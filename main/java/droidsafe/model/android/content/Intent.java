package droidsafe.model.android.content;

import droidsafe.model.ModeledClass;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.spark.pag.AllocNode;

public class Intent extends ModeledClass {

  private final static Logger logger = LoggerFactory.getLogger(Intent.class);

  droidsafe.model.java.lang.String action;
  droidsafe.model.java.lang.String type;
  droidsafe.model.android.net.Uri data;
  
  public Intent(AllocNode allocNode) {
    super(allocNode);
    this.action = new droidsafe.model.java.lang.String();
    this.type = new droidsafe.model.java.lang.String();
  }
  
  public void _init_(){
  }

  public void _init_(droidsafe.model.java.lang.String action){
    this.setAction(action);
  } 
  
  public void setAction(droidsafe.model.java.lang.String action){
    this.action.incorporateString(action);
  }
  
  public void setType(droidsafe.model.java.lang.String type){
    this.type.incorporateString(type);
  }
 
  @Override
  public String toString(){
    String str = "<modeled Intent" + this.getId() + "> {";
    if (this.invalidated) {
      str += "invalidated";
    } else {
      str += "action: " + this.action + ", "
           + "type: " + this.type + ", "
           + "data: " + this.data; 
    }
    return str + "}";
  }
}
