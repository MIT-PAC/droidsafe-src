package java.lang;

// Droidsafe Imports
import droidsafe.annotations.*;



import droidsafe.helpers.DSTaintObject;

public class Object {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.382 -0400", hash_original_method = "1035BC9FD37C3D2AC57825226BBB0539", hash_generated_method = "5CDBD442E1AC1C77BDFC3434B00402E2")
    public  Object() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.382 -0400", hash_original_method = "6E1D6DBADCF2AAA505FF9A52A4C04C6C", hash_generated_method = "7BD08C4B7BD9668043F5624AF55451A4")
    protected Object clone() throws CloneNotSupportedException {
        if(!(this instanceof Cloneable))        
        {
            CloneNotSupportedException varAAEB03D14830D479070633B166EED001_1798330854 = new CloneNotSupportedException("Class doesn't implement Cloneable");
            varAAEB03D14830D479070633B166EED001_1798330854.addTaint(taint);
            throw varAAEB03D14830D479070633B166EED001_1798330854;
        } //End block
        
        //fix for cloning, just return this statement
        
        return this;
        // ---------- Original Method ----------
        //if (!(this instanceof Cloneable)) {
            //throw new CloneNotSupportedException("Class doesn't implement Cloneable");
        //}
        //return internalClone((Cloneable) this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 13:18:45.633 -0400", hash_original_method = "DC17854DB4C4786A4B8C4AFD2060B404", hash_generated_method = "A43E05FEA5D61737BBCA795F23B88103")
    @DSModeled(DSC.SAFE)
    private Object internalClone(Cloneable o) {
    	 //Object retVal = new Object();
    	//retVal.addTaint(getTaint());
        
        //fix for cloning, just return the this statement
    	return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.382 -0400", hash_original_method = "9AE1611573D7E7CF89E7E933B2D1DCAF", hash_generated_method = "2841EB1D7DD058C073887CF168ABD267")
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        boolean var43E614DB0261BC0DACCD354054A9A7B0_610480446 = (this == o);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1505920517 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1505920517;
        // ---------- Original Method ----------
        //return this == o;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.382 -0400", hash_original_method = "D7EA50355B500A6304213C79BC9E9E09", hash_generated_method = "822E50DAC95823FB20C4852B1A92C75F")
    protected void finalize() throws Throwable {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 13:18:45.696 -0400", hash_original_method = "45F37CFDFF4C9798D584EC7971F96E39", hash_generated_method = "626427EC1E11FF0AD97BEE85D9A44D76")
    @DSModeled(DSC.SAFE)
    public final native Class<?> getClass();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.382 -0400", hash_original_method = "55C270AB7FB96DF5C59CA61A88D62880", hash_generated_method = "2959A6B5EAED190470B4404C76818546")
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_45017839 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_45017839;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.382 -0400", hash_original_method = "2491F7F734B89141B57F81CC2F5A48BA", hash_generated_method = "24636598DAEB30DC24F56D9FFC3488A3")
    public final void notify() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.382 -0400", hash_original_method = "4A0AA061C7039561E8E17F1D3678B2F2", hash_generated_method = "173C9CD26391D0CD02E4542ECF728D5B")
    public final void notifyAll() {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.383 -0400", hash_original_method = "7905F5E0624643BB59BB03B2872919E1", hash_generated_method = "04C24610331DC8120DB4C2F52DC4EFBB")
    public String toString() {
String varAE0EADF9464BE15954001C46E90E161A_304024652 =         getClass().getName() + '@' + Integer.toHexString(hashCode());
        varAE0EADF9464BE15954001C46E90E161A_304024652.addTaint(taint);
        return varAE0EADF9464BE15954001C46E90E161A_304024652;
        // ---------- Original Method ----------
        //return getClass().getName() + '@' + Integer.toHexString(hashCode());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.383 -0400", hash_original_method = "6FE2BE558DA9BAF1A2BFC29AD62222DA", hash_generated_method = "D3C95538C6A30BC3CA9D7492E38DB311")
    public final void wait() throws InterruptedException {
        wait(0 ,0);
        // ---------- Original Method ----------
        //wait(0 ,0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.383 -0400", hash_original_method = "4BB57D31A4F088800B6AE0C762E042CC", hash_generated_method = "7B447C52369D4F80FDCA77102F19E44A")
    public final void wait(long millis) throws InterruptedException {
        addTaint(millis);
        wait(millis, 0);
        // ---------- Original Method ----------
        //wait(millis, 0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.383 -0400", hash_original_method = "2C3F1320C25E20DEBA9A5B7EE716C215", hash_generated_method = "489C6064F7B80B8C516AED1465CADB5A")
    public final void wait(long millis, int nanos) throws InterruptedException {
    }

    
    // orphaned legacy method
    @DSModeled(DSC.BAN)
    public DSTaintObject getTaint() {
        
        return taint;
    }
    
    // orphaned legacy method
    @DSModeled(DSC.BAN)
    public int getTaintInt() {
        
        return 0;
    }
    
    // orphaned legacy method
    @DSModeled(DSC.BAN)
    public void addTaint(DSTaintObject taint) {
        
    }
    
    // orphaned legacy method
    @DSModeled(DSC.BAN)
    public short getTaintShort() {
        
        return 0;
    }
    
    // orphaned legacy method
    @DSModeled(DSC.BAN)
    public byte getTaintByte() {
        
        return 0;
    }
    
    // orphaned legacy method
    @DSModeled(DSC.BAN)
    public void addTaint(boolean taint) {
      
    }
    
    // orphaned legacy method
    @DSModeled(DSC.BAN)
    public boolean getTaintBoolean() {
        
        return true;
    }
    
    // orphaned legacy method
    @DSModeled(DSC.BAN)
    public char getTaintChar() {
        
        return 0;
    }
    
    // orphaned legacy method
    @DSModeled(DSC.BAN)
    public float getTaintFloat() {
        
        return 0;
    }
    
    // orphaned legacy method
    @DSModeled(DSC.BAN)
    public double getTaintDouble() {
        
        return 0;
    }
    
    // orphaned legacy method
    @DSModeled(DSC.BAN)
    public long getTaintLong() {
        
        return 0;
    }
    
    // orphaned legacy method
    @DSModeled(DSC.BAN)
    public void addTaint(double taint) {
        
    }
    
    // orphaned legacy field
    public DSTaintObject taint;
    
}

