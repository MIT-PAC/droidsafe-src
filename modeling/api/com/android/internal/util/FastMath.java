package com.android.internal.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class FastMath {

    /**
     * Fast round from float to int. This is faster than Math.round()
     * thought it may return slightly different results. It does not try to
     * handle (in any meaningful way) NaN or infinities.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.999 -0500", hash_original_method = "E58EA1DFC67544D3C851C7F9CC058E9E", hash_generated_method = "1203240BBD954CF5F9C084F8BB169A2D")
    
public static int round(float x) {
        long lx = (long)(x * (65536 * 256f));
        return (int)((lx + 0x800000) >> 24);
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.667 -0400", hash_original_method = "64D1D90DF7F5177989F305720BFD3703", hash_generated_method = "64D1D90DF7F5177989F305720BFD3703")
    public FastMath ()
    {
        //Synthesized constructor
    }
    
}

