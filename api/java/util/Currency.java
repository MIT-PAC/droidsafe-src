package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;
import libcore.icu.ICU;
import libcore.icu.LocaleData;

public final class Currency implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.994 -0400", hash_original_field = "3F4D9AC950DFB473BC6A0BB61B5D51EC", hash_generated_field = "09A83EE2F8EE9A2398F93CB4F525F4D2")

    private String currencyCode;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.994 -0400", hash_original_method = "B8C067C2D581EC195B8ADF9C49328ECD", hash_generated_method = "89190EFF2CBAF0E9684CBB21096A71AD")
    private  Currency(String currencyCode) {
        this.currencyCode = currencyCode;
        String symbol = ICU.getCurrencySymbol(Locale.US.toString(), currencyCode);
        if(symbol == null)        
        {
            IllegalArgumentException var3AA105C84DCAC57BA4323334B70BD93C_1482329760 = new IllegalArgumentException("Unsupported ISO 4217 currency code: " +
                    currencyCode);
            var3AA105C84DCAC57BA4323334B70BD93C_1482329760.addTaint(taint);
            throw var3AA105C84DCAC57BA4323334B70BD93C_1482329760;
        } //End block
        // ---------- Original Method ----------
        //this.currencyCode = currencyCode;
        //String symbol = ICU.getCurrencySymbol(Locale.US.toString(), currencyCode);
        //if (symbol == null) {
            //throw new IllegalArgumentException("Unsupported ISO 4217 currency code: " +
                    //currencyCode);
        //}
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.995 -0400", hash_original_method = "2AC1FCCB5B1A729D4AAC7C21169200F6", hash_generated_method = "36035D40AD1B83E48CCDD6A6C032E756")
    public String getCurrencyCode() {
String varDCA4AC53D28391F46322772F57580CB2_339155831 =         currencyCode;
        varDCA4AC53D28391F46322772F57580CB2_339155831.addTaint(taint);
        return varDCA4AC53D28391F46322772F57580CB2_339155831;
        // ---------- Original Method ----------
        //return currencyCode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.995 -0400", hash_original_method = "024B35E959A93D0BB9AFB5000392D858", hash_generated_method = "75EFBAD530E15AAB0B723D7483D1BB4E")
    public String getDisplayName() {
String varB9A5C9A13F510C3DA69A4E71F1129D4D_848753007 =         getDisplayName(Locale.getDefault());
        varB9A5C9A13F510C3DA69A4E71F1129D4D_848753007.addTaint(taint);
        return varB9A5C9A13F510C3DA69A4E71F1129D4D_848753007;
        // ---------- Original Method ----------
        //return getDisplayName(Locale.getDefault());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.995 -0400", hash_original_method = "B412E21D17743E44672A03725048BDDA", hash_generated_method = "BEB012B1FB291E8A29B61BE9D438C3DA")
    public String getDisplayName(Locale locale) {
        addTaint(locale.getTaint());
String varD116BA6AF2BB7EEB8981E847F12A6C58_1080792443 =         ICU.getCurrencyDisplayName(locale.toString(), currencyCode);
        varD116BA6AF2BB7EEB8981E847F12A6C58_1080792443.addTaint(taint);
        return varD116BA6AF2BB7EEB8981E847F12A6C58_1080792443;
        // ---------- Original Method ----------
        //return ICU.getCurrencyDisplayName(locale.toString(), currencyCode);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.995 -0400", hash_original_method = "E9E6FD91308CE554CCA18D78EBA5451D", hash_generated_method = "E4EA7FEC033B87EED8251F51A309B181")
    public String getSymbol() {
String var550E4FBFA0F19C770741ACC1869211F4_728318912 =         getSymbol(Locale.getDefault());
        var550E4FBFA0F19C770741ACC1869211F4_728318912.addTaint(taint);
        return var550E4FBFA0F19C770741ACC1869211F4_728318912;
        // ---------- Original Method ----------
        //return getSymbol(Locale.getDefault());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.995 -0400", hash_original_method = "798553E01F97CE042B0C960025EC8B4C", hash_generated_method = "E12008BA003A594243C6AF3DD41EC4DB")
    public String getSymbol(Locale locale) {
        addTaint(locale.getTaint());
        if(locale.getCountry().length() == 0)        
        {
String varDCA4AC53D28391F46322772F57580CB2_1730468062 =             currencyCode;
            varDCA4AC53D28391F46322772F57580CB2_1730468062.addTaint(taint);
            return varDCA4AC53D28391F46322772F57580CB2_1730468062;
        } //End block
        LocaleData localeData = LocaleData.get(locale);
        if(localeData.internationalCurrencySymbol.equals(currencyCode))        
        {
String var0C684205C7891B042FA6A8C56DBF7FC9_2141283451 =             localeData.currencySymbol;
            var0C684205C7891B042FA6A8C56DBF7FC9_2141283451.addTaint(taint);
            return var0C684205C7891B042FA6A8C56DBF7FC9_2141283451;
        } //End block
        String symbol = ICU.getCurrencySymbol(locale.toString(), currencyCode);
String var2A95E65D22A866C442E97C6F5795F0AC_1245132106 =         symbol != null ? symbol : currencyCode;
        var2A95E65D22A866C442E97C6F5795F0AC_1245132106.addTaint(taint);
        return var2A95E65D22A866C442E97C6F5795F0AC_1245132106;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.996 -0400", hash_original_method = "65B2259A2CB290C21BDBA11C63377846", hash_generated_method = "6D3BE9CD80C69720C5849DDFD96B6F9C")
    public int getDefaultFractionDigits() {
        if(currencyCode.equals("XXX"))        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1822149274 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_103617302 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_103617302;
        } //End block
        int var6BB5405F49B27F7F9C8ED23943B2841D_289572340 = (ICU.getCurrencyFractionDigits(currencyCode));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1856804370 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1856804370;
        // ---------- Original Method ----------
        //if (currencyCode.equals("XXX")) {
            //return -1;
        //}
        //return ICU.getCurrencyFractionDigits(currencyCode);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.996 -0400", hash_original_method = "61F489343549C45D5079119B52911181", hash_generated_method = "01B3C6532A6454F5164BE032314384AC")
    @Override
    public String toString() {
String varDCA4AC53D28391F46322772F57580CB2_2131570623 =         currencyCode;
        varDCA4AC53D28391F46322772F57580CB2_2131570623.addTaint(taint);
        return varDCA4AC53D28391F46322772F57580CB2_2131570623;
        // ---------- Original Method ----------
        //return currencyCode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.996 -0400", hash_original_method = "BB7ABE2F39426123A0B73E0A126344FC", hash_generated_method = "3B9159903F88B428A8D24A96767E4028")
    private Object readResolve() {
Object varD4FA9C15216E7D131112D808565A84F6_1297834162 =         getInstance(currencyCode);
        varD4FA9C15216E7D131112D808565A84F6_1297834162.addTaint(taint);
        return varD4FA9C15216E7D131112D808565A84F6_1297834162;
        // ---------- Original Method ----------
        //return getInstance(currencyCode);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.996 -0400", hash_original_field = "12D780CD12AB6643ECC64F5BF288431B", hash_generated_field = "988408236DD0ACB2CF0402B70B74C3DC")

    private static final long serialVersionUID = -158308464356906721L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.996 -0400", hash_original_field = "AE769B985C27CF2DEBF8E931C827B573", hash_generated_field = "5DE33F779A03A1507D90CF98EB856660")

    private static final HashMap<String, Currency> codesToCurrencies = new HashMap<String, Currency>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:06.996 -0400", hash_original_field = "0E1034E42DD53FC6792DC22B36BCA0A3", hash_generated_field = "15C3858DCBF7011F3D3C46BA1E9A611E")

    private static final HashMap<Locale, Currency> localesToCurrencies = new HashMap<Locale, Currency>();
}

