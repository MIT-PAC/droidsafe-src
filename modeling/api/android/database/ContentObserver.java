package android.database;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Handler;

public abstract class ContentObserver {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.908 -0500", hash_original_field = "55CDE48ED826D490911359FD32438430", hash_generated_field = "02AF804D48FC2EFA36319D85B176604C")

    private Transport mTransport;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.910 -0500", hash_original_field = "DA2A3FDBCC0B9B91674644DF55F373AF", hash_generated_field = "B291AA80E80AF2EADD13F4FAD6374324")

    private Object lock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.912 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "A163099B522120C606A3CA562F90E927")
 Handler mHandler;

    /**
     * onChange() will happen on the provider Handler.
     *
     * @param handler The handler to run {@link #onChange} on.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.940 -0500", hash_original_method = "DEDF781BC2901F5DB53B414F0A999CAB", hash_generated_method = "BD3934C133084C4C709DEBF2A7930A64")
    
public ContentObserver(Handler handler) {
        mHandler = handler;
    }

    /**
     * Gets access to the binder transport object. Not for public consumption.
     *
     * {@hide}
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.942 -0500", hash_original_method = "01F21475A40B0383A9D17C9A77564941", hash_generated_method = "DB4CC7E8014E0DE29303CEFFD312ACB6")
    
public IContentObserver getContentObserver() {
        synchronized(lock) {
            if (mTransport == null) {
                mTransport = new Transport(this);
            }
            return mTransport;
        }
    }

    /**
     * Gets access to the binder transport object, and unlinks the transport object
     * from the ContentObserver. Not for public consumption.
     *
     * {@hide}
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.944 -0500", hash_original_method = "0CB42947C64AC2776A7D9A6FF8C462FE", hash_generated_method = "BAE187CEFEEBAE04D4B82A7608401DFA")
    
public IContentObserver releaseContentObserver() {
        synchronized(lock) {
            Transport oldTransport = mTransport;
            if (oldTransport != null) {
                oldTransport.releaseContentObserver();
                mTransport = null;
            }
            return oldTransport;
        }
    }

    /**
     * Returns true if this observer is interested in notifications for changes
     * made through the cursor the observer is registered with.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.947 -0500", hash_original_method = "A5B2D8696143266ED24B145CF029F206", hash_generated_method = "E7B57C0AFB5FD682336B63E149C8CCF1")
    
public boolean deliverSelfNotifications() {
        return false;
    }

    /**
     * This method is called when a change occurs to the cursor that
     * is being observed.
     *  
     * @param selfChange true if the update was caused by a call to <code>commit</code> on the
     *  cursor that is being observed.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.949 -0500", hash_original_method = "6EAEE94A5AFBBE3CB405FFF6432059B8", hash_generated_method = "95284BF4A594F05C5AB99E7B8C5A943E")
    
public void onChange(boolean selfChange) {}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.952 -0500", hash_original_method = "16E18AEBF4A0FC6BFB0625D1ABE0E3ED", hash_generated_method = "0F2B3BD3A5CF1E7782DDC3CACABEAA60")
    
public final void dispatchChange(boolean selfChange) {
        if (mHandler == null) {
            onChange(selfChange);
        } else {
            mHandler.post(new NotificationRunnable(selfChange));
        }
    }
    
    private final class NotificationRunnable implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.915 -0500", hash_original_field = "6EE53A62AE3754C46DDF47EC57171BFA", hash_generated_field = "7939677200C76A653999F1C89FF176B1")

        private boolean mSelf;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.918 -0500", hash_original_method = "640FAC8E4E08E48125055D1606ED9C9B", hash_generated_method = "1A52B9E9B22862E7553EA139F7E18A51")
        
public NotificationRunnable(boolean self) {
            mSelf = self;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.921 -0500", hash_original_method = "ADCF046F07EA9B09E2364857C3DDF0F7", hash_generated_method = "9D3D13AFC776254022AF1D069D2B61FB")
        
public void run() {
            ContentObserver.this.onChange(mSelf);
        }
        
    }
    
    private static final class Transport extends IContentObserver.Stub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.925 -0500", hash_original_field = "9DAED586938CBB73A279F50F5ECBF202", hash_generated_field = "9DAED586938CBB73A279F50F5ECBF202")

        ContentObserver mContentObserver;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.928 -0500", hash_original_method = "C30CAD402A0C8AFFD18AB2CC7EC4F204", hash_generated_method = "0A4F385959276675A7AB18130002CB57")
        
public Transport(ContentObserver contentObserver) {
            mContentObserver = contentObserver;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.930 -0500", hash_original_method = "158F530B046C6D686908DD95065C53F9", hash_generated_method = "2E01FED80D6B3B31FC63887E63B83C99")
        
public boolean deliverSelfNotifications() {
            ContentObserver contentObserver = mContentObserver;
            if (contentObserver != null) {
                return contentObserver.deliverSelfNotifications();
            }
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.933 -0500", hash_original_method = "71BABE68DF8E341DA3CAF0778B2BD246", hash_generated_method = "0F2161B7D58B8132BE15497A40C77095")
        
public void onChange(boolean selfChange) {
            ContentObserver contentObserver = mContentObserver;
            if (contentObserver != null) {
                contentObserver.dispatchChange(selfChange);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.935 -0500", hash_original_method = "A0916E3A0DA123DBB345BC81644B70F3", hash_generated_method = "F29A6E763CA46DA3DF5D7813C4982BB3")
        
public void releaseContentObserver() {
            mContentObserver = null;
        }
        
    }
    
}

