package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Handler;

public abstract class ContentObserver {
    private Transport mTransport;
    private Object lock = new Object();
    Handler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.577 -0400", hash_original_method = "DEDF781BC2901F5DB53B414F0A999CAB", hash_generated_method = "9C8E9DBEBB828432C7E37613A6ED7C96")
    @DSModeled(DSC.SAFE)
    public ContentObserver(Handler handler) {
        dsTaint.addTaint(handler.dsTaint);
        // ---------- Original Method ----------
        //mHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.577 -0400", hash_original_method = "01F21475A40B0383A9D17C9A77564941", hash_generated_method = "5EFBC9F58D153268297B6A5A6D02E4E3")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.578 -0400", hash_original_method = "0CB42947C64AC2776A7D9A6FF8C462FE", hash_generated_method = "E0F9B8044CB5DF56384283561013F174")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.578 -0400", hash_original_method = "A5B2D8696143266ED24B145CF029F206", hash_generated_method = "F86E9AAB7254FEE757F85E267034A8F7")
    @DSModeled(DSC.SAFE)
    public boolean deliverSelfNotifications() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.578 -0400", hash_original_method = "6EAEE94A5AFBBE3CB405FFF6432059B8", hash_generated_method = "2C61F5A3907FBCA57D153BCE7B315BF0")
    @DSModeled(DSC.SAFE)
    public void onChange(boolean selfChange) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(selfChange);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.578 -0400", hash_original_method = "16E18AEBF4A0FC6BFB0625D1ABE0E3ED", hash_generated_method = "A62E3F4738A69564B6D47FE67020E0A6")
    @DSModeled(DSC.SAFE)
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.578 -0400", hash_original_method = "640FAC8E4E08E48125055D1606ED9C9B", hash_generated_method = "8DDF703732D08FD35EB47B8021FB2F7E")
        @DSModeled(DSC.SAFE)
        public NotificationRunnable(boolean self) {
            dsTaint.addTaint(self);
            // ---------- Original Method ----------
            //mSelf = self;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.579 -0400", hash_original_method = "ADCF046F07EA9B09E2364857C3DDF0F7", hash_generated_method = "0104F5330FEE814693B33DC8029E52B8")
        @DSModeled(DSC.SAFE)
        public void run() {
            ContentObserver.this.onChange(mSelf);
            // ---------- Original Method ----------
            //ContentObserver.this.onChange(mSelf);
        }

        
    }


    
    private static final class Transport extends IContentObserver.Stub {
        ContentObserver mContentObserver;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.579 -0400", hash_original_method = "C30CAD402A0C8AFFD18AB2CC7EC4F204", hash_generated_method = "A0C18894BEB154B8A20375D8020AC5C8")
        @DSModeled(DSC.SAFE)
        public Transport(ContentObserver contentObserver) {
            dsTaint.addTaint(contentObserver.dsTaint);
            // ---------- Original Method ----------
            //mContentObserver = contentObserver;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.579 -0400", hash_original_method = "158F530B046C6D686908DD95065C53F9", hash_generated_method = "0A35A9992AC73ABCC1D2308D7658203E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean deliverSelfNotifications() {
            ContentObserver contentObserver;
            contentObserver = mContentObserver;
            {
                boolean var48E239F26E510CFEEA586BDE1698ED7B_1645866508 = (contentObserver.deliverSelfNotifications());
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //ContentObserver contentObserver = mContentObserver;
            //if (contentObserver != null) {
                //return contentObserver.deliverSelfNotifications();
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.579 -0400", hash_original_method = "71BABE68DF8E341DA3CAF0778B2BD246", hash_generated_method = "EA0D2B23B89602F664AC3E403B76DD14")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.579 -0400", hash_original_method = "A0916E3A0DA123DBB345BC81644B70F3", hash_generated_method = "B793C9ABD8B7AEFE3590AF6A6B3C0077")
        @DSModeled(DSC.SAFE)
        public void releaseContentObserver() {
            mContentObserver = null;
            // ---------- Original Method ----------
            //mContentObserver = null;
        }

        
    }


    
}


