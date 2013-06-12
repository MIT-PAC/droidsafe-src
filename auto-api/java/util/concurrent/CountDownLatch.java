package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.concurrent.locks.*;
import java.util.concurrent.atomic.*;

public class CountDownLatch {
    private final Sync sync;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.905 -0400", hash_original_method = "4C9DACB295593778FC44AB86E8E7D747", hash_generated_method = "A0988E99749593FBE4B84F46DD080473")
    @DSModeled(DSC.SAFE)
    public CountDownLatch(int count) {
        dsTaint.addTaint(count);
        throw new IllegalArgumentException("count < 0");
        this.sync = new Sync(count);
        // ---------- Original Method ----------
        //if (count < 0) throw new IllegalArgumentException("count < 0");
        //this.sync = new Sync(count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.905 -0400", hash_original_method = "A9727D614A84DE128F63540E6073A44B", hash_generated_method = "BB672DF2666EC31D68A8714CF29A3D3A")
    @DSModeled(DSC.SAFE)
    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(1);
        // ---------- Original Method ----------
        //sync.acquireSharedInterruptibly(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.905 -0400", hash_original_method = "0AAF9EA81FFD8AD9617435605CC7D253", hash_generated_method = "6C648910A90C2D8F50D356F8A94532A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean await(long timeout, TimeUnit unit) throws InterruptedException {
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(timeout);
        boolean varD12778331A5B05E1E52D9468F6FF0E07_405713248 = (sync.tryAcquireSharedNanos(1, unit.toNanos(timeout)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.tryAcquireSharedNanos(1, unit.toNanos(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.905 -0400", hash_original_method = "ACB2575EE39865032078A7B67E3D5076", hash_generated_method = "BFEFE8F2767285CB1282C3E20CCEFED0")
    @DSModeled(DSC.SAFE)
    public void countDown() {
        sync.releaseShared(1);
        // ---------- Original Method ----------
        //sync.releaseShared(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.905 -0400", hash_original_method = "ABE42AE497B23B643FDF7DC2348A1AF5", hash_generated_method = "69C067A970553EE505C9F87B47702E2F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getCount() {
        long var3E7EE26A585DAEF98B448A2C779F0B42_1500513950 = (sync.getCount());
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return sync.getCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.905 -0400", hash_original_method = "45A2072B871660339FAF307330C7F60C", hash_generated_method = "78C9A870DA282602B7C9BA9DB384B5ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String varF3A6492FA02F49A55FFF7D4252F7B700_1893498339 = (super.toString() + "[Count = " + sync.getCount() + "]");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return super.toString() + "[Count = " + sync.getCount() + "]";
    }

    
    private static final class Sync extends AbstractQueuedSynchronizer {
        private static final long serialVersionUID = 4982264981922014374L;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.905 -0400", hash_original_method = "9968F5AA54B3A1250121D3E0CFE14724", hash_generated_method = "4CD3344FB7848AF227F71F059DB4AE56")
        @DSModeled(DSC.SAFE)
         Sync(int count) {
            dsTaint.addTaint(count);
            setState(count);
            // ---------- Original Method ----------
            //setState(count);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.905 -0400", hash_original_method = "192D38E698A214D58DA93C3298AD6AD3", hash_generated_method = "DEB4572F7C173B66CDA3AB31D2C6D349")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         int getCount() {
            int var376B5C2087169E76FB6628D31DCC9663_1681530467 = (getState());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return getState();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.905 -0400", hash_original_method = "5121E365AD686AC5D590ECBA2BCA053C", hash_generated_method = "70B232C78D207094AF3A4DEB62EC345C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected int tryAcquireShared(int acquires) {
            dsTaint.addTaint(acquires);
            {
                boolean varB9A8967EEEE626B2D88454F1CD4A1CB3_238678322 = ((getState() == 0));
            } //End flattened ternary
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return (getState() == 0) ? 1 : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.905 -0400", hash_original_method = "136302DDF9CF08EA1ED73402F05AC756", hash_generated_method = "EAC862D5F2673BD97DB93CD38D723DE8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected boolean tryReleaseShared(int releases) {
            dsTaint.addTaint(releases);
            {
                int c;
                c = getState();
                int nextc;
                nextc = c-1;
                {
                    boolean var525F59EF5A984E7DE1A679CCEEFC8101_212347482 = (compareAndSetState(c, nextc));
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

        
    }


    
}


