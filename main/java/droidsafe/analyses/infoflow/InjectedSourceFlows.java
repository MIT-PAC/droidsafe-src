package droidsafe.analyses.infoflow;

import droidsafe.analyses.attr.AttributeModeling;
import droidsafe.analyses.attr.AttrModeledClass;
import droidsafe.analyses.attr.models.android.net.Uri.StringUri;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.callgraph.Edge;

import soot.RefType;

import soot.SootField;

/**
 * @author dpetters
 */
public class InjectedSourceFlows {

    /** singleton instance */
    private static InjectedSourceFlows v;

    /** local to store the attribute modeling results in */
    private final Map<AllocNode, AttrModeledClass> attrModelingResults;

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
        this.attrModelingResults = AttributeModeling.v().getResults();
    }

    /**
     * returns a mapping from AllocNode's field to a set of information kinds
     *
     * @param node AllocNode that we want to check for information kind
     * @param context The context in which we want to check for information kind
     *
     * @return a mapping from each field to a set of information kinds
     */
    public Map<SootField, Set<MyKind>> getInjectedFlows(AllocNode node, Edge context) {
        return Collections.emptyMap();
    }

    /**
     * returns a set of information kinds that may be stored in the passed-in AllocNode's field
     *
     * @parameter node   AllocNode that we want to check for info kind
     * @parameter field   The field of the AllocNode that we want to check for info kind
     * @parameter context   The context in which we want to check for info kind
     *
     * @return a set of info kinds
     */
    @Deprecated
    public Set<MyValue> getInjectedFlows(AllocNode node, SootField field, Edge context) {
        LinkedHashSet<MyValue> flows = new LinkedHashSet<MyValue>();
        List<String> stringsToInspect = new ArrayList<String>();
        if(this.attrModelingResults.containsKey(node)){
            AttrModeledClass modeledClass = this.attrModelingResults.get(node);
            try {
                Class<?> c = modeledClass.getClass();
                Field fld = c.getDeclaredField(field.getName());
                Object object = fld.get(modeledClass);

                if (object instanceof StringUri){
                    StringUri stringUri = (StringUri)object;
                    stringsToInspect.addAll(stringUri.dsToString());
                }
            } catch (Exception e){

            }
        }

        for(String str : stringsToInspect) {
            if(str.indexOf("person") != -1){
                flows.add(MyKind.CONTACTS);
            }
        }

        return new LinkedHashSet<MyValue>();
    }
}
