package android.database;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public final class CharArrayBuffer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.351 -0500", hash_original_field = "46C3CE009AB1E1D4FFA5853E10EBEA22", hash_generated_field = "D84F28F88F1F0A20B618AC030F591DF4")

    
    public char[] data;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.353 -0500", hash_original_field = "26DD08FE4F3D2656704496BC18485205", hash_generated_field = "2DB5C1571BCAB0B5A55300C609B928F2")

    public int sizeCopied;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.346 -0500", hash_original_method = "BF91F70D5F13CEDD7E0CBBE1EFC98D70", hash_generated_method = "E724D56C64C47C9C10F7607C813860A9")
    
public CharArrayBuffer(int size) {
        data = new char[size];
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.349 -0500", hash_original_method = "40679B6E17B0E065ADE0664E6257B1BF", hash_generated_method = "D11AB8A55AD630BE9205E27B3AC62E6D")
    
public CharArrayBuffer(char[] buf) {
        data = buf;
    }

    
}

