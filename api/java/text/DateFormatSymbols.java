package java.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Locale;

import libcore.icu.ICU;
import libcore.icu.LocaleData;
import libcore.icu.TimeZones;





public class DateFormatSymbols implements Serializable, Cloneable {

    /**
     * Returns a new {@code DateFormatSymbols} instance for the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     *
     * @return an instance of {@code DateFormatSymbols}
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.802 -0500", hash_original_method = "3EB23C2DF5EB21266FB298F464DCFFCF", hash_generated_method = "F45FB7B1AF681A36267EB5D88557BB70")
    public static final DateFormatSymbols getInstance() {
        return getInstance(Locale.getDefault());
    }

    /**
     * Returns a new {@code DateFormatSymbols} for the given locale.
     *
     * @param locale the locale
     * @return an instance of {@code DateFormatSymbols}
     * @throws NullPointerException if {@code locale == null}
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.803 -0500", hash_original_method = "D58E0AC5713E6C4C00BE02A97E40DFE2", hash_generated_method = "C1D7872A04D2CAA85925056DDF6980C5")
    public static final DateFormatSymbols getInstance(Locale locale) {
        if (locale == null) {
            throw new NullPointerException();
        }
        return new DateFormatSymbols(locale);
    }

    /**
     * Returns an array of locales for which custom {@code DateFormatSymbols} instances
     * are available.
     * <p>Note that Android does not support user-supplied locale service providers.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.804 -0500", hash_original_method = "256797DA5B6BE050E889700D67B9C760", hash_generated_method = "BF6BD0497C537B76BD8E15E7A25B3BB6")
    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableDateFormatSymbolsLocales();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.809 -0500", hash_original_method = "F298CD9B35B1A7217D8C6A751BA351CF", hash_generated_method = "DBCC35D15F97BAB844F13AC73742B219")
    private static boolean timeZoneStringsEqual(DateFormatSymbols lhs, DateFormatSymbols rhs) {
        // Quick check that may keep us from having to load the zone strings.
        // Note that different locales may have the same strings, so the opposite check isn't valid.
        if (lhs.zoneStrings == null && rhs.zoneStrings == null && lhs.locale.equals(rhs.locale)) {
            return true;
        }
        // Make sure zone strings are loaded, then check.
        return Arrays.deepEquals(lhs.internalZoneStrings(), rhs.internalZoneStrings());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.817 -0500", hash_original_method = "B34C69425BA0551BBDC4989EB36BB4B2", hash_generated_method = "27ACBDC93EFB0CA519EFEEE23A36DDEF")
    private static String[][] clone2dStringArray(String[][] array) {
        String[][] result = new String[array.length][];
        for (int i = 0; i < array.length; ++i) {
            result[i] = array[i].clone();
        }
        return result;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.791 -0500", hash_original_field = "000410F3E4110E922FAF352732C42607", hash_generated_field = "3A9F42BB82D57C84015671E87240C88B")


    private static final long serialVersionUID = -5987973545549424702L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.792 -0500", hash_original_field = "638D89148E50EBCC60E4E8C7FF9DC90C", hash_generated_field = "B3AAF3207AD6EC4015B2989CC1E896AA")


    private String localPatternChars;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.009 -0400", hash_original_field = "EE109C8604E524BC6D9E0C2587FEE2D8", hash_generated_field = "E9E36152E2B2CCE2D2DF7029FCA0E0AA")

    String[] ampms;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.009 -0400", hash_original_field = "D026F0E07E8726FB52E3CC3E3D0D1375", hash_generated_field = "E0691941E69B86E10AC79FC9DFFC272D")

    String[] eras;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.009 -0400", hash_original_field = "DA36CFAF48B9E19896E23E1207040D1E", hash_generated_field = "86F5593447744AB0D2426E4B6C92C689")

    String[] months;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.009 -0400", hash_original_field = "7CFA6EB2E9F41003AC5C121106DC32C1", hash_generated_field = "0DF3792D47225D65FC03CC1EE597502D")

    String[] shortMonths;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.009 -0400", hash_original_field = "F232077D652EDEE073A547D6F8C9DBAA", hash_generated_field = "9FF057C20818DAD49F561EBB25C5D177")

    String[] shortWeekdays;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.009 -0400", hash_original_field = "92B9604FFB8FE10577DE981BE625A6D1", hash_generated_field = "F5A81D14F7FC350336EA1CDD45134728")

    String[] weekdays;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.793 -0500", hash_original_field = "00642AAEC569CDA836E6B109A0ECC3C9", hash_generated_field = "402565001AFCC4D0F913CB823E99BBB5")

    transient String[] longStandAloneMonths;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.794 -0500", hash_original_field = "5387D48D62D34E66E67814DB721F0B62", hash_generated_field = "D3C2FF472DF92A6DB563114884CB2A55")

    transient String[] shortStandAloneMonths;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.795 -0500", hash_original_field = "BDCCA5CE99A2C0DA2687E12D8FFB59F4", hash_generated_field = "A8C4ABDEC24C4081D6DC2DD240794CBF")

    transient String[] longStandAloneWeekdays;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.796 -0500", hash_original_field = "3A0C0082D09B4B92BBB86FD9F0E53904", hash_generated_field = "5A1974ABC298872CE58EE882C634EEA7")

    transient String[] shortStandAloneWeekdays;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.797 -0500", hash_original_field = "7D22C959C8C5C0204FC82BE4EE6AC154", hash_generated_field = "7D22C959C8C5C0204FC82BE4EE6AC154")

    String[][] zoneStrings;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.798 -0500", hash_original_field = "C3057DA1E76FAE6C7E3B3F2AC4546897", hash_generated_field = "95929A023295B932C341AB00B66AEC36")

    transient boolean customZoneStrings;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.798 -0500", hash_original_field = "A25411C3C357716626A9185E220A5EAA", hash_generated_field = "B588E29C12BDB46B326FE934DDE5D1D8")

    transient  Locale locale;

    /**
     * Constructs a new {@code DateFormatSymbols} instance containing the
     * symbols for the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.800 -0500", hash_original_method = "5D59D1DAC1D60D67A4A902493CF704FB", hash_generated_method = "A3FD5020BE4BE678FABB4B72B891AF45")
    public DateFormatSymbols() {
        this(Locale.getDefault());
    }

    /**
     * Constructs a new {@code DateFormatSymbols} instance containing the
     * symbols for the specified locale.
     *
     * @param locale
     *            the locale.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.801 -0500", hash_original_method = "10456A2571D0B6BA1CAC9BF624A7CB6F", hash_generated_method = "66A899D7DC9685B14752F7E4AE7BE51A")
    public DateFormatSymbols(Locale locale) {
        this.locale = locale;
        this.localPatternChars = SimpleDateFormat.PATTERN_CHARS;
        LocaleData localeData = LocaleData.get(locale);
        this.ampms = localeData.amPm;
        this.eras = localeData.eras;
        this.months = localeData.longMonthNames;
        this.shortMonths = localeData.shortMonthNames;
        this.weekdays = localeData.longWeekdayNames;
        this.shortWeekdays = localeData.shortWeekdayNames;

        // ICU/Android extensions.
        this.longStandAloneMonths = localeData.longStandAloneMonthNames;
        this.shortStandAloneMonths = localeData.shortStandAloneMonthNames;
        this.longStandAloneWeekdays = localeData.longStandAloneWeekdayNames;
        this.shortStandAloneWeekdays = localeData.shortStandAloneWeekdayNames;
    }

    /**
     * Gets zone strings, initializing them if necessary. Does not create
     * a defensive copy, so make sure you do so before exposing the returned
     * arrays to clients.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.799 -0500", hash_original_method = "D4F915DF738351C94CAE2742EF7502E4", hash_generated_method = "00D080E7FE990AFC83626B54C393ADE4")
    synchronized String[][] internalZoneStrings() {
        if (zoneStrings == null) {
            zoneStrings = TimeZones.getZoneStrings(locale);
        }
        return zoneStrings;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.805 -0500", hash_original_method = "E120B4C8193E856C74E13A18ACCA4F59", hash_generated_method = "56356869493ABBF18C233DB98B7292B4")
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();

        // The RI doesn't have these fields, so we'll have to fall back and do the best we can.
        longStandAloneMonths = months;
        shortStandAloneMonths = shortMonths;
        longStandAloneWeekdays = weekdays;
        shortStandAloneWeekdays = shortWeekdays;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.806 -0500", hash_original_method = "5B6B2CBEB972D19E7440DD4CD3FE992C", hash_generated_method = "E86906C583BDA4C33248A751CB2B80A7")
    private void writeObject(ObjectOutputStream oos) throws IOException {
        internalZoneStrings();
        oos.defaultWriteObject();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.807 -0500", hash_original_method = "8CF95CA28B578C998335BB5077A2FD41", hash_generated_method = "D24BA659AA7D0E532593D4A64FAB7FBB")
    @Override
public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    /**
     * Compares this object with the specified object and indicates if they are
     * equal.
     *
     * @param object
     *            the object to compare with this object.
     * @return {@code true} if {@code object} is an instance of
     *         {@code DateFormatSymbols} and has the same symbols as this
     *         object, {@code false} otherwise.
     * @see #hashCode
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.808 -0500", hash_original_method = "94EAA904B302ADC25F17C85B071CCB2E", hash_generated_method = "5B26C3EFED06904566D4AA2D9A962742")
    @Override
public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DateFormatSymbols)) {
            return false;
        }
        DateFormatSymbols rhs = (DateFormatSymbols) object;
        return localPatternChars.equals(rhs.localPatternChars) &&
                Arrays.equals(ampms, rhs.ampms) &&
                Arrays.equals(eras, rhs.eras) &&
                Arrays.equals(months, rhs.months) &&
                Arrays.equals(shortMonths, rhs.shortMonths) &&
                Arrays.equals(shortWeekdays, rhs.shortWeekdays) &&
                Arrays.equals(weekdays, rhs.weekdays) &&
                timeZoneStringsEqual(this, rhs);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.810 -0500", hash_original_method = "315ADE63F84D6DC8A24FA118617E3BBD", hash_generated_method = "A8000F990C4D2B3FBF86DC8F865F43A0")
    @Override
public String toString() {
        // 'locale' isn't part of the externally-visible state.
        // 'zoneStrings' is so large, we just print a representative value.
        return getClass().getName() +
                "[amPmStrings=" + Arrays.toString(ampms) +
                ",customZoneStrings=" + customZoneStrings +
                ",eras=" + Arrays.toString(eras) +
                ",localPatternChars=" + localPatternChars +
                ",months=" + Arrays.toString(months) +
                ",shortMonths=" + Arrays.toString(shortMonths) +
                ",shortWeekdays=" + Arrays.toString(shortWeekdays) +
                ",weekdays=" + Arrays.toString(weekdays) +
                ",zoneStrings=[" + Arrays.toString(internalZoneStrings()[0]) + "...]" +
                "]";
    }

    /**
     * Returns the array of strings which represent AM and PM. Use the
     * {@link java.util.Calendar} constants {@code Calendar.AM} and
     * {@code Calendar.PM} as indices for the array.
     *
     * @return an array of strings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.811 -0500", hash_original_method = "72991BA97E8B1C753B319ABB9AE6A911", hash_generated_method = "A9856D8B6C989DDF059928D8717607F5")
    public String[] getAmPmStrings() {
        return ampms.clone();
    }

    /**
     * Returns the array of strings which represent BC and AD. Use the
     * {@link java.util.Calendar} constants {@code GregorianCalendar.BC} and
     * {@code GregorianCalendar.AD} as indices for the array.
     *
     * @return an array of strings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.812 -0500", hash_original_method = "BB9FAB8B89491AAFEBAE987DB8D7ADC9", hash_generated_method = "94B4266AAF8B96068E6A4428AD166AE1")
    public String[] getEras() {
        return eras.clone();
    }

    /**
     * Returns the pattern characters used by {@link SimpleDateFormat} to
     * specify date and time fields.
     *
     * @return a string containing the pattern characters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.813 -0500", hash_original_method = "EEE83582BA421C729308A747699C1F8B", hash_generated_method = "8020C829A4307205A8380FF0EC7773DC")
    public String getLocalPatternChars() {
        return localPatternChars;
    }

    /**
     * Returns the array of strings containing the full names of the months. Use
     * the {@link java.util.Calendar} constants {@code Calendar.JANUARY} etc. as
     * indices for the array.
     *
     * @return an array of strings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.813 -0500", hash_original_method = "7E7D6ABDEA9D17B1FB9A10690E51D2C0", hash_generated_method = "E6F7C6F7EDCFF21CD9EC9705A9997081")
    public String[] getMonths() {
        return months.clone();
    }

    /**
     * Returns the array of strings containing the abbreviated names of the
     * months. Use the {@link java.util.Calendar} constants
     * {@code Calendar.JANUARY} etc. as indices for the array.
     *
     * @return an array of strings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.814 -0500", hash_original_method = "B159D6A758F880417EB3F558245AB4C8", hash_generated_method = "23228701839B041BE35E570066BA5B82")
    public String[] getShortMonths() {
        return shortMonths.clone();
    }

    /**
     * Returns the array of strings containing the abbreviated names of the days
     * of the week. Use the {@link java.util.Calendar} constants
     * {@code Calendar.SUNDAY} etc. as indices for the array.
     *
     * @return an array of strings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.815 -0500", hash_original_method = "22143FF136703407DD6E3A76253CFCD4", hash_generated_method = "E21790038F6B6114BA0E3C8BF9C72EF2")
    public String[] getShortWeekdays() {
        return shortWeekdays.clone();
    }

    /**
     * Returns the array of strings containing the full names of the days of the
     * week. Use the {@link java.util.Calendar} constants
     * {@code Calendar.SUNDAY} etc. as indices for the array.
     *
     * @return an array of strings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.816 -0500", hash_original_method = "9B40AAE5B3ACDD77762A9FF02C898A9B", hash_generated_method = "347ECB5FA9861F1CA81E7F26A2A506DC")
    public String[] getWeekdays() {
        return weekdays.clone();
    }

    /**
     * Returns the two-dimensional array of strings containing localized names for time zones.
     * Each row is an array of five strings:
     * <ul>
     * <li>The time zone ID, for example "America/Los_Angeles".
     *     This is not localized, and is used as a key into the table.
     * <li>The long display name, for example "Pacific Standard Time".
     * <li>The short display name, for example "PST".
     * <li>The long display name for DST, for example "Pacific Daylight Time".
     *     This is the non-DST long name for zones that have never had DST, for
     *     example "Central Standard Time" for "Canada/Saskatchewan".
     * <li>The short display name for DST, for example "PDT". This is the
     *     non-DST short name for zones that have never had DST, for example
     *     "CST" for "Canada/Saskatchewan".
     * </ul>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.817 -0500", hash_original_method = "BCD39B9ED22174061A8487583A862B84", hash_generated_method = "563FAAFCA0308CDEF53A5C45612E3C9C")
    public String[][] getZoneStrings() {
        return clone2dStringArray(internalZoneStrings());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.819 -0500", hash_original_method = "092997CB42FACC03E21BAFCA0C446C08", hash_generated_method = "9BB33B0375BEB97A684E8D357EB9D95D")
    @Override
public int hashCode() {
        String[][] zoneStrings = internalZoneStrings();
        int hashCode;
        hashCode = localPatternChars.hashCode();
        for (String element : ampms) {
            hashCode += element.hashCode();
        }
        for (String element : eras) {
            hashCode += element.hashCode();
        }
        for (String element : months) {
            hashCode += element.hashCode();
        }
        for (String element : shortMonths) {
            hashCode += element.hashCode();
        }
        for (String element : shortWeekdays) {
            hashCode += element.hashCode();
        }
        for (String element : weekdays) {
            hashCode += element.hashCode();
        }
        for (String[] element : zoneStrings) {
            for (int j = 0; j < element.length; j++) {
                if (element[j] != null) {
                    hashCode += element[j].hashCode();
                }
            }
        }
        return hashCode;
    }

    /**
     * Sets the array of strings which represent AM and PM. Use the
     * {@link java.util.Calendar} constants {@code Calendar.AM} and
     * {@code Calendar.PM} as indices for the array.
     *
     * @param data
     *            the array of strings for AM and PM.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.819 -0500", hash_original_method = "C567EF18556F46918292A2FE23B946BD", hash_generated_method = "D59F05F711749B873850B7A455C787AC")
    public void setAmPmStrings(String[] data) {
        ampms = data.clone();
    }

    /**
     * Sets the array of Strings which represent BC and AD. Use the
     * {@link java.util.Calendar} constants {@code GregorianCalendar.BC} and
     * {@code GregorianCalendar.AD} as indices for the array.
     *
     * @param data
     *            the array of strings for BC and AD.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.820 -0500", hash_original_method = "144479B04BA5F93BAF1BE491BC6DCE8F", hash_generated_method = "B1E6F0C5C41407BB499052643894FD2B")
    public void setEras(String[] data) {
        eras = data.clone();
    }

    /**
     * Sets the pattern characters used by {@link SimpleDateFormat} to specify
     * date and time fields.
     *
     * @param data
     *            the string containing the pattern characters.
     * @throws NullPointerException
     *            if {@code data} is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.821 -0500", hash_original_method = "8CEB0632F689D252D9B5C4F3D13B9389", hash_generated_method = "F13375E839A75C058396EAA758CD7599")
    public void setLocalPatternChars(String data) {
        if (data == null) {
            throw new NullPointerException();
        }
        localPatternChars = data;
    }

    /**
     * Sets the array of strings containing the full names of the months. Use
     * the {@link java.util.Calendar} constants {@code Calendar.JANUARY} etc. as
     * indices for the array.
     *
     * @param data
     *            the array of strings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.822 -0500", hash_original_method = "FF561E75C563B528E8ADE2D7DEADB24B", hash_generated_method = "C8F11F8A2C34DB8F290459879A4CB458")
    public void setMonths(String[] data) {
        months = data.clone();
    }

    /**
     * Sets the array of strings containing the abbreviated names of the months.
     * Use the {@link java.util.Calendar} constants {@code Calendar.JANUARY}
     * etc. as indices for the array.
     *
     * @param data
     *            the array of strings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.823 -0500", hash_original_method = "6978BA653DCBEF5E7386E930F96F0A7F", hash_generated_method = "1D932DD50180AA9DC1DF095941DEC658")
    public void setShortMonths(String[] data) {
        shortMonths = data.clone();
    }

    /**
     * Sets the array of strings containing the abbreviated names of the days of
     * the week. Use the {@link java.util.Calendar} constants
     * {@code Calendar.SUNDAY} etc. as indices for the array.
     *
     * @param data
     *            the array of strings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.824 -0500", hash_original_method = "D0F3596C1C1C0E88C3194208B883F56E", hash_generated_method = "62231263430DF127971CD07AB28E99E5")
    public void setShortWeekdays(String[] data) {
        shortWeekdays = data.clone();
    }

    /**
     * Sets the array of strings containing the full names of the days of the
     * week. Use the {@link java.util.Calendar} constants
     * {@code Calendar.SUNDAY} etc. as indices for the array.
     *
     * @param data
     *            the array of strings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.824 -0500", hash_original_method = "8E95286ADE938FE6BC77C4018461282B", hash_generated_method = "BAD8A77AFDB6717590D8AEDAA67EE54F")
    public void setWeekdays(String[] data) {
        weekdays = data.clone();
    }

    /**
     * Sets the two-dimensional array of strings containing localized names for time zones.
     * See {@link #getZoneStrings} for details.
     * @throws IllegalArgumentException if any row has fewer than 5 elements.
     * @throws NullPointerException if {@code zoneStrings == null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:19.826 -0500", hash_original_method = "97B75279909DC0B04FB710B3778B8E55", hash_generated_method = "C214CE0282615E8EE7C6D7BF302A4AD7")
    public void setZoneStrings(String[][] zoneStrings) {
        if (zoneStrings == null) {
            throw new NullPointerException();
        }
        for (String[] row : zoneStrings) {
            if (row.length < 5) {
                throw new IllegalArgumentException(Arrays.toString(row) + ".length < 5");
            }
        }
        this.zoneStrings = clone2dStringArray(zoneStrings);
        this.customZoneStrings = true;
    }
}

