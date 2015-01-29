package droidsafe.android.model.attributes;

import java.util.LinkedHashSet;
import java.util.Set;

public class StringAttribute {
	
	public static final StringAttribute ANY = new StringAttribute();
	
	private Set<String> values;
	
	public StringAttribute() {
		values = new LinkedHashSet<String>();	
	}
	
	//public static StringAttribute 
}
