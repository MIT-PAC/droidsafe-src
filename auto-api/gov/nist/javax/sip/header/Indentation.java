package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class Indentation {
    private int indentation;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.007 -0400", hash_original_method = "3ED5D9003C94B37DFE34F7E548B0A049", hash_generated_method = "D21C7197323C0AC51C8E527D1BC7FA49")
    @DSModeled(DSC.SAFE)
    protected Indentation() {
        indentation = 0;
        // ---------- Original Method ----------
        //indentation = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.008 -0400", hash_original_method = "B9B0555312A93A148C3D06FF260FB7DE", hash_generated_method = "0FFC10CFCE67492BE8A605EB26A516BD")
    @DSModeled(DSC.SAFE)
    protected Indentation(int initval) {
        dsTaint.addTaint(initval);
        // ---------- Original Method ----------
        //indentation = initval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.008 -0400", hash_original_method = "9806D9C99234026338307AC4AA946059", hash_generated_method = "1651F6C32AEE9721D8BEFF6EBE37C188")
    @DSModeled(DSC.SAFE)
    protected void setIndentation(int initval) {
        dsTaint.addTaint(initval);
        // ---------- Original Method ----------
        //indentation = initval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.008 -0400", hash_original_method = "8C516A01A1E7AEB883F43E447DEEB28B", hash_generated_method = "0D7B4A505557B25805BB6D35A91F6C84")
    @DSModeled(DSC.SAFE)
    protected int getCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return indentation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.008 -0400", hash_original_method = "6FB962D7C77F4582D7627B370471C9FF", hash_generated_method = "D1D1D4D3EB0E78DBB1B871A9BBD597B4")
    @DSModeled(DSC.SAFE)
    protected void increment() {
        // ---------- Original Method ----------
        //indentation++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.008 -0400", hash_original_method = "54F21AAA256E1C615958DA1382F121C5", hash_generated_method = "8B1F7F1094E96DC5ECE2EECE01021145")
    @DSModeled(DSC.SAFE)
    protected void decrement() {
        // ---------- Original Method ----------
        //indentation--;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.009 -0400", hash_original_method = "F608522BE2D902628C253AAC05B9941D", hash_generated_method = "D7BBEA5427E09EDEF174AB0F8433E477")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String getIndentation() {
        char[] chars;
        chars = new char[indentation];
        java.util.Arrays.fill(chars, ' ');
        String var9B6664B2DE21520412F0E1A2ECF4D0EC_869369221 = (new String(chars));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //char[] chars = new char[indentation];
        //java.util.Arrays.fill(chars, ' ');
        //return new String(chars);
    }

    
}

