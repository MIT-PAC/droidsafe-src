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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.886 -0400", hash_original_field = "DFCD77CC0FBBCE4763B1866A24A4CCFF", hash_generated_field = "1E15C10F775B223368F80DF5C8726D1A")

    private SelfContentObserver mObserverBridge = new SelfContentObserver(this);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.886 -0400", hash_original_field = "5E226C90629AB595B8588FEA451FAAAF", hash_generated_field = "9C921B869C896D2D1E8F32F098601C98")

    private IBulkCursor mBulkCursor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.886 -0400", hash_original_field = "4A5FC91463CC1EF00D3AA26340B946C6", hash_generated_field = "C71F96D16C33B34D6BB40030CD898648")

    private int mCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.886 -0400", hash_original_field = "11C985F30142FD30ACDDFE7CD3BD4A9B", hash_generated_field = "53DC72E56AF72859CCB6315DB649FC3E")

    private String[] mColumns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.886 -0400", hash_original_field = "DDF7CB3D8C37186F6FE6C3046EEF714F", hash_generated_field = "09D230C6B972C5B44F7AE21F206E5D75")

    private boolean mWantsAllOnMoveCalls;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.886 -0400", hash_original_method = "579A2D9511CAAA6B79AA847929FD0E6D", hash_generated_method = "579A2D9511CAAA6B79AA847929FD0E6D")
    public BulkCursorToCursorAdaptor ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.888 -0400", hash_original_method = "BDEAB060DBF06B617753E5FD68DF3DA6", hash_generated_method = "C4BF3C1490A19F47820FA1CE7FB8BFA7")
    public void initialize(IBulkCursor bulkCursor, int count, int idIndex,
            boolean wantsAllOnMoveCalls) {
        mBulkCursor = bulkCursor;
        mColumns = null;
        mCount = count;
        mRowIdColumnIndex = idIndex;
        mWantsAllOnMoveCalls = wantsAllOnMoveCalls;
        addTaint(idIndex);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.907 -0400", hash_original_method = "7E3AA4478BE7164F626026375ACE354B", hash_generated_method = "9F917A128D623AE1E929C20A32F148C5")
    public IContentObserver getObserver() {
        IContentObserver varB4EAC82CA7396A68D541C85D26508E83_816532611 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_816532611 = mObserverBridge.getContentObserver();
        varB4EAC82CA7396A68D541C85D26508E83_816532611.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_816532611;
        // ---------- Original Method ----------
        //return mObserverBridge.getContentObserver();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.913 -0400", hash_original_method = "A0DC3D6282923B31FCC435384F5B1B63", hash_generated_method = "AED704B19692C0B9B6F162F6EE810BE2")
    private void throwIfCursorIsClosed() {
        {
            if (DroidSafeAndroidRuntime.control) throw new StaleDataException("Attempted to access a cursor after it has been closed.");
        } //End block
        // ---------- Original Method ----------
        //if (mBulkCursor == null) {
            //throw new StaleDataException("Attempted to access a cursor after it has been closed.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.914 -0400", hash_original_method = "0E6B64C20F6304D897F9214656E1B9B2", hash_generated_method = "45DCE602591F340CC1DAF8DA378A8BDF")
    @Override
    public int getCount() {
        throwIfCursorIsClosed();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_397471988 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_397471988;
        // ---------- Original Method ----------
        //throwIfCursorIsClosed();
        //return mCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.919 -0400", hash_original_method = "A467CB6464BEC42A874BA0630DE4F114", hash_generated_method = "6BE8FA109291CE77C49294FA7333FFAA")
    @Override
    public boolean onMove(int oldPosition, int newPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        throwIfCursorIsClosed();
        try 
        {
            {
                boolean var10E2EB2E8ECA2B99393EB1BD9857E6EB_1943916135 = (mWindow == null
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
        addTaint(oldPosition);
        addTaint(newPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1910581425 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1910581425;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.920 -0400", hash_original_method = "DCD3F558B41192D9CD395623901FE4A3", hash_generated_method = "CCFD74321B9B3C095A7B5F0BE9C913C3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.934 -0400", hash_original_method = "546597EB3DC3CEE4DD604F653491E5D5", hash_generated_method = "E628519AB24A951645F3C6D8EA5D7BBF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.947 -0400", hash_original_method = "2BB8C0DB5A3CE31D75C859DF8A5992AB", hash_generated_method = "2093AD77F68A750C6C043D642FC261EF")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2069820653 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2069820653;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.957 -0400", hash_original_method = "1A723D6E7321D209C1569AA4BBEA85AD", hash_generated_method = "CD475AAA970E4843A0189C8DCA4D5FB1")
    @Override
    public String[] getColumnNames() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_192239341 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_888460068 = null; //Variable for return #2
        throwIfCursorIsClosed();
        {
            try 
            {
                mColumns = mBulkCursor.getColumnNames();
            } //End block
            catch (RemoteException ex)
            {
                varB4EAC82CA7396A68D541C85D26508E83_192239341 = null;
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_888460068 = mColumns;
        String[] varA7E53CE21691AB073D9660D615818899_1694907835; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1694907835 = varB4EAC82CA7396A68D541C85D26508E83_192239341;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1694907835 = varB4EAC82CA7396A68D541C85D26508E83_888460068;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1694907835.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1694907835;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.968 -0400", hash_original_method = "5109D579D87DF77312539D6DDC351AB2", hash_generated_method = "6F711142D93B02F9F56C4C372AE7EFE1")
    @Override
    public Bundle getExtras() {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_815807527 = null; //Variable for return #1
        throwIfCursorIsClosed();
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_815807527 = mBulkCursor.getExtras();
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_815807527.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_815807527;
        // ---------- Original Method ----------
        //throwIfCursorIsClosed();
        //try {
            //return mBulkCursor.getExtras();
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.972 -0400", hash_original_method = "EAE7773B95560E382A302B739F6438AF", hash_generated_method = "12C5552E0A75D3F3FA12485631B87979")
    @Override
    public Bundle respond(Bundle extras) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_694102561 = null; //Variable for return #1
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1809795876 = null; //Variable for return #2
        throwIfCursorIsClosed();
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_694102561 = mBulkCursor.respond(extras);
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1809795876 = Bundle.EMPTY;
        } //End block
        addTaint(extras.getTaint());
        Bundle varA7E53CE21691AB073D9660D615818899_1599992916; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1599992916 = varB4EAC82CA7396A68D541C85D26508E83_694102561;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1599992916 = varB4EAC82CA7396A68D541C85D26508E83_1809795876;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1599992916.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1599992916;
        // ---------- Original Method ----------
        //throwIfCursorIsClosed();
        //try {
            //return mBulkCursor.respond(extras);
        //} catch (RemoteException e) {
            //Log.w(TAG, "respond() threw RemoteException, returning an empty bundle.", e);
            //return Bundle.EMPTY;
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.972 -0400", hash_original_field = "5C21103A672655DA3072B23ECCA325CD", hash_generated_field = "25EF59C9AB110C51620ACBA22A1108FB")

    private static String TAG = "BulkCursor";
}

