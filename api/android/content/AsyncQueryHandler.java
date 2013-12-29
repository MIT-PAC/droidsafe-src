package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.ref.WeakReference;

import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;





public abstract class AsyncQueryHandler extends Handler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.590 -0500", hash_original_field = "308A471AE508CD143380C55F65246BC3", hash_generated_field = "56DF43D15450C3B466C476CFB04CD0ED")

    private static final String TAG = "AsyncQuery";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.592 -0500", hash_original_field = "7A06C0A50B73200DDC70097F2AFFF800", hash_generated_field = "761D2619615A389BF902F171CC86D6A4")

    private static final boolean localLOGV = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.593 -0500", hash_original_field = "B4B5DD185B72B76F222325D7F56B27D9", hash_generated_field = "32F7556585B8C7C5DAAC0912D7E410F0")


    private static final int EVENT_ARG_QUERY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.593 -0500", hash_original_field = "CB40908DE987C17316C34A92A1605742", hash_generated_field = "D8523E18ED29DA7E7B33104AACC2DDF2")

    private static final int EVENT_ARG_INSERT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.594 -0500", hash_original_field = "5A5DC379CC3C3C4004F4EADE8A5C771E", hash_generated_field = "00A5468179DC71DE58CE64DDD1527D2E")

    private static final int EVENT_ARG_UPDATE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.596 -0500", hash_original_field = "C28218B89854DF21F6A7AC6430DF46B0", hash_generated_field = "20DB9FEA58A3BEE5CDD77E56C01F93E4")

    private static final int EVENT_ARG_DELETE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.597 -0500", hash_original_field = "486DEB08162A61D496A2A906EACF35AA", hash_generated_field = "711CF2789028D66BC3DA37028EB24680")


    private static Looper sLooper = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.597 -0500", hash_original_field = "2623DC09028481BBFC31885FF1F55C62", hash_generated_field = "2623DC09028481BBFC31885FF1F55C62")
  WeakReference<ContentResolver> mResolver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.598 -0500", hash_original_field = "97410944F2D251997323EDE8307CFCF0", hash_generated_field = "7AD8CDD6B2C328BF6D705083CF4BDA0C")


    private Handler mWorkerThreadHandler;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.611 -0500", hash_original_method = "B4C614B6B340CBA8F78EF588C3C2AF07", hash_generated_method = "0D906943D7C53102F21474D4CCFDFBF7")
    public AsyncQueryHandler(ContentResolver cr) {
        super();
        mResolver = new WeakReference<ContentResolver>(cr);
        synchronized (AsyncQueryHandler.class) {
            if (sLooper == null) {
                HandlerThread thread = new HandlerThread("AsyncQueryWorker");
                thread.start();

                sLooper = thread.getLooper();
            }
        }
        mWorkerThreadHandler = createHandler(sLooper);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.611 -0500", hash_original_method = "0167182BD3CADC89AFF2FEC9CD47D129", hash_generated_method = "9DF31B658AA3AB071A94529FE2CDCB67")
    protected Handler createHandler(Looper looper) {
        return new WorkerHandler(looper);
    }

    /**
     * This method begins an asynchronous query. When the query is done
     * {@link #onQueryComplete} is called.
     *
     * @param token A token passed into {@link #onQueryComplete} to identify
     *  the query.
     * @param cookie An object that gets passed into {@link #onQueryComplete}
     * @param uri The URI, using the content:// scheme, for the content to
     *         retrieve.
     * @param projection A list of which columns to return. Passing null will
     *         return all columns, which is discouraged to prevent reading data
     *         from storage that isn't going to be used.
     * @param selection A filter declaring which rows to return, formatted as an
     *         SQL WHERE clause (excluding the WHERE itself). Passing null will
     *         return all rows for the given URI.
     * @param selectionArgs You may include ?s in selection, which will be
     *         replaced by the values from selectionArgs, in the order that they
     *         appear in the selection. The values will be bound as Strings.
     * @param orderBy How to order the rows, formatted as an SQL ORDER BY
     *         clause (excluding the ORDER BY itself). Passing null will use the
     *         default sort order, which may be unordered.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.612 -0500", hash_original_method = "28A47EA36D54BFEB24E3F3419F095F72", hash_generated_method = "C01CAFE1A3C21003A48644972E8354BA")
    public void startQuery(int token, Object cookie, Uri uri,
            String[] projection, String selection, String[] selectionArgs,
            String orderBy) {
        // Use the token as what so cancelOperations works properly
        Message msg = mWorkerThreadHandler.obtainMessage(token);
        msg.arg1 = EVENT_ARG_QUERY;

        WorkerArgs args = new WorkerArgs();
        args.handler = this;
        args.uri = uri;
        args.projection = projection;
        args.selection = selection;
        args.selectionArgs = selectionArgs;
        args.orderBy = orderBy;
        args.cookie = cookie;
        msg.obj = args;

        mWorkerThreadHandler.sendMessage(msg);
    }

    /**
     * Attempts to cancel operation that has not already started. Note that
     * there is no guarantee that the operation will be canceled. They still may
     * result in a call to on[Query/Insert/Update/Delete]Complete after this
     * call has completed.
     *
     * @param token The token representing the operation to be canceled.
     *  If multiple operations have the same token they will all be canceled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.613 -0500", hash_original_method = "EE3369F93F89F031119BE898CF210D83", hash_generated_method = "B3EFDCB9C29B4EC9F4F562DA178F9D3B")
    public final void cancelOperation(int token) {
        mWorkerThreadHandler.removeMessages(token);
    }

    /**
     * This method begins an asynchronous insert. When the insert operation is
     * done {@link #onInsertComplete} is called.
     *
     * @param token A token passed into {@link #onInsertComplete} to identify
     *  the insert operation.
     * @param cookie An object that gets passed into {@link #onInsertComplete}
     * @param uri the Uri passed to the insert operation.
     * @param initialValues the ContentValues parameter passed to the insert operation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.614 -0500", hash_original_method = "BF4976F2D6921E9160B247C834A0F160", hash_generated_method = "B0A68E138EDA520EE6312FEEA0A59943")
    public final void startInsert(int token, Object cookie, Uri uri,
            ContentValues initialValues) {
        // Use the token as what so cancelOperations works properly
        Message msg = mWorkerThreadHandler.obtainMessage(token);
        msg.arg1 = EVENT_ARG_INSERT;

        WorkerArgs args = new WorkerArgs();
        args.handler = this;
        args.uri = uri;
        args.cookie = cookie;
        args.values = initialValues;
        msg.obj = args;

        mWorkerThreadHandler.sendMessage(msg);
    }

    
    protected static final class WorkerArgs {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.599 -0500", hash_original_field = "F30A3503738FDB118E2076C7F22FF172", hash_generated_field = "CD245B47D421EDF9464454AF3C13247D")

        public Uri uri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.600 -0500", hash_original_field = "D9C04859655A94D3774048AFC37C4725", hash_generated_field = "87C8A35F1DBD6E5D14285483B25A7D11")

        public Handler handler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.601 -0500", hash_original_field = "ACF59640FAD771061F3BA21D4C31DE9F", hash_generated_field = "704EF8C8A2F6A1E36D50D94DC154F386")

        public String[] projection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.602 -0500", hash_original_field = "1D2D2BAEC564D0B865C42660A26E08BC", hash_generated_field = "4FDF28AA3F2FAC33C70294CAE038243A")

        public String selection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.603 -0500", hash_original_field = "86D27ABB38ED175AFE63784C7FBC124B", hash_generated_field = "C24E77D432770B2573BE7B41D9B0C99D")

        public String[] selectionArgs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.603 -0500", hash_original_field = "6175C698C46346CBED80C40752F6F75A", hash_generated_field = "7A99CE5B9B490B1DC3D808C6163AEE22")

        public String orderBy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.604 -0500", hash_original_field = "BCA77D12632DFCDF9A8AEB56A649B3D3", hash_generated_field = "C4A6D58C2F47BA9A63392D945E9CECC1")

        public Object result;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.605 -0500", hash_original_field = "F7F85A538D1954518D7E41FCD8B03375", hash_generated_field = "FC4999A33B8FA33AA9744D183E348F81")

        public Object cookie;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.606 -0500", hash_original_field = "0447B23FBF8F2DC77579AB5D67D851A7", hash_generated_field = "FAD78C29B35EAA7FE2C8690E9FAFF606")

        public ContentValues values;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.435 -0400", hash_original_method = "5AD25B0DEF3037CAAA377C35BF29670C", hash_generated_method = "5AD25B0DEF3037CAAA377C35BF29670C")
        public WorkerArgs ()
        {
            //Synthesized constructor
        }


    }


    
    protected class WorkerHandler extends Handler {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.608 -0500", hash_original_method = "A52B8D8E16654F983AD0EA90A5CCAF59", hash_generated_method = "4D2A7C2622FCE2CDBCAFF3A89841A95A")
        public WorkerHandler(Looper looper) {
            super(looper);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.609 -0500", hash_original_method = "BC8DD1777F18E8544A1DB9042612AEAB", hash_generated_method = "7FB19CE88A5D2550749BFF4DBD3AC51F")
        @Override
public void handleMessage(Message msg) {
            final ContentResolver resolver = mResolver.get();
            if (resolver == null) return;

            WorkerArgs args = (WorkerArgs) msg.obj;

            int token = msg.what;
            int event = msg.arg1;

            switch (event) {
                case EVENT_ARG_QUERY:
                    Cursor cursor;
                    try {
                        cursor = resolver.query(args.uri, args.projection,
                                args.selection, args.selectionArgs,
                                args.orderBy);
                        // Calling getCount() causes the cursor window to be filled,
                        // which will make the first access on the main thread a lot faster.
                        if (cursor != null) {
                            cursor.getCount();
                        }
                    } catch (Exception e) {
                        Log.w(TAG, "Exception thrown during handling EVENT_ARG_QUERY", e);
                        cursor = null;
                    }

                    args.result = cursor;
                    break;

                case EVENT_ARG_INSERT:
                    args.result = resolver.insert(args.uri, args.values);
                    break;

                case EVENT_ARG_UPDATE:
                    args.result = resolver.update(args.uri, args.values, args.selection,
                            args.selectionArgs);
                    break;

                case EVENT_ARG_DELETE:
                    args.result = resolver.delete(args.uri, args.selection, args.selectionArgs);
                    break;
            }

            // passing the original token value back to the caller
            // on top of the event values in arg1.
            Message reply = args.handler.obtainMessage(token);
            reply.obj = args;
            reply.arg1 = msg.arg1;

            if (localLOGV) {
                Log.d(TAG, "WorkerHandler.handleMsg: msg.arg1=" + msg.arg1
                        + ", reply.what=" + reply.what);
            }

            reply.sendToTarget();
        }

        
    }

    /**
     * This method begins an asynchronous update. When the update operation is
     * done {@link #onUpdateComplete} is called.
     *
     * @param token A token passed into {@link #onUpdateComplete} to identify
     *  the update operation.
     * @param cookie An object that gets passed into {@link #onUpdateComplete}
     * @param uri the Uri passed to the update operation.
     * @param values the ContentValues parameter passed to the update operation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.615 -0500", hash_original_method = "91BB5CD47541FB1A1DD753FE2859860E", hash_generated_method = "364AFBCEC0932304693B4E3248F05A43")
    public final void startUpdate(int token, Object cookie, Uri uri,
            ContentValues values, String selection, String[] selectionArgs) {
        // Use the token as what so cancelOperations works properly
        Message msg = mWorkerThreadHandler.obtainMessage(token);
        msg.arg1 = EVENT_ARG_UPDATE;

        WorkerArgs args = new WorkerArgs();
        args.handler = this;
        args.uri = uri;
        args.cookie = cookie;
        args.values = values;
        args.selection = selection;
        args.selectionArgs = selectionArgs;
        msg.obj = args;

        mWorkerThreadHandler.sendMessage(msg);
    }

    /**
     * This method begins an asynchronous delete. When the delete operation is
     * done {@link #onDeleteComplete} is called.
     *
     * @param token A token passed into {@link #onDeleteComplete} to identify
     *  the delete operation.
     * @param cookie An object that gets passed into {@link #onDeleteComplete}
     * @param uri the Uri passed to the delete operation.
     * @param selection the where clause.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.616 -0500", hash_original_method = "8F86DAE3437E6544E644ECB861D9B85A", hash_generated_method = "51C17436C49D6F166E989CD08C465319")
    public final void startDelete(int token, Object cookie, Uri uri,
            String selection, String[] selectionArgs) {
        // Use the token as what so cancelOperations works properly
        Message msg = mWorkerThreadHandler.obtainMessage(token);
        msg.arg1 = EVENT_ARG_DELETE;

        WorkerArgs args = new WorkerArgs();
        args.handler = this;
        args.uri = uri;
        args.cookie = cookie;
        args.selection = selection;
        args.selectionArgs = selectionArgs;
        msg.obj = args;

        mWorkerThreadHandler.sendMessage(msg);
    }

    /**
     * Called when an asynchronous query is completed.
     *
     * @param token the token to identify the query, passed in from
     *            {@link #startQuery}.
     * @param cookie the cookie object passed in from {@link #startQuery}.
     * @param cursor The cursor holding the results from the query.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.617 -0500", hash_original_method = "DE79F9BA4E2E1E76FD6FB5837E125869", hash_generated_method = "31D5A49FB0C938CA56A2082C4C3D20DD")
    protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
        // Empty
    }

    /**
     * Called when an asynchronous insert is completed.
     *
     * @param token the token to identify the query, passed in from
     *        {@link #startInsert}.
     * @param cookie the cookie object that's passed in from
     *        {@link #startInsert}.
     * @param uri the uri returned from the insert operation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.618 -0500", hash_original_method = "56E707F93CF845AF5D37EDA14CF36C80", hash_generated_method = "AE6C007A3124252793CA1C6BDF1DECC7")
    protected void onInsertComplete(int token, Object cookie, Uri uri) {
        // Empty
    }

    /**
     * Called when an asynchronous update is completed.
     *
     * @param token the token to identify the query, passed in from
     *        {@link #startUpdate}.
     * @param cookie the cookie object that's passed in from
     *        {@link #startUpdate}.
     * @param result the result returned from the update operation
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.618 -0500", hash_original_method = "D24E238B6DD6917FF9CA66039892AD0D", hash_generated_method = "92B3AD6278D2091B2F641D48A5D22E17")
    protected void onUpdateComplete(int token, Object cookie, int result) {
        // Empty
    }

    /**
     * Called when an asynchronous delete is completed.
     *
     * @param token the token to identify the query, passed in from
     *        {@link #startDelete}.
     * @param cookie the cookie object that's passed in from
     *        {@link #startDelete}.
     * @param result the result returned from the delete operation
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.619 -0500", hash_original_method = "5282503E7213EB860C46CD1340339EC5", hash_generated_method = "2B43E8E4611A95C069B1552F2C692488")
    protected void onDeleteComplete(int token, Object cookie, int result) {
        // Empty
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:00.620 -0500", hash_original_method = "50006A2133D7E0B202945894C4D59186", hash_generated_method = "BE85304DEC489057D9A532DA3D87141D")
    @Override
public void handleMessage(Message msg) {
        WorkerArgs args = (WorkerArgs) msg.obj;

        if (localLOGV) {
            Log.d(TAG, "AsyncQueryHandler.handleMessage: msg.what=" + msg.what
                    + ", msg.arg1=" + msg.arg1);
        }

        int token = msg.what;
        int event = msg.arg1;

        // pass token back to caller on each callback.
        switch (event) {
            case EVENT_ARG_QUERY:
                onQueryComplete(token, args.cookie, (Cursor) args.result);
                break;

            case EVENT_ARG_INSERT:
                onInsertComplete(token, args.cookie, (Uri) args.result);
                break;

            case EVENT_ARG_UPDATE:
                onUpdateComplete(token, args.cookie, (Integer) args.result);
                break;

            case EVENT_ARG_DELETE:
                onDeleteComplete(token, args.cookie, (Integer) args.result);
                break;
        }
    }
}

