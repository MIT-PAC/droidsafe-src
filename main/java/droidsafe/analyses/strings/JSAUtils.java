package droidsafe.analyses.strings;

import droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysisBoolean;
import droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysisByte;
import droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysisChar;
import droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysisDouble;
import droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysisFloat;
import droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysisInt;
import droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysisLong;
import droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysisShort;
import droidsafe.analyses.value.ValueAnalysis;
import droidsafe.analyses.value.ValueAnalysisModeledObject;

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
        Reflections reflections = new Reflections(ValueAnalysis.MODEL_PACKAGE);

        Set<Class<? extends ValueAnalysisModeledObject>> modeledClasses = 
            reflections.getSubTypesOf(ValueAnalysisModeledObject.class);

        for(Class<? extends ValueAnalysisModeledObject> modeledClass : modeledClasses){
            Method modeledMethods[] = modeledClass.getDeclaredMethods();

            for (Method modeledMethod : modeledMethods) {
                ArrayList<Integer> paramOfInterestIndexes = new ArrayList<Integer>();

                String signature = "<";
                signature += modeledClass.getName().replace(ValueAnalysis.MODEL_PACKAGE_PREFIX, "") + ": ";
                signature += modeledMethod.getReturnType().getName().replace(ValueAnalysis.MODEL_PACKAGE_PREFIX, "")
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
                                                  .replace(ValueAnalysis.MODEL_PACKAGE_PREFIX, "");
                                if(   paramTypeString.equals("java.lang.String") 
                                   || paramTypeString.equals("java.lang.CharSequence")
                                   || paramTypeString.equals("java.lang.StringBuffer")
                                   || paramTypeString.equals("java.lang.StringBuilder")) {
                                    paramOfInterestIndexes.add(i);
                                } else if(typeParamForBaseInterfaceClass.equals(ValueAnalysisBoolean.class)){
                                    paramTypeString = "boolean";
                                } else if(typeParamForBaseInterfaceClass.equals(ValueAnalysisByte.class)){
                                    paramTypeString = "byte";
                                } else if(typeParamForBaseInterfaceClass.equals(ValueAnalysisChar.class)){
                                    paramTypeString = "char";
                                } else if(typeParamForBaseInterfaceClass.equals(ValueAnalysisDouble.class)){
                                    paramTypeString = "double";
                                } else if(typeParamForBaseInterfaceClass.equals(ValueAnalysisFloat.class)){
                                    paramTypeString = "float";
                                } else if(typeParamForBaseInterfaceClass.equals(ValueAnalysisInt.class)){
                                    paramTypeString = "int";
                                } else if(typeParamForBaseInterfaceClass.equals(ValueAnalysisLong.class)){
                                    paramTypeString = "long";
                                } else if(typeParamForBaseInterfaceClass.equals(ValueAnalysisShort.class)){
                                    paramTypeString = "short";
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
                        JSAStrings.v().addArgumentHotspots(signature, index);
                    }
                }
            }
        }
    }
}
