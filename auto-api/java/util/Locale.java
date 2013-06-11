package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import libcore.icu.ICU;

public final class Locale implements Cloneable, Serializable {
    private static final long serialVersionUID = 9149081749638150636L;
    public static final Locale CANADA = new Locale(true, "en", "CA");
    public static final Locale CANADA_FRENCH = new Locale(true, "fr", "CA");
    public static final Locale CHINA = new Locale(true, "zh", "CN");
    public static final Locale CHINESE = new Locale(true, "zh", "");
    public static final Locale ENGLISH = new Locale(true, "en", "");
    public static final Locale FRANCE = new Locale(true, "fr", "FR");
    public static final Locale FRENCH = new Locale(true, "fr", "");
    public static final Locale GERMAN = new Locale(true, "de", "");
    public static final Locale GERMANY = new Locale(true, "de", "DE");
    public static final Locale ITALIAN = new Locale(true, "it", "");
    public static final Locale ITALY = new Locale(true, "it", "IT");
    public static final Locale JAPAN = new Locale(true, "ja", "JP");
    public static final Locale JAPANESE = new Locale(true, "ja", "");
    public static final Locale KOREA = new Locale(true, "ko", "KR");
    public static final Locale KOREAN = new Locale(true, "ko", "");
    public static final Locale PRC = new Locale(true, "zh", "CN");
    public static final Locale ROOT = new Locale(true, "", "");
    public static final Locale SIMPLIFIED_CHINESE = new Locale(true, "zh", "CN");
    public static final Locale TAIWAN = new Locale(true, "zh", "TW");
    public static final Locale TRADITIONAL_CHINESE = new Locale(true, "zh", "TW");
    public static final Locale UK = new Locale(true, "en", "GB");
    public static final Locale US = new Locale(true, "en", "US");
    private static Locale defaultLocale = US;
    private transient String countryCode;
    private transient String languageCode;
    private transient String variantCode;
    private transient String cachedToStringResult;
    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("country", String.class),
        new ObjectStreamField("hashcode", int.class),
        new ObjectStreamField("language", String.class),
        new ObjectStreamField("variant", String.class),
    };
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.726 -0400", hash_original_method = "3151080AB39B36B6870FE53962DD218F", hash_generated_method = "47693D9408E8E0DEFE0A29196A255764")
    @DSModeled(DSC.SAFE)
    private Locale(boolean unused, String lowerCaseLanguageCode, String upperCaseCountryCode) {
        dsTaint.addTaint(lowerCaseLanguageCode);
        dsTaint.addTaint(upperCaseCountryCode);
        dsTaint.addTaint(unused);
        this.variantCode = "";
        // ---------- Original Method ----------
        //this.languageCode = lowerCaseLanguageCode;
        //this.countryCode = upperCaseCountryCode;
        //this.variantCode = "";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.726 -0400", hash_original_method = "95F62AD785CE7F14018E0D0D1E27B00E", hash_generated_method = "A223FE33D739A87C0C7472F3C1441997")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Locale(String language) {
        this(language, "", "");
        dsTaint.addTaint(language);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.726 -0400", hash_original_method = "37BC67CA8C45857B55D0F669E159529A", hash_generated_method = "C6BB1049A5D598E0D861D07D2101E99F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Locale(String language, String country) {
        this(language, country, "");
        dsTaint.addTaint(language);
        dsTaint.addTaint(country);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.726 -0400", hash_original_method = "C07F4523516B5D8C3B044DC468C2EE3F", hash_generated_method = "04834AD6423B85098F839C92C3F2DAC3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Locale(String language, String country, String variant) {
        dsTaint.addTaint(language);
        dsTaint.addTaint(variant);
        dsTaint.addTaint(country);
        if (DroidSafeAndroidRuntime.control) {
            throw new NullPointerException();
        } //End block
        {
            boolean var17F6FDFF37BC30D399CD41E1E481E2CE_1029748390 = (language.isEmpty() && country.isEmpty());
            {
                languageCode = "";
                countryCode = "";
            } //End block
        } //End collapsed parenthetic
        languageCode = language.toLowerCase(Locale.US);
        {
            boolean var88B3A49202DE1B8033707F4C2B73C3A6_1205544421 = (languageCode.equals("he"));
            {
                languageCode = "iw";
            } //End block
            {
                boolean var48FBA8ACF9EAD6B66139FA4B3FE15951_225730315 = (languageCode.equals("id"));
                {
                    languageCode = "in";
                } //End block
                {
                    boolean var5B3211E51E6B494A37194C37EDA1B0D5_1162612505 = (languageCode.equals("yi"));
                    {
                        languageCode = "ji";
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        countryCode = country.toUpperCase(Locale.US);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.726 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "A62567EFFE6A066AC3FC881480281E21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        try 
        {
            Object varDEB570B566DA7549E2F197D0AFA5A2B6_42383989 = (super.clone());
        } //End block
        catch (CloneNotSupportedException e)
        {
            throw new AssertionError(e);
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.726 -0400", hash_original_method = "B2DF95EC92791D38C85586E37BBFDFD0", hash_generated_method = "45728EEF886DAADC49CB9E44C713DD58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        {
            Locale o;
            o = (Locale) object;
            boolean var0304798EE1CBEE36CAD75CC155557DCC_912991755 = (languageCode.equals(o.languageCode)
                    && countryCode.equals(o.countryCode)
                    && variantCode.equals(o.variantCode));
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.726 -0400", hash_original_method = "5568C13FBF0303E2B45FB831CBD412FF", hash_generated_method = "2AC3CF3C68E65229DEC68E9B7601D499")
    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableLocales();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.726 -0400", hash_original_method = "40EA1D1DD90B3BAB3C58BE2B6A46A98D", hash_generated_method = "026DD7D1868F440293E953A846AFE39F")
    @DSModeled(DSC.SAFE)
    public String getCountry() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return countryCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.726 -0400", hash_original_method = "78E4BA42BD949FF8F2A8F4719503FD6E", hash_generated_method = "5528E88B167B739C2F2D3F547188BFC8")
    public static Locale getDefault() {
        return defaultLocale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.726 -0400", hash_original_method = "6B1507A0394E6A6AE91AAA3FFF27DCC6", hash_generated_method = "50842EA68E33981D478B2316DC108A9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getDisplayCountry() {
        String var18AE6BBB07D99933A2B9576603CDE156_250042752 = (getDisplayCountry(getDefault()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getDisplayCountry(getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.727 -0400", hash_original_method = "6391C14D02F936975118F82A1E774FAD", hash_generated_method = "C3277F7C68B25173748C49C302DEDC84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDisplayCountry(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        {
            boolean varC33211C406C1C4EFA2F1535CC7F3910E_1604060893 = (countryCode.isEmpty());
        } //End collapsed parenthetic
        String result;
        result = ICU.getDisplayCountryNative(toString(), locale.toString());
        {
            result = ICU.getDisplayCountryNative(toString(), Locale.getDefault().toString());
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.727 -0400", hash_original_method = "8536CE63A6B8A68C05EDBD72A683988E", hash_generated_method = "A59AFD0BA590B9185A4AEE7CF52E0CF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getDisplayLanguage() {
        String var223141E5A156B9FCE4A06F8599792981_1280168536 = (getDisplayLanguage(getDefault()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getDisplayLanguage(getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.727 -0400", hash_original_method = "C0028041B7C295EE912CA1345544B282", hash_generated_method = "834CBA77A4DDE76344CE4ED4EABE20A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDisplayLanguage(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        {
            boolean var0FEF216489AE51E4D4C267CA08E5B9A9_63453699 = (languageCode.isEmpty());
        } //End collapsed parenthetic
        String result;
        result = ICU.getDisplayLanguageNative(toString(), locale.toString());
        {
            result = ICU.getDisplayLanguageNative(toString(), Locale.getDefault().toString());
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.727 -0400", hash_original_method = "CBF375FE343ED989DA3B5B8CCC8BE7E0", hash_generated_method = "CC55F82E8EA9DD01178BD355582BAE25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getDisplayName() {
        String varE2AFB90063E951E5AFB707E8072943C1_630177222 = (getDisplayName(getDefault()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getDisplayName(getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.727 -0400", hash_original_method = "82746EC2958D563F59B7A18594C66ADB", hash_generated_method = "46A31889DB4AD6C5D140BF53CC426D39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDisplayName(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        int count;
        count = 0;
        StringBuilder buffer;
        buffer = new StringBuilder();
        {
            boolean var8F29E112827E9BD79EAC9633D3FFCA6B_1709061419 = (!languageCode.isEmpty());
            {
                String displayLanguage;
                displayLanguage = getDisplayLanguage(locale);
                buffer.append(displayLanguage.isEmpty() ? languageCode : displayLanguage);
                ++count;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varBCFFDF6DE02D3D82ADC2B64B371D3030_1115359033 = (!countryCode.isEmpty());
            {
                {
                    buffer.append(" (");
                } //End block
                String displayCountry;
                displayCountry = getDisplayCountry(locale);
                buffer.append(displayCountry.isEmpty() ? countryCode : displayCountry);
                ++count;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var2765EBC38A2EE33A058AF3B323D9B258_1424559170 = (!variantCode.isEmpty());
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
                ++count;
            } //End block
        } //End collapsed parenthetic
        {
            buffer.append(")");
        } //End block
        String varAD28D02EB1C6982A5710D014292E1955_1352053468 = (buffer.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.727 -0400", hash_original_method = "A8FFA206A883AC51133D493CCCB1ED67", hash_generated_method = "E9F2873F6D74F0E90240B917B86E72DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getDisplayVariant() {
        String varFBF62CDD18327C41347C7D2636C6B7A7_1412105534 = (getDisplayVariant(getDefault()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getDisplayVariant(getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.727 -0400", hash_original_method = "4A12574A7D5205BB7F7224B1AB3BA842", hash_generated_method = "080D203143BC0140E9E90A22444C9B81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDisplayVariant(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        {
            boolean var2B0047DE9038ECDA2703DC74AA6453D5_1932917264 = (variantCode.length() == 0);
        } //End collapsed parenthetic
        String result;
        result = ICU.getDisplayVariantNative(toString(), locale.toString());
        {
            result = ICU.getDisplayVariantNative(toString(), Locale.getDefault().toString());
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.727 -0400", hash_original_method = "E7148683E6358C89AEF160E990AAEE93", hash_generated_method = "EE2F47F4EB7F2A17B4EB493CD219EA68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getISO3Country() {
        {
            boolean varEEE0CD3F3CB38C3CE139809FBEC698B9_1251847520 = (countryCode.length() == 0);
        } //End collapsed parenthetic
        String var6E1F766AD141FE2FE7BFDD6D778A3867_1241543584 = (ICU.getISO3CountryNative(toString()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (countryCode.length() == 0) {
            //return countryCode;
        //}
        //return ICU.getISO3CountryNative(toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.727 -0400", hash_original_method = "10ED62717CAC900A278627831D37EC4E", hash_generated_method = "E45B63C78BED99686EF8761215DFB063")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getISO3Language() {
        {
            boolean var705C215E009953572112B52C38E1CF29_1435651795 = (languageCode.length() == 0);
        } //End collapsed parenthetic
        String varC4CE303F9A59B43AFF624107C6D290B7_1945136201 = (ICU.getISO3LanguageNative(toString()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (languageCode.length() == 0) {
            //return languageCode;
        //}
        //return ICU.getISO3LanguageNative(toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.727 -0400", hash_original_method = "6E640F85727BC14FFB8FEB6DDFDDAA44", hash_generated_method = "644E99B2E902F685DEF0A21C0788EAF5")
    public static String[] getISOCountries() {
        return ICU.getISOCountries();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.727 -0400", hash_original_method = "38678B2D63B6657916CA4EA5FB99FCD8", hash_generated_method = "7930F48054954457DDF5223CDA0A04E7")
    public static String[] getISOLanguages() {
        return ICU.getISOLanguages();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.727 -0400", hash_original_method = "1C720E5AEB210852D4C515195DCC49D3", hash_generated_method = "6037CDE48D90592F151E34DAD49EF4D5")
    @DSModeled(DSC.SAFE)
    public String getLanguage() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return languageCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.727 -0400", hash_original_method = "A8C86ADBDB8FE1FD75DA90D3A9B92BDE", hash_generated_method = "9014BA37D9058483A94DA6762AAD4E5A")
    @DSModeled(DSC.SAFE)
    public String getVariant() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return variantCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.728 -0400", hash_original_method = "206F92E8CAE7869CD0834AB1BBCCF6BE", hash_generated_method = "51CE0C3527C85B7095A6BF3E907CFD94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized int hashCode() {
        int var713A412AC71EDAB741EF0A5EA28035CE_623084346 = (countryCode.hashCode() + languageCode.hashCode()
                + variantCode.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return countryCode.hashCode() + languageCode.hashCode()
                //+ variantCode.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.728 -0400", hash_original_method = "4AE56FD65BC36355DD6ADDF31AE9381B", hash_generated_method = "D344223857F8797D194B4DB5FFFA3F96")
    public synchronized static void setDefault(Locale locale) {
        if (locale == null) {
            throw new NullPointerException();
        }
        defaultLocale = locale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.728 -0400", hash_original_method = "8023BB72D2CCCB0AE8421793FA5DB667", hash_generated_method = "FEFE4DAEFFD1AED4D882F4CE8F95FC20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final String toString() {
        String result;
        result = cachedToStringResult;
        {
            Object var19241B7176CD2150EC841B58E8576652_1123700557 = ((cachedToStringResult = toNewString()));
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String result = cachedToStringResult;
        //return (result == null) ? (cachedToStringResult = toNewString()) : result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.728 -0400", hash_original_method = "C73C94720A0586E8BA389B0E4B761A7E", hash_generated_method = "156C58B8247E4CF4377ECB7348737B1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String toNewString() {
        {
            boolean var477BD50214513067E9CE857B6E4A4436_1925693489 = (languageCode.length() == 0 && countryCode.length() == 0);
        } //End collapsed parenthetic
        StringBuilder result;
        result = new StringBuilder(11);
        result.append(languageCode);
        {
            boolean var7985240C78B818263278A990811D7703_959231951 = (countryCode.length() > 0 || variantCode.length() > 0);
            {
                result.append('_');
            } //End block
        } //End collapsed parenthetic
        result.append(countryCode);
        {
            boolean var5529CB82C32A642B7E90788B9461B87C_102476783 = (variantCode.length() > 0);
            {
                result.append('_');
            } //End block
        } //End collapsed parenthetic
        result.append(variantCode);
        String varEA70154FDA28CC59402440C6317B57EF_972474912 = (result.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.728 -0400", hash_original_method = "03500CE785032DF09CF1C69BAF02C627", hash_generated_method = "FB9DB4E00E428B8595B0C8EC9561AD67")
    @DSModeled(DSC.SAFE)
    private void writeObject(ObjectOutputStream stream) throws IOException {
        dsTaint.addTaint(stream.dsTaint);
        ObjectOutputStream.PutField fields;
        fields = stream.putFields();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.728 -0400", hash_original_method = "119900B43F45E61950B2C4FD2DBBE050", hash_generated_method = "B29E6D977453B0D01B2F4C6C6998227E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(stream.dsTaint);
        ObjectInputStream.GetField fields;
        fields = stream.readFields();
        countryCode = (String) fields.get("country", "");
        languageCode = (String) fields.get("language", "");
        variantCode = (String) fields.get("variant", "");
        // ---------- Original Method ----------
        //ObjectInputStream.GetField fields = stream.readFields();
        //countryCode = (String) fields.get("country", "");
        //languageCode = (String) fields.get("language", "");
        //variantCode = (String) fields.get("variant", "");
    }

    
    static {
        String language = System.getProperty("user.language", "en");
        String region = System.getProperty("user.region", "US");
        String variant = System.getProperty("user.variant", "");
        defaultLocale = new Locale(language, region, variant);
    }
    
}


