package java.text;

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
import java.util.Currency;
import java.util.Locale;
import libcore.icu.ICU;
import libcore.icu.LocaleData;

public class DecimalFormatSymbols implements Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.050 -0400", hash_original_field = "8AD80D213027B16530912C1C1C7453EF", hash_generated_field = "182114D634E44B2F9FF8FA9BEA6A2670")

    private char zeroDigit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.050 -0400", hash_original_field = "29A1470067B045281DEAF936A75D8C06", hash_generated_field = "6CB8DCB59FFD8713E9C1C344A13F088C")

    private char digit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.050 -0400", hash_original_field = "48A6CA504F67CF2BD9895069CD4472FA", hash_generated_field = "E461D5D24B0D46970F3080026F5DAB3B")

    private char decimalSeparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.050 -0400", hash_original_field = "3A708173CA04CA37E5B22F97B4BC43CF", hash_generated_field = "5568C6DB84C3654DEE73CAFF55A6B581")

    private char groupingSeparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.050 -0400", hash_original_field = "CD221E3F127BA556BCF5DA2798A424B3", hash_generated_field = "6DF33D45ABDB8FE2C16C7A6B5B22148B")

    private char patternSeparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.050 -0400", hash_original_field = "354F047BA64552895B016BBDD60AB174", hash_generated_field = "35D478E85B6B0AC367D6451335AED786")

    private char percent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.050 -0400", hash_original_field = "D6C9C9F61F0116B9930F4EDD0F9D8227", hash_generated_field = "83CD8C34421477BE2D582B86E50D13B3")

    private char perMill;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.050 -0400", hash_original_field = "368D90094DFA80CD83BD48905254BFA2", hash_generated_field = "BE354A6C767B6735025B72C2F3218447")

    private char monetarySeparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.050 -0400", hash_original_field = "094850D5B1A3856672905D85A426AC77", hash_generated_field = "418B8DC329FE67FA16666E2093EA0558")

    private char minusSign;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.050 -0400", hash_original_field = "F2FDEE93271556E428DD9507B3DA7235", hash_generated_field = "E87067D299572259E6A5A50B5C50F402")

    private String infinity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.050 -0400", hash_original_field = "7ECFB3BF076A6A9635F975FE96AC97FD", hash_generated_field = "84564C16EC7DF5A18776A88E04BB85F2")

    private String NaN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.050 -0400", hash_original_field = "C5613A5A91579972FBAE451ACABEB080", hash_generated_field = "9155F1D4247E37AE2D732FFAE046AD76")

    private String currencySymbol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.050 -0400", hash_original_field = "880FF64D34B5489D22BD4683FE484CE8", hash_generated_field = "A7BD4117286329CC7FB1D92F79A53FB8")

    private String intlCurrencySymbol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.050 -0400", hash_original_field = "1AF0389838508D7016A9841EB6273962", hash_generated_field = "E59704290C574597EDF0C1232CAFF8C9")

    private transient Currency currency;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.050 -0400", hash_original_field = "FB216D9E8791E63C8D12BDC420956839", hash_generated_field = "28E42E34FE73475FADA137DE37E55757")

    private transient Locale locale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.050 -0400", hash_original_field = "95B0BA924E85C891BF81984E42E23DBB", hash_generated_field = "3597EF8DA5A09BA6DA4C6C1E5177AE99")

    private transient String exponentSeparator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.051 -0400", hash_original_method = "91524EB1B511A6593A9E4C16AA4F2798", hash_generated_method = "56C5B7DBED39CFE7A5BF60DA4A9A951E")
    public  DecimalFormatSymbols() {
        this(Locale.getDefault());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.111 -0400", hash_original_method = "0AEA27B26006219100D92BC0021E5648", hash_generated_method = "A717958FEDCCEB20B03CC3F4451C1126")
    public  DecimalFormatSymbols(Locale locale) {
        LocaleData localeData;
        localeData = LocaleData.get(locale);
        this.zeroDigit = localeData.zeroDigit;
        this.digit = '#';
        this.decimalSeparator = localeData.decimalSeparator;
        this.groupingSeparator = localeData.groupingSeparator;
        this.patternSeparator = localeData.patternSeparator;
        this.percent = localeData.percent;
        this.perMill = localeData.perMill;
        this.monetarySeparator = localeData.monetarySeparator;
        this.minusSign = localeData.minusSign;
        this.infinity = localeData.infinity;
        this.NaN = localeData.NaN;
        this.exponentSeparator = localeData.exponentSeparator;
        this.locale = locale;
        try 
        {
            currency = Currency.getInstance(locale);
            currencySymbol = currency.getSymbol(locale);
            intlCurrencySymbol = currency.getCurrencyCode();
        } //End block
        catch (IllegalArgumentException e)
        {
            currency = Currency.getInstance("XXX");
            currencySymbol = localeData.currencySymbol;
            intlCurrencySymbol = localeData.internationalCurrencySymbol;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static DecimalFormatSymbols getInstance() {
        return getInstance(Locale.getDefault());
    }

    
        public static DecimalFormatSymbols getInstance(Locale locale) {
        if (locale == null) {
            throw new NullPointerException();
        }
        return new DecimalFormatSymbols(locale);
    }

    
        public static Locale[] getAvailableLocales() {
        return ICU.getAvailableDecimalFormatSymbolsLocales();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.115 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "C31A8EE5789C13F60FA09F2F0B621E08")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_637808756 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_637808756 = super.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_637808756.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_637808756;
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.116 -0400", hash_original_method = "B3296A7E858EAC27CB28889E1F7A56D1", hash_generated_method = "C36993A184D76E4309E64F4B784DE4C2")
    @Override
    public boolean equals(Object object) {
        DecimalFormatSymbols obj;
        obj = (DecimalFormatSymbols) object;
        boolean varC158CC4243FB554C90CC017AB48211C2_191393102 = (currency.equals(obj.currency) &&
                currencySymbol.equals(obj.currencySymbol) &&
                decimalSeparator == obj.decimalSeparator &&
                digit == obj.digit &&
                exponentSeparator.equals(obj.exponentSeparator) &&
                groupingSeparator == obj.groupingSeparator &&
                infinity.equals(obj.infinity) &&
                intlCurrencySymbol.equals(obj.intlCurrencySymbol) &&
                minusSign == obj.minusSign &&
                monetarySeparator == obj.monetarySeparator &&
                NaN.equals(obj.NaN) &&
                patternSeparator == obj.patternSeparator &&
                perMill == obj.perMill &&
                percent == obj.percent &&
                zeroDigit == obj.zeroDigit);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1306888917 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1306888917;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.126 -0400", hash_original_method = "A8625956386363E3EFDBA37B24F1F247", hash_generated_method = "5C5FBA1D12D1CA520A36865D29B4EA6D")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_230846031 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_230846031 = getClass().getName() +
                "[currency=" + currency +
                ",currencySymbol=" + currencySymbol +
                ",decimalSeparator=" + decimalSeparator +
                ",digit=" + digit +
                ",exponentSeparator=" + exponentSeparator +
                ",groupingSeparator=" + groupingSeparator +
                ",infinity=" + infinity +
                ",intlCurrencySymbol=" + intlCurrencySymbol +
                ",minusSign=" + minusSign +
                ",monetarySeparator=" + monetarySeparator +
                ",NaN=" + NaN +
                ",patternSeparator=" + patternSeparator +
                ",perMill=" + perMill +
                ",percent=" + percent +
                ",zeroDigit=" + zeroDigit +
                "]";
        varB4EAC82CA7396A68D541C85D26508E83_230846031.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_230846031;
        // ---------- Original Method ----------
        //return getClass().getName() +
                //"[currency=" + currency +
                //",currencySymbol=" + currencySymbol +
                //",decimalSeparator=" + decimalSeparator +
                //",digit=" + digit +
                //",exponentSeparator=" + exponentSeparator +
                //",groupingSeparator=" + groupingSeparator +
                //",infinity=" + infinity +
                //",intlCurrencySymbol=" + intlCurrencySymbol +
                //",minusSign=" + minusSign +
                //",monetarySeparator=" + monetarySeparator +
                //",NaN=" + NaN +
                //",patternSeparator=" + patternSeparator +
                //",perMill=" + perMill +
                //",percent=" + percent +
                //",zeroDigit=" + zeroDigit +
                //"]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.127 -0400", hash_original_method = "595F433D4A540AB9FD57454DFC2D00CA", hash_generated_method = "33BB8E4FE4BD6ECC67E34107B404563D")
    public Currency getCurrency() {
        Currency varB4EAC82CA7396A68D541C85D26508E83_1495313590 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1495313590 = currency;
        varB4EAC82CA7396A68D541C85D26508E83_1495313590.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1495313590;
        // ---------- Original Method ----------
        //return currency;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.128 -0400", hash_original_method = "9A7223B2A10801087A5753E160EB5AD9", hash_generated_method = "7C9E5CC067631DEDA1A73FEE8272BAB5")
    public String getInternationalCurrencySymbol() {
        String varB4EAC82CA7396A68D541C85D26508E83_1870077273 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1870077273 = intlCurrencySymbol;
        varB4EAC82CA7396A68D541C85D26508E83_1870077273.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1870077273;
        // ---------- Original Method ----------
        //return intlCurrencySymbol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.129 -0400", hash_original_method = "44BA6DF186734A9129EE433C5393A649", hash_generated_method = "F62EB01AE254E24C7C71DD1693DF8FC6")
    public String getCurrencySymbol() {
        String varB4EAC82CA7396A68D541C85D26508E83_283666400 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_283666400 = currencySymbol;
        varB4EAC82CA7396A68D541C85D26508E83_283666400.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_283666400;
        // ---------- Original Method ----------
        //return currencySymbol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.129 -0400", hash_original_method = "C908C2BC77C07C5C3074706ADD440EBB", hash_generated_method = "2463CD051296F610320C9172B74B3F3D")
    public char getDecimalSeparator() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_631461077 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_631461077;
        // ---------- Original Method ----------
        //return decimalSeparator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.129 -0400", hash_original_method = "4E80424FBB82914FDC63C744E843DFA5", hash_generated_method = "F1E16AC9381F6A464E698E4A72B89EDF")
    public char getDigit() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_1103730422 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1103730422;
        // ---------- Original Method ----------
        //return digit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.142 -0400", hash_original_method = "0D8DAB63E4E740341CDDC10B95F6771D", hash_generated_method = "33ECB7311AD758AE16501B9E6AABA1BF")
    public char getGroupingSeparator() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_848808051 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_848808051;
        // ---------- Original Method ----------
        //return groupingSeparator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.144 -0400", hash_original_method = "195513F858098AF1B8C98F122DD853CE", hash_generated_method = "256BB0B92A7CDF25F6CC79ADA3D57204")
    public String getInfinity() {
        String varB4EAC82CA7396A68D541C85D26508E83_89698682 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_89698682 = infinity;
        varB4EAC82CA7396A68D541C85D26508E83_89698682.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_89698682;
        // ---------- Original Method ----------
        //return infinity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.144 -0400", hash_original_method = "B02DD985FFD3C706D5501C97C0FC9E68", hash_generated_method = "2BBF217DA7DF3D5C22B74E510A126AB0")
    public char getMinusSign() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_68349733 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_68349733;
        // ---------- Original Method ----------
        //return minusSign;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.144 -0400", hash_original_method = "C02AEBD6916CB8991D4B6D1CCA4BA867", hash_generated_method = "99881A38C92C6A9F87B649074D5C2F8D")
    public char getMonetaryDecimalSeparator() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_1373394089 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1373394089;
        // ---------- Original Method ----------
        //return monetarySeparator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.144 -0400", hash_original_method = "A7A5B5565C9E586C08E861055D3F830D", hash_generated_method = "792D04C7DC9FBB4690236264DBC49EE4")
    public String getNaN() {
        String varB4EAC82CA7396A68D541C85D26508E83_1167627252 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1167627252 = NaN;
        varB4EAC82CA7396A68D541C85D26508E83_1167627252.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1167627252;
        // ---------- Original Method ----------
        //return NaN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.145 -0400", hash_original_method = "D38F7AE8E1369570AEDB785398752C04", hash_generated_method = "B9E448F6E4675926C02CAD09CA04FE1F")
    public char getPatternSeparator() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_308473713 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_308473713;
        // ---------- Original Method ----------
        //return patternSeparator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.145 -0400", hash_original_method = "0F05A385A7483224A3B3B115F4941DEA", hash_generated_method = "74309D0B0395A2392CDFB14F7E99F689")
    public char getPercent() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_1849910709 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1849910709;
        // ---------- Original Method ----------
        //return percent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.145 -0400", hash_original_method = "DDC83740D050E65F948D715CA46AA4E6", hash_generated_method = "DE4255E26024D24C7BAB3B27C65694D2")
    public char getPerMill() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_1651500985 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1651500985;
        // ---------- Original Method ----------
        //return perMill;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.162 -0400", hash_original_method = "5E609E25361E12310E119A02851AA08C", hash_generated_method = "A67A190F243112B34E8BB6F8090F2A32")
    public char getZeroDigit() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_1215849458 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1215849458;
        // ---------- Original Method ----------
        //return zeroDigit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.164 -0400", hash_original_method = "819A49232B9C4BF84239DF8CB1CAA3C1", hash_generated_method = "6CB27CA96BA662A0E8DC6119AD1903CF")
    public String getExponentSeparator() {
        String varB4EAC82CA7396A68D541C85D26508E83_797679515 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_797679515 = exponentSeparator;
        varB4EAC82CA7396A68D541C85D26508E83_797679515.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_797679515;
        // ---------- Original Method ----------
        //return exponentSeparator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.166 -0400", hash_original_method = "730AF15AAE06AD4A292A18D5EB73C960", hash_generated_method = "80FFAE6121BEF97DF217F5BF0701F050")
    @Override
    public int hashCode() {
        int result;
        result = 17;
        result = 31*result + zeroDigit;
        result = 31*result + digit;
        result = 31*result + decimalSeparator;
        result = 31*result + groupingSeparator;
        result = 31*result + patternSeparator;
        result = 31*result + percent;
        result = 31*result + perMill;
        result = 31*result + monetarySeparator;
        result = 31*result + minusSign;
        result = 31*result + exponentSeparator.hashCode();
        result = 31*result + infinity.hashCode();
        result = 31*result + NaN.hashCode();
        result = 31*result + currencySymbol.hashCode();
        result = 31*result + intlCurrencySymbol.hashCode();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1676057631 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1676057631;
        // ---------- Original Method ----------
        //int result = 17;
        //result = 31*result + zeroDigit;
        //result = 31*result + digit;
        //result = 31*result + decimalSeparator;
        //result = 31*result + groupingSeparator;
        //result = 31*result + patternSeparator;
        //result = 31*result + percent;
        //result = 31*result + perMill;
        //result = 31*result + monetarySeparator;
        //result = 31*result + minusSign;
        //result = 31*result + exponentSeparator.hashCode();
        //result = 31*result + infinity.hashCode();
        //result = 31*result + NaN.hashCode();
        //result = 31*result + currencySymbol.hashCode();
        //result = 31*result + intlCurrencySymbol.hashCode();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.181 -0400", hash_original_method = "92D5537D8B3843A17694170BBEA5586B", hash_generated_method = "6B8EEED2B17092FFB0A922029CAD848C")
    public void setCurrency(Currency currency) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        this.currency = currency;
        intlCurrencySymbol = currency.getCurrencyCode();
        currencySymbol = currency.getSymbol(locale);
        // ---------- Original Method ----------
        //if (currency == null) {
            //throw new NullPointerException();
        //}
        //if (currency == this.currency) {
            //return;
        //}
        //this.currency = currency;
        //intlCurrencySymbol = currency.getCurrencyCode();
        //currencySymbol = currency.getSymbol(locale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.181 -0400", hash_original_method = "207176AE532CCEDF88793D675BD5BB7E", hash_generated_method = "6E4A10B0AA8D54CCECAF9677764C19BB")
    public void setInternationalCurrencySymbol(String value) {
        {
            currency = null;
            intlCurrencySymbol = null;
        } //End block
        {
            boolean var8EB9949666341D3A42DA12AD2DEE9D4F_470164338 = (value.equals(intlCurrencySymbol));
        } //End collapsed parenthetic
        try 
        {
            currency = Currency.getInstance(value);
            currencySymbol = currency.getSymbol(locale);
        } //End block
        catch (IllegalArgumentException e)
        {
            currency = null;
        } //End block
        intlCurrencySymbol = value;
        // ---------- Original Method ----------
        //if (value == null) {
            //currency = null;
            //intlCurrencySymbol = null;
            //return;
        //}
        //if (value.equals(intlCurrencySymbol)) {
            //return;
        //}
        //try {
            //currency = Currency.getInstance(value);
            //currencySymbol = currency.getSymbol(locale);
        //} catch (IllegalArgumentException e) {
            //currency = null;
        //}
        //intlCurrencySymbol = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.182 -0400", hash_original_method = "29E8104D01D46C7E9FE837881A4B811D", hash_generated_method = "A1B254E664FC163A6D6D66EE9051B9E5")
    public void setCurrencySymbol(String value) {
        this.currencySymbol = value;
        // ---------- Original Method ----------
        //this.currencySymbol = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.182 -0400", hash_original_method = "9AC8CCC4F998C35713D40EA8501A574C", hash_generated_method = "4539C6F9693002CBFA4139FAA5A10266")
    public void setDecimalSeparator(char value) {
        this.decimalSeparator = value;
        // ---------- Original Method ----------
        //this.decimalSeparator = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.182 -0400", hash_original_method = "D6FAF1D38DB7E623F52AE4E3C83BC924", hash_generated_method = "7711FAE92BC9F01A058CFEF49755A394")
    public void setDigit(char value) {
        this.digit = value;
        // ---------- Original Method ----------
        //this.digit = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.182 -0400", hash_original_method = "9D270588D20ED0589BF78FE9A748D06B", hash_generated_method = "C292B529EBE5F04DB57AE205EC3B991A")
    public void setGroupingSeparator(char value) {
        this.groupingSeparator = value;
        // ---------- Original Method ----------
        //this.groupingSeparator = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.183 -0400", hash_original_method = "253C85BF9C056E30DB4FF21631672E45", hash_generated_method = "ABF5584BEC1CA4A91D70149ED70C9A27")
    public void setInfinity(String value) {
        this.infinity = value;
        // ---------- Original Method ----------
        //this.infinity = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.183 -0400", hash_original_method = "D3F4D7B2767531D5CB8D7EDFAA19A0F0", hash_generated_method = "97F2E98A9053428A52AC61901D7A6FEA")
    public void setMinusSign(char value) {
        this.minusSign = value;
        // ---------- Original Method ----------
        //this.minusSign = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.183 -0400", hash_original_method = "5DC5988EDD7C3CC1FE974B80FD913370", hash_generated_method = "37C329CB534FCBA848ADC17C5247D834")
    public void setMonetaryDecimalSeparator(char value) {
        this.monetarySeparator = value;
        // ---------- Original Method ----------
        //this.monetarySeparator = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.197 -0400", hash_original_method = "6A48D24176C36753AA1CCB849BDA297D", hash_generated_method = "AA33C8D18B728D340C95D0AD4D935FA8")
    public void setNaN(String value) {
        this.NaN = value;
        // ---------- Original Method ----------
        //this.NaN = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.198 -0400", hash_original_method = "F9CB88FF85D83DD076D59F9C65C2F022", hash_generated_method = "3017D9D53BF3860D543CEE81C7ED5A22")
    public void setPatternSeparator(char value) {
        this.patternSeparator = value;
        // ---------- Original Method ----------
        //this.patternSeparator = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.198 -0400", hash_original_method = "82CC4266781153E2E37AE97635E76BF7", hash_generated_method = "4EDEC5C156FF56FDE2BCE58452EA9BAA")
    public void setPercent(char value) {
        this.percent = value;
        // ---------- Original Method ----------
        //this.percent = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.198 -0400", hash_original_method = "A113C8FE00852B00BE817507D877FFEC", hash_generated_method = "2304401BB8B19A673A86CB5806CCD958")
    public void setPerMill(char value) {
        this.perMill = value;
        // ---------- Original Method ----------
        //this.perMill = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.199 -0400", hash_original_method = "1F31C9A94279CEAA9BC58336D0C15AE7", hash_generated_method = "0DC2F198C5C3860518C6B4FFDAA37AED")
    public void setZeroDigit(char value) {
        this.zeroDigit = value;
        // ---------- Original Method ----------
        //this.zeroDigit = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.199 -0400", hash_original_method = "9B9F6C7BB1C5EA5DED0636F1E4439683", hash_generated_method = "C2D672E8013B5AEA26D251C812D6DB9D")
    public void setExponentSeparator(String value) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        this.exponentSeparator = value;
        // ---------- Original Method ----------
        //if (value == null) {
            //throw new NullPointerException();
        //}
        //this.exponentSeparator = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.208 -0400", hash_original_method = "AC413B5955CC7818D3CB585AD477DBD8", hash_generated_method = "498682A82FC1B87E34A34CECAF359939")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        ObjectOutputStream.PutField fields;
        fields = stream.putFields();
        fields.put("currencySymbol", currencySymbol);
        fields.put("decimalSeparator", getDecimalSeparator());
        fields.put("digit", getDigit());
        fields.put("exponential", exponentSeparator.charAt(0));
        fields.put("exponentialSeparator", exponentSeparator);
        fields.put("groupingSeparator", getGroupingSeparator());
        fields.put("infinity", infinity);
        fields.put("intlCurrencySymbol", intlCurrencySymbol);
        fields.put("minusSign", getMinusSign());
        fields.put("monetarySeparator", getMonetaryDecimalSeparator());
        fields.put("NaN", NaN);
        fields.put("patternSeparator", getPatternSeparator());
        fields.put("percent", getPercent());
        fields.put("perMill", getPerMill());
        fields.put("serialVersionOnStream", 3);
        fields.put("zeroDigit", getZeroDigit());
        fields.put("locale", locale);
        stream.writeFields();
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.209 -0400", hash_original_method = "6B45962B37C777732BB6D07E7138D37B", hash_generated_method = "6310BE663E2CD0A0CD8332A9EF9B5FD0")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields;
        fields = stream.readFields();
        int serialVersionOnStream;
        serialVersionOnStream = fields.get("serialVersionOnStream", 0);
        currencySymbol = (String) fields.get("currencySymbol", "");
        setDecimalSeparator(fields.get("decimalSeparator", '.'));
        setDigit(fields.get("digit", '#'));
        setGroupingSeparator(fields.get("groupingSeparator", ','));
        infinity = (String) fields.get("infinity", "");
        intlCurrencySymbol = (String) fields.get("intlCurrencySymbol", "");
        setMinusSign(fields.get("minusSign", '-'));
        NaN = (String) fields.get("NaN", "");
        setPatternSeparator(fields.get("patternSeparator", ';'));
        setPercent(fields.get("percent", '%'));
        setPerMill(fields.get("perMill", '\u2030'));
        setZeroDigit(fields.get("zeroDigit", '0'));
        locale = (Locale) fields.get("locale", null);
        {
            setMonetaryDecimalSeparator(getDecimalSeparator());
        } //End block
        {
            setMonetaryDecimalSeparator(fields.get("monetarySeparator", '.'));
        } //End block
        {
            exponentSeparator = "E";
        } //End block
        {
            setExponentSeparator(String.valueOf(fields.get("exponential", 'E')));
        } //End block
        {
            setExponentSeparator((String) fields.get("exponentialSeparator", "E"));
        } //End block
        try 
        {
            currency = Currency.getInstance(intlCurrencySymbol);
        } //End block
        catch (IllegalArgumentException e)
        {
            currency = null;
        } //End block
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.209 -0400", hash_original_field = "C1546AD2F0A1B24A763042F20510D2DC", hash_generated_field = "752AA812D1A9FCEB34A34C7D7F8E3C6F")

    private static long serialVersionUID = 5772796243397350300L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.209 -0400", hash_original_field = "A497A46D73270DC9F3E7811070586C67", hash_generated_field = "DF3B779AC65293AACA2C768A9CD43464")

    private static ObjectStreamField[] serialPersistentFields = ;
}

