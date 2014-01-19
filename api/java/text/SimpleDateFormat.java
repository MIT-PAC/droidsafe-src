package java.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import libcore.icu.LocaleData;
import libcore.icu.TimeZones;

public class SimpleDateFormat extends DateFormat {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.087 -0500", hash_original_method = "F209DE6039C95F3ED32C483A7FAB87E8", hash_generated_method = "242A0445AD9B8EA038A867E60E2CF70F")
    
private static String defaultPattern() {
        LocaleData localeData = LocaleData.get(Locale.getDefault());
        return localeData.getDateFormat(SHORT) + " " + localeData.getTimeFormat(SHORT);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.167 -0500", hash_original_method = "FC74B76DEBD3C100A988B40A9B23664F", hash_generated_method = "58DB67D74D7286DC04494E075E976CCC")
    
private static String convertPattern(String template, String fromChars, String toChars, boolean check) {
        if (!check && fromChars.equals(toChars)) {
            return template;
        }
        boolean quote = false;
        StringBuilder output = new StringBuilder();
        int length = template.length();
        for (int i = 0; i < length; i++) {
            int index;
            char next = template.charAt(i);
            if (next == '\'') {
                quote = !quote;
            }
            if (!quote && (index = fromChars.indexOf(next)) != -1) {
                output.append(toChars.charAt(index));
            } else if (check && !quote && ((next >= 'a' && next <= 'z') || (next >= 'A' && next <= 'Z'))) {
                throw new IllegalArgumentException("Invalid pattern character '" + next + "' in " + "'" + template + "'");
            } else {
                output.append(next);
            }
        }
        if (quote) {
            throw new IllegalArgumentException("Unterminated quote");
        }
        return output.toString();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.021 -0500", hash_original_field = "B1180D5D305974942CDBE002F428B05D", hash_generated_field = "56D5BE14208D23988E9004C5F0B78F0A")

    private static final long serialVersionUID = 4774881970558875024L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.024 -0500", hash_original_field = "A744F4AD3CAB1EC97E99CD0EC93B275B", hash_generated_field = "768BF8FACCCDAD6AF5C419EAE423D264")

    static final String PATTERN_CHARS = "GyMdkHmsSEDFwWahKzZLc";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.027 -0500", hash_original_field = "42C283719495C7F01F956C1C894B8966", hash_generated_field = "38D472B8F0929331ACCEF6DD12F5881E")

    // but has no corresponding public constant.
    private static final int RFC_822_TIMEZONE_FIELD = 18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.029 -0500", hash_original_field = "092BF2F6FE6A95E15662967CC9554973", hash_generated_field = "90072FD3D40BEB51F7D76B4A895EAB71")

    // necessary for correct localization in various languages (http://b/2633414).
    private static final int STAND_ALONE_MONTH_FIELD = 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.032 -0500", hash_original_field = "0506B9721FCE5527CB33CD056A58CF04", hash_generated_field = "17C0AF79A85BEACDA5BEBD11DB284CA7")

    // necessary for correct localization in various languages (http://b/2633414).
    private static final int STAND_ALONE_DAY_OF_WEEK_FIELD = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.172 -0500", hash_original_field = "91C32C5F865B6F47A29144104E3459E7", hash_generated_field = "9ECCA64B643BE0EF052CE0F624B781F1")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("defaultCenturyStart", Date.class),
        new ObjectStreamField("formatData", DateFormatSymbols.class),
        new ObjectStreamField("pattern", String.class),
        new ObjectStreamField("serialVersionOnStream", int.class),
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.035 -0500", hash_original_field = "57C08BF52FBB9452CE610A98F88E4F24", hash_generated_field = "8AE769BFE2CAD1B10C494CCD4D4D489A")

    private String pattern;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.037 -0500", hash_original_field = "EF4E0D3E20F3E15FB11A62D7FC251010", hash_generated_field = "8EEEF9C78A0C692C98D78AB64DB0C20D")

    private DateFormatSymbols formatData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.040 -0500", hash_original_field = "458A3ADAD63C38186017676F3CEBA899", hash_generated_field = "6DC58B2FFCD396D044D4105C5E7E21CC")

    transient private int creationYear;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.043 -0500", hash_original_field = "FCD1B3625B07CC098656859762932F2F", hash_generated_field = "7490904CE4798294C2932FA3B8A81D84")

    private Date defaultCenturyStart;

    /**
     * Constructs a new {@code SimpleDateFormat} for formatting and parsing
     * dates and times in the {@code SHORT} style for the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.046 -0500", hash_original_method = "55288B23256ED63825B1D49B41027576", hash_generated_method = "39B68D1F56D4EBE9F4B1205B0CE3AF97")
    
public SimpleDateFormat() {
        this(Locale.getDefault());
        this.pattern = defaultPattern();
        this.formatData = new DateFormatSymbols(Locale.getDefault());
    }

    /**
     * Constructs a new {@code SimpleDateFormat} using the specified
     * non-localized pattern and the {@code DateFormatSymbols} and {@code
     * Calendar} for the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     *
     * @param pattern
     *            the pattern.
     * @throws NullPointerException
     *            if the pattern is {@code null}.
     * @throws IllegalArgumentException
     *            if {@code pattern} is not considered to be usable by this
     *            formatter.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.048 -0500", hash_original_method = "DF79561AB8D44B187C9CA04B354315AC", hash_generated_method = "F3014B31121A74282CEB26A187F51EA5")
    
public SimpleDateFormat(String pattern) {
        this(pattern, Locale.getDefault());
    }

    /**
     * Constructs a new {@code SimpleDateFormat} using the specified
     * non-localized pattern and {@code DateFormatSymbols} and the {@code
     * Calendar} for the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     *
     * @param template
     *            the pattern.
     * @param value
     *            the DateFormatSymbols.
     * @throws NullPointerException
     *            if the pattern is {@code null}.
     * @throws IllegalArgumentException
     *            if the pattern is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.071 -0500", hash_original_method = "2C117D04FF17ED0139CEC7451AA4BD73", hash_generated_method = "53982C08D69114A77F58DFC60F0427B9")
    
public SimpleDateFormat(String template, DateFormatSymbols value) {
        this(Locale.getDefault());
        validatePattern(template);
        pattern = template;
        formatData = (DateFormatSymbols) value.clone();
    }

    /**
     * Constructs a new {@code SimpleDateFormat} using the specified
     * non-localized pattern and the {@code DateFormatSymbols} and {@code
     * Calendar} for the specified locale.
     *
     * @param template
     *            the pattern.
     * @param locale
     *            the locale.
     * @throws NullPointerException
     *            if the pattern is {@code null}.
     * @throws IllegalArgumentException
     *            if the pattern is invalid.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.074 -0500", hash_original_method = "1BCD123DF2A5414BB2A2ECF5D3357D25", hash_generated_method = "D1932A3E010E48695122576E5363C257")
    
public SimpleDateFormat(String template, Locale locale) {
        this(locale);
        validatePattern(template);
        pattern = template;
        formatData = new DateFormatSymbols(locale);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.077 -0500", hash_original_method = "F464E2338695834D875FCA6185F1E83B", hash_generated_method = "C039888B33A3E1C4324452F493B7E115")
    
private SimpleDateFormat(Locale locale) {
        numberFormat = NumberFormat.getInstance(locale);
        numberFormat.setParseIntegerOnly(true);
        numberFormat.setGroupingUsed(false);
        calendar = new GregorianCalendar(locale);
        calendar.add(Calendar.YEAR, -80);
        creationYear = calendar.get(Calendar.YEAR);
        defaultCenturyStart = calendar.getTime();
    }

    /**
     * Validates the format character.
     *
     * @param format
     *            the format character
     *
     * @throws IllegalArgumentException
     *             when the format character is invalid
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.051 -0500", hash_original_method = "411C0D5D8AD5CB18D4C2CE04A3CEEBF0", hash_generated_method = "E105F6342371FC7A4CC18F36D0625481")
    
private void validateFormat(char format) {
        int index = PATTERN_CHARS.indexOf(format);
        if (index == -1) {
            throw new IllegalArgumentException("Unknown pattern character '" + format + "'");
        }
    }

    /**
     * Validates the pattern.
     *
     * @param template
     *            the pattern to validate.
     *
     * @throws NullPointerException
     *             if the pattern is null
     * @throws IllegalArgumentException
     *             if the pattern is invalid
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.067 -0500", hash_original_method = "49C9E23BED9AC71209F0210F812D9D37", hash_generated_method = "C9301FAA0B5F911E884F0B0D4E4BD72F")
    
private void validatePattern(String template) {
        boolean quote = false;
        int next, last = -1, count = 0;

        final int patternLength = template.length();
        for (int i = 0; i < patternLength; i++) {
            next = (template.charAt(i));
            if (next == '\'') {
                if (count > 0) {
                    validateFormat((char) last);
                    count = 0;
                }
                if (last == next) {
                    last = -1;
                } else {
                    last = next;
                }
                quote = !quote;
                continue;
            }
            if (!quote
                    && (last == next || (next >= 'a' && next <= 'z') || (next >= 'A' && next <= 'Z'))) {
                if (last == next) {
                    count++;
                } else {
                    if (count > 0) {
                        validateFormat((char) last);
                    }
                    last = next;
                    count = 1;
                }
            } else {
                if (count > 0) {
                    validateFormat((char) last);
                    count = 0;
                }
                last = -1;
            }
        }
        if (count > 0) {
            validateFormat((char) last);
        }

        if (quote) {
            throw new IllegalArgumentException("Unterminated quote");
        }
    }

    /**
     * Changes the pattern of this simple date format to the specified pattern
     * which uses localized pattern characters.
     *
     * @param template
     *            the localized pattern.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.079 -0500", hash_original_method = "9688C7F66E6F76D1BE1FBD610A4BC951", hash_generated_method = "9B81995D24CAE7A81EB817AEC4C3844B")
    
public void applyLocalizedPattern(String template) {
        pattern = convertPattern(template, formatData.getLocalPatternChars(), PATTERN_CHARS, true);
    }

    /**
     * Changes the pattern of this simple date format to the specified pattern
     * which uses non-localized pattern characters.
     *
     * @param template
     *            the non-localized pattern.
     * @throws NullPointerException
     *                if the pattern is {@code null}.
     * @throws IllegalArgumentException
     *                if the pattern is invalid.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.081 -0500", hash_original_method = "3EFD18F746D60C3172C5216CCD625C1E", hash_generated_method = "F2F9C2909A53DF682B6C07C7CC473170")
    
public void applyPattern(String template) {
        validatePattern(template);
        pattern = template;
    }

    /**
     * Returns a new {@code SimpleDateFormat} with the same pattern and
     * properties as this simple date format.
     *
     * @return a shallow copy of this simple date format.
     * @see java.lang.Cloneable
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.084 -0500", hash_original_method = "894F4ABDB71A6E4F1997CC330255AFC7", hash_generated_method = "D0396D0AF64117B3ADAF61FE83EBE065")
    
@Override
    public Object clone() {
        SimpleDateFormat clone = (SimpleDateFormat) super.clone();
        clone.formatData = (DateFormatSymbols) formatData.clone();
        clone.defaultCenturyStart = new Date(defaultCenturyStart.getTime());
        return clone;
    }

    /**
     * Compares the specified object with this simple date format and indicates
     * if they are equal. In order to be equal, {@code object} must be an
     * instance of {@code SimpleDateFormat} and have the same {@code DateFormat}
     * properties, pattern, {@code DateFormatSymbols} and creation year.
     *
     * @param object
     *            the object to compare with this object.
     * @return {@code true} if the specified object is equal to this simple date
     *         format; {@code false} otherwise.
     * @see #hashCode
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.089 -0500", hash_original_method = "386F5EAAB97078077630DB3A1FE9C0D6", hash_generated_method = "12C2795BBBA4D4FDEB8798DF0BFB4376")
    
@Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof SimpleDateFormat)) {
            return false;
        }
        SimpleDateFormat simple = (SimpleDateFormat) object;
        return super.equals(object) && pattern.equals(simple.pattern)
                && formatData.equals(simple.formatData);
    }

    /**
     * Formats the specified object using the rules of this simple date format
     * and returns an {@code AttributedCharacterIterator} with the formatted
     * date and attributes.
     *
     * @param object
     *            the object to format.
     * @return an {@code AttributedCharacterIterator} with the formatted date
     *         and attributes.
     * @throws NullPointerException
     *            if the object is {@code null}.
     * @throws IllegalArgumentException
     *            if the object cannot be formatted by this simple date
     *            format.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.092 -0500", hash_original_method = "F8A48BC85545A42AFE53260512DF9B2E", hash_generated_method = "9EAC7DF5A1F47B4E3861E6DF79531AD6")
    
@Override
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        if (object instanceof Date) {
            return formatToCharacterIteratorImpl((Date) object);
        }
        if (object instanceof Number) {
            return formatToCharacterIteratorImpl(new Date(((Number) object).longValue()));
        }
        throw new IllegalArgumentException();

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.095 -0500", hash_original_method = "39C7DAF020DB077C56334C25B45C6758", hash_generated_method = "4269B45109BDFCDABAE8B23522415D35")
    
private AttributedCharacterIterator formatToCharacterIteratorImpl(Date date) {
        StringBuffer buffer = new StringBuffer();
        ArrayList<FieldPosition> fields = new ArrayList<FieldPosition>();

        // format the date, and find fields
        formatImpl(date, buffer, null, fields);

        // create and AttributedString with the formatted buffer
        AttributedString as = new AttributedString(buffer.toString());

        // add DateFormat field attributes to the AttributedString
        for (FieldPosition pos : fields) {
            Format.Field attribute = pos.getFieldAttribute();
            as.addAttribute(attribute, attribute, pos.getBeginIndex(), pos.getEndIndex());
        }

        // return the CharacterIterator from AttributedString
        return as.getIterator();
    }

    /**
     * Formats the date.
     * <p>
     * If the FieldPosition {@code field} is not null, and the field
     * specified by this FieldPosition is formatted, set the begin and end index
     * of the formatted field in the FieldPosition.
     * <p>
     * If the list {@code fields} is not null, find fields of this
     * date, set FieldPositions with these fields, and add them to the fields
     * vector.
     *
     * @param date
     *            Date to Format
     * @param buffer
     *            StringBuffer to store the resulting formatted String
     * @param field
     *            FieldPosition to set begin and end index of the field
     *            specified, if it is part of the format for this date
     * @param fields
     *            list used to store the FieldPositions for each field in this
     *            date
     * @return the formatted Date
     * @throws IllegalArgumentException
     *            if the object cannot be formatted by this Format.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.098 -0500", hash_original_method = "1377B288F93939E9FA031027B23EE480", hash_generated_method = "36FBAF57FBC342C85330D39DAC1A304D")
    
private StringBuffer formatImpl(Date date, StringBuffer buffer,
            FieldPosition field, List<FieldPosition> fields) {

        boolean quote = false;
        int next, last = -1, count = 0;
        calendar.setTime(date);
        if (field != null) {
            field.clear();
        }

        final int patternLength = pattern.length();
        for (int i = 0; i < patternLength; i++) {
            next = (pattern.charAt(i));
            if (next == '\'') {
                if (count > 0) {
                    append(buffer, field, fields, (char) last, count);
                    count = 0;
                }
                if (last == next) {
                    buffer.append('\'');
                    last = -1;
                } else {
                    last = next;
                }
                quote = !quote;
                continue;
            }
            if (!quote
                    && (last == next || (next >= 'a' && next <= 'z') || (next >= 'A' && next <= 'Z'))) {
                if (last == next) {
                    count++;
                } else {
                    if (count > 0) {
                        append(buffer, field, fields, (char) last, count);
                    }
                    last = next;
                    count = 1;
                }
            } else {
                if (count > 0) {
                    append(buffer, field, fields, (char) last, count);
                    count = 0;
                }
                last = -1;
                buffer.append((char) next);
            }
        }
        if (count > 0) {
            append(buffer, field, fields, (char) last, count);
        }
        return buffer;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.104 -0500", hash_original_method = "60C88CC31EC17788C6D13B63E0E097AB", hash_generated_method = "EA5E146546A756BECC591632A6C674F2")
    
private void append(StringBuffer buffer, FieldPosition position,
            List<FieldPosition> fields, char format, int count) {
        int field = -1;
        int index = PATTERN_CHARS.indexOf(format);
        if (index == -1) {
            throw new IllegalArgumentException("Unknown pattern character '" + format + "'");
        }

        int beginPosition = buffer.length();
        Field dateFormatField = null;
        switch (index) {
            case ERA_FIELD:
                dateFormatField = Field.ERA;
                buffer.append(formatData.eras[calendar.get(Calendar.ERA)]);
                break;
            case YEAR_FIELD:
                dateFormatField = Field.YEAR;
                int year = calendar.get(Calendar.YEAR);
                /*
                 * For 'y' and 'yyy', we're consistent with Unicode and previous releases
                 * of Android. But this means we're inconsistent with the RI.
                 *     http://unicode.org/reports/tr35/
                 */
                if (count == 2) {
                    appendNumber(buffer, 2, year % 100);
                } else {
                    appendNumber(buffer, count, year);
                }
                break;
            case STAND_ALONE_MONTH_FIELD: // L
                dateFormatField = Field.MONTH;
                appendMonth(buffer, count, formatData.longStandAloneMonths, formatData.shortStandAloneMonths);
                break;
            case MONTH_FIELD: // M
                dateFormatField = Field.MONTH;
                appendMonth(buffer, count, formatData.months, formatData.shortMonths);
                break;
            case DATE_FIELD:
                dateFormatField = Field.DAY_OF_MONTH;
                field = Calendar.DATE;
                break;
            case HOUR_OF_DAY1_FIELD: // k
                dateFormatField = Field.HOUR_OF_DAY1;
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                appendNumber(buffer, count, hour == 0 ? 24 : hour);
                break;
            case HOUR_OF_DAY0_FIELD: // H
                dateFormatField = Field.HOUR_OF_DAY0;
                field = Calendar.HOUR_OF_DAY;
                break;
            case MINUTE_FIELD:
                dateFormatField = Field.MINUTE;
                field = Calendar.MINUTE;
                break;
            case SECOND_FIELD:
                dateFormatField = Field.SECOND;
                field = Calendar.SECOND;
                break;
            case MILLISECOND_FIELD:
                dateFormatField = Field.MILLISECOND;
                int value = calendar.get(Calendar.MILLISECOND);
                appendNumber(buffer, count, value);
                break;
            case STAND_ALONE_DAY_OF_WEEK_FIELD:
                dateFormatField = Field.DAY_OF_WEEK;
                appendDayOfWeek(buffer, count, formatData.longStandAloneWeekdays, formatData.shortStandAloneWeekdays);
                break;
            case DAY_OF_WEEK_FIELD:
                dateFormatField = Field.DAY_OF_WEEK;
                appendDayOfWeek(buffer, count, formatData.weekdays, formatData.shortWeekdays);
                break;
            case DAY_OF_YEAR_FIELD:
                dateFormatField = Field.DAY_OF_YEAR;
                field = Calendar.DAY_OF_YEAR;
                break;
            case DAY_OF_WEEK_IN_MONTH_FIELD:
                dateFormatField = Field.DAY_OF_WEEK_IN_MONTH;
                field = Calendar.DAY_OF_WEEK_IN_MONTH;
                break;
            case WEEK_OF_YEAR_FIELD:
                dateFormatField = Field.WEEK_OF_YEAR;
                field = Calendar.WEEK_OF_YEAR;
                break;
            case WEEK_OF_MONTH_FIELD:
                dateFormatField = Field.WEEK_OF_MONTH;
                field = Calendar.WEEK_OF_MONTH;
                break;
            case AM_PM_FIELD:
                dateFormatField = Field.AM_PM;
                buffer.append(formatData.ampms[calendar.get(Calendar.AM_PM)]);
                break;
            case HOUR1_FIELD: // h
                dateFormatField = Field.HOUR1;
                hour = calendar.get(Calendar.HOUR);
                appendNumber(buffer, count, hour == 0 ? 12 : hour);
                break;
            case HOUR0_FIELD: // K
                dateFormatField = Field.HOUR0;
                field = Calendar.HOUR;
                break;
            case TIMEZONE_FIELD: // z
                dateFormatField = Field.TIME_ZONE;
                appendTimeZone(buffer, count, true);
                break;
            case RFC_822_TIMEZONE_FIELD: // Z
                dateFormatField = Field.TIME_ZONE;
                appendNumericTimeZone(buffer, false);
                break;
        }
        if (field != -1) {
            appendNumber(buffer, count, calendar.get(field));
        }

        if (fields != null) {
            position = new FieldPosition(dateFormatField);
            position.setBeginIndex(beginPosition);
            position.setEndIndex(buffer.length());
            fields.add(position);
        } else {
            // Set to the first occurrence
            if ((position.getFieldAttribute() == dateFormatField || (position
                    .getFieldAttribute() == null && position.getField() == index))
                    && position.getEndIndex() == 0) {
                position.setBeginIndex(beginPosition);
                position.setEndIndex(buffer.length());
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.106 -0500", hash_original_method = "DD478E87C0FA9016B83D28121FBA02DB", hash_generated_method = "62D8176C354F6CA4270DDAEDA6611069")
    
private void appendDayOfWeek(StringBuffer buffer, int count, String[] longs, String[] shorts) {
        boolean isLong = (count > 3);
        String[] days = isLong ? longs : shorts;
        buffer.append(days[calendar.get(Calendar.DAY_OF_WEEK)]);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.109 -0500", hash_original_method = "7A41E7167A1A13C1027D42A61A5B401C", hash_generated_method = "3DF6C7C327520361A845637D593DEC47")
    
private void appendMonth(StringBuffer buffer, int count, String[] longs, String[] shorts) {
        int month = calendar.get(Calendar.MONTH);
        if (count <= 2) {
            appendNumber(buffer, count, month + 1);
            return;
        }

        boolean isLong = (count > 3);
        String[] months = isLong ? longs : shorts;
        buffer.append(months[month]);
    }

    /**
     * Append a representation of the time zone of 'calendar' to 'buffer'.
     *
     * @param count the number of z or Z characters in the format string; "zzz" would be 3,
     * for example.
     * @param generalTimeZone true if we should use a display name ("PDT") if available;
     * false implies that we should use RFC 822 format ("-0800") instead. This corresponds to 'z'
     * versus 'Z' in the format string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.112 -0500", hash_original_method = "D7241707B86764AD36DA13023C5322B5", hash_generated_method = "EF0C4077378AB8F224EE2E770C8B4D87")
    
private void appendTimeZone(StringBuffer buffer, int count, boolean generalTimeZone) {
        if (generalTimeZone) {
            TimeZone tz = calendar.getTimeZone();
            boolean daylight = (calendar.get(Calendar.DST_OFFSET) != 0);
            int style = count < 4 ? TimeZone.SHORT : TimeZone.LONG;
            if (!formatData.customZoneStrings) {
                buffer.append(tz.getDisplayName(daylight, style, formatData.locale));
                return;
            }
            // We can't call TimeZone.getDisplayName() because it would not use
            // the custom DateFormatSymbols of this SimpleDateFormat.
            String custom = TimeZones.getDisplayName(formatData.zoneStrings, tz.getID(), daylight, style);
            if (custom != null) {
                buffer.append(custom);
                return;
            }
        }
        // We didn't find what we were looking for, so default to a numeric time zone.
        appendNumericTimeZone(buffer, generalTimeZone);
    }

    /**
     * @param generalTimeZone "GMT-08:00" rather than "-0800".
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.114 -0500", hash_original_method = "E1D84DE5BC6EBCC18019540ED725D9AE", hash_generated_method = "F1ADD90E358970C96463D3A14ADFAEC7")
    
private void appendNumericTimeZone(StringBuffer buffer, boolean generalTimeZone) {
        int offset = calendar.get(Calendar.ZONE_OFFSET) + calendar.get(Calendar.DST_OFFSET);
        char sign = '+';
        if (offset < 0) {
            sign = '-';
            offset = -offset;
        }
        if (generalTimeZone) {
            buffer.append("GMT");
        }
        buffer.append(sign);
        appendNumber(buffer, 2, offset / 3600000);
        if (generalTimeZone) {
            buffer.append(':');
        }
        appendNumber(buffer, 2, (offset % 3600000) / 60000);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.117 -0500", hash_original_method = "9FC1BA4007CF5C77F0A2B74AE6FBC98F", hash_generated_method = "A8E9337BDCA56FAC6220A63CD2F4DB3F")
    
private void appendNumber(StringBuffer buffer, int count, int value) {
        // TODO: we could avoid using the NumberFormat in most cases for a significant speedup.
        // The only problem is that we expose the NumberFormat to third-party code, so we'd have
        // some work to do to work out when the optimization is valid.
        int minimumIntegerDigits = numberFormat.getMinimumIntegerDigits();
        numberFormat.setMinimumIntegerDigits(count);
        numberFormat.format(Integer.valueOf(value), buffer, new FieldPosition(0));
        numberFormat.setMinimumIntegerDigits(minimumIntegerDigits);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.120 -0500", hash_original_method = "332B10C296E05CECE855CC96158B0A61", hash_generated_method = "DA3B57BDCF1C9B301BA9760F2951B0C8")
    
private Date error(ParsePosition position, int offset, TimeZone zone) {
        position.setErrorIndex(offset);
        calendar.setTimeZone(zone);
        return null;
    }

    /**
     * Formats the specified date as a string using the pattern of this date
     * format and appends the string to the specified string buffer.
     * <p>
     * If the {@code field} member of {@code field} contains a value specifying
     * a format field, then its {@code beginIndex} and {@code endIndex} members
     * will be updated with the position of the first occurrence of this field
     * in the formatted text.
     *
     * @param date
     *            the date to format.
     * @param buffer
     *            the target string buffer to append the formatted date/time to.
     * @param fieldPos
     *            on input: an optional alignment field; on output: the offsets
     *            of the alignment field in the formatted text.
     * @return the string buffer.
     * @throws IllegalArgumentException
     *             if there are invalid characters in the pattern.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.122 -0500", hash_original_method = "F2F2556FE533C0A730BEC347E52E5292", hash_generated_method = "03617E1213EA0CE091B1A42EE8FE9EE4")
    
@Override
    public StringBuffer format(Date date, StringBuffer buffer, FieldPosition fieldPos) {
        // Harmony delegates to ICU's SimpleDateFormat, we implement it directly
        return formatImpl(date, buffer, fieldPos, null);
    }

    /**
     * Returns the date which is the start of the one hundred year period for two-digit year values.
     * See {@link #set2DigitYearStart} for details.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.124 -0500", hash_original_method = "71AF220EE7B6857040DD249E69ABFBDC", hash_generated_method = "E74FAA143E85741BE4E1784A56BEBA05")
    
public Date get2DigitYearStart() {
        return (Date) defaultCenturyStart.clone();
    }

    /**
     * Returns the {@code DateFormatSymbols} used by this simple date format.
     *
     * @return the {@code DateFormatSymbols} object.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.127 -0500", hash_original_method = "CB6B47612D51E0A5BF8CB9FEBD927C3E", hash_generated_method = "205D974A5D75894D76F8CEEF2351B5EF")
    
public DateFormatSymbols getDateFormatSymbols() {
        return (DateFormatSymbols) formatData.clone();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.129 -0500", hash_original_method = "90B9D79300B8D8466B4A869D0B95FB5A", hash_generated_method = "ADE3F1602E201DDEC32E7E4E6B076FBB")
    
@Override
    public int hashCode() {
        return super.hashCode() + pattern.hashCode() + formatData.hashCode() + creationYear;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.134 -0500", hash_original_method = "308621012329CC130ED3BC1A1EBA54C1", hash_generated_method = "4FD0ABFE3C0CD8E96E29712CBC74E1E8")
    
private int parse(String string, int offset, char format, int count) {
        int index = PATTERN_CHARS.indexOf(format);
        if (index == -1) {
            throw new IllegalArgumentException("Unknown pattern character '" + format + "'");
        }
        int field = -1;
        // TODO: what's 'absolute' for? when is 'count' negative, and why?
        int absolute = 0;
        if (count < 0) {
            count = -count;
            absolute = count;
        }
        switch (index) {
            case ERA_FIELD:
                return parseText(string, offset, formatData.eras, Calendar.ERA);
            case YEAR_FIELD:
                if (count >= 3) {
                    field = Calendar.YEAR;
                } else {
                    ParsePosition position = new ParsePosition(offset);
                    Number result = parseNumber(absolute, string, position);
                    if (result == null) {
                        return -position.getErrorIndex() - 1;
                    }
                    int year = result.intValue();
                    // A two digit year must be exactly two digits, i.e. 01
                    if ((position.getIndex() - offset) == 2 && year >= 0) {
                        year += creationYear / 100 * 100;
                        if (year < creationYear) {
                            year += 100;
                        }
                    }
                    calendar.set(Calendar.YEAR, year);
                    return position.getIndex();
                }
                break;
            case STAND_ALONE_MONTH_FIELD: // L
                return parseMonth(string, offset, count, absolute,
                        formatData.longStandAloneMonths, formatData.shortStandAloneMonths);
            case MONTH_FIELD: // M
                return parseMonth(string, offset, count, absolute,
                        formatData.months, formatData.shortMonths);
            case DATE_FIELD:
                field = Calendar.DATE;
                break;
            case HOUR_OF_DAY1_FIELD: // k
                ParsePosition position = new ParsePosition(offset);
                Number result = parseNumber(absolute, string, position);
                if (result == null) {
                    return -position.getErrorIndex() - 1;
                }
                int hour = result.intValue();
                if (hour == 24) {
                    hour = 0;
                }
                calendar.set(Calendar.HOUR_OF_DAY, hour);
                return position.getIndex();
            case HOUR_OF_DAY0_FIELD: // H
                field = Calendar.HOUR_OF_DAY;
                break;
            case MINUTE_FIELD:
                field = Calendar.MINUTE;
                break;
            case SECOND_FIELD:
                field = Calendar.SECOND;
                break;
            case MILLISECOND_FIELD:
                field = Calendar.MILLISECOND;
                break;
            case STAND_ALONE_DAY_OF_WEEK_FIELD:
                return parseDayOfWeek(string, offset, formatData.longStandAloneWeekdays, formatData.shortStandAloneWeekdays);
            case DAY_OF_WEEK_FIELD:
                return parseDayOfWeek(string, offset, formatData.weekdays, formatData.shortWeekdays);
            case DAY_OF_YEAR_FIELD:
                field = Calendar.DAY_OF_YEAR;
                break;
            case DAY_OF_WEEK_IN_MONTH_FIELD:
                field = Calendar.DAY_OF_WEEK_IN_MONTH;
                break;
            case WEEK_OF_YEAR_FIELD:
                field = Calendar.WEEK_OF_YEAR;
                break;
            case WEEK_OF_MONTH_FIELD:
                field = Calendar.WEEK_OF_MONTH;
                break;
            case AM_PM_FIELD:
                return parseText(string, offset, formatData.ampms, Calendar.AM_PM);
            case HOUR1_FIELD: // h
                position = new ParsePosition(offset);
                result = parseNumber(absolute, string, position);
                if (result == null) {
                    return -position.getErrorIndex() - 1;
                }
                hour = result.intValue();
                if (hour == 12) {
                    hour = 0;
                }
                calendar.set(Calendar.HOUR, hour);
                return position.getIndex();
            case HOUR0_FIELD: // K
                field = Calendar.HOUR;
                break;
            case TIMEZONE_FIELD: // z
                return parseTimeZone(string, offset);
            case RFC_822_TIMEZONE_FIELD: // Z
                return parseTimeZone(string, offset);
        }
        if (field != -1) {
            return parseNumber(absolute, string, offset, field, 0);
        }
        return offset;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.137 -0500", hash_original_method = "4C5DAB8F3090E0FED455AF9657387367", hash_generated_method = "73128BA64BF014A304288ADA8E91211D")
    
private int parseDayOfWeek(String string, int offset, String[] longs, String[] shorts) {
        int index = parseText(string, offset, longs, Calendar.DAY_OF_WEEK);
        if (index < 0) {
            index = parseText(string, offset, shorts, Calendar.DAY_OF_WEEK);
        }
        return index;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.139 -0500", hash_original_method = "2749F9959CF57ED8E7DF53A146C2F50E", hash_generated_method = "166162ACB3B56B141E53976292994FD6")
    
private int parseMonth(String string, int offset, int count, int absolute, String[] longs, String[] shorts) {
        if (count <= 2) {
            return parseNumber(absolute, string, offset, Calendar.MONTH, -1);
        }
        int index = parseText(string, offset, longs, Calendar.MONTH);
        if (index < 0) {
            index = parseText(string, offset, shorts, Calendar.MONTH);
        }
        return index;
    }

    /**
     * Parses a date from the specified string starting at the index specified
     * by {@code position}. If the string is successfully parsed then the index
     * of the {@code ParsePosition} is updated to the index following the parsed
     * text. On error, the index is unchanged and the error index of {@code
     * ParsePosition} is set to the index where the error occurred.
     *
     * @param string
     *            the string to parse using the pattern of this simple date
     *            format.
     * @param position
     *            input/output parameter, specifies the start index in {@code
     *            string} from where to start parsing. If parsing is successful,
     *            it is updated with the index following the parsed text; on
     *            error, the index is unchanged and the error index is set to
     *            the index where the error occurred.
     * @return the date resulting from the parse, or {@code null} if there is an
     *         error.
     * @throws IllegalArgumentException
     *             if there are invalid characters in the pattern.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.144 -0500", hash_original_method = "7359DD4332D8271AC0BCC2D6C59D8B62", hash_generated_method = "EB55FA63405C87E1036FE69E8D3600F0")
    
@Override
    public Date parse(String string, ParsePosition position) {
        // Harmony delegates to ICU's SimpleDateFormat, we implement it directly
        boolean quote = false;
        int next, last = -1, count = 0, offset = position.getIndex();
        int length = string.length();
        calendar.clear();
        TimeZone zone = calendar.getTimeZone();
        final int patternLength = pattern.length();
        for (int i = 0; i < patternLength; i++) {
            next = pattern.charAt(i);
            if (next == '\'') {
                if (count > 0) {
                    if ((offset = parse(string, offset, (char) last, count)) < 0) {
                        return error(position, -offset - 1, zone);
                    }
                    count = 0;
                }
                if (last == next) {
                    if (offset >= length || string.charAt(offset) != '\'') {
                        return error(position, offset, zone);
                    }
                    offset++;
                    last = -1;
                } else {
                    last = next;
                }
                quote = !quote;
                continue;
            }
            if (!quote
                    && (last == next || (next >= 'a' && next <= 'z') || (next >= 'A' && next <= 'Z'))) {
                if (last == next) {
                    count++;
                } else {
                    if (count > 0) {
                        if ((offset = parse(string, offset, (char) last, -count)) < 0) {
                            return error(position, -offset - 1, zone);
                        }
                    }
                    last = next;
                    count = 1;
                }
            } else {
                if (count > 0) {
                    if ((offset = parse(string, offset, (char) last, count)) < 0) {
                        return error(position, -offset - 1, zone);
                    }
                    count = 0;
                }
                last = -1;
                if (offset >= length || string.charAt(offset) != next) {
                    return error(position, offset, zone);
                }
                offset++;
            }
        }
        if (count > 0) {
            if ((offset = parse(string, offset, (char) last, count)) < 0) {
                return error(position, -offset - 1, zone);
            }
        }
        Date date;
        try {
            date = calendar.getTime();
        } catch (IllegalArgumentException e) {
            return error(position, offset, zone);
        }
        position.setIndex(offset);
        calendar.setTimeZone(zone);
        return date;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.147 -0500", hash_original_method = "21C7D4A169609BA40C676EFC62A50E23", hash_generated_method = "E770EAFE96F6F02CFDA569B162E2C388")
    
private Number parseNumber(int max, String string, ParsePosition position) {
        int digit, length = string.length(), result = 0;
        int index = position.getIndex();
        if (max > 0 && max < length - index) {
            length = index + max;
        }
        while (index < length
                && (string.charAt(index) == ' ' || string.charAt(index) == '\t')) {
            index++;
        }
        if (max == 0) {
            position.setIndex(index);
            return numberFormat.parse(string, position);
        }

        while (index < length
                && (digit = Character.digit(string.charAt(index), 10)) != -1) {
            index++;
            result = result * 10 + digit;
        }
        if (index == position.getIndex()) {
            position.setErrorIndex(index);
            return null;
        }
        position.setIndex(index);
        return Integer.valueOf(result);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.149 -0500", hash_original_method = "D6F7D67552A406D8EA22E8B872F7B057", hash_generated_method = "1C99299274EC12D0A55D501E0A1B9654")
    
private int parseNumber(int max, String string, int offset, int field, int skew) {
        ParsePosition position = new ParsePosition(offset);
        Number result = parseNumber(max, string, position);
        if (result == null) {
            return -position.getErrorIndex() - 1;
        }
        calendar.set(field, result.intValue() + skew);
        return position.getIndex();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.152 -0500", hash_original_method = "6091F52EF6DC933856441BD49E0F31F1", hash_generated_method = "80CBD34C39C037F0F747F6D54CD77301")
    
private int parseText(String string, int offset, String[] text, int field) {
        int found = -1;
        for (int i = 0; i < text.length; i++) {
            if (text[i].isEmpty()) {
                continue;
            }
            if (string.regionMatches(true, offset, text[i], 0, text[i].length())) {
                // Search for the longest match, in case some fields are subsets
                if (found == -1 || text[i].length() > text[found].length()) {
                    found = i;
                }
            }
        }
        if (found != -1) {
            calendar.set(field, found);
            return offset + text[found].length();
        }
        return -offset - 1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.156 -0500", hash_original_method = "C11BF6380CD6AEFF5BAB825547AF7C4A", hash_generated_method = "9CECC94FE614EB29D256C9EC771C866D")
    
private int parseTimeZone(String string, int offset) {
        boolean foundGMT = string.regionMatches(offset, "GMT", 0, 3);
        if (foundGMT) {
            offset += 3;
        }
        char sign;
        if (offset < string.length()
                && ((sign = string.charAt(offset)) == '+' || sign == '-')) {
            ParsePosition position = new ParsePosition(offset + 1);
            Number result = numberFormat.parse(string, position);
            if (result == null) {
                return -position.getErrorIndex() - 1;
            }
            int hour = result.intValue();
            int raw = hour * 3600000;
            int index = position.getIndex();
            if (index < string.length() && string.charAt(index) == ':') {
                position.setIndex(index + 1);
                result = numberFormat.parse(string, position);
                if (result == null) {
                    return -position.getErrorIndex() - 1;
                }
                int minute = result.intValue();
                raw += minute * 60000;
            } else if (hour >= 24) {
                raw = (hour / 100 * 3600000) + (hour % 100 * 60000);
            }
            if (sign == '-') {
                raw = -raw;
            }
            calendar.setTimeZone(new SimpleTimeZone(raw, ""));
            return position.getIndex();
        }
        if (foundGMT) {
            calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
            return offset;
        }
        String[][] zones = formatData.internalZoneStrings();
        for (String[] element : zones) {
            for (int j = TimeZones.LONG_NAME; j < TimeZones.NAME_COUNT; j++) {
                if (string.regionMatches(true, offset, element[j], 0, element[j].length())) {
                    TimeZone zone = TimeZone.getTimeZone(element[TimeZones.OLSON_NAME]);
                    if (zone == null) {
                        return -offset - 1;
                    }
                    int raw = zone.getRawOffset();
                    if (j == TimeZones.LONG_NAME_DST || j == TimeZones.SHORT_NAME_DST) {
                        /*
                         * TODO, http://b/4723412
                         * We can't use TimeZone#getDSTSavings here because that
                         * will return 0 if the zone no longer uses DST. We
                         * should change this to use TimeZone.getOffset(long),
                         * which requires the complete date to be parsed first.
                         */
                        raw += 3600000;
                    }
                    calendar.setTimeZone(new SimpleTimeZone(raw, ""));
                    return offset + element[j].length();
                }
            }
        }
        return -offset - 1;
    }

    /**
     * Sets the date which is the start of the one hundred year period for two-digit year values.
     *
     * <p>When parsing a date string using the abbreviated year pattern {@code yy}, {@code
     * SimpleDateFormat} must interpret the abbreviated year relative to some
     * century. It does this by adjusting dates to be within 80 years before and 20
     * years after the time the {@code SimpleDateFormat} instance was created. For
     * example, using a pattern of {@code MM/dd/yy}, an
     * instance created on Jan 1, 1997 would interpret the string {@code "01/11/12"}
     * as Jan 11, 2012 but interpret the string {@code "05/04/64"} as May 4, 1964.
     * During parsing, only strings consisting of exactly two digits, as
     * defined by {@link java.lang.Character#isDigit(char)}, will be parsed into the
     * default century. Any other numeric string, such as a one digit string, a
     * three or more digit string, or a two digit string that isn't all digits (for
     * example, {@code "-1"}), is interpreted literally. So using the same pattern, both
     * {@code "01/02/3"} and {@code "01/02/003"} are parsed as Jan 2, 3 AD.
     * Similarly, {@code "01/02/-3"} is parsed as Jan 2, 4 BC.
     *
     * <p>If the year pattern does not have exactly two 'y' characters, the year is
     * interpreted literally, regardless of the number of digits. So using the
     * pattern {@code MM/dd/yyyy}, {@code "01/11/12"} is parsed as Jan 11, 12 A.D.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.159 -0500", hash_original_method = "893CAD0A3A74697E4DAD4463A5252E56", hash_generated_method = "48F4698F555F5A8A349303AFDE857911")
    
public void set2DigitYearStart(Date date) {
        defaultCenturyStart = (Date) date.clone();
        Calendar cal = new GregorianCalendar();
        cal.setTime(defaultCenturyStart);
        creationYear = cal.get(Calendar.YEAR);
    }

    /**
     * Sets the {@code DateFormatSymbols} used by this simple date format.
     *
     * @param value
     *            the new {@code DateFormatSymbols} object.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.161 -0500", hash_original_method = "4ECB9E8EB801E57F7682FCC8E531C475", hash_generated_method = "88A555D21095717934BB05D273D92D69")
    
public void setDateFormatSymbols(DateFormatSymbols value) {
        formatData = (DateFormatSymbols) value.clone();
    }

    /**
     * Returns the pattern of this simple date format using localized pattern
     * characters.
     *
     * @return the localized pattern.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.164 -0500", hash_original_method = "0CBAC1F89B5D111A3585F82BE6753903", hash_generated_method = "1CBD29E7E334507A5B5A2B3CECE9D604")
    
public String toLocalizedPattern() {
        return convertPattern(pattern, PATTERN_CHARS, formatData.getLocalPatternChars(), false);
    }

    /**
     * Returns the pattern of this simple date format using non-localized
     * pattern characters.
     *
     * @return the non-localized pattern.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.169 -0500", hash_original_method = "35D638E960413F452190EF441C98A34C", hash_generated_method = "5CD84E1ED88608B4AC68B8A630BD6A44")
    
public String toPattern() {
        return pattern;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.174 -0500", hash_original_method = "C5F79137BB7206158B23593D7F9B176B", hash_generated_method = "C150C85536BFA38D40BA2DD9527521D8")
    
private void writeObject(ObjectOutputStream stream) throws IOException {
        ObjectOutputStream.PutField fields = stream.putFields();
        fields.put("defaultCenturyStart", defaultCenturyStart);
        fields.put("formatData", formatData);
        fields.put("pattern", pattern);
        fields.put("serialVersionOnStream", 1);
        stream.writeFields();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.178 -0500", hash_original_method = "8B9631F89FAD33D3B003933051524309", hash_generated_method = "AD5EEEF3C6F64B2951EFD39F3E01F710")
    
private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = stream.readFields();
        int version = fields.get("serialVersionOnStream", 0);
        Date date;
        if (version > 0) {
            date = (Date) fields.get("defaultCenturyStart", new Date());
        } else {
            date = new Date();
        }
        set2DigitYearStart(date);
        formatData = (DateFormatSymbols) fields.get("formatData", null);
        pattern = (String) fields.get("pattern", "");
    }
}

