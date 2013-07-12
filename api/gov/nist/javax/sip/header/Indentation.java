package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

class Indentation {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.554 -0400", hash_original_field = "449072E30B43D04B744F22522A880818", hash_generated_field = "008AF28A46BB87C2DFA1C38C4F2D39CE")

    private int indentation;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.554 -0400", hash_original_method = "3ED5D9003C94B37DFE34F7E548B0A049", hash_generated_method = "D21C7197323C0AC51C8E527D1BC7FA49")
    protected  Indentation() {
        indentation = 0;
        // ---------- Original Method ----------
        //indentation = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.555 -0400", hash_original_method = "B9B0555312A93A148C3D06FF260FB7DE", hash_generated_method = "4E5AE8A8D228218792E8BDDE9075947A")
    protected  Indentation(int initval) {
        indentation = initval;
        // ---------- Original Method ----------
        //indentation = initval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.555 -0400", hash_original_method = "9806D9C99234026338307AC4AA946059", hash_generated_method = "818A7C48DABABA79D2F3477B550CF52A")
    protected void setIndentation(int initval) {
        indentation = initval;
        // ---------- Original Method ----------
        //indentation = initval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.556 -0400", hash_original_method = "8C516A01A1E7AEB883F43E447DEEB28B", hash_generated_method = "5FB6AD3E523DC5FC1984C44FA3EB4CB0")
    protected int getCount() {
        int var449072E30B43D04B744F22522A880818_1425268627 = (indentation);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_165880300 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_165880300;
        // ---------- Original Method ----------
        //return indentation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.557 -0400", hash_original_method = "6FB962D7C77F4582D7627B370471C9FF", hash_generated_method = "60D5DE664C61FB5F43CD88034C1D9EF6")
    protected void increment() {
        indentation++;
        // ---------- Original Method ----------
        //indentation++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.557 -0400", hash_original_method = "54F21AAA256E1C615958DA1382F121C5", hash_generated_method = "6707B8ED2429D4B7ECC5122B9CD62DD9")
    protected void decrement() {
        indentation--;
        // ---------- Original Method ----------
        //indentation--;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.558 -0400", hash_original_method = "F608522BE2D902628C253AAC05B9941D", hash_generated_method = "BC33116711E39F3F206B71A0483D10E4")
    protected String getIndentation() {
        char[] chars = new char[indentation];
        java.util.Arrays.fill(chars, ' ');
String var300818D7D4F603E5F4346D4E090224B6_1051371744 =         new String(chars);
        var300818D7D4F603E5F4346D4E090224B6_1051371744.addTaint(taint);
        return var300818D7D4F603E5F4346D4E090224B6_1051371744;
        // ---------- Original Method ----------
        //char[] chars = new char[indentation];
        //java.util.Arrays.fill(chars, ' ');
        //return new String(chars);
    }

    
}

