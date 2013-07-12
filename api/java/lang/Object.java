package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class Object {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.051 -0400", hash_original_method = "1035BC9FD37C3D2AC57825226BBB0539", hash_generated_method = "5CDBD442E1AC1C77BDFC3434B00402E2")
    public  Object() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.051 -0400", hash_original_method = "6E1D6DBADCF2AAA505FF9A52A4C04C6C", hash_generated_method = "FE87500C80F4239FEAD9AD81D730B2F5")
    protected Object clone() throws CloneNotSupportedException {
    if(!(this instanceof Cloneable))        
        {
            CloneNotSupportedException varAAEB03D14830D479070633B166EED001_72583569 = new CloneNotSupportedException("Class doesn't implement Cloneable");
            varAAEB03D14830D479070633B166EED001_72583569.addTaint(taint);
            throw varAAEB03D14830D479070633B166EED001_72583569;
        } 
Object var5D97285CC21650E6D41723F3E22233BE_31365219 =         internalClone((Cloneable) this);
        var5D97285CC21650E6D41723F3E22233BE_31365219.addTaint(taint);
        return var5D97285CC21650E6D41723F3E22233BE_31365219;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 13:18:45.633 -0400", hash_original_method = "DC17854DB4C4786A4B8C4AFD2060B404", hash_generated_method = "A43E05FEA5D61737BBCA795F23B88103")
    @DSModeled(DSC.SAFE)
    private Object internalClone(Cloneable o) {
    	Object retVal = new Object();
    	retVal.addTaint(getTaint());
    	return retVal;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.052 -0400", hash_original_method = "9AE1611573D7E7CF89E7E933B2D1DCAF", hash_generated_method = "1EDDF6D71EB35041F0C774CE64A4480E")
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        boolean var43E614DB0261BC0DACCD354054A9A7B0_243493970 = (this == o);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_324026137 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_324026137;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.052 -0400", hash_original_method = "D7EA50355B500A6304213C79BC9E9E09", hash_generated_method = "822E50DAC95823FB20C4852B1A92C75F")
    protected void finalize() throws Throwable {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 13:18:45.696 -0400", hash_original_method = "45F37CFDFF4C9798D584EC7971F96E39", hash_generated_method = "626427EC1E11FF0AD97BEE85D9A44D76")
    @DSModeled(DSC.SAFE)
    public final native Class<?> getClass();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.053 -0400", hash_original_method = "55C270AB7FB96DF5C59CA61A88D62880", hash_generated_method = "CDC00AF590C96B2F3248107D4B410133")
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_505944210 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_505944210;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.053 -0400", hash_original_method = "2491F7F734B89141B57F81CC2F5A48BA", hash_generated_method = "24636598DAEB30DC24F56D9FFC3488A3")
    public final void notify() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.054 -0400", hash_original_method = "4A0AA061C7039561E8E17F1D3678B2F2", hash_generated_method = "173C9CD26391D0CD02E4542ECF728D5B")
    public final void notifyAll() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.054 -0400", hash_original_method = "7905F5E0624643BB59BB03B2872919E1", hash_generated_method = "F6B90F5EF9FFD57BE3AEF09E66DB2DE3")
    public String toString() {
String varAE0EADF9464BE15954001C46E90E161A_1273813275 =         getClass().getName() + '@' + Integer.toHexString(hashCode());
        varAE0EADF9464BE15954001C46E90E161A_1273813275.addTaint(taint);
        return varAE0EADF9464BE15954001C46E90E161A_1273813275;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.054 -0400", hash_original_method = "6FE2BE558DA9BAF1A2BFC29AD62222DA", hash_generated_method = "D3C95538C6A30BC3CA9D7492E38DB311")
    public final void wait() throws InterruptedException {
        wait(0 ,0);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.055 -0400", hash_original_method = "4BB57D31A4F088800B6AE0C762E042CC", hash_generated_method = "7B447C52369D4F80FDCA77102F19E44A")
    public final void wait(long millis) throws InterruptedException {
        addTaint(millis);
        wait(millis, 0);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.056 -0400", hash_original_method = "2C3F1320C25E20DEBA9A5B7EE716C215", hash_generated_method = "489C6064F7B80B8C516AED1465CADB5A")
    public final void wait(long millis, int nanos) throws InterruptedException {
    }

    
    
    @DSModeled(DSC.BAN)
    public void addTaint(DSTaintObject taint) {
        
    }
    
    
    @DSModeled(DSC.BAN)
    public int getTaintInt() {
        
        return 0;
    }
    
    
    @DSModeled(DSC.BAN)
    public DSTaintObject getTaint() {
        
        return taint;
    }
    
    
    @DSModeled(DSC.BAN)
    public short getTaintShort() {
        
        return 0;
    }
    
    
    @DSModeled(DSC.BAN)
    public void addTaint(boolean taint) {
      
    }
    
    
    @DSModeled(DSC.BAN)
    public byte getTaintByte() {
        
        return 0;
    }
    
    
    @DSModeled(DSC.BAN)
    public boolean getTaintBoolean() {
        
        return true;
    }
    
    
    @DSModeled(DSC.BAN)
    public float getTaintFloat() {
        
        return 0;
    }
    
    
    @DSModeled(DSC.BAN)
    public char getTaintChar() {
        
        return 0;
    }
    
    
    @DSModeled(DSC.BAN)
    public void addTaint(double taint) {
        
    }
    
    
    @DSModeled(DSC.BAN)
    public long getTaintLong() {
        
        return 0;
    }
    
    
    @DSModeled(DSC.BAN)
    public double getTaintDouble() {
        
        return 0;
    }
    
    
    public DSTaintObject taint;
    
}

