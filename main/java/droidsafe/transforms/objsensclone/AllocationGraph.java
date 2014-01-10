package droidsafe.transforms.objsensclone;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Comparator;

import org.jgrapht.ext.DOTExporter;
import org.jgrapht.ext.VertexNameProvider;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedMultigraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.app.Project;
import droidsafe.utils.SootUtils;
import soot.Body;
import soot.RefType;
import soot.SootClass;
import soot.SootMethod;
import soot.jimple.AssignStmt;
import soot.jimple.NewExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.util.Chain;

public class AllocationGraph {
    /** static logger class */
    private static final Logger logger = LoggerFactory.getLogger(AllocationGraph.class);
    
    private DirectedMultigraph<SootClass, DefaultEdge> graph;
        
    public AllocationGraph() {
        graph = new DirectedMultigraph<SootClass, DefaultEdge>(DefaultEdge.class);
        buildAllocationGraph();
        exportToDot(Project.v().getOutputDir() + File.separator + 
            "allocation-graph.dot");
        
        //System.out.println("Allocation graph size: " + graph.vertexSet().size());
        
        /*
        for (SootClass clz : workList()) {
            System.out.println(clz);
        }
        
        System.out.println("*************");
        */
    }
    
    public int getInDegree(SootClass clz) {
        if (graph.containsVertex(clz))
            return graph.inDegreeOf(clz);
        return 0;
    }
    
    public int getOutDegree(SootClass clz) {
        if (graph.containsVertex(clz))
            return graph.outDegreeOf(clz);
        return 0;
    }
    
    public void removeClass(SootClass clz) {
        graph.removeVertex(clz);
    }
    
    public void updateAllocationGraph(SootMethod method) {
        if (method.isAbstract() || !method.isConcrete())
            return;

        SootClass enclosingClass = method.getDeclaringClass();

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
                    //is exception?
                    if (!SootUtils.isSubTypeOfIncluding(RefType.v(newClass), RefType.v("java.lang.Throwable"))) {
                        graph.addVertex(enclosingClass);
                        graph.addVertex(newClass);
                        graph.addEdge(enclosingClass, newClass);
                    }
                }
            }
        }
    }
    
    private  void buildAllocationGraph() {
        SootMethod[] methods = PTABridge.v().getAllReachableMethods().toArray(new SootMethod[0]);

        for (SootMethod method : methods) {
          updateAllocationGraph(method);  
        }
    }

    public List<SootClass> workList() {
        List<SootClass> trav = new LinkedList<SootClass>();
        
        List<SootClass> unvisited = new LinkedList<SootClass>();
        unvisited.addAll(graph.vertexSet());
        Collections.sort(unvisited, new SootClassComparator());
        
        //remove all classes with zero incoming from the graph
        for (SootClass clz : graph.vertexSet()) {
            if (graph.inDegreeOf(clz) == 0)
                unvisited.remove(clz);
        }
        
        while (!unvisited.isEmpty()) {
            //find vertex with min number of incoming unvisited
            int min = Integer.MAX_VALUE;
            SootClass minVertex = null;
            
            for (SootClass clz : unvisited) {
                int incomingUnvisited = 0;
                for (DefaultEdge inEdge : graph.incomingEdgesOf(clz)) {
                    if (unvisited.contains(graph.getEdgeSource(inEdge)))
                        incomingUnvisited++;
                }
                
                //here we have a count of unvisited incoming
                //short circuit zero case
                if (incomingUnvisited == 0) {
                    minVertex = clz;
                    min = 0;
                    break;
                } else if (incomingUnvisited < min) {
                    min = incomingUnvisited;
                    minVertex = clz;
                }
            }
            
            //at this point we have a clz with min number of incoming uncloned
            unvisited.remove(minVertex);
            trav.add(minVertex);
        }
        
        return trav;
    }
    
    public List<SootClass> breadthFirst() {
        List<SootClass> trav = new LinkedList<SootClass>();
        
        BreadthFirstIterator<SootClass, DefaultEdge> bf = 
                new BreadthFirstIterator<SootClass, DefaultEdge>(graph);

        while (bf.hasNext()) {
            trav.add(bf.next());
        }
        
        System.out.println("BFS traversal size: " + trav.size());
        
        return trav;
    }

    public void exportToDot(String filename) {
        DOTExporter<SootClass, DefaultEdge> dotE = new DOTExporter<SootClass, DefaultEdge>(
                new VertexNameProvider<SootClass>() {
                    @Override
                    public String getVertexName(SootClass arg0) {
                        return arg0.hashCode() + "";
                    }
                }, 
                new VertexNameProvider<SootClass>() {
                    @Override
                    public String getVertexName(SootClass arg0) {
                        return arg0.getName();
                    }
                },
                null);
                
        try {
            dotE.export(new FileWriter(filename), graph);
        } catch (IOException e) {
            logger.error("Error writing allocation graph dot file!");
            droidsafe.main.Main.exit(1);
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
