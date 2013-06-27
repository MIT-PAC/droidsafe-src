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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.983 -0400", hash_original_field = "8AD80D213027B16530912C1C1C7453EF", hash_generated_field = "182114D634E44B2F9FF8FA9BEA6A2670")

    private char zeroDigit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.983 -0400", hash_original_field = "29A1470067B045281DEAF936A75D8C06", hash_generated_field = "6CB8DCB59FFD8713E9C1C344A13F088C")

    private char digit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.983 -0400", hash_original_field = "48A6CA504F67CF2BD9895069CD4472FA", hash_generated_field = "E461D5D24B0D46970F3080026F5DAB3B")

    private char decimalSeparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.983 -0400", hash_original_field = "3A708173CA04CA37E5B22F97B4BC43CF", hash_generated_field = "5568C6DB84C3654DEE73CAFF55A6B581")

    private char groupingSeparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.983 -0400", hash_original_field = "CD221E3F127BA556BCF5DA2798A424B3", hash_generated_field = "6DF33D45ABDB8FE2C16C7A6B5B22148B")

    private char patternSeparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.983 -0400", hash_original_field = "354F047BA64552895B016BBDD60AB174", hash_generated_field = "35D478E85B6B0AC367D6451335AED786")

    private char percent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.983 -0400", hash_original_field = "D6C9C9F61F0116B9930F4EDD0F9D8227", hash_generated_field = "83CD8C34421477BE2D582B86E50D13B3")

    private char perMill;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.984 -0400", hash_original_field = "368D90094DFA80CD83BD48905254BFA2", hash_generated_field = "BE354A6C767B6735025B72C2F3218447")

    private char monetarySeparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.984 -0400", hash_original_field = "094850D5B1A3856672905D85A426AC77", hash_generated_field = "418B8DC329FE67FA16666E2093EA0558")

    private char minusSign;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.999 -0400", hash_original_field = "F2FDEE93271556E428DD9507B3DA7235", hash_generated_field = "E87067D299572259E6A5A50B5C50F402")

    private String infinity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.999 -0400", hash_original_field = "7ECFB3BF076A6A9635F975FE96AC97FD", hash_generated_field = "84564C16EC7DF5A18776A88E04BB85F2")

    private String NaN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.999 -0400", hash_original_field = "C5613A5A91579972FBAE451ACABEB080", hash_generated_field = "9155F1D4247E37AE2D732FFAE046AD76")

    private String currencySymbol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.999 -0400", hash_original_field = "880FF64D34B5489D22BD4683FE484CE8", hash_generated_field = "A7BD4117286329CC7FB1D92F79A53FB8")

    private String intlCurrencySymbol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.000 -0400", hash_original_field = "1AF0389838508D7016A9841EB6273962", hash_generated_field = "E59704290C574597EDF0C1232CAFF8C9")

    private transient Currency currency;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.000 -0400", hash_original_field = "FB216D9E8791E63C8D12BDC420956839", hash_generated_field = "28E42E34FE73475FADA137DE37E55757")

    private transient Locale locale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.000 -0400", hash_original_field = "95B0BA924E85C891BF81984E42E23DBB", hash_generated_field = "3597EF8DA5A09BA6DA4C6C1E5177AE99")

    private transient String exponentSeparator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.000 -0400", hash_original_method = "91524EB1B511A6593A9E4C16AA4F2798", hash_generated_method = "56C5B7DBED39CFE7A5BF60DA4A9A951E")
    public  DecimalFormatSymbols() {
        this(Locale.getDefault());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.016 -0400", hash_original_method = "0AEA27B26006219100D92BC0021E5648", hash_generated_method = "A717958FEDCCEB20B03CC3F4451C1126")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.017 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "81E6FA57E46E68173192B5C25C8071E9")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1094226171 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1094226171 = super.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1094226171.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1094226171;
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.018 -0400", hash_original_method = "B3296A7E858EAC27CB28889E1F7A56D1", hash_generated_method = "A785F74955BF8A18A3567DF9C275146D")
    @Override
    public boolean equals(Object object) {
        DecimalFormatSymbols obj;
        obj = (DecimalFormatSymbols) object;
        boolean varC158CC4243FB554C90CC017AB48211C2_2136834248 = (currency.equals(obj.currency) &&
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_354521658 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_354521658;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.019 -0400", hash_original_method = "A8625956386363E3EFDBA37B24F1F247", hash_generated_method = "B668A1FC7046B4E71D89256F95E5DA43")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_528643419 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_528643419 = getClass().getName() +
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
        varB4EAC82CA7396A68D541C85D26508E83_528643419.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_528643419;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.020 -0400", hash_original_method = "595F433D4A540AB9FD57454DFC2D00CA", hash_generated_method = "A88AD5F008B5DBC5EDCA5EB6CE2707CE")
    public Currency getCurrency() {
        Currency varB4EAC82CA7396A68D541C85D26508E83_720192737 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_720192737 = currency;
        varB4EAC82CA7396A68D541C85D26508E83_720192737.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_720192737;
        // ---------- Original Method ----------
        //return currency;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.020 -0400", hash_original_method = "9A7223B2A10801087A5753E160EB5AD9", hash_generated_method = "518237C478BE79442FE68011458CB150")
    public String getInternationalCurrencySymbol() {
        String varB4EAC82CA7396A68D541C85D26508E83_627140912 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_627140912 = intlCurrencySymbol;
        varB4EAC82CA7396A68D541C85D26508E83_627140912.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_627140912;
        // ---------- Original Method ----------
        //return intlCurrencySymbol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.021 -0400", hash_original_method = "44BA6DF186734A9129EE433C5393A649", hash_generated_method = "E15C41664BA11545EE7A70730CCE9200")
    public String getCurrencySymbol() {
        String varB4EAC82CA7396A68D541C85D26508E83_1851578461 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1851578461 = currencySymbol;
        varB4EAC82CA7396A68D541C85D26508E83_1851578461.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1851578461;
        // ---------- Original Method ----------
        //return currencySymbol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.027 -0400", hash_original_method = "C908C2BC77C07C5C3074706ADD440EBB", hash_generated_method = "33AD02B1D5C298ED051DFA6BA7C65B81")
    public char getDecimalSeparator() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_864396408 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_864396408;
        // ---------- Original Method ----------
        //return decimalSeparator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.027 -0400", hash_original_method = "4E80424FBB82914FDC63C744E843DFA5", hash_generated_method = "B16C30E80F851B76541283B249CA2CDF")
    public char getDigit() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_1953686263 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1953686263;
        // ---------- Original Method ----------
        //return digit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.028 -0400", hash_original_method = "0D8DAB63E4E740341CDDC10B95F6771D", hash_generated_method = "006B25E68B133A023B3A73255D738830")
    public char getGroupingSeparator() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_970915818 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_970915818;
        // ---------- Original Method ----------
        //return groupingSeparator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.029 -0400", hash_original_method = "195513F858098AF1B8C98F122DD853CE", hash_generated_method = "FAB522F53FEFD9D1382CD80ECFC24E2A")
    public String getInfinity() {
        String varB4EAC82CA7396A68D541C85D26508E83_1952166543 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1952166543 = infinity;
        varB4EAC82CA7396A68D541C85D26508E83_1952166543.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1952166543;
        // ---------- Original Method ----------
        //return infinity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.029 -0400", hash_original_method = "B02DD985FFD3C706D5501C97C0FC9E68", hash_generated_method = "A249869A343651C012572AE4B3C00745")
    public char getMinusSign() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_1123944558 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1123944558;
        // ---------- Original Method ----------
        //return minusSign;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.029 -0400", hash_original_method = "C02AEBD6916CB8991D4B6D1CCA4BA867", hash_generated_method = "C5338AC89845DA9D2886E2B79AE66588")
    public char getMonetaryDecimalSeparator() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_447280156 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_447280156;
        // ---------- Original Method ----------
        //return monetarySeparator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.044 -0400", hash_original_method = "A7A5B5565C9E586C08E861055D3F830D", hash_generated_method = "C6D6F889AEB40709CF417B11EEA794DA")
    public String getNaN() {
        String varB4EAC82CA7396A68D541C85D26508E83_573155255 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_573155255 = NaN;
        varB4EAC82CA7396A68D541C85D26508E83_573155255.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_573155255;
        // ---------- Original Method ----------
        //return NaN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.044 -0400", hash_original_method = "D38F7AE8E1369570AEDB785398752C04", hash_generated_method = "7AE3B3CE2F0DFC04B2988F4016A0B9D4")
    public char getPatternSeparator() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_459648215 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_459648215;
        // ---------- Original Method ----------
        //return patternSeparator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.045 -0400", hash_original_method = "0F05A385A7483224A3B3B115F4941DEA", hash_generated_method = "501EB3CF5E39BE503ECC5A50386FC4E9")
    public char getPercent() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_1627177063 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1627177063;
        // ---------- Original Method ----------
        //return percent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.046 -0400", hash_original_method = "DDC83740D050E65F948D715CA46AA4E6", hash_generated_method = "8D695088531D953C116F776646E40BA0")
    public char getPerMill() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_1170110017 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1170110017;
        // ---------- Original Method ----------
        //return perMill;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.046 -0400", hash_original_method = "5E609E25361E12310E119A02851AA08C", hash_generated_method = "E409E9E2B47C3F16993F840E12690A2B")
    public char getZeroDigit() {
        char varA87DEB01C5F539E6BDA34829C8EF2368_782860317 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_782860317;
        // ---------- Original Method ----------
        //return zeroDigit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.046 -0400", hash_original_method = "819A49232B9C4BF84239DF8CB1CAA3C1", hash_generated_method = "3EF3FCEEF7514D24FB59FFB30186C18E")
    public String getExponentSeparator() {
        String varB4EAC82CA7396A68D541C85D26508E83_1097127991 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1097127991 = exponentSeparator;
        varB4EAC82CA7396A68D541C85D26508E83_1097127991.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1097127991;
        // ---------- Original Method ----------
        //return exponentSeparator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.051 -0400", hash_original_method = "730AF15AAE06AD4A292A18D5EB73C960", hash_generated_method = "38AE83396871639E2EE895CF293EEB97")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1863150866 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1863150866;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.069 -0400", hash_original_method = "92D5537D8B3843A17694170BBEA5586B", hash_generated_method = "6B8EEED2B17092FFB0A922029CAD848C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.075 -0400", hash_original_method = "207176AE532CCEDF88793D675BD5BB7E", hash_generated_method = "44027B86F592407A5107A46D4EA13487")
    public void setInternationalCurrencySymbol(String value) {
        {
            currency = null;
            intlCurrencySymbol = null;
        } //End block
        {
            boolean var8EB9949666341D3A42DA12AD2DEE9D4F_919420585 = (value.equals(intlCurrencySymbol));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.076 -0400", hash_original_method = "29E8104D01D46C7E9FE837881A4B811D", hash_generated_method = "A1B254E664FC163A6D6D66EE9051B9E5")
    public void setCurrencySymbol(String value) {
        this.currencySymbol = value;
        // ---------- Original Method ----------
        //this.currencySymbol = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.092 -0400", hash_original_method = "9AC8CCC4F998C35713D40EA8501A574C", hash_generated_method = "4539C6F9693002CBFA4139FAA5A10266")
    public void setDecimalSeparator(char value) {
        this.decimalSeparator = value;
        // ---------- Original Method ----------
        //this.decimalSeparator = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.092 -0400", hash_original_method = "D6FAF1D38DB7E623F52AE4E3C83BC924", hash_generated_method = "7711FAE92BC9F01A058CFEF49755A394")
    public void setDigit(char value) {
        this.digit = value;
        // ---------- Original Method ----------
        //this.digit = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.093 -0400", hash_original_method = "9D270588D20ED0589BF78FE9A748D06B", hash_generated_method = "C292B529EBE5F04DB57AE205EC3B991A")
    public void setGroupingSeparator(char value) {
        this.groupingSeparator = value;
        // ---------- Original Method ----------
        //this.groupingSeparator = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.093 -0400", hash_original_method = "253C85BF9C056E30DB4FF21631672E45", hash_generated_method = "ABF5584BEC1CA4A91D70149ED70C9A27")
    public void setInfinity(String value) {
        this.infinity = value;
        // ---------- Original Method ----------
        //this.infinity = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.094 -0400", hash_original_method = "D3F4D7B2767531D5CB8D7EDFAA19A0F0", hash_generated_method = "97F2E98A9053428A52AC61901D7A6FEA")
    public void setMinusSign(char value) {
        this.minusSign = value;
        // ---------- Original Method ----------
        //this.minusSign = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.094 -0400", hash_original_method = "5DC5988EDD7C3CC1FE974B80FD913370", hash_generated_method = "37C329CB534FCBA848ADC17C5247D834")
    public void setMonetaryDecimalSeparator(char value) {
        this.monetarySeparator = value;
        // ---------- Original Method ----------
        //this.monetarySeparator = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.094 -0400", hash_original_method = "6A48D24176C36753AA1CCB849BDA297D", hash_generated_method = "AA33C8D18B728D340C95D0AD4D935FA8")
    public void setNaN(String value) {
        this.NaN = value;
        // ---------- Original Method ----------
        //this.NaN = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.095 -0400", hash_original_method = "F9CB88FF85D83DD076D59F9C65C2F022", hash_generated_method = "3017D9D53BF3860D543CEE81C7ED5A22")
    public void setPatternSeparator(char value) {
        this.patternSeparator = value;
        // ---------- Original Method ----------
        //this.patternSeparator = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.095 -0400", hash_original_method = "82CC4266781153E2E37AE97635E76BF7", hash_generated_method = "4EDEC5C156FF56FDE2BCE58452EA9BAA")
    public void setPercent(char value) {
        this.percent = value;
        // ---------- Original Method ----------
        //this.percent = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.095 -0400", hash_original_method = "A113C8FE00852B00BE817507D877FFEC", hash_generated_method = "2304401BB8B19A673A86CB5806CCD958")
    public void setPerMill(char value) {
        this.perMill = value;
        // ---------- Original Method ----------
        //this.perMill = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.096 -0400", hash_original_method = "1F31C9A94279CEAA9BC58336D0C15AE7", hash_generated_method = "0DC2F198C5C3860518C6B4FFDAA37AED")
    public void setZeroDigit(char value) {
        this.zeroDigit = value;
        // ---------- Original Method ----------
        //this.zeroDigit = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.096 -0400", hash_original_method = "9B9F6C7BB1C5EA5DED0636F1E4439683", hash_generated_method = "C2D672E8013B5AEA26D251C812D6DB9D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.209 -0400", hash_original_method = "AC413B5955CC7818D3CB585AD477DBD8", hash_generated_method = "498682A82FC1B87E34A34CECAF359939")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.216 -0400", hash_original_method = "6B45962B37C777732BB6D07E7138D37B", hash_generated_method = "6310BE663E2CD0A0CD8332A9EF9B5FD0")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.216 -0400", hash_original_field = "C1546AD2F0A1B24A763042F20510D2DC", hash_generated_field = "752AA812D1A9FCEB34A34C7D7F8E3C6F")

    private static long serialVersionUID = 5772796243397350300L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.216 -0400", hash_original_field = "A497A46D73270DC9F3E7811070586C67", hash_generated_field = "660F915E80BD36DDF1E6032CF939EB87")

    private static ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("currencySymbol", String.class),
        new ObjectStreamField("decimalSeparator", char.class),
        new ObjectStreamField("digit", char.class),
        new ObjectStreamField("exponential", char.class),
        new ObjectStreamField("exponentialSeparator", String.class),
        new ObjectStreamField("groupingSeparator", char.class),
        new ObjectStreamField("infinity", String.class),
        new ObjectStreamField("intlCurrencySymbol", String.class),
        new ObjectStreamField("minusSign", char.class),
        new ObjectStreamField("monetarySeparator", char.class),
        new ObjectStreamField("NaN", String.class),
        new ObjectStreamField("patternSeparator", char.class),
        new ObjectStreamField("percent", char.class),
        new ObjectStreamField("perMill", char.class),
        new ObjectStreamField("serialVersionOnStream", int.class),
        new ObjectStreamField("zeroDigit", char.class),
        new ObjectStreamField("locale", Locale.class),
    };
}

