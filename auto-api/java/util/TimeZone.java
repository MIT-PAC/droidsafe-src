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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.866 -0400", hash_original_field = "B718ADEC73E04CE3EC720DD11A06A308", hash_generated_field = "771D545AF32E3EF0A7656F85E986567C")

    private String ID;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.866 -0400", hash_original_method = "9668D4D4A28DB894D48B4297168D73B9", hash_generated_method = "8E92B7E01B365C66B79257355E0DA018")
    public  TimeZone() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.867 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "222E8EA3C7623F1BEE0EE536B70F9AA1")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_600311144 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_600311144 = super.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_600311144.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_600311144;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.868 -0400", hash_original_method = "E1D5D6F100BA788FCF57724352534F76", hash_generated_method = "7B64E7152902CD88E9AEF15E3E8DAC95")
    public final String getDisplayName() {
        String varB4EAC82CA7396A68D541C85D26508E83_510450535 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_510450535 = getDisplayName(false, LONG, Locale.getDefault());
        varB4EAC82CA7396A68D541C85D26508E83_510450535.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_510450535;
        // ---------- Original Method ----------
        //return getDisplayName(false, LONG, Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.868 -0400", hash_original_method = "813ED5DCC833F8E276BEA923F4174960", hash_generated_method = "573CDC4AB69FD55B1BB9B902B09CEA19")
    public final String getDisplayName(Locale locale) {
        String varB4EAC82CA7396A68D541C85D26508E83_1459473036 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1459473036 = getDisplayName(false, LONG, locale);
        addTaint(locale.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1459473036.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1459473036;
        // ---------- Original Method ----------
        //return getDisplayName(false, LONG, locale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.868 -0400", hash_original_method = "084F77DA9DC739656E2D52FB38C28132", hash_generated_method = "5214657F612F26F046679B80857DEE7E")
    public final String getDisplayName(boolean daylightTime, int style) {
        String varB4EAC82CA7396A68D541C85D26508E83_525364123 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_525364123 = getDisplayName(daylightTime, style, Locale.getDefault());
        addTaint(daylightTime);
        addTaint(style);
        varB4EAC82CA7396A68D541C85D26508E83_525364123.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_525364123;
        // ---------- Original Method ----------
        //return getDisplayName(daylightTime, style, Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.869 -0400", hash_original_method = "4F4A34040AF2984EDE789FC8C17113CE", hash_generated_method = "D6495A0618D4E936BB53E8443CAFA231")
    public String getDisplayName(boolean daylightTime, int style, Locale locale) {
        String varB4EAC82CA7396A68D541C85D26508E83_965224340 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1377349306 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        boolean useDaylight = daylightTime && useDaylightTime();
        String[][] zoneStrings = TimeZones.getZoneStrings(locale);
        String result = TimeZones.getDisplayName(zoneStrings, getID(), daylightTime, style);
        {
            varB4EAC82CA7396A68D541C85D26508E83_965224340 = result;
        } //End block
        int offset = getRawOffset();
        {
            offset += getDSTSavings();
        } //End block
        offset /= 60000;
        char sign = '+';
        {
            sign = '-';
            offset = -offset;
        } //End block
        StringBuilder builder = new StringBuilder(9);
        builder.append("GMT");
        builder.append(sign);
        appendNumber(builder, 2, offset / 60);
        builder.append(':');
        appendNumber(builder, 2, offset % 60);
        varB4EAC82CA7396A68D541C85D26508E83_1377349306 = builder.toString();
        addTaint(daylightTime);
        addTaint(style);
        addTaint(locale.getTaint());
        String varA7E53CE21691AB073D9660D615818899_545765214; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_545765214 = varB4EAC82CA7396A68D541C85D26508E83_965224340;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_545765214 = varB4EAC82CA7396A68D541C85D26508E83_1377349306;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_545765214.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_545765214;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.870 -0400", hash_original_method = "7CED7894325BE9D599DFC54349DF84F9", hash_generated_method = "EE12F6AED57EDA794CB83E0B206D1308")
    private void appendNumber(StringBuilder builder, int count, int value) {
        String string = Integer.toString(value);
        {
            int i = 0;
            boolean var60F896EAE0FB6F70417007BC6180AE2D_198847738 = (i < count - string.length());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.871 -0400", hash_original_method = "6351E64C485F9179F5E10C6B44486847", hash_generated_method = "5AC9EA0F5AE08F107D77E01E746CFB8B")
    public String getID() {
        String varB4EAC82CA7396A68D541C85D26508E83_2047828245 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2047828245 = ID;
        varB4EAC82CA7396A68D541C85D26508E83_2047828245.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2047828245;
        // ---------- Original Method ----------
        //return ID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.872 -0400", hash_original_method = "88FDDC2A48FC14F19CA7C51175C63814", hash_generated_method = "DF007CC3C5BD0D1C0A0FDA39CA1AC461")
    public int getDSTSavings() {
        {
            boolean varD465851E9E434204690C9B57B379C53B_19872106 = (useDaylightTime());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_974601404 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_974601404;
        // ---------- Original Method ----------
        //return useDaylightTime() ? 3600000 : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.872 -0400", hash_original_method = "C756709CC23E72027C31097576D8FC0B", hash_generated_method = "0F3B44E608AB47ADD1C4618BCE606ECF")
    public int getOffset(long time) {
        {
            boolean varEABB6925ABADAFBDB9B2FC1A8A73A51F_1221636248 = (inDaylightTime(new Date(time)));
            {
                int varAA9C7E238B9438161564979025C6A540_288625138 = (getRawOffset() + getDSTSavings());
            } //End block
        } //End collapsed parenthetic
        int var5AED50E979B76D88BD85212CE8481F16_483462047 = (getRawOffset());
        addTaint(time);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1347951297 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1347951297;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.873 -0400", hash_original_method = "7F1959D5E252281790218EA5AF7B09B6", hash_generated_method = "20BA18EF60A888D77FB0E7D73DD857AE")
    public boolean hasSameRules(TimeZone timeZone) {
        boolean varC4531B82AE3DA1529D1D05C5D56AD76C_1184432726 = (getRawOffset() == timeZone.getRawOffset());
        addTaint(timeZone.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1513667581 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1513667581;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.874 -0400", hash_original_method = "085ABCA184084E0387E0912A6F36E37B", hash_generated_method = "655105E407ABC601928436ACEC7B62CE")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.874 -0400", hash_original_field = "A587EBC60576AE59123FD6EE4ACC1509", hash_generated_field = "264833884098E3465C064523C6821E70")

    private static final long serialVersionUID = 3581463369166924961L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.874 -0400", hash_original_field = "AB4915390C381EF5996BBC8C05836AF5", hash_generated_field = "F0EC76EF0A1325A66146C39A7A2DD364")

    public static final int SHORT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.874 -0400", hash_original_field = "3BAE48DEAAE333CB107BC1132F4F4146", hash_generated_field = "F5FF9843F59090FE170F992D775343D2")

    public static final int LONG = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.874 -0400", hash_original_field = "C171914A8DC07BC9CEEB93EBFAE6BC81", hash_generated_field = "AD5768C44D2B4CA0FC370EAC906753D1")

    static final TimeZone GMT = new SimpleTimeZone(0, "GMT");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.874 -0400", hash_original_field = "D0491A75C542D67DF607F8F1BED6615E", hash_generated_field = "C615B22DCB0D6F7D43244D81DC929B8B")

    private static TimeZone defaultTimeZone;
}

