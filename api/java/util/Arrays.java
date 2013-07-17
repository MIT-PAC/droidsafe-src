package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;
import java.lang.reflect.Array;

public class Arrays {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.970 -0400", hash_original_method = "F55A33B7721183458366770FE1A5E43D", hash_generated_method = "49F223D555836B7BADC6EB97733A13D3")
    private  Arrays() {
        // ---------- Original Method ----------
    }

    
    public static <T> List<T> asList(T... array) {
        return new ArrayList<T>(array);
    }

    
    @DSModeled(DSC.SAFE)
    public static int binarySearch(byte[] array, byte value) {
        return binarySearch(array, 0, array.length, value);
    }

    
    @DSModeled(DSC.SAFE)
    public static int binarySearch(byte[] array, int startIndex, int endIndex, byte value) {
        checkBinarySearchBounds(startIndex, endIndex, array.length);
        int lo = startIndex;
        int hi = endIndex - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            byte midVal = array[mid];
            if (midVal < value) {
                lo = mid + 1;
            } else if (midVal > value) {
                hi = mid - 1;
            } else {
                return mid;  
            }
        }
        return ~lo;
    }

    
    @DSModeled(DSC.SAFE)
    public static int binarySearch(char[] array, char value) {
        return binarySearch(array, 0, array.length, value);
    }

    
    @DSModeled(DSC.SAFE)
    public static int binarySearch(char[] array, int startIndex, int endIndex, char value) {
        checkBinarySearchBounds(startIndex, endIndex, array.length);
        int lo = startIndex;
        int hi = endIndex - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            char midVal = array[mid];
            if (midVal < value) {
                lo = mid + 1;
            } else if (midVal > value) {
                hi = mid - 1;
            } else {
                return mid;  
            }
        }
        return ~lo;
    }

    
    @DSModeled(DSC.SAFE)
    public static int binarySearch(double[] array, double value) {
        return binarySearch(array, 0, array.length, value);
    }

    
    @DSModeled(DSC.SAFE)
    public static int binarySearch(double[] array, int startIndex, int endIndex, double value) {
        checkBinarySearchBounds(startIndex, endIndex, array.length);
        int lo = startIndex;
        int hi = endIndex - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            double midVal = array[mid];
            if (midVal < value) {
                lo = mid + 1;
            } else if (midVal > value) {
                hi = mid - 1;
            } else if (midVal != 0 && midVal == value) {
                return mid;  
            } else { 
                long midValBits = Double.doubleToLongBits(midVal);
                long valueBits  = Double.doubleToLongBits(value);
                if (midValBits < valueBits) {
                    lo = mid + 1; 
                } else if (midValBits > valueBits) {
                    hi = mid - 1; 
                } else {
                    return mid; 
                }
            }
        }
        return ~lo;
    }

    
    @DSModeled(DSC.SAFE)
    public static int binarySearch(float[] array, float value) {
        return binarySearch(array, 0, array.length, value);
    }

    
    @DSModeled(DSC.SAFE)
    public static int binarySearch(float[] array, int startIndex, int endIndex, float value) {
        checkBinarySearchBounds(startIndex, endIndex, array.length);
        int lo = startIndex;
        int hi = endIndex - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            float midVal = array[mid];
            if (midVal < value) {
                lo = mid + 1;
            } else if (midVal > value) {
                hi = mid - 1;
            } else if (midVal != 0 && midVal == value) {
                return mid;  
            } else { 
                int midValBits = Float.floatToIntBits(midVal);
                int valueBits  = Float.floatToIntBits(value);
                if (midValBits < valueBits) {
                    lo = mid + 1; 
                } else if (midValBits > valueBits) {
                    hi = mid - 1; 
                } else {
                    return mid; 
                }
            }
        }
        return ~lo;
    }

    
    @DSModeled(DSC.SAFE)
    public static int binarySearch(int[] array, int value) {
        return binarySearch(array, 0, array.length, value);
    }

    
    @DSModeled(DSC.SAFE)
    public static int binarySearch(int[] array, int startIndex, int endIndex, int value) {
        checkBinarySearchBounds(startIndex, endIndex, array.length);
        int lo = startIndex;
        int hi = endIndex - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int midVal = array[mid];
            if (midVal < value) {
                lo = mid + 1;
            } else if (midVal > value) {
                hi = mid - 1;
            } else {
                return mid;  
            }
        }
        return ~lo;
    }

    
    @DSModeled(DSC.SAFE)
    public static int binarySearch(long[] array, long value) {
        return binarySearch(array, 0, array.length, value);
    }

    
    @DSModeled(DSC.SAFE)
    public static int binarySearch(long[] array, int startIndex, int endIndex, long value) {
        checkBinarySearchBounds(startIndex, endIndex, array.length);
        int lo = startIndex;
        int hi = endIndex - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            long midVal = array[mid];
            if (midVal < value) {
                lo = mid + 1;
            } else if (midVal > value) {
                hi = mid - 1;
            } else {
                return mid;  
            }
         }
        return ~lo;
    }

    
    @DSModeled(DSC.SAFE)
    public static int binarySearch(Object[] array, Object value) {
        return binarySearch(array, 0, array.length, value);
    }

    
    @DSModeled(DSC.SAFE)
    public static int binarySearch(Object[] array, int startIndex, int endIndex, Object value) {
        checkBinarySearchBounds(startIndex, endIndex, array.length);
        int lo = startIndex;
        int hi = endIndex - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            @SuppressWarnings("unchecked")
            int midValCmp = ((Comparable) array[mid]).compareTo(value);
            if (midValCmp < 0) {
                lo = mid + 1;
            } else if (midValCmp > 0) {
                hi = mid - 1;
            } else {
                return mid;  
            }
        }
        return ~lo;
    }

    
    public static <T> int binarySearch(T[] array, T value, Comparator<? super T> comparator) {
        return binarySearch(array, 0, array.length, value, comparator);
    }

    
    public static <T> int binarySearch(T[] array, int startIndex, int endIndex, T value,
            Comparator<? super T> comparator) {
        if (comparator == null) {
            return binarySearch(array, startIndex, endIndex, value);
        }
        checkBinarySearchBounds(startIndex, endIndex, array.length);
        int lo = startIndex;
        int hi = endIndex - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int midValCmp = comparator.compare(array[mid], value);
            if (midValCmp < 0) {
                lo = mid + 1;
            } else if (midValCmp > 0) {
                hi = mid - 1;
            } else {
                return mid;  
            }
        }
        return ~lo;
    }

    
    @DSModeled(DSC.SAFE)
    public static int binarySearch(short[] array, short value) {
        return binarySearch(array, 0, array.length, value);
    }

    
    @DSModeled(DSC.SAFE)
    public static int binarySearch(short[] array, int startIndex, int endIndex, short value) {
        checkBinarySearchBounds(startIndex, endIndex, array.length);
        int lo = startIndex;
        int hi = endIndex - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            short midVal = array[mid];
            if (midVal < value) {
                lo = mid + 1;
            } else if (midVal > value) {
                hi = mid - 1;
            } else {
                return mid;  
            }
        }
        return ~lo;
    }

    
    @DSModeled(DSC.SAFE)
    private static void checkBinarySearchBounds(int startIndex, int endIndex, int length) {
        if (startIndex > endIndex) {
            throw new IllegalArgumentException();
        }
        if (startIndex < 0 || endIndex > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void fill(byte[] array, byte value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void fill(byte[] array, int start, int end, byte value) {
        Arrays.checkStartAndEnd(array.length, start, end);
        for (int i = start; i < end; i++) {
            array[i] = value;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void fill(short[] array, short value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void fill(short[] array, int start, int end, short value) {
        Arrays.checkStartAndEnd(array.length, start, end);
        for (int i = start; i < end; i++) {
            array[i] = value;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void fill(char[] array, char value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void fill(char[] array, int start, int end, char value) {
        Arrays.checkStartAndEnd(array.length, start, end);
        for (int i = start; i < end; i++) {
            array[i] = value;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void fill(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void fill(int[] array, int start, int end, int value) {
        Arrays.checkStartAndEnd(array.length, start, end);
        for (int i = start; i < end; i++) {
            array[i] = value;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void fill(long[] array, long value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void fill(long[] array, int start, int end, long value) {
        Arrays.checkStartAndEnd(array.length, start, end);
        for (int i = start; i < end; i++) {
            array[i] = value;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void fill(float[] array, float value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void fill(float[] array, int start, int end, float value) {
        Arrays.checkStartAndEnd(array.length, start, end);
        for (int i = start; i < end; i++) {
            array[i] = value;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void fill(double[] array, double value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void fill(double[] array, int start, int end, double value) {
        Arrays.checkStartAndEnd(array.length, start, end);
        for (int i = start; i < end; i++) {
            array[i] = value;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void fill(boolean[] array, boolean value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void fill(boolean[] array, int start, int end, boolean value) {
        Arrays.checkStartAndEnd(array.length, start, end);
        for (int i = start; i < end; i++) {
            array[i] = value;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void fill(Object[] array, Object value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void fill(Object[] array, int start, int end, Object value) {
        Arrays.checkStartAndEnd(array.length, start, end);
        for (int i = start; i < end; i++) {
            array[i] = value;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static int hashCode(boolean[] array) {
        if (array == null) {
            return 0;
        }
        int hashCode = 1;
        for (boolean element : array) {
            hashCode = 31 * hashCode + (element ? 1231 : 1237);
        }
        return hashCode;
    }

    
    @DSModeled(DSC.SAFE)
    public static int hashCode(int[] array) {
        if (array == null) {
            return 0;
        }
        int hashCode = 1;
        for (int element : array) {
            hashCode = 31 * hashCode + element;
        }
        return hashCode;
    }

    
    @DSModeled(DSC.SAFE)
    public static int hashCode(short[] array) {
        if (array == null) {
            return 0;
        }
        int hashCode = 1;
        for (short element : array) {
            hashCode = 31 * hashCode + element;
        }
        return hashCode;
    }

    
    @DSModeled(DSC.SAFE)
    public static int hashCode(char[] array) {
        if (array == null) {
            return 0;
        }
        int hashCode = 1;
        for (char element : array) {
            hashCode = 31 * hashCode + element;
        }
        return hashCode;
    }

    
    @DSModeled(DSC.SAFE)
    public static int hashCode(byte[] array) {
        if (array == null) {
            return 0;
        }
        int hashCode = 1;
        for (byte element : array) {
            hashCode = 31 * hashCode + element;
        }
        return hashCode;
    }

    
    @DSModeled(DSC.SAFE)
    public static int hashCode(long[] array) {
        if (array == null) {
            return 0;
        }
        int hashCode = 1;
        for (long elementValue : array) {
            hashCode = 31 * hashCode
                    + (int) (elementValue ^ (elementValue >>> 32));
        }
        return hashCode;
    }

    
    @DSModeled(DSC.SAFE)
    public static int hashCode(float[] array) {
        if (array == null) {
            return 0;
        }
        int hashCode = 1;
        for (float element : array) {
            hashCode = 31 * hashCode + Float.floatToIntBits(element);
        }
        return hashCode;
    }

    
    @DSModeled(DSC.SAFE)
    public static int hashCode(double[] array) {
        if (array == null) {
            return 0;
        }
        int hashCode = 1;
        for (double element : array) {
            long v = Double.doubleToLongBits(element);
            hashCode = 31 * hashCode + (int) (v ^ (v >>> 32));
        }
        return hashCode;
    }

    
    @DSModeled(DSC.SAFE)
    public static int hashCode(Object[] array) {
        if (array == null) {
            return 0;
        }
        int hashCode = 1;
        for (Object element : array) {
            int elementHashCode;
            if (element == null) {
                elementHashCode = 0;
            } else {
                elementHashCode = (element).hashCode();
            }
            hashCode = 31 * hashCode + elementHashCode;
        }
        return hashCode;
    }

    
    @DSModeled(DSC.SAFE)
    public static int deepHashCode(Object[] array) {
        if (array == null) {
            return 0;
        }
        int hashCode = 1;
        for (Object element : array) {
            int elementHashCode = deepHashCodeElement(element);
            hashCode = 31 * hashCode + elementHashCode;
        }
        return hashCode;
    }

    
    @DSModeled(DSC.SAFE)
    private static int deepHashCodeElement(Object element) {
        Class<?> cl;
        if (element == null) {
            return 0;
        }
        cl = element.getClass().getComponentType();
        if (cl == null) {
            return element.hashCode();
        }
        if (!cl.isPrimitive()) {
            return deepHashCode((Object[]) element);
        }
        if (cl.equals(int.class)) {
            return hashCode((int[]) element);
        }
        if (cl.equals(char.class)) {
            return hashCode((char[]) element);
        }
        if (cl.equals(boolean.class)) {
            return hashCode((boolean[]) element);
        }
        if (cl.equals(byte.class)) {
            return hashCode((byte[]) element);
        }
        if (cl.equals(long.class)) {
            return hashCode((long[]) element);
        }
        if (cl.equals(float.class)) {
            return hashCode((float[]) element);
        }
        if (cl.equals(double.class)) {
            return hashCode((double[]) element);
        }
        return hashCode((short[]) element);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean equals(byte[] array1, byte[] array2) {
        if (array1 == array2) {
            return true;
        }
        if (array1 == null || array2 == null || array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean equals(short[] array1, short[] array2) {
        if (array1 == array2) {
            return true;
        }
        if (array1 == null || array2 == null || array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean equals(char[] array1, char[] array2) {
        if (array1 == array2) {
            return true;
        }
        if (array1 == null || array2 == null || array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean equals(int[] array1, int[] array2) {
        if (array1 == array2) {
            return true;
        }
        if (array1 == null || array2 == null || array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean equals(long[] array1, long[] array2) {
        if (array1 == array2) {
            return true;
        }
        if (array1 == null || array2 == null || array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean equals(float[] array1, float[] array2) {
        if (array1 == array2) {
            return true;
        }
        if (array1 == null || array2 == null || array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (Float.floatToIntBits(array1[i]) != Float
                    .floatToIntBits(array2[i])) {
                return false;
            }
        }
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean equals(double[] array1, double[] array2) {
        if (array1 == array2) {
            return true;
        }
        if (array1 == null || array2 == null || array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (Double.doubleToLongBits(array1[i]) != Double
                    .doubleToLongBits(array2[i])) {
                return false;
            }
        }
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean equals(boolean[] array1, boolean[] array2) {
        if (array1 == array2) {
            return true;
        }
        if (array1 == null || array2 == null || array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean equals(Object[] array1, Object[] array2) {
        if (array1 == array2) {
            return true;
        }
        if (array1 == null || array2 == null || array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            Object e1 = array1[i], e2 = array2[i];
            if (!(e1 == null ? e2 == null : e1.equals(e2))) {
                return false;
            }
        }
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean deepEquals(Object[] array1, Object[] array2) {
        if (array1 == array2) {
            return true;
        }
        if (array1 == null || array2 == null || array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            Object e1 = array1[i], e2 = array2[i];
            if (!deepEqualsElements(e1, e2)) {
                return false;
            }
        }
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean deepEqualsElements(Object e1, Object e2) {
        Class<?> cl1, cl2;
        if (e1 == e2) {
            return true;
        }
        if (e1 == null || e2 == null) {
            return false;
        }
        cl1 = e1.getClass().getComponentType();
        cl2 = e2.getClass().getComponentType();
        if (cl1 != cl2) {
            return false;
        }
        if (cl1 == null) {
            return e1.equals(e2);
        }
        if (!cl1.isPrimitive()) {
            return deepEquals((Object[]) e1, (Object[]) e2);
        }
        if (cl1.equals(int.class)) {
            return equals((int[]) e1, (int[]) e2);
        }
        if (cl1.equals(char.class)) {
            return equals((char[]) e1, (char[]) e2);
        }
        if (cl1.equals(boolean.class)) {
            return equals((boolean[]) e1, (boolean[]) e2);
        }
        if (cl1.equals(byte.class)) {
            return equals((byte[]) e1, (byte[]) e2);
        }
        if (cl1.equals(long.class)) {
            return equals((long[]) e1, (long[]) e2);
        }
        if (cl1.equals(float.class)) {
            return equals((float[]) e1, (float[]) e2);
        }
        if (cl1.equals(double.class)) {
            return equals((double[]) e1, (double[]) e2);
        }
        return equals((short[]) e1, (short[]) e2);
    }

    
    @DSModeled(DSC.SAFE)
    public static void sort(byte[] array) {
        DualPivotQuicksort.sort(array);
    }

    
    @DSModeled(DSC.SAFE)
    public static void sort(byte[] array, int start, int end) {
        DualPivotQuicksort.sort(array, start, end);
    }

    
    @DSModeled(DSC.SAFE)
    public static void checkOffsetAndCount(int arrayLength, int offset, int count) {
        if ((offset | count) < 0 || offset > arrayLength || arrayLength - offset < count) {
            throw new ArrayIndexOutOfBoundsException(arrayLength, offset,
                    count);
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void checkStartAndEnd(int len, int start, int end) {
        if (start < 0 || end > len) {
            throw new ArrayIndexOutOfBoundsException("start < 0 || end > len."
                    + " start=" + start + ", end=" + end + ", len=" + len);
        }
        if (start > end) {
            throw new IllegalArgumentException("start > end: " + start + " > " + end);
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void sort(char[] array) {
        DualPivotQuicksort.sort(array);
    }

    
    @DSModeled(DSC.SAFE)
    public static void sort(char[] array, int start, int end) {
        DualPivotQuicksort.sort(array, start, end);
    }

    
    @DSModeled(DSC.SAFE)
    public static void sort(double[] array) {
        DualPivotQuicksort.sort(array);
    }

    
    @DSModeled(DSC.SAFE)
    public static void sort(double[] array, int start, int end) {
        DualPivotQuicksort.sort(array, start, end);
    }

    
    @DSModeled(DSC.SAFE)
    public static void sort(float[] array) {
        DualPivotQuicksort.sort(array);
    }

    
    @DSModeled(DSC.SAFE)
    public static void sort(float[] array, int start, int end) {
        DualPivotQuicksort.sort(array, start, end);
    }

    
    @DSModeled(DSC.SAFE)
    public static void sort(int[] array) {
        DualPivotQuicksort.sort(array);
    }

    
    @DSModeled(DSC.SAFE)
    public static void sort(int[] array, int start, int end) {
        DualPivotQuicksort.sort(array, start, end);
    }

    
    @DSModeled(DSC.SAFE)
    public static void sort(long[] array) {
        DualPivotQuicksort.sort(array);
    }

    
    @DSModeled(DSC.SAFE)
    public static void sort(long[] array, int start, int end) {
        DualPivotQuicksort.sort(array, start, end);
    }

    
    @DSModeled(DSC.SAFE)
    public static void sort(short[] array) {
        DualPivotQuicksort.sort(array);
    }

    
    @DSModeled(DSC.SAFE)
    public static void sort(short[] array, int start, int end) {
        DualPivotQuicksort.sort(array, start, end);
    }

    
    @DSModeled(DSC.SAFE)
    public static void sort(Object[] array) {
        ComparableTimSort.sort(array);
    }

    
    @DSModeled(DSC.SAFE)
    public static void sort(Object[] array, int start, int end) {
        ComparableTimSort.sort(array, start, end);
    }

    
    public static <T> void sort(T[] array, int start, int end, Comparator<? super T> comparator) {
        TimSort.sort(array, start, end, comparator);
    }

    
    public static <T> void sort(T[] array, Comparator<? super T> comparator) {
        TimSort.sort(array, comparator);
    }

    
    @DSModeled(DSC.SAFE)
    public static String toString(boolean[] array) {
        if (array == null) {
            return "null";
        }
        if (array.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(array.length * 7);
        sb.append('[');
        sb.append(array[0]);
        for (int i = 1; i < array.length; i++) {
            sb.append(", ");
            sb.append(array[i]);
        }
        sb.append(']');
        return sb.toString();
    }

    
    @DSModeled(DSC.SAFE)
    public static String toString(byte[] array) {
        if (array == null) {
            return "null";
        }
        if (array.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(array.length * 6);
        sb.append('[');
        sb.append(array[0]);
        for (int i = 1; i < array.length; i++) {
            sb.append(", ");
            sb.append(array[i]);
        }
        sb.append(']');
        return sb.toString();
    }

    
    @DSModeled(DSC.SAFE)
    public static String toString(char[] array) {
        if (array == null) {
            return "null";
        }
        if (array.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(array.length * 3);
        sb.append('[');
        sb.append(array[0]);
        for (int i = 1; i < array.length; i++) {
            sb.append(", ");
            sb.append(array[i]);
        }
        sb.append(']');
        return sb.toString();
    }

    
    @DSModeled(DSC.SAFE)
    public static String toString(double[] array) {
        if (array == null) {
            return "null";
        }
        if (array.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(array.length * 7);
        sb.append('[');
        sb.append(array[0]);
        for (int i = 1; i < array.length; i++) {
            sb.append(", ");
            sb.append(array[i]);
        }
        sb.append(']');
        return sb.toString();
    }

    
    @DSModeled(DSC.SAFE)
    public static String toString(float[] array) {
        if (array == null) {
            return "null";
        }
        if (array.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(array.length * 7);
        sb.append('[');
        sb.append(array[0]);
        for (int i = 1; i < array.length; i++) {
            sb.append(", ");
            sb.append(array[i]);
        }
        sb.append(']');
        return sb.toString();
    }

    
    @DSModeled(DSC.SAFE)
    public static String toString(int[] array) {
        if (array == null) {
            return "null";
        }
        if (array.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(array.length * 6);
        sb.append('[');
        sb.append(array[0]);
        for (int i = 1; i < array.length; i++) {
            sb.append(", ");
            sb.append(array[i]);
        }
        sb.append(']');
        return sb.toString();
    }

    
    @DSModeled(DSC.SAFE)
    public static String toString(long[] array) {
        if (array == null) {
            return "null";
        }
        if (array.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(array.length * 6);
        sb.append('[');
        sb.append(array[0]);
        for (int i = 1; i < array.length; i++) {
            sb.append(", ");
            sb.append(array[i]);
        }
        sb.append(']');
        return sb.toString();
    }

    
    @DSModeled(DSC.SAFE)
    public static String toString(short[] array) {
        if (array == null) {
            return "null";
        }
        if (array.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(array.length * 6);
        sb.append('[');
        sb.append(array[0]);
        for (int i = 1; i < array.length; i++) {
            sb.append(", ");
            sb.append(array[i]);
        }
        sb.append(']');
        return sb.toString();
    }

    
    @DSModeled(DSC.SAFE)
    public static String toString(Object[] array) {
        if (array == null) {
            return "null";
        }
        if (array.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(array.length * 7);
        sb.append('[');
        sb.append(array[0]);
        for (int i = 1; i < array.length; i++) {
            sb.append(", ");
            sb.append(array[i]);
        }
        sb.append(']');
        return sb.toString();
    }

    
    @DSModeled(DSC.SAFE)
    public static String deepToString(Object[] array) {
        if (array == null) {
            return "null";
        }
        StringBuilder buf = new StringBuilder(array.length * 9);
        deepToStringImpl(array, new Object[] { array }, buf);
        return buf.toString();
    }

    
    @DSModeled(DSC.SAFE)
    private static void deepToStringImpl(Object[] array, Object[] origArrays,
            StringBuilder sb) {
        if (array == null) {
            sb.append("null");
            return;
        }
        sb.append('[');
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            Object elem = array[i];
            if (elem == null) {
                sb.append("null");
            } else {
                Class<?> elemClass = elem.getClass();
                if (elemClass.isArray()) {
                    Class<?> elemElemClass = elemClass.getComponentType();
                    if (elemElemClass.isPrimitive()) {
                        if (boolean.class.equals(elemElemClass)) {
                            sb.append(toString((boolean[]) elem));
                        } else if (byte.class.equals(elemElemClass)) {
                            sb.append(toString((byte[]) elem));
                        } else if (char.class.equals(elemElemClass)) {
                            sb.append(toString((char[]) elem));
                        } else if (double.class.equals(elemElemClass)) {
                            sb.append(toString((double[]) elem));
                        } else if (float.class.equals(elemElemClass)) {
                            sb.append(toString((float[]) elem));
                        } else if (int.class.equals(elemElemClass)) {
                            sb.append(toString((int[]) elem));
                        } else if (long.class.equals(elemElemClass)) {
                            sb.append(toString((long[]) elem));
                        } else if (short.class.equals(elemElemClass)) {
                            sb.append(toString((short[]) elem));
                        } else {
                            throw new AssertionError();
                        }
                    } else {
                        assert elem instanceof Object[];
                        if (deepToStringImplContains(origArrays, elem)) {
                            sb.append("[...]");
                        } else {
                            Object[] newArray = (Object[]) elem;
                            Object[] newOrigArrays = new Object[origArrays.length + 1];
                            System.arraycopy(origArrays, 0, newOrigArrays, 0,
                                    origArrays.length);
                            newOrigArrays[origArrays.length] = newArray;
                            deepToStringImpl(newArray, newOrigArrays, sb);
                        }
                    }
                } else { 
                    sb.append(array[i]);
                }
            }
        }
        sb.append(']');
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean deepToStringImplContains(Object[] origArrays,
            Object array) {
        if (origArrays == null || origArrays.length == 0) {
            return false;
        }
        for (Object element : origArrays) {
            if (element == array) {
                return true;
            }
        }
        return false;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean[] copyOf(boolean[] original, int newLength) {
        if (newLength < 0) {
            throw new NegativeArraySizeException();
        }
        return copyOfRange(original, 0, newLength);
    }

    
    @DSModeled(DSC.SAFE)
    public static byte[] copyOf(byte[] original, int newLength) {
        if (newLength < 0) {
            throw new NegativeArraySizeException();
        }
        return copyOfRange(original, 0, newLength);
    }

    
    @DSModeled(DSC.SAFE)
    public static char[] copyOf(char[] original, int newLength) {
        if (newLength < 0) {
            throw new NegativeArraySizeException();
        }
        return copyOfRange(original, 0, newLength);
    }

    
    @DSModeled(DSC.SAFE)
    public static double[] copyOf(double[] original, int newLength) {
        if (newLength < 0) {
            throw new NegativeArraySizeException();
        }
        return copyOfRange(original, 0, newLength);
    }

    
    @DSModeled(DSC.SAFE)
    public static float[] copyOf(float[] original, int newLength) {
        if (newLength < 0) {
            throw new NegativeArraySizeException();
        }
        return copyOfRange(original, 0, newLength);
    }

    
    @DSModeled(DSC.SAFE)
    public static int[] copyOf(int[] original, int newLength) {
        if (newLength < 0) {
            throw new NegativeArraySizeException();
        }
        return copyOfRange(original, 0, newLength);
    }

    
    @DSModeled(DSC.SAFE)
    public static long[] copyOf(long[] original, int newLength) {
        if (newLength < 0) {
            throw new NegativeArraySizeException();
        }
        return copyOfRange(original, 0, newLength);
    }

    
    @DSModeled(DSC.SAFE)
    public static short[] copyOf(short[] original, int newLength) {
        if (newLength < 0) {
            throw new NegativeArraySizeException();
        }
        return copyOfRange(original, 0, newLength);
    }

    
    @DSModeled(DSC.SAFE)
    public static <T> T[] copyOf(T[] original, int newLength) {
        if (original == null) {
            throw new NullPointerException();
        }
        if (newLength < 0) {
            throw new NegativeArraySizeException();
        }
        return copyOfRange(original, 0, newLength);
    }

    
    public static <T, U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
        if (newLength < 0) {
            throw new NegativeArraySizeException();
        }
        return copyOfRange(original, 0, newLength, newType);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean[] copyOfRange(boolean[] original, int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException();
        }
        int originalLength = original.length;
        if (start < 0 || start > originalLength) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int resultLength = end - start;
        int copyLength = Math.min(resultLength, originalLength - start);
        boolean[] result = new boolean[resultLength];
        System.arraycopy(original, start, result, 0, copyLength);
        return result;
    }

    
    @DSModeled(DSC.SAFE)
    public static byte[] copyOfRange(byte[] original, int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException();
        }
        int originalLength = original.length;
        if (start < 0 || start > originalLength) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int resultLength = end - start;
        int copyLength = Math.min(resultLength, originalLength - start);
        byte[] result = new byte[resultLength];
        System.arraycopy(original, start, result, 0, copyLength);
        return result;
    }

    
    @DSModeled(DSC.SAFE)
    public static char[] copyOfRange(char[] original, int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException();
        }
        int originalLength = original.length;
        if (start < 0 || start > originalLength) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int resultLength = end - start;
        int copyLength = Math.min(resultLength, originalLength - start);
        char[] result = new char[resultLength];
        System.arraycopy(original, start, result, 0, copyLength);
        return result;
    }

    
    @DSModeled(DSC.SAFE)
    public static double[] copyOfRange(double[] original, int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException();
        }
        int originalLength = original.length;
        if (start < 0 || start > originalLength) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int resultLength = end - start;
        int copyLength = Math.min(resultLength, originalLength - start);
        double[] result = new double[resultLength];
        System.arraycopy(original, start, result, 0, copyLength);
        return result;
    }

    
    @DSModeled(DSC.SAFE)
    public static float[] copyOfRange(float[] original, int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException();
        }
        int originalLength = original.length;
        if (start < 0 || start > originalLength) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int resultLength = end - start;
        int copyLength = Math.min(resultLength, originalLength - start);
        float[] result = new float[resultLength];
        System.arraycopy(original, start, result, 0, copyLength);
        return result;
    }

    
    @DSModeled(DSC.SAFE)
    public static int[] copyOfRange(int[] original, int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException();
        }
        int originalLength = original.length;
        if (start < 0 || start > originalLength) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int resultLength = end - start;
        int copyLength = Math.min(resultLength, originalLength - start);
        int[] result = new int[resultLength];
        System.arraycopy(original, start, result, 0, copyLength);
        return result;
    }

    
    @DSModeled(DSC.SAFE)
    public static long[] copyOfRange(long[] original, int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException();
        }
        int originalLength = original.length;
        if (start < 0 || start > originalLength) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int resultLength = end - start;
        int copyLength = Math.min(resultLength, originalLength - start);
        long[] result = new long[resultLength];
        System.arraycopy(original, start, result, 0, copyLength);
        return result;
    }

    
    @DSModeled(DSC.SAFE)
    public static short[] copyOfRange(short[] original, int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException();
        }
        int originalLength = original.length;
        if (start < 0 || start > originalLength) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int resultLength = end - start;
        int copyLength = Math.min(resultLength, originalLength - start);
        short[] result = new short[resultLength];
        System.arraycopy(original, start, result, 0, copyLength);
        return result;
    }

    
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    public static <T> T[] copyOfRange(T[] original, int start, int end) {
        int originalLength = original.length;
        if (start > end) {
            throw new IllegalArgumentException();
        }
        if (start < 0 || start > originalLength) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int resultLength = end - start;
        int copyLength = Math.min(resultLength, originalLength - start);
        T[] result = (T[]) Array.newInstance(original.getClass().getComponentType(), resultLength);
        System.arraycopy(original, start, result, 0, copyLength);
        return result;
    }

    
    @SuppressWarnings("unchecked")
    public static <T, U> T[] copyOfRange(U[] original, int start, int end, Class<? extends T[]> newType) {
        if (start > end) {
            throw new IllegalArgumentException();
        }
        int originalLength = original.length;
        if (start < 0 || start > originalLength) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int resultLength = end - start;
        int copyLength = Math.min(resultLength, originalLength - start);
        T[] result = (T[]) Array.newInstance(newType.getComponentType(), resultLength);
        System.arraycopy(original, start, result, 0, copyLength);
        return result;
    }

    
    private static class ArrayList<E> extends AbstractList<E> implements List<E>, Serializable, RandomAccess {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.994 -0400", hash_original_field = "0CC175B9C0F1B6A831C399E269772661", hash_generated_field = "59D3CDBB1380FC0BC14279DCD13B4432")

        private E[] a;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.995 -0400", hash_original_method = "28401D48F15218543E5E002CE4B26D15", hash_generated_method = "27B21DD0ECA3827F8D6B0EAAF859F751")
          ArrayList(E[] storage) {
            if(storage == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_234179137 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_234179137.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_234179137;
            } //End block
            a = storage;
            // ---------- Original Method ----------
            //if (storage == null) {
                //throw new NullPointerException();
            //}
            //a = storage;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.995 -0400", hash_original_method = "60C2CE78869B52DAF166079897D78161", hash_generated_method = "B315BB4634966A4BE9CC724DFA655D52")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            if(object != null)            
            {
for(E element : a)
                {
                    if(object.equals(element))                    
                    {
                        boolean varB326B5062B2F0E69046810717534CB09_12235900 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_836557851 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_836557851;
                    } //End block
                } //End block
            } //End block
            else
            {
for(E element : a)
                {
                    if(element == null)                    
                    {
                        boolean varB326B5062B2F0E69046810717534CB09_527647182 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_514209282 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_514209282;
                    } //End block
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1347088337 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_117397534 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_117397534;
            // ---------- Original Method ----------
            //if (object != null) {
                //for (E element : a) {
                    //if (object.equals(element)) {
                        //return true;
                    //}
                //}
            //} else {
                //for (E element : a) {
                    //if (element == null) {
                        //return true;
                    //}
                //}
            //}
            //return false;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.518 -0400", hash_original_method = "2292A4CE789907EDD632B4A1EB11E4D2", hash_generated_method = "B2FEE0C150F1B0531794BB26ED0C3A5A")
        @Override
        public E get(int location) {
            addTaint(location);
            try 
            {
E varE9389EE2200B2620B656A8101CB528EA_471271096 =                 a[location];
                varE9389EE2200B2620B656A8101CB528EA_471271096.addTaint(taint);
                return varE9389EE2200B2620B656A8101CB528EA_471271096;
            } //End block
            catch (ArrayIndexOutOfBoundsException e)
            {
                IndexOutOfBoundsException var984B160C934F71ECE403396A96C29D5E_1586489341 = java.util.ArrayList.throwIndexOutOfBoundsException(location, a.length);
                var984B160C934F71ECE403396A96C29D5E_1586489341.addTaint(taint);
                throw var984B160C934F71ECE403396A96C29D5E_1586489341;
            } //End block
            // ---------- Original Method ----------
            //try {
                //return a[location];
            //} catch (ArrayIndexOutOfBoundsException e) {
                //throw java.util.ArrayList.throwIndexOutOfBoundsException(location, a.length);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.999 -0400", hash_original_method = "2A691ADB93209815384C011B6281A9FB", hash_generated_method = "F3FA423AE009FC3FB972E4BB95DC73B3")
        @Override
        public int indexOf(Object object) {
            addTaint(object.getTaint());
            if(object != null)            
            {
for(int i = 0;i < a.length;i++)
                {
                    if(object.equals(a[i]))                    
                    {
                        int var865C0C0B4AB0E063E5CAA3387C1A8741_2124195378 = (i);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1792711137 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1792711137;
                    } //End block
                } //End block
            } //End block
            else
            {
for(int i = 0;i < a.length;i++)
                {
                    if(a[i] == null)                    
                    {
                        int var865C0C0B4AB0E063E5CAA3387C1A8741_552905831 = (i);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1809931636 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1809931636;
                    } //End block
                } //End block
            } //End block
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1689433901 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1410326503 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1410326503;
            // ---------- Original Method ----------
            //if (object != null) {
                //for (int i = 0; i < a.length; i++) {
                    //if (object.equals(a[i])) {
                        //return i;
                    //}
                //}
            //} else {
                //for (int i = 0; i < a.length; i++) {
                    //if (a[i] == null) {
                        //return i;
                    //}
                //}
            //}
            //return -1;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.000 -0400", hash_original_method = "0667C423DABE9154AC3C7F87378CA39A", hash_generated_method = "5A763082D72A13CF95932A73699CB8C2")
        @Override
        public int lastIndexOf(Object object) {
            addTaint(object.getTaint());
            if(object != null)            
            {
for(int i = a.length - 1;i >= 0;i--)
                {
                    if(object.equals(a[i]))                    
                    {
                        int var865C0C0B4AB0E063E5CAA3387C1A8741_2077483472 = (i);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1989960678 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1989960678;
                    } //End block
                } //End block
            } //End block
            else
            {
for(int i = a.length - 1;i >= 0;i--)
                {
                    if(a[i] == null)                    
                    {
                        int var865C0C0B4AB0E063E5CAA3387C1A8741_380166862 = (i);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1426416927 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1426416927;
                    } //End block
                } //End block
            } //End block
            int var6BB61E3B7BCE0931DA574D19D1D82C88_2130062343 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_128728776 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_128728776;
            // ---------- Original Method ----------
            //if (object != null) {
                //for (int i = a.length - 1; i >= 0; i--) {
                    //if (object.equals(a[i])) {
                        //return i;
                    //}
                //}
            //} else {
                //for (int i = a.length - 1; i >= 0; i--) {
                    //if (a[i] == null) {
                        //return i;
                    //}
                //}
            //}
            //return -1;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.000 -0400", hash_original_method = "34158A3678F4541935DDD01AA8496683", hash_generated_method = "55C6D3EC7DC29A107EE26F06D7DCF1E6")
        @Override
        public E set(int location, E object) {
            E result = a[location];
            a[location] = object;
E varDC838461EE2FA0CA4C9BBB70A15456B0_1050941589 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1050941589.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1050941589;
            // ---------- Original Method ----------
            //E result = a[location];
            //a[location] = object;
            //return result;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.000 -0400", hash_original_method = "E1955A04BFD4754737F2A0E48B09DBE4", hash_generated_method = "A4CD18C6B619BEC2ABE8538573914DA7")
        @Override
        public int size() {
            int var61F7368DB9A29D8E9C70F407210E1C84_1750870361 = (a.length);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1411455983 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1411455983;
            // ---------- Original Method ----------
            //return a.length;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.000 -0400", hash_original_method = "4819818080CBECF7C6E758DFD111EA84", hash_generated_method = "C2DBF9E46B2AC63105764EB046D80AE4")
        @Override
        public Object[] toArray() {
Object[] var0F7A32B248065CE004C94D59A2988880_1467673765 =             a.clone();
            var0F7A32B248065CE004C94D59A2988880_1467673765.addTaint(taint);
            return var0F7A32B248065CE004C94D59A2988880_1467673765;
            // ---------- Original Method ----------
            //return a.clone();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.001 -0400", hash_original_method = "7C6C61B0D92D6FAC6E5A876622A28815", hash_generated_method = "F8735DB7EA6ECCE9326BD99AA6BFFDD0")
        @Override
        @SuppressWarnings({"unchecked", "SuspiciousSystemArraycopy"})
        public <T> T[] toArray(T[] contents) {
            addTaint(contents[0].getTaint());
            int size = size();
            if(size > contents.length)            
            {
                Class<?> ct = contents.getClass().getComponentType();
                contents = (T[]) Array.newInstance(ct, size);
            } //End block
            System.arraycopy(a, 0, contents, 0, size);
            if(size < contents.length)            
            {
                contents[size] = null;
            } //End block
T[] var5DC9C33EDB9F81CF1216538024B770BE_763551582 =             contents;
            var5DC9C33EDB9F81CF1216538024B770BE_763551582.addTaint(taint);
            return var5DC9C33EDB9F81CF1216538024B770BE_763551582;
            // ---------- Original Method ----------
            //int size = size();
            //if (size > contents.length) {
                //Class<?> ct = contents.getClass().getComponentType();
                //contents = (T[]) Array.newInstance(ct, size);
            //}
            //System.arraycopy(a, 0, contents, 0, size);
            //if (size < contents.length) {
                //contents[size] = null;
            //}
            //return contents;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.001 -0400", hash_original_field = "9722346E49DFE0324A719B44FDFE9526", hash_generated_field = "534D9DD3A0BE09C3AE46777ECEF6E48A")

        private static final long serialVersionUID = -2764017481108945198L;
    }


    
}

