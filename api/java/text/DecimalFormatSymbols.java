package java.text;

// Droidsafe Imports
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Currency;
import java.util.Locale;

import libcore.icu.ICU;
import libcore.icu.LocaleData;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class DecimalFormatSymbols implements Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.466 -0400", hash_original_field = "8AD80D213027B16530912C1C1C7453EF", hash_generated_field = "182114D634E44B2F9FF8FA9BEA6A2670")

    private char zeroDigit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.466 -0400", hash_original_field = "29A1470067B045281DEAF936A75D8C06", hash_generated_field = "6CB8DCB59FFD8713E9C1C344A13F088C")

    private char digit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.466 -0400", hash_original_field = "48A6CA504F67CF2BD9895069CD4472FA", hash_generated_field = "E461D5D24B0D46970F3080026F5DAB3B")

    private char decimalSeparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.466 -0400", hash_original_field = "3A708173CA04CA37E5B22F97B4BC43CF", hash_generated_field = "5568C6DB84C3654DEE73CAFF55A6B581")

    private char groupingSeparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.466 -0400", hash_original_field = "CD221E3F127BA556BCF5DA2798A424B3", hash_generated_field = "6DF33D45ABDB8FE2C16C7A6B5B22148B")

    private char patternSeparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.466 -0400", hash_original_field = "354F047BA64552895B016BBDD60AB174", hash_generated_field = "35D478E85B6B0AC367D6451335AED786")

    private char percent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.466 -0400", hash_original_field = "D6C9C9F61F0116B9930F4EDD0F9D8227", hash_generated_field = "83CD8C34421477BE2D582B86E50D13B3")

    private char perMill;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.466 -0400", hash_original_field = "368D90094DFA80CD83BD48905254BFA2", hash_generated_field = "BE354A6C767B6735025B72C2F3218447")

    private char monetarySeparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.466 -0400", hash_original_field = "094850D5B1A3856672905D85A426AC77", hash_generated_field = "418B8DC329FE67FA16666E2093EA0558")

    private char minusSign;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.466 -0400", hash_original_field = "F2FDEE93271556E428DD9507B3DA7235", hash_generated_field = "E87067D299572259E6A5A50B5C50F402")

    private String infinity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.466 -0400", hash_original_field = "7ECFB3BF076A6A9635F975FE96AC97FD", hash_generated_field = "84564C16EC7DF5A18776A88E04BB85F2")

    private String NaN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.467 -0400", hash_original_field = "C5613A5A91579972FBAE451ACABEB080", hash_generated_field = "9155F1D4247E37AE2D732FFAE046AD76")

    private String currencySymbol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.467 -0400", hash_original_field = "880FF64D34B5489D22BD4683FE484CE8", hash_generated_field = "A7BD4117286329CC7FB1D92F79A53FB8")

    private String intlCurrencySymbol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.467 -0400", hash_original_field = "1AF0389838508D7016A9841EB6273962", hash_generated_field = "E59704290C574597EDF0C1232CAFF8C9")

    private transient Currency currency;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.467 -0400", hash_original_field = "FB216D9E8791E63C8D12BDC420956839", hash_generated_field = "28E42E34FE73475FADA137DE37E55757")

    private transient Locale locale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.467 -0400", hash_original_field = "95B0BA924E85C891BF81984E42E23DBB", hash_generated_field = "3597EF8DA5A09BA6DA4C6C1E5177AE99")

    private transient String exponentSeparator;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.467 -0400", hash_original_method = "91524EB1B511A6593A9E4C16AA4F2798", hash_generated_method = "56C5B7DBED39CFE7A5BF60DA4A9A951E")
    public  DecimalFormatSymbols() {
        this(Locale.getDefault());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.470 -0400", hash_original_method = "0AEA27B26006219100D92BC0021E5648", hash_generated_method = "0C40F0BF5A36D944A9C064502F428D15")
    public  DecimalFormatSymbols(Locale locale) {
        LocaleData localeData = LocaleData.get(locale);
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

    
    @DSModeled(DSC.SAFE)
    public static DecimalFormatSymbols getInstance() {
        return getInstance(Locale.getDefault());
    }

    
    @DSModeled(DSC.SAFE)
    public static DecimalFormatSymbols getInstance(Locale locale) {
        if (locale == null) {
            throw new NullPointerException();
        }
        return new DecimalFormatSymbols(locale);
    }

    
    @DSModeled(DSC.SAFE)
    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableDecimalFormatSymbolsLocales();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.471 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "050537DC05494374C0B2BDACB01672E6")
    @Override
    public Object clone() {
        try 
        {
Object var46F3A0D86742C1D6E099C2B166941A33_1198147724 =             super.clone();
            var46F3A0D86742C1D6E099C2B166941A33_1198147724.addTaint(taint);
            return var46F3A0D86742C1D6E099C2B166941A33_1198147724;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_1820772539 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_1820772539.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_1820772539;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.477 -0400", hash_original_method = "B3296A7E858EAC27CB28889E1F7A56D1", hash_generated_method = "1476DB9C85B6DE35C7B844223AF03723")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        if(this == object)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_963451474 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1108863878 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1108863878;
        } //End block
        if(!(object instanceof DecimalFormatSymbols))        
        {
            boolean var68934A3E9455FA72420237EB05902327_203643566 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_436599595 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_436599595;
        } //End block
        DecimalFormatSymbols obj = (DecimalFormatSymbols) object;
        boolean var107FAF9BE703CAF82A450A71575EDA6B_255542715 = (currency.equals(obj.currency) &&
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
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1667727298 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1667727298;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.477 -0400", hash_original_method = "A8625956386363E3EFDBA37B24F1F247", hash_generated_method = "79CC50369ABE8FE78A50910BF06EEE99")
    @Override
    public String toString() {
String var22C3B0BA5F0FC12075CF2D57A25D0A22_420949110 =         getClass().getName() +
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
        var22C3B0BA5F0FC12075CF2D57A25D0A22_420949110.addTaint(taint);
        return var22C3B0BA5F0FC12075CF2D57A25D0A22_420949110;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.477 -0400", hash_original_method = "595F433D4A540AB9FD57454DFC2D00CA", hash_generated_method = "AFEE4A6169876F49D4439F55817F0E32")
    public Currency getCurrency() {
Currency var05943DA259B0C6AE5B5DE9B3E5D0D71C_1012852633 =         currency;
        var05943DA259B0C6AE5B5DE9B3E5D0D71C_1012852633.addTaint(taint);
        return var05943DA259B0C6AE5B5DE9B3E5D0D71C_1012852633;
        // ---------- Original Method ----------
        //return currency;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.478 -0400", hash_original_method = "9A7223B2A10801087A5753E160EB5AD9", hash_generated_method = "26B7E8DC1AB0559542E94B6D2FA20C2E")
    public String getInternationalCurrencySymbol() {
String varDB22D121B4DC5D377D10BD415496517A_389905396 =         intlCurrencySymbol;
        varDB22D121B4DC5D377D10BD415496517A_389905396.addTaint(taint);
        return varDB22D121B4DC5D377D10BD415496517A_389905396;
        // ---------- Original Method ----------
        //return intlCurrencySymbol;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.478 -0400", hash_original_method = "44BA6DF186734A9129EE433C5393A649", hash_generated_method = "3800618D19112B1E6F7A52612DCF7FE7")
    public String getCurrencySymbol() {
String varE5FBAAE09BB3027B1B6A5DC2F7C8DF5F_879742109 =         currencySymbol;
        varE5FBAAE09BB3027B1B6A5DC2F7C8DF5F_879742109.addTaint(taint);
        return varE5FBAAE09BB3027B1B6A5DC2F7C8DF5F_879742109;
        // ---------- Original Method ----------
        //return currencySymbol;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.478 -0400", hash_original_method = "C908C2BC77C07C5C3074706ADD440EBB", hash_generated_method = "AF3EAA338190BCFBFC1911F020B70AF4")
    public char getDecimalSeparator() {
        char var48A6CA504F67CF2BD9895069CD4472FA_1345875495 = (decimalSeparator);
                char varA87DEB01C5F539E6BDA34829C8EF2368_717584972 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_717584972;
        // ---------- Original Method ----------
        //return decimalSeparator;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.478 -0400", hash_original_method = "4E80424FBB82914FDC63C744E843DFA5", hash_generated_method = "99EAC343EE9CDDEDCE4E4610C749C32C")
    public char getDigit() {
        char var29A1470067B045281DEAF936A75D8C06_1906675591 = (digit);
                char varA87DEB01C5F539E6BDA34829C8EF2368_510109129 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_510109129;
        // ---------- Original Method ----------
        //return digit;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.478 -0400", hash_original_method = "0D8DAB63E4E740341CDDC10B95F6771D", hash_generated_method = "432F3A16C07731160BBB230A51847E6D")
    public char getGroupingSeparator() {
        char var3A708173CA04CA37E5B22F97B4BC43CF_1841548568 = (groupingSeparator);
                char varA87DEB01C5F539E6BDA34829C8EF2368_704640861 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_704640861;
        // ---------- Original Method ----------
        //return groupingSeparator;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.478 -0400", hash_original_method = "195513F858098AF1B8C98F122DD853CE", hash_generated_method = "3ED8B9FB765EBFA3602BFF20705AF327")
    public String getInfinity() {
String varD826F01678C0988122ADB8C93417E177_1293468829 =         infinity;
        varD826F01678C0988122ADB8C93417E177_1293468829.addTaint(taint);
        return varD826F01678C0988122ADB8C93417E177_1293468829;
        // ---------- Original Method ----------
        //return infinity;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.478 -0400", hash_original_method = "B02DD985FFD3C706D5501C97C0FC9E68", hash_generated_method = "13668A5C92FF1C859477A47727E45E10")
    public char getMinusSign() {
        char var094850D5B1A3856672905D85A426AC77_1664583500 = (minusSign);
                char varA87DEB01C5F539E6BDA34829C8EF2368_337711408 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_337711408;
        // ---------- Original Method ----------
        //return minusSign;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.478 -0400", hash_original_method = "C02AEBD6916CB8991D4B6D1CCA4BA867", hash_generated_method = "DF011D77D9461238833B3661242BE2B6")
    public char getMonetaryDecimalSeparator() {
        char var368D90094DFA80CD83BD48905254BFA2_1936784999 = (monetarySeparator);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1432582470 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1432582470;
        // ---------- Original Method ----------
        //return monetarySeparator;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.478 -0400", hash_original_method = "A7A5B5565C9E586C08E861055D3F830D", hash_generated_method = "84781D565543FBCC72C1DD5F6D2DC8A5")
    public String getNaN() {
String var7664F764E2574F36842BC374E1714106_877241714 =         NaN;
        var7664F764E2574F36842BC374E1714106_877241714.addTaint(taint);
        return var7664F764E2574F36842BC374E1714106_877241714;
        // ---------- Original Method ----------
        //return NaN;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.478 -0400", hash_original_method = "D38F7AE8E1369570AEDB785398752C04", hash_generated_method = "01104EB921E559BA7809B16A802D6323")
    public char getPatternSeparator() {
        char varCD221E3F127BA556BCF5DA2798A424B3_1803507009 = (patternSeparator);
                char varA87DEB01C5F539E6BDA34829C8EF2368_2072610469 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_2072610469;
        // ---------- Original Method ----------
        //return patternSeparator;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.478 -0400", hash_original_method = "0F05A385A7483224A3B3B115F4941DEA", hash_generated_method = "B0E19FBDD222E6913DA348700A0D9AE6")
    public char getPercent() {
        char var354F047BA64552895B016BBDD60AB174_9411292 = (percent);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1260807307 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1260807307;
        // ---------- Original Method ----------
        //return percent;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.478 -0400", hash_original_method = "DDC83740D050E65F948D715CA46AA4E6", hash_generated_method = "2B9E32EF711A54CD353C4E3D7399D69D")
    public char getPerMill() {
        char varD6C9C9F61F0116B9930F4EDD0F9D8227_1158360407 = (perMill);
                char varA87DEB01C5F539E6BDA34829C8EF2368_552829420 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_552829420;
        // ---------- Original Method ----------
        //return perMill;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.479 -0400", hash_original_method = "5E609E25361E12310E119A02851AA08C", hash_generated_method = "71458C002DBA56022C2F1F9FE7E97764")
    public char getZeroDigit() {
        char var8AD80D213027B16530912C1C1C7453EF_988063706 = (zeroDigit);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1994885097 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1994885097;
        // ---------- Original Method ----------
        //return zeroDigit;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.479 -0400", hash_original_method = "819A49232B9C4BF84239DF8CB1CAA3C1", hash_generated_method = "BC265B7EA361ECEC98D499CF7D7B86B1")
    public String getExponentSeparator() {
String varDC51D8165EE9EB6F1490FA1CA4EEB129_1746059771 =         exponentSeparator;
        varDC51D8165EE9EB6F1490FA1CA4EEB129_1746059771.addTaint(taint);
        return varDC51D8165EE9EB6F1490FA1CA4EEB129_1746059771;
        // ---------- Original Method ----------
        //return exponentSeparator;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.479 -0400", hash_original_method = "730AF15AAE06AD4A292A18D5EB73C960", hash_generated_method = "15F9A4D7B30EE61D37CF6E0CD3DB674F")
    @Override
    public int hashCode() {
        int result = 17;
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
        int varB4A88417B3D0170D754C647C30B7216A_1377221651 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_714681804 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_714681804;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.480 -0400", hash_original_method = "92D5537D8B3843A17694170BBEA5586B", hash_generated_method = "6096A905D0F7A8C3054EF28399147F21")
    public void setCurrency(Currency currency) {
        if(currency == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1298784719 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1298784719.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1298784719;
        } //End block
        if(currency == this.currency)        
        {
            return;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.480 -0400", hash_original_method = "207176AE532CCEDF88793D675BD5BB7E", hash_generated_method = "2E0FB49B2DA5CF4A23DCC90F8AB49642")
    public void setInternationalCurrencySymbol(String value) {
        if(value == null)        
        {
            currency = null;
            intlCurrencySymbol = null;
            return;
        } //End block
        if(value.equals(intlCurrencySymbol))        
        {
            return;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.480 -0400", hash_original_method = "29E8104D01D46C7E9FE837881A4B811D", hash_generated_method = "A1B254E664FC163A6D6D66EE9051B9E5")
    public void setCurrencySymbol(String value) {
        this.currencySymbol = value;
        // ---------- Original Method ----------
        //this.currencySymbol = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.480 -0400", hash_original_method = "9AC8CCC4F998C35713D40EA8501A574C", hash_generated_method = "4539C6F9693002CBFA4139FAA5A10266")
    public void setDecimalSeparator(char value) {
        this.decimalSeparator = value;
        // ---------- Original Method ----------
        //this.decimalSeparator = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.480 -0400", hash_original_method = "D6FAF1D38DB7E623F52AE4E3C83BC924", hash_generated_method = "7711FAE92BC9F01A058CFEF49755A394")
    public void setDigit(char value) {
        this.digit = value;
        // ---------- Original Method ----------
        //this.digit = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.480 -0400", hash_original_method = "9D270588D20ED0589BF78FE9A748D06B", hash_generated_method = "C292B529EBE5F04DB57AE205EC3B991A")
    public void setGroupingSeparator(char value) {
        this.groupingSeparator = value;
        // ---------- Original Method ----------
        //this.groupingSeparator = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.481 -0400", hash_original_method = "253C85BF9C056E30DB4FF21631672E45", hash_generated_method = "ABF5584BEC1CA4A91D70149ED70C9A27")
    public void setInfinity(String value) {
        this.infinity = value;
        // ---------- Original Method ----------
        //this.infinity = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.481 -0400", hash_original_method = "D3F4D7B2767531D5CB8D7EDFAA19A0F0", hash_generated_method = "97F2E98A9053428A52AC61901D7A6FEA")
    public void setMinusSign(char value) {
        this.minusSign = value;
        // ---------- Original Method ----------
        //this.minusSign = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.481 -0400", hash_original_method = "5DC5988EDD7C3CC1FE974B80FD913370", hash_generated_method = "37C329CB534FCBA848ADC17C5247D834")
    public void setMonetaryDecimalSeparator(char value) {
        this.monetarySeparator = value;
        // ---------- Original Method ----------
        //this.monetarySeparator = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.481 -0400", hash_original_method = "6A48D24176C36753AA1CCB849BDA297D", hash_generated_method = "AA33C8D18B728D340C95D0AD4D935FA8")
    public void setNaN(String value) {
        this.NaN = value;
        // ---------- Original Method ----------
        //this.NaN = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.481 -0400", hash_original_method = "F9CB88FF85D83DD076D59F9C65C2F022", hash_generated_method = "3017D9D53BF3860D543CEE81C7ED5A22")
    public void setPatternSeparator(char value) {
        this.patternSeparator = value;
        // ---------- Original Method ----------
        //this.patternSeparator = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.481 -0400", hash_original_method = "82CC4266781153E2E37AE97635E76BF7", hash_generated_method = "4EDEC5C156FF56FDE2BCE58452EA9BAA")
    public void setPercent(char value) {
        this.percent = value;
        // ---------- Original Method ----------
        //this.percent = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.481 -0400", hash_original_method = "A113C8FE00852B00BE817507D877FFEC", hash_generated_method = "2304401BB8B19A673A86CB5806CCD958")
    public void setPerMill(char value) {
        this.perMill = value;
        // ---------- Original Method ----------
        //this.perMill = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.481 -0400", hash_original_method = "1F31C9A94279CEAA9BC58336D0C15AE7", hash_generated_method = "0DC2F198C5C3860518C6B4FFDAA37AED")
    public void setZeroDigit(char value) {
        this.zeroDigit = value;
        // ---------- Original Method ----------
        //this.zeroDigit = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.482 -0400", hash_original_method = "9B9F6C7BB1C5EA5DED0636F1E4439683", hash_generated_method = "C75952F6455A289C5DB04289EBDE3868")
    public void setExponentSeparator(String value) {
        if(value == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1012876738 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1012876738.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1012876738;
        } //End block
        this.exponentSeparator = value;
        // ---------- Original Method ----------
        //if (value == null) {
            //throw new NullPointerException();
        //}
        //this.exponentSeparator = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.482 -0400", hash_original_method = "AC413B5955CC7818D3CB585AD477DBD8", hash_generated_method = "4D2A2895964DF0D57B1D0BBB55C534F0")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        addTaint(stream.getTaint());
        ObjectOutputStream.PutField fields = stream.putFields();
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.483 -0400", hash_original_method = "6B45962B37C777732BB6D07E7138D37B", hash_generated_method = "C408F6234E0FF6225B7B81806FDC0D24")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        addTaint(stream.getTaint());
        ObjectInputStream.GetField fields = stream.readFields();
        final int serialVersionOnStream = fields.get("serialVersionOnStream", 0);
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
        if(serialVersionOnStream == 0)        
        {
            setMonetaryDecimalSeparator(getDecimalSeparator());
        } //End block
        else
        {
            setMonetaryDecimalSeparator(fields.get("monetarySeparator", '.'));
        } //End block
        if(serialVersionOnStream == 0)        
        {
            exponentSeparator = "E";
        } //End block
        else
        if(serialVersionOnStream < 3)        
        {
            setExponentSeparator(String.valueOf(fields.get("exponential", 'E')));
        } //End block
        else
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.483 -0400", hash_original_field = "C1546AD2F0A1B24A763042F20510D2DC", hash_generated_field = "87839485C41D69D54758762801BECCB5")

    private static final long serialVersionUID = 5772796243397350300L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.483 -0400", hash_original_field = "A497A46D73270DC9F3E7811070586C67", hash_generated_field = "EBF01AA379088E4ACAF6533F65E738B5")

    private static final ObjectStreamField[] serialPersistentFields = {
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

