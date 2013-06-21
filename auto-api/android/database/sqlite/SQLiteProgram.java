package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.database.DatabaseUtils;
import android.database.Cursor;
import java.util.HashMap;

public abstract class SQLiteProgram extends SQLiteClosable {
    @Deprecated protected SQLiteDatabase mDatabase;
    String mSql;
    @Deprecated protected int nHandle;
    SQLiteCompiledSql mCompiledSql;
    @Deprecated protected int nStatement;
    HashMap<Integer, Object> mBindArgs = null;
    int mStatementType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.718 -0400", hash_original_method = "7775AC6B878F6A87A2372052B1B0D459", hash_generated_method = "EF4A0D6DE2718A192E35965088CC1CFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SQLiteProgram(SQLiteDatabase db, String sql) {
        this(db, sql, null, true);
        dsTaint.addTaint(db.dsTaint);
        dsTaint.addTaint(sql);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.719 -0400", hash_original_method = "DADBFC98E2D0F265D4B5A43330A492E4", hash_generated_method = "B444D67D770CD2273568700F348537D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SQLiteProgram(SQLiteDatabase db, String sql, Object[] bindArgs,
            boolean compileFlag) {
        dsTaint.addTaint(db.dsTaint);
        dsTaint.addTaint(compileFlag);
        dsTaint.addTaint(bindArgs[0].dsTaint);
        dsTaint.addTaint(sql);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.731 -0400", hash_original_method = "EE8899F672BCD12A22959F518D1125AF", hash_generated_method = "ED3E692B587C44858EB8C077086ABED1")
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
                boolean var67BB5573694D5AAA2A946CFD3319B64C_1820685668 = (!mCompiledSql.acquire());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.732 -0400", hash_original_method = "300DFE9F6A4C69242F1C212512462325", hash_generated_method = "1CD0B8729AFD456C5EE63418C49A729F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.732 -0400", hash_original_method = "A968FD9C775F09F9345F28805B1169A5", hash_generated_method = "431B9CF113097FF3B598F21FC4A441C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onAllReferencesReleasedFromContainer() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        release();
        mDatabase.releaseReference();
        // ---------- Original Method ----------
        //release();
        //mDatabase.releaseReference();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.732 -0400", hash_original_method = "A1FA2CE0BFABB0D7A31C7494B049120F", hash_generated_method = "AEF4847162FF006ACE039D37EC0210A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.732 -0400", hash_original_method = "E07CAA4B1BF262B61B70604363CAC3E9", hash_generated_method = "552234F2842FC25A498BE02822AD65D8")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public final int getUniqueId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.733 -0400", hash_original_method = "76820A9DAA0EF4EAA60C4E690E9DF41D", hash_generated_method = "7DB64BC2D14E352011A8E60DF53FC45A")
    @DSModeled(DSC.SAFE)
     int getSqlStatementId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized(this) {
        //return (mCompiledSql == null) ? 0 : nStatement;
      //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.733 -0400", hash_original_method = "D92A66541C65863AB0B524498A872E5D", hash_generated_method = "0A70B32242BBD294245A3BBF4077250E")
    @DSModeled(DSC.SAFE)
     String getSqlString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSql;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.733 -0400", hash_original_method = "B49B29A59D94DA04C289B1136BB98967", hash_generated_method = "D052164B8AEA0C68F911CEB7235A74B6")
    @DSModeled(DSC.SAFE)
    @Deprecated
    protected void compile(String sql, boolean forceCompilation) {
        dsTaint.addTaint(sql);
        dsTaint.addTaint(forceCompilation);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.734 -0400", hash_original_method = "7AFA2099A2DCB432F4822D315BB6A2D0", hash_generated_method = "B88E540DF8699B5C37D6C5ACCBB60CFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.734 -0400", hash_original_method = "3480FC3F53F060D0AF87F13A57EE020E", hash_generated_method = "467F16BA1F0220954087AAD9980A1792")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void bindNull(int index) {
        dsTaint.addTaint(index);
        bind(Cursor.FIELD_TYPE_NULL, index, null);
        // ---------- Original Method ----------
        //bind(Cursor.FIELD_TYPE_NULL, index, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.734 -0400", hash_original_method = "DDFF1311EF84C79E9F0283B8959C214A", hash_generated_method = "8A31E4BAE1E4F3BAC5747506D45A93D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void bindLong(int index, long value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        bind(Cursor.FIELD_TYPE_INTEGER, index, value);
        // ---------- Original Method ----------
        //bind(Cursor.FIELD_TYPE_INTEGER, index, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.735 -0400", hash_original_method = "D271F20EDF0F2BB1E84FEE6A8DFAF59F", hash_generated_method = "6519FE99B22E3F42F4C00A3851E46FC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void bindDouble(int index, double value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        bind(Cursor.FIELD_TYPE_FLOAT, index, value);
        // ---------- Original Method ----------
        //bind(Cursor.FIELD_TYPE_FLOAT, index, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.736 -0400", hash_original_method = "963A4C4D7269247053E24419DAA13FC1", hash_generated_method = "22AE06C029DC007D863F70F41C4725C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void bindString(int index, String value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the bind value at index " + index + " is null");
        } //End block
        bind(Cursor.FIELD_TYPE_STRING, index, value);
        // ---------- Original Method ----------
        //if (value == null) {
            //throw new IllegalArgumentException("the bind value at index " + index + " is null");
        //}
        //bind(Cursor.FIELD_TYPE_STRING, index, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.737 -0400", hash_original_method = "C702C9CEB9955A1F1B2C6A119BC67F74", hash_generated_method = "4198FB4945D7FCC265811266F9776664")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void bindBlob(int index, byte[] value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the bind value at index " + index + " is null");
        } //End block
        bind(Cursor.FIELD_TYPE_BLOB, index, value);
        // ---------- Original Method ----------
        //if (value == null) {
            //throw new IllegalArgumentException("the bind value at index " + index + " is null");
        //}
        //bind(Cursor.FIELD_TYPE_BLOB, index, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.737 -0400", hash_original_method = "A82C4E1E74B388EF1F68336E0B7074B9", hash_generated_method = "1EDABEB034297A5A67630BA6C35FE99D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.738 -0400", hash_original_method = "D3AE998E3454F9C657DFB347B01A5D33", hash_generated_method = "09833FD24A81CB084EC231C9ED0525B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() {
        mBindArgs = null;
        {
            boolean varDE68D5CB54419BE6A192FC7E85769926_1200027944 = (nHandle == 0 || !mDatabase.isOpen());
        } //End collapsed parenthetic
        releaseReference();
        // ---------- Original Method ----------
        //mBindArgs = null;
        //if (nHandle == 0 || !mDatabase.isOpen()) {
            //return;
        //}
        //releaseReference();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.738 -0400", hash_original_method = "8DD7248015BFD919A162C74D92E1DB42", hash_generated_method = "37C45EBF9A3DCD2E91961C451A367E52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.759 -0400", hash_original_method = "3FC7B6EE26A3C940A3FAD2B270073635", hash_generated_method = "2622C19E485F8B4FB4055B97623CCE85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void compileAndbindAllArgs() {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Can't pass bindargs for this sql :" + mSql);
            } //End block
        } //End block
        {
            compileSql();
        } //End block
        {
            Iterator<Integer> varE5BB6A287738C0B897F34B057ED4A5D1_1149807544 = (mBindArgs.keySet()).iterator();
            varE5BB6A287738C0B897F34B057ED4A5D1_1149807544.hasNext();
            int index = varE5BB6A287738C0B897F34B057ED4A5D1_1149807544.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.761 -0400", hash_original_method = "7568906165FD370FD5C4296CB4D5FD76", hash_generated_method = "801047A186D51AAB37BB01530D70EC6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void bindAllArgsAsStrings(String[] bindArgs) {
        dsTaint.addTaint(bindArgs[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.761 -0400", hash_original_method = "B3D61FB7C94FF71F95332257D7EBBE92", hash_generated_method = "F4B0A6EF1F27BAC34B0974A0141EC880")
    @DSModeled(DSC.SAFE)
    synchronized final void setNativeHandle(int nHandle) {
        dsTaint.addTaint(nHandle);
        // ---------- Original Method ----------
        //this.nHandle = nHandle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.762 -0400", hash_original_method = "957AE60D3A9CE570CB89C0AA6C75F6C8", hash_generated_method = "E99FF3484E4462E059EAB2435A8FBBFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    protected final void native_compile(String sql) {
        dsTaint.addTaint(sql);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.762 -0400", hash_original_method = "B81676966F6941B90240D7A24C9E2FD3", hash_generated_method = "29F79943539902B2992FABA5DEE5CC41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    protected final void native_finalize() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.762 -0400", hash_original_method = "AB3FC56412EB6E1517BB8960DA14A39F", hash_generated_method = "968FD43F5FEB78969FCA1F01CECFFECB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void native_bind_null(int index) {
        dsTaint.addTaint(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.763 -0400", hash_original_method = "788CE16CEC77E5835CEB80FC75E60641", hash_generated_method = "867977327DA77E7D62DB797164C34FE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void native_bind_long(int index, long value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.763 -0400", hash_original_method = "DDD8FE0B3144B1C9C0B95003A2ADAE8F", hash_generated_method = "1000D404A98809F1F8C443B36D16E016")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void native_bind_double(int index, double value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.763 -0400", hash_original_method = "6D9E58383F5E5E78735F2725B3EB1959", hash_generated_method = "9A8F985B2F4D2B595B7D9E5EC4CC1D07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void native_bind_string(int index, String value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.766 -0400", hash_original_method = "283C3F08E27A848CC26557756DCA3292", hash_generated_method = "E0991804162EAFB5EFBFEB0867FAC9AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void native_bind_blob(int index, byte[] value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value[0]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.767 -0400", hash_original_method = "A7443022DB1A1E9003E4973C3792843C", hash_generated_method = "7E29C74A6A130560C9B26D8118CD2BAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void native_clear_bindings() {
    }

    
    private static final String TAG = "SQLiteProgram";
    static final int STATEMENT_CACHEABLE = 16;
    static final int STATEMENT_DONT_PREPARE = 32;
    static final int STATEMENT_USE_POOLED_CONN = 64;
    static final int STATEMENT_TYPE_MASK = 0x0f;
}

