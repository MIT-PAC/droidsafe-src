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
    private static long serialVersionUID = 4774881970558875024L;
    static String PATTERN_CHARS = "GyMdkHmsSEDFwWahKzZLc";
    private static int RFC_822_TIMEZONE_FIELD = 18;
    private static int STAND_ALONE_MONTH_FIELD = 19;
    private static int STAND_ALONE_DAY_OF_WEEK_FIELD = 20;
    private String pattern;
    private DateFormatSymbols formatData;
    transient private int creationYear;
    private Date defaultCenturyStart;
    private static ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("defaultCenturyStart", Date.class),
        new ObjectStreamField("formatData", DateFormatSymbols.class),
        new ObjectStreamField("pattern", String.class),
        new ObjectStreamField("serialVersionOnStream", int.class),
    };
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.679 -0400", hash_original_method = "55288B23256ED63825B1D49B41027576", hash_generated_method = "B223AE39DA2424F7FF199106FBA8B855")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SimpleDateFormat() {
        this(Locale.getDefault());
        this.pattern = defaultPattern();
        this.formatData = new DateFormatSymbols(Locale.getDefault());
        // ---------- Original Method ----------
        //this.pattern = defaultPattern();
        //this.formatData = new DateFormatSymbols(Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.680 -0400", hash_original_method = "DF79561AB8D44B187C9CA04B354315AC", hash_generated_method = "9206670476DE0E0C83DEBAD09683F400")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SimpleDateFormat(String pattern) {
        this(pattern, Locale.getDefault());
        dsTaint.addTaint(pattern);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.682 -0400", hash_original_method = "2C117D04FF17ED0139CEC7451AA4BD73", hash_generated_method = "C32FFEC2ADF208F9CC42098477A1BDEF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.684 -0400", hash_original_method = "1BCD123DF2A5414BB2A2ECF5D3357D25", hash_generated_method = "1905E87DC5BE1F53BA6E4ACCF293489A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.688 -0400", hash_original_method = "F464E2338695834D875FCA6185F1E83B", hash_generated_method = "A5D6D503663BE9EA0B2DCEC0DDA99070")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.693 -0400", hash_original_method = "411C0D5D8AD5CB18D4C2CE04A3CEEBF0", hash_generated_method = "FD8805C66127DC589411A21C17F4DC65")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.701 -0400", hash_original_method = "49C9E23BED9AC71209F0210F812D9D37", hash_generated_method = "55C39022EC9B1E531377DFFABFA1ECEF")
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
                        count++;
                    } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.713 -0400", hash_original_method = "9688C7F66E6F76D1BE1FBD610A4BC951", hash_generated_method = "415ACA5ADBFF06BA0C73619F9E94FE35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void applyLocalizedPattern(String template) {
        dsTaint.addTaint(template);
        pattern = convertPattern(template, formatData.getLocalPatternChars(), PATTERN_CHARS, true);
        // ---------- Original Method ----------
        //pattern = convertPattern(template, formatData.getLocalPatternChars(), PATTERN_CHARS, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.716 -0400", hash_original_method = "3EFD18F746D60C3172C5216CCD625C1E", hash_generated_method = "13E029A84489E8221069CEBB807E5872")
    @DSModeled(DSC.SAFE)
    public void applyPattern(String template) {
        dsTaint.addTaint(template);
        validatePattern(template);
        // ---------- Original Method ----------
        //validatePattern(template);
        //pattern = template;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.717 -0400", hash_original_method = "894F4ABDB71A6E4F1997CC330255AFC7", hash_generated_method = "D55C2B29E6488F3F30D08E59FC6EC5B7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.719 -0400", hash_original_method = "F209DE6039C95F3ED32C483A7FAB87E8", hash_generated_method = "242A0445AD9B8EA038A867E60E2CF70F")
    private static String defaultPattern() {
        LocaleData localeData = LocaleData.get(Locale.getDefault());
        return localeData.getDateFormat(SHORT) + " " + localeData.getTimeFormat(SHORT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.726 -0400", hash_original_method = "386F5EAAB97078077630DB3A1FE9C0D6", hash_generated_method = "52270D3C7F019233073B6FF1E60CA2E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        SimpleDateFormat simple;
        simple = (SimpleDateFormat) object;
        boolean var8F00762234AC693C10F4824774BED328_1543235685 = (super.equals(object) && pattern.equals(simple.pattern)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.732 -0400", hash_original_method = "F8A48BC85545A42AFE53260512DF9B2E", hash_generated_method = "823485E9417940B9DF7D7A4B82D06888")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        dsTaint.addTaint(object.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            AttributedCharacterIterator varB84991A73FF02FF0C0898339C4B7314F_1181710500 = (formatToCharacterIteratorImpl((Date) object));
        } //End block
        {
            AttributedCharacterIterator var08AE0BDCFC68C71968076341B3A33350_858066898 = (formatToCharacterIteratorImpl(new Date(((Number) object).longValue())));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.734 -0400", hash_original_method = "39C7DAF020DB077C56334C25B45C6758", hash_generated_method = "A17EC5AA977FA30A08504407A86CBBC2")
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
            Iterator<FieldPosition> seatecAstronomy42 = fields.iterator();
            seatecAstronomy42.hasNext();
            FieldPosition pos = seatecAstronomy42.next();
            {
                Format.Field attribute;
                attribute = pos.getFieldAttribute();
                as.addAttribute(attribute, attribute, pos.getBeginIndex(), pos.getEndIndex());
            } //End block
        } //End collapsed parenthetic
        AttributedCharacterIterator varC17B74234B5E841D682B5933E83FF653_1683567941 = (as.getIterator());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.744 -0400", hash_original_method = "1377B288F93939E9FA031027B23EE480", hash_generated_method = "952348112992EA1BF1421E85CC636B8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private StringBuffer formatImpl(Date date, StringBuffer buffer,
            FieldPosition field, List<FieldPosition> fields) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(field.dsTaint);
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
                        count++;
                    } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.759 -0400", hash_original_method = "60C88CC31EC17788C6D13B63E0E097AB", hash_generated_method = "C6329227EE63AB33FD686DC56586D478")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void append(StringBuffer buffer, FieldPosition position,
            List<FieldPosition> fields, char format, int count) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(position.dsTaint);
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
                boolean varC55FDE01432B0DAD4F6A105898FCA625_132246413 = ((position.getFieldAttribute() == dateFormatField || (position
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.794 -0400", hash_original_method = "DD478E87C0FA9016B83D28121FBA02DB", hash_generated_method = "EBC2218AD7BD819C6B74BC3B374B90AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void appendDayOfWeek(StringBuffer buffer, int count, String[] longs, String[] shorts) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(count);
        dsTaint.addTaint(longs[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.800 -0400", hash_original_method = "7A41E7167A1A13C1027D42A61A5B401C", hash_generated_method = "E0D0B38FE8BC24422FB7BB1B5E4F766B")
    @DSModeled(DSC.SAFE)
    private void appendMonth(StringBuffer buffer, int count, String[] longs, String[] shorts) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(count);
        dsTaint.addTaint(longs[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.807 -0400", hash_original_method = "D7241707B86764AD36DA13023C5322B5", hash_generated_method = "45A01A67CF15729E37748AE07350E87E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.811 -0400", hash_original_method = "E1D84DE5BC6EBCC18019540ED725D9AE", hash_generated_method = "B348B91FCA6CE6D3E14897ED7AB85F2B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.812 -0400", hash_original_method = "9FC1BA4007CF5C77F0A2B74AE6FBC98F", hash_generated_method = "657B404488DABD3F4B5DD83273E3D945")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.814 -0400", hash_original_method = "332B10C296E05CECE855CC96158B0A61", hash_generated_method = "D473B18C92ADFEEE5899B446223782EB")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.815 -0400", hash_original_method = "F2F2556FE533C0A730BEC347E52E5292", hash_generated_method = "0F5FF4F70799ED1B6D7F897BC23063AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public StringBuffer format(Date date, StringBuffer buffer, FieldPosition fieldPos) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(fieldPos.dsTaint);
        dsTaint.addTaint(date.dsTaint);
        StringBuffer var8079138B94119A109B7AE3B2D01C29F8_1063940162 = (formatImpl(date, buffer, fieldPos, null));
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return formatImpl(date, buffer, fieldPos, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.817 -0400", hash_original_method = "71AF220EE7B6857040DD249E69ABFBDC", hash_generated_method = "E471E464E2F773E1C4A19BC472CA9A25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Date get2DigitYearStart() {
        Date var24E8BA095124EBC0C0537B0BB3E5F16B_9890263 = ((Date) defaultCenturyStart.clone());
        return (Date)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (Date) defaultCenturyStart.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.819 -0400", hash_original_method = "CB6B47612D51E0A5BF8CB9FEBD927C3E", hash_generated_method = "DC4E3F6048820CFF5557F8AB75C61E6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DateFormatSymbols getDateFormatSymbols() {
        DateFormatSymbols var2E3494A93BC6FE3655C9204FA365799B_880676043 = ((DateFormatSymbols) formatData.clone());
        return (DateFormatSymbols)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (DateFormatSymbols) formatData.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.824 -0400", hash_original_method = "90B9D79300B8D8466B4A869D0B95FB5A", hash_generated_method = "E6162F0FD52E912E89E3E9323126508A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varD0693BDAAD552B644210DBD32C457666_446245605 = (super.hashCode() + pattern.hashCode() + formatData.hashCode() + creationYear);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return super.hashCode() + pattern.hashCode() + formatData.hashCode() + creationYear;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.838 -0400", hash_original_method = "308621012329CC130ED3BC1A1EBA54C1", hash_generated_method = "3C47BFC2677A25414ECD378819A8F9BD")
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
        int varC268242D1C819F8892340A0FF8840203_1084139518 = (parseText(string, offset, formatData.eras, Calendar.ERA));
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
                int varB71E1580F176BCDA73B76F60CC176FE9_1057275100 = (-position.getErrorIndex() - 1);
            } //End block
            int year;
            year = result.intValue();
            {
                boolean varE554412EAE45E758F38B1FB02C0A6ACF_1620514673 = ((position.getIndex() - offset) == 2 && year >= 0);
                {
                    year += creationYear / 100 * 100;
                    {
                        year += 100;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            calendar.set(Calendar.YEAR, year);
            int varBD96F5D097851E0FFA3C2A7BAA345BEC_158014630 = (position.getIndex());
        } //End block
        //End case YEAR_FIELD 
        //Begin case STAND_ALONE_MONTH_FIELD 
        int var560623FC6DD116755F5CC889A8CAC3E8_1280106621 = (parseMonth(string, offset, count, absolute,
                        formatData.longStandAloneMonths, formatData.shortStandAloneMonths));
        //End case STAND_ALONE_MONTH_FIELD 
        //Begin case MONTH_FIELD 
        int var0CC67C4707B8537DCF5B8E60F8CABD6E_1316340303 = (parseMonth(string, offset, count, absolute,
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
            int varCCCC7758C0FC0688A93ABAD70A920A12_2039060192 = (-position.getErrorIndex() - 1);
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
        int var60B6ABEEF4EC6EBF8F72DEF15153C4C7_1449674368 = (position.getIndex());
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
        int var843626D5452FE06FA1C680C9E6637A54_1378083732 = (parseDayOfWeek(string, offset, formatData.longStandAloneWeekdays, formatData.shortStandAloneWeekdays));
        //End case STAND_ALONE_DAY_OF_WEEK_FIELD 
        //Begin case DAY_OF_WEEK_FIELD 
        int varC2688B84E650F102DF6FA9667D01DD90_155538445 = (parseDayOfWeek(string, offset, formatData.weekdays, formatData.shortWeekdays));
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
        int var7693357CD88C849DC20EA6B7065A5D27_426436627 = (parseText(string, offset, formatData.ampms, Calendar.AM_PM));
        //End case AM_PM_FIELD 
        //Begin case HOUR1_FIELD 
        position = new ParsePosition(offset);
        //End case HOUR1_FIELD 
        //Begin case HOUR1_FIELD 
        result = parseNumber(absolute, string, position);
        //End case HOUR1_FIELD 
        //Begin case HOUR1_FIELD 
        {
            int varCCCC7758C0FC0688A93ABAD70A920A12_1526643887 = (-position.getErrorIndex() - 1);
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
        int var60B6ABEEF4EC6EBF8F72DEF15153C4C7_726958703 = (position.getIndex());
        //End case HOUR1_FIELD 
        //Begin case HOUR0_FIELD 
        field = Calendar.HOUR;
        //End case HOUR0_FIELD 
        //Begin case TIMEZONE_FIELD 
        int var1CB9AA2FA0011008B741C9C1148D1A86_1689177364 = (parseTimeZone(string, offset));
        //End case TIMEZONE_FIELD 
        //Begin case RFC_822_TIMEZONE_FIELD 
        int var1CB9AA2FA0011008B741C9C1148D1A86_1989858338 = (parseTimeZone(string, offset));
        //End case RFC_822_TIMEZONE_FIELD 
        {
            int var5734EB186253E708C992D70F93730E80_1240464877 = (parseNumber(absolute, string, offset, field, 0));
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.841 -0400", hash_original_method = "4C5DAB8F3090E0FED455AF9657387367", hash_generated_method = "683FA9A1685558D17E379BFC7DD2E46A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.843 -0400", hash_original_method = "2749F9959CF57ED8E7DF53A146C2F50E", hash_generated_method = "BA921037D190978B5CC2BC763385A796")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int parseMonth(String string, int offset, int count, int absolute, String[] longs, String[] shorts) {
        dsTaint.addTaint(absolute);
        dsTaint.addTaint(count);
        dsTaint.addTaint(longs[0]);
        dsTaint.addTaint(string);
        dsTaint.addTaint(shorts[0]);
        dsTaint.addTaint(offset);
        {
            int varB7B59BC18A2DC414B9088DE551586223_804326866 = (parseNumber(absolute, string, offset, Calendar.MONTH, -1));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.853 -0400", hash_original_method = "7359DD4332D8271AC0BCC2D6C59D8B62", hash_generated_method = "7FA7E1B7B472427CFD429DCC3CF071B0")
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
                            boolean var0629699DB310DC7AEEE78863DA7252D9_2101376367 = ((offset = parse(string, offset, (char) last, count)) < 0);
                            {
                                Date var670D51FCC7C1EAEA1769C74A22858D97_1269814058 = (error(position, -offset - 1, zone));
                            } //End block
                        } //End collapsed parenthetic
                        count = 0;
                    } //End block
                    {
                        {
                            boolean varD7653FDF2728DF334832DAA2BF510074_1674357726 = (offset >= length || string.charAt(offset) != '\'');
                            {
                                Date varC4B083726F822147989628DF958643C2_492561850 = (error(position, offset, zone));
                            } //End block
                        } //End collapsed parenthetic
                        offset++;
                        last = -1;
                    } //End block
                    {
                        last = next;
                    } //End block
                    quote = !quote;
                } //End block
                {
                    {
                        count++;
                    } //End block
                    {
                        {
                            {
                                boolean var3398AC768D74E8B510352A3F537FBBE6_1905757291 = ((offset = parse(string, offset, (char) last, -count)) < 0);
                                {
                                    Date varC3B16EA578A45A7D774A905CF86934EC_528096895 = (error(position, -offset - 1, zone));
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
                            boolean var0629699DB310DC7AEEE78863DA7252D9_1745656330 = ((offset = parse(string, offset, (char) last, count)) < 0);
                            {
                                Date var670D51FCC7C1EAEA1769C74A22858D97_755374290 = (error(position, -offset - 1, zone));
                            } //End block
                        } //End collapsed parenthetic
                        count = 0;
                    } //End block
                    last = -1;
                    {
                        boolean var4EAC505724FE9931A2AD25EF05396329_923439636 = (offset >= length || string.charAt(offset) != next);
                        {
                            Date var5E72E1C96A557235EF4D1B40B5972831_1938049796 = (error(position, offset, zone));
                        } //End block
                    } //End collapsed parenthetic
                    offset++;
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean var75719BA10AA4ED51D06AC686EB3D40C0_1530587854 = ((offset = parse(string, offset, (char) last, count)) < 0);
                {
                    Date varD11C4089D724B7D642801C28E6A51BC9_2006811757 = (error(position, -offset - 1, zone));
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
            Date var6F6EA8F69ADBB6441A95DAD5E1D60F5C_130151848 = (error(position, offset, zone));
        } //End block
        position.setIndex(offset);
        calendar.setTimeZone(zone);
        return (Date)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.857 -0400", hash_original_method = "21C7D4A169609BA40C676EFC62A50E23", hash_generated_method = "7A7AEA41D54C3D98946B452CA96350E6")
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
            boolean var9F114C5717D455627CD373267F22CE15_618201658 = (index < length
                && (string.charAt(index) == ' ' || string.charAt(index) == '\t'));
            {
                index++;
            } //End block
        } //End collapsed parenthetic
        {
            position.setIndex(index);
            Number varFFEC77274942B225EA208DE9DE02B973_321354019 = (numberFormat.parse(string, position));
        } //End block
        {
            digit = Character.digit(string.charAt(index), 10);
            {
                index++;
                result = result * 10 + digit;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA55B49CD3927F24A52F0E267A68CB14D_823422933 = (index == position.getIndex());
            {
                position.setErrorIndex(index);
            } //End block
        } //End collapsed parenthetic
        position.setIndex(index);
        Number var934C41F4D26CBC15B3570DADC25A2B0A_1625172857 = (Integer.valueOf(result));
        return (Number)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.860 -0400", hash_original_method = "D6F7D67552A406D8EA22E8B872F7B057", hash_generated_method = "5B366A77DBA32263367356E2EDB3993D")
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
            int varCCCC7758C0FC0688A93ABAD70A920A12_25053855 = (-position.getErrorIndex() - 1);
        } //End block
        calendar.set(field, result.intValue() + skew);
        int var60B6ABEEF4EC6EBF8F72DEF15153C4C7_2034926800 = (position.getIndex());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.862 -0400", hash_original_method = "6091F52EF6DC933856441BD49E0F31F1", hash_generated_method = "54A0B1E2F8C35AF016DEBD921AB3D2D6")
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
                    boolean var79024F9D58EADEC2F306CD35FC16D0FB_1716076520 = (text[i].isEmpty());
                } //End collapsed parenthetic
                {
                    boolean varA9A9CAFB3FE6D3A772FD74C079113BD9_639716243 = (string.regionMatches(true, offset, text[i], 0, text[i].length()));
                    {
                        {
                            boolean var274E4B9E7BAC8AD4FE37DDC3337814FF_344421306 = (found == -1 || text[i].length() > text[found].length());
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
            int var1F7FC22D47EF763E631FF3E2E4BF095A_1782615972 = (offset + text[found].length());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.874 -0400", hash_original_method = "C11BF6380CD6AEFF5BAB825547AF7C4A", hash_generated_method = "D71868947042715C38A8CAA099EAF2DC")
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
            boolean var13C70705D9DEC5B29C54DC383546D764_151542622 = (offset < string.length()
                && ((sign = string.charAt(offset)) == '+' || sign == '-'));
            {
                ParsePosition position;
                position = new ParsePosition(offset + 1);
                Number result;
                result = numberFormat.parse(string, position);
                {
                    int varFAA5CEBA0B1B76674D4015425DE176F1_1977902807 = (-position.getErrorIndex() - 1);
                } //End block
                int hour;
                hour = result.intValue();
                int raw;
                raw = hour * 3600000;
                int index;
                index = position.getIndex();
                {
                    boolean varFCACDC168DF54F35FA13621F544783D7_805113079 = (index < string.length() && string.charAt(index) == ':');
                    {
                        position.setIndex(index + 1);
                        result = numberFormat.parse(string, position);
                        {
                            int var2E2FE557D6FCC0F70D7CCDCFC51374A0_776246333 = (-position.getErrorIndex() - 1);
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
                int var0CE9A1F9826D7F38FEFE59ABA8F8438D_316336238 = (position.getIndex());
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
                            boolean var836A03A8EB1B272E8E28931AE8026577_1453532799 = (string.regionMatches(true, offset, element[j], 0, element[j].length()));
                            {
                                TimeZone zone;
                                zone = TimeZone.getTimeZone(element[TimeZones.OLSON_NAME]);
                                int raw;
                                raw = zone.getRawOffset();
                                {
                                    raw += 3600000;
                                } //End block
                                calendar.setTimeZone(new SimpleTimeZone(raw, ""));
                                int varC6E83921AFE1C7F57E82D3AC41AD3E7E_36056336 = (offset + element[j].length());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.876 -0400", hash_original_method = "893CAD0A3A74697E4DAD4463A5252E56", hash_generated_method = "A52F6200B4A3DE872FDC9DA90B7234C7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.877 -0400", hash_original_method = "4ECB9E8EB801E57F7682FCC8E531C475", hash_generated_method = "B000E5695169D63CC13539E0B58E9C08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDateFormatSymbols(DateFormatSymbols value) {
        dsTaint.addTaint(value.dsTaint);
        formatData = (DateFormatSymbols) value.clone();
        // ---------- Original Method ----------
        //formatData = (DateFormatSymbols) value.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.879 -0400", hash_original_method = "0CBAC1F89B5D111A3585F82BE6753903", hash_generated_method = "4FA25ADB5EE19013821DD4B8EC662BC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toLocalizedPattern() {
        String var9D7D20FAE1E8370FD4B87CBD41E25C22_934529241 = (convertPattern(pattern, PATTERN_CHARS, formatData.getLocalPatternChars(), false));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return convertPattern(pattern, PATTERN_CHARS, formatData.getLocalPatternChars(), false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.883 -0400", hash_original_method = "FC74B76DEBD3C100A988B40A9B23664F", hash_generated_method = "58DB67D74D7286DC04494E075E976CCC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.885 -0400", hash_original_method = "35D638E960413F452190EF441C98A34C", hash_generated_method = "D94109F464D1BD0D9F8159EAE9626F9E")
    @DSModeled(DSC.SAFE)
    public String toPattern() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return pattern;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.887 -0400", hash_original_method = "C5F79137BB7206158B23593D7F9B176B", hash_generated_method = "4842884063CAB94DE32E2D27D2110C5B")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:20.889 -0400", hash_original_method = "8B9631F89FAD33D3B003933051524309", hash_generated_method = "68CF3E09B65B2A3180F10440F8D4AA3B")
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

    
}


