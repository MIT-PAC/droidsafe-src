package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public final class CursorToBulkCursorAdaptor extends BulkCursorNative implements IBinder.DeathRecipient {
    private Object mLock = new Object();
    private String mProviderName;
    private ContentObserverProxy mObserver;
    private CrossProcessCursor mCursor;
    private CursorWindow mFilledWindow;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.007 -0400", hash_original_method = "DFFFDCE95BD5626A15621DE9255909D3", hash_generated_method = "11C6797AF8DAB82B3DC79FF96010CDF0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.007 -0400", hash_original_method = "AD579F119ED4886B2C182C86869C4CD9", hash_generated_method = "C0A1ED446740574B689012835A978650")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.008 -0400", hash_original_method = "E626ABF61F7540C19BF105C7958133EC", hash_generated_method = "FC6E01A149851342D11F794232C93227")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.008 -0400", hash_original_method = "18B24C6ABC409A0E548E21131FCA3F48", hash_generated_method = "52590B2688227D4F3CDE916B839BBFBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void throwIfCursorIsClosed() {
        {
            if (DroidSafeAndroidRuntime.control) throw new StaleDataException("Attempted to access a cursor after it has been closed.");
        } //End block
        // ---------- Original Method ----------
        //if (mCursor == null) {
            //throw new StaleDataException("Attempted to access a cursor after it has been closed.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.008 -0400", hash_original_method = "C4AF1DDC0409484A2B59D555E10A97E5", hash_generated_method = "7811CE0DF771F7DCC608E68A68E599FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.009 -0400", hash_original_method = "4ECB0E8EDFF03AFDCED1B443F780B12E", hash_generated_method = "6E37611918186EFD94AEBEE0A37D3368")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CursorWindow getWindow(int startPos) {
        dsTaint.addTaint(startPos);
        {
            throwIfCursorIsClosed();
            {
                boolean var04D558ECAB1E17991563926E69879491_290514987 = (!mCursor.moveToPosition(startPos));
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
                    boolean varC97F342FBEDA56BA63E8F208810D5BA4_1369253371 = (startPos < window.getStartPosition()
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.018 -0400", hash_original_method = "4E23514B564E80A833367A4C9E43D15C", hash_generated_method = "524BD24B682D30851391BA5E5F5C5939")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.019 -0400", hash_original_method = "DC4D033FD1BAE66931C8A4D6EEEA211D", hash_generated_method = "1178CFE323DDEC9BBD58B3FA14F60B48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int count() {
        {
            throwIfCursorIsClosed();
            int varA0B4CA491E47E321D82FB34DD7E77E5A_1009321604 = (mCursor.getCount());
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //throwIfCursorIsClosed();
            //return mCursor.getCount();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.021 -0400", hash_original_method = "51920E427207C9DB40FE51CEF3CF1E5F", hash_generated_method = "B6CA023DD652EBE64649E61F87A1851F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getColumnNames() {
        {
            throwIfCursorIsClosed();
            String[] varC7830ACD2DB98FB85D5A2F4CC0B549B0_1417672312 = (mCursor.getColumnNames());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.024 -0400", hash_original_method = "E8CA6D89EFD51007B93658764C0D15A1", hash_generated_method = "4301E443B96F110B0EDD6EDBEB212BEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.025 -0400", hash_original_method = "AC20EBAE7250AB68ABF5848E6A31630D", hash_generated_method = "66209B28B9295F964E905A06C3A39A02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.026 -0400", hash_original_method = "C42BE5036A3BA050EE736974AEACDE99", hash_generated_method = "42F0983F7C0F6B315050745F04134E3D")
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
                    boolean var9F860FB704DE0324D019EBF4330135F9_1476343312 = (!mCursor.requery());
                } //End collapsed parenthetic
            } //End block
            catch (IllegalStateException e)
            {
                IllegalStateException leakProgram;
                leakProgram = new IllegalStateException(
                        mProviderName + " Requery misuse db, mCursor isClosed:" +
                        mCursor.isClosed(), e);
                if (DroidSafeAndroidRuntime.control) throw leakProgram;
            } //End block
            unregisterObserverProxyLocked();
            createAndRegisterObserverProxyLocked(observer);
            int varA0B4CA491E47E321D82FB34DD7E77E5A_917036360 = (mCursor.getCount());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.027 -0400", hash_original_method = "4EDF40CD28E1B076C101ED75649491F5", hash_generated_method = "36822924F350867D062E6DB22C02EDF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getWantsAllOnMoveCalls() {
        {
            throwIfCursorIsClosed();
            boolean varA4ACC3F53F22F27EF64482D87EFB3327_1743557819 = (mCursor.getWantsAllOnMoveCalls());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //throwIfCursorIsClosed();
            //return mCursor.getWantsAllOnMoveCalls();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.029 -0400", hash_original_method = "1F751777DEFC6D435260F5703D7849F2", hash_generated_method = "677E6029A8E907833680B44D7A816DEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void createAndRegisterObserverProxyLocked(IContentObserver observer) {
        dsTaint.addTaint(observer.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("an observer is already registered");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.030 -0400", hash_original_method = "8431B5C8F0968484F229748CA95CA0A8", hash_generated_method = "5059298AAFCE2E73868DD161EF14E61F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.030 -0400", hash_original_method = "D70B44F91871C59AEA1A14E0E16BCFE5", hash_generated_method = "5E5D707BE2E48067BA7FF929C8FD3F56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Bundle getExtras() {
        {
            throwIfCursorIsClosed();
            Bundle var7916F32BF738E1F7CD36D940EA225A08_942764347 = (mCursor.getExtras());
        } //End block
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //throwIfCursorIsClosed();
            //return mCursor.getExtras();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.030 -0400", hash_original_method = "7B57D96B3C93268C95F4ADF84D5A7417", hash_generated_method = "3B63DEDED53484DA4637E288107BA0A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Bundle respond(Bundle extras) {
        dsTaint.addTaint(extras.dsTaint);
        {
            throwIfCursorIsClosed();
            Bundle var32A09397F8F15377A87480A62043F9AB_551599293 = (mCursor.respond(extras));
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.031 -0400", hash_original_method = "319996A1B242CEE2610029D3C2CFA436", hash_generated_method = "0FE28152A7A5E06B06D9D6E6B4543FD8")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.031 -0400", hash_original_method = "96222C4BC704270291C489EC7FF2AF65", hash_generated_method = "0F3B2966612221DD7CCFFEFAE0525F2F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean unlinkToDeath(DeathRecipient recipient) {
            dsTaint.addTaint(recipient.dsTaint);
            boolean var9B7D13AFC7CC219CF51B2ED7350C5633_965490589 = (mRemote.asBinder().unlinkToDeath(recipient, 0));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mRemote.asBinder().unlinkToDeath(recipient, 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.031 -0400", hash_original_method = "A5B2D8696143266ED24B145CF029F206", hash_generated_method = "F715171AD0DE912B03270516F086F02E")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean deliverSelfNotifications() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.031 -0400", hash_original_method = "288C053C9E4DFF84CBC0887DEC7513A2", hash_generated_method = "854F507851EDCE08C9D662B8D4C05008")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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


    
    private static final String TAG = "Cursor";
}

