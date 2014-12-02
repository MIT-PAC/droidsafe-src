package droidsafe.transforms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.analyses.interapp.InjectInterAppFlows;
import droidsafe.analyses.interapp.SourceFlow;
import droidsafe.android.system.API;
import droidsafe.utils.SootUtils;
import soot.ArrayType;
import soot.Body;
import soot.Local;
import soot.Modifier;
import soot.PrimType;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Type;
import soot.Value;
import soot.VoidType;
import soot.jimple.IntConstant;
import soot.jimple.Jimple;
import soot.jimple.JimpleBody;

/**
 * For native methods defined in app src code, create a body that just return a new
 * value of the return type.  For primitives just return a local that is created.  For
 * reference types, return a new object of the type.  For arrays, create a one element array
 * and set the element equal to a new value.
 * 
 * 
 * @author mgordon
 *
 */
public class NativeMethodBuilder {
    private final static Logger logger = LoggerFactory.getLogger(NativeMethodBuilder.class);
    
    private static NativeMethodBuilder v;
    private List<SourceFlow> flows;
    public static int localID = 0;
    
    private Set<SootMethod> wasNative = new HashSet<SootMethod>();
    
    public static NativeMethodBuilder v() {
        if (v == null)
            v = new NativeMethodBuilder();
        
        return v;
    }
    
    private NativeMethodBuilder() {
        // TODO Auto-generated constructor stub
    }
    
    public void run() {
        for (SootClass clz : Scene.v().getClasses()) {
            if (!API.v().isSystemClass(clz)) {                
                for (SootMethod method : clz.getMethods()) {
                    if (method.isNative()) {
                        buildBody(method);
                    }
                }
            }
        }
    }
    
    private void buildBody(SootMethod method) {
        //create new body that just returns a new string
        Body newBody = Jimple.v().newBody();
        
        //create param identity statements
        for (int i = 0; i < method.getParameterCount(); i++) {
            Local p = Jimple.v().newLocal("_$native_builder_" + localID++, method.getParameterType(i));
            newBody.getLocals().add(p);
            newBody.getUnits().add(Jimple.v().newIdentityStmt(p, Jimple.v().newParameterRef(method.getParameterType(i), i)));
        }
        
        //return new value
        Type rType = method.getReturnType();
        Local r = Jimple.v().newLocal("_$native_builder_" + localID++, rType);
        
        initializeValue(newBody, rType, r);
        
        if (rType instanceof VoidType) {
            newBody.getUnits().add(Jimple.v().newReturnVoidStmt());
        } else {
            newBody.getUnits().add(Jimple.v().newReturnStmt(r));
        }
              
        logger.info("Implementing app native method: {}", method);
        //turn off native modifier
        method.setModifiers(method.getModifiers() ^ soot.Modifier.NATIVE);
        newBody.setMethod(method);
        method.setActiveBody(newBody);
        wasNative.add(method);
       
    }
    
    private void initializeValue(Body newBody, Type rType, Local r) {        
        if (rType instanceof PrimType) {
            //if prim, then just add local to the body
            newBody.getLocals().add(r);           
        } else if (rType instanceof RefType) {
            initializeRef(newBody, (RefType)rType, r);            
        } else if (rType instanceof ArrayType) {
            initializeArray(newBody, (ArrayType)rType, r);            
        } else {
            //nothing to do
            return;
        }
    }
    
    private void initializeRef(Body newBody, RefType type, Local r) {
        newBody.getLocals().add(r);
        
        SootClass clz = type.getSootClass();
        //if an interface, find a direct implementor of and instantiate that...
        if (!clz.isConcrete()) {
            clz = SootUtils.getCloseConcrete(clz);
        }

        if (clz ==  null) {
            //if clz is null, then we have an interface with no known implementors, 
            //so just pass null
            logger.warn("Cannot find any known implementors of {} when adding dummy object", 
                type.getSootClass());
            return;
        }
        
        UnmodeledGeneratedClasses.installNoArgConstructor(clz);
        
        //field and add creation of object
        if (!clz.declaresMethod(UnmodeledGeneratedClasses.noArgConsSubSig)) {
            logger.warn("Error during native simulation. Class {} does not have a no arg constructor.", clz);
            return;
        }

        //local = new Clone()
        //local.init();
        //field = local
        newBody.getUnits().add(Jimple.v().newAssignStmt(r, Jimple.v().newNewExpr(clz.getType())));
        newBody.getUnits().add(Jimple.v().newInvokeStmt(Jimple.v().newSpecialInvokeExpr(r, 
            clz.getMethod(UnmodeledGeneratedClasses.noArgConsSubSig).makeRef())));                
    }
    
    private void initializeArray(Body newBody, ArrayType type, Local arrayLocal) {
        Type baseType = type.getArrayElementType();
        Local baseValue = Jimple.v().newLocal("_$native_builder_" + localID++, baseType);
        initializeValue(newBody, baseType, baseValue);
        
        //add local for array
        newBody.getLocals().add(arrayLocal);

        if (type.numDimensions > 1) {
            //multiple dimensions, have to do some crap...
            List<Value> ones = new LinkedList<Value>();
            for (int i = 0; i < type.numDimensions; i++)
                ones.add(IntConstant.v(1));

            newBody.getUnits().add(Jimple.v().newAssignStmt(arrayLocal,
                Jimple.v().newNewMultiArrayExpr(type, ones)));
        } else {
            //single dimension, add new expression
            newBody.getUnits().add(Jimple.v().newAssignStmt(arrayLocal, 
                Jimple.v().newNewArrayExpr(baseType, IntConstant.v(1))));
        }

        //get down to an element through the dimensions
        Local elementPtr = arrayLocal;
        while (((ArrayType)elementPtr.getType()).getElementType() instanceof ArrayType) {
            Local currentLocal = Jimple.v().newLocal("_$MULTIARRAY" + localID++, ((ArrayType)elementPtr).getElementType());
            newBody.getUnits().add(Jimple.v().newAssignStmt(
                currentLocal, 
                Jimple.v().newArrayRef(elementPtr, IntConstant.v(0))));
            elementPtr = currentLocal;
        }        

        //assign the new local to the array access
        newBody.getUnits().add(Jimple.v().newAssignStmt(
            Jimple.v().newArrayRef(elementPtr, IntConstant.v(0)), 
            baseValue)); 
    }
}
