package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.InputStream;
import java.io.OutputStream;

public class Picture {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.621 -0400", hash_original_field = "205AF319C70DD39AC12A7A810F070D6A", hash_generated_field = "A1B5C5158D5DEB28A2820BEDFBA48246")

    private Canvas mRecordingCanvas;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.621 -0400", hash_original_field = "EB3D0953DBC0B65EBA1482F45D0B169C", hash_generated_field = "08C3B2ACCECB8572107176C70CDC69B3")

    private int mNativePicture;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.621 -0400", hash_original_method = "2489F1714C6AB52D2B9965C8B69500DD", hash_generated_method = "63528B2E8ADC16DD1C04E65808C24AEE")
    public  Picture() {
        this(nativeConstructor(0));
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.621 -0400", hash_original_method = "0B8FC63E2385743B0CD030A74D7237E0", hash_generated_method = "BEB05DE5939B8E76EE1EA7255E1E3D3A")
    public  Picture(Picture src) {
        this(nativeConstructor(src != null ? src.mNativePicture : 0));
        addTaint(src.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.622 -0400", hash_original_method = "4720BFD5C543F65C552F0739FF1DD2E7", hash_generated_method = "4BD9ADE5DBB84D427AC38DA6258FE8BA")
    private  Picture(int nativePicture) {
        if(nativePicture == 0)        
        {
            RuntimeException varF1484B21EF4EE84F790184975238945B_1590419679 = new RuntimeException();
            varF1484B21EF4EE84F790184975238945B_1590419679.addTaint(taint);
            throw varF1484B21EF4EE84F790184975238945B_1590419679;
        } //End block
        mNativePicture = nativePicture;
        // ---------- Original Method ----------
        //if (nativePicture == 0) {
            //throw new RuntimeException();
        //}
        //mNativePicture = nativePicture;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.622 -0400", hash_original_method = "20E22D7D195E3391E43BD9FB13A423DE", hash_generated_method = "D96E1D359F368B1235321CD40D61F22D")
    public Canvas beginRecording(int width, int height) {
        addTaint(height);
        addTaint(width);
        int ni = nativeBeginRecording(mNativePicture, width, height);
        mRecordingCanvas = new RecordingCanvas(this, ni);
Canvas var1D97605435A680D4B9EC641401BFF9EE_814837629 =         mRecordingCanvas;
        var1D97605435A680D4B9EC641401BFF9EE_814837629.addTaint(taint);
        return var1D97605435A680D4B9EC641401BFF9EE_814837629;
        // ---------- Original Method ----------
        //int ni = nativeBeginRecording(mNativePicture, width, height);
        //mRecordingCanvas = new RecordingCanvas(this, ni);
        //return mRecordingCanvas;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.622 -0400", hash_original_method = "4B70DEBF1EF0DC56C3D034BE86F32949", hash_generated_method = "6C8796540064B50705D12C6EBCDC58FA")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.622 -0400", hash_original_method = "D4E7715F32876041521BE16EC8E1C0AC", hash_generated_method = "CA83D1B52A21C097479BDB0BE6D91AD3")
    public int getWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1729249329 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1729249329;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.622 -0400", hash_original_method = "E09BF3A531DEFF54888EDA3B98EB9CFF", hash_generated_method = "166B375F6DA15EA16A62975EFE819F61")
    public int getHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1409692981 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1409692981;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.623 -0400", hash_original_method = "DC7CFB067EE80684132B2B92372F3B79", hash_generated_method = "B467DEB9F2198F0D4B06EBCE6806E8AC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.623 -0400", hash_original_method = "5D2FA2739AFC080B35312B93ED4EB821", hash_generated_method = "9CAAB0580330F805109382F6DD398285")
    public void writeToStream(OutputStream stream) {
        addTaint(stream.getTaint());
        if(stream == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_2135889039 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_2135889039.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_2135889039;
        } //End block
        if(!nativeWriteToStream(mNativePicture, stream,
                             new byte[WORKING_STREAM_STORAGE]))        
        {
            RuntimeException varF1484B21EF4EE84F790184975238945B_824203319 = new RuntimeException();
            varF1484B21EF4EE84F790184975238945B_824203319.addTaint(taint);
            throw varF1484B21EF4EE84F790184975238945B_824203319;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.623 -0400", hash_original_method = "A9ACB715DF1E16C6B20EA656F0034A3C", hash_generated_method = "65406D5C08A00AE047C5B3642566D2E9")
    protected void finalize() throws Throwable {
        nativeDestructor(mNativePicture);
        // ---------- Original Method ----------
        //nativeDestructor(mNativePicture);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.623 -0400", hash_original_method = "C2445D1D52466847173519B3E77D61F5", hash_generated_method = "FAF12BDD52883B15305D8BE218C42AA1")
    final int ni() {
        int varEB3D0953DBC0B65EBA1482F45D0B169C_847908178 = (mNativePicture);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1061686342 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1061686342;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.624 -0400", hash_original_field = "E97A703985A58F8707A878E051453537", hash_generated_field = "C3E778DE5EE29E2C4788703FE56860BD")

        private Picture mPicture;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.624 -0400", hash_original_method = "2A456EE78DB6B79255D736BC2BE0949A", hash_generated_method = "9A52DF88588713E0DD3B90E3BE8D18C0")
        public  RecordingCanvas(Picture pict, int nativeCanvas) {
            super(nativeCanvas);
            addTaint(nativeCanvas);
            mPicture = pict;
            // ---------- Original Method ----------
            //mPicture = pict;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.624 -0400", hash_original_method = "6CF0BDC754DD98C47DAA94E49A23367D", hash_generated_method = "6DEB54B77C4F682E2A3D44A8BF9F0E33")
        @Override
        public void setBitmap(Bitmap bitmap) {
            addTaint(bitmap.getTaint());
            RuntimeException var3EE550AF39B02FF8E426CCE34EA9A042_200390446 = new RuntimeException(
                                "Cannot call setBitmap on a picture canvas");
            var3EE550AF39B02FF8E426CCE34EA9A042_200390446.addTaint(taint);
            throw var3EE550AF39B02FF8E426CCE34EA9A042_200390446;
            // ---------- Original Method ----------
            //throw new RuntimeException(
                                //"Cannot call setBitmap on a picture canvas");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.625 -0400", hash_original_method = "37BF59928A286475E8AAF8FA82084BAA", hash_generated_method = "B338FF8FBF145BE3673877A69F54C9B4")
        @Override
        public void drawPicture(Picture picture) {
            addTaint(picture.getTaint());
            if(mPicture == picture)            
            {
                RuntimeException varF06980F6141921D11E9F48E5562373BE_248256912 = new RuntimeException(
                            "Cannot draw a picture into its recording canvas");
                varF06980F6141921D11E9F48E5562373BE_248256912.addTaint(taint);
                throw varF06980F6141921D11E9F48E5562373BE_248256912;
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.625 -0400", hash_original_field = "324F32D1CC16C414475D1414D2041A3B", hash_generated_field = "16A3D3E1F1A46232673D292E95776672")

    private static final int WORKING_STREAM_STORAGE = 16 * 1024;
}

