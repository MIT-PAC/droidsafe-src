package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Handler;

public abstract class ContentObserver {
    private Transport mTransport;
    private Object lock = new Object();
    Handler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.972 -0400", hash_original_method = "DEDF781BC2901F5DB53B414F0A999CAB", hash_generated_method = "D32203DFE904DA590B30EBF90A4531D8")
    @DSModeled(DSC.SAFE)
    public ContentObserver(Handler handler) {
        dsTaint.addTaint(handler.dsTaint);
        // ---------- Original Method ----------
        //mHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.973 -0400", hash_original_method = "01F21475A40B0383A9D17C9A77564941", hash_generated_method = "C0E96ABEEF31A61DE4B45365752FFC07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IContentObserver getContentObserver() {
        {
            {
                mTransport = new Transport(this);
            } //End block
        } //End block
        return (IContentObserver)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized(lock) {
            //if (mTransport == null) {
                //mTransport = new Transport(this);
            //}
            //return mTransport;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.973 -0400", hash_original_method = "0CB42947C64AC2776A7D9A6FF8C462FE", hash_generated_method = "CC50EE39931321FA2C8237598822D18A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IContentObserver releaseContentObserver() {
        {
            Transport oldTransport;
            oldTransport = mTransport;
            {
                oldTransport.releaseContentObserver();
                mTransport = null;
            } //End block
        } //End block
        return (IContentObserver)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized(lock) {
            //Transport oldTransport = mTransport;
            //if (oldTransport != null) {
                //oldTransport.releaseContentObserver();
                //mTransport = null;
            //}
            //return oldTransport;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.973 -0400", hash_original_method = "A5B2D8696143266ED24B145CF029F206", hash_generated_method = "BF34175F0D5DDDA4A66822A3C03FFBB9")
    @DSModeled(DSC.SAFE)
    public boolean deliverSelfNotifications() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.974 -0400", hash_original_method = "6EAEE94A5AFBBE3CB405FFF6432059B8", hash_generated_method = "6631C4CD0261FD94949D94429C47FDC6")
    @DSModeled(DSC.SAFE)
    public void onChange(boolean selfChange) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(selfChange);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.974 -0400", hash_original_method = "16E18AEBF4A0FC6BFB0625D1ABE0E3ED", hash_generated_method = "ACF64F7886E8F7291B933B534FE619FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void dispatchChange(boolean selfChange) {
        dsTaint.addTaint(selfChange);
        {
            onChange(selfChange);
        } //End block
        {
            mHandler.post(new NotificationRunnable(selfChange));
        } //End block
        // ---------- Original Method ----------
        //if (mHandler == null) {
            //onChange(selfChange);
        //} else {
            //mHandler.post(new NotificationRunnable(selfChange));
        //}
    }

    
    private final class NotificationRunnable implements Runnable {
        private boolean mSelf;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.974 -0400", hash_original_method = "640FAC8E4E08E48125055D1606ED9C9B", hash_generated_method = "DE355743D5E4F526CB8065BBF85E3E77")
        @DSModeled(DSC.SAFE)
        public NotificationRunnable(boolean self) {
            dsTaint.addTaint(self);
            // ---------- Original Method ----------
            //mSelf = self;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.974 -0400", hash_original_method = "ADCF046F07EA9B09E2364857C3DDF0F7", hash_generated_method = "30ECC851BB12D6B371695B1BC5CB6757")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            ContentObserver.this.onChange(mSelf);
            // ---------- Original Method ----------
            //ContentObserver.this.onChange(mSelf);
        }

        
    }


    
    private static final class Transport extends IContentObserver.Stub {
        ContentObserver mContentObserver;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.975 -0400", hash_original_method = "C30CAD402A0C8AFFD18AB2CC7EC4F204", hash_generated_method = "05BC08A5482186950400CC2B58B8BD42")
        @DSModeled(DSC.SAFE)
        public Transport(ContentObserver contentObserver) {
            dsTaint.addTaint(contentObserver.dsTaint);
            // ---------- Original Method ----------
            //mContentObserver = contentObserver;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.975 -0400", hash_original_method = "158F530B046C6D686908DD95065C53F9", hash_generated_method = "CC56DAA860DB3DA1577768BE1B7428FD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean deliverSelfNotifications() {
            ContentObserver contentObserver;
            contentObserver = mContentObserver;
            {
                boolean var48E239F26E510CFEEA586BDE1698ED7B_434395319 = (contentObserver.deliverSelfNotifications());
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //ContentObserver contentObserver = mContentObserver;
            //if (contentObserver != null) {
                //return contentObserver.deliverSelfNotifications();
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.975 -0400", hash_original_method = "71BABE68DF8E341DA3CAF0778B2BD246", hash_generated_method = "0B06EBEDEE130AD42B6AC26D1A89B2EC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(selfChange);
            ContentObserver contentObserver;
            contentObserver = mContentObserver;
            {
                contentObserver.dispatchChange(selfChange);
            } //End block
            // ---------- Original Method ----------
            //ContentObserver contentObserver = mContentObserver;
            //if (contentObserver != null) {
                //contentObserver.dispatchChange(selfChange);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.975 -0400", hash_original_method = "A0916E3A0DA123DBB345BC81644B70F3", hash_generated_method = "ADD05F525B1B13738DD98FA14B241126")
        @DSModeled(DSC.SAFE)
        public void releaseContentObserver() {
            mContentObserver = null;
            // ---------- Original Method ----------
            //mContentObserver = null;
        }

        
    }


    
}

