package java.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Locale;

import libcore.icu.LocaleData;
import libcore.icu.NativeDecimalFormat;

public class DecimalFormat extends NumberFormat {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.788 -0500", hash_original_field = "7E9991E76AE7823245F4755D2CD04E34", hash_generated_field = "942EFADCEB0CE1279370395E6155A826")

    private static final long serialVersionUID = 864413376551465018L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.873 -0500", hash_original_field = "49E5436FA4A84D9C467485AABDE306FD", hash_generated_field = "932CCB84649F025E2FD30B1EDEB9D654")

    private static final Double NEGATIVE_ZERO_DOUBLE = new Double(-0.0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.922 -0500", hash_original_field = "B584027FAD5CBF24485B1BF95027D3DC", hash_generated_field = "27E2EF88F203E0B05638B8EC99836A70")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("positivePrefix", String.class),
        new ObjectStreamField("positiveSuffix", String.class),
        new ObjectStreamField("negativePrefix", String.class),
        new ObjectStreamField("negativeSuffix", String.class),
        new ObjectStreamField("posPrefixPattern", String.class),
        new ObjectStreamField("posSuffixPattern", String.class),
        new ObjectStreamField("negPrefixPattern", String.class),
        new ObjectStreamField("negSuffixPattern", String.class),
        new ObjectStreamField("multiplier", int.class),
        new ObjectStreamField("groupingSize", byte.class),
        new ObjectStreamField("groupingUsed", boolean.class),
        new ObjectStreamField("decimalSeparatorAlwaysShown", boolean.class),
        new ObjectStreamField("parseBigDecimal", boolean.class),
        new ObjectStreamField("roundingMode", RoundingMode.class),
        new ObjectStreamField("symbols", DecimalFormatSymbols.class),
        new ObjectStreamField("useExponentialNotation", boolean.class),
        new ObjectStreamField("minExponentDigits", byte.class),
        new ObjectStreamField("maximumIntegerDigits", int.class),
        new ObjectStreamField("minimumIntegerDigits", int.class),
        new ObjectStreamField("maximumFractionDigits", int.class),
        new ObjectStreamField("minimumFractionDigits", int.class),
        new ObjectStreamField("serialVersionOnStream", int.class),
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.791 -0500", hash_original_field = "C290400CD00A6BC2E6DE4CB472105427", hash_generated_field = "52EBB9EA358F4A29D5EE09E100128428")

    private transient DecimalFormatSymbols symbols;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.793 -0500", hash_original_field = "2D2126BF0AB22AEB6CD9FBDCCD0DC70F", hash_generated_field = "311D958CADB5DD8F5620B5C0287903DF")

    private transient NativeDecimalFormat dform;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.076 -0400", hash_original_field = "56B4B01527B4EB5F82F59EBDEC4AAB14", hash_generated_field = "13F8C455B70342D0BE0D104687A9B188")

    private final Object finalizerGuardian = new Object() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.076 -0400", hash_original_method = "1A366D9719473F2399B539B354BB787B", hash_generated_method = "ABC3A607675036C5172AEFC1575529C6")
        @Override
        protected void finalize() throws Throwable {
            try 
            {
                dform.close();
            } 
            finally 
            {
                super.finalize();
            }
            
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.801 -0500", hash_original_field = "1D26322835C5517479F83C610EBD2681", hash_generated_field = "F8D485A47161940F89EC9F4328B1DE40")

    private transient RoundingMode roundingMode = RoundingMode.HALF_EVEN;

    /**
     * Constructs a new {@code DecimalFormat} for formatting and parsing numbers
     * for the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.804 -0500", hash_original_method = "DE88C1883A924350E112FA17163006E9", hash_generated_method = "D51330D98971925D6233950BE92B368D")
    
public DecimalFormat() {
        Locale locale = Locale.getDefault();
        this.symbols = new DecimalFormatSymbols(locale);
        initNative(LocaleData.get(locale).numberPattern);
    }

    /**
     * Constructs a new {@code DecimalFormat} using the specified non-localized
     * pattern and the {@code DecimalFormatSymbols} for the user's default Locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     * @param pattern
     *            the non-localized pattern.
     * @throws IllegalArgumentException
     *            if the pattern cannot be parsed.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.806 -0500", hash_original_method = "35AB5293961F9B593ADD183E8B6B3242", hash_generated_method = "F48FB803D27D0D027D76017074F2D40B")
    
public DecimalFormat(String pattern) {
        this(pattern, Locale.getDefault());
    }

    /**
     * Constructs a new {@code DecimalFormat} using the specified non-localized
     * pattern and {@code DecimalFormatSymbols}.
     *
     * @param pattern
     *            the non-localized pattern.
     * @param value
     *            the DecimalFormatSymbols.
     * @throws IllegalArgumentException
     *            if the pattern cannot be parsed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.809 -0500", hash_original_method = "17CE9F29195C1874CE3535C0883BB7B4", hash_generated_method = "A85836C0CD45DD10A33224E7CE40C4EF")
    
public DecimalFormat(String pattern, DecimalFormatSymbols value) {
        this.symbols = (DecimalFormatSymbols) value.clone();
        initNative(pattern);
    }

    // Used by NumberFormat.getInstance because cloning DecimalFormatSymbols is slow.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.813 -0500", hash_original_method = "1EB8095DC5F926848B20CBA55F6BDD83", hash_generated_method = "1EB8095DC5F926848B20CBA55F6BDD83")
    
DecimalFormat(String pattern, Locale locale) {
        this.symbols = new DecimalFormatSymbols(locale);
        initNative(pattern);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.815 -0500", hash_original_method = "701B7114CA5711EBC62D39124CAE5412", hash_generated_method = "65215DD4918E44591DB836F46B724251")
    
private void initNative(String pattern) {
        try {
            this.dform = new NativeDecimalFormat(pattern, symbols);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(pattern);
        }
        super.setMaximumFractionDigits(dform.getMaximumFractionDigits());
        super.setMaximumIntegerDigits(dform.getMaximumIntegerDigits());
        super.setMinimumFractionDigits(dform.getMinimumFractionDigits());
        super.setMinimumIntegerDigits(dform.getMinimumIntegerDigits());
    }

    /**
     * Changes the pattern of this decimal format to the specified pattern which
     * uses localized pattern characters.
     *
     * @param pattern
     *            the localized pattern.
     * @throws IllegalArgumentException
     *            if the pattern cannot be parsed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.817 -0500", hash_original_method = "65449F4F2C00BF62B7AB916EB2126B60", hash_generated_method = "96254BD74FAC45D2698DDBC33FF69A6A")
    
public void applyLocalizedPattern(String pattern) {
        dform.applyLocalizedPattern(pattern);
    }

    /**
     * Changes the pattern of this decimal format to the specified pattern which
     * uses non-localized pattern characters.
     *
     * @param pattern
     *            the non-localized pattern.
     * @throws IllegalArgumentException
     *            if the pattern cannot be parsed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.820 -0500", hash_original_method = "09E7693F39B1CA310938A9A4756C1A20", hash_generated_method = "76383C728FF2574182D2F7D2FD4A1C71")
    
public void applyPattern(String pattern) {
        dform.applyPattern(pattern);
    }

    /**
     * Returns a new instance of {@code DecimalFormat} with the same pattern and
     * properties as this decimal format.
     *
     * @return a shallow copy of this decimal format.
     * @see java.lang.Cloneable
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.822 -0500", hash_original_method = "9257BEF78EF77BD305740BB055166BA8", hash_generated_method = "C4BB3F773677AF91ED1FF0116EBC17E9")
    
@Override
    public Object clone() {
        DecimalFormat clone = (DecimalFormat) super.clone();
        clone.dform = (NativeDecimalFormat) dform.clone();
        clone.symbols = (DecimalFormatSymbols) symbols.clone();
        return clone;
    }

    /**
     * Compares the specified object to this decimal format and indicates if
     * they are equal. In order to be equal, {@code object} must be an instance
     * of {@code DecimalFormat} with the same pattern and properties.
     *
     * @param object
     *            the object to compare with this object.
     * @return {@code true} if the specified object is equal to this decimal
     *         format; {@code false} otherwise.
     * @see #hashCode
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.825 -0500", hash_original_method = "6765E822C563E620DE26A0B6A028E00A", hash_generated_method = "7C64C8C7F9B39FA756BD042BF58FAE0F")
    
@Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DecimalFormat)) {
            return false;
        }
        DecimalFormat other = (DecimalFormat) object;
        return (this.dform == null ? other.dform == null : this.dform.equals(other.dform)) &&
                getDecimalFormatSymbols().equals(other.getDecimalFormatSymbols());
    }

    /**
     * Formats the specified object using the rules of this decimal format and
     * returns an {@code AttributedCharacterIterator} with the formatted number
     * and attributes.
     *
     * @param object
     *            the object to format.
     * @return an AttributedCharacterIterator with the formatted number and
     *         attributes.
     * @throws IllegalArgumentException
     *             if {@code object} cannot be formatted by this format.
     * @throws NullPointerException
     *             if {@code object} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.827 -0500", hash_original_method = "3B59068DE45E1D685899870F874FDB91", hash_generated_method = "A44E00164F8F58770AB0FC84E484EA35")
    
@Override
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        return dform.formatToCharacterIterator(object);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.830 -0500", hash_original_method = "FBA2DE4CAF4AAEBE0D141C6C51AFFE4A", hash_generated_method = "B8D5B1B73DDB78BD66EFF54ABA3D7DE2")
    
private void checkBufferAndFieldPosition(StringBuffer buffer, FieldPosition position) {
        if (buffer == null) {
            throw new NullPointerException("buffer == null");
        }
        if (position == null) {
            throw new NullPointerException("position == null");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.833 -0500", hash_original_method = "1E84E5D2AEBA1220C1C2BABB55EE58F4", hash_generated_method = "CC08B137CABC5E3F5A119088AA498DE7")
    
@Override
    public StringBuffer format(double value, StringBuffer buffer, FieldPosition position) {
        checkBufferAndFieldPosition(buffer, position);
        // All float/double/Float/Double formatting ends up here...
        if (roundingMode == RoundingMode.UNNECESSARY) {
            // ICU4C doesn't support this rounding mode, so we have to fake it.
            try {
                setRoundingMode(RoundingMode.UP);
                String upResult = format(value, new StringBuffer(), new FieldPosition(0)).toString();
                setRoundingMode(RoundingMode.DOWN);
                String downResult = format(value, new StringBuffer(), new FieldPosition(0)).toString();
                if (!upResult.equals(downResult)) {
                    throw new ArithmeticException("rounding mode UNNECESSARY but rounding required");
                }
            } finally {
                setRoundingMode(RoundingMode.UNNECESSARY);
            }
        }
        buffer.append(dform.formatDouble(value, position));
        return buffer;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.836 -0500", hash_original_method = "B4F0904648F2A25561C63568681C231B", hash_generated_method = "1421A118F090B51ED03E7088C729FD2B")
    
@Override
    public StringBuffer format(long value, StringBuffer buffer, FieldPosition position) {
        checkBufferAndFieldPosition(buffer, position);
        buffer.append(dform.formatLong(value, position));
        return buffer;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.839 -0500", hash_original_method = "9F0187C663B029586FEAEE5997EF0E8A", hash_generated_method = "DB7C629618142FE8ED290726CD35EC7B")
    
@Override
    public final StringBuffer format(Object number, StringBuffer buffer, FieldPosition position) {
        checkBufferAndFieldPosition(buffer, position);
        if (number instanceof BigInteger) {
            BigInteger bigInteger = (BigInteger) number;
            char[] chars = (bigInteger.bitLength() < 64)
                    ? dform.formatLong(bigInteger.longValue(), position)
                    : dform.formatBigInteger(bigInteger, position);
            buffer.append(chars);
            return buffer;
        } else if (number instanceof BigDecimal) {
            buffer.append(dform.formatBigDecimal((BigDecimal) number, position));
            return buffer;
        }
        return super.format(number, buffer, position);
    }

    /**
     * Returns the {@code DecimalFormatSymbols} used by this decimal format.
     *
     * @return a copy of the {@code DecimalFormatSymbols} used by this decimal
     *         format.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.841 -0500", hash_original_method = "8DCCB340D185077EABFD1E6BFE3DB36F", hash_generated_method = "1433923B36B9154D97E82E9D22FE1CE7")
    
public DecimalFormatSymbols getDecimalFormatSymbols() {
        return (DecimalFormatSymbols) symbols.clone();
    }

    /**
     * Returns the currency used by this decimal format.
     *
     * @return the currency used by this decimal format.
     * @see DecimalFormatSymbols#getCurrency()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.843 -0500", hash_original_method = "58EEC1F79BF01CD73E1939B30FC9554A", hash_generated_method = "2A671B166B9C52E05AEA409008D31548")
    
@Override
    public Currency getCurrency() {
        return symbols.getCurrency();
    }

    /**
     * Returns the number of digits grouped together by the grouping separator.
     * This only allows to get the primary grouping size. There is no API to get
     * the secondary grouping size.
     *
     * @return the number of digits grouped together.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.846 -0500", hash_original_method = "3224B3D9278B5F6729F4AC0FDDE7BC48", hash_generated_method = "7D3B4A6BB4FC8548C8F20EC568FF33BB")
    
public int getGroupingSize() {
        return dform.getGroupingSize();
    }

    /**
     * Returns the multiplier which is applied to the number before formatting
     * or after parsing.
     *
     * @return the multiplier.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.848 -0500", hash_original_method = "20055FC91A272014560FDC07D160C285", hash_generated_method = "609694A207934005FBE331D55076A117")
    
public int getMultiplier() {
        return dform.getMultiplier();
    }

    /**
     * Returns the prefix which is formatted or parsed before a negative number.
     *
     * @return the negative prefix.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.851 -0500", hash_original_method = "1F7C0591D1187101B5F5E6FCEBFE4BA7", hash_generated_method = "5C877E6936A26C55B8ED55C2EA134572")
    
public String getNegativePrefix() {
        return dform.getNegativePrefix();
    }

    /**
     * Returns the suffix which is formatted or parsed after a negative number.
     *
     * @return the negative suffix.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.853 -0500", hash_original_method = "61D6D48706CC87AEEF19B015AC798361", hash_generated_method = "E98B91806F33E1C69FFBF95588EEA304")
    
public String getNegativeSuffix() {
        return dform.getNegativeSuffix();
    }

    /**
     * Returns the prefix which is formatted or parsed before a positive number.
     *
     * @return the positive prefix.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.855 -0500", hash_original_method = "55B5FDB79399831D6973F7F1358A3E99", hash_generated_method = "6123F5F858C9E0A71F6C85B843802FDC")
    
public String getPositivePrefix() {
        return dform.getPositivePrefix();
    }

    /**
     * Returns the suffix which is formatted or parsed after a positive number.
     *
     * @return the positive suffix.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.857 -0500", hash_original_method = "2B5CAE95AEB5D456BD3378DDAC8D9097", hash_generated_method = "A930653E4CD5FFE5AF01038AAEF4DDA8")
    
public String getPositiveSuffix() {
        return dform.getPositiveSuffix();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.860 -0500", hash_original_method = "AC91BBA5B39870FB8DAE3ED8BCCB1730", hash_generated_method = "25C382E37F66403353F0A81E8581DA20")
    
@Override
    public int hashCode() {
        return dform.hashCode();
    }

    /**
     * Indicates whether the decimal separator is shown when there are no
     * fractional digits.
     *
     * @return {@code true} if the decimal separator should always be formatted;
     *         {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.862 -0500", hash_original_method = "43884003345D483D0CB1C79601B3CBE6", hash_generated_method = "F8236E4D227A3A5242329135E9E038B7")
    
public boolean isDecimalSeparatorAlwaysShown() {
        return dform.isDecimalSeparatorAlwaysShown();
    }

    /**
     * This value indicates whether the return object of the parse operation is
     * of type {@code BigDecimal}. This value defaults to {@code false}.
     *
     * @return {@code true} if parse always returns {@code BigDecimals},
     *         {@code false} if the type of the result is {@code Long} or
     *         {@code Double}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.864 -0500", hash_original_method = "0A7D24FF4B0BD9084E07584B0A08B543", hash_generated_method = "FABE7E60DE05AC71FD1F7CD62C16C421")
    
public boolean isParseBigDecimal() {
        return dform.isParseBigDecimal();
    }

    /**
     * Sets the flag that indicates whether numbers will be parsed as integers.
     * When this decimal format is used for parsing and this value is set to
     * {@code true}, then the resulting numbers will be of type
     * {@code java.lang.Integer}. Special cases are NaN, positive and negative
     * infinity, which are still returned as {@code java.lang.Double}.
     *
     *
     * @param value
     *            {@code true} that the resulting numbers of parse operations
     *            will be of type {@code java.lang.Integer} except for the
     *            special cases described above.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.867 -0500", hash_original_method = "7481DA5537EE3F9956B6D5D3C7A225D0", hash_generated_method = "96EEA52003F882ABA75B21AC104A853A")
    
@Override
    public void setParseIntegerOnly(boolean value) {
        // In this implementation, NativeDecimalFormat is wrapped to
        // fulfill most of the format and parse feature. And this method is
        // delegated to the wrapped instance of NativeDecimalFormat.
        dform.setParseIntegerOnly(value);
    }

    /**
     * Indicates whether parsing with this decimal format will only
     * return numbers of type {@code java.lang.Integer}.
     *
     * @return {@code true} if this {@code DecimalFormat}'s parse method only
     *         returns {@code java.lang.Integer}; {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.870 -0500", hash_original_method = "4A357353F9630D5720A9D39DD6F8D4E6", hash_generated_method = "78947B70437FB395436B116C18890419")
    
@Override
    public boolean isParseIntegerOnly() {
        return dform.isParseIntegerOnly();
    }

    /**
     * Parses a {@code Long} or {@code Double} from the specified string
     * starting at the index specified by {@code position}. If the string is
     * successfully parsed then the index of the {@code ParsePosition} is
     * updated to the index following the parsed text. On error, the index is
     * unchanged and the error index of {@code ParsePosition} is set to the
     * index where the error occurred.
     *
     * @param string
     *            the string to parse.
     * @param position
     *            input/output parameter, specifies the start index in
     *            {@code string} from where to start parsing. If parsing is
     *            successful, it is updated with the index following the parsed
     *            text; on error, the index is unchanged and the error index is
     *            set to the index where the error occurred.
     * @return a {@code Long} or {@code Double} resulting from the parse or
     *         {@code null} if there is an error. The result will be a
     *         {@code Long} if the parsed number is an integer in the range of a
     *         long, otherwise the result is a {@code Double}. If
     *         {@code isParseBigDecimal} is {@code true} then it returns the
     *         result as a {@code BigDecimal}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.876 -0500", hash_original_method = "5624B977416508FD6FAAB26F049D0D1B", hash_generated_method = "77AD9311E4254A4E0E08C40873CE4706")
    
@Override
    public Number parse(String string, ParsePosition position) {
        Number number = dform.parse(string, position);
        if (number == null) {
            return null;
        }
        if (this.isParseBigDecimal()) {
            if (number instanceof Long) {
                return new BigDecimal(number.longValue());
            }
            if ((number instanceof Double) && !((Double) number).isInfinite()
                    && !((Double) number).isNaN()) {

                return new BigDecimal(number.toString());
            }
            if (number instanceof BigInteger) {
                return new BigDecimal(number.toString());
            }
            return number;
        }
        if ((number instanceof BigDecimal) || (number instanceof BigInteger)) {
            return new Double(number.doubleValue());
        }
        if (this.isParseIntegerOnly() && number.equals(NEGATIVE_ZERO_DOUBLE)) {
            return Long.valueOf(0);
        }
        return number;

    }

    /**
     * Sets the {@code DecimalFormatSymbols} used by this decimal format.
     *
     * @param value
     *            the {@code DecimalFormatSymbols} to set.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.878 -0500", hash_original_method = "86D86A0FD4BCEEB43D34AB98DA52821C", hash_generated_method = "ABDCE81DD5C3B5AB0732C3F903CDAF3F")
    
public void setDecimalFormatSymbols(DecimalFormatSymbols value) {
        if (value != null) {
            // The Java object is canonical, and we copy down to native code.
            this.symbols = (DecimalFormatSymbols) value.clone();
            dform.setDecimalFormatSymbols(this.symbols);
        }
    }

    /**
     * Sets the currency used by this decimal format. The min and max fraction
     * digits remain the same.
     *
     * @param currency
     *            the currency this {@code DecimalFormat} should use.
     * @see DecimalFormatSymbols#setCurrency(Currency)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.880 -0500", hash_original_method = "4395CDF7142532C86BE10F65050BB217", hash_generated_method = "9E20FF6281BB59E1A6BD1061B4B24737")
    
@Override
    public void setCurrency(Currency currency) {
        dform.setCurrency(Currency.getInstance(currency.getCurrencyCode()));
        symbols.setCurrency(currency);
    }

    /**
     * Sets whether the decimal separator is shown when there are no fractional
     * digits.
     *
     * @param value
     *            {@code true} if the decimal separator should always be
     *            formatted; {@code false} otherwise.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.882 -0500", hash_original_method = "3B253ED7615AA8E014EF753B3801D05C", hash_generated_method = "060F41BAE7BBC4890552C3951687DD37")
    
public void setDecimalSeparatorAlwaysShown(boolean value) {
        dform.setDecimalSeparatorAlwaysShown(value);
    }

    /**
     * Sets the number of digits grouped together by the grouping separator.
     * This only allows to set the primary grouping size; the secondary grouping
     * size can only be set with a pattern.
     *
     * @param value
     *            the number of digits grouped together.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.884 -0500", hash_original_method = "C7D074F8D378A670A8F54B2C99810E6C", hash_generated_method = "3D87E646FC705306EBDAD2F06F9DFEB8")
    
public void setGroupingSize(int value) {
        dform.setGroupingSize(value);
    }

    /**
     * Sets whether or not grouping will be used in this format. Grouping
     * affects both parsing and formatting.
     *
     * @param value
     *            {@code true} if grouping is used; {@code false} otherwise.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.887 -0500", hash_original_method = "ABE655961F79B3C1FE3443634AA21C37", hash_generated_method = "91004DDDF771A6CC7CFB13627495F367")
    
@Override
    public void setGroupingUsed(boolean value) {
        dform.setGroupingUsed(value);
    }

    /**
     * Indicates whether grouping will be used in this format.
     *
     * @return {@code true} if grouping is used; {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.889 -0500", hash_original_method = "47F90CF51661FE278576148D8412D8DA", hash_generated_method = "630F52B46C2356B6C4E27989C8E6C819")
    
@Override
    public boolean isGroupingUsed() {
        return dform.isGroupingUsed();
    }

    /**
     * Sets the maximum number of digits after the decimal point.
     * If the value passed is negative then it is replaced by 0.
     * Regardless of this setting, no more than 340 digits will be used.
     *
     * @param value the maximum number of fraction digits.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.892 -0500", hash_original_method = "D0C418C01DBD33DD29A18941B68BCBF7", hash_generated_method = "1C7EB6C8394959EECD4657CE2A97FE38")
    
@Override
    public void setMaximumFractionDigits(int value) {
        super.setMaximumFractionDigits(value);
        dform.setMaximumFractionDigits(getMaximumFractionDigits());
        // Changing the maximum fraction digits needs to update ICU4C's rounding configuration.
        setRoundingMode(roundingMode);
    }

    /**
     * Sets the maximum number of digits before the decimal point.
     * If the value passed is negative then it is replaced by 0.
     * Regardless of this setting, no more than 309 digits will be used.
     *
     * @param value the maximum number of integer digits.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.895 -0500", hash_original_method = "D5AFAB41905B13F7AD20D2FADDE73669", hash_generated_method = "836F4C4A51D27A61D4C060CA61C33E7B")
    
@Override
    public void setMaximumIntegerDigits(int value) {
        super.setMaximumIntegerDigits(value);
        dform.setMaximumIntegerDigits(getMaximumIntegerDigits());
    }

    /**
     * Sets the minimum number of digits after the decimal point.
     * If the value passed is negative then it is replaced by 0.
     * Regardless of this setting, no more than 340 digits will be used.
     *
     * @param value the minimum number of fraction digits.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.897 -0500", hash_original_method = "9EB52B7EEE1D2B50BAA9500CCA3AFB4E", hash_generated_method = "2E01BA5752DCDC86BCBE258A1F10D793")
    
@Override
    public void setMinimumFractionDigits(int value) {
        super.setMinimumFractionDigits(value);
        dform.setMinimumFractionDigits(getMinimumFractionDigits());
    }

    /**
     * Sets the minimum number of digits before the decimal point.
     * If the value passed is negative then it is replaced by 0.
     * Regardless of this setting, no more than 309 digits will be used.
     *
     * @param value the minimum number of integer digits.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.901 -0500", hash_original_method = "6EFC03984672E7D89A36C9F22F2AAB3B", hash_generated_method = "F01D9D9066CB5833B173FA2BD15528ED")
    
@Override
    public void setMinimumIntegerDigits(int value) {
        super.setMinimumIntegerDigits(value);
        dform.setMinimumIntegerDigits(getMinimumIntegerDigits());
    }

    /**
     * Sets the multiplier which is applied to the number before formatting or
     * after parsing.
     *
     * @param value
     *            the multiplier.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.903 -0500", hash_original_method = "2E4C739E2F1CFFD7C6A061AD5BB9ADF4", hash_generated_method = "F52AB94F5BFF1732FE3D52414C16FB4B")
    
public void setMultiplier(int value) {
        dform.setMultiplier(value);
    }

    /**
     * Sets the prefix which is formatted or parsed before a negative number.
     *
     * @param value
     *            the negative prefix.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.905 -0500", hash_original_method = "2C739DF56DF29E81D815FC52FA901BFF", hash_generated_method = "EF37A221B1E24DB8C1D8DAE150DD672E")
    
public void setNegativePrefix(String value) {
        dform.setNegativePrefix(value);
    }

    /**
     * Sets the suffix which is formatted or parsed after a negative number.
     *
     * @param value
     *            the negative suffix.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.907 -0500", hash_original_method = "A51B4E91EE1B92D26334E28FF3A003CC", hash_generated_method = "0C504B3533959647AE16EF7F33AA9734")
    
public void setNegativeSuffix(String value) {
        dform.setNegativeSuffix(value);
    }

    /**
     * Sets the prefix which is formatted or parsed before a positive number.
     *
     * @param value
     *            the positive prefix.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.910 -0500", hash_original_method = "7DA87D841FEB1EB829AC578209C7D87B", hash_generated_method = "518FFAC2C72B0CF0D4BC6FDEDECE4039")
    
public void setPositivePrefix(String value) {
        dform.setPositivePrefix(value);
    }

    /**
     * Sets the suffix which is formatted or parsed after a positive number.
     *
     * @param value
     *            the positive suffix.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.912 -0500", hash_original_method = "740675349A091E1D283FD9B9350AE3AA", hash_generated_method = "3564C6115BA1159AF36A66E4124816C6")
    
public void setPositiveSuffix(String value) {
        dform.setPositiveSuffix(value);
    }

    /**
     * Sets the behavior of the parse method. If set to {@code true} then all
     * the returned objects will be of type {@code BigDecimal}.
     *
     * @param newValue
     *            {@code true} if all the returned objects should be of type
     *            {@code BigDecimal}; {@code false} otherwise.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.914 -0500", hash_original_method = "DD680A2A91BAA011B854EB3CE1AE2AEF", hash_generated_method = "93345C76FD275887E99A63959B05FBDB")
    
public void setParseBigDecimal(boolean newValue) {
        dform.setParseBigDecimal(newValue);
    }

    /**
     * Returns the pattern of this decimal format using localized pattern
     * characters.
     *
     * @return the localized pattern.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.917 -0500", hash_original_method = "487E11DF64E483CD2A017195603FADD0", hash_generated_method = "70F3AF058A1932CBC6406A58EB67A151")
    
public String toLocalizedPattern() {
        return dform.toLocalizedPattern();
    }

    /**
     * Returns the pattern of this decimal format using non-localized pattern
     * characters.
     *
     * @return the non-localized pattern.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.919 -0500", hash_original_method = "588A1CECAAE48251BC4F5156DD9C9A13", hash_generated_method = "CEBFB24A422FFCDC1E0BF9115BA5B2CE")
    
public String toPattern() {
        return dform.toPattern();
    }

    /**
     * Writes serialized fields following serialized forms specified by Java
     * specification.
     *
     * @param stream
     *            the output stream to write serialized bytes
     * @throws IOException
     *             if some I/O error occurs
     * @throws ClassNotFoundException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.925 -0500", hash_original_method = "5BC6394F5F5C73D6097502885E125B6B", hash_generated_method = "084A9AC1CC7A4235E57585946A2F7B65")
    
private void writeObject(ObjectOutputStream stream) throws IOException, ClassNotFoundException {
        ObjectOutputStream.PutField fields = stream.putFields();
        fields.put("positivePrefix", dform.getPositivePrefix());
        fields.put("positiveSuffix", dform.getPositiveSuffix());
        fields.put("negativePrefix", dform.getNegativePrefix());
        fields.put("negativeSuffix", dform.getNegativeSuffix());
        fields.put("posPrefixPattern", (String) null);
        fields.put("posSuffixPattern", (String) null);
        fields.put("negPrefixPattern", (String) null);
        fields.put("negSuffixPattern", (String) null);
        fields.put("multiplier", dform.getMultiplier());
        fields.put("groupingSize", (byte) dform.getGroupingSize());
        fields.put("groupingUsed", dform.isGroupingUsed());
        fields.put("decimalSeparatorAlwaysShown", dform.isDecimalSeparatorAlwaysShown());
        fields.put("parseBigDecimal", dform.isParseBigDecimal());
        fields.put("roundingMode", roundingMode);
        fields.put("symbols", symbols);
        fields.put("useExponentialNotation", false);
        fields.put("minExponentDigits", (byte) 0);
        fields.put("maximumIntegerDigits", dform.getMaximumIntegerDigits());
        fields.put("minimumIntegerDigits", dform.getMinimumIntegerDigits());
        fields.put("maximumFractionDigits", dform.getMaximumFractionDigits());
        fields.put("minimumFractionDigits", dform.getMinimumFractionDigits());
        fields.put("serialVersionOnStream", 4);
        stream.writeFields();
    }

    /**
     * Reads serialized fields following serialized forms specified by Java
     * specification.
     *
     * @param stream
     *            the input stream to read serialized bytes
     * @throws IOException
     *             if some I/O error occurs
     * @throws ClassNotFoundException
     *             if some class of serialized objects or fields cannot be found
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.928 -0500", hash_original_method = "779EB6B3B1C2B5888DC5BF2D6BFB0D9C", hash_generated_method = "1485D1EE3803384825CD7777F357EBE6")
    
private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = stream.readFields();
        this.symbols = (DecimalFormatSymbols) fields.get("symbols", null);

        initNative("");
        dform.setPositivePrefix((String) fields.get("positivePrefix", ""));
        dform.setPositiveSuffix((String) fields.get("positiveSuffix", ""));
        dform.setNegativePrefix((String) fields.get("negativePrefix", "-"));
        dform.setNegativeSuffix((String) fields.get("negativeSuffix", ""));
        dform.setMultiplier(fields.get("multiplier", 1));
        dform.setGroupingSize(fields.get("groupingSize", (byte) 3));
        dform.setGroupingUsed(fields.get("groupingUsed", true));
        dform.setDecimalSeparatorAlwaysShown(fields.get("decimalSeparatorAlwaysShown", false));

        setRoundingMode((RoundingMode) fields.get("roundingMode", RoundingMode.HALF_EVEN));

        final int maximumIntegerDigits = fields.get("maximumIntegerDigits", 309);
        final int minimumIntegerDigits = fields.get("minimumIntegerDigits", 309);
        final int maximumFractionDigits = fields.get("maximumFractionDigits", 340);
        final int minimumFractionDigits = fields.get("minimumFractionDigits", 340);
        // Tell ICU what we want, then ask it what we can have, and then
        // set that in our Java object. This isn't RI-compatible, but then very little of our
        // behavior in this area is, and it's not obvious how we can second-guess ICU (or tell
        // it to just do exactly what we ask). We only need to do this with maximumIntegerDigits
        // because ICU doesn't seem to have its own ideas about the other options.
        dform.setMaximumIntegerDigits(maximumIntegerDigits);
        super.setMaximumIntegerDigits(dform.getMaximumIntegerDigits());

        setMinimumIntegerDigits(minimumIntegerDigits);
        setMinimumFractionDigits(minimumFractionDigits);
        setMaximumFractionDigits(maximumFractionDigits);
        setParseBigDecimal(fields.get("parseBigDecimal", false));

        if (fields.get("serialVersionOnStream", 0) < 3) {
            setMaximumIntegerDigits(super.getMaximumIntegerDigits());
            setMinimumIntegerDigits(super.getMinimumIntegerDigits());
            setMaximumFractionDigits(super.getMaximumFractionDigits());
            setMinimumFractionDigits(super.getMinimumFractionDigits());
        }
    }

    /**
     * Returns the {@code RoundingMode} used by this {@code NumberFormat}.
     * @since 1.6
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.931 -0500", hash_original_method = "665DD451D3753ACD20842BCA4E3EB32E", hash_generated_method = "6D523F860AF5DA84DA6E20F0C7E0AAFA")
    
public RoundingMode getRoundingMode() {
        return roundingMode;
    }

    /**
     * Sets the {@code RoundingMode} used by this {@code NumberFormat}.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.933 -0500", hash_original_method = "91D8E7B9A007769AA087DAF2CAD1ADF8", hash_generated_method = "9D2CE860777B487832B5BF4459D353E7")
    
public void setRoundingMode(RoundingMode roundingMode) {
        if (roundingMode == null) {
            throw new NullPointerException();
        }
        this.roundingMode = roundingMode;
        if (roundingMode != RoundingMode.UNNECESSARY) { // ICU4C doesn't support UNNECESSARY.
            double roundingIncrement = 1.0 / Math.pow(10, Math.max(0, getMaximumFractionDigits()));
            dform.setRoundingMode(roundingMode, roundingIncrement);
        }
    }
}

