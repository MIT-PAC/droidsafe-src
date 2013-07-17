package android.media;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.AndroidRuntimeException;
import android.util.Log;
import java.io.File;
import java.io.FileDescriptor;
import android.os.ParcelFileDescriptor;
import java.lang.ref.WeakReference;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import java.io.IOException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class SoundPool {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.174 -0400", hash_original_field = "20E813A614226843849BF2E571A8EBCA", hash_generated_field = "0A3F8EE607897645EB2EE30B6939205B")

    private int mNativeContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.174 -0400", hash_original_field = "3487E63080D45B4AAFB4C377AC2DEA9F", hash_generated_field = "04D6DC37F0EF901EF71A528809491D49")

    private EventHandler mEventHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.174 -0400", hash_original_field = "0F7713B2563FF9C2F8676E9976DD1647", hash_generated_field = "497ED3DB79F8602C8296F1F823EA04F7")

    private OnLoadCompleteListener mOnLoadCompleteListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.174 -0400", hash_original_field = "D99C4DF571068C060F9624A3098FE796", hash_generated_field = "7811049C9A4FE55905A497F504D75A1C")

    private Object mLock;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.175 -0400", hash_original_method = "9A330E706059F126F0EDC112CA4EBD0D", hash_generated_method = "2E1C12618C8836C512DFF54C8DFCF4FF")
    public  SoundPool(int maxStreams, int streamType, int srcQuality) {
        addTaint(srcQuality);
        addTaint(streamType);
        addTaint(maxStreams);
        if(native_setup(new WeakReference(this), maxStreams, streamType, srcQuality) != 0)        
        {
            RuntimeException var4A485DDC959A4F0F078E177957328AFF_666578440 = new RuntimeException("Native setup failed");
            var4A485DDC959A4F0F078E177957328AFF_666578440.addTaint(taint);
            throw var4A485DDC959A4F0F078E177957328AFF_666578440;
        } //End block
        mLock = new Object();
        // ---------- Original Method ----------
        //if (native_setup(new WeakReference(this), maxStreams, streamType, srcQuality) != 0) {
            //throw new RuntimeException("Native setup failed");
        //}
        //mLock = new Object();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.177 -0400", hash_original_method = "E1F98F0EB3621DC5A63042A4ACC9BAA2", hash_generated_method = "2975E26FC4314F9AF61208A93C85333D")
    public int load(String path, int priority) {
        addTaint(priority);
        addTaint(path.getTaint());
        if(path.startsWith("http:"))        
        {
        int var323438CFE8754693CD14AA3BEF9C0172_414513778 = (_load(path, priority));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1582293011 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1582293011;
        }
        int id = 0;
        try 
        {
            File f = new File(path);
            if(f != null)            
            {
                ParcelFileDescriptor fd = ParcelFileDescriptor.open(f, ParcelFileDescriptor.MODE_READ_ONLY);
                if(fd != null)                
                {
                    id = _load(fd.getFileDescriptor(), 0, f.length(), priority);
                    fd.close();
                } //End block
            } //End block
        } //End block
        catch (java.io.IOException e)
        {
        } //End block
        int varB80BB7740288FDA1F201890375A60C8F_634776453 = (id);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_106426669 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_106426669;
        // ---------- Original Method ----------
        //if (path.startsWith("http:"))
            //return _load(path, priority);
        //int id = 0;
        //try {
            //File f = new File(path);
            //if (f != null) {
                //ParcelFileDescriptor fd = ParcelFileDescriptor.open(f, ParcelFileDescriptor.MODE_READ_ONLY);
                //if (fd != null) {
                    //id = _load(fd.getFileDescriptor(), 0, f.length(), priority);
                    //fd.close();
                //}
            //}
        //} catch (java.io.IOException e) {
            //Log.e(TAG, "error loading " + path);
        //}
        //return id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.179 -0400", hash_original_method = "DBD8B5A7FFACE026F7AD7D856CBD2B6E", hash_generated_method = "D658585F1727EC4BA113A631C325A071")
    public int load(Context context, int resId, int priority) {
        addTaint(priority);
        addTaint(resId);
        addTaint(context.getTaint());
        AssetFileDescriptor afd = context.getResources().openRawResourceFd(resId);
        int id = 0;
        if(afd != null)        
        {
            id = _load(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength(), priority);
            try 
            {
                afd.close();
            } //End block
            catch (java.io.IOException ex)
            {
            } //End block
        } //End block
        int varB80BB7740288FDA1F201890375A60C8F_1282826628 = (id);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1187427975 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1187427975;
        // ---------- Original Method ----------
        //AssetFileDescriptor afd = context.getResources().openRawResourceFd(resId);
        //int id = 0;
        //if (afd != null) {
            //id = _load(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength(), priority);
            //try {
                //afd.close();
            //} catch (java.io.IOException ex) {
            //}
        //}
        //return id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.180 -0400", hash_original_method = "13C5B0F29B8E9F766E159F72001665A3", hash_generated_method = "EE3FA11FF17990BD1266551EE94E33A9")
    public int load(AssetFileDescriptor afd, int priority) {
        addTaint(priority);
        addTaint(afd.getTaint());
        if(afd != null)        
        {
            long len = afd.getLength();
            if(len < 0)            
            {
                AndroidRuntimeException var393CC3146A2EA1FFFA6DAEB6C124FFCB_1185956942 = new AndroidRuntimeException("no length for fd");
                var393CC3146A2EA1FFFA6DAEB6C124FFCB_1185956942.addTaint(taint);
                throw var393CC3146A2EA1FFFA6DAEB6C124FFCB_1185956942;
            } //End block
            int var6234090674970EC1429B8E622C997865_1954468209 = (_load(afd.getFileDescriptor(), afd.getStartOffset(), len, priority));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1672839798 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1672839798;
        } //End block
        else
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_624677742 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_861666364 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_861666364;
        } //End block
        // ---------- Original Method ----------
        //if (afd != null) {
            //long len = afd.getLength();
            //if (len < 0) {
                //throw new AndroidRuntimeException("no length for fd");
            //}
            //return _load(afd.getFileDescriptor(), afd.getStartOffset(), len, priority);
        //} else {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.181 -0400", hash_original_method = "880A1376217C4927F288F839E096A293", hash_generated_method = "43772C4540B31C0B5A74D67C7C6DDB5F")
    public int load(FileDescriptor fd, long offset, long length, int priority) {
        addTaint(priority);
        addTaint(length);
        addTaint(offset);
        addTaint(fd.getTaint());
        int varC8F5004B9A29EB17EA072643AB2B7EB5_585263977 = (_load(fd, offset, length, priority));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_575111767 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_575111767;
        // ---------- Original Method ----------
        //return _load(fd, offset, length, priority);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.182 -0400", hash_original_method = "85C3F47AB710FF718648D7EFD49684BE", hash_generated_method = "D31CCC5D7AEBF6DF70FC0F36FE5822B7")
    private final int _load(String uri, int priority) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1964384860 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1964384860;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.182 -0400", hash_original_method = "C8E2F6B503F32805E6B119DE960F5701", hash_generated_method = "8A6D03A08939497B9174C9846E938ED1")
    private final int _load(FileDescriptor fd, long offset, long length, int priority) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1718954122 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1718954122;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.183 -0400", hash_original_method = "C196F2E01E1A194C3DA5827EEB00DADF", hash_generated_method = "8350ED742ADE6E0595E47AC4F3848E2B")
    public final boolean unload(int soundID) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_978554852 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_978554852;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.183 -0400", hash_original_method = "9589225497E51729346B545BB33DDBAF", hash_generated_method = "949940A744F6306BF7AB6D8FE00D71F7")
    public final int play(int soundID, float leftVolume, float rightVolume,
            int priority, int loop, float rate) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_663010000 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_663010000;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.183 -0400", hash_original_method = "54A0F66BCDE4EF4A44EB64BA62B8B616", hash_generated_method = "1B96DE7F0F0F25B7ABC5C644C811E81B")
    public final void pause(int streamID) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.184 -0400", hash_original_method = "91631F30419B4DD14ADA49D91B638AA9", hash_generated_method = "95A923223B1C96E9E6BE3271C41575FD")
    public final void resume(int streamID) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.184 -0400", hash_original_method = "8FEE6E2BE62E09C5DD25C1A91956DDC0", hash_generated_method = "F58D9FFBF6ADD695182737FEE632B54C")
    public final void autoPause() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.184 -0400", hash_original_method = "C44CD98A45EC461F196F123D70897C27", hash_generated_method = "30B75233D51EF7C394626A24C5587C8D")
    public final void autoResume() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.184 -0400", hash_original_method = "256BB7EB28001D07413FAE5DCA57A75D", hash_generated_method = "B13AC34B1C92F227C8EEE79ED8C165AC")
    public final void stop(int streamID) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.185 -0400", hash_original_method = "20F7132E4AACD7E452666ABABCAB0364", hash_generated_method = "E0151B9ADCEBBC1E579D4A0430860A48")
    public final void setVolume(int streamID,
            float leftVolume, float rightVolume) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.185 -0400", hash_original_method = "CCA6C13126A90C5188BC1E15A109E7B2", hash_generated_method = "80E7C4F6D2558F499F9F4A7AEFF28831")
    public final void setPriority(int streamID, int priority) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.185 -0400", hash_original_method = "E029D221BD7CC57706C78C8567A53755", hash_generated_method = "A540862950B2359C56A101A8D82DD3DD")
    public final void setLoop(int streamID, int loop) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.186 -0400", hash_original_method = "825447C8FC2A68B86E6BD75A907AFFEE", hash_generated_method = "C48F9D64A0A0274C729E3E2A65DE87F9")
    public final void setRate(int streamID, float rate) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.187 -0400", hash_original_method = "093CAC8CD903CBE9AAF47DBBDF966468", hash_generated_method = "CCF4FF7E592833F3D0A24DC73AF6DB95")
    public void setOnLoadCompleteListener(OnLoadCompleteListener listener) {
        synchronized
(mLock)        {
            if(listener != null)            
            {
                Looper looper;
                if((looper = Looper.myLooper()) != null)                
                {
                    mEventHandler = new EventHandler(this, looper);
                } //End block
                else
                if((looper = Looper.getMainLooper()) != null)                
                {
                    mEventHandler = new EventHandler(this, looper);
                } //End block
                else
                {
                    mEventHandler = null;
                } //End block
            } //End block
            else
            {
                mEventHandler = null;
            } //End block
            mOnLoadCompleteListener = listener;
        } //End block
        // ---------- Original Method ----------
        //synchronized(mLock) {
            //if (listener != null) {
                //Looper looper;
                //if ((looper = Looper.myLooper()) != null) {
                    //mEventHandler = new EventHandler(this, looper);
                //} else if ((looper = Looper.getMainLooper()) != null) {
                    //mEventHandler = new EventHandler(this, looper);
                //} else {
                    //mEventHandler = null;
                //}
            //} else {
                //mEventHandler = null;
            //}
            //mOnLoadCompleteListener = listener;
        //}
    }

    
    private static void postEventFromNative(Object weakRef, int msg, int arg1, int arg2, Object obj) {
        SoundPool soundPool = (SoundPool)((WeakReference)weakRef).get();
        if (soundPool == null)
            return;
        if (soundPool.mEventHandler != null) {
            Message m = soundPool.mEventHandler.obtainMessage(msg, arg1, arg2, obj);
            soundPool.mEventHandler.sendMessage(m);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.188 -0400", hash_original_method = "1E8C38EACEA1E94FE658824D01FD2A18", hash_generated_method = "CBA58CE532C941E2BBE111633905F4A0")
    public final void release() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.189 -0400", hash_original_method = "643150117BD11ABB17CD24F5EE247C54", hash_generated_method = "7401839A6EEFCAC19FEA6ED55F9E3E39")
    private final int native_setup(Object weakRef, int maxStreams, int streamType, int srcQuality) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_670256193 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_670256193;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.189 -0400", hash_original_method = "52F53B59AD091F99DC7C4D49031A27E5", hash_generated_method = "8FAC9FF85A1EF0848C18BB309D51EC09")
    protected void finalize() {
        release();
        // ---------- Original Method ----------
        //release();
    }

    
    private class EventHandler extends Handler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.189 -0400", hash_original_field = "9344E70593C3EBCD40284D9FA74070A0", hash_generated_field = "57F9E596595665A3ABBC76A135513391")

        private SoundPool mSoundPool;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.190 -0400", hash_original_method = "623C6FE52B72FF4CA79E1D55E5E352CD", hash_generated_method = "29C53B8B0392EC6EFD2438BE25CA17E1")
        public  EventHandler(SoundPool soundPool, Looper looper) {
            super(looper);
            addTaint(looper.getTaint());
            mSoundPool = soundPool;
            // ---------- Original Method ----------
            //mSoundPool = soundPool;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.190 -0400", hash_original_method = "489ADADA267AA176412248D35C25EA36", hash_generated_method = "EAEBA4CEF113A90076E76B503980A1EB")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
switch(msg.what){
            case SAMPLE_LOADED:
            if(DEBUG)            
            Log.d(TAG, "Sample " + msg.arg1 + " loaded");
            synchronized
(mLock)            {
                if(mOnLoadCompleteListener != null)                
                {
                    mOnLoadCompleteListener.onLoadComplete(mSoundPool, msg.arg1, msg.arg2);
                } //End block
            } //End block
            break;
            default:
            return;
}
            // ---------- Original Method ----------
            //switch(msg.what) {
            //case SAMPLE_LOADED:
                //if (DEBUG) Log.d(TAG, "Sample " + msg.arg1 + " loaded");
                //synchronized(mLock) {
                    //if (mOnLoadCompleteListener != null) {
                        //mOnLoadCompleteListener.onLoadComplete(mSoundPool, msg.arg1, msg.arg2);
                    //}
                //}
                //break;
            //default:
                //Log.e(TAG, "Unknown message type " + msg.what);
                //return;
            //}
        }

        
    }


    
    public interface OnLoadCompleteListener
    {
        
        public void onLoadComplete(SoundPool soundPool, int sampleId, int status);
    }
    
    static { System.loadLibrary("soundpool"); }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.190 -0400", hash_original_field = "E93ED971A88FCF332F4F5A70FBF40090", hash_generated_field = "6DF3C44590F8CA7F63D7F38A9FE65359")

    private final static String TAG = "SoundPool";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.190 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "7841AA055B417A7E8C3D727A4ADDD91D")

    private final static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.190 -0400", hash_original_field = "905CD6D9A115F9FBDB6F8E86A6943BB7", hash_generated_field = "64F98D007AACFCA5566455D93569C9FC")

    private static final int SAMPLE_LOADED = 1;
}

