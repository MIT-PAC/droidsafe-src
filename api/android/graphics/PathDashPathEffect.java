package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
public class PathDashPathEffect extends PathEffect {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-08 23:08:30.756 -0400", hash_original_method = "6D89CA8874EF35472879901FA64C2E5A", hash_generated_method = "BEFDEAC62317FA15A434C6C63E4E087F")
    public  PathDashPathEffect(Path shape, float advance, float phase,
                              Style style) {
        addTaint(style.getTaint());
        addTaint(phase);
        addTaint(advance);
        addTaint(shape.getTaint());
        native_instance = nativeCreate(shape.ni(), advance, phase,
                                       style.native_style);
        // ---------- Original Method ----------
        //native_instance = nativeCreate(shape.ni(), advance, phase,
                                       //style.native_style);
    }

    
        private static int nativeCreate(int native_path, float advance,
                                           float phase, int native_style) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_32104371 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_32104371;
    }

    
    public enum Style {
        TRANSLATE(0),   
        ROTATE(1),      
        MORPH(2);       
        Style(int value) {
            native_style = value;
        }
        int native_style;
    }

    
}

