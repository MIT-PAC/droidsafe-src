package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;

import libcore.icu.TimeZones;
import libcore.util.ZoneInfoDB;





public abstract class TimeZone implements Serializable, Cloneable {

    /**
     * Returns the system's installed time zone IDs. Any of these IDs can be
     * passed to {@link #getTimeZone} to lookup the corresponding time zone
     * instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.868 -0500", hash_original_method = "35912C2CE07F8F743CC17B46FDAA5773", hash_generated_method = "FA69777D28D29CE124CBE6652F7C81B0")
    
public static synchronized String[] getAvailableIDs() {
        return ZoneInfoDB.getAvailableIDs();
    }

    /**
     * Returns the IDs of the time zones whose offset from UTC is {@code
     * offsetMillis}. Any of these IDs can be passed to {@link #getTimeZone} to
     * lookup the corresponding time zone instance.
     *
     * @return a possibly-empty array.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.870 -0500", hash_original_method = "5A7CF42AD0BFD4513B27A8C382CFC1F1", hash_generated_method = "C0F5916E29DFAF58AEAD0DD27EE35BE2")
    
public static synchronized String[] getAvailableIDs(int offsetMillis) {
        return ZoneInfoDB.getAvailableIDs(offsetMillis);
    }

    /**
     * Returns the user's preferred time zone. This may have been overridden for
     * this process with {@link #setDefault}.
     *
     * <p>Since the user's time zone changes dynamically, avoid caching this
     * value. Instead, use this method to look it up for each use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.873 -0500", hash_original_method = "F29CAD391A0A89C41D5BB954A59648B5", hash_generated_method = "88A3AEA543AA75FA7DE1F47D0D254B83")
    
public static synchronized TimeZone getDefault() {
        if (defaultTimeZone == null) {
            defaultTimeZone = ZoneInfoDB.getSystemDefault();
        }
        return (TimeZone) defaultTimeZone.clone();
    }

    /**
     * Returns a {@code TimeZone} suitable for {@code id}, or {@code GMT} on failure.
     *
     * <p>An id can be an Olson name of the form <i>Area</i>/<i>Location</i>, such
     * as {@code America/Los_Angeles}. The {@link #getAvailableIDs} method returns
     * the supported names.
     *
     * <p>This method can also create a custom {@code TimeZone} using the following
     * syntax: {@code GMT[+|-]hh[[:]mm]}. For example, {@code TimeZone.getTimeZone("GMT+14:00")}
     * would return an object with a raw offset of +14 hours from UTC, and which does <i>not</i>
     * use daylight savings. These are rarely useful, because they don't correspond to time
     * zones actually in use.
     *
     * <p>Other than the special cases "UTC" and "GMT" (which are synonymous in this context,
     * both corresponding to UTC), Android does not support the deprecated three-letter time
     * zone IDs used in Java 1.1.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.901 -0500", hash_original_method = "A9702CAFEC1BDFDDFFC4258E6C6ABF00", hash_generated_method = "65D278D3A5C10E4945F47E0E9E8E83E2")
    
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

    /**
     * Returns a new SimpleTimeZone for an id of the form "GMT[+|-]hh[[:]mm]", or null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.904 -0500", hash_original_method = "562E760827834660DE148A4B60F077E3", hash_generated_method = "0BD0812CF1235819DA4EF0A1090F8CF5")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.908 -0500", hash_original_method = "14669A1A9F13480263115AE965667FDF", hash_generated_method = "8F9A8FE110841A20057F9170654CEA20")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.915 -0500", hash_original_method = "ABB4B718F9BEC996080A15CD9936897B", hash_generated_method = "659F3700A783FC37A94E09C4224CC710")
    
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

    /**
     * Overrides the default time zone for the current process only.
     *
     * <p><strong>Warning</strong>: avoid using this method to use a custom time
     * zone in your process. This value may be cleared or overwritten at any
     * time, which can cause unexpected behavior. Instead, manually supply a
     * custom time zone as needed.
     *
     * @param timeZone a custom time zone, or {@code null} to set the default to
     *     the user's preferred value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.918 -0500", hash_original_method = "1A565AC3DEF2BF5296426E0128EC1C9A", hash_generated_method = "22525DC5EC86EA972ECAF34E6A66701E")
    
public static synchronized void setDefault(TimeZone timeZone) {
        defaultTimeZone = timeZone != null ? (TimeZone) timeZone.clone() : null;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.848 -0500", hash_original_field = "C13F1E7229EC7D6C7375763002499D20", hash_generated_field = "264833884098E3465C064523C6821E70")

    private static final long serialVersionUID = 3581463369166924961L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.850 -0500", hash_original_field = "D705C164A1C5B9CFA5D5291179F583BB", hash_generated_field = "F0EC76EF0A1325A66146C39A7A2DD364")

    public static final int SHORT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.853 -0500", hash_original_field = "3D5440EC1B7415979D6644BCDD15B434", hash_generated_field = "F5FF9843F59090FE170F992D775343D2")

    public static final int LONG = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.855 -0500", hash_original_field = "C2DA21A1474F9F30088EC659734A376D", hash_generated_field = "AD5768C44D2B4CA0FC370EAC906753D1")


    static final TimeZone GMT = new SimpleTimeZone(0, "GMT");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.857 -0500", hash_original_field = "8B1FF129797BF600BB3E5951495A05D5", hash_generated_field = "C615B22DCB0D6F7D43244D81DC929B8B")


    private static TimeZone defaultTimeZone;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.860 -0500", hash_original_field = "EE4ACCD5B232CF1CADCD3D3FFE849AC5", hash_generated_field = "771D545AF32E3EF0A7656F85E986567C")


    private String ID;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.863 -0500", hash_original_method = "9668D4D4A28DB894D48B4297168D73B9", hash_generated_method = "6245B52E9EE0FEAF2124F4ED5AD69880")
    
public TimeZone() {}

    /**
     * Returns a new time zone with the same ID, raw offset, and daylight
     * savings time rules as this time zone.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.865 -0500", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "88F588A1F8F1E65DC62D9CB72E24BF48")
    
@Override public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /**
     * Equivalent to {@code getDisplayName(false, TimeZone.LONG, Locale.getDefault())}.
     * <a href="../util/Locale.html#default_locale">Be wary of the default locale</a>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.876 -0500", hash_original_method = "E1D5D6F100BA788FCF57724352534F76", hash_generated_method = "855AF36B6D2FA6CA483A7086CB98DED2")
    
public final String getDisplayName() {
        return getDisplayName(false, LONG, Locale.getDefault());
    }

    /**
     * Equivalent to {@code getDisplayName(false, TimeZone.LONG, locale)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.878 -0500", hash_original_method = "813ED5DCC833F8E276BEA923F4174960", hash_generated_method = "F4D2DE61A7472AC40D4ACFD75EEBF6C3")
    
public final String getDisplayName(Locale locale) {
        return getDisplayName(false, LONG, locale);
    }

    /**
     * Equivalent to {@code getDisplayName(daylightTime, style, Locale.getDefault())}.
     * <a href="../util/Locale.html#default_locale">Be wary of the default locale</a>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.880 -0500", hash_original_method = "084F77DA9DC739656E2D52FB38C28132", hash_generated_method = "81ED72F1FA5005F99036C27AAAF0540E")
    
public final String getDisplayName(boolean daylightTime, int style) {
        return getDisplayName(daylightTime, style, Locale.getDefault());
    }

    /**
     * Returns the {@link #SHORT short} or {@link #LONG long} name of this time
     * zone with either standard or daylight time, as written in {@code locale}.
     * If the name is not available, the result is in the format
     * {@code GMT[+-]hh:mm}.
     *
     * @param daylightTime true for daylight time, false for standard time.
     * @param style either {@link TimeZone#LONG} or {@link TimeZone#SHORT}.
     * @param locale the display locale.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.883 -0500", hash_original_method = "4F4A34040AF2984EDE789FC8C17113CE", hash_generated_method = "6B54818216DAAD424943547CF1F765CD")
    
public String getDisplayName(boolean daylightTime, int style, Locale locale) {
        if (style != SHORT && style != LONG) {
            throw new IllegalArgumentException();
        }

        boolean useDaylight = daylightTime && useDaylightTime();

        String[][] zoneStrings = TimeZones.getZoneStrings(locale);
        String result = TimeZones.getDisplayName(zoneStrings, getID(), daylightTime, style);
        if (result != null) {
            return result;
        }

        // TODO: do we ever get here?

        int offset = getRawOffset();
        if (useDaylight && this instanceof SimpleTimeZone) {
            offset += getDSTSavings();
        }
        offset /= 60000;
        char sign = '+';
        if (offset < 0) {
            sign = '-';
            offset = -offset;
        }
        StringBuilder builder = new StringBuilder(9);
        builder.append("GMT");
        builder.append(sign);
        appendNumber(builder, 2, offset / 60);
        builder.append(':');
        appendNumber(builder, 2, offset % 60);
        return builder.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.885 -0500", hash_original_method = "7CED7894325BE9D599DFC54349DF84F9", hash_generated_method = "E6A28245E6A3B7335F43087FDD5A3F8D")
    
private void appendNumber(StringBuilder builder, int count, int value) {
        String string = Integer.toString(value);
        for (int i = 0; i < count - string.length(); i++) {
            builder.append('0');
        }
        builder.append(string);
    }

    /**
     * Returns the ID of this {@code TimeZone}, such as
     * {@code America/Los_Angeles}, {@code GMT-08:00} or {@code UTC}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.888 -0500", hash_original_method = "6351E64C485F9179F5E10C6B44486847", hash_generated_method = "EB1B7670C3C3A36B39FD469014CCC913")
    
public String getID() {
        return ID;
    }

    /**
     * Returns the daylight savings offset in milliseconds for this time zone.
     * The base implementation returns {@code 3600000} (1 hour) for time zones
     * that use daylight savings time and {@code 0} for timezones that do not.
     * Subclasses should override this method for other daylight savings
     * offsets.
     *
     * <p>Note that this method doesn't tell you whether or not to apply the
     * offset: you need to call {@code inDaylightTime} for the specific time
     * you're interested in. If this method returns a non-zero offset, that only
     * tells you that this {@code TimeZone} sometimes observes daylight savings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.891 -0500", hash_original_method = "88FDDC2A48FC14F19CA7C51175C63814", hash_generated_method = "3E1EE466382C8D0B5B2151752343B060")
    
public int getDSTSavings() {
        return useDaylightTime() ? 3600000 : 0;
    }

    /**
     * Returns the offset in milliseconds from UTC for this time zone at {@code
     * time}. The offset includes daylight savings time if the specified
     * date is within the daylight savings time period.
     *
     * @param time the date in milliseconds since January 1, 1970 00:00:00 UTC
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.894 -0500", hash_original_method = "C756709CC23E72027C31097576D8FC0B", hash_generated_method = "520706B60A3BF9919148A261F825584B")
    
public int getOffset(long time) {
        if (inDaylightTime(new Date(time))) {
            return getRawOffset() + getDSTSavings();
        }
        return getRawOffset();
    }

    /**
     * Returns this time zone's offset in milliseconds from UTC at the specified
     * date and time. The offset includes daylight savings time if the date
     * and time is within the daylight savings time period.
     *
     * <p>This method is intended to be used by {@link Calendar} to compute
     * {@link Calendar#DST_OFFSET} and {@link Calendar#ZONE_OFFSET}. Application
     * code should have no reason to call this method directly. Each parameter
     * is interpreted in the same way as the corresponding {@code Calendar}
     * field. Refer to {@link Calendar} for specific definitions of this
     * method's parameters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.896 -0500", hash_original_method = "BBA8171A17B46E40060127D831CE1275", hash_generated_method = "5574580ABFD637024A653FB08AC4DC87")
    
public abstract int getOffset(int era, int year, int month, int day,
            int dayOfWeek, int timeOfDayMillis);

    /**
     * Returns the offset in milliseconds from UTC of this time zone's standard
     * time.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.898 -0500", hash_original_method = "7DDA4500473EBF8DF6FE8E7FD3845289", hash_generated_method = "7A8EA9C6D36624E37953A4D1FC93F79C")
    
public abstract int getRawOffset();

    /**
     * Returns true if {@code timeZone} has the same rules as this time zone.
     *
     * <p>The base implementation returns true if both time zones have the same
     * raw offset.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.910 -0500", hash_original_method = "7F1959D5E252281790218EA5AF7B09B6", hash_generated_method = "30B3CE1E264219AF1A7619158FCF1E42")
    
public boolean hasSameRules(TimeZone timeZone) {
        if (timeZone == null) {
            return false;
        }
        return getRawOffset() == timeZone.getRawOffset();
    }

    /**
     * Returns true if {@code time} is in a daylight savings time period for
     * this time zone.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.913 -0500", hash_original_method = "D8D08367AE362349D81E432C10113D69", hash_generated_method = "768000593A099E07941789E134A5EC5C")
    
public abstract boolean inDaylightTime(Date time);

    /**
     * Sets the ID of this {@code TimeZone}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.921 -0500", hash_original_method = "085ABCA184084E0387E0912A6F36E37B", hash_generated_method = "47F7CBC650C48D202337B721CA9D1C03")
    
public void setID(String id) {
        if (id == null) {
            throw new NullPointerException();
        }
        ID = id;
    }

    /**
     * Sets the offset in milliseconds from UTC of this time zone's standard
     * time.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.923 -0500", hash_original_method = "9CBC4EC55E0E24E08575245D146CD68B", hash_generated_method = "BE4D6FC1583D34CF69508921CC26130C")
    
public abstract void setRawOffset(int offsetMillis);

    /**
     * Returns true if this time zone has a future transition to or from
     * daylight savings time.
     *
     * <p><strong>Warning:</strong> this returns false for time zones like
     * {@code Asia/Kuala_Lumpur} that have previously used DST but do not
     * currently. A hypothetical country that has never observed daylight
     * savings before but plans to start next year would return true.
     *
     * <p><strong>Warning:</strong> this returns true for time zones that use
     * DST, even when it is not active.
     *
     * <p>Use {@link #inDaylightTime} to find out whether daylight savings is
     * in effect at a specific time.
     *
     * <p>Most applications should not use this method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.925 -0500", hash_original_method = "21C3C508C0D0784BDA8C6C77AEEDE939", hash_generated_method = "AEA202CA3554582325612E76986178DB")
    
public abstract boolean useDaylightTime();
}

