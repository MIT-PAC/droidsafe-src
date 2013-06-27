package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.database.AbstractWindowedCursor;
import android.database.CursorWindow;
import android.os.StrictMode;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

public class SQLiteCursor extends AbstractWindowedCursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.649 -0400", hash_original_field = "03938FDF3029AF609FD8FCBAEE02B61F", hash_generated_field = "973CDCF4620458EDC8DC04989EC9D73D")

    private String mEditTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.649 -0400", hash_original_field = "11C985F30142FD30ACDDFE7CD3BD4A9B", hash_generated_field = "53DC72E56AF72859CCB6315DB649FC3E")

    private String[] mColumns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.650 -0400", hash_original_field = "5B134E4A2754549415570918F1EB845F", hash_generated_field = "8A548C5C667EE7DF7972E25F8E1FD3F8")

    private SQLiteQuery mQuery;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.650 -0400", hash_original_field = "AC9FCB6C9481ACE03DAC8C5318667F64", hash_generated_field = "DF56BAF171B937E9CC6E593202E96226")

    private SQLiteCursorDriver mDriver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.650 -0400", hash_original_field = "EBFB1F1A33D1A84D7D0E8E8AF5105388", hash_generated_field = "F4532CB59B1200B34E9685596B8185FB")

    private volatile int mCount = NO_COUNT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.650 -0400", hash_original_field = "BF35522FC5AD02023860C40C8D630EAE", hash_generated_field = "5E829DFAED9C527F2433E5889E542D7A")

    private Map<String, Integer> mColumnNameMap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.650 -0400", hash_original_field = "9581B90EA40AE59A20069CB826265080", hash_generated_field = "7D1AA4359A52B133BFAD994AB60E8C14")

    private Throwable mStackTrace;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.651 -0400", hash_original_method = "7DD8316FC8BAC42467B622126F8A148B", hash_generated_method = "09B7124E53153D683FDAC379D3A1EFB2")
    @Deprecated
    public  SQLiteCursor(SQLiteDatabase db, SQLiteCursorDriver driver,
            String editTable, SQLiteQuery query) {
        this(driver, editTable, query);
        addTaint(db.getTaint());
        addTaint(driver.getTaint());
        addTaint(editTable.getTaint());
        addTaint(query.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.675 -0400", hash_original_method = "73EECE67D75C79AF0ED0AD77F55FFB21", hash_generated_method = "CF28EDFCA01238E2B1B8F8FDB5632F52")
    public  SQLiteCursor(SQLiteCursorDriver driver, String editTable, SQLiteQuery query) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("query object cannot be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("query.mDatabase cannot be null");
        } //End block
        {
            boolean varBD0BED841C7A62596CB2EE0AC9816352_1879545383 = (StrictMode.vmSqliteObjectLeaksEnabled());
            {
                mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
            } //End block
            {
                mStackTrace = null;
            } //End block
        } //End collapsed parenthetic
        mDriver = driver;
        mEditTable = editTable;
        mColumnNameMap = null;
        mQuery = query;
        query.mDatabase.lock(query.mSql);
        try 
        {
            int columnCount;
            columnCount = mQuery.columnCountLocked();
            mColumns = new String[columnCount];
            {
                int i;
                i = 0;
                {
                    String columnName;
                    columnName = mQuery.columnNameLocked(i);
                    mColumns[i] = columnName;
                    {
                        boolean var6E699E5A2763233841B13F54819B19BC_1599418586 = ("_id".equals(columnName));
                        {
                            mRowIdColumnIndex = i;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            query.mDatabase.unlock();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.677 -0400", hash_original_method = "AF759727D3C973E194D48B5E653874F6", hash_generated_method = "4C74F358B90609BFA29D4CBEA01951AF")
    public SQLiteDatabase getDatabase() {
        SQLiteDatabase varB4EAC82CA7396A68D541C85D26508E83_1219483403 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1219483403 = mQuery.mDatabase;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1219483403.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1219483403;
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mQuery.mDatabase;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.678 -0400", hash_original_method = "B4A0D7606429FC274C47739DBFA1C1E0", hash_generated_method = "6A1AED229C4173E12DA52E2398B6EC30")
    @Override
    public boolean onMove(int oldPosition, int newPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varD2A5E171BD01B4A42E6C2327228CF01B_6747404 = (mWindow == null || newPosition < mWindow.getStartPosition() ||
                newPosition >= (mWindow.getStartPosition() + mWindow.getNumRows()));
            {
                fillWindow(newPosition);
            } //End block
        } //End collapsed parenthetic
        addTaint(oldPosition);
        addTaint(newPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_645510957 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_645510957;
        // ---------- Original Method ----------
        //if (mWindow == null || newPosition < mWindow.getStartPosition() ||
                //newPosition >= (mWindow.getStartPosition() + mWindow.getNumRows())) {
            //fillWindow(newPosition);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.693 -0400", hash_original_method = "D7810D185EEBB48990AE6D5077F6CEAD", hash_generated_method = "A5FB727409ABDE3A8A7CAA817D10F6F7")
    @Override
    public int getCount() {
        {
            fillWindow(0);
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1762118758 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1762118758;
        // ---------- Original Method ----------
        //if (mCount == NO_COUNT) {
            //fillWindow(0);
        //}
        //return mCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.695 -0400", hash_original_method = "1027AA1FD2FF7DB5721417BC40818677", hash_generated_method = "2207342CC5926252FAC68C47C899A4E1")
    private void fillWindow(int startPos) {
        clearOrCreateWindow(getDatabase().getPath());
        mWindow.setStartPosition(startPos);
        int count;
        count = getQuery().fillWindow(mWindow);
        {
            {
                boolean varF062350F2983BA11C030C10A71A73C26_1998816202 = (Log.isLoggable(TAG, Log.DEBUG));
                {
                    Log.d(TAG, "received count(*) from native_fill_window: " + count);
                } //End block
            } //End collapsed parenthetic
            mCount = count;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Row count should never be zero or negative "
                    + "when the start position is non-zero");
        } //End block
        addTaint(startPos);
        // ---------- Original Method ----------
        //clearOrCreateWindow(getDatabase().getPath());
        //mWindow.setStartPosition(startPos);
        //int count = getQuery().fillWindow(mWindow);
        //if (startPos == 0) { 
            //if (Log.isLoggable(TAG, Log.DEBUG)) {
                //Log.d(TAG, "received count(*) from native_fill_window: " + count);
            //}
            //mCount = count;
        //} else if (mCount <= 0) {
            //throw new IllegalStateException("Row count should never be zero or negative "
                    //+ "when the start position is non-zero");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.696 -0400", hash_original_method = "976132A7E3467B4AD1CD095C1F4D25D0", hash_generated_method = "588269697E4E87379B24381B3937349E")
    private synchronized SQLiteQuery getQuery() {
        SQLiteQuery varB4EAC82CA7396A68D541C85D26508E83_1284056249 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1284056249 = mQuery;
        varB4EAC82CA7396A68D541C85D26508E83_1284056249.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1284056249;
        // ---------- Original Method ----------
        //return mQuery;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.698 -0400", hash_original_method = "96C3F6AE90641303728CA2622AC00A1C", hash_generated_method = "B2B8C6C2249BA9A11D6BDDB0124EFCEF")
    @Override
    public int getColumnIndex(String columnName) {
        {
            String[] columns;
            columns = mColumns;
            int columnCount;
            columnCount = columns.length;
            HashMap<String, Integer> map;
            map = new HashMap<String, Integer>(columnCount, 1);
            {
                int i;
                i = 0;
                {
                    map.put(columns[i], i);
                } //End block
            } //End collapsed parenthetic
            mColumnNameMap = map;
        } //End block
        int periodIndex;
        periodIndex = columnName.lastIndexOf('.');
        {
            Exception e;
            e = new Exception();
            columnName = columnName.substring(periodIndex + 1);
        } //End block
        Integer i;
        i = mColumnNameMap.get(columnName);
        {
            int varFD096F7604415D4F8BC94DE088C66464_1996170645 = (i.intValue());
        } //End block
        addTaint(columnName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_979046738 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_979046738;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.699 -0400", hash_original_method = "6996FDAE7F544E3AE18BC0C5BC1EECAC", hash_generated_method = "64B0D8D4389CEB4E56D3C6AE63D4902F")
    @Override
    public String[] getColumnNames() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_702094173 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_702094173 = mColumns;
        varB4EAC82CA7396A68D541C85D26508E83_702094173.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_702094173;
        // ---------- Original Method ----------
        //return mColumns;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.700 -0400", hash_original_method = "9A966315BEEEC4FF7AE600084283702B", hash_generated_method = "AE3732AB3FDAA1667813E03081E0D43D")
    @Override
    public void deactivate() {
        super.deactivate();
        mDriver.cursorDeactivated();
        // ---------- Original Method ----------
        //super.deactivate();
        //mDriver.cursorDeactivated();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.720 -0400", hash_original_method = "448CAED0D85C68E057975FF7C64F6766", hash_generated_method = "F96B742494CD21F979DC2EF035C64825")
    @Override
    public void close() {
        super.close();
        {
            mQuery.close();
            mDriver.cursorClosed();
        } //End block
        // ---------- Original Method ----------
        //super.close();
        //synchronized (this) {
            //mQuery.close();
            //mDriver.cursorClosed();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.747 -0400", hash_original_method = "EB44A3C249AFFC8E58A7028D8F44463C", hash_generated_method = "F5C2431E795BB1338DFCEBD95886D3D4")
    @Override
    public boolean requery() {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_656427573 = (isClosed());
        } //End collapsed parenthetic
        long timeStart;
        timeStart = 0;
        {
            timeStart = System.currentTimeMillis();
        } //End block
        {
            {
                mWindow.clear();
            } //End block
            mPos = -1;
            SQLiteDatabase db;
            db = null;
            try 
            {
                db = mQuery.mDatabase.getDatabaseHandle(mQuery.mSql);
            } //End block
            catch (IllegalStateException e)
            { }
            {
                boolean varD1EFE84BAA87D6F9DEA8464BF23840BD_262265775 = (!db.equals(mQuery.mDatabase));
                {
                    try 
                    {
                        db.lock(mQuery.mSql);
                    } //End block
                    catch (IllegalStateException e)
                    { }
                    try 
                    {
                        mQuery.close();
                        mQuery = new SQLiteQuery(db, mQuery);
                    } //End block
                    catch (IllegalStateException e)
                    { }
                    finally 
                    {
                        db.unlock();
                    } //End block
                } //End block
            } //End collapsed parenthetic
            mDriver.cursorRequeried(this);
            mCount = NO_COUNT;
            try 
            {
                mQuery.requery();
            } //End block
            catch (IllegalStateException e)
            { }
        } //End block
        boolean result;
        result = false;
        try 
        {
            result = super.requery();
        } //End block
        catch (IllegalStateException e)
        { }
        {
            long timeEnd;
            timeEnd = System.currentTimeMillis();
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1945056101 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1945056101;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.752 -0400", hash_original_method = "5E8FFACADD72707A480415823E5A0DF8", hash_generated_method = "1345308ED4E30FABD6209237CE7EAF2D")
    @Override
    public void setWindow(CursorWindow window) {
        super.setWindow(window);
        mCount = NO_COUNT;
        addTaint(window.getTaint());
        // ---------- Original Method ----------
        //super.setWindow(window);
        //mCount = NO_COUNT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.752 -0400", hash_original_method = "F2A62A4628FC6852210F2ED0EED8C7EA", hash_generated_method = "4072DECACD10F43A8E56B36F3B3D68DE")
    public void setSelectionArguments(String[] selectionArgs) {
        mDriver.setBindArguments(selectionArgs);
        addTaint(selectionArgs[0].getTaint());
        // ---------- Original Method ----------
        //mDriver.setBindArguments(selectionArgs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.770 -0400", hash_original_method = "3B748B9308D21E215FBA6A9497941AC3", hash_generated_method = "975EDD961DC890D052DE381C64A99AE8")
    @Override
    protected void finalize() {
        try 
        {
            {
                {
                    int len;
                    len = mQuery.mSql.length();
                    StrictMode.onSqliteObjectLeaked(
                        "Finalizing a Cursor that has not been deactivated or closed. " +
                        "database = " + mQuery.mDatabase.getPath() + ", table = " + mEditTable +
                        ", query = " + mQuery.mSql.substring(0, (len > 1000) ? 1000 : len),
                        mStackTrace);
                } //End block
                close();
                SQLiteDebug.notifyActiveCursorFinalized();
            } //End block
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.771 -0400", hash_original_field = "834A112660C6E37DBC368D54B6CAFBE4", hash_generated_field = "C05D779C365B44403867608E8048ECC2")

    static String TAG = "SQLiteCursor";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.771 -0400", hash_original_field = "D08D7E472E5B15D94238F087A1FF491A", hash_generated_field = "2FA9EDF4F2AD0BE96432FA4706EC370D")

    static int NO_COUNT = -1;
}

