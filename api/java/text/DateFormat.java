package java.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Locale;
import java.util.TimeZone;

import libcore.icu.ICU;
import libcore.icu.LocaleData;





public abstract class DateFormat extends Format {

    /**
     * Returns an array of locales for which custom {@code DateFormat} instances
     * are available.
     * <p>Note that Android does not support user-supplied locale service providers.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.738 -0500", hash_original_method = "EC1C9549160E2BC66E11F9DDB4B8FBD0", hash_generated_method = "8D491F66EE876E7A6F3079E4FA395FD6")
    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableDateFormatLocales();
    }

    /**
     * Returns a {@code DateFormat} instance for formatting and parsing dates in
     * the DEFAULT style for the default locale.
     *
     * @return the {@code DateFormat} instance for the default style and locale.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.740 -0500", hash_original_method = "492FD3DDCD551887FA928B87F9CDC015", hash_generated_method = "1584BAADDCCEE1FD6566ABD02B67F340")
    public static final DateFormat getDateInstance() {
        return getDateInstance(DEFAULT);
    }

    /**
     * Returns a {@code DateFormat} instance for formatting and parsing dates in
     * the specified style for the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     * @param style
     *            one of SHORT, MEDIUM, LONG, FULL, or DEFAULT.
     * @return the {@code DateFormat} instance for {@code style} and the default
     *         locale.
     * @throws IllegalArgumentException
     *             if {@code style} is not one of SHORT, MEDIUM, LONG, FULL, or
     *             DEFAULT.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.741 -0500", hash_original_method = "E9C515926F59D15FF7CB88B0B60D9C22", hash_generated_method = "AA5C2AC1481A266A9A2F2128C5031964")
    public static final DateFormat getDateInstance(int style) {
        checkDateStyle(style);
        return getDateInstance(style, Locale.getDefault());
    }

    /**
     * Returns a {@code DateFormat} instance for formatting and parsing dates in
     * the specified style for the specified locale.
     *
     * @param style
     *            one of SHORT, MEDIUM, LONG, FULL, or DEFAULT.
     * @param locale
     *            the locale.
     * @throws IllegalArgumentException
     *             if {@code style} is not one of SHORT, MEDIUM, LONG, FULL, or
     *             DEFAULT.
     * @return the {@code DateFormat} instance for {@code style} and
     *         {@code locale}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.742 -0500", hash_original_method = "2C09A4D27D27084B3D92D338508BC4B1", hash_generated_method = "0A3BDC25EFBB4AF2B4D924801B40054C")
    public static final DateFormat getDateInstance(int style, Locale locale) {
        checkDateStyle(style);
        return new SimpleDateFormat(LocaleData.get(locale).getDateFormat(style), locale);
    }

    /**
     * Returns a {@code DateFormat} instance for formatting and parsing dates
     * and time values in the DEFAULT style for the default locale.
     *
     * @return the {@code DateFormat} instance for the default style and locale.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.743 -0500", hash_original_method = "83705E0AAFF633A246DC83A01D518F12", hash_generated_method = "E8401EC0A796A90AF72EB9263851C999")
    public static final DateFormat getDateTimeInstance() {
        return getDateTimeInstance(DEFAULT, DEFAULT);
    }

    /**
     * Returns a {@code DateFormat} instance for formatting and parsing of both
     * dates and time values in the manner appropriate for the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     * @param dateStyle
     *            one of SHORT, MEDIUM, LONG, FULL, or DEFAULT.
     * @param timeStyle
     *            one of SHORT, MEDIUM, LONG, FULL, or DEFAULT.
     * @return the {@code DateFormat} instance for {@code dateStyle},
     *         {@code timeStyle} and the default locale.
     * @throws IllegalArgumentException
     *             if {@code dateStyle} or {@code timeStyle} is not one of
     *             SHORT, MEDIUM, LONG, FULL, or DEFAULT.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.744 -0500", hash_original_method = "A7E6AB35D13132D438F9DCCBC72BE606", hash_generated_method = "3900BD34F97E39BD1CA09511756D47FF")
    public static final DateFormat getDateTimeInstance(int dateStyle, int timeStyle) {
        checkTimeStyle(timeStyle);
        checkDateStyle(dateStyle);
        return getDateTimeInstance(dateStyle, timeStyle, Locale.getDefault());
    }

    /**
     * Returns a {@code DateFormat} instance for formatting and parsing dates
     * and time values in the specified styles for the specified locale.
     *
     * @param dateStyle
     *            one of SHORT, MEDIUM, LONG, FULL, or DEFAULT.
     * @param timeStyle
     *            one of SHORT, MEDIUM, LONG, FULL, or DEFAULT.
     * @param locale
     *            the locale.
     * @return the {@code DateFormat} instance for {@code dateStyle},
     *         {@code timeStyle} and {@code locale}.
     * @throws IllegalArgumentException
     *             if {@code dateStyle} or {@code timeStyle} is not one of
     *             SHORT, MEDIUM, LONG, FULL, or DEFAULT.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.745 -0500", hash_original_method = "2285EB3463305C879C637226A064045A", hash_generated_method = "FF7CBCCFC8E13A430AD369002279FC0F")
    public static final DateFormat getDateTimeInstance(int dateStyle, int timeStyle, Locale locale) {
        checkTimeStyle(timeStyle);
        checkDateStyle(dateStyle);
        LocaleData localeData = LocaleData.get(locale);
        String pattern = localeData.getDateFormat(dateStyle) + " " + localeData.getTimeFormat(timeStyle);
        return new SimpleDateFormat(pattern, locale);
    }

    /**
     * Returns a {@code DateFormat} instance for formatting and parsing dates
     * and times in the SHORT style for the default locale.
     *
     * @return the {@code DateFormat} instance for the SHORT style and default
     *         locale.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.746 -0500", hash_original_method = "328D72CCC3CD1DC2B99E83C7AF31E8C0", hash_generated_method = "125F5E29A0A8C131F8DEC3BC1D902C43")
    public static final DateFormat getInstance() {
        return getDateTimeInstance(SHORT, SHORT);
    }

    /**
     * Returns a {@code DateFormat} instance for formatting and parsing time
     * values in the DEFAULT style for the default locale.
     *
     * @return the {@code DateFormat} instance for the default style and locale.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.748 -0500", hash_original_method = "90581B7473F3E36379FBAEEBE90EB2FE", hash_generated_method = "5D6C0507FCEE4BAF6C384DE19C749A51")
    public static final DateFormat getTimeInstance() {
        return getTimeInstance(DEFAULT);
    }

    /**
     * Returns a {@code DateFormat} instance for formatting and parsing time
     * values in the specified style for the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     * @param style
     *            one of SHORT, MEDIUM, LONG, FULL, or DEFAULT.
     * @return the {@code DateFormat} instance for {@code style} and the default
     *         locale.
     * @throws IllegalArgumentException
     *             if {@code style} is not one of SHORT, MEDIUM, LONG, FULL, or
     *             DEFAULT.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.749 -0500", hash_original_method = "F938DFCF67BFE83189AB8EEA5DA2BD42", hash_generated_method = "30A9FE09077139894689C40593A1B38B")
    public static final DateFormat getTimeInstance(int style) {
        checkTimeStyle(style);
        return getTimeInstance(style, Locale.getDefault());
    }

    /**
     * Returns a {@code DateFormat} instance for formatting and parsing time
     * values in the specified style for the specified locale.
     *
     * @param style
     *            one of SHORT, MEDIUM, LONG, FULL, or DEFAULT.
     * @param locale
     *            the locale.
     * @throws IllegalArgumentException
     *             if {@code style} is not one of SHORT, MEDIUM, LONG, FULL, or
     *             DEFAULT.
     * @return the {@code DateFormat} instance for {@code style} and
     *         {@code locale}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.750 -0500", hash_original_method = "694861B989ADA6B38BBA026408A73346", hash_generated_method = "0458389C40354284B85DBE0DD3EC5238")
    public static final DateFormat getTimeInstance(int style, Locale locale) {
        checkTimeStyle(style);
        return new SimpleDateFormat(LocaleData.get(locale).getTimeFormat(style), locale);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.786 -0500", hash_original_method = "B329E05B5E04B9823F2C9BC2800E30F2", hash_generated_method = "F96F5E5D4172212169AD6F6775E70405")
    private static void checkDateStyle(int style) {
        if (!(style == SHORT || style == MEDIUM || style == LONG
                || style == FULL || style == DEFAULT)) {
            throw new IllegalArgumentException("Illegal date style " + style);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.787 -0500", hash_original_method = "4710581F2B1DA7C66F09FB3530AA4908", hash_generated_method = "ED5F8F55E700B9E0401BFB32DB6908B6")
    private static void checkTimeStyle(int style) {
        if (!(style == SHORT || style == MEDIUM || style == LONG
                || style == FULL || style == DEFAULT)) {
            throw new IllegalArgumentException("Illegal time style " + style);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.703 -0500", hash_original_field = "C72F49E2EAC6CD60C0BECB525FDA777D", hash_generated_field = "AEAB9195175D475D5D3748DEE868C0A6")


    private static final long serialVersionUID = 7218322306649953788L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.706 -0500", hash_original_field = "43E6EB368450F9D826E5B6A71A7E402C", hash_generated_field = "2B49C232BC4EF47D298ED64FBB983234")

    public static final int DEFAULT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.707 -0500", hash_original_field = "AB87BA4BE42391E3E3CE27CFBF62DED0", hash_generated_field = "106A81E4B9F6A40487011085AD6AE99A")

    public static final int FULL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.708 -0500", hash_original_field = "3D5440EC1B7415979D6644BCDD15B434", hash_generated_field = "F5FF9843F59090FE170F992D775343D2")

    public static final int LONG = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.709 -0500", hash_original_field = "C5D174FD7A3EEAD91FA3F11152690396", hash_generated_field = "3DC8393EEFC142D68E10B0A1C6F109DB")

    public static final int MEDIUM = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.709 -0500", hash_original_field = "7BF049E805FA8C19C73CED1A14410777", hash_generated_field = "BD2F58D1B62968CF2B681918725A7107")

    public static final int SHORT = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.711 -0500", hash_original_field = "57E1D6F1510233C6706A8567569CFE99", hash_generated_field = "365A0A362471A59BA76EBA2059A29C49")

    public static final int ERA_FIELD = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.712 -0500", hash_original_field = "583FD150E58A3DFDCF9E62E21BC1A46A", hash_generated_field = "8D088B7424FC85DCD98E414D6F78627B")

    public static final int YEAR_FIELD = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.713 -0500", hash_original_field = "1A403175051E35AEAD83C5543E0EBE6A", hash_generated_field = "B7407A3AB6C00B5BFE0894F2E28B83F0")

    public static final int MONTH_FIELD = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.714 -0500", hash_original_field = "15643A0E3F0FD3B96E7E6BDF5DD506F5", hash_generated_field = "C72906A9F3F4A76EFE0F2A022B718E2D")

    public static final int DATE_FIELD = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.714 -0500", hash_original_field = "388F46B599E6F8AB6410A52D1C609C7E", hash_generated_field = "BF29B257CDC5515FB8DD982622A87E47")

    public static final int HOUR_OF_DAY1_FIELD = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.715 -0500", hash_original_field = "A6799A0CA49A527C3A319428807292D4", hash_generated_field = "4EBCEA05E564734384E349AACF574704")

    public static final int HOUR_OF_DAY0_FIELD = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.716 -0500", hash_original_field = "CE369E80AE2C4AD11434B472DA2C41A7", hash_generated_field = "51A085672F71693D54EB09846A0977DC")

    public static final int MINUTE_FIELD = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.717 -0500", hash_original_field = "80BCB78E4B78D8583B345315D76C7920", hash_generated_field = "EE99171CAA63925B099FCF44CFACE405")

    public static final int SECOND_FIELD = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.718 -0500", hash_original_field = "A6826D2E6C5BD9F692A32CE741F833C7", hash_generated_field = "32165551CCE1FCF8FA44FCEB2DE56361")

    public static final int MILLISECOND_FIELD = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.719 -0500", hash_original_field = "89414870CC2625752066A4F2F1D44BF1", hash_generated_field = "523FAFFEB1013AA503CBADAD7000AD40")

    public static final int DAY_OF_WEEK_FIELD = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.720 -0500", hash_original_field = "0B6FC87C63BBA5A42B472F4C4EF9E01C", hash_generated_field = "A95BC2102C8607CED53A0575A6666797")

    public static final int DAY_OF_YEAR_FIELD = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.721 -0500", hash_original_field = "ACD091AC402EEFF6005BA0FBF8ED9C8A", hash_generated_field = "E56CB5AA16632139DBC6DA52F0351A91")

    public static final int DAY_OF_WEEK_IN_MONTH_FIELD = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.722 -0500", hash_original_field = "F9C9C7E2CFBCE3F9A05053999AE3D300", hash_generated_field = "44EDF7554E9ECC472942AA2FD4DC76F6")

    public static final int WEEK_OF_YEAR_FIELD = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.727 -0500", hash_original_field = "5FA0AB6D53CC2911F1569A8FC4192DB5", hash_generated_field = "A7EDBC4832D76350B823AF51773A9332")

    public static final int WEEK_OF_MONTH_FIELD = 13;

    
    public static class Field extends Format.Field {

        /**
         * Returns the {@code DateFormat.Field} instance for the given calendar
         * field.
         *
         * @param calendarField
         *            a calendar field constant.
         * @return the {@code DateFormat.Field} corresponding to
         *         {@code calendarField}.
         * @throws IllegalArgumentException
         *             if {@code calendarField} is negative or greater than the
         *             field count of {@code Calendar}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.784 -0500", hash_original_method = "633B504F9B95CCF26044905BC967B722", hash_generated_method = "3B9F31E08AC86DBF8BF7A9C1AC9AD042")
        public static Field ofCalendarField(int calendarField) {
            if (calendarField < 0 || calendarField >= Calendar.FIELD_COUNT) {
                throw new IllegalArgumentException();
            }

            return table.get(Integer.valueOf(calendarField));
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.761 -0500", hash_original_field = "B1C9975224CA0CC58869567B36A249AA", hash_generated_field = "1D13173B04DB328F0B582E6E67347BD1")


        private static final long serialVersionUID = 7441350119349544720L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.762 -0500", hash_original_field = "0F1A76081B8229E3B0746E0D5A816278", hash_generated_field = "314E7CADFD609ED986410B07259D6A40")


        private static Hashtable<Integer, Field> table = new Hashtable<Integer, Field>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.763 -0500", hash_original_field = "29AAEC0F78F4DC06FD249C597476D118", hash_generated_field = "1ABC5D4C99C93DBFEB91C8AADB60D48C")

        public static final Field ERA = new Field("era", Calendar.ERA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.764 -0500", hash_original_field = "5359AD3B82F0FDEDD7F883EB5FCA5CC9", hash_generated_field = "A107E2D089FA1EF60AB4A2FEA680C8E6")

        public static final Field YEAR = new Field("year", Calendar.YEAR);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.765 -0500", hash_original_field = "DDD8A223DADA96AE058316FAA55AAAC7", hash_generated_field = "EBC91A889ECBB933A509717D7AECA5AF")

        public static final Field MONTH = new Field("month", Calendar.MONTH);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.766 -0500", hash_original_field = "46C97BD2F91590288AB59E9F1F05BA6F", hash_generated_field = "320CDD7535CD82D0158F2C07003E41F0")

        public static final Field HOUR_OF_DAY0 = new Field("hour of day", Calendar.HOUR_OF_DAY);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.767 -0500", hash_original_field = "37503DD82BE43BE2D7EFBA9FFD64DF6D", hash_generated_field = "822815034939B64F8339B9750A02222D")

        public static final Field HOUR_OF_DAY1 = new Field("hour of day 1", -1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.768 -0500", hash_original_field = "02D0172007C51C2CA519D12A12B467E7", hash_generated_field = "80C2E50A31A497D1527533C0F969AD7F")

        public static final Field MINUTE = new Field("minute", Calendar.MINUTE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.768 -0500", hash_original_field = "ED182168D7272E7D94A50ABDE4E84E76", hash_generated_field = "958B8B727708190A075287581AC42054")

        public static final Field SECOND = new Field("second", Calendar.SECOND);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.770 -0500", hash_original_field = "F01515C274004D1CBA62FAEC9280B8A7", hash_generated_field = "08B6B3F5E7A807A67E9296F4DDFD9438")

        public static final Field MILLISECOND = new Field("millisecond", Calendar.MILLISECOND);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.771 -0500", hash_original_field = "146AB3F27F6E24FB0DE16B423EFFDED6", hash_generated_field = "C6D4E2A5BD668072EBC43776C1425516")

        public static final Field DAY_OF_WEEK = new Field("day of week", Calendar.DAY_OF_WEEK);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.772 -0500", hash_original_field = "65D19E222EE8BA86FD46D9E6127BC897", hash_generated_field = "D4C001726306DDB365F9A280F69E9ABD")

        public static final Field DAY_OF_MONTH = new Field("day of month", Calendar.DAY_OF_MONTH);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.773 -0500", hash_original_field = "C16CF164260E6DD79270F746AD68EF8A", hash_generated_field = "4C0FAA57A9A738AA51ED50B046A75486")

        public static final Field DAY_OF_YEAR = new Field("day of year", Calendar.DAY_OF_YEAR);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.774 -0500", hash_original_field = "7A1480DA070C1052197C8B5B9DF46267", hash_generated_field = "E0DFB10679A270FA7B3E2BC2489A26A2")

        public static final Field DAY_OF_WEEK_IN_MONTH = new Field("day of week in month",
                Calendar.DAY_OF_WEEK_IN_MONTH);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.775 -0500", hash_original_field = "7DF925DD7743FCBE50D290C34E093AF0", hash_generated_field = "70A95005BF5B7350C85CF5D67483CD83")

        public static final Field WEEK_OF_YEAR = new Field("week of year",
                Calendar.WEEK_OF_YEAR);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.776 -0500", hash_original_field = "D8ED481AEA29512A56CC8FBEDF3005E6", hash_generated_field = "2B74FA99831753B112A020D8AB02260B")

        public static final Field WEEK_OF_MONTH = new Field("week of month",
                Calendar.WEEK_OF_MONTH);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.777 -0500", hash_original_field = "6CFA1F2EF409E3D9E80C44BAEEBE5A59", hash_generated_field = "4221BDFEE65C1C5EF3D94A11561C35AE")

        public static final Field AM_PM = new Field("am pm", Calendar.AM_PM);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.778 -0500", hash_original_field = "4ED1D3DAFCDF5E6765C61EE8C2B57621", hash_generated_field = "3B5DC0A6880AEDA967CCE2D22562C1EB")

        public static final Field HOUR0 = new Field("hour", Calendar.HOUR);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.779 -0500", hash_original_field = "61D4686FFA83D8ADE9E3DAD9525C2703", hash_generated_field = "84B9176C5910072DEBC7691A9A4ED8AA")

        public static final Field HOUR1 = new Field("hour 1", -1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.780 -0500", hash_original_field = "60FD50AD8B36BFE6C92D7CDE9721016F", hash_generated_field = "B6C96AF85706A7CE7EFA469F8ACAFD67")

        public static final Field TIME_ZONE = new Field("time zone", -1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.781 -0500", hash_original_field = "AFF0149F7D3F7F2E7A12DD67CBD612CC", hash_generated_field = "6C8210CAC0A721846CF9DEC872095DCC")

        private int calendarField = -1;

        /**
         * Constructs a new instance of {@code DateFormat.Field} with the given
         * fieldName and calendar field.
         *
         * @param fieldName
         *            the field name.
         * @param calendarField
         *            the calendar field type of the field.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.782 -0500", hash_original_method = "888BC0FB09FD210C46F878EFCBB9BD6C", hash_generated_method = "886EF00D7FC8756F8800680F6ABF3E4D")
        protected Field(String fieldName, int calendarField) {
            super(fieldName);
            this.calendarField = calendarField;
            if (calendarField != -1 && table.get(Integer.valueOf(calendarField)) == null) {
                table.put(Integer.valueOf(calendarField), this);
            }
        }

        /**
         * Returns the Calendar field that this field represents.
         *
         * @return the calendar field.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.783 -0500", hash_original_method = "E3ED29195795ED22C0785EABF4B5C0B6", hash_generated_method = "09B3065D77A2BC8013ABE980F0608FFA")
        public int getCalendarField() {
            return calendarField;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.728 -0500", hash_original_field = "071D91C69554D4DB86165994435C7FB4", hash_generated_field = "BCD3E110D56485D2FA7DBADE0019EADA")

    public static final int AM_PM_FIELD = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.729 -0500", hash_original_field = "3FDEF5206443D7A5611DABB89A7D60D5", hash_generated_field = "B97B3472BC6A81EB72CA23E982E6503B")

    public static final int HOUR1_FIELD = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.730 -0500", hash_original_field = "3D43060CECAE0BAE059DE880B8E8E700", hash_generated_field = "1BD56D865050E358A588DCF704750655")

    public static final int HOUR0_FIELD = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.732 -0500", hash_original_field = "66EF17F55978EAB12A515210871FF98D", hash_generated_field = "1D005DFF3ECBE087534BA0E900C3C957")

    public static final int TIMEZONE_FIELD = 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.704 -0500", hash_original_field = "1FBDCBF1EBCF702B875F63B227467209", hash_generated_field = "69C10C9929AB222710744337F1708515")

    protected Calendar calendar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.705 -0500", hash_original_field = "ABF79D8239C1722FE0013AA65D534FB5", hash_generated_field = "212955431FD97B61E8D475C756E3078C")

    protected NumberFormat numberFormat;

    /**
     * Constructs a new instance of {@code DateFormat}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.733 -0500", hash_original_method = "B3EF4E3485D0789C83BAEC35E9E3BAD6", hash_generated_method = "10A1B52A5CA8C2A4D9F86E0EA9A1EFD8")
    protected DateFormat() {
    }

    /**
     * Returns a new instance of {@code DateFormat} with the same properties.
     *
     * @return a shallow copy of this {@code DateFormat}.
     *
     * @see java.lang.Cloneable
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.733 -0500", hash_original_method = "6214BE37793C3124BC718667B7E0632D", hash_generated_method = "FB7C835B38BFFC419A3B0A3A2A027A83")
    @Override
public Object clone() {
        DateFormat clone = (DateFormat) super.clone();
        clone.calendar = (Calendar) calendar.clone();
        clone.numberFormat = (NumberFormat) numberFormat.clone();
        return clone;
    }

    /**
     * Compares this date format with the specified object and indicates if they
     * are equal.
     *
     * @param object
     *            the object to compare with this date format.
     * @return {@code true} if {@code object} is a {@code DateFormat} object and
     *         it has the same properties as this date format; {@code false}
     *         otherwise.
     * @see #hashCode
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.735 -0500", hash_original_method = "ACA6119BE57A696CA271FA419EAF8A87", hash_generated_method = "9478B044B0FAAEBB5403DC1489F2E0ED")
    @Override
public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DateFormat)) {
            return false;
        }
        DateFormat dateFormat = (DateFormat) object;
        return numberFormat.equals(dateFormat.numberFormat)
                && calendar.getTimeZone().equals(
                        dateFormat.calendar.getTimeZone())
                && calendar.getFirstDayOfWeek() == dateFormat.calendar
                        .getFirstDayOfWeek()
                && calendar.getMinimalDaysInFirstWeek() == dateFormat.calendar
                        .getMinimalDaysInFirstWeek()
                && calendar.isLenient() == dateFormat.calendar.isLenient();
    }

    /**
     * Formats the specified object as a string using the pattern of this date
     * format and appends the string to the specified string buffer.
     * <p>
     * If the {@code field} member of {@code field} contains a value specifying
     * a format field, then its {@code beginIndex} and {@code endIndex} members
     * will be updated with the position of the first occurrence of this field
     * in the formatted text.
     *
     * @param object
     *            the source object to format, must be a {@code Date} or a
     *            {@code Number}. If {@code object} is a number then a date is
     *            constructed using the {@code longValue()} of the number.
     * @param buffer
     *            the target string buffer to append the formatted date/time to.
     * @param field
     *            on input: an optional alignment field; on output: the offsets
     *            of the alignment field in the formatted text.
     * @return the string buffer.
     * @throws IllegalArgumentException
     *            if {@code object} is neither a {@code Date} nor a
     *            {@code Number} instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.736 -0500", hash_original_method = "B3CAB535AB645340CDBC761CC64061A2", hash_generated_method = "A2E0A989B834C4E2B1CAFCE3FEA7CA69")
    @Override
public final StringBuffer format(Object object, StringBuffer buffer,
            FieldPosition field) {
        if (object instanceof Date) {
            return format((Date) object, buffer, field);
        }
        if (object instanceof Number) {
            return format(new Date(((Number) object).longValue()), buffer,
                    field);
        }
        throw new IllegalArgumentException();
    }

    /**
     * Formats the specified date using the rules of this date format.
     *
     * @param date
     *            the date to format.
     * @return the formatted string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.737 -0500", hash_original_method = "2A35FD3F5DCDDD81B439EA4274C41413", hash_generated_method = "EEB1197F390F746EAF296F0CBA3BE616")
    public final String format(Date date) {
        return format(date, new StringBuffer(), new FieldPosition(0))
                .toString();
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
     * @param field
     *            on input: an optional alignment field; on output: the offsets
     *            of the alignment field in the formatted text.
     * @return the string buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.737 -0500", hash_original_method = "CCA64E9C4F95BFBA0963A237E8C02CBB", hash_generated_method = "B7B10EE9D6E6167008ADC116705062BB")
    public abstract StringBuffer format(Date date, StringBuffer buffer,
            FieldPosition field);

    /**
     * Returns the calendar used by this {@code DateFormat}.
     *
     * @return the calendar used by this date format.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.739 -0500", hash_original_method = "AC2D491D0E9EF49D1E9DF4E35BBACC3B", hash_generated_method = "9CCA2A38B21AEC6F62F360BFF7610E34")
    public Calendar getCalendar() {
        return calendar;
    }

    /**
     * Returns the {@code NumberFormat} used by this {@code DateFormat}.
     *
     * @return the {@code NumberFormat} used by this date format.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.747 -0500", hash_original_method = "303CF4BDA8F6551FE38CF841A2AE86A7", hash_generated_method = "EB38436501CEBEE3B4D1C055D8B464AE")
    public NumberFormat getNumberFormat() {
        return numberFormat;
    }

    /**
     * Returns the time zone of this date format's calendar.
     *
     * @return the time zone of the calendar used by this date format.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.751 -0500", hash_original_method = "028D1A898568609D223BE7B30E97723B", hash_generated_method = "B01A7C91ADD7ACF068582800A58DB9D6")
    public TimeZone getTimeZone() {
        return calendar.getTimeZone();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.752 -0500", hash_original_method = "3F46A6ECEE37AE5ECC5364DC5B9940AE", hash_generated_method = "30133F34F2648997EE89ACFF34EEDB3F")
    @Override
public int hashCode() {
        return calendar.getFirstDayOfWeek()
                + calendar.getMinimalDaysInFirstWeek()
                + calendar.getTimeZone().hashCode()
                + (calendar.isLenient() ? 1231 : 1237)
                + numberFormat.hashCode();
    }

    /**
     * Indicates whether the calendar used by this date format is lenient.
     *
     * @return {@code true} if the calendar is lenient; {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.753 -0500", hash_original_method = "C4BF8639B942350BBBDBCDAD05669E72", hash_generated_method = "27734BC62C1DCCFA99B539ECC6E7C540")
    public boolean isLenient() {
        return calendar.isLenient();
    }

    /**
     * Parses a date from the specified string using the rules of this date
     * format.
     *
     * @param string
     *            the string to parse.
     * @return the {@code Date} resulting from the parsing.
     * @throws ParseException
     *         if an error occurs during parsing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.754 -0500", hash_original_method = "CB060FB8FCF7D6D5A12D02C797F79FD4", hash_generated_method = "AB750F8D4A9AEF735FB2E2BFCAC75CE4")
    public Date parse(String string) throws ParseException {
        ParsePosition position = new ParsePosition(0);
        Date date = parse(string, position);
        if (position.getIndex() == 0) {
            throw new ParseException("Unparseable date: \"" + string + "\"",
                    position.getErrorIndex());
        }
        return date;
    }

    /**
     * Parses a date from the specified string starting at the index specified
     * by {@code position}. If the string is successfully parsed then the index
     * of the {@code ParsePosition} is updated to the index following the parsed
     * text. On error, the index is unchanged and the error index of {@code
     * ParsePosition} is set to the index where the error occurred.
     * <p>
     * By default, parsing is lenient: If the input is not in the form used by
     * this object's format method but can still be parsed as a date, then the
     * parse succeeds. Clients may insist on strict adherence to the format by
     * calling {@code setLenient(false)}.
     *
     * @param string
     *            the string to parse.
     * @param position
     *            input/output parameter, specifies the start index in {@code
     *            string} from where to start parsing. If parsing is successful,
     *            it is updated with the index following the parsed text; on
     *            error, the index is unchanged and the error index is set to
     *            the index where the error occurred.
     * @return the date resulting from the parse, or {@code null} if there is an
     *         error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.755 -0500", hash_original_method = "96A53C3E9008520EC39833233AB03108", hash_generated_method = "87630C55D49CD1AADF581DDA7D25A18E")
    public abstract Date parse(String string, ParsePosition position);

    /**
     * Parses a date from the specified string starting at the index specified
     * by {@code position}. If the string is successfully parsed then the index
     * of the {@code ParsePosition} is updated to the index following the parsed
     * text. On error, the index is unchanged and the error index of
     * {@code ParsePosition} is set to the index where the error occurred.
     * <p>
     * By default, parsing is lenient: If the input is not in the form used by
     * this object's format method but can still be parsed as a date, then the
     * parse succeeds. Clients may insist on strict adherence to the format by
     * calling {@code setLenient(false)}.
     *
     * @param string
     *            the string to parse.
     * @param position
     *            input/output parameter, specifies the start index in
     *            {@code string} from where to start parsing. If parsing is
     *            successful, it is updated with the index following the parsed
     *            text; on error, the index is unchanged and the error index
     *            is set to the index where the error occurred.
     * @return the date resulting from the parsing, or {@code null} if there is
     *         an error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.756 -0500", hash_original_method = "C9AA8969DE1792F4979FB5B1F65B9849", hash_generated_method = "63216C42E69B7A23B760025E3A8B8D9B")
    @Override
public Object parseObject(String string, ParsePosition position) {
        return parse(string, position);
    }

    /**
     * Sets the calendar used by this date format.
     *
     * @param cal
     *            the new calendar.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.757 -0500", hash_original_method = "6C57FEC8F5EF28EFDF88DCA370317E90", hash_generated_method = "E18AF8A914833DDBE3D602C2454CC930")
    public void setCalendar(Calendar cal) {
        calendar = cal;
    }

    /**
     * Specifies whether or not date/time parsing shall be lenient. With lenient
     * parsing, the parser may use heuristics to interpret inputs that do not
     * precisely match this object's format. With strict parsing, inputs must
     * match this object's format.
     *
     * @param value
     *            {@code true} to set the calendar to be lenient, {@code false}
     *            otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.758 -0500", hash_original_method = "C0CD4ED6DB9107DF0F000BE04B2DBCDB", hash_generated_method = "77C364A8166B57DB585E631363560368")
    public void setLenient(boolean value) {
        calendar.setLenient(value);
    }

    /**
     * Sets the {@code NumberFormat} used by this date format.
     *
     * @param format
     *            the new number format.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.759 -0500", hash_original_method = "DB316F58F9072942395CFF97FB7F9BCE", hash_generated_method = "A51768D3C3145730C6940AA0F928B66A")
    public void setNumberFormat(NumberFormat format) {
        numberFormat = format;
    }

    /**
     * Sets the time zone of the calendar used by this date format.
     *
     * @param timezone
     *            the new time zone.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:17.760 -0500", hash_original_method = "21956223404148B0DA41DA5118D6AFF3", hash_generated_method = "7D12735F5FACD641C52739A935BD1364")
    public void setTimeZone(TimeZone timezone) {
        calendar.setTimeZone(timezone);
    }
}

