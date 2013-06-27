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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.175 -0400", hash_original_field = "3F4D9AC950DFB473BC6A0BB61B5D51EC", hash_generated_field = "09A83EE2F8EE9A2398F93CB4F525F4D2")

    private String currencyCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.176 -0400", hash_original_method = "B8C067C2D581EC195B8ADF9C49328ECD", hash_generated_method = "120711EF868F2ED0222E6A4270293C70")
    private  Currency(String currencyCode) {
        this.currencyCode = currencyCode;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.177 -0400", hash_original_method = "2AC1FCCB5B1A729D4AAC7C21169200F6", hash_generated_method = "5BC24B63674E77755BABB92D1AF1D5B0")
    public String getCurrencyCode() {
        String varB4EAC82CA7396A68D541C85D26508E83_526033998 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_526033998 = currencyCode;
        varB4EAC82CA7396A68D541C85D26508E83_526033998.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_526033998;
        // ---------- Original Method ----------
        //return currencyCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.191 -0400", hash_original_method = "024B35E959A93D0BB9AFB5000392D858", hash_generated_method = "5F030C58D523FC2FA37EC2FC44FAA6D4")
    public String getDisplayName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1118697821 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1118697821 = getDisplayName(Locale.getDefault());
        varB4EAC82CA7396A68D541C85D26508E83_1118697821.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1118697821;
        // ---------- Original Method ----------
        //return getDisplayName(Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.192 -0400", hash_original_method = "B412E21D17743E44672A03725048BDDA", hash_generated_method = "1207184F5152F64ECE367A2FF28D08B5")
    public String getDisplayName(Locale locale) {
        String varB4EAC82CA7396A68D541C85D26508E83_1940918643 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1940918643 = ICU.getCurrencyDisplayName(locale.toString(), currencyCode);
        addTaint(locale.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1940918643.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1940918643;
        // ---------- Original Method ----------
        //return ICU.getCurrencyDisplayName(locale.toString(), currencyCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.192 -0400", hash_original_method = "E9E6FD91308CE554CCA18D78EBA5451D", hash_generated_method = "B36F0C4AA6684E69DC0A257A1C42B98D")
    public String getSymbol() {
        String varB4EAC82CA7396A68D541C85D26508E83_1390116943 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1390116943 = getSymbol(Locale.getDefault());
        varB4EAC82CA7396A68D541C85D26508E83_1390116943.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1390116943;
        // ---------- Original Method ----------
        //return getSymbol(Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.193 -0400", hash_original_method = "798553E01F97CE042B0C960025EC8B4C", hash_generated_method = "E4E829E9E67500FB259738831149A28B")
    public String getSymbol(Locale locale) {
        String varB4EAC82CA7396A68D541C85D26508E83_676899945 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1306682253 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_284361288 = null; //Variable for return #3
        {
            boolean var46A8F51C48B1EC7316C856485A0E0C49_2073622319 = (locale.getCountry().length() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_676899945 = currencyCode;
            } //End block
        } //End collapsed parenthetic
        LocaleData localeData;
        localeData = LocaleData.get(locale);
        {
            boolean var595D8F43DD7F02F67BE19AC37628DD20_635713340 = (localeData.internationalCurrencySymbol.equals(currencyCode));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1306682253 = localeData.currencySymbol;
            } //End block
        } //End collapsed parenthetic
        String symbol;
        symbol = ICU.getCurrencySymbol(locale.toString(), currencyCode);
        varB4EAC82CA7396A68D541C85D26508E83_284361288 = symbol != null ? symbol : currencyCode;
        addTaint(locale.getTaint());
        String varA7E53CE21691AB073D9660D615818899_2050170766; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2050170766 = varB4EAC82CA7396A68D541C85D26508E83_676899945;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2050170766 = varB4EAC82CA7396A68D541C85D26508E83_1306682253;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2050170766 = varB4EAC82CA7396A68D541C85D26508E83_284361288;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2050170766.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2050170766;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.193 -0400", hash_original_method = "65B2259A2CB290C21BDBA11C63377846", hash_generated_method = "FE2209BEF166277A948B6A9027B93DE0")
    public int getDefaultFractionDigits() {
        {
            boolean var365784966A899A27D6D404098D0B02F3_1583957057 = (currencyCode.equals("XXX"));
        } //End collapsed parenthetic
        int var33FDAAE94FD1F5BFA848E456F837BDB6_882895849 = (ICU.getCurrencyFractionDigits(currencyCode));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1996356839 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1996356839;
        // ---------- Original Method ----------
        //if (currencyCode.equals("XXX")) {
            //return -1;
        //}
        //return ICU.getCurrencyFractionDigits(currencyCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.194 -0400", hash_original_method = "61F489343549C45D5079119B52911181", hash_generated_method = "0A8E0075B157D85EE93981E2259875B7")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1932929879 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1932929879 = currencyCode;
        varB4EAC82CA7396A68D541C85D26508E83_1932929879.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1932929879;
        // ---------- Original Method ----------
        //return currencyCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.194 -0400", hash_original_method = "BB7ABE2F39426123A0B73E0A126344FC", hash_generated_method = "4531DA6696EFBD52078A7411FA1C0939")
    private Object readResolve() {
        Object varB4EAC82CA7396A68D541C85D26508E83_555247916 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_555247916 = getInstance(currencyCode);
        varB4EAC82CA7396A68D541C85D26508E83_555247916.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_555247916;
        // ---------- Original Method ----------
        //return getInstance(currencyCode);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.194 -0400", hash_original_field = "12D780CD12AB6643ECC64F5BF288431B", hash_generated_field = "DDDD372229242F6A0BC133DE3F8C9EEF")

    private static long serialVersionUID = -158308464356906721L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.194 -0400", hash_original_field = "AE769B985C27CF2DEBF8E931C827B573", hash_generated_field = "25CC71919B9981C54B95EFCA24210883")

    private static HashMap<String, Currency> codesToCurrencies = new HashMap<String, Currency>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.194 -0400", hash_original_field = "0E1034E42DD53FC6792DC22B36BCA0A3", hash_generated_field = "980B5F33F57E120A86692A2A449C0635")

    private static HashMap<Locale, Currency> localesToCurrencies = new HashMap<Locale, Currency>();
}

