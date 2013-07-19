package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

class Indentation {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.535 -0400", hash_original_field = "449072E30B43D04B744F22522A880818", hash_generated_field = "008AF28A46BB87C2DFA1C38C4F2D39CE")

    private int indentation;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.535 -0400", hash_original_method = "3ED5D9003C94B37DFE34F7E548B0A049", hash_generated_method = "D21C7197323C0AC51C8E527D1BC7FA49")
    protected  Indentation() {
        indentation = 0;
        // ---------- Original Method ----------
        //indentation = 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.536 -0400", hash_original_method = "B9B0555312A93A148C3D06FF260FB7DE", hash_generated_method = "4E5AE8A8D228218792E8BDDE9075947A")
    protected  Indentation(int initval) {
        indentation = initval;
        // ---------- Original Method ----------
        //indentation = initval;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.536 -0400", hash_original_method = "9806D9C99234026338307AC4AA946059", hash_generated_method = "818A7C48DABABA79D2F3477B550CF52A")
    protected void setIndentation(int initval) {
        indentation = initval;
        // ---------- Original Method ----------
        //indentation = initval;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.536 -0400", hash_original_method = "8C516A01A1E7AEB883F43E447DEEB28B", hash_generated_method = "E5672145C8A312FC43E513B74FCACF99")
    protected int getCount() {
        int var449072E30B43D04B744F22522A880818_1364877374 = (indentation);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1473531108 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1473531108;
        // ---------- Original Method ----------
        //return indentation;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.536 -0400", hash_original_method = "6FB962D7C77F4582D7627B370471C9FF", hash_generated_method = "60D5DE664C61FB5F43CD88034C1D9EF6")
    protected void increment() {
        indentation++;
        // ---------- Original Method ----------
        //indentation++;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.537 -0400", hash_original_method = "54F21AAA256E1C615958DA1382F121C5", hash_generated_method = "6707B8ED2429D4B7ECC5122B9CD62DD9")
    protected void decrement() {
        indentation--;
        // ---------- Original Method ----------
        //indentation--;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.537 -0400", hash_original_method = "F608522BE2D902628C253AAC05B9941D", hash_generated_method = "7AE4B0CBAEE89B82BFD0DC6AA1230255")
    protected String getIndentation() {
        char[] chars = new char[indentation];
        java.util.Arrays.fill(chars, ' ');
String var300818D7D4F603E5F4346D4E090224B6_1577787043 =         new String(chars);
        var300818D7D4F603E5F4346D4E090224B6_1577787043.addTaint(taint);
        return var300818D7D4F603E5F4346D4E090224B6_1577787043;
        // ---------- Original Method ----------
        //char[] chars = new char[indentation];
        //java.util.Arrays.fill(chars, ' ');
        //return new String(chars);
    }

    
}

