package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.201 -0400", hash_original_field = "CAC1605D9B4F31C278921D5EA4DD178B", hash_generated_field = "769F77C34DE42382B188666E269E7701")

    private Map<String, String> mProjectionMap = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.201 -0400", hash_original_field = "9AFED356017DBD96BEA037FB628DD7E5", hash_generated_field = "8F885C16B9BDADDFD8C26FCD5BE5228C")

    private String mTables = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.202 -0400", hash_original_field = "3073694C7BCC7C209803EDAC9D081570", hash_generated_field = "AA43CCC2518697E93036E759BA68D945")

    private StringBuilder mWhereClause = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.202 -0400", hash_original_field = "097E4446BDCC69C5664BA85E4A99402A", hash_generated_field = "A56C1C3192C3259733D99B7B9797B9BD")

    private boolean mDistinct;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.202 -0400", hash_original_field = "06389DE86ED19AB1571A41645A1AFADC", hash_generated_field = "B3A21B3E4C20F1E737FF55A7E08BB6E5")

    private SQLiteDatabase.CursorFactory mFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.202 -0400", hash_original_field = "89640C202140B2F2E90FF0FCFBB5A040", hash_generated_field = "52E2A3AFF0ECDB0477697EA761229425")

    private boolean mStrict;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.203 -0400", hash_original_method = "841FC2D35CC9552E307358F36A673D72", hash_generated_method = "7743D13935D2A6130C706962EEE16D30")
    public  SQLiteQueryBuilder() {
        mDistinct = false;
        mFactory = null;
        // ---------- Original Method ----------
        //mDistinct = false;
        //mFactory = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.203 -0400", hash_original_method = "9A9512BC3B93773BE1B8C3DEAB4EDCF7", hash_generated_method = "04E5D28A4FA7008D9677964C6DA606F3")
    public void setDistinct(boolean distinct) {
        mDistinct = distinct;
        // ---------- Original Method ----------
        //mDistinct = distinct;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.204 -0400", hash_original_method = "71A35CB8526DF402EA58F5074639A5D5", hash_generated_method = "E038E828A34244E633769B36E1210114")
    public String getTables() {
String varDFAC709EF682E7EE77A36551B3D5FA40_861799118 =         mTables;
        varDFAC709EF682E7EE77A36551B3D5FA40_861799118.addTaint(taint);
        return varDFAC709EF682E7EE77A36551B3D5FA40_861799118;
        // ---------- Original Method ----------
        //return mTables;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.204 -0400", hash_original_method = "3D5C8D5A2DF23857F8B36CBC126449F5", hash_generated_method = "8A78A70CC3C87FBE05086EC3C4609F92")
    public void setTables(String inTables) {
        mTables = inTables;
        // ---------- Original Method ----------
        //mTables = inTables;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.205 -0400", hash_original_method = "4066C27D90FD6AEEDB747E2D0A255B82", hash_generated_method = "B25AAE77F970461803CCD21018C846A5")
    public void appendWhere(CharSequence inWhere) {
    if(mWhereClause == null)        
        {
            mWhereClause = new StringBuilder(inWhere.length() + 16);
        } //End block
    if(mWhereClause.length() == 0)        
        {
            mWhereClause.append('(');
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.206 -0400", hash_original_method = "CD89033A6A424354FBAEE4A7B7BB0312", hash_generated_method = "450FEC29316E94980C9763526705C9D9")
    public void appendWhereEscapeString(String inWhere) {
    if(mWhereClause == null)        
        {
            mWhereClause = new StringBuilder(inWhere.length() + 16);
        } //End block
    if(mWhereClause.length() == 0)        
        {
            mWhereClause.append('(');
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.207 -0400", hash_original_method = "DDD8D9F6C39192C696789E3C5816355A", hash_generated_method = "52ECEFBD4BAF572978D68E44F502DFAD")
    public void setProjectionMap(Map<String, String> columnMap) {
        mProjectionMap = columnMap;
        // ---------- Original Method ----------
        //mProjectionMap = columnMap;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.207 -0400", hash_original_method = "9A5AF21719138D1250197FB20CA33704", hash_generated_method = "1239112BA6697D38A5EBA247B91110D9")
    public void setCursorFactory(SQLiteDatabase.CursorFactory factory) {
        mFactory = factory;
        // ---------- Original Method ----------
        //mFactory = factory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.208 -0400", hash_original_method = "20B77E17A7BDAD72AFE7C926EABDA9FA", hash_generated_method = "42BC386A940F34BA3758B62F79108296")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.210 -0400", hash_original_method = "C851DFBDB6501381AF55260B14586647", hash_generated_method = "FDEDA5A8A68D8D803EEC6751807F8A09")
    public Cursor query(SQLiteDatabase db, String[] projectionIn,
            String selection, String[] selectionArgs, String groupBy,
            String having, String sortOrder) {
        addTaint(sortOrder.getTaint());
        addTaint(having.getTaint());
        addTaint(groupBy.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(projectionIn[0].getTaint());
        addTaint(db.getTaint());
Cursor var010D04419F95D543F4A35097C893B344_1855855830 =         query(db, projectionIn, selection, selectionArgs, groupBy, having, sortOrder,
                null );
        var010D04419F95D543F4A35097C893B344_1855855830.addTaint(taint);
        return var010D04419F95D543F4A35097C893B344_1855855830;
        // ---------- Original Method ----------
        //return query(db, projectionIn, selection, selectionArgs, groupBy, having, sortOrder,
                //null );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.211 -0400", hash_original_method = "A22563797EE8B98D8D2C96F4FC0F2C77", hash_generated_method = "C5328FADC070570B966E45207F48AFBD")
    public Cursor query(SQLiteDatabase db, String[] projectionIn,
            String selection, String[] selectionArgs, String groupBy,
            String having, String sortOrder, String limit) {
        addTaint(limit.getTaint());
        addTaint(sortOrder.getTaint());
        addTaint(having.getTaint());
        addTaint(groupBy.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(projectionIn[0].getTaint());
        addTaint(db.getTaint());
    if(mTables == null)        
        {
Cursor var540C13E9E156B687226421B24F2DF178_1932729864 =             null;
            var540C13E9E156B687226421B24F2DF178_1932729864.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1932729864;
        } //End block
    if(mStrict && selection != null && selection.length() > 0)        
        {
            String sqlForValidation = buildQuery(projectionIn, "(" + selection + ")", groupBy,
                    having, sortOrder, limit);
            validateSql(db, sqlForValidation);
        } //End block
        String sql = buildQuery(
                projectionIn, selection, groupBy, having,
                sortOrder, limit);
    if(Log.isLoggable(TAG, Log.DEBUG))        
        {
            Log.d(TAG, "Performing query: " + sql);
        } //End block
Cursor var12E0F7DE1781C915D060A2E700D32EBB_1957223874 =         db.rawQueryWithFactory(
                mFactory, sql, selectionArgs,
                SQLiteDatabase.findEditTable(mTables));
        var12E0F7DE1781C915D060A2E700D32EBB_1957223874.addTaint(taint);
        return var12E0F7DE1781C915D060A2E700D32EBB_1957223874;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.211 -0400", hash_original_method = "A033D274CBE9E5A0C4BD18FE9EA6496C", hash_generated_method = "E024B6162D1ABDCE5627DC751D3C8BA8")
    private void validateSql(SQLiteDatabase db, String sql) {
        addTaint(sql.getTaint());
        addTaint(db.getTaint());
        db.lock(sql);
        try 
        {
            new SQLiteCompiledSql(db, sql).releaseSqlStatement();
        } //End block
        finally 
        {
            db.unlock();
        } //End block
        // ---------- Original Method ----------
        //db.lock(sql);
        //try {
            //new SQLiteCompiledSql(db, sql).releaseSqlStatement();
        //} finally {
            //db.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.212 -0400", hash_original_method = "131EA8692C493A86BCD7B59A8B1306F4", hash_generated_method = "289052F7E68CE376C9760DA4FFC0CC0A")
    public String buildQuery(
            String[] projectionIn, String selection, String groupBy,
            String having, String sortOrder, String limit) {
        addTaint(limit.getTaint());
        addTaint(sortOrder.getTaint());
        addTaint(having.getTaint());
        addTaint(groupBy.getTaint());
        addTaint(selection.getTaint());
        addTaint(projectionIn[0].getTaint());
        String[] projection = computeProjection(projectionIn);
        StringBuilder where = new StringBuilder();
        boolean hasBaseWhereClause = mWhereClause != null && mWhereClause.length() > 0;
    if(hasBaseWhereClause)        
        {
            where.append(mWhereClause.toString());
            where.append(')');
        } //End block
    if(selection != null && selection.length() > 0)        
        {
    if(hasBaseWhereClause)            
            {
                where.append(" AND ");
            } //End block
            where.append('(');
            where.append(selection);
            where.append(')');
        } //End block
String var236D2A0B1C8E8F9FF2BF69EB168E582B_1318064334 =         buildQueryString(
                mDistinct, mTables, projection, where.toString(),
                groupBy, having, sortOrder, limit);
        var236D2A0B1C8E8F9FF2BF69EB168E582B_1318064334.addTaint(taint);
        return var236D2A0B1C8E8F9FF2BF69EB168E582B_1318064334;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.213 -0400", hash_original_method = "D5409D707055983A8E689AC969CBA872", hash_generated_method = "D388CBB4515757E44CBD3D28AE81ECFC")
    @Deprecated
    public String buildQuery(
            String[] projectionIn, String selection, String[] selectionArgs,
            String groupBy, String having, String sortOrder, String limit) {
        addTaint(limit.getTaint());
        addTaint(sortOrder.getTaint());
        addTaint(having.getTaint());
        addTaint(groupBy.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(projectionIn[0].getTaint());
String var27F7D9905AFAE2B7B4A780252CB654AE_1923964249 =         buildQuery(projectionIn, selection, groupBy, having, sortOrder, limit);
        var27F7D9905AFAE2B7B4A780252CB654AE_1923964249.addTaint(taint);
        return var27F7D9905AFAE2B7B4A780252CB654AE_1923964249;
        // ---------- Original Method ----------
        //return buildQuery(projectionIn, selection, groupBy, having, sortOrder, limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.215 -0400", hash_original_method = "579B4F5DF75F7C70B58361D381AB3677", hash_generated_method = "BFF1778C32A6BCBD4A6D59928FDDC2E4")
    public String buildUnionSubQuery(
            String typeDiscriminatorColumn,
            String[] unionColumns,
            Set<String> columnsPresentInTable,
            int computedColumnsOffset,
            String typeDiscriminatorValue,
            String selection,
            String groupBy,
            String having) {
        addTaint(having.getTaint());
        addTaint(groupBy.getTaint());
        addTaint(selection.getTaint());
        addTaint(typeDiscriminatorValue.getTaint());
        addTaint(computedColumnsOffset);
        addTaint(columnsPresentInTable.getTaint());
        addTaint(unionColumns[0].getTaint());
        addTaint(typeDiscriminatorColumn.getTaint());
        int unionColumnsCount = unionColumns.length;
        String[] projectionIn = new String[unionColumnsCount];
for(int i = 0;i < unionColumnsCount;i++)
        {
            String unionColumn = unionColumns[i];
    if(unionColumn.equals(typeDiscriminatorColumn))            
            {
                projectionIn[i] = "'" + typeDiscriminatorValue + "' AS "
                        + typeDiscriminatorColumn;
            } //End block
            else
    if(i <= computedColumnsOffset
                       || columnsPresentInTable.contains(unionColumn))            
            {
                projectionIn[i] = unionColumn;
            } //End block
            else
            {
                projectionIn[i] = "NULL AS " + unionColumn;
            } //End block
        } //End block
String var097A97A35346D121779DBBE760699D3E_1292901762 =         buildQuery(
                projectionIn, selection, groupBy, having,
                null ,
                null );
        var097A97A35346D121779DBBE760699D3E_1292901762.addTaint(taint);
        return var097A97A35346D121779DBBE760699D3E_1292901762;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.216 -0400", hash_original_method = "6C4D740E5B06C8AB5B016A4D8B83E2C6", hash_generated_method = "71F76D657624A5378D33C33DFFBE7EF3")
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
        addTaint(having.getTaint());
        addTaint(groupBy.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(typeDiscriminatorValue.getTaint());
        addTaint(computedColumnsOffset);
        addTaint(columnsPresentInTable.getTaint());
        addTaint(unionColumns[0].getTaint());
        addTaint(typeDiscriminatorColumn.getTaint());
String var0743EC5E411E1095EAA717524958A67B_1110171384 =         buildUnionSubQuery(
                typeDiscriminatorColumn, unionColumns, columnsPresentInTable,
                computedColumnsOffset, typeDiscriminatorValue, selection,
                groupBy, having);
        var0743EC5E411E1095EAA717524958A67B_1110171384.addTaint(taint);
        return var0743EC5E411E1095EAA717524958A67B_1110171384;
        // ---------- Original Method ----------
        //return buildUnionSubQuery(
                //typeDiscriminatorColumn, unionColumns, columnsPresentInTable,
                //computedColumnsOffset, typeDiscriminatorValue, selection,
                //groupBy, having);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.217 -0400", hash_original_method = "870E9211222A33CDF50FFEE42B5AEA84", hash_generated_method = "739D4AA15CD669C3411C5F549AC732E6")
    public String buildUnionQuery(String[] subQueries, String sortOrder, String limit) {
        addTaint(limit.getTaint());
        addTaint(sortOrder.getTaint());
        addTaint(subQueries[0].getTaint());
        StringBuilder query = new StringBuilder(128);
        int subQueryCount = subQueries.length;
        String unionOperator = mDistinct ? " UNION " : " UNION ALL ";
for(int i = 0;i < subQueryCount;i++)
        {
    if(i > 0)            
            {
                query.append(unionOperator);
            } //End block
            query.append(subQueries[i]);
        } //End block
        appendClause(query, " ORDER BY ", sortOrder);
        appendClause(query, " LIMIT ", limit);
String varE73198DDFB7E7C53E7B645B55E7AD475_262871224 =         query.toString();
        varE73198DDFB7E7C53E7B645B55E7AD475_262871224.addTaint(taint);
        return varE73198DDFB7E7C53E7B645B55E7AD475_262871224;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.218 -0400", hash_original_method = "37AD514842546773747C53CA078B5ACE", hash_generated_method = "87DEE05C51FEBA86C2E32B63EFF9F35B")
    private String[] computeProjection(String[] projectionIn) {
        addTaint(projectionIn[0].getTaint());
    if(projectionIn != null && projectionIn.length > 0)        
        {
    if(mProjectionMap != null)            
            {
                String[] projection = new String[projectionIn.length];
                int length = projectionIn.length;
for(int i = 0;i < length;i++)
                {
                    String userColumn = projectionIn[i];
                    String column = mProjectionMap.get(userColumn);
    if(column != null)                    
                    {
                        projection[i] = column;
                        continue;
                    } //End block
    if(!mStrict &&
                            ( userColumn.contains(" AS ") || userColumn.contains(" as ")))                    
                    {
                        projection[i] = userColumn;
                        continue;
                    } //End block
                    IllegalArgumentException var6181138E8BB0488B74FEFEEAD0D0B020_2059223948 = new IllegalArgumentException("Invalid column "
                            + projectionIn[i]);
                    var6181138E8BB0488B74FEFEEAD0D0B020_2059223948.addTaint(taint);
                    throw var6181138E8BB0488B74FEFEEAD0D0B020_2059223948;
                } //End block
String[] var53A5863805B8B24BD4F7350992F637F5_1892170817 =                 projection;
                var53A5863805B8B24BD4F7350992F637F5_1892170817.addTaint(taint);
                return var53A5863805B8B24BD4F7350992F637F5_1892170817;
            } //End block
            else
            {
String[] var536B1970813628617C7353223955A3EE_203688373 =                 projectionIn;
                var536B1970813628617C7353223955A3EE_203688373.addTaint(taint);
                return var536B1970813628617C7353223955A3EE_203688373;
            } //End block
        } //End block
        else
    if(mProjectionMap != null)        
        {
            Set<Entry<String, String>> entrySet = mProjectionMap.entrySet();
            String[] projection = new String[entrySet.size()];
            Iterator<Entry<String, String>> entryIter = entrySet.iterator();
            int i = 0;
            while
(entryIter.hasNext())            
            {
                Entry<String, String> entry = entryIter.next();
    if(entry.getKey().equals(BaseColumns._COUNT))                
                {
                    continue;
                } //End block
                projection[i++] = entry.getValue();
            } //End block
String[] var53A5863805B8B24BD4F7350992F637F5_122050701 =             projection;
            var53A5863805B8B24BD4F7350992F637F5_122050701.addTaint(taint);
            return var53A5863805B8B24BD4F7350992F637F5_122050701;
        } //End block
String[] var540C13E9E156B687226421B24F2DF178_1734455734 =         null;
        var540C13E9E156B687226421B24F2DF178_1734455734.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1734455734;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.219 -0400", hash_original_field = "9C8EED53DDB7737D7F02CB334DF9AF58", hash_generated_field = "4E4A0EABB322720F9E96EF500187126A")

    private static final String TAG = "SQLiteQueryBuilder";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.219 -0400", hash_original_field = "2F52A8FF47786EBFC843A29274CE4072", hash_generated_field = "A91426785D8E749A1E39A5FB97B565C7")

    private static final Pattern sLimitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
}

