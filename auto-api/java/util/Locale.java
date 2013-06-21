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
    private transient String countryCode;
    private transient String languageCode;
    private transient String variantCode;
    private transient String cachedToStringResult;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.897 -0400", hash_original_method = "3151080AB39B36B6870FE53962DD218F", hash_generated_method = "7F13221B1D1105D7AA7AC7190ACB9F3C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.897 -0400", hash_original_method = "95F62AD785CE7F14018E0D0D1E27B00E", hash_generated_method = "E387ACF83D2485A14A112179F5476ACC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Locale(String language) {
        this(language, "", "");
        dsTaint.addTaint(language);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.897 -0400", hash_original_method = "37BC67CA8C45857B55D0F669E159529A", hash_generated_method = "C9CE38C4BE5E40862A461C6AE1A3B97A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Locale(String language, String country) {
        this(language, country, "");
        dsTaint.addTaint(language);
        dsTaint.addTaint(country);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.897 -0400", hash_original_method = "C07F4523516B5D8C3B044DC468C2EE3F", hash_generated_method = "E3C5DFF480AC9978A73FD5658F6D7BE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Locale(String language, String country, String variant) {
        dsTaint.addTaint(language);
        dsTaint.addTaint(variant);
        dsTaint.addTaint(country);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean var17F6FDFF37BC30D399CD41E1E481E2CE_103455102 = (language.isEmpty() && country.isEmpty());
            {
                languageCode = "";
                countryCode = "";
            } //End block
        } //End collapsed parenthetic
        languageCode = language.toLowerCase(Locale.US);
        {
            boolean var88B3A49202DE1B8033707F4C2B73C3A6_938159647 = (languageCode.equals("he"));
            {
                languageCode = "iw";
            } //End block
            {
                boolean var48FBA8ACF9EAD6B66139FA4B3FE15951_421514514 = (languageCode.equals("id"));
                {
                    languageCode = "in";
                } //End block
                {
                    boolean var5B3211E51E6B494A37194C37EDA1B0D5_1051198314 = (languageCode.equals("yi"));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.898 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "01D04F4150A292DEEED907C59AB17BBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        try 
        {
            Object varDEB570B566DA7549E2F197D0AFA5A2B6_457818527 = (super.clone());
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.898 -0400", hash_original_method = "B2DF95EC92791D38C85586E37BBFDFD0", hash_generated_method = "C1C9ACC4876DC9AE3C6642AE443A0106")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        {
            boolean var3F549205D4C262003697A031F89E5954_1067377442 = (object == this);
        } //End collapsed parenthetic
        {
            Locale o;
            o = (Locale) object;
            boolean var0304798EE1CBEE36CAD75CC155557DCC_1974599759 = (languageCode.equals(o.languageCode)
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

    
        public static Locale[] getAvailableLocales() {
        return ICU.getAvailableLocales();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.898 -0400", hash_original_method = "40EA1D1DD90B3BAB3C58BE2B6A46A98D", hash_generated_method = "B2F602EBFD663B0434B5FFFFCDB171F1")
    @DSModeled(DSC.SAFE)
    public String getCountry() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return countryCode;
    }

    
        public static Locale getDefault() {
        return defaultLocale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.899 -0400", hash_original_method = "6B1507A0394E6A6AE91AAA3FFF27DCC6", hash_generated_method = "0842F1A773A2DE72D4950228ECAD8A90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getDisplayCountry() {
        String var18AE6BBB07D99933A2B9576603CDE156_424659695 = (getDisplayCountry(getDefault()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getDisplayCountry(getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.899 -0400", hash_original_method = "6391C14D02F936975118F82A1E774FAD", hash_generated_method = "0FE5944733D1A25DAF4D1B6E62B69396")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDisplayCountry(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        {
            boolean varC33211C406C1C4EFA2F1535CC7F3910E_1387523605 = (countryCode.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.899 -0400", hash_original_method = "8536CE63A6B8A68C05EDBD72A683988E", hash_generated_method = "1629E634F48DA519B7DA038F5F10832B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getDisplayLanguage() {
        String var223141E5A156B9FCE4A06F8599792981_169054988 = (getDisplayLanguage(getDefault()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getDisplayLanguage(getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.899 -0400", hash_original_method = "C0028041B7C295EE912CA1345544B282", hash_generated_method = "329078406805BE44BB3C574ABB0FA533")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDisplayLanguage(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        {
            boolean var0FEF216489AE51E4D4C267CA08E5B9A9_1250133889 = (languageCode.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.899 -0400", hash_original_method = "CBF375FE343ED989DA3B5B8CCC8BE7E0", hash_generated_method = "6F4562694DD40B1852C12B2FC2730946")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getDisplayName() {
        String varE2AFB90063E951E5AFB707E8072943C1_1956200733 = (getDisplayName(getDefault()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getDisplayName(getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.900 -0400", hash_original_method = "82746EC2958D563F59B7A18594C66ADB", hash_generated_method = "56531732FEA64F78D1C6054D350C1138")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDisplayName(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        int count;
        count = 0;
        StringBuilder buffer;
        buffer = new StringBuilder();
        {
            boolean var8F29E112827E9BD79EAC9633D3FFCA6B_23536645 = (!languageCode.isEmpty());
            {
                String displayLanguage;
                displayLanguage = getDisplayLanguage(locale);
                buffer.append(displayLanguage.isEmpty() ? languageCode : displayLanguage);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varBCFFDF6DE02D3D82ADC2B64B371D3030_13061856 = (!countryCode.isEmpty());
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
            boolean var2765EBC38A2EE33A058AF3B323D9B258_1387124516 = (!variantCode.isEmpty());
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
        String varAD28D02EB1C6982A5710D014292E1955_355451707 = (buffer.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.900 -0400", hash_original_method = "A8FFA206A883AC51133D493CCCB1ED67", hash_generated_method = "F23C02E0EEDA7C66E9B36198B3D2C4F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getDisplayVariant() {
        String varFBF62CDD18327C41347C7D2636C6B7A7_737197570 = (getDisplayVariant(getDefault()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getDisplayVariant(getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.900 -0400", hash_original_method = "4A12574A7D5205BB7F7224B1AB3BA842", hash_generated_method = "EAFD84F092483BB9D0A83191ECA952C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDisplayVariant(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        {
            boolean var2B0047DE9038ECDA2703DC74AA6453D5_247794990 = (variantCode.length() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.900 -0400", hash_original_method = "E7148683E6358C89AEF160E990AAEE93", hash_generated_method = "F0CB304B62AC7C7AA29FF1CF3F7BAFDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getISO3Country() {
        {
            boolean varEEE0CD3F3CB38C3CE139809FBEC698B9_425843163 = (countryCode.length() == 0);
        } //End collapsed parenthetic
        String var6E1F766AD141FE2FE7BFDD6D778A3867_880618549 = (ICU.getISO3CountryNative(toString()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (countryCode.length() == 0) {
            //return countryCode;
        //}
        //return ICU.getISO3CountryNative(toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.901 -0400", hash_original_method = "10ED62717CAC900A278627831D37EC4E", hash_generated_method = "46AC476AC850D6C09D612289DBFEFA07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getISO3Language() {
        {
            boolean var705C215E009953572112B52C38E1CF29_1599958373 = (languageCode.length() == 0);
        } //End collapsed parenthetic
        String varC4CE303F9A59B43AFF624107C6D290B7_605562270 = (ICU.getISO3LanguageNative(toString()));
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.901 -0400", hash_original_method = "1C720E5AEB210852D4C515195DCC49D3", hash_generated_method = "CF8B5785B090A9D77EFFD92F8C20596F")
    @DSModeled(DSC.SAFE)
    public String getLanguage() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return languageCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.901 -0400", hash_original_method = "A8C86ADBDB8FE1FD75DA90D3A9B92BDE", hash_generated_method = "94D330294F411516D593E6D344F84C8F")
    @DSModeled(DSC.SAFE)
    public String getVariant() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return variantCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.901 -0400", hash_original_method = "206F92E8CAE7869CD0834AB1BBCCF6BE", hash_generated_method = "6F0ECBB2F423CA3CD138ADE5BF1CFB7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized int hashCode() {
        int var713A412AC71EDAB741EF0A5EA28035CE_54551141 = (countryCode.hashCode() + languageCode.hashCode()
                + variantCode.hashCode());
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.902 -0400", hash_original_method = "8023BB72D2CCCB0AE8421793FA5DB667", hash_generated_method = "4E6180D50BC96E6F372017AC5DDBE025")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final String toString() {
        String result;
        result = cachedToStringResult;
        {
            Object var19241B7176CD2150EC841B58E8576652_384835173 = ((cachedToStringResult = toNewString()));
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String result = cachedToStringResult;
        //return (result == null) ? (cachedToStringResult = toNewString()) : result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.902 -0400", hash_original_method = "C73C94720A0586E8BA389B0E4B761A7E", hash_generated_method = "000C345A727D3C7F576BF0A7FCD008BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String toNewString() {
        {
            boolean var477BD50214513067E9CE857B6E4A4436_2017449136 = (languageCode.length() == 0 && countryCode.length() == 0);
        } //End collapsed parenthetic
        StringBuilder result;
        result = new StringBuilder(11);
        result.append(languageCode);
        {
            boolean var7985240C78B818263278A990811D7703_2062600990 = (countryCode.length() > 0 || variantCode.length() > 0);
            {
                result.append('_');
            } //End block
        } //End collapsed parenthetic
        result.append(countryCode);
        {
            boolean var5529CB82C32A642B7E90788B9461B87C_1697744280 = (variantCode.length() > 0);
            {
                result.append('_');
            } //End block
        } //End collapsed parenthetic
        result.append(variantCode);
        String varEA70154FDA28CC59402440C6317B57EF_310521672 = (result.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.902 -0400", hash_original_method = "03500CE785032DF09CF1C69BAF02C627", hash_generated_method = "F21CEAE8CF63D9E5FEB627B5F5C787EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.902 -0400", hash_original_method = "119900B43F45E61950B2C4FD2DBBE050", hash_generated_method = "505B01F4EF326B9D190E3C77E8E2F9A5")
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
    static {
        String language = System.getProperty("user.language", "en");
        String region = System.getProperty("user.region", "US");
        String variant = System.getProperty("user.variant", "");
        defaultLocale = new Locale(language, region, variant);
    }
    
    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("country", String.class),
        new ObjectStreamField("hashcode", int.class),
        new ObjectStreamField("language", String.class),
        new ObjectStreamField("variant", String.class),
    };
}

