package java.lang;

import droidsafe.annotations.*;
import droidsafe.helpers.*;

public final class Integer extends Number implements Comparable<Integer> {
	private DSTaintObject dsTaint = new DSTaintObject();

	@Override
	public int compareTo(Integer arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@DSModeled(DSC.SAFE)
	public Integer(int value) {
		dsTaint.addTaint(value);
        //this.value = value;
    }

	@DSModeled(DSC.SAFE)
	public static Integer valueOf(int i) {
		return new Integer(i);
        //return  i >= 128 || i < -128 ? new Integer(i) : SMALL_VALUES[i + 128];
    }
	
	@DSModeled(DSC.SAFE)
	public static int parseInt(String string) throws NumberFormatException {
        return parseInt(string, 10);
    }
	
	@DSModeled(DSC.SAFE)
	public static int parseInt(String string, int radix) throws NumberFormatException {
		/*
        if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX) {
            throw new NumberFormatException("Invalid radix: " + radix);
        }
        if (string == null) {
            throw invalidInt(string);
        }
        int length = string.length(), i = 0;
        if (length == 0) {
            throw invalidInt(string);
        }
        boolean negative = string.charAt(i) == '-';
        if (negative && ++i == length) {
            throw invalidInt(string);
        }
        return parse(string, i, radix, negative);
        */
		return parse(string, 0, radix, false);
    }
	
	@DSModeled(DSC.SAFE)
	private static int parse(String string, int offset, int radix, boolean negative) throws NumberFormatException {
		return 0;
		/*
        int max = Integer.MIN_VALUE / radix;
        int result = 0, length = string.length();
        while (offset < length) {
            int digit = Character.digit(string.charAt(offset++), radix);
            if (digit == -1) {
                throw invalidInt(string);
            }
            if (max > result) {
                throw invalidInt(string);
            }
            int next = result * radix - digit;
            if (next > result) {
                throw invalidInt(string);
            }
            result = next;
        }
        if (!negative) {
            result = -result;
            if (result < 0) {
                throw invalidInt(string);
            }
        }
        return result;
        */
    }
	
	@DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
    }

	@DSModeled(DSC.SAFE)
	public String toString() {
        return dsTaint.getTaintString();
    }
}
