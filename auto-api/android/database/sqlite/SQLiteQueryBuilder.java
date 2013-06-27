package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.provider.BaseColumns;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

public class SQLiteQueryBuilder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.040 -0400", hash_original_field = "CAC1605D9B4F31C278921D5EA4DD178B", hash_generated_field = "769F77C34DE42382B188666E269E7701")

    private Map<String, String> mProjectionMap = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.041 -0400", hash_original_field = "9AFED356017DBD96BEA037FB628DD7E5", hash_generated_field = "8F885C16B9BDADDFD8C26FCD5BE5228C")

    private String mTables = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.041 -0400", hash_original_field = "3073694C7BCC7C209803EDAC9D081570", hash_generated_field = "AA43CCC2518697E93036E759BA68D945")

    private StringBuilder mWhereClause = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.041 -0400", hash_original_field = "097E4446BDCC69C5664BA85E4A99402A", hash_generated_field = "A56C1C3192C3259733D99B7B9797B9BD")

    private boolean mDistinct;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.041 -0400", hash_original_field = "06389DE86ED19AB1571A41645A1AFADC", hash_generated_field = "B3A21B3E4C20F1E737FF55A7E08BB6E5")

    private SQLiteDatabase.CursorFactory mFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.041 -0400", hash_original_field = "89640C202140B2F2E90FF0FCFBB5A040", hash_generated_field = "52E2A3AFF0ECDB0477697EA761229425")

    private boolean mStrict;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.046 -0400", hash_original_method = "841FC2D35CC9552E307358F36A673D72", hash_generated_method = "7743D13935D2A6130C706962EEE16D30")
    public  SQLiteQueryBuilder() {
        mDistinct = false;
        mFactory = null;
        // ---------- Original Method ----------
        //mDistinct = false;
        //mFactory = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.054 -0400", hash_original_method = "9A9512BC3B93773BE1B8C3DEAB4EDCF7", hash_generated_method = "04E5D28A4FA7008D9677964C6DA606F3")
    public void setDistinct(boolean distinct) {
        mDistinct = distinct;
        // ---------- Original Method ----------
        //mDistinct = distinct;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.062 -0400", hash_original_method = "71A35CB8526DF402EA58F5074639A5D5", hash_generated_method = "24E300354017B3A831BECFC57C56DA1C")
    public String getTables() {
        String varB4EAC82CA7396A68D541C85D26508E83_194950889 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_194950889 = mTables;
        varB4EAC82CA7396A68D541C85D26508E83_194950889.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_194950889;
        // ---------- Original Method ----------
        //return mTables;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.064 -0400", hash_original_method = "3D5C8D5A2DF23857F8B36CBC126449F5", hash_generated_method = "8A78A70CC3C87FBE05086EC3C4609F92")
    public void setTables(String inTables) {
        mTables = inTables;
        // ---------- Original Method ----------
        //mTables = inTables;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.079 -0400", hash_original_method = "4066C27D90FD6AEEDB747E2D0A255B82", hash_generated_method = "1CF5B3B5978A258D19371926C89F9498")
    public void appendWhere(CharSequence inWhere) {
        {
            mWhereClause = new StringBuilder(inWhere.length() + 16);
        } //End block
        {
            boolean var684378E5464B4E4DF3A428AF47BF8D84_1938373629 = (mWhereClause.length() == 0);
            {
                mWhereClause.append('(');
            } //End block
        } //End collapsed parenthetic
        mWhereClause.append(inWhere);
        // ---------- Original Method ----------
        //if (mWhereClause == null) {
            //mWhereClause = new StringBuilder(inWhere.length() + 16);
        //}
        //if (mWhereClause.length() == 0) {
            //mWhereClause.append('(');
        //}
        //mWhereClause.append(inWhere);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.095 -0400", hash_original_method = "CD89033A6A424354FBAEE4A7B7BB0312", hash_generated_method = "8CAEC8889816E1DF6DB49189E96CA658")
    public void appendWhereEscapeString(String inWhere) {
        {
            mWhereClause = new StringBuilder(inWhere.length() + 16);
        } //End block
        {
            boolean var684378E5464B4E4DF3A428AF47BF8D84_1298614273 = (mWhereClause.length() == 0);
            {
                mWhereClause.append('(');
            } //End block
        } //End collapsed parenthetic
        DatabaseUtils.appendEscapedSQLString(mWhereClause, inWhere);
        // ---------- Original Method ----------
        //if (mWhereClause == null) {
            //mWhereClause = new StringBuilder(inWhere.length() + 16);
        //}
        //if (mWhereClause.length() == 0) {
            //mWhereClause.append('(');
        //}
        //DatabaseUtils.appendEscapedSQLString(mWhereClause, inWhere);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.096 -0400", hash_original_method = "DDD8D9F6C39192C696789E3C5816355A", hash_generated_method = "52ECEFBD4BAF572978D68E44F502DFAD")
    public void setProjectionMap(Map<String, String> columnMap) {
        mProjectionMap = columnMap;
        // ---------- Original Method ----------
        //mProjectionMap = columnMap;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.097 -0400", hash_original_method = "9A5AF21719138D1250197FB20CA33704", hash_generated_method = "1239112BA6697D38A5EBA247B91110D9")
    public void setCursorFactory(SQLiteDatabase.CursorFactory factory) {
        mFactory = factory;
        // ---------- Original Method ----------
        //mFactory = factory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.097 -0400", hash_original_method = "20B77E17A7BDAD72AFE7C926EABDA9FA", hash_generated_method = "42BC386A940F34BA3758B62F79108296")
    public void setStrict(boolean flag) {
        mStrict = flag;
        // ---------- Original Method ----------
        //mStrict = flag;
    }

    
        public static String buildQueryString(
            boolean distinct, String tables, String[] columns, String where,
            String groupBy, String having, String orderBy, String limit) {
        if (TextUtils.isEmpty(groupBy) && !TextUtils.isEmpty(having)) {
            throw new IllegalArgumentException(
                    "HAVING clauses are only permitted when using a groupBy clause");
        }
        if (!TextUtils.isEmpty(limit) && !sLimitPattern.matcher(limit).matches()) {
            throw new IllegalArgumentException("invalid LIMIT clauses:" + limit);
        }
        StringBuilder query = new StringBuilder(120);
        query.append("SELECT ");
        if (distinct) {
            query.append("DISTINCT ");
        }
        if (columns != null && columns.length != 0) {
            appendColumns(query, columns);
        } else {
            query.append("* ");
        }
        query.append("FROM ");
        query.append(tables);
        appendClause(query, " WHERE ", where);
        appendClause(query, " GROUP BY ", groupBy);
        appendClause(query, " HAVING ", having);
        appendClause(query, " ORDER BY ", orderBy);
        appendClause(query, " LIMIT ", limit);
        return query.toString();
    }

    
        private static void appendClause(StringBuilder s, String name, String clause) {
        if (!TextUtils.isEmpty(clause)) {
            s.append(name);
            s.append(clause);
        }
    }

    
        public static void appendColumns(StringBuilder s, String[] columns) {
        int n = columns.length;
        for (int i = 0; i < n; i++) {
            String column = columns[i];
            if (column != null) {
                if (i > 0) {
                    s.append(", ");
                }
                s.append(column);
            }
        }
        s.append(' ');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.128 -0400", hash_original_method = "C851DFBDB6501381AF55260B14586647", hash_generated_method = "9830E3C97A7126FFF34B795DB4BE2AB6")
    public Cursor query(SQLiteDatabase db, String[] projectionIn,
            String selection, String[] selectionArgs, String groupBy,
            String having, String sortOrder) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_708840236 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_708840236 = query(db, projectionIn, selection, selectionArgs, groupBy, having, sortOrder,
                null );
        addTaint(db.getTaint());
        addTaint(projectionIn[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(groupBy.getTaint());
        addTaint(having.getTaint());
        addTaint(sortOrder.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_708840236.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_708840236;
        // ---------- Original Method ----------
        //return query(db, projectionIn, selection, selectionArgs, groupBy, having, sortOrder,
                //null );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.143 -0400", hash_original_method = "A22563797EE8B98D8D2C96F4FC0F2C77", hash_generated_method = "43F2C761389C330AC7F3C7E2012513D9")
    public Cursor query(SQLiteDatabase db, String[] projectionIn,
            String selection, String[] selectionArgs, String groupBy,
            String having, String sortOrder, String limit) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_917612915 = null; //Variable for return #1
        Cursor varB4EAC82CA7396A68D541C85D26508E83_885219879 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_917612915 = null;
        } //End block
        {
            boolean varA87A577568BFC2D77CF995C5491CA98D_1071078080 = (mStrict && selection != null && selection.length() > 0);
            {
                String sqlForValidation;
                sqlForValidation = buildQuery(projectionIn, "(" + selection + ")", groupBy,
                    having, sortOrder, limit);
                validateSql(db, sqlForValidation);
            } //End block
        } //End collapsed parenthetic
        String sql;
        sql = buildQuery(
                projectionIn, selection, groupBy, having,
                sortOrder, limit);
        {
            boolean var7061DF8A5335B809C796044C2A062407_1185946062 = (Log.isLoggable(TAG, Log.DEBUG));
            {
                Log.d(TAG, "Performing query: " + sql);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_885219879 = db.rawQueryWithFactory(
                mFactory, sql, selectionArgs,
                SQLiteDatabase.findEditTable(mTables));
        addTaint(db.getTaint());
        addTaint(projectionIn[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(groupBy.getTaint());
        addTaint(having.getTaint());
        addTaint(sortOrder.getTaint());
        addTaint(limit.getTaint());
        Cursor varA7E53CE21691AB073D9660D615818899_1859016061; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1859016061 = varB4EAC82CA7396A68D541C85D26508E83_917612915;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1859016061 = varB4EAC82CA7396A68D541C85D26508E83_885219879;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1859016061.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1859016061;
        // ---------- Original Method ----------
        //if (mTables == null) {
            //return null;
        //}
        //if (mStrict && selection != null && selection.length() > 0) {
            //String sqlForValidation = buildQuery(projectionIn, "(" + selection + ")", groupBy,
                    //having, sortOrder, limit);
            //validateSql(db, sqlForValidation); 
        //}
        //String sql = buildQuery(
                //projectionIn, selection, groupBy, having,
                //sortOrder, limit);
        //if (Log.isLoggable(TAG, Log.DEBUG)) {
            //Log.d(TAG, "Performing query: " + sql);
        //}
        //return db.rawQueryWithFactory(
                //mFactory, sql, selectionArgs,
                //SQLiteDatabase.findEditTable(mTables));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.145 -0400", hash_original_method = "A033D274CBE9E5A0C4BD18FE9EA6496C", hash_generated_method = "145EC15A6E9EF294D2B1F4AE529E30BA")
    private void validateSql(SQLiteDatabase db, String sql) {
        db.lock(sql);
        try 
        {
            new SQLiteCompiledSql(db, sql).releaseSqlStatement();
        } //End block
        finally 
        {
            db.unlock();
        } //End block
        addTaint(db.getTaint());
        addTaint(sql.getTaint());
        // ---------- Original Method ----------
        //db.lock(sql);
        //try {
            //new SQLiteCompiledSql(db, sql).releaseSqlStatement();
        //} finally {
            //db.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.167 -0400", hash_original_method = "131EA8692C493A86BCD7B59A8B1306F4", hash_generated_method = "D2DE55E95FCAFCEDD3A4A1CDFF9A3BC1")
    public String buildQuery(
            String[] projectionIn, String selection, String groupBy,
            String having, String sortOrder, String limit) {
        String varB4EAC82CA7396A68D541C85D26508E83_194395176 = null; //Variable for return #1
        String[] projection;
        projection = computeProjection(projectionIn);
        StringBuilder where;
        where = new StringBuilder();
        boolean hasBaseWhereClause;
        hasBaseWhereClause = mWhereClause != null && mWhereClause.length() > 0;
        {
            where.append(mWhereClause.toString());
            where.append(')');
        } //End block
        {
            boolean varA1B7D4902A1967FE05483484790F8DD9_1188607815 = (selection != null && selection.length() > 0);
            {
                {
                    where.append(" AND ");
                } //End block
                where.append('(');
                where.append(selection);
                where.append(')');
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_194395176 = buildQueryString(
                mDistinct, mTables, projection, where.toString(),
                groupBy, having, sortOrder, limit);
        addTaint(projectionIn[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(groupBy.getTaint());
        addTaint(having.getTaint());
        addTaint(sortOrder.getTaint());
        addTaint(limit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_194395176.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_194395176;
        // ---------- Original Method ----------
        //String[] projection = computeProjection(projectionIn);
        //StringBuilder where = new StringBuilder();
        //boolean hasBaseWhereClause = mWhereClause != null && mWhereClause.length() > 0;
        //if (hasBaseWhereClause) {
            //where.append(mWhereClause.toString());
            //where.append(')');
        //}
        //if (selection != null && selection.length() > 0) {
            //if (hasBaseWhereClause) {
                //where.append(" AND ");
            //}
            //where.append('(');
            //where.append(selection);
            //where.append(')');
        //}
        //return buildQueryString(
                //mDistinct, mTables, projection, where.toString(),
                //groupBy, having, sortOrder, limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.168 -0400", hash_original_method = "D5409D707055983A8E689AC969CBA872", hash_generated_method = "A644894F6DE224A78E62FD1F332777E4")
    @Deprecated
    public String buildQuery(
            String[] projectionIn, String selection, String[] selectionArgs,
            String groupBy, String having, String sortOrder, String limit) {
        String varB4EAC82CA7396A68D541C85D26508E83_1808051398 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1808051398 = buildQuery(projectionIn, selection, groupBy, having, sortOrder, limit);
        addTaint(projectionIn[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(groupBy.getTaint());
        addTaint(having.getTaint());
        addTaint(sortOrder.getTaint());
        addTaint(limit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1808051398.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1808051398;
        // ---------- Original Method ----------
        //return buildQuery(projectionIn, selection, groupBy, having, sortOrder, limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.188 -0400", hash_original_method = "579B4F5DF75F7C70B58361D381AB3677", hash_generated_method = "55B5F2D1A8B567128AD0554A31AF207D")
    public String buildUnionSubQuery(
            String typeDiscriminatorColumn,
            String[] unionColumns,
            Set<String> columnsPresentInTable,
            int computedColumnsOffset,
            String typeDiscriminatorValue,
            String selection,
            String groupBy,
            String having) {
        String varB4EAC82CA7396A68D541C85D26508E83_1470638019 = null; //Variable for return #1
        int unionColumnsCount;
        unionColumnsCount = unionColumns.length;
        String[] projectionIn;
        projectionIn = new String[unionColumnsCount];
        {
            int i;
            i = 0;
            {
                String unionColumn;
                unionColumn = unionColumns[i];
                {
                    boolean varEE2D3B923A9856EBBD44CF35F85DDA8F_695705079 = (unionColumn.equals(typeDiscriminatorColumn));
                    {
                        projectionIn[i] = "'" + typeDiscriminatorValue + "' AS "
                        + typeDiscriminatorColumn;
                    } //End block
                    {
                        boolean var8CCCDA57FF3EE4F2C54EF7FC819C4A57_807121557 = (i <= computedColumnsOffset
                       || columnsPresentInTable.contains(unionColumn));
                        {
                            projectionIn[i] = unionColumn;
                        } //End block
                        {
                            projectionIn[i] = "NULL AS " + unionColumn;
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1470638019 = buildQuery(
                projectionIn, selection, groupBy, having,
                null ,
                null );
        addTaint(typeDiscriminatorColumn.getTaint());
        addTaint(unionColumns[0].getTaint());
        addTaint(columnsPresentInTable.getTaint());
        addTaint(computedColumnsOffset);
        addTaint(typeDiscriminatorValue.getTaint());
        addTaint(selection.getTaint());
        addTaint(groupBy.getTaint());
        addTaint(having.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1470638019.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1470638019;
        // ---------- Original Method ----------
        //int unionColumnsCount = unionColumns.length;
        //String[] projectionIn = new String[unionColumnsCount];
        //for (int i = 0; i < unionColumnsCount; i++) {
            //String unionColumn = unionColumns[i];
            //if (unionColumn.equals(typeDiscriminatorColumn)) {
                //projectionIn[i] = "'" + typeDiscriminatorValue + "' AS "
                        //+ typeDiscriminatorColumn;
            //} else if (i <= computedColumnsOffset
                       //|| columnsPresentInTable.contains(unionColumn)) {
                //projectionIn[i] = unionColumn;
            //} else {
                //projectionIn[i] = "NULL AS " + unionColumn;
            //}
        //}
        //return buildQuery(
                //projectionIn, selection, groupBy, having,
                //null ,
                //null );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.189 -0400", hash_original_method = "6C4D740E5B06C8AB5B016A4D8B83E2C6", hash_generated_method = "7A725669943844CD83ABF3B91FDA917E")
    @Deprecated
    public String buildUnionSubQuery(
            String typeDiscriminatorColumn,
            String[] unionColumns,
            Set<String> columnsPresentInTable,
            int computedColumnsOffset,
            String typeDiscriminatorValue,
            String selection,
            String[] selectionArgs,
            String groupBy,
            String having) {
        String varB4EAC82CA7396A68D541C85D26508E83_253897318 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_253897318 = buildUnionSubQuery(
                typeDiscriminatorColumn, unionColumns, columnsPresentInTable,
                computedColumnsOffset, typeDiscriminatorValue, selection,
                groupBy, having);
        addTaint(typeDiscriminatorColumn.getTaint());
        addTaint(unionColumns[0].getTaint());
        addTaint(columnsPresentInTable.getTaint());
        addTaint(computedColumnsOffset);
        addTaint(typeDiscriminatorValue.getTaint());
        addTaint(selection.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(groupBy.getTaint());
        addTaint(having.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_253897318.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_253897318;
        // ---------- Original Method ----------
        //return buildUnionSubQuery(
                //typeDiscriminatorColumn, unionColumns, columnsPresentInTable,
                //computedColumnsOffset, typeDiscriminatorValue, selection,
                //groupBy, having);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.197 -0400", hash_original_method = "870E9211222A33CDF50FFEE42B5AEA84", hash_generated_method = "3D11C4610B5E2916EF86103B4BF9524D")
    public String buildUnionQuery(String[] subQueries, String sortOrder, String limit) {
        String varB4EAC82CA7396A68D541C85D26508E83_2043747210 = null; //Variable for return #1
        StringBuilder query;
        query = new StringBuilder(128);
        int subQueryCount;
        subQueryCount = subQueries.length;
        String unionOperator;
        unionOperator = " UNION ";
        unionOperator = " UNION ALL ";
        {
            int i;
            i = 0;
            {
                {
                    query.append(unionOperator);
                } //End block
                query.append(subQueries[i]);
            } //End block
        } //End collapsed parenthetic
        appendClause(query, " ORDER BY ", sortOrder);
        appendClause(query, " LIMIT ", limit);
        varB4EAC82CA7396A68D541C85D26508E83_2043747210 = query.toString();
        addTaint(subQueries[0].getTaint());
        addTaint(sortOrder.getTaint());
        addTaint(limit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2043747210.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2043747210;
        // ---------- Original Method ----------
        //StringBuilder query = new StringBuilder(128);
        //int subQueryCount = subQueries.length;
        //String unionOperator = mDistinct ? " UNION " : " UNION ALL ";
        //for (int i = 0; i < subQueryCount; i++) {
            //if (i > 0) {
                //query.append(unionOperator);
            //}
            //query.append(subQueries[i]);
        //}
        //appendClause(query, " ORDER BY ", sortOrder);
        //appendClause(query, " LIMIT ", limit);
        //return query.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.209 -0400", hash_original_method = "37AD514842546773747C53CA078B5ACE", hash_generated_method = "2A3FEDD1A7A38E103DA595BC9FC2B0D8")
    private String[] computeProjection(String[] projectionIn) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_761337991 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_1408668671 = null; //Variable for return #2
        String[] varB4EAC82CA7396A68D541C85D26508E83_86087897 = null; //Variable for return #3
        String[] varB4EAC82CA7396A68D541C85D26508E83_33014096 = null; //Variable for return #4
        {
            {
                String[] projection;
                projection = new String[projectionIn.length];
                int length;
                length = projectionIn.length;
                {
                    int i;
                    i = 0;
                    {
                        String userColumn;
                        userColumn = projectionIn[i];
                        String column;
                        column = mProjectionMap.get(userColumn);
                        {
                            projection[i] = column;
                        } //End block
                        {
                            boolean var99AA437685C808418B23C85778263149_1822984828 = (!mStrict &&
                            ( userColumn.contains(" AS ") || userColumn.contains(" as ")));
                            {
                                projection[i] = userColumn;
                            } //End block
                        } //End collapsed parenthetic
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid column "
                            + projectionIn[i]);
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_761337991 = projection;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1408668671 = projectionIn;
            } //End block
        } //End block
        {
            Set<Entry<String, String>> entrySet;
            entrySet = mProjectionMap.entrySet();
            String[] projection;
            projection = new String[entrySet.size()];
            Iterator<Entry<String, String>> entryIter;
            entryIter = entrySet.iterator();
            int i;
            i = 0;
            {
                boolean varC38192A7CEBA362BA42047FB692ED895_876305511 = (entryIter.hasNext());
                {
                    Entry<String, String> entry;
                    entry = entryIter.next();
                    {
                        boolean var259E335C27C5828A024F1EFCDEF7B5FA_370505984 = (entry.getKey().equals(BaseColumns._COUNT));
                    } //End collapsed parenthetic
                    projection[i++] = entry.getValue();
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_86087897 = projection;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_33014096 = null;
        addTaint(projectionIn[0].getTaint());
        String[] varA7E53CE21691AB073D9660D615818899_1809937439; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1809937439 = varB4EAC82CA7396A68D541C85D26508E83_761337991;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1809937439 = varB4EAC82CA7396A68D541C85D26508E83_1408668671;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1809937439 = varB4EAC82CA7396A68D541C85D26508E83_86087897;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1809937439 = varB4EAC82CA7396A68D541C85D26508E83_33014096;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1809937439.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1809937439;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.209 -0400", hash_original_field = "9C8EED53DDB7737D7F02CB334DF9AF58", hash_generated_field = "26E38749F29C285F9E388248AB7BF436")

    private static String TAG = "SQLiteQueryBuilder";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.209 -0400", hash_original_field = "2F52A8FF47786EBFC843A29274CE4072", hash_generated_field = "AE2C87AE526C4163C6BB0C630CD20761")

    private static Pattern sLimitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
}

