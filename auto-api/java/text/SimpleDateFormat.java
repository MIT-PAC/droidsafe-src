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
    private String pattern;
    private DateFormatSymbols formatData;
    transient private int creationYear;
    private Date defaultCenturyStart;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.611 -0400", hash_original_method = "55288B23256ED63825B1D49B41027576", hash_generated_method = "F82B18A1A66AF548F5C62D87F2131939")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SimpleDateFormat() {
        this(Locale.getDefault());
        this.pattern = defaultPattern();
        this.formatData = new DateFormatSymbols(Locale.getDefault());
        // ---------- Original Method ----------
        //this.pattern = defaultPattern();
        //this.formatData = new DateFormatSymbols(Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.611 -0400", hash_original_method = "DF79561AB8D44B187C9CA04B354315AC", hash_generated_method = "917A747E50FA5DC8F0176746B74B5C00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SimpleDateFormat(String pattern) {
        this(pattern, Locale.getDefault());
        dsTaint.addTaint(pattern);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.612 -0400", hash_original_method = "2C117D04FF17ED0139CEC7451AA4BD73", hash_generated_method = "74E159FF3385E7CC170BD51B371D6159")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SimpleDateFormat(String template, DateFormatSymbols value) {
        this(Locale.getDefault());
        dsTaint.addTaint(template);
        dsTaint.addTaint(value.dsTaint);
        validatePattern(template);
        formatData = (DateFormatSymbols) value.clone();
        // ---------- Original Method ----------
        //validatePattern(template);
        //pattern = template;
        //formatData = (DateFormatSymbols) value.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.612 -0400", hash_original_method = "1BCD123DF2A5414BB2A2ECF5D3357D25", hash_generated_method = "56BDD257FA49E5B60749F35F1203D2D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SimpleDateFormat(String template, Locale locale) {
        this(locale);
        dsTaint.addTaint(template);
        dsTaint.addTaint(locale.dsTaint);
        validatePattern(template);
        formatData = new DateFormatSymbols(locale);
        // ---------- Original Method ----------
        //validatePattern(template);
        //pattern = template;
        //formatData = new DateFormatSymbols(locale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.612 -0400", hash_original_method = "F464E2338695834D875FCA6185F1E83B", hash_generated_method = "F701D061AF9360389667A9FBFB488F5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SimpleDateFormat(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        numberFormat = NumberFormat.getInstance(locale);
        numberFormat.setParseIntegerOnly(true);
        numberFormat.setGroupingUsed(false);
        calendar = new GregorianCalendar(locale);
        calendar.add(Calendar.YEAR, -80);
        creationYear = calendar.get(Calendar.YEAR);
        defaultCenturyStart = calendar.getTime();
        // ---------- Original Method ----------
        //numberFormat = NumberFormat.getInstance(locale);
        //numberFormat.setParseIntegerOnly(true);
        //numberFormat.setGroupingUsed(false);
        //calendar = new GregorianCalendar(locale);
        //calendar.add(Calendar.YEAR, -80);
        //creationYear = calendar.get(Calendar.YEAR);
        //defaultCenturyStart = calendar.getTime();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.612 -0400", hash_original_method = "411C0D5D8AD5CB18D4C2CE04A3CEEBF0", hash_generated_method = "8049CBA0E5C414A792A1F5942EF58800")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void validateFormat(char format) {
        dsTaint.addTaint(format);
        int index;
        index = PATTERN_CHARS.indexOf(format);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown pattern character '" + format + "'");
        } //End block
        // ---------- Original Method ----------
        //int index = PATTERN_CHARS.indexOf(format);
        //if (index == -1) {
            //throw new IllegalArgumentException("Unknown pattern character '" + format + "'");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.613 -0400", hash_original_method = "49C9E23BED9AC71209F0210F812D9D37", hash_generated_method = "0A6A990131CCD280B05416205624B3ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void validatePattern(String template) {
        dsTaint.addTaint(template);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.613 -0400", hash_original_method = "9688C7F66E6F76D1BE1FBD610A4BC951", hash_generated_method = "E012B849389DBE07AE9BD3C8D02C9F0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void applyLocalizedPattern(String template) {
        dsTaint.addTaint(template);
        pattern = convertPattern(template, formatData.getLocalPatternChars(), PATTERN_CHARS, true);
        // ---------- Original Method ----------
        //pattern = convertPattern(template, formatData.getLocalPatternChars(), PATTERN_CHARS, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.613 -0400", hash_original_method = "3EFD18F746D60C3172C5216CCD625C1E", hash_generated_method = "9F78EE79C88CAB5EA10617497698C975")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void applyPattern(String template) {
        dsTaint.addTaint(template);
        validatePattern(template);
        // ---------- Original Method ----------
        //validatePattern(template);
        //pattern = template;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.614 -0400", hash_original_method = "894F4ABDB71A6E4F1997CC330255AFC7", hash_generated_method = "2AE09B87C281C5E73524AA8AD392A83F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        SimpleDateFormat clone;
        clone = (SimpleDateFormat) super.clone();
        clone.formatData = (DateFormatSymbols) formatData.clone();
        clone.defaultCenturyStart = new Date(defaultCenturyStart.getTime());
        return (Object)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.614 -0400", hash_original_method = "386F5EAAB97078077630DB3A1FE9C0D6", hash_generated_method = "3928EB29BF71A9905CF9708230474A3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        SimpleDateFormat simple;
        simple = (SimpleDateFormat) object;
        boolean var8F00762234AC693C10F4824774BED328_1057660307 = (super.equals(object) && pattern.equals(simple.pattern)
                && formatData.equals(simple.formatData));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.614 -0400", hash_original_method = "F8A48BC85545A42AFE53260512DF9B2E", hash_generated_method = "473D484D680A56455B3525DD76652BF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        dsTaint.addTaint(object.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            AttributedCharacterIterator varB84991A73FF02FF0C0898339C4B7314F_996269476 = (formatToCharacterIteratorImpl((Date) object));
        } //End block
        {
            AttributedCharacterIterator var08AE0BDCFC68C71968076341B3A33350_1729428222 = (formatToCharacterIteratorImpl(new Date(((Number) object).longValue())));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        return (AttributedCharacterIterator)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.618 -0400", hash_original_method = "39C7DAF020DB077C56334C25B45C6758", hash_generated_method = "05DE64FAE8A8D8A89815E6410EC36DC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private AttributedCharacterIterator formatToCharacterIteratorImpl(Date date) {
        dsTaint.addTaint(date.dsTaint);
        StringBuffer buffer;
        buffer = new StringBuffer();
        ArrayList<FieldPosition> fields;
        fields = new ArrayList<FieldPosition>();
        formatImpl(date, buffer, null, fields);
        AttributedString as;
        as = new AttributedString(buffer.toString());
        {
            Iterator<FieldPosition> var88F8042C83F53E4D1CB9979F97D9B388_1576405102 = (fields).iterator();
            var88F8042C83F53E4D1CB9979F97D9B388_1576405102.hasNext();
            FieldPosition pos = var88F8042C83F53E4D1CB9979F97D9B388_1576405102.next();
            {
                Format.Field attribute;
                attribute = pos.getFieldAttribute();
                as.addAttribute(attribute, attribute, pos.getBeginIndex(), pos.getEndIndex());
            } //End block
        } //End collapsed parenthetic
        AttributedCharacterIterator varC17B74234B5E841D682B5933E83FF653_604316706 = (as.getIterator());
        return (AttributedCharacterIterator)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.618 -0400", hash_original_method = "1377B288F93939E9FA031027B23EE480", hash_generated_method = "E691C9934B3A42D6A758B0AE79E44661")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private StringBuffer formatImpl(Date date, StringBuffer buffer,
            FieldPosition field, List<FieldPosition> fields) {
        dsTaint.addTaint(field.dsTaint);
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(date.dsTaint);
        dsTaint.addTaint(fields.dsTaint);
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
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.619 -0400", hash_original_method = "60C88CC31EC17788C6D13B63E0E097AB", hash_generated_method = "9589F260A370C499C7BE0311C2751A33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void append(StringBuffer buffer, FieldPosition position,
            List<FieldPosition> fields, char format, int count) {
        dsTaint.addTaint(position.dsTaint);
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(count);
        dsTaint.addTaint(format);
        dsTaint.addTaint(fields.dsTaint);
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
                boolean varC55FDE01432B0DAD4F6A105898FCA625_1865717028 = ((position.getFieldAttribute() == dateFormatField || (position
                    .getFieldAttribute() == null && position.getField() == index))
                    && position.getEndIndex() == 0);
                {
                    position.setBeginIndex(beginPosition);
                    position.setEndIndex(buffer.length());
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.620 -0400", hash_original_method = "DD478E87C0FA9016B83D28121FBA02DB", hash_generated_method = "22AE27E4DC723090C27B98A1DC3736B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void appendDayOfWeek(StringBuffer buffer, int count, String[] longs, String[] shorts) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(longs[0]);
        dsTaint.addTaint(count);
        dsTaint.addTaint(shorts[0]);
        boolean isLong;
        isLong = (count > 3);
        String[] days;
        days = longs;
        days = shorts;
        buffer.append(days[calendar.get(Calendar.DAY_OF_WEEK)]);
        // ---------- Original Method ----------
        //boolean isLong = (count > 3);
        //String[] days = isLong ? longs : shorts;
        //buffer.append(days[calendar.get(Calendar.DAY_OF_WEEK)]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.620 -0400", hash_original_method = "7A41E7167A1A13C1027D42A61A5B401C", hash_generated_method = "3324FC603704446E1C429188B9E2A5F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void appendMonth(StringBuffer buffer, int count, String[] longs, String[] shorts) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(longs[0]);
        dsTaint.addTaint(count);
        dsTaint.addTaint(shorts[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.621 -0400", hash_original_method = "D7241707B86764AD36DA13023C5322B5", hash_generated_method = "DE92B6FF2EE8F5A5C74007A6E0AFCFDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void appendTimeZone(StringBuffer buffer, int count, boolean generalTimeZone) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(count);
        dsTaint.addTaint(generalTimeZone);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.621 -0400", hash_original_method = "E1D84DE5BC6EBCC18019540ED725D9AE", hash_generated_method = "93191FE6FB8AD05A1463A08BEF23EFB0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void appendNumericTimeZone(StringBuffer buffer, boolean generalTimeZone) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(generalTimeZone);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.622 -0400", hash_original_method = "9FC1BA4007CF5C77F0A2B74AE6FBC98F", hash_generated_method = "9BD5B0BA831E1DEE358D551D06B56D0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void appendNumber(StringBuffer buffer, int count, int value) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(count);
        dsTaint.addTaint(value);
        int minimumIntegerDigits;
        minimumIntegerDigits = numberFormat.getMinimumIntegerDigits();
        numberFormat.setMinimumIntegerDigits(count);
        numberFormat.format(Integer.valueOf(value), buffer, new FieldPosition(0));
        numberFormat.setMinimumIntegerDigits(minimumIntegerDigits);
        // ---------- Original Method ----------
        //int minimumIntegerDigits = numberFormat.getMinimumIntegerDigits();
        //numberFormat.setMinimumIntegerDigits(count);
        //numberFormat.format(Integer.valueOf(value), buffer, new FieldPosition(0));
        //numberFormat.setMinimumIntegerDigits(minimumIntegerDigits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.623 -0400", hash_original_method = "332B10C296E05CECE855CC96158B0A61", hash_generated_method = "7530752DE3F6B230656C50E376C0E4DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Date error(ParsePosition position, int offset, TimeZone zone) {
        dsTaint.addTaint(position.dsTaint);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(zone.dsTaint);
        position.setErrorIndex(offset);
        calendar.setTimeZone(zone);
        return (Date)dsTaint.getTaint();
        // ---------- Original Method ----------
        //position.setErrorIndex(offset);
        //calendar.setTimeZone(zone);
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.623 -0400", hash_original_method = "F2F2556FE533C0A730BEC347E52E5292", hash_generated_method = "2CB15FCA0DD856706324DC6CB6BD36AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public StringBuffer format(Date date, StringBuffer buffer, FieldPosition fieldPos) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(fieldPos.dsTaint);
        dsTaint.addTaint(date.dsTaint);
        StringBuffer var8079138B94119A109B7AE3B2D01C29F8_600588945 = (formatImpl(date, buffer, fieldPos, null));
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return formatImpl(date, buffer, fieldPos, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.623 -0400", hash_original_method = "71AF220EE7B6857040DD249E69ABFBDC", hash_generated_method = "A325CC60223B044B1D373FBCF3AAD3FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Date get2DigitYearStart() {
        Date var24E8BA095124EBC0C0537B0BB3E5F16B_583846692 = ((Date) defaultCenturyStart.clone());
        return (Date)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (Date) defaultCenturyStart.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.623 -0400", hash_original_method = "CB6B47612D51E0A5BF8CB9FEBD927C3E", hash_generated_method = "378E9F7B41BACDDFE2365185AAD00C47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DateFormatSymbols getDateFormatSymbols() {
        DateFormatSymbols var2E3494A93BC6FE3655C9204FA365799B_1852183635 = ((DateFormatSymbols) formatData.clone());
        return (DateFormatSymbols)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (DateFormatSymbols) formatData.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.623 -0400", hash_original_method = "90B9D79300B8D8466B4A869D0B95FB5A", hash_generated_method = "5413BBCA54BF339C87991FBB3E8BAFCE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varD0693BDAAD552B644210DBD32C457666_1252739571 = (super.hashCode() + pattern.hashCode() + formatData.hashCode() + creationYear);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return super.hashCode() + pattern.hashCode() + formatData.hashCode() + creationYear;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.624 -0400", hash_original_method = "308621012329CC130ED3BC1A1EBA54C1", hash_generated_method = "7793DD80945096D773A4A63B61426FAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int parse(String string, int offset, char format, int count) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(string);
        dsTaint.addTaint(format);
        dsTaint.addTaint(offset);
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
        int varC268242D1C819F8892340A0FF8840203_1074946870 = (parseText(string, offset, formatData.eras, Calendar.ERA));
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
                int varB71E1580F176BCDA73B76F60CC176FE9_1137480349 = (-position.getErrorIndex() - 1);
            } //End block
            int year;
            year = result.intValue();
            {
                boolean varE554412EAE45E758F38B1FB02C0A6ACF_304461718 = ((position.getIndex() - offset) == 2 && year >= 0);
                {
                    year += creationYear / 100 * 100;
                    {
                        year += 100;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            calendar.set(Calendar.YEAR, year);
            int varBD96F5D097851E0FFA3C2A7BAA345BEC_946206009 = (position.getIndex());
        } //End block
        //End case YEAR_FIELD 
        //Begin case STAND_ALONE_MONTH_FIELD 
        int var560623FC6DD116755F5CC889A8CAC3E8_1790565137 = (parseMonth(string, offset, count, absolute,
                        formatData.longStandAloneMonths, formatData.shortStandAloneMonths));
        //End case STAND_ALONE_MONTH_FIELD 
        //Begin case MONTH_FIELD 
        int var0CC67C4707B8537DCF5B8E60F8CABD6E_989073908 = (parseMonth(string, offset, count, absolute,
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
            int varCCCC7758C0FC0688A93ABAD70A920A12_689398816 = (-position.getErrorIndex() - 1);
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
        int var60B6ABEEF4EC6EBF8F72DEF15153C4C7_1858533551 = (position.getIndex());
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
        int var843626D5452FE06FA1C680C9E6637A54_1849339542 = (parseDayOfWeek(string, offset, formatData.longStandAloneWeekdays, formatData.shortStandAloneWeekdays));
        //End case STAND_ALONE_DAY_OF_WEEK_FIELD 
        //Begin case DAY_OF_WEEK_FIELD 
        int varC2688B84E650F102DF6FA9667D01DD90_1534887938 = (parseDayOfWeek(string, offset, formatData.weekdays, formatData.shortWeekdays));
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
        int var7693357CD88C849DC20EA6B7065A5D27_1598181954 = (parseText(string, offset, formatData.ampms, Calendar.AM_PM));
        //End case AM_PM_FIELD 
        //Begin case HOUR1_FIELD 
        position = new ParsePosition(offset);
        //End case HOUR1_FIELD 
        //Begin case HOUR1_FIELD 
        result = parseNumber(absolute, string, position);
        //End case HOUR1_FIELD 
        //Begin case HOUR1_FIELD 
        {
            int varCCCC7758C0FC0688A93ABAD70A920A12_203638417 = (-position.getErrorIndex() - 1);
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
        int var60B6ABEEF4EC6EBF8F72DEF15153C4C7_297458499 = (position.getIndex());
        //End case HOUR1_FIELD 
        //Begin case HOUR0_FIELD 
        field = Calendar.HOUR;
        //End case HOUR0_FIELD 
        //Begin case TIMEZONE_FIELD 
        int var1CB9AA2FA0011008B741C9C1148D1A86_1866048566 = (parseTimeZone(string, offset));
        //End case TIMEZONE_FIELD 
        //Begin case RFC_822_TIMEZONE_FIELD 
        int var1CB9AA2FA0011008B741C9C1148D1A86_1417354719 = (parseTimeZone(string, offset));
        //End case RFC_822_TIMEZONE_FIELD 
        {
            int var5734EB186253E708C992D70F93730E80_19169774 = (parseNumber(absolute, string, offset, field, 0));
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.625 -0400", hash_original_method = "4C5DAB8F3090E0FED455AF9657387367", hash_generated_method = "F42863D3DF6AB3BE31DCDFF878A47367")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int parseDayOfWeek(String string, int offset, String[] longs, String[] shorts) {
        dsTaint.addTaint(longs[0]);
        dsTaint.addTaint(string);
        dsTaint.addTaint(shorts[0]);
        dsTaint.addTaint(offset);
        int index;
        index = parseText(string, offset, longs, Calendar.DAY_OF_WEEK);
        {
            index = parseText(string, offset, shorts, Calendar.DAY_OF_WEEK);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int index = parseText(string, offset, longs, Calendar.DAY_OF_WEEK);
        //if (index < 0) {
            //index = parseText(string, offset, shorts, Calendar.DAY_OF_WEEK);
        //}
        //return index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.625 -0400", hash_original_method = "2749F9959CF57ED8E7DF53A146C2F50E", hash_generated_method = "E7F07BF207A6E92CC6EE8EE0FCEFC54B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int parseMonth(String string, int offset, int count, int absolute, String[] longs, String[] shorts) {
        dsTaint.addTaint(absolute);
        dsTaint.addTaint(longs[0]);
        dsTaint.addTaint(count);
        dsTaint.addTaint(string);
        dsTaint.addTaint(shorts[0]);
        dsTaint.addTaint(offset);
        {
            int varB7B59BC18A2DC414B9088DE551586223_1701002918 = (parseNumber(absolute, string, offset, Calendar.MONTH, -1));
        } //End block
        int index;
        index = parseText(string, offset, longs, Calendar.MONTH);
        {
            index = parseText(string, offset, shorts, Calendar.MONTH);
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.626 -0400", hash_original_method = "7359DD4332D8271AC0BCC2D6C59D8B62", hash_generated_method = "619C9FB5C372D77916ECF9D17D655732")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Date parse(String string, ParsePosition position) {
        dsTaint.addTaint(position.dsTaint);
        dsTaint.addTaint(string);
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
                            boolean var0629699DB310DC7AEEE78863DA7252D9_1562810112 = ((offset = parse(string, offset, (char) last, count)) < 0);
                            {
                                Date var670D51FCC7C1EAEA1769C74A22858D97_1237686997 = (error(position, -offset - 1, zone));
                            } //End block
                        } //End collapsed parenthetic
                        count = 0;
                    } //End block
                    {
                        {
                            boolean varD7653FDF2728DF334832DAA2BF510074_438750527 = (offset >= length || string.charAt(offset) != '\'');
                            {
                                Date varC4B083726F822147989628DF958643C2_1230907001 = (error(position, offset, zone));
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
                                boolean var3398AC768D74E8B510352A3F537FBBE6_1094003657 = ((offset = parse(string, offset, (char) last, -count)) < 0);
                                {
                                    Date varC3B16EA578A45A7D774A905CF86934EC_1783962852 = (error(position, -offset - 1, zone));
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
                            boolean var0629699DB310DC7AEEE78863DA7252D9_1289165792 = ((offset = parse(string, offset, (char) last, count)) < 0);
                            {
                                Date var670D51FCC7C1EAEA1769C74A22858D97_19950999 = (error(position, -offset - 1, zone));
                            } //End block
                        } //End collapsed parenthetic
                        count = 0;
                    } //End block
                    last = -1;
                    {
                        boolean var4EAC505724FE9931A2AD25EF05396329_1619632155 = (offset >= length || string.charAt(offset) != next);
                        {
                            Date var5E72E1C96A557235EF4D1B40B5972831_1338307418 = (error(position, offset, zone));
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean var75719BA10AA4ED51D06AC686EB3D40C0_422066276 = ((offset = parse(string, offset, (char) last, count)) < 0);
                {
                    Date varD11C4089D724B7D642801C28E6A51BC9_4811455 = (error(position, -offset - 1, zone));
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
            Date var6F6EA8F69ADBB6441A95DAD5E1D60F5C_1345688667 = (error(position, offset, zone));
        } //End block
        position.setIndex(offset);
        calendar.setTimeZone(zone);
        return (Date)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.628 -0400", hash_original_method = "21C7D4A169609BA40C676EFC62A50E23", hash_generated_method = "30BE10205334F60C45ED5853307478C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Number parseNumber(int max, String string, ParsePosition position) {
        dsTaint.addTaint(position.dsTaint);
        dsTaint.addTaint(max);
        dsTaint.addTaint(string);
        int digit, length, result;
        length = string.length();
        result = 0;
        int index;
        index = position.getIndex();
        {
            length = index + max;
        } //End block
        {
            boolean var9F114C5717D455627CD373267F22CE15_949267224 = (index < length
                && (string.charAt(index) == ' ' || string.charAt(index) == '\t'));
        } //End collapsed parenthetic
        {
            position.setIndex(index);
            Number varFFEC77274942B225EA208DE9DE02B973_917176528 = (numberFormat.parse(string, position));
        } //End block
        {
            boolean var1A5D98E30C674C7D0F555BDD75E8DF23_960307741 = (index < length
                && (digit = Character.digit(string.charAt(index), 10)) != -1);
            {
                result = result * 10 + digit;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA55B49CD3927F24A52F0E267A68CB14D_1223865738 = (index == position.getIndex());
            {
                position.setErrorIndex(index);
            } //End block
        } //End collapsed parenthetic
        position.setIndex(index);
        Number var934C41F4D26CBC15B3570DADC25A2B0A_852250769 = (Integer.valueOf(result));
        return (Number)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.629 -0400", hash_original_method = "D6F7D67552A406D8EA22E8B872F7B057", hash_generated_method = "E7D617860F77F73CB8D6B200C5EFB194")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int parseNumber(int max, String string, int offset, int field, int skew) {
        dsTaint.addTaint(field);
        dsTaint.addTaint(max);
        dsTaint.addTaint(string);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(skew);
        ParsePosition position;
        position = new ParsePosition(offset);
        Number result;
        result = parseNumber(max, string, position);
        {
            int varCCCC7758C0FC0688A93ABAD70A920A12_2026010538 = (-position.getErrorIndex() - 1);
        } //End block
        calendar.set(field, result.intValue() + skew);
        int var60B6ABEEF4EC6EBF8F72DEF15153C4C7_982480328 = (position.getIndex());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //ParsePosition position = new ParsePosition(offset);
        //Number result = parseNumber(max, string, position);
        //if (result == null) {
            //return -position.getErrorIndex() - 1;
        //}
        //calendar.set(field, result.intValue() + skew);
        //return position.getIndex();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.629 -0400", hash_original_method = "6091F52EF6DC933856441BD49E0F31F1", hash_generated_method = "95770EE7688953951CD79E3EF9488592")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int parseText(String string, int offset, String[] text, int field) {
        dsTaint.addTaint(field);
        dsTaint.addTaint(text[0]);
        dsTaint.addTaint(string);
        dsTaint.addTaint(offset);
        int found;
        found = -1;
        {
            int i;
            i = 0;
            {
                {
                    boolean var79024F9D58EADEC2F306CD35FC16D0FB_271784555 = (text[i].isEmpty());
                } //End collapsed parenthetic
                {
                    boolean varA9A9CAFB3FE6D3A772FD74C079113BD9_2132806040 = (string.regionMatches(true, offset, text[i], 0, text[i].length()));
                    {
                        {
                            boolean var274E4B9E7BAC8AD4FE37DDC3337814FF_615436867 = (found == -1 || text[i].length() > text[found].length());
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
            int var1F7FC22D47EF763E631FF3E2E4BF095A_1375114080 = (offset + text[found].length());
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.641 -0400", hash_original_method = "C11BF6380CD6AEFF5BAB825547AF7C4A", hash_generated_method = "C11B878E57C949C7E6E5CF16C531FA35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int parseTimeZone(String string, int offset) {
        dsTaint.addTaint(string);
        dsTaint.addTaint(offset);
        boolean foundGMT;
        foundGMT = string.regionMatches(offset, "GMT", 0, 3);
        {
            offset += 3;
        } //End block
        char sign;
        {
            boolean var13C70705D9DEC5B29C54DC383546D764_267301215 = (offset < string.length()
                && ((sign = string.charAt(offset)) == '+' || sign == '-'));
            {
                ParsePosition position;
                position = new ParsePosition(offset + 1);
                Number result;
                result = numberFormat.parse(string, position);
                {
                    int varFAA5CEBA0B1B76674D4015425DE176F1_1681668865 = (-position.getErrorIndex() - 1);
                } //End block
                int hour;
                hour = result.intValue();
                int raw;
                raw = hour * 3600000;
                int index;
                index = position.getIndex();
                {
                    boolean varFCACDC168DF54F35FA13621F544783D7_349257528 = (index < string.length() && string.charAt(index) == ':');
                    {
                        position.setIndex(index + 1);
                        result = numberFormat.parse(string, position);
                        {
                            int var2E2FE557D6FCC0F70D7CCDCFC51374A0_1424267545 = (-position.getErrorIndex() - 1);
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
                int var0CE9A1F9826D7F38FEFE59ABA8F8438D_867997167 = (position.getIndex());
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
                            boolean var836A03A8EB1B272E8E28931AE8026577_1915478278 = (string.regionMatches(true, offset, element[j], 0, element[j].length()));
                            {
                                TimeZone zone;
                                zone = TimeZone.getTimeZone(element[TimeZones.OLSON_NAME]);
                                int raw;
                                raw = zone.getRawOffset();
                                {
                                    raw += 3600000;
                                } //End block
                                calendar.setTimeZone(new SimpleTimeZone(raw, ""));
                                int varC6E83921AFE1C7F57E82D3AC41AD3E7E_1863744296 = (offset + element[j].length());
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.641 -0400", hash_original_method = "893CAD0A3A74697E4DAD4463A5252E56", hash_generated_method = "0DDFE13D00C0D94850E4536C7F725A33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void set2DigitYearStart(Date date) {
        dsTaint.addTaint(date.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.642 -0400", hash_original_method = "4ECB9E8EB801E57F7682FCC8E531C475", hash_generated_method = "F0D42A63A1D7B88B4CABBDEE37399CCB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDateFormatSymbols(DateFormatSymbols value) {
        dsTaint.addTaint(value.dsTaint);
        formatData = (DateFormatSymbols) value.clone();
        // ---------- Original Method ----------
        //formatData = (DateFormatSymbols) value.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.642 -0400", hash_original_method = "0CBAC1F89B5D111A3585F82BE6753903", hash_generated_method = "04AF54EBD8CF856D285D260FEC2EE530")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toLocalizedPattern() {
        String var9D7D20FAE1E8370FD4B87CBD41E25C22_996982081 = (convertPattern(pattern, PATTERN_CHARS, formatData.getLocalPatternChars(), false));
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.642 -0400", hash_original_method = "35D638E960413F452190EF441C98A34C", hash_generated_method = "31272F6B046F373A4D0AA6D6D7023D43")
    @DSModeled(DSC.SAFE)
    public String toPattern() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return pattern;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.643 -0400", hash_original_method = "C5F79137BB7206158B23593D7F9B176B", hash_generated_method = "BC514C8ADC8A80615D23F8FACE4468E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream stream) throws IOException {
        dsTaint.addTaint(stream.dsTaint);
        ObjectOutputStream.PutField fields;
        fields = stream.putFields();
        fields.put("defaultCenturyStart", defaultCenturyStart);
        fields.put("formatData", formatData);
        fields.put("pattern", pattern);
        fields.put("serialVersionOnStream", 1);
        stream.writeFields();
        // ---------- Original Method ----------
        //ObjectOutputStream.PutField fields = stream.putFields();
        //fields.put("defaultCenturyStart", defaultCenturyStart);
        //fields.put("formatData", formatData);
        //fields.put("pattern", pattern);
        //fields.put("serialVersionOnStream", 1);
        //stream.writeFields();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.643 -0400", hash_original_method = "8B9631F89FAD33D3B003933051524309", hash_generated_method = "9A38D42A9B32C60511C2B1437199B0CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(stream.dsTaint);
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

    
    private static final long serialVersionUID = 4774881970558875024L;
    static final String PATTERN_CHARS = "GyMdkHmsSEDFwWahKzZLc";
    private static final int RFC_822_TIMEZONE_FIELD = 18;
    private static final int STAND_ALONE_MONTH_FIELD = 19;
    private static final int STAND_ALONE_DAY_OF_WEEK_FIELD = 20;
    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("defaultCenturyStart", Date.class),
        new ObjectStreamField("formatData", DateFormatSymbols.class),
        new ObjectStreamField("pattern", String.class),
        new ObjectStreamField("serialVersionOnStream", int.class),
    };
}

