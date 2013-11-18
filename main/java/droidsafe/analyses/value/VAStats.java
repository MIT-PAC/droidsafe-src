package droidsafe.analyses.value;

import au.com.bytecode.opencsv.CSVWriter;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;

import droidsafe.analyses.GeoPTA;
import droidsafe.analyses.rcfg.OutputEvent;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.rcfg.RCFGNode;

import droidsafe.android.app.Project;

import droidsafe.transforms.objsensclone.ClassCloner;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.InvokeExpr;
import soot.jimple.NewExpr;
import soot.jimple.spark.pag.AllocNode;

import soot.RefType;

import soot.SootClass;

import soot.SootField;

import soot.Type;

import soot.Value;

/**
 * @author dpetters
 */

public class VAStats {

    /** Generic logger */
    private static final Logger logger = LoggerFactory.getLogger(VAStats.class);


    private Set<AllocNode> reachableAllocNodes = new HashSet<AllocNode>();

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

        // Walks through all the arguments of all output events and gathers a set of sootclasses of the arguments
        // From a VA stats standpoint, only the set sizes of fields of models of these sootclasses matter
        for(RCFGNode rcfgNode : RCFG.v().getNodes()) {
            for(OutputEvent oe : rcfgNode.getOutputEvents()) {
                InvokeExpr ie = oe.getInvokeExpr();
                if(ie != null) {
                    for(int i = 0; i < oe.getNumArgs(); ++i) {
                        if(oe.isArgPointer(i)) {
                            v.reachableAllocNodes.addAll(oe.getArgPTSet(i));
                        }
                    }
                }
            }
        }


        Map<SootClass, Set<SootField>> vaResolvedClassesAndFields= VAResultContainerClassGenerator.getClassesAndFieldsToModel(true);
        Map<String, Set<SootField>> vaResolvedClassNamesAndFields = new HashMap<String, Set<SootField>>();
        for(Map.Entry<SootClass, Set<SootField>> entry : vaResolvedClassesAndFields.entrySet()) {
            vaResolvedClassNamesAndFields.put(entry.getKey().getName(), entry.getValue());
        }

        for(Map.Entry<Object, VAModel> entry : ValueAnalysis.v().getResults().entrySet()) {
            Object newExpr = entry.getKey();
            AllocNode node = GeoPTA.v().getAllocNode(newExpr);
            Type type = node.getType();
            if(type instanceof RefType && v.reachableAllocNodes.contains(node)) {
                SootClass sc = ((RefType)type).getSootClass();
                String scName = ClassCloner.removeClassCloneSuffix(sc.getName());
                RefVAModel refVAModel = (RefVAModel)entry.getValue();
                if(vaResolvedClassNamesAndFields.containsKey(scName)) {
                    for(SootField sf : vaResolvedClassNamesAndFields.get(scName)){
                        Set<VAModel> fieldVAModels = refVAModel.getFieldVAModels(sf);
                        Type fieldType = sf.getType();
                        List<String> rowEntries = new ArrayList<String>();
                        rowEntries.add(scName);
                        rowEntries.add(sf.toString());
                        int size;
                        if(fieldType instanceof RefType && !SootUtils.isStringOrSimilarType(fieldType)){
                            size = fieldVAModels.size();
                        } else {
                            if(fieldVAModels.size() == 0){
                                size = 0;
                            } else {
                                size = ((PrimVAModel)fieldVAModels.iterator().next()).getValues().size();
                            }
                        }
                        rowEntries.add(String.valueOf(size));
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
}
