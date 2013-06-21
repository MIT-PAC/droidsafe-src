package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;
import libcore.icu.ICU;
import libcore.icu.LocaleData;

public final class Currency implements Serializable {
    private String currencyCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.760 -0400", hash_original_method = "B8C067C2D581EC195B8ADF9C49328ECD", hash_generated_method = "9C45592F1F8D3E46D1885B2F3B769D5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Currency(String currencyCode) {
        dsTaint.addTaint(currencyCode);
        String symbol;
        symbol = ICU.getCurrencySymbol(Locale.US.toString(), currencyCode);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unsupported ISO 4217 currency code: " +
                    currencyCode);
        } //End block
        // ---------- Original Method ----------
        //this.currencyCode = currencyCode;
        //String symbol = ICU.getCurrencySymbol(Locale.US.toString(), currencyCode);
        //if (symbol == null) {
            //throw new IllegalArgumentException("Unsupported ISO 4217 currency code: " +
                    //currencyCode);
        //}
    }

    
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

    
        public static Set<Currency> getAvailableCurrencies() {
        Set<Currency> result = new LinkedHashSet<Currency>();
        String[] currencyCodes = ICU.getAvailableCurrencyCodes();
        for (String currencyCode : currencyCodes) {
            result.add(Currency.getInstance(currencyCode));
        }
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.761 -0400", hash_original_method = "2AC1FCCB5B1A729D4AAC7C21169200F6", hash_generated_method = "82E85A0A39F1BA55340A23C1B19E0729")
    @DSModeled(DSC.SAFE)
    public String getCurrencyCode() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return currencyCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.761 -0400", hash_original_method = "024B35E959A93D0BB9AFB5000392D858", hash_generated_method = "32C5CEFE529AE9D95A26E85F47731A31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDisplayName() {
        String var32E5D71ABA5D9535215CF72F9470A922_1650122212 = (getDisplayName(Locale.getDefault()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getDisplayName(Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.761 -0400", hash_original_method = "B412E21D17743E44672A03725048BDDA", hash_generated_method = "D863891522D1DCEB3FDC159A41E4D396")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDisplayName(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        String var56B25A86521BDD0EA093C41D3591622F_189511899 = (ICU.getCurrencyDisplayName(locale.toString(), currencyCode));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return ICU.getCurrencyDisplayName(locale.toString(), currencyCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.761 -0400", hash_original_method = "E9E6FD91308CE554CCA18D78EBA5451D", hash_generated_method = "98D9BF010ED575D9B15DC5609FBB766C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSymbol() {
        String varD7388F1CA21423F080E14B18B9FD4E34_29826286 = (getSymbol(Locale.getDefault()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getSymbol(Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.762 -0400", hash_original_method = "798553E01F97CE042B0C960025EC8B4C", hash_generated_method = "B8468E268997086D6F0C3C8BF6B6B7AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSymbol(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        {
            boolean var46A8F51C48B1EC7316C856485A0E0C49_1877277698 = (locale.getCountry().length() == 0);
        } //End collapsed parenthetic
        LocaleData localeData;
        localeData = LocaleData.get(locale);
        {
            boolean var595D8F43DD7F02F67BE19AC37628DD20_143580220 = (localeData.internationalCurrencySymbol.equals(currencyCode));
        } //End collapsed parenthetic
        String symbol;
        symbol = ICU.getCurrencySymbol(locale.toString(), currencyCode);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (locale.getCountry().length() == 0) {
            //return currencyCode;
        //}
        //LocaleData localeData = LocaleData.get(locale);
        //if (localeData.internationalCurrencySymbol.equals(currencyCode)) {
            //return localeData.currencySymbol;
        //}
        //String symbol = ICU.getCurrencySymbol(locale.toString(), currencyCode);
        //return symbol != null ? symbol : currencyCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.762 -0400", hash_original_method = "65B2259A2CB290C21BDBA11C63377846", hash_generated_method = "1AAA83BD7226BE3D6769FEE894A5E714")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDefaultFractionDigits() {
        {
            boolean var365784966A899A27D6D404098D0B02F3_2014727776 = (currencyCode.equals("XXX"));
        } //End collapsed parenthetic
        int var33FDAAE94FD1F5BFA848E456F837BDB6_1466723681 = (ICU.getCurrencyFractionDigits(currencyCode));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (currencyCode.equals("XXX")) {
            //return -1;
        //}
        //return ICU.getCurrencyFractionDigits(currencyCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.762 -0400", hash_original_method = "61F489343549C45D5079119B52911181", hash_generated_method = "6C48C6CEB58956C7CFB03335374A222F")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return currencyCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.762 -0400", hash_original_method = "BB7ABE2F39426123A0B73E0A126344FC", hash_generated_method = "BD051BB95304AA2A7B9B536289187E43")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object readResolve() {
        Object varE2B6ED55795313175EECC14BE8B9E2AE_209853148 = (getInstance(currencyCode));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getInstance(currencyCode);
    }

    
    private static final long serialVersionUID = -158308464356906721L;
    private static final HashMap<String, Currency> codesToCurrencies = new HashMap<String, Currency>();
    private static final HashMap<Locale, Currency> localesToCurrencies = new HashMap<Locale, Currency>();
}

