package android.database.sqlite;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.provider.BaseColumns;
import android.text.TextUtils;
import android.util.Log;

public class SQLiteQueryBuilder {

    /**
     * Build an SQL query string from the given clauses.
     *
     * @param distinct true if you want each row to be unique, false otherwise.
     * @param tables The table names to compile the query against.
     * @param columns A list of which columns to return. Passing null will
     *            return all columns, which is discouraged to prevent reading
     *            data from storage that isn't going to be used.
     * @param where A filter declaring which rows to return, formatted as an SQL
     *            WHERE clause (excluding the WHERE itself). Passing null will
     *            return all rows for the given URL.
     * @param groupBy A filter declaring how to group rows, formatted as an SQL
     *            GROUP BY clause (excluding the GROUP BY itself). Passing null
     *            will cause the rows to not be grouped.
     * @param having A filter declare which row groups to include in the cursor,
     *            if row grouping is being used, formatted as an SQL HAVING
     *            clause (excluding the HAVING itself). Passing null will cause
     *            all row groups to be included, and is required when row
     *            grouping is not being used.
     * @param orderBy How to order the rows, formatted as an SQL ORDER BY clause
     *            (excluding the ORDER BY itself). Passing null will use the
     *            default sort order, which may be unordered.
     * @param limit Limits the number of rows returned by the query,
     *            formatted as LIMIT clause. Passing null denotes no LIMIT clause.
     * @return the SQL query string
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.138 -0500", hash_original_method = "6E0664B211A1B13A2C33147AD11424D2", hash_generated_method = "D454C1E640BB99B0BB734BA6E84010B4")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.141 -0500", hash_original_method = "D278BB0314F1874BBF59B2B8781BE260", hash_generated_method = "DA85E6EDCE32E0374FF85F55A4F4AF9F")
    
private static void appendClause(StringBuilder s, String name, String clause) {
        if (!TextUtils.isEmpty(clause)) {
            s.append(name);
            s.append(clause);
        }
    }

    /**
     * Add the names that are non-null in columns to s, separating
     * them with commas.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.143 -0500", hash_original_method = "B65787A0A04535E0065F95FD28B9005F", hash_generated_method = "00252D58673EB95CADC3DEEB71408B6E")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.089 -0500", hash_original_field = "C3C94A591EE45F1951B1E4E91CB473A0", hash_generated_field = "4E4A0EABB322720F9E96EF500187126A")

    private static final String TAG = "SQLiteQueryBuilder";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.092 -0500", hash_original_field = "F766D7E7F8B0C06D3A1298A462D0CEFC", hash_generated_field = "A91426785D8E749A1E39A5FB97B565C7")

    private static final Pattern sLimitPattern =
            Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.095 -0500", hash_original_field = "DD1007F99755848BE13ED87D9635B873", hash_generated_field = "769F77C34DE42382B188666E269E7701")

    private Map<String, String> mProjectionMap = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.097 -0500", hash_original_field = "F82DC55178AF9E82B2CF77FF772C5CD0", hash_generated_field = "8F885C16B9BDADDFD8C26FCD5BE5228C")

    private String mTables = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.100 -0500", hash_original_field = "E9E7739E4751A65CAB1C7BDE3903EA88", hash_generated_field = "AA43CCC2518697E93036E759BA68D945")

    private StringBuilder mWhereClause = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.102 -0500", hash_original_field = "B5DAA7C8E039265A7D6974E1B3E19B66", hash_generated_field = "A56C1C3192C3259733D99B7B9797B9BD")

    private boolean mDistinct;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.104 -0500", hash_original_field = "2FEAA39ED75A8BF923BED7D3044704CC", hash_generated_field = "B3A21B3E4C20F1E737FF55A7E08BB6E5")

    private SQLiteDatabase.CursorFactory mFactory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.107 -0500", hash_original_field = "DCA4E3E6C10DE7A519D62B664BDCD575", hash_generated_field = "52E2A3AFF0ECDB0477697EA761229425")

    private boolean mStrict;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.110 -0500", hash_original_method = "841FC2D35CC9552E307358F36A673D72", hash_generated_method = "2AEC253E7142AD2F66BF83F76E98F9AA")
    
public SQLiteQueryBuilder() {
        mDistinct = false;
        mFactory = null;
    }

    /**
     * Mark the query as DISTINCT.
     *
     * @param distinct if true the query is DISTINCT, otherwise it isn't
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.113 -0500", hash_original_method = "9A9512BC3B93773BE1B8C3DEAB4EDCF7", hash_generated_method = "44B4C3FC4193EF36C72AAE129AC2D0CC")
    
public void setDistinct(boolean distinct) {
        mDistinct = distinct;
    }

    /**
     * Returns the list of tables being queried
     *
     * @return the list of tables being queried
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.116 -0500", hash_original_method = "71A35CB8526DF402EA58F5074639A5D5", hash_generated_method = "13D8072364158B36631FA2ACBC56A17F")
    
public String getTables() {
        return mTables;
    }

    /**
     * Sets the list of tables to query. Multiple tables can be specified to perform a join.
     * For example:
     *   setTables("foo, bar")
     *   setTables("foo LEFT OUTER JOIN bar ON (foo.id = bar.foo_id)")
     *
     * @param inTables the list of tables to query on
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.118 -0500", hash_original_method = "3D5C8D5A2DF23857F8B36CBC126449F5", hash_generated_method = "6D71291B909000BAACAB49C5B7A12499")
    
public void setTables(String inTables) {
        mTables = inTables;
    }

    /**
     * Append a chunk to the WHERE clause of the query. All chunks appended are surrounded
     * by parenthesis and ANDed with the selection passed to {@link #query}. The final
     * WHERE clause looks like:
     *
     * WHERE (&lt;append chunk 1>&lt;append chunk2>) AND (&lt;query() selection parameter>)
     *
     * @param inWhere the chunk of text to append to the WHERE clause.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.123 -0500", hash_original_method = "4066C27D90FD6AEEDB747E2D0A255B82", hash_generated_method = "AE5516F5F592B31E19612BE6B9DC745C")
    
public void appendWhere(CharSequence inWhere) {
        if (mWhereClause == null) {
            mWhereClause = new StringBuilder(inWhere.length() + 16);
        }
        if (mWhereClause.length() == 0) {
            mWhereClause.append('(');
        }
        mWhereClause.append(inWhere);
    }

    /**
     * Append a chunk to the WHERE clause of the query. All chunks appended are surrounded
     * by parenthesis and ANDed with the selection passed to {@link #query}. The final
     * WHERE clause looks like:
     *
     * WHERE (&lt;append chunk 1>&lt;append chunk2>) AND (&lt;query() selection parameter>)
     *
     * @param inWhere the chunk of text to append to the WHERE clause. it will be escaped
     * to avoid SQL injection attacks
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.127 -0500", hash_original_method = "CD89033A6A424354FBAEE4A7B7BB0312", hash_generated_method = "F2E378748E2C287D92424CD85C2A7EE1")
    
public void appendWhereEscapeString(String inWhere) {
        if (mWhereClause == null) {
            mWhereClause = new StringBuilder(inWhere.length() + 16);
        }
        if (mWhereClause.length() == 0) {
            mWhereClause.append('(');
        }
        DatabaseUtils.appendEscapedSQLString(mWhereClause, inWhere);
    }

    /**
     * Sets the projection map for the query.  The projection map maps
     * from column names that the caller passes into query to database
     * column names. This is useful for renaming columns as well as
     * disambiguating column names when doing joins. For example you
     * could map "name" to "people.name".  If a projection map is set
     * it must contain all column names the user may request, even if
     * the key and value are the same.
     *
     * @param columnMap maps from the user column names to the database column names
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.129 -0500", hash_original_method = "DDD8D9F6C39192C696789E3C5816355A", hash_generated_method = "242D53A391A616E52B1C81C51E3570BE")
    
public void setProjectionMap(Map<String, String> columnMap) {
        mProjectionMap = columnMap;
    }

    /**
     * Sets the cursor factory to be used for the query.  You can use
     * one factory for all queries on a database but it is normally
     * easier to specify the factory when doing this query.  @param
     * factory the factor to use
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.132 -0500", hash_original_method = "9A5AF21719138D1250197FB20CA33704", hash_generated_method = "2EEF0EB4A38CF905FBAC825955A22FF6")
    
public void setCursorFactory(SQLiteDatabase.CursorFactory factory) {
        mFactory = factory;
    }

    /**
     * When set, the selection is verified against malicious arguments.
     * When using this class to create a statement using
     * {@link #buildQueryString(boolean, String, String[], String, String, String, String, String)},
     * non-numeric limits will raise an exception. If a projection map is specified, fields
     * not in that map will be ignored.
     * If this class is used to execute the statement directly using
     * {@link #query(SQLiteDatabase, String[], String, String[], String, String, String)}
     * or
     * {@link #query(SQLiteDatabase, String[], String, String[], String, String, String, String)},
     * additionally also parenthesis escaping selection are caught.
     *
     * To summarize: To get maximum protection against malicious third party apps (for example
     * content provider consumers), make sure to do the following:
     * <ul>
     * <li>Set this value to true</li>
     * <li>Use a projection map</li>
     * <li>Use one of the query overloads instead of getting the statement as a sql string</li>
     * </ul>
     * By default, this value is false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.134 -0500", hash_original_method = "20B77E17A7BDAD72AFE7C926EABDA9FA", hash_generated_method = "D2998DB6AF93B3BB9F95A4529ACFFF30")
    
public void setStrict(boolean flag) {
        mStrict = flag;
    }

    /**
     * Perform a query by combining all current settings and the
     * information passed into this method.
     *
     * @param db the database to query on
     * @param projectionIn A list of which columns to return. Passing
     *   null will return all columns, which is discouraged to prevent
     *   reading data from storage that isn't going to be used.
     * @param selection A filter declaring which rows to return,
     *   formatted as an SQL WHERE clause (excluding the WHERE
     *   itself). Passing null will return all rows for the given URL.
     * @param selectionArgs You may include ?s in selection, which
     *   will be replaced by the values from selectionArgs, in order
     *   that they appear in the selection. The values will be bound
     *   as Strings.
     * @param groupBy A filter declaring how to group rows, formatted
     *   as an SQL GROUP BY clause (excluding the GROUP BY
     *   itself). Passing null will cause the rows to not be grouped.
     * @param having A filter declare which row groups to include in
     *   the cursor, if row grouping is being used, formatted as an
     *   SQL HAVING clause (excluding the HAVING itself).  Passing
     *   null will cause all row groups to be included, and is
     *   required when row grouping is not being used.
     * @param sortOrder How to order the rows, formatted as an SQL
     *   ORDER BY clause (excluding the ORDER BY itself). Passing null
     *   will use the default sort order, which may be unordered.
     * @return a cursor over the result set
     * @see android.content.ContentResolver#query(android.net.Uri, String[],
     *      String, String[], String)
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.146 -0500", hash_original_method = "C851DFBDB6501381AF55260B14586647", hash_generated_method = "60B42FCF91B7DAFA84B5EEAB5AFFEF11")
    
public Cursor query(SQLiteDatabase db, String[] projectionIn,
            String selection, String[] selectionArgs, String groupBy,
            String having, String sortOrder) {
        return query(db, projectionIn, selection, selectionArgs, groupBy, having, sortOrder,
                null /* limit */);
    }

    /**
     * Perform a query by combining all current settings and the
     * information passed into this method.
     *
     * @param db the database to query on
     * @param projectionIn A list of which columns to return. Passing
     *   null will return all columns, which is discouraged to prevent
     *   reading data from storage that isn't going to be used.
     * @param selection A filter declaring which rows to return,
     *   formatted as an SQL WHERE clause (excluding the WHERE
     *   itself). Passing null will return all rows for the given URL.
     * @param selectionArgs You may include ?s in selection, which
     *   will be replaced by the values from selectionArgs, in order
     *   that they appear in the selection. The values will be bound
     *   as Strings.
     * @param groupBy A filter declaring how to group rows, formatted
     *   as an SQL GROUP BY clause (excluding the GROUP BY
     *   itself). Passing null will cause the rows to not be grouped.
     * @param having A filter declare which row groups to include in
     *   the cursor, if row grouping is being used, formatted as an
     *   SQL HAVING clause (excluding the HAVING itself).  Passing
     *   null will cause all row groups to be included, and is
     *   required when row grouping is not being used.
     * @param sortOrder How to order the rows, formatted as an SQL
     *   ORDER BY clause (excluding the ORDER BY itself). Passing null
     *   will use the default sort order, which may be unordered.
     * @param limit Limits the number of rows returned by the query,
     *   formatted as LIMIT clause. Passing null denotes no LIMIT clause.
     * @return a cursor over the result set
     * @see android.content.ContentResolver#query(android.net.Uri, String[],
     *      String, String[], String)
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.149 -0500", hash_original_method = "A22563797EE8B98D8D2C96F4FC0F2C77", hash_generated_method = "EB9D53584F352AD6AC60DCC4EDA82399")
    
public Cursor query(SQLiteDatabase db, String[] projectionIn,
            String selection, String[] selectionArgs, String groupBy,
            String having, String sortOrder, String limit) {
        if (mTables == null) {
            return null;
        }

        if (mStrict && selection != null && selection.length() > 0) {
            // Validate the user-supplied selection to detect syntactic anomalies
            // in the selection string that could indicate a SQL injection attempt.
            // The idea is to ensure that the selection clause is a valid SQL expression
            // by compiling it twice: once wrapped in parentheses and once as
            // originally specified. An attacker cannot create an expression that
            // would escape the SQL expression while maintaining balanced parentheses
            // in both the wrapped and original forms.
            String sqlForValidation = buildQuery(projectionIn, "(" + selection + ")", groupBy,
                    having, sortOrder, limit);
            validateSql(db, sqlForValidation); // will throw if query is invalid
        }

        String sql = buildQuery(
                projectionIn, selection, groupBy, having,
                sortOrder, limit);

        if (Log.isLoggable(TAG, Log.DEBUG)) {
            Log.d(TAG, "Performing query: " + sql);
        }
        return db.rawQueryWithFactory(
                mFactory, sql, selectionArgs,
                SQLiteDatabase.findEditTable(mTables)); // will throw if query is invalid
    }

    /**
     * Verifies that a SQL statement is valid by compiling it.
     * If the SQL statement is not valid, this method will throw a {@link SQLiteException}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.152 -0500", hash_original_method = "A033D274CBE9E5A0C4BD18FE9EA6496C", hash_generated_method = "C95076B53B9B593D27569827D7E59306")
    
private void validateSql(SQLiteDatabase db, String sql) {
        db.lock(sql);
        try {
            new SQLiteCompiledSql(db, sql).releaseSqlStatement();
        } finally {
            db.unlock();
        }
    }

    /**
     * Construct a SELECT statement suitable for use in a group of
     * SELECT statements that will be joined through UNION operators
     * in buildUnionQuery.
     *
     * @param projectionIn A list of which columns to return. Passing
     *    null will return all columns, which is discouraged to
     *    prevent reading data from storage that isn't going to be
     *    used.
     * @param selection A filter declaring which rows to return,
     *   formatted as an SQL WHERE clause (excluding the WHERE
     *   itself).  Passing null will return all rows for the given
     *   URL.
     * @param groupBy A filter declaring how to group rows, formatted
     *   as an SQL GROUP BY clause (excluding the GROUP BY itself).
     *   Passing null will cause the rows to not be grouped.
     * @param having A filter declare which row groups to include in
     *   the cursor, if row grouping is being used, formatted as an
     *   SQL HAVING clause (excluding the HAVING itself).  Passing
     *   null will cause all row groups to be included, and is
     *   required when row grouping is not being used.
     * @param sortOrder How to order the rows, formatted as an SQL
     *   ORDER BY clause (excluding the ORDER BY itself). Passing null
     *   will use the default sort order, which may be unordered.
     * @param limit Limits the number of rows returned by the query,
     *   formatted as LIMIT clause. Passing null denotes no LIMIT clause.
     * @return the resulting SQL SELECT statement
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.155 -0500", hash_original_method = "131EA8692C493A86BCD7B59A8B1306F4", hash_generated_method = "A675D2F50F847BFFE856FA499291DBFE")
    
public String buildQuery(
            String[] projectionIn, String selection, String groupBy,
            String having, String sortOrder, String limit) {
        String[] projection = computeProjection(projectionIn);

        StringBuilder where = new StringBuilder();
        boolean hasBaseWhereClause = mWhereClause != null && mWhereClause.length() > 0;

        if (hasBaseWhereClause) {
            where.append(mWhereClause.toString());
            where.append(')');
        }

        // Tack on the user's selection, if present.
        if (selection != null && selection.length() > 0) {
            if (hasBaseWhereClause) {
                where.append(" AND ");
            }

            where.append('(');
            where.append(selection);
            where.append(')');
        }

        return buildQueryString(
                mDistinct, mTables, projection, where.toString(),
                groupBy, having, sortOrder, limit);
    }

    /**
     * @deprecated This method's signature is misleading since no SQL parameter
     * substitution is carried out.  The selection arguments parameter does not get
     * used at all.  To avoid confusion, call
     * {@link #buildQuery(String[], String, String, String, String, String)} instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.157 -0500", hash_original_method = "D5409D707055983A8E689AC969CBA872", hash_generated_method = "43B6153B9809D029FFF31AF5473B87C4")
    
@Deprecated
    public String buildQuery(
            String[] projectionIn, String selection, String[] selectionArgs,
            String groupBy, String having, String sortOrder, String limit) {
        return buildQuery(projectionIn, selection, groupBy, having, sortOrder, limit);
    }

    /**
     * Construct a SELECT statement suitable for use in a group of
     * SELECT statements that will be joined through UNION operators
     * in buildUnionQuery.
     *
     * @param typeDiscriminatorColumn the name of the result column
     *   whose cells will contain the name of the table from which
     *   each row was drawn.
     * @param unionColumns the names of the columns to appear in the
     *   result.  This may include columns that do not appear in the
     *   table this SELECT is querying (i.e. mTables), but that do
     *   appear in one of the other tables in the UNION query that we
     *   are constructing.
     * @param columnsPresentInTable a Set of the names of the columns
     *   that appear in this table (i.e. in the table whose name is
     *   mTables).  Since columns in unionColumns include columns that
     *   appear only in other tables, we use this array to distinguish
     *   which ones actually are present.  Other columns will have
     *   NULL values for results from this subquery.
     * @param computedColumnsOffset all columns in unionColumns before
     *   this index are included under the assumption that they're
     *   computed and therefore won't appear in columnsPresentInTable,
     *   e.g. "date * 1000 as normalized_date"
     * @param typeDiscriminatorValue the value used for the
     *   type-discriminator column in this subquery
     * @param selection A filter declaring which rows to return,
     *   formatted as an SQL WHERE clause (excluding the WHERE
     *   itself).  Passing null will return all rows for the given
     *   URL.
     * @param groupBy A filter declaring how to group rows, formatted
     *   as an SQL GROUP BY clause (excluding the GROUP BY itself).
     *   Passing null will cause the rows to not be grouped.
     * @param having A filter declare which row groups to include in
     *   the cursor, if row grouping is being used, formatted as an
     *   SQL HAVING clause (excluding the HAVING itself).  Passing
     *   null will cause all row groups to be included, and is
     *   required when row grouping is not being used.
     * @return the resulting SQL SELECT statement
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.160 -0500", hash_original_method = "579B4F5DF75F7C70B58361D381AB3677", hash_generated_method = "B38ADA6C9E0B1F648A7D372DCFD6BAE1")
    
public String buildUnionSubQuery(
            String typeDiscriminatorColumn,
            String[] unionColumns,
            Set<String> columnsPresentInTable,
            int computedColumnsOffset,
            String typeDiscriminatorValue,
            String selection,
            String groupBy,
            String having) {
        int unionColumnsCount = unionColumns.length;
        String[] projectionIn = new String[unionColumnsCount];

        for (int i = 0; i < unionColumnsCount; i++) {
            String unionColumn = unionColumns[i];

            if (unionColumn.equals(typeDiscriminatorColumn)) {
                projectionIn[i] = "'" + typeDiscriminatorValue + "' AS "
                        + typeDiscriminatorColumn;
            } else if (i <= computedColumnsOffset
                       || columnsPresentInTable.contains(unionColumn)) {
                projectionIn[i] = unionColumn;
            } else {
                projectionIn[i] = "NULL AS " + unionColumn;
            }
        }
        return buildQuery(
                projectionIn, selection, groupBy, having,
                null /* sortOrder */,
                null /* limit */);
    }

    /**
     * @deprecated This method's signature is misleading since no SQL parameter
     * substitution is carried out.  The selection arguments parameter does not get
     * used at all.  To avoid confusion, call
     * {@link #buildUnionSubQuery}
     * instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.164 -0500", hash_original_method = "6C4D740E5B06C8AB5B016A4D8B83E2C6", hash_generated_method = "BE5B068B91D2E3EF214A51ACA2BC925F")
    
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
        return buildUnionSubQuery(
                typeDiscriminatorColumn, unionColumns, columnsPresentInTable,
                computedColumnsOffset, typeDiscriminatorValue, selection,
                groupBy, having);
    }

    /**
     * Given a set of subqueries, all of which are SELECT statements,
     * construct a query that returns the union of what those
     * subqueries return.
     * @param subQueries an array of SQL SELECT statements, all of
     *   which must have the same columns as the same positions in
     *   their results
     * @param sortOrder How to order the rows, formatted as an SQL
     *   ORDER BY clause (excluding the ORDER BY itself).  Passing
     *   null will use the default sort order, which may be unordered.
     * @param limit The limit clause, which applies to the entire union result set
     *
     * @return the resulting SQL SELECT statement
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.167 -0500", hash_original_method = "870E9211222A33CDF50FFEE42B5AEA84", hash_generated_method = "2295C47135890B172FCC5171045CB48E")
    
public String buildUnionQuery(String[] subQueries, String sortOrder, String limit) {
        StringBuilder query = new StringBuilder(128);
        int subQueryCount = subQueries.length;
        String unionOperator = mDistinct ? " UNION " : " UNION ALL ";

        for (int i = 0; i < subQueryCount; i++) {
            if (i > 0) {
                query.append(unionOperator);
            }
            query.append(subQueries[i]);
        }
        appendClause(query, " ORDER BY ", sortOrder);
        appendClause(query, " LIMIT ", limit);
        return query.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.170 -0500", hash_original_method = "37AD514842546773747C53CA078B5ACE", hash_generated_method = "D70EE8D8D24C9C44666F66A1E9216045")
    
private String[] computeProjection(String[] projectionIn) {
        if (projectionIn != null && projectionIn.length > 0) {
            if (mProjectionMap != null) {
                String[] projection = new String[projectionIn.length];
                int length = projectionIn.length;

                for (int i = 0; i < length; i++) {
                    String userColumn = projectionIn[i];
                    String column = mProjectionMap.get(userColumn);

                    if (column != null) {
                        projection[i] = column;
                        continue;
                    }

                    if (!mStrict &&
                            ( userColumn.contains(" AS ") || userColumn.contains(" as "))) {
                        /* A column alias already exist */
                        projection[i] = userColumn;
                        continue;
                    }

                    throw new IllegalArgumentException("Invalid column "
                            + projectionIn[i]);
                }
                return projection;
            } else {
                return projectionIn;
            }
        } else if (mProjectionMap != null) {
            // Return all columns in projection map.
            Set<Entry<String, String>> entrySet = mProjectionMap.entrySet();
            String[] projection = new String[entrySet.size()];
            Iterator<Entry<String, String>> entryIter = entrySet.iterator();
            int i = 0;

            while (entryIter.hasNext()) {
                Entry<String, String> entry = entryIter.next();

                // Don't include the _count column when people ask for no projection.
                if (entry.getKey().equals(BaseColumns._COUNT)) {
                    continue;
                }
                projection[i++] = entry.getValue();
            }
            return projection;
        }
        return null;
    }
}

