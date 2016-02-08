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

package droidsafe.analyses.pta;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;
import soot.Context;
import soot.G;
import soot.Hierarchy;
import soot.MethodContext;
import soot.MethodOrMethodContext;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Type;
import soot.Value;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.spark.pag.StringConstantByMethod;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.pta.IAllocNode;

/**
 * This abstract class defines methods that an underlying points to analysis framework must implement
 * to be used by DroidSafe.
 * 
 * @author mgordon
 *
 */
public abstract class PTABridge {
    /** Logger field */
    private static final Logger logger = LoggerFactory.getLogger(PTABridge.class);
    /** Singleton for PTA bridge */
    private static PTABridge v;
    
    /** internal soot call graph */
    protected CallGraph callGraph;

    private static PointsToAnalysisPackage myPackage;
    /** options passed by caller to the underlying pta */
    protected Map<String,String> optionsInCode;
    
    public static boolean DUMP_CALL_GRAPH_NEXT_RUN = false;
    
    /** When gathering statistics, ignore methods and references of these classes or subclasses */
    public static final Set<String> STATS_IGNORE_CLASS_STRINGS = new HashSet<String>(Arrays.asList(
        "java.lang.String", 
        "java.lang.AbstractStringBuilder", 
        "java.lang.Throwable",
        "java.lang.CharSequence"));
    /** Build above as soot classes with all children before each run */
    public static Set<SootClass> STATS_IGNORE_SOOTCLASSES;
    
    public PointsToAnalysisPackage getPackage() {
        return myPackage;
    }
    
    protected PTABridge(Map<String,String> opts) {
        this.optionsInCode = opts;
    }
    
    /**
     * Perform any specific cleanup required for specific bridge
     */
    protected abstract void releaseInternal();
    
    /**
     * Reset the PTA and get it ready for another run.
     */
    public static void release() {
       if (v != null) v.releaseInternal();
        v = null;

        Scene.v().releaseCallGraph();
        Scene.v().releasePointsToAnalysis();
        Scene.v().releaseReachableMethods();
        Scene.v().releaseActiveHierarchy();
        Scene.v().releaseFastHierarchy();
        
        G.v().instance_soot_jimple_toolkits_callgraph_VirtualCalls = null;
        G.v().instance_soot_jimple_toolkits_typing_integer_ClassHierarchy = null;
        G.v().instance_soot_jimple_spark_SparkTransformer = null;
        G.v().ClassHierarchy_classHierarchyMap.clear();  
        //G.v().instance_soot_jimple_spark_fieldrw_FieldWriteTagAggregator = null;
        
        System.gc();
        System.gc();
    }
    
    /** Internal run method for implementing analysis */
    protected abstract void runInternal();
    
    /** 
     * Return true if we should ignore this class for stats gathering.
     */
    public boolean shouldIgnoreForStats(SootClass clz) {
        return STATS_IGNORE_SOOTCLASSES.contains(clz);
    }
    
    /** Run the points to analysis, if an analysis is to be added, it must be added here in the if statement */
    public static void run(PointsToAnalysisPackage pta, Map<String,String> opts) {
       STATS_IGNORE_SOOTCLASSES = new HashSet<SootClass>();
       for (String str : STATS_IGNORE_CLASS_STRINGS) {
           SootClass clz = Scene.v().getSootClass(str);
           List<SootClass> childrenInc = SootUtils.getChildrenIncluding(clz);
           for (SootClass child : childrenInc)
               STATS_IGNORE_SOOTCLASSES.add(child);
       }
            
        myPackage = pta;
        if (pta == PointsToAnalysisPackage.GEOPTA) {
            v = new GeoPTA(opts);
            v.runInternal();
        } else if (pta == PointsToAnalysisPackage.SPARK) {
            v = new SparkPTA(opts);
            v.runInternal();
        }  else
        if (pta == PointsToAnalysisPackage.PADDLE) {
            v = new PaddlePTA(opts);
            v.runInternal();
        } else {
            logger.error("Invalid points to analysis package: {}", pta);
            droidsafe.main.Main.exit(1);
        }
    }
    
    /** Return the static singleton for the pta */
    public static PTABridge v() {
        return v;
    }
    
    /** 
     * Can the first argument type be cast to the second argument type?
     */
    public abstract boolean isLegalCast(Type objType, Type refType);

    /** return the alloc node of the PAG representing the new expr */
    public abstract IAllocNode getAllocNode(Object newExpr, Context context);

    /** return the alloc node of the PAG representing the new expr */
    public abstract Set<IAllocNode> getAllocNodeIns(Object newExpr);

    
    
    /** Get all the alloc nodes of the PAG */
    public abstract Set<? extends IAllocNode> getAllAllocNodes();
    
    /** Return a list of all reachable methods based on PTA */
    public abstract Set<SootMethod> getReachableMethods() ;
    
    /** return a set of all reachable method contexts */
    public abstract Set<MethodOrMethodContext> getReachableMethodContexts();
    
    /** return all contexts the method is called under */
    public abstract Set<MethodOrMethodContext> getMethodContexts(SootMethod method);
            
    /** Return true if this given method is reachable given the last PTA run */
    public abstract boolean isReachableMethod(SootMethod method);
    
    /** Return true if this value is a pointer value that is in the PAG */
    public abstract boolean isPointer(Value val);
    
    /** Return the possible dynamic types of the pointer value */
    public abstract Set<Type> getTypesIns(Value val);
    
    /** Return the possible dynamic types of the pointer value given the context */
    public abstract Set<Type> getTypes(Value val, Context context);
    
    /** Return the possible alloc nodes that the given pointer could point to, insensitive */
    public abstract Set<? extends IAllocNode> getPTSetIns(Value val);
    
    /**
     * Query of field reference with allocnode and field. 
     */
    public abstract Set<? extends IAllocNode> getPTSet(IAllocNode node, SootField field);
    
    /** Return the possible alloc nodes that the given points to could point to given the context */
    public abstract Set<? extends IAllocNode> getPTSet(Value val, Context context);
    
    /** Return the possible alloc nodes that the given alloc node could point to, with alloc node arg an array */
    public abstract Set<? extends IAllocNode> getPTSetOfArrayElement(IAllocNode nodes);
    
  
    /** dump the pta result */
    public abstract void dumpPTA();
    
    /** dump the pta result to a file */
    public abstract void dumpPTA(String fileName);
    
    /** dump the pta result for a given context */
    public abstract void dumpPTAForContext(PrintStream file, Context sootContext);
    
    /** dump the call graph to a file */
    public abstract void dumpCallGraph(String fileStr);
    
    /** return the call graph built by the pta */
    public abstract CallGraph getCallGraph();
    
    public List<SootMethod> incomingEdgesIns(SootMethod method) {
        List<SootMethod> callingMethods = new LinkedList<SootMethod>();
        
        List<MethodOrMethodContext> momcs = new LinkedList<MethodOrMethodContext>();
      
        //find contexts
        for (MethodOrMethodContext mc : getMethodContexts(method)) {
            momcs.add(mc);
        }
        
        //find incoming methods for all contexts, ignore context
        for (MethodOrMethodContext momc : momcs) {
            Iterator<Edge> edges = callGraph.edgesInto(momc);
            while (edges.hasNext()) 
                callingMethods.add(edges.next().src());
        }
        
        return callingMethods;
    }
    
    public List<SootMethod> outgoingEdgesIns(SootMethod method) {
        List<SootMethod> calledMethods = new LinkedList<SootMethod>();              
        
        //find incoming methods for all contexts, ignore context
        for (MethodOrMethodContext momc : getMethodContexts(method)) {
            Iterator<Edge> edges = callGraph.edgesOutOf(momc);
            while (edges.hasNext()) 
                calledMethods.add(edges.next().tgt());
        }
        
        return calledMethods;
    }
    
    public Set<SootMethod> getTargetsInsNoContext(Stmt stmt) {
        return getTargetsInsNoContext(JimpleRelationships.v().getEnclosingMethod(stmt), stmt);
    }
    
    public Set<SootMethod> getTargetsInsNoContext(SootMethod enclosingMethod, Stmt stmt) {
        Set<SootMethod> ret = new LinkedHashSet<SootMethod>();
        
        for (MethodOrMethodContext momc : getMethodContexts(enclosingMethod)) {
            for (MethodOrMethodContext tgt : getTargets(momc, stmt)) {
                ret.add(tgt.method());
            }
        }
        
        return ret;
        
    }
    
    public Set<MethodOrMethodContext> getTargetsInsWithContext(SootMethod enclosingMethod, Stmt stmt) {
        Set<MethodOrMethodContext> ret = new LinkedHashSet<MethodOrMethodContext>();
        
        for (MethodOrMethodContext momc : getMethodContexts(enclosingMethod)) {
            ret.addAll(getTargets(momc, stmt));
        }
        
        return ret;
        
    }
    
    public Set<MethodOrMethodContext> getTargets(MethodOrMethodContext momc, Stmt stmt) {
        List<Edge> edges = outgoingEdges(momc, stmt);
        
        Set<MethodOrMethodContext> ret = new LinkedHashSet<MethodOrMethodContext>();
        for (Edge edge : edges) {
            ret.add(edge.getTgt());
        }
                
        return ret;
    }
    
    /** return edges out of a method/method+context that have stmt as source */
    public List<Edge> outgoingEdges(MethodOrMethodContext momc, Stmt stmt) {
        List<Edge> edges = new LinkedList<Edge>();
        
        Iterator<Edge> it = callGraph.edgesOutOf(momc);
        while (it.hasNext()) {
            Edge e = it.next();
            if (stmt.equals(e.srcStmt()))
                edges.add(e);
        }
        
        return edges;  
        
    }
    
    public Edge findEdge(MethodOrMethodContext caller, Stmt stmt, MethodOrMethodContext callee) {
        List<Edge> outgoing = outgoingEdges(caller, stmt);        
        for (Edge edge : outgoing) {
            if (callee.equals(edge.getTgt()))
                return edge;
        }
        return null;
    }
    
    /** return edges into a method/method+context */
    public List<Edge> incomingEdges(MethodOrMethodContext momc) {
        List<Edge> edges = new LinkedList<Edge>();
        
        Iterator<Edge> it = callGraph.edgesInto(momc);
        while (it.hasNext()) 
            edges.add(it.next());
        
        return edges;
    }
    
    /**
     * Is this node a string constant (with or without context)
     */
    public static boolean isStringConstant(IAllocNode node) {
        return (node.getNewExpr() instanceof StringConstantByMethod);
    }
    

    /**
     * if this node is a string constant node, then get the value of the string constant
     */
    public static String getValueOfStringConstant(IAllocNode node) {
        if (!isStringConstant(node)) {
            logger.error("Trying to get string constant value of non-string constant node: {}", node);
        }
        
        return ((StringConstantByMethod)node.getNewExpr()).getStringConstant().value;
    }
}
