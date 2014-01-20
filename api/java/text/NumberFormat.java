package java.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Locale;

import libcore.icu.ICU;
import libcore.icu.LocaleData;

public abstract class NumberFormat extends Format {

    /**
     * Returns an array of locales for which custom {@code NumberFormat} instances
     * are available.
     * <p>Note that Android does not support user-supplied locale service providers.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.837 -0500", hash_original_method = "6BEB9368EB9D88DA78E1C62745050C9B", hash_generated_method = "3B9E6EDBE5D8569E871CF4D025A8564A")
    
public static Locale[] getAvailableLocales() {
        return ICU.getAvailableNumberFormatLocales();
    }

    /**
     * Returns a {@code NumberFormat} for formatting and parsing currency values
     * for the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     *
     * @return a {@code NumberFormat} for handling currency values.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.843 -0500", hash_original_method = "258A750CE8BE13405441C959EA448B3E", hash_generated_method = "326DD9FA59ABEDC759B8356CA4C0754E")
    
public static final NumberFormat getCurrencyInstance() {
        return getCurrencyInstance(Locale.getDefault());
    }

    /**
     * Returns a {@code NumberFormat} for formatting and parsing currency values
     * for the specified locale.
     *
     * @param locale
     *            the locale to use.
     * @return a {@code NumberFormat} for handling currency values.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.845 -0500", hash_original_method = "16A5E39250FE2E20C754792FEDF0522B", hash_generated_method = "41DEE570C68D28442F17AB74256D21CD")
    
public static NumberFormat getCurrencyInstance(Locale locale) {
        return getInstance(LocaleData.get(locale).currencyPattern, locale);
    }

    /**
     * Returns a {@code NumberFormat} for formatting and parsing integers for the
     * user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     *
     * @return a {@code NumberFormat} for handling integers.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.848 -0500", hash_original_method = "5548420D2F066ACFECD569FD2948AFC4", hash_generated_method = "0D3727AE0AD25B78DF9EAB50567A188F")
    
public static final NumberFormat getIntegerInstance() {
        return getIntegerInstance(Locale.getDefault());
    }

    /**
     * Returns a {@code NumberFormat} for formatting and parsing integers for
     * the specified locale.
     *
     * @param locale
     *            the locale to use.
     * @return a {@code NumberFormat} for handling integers.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.850 -0500", hash_original_method = "25EF42A674E48F64B76F32D6F7A53370", hash_generated_method = "62F71791F2B9CCFF9340FDDFE343F2C5")
    
public static NumberFormat getIntegerInstance(Locale locale) {
        NumberFormat result = getInstance(LocaleData.get(locale).integerPattern, locale);
        result.setParseIntegerOnly(true);
        return result;
    }

    /**
     * Returns a {@code NumberFormat} for formatting and parsing numbers for the
     * default locale.
     *
     * @return a {@code NumberFormat} for handling {@code Number} objects.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.853 -0500", hash_original_method = "F7516F92C087ACF7ECF1F822BA0199BE", hash_generated_method = "D6CE1F57C2D3FCF6C95F069F1B260153")
    
public static final NumberFormat getInstance() {
        return getNumberInstance();
    }

    /**
     * Returns a {@code NumberFormat} for formatting and parsing numbers for the
     * specified locale.
     *
     * @param locale
     *            the locale to use.
     * @return a {@code NumberFormat} for handling {@code Number} objects.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.855 -0500", hash_original_method = "3A87CF816CFDA0980D70AEF11A7290C6", hash_generated_method = "BD0D464261E3C1D0AE15045C4C98DD9C")
    
public static NumberFormat getInstance(Locale locale) {
        return getNumberInstance(locale);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.858 -0500", hash_original_method = "EB5EC89C6842F0D79CF1138BE0031817", hash_generated_method = "B58E08D62E82FABF334079070BB54D27")
    
private static NumberFormat getInstance(String pattern, Locale locale) {
        return new DecimalFormat(pattern, locale);
    }

    /**
     * Returns a {@code NumberFormat} for formatting and parsing numbers for the
     * user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     *
     * @return a {@code NumberFormat} for handling {@code Number} objects.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.870 -0500", hash_original_method = "63F8FE3016CEBE5E29C78966580FBB54", hash_generated_method = "2D381449A417B2D2CEC017FDCBFA76E4")
    
public static final NumberFormat getNumberInstance() {
        return getNumberInstance(Locale.getDefault());
    }

    /**
     * Returns a {@code NumberFormat} for formatting and parsing numbers for the
     * specified locale.
     *
     * @param locale
     *            the locale to use.
     * @return a {@code NumberFormat} for handling {@code Number} objects.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.873 -0500", hash_original_method = "66D65C328FDAE1D86A3DA0B84FD3C3FE", hash_generated_method = "57E6D8A79AC39E4051B615DED084CA5A")
    
public static NumberFormat getNumberInstance(Locale locale) {
        return getInstance(LocaleData.get(locale).numberPattern, locale);
    }

    /**
     * Returns a {@code NumberFormat} for formatting and parsing percentage
     * values for the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     *
     * <p>The {@code NumberFormat} returned by this method should only be used
     * to format floating-point numbers typically between 0 and 1 (with 1 being 100%).
     * A value such as 0.53 will be treated as 53%, but 53.0 (or the integer 53) will be
     * treated as 5,300%, which is rarely what you intended.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.875 -0500", hash_original_method = "855FA915A2F7D9FBFD9E3E67A5EAB3BE", hash_generated_method = "A8A5BA5B2985FCECB0F0BEC3DAA1CF00")
    
public static final NumberFormat getPercentInstance() {
        return getPercentInstance(Locale.getDefault());
    }

    /**
     * Returns a {@code NumberFormat} for formatting and parsing percentage
     * values for the given {@code locale}.
     *
     * <p>The {@code NumberFormat} returned by this method should only be used
     * to format floating-point numbers typically between 0 and 1 (with 1 being 100%).
     * A value such as 0.53 will be treated as 53%, but 53.0 (or the integer 53) will be
     * treated as 5,300%, which is rarely what you intended.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.878 -0500", hash_original_method = "04CA5B59AD3E4BB098F73D201B017E04", hash_generated_method = "C5ED3D84C07C920C2DDDFF1B49D7B31A")
    
public static NumberFormat getPercentInstance(Locale locale) {
        return getInstance(LocaleData.get(locale).percentPattern, locale);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.804 -0500", hash_original_field = "B0493B31618B50A4C91C77CBDFBA8B6D", hash_generated_field = "F09073C8D8AE7A807304B7452EAEF8B1")

    private static final long serialVersionUID = -2308460125733713944L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.807 -0500", hash_original_field = "AEF70CABBD9DC0B6B474123AFBEA68D1", hash_generated_field = "8E8C994FB7A9C648CA5248364548DF14")

    public static final int INTEGER_FIELD = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.810 -0500", hash_original_field = "CA9D6DD01CE0C8D679F33026EF094B23", hash_generated_field = "366746AFA392D2AA06B116040E73FAAC")

    public static final int FRACTION_FIELD = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.913 -0500", hash_original_field = "F54C791EFF1ABDF72C23022B8083E49E", hash_generated_field = "BAD9E2169D2150C1AD558C00FC601059")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("groupingUsed", boolean.class),
        new ObjectStreamField("maxFractionDigits", byte.class),
        new ObjectStreamField("maximumFractionDigits", int.class),
        new ObjectStreamField("maximumIntegerDigits", int.class),
        new ObjectStreamField("maxIntegerDigits", byte.class),
        new ObjectStreamField("minFractionDigits", byte.class),
        new ObjectStreamField("minimumFractionDigits", int.class),
        new ObjectStreamField("minimumIntegerDigits", int.class),
        new ObjectStreamField("minIntegerDigits", byte.class),
        new ObjectStreamField("parseIntegerOnly", boolean.class),
        new ObjectStreamField("serialVersionOnStream", int.class),
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.829 -0400", hash_original_field = "A8297487699539E2F81FB26EFCAE4926", hash_generated_field = "BA0A3C716E8972AFDE20CB1849A202C5")

    private boolean groupingUsed = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.829 -0400", hash_original_field = "1B0360C18BB931B3601366AE793BA160", hash_generated_field = "B8A513C59F0250621283D2DE9187B85C")

    private boolean parseIntegerOnly = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.829 -0400", hash_original_field = "1B64E19FB2AD8A96A43F15BDB5C977BC", hash_generated_field = "A77FA56511D100D0E8370E5AA6626E49")

    private int maximumIntegerDigits = 40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.829 -0400", hash_original_field = "7EB911BA8BD0D322029A9FDAB57505FC", hash_generated_field = "7C07B0CC78175F8B345B2FD942DE4829")

    private int minimumIntegerDigits = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.829 -0400", hash_original_field = "F8E2B2219E9D1D35671A6FF9D8DD023B", hash_generated_field = "9031A923FB51BEDA5191306AA866610E")

    private int maximumFractionDigits = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.829 -0400", hash_original_field = "81C5674E758DBE4CDDC7554C3C6402D5", hash_generated_field = "A2436992C475A167FCC16C9C61FB2AEF")

    private int minimumFractionDigits = 0;

    /**
     * Used by subclasses. This was public in Java 5.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.817 -0500", hash_original_method = "AC8E136DE5A642003A57BDCF52FB755A", hash_generated_method = "BBA7749AC423BD76D422102DADB4C46F")
    
protected NumberFormat() {
    }

    /**
     * Returns a new {@code NumberFormat} with the same properties as this
     * {@code NumberFormat}.
     *
     * @return a shallow copy of this {@code NumberFormat}.
     * @see java.lang.Cloneable
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.819 -0500", hash_original_method = "323EA29B58059AEF6BA9ED0328A60A9B", hash_generated_method = "9755366EB9AD150D07F6C03C61EF8047")
    
@Override
    public Object clone() {
        return super.clone();
    }

    /**
     * Compares the specified object to this number format and indicates if
     * they are equal. In order to be equal, {@code object} must be an instance
     * of {@code NumberFormat} with the same pattern and properties.
     *
     * @param object
     *            the object to compare with this object.
     * @return {@code true} if the specified object is equal to this number
     *         format; {@code false} otherwise.
     * @see #hashCode
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.822 -0500", hash_original_method = "CF2A5131022F3DE945450C291D454139", hash_generated_method = "EF0DD2A5B3F471DBDDB9D70171B4916F")
    
@Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof NumberFormat)) {
            return false;
        }
        NumberFormat obj = (NumberFormat) object;
        return groupingUsed == obj.groupingUsed
                && parseIntegerOnly == obj.parseIntegerOnly
                && maximumFractionDigits == obj.maximumFractionDigits
                && maximumIntegerDigits == obj.maximumIntegerDigits
                && minimumFractionDigits == obj.minimumFractionDigits
                && minimumIntegerDigits == obj.minimumIntegerDigits;
    }

    /**
     * Formats the specified double using the rules of this number format.
     *
     * @param value
     *            the double to format.
     * @return the formatted string.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.825 -0500", hash_original_method = "D30D6926B1574E72997696CC4AACA867", hash_generated_method = "95F58325036F2C69E171344EDB82232C")
    
public final String format(double value) {
        return format(value, new StringBuffer(), new FieldPosition(0))
                .toString();
    }

    /**
     * Formats the specified double value as a string using the pattern of this
     * number format and appends the string to the specified string buffer.
     * <p>
     * If the {@code field} member of {@code position} contains a value
     * specifying a format field, then its {@code beginIndex} and
     * {@code endIndex} members will be updated with the position of the first
     * occurrence of this field in the formatted text.
     *
     * @param value
     *            the double to format.
     * @param buffer
     *            the target string buffer to append the formatted double value
     *            to.
     * @param field
     *            on input: an optional alignment field; on output: the offsets
     *            of the alignment field in the formatted text.
     * @return the string buffer.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.827 -0500", hash_original_method = "7CB6A6462126622DA2A88B0C24A5844A", hash_generated_method = "176E2433BC3E773098D4B0E8FDCC0386")
    
public abstract StringBuffer format(double value, StringBuffer buffer, FieldPosition field);

    /**
     * Formats the specified long using the rules of this number format.
     *
     * @param value
     *            the long to format.
     * @return the formatted string.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.830 -0500", hash_original_method = "D84155C6B50E9BFD8F05A957DEB6EF42", hash_generated_method = "0E7E8B70DFDDBFB1953B7F5E9BBC5BCE")
    
public final String format(long value) {
        return format(value, new StringBuffer(), new FieldPosition(0))
                .toString();
    }

    /**
     * Formats the specified long value as a string using the pattern of this
     * number format and appends the string to the specified string buffer.
     * <p>
     * If the {@code field} member of {@code position} contains a value
     * specifying a format field, then its {@code beginIndex} and
     * {@code endIndex} members will be updated with the position of the first
     * occurrence of this field in the formatted text.
     *
     * @param value
     *            the long to format.
     * @param buffer
     *            the target string buffer to append the formatted long value
     *            to.
     * @param field
     *            on input: an optional alignment field; on output: the offsets
     *            of the alignment field in the formatted text.
     * @return the string buffer.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.832 -0500", hash_original_method = "73E96E0E79F54A6C81E2C7F3DD907666", hash_generated_method = "4F8C5CBF5FC65EDB5D161D8E988A3E77")
    
public abstract StringBuffer format(long value, StringBuffer buffer, FieldPosition field);

    /**
     * Formats a number into a supplied buffer.
     * <p>
     * The number must be a subclass of {@code Number}. Instances of {@code Byte}, {@code Short},
     * {@code Integer}, and {@code Long} have {@code Number.longValue} invoked, as do instances of
     * {@code BigInteger} where {@code BigInteger.bitLength} returns <i>less than</i> 64. All other
     * values have {@code Number.doubleValue} invoked instead.
     * <p>
     * If the {@code field} member of {@code field} contains a value specifying
     * a format field, then its {@code beginIndex} and {@code endIndex} members
     * will be updated with the position of the first occurrence of this field
     * in the formatted text.
     *
     * @param object
     *            the object to format, must be a {@code Number}.
     * @param buffer
     *            the target string buffer to append the formatted number to.
     * @param field
     *            on input: an optional alignment field; on output: the offsets
     *            of the alignment field in the formatted text.
     * @return the string buffer.
     * @throws IllegalArgumentException
     *             if {@code object} is not an instance of {@code Number}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.835 -0500", hash_original_method = "294F85583D2E74BD6D7B73B5CBA517EA", hash_generated_method = "5012202613E05145340A6B817FC3F6D1")
    
@Override
    public StringBuffer format(Object object, StringBuffer buffer, FieldPosition field) {
        if (object instanceof Byte || object instanceof Short || object instanceof Integer ||
                object instanceof Long ||
                (object instanceof BigInteger && ((BigInteger) object).bitLength() < 64)) {
            long lv = ((Number) object).longValue();
            return format(lv, buffer, field);
        } else if (object instanceof Number) {
            double dv = ((Number) object).doubleValue();
            return format(dv, buffer, field);
        }
        throw new IllegalArgumentException();
    }

    /**
     * Returns the currency used by this number format.
     * <p>
     * This implementation throws {@code UnsupportedOperationException},
     * concrete subclasses should override this method if they support currency
     * formatting.
     * <p>
     *
     * @return the currency that was set in getInstance() or in setCurrency(),
     *         or {@code null}.
     * @throws UnsupportedOperationException
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.839 -0500", hash_original_method = "B4D372C49661A5E03C88F7CDA081E3AF", hash_generated_method = "E58C59A00DBF2277D293D6FCF2E0A587")
    
public Currency getCurrency() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the maximum number of fraction digits that are printed when
     * formatting. If the maximum is less than the number of fraction digits,
     * the least significant digits are truncated.
     *
     * @return the maximum number of fraction digits.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.860 -0500", hash_original_method = "E813DF8258936A130B114EAEAD95EDA2", hash_generated_method = "B284E6E4335E159EA03A8496EBD0433E")
    
public int getMaximumFractionDigits() {
        return maximumFractionDigits;
    }

    /**
     * Returns the maximum number of integer digits that are printed when
     * formatting. If the maximum is less than the number of integer digits, the
     * most significant digits are truncated.
     *
     * @return the maximum number of integer digits.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.862 -0500", hash_original_method = "78A0327FC665D89694C44AF144F747A0", hash_generated_method = "832D0299DF226A06856719050D8FC5C7")
    
public int getMaximumIntegerDigits() {
        return maximumIntegerDigits;
    }

    /**
     * Returns the minimum number of fraction digits that are printed when
     * formatting.
     *
     * @return the minimum number of fraction digits.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.865 -0500", hash_original_method = "357B48579C639D091425919515E6A5BC", hash_generated_method = "929DFB4D60F56D669FD28C19F5C46A06")
    
public int getMinimumFractionDigits() {
        return minimumFractionDigits;
    }

    /**
     * Returns the minimum number of integer digits that are printed when
     * formatting.
     *
     * @return the minimum number of integer digits.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.868 -0500", hash_original_method = "F5C90064F0CFBE4D6C8C4DDC2FA4814C", hash_generated_method = "C3DD120E23556C3549AFB1F8960B72C9")
    
public int getMinimumIntegerDigits() {
        return minimumIntegerDigits;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.880 -0500", hash_original_method = "BA195880AA858EB457E0D875FED9F2CD", hash_generated_method = "56D54B9101E14790F8421182F443C19C")
    
@Override
    public int hashCode() {
        return (groupingUsed ? 1231 : 1237) + (parseIntegerOnly ? 1231 : 1237)
                + maximumFractionDigits + maximumIntegerDigits
                + minimumFractionDigits + minimumIntegerDigits;
    }

    /**
     * Indicates whether this number format formats and parses numbers using a
     * grouping separator.
     *
     * @return {@code true} if a grouping separator is used; {@code false}
     *         otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.882 -0500", hash_original_method = "4D5DDA7520229906D909C6D4DE03887B", hash_generated_method = "4A3831659BCEE8D5EBF9DB83D3C6375D")
    
public boolean isGroupingUsed() {
        return groupingUsed;
    }

    /**
     * Indicates whether this number format only parses integer numbers. Parsing
     * stops if a decimal separator is encountered.
     *
     * @return {@code true} if this number format only parses integers,
     *         {@code false} if if parsese integers as well as fractions.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.884 -0500", hash_original_method = "2C7184F183FABEE99D4475D92EBC3629", hash_generated_method = "B83151213525193076686D6777E64041")
    
public boolean isParseIntegerOnly() {
        return parseIntegerOnly;
    }

    /**
     * Parses a {@code Number} from the specified string using the rules of this
     * number format.
     *
     * @param string
     *            the string to parse.
     * @return the {@code Number} resulting from the parsing.
     * @throws ParseException
     *            if an error occurs during parsing.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.887 -0500", hash_original_method = "FE3646B6613636F305FFC18B8FD2F859", hash_generated_method = "FA0FE0430A61B5169B5F290D51237EE6")
    
public Number parse(String string) throws ParseException {
        ParsePosition pos = new ParsePosition(0);
        Number number = parse(string, pos);
        if (pos.getIndex() == 0) {
            throw new ParseException("Unparseable number: \"" + string + "\"", pos.getErrorIndex());
        }
        return number;
    }

    /**
     * Parses a {@code Number} from the specified string starting at the index
     * specified by {@code position}. If the string is successfully parsed then
     * the index of the {@code ParsePosition} is updated to the index following
     * the parsed text. On error, the index is unchanged and the error index of
     * {@code ParsePosition} is set to the index where the error occurred.
     *
     * @param string
     *            the string to parse.
     * @param position
     *            input/output parameter, specifies the start index in
     *            {@code string} from where to start parsing. If parsing is
     *            successful, it is updated with the index following the parsed
     *            text; on error, the index is unchanged and the error index is
     *            set to the index where the error occurred.
     * @return the {@code Number} resulting from the parse or {@code null} if
     *         there is an error.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.890 -0500", hash_original_method = "A5BC45A24D32242DC134114EC64876DB", hash_generated_method = "E8742C864B91456FC159949C48AAD9B9")
    
public abstract Number parse(String string, ParsePosition position);

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.893 -0500", hash_original_method = "CBC8FD7F8E88C5B63A9D5DAA3A983953", hash_generated_method = "7BABB74BB34C2E2E1A32ABC270196D4D")
    
@Override
    public final Object parseObject(String string, ParsePosition position) {
        if (position == null) {
            throw new NullPointerException("position is null");
        }
        try {
            return parse(string, position);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Sets the currency used by this number format when formatting currency
     * values. The min and max fraction digits remain the same.
     * <p>
     * This implementation throws {@code UnsupportedOperationException},
     * concrete subclasses should override this method if they support currency
     * formatting.
     *
     * @param currency
     *            the new currency.
     * @throws UnsupportedOperationException
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.896 -0500", hash_original_method = "840FE994670C453CCC1032B9649CFF03", hash_generated_method = "A169631953653E16CCEEAB40C02C1FD8")
    
public void setCurrency(Currency currency) {
        throw new UnsupportedOperationException();
    }

    /**
     * Sets whether this number format formats and parses numbers using a
     * grouping separator.
     *
     * @param value
     *            {@code true} if a grouping separator is used; {@code false}
     *            otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.898 -0500", hash_original_method = "A7E1435E673E29B6F1D0E28A7EA1B8E8", hash_generated_method = "4EA80105A5A7830197F05B876D558B78")
    
public void setGroupingUsed(boolean value) {
        groupingUsed = value;
    }

    /**
     * Sets the maximum number of fraction digits that are printed when
     * formatting. If the maximum is less than the number of fraction digits,
     * the least significant digits are truncated.
     *
     * @param value
     *            the maximum number of fraction digits.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.900 -0500", hash_original_method = "8D829B5D993AE8CFC3165307650DC45D", hash_generated_method = "B569DFACE9B7661DCF2CC218F4A9078A")
    
public void setMaximumFractionDigits(int value) {
        maximumFractionDigits = value < 0 ? 0 : value;
        if (maximumFractionDigits < minimumFractionDigits) {
            minimumFractionDigits = maximumFractionDigits;
        }
    }

    /**
     * Sets the new maximum count of integer digits that are printed when
     * formatting. If the maximum is less than the number of integer digits, the
     * most significant digits are truncated.
     *
     * @param value
     *            the new maximum number of integer numerals for display.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.903 -0500", hash_original_method = "21B8BEFD42232423658838BAC20C84FE", hash_generated_method = "ADAEF0B22E852C749C9B69B0F7BCEAD0")
    
public void setMaximumIntegerDigits(int value) {
        maximumIntegerDigits = value < 0 ? 0 : value;
        if (maximumIntegerDigits < minimumIntegerDigits) {
            minimumIntegerDigits = maximumIntegerDigits;
        }
    }

    /**
     * Sets the minimum number of fraction digits that are printed when
     * formatting.
     *
     * @param value
     *            the minimum number of fraction digits.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.905 -0500", hash_original_method = "2004D453A285EC62847C50B61DD7CBAF", hash_generated_method = "A56F674E81424A2AB4EAA70DC723F231")
    
public void setMinimumFractionDigits(int value) {
        minimumFractionDigits = value < 0 ? 0 : value;
        if (maximumFractionDigits < minimumFractionDigits) {
            maximumFractionDigits = minimumFractionDigits;
        }
    }

    /**
     * Sets the minimum number of integer digits that are printed when
     * formatting.
     *
     * @param value
     *            the minimum number of integer digits.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.908 -0500", hash_original_method = "6D62345156926236ED68DA3CBABDD448", hash_generated_method = "19CD8D88E7CE0A1765C33B375854E3B2")
    
public void setMinimumIntegerDigits(int value) {
        minimumIntegerDigits = value < 0 ? 0 : value;
        if (maximumIntegerDigits < minimumIntegerDigits) {
            maximumIntegerDigits = minimumIntegerDigits;
        }
    }

    /**
     * Specifies if this number format should parse numbers only as integers or
     * else as any kind of number. If this method is called with a {@code true}
     * value then subsequent parsing attempts will stop if a decimal separator
     * is encountered.
     *
     * @param value
     *            {@code true} to only parse integers, {@code false} to parse
     *            integers as well as fractions.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.910 -0500", hash_original_method = "7914BBF7EC4F88E69DC0254980E5E100", hash_generated_method = "FBB00F66CC1AA5A8066677324DF2F235")
    
public void setParseIntegerOnly(boolean value) {
        parseIntegerOnly = value;
    }
    
    public static class Field extends Format.Field {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.922 -0500", hash_original_field = "0678BF01D3765E8C9254F90EF25B33B0", hash_generated_field = "E6808DCA2B613BACD85F5DF8A49842E5")

        private static final long serialVersionUID = 7494728892700160890L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.925 -0500", hash_original_field = "45E9A99C7A10B5137F72C9362AD46E33", hash_generated_field = "E67CF04835E7440B3B8255401771C5CD")

        public static final Field SIGN = new Field("sign");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.928 -0500", hash_original_field = "FE1EDF0407C53B6D15226A3C65750200", hash_generated_field = "3E710ACC9159D86DCBAEF807D5972AA9")

        public static final Field INTEGER = new Field("integer");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.931 -0500", hash_original_field = "54BAFCED1C3EE9C7C0902649BD28F399", hash_generated_field = "6E1A733B400A6EC7E2C2C43052CECE2A")

        public static final Field FRACTION = new Field("fraction");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.934 -0500", hash_original_field = "E4ED41620BC875231122EA3CFF499827", hash_generated_field = "319F9EC01C54BF39610B784926849985")

        public static final Field EXPONENT = new Field("exponent");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.937 -0500", hash_original_field = "903B7EF02FC7ADE982C5CF9DAD4984C5", hash_generated_field = "6F3344887D5C43063B3E3BB99EEA0438")

        public static final Field EXPONENT_SIGN = new Field("exponent sign");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.939 -0500", hash_original_field = "792E91CE72A89B97CCBA535EDC9BAA5B", hash_generated_field = "9DAFAC188978AAF54D1712AE1358211E")

        public static final Field EXPONENT_SYMBOL = new Field("exponent symbol");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.942 -0500", hash_original_field = "3E3CBF999EA211F6B90D7604023290B5", hash_generated_field = "7DA4CAE4944D7EA0085939A97D217F42")

        public static final Field DECIMAL_SEPARATOR = new Field("decimal separator");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.945 -0500", hash_original_field = "2159719EE402DDD0F55EE00BCD8101DF", hash_generated_field = "426A0B45CE473A2A95A3111A95B0BC93")

        public static final Field GROUPING_SEPARATOR = new Field("grouping separator");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.948 -0500", hash_original_field = "4C2AF59BE867C644B7E7DB7097C831C7", hash_generated_field = "8E65210094B4E3C543532347F9FF71EC")

        public static final Field PERCENT = new Field("percent");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.951 -0500", hash_original_field = "3CAA55A5EDFDC234C27497BD22A355F8", hash_generated_field = "E1C4AB1812D6EAA5813530289FF65B7E")

        public static final Field PERMILLE = new Field("per mille");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.953 -0500", hash_original_field = "FF7AEDAB1709C2F3E7BF306A6BB7F558", hash_generated_field = "4C849A2E4130CBE7D5EC854384ED9B8E")

        public static final Field CURRENCY = new Field("currency");

        /**
         * Constructs a new instance of {@code NumberFormat.Field} with the
         * given field name.
         *
         * @param fieldName
         *            the field name.
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.957 -0500", hash_original_method = "5600516370D16E6925F34153CC1B60B8", hash_generated_method = "8E9E2E9A1129AAE1C0A40E201C67690D")
        
protected Field(String fieldName) {
            super(fieldName);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.916 -0500", hash_original_method = "615BDCCE0F576CE8071CDC67AB896544", hash_generated_method = "A70ABE4F1C53A9973D21974F44EEE76B")
    
private void writeObject(ObjectOutputStream stream) throws IOException {
        ObjectOutputStream.PutField fields = stream.putFields();
        fields.put("groupingUsed", groupingUsed);
        fields.put("maxFractionDigits",
                        maximumFractionDigits < Byte.MAX_VALUE ? (byte) maximumFractionDigits
                                : Byte.MAX_VALUE);
        fields.put("maximumFractionDigits", maximumFractionDigits);
        fields.put("maximumIntegerDigits", maximumIntegerDigits);
        fields.put("maxIntegerDigits",
                        maximumIntegerDigits < Byte.MAX_VALUE ? (byte) maximumIntegerDigits
                                : Byte.MAX_VALUE);
        fields.put("minFractionDigits",
                        minimumFractionDigits < Byte.MAX_VALUE ? (byte) minimumFractionDigits
                                : Byte.MAX_VALUE);
        fields.put("minimumFractionDigits", minimumFractionDigits);
        fields.put("minimumIntegerDigits", minimumIntegerDigits);
        fields.put("minIntegerDigits",
                minimumIntegerDigits < Byte.MAX_VALUE ? (byte) minimumIntegerDigits : Byte.MAX_VALUE);
        fields.put("parseIntegerOnly", parseIntegerOnly);
        fields.put("serialVersionOnStream", 1);
        stream.writeFields();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.919 -0500", hash_original_method = "7CE1B061AB7260929E58BDEF36BC550E", hash_generated_method = "805A83CF8079AC7D43854BD7FE48F8BC")
    
private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        ObjectInputStream.GetField fields = stream.readFields();
        groupingUsed = fields.get("groupingUsed", true);
        parseIntegerOnly = fields.get("parseIntegerOnly", false);
        if (fields.get("serialVersionOnStream", 0) == 0) {
            maximumFractionDigits = fields.get("maxFractionDigits", (byte) 3);
            maximumIntegerDigits = fields.get("maxIntegerDigits", (byte) 40);
            minimumFractionDigits = fields.get("minFractionDigits", (byte) 0);
            minimumIntegerDigits = fields.get("minIntegerDigits", (byte) 1);
        } else {
            maximumFractionDigits = fields.get("maximumFractionDigits", 3);
            maximumIntegerDigits = fields.get("maximumIntegerDigits", 40);
            minimumFractionDigits = fields.get("minimumFractionDigits", 0);
            minimumIntegerDigits = fields.get("minimumIntegerDigits", 1);
        }
        if (minimumIntegerDigits > maximumIntegerDigits
                || minimumFractionDigits > maximumFractionDigits) {
            throw new InvalidObjectException("min digits greater than max digits");
        }
        if (minimumIntegerDigits < 0 || maximumIntegerDigits < 0
                || minimumFractionDigits < 0 || maximumFractionDigits < 0) {
            throw new InvalidObjectException("min or max digits negative");
        }
    }

    /**
     * Returns the {@code RoundingMode} used by this {@code NumberFormat}. The default
     * implementation in {@code NumberFormat} throws {@code UnsupportedOperationException}.
     * Subclasses for which a rounding mode is meaningful are expected to override this method.
     * @since 1.6
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.961 -0500", hash_original_method = "E6FF1C57537669874BDF42CE722EB942", hash_generated_method = "A98E2C85D6B752987990D28317616052")
    
public RoundingMode getRoundingMode() {
        throw new UnsupportedOperationException();
    }

    /**
     * Sets the {@code RoundingMode} used by this {@code NumberFormat}. The default
     * implementation in {@code NumberFormat} throws {@code UnsupportedOperationException}.
     * Subclasses for which a rounding mode is meaningful are expected to override this method.
     * @since 1.6
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.963 -0500", hash_original_method = "0C28590135419FD8FADCC2330801FC90", hash_generated_method = "059A5AEB4BFAC19B3AF46F11B93919BE")
    
public void setRoundingMode(RoundingMode roundingMode) {
        throw new UnsupportedOperationException();
    }
}

