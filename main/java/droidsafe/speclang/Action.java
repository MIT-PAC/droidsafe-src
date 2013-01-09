package droidsafe.speclang;

public class Action extends OutputEvent {
	private ArgumentValue[] args;
	
	public Action(String name, ArgumentValue[] args) {
		this.args = args;
		this.name = name;
	}

	public ArgumentValue[] getArgs() {
		return args;
	}

	public void setArgs(ArgumentValue[] args) {
		this.args = args;
	}
	
	public String toXML() {
		return "XML for Action not implemented";
	}
}
