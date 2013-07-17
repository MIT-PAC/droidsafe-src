package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.InputStream;
import java.io.FileInputStream;

public class Movie {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.349 -0400", hash_original_field = "426D92660CB2EB39A9900EB87D96F581", hash_generated_field = "4EB7E0A78D30CBDA5FB767C928D33814")

    private int mNativeMovie;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.349 -0400", hash_original_method = "E5F06651A3B56F187AA9A006C8924984", hash_generated_method = "8DBC94C0164D2B66CA478A8DA138739D")
    private  Movie(int nativeMovie) {
        if(nativeMovie == 0)        
        {
            RuntimeException varA71E78EA572F34619BEAC790E37CCF63_1073792357 = new RuntimeException("native movie creation failed");
            varA71E78EA572F34619BEAC790E37CCF63_1073792357.addTaint(taint);
            throw varA71E78EA572F34619BEAC790E37CCF63_1073792357;
        } //End block
        mNativeMovie = nativeMovie;
        // ---------- Original Method ----------
        //if (nativeMovie == 0) {
            //throw new RuntimeException("native movie creation failed");
        //}
        //mNativeMovie = nativeMovie;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.349 -0400", hash_original_method = "84910C7B35CA680EF9DD8AE9E26E21F9", hash_generated_method = "CF7A9BBE20EB52297E79886E6E7D1F4B")
    public int width() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_480365835 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_480365835;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.349 -0400", hash_original_method = "C25EEDFD8D4C31BF8873912BD17554C7", hash_generated_method = "96872011430C80B68E5B56C8DDC46183")
    public int height() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1210368793 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1210368793;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.349 -0400", hash_original_method = "9A759A0D04375324D8F6D99375FF174F", hash_generated_method = "6A13BCE00F4A1F1A0A0179987ADFBEDE")
    public boolean isOpaque() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_727589722 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_727589722;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.349 -0400", hash_original_method = "6FBC32EA70076DE70D25629F42C7072B", hash_generated_method = "7C41EB019E2A8C44AE6FE979060AD896")
    public int duration() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1762108475 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1762108475;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.351 -0400", hash_original_method = "8413562E7FCFCF0CDE16790D77663C90", hash_generated_method = "768715CE06E13CB3DB1EA4691B587BA7")
    public boolean setTime(int relativeMilliseconds) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1059444139 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1059444139;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.352 -0400", hash_original_method = "AB91E3BC6684B90AB29C38A2A4978664", hash_generated_method = "CD037BABBC64DBE1BAE402E06DA63CD9")
    public void draw(Canvas canvas, float x, float y, Paint paint) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.352 -0400", hash_original_method = "27AF6C33DD27E3F7A12E5155D66D2F71", hash_generated_method = "0FAA91739190A76F528FF512134FE8FF")
    public void draw(Canvas canvas, float x, float y) {
        addTaint(y);
        addTaint(x);
        addTaint(canvas.getTaint());
        draw(canvas, x, y, null);
        // ---------- Original Method ----------
        //draw(canvas, x, y, null);
    }

    
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

    
    @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.352 -0400", hash_original_method = "2A8A5725920B2887C390528D14702FB9", hash_generated_method = "F60431C87802AFB4C31B956CE5749F71")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            nativeDestructor(mNativeMovie);
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //nativeDestructor(mNativeMovie);
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    private static Movie decodeTempStream(InputStream is) {
        Movie moov = null;
        try {
            moov = decodeStream(is);
            is.close();
        }
        catch (java.io.IOException e) {
        }
        return moov;
    }

    
}

