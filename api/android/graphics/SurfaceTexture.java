package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.ref.WeakReference;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class SurfaceTexture {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.370 -0400", hash_original_field = "3487E63080D45B4AAFB4C377AC2DEA9F", hash_generated_field = "04D6DC37F0EF901EF71A528809491D49")

    private EventHandler mEventHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.370 -0400", hash_original_field = "639B92941E9F72FB2DAB509585D9EFD4", hash_generated_field = "294E295D0012756EF3396CAF3BBC347B")

    private OnFrameAvailableListener mOnFrameAvailableListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.370 -0400", hash_original_field = "900BC55D29CF07DFEC2F4B5FE0ABC033", hash_generated_field = "F8463E29CE0C76463ADFD57642F32BDF")

    private int mSurfaceTexture;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.370 -0400", hash_original_method = "C7158DCB4D3EE755177A25DCF0F3004D", hash_generated_method = "13E12D1E7782CE5DAEA4C56B1E7081B7")
    public  SurfaceTexture(int texName) {
        this(texName, false);
        addTaint(texName);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.372 -0400", hash_original_method = "67BB7F3D4FE9BE0028412949F77419AD", hash_generated_method = "B2A0E9C07FEC7C8D13D73B6B367CF09B")
    public  SurfaceTexture(int texName, boolean allowSynchronousMode) {
        addTaint(allowSynchronousMode);
        addTaint(texName);
        Looper looper;
    if((looper = Looper.myLooper()) != null)        
        {
            mEventHandler = new EventHandler(looper);
        } //End block
        else
    if((looper = Looper.getMainLooper()) != null)        
        {
            mEventHandler = new EventHandler(looper);
        } //End block
        else
        {
            mEventHandler = null;
        } //End block
        nativeInit(texName, new WeakReference<SurfaceTexture>(this), allowSynchronousMode);
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.372 -0400", hash_original_method = "D25F82A74C11430669962AA7817D10FE", hash_generated_method = "DD5B842D81AE394243957596610A8178")
    public void setOnFrameAvailableListener(OnFrameAvailableListener l) {
        mOnFrameAvailableListener = l;
        // ---------- Original Method ----------
        //mOnFrameAvailableListener = l;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.373 -0400", hash_original_method = "73040EC5A717DD03B1E2713EBAC256DF", hash_generated_method = "F91A5C7620F86F5EA24C5836D02F2D19")
    public void setDefaultBufferSize(int width, int height) {
        addTaint(height);
        addTaint(width);
        nativeSetDefaultBufferSize(width, height);
        // ---------- Original Method ----------
        //nativeSetDefaultBufferSize(width, height);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.373 -0400", hash_original_method = "2A6ADC9927C563F3FF4AF28D3226D576", hash_generated_method = "744097BD4E69198B5926D1436B0C56EB")
    public void updateTexImage() {
        int err = nativeUpdateTexImage();
    if(err != 0)        
        {
            RuntimeException var7BB202BB7263D61A27E45056CC4F3D45_657001122 = new RuntimeException("Error during updateTexImage (see logs)");
            var7BB202BB7263D61A27E45056CC4F3D45_657001122.addTaint(taint);
            throw var7BB202BB7263D61A27E45056CC4F3D45_657001122;
        } //End block
        // ---------- Original Method ----------
        //int err = nativeUpdateTexImage();
        //if (err != 0) {
            //throw new RuntimeException("Error during updateTexImage (see logs)");
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.374 -0400", hash_original_method = "BB625075136BE4BF04377676D5DA464A", hash_generated_method = "4E9290328A89542A2C8F7D6609277128")
    public void getTransformMatrix(float[] mtx) {
        addTaint(mtx[0]);
    if(mtx.length != 16)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_20481036 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_20481036.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_20481036;
        } //End block
        nativeGetTransformMatrix(mtx);
        // ---------- Original Method ----------
        //if (mtx.length != 16) {
            //throw new IllegalArgumentException();
        //}
        //nativeGetTransformMatrix(mtx);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.375 -0400", hash_original_method = "1E06887ADD0CA49D5969AE26836E85A4", hash_generated_method = "6DD6B65A85814D6B4B0B6651F57FA379")
    public long getTimestamp() {
        long varBEECE9A39BF9C4F95DE1D38260730729_1798334010 = (nativeGetTimestamp());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_706844554 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_706844554;
        // ---------- Original Method ----------
        //return nativeGetTimestamp();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.376 -0400", hash_original_method = "D25304D195F58D125972FA32527A0B4B", hash_generated_method = "B7776AF5A8E3FC4F626BC7EA0247303C")
    public void release() {
        nativeRelease();
        // ---------- Original Method ----------
        //nativeRelease();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.376 -0400", hash_original_method = "9BBDD5FE82DE1D04FB6B805CB455ABD6", hash_generated_method = "D2EC0274E3B94A62F39E610CB5453EC2")
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

    
        @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.377 -0400", hash_original_method = "C6EC796BAFF87019C29023815C189B5A", hash_generated_method = "8824C38A2AF18B217147220519528F43")
    private void nativeInit(int texName, Object weakSelf, boolean allowSynchronousMode) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.377 -0400", hash_original_method = "46D026C452E34CB5D17D4D7413C83210", hash_generated_method = "76DCFAD42AA6902991CC86FFBD4823C2")
    private void nativeFinalize() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.378 -0400", hash_original_method = "39631901C5E9C156F840F3431C1EB6A3", hash_generated_method = "E3B4C19945778599093CCCD35B7210D9")
    private void nativeGetTransformMatrix(float[] mtx) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.378 -0400", hash_original_method = "F440D167BF3058541215FA5D0CFEDE56", hash_generated_method = "16662A87D828D5713FAD68331B9204CC")
    private long nativeGetTimestamp() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1422015161 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1422015161;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.378 -0400", hash_original_method = "777FDD0379AC4E914563AFAE47F93745", hash_generated_method = "53D4DFD381964AA171841E2F104BF57E")
    private void nativeSetDefaultBufferSize(int width, int height) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.378 -0400", hash_original_method = "5F79841CB1993D78C92BE65FFA4E3E7E", hash_generated_method = "500D9916884422448C0A964E9DC78758")
    private int nativeUpdateTexImage() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1674599874 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1674599874;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.379 -0400", hash_original_method = "7EC2703D346B1354B6934AD09D0B787F", hash_generated_method = "50A29537685FC3B8ADF137E2079A53E8")
    private int nativeGetQueuedCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1541460138 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1541460138;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.379 -0400", hash_original_method = "2D7DB035F92C7747E201CDD180CCEB34", hash_generated_method = "5B893D9C0D8D139D1AA6F9D31A7778E0")
    private void nativeRelease() {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeClassInit() {
    }

    
    public static class OutOfResourcesException extends Exception {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.379 -0400", hash_original_method = "61F4EF1E830289140B20E24C64AAB8C1", hash_generated_method = "A594474F57F2910DF90E8F2B34F97C87")
        public  OutOfResourcesException() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.380 -0400", hash_original_method = "939C993D5367F7A0F0B43DA6997565C5", hash_generated_method = "5C61F340B8BA1A59560151D83B1A6E5F")
        public  OutOfResourcesException(String name) {
            super(name);
            addTaint(name.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    private class EventHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.380 -0400", hash_original_method = "4C7A877E4BE32D4145A967F6B988F2F0", hash_generated_method = "4725498A7E7F3BCE66A8F5F42E97D427")
        public  EventHandler(Looper looper) {
            super(looper);
            addTaint(looper.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.380 -0400", hash_original_method = "30D4E35B8AF7291102AD4322AA39CBBD", hash_generated_method = "30B5966BCDE8314553CC4C7ACE79EF83")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
    if(mOnFrameAvailableListener != null)            
            {
                mOnFrameAvailableListener.onFrameAvailable(SurfaceTexture.this);
            } //End block
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

