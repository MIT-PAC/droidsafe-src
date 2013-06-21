package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public class IllegalFormatCodePointException extends IllegalFormatException implements Serializable {
    private int c;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.486 -0400", hash_original_method = "EC5D1DD50821B22662FE61EFD96C533A", hash_generated_method = "12792EDF7DE43C35FE4C31FED0F708E9")
    @DSModeled(DSC.SAFE)
    public IllegalFormatCodePointException(int c) {
        dsTaint.addTaint(c);
        // ---------- Original Method ----------
        //this.c = c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.486 -0400", hash_original_method = "D5B710B3F21DF9B84478D362C18B2C11", hash_generated_method = "7EB79BD7CB6B187FAA821249269BD6BA")
    @DSModeled(DSC.SAFE)
    public int getCodePoint() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.487 -0400", hash_original_method = "D74EDE3BF1A0D3C4B575CB0DB2BFF88F", hash_generated_method = "FA3ED85D3C771B180E6223FBBAB15299")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getMessage() {
        String varA4265EC1F0C4033332F57D47FD39C87D_840145176 = (Integer.toHexString(c));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Integer.toHexString(c);
    }

    
    private static final long serialVersionUID = 19080630L;
}

