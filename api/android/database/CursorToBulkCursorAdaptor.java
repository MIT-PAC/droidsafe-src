package android.database;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

public final class CursorToBulkCursorAdaptor extends BulkCursorNative implements IBinder.DeathRecipient {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.681 -0500", hash_original_field = "185286679E98DDBA5FF230438EB0F181", hash_generated_field = "C0008393E22A94FFD078F5CB06D7EC35")

    private static final String TAG = "Cursor";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.684 -0500", hash_original_field = "83DB9DCBBD2D99A708D9A1934D5CD5AB", hash_generated_field = "E59081251AD157907AA4CE8B3D8E654E")

    private final Object mLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.687 -0500", hash_original_field = "719FE8D1D312E4983A0DDBA58E58CDCF", hash_generated_field = "A729030D5DBB0175A438B51B5B1D1491")

    private  String mProviderName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.689 -0500", hash_original_field = "9BD5BDB8EB4E9A8880FBF3440BDF4091", hash_generated_field = "C0BC6E9ED279A4CF6D17FF3227AF4CAD")

    private ContentObserverProxy mObserver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.692 -0500", hash_original_field = "4DB3610781C451E2FCCEA599B25EDC40", hash_generated_field = "33920F0BCDF13F29B9CC06EF8E2B2F17")

    private CrossProcessCursor mCursor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.694 -0500", hash_original_field = "55104685FC995780BF467509CF711FAA", hash_generated_field = "E8734D79A4BD19C7AB5E7CF160F0A9A7")

    private CursorWindow mFilledWindow;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.712 -0500", hash_original_method = "DFFFDCE95BD5626A15621DE9255909D3", hash_generated_method = "3AF43678BBDFC388A9B19FB0A40965F7")
    
public CursorToBulkCursorAdaptor(Cursor cursor, IContentObserver observer,
            String providerName) {
        if (cursor instanceof CrossProcessCursor) {
            mCursor = (CrossProcessCursor)cursor;
        } else {
            mCursor = new CrossProcessCursorWrapper(cursor);
        }
        mProviderName = providerName;

        synchronized (mLock) {
            createAndRegisterObserverProxyLocked(observer);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.715 -0500", hash_original_method = "AD579F119ED4886B2C182C86869C4CD9", hash_generated_method = "59F7A2C56124BED74D0F696A6E6C0859")
    
private void closeFilledWindowLocked() {
        if (mFilledWindow != null) {
            mFilledWindow.close();
            mFilledWindow = null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.717 -0500", hash_original_method = "E626ABF61F7540C19BF105C7958133EC", hash_generated_method = "D3EA8E7F95CEA3C22B60A9CB1E00BE92")
    
private void disposeLocked() {
        if (mCursor != null) {
            unregisterObserverProxyLocked();
            mCursor.close();
            mCursor = null;
        }

        closeFilledWindowLocked();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.720 -0500", hash_original_method = "18B24C6ABC409A0E548E21131FCA3F48", hash_generated_method = "375630E60FD0CCA4F8B04B778992B083")
    
private void throwIfCursorIsClosed() {
        if (mCursor == null) {
            throw new StaleDataException("Attempted to access a cursor after it has been closed.");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.722 -0500", hash_original_method = "C4AF1DDC0409484A2B59D555E10A97E5", hash_generated_method = "A237896F566D10C0DE718CA599FB8AF9")
    
@Override
    public void binderDied() {
        synchronized (mLock) {
            disposeLocked();
        }
    }

    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.725 -0500", hash_original_method = "4ECB0E8EDFF03AFDCED1B443F780B12E", hash_generated_method = "9A15BCAC89E334437CA3D66B23D658B9")
    
@Override
    public CursorWindow getWindow(int startPos) {
        synchronized (mLock) {
            throwIfCursorIsClosed();

            if (!mCursor.moveToPosition(startPos)) {
                closeFilledWindowLocked();
                return null;
            }

            CursorWindow window = mCursor.getWindow();
            if (window != null) {
                closeFilledWindowLocked();
            } else {
                window = mFilledWindow;
                if (window == null) {
                    mFilledWindow = new CursorWindow(mProviderName);
                    window = mFilledWindow;
                    mCursor.fillWindow(startPos, window);
                } else if (startPos < window.getStartPosition()
                        || startPos >= window.getStartPosition() + window.getNumRows()) {
                    window.clear();
                    mCursor.fillWindow(startPos, window);
                }
            }

            // Acquire a reference before returning from this RPC.
            // The Binder proxy will decrement the reference count again as part of writing
            // the CursorWindow to the reply parcel as a return value.
            if (window != null) {
                window.acquireReference();
            }
            return window;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.727 -0500", hash_original_method = "4E23514B564E80A833367A4C9E43D15C", hash_generated_method = "47FD26EA2354EAEE50D28A7CE898554C")
    
@Override
    public void onMove(int position) {
        synchronized (mLock) {
            throwIfCursorIsClosed();

            mCursor.onMove(mCursor.getPosition(), position);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.730 -0500", hash_original_method = "DC4D033FD1BAE66931C8A4D6EEEA211D", hash_generated_method = "04296353E79FE5DEB3E8355098C6F908")
    
@Override
    public int count() {
        synchronized (mLock) {
            throwIfCursorIsClosed();

            return mCursor.getCount();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.732 -0500", hash_original_method = "51920E427207C9DB40FE51CEF3CF1E5F", hash_generated_method = "B0F1C7E5461F6B0DAEDE32A261D82D3C")
    
@Override
    public String[] getColumnNames() {
        synchronized (mLock) {
            throwIfCursorIsClosed();

            return mCursor.getColumnNames();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.735 -0500", hash_original_method = "E8CA6D89EFD51007B93658764C0D15A1", hash_generated_method = "65D43E6888271529B2F62B6843C6393D")
    
@Override
    public void deactivate() {
        synchronized (mLock) {
            if (mCursor != null) {
                unregisterObserverProxyLocked();
                mCursor.deactivate();
            }

            closeFilledWindowLocked();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.737 -0500", hash_original_method = "AC20EBAE7250AB68ABF5848E6A31630D", hash_generated_method = "014489E94632B4419BB93346225465C8")
    
@Override
    public void close() {
        synchronized (mLock) {
            disposeLocked();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.740 -0500", hash_original_method = "C42BE5036A3BA050EE736974AEACDE99", hash_generated_method = "2B0AC954301C70C37DED64D4E8209789")
    
@Override
    public int requery(IContentObserver observer) {
        synchronized (mLock) {
            throwIfCursorIsClosed();

            closeFilledWindowLocked();

            try {
                if (!mCursor.requery()) {
                    return -1;
                }
            } catch (IllegalStateException e) {
                IllegalStateException leakProgram = new IllegalStateException(
                        mProviderName + " Requery misuse db, mCursor isClosed:" +
                        mCursor.isClosed(), e);
                throw leakProgram;
            }

            unregisterObserverProxyLocked();
            createAndRegisterObserverProxyLocked(observer);
            return mCursor.getCount();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.742 -0500", hash_original_method = "4EDF40CD28E1B076C101ED75649491F5", hash_generated_method = "70EE682EDFE5CCBD15F893B07C3C7FFC")
    
@Override
    public boolean getWantsAllOnMoveCalls() {
        synchronized (mLock) {
            throwIfCursorIsClosed();

            return mCursor.getWantsAllOnMoveCalls();
        }
    }

    /**
     * Create a ContentObserver from the observer and register it as an observer on the
     * underlying cursor.
     * @param observer the IContentObserver that wants to monitor the cursor
     * @throws IllegalStateException if an observer is already registered
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.744 -0500", hash_original_method = "1F751777DEFC6D435260F5703D7849F2", hash_generated_method = "7EE27EF1F20A6275792A7B5250FC7943")
    
private void createAndRegisterObserverProxyLocked(IContentObserver observer) {
        if (mObserver != null) {
            throw new IllegalStateException("an observer is already registered");
        }
        mObserver = new ContentObserverProxy(observer, this);
        mCursor.registerContentObserver(mObserver);
    }

    /** Unregister the observer if it is already registered. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.747 -0500", hash_original_method = "8431B5C8F0968484F229748CA95CA0A8", hash_generated_method = "4692BDE8D809837F0CF470CA97A7DFBA")
    
private void unregisterObserverProxyLocked() {
        if (mObserver != null) {
            mCursor.unregisterContentObserver(mObserver);
            mObserver.unlinkToDeath(this);
            mObserver = null;
        }
    }

    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.749 -0500", hash_original_method = "D70B44F91871C59AEA1A14E0E16BCFE5", hash_generated_method = "162DE252350A112A17DD6E06E3D1CEF0")
    
@Override
    public Bundle getExtras() {
        synchronized (mLock) {
            throwIfCursorIsClosed();

            return mCursor.getExtras();
        }
    }
    
    private static final class ContentObserverProxy extends ContentObserver {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.697 -0500", hash_original_field = "B953E44F04521B54F9B83F1940415B2A", hash_generated_field = "74D5AC8BC3A14B4C09214B5B5668899E")

        protected IContentObserver mRemote;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.699 -0500", hash_original_method = "319996A1B242CEE2610029D3C2CFA436", hash_generated_method = "BB1ABC44E09827564626D4825EACBDFA")
        
public ContentObserverProxy(IContentObserver remoteObserver, DeathRecipient recipient) {
            super(null);
            mRemote = remoteObserver;
            try {
                remoteObserver.asBinder().linkToDeath(recipient, 0);
            } catch (RemoteException e) {
                // Do nothing, the far side is dead
            }
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.702 -0500", hash_original_method = "96222C4BC704270291C489EC7FF2AF65", hash_generated_method = "3A3EACF753FF1DAE4091946280ED65B9")
        
public boolean unlinkToDeath(DeathRecipient recipient) {
            return mRemote.asBinder().unlinkToDeath(recipient, 0);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.704 -0500", hash_original_method = "A5B2D8696143266ED24B145CF029F206", hash_generated_method = "E1AD8D4488037326DDBD7DE3BF15E259")
        
@Override
        public boolean deliverSelfNotifications() {
            // The far side handles the self notifications.
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.707 -0500", hash_original_method = "288C053C9E4DFF84CBC0887DEC7513A2", hash_generated_method = "9D5E90478EA4D14DB3253559D6A175EF")
        
@Override
        public void onChange(boolean selfChange) {
            try {
                mRemote.onChange(selfChange);
            } catch (RemoteException ex) {
                // Do nothing, the far side is dead
            }
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.752 -0500", hash_original_method = "7B57D96B3C93268C95F4ADF84D5A7417", hash_generated_method = "E0D304CC5AFFC0A9A0F8DAC1FAF927C1")
    
@Override
    public Bundle respond(Bundle extras) {
        synchronized (mLock) {
            throwIfCursorIsClosed();

            return mCursor.respond(extras);
        }
    }
}

