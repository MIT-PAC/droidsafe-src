package droidsafe.model.android.app;

import droidsafe.model.android.content.ContextThemeWrapper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.spark.pag.AllocNode;

public class Activity extends ContextThemeWrapper {

  private final static Logger logger = LoggerFactory.getLogger(Activity.class);

  
  public Activity(AllocNode allocNode) {
    super(allocNode);
  }
  
  // 15
  public void startActivity(droidsafe.model.android.content.Intent intent){
  
  }
 
  @Override
  public String toString(){
    String str = "<modeled Activity> {";
    if (this.invalidated) {
      str += "invalidated";
    } else {
   
    }
    return str + "}";
  }
}
