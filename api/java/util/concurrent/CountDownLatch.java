package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.concurrent.locks.*;
import java.util.concurrent.atomic.*;

public class CountDownLatch {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.897 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

    private Sync sync;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.898 -0400", hash_original_method = "4C9DACB295593778FC44AB86E8E7D747", hash_generated_method = "878EEFAED4F1781557AF5F6F93883A06")
    public  CountDownLatch(int count) {
        if(count < 0)        
        {
        IllegalArgumentException varAEB2F18A5228FBCF89210BA55B20E012_1573907968 = new IllegalArgumentException("count < 0");
        varAEB2F18A5228FBCF89210BA55B20E012_1573907968.addTaint(taint);
        throw varAEB2F18A5228FBCF89210BA55B20E012_1573907968;
        }
        this.sync = new Sync(count);
        // ---------- Original Method ----------
        //if (count < 0) throw new IllegalArgumentException("count < 0");
        //this.sync = new Sync(count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.898 -0400", hash_original_method = "A9727D614A84DE128F63540E6073A44B", hash_generated_method = "D070BA44558B523604A261CE2882A091")
    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(1);
        // ---------- Original Method ----------
        //sync.acquireSharedInterruptibly(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.898 -0400", hash_original_method = "0AAF9EA81FFD8AD9617435605CC7D253", hash_generated_method = "0E37C8C4F11E9D5F535DD9C80AE9F369")
    public boolean await(long timeout, TimeUnit unit) throws InterruptedException {
        addTaint(unit.getTaint());
        addTaint(timeout);
        boolean varF9FFBA7272EE05E2720644344A388E0D_1588427728 = (sync.tryAcquireSharedNanos(1, unit.toNanos(timeout)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_267514312 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_267514312;
        // ---------- Original Method ----------
        //return sync.tryAcquireSharedNanos(1, unit.toNanos(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.899 -0400", hash_original_method = "ACB2575EE39865032078A7B67E3D5076", hash_generated_method = "5F72B9A21B37F73F93872F70DF24474A")
    public void countDown() {
        sync.releaseShared(1);
        // ---------- Original Method ----------
        //sync.releaseShared(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.899 -0400", hash_original_method = "ABE42AE497B23B643FDF7DC2348A1AF5", hash_generated_method = "30FAD490185C65E7B12A80092F1080CD")
    public long getCount() {
        long varEADBA8DEF1BC9738D4EDEC8923318B63_1820788281 = (sync.getCount());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1325019285 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1325019285;
        // ---------- Original Method ----------
        //return sync.getCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.899 -0400", hash_original_method = "45A2072B871660339FAF307330C7F60C", hash_generated_method = "50F7417895D9E7B702988A410A8D0DD6")
    public String toString() {
String var4D62EFEC3E50E2AF5780683B34D1CC77_1047917073 =         super.toString() + "[Count = " + sync.getCount() + "]";
        var4D62EFEC3E50E2AF5780683B34D1CC77_1047917073.addTaint(taint);
        return var4D62EFEC3E50E2AF5780683B34D1CC77_1047917073;
        // ---------- Original Method ----------
        //return super.toString() + "[Count = " + sync.getCount() + "]";
    }

    
    private static final class Sync extends AbstractQueuedSynchronizer {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.899 -0400", hash_original_method = "9968F5AA54B3A1250121D3E0CFE14724", hash_generated_method = "8A0C888A5DA83A3653D6DAE983FA987D")
          Sync(int count) {
            addTaint(count);
            setState(count);
            // ---------- Original Method ----------
            //setState(count);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.899 -0400", hash_original_method = "192D38E698A214D58DA93C3298AD6AD3", hash_generated_method = "D76C126A40078DAB75BE277EFD8A3565")
         int getCount() {
            int var118C4F58F1303398C344B8AAB7CE6EE1_61522169 = (getState());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_408057163 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_408057163;
            // ---------- Original Method ----------
            //return getState();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.900 -0400", hash_original_method = "5121E365AD686AC5D590ECBA2BCA053C", hash_generated_method = "B94527C2B27C967EA2772D1810BD27BF")
        protected int tryAcquireShared(int acquires) {
            addTaint(acquires);
            int var3EC71F3BC01146A4D6BAB5C90EB4C53B_1219580340 = ((getState() == 0) ? 1 : -1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1824123277 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1824123277;
            // ---------- Original Method ----------
            //return (getState() == 0) ? 1 : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.900 -0400", hash_original_method = "136302DDF9CF08EA1ED73402F05AC756", hash_generated_method = "D56D384F8B12CB6AC2A8D982FFA88460")
        protected boolean tryReleaseShared(int releases) {
            addTaint(releases);
for(;;)
            {
                int c = getState();
                if(c == 0)                
                {
                boolean var68934A3E9455FA72420237EB05902327_813315639 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1559443340 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1559443340;
                }
                int nextc = c-1;
                if(compareAndSetState(c, nextc))                
                {
                boolean varFE567596D7CBF2AAC320D09D88315819_522854758 = (nextc == 0);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1309037808 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1309037808;
                }
            } //End block
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.901 -0400", hash_original_field = "69F97A85B2FBB03A012E5B08317FA038", hash_generated_field = "CC4AEE6AD5E042E09631015E4C8CF188")

        private static final long serialVersionUID = 4982264981922014374L;
    }


    
}

