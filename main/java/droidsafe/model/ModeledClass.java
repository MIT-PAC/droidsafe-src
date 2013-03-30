package droidsafe.model;

import soot.jimple.spark.pag.AllocNode;
import java.util.Set;
import java.util.HashSet;

public abstract class ModeledClass {

   protected AllocNode allocNode;
   protected boolean invalidated;
  
   public ModeledClass(){
     this.invalidated = false;
   }

   public ModeledClass(AllocNode allocNode){
     this();
     this.allocNode = allocNode;
   }

   public void invalidate(){
     this.invalidated = true;
   }
   public boolean isInvalid() {
     return this.invalidated;
   }

   public AllocNode getAllocNode(){
     return this.allocNode;
   }
}
