/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

package droidsafe.utils;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * A location in source code with Class and line.
 * 
 * @author mgordon
 *
 */
public class SourceLocationTag implements Comparable<SourceLocationTag>, Serializable {

  private static final long serialVersionUID = 5400084150916043785L;
  
  @SerializedName("class")
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
		if (other == null)
			return 1;
		
		int clzCompare = clz.toString().compareTo(other.getClz().toString()); 
		
		if (clzCompare != 0)
			return clzCompare;
		
		//otherwise same class, so compare line
		return (new Integer(this.line).compareTo(other.line));
	}
	
	
}
