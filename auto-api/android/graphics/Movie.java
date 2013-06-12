package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.InputStream;
import java.io.FileInputStream;

public class Movie {
    private final int mNativeMovie;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.224 -0400", hash_original_method = "E5F06651A3B56F187AA9A006C8924984", hash_generated_method = "65795E112E43353A8D0ACB1E3D621B78")
    @DSModeled(DSC.SAFE)
    private Movie(int nativeMovie) {
        dsTaint.addTaint(nativeMovie);
        {
            throw new RuntimeException("native movie creation failed");
        } //End block
        // ---------- Original Method ----------
        //if (nativeMovie == 0) {
            //throw new RuntimeException("native movie creation failed");
        //}
        //mNativeMovie = nativeMovie;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.225 -0400", hash_original_method = "84910C7B35CA680EF9DD8AE9E26E21F9", hash_generated_method = "768F3541DC59F715B33374F8861B3ED0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int width() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.225 -0400", hash_original_method = "C25EEDFD8D4C31BF8873912BD17554C7", hash_generated_method = "4C69BEEB27C663212B753607CEF6BD76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int height() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.225 -0400", hash_original_method = "9A759A0D04375324D8F6D99375FF174F", hash_generated_method = "B5E14EAC8468AB1C1A41FC932088673B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isOpaque() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.225 -0400", hash_original_method = "6FBC32EA70076DE70D25629F42C7072B", hash_generated_method = "B94DF9F368000C94F9C02BB595DE9019")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int duration() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.225 -0400", hash_original_method = "8413562E7FCFCF0CDE16790D77663C90", hash_generated_method = "7A415011371D42706723EE8DE0EA8B39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setTime(int relativeMilliseconds) {
        dsTaint.addTaint(relativeMilliseconds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.225 -0400", hash_original_method = "AB91E3BC6684B90AB29C38A2A4978664", hash_generated_method = "FCF278E0DE8F6C7FE6323931FC5FEC05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void draw(Canvas canvas, float x, float y, Paint paint) {
        dsTaint.addTaint(canvas.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.225 -0400", hash_original_method = "27AF6C33DD27E3F7A12E5155D66D2F71", hash_generated_method = "2B48F130485E4C502B99F0A40133C25A")
    @DSModeled(DSC.SAFE)
    public void draw(Canvas canvas, float x, float y) {
        dsTaint.addTaint(canvas.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        draw(canvas, x, y, null);
        // ---------- Original Method ----------
        //draw(canvas, x, y, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.225 -0400", hash_original_method = "9F4D6D7AE88092AD8FB39A0D19320567", hash_generated_method = "A6D9156EFA3804A54FE57BD9ACB615AA")
    public static Movie decodeStream(InputStream is) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.225 -0400", hash_original_method = "4C1CB5E71AE8BA79EF650F5944AA6286", hash_generated_method = "C5FF05D89B051607F5C3B69F3F85F41F")
    public static Movie decodeByteArray(byte[] data, int offset,
                                               int length) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.225 -0400", hash_original_method = "11F624E033F674569C619499368D5094", hash_generated_method = "3088B39F31F2B69539C1F7646A543170")
    private static void nativeDestructor(int nativeMovie) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.225 -0400", hash_original_method = "7CEF8D05BF0B6EBDABA0245FC8F1DEC0", hash_generated_method = "C53B8DB7DF660164057BC04C9A33EBBD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.226 -0400", hash_original_method = "2A8A5725920B2887C390528D14702FB9", hash_generated_method = "F1B4D9A898DF262B7755C533B5A2B653")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.226 -0400", hash_original_method = "1F682A68BAFB057136222BC2E907245D", hash_generated_method = "5F2F3246A5F7CF1FF781CB29304A3197")
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


