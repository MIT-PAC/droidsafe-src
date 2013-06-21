package java.lang;

import java.io.Serializable;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public final class Boolean implements Serializable, Comparable<Boolean> {
	public static final Boolean TRUE = new Boolean(true);
	public static final Boolean FALSE = new Boolean(false);
	private static final long serialVersionUID = -3665804199014368530L;
	
	public static final Class<Boolean> TYPE = new Class<Boolean>();

	private final boolean value;
	
	@DSModeled(DSC.SAFE)
	public Boolean(boolean value) {
		addTaint(value.getTaint());
        this.value = value;
    }
	
	@DSModeled(DSC.SAFE)
	public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

	@Override
	public int compareTo(Boolean that) {
        return compare(value, that.value);
    }
	
	public static int compare(boolean lhs, boolean rhs) {
		return 0;
        //return lhs == rhs ? 0 : lhs ? 1 : -1;
    }
	
	public boolean booleanValue() {
		return getTaintBoolean();
        //return value;
    }
	
	@DSModeled(DSC.SAFE)
	@Override
    public int hashCode() {
		return getTaintInt();  //Technically the hash code is derived from the value
        //return value ? 1231 : 1237;
    }
}
