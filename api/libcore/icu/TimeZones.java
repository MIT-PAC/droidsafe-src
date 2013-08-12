package libcore.icu;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

import libcore.util.BasicLruCache;





public final class TimeZones {
    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.901 -0400", hash_original_method = "A05C4975F009B050E4723CBEC63CF03D", hash_generated_method = "A3706FB06655BF7A8E96F021B21E6A98")
    private  TimeZones() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static String[][] getZoneStrings(Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return cachedZoneStrings.get(locale);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    public static class ZoneStringsCache extends BasicLruCache<Locale, String[][]> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.903 -0400", hash_original_field = "57BDEC03B61EAA1FFA44BC33B6805298", hash_generated_field = "97D44B3A373BF0B0AA4AFE0CA5B27D71")

        private final HashMap<String, String> internTable = new HashMap<String, String>();
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.903 -0400", hash_original_method = "8CBB117BE999E006B1D5CB712A559541", hash_generated_method = "5B341770CB1D4B88A6CBDF9D4F397CBB")
        public  ZoneStringsCache() {
            super(availableTimeZones.length);
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.903 -0400", hash_original_method = "6F2D0ECC0E2349A3B7CCB8E5434A3F26", hash_generated_method = "D45BF04BD3E56808F8598B8319932A95")
        @Override
        protected String[][] create(Locale locale) {
            addTaint(locale.getTaint());
            long start;
            long nativeStart;
            start = nativeStart = System.currentTimeMillis();
            String[][] result = getZoneStringsImpl(locale.toString(), availableTimeZones);
            long nativeEnd = System.currentTimeMillis();
            internStrings(result);
            long end = System.currentTimeMillis();
            long duration = end - start;
            long nativeDuration = nativeEnd - nativeStart;
            System.logI("Loaded time zone names for " + locale + " in " + duration + "ms" +
                    " (" + nativeDuration + "ms in ICU)");
String[][] varDC838461EE2FA0CA4C9BBB70A15456B0_1069865706 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1069865706.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1069865706;
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

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.904 -0400", hash_original_method = "B8ADCF3091CCD0EA103D9032F8613DD2", hash_generated_method = "5A7ADE4AA1DECADF6175D595B59ABCD6")
        private synchronized void internStrings(String[][] result) {
            addTaint(result[0][0].getTaint());
for(int i = 0;i < result.length;++i)
            {
for(int j = 1;j < NAME_COUNT;++j)
                {
                    String original = result[i][j];
                    String nonDuplicate = internTable.get(original);
                    if(nonDuplicate == null)                    
                    {
                        internTable.put(original, original);
                    } //End block
                    else
                    {
                        result[i][j] = nonDuplicate;
                    } //End block
                } //End block
            } //End block
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.904 -0400", hash_original_field = "95270548D8F931580A6725807CE0DFE9", hash_generated_field = "19D5663E9EA33416D4EF36ECC0AAEC15")

    private static final String[] availableTimeZones = TimeZone.getAvailableIDs();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.904 -0400", hash_original_field = "08C2DBC8CE4D87024470BEFA861800F9", hash_generated_field = "8F371653837F1507B414281936EB3848")

    public static final int OLSON_NAME = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.904 -0400", hash_original_field = "1A6FEA05FA2009D641800829E13918E2", hash_generated_field = "E15F8D99C998A71DC1698E1F52465854")

    public static final int LONG_NAME = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.904 -0400", hash_original_field = "410FA0E8241CD0CBA10434F0F995487D", hash_generated_field = "78190E4FB26A2DA66B946210A944690C")

    public static final int SHORT_NAME = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.904 -0400", hash_original_field = "D57860260244A8FE2BA2FD5B1E018C97", hash_generated_field = "F22EA3730CBA037C4C99C5C3536E239F")

    public static final int LONG_NAME_DST = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.905 -0400", hash_original_field = "FDB6FB91A094DF009929513E28203EBA", hash_generated_field = "109BD5FE446B91FBDBA1AB38919D9822")

    public static final int SHORT_NAME_DST = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.905 -0400", hash_original_field = "A8A8C79B68B42FE072F3AE6C899731CE", hash_generated_field = "DF831337D7DC0E3BC679299C55486ED8")

    public static final int NAME_COUNT = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.905 -0400", hash_original_field = "58F8DB2959B00EE1F9B553FC40F46DA9", hash_generated_field = "829D32F7C8B866FE3E358BF89DC3666E")

    private static final ZoneStringsCache cachedZoneStrings = new ZoneStringsCache();
    static {
        cachedZoneStrings.get(Locale.ROOT);
        cachedZoneStrings.get(Locale.US);
        cachedZoneStrings.get(Locale.getDefault());
    }
    
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
}

