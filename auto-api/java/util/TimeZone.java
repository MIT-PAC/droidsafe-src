package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.Serializable;
import libcore.icu.TimeZones;
import libcore.util.ZoneInfoDB;

public abstract class TimeZone implements Serializable, Cloneable {
    private static final long serialVersionUID = 3581463369166924961L;
    public static final int SHORT = 0;
    public static final int LONG = 1;
    static final TimeZone GMT = new SimpleTimeZone(0, "GMT");
    private static TimeZone defaultTimeZone;
    private String ID;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.208 -0400", hash_original_method = "9668D4D4A28DB894D48B4297168D73B9", hash_generated_method = "17B92B6B056E44EA2EAC6EA6B64DB8C7")
    @DSModeled(DSC.SAFE)
    public TimeZone() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.208 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "61A6D19735032B457CC2C2ECC9E8C203")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        try 
        {
            Object varDEB570B566DA7549E2F197D0AFA5A2B6_867420720 = (super.clone());
        } //End block
        catch (CloneNotSupportedException e)
        {
            throw new AssertionError(e);
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.208 -0400", hash_original_method = "35912C2CE07F8F743CC17B46FDAA5773", hash_generated_method = "FA69777D28D29CE124CBE6652F7C81B0")
    public static synchronized String[] getAvailableIDs() {
        return ZoneInfoDB.getAvailableIDs();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.208 -0400", hash_original_method = "5A7CF42AD0BFD4513B27A8C382CFC1F1", hash_generated_method = "C0F5916E29DFAF58AEAD0DD27EE35BE2")
    public static synchronized String[] getAvailableIDs(int offsetMillis) {
        return ZoneInfoDB.getAvailableIDs(offsetMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.208 -0400", hash_original_method = "F29CAD391A0A89C41D5BB954A59648B5", hash_generated_method = "88A3AEA543AA75FA7DE1F47D0D254B83")
    public static synchronized TimeZone getDefault() {
        if (defaultTimeZone == null) {
            defaultTimeZone = ZoneInfoDB.getSystemDefault();
        }
        return (TimeZone) defaultTimeZone.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.208 -0400", hash_original_method = "E1D5D6F100BA788FCF57724352534F76", hash_generated_method = "8E9F025B9E03B5C8DC21ABAD40E5613F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getDisplayName() {
        String var127F69A4CE8F9BF22C093B29F518E2B6_2045170655 = (getDisplayName(false, LONG, Locale.getDefault()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getDisplayName(false, LONG, Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.208 -0400", hash_original_method = "813ED5DCC833F8E276BEA923F4174960", hash_generated_method = "DB802A47E631EF7928C5689F7A890570")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getDisplayName(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        String var050E743F370BFF064FBD2B5F0A0CD97F_1194446497 = (getDisplayName(false, LONG, locale));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getDisplayName(false, LONG, locale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.208 -0400", hash_original_method = "084F77DA9DC739656E2D52FB38C28132", hash_generated_method = "D6608E319F7484E07B2CBA403DBE2D75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getDisplayName(boolean daylightTime, int style) {
        dsTaint.addTaint(daylightTime);
        dsTaint.addTaint(style);
        String var5524BF6F6260EF84AC68DDD375B3ADB3_31201974 = (getDisplayName(daylightTime, style, Locale.getDefault()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getDisplayName(daylightTime, style, Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.209 -0400", hash_original_method = "4F4A34040AF2984EDE789FC8C17113CE", hash_generated_method = "032D1843260CBAC81E7E6FB44ED7DBBB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDisplayName(boolean daylightTime, int style, Locale locale) {
        dsTaint.addTaint(daylightTime);
        dsTaint.addTaint(style);
        dsTaint.addTaint(locale.dsTaint);
        if (DroidSafeAndroidRuntime.control) {
            throw new IllegalArgumentException();
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
        String var687AAF24B90629C9BFCFE9608FDCE6E7_695871316 = (builder.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.209 -0400", hash_original_method = "7CED7894325BE9D599DFC54349DF84F9", hash_generated_method = "03253B1185140A408ACAC1476AEC1B89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void appendNumber(StringBuilder builder, int count, int value) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(builder.dsTaint);
        dsTaint.addTaint(value);
        String string;
        string = Integer.toString(value);
        {
            int i;
            i = 0;
            boolean var60F896EAE0FB6F70417007BC6180AE2D_272622290 = (i < count - string.length());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.209 -0400", hash_original_method = "6351E64C485F9179F5E10C6B44486847", hash_generated_method = "169F75C8FE46179F2BE8B68FB870FE40")
    @DSModeled(DSC.SAFE)
    public String getID() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return ID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.209 -0400", hash_original_method = "88FDDC2A48FC14F19CA7C51175C63814", hash_generated_method = "6AF8F5F5A626B435D7D9374B95651664")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDSTSavings() {
        {
            boolean varD465851E9E434204690C9B57B379C53B_757249850 = (useDaylightTime());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return useDaylightTime() ? 3600000 : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.209 -0400", hash_original_method = "C756709CC23E72027C31097576D8FC0B", hash_generated_method = "DC841B529A22F5B1A2804A78E2823B85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getOffset(long time) {
        dsTaint.addTaint(time);
        {
            boolean varEABB6925ABADAFBDB9B2FC1A8A73A51F_596838252 = (inDaylightTime(new Date(time)));
            {
                int varAA9C7E238B9438161564979025C6A540_768334312 = (getRawOffset() + getDSTSavings());
            } //End block
        } //End collapsed parenthetic
        int var5AED50E979B76D88BD85212CE8481F16_521179327 = (getRawOffset());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.209 -0400", hash_original_method = "A9702CAFEC1BDFDDFFC4258E6C6ABF00", hash_generated_method = "65D278D3A5C10E4945F47E0E9E8E83E2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.209 -0400", hash_original_method = "562E760827834660DE148A4B60F077E3", hash_generated_method = "0BD0812CF1235819DA4EF0A1090F8CF5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.209 -0400", hash_original_method = "14669A1A9F13480263115AE965667FDF", hash_generated_method = "8F9A8FE110841A20057F9170654CEA20")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.209 -0400", hash_original_method = "7F1959D5E252281790218EA5AF7B09B6", hash_generated_method = "C03B2EF68B37038F26E5B2A7D84C793A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasSameRules(TimeZone timeZone) {
        dsTaint.addTaint(timeZone.dsTaint);
        boolean varC4531B82AE3DA1529D1D05C5D56AD76C_1147922676 = (getRawOffset() == timeZone.getRawOffset());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (timeZone == null) {
            //return false;
        //}
        //return getRawOffset() == timeZone.getRawOffset();
    }

    
    public abstract boolean inDaylightTime(Date time);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.209 -0400", hash_original_method = "ABB4B718F9BEC996080A15CD9936897B", hash_generated_method = "659F3700A783FC37A94E09C4224CC710")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.209 -0400", hash_original_method = "1A565AC3DEF2BF5296426E0128EC1C9A", hash_generated_method = "22525DC5EC86EA972ECAF34E6A66701E")
    public static synchronized void setDefault(TimeZone timeZone) {
        defaultTimeZone = timeZone != null ? (TimeZone) timeZone.clone() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.209 -0400", hash_original_method = "085ABCA184084E0387E0912A6F36E37B", hash_generated_method = "F9176058D464C47F98B5047ABB9A87BC")
    @DSModeled(DSC.SAFE)
    public void setID(String id) {
        dsTaint.addTaint(id);
        {
            throw new NullPointerException();
        } //End block
        // ---------- Original Method ----------
        //if (id == null) {
            //throw new NullPointerException();
        //}
        //ID = id;
    }

    
    public abstract void setRawOffset(int offsetMillis);

    
    public abstract boolean useDaylightTime();

    
}


