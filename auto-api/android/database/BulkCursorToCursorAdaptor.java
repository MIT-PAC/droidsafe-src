package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;

public final class BulkCursorToCursorAdaptor extends AbstractWindowedCursor {
    private SelfContentObserver mObserverBridge = new SelfContentObserver(this);
    private IBulkCursor mBulkCursor;
    private int mCount;
    private String[] mColumns;
    private boolean mWantsAllOnMoveCalls;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.912 -0400", hash_original_method = "A6CFBFC2E59FD19561DBBA73975B9CA3", hash_generated_method = "A6CFBFC2E59FD19561DBBA73975B9CA3")
        public BulkCursorToCursorAdaptor ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.913 -0400", hash_original_method = "BDEAB060DBF06B617753E5FD68DF3DA6", hash_generated_method = "C7FA919028F7AAA97A82AE2F06E5ED7B")
    @DSModeled(DSC.SAFE)
    public void initialize(IBulkCursor bulkCursor, int count, int idIndex,
            boolean wantsAllOnMoveCalls) {
        dsTaint.addTaint(idIndex);
        dsTaint.addTaint(wantsAllOnMoveCalls);
        dsTaint.addTaint(count);
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

    
        public static int findRowIdColumnIndex(String[] columnNames) {
        int length = columnNames.length;
        for (int i = 0; i < length; i++) {
            if (columnNames[i].equals("_id")) {
                return i;
            }
        }
        return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.914 -0400", hash_original_method = "7E3AA4478BE7164F626026375ACE354B", hash_generated_method = "29A3A247D7E50EE504AFC17AB69D137A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IContentObserver getObserver() {
        IContentObserver varF0F7B79B7FE9E6E0669A90F0C6B3D24E_779276117 = (mObserverBridge.getContentObserver());
        return (IContentObserver)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mObserverBridge.getContentObserver();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.914 -0400", hash_original_method = "A0DC3D6282923B31FCC435384F5B1B63", hash_generated_method = "AED704B19692C0B9B6F162F6EE810BE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void throwIfCursorIsClosed() {
        {
            if (DroidSafeAndroidRuntime.control) throw new StaleDataException("Attempted to access a cursor after it has been closed.");
        } //End block
        // ---------- Original Method ----------
        //if (mBulkCursor == null) {
            //throw new StaleDataException("Attempted to access a cursor after it has been closed.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.914 -0400", hash_original_method = "0E6B64C20F6304D897F9214656E1B9B2", hash_generated_method = "164B98CBCF7F5028027A940D02201F5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getCount() {
        throwIfCursorIsClosed();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //throwIfCursorIsClosed();
        //return mCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.915 -0400", hash_original_method = "A467CB6464BEC42A874BA0630DE4F114", hash_generated_method = "0AFFC1C5A6C82F32F7DE733B7DEC08B5")
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
                boolean var10E2EB2E8ECA2B99393EB1BD9857E6EB_331291162 = (mWindow == null
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.915 -0400", hash_original_method = "DCD3F558B41192D9CD395623901FE4A3", hash_generated_method = "CCFD74321B9B3C095A7B5F0BE9C913C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.916 -0400", hash_original_method = "546597EB3DC3CEE4DD604F653491E5D5", hash_generated_method = "E628519AB24A951645F3C6D8EA5D7BBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.916 -0400", hash_original_method = "2BB8C0DB5A3CE31D75C859DF8A5992AB", hash_generated_method = "9D5C2E686CF21028ACCCA87538AB6194")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.917 -0400", hash_original_method = "1A723D6E7321D209C1569AA4BBEA85AD", hash_generated_method = "B5A2600E07EE3309F35CBC8A97F9D888")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.926 -0400", hash_original_method = "5109D579D87DF77312539D6DDC351AB2", hash_generated_method = "91DDB2DD75EF1F9783223DFFCBC8E5B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Bundle getExtras() {
        throwIfCursorIsClosed();
        try 
        {
            Bundle varB2D512B50FEBC63CA5519A1AD6E413B6_291710344 = (mBulkCursor.getExtras());
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.929 -0400", hash_original_method = "EAE7773B95560E382A302B739F6438AF", hash_generated_method = "803378B3B9F18D9DE791279EDCA1DDE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Bundle respond(Bundle extras) {
        dsTaint.addTaint(extras.dsTaint);
        throwIfCursorIsClosed();
        try 
        {
            Bundle var938E92CDDE678F06C825B0E7A34E5C12_1892944312 = (mBulkCursor.respond(extras));
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

    
    private static final String TAG = "BulkCursor";
}

