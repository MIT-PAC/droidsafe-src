package com.google.android.collect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;

public class Lists {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.136 -0400", hash_original_method = "0DBD2C7B501157057D71BFEB53FDAE94", hash_generated_method = "0DBD2C7B501157057D71BFEB53FDAE94")
        public Lists ()
    {
    }


        public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<E>();
    }

    
        public static <E> ArrayList<E> newArrayList(E... elements) {
        int capacity = (elements.length * 110) / 100 + 5;
        ArrayList<E> list = new ArrayList<E>(capacity);
        Collections.addAll(list, elements);
        return list;
    }

    
}

