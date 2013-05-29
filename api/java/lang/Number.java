package java.lang;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;


public abstract class Number implements java.io.Serializable {
	
	private static final long serialVersionUID = -8742448824652078965L;
	
	@DSModeled(DSC.SAFE)
	Number(){
	}
	
	public byte byteValue(){
		
		// Original method
		/*
		{
        return (byte) intValue();
    }
		*/
		return 0;
	}
	
	public abstract double doubleValue();
	
	public abstract float floatValue();
	
	public abstract int intValue();
	
	public abstract long longValue();
	
	public short shortValue(){
		
		// Original method
		/*
		{
        return (short) intValue();
    }
		*/
		return 0;
	}
}


