/**
 * 
 */
package droidsafe.speclang.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;
import soot.Local;
import soot.MethodOrMethodContext;
import soot.PatchingChain;
import soot.PrimType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.ValueBox;
import soot.jimple.FieldRef;
import soot.jimple.InstanceFieldRef;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.StaticFieldRef;
import soot.jimple.Stmt;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.pta.IAllocNode;
import soot.toolkits.scalar.Pair;
import droidsafe.analyses.infoflow.InfoUnit;
import droidsafe.analyses.infoflow.InfoValue;
import droidsafe.analyses.infoflow.InformationFlowAnalysis;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.strings.JSAStrings;
import droidsafe.analyses.strings.JSAStrings.Hotspot;
import droidsafe.android.app.Project;
import droidsafe.android.system.InfoKind;
import droidsafe.main.Config;
import droidsafe.reports.SourceCallTree;
import droidsafe.speclang.Method;
import droidsafe.speclang.SecuritySpecification;
import droidsafe.transforms.UnmodeledGeneratedClasses;
import droidsafe.transforms.objsensclone.CloneInheritedMethods;
import droidsafe.utils.IntRange;
import droidsafe.utils.SootUtils;
import droidsafe.utils.SourceLocationTag;
import droidsafe.utils.Utils;

/**
 * This is a wrapper class around the droidsafe.speclang.SecuritySpecification class. This class
 * provides a model of the spec that can be used by the Eclipse outline view, and simplifies the
 * serialization of the spec representation to be used by this view.
 * 
 * @author Marcel Becker (becker@kestrel.edu)
 * 
 */
public class SecuritySpecModel extends ModelChangeSupport
implements
Serializable,
PropertyChangeListener {
    /**
     * The generated serial version ID.
     */
    private static final long serialVersionUID = -2836030244594131144L;

    /**
     * The logger object for this class.
     */
    //@SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(SecuritySpecModel.class);

    /**
     * The name of the file to use to save the serialized version of the spec.
     */
    public static final String SECURITY_SPEC_SERIAL_FILE_NAME = "security_spec.ser";

    /**
     * The name of the file that contains the points-to info of the spec.
     */
    private static final String POINTS_TO_INFO_FILE_NAME = "points-to-info.txt";

    /**
     * The name of the file that contains the points-to info of the spec.
     */
    private static final String VALUE_INFO_FILE_NAME = "value-info.txt";

    /**
     * The name of the file that contains the info flow summary of the spec.
     */
    private static final String INFO_FLOW_SUMMARY_FILE_NAME = "info-flow-summary.txt";

    /**
     * The name of the file that contains the info flow details of the spec.
     */
    private static final String INFO_FLOW_DETAILS_FILE_NAME = "info-flow-details.txt";

    /**
     * The path to location of the Android project root folder. We need this information to serialize
     * the spec.
     */
    private String projectRootPath;

    /**
     * Set of methods that are considered safe.
     */
    private Set<MethodModel> whitelist = new LinkedHashSet<MethodModel>();

    /**
     * eventBlocks contains the default security spec hierarchy -- output events map to a list of
     * input events, or APIs, and each API entry maps to a number of source code locations. In this
     * map, the top most parents are the input events.
     * 
     */
    private Map<MethodModel, List<MethodModel>> inputEventBlocks =
            new LinkedHashMap<MethodModel, List<MethodModel>>();


    /**
     * This map contains the same information as the eventBlocks above but in a different
     * organization. This map maps outputEvents to input events, and each intput event to the list of
     * lines in which the parent outputEvent is present. This map is used to display a hierarchical
     * view of the spec rooted at the API nodes.
     */
    private transient Map<MethodModel, Map<MethodModel, List<CodeLocationModel>>> outputEventBlocks =
            new LinkedHashMap<MethodModel, Map<MethodModel, List<CodeLocationModel>>>();



    /**
     * This map contains the same information as the eventBlocks above but in a different
     * organization. This map maps code locations to lists of input events, and each input event to
     * the list of output events in which the parent code location is present. This map is used to
     * display a hierarchical view of the spec rooted at the code location nodes.
     */
    private transient Map<CodeLocationModel, Map<MethodModel, List<MethodModel>>> codeLocationEventBlocks =
            new LinkedHashMap<CodeLocationModel, Map<MethodModel, List<MethodModel>>>();


    /**
     * A map from source info kind and sink info kind to the set of sink method models where there are info flows
     * from the source kind to the sink kind.  This information is used to display Info Flow Summary outline in
     * the Eclipse plugin.
     */
    Map<String, Map<String, Set<MethodModel>>> infoFlowSummaryMap = new TreeMap<String, Map<String, Set<MethodModel>>>();

    /**
     * A map from class names, method ids, method line ranges, and tainted variables/fields to
     * the corresponding sets of info sources that flow through the tainted variables/fields.
     * This information is used to display tainted data in the Java sources viewed in the 
     * Eclipse plugin.
     */
    private Map<String, Map<String, Map<IntRange, Map<String, Set<CallLocationModel>>>>> taintedDataMap;

    /**
     * A map from info source kinds to the corresponding sets of info sources.  This information is 
     * used by the Eclipse plugin to facilitate project-wise display filtering of tainted data.
     */
    private Map<String, Set<CallLocationModel>> taintSourcesMap;

    /**
     * A map from class names and method ids to the corresponding sets of source line ranges of 
     * unreachable methods.  This information is used by the Eclipse plugin to locate dead code.
     */
    private Map<String, Map<String, Set<IntRange>>> unreachableSourceMethodMap;

    /**
     * A map from source method signatures to source method code locations. 
     */
    private Map<String, SourceLocationTag> sourceMethodLocationMap;

    /**
     * Main constructor for the spec model. Translate the original droidsafe spec into a simpler
     * representation that can be used by the eclipse plugin.
     * 
     * @param originalSpec The droidsafe security spec we want to represent in this model.
     */
    public SecuritySpecModel(SecuritySpecification originalSpec, String projectPath) {
        this.projectRootPath = projectPath;
        translateModel(originalSpec);
        computeTaintInfo();
        computeUneachableSourceMethods();
        computeSourceMethodLocationMap();
        if (Config.v().debug) {
        	writeTaintInfoToFile();
        	writeUnreachableSourceMethodsToFile();
        	writeSourceMethodLocationMapToFile();
        }
    }
    
    /**
     * Returns the map from class name, method id, method line range, and tainted variable/field name to 
     * the info sources that flow through the tainted variable/field.
     * 
     * @return the tainted data map
     */
    public Map<String, Map<String, Map<IntRange, Map<String, Set<CallLocationModel>>>>> getTaintedDataMap() {
        return taintedDataMap;
    }

    /**
     * Returns the map from info source kind to the corresponding info sources.
     * 
     * @return the taint sources map
     */
    public Map<String, Set<CallLocationModel>> getTaintSourcesMap() {
        return taintSourcesMap;
    }

    /**
     * Returns the map from source method signatures to source method code locations. 
     * 
     * @return the source method location map
     */
    public Map<String, SourceLocationTag> getSourceMethodLocationMap() {
        return sourceMethodLocationMap;
    }

    /**
     * Compute the tainted data map and the tainted sources map for the spec model.
     */
    private void computeTaintInfo() {
        taintedDataMap = new TreeMap<String, Map<String, Map<IntRange, Map<String, Set<CallLocationModel>>>>>();
        taintSourcesMap = new TreeMap<String, Set<CallLocationModel>>();
        Set<MethodOrMethodContext> methodContexts = PTABridge.v().getReachableMethodContexts();
        for (MethodOrMethodContext methodContext : methodContexts) {
            SootMethod method = methodContext.method();
            String methodName = getSourceMethodID(method);
            if (methodName != null) {
                SourceLocationTag loc = SootUtils.getMethodLocation(method);
                if (loc != null) {
                    String clsName = loc.getClz();
                    if (Project.v().isSrcClass(clsName)) {
                        Map<String, Map<IntRange, Map<String, Set<CallLocationModel>>>> methodMap = taintedDataMap.get(clsName);
                        if (methodMap == null) {
                            methodMap = new TreeMap<String, Map<IntRange, Map<String, Set<CallLocationModel>>>>();
                            taintedDataMap.put(clsName, methodMap);
                        }
                        IntRange range = SootUtils.getMethodLineRange(method);
                        if (range != null) {
                            Map<IntRange, Map<String, Set<CallLocationModel>>> rangeMap = methodMap.get(methodName);
                            if (rangeMap == null) {
                                rangeMap = new TreeMap<IntRange, Map<String, Set<CallLocationModel>>>();
                                methodMap.put(methodName, rangeMap);
                            }
                            Map<String, Set<CallLocationModel>> dataMap = rangeMap.get(range);
                            if (dataMap == null) {
                                dataMap = new HashMap<String, Set<CallLocationModel>>();
                                rangeMap.put(range, dataMap);
                            }
                            computeTaintInfoForMethodLocals(methodContext, dataMap);
                            computeTaintInfoForMethodFieldRefs(methodContext, dataMap);
                            if (dataMap.isEmpty()) {
                                rangeMap.remove(range);
                                if (rangeMap.isEmpty()) {
                                    methodMap.remove(methodName);
                                    if (methodMap.isEmpty())
                                        taintedDataMap.remove(clsName);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Returns the method name if the given method is not a constructor.  Returns 
     * the short class name and the short parameter signature if the given method 
     * is a constructor.
     * 
     * @param method - the method
     * @return
     */
    private String getSourceMethodID(SootMethod method) {
        String methodName = method.getName();
        if (methodName.equals("DS__FAKE__CALLBACKS__") || 
                methodName.startsWith("OBJECTGETCLASS_TO_CLASSCONSTANT_LOCAL") || 
                methodName.matches(".*\\$\\d+.*")) {
            return null;
        }
        if (methodName.equals("<init>")) {
            String className = method.getDeclaringClass().getName();
            if (className.matches(".*\\$\\d+.*"))
                return null;
            int pos = className.lastIndexOf('$');
            if (pos >= 0)
                methodName = className.substring(pos + 1);
            else 
                methodName = Utils.extractClassname(className);
            String paramsSig = getParamsShortSig(method);
            methodName = (methodName + paramsSig).intern();
        }
        return methodName;
    }

    /**
     * Returns short signature (without package names) for the parameters of the given method.
     * 
     * @param method - the method
     * @return
     */
    private String getParamsShortSig(SootMethod method) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("(");
        List<Type> paramTypes = method.getParameterTypes();
        boolean first = true;
        for (Type paramType: paramTypes) {
            if (first)
                first = false;
            else
                buffer.append(",");
            String typeStr = Utils.extractClassname(paramType.toString());
            buffer.append(typeStr);
        }
        buffer.append(")");
        return buffer.toString();
    }

    /**
     * Given a method context and a method, computes taint info for the local variables
     * in the method, and updates the map from variable name to info sources that
     * can flow through the variable.
     * 
     * @param methodContext - the method context
     * @param methodMap - a map from variable name to info sources that can flow through
     *                    the variable
     */
    private void computeTaintInfoForMethodLocals(MethodOrMethodContext methodContext, Map<String, Set<CallLocationModel>> methodMap) {
        for (Local local: methodContext.method().getActiveBody().getLocals()) {
            String name = local.getName();
            if (!name.equals("this") && !name.startsWith("$") && !name.startsWith("_$") && !name.matches("l\\d+")) {
                String origName = name.replaceFirst("#\\d+$", "");
                Set<CallLocationModel> vals = getTaints(methodContext, local);
                if (!vals.isEmpty()) {
                    Set<CallLocationModel> infoVals = methodMap.get(origName);
                    if (infoVals == null) {
                        infoVals = new TreeSet<CallLocationModel>();
                        methodMap.put(origName, infoVals);
                    }
                    infoVals.addAll(vals);
                }
            }
        }
    }

    /**
     * Given a method context and a method, computes taint info for the fields referenced
     * in the method, and updates the map from field name to info sources that
     * can flow through the field.
     * 
     * @param methodContext - the method context
     * @param methodMap - a map from field name to info sources that can flow through
     *                    the field
     */
    private void computeTaintInfoForMethodFieldRefs(MethodOrMethodContext methodContext, Map<String, Set<CallLocationModel>> methodMap) {
        for (Unit unit: methodContext.method().getActiveBody().getUnits()) {
            Stmt stmt = (Stmt) unit;
            if (stmt.containsFieldRef()) {
                FieldRef fieldRef = stmt.getFieldRef();
                String fieldName = fieldRef.getField().getName();
                if (!fieldName.contains("$") && !fieldName.startsWith(UnmodeledGeneratedClasses.DUMMY_FIELD_PREFIX)) {
                    String name = fieldRefToString(fieldRef);
                    if (!name.startsWith("$") && !name.startsWith("_$")) {
                        String origName = name.replaceFirst("#\\d+", "");
                        Set<CallLocationModel> vals = getTaints(methodContext, fieldRef);
                        if (!vals.isEmpty()) {
                            Set<CallLocationModel> infoVals = methodMap.get(origName);
                            if (infoVals == null) {
                                infoVals = new TreeSet<CallLocationModel>();
                                methodMap.put(origName, infoVals);
                            }
                            infoVals.addAll(vals);
                        }
                    }
                }
            }
        }
    }

    /**
     * Returns the string representation of the given field reference.
     * 
     * @param fieldRef - the field reference
     * @return the string representation of the field reference
     */
    private String fieldRefToString(FieldRef fieldRef) {
        if (fieldRef instanceof InstanceFieldRef) {
            InstanceFieldRef instanceFieldRef = (InstanceFieldRef) fieldRef;
            Value base = instanceFieldRef.getBase();
            String baseStr = (base instanceof FieldRef)? fieldRefToString((FieldRef)base) : base.toString();
            return baseStr + "." + instanceFieldRef.getField().getName();
        } else {
            StaticFieldRef staticFieldRef = (StaticFieldRef) fieldRef;
            String className = staticFieldRef.getFieldRef().declaringClass().getName();
            return className + "." + staticFieldRef.getField().getName();
        } 
    }

    /**
     * Writes the tainted data information to a file 'tained-data.txt' in the droidsafe output directory.
     */
    private void writeTaintInfoToFile() {
        try {
            FileWriter fw = new FileWriter(Project.v().getOutputDir() + File.separator + "tainted-data.txt");
            for (String clsName:  taintedDataMap.keySet()) {
                fw.write(clsName+"\n");
                Map<String, Map<IntRange, Map<String, Set<CallLocationModel>>>> methodMap = taintedDataMap.get(clsName);
                for (String methodName: methodMap.keySet()) {
                    fw.write("\n  " + methodName + "\n");
                    Map<IntRange, Map<String, Set<CallLocationModel>>> rangeMap = methodMap.get(methodName);
                    for (IntRange range: rangeMap.keySet()) {
                        fw.write("\n    [" + range.min + ", " + range.max + "]\n");
                        Map<String, Set<CallLocationModel>> dataMap = rangeMap.get(range);
                        for (String str: dataMap.keySet()) {
                            fw.write("\n      " + str + "\n");
                            for (CallLocationModel line: dataMap.get(str)) {
                                fw.write("        " + line + "\n");
                            }
                        }
                    }
                }
                fw.write("\n");
            }
            fw.write("\nTaint kinds:\n");
            for (Entry<String, Set<CallLocationModel>> entry: taintSourcesMap.entrySet()) {
                String taintKind = entry.getKey();
                fw.write("\n  " + taintKind);
                for (CallLocationModel call: entry.getValue()) {
                    fw.write("\n    " + call);
                }
            }
            fw.close();
        } catch (IOException e) {
            logger.error("Error writing tainted data file.");
            droidsafe.main.Main.exit(1);
        }     
    }

    /**
     * Returns the set of info sources that can flow through the given value under the given
     * method context.
     * 
     * @param methodContext - the method context
     * @param value - the value on which the taint sources are to be calculated
     * @return
     */
    private Set<CallLocationModel> getTaints(MethodOrMethodContext methodContext, Value value) {
        Set<InfoValue> infoVals = new HashSet<InfoValue>();
        if (value instanceof Local && value.getType() instanceof PrimType) {
            infoVals.addAll(InformationFlowAnalysis.v().getTaints(methodContext, (Local) value));
        } else {
            for (IAllocNode allocNode: PTABridge.v().getPTSet(value, methodContext.context())) {
                infoVals.addAll(InformationFlowAnalysis.v().getTaints(allocNode));
            }
        }
        Set<CallLocationModel> result = new HashSet<CallLocationModel>();
        for (InfoValue infoVal: infoVals) {
            if (infoVal instanceof InfoUnit && ((InfoUnit)infoVal).getUnit() instanceof Stmt) {
                Stmt stmt = (Stmt) ((InfoUnit)infoVal).getUnit();

                Set<Edge> edges = new LinkedHashSet<Edge>(); 
                if (stmt.containsInvokeExpr()) {
                    if (stmt.getInvokeExpr() instanceof InstanceInvokeExpr) {
                        Iterator<Edge> edgeIter = Scene.v().getCallGraph().edgesOutOf(stmt);
                        while (edgeIter.hasNext()) {
                            Edge edge = edgeIter.next();
                            edges.add(edge);
                        }
                    } else {
                        //static invoke
                        edges.add(Scene.v().getCallGraph().findEdge(stmt, stmt.getInvokeExpr().getMethod()));
                    }
                }

                for (Edge edge : edges) {
                    CallLocationModel line = CallLocationModel.get(edge);
                    if (line != null) {
                        Set<String> infoKinds = line.getInfoKinds();
                        if (line.getInfoKinds().isEmpty()) {
                            infoKinds = new HashSet<String>();
                            for (InfoKind infoKind: InfoKind.getSourceInfoKinds(stmt)) {
                                String kind = infoKind.toString();
                                infoKinds.add(kind);
                                Set<CallLocationModel> taintUnits = taintSourcesMap.get(kind);
                                if (taintUnits == null) {
                                    taintUnits = new TreeSet<CallLocationModel>();
                                    taintSourcesMap.put(kind, taintUnits);
                                }
                                taintUnits.add(line);
                            }
                            line.setInfoKinds(infoKinds);
                        }
                        result.add(line);
                    }
                }
            }
        }
        return result;
    }

    /**
     * Returns the map from class name and method id to the set of source line ranges of unreachable methods
     * with the method id.
     * 
     * @return the unreachable source method map
     */
    public Map<String, Map<String, Set<IntRange>>> getUnreachableSourceMethodMap() {
        return unreachableSourceMethodMap;
    }

    /**
     * Computes source methods that are unreachable and sets the field unreachableSourceMethodMap.
     */
    private void computeUneachableSourceMethods() {
        unreachableSourceMethodMap = new TreeMap<String, Map<String, Set<IntRange>>>();
        Set<String> srcClassNames = Project.v().getSrcClasses();
        for (String srcClassName : srcClassNames) {
            SootClass srcClass = Scene.v().getSootClass(srcClassName);
            if (!srcClass.isPhantomClass()) {
                for (SootMethod method: srcClass.getMethods()) {
                    if (!PTABridge.v().isReachableMethod(method)) {
                        String methodName = getSourceMethodID(method);
                        if (methodName != null) {
                            SourceLocationTag loc = SootUtils.getMethodLocation(method);
                            if (loc != null) {
                                String clsName = loc.getClz();
                                if (Project.v().isSrcClass(clsName)) {
                                    Map<String, Set<IntRange>> methodMap = unreachableSourceMethodMap.get(clsName);
                                    if (methodMap == null) {
                                        methodMap = new TreeMap<String, Set<IntRange>>();
                                        unreachableSourceMethodMap.put(clsName, methodMap);
                                    }
                                    IntRange range = SootUtils.getMethodLineRange(method);
                                    if (range != null) {
                                        Set<IntRange> ranges = methodMap.get(methodName);
                                        if (ranges == null) {
                                            ranges = new TreeSet<IntRange>();
                                            methodMap.put(methodName, ranges);
                                        }
                                        ranges.add(range);
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
    }

    /**
     * Writes info on the unreachable source methods to a file 'unreachable-source-methods.txt' in the droidsafe output
     * directory.
     */
    private void writeUnreachableSourceMethodsToFile() {
        try {
            FileWriter fw = new FileWriter(Project.v().getOutputDir() + File.separator + "unreachable-source-methods.txt");
            for (String clsName:  unreachableSourceMethodMap.keySet()) {
                fw.write(clsName+"\n");
                Map<String, Set<IntRange>> methodMap = unreachableSourceMethodMap.get(clsName);
                for (String methodName: methodMap.keySet()) {
                    fw.write("\n  " + methodName + "\n");
                    Set<IntRange> ranges = methodMap.get(methodName);
                    for (IntRange range: ranges) {
                        fw.write("\n    [" + range.min + ", " + range.max + "]\n");
                    }
                }
                fw.write("\n");
            }
            fw.close();
        } catch (IOException e) {
            logger.error("Error writing unreachable source methods file.");
            droidsafe.main.Main.exit(1);
        }     
    }

    /**
     * Computes locations of the source methods and sets the field sourceMethodLocationMap.
     */
    private void computeSourceMethodLocationMap() {
        sourceMethodLocationMap = new HashMap<String, SourceLocationTag>();
        for (SootMethod method: SourceCallTree.v().collectSourceMethods()) {
            SourceLocationTag loc = SootUtils.getMethodLocation(method);
            if (loc != null) {
                sourceMethodLocationMap.put(method.getSignature(), loc);
            }
        }
    }

    /**
     * Writes the source method location map to a file 'source-method-locations.txt' in the droidsafe output
     * directory.
     */
    private void writeSourceMethodLocationMapToFile() {
        try {
            FileWriter fw = new FileWriter(Project.v().getOutputDir() + File.separator + "source-method-locations.txt");
            for (Entry<String, SourceLocationTag> entry:  sourceMethodLocationMap.entrySet()) {
                fw.write(entry.getKey() + " : "+ entry.getValue() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            logger.error("Error writing source method locations file.");
            droidsafe.main.Main.exit(1);
        }     
    }

    /**
     * Returns the white list.
     * 
     * @return the write list
     */
    public Set<MethodModel> getWhitelist() {
        return this.whitelist;
    }

    /**
     * Returns the entry point methods of the spec model.
     * 
     * @return the entry points
     */
    public Set<MethodModel> getEntryPoints() {
        return this.inputEventBlocks.keySet();
    }

    /**
     * Returns the output events originated from the given method.
     * @param method - the method
     * @return
     */
    public List<MethodModel> getOutputEvents(MethodModel method) {
        return this.inputEventBlocks.get(method);
    }

    /**
     * Returns the map from source info kind and sink info kind to the set of sink method models where there are info flows
     * from the source kind to the sink kind. 
     * 
     * @return the info flow summary map
     */
    public Map<String, Map<String, Set<MethodModel>>> getInfoFlowSummaryMap() {
        return this.infoFlowSummaryMap;
    }

    //  public void addHotspot(MethodModel method, int argPosition) {
    //    addHotspotToSpec(method.getSootMethodSignature(), new HotspotModel(method, argPosition));
    //    serializeSpecToFile(this, this.projectRootPath);
    //  }


    //  public void removeHotspot(MethodModel method) {
    //    this.methodToHotspotMap.remove(method);
    //    serializeSpecToFile(this, this.projectRootPath);
    //  }



    /**
     * Populates the fields from the information stored in the original specification.
     * 
     * @param originalSpec - the security specification to be translated
     */
    private void translateModel(SecuritySpecification originalSpec) {
        for (Method m : originalSpec.getWhitelist()) {
            MethodModel model = new MethodModel(m);
            this.whitelist.add(model);
            model.addPropertyChangeListener(this);
        }
        Map<String, List<Hotspot>> signatureToHotspotMap = JSAStrings.v().getSignatureToHotspotMap();

        for (Map.Entry<Method, List<Method>> entry : originalSpec.getEventBlocks().entrySet()) {
            Method inputEvent = entry.getKey();
            List<Method> outputEvents = entry.getValue();
            ArrayList<MethodModel> modelOutputEvents = new ArrayList<MethodModel>();
            MethodModel model = new MethodModel(inputEvent);
            if (this.inputEventBlocks.get(model) != null) {
                logger.debug("Method {} already in event blocks", model);
            }
            this.inputEventBlocks.put(model, modelOutputEvents);
            model.addPropertyChangeListener(this);
            updateInfoFlowSummaryMap(model, inputEvent);


            for (Method outputEvent : outputEvents) {
                MethodModel methodModel = new MethodModel(outputEvent);
                modelOutputEvents.add(methodModel);
                methodModel.addPropertyChangeListener(this);
                updateInfoFlowSummaryMap(methodModel, outputEvent);

                List<Hotspot> apiHotspots = signatureToHotspotMap.get(model.getSootMethodSignature());
                Map<SourceLocationTag, List<HotspotModel>> map = computeSourceLocToHotspotsMap(apiHotspots);      

                for (CodeLocationModel line : methodModel.getLines()) {
                    line.addPropertyChangeListener(this);
                    if (map != null) {
                        logger.debug("Hotspot for method {} is in map", methodModel);
                        for (SourceLocationTag loc : map.keySet()) {
                            if (line.getClz().equals(loc.getClz())
                                    && line.getLine() == loc.getLine()) {
                                line.addHotspots(map.get(loc));
                            }
                        }
                    }
                }
            }
            Collections.sort(modelOutputEvents);
            // logger.debug("Input Method {}", inputEvent);
            // logger.debug(" \n Number of Output Events in original method {}",
            // Integer.toString(outputEvents.size()));
            // logger.debug("\n Number of Events in modelEvents {}",
            // Integer.toString(modelOutputEvents.size()));
        }
        // logger.debug("{}", printSpecModel());
    }

    /**
     * Auxiliary method to add all previously computed hotspots to the spec.
     * 
     * @param signatureToHotspotMap A map from soot method signature to a list of soot value boxes.
     */
    private Map<SourceLocationTag, List<HotspotModel>> computeSourceLocToHotspotsMap(List<Hotspot> hotspots) {
        if (hotspots == null)
            return null;
        Map<SourceLocationTag, List<HotspotModel>> map = new HashMap<SourceLocationTag, List<HotspotModel>>();
        for (Hotspot hot : hotspots) {
            for (ValueBox vb : hot.getHotspots()) {
                SourceLocationTag loc = SootUtils.getSourceLocation(vb);
                List<HotspotModel> hotspotModels = map.get(loc);
                if (hotspotModels == null) {
                    hotspotModels = new ArrayList<HotspotModel>();
                    map.put(loc, hotspotModels);
                }
                HotspotModel hotspotModel = new HotspotModel(hot.getArgumentPosition(), JSAStrings.v().getRegex(vb.getValue()));
                hotspotModels.add(hotspotModel);
            }
        }
        return map;
    }

    /**
     * Updates the info flow summary map if the given method is a sink method and there are info flows
     * from some info sources into this sink method.
     * 
     * @param methodModel - the method model
     * @param method - the method corresponding to the method model
     */
    private void updateInfoFlowSummaryMap(MethodModel methodModel, Method method) {
        Set<InfoKind> sourcesInfoKinds = method.getSourcesInfoKinds();
        Set<InfoKind> sinkInfoKinds = method.getSinkInfoKinds();
        if (!sourcesInfoKinds.isEmpty() && !sinkInfoKinds.isEmpty()) {
            for (InfoKind sourceInfoKind: sourcesInfoKinds) {
                String source = sourceInfoKind.toString();
                Map<String, Set<MethodModel>> sinkMap = infoFlowSummaryMap.get(source);
                if (sinkMap == null) {
                    sinkMap = new TreeMap<String, Set<MethodModel>>();
                    infoFlowSummaryMap.put(source, sinkMap);
                }
                for (InfoKind sinkInfoKind: sinkInfoKinds) {
                    String sink = sinkInfoKind.toString();
                    Set<MethodModel> methodModels = sinkMap.get(sink);
                    if (methodModels == null) {
                        methodModels = new TreeSet<MethodModel>();
                        sinkMap.put(sink, methodModels);
                    }
                    methodModels.add(methodModel);
                }
            }
        }
    }

    /**
     * Returns the string representation of this spec model.
     * 
     * @return the string representation of this spec model.
     */
    public String printSpecModel() {
        StringBuffer sb = new StringBuffer("Droidsafe Spec Model");
        sb.append("\nWhitelist\n");
        for (MethodModel m : this.whitelist) {
            sb.append(m.printMethod()).append("\n");
        }
        for (MethodModel im : inputEventBlocks.keySet()) {
            sb.append("InputMethod ").append(im.toString()).append("\n");
            for (MethodModel om : inputEventBlocks.get(im)) {
                sb.append("    OutputMethod ").append(om.printMethod()).append("\n");
            }
        }
        return sb.toString();
    }


    /**
     * Creates a map from output events (API calls) to entry points (input events) to code locations.
     */
    private void computeOutputEventBlocks() {
        if (this.outputEventBlocks == null) {
            this.outputEventBlocks =
                    new LinkedHashMap<MethodModel, Map<MethodModel, List<CodeLocationModel>>>();
        }
        for (MethodModel inputEvent : inputEventBlocks.keySet()) {
            if (inputEventBlocks.get(inputEvent) != null) {
                for (MethodModel outputEvent : inputEventBlocks.get(inputEvent)) {
                    Map<MethodModel, List<CodeLocationModel>> outputEventMap =
                            this.outputEventBlocks.get(outputEvent);
                    if (outputEventMap == null) {
                        outputEventMap = new LinkedHashMap<MethodModel, List<CodeLocationModel>>();
                        this.outputEventBlocks.put(outputEvent, outputEventMap);
                    }
                    outputEventMap.put(inputEvent, outputEvent.getLines());
                }
            }
        }
    }

    /**
     * Creates a map from code location to entry points (input events) to to output events (API
     * calls).
     */
    private void computeCodeLocationEventBlocks() {
        if (this.codeLocationEventBlocks == null) {
            this.codeLocationEventBlocks =
                    new LinkedHashMap<CodeLocationModel, Map<MethodModel, List<MethodModel>>>();
        }
        for (MethodModel inputEvent : inputEventBlocks.keySet()) {
            if (inputEventBlocks.get(inputEvent) != null) {
                for (MethodModel outputEvent : inputEventBlocks.get(inputEvent)) {
                    List<CodeLocationModel> lines = outputEvent.getLines();
                    if (lines != null) {
                        for (CodeLocationModel line : lines) {
                            Map<MethodModel, List<MethodModel>> lineEventMap =
                                    this.codeLocationEventBlocks.get(line);
                            if (lineEventMap == null) {
                                lineEventMap = new LinkedHashMap<MethodModel, List<MethodModel>>();
                                this.codeLocationEventBlocks.put(line, lineEventMap);
                            }
                            List<MethodModel> outputMethods = lineEventMap.get(inputEvent);
                            if (outputMethods == null) {
                                outputMethods = new ArrayList<MethodModel>();
                                lineEventMap.put(inputEvent, outputMethods);
                            }
                            outputMethods.add(outputEvent);
                        }
                    }
                }
            }
        }
    }

    /**
     * Returns the input event blocks, i.e. the map from entry points (input events) to output events
     * (API calls).
     * 
     * @return the input event blocks
     */
    public Map<MethodModel, List<MethodModel>> getInputEventBlocks() {
        return this.inputEventBlocks;
    }

    /**
     * Returns the output event blocks, i.e. the map from output events (API calls) to entry points 
     * (input events) to code locations.
     * 
     * @return the output event blocks
     */
    public Map<MethodModel, Map<MethodModel, List<CodeLocationModel>>> getOutputEventBlocks() {
        if (this.outputEventBlocks == null || this.outputEventBlocks.isEmpty()) {
            computeOutputEventBlocks();
        }
        return this.outputEventBlocks;
    }

    /**
     * Returns the code location event blocks, i.e. the map from code location and input eventt to
     * the list of output events in which the parent code location is present.
     * 
     * @return the code location event blocks
     */
    public Map<CodeLocationModel, Map<MethodModel, List<MethodModel>>> getCodeLocationEventBlocks() {
        if (this.codeLocationEventBlocks == null || this.codeLocationEventBlocks.isEmpty()) {
            computeCodeLocationEventBlocks();
        }
        return this.codeLocationEventBlocks;
    }

    /**
     * Serializes the current version of the spec to a file in the droidsafe folder of the current
     * selected Android app.
     * 
     * @param spec The security specification model.
     * @param androidProjectRootPath The root of the Android App Eclipse project.
     * @return
     */
    public static boolean serializeSpecToFile(SecuritySpecModel spec, String androidProjectRootPath) {
        boolean saved = false;
        String fileName =
                androidProjectRootPath + File.separator + Project.OUTPUT_DIR + File.separator
                + SECURITY_SPEC_SERIAL_FILE_NAME;
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
            try {
                oos.writeObject(spec);
                saved = true;
            } finally {
                oos.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return saved;
    }

    /**
     * Reads the serialized version of the security specification from a file and creates a spec
     * model.
     * 
     * @param androidProjectRootPath The root location of the Android Eclipse project.
     * @return The security specification for the Android application.
     */
    public static SecuritySpecModel deserializeSpecFromFile(String androidProjectRootPath) {
        SecuritySpecModel spec = null;
        String fileName =
                androidProjectRootPath + File.separator + Project.OUTPUT_DIR + File.separator
                + SECURITY_SPEC_SERIAL_FILE_NAME;
        File file = new File(fileName);
        if (file.exists()) {
            try {
                ObjectInputStream ois =
                        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof SecuritySpecModel) {
                        spec = (SecuritySpecModel) obj;
                    }
                } finally {
                    ois.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            // if (spec != null) {
            // logger.debug("{}", spec.printSpecModel());
            // }
        }
        return spec;
    }

    /**
     * Saves the state of the specification model every time something changes in the model.
     */
    @Override
    public void propertyChange(PropertyChangeEvent event) {
        serializeSpecToFile(this, this.projectRootPath);
    }

    /**
     * Print points-to info associated with the security spec to a file in the droidsafe folder of 
     * the current selected Android app.
     */
    public static void writePointsToInfoToFile(SecuritySpecModel securitySpecModel, String app_ROOT_DIR) {
        try {
            FileWriter fw = new FileWriter(Project.v().getOutputDir() + File.separator + POINTS_TO_INFO_FILE_NAME);
            Set<MethodModel> entryPoints = securitySpecModel.getEntryPoints();
            SortedSet<MethodModel> allMethods = new TreeSet<MethodModel>(new MethodP2Comparator());
            allMethods.addAll(entryPoints);
            for (MethodModel entryPoint: entryPoints) {
                allMethods.addAll(securitySpecModel.getOutputEvents(entryPoint));
            }
            for (MethodModel method: allMethods) {
                StringBuffer buf = new StringBuffer();
                List<AllocLocationModel> receiverSources = method.getArgumentAllocSources(-1);
                if (receiverSources != null && !receiverSources.isEmpty()) {
                    buf.append("  <receiver> " + method.getReceiverType() + "\n");
                    printAllocations(receiverSources, buf);
                }
                List<String> args = method.getMethodArguments();
                for (int i = 0; i < args.size(); i++) {
                    List<AllocLocationModel> argSources = method.getArgumentAllocSources(i);
                    if (argSources != null && !argSources.isEmpty()) {
                        buf.append("  <argument " + (i + 1) + "> : " + args.get(i) + "\n");
                        printAllocations(argSources, buf);
                    }
                }
                if (buf.length() > 0) {
                    fw.write(method.getSignature() + "\n");
                    fw.write(buf.toString());
                }
            }
            fw.close();
        } catch (IOException e) {
            logger.error("Error writing points-to info file.");
            droidsafe.main.Main.exit(1);
        }     
    }

    /**
     * Print points-to info associated with the security spec to a file in the droidsafe folder of 
     * the current selected Android app.
     */
    public static void writeValueInfoToFile(SecuritySpecModel securitySpecModel, String app_ROOT_DIR) {
        try {
            FileWriter fw = new FileWriter(Project.v().getOutputDir() + File.separator + VALUE_INFO_FILE_NAME);
            Set<MethodModel> entryPoints = securitySpecModel.getEntryPoints();
            SortedSet<MethodModel> allMethods = new TreeSet<MethodModel>(new MethodP2Comparator());
            allMethods.addAll(entryPoints);
            for (MethodModel entryPoint: entryPoints) {
                allMethods.addAll(securitySpecModel.getOutputEvents(entryPoint));
            }
            for (MethodModel method: allMethods) {
                StringBuffer buf = new StringBuffer();
                String receiverValue = method.getReceiverValue();
                if (receiverValue != null && !receiverValue.isEmpty()) {
                    buf.append("<receiver>");
                    buf.append(receiverValue);
                    buf.append("\n\n");
                }
                List<String> args = method.getMethodArguments();
                for (int i = 0; i < args.size(); i++) {
                    String argValue = method.getArgumentValue(i);
                    if (argValue != null && !argValue.isEmpty()) {
                        buf.append("<argument " + (i + 1) + "> : " + args.get(i) + "\n");
                        buf.append(argValue);
                        buf.append("\n\n");
                    }
                }
                if (buf.length() > 0) {
                    fw.write(method.getSignature() + "\n");
                    fw.write(buf.toString());
                }
            }
            fw.close();
        } catch (IOException e) {
            logger.error("Error writing points-to info file.");
            droidsafe.main.Main.exit(1);
        }     
    }

    /**
     * Appends points-to info associated with the given allocation sources to the given string buffer.
     */
    private static void printAllocations(List<AllocLocationModel> allocSources, StringBuffer buf) {
        for (AllocLocationModel allocLoc: allocSources) {
            buf.append("    <allocation> "+ allocLoc + "\n");
            for (CallLocationModel callLoc: allocLoc.getCallsOnAlloc())
                buf.append("      <call> " + callLoc + "\n");
        }
    }

    /**
     * A method comparator used to sort method entries in the points-to info output.
     */
    public static class MethodP2Comparator implements Comparator<MethodModel> {

        @Override
        public int compare(MethodModel method1, MethodModel method2) {
            int diff = getAllocCount(method2) - getAllocCount(method1);
            if (diff == 0) {
                diff = method1.getClassName().compareTo(method2.getClassName());
                if (diff == 0) {
                    diff = method1.getMethodName().compareTo(method2.getMethodName());
                    if (diff == 0) {
                        diff = method1.getSignature().compareTo(method2.getSignature());
                        if (diff == 0) {
                            diff = getLineNumber(method1) - (getLineNumber(method2));
                        }
                    }
                }
            }
            return diff;
        }

        /**
         * Returns the total count of alloc nodes associated with the given method's receiver
         * and arguments.
         */
        private int getAllocCount(MethodModel method) {
            int count = 0;
            List<AllocLocationModel> receiverSources = method.getArgumentAllocSources(-1);
            if (receiverSources != null)
                count += receiverSources.size();
            int argCount = method.getMethodArguments().size();
            for (int i = 0; i < argCount; i++) {
                List<AllocLocationModel> allocs = method.getArgumentAllocSources(i);
                if (allocs != null)
                    count += allocs.size();
            }
            return count;
        }

        /**
         * Returns the number of the first line where this method is called.
         */
        private int getLineNumber(MethodModel method) {
            List<CodeLocationModel> lines = method.getLines();
            return (lines == null || lines.isEmpty()) ? 0 : lines.get(0).getLine();
        }

    }

    /**
     * Writes info flow info, value flow info, and points to info associated with the security spec to separate
     * files in the droidsafe folder of the current selected Android app.
     */
    public static void writeSpecInfoToFiles(SecuritySpecModel securitySpecModel, String app_ROOT_DIR) {
        writeInfoFlowSummaryToFile(securitySpecModel, Config.v().APP_ROOT_DIR);
        writeInfoFlowDetailsToFile(securitySpecModel, Config.v().APP_ROOT_DIR);
        writeValueInfoToFile(securitySpecModel, Config.v().APP_ROOT_DIR);
        writePointsToInfoToFile(securitySpecModel, Config.v().APP_ROOT_DIR);
    }

    /**
     * Writes info flow summary info associated with the security spec to a file in the droidsafe folder of 
     * the current selected Android app.
     */
    public static void writeInfoFlowSummaryToFile(SecuritySpecModel securitySpecModel, String app_ROOT_DIR) {
        try {
            FileWriter fw = new FileWriter(Project.v().getOutputDir() + File.separator + INFO_FLOW_SUMMARY_FILE_NAME);
            Map<String, Map<String, Set<MethodModel>>> infoFlowSummaryMap = securitySpecModel.getInfoFlowSummaryMap();
            for (String source : infoFlowSummaryMap.keySet()) {
                Map<String, Set<MethodModel>> sinkMap = infoFlowSummaryMap.get(source);
                for (String sink : sinkMap.keySet()) {
                    fw.write(source + " -> " + sink + "\n");
                    Set<MethodModel> methods = sinkMap.get(sink);
                    for (MethodModel method: methods) {
                        fw.write("  " + method + "\n");
                    }
                }
            }
            fw.close();
        } catch (IOException e) {
            logger.error("Error writing info flow summary to file.");
            droidsafe.main.Main.exit(1);
        }     
    }

    /**
     * Writes detailed info flow info associated with the security spec to a file in the droidsafe folder of 
     * the current selected Android app.
     */
    public static void writeInfoFlowDetailsToFile(SecuritySpecModel securitySpecModel, String app_ROOT_DIR) {
        try {
            FileWriter fw = new FileWriter(Project.v().getOutputDir() + File.separator + INFO_FLOW_DETAILS_FILE_NAME);
            Set<MethodModel> entryPoints = securitySpecModel.getEntryPoints();
            SortedSet<MethodModel> allMethods = new TreeSet<MethodModel>();
            allMethods.addAll(entryPoints);
            for (MethodModel entryPoint: entryPoints) {
                allMethods.addAll(securitySpecModel.getOutputEvents(entryPoint));
            }
            for (MethodModel method: allMethods) {
                if (method.hasInfoFlowInfo()) {
                    fw.write(method.getSignature() + "\n");
                    List<String> receiverInfoKinds = method.getArgumentInfoKinds(-1);
                    Map<String, List<CallLocationModel>> receiverSourceInfoUnits = method.getArgumentSourceInfoUnits(-1);
                    String desc = "<receiver> " + method.getReceiverType();
                    writeInfoFlowDetails(desc, receiverInfoKinds, receiverSourceInfoUnits, fw);
                    List<String> args = method.getMethodArguments();
                    for (int i = 0; i < args.size(); i++) {
                        List<String> argInfoKinds = method.getArgumentInfoKinds(i);
                        Map<String, List<CallLocationModel>> argInfoUnits = method.getArgumentSourceInfoUnits(i);
                        desc = "<argument " + (i + 1) + "> : " + args.get(i);
                        writeInfoFlowDetails(desc, argInfoKinds, argInfoUnits, fw);
                    }
                    List<String> sinkInfoKinds = method.getSinkInfoKinds();
                    desc = "<sinks>";
                    writeInfoFlowDetails(desc, sinkInfoKinds, null, fw);
                }
            }
            fw.close();
        } catch (IOException e) {
            logger.error("Error writing info flow details to file.");
            droidsafe.main.Main.exit(1);
        }     
    }

    /** 
     * Writes the detailed info flow info associated with a method argument or receiver using the given FileWriter.
     * 
     * @param desc - the description (a method argument or a method receiver) of the value where the info flows through
     * @param infoKinds - the info kinds of the flows
     * @param infoUnits - the info units of the flows
     * @param fw - the file writer
     * @throws IOException
     */
    private static void writeInfoFlowDetails(String desc, List<String> infoKinds,
                                             Map<String, List<CallLocationModel>> infoUnits, FileWriter fw) throws IOException {
        if ((infoKinds != null && !infoKinds.isEmpty()) || (infoUnits != null && !infoUnits.isEmpty())) {
            fw.write("  " + desc + "\n");
            String kinds = (infoKinds == null) ? "[SENSITIVE_UNCATEGORIZED]" : infoKinds.toString();
            fw.write("    " + kinds + "\n");
            if (infoUnits != null) {
                for (String kind: infoUnits.keySet()) {
                    fw.write("    " + kind + "\n");
                    for (CallLocationModel loc: infoUnits.get(kind)) {
                        fw.write("      " + loc + "\n");
                    }
                }
            }
        }
    }

}
