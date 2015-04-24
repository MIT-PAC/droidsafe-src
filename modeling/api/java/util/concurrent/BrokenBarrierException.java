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


/*
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */

package java.util.concurrent;

/**
 * Exception thrown when a thread tries to wait upon a barrier that is
 * in a broken state, or which enters the broken state while the thread
 * is waiting.
 *
 * @see CyclicBarrier
 *
 * @since 1.5
 * @author Doug Lea
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class BrokenBarrierException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.488 -0400", hash_original_field = "852DA7724D4224E00589024217A33766", hash_generated_field = "6FC45A2038F85BA63C53B4141525DB02")

    private static final long serialVersionUID = 7117394618823254244L;

    /**
     * Constructs a {@code BrokenBarrierException} with no specified detail
     * message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.489 -0400", hash_original_method = "2BC358C583B771407940AA4CE193B40F", hash_generated_method = "AA24B6E0E33B1327456EFDE80DE0DF3B")
    
public BrokenBarrierException() {}

    /**
     * Constructs a {@code BrokenBarrierException} with the specified
     * detail message.
     *
     * @param message the detail message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.489 -0400", hash_original_method = "C6A95F62AB4855FE42FEB35D12785B70", hash_generated_method = "B897E3BDC97C89431370FF875671985B")
    
public BrokenBarrierException(String message) {
        super(message);
    }
}
