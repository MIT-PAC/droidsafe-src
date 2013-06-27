package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.649 -0400", hash_original_field = "240BF022E685B0EE30AD9FE9E1FB5D5B", hash_generated_field = "8AE769BFE2CAD1B10C494CCD4D4D489A")

    private String pattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.649 -0400", hash_original_field = "B92E573129E9FB1D0BF38D29B8A706A2", hash_generated_field = "8EEEF9C78A0C692C98D78AB64DB0C20D")

    private DateFormatSymbols formatData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.650 -0400", hash_original_field = "712A97B2F4207AEC6A75B48EAB21BF85", hash_generated_field = "6DC58B2FFCD396D044D4105C5E7E21CC")

    transient private int creationYear;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.650 -0400", hash_original_field = "94D5A7D82D300ED81AB6D9A58D07F6BE", hash_generated_field = "7490904CE4798294C2932FA3B8A81D84")

    private Date defaultCenturyStart;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.650 -0400", hash_original_method = "55288B23256ED63825B1D49B41027576", hash_generated_method = "F82B18A1A66AF548F5C62D87F2131939")
    public  SimpleDateFormat() {
        this(Locale.getDefault());
        this.pattern = defaultPattern();
        this.formatData = new DateFormatSymbols(Locale.getDefault());
        // ---------- Original Method ----------
        //this.pattern = defaultPattern();
        //this.formatData = new DateFormatSymbols(Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.650 -0400", hash_original_method = "DF79561AB8D44B187C9CA04B354315AC", hash_generated_method = "D4A2069D1C68F4AB2BBA6AA73240C2D8")
    public  SimpleDateFormat(String pattern) {
        this(pattern, Locale.getDefault());
        addTaint(pattern.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.661 -0400", hash_original_method = "2C117D04FF17ED0139CEC7451AA4BD73", hash_generated_method = "BA4FDDD7A78A1236519D0152F2C887F3")
    public  SimpleDateFormat(String template, DateFormatSymbols value) {
        this(Locale.getDefault());
        validatePattern(template);
        pattern = template;
        formatData = (DateFormatSymbols) value.clone();
        // ---------- Original Method ----------
        //validatePattern(template);
        //pattern = template;
        //formatData = (DateFormatSymbols) value.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.661 -0400", hash_original_method = "1BCD123DF2A5414BB2A2ECF5D3357D25", hash_generated_method = "476D04B09E3E58E3666ECF86228F2313")
    public  SimpleDateFormat(String template, Locale locale) {
        this(locale);
        validatePattern(template);
        pattern = template;
        formatData = new DateFormatSymbols(locale);
        // ---------- Original Method ----------
        //validatePattern(template);
        //pattern = template;
        //formatData = new DateFormatSymbols(locale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.662 -0400", hash_original_method = "F464E2338695834D875FCA6185F1E83B", hash_generated_method = "1FF8E5DD3719875F7A36B1176107DB9C")
    private  SimpleDateFormat(Locale locale) {
        numberFormat = NumberFormat.getInstance(locale);
        numberFormat.setParseIntegerOnly(true);
        numberFormat.setGroupingUsed(false);
        calendar = new GregorianCalendar(locale);
        calendar.add(Calendar.YEAR, -80);
        creationYear = calendar.get(Calendar.YEAR);
        defaultCenturyStart = calendar.getTime();
        addTaint(locale.getTaint());
        // ---------- Original Method ----------
        //numberFormat = NumberFormat.getInstance(locale);
        //numberFormat.setParseIntegerOnly(true);
        //numberFormat.setGroupingUsed(false);
        //calendar = new GregorianCalendar(locale);
        //calendar.add(Calendar.YEAR, -80);
        //creationYear = calendar.get(Calendar.YEAR);
        //defaultCenturyStart = calendar.getTime();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.662 -0400", hash_original_method = "411C0D5D8AD5CB18D4C2CE04A3CEEBF0", hash_generated_method = "D58F884984DD85B724C2BD2F37ED9A89")
    private void validateFormat(char format) {
        int index;
        index = PATTERN_CHARS.indexOf(format);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown pattern character '" + format + "'");
        } //End block
        addTaint(format);
        // ---------- Original Method ----------
        //int index = PATTERN_CHARS.indexOf(format);
        //if (index == -1) {
            //throw new IllegalArgumentException("Unknown pattern character '" + format + "'");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.671 -0400", hash_original_method = "49C9E23BED9AC71209F0210F812D9D37", hash_generated_method = "7D3B27416FF1E01114200E637F129502")
    private void validatePattern(String template) {
        boolean quote;
        quote = false;
        int next, last, count;
        last = -1;
        count = 0;
        int patternLength;
        patternLength = template.length();
        {
            int i;
            i = 0;
            {
                next = (template.charAt(i));
                {
                    {
                        validateFormat((char) last);
                        count = 0;
                    } //End block
                    {
                        last = -1;
                    } //End block
                    {
                        last = next;
                    } //End block
                    quote = !quote;
                } //End block
                {
                    {
                        {
                            validateFormat((char) last);
                        } //End block
                        last = next;
                        count = 1;
                    } //End block
                } //End block
                {
                    {
                        validateFormat((char) last);
                        count = 0;
                    } //End block
                    last = -1;
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            validateFormat((char) last);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unterminated quote");
        } //End block
        addTaint(template.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.671 -0400", hash_original_method = "9688C7F66E6F76D1BE1FBD610A4BC951", hash_generated_method = "8E68E16C2D98EE10C6281ED8D7385F2A")
    public void applyLocalizedPattern(String template) {
        pattern = convertPattern(template, formatData.getLocalPatternChars(), PATTERN_CHARS, true);
        // ---------- Original Method ----------
        //pattern = convertPattern(template, formatData.getLocalPatternChars(), PATTERN_CHARS, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.672 -0400", hash_original_method = "3EFD18F746D60C3172C5216CCD625C1E", hash_generated_method = "3B487F85B3ED861181DD02458BC7C04B")
    public void applyPattern(String template) {
        validatePattern(template);
        pattern = template;
        // ---------- Original Method ----------
        //validatePattern(template);
        //pattern = template;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.672 -0400", hash_original_method = "894F4ABDB71A6E4F1997CC330255AFC7", hash_generated_method = "C775565899BF7423B47A43661A8FBBAA")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_400442292 = null; //Variable for return #1
        SimpleDateFormat clone;
        clone = (SimpleDateFormat) super.clone();
        clone.formatData = (DateFormatSymbols) formatData.clone();
        clone.defaultCenturyStart = new Date(defaultCenturyStart.getTime());
        varB4EAC82CA7396A68D541C85D26508E83_400442292 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_400442292.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_400442292;
        // ---------- Original Method ----------
        //SimpleDateFormat clone = (SimpleDateFormat) super.clone();
        //clone.formatData = (DateFormatSymbols) formatData.clone();
        //clone.defaultCenturyStart = new Date(defaultCenturyStart.getTime());
        //return clone;
    }

    
        private static String defaultPattern() {
        LocaleData localeData = LocaleData.get(Locale.getDefault());
        return localeData.getDateFormat(SHORT) + " " + localeData.getTimeFormat(SHORT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.673 -0400", hash_original_method = "386F5EAAB97078077630DB3A1FE9C0D6", hash_generated_method = "6823B35D816A7598613E922227763659")
    @Override
    public boolean equals(Object object) {
        SimpleDateFormat simple;
        simple = (SimpleDateFormat) object;
        boolean var8F00762234AC693C10F4824774BED328_1409987772 = (super.equals(object) && pattern.equals(simple.pattern)
                && formatData.equals(simple.formatData));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_103476612 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_103476612;
        // ---------- Original Method ----------
        //if (this == object) {
            //return true;
        //}
        //if (!(object instanceof SimpleDateFormat)) {
            //return false;
        //}
        //SimpleDateFormat simple = (SimpleDateFormat) object;
        //return super.equals(object) && pattern.equals(simple.pattern)
                //&& formatData.equals(simple.formatData);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.674 -0400", hash_original_method = "F8A48BC85545A42AFE53260512DF9B2E", hash_generated_method = "7BC7B946E48EFD871E0E1C5A166AF59C")
    @Override
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        AttributedCharacterIterator varB4EAC82CA7396A68D541C85D26508E83_483921244 = null; //Variable for return #1
        AttributedCharacterIterator varB4EAC82CA7396A68D541C85D26508E83_1392423906 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_483921244 = formatToCharacterIteratorImpl((Date) object);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1392423906 = formatToCharacterIteratorImpl(new Date(((Number) object).longValue()));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        addTaint(object.getTaint());
        AttributedCharacterIterator varA7E53CE21691AB073D9660D615818899_1635640957; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1635640957 = varB4EAC82CA7396A68D541C85D26508E83_483921244;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1635640957 = varB4EAC82CA7396A68D541C85D26508E83_1392423906;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1635640957.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1635640957;
        // ---------- Original Method ----------
        //if (object == null) {
            //throw new NullPointerException();
        //}
        //if (object instanceof Date) {
            //return formatToCharacterIteratorImpl((Date) object);
        //}
        //if (object instanceof Number) {
            //return formatToCharacterIteratorImpl(new Date(((Number) object).longValue()));
        //}
        //throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.711 -0400", hash_original_method = "39C7DAF020DB077C56334C25B45C6758", hash_generated_method = "DE46A7D7EE2043B13148EE810B45C03F")
    private AttributedCharacterIterator formatToCharacterIteratorImpl(Date date) {
        AttributedCharacterIterator varB4EAC82CA7396A68D541C85D26508E83_1085955449 = null; //Variable for return #1
        StringBuffer buffer;
        buffer = new StringBuffer();
        ArrayList<FieldPosition> fields;
        fields = new ArrayList<FieldPosition>();
        formatImpl(date, buffer, null, fields);
        AttributedString as;
        as = new AttributedString(buffer.toString());
        {
            Iterator<FieldPosition> var88F8042C83F53E4D1CB9979F97D9B388_1585651438 = (fields).iterator();
            var88F8042C83F53E4D1CB9979F97D9B388_1585651438.hasNext();
            FieldPosition pos = var88F8042C83F53E4D1CB9979F97D9B388_1585651438.next();
            {
                Format.Field attribute;
                attribute = pos.getFieldAttribute();
                as.addAttribute(attribute, attribute, pos.getBeginIndex(), pos.getEndIndex());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1085955449 = as.getIterator();
        addTaint(date.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1085955449.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1085955449;
        // ---------- Original Method ----------
        //StringBuffer buffer = new StringBuffer();
        //ArrayList<FieldPosition> fields = new ArrayList<FieldPosition>();
        //formatImpl(date, buffer, null, fields);
        //AttributedString as = new AttributedString(buffer.toString());
        //for (FieldPosition pos : fields) {
            //Format.Field attribute = pos.getFieldAttribute();
            //as.addAttribute(attribute, attribute, pos.getBeginIndex(), pos.getEndIndex());
        //}
        //return as.getIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.726 -0400", hash_original_method = "1377B288F93939E9FA031027B23EE480", hash_generated_method = "EB66293CAD45A30ED11C989545910A25")
    private StringBuffer formatImpl(Date date, StringBuffer buffer,
            FieldPosition field, List<FieldPosition> fields) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1438442401 = null; //Variable for return #1
        boolean quote;
        quote = false;
        int next, last, count;
        last = -1;
        count = 0;
        calendar.setTime(date);
        {
            field.clear();
        } //End block
        int patternLength;
        patternLength = pattern.length();
        {
            int i;
            i = 0;
            {
                next = (pattern.charAt(i));
                {
                    {
                        append(buffer, field, fields, (char) last, count);
                        count = 0;
                    } //End block
                    {
                        buffer.append('\'');
                        last = -1;
                    } //End block
                    {
                        last = next;
                    } //End block
                    quote = !quote;
                } //End block
                {
                    {
                        {
                            append(buffer, field, fields, (char) last, count);
                        } //End block
                        last = next;
                        count = 1;
                    } //End block
                } //End block
                {
                    {
                        append(buffer, field, fields, (char) last, count);
                        count = 0;
                    } //End block
                    last = -1;
                    buffer.append((char) next);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            append(buffer, field, fields, (char) last, count);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1438442401 = buffer;
        addTaint(date.getTaint());
        addTaint(buffer.getTaint());
        addTaint(field.getTaint());
        addTaint(fields.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1438442401.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1438442401;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.744 -0400", hash_original_method = "60C88CC31EC17788C6D13B63E0E097AB", hash_generated_method = "C05B98B2E1A6886924C7FF8C683C153F")
    private void append(StringBuffer buffer, FieldPosition position,
            List<FieldPosition> fields, char format, int count) {
        int field;
        field = -1;
        int index;
        index = PATTERN_CHARS.indexOf(format);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown pattern character '" + format + "'");
        } //End block
        int beginPosition;
        beginPosition = buffer.length();
        Field dateFormatField;
        dateFormatField = null;
        //Begin case ERA_FIELD 
        dateFormatField = Field.ERA;
        //End case ERA_FIELD 
        //Begin case ERA_FIELD 
        buffer.append(formatData.eras[calendar.get(Calendar.ERA)]);
        //End case ERA_FIELD 
        //Begin case YEAR_FIELD 
        dateFormatField = Field.YEAR;
        //End case YEAR_FIELD 
        //Begin case YEAR_FIELD 
        int year;
        year = calendar.get(Calendar.YEAR);
        //End case YEAR_FIELD 
        //Begin case YEAR_FIELD 
        {
            appendNumber(buffer, 2, year % 100);
        } //End block
        {
            appendNumber(buffer, count, year);
        } //End block
        //End case YEAR_FIELD 
        //Begin case STAND_ALONE_MONTH_FIELD 
        dateFormatField = Field.MONTH;
        //End case STAND_ALONE_MONTH_FIELD 
        //Begin case STAND_ALONE_MONTH_FIELD 
        appendMonth(buffer, count, formatData.longStandAloneMonths, formatData.shortStandAloneMonths);
        //End case STAND_ALONE_MONTH_FIELD 
        //Begin case MONTH_FIELD 
        dateFormatField = Field.MONTH;
        //End case MONTH_FIELD 
        //Begin case MONTH_FIELD 
        appendMonth(buffer, count, formatData.months, formatData.shortMonths);
        //End case MONTH_FIELD 
        //Begin case DATE_FIELD 
        dateFormatField = Field.DAY_OF_MONTH;
        //End case DATE_FIELD 
        //Begin case DATE_FIELD 
        field = Calendar.DATE;
        //End case DATE_FIELD 
        //Begin case HOUR_OF_DAY1_FIELD 
        dateFormatField = Field.HOUR_OF_DAY1;
        //End case HOUR_OF_DAY1_FIELD 
        //Begin case HOUR_OF_DAY1_FIELD 
        int hour;
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        //End case HOUR_OF_DAY1_FIELD 
        //Begin case HOUR_OF_DAY1_FIELD 
        appendNumber(buffer, count, hour == 0 ? 24 : hour);
        //End case HOUR_OF_DAY1_FIELD 
        //Begin case HOUR_OF_DAY0_FIELD 
        dateFormatField = Field.HOUR_OF_DAY0;
        //End case HOUR_OF_DAY0_FIELD 
        //Begin case HOUR_OF_DAY0_FIELD 
        field = Calendar.HOUR_OF_DAY;
        //End case HOUR_OF_DAY0_FIELD 
        //Begin case MINUTE_FIELD 
        dateFormatField = Field.MINUTE;
        //End case MINUTE_FIELD 
        //Begin case MINUTE_FIELD 
        field = Calendar.MINUTE;
        //End case MINUTE_FIELD 
        //Begin case SECOND_FIELD 
        dateFormatField = Field.SECOND;
        //End case SECOND_FIELD 
        //Begin case SECOND_FIELD 
        field = Calendar.SECOND;
        //End case SECOND_FIELD 
        //Begin case MILLISECOND_FIELD 
        dateFormatField = Field.MILLISECOND;
        //End case MILLISECOND_FIELD 
        //Begin case MILLISECOND_FIELD 
        int value;
        value = calendar.get(Calendar.MILLISECOND);
        //End case MILLISECOND_FIELD 
        //Begin case MILLISECOND_FIELD 
        appendNumber(buffer, count, value);
        //End case MILLISECOND_FIELD 
        //Begin case STAND_ALONE_DAY_OF_WEEK_FIELD 
        dateFormatField = Field.DAY_OF_WEEK;
        //End case STAND_ALONE_DAY_OF_WEEK_FIELD 
        //Begin case STAND_ALONE_DAY_OF_WEEK_FIELD 
        appendDayOfWeek(buffer, count, formatData.longStandAloneWeekdays, formatData.shortStandAloneWeekdays);
        //End case STAND_ALONE_DAY_OF_WEEK_FIELD 
        //Begin case DAY_OF_WEEK_FIELD 
        dateFormatField = Field.DAY_OF_WEEK;
        //End case DAY_OF_WEEK_FIELD 
        //Begin case DAY_OF_WEEK_FIELD 
        appendDayOfWeek(buffer, count, formatData.weekdays, formatData.shortWeekdays);
        //End case DAY_OF_WEEK_FIELD 
        //Begin case DAY_OF_YEAR_FIELD 
        dateFormatField = Field.DAY_OF_YEAR;
        //End case DAY_OF_YEAR_FIELD 
        //Begin case DAY_OF_YEAR_FIELD 
        field = Calendar.DAY_OF_YEAR;
        //End case DAY_OF_YEAR_FIELD 
        //Begin case DAY_OF_WEEK_IN_MONTH_FIELD 
        dateFormatField = Field.DAY_OF_WEEK_IN_MONTH;
        //End case DAY_OF_WEEK_IN_MONTH_FIELD 
        //Begin case DAY_OF_WEEK_IN_MONTH_FIELD 
        field = Calendar.DAY_OF_WEEK_IN_MONTH;
        //End case DAY_OF_WEEK_IN_MONTH_FIELD 
        //Begin case WEEK_OF_YEAR_FIELD 
        dateFormatField = Field.WEEK_OF_YEAR;
        //End case WEEK_OF_YEAR_FIELD 
        //Begin case WEEK_OF_YEAR_FIELD 
        field = Calendar.WEEK_OF_YEAR;
        //End case WEEK_OF_YEAR_FIELD 
        //Begin case WEEK_OF_MONTH_FIELD 
        dateFormatField = Field.WEEK_OF_MONTH;
        //End case WEEK_OF_MONTH_FIELD 
        //Begin case WEEK_OF_MONTH_FIELD 
        field = Calendar.WEEK_OF_MONTH;
        //End case WEEK_OF_MONTH_FIELD 
        //Begin case AM_PM_FIELD 
        dateFormatField = Field.AM_PM;
        //End case AM_PM_FIELD 
        //Begin case AM_PM_FIELD 
        buffer.append(formatData.ampms[calendar.get(Calendar.AM_PM)]);
        //End case AM_PM_FIELD 
        //Begin case HOUR1_FIELD 
        dateFormatField = Field.HOUR1;
        //End case HOUR1_FIELD 
        //Begin case HOUR1_FIELD 
        hour = calendar.get(Calendar.HOUR);
        //End case HOUR1_FIELD 
        //Begin case HOUR1_FIELD 
        appendNumber(buffer, count, hour == 0 ? 12 : hour);
        //End case HOUR1_FIELD 
        //Begin case HOUR0_FIELD 
        dateFormatField = Field.HOUR0;
        //End case HOUR0_FIELD 
        //Begin case HOUR0_FIELD 
        field = Calendar.HOUR;
        //End case HOUR0_FIELD 
        //Begin case TIMEZONE_FIELD 
        dateFormatField = Field.TIME_ZONE;
        //End case TIMEZONE_FIELD 
        //Begin case TIMEZONE_FIELD 
        appendTimeZone(buffer, count, true);
        //End case TIMEZONE_FIELD 
        //Begin case RFC_822_TIMEZONE_FIELD 
        dateFormatField = Field.TIME_ZONE;
        //End case RFC_822_TIMEZONE_FIELD 
        //Begin case RFC_822_TIMEZONE_FIELD 
        appendNumericTimeZone(buffer, false);
        //End case RFC_822_TIMEZONE_FIELD 
        {
            appendNumber(buffer, count, calendar.get(field));
        } //End block
        {
            position = new FieldPosition(dateFormatField);
            position.setBeginIndex(beginPosition);
            position.setEndIndex(buffer.length());
            fields.add(position);
        } //End block
        {
            {
                boolean varC55FDE01432B0DAD4F6A105898FCA625_2145253998 = ((position.getFieldAttribute() == dateFormatField || (position
                    .getFieldAttribute() == null && position.getField() == index))
                    && position.getEndIndex() == 0);
                {
                    position.setBeginIndex(beginPosition);
                    position.setEndIndex(buffer.length());
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(buffer.getTaint());
        addTaint(position.getTaint());
        addTaint(fields.getTaint());
        addTaint(format);
        addTaint(count);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.744 -0400", hash_original_method = "DD478E87C0FA9016B83D28121FBA02DB", hash_generated_method = "FEE7BE5A93E2649EA544A02B3161C9E7")
    private void appendDayOfWeek(StringBuffer buffer, int count, String[] longs, String[] shorts) {
        boolean isLong;
        isLong = (count > 3);
        String[] days;
        days = longs;
        days = shorts;
        buffer.append(days[calendar.get(Calendar.DAY_OF_WEEK)]);
        addTaint(buffer.getTaint());
        addTaint(count);
        addTaint(longs[0].getTaint());
        addTaint(shorts[0].getTaint());
        // ---------- Original Method ----------
        //boolean isLong = (count > 3);
        //String[] days = isLong ? longs : shorts;
        //buffer.append(days[calendar.get(Calendar.DAY_OF_WEEK)]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.758 -0400", hash_original_method = "7A41E7167A1A13C1027D42A61A5B401C", hash_generated_method = "31B68FD400FEBD360F4A256826549B1F")
    private void appendMonth(StringBuffer buffer, int count, String[] longs, String[] shorts) {
        int month;
        month = calendar.get(Calendar.MONTH);
        {
            appendNumber(buffer, count, month + 1);
        } //End block
        boolean isLong;
        isLong = (count > 3);
        String[] months;
        months = longs;
        months = shorts;
        buffer.append(months[month]);
        addTaint(buffer.getTaint());
        addTaint(count);
        addTaint(longs[0].getTaint());
        addTaint(shorts[0].getTaint());
        // ---------- Original Method ----------
        //int month = calendar.get(Calendar.MONTH);
        //if (count <= 2) {
            //appendNumber(buffer, count, month + 1);
            //return;
        //}
        //boolean isLong = (count > 3);
        //String[] months = isLong ? longs : shorts;
        //buffer.append(months[month]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.759 -0400", hash_original_method = "D7241707B86764AD36DA13023C5322B5", hash_generated_method = "D61074FCA957429EDF059C20F539907F")
    private void appendTimeZone(StringBuffer buffer, int count, boolean generalTimeZone) {
        {
            TimeZone tz;
            tz = calendar.getTimeZone();
            boolean daylight;
            daylight = (calendar.get(Calendar.DST_OFFSET) != 0);
            int style;
            style = TimeZone.SHORT;
            style = TimeZone.LONG;
            {
                buffer.append(tz.getDisplayName(daylight, style, formatData.locale));
            } //End block
            String custom;
            custom = TimeZones.getDisplayName(formatData.zoneStrings, tz.getID(), daylight, style);
            {
                buffer.append(custom);
            } //End block
        } //End block
        appendNumericTimeZone(buffer, generalTimeZone);
        addTaint(buffer.getTaint());
        addTaint(count);
        addTaint(generalTimeZone);
        // ---------- Original Method ----------
        //if (generalTimeZone) {
            //TimeZone tz = calendar.getTimeZone();
            //boolean daylight = (calendar.get(Calendar.DST_OFFSET) != 0);
            //int style = count < 4 ? TimeZone.SHORT : TimeZone.LONG;
            //if (!formatData.customZoneStrings) {
                //buffer.append(tz.getDisplayName(daylight, style, formatData.locale));
                //return;
            //}
            //String custom = TimeZones.getDisplayName(formatData.zoneStrings, tz.getID(), daylight, style);
            //if (custom != null) {
                //buffer.append(custom);
                //return;
            //}
        //}
        //appendNumericTimeZone(buffer, generalTimeZone);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.759 -0400", hash_original_method = "E1D84DE5BC6EBCC18019540ED725D9AE", hash_generated_method = "EB3E47D09E404D21766711E58A91ED09")
    private void appendNumericTimeZone(StringBuffer buffer, boolean generalTimeZone) {
        int offset;
        offset = calendar.get(Calendar.ZONE_OFFSET) + calendar.get(Calendar.DST_OFFSET);
        char sign;
        sign = '+';
        {
            sign = '-';
            offset = -offset;
        } //End block
        {
            buffer.append("GMT");
        } //End block
        buffer.append(sign);
        appendNumber(buffer, 2, offset / 3600000);
        {
            buffer.append(':');
        } //End block
        appendNumber(buffer, 2, (offset % 3600000) / 60000);
        addTaint(buffer.getTaint());
        addTaint(generalTimeZone);
        // ---------- Original Method ----------
        //int offset = calendar.get(Calendar.ZONE_OFFSET) + calendar.get(Calendar.DST_OFFSET);
        //char sign = '+';
        //if (offset < 0) {
            //sign = '-';
            //offset = -offset;
        //}
        //if (generalTimeZone) {
            //buffer.append("GMT");
        //}
        //buffer.append(sign);
        //appendNumber(buffer, 2, offset / 3600000);
        //if (generalTimeZone) {
            //buffer.append(':');
        //}
        //appendNumber(buffer, 2, (offset % 3600000) / 60000);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.759 -0400", hash_original_method = "9FC1BA4007CF5C77F0A2B74AE6FBC98F", hash_generated_method = "AA3F9CB02BAA07AFAA0F510395810D72")
    private void appendNumber(StringBuffer buffer, int count, int value) {
        int minimumIntegerDigits;
        minimumIntegerDigits = numberFormat.getMinimumIntegerDigits();
        numberFormat.setMinimumIntegerDigits(count);
        numberFormat.format(Integer.valueOf(value), buffer, new FieldPosition(0));
        numberFormat.setMinimumIntegerDigits(minimumIntegerDigits);
        addTaint(buffer.getTaint());
        addTaint(count);
        addTaint(value);
        // ---------- Original Method ----------
        //int minimumIntegerDigits = numberFormat.getMinimumIntegerDigits();
        //numberFormat.setMinimumIntegerDigits(count);
        //numberFormat.format(Integer.valueOf(value), buffer, new FieldPosition(0));
        //numberFormat.setMinimumIntegerDigits(minimumIntegerDigits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.882 -0400", hash_original_method = "332B10C296E05CECE855CC96158B0A61", hash_generated_method = "FEA84E9A28B74F007996506A95F8D404")
    private Date error(ParsePosition position, int offset, TimeZone zone) {
        Date varB4EAC82CA7396A68D541C85D26508E83_750736563 = null; //Variable for return #1
        position.setErrorIndex(offset);
        calendar.setTimeZone(zone);
        varB4EAC82CA7396A68D541C85D26508E83_750736563 = null;
        addTaint(position.getTaint());
        addTaint(offset);
        addTaint(zone.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_750736563.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_750736563;
        // ---------- Original Method ----------
        //position.setErrorIndex(offset);
        //calendar.setTimeZone(zone);
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.882 -0400", hash_original_method = "F2F2556FE533C0A730BEC347E52E5292", hash_generated_method = "E48276381C032A46275AB4735E1D146F")
    @Override
    public StringBuffer format(Date date, StringBuffer buffer, FieldPosition fieldPos) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1401501720 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1401501720 = formatImpl(date, buffer, fieldPos, null);
        addTaint(date.getTaint());
        addTaint(buffer.getTaint());
        addTaint(fieldPos.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1401501720.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1401501720;
        // ---------- Original Method ----------
        //return formatImpl(date, buffer, fieldPos, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.883 -0400", hash_original_method = "71AF220EE7B6857040DD249E69ABFBDC", hash_generated_method = "4892AD7444A2A424B79535F129734B70")
    public Date get2DigitYearStart() {
        Date varB4EAC82CA7396A68D541C85D26508E83_1864028170 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1864028170 = (Date) defaultCenturyStart.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1864028170.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1864028170;
        // ---------- Original Method ----------
        //return (Date) defaultCenturyStart.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.883 -0400", hash_original_method = "CB6B47612D51E0A5BF8CB9FEBD927C3E", hash_generated_method = "2C7FC1630616A29DA62AF617E9AEAED4")
    public DateFormatSymbols getDateFormatSymbols() {
        DateFormatSymbols varB4EAC82CA7396A68D541C85D26508E83_2135202278 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2135202278 = (DateFormatSymbols) formatData.clone();
        varB4EAC82CA7396A68D541C85D26508E83_2135202278.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2135202278;
        // ---------- Original Method ----------
        //return (DateFormatSymbols) formatData.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.883 -0400", hash_original_method = "90B9D79300B8D8466B4A869D0B95FB5A", hash_generated_method = "E69CE76246C248D8047CE8FB4CCCF8D9")
    @Override
    public int hashCode() {
        int varD0693BDAAD552B644210DBD32C457666_1630191267 = (super.hashCode() + pattern.hashCode() + formatData.hashCode() + creationYear);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1289119427 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1289119427;
        // ---------- Original Method ----------
        //return super.hashCode() + pattern.hashCode() + formatData.hashCode() + creationYear;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.885 -0400", hash_original_method = "308621012329CC130ED3BC1A1EBA54C1", hash_generated_method = "8C31B7AC57802077F46CDBCF6003653B")
    private int parse(String string, int offset, char format, int count) {
        int index;
        index = PATTERN_CHARS.indexOf(format);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown pattern character '" + format + "'");
        } //End block
        int field;
        field = -1;
        int absolute;
        absolute = 0;
        {
            count = -count;
            absolute = count;
        } //End block
        //Begin case ERA_FIELD 
        int varC268242D1C819F8892340A0FF8840203_739721155 = (parseText(string, offset, formatData.eras, Calendar.ERA));
        //End case ERA_FIELD 
        //Begin case YEAR_FIELD 
        {
            field = Calendar.YEAR;
        } //End block
        {
            ParsePosition position;
            position = new ParsePosition(offset);
            Number result;
            result = parseNumber(absolute, string, position);
            {
                int varB71E1580F176BCDA73B76F60CC176FE9_963493186 = (-position.getErrorIndex() - 1);
            } //End block
            int year;
            year = result.intValue();
            {
                boolean varE554412EAE45E758F38B1FB02C0A6ACF_2131623952 = ((position.getIndex() - offset) == 2 && year >= 0);
                {
                    year += creationYear / 100 * 100;
                    {
                        year += 100;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            calendar.set(Calendar.YEAR, year);
            int varBD96F5D097851E0FFA3C2A7BAA345BEC_1997536936 = (position.getIndex());
        } //End block
        //End case YEAR_FIELD 
        //Begin case STAND_ALONE_MONTH_FIELD 
        int var560623FC6DD116755F5CC889A8CAC3E8_1699705480 = (parseMonth(string, offset, count, absolute,
                        formatData.longStandAloneMonths, formatData.shortStandAloneMonths));
        //End case STAND_ALONE_MONTH_FIELD 
        //Begin case MONTH_FIELD 
        int var0CC67C4707B8537DCF5B8E60F8CABD6E_1524294964 = (parseMonth(string, offset, count, absolute,
                        formatData.months, formatData.shortMonths));
        //End case MONTH_FIELD 
        //Begin case DATE_FIELD 
        field = Calendar.DATE;
        //End case DATE_FIELD 
        //Begin case HOUR_OF_DAY1_FIELD 
        ParsePosition position;
        position = new ParsePosition(offset);
        //End case HOUR_OF_DAY1_FIELD 
        //Begin case HOUR_OF_DAY1_FIELD 
        Number result;
        result = parseNumber(absolute, string, position);
        //End case HOUR_OF_DAY1_FIELD 
        //Begin case HOUR_OF_DAY1_FIELD 
        {
            int varCCCC7758C0FC0688A93ABAD70A920A12_1208849614 = (-position.getErrorIndex() - 1);
        } //End block
        //End case HOUR_OF_DAY1_FIELD 
        //Begin case HOUR_OF_DAY1_FIELD 
        int hour;
        hour = result.intValue();
        //End case HOUR_OF_DAY1_FIELD 
        //Begin case HOUR_OF_DAY1_FIELD 
        {
            hour = 0;
        } //End block
        //End case HOUR_OF_DAY1_FIELD 
        //Begin case HOUR_OF_DAY1_FIELD 
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        //End case HOUR_OF_DAY1_FIELD 
        //Begin case HOUR_OF_DAY1_FIELD 
        int var60B6ABEEF4EC6EBF8F72DEF15153C4C7_1270118774 = (position.getIndex());
        //End case HOUR_OF_DAY1_FIELD 
        //Begin case HOUR_OF_DAY0_FIELD 
        field = Calendar.HOUR_OF_DAY;
        //End case HOUR_OF_DAY0_FIELD 
        //Begin case MINUTE_FIELD 
        field = Calendar.MINUTE;
        //End case MINUTE_FIELD 
        //Begin case SECOND_FIELD 
        field = Calendar.SECOND;
        //End case SECOND_FIELD 
        //Begin case MILLISECOND_FIELD 
        field = Calendar.MILLISECOND;
        //End case MILLISECOND_FIELD 
        //Begin case STAND_ALONE_DAY_OF_WEEK_FIELD 
        int var843626D5452FE06FA1C680C9E6637A54_647320415 = (parseDayOfWeek(string, offset, formatData.longStandAloneWeekdays, formatData.shortStandAloneWeekdays));
        //End case STAND_ALONE_DAY_OF_WEEK_FIELD 
        //Begin case DAY_OF_WEEK_FIELD 
        int varC2688B84E650F102DF6FA9667D01DD90_882639854 = (parseDayOfWeek(string, offset, formatData.weekdays, formatData.shortWeekdays));
        //End case DAY_OF_WEEK_FIELD 
        //Begin case DAY_OF_YEAR_FIELD 
        field = Calendar.DAY_OF_YEAR;
        //End case DAY_OF_YEAR_FIELD 
        //Begin case DAY_OF_WEEK_IN_MONTH_FIELD 
        field = Calendar.DAY_OF_WEEK_IN_MONTH;
        //End case DAY_OF_WEEK_IN_MONTH_FIELD 
        //Begin case WEEK_OF_YEAR_FIELD 
        field = Calendar.WEEK_OF_YEAR;
        //End case WEEK_OF_YEAR_FIELD 
        //Begin case WEEK_OF_MONTH_FIELD 
        field = Calendar.WEEK_OF_MONTH;
        //End case WEEK_OF_MONTH_FIELD 
        //Begin case AM_PM_FIELD 
        int var7693357CD88C849DC20EA6B7065A5D27_882692601 = (parseText(string, offset, formatData.ampms, Calendar.AM_PM));
        //End case AM_PM_FIELD 
        //Begin case HOUR1_FIELD 
        position = new ParsePosition(offset);
        //End case HOUR1_FIELD 
        //Begin case HOUR1_FIELD 
        result = parseNumber(absolute, string, position);
        //End case HOUR1_FIELD 
        //Begin case HOUR1_FIELD 
        {
            int varCCCC7758C0FC0688A93ABAD70A920A12_1106357825 = (-position.getErrorIndex() - 1);
        } //End block
        //End case HOUR1_FIELD 
        //Begin case HOUR1_FIELD 
        hour = result.intValue();
        //End case HOUR1_FIELD 
        //Begin case HOUR1_FIELD 
        {
            hour = 0;
        } //End block
        //End case HOUR1_FIELD 
        //Begin case HOUR1_FIELD 
        calendar.set(Calendar.HOUR, hour);
        //End case HOUR1_FIELD 
        //Begin case HOUR1_FIELD 
        int var60B6ABEEF4EC6EBF8F72DEF15153C4C7_1720051185 = (position.getIndex());
        //End case HOUR1_FIELD 
        //Begin case HOUR0_FIELD 
        field = Calendar.HOUR;
        //End case HOUR0_FIELD 
        //Begin case TIMEZONE_FIELD 
        int var1CB9AA2FA0011008B741C9C1148D1A86_178881294 = (parseTimeZone(string, offset));
        //End case TIMEZONE_FIELD 
        //Begin case RFC_822_TIMEZONE_FIELD 
        int var1CB9AA2FA0011008B741C9C1148D1A86_1712941435 = (parseTimeZone(string, offset));
        //End case RFC_822_TIMEZONE_FIELD 
        {
            int var5734EB186253E708C992D70F93730E80_1437032604 = (parseNumber(absolute, string, offset, field, 0));
        } //End block
        addTaint(string.getTaint());
        addTaint(offset);
        addTaint(format);
        addTaint(count);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1235415086 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1235415086;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.889 -0400", hash_original_method = "4C5DAB8F3090E0FED455AF9657387367", hash_generated_method = "4680E6BFA621E711715BE37D042CFFE0")
    private int parseDayOfWeek(String string, int offset, String[] longs, String[] shorts) {
        int index;
        index = parseText(string, offset, longs, Calendar.DAY_OF_WEEK);
        {
            index = parseText(string, offset, shorts, Calendar.DAY_OF_WEEK);
        } //End block
        addTaint(string.getTaint());
        addTaint(offset);
        addTaint(longs[0].getTaint());
        addTaint(shorts[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2075037836 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2075037836;
        // ---------- Original Method ----------
        //int index = parseText(string, offset, longs, Calendar.DAY_OF_WEEK);
        //if (index < 0) {
            //index = parseText(string, offset, shorts, Calendar.DAY_OF_WEEK);
        //}
        //return index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.889 -0400", hash_original_method = "2749F9959CF57ED8E7DF53A146C2F50E", hash_generated_method = "FB604772456A2945AAC76558BB7127A9")
    private int parseMonth(String string, int offset, int count, int absolute, String[] longs, String[] shorts) {
        {
            int varB7B59BC18A2DC414B9088DE551586223_1472600254 = (parseNumber(absolute, string, offset, Calendar.MONTH, -1));
        } //End block
        int index;
        index = parseText(string, offset, longs, Calendar.MONTH);
        {
            index = parseText(string, offset, shorts, Calendar.MONTH);
        } //End block
        addTaint(string.getTaint());
        addTaint(offset);
        addTaint(count);
        addTaint(absolute);
        addTaint(longs[0].getTaint());
        addTaint(shorts[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_721381063 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_721381063;
        // ---------- Original Method ----------
        //if (count <= 2) {
            //return parseNumber(absolute, string, offset, Calendar.MONTH, -1);
        //}
        //int index = parseText(string, offset, longs, Calendar.MONTH);
        //if (index < 0) {
            //index = parseText(string, offset, shorts, Calendar.MONTH);
        //}
        //return index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.901 -0400", hash_original_method = "7359DD4332D8271AC0BCC2D6C59D8B62", hash_generated_method = "C5035E510D506F669F3955463C689AF9")
    @Override
    public Date parse(String string, ParsePosition position) {
        Date varB4EAC82CA7396A68D541C85D26508E83_61510839 = null; //Variable for return #1
        Date varB4EAC82CA7396A68D541C85D26508E83_464810238 = null; //Variable for return #2
        Date varB4EAC82CA7396A68D541C85D26508E83_1034430232 = null; //Variable for return #3
        Date varB4EAC82CA7396A68D541C85D26508E83_933739187 = null; //Variable for return #4
        Date varB4EAC82CA7396A68D541C85D26508E83_1438025809 = null; //Variable for return #5
        Date varB4EAC82CA7396A68D541C85D26508E83_1859514642 = null; //Variable for return #6
        Date varB4EAC82CA7396A68D541C85D26508E83_1963199451 = null; //Variable for return #7
        Date varB4EAC82CA7396A68D541C85D26508E83_1966598548 = null; //Variable for return #8
        boolean quote;
        quote = false;
        int next, last, count, offset;
        last = -1;
        count = 0;
        offset = position.getIndex();
        int length;
        length = string.length();
        calendar.clear();
        TimeZone zone;
        zone = calendar.getTimeZone();
        int patternLength;
        patternLength = pattern.length();
        {
            int i;
            i = 0;
            {
                next = pattern.charAt(i);
                {
                    {
                        {
                            boolean var0629699DB310DC7AEEE78863DA7252D9_167017297 = ((offset = parse(string, offset, (char) last, count)) < 0);
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_61510839 = error(position, -offset - 1, zone);
                            } //End block
                        } //End collapsed parenthetic
                        count = 0;
                    } //End block
                    {
                        {
                            boolean varD7653FDF2728DF334832DAA2BF510074_1241267710 = (offset >= length || string.charAt(offset) != '\'');
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_464810238 = error(position, offset, zone);
                            } //End block
                        } //End collapsed parenthetic
                        last = -1;
                    } //End block
                    {
                        last = next;
                    } //End block
                    quote = !quote;
                } //End block
                {
                    {
                        {
                            {
                                boolean var3398AC768D74E8B510352A3F537FBBE6_2056290421 = ((offset = parse(string, offset, (char) last, -count)) < 0);
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_1034430232 = error(position, -offset - 1, zone);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        last = next;
                        count = 1;
                    } //End block
                } //End block
                {
                    {
                        {
                            boolean var0629699DB310DC7AEEE78863DA7252D9_1523405685 = ((offset = parse(string, offset, (char) last, count)) < 0);
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_933739187 = error(position, -offset - 1, zone);
                            } //End block
                        } //End collapsed parenthetic
                        count = 0;
                    } //End block
                    last = -1;
                    {
                        boolean var4EAC505724FE9931A2AD25EF05396329_599789885 = (offset >= length || string.charAt(offset) != next);
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1438025809 = error(position, offset, zone);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean var75719BA10AA4ED51D06AC686EB3D40C0_564830399 = ((offset = parse(string, offset, (char) last, count)) < 0);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1859514642 = error(position, -offset - 1, zone);
                } //End block
            } //End collapsed parenthetic
        } //End block
        Date date;
        try 
        {
            date = calendar.getTime();
        } //End block
        catch (IllegalArgumentException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1963199451 = error(position, offset, zone);
        } //End block
        position.setIndex(offset);
        calendar.setTimeZone(zone);
        varB4EAC82CA7396A68D541C85D26508E83_1966598548 = date;
        addTaint(string.getTaint());
        addTaint(position.getTaint());
        Date varA7E53CE21691AB073D9660D615818899_545794536; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_545794536 = varB4EAC82CA7396A68D541C85D26508E83_61510839;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_545794536 = varB4EAC82CA7396A68D541C85D26508E83_464810238;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_545794536 = varB4EAC82CA7396A68D541C85D26508E83_1034430232;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_545794536 = varB4EAC82CA7396A68D541C85D26508E83_933739187;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_545794536 = varB4EAC82CA7396A68D541C85D26508E83_1438025809;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_545794536 = varB4EAC82CA7396A68D541C85D26508E83_1859514642;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_545794536 = varB4EAC82CA7396A68D541C85D26508E83_1963199451;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_545794536 = varB4EAC82CA7396A68D541C85D26508E83_1966598548;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_545794536.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_545794536;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.906 -0400", hash_original_method = "21C7D4A169609BA40C676EFC62A50E23", hash_generated_method = "5B2757BB7A96D08DA3E925F935A32FE3")
    private Number parseNumber(int max, String string, ParsePosition position) {
        Number varB4EAC82CA7396A68D541C85D26508E83_499148872 = null; //Variable for return #1
        Number varB4EAC82CA7396A68D541C85D26508E83_1869408825 = null; //Variable for return #2
        Number varB4EAC82CA7396A68D541C85D26508E83_1976772311 = null; //Variable for return #3
        int digit, length, result;
        length = string.length();
        result = 0;
        int index;
        index = position.getIndex();
        {
            length = index + max;
        } //End block
        {
            boolean var9F114C5717D455627CD373267F22CE15_463383862 = (index < length
                && (string.charAt(index) == ' ' || string.charAt(index) == '\t'));
        } //End collapsed parenthetic
        {
            position.setIndex(index);
            varB4EAC82CA7396A68D541C85D26508E83_499148872 = numberFormat.parse(string, position);
        } //End block
        {
            boolean var1A5D98E30C674C7D0F555BDD75E8DF23_333798502 = (index < length
                && (digit = Character.digit(string.charAt(index), 10)) != -1);
            {
                result = result * 10 + digit;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA55B49CD3927F24A52F0E267A68CB14D_992859913 = (index == position.getIndex());
            {
                position.setErrorIndex(index);
                varB4EAC82CA7396A68D541C85D26508E83_1869408825 = null;
            } //End block
        } //End collapsed parenthetic
        position.setIndex(index);
        varB4EAC82CA7396A68D541C85D26508E83_1976772311 = Integer.valueOf(result);
        addTaint(max);
        addTaint(string.getTaint());
        addTaint(position.getTaint());
        Number varA7E53CE21691AB073D9660D615818899_548321905; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_548321905 = varB4EAC82CA7396A68D541C85D26508E83_499148872;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_548321905 = varB4EAC82CA7396A68D541C85D26508E83_1869408825;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_548321905 = varB4EAC82CA7396A68D541C85D26508E83_1976772311;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_548321905.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_548321905;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.907 -0400", hash_original_method = "D6F7D67552A406D8EA22E8B872F7B057", hash_generated_method = "D6EE8DC070C480ECEF065BC444FE6797")
    private int parseNumber(int max, String string, int offset, int field, int skew) {
        ParsePosition position;
        position = new ParsePosition(offset);
        Number result;
        result = parseNumber(max, string, position);
        {
            int varCCCC7758C0FC0688A93ABAD70A920A12_1970254102 = (-position.getErrorIndex() - 1);
        } //End block
        calendar.set(field, result.intValue() + skew);
        int var60B6ABEEF4EC6EBF8F72DEF15153C4C7_409156607 = (position.getIndex());
        addTaint(max);
        addTaint(string.getTaint());
        addTaint(offset);
        addTaint(field);
        addTaint(skew);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1622789510 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1622789510;
        // ---------- Original Method ----------
        //ParsePosition position = new ParsePosition(offset);
        //Number result = parseNumber(max, string, position);
        //if (result == null) {
            //return -position.getErrorIndex() - 1;
        //}
        //calendar.set(field, result.intValue() + skew);
        //return position.getIndex();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.918 -0400", hash_original_method = "6091F52EF6DC933856441BD49E0F31F1", hash_generated_method = "16A7239499A0D8363C7D05332A6F8256")
    private int parseText(String string, int offset, String[] text, int field) {
        int found;
        found = -1;
        {
            int i;
            i = 0;
            {
                {
                    boolean var79024F9D58EADEC2F306CD35FC16D0FB_403774149 = (text[i].isEmpty());
                } //End collapsed parenthetic
                {
                    boolean varA9A9CAFB3FE6D3A772FD74C079113BD9_412180687 = (string.regionMatches(true, offset, text[i], 0, text[i].length()));
                    {
                        {
                            boolean var274E4B9E7BAC8AD4FE37DDC3337814FF_1108200329 = (found == -1 || text[i].length() > text[found].length());
                            {
                                found = i;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            calendar.set(field, found);
            int var1F7FC22D47EF763E631FF3E2E4BF095A_1733551114 = (offset + text[found].length());
        } //End block
        addTaint(string.getTaint());
        addTaint(offset);
        addTaint(text[0].getTaint());
        addTaint(field);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1705412927 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1705412927;
        // ---------- Original Method ----------
        //int found = -1;
        //for (int i = 0; i < text.length; i++) {
            //if (text[i].isEmpty()) {
                //continue;
            //}
            //if (string.regionMatches(true, offset, text[i], 0, text[i].length())) {
                //if (found == -1 || text[i].length() > text[found].length()) {
                    //found = i;
                //}
            //}
        //}
        //if (found != -1) {
            //calendar.set(field, found);
            //return offset + text[found].length();
        //}
        //return -offset - 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.067 -0400", hash_original_method = "C11BF6380CD6AEFF5BAB825547AF7C4A", hash_generated_method = "48C582C01D030FE95C479504B7125DC0")
    private int parseTimeZone(String string, int offset) {
        boolean foundGMT;
        foundGMT = string.regionMatches(offset, "GMT", 0, 3);
        {
            offset += 3;
        } //End block
        char sign;
        {
            boolean var13C70705D9DEC5B29C54DC383546D764_450520050 = (offset < string.length()
                && ((sign = string.charAt(offset)) == '+' || sign == '-'));
            {
                ParsePosition position;
                position = new ParsePosition(offset + 1);
                Number result;
                result = numberFormat.parse(string, position);
                {
                    int varFAA5CEBA0B1B76674D4015425DE176F1_935683598 = (-position.getErrorIndex() - 1);
                } //End block
                int hour;
                hour = result.intValue();
                int raw;
                raw = hour * 3600000;
                int index;
                index = position.getIndex();
                {
                    boolean varFCACDC168DF54F35FA13621F544783D7_14587217 = (index < string.length() && string.charAt(index) == ':');
                    {
                        position.setIndex(index + 1);
                        result = numberFormat.parse(string, position);
                        {
                            int var2E2FE557D6FCC0F70D7CCDCFC51374A0_1140821477 = (-position.getErrorIndex() - 1);
                        } //End block
                        int minute;
                        minute = result.intValue();
                        raw += minute * 60000;
                    } //End block
                    {
                        raw = (hour / 100 * 3600000) + (hour % 100 * 60000);
                    } //End block
                } //End collapsed parenthetic
                {
                    raw = -raw;
                } //End block
                calendar.setTimeZone(new SimpleTimeZone(raw, ""));
                int var0CE9A1F9826D7F38FEFE59ABA8F8438D_1280454662 = (position.getIndex());
            } //End block
        } //End collapsed parenthetic
        {
            calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        } //End block
        String[][] zones;
        zones = formatData.internalZoneStrings();
        {
            String[] element = zones[0];
            {
                {
                    int j;
                    j = TimeZones.LONG_NAME;
                    {
                        {
                            boolean var836A03A8EB1B272E8E28931AE8026577_1714506081 = (string.regionMatches(true, offset, element[j], 0, element[j].length()));
                            {
                                TimeZone zone;
                                zone = TimeZone.getTimeZone(element[TimeZones.OLSON_NAME]);
                                int raw;
                                raw = zone.getRawOffset();
                                {
                                    raw += 3600000;
                                } //End block
                                calendar.setTimeZone(new SimpleTimeZone(raw, ""));
                                int varC6E83921AFE1C7F57E82D3AC41AD3E7E_1355264212 = (offset + element[j].length());
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(string.getTaint());
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_990185429 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_990185429;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.068 -0400", hash_original_method = "893CAD0A3A74697E4DAD4463A5252E56", hash_generated_method = "6FEE0A79BD6E9C011B580795C38F4C1C")
    public void set2DigitYearStart(Date date) {
        defaultCenturyStart = (Date) date.clone();
        Calendar cal;
        cal = new GregorianCalendar();
        cal.setTime(defaultCenturyStart);
        creationYear = cal.get(Calendar.YEAR);
        // ---------- Original Method ----------
        //defaultCenturyStart = (Date) date.clone();
        //Calendar cal = new GregorianCalendar();
        //cal.setTime(defaultCenturyStart);
        //creationYear = cal.get(Calendar.YEAR);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.068 -0400", hash_original_method = "4ECB9E8EB801E57F7682FCC8E531C475", hash_generated_method = "7D960DE801802A6F7D2D49263FFB2EB7")
    public void setDateFormatSymbols(DateFormatSymbols value) {
        formatData = (DateFormatSymbols) value.clone();
        // ---------- Original Method ----------
        //formatData = (DateFormatSymbols) value.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.069 -0400", hash_original_method = "0CBAC1F89B5D111A3585F82BE6753903", hash_generated_method = "322072BA4165292750134AF4DEEA905E")
    public String toLocalizedPattern() {
        String varB4EAC82CA7396A68D541C85D26508E83_1368524316 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1368524316 = convertPattern(pattern, PATTERN_CHARS, formatData.getLocalPatternChars(), false);
        varB4EAC82CA7396A68D541C85D26508E83_1368524316.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1368524316;
        // ---------- Original Method ----------
        //return convertPattern(pattern, PATTERN_CHARS, formatData.getLocalPatternChars(), false);
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.080 -0400", hash_original_method = "35D638E960413F452190EF441C98A34C", hash_generated_method = "2280CAC92BD9AF18EE88948AE30B6813")
    public String toPattern() {
        String varB4EAC82CA7396A68D541C85D26508E83_623176533 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_623176533 = pattern;
        varB4EAC82CA7396A68D541C85D26508E83_623176533.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_623176533;
        // ---------- Original Method ----------
        //return pattern;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.080 -0400", hash_original_method = "C5F79137BB7206158B23593D7F9B176B", hash_generated_method = "B2EF755B84DA5135A5A5D640F3A53850")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        ObjectOutputStream.PutField fields;
        fields = stream.putFields();
        fields.put("defaultCenturyStart", defaultCenturyStart);
        fields.put("formatData", formatData);
        fields.put("pattern", pattern);
        fields.put("serialVersionOnStream", 1);
        stream.writeFields();
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        //ObjectOutputStream.PutField fields = stream.putFields();
        //fields.put("defaultCenturyStart", defaultCenturyStart);
        //fields.put("formatData", formatData);
        //fields.put("pattern", pattern);
        //fields.put("serialVersionOnStream", 1);
        //stream.writeFields();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.081 -0400", hash_original_method = "8B9631F89FAD33D3B003933051524309", hash_generated_method = "638D310F81BA92C83DC7028B33B207FF")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields;
        fields = stream.readFields();
        int version;
        version = fields.get("serialVersionOnStream", 0);
        Date date;
        {
            date = (Date) fields.get("defaultCenturyStart", new Date());
        } //End block
        {
            date = new Date();
        } //End block
        set2DigitYearStart(date);
        formatData = (DateFormatSymbols) fields.get("formatData", null);
        pattern = (String) fields.get("pattern", "");
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        //ObjectInputStream.GetField fields = stream.readFields();
        //int version = fields.get("serialVersionOnStream", 0);
        //Date date;
        //if (version > 0) {
            //date = (Date) fields.get("defaultCenturyStart", new Date());
        //} else {
            //date = new Date();
        //}
        //set2DigitYearStart(date);
        //formatData = (DateFormatSymbols) fields.get("formatData", null);
        //pattern = (String) fields.get("pattern", "");
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.081 -0400", hash_original_field = "712430BF0146209ACE3FF92C25509F9C", hash_generated_field = "0ADD081606102E085347BC1DE10E36DE")

    private static long serialVersionUID = 4774881970558875024L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.081 -0400", hash_original_field = "72D320CDF3E21B58BDA9BF6BAD2EE457", hash_generated_field = "C335AF32D023F51C67A2180C991A4556")

    static String PATTERN_CHARS = "GyMdkHmsSEDFwWahKzZLc";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.081 -0400", hash_original_field = "4C1B5CFA65D7E5B57608F90036B5EB41", hash_generated_field = "DE8A8DE67FB41F966DED87FE92C83681")

    private static int RFC_822_TIMEZONE_FIELD = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.081 -0400", hash_original_field = "B4558FC8452DBD732D3D4BD4F5C33B4C", hash_generated_field = "4C6705209CDD5A780783B91D4E1A9052")

    private static int STAND_ALONE_MONTH_FIELD = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.081 -0400", hash_original_field = "6D4CEC0D6141F8F84E1E5888DD16C5B6", hash_generated_field = "F9C30D7BF65AF9755DD3984948C9117D")

    private static int STAND_ALONE_DAY_OF_WEEK_FIELD = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.081 -0400", hash_original_field = "3C88CDD38A57AED6633CEAECC81C6EA2", hash_generated_field = "8938E7CD6F628258577F18F565594A7F")

    private static ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("defaultCenturyStart", Date.class),
        new ObjectStreamField("formatData", DateFormatSymbols.class),
        new ObjectStreamField("pattern", String.class),
        new ObjectStreamField("serialVersionOnStream", int.class),
    };
}

