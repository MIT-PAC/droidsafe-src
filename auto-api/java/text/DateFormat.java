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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.727 -0400", hash_original_field = "A0E7B2A565119C0A7EC3126A16016113", hash_generated_field = "69C10C9929AB222710744337F1708515")

    protected Calendar calendar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.727 -0400", hash_original_field = "484976AE104B50C6289AFF253721F20D", hash_generated_field = "212955431FD97B61E8D475C756E3078C")

    protected NumberFormat numberFormat;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.727 -0400", hash_original_method = "B3EF4E3485D0789C83BAEC35E9E3BAD6", hash_generated_method = "4CEB3B1E67F52104B0EDECB49E396168")
    protected  DateFormat() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.728 -0400", hash_original_method = "6214BE37793C3124BC718667B7E0632D", hash_generated_method = "D66A06EEFF73E6E52FFA082F68F15735")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1220196387 = null; //Variable for return #1
        DateFormat clone = (DateFormat) super.clone();
        clone.calendar = (Calendar) calendar.clone();
        clone.numberFormat = (NumberFormat) numberFormat.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1220196387 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_1220196387.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1220196387;
        // ---------- Original Method ----------
        //DateFormat clone = (DateFormat) super.clone();
        //clone.calendar = (Calendar) calendar.clone();
        //clone.numberFormat = (NumberFormat) numberFormat.clone();
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.728 -0400", hash_original_method = "ACA6119BE57A696CA271FA419EAF8A87", hash_generated_method = "33968356490D6878ACA36ED8C853F3FE")
    @Override
    public boolean equals(Object object) {
        DateFormat dateFormat = (DateFormat) object;
        boolean var6547837465B05654A33DF377FA19670B_178715335 = (numberFormat.equals(dateFormat.numberFormat)
                && calendar.getTimeZone().equals(
                        dateFormat.calendar.getTimeZone())
                && calendar.getFirstDayOfWeek() == dateFormat.calendar
                        .getFirstDayOfWeek()
                && calendar.getMinimalDaysInFirstWeek() == dateFormat.calendar
                        .getMinimalDaysInFirstWeek()
                && calendar.isLenient() == dateFormat.calendar.isLenient());
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_633218185 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_633218185;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.729 -0400", hash_original_method = "B3CAB535AB645340CDBC761CC64061A2", hash_generated_method = "C292E6C5884D1EB8B5F5F0239D7C3BCE")
    @Override
    public final StringBuffer format(Object object, StringBuffer buffer,
            FieldPosition field) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1059416546 = null; //Variable for return #1
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_298941476 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1059416546 = format((Date) object, buffer, field);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_298941476 = format(new Date(((Number) object).longValue()), buffer,
                    field);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        addTaint(object.getTaint());
        addTaint(buffer.getTaint());
        addTaint(field.getTaint());
        StringBuffer varA7E53CE21691AB073D9660D615818899_646095104; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_646095104 = varB4EAC82CA7396A68D541C85D26508E83_1059416546;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_646095104 = varB4EAC82CA7396A68D541C85D26508E83_298941476;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_646095104.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_646095104;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.729 -0400", hash_original_method = "2A35FD3F5DCDDD81B439EA4274C41413", hash_generated_method = "DF06AC984B438D26A94E2671159115B0")
    public final String format(Date date) {
        String varB4EAC82CA7396A68D541C85D26508E83_873482182 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_873482182 = format(date, new StringBuffer(), new FieldPosition(0))
                .toString();
        addTaint(date.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_873482182.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_873482182;
        // ---------- Original Method ----------
        //return format(date, new StringBuffer(), new FieldPosition(0))
                //.toString();
    }

    
    public abstract StringBuffer format(Date date, StringBuffer buffer,
            FieldPosition field);

    
    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableDateFormatLocales();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.731 -0400", hash_original_method = "AC2D491D0E9EF49D1E9DF4E35BBACC3B", hash_generated_method = "B13F1499DDE273D4774564DC713E9436")
    public Calendar getCalendar() {
        Calendar varB4EAC82CA7396A68D541C85D26508E83_363760473 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_363760473 = calendar;
        varB4EAC82CA7396A68D541C85D26508E83_363760473.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_363760473;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.732 -0400", hash_original_method = "303CF4BDA8F6551FE38CF841A2AE86A7", hash_generated_method = "D87DB035B2CC2497139387C272C22BD4")
    public NumberFormat getNumberFormat() {
        NumberFormat varB4EAC82CA7396A68D541C85D26508E83_1653557882 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1653557882 = numberFormat;
        varB4EAC82CA7396A68D541C85D26508E83_1653557882.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1653557882;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.733 -0400", hash_original_method = "028D1A898568609D223BE7B30E97723B", hash_generated_method = "0A10CF57D311C8E5E87FF82F1FEBCCE0")
    public TimeZone getTimeZone() {
        TimeZone varB4EAC82CA7396A68D541C85D26508E83_1220867368 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1220867368 = calendar.getTimeZone();
        varB4EAC82CA7396A68D541C85D26508E83_1220867368.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1220867368;
        // ---------- Original Method ----------
        //return calendar.getTimeZone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.733 -0400", hash_original_method = "3F46A6ECEE37AE5ECC5364DC5B9940AE", hash_generated_method = "B73839BA4F798144A8E6DB6AD3C53F11")
    @Override
    public int hashCode() {
        int var00C4C661405C9C662884EAAED3C71D72_142026121 = (calendar.getFirstDayOfWeek()
                + calendar.getMinimalDaysInFirstWeek()
                + calendar.getTimeZone().hashCode()
                + (calendar.isLenient() ? 1231 : 1237)
                + numberFormat.hashCode()); //DSFIXME:  CODE0008: Nested ternary operator in expression
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2061425101 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2061425101;
        // ---------- Original Method ----------
        //return calendar.getFirstDayOfWeek()
                //+ calendar.getMinimalDaysInFirstWeek()
                //+ calendar.getTimeZone().hashCode()
                //+ (calendar.isLenient() ? 1231 : 1237)
                //+ numberFormat.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.734 -0400", hash_original_method = "C4BF8639B942350BBBDBCDAD05669E72", hash_generated_method = "EE2E782BA5A5011EE9B2AAEDA1C9C20D")
    public boolean isLenient() {
        boolean varCF550C98B3980A2B47AF4BEE3581E80D_915706896 = (calendar.isLenient());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1412391603 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1412391603;
        // ---------- Original Method ----------
        //return calendar.isLenient();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.734 -0400", hash_original_method = "CB060FB8FCF7D6D5A12D02C797F79FD4", hash_generated_method = "D58A894A12B5B098A3DAF48AA87976EC")
    public Date parse(String string) throws ParseException {
        Date varB4EAC82CA7396A68D541C85D26508E83_695415406 = null; //Variable for return #1
        ParsePosition position = new ParsePosition(0);
        Date date = parse(string, position);
        {
            boolean varA01BF4F3DE22A214F5C7EB004E28484E_1007634512 = (position.getIndex() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException("Unparseable date: \"" + string + "\"",
                    position.getErrorIndex());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_695415406 = date;
        addTaint(string.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_695415406.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_695415406;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.735 -0400", hash_original_method = "C9AA8969DE1792F4979FB5B1F65B9849", hash_generated_method = "BF97C718982B3A33A81D1DBE246DB2BE")
    @Override
    public Object parseObject(String string, ParsePosition position) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1970480606 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1970480606 = parse(string, position);
        addTaint(string.getTaint());
        addTaint(position.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1970480606.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1970480606;
        // ---------- Original Method ----------
        //return parse(string, position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.735 -0400", hash_original_method = "6C57FEC8F5EF28EFDF88DCA370317E90", hash_generated_method = "E802D086EAB4F0F67AA7535AB9302E52")
    public void setCalendar(Calendar cal) {
        calendar = cal;
        // ---------- Original Method ----------
        //calendar = cal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.735 -0400", hash_original_method = "C0CD4ED6DB9107DF0F000BE04B2DBCDB", hash_generated_method = "04206A48739095B73E63A4DD062B9C28")
    public void setLenient(boolean value) {
        calendar.setLenient(value);
        addTaint(value);
        // ---------- Original Method ----------
        //calendar.setLenient(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.735 -0400", hash_original_method = "DB316F58F9072942395CFF97FB7F9BCE", hash_generated_method = "16CBA8285F39434CB2D8444A821C6283")
    public void setNumberFormat(NumberFormat format) {
        numberFormat = format;
        // ---------- Original Method ----------
        //numberFormat = format;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.736 -0400", hash_original_method = "21956223404148B0DA41DA5118D6AFF3", hash_generated_method = "84D7DD06357FBDCE6F5A19BCE98E7A9A")
    public void setTimeZone(TimeZone timezone) {
        calendar.setTimeZone(timezone);
        addTaint(timezone.getTaint());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.736 -0400", hash_original_field = "DBF8DA4BD493741C0BD0CC3DBBB3A151", hash_generated_field = "6C8210CAC0A721846CF9DEC872095DCC")

        private int calendarField = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.736 -0400", hash_original_method = "888BC0FB09FD210C46F878EFCBB9BD6C", hash_generated_method = "216663502EAED3C32FBACD33330C656A")
        protected  Field(String fieldName, int calendarField) {
            super(fieldName);
            this.calendarField = calendarField;
            {
                boolean var1B0BEC2FE01BC686D6C0F04E5807969E_825074855 = (calendarField != -1 && table.get(Integer.valueOf(calendarField)) == null);
                {
                    table.put(Integer.valueOf(calendarField), this);
                } //End block
            } //End collapsed parenthetic
            addTaint(fieldName.getTaint());
            // ---------- Original Method ----------
            //this.calendarField = calendarField;
            //if (calendarField != -1 && table.get(Integer.valueOf(calendarField)) == null) {
                //table.put(Integer.valueOf(calendarField), this);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.736 -0400", hash_original_method = "E3ED29195795ED22C0785EABF4B5C0B6", hash_generated_method = "37E09C8313D739BA6F3CE7CE35631332")
        public int getCalendarField() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_42745566 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_42745566;
            // ---------- Original Method ----------
            //return calendarField;
        }

        
        public static Field ofCalendarField(int calendarField) {
            if (calendarField < 0 || calendarField >= Calendar.FIELD_COUNT) {
                throw new IllegalArgumentException();
            }
            return table.get(Integer.valueOf(calendarField));
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "2D4C79F819117351AD0BBEF40375938A", hash_generated_field = "1D13173B04DB328F0B582E6E67347BD1")

        private static final long serialVersionUID = 7441350119349544720L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "2C6C6886DC87115854BBBE95999B5929", hash_generated_field = "314E7CADFD609ED986410B07259D6A40")

        private static Hashtable<Integer, Field> table = new Hashtable<Integer, Field>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "D32ABCBADC9FBF1B70B5C6B99C50BA1E", hash_generated_field = "1ABC5D4C99C93DBFEB91C8AADB60D48C")

        public static final Field ERA = new Field("era", Calendar.ERA);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "6A903AC6DB9E9113CD371896A78D1544", hash_generated_field = "A107E2D089FA1EF60AB4A2FEA680C8E6")

        public static final Field YEAR = new Field("year", Calendar.YEAR);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "EE5BB4751D1EAE51A261AFF61643CF91", hash_generated_field = "EBC91A889ECBB933A509717D7AECA5AF")

        public static final Field MONTH = new Field("month", Calendar.MONTH);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "1F0FDCCD9A3D14C1C8013ED512F17495", hash_generated_field = "320CDD7535CD82D0158F2C07003E41F0")

        public static final Field HOUR_OF_DAY0 = new Field("hour of day", Calendar.HOUR_OF_DAY);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "1A09DC69CA7BF5DEF62A4F896D9E5D7D", hash_generated_field = "822815034939B64F8339B9750A02222D")

        public static final Field HOUR_OF_DAY1 = new Field("hour of day 1", -1);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "C5B7A6BF3346930C5E72ABFC130C0C07", hash_generated_field = "80C2E50A31A497D1527533C0F969AD7F")

        public static final Field MINUTE = new Field("minute", Calendar.MINUTE);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "7F1B4A780F5FD44920D2F09F92F1D0D2", hash_generated_field = "958B8B727708190A075287581AC42054")

        public static final Field SECOND = new Field("second", Calendar.SECOND);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "9A6AFF52270B1BEE6BEB9C5DBEEDD37D", hash_generated_field = "08B6B3F5E7A807A67E9296F4DDFD9438")

        public static final Field MILLISECOND = new Field("millisecond", Calendar.MILLISECOND);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "A0E7E01E83670461A7A1DEB0117E9146", hash_generated_field = "C6D4E2A5BD668072EBC43776C1425516")

        public static final Field DAY_OF_WEEK = new Field("day of week", Calendar.DAY_OF_WEEK);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "72CA73E78C20B32C0DCA306EABC85693", hash_generated_field = "D4C001726306DDB365F9A280F69E9ABD")

        public static final Field DAY_OF_MONTH = new Field("day of month", Calendar.DAY_OF_MONTH);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "0040C70E517585C1C04A731B0B87294F", hash_generated_field = "4C0FAA57A9A738AA51ED50B046A75486")

        public static final Field DAY_OF_YEAR = new Field("day of year", Calendar.DAY_OF_YEAR);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "D3C856A391E361C8D34FE0EFC626F669", hash_generated_field = "E0DFB10679A270FA7B3E2BC2489A26A2")

        public static final Field DAY_OF_WEEK_IN_MONTH = new Field("day of week in month",
                Calendar.DAY_OF_WEEK_IN_MONTH);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "6CA24BD89018C51716388F9A71C2DE0F", hash_generated_field = "70A95005BF5B7350C85CF5D67483CD83")

        public static final Field WEEK_OF_YEAR = new Field("week of year",
                Calendar.WEEK_OF_YEAR);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "F268817ED495CB257093B0F8D54999A7", hash_generated_field = "2B74FA99831753B112A020D8AB02260B")

        public static final Field WEEK_OF_MONTH = new Field("week of month",
                Calendar.WEEK_OF_MONTH);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "1CC78C5AB025F701750D9838DDEA97A0", hash_generated_field = "4221BDFEE65C1C5EF3D94A11561C35AE")

        public static final Field AM_PM = new Field("am pm", Calendar.AM_PM);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "DB86B69F2F960F6F66B0B5704691B4D4", hash_generated_field = "3B5DC0A6880AEDA967CCE2D22562C1EB")

        public static final Field HOUR0 = new Field("hour", Calendar.HOUR);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "A4AFB3E4868C9D44236962A8DB14AD51", hash_generated_field = "84B9176C5910072DEBC7691A9A4ED8AA")

        public static final Field HOUR1 = new Field("hour 1", -1);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "F19E34DA8C05CE90B563DDCEDB834357", hash_generated_field = "B6C96AF85706A7CE7EFA469F8ACAFD67")

        public static final Field TIME_ZONE = new Field("time zone", -1);
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "688E1C6A008070BFA345E7A6028913EC", hash_generated_field = "AEAB9195175D475D5D3748DEE868C0A6")

    private static final long serialVersionUID = 7218322306649953788L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "DC4FC8AEAB8674DD8AE8E2463EDA3BBA", hash_generated_field = "2B49C232BC4EF47D298ED64FBB983234")

    public static final int DEFAULT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "25E5BBB9F4EADE59D20310641ADCE543", hash_generated_field = "106A81E4B9F6A40487011085AD6AE99A")

    public static final int FULL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "3BAE48DEAAE333CB107BC1132F4F4146", hash_generated_field = "F5FF9843F59090FE170F992D775343D2")

    public static final int LONG = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "237853F02935F95EDDCA4129BDFF3F2D", hash_generated_field = "3DC8393EEFC142D68E10B0A1C6F109DB")

    public static final int MEDIUM = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "175308D2FBF3B761DF0108367B225AD1", hash_generated_field = "BD2F58D1B62968CF2B681918725A7107")

    public static final int SHORT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "60AE66E274A6599EC125ED88E92FF030", hash_generated_field = "365A0A362471A59BA76EBA2059A29C49")

    public static final int ERA_FIELD = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "BE2929062F9CD7575C04425BF19EBDE5", hash_generated_field = "8D088B7424FC85DCD98E414D6F78627B")

    public static final int YEAR_FIELD = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "5FAC2F6A17976407B6E8D0A93240EC7B", hash_generated_field = "B7407A3AB6C00B5BFE0894F2E28B83F0")

    public static final int MONTH_FIELD = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "EBB8ACA85754B7687736A9BF840DCC4B", hash_generated_field = "C72906A9F3F4A76EFE0F2A022B718E2D")

    public static final int DATE_FIELD = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "5765A46C5DC08D1FC6A278F067B18F41", hash_generated_field = "BF29B257CDC5515FB8DD982622A87E47")

    public static final int HOUR_OF_DAY1_FIELD = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "31E5A7664C2CFD5062E05A60E9A7E0A5", hash_generated_field = "4EBCEA05E564734384E349AACF574704")

    public static final int HOUR_OF_DAY0_FIELD = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.737 -0400", hash_original_field = "1F84CD36C479ED6E34C207E3F0E61451", hash_generated_field = "51A085672F71693D54EB09846A0977DC")

    public static final int MINUTE_FIELD = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.738 -0400", hash_original_field = "422681AB9A2BC4597704731C6C404E2C", hash_generated_field = "EE99171CAA63925B099FCF44CFACE405")

    public static final int SECOND_FIELD = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.738 -0400", hash_original_field = "E8B6E22EB55D0E104BC1B91CA7AA9A69", hash_generated_field = "32165551CCE1FCF8FA44FCEB2DE56361")

    public static final int MILLISECOND_FIELD = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.738 -0400", hash_original_field = "882E6379DC5B0AC5632D618BAE568C73", hash_generated_field = "523FAFFEB1013AA503CBADAD7000AD40")

    public static final int DAY_OF_WEEK_FIELD = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.738 -0400", hash_original_field = "B312D71CB7647D22AE50FBEA77CEB858", hash_generated_field = "A95BC2102C8607CED53A0575A6666797")

    public static final int DAY_OF_YEAR_FIELD = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.738 -0400", hash_original_field = "C241F4641B6AE0AAA8284A4EA33A37B3", hash_generated_field = "E56CB5AA16632139DBC6DA52F0351A91")

    public static final int DAY_OF_WEEK_IN_MONTH_FIELD = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.738 -0400", hash_original_field = "F23C1BAA5F94C567CAB28EA062B315AA", hash_generated_field = "44EDF7554E9ECC472942AA2FD4DC76F6")

    public static final int WEEK_OF_YEAR_FIELD = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.738 -0400", hash_original_field = "D9DB45563DBC8B7D7B99F1003598BE9A", hash_generated_field = "A7EDBC4832D76350B823AF51773A9332")

    public static final int WEEK_OF_MONTH_FIELD = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.738 -0400", hash_original_field = "257C6336A0AD264A0991FF46E54436C4", hash_generated_field = "BCD3E110D56485D2FA7DBADE0019EADA")

    public static final int AM_PM_FIELD = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.738 -0400", hash_original_field = "CC463103CFDD6ABE13893A4B54C9219C", hash_generated_field = "B97B3472BC6A81EB72CA23E982E6503B")

    public static final int HOUR1_FIELD = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.738 -0400", hash_original_field = "89E71309A8C293FB413DF1EB243749FF", hash_generated_field = "1BD56D865050E358A588DCF704750655")

    public static final int HOUR0_FIELD = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.738 -0400", hash_original_field = "22A989A46297875226F9093C8993B30F", hash_generated_field = "1D005DFF3ECBE087534BA0E900C3C957")

    public static final int TIMEZONE_FIELD = 17;
}

