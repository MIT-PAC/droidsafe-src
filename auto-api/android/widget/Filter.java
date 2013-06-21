package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public abstract class Filter {
    private Handler mThreadHandler;
    private Handler mResultHandler;
    private Delayer mDelayer;
    private Object mLock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.702 -0400", hash_original_method = "3A43B55E5FFADA496A080A897709E281", hash_generated_method = "224B7DC54A49D487A6B70021B3EAC24D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Filter() {
        mResultHandler = new ResultsHandler();
        // ---------- Original Method ----------
        //mResultHandler = new ResultsHandler();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.703 -0400", hash_original_method = "945149F2F16183884CBDA739B056A27B", hash_generated_method = "48CE02F0A78F23415F1CAA3355C153AB")
    @DSModeled(DSC.SAFE)
    public void setDelayer(Delayer delayer) {
        dsTaint.addTaint(delayer.dsTaint);
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //mDelayer = delayer;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.703 -0400", hash_original_method = "547418F5BDE1A6BA9449D3E97456DC38", hash_generated_method = "706D8BBD6030787E50D5BDCEEA0F364C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void filter(CharSequence constraint) {
        dsTaint.addTaint(constraint);
        filter(constraint, null);
        // ---------- Original Method ----------
        //filter(constraint, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.703 -0400", hash_original_method = "72132B08B36B7C63B817B4EDB2584A0E", hash_generated_method = "9AB0FBB36FF9755A005D2C252108BCE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void filter(CharSequence constraint, FilterListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(constraint);
        {
            {
                HandlerThread thread;
                thread = new HandlerThread(
                        THREAD_NAME, android.os.Process.THREAD_PRIORITY_BACKGROUND);
                thread.start();
                mThreadHandler = new RequestHandler(thread.getLooper());
            } //End block
            long delay;
            delay = 0;
            delay = mDelayer.getPostingDelay(constraint);
            Message message;
            message = mThreadHandler.obtainMessage(FILTER_TOKEN);
            RequestArguments args;
            args = new RequestArguments();
            args.constraint = constraint != null ? constraint.toString() : null;
            args.listener = listener;
            message.obj = args;
            mThreadHandler.removeMessages(FILTER_TOKEN);
            mThreadHandler.removeMessages(FINISH_TOKEN);
            mThreadHandler.sendMessageDelayed(message, delay);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    protected abstract FilterResults performFiltering(CharSequence constraint);

    
    protected abstract void publishResults(CharSequence constraint,
            FilterResults results);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.704 -0400", hash_original_method = "5D0951FE3DB94952122FC0A58DABB40C", hash_generated_method = "541D600A6F4B2CD13AA28F37B887383D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence convertResultToString(Object resultValue) {
        dsTaint.addTaint(resultValue.dsTaint);
        {
            Object varAB386EA08A6DAE719B91B8912A5FAC36_1889213569 = (resultValue.toString());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return resultValue == null ? "" : resultValue.toString();
    }

    
    protected static class FilterResults {
        public Object values;
        public int count;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.704 -0400", hash_original_method = "4DBCD611B55919CEC0E695E7409A22D3", hash_generated_method = "2A33A130733322CE05C88516643CF5BD")
        @DSModeled(DSC.SAFE)
        public FilterResults() {
            // ---------- Original Method ----------
        }

        
    }


    
    private class RequestHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.704 -0400", hash_original_method = "6F9C1865AABC7FABBD177D227607C2E3", hash_generated_method = "3E37A24D5A9A9645899B97935BF9199C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RequestHandler(Looper looper) {
            super(looper);
            dsTaint.addTaint(looper.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.704 -0400", hash_original_method = "B041560ADE0D1FD357DB3E4E690D9D5B", hash_generated_method = "351FFAFB1123EA54C027CDAC371E56F5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            int what;
            what = msg.what;
            Message message;
            //Begin case FILTER_TOKEN 
            RequestArguments args;
            args = (RequestArguments) msg.obj;
            //End case FILTER_TOKEN 
            //Begin case FILTER_TOKEN 
            try 
            {
                args.results = performFiltering(args.constraint);
            } //End block
            catch (Exception e)
            {
                args.results = new FilterResults();
            } //End block
            finally 
            {
                message = mResultHandler.obtainMessage(what);
                message.obj = args;
                message.sendToTarget();
            } //End block
            //End case FILTER_TOKEN 
            //Begin case FILTER_TOKEN 
            {
                {
                    Message finishMessage;
                    finishMessage = mThreadHandler.obtainMessage(FINISH_TOKEN);
                    mThreadHandler.sendMessageDelayed(finishMessage, 3000);
                } //End block
            } //End block
            //End case FILTER_TOKEN 
            //Begin case FINISH_TOKEN 
            {
                {
                    mThreadHandler.getLooper().quit();
                    mThreadHandler = null;
                } //End block
            } //End block
            //End case FINISH_TOKEN 
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class ResultsHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.705 -0400", hash_original_method = "CD0A6B87526D626087E8AF2E44FCD56C", hash_generated_method = "CD0A6B87526D626087E8AF2E44FCD56C")
                public ResultsHandler ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.705 -0400", hash_original_method = "1BAD86CE9386A91CEFB9E87EDE15880F", hash_generated_method = "D4498EB455D0DF28A4CA8F2D67686762")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            RequestArguments args;
            args = (RequestArguments) msg.obj;
            publishResults(args.constraint, args.results);
            {
                int count;
                count = args.results.count;
                count = -1;
                args.listener.onFilterComplete(count);
            } //End block
            // ---------- Original Method ----------
            //RequestArguments args = (RequestArguments) msg.obj;
            //publishResults(args.constraint, args.results);
            //if (args.listener != null) {
                //int count = args.results != null ? args.results.count : -1;
                //args.listener.onFilterComplete(count);
            //}
        }

        
    }


    
    private static class RequestArguments {
        CharSequence constraint;
        FilterListener listener;
        FilterResults results;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.705 -0400", hash_original_method = "3AF33BF19AB35B9A22757D214E04ABE6", hash_generated_method = "3AF33BF19AB35B9A22757D214E04ABE6")
                public RequestArguments ()
        {
        }


    }


    
    public static interface FilterListener {
        
        public void onFilterComplete(int count);
    }
    
    public interface Delayer {

        
        long getPostingDelay(CharSequence constraint);
    }
    
    private static final String LOG_TAG = "Filter";
    private static final String THREAD_NAME = "Filter";
    private static final int FILTER_TOKEN = 0xD0D0F00D;
    private static final int FINISH_TOKEN = 0xDEADBEEF;
}

