package android.database.sqlite;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.Map;

import android.database.AbstractWindowedCursor;
import android.database.CursorWindow;
import android.os.StrictMode;
import android.util.Log;





public class SQLiteCursor extends AbstractWindowedCursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.298 -0400", hash_original_field = "03938FDF3029AF609FD8FCBAEE02B61F", hash_generated_field = "973CDCF4620458EDC8DC04989EC9D73D")

    private String mEditTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.298 -0400", hash_original_field = "11C985F30142FD30ACDDFE7CD3BD4A9B", hash_generated_field = "53DC72E56AF72859CCB6315DB649FC3E")

    private String[] mColumns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.298 -0400", hash_original_field = "5B134E4A2754549415570918F1EB845F", hash_generated_field = "8A548C5C667EE7DF7972E25F8E1FD3F8")

    private SQLiteQuery mQuery;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.298 -0400", hash_original_field = "AC9FCB6C9481ACE03DAC8C5318667F64", hash_generated_field = "DF56BAF171B937E9CC6E593202E96226")

    private SQLiteCursorDriver mDriver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.298 -0400", hash_original_field = "EBFB1F1A33D1A84D7D0E8E8AF5105388", hash_generated_field = "F4532CB59B1200B34E9685596B8185FB")

    private volatile int mCount = NO_COUNT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.298 -0400", hash_original_field = "BF35522FC5AD02023860C40C8D630EAE", hash_generated_field = "5E829DFAED9C527F2433E5889E542D7A")

    private Map<String, Integer> mColumnNameMap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.298 -0400", hash_original_field = "9581B90EA40AE59A20069CB826265080", hash_generated_field = "7D1AA4359A52B133BFAD994AB60E8C14")

    private Throwable mStackTrace;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.299 -0400", hash_original_method = "7DD8316FC8BAC42467B622126F8A148B", hash_generated_method = "C75A2663D49A065F3B7387A587A0CD39")
    @Deprecated
    public  SQLiteCursor(SQLiteDatabase db, SQLiteCursorDriver driver,
            String editTable, SQLiteQuery query) {
        this(driver, editTable, query);
        addTaint(query.getTaint());
        addTaint(editTable.getTaint());
        addTaint(driver.getTaint());
        addTaint(db.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.302 -0400", hash_original_method = "73EECE67D75C79AF0ED0AD77F55FFB21", hash_generated_method = "819342AB1150F05CA9FF27F6DB10D9E2")
    public  SQLiteCursor(SQLiteCursorDriver driver, String editTable, SQLiteQuery query) {
        if(query == null)        
        {
            IllegalArgumentException var4DCD1112209C612D190CEBACFFC334B6_1289509996 = new IllegalArgumentException("query object cannot be null");
            var4DCD1112209C612D190CEBACFFC334B6_1289509996.addTaint(taint);
            throw var4DCD1112209C612D190CEBACFFC334B6_1289509996;
        } //End block
        if(query.mDatabase == null)        
        {
            IllegalArgumentException var7217DF37FE0EF7B4F0A13015568C047C_1360675229 = new IllegalArgumentException("query.mDatabase cannot be null");
            var7217DF37FE0EF7B4F0A13015568C047C_1360675229.addTaint(taint);
            throw var7217DF37FE0EF7B4F0A13015568C047C_1360675229;
        } //End block
        if(StrictMode.vmSqliteObjectLeaksEnabled())        
        {
            mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
        } //End block
        else
        {
            mStackTrace = null;
        } //End block
        mDriver = driver;
        mEditTable = editTable;
        mColumnNameMap = null;
        mQuery = query;
        query.mDatabase.lock(query.mSql);
        try 
        {
            int columnCount = mQuery.columnCountLocked();
            mColumns = new String[columnCount];
for(int i = 0;i < columnCount;i++)
            {
                String columnName = mQuery.columnNameLocked(i);
                mColumns[i] = columnName;
                if(false)                
                {
                } //End block
                if("_id".equals(columnName))                
                {
                    mRowIdColumnIndex = i;
                } //End block
            } //End block
        } //End block
        finally 
        {
            query.mDatabase.unlock();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.304 -0400", hash_original_method = "AF759727D3C973E194D48B5E653874F6", hash_generated_method = "48C2804802E482DB7FB68B8B2A51C5C7")
    public SQLiteDatabase getDatabase() {
        synchronized
(this)        {
SQLiteDatabase var74EF8627A8500A3E2D87BFD62025CE19_1542224551 =             mQuery.mDatabase;
            var74EF8627A8500A3E2D87BFD62025CE19_1542224551.addTaint(taint);
            return var74EF8627A8500A3E2D87BFD62025CE19_1542224551;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //return mQuery.mDatabase;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.305 -0400", hash_original_method = "B4A0D7606429FC274C47739DBFA1C1E0", hash_generated_method = "00D4CDECC411A6C7E745C7842F82712A")
    @Override
    public boolean onMove(int oldPosition, int newPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newPosition);
        addTaint(oldPosition);
        if(mWindow == null || newPosition < mWindow.getStartPosition() ||
                newPosition >= (mWindow.getStartPosition() + mWindow.getNumRows()))        
        {
            fillWindow(newPosition);
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1622486065 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_57853855 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_57853855;
        // ---------- Original Method ----------
        //if (mWindow == null || newPosition < mWindow.getStartPosition() ||
                //newPosition >= (mWindow.getStartPosition() + mWindow.getNumRows())) {
            //fillWindow(newPosition);
        //}
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.306 -0400", hash_original_method = "D7810D185EEBB48990AE6D5077F6CEAD", hash_generated_method = "2D8118D7D1C87FCBF9148DDEC02FAEDE")
    @Override
    public int getCount() {
        if(mCount == NO_COUNT)        
        {
            fillWindow(0);
        } //End block
        int var4A5FC91463CC1EF00D3AA26340B946C6_1337155326 = (mCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2037592851 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2037592851;
        // ---------- Original Method ----------
        //if (mCount == NO_COUNT) {
            //fillWindow(0);
        //}
        //return mCount;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.307 -0400", hash_original_method = "1027AA1FD2FF7DB5721417BC40818677", hash_generated_method = "EE80B7B477FE0D6A4A491DCD70263CE7")
    private void fillWindow(int startPos) {
        addTaint(startPos);
        clearOrCreateWindow(getDatabase().getPath());
        mWindow.setStartPosition(startPos);
        int count = getQuery().fillWindow(mWindow);
        if(startPos == 0)        
        {
            if(Log.isLoggable(TAG, Log.DEBUG))            
            {
                Log.d(TAG, "received count(*) from native_fill_window: " + count);
            } //End block
            mCount = count;
        } //End block
        else
        if(mCount <= 0)        
        {
            IllegalStateException var0CC1C6D0B17DF0CAC4CA7F5C03B3AB88_1427786209 = new IllegalStateException("Row count should never be zero or negative "
                    + "when the start position is non-zero");
            var0CC1C6D0B17DF0CAC4CA7F5C03B3AB88_1427786209.addTaint(taint);
            throw var0CC1C6D0B17DF0CAC4CA7F5C03B3AB88_1427786209;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.308 -0400", hash_original_method = "976132A7E3467B4AD1CD095C1F4D25D0", hash_generated_method = "E1548F201A68F242417EEFBA2D3DDC14")
    private synchronized SQLiteQuery getQuery() {
SQLiteQuery varC104E74F3085CDE7E6D7F4CAA0F9BCA1_1727408861 =         mQuery;
        varC104E74F3085CDE7E6D7F4CAA0F9BCA1_1727408861.addTaint(taint);
        return varC104E74F3085CDE7E6D7F4CAA0F9BCA1_1727408861;
        // ---------- Original Method ----------
        //return mQuery;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.311 -0400", hash_original_method = "96C3F6AE90641303728CA2622AC00A1C", hash_generated_method = "6EBF76DA199327E56D932617C4914243")
    @Override
    public int getColumnIndex(String columnName) {
        addTaint(columnName.getTaint());
        if(mColumnNameMap == null)        
        {
            String[] columns = mColumns;
            int columnCount = columns.length;
            HashMap<String, Integer> map = new HashMap<String, Integer>(columnCount, 1);
for(int i = 0;i < columnCount;i++)
            {
                map.put(columns[i], i);
            } //End block
            mColumnNameMap = map;
        } //End block
        final int periodIndex = columnName.lastIndexOf('.');
        if(periodIndex != -1)        
        {
            Exception e = new Exception();
            columnName = columnName.substring(periodIndex + 1);
        } //End block
        Integer i = mColumnNameMap.get(columnName);
        if(i != null)        
        {
            int varF877893BFF35C97E4E3D5D01360AF179_2072043722 = (i.intValue());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_315062637 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_315062637;
        } //End block
        else
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_2099766323 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1574121208 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1574121208;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.312 -0400", hash_original_method = "6996FDAE7F544E3AE18BC0C5BC1EECAC", hash_generated_method = "7054549E38130F1C42717BB0BCB5D9EE")
    @Override
    public String[] getColumnNames() {
String[] varD3E6185118B69354C5CA1E2493E0C19D_2011788089 =         mColumns;
        varD3E6185118B69354C5CA1E2493E0C19D_2011788089.addTaint(taint);
        return varD3E6185118B69354C5CA1E2493E0C19D_2011788089;
        // ---------- Original Method ----------
        //return mColumns;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.312 -0400", hash_original_method = "9A966315BEEEC4FF7AE600084283702B", hash_generated_method = "AE3732AB3FDAA1667813E03081E0D43D")
    @Override
    public void deactivate() {
        super.deactivate();
        mDriver.cursorDeactivated();
        // ---------- Original Method ----------
        //super.deactivate();
        //mDriver.cursorDeactivated();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.313 -0400", hash_original_method = "448CAED0D85C68E057975FF7C64F6766", hash_generated_method = "F952F3C03ADB6ED50FD0A82E13FE1446")
    @Override
    public void close() {
        super.close();
        synchronized
(this)        {
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.315 -0400", hash_original_method = "EB44A3C249AFFC8E58A7028D8F44463C", hash_generated_method = "93CA8F0576B479C26A07BE5A5E068B0A")
    @Override
    public boolean requery() {
        if(isClosed())        
        {
            boolean var68934A3E9455FA72420237EB05902327_558533347 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1042367666 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1042367666;
        } //End block
        long timeStart = 0;
        if(false)        
        {
            timeStart = System.currentTimeMillis();
        } //End block
        synchronized
(this)        {
            if(mWindow != null)            
            {
                mWindow.clear();
            } //End block
            mPos = -1;
            SQLiteDatabase db = null;
            try 
            {
                db = mQuery.mDatabase.getDatabaseHandle(mQuery.mSql);
            } //End block
            catch (IllegalStateException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_465181146 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_408124506 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_408124506;
            } //End block
            if(!db.equals(mQuery.mDatabase))            
            {
                try 
                {
                    db.lock(mQuery.mSql);
                } //End block
                catch (IllegalStateException e)
                {
                    boolean var68934A3E9455FA72420237EB05902327_1728775178 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_840363806 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_840363806;
                } //End block
                try 
                {
                    mQuery.close();
                    mQuery = new SQLiteQuery(db, mQuery);
                } //End block
                catch (IllegalStateException e)
                {
                    boolean var68934A3E9455FA72420237EB05902327_1927444687 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1771424665 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1771424665;
                } //End block
                finally 
                {
                    db.unlock();
                } //End block
            } //End block
            mDriver.cursorRequeried(this);
            mCount = NO_COUNT;
            try 
            {
                mQuery.requery();
            } //End block
            catch (IllegalStateException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_716084983 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_330367574 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_330367574;
            } //End block
        } //End block
        if(false)        
        {
        } //End block
        boolean result = false;
        try 
        {
            result = super.requery();
        } //End block
        catch (IllegalStateException e)
        {
        } //End block
        if(false)        
        {
            long timeEnd = System.currentTimeMillis();
        } //End block
        boolean varB4A88417B3D0170D754C647C30B7216A_969192536 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1390509898 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1390509898;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.317 -0400", hash_original_method = "5E8FFACADD72707A480415823E5A0DF8", hash_generated_method = "55E172B19852D8E53CE8FA49AF1AF62F")
    @Override
    public void setWindow(CursorWindow window) {
        addTaint(window.getTaint());
        super.setWindow(window);
        mCount = NO_COUNT;
        // ---------- Original Method ----------
        //super.setWindow(window);
        //mCount = NO_COUNT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.317 -0400", hash_original_method = "F2A62A4628FC6852210F2ED0EED8C7EA", hash_generated_method = "27E93214406A5C62EADFC5EACF78EECA")
    public void setSelectionArguments(String[] selectionArgs) {
        addTaint(selectionArgs[0].getTaint());
        mDriver.setBindArguments(selectionArgs);
        // ---------- Original Method ----------
        //mDriver.setBindArguments(selectionArgs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.319 -0400", hash_original_method = "3B748B9308D21E215FBA6A9497941AC3", hash_generated_method = "F7AB92730F29B27F883A76E20B20D2DA")
    @Override
    protected void finalize() {
        try 
        {
            if(mWindow != null)            
            {
                if(mStackTrace != null)                
                {
                    int len = mQuery.mSql.length();
                    StrictMode.onSqliteObjectLeaked(
                        "Finalizing a Cursor that has not been deactivated or closed. " +
                        "database = " + mQuery.mDatabase.getPath() + ", table = " + mEditTable +
                        ", query = " + mQuery.mSql.substring(0, (len > 1000) ? 1000 : len),
                        mStackTrace);
                } //End block
                close();
                SQLiteDebug.notifyActiveCursorFinalized();
            } //End block
            else
            {
                if(false)                
                {
                } //End block
            } //End block
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.319 -0400", hash_original_field = "834A112660C6E37DBC368D54B6CAFBE4", hash_generated_field = "BF7B5B2F2106B38369133C49B98E70AF")

    static final String TAG = "SQLiteCursor";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.319 -0400", hash_original_field = "D08D7E472E5B15D94238F087A1FF491A", hash_generated_field = "B3506D48E898548A190C450C174C3FFA")

    static final int NO_COUNT = -1;
}

