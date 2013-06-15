package droidsafe.analyses.strings;

import droidsafe.analyses.attr.AttributeModeling;
import droidsafe.analyses.attr.AttrModeledClass;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import java.util.ArrayList;
import java.util.Set;

import org.reflections.*;

/**
 * Class containing utility methods for JSA
 *
 * @author dpetters
 */
public class JSAUtils {
    /**
     * Set JSA hotspots to be every method signature in attr modeling that has a string as a parameter
     */
    public static void setUpHotspots(){
        Reflections reflections = new Reflections(AttributeModeling.MODEL_PACKAGE);

        Set<Class<? extends AttrModeledClass>> modeledClasses = 
            reflections.getSubTypesOf(AttrModeledClass.class);

        for(Class<? extends AttrModeledClass> modeledClass : modeledClasses){
            Method modeledMethods[] = modeledClass.getDeclaredMethods();

            for (Method modeledMethod : modeledMethods) {
                ArrayList<Integer> paramOfInterestIndexes = new ArrayList<Integer>();

                String signature = "<";
                signature += modeledClass.getName().replace(AttributeModeling.MODEL_PACKAGE_PREFIX, "") + ": ";
                signature += modeledMethod.getReturnType().getName().replace(AttributeModeling.MODEL_PACKAGE_PREFIX, "")
                          + " ";
                signature += modeledMethod.getName().replace("_init_", "<init>");

                signature += "(";
                Class<?>[] paramClasses = modeledMethod.getParameterTypes();
                Type[] genericParamTypes = modeledMethod.getGenericParameterTypes();
                for(int i = 0; i < genericParamTypes.length; i++) {
                    Class paramClass = paramClasses[i];
                    String paramTypeString = paramClass.getName();
                    if(paramTypeString.equals("java.util.Set")) {
                        Type genericParamType = genericParamTypes[i];
                        if(genericParamType instanceof ParameterizedType) {
                            ParameterizedType parameterizedType = (ParameterizedType)genericParamType;
                            Type typeParamForBaseInterface = parameterizedType.getActualTypeArguments()[0];
                            if(typeParamForBaseInterface instanceof Class) {
                                Class typeParamForBaseInterfaceClass = (Class)typeParamForBaseInterface;
                                paramTypeString = typeParamForBaseInterfaceClass.getName()
                                                  .replace(AttributeModeling.MODEL_PACKAGE_PREFIX, "");
                                if(   paramTypeString.equals("java.lang.String") 
                                   || paramTypeString.equals("java.lang.CharSequence")
                                   || paramTypeString.equals("java.lang.StringBuffer")
                                   || paramTypeString.equals("java.lang.StringBuilder")) {
                                    paramOfInterestIndexes.add(i);
                                }
                            }
                        }
                    }
                    signature += paramTypeString;
                    if(i+1 < genericParamTypes.length){
                        signature += ",";
                    }
                }
                signature += ")>";
                if(paramOfInterestIndexes.size() > 0){
                    for(Integer index : paramOfInterestIndexes){
                        System.out.println(signature);
                        System.out.println(index);
                        JSAStrings.v().addArgumentHotspots(signature, index);
                    }
                }
            }
        }
    }
}
