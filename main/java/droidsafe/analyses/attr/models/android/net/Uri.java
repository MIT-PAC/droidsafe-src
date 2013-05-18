package droidsafe.analyses.attr.models.android.net;

import droidsafe.analyses.attr.ModeledClass;

import java.util.HashSet;
import java.util.Set;

import soot.jimple.spark.pag.AllocNode;

public abstract class Uri extends ModeledClass {

  public Uri(){}

  public Uri(AllocNode allocNode) {
    super(allocNode);
  }
  
  public void incorporateUri(Uri dUri) {}

  // parse doesn't modify 
  public static void parse(droidsafe.analyses.attr.models.java.lang.String uriString) {}

  @Override
  public String toString(){
    String str = "<modeled Uri" + this.getId() + "> {";
    if (this.invalidated) {
      str += "invalidated";
    } else {
   
    }
    return str + "}";
  }

  public abstract static class AbstractHierarchicalUri extends Uri {
   
    public AbstractHierarchicalUri() {}

    public AbstractHierarchicalUri(AllocNode allocNode){
       super(allocNode);
    }
  }
 
 
  public static class HierarchicalUri extends AbstractHierarchicalUri {
    
    public HierarchicalUri(AllocNode allocNode) {
      super(allocNode);
    }

    public void _init_(){}
    
    public void _init_(droidsafe.analyses.attr.models.java.lang.String uriString){
    }
  
    @Override
    public String toString(){
      String str = "<modeled HierarchicalUri" + this.getId() + "> {";
      if (this.invalidated) {
        str += "invalidated";
      } else {
      }
      return str + "}";
    }
  }

  public static class StringUri extends AbstractHierarchicalUri {
    
    private droidsafe.analyses.attr.models.java.lang.String uriString;
    
    public StringUri(AllocNode allocNode) {
      super(allocNode);
    }
    
    public StringUri(droidsafe.analyses.attr.models.java.lang.String uriString) {
      this.uriString = uriString;
    }
    
    public void _init_(){
    }
    
    public void _init_(droidsafe.analyses.attr.models.java.lang.String uriString){
      this.uriString = uriString;
    }
 
    public droidsafe.analyses.attr.models.java.lang.String getUriString(){
      return this.uriString;
    }

    @Override
    public String toString(){
      String str = "<modeled StringUri" + this.getId() + "> {";
      if (this.invalidated) {
        str += "invalidated";
      } else {
        if(this.uriString != null)
          str += "uriString: " + this.uriString; 
      }
      return str + "}";
    }
  }
}
