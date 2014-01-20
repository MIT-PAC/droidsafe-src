package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

final class DualPivotQuicksort {

    /*
     * Sorting methods for 7 primitive types.
     */

    /**
     * Sorts the specified array into ascending numerical order.
     *
     * @param a the array to be sorted
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.358 -0500", hash_original_method = "6046B077AB394D3EE192C203E1B5357E", hash_generated_method = "3AE9973997983BDE421D39586AF6DF26")
    
public static void sort(int[] a) {
        doSort(a, 0, a.length - 1);
    }

    /**
     * Sorts the specified range of the array into ascending order. The range
     * to be sorted extends from the index {@code fromIndex}, inclusive, to
     * the index {@code toIndex}, exclusive. If {@code fromIndex == toIndex},
     * the range to be sorted is empty (and the call is a no-op).
     *
     * @param a the array to be sorted
     * @param fromIndex the index of the first element, inclusive, to be sorted
     * @param toIndex the index of the last element, exclusive, to be sorted
     * @throws IllegalArgumentException if {@code fromIndex > toIndex}
     * @throws ArrayIndexOutOfBoundsException
     *     if {@code fromIndex < 0} or {@code toIndex > a.length}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.360 -0500", hash_original_method = "BC36EF2390B2EAFCD9CC55E9BF920708", hash_generated_method = "381136C45908BC9FBDE9FD24FA3C98CD")
    
public static void sort(int[] a, int fromIndex, int toIndex) {
        Arrays.checkStartAndEnd(a.length, fromIndex, toIndex);
        doSort(a, fromIndex, toIndex - 1);
    }

    /**
     * Sorts the specified range of the array into ascending order. This
     * method differs from the public {@code sort} method in that the
     * {@code right} index is inclusive, and it does no range checking
     * on {@code left} or {@code right}.
     *
     * @param a the array to be sorted
     * @param left the index of the first element, inclusive, to be sorted
     * @param right the index of the last element, inclusive, to be sorted
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.363 -0500", hash_original_method = "DE2F13AFC7540F73FF05BA40E9B31AF8", hash_generated_method = "624308ED8D4B36134BA69A0A6AEEEE65")
    
private static void doSort(int[] a, int left, int right) {
        // Use insertion sort on tiny arrays
        if (right - left + 1 < INSERTION_SORT_THRESHOLD) {
            for (int i = left + 1; i <= right; i++) {
                int ai = a[i];
                int j;
                for (j = i - 1; j >= left && ai < a[j]; j--) {
                    a[j + 1] = a[j];
                }
                a[j + 1] = ai;
            }
        } else { // Use Dual-Pivot Quicksort on large arrays
            dualPivotQuicksort(a, left, right);
        }
    }

    /**
     * Sorts the specified range of the array into ascending order by the
     * Dual-Pivot Quicksort algorithm.
     *
     * @param a the array to be sorted
     * @param left the index of the first element, inclusive, to be sorted
     * @param right the index of the last element, inclusive, to be sorted
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.369 -0500", hash_original_method = "7E78CD90ED1E9E863DE97D11ACED21F6", hash_generated_method = "8C48F897F798B01DF3D2D717DB4F52C6")
    
private static void dualPivotQuicksort(int[] a, int left, int right) {
        // Compute indices of five evenly spaced elements
        int sixth = (right - left + 1) / 6;
        int e1 = left  + sixth;
        int e5 = right - sixth;
        int e3 = (left + right) >>> 1; // The midpoint
        int e4 = e3 + sixth;
        int e2 = e3 - sixth;

        // Sort these elements using a 5-element sorting network
        int ae1 = a[e1], ae2 = a[e2], ae3 = a[e3], ae4 = a[e4], ae5 = a[e5];

        if (ae1 > ae2) { int t = ae1; ae1 = ae2; ae2 = t; }
        if (ae4 > ae5) { int t = ae4; ae4 = ae5; ae5 = t; }
        if (ae1 > ae3) { int t = ae1; ae1 = ae3; ae3 = t; }
        if (ae2 > ae3) { int t = ae2; ae2 = ae3; ae3 = t; }
        if (ae1 > ae4) { int t = ae1; ae1 = ae4; ae4 = t; }
        if (ae3 > ae4) { int t = ae3; ae3 = ae4; ae4 = t; }
        if (ae2 > ae5) { int t = ae2; ae2 = ae5; ae5 = t; }
        if (ae2 > ae3) { int t = ae2; ae2 = ae3; ae3 = t; }
        if (ae4 > ae5) { int t = ae4; ae4 = ae5; ae5 = t; }

        a[e1] = ae1; a[e3] = ae3; a[e5] = ae5;

        /*
         * Use the second and fourth of the five sorted elements as pivots.
         * These values are inexpensive approximations of the first and
         * second terciles of the array. Note that pivot1 <= pivot2.
         *
         * The pivots are stored in local variables, and the first and
         * the last of the elements to be sorted are moved to the locations
         * formerly occupied by the pivots. When partitioning is complete,
         * the pivots are swapped back into their final positions, and
         * excluded from subsequent sorting.
         */
        int pivot1 = ae2; a[e2] = a[left];
        int pivot2 = ae4; a[e4] = a[right];

        // Pointers
        int less  = left  + 1; // The index of first element of center part
        int great = right - 1; // The index before first element of right part

        boolean pivotsDiffer = (pivot1 != pivot2);

        if (pivotsDiffer) {
            /*
             * Partitioning:
             *
             *   left part         center part                    right part
             * +------------------------------------------------------------+
             * | < pivot1  |  pivot1 <= && <= pivot2  |    ?    |  > pivot2 |
             * +------------------------------------------------------------+
             *              ^                          ^       ^
             *              |                          |       |
             *             less                        k     great
             *
             * Invariants:
             *
             *              all in (left, less)   < pivot1
             *    pivot1 <= all in [less, k)     <= pivot2
             *              all in (great, right) > pivot2
             *
             * Pointer k is the first index of ?-part
             */
            outer:
            for (int k = less; k <= great; k++) {
                int ak = a[k];
                if (ak < pivot1) { // Move a[k] to left part
                    if (k != less) {
                        a[k] = a[less];
                        a[less] = ak;
                    }
                    less++;
                } else if (ak > pivot2) { // Move a[k] to right part
                    while (a[great] > pivot2) {
                        if (great-- == k) {
                            break outer;
                        }
                    }
                    if (a[great] < pivot1) {
                        a[k] = a[less];
                        a[less++] = a[great];
                        a[great--] = ak;
                    } else { // pivot1 <= a[great] <= pivot2
                        a[k] = a[great];
                        a[great--] = ak;
                    }
                }
            }
        } else { // Pivots are equal
            /*
             * Partition degenerates to the traditional 3-way,
             * or "Dutch National Flag", partition:
             *
             *   left part   center part            right part
             * +----------------------------------------------+
             * |  < pivot  |  == pivot  |    ?    |  > pivot  |
             * +----------------------------------------------+
             *              ^            ^       ^
             *              |            |       |
             *             less          k     great
             *
             * Invariants:
             *
             *   all in (left, less)   < pivot
             *   all in [less, k)     == pivot
             *   all in (great, right) > pivot
             *
             * Pointer k is the first index of ?-part
             */
            for (int k = less; k <= great; k++) {
                int ak = a[k];
                if (ak == pivot1) {
                    continue;
                }
                if (ak < pivot1) { // Move a[k] to left part
                    if (k != less) {
                        a[k] = a[less];
                        a[less] = ak;
                    }
                    less++;
                } else { // (a[k] > pivot1) -  Move a[k] to right part
                    /*
                     * We know that pivot1 == a[e3] == pivot2. Thus, we know
                     * that great will still be >= k when the following loop
                     * terminates, even though we don't test for it explicitly.
                     * In other words, a[e3] acts as a sentinel for great.
                     */
                    while (a[great] > pivot1) {
                        great--;
                    }
                    if (a[great] < pivot1) {
                        a[k] = a[less];
                        a[less++] = a[great];
                        a[great--] = ak;
                    } else { // a[great] == pivot1
                        a[k] = pivot1;
                        a[great--] = ak;
                    }
                }
            }
        }

        // Swap pivots into their final positions
        a[left]  = a[less  - 1]; a[less  - 1] = pivot1;
        a[right] = a[great + 1]; a[great + 1] = pivot2;

        // Sort left and right parts recursively, excluding known pivot values
        doSort(a, left,   less - 2);
        doSort(a, great + 2, right);

        /*
         * If pivot1 == pivot2, all elements from center
         * part are equal and, therefore, already sorted
         */
        if (!pivotsDiffer) {
            return;
        }

        /*
         * If center part is too large (comprises > 2/3 of the array),
         * swap internal pivot values to ends
         */
        if (less < e1 && great > e5) {
            while (a[less] == pivot1) {
                less++;
            }
            while (a[great] == pivot2) {
                great--;
            }

            /*
             * Partitioning:
             *
             *   left part       center part                   right part
             * +----------------------------------------------------------+
             * | == pivot1 |  pivot1 < && < pivot2  |    ?    | == pivot2 |
             * +----------------------------------------------------------+
             *              ^                        ^       ^
             *              |                        |       |
             *             less                      k     great
             *
             * Invariants:
             *
             *              all in (*, less)  == pivot1
             *     pivot1 < all in [less, k)   < pivot2
             *              all in (great, *) == pivot2
             *
             * Pointer k is the first index of ?-part
             */
            outer:
            for (int k = less; k <= great; k++) {
                int ak = a[k];
                if (ak == pivot2) { // Move a[k] to right part
                    while (a[great] == pivot2) {
                        if (great-- == k) {
                            break outer;
                        }
                    }
                    if (a[great] == pivot1) {
                        a[k] = a[less];
                        a[less++] = pivot1;
                    } else { // pivot1 < a[great] < pivot2
                        a[k] = a[great];
                    }
                    a[great--] = pivot2;
                } else if (ak == pivot1) { // Move a[k] to left part
                    a[k] = a[less];
                    a[less++] = pivot1;
                }
            }
        }

        // Sort center part recursively, excluding known pivot values
        doSort(a, less, great);
    }

    /**
     * Sorts the specified array into ascending numerical order.
     *
     * @param a the array to be sorted
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.371 -0500", hash_original_method = "A2AC90B935B0F7A3AA49E791BAFD5249", hash_generated_method = "419F6F98DEC40FCD1FCFEC54581578B9")
    
public static void sort(long[] a) {
        doSort(a, 0, a.length - 1);
    }

    /**
     * Sorts the specified range of the array into ascending order. The range
     * to be sorted extends from the index {@code fromIndex}, inclusive, to
     * the index {@code toIndex}, exclusive. If {@code fromIndex == toIndex},
     * the range to be sorted is empty (and the call is a no-op).
     *
     * @param a the array to be sorted
     * @param fromIndex the index of the first element, inclusive, to be sorted
     * @param toIndex the index of the last element, exclusive, to be sorted
     * @throws IllegalArgumentException if {@code fromIndex > toIndex}
     * @throws ArrayIndexOutOfBoundsException
     *     if {@code fromIndex < 0} or {@code toIndex > a.length}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.375 -0500", hash_original_method = "8F234F269D33940DA94DD5ECEA121022", hash_generated_method = "FDE82B13742D746290A3C22F37F30CAD")
    
public static void sort(long[] a, int fromIndex, int toIndex) {
        Arrays.checkStartAndEnd(a.length, fromIndex, toIndex);
        doSort(a, fromIndex, toIndex - 1);
    }

    /**
     * Sorts the specified range of the array into ascending order. This
     * method differs from the public {@code sort} method in that the
     * {@code right} index is inclusive, and it does no range checking on
     * {@code left} or {@code right}.
     *
     * @param a the array to be sorted
     * @param left the index of the first element, inclusive, to be sorted
     * @param right the index of the last element, inclusive, to be sorted
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.378 -0500", hash_original_method = "57217C9A49FB585063B45B1F237ED223", hash_generated_method = "EBC178C42238810C4AF0C5A5C0490259")
    
private static void doSort(long[] a, int left, int right) {
        // Use insertion sort on tiny arrays
        if (right - left + 1 < INSERTION_SORT_THRESHOLD) {
            for (int i = left + 1; i <= right; i++) {
                long ai = a[i];
                int j;
                for (j = i - 1; j >= left && ai < a[j]; j--) {
                    a[j + 1] = a[j];
                }
                a[j + 1] = ai;
            }
        } else { // Use Dual-Pivot Quicksort on large arrays
            dualPivotQuicksort(a, left, right);
        }
    }

    /**
     * Sorts the specified range of the array into ascending order by the
     * Dual-Pivot Quicksort algorithm.
     *
     * @param a the array to be sorted
     * @param left the index of the first element, inclusive, to be sorted
     * @param right the index of the last element, inclusive, to be sorted
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.383 -0500", hash_original_method = "FB7B04B697C4CD5C2E52C66D10F38E7C", hash_generated_method = "B9BECCC653C69893690A16B8DB132B22")
    
private static void dualPivotQuicksort(long[] a, int left, int right) {
        // Compute indices of five evenly spaced elements
        int sixth = (right - left + 1) / 6;
        int e1 = left  + sixth;
        int e5 = right - sixth;
        int e3 = (left + right) >>> 1; // The midpoint
        int e4 = e3 + sixth;
        int e2 = e3 - sixth;

        // Sort these elements using a 5-element sorting network
        long ae1 = a[e1], ae2 = a[e2], ae3 = a[e3], ae4 = a[e4], ae5 = a[e5];

        if (ae1 > ae2) { long t = ae1; ae1 = ae2; ae2 = t; }
        if (ae4 > ae5) { long t = ae4; ae4 = ae5; ae5 = t; }
        if (ae1 > ae3) { long t = ae1; ae1 = ae3; ae3 = t; }
        if (ae2 > ae3) { long t = ae2; ae2 = ae3; ae3 = t; }
        if (ae1 > ae4) { long t = ae1; ae1 = ae4; ae4 = t; }
        if (ae3 > ae4) { long t = ae3; ae3 = ae4; ae4 = t; }
        if (ae2 > ae5) { long t = ae2; ae2 = ae5; ae5 = t; }
        if (ae2 > ae3) { long t = ae2; ae2 = ae3; ae3 = t; }
        if (ae4 > ae5) { long t = ae4; ae4 = ae5; ae5 = t; }

        a[e1] = ae1; a[e3] = ae3; a[e5] = ae5;

        /*
         * Use the second and fourth of the five sorted elements as pivots.
         * These values are inexpensive approximations of the first and
         * second terciles of the array. Note that pivot1 <= pivot2.
         *
         * The pivots are stored in local variables, and the first and
         * the last of the elements to be sorted are moved to the locations
         * formerly occupied by the pivots. When partitioning is complete,
         * the pivots are swapped back into their final positions, and
         * excluded from subsequent sorting.
         */
        long pivot1 = ae2; a[e2] = a[left];
        long pivot2 = ae4; a[e4] = a[right];

        // Pointers
        int less  = left  + 1; // The index of first element of center part
        int great = right - 1; // The index before first element of right part

        boolean pivotsDiffer = (pivot1 != pivot2);

        if (pivotsDiffer) {
            /*
             * Partitioning:
             *
             *   left part         center part                    right part
             * +------------------------------------------------------------+
             * | < pivot1  |  pivot1 <= && <= pivot2  |    ?    |  > pivot2 |
             * +------------------------------------------------------------+
             *              ^                          ^       ^
             *              |                          |       |
             *             less                        k     great
             *
             * Invariants:
             *
             *              all in (left, less)   < pivot1
             *    pivot1 <= all in [less, k)     <= pivot2
             *              all in (great, right) > pivot2
             *
             * Pointer k is the first index of ?-part
             */
            outer:
            for (int k = less; k <= great; k++) {
                long ak = a[k];
                if (ak < pivot1) { // Move a[k] to left part
                    if (k != less) {
                        a[k] = a[less];
                        a[less] = ak;
                    }
                    less++;
                } else if (ak > pivot2) { // Move a[k] to right part
                    while (a[great] > pivot2) {
                        if (great-- == k) {
                            break outer;
                        }
                    }
                    if (a[great] < pivot1) {
                        a[k] = a[less];
                        a[less++] = a[great];
                        a[great--] = ak;
                    } else { // pivot1 <= a[great] <= pivot2
                        a[k] = a[great];
                        a[great--] = ak;
                    }
                }
            }
        } else { // Pivots are equal
            /*
             * Partition degenerates to the traditional 3-way,
             * or "Dutch National Flag", partition:
             *
             *   left part   center part            right part
             * +----------------------------------------------+
             * |  < pivot  |  == pivot  |    ?    |  > pivot  |
             * +----------------------------------------------+
             *              ^            ^       ^
             *              |            |       |
             *             less          k     great
             *
             * Invariants:
             *
             *   all in (left, less)   < pivot
             *   all in [less, k)     == pivot
             *   all in (great, right) > pivot
             *
             * Pointer k is the first index of ?-part
             */
            for (int k = less; k <= great; k++) {
                long ak = a[k];
                if (ak == pivot1) {
                    continue;
                }
                if (ak < pivot1) { // Move a[k] to left part
                    if (k != less) {
                        a[k] = a[less];
                        a[less] = ak;
                    }
                    less++;
                } else { // (a[k] > pivot1) -  Move a[k] to right part
                    /*
                     * We know that pivot1 == a[e3] == pivot2. Thus, we know
                     * that great will still be >= k when the following loop
                     * terminates, even though we don't test for it explicitly.
                     * In other words, a[e3] acts as a sentinel for great.
                     */
                    while (a[great] > pivot1) {
                        great--;
                    }
                    if (a[great] < pivot1) {
                        a[k] = a[less];
                        a[less++] = a[great];
                        a[great--] = ak;
                    } else { // a[great] == pivot1
                        a[k] = pivot1;
                        a[great--] = ak;
                    }
                }
            }
        }

        // Swap pivots into their final positions
        a[left]  = a[less  - 1]; a[less  - 1] = pivot1;
        a[right] = a[great + 1]; a[great + 1] = pivot2;

        // Sort left and right parts recursively, excluding known pivot values
        doSort(a, left,   less - 2);
        doSort(a, great + 2, right);

        /*
         * If pivot1 == pivot2, all elements from center
         * part are equal and, therefore, already sorted
         */
        if (!pivotsDiffer) {
            return;
        }

        /*
         * If center part is too large (comprises > 2/3 of the array),
         * swap internal pivot values to ends
         */
        if (less < e1 && great > e5) {
            while (a[less] == pivot1) {
                less++;
            }
            while (a[great] == pivot2) {
                great--;
            }

            /*
             * Partitioning:
             *
             *   left part       center part                   right part
             * +----------------------------------------------------------+
             * | == pivot1 |  pivot1 < && < pivot2  |    ?    | == pivot2 |
             * +----------------------------------------------------------+
             *              ^                        ^       ^
             *              |                        |       |
             *             less                      k     great
             *
             * Invariants:
             *
             *              all in (*, less)  == pivot1
             *     pivot1 < all in [less, k)   < pivot2
             *              all in (great, *) == pivot2
             *
             * Pointer k is the first index of ?-part
             */
            outer:
            for (int k = less; k <= great; k++) {
                long ak = a[k];
                if (ak == pivot2) { // Move a[k] to right part
                    while (a[great] == pivot2) {
                        if (great-- == k) {
                            break outer;
                        }
                    }
                    if (a[great] == pivot1) {
                        a[k] = a[less];
                        a[less++] = pivot1;
                    } else { // pivot1 < a[great] < pivot2
                        a[k] = a[great];
                    }
                    a[great--] = pivot2;
                } else if (ak == pivot1) { // Move a[k] to left part
                    a[k] = a[less];
                    a[less++] = pivot1;
                }
            }
        }

        // Sort center part recursively, excluding known pivot values
        doSort(a, less, great);
    }

    /**
     * Sorts the specified array into ascending numerical order.
     *
     * @param a the array to be sorted
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.386 -0500", hash_original_method = "E605CEDD3D735C877CD5828196F893EC", hash_generated_method = "A197A3EA3EA4ED335C81DA684AD7D6F7")
    
public static void sort(short[] a) {
        doSort(a, 0, a.length - 1);
    }

    /**
     * Sorts the specified range of the array into ascending order. The range
     * to be sorted extends from the index {@code fromIndex}, inclusive, to
     * the index {@code toIndex}, exclusive. If {@code fromIndex == toIndex},
     * the range to be sorted is empty (and the call is a no-op).
     *
     * @param a the array to be sorted
     * @param fromIndex the index of the first element, inclusive, to be sorted
     * @param toIndex the index of the last element, exclusive, to be sorted
     * @throws IllegalArgumentException if {@code fromIndex > toIndex}
     * @throws ArrayIndexOutOfBoundsException
     *     if {@code fromIndex < 0} or {@code toIndex > a.length}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.388 -0500", hash_original_method = "565C3405F12FE5668E6BDD038EC3F15F", hash_generated_method = "6E5BAE33A9A48983EAC412627B6F01AC")
    
public static void sort(short[] a, int fromIndex, int toIndex) {
        Arrays.checkStartAndEnd(a.length, fromIndex, toIndex);
        doSort(a, fromIndex, toIndex - 1);
    }

    /**
     * Sorts the specified range of the array into ascending order. This
     * method differs from the public {@code sort} method in that the
     * {@code right} index is inclusive, and it does no range checking on
     * {@code left} or {@code right}.
     *
     * @param a the array to be sorted
     * @param left the index of the first element, inclusive, to be sorted
     * @param right the index of the last element, inclusive, to be sorted
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.395 -0500", hash_original_method = "6AE68DF80A8FE2CB0DCFB68F6A59F77D", hash_generated_method = "571151D5767C0FC3C71BAA18E02C0707")
    
private static void doSort(short[] a, int left, int right) {
        // Use insertion sort on tiny arrays
        if (right - left + 1 < INSERTION_SORT_THRESHOLD) {
            for (int i = left + 1; i <= right; i++) {
                short ai = a[i];
                int j;
                for (j = i - 1; j >= left && ai < a[j]; j--) {
                    a[j + 1] = a[j];
                }
                a[j + 1] = ai;
            }
        } else if (right-left+1 > COUNTING_SORT_THRESHOLD_FOR_SHORT_OR_CHAR) {
            // Use counting sort on huge arrays
            int[] count = new int[NUM_SHORT_VALUES];

            for (int i = left; i <= right; i++) {
                count[a[i] - Short.MIN_VALUE]++;
            }
            for (int i = 0, k = left; i < count.length && k <= right; i++) {
                short value = (short) (i + Short.MIN_VALUE);

                for (int s = count[i]; s > 0; s--) {
                    a[k++] = value;
               }
            }
        } else { // Use Dual-Pivot Quicksort on large arrays
            dualPivotQuicksort(a, left, right);
        }
    }

    /**
     * Sorts the specified range of the array into ascending order by the
     * Dual-Pivot Quicksort algorithm.
     *
     * @param a the array to be sorted
     * @param left the index of the first element, inclusive, to be sorted
     * @param right the index of the last element, inclusive, to be sorted
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.400 -0500", hash_original_method = "C7C89EDE88EEEE9F63E963A5E9C3FEE9", hash_generated_method = "B8B764751BE0250B937971F01AE9FE8D")
    
private static void dualPivotQuicksort(short[] a, int left, int right) {
        // Compute indices of five evenly spaced elements
        int sixth = (right - left + 1) / 6;
        int e1 = left  + sixth;
        int e5 = right - sixth;
        int e3 = (left + right) >>> 1; // The midpoint
        int e4 = e3 + sixth;
        int e2 = e3 - sixth;

        // Sort these elements using a 5-element sorting network
        short ae1 = a[e1], ae2 = a[e2], ae3 = a[e3], ae4 = a[e4], ae5 = a[e5];

        if (ae1 > ae2) { short t = ae1; ae1 = ae2; ae2 = t; }
        if (ae4 > ae5) { short t = ae4; ae4 = ae5; ae5 = t; }
        if (ae1 > ae3) { short t = ae1; ae1 = ae3; ae3 = t; }
        if (ae2 > ae3) { short t = ae2; ae2 = ae3; ae3 = t; }
        if (ae1 > ae4) { short t = ae1; ae1 = ae4; ae4 = t; }
        if (ae3 > ae4) { short t = ae3; ae3 = ae4; ae4 = t; }
        if (ae2 > ae5) { short t = ae2; ae2 = ae5; ae5 = t; }
        if (ae2 > ae3) { short t = ae2; ae2 = ae3; ae3 = t; }
        if (ae4 > ae5) { short t = ae4; ae4 = ae5; ae5 = t; }

        a[e1] = ae1; a[e3] = ae3; a[e5] = ae5;

        /*
         * Use the second and fourth of the five sorted elements as pivots.
         * These values are inexpensive approximations of the first and
         * second terciles of the array. Note that pivot1 <= pivot2.
         *
         * The pivots are stored in local variables, and the first and
         * the last of the elements to be sorted are moved to the locations
         * formerly occupied by the pivots. When partitioning is complete,
         * the pivots are swapped back into their final positions, and
         * excluded from subsequent sorting.
         */
        short pivot1 = ae2; a[e2] = a[left];
        short pivot2 = ae4; a[e4] = a[right];

        // Pointers
        int less  = left  + 1; // The index of first element of center part
        int great = right - 1; // The index before first element of right part

        boolean pivotsDiffer = (pivot1 != pivot2);

        if (pivotsDiffer) {
            /*
             * Partitioning:
             *
             *   left part         center part                    right part
             * +------------------------------------------------------------+
             * | < pivot1  |  pivot1 <= && <= pivot2  |    ?    |  > pivot2 |
             * +------------------------------------------------------------+
             *              ^                          ^       ^
             *              |                          |       |
             *             less                        k     great
             *
             * Invariants:
             *
             *              all in (left, less)   < pivot1
             *    pivot1 <= all in [less, k)     <= pivot2
             *              all in (great, right) > pivot2
             *
             * Pointer k is the first index of ?-part
             */
            outer:
            for (int k = less; k <= great; k++) {
                short ak = a[k];
                if (ak < pivot1) { // Move a[k] to left part
                    if (k != less) {
                        a[k] = a[less];
                        a[less] = ak;
                    }
                    less++;
                } else if (ak > pivot2) { // Move a[k] to right part
                    while (a[great] > pivot2) {
                        if (great-- == k) {
                            break outer;
                        }
                    }
                    if (a[great] < pivot1) {
                        a[k] = a[less];
                        a[less++] = a[great];
                        a[great--] = ak;
                    } else { // pivot1 <= a[great] <= pivot2
                        a[k] = a[great];
                        a[great--] = ak;
                    }
                }
            }
        } else { // Pivots are equal
            /*
             * Partition degenerates to the traditional 3-way,
             * or "Dutch National Flag", partition:
             *
             *   left part   center part            right part
             * +----------------------------------------------+
             * |  < pivot  |  == pivot  |    ?    |  > pivot  |
             * +----------------------------------------------+
             *              ^            ^       ^
             *              |            |       |
             *             less          k     great
             *
             * Invariants:
             *
             *   all in (left, less)   < pivot
             *   all in [less, k)     == pivot
             *   all in (great, right) > pivot
             *
             * Pointer k is the first index of ?-part
             */
            for (int k = less; k <= great; k++) {
                short ak = a[k];
                if (ak == pivot1) {
                    continue;
                }
                if (ak < pivot1) { // Move a[k] to left part
                    if (k != less) {
                        a[k] = a[less];
                        a[less] = ak;
                    }
                    less++;
                } else { // (a[k] > pivot1) -  Move a[k] to right part
                    /*
                     * We know that pivot1 == a[e3] == pivot2. Thus, we know
                     * that great will still be >= k when the following loop
                     * terminates, even though we don't test for it explicitly.
                     * In other words, a[e3] acts as a sentinel for great.
                     */
                    while (a[great] > pivot1) {
                        great--;
                    }
                    if (a[great] < pivot1) {
                        a[k] = a[less];
                        a[less++] = a[great];
                        a[great--] = ak;
                    } else { // a[great] == pivot1
                        a[k] = pivot1;
                        a[great--] = ak;
                    }
                }
            }
        }

        // Swap pivots into their final positions
        a[left]  = a[less  - 1]; a[less  - 1] = pivot1;
        a[right] = a[great + 1]; a[great + 1] = pivot2;

        // Sort left and right parts recursively, excluding known pivot values
        doSort(a, left,   less - 2);
        doSort(a, great + 2, right);

        /*
         * If pivot1 == pivot2, all elements from center
         * part are equal and, therefore, already sorted
         */
        if (!pivotsDiffer) {
            return;
        }

        /*
         * If center part is too large (comprises > 2/3 of the array),
         * swap internal pivot values to ends
         */
        if (less < e1 && great > e5) {
            while (a[less] == pivot1) {
                less++;
            }
            while (a[great] == pivot2) {
                great--;
            }

            /*
             * Partitioning:
             *
             *   left part       center part                   right part
             * +----------------------------------------------------------+
             * | == pivot1 |  pivot1 < && < pivot2  |    ?    | == pivot2 |
             * +----------------------------------------------------------+
             *              ^                        ^       ^
             *              |                        |       |
             *             less                      k     great
             *
             * Invariants:
             *
             *              all in (*, less)  == pivot1
             *     pivot1 < all in [less, k)   < pivot2
             *              all in (great, *) == pivot2
             *
             * Pointer k is the first index of ?-part
             */
            outer:
            for (int k = less; k <= great; k++) {
                short ak = a[k];
                if (ak == pivot2) { // Move a[k] to right part
                    while (a[great] == pivot2) {
                        if (great-- == k) {
                            break outer;
                        }
                    }
                    if (a[great] == pivot1) {
                        a[k] = a[less];
                        a[less++] = pivot1;
                    } else { // pivot1 < a[great] < pivot2
                        a[k] = a[great];
                    }
                    a[great--] = pivot2;
                } else if (ak == pivot1) { // Move a[k] to left part
                    a[k] = a[less];
                    a[less++] = pivot1;
                }
            }
        }

        // Sort center part recursively, excluding known pivot values
        doSort(a, less, great);
    }

    /**
     * Sorts the specified array into ascending numerical order.
     *
     * @param a the array to be sorted
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.403 -0500", hash_original_method = "E19FA42AA082CC163404041188B59FFA", hash_generated_method = "4CEFECF21EB2AF8C2BB7F8E6763AB164")
    
public static void sort(char[] a) {
        doSort(a, 0, a.length - 1);
    }

    /**
     * Sorts the specified range of the array into ascending order. The range
     * to be sorted extends from the index {@code fromIndex}, inclusive, to
     * the index {@code toIndex}, exclusive. If {@code fromIndex == toIndex},
     * the range to be sorted is empty (and the call is a no-op).
     *
     * @param a the array to be sorted
     * @param fromIndex the index of the first element, inclusive, to be sorted
     * @param toIndex the index of the last element, exclusive, to be sorted
     * @throws IllegalArgumentException if {@code fromIndex > toIndex}
     * @throws ArrayIndexOutOfBoundsException
     *     if {@code fromIndex < 0} or {@code toIndex > a.length}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.406 -0500", hash_original_method = "17F1AD79DA39A57DA59F3C59DD2C317C", hash_generated_method = "903C552756F2C661DB70CEBEE5EB2166")
    
public static void sort(char[] a, int fromIndex, int toIndex) {
        Arrays.checkStartAndEnd(a.length, fromIndex, toIndex);
        doSort(a, fromIndex, toIndex - 1);
    }

    /**
     * Sorts the specified range of the array into ascending order. This
     * method differs from the public {@code sort} method in that the
     * {@code right} index is inclusive, and it does no range checking on
     * {@code left} or {@code right}.
     *
     * @param a the array to be sorted
     * @param left the index of the first element, inclusive, to be sorted
     * @param right the index of the last element, inclusive, to be sorted
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.413 -0500", hash_original_method = "909B15FA5BF6E7570D2E31DE88123D65", hash_generated_method = "DA52F21B79453835FE6551667A1B5116")
    
private static void doSort(char[] a, int left, int right) {
        // Use insertion sort on tiny arrays
        if (right - left + 1 < INSERTION_SORT_THRESHOLD) {
            for (int i = left + 1; i <= right; i++) {
                char ai = a[i];
                int j;
                for (j = i - 1; j >= left && ai < a[j]; j--) {
                    a[j + 1] = a[j];
                }
                a[j + 1] = ai;
            }
        } else if (right-left+1 > COUNTING_SORT_THRESHOLD_FOR_SHORT_OR_CHAR) {
            // Use counting sort on huge arrays
            int[] count = new int[NUM_CHAR_VALUES];

            for (int i = left; i <= right; i++) {
                count[a[i]]++;
            }
            for (int i = 0, k = left; i < count.length && k <= right; i++) {
                for (int s = count[i]; s > 0; s--) {
                    a[k++] = (char) i;
               }
            }
        } else { // Use Dual-Pivot Quicksort on large arrays
            dualPivotQuicksort(a, left, right);
        }
    }

    /**
     * Sorts the specified range of the array into ascending order by the
     * Dual-Pivot Quicksort algorithm.
     *
     * @param a the array to be sorted
     * @param left the index of the first element, inclusive, to be sorted
     * @param right the index of the last element, inclusive, to be sorted
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.418 -0500", hash_original_method = "955F0BB80223C58E153B47499A5DD4B3", hash_generated_method = "FDD563AA40ECE31E69BC2E5E22861B16")
    
private static void dualPivotQuicksort(char[] a, int left, int right) {
        // Compute indices of five evenly spaced elements
        int sixth = (right - left + 1) / 6;
        int e1 = left  + sixth;
        int e5 = right - sixth;
        int e3 = (left + right) >>> 1; // The midpoint
        int e4 = e3 + sixth;
        int e2 = e3 - sixth;

        // Sort these elements using a 5-element sorting network
        char ae1 = a[e1], ae2 = a[e2], ae3 = a[e3], ae4 = a[e4], ae5 = a[e5];

        if (ae1 > ae2) { char t = ae1; ae1 = ae2; ae2 = t; }
        if (ae4 > ae5) { char t = ae4; ae4 = ae5; ae5 = t; }
        if (ae1 > ae3) { char t = ae1; ae1 = ae3; ae3 = t; }
        if (ae2 > ae3) { char t = ae2; ae2 = ae3; ae3 = t; }
        if (ae1 > ae4) { char t = ae1; ae1 = ae4; ae4 = t; }
        if (ae3 > ae4) { char t = ae3; ae3 = ae4; ae4 = t; }
        if (ae2 > ae5) { char t = ae2; ae2 = ae5; ae5 = t; }
        if (ae2 > ae3) { char t = ae2; ae2 = ae3; ae3 = t; }
        if (ae4 > ae5) { char t = ae4; ae4 = ae5; ae5 = t; }

        a[e1] = ae1; a[e3] = ae3; a[e5] = ae5;

        /*
         * Use the second and fourth of the five sorted elements as pivots.
         * These values are inexpensive approximations of the first and
         * second terciles of the array. Note that pivot1 <= pivot2.
         *
         * The pivots are stored in local variables, and the first and
         * the last of the elements to be sorted are moved to the locations
         * formerly occupied by the pivots. When partitioning is complete,
         * the pivots are swapped back into their final positions, and
         * excluded from subsequent sorting.
         */
        char pivot1 = ae2; a[e2] = a[left];
        char pivot2 = ae4; a[e4] = a[right];

        // Pointers
        int less  = left  + 1; // The index of first element of center part
        int great = right - 1; // The index before first element of right part

        boolean pivotsDiffer = (pivot1 != pivot2);

        if (pivotsDiffer) {
            /*
             * Partitioning:
             *
             *   left part         center part                    right part
             * +------------------------------------------------------------+
             * | < pivot1  |  pivot1 <= && <= pivot2  |    ?    |  > pivot2 |
             * +------------------------------------------------------------+
             *              ^                          ^       ^
             *              |                          |       |
             *             less                        k     great
             *
             * Invariants:
             *
             *              all in (left, less)   < pivot1
             *    pivot1 <= all in [less, k)     <= pivot2
             *              all in (great, right) > pivot2
             *
             * Pointer k is the first index of ?-part
             */
            outer:
            for (int k = less; k <= great; k++) {
                char ak = a[k];
                if (ak < pivot1) { // Move a[k] to left part
                    if (k != less) {
                        a[k] = a[less];
                        a[less] = ak;
                    }
                    less++;
                } else if (ak > pivot2) { // Move a[k] to right part
                    while (a[great] > pivot2) {
                        if (great-- == k) {
                            break outer;
                        }
                    }
                    if (a[great] < pivot1) {
                        a[k] = a[less];
                        a[less++] = a[great];
                        a[great--] = ak;
                    } else { // pivot1 <= a[great] <= pivot2
                        a[k] = a[great];
                        a[great--] = ak;
                    }
                }
            }
        } else { // Pivots are equal
            /*
             * Partition degenerates to the traditional 3-way,
             * or "Dutch National Flag", partition:
             *
             *   left part   center part            right part
             * +----------------------------------------------+
             * |  < pivot  |  == pivot  |    ?    |  > pivot  |
             * +----------------------------------------------+
             *              ^            ^       ^
             *              |            |       |
             *             less          k     great
             *
             * Invariants:
             *
             *   all in (left, less)   < pivot
             *   all in [less, k)     == pivot
             *   all in (great, right) > pivot
             *
             * Pointer k is the first index of ?-part
             */
            for (int k = less; k <= great; k++) {
                char ak = a[k];
                if (ak == pivot1) {
                    continue;
                }
                if (ak < pivot1) { // Move a[k] to left part
                    if (k != less) {
                        a[k] = a[less];
                        a[less] = ak;
                    }
                    less++;
                } else { // (a[k] > pivot1) -  Move a[k] to right part
                    /*
                     * We know that pivot1 == a[e3] == pivot2. Thus, we know
                     * that great will still be >= k when the following loop
                     * terminates, even though we don't test for it explicitly.
                     * In other words, a[e3] acts as a sentinel for great.
                     */
                    while (a[great] > pivot1) {
                        great--;
                    }
                    if (a[great] < pivot1) {
                        a[k] = a[less];
                        a[less++] = a[great];
                        a[great--] = ak;
                    } else { // a[great] == pivot1
                        a[k] = pivot1;
                        a[great--] = ak;
                    }
                }
            }
        }

        // Swap pivots into their final positions
        a[left]  = a[less  - 1]; a[less  - 1] = pivot1;
        a[right] = a[great + 1]; a[great + 1] = pivot2;

        // Sort left and right parts recursively, excluding known pivot values
        doSort(a, left,   less - 2);
        doSort(a, great + 2, right);

        /*
         * If pivot1 == pivot2, all elements from center
         * part are equal and, therefore, already sorted
         */
        if (!pivotsDiffer) {
            return;
        }

        /*
         * If center part is too large (comprises > 2/3 of the array),
         * swap internal pivot values to ends
         */
        if (less < e1 && great > e5) {
            while (a[less] == pivot1) {
                less++;
            }
            while (a[great] == pivot2) {
                great--;
            }

            /*
             * Partitioning:
             *
             *   left part       center part                   right part
             * +----------------------------------------------------------+
             * | == pivot1 |  pivot1 < && < pivot2  |    ?    | == pivot2 |
             * +----------------------------------------------------------+
             *              ^                        ^       ^
             *              |                        |       |
             *             less                      k     great
             *
             * Invariants:
             *
             *              all in (*, less)  == pivot1
             *     pivot1 < all in [less, k)   < pivot2
             *              all in (great, *) == pivot2
             *
             * Pointer k is the first index of ?-part
             */
            outer:
            for (int k = less; k <= great; k++) {
                char ak = a[k];
                if (ak == pivot2) { // Move a[k] to right part
                    while (a[great] == pivot2) {
                        if (great-- == k) {
                            break outer;
                        }
                    }
                    if (a[great] == pivot1) {
                        a[k] = a[less];
                        a[less++] = pivot1;
                    } else { // pivot1 < a[great] < pivot2
                        a[k] = a[great];
                    }
                    a[great--] = pivot2;
                } else if (ak == pivot1) { // Move a[k] to left part
                    a[k] = a[less];
                    a[less++] = pivot1;
                }
            }
        }

        // Sort center part recursively, excluding known pivot values
        doSort(a, less, great);
    }

    /**
     * Sorts the specified array into ascending numerical order.
     *
     * @param a the array to be sorted
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.421 -0500", hash_original_method = "1BD37EF197753A4C52E1EAD431273D9E", hash_generated_method = "ED1014A56C27D110A8DA40BC92649C61")
    
public static void sort(byte[] a) {
        doSort(a, 0, a.length - 1);
    }

    /**
     * Sorts the specified range of the array into ascending order. The range
     * to be sorted extends from the index {@code fromIndex}, inclusive, to
     * the index {@code toIndex}, exclusive. If {@code fromIndex == toIndex},
     * the range to be sorted is empty (and the call is a no-op).
     *
     * @param a the array to be sorted
     * @param fromIndex the index of the first element, inclusive, to be sorted
     * @param toIndex the index of the last element, exclusive, to be sorted
     * @throws IllegalArgumentException if {@code fromIndex > toIndex}
     * @throws ArrayIndexOutOfBoundsException
     *     if {@code fromIndex < 0} or {@code toIndex > a.length}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.424 -0500", hash_original_method = "4D58317C5C3B34360CFB17CBB78DECCA", hash_generated_method = "08BDFEA743182B07EEE27D8DAA7824DD")
    
public static void sort(byte[] a, int fromIndex, int toIndex) {
        Arrays.checkStartAndEnd(a.length, fromIndex, toIndex);
        doSort(a, fromIndex, toIndex - 1);
    }

    /**
     * Sorts the specified range of the array into ascending order. This
     * method differs from the public {@code sort} method in that the
     * {@code right} index is inclusive, and it does no range checking on
     * {@code left} or {@code right}.
     *
     * @param a the array to be sorted
     * @param left the index of the first element, inclusive, to be sorted
     * @param right the index of the last element, inclusive, to be sorted
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.430 -0500", hash_original_method = "A1C3CF7FD1EE08825F2123508F5A4D77", hash_generated_method = "B3BEDF731DCA92AE219DA076178656D5")
    
private static void doSort(byte[] a, int left, int right) {
        // Use insertion sort on tiny arrays
        if (right - left + 1 < INSERTION_SORT_THRESHOLD) {
            for (int i = left + 1; i <= right; i++) {
                byte ai = a[i];
                int j;
                for (j = i - 1; j >= left && ai < a[j]; j--) {
                    a[j + 1] = a[j];
                }
                a[j + 1] = ai;
            }
        } else if (right - left + 1 > COUNTING_SORT_THRESHOLD_FOR_BYTE) {
            // Use counting sort on huge arrays
            int[] count = new int[NUM_BYTE_VALUES];

            for (int i = left; i <= right; i++) {
                count[a[i] - Byte.MIN_VALUE]++;
            }
            for (int i = 0, k = left; i < count.length && k <= right; i++) {
                byte value = (byte) (i + Byte.MIN_VALUE);

                for (int s = count[i]; s > 0; s--) {
                    a[k++] = value;
               }
            }
        } else { // Use Dual-Pivot Quicksort on large arrays
            dualPivotQuicksort(a, left, right);
        }
    }

    /**
     * Sorts the specified range of the array into ascending order by the
     * Dual-Pivot Quicksort algorithm.
     *
     * @param a the array to be sorted
     * @param left the index of the first element, inclusive, to be sorted
     * @param right the index of the last element, inclusive, to be sorted
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.436 -0500", hash_original_method = "385DB8898AF9AC13D75FFFA3464F288D", hash_generated_method = "57E81833D69AF69EB95FF82F92A7308E")
    
private static void dualPivotQuicksort(byte[] a, int left, int right) {
        // Compute indices of five evenly spaced elements
        int sixth = (right - left + 1) / 6;
        int e1 = left  + sixth;
        int e5 = right - sixth;
        int e3 = (left + right) >>> 1; // The midpoint
        int e4 = e3 + sixth;
        int e2 = e3 - sixth;

        // Sort these elements using a 5-element sorting network
        byte ae1 = a[e1], ae2 = a[e2], ae3 = a[e3], ae4 = a[e4], ae5 = a[e5];

        if (ae1 > ae2) { byte t = ae1; ae1 = ae2; ae2 = t; }
        if (ae4 > ae5) { byte t = ae4; ae4 = ae5; ae5 = t; }
        if (ae1 > ae3) { byte t = ae1; ae1 = ae3; ae3 = t; }
        if (ae2 > ae3) { byte t = ae2; ae2 = ae3; ae3 = t; }
        if (ae1 > ae4) { byte t = ae1; ae1 = ae4; ae4 = t; }
        if (ae3 > ae4) { byte t = ae3; ae3 = ae4; ae4 = t; }
        if (ae2 > ae5) { byte t = ae2; ae2 = ae5; ae5 = t; }
        if (ae2 > ae3) { byte t = ae2; ae2 = ae3; ae3 = t; }
        if (ae4 > ae5) { byte t = ae4; ae4 = ae5; ae5 = t; }

        a[e1] = ae1; a[e3] = ae3; a[e5] = ae5;

        /*
         * Use the second and fourth of the five sorted elements as pivots.
         * These values are inexpensive approximations of the first and
         * second terciles of the array. Note that pivot1 <= pivot2.
         *
         * The pivots are stored in local variables, and the first and
         * the last of the elements to be sorted are moved to the locations
         * formerly occupied by the pivots. When partitioning is complete,
         * the pivots are swapped back into their final positions, and
         * excluded from subsequent sorting.
         */
        byte pivot1 = ae2; a[e2] = a[left];
        byte pivot2 = ae4; a[e4] = a[right];

        // Pointers
        int less  = left  + 1; // The index of first element of center part
        int great = right - 1; // The index before first element of right part

        boolean pivotsDiffer = (pivot1 != pivot2);

        if (pivotsDiffer) {
            /*
             * Partitioning:
             *
             *   left part         center part                    right part
             * +------------------------------------------------------------+
             * | < pivot1  |  pivot1 <= && <= pivot2  |    ?    |  > pivot2 |
             * +------------------------------------------------------------+
             *              ^                          ^       ^
             *              |                          |       |
             *             less                        k     great
             *
             * Invariants:
             *
             *              all in (left, less)   < pivot1
             *    pivot1 <= all in [less, k)     <= pivot2
             *              all in (great, right) > pivot2
             *
             * Pointer k is the first index of ?-part
             */
            outer:
            for (int k = less; k <= great; k++) {
                byte ak = a[k];
                if (ak < pivot1) { // Move a[k] to left part
                    if (k != less) {
                        a[k] = a[less];
                        a[less] = ak;
                    }
                    less++;
                } else if (ak > pivot2) { // Move a[k] to right part
                    while (a[great] > pivot2) {
                        if (great-- == k) {
                            break outer;
                        }
                    }
                    if (a[great] < pivot1) {
                        a[k] = a[less];
                        a[less++] = a[great];
                        a[great--] = ak;
                    } else { // pivot1 <= a[great] <= pivot2
                        a[k] = a[great];
                        a[great--] = ak;
                    }
                }
            }
        } else { // Pivots are equal
            /*
             * Partition degenerates to the traditional 3-way,
             * or "Dutch National Flag", partition:
             *
             *   left part   center part            right part
             * +----------------------------------------------+
             * |  < pivot  |  == pivot  |    ?    |  > pivot  |
             * +----------------------------------------------+
             *              ^            ^       ^
             *              |            |       |
             *             less          k     great
             *
             * Invariants:
             *
             *   all in (left, less)   < pivot
             *   all in [less, k)     == pivot
             *   all in (great, right) > pivot
             *
             * Pointer k is the first index of ?-part
             */
            for (int k = less; k <= great; k++) {
                byte ak = a[k];
                if (ak == pivot1) {
                    continue;
                }
                if (ak < pivot1) { // Move a[k] to left part
                    if (k != less) {
                        a[k] = a[less];
                        a[less] = ak;
                    }
                    less++;
                } else { // (a[k] > pivot1) -  Move a[k] to right part
                    /*
                     * We know that pivot1 == a[e3] == pivot2. Thus, we know
                     * that great will still be >= k when the following loop
                     * terminates, even though we don't test for it explicitly.
                     * In other words, a[e3] acts as a sentinel for great.
                     */
                    while (a[great] > pivot1) {
                        great--;
                    }
                    if (a[great] < pivot1) {
                        a[k] = a[less];
                        a[less++] = a[great];
                        a[great--] = ak;
                    } else { // a[great] == pivot1
                        a[k] = pivot1;
                        a[great--] = ak;
                    }
                }
            }
        }

        // Swap pivots into their final positions
        a[left]  = a[less  - 1]; a[less  - 1] = pivot1;
        a[right] = a[great + 1]; a[great + 1] = pivot2;

        // Sort left and right parts recursively, excluding known pivot values
        doSort(a, left,   less - 2);
        doSort(a, great + 2, right);

        /*
         * If pivot1 == pivot2, all elements from center
         * part are equal and, therefore, already sorted
         */
        if (!pivotsDiffer) {
            return;
        }

        /*
         * If center part is too large (comprises > 2/3 of the array),
         * swap internal pivot values to ends
         */
        if (less < e1 && great > e5) {
            while (a[less] == pivot1) {
                less++;
            }
            while (a[great] == pivot2) {
                great--;
            }

            /*
             * Partitioning:
             *
             *   left part       center part                   right part
             * +----------------------------------------------------------+
             * | == pivot1 |  pivot1 < && < pivot2  |    ?    | == pivot2 |
             * +----------------------------------------------------------+
             *              ^                        ^       ^
             *              |                        |       |
             *             less                      k     great
             *
             * Invariants:
             *
             *              all in (*, less)  == pivot1
             *     pivot1 < all in [less, k)   < pivot2
             *              all in (great, *) == pivot2
             *
             * Pointer k is the first index of ?-part
             */
            outer:
            for (int k = less; k <= great; k++) {
                byte ak = a[k];
                if (ak == pivot2) { // Move a[k] to right part
                    while (a[great] == pivot2) {
                        if (great-- == k) {
                            break outer;
                        }
                    }
                    if (a[great] == pivot1) {
                        a[k] = a[less];
                        a[less++] = pivot1;
                    } else { // pivot1 < a[great] < pivot2
                        a[k] = a[great];
                    }
                    a[great--] = pivot2;
                } else if (ak == pivot1) { // Move a[k] to left part
                    a[k] = a[less];
                    a[less++] = pivot1;
                }
            }
        }

        // Sort center part recursively, excluding known pivot values
        doSort(a, less, great);
    }

    /**
     * Sorts the specified array into ascending numerical order.
     *
     * <p>The {@code <} relation does not provide a total order on all float
     * values: {@code -0.0f == 0.0f} is {@code true} and a {@code Float.NaN}
     * value compares neither less than, greater than, nor equal to any value,
     * even itself. This method uses the total order imposed by the method
     * {@link Float#compareTo}: {@code -0.0f} is treated as less than value
     * {@code 0.0f} and {@code Float.NaN} is considered greater than any
     * other value and all {@code Float.NaN} values are considered equal.
     *
     * @param a the array to be sorted
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.438 -0500", hash_original_method = "A3D557943E8348E3BCEFBC8A62E2FCD4", hash_generated_method = "1DB19A7182A7E44148C870D50634551A")
    
public static void sort(float[] a) {
        sortNegZeroAndNaN(a, 0, a.length - 1);
    }

    /**
     * Sorts the specified range of the array into ascending order. The range
     * to be sorted extends from the index {@code fromIndex}, inclusive, to
     * the index {@code toIndex}, exclusive. If {@code fromIndex == toIndex},
     * the range to be sorted is empty  and the call is a no-op).
     *
     * <p>The {@code <} relation does not provide a total order on all float
     * values: {@code -0.0f == 0.0f} is {@code true} and a {@code Float.NaN}
     * value compares neither less than, greater than, nor equal to any value,
     * even itself. This method uses the total order imposed by the method
     * {@link Float#compareTo}: {@code -0.0f} is treated as less than value
     * {@code 0.0f} and {@code Float.NaN} is considered greater than any
     * other value and all {@code Float.NaN} values are considered equal.
     *
     * @param a the array to be sorted
     * @param fromIndex the index of the first element, inclusive, to be sorted
     * @param toIndex the index of the last element, exclusive, to be sorted
     * @throws IllegalArgumentException if {@code fromIndex > toIndex}
     * @throws ArrayIndexOutOfBoundsException
     *     if {@code fromIndex < 0} or {@code toIndex > a.length}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.441 -0500", hash_original_method = "B6BF98C7E8A52686AE779050AF7E2F0E", hash_generated_method = "720FA50148E48C2E06AFE6C1D8F309C1")
    
public static void sort(float[] a, int fromIndex, int toIndex) {
        Arrays.checkStartAndEnd(a.length, fromIndex, toIndex);
        sortNegZeroAndNaN(a, fromIndex, toIndex - 1);
    }

    /**
     * Sorts the specified range of the array into ascending order. The
     * sort is done in three phases to avoid expensive comparisons in the
     * inner loop. The comparisons would be expensive due to anomalies
     * associated with negative zero {@code -0.0f} and {@code Float.NaN}.
     *
     * @param a the array to be sorted
     * @param left the index of the first element, inclusive, to be sorted
     * @param right the index of the last element, inclusive, to be sorted
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.444 -0500", hash_original_method = "08E74107BBE5A1309F25A73146E73583", hash_generated_method = "A2BB16061B6FD08D6C44AACDF4AA6D2C")
    
private static void sortNegZeroAndNaN(float[] a, int left, int right) {
        /*
         * Phase 1: Count negative zeros and move NaNs to end of array
         */
        final int NEGATIVE_ZERO = Float.floatToIntBits(-0.0f);
        int numNegativeZeros = 0;
        int n = right;

        for (int k = left; k <= n; k++) {
            float ak = a[k];
            if (ak == 0.0f && NEGATIVE_ZERO == Float.floatToIntBits(ak)) {
                a[k] = 0.0f;
                numNegativeZeros++;
            } else if (ak != ak) { // i.e., ak is NaN
                a[k--] = a[n];
                a[n--] = Float.NaN;
            }
        }

        /*
         * Phase 2: Sort everything except NaNs (which are already in place)
         */
        doSort(a, left, n);

        /*
         * Phase 3: Turn positive zeros back into negative zeros as appropriate
         */
        if (numNegativeZeros == 0) {
            return;
        }

        // Find first zero element
        int zeroIndex = findAnyZero(a, left, n);

        for (int i = zeroIndex - 1; i >= left && a[i] == 0.0f; i--) {
            zeroIndex = i;
        }

        // Turn the right number of positive zeros back into negative zeros
        for (int i = zeroIndex, m = zeroIndex + numNegativeZeros; i < m; i++) {
            a[i] = -0.0f;
        }
    }

    /**
     * Returns the index of some zero element in the specified range via
     * binary search. The range is assumed to be sorted, and must contain
     * at least one zero.
     *
     * @param a the array to be searched
     * @param low the index of the first element, inclusive, to be searched
     * @param high the index of the last element, inclusive, to be searched
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.448 -0500", hash_original_method = "4B96477BBB4E18CCF7F5B12A49CDFC2A", hash_generated_method = "BC8C3B5543D293ACEC988CEA8B3F1359")
    
private static int findAnyZero(float[] a, int low, int high) {
        while (true) {
            int middle = (low + high) >>> 1;
            float middleValue = a[middle];

            if (middleValue < 0.0f) {
                low = middle + 1;
            } else if (middleValue > 0.0f) {
                high = middle - 1;
            } else { // middleValue == 0.0f
                return middle;
            }
        }
    }

    /**
     * Sorts the specified range of the array into ascending order. This
     * method differs from the public {@code sort} method in three ways:
     * {@code right} index is inclusive, it does no range checking on
     * {@code left} or {@code right}, and it does not handle negative
     * zeros or NaNs in the array.
     *
     * @param a the array to be sorted, which must not contain -0.0f or NaN
     * @param left the index of the first element, inclusive, to be sorted
     * @param right the index of the last element, inclusive, to be sorted
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.451 -0500", hash_original_method = "8B9253591CB3778BA3235DBD1965402C", hash_generated_method = "7E7B7653D9006713B36B4C18A0C52E31")
    
private static void doSort(float[] a, int left, int right) {
        // Use insertion sort on tiny arrays
        if (right - left + 1 < INSERTION_SORT_THRESHOLD) {
            for (int i = left + 1; i <= right; i++) {
                float ai = a[i];
                int j;
                for (j = i - 1; j >= left && ai < a[j]; j--) {
                    a[j + 1] = a[j];
                }
                a[j + 1] = ai;
            }
        } else { // Use Dual-Pivot Quicksort on large arrays
            dualPivotQuicksort(a, left, right);
        }
    }

    /**
     * Sorts the specified range of the array into ascending order by the
     * Dual-Pivot Quicksort algorithm.
     *
     * @param a the array to be sorted
     * @param left the index of the first element, inclusive, to be sorted
     * @param right the index of the last element, inclusive, to be sorted
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.457 -0500", hash_original_method = "87F4CF9B4558729C608B779F834C4D2A", hash_generated_method = "C11DC780A9FA5D5DD147BBB9BA9688DC")
    
private static void dualPivotQuicksort(float[] a, int left, int right) {
        // Compute indices of five evenly spaced elements
        int sixth = (right - left + 1) / 6;
        int e1 = left  + sixth;
        int e5 = right - sixth;
        int e3 = (left + right) >>> 1; // The midpoint
        int e4 = e3 + sixth;
        int e2 = e3 - sixth;

        // Sort these elements using a 5-element sorting network
        float ae1 = a[e1], ae2 = a[e2], ae3 = a[e3], ae4 = a[e4], ae5 = a[e5];

        if (ae1 > ae2) { float t = ae1; ae1 = ae2; ae2 = t; }
        if (ae4 > ae5) { float t = ae4; ae4 = ae5; ae5 = t; }
        if (ae1 > ae3) { float t = ae1; ae1 = ae3; ae3 = t; }
        if (ae2 > ae3) { float t = ae2; ae2 = ae3; ae3 = t; }
        if (ae1 > ae4) { float t = ae1; ae1 = ae4; ae4 = t; }
        if (ae3 > ae4) { float t = ae3; ae3 = ae4; ae4 = t; }
        if (ae2 > ae5) { float t = ae2; ae2 = ae5; ae5 = t; }
        if (ae2 > ae3) { float t = ae2; ae2 = ae3; ae3 = t; }
        if (ae4 > ae5) { float t = ae4; ae4 = ae5; ae5 = t; }

        a[e1] = ae1; a[e3] = ae3; a[e5] = ae5;

        /*
         * Use the second and fourth of the five sorted elements as pivots.
         * These values are inexpensive approximations of the first and
         * second terciles of the array. Note that pivot1 <= pivot2.
         *
         * The pivots are stored in local variables, and the first and
         * the last of the elements to be sorted are moved to the locations
         * formerly occupied by the pivots. When partitioning is complete,
         * the pivots are swapped back into their final positions, and
         * excluded from subsequent sorting.
         */
        float pivot1 = ae2; a[e2] = a[left];
        float pivot2 = ae4; a[e4] = a[right];

        // Pointers
        int less  = left  + 1; // The index of first element of center part
        int great = right - 1; // The index before first element of right part

        boolean pivotsDiffer = (pivot1 != pivot2);

        if (pivotsDiffer) {
            /*
             * Partitioning:
             *
             *   left part         center part                    right part
             * +------------------------------------------------------------+
             * | < pivot1  |  pivot1 <= && <= pivot2  |    ?    |  > pivot2 |
             * +------------------------------------------------------------+
             *              ^                          ^       ^
             *              |                          |       |
             *             less                        k     great
             *
             * Invariants:
             *
             *              all in (left, less)   < pivot1
             *    pivot1 <= all in [less, k)     <= pivot2
             *              all in (great, right) > pivot2
             *
             * Pointer k is the first index of ?-part
             */
            outer:
            for (int k = less; k <= great; k++) {
                float ak = a[k];
                if (ak < pivot1) { // Move a[k] to left part
                    if (k != less) {
                        a[k] = a[less];
                        a[less] = ak;
                    }
                    less++;
                } else if (ak > pivot2) { // Move a[k] to right part
                    while (a[great] > pivot2) {
                        if (great-- == k) {
                            break outer;
                        }
                    }
                    if (a[great] < pivot1) {
                        a[k] = a[less];
                        a[less++] = a[great];
                        a[great--] = ak;
                    } else { // pivot1 <= a[great] <= pivot2
                        a[k] = a[great];
                        a[great--] = ak;
                    }
                }
            }
        } else { // Pivots are equal
            /*
             * Partition degenerates to the traditional 3-way,
             * or "Dutch National Flag", partition:
             *
             *   left part   center part            right part
             * +----------------------------------------------+
             * |  < pivot  |  == pivot  |    ?    |  > pivot  |
             * +----------------------------------------------+
             *              ^            ^       ^
             *              |            |       |
             *             less          k     great
             *
             * Invariants:
             *
             *   all in (left, less)   < pivot
             *   all in [less, k)     == pivot
             *   all in (great, right) > pivot
             *
             * Pointer k is the first index of ?-part
             */
            for (int k = less; k <= great; k++) {
                float ak = a[k];
                if (ak == pivot1) {
                    continue;
                }
                if (ak < pivot1) { // Move a[k] to left part
                    if (k != less) {
                        a[k] = a[less];
                        a[less] = ak;
                    }
                    less++;
                } else { // (a[k] > pivot1) -  Move a[k] to right part
                    /*
                     * We know that pivot1 == a[e3] == pivot2. Thus, we know
                     * that great will still be >= k when the following loop
                     * terminates, even though we don't test for it explicitly.
                     * In other words, a[e3] acts as a sentinel for great.
                     */
                    while (a[great] > pivot1) {
                        great--;
                    }
                    if (a[great] < pivot1) {
                        a[k] = a[less];
                        a[less++] = a[great];
                        a[great--] = ak;
                    } else { // a[great] == pivot1
                        a[k] = pivot1;
                        a[great--] = ak;
                    }
                }
            }
        }

        // Swap pivots into their final positions
        a[left]  = a[less  - 1]; a[less  - 1] = pivot1;
        a[right] = a[great + 1]; a[great + 1] = pivot2;

        // Sort left and right parts recursively, excluding known pivot values
        doSort(a, left,   less - 2);
        doSort(a, great + 2, right);

        /*
         * If pivot1 == pivot2, all elements from center
         * part are equal and, therefore, already sorted
         */
        if (!pivotsDiffer) {
            return;
        }

        /*
         * If center part is too large (comprises > 2/3 of the array),
         * swap internal pivot values to ends
         */
        if (less < e1 && great > e5) {
            while (a[less] == pivot1) {
                less++;
            }
            while (a[great] == pivot2) {
                great--;
            }

            /*
             * Partitioning:
             *
             *   left part       center part                   right part
             * +----------------------------------------------------------+
             * | == pivot1 |  pivot1 < && < pivot2  |    ?    | == pivot2 |
             * +----------------------------------------------------------+
             *              ^                        ^       ^
             *              |                        |       |
             *             less                      k     great
             *
             * Invariants:
             *
             *              all in (*, less)  == pivot1
             *     pivot1 < all in [less, k)   < pivot2
             *              all in (great, *) == pivot2
             *
             * Pointer k is the first index of ?-part
             */
            outer:
            for (int k = less; k <= great; k++) {
                float ak = a[k];
                if (ak == pivot2) { // Move a[k] to right part
                    while (a[great] == pivot2) {
                        if (great-- == k) {
                            break outer;
                        }
                    }
                    if (a[great] == pivot1) {
                        a[k] = a[less];
                        a[less++] = pivot1;
                    } else { // pivot1 < a[great] < pivot2
                        a[k] = a[great];
                    }
                    a[great--] = pivot2;
                } else if (ak == pivot1) { // Move a[k] to left part
                    a[k] = a[less];
                    a[less++] = pivot1;
                }
            }
        }

        // Sort center part recursively, excluding known pivot values
        doSort(a, less, great);
    }

    /**
     * Sorts the specified array into ascending numerical order.
     *
     * <p>The {@code <} relation does not provide a total order on all double
     * values: {@code -0.0d == 0.0d} is {@code true} and a {@code Double.NaN}
     * value compares neither less than, greater than, nor equal to any value,
     * even itself. This method uses the total order imposed by the method
     * {@link Double#compareTo}: {@code -0.0d} is treated as less than value
     * {@code 0.0d} and {@code Double.NaN} is considered greater than any
     * other value and all {@code Double.NaN} values are considered equal.
     *
     * @param a the array to be sorted
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.460 -0500", hash_original_method = "8F278FEA5C9ECC20001FE85FA8D54AEE", hash_generated_method = "73D73D496C95B4ACCCBC25BB73241B94")
    
public static void sort(double[] a) {
        sortNegZeroAndNaN(a, 0, a.length - 1);
    }

    /**
     * Sorts the specified range of the array into ascending order. The range
     * to be sorted extends from the index {@code fromIndex}, inclusive, to
     * the index {@code toIndex}, exclusive. If {@code fromIndex == toIndex},
     * the range to be sorted is empty (and the call is a no-op).
     *
     * <p>The {@code <} relation does not provide a total order on all double
     * values: {@code -0.0d == 0.0d} is {@code true} and a {@code Double.NaN}
     * value compares neither less than, greater than, nor equal to any value,
     * even itself. This method uses the total order imposed by the method
     * {@link Double#compareTo}: {@code -0.0d} is treated as less than value
     * {@code 0.0d} and {@code Double.NaN} is considered greater than any
     * other value and all {@code Double.NaN} values are considered equal.
     *
     * @param a the array to be sorted
     * @param fromIndex the index of the first element, inclusive, to be sorted
     * @param toIndex the index of the last element, exclusive, to be sorted
     * @throws IllegalArgumentException if {@code fromIndex > toIndex}
     * @throws ArrayIndexOutOfBoundsException
     *     if {@code fromIndex < 0} or {@code toIndex > a.length}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.463 -0500", hash_original_method = "D6E41A8E529CCB76613ADD41E816838F", hash_generated_method = "DFDD4639E22D06F8A28D1A93D8CD53A1")
    
public static void sort(double[] a, int fromIndex, int toIndex) {
        Arrays.checkStartAndEnd(a.length, fromIndex, toIndex);
        sortNegZeroAndNaN(a, fromIndex, toIndex - 1);
    }

    /**
     * Sorts the specified range of the array into ascending order. The
     * sort is done in three phases to avoid expensive comparisons in the
     * inner loop. The comparisons would be expensive due to anomalies
     * associated with negative zero {@code -0.0d} and {@code Double.NaN}.
     *
     * @param a the array to be sorted
     * @param left the index of the first element, inclusive, to be sorted
     * @param right the index of the last element, inclusive, to be sorted
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.466 -0500", hash_original_method = "A36ED475DD13515BBDA234F6686CB7DD", hash_generated_method = "F5D54E52EA3A4E6A0F3922B994C6BD95")
    
private static void sortNegZeroAndNaN(double[] a, int left, int right) {
        /*
         * Phase 1: Count negative zeros and move NaNs to end of array
         */
        final long NEGATIVE_ZERO = Double.doubleToLongBits(-0.0d);
        int numNegativeZeros = 0;
        int n = right;

        for (int k = left; k <= n; k++) {
            double ak = a[k];
            if (ak == 0.0d && NEGATIVE_ZERO == Double.doubleToLongBits(ak)) {
                a[k] = 0.0d;
                numNegativeZeros++;
            } else if (ak != ak) { // i.e., ak is NaN
                a[k--] = a[n];
                a[n--] = Double.NaN;
            }
        }

        /*
         * Phase 2: Sort everything except NaNs (which are already in place)
         */
        doSort(a, left, n);

        /*
         * Phase 3: Turn positive zeros back into negative zeros as appropriate
         */
        if (numNegativeZeros == 0) {
            return;
        }

        // Find first zero element
        int zeroIndex = findAnyZero(a, left, n);

        for (int i = zeroIndex - 1; i >= left && a[i] == 0.0d; i--) {
            zeroIndex = i;
        }

        // Turn the right number of positive zeros back into negative zeros
        for (int i = zeroIndex, m = zeroIndex + numNegativeZeros; i < m; i++) {
            a[i] = -0.0d;
        }
    }

    /**
     * Returns the index of some zero element in the specified range via
     * binary search. The range is assumed to be sorted, and must contain
     * at least one zero.
     *
     * @param a the array to be searched
     * @param low the index of the first element, inclusive, to be searched
     * @param high the index of the last element, inclusive, to be searched
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.469 -0500", hash_original_method = "586B8F3F36F41AEEA37D2D7C84643BDD", hash_generated_method = "86E2CB6863C9F186FD4556610E97B0D6")
    
private static int findAnyZero(double[] a, int low, int high) {
        while (true) {
            int middle = (low + high) >>> 1;
            double middleValue = a[middle];

            if (middleValue < 0.0d) {
                low = middle + 1;
            } else if (middleValue > 0.0d) {
                high = middle - 1;
            } else { // middleValue == 0.0d
                return middle;
            }
        }
    }

    /**
     * Sorts the specified range of the array into ascending order. This
     * method differs from the public {@code sort} method in three ways:
     * {@code right} index is inclusive, it does no range checking on
     * {@code left} or {@code right}, and it does not handle negative
     * zeros or NaNs in the array.
     *
     * @param a the array to be sorted, which must not contain -0.0d and NaN
     * @param left the index of the first element, inclusive, to be sorted
     * @param right the index of the last element, inclusive, to be sorted
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.472 -0500", hash_original_method = "A69F91768E9AEC9D49249CE97937E948", hash_generated_method = "6B2B6592134553BD7A946B6816052A9C")
    
private static void doSort(double[] a, int left, int right) {
        // Use insertion sort on tiny arrays
        if (right - left + 1 < INSERTION_SORT_THRESHOLD) {
            for (int i = left + 1; i <= right; i++) {
                double ai = a[i];
                int j;
                for (j = i - 1; j >= left && ai < a[j]; j--) {
                    a[j + 1] = a[j];
                }
                a[j + 1] = ai;
            }
        } else { // Use Dual-Pivot Quicksort on large arrays
            dualPivotQuicksort(a, left, right);
        }
    }

    /**
     * Sorts the specified range of the array into ascending order by the
     * Dual-Pivot Quicksort algorithm.
     *
     * @param a the array to be sorted
     * @param left the index of the first element, inclusive, to be sorted
     * @param right the index of the last element, inclusive, to be sorted
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.477 -0500", hash_original_method = "2098CB9502FC347E6CEF0B39981B1FB6", hash_generated_method = "F5FCAF9BD5CA5DB34A9139FFD115ABDC")
    
private static void dualPivotQuicksort(double[] a, int left, int right) {
        // Compute indices of five evenly spaced elements
        int sixth = (right - left + 1) / 6;
        int e1 = left  + sixth;
        int e5 = right - sixth;
        int e3 = (left + right) >>> 1; // The midpoint
        int e4 = e3 + sixth;
        int e2 = e3 - sixth;

        // Sort these elements using a 5-element sorting network
        double ae1 = a[e1], ae2 = a[e2], ae3 = a[e3], ae4 = a[e4], ae5 = a[e5];

        if (ae1 > ae2) { double t = ae1; ae1 = ae2; ae2 = t; }
        if (ae4 > ae5) { double t = ae4; ae4 = ae5; ae5 = t; }
        if (ae1 > ae3) { double t = ae1; ae1 = ae3; ae3 = t; }
        if (ae2 > ae3) { double t = ae2; ae2 = ae3; ae3 = t; }
        if (ae1 > ae4) { double t = ae1; ae1 = ae4; ae4 = t; }
        if (ae3 > ae4) { double t = ae3; ae3 = ae4; ae4 = t; }
        if (ae2 > ae5) { double t = ae2; ae2 = ae5; ae5 = t; }
        if (ae2 > ae3) { double t = ae2; ae2 = ae3; ae3 = t; }
        if (ae4 > ae5) { double t = ae4; ae4 = ae5; ae5 = t; }

        a[e1] = ae1; a[e3] = ae3; a[e5] = ae5;

        /*
         * Use the second and fourth of the five sorted elements as pivots.
         * These values are inexpensive approximations of the first and
         * second terciles of the array. Note that pivot1 <= pivot2.
         *
         * The pivots are stored in local variables, and the first and
         * the last of the elements to be sorted are moved to the locations
         * formerly occupied by the pivots. When partitioning is complete,
         * the pivots are swapped back into their final positions, and
         * excluded from subsequent sorting.
         */
        double pivot1 = ae2; a[e2] = a[left];
        double pivot2 = ae4; a[e4] = a[right];

        // Pointers
        int less  = left  + 1; // The index of first element of center part
        int great = right - 1; // The index before first element of right part

        boolean pivotsDiffer = (pivot1 != pivot2);

        if (pivotsDiffer) {
            /*
             * Partitioning:
             *
             *   left part         center part                    right part
             * +------------------------------------------------------------+
             * | < pivot1  |  pivot1 <= && <= pivot2  |    ?    |  > pivot2 |
             * +------------------------------------------------------------+
             *              ^                          ^       ^
             *              |                          |       |
             *             less                        k     great
             *
             * Invariants:
             *
             *              all in (left, less)   < pivot1
             *    pivot1 <= all in [less, k)     <= pivot2
             *              all in (great, right) > pivot2
             *
             * Pointer k is the first index of ?-part
             */
            outer:
            for (int k = less; k <= great; k++) {
                double ak = a[k];
                if (ak < pivot1) { // Move a[k] to left part
                    if (k != less) {
                        a[k] = a[less];
                        a[less] = ak;
                    }
                    less++;
                } else if (ak > pivot2) { // Move a[k] to right part
                    while (a[great] > pivot2) {
                        if (great-- == k) {
                            break outer;
                        }
                    }
                    if (a[great] < pivot1) {
                        a[k] = a[less];
                        a[less++] = a[great];
                        a[great--] = ak;
                    } else { // pivot1 <= a[great] <= pivot2
                        a[k] = a[great];
                        a[great--] = ak;
                    }
                }
            }
        } else { // Pivots are equal
            /*
             * Partition degenerates to the traditional 3-way,
             * or "Dutch National Flag", partition:
             *
             *   left part   center part            right part
             * +----------------------------------------------+
             * |  < pivot  |  == pivot  |    ?    |  > pivot  |
             * +----------------------------------------------+
             *              ^            ^       ^
             *              |            |       |
             *             less          k     great
             *
             * Invariants:
             *
             *   all in (left, less)   < pivot
             *   all in [less, k)     == pivot
             *   all in (great, right) > pivot
             *
             * Pointer k is the first index of ?-part
             */
            for (int k = less; k <= great; k++) {
                double ak = a[k];
                if (ak == pivot1) {
                    continue;
                }
                if (ak < pivot1) { // Move a[k] to left part
                    if (k != less) {
                        a[k] = a[less];
                        a[less] = ak;
                    }
                    less++;
                } else { // (a[k] > pivot1) -  Move a[k] to right part
                    /*
                     * We know that pivot1 == a[e3] == pivot2. Thus, we know
                     * that great will still be >= k when the following loop
                     * terminates, even though we don't test for it explicitly.
                     * In other words, a[e3] acts as a sentinel for great.
                     */
                    while (a[great] > pivot1) {
                        great--;
                    }
                    if (a[great] < pivot1) {
                        a[k] = a[less];
                        a[less++] = a[great];
                        a[great--] = ak;
                    } else { // a[great] == pivot1
                        a[k] = pivot1;
                        a[great--] = ak;
                    }
                }
            }
        }

        // Swap pivots into their final positions
        a[left]  = a[less  - 1]; a[less  - 1] = pivot1;
        a[right] = a[great + 1]; a[great + 1] = pivot2;

        // Sort left and right parts recursively, excluding known pivot values
        doSort(a, left,   less - 2);
        doSort(a, great + 2, right);

        /*
         * If pivot1 == pivot2, all elements from center
         * part are equal and, therefore, already sorted
         */
        if (!pivotsDiffer) {
            return;
        }

        /*
         * If center part is too large (comprises > 2/3 of the array),
         * swap internal pivot values to ends
         */
        if (less < e1 && great > e5) {
            while (a[less] == pivot1) {
                less++;
            }
            while (a[great] == pivot2) {
                great--;
            }

            /*
             * Partitioning:
             *
             *   left part       center part                   right part
             * +----------------------------------------------------------+
             * | == pivot1 |  pivot1 < && < pivot2  |    ?    | == pivot2 |
             * +----------------------------------------------------------+
             *              ^                        ^       ^
             *              |                        |       |
             *             less                      k     great
             *
             * Invariants:
             *
             *              all in (*, less)  == pivot1
             *     pivot1 < all in [less, k)   < pivot2
             *              all in (great, *) == pivot2
             *
             * Pointer k is the first index of ?-part
             */
            outer:
            for (int k = less; k <= great; k++) {
                double ak = a[k];
                if (ak == pivot2) { // Move a[k] to right part
                    while (a[great] == pivot2) {
                        if (great-- == k) {
                            break outer;
                        }
                    }
                    if (a[great] == pivot1) {
                        a[k] = a[less];
                        a[less++] = pivot1;
                    } else { // pivot1 < a[great] < pivot2
                        a[k] = a[great];
                    }
                    a[great--] = pivot2;
                } else if (ak == pivot1) { // Move a[k] to left part
                    a[k] = a[less];
                    a[less++] = pivot1;
                }
            }
        }

        // Sort center part recursively, excluding known pivot values
        doSort(a, less, great);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.349 -0500", hash_original_field = "1161DDF926E92097F713C6A620F3FBEF", hash_generated_field = "69F1559DEF8EAE4C7B8144E76EB36B2D")

    /**
     * If the length of an array to be sorted is less than this
     * constant, insertion sort is used in preference to Quicksort.
     */
    private static final int INSERTION_SORT_THRESHOLD = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.352 -0500", hash_original_field = "E12A0760399EA4AC4D58931141403685", hash_generated_field = "FB00E5C7F5169F6909153059E9E7DC47")

    private static final int COUNTING_SORT_THRESHOLD_FOR_BYTE = 128;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.354 -0500", hash_original_field = "AA2E6F2748B6E68424E16E074C099F58", hash_generated_field = "BC08190B460D0471F1781A740F156E67")

    private static final int COUNTING_SORT_THRESHOLD_FOR_SHORT_OR_CHAR = 32768;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.392 -0500", hash_original_field = "5DA14A8D4AAE936DE49B19DBEA5354B2", hash_generated_field = "FB6D5FC791962D1D653D5EC8368240F1")

    private static final int NUM_SHORT_VALUES = 1 << 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.409 -0500", hash_original_field = "A59F14593AB6A405CB530DA6EE354039", hash_generated_field = "32B1F4D135C8358A9B7BCD2C64DB0B09")

    private static final int NUM_CHAR_VALUES = 1 << 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.426 -0500", hash_original_field = "C32AB1DB2F432FF04A53C12ECB70A331", hash_generated_field = "891D887973B93E8CB3FE00BAD7302B4C")

    private static final int NUM_BYTE_VALUES = 1 << 8;

    /**
     * Prevents instantiation.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:34.347 -0500", hash_original_method = "7D881BD1A8E4D4C26C8DF479B09D2287", hash_generated_method = "BE224B666802DAA9D4B75F867770010D")
    
private DualPivotQuicksort() {}
}

