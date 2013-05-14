package droidsafe.model.android.app;

import droidsafe.model.android.content.ContextWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.spark.pag.AllocNode;

public class Application extends ContextWrapper {

  private final static Logger logger = LoggerFactory.getLogger(Application.class);
  
  public Application(AllocNode allocNode) {
    super(allocNode);
  }
 
  public void _init_(){
  }

  void dispatchActivityPaused(Activity activity) {}

  void dispatchActivityResumed(Activity activity) {}
 
  void dispatchActivityStarted(Activity activity) {}

  void dispatchActivityStopped(Activity activity) {}

  @Override
  public String toString(){
    String str = "<modeled Application" + this.getId() + "> {";
    if (this.invalidated) {
      str += "invalidated";
    } else {
   
    }
    return str + "}";
  }
}
