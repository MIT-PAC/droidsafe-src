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
    private Map<String, String> mProjectionMap = null;
    private String mTables = "";
    private StringBuilder mWhereClause = null;
    private boolean mDistinct;
    private SQLiteDatabase.CursorFactory mFactory;
    private boolean mStrict;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.896 -0400", hash_original_method = "841FC2D35CC9552E307358F36A673D72", hash_generated_method = "7743D13935D2A6130C706962EEE16D30")
    @DSModeled(DSC.SAFE)
    public SQLiteQueryBuilder() {
        mDistinct = false;
        mFactory = null;
        // ---------- Original Method ----------
        //mDistinct = false;
        //mFactory = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.897 -0400", hash_original_method = "9A9512BC3B93773BE1B8C3DEAB4EDCF7", hash_generated_method = "4401459A7F43B4D3E7288B494738BED1")
    @DSModeled(DSC.SAFE)
    public void setDistinct(boolean distinct) {
        dsTaint.addTaint(distinct);
        // ---------- Original Method ----------
        //mDistinct = distinct;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.897 -0400", hash_original_method = "71A35CB8526DF402EA58F5074639A5D5", hash_generated_method = "EB7B167643C3D9A7B8D39D91207D6F5B")
    @DSModeled(DSC.SAFE)
    public String getTables() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mTables;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.897 -0400", hash_original_method = "3D5C8D5A2DF23857F8B36CBC126449F5", hash_generated_method = "EB030C24C451BDA4C9DE5E3332223CBC")
    @DSModeled(DSC.SAFE)
    public void setTables(String inTables) {
        dsTaint.addTaint(inTables);
        // ---------- Original Method ----------
        //mTables = inTables;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.897 -0400", hash_original_method = "4066C27D90FD6AEEDB747E2D0A255B82", hash_generated_method = "AC50908351B47538E29F0A9BF85B10E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void appendWhere(CharSequence inWhere) {
        dsTaint.addTaint(inWhere);
        {
            mWhereClause = new StringBuilder(inWhere.length() + 16);
        } //End block
        {
            boolean var684378E5464B4E4DF3A428AF47BF8D84_1476736410 = (mWhereClause.length() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.898 -0400", hash_original_method = "CD89033A6A424354FBAEE4A7B7BB0312", hash_generated_method = "CF478AD74EEE72C89715F402DE4B7694")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void appendWhereEscapeString(String inWhere) {
        dsTaint.addTaint(inWhere);
        {
            mWhereClause = new StringBuilder(inWhere.length() + 16);
        } //End block
        {
            boolean var684378E5464B4E4DF3A428AF47BF8D84_662194983 = (mWhereClause.length() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.898 -0400", hash_original_method = "DDD8D9F6C39192C696789E3C5816355A", hash_generated_method = "4FD9647F3F2B79ADCE1D2D202311CD59")
    @DSModeled(DSC.SAFE)
    public void setProjectionMap(Map<String, String> columnMap) {
        dsTaint.addTaint(columnMap.dsTaint);
        // ---------- Original Method ----------
        //mProjectionMap = columnMap;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.898 -0400", hash_original_method = "9A5AF21719138D1250197FB20CA33704", hash_generated_method = "189EA1984396551FDD019DCB21C1D5FC")
    @DSModeled(DSC.SAFE)
    public void setCursorFactory(SQLiteDatabase.CursorFactory factory) {
        dsTaint.addTaint(factory.dsTaint);
        // ---------- Original Method ----------
        //mFactory = factory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.898 -0400", hash_original_method = "20B77E17A7BDAD72AFE7C926EABDA9FA", hash_generated_method = "6D396A223E8ACE6BD18854FD00BC7923")
    @DSModeled(DSC.SAFE)
    public void setStrict(boolean flag) {
        dsTaint.addTaint(flag);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.899 -0400", hash_original_method = "C851DFBDB6501381AF55260B14586647", hash_generated_method = "CC34DE7D38801485E32C08918587D42C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Cursor query(SQLiteDatabase db, String[] projectionIn,
            String selection, String[] selectionArgs, String groupBy,
            String having, String sortOrder) {
        dsTaint.addTaint(groupBy);
        dsTaint.addTaint(db.dsTaint);
        dsTaint.addTaint(selectionArgs[0]);
        dsTaint.addTaint(projectionIn[0]);
        dsTaint.addTaint(sortOrder);
        dsTaint.addTaint(having);
        dsTaint.addTaint(selection);
        Cursor var6C07F48A11B06B9A84F0EBAB44D0F75E_860270963 = (query(db, projectionIn, selection, selectionArgs, groupBy, having, sortOrder,
                null ));
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return query(db, projectionIn, selection, selectionArgs, groupBy, having, sortOrder,
                //null );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.900 -0400", hash_original_method = "A22563797EE8B98D8D2C96F4FC0F2C77", hash_generated_method = "E1CD8AFA9BAFB0EB087517295245E25D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Cursor query(SQLiteDatabase db, String[] projectionIn,
            String selection, String[] selectionArgs, String groupBy,
            String having, String sortOrder, String limit) {
        dsTaint.addTaint(limit);
        dsTaint.addTaint(groupBy);
        dsTaint.addTaint(db.dsTaint);
        dsTaint.addTaint(selectionArgs[0]);
        dsTaint.addTaint(projectionIn[0]);
        dsTaint.addTaint(sortOrder);
        dsTaint.addTaint(having);
        dsTaint.addTaint(selection);
        {
            boolean varA87A577568BFC2D77CF995C5491CA98D_1397854733 = (mStrict && selection != null && selection.length() > 0);
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
            boolean var7061DF8A5335B809C796044C2A062407_1372870747 = (Log.isLoggable(TAG, Log.DEBUG));
            {
                Log.d(TAG, "Performing query: " + sql);
            } //End block
        } //End collapsed parenthetic
        Cursor var9ECD582C8DA669A2E1BF45BB65446BD0_1991679573 = (db.rawQueryWithFactory(
                mFactory, sql, selectionArgs,
                SQLiteDatabase.findEditTable(mTables)));
        return (Cursor)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.900 -0400", hash_original_method = "A033D274CBE9E5A0C4BD18FE9EA6496C", hash_generated_method = "29E8DFB15C8FB3A3CA96A3795D6444BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void validateSql(SQLiteDatabase db, String sql) {
        dsTaint.addTaint(db.dsTaint);
        dsTaint.addTaint(sql);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.901 -0400", hash_original_method = "131EA8692C493A86BCD7B59A8B1306F4", hash_generated_method = "1857CCCB2F68E7704E548A927BC8C06F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String buildQuery(
            String[] projectionIn, String selection, String groupBy,
            String having, String sortOrder, String limit) {
        dsTaint.addTaint(limit);
        dsTaint.addTaint(groupBy);
        dsTaint.addTaint(projectionIn[0]);
        dsTaint.addTaint(sortOrder);
        dsTaint.addTaint(having);
        dsTaint.addTaint(selection);
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
            boolean varA1B7D4902A1967FE05483484790F8DD9_316952492 = (selection != null && selection.length() > 0);
            {
                {
                    where.append(" AND ");
                } //End block
                where.append('(');
                where.append(selection);
                where.append(')');
            } //End block
        } //End collapsed parenthetic
        String varC26EBEE481B742063D0DD17792E7DA13_1062385875 = (buildQueryString(
                mDistinct, mTables, projection, where.toString(),
                groupBy, having, sortOrder, limit));
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.901 -0400", hash_original_method = "D5409D707055983A8E689AC969CBA872", hash_generated_method = "36977AC49D674CA8C49AF077AF34BAD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public String buildQuery(
            String[] projectionIn, String selection, String[] selectionArgs,
            String groupBy, String having, String sortOrder, String limit) {
        dsTaint.addTaint(limit);
        dsTaint.addTaint(groupBy);
        dsTaint.addTaint(selectionArgs[0]);
        dsTaint.addTaint(projectionIn[0]);
        dsTaint.addTaint(sortOrder);
        dsTaint.addTaint(having);
        dsTaint.addTaint(selection);
        String varE2727CC092BF9F0CF07CCC994A299374_960600822 = (buildQuery(projectionIn, selection, groupBy, having, sortOrder, limit));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return buildQuery(projectionIn, selection, groupBy, having, sortOrder, limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.902 -0400", hash_original_method = "579B4F5DF75F7C70B58361D381AB3677", hash_generated_method = "AEF3A4D6F11E1EF5D3587A3852CF8479")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String buildUnionSubQuery(
            String typeDiscriminatorColumn,
            String[] unionColumns,
            Set<String> columnsPresentInTable,
            int computedColumnsOffset,
            String typeDiscriminatorValue,
            String selection,
            String groupBy,
            String having) {
        dsTaint.addTaint(groupBy);
        dsTaint.addTaint(unionColumns[0]);
        dsTaint.addTaint(having);
        dsTaint.addTaint(typeDiscriminatorColumn);
        dsTaint.addTaint(columnsPresentInTable.dsTaint);
        dsTaint.addTaint(selection);
        dsTaint.addTaint(typeDiscriminatorValue);
        dsTaint.addTaint(computedColumnsOffset);
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
                    boolean varEE2D3B923A9856EBBD44CF35F85DDA8F_206471834 = (unionColumn.equals(typeDiscriminatorColumn));
                    {
                        projectionIn[i] = "'" + typeDiscriminatorValue + "' AS "
                        + typeDiscriminatorColumn;
                    } //End block
                    {
                        boolean var8CCCDA57FF3EE4F2C54EF7FC819C4A57_474184609 = (i <= computedColumnsOffset
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
        String varE2E5396880B43BCB49E6FED52A7A91A5_98200249 = (buildQuery(
                projectionIn, selection, groupBy, having,
                null ,
                null ));
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.902 -0400", hash_original_method = "6C4D740E5B06C8AB5B016A4D8B83E2C6", hash_generated_method = "4C0BC1C905A49E5903EA79A895168BC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        dsTaint.addTaint(groupBy);
        dsTaint.addTaint(unionColumns[0]);
        dsTaint.addTaint(selectionArgs[0]);
        dsTaint.addTaint(having);
        dsTaint.addTaint(typeDiscriminatorColumn);
        dsTaint.addTaint(columnsPresentInTable.dsTaint);
        dsTaint.addTaint(selection);
        dsTaint.addTaint(typeDiscriminatorValue);
        dsTaint.addTaint(computedColumnsOffset);
        String var9B5F867F285F56BB185CDCEF4553C166_1577418899 = (buildUnionSubQuery(
                typeDiscriminatorColumn, unionColumns, columnsPresentInTable,
                computedColumnsOffset, typeDiscriminatorValue, selection,
                groupBy, having));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return buildUnionSubQuery(
                //typeDiscriminatorColumn, unionColumns, columnsPresentInTable,
                //computedColumnsOffset, typeDiscriminatorValue, selection,
                //groupBy, having);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.902 -0400", hash_original_method = "870E9211222A33CDF50FFEE42B5AEA84", hash_generated_method = "D17D17412E6E3DE17151B3E5692D208C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String buildUnionQuery(String[] subQueries, String sortOrder, String limit) {
        dsTaint.addTaint(limit);
        dsTaint.addTaint(subQueries[0]);
        dsTaint.addTaint(sortOrder);
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
        String var85B983C9A245B5D8301B285F22BB7BCA_1388831012 = (query.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.903 -0400", hash_original_method = "37AD514842546773747C53CA078B5ACE", hash_generated_method = "DA241B66DB51B48D29F1692BB51BCDF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String[] computeProjection(String[] projectionIn) {
        dsTaint.addTaint(projectionIn[0]);
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
                            boolean var99AA437685C808418B23C85778263149_918923155 = (!mStrict &&
                            ( userColumn.contains(" AS ") || userColumn.contains(" as ")));
                            {
                                projection[i] = userColumn;
                            } //End block
                        } //End collapsed parenthetic
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid column "
                            + projectionIn[i]);
                    } //End block
                } //End collapsed parenthetic
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
                boolean varC38192A7CEBA362BA42047FB692ED895_18186310 = (entryIter.hasNext());
                {
                    Entry<String, String> entry;
                    entry = entryIter.next();
                    {
                        boolean var259E335C27C5828A024F1EFCDEF7B5FA_1417862067 = (entry.getKey().equals(BaseColumns._COUNT));
                    } //End collapsed parenthetic
                    projection[i++] = entry.getValue();
                } //End block
            } //End collapsed parenthetic
        } //End block
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static final String TAG = "SQLiteQueryBuilder";
    private static final Pattern sLimitPattern =
            Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
}

