package com.google.android.collect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.ArrayList;
import java.util.Collections;

public class Lists {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.316 -0400", hash_original_method = "9C03178B6871DBAD781A5B1956479BCD", hash_generated_method = "4A727BF71289B1857A6F0CD7ECDE0466")
    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<E>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.316 -0400", hash_original_method = "4E292A22314891AA5815FB5D3DCB058E", hash_generated_method = "AE587EA7C616EAFD929EE1AA2BBFB053")
    public static <E> ArrayList<E> newArrayList(E... elements) {
        int capacity = (elements.length * 110) / 100 + 5;
        ArrayList<E> list = new ArrayList<E>(capacity);
        Collections.addAll(list, elements);
        return list;
    }

    
}


