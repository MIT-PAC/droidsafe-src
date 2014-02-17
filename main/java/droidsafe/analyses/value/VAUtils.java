package droidsafe.analyses.value;

import soot.RefType;
import soot.Scene;
import soot.SootClass;


/**
 * Class containing attribute modeling utility methods 

 * @author dpetters
 */
public class VAUtils {
    /** 
     * Convert the string signature of a regular class to the string signature of the corresponding attr modeling model
     * class 
     */
    public static String toAttrModelingModelClass(String regularClass){
        return ValueAnalysis.MODEL_PACKAGE_PREFIX + regularClass;
    }
   
    /**
     * Convert the string signature of an attr modeling model class to a string signature of a regular class 
     */
    public static String fromAttrModelingModelClass(String vaModelClass){
        return vaModelClass.split(ValueAnalysis.MODEL_PACKAGE_PREFIX)[1];
    }

    /**
     * Helper method that convers a refType into the appropriate droidsafe.analyses.value.models.class
     *
     * @throws ClassNotFoundException if the correct class isn't modeled 
     */
    public static Class<?> getDroidsafeClass(RefType refType) throws ClassNotFoundException {
        return getDroidsafeClass(refType.getSootClass());
    }

    /**
     * wrapper around toAttrModelingModelClass 
     */
    public static Class<?> getDroidsafeClass(SootClass sootClass) throws ClassNotFoundException {
        return Class.forName(toAttrModelingModelClass(sootClass.getName()));
    }

    /**
     * Given a SootClass, return the corresponding va model SootClass
     */
    public static SootClass getDroidsafeSootClass(SootClass sootClass) throws ClassNotFoundException {
        return Scene.v().getSootClass(toAttrModelingModelClass(sootClass.getName()));
    }

    /**
     * Given a SootClass, return the corresponding va model SootClass
     */
    public static String indent(int level) {
        return (level <= 0) ? "" : String.format("%" + level * 2 + "s", "");
    }
}
