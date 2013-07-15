package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;
import libcore.icu.ICU;
import libcore.icu.LocaleData;

public final class Currency implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.897 -0400", hash_original_field = "3F4D9AC950DFB473BC6A0BB61B5D51EC", hash_generated_field = "09A83EE2F8EE9A2398F93CB4F525F4D2")

    private String currencyCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.898 -0400", hash_original_method = "B8C067C2D581EC195B8ADF9C49328ECD", hash_generated_method = "A6F30179708FF3E4869204CF9307A4EC")
    private  Currency(String currencyCode) {
        this.currencyCode = currencyCode;
        String symbol = ICU.getCurrencySymbol(Locale.US.toString(), currencyCode);
    if(symbol == null)        
        {
            IllegalArgumentException var3AA105C84DCAC57BA4323334B70BD93C_1374191000 = new IllegalArgumentException("Unsupported ISO 4217 currency code: " +
                    currencyCode);
            var3AA105C84DCAC57BA4323334B70BD93C_1374191000.addTaint(taint);
            throw var3AA105C84DCAC57BA4323334B70BD93C_1374191000;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.900 -0400", hash_original_method = "2AC1FCCB5B1A729D4AAC7C21169200F6", hash_generated_method = "7DA18BFDFD2B9115D3580898548038C3")
    public String getCurrencyCode() {
String varDCA4AC53D28391F46322772F57580CB2_2137732917 =         currencyCode;
        varDCA4AC53D28391F46322772F57580CB2_2137732917.addTaint(taint);
        return varDCA4AC53D28391F46322772F57580CB2_2137732917;
        // ---------- Original Method ----------
        //return currencyCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.900 -0400", hash_original_method = "024B35E959A93D0BB9AFB5000392D858", hash_generated_method = "70172DF8ABB90858F2776E26A896F72B")
    public String getDisplayName() {
String varB9A5C9A13F510C3DA69A4E71F1129D4D_1018851380 =         getDisplayName(Locale.getDefault());
        varB9A5C9A13F510C3DA69A4E71F1129D4D_1018851380.addTaint(taint);
        return varB9A5C9A13F510C3DA69A4E71F1129D4D_1018851380;
        // ---------- Original Method ----------
        //return getDisplayName(Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.900 -0400", hash_original_method = "B412E21D17743E44672A03725048BDDA", hash_generated_method = "4D9267402531EFB63ACF2F200E65241D")
    public String getDisplayName(Locale locale) {
        addTaint(locale.getTaint());
String varD116BA6AF2BB7EEB8981E847F12A6C58_454920566 =         ICU.getCurrencyDisplayName(locale.toString(), currencyCode);
        varD116BA6AF2BB7EEB8981E847F12A6C58_454920566.addTaint(taint);
        return varD116BA6AF2BB7EEB8981E847F12A6C58_454920566;
        // ---------- Original Method ----------
        //return ICU.getCurrencyDisplayName(locale.toString(), currencyCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.901 -0400", hash_original_method = "E9E6FD91308CE554CCA18D78EBA5451D", hash_generated_method = "3E7F74C86D3C4DDD47065ABA1912E28A")
    public String getSymbol() {
String var550E4FBFA0F19C770741ACC1869211F4_674718114 =         getSymbol(Locale.getDefault());
        var550E4FBFA0F19C770741ACC1869211F4_674718114.addTaint(taint);
        return var550E4FBFA0F19C770741ACC1869211F4_674718114;
        // ---------- Original Method ----------
        //return getSymbol(Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.901 -0400", hash_original_method = "798553E01F97CE042B0C960025EC8B4C", hash_generated_method = "C1295AD2595F471836402DC080E2C2F5")
    public String getSymbol(Locale locale) {
        addTaint(locale.getTaint());
    if(locale.getCountry().length() == 0)        
        {
String varDCA4AC53D28391F46322772F57580CB2_1888348746 =             currencyCode;
            varDCA4AC53D28391F46322772F57580CB2_1888348746.addTaint(taint);
            return varDCA4AC53D28391F46322772F57580CB2_1888348746;
        } //End block
        LocaleData localeData = LocaleData.get(locale);
    if(localeData.internationalCurrencySymbol.equals(currencyCode))        
        {
String var0C684205C7891B042FA6A8C56DBF7FC9_1367274349 =             localeData.currencySymbol;
            var0C684205C7891B042FA6A8C56DBF7FC9_1367274349.addTaint(taint);
            return var0C684205C7891B042FA6A8C56DBF7FC9_1367274349;
        } //End block
        String symbol = ICU.getCurrencySymbol(locale.toString(), currencyCode);
String var2A95E65D22A866C442E97C6F5795F0AC_1428510872 =         symbol != null ? symbol : currencyCode;
        var2A95E65D22A866C442E97C6F5795F0AC_1428510872.addTaint(taint);
        return var2A95E65D22A866C442E97C6F5795F0AC_1428510872;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.902 -0400", hash_original_method = "65B2259A2CB290C21BDBA11C63377846", hash_generated_method = "03F63D9B6D93E3842CBE89AF9A2212ED")
    public int getDefaultFractionDigits() {
    if(currencyCode.equals("XXX"))        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1428284635 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2036702040 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2036702040;
        } //End block
        int var6BB5405F49B27F7F9C8ED23943B2841D_1892985743 = (ICU.getCurrencyFractionDigits(currencyCode));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_412944475 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_412944475;
        // ---------- Original Method ----------
        //if (currencyCode.equals("XXX")) {
            //return -1;
        //}
        //return ICU.getCurrencyFractionDigits(currencyCode);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.902 -0400", hash_original_method = "61F489343549C45D5079119B52911181", hash_generated_method = "E23EAAE85BB9875AC12C317ED19C9C24")
    @Override
    public String toString() {
String varDCA4AC53D28391F46322772F57580CB2_1479544 =         currencyCode;
        varDCA4AC53D28391F46322772F57580CB2_1479544.addTaint(taint);
        return varDCA4AC53D28391F46322772F57580CB2_1479544;
        // ---------- Original Method ----------
        //return currencyCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.903 -0400", hash_original_method = "BB7ABE2F39426123A0B73E0A126344FC", hash_generated_method = "ADC73D7743883B25FF186F40EBD8C9D2")
    private Object readResolve() {
Object varD4FA9C15216E7D131112D808565A84F6_258698483 =         getInstance(currencyCode);
        varD4FA9C15216E7D131112D808565A84F6_258698483.addTaint(taint);
        return varD4FA9C15216E7D131112D808565A84F6_258698483;
        // ---------- Original Method ----------
        //return getInstance(currencyCode);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.903 -0400", hash_original_field = "12D780CD12AB6643ECC64F5BF288431B", hash_generated_field = "988408236DD0ACB2CF0402B70B74C3DC")

    private static final long serialVersionUID = -158308464356906721L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.903 -0400", hash_original_field = "AE769B985C27CF2DEBF8E931C827B573", hash_generated_field = "5DE33F779A03A1507D90CF98EB856660")

    private static final HashMap<String, Currency> codesToCurrencies = new HashMap<String, Currency>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:02.903 -0400", hash_original_field = "0E1034E42DD53FC6792DC22B36BCA0A3", hash_generated_field = "15C3858DCBF7011F3D3C46BA1E9A611E")

    private static final HashMap<Locale, Currency> localesToCurrencies = new HashMap<Locale, Currency>();
}

