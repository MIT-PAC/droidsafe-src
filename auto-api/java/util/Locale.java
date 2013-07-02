package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import libcore.icu.ICU;

public final class Locale implements Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.204 -0400", hash_original_field = "AF9AD4037F4BB83AC9CEB5E118E6DE1A", hash_generated_field = "19B779CD8189BCE485C226E9C90F5F3B")

    private transient String countryCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.204 -0400", hash_original_field = "3A3CB397ADE05A407F0D792E87F6F299", hash_generated_field = "2ECB9A2070EAE3399DFD4B61935BB4AA")

    private transient String languageCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.204 -0400", hash_original_field = "C4D80CF9E79B4A0C529653A1DB0E5891", hash_generated_field = "20B608C3BDA9F3FFBF7E6CEE9057B7C0")

    private transient String variantCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.204 -0400", hash_original_field = "9ACE3194BDE7C7B07D43470C11B716C5", hash_generated_field = "34675DF76648E8EBEE86B67A25EA4CB3")

    private transient String cachedToStringResult;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.205 -0400", hash_original_method = "3151080AB39B36B6870FE53962DD218F", hash_generated_method = "B8525880001D0CFB2824C4EF006E6CE5")
    private  Locale(boolean unused, String lowerCaseLanguageCode, String upperCaseCountryCode) {
        this.languageCode = lowerCaseLanguageCode;
        this.countryCode = upperCaseCountryCode;
        this.variantCode = "";
        addTaint(unused);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.205 -0400", hash_original_method = "95F62AD785CE7F14018E0D0D1E27B00E", hash_generated_method = "AA357B84DEB8D807A33A795D8F57D011")
    public  Locale(String language) {
        this(language, "", "");
        addTaint(language.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.205 -0400", hash_original_method = "37BC67CA8C45857B55D0F669E159529A", hash_generated_method = "6C060AC0D66A842880688D936B6EEAFB")
    public  Locale(String language, String country) {
        this(language, country, "");
        addTaint(language.getTaint());
        addTaint(country.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.206 -0400", hash_original_method = "C07F4523516B5D8C3B044DC468C2EE3F", hash_generated_method = "52BF159FDAFF0FA68BB9E4BC9A9DDB63")
    public  Locale(String language, String country, String variant) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        {
            boolean var17F6FDFF37BC30D399CD41E1E481E2CE_1805487353 = (language.isEmpty() && country.isEmpty());
            {
                languageCode = "";
                countryCode = "";
                variantCode = variant;
            } 
        } 
        languageCode = language.toLowerCase(Locale.US);
        {
            boolean var88B3A49202DE1B8033707F4C2B73C3A6_2087878296 = (languageCode.equals("he"));
            {
                languageCode = "iw";
            } 
            {
                boolean var48FBA8ACF9EAD6B66139FA4B3FE15951_73233445 = (languageCode.equals("id"));
                {
                    languageCode = "in";
                } 
                {
                    boolean var5B3211E51E6B494A37194C37EDA1B0D5_1141632937 = (languageCode.equals("yi"));
                    {
                        languageCode = "ji";
                    } 
                } 
            } 
        } 
        countryCode = country.toUpperCase(Locale.US);
        variantCode = variant;
        
        
            
        
        
            
            
            
            
        
        
        
            
        
            
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.207 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "187A066AFB358D386274C93C3D023724")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1142556829 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1142556829 = super.clone();
        } 
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1142556829.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1142556829;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.209 -0400", hash_original_method = "B2DF95EC92791D38C85586E37BBFDFD0", hash_generated_method = "66652CCC7D992239003A0F5CA1B7ECBD")
    @Override
    public boolean equals(Object object) {
        {
            boolean var3F549205D4C262003697A031F89E5954_267249708 = (object == this);
        } 
        {
            Locale o = (Locale) object;
            boolean var0304798EE1CBEE36CAD75CC155557DCC_1656942844 = (languageCode.equals(o.languageCode)
                    && countryCode.equals(o.countryCode)
                    && variantCode.equals(o.variantCode));
        } 
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1423967504 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1423967504;
        
        
            
        
        
            
            
                    
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableLocales();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.210 -0400", hash_original_method = "40EA1D1DD90B3BAB3C58BE2B6A46A98D", hash_generated_method = "C92174AB3AA4172CCB8E3F46EDC01B31")
    public String getCountry() {
        String varB4EAC82CA7396A68D541C85D26508E83_1240303686 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1240303686 = countryCode;
        varB4EAC82CA7396A68D541C85D26508E83_1240303686.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1240303686;
        
        
    }

    
    public static Locale getDefault() {
        return defaultLocale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.210 -0400", hash_original_method = "6B1507A0394E6A6AE91AAA3FFF27DCC6", hash_generated_method = "E89E6106C2BDEE2DC6863D0CD6AACC73")
    public final String getDisplayCountry() {
        String varB4EAC82CA7396A68D541C85D26508E83_754660363 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_754660363 = getDisplayCountry(getDefault());
        varB4EAC82CA7396A68D541C85D26508E83_754660363.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_754660363;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.211 -0400", hash_original_method = "6391C14D02F936975118F82A1E774FAD", hash_generated_method = "CD965D0DD8C723EC2D19E59126B6CE6C")
    public String getDisplayCountry(Locale locale) {
        String varB4EAC82CA7396A68D541C85D26508E83_656588618 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1847475079 = null; 
        {
            boolean varC33211C406C1C4EFA2F1535CC7F3910E_1308925605 = (countryCode.isEmpty());
            {
                varB4EAC82CA7396A68D541C85D26508E83_656588618 = "";
            } 
        } 
        String result = ICU.getDisplayCountryNative(toString(), locale.toString());
        {
            result = ICU.getDisplayCountryNative(toString(), Locale.getDefault().toString());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1847475079 = result;
        addTaint(locale.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1891537896; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1891537896 = varB4EAC82CA7396A68D541C85D26508E83_656588618;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1891537896 = varB4EAC82CA7396A68D541C85D26508E83_1847475079;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1891537896.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1891537896;
        
        
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.211 -0400", hash_original_method = "8536CE63A6B8A68C05EDBD72A683988E", hash_generated_method = "C74F05258ADA00F50415CF22C9469DD8")
    public final String getDisplayLanguage() {
        String varB4EAC82CA7396A68D541C85D26508E83_115576608 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_115576608 = getDisplayLanguage(getDefault());
        varB4EAC82CA7396A68D541C85D26508E83_115576608.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_115576608;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.212 -0400", hash_original_method = "C0028041B7C295EE912CA1345544B282", hash_generated_method = "D06F4D33C2D1585D38D94678B88D007A")
    public String getDisplayLanguage(Locale locale) {
        String varB4EAC82CA7396A68D541C85D26508E83_93264376 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1022365779 = null; 
        {
            boolean var0FEF216489AE51E4D4C267CA08E5B9A9_1786863392 = (languageCode.isEmpty());
            {
                varB4EAC82CA7396A68D541C85D26508E83_93264376 = "";
            } 
        } 
        String result = ICU.getDisplayLanguageNative(toString(), locale.toString());
        {
            result = ICU.getDisplayLanguageNative(toString(), Locale.getDefault().toString());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1022365779 = result;
        addTaint(locale.getTaint());
        String varA7E53CE21691AB073D9660D615818899_432704426; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_432704426 = varB4EAC82CA7396A68D541C85D26508E83_93264376;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_432704426 = varB4EAC82CA7396A68D541C85D26508E83_1022365779;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_432704426.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_432704426;
        
        
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.213 -0400", hash_original_method = "CBF375FE343ED989DA3B5B8CCC8BE7E0", hash_generated_method = "31E9A343F0E139FC343EFB504F910FE6")
    public final String getDisplayName() {
        String varB4EAC82CA7396A68D541C85D26508E83_600232164 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_600232164 = getDisplayName(getDefault());
        varB4EAC82CA7396A68D541C85D26508E83_600232164.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_600232164;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.213 -0400", hash_original_method = "82746EC2958D563F59B7A18594C66ADB", hash_generated_method = "235758DF4E1085DE110EC7A59E2FBCB4")
    public String getDisplayName(Locale locale) {
        String varB4EAC82CA7396A68D541C85D26508E83_2107675580 = null; 
        int count = 0;
        StringBuilder buffer = new StringBuilder();
        {
            boolean var8F29E112827E9BD79EAC9633D3FFCA6B_2135446325 = (!languageCode.isEmpty());
            {
                String displayLanguage = getDisplayLanguage(locale);
                buffer.append(displayLanguage.isEmpty() ? languageCode : displayLanguage);
            } 
        } 
        {
            boolean varBCFFDF6DE02D3D82ADC2B64B371D3030_1327713867 = (!countryCode.isEmpty());
            {
                {
                    buffer.append(" (");
                } 
                String displayCountry = getDisplayCountry(locale);
                buffer.append(displayCountry.isEmpty() ? countryCode : displayCountry);
            } 
        } 
        {
            boolean var2765EBC38A2EE33A058AF3B323D9B258_664175647 = (!variantCode.isEmpty());
            {
                {
                    buffer.append(" (");
                } 
                {
                    buffer.append(",");
                } 
                String displayVariant = getDisplayVariant(locale);
                buffer.append(displayVariant.isEmpty() ? variantCode : displayVariant);
            } 
        } 
        {
            buffer.append(")");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2107675580 = buffer.toString();
        addTaint(locale.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2107675580.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2107675580;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.214 -0400", hash_original_method = "A8FFA206A883AC51133D493CCCB1ED67", hash_generated_method = "593B590A77C5C2D96A4672BDF1F6BAC2")
    public final String getDisplayVariant() {
        String varB4EAC82CA7396A68D541C85D26508E83_187091114 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_187091114 = getDisplayVariant(getDefault());
        varB4EAC82CA7396A68D541C85D26508E83_187091114.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_187091114;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.215 -0400", hash_original_method = "4A12574A7D5205BB7F7224B1AB3BA842", hash_generated_method = "F161A449A73891ED4059C049D23AD10E")
    public String getDisplayVariant(Locale locale) {
        String varB4EAC82CA7396A68D541C85D26508E83_297993286 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1898881018 = null; 
        {
            boolean var2B0047DE9038ECDA2703DC74AA6453D5_2013637666 = (variantCode.length() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_297993286 = variantCode;
            } 
        } 
        String result = ICU.getDisplayVariantNative(toString(), locale.toString());
        {
            result = ICU.getDisplayVariantNative(toString(), Locale.getDefault().toString());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1898881018 = result;
        addTaint(locale.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1713958758; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1713958758 = varB4EAC82CA7396A68D541C85D26508E83_297993286;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1713958758 = varB4EAC82CA7396A68D541C85D26508E83_1898881018;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1713958758.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1713958758;
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.216 -0400", hash_original_method = "E7148683E6358C89AEF160E990AAEE93", hash_generated_method = "B4A54C3C0C34A327FFB9074A2904BE1D")
    public String getISO3Country() {
        String varB4EAC82CA7396A68D541C85D26508E83_1001062189 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_598600991 = null; 
        {
            boolean varEEE0CD3F3CB38C3CE139809FBEC698B9_1087009905 = (countryCode.length() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1001062189 = countryCode;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_598600991 = ICU.getISO3CountryNative(toString());
        String varA7E53CE21691AB073D9660D615818899_524367624; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_524367624 = varB4EAC82CA7396A68D541C85D26508E83_1001062189;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_524367624 = varB4EAC82CA7396A68D541C85D26508E83_598600991;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_524367624.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_524367624;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.217 -0400", hash_original_method = "10ED62717CAC900A278627831D37EC4E", hash_generated_method = "B47DBEB6121ECFDFE7E264D9B5CB8AB4")
    public String getISO3Language() {
        String varB4EAC82CA7396A68D541C85D26508E83_1851726711 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1382379775 = null; 
        {
            boolean var705C215E009953572112B52C38E1CF29_1981915094 = (languageCode.length() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1851726711 = languageCode;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1382379775 = ICU.getISO3LanguageNative(toString());
        String varA7E53CE21691AB073D9660D615818899_899991216; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_899991216 = varB4EAC82CA7396A68D541C85D26508E83_1851726711;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_899991216 = varB4EAC82CA7396A68D541C85D26508E83_1382379775;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_899991216.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_899991216;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static String[] getISOCountries() {
        return ICU.getISOCountries();
    }

    
    @DSModeled(DSC.SAFE)
    public static String[] getISOLanguages() {
        return ICU.getISOLanguages();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.218 -0400", hash_original_method = "1C720E5AEB210852D4C515195DCC49D3", hash_generated_method = "363EC3A26D8CC87A01ED7BC9AA09BB09")
    public String getLanguage() {
        String varB4EAC82CA7396A68D541C85D26508E83_2044795253 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2044795253 = languageCode;
        varB4EAC82CA7396A68D541C85D26508E83_2044795253.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2044795253;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.218 -0400", hash_original_method = "A8C86ADBDB8FE1FD75DA90D3A9B92BDE", hash_generated_method = "FF8DAA1A1DC33A34A6E90EA282CE9769")
    public String getVariant() {
        String varB4EAC82CA7396A68D541C85D26508E83_589541278 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_589541278 = variantCode;
        varB4EAC82CA7396A68D541C85D26508E83_589541278.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_589541278;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.219 -0400", hash_original_method = "206F92E8CAE7869CD0834AB1BBCCF6BE", hash_generated_method = "6C06F562D2D0E05958878DE52EEA8B68")
    @Override
    public synchronized int hashCode() {
        int var713A412AC71EDAB741EF0A5EA28035CE_276491461 = (countryCode.hashCode() + languageCode.hashCode()
                + variantCode.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1198583281 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1198583281;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    public synchronized static void setDefault(Locale locale) {
        if (locale == null) {
            throw new NullPointerException();
        }
        defaultLocale = locale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.219 -0400", hash_original_method = "8023BB72D2CCCB0AE8421793FA5DB667", hash_generated_method = "E9DC83C2F19EF4FB0E8F0AFAFD345F9A")
    @Override
    public final String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1518751620 = null; 
        String result = cachedToStringResult;
        varB4EAC82CA7396A68D541C85D26508E83_1518751620 = (result == null) ? (cachedToStringResult = toNewString()) : result;
        varB4EAC82CA7396A68D541C85D26508E83_1518751620.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1518751620;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.220 -0400", hash_original_method = "C73C94720A0586E8BA389B0E4B761A7E", hash_generated_method = "BCE96F73647F186D05420827C9B44CC7")
    private String toNewString() {
        String varB4EAC82CA7396A68D541C85D26508E83_467685284 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1455130220 = null; 
        {
            boolean var477BD50214513067E9CE857B6E4A4436_1208561049 = (languageCode.length() == 0 && countryCode.length() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_467685284 = "";
            } 
        } 
        StringBuilder result = new StringBuilder(11);
        result.append(languageCode);
        {
            boolean var7985240C78B818263278A990811D7703_1429094606 = (countryCode.length() > 0 || variantCode.length() > 0);
            {
                result.append('_');
            } 
        } 
        result.append(countryCode);
        {
            boolean var5529CB82C32A642B7E90788B9461B87C_851288958 = (variantCode.length() > 0);
            {
                result.append('_');
            } 
        } 
        result.append(variantCode);
        varB4EAC82CA7396A68D541C85D26508E83_1455130220 = result.toString();
        String varA7E53CE21691AB073D9660D615818899_192464435; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_192464435 = varB4EAC82CA7396A68D541C85D26508E83_467685284;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_192464435 = varB4EAC82CA7396A68D541C85D26508E83_1455130220;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_192464435.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_192464435;
        
        
            
        
        
        
        
            
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.221 -0400", hash_original_method = "03500CE785032DF09CF1C69BAF02C627", hash_generated_method = "5B31048148B62FA35ABE36F59C9BB241")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        ObjectOutputStream.PutField fields = stream.putFields();
        fields.put("country", countryCode);
        fields.put("hashcode", -1);
        fields.put("language", languageCode);
        fields.put("variant", variantCode);
        stream.writeFields();
        addTaint(stream.getTaint());
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.222 -0400", hash_original_method = "119900B43F45E61950B2C4FD2DBBE050", hash_generated_method = "96105A65FA520BCB4E76A71AC62B5F44")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = stream.readFields();
        countryCode = (String) fields.get("country", "");
        languageCode = (String) fields.get("language", "");
        variantCode = (String) fields.get("variant", "");
        addTaint(stream.getTaint());
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.222 -0400", hash_original_field = "18DA9B5D151863655E40910EB4A12CE3", hash_generated_field = "3C249CD2C44FDE2FABB9E6465C331B47")

    private static final long serialVersionUID = 9149081749638150636L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.222 -0400", hash_original_field = "6BF363EA1A8DE86B5AC0377FA794F11F", hash_generated_field = "7BDD40E7897A0B20ED68158A0E65F590")

    public static final Locale CANADA = new Locale(true, "en", "CA");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.222 -0400", hash_original_field = "BFBF652CF675E54322886752FC940A96", hash_generated_field = "6892784792C9F34D39D8FEB23F4ECC7C")

    public static final Locale CANADA_FRENCH = new Locale(true, "fr", "CA");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.222 -0400", hash_original_field = "5DC13621D42D47291E1A23AFEEE5B4A6", hash_generated_field = "815F7BAFEA33E18C6C585964A4AAD2BF")

    public static final Locale CHINA = new Locale(true, "zh", "CN");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.222 -0400", hash_original_field = "F645BAE03C0192FC36BF37B93340CF96", hash_generated_field = "2AFCDD9168470113B6C8F8A14E381616")

    public static final Locale CHINESE = new Locale(true, "zh", "");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.223 -0400", hash_original_field = "B517792B30100A2D1A29CBC8D54CD474", hash_generated_field = "010EE953058E1394EC388C06EEEFF35C")

    public static final Locale ENGLISH = new Locale(true, "en", "");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.223 -0400", hash_original_field = "0DECFD7B4501C8DA6FED0A7D48FA7CF6", hash_generated_field = "4121FCC78DA601AEAC97C367E5C6E05D")

    public static final Locale FRANCE = new Locale(true, "fr", "FR");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.223 -0400", hash_original_field = "06CE2784C44649FD8CC4EBD2B3B4ED42", hash_generated_field = "CBA5E07F7E68529CF82B9E96AF4E3809")

    public static final Locale FRENCH = new Locale(true, "fr", "");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.223 -0400", hash_original_field = "D67AA0F18FF909C546981ECCC69A895A", hash_generated_field = "B7E2C8DE81F1356E34A1BFA17F499BB8")

    public static final Locale GERMAN = new Locale(true, "de", "");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.223 -0400", hash_original_field = "35A9E98B2A7845D0BED0CAA90C6E1B3C", hash_generated_field = "99C12CF22E8A302C658D06A543E6ABC9")

    public static final Locale GERMANY = new Locale(true, "de", "DE");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.223 -0400", hash_original_field = "37ED88901F01E6C58DA9BA4B969D92FC", hash_generated_field = "A3398381AD52B8EE49ECC3C156390428")

    public static final Locale ITALIAN = new Locale(true, "it", "");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.223 -0400", hash_original_field = "6FFA395B3193069456AEA18A75551201", hash_generated_field = "6B8F2AEFB85A9DDE96656C221445E060")

    public static final Locale ITALY = new Locale(true, "it", "IT");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.223 -0400", hash_original_field = "7A4BF0EBA8C1C4155D7E16424E30466A", hash_generated_field = "ADB1EFC498D0885F1C7D82EFDC8A762E")

    public static final Locale JAPAN = new Locale(true, "ja", "JP");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.223 -0400", hash_original_field = "866D24DCD5CB4CB16E0A97F97B10599A", hash_generated_field = "E9F0251CDBFB0D682860A91571CF2885")

    public static final Locale JAPANESE = new Locale(true, "ja", "");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.223 -0400", hash_original_field = "6B47FF8AA94A86727A705B65745CEBEF", hash_generated_field = "CB8453466B2EFA0F4D4DB63AEF3DF7B9")

    public static final Locale KOREA = new Locale(true, "ko", "KR");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.223 -0400", hash_original_field = "DE9D9B65EC42AB12EC074817D13D6C8B", hash_generated_field = "D94D062AFAC409AAE6CD164AF870C246")

    public static final Locale KOREAN = new Locale(true, "ko", "");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.223 -0400", hash_original_field = "94857004AC24363C83FD06F5422E404C", hash_generated_field = "8FCD51D6A9283D26C9714E64D8EA8DFE")

    public static final Locale PRC = new Locale(true, "zh", "CN");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.223 -0400", hash_original_field = "C121102F6AA0785D597B6A961998BAE6", hash_generated_field = "C5D08DD56BA40521153147D2F8DF528D")

    public static final Locale ROOT = new Locale(true, "", "");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.223 -0400", hash_original_field = "BEB2DE091D7CD44A849D4FDE17801C6E", hash_generated_field = "C9504C68B180C678A4DDB8147C15B90F")

    public static final Locale SIMPLIFIED_CHINESE = new Locale(true, "zh", "CN");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.223 -0400", hash_original_field = "9F9ED1B34DCEEA793B9F2502F103BC49", hash_generated_field = "2187C3D4D669572A201125FA3D3DF376")

    public static final Locale TAIWAN = new Locale(true, "zh", "TW");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.223 -0400", hash_original_field = "A6C3D0A04F6A5058865AC79A7745E81B", hash_generated_field = "FEBC7896ADE07EF3D8CF22757D61F030")

    public static final Locale TRADITIONAL_CHINESE = new Locale(true, "zh", "TW");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.223 -0400", hash_original_field = "3558BCA0BFA1F389CDCC1EFD60F74115", hash_generated_field = "107ED72C23A2F8F9913FA2417A93830D")

    public static final Locale UK = new Locale(true, "en", "GB");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.223 -0400", hash_original_field = "9E7BBDDA07AD4A3962C1F38EF8DDAC19", hash_generated_field = "CCE42131F2E9126D82844E6ECA655BD3")

    public static final Locale US = new Locale(true, "en", "US");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.223 -0400", hash_original_field = "4887A8DD11208FE3C42BAF38E09F0C96", hash_generated_field = "982529EBDC2FA2E697C9C08FE118F9D9")

    private static Locale defaultLocale = US;
    static {
        String language = System.getProperty("user.language", "en");
        String region = System.getProperty("user.region", "US");
        String variant = System.getProperty("user.variant", "");
        defaultLocale = new Locale(language, region, variant);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.223 -0400", hash_original_field = "5901E35E9EA50F2714379B11227EB9C4", hash_generated_field = "E179BF6620C821162D69DC2C844B9C9A")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("country", String.class),
        new ObjectStreamField("hashcode", int.class),
        new ObjectStreamField("language", String.class),
        new ObjectStreamField("variant", String.class),
    };
}

