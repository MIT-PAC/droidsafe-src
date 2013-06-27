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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.950 -0400", hash_original_field = "B718ADEC73E04CE3EC720DD11A06A308", hash_generated_field = "771D545AF32E3EF0A7656F85E986567C")

    private String ID;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.957 -0400", hash_original_method = "9668D4D4A28DB894D48B4297168D73B9", hash_generated_method = "8E92B7E01B365C66B79257355E0DA018")
    public  TimeZone() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.962 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "657E013037F377A3D14051FE1C18AC80")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1667307797 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1667307797 = super.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1667307797.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1667307797;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.969 -0400", hash_original_method = "E1D5D6F100BA788FCF57724352534F76", hash_generated_method = "F06A06CE60AB93C0D930D0B479A8F259")
    public final String getDisplayName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1955272185 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1955272185 = getDisplayName(false, LONG, Locale.getDefault());
        varB4EAC82CA7396A68D541C85D26508E83_1955272185.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1955272185;
        // ---------- Original Method ----------
        //return getDisplayName(false, LONG, Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.969 -0400", hash_original_method = "813ED5DCC833F8E276BEA923F4174960", hash_generated_method = "7C34DFBA63B1F8DDBF2C164E7FF42796")
    public final String getDisplayName(Locale locale) {
        String varB4EAC82CA7396A68D541C85D26508E83_1431259563 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1431259563 = getDisplayName(false, LONG, locale);
        addTaint(locale.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1431259563.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1431259563;
        // ---------- Original Method ----------
        //return getDisplayName(false, LONG, locale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.970 -0400", hash_original_method = "084F77DA9DC739656E2D52FB38C28132", hash_generated_method = "F4645EB2E4D6391D140292C2393851A8")
    public final String getDisplayName(boolean daylightTime, int style) {
        String varB4EAC82CA7396A68D541C85D26508E83_2085678328 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2085678328 = getDisplayName(daylightTime, style, Locale.getDefault());
        addTaint(daylightTime);
        addTaint(style);
        varB4EAC82CA7396A68D541C85D26508E83_2085678328.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2085678328;
        // ---------- Original Method ----------
        //return getDisplayName(daylightTime, style, Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.971 -0400", hash_original_method = "4F4A34040AF2984EDE789FC8C17113CE", hash_generated_method = "555B8EA9D2C25D53F263EE1B0EC39A28")
    public String getDisplayName(boolean daylightTime, int style, Locale locale) {
        String varB4EAC82CA7396A68D541C85D26508E83_1874656108 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_748867473 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        boolean useDaylight;
        useDaylight = daylightTime && useDaylightTime();
        String[][] zoneStrings;
        zoneStrings = TimeZones.getZoneStrings(locale);
        String result;
        result = TimeZones.getDisplayName(zoneStrings, getID(), daylightTime, style);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1874656108 = result;
        } //End block
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
        varB4EAC82CA7396A68D541C85D26508E83_748867473 = builder.toString();
        addTaint(daylightTime);
        addTaint(style);
        addTaint(locale.getTaint());
        String varA7E53CE21691AB073D9660D615818899_2119360867; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2119360867 = varB4EAC82CA7396A68D541C85D26508E83_1874656108;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2119360867 = varB4EAC82CA7396A68D541C85D26508E83_748867473;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2119360867.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2119360867;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.971 -0400", hash_original_method = "7CED7894325BE9D599DFC54349DF84F9", hash_generated_method = "DDC710D89EB32817ABFFC3A0D8725EAD")
    private void appendNumber(StringBuilder builder, int count, int value) {
        String string;
        string = Integer.toString(value);
        {
            int i;
            i = 0;
            boolean var60F896EAE0FB6F70417007BC6180AE2D_1672016579 = (i < count - string.length());
            {
                builder.append('0');
            } //End block
        } //End collapsed parenthetic
        builder.append(string);
        addTaint(builder.getTaint());
        addTaint(count);
        addTaint(value);
        // ---------- Original Method ----------
        //String string = Integer.toString(value);
        //for (int i = 0; i < count - string.length(); i++) {
            //builder.append('0');
        //}
        //builder.append(string);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.972 -0400", hash_original_method = "6351E64C485F9179F5E10C6B44486847", hash_generated_method = "07331380FA3DCEFDB46F784146A105D7")
    public String getID() {
        String varB4EAC82CA7396A68D541C85D26508E83_1607683942 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1607683942 = ID;
        varB4EAC82CA7396A68D541C85D26508E83_1607683942.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1607683942;
        // ---------- Original Method ----------
        //return ID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.972 -0400", hash_original_method = "88FDDC2A48FC14F19CA7C51175C63814", hash_generated_method = "3BD33BB01DC921933D0DC7CA09F96990")
    public int getDSTSavings() {
        {
            boolean varD465851E9E434204690C9B57B379C53B_706227077 = (useDaylightTime());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1358371740 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1358371740;
        // ---------- Original Method ----------
        //return useDaylightTime() ? 3600000 : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.972 -0400", hash_original_method = "C756709CC23E72027C31097576D8FC0B", hash_generated_method = "72DAB8123FA8B45169213752A57243B0")
    public int getOffset(long time) {
        {
            boolean varEABB6925ABADAFBDB9B2FC1A8A73A51F_29923732 = (inDaylightTime(new Date(time)));
            {
                int varAA9C7E238B9438161564979025C6A540_185755409 = (getRawOffset() + getDSTSavings());
            } //End block
        } //End collapsed parenthetic
        int var5AED50E979B76D88BD85212CE8481F16_1641858572 = (getRawOffset());
        addTaint(time);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1868758757 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1868758757;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.998 -0400", hash_original_method = "7F1959D5E252281790218EA5AF7B09B6", hash_generated_method = "DAF2FD1CA41317534E582737611B8A47")
    public boolean hasSameRules(TimeZone timeZone) {
        boolean varC4531B82AE3DA1529D1D05C5D56AD76C_1437061267 = (getRawOffset() == timeZone.getRawOffset());
        addTaint(timeZone.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1531622374 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1531622374;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.999 -0400", hash_original_method = "085ABCA184084E0387E0912A6F36E37B", hash_generated_method = "655105E407ABC601928436ACEC7B62CE")
    public void setID(String id) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        ID = id;
        // ---------- Original Method ----------
        //if (id == null) {
            //throw new NullPointerException();
        //}
        //ID = id;
    }

    
    public abstract void setRawOffset(int offsetMillis);

    
    public abstract boolean useDaylightTime();

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.000 -0400", hash_original_field = "A587EBC60576AE59123FD6EE4ACC1509", hash_generated_field = "6FB3FB67E789BD459E53A6D7000DBE51")

    private static long serialVersionUID = 3581463369166924961L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.000 -0400", hash_original_field = "AB4915390C381EF5996BBC8C05836AF5", hash_generated_field = "F0EC76EF0A1325A66146C39A7A2DD364")

    public static final int SHORT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.000 -0400", hash_original_field = "3BAE48DEAAE333CB107BC1132F4F4146", hash_generated_field = "F5FF9843F59090FE170F992D775343D2")

    public static final int LONG = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.000 -0400", hash_original_field = "C171914A8DC07BC9CEEB93EBFAE6BC81", hash_generated_field = "A7E4E2EACD9A3E3499E9D3DFDD2AECFA")

    static TimeZone GMT = new SimpleTimeZone(0, "GMT");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.000 -0400", hash_original_field = "D0491A75C542D67DF607F8F1BED6615E", hash_generated_field = "C615B22DCB0D6F7D43244D81DC929B8B")

    private static TimeZone defaultTimeZone;
}

