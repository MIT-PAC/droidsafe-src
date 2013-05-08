package java.lang;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSTaintObject;

public class Long extends Number implements Comparable<Long> {

	private DSTaintObject taint = new DSTaintObject();
	
	@DSModeled(DSC.SAFE)
	public Long(String s) throws NumberFormatException {
		taint.addTaint(s);
    }
	
	@DSModeled(DSC.SAFE)
	public Long(long value) {
		taint.addTaint(value);
    }
	
	@DSModeled(DSC.SAFE)
	public static Long valueOf(long l) {
		return new Long(l);
	}
	
	@Override
	public int compareTo(Long o) {
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
	@DSModeled(DSC.SAFE)
	public long longValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}
