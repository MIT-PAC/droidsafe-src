package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.InputStream;
import java.io.OutputStream;

public class Picture {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.717 -0400", hash_original_field = "205AF319C70DD39AC12A7A810F070D6A", hash_generated_field = "A1B5C5158D5DEB28A2820BEDFBA48246")

    private Canvas mRecordingCanvas;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.717 -0400", hash_original_field = "EB3D0953DBC0B65EBA1482F45D0B169C", hash_generated_field = "08C3B2ACCECB8572107176C70CDC69B3")

    private int mNativePicture;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.717 -0400", hash_original_method = "2489F1714C6AB52D2B9965C8B69500DD", hash_generated_method = "63528B2E8ADC16DD1C04E65808C24AEE")
    public  Picture() {
        this(nativeConstructor(0));
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.717 -0400", hash_original_method = "0B8FC63E2385743B0CD030A74D7237E0", hash_generated_method = "BEB05DE5939B8E76EE1EA7255E1E3D3A")
    public  Picture(Picture src) {
        this(nativeConstructor(src != null ? src.mNativePicture : 0));
        addTaint(src.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.718 -0400", hash_original_method = "4720BFD5C543F65C552F0739FF1DD2E7", hash_generated_method = "7747409E3B4A04AA3BB59D62F8883814")
    private  Picture(int nativePicture) {
    if(nativePicture == 0)        
        {
            RuntimeException varF1484B21EF4EE84F790184975238945B_1091199594 = new RuntimeException();
            varF1484B21EF4EE84F790184975238945B_1091199594.addTaint(taint);
            throw varF1484B21EF4EE84F790184975238945B_1091199594;
        } //End block
        mNativePicture = nativePicture;
        // ---------- Original Method ----------
        //if (nativePicture == 0) {
            //throw new RuntimeException();
        //}
        //mNativePicture = nativePicture;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.718 -0400", hash_original_method = "20E22D7D195E3391E43BD9FB13A423DE", hash_generated_method = "A2095EAAECBC7182AF435E90D9A95630")
    public Canvas beginRecording(int width, int height) {
        addTaint(height);
        addTaint(width);
        int ni = nativeBeginRecording(mNativePicture, width, height);
        mRecordingCanvas = new RecordingCanvas(this, ni);
Canvas var1D97605435A680D4B9EC641401BFF9EE_1430995049 =         mRecordingCanvas;
        var1D97605435A680D4B9EC641401BFF9EE_1430995049.addTaint(taint);
        return var1D97605435A680D4B9EC641401BFF9EE_1430995049;
        // ---------- Original Method ----------
        //int ni = nativeBeginRecording(mNativePicture, width, height);
        //mRecordingCanvas = new RecordingCanvas(this, ni);
        //return mRecordingCanvas;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.719 -0400", hash_original_method = "4B70DEBF1EF0DC56C3D034BE86F32949", hash_generated_method = "6C8796540064B50705D12C6EBCDC58FA")
    public void endRecording() {
    if(mRecordingCanvas != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.719 -0400", hash_original_method = "D4E7715F32876041521BE16EC8E1C0AC", hash_generated_method = "85E24EA39B1293CBD8BB3FEB1DB550AC")
    public int getWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1893710660 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1893710660;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.719 -0400", hash_original_method = "E09BF3A531DEFF54888EDA3B98EB9CFF", hash_generated_method = "5469A48855EF638B35A8D38628B25735")
    public int getHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_999429503 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_999429503;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.720 -0400", hash_original_method = "DC7CFB067EE80684132B2B92372F3B79", hash_generated_method = "B467DEB9F2198F0D4B06EBCE6806E8AC")
    public void draw(Canvas canvas) {
        addTaint(canvas.getTaint());
    if(mRecordingCanvas != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.721 -0400", hash_original_method = "5D2FA2739AFC080B35312B93ED4EB821", hash_generated_method = "15853A5CCFD0ADFDDEEBD1C7E227A626")
    public void writeToStream(OutputStream stream) {
        addTaint(stream.getTaint());
    if(stream == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_361374864 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_361374864.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_361374864;
        } //End block
    if(!nativeWriteToStream(mNativePicture, stream,
                             new byte[WORKING_STREAM_STORAGE]))        
        {
            RuntimeException varF1484B21EF4EE84F790184975238945B_1425502626 = new RuntimeException();
            varF1484B21EF4EE84F790184975238945B_1425502626.addTaint(taint);
            throw varF1484B21EF4EE84F790184975238945B_1425502626;
        } //End block
        // ---------- Original Method ----------
        //if (stream == null) {
            //throw new NullPointerException();
        //}
        //if (!nativeWriteToStream(mNativePicture, stream,
                             //new byte[WORKING_STREAM_STORAGE])) {
            //throw new RuntimeException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.721 -0400", hash_original_method = "A9ACB715DF1E16C6B20EA656F0034A3C", hash_generated_method = "65406D5C08A00AE047C5B3642566D2E9")
    protected void finalize() throws Throwable {
        nativeDestructor(mNativePicture);
        // ---------- Original Method ----------
        //nativeDestructor(mNativePicture);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.722 -0400", hash_original_method = "C2445D1D52466847173519B3E77D61F5", hash_generated_method = "0E0469313986BB5220906AD032EE0344")
    final int ni() {
        int varEB3D0953DBC0B65EBA1482F45D0B169C_214208234 = (mNativePicture);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1537256125 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1537256125;
        // ---------- Original Method ----------
        //return mNativePicture;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeConstructor(int nativeSrcOr0) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeCreateFromStream(InputStream stream,
                                                byte[] storage) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeBeginRecording(int nativeCanvas,
                                                    int w, int h) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeEndRecording(int nativeCanvas) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeDraw(int nativeCanvas, int nativePicture) {
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeWriteToStream(int nativePicture,
                                           OutputStream stream, byte[] storage) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeDestructor(int nativePicture) {
    }

    
    private static class RecordingCanvas extends Canvas {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.725 -0400", hash_original_field = "E97A703985A58F8707A878E051453537", hash_generated_field = "C3E778DE5EE29E2C4788703FE56860BD")

        private Picture mPicture;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.725 -0400", hash_original_method = "2A456EE78DB6B79255D736BC2BE0949A", hash_generated_method = "9A52DF88588713E0DD3B90E3BE8D18C0")
        public  RecordingCanvas(Picture pict, int nativeCanvas) {
            super(nativeCanvas);
            addTaint(nativeCanvas);
            mPicture = pict;
            // ---------- Original Method ----------
            //mPicture = pict;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.725 -0400", hash_original_method = "6CF0BDC754DD98C47DAA94E49A23367D", hash_generated_method = "5BB84C57602EDF31B2A46FB378573E1D")
        @Override
        public void setBitmap(Bitmap bitmap) {
            addTaint(bitmap.getTaint());
            RuntimeException var3EE550AF39B02FF8E426CCE34EA9A042_1988381390 = new RuntimeException(
                                "Cannot call setBitmap on a picture canvas");
            var3EE550AF39B02FF8E426CCE34EA9A042_1988381390.addTaint(taint);
            throw var3EE550AF39B02FF8E426CCE34EA9A042_1988381390;
            // ---------- Original Method ----------
            //throw new RuntimeException(
                                //"Cannot call setBitmap on a picture canvas");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.726 -0400", hash_original_method = "37BF59928A286475E8AAF8FA82084BAA", hash_generated_method = "DD600DF41CE931C4C0A645B9619093DF")
        @Override
        public void drawPicture(Picture picture) {
            addTaint(picture.getTaint());
    if(mPicture == picture)            
            {
                RuntimeException varF06980F6141921D11E9F48E5562373BE_1088655599 = new RuntimeException(
                            "Cannot draw a picture into its recording canvas");
                varF06980F6141921D11E9F48E5562373BE_1088655599.addTaint(taint);
                throw varF06980F6141921D11E9F48E5562373BE_1088655599;
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.726 -0400", hash_original_field = "324F32D1CC16C414475D1414D2041A3B", hash_generated_field = "16A3D3E1F1A46232673D292E95776672")

    private static final int WORKING_STREAM_STORAGE = 16 * 1024;
}

