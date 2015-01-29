package com.google.android.collect;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Collections;

public class Lists {
    
    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<E>();
    }
    
    public static <E> ArrayList<E> newArrayList(E... elements) {
        int capacity = (elements.length * 110) / 100 + 5;
        ArrayList<E> list = new ArrayList<E>(capacity);
        Collections.addAll(list, elements);
        return list;
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.483 -0400", hash_original_method = "440C6E9BC1692F21363DE1B8F62E6180", hash_generated_method = "440C6E9BC1692F21363DE1B8F62E6180")
    public Lists ()
    {
        //Synthesized constructor
    }
    
}

