package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public abstract class Filter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.889 -0400", hash_original_field = "BA7E3585BAC0AB9D61DD30CE7204792F", hash_generated_field = "95F8A0CD9492F0837A9DA3FE5B46EFD4")

    private Handler mThreadHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.889 -0400", hash_original_field = "E70782971915A611914403852491DF6A", hash_generated_field = "2CD0385D10AF873EE6FED55190565ADB")

    private Handler mResultHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.889 -0400", hash_original_field = "E8F61699EEEC0D6D66C267C1C275FAC8", hash_generated_field = "80A4CE79B874839FC5345637AF2E83E5")

    private Delayer mDelayer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.889 -0400", hash_original_field = "B89DEBA2CB26B1AC973763E3E152017B", hash_generated_field = "E59081251AD157907AA4CE8B3D8E654E")

    private final Object mLock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.890 -0400", hash_original_method = "3A43B55E5FFADA496A080A897709E281", hash_generated_method = "224B7DC54A49D487A6B70021B3EAC24D")
    public  Filter() {
        mResultHandler = new ResultsHandler();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.890 -0400", hash_original_method = "945149F2F16183884CBDA739B056A27B", hash_generated_method = "F7C8A98646A33E71E9BAA665E430A7D7")
    public void setDelayer(Delayer delayer) {
        {
            mDelayer = delayer;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.890 -0400", hash_original_method = "547418F5BDE1A6BA9449D3E97456DC38", hash_generated_method = "E93C8355A0E05E83507A7618DC93B6DC")
    public final void filter(CharSequence constraint) {
        filter(constraint, null);
        addTaint(constraint.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.891 -0400", hash_original_method = "72132B08B36B7C63B817B4EDB2584A0E", hash_generated_method = "83481BC7501A209B3FBE132D47C5E7A2")
    public final void filter(CharSequence constraint, FilterListener listener) {
        {
            {
                HandlerThread thread = new HandlerThread(
                        THREAD_NAME, android.os.Process.THREAD_PRIORITY_BACKGROUND);
                thread.start();
                mThreadHandler = new RequestHandler(thread.getLooper());
            } 
            long delay;
            delay = 0;
            delay = mDelayer.getPostingDelay(constraint);
            Message message = mThreadHandler.obtainMessage(FILTER_TOKEN);
            RequestArguments args = new RequestArguments();
            args.constraint = constraint != null ? constraint.toString() : null;
            args.listener = listener;
            message.obj = args;
            mThreadHandler.removeMessages(FILTER_TOKEN);
            mThreadHandler.removeMessages(FINISH_TOKEN);
            mThreadHandler.sendMessageDelayed(message, delay);
        } 
        addTaint(constraint.getTaint());
        addTaint(listener.getTaint());
        
        
    }

    
    protected abstract FilterResults performFiltering(CharSequence constraint);

    
    protected abstract void publishResults(CharSequence constraint,
            FilterResults results);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.892 -0400", hash_original_method = "5D0951FE3DB94952122FC0A58DABB40C", hash_generated_method = "B5B73AD7D9F408C0F1135F4D3A5771FE")
    public CharSequence convertResultToString(Object resultValue) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_12408689 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_12408689 = resultValue == null ? "" : resultValue.toString();
        addTaint(resultValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_12408689.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_12408689;
        
        
    }

    
    protected static class FilterResults {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.892 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "D3703C87CDEFAF1A6A55F65201CACA1D")

        public Object values;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.892 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "21B1DF5337CCD3E0731435FB1361ED67")

        public int count;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.892 -0400", hash_original_method = "4DBCD611B55919CEC0E695E7409A22D3", hash_generated_method = "2A33A130733322CE05C88516643CF5BD")
        public  FilterResults() {
            
        }

        
    }


    
    private class RequestHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.892 -0400", hash_original_method = "6F9C1865AABC7FABBD177D227607C2E3", hash_generated_method = "B4310111147B5C14A2F8D8B70200993B")
        public  RequestHandler(Looper looper) {
            super(looper);
            addTaint(looper.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.893 -0400", hash_original_method = "B041560ADE0D1FD357DB3E4E690D9D5B", hash_generated_method = "D5504D1B25F4AECA1478F7A9946E9173")
        public void handleMessage(Message msg) {
            int what = msg.what;
            Message message;
            
            RequestArguments args = (RequestArguments) msg.obj;
            
            
            try 
            {
                args.results = performFiltering(args.constraint);
            } 
            catch (Exception e)
            {
                args.results = new FilterResults();
            } 
            finally 
            {
                message = mResultHandler.obtainMessage(what);
                message.obj = args;
                message.sendToTarget();
            } 
            
            
            {
                {
                    Message finishMessage = mThreadHandler.obtainMessage(FINISH_TOKEN);
                    mThreadHandler.sendMessageDelayed(finishMessage, 3000);
                } 
            } 
            
            
            {
                {
                    mThreadHandler.getLooper().quit();
                    mThreadHandler = null;
                } 
            } 
            
            addTaint(msg.getTaint());
            
            
        }

        
    }


    
    private class ResultsHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.893 -0400", hash_original_method = "1E08EF8EFA185C4653CFFF0D7408C61C", hash_generated_method = "1E08EF8EFA185C4653CFFF0D7408C61C")
        public ResultsHandler ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.893 -0400", hash_original_method = "1BAD86CE9386A91CEFB9E87EDE15880F", hash_generated_method = "D47AB537963FFB03F388F2314C9042A0")
        @Override
        public void handleMessage(Message msg) {
            RequestArguments args = (RequestArguments) msg.obj;
            publishResults(args.constraint, args.results);
            {
                int count;
                count = args.results.count;
                count = -1;
                args.listener.onFilterComplete(count);
            } 
            addTaint(msg.getTaint());
            
            
            
            
                
                
            
        }

        
    }


    
    private static class RequestArguments {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.893 -0400", hash_original_field = "3677AB7ADAF00725E9FDBAED503A94E3", hash_generated_field = "A990B1A3EAE194295F4523C8D67C8224")

        CharSequence constraint;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.893 -0400", hash_original_field = "D0B62CF0CD270BB58374F321620931FF", hash_generated_field = "D4CDE16C0546A2B2BFBBEE27F9F88E28")

        FilterListener listener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.893 -0400", hash_original_field = "53E61336BB49EC978968786B07DEA50B", hash_generated_field = "31AA06C32DAD475E424FD501DC622C26")

        FilterResults results;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.893 -0400", hash_original_method = "6E50E95F99D18D81DCBEFDBA0A1A41EC", hash_generated_method = "6E50E95F99D18D81DCBEFDBA0A1A41EC")
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.893 -0400", hash_original_field = "756A4E861FD91CEB60D36BCCC186E750", hash_generated_field = "793222EB5D405FC1EB1B7701D18817D3")

    private static final String LOG_TAG = "Filter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.894 -0400", hash_original_field = "076DC9686957CC9A757CAFE928507CC5", hash_generated_field = "5FAF72EED80F110BC27332069A109797")

    private static final String THREAD_NAME = "Filter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.894 -0400", hash_original_field = "4F0F8403B2C2279DFB29369FB5BA1C96", hash_generated_field = "59508486D6172BE2A85FA3BBA6DCA371")

    private static final int FILTER_TOKEN = 0xD0D0F00D;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.894 -0400", hash_original_field = "F6EF94DA63E8FE59FBEBB37ADAA1551E", hash_generated_field = "F92F74445173D271FAFC43822262A61D")

    private static final int FINISH_TOKEN = 0xDEADBEEF;
}

