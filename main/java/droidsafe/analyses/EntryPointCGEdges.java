package droidsafe.analyses;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import soot.Scene;
import soot.SootClass;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.util.queue.QueueReader;
import droidsafe.analyses.pta.ContextType;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.pta.PTAContext;
import droidsafe.analyses.rcfg.RCFGNode;
import droidsafe.android.app.Project;

/**
 * This analysis will create a set of all edges in the call graph that define
 * entry points into the application.  It must be run after pta is run.
 * 
 * @author mgordon
 *
 */
public class EntryPointCGEdges {
    
    /** the set of entry point edges into usr code */
    private Set<Edge> entryPointEdges;

    /** singleton analysis object */
    protected static EntryPointCGEdges v;
    
    /**
     * Return the singleton analysis object. 
     */
    public static EntryPointCGEdges v() {
        if (v == null) {
            v = new EntryPointCGEdges();
        }
        
        return v;
    }

    /**
     * Return the set of entry point edges as defined by this analysis.
     */
    public Set<Edge> getEntryPoints() {
        return Collections.unmodifiableSet(entryPointEdges);
    }
    
    /**
     * Return true if the given edge is an entry point as defined by this analysis.
     */
    public boolean isEntryPoint(Edge e) {
        return entryPointEdges.contains(e);
    }
    
    /**
     * Create the set and generate the set of entry point edges.
     */
    private EntryPointCGEdges() {
        entryPointEdges = new LinkedHashSet<Edge>();
        init();
        /*
        dumpEdges();        
        checkPTA();
        */
    }
    
    /**
     * Create the set of entry point edges.
     */
    private void init() {
        CallGraph sparkCG = Scene.v().getCallGraph();
                
        //iterate over all edges to find entry points for rcfg
        //these entry points are edges from harness to user code
        //or edges from api call to user code
        QueueReader<Edge> edges = sparkCG.listener();
        while (edges.hasNext()) {
            Edge e = edges.next();
            SootClass sourceClz = e.src().getDeclaringClass();
            SootClass tgtClz = e.tgt().getDeclaringClass();
            
            //if the edge goes from an non-src, non lib class to a src or lib class
            //then it is an entry point
            if (!(Project.v().isSrcClass(sourceClz) || Project.v().isLibClass(sourceClz)) &&
                    (Project.v().isSrcClass(tgtClz) || Project.v().isLibClass(tgtClz))) {
                entryPointEdges.add(e);
            }
        }
    }
    
    /**
     * Print the pta results for each context (entry point edge) we find.
     */
    private void checkPTA()  {
        for (Edge e : entryPointEdges) {
            PTAContext context = new PTAContext(ContextType.EVENT_CONTEXT, e);
            PTABridge.v().dumpPTAForContext(System.out, context);
        }
    }
    
    /**
     * Dump the edges we found as entry points to standard out.
     */
    public void dumpEdges() {
        for (Edge e : entryPointEdges) {
            System.out.println(e);
        }
    }
}
