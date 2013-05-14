package droidsafe.model.java.lang;

import soot.jimple.spark.pag.AllocNode;

import soot.jimple.spark.pag.StringConstantNode;

import droidsafe.model.ModeledClass;

import java.util.Set;
import java.util.HashSet;

public class String extends ModeledClass{

  private Set<java.lang.String> possibleValues;

  public String(){
    this.possibleValues = new HashSet<java.lang.String>();
  }

  public String(java.lang.String possibleValue){
    this();
    this.incorporateString(possibleValue);
  }

  public String(AllocNode allocNode){
    super(allocNode);
    this.possibleValues = new HashSet<java.lang.String>();
    this.incorporateAllocNode(allocNode);
  }

  public void incorporateAllocNode(AllocNode allocNode) {
    if(allocNode instanceof StringConstantNode) {
      StringConstantNode stringConstantNode = (StringConstantNode)allocNode;
      possibleValues.add(stringConstantNode.getString());
    } else {
      this.invalidate();
    }
  }

  public Set<java.lang.String> getPossibleValues() {
    return this.possibleValues;
  }

  public void incorporateString(String string){
    this.possibleValues.addAll(string.getPossibleValues());
  }

  public void incorporateString(java.lang.String string){
    this.possibleValues.add(string);
  }

  public int compareTo(String that) {
    if(possibleValues.equals(that.possibleValues))
      return 0;
    return -1;
  }

  @Override
  public java.lang.String toString() {
    java.lang.String str = "<modeled string" + this.getId() + "> {";
    if(this.invalidated) {
      str += "invalidated"; 
    } else {
      str += "possible values: " + this.possibleValues.toString() + "}";
    }
    return str + "}";
  }
}
