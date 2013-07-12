package android.media;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.util.Log;
import java.lang.IllegalArgumentException;

public class FaceDetector {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.831 -0400", hash_original_field = "651CEF29F37C9F53091FD6A9046D9F00", hash_generated_field = "B2E1347C5E93135AD628FBFEBF992869")

    private int mFD;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.832 -0400", hash_original_field = "AAF8199DF88BE47874825086CB4C893C", hash_generated_field = "829CFDAFE2E688EBA8166FB3418BF48F")

    private int mSDK;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.832 -0400", hash_original_field = "E3A66662CA1B990F4BAE900261C35546", hash_generated_field = "A4FC2249D14DBC5390BB543871CCB5FD")

    private int mDCR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.832 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

    private int mWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.832 -0400", hash_original_field = "483542B05A951AA16D89C7F809C20811", hash_generated_field = "9A13F430E09A05B31C551CE62B9A37C1")

    private int mHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.832 -0400", hash_original_field = "A7B9FDD16455F41531DAEF7D55A6190F", hash_generated_field = "964A2E5BBD4BE12624065D6AB48016F6")

    private int mMaxFaces;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.833 -0400", hash_original_field = "C9913858B5DF834FF526BA107FA748AF", hash_generated_field = "9F8C8AD37010BC34F1F731250F49E732")

    private byte mBWBuffer[];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.834 -0400", hash_original_method = "69484680A1706F6AEC1DEA5335B0CC8C", hash_generated_method = "098F0AF48257D62271EA978CAE6ED8CB")
    public  FaceDetector(int width, int height, int maxFaces) {
    if(!sInitialized)        
        {
            return;
        } //End block
        fft_initialize(width, height, maxFaces);
        mWidth = width;
        mHeight = height;
        mMaxFaces = maxFaces;
        mBWBuffer = new byte[width * height];
        // ---------- Original Method ----------
        //if (!sInitialized) {
            //return;
        //}
        //fft_initialize(width, height, maxFaces);
        //mWidth = width;
        //mHeight = height;
        //mMaxFaces = maxFaces;
        //mBWBuffer = new byte[width * height];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.835 -0400", hash_original_method = "3B299240BA81D20DD0BB998342A5B688", hash_generated_method = "F518A3800CEC213BBA32786BECCD7BEB")
    public int findFaces(Bitmap bitmap, Face[] faces) {
        addTaint(faces[0].getTaint());
        addTaint(bitmap.getTaint());
    if(!sInitialized)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_564890617 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_31863398 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_31863398;
        } //End block
    if(bitmap.getWidth() != mWidth || bitmap.getHeight() != mHeight)        
        {
            IllegalArgumentException var154C644C9C69E602A2014751BF7C49BC_1099416852 = new IllegalArgumentException(
                    "bitmap size doesn't match initialization");
            var154C644C9C69E602A2014751BF7C49BC_1099416852.addTaint(taint);
            throw var154C644C9C69E602A2014751BF7C49BC_1099416852;
        } //End block
    if(faces.length < mMaxFaces)        
        {
            IllegalArgumentException var2510662408A702670DD9B0096485E415_251587750 = new IllegalArgumentException(
                    "faces[] smaller than maxFaces");
            var2510662408A702670DD9B0096485E415_251587750.addTaint(taint);
            throw var2510662408A702670DD9B0096485E415_251587750;
        } //End block
        int numFaces = fft_detect(bitmap);
    if(numFaces >= mMaxFaces)        
        numFaces = mMaxFaces;
for(int i=0;i<numFaces;i++)
        {
    if(faces[i] == null)            
            faces[i] = new Face();
            fft_get_face(faces[i], i);
        } //End block
        int var176C6CB8FAA1E6C3704F46504E8512AE_1252513350 = (numFaces);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1009271448 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1009271448;
        // ---------- Original Method ----------
        //if (!sInitialized) {
            //return 0;
        //}
        //if (bitmap.getWidth() != mWidth || bitmap.getHeight() != mHeight) {
            //throw new IllegalArgumentException(
                    //"bitmap size doesn't match initialization");
        //}
        //if (faces.length < mMaxFaces) {
            //throw new IllegalArgumentException(
                    //"faces[] smaller than maxFaces");
        //}
        //int numFaces = fft_detect(bitmap);
        //if (numFaces >= mMaxFaces)
            //numFaces = mMaxFaces;
        //for (int i=0 ; i<numFaces ; i++) {
            //if (faces[i] == null)
                //faces[i] = new Face();
            //fft_get_face(faces[i], i);
        //}
        //return numFaces;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.836 -0400", hash_original_method = "CCE05B54F33EBA167A725030DCD8853F", hash_generated_method = "2CC4F6796BD9E47ED451AF65EA5C2C86")
    @Override
    protected void finalize() throws Throwable {
        fft_destroy();
        // ---------- Original Method ----------
        //fft_destroy();
    }

    
    private static void nativeClassInit() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.837 -0400", hash_original_method = "D8B51518847CA27E06A5D5CCCEFE0583", hash_generated_method = "0271A03F8296EC9660DAAA0B1AC61E78")
    private int fft_initialize(int width, int height, int maxFaces) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1568846977 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1568846977;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.838 -0400", hash_original_method = "0EFAC765C015AB65F15820DF03280C70", hash_generated_method = "6B24CD91ED01C94175BB1A45D12BB141")
    private int fft_detect(Bitmap bitmap) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_393648706 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_393648706;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.838 -0400", hash_original_method = "CB86BCB7657566AD08727E53423C77D8", hash_generated_method = "8662A1DE4A4B8DE549C38F3796471A14")
    private void fft_get_face(Face face, int i) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.838 -0400", hash_original_method = "7408AB46012CCA5768269842BF780619", hash_generated_method = "676CA60B71ACB1DA9EFD2C5C1886ACF8")
    private void fft_destroy() {
    }

    
    public class Face {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.839 -0400", hash_original_field = "E794D0ADC53728A5ABD87B319A179821", hash_generated_field = "D38234D2085FE27CE370F54DE4A30D93")

        private float mConfidence;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.839 -0400", hash_original_field = "1D4AD9D27A80814AFA3F5CEF668D7DB6", hash_generated_field = "8B9539AA667588C6494F2C2019AF98D3")

        private float mMidPointX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.839 -0400", hash_original_field = "4189F75C0480E43AE53A4CA37875C5AB", hash_generated_field = "3B6073D166196B3AE4BFA3EE6CF1CACF")

        private float mMidPointY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.839 -0400", hash_original_field = "08BB0117896C2E0A1E26DAA06F2494D6", hash_generated_field = "62716D698E0517CAAC505FEFB0E34D1A")

        private float mEyesDist;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.839 -0400", hash_original_field = "F74678F93251BC38E045AC644D11C8FF", hash_generated_field = "3F871B17394A25034C627CF5082BE20F")

        private float mPoseEulerX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.839 -0400", hash_original_field = "5B944BD2C61F67D098861EA59373D10A", hash_generated_field = "D15A9525752F32902363477FF15D0C81")

        private float mPoseEulerY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.839 -0400", hash_original_field = "48D1A8A8FD47D7F0FD1B8A5FF449C77F", hash_generated_field = "9455EC2C3F2CFBAB421F713034F49D7C")

        private float mPoseEulerZ;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.839 -0400", hash_original_method = "AEF29885362690B7E7A5098C2C347237", hash_generated_method = "6CF5710E5D033018DA5255DB3AFFFC40")
        private  Face() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.840 -0400", hash_original_method = "C4C15952E1E232D46597A87ECAFE1945", hash_generated_method = "CF15D7FFBE017735100166E7621205D7")
        public float confidence() {
            float varE794D0ADC53728A5ABD87B319A179821_569476158 = (mConfidence);
                        float var546ADE640B6EDFBC8A086EF31347E768_2000880217 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_2000880217;
            // ---------- Original Method ----------
            //return mConfidence;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.840 -0400", hash_original_method = "9735D84F89F9E8F084506CF39AC5503E", hash_generated_method = "9BE8A601100F32AB9364D3D077EA6125")
        public void getMidPoint(PointF point) {
            addTaint(point.getTaint());
            point.set(mMidPointX, mMidPointY);
            // ---------- Original Method ----------
            //point.set(mMidPointX, mMidPointY);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.840 -0400", hash_original_method = "80E9D70CB6ACD6183E07186EDB4A95C5", hash_generated_method = "8896FE2AD6A17B77ED44068B0D507C02")
        public float eyesDistance() {
            float var08BB0117896C2E0A1E26DAA06F2494D6_202823962 = (mEyesDist);
                        float var546ADE640B6EDFBC8A086EF31347E768_2140076347 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_2140076347;
            // ---------- Original Method ----------
            //return mEyesDist;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.841 -0400", hash_original_method = "50883A0AF140E51AB6B8450738DEEEF4", hash_generated_method = "6AD8D84C8B53F7560F6941CB14D24A34")
        public float pose(int euler) {
            addTaint(euler);
    if(euler == EULER_X)            
            {
            float varF74678F93251BC38E045AC644D11C8FF_1995162361 = (mPoseEulerX);
                        float var546ADE640B6EDFBC8A086EF31347E768_2073133255 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_2073133255;
            }
            else
    if(euler == EULER_Y)            
            {
            float var5B944BD2C61F67D098861EA59373D10A_255655654 = (mPoseEulerY);
                        float var546ADE640B6EDFBC8A086EF31347E768_1123599787 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1123599787;
            }
            else
    if(euler == EULER_Z)            
            {
            float var48D1A8A8FD47D7F0FD1B8A5FF449C77F_1332350238 = (mPoseEulerZ);
                        float var546ADE640B6EDFBC8A086EF31347E768_879909705 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_879909705;
            }
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_654303088 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_654303088.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_654303088;
            // ---------- Original Method ----------
            //if (euler == EULER_X)
                //return mPoseEulerX;
            //else if (euler == EULER_Y)
                //return mPoseEulerY;
            //else if (euler == EULER_Z)
                //return mPoseEulerZ;
            //throw new IllegalArgumentException();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.841 -0400", hash_original_field = "E409A608FE5BEF7E8A52BBA6DBD3A10A", hash_generated_field = "3EF6D022C788BB790EBDB5B748D95D90")

        public static final float CONFIDENCE_THRESHOLD = 0.4f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.841 -0400", hash_original_field = "D29024375DE7720F1E97332A91D9488D", hash_generated_field = "4D458FDB069BE3F18BE0DAD57E80198F")

        public static final int EULER_X = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.841 -0400", hash_original_field = "D794C6FDAEB110F26DAE88ED0C7D7E59", hash_generated_field = "14E28AA4449FDA7D9F9611C3BCCF8B86")

        public static final int EULER_Y = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.841 -0400", hash_original_field = "C9F646BEA573F43D3AC23EA15317BABC", hash_generated_field = "DBB62461D27E0594F1AFF27A2BB124CE")

        public static final int EULER_Z = 2;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:23.841 -0400", hash_original_field = "663FF7399920A29F8C63F4FBCE07F521", hash_generated_field = "27A01AEA893820336EC60E3CEF29F8C6")

    private static boolean sInitialized;
    static {
        sInitialized = false;
        try {
            System.loadLibrary("FFTEm");
            nativeClassInit();
            sInitialized = true;
        } catch (UnsatisfiedLinkError e) {
            Log.d("FFTEm", "face detection library not found!");
        }
    }
    
}

