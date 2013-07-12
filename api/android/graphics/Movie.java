package android.graphics;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.InputStream;
import java.io.FileInputStream;

public class Movie {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.402 -0400", hash_original_field = "426D92660CB2EB39A9900EB87D96F581", hash_generated_field = "4EB7E0A78D30CBDA5FB767C928D33814")

    private int mNativeMovie;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.403 -0400", hash_original_method = "E5F06651A3B56F187AA9A006C8924984", hash_generated_method = "B84D80373E2AF429C2411B5993D179A0")
    private  Movie(int nativeMovie) {
    if(nativeMovie == 0)        
        {
            RuntimeException varA71E78EA572F34619BEAC790E37CCF63_178369293 = new RuntimeException("native movie creation failed");
            varA71E78EA572F34619BEAC790E37CCF63_178369293.addTaint(taint);
            throw varA71E78EA572F34619BEAC790E37CCF63_178369293;
        } 
        mNativeMovie = nativeMovie;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.403 -0400", hash_original_method = "84910C7B35CA680EF9DD8AE9E26E21F9", hash_generated_method = "5B97739B3A898B1654432E8FE8D960B2")
    public int width() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1032093973 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1032093973;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.403 -0400", hash_original_method = "C25EEDFD8D4C31BF8873912BD17554C7", hash_generated_method = "90E3901A4AD50EAAC1F631785AC8FC40")
    public int height() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_883967112 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_883967112;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.403 -0400", hash_original_method = "9A759A0D04375324D8F6D99375FF174F", hash_generated_method = "1D48ECF5C0C6A84FAA9030DC2207256E")
    public boolean isOpaque() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1940885478 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1940885478;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.403 -0400", hash_original_method = "6FBC32EA70076DE70D25629F42C7072B", hash_generated_method = "2D0974D91755FB4F50A2EA6B0312BB2B")
    public int duration() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_849856289 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_849856289;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.404 -0400", hash_original_method = "8413562E7FCFCF0CDE16790D77663C90", hash_generated_method = "997579E278E7BEE2DFDA23B2EF5703C3")
    public boolean setTime(int relativeMilliseconds) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_209856847 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_209856847;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.404 -0400", hash_original_method = "AB91E3BC6684B90AB29C38A2A4978664", hash_generated_method = "CD037BABBC64DBE1BAE402E06DA63CD9")
    public void draw(Canvas canvas, float x, float y, Paint paint) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.404 -0400", hash_original_method = "27AF6C33DD27E3F7A12E5155D66D2F71", hash_generated_method = "0FAA91739190A76F528FF512134FE8FF")
    public void draw(Canvas canvas, float x, float y) {
        addTaint(y);
        addTaint(x);
        addTaint(canvas.getTaint());
        draw(canvas, x, y, null);
        
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.405 -0400", hash_original_method = "2A8A5725920B2887C390528D14702FB9", hash_generated_method = "F60431C87802AFB4C31B956CE5749F71")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            nativeDestructor(mNativeMovie);
        } 
        finally 
        {
            super.finalize();
        } 
        
        
            
        
            
        
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

