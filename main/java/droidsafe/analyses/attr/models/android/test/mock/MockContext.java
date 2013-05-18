package droidsafe.analyses.attr.models.android.test.mock;

import droidsafe.analyses.attr.ModeledClass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.spark.pag.AllocNode;

public class MockContext extends ModeledClass {

  private final static Logger logger = LoggerFactory.getLogger(MockContext.class);

  
  public MockContext(AllocNode allocNode) {
    super(allocNode);
  }
 
  public void _init_(){
  }

  @Override
  public String toString(){
    String str = "<modeled MockContext" + this.getId() + "> {";
    if (this.invalidated) {
      str += "invalidated";
    } else {
   
    }
    return str + "}";
  }
}
