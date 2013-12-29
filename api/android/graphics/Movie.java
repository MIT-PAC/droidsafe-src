package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileInputStream;
import java.io.InputStream;






public class Movie {

    
    @DSModeled(DSC.SAFE)
    public static Movie decodeStream(InputStream is) {
    	return new Movie(0);
    }

    
    @DSModeled(DSC.SAFE)
    public static Movie decodeByteArray(byte[] data, int offset,
                                               int length) {
    	return new Movie(0);
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeDestructor(int nativeMovie) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:55.632 -0500", hash_original_method = "7CEF8D05BF0B6EBDABA0245FC8F1DEC0", hash_generated_method = "C53B8DB7DF660164057BC04C9A33EBBD")
    public static Movie decodeFile(String pathName) {
        InputStream is;
        try {
            is = new FileInputStream(pathName);
        }
        catch (java.io.FileNotFoundException e) {
            return null;
        }
        return decodeTempStream(is);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:55.634 -0500", hash_original_method = "1F682A68BAFB057136222BC2E907245D", hash_generated_method = "A5CF4790286AA86E209347F618A845EF")
    private static Movie decodeTempStream(InputStream is) {
        Movie moov = null;
        try {
            moov = decodeStream(is);
            is.close();
        }
        catch (java.io.IOException e) {
            /*  do nothing.
                If the exception happened on open, moov will be null.
                If it happened on close, moov is still valid.
            */
        }
        return moov;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:55.617 -0500", hash_original_field = "994605F46AA0CDC32D1C8DEF79EB8CDA", hash_generated_field = "4EB7E0A78D30CBDA5FB767C928D33814")

    private  int mNativeMovie;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:55.618 -0500", hash_original_method = "E5F06651A3B56F187AA9A006C8924984", hash_generated_method = "B00080BA60B2757F1152A104C95CC83F")
    private Movie(int nativeMovie) {
        if (nativeMovie == 0) {
            throw new RuntimeException("native movie creation failed");
        }
        mNativeMovie = nativeMovie;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:38.377 -0500", hash_original_method = "84910C7B35CA680EF9DD8AE9E26E21F9", hash_generated_method = "BE8F89305253FB034BFE471E3295C504")
    public native int width();
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:38.378 -0500", hash_original_method = "C25EEDFD8D4C31BF8873912BD17554C7", hash_generated_method = "5680467DD943EF2D871C87189F3170BD")
    public native int height();
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:38.379 -0500", hash_original_method = "9A759A0D04375324D8F6D99375FF174F", hash_generated_method = "0FF4C408441CDF51A299C96865D3C743")
    public native boolean isOpaque();
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:38.381 -0500", hash_original_method = "6FBC32EA70076DE70D25629F42C7072B", hash_generated_method = "887AEC1383BFF57FB67885299385FC5E")
    public native int duration();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:38.382 -0500", hash_original_method = "8413562E7FCFCF0CDE16790D77663C90", hash_generated_method = "163A2BE4D6CF08368E7D4C04CD05CF70")
    public native boolean setTime(int relativeMilliseconds);    

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:38.384 -0500", hash_original_method = "AB91E3BC6684B90AB29C38A2A4978664", hash_generated_method = "A9F06C005557C3E4313781A09EFCCECB")
    public native void draw(Canvas canvas, float x, float y, Paint paint);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:55.626 -0500", hash_original_method = "27AF6C33DD27E3F7A12E5155D66D2F71", hash_generated_method = "73ACCB1208EF0E906A08BDC98601C593")
    public void draw(Canvas canvas, float x, float y) {
        draw(canvas, x, y, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:55.633 -0500", hash_original_method = "2A8A5725920B2887C390528D14702FB9", hash_generated_method = "0E61351CEF779F0F53AE63AE85A657B8")
    @Override
protected void finalize() throws Throwable {
        try {
            nativeDestructor(mNativeMovie);
        } finally {
            super.finalize();
        }
    }

    
}

