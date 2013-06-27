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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.342 -0400", hash_original_field = "BA7E3585BAC0AB9D61DD30CE7204792F", hash_generated_field = "95F8A0CD9492F0837A9DA3FE5B46EFD4")

    private Handler mThreadHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.342 -0400", hash_original_field = "E70782971915A611914403852491DF6A", hash_generated_field = "2CD0385D10AF873EE6FED55190565ADB")

    private Handler mResultHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.342 -0400", hash_original_field = "E8F61699EEEC0D6D66C267C1C275FAC8", hash_generated_field = "80A4CE79B874839FC5345637AF2E83E5")

    private Delayer mDelayer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.342 -0400", hash_original_field = "B89DEBA2CB26B1AC973763E3E152017B", hash_generated_field = "C8F8FCD335E09ED70E70801AB39A894A")

    private Object mLock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.342 -0400", hash_original_method = "3A43B55E5FFADA496A080A897709E281", hash_generated_method = "224B7DC54A49D487A6B70021B3EAC24D")
    public  Filter() {
        mResultHandler = new ResultsHandler();
        // ---------- Original Method ----------
        //mResultHandler = new ResultsHandler();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.342 -0400", hash_original_method = "945149F2F16183884CBDA739B056A27B", hash_generated_method = "F7C8A98646A33E71E9BAA665E430A7D7")
    public void setDelayer(Delayer delayer) {
        {
            mDelayer = delayer;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //mDelayer = delayer;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.342 -0400", hash_original_method = "547418F5BDE1A6BA9449D3E97456DC38", hash_generated_method = "E93C8355A0E05E83507A7618DC93B6DC")
    public final void filter(CharSequence constraint) {
        filter(constraint, null);
        addTaint(constraint.getTaint());
        // ---------- Original Method ----------
        //filter(constraint, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.361 -0400", hash_original_method = "72132B08B36B7C63B817B4EDB2584A0E", hash_generated_method = "5C0BC91E90F74619AAF3EB797BE04633")
    public final void filter(CharSequence constraint, FilterListener listener) {
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
        addTaint(constraint.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    protected abstract FilterResults performFiltering(CharSequence constraint);

    
    protected abstract void publishResults(CharSequence constraint,
            FilterResults results);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.361 -0400", hash_original_method = "5D0951FE3DB94952122FC0A58DABB40C", hash_generated_method = "7A5025A5BFDBE2574586A3DC2FF0B1AD")
    public CharSequence convertResultToString(Object resultValue) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_422936874 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_422936874 = resultValue == null ? "" : resultValue.toString();
        addTaint(resultValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_422936874.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_422936874;
        // ---------- Original Method ----------
        //return resultValue == null ? "" : resultValue.toString();
    }

    
    protected static class FilterResults {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.362 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "D3703C87CDEFAF1A6A55F65201CACA1D")

        public Object values;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.362 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "21B1DF5337CCD3E0731435FB1361ED67")

        public int count;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.362 -0400", hash_original_method = "4DBCD611B55919CEC0E695E7409A22D3", hash_generated_method = "2A33A130733322CE05C88516643CF5BD")
        public  FilterResults() {
            // ---------- Original Method ----------
        }

        
    }


    
    private class RequestHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.362 -0400", hash_original_method = "6F9C1865AABC7FABBD177D227607C2E3", hash_generated_method = "B4310111147B5C14A2F8D8B70200993B")
        public  RequestHandler(Looper looper) {
            super(looper);
            addTaint(looper.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.369 -0400", hash_original_method = "B041560ADE0D1FD357DB3E4E690D9D5B", hash_generated_method = "0090A2082A149BBF15F6EA1E24F701AC")
        public void handleMessage(Message msg) {
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
            addTaint(msg.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class ResultsHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.369 -0400", hash_original_method = "1E08EF8EFA185C4653CFFF0D7408C61C", hash_generated_method = "1E08EF8EFA185C4653CFFF0D7408C61C")
        public ResultsHandler ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.370 -0400", hash_original_method = "1BAD86CE9386A91CEFB9E87EDE15880F", hash_generated_method = "AE07FF571CDA1432B04A6176A21E33EB")
        @Override
        public void handleMessage(Message msg) {
            RequestArguments args;
            args = (RequestArguments) msg.obj;
            publishResults(args.constraint, args.results);
            {
                int count;
                count = args.results.count;
                count = -1;
                args.listener.onFilterComplete(count);
            } //End block
            addTaint(msg.getTaint());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.370 -0400", hash_original_field = "3677AB7ADAF00725E9FDBAED503A94E3", hash_generated_field = "A990B1A3EAE194295F4523C8D67C8224")

        CharSequence constraint;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.370 -0400", hash_original_field = "D0B62CF0CD270BB58374F321620931FF", hash_generated_field = "D4CDE16C0546A2B2BFBBEE27F9F88E28")

        FilterListener listener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.370 -0400", hash_original_field = "53E61336BB49EC978968786B07DEA50B", hash_generated_field = "31AA06C32DAD475E424FD501DC622C26")

        FilterResults results;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.370 -0400", hash_original_method = "6E50E95F99D18D81DCBEFDBA0A1A41EC", hash_generated_method = "6E50E95F99D18D81DCBEFDBA0A1A41EC")
        public RequestArguments ()
        {
            //Synthesized constructor
        }


    }


    
    public static interface FilterListener {
        
        public void onFilterComplete(int count);
    }
    
    public interface Delayer {

        
        long getPostingDelay(CharSequence constraint);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.370 -0400", hash_original_field = "756A4E861FD91CEB60D36BCCC186E750", hash_generated_field = "111CF7F01127AAD7B82AC9FC76F221B6")

    private static String LOG_TAG = "Filter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.370 -0400", hash_original_field = "076DC9686957CC9A757CAFE928507CC5", hash_generated_field = "A368AC6614B192751F8935F4DE69109A")

    private static String THREAD_NAME = "Filter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.370 -0400", hash_original_field = "4F0F8403B2C2279DFB29369FB5BA1C96", hash_generated_field = "915BE4CDF9553B99B50FB57DB9EFA929")

    private static int FILTER_TOKEN = 0xD0D0F00D;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.370 -0400", hash_original_field = "F6EF94DA63E8FE59FBEBB37ADAA1551E", hash_generated_field = "9D88BD702F75C1CD5942B39312F87F93")

    private static int FINISH_TOKEN = 0xDEADBEEF;
}

