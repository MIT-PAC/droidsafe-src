package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    protected Calendar calendar;
    protected NumberFormat numberFormat;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.941 -0400", hash_original_method = "B3EF4E3485D0789C83BAEC35E9E3BAD6", hash_generated_method = "4CEB3B1E67F52104B0EDECB49E396168")
    @DSModeled(DSC.SAFE)
    protected DateFormat() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.941 -0400", hash_original_method = "6214BE37793C3124BC718667B7E0632D", hash_generated_method = "F920B015B8006B14FA57A83F780D7E22")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.941 -0400", hash_original_method = "ACA6119BE57A696CA271FA419EAF8A87", hash_generated_method = "5D96FFE08F7FE7D0168665C6508B3ADF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        DateFormat dateFormat;
        dateFormat = (DateFormat) object;
        boolean var6547837465B05654A33DF377FA19670B_1504541595 = (numberFormat.equals(dateFormat.numberFormat)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.942 -0400", hash_original_method = "B3CAB535AB645340CDBC761CC64061A2", hash_generated_method = "656F7059B81680206EB1DE0AD4387509")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final StringBuffer format(Object object, StringBuffer buffer,
            FieldPosition field) {
        dsTaint.addTaint(field.dsTaint);
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(object.dsTaint);
        {
            StringBuffer varA015649C8CD63FE6E545D2340EECB111_2064587818 = (format((Date) object, buffer, field));
        } //End block
        {
            StringBuffer var64C927786F472344128653963E19764D_344813831 = (format(new Date(((Number) object).longValue()), buffer,
                    field));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.942 -0400", hash_original_method = "2A35FD3F5DCDDD81B439EA4274C41413", hash_generated_method = "72008BD47100358BAF8734C98EFB25A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String format(Date date) {
        dsTaint.addTaint(date.dsTaint);
        String var4EF9B7B8AD61089C39007EB093EDE249_333071518 = (format(date, new StringBuffer(), new FieldPosition(0))
                .toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return format(date, new StringBuffer(), new FieldPosition(0))
                //.toString();
    }

    
    public abstract StringBuffer format(Date date, StringBuffer buffer,
            FieldPosition field);

    
        public static Locale[] getAvailableLocales() {
        return ICU.getAvailableDateFormatLocales();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.942 -0400", hash_original_method = "AC2D491D0E9EF49D1E9DF4E35BBACC3B", hash_generated_method = "051F1B5232EAC093F95D39D81920DEBF")
    @DSModeled(DSC.SAFE)
    public Calendar getCalendar() {
        return (Calendar)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return calendar;
    }

    
        public static final DateFormat getDateInstance() {
        return getDateInstance(DEFAULT);
    }

    
        public static final DateFormat getDateInstance(int style) {
        checkDateStyle(style);
        return getDateInstance(style, Locale.getDefault());
    }

    
        public static final DateFormat getDateInstance(int style, Locale locale) {
        checkDateStyle(style);
        return new SimpleDateFormat(LocaleData.get(locale).getDateFormat(style), locale);
    }

    
        public static final DateFormat getDateTimeInstance() {
        return getDateTimeInstance(DEFAULT, DEFAULT);
    }

    
        public static final DateFormat getDateTimeInstance(int dateStyle, int timeStyle) {
        checkTimeStyle(timeStyle);
        checkDateStyle(dateStyle);
        return getDateTimeInstance(dateStyle, timeStyle, Locale.getDefault());
    }

    
        public static final DateFormat getDateTimeInstance(int dateStyle, int timeStyle, Locale locale) {
        checkTimeStyle(timeStyle);
        checkDateStyle(dateStyle);
        LocaleData localeData = LocaleData.get(locale);
        String pattern = localeData.getDateFormat(dateStyle) + " " + localeData.getTimeFormat(timeStyle);
        return new SimpleDateFormat(pattern, locale);
    }

    
        public static final DateFormat getInstance() {
        return getDateTimeInstance(SHORT, SHORT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.945 -0400", hash_original_method = "303CF4BDA8F6551FE38CF841A2AE86A7", hash_generated_method = "F66552C306839577AE4096B4A876C802")
    @DSModeled(DSC.SAFE)
    public NumberFormat getNumberFormat() {
        return (NumberFormat)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return numberFormat;
    }

    
        public static final DateFormat getTimeInstance() {
        return getTimeInstance(DEFAULT);
    }

    
        public static final DateFormat getTimeInstance(int style) {
        checkTimeStyle(style);
        return getTimeInstance(style, Locale.getDefault());
    }

    
        public static final DateFormat getTimeInstance(int style, Locale locale) {
        checkTimeStyle(style);
        return new SimpleDateFormat(LocaleData.get(locale).getTimeFormat(style), locale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.945 -0400", hash_original_method = "028D1A898568609D223BE7B30E97723B", hash_generated_method = "78C0C6CC6B74EB877ACAC4A1C0065FE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TimeZone getTimeZone() {
        TimeZone varEF3CCBEDCA0E47135FB0142E2055D67D_1463997603 = (calendar.getTimeZone());
        return (TimeZone)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return calendar.getTimeZone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.946 -0400", hash_original_method = "3F46A6ECEE37AE5ECC5364DC5B9940AE", hash_generated_method = "156B37262347B109021F8FE6CB170442")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var00C4C661405C9C662884EAAED3C71D72_980199116 = (calendar.getFirstDayOfWeek()
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.946 -0400", hash_original_method = "C4BF8639B942350BBBDBCDAD05669E72", hash_generated_method = "69A09E146C28E8E6C6D6EE225716B101")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isLenient() {
        boolean varCF550C98B3980A2B47AF4BEE3581E80D_259845009 = (calendar.isLenient());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return calendar.isLenient();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.947 -0400", hash_original_method = "CB060FB8FCF7D6D5A12D02C797F79FD4", hash_generated_method = "A7FBE87F9E4EAF6AC116DF390BBAC5C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Date parse(String string) throws ParseException {
        dsTaint.addTaint(string);
        ParsePosition position;
        position = new ParsePosition(0);
        Date date;
        date = parse(string, position);
        {
            boolean varA01BF4F3DE22A214F5C7EB004E28484E_1920577303 = (position.getIndex() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException("Unparseable date: \"" + string + "\"",
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.947 -0400", hash_original_method = "C9AA8969DE1792F4979FB5B1F65B9849", hash_generated_method = "0066139E6D990569895D58578F24E272")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object parseObject(String string, ParsePosition position) {
        dsTaint.addTaint(position.dsTaint);
        dsTaint.addTaint(string);
        Object var04896F8F24C019F45C9BA249DADA68FE_1927350168 = (parse(string, position));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return parse(string, position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.947 -0400", hash_original_method = "6C57FEC8F5EF28EFDF88DCA370317E90", hash_generated_method = "4FCF1AB24E85D407F7C65920D39AE4D6")
    @DSModeled(DSC.SAFE)
    public void setCalendar(Calendar cal) {
        dsTaint.addTaint(cal.dsTaint);
        // ---------- Original Method ----------
        //calendar = cal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.947 -0400", hash_original_method = "C0CD4ED6DB9107DF0F000BE04B2DBCDB", hash_generated_method = "E4AD7CCD996E4F07405B6E1DB030D460")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLenient(boolean value) {
        dsTaint.addTaint(value);
        calendar.setLenient(value);
        // ---------- Original Method ----------
        //calendar.setLenient(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.948 -0400", hash_original_method = "DB316F58F9072942395CFF97FB7F9BCE", hash_generated_method = "741B58EBC312571D7D4293BDB0098E20")
    @DSModeled(DSC.SAFE)
    public void setNumberFormat(NumberFormat format) {
        dsTaint.addTaint(format.dsTaint);
        // ---------- Original Method ----------
        //numberFormat = format;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.948 -0400", hash_original_method = "21956223404148B0DA41DA5118D6AFF3", hash_generated_method = "B315DB831B84F9AE462B3D65714FCB2F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTimeZone(TimeZone timezone) {
        dsTaint.addTaint(timezone.dsTaint);
        calendar.setTimeZone(timezone);
        // ---------- Original Method ----------
        //calendar.setTimeZone(timezone);
    }

    
        private static void checkDateStyle(int style) {
        if (!(style == SHORT || style == MEDIUM || style == LONG
                || style == FULL || style == DEFAULT)) {
            throw new IllegalArgumentException("Illegal date style " + style);
        }
    }

    
        private static void checkTimeStyle(int style) {
        if (!(style == SHORT || style == MEDIUM || style == LONG
                || style == FULL || style == DEFAULT)) {
            throw new IllegalArgumentException("Illegal time style " + style);
        }
    }

    
    public static class Field extends Format.Field {
        private int calendarField = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.948 -0400", hash_original_method = "888BC0FB09FD210C46F878EFCBB9BD6C", hash_generated_method = "BDED03D5FBCA6BF3D58DA2677E17341B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected Field(String fieldName, int calendarField) {
            super(fieldName);
            dsTaint.addTaint(calendarField);
            dsTaint.addTaint(fieldName);
            {
                boolean var1B0BEC2FE01BC686D6C0F04E5807969E_1665344974 = (calendarField != -1 && table.get(Integer.valueOf(calendarField)) == null);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.948 -0400", hash_original_method = "E3ED29195795ED22C0785EABF4B5C0B6", hash_generated_method = "8EC44D438D7061536A50E6558DE7DE75")
        @DSModeled(DSC.SAFE)
        public int getCalendarField() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return calendarField;
        }

        
                public static Field ofCalendarField(int calendarField) {
            if (calendarField < 0 || calendarField >= Calendar.FIELD_COUNT) {
                throw new IllegalArgumentException();
            }
            return table.get(Integer.valueOf(calendarField));
        }

        
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
    }


    
    private static final long serialVersionUID = 7218322306649953788L;
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
}

