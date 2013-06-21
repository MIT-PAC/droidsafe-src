package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;
import libcore.icu.TimeZones;
import libcore.util.ZoneInfoDB;

public abstract class TimeZone implements Serializable, Cloneable {
    private String ID;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.787 -0400", hash_original_method = "9668D4D4A28DB894D48B4297168D73B9", hash_generated_method = "8E92B7E01B365C66B79257355E0DA018")
    @DSModeled(DSC.SAFE)
    public TimeZone() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.787 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "7A1B3C378002819554DCB77D2FE65BB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        try 
        {
            Object varDEB570B566DA7549E2F197D0AFA5A2B6_1721737482 = (super.clone());
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
        public static synchronized String[] getAvailableIDs() {
        return ZoneInfoDB.getAvailableIDs();
    }

    
        public static synchronized String[] getAvailableIDs(int offsetMillis) {
        return ZoneInfoDB.getAvailableIDs(offsetMillis);
    }

    
        public static synchronized TimeZone getDefault() {
        if (defaultTimeZone == null) {
            defaultTimeZone = ZoneInfoDB.getSystemDefault();
        }
        return (TimeZone) defaultTimeZone.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.788 -0400", hash_original_method = "E1D5D6F100BA788FCF57724352534F76", hash_generated_method = "BCF321625C22B9BBF3C077C8CDADF914")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getDisplayName() {
        String var127F69A4CE8F9BF22C093B29F518E2B6_859894373 = (getDisplayName(false, LONG, Locale.getDefault()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getDisplayName(false, LONG, Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.788 -0400", hash_original_method = "813ED5DCC833F8E276BEA923F4174960", hash_generated_method = "F0F89B90546933395FFDEAFB9D50378C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getDisplayName(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        String var050E743F370BFF064FBD2B5F0A0CD97F_359635258 = (getDisplayName(false, LONG, locale));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getDisplayName(false, LONG, locale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.788 -0400", hash_original_method = "084F77DA9DC739656E2D52FB38C28132", hash_generated_method = "2BC51DD36A344AE2A7F8BD30D2C33243")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getDisplayName(boolean daylightTime, int style) {
        dsTaint.addTaint(daylightTime);
        dsTaint.addTaint(style);
        String var5524BF6F6260EF84AC68DDD375B3ADB3_477554570 = (getDisplayName(daylightTime, style, Locale.getDefault()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getDisplayName(daylightTime, style, Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.789 -0400", hash_original_method = "4F4A34040AF2984EDE789FC8C17113CE", hash_generated_method = "9E27027F48B14E66A19638FFB3D16C00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDisplayName(boolean daylightTime, int style, Locale locale) {
        dsTaint.addTaint(daylightTime);
        dsTaint.addTaint(style);
        dsTaint.addTaint(locale.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        boolean useDaylight;
        useDaylight = daylightTime && useDaylightTime();
        String[][] zoneStrings;
        zoneStrings = TimeZones.getZoneStrings(locale);
        String result;
        result = TimeZones.getDisplayName(zoneStrings, getID(), daylightTime, style);
        int offset;
        offset = getRawOffset();
        {
            offset += getDSTSavings();
        } //End block
        offset /= 60000;
        char sign;
        sign = '+';
        {
            sign = '-';
            offset = -offset;
        } //End block
        StringBuilder builder;
        builder = new StringBuilder(9);
        builder.append("GMT");
        builder.append(sign);
        appendNumber(builder, 2, offset / 60);
        builder.append(':');
        appendNumber(builder, 2, offset % 60);
        String var687AAF24B90629C9BFCFE9608FDCE6E7_413171383 = (builder.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.792 -0400", hash_original_method = "7CED7894325BE9D599DFC54349DF84F9", hash_generated_method = "3B7554BFC89BDE6A572C386453CCBB89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void appendNumber(StringBuilder builder, int count, int value) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(value);
        dsTaint.addTaint(builder.dsTaint);
        String string;
        string = Integer.toString(value);
        {
            int i;
            i = 0;
            boolean var60F896EAE0FB6F70417007BC6180AE2D_1212810344 = (i < count - string.length());
            {
                builder.append('0');
            } //End block
        } //End collapsed parenthetic
        builder.append(string);
        // ---------- Original Method ----------
        //String string = Integer.toString(value);
        //for (int i = 0; i < count - string.length(); i++) {
            //builder.append('0');
        //}
        //builder.append(string);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.793 -0400", hash_original_method = "6351E64C485F9179F5E10C6B44486847", hash_generated_method = "967D0D2173FC07F73DF03E66201BAFD1")
    @DSModeled(DSC.SAFE)
    public String getID() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return ID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.795 -0400", hash_original_method = "88FDDC2A48FC14F19CA7C51175C63814", hash_generated_method = "AA557474B81B4007F6E629A12B4201AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDSTSavings() {
        {
            boolean varD465851E9E434204690C9B57B379C53B_206168845 = (useDaylightTime());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return useDaylightTime() ? 3600000 : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.795 -0400", hash_original_method = "C756709CC23E72027C31097576D8FC0B", hash_generated_method = "5EE8CAC35006A1FA7AEB5465BECBA40C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getOffset(long time) {
        dsTaint.addTaint(time);
        {
            boolean varEABB6925ABADAFBDB9B2FC1A8A73A51F_1401922925 = (inDaylightTime(new Date(time)));
            {
                int varAA9C7E238B9438161564979025C6A540_1382785075 = (getRawOffset() + getDSTSavings());
            } //End block
        } //End collapsed parenthetic
        int var5AED50E979B76D88BD85212CE8481F16_1557278236 = (getRawOffset());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (inDaylightTime(new Date(time))) {
            //return getRawOffset() + getDSTSavings();
        //}
        //return getRawOffset();
    }

    
    public abstract int getOffset(int era, int year, int month, int day,
            int dayOfWeek, int timeOfDayMillis);

    
    public abstract int getRawOffset();

    
        public static synchronized TimeZone getTimeZone(String id) {
        TimeZone zone = ZoneInfoDB.getTimeZone(id);
        if (zone != null) {
            return zone;
        }
        if (zone == null && id.length() > 3 && id.startsWith("GMT")) {
            zone = getCustomTimeZone(id);
        }
        if (zone == null) {
            zone = (TimeZone) GMT.clone();
        }
        return zone;
    }

    
        private static TimeZone getCustomTimeZone(String id) {
        char sign = id.charAt(3);
        if (sign != '+' && sign != '-') {
            return null;
        }
        int[] position = new int[1];
        String formattedName = formatTimeZoneName(id, 4);
        int hour = parseNumber(formattedName, 4, position);
        if (hour < 0 || hour > 23) {
            return null;
        }
        int index = position[0];
        if (index == -1) {
            return null;
        }
        int raw = hour * 3600000;
        if (index < formattedName.length() && formattedName.charAt(index) == ':') {
            int minute = parseNumber(formattedName, index + 1, position);
            if (position[0] == -1 || minute < 0 || minute > 59) {
                return null;
            }
            raw += minute * 60000;
        } else if (hour >= 30 || index > 6) {
            raw = (hour / 100 * 3600000) + (hour % 100 * 60000);
        }
        if (sign == '-') {
            raw = -raw;
        }
        return new SimpleTimeZone(raw, formattedName);
    }

    
        private static String formatTimeZoneName(String name, int offset) {
        StringBuilder buf = new StringBuilder();
        int index = offset, length = name.length();
        buf.append(name.substring(0, offset));
        while (index < length) {
            if (Character.digit(name.charAt(index), 10) != -1) {
                buf.append(name.charAt(index));
                if ((length - (index + 1)) == 2) {
                    buf.append(':');
                }
            } else if (name.charAt(index) == ':') {
                buf.append(':');
            }
            index++;
        }
        if (buf.toString().indexOf(":") == -1) {
            buf.append(':');
            buf.append("00");
        }
        if (buf.toString().indexOf(":") == 5) {
            buf.insert(4, '0');
        }
        return buf.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.796 -0400", hash_original_method = "7F1959D5E252281790218EA5AF7B09B6", hash_generated_method = "A505240EEA93996EA5E95F393155BF54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasSameRules(TimeZone timeZone) {
        dsTaint.addTaint(timeZone.dsTaint);
        boolean varC4531B82AE3DA1529D1D05C5D56AD76C_1241407478 = (getRawOffset() == timeZone.getRawOffset());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (timeZone == null) {
            //return false;
        //}
        //return getRawOffset() == timeZone.getRawOffset();
    }

    
    public abstract boolean inDaylightTime(Date time);

    
        private static int parseNumber(String string, int offset, int[] position) {
        int index = offset, length = string.length(), digit, result = 0;
        while (index < length
                && (digit = Character.digit(string.charAt(index), 10)) != -1) {
            index++;
            result = result * 10 + digit;
        }
        position[0] = index == offset ? -1 : index;
        return result;
    }

    
        public static synchronized void setDefault(TimeZone timeZone) {
        defaultTimeZone = timeZone != null ? (TimeZone) timeZone.clone() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.797 -0400", hash_original_method = "085ABCA184084E0387E0912A6F36E37B", hash_generated_method = "2EE4A392962C24205062319448FC1A5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setID(String id) {
        dsTaint.addTaint(id);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        // ---------- Original Method ----------
        //if (id == null) {
            //throw new NullPointerException();
        //}
        //ID = id;
    }

    
    public abstract void setRawOffset(int offsetMillis);

    
    public abstract boolean useDaylightTime();

    
    private static final long serialVersionUID = 3581463369166924961L;
    public static final int SHORT = 0;
    public static final int LONG = 1;
    static final TimeZone GMT = new SimpleTimeZone(0, "GMT");
    private static TimeZone defaultTimeZone;
}

