/*
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
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/licenses/publicdomain
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.util.concurrent;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class TimeoutException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.562 -0500", hash_original_field = "68575169DC0173071B6C7AFCA1837323", hash_generated_field = "27D2403B305D4570D5BAB39A961BDA5B")

    private static final long serialVersionUID = 1900926677490660714L;

    /**
     * Constructs a <tt>TimeoutException</tt> with no specified detail
     * message.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.565 -0500", hash_original_method = "043D89A921444ACFFC25D3711EECF0CA", hash_generated_method = "1EC3AF62B1106EC64D8195D6B4E8C3D2")
    
public TimeoutException() {}

    /**
     * Constructs a <tt>TimeoutException</tt> with the specified detail
     * message.
     *
     * @param message the detail message
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.568 -0500", hash_original_method = "D54DDC72729A014BD7698825D7BF2D5A", hash_generated_method = "787A427C3C50877320E1D51565E40BED")
    
public TimeoutException(String message) {
        super(message);
    }
}

