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


    Map<String, Map<String, Set<MethodModel>>> infoFlowSummaryMap = new TreeMap<String, Map<String, Set<MethodModel>>>();

    private Map<String, Map<String, Map<IntRange, Map<String, Set<CallLocationModel>>>>> taintedDataMap;
    private Map<String, Set<CallLocationModel>> taintSourcesMap;

    private Map<String, Map<String, Set<IntRange>>> unreachableSourceMethodMap;

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
        //        if (Config.v().debug) {
        printTaintInfo();
        printUnreachableSourceMethods();
        printSourceMethodLocationMap();
        //        }
    }

    public Map<String, Map<String, Map<IntRange, Map<String, Set<CallLocationModel>>>>> getTaintedDataMap() {
        return taintedDataMap;
    }

    public Map<String, Set<CallLocationModel>> getTaintSourcesMap() {
        return taintSourcesMap;
    }

    public Map<String, SourceLocationTag> getSourceMethodLocationMap() {
        return sourceMethodLocationMap;
    }

    private void computeTaintInfo() {
        taintedDataMap = new TreeMap<String, Map<String, Map<IntRange, Map<String, Set<CallLocationModel>>>>>();
        taintSourcesMap = new TreeMap<String, Set<CallLocationModel>>();
        Set<MethodOrMethodContext> methodContexts = PTABridge.v().getReachableMethodContexts();
        for (MethodOrMethodContext methodContext : methodContexts) {
            SootMethod method = methodContext.method();
            String methodName = getSourceMethodName(method);
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

    private String getSourceMethodName(SootMethod method) {
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
            String paramsSig = getParamsSig(method);
            methodName = (methodName + paramsSig).intern();
        }
        return methodName;
    }

    private String getParamsSig(SootMethod method) {
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

    private void computeTaintInfoForMethodFieldRefs(MethodOrMethodContext methodContext, Map<String, Set<CallLocationModel>> methodMap) {
        for (Unit unit: methodContext.method().getActiveBody().getUnits()) {
            Stmt stmt = (Stmt) unit;
            if (stmt.containsFieldRef()) {
                FieldRef fieldRef = stmt.getFieldRef();
                String fieldName = fieldRef.getField().getName();
                if (!fieldName.contains("$") && !fieldName.startsWith(UnmodeledGeneratedClasses.DUMMY_FIELD_PREFIX)) {
                    String name = valueToString(fieldRef);
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

    private String valueToString(Value value) {
        if (value instanceof InstanceFieldRef) {
            InstanceFieldRef instanceFieldRef = (InstanceFieldRef) value;
            return valueToString(instanceFieldRef.getBase()) + "." + instanceFieldRef.getField().getName();
        } else if (value instanceof StaticFieldRef) {
            StaticFieldRef staticFieldRef = (StaticFieldRef) value;
            String className = staticFieldRef.getFieldRef().declaringClass().getName();
            return className + "." + staticFieldRef.getField().getName();
        } else {
            return value.toString();
        }
    }

    private void printTaintInfo() {
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

    public Map<String, Map<String, Set<IntRange>>> getUnreachableSourceMethodMap() {
        return unreachableSourceMethodMap;
    }

    private void computeUneachableSourceMethods() {
        unreachableSourceMethodMap = new TreeMap<String, Map<String, Set<IntRange>>>();
        Set<String> srcClassNames = Project.v().getSrcClasses();
        for (String srcClassName : srcClassNames) {
            SootClass srcClass = Scene.v().getSootClass(srcClassName);
            if (!srcClass.isPhantomClass()) {
                for (SootMethod method: srcClass.getMethods()) {
                    if (!PTABridge.v().isReachableMethod(method)) {
                        String methodName = getSourceMethodName(method);
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

    private void printUnreachableSourceMethods() {
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

    private void computeSourceMethodLocationMap() {
        sourceMethodLocationMap = new HashMap<String, SourceLocationTag>();
        for (SootMethod method: SourceCallTree.v().collectSourceMethods()) {
            SourceLocationTag loc = SootUtils.getMethodLocation(method);
            if (loc != null) {
                sourceMethodLocationMap.put(method.getSignature(), loc);
            }
        }
    }

    private void printSourceMethodLocationMap() {
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

    public Set<MethodModel> getWhitelist() {
        return this.whitelist;
    }

    public Set<MethodModel> getEntryPoints() {
        return this.inputEventBlocks.keySet();
    }

    public List<MethodModel> getOutputEvents(MethodModel method) {
        return this.inputEventBlocks.get(method);
    }

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

    public Map<MethodModel, List<MethodModel>> getInputEventBlocks() {
        return this.inputEventBlocks;
    }

    public Map<MethodModel, Map<MethodModel, List<CodeLocationModel>>> getOutputEventBlocks() {
        if (this.outputEventBlocks == null || this.outputEventBlocks.isEmpty()) {
            computeOutputEventBlocks();
        }
        return this.outputEventBlocks;
    }

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
    public static void printPointsToInfo(SecuritySpecModel securitySpecModel, String app_ROOT_DIR) {
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
    public static void printValueInfo(SecuritySpecModel securitySpecModel, String app_ROOT_DIR) {
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

    public static void printSpecInfo(SecuritySpecModel securitySpecModel, String app_ROOT_DIR) {
        printInfoFlowSummary(securitySpecModel, Config.v().APP_ROOT_DIR);
        printInfoFlowDetails(securitySpecModel, Config.v().APP_ROOT_DIR);
        printValueInfo(securitySpecModel, Config.v().APP_ROOT_DIR);
        printPointsToInfo(securitySpecModel, Config.v().APP_ROOT_DIR);
    }

    public static void printInfoFlowSummary(SecuritySpecModel securitySpecModel, String app_ROOT_DIR) {
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
     * Print detailed info flow info associated with the security spec to a file in the droidsafe folder of 
     * the current selected Android app.
     */
    public static void printInfoFlowDetails(SecuritySpecModel securitySpecModel, String app_ROOT_DIR) {
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
