package java.lang.ref;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public abstract class Reference<T> {
    volatile T referent;
    @SuppressWarnings("unchecked")
    volatile ReferenceQueue queue;
    @SuppressWarnings("unchecked")
    volatile Reference queueNext;
    public volatile Reference<?> pendingNext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.878 -0400", hash_original_method = "6CD3D0843AA30F3B07C5B27C93AA8456", hash_generated_method = "D5010EC840BE1BA76E795E1CD20A9735")
    @DSModeled(DSC.SAFE)
     Reference() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.878 -0400", hash_original_method = "12DB2A62AB24EF0D8394447093A7278F", hash_generated_method = "36B6BD90540644DFBE6209FA453B059F")
    @DSModeled(DSC.SAFE)
     Reference(T r, ReferenceQueue q) {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(q.dsTaint);
        // ---------- Original Method ----------
        //referent = r;
        //queue = q;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.878 -0400", hash_original_method = "0AFD16A0602732B7092274BEFFE68A69", hash_generated_method = "6D87151304C4A581CE75178412E75905")
    @DSModeled(DSC.SAFE)
    public void clear() {
        referent = null;
        // ---------- Original Method ----------
        //referent = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.878 -0400", hash_original_method = "26440EC338F5668042D20BF591B8B96C", hash_generated_method = "B28F89ABF9714E464CE39686B7CBEB53")
    @DSModeled(DSC.SAFE)
    public final synchronized boolean enqueueInternal() {
        {
            queue.enqueue(this);
            queue = null;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (queue != null && queueNext == null) {
            //queue.enqueue(this);
            //queue = null;
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.878 -0400", hash_original_method = "D897CF322202613DC6CC465308B391E4", hash_generated_method = "3D9BB639CC13053E449ADF1DED4308EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean enqueue() {
        boolean var1A956F7B1D16A58A3C34850CA5FE4029_1466807794 = (enqueueInternal());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return enqueueInternal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.878 -0400", hash_original_method = "3B05713F718010AF3C5E0D5C54D10077", hash_generated_method = "0687BA55CA234CF8B0033189F3748C3F")
    @DSModeled(DSC.SAFE)
    public T get() {
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return referent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.878 -0400", hash_original_method = "22F3CCC310074C277F932626BFB7DCB6", hash_generated_method = "CFDA7B7188263ADB13B603849BBAF2B8")
    @DSModeled(DSC.SAFE)
    public boolean isEnqueued() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return queueNext != null;
    }

    
}


