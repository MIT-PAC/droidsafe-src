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
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


/*
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */

package java.util.concurrent;

/**
 * A recursive result-bearing {@link ForkJoinTask}.
 *
 * <p>For a classic example, here is a task computing Fibonacci numbers:
 *
 *  <pre> {@code
 * class Fibonacci extends RecursiveTask<Integer> {
 *   final int n;
 *   Fibonacci(int n) { this.n = n; }
 *   Integer compute() {
 *     if (n <= 1)
 *       return n;
 *     Fibonacci f1 = new Fibonacci(n - 1);
 *     f1.fork();
 *     Fibonacci f2 = new Fibonacci(n - 2);
 *     return f2.compute() + f1.join();
 *   }
 * }}</pre>
 *
 * However, besides being a dumb way to compute Fibonacci functions
 * (there is a simple fast linear algorithm that you'd use in
 * practice), this is likely to perform poorly because the smallest
 * subtasks are too small to be worthwhile splitting up. Instead, as
 * is the case for nearly all fork/join applications, you'd pick some
 * minimum granularity size (for example 10 here) for which you always
 * sequentially solve rather than subdividing.
 *
 * @since 1.7
 * @hide
 * @author Doug Lea
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public abstract class RecursiveTask<V> extends ForkJoinTask<V> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.956 -0400", hash_original_field = "6092431D634EBE2CA49B4F4F089D811B", hash_generated_field = "02365C9A5A2B0968EA30E114F1EEA2BE")

    private static final long serialVersionUID = 5232453952276485270L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.958 -0400", hash_original_field = "D7604DFAA500A27AADFB727128D5C70F", hash_generated_field = "D7604DFAA500A27AADFB727128D5C70F")

    V result;

    /**
     * The main computation performed by this task.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.958 -0400", hash_original_method = "A3DCE5C9331A83568A0AD0980A641BD4", hash_generated_method = "92EF0C4E2242BB9B1A79C72311A85D2D")
    
protected abstract V compute();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.959 -0400", hash_original_method = "6A41CC7DD834C30742787F22F63834A3", hash_generated_method = "6EE8DFF48811BF71BF8033ADB7F30EC6")
    
public final V getRawResult() {
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.959 -0400", hash_original_method = "4A51DD9A4A08D97A567FABDC47027A60", hash_generated_method = "48BE479268826C61A2E1E8B33FCE3352")
    
protected final void setRawResult(V value) {
        result = value;
    }

    /**
     * Implements execution conventions for RecursiveTask.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:25.959 -0400", hash_original_method = "9C50BAB518DB2505CE89F8C1F2F26B3A", hash_generated_method = "313DFDDD1B2B23027080BE35D60F404F")
    
protected final boolean exec() {
        result = compute();
        return true;
    }

}
