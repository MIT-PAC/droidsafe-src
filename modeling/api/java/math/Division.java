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
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.math;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

class Division {

    /**
     * Divides an array by an integer value. Implements the Knuth's division
     * algorithm. See D. Knuth, The Art of Computer Programming, vol. 2.
     *
     * @return remainder
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:34.250 -0500", hash_original_method = "E1E264751E5195BA90C2FFC7352846D5", hash_generated_method = "C2300A69C9E396B7E6838C00C51A153A")
    
static int divideArrayByInt(int[] quotient, int[] dividend, final int dividendLength,
            final int divisor) {

        long rem = 0;
        long bLong = divisor & 0xffffffffL;

        for (int i = dividendLength - 1; i >= 0; i--) {
            long temp = (rem << 32) | (dividend[i] & 0xffffffffL);
            long quot;
            if (temp >= 0) {
                quot = (temp / bLong);
                rem = (temp % bLong);
            } else {
                /*
                 * make the dividend positive shifting it right by 1 bit then
                 * get the quotient an remainder and correct them properly
                 */
                long aPos = temp >>> 1;
                long bPos = divisor >>> 1;
                quot = aPos / bPos;
                rem = aPos % bPos;
                // double the remainder and add 1 if a is odd
                rem = (rem << 1) + (temp & 1);
                if ((divisor & 1) != 0) {
                    // the divisor is odd
                    if (quot <= rem) {
                        rem -= quot;
                    } else {
                        if (quot - rem <= bLong) {
                            rem += bLong - quot;
                            quot -= 1;
                        } else {
                            rem += (bLong << 1) - quot;
                            quot -= 2;
                        }
                    }
                }
            }
            quotient[i] = (int) (quot & 0xffffffffL);
        }
        return (int) rem;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.891 -0400", hash_original_method = "1CA90C9F74D165C3A16F193EF3A664DD", hash_generated_method = "1CA90C9F74D165C3A16F193EF3A664DD")
    public Division ()
    {
        //Synthesized constructor
    }
    
}

