/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

package droidsafe.analyses.allocationgraph;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Comparator;

import org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION;
import org.jgrapht.ext.DOTExporter;
import org.jgrapht.ext.VertexNameProvider;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedMultigraph;
import org.jgrapht.graph.DirectedWeightedMultigraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.main.Config;
import droidsafe.utils.MutableInt;
import droidsafe.utils.SootUtils;
import soot.Body;
import soot.Local;
import soot.RefLikeType;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Unit;
import soot.Value;
import soot.ValueBox;
import soot.jimple.AssignStmt;
import soot.jimple.NewArrayExpr;
import soot.jimple.NewExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.StringConstant;
import soot.jimple.toolkits.callgraph.Edge;
import soot.options.Options;
import soot.util.Chain;

/**
 * A graph representing the allocation of a program.  Nodes are classes, and an edge from 
 * A->B denotes that class A creates a class B.  
 * 
 * The graph is used to clone classes in a particular order and introduce object sensitivity.
 * 
 * There are a few different methods that calculate different orderings for cloning.
 * 
 * @author mgordon
 *
 */
public class AllocationGraph {
	/** static logger class */
	private static final Logger logger = LoggerFactory.getLogger(AllocationGraph.class);
	/** map of soot class to the new expressions in reachable code that allocates the class */
	private Map<SootClass, Set<NewExpr>> classToNewExprs;
	/** map of class to number of new array expressions in reachable methods */    
	private Map<SootClass, MutableInt> reachableNewArrayExprs;
	/** map of class to string constants in reachable methods */    
	private Map<SootClass, Set<String>> reachableStringConsts;
	private Map<SootClass, Long> complexityMap;

	/* Graph Structures */
	Set<SootClass> vertices;
	Map<AllocGraphEdge, AllocGraphEdge> edges;	
	Map<SootClass, Set<AllocGraphEdge>> incomingEdges;
	Map<SootClass, Set<AllocGraphEdge>> outgoingEdges;

	private static AllocationGraph v;

	public static AllocationGraph v() {		
		return v;
	}

	public static void update() {
		v = new AllocationGraph();
	}

	/**
	 * Create an allocation graph based on the current classes in the scene.
	 */
	public AllocationGraph() {
		vertices = new HashSet<SootClass>();
		edges = new HashMap<AllocGraphEdge,AllocGraphEdge>();
		incomingEdges = new HashMap<SootClass,Set<AllocGraphEdge>>();
		outgoingEdges = new HashMap<SootClass,Set<AllocGraphEdge>>();

		classToNewExprs = new HashMap<SootClass, Set<NewExpr>>();
		reachableNewArrayExprs = new HashMap<SootClass, MutableInt>();
		reachableStringConsts = new HashMap<SootClass, Set<String>>();
		complexityMap = new HashMap<SootClass, Long>();

		buildAllocationGraph();
		createComplexityMap();


		/*exportToDot(Project.v().getOutputDir() + File.separator + 
            "allocation-graph.dot");*/

		//System.out.println("Allocation graph size: " + graph.vertexSet().size());

		/*
        for (SootClass clz : workList()) {
            System.out.println(clz);
        }

        System.out.println("*************");
		 */
	}

	/**
	 * @return The total complexity of all classes.
	 */
	public long getTotalComplexity() {
		long total = 0;

		for (Map.Entry<SootClass, Long> entry : complexityMap.entrySet()) {
			total += entry.getValue();
		}

		return total;
	}

	private int getArrayAndStringConstComplexity(SootClass clz) {
		return (reachableStringConsts.get(clz) == null ? 0 :
			reachableStringConsts.get(clz).size()) +
				(reachableNewArrayExprs.get(clz) == null ? 0 :
					reachableNewArrayExprs.get(clz).value());

	}

	private long calcNumberOfContexts(SootClass current, int distanceFromStart, int k) {
		if (distanceFromStart == k) 
			return 1;

		if (distanceFromStart > k) {
			throw new RuntimeException("Should never happen");
		}		

		long sum = 0;

		for (AllocGraphEdge edge : incomingEdges.get(current)) {

			sum += edge.getStaticWeight();

			//non-static edge
			//call recursively on parent
			//System.out.println("Virtual " + edge + " " + graph.getEdgeWeight(edge));
			sum += (calcNumberOfContexts(edge.getEnclosing(), distanceFromStart + 1, k) * edge.getVirtualWeight());			
		}

		//account for entry points, with no incoming edges		
		if (sum == 0)
			sum = 1;

		return sum;
	}

	private long calcComplexity(SootClass clz) {
		long numContexts = calcNumberOfContexts(clz, 0, Config.v().kobjsens);
		/*
		int instanceRefFields = 0;
		//maybe multiply by reference instance fields + local fields
		for (SootField field : clz.getFields()) {
			if (!field.isStatic() && field.getType() instanceof RefLikeType) {
				instanceRefFields++;
			}
		}

		int refLocals = 0;
		try {
			for (SootMethod method : clz.getMethods()) {
				if (!method.isStatic() && PTABridge.v().isReachableMethod(method)) {
					for (Local local : method.retrieveActiveBody().getLocals()) {
						if (local.getType() instanceof RefLikeType)
							refLocals++;
					}
				}
			} 
		} catch (Exception e) {
			//ignore issue with body
		}

		 */

		//long singleContextComplexity = (reachableNewArrayExprs.get(clz) == null ? 0 :
		//	reachableNewArrayExprs.get(clz).value());  

		return numContexts;// * (singleContextComplexity == 0 ? 1 : singleContextComplexity);
	}


	public Long getComplexity(SootClass clz) {
		return complexityMap.get(clz);
	}

	public Map<SootClass, Long> getComplexityMap() {
		return complexityMap;
	}

	private void createComplexityMap() {
		for (SootClass clz : vertices) {
			complexityMap.put(clz, calcComplexity(clz));                
		}
	}

	public long estimtateMethodContexts() {
		long sum = 0;

		for (SootClass clz : vertices) {
			Long targetComp = complexityMap.containsKey(clz) ? complexityMap.get(clz) : (long) 1;
			
			for (SootMethod method : clz.getMethods()) {
				if (!PTABridge.v().isReachableMethod(method))
					continue;

				

				Set<SootMethod> callingMethods = new HashSet<SootMethod>();
				for (Edge edge : PTABridge.v().incomingEdges(method)) {
					callingMethods.add(edge.src());
				}
					
				for (SootMethod callingMethod : callingMethods) {
					SootClass sourceClass = callingMethod.getDeclaringClass();
					Long sourceComp = complexityMap.containsKey(sourceClass) ? complexityMap.get(sourceClass) : (long) 1;

					sum += (sourceComp * targetComp);
				}
			}

		}
		return sum;
	}

	public void dumpComplexity() {
		try (FileWriter fw = new FileWriter(Project.v().getOutputDir() + File.separator + "alloc-complexity.csv")){
			for (SootClass clz : vertices) {
				fw.write(clz + "," + complexityMap.get(clz) + "\n");                
			}

		} catch (IOException e) {

		}
	}

	private void recordAllocation(SootClass enclosing, SootClass allocated, boolean isStatic) {
		if (vertices.add(enclosing)) {
			//vertex did not exist
			incomingEdges.put(enclosing, new HashSet<AllocGraphEdge>());
			outgoingEdges.put(enclosing, new HashSet<AllocGraphEdge>());
		}

		if (vertices.add(allocated)) {
			//vertex did not exist
			incomingEdges.put(allocated, new HashSet<AllocGraphEdge>());
			outgoingEdges.put(allocated, new HashSet<AllocGraphEdge>());
		}

		AllocGraphEdge probe = new AllocGraphEdge(enclosing, allocated);
		if (!edges.containsKey(probe)) {
			edges.put(probe, probe);						
			incomingEdges.get(allocated).add(probe);
			outgoingEdges.get(enclosing).add(probe);
		}

		AllocGraphEdge edge = edges.get(probe);

		if (isStatic)
			edge.incrementStaticWeight();
		else 
			edge.incrementVirtualWeight();			

	}

	private void updateAllocationGraph(SootMethod method) {
		if (method.isAbstract() || !method.isConcrete())
			return;

		SootClass enclosingClass = method.getDeclaringClass();

		boolean debug = ("<com.example.android.apis.content.PickContact: void onCreate(android.os.Bundle)>".equals(method.getSignature()));

		Body body = method.getActiveBody();
		StmtBody stmtBody = (StmtBody)body;
		Chain units = stmtBody.getUnits();
		Iterator stmtIt = units.snapshotIterator();

		while (stmtIt.hasNext()) {
			Stmt stmt = (Stmt)stmtIt.next();

			if (stmt instanceof AssignStmt) {
				AssignStmt assign = (AssignStmt) stmt;
				if (assign.getRightOp() instanceof NewExpr) {
					NewExpr newExpr = (NewExpr)assign.getRightOp();
					SootClass newClass = newExpr.getBaseType().getSootClass();
					recordAllocation(enclosingClass, newClass, method.isStatic());

					if (!classToNewExprs.containsKey(newClass)) 
						classToNewExprs.put(newClass, new HashSet<NewExpr>());
					classToNewExprs.get(newClass).add(newExpr);

				} else if (assign.getRightOp() instanceof NewArrayExpr) {
					//count new array exprs
					MutableInt count = reachableNewArrayExprs.get(enclosingClass);
					if (count == null) {
						reachableNewArrayExprs.put(enclosingClass, new MutableInt());
					}
					else {
						count.increment();
					}                                     
				}
			}

			//record string constants
			for (ValueBox vb : stmt.getUseAndDefBoxes()) {
				Value v = vb.getValue();
				if (v instanceof StringConstant) {
					if (!reachableStringConsts.containsKey(enclosingClass)) {
						reachableStringConsts.put(enclosingClass, new HashSet<String>());
					}
					reachableStringConsts.get(enclosingClass).add(((StringConstant)v).value);
				}
			}
		}
	}

	public Set<NewExpr> getNewExprsForClass(SootClass clz) {
		if (!classToNewExprs.containsKey(clz))
			return Collections.emptySet();
		return classToNewExprs.get(clz);
	}

	private  void buildAllocationGraph() {
		SootMethod[] methods = PTABridge.v().getReachableMethods().toArray(new SootMethod[0]);

		for (SootMethod method : methods) {
			updateAllocationGraph(method);  
		}
	}


	/**
	 * Compare soot classes based on their name.
	 * @author mgordon
	 *
	 */
	public class SootClassComparator implements Comparator<SootClass> {

		@Override
		public int compare(SootClass o1, SootClass o2) {
			return o1.getName().compareTo(o2.getName());
		}

	}
}
