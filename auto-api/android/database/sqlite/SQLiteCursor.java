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
    private String mEditTable;
    private String[] mColumns;
    private SQLiteQuery mQuery;
    private SQLiteCursorDriver mDriver;
    private volatile int mCount = NO_COUNT;
    private Map<String, Integer> mColumnNameMap;
    private Throwable mStackTrace;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.306 -0400", hash_original_method = "7DD8316FC8BAC42467B622126F8A148B", hash_generated_method = "443D2A99FF42EBCF28DD095A3C8CE169")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public SQLiteCursor(SQLiteDatabase db, SQLiteCursorDriver driver,
            String editTable, SQLiteQuery query) {
        this(driver, editTable, query);
        dsTaint.addTaint(db.dsTaint);
        dsTaint.addTaint(query.dsTaint);
        dsTaint.addTaint(driver.dsTaint);
        dsTaint.addTaint(editTable);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.307 -0400", hash_original_method = "73EECE67D75C79AF0ED0AD77F55FFB21", hash_generated_method = "40B16FD0385734F170710A9A6388820E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SQLiteCursor(SQLiteCursorDriver driver, String editTable, SQLiteQuery query) {
        dsTaint.addTaint(query.dsTaint);
        dsTaint.addTaint(driver.dsTaint);
        dsTaint.addTaint(editTable);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("query object cannot be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("query.mDatabase cannot be null");
        } //End block
        {
            boolean varBD0BED841C7A62596CB2EE0AC9816352_1575129792 = (StrictMode.vmSqliteObjectLeaksEnabled());
            {
                mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
            } //End block
            {
                mStackTrace = null;
            } //End block
        } //End collapsed parenthetic
        mColumnNameMap = null;
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
                        boolean var6E699E5A2763233841B13F54819B19BC_1994671188 = ("_id".equals(columnName));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.307 -0400", hash_original_method = "AF759727D3C973E194D48B5E653874F6", hash_generated_method = "EC7EF15947DCEC10E35602557BC3B603")
    @DSModeled(DSC.SAFE)
    public SQLiteDatabase getDatabase() {
        return (SQLiteDatabase)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mQuery.mDatabase;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.308 -0400", hash_original_method = "B4A0D7606429FC274C47739DBFA1C1E0", hash_generated_method = "8841927BEF44CD22D97E8B21DA620015")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onMove(int oldPosition, int newPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newPosition);
        dsTaint.addTaint(oldPosition);
        {
            boolean varD2A5E171BD01B4A42E6C2327228CF01B_385592976 = (mWindow == null || newPosition < mWindow.getStartPosition() ||
                newPosition >= (mWindow.getStartPosition() + mWindow.getNumRows()));
            {
                fillWindow(newPosition);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mWindow == null || newPosition < mWindow.getStartPosition() ||
                //newPosition >= (mWindow.getStartPosition() + mWindow.getNumRows())) {
            //fillWindow(newPosition);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.308 -0400", hash_original_method = "D7810D185EEBB48990AE6D5077F6CEAD", hash_generated_method = "0A643A3E4CDF1AD3010EE258981ECFE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getCount() {
        {
            fillWindow(0);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mCount == NO_COUNT) {
            //fillWindow(0);
        //}
        //return mCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.308 -0400", hash_original_method = "1027AA1FD2FF7DB5721417BC40818677", hash_generated_method = "BB06769C9D4054D6298EE81A3ECF142F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void fillWindow(int startPos) {
        dsTaint.addTaint(startPos);
        clearOrCreateWindow(getDatabase().getPath());
        mWindow.setStartPosition(startPos);
        int count;
        count = getQuery().fillWindow(mWindow);
        {
            {
                boolean varF062350F2983BA11C030C10A71A73C26_27461741 = (Log.isLoggable(TAG, Log.DEBUG));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.308 -0400", hash_original_method = "976132A7E3467B4AD1CD095C1F4D25D0", hash_generated_method = "43987399F835841D2E45ADFCFA82B5A2")
    @DSModeled(DSC.SAFE)
    private synchronized SQLiteQuery getQuery() {
        return (SQLiteQuery)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mQuery;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.309 -0400", hash_original_method = "96C3F6AE90641303728CA2622AC00A1C", hash_generated_method = "5242F019B99E891CD654A845F2DC4141")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getColumnIndex(String columnName) {
        dsTaint.addTaint(columnName);
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
            int varFD096F7604415D4F8BC94DE088C66464_2111437554 = (i.intValue());
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.309 -0400", hash_original_method = "6996FDAE7F544E3AE18BC0C5BC1EECAC", hash_generated_method = "418AB809209F5691F671976F6DACB5FE")
    @DSModeled(DSC.SAFE)
    @Override
    public String[] getColumnNames() {
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return mColumns;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.309 -0400", hash_original_method = "9A966315BEEEC4FF7AE600084283702B", hash_generated_method = "AE3732AB3FDAA1667813E03081E0D43D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void deactivate() {
        super.deactivate();
        mDriver.cursorDeactivated();
        // ---------- Original Method ----------
        //super.deactivate();
        //mDriver.cursorDeactivated();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.310 -0400", hash_original_method = "448CAED0D85C68E057975FF7C64F6766", hash_generated_method = "F96B742494CD21F979DC2EF035C64825")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.310 -0400", hash_original_method = "EB44A3C249AFFC8E58A7028D8F44463C", hash_generated_method = "FB8FFD58875DCC29C9F0EEB288470B7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean requery() {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_1658555207 = (isClosed());
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
                boolean varD1EFE84BAA87D6F9DEA8464BF23840BD_1146251480 = (!db.equals(mQuery.mDatabase));
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.311 -0400", hash_original_method = "5E8FFACADD72707A480415823E5A0DF8", hash_generated_method = "FC60DCEE2F5B8980CE7C4C87DCE947CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setWindow(CursorWindow window) {
        dsTaint.addTaint(window.dsTaint);
        super.setWindow(window);
        mCount = NO_COUNT;
        // ---------- Original Method ----------
        //super.setWindow(window);
        //mCount = NO_COUNT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.315 -0400", hash_original_method = "F2A62A4628FC6852210F2ED0EED8C7EA", hash_generated_method = "A3B98191E159EA00C4490F66B4D0A5A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSelectionArguments(String[] selectionArgs) {
        dsTaint.addTaint(selectionArgs[0]);
        mDriver.setBindArguments(selectionArgs);
        // ---------- Original Method ----------
        //mDriver.setBindArguments(selectionArgs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.316 -0400", hash_original_method = "3B748B9308D21E215FBA6A9497941AC3", hash_generated_method = "975EDD961DC890D052DE381C64A99AE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    static final String TAG = "SQLiteCursor";
    static final int NO_COUNT = -1;
}

