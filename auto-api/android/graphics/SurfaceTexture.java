package android.graphics;

// Droidsafe Imports
import java.lang.ref.WeakReference;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation

public class SurfaceTexture {
    private EventHandler mEventHandler;
    private OnFrameAvailableListener mOnFrameAvailableListener;
    private int mSurfaceTexture;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.470 -0400", hash_original_method = "C7158DCB4D3EE755177A25DCF0F3004D", hash_generated_method = "FD15BE9742F30728E13E3088BB08ED94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SurfaceTexture(int texName) {
        this(texName, false);
        dsTaint.addTaint(texName);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.470 -0400", hash_original_method = "67BB7F3D4FE9BE0028412949F77419AD", hash_generated_method = "910111ED888BD7A0FA6384AC10D9FEA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SurfaceTexture(int texName, boolean allowSynchronousMode) {
        dsTaint.addTaint(allowSynchronousMode);
        dsTaint.addTaint(texName);
        Looper looper;
        {
            boolean var59AC82EBCD14E4AA50598F2AE3563759_1858331829 = ((looper = Looper.myLooper()) != null);
            {
                mEventHandler = new EventHandler(looper);
            } //End block
            {
                boolean var9D854D75870272BF06142F5CE681F893_667265371 = ((looper = Looper.getMainLooper()) != null);
                {
                    mEventHandler = new EventHandler(looper);
                } //End block
                {
                    mEventHandler = null;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.471 -0400", hash_original_method = "D25F82A74C11430669962AA7817D10FE", hash_generated_method = "971DA0AABB2AF117FDF304A3941BE0E4")
    @DSModeled(DSC.SAFE)
    public void setOnFrameAvailableListener(OnFrameAvailableListener l) {
        dsTaint.addTaint(l.dsTaint);
        // ---------- Original Method ----------
        //mOnFrameAvailableListener = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.471 -0400", hash_original_method = "73040EC5A717DD03B1E2713EBAC256DF", hash_generated_method = "EA46EB507DEC7339C50591B6BD044F1B")
    @DSModeled(DSC.SAFE)
    public void setDefaultBufferSize(int width, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        nativeSetDefaultBufferSize(width, height);
        // ---------- Original Method ----------
        //nativeSetDefaultBufferSize(width, height);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.471 -0400", hash_original_method = "2A6ADC9927C563F3FF4AF28D3226D576", hash_generated_method = "C3B7061350799A9E03C7C6AD04B3ACE4")
    @DSModeled(DSC.SAFE)
    public void updateTexImage() {
        int err;
        err = nativeUpdateTexImage();
        {
            throw new RuntimeException("Error during updateTexImage (see logs)");
        } //End block
        // ---------- Original Method ----------
        //int err = nativeUpdateTexImage();
        //if (err != 0) {
            //throw new RuntimeException("Error during updateTexImage (see logs)");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.471 -0400", hash_original_method = "BB625075136BE4BF04377676D5DA464A", hash_generated_method = "530F2F943D09C63D3C0BB36D42085BF7")
    @DSModeled(DSC.SAFE)
    public void getTransformMatrix(float[] mtx) {
        dsTaint.addTaint(mtx);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalArgumentException();
        } //End block
        nativeGetTransformMatrix(mtx);
        // ---------- Original Method ----------
        //if (mtx.length != 16) {
            //throw new IllegalArgumentException();
        //}
        //nativeGetTransformMatrix(mtx);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.471 -0400", hash_original_method = "1E06887ADD0CA49D5969AE26836E85A4", hash_generated_method = "951C317DD10CC60EE264C997CA2B8570")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getTimestamp() {
        long var18BA78939055EC15B891B01928A9AA7A_2006776530 = (nativeGetTimestamp());
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return nativeGetTimestamp();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.471 -0400", hash_original_method = "D25304D195F58D125972FA32527A0B4B", hash_generated_method = "B8B683E64171130DF8B6E14959A9B052")
    @DSModeled(DSC.SAFE)
    public void release() {
        nativeRelease();
        // ---------- Original Method ----------
        //nativeRelease();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.471 -0400", hash_original_method = "9BBDD5FE82DE1D04FB6B805CB455ABD6", hash_generated_method = "CD959B30DC5CF314B1DA65D95C7AE2BC")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.471 -0400", hash_original_method = "7431FEB98B9B53A93696C76CA47D5EA1", hash_generated_method = "69433486C6A90FD2E8F6D5B7F9676837")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.471 -0400", hash_original_method = "C6EC796BAFF87019C29023815C189B5A", hash_generated_method = "FB83DA9F0948C8A19F2C63DE3432BBF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeInit(int texName, Object weakSelf, boolean allowSynchronousMode) {
        dsTaint.addTaint(allowSynchronousMode);
        dsTaint.addTaint(texName);
        dsTaint.addTaint(weakSelf.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.472 -0400", hash_original_method = "46D026C452E34CB5D17D4D7413C83210", hash_generated_method = "AC1B24E599BBFA0E991DA7FE0D281D81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeFinalize() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.472 -0400", hash_original_method = "39631901C5E9C156F840F3431C1EB6A3", hash_generated_method = "0FA8B193601FB12457733B4BCC584CF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeGetTransformMatrix(float[] mtx) {
        dsTaint.addTaint(mtx);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.472 -0400", hash_original_method = "F440D167BF3058541215FA5D0CFEDE56", hash_generated_method = "53F070B94ABEFF392DEF2F7769834B0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long nativeGetTimestamp() {
    	return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.472 -0400", hash_original_method = "777FDD0379AC4E914563AFAE47F93745", hash_generated_method = "261A4AA4981BF0250F96D248F2FF7D7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetDefaultBufferSize(int width, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.472 -0400", hash_original_method = "5F79841CB1993D78C92BE65FFA4E3E7E", hash_generated_method = "3C0D18324617D8E980E27AB2830B346A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeUpdateTexImage() {
    	return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.472 -0400", hash_original_method = "7EC2703D346B1354B6934AD09D0B787F", hash_generated_method = "EE3B42776CBD17A8622CB50B81025E3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeGetQueuedCount() {
    	return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.472 -0400", hash_original_method = "2D7DB035F92C7747E201CDD180CCEB34", hash_generated_method = "4AB1A1C96C71BB4EDE30C3CEC70C6D86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeRelease() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.472 -0400", hash_original_method = "368BCBBAD3F68FEF8C07AE5DC4D2077C", hash_generated_method = "66CFEED3BA0F1B2AF18C8805660BFF70")
    private static void nativeClassInit() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    public static class OutOfResourcesException extends Exception {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.472 -0400", hash_original_method = "61F4EF1E830289140B20E24C64AAB8C1", hash_generated_method = "CFBFC0DB041C16AD2D90FA8588C85EDB")
        @DSModeled(DSC.SAFE)
        public OutOfResourcesException() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.472 -0400", hash_original_method = "939C993D5367F7A0F0B43DA6997565C5", hash_generated_method = "63FF1155466AA653A323C76D2D58DC79")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public OutOfResourcesException(String name) {
            super(name);
            dsTaint.addTaint(name);
            // ---------- Original Method ----------
        }

        
    }


    
    private class EventHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.472 -0400", hash_original_method = "4C7A877E4BE32D4145A967F6B988F2F0", hash_generated_method = "75B0D8A944C97E266ED5E623EB58376A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public EventHandler(Looper looper) {
            super(looper);
            dsTaint.addTaint(looper.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.473 -0400", hash_original_method = "30D4E35B8AF7291102AD4322AA39CBBD", hash_generated_method = "5292BA604CD4543DD0136129EBB26A7F")
        @DSModeled(DSC.SAFE)
        @Override
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
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


