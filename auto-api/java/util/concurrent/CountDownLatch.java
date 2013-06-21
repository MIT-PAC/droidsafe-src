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
    private Sync sync;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.517 -0400", hash_original_method = "4C9DACB295593778FC44AB86E8E7D747", hash_generated_method = "42C8215E30603FD0750300528993B201")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CountDownLatch(int count) {
        dsTaint.addTaint(count);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("count < 0");
        this.sync = new Sync(count);
        // ---------- Original Method ----------
        //if (count < 0) throw new IllegalArgumentException("count < 0");
        //this.sync = new Sync(count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.517 -0400", hash_original_method = "A9727D614A84DE128F63540E6073A44B", hash_generated_method = "D070BA44558B523604A261CE2882A091")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(1);
        // ---------- Original Method ----------
        //sync.acquireSharedInterruptibly(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.517 -0400", hash_original_method = "0AAF9EA81FFD8AD9617435605CC7D253", hash_generated_method = "44C5FF7BBCBB7BFFF4BD84DF7D53C3C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean await(long timeout, TimeUnit unit) throws InterruptedException {
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(timeout);
        boolean varD12778331A5B05E1E52D9468F6FF0E07_1326315243 = (sync.tryAcquireSharedNanos(1, unit.toNanos(timeout)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.tryAcquireSharedNanos(1, unit.toNanos(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.517 -0400", hash_original_method = "ACB2575EE39865032078A7B67E3D5076", hash_generated_method = "5F72B9A21B37F73F93872F70DF24474A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void countDown() {
        sync.releaseShared(1);
        // ---------- Original Method ----------
        //sync.releaseShared(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.517 -0400", hash_original_method = "ABE42AE497B23B643FDF7DC2348A1AF5", hash_generated_method = "C256227666B7FB0DC3483ACC60C834BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getCount() {
        long var3E7EE26A585DAEF98B448A2C779F0B42_1862517938 = (sync.getCount());
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return sync.getCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.518 -0400", hash_original_method = "45A2072B871660339FAF307330C7F60C", hash_generated_method = "E4450992FE67F2F019D21F328F15B082")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String varF3A6492FA02F49A55FFF7D4252F7B700_2060845952 = (super.toString() + "[Count = " + sync.getCount() + "]");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return super.toString() + "[Count = " + sync.getCount() + "]";
    }

    
    private static final class Sync extends AbstractQueuedSynchronizer {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.518 -0400", hash_original_method = "9968F5AA54B3A1250121D3E0CFE14724", hash_generated_method = "824B10E0914824334CCA47C2D0235C67")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Sync(int count) {
            dsTaint.addTaint(count);
            setState(count);
            // ---------- Original Method ----------
            //setState(count);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.518 -0400", hash_original_method = "192D38E698A214D58DA93C3298AD6AD3", hash_generated_method = "6BB1ADBE294D3EB689EDD7F024F61AB6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         int getCount() {
            int var376B5C2087169E76FB6628D31DCC9663_226377016 = (getState());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return getState();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.518 -0400", hash_original_method = "5121E365AD686AC5D590ECBA2BCA053C", hash_generated_method = "64C62059E760DCCE8C8A32B565E89BE4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected int tryAcquireShared(int acquires) {
            dsTaint.addTaint(acquires);
            {
                boolean varB9A8967EEEE626B2D88454F1CD4A1CB3_954928303 = ((getState() == 0));
            } //End flattened ternary
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return (getState() == 0) ? 1 : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.518 -0400", hash_original_method = "136302DDF9CF08EA1ED73402F05AC756", hash_generated_method = "56F7E78B3175E46CCBBF7B0C02D6E660")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected boolean tryReleaseShared(int releases) {
            dsTaint.addTaint(releases);
            {
                int c;
                c = getState();
                int nextc;
                nextc = c-1;
                {
                    boolean var525F59EF5A984E7DE1A679CCEEFC8101_698435659 = (compareAndSetState(c, nextc));
                } //End collapsed parenthetic
            } //End block
            return dsTaint.getTaintBoolean();
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

        
        private static final long serialVersionUID = 4982264981922014374L;
    }


    
}

