package droidsafe.helpers;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class DSTaintObject {
	private Object taint;
	
	@DSModeled(DSC.BAN)
	public DSTaintObject() {
	}
	
	/* Do not use this anymore because we associate taint with fields
	 * and primitives, and this generic call can confuse.
	@DSModeled(DSC.BAN)
	public void addTaints(Object... taints) {
		for (Object t : taints)
			addTaint(t);
	}
	*/
	
	@DSModeled(DSC.BAN)
	public void addTaint(boolean i) {
		this.taint = new Boolean(i);
	}

	@DSModeled(DSC.BAN)
	public void addTaint(byte i) {
		this.taint = new Byte(i);
	}

	@DSModeled(DSC.BAN)
	public void addTaint(char i) {
		this.taint = new Character(i);
	}

	@DSModeled(DSC.BAN)
	public void addTaint(CharSequence i) {
		this.taint = new CharSequence(i);
	}
	
	@DSModeled(DSC.BAN)
	public void addTaint(double i) {
		this.taint = new Double(i);
	}
	
	@DSModeled(DSC.BAN)
	public void addTaint(float i) {
		this.taint = new Float(i);
	}
	
	@DSModeled(DSC.BAN)
	public void addTaint(int i) {
		this.taint = new Integer(i);
	}

	@DSModeled(DSC.BAN)
	public void addTaint(long i) {
		this.taint = new Long(i);
	}

	@DSModeled(DSC.BAN)
	public void addTaint(short i) {
		this.taint = new Short(i);
	}
	
	@DSModeled(DSC.BAN)
	public void addTaint(String s) {
		this.taint = new String(s);
	}
	
	@DSModeled(DSC.BAN)
	public void addTaint(boolean[] i) {
		this.taint = new boolean[0];
	}

	@DSModeled(DSC.BAN)
	public void addTaint(byte[] i) {
		this.taint = new byte[0];
	}

	@DSModeled(DSC.BAN)
	public void addTaint(char[] i) {
		this.taint = new char[0];
	}
	
	@DSModeled(DSC.BAN)
	public void addTaint(CharSequence[] s) {
		this.taint = new CharSequence[0];
	}
	
	@DSModeled(DSC.BAN)
	public void addTaint(double[] i) {
		this.taint = new double[0];
	}
	
	@DSModeled(DSC.BAN)
	public void addTaint(float[] i) {
		this.taint = new float[0];
	}
	
	@DSModeled(DSC.BAN)
	public void addTaint(int[] i) {
		this.taint = new int[0];
	}

	@DSModeled(DSC.BAN)
	public void addTaint(long[] i) {
		this.taint = new long[0];
	}

	@DSModeled(DSC.BAN)
	public void addTaint(short[] i) {
		this.taint = new short[0];
	}
	
	@DSModeled(DSC.BAN)
	public void addTaint(String[] s) {
		this.taint = new String[0];
	}

	@DSModeled(DSC.BAN)
	public void addTaint(DSTaintObject obj) {
		this.taint = obj;
	}
	
	@DSModeled(DSC.BAN)
	public Object getTaint() {
		return null;
	}
	
	@DSModeled(DSC.BAN)
	public char getTaintChar() {
		return (char)0;
	}
	
	@DSModeled(DSC.BAN)
	public short getTaintShort() {
		return (short)0;
	}
	
	@DSModeled(DSC.BAN)
	public int getTaintInt() {
		return 0;
	}
	
	@DSModeled(DSC.BAN)
	public long getTaintLong() {
		return 0L;
	}
	
	@DSModeled(DSC.BAN)
	public float getTaintFloat() {
		return 0f;
	}
	
	@DSModeled(DSC.BAN)
	public double getTaintDouble() {
		return 0.0D;
	}
	
	@DSModeled(DSC.BAN)
	public String getTaintString() {
		return "";
	}
	
	@DSModeled(DSC.BAN)
	public boolean getTaintBoolean() {
		return false;
	}	
	
	@DSModeled(DSC.BAN)
	public byte getTaintByte() {
		return 0;
	}	
}

