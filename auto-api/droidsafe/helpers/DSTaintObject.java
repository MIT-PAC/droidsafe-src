package droidsafe.helpers;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class DSTaintObject {
    private double taintDouble;
    private boolean taintBoolean;
    private Object taintObject;

    @DSModeled(DSC.BAN)
    public void addTaint(double taint) {
        taintDouble = taint;
    }

    @DSModeled(DSC.BAN)
    public void addTaint(boolean taint) {
        taintBoolean = taint;
    }

    @DSModeled(DSC.BAN)
    public void addTaint(Object taint) {
        taintObject = taint;
    }

    @DSModeled(DSC.BAN)
    public byte getTaintByte() {
        return (byte)taintDouble;
    }

    @DSModeled(DSC.BAN)
    public short getTaintShort() {
        return (short)taintDouble;
    }

    @DSModeled(DSC.BAN)
    public int getTaintInt() {
        return (int)taintDouble;
    }

    @DSModeled(DSC.BAN)
    public long getTaintLong() {
        return (long)taintDouble;
    }

    @DSModeled(DSC.BAN)
    public float getTaintFloat() {
        return (float)taintDouble;
    }

    @DSModeled(DSC.BAN)
    public double getTaintDouble() {
        return taintDouble;
    }

    @DSModeled(DSC.BAN)
    public boolean getTaintBoolean() {
        return taintBoolean;
    }

    @DSModeled(DSC.BAN)
    public char getTaintChar() {
        return (char)taintDouble;
    }

    @DSModeled(DSC.BAN)
    public Object getTaintObject() {
        return taintObject;
    }

    @DSModeled(DSC.BAN)
    public String getTaintString() {
        return (String)taintObject;
    }

    @DSModeled(DSC.BAN)
    public byte[] getTaintByteArray() {
        return (byte[])taintObject;
    }

    @DSModeled(DSC.BAN)
    public short[] getTaintShortArray() {
        return (short[])taintObject;
    }

    @DSModeled(DSC.BAN)
    public int[] getTaintIntArray() {
        return (int[])taintObject;
    }

    @DSModeled(DSC.BAN)
    public long[] getTaintLongArray() {
        return (long[])taintObject;
    }

    @DSModeled(DSC.BAN)
    public float[] getTaintFloatArray() {
        return (float[])taintObject;
    }

    @DSModeled(DSC.BAN)
    public double[] getTaintDoubleArray() {
        return (double[])taintObject;
    }

    @DSModeled(DSC.BAN)
    public boolean[] getTaintBooleanArray() {
        return (boolean[])taintObject;
    }

    @DSModeled(DSC.BAN)
    public char[] getTaintCharArray() {
        return (char[])taintObject;
    }

    @DSModeled(DSC.BAN)
    public Object[] getTaintObjectArray() {
        return (Object[])taintObject;
    }

    @DSModeled(DSC.BAN)
    public String[] getTaintStringArray() {
        return (String[])taintObject;
    }
}

