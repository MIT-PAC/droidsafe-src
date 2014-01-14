package android.database;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.os.Bundle;
import android.os.RemoteException;

public final class BulkCursorToCursorAdaptor extends AbstractWindowedCursor {

    /**
     * Returns column index of "_id" column, or -1 if not found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.677 -0500", hash_original_method = "A1363D8F4C336B0A08C904C28B9D0448", hash_generated_method = "FF55DCE7800A970FD612A052C53A3446")
    
public static int findRowIdColumnIndex(String[] columnNames) {
        int length = columnNames.length;
        for (int i = 0; i < length; i++) {
            if (columnNames[i].equals("_id")) {
                return i;
            }
        }
        return -1;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.660 -0500", hash_original_field = "084582FAD180EC515575FE3E8435607F", hash_generated_field = "ADC0FCD54016ADA5A4BD1654F2DAEC28")

    private static final String TAG = "BulkCursor";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.663 -0500", hash_original_field = "B137C0C42FB6695835607BC3B3F48B0E", hash_generated_field = "1E15C10F775B223368F80DF5C8726D1A")

    private SelfContentObserver mObserverBridge = new SelfContentObserver(this);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.666 -0500", hash_original_field = "66CFECD4811614CB55DCEE3BC7CCEF08", hash_generated_field = "9C921B869C896D2D1E8F32F098601C98")

    private IBulkCursor mBulkCursor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.668 -0500", hash_original_field = "228E80965D19F3262507FB2E30484C98", hash_generated_field = "C71F96D16C33B34D6BB40030CD898648")

    private int mCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.670 -0500", hash_original_field = "05C6FA34740ED8752F22266873F75802", hash_generated_field = "53DC72E56AF72859CCB6315DB649FC3E")

    private String[] mColumns;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.672 -0500", hash_original_field = "0541A92F1227967C4F621D00D304DDFF", hash_generated_field = "09D230C6B972C5B44F7AE21F206E5D75")

    private boolean mWantsAllOnMoveCalls;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.525 -0400", hash_original_method = "579A2D9511CAAA6B79AA847929FD0E6D", hash_generated_method = "579A2D9511CAAA6B79AA847929FD0E6D")
    public BulkCursorToCursorAdaptor ()
    {
        //Synthesized constructor
    }

    /**
     * Initializes the adaptor.
     * Must be called before first use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.675 -0500", hash_original_method = "BDEAB060DBF06B617753E5FD68DF3DA6", hash_generated_method = "555C784C8E6FB0A57ACAD5F7648D3C10")
    
public void initialize(IBulkCursor bulkCursor, int count, int idIndex,
            boolean wantsAllOnMoveCalls) {
        mBulkCursor = bulkCursor;
        mColumns = null;  // lazily retrieved
        mCount = count;
        mRowIdColumnIndex = idIndex;
        mWantsAllOnMoveCalls = wantsAllOnMoveCalls;
    }

    /**
     * Gets a SelfDataChangeOberserver that can be sent to a remote
     * process to receive change notifications over IPC.
     *
     * @return A SelfContentObserver hooked up to this Cursor
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.679 -0500", hash_original_method = "7E3AA4478BE7164F626026375ACE354B", hash_generated_method = "A1B41044A931BC9485859EA8186C9405")
    
public IContentObserver getObserver() {
        return mObserverBridge.getContentObserver();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.682 -0500", hash_original_method = "A0DC3D6282923B31FCC435384F5B1B63", hash_generated_method = "207A1BFBBD46C28991369216F5EE6345")
    
private void throwIfCursorIsClosed() {
        if (mBulkCursor == null) {
            throw new StaleDataException("Attempted to access a cursor after it has been closed.");
        }
    }

    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.684 -0500", hash_original_method = "0E6B64C20F6304D897F9214656E1B9B2", hash_generated_method = "D697043E99580945CEDED89CB5B67AFF")
    
@Override
    public int getCount() {
        throwIfCursorIsClosed();
        return mCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.687 -0500", hash_original_method = "A467CB6464BEC42A874BA0630DE4F114", hash_generated_method = "09F47DC1114E682C359099978799C88E")
    
@Override
    public boolean onMove(int oldPosition, int newPosition) {
        throwIfCursorIsClosed();

        try {
            // Make sure we have the proper window
            if (mWindow == null
                    || newPosition < mWindow.getStartPosition()
                    || newPosition >= mWindow.getStartPosition() + mWindow.getNumRows()) {
                setWindow(mBulkCursor.getWindow(newPosition));
            } else if (mWantsAllOnMoveCalls) {
                mBulkCursor.onMove(newPosition);
            }
        } catch (RemoteException ex) {
            // We tried to get a window and failed
            Log.e(TAG, "Unable to get window because the remote process is dead");
            return false;
        }

        // Couldn't obtain a window, something is wrong
        if (mWindow == null) {
            return false;
        }

        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.690 -0500", hash_original_method = "DCD3F558B41192D9CD395623901FE4A3", hash_generated_method = "43C1A334BDCC98642B77185AA91788D1")
    
@Override
    public void deactivate() {
        // This will call onInvalidated(), so make sure to do it before calling release,
        // which is what actually makes the data set invalid.
        super.deactivate();

        if (mBulkCursor != null) {
            try {
                mBulkCursor.deactivate();
            } catch (RemoteException ex) {
                Log.w(TAG, "Remote process exception when deactivating");
            }
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.693 -0500", hash_original_method = "546597EB3DC3CEE4DD604F653491E5D5", hash_generated_method = "68B5B5B856D9D581E046B181EAFB98EC")
    
@Override
    public void close() {
        super.close();

        if (mBulkCursor != null) {
            try {
                mBulkCursor.close();
            } catch (RemoteException ex) {
                Log.w(TAG, "Remote process exception when closing");
            } finally {
                mBulkCursor = null;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.696 -0500", hash_original_method = "2BB8C0DB5A3CE31D75C859DF8A5992AB", hash_generated_method = "6AE83350538398CFDDEDC3B303DB78A3")
    
@Override
    public boolean requery() {
        throwIfCursorIsClosed();

        try {
            mCount = mBulkCursor.requery(getObserver());
            if (mCount != -1) {
                mPos = -1;
                closeWindow();

                // super.requery() will call onChanged. Do it here instead of relying on the
                // observer from the far side so that observers can see a correct value for mCount
                // when responding to onChanged.
                super.requery();
                return true;
            } else {
                deactivate();
                return false;
            }
        } catch (Exception ex) {
            Log.e(TAG, "Unable to requery because the remote process exception " + ex.getMessage());
            deactivate();
            return false;
        }
    }

    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.698 -0500", hash_original_method = "1A723D6E7321D209C1569AA4BBEA85AD", hash_generated_method = "06750EEE4BAB9F09AD43FB3D07543703")
    
@Override
    public String[] getColumnNames() {
        throwIfCursorIsClosed();

        if (mColumns == null) {
            try {
                mColumns = mBulkCursor.getColumnNames();
            } catch (RemoteException ex) {
                Log.e(TAG, "Unable to fetch column names because the remote process is dead");
                return null;
            }
        }
        return mColumns;
    }

    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.701 -0500", hash_original_method = "5109D579D87DF77312539D6DDC351AB2", hash_generated_method = "3BC2D21BA5951A433D2AF7F4C9FC0409")
    
@Override
    public Bundle getExtras() {
        throwIfCursorIsClosed();

        try {
            return mBulkCursor.getExtras();
        } catch (RemoteException e) {
            // This should never happen because the system kills processes that are using remote
            // cursors when the provider process is killed.
            throw new RuntimeException(e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.703 -0500", hash_original_method = "EAE7773B95560E382A302B739F6438AF", hash_generated_method = "CA31A1DF73C78C7596D1AB956319DEDC")
    
@Override
    public Bundle respond(Bundle extras) {
        throwIfCursorIsClosed();

        try {
            return mBulkCursor.respond(extras);
        } catch (RemoteException e) {
            // the system kills processes that are using remote cursors when the provider process
            // is killed, but this can still happen if this is being called from the system process,
            // so, better to log and return an empty bundle.
            Log.w(TAG, "respond() threw RemoteException, returning an empty bundle.", e);
            return Bundle.EMPTY;
        }
    }
}

