package libcore.icu;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

import libcore.util.BasicLruCache;





public final class TimeZones {

    /**
     * Returns the appropriate string from 'zoneStrings'. Used with getZoneStrings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.124 -0500", hash_original_method = "CC9A44865472DDCD46A6BDC9068D8F5A", hash_generated_method = "CF7986F68726128BC7A16E2366695758")
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

    /**
     * Returns an array of time zone strings, as used by DateFormatSymbols.getZoneStrings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.125 -0500", hash_original_method = "DF8DCB122814848FD6878CF621D94106", hash_generated_method = "A808D0A1838322258219AB2F1848ED5E")
    public static String[][] getZoneStrings(Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return cachedZoneStrings.get(locale);
    }

    /**
     * Returns an array containing the time zone ids in use in the country corresponding to
     * the given locale. This is not necessary for Java API, but is used by telephony as a
     * fallback.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.126 -0500", hash_original_method = "7E9F59302235A7D0B845D6D175C9DBE6", hash_generated_method = "60C99D34C8ECCB1BE065D8D35CAF2D6D")
    public static String[] forLocale(Locale locale) {
        return forCountryCode(locale.getCountry());
    }

    
    @DSModeled(DSC.SAFE)
    private static String[] forCountryCode(String countryCode) {
    	String [] ret = {new String()};
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    private static String[][] getZoneStringsImpl(String locale, String[] timeZoneIds) {
    	String [][] ret = {{new String()}};
    	return ret;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.109 -0500", hash_original_field = "E0F8A71B13086197AEBF93B8EACC6C14", hash_generated_field = "19D5663E9EA33416D4EF36ECC0AAEC15")

    private static final String[] availableTimeZones = TimeZone.getAvailableIDs();

    
    public static class ZoneStringsCache extends BasicLruCache<Locale, String[][]> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.117 -0500", hash_original_field = "DD96F2687F690592597F29FD443B8EAF", hash_generated_field = "97D44B3A373BF0B0AA4AFE0CA5B27D71")

        private final HashMap<String, String> internTable = new HashMap<String, String>();

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.118 -0500", hash_original_method = "8CBB117BE999E006B1D5CB712A559541", hash_generated_method = "B89F895A69615BFFCCA3C4E0CE9F0729")
        public ZoneStringsCache() {
            // We make room for all the time zones known to the system, since each set of strings
            // isn't particularly large (and we remove duplicates), but is currently (Honeycomb)
            // really expensive to compute.
            // If you change this, you might want to change the scope of the intern table too.
            super(availableTimeZones.length);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.119 -0500", hash_original_method = "6F2D0ECC0E2349A3B7CCB8E5434A3F26", hash_generated_method = "011A7E4C34226BDB03AA4A172E6151A0")
        @Override
protected String[][] create(Locale locale) {
            long start, nativeStart;
            start = nativeStart = System.currentTimeMillis();
            String[][] result = getZoneStringsImpl(locale.toString(), availableTimeZones);
            long nativeEnd = System.currentTimeMillis();
            internStrings(result);
            // Ending up in this method too often is an easy way to make your app slow, so we ensure
            // it's easy to tell from the log (a) what we were doing, (b) how long it took, and
            // (c) that it's all ICU's fault.
            long end = System.currentTimeMillis();
            long duration = end - start;
            long nativeDuration = nativeEnd - nativeStart;
            System.logI("Loaded time zone names for " + locale + " in " + duration + "ms" +
                    " (" + nativeDuration + "ms in ICU)");
            return result;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.120 -0500", hash_original_method = "B8ADCF3091CCD0EA103D9032F8613DD2", hash_generated_method = "AF9E956730F1442D3F67FF2610B87FA7")
        private synchronized void internStrings(String[][] result) {
            for (int i = 0; i < result.length; ++i) {
                for (int j = 1; j < NAME_COUNT; ++j) {
                    String original = result[i][j];
                    String nonDuplicate = internTable.get(original);
                    if (nonDuplicate == null) {
                        internTable.put(original, original);
                    } else {
                        result[i][j] = nonDuplicate;
                    }
                }
            }
        }

        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.110 -0500", hash_original_field = "7E5F2978A9F76A969CD637C3D8BB2DA4", hash_generated_field = "8F371653837F1507B414281936EB3848")

    public static final int OLSON_NAME = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.111 -0500", hash_original_field = "E0DAA85FB8508DEE47CC1FC45B628477", hash_generated_field = "E15F8D99C998A71DC1698E1F52465854")

    public static final int LONG_NAME = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.112 -0500", hash_original_field = "FF9C7C421B16C5EF9D970D14700E74F3", hash_generated_field = "78190E4FB26A2DA66B946210A944690C")

    public static final int SHORT_NAME = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.113 -0500", hash_original_field = "0BCB5CB5D2172F14F6C091C2F207A3D5", hash_generated_field = "F22EA3730CBA037C4C99C5C3536E239F")

    public static final int LONG_NAME_DST = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.114 -0500", hash_original_field = "34CB59E907761C916E7AEC21913C11C0", hash_generated_field = "109BD5FE446B91FBDBA1AB38919D9822")

    public static final int SHORT_NAME_DST = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.115 -0500", hash_original_field = "88D629BD5381467845B607768D9F8993", hash_generated_field = "DF831337D7DC0E3BC679299C55486ED8")

    public static final int NAME_COUNT = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.115 -0500", hash_original_field = "3B52FB6330C02F742B208C1D56F39870", hash_generated_field = "829D32F7C8B866FE3E358BF89DC3666E")


    private static final ZoneStringsCache cachedZoneStrings = new ZoneStringsCache();
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.765 -0400", hash_original_field = "F3D1D931D6D8ABAB0784456286AA6490", hash_generated_field = "20A59513D44FA082881D368B3B779D6D")

    private static final Comparator<String[]> ZONE_STRINGS_COMPARATOR = new Comparator<String[]>() {        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.765 -0400", hash_original_method = "78D6A50B25B700B049CBB3B10CFB6A69", hash_generated_method = "BB7DD2368C24C50BAD92DE238733B79C")
        public int compare(String[] lhs, String[] rhs) {
            int var42A7CE75D9634A77D0F9C98CADB948CE_1083735524 = (lhs[OLSON_NAME].compareTo(rhs[OLSON_NAME]));
            addTaint(lhs[0].getTaint());
            addTaint(rhs[0].getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_36081911 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_36081911;
            
            
        }

        
};
    static {
        cachedZoneStrings.get(Locale.ROOT);
        cachedZoneStrings.get(Locale.US);
        cachedZoneStrings.get(Locale.getDefault());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.123 -0500", hash_original_method = "A05C4975F009B050E4723CBEC63CF03D", hash_generated_method = "D7DAFEA01BE01920EF3D08C54FD34329")
    private TimeZones() {}
}

