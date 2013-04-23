package droidsafe.model.android.net;

import droidsafe.model.ModeledClass;

import java.util.HashSet;
import java.util.Set;

import soot.jimple.spark.pag.AllocNode;

public class Uri extends ModeledClass {

  Set<droidsafe.model.java.lang.String> values;

  public Uri(AllocNode allocNode) {
    super(allocNode);
    this.values = new HashSet<droidsafe.model.java.lang.String>();
  }
  public class StringUri {
    public StringUri(AllocNode allocNode) {
    } 
  }
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
