package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.InvalidObjectException;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Locale;
import java.util.TimeZone;
import libcore.icu.ICU;
import libcore.icu.LocaleData;

public abstract class DateFormat extends Format {
    private static final long serialVersionUID = 7218322306649953788L;
    protected Calendar calendar;
    protected NumberFormat numberFormat;
    public static final int DEFAULT = 2;
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    public static final int ERA_FIELD = 0;
    public static final int YEAR_FIELD = 1;
    public static final int MONTH_FIELD = 2;
    public static final int DATE_FIELD = 3;
    public static final int HOUR_OF_DAY1_FIELD = 4;
    public static final int HOUR_OF_DAY0_FIELD = 5;
    public static final int MINUTE_FIELD = 6;
    public static final int SECOND_FIELD = 7;
    public static final int MILLISECOND_FIELD = 8;
    public static final int DAY_OF_WEEK_FIELD = 9;
    public static final int DAY_OF_YEAR_FIELD = 10;
    public static final int DAY_OF_WEEK_IN_MONTH_FIELD = 11;
    public static final int WEEK_OF_YEAR_FIELD = 12;
    public static final int WEEK_OF_MONTH_FIELD = 13;
    public static final int AM_PM_FIELD = 14;
    public static final int HOUR1_FIELD = 15;
    public static final int HOUR0_FIELD = 16;
    public static final int TIMEZONE_FIELD = 17;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.893 -0400", hash_original_method = "B3EF4E3485D0789C83BAEC35E9E3BAD6", hash_generated_method = "07F95AE9E0D2BCAEBFB1993356C865E4")
    @DSModeled(DSC.SAFE)
    protected DateFormat() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.893 -0400", hash_original_method = "6214BE37793C3124BC718667B7E0632D", hash_generated_method = "1F43A551838B3E4C1B5A42E50EF28795")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        DateFormat clone;
        clone = (DateFormat) super.clone();
        clone.calendar = (Calendar) calendar.clone();
        clone.numberFormat = (NumberFormat) numberFormat.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //DateFormat clone = (DateFormat) super.clone();
        //clone.calendar = (Calendar) calendar.clone();
        //clone.numberFormat = (NumberFormat) numberFormat.clone();
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.893 -0400", hash_original_method = "ACA6119BE57A696CA271FA419EAF8A87", hash_generated_method = "31B4138C1C099905B8067D5D911C2ED6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        DateFormat dateFormat;
        dateFormat = (DateFormat) object;
        boolean var6547837465B05654A33DF377FA19670B_283764297 = (numberFormat.equals(dateFormat.numberFormat)
                && calendar.getTimeZone().equals(
                        dateFormat.calendar.getTimeZone())
                && calendar.getFirstDayOfWeek() == dateFormat.calendar
                        .getFirstDayOfWeek()
                && calendar.getMinimalDaysInFirstWeek() == dateFormat.calendar
                        .getMinimalDaysInFirstWeek()
                && calendar.isLenient() == dateFormat.calendar.isLenient());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (this == object) {
            //return true;
        //}
        //if (!(object instanceof DateFormat)) {
            //return false;
        //}
        //DateFormat dateFormat = (DateFormat) object;
        //return numberFormat.equals(dateFormat.numberFormat)
                //&& calendar.getTimeZone().equals(
                        //dateFormat.calendar.getTimeZone())
                //&& calendar.getFirstDayOfWeek() == dateFormat.calendar
                        //.getFirstDayOfWeek()
                //&& calendar.getMinimalDaysInFirstWeek() == dateFormat.calendar
                        //.getMinimalDaysInFirstWeek()
                //&& calendar.isLenient() == dateFormat.calendar.isLenient();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.893 -0400", hash_original_method = "B3CAB535AB645340CDBC761CC64061A2", hash_generated_method = "6B23A9AB156CA4541D32554142488AC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final StringBuffer format(Object object, StringBuffer buffer,
            FieldPosition field) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(field.dsTaint);
        dsTaint.addTaint(object.dsTaint);
        {
            StringBuffer varA015649C8CD63FE6E545D2340EECB111_847344051 = (format((Date) object, buffer, field));
        } //End block
        {
            StringBuffer var64C927786F472344128653963E19764D_906361581 = (format(new Date(((Number) object).longValue()), buffer,
                    field));
        } //End block
        throw new IllegalArgumentException();
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (object instanceof Date) {
            //return format((Date) object, buffer, field);
        //}
        //if (object instanceof Number) {
            //return format(new Date(((Number) object).longValue()), buffer,
                    //field);
        //}
        //throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.893 -0400", hash_original_method = "2A35FD3F5DCDDD81B439EA4274C41413", hash_generated_method = "6C37E57F89E624E20174676D017ACEAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String format(Date date) {
        dsTaint.addTaint(date.dsTaint);
        String var4EF9B7B8AD61089C39007EB093EDE249_758229671 = (format(date, new StringBuffer(), new FieldPosition(0))
                .toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return format(date, new StringBuffer(), new FieldPosition(0))
                //.toString();
    }

    
    public abstract StringBuffer format(Date date, StringBuffer buffer,
            FieldPosition field);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.893 -0400", hash_original_method = "EC1C9549160E2BC66E11F9DDB4B8FBD0", hash_generated_method = "8D491F66EE876E7A6F3079E4FA395FD6")
    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableDateFormatLocales();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.893 -0400", hash_original_method = "AC2D491D0E9EF49D1E9DF4E35BBACC3B", hash_generated_method = "85EACB3054C70AF27CF74A2815CA57EC")
    @DSModeled(DSC.SAFE)
    public Calendar getCalendar() {
        return (Calendar)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return calendar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.893 -0400", hash_original_method = "492FD3DDCD551887FA928B87F9CDC015", hash_generated_method = "1584BAADDCCEE1FD6566ABD02B67F340")
    public static final DateFormat getDateInstance() {
        return getDateInstance(DEFAULT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.893 -0400", hash_original_method = "E9C515926F59D15FF7CB88B0B60D9C22", hash_generated_method = "AA5C2AC1481A266A9A2F2128C5031964")
    public static final DateFormat getDateInstance(int style) {
        checkDateStyle(style);
        return getDateInstance(style, Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.894 -0400", hash_original_method = "2C09A4D27D27084B3D92D338508BC4B1", hash_generated_method = "0A3BDC25EFBB4AF2B4D924801B40054C")
    public static final DateFormat getDateInstance(int style, Locale locale) {
        checkDateStyle(style);
        return new SimpleDateFormat(LocaleData.get(locale).getDateFormat(style), locale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.894 -0400", hash_original_method = "83705E0AAFF633A246DC83A01D518F12", hash_generated_method = "E8401EC0A796A90AF72EB9263851C999")
    public static final DateFormat getDateTimeInstance() {
        return getDateTimeInstance(DEFAULT, DEFAULT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.894 -0400", hash_original_method = "A7E6AB35D13132D438F9DCCBC72BE606", hash_generated_method = "3900BD34F97E39BD1CA09511756D47FF")
    public static final DateFormat getDateTimeInstance(int dateStyle, int timeStyle) {
        checkTimeStyle(timeStyle);
        checkDateStyle(dateStyle);
        return getDateTimeInstance(dateStyle, timeStyle, Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.894 -0400", hash_original_method = "2285EB3463305C879C637226A064045A", hash_generated_method = "FF7CBCCFC8E13A430AD369002279FC0F")
    public static final DateFormat getDateTimeInstance(int dateStyle, int timeStyle, Locale locale) {
        checkTimeStyle(timeStyle);
        checkDateStyle(dateStyle);
        LocaleData localeData = LocaleData.get(locale);
        String pattern = localeData.getDateFormat(dateStyle) + " " + localeData.getTimeFormat(timeStyle);
        return new SimpleDateFormat(pattern, locale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.894 -0400", hash_original_method = "328D72CCC3CD1DC2B99E83C7AF31E8C0", hash_generated_method = "125F5E29A0A8C131F8DEC3BC1D902C43")
    public static final DateFormat getInstance() {
        return getDateTimeInstance(SHORT, SHORT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.894 -0400", hash_original_method = "303CF4BDA8F6551FE38CF841A2AE86A7", hash_generated_method = "B843F7252962C4BD13250C60984FE60C")
    @DSModeled(DSC.SAFE)
    public NumberFormat getNumberFormat() {
        return (NumberFormat)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return numberFormat;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.894 -0400", hash_original_method = "90581B7473F3E36379FBAEEBE90EB2FE", hash_generated_method = "5D6C0507FCEE4BAF6C384DE19C749A51")
    public static final DateFormat getTimeInstance() {
        return getTimeInstance(DEFAULT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.894 -0400", hash_original_method = "F938DFCF67BFE83189AB8EEA5DA2BD42", hash_generated_method = "30A9FE09077139894689C40593A1B38B")
    public static final DateFormat getTimeInstance(int style) {
        checkTimeStyle(style);
        return getTimeInstance(style, Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.894 -0400", hash_original_method = "694861B989ADA6B38BBA026408A73346", hash_generated_method = "0458389C40354284B85DBE0DD3EC5238")
    public static final DateFormat getTimeInstance(int style, Locale locale) {
        checkTimeStyle(style);
        return new SimpleDateFormat(LocaleData.get(locale).getTimeFormat(style), locale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.894 -0400", hash_original_method = "028D1A898568609D223BE7B30E97723B", hash_generated_method = "03875DC24B8687F110C7487B0474A213")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TimeZone getTimeZone() {
        TimeZone varEF3CCBEDCA0E47135FB0142E2055D67D_1215494708 = (calendar.getTimeZone());
        return (TimeZone)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return calendar.getTimeZone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.894 -0400", hash_original_method = "3F46A6ECEE37AE5ECC5364DC5B9940AE", hash_generated_method = "FD806EEF73F6F9709953624FDE9B5D24")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var00C4C661405C9C662884EAAED3C71D72_260636980 = (calendar.getFirstDayOfWeek()
                + calendar.getMinimalDaysInFirstWeek()
                + calendar.getTimeZone().hashCode()
                + (calendar.isLenient() ? 1231 : 1237)
                + numberFormat.hashCode()); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return calendar.getFirstDayOfWeek()
                //+ calendar.getMinimalDaysInFirstWeek()
                //+ calendar.getTimeZone().hashCode()
                //+ (calendar.isLenient() ? 1231 : 1237)
                //+ numberFormat.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.894 -0400", hash_original_method = "C4BF8639B942350BBBDBCDAD05669E72", hash_generated_method = "F20816F1087D929AA1E8AEDC4C72CEC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isLenient() {
        boolean varCF550C98B3980A2B47AF4BEE3581E80D_1878619218 = (calendar.isLenient());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return calendar.isLenient();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.894 -0400", hash_original_method = "CB060FB8FCF7D6D5A12D02C797F79FD4", hash_generated_method = "6A3AA97FEC0327103AF56C1D59F1B131")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Date parse(String string) throws ParseException {
        dsTaint.addTaint(string);
        ParsePosition position;
        position = new ParsePosition(0);
        Date date;
        date = parse(string, position);
        {
            boolean varA01BF4F3DE22A214F5C7EB004E28484E_265360612 = (position.getIndex() == 0);
            {
                throw new ParseException("Unparseable date: \"" + string + "\"",
                    position.getErrorIndex());
            } //End block
        } //End collapsed parenthetic
        return (Date)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ParsePosition position = new ParsePosition(0);
        //Date date = parse(string, position);
        //if (position.getIndex() == 0) {
            //throw new ParseException("Unparseable date: \"" + string + "\"",
                    //position.getErrorIndex());
        //}
        //return date;
    }

    
    public abstract Date parse(String string, ParsePosition position);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.894 -0400", hash_original_method = "C9AA8969DE1792F4979FB5B1F65B9849", hash_generated_method = "B389E4EF5B8C08F2EF67D1DD80FF5A3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object parseObject(String string, ParsePosition position) {
        dsTaint.addTaint(position.dsTaint);
        dsTaint.addTaint(string);
        Object var04896F8F24C019F45C9BA249DADA68FE_861211003 = (parse(string, position));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return parse(string, position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.894 -0400", hash_original_method = "6C57FEC8F5EF28EFDF88DCA370317E90", hash_generated_method = "AA6BB190AA25E0EA561D441B0AF8D1A4")
    @DSModeled(DSC.SAFE)
    public void setCalendar(Calendar cal) {
        dsTaint.addTaint(cal.dsTaint);
        // ---------- Original Method ----------
        //calendar = cal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.894 -0400", hash_original_method = "C0CD4ED6DB9107DF0F000BE04B2DBCDB", hash_generated_method = "6D36F7D334A1945B9E4CB25B278EBBF0")
    @DSModeled(DSC.SAFE)
    public void setLenient(boolean value) {
        dsTaint.addTaint(value);
        calendar.setLenient(value);
        // ---------- Original Method ----------
        //calendar.setLenient(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.894 -0400", hash_original_method = "DB316F58F9072942395CFF97FB7F9BCE", hash_generated_method = "71FA02A050C7B5C4CB976EFD847B9325")
    @DSModeled(DSC.SAFE)
    public void setNumberFormat(NumberFormat format) {
        dsTaint.addTaint(format.dsTaint);
        // ---------- Original Method ----------
        //numberFormat = format;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.894 -0400", hash_original_method = "21956223404148B0DA41DA5118D6AFF3", hash_generated_method = "D09CA1BFBF021D42A04330E7183FAD05")
    @DSModeled(DSC.SAFE)
    public void setTimeZone(TimeZone timezone) {
        dsTaint.addTaint(timezone.dsTaint);
        calendar.setTimeZone(timezone);
        // ---------- Original Method ----------
        //calendar.setTimeZone(timezone);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.894 -0400", hash_original_method = "B329E05B5E04B9823F2C9BC2800E30F2", hash_generated_method = "F96F5E5D4172212169AD6F6775E70405")
    private static void checkDateStyle(int style) {
        if (!(style == SHORT || style == MEDIUM || style == LONG
                || style == FULL || style == DEFAULT)) {
            throw new IllegalArgumentException("Illegal date style " + style);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.894 -0400", hash_original_method = "4710581F2B1DA7C66F09FB3530AA4908", hash_generated_method = "ED5F8F55E700B9E0401BFB32DB6908B6")
    private static void checkTimeStyle(int style) {
        if (!(style == SHORT || style == MEDIUM || style == LONG
                || style == FULL || style == DEFAULT)) {
            throw new IllegalArgumentException("Illegal time style " + style);
        }
    }

    
    public static class Field extends Format.Field {
        private static final long serialVersionUID = 7441350119349544720L;
        private static Hashtable<Integer, Field> table = new Hashtable<Integer, Field>();
        public static final Field ERA = new Field("era", Calendar.ERA);
        public static final Field YEAR = new Field("year", Calendar.YEAR);
        public static final Field MONTH = new Field("month", Calendar.MONTH);
        public static final Field HOUR_OF_DAY0 = new Field("hour of day", Calendar.HOUR_OF_DAY);
        public static final Field HOUR_OF_DAY1 = new Field("hour of day 1", -1);
        public static final Field MINUTE = new Field("minute", Calendar.MINUTE);
        public static final Field SECOND = new Field("second", Calendar.SECOND);
        public static final Field MILLISECOND = new Field("millisecond", Calendar.MILLISECOND);
        public static final Field DAY_OF_WEEK = new Field("day of week", Calendar.DAY_OF_WEEK);
        public static final Field DAY_OF_MONTH = new Field("day of month", Calendar.DAY_OF_MONTH);
        public static final Field DAY_OF_YEAR = new Field("day of year", Calendar.DAY_OF_YEAR);
        public static final Field DAY_OF_WEEK_IN_MONTH = new Field("day of week in month",
                Calendar.DAY_OF_WEEK_IN_MONTH);
        public static final Field WEEK_OF_YEAR = new Field("week of year",
                Calendar.WEEK_OF_YEAR);
        public static final Field WEEK_OF_MONTH = new Field("week of month",
                Calendar.WEEK_OF_MONTH);
        public static final Field AM_PM = new Field("am pm", Calendar.AM_PM);
        public static final Field HOUR0 = new Field("hour", Calendar.HOUR);
        public static final Field HOUR1 = new Field("hour 1", -1);
        public static final Field TIME_ZONE = new Field("time zone", -1);
        private int calendarField = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.895 -0400", hash_original_method = "888BC0FB09FD210C46F878EFCBB9BD6C", hash_generated_method = "541AA128FAE6E88B6351FD7422A8D5F0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected Field(String fieldName, int calendarField) {
            super(fieldName);
            dsTaint.addTaint(calendarField);
            dsTaint.addTaint(fieldName);
            {
                boolean var1B0BEC2FE01BC686D6C0F04E5807969E_434913595 = (calendarField != -1 && table.get(Integer.valueOf(calendarField)) == null);
                {
                    table.put(Integer.valueOf(calendarField), this);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //this.calendarField = calendarField;
            //if (calendarField != -1 && table.get(Integer.valueOf(calendarField)) == null) {
                //table.put(Integer.valueOf(calendarField), this);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.895 -0400", hash_original_method = "E3ED29195795ED22C0785EABF4B5C0B6", hash_generated_method = "CDDE8E1B109708DAAEF4E8D75C354893")
        @DSModeled(DSC.SAFE)
        public int getCalendarField() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return calendarField;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.895 -0400", hash_original_method = "633B504F9B95CCF26044905BC967B722", hash_generated_method = "3B9F31E08AC86DBF8BF7A9C1AC9AD042")
        public static Field ofCalendarField(int calendarField) {
            if (calendarField < 0 || calendarField >= Calendar.FIELD_COUNT) {
                throw new IllegalArgumentException();
            }
            return table.get(Integer.valueOf(calendarField));
        }

        
    }


    
}


