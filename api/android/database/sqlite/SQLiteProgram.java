package android.database.sqlite;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.HashMap;

import android.database.Cursor;
import android.database.DatabaseUtils;

public abstract class SQLiteProgram extends SQLiteClosable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.128 -0500", hash_original_field = "4E3C985F8E8E62B8A187507B4B66A01F", hash_generated_field = "816508A07B46D824F7128BA5AE03ED0D")

    private static final String TAG = "SQLiteProgram";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.147 -0500", hash_original_field = "BB03963FBF2C631FE73030710811F0A6", hash_generated_field = "0F075AA00FFEB378FEE9A066ECB987E5")
 static final int STATEMENT_CACHEABLE = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.149 -0500", hash_original_field = "662972BFCC3C44DE79CFE145603B7338", hash_generated_field = "DF8B6D15B44BF0FE7223ACE28B1005DF")
 static final int STATEMENT_DONT_PREPARE = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.152 -0500", hash_original_field = "1DBEF267EAB5E563E5807A45FA62709F", hash_generated_field = "4DA750052F1E88DF1AF103836FAAA56E")
 static final int STATEMENT_USE_POOLED_CONN = 64;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.154 -0500", hash_original_field = "957E28551E8000D6D1378750A91F6030", hash_generated_field = "E08807DCEDC0067CCFCD6359301CA6D4")
 static final int STATEMENT_TYPE_MASK = 0x0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.130 -0500", hash_original_field = "AC0A81ABC82A618858F7E54D51784ED6", hash_generated_field = "45ED686A7022C4BC2786DB04CE6EE8DB")

    @Deprecated
    protected SQLiteDatabase mDatabase;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.132 -0500", hash_original_field = "4999D4179E22F9283AE45DB93648A65D", hash_generated_field = "19F08D23769D17C0D83A984597C41926")

    /* package */  String mSql;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.135 -0500", hash_original_field = "8BF79E4EB0813672F4D3D9C26E53F6B8", hash_generated_field = "85232168C2FFA32DBC86841F8D803FC7")

    @Deprecated
    protected int nHandle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.137 -0500", hash_original_field = "1913885E9133C6D2471365A2BE7C68CC", hash_generated_field = "ECAD1869B040D47DF2969B8A349C5DF6")

    /* package */ SQLiteCompiledSql mCompiledSql;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.140 -0500", hash_original_field = "065667ABB927E7A1E8FCCB15A48E314D", hash_generated_field = "AC169818D70E77676A3C030A1C1550F3")

    @Deprecated
    protected int nStatement;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.142 -0500", hash_original_field = "C5DBBCFF0D5F9E2F9756598D8BC58ACC", hash_generated_field = "219A6A9908826B6369B07AF6BD8F3B8D")

    /* package */ HashMap<Integer, Object> mBindArgs = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.145 -0500", hash_original_field = "424B264B2B85E8A83136F411485ACD38", hash_generated_field = "424B264B2B85E8A83136F411485ACD38")
  int mStatementType;

    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.157 -0500", hash_original_method = "7775AC6B878F6A87A2372052B1B0D459", hash_generated_method = "7775AC6B878F6A87A2372052B1B0D459")
    
SQLiteProgram(SQLiteDatabase db, String sql) {
        this(db, sql, null, true);
    }

    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.160 -0500", hash_original_method = "DADBFC98E2D0F265D4B5A43330A492E4", hash_generated_method = "DADBFC98E2D0F265D4B5A43330A492E4")
    
SQLiteProgram(SQLiteDatabase db, String sql, Object[] bindArgs,
            boolean compileFlag) {
        mSql = sql.trim();
        int n = DatabaseUtils.getSqlStatementType(mSql);
        switch (n) {
            case DatabaseUtils.STATEMENT_UPDATE:
                mStatementType = n | STATEMENT_CACHEABLE;
                break;
            case DatabaseUtils.STATEMENT_SELECT:
                mStatementType = n | STATEMENT_CACHEABLE | STATEMENT_USE_POOLED_CONN;
                break;
            case DatabaseUtils.STATEMENT_BEGIN:
            case DatabaseUtils.STATEMENT_COMMIT:
            case DatabaseUtils.STATEMENT_ABORT:
                mStatementType = n | STATEMENT_DONT_PREPARE;
                break;
            default:
                mStatementType = n;
        }
        db.acquireReference();
        db.addSQLiteClosable(this);
        mDatabase = db;
        nHandle = db.mNativeHandle;
        if (bindArgs != null) {
            int size = bindArgs.length;
            for (int i = 0; i < size; i++) {
                this.addToBindArgs(i + 1, bindArgs[i]);
            }
        }
        if (compileFlag) {
            compileAndbindAllArgs();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.163 -0500", hash_original_method = "EE8899F672BCD12A22959F518D1125AF", hash_generated_method = "8EE695D84F6E72E97475ACB79F23A6F6")
    
private void compileSql() {
        // only cache CRUD statements
        if ((mStatementType & STATEMENT_CACHEABLE) == 0) {
            mCompiledSql = new SQLiteCompiledSql(mDatabase, mSql);
            nStatement = mCompiledSql.nStatement;
            // since it is not in the cache, no need to acquire() it.
            return;
        }

        mCompiledSql = mDatabase.getCompiledStatementForSql(mSql);
        if (mCompiledSql == null) {
            // create a new compiled-sql obj
            mCompiledSql = new SQLiteCompiledSql(mDatabase, mSql);

            // add it to the cache of compiled-sqls
            // but before adding it and thus making it available for anyone else to use it,
            // make sure it is acquired by me.
            mCompiledSql.acquire();
            mDatabase.addToCompiledQueries(mSql, mCompiledSql);
        } else {
            // it is already in compiled-sql cache.
            // try to acquire the object.
            if (!mCompiledSql.acquire()) {
                int last = mCompiledSql.nStatement;
                // the SQLiteCompiledSql in cache is in use by some other SQLiteProgram object.
                // we can't have two different SQLiteProgam objects can't share the same
                // CompiledSql object. create a new one.
                // finalize it when I am done with it in "this" object.
                mCompiledSql = new SQLiteCompiledSql(mDatabase, mSql);
                // since it is not in the cache, no need to acquire() it.
            }
        }
        nStatement = mCompiledSql.nStatement;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.165 -0500", hash_original_method = "300DFE9F6A4C69242F1C212512462325", hash_generated_method = "75C17329CB46024E673395BB001BDB7A")
    
@Override
    protected void onAllReferencesReleased() {
        release();
        mDatabase.removeSQLiteClosable(this);
        mDatabase.releaseReference();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.168 -0500", hash_original_method = "A968FD9C775F09F9345F28805B1169A5", hash_generated_method = "491365FBEB3AE8E53C5A2E975489E0EC")
    
@Override
    protected void onAllReferencesReleasedFromContainer() {
        release();
        mDatabase.releaseReference();
    }

    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.170 -0500", hash_original_method = "A1FA2CE0BFABB0D7A31C7494B049120F", hash_generated_method = "A1FA2CE0BFABB0D7A31C7494B049120F")
    
void release() {
        if (mCompiledSql == null) {
            return;
        }
        mDatabase.releaseCompiledSqlObj(mSql, mCompiledSql);
        mCompiledSql = null;
        nStatement = 0;
    }

    /**
     * Returns a unique identifier for this program.
     *
     * @return a unique identifier for this program
     * @deprecated do not use this method. it is not guaranteed to be the same across executions of
     * the SQL statement contained in this object.
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.173 -0500", hash_original_method = "E07CAA4B1BF262B61B70604363CAC3E9", hash_generated_method = "C2177A142C34EFB222F16867D284DCC2")
    
@Deprecated
    public final int getUniqueId() {
      return -1;
    }

    /**
     * used only for testing purposes
     */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.175 -0500", hash_original_method = "76820A9DAA0EF4EAA60C4E690E9DF41D", hash_generated_method = "76820A9DAA0EF4EAA60C4E690E9DF41D")
    
int getSqlStatementId() {
      synchronized(this) {
        return (mCompiledSql == null) ? 0 : nStatement;
      }
    }

    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.177 -0500", hash_original_method = "D92A66541C65863AB0B524498A872E5D", hash_generated_method = "D92A66541C65863AB0B524498A872E5D")
    
String getSqlString() {
        return mSql;
    }

    /**
     * @deprecated This method is deprecated and must not be used.
     *
     * @param sql the SQL string to compile
     * @param forceCompilation forces the SQL to be recompiled in the event that there is an
     *  existing compiled SQL program already around
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.180 -0500", hash_original_method = "B49B29A59D94DA04C289B1136BB98967", hash_generated_method = "2EAE26B4ED65A866D24B11770B7BA5AE")
    
@Deprecated
    protected void compile(String sql, boolean forceCompilation) {
        // TODO is there a need for this?
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.182 -0500", hash_original_method = "7AFA2099A2DCB432F4822D315BB6A2D0", hash_generated_method = "013FB257FC0CDC69490011B51E5D6400")
    
private void bind(int type, int index, Object value) {
        mDatabase.verifyDbIsOpen();
        addToBindArgs(index, (type == Cursor.FIELD_TYPE_NULL) ? null : value);
        if (nStatement > 0) {
            // bind only if the SQL statement is compiled
            acquireReference();
            try {
                switch (type) {
                    case Cursor.FIELD_TYPE_NULL:
                        native_bind_null(index);
                        break;
                    case Cursor.FIELD_TYPE_BLOB:
                        native_bind_blob(index, (byte[]) value);
                        break;
                    case Cursor.FIELD_TYPE_FLOAT:
                        native_bind_double(index, (Double) value);
                        break;
                    case Cursor.FIELD_TYPE_INTEGER:
                        native_bind_long(index, (Long) value);
                        break;
                    case Cursor.FIELD_TYPE_STRING:
                    default:
                        native_bind_string(index, (String) value);
                        break;
                }
            } finally {
                releaseReference();
            }
        }
    }

    /**
     * Bind a NULL value to this statement. The value remains bound until
     * {@link #clearBindings} is called.
     *
     * @param index The 1-based index to the parameter to bind null to
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.184 -0500", hash_original_method = "3480FC3F53F060D0AF87F13A57EE020E", hash_generated_method = "288D9EF026F891E54B9DEA3637806146")
    
public void bindNull(int index) {
        bind(Cursor.FIELD_TYPE_NULL, index, null);
    }

    /**
     * Bind a long value to this statement. The value remains bound until
     * {@link #clearBindings} is called.
     *addToBindArgs
     * @param index The 1-based index to the parameter to bind
     * @param value The value to bind
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.187 -0500", hash_original_method = "DDFF1311EF84C79E9F0283B8959C214A", hash_generated_method = "3388891A13AB586E95F3639121D7334F")
    
public void bindLong(int index, long value) {
        bind(Cursor.FIELD_TYPE_INTEGER, index, value);
    }

    /**
     * Bind a double value to this statement. The value remains bound until
     * {@link #clearBindings} is called.
     *
     * @param index The 1-based index to the parameter to bind
     * @param value The value to bind
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.190 -0500", hash_original_method = "D271F20EDF0F2BB1E84FEE6A8DFAF59F", hash_generated_method = "DBAB89804C01133DD327EEB8DE0A3F99")
    
public void bindDouble(int index, double value) {
        bind(Cursor.FIELD_TYPE_FLOAT, index, value);
    }

    /**
     * Bind a String value to this statement. The value remains bound until
     * {@link #clearBindings} is called.
     *
     * @param index The 1-based index to the parameter to bind
     * @param value The value to bind
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.192 -0500", hash_original_method = "963A4C4D7269247053E24419DAA13FC1", hash_generated_method = "8F5D6A2064655E7863E1E3363920F842")
    
public void bindString(int index, String value) {
        if (value == null) {
            throw new IllegalArgumentException("the bind value at index " + index + " is null");
        }
        bind(Cursor.FIELD_TYPE_STRING, index, value);
    }

    /**
     * Bind a byte array value to this statement. The value remains bound until
     * {@link #clearBindings} is called.
     *
     * @param index The 1-based index to the parameter to bind
     * @param value The value to bind
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.194 -0500", hash_original_method = "C702C9CEB9955A1F1B2C6A119BC67F74", hash_generated_method = "77B2F25594F8497354A2A69D1ECE43E7")
    
public void bindBlob(int index, byte[] value) {
        if (value == null) {
            throw new IllegalArgumentException("the bind value at index " + index + " is null");
        }
        bind(Cursor.FIELD_TYPE_BLOB, index, value);
    }

    /**
     * Clears all existing bindings. Unset bindings are treated as NULL.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.197 -0500", hash_original_method = "A82C4E1E74B388EF1F68336E0B7074B9", hash_generated_method = "DFA28A1095760F60199A7210297ABC05")
    
public void clearBindings() {
        mBindArgs = null;
        if (this.nStatement == 0) {
            return;
        }
        mDatabase.verifyDbIsOpen();
        acquireReference();
        try {
            native_clear_bindings();
        } finally {
            releaseReference();
        }
    }

    /**
     * Release this program's resources, making it invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.199 -0500", hash_original_method = "D3AE998E3454F9C657DFB347B01A5D33", hash_generated_method = "981860DE70F16540F0E330413D24ECFA")
    
public void close() {
        mBindArgs = null;
        if (nHandle == 0 || !mDatabase.isOpen()) {
            return;
        }
        releaseReference();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.201 -0500", hash_original_method = "8DD7248015BFD919A162C74D92E1DB42", hash_generated_method = "7C94AC73D336D40D18F61050A12F6464")
    
private void addToBindArgs(int index, Object value) {
        if (mBindArgs == null) {
            mBindArgs = new HashMap<Integer, Object>();
        }
        mBindArgs.put(index, value);
    }

    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.204 -0500", hash_original_method = "3FC7B6EE26A3C940A3FAD2B270073635", hash_generated_method = "62964B7B9EADB4CAFC1CD10CF3AD8AD0")
    
void compileAndbindAllArgs() {
        if ((mStatementType & STATEMENT_DONT_PREPARE) > 0) {
            if (mBindArgs != null) {
                throw new IllegalArgumentException("Can't pass bindargs for this sql :" + mSql);
            }
            // no need to prepare this SQL statement
            return;
        }
        if (nStatement == 0) {
            // SQL statement is not compiled yet. compile it now.
            compileSql();
        }
        if (mBindArgs == null) {
            return;
        }
        for (int index : mBindArgs.keySet()) {
            Object value = mBindArgs.get(index);
            if (value == null) {
                native_bind_null(index);
            } else if (value instanceof Double || value instanceof Float) {
                native_bind_double(index, ((Number) value).doubleValue());
            } else if (value instanceof Number) {
                native_bind_long(index, ((Number) value).longValue());
            } else if (value instanceof Boolean) {
                Boolean bool = (Boolean)value;
                native_bind_long(index, (bool) ? 1 : 0);
                if (bool) {
                    native_bind_long(index, 1);
                } else {
                    native_bind_long(index, 0);
                }
            } else if (value instanceof byte[]){
                native_bind_blob(index, (byte[]) value);
            } else {
                native_bind_string(index, value.toString());
            }
        }
    }

    /**
     * Given an array of String bindArgs, this method binds all of them in one single call.
     *
     * @param bindArgs the String array of bind args.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.207 -0500", hash_original_method = "7568906165FD370FD5C4296CB4D5FD76", hash_generated_method = "B6E6EC8992C1CCA1FC7F07E623B0F6A7")
    
public void bindAllArgsAsStrings(String[] bindArgs) {
        if (bindArgs == null) {
            return;
        }
        int size = bindArgs.length;
        for (int i = 0; i < size; i++) {
            bindString(i + 1, bindArgs[i]);
        }
    }

    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.209 -0500", hash_original_method = "B3D61FB7C94FF71F95332257D7EBBE92", hash_generated_method = "2AD098197CAFBEF39B912C7FB3A53B06")
    
synchronized final void setNativeHandle(int nHandle) {
        this.nHandle = nHandle;
    }

    /**
     * @deprecated This method is deprecated and must not be used.
     * Compiles SQL into a SQLite program.
     *
     * <P>The database lock must be held when calling this method.
     * @param sql The SQL to compile.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.213 -0500", hash_original_method = "957AE60D3A9CE570CB89C0AA6C75F6C8", hash_generated_method = "FDADB4FC4E31C09D638AC9398578192F")
    
    @Deprecated
    protected final void native_compile(String sql){
    	//Formerly a native method
    	addTaint(sql.getTaint());
    }

    /**
     * @deprecated This method is deprecated and must not be used.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.217 -0500", hash_original_method = "B81676966F6941B90240D7A24C9E2FD3", hash_generated_method = "4BEBACDDC5BC3582F570933043BBE8A7")
    
    @Deprecated
    protected final void native_finalize(){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.222 -0500", hash_original_method = "AB3FC56412EB6E1517BB8960DA14A39F", hash_generated_method = "59B4517C68ED14E1D11D071AD9B6ABA5")
    
    protected final void native_bind_null(int index){
    	//Formerly a native method
    	addTaint(index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.225 -0500", hash_original_method = "788CE16CEC77E5835CEB80FC75E60641", hash_generated_method = "DA72EDDAA0D8D955940E88D197D62E11")
    
    protected final void native_bind_long(int index, long value){
    	//Formerly a native method
    	addTaint(index);
    	addTaint(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.229 -0500", hash_original_method = "DDD8FE0B3144B1C9C0B95003A2ADAE8F", hash_generated_method = "EC1D2BD8943C01E30F7E6937F9533027")
    
    protected final void native_bind_double(int index, double value){
    	//Formerly a native method
    	addTaint(index);
    	addTaint(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.233 -0500", hash_original_method = "6D9E58383F5E5E78735F2725B3EB1959", hash_generated_method = "CBF79BDD923FBAD0F3ED7B875F663BB0")
    
    protected final void native_bind_string(int index, String value){
    	//Formerly a native method
    	addTaint(index);
    	addTaint(value.getTaint());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.237 -0500", hash_original_method = "283C3F08E27A848CC26557756DCA3292", hash_generated_method = "274D89824040C9276F8ACBEF74B83F35")
    
    protected final void native_bind_blob(int index, byte[] value){
    	//Formerly a native method
    	addTaint(index);
    	addTaint(value[0]);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.240 -0500", hash_original_method = "A7443022DB1A1E9003E4973C3792843C", hash_generated_method = "F5ADBCE17982F800A7C5AA5FA2786F05")
    
    private final void native_clear_bindings(){
    	//Formerly a native method
    }

}

