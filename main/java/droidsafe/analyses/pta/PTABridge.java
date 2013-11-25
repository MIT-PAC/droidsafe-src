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

public abstract class PTABridge {
    /** Logger field */
    private static final Logger logger = LoggerFactory.getLogger(PTABridge.class);
    /** Singleton for PTA bridge */
    private static PTABridge v;
    
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

        G.v().MethodPAG_methodToPag = new HashMap<SootMethod, MethodPAG>();

        System.gc();
        System.gc();
    }
    
    protected abstract void runInternal();

    
    public static void run(PointsToAnalysisPackage pta) {
        if (pta == PointsToAnalysisPackage.GEOPTA) {
            v = new GeoPTA();
            v.runInternal();
        } else {
            logger.error("Invalid points to analysis package: {}", pta);
            droidsafe.main.Main.exit(1);
        }
    }
    
    public static PTABridge v() {
        return v;
    }
    
    public abstract boolean isLegalCast(Type objType, Type refType);

    public abstract AllocNode getAllocNode(Object newExpr);
    
    public abstract Set<AllocNode> getAllAllocNodes();
    
    public abstract Object getNewExpr(AllocNode an);
    
    public abstract Set<SootMethod> getAllReachableMethods() ;
    
    public abstract boolean isReachableMethod(SootMethod method);
    
    public abstract boolean isPointer(Value val);
    
    public abstract Set<Type> getTypes(Value val);
    
    public abstract Set<Type> getTypes(Value val, PTAContext context);
    
    public abstract Set<AllocNode> getPTSet(Value val);
    
    /**
     * Content Insensitive query of field reference with allocnode and field. 
     */
    public abstract Set<AllocNode> getPTSet(AllocNode node, SootField field);
    
    public abstract Set<AllocNode> getPTSet(Value val, PTAContext context);
    
    public abstract Collection<SootMethod> resolveInvoke(InvokeExpr invoke)  throws CannotFindMethodException;
    
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
    
    public abstract Map<AllocNode,SootMethod> resolveInstanceInvokeMap(InstanceInvokeExpr invoke)
            throws CannotFindMethodException;
    
    public abstract Map<AllocNode,SootMethod> resolveInstanceInvokeMap(InstanceInvokeExpr invoke, PTAContext context)
            throws CannotFindMethodException;
    
    public abstract void dumpPTA();
    
    public abstract void dumpPTA(String fileName);
    
    public abstract void dumpPTAForContext(PrintStream file, PTAContext sootContext);
    
    public abstract void dumpCallGraph(String fileStr);
    
    public abstract boolean isValidContext(SootMethod method);
    
}
