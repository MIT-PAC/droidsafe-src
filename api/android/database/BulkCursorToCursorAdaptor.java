package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;

public final class BulkCursorToCursorAdaptor extends AbstractWindowedCursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.524 -0400", hash_original_field = "DFCD77CC0FBBCE4763B1866A24A4CCFF", hash_generated_field = "1E15C10F775B223368F80DF5C8726D1A")

    private SelfContentObserver mObserverBridge = new SelfContentObserver(this);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.524 -0400", hash_original_field = "5E226C90629AB595B8588FEA451FAAAF", hash_generated_field = "9C921B869C896D2D1E8F32F098601C98")

    private IBulkCursor mBulkCursor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.524 -0400", hash_original_field = "4A5FC91463CC1EF00D3AA26340B946C6", hash_generated_field = "C71F96D16C33B34D6BB40030CD898648")

    private int mCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.525 -0400", hash_original_field = "11C985F30142FD30ACDDFE7CD3BD4A9B", hash_generated_field = "53DC72E56AF72859CCB6315DB649FC3E")

    private String[] mColumns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.525 -0400", hash_original_field = "DDF7CB3D8C37186F6FE6C3046EEF714F", hash_generated_field = "09D230C6B972C5B44F7AE21F206E5D75")

    private boolean mWantsAllOnMoveCalls;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.525 -0400", hash_original_method = "579A2D9511CAAA6B79AA847929FD0E6D", hash_generated_method = "579A2D9511CAAA6B79AA847929FD0E6D")
    public BulkCursorToCursorAdaptor ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.526 -0400", hash_original_method = "BDEAB060DBF06B617753E5FD68DF3DA6", hash_generated_method = "CF17B3F2DAC2067844F40FF84CF8C685")
    public void initialize(IBulkCursor bulkCursor, int count, int idIndex,
            boolean wantsAllOnMoveCalls) {
        addTaint(idIndex);
        mBulkCursor = bulkCursor;
        mColumns = null;
        mCount = count;
        mRowIdColumnIndex = idIndex;
        mWantsAllOnMoveCalls = wantsAllOnMoveCalls;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.527 -0400", hash_original_method = "7E3AA4478BE7164F626026375ACE354B", hash_generated_method = "D7D0F4B21BC063605D485787CF17F4EE")
    public IContentObserver getObserver() {
IContentObserver var79B4C6682518603384B80B07D25B4279_2035851578 =         mObserverBridge.getContentObserver();
        var79B4C6682518603384B80B07D25B4279_2035851578.addTaint(taint);
        return var79B4C6682518603384B80B07D25B4279_2035851578;
        // ---------- Original Method ----------
        //return mObserverBridge.getContentObserver();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.528 -0400", hash_original_method = "A0DC3D6282923B31FCC435384F5B1B63", hash_generated_method = "8C4996307801C0ACA2AC5495811F0748")
    private void throwIfCursorIsClosed() {
        if(mBulkCursor == null)        
        {
            StaleDataException var241EC54C1C02F408EBF48FDE17C24E97_1659716995 = new StaleDataException("Attempted to access a cursor after it has been closed.");
            var241EC54C1C02F408EBF48FDE17C24E97_1659716995.addTaint(taint);
            throw var241EC54C1C02F408EBF48FDE17C24E97_1659716995;
        } //End block
        // ---------- Original Method ----------
        //if (mBulkCursor == null) {
            //throw new StaleDataException("Attempted to access a cursor after it has been closed.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.530 -0400", hash_original_method = "0E6B64C20F6304D897F9214656E1B9B2", hash_generated_method = "F4DA8B007C92B801263CA47279A5EB82")
    @Override
    public int getCount() {
        throwIfCursorIsClosed();
        int var4A5FC91463CC1EF00D3AA26340B946C6_1991145802 = (mCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_389993160 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_389993160;
        // ---------- Original Method ----------
        //throwIfCursorIsClosed();
        //return mCount;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.532 -0400", hash_original_method = "A467CB6464BEC42A874BA0630DE4F114", hash_generated_method = "7082F64604EFBB1098A332A8FA1330E6")
    @Override
    public boolean onMove(int oldPosition, int newPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newPosition);
        addTaint(oldPosition);
        throwIfCursorIsClosed();
        try 
        {
            if(mWindow == null
                    || newPosition < mWindow.getStartPosition()
                    || newPosition >= mWindow.getStartPosition() + mWindow.getNumRows())            
            {
                setWindow(mBulkCursor.getWindow(newPosition));
            } //End block
            else
            if(mWantsAllOnMoveCalls)            
            {
                mBulkCursor.onMove(newPosition);
            } //End block
        } //End block
        catch (RemoteException ex)
        {
            boolean var68934A3E9455FA72420237EB05902327_1792654603 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1063787432 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1063787432;
        } //End block
        if(mWindow == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1379399396 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1991342422 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1991342422;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_924881080 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_94030364 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_94030364;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.534 -0400", hash_original_method = "DCD3F558B41192D9CD395623901FE4A3", hash_generated_method = "ED7A593E1FCB5ECE9BD6FCEFF4B73CDD")
    @Override
    public void deactivate() {
        super.deactivate();
        if(mBulkCursor != null)        
        {
            try 
            {
                mBulkCursor.deactivate();
            } //End block
            catch (RemoteException ex)
            {
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.535 -0400", hash_original_method = "546597EB3DC3CEE4DD604F653491E5D5", hash_generated_method = "B726E89BEC8F15DFCCF0CB5B814DC12C")
    @Override
    public void close() {
        super.close();
        if(mBulkCursor != null)        
        {
            try 
            {
                mBulkCursor.close();
            } //End block
            catch (RemoteException ex)
            {
            } //End block
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.538 -0400", hash_original_method = "2BB8C0DB5A3CE31D75C859DF8A5992AB", hash_generated_method = "72609CE14E7891D5E0FEB788E59B7E7F")
    @Override
    public boolean requery() {
        throwIfCursorIsClosed();
        try 
        {
            mCount = mBulkCursor.requery(getObserver());
            if(mCount != -1)            
            {
                mPos = -1;
                closeWindow();
                super.requery();
                boolean varB326B5062B2F0E69046810717534CB09_651076055 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1168362279 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1168362279;
            } //End block
            else
            {
                deactivate();
                boolean var68934A3E9455FA72420237EB05902327_685945301 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_860800854 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_860800854;
            } //End block
        } //End block
        catch (Exception ex)
        {
            deactivate();
            boolean var68934A3E9455FA72420237EB05902327_267421566 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1721357883 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1721357883;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.540 -0400", hash_original_method = "1A723D6E7321D209C1569AA4BBEA85AD", hash_generated_method = "2BCB60F991CEE8D2E06CFF30A0F0C22D")
    @Override
    public String[] getColumnNames() {
        throwIfCursorIsClosed();
        if(mColumns == null)        
        {
            try 
            {
                mColumns = mBulkCursor.getColumnNames();
            } //End block
            catch (RemoteException ex)
            {
String[] var540C13E9E156B687226421B24F2DF178_1693309502 =                 null;
                var540C13E9E156B687226421B24F2DF178_1693309502.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1693309502;
            } //End block
        } //End block
String[] varD3E6185118B69354C5CA1E2493E0C19D_369012382 =         mColumns;
        varD3E6185118B69354C5CA1E2493E0C19D_369012382.addTaint(taint);
        return varD3E6185118B69354C5CA1E2493E0C19D_369012382;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.541 -0400", hash_original_method = "5109D579D87DF77312539D6DDC351AB2", hash_generated_method = "839DAA60CC711C6E5F05B1BC5C8C87F5")
    @Override
    public Bundle getExtras() {
        throwIfCursorIsClosed();
        try 
        {
Bundle varC9D220A55BC9FCE6E848D4BF5278F31D_1305962087 =             mBulkCursor.getExtras();
            varC9D220A55BC9FCE6E848D4BF5278F31D_1305962087.addTaint(taint);
            return varC9D220A55BC9FCE6E848D4BF5278F31D_1305962087;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1532465719 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_1532465719.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_1532465719;
        } //End block
        // ---------- Original Method ----------
        //throwIfCursorIsClosed();
        //try {
            //return mBulkCursor.getExtras();
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.542 -0400", hash_original_method = "EAE7773B95560E382A302B739F6438AF", hash_generated_method = "A534B5126AF75721B662590F36D5EE82")
    @Override
    public Bundle respond(Bundle extras) {
        addTaint(extras.getTaint());
        throwIfCursorIsClosed();
        try 
        {
Bundle varDA852F898B244A7E1232C20D0C2D350D_1762428426 =             mBulkCursor.respond(extras);
            varDA852F898B244A7E1232C20D0C2D350D_1762428426.addTaint(taint);
            return varDA852F898B244A7E1232C20D0C2D350D_1762428426;
        } //End block
        catch (RemoteException e)
        {
Bundle var998437625BBF03281B97467174D26383_1430458875 =             Bundle.EMPTY;
            var998437625BBF03281B97467174D26383_1430458875.addTaint(taint);
            return var998437625BBF03281B97467174D26383_1430458875;
        } //End block
        // ---------- Original Method ----------
        //throwIfCursorIsClosed();
        //try {
            //return mBulkCursor.respond(extras);
        //} catch (RemoteException e) {
            //Log.w(TAG, "respond() threw RemoteException, returning an empty bundle.", e);
            //return Bundle.EMPTY;
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.542 -0400", hash_original_field = "5C21103A672655DA3072B23ECCA325CD", hash_generated_field = "ADC0FCD54016ADA5A4BD1654F2DAEC28")

    private static final String TAG = "BulkCursor";
}

