package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.concurrent.locks.*;
import java.util.concurrent.atomic.*;

public class CountDownLatch {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.347 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

    private Sync sync;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.347 -0400", hash_original_method = "4C9DACB295593778FC44AB86E8E7D747", hash_generated_method = "17F26F23175D66830A53D7DC96BBD403")
    public  CountDownLatch(int count) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("count < 0");
        this.sync = new Sync(count);
        // ---------- Original Method ----------
        //if (count < 0) throw new IllegalArgumentException("count < 0");
        //this.sync = new Sync(count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.347 -0400", hash_original_method = "A9727D614A84DE128F63540E6073A44B", hash_generated_method = "D070BA44558B523604A261CE2882A091")
    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(1);
        // ---------- Original Method ----------
        //sync.acquireSharedInterruptibly(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.348 -0400", hash_original_method = "0AAF9EA81FFD8AD9617435605CC7D253", hash_generated_method = "B70F8C19E150E4BF2369E81A2E67EAB4")
    public boolean await(long timeout, TimeUnit unit) throws InterruptedException {
        boolean varD12778331A5B05E1E52D9468F6FF0E07_1228938971 = (sync.tryAcquireSharedNanos(1, unit.toNanos(timeout)));
        addTaint(timeout);
        addTaint(unit.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1853573662 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1853573662;
        // ---------- Original Method ----------
        //return sync.tryAcquireSharedNanos(1, unit.toNanos(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.348 -0400", hash_original_method = "ACB2575EE39865032078A7B67E3D5076", hash_generated_method = "5F72B9A21B37F73F93872F70DF24474A")
    public void countDown() {
        sync.releaseShared(1);
        // ---------- Original Method ----------
        //sync.releaseShared(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.348 -0400", hash_original_method = "ABE42AE497B23B643FDF7DC2348A1AF5", hash_generated_method = "F535A0C546861A03B9FFFDAC871C3179")
    public long getCount() {
        long var3E7EE26A585DAEF98B448A2C779F0B42_504580203 = (sync.getCount());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1983493959 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1983493959;
        // ---------- Original Method ----------
        //return sync.getCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.372 -0400", hash_original_method = "45A2072B871660339FAF307330C7F60C", hash_generated_method = "A0CCE097BE6581C0A9640D2D7F51D500")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1741835581 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1741835581 = super.toString() + "[Count = " + sync.getCount() + "]";
        varB4EAC82CA7396A68D541C85D26508E83_1741835581.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1741835581;
        // ---------- Original Method ----------
        //return super.toString() + "[Count = " + sync.getCount() + "]";
    }

    
    private static final class Sync extends AbstractQueuedSynchronizer {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.372 -0400", hash_original_method = "9968F5AA54B3A1250121D3E0CFE14724", hash_generated_method = "9BB36C580E3DFB237981164E8A505DAF")
          Sync(int count) {
            setState(count);
            addTaint(count);
            // ---------- Original Method ----------
            //setState(count);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.372 -0400", hash_original_method = "192D38E698A214D58DA93C3298AD6AD3", hash_generated_method = "4656CE709F4FAD8761CE8CCB442BF3F5")
         int getCount() {
            int var376B5C2087169E76FB6628D31DCC9663_1351331216 = (getState());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_989644849 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_989644849;
            // ---------- Original Method ----------
            //return getState();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.373 -0400", hash_original_method = "5121E365AD686AC5D590ECBA2BCA053C", hash_generated_method = "76A5C516B1360D91E9186B1D580F5172")
        protected int tryAcquireShared(int acquires) {
            {
                boolean varB9A8967EEEE626B2D88454F1CD4A1CB3_11471028 = ((getState() == 0));
            } //End flattened ternary
            addTaint(acquires);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_118036020 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_118036020;
            // ---------- Original Method ----------
            //return (getState() == 0) ? 1 : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.373 -0400", hash_original_method = "136302DDF9CF08EA1ED73402F05AC756", hash_generated_method = "3A83BDFA419C8C46EB0872869F4E9BC6")
        protected boolean tryReleaseShared(int releases) {
            {
                int c;
                c = getState();
                int nextc;
                nextc = c-1;
                {
                    boolean var525F59EF5A984E7DE1A679CCEEFC8101_1337132781 = (compareAndSetState(c, nextc));
                } //End collapsed parenthetic
            } //End block
            addTaint(releases);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1868835700 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1868835700;
            // ---------- Original Method ----------
            //for (;;) {
                //int c = getState();
                //if (c == 0)
                    //return false;
                //int nextc = c-1;
                //if (compareAndSetState(c, nextc))
                    //return nextc == 0;
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.373 -0400", hash_original_field = "69F97A85B2FBB03A012E5B08317FA038", hash_generated_field = "149823ABB3559D1631C7C00C01D4A89F")

        private static long serialVersionUID = 4982264981922014374L;
    }


    
}

