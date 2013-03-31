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
 
  public void _init_(){
  }
 
  // 15
  public void startActivity(droidsafe.model.android.content.Intent intent){
  
  }
 
  // 15
  public void startActivityForResult(droidsafe.model.android.content.Intent intent, Integer requestCode){
  
  }

  @Override
  public String toString(){
    String str = "<modeled Activity" + this.getId() + "> {";
    if (this.invalidated) {
      str += "invalidated";
    } else {
   
    }
    return str + "}";
  }
}
