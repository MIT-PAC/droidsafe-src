package droidsafe.model.android.os;

import droidsafe.model.ModeledClass;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.spark.pag.AllocNode;

public class Bundle extends ModeledClass {

  private final static Logger logger = LoggerFactory.getLogger(Bundle.class);

  
  public Bundle(AllocNode allocNode) {
    super(allocNode);
  }
 
  public void _init_(){
  }
 
  @Override
  public String toString(){
    String str = "<modeled Bundle" + this.getId() + "> {";
    if (this.invalidated) {
      str += "invalidated";
    } else {
   
    }
    return str + "}";
  }
}
