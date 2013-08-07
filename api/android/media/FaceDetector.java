package android.media;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.util.Log;





public class FaceDetector {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.167 -0400", hash_original_field = "651CEF29F37C9F53091FD6A9046D9F00", hash_generated_field = "B2E1347C5E93135AD628FBFEBF992869")

    private int mFD;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.168 -0400", hash_original_field = "AAF8199DF88BE47874825086CB4C893C", hash_generated_field = "829CFDAFE2E688EBA8166FB3418BF48F")

    private int mSDK;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.168 -0400", hash_original_field = "E3A66662CA1B990F4BAE900261C35546", hash_generated_field = "A4FC2249D14DBC5390BB543871CCB5FD")

    private int mDCR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.168 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

    private int mWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.168 -0400", hash_original_field = "483542B05A951AA16D89C7F809C20811", hash_generated_field = "9A13F430E09A05B31C551CE62B9A37C1")

    private int mHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.168 -0400", hash_original_field = "A7B9FDD16455F41531DAEF7D55A6190F", hash_generated_field = "964A2E5BBD4BE12624065D6AB48016F6")

    private int mMaxFaces;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.168 -0400", hash_original_field = "C9913858B5DF834FF526BA107FA748AF", hash_generated_field = "9F8C8AD37010BC34F1F731250F49E732")

    private byte mBWBuffer[];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.183 -0400", hash_original_method = "69484680A1706F6AEC1DEA5335B0CC8C", hash_generated_method = "098F0AF48257D62271EA978CAE6ED8CB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.183 -0400", hash_original_method = "3B299240BA81D20DD0BB998342A5B688", hash_generated_method = "7EE950422BC87F62022BA6C7178E7459")
    public int findFaces(Bitmap bitmap, Face[] faces) {
        addTaint(faces[0].getTaint());
        addTaint(bitmap.getTaint());
        if(!sInitialized)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_879279395 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1997609607 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1997609607;
        } //End block
        if(bitmap.getWidth() != mWidth || bitmap.getHeight() != mHeight)        
        {
            IllegalArgumentException var154C644C9C69E602A2014751BF7C49BC_240406793 = new IllegalArgumentException(
                    "bitmap size doesn't match initialization");
            var154C644C9C69E602A2014751BF7C49BC_240406793.addTaint(taint);
            throw var154C644C9C69E602A2014751BF7C49BC_240406793;
        } //End block
        if(faces.length < mMaxFaces)        
        {
            IllegalArgumentException var2510662408A702670DD9B0096485E415_1175199006 = new IllegalArgumentException(
                    "faces[] smaller than maxFaces");
            var2510662408A702670DD9B0096485E415_1175199006.addTaint(taint);
            throw var2510662408A702670DD9B0096485E415_1175199006;
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
        int var176C6CB8FAA1E6C3704F46504E8512AE_1396791153 = (numFaces);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_912935859 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_912935859;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.183 -0400", hash_original_method = "CCE05B54F33EBA167A725030DCD8853F", hash_generated_method = "2CC4F6796BD9E47ED451AF65EA5C2C86")
    @Override
    protected void finalize() throws Throwable {
        fft_destroy();
        // ---------- Original Method ----------
        //fft_destroy();
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeClassInit() {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.184 -0400", hash_original_method = "D8B51518847CA27E06A5D5CCCEFE0583", hash_generated_method = "ACAEA0A0525309BBEF05717F784504BD")
    private int fft_initialize(int width, int height, int maxFaces) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_795961604 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_795961604;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.184 -0400", hash_original_method = "0EFAC765C015AB65F15820DF03280C70", hash_generated_method = "6F49625607379D1291ADAA2F75928A20")
    private int fft_detect(Bitmap bitmap) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2022776963 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2022776963;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.184 -0400", hash_original_method = "CB86BCB7657566AD08727E53423C77D8", hash_generated_method = "8662A1DE4A4B8DE549C38F3796471A14")
    private void fft_get_face(Face face, int i) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.184 -0400", hash_original_method = "7408AB46012CCA5768269842BF780619", hash_generated_method = "676CA60B71ACB1DA9EFD2C5C1886ACF8")
    private void fft_destroy() {
    }

    
    public class Face {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.184 -0400", hash_original_field = "E794D0ADC53728A5ABD87B319A179821", hash_generated_field = "D38234D2085FE27CE370F54DE4A30D93")

        private float mConfidence;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.184 -0400", hash_original_field = "1D4AD9D27A80814AFA3F5CEF668D7DB6", hash_generated_field = "8B9539AA667588C6494F2C2019AF98D3")

        private float mMidPointX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.184 -0400", hash_original_field = "4189F75C0480E43AE53A4CA37875C5AB", hash_generated_field = "3B6073D166196B3AE4BFA3EE6CF1CACF")

        private float mMidPointY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.184 -0400", hash_original_field = "08BB0117896C2E0A1E26DAA06F2494D6", hash_generated_field = "62716D698E0517CAAC505FEFB0E34D1A")

        private float mEyesDist;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.184 -0400", hash_original_field = "F74678F93251BC38E045AC644D11C8FF", hash_generated_field = "3F871B17394A25034C627CF5082BE20F")

        private float mPoseEulerX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.184 -0400", hash_original_field = "5B944BD2C61F67D098861EA59373D10A", hash_generated_field = "D15A9525752F32902363477FF15D0C81")

        private float mPoseEulerY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.184 -0400", hash_original_field = "48D1A8A8FD47D7F0FD1B8A5FF449C77F", hash_generated_field = "9455EC2C3F2CFBAB421F713034F49D7C")

        private float mPoseEulerZ;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.184 -0400", hash_original_method = "AEF29885362690B7E7A5098C2C347237", hash_generated_method = "6CF5710E5D033018DA5255DB3AFFFC40")
        private  Face() {
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.184 -0400", hash_original_method = "C4C15952E1E232D46597A87ECAFE1945", hash_generated_method = "0535E70B0013D1245993A009B492DA5C")
        public float confidence() {
            float varE794D0ADC53728A5ABD87B319A179821_570544836 = (mConfidence);
                        float var546ADE640B6EDFBC8A086EF31347E768_1335838765 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1335838765;
            // ---------- Original Method ----------
            //return mConfidence;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.185 -0400", hash_original_method = "9735D84F89F9E8F084506CF39AC5503E", hash_generated_method = "9BE8A601100F32AB9364D3D077EA6125")
        public void getMidPoint(PointF point) {
            addTaint(point.getTaint());
            point.set(mMidPointX, mMidPointY);
            // ---------- Original Method ----------
            //point.set(mMidPointX, mMidPointY);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.185 -0400", hash_original_method = "80E9D70CB6ACD6183E07186EDB4A95C5", hash_generated_method = "A6F87F0B7954F65DDC2098DAC842CF29")
        public float eyesDistance() {
            float var08BB0117896C2E0A1E26DAA06F2494D6_129412391 = (mEyesDist);
                        float var546ADE640B6EDFBC8A086EF31347E768_437113870 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_437113870;
            // ---------- Original Method ----------
            //return mEyesDist;
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.185 -0400", hash_original_method = "50883A0AF140E51AB6B8450738DEEEF4", hash_generated_method = "D6ADA1775CF6B9F54A21145C7419746C")
        public float pose(int euler) {
            addTaint(euler);
            if(euler == EULER_X)            
            {
            float varF74678F93251BC38E045AC644D11C8FF_216178211 = (mPoseEulerX);
                        float var546ADE640B6EDFBC8A086EF31347E768_520196262 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_520196262;
            }
            else
            if(euler == EULER_Y)            
            {
            float var5B944BD2C61F67D098861EA59373D10A_1756688682 = (mPoseEulerY);
                        float var546ADE640B6EDFBC8A086EF31347E768_396425537 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_396425537;
            }
            else
            if(euler == EULER_Z)            
            {
            float var48D1A8A8FD47D7F0FD1B8A5FF449C77F_1390736788 = (mPoseEulerZ);
                        float var546ADE640B6EDFBC8A086EF31347E768_1062840054 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1062840054;
            }
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1578314377 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1578314377.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1578314377;
            // ---------- Original Method ----------
            //if (euler == EULER_X)
                //return mPoseEulerX;
            //else if (euler == EULER_Y)
                //return mPoseEulerY;
            //else if (euler == EULER_Z)
                //return mPoseEulerZ;
            //throw new IllegalArgumentException();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.185 -0400", hash_original_field = "E409A608FE5BEF7E8A52BBA6DBD3A10A", hash_generated_field = "3EF6D022C788BB790EBDB5B748D95D90")

        public static final float CONFIDENCE_THRESHOLD = 0.4f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.185 -0400", hash_original_field = "D29024375DE7720F1E97332A91D9488D", hash_generated_field = "4D458FDB069BE3F18BE0DAD57E80198F")

        public static final int EULER_X = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.185 -0400", hash_original_field = "D794C6FDAEB110F26DAE88ED0C7D7E59", hash_generated_field = "14E28AA4449FDA7D9F9611C3BCCF8B86")

        public static final int EULER_Y = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.185 -0400", hash_original_field = "C9F646BEA573F43D3AC23EA15317BABC", hash_generated_field = "DBB62461D27E0594F1AFF27A2BB124CE")

        public static final int EULER_Z = 2;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.185 -0400", hash_original_field = "663FF7399920A29F8C63F4FBCE07F521", hash_generated_field = "27A01AEA893820336EC60E3CEF29F8C6")

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

