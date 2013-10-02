package droidsafe.analyses.infoflow;

import droidsafe.analyses.GeoPTA;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.value.models.droidsafe.primitives.StringVAModel;
import droidsafe.analyses.value.ValueAnalysis;
import droidsafe.analyses.value.VAModel;
import droidsafe.analyses.value.RefVAModel;
import droidsafe.analyses.value.VAUtils;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.internal.AbstractNewExpr;
import soot.jimple.NewExpr;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.callgraph.Edge;

import soot.RefType;

import soot.Scene;

import soot.SootClass;

import soot.SootField;

import soot.Type;

import soot.util.Chain;

/**
 * This analysis will calculate the sources of dynamic flows in the program.  Flows are attached to 
 * allocation nodes, and are determined by the values of the fields of an allocation node, as calculated 
 * by value analysis. 
 * 
 * In this class there is a list of fields, and for each field, a map of values to info kinds
 *  
 * One can add entries to this map to define potential dynamic flows for Android
 * 
 * Currently, we test for the possible dynamic value using string contains the against the values in the 
 * map entries for the field.  If not a string, we use .equals on the objects.
 * 
 * 
 * @author mgordon and dpetters
 */
public class InjectedSourceFlows {
    /** logger object */
    private static final Logger logger = LoggerFactory.getLogger(InjectedSourceFlows.class);

    /** singleton instance */
    private static InjectedSourceFlows v;

    /** local to store the attribute modeling results in */
    private final Map<AllocNode, VAModel> attrModelingResults;

    /** results of this analysis, map from allocnodes to the flows injected */
    private Map<AllocNode, Set<MyKind>> injectedFlows;

    /**
     * This map defines the flows we will inject based on values of fields.  
     * 
     * fully qualified field name -> object-> kind
     */
    private static Map<String, Map<Object, MyKind>> flowsToInject = new LinkedHashMap<String, Map<Object, MyKind>>() {{

        put("android.net.Uri.uriString", 
                new LinkedHashMap<Object,MyKind>() {{
                    put("person", MyKind.CONTACTS);
                    put("content://browser/bookmarks", MyKind.BROWSER_BOOKMARKS);
                    put("content://browser/bookmarks", MyKind.BROWSER_HISTORY);
                }});

    }};

    /**
     * This map defines the flows we will inject based on classes.
     *
     * fully qualified class name -> set of kinds
     */
    private static Map<String, Set<MyKind>> classNameToFlows = new HashMap<String, Set<MyKind>>();
    static {
        {
            Set<MyKind> kinds = new HashSet<MyKind>();
            kinds.add(MyKind.LOCATION);
            classNameToFlows.put("android.location.Location", kinds);
        }
    }

    /**
     * runs the analysis
     */
    public static void run() {
        v = new InjectedSourceFlows();
        v.buildInjectedFlowMap();
        System.out.println("Injected Flows: \n");
        for (Entry<AllocNode, Set<MyKind>> entry: v.injectedFlows.entrySet()) {
            System.out.println(entry.getKey());
            for (MyKind kind : entry.getValue())
                System.out.println("  " + kind);
        } 
    }

    /**
     * @return the singleton instance
     */
    public static InjectedSourceFlows v() {
        return v;
    }

    /**
     * Return the set of injected flows for this allocation site.
     */
    public Set<MyKind> getInjectedFlows(AllocNode node) {
        Object newExpr = GeoPTA.v().getNewExpr(node);
        if (newExpr instanceof NewExpr) {
            String className = ((NewExpr)newExpr).getBaseType().getClassName();
            if (classNameToFlows.containsKey(className)) {
                return classNameToFlows.get(className);
            }
        }

        if (injectedFlows.containsKey(node)) {
            return injectedFlows.get(node);
        } else {
            return new LinkedHashSet<MyKind>();
        }
    }

    /**
     * Build the internal map of allocnode to injected flows.  First, cache the classes we are interested in
     * inspecting, and build up some maps that will help the search.
     */
    private void buildInjectedFlowMap() {
        // the set of ANDROID classes we are inspecting
        Set<SootClass> classesToInspect = new LinkedHashSet<SootClass>();

        //map from field of the modeled class to the value->kind maps.
        Map<SootField, Map<Object, MyKind>> fieldFlowMap = new LinkedHashMap<SootField, Map<Object, MyKind>>();

        //map from modeled class class to field of that class that has an injected flow definition
        Map<SootClass, Set<SootField>> trackedFields = new LinkedHashMap<SootClass, Set<SootField>>(); 

        //build set of classes we should be examining
        //and a new map from SootField to string and flow
        for (String fullFieldName : flowsToInject.keySet()) {
            String field = getField(fullFieldName);
            String clz = getClass(fullFieldName);
            SootClass sootClass = Scene.v().getSootClass(clz); 
            classesToInspect.add(sootClass);

            SootField modeledField = sootClass.getFieldByName(field);

            //add the modeled field to the map of modeled field to value->kind
            fieldFlowMap.put(modeledField, flowsToInject.get(fullFieldName));

            //add the field to the set of fields we are curious about for the modeled class
            if (!trackedFields.containsKey(sootClass))
                trackedFields.put(sootClass, new LinkedHashSet<SootField>());

            trackedFields.get(sootClass).add(modeledField);


        }
        System.out.println(trackedFields);
        System.out.println(fieldFlowMap);

        //loop over all allocnodes in the results and if there is an inject flow, remember it
        for (AllocNode node : attrModelingResults.keySet()) {
            Type type = node.getType();
            if (type instanceof RefType) {
                SootClass clz = ((RefType)type).getSootClass();

                if (classesToInspect.contains(clz)) {
                    System.out.println("Testing: " + node);

                    //do something
                    RefVAModel modeledClass = (RefVAModel)this.attrModelingResults.get(node);


                    for (SootField field : trackedFields.get(clz)) {
                        //Value analysis stores all results as sets
                        Set<VAModel> values = modeledClass.getFieldVAModels(field);

                        Set<MyKind> flowsFound = test(values, fieldFlowMap.get(field));
                        if (flowsFound.size() > 0)
                            injectedFlows.put(node, flowsFound);
                    }

                }
            } else {
                logger.error("Unknown type for Value Analysis results: {} {}", node, type);
                droidsafe.main.Main.exit(1);
            }
        }
    }

    /**
     * Test for VA resolved value for a field against the possible values that inject flows.
     * 
     * For strings, use value.contains(testValue) otherwise use .equals()
     */
    private Set<MyKind> test(Set<VAModel> values, Map<Object, MyKind> possibleFlows) {
        Set<MyKind> kindsFound = new LinkedHashSet<MyKind>();

        for (VAModel value : values) {
            for (Entry<Object, MyKind> flowTest : possibleFlows.entrySet()) {
                boolean testTrue = false;

                System.out.printf("** Testing: %s (%s) and %s (%s)\n", value, value.getClass(), 
                        flowTest.getKey(), flowTest.getKey().getClass());

                if (value instanceof StringVAModel && flowTest.getKey() instanceof String) {
                    for(Object stringValue : ((StringVAModel)value).getValues()) {
                        testTrue = ((String)stringValue).contains((String)flowTest.getKey());
                        if (testTrue)
                            break;
                    }
                } else {
                    testTrue = value.equals(flowTest.getKey());
                }

                if (testTrue) 
                    kindsFound.add(flowTest.getValue());
            }
        }

        return kindsFound;
    }

    /**
     * Given a fully qualified field name in the format of the flowsToInject, return just the field name.
     * Stripping the class name.
     */
    private String getField(String fullFieldName) {
        return fullFieldName.substring(fullFieldName.lastIndexOf('.') + 1);
    }

    /** 
     * Given a full qualified field name in the format of the flowsToIject, return the class name, stripping the field.
     */
    private String getClass(String fullFieldName) {
        return fullFieldName.substring(0, fullFieldName.lastIndexOf('.'));
    }

    /**
     * Private (to enforce singleton pattern) class constructor that runs the analysis
     */
    private InjectedSourceFlows() {
        this.attrModelingResults = ValueAnalysis.v().getResults();
        this.injectedFlows = new LinkedHashMap<AllocNode, Set<MyKind>>();
    }

    public Map<SootField, Set<MyKind>> getInjectedFlows(AllocNode allocNode, Edge entryEdge) {
        logger.error("Don't call this anymore!");
        droidsafe.main.Main.exit(1);
        return null;
    }
}
