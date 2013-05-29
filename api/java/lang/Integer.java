package java.lang;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;


@FindBugsSuppressWarnings("DM_NUMBER_CTOR") public final class Integer extends Number implements Comparable<Integer> {
	
	private static final long serialVersionUID = 1360826667806852920L;
	private final int value;
	public static final int MAX_VALUE = 0x7FFFFFFF;
	public static final int MIN_VALUE = 0x80000000;
	public static final int SIZE = 32;
	private static final byte[] NTZ_TABLE = {
        32,  0,  1, 12,  2,  6, -1, 13,   3, -1,  7, -1, -1, -1, -1, 14,
        10,  4, -1, -1,  8, -1, -1, 25,  -1, -1, -1, -1, -1, 21, 27, 15,
        31, 11,  5, -1, -1, -1, -1, -1,   9, -1, -1, 24, -1, -1, 20, 26,
        30, -1, -1, -1, -1, 23, -1, 19,  29, -1, 22, 18, 28, 17, 16, -1
    };
	@SuppressWarnings("unchecked")
    public static final Class<Integer> TYPE
            = (Class<Integer>) int[].class.getComponentType();
	
	@DSModeled(DSC.SAFE)
	public Integer(int value){
		dsTaint.addTaint(value);
		this.value = value;
		/*
		this.value = value;
		*/
	}
	
	Integer(String string) throws NumberFormatException{
		this(parseInt(string));
	}
	
	@Override public byte byteValue(){
		
		// Original method
		/*
		{
        return (byte) value;
    }
		*/
		return 0;
	}
	
	public int compareTo(Integer object){
		
		// Original method
		/*
		{
        return compare(value, object.value);
    }
		*/
		return 0;
	}
	
	public static int compare(int lhs, int rhs){
		
		// Original method
		/*
		{
        return lhs < rhs ? -1 : (lhs == rhs ? 0 : 1);
    }
		*/
		return 0;
	}
	
	private static NumberFormatException invalidInt(String s){
		
		// Original method
		/*
		{
        throw new NumberFormatException("Invalid int: \"" + s + "\"");
    }
		*/
		return null;
	}
	
	public static Integer decode(String string){
		
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return null;
	}
	
	@Override public double doubleValue(){
		return (double)dsTaint.getTaintFloat();
		
		// Original method
		/*
		{
        return value;
    }
		*/
	}
	
	@Override public boolean equals(Object o){
		
		// Original method
		/*
		{
        return (o instanceof Integer) && (((Integer) o).value == value);
    }
		*/
		return false;
	}
	
	@Override public float floatValue(){
		return dsTaint.getTaintFloat();
		
		// Original method
		/*
		{
        return value;
    }
		*/
	}
	
	public static Integer getInteger(String string){
		
		// Original method
		/*
		{
        if (string == null || string.length() == 0) {
            return null;
        }
        String prop = System.getProperty(string);
        if (prop == null) {
            return null;
        }
        try {
            return decode(prop);
        } catch (NumberFormatException ex) {
            return null;
        }
    }
		*/
		return null;
	}
	
	public static Integer getInteger(String string, int defaultValue){
		
		// Original method
		/*
		{
        if (string == null || string.length() == 0) {
            return valueOf(defaultValue);
        }
        String prop = System.getProperty(string);
        if (prop == null) {
            return valueOf(defaultValue);
        }
        try {
            return decode(prop);
        } catch (NumberFormatException ex) {
            return valueOf(defaultValue);
        }
    }
		*/
		return null;
	}
	
	public static Integer getInteger(String string, Integer defaultValue){
		
		// Original method
		/*
		{
        if (string == null || string.length() == 0) {
            return defaultValue;
        }
        String prop = System.getProperty(string);
        if (prop == null) {
            return defaultValue;
        }
        try {
            return decode(prop);
        } catch (NumberFormatException ex) {
            return defaultValue;
        }
    }
		*/
		return null;
	}
	
	@DSModeled(DSC.SAFE)
	@Override public int hashCode(){
		return dsTaint.getTaintInt();
		
		// Original method
		/*
		{
        return value;
    }
		*/
	}
	
	@Override public int intValue(){
		return dsTaint.getTaintInt();
		
		// Original method
		/*
		{
        return value;
    }
		*/
	}
	
	@Override public long longValue(){
		return (long)dsTaint.getTaintInt();
		
		// Original method
		/*
		{
        return value;
    }
		*/
	}
	
	public static int parseInt(String string){
		return parseInt(string, 10);
		// Original method
		/*
		{
        return parseInt(string, 10);
    }
		*/
	}
	
	@DSModeled(DSC.SAFE)
	public static int parseInt(String string, int radix){
		return parse(string, 0, radix, false);
		// Original method
		/*
		{
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
    }
		*/
	}
	
	@DSModeled(DSC.SAFE)
	private static int parse(String string, int offset, int radix, boolean negative){
		
		// Original method
		/*
		{
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
    }
		*/
		return 0;
	}
	
	@Override public short shortValue(){
		
		// Original method
		/*
		{
        return (short) value;
    }
		*/
		return 0;
	}
	
	public static String toBinaryString(int i){
		
		// Original method
		/*
		{
        return IntegralToString.intToBinaryString(i);
    }
		*/
		return "";
	}
	
	public static String toHexString(int i){
		
		// Original method
		/*
		{
        return IntegralToString.intToHexString(i, false, 0);
    }
		*/
		return "";
	}
	
	public static String toOctalString(int i){
		
		// Original method
		/*
		{
        return IntegralToString.intToOctalString(i);
    }
		*/
		return "";
	}
	
	@Override public String toString(){
		
		// Original method
		/*
		{
        return Integer.toString(value);
    }
		*/
		return "";
	}
	
	public static String toString(int i){
		
		// Original method
		/*
		{
        return IntegralToString.intToString(i);
    }
		*/
		return "";
	}
	
	public static String toString(int i, int radix){
		
		// Original method
		/*
		{
        return IntegralToString.intToString(i, radix);
    }
		*/
		return "";
	}
	
	public static Integer valueOf(String string){
		
		// Original method
		/*
		{
        return valueOf(parseInt(string));
    }
		*/
		return null;
	}
	
	public static Integer valueOf(String string, int radix){
		
		// Original method
		/*
		{
        return valueOf(parseInt(string, radix));
    }
		*/
		return null;
	}
	
	public static int highestOneBit(int i){
		
		// Original method
		/*
		{
        
        i |= (i >> 1);
        i |= (i >> 2);
        i |= (i >> 4);
        i |= (i >> 8);
        i |= (i >> 16);
        return i - (i >>> 1);
    }
		*/
		return 0;
	}
	
	public static int lowestOneBit(int i){
		
		// Original method
		/*
		{
        return i & -i;
    }
		*/
		return 0;
	}
	
	public static int numberOfLeadingZeros(int i){
		
		// Original method
		/*
		{
        
        if (i <= 0) {
            return (~i >> 26) & 32;
        }
        int n = 1;
        if (i >> 16 == 0) {
            n +=  16;
            i <<= 16;
        }
        if (i >> 24 == 0) {
            n +=  8;
            i <<= 8;
        }
        if (i >> 28 == 0) {
            n +=  4;
            i <<= 4;
        }
        if (i >> 30 == 0) {
            n +=  2;
            i <<= 2;
        }
        return n - (i >>> 31);
    }
		*/
		return 0;
	}
	
	public static int numberOfTrailingZeros(int i){
		
		// Original method
		/*
		{
        return NTZ_TABLE[((i & -i) * 0x0450FBAF) >>> 26];
    }
		*/
		return 0;
	}
	
	@DSModeled(DSC.SAFE)
	public static int bitCount(int i){
		
		// Original method
		/*
		{
        
        i -= (i >> 1) & 0x55555555;
        i = (i & 0x33333333) + ((i >> 2) & 0x33333333);
        i = ((i >> 4) + i) & 0x0F0F0F0F;
        i += i >> 8;
        i += i >> 16;
        return i & 0x0000003F;
    }
		*/
		return 0;
	}
	
	public static int rotateLeft(int i, int distance){
		
		// Original method
		/*
		{
        
        return (i << distance) | (i >>> -distance);
    }
		*/
		return 0;
	}
	
	public static int rotateRight(int i, int distance){
		
		// Original method
		/*
		{
        
        return (i >>> distance) | (i << -distance);
    }
		*/
		return 0;
	}
	
	public static int reverseBytes(int i){
		
		// Original method
		/*
		{
        
        
        i =    ((i >>>  8) & 0x00FF00FF) | ((i & 0x00FF00FF) <<  8);
        return ( i >>> 16              ) | ( i               << 16);
    }
		*/
		return 0;
	}
	
	public static int reverse(int i){
		
		// Original method
		/*
		{
        
        
        i =    ((i >>>  1) & 0x55555555) | ((i & 0x55555555) <<  1);
        i =    ((i >>>  2) & 0x33333333) | ((i & 0x33333333) <<  2);
        i =    ((i >>>  4) & 0x0F0F0F0F) | ((i & 0x0F0F0F0F) <<  4);
        i =    ((i >>>  8) & 0x00FF00FF) | ((i & 0x00FF00FF) <<  8);
        return ((i >>> 16)             ) | ((i             ) << 16);
    }
		*/
		return 0;
	}
	
	public static int signum(int i){
		
		// Original method
		/*
		{
        return (i >> 31) | (-i >>> 31); 
    }
		*/
		return 0;
	}
	
	@DSModeled(DSC.SAFE)
	public static Integer valueOf(int i){
		return new Integer(i);
		// Original method
		/*
		{
        return  i >= 128 || i < -128 ? new Integer(i) : SMALL_VALUES[i + 128];
    }
		*/
	}
	private static final Integer[] SMALL_VALUES = new Integer[256];
}


