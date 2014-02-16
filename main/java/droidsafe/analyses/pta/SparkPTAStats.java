package droidsafe.analyses.pta;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Local;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Value;
import soot.ValueBox;
import soot.jimple.InstanceFieldRef;
import soot.jimple.NewExpr;
import soot.jimple.StaticFieldRef;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.spark.pag.ClassConstantNode;
import soot.jimple.spark.pag.StringConstantNode;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.pta.IAllocNode;
import soot.toolkits.scalar.Pair;
import droidsafe.android.app.Project;
import droidsafe.main.Config;
import droidsafe.transforms.objsensclone.AllocationGraph;
import droidsafe.transforms.objsensclone.ClonedContextTranslator;
import droidsafe.transforms.objsensclone.ObjectSensitivityCloner;

public class SparkPTAStats {
    /** Logger field */
    private static final Logger logger = LoggerFactory.getLogger(SparkPTAStats.class);
    private static FileWriter fw;
    private ClonedContextTranslator cTrans;
    private PTABridge pta;
    private AllocationGraph graph;

    public SparkPTAStats() {
        cTrans = new ClonedContextTranslator();
        graph = new AllocationGraph();
        pta = PTABridge.v();
    }

    /**
     * Work in progress!
     */
    public void writeStats() {
        if (!Config.v().statsRun)
            return;


        

        try {

            if (fw == null)
                fw = new FileWriter(Project.v().getOutputDir() + File.separator +"spark-stats.txt");

            fw.write("\n=====================================================\n");
            fw.write("Obj sens: " + ObjectSensitivityCloner.v().hasRun + "\n");

            ObjectSensitivityCloner osc = ObjectSensitivityCloner.v();

            long PTSets = 0;
            long PTSetSize = 0;
            long collapsedReachable = 0;

            long queriedContextObjects = 0;
            long totalContextObjects = 0;


            //loop through all non-cloned methods, look for clones
            //gather stats?

            //loop through all non-cloned classes
            for (SootClass clz : Scene.v().getClasses()) {

                //we are basing everything on the original code, so only 
                //look at original classes, and then translate context
                if (ObjectSensitivityCloner.v().isClonedClass(clz) || pta.shouldIgnoreForStats(clz))
                    continue;



                for (SootMethod method : clz.getMethods()) {
                    //don't look at cloned method in original classes!
                    if (ObjectSensitivityCloner.v().isClonedMethod(method))
                        continue;

                    //System.out.println("Here: " + method);    

                    boolean reachable = false;

                    //the orignal method is reachable if it is reachable or any of its clones
                    if (pta.isReachableMethod(method)) {
                        reachable = true;
                    }

                    if (!reachable) {
                        for (SootMethod cloneC : ObjectSensitivityCloner.v().getClonedContextMethods(method)) {
                            if (pta.isReachableMethod(cloneC)) {
                                reachable = true;
                                break;
                            }
                        }
                    }

                    if (!reachable)
                        continue;

                    //System.out.println("Here2: " + method);    

                    collapsedReachable++;

                    if (method.isAbstract() || !method.isConcrete() || method.isPhantom())
                        continue;

                    //loop over values of orig, if value is a pointer, then query pta
                    Map<Value, Set<Value>> contextVals = cTrans.getValueMap(method, pta.isReachableMethod(method));

                    List<ValueBox> origVBs = method.retrieveActiveBody().getUseAndDefBoxes();

                    //System.out.println("Here3: " + method);    

                    for (ValueBox vb : origVBs) {
                        Value value = vb.getValue();

                        //ignore pointer of a specific type
                        if (value.getType() instanceof RefType && 
                                pta.shouldIgnoreForStats(((RefType)value.getType()).getSootClass()))
                            continue;

                        if (value instanceof Local ||
                                value instanceof StaticFieldRef ||
                                value instanceof InstanceFieldRef) {

                            Set<Value> insensSet = new HashSet<Value>();


                            for (Value contextVal : contextVals.get(value)) {

                                Set<IAllocNode> possibleContextNodes = new HashSet<IAllocNode>();
                                Set<IAllocNode> queriedContextNodes = new HashSet<IAllocNode>();
                                
                                Set<AllocNode> allocNodes = (Set<AllocNode>)pta.getPTSet(contextVal);

                                for (AllocNode an : allocNodes) {
                                    //System.out.println("Here4: " + an);    
                                    //ignore allocnodes of ignore types
                                    if (an.getType() instanceof RefType &&
                                            pta.shouldIgnoreForStats(((RefType)an.getType()).getSootClass()))
                                        continue;

                                    Value newExpr = null;
                                    if (an.getNewExpr() instanceof Value) {
                                        newExpr = (Value)an.getNewExpr();
                                    } else if (an.getNewExpr() instanceof Pair) {
                                        if (((Pair)an.getNewExpr()).getO1() instanceof Value)
                                            newExpr = (Value)((Pair)an.getNewExpr()).getO1();
                                    } else {
                                        logger.info("Unknown new expression type: {} {}", 
                                            an.getNewExpr(), an.getNewExpr().getClass());
                                    }

                                    //System.out.println("Here5: " + an);    

                                    if (an instanceof ClassConstantNode || an instanceof StringConstantNode)
                                        continue;
                                    
                                    if (cTrans.isClonedNewExpr(newExpr)) {
                                        insensSet.add(cTrans.getOrigNewExpr(newExpr));
                                    } else {
                                        insensSet.add(newExpr);
                                    }

                                                                        
                                    //don't do the following for non ref types
                                    if (! (an.getType() instanceof RefType)) 
                                        continue;

                                    SootClass clazz = ((RefType)an.getType()).getSootClass();
                                    queriedContextNodes.add(an);

                                    if (ObjectSensitivityCloner.v().hasRun) {
                                        SootClass origClass = clazz;

                                        if (ObjectSensitivityCloner.v().isClonedClass(clazz)) {
                                            origClass = ObjectSensitivityCloner.v().getOriginalClass(clazz);
                                        }

                                        Set<SootClass> clonedClasses = ObjectSensitivityCloner.v().getClonedClasses(origClass);
                                        if (clonedClasses.isEmpty())
                                            possibleContextNodes.addAll(getAllocNodesOfClass(clazz));
                                        else {
                                            for (SootClass clonedClz : clonedClasses) {
                                                possibleContextNodes.addAll(getAllocNodesOfClass(clonedClz));
                                            }
                                        }
                                    } else {

                                        //no object sens
                                        Set<IAllocNode> nodes = getAllocNodesOfClass(clazz);
                                        //System.out.println(Arrays.toString(nodes.toArray()));
                                        possibleContextNodes.addAll(nodes);
                                    }
                                }
                                
                                if (queriedContextNodes.size() > possibleContextNodes.size()) {
                                    /*
                                    System.out.println("-------------------------");
                                    System.out.println(Arrays.toString(queriedContextNodes.toArray()));
                                    System.out.println("----");
                                    System.out.println(Arrays.toString(possibleContextNodes.toArray()));
                                    System.out.println("-------------------------");
                                    */
                                }
                                totalContextObjects += possibleContextNodes.size();
                                queriedContextObjects += queriedContextNodes.size();
                            }

                            PTSets++;
                            PTSetSize += insensSet.size();
                            
                            
                        }
                    }

                    //virtual calls (how to account for cloning?)

                    //total polymorphic calls (how to account for cloning?)

                    //reachable casts

                    //somehow build call graph??

                    //total casts that may fail

                }
            }

            //raw call graph
            fw.write("Raw reachable methods: " + pta.getReachableMethods().size() + "\n");
            fw.write("Raw call graph edges: " + pta.getCallGraph().size() + "\n");

            fw.write("Collapsed Reachable Methods: " + collapsedReachable + "\n");

            fw.write("Average method context size: " + 
                    ((double)pta.getReachableMethods().size()) / ((double)collapsedReachable) + "\n");

            //cloning removed call graph

            fw.write("Average points to set size: " + ((double)PTSetSize)/((double)PTSets) + "\n");

            fw.write("Context Objects Reduction: " + 
                    ((double)queriedContextObjects) / ((double)totalContextObjects) + "\n");


            fw.write(graph.getGraphStats() + "\n");

            /*
            fw.write("virtual call sites: " + virtualCallSites + "\n");
            fw.write("polymorphic call sites: " + polyCallSites + "\n");
            fw.write("Casts: " + casts + "\n");
            fw.write("Casts that may fail: " + castsMayFail + "\n");
             */
            fw.flush();
        } catch (IOException e) {
            logger.error("Error writing stats file", e);
            droidsafe.main.Main.exit(1);

        }
    }

    
    private Set<IAllocNode> getAllocNodesOfClass(SootClass clz) {
        return null;
        /*
        Set<NewExpr> newExprs = graph.getNewExprsForClass(clz);
        
        Set<IAllocNode> nodes = new HashSet<IAllocNode>();
        for (NewExpr newE : newExprs) {
            nodes.add(pta.getAllocNode(newE));
        }
        return nodes;
        */
    }
    
}
