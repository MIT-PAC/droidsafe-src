package droidsafe.analyses.value;

/**
 * Class containing attribute modeling utility methods 

 * @author dpetters
 * */
public class ValueAnalysisUtils {
    /** 
     * Convert the string signature of a regular class to the string signature of the corresponding attr modeling model
     * class 
     * */
    public static String toAttrModelingModelClass(String regularClass){
        return ValueAnalysis.MODEL_PACKAGE_PREFIX + regularClass;
    }
   
    /**
     * Convert the string signature of an attr modeling model class to a string signature of a regular class 
     * */
    public static String fromAttrModelingModelClass(String attrModelingModelClass){
        return attrModelingModelClass.split(ValueAnalysis.MODEL_PACKAGE_PREFIX)[1];
    }
}
