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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.612 -0400", hash_original_field = "3F4D9AC950DFB473BC6A0BB61B5D51EC", hash_generated_field = "09A83EE2F8EE9A2398F93CB4F525F4D2")

    private String currencyCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.613 -0400", hash_original_method = "B8C067C2D581EC195B8ADF9C49328ECD", hash_generated_method = "1644E5A8672D15FD8F4D32DB1FE50B63")
    private  Currency(String currencyCode) {
        this.currencyCode = currencyCode;
        String symbol = ICU.getCurrencySymbol(Locale.US.toString(), currencyCode);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.614 -0400", hash_original_method = "2AC1FCCB5B1A729D4AAC7C21169200F6", hash_generated_method = "ABF57015E807182648E093784396C830")
    public String getCurrencyCode() {
        String varB4EAC82CA7396A68D541C85D26508E83_171711508 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_171711508 = currencyCode;
        varB4EAC82CA7396A68D541C85D26508E83_171711508.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_171711508;
        // ---------- Original Method ----------
        //return currencyCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.614 -0400", hash_original_method = "024B35E959A93D0BB9AFB5000392D858", hash_generated_method = "A0D8A82108AEF3A134E420666B5696BD")
    public String getDisplayName() {
        String varB4EAC82CA7396A68D541C85D26508E83_942126316 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_942126316 = getDisplayName(Locale.getDefault());
        varB4EAC82CA7396A68D541C85D26508E83_942126316.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_942126316;
        // ---------- Original Method ----------
        //return getDisplayName(Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.614 -0400", hash_original_method = "B412E21D17743E44672A03725048BDDA", hash_generated_method = "AB6713420639E9A3A5775361B4A61F54")
    public String getDisplayName(Locale locale) {
        String varB4EAC82CA7396A68D541C85D26508E83_801781698 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_801781698 = ICU.getCurrencyDisplayName(locale.toString(), currencyCode);
        addTaint(locale.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_801781698.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_801781698;
        // ---------- Original Method ----------
        //return ICU.getCurrencyDisplayName(locale.toString(), currencyCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.615 -0400", hash_original_method = "E9E6FD91308CE554CCA18D78EBA5451D", hash_generated_method = "1091682D95EB9B6D9D6B2D9022711DE4")
    public String getSymbol() {
        String varB4EAC82CA7396A68D541C85D26508E83_769687654 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_769687654 = getSymbol(Locale.getDefault());
        varB4EAC82CA7396A68D541C85D26508E83_769687654.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_769687654;
        // ---------- Original Method ----------
        //return getSymbol(Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.616 -0400", hash_original_method = "798553E01F97CE042B0C960025EC8B4C", hash_generated_method = "17176661C99468E319AE75251C2C0618")
    public String getSymbol(Locale locale) {
        String varB4EAC82CA7396A68D541C85D26508E83_306532808 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_763173971 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_63327200 = null; //Variable for return #3
        {
            boolean var46A8F51C48B1EC7316C856485A0E0C49_202248384 = (locale.getCountry().length() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_306532808 = currencyCode;
            } //End block
        } //End collapsed parenthetic
        LocaleData localeData = LocaleData.get(locale);
        {
            boolean var595D8F43DD7F02F67BE19AC37628DD20_1108363383 = (localeData.internationalCurrencySymbol.equals(currencyCode));
            {
                varB4EAC82CA7396A68D541C85D26508E83_763173971 = localeData.currencySymbol;
            } //End block
        } //End collapsed parenthetic
        String symbol = ICU.getCurrencySymbol(locale.toString(), currencyCode);
        varB4EAC82CA7396A68D541C85D26508E83_63327200 = symbol != null ? symbol : currencyCode;
        addTaint(locale.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1494360718; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1494360718 = varB4EAC82CA7396A68D541C85D26508E83_306532808;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1494360718 = varB4EAC82CA7396A68D541C85D26508E83_763173971;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1494360718 = varB4EAC82CA7396A68D541C85D26508E83_63327200;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1494360718.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1494360718;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.617 -0400", hash_original_method = "65B2259A2CB290C21BDBA11C63377846", hash_generated_method = "3D923F36463CAEFCD7BCF0DDF448681D")
    public int getDefaultFractionDigits() {
        {
            boolean var365784966A899A27D6D404098D0B02F3_1081124869 = (currencyCode.equals("XXX"));
        } //End collapsed parenthetic
        int var33FDAAE94FD1F5BFA848E456F837BDB6_1698529149 = (ICU.getCurrencyFractionDigits(currencyCode));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1640016483 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1640016483;
        // ---------- Original Method ----------
        //if (currencyCode.equals("XXX")) {
            //return -1;
        //}
        //return ICU.getCurrencyFractionDigits(currencyCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.617 -0400", hash_original_method = "61F489343549C45D5079119B52911181", hash_generated_method = "01204BAF7B835AB024A4C87380F1A473")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1289133929 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1289133929 = currencyCode;
        varB4EAC82CA7396A68D541C85D26508E83_1289133929.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1289133929;
        // ---------- Original Method ----------
        //return currencyCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.618 -0400", hash_original_method = "BB7ABE2F39426123A0B73E0A126344FC", hash_generated_method = "B1006BB8E3AC46A64F0D1F747F16A8AB")
    private Object readResolve() {
        Object varB4EAC82CA7396A68D541C85D26508E83_101218829 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_101218829 = getInstance(currencyCode);
        varB4EAC82CA7396A68D541C85D26508E83_101218829.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_101218829;
        // ---------- Original Method ----------
        //return getInstance(currencyCode);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.618 -0400", hash_original_field = "12D780CD12AB6643ECC64F5BF288431B", hash_generated_field = "988408236DD0ACB2CF0402B70B74C3DC")

    private static final long serialVersionUID = -158308464356906721L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.618 -0400", hash_original_field = "AE769B985C27CF2DEBF8E931C827B573", hash_generated_field = "5DE33F779A03A1507D90CF98EB856660")

    private static final HashMap<String, Currency> codesToCurrencies = new HashMap<String, Currency>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:07.618 -0400", hash_original_field = "0E1034E42DD53FC6792DC22B36BCA0A3", hash_generated_field = "15C3858DCBF7011F3D3C46BA1E9A611E")

    private static final HashMap<Locale, Currency> localesToCurrencies = new HashMap<Locale, Currency>();
}

