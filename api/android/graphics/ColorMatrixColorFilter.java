package android.graphics;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSUtils;

public class ColorMatrixColorFilter extends ColorFilter {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.156 -0400", hash_original_method = "92B387BCC5497E96DCF4BCCE85C5A491", hash_generated_method = "51F33EB5912D51F7349BD07120C17B07")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.157 -0400", hash_original_method = "2D0E3EA51658F535A9A5BDBE5AE078D8", hash_generated_method = "4AAE22011098E322A5970F4D03C550FE")
    public  ColorMatrixColorFilter(float[] array) {
        addTaint(array[0]);
        if(array.length < 20)        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_471226711 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_471226711.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_471226711;
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

    
    @DSModeled(DSC.SAFE)
    private static int nativeColorMatrixFilter(float[] array) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_207688702 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_207688702;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nColorMatrixFilter(int nativeFilter, float[] array) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_221975373 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_221975373;
    }

    
}

