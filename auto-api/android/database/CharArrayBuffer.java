package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class CharArrayBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.654 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "D84F28F88F1F0A20B618AC030F591DF4")

    public char[] data;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.654 -0400", hash_original_field = "4B22B1A6185718C71CD4A05A9AFE098D", hash_generated_field = "2DB5C1571BCAB0B5A55300C609B928F2")

    public int sizeCopied;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.655 -0400", hash_original_method = "BF91F70D5F13CEDD7E0CBBE1EFC98D70", hash_generated_method = "4C2787E6751E26394D8D41AC561B9988")
    public  CharArrayBuffer(int size) {
        data = new char[size];
        // ---------- Original Method ----------
        //data = new char[size];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.662 -0400", hash_original_method = "40679B6E17B0E065ADE0664E6257B1BF", hash_generated_method = "E397297280709518057C19FD579B0BA7")
    public  CharArrayBuffer(char[] buf) {
        data = buf;
        // ---------- Original Method ----------
        //data = buf;
    }

    
}

