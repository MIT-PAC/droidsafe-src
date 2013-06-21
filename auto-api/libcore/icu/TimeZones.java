package libcore.icu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import libcore.util.BasicLruCache;

public final class TimeZones {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.754 -0400", hash_original_method = "A05C4975F009B050E4723CBEC63CF03D", hash_generated_method = "A3706FB06655BF7A8E96F021B21E6A98")
    @DSModeled(DSC.SAFE)
    private TimeZones() {
        // ---------- Original Method ----------
    }

    
        public static String getDisplayName(String[][] zoneStrings, String id, boolean daylight, int style) {
        String[] needle = new String[] { id };
        int index = Arrays.binarySearch(zoneStrings, needle, ZONE_STRINGS_COMPARATOR);
        if (index >= 0) {
            String[] row = zoneStrings[index];
            if (daylight) {
                return (style == TimeZone.LONG) ? row[LONG_NAME_DST] : row[SHORT_NAME_DST];
            } else {
                return (style == TimeZone.LONG) ? row[LONG_NAME] : row[SHORT_NAME];
            }
        }
        return null;
    }

    
        public static String[][] getZoneStrings(Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return cachedZoneStrings.get(locale);
    }

    
        public static String[] forLocale(Locale locale) {
        return forCountryCode(locale.getCountry());
    }

    
        private static String[] forCountryCode(String countryCode) {
        String[] retVal = {DSUtils.UNKNOWN_STRING};
        return retVal;
    }

    
        private static String[][] getZoneStringsImpl(String locale, String[] timeZoneIds) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    public static class ZoneStringsCache extends BasicLruCache<Locale, String[][]> {
        private HashMap<String, String> internTable = new HashMap<String, String>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.755 -0400", hash_original_method = "8CBB117BE999E006B1D5CB712A559541", hash_generated_method = "5B341770CB1D4B88A6CBDF9D4F397CBB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ZoneStringsCache() {
            super(availableTimeZones.length);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.755 -0400", hash_original_method = "6F2D0ECC0E2349A3B7CCB8E5434A3F26", hash_generated_method = "C6C3FE0053C33012AE7249E748910E7E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected String[][] create(Locale locale) {
            dsTaint.addTaint(locale.dsTaint);
            long start, nativeStart;
            start = nativeStart = System.currentTimeMillis();
            String[][] result;
            result = getZoneStringsImpl(locale.toString(), availableTimeZones);
            long nativeEnd;
            nativeEnd = System.currentTimeMillis();
            internStrings(result);
            long end;
            end = System.currentTimeMillis();
            long duration;
            duration = end - start;
            long nativeDuration;
            nativeDuration = nativeEnd - nativeStart;
            System.logI("Loaded time zone names for " + locale + " in " + duration + "ms" +
                    " (" + nativeDuration + "ms in ICU)");
            return (String[][])dsTaint.getTaint();
            // ---------- Original Method ----------
            //long start, nativeStart;
            //start = nativeStart = System.currentTimeMillis();
            //String[][] result = getZoneStringsImpl(locale.toString(), availableTimeZones);
            //long nativeEnd = System.currentTimeMillis();
            //internStrings(result);
            //long end = System.currentTimeMillis();
            //long duration = end - start;
            //long nativeDuration = nativeEnd - nativeStart;
            //System.logI("Loaded time zone names for " + locale + " in " + duration + "ms" +
                    //" (" + nativeDuration + "ms in ICU)");
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.755 -0400", hash_original_method = "B8ADCF3091CCD0EA103D9032F8613DD2", hash_generated_method = "CFE946AC47043F57D4D9B34B5596B349")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private synchronized void internStrings(String[][] result) {
            dsTaint.addTaint(result[0][0]);
            {
                int i;
                i = 0;
                {
                    {
                        int j;
                        j = 1;
                        {
                            String original;
                            original = result[i][j];
                            String nonDuplicate;
                            nonDuplicate = internTable.get(original);
                            {
                                internTable.put(original, original);
                            } //End block
                            {
                                result[i][j] = nonDuplicate;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //for (int i = 0; i < result.length; ++i) {
                //for (int j = 1; j < NAME_COUNT; ++j) {
                    //String original = result[i][j];
                    //String nonDuplicate = internTable.get(original);
                    //if (nonDuplicate == null) {
                        //internTable.put(original, original);
                    //} else {
                        //result[i][j] = nonDuplicate;
                    //}
                //}
            //}
        }

        
    }


    
    private static final String[] availableTimeZones = TimeZone.getAvailableIDs();
    public static final int OLSON_NAME = 0;
    public static final int LONG_NAME = 1;
    public static final int SHORT_NAME = 2;
    public static final int LONG_NAME_DST = 3;
    public static final int SHORT_NAME_DST = 4;
    public static final int NAME_COUNT = 5;
    private static final ZoneStringsCache cachedZoneStrings = new ZoneStringsCache();
    static {
        cachedZoneStrings.get(Locale.ROOT);
        cachedZoneStrings.get(Locale.US);
        cachedZoneStrings.get(Locale.getDefault());
    }
    
    private static final Comparator<String[]> ZONE_STRINGS_COMPARATOR = new Comparator<String[]>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.756 -0400", hash_original_method = "78D6A50B25B700B049CBB3B10CFB6A69", hash_generated_method = "78438610120BA873391BCE1E47D18B49")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int compare(String[] lhs, String[] rhs) {
            dsTaint.addTaint(rhs[0]);
            dsTaint.addTaint(lhs[0]);
            int var42A7CE75D9634A77D0F9C98CADB948CE_1525676355 = (lhs[OLSON_NAME].compareTo(rhs[OLSON_NAME]));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return lhs[OLSON_NAME].compareTo(rhs[OLSON_NAME]);
        }

        
}; //Transformed anonymous class
}

