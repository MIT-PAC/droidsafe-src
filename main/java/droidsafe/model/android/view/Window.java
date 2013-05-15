package droidsafe.model.android.view;

import droidsafe.model.ModeledClass;

import soot.jimple.spark.pag.AllocNode;

public abstract class Window extends ModeledClass {

  public Window(){}

  public Window(AllocNode allocNode) {
    super(allocNode);
  }


  @Override
  public String toString(){
    String str = "<modeled Window" + this.getId() + "> {";
    if (this.invalidated) {
      str += "invalidated";
    } else {
   
    }
    return str + "}";
  }
}
