package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public final class Float extends Number implements Comparable<Float> {
	private DSTaintObject dsTaint = new DSTaintObject();
	
	static final int EXPONENT_BIAS = 127;
	static final int EXPONENT_BITS = 9;
	static final int MANTISSA_BITS = 23;
	static final int NON_MANTISSA_BITS = 9;
	static final int SIGN_MASK     = 0x80000000;
	static final int EXPONENT_MASK = 0x7f800000;
	static final int MANTISSA_MASK = 0x007fffff;
	private static final long serialVersionUID = -2671257302660747028L;
	private final float value;
	public static final float MAX_VALUE = 3.40282346638528860e+38f;
	public static final float MIN_VALUE = 1.40129846432481707e-45f;
	public static final float NaN = 0.0f / 0.0f;
	public static final float POSITIVE_INFINITY = 1.0f / 0.0f;
	public static final float NEGATIVE_INFINITY = -1.0f / 0.0f;
	public static final float MIN_NORMAL = 1.1754943508222875E-38f;
	public static final int MAX_EXPONENT = 127;
	public static final int MIN_EXPONENT = -126;
	@SuppressWarnings("unchecked")
    public static final Class<Float> TYPE
            = (Class<Float>) float[].class.getComponentType();
	public static final int SIZE = 32;
	
	@DSModeled(DSC.SAFE)
	public Float(float value){
		dsTaint.addTaint(value);
		this.value = value;
		
		/*
		this.value = value;
		*/
	}
	
	public Float(double value){
		dsTaint.addTaint((float)value);
		this.value = (float)value;
		/*
		this.value = (float) value;
		*/
	}
	
	Float(String string) throws NumberFormatException{
		this(parseFloat(string));
	}
	
	public int compareTo(Float object){
		
		// Original method
		/*
		{
        return compare(value, object.value);
    }
		*/
		return 0;
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
	
	@Override public double doubleValue(){
		return (double)dsTaint.getTaint();
		
		// Original method
		/*
		{
        return value;
    }
		*/
	}
	
	@Override public boolean equals(Object object){
		
		// Original method
		/*
		{
        return (object instanceof Float) &&
                (floatToIntBits(this.value) == floatToIntBits(((Float) object).value));
    }
		*/
		return false;
	}
	
	public static int floatToIntBits(float value){
		
		// Original method
		return 0;
	}
	
	public static int floatToRawIntBits(float value){
		
		// Original method
		return 0;
	}
	
	@Override public float floatValue(){
		return (float)dsTaint.getTaint();
		
		// Original method
		/*
		{
        return value;
    }
		*/
	}
	
	@DSModeled(DSC.SAFE)
	@Override public int hashCode(){
		return dsTaint.getTaintInt();
		// Original method
		/*
		{
        return floatToIntBits(value);
    }
		*/
	}
	
	public static float intBitsToFloat(int bits){
		
		// Original method
		return 0;
	}
	
	@Override public int intValue(){
		
		// Original method
		/*
		{
        return (int) value;
    }
		*/
		return 0;
	}
	
	public boolean isInfinite(){
		
		// Original method
		/*
		{
        return isInfinite(value);
    }
		*/
		return false;
	}
	
	public static boolean isInfinite(float f){
		
		// Original method
		/*
		{
        return (f == POSITIVE_INFINITY) || (f == NEGATIVE_INFINITY);
    }
		*/
		return false;
	}
	
	public boolean isNaN(){
		
		// Original method
		/*
		{
        return isNaN(value);
    }
		*/
		return false;
	}
	
	public static boolean isNaN(float f){
		
		// Original method
		/*
		{
        return f != f;
    }
		*/
		return false;
	}
	
	@Override public long longValue(){
		
		// Original method
		/*
		{
        return (long) value;
    }
		*/
		return 0;
	}
	
	public static float parseFloat(String string){
		
		// Original method
		/*
		{
        return StringToReal.parseFloat(string);
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
	
	@Override public String toString(){
		
		// Original method
		/*
		{
        return Float.toString(value);
    }
		*/
		return "";
	}
	
	public static String toString(float f){
		
		// Original method
		/*
		{
        return RealToString.getInstance().floatToString(f);
    }
		*/
		return "";
	}
	
	public static Float valueOf(String string){
		
		// Original method
		/*
		{
        return parseFloat(string);
    }
		*/
		return null;
	}
	
	public static int compare(float float1, float float2){
		
		// Original method
		/*
		{
        
        if (float1 > float2) {
            return 1;
        }
        if (float2 > float1) {
            return -1;
        }
        if (float1 == float2 && 0.0f != float1) {
            return 0;
        }

        
        if (isNaN(float1)) {
            if (isNaN(float2)) {
                return 0;
            }
            return 1;
        } else if (isNaN(float2)) {
            return -1;
        }

        
        int f1 = floatToRawIntBits(float1);
        int f2 = floatToRawIntBits(float2);
        
        
        
        return (f1 >> 31) - (f2 >> 31);
    }
		*/
		return 0;
	}
	
	@DSModeled(DSC.SAFE)
	public static Float valueOf(float f){
		return new Float(f);
		// Original method
		/*
		{
        return new Float(f);
    }
		*/
	}
	
	public static String toHexString(float f){
		
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return "";
	}
}


