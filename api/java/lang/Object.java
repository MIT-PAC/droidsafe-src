package java.lang;

import droidsafe.annotations.*;
import droidsafe.helpers.*;

public class Object {
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
}
