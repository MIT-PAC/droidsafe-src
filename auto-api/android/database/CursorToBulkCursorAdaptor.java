package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public final class CursorToBulkCursorAdaptor extends BulkCursorNative implements IBinder.DeathRecipient {
    private static final String TAG = "Cursor";
    private /* final */ Object mLock = new Object();
    private /* final */ String mProviderName;
    private ContentObserverProxy mObserver;
    private CrossProcessCursor mCursor;
    private CursorWindow mFilledWindow;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.589 -0400", hash_original_method = "DFFFDCE95BD5626A15621DE9255909D3", hash_generated_method = "5A5B40432C38786E7D2D5D9BAB3C1627")
    @DSModeled(DSC.SAFE)
    public CursorToBulkCursorAdaptor(Cursor cursor, IContentObserver observer,
            String providerName) {
        dsTaint.addTaint(cursor.dsTaint);
        dsTaint.addTaint(providerName);
        dsTaint.addTaint(observer.dsTaint);
        {
            mCursor = (CrossProcessCursor)cursor;
        } //End block
        {
            mCursor = new CrossProcessCursorWrapper(cursor);
        } //End block
        {
            createAndRegisterObserverProxyLocked(observer);
        } //End block
        // ---------- Original Method ----------
        //if (cursor instanceof CrossProcessCursor) {
            //mCursor = (CrossProcessCursor)cursor;
        //} else {
            //mCursor = new CrossProcessCursorWrapper(cursor);
        //}
        //mProviderName = providerName;
        //synchronized (mLock) {
            //createAndRegisterObserverProxyLocked(observer);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.589 -0400", hash_original_method = "AD579F119ED4886B2C182C86869C4CD9", hash_generated_method = "C8EF84E3117D208FAF7CFF1A7441A7C4")
    @DSModeled(DSC.SAFE)
    private void closeFilledWindowLocked() {
        {
            mFilledWindow.close();
            mFilledWindow = null;
        } //End block
        // ---------- Original Method ----------
        //if (mFilledWindow != null) {
            //mFilledWindow.close();
            //mFilledWindow = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.590 -0400", hash_original_method = "E626ABF61F7540C19BF105C7958133EC", hash_generated_method = "F8E2433AD3CDBCD056A25C8D76289129")
    @DSModeled(DSC.SAFE)
    private void disposeLocked() {
        {
            unregisterObserverProxyLocked();
            mCursor.close();
            mCursor = null;
        } //End block
        closeFilledWindowLocked();
        // ---------- Original Method ----------
        //if (mCursor != null) {
            //unregisterObserverProxyLocked();
            //mCursor.close();
            //mCursor = null;
        //}
        //closeFilledWindowLocked();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.590 -0400", hash_original_method = "18B24C6ABC409A0E548E21131FCA3F48", hash_generated_method = "4C9F595EB91BDBD0631296FB7543B275")
    @DSModeled(DSC.SAFE)
    private void throwIfCursorIsClosed() {
        {
            throw new StaleDataException("Attempted to access a cursor after it has been closed.");
        } //End block
        // ---------- Original Method ----------
        //if (mCursor == null) {
            //throw new StaleDataException("Attempted to access a cursor after it has been closed.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.590 -0400", hash_original_method = "C4AF1DDC0409484A2B59D555E10A97E5", hash_generated_method = "B6A05E3301186D9B71AC93C3AC582556")
    @DSModeled(DSC.SAFE)
    @Override
    public void binderDied() {
        {
            disposeLocked();
        } //End block
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //disposeLocked();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.590 -0400", hash_original_method = "4ECB0E8EDFF03AFDCED1B443F780B12E", hash_generated_method = "85E7DCBCADC4298D753FBCDA82A80EE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CursorWindow getWindow(int startPos) {
        dsTaint.addTaint(startPos);
        {
            throwIfCursorIsClosed();
            {
                boolean var04D558ECAB1E17991563926E69879491_517211760 = (!mCursor.moveToPosition(startPos));
                {
                    closeFilledWindowLocked();
                } //End block
            } //End collapsed parenthetic
            CursorWindow window;
            window = mCursor.getWindow();
            {
                closeFilledWindowLocked();
            } //End block
            {
                window = mFilledWindow;
                {
                    mFilledWindow = new CursorWindow(mProviderName);
                    window = mFilledWindow;
                    mCursor.fillWindow(startPos, window);
                } //End block
                {
                    boolean varC97F342FBEDA56BA63E8F208810D5BA4_47882419 = (startPos < window.getStartPosition()
                        || startPos >= window.getStartPosition() + window.getNumRows());
                    {
                        window.clear();
                        mCursor.fillWindow(startPos, window);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                window.acquireReference();
            } //End block
        } //End block
        return (CursorWindow)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.591 -0400", hash_original_method = "4E23514B564E80A833367A4C9E43D15C", hash_generated_method = "41B190427C30D120FF4C1C455E6AB4AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onMove(int position) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(position);
        {
            throwIfCursorIsClosed();
            mCursor.onMove(mCursor.getPosition(), position);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //throwIfCursorIsClosed();
            //mCursor.onMove(mCursor.getPosition(), position);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.591 -0400", hash_original_method = "DC4D033FD1BAE66931C8A4D6EEEA211D", hash_generated_method = "06C4269F07E8863A969E8C7AAE402714")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int count() {
        {
            throwIfCursorIsClosed();
            int varA0B4CA491E47E321D82FB34DD7E77E5A_1577330787 = (mCursor.getCount());
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //throwIfCursorIsClosed();
            //return mCursor.getCount();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.591 -0400", hash_original_method = "51920E427207C9DB40FE51CEF3CF1E5F", hash_generated_method = "580C1A0FA10060269658F6A1F1D40D0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getColumnNames() {
        {
            throwIfCursorIsClosed();
            String[] varC7830ACD2DB98FB85D5A2F4CC0B549B0_1093138181 = (mCursor.getColumnNames());
        } //End block
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //throwIfCursorIsClosed();
            //return mCursor.getColumnNames();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.591 -0400", hash_original_method = "E8CA6D89EFD51007B93658764C0D15A1", hash_generated_method = "71BC80BA06745462F3013139FB3FE960")
    @DSModeled(DSC.SAFE)
    @Override
    public void deactivate() {
        {
            {
                unregisterObserverProxyLocked();
                mCursor.deactivate();
            } //End block
            closeFilledWindowLocked();
        } //End block
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //if (mCursor != null) {
                //unregisterObserverProxyLocked();
                //mCursor.deactivate();
            //}
            //closeFilledWindowLocked();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.591 -0400", hash_original_method = "AC20EBAE7250AB68ABF5848E6A31630D", hash_generated_method = "E603BA2BA469E1013430925F31251133")
    @DSModeled(DSC.SAFE)
    @Override
    public void close() {
        {
            disposeLocked();
        } //End block
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //disposeLocked();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.592 -0400", hash_original_method = "C42BE5036A3BA050EE736974AEACDE99", hash_generated_method = "0F65859A1D1F3124602C914F50BF9A19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int requery(IContentObserver observer) {
        dsTaint.addTaint(observer.dsTaint);
        {
            throwIfCursorIsClosed();
            closeFilledWindowLocked();
            try 
            {
                {
                    boolean var9F860FB704DE0324D019EBF4330135F9_1151212798 = (!mCursor.requery());
                } //End collapsed parenthetic
            } //End block
            catch (IllegalStateException e)
            {
                IllegalStateException leakProgram;
                leakProgram = new IllegalStateException(
                        mProviderName + " Requery misuse db, mCursor isClosed:" +
                        mCursor.isClosed(), e);
                throw leakProgram;
            } //End block
            unregisterObserverProxyLocked();
            createAndRegisterObserverProxyLocked(observer);
            int varA0B4CA491E47E321D82FB34DD7E77E5A_1944407150 = (mCursor.getCount());
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //throwIfCursorIsClosed();
            //closeFilledWindowLocked();
            //try {
                //if (!mCursor.requery()) {
                    //return -1;
                //}
            //} catch (IllegalStateException e) {
                //IllegalStateException leakProgram = new IllegalStateException(
                        //mProviderName + " Requery misuse db, mCursor isClosed:" +
                        //mCursor.isClosed(), e);
                //throw leakProgram;
            //}
            //unregisterObserverProxyLocked();
            //createAndRegisterObserverProxyLocked(observer);
            //return mCursor.getCount();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.592 -0400", hash_original_method = "4EDF40CD28E1B076C101ED75649491F5", hash_generated_method = "CD3375FCFB316064C7A176D4BEF5F693")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getWantsAllOnMoveCalls() {
        {
            throwIfCursorIsClosed();
            boolean varA4ACC3F53F22F27EF64482D87EFB3327_2033699668 = (mCursor.getWantsAllOnMoveCalls());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //throwIfCursorIsClosed();
            //return mCursor.getWantsAllOnMoveCalls();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.592 -0400", hash_original_method = "1F751777DEFC6D435260F5703D7849F2", hash_generated_method = "836DE81395A0E3886A1269C6A5F00114")
    @DSModeled(DSC.SAFE)
    private void createAndRegisterObserverProxyLocked(IContentObserver observer) {
        dsTaint.addTaint(observer.dsTaint);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalStateException("an observer is already registered");
        } //End block
        mObserver = new ContentObserverProxy(observer, this);
        mCursor.registerContentObserver(mObserver);
        // ---------- Original Method ----------
        //if (mObserver != null) {
            //throw new IllegalStateException("an observer is already registered");
        //}
        //mObserver = new ContentObserverProxy(observer, this);
        //mCursor.registerContentObserver(mObserver);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.592 -0400", hash_original_method = "8431B5C8F0968484F229748CA95CA0A8", hash_generated_method = "002C7903C9B809A7064A64068962962D")
    @DSModeled(DSC.SAFE)
    private void unregisterObserverProxyLocked() {
        {
            mCursor.unregisterContentObserver(mObserver);
            mObserver.unlinkToDeath(this);
            mObserver = null;
        } //End block
        // ---------- Original Method ----------
        //if (mObserver != null) {
            //mCursor.unregisterContentObserver(mObserver);
            //mObserver.unlinkToDeath(this);
            //mObserver = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.593 -0400", hash_original_method = "D70B44F91871C59AEA1A14E0E16BCFE5", hash_generated_method = "1642C4A3460C5745824270CDB9220E7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Bundle getExtras() {
        {
            throwIfCursorIsClosed();
            Bundle var7916F32BF738E1F7CD36D940EA225A08_701992004 = (mCursor.getExtras());
        } //End block
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //throwIfCursorIsClosed();
            //return mCursor.getExtras();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.593 -0400", hash_original_method = "7B57D96B3C93268C95F4ADF84D5A7417", hash_generated_method = "9BF4BBCCBF4B069ABE0259097F55DBC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Bundle respond(Bundle extras) {
        dsTaint.addTaint(extras.dsTaint);
        {
            throwIfCursorIsClosed();
            Bundle var32A09397F8F15377A87480A62043F9AB_2053541493 = (mCursor.respond(extras));
        } //End block
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //throwIfCursorIsClosed();
            //return mCursor.respond(extras);
        //}
    }

    
    private static final class ContentObserverProxy extends ContentObserver {
        protected IContentObserver mRemote;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.593 -0400", hash_original_method = "319996A1B242CEE2610029D3C2CFA436", hash_generated_method = "E5D21F9F6A007F1C1D79B2447D32D4C6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ContentObserverProxy(IContentObserver remoteObserver, DeathRecipient recipient) {
            super(null);
            dsTaint.addTaint(remoteObserver.dsTaint);
            dsTaint.addTaint(recipient.dsTaint);
            try 
            {
                remoteObserver.asBinder().linkToDeath(recipient, 0);
            } //End block
            catch (RemoteException e)
            { }
            // ---------- Original Method ----------
            //mRemote = remoteObserver;
            //try {
                //remoteObserver.asBinder().linkToDeath(recipient, 0);
            //} catch (RemoteException e) {
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.593 -0400", hash_original_method = "96222C4BC704270291C489EC7FF2AF65", hash_generated_method = "895AAC279A939623D93387BA1C070ED7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean unlinkToDeath(DeathRecipient recipient) {
            dsTaint.addTaint(recipient.dsTaint);
            boolean var9B7D13AFC7CC219CF51B2ED7350C5633_1637609225 = (mRemote.asBinder().unlinkToDeath(recipient, 0));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mRemote.asBinder().unlinkToDeath(recipient, 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.593 -0400", hash_original_method = "A5B2D8696143266ED24B145CF029F206", hash_generated_method = "04AF9B9E52102CC0A16782543D266E43")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean deliverSelfNotifications() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.594 -0400", hash_original_method = "288C053C9E4DFF84CBC0887DEC7513A2", hash_generated_method = "70F26799975000E596746C61F269D741")
        @DSModeled(DSC.SAFE)
        @Override
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(selfChange);
            try 
            {
                mRemote.onChange(selfChange);
            } //End block
            catch (RemoteException ex)
            { }
            // ---------- Original Method ----------
            //try {
                //mRemote.onChange(selfChange);
            //} catch (RemoteException ex) {
            //}
        }

        
    }


    
}


