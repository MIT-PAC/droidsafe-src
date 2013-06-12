package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;

public final class BulkCursorToCursorAdaptor extends AbstractWindowedCursor {
    private static final String TAG = "BulkCursor";
    private SelfContentObserver mObserverBridge = new SelfContentObserver(this);
    private IBulkCursor mBulkCursor;
    private int mCount;
    private String[] mColumns;
    private boolean mWantsAllOnMoveCalls;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.573 -0400", hash_original_method = "BDEAB060DBF06B617753E5FD68DF3DA6", hash_generated_method = "BA1812F3369DB9328D04F3B5A95716C5")
    @DSModeled(DSC.SAFE)
    public void initialize(IBulkCursor bulkCursor, int count, int idIndex,
            boolean wantsAllOnMoveCalls) {
        dsTaint.addTaint(idIndex);
        dsTaint.addTaint(count);
        dsTaint.addTaint(wantsAllOnMoveCalls);
        dsTaint.addTaint(bulkCursor.dsTaint);
        mColumns = null;
        mRowIdColumnIndex = idIndex;
        // ---------- Original Method ----------
        //mBulkCursor = bulkCursor;
        //mColumns = null;
        //mCount = count;
        //mRowIdColumnIndex = idIndex;
        //mWantsAllOnMoveCalls = wantsAllOnMoveCalls;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.573 -0400", hash_original_method = "A1363D8F4C336B0A08C904C28B9D0448", hash_generated_method = "FF55DCE7800A970FD612A052C53A3446")
    public static int findRowIdColumnIndex(String[] columnNames) {
        int length = columnNames.length;
        for (int i = 0; i < length; i++) {
            if (columnNames[i].equals("_id")) {
                return i;
            }
        }
        return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.573 -0400", hash_original_method = "7E3AA4478BE7164F626026375ACE354B", hash_generated_method = "34DB324F3F5B1D81A153AD3709BD6EA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IContentObserver getObserver() {
        IContentObserver varF0F7B79B7FE9E6E0669A90F0C6B3D24E_485806649 = (mObserverBridge.getContentObserver());
        return (IContentObserver)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mObserverBridge.getContentObserver();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.574 -0400", hash_original_method = "A0DC3D6282923B31FCC435384F5B1B63", hash_generated_method = "9E33B230260300BE4381C51E28E00295")
    @DSModeled(DSC.SAFE)
    private void throwIfCursorIsClosed() {
        {
            throw new StaleDataException("Attempted to access a cursor after it has been closed.");
        } //End block
        // ---------- Original Method ----------
        //if (mBulkCursor == null) {
            //throw new StaleDataException("Attempted to access a cursor after it has been closed.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.574 -0400", hash_original_method = "0E6B64C20F6304D897F9214656E1B9B2", hash_generated_method = "A1F40606BB41BF9789CB52979B6DD27D")
    @DSModeled(DSC.SAFE)
    @Override
    public int getCount() {
        throwIfCursorIsClosed();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //throwIfCursorIsClosed();
        //return mCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.574 -0400", hash_original_method = "A467CB6464BEC42A874BA0630DE4F114", hash_generated_method = "149CD3C9C7B4AE3444416A7AA541D817")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onMove(int oldPosition, int newPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newPosition);
        dsTaint.addTaint(oldPosition);
        throwIfCursorIsClosed();
        try 
        {
            {
                boolean var10E2EB2E8ECA2B99393EB1BD9857E6EB_1935642634 = (mWindow == null
                    || newPosition < mWindow.getStartPosition()
                    || newPosition >= mWindow.getStartPosition() + mWindow.getNumRows());
                {
                    setWindow(mBulkCursor.getWindow(newPosition));
                } //End block
                {
                    mBulkCursor.onMove(newPosition);
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (RemoteException ex)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throwIfCursorIsClosed();
        //try {
            //if (mWindow == null
                    //|| newPosition < mWindow.getStartPosition()
                    //|| newPosition >= mWindow.getStartPosition() + mWindow.getNumRows()) {
                //setWindow(mBulkCursor.getWindow(newPosition));
            //} else if (mWantsAllOnMoveCalls) {
                //mBulkCursor.onMove(newPosition);
            //}
        //} catch (RemoteException ex) {
            //Log.e(TAG, "Unable to get window because the remote process is dead");
            //return false;
        //}
        //if (mWindow == null) {
            //return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.574 -0400", hash_original_method = "DCD3F558B41192D9CD395623901FE4A3", hash_generated_method = "14D68B8B15052BDC551967A2BC1C9677")
    @DSModeled(DSC.SAFE)
    @Override
    public void deactivate() {
        super.deactivate();
        {
            try 
            {
                mBulkCursor.deactivate();
            } //End block
            catch (RemoteException ex)
            { }
        } //End block
        // ---------- Original Method ----------
        //super.deactivate();
        //if (mBulkCursor != null) {
            //try {
                //mBulkCursor.deactivate();
            //} catch (RemoteException ex) {
                //Log.w(TAG, "Remote process exception when deactivating");
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.575 -0400", hash_original_method = "546597EB3DC3CEE4DD604F653491E5D5", hash_generated_method = "BE06D04B1FECEABDBFFD491B1FF59404")
    @DSModeled(DSC.SAFE)
    @Override
    public void close() {
        super.close();
        {
            try 
            {
                mBulkCursor.close();
            } //End block
            catch (RemoteException ex)
            { }
            finally 
            {
                mBulkCursor = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //super.close();
        //if (mBulkCursor != null) {
            //try {
                //mBulkCursor.close();
            //} catch (RemoteException ex) {
                //Log.w(TAG, "Remote process exception when closing");
            //} finally {
                //mBulkCursor = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.575 -0400", hash_original_method = "2BB8C0DB5A3CE31D75C859DF8A5992AB", hash_generated_method = "6B5C90AF325EA16E362D3872502FB751")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean requery() {
        throwIfCursorIsClosed();
        try 
        {
            mCount = mBulkCursor.requery(getObserver());
            {
                mPos = -1;
                closeWindow();
                super.requery();
            } //End block
            {
                deactivate();
            } //End block
        } //End block
        catch (Exception ex)
        {
            deactivate();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throwIfCursorIsClosed();
        //try {
            //mCount = mBulkCursor.requery(getObserver());
            //if (mCount != -1) {
                //mPos = -1;
                //closeWindow();
                //super.requery();
                //return true;
            //} else {
                //deactivate();
                //return false;
            //}
        //} catch (Exception ex) {
            //Log.e(TAG, "Unable to requery because the remote process exception " + ex.getMessage());
            //deactivate();
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.575 -0400", hash_original_method = "1A723D6E7321D209C1569AA4BBEA85AD", hash_generated_method = "3B7D1EE5233DF18FD543F849CBCC0A4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getColumnNames() {
        throwIfCursorIsClosed();
        {
            try 
            {
                mColumns = mBulkCursor.getColumnNames();
            } //End block
            catch (RemoteException ex)
            { }
        } //End block
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //throwIfCursorIsClosed();
        //if (mColumns == null) {
            //try {
                //mColumns = mBulkCursor.getColumnNames();
            //} catch (RemoteException ex) {
                //Log.e(TAG, "Unable to fetch column names because the remote process is dead");
                //return null;
            //}
        //}
        //return mColumns;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.575 -0400", hash_original_method = "5109D579D87DF77312539D6DDC351AB2", hash_generated_method = "AAD9DBD1A0AE40742A969895B170AAF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Bundle getExtras() {
        throwIfCursorIsClosed();
        try 
        {
            Bundle varB2D512B50FEBC63CA5519A1AD6E413B6_1570375166 = (mBulkCursor.getExtras());
        } //End block
        catch (RemoteException e)
        {
            throw new RuntimeException(e);
        } //End block
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throwIfCursorIsClosed();
        //try {
            //return mBulkCursor.getExtras();
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.576 -0400", hash_original_method = "EAE7773B95560E382A302B739F6438AF", hash_generated_method = "FFA1DA886CD784BB386F6A0E3551E9E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Bundle respond(Bundle extras) {
        dsTaint.addTaint(extras.dsTaint);
        throwIfCursorIsClosed();
        try 
        {
            Bundle var938E92CDDE678F06C825B0E7A34E5C12_2141939938 = (mBulkCursor.respond(extras));
        } //End block
        catch (RemoteException e)
        { }
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throwIfCursorIsClosed();
        //try {
            //return mBulkCursor.respond(extras);
        //} catch (RemoteException e) {
            //Log.w(TAG, "respond() threw RemoteException, returning an empty bundle.", e);
            //return Bundle.EMPTY;
        //}
    }

    
}


