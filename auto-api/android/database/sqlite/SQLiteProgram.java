package android.database.sqlite;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.database.DatabaseUtils;
import android.database.Cursor;
import java.util.HashMap;

public abstract class SQLiteProgram extends SQLiteClosable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.761 -0400", hash_original_field = "8C0B67E1F99496AB4CD09433C231BEB3", hash_generated_field = "45ED686A7022C4BC2786DB04CE6EE8DB")

    @Deprecated protected SQLiteDatabase mDatabase;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.761 -0400", hash_original_field = "ABF275D728AAD5B5017275F72010DE2D", hash_generated_field = "4999D4179E22F9283AE45DB93648A65D")

    String mSql;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.761 -0400", hash_original_field = "83BEE6D182A8A0F703AE0355A9CE0E10", hash_generated_field = "85232168C2FFA32DBC86841F8D803FC7")

    @Deprecated protected int nHandle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.761 -0400", hash_original_field = "4898CE77BC963F16329C91A665085757", hash_generated_field = "1913885E9133C6D2471365A2BE7C68CC")

    SQLiteCompiledSql mCompiledSql;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.761 -0400", hash_original_field = "89022B4A7B6E760B21FA35C0F1DCD003", hash_generated_field = "AC169818D70E77676A3C030A1C1550F3")

    @Deprecated protected int nStatement;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.761 -0400", hash_original_field = "F17FD8F8DF407F1B4DA85EE2CFCED461", hash_generated_field = "C5DBBCFF0D5F9E2F9756598D8BC58ACC")

    HashMap<Integer, Object> mBindArgs = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.761 -0400", hash_original_field = "80AC909AAEC71746A068105F25E3B9AE", hash_generated_field = "424B264B2B85E8A83136F411485ACD38")

    int mStatementType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.762 -0400", hash_original_method = "7775AC6B878F6A87A2372052B1B0D459", hash_generated_method = "4477DCAF544BA636792EBDD195E0ACAF")
      SQLiteProgram(SQLiteDatabase db, String sql) {
        this(db, sql, null, true);
        addTaint(db.getTaint());
        addTaint(sql.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.763 -0400", hash_original_method = "DADBFC98E2D0F265D4B5A43330A492E4", hash_generated_method = "0BFBADBC66D69C604A4FE8E58A15D192")
      SQLiteProgram(SQLiteDatabase db, String sql, Object[] bindArgs,
            boolean compileFlag) {
        mSql = sql.trim();
        int n = DatabaseUtils.getSqlStatementType(mSql);
        
        mStatementType = n | STATEMENT_CACHEABLE;
        
        
        mStatementType = n | STATEMENT_CACHEABLE | STATEMENT_USE_POOLED_CONN;
        
        
        mStatementType = n | STATEMENT_DONT_PREPARE;
        
        
        mStatementType = n;
        
        db.acquireReference();
        db.addSQLiteClosable(this);
        mDatabase = db;
        nHandle = db.mNativeHandle;
        {
            int size = bindArgs.length;
            {
                int i = 0;
                {
                    this.addToBindArgs(i + 1, bindArgs[i]);
                } 
            } 
        } 
        {
            compileAndbindAllArgs();
        } 
        addTaint(bindArgs[0].getTaint());
        addTaint(compileFlag);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.764 -0400", hash_original_method = "EE8899F672BCD12A22959F518D1125AF", hash_generated_method = "0CE73BEB5C58DAC5BC8E4D333F928F0A")
    private void compileSql() {
        {
            mCompiledSql = new SQLiteCompiledSql(mDatabase, mSql);
            nStatement = mCompiledSql.nStatement;
        } 
        mCompiledSql = mDatabase.getCompiledStatementForSql(mSql);
        {
            mCompiledSql = new SQLiteCompiledSql(mDatabase, mSql);
            mCompiledSql.acquire();
            mDatabase.addToCompiledQueries(mSql, mCompiledSql);
        } 
        {
            {
                boolean var67BB5573694D5AAA2A946CFD3319B64C_1829450239 = (!mCompiledSql.acquire());
                {
                    int last = mCompiledSql.nStatement;
                    mCompiledSql = new SQLiteCompiledSql(mDatabase, mSql);
                } 
            } 
        } 
        nStatement = mCompiledSql.nStatement;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.764 -0400", hash_original_method = "300DFE9F6A4C69242F1C212512462325", hash_generated_method = "1CD0B8729AFD456C5EE63418C49A729F")
    @Override
    protected void onAllReferencesReleased() {
        
        release();
        mDatabase.removeSQLiteClosable(this);
        mDatabase.releaseReference();
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.765 -0400", hash_original_method = "A968FD9C775F09F9345F28805B1169A5", hash_generated_method = "431B9CF113097FF3B598F21FC4A441C4")
    @Override
    protected void onAllReferencesReleasedFromContainer() {
        
        release();
        mDatabase.releaseReference();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.766 -0400", hash_original_method = "A1FA2CE0BFABB0D7A31C7494B049120F", hash_generated_method = "AEF4847162FF006ACE039D37EC0210A6")
     void release() {
        mDatabase.releaseCompiledSqlObj(mSql, mCompiledSql);
        mCompiledSql = null;
        nStatement = 0;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.766 -0400", hash_original_method = "E07CAA4B1BF262B61B70604363CAC3E9", hash_generated_method = "BB4FDDEEF92D5345FB3DF4ABEFAA20B9")
    @Deprecated
    public final int getUniqueId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_171544010 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_171544010;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.767 -0400", hash_original_method = "76820A9DAA0EF4EAA60C4E690E9DF41D", hash_generated_method = "064667B7C26B419B9045E41247E7E515")
     int getSqlStatementId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1559170426 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1559170426;
        
        
        
      
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.767 -0400", hash_original_method = "D92A66541C65863AB0B524498A872E5D", hash_generated_method = "E83FED7309E50EB6CD5FE5C7C262A370")
     String getSqlString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2117573509 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2117573509 = mSql;
        varB4EAC82CA7396A68D541C85D26508E83_2117573509.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2117573509;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.768 -0400", hash_original_method = "B49B29A59D94DA04C289B1136BB98967", hash_generated_method = "AFFB24A97E7B835AB0D12D6BB202A60F")
    @Deprecated
    protected void compile(String sql, boolean forceCompilation) {
        addTaint(sql.getTaint());
        addTaint(forceCompilation);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.768 -0400", hash_original_method = "7AFA2099A2DCB432F4822D315BB6A2D0", hash_generated_method = "4705C44EF2239B94640BC373A03372A0")
    private void bind(int type, int index, Object value) {
        mDatabase.verifyDbIsOpen();
        addToBindArgs(index, (type == Cursor.FIELD_TYPE_NULL) ? null : value);
        {
            acquireReference();
            try 
            {
                
                native_bind_null(index);
                
                
                native_bind_blob(index, (byte[]) value);
                
                
                native_bind_double(index, (Double) value);
                
                
                native_bind_long(index, (Long) value);
                
                
                native_bind_string(index, (String) value);
                
            } 
            finally 
            {
                releaseReference();
            } 
        } 
        addTaint(type);
        addTaint(index);
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.769 -0400", hash_original_method = "3480FC3F53F060D0AF87F13A57EE020E", hash_generated_method = "6EE54E03CEE99F89ECAD4C4F085F5E3F")
    public void bindNull(int index) {
        bind(Cursor.FIELD_TYPE_NULL, index, null);
        addTaint(index);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.769 -0400", hash_original_method = "DDFF1311EF84C79E9F0283B8959C214A", hash_generated_method = "A9C11960F0E2E7F363017F1AA9F76FDD")
    public void bindLong(int index, long value) {
        bind(Cursor.FIELD_TYPE_INTEGER, index, value);
        addTaint(index);
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.770 -0400", hash_original_method = "D271F20EDF0F2BB1E84FEE6A8DFAF59F", hash_generated_method = "A143E61D8D48B234493AD21D8711DA61")
    public void bindDouble(int index, double value) {
        bind(Cursor.FIELD_TYPE_FLOAT, index, value);
        addTaint(index);
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.770 -0400", hash_original_method = "963A4C4D7269247053E24419DAA13FC1", hash_generated_method = "3D63D34B10B8BBEC22BCA729C5A9871E")
    public void bindString(int index, String value) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the bind value at index " + index + " is null");
        } 
        bind(Cursor.FIELD_TYPE_STRING, index, value);
        addTaint(index);
        addTaint(value.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.771 -0400", hash_original_method = "C702C9CEB9955A1F1B2C6A119BC67F74", hash_generated_method = "6812B9BCCF37279EB0DE423DFBC794E3")
    public void bindBlob(int index, byte[] value) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the bind value at index " + index + " is null");
        } 
        bind(Cursor.FIELD_TYPE_BLOB, index, value);
        addTaint(index);
        addTaint(value[0]);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.771 -0400", hash_original_method = "A82C4E1E74B388EF1F68336E0B7074B9", hash_generated_method = "1EDABEB034297A5A67630BA6C35FE99D")
    public void clearBindings() {
        mBindArgs = null;
        mDatabase.verifyDbIsOpen();
        acquireReference();
        try 
        {
            native_clear_bindings();
        } 
        finally 
        {
            releaseReference();
        } 
        
        
        
            
        
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.772 -0400", hash_original_method = "D3AE998E3454F9C657DFB347B01A5D33", hash_generated_method = "080B111F3C20F1ABF45FB147DC9E7F28")
    public void close() {
        mBindArgs = null;
        {
            boolean varDE68D5CB54419BE6A192FC7E85769926_1156311567 = (nHandle == 0 || !mDatabase.isOpen());
        } 
        releaseReference();
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.772 -0400", hash_original_method = "8DD7248015BFD919A162C74D92E1DB42", hash_generated_method = "56D98F965A2928CD06D27411ECA151D8")
    private void addToBindArgs(int index, Object value) {
        {
            mBindArgs = new HashMap<Integer, Object>();
        } 
        mBindArgs.put(index, value);
        addTaint(index);
        addTaint(value.getTaint());
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.785 -0400", hash_original_method = "3FC7B6EE26A3C940A3FAD2B270073635", hash_generated_method = "F67786982EB987931B16356E2666C696")
     void compileAndbindAllArgs() {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Can't pass bindargs for this sql :" + mSql);
            } 
        } 
        {
            compileSql();
        } 
        {
            Iterator<Integer> varE5BB6A287738C0B897F34B057ED4A5D1_71353976 = (mBindArgs.keySet()).iterator();
            varE5BB6A287738C0B897F34B057ED4A5D1_71353976.hasNext();
            int index = varE5BB6A287738C0B897F34B057ED4A5D1_71353976.next();
            {
                Object value = mBindArgs.get(index);
                {
                    native_bind_null(index);
                } 
                {
                    native_bind_double(index, ((Number) value).doubleValue());
                } 
                {
                    native_bind_long(index, ((Number) value).longValue());
                } 
                {
                    Boolean bool = (Boolean)value;
                    native_bind_long(index, (bool) ? 1 : 0);
                    {
                        native_bind_long(index, 1);
                    } 
                    {
                        native_bind_long(index, 0);
                    } 
                } 
                {
                    native_bind_blob(index, (byte[]) value);
                } 
                {
                    native_bind_string(index, value.toString());
                } 
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.785 -0400", hash_original_method = "7568906165FD370FD5C4296CB4D5FD76", hash_generated_method = "0CB143BEAFDB1BC204894CA5670F5468")
    public void bindAllArgsAsStrings(String[] bindArgs) {
        int size = bindArgs.length;
        {
            int i = 0;
            {
                bindString(i + 1, bindArgs[i]);
            } 
        } 
        addTaint(bindArgs[0].getTaint());
        
        
            
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.786 -0400", hash_original_method = "B3D61FB7C94FF71F95332257D7EBBE92", hash_generated_method = "8CD7EC8DFFC384BDEDA0FF75DA7E64C6")
    synchronized final void setNativeHandle(int nHandle) {
        this.nHandle = nHandle;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.786 -0400", hash_original_method = "957AE60D3A9CE570CB89C0AA6C75F6C8", hash_generated_method = "05A7614624EE5DC85A8CB7259F9CAADD")
    @Deprecated
    protected final void native_compile(String sql) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.786 -0400", hash_original_method = "B81676966F6941B90240D7A24C9E2FD3", hash_generated_method = "29F79943539902B2992FABA5DEE5CC41")
    @Deprecated
    protected final void native_finalize() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.787 -0400", hash_original_method = "AB3FC56412EB6E1517BB8960DA14A39F", hash_generated_method = "02063E5C169A9266082F35EAE3C7C520")
    protected final void native_bind_null(int index) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.787 -0400", hash_original_method = "788CE16CEC77E5835CEB80FC75E60641", hash_generated_method = "F543D954A1583266C1CF2C596DC6D8F7")
    protected final void native_bind_long(int index, long value) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.787 -0400", hash_original_method = "DDD8FE0B3144B1C9C0B95003A2ADAE8F", hash_generated_method = "BF020D591B59EC88D6E6DE4D00A42DE7")
    protected final void native_bind_double(int index, double value) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.787 -0400", hash_original_method = "6D9E58383F5E5E78735F2725B3EB1959", hash_generated_method = "7E1F6811E07620367DA6F46B72C1EC49")
    protected final void native_bind_string(int index, String value) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.788 -0400", hash_original_method = "283C3F08E27A848CC26557756DCA3292", hash_generated_method = "40CB1A935F835CA4557C2B3A78725579")
    protected final void native_bind_blob(int index, byte[] value) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.788 -0400", hash_original_method = "A7443022DB1A1E9003E4973C3792843C", hash_generated_method = "7E29C74A6A130560C9B26D8118CD2BAA")
    private final void native_clear_bindings() {
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.788 -0400", hash_original_field = "CA2842CAC53650043FCFF2C4FF30671E", hash_generated_field = "816508A07B46D824F7128BA5AE03ED0D")

    private static final String TAG = "SQLiteProgram";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.788 -0400", hash_original_field = "A32CD36BCAA299B40589381C0FC28A6E", hash_generated_field = "0F075AA00FFEB378FEE9A066ECB987E5")

    static final int STATEMENT_CACHEABLE = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.788 -0400", hash_original_field = "FB47074F23821C2976A54DF0B807DE5B", hash_generated_field = "DF8B6D15B44BF0FE7223ACE28B1005DF")

    static final int STATEMENT_DONT_PREPARE = 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.788 -0400", hash_original_field = "5EA607C38E360BB2E02CFA22D08E10AD", hash_generated_field = "4DA750052F1E88DF1AF103836FAAA56E")

    static final int STATEMENT_USE_POOLED_CONN = 64;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.788 -0400", hash_original_field = "E371F27A1CAF1FE8D47600BF5310C83B", hash_generated_field = "E08807DCEDC0067CCFCD6359301CA6D4")

    static final int STATEMENT_TYPE_MASK = 0x0f;
}

