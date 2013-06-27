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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.183 -0400", hash_original_method = "A05C4975F009B050E4723CBEC63CF03D", hash_generated_method = "A3706FB06655BF7A8E96F021B21E6A98")
    private  TimeZones() {
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
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static String[][] getZoneStringsImpl(String locale, String[] timeZoneIds) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    public static class ZoneStringsCache extends BasicLruCache<Locale, String[][]> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.184 -0400", hash_original_field = "57BDEC03B61EAA1FFA44BC33B6805298", hash_generated_field = "6420ABEF54F75A7C79EBA710DAECE745")

        private HashMap<String, String> internTable = new HashMap<String, String>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.184 -0400", hash_original_method = "8CBB117BE999E006B1D5CB712A559541", hash_generated_method = "5B341770CB1D4B88A6CBDF9D4F397CBB")
        public  ZoneStringsCache() {
            super(availableTimeZones.length);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.185 -0400", hash_original_method = "6F2D0ECC0E2349A3B7CCB8E5434A3F26", hash_generated_method = "036F0EEBA2E42C722A701836C5172554")
        @Override
        protected String[][] create(Locale locale) {
            String[][] varB4EAC82CA7396A68D541C85D26508E83_1622420783 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_1622420783 = result;
            addTaint(locale.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1622420783.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1622420783;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.189 -0400", hash_original_method = "B8ADCF3091CCD0EA103D9032F8613DD2", hash_generated_method = "A5E4D77A945B6A0C53A4229CD2C7C884")
        private synchronized void internStrings(String[][] result) {
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
            addTaint(result[0][0].getTaint());
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.196 -0400", hash_original_field = "95270548D8F931580A6725807CE0DFE9", hash_generated_field = "FA2D73148AA85DF7182FD2217E3CA139")

    private static String[] availableTimeZones = TimeZone.getAvailableIDs();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.196 -0400", hash_original_field = "08C2DBC8CE4D87024470BEFA861800F9", hash_generated_field = "8F371653837F1507B414281936EB3848")

    public static final int OLSON_NAME = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.196 -0400", hash_original_field = "1A6FEA05FA2009D641800829E13918E2", hash_generated_field = "E15F8D99C998A71DC1698E1F52465854")

    public static final int LONG_NAME = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.196 -0400", hash_original_field = "410FA0E8241CD0CBA10434F0F995487D", hash_generated_field = "78190E4FB26A2DA66B946210A944690C")

    public static final int SHORT_NAME = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.196 -0400", hash_original_field = "D57860260244A8FE2BA2FD5B1E018C97", hash_generated_field = "F22EA3730CBA037C4C99C5C3536E239F")

    public static final int LONG_NAME_DST = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.196 -0400", hash_original_field = "FDB6FB91A094DF009929513E28203EBA", hash_generated_field = "109BD5FE446B91FBDBA1AB38919D9822")

    public static final int SHORT_NAME_DST = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.196 -0400", hash_original_field = "A8A8C79B68B42FE072F3AE6C899731CE", hash_generated_field = "DF831337D7DC0E3BC679299C55486ED8")

    public static final int NAME_COUNT = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.196 -0400", hash_original_field = "58F8DB2959B00EE1F9B553FC40F46DA9", hash_generated_field = "6F48DF4771C3CC3E1545ABD55AF30988")

    private static ZoneStringsCache cachedZoneStrings = new ZoneStringsCache();
    static {
        cachedZoneStrings.get(Locale.ROOT);
        cachedZoneStrings.get(Locale.US);
        cachedZoneStrings.get(Locale.getDefault());
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.197 -0400", hash_original_field = "F3D1D931D6D8ABAB0784456286AA6490", hash_generated_field = "B3554AED32545BA8AFD11B684591F57C")

    private static Comparator<String[]> ZONE_STRINGS_COMPARATOR = new Comparator<String[]>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.197 -0400", hash_original_method = "78D6A50B25B700B049CBB3B10CFB6A69", hash_generated_method = "0AB52C32EA7ADCCD003D556E83DB95D7")
        public int compare(String[] lhs, String[] rhs) {
            int var42A7CE75D9634A77D0F9C98CADB948CE_889336392 = (lhs[OLSON_NAME].compareTo(rhs[OLSON_NAME]));
            addTaint(lhs[0].getTaint());
            addTaint(rhs[0].getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1293362714 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1293362714;
            // ---------- Original Method ----------
            //return lhs[OLSON_NAME].compareTo(rhs[OLSON_NAME]);
        }

        
};
}

