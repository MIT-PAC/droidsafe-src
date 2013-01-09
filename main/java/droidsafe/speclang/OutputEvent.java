package droidsafe.speclang;

/** 
 * This class represents an output event in the specification, an api call or an 
 * api action.
 * 
 * @author mgordon
 *
 */
public abstract class OutputEvent {
	protected String name;
	
	protected OutputEvent() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract String toXML();
}
