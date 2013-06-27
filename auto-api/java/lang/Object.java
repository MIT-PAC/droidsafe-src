package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Object {
	//do not create DSTaintObject, allocations of DSTaintObject are added to the code by 
    //the DroidSafe tool when needed.
	public DSTaintObject taint;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 13:18:45.585 -0400", hash_original_method = "1035BC9FD37C3D2AC57825226BBB0539", hash_generated_method = "5CDBD442E1AC1C77BDFC3434B00402E2")
    @DSModeled(DSC.SAFE)
    public  Object() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 13:18:45.619 -0400", hash_original_method = "6E1D6DBADCF2AAA505FF9A52A4C04C6C", hash_generated_method = "D871942827E31CAADC6A7F02CE1EB315")
    @DSModeled(DSC.SAFE)
    protected Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_708426382 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new CloneNotSupportedException("Class doesn't implement Cloneable");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_708426382 = internalClone((Cloneable) this);
        varB4EAC82CA7396A68D541C85D26508E83_708426382.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_708426382;
        // ---------- Original Method ----------
        //if (!(this instanceof Cloneable)) {
            //throw new CloneNotSupportedException("Class doesn't implement Cloneable");
        //}
        //return internalClone((Cloneable) this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 13:18:45.633 -0400", hash_original_method = "DC17854DB4C4786A4B8C4AFD2060B404", hash_generated_method = "A43E05FEA5D61737BBCA795F23B88103")
    @DSModeled(DSC.SAFE)
    private Object internalClone(Cloneable o) {
    	Object retVal = new Object();
    	retVal.addTaint(getTaint());
    	return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 13:18:45.654 -0400", hash_original_method = "9AE1611573D7E7CF89E7E933B2D1DCAF", hash_generated_method = "B5D3C6032D4405140F96646220CD8D86")
    @DSModeled(DSC.SAFE)
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_910900821 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_910900821;
        // ---------- Original Method ----------
        //return this == o;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 13:18:45.671 -0400", hash_original_method = "D7EA50355B500A6304213C79BC9E9E09", hash_generated_method = "0569B823B01EAAF4436AADD06F3EDAD4")
    @DSModeled(DSC.SAFE)
    @FindBugsSuppressWarnings("FI_EMPTY")
    protected void finalize() throws Throwable {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 13:18:45.696 -0400", hash_original_method = "45F37CFDFF4C9798D584EC7971F96E39", hash_generated_method = "626427EC1E11FF0AD97BEE85D9A44D76")
    @DSModeled(DSC.SAFE)
    public final native Class<?> getClass();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 13:18:45.701 -0400", hash_original_method = "55C270AB7FB96DF5C59CA61A88D62880", hash_generated_method = "18EF0DAAA163CF67DDDF471DC2DB307A")
    @DSModeled(DSC.SAFE)
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_150298221 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_150298221;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 13:18:45.704 -0400", hash_original_method = "2491F7F734B89141B57F81CC2F5A48BA", hash_generated_method = "24636598DAEB30DC24F56D9FFC3488A3")
    @DSModeled(DSC.SAFE)
    public final void notify() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 13:18:45.728 -0400", hash_original_method = "4A0AA061C7039561E8E17F1D3678B2F2", hash_generated_method = "173C9CD26391D0CD02E4542ECF728D5B")
    @DSModeled(DSC.SAFE)
    public final void notifyAll() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 13:18:45.742 -0400", hash_original_method = "7905F5E0624643BB59BB03B2872919E1", hash_generated_method = "20877D866004FCA741A131E577B08A44")
    @DSModeled(DSC.SAFE)
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1074373299 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1074373299 = getClass().getName() + '@' + Integer.toHexString(hashCode());
        varB4EAC82CA7396A68D541C85D26508E83_1074373299.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1074373299;
        // ---------- Original Method ----------
        //return getClass().getName() + '@' + Integer.toHexString(hashCode());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 13:18:45.761 -0400", hash_original_method = "6FE2BE558DA9BAF1A2BFC29AD62222DA", hash_generated_method = "D3C95538C6A30BC3CA9D7492E38DB311")
    @DSModeled(DSC.SAFE)
    public final void wait() throws InterruptedException {
        wait(0 ,0);
        // ---------- Original Method ----------
        //wait(0 ,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 13:18:45.772 -0400", hash_original_method = "4BB57D31A4F088800B6AE0C762E042CC", hash_generated_method = "554233B4BAE655607A00130D00F272A3")
    @DSModeled(DSC.SAFE)
    public final void wait(long millis) throws InterruptedException {
        wait(millis, 0);
        addTaint(millis);
        // ---------- Original Method ----------
        //wait(millis, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 13:18:45.786 -0400", hash_original_method = "2C3F1320C25E20DEBA9A5B7EE716C215", hash_generated_method = "489C6064F7B80B8C516AED1465CADB5A")
    @DSModeled(DSC.SAFE)
    public final void wait(long millis, int nanos) throws InterruptedException {
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