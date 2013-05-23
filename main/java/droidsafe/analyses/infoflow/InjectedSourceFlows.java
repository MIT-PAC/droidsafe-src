package droidsafe.analyses.infoflow;

import droidsafe.analyses.attr.AttributeModeling;
import droidsafe.analyses.attr.ModeledClass;

import droidsafe.analyses.attr.models.android.net.Uri.StringUri;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.callgraph.Edge;

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

        if (object instanceof StringUri){
          StringUri stringUri = (StringUri)object;
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
