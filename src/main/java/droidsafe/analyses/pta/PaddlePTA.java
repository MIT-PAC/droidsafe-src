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
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.AnySubType;
import soot.ArrayType;
import soot.Context;
import soot.Local;
import soot.MethodOrMethodContext;
import soot.PackManager;
import soot.PointsToSet;
import soot.RefLikeType;
import soot.RefType;
import soot.Scene;
import soot.SootBridge;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Type;
import soot.Value;
import soot.ValueBox;
import soot.jimple.ArrayRef;
import soot.jimple.DynamicInvokeExpr;
import soot.jimple.InstanceFieldRef;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InterfaceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.NewMultiArrayExpr;
import soot.jimple.NullConstant;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.StaticFieldRef;
import soot.jimple.StaticInvokeExpr;
import soot.jimple.VirtualInvokeExpr;
import soot.jimple.paddle.AbsP2Sets;
import soot.jimple.paddle.AbsPointsToAnalysis;
import soot.jimple.paddle.AbsReachableMethods;
import soot.jimple.paddle.AllocDotField;
import soot.jimple.paddle.AllocNode;
import soot.jimple.paddle.ContextAllocDotField;
import soot.jimple.paddle.ContextAllocNode;
import soot.jimple.paddle.Node;
import soot.jimple.paddle.NodeManager;
import soot.jimple.paddle.P2SetVisitor;
import soot.jimple.paddle.PaddleNumberers;
import soot.jimple.paddle.PaddleScene;
import soot.jimple.paddle.PointsToSetReadOnly;
import soot.jimple.paddle.Results;
import soot.jimple.paddle.VarNode;
import soot.jimple.paddle.queue.Rctxt_method;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.pta.IAllocNode;
import soot.toolkits.scalar.Pair;
import soot.util.queue.QueueReader;

import com.google.common.collect.HashBiMap;

import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.SootUtils;

public class PaddlePTA extends PTABridge {
    /** Logger field */
    private static final Logger logger = LoggerFactory.getLogger(PaddlePTA.class);
    /** bimap of new expressions to their alloc node representation */
    private HashBiMap<Object, AllocNode> newToAllocNodeMap;
    /** underlying pta */
    private AbsPointsToAnalysis ptsProvider;
    /** Maps each reachable method to the contexts in which the method is reached. */
    public Map<SootMethod, Set<Context>> reachableMethodContextMap = null;

    /**
     * Computes 'reachableMethodContextMap' which maps each reachable method to the set of
     * contexts in which it is reachable.
     */
    public void computeReachableMethodContextMap() {
        if (reachableMethodContextMap == null) {
            reachableMethodContextMap = new HashMap<SootMethod, Set<Context>>();
            AbsReachableMethods rc = Results.v().reachableMethods();
            Rctxt_method ctxtMethods = rc.contextMethods();
            Iterator iter = ctxtMethods.iterator();
            while (iter.hasNext()) {
                Rctxt_method.Tuple t = (Rctxt_method.Tuple)iter.next();
                Context ctxt = t.ctxt();
                SootMethod method = t.method();
                Set<Context> ctxts = reachableMethodContextMap.get(method);
                if (ctxts == null) {
                    ctxts = new HashSet();
                    reachableMethodContextMap.put(method, ctxts);
                } 
                ctxts.add(ctxt);
            }
        }
    }


    public PaddlePTA(Map<String,String> opts) {
        super(opts);
        // TODO Auto-generated constructor stub
    }

    public CallGraph getCallGraph() {
        //what to return at this point? maybe paddle has its own call graph or can translate the soot call graph
        return null;
    }

    @Override
    protected void releaseInternal() {
        Scene.v().releaseFastHierarchy();
        Scene.v().releaseActiveHierarchy();
        SootBridge.releaseContextNumberer();
    }

    @Override
    protected void runInternal() {

        Scene.v().loadDynamicClasses();

        setPaddlePointsToAnalysis();

        ptsProvider = (AbsPointsToAnalysis)Scene.v().getPointsToAnalysis();

        computeReachableMethodContextMap();
        
        createNewToAllocMap();
        
        System.out.println("Size of reachable methods: " + reachableMethodContextMap.keySet().size());
        System.out.println("Alloc Nodes: " + newToAllocNodeMap.size());

        printStats();
    }

    private void printStats() {
        long PTSets = 0;
        long PTSetSize = 0;
        
        Set<Context> contexts = new HashSet<Context>();
        
        for (SootMethod method : reachableMethodContextMap.keySet()) {
        
            contexts.addAll(reachableMethodContextMap.get(method));
            
            if (shouldIgnoreForStats(method.getDeclaringClass()))
                continue;
            
            if (method.isAbstract() || !method.isConcrete() || method.isPhantom())
                continue;

            List<ValueBox> origVBs = null;
            try {
            	origVBs = method.retrieveActiveBody().getUseAndDefBoxes();
            }
            catch (Exception ex) {
            	logger.info("Exception retrieving method body {}", ex);
            	continue;
            }

            for (ValueBox vb : origVBs) {
                Value value = vb.getValue();

                //ignore pointer of a specific type
                if (value.getType() instanceof RefType && 
                        this.shouldIgnoreForStats(((RefType)value.getType()).getSootClass()))
                    continue;

                if (value instanceof Local ||
                        value instanceof StaticFieldRef ||
                        value instanceof InstanceFieldRef) {
                    Set<IAllocNode> nodes = (Set<IAllocNode>) getPTSetIns(value);

                    int ignoreSize = 0;
                    for (IAllocNode an : nodes) {
                        //reduce size by one for each allocation of a type we are not tracking...
                        if (an.getType() instanceof RefType &&
                                this.shouldIgnoreForStats(((RefType)an.getType()).getSootClass())) {
                            ignoreSize++;
                        }

                    }
                    PTSets++;
                    PTSetSize += (nodes.size() - ignoreSize);
                }
            }

        }

        System.out.println("Average method context size: " +
                ((double)contexts.size()) / ((double)reachableMethodContextMap.keySet().size()));
        System.out.println("Average points to set size: " + ((double)PTSetSize)/((double)PTSets) );


        /*
        for (SootMethod method : reachableMethodContextMap.keySet()) {
            //loop through instructions
            Local local = null;

            //for any reference value perform the pta query
            for (Context ctxt : reachableMethodContextMap.get(method)) {
                PointsToSetReadOnly pts = (PointsToSetReadOnly)ptsProvider.reachingObjects(ctxt, local);
                //visit internal points to set and grab all allocnodes

                int size = pts.size();
                pts.forall(new P2SetVisitor() {
                    public void visit(ContextAllocNode n) {
                        //
                    }
                });

            }
        }
         */
    }

    private void setPaddlePointsToAnalysis() {
        logger.info("[paddle] Starting analysis ...");
        HashMap<String, String> opt = new HashMap<String, String>();

        soot.options.Options.v().setPhaseOption("cg.paddle","enabled:true");
        soot.options.Options.v().setPhaseOption("cg.paddle","verbose:false");
        soot.options.Options.v().setPhaseOption("cg.paddle","bdd:false");
        soot.options.Options.v().setPhaseOption("cg.paddle","backend:none");
        soot.options.Options.v().setPhaseOption("cg.paddle","context:kobjsens");
        soot.options.Options.v().setPhaseOption("cg.paddle","k:2");
        soot.options.Options.v().setPhaseOption("cg.paddle","propagator:auto");
        soot.options.Options.v().setPhaseOption("cg.paddle","conf:ofcg");
        soot.options.Options.v().setPhaseOption("cg.paddle","order:32");
        soot.options.Options.v().setPhaseOption("cg.paddle","q:auto");
        soot.options.Options.v().setPhaseOption("cg.paddle","set-impl:double");
        soot.options.Options.v().setPhaseOption("cg.paddle","double-set-old:hybrid");
        soot.options.Options.v().setPhaseOption("cg.paddle","double-set-new:hybrid");
        soot.options.Options.v().setPhaseOption("cg.paddle","pre-jimplify:false");

        //handle strings with more precision
        soot.options.Options.v().setPhaseOption("cg.paddle", "merge-stringbuffer:false");
        soot.options.Options.v().setPhaseOption("cg.paddle", "string-constants:true");

        //object sensitive heap?
        soot.options.Options.v().setPhaseOption("cg.paddle", "context-heap:false");

        PackManager.v().getPack("cg").apply();
    }

    /**
     * Create the bi map of NewExpr <-> AllocNode
     */
    private void createNewToAllocMap() {
        newToAllocNodeMap = HashBiMap.create();
        Iterator iter = PaddleNumberers.v().allocNodeNumberer().iterator();
        while(iter.hasNext()) {
            AllocNode node = (AllocNode) iter.next();
            newToAllocNodeMap.put(node.getNewExpr(), node);
        }
    }

    @Override
    public boolean isLegalCast(Type objType, Type refType) {
        return PaddleScene.v().tm.castNeverFails(objType, refType);
    }
    
    public Set<IAllocNode> getAllocNodeIns(Object newExpr) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Given a new expression (Jimple NewExpr or String) return the corresponding AllocNode.
     */
    public IAllocNode getAllocNode(Object newExpr, Context context) {
        if (newExpr instanceof NewMultiArrayExpr) {
            NewMultiArrayExpr newArr = (NewMultiArrayExpr)newExpr;
            ArrayType type = (ArrayType)newArr.getType();
            Integer i = type.numDimensions;
            Pair pair = new Pair(newArr, i);
            return (IAllocNode) newToAllocNodeMap.get(pair);
        } else
            return (IAllocNode) newToAllocNodeMap.get(newExpr);
    }
    
    public Set<MethodOrMethodContext> getMethodContexts(SootMethod method) {
        logger.error("Not implemented");
        return null;
    }
    

    /**
     * Return a set of all allocnodes in the program.
     */
    public Set<? extends IAllocNode> getAllAllocNodes() {
        Set<AllocNode> nodes = Collections.unmodifiableSet(newToAllocNodeMap.values());
        return (Set<? extends IAllocNode>) nodes;
    }

    /**
     * Given a Spark AllocNode return the corresponding new expression (Jimple NewExpr or String) 
     */
    public Object getNewExpr(IAllocNode an) {
        return newToAllocNodeMap.inverse().get(an);
    }

    @Override
    public Set<SootMethod> getReachableMethods() {
        return reachableMethodContextMap.keySet();
    }
    
    @Override
    public Set<MethodOrMethodContext> getReachableMethodContexts() {
       return null;
    }

    @Override
    public boolean isReachableMethod(SootMethod method) {
        return reachableMethodContextMap.keySet().contains(method);
    }

    /**
     * Return true if this value is a pointer that is represented in the 
     * PTA graph.
     */
    public boolean isPointer(Value val) {
        if (!(val.getType() instanceof RefLikeType)) 
            return false;

        //now see if it is tracked by the PTA
        if (getInternalNode(val) != null) 
            return true;

        return false;
    }

    /**
     * Return the node representation for the value (local, fieldref, or array ref)
     * in the pointer assignment graph.  
     */
    private Node getInternalNode(Value val) {
        NodeManager nodeManager = PaddleScene.v().nodeManager();
        Node node = null;

        if (val instanceof Local) {
            node = nodeManager.findLocalVarNode((Local)val);
        } else if (val instanceof InstanceFieldRef) {
            node = nodeManager.findLocalVarNode((Local) ((InstanceFieldRef)val).getBase());    
        } else if (val instanceof StaticFieldRef) {
            SootField field = ((StaticFieldRef)val).getField();
            node = nodeManager.findGlobalVarNode(field); 
        } else if (val instanceof ArrayRef) {
            ArrayRef arf = (ArrayRef) val;
            node = nodeManager.findLocalVarNode((Local) arf.getBase());
        }

        return node;
    }

    @Override
    public Set<Type> getTypesIns(Value val) {
        Set<Type> types = new LinkedHashSet<Type>();

        for (IAllocNode node : getPTSetIns(val)) {
            types.add(node.getType());
        }

        return types;
    }

    @Override
    public Set<Type> getTypes(Value val, Context context) {
        Set<Type> types = new LinkedHashSet<Type>();

        for (IAllocNode node : getPTSet(val, context)) {
            types.add(node.getType());
        }

        return types;
    }

    @Override
    public Set<? extends IAllocNode> getPTSetIns(Value val) {
        final Set<AllocNode> allocNodes = new HashSet<AllocNode>();
        PointsToSetReadOnly pts = null;

        try {
            if (val instanceof InstanceFieldRef) {
                final InstanceFieldRef ifr = (InstanceFieldRef)val;
                pts = (PointsToSetReadOnly)ptsProvider.reachingObjects((Local)ifr.getBase(), ifr.getField());
            } else if (val instanceof ArrayRef) {
                ArrayRef arrayRef = (ArrayRef)val;
                pts = (PointsToSetReadOnly)ptsProvider.reachingObjectsOfArrayElement
                        (ptsProvider.reachingObjects((Local)arrayRef.getBase()));
            } else if (val instanceof Local){            
                pts = (PointsToSetReadOnly)ptsProvider.reachingObjects((Local)val);
            } else if (val instanceof StaticFieldRef) {
                SootField field = ((StaticFieldRef)val).getField();
                pts = (PointsToSetReadOnly)ptsProvider.reachingObjects(field);
            } else if (val instanceof NullConstant) {
                return (Set<? extends IAllocNode>) allocNodes;
            } else {
                logger.error("Unknown reference type for insenstive search: {} {}", val, val.getClass());
                droidsafe.main.Main.exit(1);
            }

            //visit internal points to set and grab all allocnodes        
            pts.forall(new P2SetVisitor() {
                public void visit(ContextAllocNode n) {
                    allocNodes.add(n.obj());
                }
            });

        } catch (Exception e) {
            logger.info("Some sort of error getting context insensitive points to set for {}", val, e);
            //e.printStackTrace();
        }

        return (Set<? extends IAllocNode>) allocNodes;
    }

    /**
     * Context Insensitive query of field reference with allocnode and field. 
     */
    public Set<? extends IAllocNode> getPTSet(IAllocNode node, SootField field) {
        if (field.isStatic()) {
            logger.error("Cannot call getPTSet(node, field) with static field: {}", field);
            droidsafe.main.Main.exit(1);
        }

        final Set<AllocNode> allocNodes = new HashSet<AllocNode>();        
        AllocNode allocNode = (AllocNode) node;
        AllocDotField allocDotField = allocNode.dot(field);
        AbsP2Sets p2sets = Results.v().p2sets();
        Iterator iter = allocDotField.contexts();
        while (iter.hasNext()) {
            ContextAllocDotField cadf = (ContextAllocDotField) iter.next();
            PointsToSet pointsToSet = p2sets.get(cadf);
            ((PointsToSetReadOnly)ptsProvider.reachingObjects(pointsToSet, field)).forall(new P2SetVisitor() {
                @Override
                public void visit(ContextAllocNode node) {
                    allocNodes.add(node.obj());
                }
            });
        }

        return (Set<? extends IAllocNode>) allocNodes;
    }

    @Override
    public Set<? extends IAllocNode> getPTSet(Value val, Context context) {
        //        if (context.getType() == ContextType.EVENT_CONTEXT) {
        //            return getPTSetEventContext(val, context.getContext());
        //        } else if (context.getType() == ContextType.ONE_CFA) {
        //            return getPTSet1CFA(val, context.getContext());
        //        } else if (context.getType() == ContextType.NONE) {
        if (context == null) {
            return getPTSetIns(val);
        } else {
            logger.error("Invalid Query Type: {}", context);
            droidsafe.main.Main.exit(1);
            return null;
        }
    }

    @Override
    public Set<? extends IAllocNode> getPTSetOfArrayElement(IAllocNode node) {
        logger.error("Not yet implemented");
        droidsafe.main.Main.exit(1);
        return null;
    }

 
    @Override
    public void dumpPTA() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dumpPTA(String fileName) {
        // TODO Auto-generated method stub

    }

    @Override
    public void dumpPTAForContext(PrintStream file, Context sootContext) {
        // TODO Auto-generated method stub

    }

    @Override
    public void dumpCallGraph(String fileStr) {
        // TODO Auto-generated method stub

    }

}
