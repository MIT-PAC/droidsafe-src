package droidsafe.analyses.value;

import droidsafe.analyses.pta.ContextType;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.pta.PTAContext;
import droidsafe.analyses.pta.PointsToAnalysisPackage;
import droidsafe.analyses.pta.cg.CGContextVisitor;
import droidsafe.analyses.pta.cg.CGVisitorEntryAnd1CFA;
import droidsafe.analyses.pta.cg.CallGraphTraversal;
import droidsafe.analyses.value.primitives.StringVAModel;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.main.Config;
import droidsafe.speclang.Method;
import droidsafe.transforms.JSAResultInjection;
import droidsafe.utils.SootUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.AssignStmt;
import soot.jimple.Constant;
import soot.jimple.DoubleConstant;
import soot.jimple.FloatConstant;
import soot.jimple.InstanceFieldRef;
import soot.jimple.IntConstant;
import soot.jimple.LongConstant;
import soot.jimple.StringConstant;
import soot.jimple.Stmt;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.pta.IAllocNode;
import soot.jimple.toolkits.pta.IStringConstantNode;
import soot.RefType;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Type;
import soot.Value;

/** 
 * Determine soundly and conservatively the possible values of fields of security sensitive  Android objects such as 
 * Intents, Strings, and Uris.
 *
 * This will make it easier for an analyst to determine if a particular security-sensitive API call that one of these
 * objects interacts with is used maliciously by providing the necessary context.
 * 
 * @author dpetters
 */
public class ValueAnalysis implements CGContextVisitor {
    //if true then for string values, only track jsa resolved strings (so hot spot strings)
    public static final boolean ONLY_TRACK_JSA_STRINGS = true;
    public static ContextType CONTEXT_TYPE = ContextType.NONE;
    
    /** Singleton for analysis */
    private static ValueAnalysis am;

    /** string to represent sets of unknown values */
    public static final String UNKNOWN_VALUES_STRING = "ANYTHING";

    /** 
     * keys are the objects that we can and want to model (they are new expressions) 
     * The value is the Model object which simulates that object. 
     */
    private Map<Object, VAModel> allocNodeToVAModelMap; 
    
    private Set<Type> vaModeledTypesAndParents;

    private Map<SootClass, Set<SootField>> classesAndFieldsToModel;

    /** va errors file used to help figure out what to model */
    public static FileWriter vaErrorsLog;

    /** va stats file */
    public static FileWriter vaResultsLog;

    /** Generic logger */
    private static final Logger logger = LoggerFactory.getLogger(ValueAnalysis.class);

    /** The package of the value analysis models */
    public static final String MODEL_PACKAGE = "droidsafe.analyses.value.VAResultContainerClasses";

    /** The prefix that is prepended to fully qualified value analysis models */
    public static final String MODEL_PACKAGE_PREFIX = MODEL_PACKAGE + ".";
    /** list of base classes that we will model taken from the annotations in the source code. 
     * Can be queried before va is run or created.
     */
    private static Set<SootClass> baseClassesToModel;

    /** Private constructor to enforce singleton pattern */
    private ValueAnalysis() {
        this.allocNodeToVAModelMap = new LinkedHashMap<Object, VAModel>();
        this.classesAndFieldsToModel = VAResultContainerClassGenerator.getClassesAndFieldsToModel(true);
        this.vaModeledTypesAndParents = new HashSet<Type>();
    }

    /**
     * Before VA is run, this method will all base classes that will be tracked (have at least one field 
     * tracked by VA).
     */
    public static Set<SootClass> baseClassesToModel() {
        if (baseClassesToModel == null) {
            baseClassesToModel = 
                VAResultContainerClassGenerator.getClassesAndFieldsToModel(false).keySet();
        }

        return baseClassesToModel;
    }

    /**
     * Getter for analysis result.  Jimple NewExpr -> VAModel.
     */
    public Map<Object, VAModel> getResults() {
        return this.allocNodeToVAModelMap;
    }

    /**
     * Getter for analysis result
     */
    public Map<SootClass, Set<SootField>> getClassesAndFieldsToModel() {
        return this.classesAndFieldsToModel;
    }

    /**
     * Return true if this alloc node has an analysis result (and is not invalidated)
     */
    public boolean hasResult(IAllocNode node) {
        Object newExpr = PTABridge.v().getNewExpr(node);

        return this.allocNodeToVAModelMap.containsKey(newExpr) &&
                !this.allocNodeToVAModelMap.get(newExpr).invalidated();
    }

    /**
     * Return the ModeledObject result for a given alloc node.
     */
    public VAModel getResult(IAllocNode node) {
        Object newExpr = PTABridge.v().getNewExpr(node);

        return this.allocNodeToVAModelMap.get(newExpr);
    }

    /** access to the singleton instance */
    public static ValueAnalysis v() {
        return am;
    }

    public static void setup() {
        if (am == null)
            am = new ValueAnalysis();
    }

    /** run the analysis to fixed point */
    public static void run() {
        if (PTABridge.v() == null) {
            logger.error("The GeoPTA pass has not been run. Value analysis requires it.");
            droidsafe.main.Main.exit(1);
        }      

        try {
            vaErrorsLog = new FileWriter(Project.v().getOutputDir() + File.separator 
                + "va-errors.log");
        } catch (Exception e) {
            logger.warn("Unable to open va-errors.log:", e);
        }

        try {
            vaResultsLog = new FileWriter(Project.v().getOutputDir() + File.separator 
                + "va-results.log");
        } catch (Exception e) {
            logger.warn("Unable to open va-results.log: ", e);
        }

        am.createObjectModels();

        //run with one cfa if using geo
        if (Config.v().POINTS_TO_ANALYSIS_PACKAGE == PointsToAnalysisPackage.GEOPTA)
            CONTEXT_TYPE = ContextType.ONE_CFA;
        
        CallGraphTraversal.acceptContext(am, CONTEXT_TYPE);;
                                
        am.logResults();

        try {
            am.vaErrorsLog.close();
        } catch (IOException e){
            logger.warn("Unable to close the va-errors.log file.", e);
        }

        try {
            am.vaResultsLog.close();
        } catch (IOException e){
            logger.warn("Unable to close the va-results.log file.", e);
        }
    }
    
    public void createObjectModels() {
        for(IAllocNode allocNode : PTABridge.v().getAllAllocNodes()) {
            Object newExpr = PTABridge.v().getNewExpr(allocNode);
            createObjectModel(allocNode, newExpr);    
        }
    }

    public void createObjectModel(IAllocNode allocNode, Object newExpr) {
        if(!(allocNode.getType() instanceof RefType)) {
            this.logError(allocNode.toString());
            return;
        }
        RefType refType = (RefType)allocNode.getType();

        String errorLogEntry = "Couldn't model an instance of the " + refType.getSootClass().getName() + " ";

        SootClass sootClass = refType.getSootClass();

        Class<?> cls = null;
        while(sootClass.hasSuperclass() && cls == null) {
            try {
                cls = VAUtils.getDroidsafeClass(sootClass);
            } catch(ClassNotFoundException e) {
                errorLogEntry += e.toString();
                this.logError(errorLogEntry);
                sootClass = sootClass.getSuperclass();
            }
        }

        if (cls == null) {
            return;
        }

        RefVAModel model = null;
        Constructor<?> ctor;
        try {
            ctor = cls.getConstructor(Object.class);
        } catch(NoSuchMethodException e) {
            errorLogEntry += "Available constructors are:\n";
            for (Constructor<?> constructor : cls.getConstructors()){
                errorLogEntry += constructor + "\n";
            }
            errorLogEntry += e.toString();
            logError(errorLogEntry);
            return;
        } catch(SecurityException e) {
            errorLogEntry += e.toString();
            logError(errorLogEntry);
            return;
        }

        try {
            model = (RefVAModel)ctor.newInstance(newExpr);
        } catch(Exception e){
            errorLogEntry += e.toString();
            logError(errorLogEntry);
            return;
        }
        if(model != null) {
            this.allocNodeToVAModelMap.put(newExpr, model);
            RefType refT = (RefType)allocNode.getType();
            this.vaModeledTypesAndParents.add(refT);
            SootClass allocType = refT.getSootClass();
            for (SootClass parent : SootUtils.getParents(allocType)) {
                this.vaModeledTypesAndParents.add(RefType.v(parent));
            }
        }
    }

    @Override
    public void visit(SootMethod sootMethod, PTAContext ptaContext) {
              
        if(!sootMethod.isConcrete())
            return;

        if(!sootMethod.hasActiveBody())
            sootMethod.retrieveActiveBody();
        
        for(Iterator stmts = sootMethod.getActiveBody().getUnits().iterator(); stmts.hasNext();) {
            Stmt stmt = (Stmt) stmts.next();
            if(stmt instanceof AssignStmt) {
                AssignStmt assignStmt = (AssignStmt)stmt;
                Value leftOp = assignStmt.getLeftOp();
                Value rightOp = assignStmt.getRightOp();
                if(leftOp instanceof InstanceFieldRef) {
                    InstanceFieldRef instanceFieldRef = (InstanceFieldRef)leftOp;
                    Value baseValue = instanceFieldRef.getBase();
                    //use a quick type search to see if we need to look at the pta for this value
                    //if its types is not possibly one that could be tracked, then continue;
                    if (!vaModeledTypesAndParents.contains(baseValue.getType())) {
                        continue;
                    }
                                        
                    //this call here is expensive!!
                    Set<? extends IAllocNode> baseAllocNodes = PTABridge.v().getPTSet(baseValue, ptaContext);
                    for(IAllocNode allocNode : baseAllocNodes) {
                        Object newExpr = PTABridge.v().getNewExpr(allocNode);
                        VAModel vaModel = this.allocNodeToVAModelMap.get(newExpr);
                        if(vaModel != null) {
                            Class<?> c = vaModel.getClass();
                            String fieldName = instanceFieldRef.getField().getName();
                            try {
                                Field field = c.getField(fieldName);
                                try {
                                    Object fieldObject = field.get(vaModel);
                                    VAModel fieldObjectVAModel = (VAModel)fieldObject;
                                    if(fieldObjectVAModel instanceof PrimVAModel) {
                                        PrimVAModel fieldPrimVAModel = (PrimVAModel)fieldObjectVAModel;
                                        if (fieldPrimVAModel instanceof StringVAModel) {
                                            handleString(assignStmt, fieldPrimVAModel, ptaContext);
                                        } else  {
                                            //primitive, but not string primitive
                                            if(rightOp instanceof Constant) {
                                                Constant rightOpConstant = (Constant)rightOp;
                                                if(rightOpConstant instanceof IntConstant) {
                                                    IntConstant intConstant = (IntConstant)rightOpConstant;
                                                    fieldPrimVAModel.addValue(intConstant.value);
                                                } else if(rightOpConstant instanceof LongConstant) {
                                                    LongConstant longConstant = (LongConstant)rightOpConstant;
                                                    fieldPrimVAModel.addValue(longConstant.value);
                                                } else if(rightOpConstant instanceof DoubleConstant) {
                                                    DoubleConstant doubleConstant = (DoubleConstant)rightOpConstant;
                                                    fieldPrimVAModel.addValue(doubleConstant.value);
                                                } else if(rightOpConstant instanceof FloatConstant) {
                                                    FloatConstant floatConstant = (FloatConstant)rightOpConstant;
                                                    fieldPrimVAModel.addValue(floatConstant.value);
                                                } else {
                                                    System.out.println("Unhandled constant case: " + 
                                                            rightOpConstant.getClass());
                                                    System.exit(1);
                                                }
                                            } else {
                                                fieldPrimVAModel.invalidate();
                                            }
                                        }
                                    }
                                } catch(IllegalAccessException e) {
                                }
                            } catch(NoSuchFieldException e) {
                            }
                        }
                    }
                }
            }
        }
    }


    /**
     * Handle case where type for assignment is a string
     */
    private void handleString(AssignStmt assignStmt, PrimVAModel fieldPrimVAModel, PTAContext eventContext) {
        //Found string
        Set<? extends IAllocNode> rhsNodes;

        //get the string nodes the rhs expression could possibly point to
        if (assignStmt.getRightOp() instanceof StringConstant) {
            //if a direct string constant, then get the string constant node from pta
            Set<IAllocNode> nodes = new HashSet<IAllocNode>();
            nodes.add(PTABridge.v().getAllocNode(assignStmt.getRightOp()));
            rhsNodes = nodes;
        } else {
            //if not a string constant, then query pta
            rhsNodes = PTABridge.v().getPTSet(assignStmt.getRightOp(), eventContext);
        }

        for(IAllocNode rhsNode : rhsNodes) {
            boolean knownValue = false;
            if(rhsNode instanceof IStringConstantNode) {
                //logger.info("handleString: {}", rhsNode.getMethod());
                StringConstant sc = (StringConstant)rhsNode.getNewExpr();
                //are we tracking all strings, or just the strings injected by jsa for api calls in user code
                if (!ONLY_TRACK_JSA_STRINGS || JSAResultInjection.trackedStringConstants.contains(sc) || rhsNodes.size() == 1) {
                    String value = ((IStringConstantNode)rhsNode).getString();
                    value = value.replaceAll("(\\r|\\n)", "");
                    value = value.replace("\"", "");
                    value = value.replace("\\uxxxx", "");
                    fieldPrimVAModel.addValue(value);
                    knownValue = true;
                }
            }
            if (!knownValue) {
                // all strings weren't constants, write unknown value
                ValueAnalysis.logError(fieldPrimVAModel.toString() + 
                    " the value it is assigned, " + 
                    rhsNode + " is not a constant. Contained values beforehand: " + 
                    fieldPrimVAModel.getValues());
                fieldPrimVAModel.addValue(UNKNOWN_VALUES_STRING);
            }
        }                           
    }


    /**
     * Helper method to write to the file where we log all errors we encounter during value analysis
     */
    public static void logError(String logEntry) {
        /*
        try {
            vaErrorsLog.write(logEntry + "\n");
        } catch (IOException ioe) {
            logger.warn("Unable to write to the va-errors.log file.", ioe);
        }
         */
    }

    /**
     * Helper method to write to the file where we log all the value analysis statistics
     */
    public static void logResult(String logEntry) {
        try {
            vaResultsLog.write(logEntry + "\n");
        } catch (IOException ioe) {
            //logger.warn("Unable to write to the va-results.log file.", ioe);
        }
    }

    /**
     * Log the results of the modeling
     */
    private void logResults() {
        for(Map.Entry<Object, VAModel> entry : allocNodeToVAModelMap.entrySet()) {
            logResult("NewExpr: " + entry.getKey().toString());
            logResult("AllocNode: " + PTABridge.v().getAllocNode(entry.getKey()));
            logResult("Model: " + entry.getValue().toStringPretty());
        }
    }
}
