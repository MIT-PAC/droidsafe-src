package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.Serializable;
import libcore.icu.ICU;
import libcore.icu.LocaleData;

public final class Currency implements Serializable {
    private static final long serialVersionUID = -158308464356906721L;
    private static final HashMap<String, Currency> codesToCurrencies = new HashMap<String, Currency>();
    private static final HashMap<Locale, Currency> localesToCurrencies = new HashMap<Locale, Currency>();
    private final String currencyCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.098 -0400", hash_original_method = "B8C067C2D581EC195B8ADF9C49328ECD", hash_generated_method = "34C50C036E5D4AC281EF917CB8018C97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Currency(String currencyCode) {
        dsTaint.addTaint(currencyCode);
        String symbol;
        symbol = ICU.getCurrencySymbol(Locale.US.toString(), currencyCode);
        {
            throw new IllegalArgumentException("Unsupported ISO 4217 currency code: " +
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.098 -0400", hash_original_method = "BAF6F7D56D54D6837D138AE76CB94486", hash_generated_method = "1958A5CB62A9CACC726EB766D9AEC024")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.098 -0400", hash_original_method = "6CD28EDE187ECB267B82CB22AA243B4D", hash_generated_method = "622702E1F5EFE722DCF2139A8DB3D633")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.098 -0400", hash_original_method = "3BA00AE8CC62BA0042B4559B37B5E5E2", hash_generated_method = "0A6CA9A85DFE384BF92C633C51165597")
    public static Set<Currency> getAvailableCurrencies() {
        Set<Currency> result = new LinkedHashSet<Currency>();
        String[] currencyCodes = ICU.getAvailableCurrencyCodes();
        for (String currencyCode : currencyCodes) {
            result.add(Currency.getInstance(currencyCode));
        }
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.098 -0400", hash_original_method = "2AC1FCCB5B1A729D4AAC7C21169200F6", hash_generated_method = "2AA9AE0E030F9ACA139331DAC0F47B4F")
    @DSModeled(DSC.SAFE)
    public String getCurrencyCode() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return currencyCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.098 -0400", hash_original_method = "024B35E959A93D0BB9AFB5000392D858", hash_generated_method = "4805AE34191AAF8BC3AE3D3F71E8F9DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDisplayName() {
        String var32E5D71ABA5D9535215CF72F9470A922_1184782055 = (getDisplayName(Locale.getDefault()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getDisplayName(Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.098 -0400", hash_original_method = "B412E21D17743E44672A03725048BDDA", hash_generated_method = "C8E23D93A3C13B8435FD9A1D2C147DAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDisplayName(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        String var56B25A86521BDD0EA093C41D3591622F_1290048240 = (ICU.getCurrencyDisplayName(locale.toString(), currencyCode));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return ICU.getCurrencyDisplayName(locale.toString(), currencyCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.098 -0400", hash_original_method = "E9E6FD91308CE554CCA18D78EBA5451D", hash_generated_method = "E92909CA881EE31275F51D7967F334EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSymbol() {
        String varD7388F1CA21423F080E14B18B9FD4E34_57990082 = (getSymbol(Locale.getDefault()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getSymbol(Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.098 -0400", hash_original_method = "798553E01F97CE042B0C960025EC8B4C", hash_generated_method = "54276DF671F902CC5997CC6ACE99A8AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSymbol(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        {
            boolean var46A8F51C48B1EC7316C856485A0E0C49_1727225710 = (locale.getCountry().length() == 0);
        } //End collapsed parenthetic
        LocaleData localeData;
        localeData = LocaleData.get(locale);
        {
            boolean var595D8F43DD7F02F67BE19AC37628DD20_1150203015 = (localeData.internationalCurrencySymbol.equals(currencyCode));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.098 -0400", hash_original_method = "65B2259A2CB290C21BDBA11C63377846", hash_generated_method = "F1ED2EBEB791FBE52538AF887C2FE1FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDefaultFractionDigits() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var365784966A899A27D6D404098D0B02F3_96783014 = (currencyCode.equals("XXX"));
        } //End collapsed parenthetic
        int var33FDAAE94FD1F5BFA848E456F837BDB6_1999533325 = (ICU.getCurrencyFractionDigits(currencyCode));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (currencyCode.equals("XXX")) {
            //return -1;
        //}
        //return ICU.getCurrencyFractionDigits(currencyCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.098 -0400", hash_original_method = "61F489343549C45D5079119B52911181", hash_generated_method = "5F0C07E6D12AE2F3EAA4D938B544267A")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return currencyCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.098 -0400", hash_original_method = "BB7ABE2F39426123A0B73E0A126344FC", hash_generated_method = "EFB1195E33C8DEC78C70AD5F9657276C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object readResolve() {
        Object varE2B6ED55795313175EECC14BE8B9E2AE_1381528767 = (getInstance(currencyCode));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getInstance(currencyCode);
    }

    
}


