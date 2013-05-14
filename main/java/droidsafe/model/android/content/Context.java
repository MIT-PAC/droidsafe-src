package droidsafe.model.android.content;

import droidsafe.model.ModeledClass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.spark.pag.AllocNode;

public abstract class Context extends ModeledClass {

  private final static Logger logger = LoggerFactory.getLogger(Context.class);

  
  public Context(AllocNode allocNode) {
    super(allocNode);
  }

  public abstract droidsafe.model.java.lang.String getPackageName(); 

  @Override
  public String toString(){
    String str = "<modeled Context" + this.getId() + "> {";
    if (this.invalidated) {
      str += "invalidated";
    } else {
   
    }
    return str + "}";
  }
}
