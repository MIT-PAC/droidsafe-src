package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.lang.ref.WeakReference;

public abstract class AsyncQueryHandler extends Handler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.420 -0400", hash_original_field = "CF849E3C15214EFD093D4303B542BF44", hash_generated_field = "2623DC09028481BBFC31885FF1F55C62")

    WeakReference<ContentResolver> mResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.420 -0400", hash_original_field = "041E83957B159F95441518AB1B6E6C69", hash_generated_field = "7AD8CDD6B2C328BF6D705083CF4BDA0C")

    private Handler mWorkerThreadHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.421 -0400", hash_original_method = "B4C614B6B340CBA8F78EF588C3C2AF07", hash_generated_method = "75A193E9A1E570227CEF7A75F2A56784")
    public  AsyncQueryHandler(ContentResolver cr) {
        super();
        mResolver = new WeakReference<ContentResolver>(cr);
        synchronized
(AsyncQueryHandler.class)        {
            if(sLooper == null)            
            {
                HandlerThread thread = new HandlerThread("AsyncQueryWorker");
                thread.start();
                sLooper = thread.getLooper();
            } //End block
        } //End block
        mWorkerThreadHandler = createHandler(sLooper);
        // ---------- Original Method ----------
        //mResolver = new WeakReference<ContentResolver>(cr);
        //synchronized (AsyncQueryHandler.class) {
            //if (sLooper == null) {
                //HandlerThread thread = new HandlerThread("AsyncQueryWorker");
                //thread.start();
                //sLooper = thread.getLooper();
            //}
        //}
        //mWorkerThreadHandler = createHandler(sLooper);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.423 -0400", hash_original_method = "0167182BD3CADC89AFF2FEC9CD47D129", hash_generated_method = "DBA95B5C69A352C493B9365CDF1A8291")
    protected Handler createHandler(Looper looper) {
        addTaint(looper.getTaint());
Handler var068CCC2B93BE9A402088FD79638C7AA5_1311177178 =         new WorkerHandler(looper);
        var068CCC2B93BE9A402088FD79638C7AA5_1311177178.addTaint(taint);
        return var068CCC2B93BE9A402088FD79638C7AA5_1311177178;
        // ---------- Original Method ----------
        //return new WorkerHandler(looper);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.425 -0400", hash_original_method = "28A47EA36D54BFEB24E3F3419F095F72", hash_generated_method = "62C6883177E06C5D3EE9245139D57ADC")
    public void startQuery(int token, Object cookie, Uri uri,
            String[] projection, String selection, String[] selectionArgs,
            String orderBy) {
        addTaint(orderBy.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(projection[0].getTaint());
        addTaint(uri.getTaint());
        addTaint(cookie.getTaint());
        addTaint(token);
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
        // ---------- Original Method ----------
        //Message msg = mWorkerThreadHandler.obtainMessage(token);
        //msg.arg1 = EVENT_ARG_QUERY;
        //WorkerArgs args = new WorkerArgs();
        //args.handler = this;
        //args.uri = uri;
        //args.projection = projection;
        //args.selection = selection;
        //args.selectionArgs = selectionArgs;
        //args.orderBy = orderBy;
        //args.cookie = cookie;
        //msg.obj = args;
        //mWorkerThreadHandler.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.426 -0400", hash_original_method = "EE3369F93F89F031119BE898CF210D83", hash_generated_method = "EBCA812E8BD0C7CF1110C3046C20E638")
    public final void cancelOperation(int token) {
        addTaint(token);
        mWorkerThreadHandler.removeMessages(token);
        // ---------- Original Method ----------
        //mWorkerThreadHandler.removeMessages(token);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.427 -0400", hash_original_method = "BF4976F2D6921E9160B247C834A0F160", hash_generated_method = "BEA46ABC5850CAB16811B5A937EDB806")
    public final void startInsert(int token, Object cookie, Uri uri,
            ContentValues initialValues) {
        addTaint(initialValues.getTaint());
        addTaint(uri.getTaint());
        addTaint(cookie.getTaint());
        addTaint(token);
        Message msg = mWorkerThreadHandler.obtainMessage(token);
        msg.arg1 = EVENT_ARG_INSERT;
        WorkerArgs args = new WorkerArgs();
        args.handler = this;
        args.uri = uri;
        args.cookie = cookie;
        args.values = initialValues;
        msg.obj = args;
        mWorkerThreadHandler.sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = mWorkerThreadHandler.obtainMessage(token);
        //msg.arg1 = EVENT_ARG_INSERT;
        //WorkerArgs args = new WorkerArgs();
        //args.handler = this;
        //args.uri = uri;
        //args.cookie = cookie;
        //args.values = initialValues;
        //msg.obj = args;
        //mWorkerThreadHandler.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.429 -0400", hash_original_method = "91BB5CD47541FB1A1DD753FE2859860E", hash_generated_method = "4E78299B4903DE6F0C2BA2FAB3A87148")
    public final void startUpdate(int token, Object cookie, Uri uri,
            ContentValues values, String selection, String[] selectionArgs) {
        addTaint(selectionArgs[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(values.getTaint());
        addTaint(uri.getTaint());
        addTaint(cookie.getTaint());
        addTaint(token);
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
        // ---------- Original Method ----------
        //Message msg = mWorkerThreadHandler.obtainMessage(token);
        //msg.arg1 = EVENT_ARG_UPDATE;
        //WorkerArgs args = new WorkerArgs();
        //args.handler = this;
        //args.uri = uri;
        //args.cookie = cookie;
        //args.values = values;
        //args.selection = selection;
        //args.selectionArgs = selectionArgs;
        //msg.obj = args;
        //mWorkerThreadHandler.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.431 -0400", hash_original_method = "8F86DAE3437E6544E644ECB861D9B85A", hash_generated_method = "55D78AACE82939A73BBD2353C83EFB60")
    public final void startDelete(int token, Object cookie, Uri uri,
            String selection, String[] selectionArgs) {
        addTaint(selectionArgs[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(uri.getTaint());
        addTaint(cookie.getTaint());
        addTaint(token);
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
        // ---------- Original Method ----------
        //Message msg = mWorkerThreadHandler.obtainMessage(token);
        //msg.arg1 = EVENT_ARG_DELETE;
        //WorkerArgs args = new WorkerArgs();
        //args.handler = this;
        //args.uri = uri;
        //args.cookie = cookie;
        //args.selection = selection;
        //args.selectionArgs = selectionArgs;
        //msg.obj = args;
        //mWorkerThreadHandler.sendMessage(msg);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.432 -0400", hash_original_method = "DE79F9BA4E2E1E76FD6FB5837E125869", hash_generated_method = "9D3FF6ECD27AC8BDCBB25BE5F4EF571A")
    protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(cursor.getTaint());
        addTaint(cookie.getTaint());
        addTaint(token);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.433 -0400", hash_original_method = "56E707F93CF845AF5D37EDA14CF36C80", hash_generated_method = "FB85709BC61A8419CE005019868AF694")
    protected void onInsertComplete(int token, Object cookie, Uri uri) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(uri.getTaint());
        addTaint(cookie.getTaint());
        addTaint(token);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.433 -0400", hash_original_method = "D24E238B6DD6917FF9CA66039892AD0D", hash_generated_method = "136393E13205FCAEE209B63116A32EAB")
    protected void onUpdateComplete(int token, Object cookie, int result) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(result);
        addTaint(cookie.getTaint());
        addTaint(token);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.433 -0400", hash_original_method = "5282503E7213EB860C46CD1340339EC5", hash_generated_method = "6409983EE856B1ECD4D07AAFA58F9B22")
    protected void onDeleteComplete(int token, Object cookie, int result) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(result);
        addTaint(cookie.getTaint());
        addTaint(token);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.434 -0400", hash_original_method = "50006A2133D7E0B202945894C4D59186", hash_generated_method = "97BC7E6509A54433E73DF1AB7CC40BB5")
    @Override
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
        WorkerArgs args = (WorkerArgs) msg.obj;
        if(localLOGV)        
        {
            Log.d(TAG, "AsyncQueryHandler.handleMessage: msg.what=" + msg.what
                    + ", msg.arg1=" + msg.arg1);
        } //End block
        int token = msg.what;
        int event = msg.arg1;
switch(event){
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    protected static final class WorkerArgs {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.434 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "CD245B47D421EDF9464454AF3C13247D")

        public Uri uri;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.434 -0400", hash_original_field = "C1CBFE271A40788A00E8BF8574D94D4B", hash_generated_field = "87C8A35F1DBD6E5D14285483B25A7D11")

        public Handler handler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.435 -0400", hash_original_field = "DFA555786D19F339A13E6719241E9D6F", hash_generated_field = "704EF8C8A2F6A1E36D50D94DC154F386")

        public String[] projection;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.435 -0400", hash_original_field = "EF5714E0519BFAA645CDFF7D28843B70", hash_generated_field = "4FDF28AA3F2FAC33C70294CAE038243A")

        public String selection;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.435 -0400", hash_original_field = "70F0187294D1F325A86E6A02045835B4", hash_generated_field = "C24E77D432770B2573BE7B41D9B0C99D")

        public String[] selectionArgs;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.435 -0400", hash_original_field = "4294376261299BA2CAFAFDB77CA4DEEB", hash_generated_field = "7A99CE5B9B490B1DC3D808C6163AEE22")

        public String orderBy;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.435 -0400", hash_original_field = "B4A88417B3D0170D754C647C30B7216A", hash_generated_field = "C4A6D58C2F47BA9A63392D945E9CECC1")

        public Object result;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.435 -0400", hash_original_field = "2DCCD1AB3E03990AEA77359831C85CA2", hash_generated_field = "FC4999A33B8FA33AA9744D183E348F81")

        public Object cookie;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.435 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "FAD78C29B35EAA7FE2C8690E9FAFF606")

        public ContentValues values;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.435 -0400", hash_original_method = "5AD25B0DEF3037CAAA377C35BF29670C", hash_generated_method = "5AD25B0DEF3037CAAA377C35BF29670C")
        public WorkerArgs ()
        {
            //Synthesized constructor
        }


    }


    
    protected class WorkerHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.436 -0400", hash_original_method = "A52B8D8E16654F983AD0EA90A5CCAF59", hash_generated_method = "F512DD8347E2C466089CBE1C3F03EA3A")
        public  WorkerHandler(Looper looper) {
            super(looper);
            addTaint(looper.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.438 -0400", hash_original_method = "BC8DD1777F18E8544A1DB9042612AEAB", hash_generated_method = "BABC94E70A2535044D22BC7E51CF5153")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
            final ContentResolver resolver = mResolver.get();
            if(resolver == null)            
            return;
            WorkerArgs args = (WorkerArgs) msg.obj;
            int token = msg.what;
            int event = msg.arg1;
switch(event){
            case EVENT_ARG_QUERY:
            Cursor cursor;
            try 
            {
                cursor = resolver.query(args.uri, args.projection,
                                args.selection, args.selectionArgs,
                                args.orderBy);
                if(cursor != null)                
                {
                    cursor.getCount();
                } //End block
            } //End block
            catch (Exception e)
            {
                cursor = null;
            } //End block
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
}            Message reply = args.handler.obtainMessage(token);
            reply.obj = args;
            reply.arg1 = msg.arg1;
            if(localLOGV)            
            {
                Log.d(TAG, "WorkerHandler.handleMsg: msg.arg1=" + msg.arg1
                        + ", reply.what=" + reply.what);
            } //End block
            reply.sendToTarget();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.439 -0400", hash_original_field = "1F81DA0D9C195AC356675F1B3B58533E", hash_generated_field = "56DF43D15450C3B466C476CFB04CD0ED")

    private static final String TAG = "AsyncQuery";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.439 -0400", hash_original_field = "6225589B7095A2A8B4D13D7070C07695", hash_generated_field = "761D2619615A389BF902F171CC86D6A4")

    private static final boolean localLOGV = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.439 -0400", hash_original_field = "45292F0DBCE83CBF23561A864806ADDD", hash_generated_field = "32F7556585B8C7C5DAAC0912D7E410F0")

    private static final int EVENT_ARG_QUERY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.439 -0400", hash_original_field = "F911AD193B4878BE4D94460A8641B6C1", hash_generated_field = "D8523E18ED29DA7E7B33104AACC2DDF2")

    private static final int EVENT_ARG_INSERT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.439 -0400", hash_original_field = "D40F52B3B029AACC7A45C68AF1B0D1CA", hash_generated_field = "00A5468179DC71DE58CE64DDD1527D2E")

    private static final int EVENT_ARG_UPDATE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.439 -0400", hash_original_field = "8CD836489B4B480F96ED22C7ACC5B61A", hash_generated_field = "20DB9FEA58A3BEE5CDD77E56C01F93E4")

    private static final int EVENT_ARG_DELETE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.440 -0400", hash_original_field = "0C5D9FDF812DE588B3B4B1A41A0CF09A", hash_generated_field = "711CF2789028D66BC3DA37028EB24680")

    private static Looper sLooper = null;
}

