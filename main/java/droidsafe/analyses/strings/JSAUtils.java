package droidsafe.analyses.strings;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Set;
import org.reflections.*;
import droidsafe.model.ModeledClass;

public class JSAUtils {
  // TODO: fix this so methods like incorporateString aren't marked as hotspots
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
          System.out.println(signature);
          for(Integer index : paramOfInterestIndexes){
            JSAStrings.v().addArgumentHotspots(signature, index);
          }
        }
      }
    }
  }
}
