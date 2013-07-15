package android.graphics;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class ComposeShader extends Shader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.507 -0400", hash_original_field = "327874507E1B565E8B7C84B73A259C64", hash_generated_field = "9D1A193A171A566C28715B3DF9829B6D")

    @SuppressWarnings({"UnusedDeclaration"}) private Shader mShaderA;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.507 -0400", hash_original_field = "57F941674B2C8089D85DBE5F4EA26FA9", hash_generated_field = "0BC17BE1D67AE4FB7B6930A577FEA85A")

    @SuppressWarnings({"UnusedDeclaration"}) private Shader mShaderB;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.508 -0400", hash_original_method = "54479FEAF5918A2D0015420E3AF1868D", hash_generated_method = "06639F638A044F1668924F2F378C8874")
    public  ComposeShader(Shader shaderA, Shader shaderB, Xfermode mode) {
        mShaderA = shaderA;
        mShaderB = shaderB;
        native_instance = nativeCreate1(shaderA.native_instance, shaderB.native_instance,
                (mode != null) ? mode.native_instance : 0);
        {
            PorterDuff.Mode pdMode = ((PorterDuffXfermode) mode).mode;
            native_shader = nativePostCreate2(native_instance, shaderA.native_shader,
                    shaderB.native_shader, pdMode != null ? pdMode.nativeInt : 0);
        } 
        {
            native_shader = nativePostCreate1(native_instance, shaderA.native_shader,
                    shaderB.native_shader, mode != null ? mode.native_instance : 0);
        } 
        addTaint(mode.getTaint());
        
        
        
        
                
        
            
            
                    
        
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.509 -0400", hash_original_method = "6DA3793B1F4C3B72942152784A23C545", hash_generated_method = "F1C66A31CF79DBC5B492AED06B2BD5B3")
    public  ComposeShader(Shader shaderA, Shader shaderB, PorterDuff.Mode mode) {
        mShaderA = shaderA;
        mShaderB = shaderB;
        native_instance = nativeCreate2(shaderA.native_instance, shaderB.native_instance,
                mode.nativeInt);
        native_shader = nativePostCreate2(native_instance, shaderA.native_shader,
                shaderB.native_shader, mode.nativeInt);
        addTaint(mode.getTaint());
        
        
        
        
                
        
                
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

