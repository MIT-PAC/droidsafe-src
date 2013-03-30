package droidsafe.model.android.content;

import droidsafe.model.ModeledClass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.spark.pag.AllocNode;

public class ContextWrapper extends ModeledClass {

  private final static Logger logger = LoggerFactory.getLogger(ContextWrapper.class);

  
  public ContextWrapper(AllocNode allocNode) {
    super(allocNode);
  }
 
  @Override
  public String toString(){
    String str = "<modeled ContextWrapper> {";
    if (this.invalidated) {
      str += "invalidated";
    } else {
   
    }
    return str + "}";
  }
}
