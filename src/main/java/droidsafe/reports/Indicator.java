package droidsafe.reports;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import soot.SootMethod;
import soot.jimple.Stmt;

import com.google.gson.annotations.SerializedName;

import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;
import droidsafe.utils.SourceLocationTag;

public class Indicator<T> {

    @SerializedName("indicator-type")
    String indicator_type;
    Map<String, Boolean> visibility = new HashMap<String,Boolean>();
    Map<String, Boolean> display = new HashMap<String,Boolean>();
    ArrayList<T> contents = new ArrayList<T>();
    
    public Indicator(String type) { 
        indicator_type = type;
    }
    
    public void addContents(T t) {
        contents.add(t);
    }
    
    public void addVisibility(String str) {
        visibility.put(str, true);
    }
    
    public void removeVisibility(String str) {
        visibility.put(str, false);
    }
    
    public void addDisplay(String str) {
        display.put(str, true);
    }
    
    public void removeDisplay(String str) {
        display.put(str, false);
    }
    
   
}
