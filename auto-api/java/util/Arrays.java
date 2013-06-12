package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.Serializable;
import java.lang.reflect.Array;

public class Arrays {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.392 -0400", hash_original_method = "F55A33B7721183458366770FE1A5E43D", hash_generated_method = "B448B3DBD401F3AD907EE68EE8C37D3C")
    @DSModeled(DSC.SAFE)
    private Arrays() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.392 -0400", hash_original_method = "A6F5C53A625808CA7AF1875ED3BF735C", hash_generated_method = "DEC6DD4B8A78B55E4A7850BCBCA99714")
    public static <T> List<T> asList(T... array) {
        return new ArrayList<T>(array);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.392 -0400", hash_original_method = "AF653A9E2629865B65E27F3E8EFBF9CD", hash_generated_method = "DE4F969DFC1A4EF3B3F02E88F44DA323")
    public static int binarySearch(byte[] array, byte value) {
        return binarySearch(array, 0, array.length, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.392 -0400", hash_original_method = "B5911E4390B2ECBA2CAD1A2FC1492249", hash_generated_method = "B0149DE892F49B97F42A9D32838456E2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.392 -0400", hash_original_method = "9CC86BD32DF5EB04FF2B752A6A05E065", hash_generated_method = "41159CBC40193F82CBD306E185C5BDC8")
    public static int binarySearch(char[] array, char value) {
        return binarySearch(array, 0, array.length, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.392 -0400", hash_original_method = "AEEEC8BFBB077FAE42FCA03B1FA50755", hash_generated_method = "2790F31A6347F9B14A24141CDA182D06")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.392 -0400", hash_original_method = "66D7F0846D72EFE08F25F15E2339BFFE", hash_generated_method = "BE1771EA0F006179C18C142A18A33FD6")
    public static int binarySearch(double[] array, double value) {
        return binarySearch(array, 0, array.length, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.392 -0400", hash_original_method = "DFA533AB240C3C67D07C47863082135D", hash_generated_method = "A24894081355CD46C0E8B5ACA35E21B4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.393 -0400", hash_original_method = "73828DC617856FC9A203FC462E1B8678", hash_generated_method = "A1A5C483C3A39E63749127E427F88451")
    public static int binarySearch(float[] array, float value) {
        return binarySearch(array, 0, array.length, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.393 -0400", hash_original_method = "AF7118C80FB68E58015CBBEDE5BFCF3D", hash_generated_method = "73EB95E987821BEC7E704B687A69AA47")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.393 -0400", hash_original_method = "10FAE7826DE6C7FA92370FA2DBE898D1", hash_generated_method = "9271C14F7C01A2A7226F67441954C6B7")
    public static int binarySearch(int[] array, int value) {
        return binarySearch(array, 0, array.length, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.393 -0400", hash_original_method = "01050E2BB1B59C59137C6D948F115373", hash_generated_method = "455935D1ABE4DD61D6A69E2B7013D3CD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.393 -0400", hash_original_method = "1E3F02592E9C9ED40FFDCAF3EF0E0C2B", hash_generated_method = "939A83A3FEDD02B1DF191D3461079495")
    public static int binarySearch(long[] array, long value) {
        return binarySearch(array, 0, array.length, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.393 -0400", hash_original_method = "76252A64BDCCB1FCE9F78F94C438C4DB", hash_generated_method = "57B05A66B38A91DFCB1A2AA3C8DBC68C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.393 -0400", hash_original_method = "E3D417998982E06151FF39AAEE4DA490", hash_generated_method = "BC31C7F295E0D9CC49849A154320934A")
    public static int binarySearch(Object[] array, Object value) {
        return binarySearch(array, 0, array.length, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.393 -0400", hash_original_method = "AC62DCBBB079682E75E581145CFFC517", hash_generated_method = "4C74D2CA55B542E30CE840B363A0AEE7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.393 -0400", hash_original_method = "2AEB5F2014DE8ABC00CA194E273A4FA3", hash_generated_method = "2F88113D8141B5C9722173AF3DD0ADCB")
    public static <T> int binarySearch(T[] array, T value, Comparator<? super T> comparator) {
        return binarySearch(array, 0, array.length, value, comparator);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.393 -0400", hash_original_method = "406091D7555B8A188A9915C6FFA52453", hash_generated_method = "DB3A1C8E5DF7CA65B9AC99A6175A7A5D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.393 -0400", hash_original_method = "1B11741F9AA29C21BB23748721F87958", hash_generated_method = "76D58326E2A244119B66D9C6A61C43CA")
    public static int binarySearch(short[] array, short value) {
        return binarySearch(array, 0, array.length, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.393 -0400", hash_original_method = "CBB47C186DC83A7CE83F653A8FA49FBE", hash_generated_method = "D46B55FCA393E42C9148A68EAFFCD8D1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.393 -0400", hash_original_method = "23AA60D248EBBCA086D18D3DB48A4C87", hash_generated_method = "7F187F0E88CA844AD6CFCB5A2601752E")
    private static void checkBinarySearchBounds(int startIndex, int endIndex, int length) {
        if (startIndex > endIndex) {
            throw new IllegalArgumentException();
        }
        if (startIndex < 0 || endIndex > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.393 -0400", hash_original_method = "B36EFEED8A01C5AB548445C2A30D3515", hash_generated_method = "AB254B7381DE3B17EA718AC261CF38C6")
    public static void fill(byte[] array, byte value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.393 -0400", hash_original_method = "9FD1A2E2343A7342F7CA850BC8948EC8", hash_generated_method = "AF3A54E7FF041881C4F9E8B06CF87E9A")
    public static void fill(byte[] array, int start, int end, byte value) {
        Arrays.checkStartAndEnd(array.length, start, end);
        for (int i = start; i < end; i++) {
            array[i] = value;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.393 -0400", hash_original_method = "0C56D37E9DF08871E792A0F50E2C2D13", hash_generated_method = "1CF19802A5E86A6D8957B67EF29CF63E")
    public static void fill(short[] array, short value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.393 -0400", hash_original_method = "9C63A043347A5856E259C40D0B092C8E", hash_generated_method = "406FE9C9ADC52D37C46B04541FF580EB")
    public static void fill(short[] array, int start, int end, short value) {
        Arrays.checkStartAndEnd(array.length, start, end);
        for (int i = start; i < end; i++) {
            array[i] = value;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.393 -0400", hash_original_method = "9B0DDD6C675DEF6700311B055DE9E01B", hash_generated_method = "A9299B19BB59DB39888BE5B675AC053F")
    public static void fill(char[] array, char value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.393 -0400", hash_original_method = "E9EBA1A345E6EC087EE2D65CFFC68545", hash_generated_method = "509B6A515B76550498F8ACB94D6F9894")
    public static void fill(char[] array, int start, int end, char value) {
        Arrays.checkStartAndEnd(array.length, start, end);
        for (int i = start; i < end; i++) {
            array[i] = value;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.393 -0400", hash_original_method = "1729B4B42F76884BCE9F1EB6E36424D7", hash_generated_method = "1141C52690BF47076EA68141B6C22013")
    public static void fill(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.394 -0400", hash_original_method = "CF4D8222D8388EE49D3DF4DFFECBAFE7", hash_generated_method = "48266E6E7D0F6013222BC8FE364E303A")
    public static void fill(int[] array, int start, int end, int value) {
        Arrays.checkStartAndEnd(array.length, start, end);
        for (int i = start; i < end; i++) {
            array[i] = value;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.394 -0400", hash_original_method = "8C25963DC1F5FD75F75FC8C46F2D8080", hash_generated_method = "2AECEAB147DF1422DFD870892004A44E")
    public static void fill(long[] array, long value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.394 -0400", hash_original_method = "A7E5E6D8B0352E19D2CAFB651CA3375F", hash_generated_method = "6CBDC8D77E8A0CBB5C04485ADF00FF9B")
    public static void fill(long[] array, int start, int end, long value) {
        Arrays.checkStartAndEnd(array.length, start, end);
        for (int i = start; i < end; i++) {
            array[i] = value;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.394 -0400", hash_original_method = "22CFEAA69588357DEEA1E52F95A64CA9", hash_generated_method = "50C71A9774937CB4C96DFB7BD77C5D4C")
    public static void fill(float[] array, float value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.394 -0400", hash_original_method = "E2DD3866058120BA248E0EBF124B1A36", hash_generated_method = "D16830E2241A31CF3EA28FD7BB070D36")
    public static void fill(float[] array, int start, int end, float value) {
        Arrays.checkStartAndEnd(array.length, start, end);
        for (int i = start; i < end; i++) {
            array[i] = value;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.394 -0400", hash_original_method = "DB9408C548BB70BC9C2AC261FCDA28D9", hash_generated_method = "1962DC9CA9457658A119FC983749DA2B")
    public static void fill(double[] array, double value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.394 -0400", hash_original_method = "24E580167A377C75EF9FE74DA27231DA", hash_generated_method = "D2CDCE8985EEA64376528B973FDA20A4")
    public static void fill(double[] array, int start, int end, double value) {
        Arrays.checkStartAndEnd(array.length, start, end);
        for (int i = start; i < end; i++) {
            array[i] = value;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.394 -0400", hash_original_method = "EF04E7E51A80342C344C8D19A9D97259", hash_generated_method = "D719B9A16FA27CBCE051E6C690CA6ED2")
    public static void fill(boolean[] array, boolean value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.394 -0400", hash_original_method = "9CD6B8DA260D9BA7ACF3634EA114A1DD", hash_generated_method = "ACBDA07FB96BD213D87D2BDC60BC03D5")
    public static void fill(boolean[] array, int start, int end, boolean value) {
        Arrays.checkStartAndEnd(array.length, start, end);
        for (int i = start; i < end; i++) {
            array[i] = value;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.394 -0400", hash_original_method = "61F6C031C06541C0A8BB46124B7DF1B0", hash_generated_method = "57B271DD17C53D9174EA5A7D77C69ED2")
    public static void fill(Object[] array, Object value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.394 -0400", hash_original_method = "79F0F9E2337864B3A25E38841319137B", hash_generated_method = "760DF7690E0B7EAD9ECBC86BAD1DE27E")
    public static void fill(Object[] array, int start, int end, Object value) {
        Arrays.checkStartAndEnd(array.length, start, end);
        for (int i = start; i < end; i++) {
            array[i] = value;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.394 -0400", hash_original_method = "2546D08E367F39B87276798E74E5F7C9", hash_generated_method = "8BB008E3FD92EB2E406FEAF23DE1BFB9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.394 -0400", hash_original_method = "4247337C364D75C5775B90327E437E02", hash_generated_method = "CD984584F502B1108563DC23CBB82712")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.394 -0400", hash_original_method = "8996E0EE964DF7503EEB7546D0171BC8", hash_generated_method = "8B15E33014C4C1250C77600C56C39135")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.394 -0400", hash_original_method = "CF34292E59B04B6D44737BA18E98D31E", hash_generated_method = "4E69F64F34B06B52A43E5B53E591DCBF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.394 -0400", hash_original_method = "0DAB329A34E0F771BA53A47F3CC85A85", hash_generated_method = "01C9A8EE1C3639BCC93F57735618B037")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.394 -0400", hash_original_method = "1372B3AF5C4A871F1477E5CFF59AA36C", hash_generated_method = "0C1597EEF8107EBEBFBF64B626E27464")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.394 -0400", hash_original_method = "5F64F0D4801047CFA52A927D58D47DFF", hash_generated_method = "32DCA0D36E44A7502B0A306DE2D8FA39")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.394 -0400", hash_original_method = "2ED6EC211AB050CE988E9C1E614165FC", hash_generated_method = "33F2014836D274923A7A71C35A91E520")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.394 -0400", hash_original_method = "179A8ECB8B9B61393E365C3DEC772A71", hash_generated_method = "1734914FAD1C698620650083D46C7152")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.394 -0400", hash_original_method = "DB95657D7B9BFF04F8AE75CCE334956B", hash_generated_method = "CE577603315572D2578507DB9ABC5061")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.394 -0400", hash_original_method = "3E4FA1262DE5E7DDD13BA987FBBE3E7F", hash_generated_method = "C360ED1B4A1E8B57DB03409CEEC5E1A5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.395 -0400", hash_original_method = "36525CF04D56B3E594DA28B5E31D5D17", hash_generated_method = "9E66340CD089F626729C874183CC494A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.395 -0400", hash_original_method = "734A4379046AFFEB9A4187E967041454", hash_generated_method = "4A3E227C5FF338AD6ED94C32D38C4F5B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.395 -0400", hash_original_method = "90AE32A316C2C8D81F960E0C17378875", hash_generated_method = "FD6CEFEAFF4B3525D8AD491A42D7B3D0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.395 -0400", hash_original_method = "85B9524033BC9A85EE51FE1FEA6AF837", hash_generated_method = "CEF27A2E6A9145AC480E41CF5E9BDF23")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.395 -0400", hash_original_method = "1E6C155141A1111F03DCDEAF3678F678", hash_generated_method = "E853A16D932FDC9525B58F2A0F907CD7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.395 -0400", hash_original_method = "153C3E9C5F203E79F5BF280F155C0AB0", hash_generated_method = "03C85F91D2C5A42823F86B81962DDED2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.395 -0400", hash_original_method = "C791C08846C114648457D3C0AD73339F", hash_generated_method = "AB8BBF1E4C36D7A38FB5B6C8304F0C39")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.395 -0400", hash_original_method = "418DF30233826B8D5F2BA83471599105", hash_generated_method = "D53850AD9234427781A798821AD9FA19")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.395 -0400", hash_original_method = "2BBB55550A5654C183C70F6E6AB7077D", hash_generated_method = "7B58E80526BDD8137E3E9C883F497646")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.395 -0400", hash_original_method = "BBDCB0D2AFB3FB09B2E81D11AD378107", hash_generated_method = "4FF602F398122F00281AB6E439B5CC4B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.395 -0400", hash_original_method = "F5AFF1E198BE400B38C78ACAF40C1324", hash_generated_method = "29FF8658B56EC4958407871B50FEDC52")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.395 -0400", hash_original_method = "E5BF1B41F12B83B703EDEDC6C20A8D2E", hash_generated_method = "10F8E2945ED87E2DEC22E9498B408452")
    public static void sort(byte[] array) {
        DualPivotQuicksort.sort(array);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.395 -0400", hash_original_method = "C91BF707E87558E2399AB2AABB697A59", hash_generated_method = "46294595859D7DA9E01CD79B48D0F31D")
    public static void sort(byte[] array, int start, int end) {
        DualPivotQuicksort.sort(array, start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.395 -0400", hash_original_method = "F4478C2D8B136FFA51B672714176E1DA", hash_generated_method = "01BC072697969B831885D7A03C404D43")
    public static void checkOffsetAndCount(int arrayLength, int offset, int count) {
        if ((offset | count) < 0 || offset > arrayLength || arrayLength - offset < count) {
            throw new ArrayIndexOutOfBoundsException(arrayLength, offset,
                    count);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.395 -0400", hash_original_method = "E4D2FA815A47A76C3AC4F451E8832ED4", hash_generated_method = "DA96F57F4DE904C94DA4A9CC39A04E62")
    public static void checkStartAndEnd(int len, int start, int end) {
        if (start < 0 || end > len) {
            throw new ArrayIndexOutOfBoundsException("start < 0 || end > len."
                    + " start=" + start + ", end=" + end + ", len=" + len);
        }
        if (start > end) {
            throw new IllegalArgumentException("start > end: " + start + " > " + end);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.395 -0400", hash_original_method = "49FEABF0AD0150DE31C3D1B1392EC32F", hash_generated_method = "C2AC3C6088B13DD2017B67031689708B")
    public static void sort(char[] array) {
        DualPivotQuicksort.sort(array);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.395 -0400", hash_original_method = "371BFA4DC1A016D782A781EAD4A3EDE2", hash_generated_method = "1C0A82A26D31EE8C406869302E86ACAA")
    public static void sort(char[] array, int start, int end) {
        DualPivotQuicksort.sort(array, start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.396 -0400", hash_original_method = "84A18C4D53BD41C8D2778E79004BC913", hash_generated_method = "77EF985B7D756EB16928287D57DF5D07")
    public static void sort(double[] array) {
        DualPivotQuicksort.sort(array);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.396 -0400", hash_original_method = "854A1C6650DA6DBAB9B14EA7DEF38592", hash_generated_method = "2A6FDDC8429443748543CCA6946C086B")
    public static void sort(double[] array, int start, int end) {
        DualPivotQuicksort.sort(array, start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.396 -0400", hash_original_method = "16C65FF0357F4E9D1D50699F331D8839", hash_generated_method = "D95D8F45336F14A82A0DA6D9E33416D0")
    public static void sort(float[] array) {
        DualPivotQuicksort.sort(array);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.396 -0400", hash_original_method = "AF6D58E0B54A03BD8558812B1E476809", hash_generated_method = "CFC5DD12E904BD82308FCAD44210EBB4")
    public static void sort(float[] array, int start, int end) {
        DualPivotQuicksort.sort(array, start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.396 -0400", hash_original_method = "D747170A7F04B613231E2142802ABE4F", hash_generated_method = "06E36CF176CAA6C02E3009ABCB7C47D7")
    public static void sort(int[] array) {
        DualPivotQuicksort.sort(array);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.396 -0400", hash_original_method = "0D7CECF6C48A29B817D7C281772463C0", hash_generated_method = "EEA5A91DD76296BEF0E6F5D639F41BA4")
    public static void sort(int[] array, int start, int end) {
        DualPivotQuicksort.sort(array, start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.396 -0400", hash_original_method = "E8E6CFFD56A04D652E5CCA11D468DE7D", hash_generated_method = "479C8E951B583B43B17A63B224C3E23F")
    public static void sort(long[] array) {
        DualPivotQuicksort.sort(array);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.396 -0400", hash_original_method = "B4C5BDF3B63061452DED86E729A4379E", hash_generated_method = "E437A036D13E6AAE362166992D5D101B")
    public static void sort(long[] array, int start, int end) {
        DualPivotQuicksort.sort(array, start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.396 -0400", hash_original_method = "2ABBA9721E6AA886F8B6CBB3EA3C6907", hash_generated_method = "DA076D4E62F231F8C5B69BFC1874CA6D")
    public static void sort(short[] array) {
        DualPivotQuicksort.sort(array);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.396 -0400", hash_original_method = "3DD87F91095A169C1E58894EFACAD9BC", hash_generated_method = "30733AE96453ACC928BA06D939F82551")
    public static void sort(short[] array, int start, int end) {
        DualPivotQuicksort.sort(array, start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.396 -0400", hash_original_method = "E4A046EBA329CB34ADB8348C19056859", hash_generated_method = "BA8A5F1F03DB979CE61190FBA9296E46")
    public static void sort(Object[] array) {
        ComparableTimSort.sort(array);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.396 -0400", hash_original_method = "4B0605E013E4E76992C5E6D06D85AB36", hash_generated_method = "D575D1FCB553A41729CC20B346E26273")
    public static void sort(Object[] array, int start, int end) {
        ComparableTimSort.sort(array, start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.396 -0400", hash_original_method = "D284DE4C83C0552601A0161E029592D5", hash_generated_method = "831B17222AECEC73F5354EF1506CA3A2")
    public static <T> void sort(T[] array, int start, int end, Comparator<? super T> comparator) {
        TimSort.sort(array, start, end, comparator);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.396 -0400", hash_original_method = "127171E3B6140C63B6F3D806D8D64B0F", hash_generated_method = "AB383DD1DEE4CDCE9CE8EBC52D082AC5")
    public static <T> void sort(T[] array, Comparator<? super T> comparator) {
        TimSort.sort(array, comparator);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.396 -0400", hash_original_method = "DF1A9D37DEA1814BE0A1BBD9C33C2E61", hash_generated_method = "622402968FDF43F5F4A3D6EBA98237B6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.396 -0400", hash_original_method = "497D7FD68D9DA1C21B948995B9C08123", hash_generated_method = "80B737CED8CABD4D5836ABBCA3038F3C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.396 -0400", hash_original_method = "0BD927898618E317DB698CC7205B2AB8", hash_generated_method = "6367B5C0721BBA2E45C089433B36ADE6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.396 -0400", hash_original_method = "954F4473C971E06E4D851CD45B56DB41", hash_generated_method = "E4DD420CCF21B174899357A65A0EF6B2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.396 -0400", hash_original_method = "05E92F8279F4AF4E4104C1FBFFCB09A5", hash_generated_method = "E519F131B1DB021D46D87168DA13DA08")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.396 -0400", hash_original_method = "A82D8AB8B553305192C164EB5888E1A5", hash_generated_method = "C77FC40DF01FB300C98F2C0D47064706")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.396 -0400", hash_original_method = "0BBBC9C5E8C44EFE67C0ED27FFEEE9BA", hash_generated_method = "2B7ADE6FB0D2B44E4B4C3C142370C8C7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.396 -0400", hash_original_method = "2A705CB7132FDFA84D44B25A472815FB", hash_generated_method = "F2E8E036F014D440E81326985210AC11")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.396 -0400", hash_original_method = "4659354346ED12C20B39DE6F57548D0B", hash_generated_method = "01D32014C4AD9B493003B0C1B46CED8F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.397 -0400", hash_original_method = "A9E20A49559B5F7B4C63C87BC2AD7AEE", hash_generated_method = "07D9E5F7F398622F2AB422FA32FE73BC")
    public static String deepToString(Object[] array) {
        if (array == null) {
            return "null";
        }
        StringBuilder buf = new StringBuilder(array.length * 9);
        deepToStringImpl(array, new Object[] { array }, buf);
        return buf.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.397 -0400", hash_original_method = "775EF6CABB5AD5EA80F9890FB88BA9F1", hash_generated_method = "364A8C38FD10900977F69C728F7432B3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.397 -0400", hash_original_method = "A2425CE786319C2459A6785F99986BBA", hash_generated_method = "8FDF15EC344C672839A8351DECEC37E7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.397 -0400", hash_original_method = "EEFE4CF8E72C2451CD6574BC42EEF616", hash_generated_method = "80FB277279A07A1BE58ACB083AE0166F")
    public static boolean[] copyOf(boolean[] original, int newLength) {
        if (newLength < 0) {
            throw new NegativeArraySizeException();
        }
        return copyOfRange(original, 0, newLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.397 -0400", hash_original_method = "9ECE64D6C44CCCD3CA2F4FAD7A67037A", hash_generated_method = "68975492B4B8C3482F024332FBAC1B64")
    public static byte[] copyOf(byte[] original, int newLength) {
        if (newLength < 0) {
            throw new NegativeArraySizeException();
        }
        return copyOfRange(original, 0, newLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.397 -0400", hash_original_method = "BEEFDE40BF0B812C3EC81F5AA7FF19C2", hash_generated_method = "A9B78EA0B359E7A52A91D91BADC7D1D4")
    public static char[] copyOf(char[] original, int newLength) {
        if (newLength < 0) {
            throw new NegativeArraySizeException();
        }
        return copyOfRange(original, 0, newLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.397 -0400", hash_original_method = "0344866F84B86AB5E9951BBEBE8DF7CF", hash_generated_method = "29D05D4ABCCFC48B4AC3D23A39A60A4F")
    public static double[] copyOf(double[] original, int newLength) {
        if (newLength < 0) {
            throw new NegativeArraySizeException();
        }
        return copyOfRange(original, 0, newLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.397 -0400", hash_original_method = "274DB8BA8EB7DE2FB860E7A8F4EB4CC5", hash_generated_method = "4B37021DD915AA40FBA77AED500139D5")
    public static float[] copyOf(float[] original, int newLength) {
        if (newLength < 0) {
            throw new NegativeArraySizeException();
        }
        return copyOfRange(original, 0, newLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.397 -0400", hash_original_method = "410F54B03DF6190A84943E9E1D03989F", hash_generated_method = "3D9F4FE87F8C2297E41DFECC3C8577A4")
    public static int[] copyOf(int[] original, int newLength) {
        if (newLength < 0) {
            throw new NegativeArraySizeException();
        }
        return copyOfRange(original, 0, newLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.397 -0400", hash_original_method = "3343CDB162AFA47FA49580605A57EDA3", hash_generated_method = "2A191A2B3DB991AC86CA0C3E75588B58")
    public static long[] copyOf(long[] original, int newLength) {
        if (newLength < 0) {
            throw new NegativeArraySizeException();
        }
        return copyOfRange(original, 0, newLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.397 -0400", hash_original_method = "DD9D7EA34F4A6424E4EB64114A9DD79C", hash_generated_method = "D2B56992E2A35D3C87F53536C09F94A6")
    public static short[] copyOf(short[] original, int newLength) {
        if (newLength < 0) {
            throw new NegativeArraySizeException();
        }
        return copyOfRange(original, 0, newLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.397 -0400", hash_original_method = "791D1DBBC2DC7492A22FE486AA3A706B", hash_generated_method = "66F928B57C2B7BD9B3FD892B3544A65E")
    public static <T> T[] copyOf(T[] original, int newLength) {
        if (original == null) {
            throw new NullPointerException();
        }
        if (newLength < 0) {
            throw new NegativeArraySizeException();
        }
        return copyOfRange(original, 0, newLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.397 -0400", hash_original_method = "11E41D8DD4828E62EC19B48A26A090C8", hash_generated_method = "349DB56FC37F07B6EDD65710C3E258C0")
    public static <T, U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
        if (newLength < 0) {
            throw new NegativeArraySizeException();
        }
        return copyOfRange(original, 0, newLength, newType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.397 -0400", hash_original_method = "F502B9EC75335D4F5735070162DD7C3C", hash_generated_method = "4E25A19B709CDFDA3155D74A7EC6F6C9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.397 -0400", hash_original_method = "8F0CC874ECACCB04EB7CA2CFC3E48655", hash_generated_method = "05BB15D077B8441F3559723A5D6087AD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.397 -0400", hash_original_method = "91CE694A0D2E577C530BE629F92B8EF0", hash_generated_method = "B16AB5F5FFF9B0CF11239BEB6B6B10EC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.397 -0400", hash_original_method = "7933ED1507BF980E20F5A9C8C4695C51", hash_generated_method = "133B58F008D57286686B0D8F944842C8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.398 -0400", hash_original_method = "01867581602B5B044213DAECE2F1D1A8", hash_generated_method = "A49D9C4950BDE090192F8BDA156A6471")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.398 -0400", hash_original_method = "7B36D32E8B026BA3BC24987851E5FB75", hash_generated_method = "C0DAD15D215B7C170326DE9C95A801D5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.398 -0400", hash_original_method = "A34132FCEEB936A432F684C9C10320B5", hash_generated_method = "F1BCB638233CBB2A04705ADDC85AAB59")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.398 -0400", hash_original_method = "BA02812AC7ABCCE3BD17A25110563368", hash_generated_method = "1CF2C11C3DB834451A65152365A5B5A8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.398 -0400", hash_original_method = "E81B7CFBA2F00165072E5559EF747233", hash_generated_method = "89CFF840B9D24DB16EB9F6F9BEDD7992")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.398 -0400", hash_original_method = "92FCE676D7D0FA16FAD4FB3F671C6F64", hash_generated_method = "B3FE6D4B428271AD3747DD546FEF733B")
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
        private static final long serialVersionUID = -2764017481108945198L;
        private final E[] a;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.398 -0400", hash_original_method = "28401D48F15218543E5E002CE4B26D15", hash_generated_method = "52361163B9EA006D94A470CF0C4DF91A")
        @DSModeled(DSC.SAFE)
         ArrayList(E[] storage) {
            dsTaint.addTaint(storage[0].dsTaint);
            if (DroidSafeAndroidRuntime.control) {
                throw new NullPointerException();
            } //End block
            // ---------- Original Method ----------
            //if (storage == null) {
                //throw new NullPointerException();
            //}
            a = storage;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.398 -0400", hash_original_method = "60C2CE78869B52DAF166079897D78161", hash_generated_method = "B5F7939250EAF5709AD7D91053A0D9CC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                {
                    E element = a[0];
                    {
                        {
                            boolean var97B4224D5E3FF3963F495EAD32377EDA_1023440789 = (object.equals(element));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    E element = a[0];
                } //End collapsed parenthetic
            } //End block
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.398 -0400", hash_original_method = "2292A4CE789907EDD632B4A1EB11E4D2", hash_generated_method = "899E6AE1474D84E00EFA41AB39A488FF")
        @DSModeled(DSC.SAFE)
        @Override
        public E get(int location) {
            dsTaint.addTaint(location);
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //try {
                //return a[location];
            //} catch (ArrayIndexOutOfBoundsException e) {
                //throw java.util.ArrayList.throwIndexOutOfBoundsException(location, a.length);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.398 -0400", hash_original_method = "2A691ADB93209815384C011B6281A9FB", hash_generated_method = "9C08DDE6FF3700A74B775E30AC9A6CD9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int indexOf(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                {
                    int i;
                    i = 0;
                    {
                        {
                            boolean var6683716CAAF219D7EC79AD371A9177DA_1405962177 = (object.equals(a[i]));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    int i;
                    i = 0;
                } //End collapsed parenthetic
            } //End block
            return dsTaint.getTaintInt();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.399 -0400", hash_original_method = "0667C423DABE9154AC3C7F87378CA39A", hash_generated_method = "9B6B6A57444253F1CB03F7E981211174")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int lastIndexOf(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                {
                    int i;
                    i = a.length - 1;
                    {
                        {
                            boolean var6683716CAAF219D7EC79AD371A9177DA_2013540892 = (object.equals(a[i]));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    int i;
                    i = a.length - 1;
                } //End collapsed parenthetic
            } //End block
            return dsTaint.getTaintInt();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.399 -0400", hash_original_method = "34158A3678F4541935DDD01AA8496683", hash_generated_method = "688B6D70968A01DF112EDA379A454F07")
        @DSModeled(DSC.SAFE)
        @Override
        public E set(int location, E object) {
            dsTaint.addTaint(location);
            dsTaint.addTaint(object.dsTaint);
            E result;
            result = a[location];
            a[location] = object;
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //E result = a[location];
            //a[location] = object;
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.399 -0400", hash_original_method = "E1955A04BFD4754737F2A0E48B09DBE4", hash_generated_method = "179827E282FA7D12483C640432BA888F")
        @DSModeled(DSC.SAFE)
        @Override
        public int size() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return a.length;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.399 -0400", hash_original_method = "4819818080CBECF7C6E758DFD111EA84", hash_generated_method = "F85F97F7C6CABF338432FF2B2CBD65E8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object[] toArray() {
            Object[] varBBB654220CACE186AC13E44BA5965F5E_307332838 = (a.clone());
            return (Object[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return a.clone();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.399 -0400", hash_original_method = "7C6C61B0D92D6FAC6E5A876622A28815", hash_generated_method = "C90BFFF218D96450606BB5E73B4B7098")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        @SuppressWarnings({"unchecked", "SuspiciousSystemArraycopy"})
        public <T> T[] toArray(T[] contents) {
            dsTaint.addTaint(contents[0].dsTaint);
            int size;
            size = size();
            {
                Class<?> ct;
                ct = contents.getClass().getComponentType();
                contents = (T[]) Array.newInstance(ct, size);
            } //End block
            System.arraycopy(a, 0, contents, 0, size);
            {
                contents[size] = null;
            } //End block
            return (T[])dsTaint.getTaint();
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

        
    }


    
}


