package android.media;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.util.Log;





public class FaceDetector {

    
    @DSModeled(DSC.SAFE)
    private static void nativeClassInit() {
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.571 -0500", hash_original_field = "D692DCD499E02653F7D40EBB5CF95A8C", hash_generated_field = "27A01AEA893820336EC60E3CEF29F8C6")

    private static boolean sInitialized;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.594 -0500", hash_original_field = "6BEC4841C057AD5F45E3C9B973908E26", hash_generated_field = "B2E1347C5E93135AD628FBFEBF992869")


    private int     mFD;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.596 -0500", hash_original_field = "F1ABD4902634CFF60AD5EFFC5DE1A2E9", hash_generated_field = "829CFDAFE2E688EBA8166FB3418BF48F")

    private int     mSDK;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.598 -0500", hash_original_field = "09A79F49698A3B63A5276CE6DF24D50C", hash_generated_field = "A4FC2249D14DBC5390BB543871CCB5FD")

    private int     mDCR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.601 -0500", hash_original_field = "AF6410B200BC05DCA2CF0BE65165448A", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

    private int     mWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.603 -0500", hash_original_field = "7DDAE255893B528E7BEBEC203BC2D9F3", hash_generated_field = "9A13F430E09A05B31C551CE62B9A37C1")

    private int     mHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.605 -0500", hash_original_field = "0DAAA6ECF80DDD73E2574DC1018B840E", hash_generated_field = "964A2E5BBD4BE12624065D6AB48016F6")

    private int     mMaxFaces;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.607 -0500", hash_original_field = "F8C0152588D4596E03F1148BD7CCEDBC", hash_generated_field = "9F8C8AD37010BC34F1F731250F49E732")
    
    private byte    mBWBuffer[];


    /**
     * Creates a FaceDetector, configured with the size of the images to
     * be analysed and the maximum number of faces that can be detected.
     * These parameters cannot be changed once the object is constructed.
     * Note that the width of the image must be even.
     * 
     * @param width  the width of the image
     * @param height the height of the image
     * @param maxFaces the maximum number of faces to identify
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.563 -0500", hash_original_method = "69484680A1706F6AEC1DEA5335B0CC8C", hash_generated_method = "2D6AFF60B7D25965A7A6D862C14145CD")
    
public FaceDetector(int width, int height, int maxFaces)
    {
        if (!sInitialized) {
            return;
        }
        fft_initialize(width, height, maxFaces);
        mWidth = width;
        mHeight = height;
        mMaxFaces = maxFaces;
        mBWBuffer = new byte[width * height];
    }

    /**
     * Finds all the faces found in a given {@link android.graphics.Bitmap}. 
     * The supplied array is populated with {@link FaceDetector.Face}s for each
     * face found. The bitmap must be in 565 format (for now).
     * 
     * @param bitmap the {@link android.graphics.Bitmap} graphic to be analyzed
     * @param faces  an array in which to place all found 
     *               {@link FaceDetector.Face}s. The array must be sized equal
     *               to the <var>maxFaces</var> value set at initialization
     * @return the number of faces found
     * @throws IllegalArgumentException if the Bitmap dimensions don't match
     *               the dimensions defined at initialization or the given array 
     *               is not sized equal to the <var>maxFaces</var> value defined
     *               at initialization
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.565 -0500", hash_original_method = "3B299240BA81D20DD0BB998342A5B688", hash_generated_method = "510FAF624686E6371A1EA933AC4B2B26")
    
public int findFaces(Bitmap bitmap, Face[] faces)
    {
        if (!sInitialized) {
            return 0;
        }
        if (bitmap.getWidth() != mWidth || bitmap.getHeight() != mHeight) {
            throw new IllegalArgumentException(
                    "bitmap size doesn't match initialization");
        }
        if (faces.length < mMaxFaces) {
            throw new IllegalArgumentException(
                    "faces[] smaller than maxFaces");
        }
        
        int numFaces = fft_detect(bitmap);
        if (numFaces >= mMaxFaces)
            numFaces = mMaxFaces;
        for (int i=0 ; i<numFaces ; i++) {
            if (faces[i] == null)
                faces[i] = new Face();
            fft_get_face(faces[i], i);
        }
        return numFaces;
    }


    /* no user serviceable parts here ... */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.568 -0500", hash_original_method = "CCE05B54F33EBA167A725030DCD8853F", hash_generated_method = "A9F122C14E7F1B20D9E36D96CD0C6263")
    
@Override
    protected void finalize() throws Throwable {
        fft_destroy();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.580 -0500", hash_original_method = "D8B51518847CA27E06A5D5CCCEFE0583", hash_generated_method = "864DAA609BDA840F6A768B16052A9265")
    
    private int  fft_initialize(int width, int height, int maxFaces){
    	//Formerly a native method
    	addTaint(width);
    	addTaint(height);
    	addTaint(maxFaces);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.584 -0500", hash_original_method = "0EFAC765C015AB65F15820DF03280C70", hash_generated_method = "BB427F2418D011F2F8EA9D3A5A4FD185")
    
    private int  fft_detect(Bitmap bitmap){
    	//Formerly a native method
    	addTaint(bitmap.getTaint());
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.588 -0500", hash_original_method = "CB86BCB7657566AD08727E53423C77D8", hash_generated_method = "56605F911A146C99C6E2F0DC871DCB2B")
    
    private void fft_get_face(Face face, int i){
    	//Formerly a native method
    	addTaint(face.getTaint());
    	addTaint(i);
    }


    
    public class Face {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.516 -0500", hash_original_field = "3FF5F046EB09E2977AAEB85477EDBAF9", hash_generated_field = "3EF6D022C788BB790EBDB5B748D95D90")

        public static final float CONFIDENCE_THRESHOLD = 0.4f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.519 -0500", hash_original_field = "94059C48B6B6D51DD882536D84D46631", hash_generated_field = "4D458FDB069BE3F18BE0DAD57E80198F")

        public static final int EULER_X = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.521 -0500", hash_original_field = "6DE1EB6C68A7A915BF08568E0A6BC382", hash_generated_field = "14E28AA4449FDA7D9F9611C3BCCF8B86")

        public static final int EULER_Y = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.524 -0500", hash_original_field = "965ADDCEF81D80C681993174BED48343", hash_generated_field = "DBB62461D27E0594F1AFF27A2BB124CE")

        public static final int EULER_Z = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.540 -0500", hash_original_field = "33C257B9074D1F8A5D307DFEF6A489FC", hash_generated_field = "D38234D2085FE27CE370F54DE4A30D93")

        private float   mConfidence;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.543 -0500", hash_original_field = "72BC06AAC4E354105E988AD0D9E6DA2A", hash_generated_field = "8B9539AA667588C6494F2C2019AF98D3")

        private float   mMidPointX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.545 -0500", hash_original_field = "893CEBA8C5C9D71197A93D923DD8B17D", hash_generated_field = "3B6073D166196B3AE4BFA3EE6CF1CACF")

        private float   mMidPointY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.548 -0500", hash_original_field = "9272F8AB093DCBB531EF843A65647503", hash_generated_field = "62716D698E0517CAAC505FEFB0E34D1A")

        private float   mEyesDist;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.552 -0500", hash_original_field = "E84C7DF9DFBB6C6A94E806D5DC758462", hash_generated_field = "3F871B17394A25034C627CF5082BE20F")

        private float   mPoseEulerX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.555 -0500", hash_original_field = "47FD5F772CF8853320060E019DA93C06", hash_generated_field = "D15A9525752F32902363477FF15D0C81")

        private float   mPoseEulerY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.558 -0500", hash_original_field = "08634D83EB4163305E303B35705ECAA7", hash_generated_field = "9455EC2C3F2CFBAB421F713034F49D7C")

        private float   mPoseEulerZ;

        // private ctor, user not supposed to build this object
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.538 -0500", hash_original_method = "AEF29885362690B7E7A5098C2C347237", hash_generated_method = "69276EF4CC43C923C40D8920629F466A")
        
private Face() {
        }

        /** 
         * Returns a confidence factor between 0 and 1. This indicates how
         * certain what has been found is actually a face. A confidence
         * factor above 0.3 is usually good enough.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.527 -0500", hash_original_method = "C4C15952E1E232D46597A87ECAFE1945", hash_generated_method = "E356C934ED20FD22E083A4A134DC00E7")
        
public float confidence() {
            return mConfidence;
        }
        /**
         * Sets the position of the mid-point between the eyes.
         * @param point the PointF coordinates (float values) of the 
         *              face's mid-point
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.530 -0500", hash_original_method = "9735D84F89F9E8F084506CF39AC5503E", hash_generated_method = "F2F1230E6AE5A819E30388714347D749")
        
public void getMidPoint(PointF point) {
            // don't return a PointF to avoid allocations
            point.set(mMidPointX, mMidPointY);
        }
        /**
         * Returns the distance between the eyes.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.532 -0500", hash_original_method = "80E9D70CB6ACD6183E07186EDB4A95C5", hash_generated_method = "DB1C701A897DDE4A240532A306C76034")
        
public float eyesDistance() {
            return mEyesDist;
        }
        /**
         * Returns the face's pose. That is, the rotations around either 
         * the X, Y or Z axis (the positions in 3-dimensional Euclidean space).
         * 
         * @param euler the Euler axis to retrieve an angle from 
         *              (<var>EULER_X</var>, <var>EULER_Y</var> or 
         *              <var>EULER_Z</var>)
         * @return the Euler angle of the of the face, for the given axis
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.535 -0500", hash_original_method = "50883A0AF140E51AB6B8450738DEEEF4", hash_generated_method = "D9C635FA044851C8A967FE6476670D17")
        
public float pose(int euler) {
            // don't use an array to avoid allocations
            if (euler == EULER_X)
                return mPoseEulerX;
            else if (euler == EULER_Y)
                return mPoseEulerY;
            else if (euler == EULER_Z)
                return mPoseEulerZ;
           throw new IllegalArgumentException();
        }
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:35.591 -0500", hash_original_method = "7408AB46012CCA5768269842BF780619", hash_generated_method = "6F6FAC4DFE0C882EC7B63D2DB30C6D37")
    
    private void fft_destroy(){
    	//Formerly a native method
    }

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

