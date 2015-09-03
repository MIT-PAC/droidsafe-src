/**
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
*******************************************************************************
* Copyright (C) 1996-2005, International Business Machines Corporation and    *
* others. All Rights Reserved.                                                *
*******************************************************************************
*
*******************************************************************************
*/


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.nio.charset;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import libcore.icu.NativeConverter;

final class CharsetICU extends Charset {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.620 -0400", hash_original_field = "BA534D89BC743B2713B834016AE2CE84", hash_generated_field = "6DD0445F99F9B261F7C77EA7FDB01148")

    private  String icuCanonicalName;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.621 -0400", hash_original_method = "757F0CAF578939E304717EBBB5205D82", hash_generated_method = "E08A811E2223AD829952A8EF3C167D0A")
    
protected CharsetICU(String canonicalName, String icuCanonName, String[] aliases) {
         super(canonicalName, aliases);
         icuCanonicalName = icuCanonName;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.621 -0400", hash_original_method = "E821BF5CAC3B1B3B28BA69CD2EC5EEAB", hash_generated_method = "BC1D6EC20D7EB5175EB2745FD0B288A3")
    
public CharsetDecoder newDecoder() {
        return CharsetDecoderICU.newInstance(this, icuCanonicalName);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.622 -0400", hash_original_method = "E98E9CAA5D46E5AB825E624857A1AD8D", hash_generated_method = "6FFCB73943ACFB439BF454A3BC672951")
    
public CharsetEncoder newEncoder() {
        return CharsetEncoderICU.newInstance(this, icuCanonicalName);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:42.622 -0400", hash_original_method = "D85E5EAFC717D14BE8F2289951147106", hash_generated_method = "AD9A6940C7C7065E3ACF4A33BB145B53")
    
public boolean contains(Charset cs) {
        if (cs == null) {
            return false;
        } else if (this.equals(cs)) {
            return true;
        }
        return NativeConverter.contains(this.name(), cs.name());
    }
}
