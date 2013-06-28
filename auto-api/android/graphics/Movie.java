package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.InputStream;
import java.io.FileInputStream;

public class Movie {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.676 -0400", hash_original_field = "426D92660CB2EB39A9900EB87D96F581", hash_generated_field = "4EB7E0A78D30CBDA5FB767C928D33814")

    private int mNativeMovie;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.677 -0400", hash_original_method = "E5F06651A3B56F187AA9A006C8924984", hash_generated_method = "C530F775337E30C6233DC78A6DF29AD2")
    private  Movie(int nativeMovie) {
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("native movie creation failed");
        } //End block
        mNativeMovie = nativeMovie;
        // ---------- Original Method ----------
        //if (nativeMovie == 0) {
            //throw new RuntimeException("native movie creation failed");
        //}
        //mNativeMovie = nativeMovie;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.677 -0400", hash_original_method = "84910C7B35CA680EF9DD8AE9E26E21F9", hash_generated_method = "F9B4078B5EA929F0FA4BAFDD3B6615E3")
    public int width() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1768049638 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1768049638;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.678 -0400", hash_original_method = "C25EEDFD8D4C31BF8873912BD17554C7", hash_generated_method = "ADD5475DF6A927B12AE30DE612E1C8FF")
    public int height() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_249032603 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_249032603;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.678 -0400", hash_original_method = "9A759A0D04375324D8F6D99375FF174F", hash_generated_method = "DE23A811B2F5885F87A08BEB2CFF5496")
    public boolean isOpaque() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_867014520 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_867014520;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.679 -0400", hash_original_method = "6FBC32EA70076DE70D25629F42C7072B", hash_generated_method = "DEA7E19112A729BDCB840204767D2E0F")
    public int duration() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1047084327 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1047084327;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.679 -0400", hash_original_method = "8413562E7FCFCF0CDE16790D77663C90", hash_generated_method = "9FB2AB8913607C54F566C04CB713FEC3")
    public boolean setTime(int relativeMilliseconds) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1831524425 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1831524425;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.679 -0400", hash_original_method = "AB91E3BC6684B90AB29C38A2A4978664", hash_generated_method = "CD037BABBC64DBE1BAE402E06DA63CD9")
    public void draw(Canvas canvas, float x, float y, Paint paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.680 -0400", hash_original_method = "27AF6C33DD27E3F7A12E5155D66D2F71", hash_generated_method = "CDD48E03784E943B91431AB56B64A252")
    public void draw(Canvas canvas, float x, float y) {
        draw(canvas, x, y, null);
        addTaint(canvas.getTaint());
        addTaint(x);
        addTaint(y);
        // ---------- Original Method ----------
        //draw(canvas, x, y, null);
    }

    
    public static Movie decodeStream(InputStream is) {
                //DSFIXME:  This shouldn't happen!
    }

    
    public static Movie decodeByteArray(byte[] data, int offset,
                                               int length) {
                //DSFIXME:  This shouldn't happen!
    }

    
    private static void nativeDestructor(int nativeMovie) {
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.681 -0400", hash_original_method = "2A8A5725920B2887C390528D14702FB9", hash_generated_method = "F60431C87802AFB4C31B956CE5749F71")
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

