package android.support.v4.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.util.TimeUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;

public abstract class AsyncTaskLoader<D> extends Loader<D> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.251 -0400", hash_original_field = "0F416DC8E1EF1E61CE9DC1C4C6AAC524", hash_generated_field = "5C3107BBF367803569D0AB8A39076D22")

    volatile LoadTask mTask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.251 -0400", hash_original_field = "EDF7920DB00DE49F0F969383ED96ADCF", hash_generated_field = "3D2A32ED16FA4BFF500D2C906E32BFB2")

    volatile LoadTask mCancellingTask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.251 -0400", hash_original_field = "02ECB78B7782D2E17D2F48FF5560193C", hash_generated_field = "0CC16960397661E2A91A0C1245907990")

    long mUpdateThrottle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.251 -0400", hash_original_field = "9BA75F3ADE66FC882D737169079E87F5", hash_generated_field = "068F47D76DDC530CAC2DF35289A5CFB4")

    long mLastLoadCompleteTime = -10000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.251 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

    Handler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.251 -0400", hash_original_method = "D12030B6AB606C68B1075214300CB0F6", hash_generated_method = "9F1C3BF057BEA8A30936008A3BBCBD74")
    public  AsyncTaskLoader(Context context) {
        super(context);
        addTaint(context.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.252 -0400", hash_original_method = "5FBC47B8FEAE1CF1C3C903D2FBB05A60", hash_generated_method = "21798D7C30B0FA4AFD9628ACC2788318")
    public void setUpdateThrottle(long delayMS) {
        mUpdateThrottle = delayMS;
        {
            mHandler = new Handler();
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.252 -0400", hash_original_method = "432E7B986B9CB9166C0D2E103A5093E2", hash_generated_method = "09FB2E450172659DF3F5F1A5827F0B79")
    @Override
    protected void onForceLoad() {
        
        super.onForceLoad();
        cancelLoad();
        mTask = new LoadTask();
        executePendingTask();
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.253 -0400", hash_original_method = "EED9AFD45373FFA0657A2114031AE14C", hash_generated_method = "01EB0F84210B74CC829B9B249442E14A")
    public boolean cancelLoad() {
        {
            {
                {
                    mTask.waiting = false;
                    mHandler.removeCallbacks(mTask);
                } 
                mTask = null;
            } 
            {
                mTask.waiting = false;
                mHandler.removeCallbacks(mTask);
                mTask = null;
            } 
            {
                boolean cancelled = mTask.cancel(false);
                {
                    mCancellingTask = mTask;
                } 
                mTask = null;
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2074194043 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2074194043;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.253 -0400", hash_original_method = "6EDCFF0D227BFAAE1F619E412FD9521B", hash_generated_method = "0F4F990AA22D5996D91D9A1E1C026B8F")
    public void onCanceled(D data) {
        
        addTaint(data.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.253 -0400", hash_original_method = "DFA4BC3BC4931E8E36EC6E65D042E4CC", hash_generated_method = "80005DBC0D16B6BA851D81B22EC900EE")
     void executePendingTask() {
        {
            {
                mTask.waiting = false;
                mHandler.removeCallbacks(mTask);
            } 
            {
                long now = SystemClock.uptimeMillis();
                {
                    mTask.waiting = true;
                    mHandler.postAtTime(mTask, mLastLoadCompleteTime+mUpdateThrottle);
                } 
            } 
            mTask.executeOnExecutor(ModernAsyncTask.THREAD_POOL_EXECUTOR, (Void[]) null);
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.254 -0400", hash_original_method = "BF74607E5A027725B948953035D3427E", hash_generated_method = "C4710B49780C4548B0D230CFC3710449")
     void dispatchOnCancelled(LoadTask task, D data) {
        onCanceled(data);
        {
            mLastLoadCompleteTime = SystemClock.uptimeMillis();
            mCancellingTask = null;
            executePendingTask();
        } 
        addTaint(task.getTaint());
        addTaint(data.getTaint());
        
        
        
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.254 -0400", hash_original_method = "A2F1D76D2090E39A2E66817DE2784754", hash_generated_method = "1FD8A735D4D29B5B7C26D209B80456F2")
     void dispatchOnLoadComplete(LoadTask task, D data) {
        {
            dispatchOnCancelled(task, data);
        } 
        {
            {
                boolean varCF392471541B21B47F5379E70C625C71_625176928 = (isAbandoned());
                {
                    onCanceled(data);
                } 
                {
                    mLastLoadCompleteTime = SystemClock.uptimeMillis();
                    mTask = null;
                    deliverResult(data);
                } 
            } 
        } 
        addTaint(task.getTaint());
        addTaint(data.getTaint());
        
        
            
            
        
            
                
            
                
                
                
                
            
        
    }

    
    public abstract D loadInBackground();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.255 -0400", hash_original_method = "4A83A9163F83587A19BB5376A46D430D", hash_generated_method = "FFCC0A9866F850FFA970FFE673247546")
    protected D onLoadInBackground() {
        
        D varB4EAC82CA7396A68D541C85D26508E83_1123308344 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1123308344 = loadInBackground();
        varB4EAC82CA7396A68D541C85D26508E83_1123308344.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1123308344;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.255 -0400", hash_original_method = "13983B8AAAA767CBF57A8C7D5EF6BF65", hash_generated_method = "CDE044A64D9501255C3C17EB43D1AC9B")
    public void waitForLoader() {
        LoadTask task = mTask;
        {
            try 
            {
                task.done.await();
            } 
            catch (InterruptedException e)
            { }
        } 
        
        
        
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.256 -0400", hash_original_method = "3BD2D1BA0575E5C52E87DB33CE550D2F", hash_generated_method = "20F9BF304E07E8CA55E280BC758E8EC3")
    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        super.dump(prefix, fd, writer, args);
        {
            writer.print(prefix);
            writer.print("mTask=");
            writer.print(mTask);
            writer.print(" waiting=");
            writer.println(mTask.waiting);
        } 
        {
            writer.print(prefix);
            writer.print("mCancellingTask=");
            writer.print(mCancellingTask);
            writer.print(" waiting=");
            writer.println(mCancellingTask.waiting);
        } 
        {
            writer.print(prefix);
            writer.print("mUpdateThrottle=");
            TimeUtils.formatDuration(mUpdateThrottle, writer);
            writer.print(" mLastLoadCompleteTime=");
            TimeUtils.formatDuration(mLastLoadCompleteTime,
                            SystemClock.uptimeMillis(), writer);
            writer.println();
        } 
        addTaint(prefix.getTaint());
        addTaint(fd.getTaint());
        addTaint(writer.getTaint());
        addTaint(args[0].getTaint());
        
        
    }

    
    final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.256 -0400", hash_original_field = "B4A88417B3D0170D754C647C30B7216A", hash_generated_field = "582B22379A32E8937A90E0545A184CFB")

        D result;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.256 -0400", hash_original_field = "CB05CAB65AFEFAB8FD3831D92CFC68BE", hash_generated_field = "4B5AD997260D6A7F7067C9C9B5D02B34")

        boolean waiting;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.256 -0400", hash_original_field = "E59FCAF1FB9C927C0B18C71A73C87BFA", hash_generated_field = "F0455DF121EFC5ECE22AA733E5351602")

        private CountDownLatch done = new CountDownLatch(1);
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.256 -0400", hash_original_method = "16D80339785A96B3DBCA213BDE6C22F0", hash_generated_method = "16D80339785A96B3DBCA213BDE6C22F0")
        public LoadTask ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.257 -0400", hash_original_method = "962D018A6346A7B0135AC9FF7B03DD4E", hash_generated_method = "92609573BA620029FEBAE1465073ED27")
        @Override
        protected D doInBackground(Void... params) {
            D varB4EAC82CA7396A68D541C85D26508E83_2112864022 = null; 
            result = AsyncTaskLoader.this.onLoadInBackground();
            varB4EAC82CA7396A68D541C85D26508E83_2112864022 = result;
            addTaint(params[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2112864022.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2112864022;
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.257 -0400", hash_original_method = "58FAE55DC10E415A2FA190657D4F1D85", hash_generated_method = "03B0A6546CF62465B37006215AC7186A")
        @Override
        protected void onPostExecute(D data) {
            
            try 
            {
                AsyncTaskLoader.this.dispatchOnLoadComplete(this, data);
            } 
            finally 
            {
                done.countDown();
            } 
            addTaint(data.getTaint());
            
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.258 -0400", hash_original_method = "B83F1AA509F54D59951BAD91749D4A0A", hash_generated_method = "1032CAF6BF8959A2D6E0662737DDF59B")
        @Override
        protected void onCancelled() {
            
            try 
            {
                AsyncTaskLoader.this.dispatchOnCancelled(this, result);
            } 
            finally 
            {
                done.countDown();
            } 
            
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.258 -0400", hash_original_method = "65A4E8609F3A198276A58E99188CF50D", hash_generated_method = "A3D7CB50D3A18C07A0E486AD92E5DB33")
        @Override
        public void run() {
            waiting = false;
            AsyncTaskLoader.this.executePendingTask();
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.258 -0400", hash_original_field = "642F64B2F6B3B4A629E0B76845D23A2B", hash_generated_field = "E2B79C20584722CC23AA6431B7343097")

    static final String TAG = "AsyncTaskLoader";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.258 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "F09208C088E716A2CD36A97B937BB5EA")

    static final boolean DEBUG = false;
}

