package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.ref.WeakReference;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class SurfaceTexture {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.031 -0400", hash_original_field = "3487E63080D45B4AAFB4C377AC2DEA9F", hash_generated_field = "04D6DC37F0EF901EF71A528809491D49")

    private EventHandler mEventHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.031 -0400", hash_original_field = "639B92941E9F72FB2DAB509585D9EFD4", hash_generated_field = "294E295D0012756EF3396CAF3BBC347B")

    private OnFrameAvailableListener mOnFrameAvailableListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.031 -0400", hash_original_field = "900BC55D29CF07DFEC2F4B5FE0ABC033", hash_generated_field = "F8463E29CE0C76463ADFD57642F32BDF")

    private int mSurfaceTexture;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.032 -0400", hash_original_method = "C7158DCB4D3EE755177A25DCF0F3004D", hash_generated_method = "13E12D1E7782CE5DAEA4C56B1E7081B7")
    public  SurfaceTexture(int texName) {
        this(texName, false);
        addTaint(texName);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.033 -0400", hash_original_method = "67BB7F3D4FE9BE0028412949F77419AD", hash_generated_method = "633A72B29A4B56112DA7F1E9E1507386")
    public  SurfaceTexture(int texName, boolean allowSynchronousMode) {
        Looper looper;
        {
            boolean var59AC82EBCD14E4AA50598F2AE3563759_1884965371 = ((looper = Looper.myLooper()) != null);
            {
                mEventHandler = new EventHandler(looper);
            } //End block
            {
                boolean var9D854D75870272BF06142F5CE681F893_633951490 = ((looper = Looper.getMainLooper()) != null);
                {
                    mEventHandler = new EventHandler(looper);
                } //End block
                {
                    mEventHandler = null;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        nativeInit(texName, new WeakReference<SurfaceTexture>(this), allowSynchronousMode);
        addTaint(texName);
        addTaint(allowSynchronousMode);
        // ---------- Original Method ----------
        //Looper looper;
        //if ((looper = Looper.myLooper()) != null) {
            //mEventHandler = new EventHandler(looper);
        //} else if ((looper = Looper.getMainLooper()) != null) {
            //mEventHandler = new EventHandler(looper);
        //} else {
            //mEventHandler = null;
        //}
        //nativeInit(texName, new WeakReference<SurfaceTexture>(this), allowSynchronousMode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.036 -0400", hash_original_method = "D25F82A74C11430669962AA7817D10FE", hash_generated_method = "DD5B842D81AE394243957596610A8178")
    public void setOnFrameAvailableListener(OnFrameAvailableListener l) {
        mOnFrameAvailableListener = l;
        // ---------- Original Method ----------
        //mOnFrameAvailableListener = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.051 -0400", hash_original_method = "73040EC5A717DD03B1E2713EBAC256DF", hash_generated_method = "A4145A0245B3888FB176CF0DDAA2B447")
    public void setDefaultBufferSize(int width, int height) {
        nativeSetDefaultBufferSize(width, height);
        addTaint(width);
        addTaint(height);
        // ---------- Original Method ----------
        //nativeSetDefaultBufferSize(width, height);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.051 -0400", hash_original_method = "2A6ADC9927C563F3FF4AF28D3226D576", hash_generated_method = "626C83F49A511CBA8917FD997666A882")
    public void updateTexImage() {
        int err;
        err = nativeUpdateTexImage();
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Error during updateTexImage (see logs)");
        } //End block
        // ---------- Original Method ----------
        //int err = nativeUpdateTexImage();
        //if (err != 0) {
            //throw new RuntimeException("Error during updateTexImage (see logs)");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.052 -0400", hash_original_method = "BB625075136BE4BF04377676D5DA464A", hash_generated_method = "0E1F03DB38B24954FE657591E6FFBCDE")
    public void getTransformMatrix(float[] mtx) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        nativeGetTransformMatrix(mtx);
        addTaint(mtx[0]);
        // ---------- Original Method ----------
        //if (mtx.length != 16) {
            //throw new IllegalArgumentException();
        //}
        //nativeGetTransformMatrix(mtx);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.053 -0400", hash_original_method = "1E06887ADD0CA49D5969AE26836E85A4", hash_generated_method = "7F348346130826DD252E3730468C6C15")
    public long getTimestamp() {
        long var18BA78939055EC15B891B01928A9AA7A_676443789 = (nativeGetTimestamp());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2108819982 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2108819982;
        // ---------- Original Method ----------
        //return nativeGetTimestamp();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.053 -0400", hash_original_method = "D25304D195F58D125972FA32527A0B4B", hash_generated_method = "B7776AF5A8E3FC4F626BC7EA0247303C")
    public void release() {
        nativeRelease();
        // ---------- Original Method ----------
        //nativeRelease();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.059 -0400", hash_original_method = "9BBDD5FE82DE1D04FB6B805CB455ABD6", hash_generated_method = "D2EC0274E3B94A62F39E610CB5453EC2")
    protected void finalize() throws Throwable {
        try 
        {
            nativeFinalize();
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //nativeFinalize();
        //} finally {
            //super.finalize();
        //}
    }

    
        @SuppressWarnings({"UnusedDeclaration"})
    private static void postEventFromNative(Object selfRef) {
        WeakReference weakSelf = (WeakReference)selfRef;
        SurfaceTexture st = (SurfaceTexture)weakSelf.get();
        if (st == null) {
            return;
        }
        if (st.mEventHandler != null) {
            Message m = st.mEventHandler.obtainMessage();
            st.mEventHandler.sendMessage(m);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.060 -0400", hash_original_method = "C6EC796BAFF87019C29023815C189B5A", hash_generated_method = "8824C38A2AF18B217147220519528F43")
    private void nativeInit(int texName, Object weakSelf, boolean allowSynchronousMode) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.060 -0400", hash_original_method = "46D026C452E34CB5D17D4D7413C83210", hash_generated_method = "76DCFAD42AA6902991CC86FFBD4823C2")
    private void nativeFinalize() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.060 -0400", hash_original_method = "39631901C5E9C156F840F3431C1EB6A3", hash_generated_method = "E3B4C19945778599093CCCD35B7210D9")
    private void nativeGetTransformMatrix(float[] mtx) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.077 -0400", hash_original_method = "F440D167BF3058541215FA5D0CFEDE56", hash_generated_method = "4932A0A2FE2EC8DE7D664D4E953A6ED1")
    private long nativeGetTimestamp() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_63893704 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_63893704;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.078 -0400", hash_original_method = "777FDD0379AC4E914563AFAE47F93745", hash_generated_method = "53D4DFD381964AA171841E2F104BF57E")
    private void nativeSetDefaultBufferSize(int width, int height) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.078 -0400", hash_original_method = "5F79841CB1993D78C92BE65FFA4E3E7E", hash_generated_method = "016236CD0FD9C199EFBF0807C7E55787")
    private int nativeUpdateTexImage() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_469975461 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_469975461;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.084 -0400", hash_original_method = "7EC2703D346B1354B6934AD09D0B787F", hash_generated_method = "D35986ECB684D6239B5CB306671F28B6")
    private int nativeGetQueuedCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1985021015 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1985021015;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.085 -0400", hash_original_method = "2D7DB035F92C7747E201CDD180CCEB34", hash_generated_method = "5B893D9C0D8D139D1AA6F9D31A7778E0")
    private void nativeRelease() {
    }

    
        private static void nativeClassInit() {
    }

    
    public static class OutOfResourcesException extends Exception {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.088 -0400", hash_original_method = "61F4EF1E830289140B20E24C64AAB8C1", hash_generated_method = "A594474F57F2910DF90E8F2B34F97C87")
        public  OutOfResourcesException() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.089 -0400", hash_original_method = "939C993D5367F7A0F0B43DA6997565C5", hash_generated_method = "5C61F340B8BA1A59560151D83B1A6E5F")
        public  OutOfResourcesException(String name) {
            super(name);
            addTaint(name.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    private class EventHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.089 -0400", hash_original_method = "4C7A877E4BE32D4145A967F6B988F2F0", hash_generated_method = "4725498A7E7F3BCE66A8F5F42E97D427")
        public  EventHandler(Looper looper) {
            super(looper);
            addTaint(looper.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.100 -0400", hash_original_method = "30D4E35B8AF7291102AD4322AA39CBBD", hash_generated_method = "101082AAC3B3CEB4E5ECC03F362BDE11")
        @Override
        public void handleMessage(Message msg) {
            {
                mOnFrameAvailableListener.onFrameAvailable(SurfaceTexture.this);
            } //End block
            addTaint(msg.getTaint());
            // ---------- Original Method ----------
            //if (mOnFrameAvailableListener != null) {
                //mOnFrameAvailableListener.onFrameAvailable(SurfaceTexture.this);
            //}
        }

        
    }


    
    public interface OnFrameAvailableListener {
        void onFrameAvailable(SurfaceTexture surfaceTexture);
    }
    
    static { nativeClassInit(); }
    
}

