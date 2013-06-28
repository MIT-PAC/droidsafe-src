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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.023 -0400", hash_original_field = "205AF319C70DD39AC12A7A810F070D6A", hash_generated_field = "A1B5C5158D5DEB28A2820BEDFBA48246")

    private Canvas mRecordingCanvas;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.023 -0400", hash_original_field = "EB3D0953DBC0B65EBA1482F45D0B169C", hash_generated_field = "08C3B2ACCECB8572107176C70CDC69B3")

    private int mNativePicture;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.024 -0400", hash_original_method = "2489F1714C6AB52D2B9965C8B69500DD", hash_generated_method = "63528B2E8ADC16DD1C04E65808C24AEE")
    public  Picture() {
        this(nativeConstructor(0));
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.024 -0400", hash_original_method = "0B8FC63E2385743B0CD030A74D7237E0", hash_generated_method = "BEB05DE5939B8E76EE1EA7255E1E3D3A")
    public  Picture(Picture src) {
        this(nativeConstructor(src != null ? src.mNativePicture : 0));
        addTaint(src.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.024 -0400", hash_original_method = "4720BFD5C543F65C552F0739FF1DD2E7", hash_generated_method = "696BDC1CE19AB8BA9C4FC0E201030DC9")
    private  Picture(int nativePicture) {
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException();
        } //End block
        mNativePicture = nativePicture;
        // ---------- Original Method ----------
        //if (nativePicture == 0) {
            //throw new RuntimeException();
        //}
        //mNativePicture = nativePicture;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.025 -0400", hash_original_method = "20E22D7D195E3391E43BD9FB13A423DE", hash_generated_method = "A7FC77A0A567E47C49E8EA79661315EF")
    public Canvas beginRecording(int width, int height) {
        Canvas varB4EAC82CA7396A68D541C85D26508E83_1008372333 = null; //Variable for return #1
        int ni = nativeBeginRecording(mNativePicture, width, height);
        mRecordingCanvas = new RecordingCanvas(this, ni);
        varB4EAC82CA7396A68D541C85D26508E83_1008372333 = mRecordingCanvas;
        addTaint(width);
        addTaint(height);
        varB4EAC82CA7396A68D541C85D26508E83_1008372333.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1008372333;
        // ---------- Original Method ----------
        //int ni = nativeBeginRecording(mNativePicture, width, height);
        //mRecordingCanvas = new RecordingCanvas(this, ni);
        //return mRecordingCanvas;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.026 -0400", hash_original_method = "4B70DEBF1EF0DC56C3D034BE86F32949", hash_generated_method = "2A735E704B28EC1A42C597E28B57117E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.026 -0400", hash_original_method = "D4E7715F32876041521BE16EC8E1C0AC", hash_generated_method = "3219A56FFE3CE9A86C23747FABFFFD46")
    public int getWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_19961746 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_19961746;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.027 -0400", hash_original_method = "E09BF3A531DEFF54888EDA3B98EB9CFF", hash_generated_method = "E707A5A984B2F406617CD9714B5A7DA7")
    public int getHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_146062055 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_146062055;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.028 -0400", hash_original_method = "DC7CFB067EE80684132B2B92372F3B79", hash_generated_method = "1D1A6DC2019C480DB087EE9558CED8B0")
    public void draw(Canvas canvas) {
        {
            endRecording();
        } //End block
        nativeDraw(canvas.mNativeCanvas, mNativePicture);
        addTaint(canvas.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.030 -0400", hash_original_method = "5D2FA2739AFC080B35312B93ED4EB821", hash_generated_method = "625EEC589D26757E95AA4F9174996CD3")
    public void writeToStream(OutputStream stream) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean varAD32F998F4C478CC17387CBF60C9B455_297598278 = (!nativeWriteToStream(mNativePicture, stream,
                             new byte[WORKING_STREAM_STORAGE]));
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException();
            } //End block
        } //End collapsed parenthetic
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        //if (stream == null) {
            //throw new NullPointerException();
        //}
        //if (!nativeWriteToStream(mNativePicture, stream,
                             //new byte[WORKING_STREAM_STORAGE])) {
            //throw new RuntimeException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.030 -0400", hash_original_method = "A9ACB715DF1E16C6B20EA656F0034A3C", hash_generated_method = "65406D5C08A00AE047C5B3642566D2E9")
    protected void finalize() throws Throwable {
        nativeDestructor(mNativePicture);
        // ---------- Original Method ----------
        //nativeDestructor(mNativePicture);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.031 -0400", hash_original_method = "C2445D1D52466847173519B3E77D61F5", hash_generated_method = "66D5EA19077B3609A436E3E930031E59")
    final int ni() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1200424768 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1200424768;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.034 -0400", hash_original_field = "E97A703985A58F8707A878E051453537", hash_generated_field = "C3E778DE5EE29E2C4788703FE56860BD")

        private Picture mPicture;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.035 -0400", hash_original_method = "2A456EE78DB6B79255D736BC2BE0949A", hash_generated_method = "34FAA35CB0E8018DEF9044A9719C9EAC")
        public  RecordingCanvas(Picture pict, int nativeCanvas) {
            super(nativeCanvas);
            mPicture = pict;
            addTaint(nativeCanvas);
            // ---------- Original Method ----------
            //mPicture = pict;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.035 -0400", hash_original_method = "6CF0BDC754DD98C47DAA94E49A23367D", hash_generated_method = "652B8C3612779FC2C8AECF59CE79EE22")
        @Override
        public void setBitmap(Bitmap bitmap) {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                                "Cannot call setBitmap on a picture canvas");
            addTaint(bitmap.getTaint());
            // ---------- Original Method ----------
            //throw new RuntimeException(
                                //"Cannot call setBitmap on a picture canvas");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.036 -0400", hash_original_method = "37BF59928A286475E8AAF8FA82084BAA", hash_generated_method = "756662CA5F7651CB7487595690B5AE89")
        @Override
        public void drawPicture(Picture picture) {
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Cannot draw a picture into its recording canvas");
            } //End block
            super.drawPicture(picture);
            addTaint(picture.getTaint());
            // ---------- Original Method ----------
            //if (mPicture == picture) {
                //throw new RuntimeException(
                            //"Cannot draw a picture into its recording canvas");
            //}
            //super.drawPicture(picture);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.036 -0400", hash_original_field = "324F32D1CC16C414475D1414D2041A3B", hash_generated_field = "16A3D3E1F1A46232673D292E95776672")

    private static final int WORKING_STREAM_STORAGE = 16 * 1024;
}

