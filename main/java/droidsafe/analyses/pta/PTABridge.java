package droidsafe.analyses.pta;

import java.io.PrintStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.utils.CannotFindMethodException;
import soot.G;
import soot.PointsToSet;
import soot.Scene;
import soot.SootField;
import soot.SootMethod;
import soot.Type;
import soot.Value;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.spark.geom.helper.ContextTranslator;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.spark.pag.MethodPAG;

/**
 * This abstract class defines methods that an underlying points to analysis framework must implement
 * to be used by DroidSafe.
 * 
 * @author mgordon
 *
 */
public abstract class PTABridge {
    /** Logger field */
    private static final Logger logger = LoggerFactory.getLogger(PTABridge.class);
    /** Singleton for PTA bridge */
    private static PTABridge v;

    private static PointsToAnalysisPackage myPackage;
    
    public PointsToAnalysisPackage getPackage() {
        return myPackage;
    }
    
    /**
     * Perform any specific cleanup required for specific bridge
     */
    protected abstract void releaseInternal();
    
    /**
     * Reset the PTA and get it ready for another run.
     */
    public static void release() {
       if (v != null) v.releaseInternal();
        v = null;

        Scene.v().releaseCallGraph();
        Scene.v().releasePointsToAnalysis();
        Scene.v().releaseReachableMethods();

        G.v().MethodPAG_methodToPag = new HashMap<SootMethod, MethodPAG>();

        System.gc();
        System.gc();
    }
    
    /** Internal run method for implementing analysis */
    protected abstract void runInternal();

    /** Run the points to analysis, if an analysis is to be added, it must be added here in the if statement */
    public static void run(PointsToAnalysisPackage pta) {
        myPackage = pta;
        if (pta == PointsToAnalysisPackage.GEOPTA) {
            v = new GeoPTA();
            v.runInternal();
        } else if (pta == PointsToAnalysisPackage.SPARK) {
            v = new SparkPTA();
            v.runInternal();
        }  else if (pta == PointsToAnalysisPackage.PADDLE) {
            v = new PaddlePTA();
            v.runInternal();
        } else {
            logger.error("Invalid points to analysis package: {}", pta);
            droidsafe.main.Main.exit(1);
        }
    }
    
    /** Return the static singleton for the pta */
    public static PTABridge v() {
        return v;
    }
    
    /** 
     * Can the first argument type be cast to the second argument type?
     */
    public abstract boolean isLegalCast(Type objType, Type refType);

    /** return the alloc node of the PAG representing the new expr */
    public abstract AllocNode getAllocNode(Object newExpr);
    
    /** Get all the alloc nodes of the PAG */
    public abstract Set<AllocNode> getAllAllocNodes();
    
    /** return the new expression in the IR that this alloc node represents */
    public abstract Object getNewExpr(AllocNode an);
    
    /** Return a list of all reachable methods based on PTA */
    public abstract Set<SootMethod> getAllReachableMethods() ;
    
    /** Return true if this given method is reachable given the last PTA run */
    public abstract boolean isReachableMethod(SootMethod method);
    
    /** Return true if this value is a pointer value that is in the PAG */
    public abstract boolean isPointer(Value val);
    
    /** Return the possible dynamic types of the pointer value */
    public abstract Set<Type> getTypes(Value val);
    
    /** Return the possible dynamic types of the pointer value given the context */
    public abstract Set<Type> getTypes(Value val, PTAContext context);
    
    /** Return the possible alloc nodes that the given pointer could point to, insensitive */
    public abstract Set<AllocNode> getPTSet(Value val);
    
    /**
     * Content Insensitive query of field reference with allocnode and field. 
     */
    public abstract Set<AllocNode> getPTSet(AllocNode node, SootField field);
    
    /** Return the possible alloc nodes that the given points to could point to given the context */
    public abstract Set<AllocNode> getPTSet(Value val, PTAContext context);
    
    /** Return the possible alloc nodes that the given alloc node could point to, with alloc node arg an array */
    public abstract Set<AllocNode> getPTSetOfArrayElement(AllocNode nodes);
    
    /** Resolve the targets of the invoke statement given the PTA and an insensitive search */
    public abstract Collection<SootMethod> resolveInvoke(InvokeExpr invoke)  throws CannotFindMethodException;
    
    /** Resolve the targets of the invoke statement given the PTA and the context*/
    public abstract Collection<SootMethod> resolveInvoke(InvokeExpr invoke, PTAContext context) 
        
         throws CannotFindMethodException;
    
    /**
     * Use the PTA to resolve the set of methods that an instance invoke could call.  In this
     * version, use the context insensitive PTA result.
     * 
     * If the method cannot be found, then throw a specialized exception.
     */
    public Collection<SootMethod> resolveInstanceInvoke(InstanceInvokeExpr invoke)
            throws CannotFindMethodException {
        return resolveInstanceInvokeMap(invoke).values();
    }
    
    /**
     * Use the PTA to resolve the set of methods that an instance invoke could call.  
     * 
     * If the method cannot be found, then throw a specialized exception.
     */
    public Collection<SootMethod> resolveInstanceInvoke(InstanceInvokeExpr invoke, PTAContext context)
            throws CannotFindMethodException {
        return resolveInstanceInvokeMap(invoke, context).values();
    }
    
    /** Resolve the targets of the invoke statement for each alloc node that the receiver could reference 
    given the PTA and an insensitive search */
    public abstract Map<AllocNode,SootMethod> resolveInstanceInvokeMap(InstanceInvokeExpr invoke)
            throws CannotFindMethodException;
    
    /** Resolve the targets of the invoke statement for each alloc node that the receiver could reference 
        given the PTA and a context */
    public abstract Map<AllocNode,SootMethod> resolveInstanceInvokeMap(InstanceInvokeExpr invoke, PTAContext context)
            throws CannotFindMethodException;
    
    /** dump the pta result */
    public abstract void dumpPTA();
    
    /** dump the pta result to a file */
    public abstract void dumpPTA(String fileName);
    
    /** dump the pta result for a given context */
    public abstract void dumpPTAForContext(PrintStream file, PTAContext sootContext);
    
    /** dump the call graph to a file */
    public abstract void dumpCallGraph(String fileStr);
    
        
}
