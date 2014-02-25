package droidsafe.analyses.value;

import au.com.bytecode.opencsv.CSVWriter;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;

import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.rcfg.OutputEvent;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.rcfg.RCFGNode;
import droidsafe.android.app.Project;
import droidsafe.transforms.objsensclone.ClassCloner;
import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.InvokeExpr;
import soot.jimple.NewExpr;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.pta.IAllocNode;
import soot.RefType;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Type;
import soot.Value;

/**
 * @author dpetters
 */

public class VAStats {

    /** Generic logger */
    private static final Logger logger = LoggerFactory.getLogger(VAStats.class);

    // all lrelevant 
    private Set<IAllocNode> reachableAllocNodes = new HashSet<IAllocNode>();

    // classes and fields resolved by value analysis
    private Map<String, Set<SootField>> vaResolvedClassNamesAndFields = new HashMap<String, Set<SootField>>();

    // methods for which an IAllocNode is a receiver or an argument are marked as relevant
    private Map<IAllocNode, Set<SootMethod>> allocNodeToRelevantMethodsMap = new HashMap<IAllocNode, Set<SootMethod>>();

    // singleton
    private static VAStats v;

    // private constructor to enforce singleton pattern
    private VAStats() {}

    public static void run() {
        if(v==null) v = new VAStats();

        CSVWriter writer = null; 
        try {
            writer = new CSVWriter(new FileWriter(Project.v().getOutputDir() + File.separator + "va-stats.csv"));
        } catch(Exception e) {
            logger.warn("Unable to open va-stats.csv: {}", e);
            System.exit(1);
        }

        Map<SootClass, Set<SootField>> vaResolvedClassesAndFields= VAResultContainerClassGenerator.getClassesAndFieldsToModel(true);
        for(Map.Entry<SootClass, Set<SootField>> entry : vaResolvedClassesAndFields.entrySet()) {
            v.vaResolvedClassNamesAndFields.put(entry.getKey().getName(), entry.getValue());
        }

        // Walks through all the arguments of all output events and gathers a set of sootclasses of the arguments
        // From a VA stats standpoint, only the set sizes of fields of models of these sootclasses matter
        for(RCFGNode rcfgNode : RCFG.v().getNodes()) {
            InvokeExpr invokeExpr = rcfgNode.getInvokeExpr();
            if(invokeExpr != null) {
                SootMethod entryPointMethod = invokeExpr.getMethod();
                if (entryPointMethod.getName().equals("onClick")) {
                    for(int i = 0; i < rcfgNode.getNumArgs(); ++i) {

                        for(IAllocNode allocNode : rcfgNode.getArgPTSet( i)) {
                            if(shouldInclude(allocNode)) {
                                v.markAllocNodeAsReachable(allocNode);
                                v.markMethodAsRelevant(allocNode, entryPointMethod);
                            }
                        }
                    }
                }
            }
            for(OutputEvent oe : rcfgNode.getOutputEvents()) {
                InvokeExpr ie = oe.getInvokeExpr();
                SootMethod sm = ie.getMethod();
                if(ie != null) {
                    if(oe.hasReceiver()) {
                        // process receiver IAllocNodes
                        Set<IAllocNode> receiverPTSet = (Set<IAllocNode>)oe.getReceiverPTSet();
                        for(IAllocNode allocNode : receiverPTSet) {
                            if(shouldInclude(allocNode)) {
                                v.markAllocNodeAsReachable(allocNode);
                                v.markMethodAsRelevant(allocNode, sm);
                            }
                        }
                    }
                    // process argument allocNodes
                    for(int i = 0; i < oe.getNumArgs(); ++i) {
                        if(oe.isArgPointer(i)) {
                            Set<? extends IAllocNode> argPTSet = oe.getArgPTSet(i);
                            for(IAllocNode allocNode : argPTSet) {
                                if(shouldInclude(allocNode)) {
                                    v.markAllocNodeAsReachable(allocNode);
                                    v.markMethodAsRelevant(allocNode, sm);
                                }
                            }
                        }
                    }
                }
            }
        }

        // write out headers for columns
        writer.writeNext(new String[] {"field", "size", "relevant methods", "allocNode"});

        for(Map.Entry<IAllocNode, VAModel> entry : ValueAnalysis.v().getResults().entrySet()) {
            IAllocNode node = entry.getKey();
            Type type = node.getType();
            // we only care about reachable nodes
            if(type instanceof RefType && v.reachableAllocNodes.contains(node)) {
                RefVAModel refVAModel = (RefVAModel)entry.getValue();
                String scName = refVAModel.getClass().getName().substring(ValueAnalysis.MODEL_PACKAGE_PREFIX.length());
                if(v.vaResolvedClassNamesAndFields.containsKey(scName)) {
                    // we claim that we don't know the sizes of any field sets if the containing model got invalidated
                    boolean containingModelInvalidated = refVAModel.invalidated();
                    for(SootField sf : RefVAModel.getFieldsToDisplay(refVAModel.getSootClass())){
                        // 1st column - class name and field name
                        List<String> rowEntries = new ArrayList<String>();
                        rowEntries.add(sf.toString());

                        // 2nd column -  size of the resolved value set, either an integer or UNKNOWN. In the code
                        // below, -1 stands for UNKNOWN, which means we couldn't precisely identify the size of the
                        // set, either because it is a string and could be ANYTHING or got invalidated
                        int size = -1;
                        // we claim that we don't know the sizes of any field sets if the containing model got
                        // invalidated
                        if(!containingModelInvalidated) {
                            // Get the VA models for the field
                            Set<VAModel> fieldVAModels = refVAModel.getFieldVAModels(sf);
                            if(fieldVAModels.size() > 0) {
                                // If the field is a primitive or string-like, get the size of the set of values itself
                                // Otherwise, just get the number of other objects the field could point too
                                Type fieldType = sf.getType();
                                if(fieldType instanceof RefType && !SootUtils.isStringOrSimilarType(fieldType)){
                                    size = fieldVAModels.size();
                                    for(VAModel vaModel : fieldVAModels) {
                                        if(vaModel instanceof UnknownVAModel) {
                                            size = -1;
                                        }
                                    }
                                } else {
                                    for(VAModel vaModel : fieldVAModels) {
                                        if(vaModel instanceof PrimVAModel) {
                                            PrimVAModel primVAModel = (PrimVAModel)vaModel;
                                            // if the primitive field is invalidated, we can't trust the number of values
                                            if(primVAModel.invalidated()) {
                                                size = -1;
                                                break;
                                            } else {
                                                Set<Object> values = primVAModel.getValues();
                                                // if the set of values could include ANYTHING, leave size as -1
                                                if(values.contains(ValueAnalysis.UNKNOWN_VALUES_STRING)) {
                                                    size = -1;
                                                    break;    
                                                } else {
                                                    if (size == -1) {
                                                        size = 0;
                                                    }
                                                    size += values.size(); 
                                                }
                                            }
                                        } else {
                                            size = -1;
                                            break;
                                        }
                                    }
                                }
                            } else {
                                size = 0;
                            }
                        }               
                        // if size is still -1, then we couldn't figure out the number of resolved values
                        if(size == -1)
                            rowEntries.add("UNKNOWN");
                        else
                            rowEntries.add(String.valueOf(size));

                        // 3rd column - relevant methods for the node
                        rowEntries.add(v.getRelevantMethods(node));

                        // 4th column - allocNode
                        rowEntries.add(node.toString());

                        // write out all columns
                        writer.writeNext(rowEntries.toArray(new String[] {}));
                    }
                }
            }
        }
        try {
            writer.close();
        } catch(IOException ie) {
            logger.warn("Unable to close va-stats.log: {}", ie);
        }
    }

    /**
     * @return Concatinated string of 'relevant' methods, methods for which the object is a receiver or an argument. 
     *         We record these as another column in the csv file
     */
    private String getRelevantMethods(IAllocNode node) { 
        List<String> relevantMethodNames = new ArrayList<String>();
        if(allocNodeToRelevantMethodsMap.containsKey(node)) {
            for(SootMethod relevantMethod : v.allocNodeToRelevantMethodsMap.get(node)) {
                relevantMethodNames.add(relevantMethod.toString());
            }
        }
        return StringUtils.join(relevantMethodNames.toArray(), ";");
    }

    private static SootClass getFirstVAResolvedParentSootClass(SootClass sootClass) {
        Class<?> cls = null;
        while(sootClass.hasSuperclass() && cls == null) {
            try {
                cls = VAUtils.getDroidsafeClass(sootClass);
            } catch(ClassNotFoundException e) {
                sootClass = sootClass.getSuperclass();
            }
        }
        return sootClass;
    }


    /**
     * Helper method that records a soot method as being reachable with respect to a particular allocNode
     */
    private void markMethodAsRelevant(IAllocNode allocNode, SootMethod sootMethod) {
        if(!v.allocNodeToRelevantMethodsMap.containsKey(allocNode)) {
            v.allocNodeToRelevantMethodsMap.put(allocNode, new HashSet<SootMethod>());
        }
        v.allocNodeToRelevantMethodsMap.get(allocNode).add(sootMethod);
    }

    /**
     * Marks the allocNode and any allocNodes that could be assigned to its VA-resolved fields as reachable.
     * These are the allocNodes for which we want to dump specs about
     */ 
    private void markAllocNodeAsReachable(IAllocNode allocNode) {
        v.reachableAllocNodes.add(allocNode);

        Type type = allocNode.getType();

        if(type instanceof RefType) {
            SootClass sc = ((RefType)type).getSootClass();
            String scName = ClassCloner.removeClassCloneSuffix(sc.getName());
            if(v.vaResolvedClassNamesAndFields.containsKey(scName)) {
                for(SootField sf : v.vaResolvedClassNamesAndFields.get(scName)){
                    Set<? extends IAllocNode> allocNodes = PTABridge.v().getPTSet(allocNode, sf);
                    for(IAllocNode an : allocNodes) {
                        if(shouldInclude(an)) {
                            markAllocNodeAsReachable(an);
                        }
                    }
                }
            }
        }
    }

    /** 
     * Returns true if allocNode not allocated in DroidSafeMain or is of type android.app.Activity
     */
    private static boolean shouldInclude(IAllocNode allocNode) {
        SootMethod method = ((AllocNode)allocNode).getMethod();
        if(method != null) {
            SootClass sootClass = method.getDeclaringClass();
            Type type = allocNode.getType();
            if(sootClass != null && type instanceof RefType) {
                boolean should = sootClass.getName() != "droidsafe.generated.DroidSafeMain" || 
                        ClassCloner.removeClassCloneSuffix(((RefType)type).getSootClass().getSuperclass().getName()).equals("android.app.Activity");
                return should;
            }
        }
        return false;
    }
}