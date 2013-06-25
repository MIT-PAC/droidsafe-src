package droidsafe.analyses.infoflow;

import droidsafe.analyses.value.ValueAnalysis;
import droidsafe.analyses.value.ValueAnalysisModeledObject;
import droidsafe.analyses.value.models.android.net.Uri;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import soot.jimple.internal.AbstractNewExpr;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.callgraph.Edge;

import soot.RefType;

import soot.SootField;

import soot.util.Chain;
/**
 * @author dpetters
 */
public class InjectedSourceFlows {

    /** singleton instance */
    private static InjectedSourceFlows v;

    /** local to store the attribute modeling results in */
    private final Map<AllocNode, ValueAnalysisModeledObject> attrModelingResults;

    /**
     * runs the analysis
     */
    public static void run() {
        v = new InjectedSourceFlows();
    }

    /**
     * @return the singleton instance
     */
    public static InjectedSourceFlows v() {
        return v;
    }

    /**
     * Private (to enforce singleton pattern) class constructor that runs the analysis
     */
    private InjectedSourceFlows() {
        this.attrModelingResults = ValueAnalysis.v().getResults();
    }

    /**
     * returns a mapping from AllocNode's field to a set of information kinds
     *
     * @param allocNode AllocNode that we want to check for information kind
     * @param context The context in which we want to check for information kind
     *
     * @return a mapping from each field to a set of information kinds
     */
    public Map<SootField, Set<MyKind>> getInjectedFlows(AllocNode allocNode, Edge context) {
        
        Map<SootField, Set<MyKind>> fieldToInfoKindSetMap = new HashMap<SootField, Set<MyKind>>();

        AbstractNewExpr abstractNewExpr = (AbstractNewExpr)allocNode.getNewExpr();
        Chain<SootField> sootFieldChain = abstractNewExpr.getBaseType().getSootClass().getFields();

        for(SootField sootField : sootFieldChain) {
            fieldToInfoKindSetMap.put(sootField, getInjectedFlows(allocNode, sootField, context));
        }
 
        return fieldToInfoKindSetMap;
    }

    /**
     * Returns a set of information kinds represented by the passed-in AllocNode's SootField
     *
     * @param node   AllocNode that we want to look at
     * @param field   The field of the AllocNode that we want to look at
     * @param context   The context we want to consider
     *
     * @return Set<MyKind>, the set of info kinds represented by the passed-in AllocNode's SootField
     */
    private Set<MyKind> getInjectedFlows(AllocNode node, SootField field, Edge context) {
        
        Set<String> stringsToInspect = new HashSet<String>();
        
        if(this.attrModelingResults.containsKey(node)){
            ValueAnalysisModeledObject modeledClass = this.attrModelingResults.get(node);
            try {
                Class<?> c = modeledClass.getClass();
                Field fld = c.getDeclaredField(field.getName());
                Object object = fld.get(modeledClass);

                if (object instanceof Uri){
                    Uri uri = (Uri)object;
                    stringsToInspect.addAll(uri.uriString);
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                // do nothing
            }
        }

        return inspectStringsForInfoKinds(stringsToInspect);
    }

    /**
     * Returns the set of information kinds represented by the passed-in strings
     *
     * @param stringsToInspect   set of strings to inspect
     *
     * @return Set<MyKind>, the set of information kinds representated by the passed-in set of strings
     */
    private static Set<MyKind> inspectStringsForInfoKinds(Set<String> stringsToInspect) {
        Set<MyKind> infoKinds = new HashSet<MyKind>();
        for(String str : stringsToInspect) {
            if(str.indexOf("person") != -1) {
                infoKinds.add(MyKind.CONTACTS);
            }
        }
        return infoKinds;
    }
}
