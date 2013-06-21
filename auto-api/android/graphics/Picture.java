package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.InputStream;
import java.io.OutputStream;

public class Picture {
    private Canvas mRecordingCanvas;
    private int mNativePicture;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.513 -0400", hash_original_method = "2489F1714C6AB52D2B9965C8B69500DD", hash_generated_method = "63528B2E8ADC16DD1C04E65808C24AEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Picture() {
        this(nativeConstructor(0));
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.514 -0400", hash_original_method = "0B8FC63E2385743B0CD030A74D7237E0", hash_generated_method = "F5EFA12A8B351631D4C3BC8C70C0EC38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Picture(Picture src) {
        this(nativeConstructor(src != null ? src.mNativePicture : 0));
        dsTaint.addTaint(src.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.514 -0400", hash_original_method = "4720BFD5C543F65C552F0739FF1DD2E7", hash_generated_method = "FA9F35E992BEC50354E22559AF0AF48E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Picture(int nativePicture) {
        dsTaint.addTaint(nativePicture);
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException();
        } //End block
        // ---------- Original Method ----------
        //if (nativePicture == 0) {
            //throw new RuntimeException();
        //}
        //mNativePicture = nativePicture;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.515 -0400", hash_original_method = "20E22D7D195E3391E43BD9FB13A423DE", hash_generated_method = "641AE2154621E5555685D4ADD376BD3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Canvas beginRecording(int width, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        int ni;
        ni = nativeBeginRecording(mNativePicture, width, height);
        mRecordingCanvas = new RecordingCanvas(this, ni);
        return (Canvas)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int ni = nativeBeginRecording(mNativePicture, width, height);
        //mRecordingCanvas = new RecordingCanvas(this, ni);
        //return mRecordingCanvas;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.515 -0400", hash_original_method = "4B70DEBF1EF0DC56C3D034BE86F32949", hash_generated_method = "2A735E704B28EC1A42C597E28B57117E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void endRecording() {
        {
            mRecordingCanvas = null;
            nativeEndRecording(mNativePicture);
        } //End block
        // ---------- Original Method ----------
        //if (mRecordingCanvas != null) {
            //mRecordingCanvas = null;
            //nativeEndRecording(mNativePicture);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.515 -0400", hash_original_method = "D4E7715F32876041521BE16EC8E1C0AC", hash_generated_method = "DF8B748F0B24EE0E7526D789A40020BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getWidth() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.515 -0400", hash_original_method = "E09BF3A531DEFF54888EDA3B98EB9CFF", hash_generated_method = "74072A037789FBB3D4EA8BB8DEA4D056")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getHeight() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.515 -0400", hash_original_method = "DC7CFB067EE80684132B2B92372F3B79", hash_generated_method = "633963F5F072F72C92FDA7DC309646AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void draw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        {
            endRecording();
        } //End block
        nativeDraw(canvas.mNativeCanvas, mNativePicture);
        // ---------- Original Method ----------
        //if (mRecordingCanvas != null) {
            //endRecording();
        //}
        //nativeDraw(canvas.mNativeCanvas, mNativePicture);
    }

    
        public static Picture createFromStream(InputStream stream) {
        return new Picture(
            nativeCreateFromStream(stream, new byte[WORKING_STREAM_STORAGE]));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.516 -0400", hash_original_method = "5D2FA2739AFC080B35312B93ED4EB821", hash_generated_method = "441DE6E4E634A651FF12FB8ADD0B65AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToStream(OutputStream stream) {
        dsTaint.addTaint(stream.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean varAD32F998F4C478CC17387CBF60C9B455_1912967397 = (!nativeWriteToStream(mNativePicture, stream,
                             new byte[WORKING_STREAM_STORAGE]));
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (stream == null) {
            //throw new NullPointerException();
        //}
        //if (!nativeWriteToStream(mNativePicture, stream,
                             //new byte[WORKING_STREAM_STORAGE])) {
            //throw new RuntimeException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.516 -0400", hash_original_method = "A9ACB715DF1E16C6B20EA656F0034A3C", hash_generated_method = "65406D5C08A00AE047C5B3642566D2E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void finalize() throws Throwable {
        nativeDestructor(mNativePicture);
        // ---------- Original Method ----------
        //nativeDestructor(mNativePicture);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.516 -0400", hash_original_method = "C2445D1D52466847173519B3E77D61F5", hash_generated_method = "CB8B2656981EE7FEE6CBC63085B8657C")
    @DSModeled(DSC.SAFE)
    final int ni() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mNativePicture;
    }

    
        private static int nativeConstructor(int nativeSrcOr0) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int nativeCreateFromStream(InputStream stream,
                                                byte[] storage) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int nativeBeginRecording(int nativeCanvas,
                                                    int w, int h) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void nativeEndRecording(int nativeCanvas) {
    }

    
        private static void nativeDraw(int nativeCanvas, int nativePicture) {
    }

    
        private static boolean nativeWriteToStream(int nativePicture,
                                           OutputStream stream, byte[] storage) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static void nativeDestructor(int nativePicture) {
    }

    
    private static class RecordingCanvas extends Canvas {
        private Picture mPicture;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.518 -0400", hash_original_method = "2A456EE78DB6B79255D736BC2BE0949A", hash_generated_method = "40EA16A7D165F184D0AB890684ADEC5E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RecordingCanvas(Picture pict, int nativeCanvas) {
            super(nativeCanvas);
            dsTaint.addTaint(pict.dsTaint);
            dsTaint.addTaint(nativeCanvas);
            // ---------- Original Method ----------
            //mPicture = pict;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.518 -0400", hash_original_method = "6CF0BDC754DD98C47DAA94E49A23367D", hash_generated_method = "2737CF1609058F58A178E6841D10C1FE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setBitmap(Bitmap bitmap) {
            dsTaint.addTaint(bitmap.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                                "Cannot call setBitmap on a picture canvas");
            // ---------- Original Method ----------
            //throw new RuntimeException(
                                //"Cannot call setBitmap on a picture canvas");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.519 -0400", hash_original_method = "37BF59928A286475E8AAF8FA82084BAA", hash_generated_method = "E38BF59079A0F5D188E2F6484E7E01DD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void drawPicture(Picture picture) {
            dsTaint.addTaint(picture.dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Cannot draw a picture into its recording canvas");
            } //End block
            super.drawPicture(picture);
            // ---------- Original Method ----------
            //if (mPicture == picture) {
                //throw new RuntimeException(
                            //"Cannot draw a picture into its recording canvas");
            //}
            //super.drawPicture(picture);
        }

        
    }


    
    private static final int WORKING_STREAM_STORAGE = 16 * 1024;
}

