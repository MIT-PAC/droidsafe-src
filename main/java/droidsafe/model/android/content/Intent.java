package droidsafe.model.android.content;

import droidsafe.model.ModeledClass;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.spark.pag.AllocNode;

public class Intent extends ModeledClass {

  private final static Logger logger = LoggerFactory.getLogger(Intent.class);

  droidsafe.model.java.lang.String mAction;
  droidsafe.model.java.lang.String mType;
  droidsafe.model.java.lang.String mPackage;
  droidsafe.model.android.net.Uri mData;
  
  public Intent(AllocNode allocNode) {
    super(allocNode);
    this.mAction = new droidsafe.model.java.lang.String();
    this.mType = new droidsafe.model.java.lang.String();
    this.mPackage = new droidsafe.model.java.lang.String();
  }
  
  public void _init_(){
  }

  public void _init_(droidsafe.model.java.lang.String action){
    this.setAction(action);
  } 
  
  public void setAction(droidsafe.model.java.lang.String mAction){
    this.mAction.incorporateString(mAction);
  }
  
  public void setType(droidsafe.model.java.lang.String mType){
    this.mType.incorporateString(mType);
  }
  
  public void setPackage(droidsafe.model.java.lang.String mPackage){
    this.mPackage.incorporateString(mPackage);
  }
  @Override
  public String toString(){
    String str = "<modeled Intent" + this.getId() + "> {";
    if (this.invalidated) {
      str += "invalidated";
    } else {
      str += "action: " + this.mAction + ", "
           + "type: " + this.mType + ", "
           + "data: " + this.mData + ", "
           + "package: " + this.mPackage; 
    }
    return str + "}";
  }
}
