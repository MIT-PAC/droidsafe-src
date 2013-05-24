package droidsafe.analyses.strings;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Set;
import org.reflections.*;
import droidsafe.analyses.attr.ModeledClass;

/**
 * Class containing utility methods for JSA
 * @author Dmitrij Petters (dpetters@mit.edu)
 */
public class JSAUtils {
  /**
   * Set JSA hotspots to be every method signature in attr modeling that has a string as a parameter
   */
  public static void setUpHotspots(){
    Reflections reflections = new Reflections("droidsafe.model");

    Set<Class<? extends ModeledClass>> modeledClasses = 
            reflections.getSubTypesOf(ModeledClass.class);

    for(Class<? extends ModeledClass> modeledClass : modeledClasses){
      Method modeledMethods[] = modeledClass.getDeclaredMethods();

      for (Method modeledMethod : modeledMethods) {
        ArrayList<Integer> paramOfInterestIndexes = new ArrayList<Integer>();

        String signature = "<";
        signature += modeledClass.getName().replace("droidsafe.model.", "") + ": ";
        signature += modeledMethod.getReturnType().getName().replace("droidsafe.model.", "") + " ";
        signature += modeledMethod.getName().replace("_init_", "<init>");

        signature += "(";
        Class<?>[] paramTypes = modeledMethod.getParameterTypes();
        for(int i = 0; i < paramTypes.length; i++) {
          Class<?> paramType = paramTypes[i];
          String paramTypeString = paramType.getName().replace("droidsafe.model.", "");
          signature += paramTypeString;
          if(paramTypeString.equals("java.lang.String") || paramTypeString.equals("java.lang.CharSequence")){
            paramOfInterestIndexes.add(i);
          }
          
          if(i+1 < paramTypes.length){
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
