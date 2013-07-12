package java.util.concurrent;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.concurrent.locks.*;
import java.util.concurrent.atomic.*;

public class CountDownLatch {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.442 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

    private Sync sync;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.443 -0400", hash_original_method = "4C9DACB295593778FC44AB86E8E7D747", hash_generated_method = "F27F9AF92BB62969C60B4CE2C4B856EC")
    public  CountDownLatch(int count) {
    if(count < 0)        
        {
        IllegalArgumentException varAEB2F18A5228FBCF89210BA55B20E012_290944776 = new IllegalArgumentException("count < 0");
        varAEB2F18A5228FBCF89210BA55B20E012_290944776.addTaint(taint);
        throw varAEB2F18A5228FBCF89210BA55B20E012_290944776;
        }
        this.sync = new Sync(count);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.443 -0400", hash_original_method = "A9727D614A84DE128F63540E6073A44B", hash_generated_method = "D070BA44558B523604A261CE2882A091")
    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(1);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.443 -0400", hash_original_method = "0AAF9EA81FFD8AD9617435605CC7D253", hash_generated_method = "1A18A5DB6844C5ED467E5DB312F5169A")
    public boolean await(long timeout, TimeUnit unit) throws InterruptedException {
        addTaint(unit.getTaint());
        addTaint(timeout);
        boolean varF9FFBA7272EE05E2720644344A388E0D_1851183470 = (sync.tryAcquireSharedNanos(1, unit.toNanos(timeout)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_737915935 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_737915935;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.443 -0400", hash_original_method = "ACB2575EE39865032078A7B67E3D5076", hash_generated_method = "5F72B9A21B37F73F93872F70DF24474A")
    public void countDown() {
        sync.releaseShared(1);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.443 -0400", hash_original_method = "ABE42AE497B23B643FDF7DC2348A1AF5", hash_generated_method = "7FAE55A531EEB4598D53F1116B0F61CE")
    public long getCount() {
        long varEADBA8DEF1BC9738D4EDEC8923318B63_1084453054 = (sync.getCount());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1875767672 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1875767672;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.443 -0400", hash_original_method = "45A2072B871660339FAF307330C7F60C", hash_generated_method = "66B64053AE9E35C3A150DE0F46026031")
    public String toString() {
String var4D62EFEC3E50E2AF5780683B34D1CC77_361297067 =         super.toString() + "[Count = " + sync.getCount() + "]";
        var4D62EFEC3E50E2AF5780683B34D1CC77_361297067.addTaint(taint);
        return var4D62EFEC3E50E2AF5780683B34D1CC77_361297067;
        
        
    }

    
    private static final class Sync extends AbstractQueuedSynchronizer {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.444 -0400", hash_original_method = "9968F5AA54B3A1250121D3E0CFE14724", hash_generated_method = "8A0C888A5DA83A3653D6DAE983FA987D")
          Sync(int count) {
            addTaint(count);
            setState(count);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.444 -0400", hash_original_method = "192D38E698A214D58DA93C3298AD6AD3", hash_generated_method = "98905205192782B267074DC71C81CA92")
         int getCount() {
            int var118C4F58F1303398C344B8AAB7CE6EE1_373586212 = (getState());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_735112698 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_735112698;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.444 -0400", hash_original_method = "5121E365AD686AC5D590ECBA2BCA053C", hash_generated_method = "FBD7E0622E3604B947D862A9DF15A626")
        protected int tryAcquireShared(int acquires) {
            addTaint(acquires);
            int var3EC71F3BC01146A4D6BAB5C90EB4C53B_1054521476 = ((getState() == 0) ? 1 : -1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1130481289 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1130481289;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.444 -0400", hash_original_method = "136302DDF9CF08EA1ED73402F05AC756", hash_generated_method = "8D9608DA02A1AB3FA894C038F1D2E028")
        protected boolean tryReleaseShared(int releases) {
            addTaint(releases);
for(;;)
            {
                int c = getState();
    if(c == 0)                
                {
                boolean var68934A3E9455FA72420237EB05902327_1595101730 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_144675406 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_144675406;
                }
                int nextc = c-1;
    if(compareAndSetState(c, nextc))                
                {
                boolean varFE567596D7CBF2AAC320D09D88315819_175417739 = (nextc == 0);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_692470954 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_692470954;
                }
            } 
            
            
                
                
                    
                
                
                    
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.444 -0400", hash_original_field = "69F97A85B2FBB03A012E5B08317FA038", hash_generated_field = "CC4AEE6AD5E042E09631015E4C8CF188")

        private static final long serialVersionUID = 4982264981922014374L;
    }


    
}

