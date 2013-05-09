package java.lang;

import droidsafe.annotations.*;
import droidsafe.helpers.*;

public final class Float extends Number implements Comparable<Float> {
	private DSTaintObject dsTaint = new DSTaintObject();
	
	public static final Class<Float> TYPE = new Class<Float>();

	@Override
	public int compareTo(Float arg0) {
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
	public Float(float value) {
		dsTaint.addTaint(value);
        //this.value = value;
    }

	@DSModeled(DSC.SAFE)
	public static Float valueOf(float f) {
        return new Float(f);
    }
	
	@DSModeled(DSC.SAFE)
	@Override
    public int hashCode() {
		return dsTaint.getTaintInt();
        //return floatToIntBits(value);
    }
}
