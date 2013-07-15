package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.973 -0400", hash_original_field = "240BF022E685B0EE30AD9FE9E1FB5D5B", hash_generated_field = "8AE769BFE2CAD1B10C494CCD4D4D489A")

    private String pattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.973 -0400", hash_original_field = "B92E573129E9FB1D0BF38D29B8A706A2", hash_generated_field = "8EEEF9C78A0C692C98D78AB64DB0C20D")

    private DateFormatSymbols formatData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.973 -0400", hash_original_field = "712A97B2F4207AEC6A75B48EAB21BF85", hash_generated_field = "6DC58B2FFCD396D044D4105C5E7E21CC")

    transient private int creationYear;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.973 -0400", hash_original_field = "94D5A7D82D300ED81AB6D9A58D07F6BE", hash_generated_field = "7490904CE4798294C2932FA3B8A81D84")

    private Date defaultCenturyStart;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.974 -0400", hash_original_method = "55288B23256ED63825B1D49B41027576", hash_generated_method = "F82B18A1A66AF548F5C62D87F2131939")
    public  SimpleDateFormat() {
        this(Locale.getDefault());
        this.pattern = defaultPattern();
        this.formatData = new DateFormatSymbols(Locale.getDefault());
        // ---------- Original Method ----------
        //this.pattern = defaultPattern();
        //this.formatData = new DateFormatSymbols(Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.974 -0400", hash_original_method = "DF79561AB8D44B187C9CA04B354315AC", hash_generated_method = "D4A2069D1C68F4AB2BBA6AA73240C2D8")
    public  SimpleDateFormat(String pattern) {
        this(pattern, Locale.getDefault());
        addTaint(pattern.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.975 -0400", hash_original_method = "2C117D04FF17ED0139CEC7451AA4BD73", hash_generated_method = "BA4FDDD7A78A1236519D0152F2C887F3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.976 -0400", hash_original_method = "1BCD123DF2A5414BB2A2ECF5D3357D25", hash_generated_method = "476D04B09E3E58E3666ECF86228F2313")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.977 -0400", hash_original_method = "F464E2338695834D875FCA6185F1E83B", hash_generated_method = "E5454081FE896EFEC960EA2EC9ACCD73")
    private  SimpleDateFormat(Locale locale) {
        addTaint(locale.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.977 -0400", hash_original_method = "411C0D5D8AD5CB18D4C2CE04A3CEEBF0", hash_generated_method = "7E489D3F7EAEB44E881EA04E6009CFF2")
    private void validateFormat(char format) {
        addTaint(format);
        int index = PATTERN_CHARS.indexOf(format);
    if(index == -1)        
        {
            IllegalArgumentException var5E16A7CD4B7CEB0DD90E96CEF9F8D8FC_1932342894 = new IllegalArgumentException("Unknown pattern character '" + format + "'");
            var5E16A7CD4B7CEB0DD90E96CEF9F8D8FC_1932342894.addTaint(taint);
            throw var5E16A7CD4B7CEB0DD90E96CEF9F8D8FC_1932342894;
        } //End block
        // ---------- Original Method ----------
        //int index = PATTERN_CHARS.indexOf(format);
        //if (index == -1) {
            //throw new IllegalArgumentException("Unknown pattern character '" + format + "'");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.979 -0400", hash_original_method = "49C9E23BED9AC71209F0210F812D9D37", hash_generated_method = "34849C0937DBA3CE44DCD0797C9DBDFF")
    private void validatePattern(String template) {
        addTaint(template.getTaint());
        boolean quote = false;
        int next;
        int last = -1;
        int count = 0;
        final int patternLength = template.length();
for(int i = 0;i < patternLength;i++)
        {
            next = (template.charAt(i));
    if(next == '\'')            
            {
    if(count > 0)                
                {
                    validateFormat((char) last);
                    count = 0;
                } //End block
    if(last == next)                
                {
                    last = -1;
                } //End block
                else
                {
                    last = next;
                } //End block
                quote = !quote;
                continue;
            } //End block
    if(!quote
                    && (last == next || (next >= 'a' && next <= 'z') || (next >= 'A' && next <= 'Z')))            
            {
    if(last == next)                
                {
                    count++;
                } //End block
                else
                {
    if(count > 0)                    
                    {
                        validateFormat((char) last);
                    } //End block
                    last = next;
                    count = 1;
                } //End block
            } //End block
            else
            {
    if(count > 0)                
                {
                    validateFormat((char) last);
                    count = 0;
                } //End block
                last = -1;
            } //End block
        } //End block
    if(count > 0)        
        {
            validateFormat((char) last);
        } //End block
    if(quote)        
        {
            IllegalArgumentException var7C318F245198BF5B8518FA0EBBDC7533_1402962142 = new IllegalArgumentException("Unterminated quote");
            var7C318F245198BF5B8518FA0EBBDC7533_1402962142.addTaint(taint);
            throw var7C318F245198BF5B8518FA0EBBDC7533_1402962142;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.980 -0400", hash_original_method = "9688C7F66E6F76D1BE1FBD610A4BC951", hash_generated_method = "8E68E16C2D98EE10C6281ED8D7385F2A")
    public void applyLocalizedPattern(String template) {
        pattern = convertPattern(template, formatData.getLocalPatternChars(), PATTERN_CHARS, true);
        // ---------- Original Method ----------
        //pattern = convertPattern(template, formatData.getLocalPatternChars(), PATTERN_CHARS, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.981 -0400", hash_original_method = "3EFD18F746D60C3172C5216CCD625C1E", hash_generated_method = "3B487F85B3ED861181DD02458BC7C04B")
    public void applyPattern(String template) {
        validatePattern(template);
        pattern = template;
        // ---------- Original Method ----------
        //validatePattern(template);
        //pattern = template;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.981 -0400", hash_original_method = "894F4ABDB71A6E4F1997CC330255AFC7", hash_generated_method = "9C278A2238BFED8A87185D68216E935B")
    @Override
    public Object clone() {
        SimpleDateFormat clone = (SimpleDateFormat) super.clone();
        clone.formatData = (DateFormatSymbols) formatData.clone();
        clone.defaultCenturyStart = new Date(defaultCenturyStart.getTime());
Object var3DE52045BFD3C1BF3742F994ED6139AD_745006377 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_745006377.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_745006377;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.982 -0400", hash_original_method = "386F5EAAB97078077630DB3A1FE9C0D6", hash_generated_method = "9D343E89542B5F56EDB0FD6E05484FA1")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
    if(this == object)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_995198579 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1022785216 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1022785216;
        } //End block
    if(!(object instanceof SimpleDateFormat))        
        {
            boolean var68934A3E9455FA72420237EB05902327_2078087201 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1107660827 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1107660827;
        } //End block
        SimpleDateFormat simple = (SimpleDateFormat) object;
        boolean var91AE0C6DF42229A6706625538AAC2C7D_1341328728 = (super.equals(object) && pattern.equals(simple.pattern)
                && formatData.equals(simple.formatData));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1097310358 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1097310358;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.983 -0400", hash_original_method = "F8A48BC85545A42AFE53260512DF9B2E", hash_generated_method = "6B8ADCAB51356531743FB9801A70A598")
    @Override
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        addTaint(object.getTaint());
    if(object == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_2132985645 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_2132985645.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_2132985645;
        } //End block
    if(object instanceof Date)        
        {
AttributedCharacterIterator varEC3F7284F348DEDCFA5E4DF622B30198_631875577 =             formatToCharacterIteratorImpl((Date) object);
            varEC3F7284F348DEDCFA5E4DF622B30198_631875577.addTaint(taint);
            return varEC3F7284F348DEDCFA5E4DF622B30198_631875577;
        } //End block
    if(object instanceof Number)        
        {
AttributedCharacterIterator var5A5CEE3F758E980FD8115C3D54EE8214_2010505776 =             formatToCharacterIteratorImpl(new Date(((Number) object).longValue()));
            var5A5CEE3F758E980FD8115C3D54EE8214_2010505776.addTaint(taint);
            return var5A5CEE3F758E980FD8115C3D54EE8214_2010505776;
        } //End block
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_765490813 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_765490813.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_765490813;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.983 -0400", hash_original_method = "39C7DAF020DB077C56334C25B45C6758", hash_generated_method = "1219788CE9746D8679F1AED8566C5831")
    private AttributedCharacterIterator formatToCharacterIteratorImpl(Date date) {
        addTaint(date.getTaint());
        StringBuffer buffer = new StringBuffer();
        ArrayList<FieldPosition> fields = new ArrayList<FieldPosition>();
        formatImpl(date, buffer, null, fields);
        AttributedString as = new AttributedString(buffer.toString());
for(FieldPosition pos : fields)
        {
            Format.Field attribute = pos.getFieldAttribute();
            as.addAttribute(attribute, attribute, pos.getBeginIndex(), pos.getEndIndex());
        } //End block
AttributedCharacterIterator varE3ABF6B4C0DDC070CF0843A4557F5D73_854569364 =         as.getIterator();
        varE3ABF6B4C0DDC070CF0843A4557F5D73_854569364.addTaint(taint);
        return varE3ABF6B4C0DDC070CF0843A4557F5D73_854569364;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.997 -0400", hash_original_method = "1377B288F93939E9FA031027B23EE480", hash_generated_method = "ECABAC8328D52D84204521F94F26ED2C")
    private StringBuffer formatImpl(Date date, StringBuffer buffer,
            FieldPosition field, List<FieldPosition> fields) {
        addTaint(fields.getTaint());
        addTaint(field.getTaint());
        addTaint(buffer.getTaint());
        addTaint(date.getTaint());
        boolean quote = false;
        int next;
        int last = -1;
        int count = 0;
        calendar.setTime(date);
    if(field != null)        
        {
            field.clear();
        } //End block
        final int patternLength = pattern.length();
for(int i = 0;i < patternLength;i++)
        {
            next = (pattern.charAt(i));
    if(next == '\'')            
            {
    if(count > 0)                
                {
                    append(buffer, field, fields, (char) last, count);
                    count = 0;
                } //End block
    if(last == next)                
                {
                    buffer.append('\'');
                    last = -1;
                } //End block
                else
                {
                    last = next;
                } //End block
                quote = !quote;
                continue;
            } //End block
    if(!quote
                    && (last == next || (next >= 'a' && next <= 'z') || (next >= 'A' && next <= 'Z')))            
            {
    if(last == next)                
                {
                    count++;
                } //End block
                else
                {
    if(count > 0)                    
                    {
                        append(buffer, field, fields, (char) last, count);
                    } //End block
                    last = next;
                    count = 1;
                } //End block
            } //End block
            else
            {
    if(count > 0)                
                {
                    append(buffer, field, fields, (char) last, count);
                    count = 0;
                } //End block
                last = -1;
                buffer.append((char) next);
            } //End block
        } //End block
    if(count > 0)        
        {
            append(buffer, field, fields, (char) last, count);
        } //End block
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_938092539 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_938092539.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_938092539;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.001 -0400", hash_original_method = "60C88CC31EC17788C6D13B63E0E097AB", hash_generated_method = "0451B5584E716EA8D75331A7C4916354")
    private void append(StringBuffer buffer, FieldPosition position,
            List<FieldPosition> fields, char format, int count) {
        addTaint(count);
        addTaint(format);
        addTaint(fields.getTaint());
        addTaint(position.getTaint());
        addTaint(buffer.getTaint());
        int field = -1;
        int index = PATTERN_CHARS.indexOf(format);
    if(index == -1)        
        {
            IllegalArgumentException var5E16A7CD4B7CEB0DD90E96CEF9F8D8FC_912807873 = new IllegalArgumentException("Unknown pattern character '" + format + "'");
            var5E16A7CD4B7CEB0DD90E96CEF9F8D8FC_912807873.addTaint(taint);
            throw var5E16A7CD4B7CEB0DD90E96CEF9F8D8FC_912807873;
        } //End block
        int beginPosition = buffer.length();
        Field dateFormatField = null;
switch(index){
        case ERA_FIELD:
        dateFormatField = Field.ERA;
        buffer.append(formatData.eras[calendar.get(Calendar.ERA)]);
        break;
        case YEAR_FIELD:
        dateFormatField = Field.YEAR;
        int year = calendar.get(Calendar.YEAR);
    if(count == 2)        
        {
            appendNumber(buffer, 2, year % 100);
        } //End block
        else
        {
            appendNumber(buffer, count, year);
        } //End block
        break;
        case STAND_ALONE_MONTH_FIELD:
        dateFormatField = Field.MONTH;
        appendMonth(buffer, count, formatData.longStandAloneMonths, formatData.shortStandAloneMonths);
        break;
        case MONTH_FIELD:
        dateFormatField = Field.MONTH;
        appendMonth(buffer, count, formatData.months, formatData.shortMonths);
        break;
        case DATE_FIELD:
        dateFormatField = Field.DAY_OF_MONTH;
        field = Calendar.DATE;
        break;
        case HOUR_OF_DAY1_FIELD:
        dateFormatField = Field.HOUR_OF_DAY1;
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        appendNumber(buffer, count, hour == 0 ? 24 : hour);
        break;
        case HOUR_OF_DAY0_FIELD:
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
        case HOUR1_FIELD:
        dateFormatField = Field.HOUR1;
        hour = calendar.get(Calendar.HOUR);
        appendNumber(buffer, count, hour == 0 ? 12 : hour);
        break;
        case HOUR0_FIELD:
        dateFormatField = Field.HOUR0;
        field = Calendar.HOUR;
        break;
        case TIMEZONE_FIELD:
        dateFormatField = Field.TIME_ZONE;
        appendTimeZone(buffer, count, true);
        break;
        case RFC_822_TIMEZONE_FIELD:
        dateFormatField = Field.TIME_ZONE;
        appendNumericTimeZone(buffer, false);
        break;
}    if(field != -1)        
        {
            appendNumber(buffer, count, calendar.get(field));
        } //End block
    if(fields != null)        
        {
            position = new FieldPosition(dateFormatField);
            position.setBeginIndex(beginPosition);
            position.setEndIndex(buffer.length());
            fields.add(position);
        } //End block
        else
        {
    if((position.getFieldAttribute() == dateFormatField || (position
                    .getFieldAttribute() == null && position.getField() == index))
                    && position.getEndIndex() == 0)            
            {
                position.setBeginIndex(beginPosition);
                position.setEndIndex(buffer.length());
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.001 -0400", hash_original_method = "DD478E87C0FA9016B83D28121FBA02DB", hash_generated_method = "DFBA177F2BF00EE30DFF847F56929191")
    private void appendDayOfWeek(StringBuffer buffer, int count, String[] longs, String[] shorts) {
        addTaint(shorts[0].getTaint());
        addTaint(longs[0].getTaint());
        addTaint(count);
        addTaint(buffer.getTaint());
        boolean isLong = (count > 3);
        String[] days = isLong ? longs : shorts;
        buffer.append(days[calendar.get(Calendar.DAY_OF_WEEK)]);
        // ---------- Original Method ----------
        //boolean isLong = (count > 3);
        //String[] days = isLong ? longs : shorts;
        //buffer.append(days[calendar.get(Calendar.DAY_OF_WEEK)]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.001 -0400", hash_original_method = "7A41E7167A1A13C1027D42A61A5B401C", hash_generated_method = "EB2EA5D62C887563BFD133F4E31229D4")
    private void appendMonth(StringBuffer buffer, int count, String[] longs, String[] shorts) {
        addTaint(shorts[0].getTaint());
        addTaint(longs[0].getTaint());
        addTaint(count);
        addTaint(buffer.getTaint());
        int month = calendar.get(Calendar.MONTH);
    if(count <= 2)        
        {
            appendNumber(buffer, count, month + 1);
            return;
        } //End block
        boolean isLong = (count > 3);
        String[] months = isLong ? longs : shorts;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.002 -0400", hash_original_method = "D7241707B86764AD36DA13023C5322B5", hash_generated_method = "28322BC22B56F57D563815353F3303A9")
    private void appendTimeZone(StringBuffer buffer, int count, boolean generalTimeZone) {
        addTaint(generalTimeZone);
        addTaint(count);
        addTaint(buffer.getTaint());
    if(generalTimeZone)        
        {
            TimeZone tz = calendar.getTimeZone();
            boolean daylight = (calendar.get(Calendar.DST_OFFSET) != 0);
            int style = count < 4 ? TimeZone.SHORT : TimeZone.LONG;
    if(!formatData.customZoneStrings)            
            {
                buffer.append(tz.getDisplayName(daylight, style, formatData.locale));
                return;
            } //End block
            String custom = TimeZones.getDisplayName(formatData.zoneStrings, tz.getID(), daylight, style);
    if(custom != null)            
            {
                buffer.append(custom);
                return;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.002 -0400", hash_original_method = "E1D84DE5BC6EBCC18019540ED725D9AE", hash_generated_method = "DEBFC761BED26E5BE4355BF3D1A5CCAE")
    private void appendNumericTimeZone(StringBuffer buffer, boolean generalTimeZone) {
        addTaint(generalTimeZone);
        addTaint(buffer.getTaint());
        int offset = calendar.get(Calendar.ZONE_OFFSET) + calendar.get(Calendar.DST_OFFSET);
        char sign = '+';
    if(offset < 0)        
        {
            sign = '-';
            offset = -offset;
        } //End block
    if(generalTimeZone)        
        {
            buffer.append("GMT");
        } //End block
        buffer.append(sign);
        appendNumber(buffer, 2, offset / 3600000);
    if(generalTimeZone)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.003 -0400", hash_original_method = "9FC1BA4007CF5C77F0A2B74AE6FBC98F", hash_generated_method = "594FDB6FE657F4C8BA35C742EF63CD55")
    private void appendNumber(StringBuffer buffer, int count, int value) {
        addTaint(value);
        addTaint(count);
        addTaint(buffer.getTaint());
        int minimumIntegerDigits = numberFormat.getMinimumIntegerDigits();
        numberFormat.setMinimumIntegerDigits(count);
        numberFormat.format(Integer.valueOf(value), buffer, new FieldPosition(0));
        numberFormat.setMinimumIntegerDigits(minimumIntegerDigits);
        // ---------- Original Method ----------
        //int minimumIntegerDigits = numberFormat.getMinimumIntegerDigits();
        //numberFormat.setMinimumIntegerDigits(count);
        //numberFormat.format(Integer.valueOf(value), buffer, new FieldPosition(0));
        //numberFormat.setMinimumIntegerDigits(minimumIntegerDigits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.003 -0400", hash_original_method = "332B10C296E05CECE855CC96158B0A61", hash_generated_method = "5E4D92F4688CED917DF9BCF9C2F48257")
    private Date error(ParsePosition position, int offset, TimeZone zone) {
        addTaint(zone.getTaint());
        addTaint(offset);
        addTaint(position.getTaint());
        position.setErrorIndex(offset);
        calendar.setTimeZone(zone);
Date var540C13E9E156B687226421B24F2DF178_73702682 =         null;
        var540C13E9E156B687226421B24F2DF178_73702682.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_73702682;
        // ---------- Original Method ----------
        //position.setErrorIndex(offset);
        //calendar.setTimeZone(zone);
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.003 -0400", hash_original_method = "F2F2556FE533C0A730BEC347E52E5292", hash_generated_method = "1280C2D203D604D634CC3D321499BC57")
    @Override
    public StringBuffer format(Date date, StringBuffer buffer, FieldPosition fieldPos) {
        addTaint(fieldPos.getTaint());
        addTaint(buffer.getTaint());
        addTaint(date.getTaint());
StringBuffer var0F50A9D01EA4EF57632444C72835C067_133353712 =         formatImpl(date, buffer, fieldPos, null);
        var0F50A9D01EA4EF57632444C72835C067_133353712.addTaint(taint);
        return var0F50A9D01EA4EF57632444C72835C067_133353712;
        // ---------- Original Method ----------
        //return formatImpl(date, buffer, fieldPos, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.004 -0400", hash_original_method = "71AF220EE7B6857040DD249E69ABFBDC", hash_generated_method = "5692322865A3B5C790DBC5107DA3A609")
    public Date get2DigitYearStart() {
Date varBA1FA37EE712CBCDA22DDA5229C33D31_17994624 =         (Date) defaultCenturyStart.clone();
        varBA1FA37EE712CBCDA22DDA5229C33D31_17994624.addTaint(taint);
        return varBA1FA37EE712CBCDA22DDA5229C33D31_17994624;
        // ---------- Original Method ----------
        //return (Date) defaultCenturyStart.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.004 -0400", hash_original_method = "CB6B47612D51E0A5BF8CB9FEBD927C3E", hash_generated_method = "49AF4B19DFECAC0A18472B292EEA3E57")
    public DateFormatSymbols getDateFormatSymbols() {
DateFormatSymbols var1D299C2B14400BA87F207ABC1470D595_1796162907 =         (DateFormatSymbols) formatData.clone();
        var1D299C2B14400BA87F207ABC1470D595_1796162907.addTaint(taint);
        return var1D299C2B14400BA87F207ABC1470D595_1796162907;
        // ---------- Original Method ----------
        //return (DateFormatSymbols) formatData.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.004 -0400", hash_original_method = "90B9D79300B8D8466B4A869D0B95FB5A", hash_generated_method = "AA6EE18492CEBFACE71A9EC3E2EFEF66")
    @Override
    public int hashCode() {
        int var66565EAAEA6B22AEE1E4447CBBADFC49_933896693 = (super.hashCode() + pattern.hashCode() + formatData.hashCode() + creationYear);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_207442307 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_207442307;
        // ---------- Original Method ----------
        //return super.hashCode() + pattern.hashCode() + formatData.hashCode() + creationYear;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.009 -0400", hash_original_method = "308621012329CC130ED3BC1A1EBA54C1", hash_generated_method = "E9A071100B5AD767F8BF08BDF88440AB")
    private int parse(String string, int offset, char format, int count) {
        addTaint(count);
        addTaint(format);
        addTaint(offset);
        addTaint(string.getTaint());
        int index = PATTERN_CHARS.indexOf(format);
    if(index == -1)        
        {
            IllegalArgumentException var5E16A7CD4B7CEB0DD90E96CEF9F8D8FC_1315355781 = new IllegalArgumentException("Unknown pattern character '" + format + "'");
            var5E16A7CD4B7CEB0DD90E96CEF9F8D8FC_1315355781.addTaint(taint);
            throw var5E16A7CD4B7CEB0DD90E96CEF9F8D8FC_1315355781;
        } //End block
        int field = -1;
        int absolute = 0;
    if(count < 0)        
        {
            count = -count;
            absolute = count;
        } //End block
switch(index){
        case ERA_FIELD:
        int var9301A0A89171DAEEDA482FAA340DAFD9_27365305 = (parseText(string, offset, formatData.eras, Calendar.ERA));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_893927136 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_893927136;
        case YEAR_FIELD:
    if(count >= 3)        
        {
            field = Calendar.YEAR;
        } //End block
        else
        {
            ParsePosition position = new ParsePosition(offset);
            Number result = parseNumber(absolute, string, position);
    if(result == null)            
            {
                int varF1B9D519E1757129140036D93B851057_735875845 = (-position.getErrorIndex() - 1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1400244765 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1400244765;
            } //End block
            int year = result.intValue();
    if((position.getIndex() - offset) == 2 && year >= 0)            
            {
                year += creationYear / 100 * 100;
    if(year < creationYear)                
                {
                    year += 100;
                } //End block
            } //End block
            calendar.set(Calendar.YEAR, year);
            int var57E1DED23A17D5FCAD98CCD8D8F11A05_1678841376 = (position.getIndex());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1802124747 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1802124747;
        } //End block
        break;
        case STAND_ALONE_MONTH_FIELD:
        int varDD7E0F84325872645D031B0E53B2416B_1500191279 = (parseMonth(string, offset, count, absolute,
                        formatData.longStandAloneMonths, formatData.shortStandAloneMonths));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1515040076 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1515040076;
        case MONTH_FIELD:
        int var943DEF4CD06F672313CCFCB5B44F95EF_784216098 = (parseMonth(string, offset, count, absolute,
                        formatData.months, formatData.shortMonths));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1339376773 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1339376773;
        case DATE_FIELD:
        field = Calendar.DATE;
        break;
        case HOUR_OF_DAY1_FIELD:
        ParsePosition position = new ParsePosition(offset);
        Number result = parseNumber(absolute, string, position);
    if(result == null)        
        {
            int varF1B9D519E1757129140036D93B851057_783144180 = (-position.getErrorIndex() - 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1361172221 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1361172221;
        } //End block
        int hour = result.intValue();
    if(hour == 24)        
        {
            hour = 0;
        } //End block
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        int var57E1DED23A17D5FCAD98CCD8D8F11A05_1795473952 = (position.getIndex());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1121401784 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1121401784;
        case HOUR_OF_DAY0_FIELD:
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
        int var2E87FC1CFA07816D20F2709CF760C507_958884901 = (parseDayOfWeek(string, offset, formatData.longStandAloneWeekdays, formatData.shortStandAloneWeekdays));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2104747358 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2104747358;
        case DAY_OF_WEEK_FIELD:
        int var36D852CC1CA4763B3A4780AA2DB75AA5_481928379 = (parseDayOfWeek(string, offset, formatData.weekdays, formatData.shortWeekdays));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2125166077 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2125166077;
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
        int var8314AE86DEF9A9639D2761C8F2B7044A_31738919 = (parseText(string, offset, formatData.ampms, Calendar.AM_PM));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_991677949 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_991677949;
        case HOUR1_FIELD:
        position = new ParsePosition(offset);
        result = parseNumber(absolute, string, position);
    if(result == null)        
        {
            int varF1B9D519E1757129140036D93B851057_2045460176 = (-position.getErrorIndex() - 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1969884523 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1969884523;
        } //End block
        hour = result.intValue();
    if(hour == 12)        
        {
            hour = 0;
        } //End block
        calendar.set(Calendar.HOUR, hour);
        int var57E1DED23A17D5FCAD98CCD8D8F11A05_224368308 = (position.getIndex());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2003808569 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2003808569;
        case HOUR0_FIELD:
        field = Calendar.HOUR;
        break;
        case TIMEZONE_FIELD:
        int var36BF83B80AB2AD8D2A159690FC041650_65200690 = (parseTimeZone(string, offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1744017391 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1744017391;
        case RFC_822_TIMEZONE_FIELD:
        int var36BF83B80AB2AD8D2A159690FC041650_2048687223 = (parseTimeZone(string, offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_163514199 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_163514199;
}    if(field != -1)        
        {
            int var4005E6A24667F1C03CF0B10BB7BCB53F_1284685720 = (parseNumber(absolute, string, offset, field, 0));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1963765865 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1963765865;
        } //End block
        int var7A86C157EE9713C34FBD7A1EE40F0C5A_1736120967 = (offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1824115186 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1824115186;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.011 -0400", hash_original_method = "4C5DAB8F3090E0FED455AF9657387367", hash_generated_method = "161475EC0742979DC04CD0241BAADE8B")
    private int parseDayOfWeek(String string, int offset, String[] longs, String[] shorts) {
        addTaint(shorts[0].getTaint());
        addTaint(longs[0].getTaint());
        addTaint(offset);
        addTaint(string.getTaint());
        int index = parseText(string, offset, longs, Calendar.DAY_OF_WEEK);
    if(index < 0)        
        {
            index = parseText(string, offset, shorts, Calendar.DAY_OF_WEEK);
        } //End block
        int var6A992D5529F459A44FEE58C733255E86_979019225 = (index);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_15495856 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_15495856;
        // ---------- Original Method ----------
        //int index = parseText(string, offset, longs, Calendar.DAY_OF_WEEK);
        //if (index < 0) {
            //index = parseText(string, offset, shorts, Calendar.DAY_OF_WEEK);
        //}
        //return index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.012 -0400", hash_original_method = "2749F9959CF57ED8E7DF53A146C2F50E", hash_generated_method = "7B5DEDAA4CAD7DB5ABEE1DF113EC5A5A")
    private int parseMonth(String string, int offset, int count, int absolute, String[] longs, String[] shorts) {
        addTaint(shorts[0].getTaint());
        addTaint(longs[0].getTaint());
        addTaint(absolute);
        addTaint(count);
        addTaint(offset);
        addTaint(string.getTaint());
    if(count <= 2)        
        {
            int varF871C0B29DCCB599CC1ECA3DD001C02C_1426001907 = (parseNumber(absolute, string, offset, Calendar.MONTH, -1));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2066068707 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2066068707;
        } //End block
        int index = parseText(string, offset, longs, Calendar.MONTH);
    if(index < 0)        
        {
            index = parseText(string, offset, shorts, Calendar.MONTH);
        } //End block
        int var6A992D5529F459A44FEE58C733255E86_1812135850 = (index);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_188068468 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_188068468;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.016 -0400", hash_original_method = "7359DD4332D8271AC0BCC2D6C59D8B62", hash_generated_method = "475C41A247DDA67F27D009FAD5D9CDB3")
    @Override
    public Date parse(String string, ParsePosition position) {
        addTaint(position.getTaint());
        addTaint(string.getTaint());
        boolean quote = false;
        int next;
        int last = -1;
        int count = 0;
        int offset = position.getIndex();
        int length = string.length();
        calendar.clear();
        TimeZone zone = calendar.getTimeZone();
        final int patternLength = pattern.length();
for(int i = 0;i < patternLength;i++)
        {
            next = pattern.charAt(i);
    if(next == '\'')            
            {
    if(count > 0)                
                {
    if((offset = parse(string, offset, (char) last, count)) < 0)                    
                    {
Date varF2C98E64B384411932415E7B0D4DBE44_326355728 =                         error(position, -offset - 1, zone);
                        varF2C98E64B384411932415E7B0D4DBE44_326355728.addTaint(taint);
                        return varF2C98E64B384411932415E7B0D4DBE44_326355728;
                    } //End block
                    count = 0;
                } //End block
    if(last == next)                
                {
    if(offset >= length || string.charAt(offset) != '\'')                    
                    {
Date varE96EAB73B0E5D6E9DF30B4AC9F5927BA_355951178 =                         error(position, offset, zone);
                        varE96EAB73B0E5D6E9DF30B4AC9F5927BA_355951178.addTaint(taint);
                        return varE96EAB73B0E5D6E9DF30B4AC9F5927BA_355951178;
                    } //End block
                    offset++;
                    last = -1;
                } //End block
                else
                {
                    last = next;
                } //End block
                quote = !quote;
                continue;
            } //End block
    if(!quote
                    && (last == next || (next >= 'a' && next <= 'z') || (next >= 'A' && next <= 'Z')))            
            {
    if(last == next)                
                {
                    count++;
                } //End block
                else
                {
    if(count > 0)                    
                    {
    if((offset = parse(string, offset, (char) last, -count)) < 0)                        
                        {
Date varF2C98E64B384411932415E7B0D4DBE44_566179658 =                             error(position, -offset - 1, zone);
                            varF2C98E64B384411932415E7B0D4DBE44_566179658.addTaint(taint);
                            return varF2C98E64B384411932415E7B0D4DBE44_566179658;
                        } //End block
                    } //End block
                    last = next;
                    count = 1;
                } //End block
            } //End block
            else
            {
    if(count > 0)                
                {
    if((offset = parse(string, offset, (char) last, count)) < 0)                    
                    {
Date varF2C98E64B384411932415E7B0D4DBE44_447902058 =                         error(position, -offset - 1, zone);
                        varF2C98E64B384411932415E7B0D4DBE44_447902058.addTaint(taint);
                        return varF2C98E64B384411932415E7B0D4DBE44_447902058;
                    } //End block
                    count = 0;
                } //End block
                last = -1;
    if(offset >= length || string.charAt(offset) != next)                
                {
Date varE96EAB73B0E5D6E9DF30B4AC9F5927BA_860468293 =                     error(position, offset, zone);
                    varE96EAB73B0E5D6E9DF30B4AC9F5927BA_860468293.addTaint(taint);
                    return varE96EAB73B0E5D6E9DF30B4AC9F5927BA_860468293;
                } //End block
                offset++;
            } //End block
        } //End block
    if(count > 0)        
        {
    if((offset = parse(string, offset, (char) last, count)) < 0)            
            {
Date varF2C98E64B384411932415E7B0D4DBE44_640155350 =                 error(position, -offset - 1, zone);
                varF2C98E64B384411932415E7B0D4DBE44_640155350.addTaint(taint);
                return varF2C98E64B384411932415E7B0D4DBE44_640155350;
            } //End block
        } //End block
        Date date;
        try 
        {
            date = calendar.getTime();
        } //End block
        catch (IllegalArgumentException e)
        {
Date varE96EAB73B0E5D6E9DF30B4AC9F5927BA_1666473944 =             error(position, offset, zone);
            varE96EAB73B0E5D6E9DF30B4AC9F5927BA_1666473944.addTaint(taint);
            return varE96EAB73B0E5D6E9DF30B4AC9F5927BA_1666473944;
        } //End block
        position.setIndex(offset);
        calendar.setTimeZone(zone);
Date var1F31043EE3B8C862CA53EA8B99691F13_94484662 =         date;
        var1F31043EE3B8C862CA53EA8B99691F13_94484662.addTaint(taint);
        return var1F31043EE3B8C862CA53EA8B99691F13_94484662;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.018 -0400", hash_original_method = "21C7D4A169609BA40C676EFC62A50E23", hash_generated_method = "6BDE32061A5F7E2322EFE672DCF2D5BB")
    private Number parseNumber(int max, String string, ParsePosition position) {
        addTaint(position.getTaint());
        addTaint(string.getTaint());
        addTaint(max);
        int digit;
        int length = string.length();
        int result = 0;
        int index = position.getIndex();
    if(max > 0 && max < length - index)        
        {
            length = index + max;
        } //End block
        while
(index < length
                && (string.charAt(index) == ' ' || string.charAt(index) == '\t'))        
        {
            index++;
        } //End block
    if(max == 0)        
        {
            position.setIndex(index);
Number varBC3DFB26D41B6E1007F3A9183DEB1A89_736447965 =             numberFormat.parse(string, position);
            varBC3DFB26D41B6E1007F3A9183DEB1A89_736447965.addTaint(taint);
            return varBC3DFB26D41B6E1007F3A9183DEB1A89_736447965;
        } //End block
        while
(index < length
                && (digit = Character.digit(string.charAt(index), 10)) != -1)        
        {
            index++;
            result = result * 10 + digit;
        } //End block
    if(index == position.getIndex())        
        {
            position.setErrorIndex(index);
Number var540C13E9E156B687226421B24F2DF178_683376196 =             null;
            var540C13E9E156B687226421B24F2DF178_683376196.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_683376196;
        } //End block
        position.setIndex(index);
Number var784000E4696DA9110EFC21DABAA27F83_349209093 =         Integer.valueOf(result);
        var784000E4696DA9110EFC21DABAA27F83_349209093.addTaint(taint);
        return var784000E4696DA9110EFC21DABAA27F83_349209093;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.019 -0400", hash_original_method = "D6F7D67552A406D8EA22E8B872F7B057", hash_generated_method = "9FB50A05EBBAA337EF88525601F8C66C")
    private int parseNumber(int max, String string, int offset, int field, int skew) {
        addTaint(skew);
        addTaint(field);
        addTaint(offset);
        addTaint(string.getTaint());
        addTaint(max);
        ParsePosition position = new ParsePosition(offset);
        Number result = parseNumber(max, string, position);
    if(result == null)        
        {
            int varF1B9D519E1757129140036D93B851057_738257928 = (-position.getErrorIndex() - 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1729471816 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1729471816;
        } //End block
        calendar.set(field, result.intValue() + skew);
        int var57E1DED23A17D5FCAD98CCD8D8F11A05_609686565 = (position.getIndex());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_881210779 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_881210779;
        // ---------- Original Method ----------
        //ParsePosition position = new ParsePosition(offset);
        //Number result = parseNumber(max, string, position);
        //if (result == null) {
            //return -position.getErrorIndex() - 1;
        //}
        //calendar.set(field, result.intValue() + skew);
        //return position.getIndex();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.020 -0400", hash_original_method = "6091F52EF6DC933856441BD49E0F31F1", hash_generated_method = "DC1F33E3B286300CAD2F792871E93308")
    private int parseText(String string, int offset, String[] text, int field) {
        addTaint(field);
        addTaint(text[0].getTaint());
        addTaint(offset);
        addTaint(string.getTaint());
        int found = -1;
for(int i = 0;i < text.length;i++)
        {
    if(text[i].isEmpty())            
            {
                continue;
            } //End block
    if(string.regionMatches(true, offset, text[i], 0, text[i].length()))            
            {
    if(found == -1 || text[i].length() > text[found].length())                
                {
                    found = i;
                } //End block
            } //End block
        } //End block
    if(found != -1)        
        {
            calendar.set(field, found);
            int var6206F553F823DE46991178C0E7275432_124506140 = (offset + text[found].length());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_958883364 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_958883364;
        } //End block
        int var4573380BE390B404481CB00707F0B4C5_1342180125 = (-offset - 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_690849356 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_690849356;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.025 -0400", hash_original_method = "C11BF6380CD6AEFF5BAB825547AF7C4A", hash_generated_method = "8DD9A6B21C87328DDDCBCA1F4F0515F4")
    private int parseTimeZone(String string, int offset) {
        addTaint(offset);
        addTaint(string.getTaint());
        boolean foundGMT = string.regionMatches(offset, "GMT", 0, 3);
    if(foundGMT)        
        {
            offset += 3;
        } //End block
        char sign;
    if(offset < string.length()
                && ((sign = string.charAt(offset)) == '+' || sign == '-'))        
        {
            ParsePosition position = new ParsePosition(offset + 1);
            Number result = numberFormat.parse(string, position);
    if(result == null)            
            {
                int varF1B9D519E1757129140036D93B851057_1071496882 = (-position.getErrorIndex() - 1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_683226732 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_683226732;
            } //End block
            int hour = result.intValue();
            int raw = hour * 3600000;
            int index = position.getIndex();
    if(index < string.length() && string.charAt(index) == ':')            
            {
                position.setIndex(index + 1);
                result = numberFormat.parse(string, position);
    if(result == null)                
                {
                    int varF1B9D519E1757129140036D93B851057_1214864635 = (-position.getErrorIndex() - 1);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1903522869 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1903522869;
                } //End block
                int minute = result.intValue();
                raw += minute * 60000;
            } //End block
            else
    if(hour >= 24)            
            {
                raw = (hour / 100 * 3600000) + (hour % 100 * 60000);
            } //End block
    if(sign == '-')            
            {
                raw = -raw;
            } //End block
            calendar.setTimeZone(new SimpleTimeZone(raw, ""));
            int var57E1DED23A17D5FCAD98CCD8D8F11A05_137627676 = (position.getIndex());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1430419314 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1430419314;
        } //End block
    if(foundGMT)        
        {
            calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
            int var7A86C157EE9713C34FBD7A1EE40F0C5A_2049133745 = (offset);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1364110054 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1364110054;
        } //End block
        String[][] zones = formatData.internalZoneStrings();
for(String[] element : zones)
        {
for(int j = TimeZones.LONG_NAME;j < TimeZones.NAME_COUNT;j++)
            {
    if(string.regionMatches(true, offset, element[j], 0, element[j].length()))                
                {
                    TimeZone zone = TimeZone.getTimeZone(element[TimeZones.OLSON_NAME]);
    if(zone == null)                    
                    {
                        int var4573380BE390B404481CB00707F0B4C5_1627454231 = (-offset - 1);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_810001108 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_810001108;
                    } //End block
                    int raw = zone.getRawOffset();
    if(j == TimeZones.LONG_NAME_DST || j == TimeZones.SHORT_NAME_DST)                    
                    {
                        raw += 3600000;
                    } //End block
                    calendar.setTimeZone(new SimpleTimeZone(raw, ""));
                    int varBF2C48E1937183EAA22FCC3030627C57_843840882 = (offset + element[j].length());
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1800692724 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1800692724;
                } //End block
            } //End block
        } //End block
        int var4573380BE390B404481CB00707F0B4C5_984366900 = (-offset - 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1749838739 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1749838739;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.026 -0400", hash_original_method = "893CAD0A3A74697E4DAD4463A5252E56", hash_generated_method = "2F09D19B6383A55C65C652796D6E2723")
    public void set2DigitYearStart(Date date) {
        defaultCenturyStart = (Date) date.clone();
        Calendar cal = new GregorianCalendar();
        cal.setTime(defaultCenturyStart);
        creationYear = cal.get(Calendar.YEAR);
        // ---------- Original Method ----------
        //defaultCenturyStart = (Date) date.clone();
        //Calendar cal = new GregorianCalendar();
        //cal.setTime(defaultCenturyStart);
        //creationYear = cal.get(Calendar.YEAR);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.027 -0400", hash_original_method = "4ECB9E8EB801E57F7682FCC8E531C475", hash_generated_method = "7D960DE801802A6F7D2D49263FFB2EB7")
    public void setDateFormatSymbols(DateFormatSymbols value) {
        formatData = (DateFormatSymbols) value.clone();
        // ---------- Original Method ----------
        //formatData = (DateFormatSymbols) value.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.027 -0400", hash_original_method = "0CBAC1F89B5D111A3585F82BE6753903", hash_generated_method = "7F3B8AEE2FBD7BAA79A0D007F68877F9")
    public String toLocalizedPattern() {
String var240EBD5AC8EFFE1F951B588542F8A189_866801605 =         convertPattern(pattern, PATTERN_CHARS, formatData.getLocalPatternChars(), false);
        var240EBD5AC8EFFE1F951B588542F8A189_866801605.addTaint(taint);
        return var240EBD5AC8EFFE1F951B588542F8A189_866801605;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.028 -0400", hash_original_method = "35D638E960413F452190EF441C98A34C", hash_generated_method = "A608004B85FCB44CFEFE7FBF819A5151")
    public String toPattern() {
String var407D32260E541B695CF3FD3F7EFB76AB_346560113 =         pattern;
        var407D32260E541B695CF3FD3F7EFB76AB_346560113.addTaint(taint);
        return var407D32260E541B695CF3FD3F7EFB76AB_346560113;
        // ---------- Original Method ----------
        //return pattern;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.028 -0400", hash_original_method = "C5F79137BB7206158B23593D7F9B176B", hash_generated_method = "08F97FDF950A558BEF6E2FC112777087")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        addTaint(stream.getTaint());
        ObjectOutputStream.PutField fields = stream.putFields();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.029 -0400", hash_original_method = "8B9631F89FAD33D3B003933051524309", hash_generated_method = "488B9FEB0505C151FEB961C02318E656")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        addTaint(stream.getTaint());
        ObjectInputStream.GetField fields = stream.readFields();
        int version = fields.get("serialVersionOnStream", 0);
        Date date;
    if(version > 0)        
        {
            date = (Date) fields.get("defaultCenturyStart", new Date());
        } //End block
        else
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.030 -0400", hash_original_field = "712430BF0146209ACE3FF92C25509F9C", hash_generated_field = "56D5BE14208D23988E9004C5F0B78F0A")

    private static final long serialVersionUID = 4774881970558875024L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.030 -0400", hash_original_field = "72D320CDF3E21B58BDA9BF6BAD2EE457", hash_generated_field = "768BF8FACCCDAD6AF5C419EAE423D264")

    static final String PATTERN_CHARS = "GyMdkHmsSEDFwWahKzZLc";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.030 -0400", hash_original_field = "4C1B5CFA65D7E5B57608F90036B5EB41", hash_generated_field = "B5246C35F9289E2F296B81640B112188")

    private static final int RFC_822_TIMEZONE_FIELD = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.030 -0400", hash_original_field = "B4558FC8452DBD732D3D4BD4F5C33B4C", hash_generated_field = "4DF0BEA5FBA0C049726ECF88BAEBB8A5")

    private static final int STAND_ALONE_MONTH_FIELD = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.030 -0400", hash_original_field = "6D4CEC0D6141F8F84E1E5888DD16C5B6", hash_generated_field = "94CC5BEC1C3B0327CFDF49E3D6B4021F")

    private static final int STAND_ALONE_DAY_OF_WEEK_FIELD = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.030 -0400", hash_original_field = "3C88CDD38A57AED6633CEAECC81C6EA2", hash_generated_field = "9ECCA64B643BE0EF052CE0F624B781F1")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("defaultCenturyStart", Date.class),
        new ObjectStreamField("formatData", DateFormatSymbols.class),
        new ObjectStreamField("pattern", String.class),
        new ObjectStreamField("serialVersionOnStream", int.class),
    };
}

