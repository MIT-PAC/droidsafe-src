package dk.brics.string.java;

import soot.ValueBox;
import dk.brics.string.intermediate.Hotspot;

/**
 * Contains a {@link Hotspot} statement and information about which jimple-expression,
 * Java source file, class, method, and line number it was originally defined at.
 */
public class HotspotInfo {
	private Hotspot statement;
	private ValueBox box;
	private String sourcefile;
	private String className;
	private String methodName;
	private int lineNumber;
	
	public HotspotInfo(Hotspot statement, ValueBox box) {
		this.statement = statement;
		this.box = box;
	}
	
	public Hotspot getStatement() {
		return statement;
	}
	public void setStatement(Hotspot statement) {
		this.statement = statement;
	}
	public ValueBox getBox() {
		return box;
	}
	public void setBox(ValueBox box) {
		this.box = box;
	}
	public String getSourcefile() {
		return sourcefile;
	}
	public void setSourcefile(String sourcefile) {
		this.sourcefile = sourcefile;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public int getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
}
