package droidsafe.model.android.view;

import droidsafe.model.android.content.ContextWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.spark.pag.AllocNode;

public class ContextThemeWrapper extends ContextWrapper {

  private final static Logger logger = LoggerFactory.getLogger(ContextThemeWrapper.class);

  
  public ContextThemeWrapper(AllocNode allocNode) {
    super(allocNode);
  }
 
  @Override
  public String toString(){
    String str = "<modeled ContextThemeWrapper" + this.getId() + "> {";
    if (this.invalidated) {
      str += "invalidated";
    } else {
   
    }
    return str + "}";
  }
}
