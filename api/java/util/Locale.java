package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import libcore.icu.ICU;

public final class Locale implements Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.206 -0400", hash_original_field = "AF9AD4037F4BB83AC9CEB5E118E6DE1A", hash_generated_field = "19B779CD8189BCE485C226E9C90F5F3B")

    private transient String countryCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.206 -0400", hash_original_field = "3A3CB397ADE05A407F0D792E87F6F299", hash_generated_field = "2ECB9A2070EAE3399DFD4B61935BB4AA")

    private transient String languageCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.206 -0400", hash_original_field = "C4D80CF9E79B4A0C529653A1DB0E5891", hash_generated_field = "20B608C3BDA9F3FFBF7E6CEE9057B7C0")

    private transient String variantCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.207 -0400", hash_original_field = "9ACE3194BDE7C7B07D43470C11B716C5", hash_generated_field = "34675DF76648E8EBEE86B67A25EA4CB3")

    private transient String cachedToStringResult;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.207 -0400", hash_original_method = "3151080AB39B36B6870FE53962DD218F", hash_generated_method = "EE01A9EAA1684C1454F7936A22A4747D")
    private  Locale(boolean unused, String lowerCaseLanguageCode, String upperCaseCountryCode) {
        addTaint(unused);
        this.languageCode = lowerCaseLanguageCode;
        this.countryCode = upperCaseCountryCode;
        this.variantCode = "";
        // ---------- Original Method ----------
        //this.languageCode = lowerCaseLanguageCode;
        //this.countryCode = upperCaseCountryCode;
        //this.variantCode = "";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.207 -0400", hash_original_method = "95F62AD785CE7F14018E0D0D1E27B00E", hash_generated_method = "AA357B84DEB8D807A33A795D8F57D011")
    public  Locale(String language) {
        this(language, "", "");
        addTaint(language.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.208 -0400", hash_original_method = "37BC67CA8C45857B55D0F669E159529A", hash_generated_method = "69B893E13BBBAE538AF94B2DE7037E0D")
    public  Locale(String language, String country) {
        this(language, country, "");
        addTaint(country.getTaint());
        addTaint(language.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.209 -0400", hash_original_method = "C07F4523516B5D8C3B044DC468C2EE3F", hash_generated_method = "5EBC2B6992BCC0DE6A26186ABECB075F")
    public  Locale(String language, String country, String variant) {
        if(language == null || country == null || variant == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_223012093 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_223012093.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_223012093;
        } //End block
        if(language.isEmpty() && country.isEmpty())        
        {
            languageCode = "";
            countryCode = "";
            variantCode = variant;
            return;
        } //End block
        languageCode = language.toLowerCase(Locale.US);
        if(languageCode.equals("he"))        
        {
            languageCode = "iw";
        } //End block
        else
        if(languageCode.equals("id"))        
        {
            languageCode = "in";
        } //End block
        else
        if(languageCode.equals("yi"))        
        {
            languageCode = "ji";
        } //End block
        countryCode = country.toUpperCase(Locale.US);
        variantCode = variant;
        // ---------- Original Method ----------
        //if (language == null || country == null || variant == null) {
            //throw new NullPointerException();
        //}
        //if (language.isEmpty() && country.isEmpty()) {
            //languageCode = "";
            //countryCode = "";
            //variantCode = variant;
            //return;
        //}
        //languageCode = language.toLowerCase(Locale.US);
        //if (languageCode.equals("he")) {
            //languageCode = "iw";
        //} else if (languageCode.equals("id")) {
            //languageCode = "in";
        //} else if (languageCode.equals("yi")) {
            //languageCode = "ji";
        //}
        //countryCode = country.toUpperCase(Locale.US);
        //variantCode = variant;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.210 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "FFD16B126853A66E6BE81729028BC668")
    @Override
    public Object clone() {
        try 
        {
Object var46F3A0D86742C1D6E099C2B166941A33_620947978 =             super.clone();
            var46F3A0D86742C1D6E099C2B166941A33_620947978.addTaint(taint);
            return var46F3A0D86742C1D6E099C2B166941A33_620947978;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_1296995086 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_1296995086.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_1296995086;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.211 -0400", hash_original_method = "B2DF95EC92791D38C85586E37BBFDFD0", hash_generated_method = "924019700BC6543D75B8DC863263A9AF")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        if(object == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1325111343 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_102081293 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_102081293;
        } //End block
        if(object instanceof Locale)        
        {
            Locale o = (Locale) object;
            boolean var2DE04CF58E64C4EC58B7C217D560D5B4_151929887 = (languageCode.equals(o.languageCode)
                    && countryCode.equals(o.countryCode)
                    && variantCode.equals(o.variantCode));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_153001350 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_153001350;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_748643963 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1281766909 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1281766909;
        // ---------- Original Method ----------
        //if (object == this) {
            //return true;
        //}
        //if (object instanceof Locale) {
            //Locale o = (Locale) object;
            //return languageCode.equals(o.languageCode)
                    //&& countryCode.equals(o.countryCode)
                    //&& variantCode.equals(o.variantCode);
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableLocales();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.211 -0400", hash_original_method = "40EA1D1DD90B3BAB3C58BE2B6A46A98D", hash_generated_method = "207F7CE1D1E7A6E442E3E331D223595F")
    public String getCountry() {
String var306B1C24BC0EE091C63E09C6178972F6_1869099160 =         countryCode;
        var306B1C24BC0EE091C63E09C6178972F6_1869099160.addTaint(taint);
        return var306B1C24BC0EE091C63E09C6178972F6_1869099160;
        // ---------- Original Method ----------
        //return countryCode;
    }

    
    @DSModeled(DSC.SAFE)
    public static Locale getDefault() {
        return defaultLocale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.212 -0400", hash_original_method = "6B1507A0394E6A6AE91AAA3FFF27DCC6", hash_generated_method = "3198C0AF50623CAF15E041CC830D2796")
    public final String getDisplayCountry() {
String var4162A28D46B1DE98D12901CC8E93D248_662797164 =         getDisplayCountry(getDefault());
        var4162A28D46B1DE98D12901CC8E93D248_662797164.addTaint(taint);
        return var4162A28D46B1DE98D12901CC8E93D248_662797164;
        // ---------- Original Method ----------
        //return getDisplayCountry(getDefault());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.212 -0400", hash_original_method = "6391C14D02F936975118F82A1E774FAD", hash_generated_method = "842AE560EB4DA3671ADE3E46DADD6E00")
    public String getDisplayCountry(Locale locale) {
        addTaint(locale.getTaint());
        if(countryCode.isEmpty())        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1226490255 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1226490255.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1226490255;
        } //End block
        String result = ICU.getDisplayCountryNative(toString(), locale.toString());
        if(result == null)        
        {
            result = ICU.getDisplayCountryNative(toString(), Locale.getDefault().toString());
        } //End block
String varDC838461EE2FA0CA4C9BBB70A15456B0_149028870 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_149028870.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_149028870;
        // ---------- Original Method ----------
        //if (countryCode.isEmpty()) {
            //return "";
        //}
        //String result = ICU.getDisplayCountryNative(toString(), locale.toString());
        //if (result == null) { 
            //result = ICU.getDisplayCountryNative(toString(), Locale.getDefault().toString());
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.212 -0400", hash_original_method = "8536CE63A6B8A68C05EDBD72A683988E", hash_generated_method = "614974DD8C3C6993679493874D27E3E3")
    public final String getDisplayLanguage() {
String var7EDF4DE2945252F485BCACF7DA7023A8_1869526620 =         getDisplayLanguage(getDefault());
        var7EDF4DE2945252F485BCACF7DA7023A8_1869526620.addTaint(taint);
        return var7EDF4DE2945252F485BCACF7DA7023A8_1869526620;
        // ---------- Original Method ----------
        //return getDisplayLanguage(getDefault());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.213 -0400", hash_original_method = "C0028041B7C295EE912CA1345544B282", hash_generated_method = "DA2AB781A3DA3207E411F06845FFB4BD")
    public String getDisplayLanguage(Locale locale) {
        addTaint(locale.getTaint());
        if(languageCode.isEmpty())        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_116910623 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_116910623.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_116910623;
        } //End block
        String result = ICU.getDisplayLanguageNative(toString(), locale.toString());
        if(result == null)        
        {
            result = ICU.getDisplayLanguageNative(toString(), Locale.getDefault().toString());
        } //End block
String varDC838461EE2FA0CA4C9BBB70A15456B0_1454648026 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1454648026.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1454648026;
        // ---------- Original Method ----------
        //if (languageCode.isEmpty()) {
            //return "";
        //}
        //String result = ICU.getDisplayLanguageNative(toString(), locale.toString());
        //if (result == null) { 
            //result = ICU.getDisplayLanguageNative(toString(), Locale.getDefault().toString());
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.213 -0400", hash_original_method = "CBF375FE343ED989DA3B5B8CCC8BE7E0", hash_generated_method = "54C6690660CB943DF7C0C3C11D2A7404")
    public final String getDisplayName() {
String var5FFBDDC73BB3304503DF2B5423E14A46_1235144859 =         getDisplayName(getDefault());
        var5FFBDDC73BB3304503DF2B5423E14A46_1235144859.addTaint(taint);
        return var5FFBDDC73BB3304503DF2B5423E14A46_1235144859;
        // ---------- Original Method ----------
        //return getDisplayName(getDefault());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.213 -0400", hash_original_method = "82746EC2958D563F59B7A18594C66ADB", hash_generated_method = "16F0DF629A9BA59E60156CE732C52E8F")
    public String getDisplayName(Locale locale) {
        addTaint(locale.getTaint());
        int count = 0;
        StringBuilder buffer = new StringBuilder();
        if(!languageCode.isEmpty())        
        {
            String displayLanguage = getDisplayLanguage(locale);
            buffer.append(displayLanguage.isEmpty() ? languageCode : displayLanguage);
            ++count;
        } //End block
        if(!countryCode.isEmpty())        
        {
            if(count == 1)            
            {
                buffer.append(" (");
            } //End block
            String displayCountry = getDisplayCountry(locale);
            buffer.append(displayCountry.isEmpty() ? countryCode : displayCountry);
            ++count;
        } //End block
        if(!variantCode.isEmpty())        
        {
            if(count == 1)            
            {
                buffer.append(" (");
            } //End block
            else
            if(count == 2)            
            {
                buffer.append(",");
            } //End block
            String displayVariant = getDisplayVariant(locale);
            buffer.append(displayVariant.isEmpty() ? variantCode : displayVariant);
            ++count;
        } //End block
        if(count > 1)        
        {
            buffer.append(")");
        } //End block
String varD03843288D33B9E1D3062E25339ECF6D_1998336774 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_1998336774.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_1998336774;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.214 -0400", hash_original_method = "A8FFA206A883AC51133D493CCCB1ED67", hash_generated_method = "F6CC123F9C40B61C8A8D063C684328F8")
    public final String getDisplayVariant() {
String varB73190F85C04E5DCE591881F28A0B6BC_724328995 =         getDisplayVariant(getDefault());
        varB73190F85C04E5DCE591881F28A0B6BC_724328995.addTaint(taint);
        return varB73190F85C04E5DCE591881F28A0B6BC_724328995;
        // ---------- Original Method ----------
        //return getDisplayVariant(getDefault());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.214 -0400", hash_original_method = "4A12574A7D5205BB7F7224B1AB3BA842", hash_generated_method = "872CBB3FF0AE35660B1FCD5868DAB55F")
    public String getDisplayVariant(Locale locale) {
        addTaint(locale.getTaint());
        if(variantCode.length() == 0)        
        {
String varFF6608C6BB8A10EA44ED34D897B0E991_1835433390 =             variantCode;
            varFF6608C6BB8A10EA44ED34D897B0E991_1835433390.addTaint(taint);
            return varFF6608C6BB8A10EA44ED34D897B0E991_1835433390;
        } //End block
        String result = ICU.getDisplayVariantNative(toString(), locale.toString());
        if(result == null)        
        {
            result = ICU.getDisplayVariantNative(toString(), Locale.getDefault().toString());
        } //End block
String varDC838461EE2FA0CA4C9BBB70A15456B0_452997950 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_452997950.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_452997950;
        // ---------- Original Method ----------
        //if (variantCode.length() == 0) {
            //return variantCode;
        //}
        //String result = ICU.getDisplayVariantNative(toString(), locale.toString());
        //if (result == null) { 
            //result = ICU.getDisplayVariantNative(toString(), Locale.getDefault().toString());
        //}
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.214 -0400", hash_original_method = "E7148683E6358C89AEF160E990AAEE93", hash_generated_method = "036182D8CC24E4AC09098A22FDE60861")
    public String getISO3Country() {
        if(countryCode.length() == 0)        
        {
String var306B1C24BC0EE091C63E09C6178972F6_919319723 =             countryCode;
            var306B1C24BC0EE091C63E09C6178972F6_919319723.addTaint(taint);
            return var306B1C24BC0EE091C63E09C6178972F6_919319723;
        } //End block
String varC3479BF156E1D68A215A279AC7D244A6_1184597601 =         ICU.getISO3CountryNative(toString());
        varC3479BF156E1D68A215A279AC7D244A6_1184597601.addTaint(taint);
        return varC3479BF156E1D68A215A279AC7D244A6_1184597601;
        // ---------- Original Method ----------
        //if (countryCode.length() == 0) {
            //return countryCode;
        //}
        //return ICU.getISO3CountryNative(toString());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.215 -0400", hash_original_method = "10ED62717CAC900A278627831D37EC4E", hash_generated_method = "C0995FD541F936F263404E3623F56C64")
    public String getISO3Language() {
        if(languageCode.length() == 0)        
        {
String var3B648CECCAFE6CC0C14E6B5112DF42CA_471217093 =             languageCode;
            var3B648CECCAFE6CC0C14E6B5112DF42CA_471217093.addTaint(taint);
            return var3B648CECCAFE6CC0C14E6B5112DF42CA_471217093;
        } //End block
String var1E83AAAD5E709395BB9CA6BB58BCA009_433656015 =         ICU.getISO3LanguageNative(toString());
        var1E83AAAD5E709395BB9CA6BB58BCA009_433656015.addTaint(taint);
        return var1E83AAAD5E709395BB9CA6BB58BCA009_433656015;
        // ---------- Original Method ----------
        //if (languageCode.length() == 0) {
            //return languageCode;
        //}
        //return ICU.getISO3LanguageNative(toString());
    }

    
    @DSModeled(DSC.SAFE)
    public static String[] getISOCountries() {
        return ICU.getISOCountries();
    }

    
    @DSModeled(DSC.SAFE)
    public static String[] getISOLanguages() {
        return ICU.getISOLanguages();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.215 -0400", hash_original_method = "1C720E5AEB210852D4C515195DCC49D3", hash_generated_method = "21E84C0C0506F5FBD2482B7C109DEFDE")
    public String getLanguage() {
String var3B648CECCAFE6CC0C14E6B5112DF42CA_643780519 =         languageCode;
        var3B648CECCAFE6CC0C14E6B5112DF42CA_643780519.addTaint(taint);
        return var3B648CECCAFE6CC0C14E6B5112DF42CA_643780519;
        // ---------- Original Method ----------
        //return languageCode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.216 -0400", hash_original_method = "A8C86ADBDB8FE1FD75DA90D3A9B92BDE", hash_generated_method = "52C0CA8D6BE0935BCE3D4AC2D0D554CA")
    public String getVariant() {
String varFF6608C6BB8A10EA44ED34D897B0E991_887952145 =         variantCode;
        varFF6608C6BB8A10EA44ED34D897B0E991_887952145.addTaint(taint);
        return varFF6608C6BB8A10EA44ED34D897B0E991_887952145;
        // ---------- Original Method ----------
        //return variantCode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.216 -0400", hash_original_method = "206F92E8CAE7869CD0834AB1BBCCF6BE", hash_generated_method = "3154581E58914E44F02A68C283CE1C2D")
    @Override
    public synchronized int hashCode() {
        int varB43AFB492ED227CEFAE1AFA8A34A6DE5_2032632303 = (countryCode.hashCode() + languageCode.hashCode()
                + variantCode.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_261999625 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_261999625;
        // ---------- Original Method ----------
        //return countryCode.hashCode() + languageCode.hashCode()
                //+ variantCode.hashCode();
    }

    
    @DSModeled(DSC.SAFE)
    public synchronized static void setDefault(Locale locale) {
        if (locale == null) {
            throw new NullPointerException();
        }
        defaultLocale = locale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.217 -0400", hash_original_method = "8023BB72D2CCCB0AE8421793FA5DB667", hash_generated_method = "D199EBFDF95A6DC8072EA310C5E76102")
    @Override
    public final String toString() {
        String result = cachedToStringResult;
String var66D22B56B8793B92BBBBA1F207965C13_851066035 =         (result == null) ? (cachedToStringResult = toNewString()) : result;
        var66D22B56B8793B92BBBBA1F207965C13_851066035.addTaint(taint);
        return var66D22B56B8793B92BBBBA1F207965C13_851066035;
        // ---------- Original Method ----------
        //String result = cachedToStringResult;
        //return (result == null) ? (cachedToStringResult = toNewString()) : result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.217 -0400", hash_original_method = "C73C94720A0586E8BA389B0E4B761A7E", hash_generated_method = "7DE619ECEC88113AD1C6753FBD486E6B")
    private String toNewString() {
        if(languageCode.length() == 0 && countryCode.length() == 0)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_772401659 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_772401659.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_772401659;
        } //End block
        StringBuilder result = new StringBuilder(11);
        result.append(languageCode);
        if(countryCode.length() > 0 || variantCode.length() > 0)        
        {
            result.append('_');
        } //End block
        result.append(countryCode);
        if(variantCode.length() > 0)        
        {
            result.append('_');
        } //End block
        result.append(variantCode);
String varE65B3A02759122992CB82C0E651AD408_1482555691 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_1482555691.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_1482555691;
        // ---------- Original Method ----------
        //if (languageCode.length() == 0 && countryCode.length() == 0) {
            //return "";
        //}
        //StringBuilder result = new StringBuilder(11);
        //result.append(languageCode);
        //if (countryCode.length() > 0 || variantCode.length() > 0) {
            //result.append('_');
        //}
        //result.append(countryCode);
        //if (variantCode.length() > 0) {
            //result.append('_');
        //}
        //result.append(variantCode);
        //return result.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.217 -0400", hash_original_method = "03500CE785032DF09CF1C69BAF02C627", hash_generated_method = "451531EC6CFF215571930AE6226FD5CC")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        addTaint(stream.getTaint());
        ObjectOutputStream.PutField fields = stream.putFields();
        fields.put("country", countryCode);
        fields.put("hashcode", -1);
        fields.put("language", languageCode);
        fields.put("variant", variantCode);
        stream.writeFields();
        // ---------- Original Method ----------
        //ObjectOutputStream.PutField fields = stream.putFields();
        //fields.put("country", countryCode);
        //fields.put("hashcode", -1);
        //fields.put("language", languageCode);
        //fields.put("variant", variantCode);
        //stream.writeFields();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.218 -0400", hash_original_method = "119900B43F45E61950B2C4FD2DBBE050", hash_generated_method = "D3338A68F22AB0AA28E6AF440D44E529")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        addTaint(stream.getTaint());
        ObjectInputStream.GetField fields = stream.readFields();
        countryCode = (String) fields.get("country", "");
        languageCode = (String) fields.get("language", "");
        variantCode = (String) fields.get("variant", "");
        // ---------- Original Method ----------
        //ObjectInputStream.GetField fields = stream.readFields();
        //countryCode = (String) fields.get("country", "");
        //languageCode = (String) fields.get("language", "");
        //variantCode = (String) fields.get("variant", "");
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.218 -0400", hash_original_field = "18DA9B5D151863655E40910EB4A12CE3", hash_generated_field = "3C249CD2C44FDE2FABB9E6465C331B47")

    private static final long serialVersionUID = 9149081749638150636L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.218 -0400", hash_original_field = "6BF363EA1A8DE86B5AC0377FA794F11F", hash_generated_field = "7BDD40E7897A0B20ED68158A0E65F590")

    public static final Locale CANADA = new Locale(true, "en", "CA");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.218 -0400", hash_original_field = "BFBF652CF675E54322886752FC940A96", hash_generated_field = "6892784792C9F34D39D8FEB23F4ECC7C")

    public static final Locale CANADA_FRENCH = new Locale(true, "fr", "CA");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.218 -0400", hash_original_field = "5DC13621D42D47291E1A23AFEEE5B4A6", hash_generated_field = "815F7BAFEA33E18C6C585964A4AAD2BF")

    public static final Locale CHINA = new Locale(true, "zh", "CN");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.218 -0400", hash_original_field = "F645BAE03C0192FC36BF37B93340CF96", hash_generated_field = "2AFCDD9168470113B6C8F8A14E381616")

    public static final Locale CHINESE = new Locale(true, "zh", "");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.218 -0400", hash_original_field = "B517792B30100A2D1A29CBC8D54CD474", hash_generated_field = "010EE953058E1394EC388C06EEEFF35C")

    public static final Locale ENGLISH = new Locale(true, "en", "");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.219 -0400", hash_original_field = "0DECFD7B4501C8DA6FED0A7D48FA7CF6", hash_generated_field = "4121FCC78DA601AEAC97C367E5C6E05D")

    public static final Locale FRANCE = new Locale(true, "fr", "FR");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.219 -0400", hash_original_field = "06CE2784C44649FD8CC4EBD2B3B4ED42", hash_generated_field = "CBA5E07F7E68529CF82B9E96AF4E3809")

    public static final Locale FRENCH = new Locale(true, "fr", "");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.219 -0400", hash_original_field = "D67AA0F18FF909C546981ECCC69A895A", hash_generated_field = "B7E2C8DE81F1356E34A1BFA17F499BB8")

    public static final Locale GERMAN = new Locale(true, "de", "");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.219 -0400", hash_original_field = "35A9E98B2A7845D0BED0CAA90C6E1B3C", hash_generated_field = "99C12CF22E8A302C658D06A543E6ABC9")

    public static final Locale GERMANY = new Locale(true, "de", "DE");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.219 -0400", hash_original_field = "37ED88901F01E6C58DA9BA4B969D92FC", hash_generated_field = "A3398381AD52B8EE49ECC3C156390428")

    public static final Locale ITALIAN = new Locale(true, "it", "");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.219 -0400", hash_original_field = "6FFA395B3193069456AEA18A75551201", hash_generated_field = "6B8F2AEFB85A9DDE96656C221445E060")

    public static final Locale ITALY = new Locale(true, "it", "IT");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.219 -0400", hash_original_field = "7A4BF0EBA8C1C4155D7E16424E30466A", hash_generated_field = "ADB1EFC498D0885F1C7D82EFDC8A762E")

    public static final Locale JAPAN = new Locale(true, "ja", "JP");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.219 -0400", hash_original_field = "866D24DCD5CB4CB16E0A97F97B10599A", hash_generated_field = "E9F0251CDBFB0D682860A91571CF2885")

    public static final Locale JAPANESE = new Locale(true, "ja", "");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.219 -0400", hash_original_field = "6B47FF8AA94A86727A705B65745CEBEF", hash_generated_field = "CB8453466B2EFA0F4D4DB63AEF3DF7B9")

    public static final Locale KOREA = new Locale(true, "ko", "KR");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.219 -0400", hash_original_field = "DE9D9B65EC42AB12EC074817D13D6C8B", hash_generated_field = "D94D062AFAC409AAE6CD164AF870C246")

    public static final Locale KOREAN = new Locale(true, "ko", "");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.219 -0400", hash_original_field = "94857004AC24363C83FD06F5422E404C", hash_generated_field = "8FCD51D6A9283D26C9714E64D8EA8DFE")

    public static final Locale PRC = new Locale(true, "zh", "CN");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.219 -0400", hash_original_field = "C121102F6AA0785D597B6A961998BAE6", hash_generated_field = "C5D08DD56BA40521153147D2F8DF528D")

    public static final Locale ROOT = new Locale(true, "", "");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.219 -0400", hash_original_field = "BEB2DE091D7CD44A849D4FDE17801C6E", hash_generated_field = "C9504C68B180C678A4DDB8147C15B90F")

    public static final Locale SIMPLIFIED_CHINESE = new Locale(true, "zh", "CN");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.219 -0400", hash_original_field = "9F9ED1B34DCEEA793B9F2502F103BC49", hash_generated_field = "2187C3D4D669572A201125FA3D3DF376")

    public static final Locale TAIWAN = new Locale(true, "zh", "TW");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.219 -0400", hash_original_field = "A6C3D0A04F6A5058865AC79A7745E81B", hash_generated_field = "FEBC7896ADE07EF3D8CF22757D61F030")

    public static final Locale TRADITIONAL_CHINESE = new Locale(true, "zh", "TW");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.219 -0400", hash_original_field = "3558BCA0BFA1F389CDCC1EFD60F74115", hash_generated_field = "107ED72C23A2F8F9913FA2417A93830D")

    public static final Locale UK = new Locale(true, "en", "GB");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.219 -0400", hash_original_field = "9E7BBDDA07AD4A3962C1F38EF8DDAC19", hash_generated_field = "CCE42131F2E9126D82844E6ECA655BD3")

    public static final Locale US = new Locale(true, "en", "US");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.219 -0400", hash_original_field = "4887A8DD11208FE3C42BAF38E09F0C96", hash_generated_field = "982529EBDC2FA2E697C9C08FE118F9D9")

    private static Locale defaultLocale = US;
    static {
        String language = System.getProperty("user.language", "en");
        String region = System.getProperty("user.region", "US");
        String variant = System.getProperty("user.variant", "");
        defaultLocale = new Locale(language, region, variant);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.219 -0400", hash_original_field = "5901E35E9EA50F2714379B11227EB9C4", hash_generated_field = "E179BF6620C821162D69DC2C844B9C9A")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("country", String.class),
        new ObjectStreamField("hashcode", int.class),
        new ObjectStreamField("language", String.class),
        new ObjectStreamField("variant", String.class),
    };
}

