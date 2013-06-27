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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.531 -0400", hash_original_field = "CAC1605D9B4F31C278921D5EA4DD178B", hash_generated_field = "769F77C34DE42382B188666E269E7701")

    private Map<String, String> mProjectionMap = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.531 -0400", hash_original_field = "9AFED356017DBD96BEA037FB628DD7E5", hash_generated_field = "8F885C16B9BDADDFD8C26FCD5BE5228C")

    private String mTables = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.531 -0400", hash_original_field = "3073694C7BCC7C209803EDAC9D081570", hash_generated_field = "AA43CCC2518697E93036E759BA68D945")

    private StringBuilder mWhereClause = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.531 -0400", hash_original_field = "097E4446BDCC69C5664BA85E4A99402A", hash_generated_field = "A56C1C3192C3259733D99B7B9797B9BD")

    private boolean mDistinct;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.531 -0400", hash_original_field = "06389DE86ED19AB1571A41645A1AFADC", hash_generated_field = "B3A21B3E4C20F1E737FF55A7E08BB6E5")

    private SQLiteDatabase.CursorFactory mFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.531 -0400", hash_original_field = "89640C202140B2F2E90FF0FCFBB5A040", hash_generated_field = "52E2A3AFF0ECDB0477697EA761229425")

    private boolean mStrict;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.532 -0400", hash_original_method = "841FC2D35CC9552E307358F36A673D72", hash_generated_method = "7743D13935D2A6130C706962EEE16D30")
    public  SQLiteQueryBuilder() {
        mDistinct = false;
        mFactory = null;
        // ---------- Original Method ----------
        //mDistinct = false;
        //mFactory = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.533 -0400", hash_original_method = "9A9512BC3B93773BE1B8C3DEAB4EDCF7", hash_generated_method = "04E5D28A4FA7008D9677964C6DA606F3")
    public void setDistinct(boolean distinct) {
        mDistinct = distinct;
        // ---------- Original Method ----------
        //mDistinct = distinct;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.533 -0400", hash_original_method = "71A35CB8526DF402EA58F5074639A5D5", hash_generated_method = "3272F652D0089E6177C133F1235C2523")
    public String getTables() {
        String varB4EAC82CA7396A68D541C85D26508E83_1008806253 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1008806253 = mTables;
        varB4EAC82CA7396A68D541C85D26508E83_1008806253.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1008806253;
        // ---------- Original Method ----------
        //return mTables;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.542 -0400", hash_original_method = "3D5C8D5A2DF23857F8B36CBC126449F5", hash_generated_method = "8A78A70CC3C87FBE05086EC3C4609F92")
    public void setTables(String inTables) {
        mTables = inTables;
        // ---------- Original Method ----------
        //mTables = inTables;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.545 -0400", hash_original_method = "4066C27D90FD6AEEDB747E2D0A255B82", hash_generated_method = "E9E8FAB6990AE0BE9CAA63A57E1C9600")
    public void appendWhere(CharSequence inWhere) {
        {
            mWhereClause = new StringBuilder(inWhere.length() + 16);
        } //End block
        {
            boolean var684378E5464B4E4DF3A428AF47BF8D84_57356778 = (mWhereClause.length() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.573 -0400", hash_original_method = "CD89033A6A424354FBAEE4A7B7BB0312", hash_generated_method = "BFDA0E53CF3C2F837605EB9897DFEF0F")
    public void appendWhereEscapeString(String inWhere) {
        {
            mWhereClause = new StringBuilder(inWhere.length() + 16);
        } //End block
        {
            boolean var684378E5464B4E4DF3A428AF47BF8D84_509795137 = (mWhereClause.length() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.574 -0400", hash_original_method = "DDD8D9F6C39192C696789E3C5816355A", hash_generated_method = "52ECEFBD4BAF572978D68E44F502DFAD")
    public void setProjectionMap(Map<String, String> columnMap) {
        mProjectionMap = columnMap;
        // ---------- Original Method ----------
        //mProjectionMap = columnMap;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.575 -0400", hash_original_method = "9A5AF21719138D1250197FB20CA33704", hash_generated_method = "1239112BA6697D38A5EBA247B91110D9")
    public void setCursorFactory(SQLiteDatabase.CursorFactory factory) {
        mFactory = factory;
        // ---------- Original Method ----------
        //mFactory = factory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.576 -0400", hash_original_method = "20B77E17A7BDAD72AFE7C926EABDA9FA", hash_generated_method = "42BC386A940F34BA3758B62F79108296")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.596 -0400", hash_original_method = "C851DFBDB6501381AF55260B14586647", hash_generated_method = "7518FD241E408428095B73E7997E46D9")
    public Cursor query(SQLiteDatabase db, String[] projectionIn,
            String selection, String[] selectionArgs, String groupBy,
            String having, String sortOrder) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_2084436340 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2084436340 = query(db, projectionIn, selection, selectionArgs, groupBy, having, sortOrder,
                null );
        addTaint(db.getTaint());
        addTaint(projectionIn[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(groupBy.getTaint());
        addTaint(having.getTaint());
        addTaint(sortOrder.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2084436340.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2084436340;
        // ---------- Original Method ----------
        //return query(db, projectionIn, selection, selectionArgs, groupBy, having, sortOrder,
                //null );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.621 -0400", hash_original_method = "A22563797EE8B98D8D2C96F4FC0F2C77", hash_generated_method = "F3552C53410012DAB696429290D272D4")
    public Cursor query(SQLiteDatabase db, String[] projectionIn,
            String selection, String[] selectionArgs, String groupBy,
            String having, String sortOrder, String limit) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_949359549 = null; //Variable for return #1
        Cursor varB4EAC82CA7396A68D541C85D26508E83_1003316877 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_949359549 = null;
        } //End block
        {
            boolean varA87A577568BFC2D77CF995C5491CA98D_967589200 = (mStrict && selection != null && selection.length() > 0);
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
            boolean var7061DF8A5335B809C796044C2A062407_1680652114 = (Log.isLoggable(TAG, Log.DEBUG));
            {
                Log.d(TAG, "Performing query: " + sql);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1003316877 = db.rawQueryWithFactory(
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
        Cursor varA7E53CE21691AB073D9660D615818899_1412741326; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1412741326 = varB4EAC82CA7396A68D541C85D26508E83_949359549;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1412741326 = varB4EAC82CA7396A68D541C85D26508E83_1003316877;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1412741326.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1412741326;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.622 -0400", hash_original_method = "A033D274CBE9E5A0C4BD18FE9EA6496C", hash_generated_method = "145EC15A6E9EF294D2B1F4AE529E30BA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.628 -0400", hash_original_method = "131EA8692C493A86BCD7B59A8B1306F4", hash_generated_method = "5D4C07A70C3826B108798EB99D864A7B")
    public String buildQuery(
            String[] projectionIn, String selection, String groupBy,
            String having, String sortOrder, String limit) {
        String varB4EAC82CA7396A68D541C85D26508E83_1247063153 = null; //Variable for return #1
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
            boolean varA1B7D4902A1967FE05483484790F8DD9_1649732955 = (selection != null && selection.length() > 0);
            {
                {
                    where.append(" AND ");
                } //End block
                where.append('(');
                where.append(selection);
                where.append(')');
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1247063153 = buildQueryString(
                mDistinct, mTables, projection, where.toString(),
                groupBy, having, sortOrder, limit);
        addTaint(projectionIn[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(groupBy.getTaint());
        addTaint(having.getTaint());
        addTaint(sortOrder.getTaint());
        addTaint(limit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1247063153.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1247063153;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.650 -0400", hash_original_method = "D5409D707055983A8E689AC969CBA872", hash_generated_method = "B72326846BE1C4A23B2B1652453D78F9")
    @Deprecated
    public String buildQuery(
            String[] projectionIn, String selection, String[] selectionArgs,
            String groupBy, String having, String sortOrder, String limit) {
        String varB4EAC82CA7396A68D541C85D26508E83_1731986976 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1731986976 = buildQuery(projectionIn, selection, groupBy, having, sortOrder, limit);
        addTaint(projectionIn[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(groupBy.getTaint());
        addTaint(having.getTaint());
        addTaint(sortOrder.getTaint());
        addTaint(limit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1731986976.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1731986976;
        // ---------- Original Method ----------
        //return buildQuery(projectionIn, selection, groupBy, having, sortOrder, limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.664 -0400", hash_original_method = "579B4F5DF75F7C70B58361D381AB3677", hash_generated_method = "986B33D15FEFEC1A1B04500C835B1A38")
    public String buildUnionSubQuery(
            String typeDiscriminatorColumn,
            String[] unionColumns,
            Set<String> columnsPresentInTable,
            int computedColumnsOffset,
            String typeDiscriminatorValue,
            String selection,
            String groupBy,
            String having) {
        String varB4EAC82CA7396A68D541C85D26508E83_463168750 = null; //Variable for return #1
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
                    boolean varEE2D3B923A9856EBBD44CF35F85DDA8F_1974615935 = (unionColumn.equals(typeDiscriminatorColumn));
                    {
                        projectionIn[i] = "'" + typeDiscriminatorValue + "' AS "
                        + typeDiscriminatorColumn;
                    } //End block
                    {
                        boolean var8CCCDA57FF3EE4F2C54EF7FC819C4A57_932428392 = (i <= computedColumnsOffset
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
        varB4EAC82CA7396A68D541C85D26508E83_463168750 = buildQuery(
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
        varB4EAC82CA7396A68D541C85D26508E83_463168750.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_463168750;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.682 -0400", hash_original_method = "6C4D740E5B06C8AB5B016A4D8B83E2C6", hash_generated_method = "59954468C44C72A9DDAE73A5C4E39241")
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
        String varB4EAC82CA7396A68D541C85D26508E83_1951627631 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1951627631 = buildUnionSubQuery(
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
        varB4EAC82CA7396A68D541C85D26508E83_1951627631.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1951627631;
        // ---------- Original Method ----------
        //return buildUnionSubQuery(
                //typeDiscriminatorColumn, unionColumns, columnsPresentInTable,
                //computedColumnsOffset, typeDiscriminatorValue, selection,
                //groupBy, having);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.707 -0400", hash_original_method = "870E9211222A33CDF50FFEE42B5AEA84", hash_generated_method = "6F20A307BF180E387F21AD0A6033970B")
    public String buildUnionQuery(String[] subQueries, String sortOrder, String limit) {
        String varB4EAC82CA7396A68D541C85D26508E83_104191203 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_104191203 = query.toString();
        addTaint(subQueries[0].getTaint());
        addTaint(sortOrder.getTaint());
        addTaint(limit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_104191203.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_104191203;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.727 -0400", hash_original_method = "37AD514842546773747C53CA078B5ACE", hash_generated_method = "D0C4EF8BADB4C27126B924DE66112E5F")
    private String[] computeProjection(String[] projectionIn) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1103310726 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_427485266 = null; //Variable for return #2
        String[] varB4EAC82CA7396A68D541C85D26508E83_993286797 = null; //Variable for return #3
        String[] varB4EAC82CA7396A68D541C85D26508E83_1803282225 = null; //Variable for return #4
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
                            boolean var99AA437685C808418B23C85778263149_1768715710 = (!mStrict &&
                            ( userColumn.contains(" AS ") || userColumn.contains(" as ")));
                            {
                                projection[i] = userColumn;
                            } //End block
                        } //End collapsed parenthetic
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid column "
                            + projectionIn[i]);
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_1103310726 = projection;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_427485266 = projectionIn;
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
                boolean varC38192A7CEBA362BA42047FB692ED895_1697737060 = (entryIter.hasNext());
                {
                    Entry<String, String> entry;
                    entry = entryIter.next();
                    {
                        boolean var259E335C27C5828A024F1EFCDEF7B5FA_721141123 = (entry.getKey().equals(BaseColumns._COUNT));
                    } //End collapsed parenthetic
                    projection[i++] = entry.getValue();
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_993286797 = projection;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1803282225 = null;
        addTaint(projectionIn[0].getTaint());
        String[] varA7E53CE21691AB073D9660D615818899_1348262770; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1348262770 = varB4EAC82CA7396A68D541C85D26508E83_1103310726;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1348262770 = varB4EAC82CA7396A68D541C85D26508E83_427485266;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1348262770 = varB4EAC82CA7396A68D541C85D26508E83_993286797;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1348262770 = varB4EAC82CA7396A68D541C85D26508E83_1803282225;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1348262770.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1348262770;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.727 -0400", hash_original_field = "9C8EED53DDB7737D7F02CB334DF9AF58", hash_generated_field = "26E38749F29C285F9E388248AB7BF436")

    private static String TAG = "SQLiteQueryBuilder";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.727 -0400", hash_original_field = "2F52A8FF47786EBFC843A29274CE4072", hash_generated_field = "AE2C87AE526C4163C6BB0C630CD20761")

    private static Pattern sLimitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
}

