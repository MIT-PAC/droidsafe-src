package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.database.DatabaseUtils;
import android.database.Cursor;
import java.util.HashMap;

public abstract class SQLiteProgram extends SQLiteClosable {
    private static final String TAG = "SQLiteProgram";
    @Deprecated
    protected SQLiteDatabase mDatabase;
    final String mSql;
    @Deprecated
    protected int nHandle;
    SQLiteCompiledSql mCompiledSql;
    @Deprecated
    protected int nStatement;
    HashMap<Integer, Object> mBindArgs = null;
    final int mStatementType;
    static final int STATEMENT_CACHEABLE = 16;
    static final int STATEMENT_DONT_PREPARE = 32;
    static final int STATEMENT_USE_POOLED_CONN = 64;
    static final int STATEMENT_TYPE_MASK = 0x0f;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.829 -0400", hash_original_method = "7775AC6B878F6A87A2372052B1B0D459", hash_generated_method = "CB12E134B8D3596B8EECB67D38B838BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SQLiteProgram(SQLiteDatabase db, String sql) {
        this(db, sql, null, true);
        dsTaint.addTaint(db.dsTaint);
        dsTaint.addTaint(sql);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.829 -0400", hash_original_method = "DADBFC98E2D0F265D4B5A43330A492E4", hash_generated_method = "2E856D5BCB34FD561B231202716DC8AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SQLiteProgram(SQLiteDatabase db, String sql, Object[] bindArgs,
            boolean compileFlag) {
        dsTaint.addTaint(db.dsTaint);
        dsTaint.addTaint(sql);
        dsTaint.addTaint(bindArgs.dsTaint);
        dsTaint.addTaint(compileFlag);
        mSql = sql.trim();
        int n;
        n = DatabaseUtils.getSqlStatementType(mSql);
        //Begin case DatabaseUtils.STATEMENT_UPDATE 
        mStatementType = n | STATEMENT_CACHEABLE;
        //End case DatabaseUtils.STATEMENT_UPDATE 
        //Begin case DatabaseUtils.STATEMENT_SELECT 
        mStatementType = n | STATEMENT_CACHEABLE | STATEMENT_USE_POOLED_CONN;
        //End case DatabaseUtils.STATEMENT_SELECT 
        //Begin case DatabaseUtils.STATEMENT_BEGIN DatabaseUtils.STATEMENT_COMMIT DatabaseUtils.STATEMENT_ABORT 
        mStatementType = n | STATEMENT_DONT_PREPARE;
        //End case DatabaseUtils.STATEMENT_BEGIN DatabaseUtils.STATEMENT_COMMIT DatabaseUtils.STATEMENT_ABORT 
        //Begin case default 
        mStatementType = n;
        //End case default 
        db.acquireReference();
        db.addSQLiteClosable(this);
        nHandle = db.mNativeHandle;
        {
            int size;
            size = bindArgs.length;
            {
                int i;
                i = 0;
                {
                    this.addToBindArgs(i + 1, bindArgs[i]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            compileAndbindAllArgs();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.829 -0400", hash_original_method = "EE8899F672BCD12A22959F518D1125AF", hash_generated_method = "073F2C86F5EC2DA5E62D0135DB58C349")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void compileSql() {
        {
            mCompiledSql = new SQLiteCompiledSql(mDatabase, mSql);
            nStatement = mCompiledSql.nStatement;
        } //End block
        mCompiledSql = mDatabase.getCompiledStatementForSql(mSql);
        {
            mCompiledSql = new SQLiteCompiledSql(mDatabase, mSql);
            mCompiledSql.acquire();
            mDatabase.addToCompiledQueries(mSql, mCompiledSql);
        } //End block
        {
            {
                boolean var67BB5573694D5AAA2A946CFD3319B64C_281120496 = (!mCompiledSql.acquire());
                {
                    int last;
                    last = mCompiledSql.nStatement;
                    mCompiledSql = new SQLiteCompiledSql(mDatabase, mSql);
                } //End block
            } //End collapsed parenthetic
        } //End block
        nStatement = mCompiledSql.nStatement;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.830 -0400", hash_original_method = "300DFE9F6A4C69242F1C212512462325", hash_generated_method = "033615FB086DD51CB0222D6A199ADC0A")
    @DSModeled(DSC.SAFE)
    @Override
    protected void onAllReferencesReleased() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        release();
        mDatabase.removeSQLiteClosable(this);
        mDatabase.releaseReference();
        // ---------- Original Method ----------
        //release();
        //mDatabase.removeSQLiteClosable(this);
        //mDatabase.releaseReference();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.830 -0400", hash_original_method = "A968FD9C775F09F9345F28805B1169A5", hash_generated_method = "45BDAE0173C585E9B1B8B2BE8C57388C")
    @DSModeled(DSC.SAFE)
    @Override
    protected void onAllReferencesReleasedFromContainer() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        release();
        mDatabase.releaseReference();
        // ---------- Original Method ----------
        //release();
        //mDatabase.releaseReference();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.830 -0400", hash_original_method = "A1FA2CE0BFABB0D7A31C7494B049120F", hash_generated_method = "FCFDB2FA58D40E69F309888BF8BE0AF3")
    @DSModeled(DSC.SAFE)
     void release() {
        mDatabase.releaseCompiledSqlObj(mSql, mCompiledSql);
        mCompiledSql = null;
        nStatement = 0;
        // ---------- Original Method ----------
        //if (mCompiledSql == null) {
            //return;
        //}
        //mDatabase.releaseCompiledSqlObj(mSql, mCompiledSql);
        //mCompiledSql = null;
        //nStatement = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.830 -0400", hash_original_method = "E07CAA4B1BF262B61B70604363CAC3E9", hash_generated_method = "5DDABDEACFA25B132EC276E23D6B722D")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public final int getUniqueId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.831 -0400", hash_original_method = "76820A9DAA0EF4EAA60C4E690E9DF41D", hash_generated_method = "C7F2B6B27F9364C90F363AD0969FA73E")
    @DSModeled(DSC.SAFE)
     int getSqlStatementId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized(this) {
        //return (mCompiledSql == null) ? 0 : nStatement;
      //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.831 -0400", hash_original_method = "D92A66541C65863AB0B524498A872E5D", hash_generated_method = "8FD2D37DA8C2139489C02B389797756A")
    @DSModeled(DSC.SAFE)
     String getSqlString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSql;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.831 -0400", hash_original_method = "B49B29A59D94DA04C289B1136BB98967", hash_generated_method = "AAF61A7F86E6DF337C77AC9C75229B2F")
    @DSModeled(DSC.SAFE)
    @Deprecated
    protected void compile(String sql, boolean forceCompilation) {
        dsTaint.addTaint(sql);
        dsTaint.addTaint(forceCompilation);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.831 -0400", hash_original_method = "7AFA2099A2DCB432F4822D315BB6A2D0", hash_generated_method = "EEF03500894309A28582A083B0E43C01")
    @DSModeled(DSC.SAFE)
    private void bind(int type, int index, Object value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(type);
        mDatabase.verifyDbIsOpen();
        addToBindArgs(index, (type == Cursor.FIELD_TYPE_NULL) ? null : value);
        {
            acquireReference();
            try 
            {
                //Begin case Cursor.FIELD_TYPE_NULL 
                native_bind_null(index);
                //End case Cursor.FIELD_TYPE_NULL 
                //Begin case Cursor.FIELD_TYPE_BLOB 
                native_bind_blob(index, (byte[]) value);
                //End case Cursor.FIELD_TYPE_BLOB 
                //Begin case Cursor.FIELD_TYPE_FLOAT 
                native_bind_double(index, (Double) value);
                //End case Cursor.FIELD_TYPE_FLOAT 
                //Begin case Cursor.FIELD_TYPE_INTEGER 
                native_bind_long(index, (Long) value);
                //End case Cursor.FIELD_TYPE_INTEGER 
                //Begin case Cursor.FIELD_TYPE_STRING default 
                native_bind_string(index, (String) value);
                //End case Cursor.FIELD_TYPE_STRING default 
            } //End block
            finally 
            {
                releaseReference();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.831 -0400", hash_original_method = "3480FC3F53F060D0AF87F13A57EE020E", hash_generated_method = "C88583D14D2D64739D22EEEBB4969191")
    @DSModeled(DSC.SAFE)
    public void bindNull(int index) {
        dsTaint.addTaint(index);
        bind(Cursor.FIELD_TYPE_NULL, index, null);
        // ---------- Original Method ----------
        //bind(Cursor.FIELD_TYPE_NULL, index, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.832 -0400", hash_original_method = "DDFF1311EF84C79E9F0283B8959C214A", hash_generated_method = "B4A95444ECC818327931D7460171010E")
    @DSModeled(DSC.SAFE)
    public void bindLong(int index, long value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        bind(Cursor.FIELD_TYPE_INTEGER, index, value);
        // ---------- Original Method ----------
        //bind(Cursor.FIELD_TYPE_INTEGER, index, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.832 -0400", hash_original_method = "D271F20EDF0F2BB1E84FEE6A8DFAF59F", hash_generated_method = "572B11ED62E3104E0DB1A49430A56663")
    @DSModeled(DSC.SAFE)
    public void bindDouble(int index, double value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        bind(Cursor.FIELD_TYPE_FLOAT, index, value);
        // ---------- Original Method ----------
        //bind(Cursor.FIELD_TYPE_FLOAT, index, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.832 -0400", hash_original_method = "963A4C4D7269247053E24419DAA13FC1", hash_generated_method = "04A03278E48F8D937DF1F6239B842AFE")
    @DSModeled(DSC.SAFE)
    public void bindString(int index, String value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        {
            throw new IllegalArgumentException("the bind value at index " + index + " is null");
        } //End block
        bind(Cursor.FIELD_TYPE_STRING, index, value);
        // ---------- Original Method ----------
        //if (value == null) {
            //throw new IllegalArgumentException("the bind value at index " + index + " is null");
        //}
        //bind(Cursor.FIELD_TYPE_STRING, index, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.832 -0400", hash_original_method = "C702C9CEB9955A1F1B2C6A119BC67F74", hash_generated_method = "212C112A50ABCEEFB347A75A7BBFC435")
    @DSModeled(DSC.SAFE)
    public void bindBlob(int index, byte[] value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        {
            throw new IllegalArgumentException("the bind value at index " + index + " is null");
        } //End block
        bind(Cursor.FIELD_TYPE_BLOB, index, value);
        // ---------- Original Method ----------
        //if (value == null) {
            //throw new IllegalArgumentException("the bind value at index " + index + " is null");
        //}
        //bind(Cursor.FIELD_TYPE_BLOB, index, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.832 -0400", hash_original_method = "A82C4E1E74B388EF1F68336E0B7074B9", hash_generated_method = "CAEA9FBD0F430F649F71F7A7747370FD")
    @DSModeled(DSC.SAFE)
    public void clearBindings() {
        mBindArgs = null;
        mDatabase.verifyDbIsOpen();
        acquireReference();
        try 
        {
            native_clear_bindings();
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        // ---------- Original Method ----------
        //mBindArgs = null;
        //if (this.nStatement == 0) {
            //return;
        //}
        //mDatabase.verifyDbIsOpen();
        //acquireReference();
        //try {
            //native_clear_bindings();
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.832 -0400", hash_original_method = "D3AE998E3454F9C657DFB347B01A5D33", hash_generated_method = "4799EB30F7505D92AC36B9D0563DF267")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() {
        mBindArgs = null;
        {
            boolean varDE68D5CB54419BE6A192FC7E85769926_1799871682 = (nHandle == 0 || !mDatabase.isOpen());
        } //End collapsed parenthetic
        releaseReference();
        // ---------- Original Method ----------
        //mBindArgs = null;
        //if (nHandle == 0 || !mDatabase.isOpen()) {
            //return;
        //}
        //releaseReference();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.833 -0400", hash_original_method = "8DD7248015BFD919A162C74D92E1DB42", hash_generated_method = "0E0D041396A92EB31C3DF5E07E2A8EF9")
    @DSModeled(DSC.SAFE)
    private void addToBindArgs(int index, Object value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value.dsTaint);
        {
            mBindArgs = new HashMap<Integer, Object>();
        } //End block
        mBindArgs.put(index, value);
        // ---------- Original Method ----------
        //if (mBindArgs == null) {
            //mBindArgs = new HashMap<Integer, Object>();
        //}
        //mBindArgs.put(index, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.833 -0400", hash_original_method = "3FC7B6EE26A3C940A3FAD2B270073635", hash_generated_method = "1F9C4487B48B467D61DA0C462B11B5E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void compileAndbindAllArgs() {
        {
            {
                throw new IllegalArgumentException("Can't pass bindargs for this sql :" + mSql);
            } //End block
        } //End block
        {
            compileSql();
        } //End block
        {
            Iterator<int> seatecAstronomy42 = mBindArgs.keySet().iterator();
            seatecAstronomy42.hasNext();
            int index = seatecAstronomy42.next();
            {
                Object value;
                value = mBindArgs.get(index);
                {
                    native_bind_null(index);
                } //End block
                {
                    native_bind_double(index, ((Number) value).doubleValue());
                } //End block
                {
                    native_bind_long(index, ((Number) value).longValue());
                } //End block
                {
                    Boolean bool;
                    bool = (Boolean)value;
                    native_bind_long(index, (bool) ? 1 : 0);
                    {
                        native_bind_long(index, 1);
                    } //End block
                    {
                        native_bind_long(index, 0);
                    } //End block
                } //End block
                {
                    native_bind_blob(index, (byte[]) value);
                } //End block
                {
                    native_bind_string(index, value.toString());
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.833 -0400", hash_original_method = "7568906165FD370FD5C4296CB4D5FD76", hash_generated_method = "C8B69FCA1F68BA4BD3138CA0B8257FBF")
    @DSModeled(DSC.SAFE)
    public void bindAllArgsAsStrings(String[] bindArgs) {
        dsTaint.addTaint(bindArgs);
        int size;
        size = bindArgs.length;
        {
            int i;
            i = 0;
            {
                bindString(i + 1, bindArgs[i]);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (bindArgs == null) {
            //return;
        //}
        //int size = bindArgs.length;
        //for (int i = 0; i < size; i++) {
            //bindString(i + 1, bindArgs[i]);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.833 -0400", hash_original_method = "B3D61FB7C94FF71F95332257D7EBBE92", hash_generated_method = "93BF7630E636C22BB3575C74810B70F9")
    @DSModeled(DSC.SAFE)
    synchronized final void setNativeHandle(int nHandle) {
        dsTaint.addTaint(nHandle);
        // ---------- Original Method ----------
        //this.nHandle = nHandle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.834 -0400", hash_original_method = "957AE60D3A9CE570CB89C0AA6C75F6C8", hash_generated_method = "DB053FFB37D2D889F4FB19FD7A0FA521")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    protected final void native_compile(String sql) {
        dsTaint.addTaint(sql);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.834 -0400", hash_original_method = "B81676966F6941B90240D7A24C9E2FD3", hash_generated_method = "F6826D2D40C6E5F64450106D263BD66E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    protected final void native_finalize() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.834 -0400", hash_original_method = "AB3FC56412EB6E1517BB8960DA14A39F", hash_generated_method = "288DCBFA3B8FEB66ACAEFB1299EE51FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void native_bind_null(int index) {
        dsTaint.addTaint(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.834 -0400", hash_original_method = "788CE16CEC77E5835CEB80FC75E60641", hash_generated_method = "E18800A038B1C5AD9C6EDAA868A7E9E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void native_bind_long(int index, long value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.834 -0400", hash_original_method = "DDD8FE0B3144B1C9C0B95003A2ADAE8F", hash_generated_method = "9AC9416C9F359CF0083898DCF18EED1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void native_bind_double(int index, double value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.834 -0400", hash_original_method = "6D9E58383F5E5E78735F2725B3EB1959", hash_generated_method = "BC30B54723FDEDB2142402D519A4CAD1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void native_bind_string(int index, String value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.834 -0400", hash_original_method = "283C3F08E27A848CC26557756DCA3292", hash_generated_method = "A11E4D1B4EBB1DE18C89BBA38A2C6F9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void native_bind_blob(int index, byte[] value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.834 -0400", hash_original_method = "A7443022DB1A1E9003E4973C3792843C", hash_generated_method = "10A1C33678A44A2D231FEB4F873E3CDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void native_clear_bindings() {
    }

    
}


