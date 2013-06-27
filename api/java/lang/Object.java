package java.lang;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSTaintObject;

public class Object {
    //do not create DSTaintObject, allocations of DSTaintObject are added to the code by 
    //the DroidSafe tool when needed.
	public DSTaintObject taint;
	
	@DSModeled(DSC.SAFE)
	public Object() {
    }
	
	@DSModeled(DSC.SAFE)
	public int hashCode() {
		return 0;
	}
	
	@DSModeled(DSC.SAFE)
	protected void finalize() throws Throwable {
    }
	
	@DSModeled(DSC.SAFE)
	public boolean equals(Object o) {
		return true;
        //return this == o;
    }
	
	//Since this is a fundamental JVM generated item, we will not cut it over to a non-native implementation
	@DSModeled(DSC.SAFE)
	public final native Class<?> getClass();
	
	//Since this is a fundamental JVM generated item, we will not cut it over to a non-native implementation
	@DSModeled(DSC.SAFE)
	private native Object internalClone(Cloneable o);
	
	@DSModeled(DSC.SAFE)
	protected Object clone() throws CloneNotSupportedException {
        if (!(this instanceof Cloneable)) {
            throw new CloneNotSupportedException("Class doesn't implement Cloneable");
        }

        return internalClone((Cloneable) this);
    }
	
	@DSModeled(DSC.SAFE)
	public String toString() {
		return "woot!";
        //return getClass().getName() + '@' + Integer.toHexString(hashCode());
    }
	
	  @DSModeled(DSC.BAN)
	    public void addTaint(double taint) {
	        //this.taint = taint
	        
	    }

	    @DSModeled(DSC.BAN)
	    public void addTaint(boolean taint) {
	      //this.taint = taint
	    }

	    @DSModeled(DSC.BAN)
	    public void addTaint(DSTaintObject taint) {
	        //this.taint = taint
	    }

	    @DSModeled(DSC.BAN)
	    public byte getTaintByte() {
	        //return this.taint
	        return 0;
	    }

	    @DSModeled(DSC.BAN)
	    public short getTaintShort() {
	        //return this.taint
            return 0;
        }

	    @DSModeled(DSC.BAN)
	    public int getTaintInt() {
	        //return this.taint
            return 0;
        }


	    @DSModeled(DSC.BAN)
	    public long getTaintLong() {
	        //return this.taint
            return 0;
        }


	    @DSModeled(DSC.BAN)
	    public float getTaintFloat() {
	        //return this.taint
            return 0;
        }


	    @DSModeled(DSC.BAN)
	    public double getTaintDouble() {
	        //return this.taint
            return 0;
        }


	    @DSModeled(DSC.BAN)
	    public boolean getTaintBoolean() {
	        //return this.taint
	        return true;
	    }

	    @DSModeled(DSC.BAN)
	    public char getTaintChar() {
	        //return this.taint
            return 0;
        }

	    @DSModeled(DSC.BAN)
	    public DSTaintObject getTaint() {
	        //return this.taint
            return taint;
        }


}
