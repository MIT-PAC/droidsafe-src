package droidsafe.analyses.attr;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Set;

import soot.jimple.spark.pag.AllocNode;

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

   public boolean invalidated() {
     return this.invalidated;
   }

   public String getId() {
     String id = "";
     if (this.allocNode != null) {
       Pattern p = Pattern.compile("\\d+");
       Matcher m = p.matcher(this.allocNode.toString());
       if(m.find()) {
         id += " #" + m.group();
       }
     }
     return id;
   }

   public AllocNode getAllocNode(){
     return this.allocNode;
   }
}
