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
 * A recursive resultless {@link ForkJoinTask}.  This class
 * establishes conventions to parameterize resultless actions as
 * {@code Void} {@code ForkJoinTask}s. Because {@code null} is the
 * only valid value of type {@code Void}, methods such as {@code join}
 * always return {@code null} upon completion.
 *
 * <p><b>Sample Usages.</b> Here is a simple but complete ForkJoin
 * sort that sorts a given {@code long[]} array:
 *
 *  <pre> {@code
 * static class SortTask extends RecursiveAction {
 *   final long[] array; final int lo, hi;
 *   SortTask(long[] array, int lo, int hi) {
 *     this.array = array; this.lo = lo; this.hi = hi;
 *   }
 *   SortTask(long[] array) { this(array, 0, array.length); }
 *   protected void compute() {
 *     if (hi - lo < THRESHOLD)
 *       sortSequentially(lo, hi);
 *     else {
 *       int mid = (lo + hi) >>> 1;
 *       invokeAll(new SortTask(array, lo, mid),
 *                 new SortTask(array, mid, hi));
 *       merge(lo, mid, hi);
 *     }
 *   }
 *   // implementation details follow:
 *   static final int THRESHOLD = 1000;
 *   void sortSequentially(int lo, int hi) {
 *     Arrays.sort(array, lo, hi);
 *   }
 *   void merge(int lo, int mid, int hi) {
 *     long[] buf = Arrays.copyOfRange(array, lo, mid);
 *     for (int i = 0, j = lo, k = mid; i < buf.length; j++)
 *       array[j] = (k == hi || buf[i] < array[k]) ?
 *         buf[i++] : array[k++];
 *   }
 * }}</pre>
 *
 * You could then sort {@code anArray} by creating {@code new
 * SortTask(anArray)} and invoking it in a ForkJoinPool.  As a more
 * concrete simple example, the following task increments each element
 * of an array:
 *  <pre> {@code
 * class IncrementTask extends RecursiveAction {
 *   final long[] array; final int lo, hi;
 *   IncrementTask(long[] array, int lo, int hi) {
 *     this.array = array; this.lo = lo; this.hi = hi;
 *   }
 *   protected void compute() {
 *     if (hi - lo < THRESHOLD) {
 *       for (int i = lo; i < hi; ++i)
 *         array[i]++;
 *     }
 *     else {
 *       int mid = (lo + hi) >>> 1;
 *       invokeAll(new IncrementTask(array, lo, mid),
 *                 new IncrementTask(array, mid, hi));
 *     }
 *   }
 * }}</pre>
 *
 * <p>The following example illustrates some refinements and idioms
 * that may lead to better performance: RecursiveActions need not be
 * fully recursive, so long as they maintain the basic
 * divide-and-conquer approach. Here is a class that sums the squares
 * of each element of a double array, by subdividing out only the
 * right-hand-sides of repeated divisions by two, and keeping track of
 * them with a chain of {@code next} references. It uses a dynamic
 * threshold based on method {@code getSurplusQueuedTaskCount}, but
 * counterbalances potential excess partitioning by directly
 * performing leaf actions on unstolen tasks rather than further
 * subdividing.
 *
 *  <pre> {@code
 * double sumOfSquares(ForkJoinPool pool, double[] array) {
 *   int n = array.length;
 *   Applyer a = new Applyer(array, 0, n, null);
 *   pool.invoke(a);
 *   return a.result;
 * }
 *
 * class Applyer extends RecursiveAction {
 *   final double[] array;
 *   final int lo, hi;
 *   double result;
 *   Applyer next; // keeps track of right-hand-side tasks
 *   Applyer(double[] array, int lo, int hi, Applyer next) {
 *     this.array = array; this.lo = lo; this.hi = hi;
 *     this.next = next;
 *   }
 *
 *   double atLeaf(int l, int h) {
 *     double sum = 0;
 *     for (int i = l; i < h; ++i) // perform leftmost base step
 *       sum += array[i] * array[i];
 *     return sum;
 *   }
 *
 *   protected void compute() {
 *     int l = lo;
 *     int h = hi;
 *     Applyer right = null;
 *     while (h - l > 1 && getSurplusQueuedTaskCount() <= 3) {
 *       int mid = (l + h) >>> 1;
 *       right = new Applyer(array, mid, h, right);
 *       right.fork();
 *       h = mid;
 *     }
 *     double sum = atLeaf(l, h);
 *     while (right != null) {
 *       if (right.tryUnfork()) // directly calculate if not stolen
 *         sum += right.atLeaf(right.lo, right.hi);
 *       else {
 *         right.join();
 *         sum += right.result;
 *       }
 *       right = right.next;
 *     }
 *     result = sum;
 *   }
 * }}</pre>
 *
 * @since 1.7
 * @hide
 * @author Doug Lea
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public abstract class RecursiveAction extends ForkJoinTask<Void> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.935 -0400", hash_original_field = "E2392645A9803F313F800911F85FA392", hash_generated_field = "4C883A47496BCA7FAC55F8AF370822EC")

    private static final long serialVersionUID = 5232453952276485070L;

    /**
     * The main computation performed by this task.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.935 -0400", hash_original_method = "3472BCA0870D21FCBDB4784495B49568", hash_generated_method = "C70F0A169D15990F3E096BD12F5EA97B")
    
protected abstract void compute();

    /**
     * Always returns {@code null}.
     *
     * @return {@code null} always
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.936 -0400", hash_original_method = "3DE82AA92F6CBDFB2CF4126D370439F9", hash_generated_method = "3F97477252B0C202F30FC22FA92A0B8B")
    
public final Void getRawResult() { return null; }

    /**
     * Requires null completion value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.936 -0400", hash_original_method = "ABDC5F11B2ED6651153DFDF12B4B77F9", hash_generated_method = "00AC88ADFEEEFA26311416C1DDAF2E14")
    
protected final void setRawResult(Void mustBeNull) { }

    /**
     * Implements execution conventions for RecursiveActions.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:19.936 -0400", hash_original_method = "8643D3FC2DF783DC8917CE6A843DED56", hash_generated_method = "B77FB3F18A2C4D30D9E86E130F8074FA")
    
protected final boolean exec() {
        compute();
        return true;
    }

}
