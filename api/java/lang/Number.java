package java.lang;

import droidsafe.annotations.*;
import droidsafe.helpers.*;

public abstract class Number implements java.io.Serializable {
	@DSModeled(DSC.SAFE)
	public Number() {
    }
	
	public abstract double doubleValue();
	public abstract float floatValue();
	public abstract int intValue();
	public abstract long longValue();
}
