package dk.brics.string.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import soot.ArrayType;
import soot.BooleanType;
import soot.ByteType;
import soot.CharType;
import soot.DoubleType;
import soot.FloatType;
import soot.Hierarchy;
import soot.IntType;
import soot.LongType;
import soot.NullType;
import soot.PrimType;
import soot.RefType;
import soot.Scene;
import soot.ShortType;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Type;
import soot.Value;
import soot.ValueBox;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.ParameterRef;
import dk.brics.automaton.Automaton;
import dk.brics.string.MethodNameTaintAnalysisStrategy;
import dk.brics.string.StringAnalysis;
import dk.brics.string.external.ExternalVisibility;
import dk.brics.string.external.Resolver;
import dk.brics.string.intermediate.Application;
import dk.brics.string.intermediate.ArrayCorrupt;
import dk.brics.string.intermediate.AssertStatement;
import dk.brics.string.intermediate.Call;
import dk.brics.string.intermediate.FieldAssignment;
import dk.brics.string.intermediate.Method;
import dk.brics.string.intermediate.Nop;
import dk.brics.string.intermediate.ObjectCorrupt;
import dk.brics.string.intermediate.PrimitiveInit;
import dk.brics.string.intermediate.Return;
import dk.brics.string.intermediate.Statement;
import dk.brics.string.intermediate.StringAssignment;
import dk.brics.string.intermediate.StringBufferCorrupt;
import dk.brics.string.intermediate.StringInit;
import dk.brics.string.intermediate.StringStatement;
import dk.brics.string.intermediate.Variable;
import dk.brics.string.intermediate.VariableType;
import dk.brics.string.stringoperations.Basic;

/**
 * Converter from Jimple code to intermediate representation.
 * <p/>
 * Basic rundown of the translation process:
 * <ol>
 * <li>Create intermediate {@link Method} objects with empty bodies for each
 * method in the application.
 * <li>Create the <i>wrapper</i> method, which is a special method that calls
 * all externally visible methods with corrupt/unknown arguments.
 * <li>Create methods modelling the <tt>toString</tt>-method for each
 * application class.
 * <li>Translate the method bodies from jimple into intermediate code.
 * </ol>
 * The first three steps are handled by this class, while the fourth and most
 * complicated step is delegated to several other classes. See
 * {@link MethodTranslator} for an overview how how step four is executed.
 * 
 * @see dk.brics.string.StringAnalysis
 * @see MethodTranslator
 */
public class Jimple2Intermediate implements TranslationContext {

    /**
     * Methods being generated.
     */
    private List<Method> methods = new LinkedList<Method>();

    /**
     * Map from signatures to methods.
     */
    private Map<String, Method> sms_m = new HashMap<String, Method>();

    /**
     * For each method signature, map from real-arg number to relevant-arg
     * number.
     */
    private Map<String, int[]> sms_sa_ma = new HashMap<String, int[]>();

    /**
     * For each method signature, map from relevant-arg number to real-arg
     * number.
     */
    private Map<String, int[]> sms_ma_sa = new HashMap<String, int[]>();

    /**
     * Defines which methods are accessible from external code.
     */
    private ExternalVisibility ext;

    /**
     * The taint analysis strategy for determining taint strings
     */
    private TaintAnalysisStrategy taintAnalysisStrategy = new MethodNameTaintAnalysisStrategy(
            Collections.<String> emptyList());

    /**
     * Hotspots (all expressions if null).
     */
    private Collection<ValueBox> hotspots;

    /**
     * Map from classes to their <code>toString</code> methods.
     */
    private Map<SootClass, Method> tostring_targets = new HashMap<SootClass, Method>();

    /**
     * Map from names of a classes to their <code>toString</code> methods.
     */
    private Map<String, Method> tostring_methods = new HashMap<String, Method>();

    /**
     * Hotspots for <code>toString</code> methods. Used by
     * {@link StringAnalysis#getTypeAutomaton(VariableType)}.
     */
    private Map<SootClass, StringStatement> tostring_hotspots = new HashMap<SootClass, StringStatement>();

    /**
     * Cache of automata for primitive types and null type.
     */
    private Map<Type, Automaton> type_automaton = new HashMap<Type, Automaton>();

    /**
     * Class hierarchy, provided by Soot.
     */
    private Hierarchy class_hierarchy;

    /**
     * Map from Jimple expression to intermediate representation statement.
     */
    private Map<ValueBox, Statement> trans_map = new HashMap<ValueBox, Statement>();

    /**
     * Map from Jimple expression to source file name.
     */
    private Map<ValueBox, String> sourcefile_map = new HashMap<ValueBox, String>();

    /**
     * Map from Jimple expression to class name.
     */
    private Map<ValueBox, String> class_map = new HashMap<ValueBox, String>();

    /**
     * Map from Jimple expression to method name.
     */
    private Map<ValueBox, String> method_map = new HashMap<ValueBox, String>();

    /**
     * Map from Jimple expression to line number.
     */
    private Map<ValueBox, Integer> line_map = new HashMap<ValueBox, Integer>();
    
    private Map<Value, Variable> expression_map = new HashMap<Value, Variable>();

    private Logger log = LoggerFactory.getLogger(Jimple2Intermediate.class); // FIXME: check uses of log4j ?!

    private VariableManager variableManager;
    
    private AbstractDispatchStrategy abstractDispatchStrategy;
    
    private StaticStringTypes staticStringTypes;
    
    /**
     * Number of skipped string expressions. String constants are skipped if
     * arguments to non-application class methods that are not hotspots.
     */
    int skipped;

    private MethodTranslator methodTranslator;

    private Application application;

    /**
     * Constructs a new converter using no resolvers.
     */
    @Deprecated
    public Jimple2Intermediate(ExternalVisibility ext) {
        this(new Jimple2IntermediateFactoryImpl(ext, Collections.<Resolver> emptySet()));
    }

    /**
     * Constructs a new converter using the given resolvers.
     */
    @Deprecated
    public Jimple2Intermediate(ExternalVisibility ext,
            Collection<? extends Resolver> resolvers) {
        this(new Jimple2IntermediateFactoryImpl(ext, resolvers));
    }

    @Deprecated
    public Jimple2Intermediate(TaintAnalysisStrategy taintAnalysisStrategy,
            Collection<? extends Resolver> resolvers, ExternalVisibility ext) {
        this(new Jimple2IntermediateFactoryImpl(ext, taintAnalysisStrategy, resolvers));
    }

    public Jimple2Intermediate(Jimple2IntermediateFactory af) {
    	// LWG: allow application classes to be filtered from soot.Scene
    	this.applicationClasses = StringAnalysis.getApplicationClasses();
        this.taintAnalysisStrategy = af.getTaintAnalysisStrategy();
        this.ext = af.getExternallyVisible();
        this.methodTranslator = af.getMethodTranslator();
        this.staticStringTypes = af.getStaticStringTypes();
    }
    
    /**
     * Translates the application classes considering all expressions as
     * hotspots.
     */
    public Application translateApplicationClasses() {
        return translateApplicationClasses(null);
    }
    
    /**
     * Translates the application classes considering the given expressions as
     * hotspots.
     */
    public Application translateApplicationClasses(Collection<ValueBox> hotspots) {
        // LWG: commented out
    	/*
        applicationClasses = new ArrayList<SootClass>();
        for (SootClass clazz : Scene.v().getApplicationClasses()) {
            if (!clazz.isPhantom() && !clazz.isPhantomClass()) {// no idea what the difference between these two are
                applicationClasses.add(clazz);
            }
        }
        */
        
        this.application = new Application();
        this.variableManager = new VariableManager(application, this);
        log.info("Translating classes to intermediate form...");
        this.hotspots = hotspots;
        
        // load ALL classes we might need before creating the hierarchy!!
        Scene.v().getSootClass("java.util.Iterator");
        Scene.v().getSootClass("java.util.Collection");
        class_hierarchy = new Hierarchy();
        this.abstractDispatchStrategy = new AbstractDispatchClassHierarchy(class_hierarchy);
        skipped = 0;
        makeMethods();
        // LWG: Split the wrapper method into three methods for efficiency reason.
        // makeWrapperMethod();
        makeWrapperMethodForExternallyVisibleFields();
        makeWrapperMethodForStringFields();
        makeWrapperMethodForMethods();

        makeToStringMethods();
        translate();
        removeNops();
        return application;
    }

    public boolean isHotspot(ValueBox expr) {
        return hotspots == null || hotspots.contains(expr);
    }

    /**
     * Returns the method object for the given signature.
     */
    public Method getMethod(String signature) {
        return sms_m.get(signature);
    }

    /**
     * Returns the relevant-arg numbers for the given method.
     */
    public int[] getRelevantArgNumbers(String signature) {
        return sms_sa_ma.get(signature);
    }

    /**
     * Returns the translation map. <code>translateApplicationClasses</code>
     * must be called first.
     * 
     * @return map from Jimple expression to intermediate representation
     *         statement
     */
    public Map<ValueBox, Statement> getTranslationMap() {
        return trans_map;
    }

    /**
     * Returns the number of string constants that have been skipped because
     * they are non-hotspot arguments to non-application class methods.
     */
    public int getNumberOfExpsSkipped() {
        return skipped;
    }

    /**
     * Returns hotspots for <code>toString</code> methods.
     */
    public Map<SootClass, StringStatement> getToStringHotspotMap() {
        return tostring_hotspots;
    }

    /**
     * Returns source file name for each expression.
     */
    public Map<ValueBox, String> getSourceFileMap() {
        return sourcefile_map;
    }

    /**
     * Returns class name for each expression.
     */
    public Map<ValueBox, String> getClassNameMap() {
        return class_map;
    }

    /**
     * Returns method name for each expression.
     */
    public Map<ValueBox, String> getMethodNameMap() {
        return method_map;
    }

    /**
     * Returns line number for each expression.
     */
    public Map<ValueBox, Integer> getLineNumberMap() {
        return line_map;
    }

    /**
     * Prepares <code>Method</code> objects for application classes.
     */
    void makeMethods() {
        for (SootClass sc : getApplicationClasses()) {
            for (SootMethod sm : sc.getMethods()) {
                List<Variable> vars = new LinkedList<Variable>();
                List<Type> params = getParameterTypes(sm);
                int[] sa_ma = new int[params.size()];
                int[] ma_sa = new int[params.size()];
                int ma = 0;
                int sa = 0;
                for (Type pt : params) {
                    // if (isSType(pt)) {
                    if (fromSootType(pt) != VariableType.NONE) {
                        vars.add(makeVariable(pt));
                        sa_ma[sa] = ma;
                        ma_sa[ma] = sa;
                        ma++;
                    } else {
                        sa_ma[sa] = -1;
                    }
                    sa++;
                }
                Variable[] var_array = vars.toArray(new Variable[0]);
                Method m = new Method(application, sm.getName(), var_array);
                methods.add(m);
                sms_m.put(sm.getSignature(), m);
                sms_sa_ma.put(sm.getSignature(), sa_ma);
                sms_ma_sa.put(sm.getSignature(), ma_sa);
            }
        }
    }

    /**
     * Makes <code>toString</code> methods for basic wrapper classes and
     * application classes.
     */
    void makeToStringMethods() {
        // Make basic tostring methods
        makeBasicToStringMethod(null, "java.lang.Object", Basic
                .makeObjectString());
        makeBasicToStringMethod(BooleanType.v(), "java.lang.Boolean", Basic
                .makeBooleanString());
        makeBasicToStringMethod(ByteType.v(), "java.lang.Byte", Basic
                .makeByteString());
        makeBasicToStringMethod(CharType.v(), "java.lang.Character", Basic
                .makeCharacterString());
        makeBasicToStringMethod(DoubleType.v(), "java.lang.Double", Basic
                .makeDoubleString());
        makeBasicToStringMethod(FloatType.v(), "java.lang.Float", Basic
                .makeFloatString());
        makeBasicToStringMethod(IntType.v(), "java.lang.Integer", Basic
                .makeIntegerString());
        makeBasicToStringMethod(LongType.v(), "java.lang.Long", Basic
                .makeLongString());
        makeBasicToStringMethod(ShortType.v(), "java.lang.Short", Basic
                .makeShortString());
        
        // Make tostring methods for application classes
        // Link toString calls to the hotspots for all superclasses of the
        // receiver type
        for (SootClass ac : getApplicationClasses()) {
            Method m = new Method(application, ac.getName() + ".toString",
                    new Variable[0]);
            methods.add(m);
            tostring_methods.put(ac.getName(), m);
            Variable var = application.createVariable(VariableType.STRING);
            StringStatement spot = new StringAssignment(var, var);
            m.addStatement(spot);
            Return ret = new Return(var);
            m.addStatement(ret);
            spot.addSucc(ret);
            tostring_hotspots.put(ac, spot); // these hotspots are used by
                                             // StringAnalysis.getTypeAutomaton
            Collection<SootClass> subtypes;
            if (ac.isInterface())
                subtypes = class_hierarchy.getImplementersOf(ac);
            else
                subtypes = class_hierarchy.getSubclassesOfIncluding(ac);
            for (SootClass ac2 : subtypes) {
                if (ac2.isPhantom() || ac2.isPhantomClass() || ac2.isInterface())
                    continue;
                Method target = tostring_targets.get(ac2);
                if (target == null)
                    continue;
                Call call = new Call(var, target, new Variable[0]);
                m.addStatement(call);
                m.getEntry().addSucc(call);
                call.addSucc(spot);
            }
            
            /*for (SootClass ac2 : getApplicationClasses()) {
                if (ac2.isInterface()) // skip interfaces here
                    continue;
                if (class_hierarchy.isClassSubclassOfIncluding(ac2, ac)) {
                    // Calling tostring with a receiver of type ac,
                    // the method in class ac2 might be called.
                    // ac2 might not implement it directly,
                    // so we search upwards for the implementation
                    while (!tostring_targets.containsKey(ac2)) {
                        ac2 = ac2.getSuperclass();
                    }
                    Method target = tostring_targets.get(ac2);
                    Call call = new Call(var, target, new Variable[0]);
                    m.addStatement(call);
                    m.getEntry().addSucc(call);
                    call.addSucc(spot);
                }
            }*/
        }
    }

    /**
     * Makes a method that simulates the <code>toString</code> method of a basic
     * wrapper classes.
     */
    void makeBasicToStringMethod(Type prim, String classname, Automaton a) {
        Method m = new Method(application, classname + ".toString",
                new Variable[0]);
        SootClass c = Scene.v().getSootClass(classname);
        Variable var = application.createVariable(VariableType.STRING);
        StringStatement ss = new StringInit(var, a);
        m.addStatement(ss);
        m.getEntry().addSucc(ss);
        Return ret = new Return(var);
        m.addStatement(ret);
        ss.addSucc(ret);

        methods.add(m);
        tostring_targets.put(c, m);
        tostring_methods.put(classname, m);

        type_automaton.put(prim, a);
    }

    /**
     * Translates the method bodies.
     */
    void translate() {
        for (SootClass ac : getApplicationClasses()) {
            for (SootMethod sm : ac.getMethods()) {
                if (sm.isConcrete()) {
                    List<HotspotInfo> hotspots = methodTranslator.translateMethod(sm, this);

                    // add all the hotspots we found
                    for (HotspotInfo hot : hotspots) {
                        registerHotspot(hot);
                    }
                }
            }
        }
    }

    // LWG: Split the wrapper method into three methods for efficiency reason.
    // /**
    //  * Makes wrapper method that calls all externally visible methods in
    //  * application classes, using arbitrary arguments.
    //  */
    // void makeWrapperMethod() {
    //     Method wrapper = new Method(application, "<wrapper>", new Variable[0]);
    //     methods.add(wrapper);
        
    //     // build the wrapper's body
    //     ControlFlowBuilder cfg = new ControlFlowBuilder(wrapper);
    //     cfg.moveToStatement(wrapper.getEntry());
        
    //     // create a variable holding any string
    //     Variable anyVar = application.createVariable(VariableType.STRING);
    //     Statement assignAny = new StringInit(anyVar, Basic.makeAnyString());
    //     cfg.addStatement(assignAny);

    //     // create a variable holding the null string
    //     Variable nullVar = application.createVariable(VariableType.STRING);
    //     Statement assignNull = new StringInit(nullVar, Automatons.getNull());
    //     cfg.addStatement(assignNull);
        
    //     // initialize externally visible field variables to anything
    //     // and set string fields to "null"
    //     for (SootClass ac : getApplicationClasses()) {
    //         for (SootField field : ac.getFields()) {
    //             // String fields should be assigned to "null" because they are
    //             // exempt from the
    //             // null-pointer analysis we use for other objects
    //             if (field.getType().equals(RefType.v("java.lang.String"))) {
    //                 FieldAssignment assignment = new FieldAssignment(
    //                         variableManager.getField(field), nullVar);
    //                 cfg.addStatement(assignment);
    //             }

    //             // corrupt externally visible fields
    //             if (ext.isExternallyVisibleField(field)) {
    //                 VariableType type = fromSootType(field
    //                         .getType());

    //                 if (type == VariableType.NONE)
    //                     continue;

    //                 Variable fieldInit;

    //                 switch (type) {
    //                 case OBJECT:
    //                 case STRING:
    //                 case PRIMITIVE:
    //                     fieldInit = anyVar;
    //                     break;

    //                 case STRINGBUFFER: {
    //                     fieldInit = application.createVariable(VariableType.STRINGBUFFER);
    //                     Statement s = new StringBufferCorrupt(fieldInit);
    //                     cfg.addStatement(s);
    //                     break;
    //                 }

    //                 case ARRAY: {
    //                     fieldInit = application.createVariable(VariableType.ARRAY);
    //                     Statement s = new ArrayCorrupt(fieldInit);
    //                     cfg.addStatement(s);
    //                     break;
    //                 }
    //                 default:
    //                     throw new RuntimeException("Unknown field type " + type);
    //                 }// switch

    //                 FieldAssignment assignment = new FieldAssignment(variableManager.getField(field), fieldInit);
    //                 cfg.addStatement(assignment);
    //             }
    //         }
    //     }
        
    //     // split control here, and call a random externally visible method
    //     cfg.startBranch();
        
    //     // call externally visible methods
    //     for (SootClass ac : getApplicationClasses()) {
    //         for (SootMethod sm : ac.getMethods()) {
    //             if (ext.isExternallyVisibleMethod(sm)) {
    //                 Method m = sms_m.get(sm.getSignature());
    //                 Variable[] params = m.getEntry().params;
    //                 Variable[] args = new Variable[params.length];
    //                 for (int i = 0; i < params.length; i++) {
    //                     Variable arg = application.createVariable(params[i].getType());
    //                     args[i] = arg;
    //                     Statement s;
    //                     switch (arg.getType()) {
    //                     case STRING:
    //                         s = new StringInit(arg, Basic.makeAnyString());
    //                         break;
    //                     case STRINGBUFFER:
    //                         s = new StringBufferCorrupt(arg);
    //                         break;
    //                     case ARRAY:
    //                         s = new ArrayCorrupt(arg);
    //                         break;
    //                     case PRIMITIVE:
    //                         // TODO: Integers can contain two characters, right? look deeper into which primitive type
    //                         s = new PrimitiveInit(arg, Automaton.makeAnyChar());
    //                         break;
    //                     default:
    //                         s = new ObjectCorrupt(arg);
    //                         // (case NONE or NULL cannot occur because such
    //                         // parameters do not get created for intermediate
    //                         // methods)
    //                     }
    //                     cfg.addStatement(s);
    //                 }
    //                 Variable retvar = makeVariable(sm.getReturnType());
    //                 Call c = new Call(retvar, m, args);
    //                 cfg.addStatement(c);
    //                 // If this is toString, remember the return value
    //                 if (sm.getName().equals("toString")
    //                         && sm.getParameterCount() == 0
    //                         && sm.getReturnType().toString().equals("java.lang.String")) {
    //                     tostring_targets.put(ac, m);
    //                 }
                    
    //                 cfg.useBranch();
    //             }
    //         }
    //     }
        
    //     // also add the possibility of no method being called.
    //     // in case the application has no externally visible methods, we still want
    //     // the return statement to be reachable so we don't create a malformed program.
    //     cfg.useBranch();
        
    //     cfg.endBranch();
        
    //     // add a return statement
    //     Return ret = new Return(application.createVariable(VariableType.NONE));
    //     cfg.addStatement(ret);
    // }

    // LWG: New. Factored from makeWrapperMethod().
    /**
     * Makes wrapper method that initializes externally visible field variables to anything
     */
    void makeWrapperMethodForExternallyVisibleFields() {
        Method wrapper = new Method(application, "<wrapper>_f_ev", new Variable[0]);
        methods.add(wrapper);
        
        // build the wrapper's body
        ControlFlowBuilder cfg = new ControlFlowBuilder(wrapper);
        cfg.moveToStatement(wrapper.getEntry());
        
        // create a variable holding any string
        Variable anyVar = application.createVariable(VariableType.STRING);
        Statement assignAny = new StringInit(anyVar, Basic.makeAnyString());
        cfg.addStatement(assignAny);

        // initialize externally visible field variables to anything
        for (SootClass ac : getApplicationClasses()) {
            for (SootField field : ac.getFields()) {
                // corrupt externally visible fields
                if (ext.isExternallyVisibleField(field)) {
                    VariableType type = fromSootType(field
                            .getType());

                    if (type == VariableType.NONE)
                        continue;

                    Variable fieldInit;

                    switch (type) {
                    case OBJECT:
                    case STRING:
                    case PRIMITIVE:
                        fieldInit = anyVar;
                        break;

                    case STRINGBUFFER: {
                        fieldInit = application.createVariable(VariableType.STRINGBUFFER);
                        Statement s = new StringBufferCorrupt(fieldInit);
                        cfg.addStatement(s);
                        break;
                    }

                    case ARRAY: {
                        fieldInit = application.createVariable(VariableType.ARRAY);
                        Statement s = new ArrayCorrupt(fieldInit);
                        cfg.addStatement(s);
                        break;
                    }
                    default:
                        throw new RuntimeException("Unknown field type " + type);
                    }// switch

                    FieldAssignment assignment = new FieldAssignment(variableManager.getField(field), fieldInit);
                    cfg.addStatement(assignment);
                }
            }
        }
        
        // add a return statement
        Return ret = new Return(application.createVariable(VariableType.NONE));
        cfg.addStatement(ret);
    }

    // LWG: New. Factored from makeWrapperMethod().
    /**
     * Makes wrapper method that initializes string field variables to "null".
     */
    void makeWrapperMethodForStringFields() {
        Method wrapper = new Method(application, "<wrapper>_f_str", new Variable[0]);
        methods.add(wrapper);
        
        // build the wrapper's body
        ControlFlowBuilder cfg = new ControlFlowBuilder(wrapper);
        cfg.moveToStatement(wrapper.getEntry());
        
        // create a variable holding any string
        Variable anyVar = application.createVariable(VariableType.STRING);
        Statement assignAny = new StringInit(anyVar, Basic.makeAnyString());
        cfg.addStatement(assignAny);

        // create a variable holding the null string
        Variable nullVar = application.createVariable(VariableType.STRING);
        Statement assignNull = new StringInit(nullVar, Automatons.getNull());
        cfg.addStatement(assignNull);
        
        // set string fields to "null"
        for (SootClass ac : getApplicationClasses()) {
            for (SootField field : ac.getFields()) {
                // String fields should be assigned to "null" because they are
                // exempt from the
                // null-pointer analysis we use for other objects
                if (field.getType().equals(RefType.v("java.lang.String"))) {
                    FieldAssignment assignment = new FieldAssignment(
                            variableManager.getField(field), nullVar);
                    cfg.addStatement(assignment);
                }
            }
        }
        
        // add a return statement
        Return ret = new Return(application.createVariable(VariableType.NONE));
        cfg.addStatement(ret);
    }

    // LWG: New. Factored from makeWrapperMethod().
    /**
     * Makes wrapper method that calls all externally visible methods in
     * application classes, using arbitrary arguments.
     */
    void makeWrapperMethodForMethods() {
        Method wrapper = new Method(application, "<wrapper>_m", new Variable[0]);
        methods.add(wrapper);
        
        // build the wrapper's body
        ControlFlowBuilder cfg = new ControlFlowBuilder(wrapper);
        cfg.moveToStatement(wrapper.getEntry());
        
        // split control here, and call a random externally visible method
        cfg.startBranch();
        
        // call externally visible methods
        for (SootClass ac : getApplicationClasses()) {
            for (SootMethod sm : ac.getMethods()) {
                if (ext.isExternallyVisibleMethod(sm)) {
                    Method m = sms_m.get(sm.getSignature());
                    Variable[] params = m.getEntry().params;
                    Variable[] args = new Variable[params.length];
                    for (int i = 0; i < params.length; i++) {
                        Variable arg = application.createVariable(params[i].getType());
                        args[i] = arg;
                        Statement s;
                        switch (arg.getType()) {
                        case STRING:
                            s = new StringInit(arg, Basic.makeAnyString());
                            break;
                        case STRINGBUFFER:
                            s = new StringBufferCorrupt(arg);
                            break;
                        case ARRAY:
                            s = new ArrayCorrupt(arg);
                            break;
                        case PRIMITIVE:
                            // TODO: Integers can contain two characters, right? look deeper into which primitive type
                            s = new PrimitiveInit(arg, Automaton.makeAnyChar());
                            break;
                        default:
                            s = new ObjectCorrupt(arg);
                            // (case NONE or NULL cannot occur because such
                            // parameters do not get created for intermediate
                            // methods)
                        }
                        cfg.addStatement(s);
                    }
                    Variable retvar = makeVariable(sm.getReturnType());
                    Call c = new Call(retvar, m, args);
                    cfg.addStatement(c);
                    // If this is toString, remember the return value
                    if (sm.getName().equals("toString")
                            && sm.getParameterCount() == 0
                            && sm.getReturnType().toString().equals("java.lang.String")) {
                        tostring_targets.put(ac, m);
                    }
                    
                    cfg.useBranch();
                }
            }
        }
        
        // also add the possibility of no method being called.
        // in case the application has no externally visible methods, we still want
        // the return statement to be reachable so we don't create a malformed program.
        cfg.useBranch();
        
        cfg.endBranch();
        
        // add a return statement
        Return ret = new Return(application.createVariable(VariableType.NONE));
        cfg.addStatement(ret);
    }

    /**
     * Removes all <code>Nop</code>s in the generated code.
     */
    void removeNops() {
    	Set<Statement> protectedNops = new HashSet<Statement>();
        for (Method m : methods) {
        	protectedNops.clear();
        	// assertions referring to a nop statement must have their target updated to the nop's predecessor,
        	// or in case there are multiple predecessors, the nop must not be removed
        	for (Statement s : m.getStatements()) {
        		if (s instanceof AssertStatement) {
        			AssertStatement a = (AssertStatement)s;
        			Statement target = a.targetStatement;
        			while (target instanceof Nop && target.getPreds().size() == 1) {
        				target = target.getPreds().iterator().next();
        				a.targetStatement = target;
        			}
        			if (target instanceof Nop) {
        				protectedNops.add(target);
        			}
        		}
        	}
        	
            for (Statement s : new ArrayList<Statement>(m.getStatements())) {
                if (s instanceof Nop && !protectedNops.contains(s)) {
                    m.removeNop((Nop) s);
                }
            }
        }
    }

    /**
     * Makes a new variable, using the given Soot type.
     */
    Variable makeVariable(Type t) {
        return application.createVariable(fromSootType(t));
    }

    /**
     * Returns the type corresponding to the given Soot value.
     */
    VariableType getValueType(Value v) {
        return getType(v.getType());
    }

    /**
     * Returns the type corresponding to the given Soot type.
     */
    VariableType getType(Type type) {
        return fromSootType(type);
    }

    public List<SootMethod> getTargetsOf(InstanceInvokeExpr expr) {
        return abstractDispatchStrategy.getTargetsOf(expr);
    }

    public Method getToStringMethod(SootClass c) {
        return tostring_methods.get(c.getName());
    }

    public Automaton getTypeAutomaton(Type t) {
        if (t instanceof PrimType) {
            return type_automaton.get(t);
        } else if (t instanceof NullType) {
            return Automaton.makeString("null");
        } else {
            return null;
        }
    }

    /**
     * Checks whether the given class is an application class.
     */
    public boolean isApplicationClass(SootClass c) {
        for (SootClass ac : getApplicationClasses()) {
            if (c.getName().equals(ac.getName())) {
                return true;
            }
        }
        return false;
    }

    private void registerHotspot(HotspotInfo hotspot) {
        ValueBox box = hotspot.getBox();
        trans_map.put(box, hotspot.getStatement());
        sourcefile_map.put(box, hotspot.getSourcefile());
        class_map.put(box, hotspot.getClassName());
        method_map.put(box, hotspot.getMethodName());
        line_map.put(box, hotspot.getLineNumber());
    }

    /**
     * Returns the parameter variable for the given relevant-arg number in the
     * current method.
     */
    public Variable getParameter(SootMethod sm, int index) {
        int ma = getRelevantArgNumbers(sm.getSignature())[index];
        if (ma != -1) {
            return getMethod(sm.getSignature()).getEntry().params[ma];
        } else {
            return application.createVariable(VariableType.NONE);
        }
    }

    public TaintAnalysisStrategy getTaintAnalysisStrategy() {
        return taintAnalysisStrategy;
    }
    
    private Collection<SootClass> applicationClasses;

    private Collection<SootClass> getApplicationClasses() {
        return applicationClasses;
    }

    @SuppressWarnings("unchecked")
    private List<Type> getParameterTypes(SootMethod sm) {
        return sm.getParameterTypes();
    }

    public Variable getParameter(SootMethod sm, ParameterRef ref) {
        return getParameter(sm, ref.getIndex());
    }

    public Method getMethod(SootMethod method) {
        return getMethod(method.getSignature());
    }

    public Application getApplication() {
        return application;
    }

    public VariableManager getVariableManager() {
        return variableManager;
    }
    
    public void setExpressionVariable(Value value, Variable variable) {
        expression_map.put(value, variable);
    }
    
    public Variable getExpressionVariable(Value value) {
        return expression_map.get(value);
    }

    public Automaton getFieldType(SootField field) {
        return staticStringTypes.getFieldType(field);
    }

    public Automaton getMethodReturnType(SootMethod method) {
        return staticStringTypes.getMethodReturnType(method);
    }

    public Automaton getParameterType(SootMethod method, int paramIndex) {
        return staticStringTypes.getParameterType(method, paramIndex);
    }
    
    public boolean isSubtypeOf(SootClass a, SootClass b) {
    	if (a.equals(b))
    		return true;
    	if (b.getType().equals(RefType.v("java.lang.Object")))
    		return true;
    	if (a.isInterface()) {
    		return b.isInterface() && class_hierarchy.isInterfaceSubinterfaceOf(a, b);
    	}
    	if (b.isInterface()) {
    		return class_hierarchy.getImplementersOf(b).contains(a);
    	}
    	return class_hierarchy.isClassSubclassOf(a, b);
    }
    
    /**
     * Given the static type of a variable, returns the most specific variable type
     * we can assign to it.
     * <p/>
     * For example, a variable of type <tt>Cloneable</tt> might be an array, so this returns
     * <tt>ARRAY</tt> if the argument equals <tt>java.lang.Cloneable</tt>. On the other hand, if
     * the argument is <tt>java.io.Serializable</tt>, it returns <tt>OBJECT</tt> because all
     * the interesting types implement <tt>Serializable</tt>.
     * @param type a soot type
     * @return a variable type. <tt>null</tt> and {@link VariableType#NULL} are never returned.
     */
    public VariableType fromSootType(Type type) {
        if (type instanceof RefType) {
        	SootClass clazz = ((RefType)type).getSootClass();
        	if (isSubtypeOf(clazz, Scene.v().getSootClass("java.util.Collection"))
        			|| isSubtypeOf(clazz, Scene.v().getSootClass("java.util.Iterator"))) {
        		return VariableType.ARRAY;
        	}
        	// otherwise, look in the table
            String className = ((RefType)type).getClassName();
            return fromCanonicalName(className);
        } else if (type instanceof ArrayType) {
            // TODO because of covariant arrays, we currently assume String[]. 
            // find out exactly which array types might be a covariant of String[]. (for example int[] cannot be)
            // XXX now that primitive arrays are also supported, char[], etc. is actually allowed
            return VariableType.ARRAY;  
        } else if (type instanceof NullType) {
            return VariableType.NULL; 
        } else if (type instanceof PrimType) {
        	// FIXME ignore int,long,float,double here? only 16-bit primitives are suported anyway
            return VariableType.PRIMITIVE;
        }
        return VariableType.NONE;
    }
    
    /**
     * Given the static type of a variable, returns the most specific variable type
     * we can assign to it.
     * <p/>
     * For example, a variable of type <tt>Cloneable</tt> might be an array, so this returns
     * <tt>ARRAY</tt> if the argument equals <tt>java.lang.Cloneable</tt>. On the other hand, if
     * the argument is <tt>java.lang.Serializable</tt>, it returns <tt>OBJECT</tt> because all
     * the interesting types implement <tt>Serializable</tt>.
     * @param canonicalName fully qualified name of a Java class.
     * @return a variable type. <tt>NONE</tt> is (rightfully) returned for unknown types. <tt>null</tt> is never returned.
     */
    private static VariableType fromCanonicalName(String canonicalName) {
        VariableType type = javaTypesToVariableTypes.get(canonicalName);
        if (type == null)
            return VariableType.NONE;
        return type;
    }
    
    private static final HashMap<String, VariableType> javaTypesToVariableTypes;
    static {
        javaTypesToVariableTypes = new HashMap<String, VariableType>();
        javaTypesToVariableTypes.put("java.lang.Object", VariableType.OBJECT);
        javaTypesToVariableTypes.put("java.io.Serializable", VariableType.OBJECT);
        javaTypesToVariableTypes.put("java.lang.String", VariableType.STRING);
        javaTypesToVariableTypes.put("java.lang.StringBuffer", VariableType.STRINGBUFFER);
        javaTypesToVariableTypes.put("java.lang.StringBuilder", VariableType.STRINGBUFFER);
        javaTypesToVariableTypes.put("java.lang.Appendable", VariableType.STRINGBUFFER);
        javaTypesToVariableTypes.put("java.lang.Cloneable", VariableType.ARRAY);
        javaTypesToVariableTypes.put("java.lang.CharSequence", VariableType.OBJECT);
        //javaTypesToVariableTypes.put("java.lang.Comparable", STRING);     // String implements Comparable<String>
        
        javaTypesToVariableTypes.put("java.lang.AbstractStringBuilder", VariableType.STRINGBUFFER);
        
        // collections
        javaTypesToVariableTypes.put("java.util.Collection", VariableType.ARRAY);
        javaTypesToVariableTypes.put("java.util.List", VariableType.ARRAY);
        javaTypesToVariableTypes.put("java.util.ArrayList", VariableType.ARRAY);
        javaTypesToVariableTypes.put("java.util.Vector", VariableType.ARRAY);
        javaTypesToVariableTypes.put("java.util.LinkedList", VariableType.ARRAY);
        javaTypesToVariableTypes.put("java.util.Set", VariableType.ARRAY);
        javaTypesToVariableTypes.put("java.util.HashSet", VariableType.ARRAY);
        javaTypesToVariableTypes.put("java.util.LinkedHashSet", VariableType.ARRAY);
        javaTypesToVariableTypes.put("java.util.TreeSet", VariableType.ARRAY);
        
        // iterators
        javaTypesToVariableTypes.put("java.util.Iterator", VariableType.ARRAY);
        javaTypesToVariableTypes.put("java.util.ListIterator", VariableType.ARRAY);

        // AbstractStringBuilder is a package-private class in the Java API that
        // Soot may decide to use as variable type. Both StringBuffer and StringBuilder extend it.
        
        // Comparable has been commented out because Strings are immutable, so we
        // don't care which strings might be aliases
    }
    
}
