package droidsafe.analyses.infoflow;

import java.util.LinkedHashSet;
import java.util.Set;

import soot.RefType;
import soot.jimple.StringConstant;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.callgraph.Edge;

public class InjectedSourceFlows {
	private static InjectedSourceFlows v;
	
	public static void run() {
		v = new InjectedSourceFlows();
	}
	
	public static InjectedSourceFlows v() {
		return v;
	}
	
	private InjectedSourceFlows() {
		
	}
	
	public Set<MyValue> getInjectedFlows(AllocNode node, Edge context) {
		if (node.getType() instanceof RefType &&
				((RefType)node.getType()).getSootClass().getName().equals("java.net.Uri")) {
			LinkedHashSet<MyValue> flows = new LinkedHashSet<MyValue>();
			
			flows.add(new MyConstant(StringConstant.v("CONTACTS")));
			
			return flows;
		}
		
		return new LinkedHashSet<MyValue>();
	}

}
