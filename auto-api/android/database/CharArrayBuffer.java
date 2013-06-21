package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class CharArrayBuffer {
    public char[] data;
    public int sizeCopied;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.933 -0400", hash_original_method = "BF91F70D5F13CEDD7E0CBBE1EFC98D70", hash_generated_method = "6DFD7821FA34F13DCF4AE238CDC18293")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharArrayBuffer(int size) {
        dsTaint.addTaint(size);
        data = new char[size];
        // ---------- Original Method ----------
        //data = new char[size];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.934 -0400", hash_original_method = "40679B6E17B0E065ADE0664E6257B1BF", hash_generated_method = "700A4E10AB76C9FE600A773852C68290")
    @DSModeled(DSC.SAFE)
    public CharArrayBuffer(char[] buf) {
        dsTaint.addTaint(buf[0]);
        // ---------- Original Method ----------
        //data = buf;
    }

    
}

