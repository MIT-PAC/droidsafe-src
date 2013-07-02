package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

class Indentation {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.764 -0400", hash_original_field = "449072E30B43D04B744F22522A880818", hash_generated_field = "008AF28A46BB87C2DFA1C38C4F2D39CE")

    private int indentation;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.765 -0400", hash_original_method = "3ED5D9003C94B37DFE34F7E548B0A049", hash_generated_method = "D21C7197323C0AC51C8E527D1BC7FA49")
    protected  Indentation() {
        indentation = 0;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.765 -0400", hash_original_method = "B9B0555312A93A148C3D06FF260FB7DE", hash_generated_method = "4E5AE8A8D228218792E8BDDE9075947A")
    protected  Indentation(int initval) {
        indentation = initval;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.765 -0400", hash_original_method = "9806D9C99234026338307AC4AA946059", hash_generated_method = "818A7C48DABABA79D2F3477B550CF52A")
    protected void setIndentation(int initval) {
        indentation = initval;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.765 -0400", hash_original_method = "8C516A01A1E7AEB883F43E447DEEB28B", hash_generated_method = "E772607379FC19199F3910089A190FB1")
    protected int getCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_449056566 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_449056566;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.766 -0400", hash_original_method = "6FB962D7C77F4582D7627B370471C9FF", hash_generated_method = "D1D1D4D3EB0E78DBB1B871A9BBD597B4")
    protected void increment() {
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.766 -0400", hash_original_method = "54F21AAA256E1C615958DA1382F121C5", hash_generated_method = "8B1F7F1094E96DC5ECE2EECE01021145")
    protected void decrement() {
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.766 -0400", hash_original_method = "F608522BE2D902628C253AAC05B9941D", hash_generated_method = "9C76B6939832CA44BBD13FEDC3349F8B")
    protected String getIndentation() {
        String varB4EAC82CA7396A68D541C85D26508E83_1872230264 = null; 
        char[] chars = new char[indentation];
        java.util.Arrays.fill(chars, ' ');
        varB4EAC82CA7396A68D541C85D26508E83_1872230264 = new String(chars);
        varB4EAC82CA7396A68D541C85D26508E83_1872230264.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1872230264;
        
        
        
        
    }

    
}

