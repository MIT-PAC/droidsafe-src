package libcore.icu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import libcore.util.BasicLruCache;

public final class TimeZones {
    private static final String[] availableTimeZones = TimeZone.getAvailableIDs();
    public static final int OLSON_NAME = 0;
    public static final int LONG_NAME = 1;
    public static final int SHORT_NAME = 2;
    public static final int LONG_NAME_DST = 3;
    public static final int SHORT_NAME_DST = 4;
    public static final int NAME_COUNT = 5;
    private static final ZoneStringsCache cachedZoneStrings = new ZoneStringsCache();
    private static final Comparator<String[]> ZONE_STRINGS_COMPARATOR = new Comparator<String[]>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.427 -0400", hash_original_method = "78D6A50B25B700B049CBB3B10CFB6A69", hash_generated_method = "28D96A0A07DBC201C40CF3ABAE27D66D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int compare(String[] lhs, String[] rhs) {
            dsTaint.addTaint(rhs);
            dsTaint.addTaint(lhs);
            int var42A7CE75D9634A77D0F9C98CADB948CE_79378796 = (lhs[OLSON_NAME].compareTo(rhs[OLSON_NAME]));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return lhs[OLSON_NAME].compareTo(rhs[OLSON_NAME]);
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.427 -0400", hash_original_method = "A05C4975F009B050E4723CBEC63CF03D", hash_generated_method = "E1765EF2F348F33FCA6E2122B88E20B3")
    @DSModeled(DSC.SAFE)
    private TimeZones() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.427 -0400", hash_original_method = "CC9A44865472DDCD46A6BDC9068D8F5A", hash_generated_method = "CF7986F68726128BC7A16E2366695758")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.427 -0400", hash_original_method = "DF8DCB122814848FD6878CF621D94106", hash_generated_method = "A808D0A1838322258219AB2F1848ED5E")
    public static String[][] getZoneStrings(Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return cachedZoneStrings.get(locale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.427 -0400", hash_original_method = "7E9F59302235A7D0B845D6D175C9DBE6", hash_generated_method = "60C99D34C8ECCB1BE065D8D35CAF2D6D")
    public static String[] forLocale(Locale locale) {
        return forCountryCode(locale.getCountry());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.427 -0400", hash_original_method = "2293CF188C457515355A158905168E4D", hash_generated_method = "6644788B946E8A1F537705C1F9D2CEA0")
    private static String[] forCountryCode(String countryCode) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.427 -0400", hash_original_method = "2F5AD73BE20F62D72422B418477C0950", hash_generated_method = "108857D5AD2D5CA09C1CAF5693F6BB96")
    private static String[][] getZoneStringsImpl(String locale, String[] timeZoneIds) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    public static class ZoneStringsCache extends BasicLruCache<Locale, String[][]> {
        private final HashMap<String, String> internTable = new HashMap<String, String>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.427 -0400", hash_original_method = "8CBB117BE999E006B1D5CB712A559541", hash_generated_method = "7F5B02B66E22D0C6005260DAADFFB556")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ZoneStringsCache() {
            super(availableTimeZones.length);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.427 -0400", hash_original_method = "6F2D0ECC0E2349A3B7CCB8E5434A3F26", hash_generated_method = "20946D6524C4C4973505BC0914B71CFB")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.427 -0400", hash_original_method = "B8ADCF3091CCD0EA103D9032F8613DD2", hash_generated_method = "8F848F9DDE706BE1CC885E6E01293503")
        @DSModeled(DSC.SAFE)
        private synchronized void internStrings(String[][] result) {
            dsTaint.addTaint(result.dsTaint);
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


    
    static {
        cachedZoneStrings.get(Locale.ROOT);
        cachedZoneStrings.get(Locale.US);
        cachedZoneStrings.get(Locale.getDefault());
    }
    
}


