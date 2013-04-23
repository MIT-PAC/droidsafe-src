package java.lang;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSTaintObject;

public class String implements java.io.Serializable, Comparable<String>, CharSequence {
	
	private DSTaintObject taint = new DSTaintObject();
	
	@DSModeled(DSC.SAFE)
	public String() {
        taint.addTaint(new char[0]);
    }
	
	@DSModeled(DSC.SAFE)
	public String(String s) {
        taint.addTaint(s);
    }
	
	@DSModeled(DSC.SAFE)
	public char[] toCharArray() {
		char[] ret = (char[])taint.getTaint();
		return ret;
	}
	
	@DSModeled(DSC.SAFE)
	public int hashCode() {
		return 0;
	}

	@DSModeled(DSC.SAFE)
	public int length() {
		return 0;
	}
	
	@DSModeled(DSC.SAFE)
	public String toString() {
        return taint.getTaintString();
    }

	@Override
	public char charAt(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(String o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
