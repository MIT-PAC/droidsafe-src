package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import libcore.icu.ICU;

public final class Locale implements Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.462 -0400", hash_original_field = "AF9AD4037F4BB83AC9CEB5E118E6DE1A", hash_generated_field = "19B779CD8189BCE485C226E9C90F5F3B")

    private transient String countryCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.462 -0400", hash_original_field = "3A3CB397ADE05A407F0D792E87F6F299", hash_generated_field = "2ECB9A2070EAE3399DFD4B61935BB4AA")

    private transient String languageCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.462 -0400", hash_original_field = "C4D80CF9E79B4A0C529653A1DB0E5891", hash_generated_field = "20B608C3BDA9F3FFBF7E6CEE9057B7C0")

    private transient String variantCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.462 -0400", hash_original_field = "9ACE3194BDE7C7B07D43470C11B716C5", hash_generated_field = "34675DF76648E8EBEE86B67A25EA4CB3")

    private transient String cachedToStringResult;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.464 -0400", hash_original_method = "3151080AB39B36B6870FE53962DD218F", hash_generated_method = "B8525880001D0CFB2824C4EF006E6CE5")
    private  Locale(boolean unused, String lowerCaseLanguageCode, String upperCaseCountryCode) {
        this.languageCode = lowerCaseLanguageCode;
        this.countryCode = upperCaseCountryCode;
        this.variantCode = "";
        addTaint(unused);
        // ---------- Original Method ----------
        //this.languageCode = lowerCaseLanguageCode;
        //this.countryCode = upperCaseCountryCode;
        //this.variantCode = "";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.464 -0400", hash_original_method = "95F62AD785CE7F14018E0D0D1E27B00E", hash_generated_method = "AA357B84DEB8D807A33A795D8F57D011")
    public  Locale(String language) {
        this(language, "", "");
        addTaint(language.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.464 -0400", hash_original_method = "37BC67CA8C45857B55D0F669E159529A", hash_generated_method = "6C060AC0D66A842880688D936B6EEAFB")
    public  Locale(String language, String country) {
        this(language, country, "");
        addTaint(language.getTaint());
        addTaint(country.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.467 -0400", hash_original_method = "C07F4523516B5D8C3B044DC468C2EE3F", hash_generated_method = "F411C7EB03E9576974A834ABA2D5A73B")
    public  Locale(String language, String country, String variant) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean var17F6FDFF37BC30D399CD41E1E481E2CE_1550730771 = (language.isEmpty() && country.isEmpty());
            {
                languageCode = "";
                countryCode = "";
                variantCode = variant;
            } //End block
        } //End collapsed parenthetic
        languageCode = language.toLowerCase(Locale.US);
        {
            boolean var88B3A49202DE1B8033707F4C2B73C3A6_174077101 = (languageCode.equals("he"));
            {
                languageCode = "iw";
            } //End block
            {
                boolean var48FBA8ACF9EAD6B66139FA4B3FE15951_1104996530 = (languageCode.equals("id"));
                {
                    languageCode = "in";
                } //End block
                {
                    boolean var5B3211E51E6B494A37194C37EDA1B0D5_1101048063 = (languageCode.equals("yi"));
                    {
                        languageCode = "ji";
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.468 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "8F5841ECC5BB30694009A0A4753BC597")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1165284624 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1165284624 = super.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1165284624.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1165284624;
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.477 -0400", hash_original_method = "B2DF95EC92791D38C85586E37BBFDFD0", hash_generated_method = "E1A8DD66B3CF6A72B4E19D3DDE92A9AB")
    @Override
    public boolean equals(Object object) {
        {
            boolean var3F549205D4C262003697A031F89E5954_2141072726 = (object == this);
        } //End collapsed parenthetic
        {
            Locale o;
            o = (Locale) object;
            boolean var0304798EE1CBEE36CAD75CC155557DCC_1959937160 = (languageCode.equals(o.languageCode)
                    && countryCode.equals(o.countryCode)
                    && variantCode.equals(o.variantCode));
        } //End block
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_29404639 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_29404639;
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

    
        public static Locale[] getAvailableLocales() {
        return ICU.getAvailableLocales();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.478 -0400", hash_original_method = "40EA1D1DD90B3BAB3C58BE2B6A46A98D", hash_generated_method = "195D965F3F8771F159DB3601ADE8724B")
    public String getCountry() {
        String varB4EAC82CA7396A68D541C85D26508E83_1989315 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1989315 = countryCode;
        varB4EAC82CA7396A68D541C85D26508E83_1989315.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1989315;
        // ---------- Original Method ----------
        //return countryCode;
    }

    
        public static Locale getDefault() {
        return defaultLocale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.479 -0400", hash_original_method = "6B1507A0394E6A6AE91AAA3FFF27DCC6", hash_generated_method = "FB8539B0CCE214DDD7457011BD629D9B")
    public final String getDisplayCountry() {
        String varB4EAC82CA7396A68D541C85D26508E83_1230162291 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1230162291 = getDisplayCountry(getDefault());
        varB4EAC82CA7396A68D541C85D26508E83_1230162291.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1230162291;
        // ---------- Original Method ----------
        //return getDisplayCountry(getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.490 -0400", hash_original_method = "6391C14D02F936975118F82A1E774FAD", hash_generated_method = "2B6A45A30863EA2458FDBDDC95692CB8")
    public String getDisplayCountry(Locale locale) {
        String varB4EAC82CA7396A68D541C85D26508E83_1560055775 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2120202188 = null; //Variable for return #2
        {
            boolean varC33211C406C1C4EFA2F1535CC7F3910E_297918407 = (countryCode.isEmpty());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1560055775 = "";
            } //End block
        } //End collapsed parenthetic
        String result;
        result = ICU.getDisplayCountryNative(toString(), locale.toString());
        {
            result = ICU.getDisplayCountryNative(toString(), Locale.getDefault().toString());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2120202188 = result;
        addTaint(locale.getTaint());
        String varA7E53CE21691AB073D9660D615818899_888853373; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_888853373 = varB4EAC82CA7396A68D541C85D26508E83_1560055775;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_888853373 = varB4EAC82CA7396A68D541C85D26508E83_2120202188;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_888853373.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_888853373;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.495 -0400", hash_original_method = "8536CE63A6B8A68C05EDBD72A683988E", hash_generated_method = "74EFF97CD9CF4BA4616B61A526E94686")
    public final String getDisplayLanguage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1442378515 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1442378515 = getDisplayLanguage(getDefault());
        varB4EAC82CA7396A68D541C85D26508E83_1442378515.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1442378515;
        // ---------- Original Method ----------
        //return getDisplayLanguage(getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.501 -0400", hash_original_method = "C0028041B7C295EE912CA1345544B282", hash_generated_method = "01A2091A5273D3934381BB7FF172344A")
    public String getDisplayLanguage(Locale locale) {
        String varB4EAC82CA7396A68D541C85D26508E83_1086048220 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_551473387 = null; //Variable for return #2
        {
            boolean var0FEF216489AE51E4D4C267CA08E5B9A9_1964871108 = (languageCode.isEmpty());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1086048220 = "";
            } //End block
        } //End collapsed parenthetic
        String result;
        result = ICU.getDisplayLanguageNative(toString(), locale.toString());
        {
            result = ICU.getDisplayLanguageNative(toString(), Locale.getDefault().toString());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_551473387 = result;
        addTaint(locale.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1562522887; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1562522887 = varB4EAC82CA7396A68D541C85D26508E83_1086048220;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1562522887 = varB4EAC82CA7396A68D541C85D26508E83_551473387;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1562522887.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1562522887;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.501 -0400", hash_original_method = "CBF375FE343ED989DA3B5B8CCC8BE7E0", hash_generated_method = "7D7F942BBE190AF11B8321E5858B2C63")
    public final String getDisplayName() {
        String varB4EAC82CA7396A68D541C85D26508E83_497397903 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_497397903 = getDisplayName(getDefault());
        varB4EAC82CA7396A68D541C85D26508E83_497397903.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_497397903;
        // ---------- Original Method ----------
        //return getDisplayName(getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.503 -0400", hash_original_method = "82746EC2958D563F59B7A18594C66ADB", hash_generated_method = "708D1A5722056DC8D7A57E553B44C32C")
    public String getDisplayName(Locale locale) {
        String varB4EAC82CA7396A68D541C85D26508E83_874425984 = null; //Variable for return #1
        int count;
        count = 0;
        StringBuilder buffer;
        buffer = new StringBuilder();
        {
            boolean var8F29E112827E9BD79EAC9633D3FFCA6B_883842186 = (!languageCode.isEmpty());
            {
                String displayLanguage;
                displayLanguage = getDisplayLanguage(locale);
                buffer.append(displayLanguage.isEmpty() ? languageCode : displayLanguage);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varBCFFDF6DE02D3D82ADC2B64B371D3030_1328223660 = (!countryCode.isEmpty());
            {
                {
                    buffer.append(" (");
                } //End block
                String displayCountry;
                displayCountry = getDisplayCountry(locale);
                buffer.append(displayCountry.isEmpty() ? countryCode : displayCountry);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var2765EBC38A2EE33A058AF3B323D9B258_1591581245 = (!variantCode.isEmpty());
            {
                {
                    buffer.append(" (");
                } //End block
                {
                    buffer.append(",");
                } //End block
                String displayVariant;
                displayVariant = getDisplayVariant(locale);
                buffer.append(displayVariant.isEmpty() ? variantCode : displayVariant);
            } //End block
        } //End collapsed parenthetic
        {
            buffer.append(")");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_874425984 = buffer.toString();
        addTaint(locale.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_874425984.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_874425984;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.512 -0400", hash_original_method = "A8FFA206A883AC51133D493CCCB1ED67", hash_generated_method = "F9EB471F3EDC554D2AA0103240974E7E")
    public final String getDisplayVariant() {
        String varB4EAC82CA7396A68D541C85D26508E83_928055707 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_928055707 = getDisplayVariant(getDefault());
        varB4EAC82CA7396A68D541C85D26508E83_928055707.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_928055707;
        // ---------- Original Method ----------
        //return getDisplayVariant(getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.518 -0400", hash_original_method = "4A12574A7D5205BB7F7224B1AB3BA842", hash_generated_method = "68BA2509D26575C2480A03AD779E99A3")
    public String getDisplayVariant(Locale locale) {
        String varB4EAC82CA7396A68D541C85D26508E83_1935860631 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1605914662 = null; //Variable for return #2
        {
            boolean var2B0047DE9038ECDA2703DC74AA6453D5_1489455794 = (variantCode.length() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1935860631 = variantCode;
            } //End block
        } //End collapsed parenthetic
        String result;
        result = ICU.getDisplayVariantNative(toString(), locale.toString());
        {
            result = ICU.getDisplayVariantNative(toString(), Locale.getDefault().toString());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1605914662 = result;
        addTaint(locale.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1048967747; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1048967747 = varB4EAC82CA7396A68D541C85D26508E83_1935860631;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1048967747 = varB4EAC82CA7396A68D541C85D26508E83_1605914662;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1048967747.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1048967747;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.519 -0400", hash_original_method = "E7148683E6358C89AEF160E990AAEE93", hash_generated_method = "404C94C0181A8A7EC7309EBCF18DBCDD")
    public String getISO3Country() {
        String varB4EAC82CA7396A68D541C85D26508E83_2122795388 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1523550535 = null; //Variable for return #2
        {
            boolean varEEE0CD3F3CB38C3CE139809FBEC698B9_1429096320 = (countryCode.length() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_2122795388 = countryCode;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1523550535 = ICU.getISO3CountryNative(toString());
        String varA7E53CE21691AB073D9660D615818899_762440381; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_762440381 = varB4EAC82CA7396A68D541C85D26508E83_2122795388;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_762440381 = varB4EAC82CA7396A68D541C85D26508E83_1523550535;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_762440381.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_762440381;
        // ---------- Original Method ----------
        //if (countryCode.length() == 0) {
            //return countryCode;
        //}
        //return ICU.getISO3CountryNative(toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.524 -0400", hash_original_method = "10ED62717CAC900A278627831D37EC4E", hash_generated_method = "C7D4A7689848080BBD47340604B0A2D9")
    public String getISO3Language() {
        String varB4EAC82CA7396A68D541C85D26508E83_1784992316 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_887290004 = null; //Variable for return #2
        {
            boolean var705C215E009953572112B52C38E1CF29_1706390781 = (languageCode.length() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1784992316 = languageCode;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_887290004 = ICU.getISO3LanguageNative(toString());
        String varA7E53CE21691AB073D9660D615818899_797924468; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_797924468 = varB4EAC82CA7396A68D541C85D26508E83_1784992316;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_797924468 = varB4EAC82CA7396A68D541C85D26508E83_887290004;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_797924468.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_797924468;
        // ---------- Original Method ----------
        //if (languageCode.length() == 0) {
            //return languageCode;
        //}
        //return ICU.getISO3LanguageNative(toString());
    }

    
        public static String[] getISOCountries() {
        return ICU.getISOCountries();
    }

    
        public static String[] getISOLanguages() {
        return ICU.getISOLanguages();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.525 -0400", hash_original_method = "1C720E5AEB210852D4C515195DCC49D3", hash_generated_method = "022F782FA165F208080162F949ED3E3F")
    public String getLanguage() {
        String varB4EAC82CA7396A68D541C85D26508E83_339878748 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_339878748 = languageCode;
        varB4EAC82CA7396A68D541C85D26508E83_339878748.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_339878748;
        // ---------- Original Method ----------
        //return languageCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.527 -0400", hash_original_method = "A8C86ADBDB8FE1FD75DA90D3A9B92BDE", hash_generated_method = "6C7DF06B102ECDC20107B2F777D0C22F")
    public String getVariant() {
        String varB4EAC82CA7396A68D541C85D26508E83_709984062 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_709984062 = variantCode;
        varB4EAC82CA7396A68D541C85D26508E83_709984062.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_709984062;
        // ---------- Original Method ----------
        //return variantCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.528 -0400", hash_original_method = "206F92E8CAE7869CD0834AB1BBCCF6BE", hash_generated_method = "80F6018A96B6A324829ED1A98081B46F")
    @Override
    public synchronized int hashCode() {
        int var713A412AC71EDAB741EF0A5EA28035CE_1076174429 = (countryCode.hashCode() + languageCode.hashCode()
                + variantCode.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2018043094 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2018043094;
        // ---------- Original Method ----------
        //return countryCode.hashCode() + languageCode.hashCode()
                //+ variantCode.hashCode();
    }

    
        public synchronized static void setDefault(Locale locale) {
        if (locale == null) {
            throw new NullPointerException();
        }
        defaultLocale = locale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.528 -0400", hash_original_method = "8023BB72D2CCCB0AE8421793FA5DB667", hash_generated_method = "930648F3C1B1F3422B5724FC464AA892")
    @Override
    public final String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_427698692 = null; //Variable for return #1
        String result;
        result = cachedToStringResult;
        varB4EAC82CA7396A68D541C85D26508E83_427698692 = (result == null) ? (cachedToStringResult = toNewString()) : result;
        varB4EAC82CA7396A68D541C85D26508E83_427698692.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_427698692;
        // ---------- Original Method ----------
        //String result = cachedToStringResult;
        //return (result == null) ? (cachedToStringResult = toNewString()) : result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.533 -0400", hash_original_method = "C73C94720A0586E8BA389B0E4B761A7E", hash_generated_method = "B6E809FA7FB5AEF4D3DBBD2B67DFFE24")
    private String toNewString() {
        String varB4EAC82CA7396A68D541C85D26508E83_298053605 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_822025854 = null; //Variable for return #2
        {
            boolean var477BD50214513067E9CE857B6E4A4436_1306829885 = (languageCode.length() == 0 && countryCode.length() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_298053605 = "";
            } //End block
        } //End collapsed parenthetic
        StringBuilder result;
        result = new StringBuilder(11);
        result.append(languageCode);
        {
            boolean var7985240C78B818263278A990811D7703_543180813 = (countryCode.length() > 0 || variantCode.length() > 0);
            {
                result.append('_');
            } //End block
        } //End collapsed parenthetic
        result.append(countryCode);
        {
            boolean var5529CB82C32A642B7E90788B9461B87C_228969194 = (variantCode.length() > 0);
            {
                result.append('_');
            } //End block
        } //End collapsed parenthetic
        result.append(variantCode);
        varB4EAC82CA7396A68D541C85D26508E83_822025854 = result.toString();
        String varA7E53CE21691AB073D9660D615818899_983681212; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_983681212 = varB4EAC82CA7396A68D541C85D26508E83_298053605;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_983681212 = varB4EAC82CA7396A68D541C85D26508E83_822025854;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_983681212.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_983681212;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.538 -0400", hash_original_method = "03500CE785032DF09CF1C69BAF02C627", hash_generated_method = "034D3FAC1560105DEB3557DBA4C134EB")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        ObjectOutputStream.PutField fields;
        fields = stream.putFields();
        fields.put("country", countryCode);
        fields.put("hashcode", -1);
        fields.put("language", languageCode);
        fields.put("variant", variantCode);
        stream.writeFields();
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        //ObjectOutputStream.PutField fields = stream.putFields();
        //fields.put("country", countryCode);
        //fields.put("hashcode", -1);
        //fields.put("language", languageCode);
        //fields.put("variant", variantCode);
        //stream.writeFields();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.538 -0400", hash_original_method = "119900B43F45E61950B2C4FD2DBBE050", hash_generated_method = "DE5F8BA5149E7766631CB0615E0327A2")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields;
        fields = stream.readFields();
        countryCode = (String) fields.get("country", "");
        languageCode = (String) fields.get("language", "");
        variantCode = (String) fields.get("variant", "");
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        //ObjectInputStream.GetField fields = stream.readFields();
        //countryCode = (String) fields.get("country", "");
        //languageCode = (String) fields.get("language", "");
        //variantCode = (String) fields.get("variant", "");
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.538 -0400", hash_original_field = "18DA9B5D151863655E40910EB4A12CE3", hash_generated_field = "07B3E9C66264B7B3B91943A9DBC2CA58")

    private static long serialVersionUID = 9149081749638150636L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.538 -0400", hash_original_field = "6BF363EA1A8DE86B5AC0377FA794F11F", hash_generated_field = "7BDD40E7897A0B20ED68158A0E65F590")

    public static final Locale CANADA = new Locale(true, "en", "CA");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.538 -0400", hash_original_field = "BFBF652CF675E54322886752FC940A96", hash_generated_field = "6892784792C9F34D39D8FEB23F4ECC7C")

    public static final Locale CANADA_FRENCH = new Locale(true, "fr", "CA");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.538 -0400", hash_original_field = "5DC13621D42D47291E1A23AFEEE5B4A6", hash_generated_field = "815F7BAFEA33E18C6C585964A4AAD2BF")

    public static final Locale CHINA = new Locale(true, "zh", "CN");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.539 -0400", hash_original_field = "F645BAE03C0192FC36BF37B93340CF96", hash_generated_field = "2AFCDD9168470113B6C8F8A14E381616")

    public static final Locale CHINESE = new Locale(true, "zh", "");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.539 -0400", hash_original_field = "B517792B30100A2D1A29CBC8D54CD474", hash_generated_field = "010EE953058E1394EC388C06EEEFF35C")

    public static final Locale ENGLISH = new Locale(true, "en", "");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.539 -0400", hash_original_field = "0DECFD7B4501C8DA6FED0A7D48FA7CF6", hash_generated_field = "4121FCC78DA601AEAC97C367E5C6E05D")

    public static final Locale FRANCE = new Locale(true, "fr", "FR");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.539 -0400", hash_original_field = "06CE2784C44649FD8CC4EBD2B3B4ED42", hash_generated_field = "CBA5E07F7E68529CF82B9E96AF4E3809")

    public static final Locale FRENCH = new Locale(true, "fr", "");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.539 -0400", hash_original_field = "D67AA0F18FF909C546981ECCC69A895A", hash_generated_field = "B7E2C8DE81F1356E34A1BFA17F499BB8")

    public static final Locale GERMAN = new Locale(true, "de", "");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.539 -0400", hash_original_field = "35A9E98B2A7845D0BED0CAA90C6E1B3C", hash_generated_field = "99C12CF22E8A302C658D06A543E6ABC9")

    public static final Locale GERMANY = new Locale(true, "de", "DE");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.539 -0400", hash_original_field = "37ED88901F01E6C58DA9BA4B969D92FC", hash_generated_field = "A3398381AD52B8EE49ECC3C156390428")

    public static final Locale ITALIAN = new Locale(true, "it", "");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.539 -0400", hash_original_field = "6FFA395B3193069456AEA18A75551201", hash_generated_field = "6B8F2AEFB85A9DDE96656C221445E060")

    public static final Locale ITALY = new Locale(true, "it", "IT");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.539 -0400", hash_original_field = "7A4BF0EBA8C1C4155D7E16424E30466A", hash_generated_field = "ADB1EFC498D0885F1C7D82EFDC8A762E")

    public static final Locale JAPAN = new Locale(true, "ja", "JP");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.539 -0400", hash_original_field = "866D24DCD5CB4CB16E0A97F97B10599A", hash_generated_field = "E9F0251CDBFB0D682860A91571CF2885")

    public static final Locale JAPANESE = new Locale(true, "ja", "");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.539 -0400", hash_original_field = "6B47FF8AA94A86727A705B65745CEBEF", hash_generated_field = "CB8453466B2EFA0F4D4DB63AEF3DF7B9")

    public static final Locale KOREA = new Locale(true, "ko", "KR");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.539 -0400", hash_original_field = "DE9D9B65EC42AB12EC074817D13D6C8B", hash_generated_field = "D94D062AFAC409AAE6CD164AF870C246")

    public static final Locale KOREAN = new Locale(true, "ko", "");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.539 -0400", hash_original_field = "94857004AC24363C83FD06F5422E404C", hash_generated_field = "8FCD51D6A9283D26C9714E64D8EA8DFE")

    public static final Locale PRC = new Locale(true, "zh", "CN");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.539 -0400", hash_original_field = "C121102F6AA0785D597B6A961998BAE6", hash_generated_field = "C5D08DD56BA40521153147D2F8DF528D")

    public static final Locale ROOT = new Locale(true, "", "");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.539 -0400", hash_original_field = "BEB2DE091D7CD44A849D4FDE17801C6E", hash_generated_field = "C9504C68B180C678A4DDB8147C15B90F")

    public static final Locale SIMPLIFIED_CHINESE = new Locale(true, "zh", "CN");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.539 -0400", hash_original_field = "9F9ED1B34DCEEA793B9F2502F103BC49", hash_generated_field = "2187C3D4D669572A201125FA3D3DF376")

    public static final Locale TAIWAN = new Locale(true, "zh", "TW");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.539 -0400", hash_original_field = "A6C3D0A04F6A5058865AC79A7745E81B", hash_generated_field = "FEBC7896ADE07EF3D8CF22757D61F030")

    public static final Locale TRADITIONAL_CHINESE = new Locale(true, "zh", "TW");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.539 -0400", hash_original_field = "3558BCA0BFA1F389CDCC1EFD60F74115", hash_generated_field = "107ED72C23A2F8F9913FA2417A93830D")

    public static final Locale UK = new Locale(true, "en", "GB");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.539 -0400", hash_original_field = "9E7BBDDA07AD4A3962C1F38EF8DDAC19", hash_generated_field = "CCE42131F2E9126D82844E6ECA655BD3")

    public static final Locale US = new Locale(true, "en", "US");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.539 -0400", hash_original_field = "4887A8DD11208FE3C42BAF38E09F0C96", hash_generated_field = "982529EBDC2FA2E697C9C08FE118F9D9")

    private static Locale defaultLocale = US;
    static {
        String language = System.getProperty("user.language", "en");
        String region = System.getProperty("user.region", "US");
        String variant = System.getProperty("user.variant", "");
        defaultLocale = new Locale(language, region, variant);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.540 -0400", hash_original_field = "5901E35E9EA50F2714379B11227EB9C4", hash_generated_field = "CADDB07420F8B73FF38C3E00E8BA222C")

    private static ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("country", String.class),
        new ObjectStreamField("hashcode", int.class),
        new ObjectStreamField("language", String.class),
        new ObjectStreamField("variant", String.class),
    };
}

