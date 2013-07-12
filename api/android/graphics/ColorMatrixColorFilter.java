package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class ColorMatrixColorFilter extends ColorFilter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.215 -0400", hash_original_method = "92B387BCC5497E96DCF4BCCE85C5A491", hash_generated_method = "51F33EB5912D51F7349BD07120C17B07")
    public  ColorMatrixColorFilter(ColorMatrix matrix) {
        addTaint(matrix.getTaint());
        final float[] colorMatrix = matrix.getArray();
        native_instance = nativeColorMatrixFilter(colorMatrix);
        nativeColorFilter = nColorMatrixFilter(native_instance, colorMatrix);
        // ---------- Original Method ----------
        //final float[] colorMatrix = matrix.getArray();
        //native_instance = nativeColorMatrixFilter(colorMatrix);
        //nativeColorFilter = nColorMatrixFilter(native_instance, colorMatrix);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.215 -0400", hash_original_method = "2D0E3EA51658F535A9A5BDBE5AE078D8", hash_generated_method = "06945BA4000A9368E278CDFD95CF83E4")
    public  ColorMatrixColorFilter(float[] array) {
        addTaint(array[0]);
    if(array.length < 20)        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_1106077398 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_1106077398.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_1106077398;
        } //End block
        native_instance = nativeColorMatrixFilter(array);
        nativeColorFilter = nColorMatrixFilter(native_instance, array);
        // ---------- Original Method ----------
        //if (array.length < 20) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //native_instance = nativeColorMatrixFilter(array);
        //nativeColorFilter = nColorMatrixFilter(native_instance, array);
    }

    
    private static int nativeColorMatrixFilter(float[] array) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_207688702 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_207688702;
    }

    
    private static int nColorMatrixFilter(int nativeFilter, float[] array) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_221975373 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_221975373;
    }

    
}

