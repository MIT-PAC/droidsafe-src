package droidsafe.analyses.attr;

public class AttributeModelingUtils {
    public static String toAttrModelingModelClass(String regularClass){
        return AttributeModeling.PACKAGE_PREFIX + regularClass;
    }

    public static String fromAttrModelingModelClass(String attrModelingModelClass){
        return attrModelingModelClass.split(AttributeModeling.PACKAGE_PREFIX)[1];
    }
}
