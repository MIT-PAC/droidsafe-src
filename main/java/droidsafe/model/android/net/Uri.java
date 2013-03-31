package droidsafe.model.android.net;

import droidsafe.model.ModeledClass;

import java.util.Set;

public class Uri extends ModeledClass {
  Set<droidsafe.model.java.lang.String> values;

  @Override
  public String toString(){
    String str = "<modeled Uri" + this.getId() + "> {";
    if (this.invalidated) {
      str += "invalidated";
    } else {
   
    }
    return str + "}";
  }
}
