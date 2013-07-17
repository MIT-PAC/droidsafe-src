package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class ComposeShader extends Shader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.177 -0400", hash_original_field = "327874507E1B565E8B7C84B73A259C64", hash_generated_field = "9D1A193A171A566C28715B3DF9829B6D")

    @SuppressWarnings({"UnusedDeclaration"}) private Shader mShaderA;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.177 -0400", hash_original_field = "57F941674B2C8089D85DBE5F4EA26FA9", hash_generated_field = "0BC17BE1D67AE4FB7B6930A577FEA85A")

    @SuppressWarnings({"UnusedDeclaration"}) private Shader mShaderB;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.180 -0400", hash_original_method = "54479FEAF5918A2D0015420E3AF1868D", hash_generated_method = "C7F1D56EF0682306F7831840B5A4D0B0")
    public  ComposeShader(Shader shaderA, Shader shaderB, Xfermode mode) {
        addTaint(mode.getTaint());
        mShaderA = shaderA;
        mShaderB = shaderB;
        native_instance = nativeCreate1(shaderA.native_instance, shaderB.native_instance,
                (mode != null) ? mode.native_instance : 0);
        if(mode instanceof PorterDuffXfermode)        
        {
            PorterDuff.Mode pdMode = ((PorterDuffXfermode) mode).mode;
            native_shader = nativePostCreate2(native_instance, shaderA.native_shader,
                    shaderB.native_shader, pdMode != null ? pdMode.nativeInt : 0);
        } //End block
        else
        {
            native_shader = nativePostCreate1(native_instance, shaderA.native_shader,
                    shaderB.native_shader, mode != null ? mode.native_instance : 0);
        } //End block
        // ---------- Original Method ----------
        //mShaderA = shaderA;
        //mShaderB = shaderB;
        //native_instance = nativeCreate1(shaderA.native_instance, shaderB.native_instance,
                //(mode != null) ? mode.native_instance : 0);
        //if (mode instanceof PorterDuffXfermode) {
            //PorterDuff.Mode pdMode = ((PorterDuffXfermode) mode).mode;
            //native_shader = nativePostCreate2(native_instance, shaderA.native_shader,
                    //shaderB.native_shader, pdMode != null ? pdMode.nativeInt : 0);
        //} else {
            //native_shader = nativePostCreate1(native_instance, shaderA.native_shader,
                    //shaderB.native_shader, mode != null ? mode.native_instance : 0);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.182 -0400", hash_original_method = "6DA3793B1F4C3B72942152784A23C545", hash_generated_method = "B112B2A6881BB62DFF4E7106CDBF9A05")
    public  ComposeShader(Shader shaderA, Shader shaderB, PorterDuff.Mode mode) {
        addTaint(mode.getTaint());
        mShaderA = shaderA;
        mShaderB = shaderB;
        native_instance = nativeCreate2(shaderA.native_instance, shaderB.native_instance,
                mode.nativeInt);
        native_shader = nativePostCreate2(native_instance, shaderA.native_shader,
                shaderB.native_shader, mode.nativeInt);
        // ---------- Original Method ----------
        //mShaderA = shaderA;
        //mShaderB = shaderB;
        //native_instance = nativeCreate2(shaderA.native_instance, shaderB.native_instance,
                //mode.nativeInt);
        //native_shader = nativePostCreate2(native_instance, shaderA.native_shader,
                //shaderB.native_shader, mode.nativeInt);
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeCreate1(int native_shaderA, int native_shaderB,
            int native_mode) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeCreate2(int native_shaderA, int native_shaderB,
            int porterDuffMode) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativePostCreate1(int native_shader, int native_skiaShaderA,
            int native_skiaShaderB, int native_mode) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativePostCreate2(int native_shader, int native_skiaShaderA,
            int native_skiaShaderB, int porterDuffMode) {
        return DSUtils.UNKNOWN_INT;
    }

    
}

