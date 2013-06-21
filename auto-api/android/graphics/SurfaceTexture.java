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
    private EventHandler mEventHandler;
    private OnFrameAvailableListener mOnFrameAvailableListener;
    private int mSurfaceTexture;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.816 -0400", hash_original_method = "C7158DCB4D3EE755177A25DCF0F3004D", hash_generated_method = "549D7C366A69BF24F815CA650983683C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SurfaceTexture(int texName) {
        this(texName, false);
        dsTaint.addTaint(texName);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.816 -0400", hash_original_method = "67BB7F3D4FE9BE0028412949F77419AD", hash_generated_method = "CC3ADE33B5E4D40B06948419289C3A8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SurfaceTexture(int texName, boolean allowSynchronousMode) {
        dsTaint.addTaint(allowSynchronousMode);
        dsTaint.addTaint(texName);
        Looper looper;
        {
            boolean var59AC82EBCD14E4AA50598F2AE3563759_639140323 = ((looper = Looper.myLooper()) != null);
            {
                mEventHandler = new EventHandler(looper);
            } //End block
            {
                boolean var9D854D75870272BF06142F5CE681F893_1376815927 = ((looper = Looper.getMainLooper()) != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.816 -0400", hash_original_method = "D25F82A74C11430669962AA7817D10FE", hash_generated_method = "EF873476D3CD5FB47A732160C48E5233")
    @DSModeled(DSC.SAFE)
    public void setOnFrameAvailableListener(OnFrameAvailableListener l) {
        dsTaint.addTaint(l.dsTaint);
        // ---------- Original Method ----------
        //mOnFrameAvailableListener = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.816 -0400", hash_original_method = "73040EC5A717DD03B1E2713EBAC256DF", hash_generated_method = "8690D32222CD33B5FA8A8A9A0A7E0698")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDefaultBufferSize(int width, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        nativeSetDefaultBufferSize(width, height);
        // ---------- Original Method ----------
        //nativeSetDefaultBufferSize(width, height);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.817 -0400", hash_original_method = "2A6ADC9927C563F3FF4AF28D3226D576", hash_generated_method = "626C83F49A511CBA8917FD997666A882")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.817 -0400", hash_original_method = "BB625075136BE4BF04377676D5DA464A", hash_generated_method = "66EFECC841E678848FA4C98A413FDDD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getTransformMatrix(float[] mtx) {
        dsTaint.addTaint(mtx[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        nativeGetTransformMatrix(mtx);
        // ---------- Original Method ----------
        //if (mtx.length != 16) {
            //throw new IllegalArgumentException();
        //}
        //nativeGetTransformMatrix(mtx);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.817 -0400", hash_original_method = "1E06887ADD0CA49D5969AE26836E85A4", hash_generated_method = "6B643500ACFD1708FBB42551CF867364")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getTimestamp() {
        long var18BA78939055EC15B891B01928A9AA7A_69081127 = (nativeGetTimestamp());
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return nativeGetTimestamp();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.818 -0400", hash_original_method = "D25304D195F58D125972FA32527A0B4B", hash_generated_method = "B7776AF5A8E3FC4F626BC7EA0247303C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void release() {
        nativeRelease();
        // ---------- Original Method ----------
        //nativeRelease();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.818 -0400", hash_original_method = "9BBDD5FE82DE1D04FB6B805CB455ABD6", hash_generated_method = "D2EC0274E3B94A62F39E610CB5453EC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.818 -0400", hash_original_method = "C6EC796BAFF87019C29023815C189B5A", hash_generated_method = "243AB1157356E131D9F5689165A108E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeInit(int texName, Object weakSelf, boolean allowSynchronousMode) {
        dsTaint.addTaint(allowSynchronousMode);
        dsTaint.addTaint(texName);
        dsTaint.addTaint(weakSelf.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.818 -0400", hash_original_method = "46D026C452E34CB5D17D4D7413C83210", hash_generated_method = "76DCFAD42AA6902991CC86FFBD4823C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeFinalize() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.819 -0400", hash_original_method = "39631901C5E9C156F840F3431C1EB6A3", hash_generated_method = "7CB56511ECBD7C4D44B8053CD5A40BF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeGetTransformMatrix(float[] mtx) {
        dsTaint.addTaint(mtx[0]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.819 -0400", hash_original_method = "F440D167BF3058541215FA5D0CFEDE56", hash_generated_method = "C3A9184F62A022988390F278B2EBA4B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long nativeGetTimestamp() {
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.820 -0400", hash_original_method = "777FDD0379AC4E914563AFAE47F93745", hash_generated_method = "AD7E0F1D529AB82271AFB5C4A0B33323")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetDefaultBufferSize(int width, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.821 -0400", hash_original_method = "5F79841CB1993D78C92BE65FFA4E3E7E", hash_generated_method = "535A7EF1944A2C7EE5C0127D0BBCC9E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeUpdateTexImage() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.821 -0400", hash_original_method = "7EC2703D346B1354B6934AD09D0B787F", hash_generated_method = "7535D2A9BE41DC99D3C12F2191358BE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeGetQueuedCount() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.821 -0400", hash_original_method = "2D7DB035F92C7747E201CDD180CCEB34", hash_generated_method = "5B893D9C0D8D139D1AA6F9D31A7778E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeRelease() {
    }

    
        private static void nativeClassInit() {
    }

    
    public static class OutOfResourcesException extends Exception {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.822 -0400", hash_original_method = "61F4EF1E830289140B20E24C64AAB8C1", hash_generated_method = "A594474F57F2910DF90E8F2B34F97C87")
        @DSModeled(DSC.SAFE)
        public OutOfResourcesException() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.822 -0400", hash_original_method = "939C993D5367F7A0F0B43DA6997565C5", hash_generated_method = "D2827E50CE1819C8467D6B826BD6F810")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public OutOfResourcesException(String name) {
            super(name);
            dsTaint.addTaint(name);
            // ---------- Original Method ----------
        }

        
    }


    
    private class EventHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.822 -0400", hash_original_method = "4C7A877E4BE32D4145A967F6B988F2F0", hash_generated_method = "DA32BA1C270E3EB0D5B17D6F27A96764")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public EventHandler(Looper looper) {
            super(looper);
            dsTaint.addTaint(looper.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.822 -0400", hash_original_method = "30D4E35B8AF7291102AD4322AA39CBBD", hash_generated_method = "80B039B6739313F21C8485B855CA6904")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

