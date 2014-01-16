package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;

import libcore.icu.ICU;
import libcore.icu.LocaleData;

public final class Currency implements Serializable {

    /**
     * Returns the {@code Currency} instance for the given ISO 4217 currency code.
     * @throws IllegalArgumentException
     *             if the currency code is not a supported ISO 4217 currency code.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.813 -0500", hash_original_method = "BAF6F7D56D54D6837D138AE76CB94486", hash_generated_method = "1958A5CB62A9CACC726EB766D9AEC024")
    
public static Currency getInstance(String currencyCode) {
        synchronized (codesToCurrencies) {
            Currency currency = codesToCurrencies.get(currencyCode);
            if (currency == null) {
                currency = new Currency(currencyCode);
                codesToCurrencies.put(currencyCode, currency);
            }
            return currency;
        }
    }

    /**
     * Returns the {@code Currency} instance for this {@code Locale}'s country.
     * @throws IllegalArgumentException
     *             if the locale's country is not a supported ISO 3166 country.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.816 -0500", hash_original_method = "6CD28EDE187ECB267B82CB22AA243B4D", hash_generated_method = "622702E1F5EFE722DCF2139A8DB3D633")
    
public static Currency getInstance(Locale locale) {
        synchronized (localesToCurrencies) {
            Currency currency = localesToCurrencies.get(locale);
            if (currency != null) {
                return currency;
            }
            String country = locale.getCountry();
            String variant = locale.getVariant();
            if (!variant.isEmpty() && (variant.equals("EURO") || variant.equals("HK") ||
                    variant.equals("PREEURO"))) {
                country = country + "_" + variant;
            }

            String currencyCode = ICU.getCurrencyCode(country);
            if (currencyCode == null) {
                throw new IllegalArgumentException("Unsupported ISO 3166 country: " + locale);
            } else if (currencyCode.equals("None")) {
                return null;
            }
            Currency result = getInstance(currencyCode);
            localesToCurrencies.put(locale, result);
            return result;
        }
    }

    /**
     * Returns a set of all known currencies.
     * @since 1.7
     * @hide 1.7
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.818 -0500", hash_original_method = "3BA00AE8CC62BA0042B4559B37B5E5E2", hash_generated_method = "0A6CA9A85DFE384BF92C633C51165597")
    
public static Set<Currency> getAvailableCurrencies() {
        Set<Currency> result = new LinkedHashSet<Currency>();
        String[] currencyCodes = ICU.getAvailableCurrencyCodes();
        for (String currencyCode : currencyCodes) {
            result.add(Currency.getInstance(currencyCode));
        }
        return result;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.799 -0500", hash_original_field = "92FE56715AB3AA6A04A3019B1FE5A4B5", hash_generated_field = "988408236DD0ACB2CF0402B70B74C3DC")

    private static final long serialVersionUID = -158308464356906721L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.802 -0500", hash_original_field = "6795F9BFF3BB7AFB0DBCF2E4B7200D0E", hash_generated_field = "5DE33F779A03A1507D90CF98EB856660")

    private static final HashMap<String, Currency> codesToCurrencies = new HashMap<String, Currency>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.804 -0500", hash_original_field = "E6A45BD1D2829CDAE64AA5D2C062DC2B", hash_generated_field = "15C3858DCBF7011F3D3C46BA1E9A611E")

    private static final HashMap<Locale, Currency> localesToCurrencies = new HashMap<Locale, Currency>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.807 -0500", hash_original_field = "D31B563A97C693C9B541BCA214184362", hash_generated_field = "09A83EE2F8EE9A2398F93CB4F525F4D2")

    private  String currencyCode;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.810 -0500", hash_original_method = "B8C067C2D581EC195B8ADF9C49328ECD", hash_generated_method = "EC22FFA2216AB07172547C8A5C42DF40")
    
private Currency(String currencyCode) {
        this.currencyCode = currencyCode;
        String symbol = ICU.getCurrencySymbol(Locale.US.toString(), currencyCode);
        if (symbol == null) {
            throw new IllegalArgumentException("Unsupported ISO 4217 currency code: " +
                    currencyCode);
        }
    }

    /**
     * Returns this currency's ISO 4217 currency code.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.821 -0500", hash_original_method = "2AC1FCCB5B1A729D4AAC7C21169200F6", hash_generated_method = "C3161812D25A8275C97E68CD2A97699A")
    
public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Equivalent to {@code getDisplayName(Locale.getDefault())}.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     * @since 1.7
     * @hide 1.7
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.823 -0500", hash_original_method = "024B35E959A93D0BB9AFB5000392D858", hash_generated_method = "F25632E299DC6CDF309556DD7393FC6B")
    
public String getDisplayName() {
        return getDisplayName(Locale.getDefault());
    }

    /**
     * Returns the localized name of this currency in the given {@code locale}.
     * Returns the ISO 4217 currency code if no localized name is available.
     * @since 1.7
     * @hide 1.7
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.826 -0500", hash_original_method = "B412E21D17743E44672A03725048BDDA", hash_generated_method = "BEE04B9C7589DEF988EE51980F910103")
    
public String getDisplayName(Locale locale) {
        return ICU.getCurrencyDisplayName(locale.toString(), currencyCode);
    }

    /**
     * Equivalent to {@code getSymbol(Locale.getDefault())}.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.828 -0500", hash_original_method = "E9E6FD91308CE554CCA18D78EBA5451D", hash_generated_method = "B882D9E9B74480A7FE05D0C27DD548C8")
    
public String getSymbol() {
        return getSymbol(Locale.getDefault());
    }

    /**
     * Returns the localized currency symbol for this currency in {@code locale}.
     * That is, given "USD" and Locale.US, you'd get "$", but given "USD" and a non-US locale,
     * you'd get "US$".
     *
     * <p>If the locale only specifies a language rather than a language and a country (such as
     * {@code Locale.JAPANESE} or {new Locale("en", "")} rather than {@code Locale.JAPAN} or
     * {new Locale("en", "US")}), the ISO 4217 currency code is returned.
     *
     * <p>If there is no locale-specific currency symbol, the ISO 4217 currency code is returned.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.831 -0500", hash_original_method = "798553E01F97CE042B0C960025EC8B4C", hash_generated_method = "B2A9E372B0880E9100E0B24056FFFEE5")
    
public String getSymbol(Locale locale) {
        if (locale.getCountry().length() == 0) {
            return currencyCode;
        }

        // Check the locale first, in case the locale has the same currency.
        LocaleData localeData = LocaleData.get(locale);
        if (localeData.internationalCurrencySymbol.equals(currencyCode)) {
            return localeData.currencySymbol;
        }

        // Try ICU, and fall back to the currency code if ICU has nothing.
        String symbol = ICU.getCurrencySymbol(locale.toString(), currencyCode);
        return symbol != null ? symbol : currencyCode;
    }

    /**
     * Returns the default number of fraction digits for this currency.
     * For instance, the default number of fraction digits for the US dollar is 2 because there are
     * 100 US cents in a US dollar. For the Japanese Yen, the number is 0 because coins smaller
     * than 1 Yen became invalid in 1953. In the case of pseudo-currencies, such as
     * IMF Special Drawing Rights, -1 is returned.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.833 -0500", hash_original_method = "65B2259A2CB290C21BDBA11C63377846", hash_generated_method = "26C4C3825C318B199FB8D45816B19568")
    
public int getDefaultFractionDigits() {
        // In some places the code XXX is used as the fall back currency.
        // The RI returns -1, but ICU defaults to 2 for unknown currencies.
        if (currencyCode.equals("XXX")) {
            return -1;
        }
        return ICU.getCurrencyFractionDigits(currencyCode);
    }

    /**
     * Returns this currency's ISO 4217 currency code.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.836 -0500", hash_original_method = "61F489343549C45D5079119B52911181", hash_generated_method = "5A69ED0E0A66D7BB87D01A4C23F64132")
    
@Override
    public String toString() {
        return currencyCode;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.838 -0500", hash_original_method = "BB7ABE2F39426123A0B73E0A126344FC", hash_generated_method = "DECCC08527160C4C5759AA77139B5B6B")
    
private Object readResolve() {
        return getInstance(currencyCode);
    }
}

