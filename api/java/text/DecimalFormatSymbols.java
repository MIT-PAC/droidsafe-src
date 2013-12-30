package java.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Currency;
import java.util.Locale;

import libcore.icu.ICU;
import libcore.icu.LocaleData;





public class DecimalFormatSymbols implements Cloneable, Serializable {

    /**
     * Returns a new {@code DecimalFormatSymbols} instance for the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     *
     * @return an instance of {@code DecimalFormatSymbols}
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.781 -0500", hash_original_method = "A20804536D1BB58CF64F5D4344E1058E", hash_generated_method = "A0E365D64745B645D76306204BE1E035")
    
public static DecimalFormatSymbols getInstance() {
        return getInstance(Locale.getDefault());
    }

    /**
     * Returns a new {@code DecimalFormatSymbols} for the given locale.
     *
     * @param locale the locale
     * @return an instance of {@code DecimalFormatSymbols}
     * @throws NullPointerException if {@code locale == null}
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.784 -0500", hash_original_method = "AAE245E8122356AE5E986468622585C0", hash_generated_method = "B356C861F459952B5AA0BDB0997162C9")
    
public static DecimalFormatSymbols getInstance(Locale locale) {
        if (locale == null) {
            throw new NullPointerException();
        }
        return new DecimalFormatSymbols(locale);
    }

    /**
     * Returns an array of locales for which custom {@code DecimalFormatSymbols} instances
     * are available.
     * <p>Note that Android does not support user-supplied locale service providers.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.787 -0500", hash_original_method = "623079C002E398EE5B17BE6978E7428C", hash_generated_method = "01AF92D5F3A729A167059F795E08D11C")
    
public static Locale[] getAvailableLocales() {
        return ICU.getAvailableDecimalFormatSymbolsLocales();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.743 -0500", hash_original_field = "DEC7F81DBB7C8E8A2129C36644CFB821", hash_generated_field = "87839485C41D69D54758762801BECCB5")


    private static final long serialVersionUID = 5772796243397350300L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.872 -0500", hash_original_field = "AAEC829649AFAD53E27ED73916572C13", hash_generated_field = "EBF01AA379088E4ACAF6533F65E738B5")


    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("currencySymbol", String.class),
        new ObjectStreamField("decimalSeparator", char.class),
        new ObjectStreamField("digit", char.class),
        new ObjectStreamField("exponential", char.class),
        new ObjectStreamField("exponentialSeparator", String.class),
        new ObjectStreamField("groupingSeparator", char.class),
        new ObjectStreamField("infinity", String.class),
        new ObjectStreamField("intlCurrencySymbol", String.class),
        new ObjectStreamField("minusSign", char.class),
        new ObjectStreamField("monetarySeparator", char.class),
        new ObjectStreamField("NaN", String.class),
        new ObjectStreamField("patternSeparator", char.class),
        new ObjectStreamField("percent", char.class),
        new ObjectStreamField("perMill", char.class),
        new ObjectStreamField("serialVersionOnStream", int.class),
        new ObjectStreamField("zeroDigit", char.class),
        new ObjectStreamField("locale", Locale.class),
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.745 -0500", hash_original_field = "17DFD5FF22509500C57E1B2A7C4E9225", hash_generated_field = "182114D634E44B2F9FF8FA9BEA6A2670")


    private char zeroDigit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.747 -0500", hash_original_field = "1D18153132F04D5683051E104D9B8317", hash_generated_field = "6CB8DCB59FFD8713E9C1C344A13F088C")

    private char digit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.749 -0500", hash_original_field = "1038FD332ED44A7DF96FEF42F0B6917E", hash_generated_field = "E461D5D24B0D46970F3080026F5DAB3B")

    private char decimalSeparator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.751 -0500", hash_original_field = "387522DF55114ECCD5B758AE0FB4960A", hash_generated_field = "5568C6DB84C3654DEE73CAFF55A6B581")

    private char groupingSeparator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.753 -0500", hash_original_field = "5C37B6EBDB9BD228E12EA493827F167B", hash_generated_field = "6DF33D45ABDB8FE2C16C7A6B5B22148B")

    private char patternSeparator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.756 -0500", hash_original_field = "3F2A0F7E47175E72985257908756B0D4", hash_generated_field = "35D478E85B6B0AC367D6451335AED786")

    private char percent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.758 -0500", hash_original_field = "362DA8A2EA348381739AA1AA9E01F08D", hash_generated_field = "83CD8C34421477BE2D582B86E50D13B3")

    private char perMill;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.761 -0500", hash_original_field = "CB2E5B66AD2B613B8806B2371335452C", hash_generated_field = "BE354A6C767B6735025B72C2F3218447")

    private char monetarySeparator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.763 -0500", hash_original_field = "1D678252731BB3F550006E1A687D6282", hash_generated_field = "418B8DC329FE67FA16666E2093EA0558")

    private char minusSign;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.466 -0400", hash_original_field = "F2FDEE93271556E428DD9507B3DA7235", hash_generated_field = "E87067D299572259E6A5A50B5C50F402")

    private String infinity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.466 -0400", hash_original_field = "7ECFB3BF076A6A9635F975FE96AC97FD", hash_generated_field = "84564C16EC7DF5A18776A88E04BB85F2")

    private String NaN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.467 -0400", hash_original_field = "C5613A5A91579972FBAE451ACABEB080", hash_generated_field = "9155F1D4247E37AE2D732FFAE046AD76")

    private String currencySymbol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.467 -0400", hash_original_field = "880FF64D34B5489D22BD4683FE484CE8", hash_generated_field = "A7BD4117286329CC7FB1D92F79A53FB8")

    private String intlCurrencySymbol;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.768 -0500", hash_original_field = "4824C6AE0AB3D4E6EAB349F40A4DF6DC", hash_generated_field = "E59704290C574597EDF0C1232CAFF8C9")


    private transient Currency currency;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.770 -0500", hash_original_field = "A25411C3C357716626A9185E220A5EAA", hash_generated_field = "28E42E34FE73475FADA137DE37E55757")

    private transient Locale locale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.773 -0500", hash_original_field = "D6E7D74106B64434AFE81AD1BEF608B8", hash_generated_field = "3597EF8DA5A09BA6DA4C6C1E5177AE99")

    private transient String exponentSeparator;

    /**
     * Constructs a new {@code DecimalFormatSymbols} containing the symbols for
     * the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     * Best practice is to create a {@code DecimalFormat}
     * and then to get the {@code DecimalFormatSymbols} from that object by
     * calling {@link DecimalFormat#getDecimalFormatSymbols()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.776 -0500", hash_original_method = "91524EB1B511A6593A9E4C16AA4F2798", hash_generated_method = "18B877D5D8D56D5FF678E24B31018039")
    
public DecimalFormatSymbols() {
        this(Locale.getDefault());
    }

    /**
     * Constructs a new DecimalFormatSymbols containing the symbols for the
     * specified Locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     * Best practice is to create a {@code DecimalFormat}
     * and then to get the {@code DecimalFormatSymbols} from that object by
     * calling {@link DecimalFormat#getDecimalFormatSymbols()}.
     *
     * @param locale
     *            the locale.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.779 -0500", hash_original_method = "0AEA27B26006219100D92BC0021E5648", hash_generated_method = "A0434FD7C814BA7DA2DF56002EC17FE9")
    
public DecimalFormatSymbols(Locale locale) {
        LocaleData localeData = LocaleData.get(locale);
        this.zeroDigit = localeData.zeroDigit;
        this.digit = '#';
        this.decimalSeparator = localeData.decimalSeparator;
        this.groupingSeparator = localeData.groupingSeparator;
        this.patternSeparator = localeData.patternSeparator;
        this.percent = localeData.percent;
        this.perMill = localeData.perMill;
        this.monetarySeparator = localeData.monetarySeparator;
        this.minusSign = localeData.minusSign;
        this.infinity = localeData.infinity;
        this.NaN = localeData.NaN;
        this.exponentSeparator = localeData.exponentSeparator;
        this.locale = locale;
        try {
            currency = Currency.getInstance(locale);
            currencySymbol = currency.getSymbol(locale);
            intlCurrencySymbol = currency.getCurrencyCode();
        } catch (IllegalArgumentException e) {
            currency = Currency.getInstance("XXX");
            currencySymbol = localeData.currencySymbol;
            intlCurrencySymbol = localeData.internationalCurrencySymbol;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.789 -0500", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "88F588A1F8F1E65DC62D9CB72E24BF48")
    
@Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /**
     * Compares the specified object to this {@code DecimalFormatSymbols} and
     * indicates if they are equal. In order to be equal, {@code object} must be
     * an instance of {@code DecimalFormatSymbols} and contain the same symbols.
     *
     * @param object
     *            the object to compare with this object.
     * @return {@code true} if the specified object is equal to this
     *         {@code DecimalFormatSymbols}; {@code false} otherwise.
     * @see #hashCode
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.792 -0500", hash_original_method = "B3296A7E858EAC27CB28889E1F7A56D1", hash_generated_method = "CBF1B05DA5600F535EC27909B797280E")
    
@Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DecimalFormatSymbols)) {
            return false;
        }
        DecimalFormatSymbols obj = (DecimalFormatSymbols) object;
        return currency.equals(obj.currency) &&
                currencySymbol.equals(obj.currencySymbol) &&
                decimalSeparator == obj.decimalSeparator &&
                digit == obj.digit &&
                exponentSeparator.equals(obj.exponentSeparator) &&
                groupingSeparator == obj.groupingSeparator &&
                infinity.equals(obj.infinity) &&
                intlCurrencySymbol.equals(obj.intlCurrencySymbol) &&
                minusSign == obj.minusSign &&
                monetarySeparator == obj.monetarySeparator &&
                NaN.equals(obj.NaN) &&
                patternSeparator == obj.patternSeparator &&
                perMill == obj.perMill &&
                percent == obj.percent &&
                zeroDigit == obj.zeroDigit;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.794 -0500", hash_original_method = "A8625956386363E3EFDBA37B24F1F247", hash_generated_method = "8216705CD4CCA28793FEEF710E7CD1DD")
    
@Override
    public String toString() {
        return getClass().getName() +
                "[currency=" + currency +
                ",currencySymbol=" + currencySymbol +
                ",decimalSeparator=" + decimalSeparator +
                ",digit=" + digit +
                ",exponentSeparator=" + exponentSeparator +
                ",groupingSeparator=" + groupingSeparator +
                ",infinity=" + infinity +
                ",intlCurrencySymbol=" + intlCurrencySymbol +
                ",minusSign=" + minusSign +
                ",monetarySeparator=" + monetarySeparator +
                ",NaN=" + NaN +
                ",patternSeparator=" + patternSeparator +
                ",perMill=" + perMill +
                ",percent=" + percent +
                ",zeroDigit=" + zeroDigit +
                "]";
    }

    /**
     * Returns the currency.
     * <p>
     * {@code null} is returned if {@code setInternationalCurrencySymbol()} has
     * been previously called with a value that is not a valid ISO 4217 currency
     * code.
     * <p>
     *
     * @return the currency that was set in the constructor or by calling
     *         {@code setCurrency()} or {@code setInternationalCurrencySymbol()},
     *         or {@code null} if an invalid currency was set.
     * @see #setCurrency(Currency)
     * @see #setInternationalCurrencySymbol(String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.796 -0500", hash_original_method = "595F433D4A540AB9FD57454DFC2D00CA", hash_generated_method = "C108EADF2D86F77DBDD7939A80A9D62E")
    
public Currency getCurrency() {
        return currency;
    }

    /**
     * Returns the international currency symbol.
     *
     * @return the international currency symbol as string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.799 -0500", hash_original_method = "9A7223B2A10801087A5753E160EB5AD9", hash_generated_method = "76F084A7B15F57C9EFBA142A75D537A6")
    
public String getInternationalCurrencySymbol() {
        return intlCurrencySymbol;
    }

    /**
     * Returns the currency symbol.
     *
     * @return the currency symbol as string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.802 -0500", hash_original_method = "44BA6DF186734A9129EE433C5393A649", hash_generated_method = "70DFB06488352B3435EF25CDCFB10A53")
    
public String getCurrencySymbol() {
        return currencySymbol;
    }

    /**
     * Returns the character which represents the decimal point in a number.
     *
     * @return the decimal separator character.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.804 -0500", hash_original_method = "C908C2BC77C07C5C3074706ADD440EBB", hash_generated_method = "E0DBE9B544DF8DC659ED0BE34920CF24")
    
public char getDecimalSeparator() {
        return decimalSeparator;
    }

    /**
     * Returns the character which represents a single digit in a format
     * pattern.
     *
     * @return the digit pattern character.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.807 -0500", hash_original_method = "4E80424FBB82914FDC63C744E843DFA5", hash_generated_method = "C49B1F0A349E4E8C7B596F16DD88DA0D")
    
public char getDigit() {
        return digit;
    }

    /**
     * Returns the character used as the thousands separator in a number.
     *
     * @return the thousands separator character.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.809 -0500", hash_original_method = "0D8DAB63E4E740341CDDC10B95F6771D", hash_generated_method = "DEF4D752D3653A40ABE08847F5944803")
    
public char getGroupingSeparator() {
        return groupingSeparator;
    }

    /**
     * Returns the string which represents infinity.
     *
     * @return the infinity symbol as a string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.811 -0500", hash_original_method = "195513F858098AF1B8C98F122DD853CE", hash_generated_method = "27AB5D9A5F597EF9618F1A7FEBBBBB87")
    
public String getInfinity() {
        return infinity;
    }

    /**
     * Returns the minus sign character.
     *
     * @return the minus sign as a character.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.813 -0500", hash_original_method = "B02DD985FFD3C706D5501C97C0FC9E68", hash_generated_method = "894B9783BEFD2D11F1FCB9633D1EB03A")
    
public char getMinusSign() {
        return minusSign;
    }

    /**
     * Returns the character which represents the decimal point in a monetary
     * value.
     *
     * @return the monetary decimal point as a character.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.816 -0500", hash_original_method = "C02AEBD6916CB8991D4B6D1CCA4BA867", hash_generated_method = "40FC08D0C79CF6C8B7891E6A23FBF834")
    
public char getMonetaryDecimalSeparator() {
        return monetarySeparator;
    }

    /**
     * Returns the string which represents NaN.
     *
     * @return the symbol NaN as a string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.818 -0500", hash_original_method = "A7A5B5565C9E586C08E861055D3F830D", hash_generated_method = "50D88620192950A49432BD9A7F4D15AA")
    
public String getNaN() {
        return NaN;
    }

    /**
     * Returns the character which separates the positive and negative patterns
     * in a format pattern.
     *
     * @return the pattern separator character.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.820 -0500", hash_original_method = "D38F7AE8E1369570AEDB785398752C04", hash_generated_method = "ED7D742D64874057D70983B049FCE9CB")
    
public char getPatternSeparator() {
        return patternSeparator;
    }

    /**
     * Returns the percent character.
     *
     * @return the percent character.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.822 -0500", hash_original_method = "0F05A385A7483224A3B3B115F4941DEA", hash_generated_method = "191ACF0D69C3AF2B2A79760C31DE867C")
    
public char getPercent() {
        return percent;
    }

    /**
     * Returns the per mill sign character.
     *
     * @return the per mill sign character.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.824 -0500", hash_original_method = "DDC83740D050E65F948D715CA46AA4E6", hash_generated_method = "9E510AF2F024D1B04872F06D70B8EB92")
    
public char getPerMill() {
        return perMill;
    }

    /**
     * Returns the character which represents zero.
     *
     * @return the zero character.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.827 -0500", hash_original_method = "5E609E25361E12310E119A02851AA08C", hash_generated_method = "9F7AD0B6208757056B1FFF98A08C2042")
    
public char getZeroDigit() {
        return zeroDigit;
    }

    /*
     * Returns the string used to separate mantissa and exponent. Typically "E", as in "1.2E3".
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.829 -0500", hash_original_method = "819A49232B9C4BF84239DF8CB1CAA3C1", hash_generated_method = "7A596710525270A6C7BAD0763C173D15")
    
public String getExponentSeparator() {
        return exponentSeparator;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.833 -0500", hash_original_method = "730AF15AAE06AD4A292A18D5EB73C960", hash_generated_method = "4CE2BCED81D139887B56B46E0F2A7FCF")
    
@Override
    public int hashCode() {
        int result = 17;
        result = 31*result + zeroDigit;
        result = 31*result + digit;
        result = 31*result + decimalSeparator;
        result = 31*result + groupingSeparator;
        result = 31*result + patternSeparator;
        result = 31*result + percent;
        result = 31*result + perMill;
        result = 31*result + monetarySeparator;
        result = 31*result + minusSign;
        result = 31*result + exponentSeparator.hashCode();
        result = 31*result + infinity.hashCode();
        result = 31*result + NaN.hashCode();
        result = 31*result + currencySymbol.hashCode();
        result = 31*result + intlCurrencySymbol.hashCode();
        return result;
    }

    /**
     * Sets the currency.
     * <p>
     * The international currency symbol and the currency symbol are updated,
     * but the min and max number of fraction digits stays the same.
     * <p>
     *
     * @param currency
     *            the new currency.
     * @throws NullPointerException
     *             if {@code currency} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.836 -0500", hash_original_method = "92D5537D8B3843A17694170BBEA5586B", hash_generated_method = "ACADD70342AD1A4712525629366404CF")
    
public void setCurrency(Currency currency) {
        if (currency == null) {
            throw new NullPointerException();
        }
        if (currency == this.currency) {
            return;
        }
        this.currency = currency;
        intlCurrencySymbol = currency.getCurrencyCode();
        currencySymbol = currency.getSymbol(locale);
    }

    /**
     * Sets the international currency symbol.
     * <p>
     * The currency and currency symbol are also updated if {@code value} is a
     * valid ISO4217 currency code.
     * <p>
     * The min and max number of fraction digits stay the same.
     *
     * @param value
     *            the currency code.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.838 -0500", hash_original_method = "207176AE532CCEDF88793D675BD5BB7E", hash_generated_method = "8411A01250F847572708E3CAF71DA871")
    
public void setInternationalCurrencySymbol(String value) {
        if (value == null) {
            currency = null;
            intlCurrencySymbol = null;
            return;
        }

        if (value.equals(intlCurrencySymbol)) {
            return;
        }

        try {
            currency = Currency.getInstance(value);
            currencySymbol = currency.getSymbol(locale);
        } catch (IllegalArgumentException e) {
            currency = null;
        }
        intlCurrencySymbol = value;
    }

    /**
     * Sets the currency symbol.
     *
     * @param value
     *            the currency symbol.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.841 -0500", hash_original_method = "29E8104D01D46C7E9FE837881A4B811D", hash_generated_method = "74F7DFB51B59745AB7999700EA7F22F0")
    
public void setCurrencySymbol(String value) {
        this.currencySymbol = value;
    }

    /**
     * Sets the character which represents the decimal point in a number.
     *
     * @param value
     *            the decimal separator character.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.843 -0500", hash_original_method = "9AC8CCC4F998C35713D40EA8501A574C", hash_generated_method = "F28CE1DE643543C56421524A2DFF9CB7")
    
public void setDecimalSeparator(char value) {
        this.decimalSeparator = value;
    }

    /**
     * Sets the character which represents a single digit in a format pattern.
     *
     * @param value
     *            the digit character.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.845 -0500", hash_original_method = "D6FAF1D38DB7E623F52AE4E3C83BC924", hash_generated_method = "88832D62D2024C46197D999805A0461F")
    
public void setDigit(char value) {
        this.digit = value;
    }

    /**
     * Sets the character used as the thousands separator in a number.
     *
     * @param value
     *            the grouping separator character.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.847 -0500", hash_original_method = "9D270588D20ED0589BF78FE9A748D06B", hash_generated_method = "C23E9EFA1E9820F29C8E7DF301C5A0C2")
    
public void setGroupingSeparator(char value) {
        this.groupingSeparator = value;
    }

    /**
     * Sets the string which represents infinity.
     *
     * @param value
     *            the string representing infinity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.850 -0500", hash_original_method = "253C85BF9C056E30DB4FF21631672E45", hash_generated_method = "1D37AFC24C53C36A6A7AF808C672A491")
    
public void setInfinity(String value) {
        this.infinity = value;
    }

    /**
     * Sets the minus sign character.
     *
     * @param value
     *            the minus sign character.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.852 -0500", hash_original_method = "D3F4D7B2767531D5CB8D7EDFAA19A0F0", hash_generated_method = "5E9C55701C8AEFF1E1075BC6682D316C")
    
public void setMinusSign(char value) {
        this.minusSign = value;
    }

    /**
     * Sets the character which represents the decimal point in a monetary
     * value.
     *
     * @param value
     *            the monetary decimal separator character.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.854 -0500", hash_original_method = "5DC5988EDD7C3CC1FE974B80FD913370", hash_generated_method = "BBBAB4DAB4714A928DEB819A26999FDF")
    
public void setMonetaryDecimalSeparator(char value) {
        this.monetarySeparator = value;
    }

    /**
     * Sets the string which represents NaN.
     *
     * @param value
     *            the string representing NaN.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.856 -0500", hash_original_method = "6A48D24176C36753AA1CCB849BDA297D", hash_generated_method = "3DCDBC023873F38218DE42FA318DDCA7")
    
public void setNaN(String value) {
        this.NaN = value;
    }

    /**
     * Sets the character which separates the positive and negative patterns in
     * a format pattern.
     *
     * @param value
     *            the pattern separator character.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.859 -0500", hash_original_method = "F9CB88FF85D83DD076D59F9C65C2F022", hash_generated_method = "8A4258183297583C2CD69921F4F06DFE")
    
public void setPatternSeparator(char value) {
        this.patternSeparator = value;
    }

    /**
     * Sets the percent character.
     *
     * @param value
     *            the percent character.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.862 -0500", hash_original_method = "82CC4266781153E2E37AE97635E76BF7", hash_generated_method = "AFAD83F88998AC68D0067A2A970A03A9")
    
public void setPercent(char value) {
        this.percent = value;
    }

    /**
     * Sets the per mill sign character.
     *
     * @param value
     *            the per mill character.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.864 -0500", hash_original_method = "A113C8FE00852B00BE817507D877FFEC", hash_generated_method = "6F33AB6CBEFD5DE64C9FC9C073CEA0A3")
    
public void setPerMill(char value) {
        this.perMill = value;
    }

    /**
     * Sets the character which represents zero.
     *
     * @param value
     *            the zero digit character.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.866 -0500", hash_original_method = "1F31C9A94279CEAA9BC58336D0C15AE7", hash_generated_method = "3BB7964E99EF8955ABCEF1285BEEA6CC")
    
public void setZeroDigit(char value) {
        this.zeroDigit = value;
    }

    /**
     * Sets the string used to separate mantissa and exponent. Typically "E", as in "1.2E3".
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.869 -0500", hash_original_method = "9B9F6C7BB1C5EA5DED0636F1E4439683", hash_generated_method = "0EDC007810E7C8BCF3967FF24A8E1C13")
    
public void setExponentSeparator(String value) {
        if (value == null) {
            throw new NullPointerException();
        }
        this.exponentSeparator = value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.874 -0500", hash_original_method = "AC413B5955CC7818D3CB585AD477DBD8", hash_generated_method = "DAA336F5A7F415B76670207E61D0C9FE")
    
private void writeObject(ObjectOutputStream stream) throws IOException {
        ObjectOutputStream.PutField fields = stream.putFields();
        fields.put("currencySymbol", currencySymbol);
        fields.put("decimalSeparator", getDecimalSeparator());
        fields.put("digit", getDigit());
        fields.put("exponential", exponentSeparator.charAt(0));
        fields.put("exponentialSeparator", exponentSeparator);
        fields.put("groupingSeparator", getGroupingSeparator());
        fields.put("infinity", infinity);
        fields.put("intlCurrencySymbol", intlCurrencySymbol);
        fields.put("minusSign", getMinusSign());
        fields.put("monetarySeparator", getMonetaryDecimalSeparator());
        fields.put("NaN", NaN);
        fields.put("patternSeparator", getPatternSeparator());
        fields.put("percent", getPercent());
        fields.put("perMill", getPerMill());
        fields.put("serialVersionOnStream", 3);
        fields.put("zeroDigit", getZeroDigit());
        fields.put("locale", locale);
        stream.writeFields();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:06.879 -0500", hash_original_method = "6B45962B37C777732BB6D07E7138D37B", hash_generated_method = "AC27212400A06FD88EE8469147FE9846")
    
private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = stream.readFields();
        final int serialVersionOnStream = fields.get("serialVersionOnStream", 0);
        currencySymbol = (String) fields.get("currencySymbol", "");
        setDecimalSeparator(fields.get("decimalSeparator", '.'));
        setDigit(fields.get("digit", '#'));
        setGroupingSeparator(fields.get("groupingSeparator", ','));
        infinity = (String) fields.get("infinity", "");
        intlCurrencySymbol = (String) fields.get("intlCurrencySymbol", "");
        setMinusSign(fields.get("minusSign", '-'));
        NaN = (String) fields.get("NaN", "");
        setPatternSeparator(fields.get("patternSeparator", ';'));
        setPercent(fields.get("percent", '%'));
        setPerMill(fields.get("perMill", '\u2030'));
        setZeroDigit(fields.get("zeroDigit", '0'));
        locale = (Locale) fields.get("locale", null);
        if (serialVersionOnStream == 0) {
            setMonetaryDecimalSeparator(getDecimalSeparator());
        } else {
            setMonetaryDecimalSeparator(fields.get("monetarySeparator", '.'));
        }

        if (serialVersionOnStream == 0) {
            // Prior to Java 1.1.6, the exponent separator wasn't configurable.
            exponentSeparator = "E";
        } else if (serialVersionOnStream < 3) {
            // In Javas 1.1.6 and 1.4, there was a character field "exponential".
            setExponentSeparator(String.valueOf(fields.get("exponential", 'E')));
        } else {
            // In Java 6, there's a new "exponentialSeparator" field.
            setExponentSeparator((String) fields.get("exponentialSeparator", "E"));
        }

        try {
            currency = Currency.getInstance(intlCurrencySymbol);
        } catch (IllegalArgumentException e) {
            currency = null;
        }
    }
}

