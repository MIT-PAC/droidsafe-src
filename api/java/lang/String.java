package java.lang;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSTaintObject;

public class String implements java.io.Serializable, Comparable<String>, CharSequence {
	
	private static DSTaintObject taint = new DSTaintObject();
	public static final Class<String> TYPE = new Class<String>();
	
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
	@DSModeled(DSC.SAFE)
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
	
	@DSModeled(DSC.SAFE)
	public static String valueOf(char[] data) {
		return new String();
        //return new String(data, 0, data.length);
    }
	
	@DSModeled(DSC.SAFE)
	public static String valueOf(char value) {
		return new String();
		/*
        String s;
        if (value < 128) {
            s = new String(value, 1, ASCII);
        } else {
            s = new String(0, 1, new char[] { value });
        }
        s.hashCode = value;
        return s;
        */
    }
	
	@DSModeled(DSC.SAFE)
	public static String valueOf(Object value) {
		return value.toString(); 
	}
	
	@DSModeled(DSC.SAFE)
	public static String valueOf(int i) {
        return new String();
    }
}
