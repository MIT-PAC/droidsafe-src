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
    private int mNativeMovie;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.348 -0400", hash_original_method = "E5F06651A3B56F187AA9A006C8924984", hash_generated_method = "D311BFF91539F33A89E447D48E9DDB0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Movie(int nativeMovie) {
        dsTaint.addTaint(nativeMovie);
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("native movie creation failed");
        } //End block
        // ---------- Original Method ----------
        //if (nativeMovie == 0) {
            //throw new RuntimeException("native movie creation failed");
        //}
        //mNativeMovie = nativeMovie;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.349 -0400", hash_original_method = "84910C7B35CA680EF9DD8AE9E26E21F9", hash_generated_method = "C11E4CD3ADBB0894E9960D2F29E9B9CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int width() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.349 -0400", hash_original_method = "C25EEDFD8D4C31BF8873912BD17554C7", hash_generated_method = "0F4898D25A37D31BDAC89B0BE8190055")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int height() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.349 -0400", hash_original_method = "9A759A0D04375324D8F6D99375FF174F", hash_generated_method = "85D01AAC2BE5DE26630731B8B3847BEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isOpaque() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.349 -0400", hash_original_method = "6FBC32EA70076DE70D25629F42C7072B", hash_generated_method = "17ED92EC86503B7603D3B45953D25045")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int duration() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.350 -0400", hash_original_method = "8413562E7FCFCF0CDE16790D77663C90", hash_generated_method = "730B9EC590D899DCACAB6CCEB32DEB0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setTime(int relativeMilliseconds) {
        dsTaint.addTaint(relativeMilliseconds);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.350 -0400", hash_original_method = "AB91E3BC6684B90AB29C38A2A4978664", hash_generated_method = "454D36BBDF138AF3951DB9A86B1061E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void draw(Canvas canvas, float x, float y, Paint paint) {
        dsTaint.addTaint(canvas.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.350 -0400", hash_original_method = "27AF6C33DD27E3F7A12E5155D66D2F71", hash_generated_method = "6973BD64F84466B8A16F14BE9ACC383B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void draw(Canvas canvas, float x, float y) {
        dsTaint.addTaint(canvas.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        draw(canvas, x, y, null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.351 -0400", hash_original_method = "2A8A5725920B2887C390528D14702FB9", hash_generated_method = "F60431C87802AFB4C31B956CE5749F71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

