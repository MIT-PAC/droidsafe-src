package droidsafe.utils;

import java.io.Serializable;

import soot.SootClass;

/**
 * A location in source code with Class and line.
 * 
 * @author mgordon
 *
 */
public class SourceLocationTag implements Comparable<SourceLocationTag>, Serializable {
	private String clz;
	private int line;
	
	public SourceLocationTag(String clz, int line) {
		this.clz = clz;
		this.line = line;
	}

	public String getClz() {
		return clz;
	}

	public void setClz(String clz) {
		this.clz = clz;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}
	
	@Override
	public String toString() {
		return "Line: " + clz.toString() + " " + line;
	}

	
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clz == null) ? 0 : clz.hashCode());
		result = prime * result + line;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SourceLocationTag other = (SourceLocationTag) obj;
		if (clz == null) {
			if (other.clz != null)
				return false;
		} else if (!clz.equals(other.clz))
			return false;
		if (line != other.line)
			return false;
		return true;
	}

	@Override
	public int compareTo(SourceLocationTag other) {
		int clzCompare = clz.toString().compareTo(other.getClz().toString()); 
		
		if (clzCompare != 0)
			return clzCompare;
		
		//otherwise same class, so compare line
		return (new Integer(this.line).compareTo(other.line));
	}
	
	
}
