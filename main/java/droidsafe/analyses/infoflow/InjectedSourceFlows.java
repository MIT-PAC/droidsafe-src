package droidsafe.analyses.infoflow;

import droidsafe.analyses.AttributeModeling;

import droidsafe.model.ModeledClass;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Map;

import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.callgraph.Edge;

import java.lang.reflect.Field;

import soot.RefType;

import soot.SootField;

public class InjectedSourceFlows {
	private static InjectedSourceFlows v;

  private Map<AllocNode, ModeledClass> attrModelingResults;


	public static void run() {
		v = new InjectedSourceFlows();
	}

	public static InjectedSourceFlows v() {
		return v;
	}

	private InjectedSourceFlows() {
     this.attrModelingResults = AttributeModeling.v().getResults();
	}

	public Set<MyValue> getInjectedFlows(AllocNode node, SootField field, Edge context) {
    LinkedHashSet<MyValue> flows = new LinkedHashSet<MyValue>();
    List<String> stringsToInspect = new ArrayList<String>();
    if(this.attrModelingResults.containsKey(node)){
     ModeledClass modeledClass = this.attrModelingResults.get(node);
      try {
        Class<?> c = modeledClass.getClass();
        Field fld = c.getDeclaredField(field.getName());
        Object object = fld.get(modeledClass);

        if (object instanceof droidsafe.model.android.net.Uri.StringUri){
          droidsafe.model.android.net.Uri.StringUri stringUri = (droidsafe.model.android.net.Uri.StringUri)object;
          stringsToInspect.addAll(stringUri.getUriString().getPossibleValues());
        }
      } catch (Exception e){

      } 
    }

    for(String str : stringsToInspect) {
      if(str.indexOf("person") != -1){
        System.out.println("ADDING CONTACT INFO KIND");
        flows.add(Kind.CONTACTS);
      }
    }

		return new LinkedHashSet<MyValue>();
	}

}
