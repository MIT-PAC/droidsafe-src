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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.095 -0400", hash_original_field = "426D92660CB2EB39A9900EB87D96F581", hash_generated_field = "4EB7E0A78D30CBDA5FB767C928D33814")

    private int mNativeMovie;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.102 -0400", hash_original_method = "E5F06651A3B56F187AA9A006C8924984", hash_generated_method = "C530F775337E30C6233DC78A6DF29AD2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.103 -0400", hash_original_method = "84910C7B35CA680EF9DD8AE9E26E21F9", hash_generated_method = "1D4B72A74E805FF9C66BC5984B540150")
    public int width() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_930274760 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_930274760;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.104 -0400", hash_original_method = "C25EEDFD8D4C31BF8873912BD17554C7", hash_generated_method = "C86D0DA3802C2C28102383A829445533")
    public int height() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_889159570 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_889159570;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.104 -0400", hash_original_method = "9A759A0D04375324D8F6D99375FF174F", hash_generated_method = "C7F42EA770A3F75628EA0F2B559E14AC")
    public boolean isOpaque() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_194800402 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_194800402;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.104 -0400", hash_original_method = "6FBC32EA70076DE70D25629F42C7072B", hash_generated_method = "4DFA66994443A867DBDC2F160C9C093C")
    public int duration() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_947540703 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_947540703;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.126 -0400", hash_original_method = "8413562E7FCFCF0CDE16790D77663C90", hash_generated_method = "6D4AFFE5489AC6846521D22BB9426BDD")
    public boolean setTime(int relativeMilliseconds) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_211076693 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_211076693;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.126 -0400", hash_original_method = "AB91E3BC6684B90AB29C38A2A4978664", hash_generated_method = "CD037BABBC64DBE1BAE402E06DA63CD9")
    public void draw(Canvas canvas, float x, float y, Paint paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.127 -0400", hash_original_method = "27AF6C33DD27E3F7A12E5155D66D2F71", hash_generated_method = "CDD48E03784E943B91431AB56B64A252")
    public void draw(Canvas canvas, float x, float y) {
        draw(canvas, x, y, null);
        addTaint(canvas.getTaint());
        addTaint(x);
        addTaint(y);
        // ---------- Original Method ----------
        //draw(canvas, x, y, null);
    }

    
        public static Movie decodeStream(InputStream is) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static Movie decodeByteArray(byte[] data, int offset,
                                               int length) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.128 -0400", hash_original_method = "2A8A5725920B2887C390528D14702FB9", hash_generated_method = "F60431C87802AFB4C31B956CE5749F71")
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

