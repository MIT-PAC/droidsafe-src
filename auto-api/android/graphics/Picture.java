package android.graphics;

// Droidsafe Imports
import java.io.InputStream;
import java.io.OutputStream;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSUtils;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation

public class Picture {
    private Canvas mRecordingCanvas;
    private final int mNativePicture;
    private static final int WORKING_STREAM_STORAGE = 16 * 1024;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.297 -0400", hash_original_method = "2489F1714C6AB52D2B9965C8B69500DD", hash_generated_method = "BE75E5860C4E08BC1ABD193B1CB372DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Picture() {
        this(nativeConstructor(0));
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.298 -0400", hash_original_method = "0B8FC63E2385743B0CD030A74D7237E0", hash_generated_method = "F2DFAE0CF26682561D71CBD93AAE450D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Picture(Picture src) {
        this(nativeConstructor(src != null ? src.mNativePicture : 0));
        dsTaint.addTaint(src.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.298 -0400", hash_original_method = "4720BFD5C543F65C552F0739FF1DD2E7", hash_generated_method = "3C6DF37B22CBADFFE610113D21CF19EA")
    @DSModeled(DSC.SAFE)
    private Picture(int nativePicture) {
        dsTaint.addTaint(nativePicture);
        {
            throw new RuntimeException();
        } //End block
        // ---------- Original Method ----------
        //if (nativePicture == 0) {
            //throw new RuntimeException();
        //}
        //mNativePicture = nativePicture;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.298 -0400", hash_original_method = "20E22D7D195E3391E43BD9FB13A423DE", hash_generated_method = "77F941B1E5B9DDA21D395C7EA8F20E41")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.298 -0400", hash_original_method = "4B70DEBF1EF0DC56C3D034BE86F32949", hash_generated_method = "28399EE02E216A98422EB15257576FDD")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.298 -0400", hash_original_method = "D4E7715F32876041521BE16EC8E1C0AC", hash_generated_method = "8202ACDF7C5D29ED74BE3232863D1E31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getWidth() {
    	return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.298 -0400", hash_original_method = "E09BF3A531DEFF54888EDA3B98EB9CFF", hash_generated_method = "CFD12F7A9648C1DBAD827DBA35D4B80A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getHeight() {
    	return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.298 -0400", hash_original_method = "DC7CFB067EE80684132B2B92372F3B79", hash_generated_method = "55776D9B2DACFF9B0833A5C4920D0721")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.298 -0400", hash_original_method = "088B6D36E7315E28AFCE4F1DFAAB72D3", hash_generated_method = "0B4BAF19FBE4483E75DF5B1663D766EE")
    public static Picture createFromStream(InputStream stream) {
        return new Picture(
            nativeCreateFromStream(stream, new byte[WORKING_STREAM_STORAGE]));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.298 -0400", hash_original_method = "5D2FA2739AFC080B35312B93ED4EB821", hash_generated_method = "A1852525F9F01B26ADF810ECFF581DA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToStream(OutputStream stream) {
        dsTaint.addTaint(stream.dsTaint);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new NullPointerException();
        } //End block
        {
            boolean varAD32F998F4C478CC17387CBF60C9B455_1857910847 = (!nativeWriteToStream(mNativePicture, stream,
                             new byte[WORKING_STREAM_STORAGE]));
            if (DroidSafeAndroidRuntime.control)
            {
                throw new RuntimeException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.299 -0400", hash_original_method = "A9ACB715DF1E16C6B20EA656F0034A3C", hash_generated_method = "0064F60FCB9289E24FF2E61317D35E67")
    @DSModeled(DSC.SAFE)
    protected void finalize() throws Throwable {
        nativeDestructor(mNativePicture);
        // ---------- Original Method ----------
        //nativeDestructor(mNativePicture);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.299 -0400", hash_original_method = "C2445D1D52466847173519B3E77D61F5", hash_generated_method = "EFEEC6BFFBB5D05F4175A89A6B4EF9A3")
    @DSModeled(DSC.SAFE)
    final int ni() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mNativePicture;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.299 -0400", hash_original_method = "3636BAC8732FF96378A1BE315B0516F2", hash_generated_method = "0DBD6CCDD8D44C1574CE75EF98ACAA2D")
    private static int nativeConstructor(int nativeSrcOr0) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.299 -0400", hash_original_method = "7FA311127412CD340871FDF8F0142F7E", hash_generated_method = "DF253043EB2672E6CA0FEE8DF60D32DD")
    private static int nativeCreateFromStream(InputStream stream,
                                                byte[] storage) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.299 -0400", hash_original_method = "F602CC0F97BB9E702F82EAFDC01A818D", hash_generated_method = "70D207B74A1767ACCE74FFA0979737B3")
    private static int nativeBeginRecording(int nativeCanvas,
                                                    int w, int h) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.299 -0400", hash_original_method = "E93BD5F5740A4889902D3721362E635E", hash_generated_method = "56B3D2CAE67C5D3770CE04A6E08AF6C5")
    private static void nativeEndRecording(int nativeCanvas) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.299 -0400", hash_original_method = "CAC5B100804A40467268DA07399C9CAF", hash_generated_method = "A0388593D20479252EA5869213B6017F")
    private static void nativeDraw(int nativeCanvas, int nativePicture) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.299 -0400", hash_original_method = "DC2BEBA732A6A50260E54B99991FA0A4", hash_generated_method = "2F89F772FA3ABC395318BD6C838BDEDE")
    private static boolean nativeWriteToStream(int nativePicture,
                                           OutputStream stream, byte[] storage) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.299 -0400", hash_original_method = "B13B4B2D73EAD3025A246E3798034DAC", hash_generated_method = "DDDEF9EF732C71B242927258CD767BFB")
    private static void nativeDestructor(int nativePicture) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    private static class RecordingCanvas extends Canvas {
        private /* final */ Picture mPicture;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.299 -0400", hash_original_method = "2A456EE78DB6B79255D736BC2BE0949A", hash_generated_method = "399CF781AAD2DDC93482CDABA502A7A8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RecordingCanvas(Picture pict, int nativeCanvas) {
            super(nativeCanvas);
            dsTaint.addTaint(pict.dsTaint);
            dsTaint.addTaint(nativeCanvas);
            // ---------- Original Method ----------
            //mPicture = pict;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.299 -0400", hash_original_method = "6CF0BDC754DD98C47DAA94E49A23367D", hash_generated_method = "E56CC8B8B0E3A01258DB8A2CBDDADD9E")
        @DSModeled(DSC.SAFE)
        @Override
        public void setBitmap(Bitmap bitmap) {
            dsTaint.addTaint(bitmap.dsTaint);
            throw new RuntimeException(
                                "Cannot call setBitmap on a picture canvas");
            // ---------- Original Method ----------
            //throw new RuntimeException(
                                //"Cannot call setBitmap on a picture canvas");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.300 -0400", hash_original_method = "37BF59928A286475E8AAF8FA82084BAA", hash_generated_method = "01EDCB5E35BA312FAE3F1227FFC9A28D")
        @DSModeled(DSC.SAFE)
        @Override
        public void drawPicture(Picture picture) {
            dsTaint.addTaint(picture.dsTaint);
            if (DroidSafeAndroidRuntime.control)
            {
                throw new RuntimeException(
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


    
}


