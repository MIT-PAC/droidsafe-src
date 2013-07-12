package java.text;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.621 -0400", hash_original_field = "8AD80D213027B16530912C1C1C7453EF", hash_generated_field = "182114D634E44B2F9FF8FA9BEA6A2670")

    private char zeroDigit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.621 -0400", hash_original_field = "29A1470067B045281DEAF936A75D8C06", hash_generated_field = "6CB8DCB59FFD8713E9C1C344A13F088C")

    private char digit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.621 -0400", hash_original_field = "48A6CA504F67CF2BD9895069CD4472FA", hash_generated_field = "E461D5D24B0D46970F3080026F5DAB3B")

    private char decimalSeparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.621 -0400", hash_original_field = "3A708173CA04CA37E5B22F97B4BC43CF", hash_generated_field = "5568C6DB84C3654DEE73CAFF55A6B581")

    private char groupingSeparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.621 -0400", hash_original_field = "CD221E3F127BA556BCF5DA2798A424B3", hash_generated_field = "6DF33D45ABDB8FE2C16C7A6B5B22148B")

    private char patternSeparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.621 -0400", hash_original_field = "354F047BA64552895B016BBDD60AB174", hash_generated_field = "35D478E85B6B0AC367D6451335AED786")

    private char percent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.621 -0400", hash_original_field = "D6C9C9F61F0116B9930F4EDD0F9D8227", hash_generated_field = "83CD8C34421477BE2D582B86E50D13B3")

    private char perMill;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.622 -0400", hash_original_field = "368D90094DFA80CD83BD48905254BFA2", hash_generated_field = "BE354A6C767B6735025B72C2F3218447")

    private char monetarySeparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.622 -0400", hash_original_field = "094850D5B1A3856672905D85A426AC77", hash_generated_field = "418B8DC329FE67FA16666E2093EA0558")

    private char minusSign;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.622 -0400", hash_original_field = "F2FDEE93271556E428DD9507B3DA7235", hash_generated_field = "E87067D299572259E6A5A50B5C50F402")

    private String infinity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.622 -0400", hash_original_field = "7ECFB3BF076A6A9635F975FE96AC97FD", hash_generated_field = "84564C16EC7DF5A18776A88E04BB85F2")

    private String NaN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.622 -0400", hash_original_field = "C5613A5A91579972FBAE451ACABEB080", hash_generated_field = "9155F1D4247E37AE2D732FFAE046AD76")

    private String currencySymbol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.622 -0400", hash_original_field = "880FF64D34B5489D22BD4683FE484CE8", hash_generated_field = "A7BD4117286329CC7FB1D92F79A53FB8")

    private String intlCurrencySymbol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.622 -0400", hash_original_field = "1AF0389838508D7016A9841EB6273962", hash_generated_field = "E59704290C574597EDF0C1232CAFF8C9")

    private transient Currency currency;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.622 -0400", hash_original_field = "FB216D9E8791E63C8D12BDC420956839", hash_generated_field = "28E42E34FE73475FADA137DE37E55757")

    private transient Locale locale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.622 -0400", hash_original_field = "95B0BA924E85C891BF81984E42E23DBB", hash_generated_field = "3597EF8DA5A09BA6DA4C6C1E5177AE99")

    private transient String exponentSeparator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.623 -0400", hash_original_method = "91524EB1B511A6593A9E4C16AA4F2798", hash_generated_method = "56C5B7DBED39CFE7A5BF60DA4A9A951E")
    public  DecimalFormatSymbols() {
        this(Locale.getDefault());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.626 -0400", hash_original_method = "0AEA27B26006219100D92BC0021E5648", hash_generated_method = "0C40F0BF5A36D944A9C064502F428D15")
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
        } 
        catch (IllegalArgumentException e)
        {
            currency = Currency.getInstance("XXX");
            currencySymbol = localeData.currencySymbol;
            intlCurrencySymbol = localeData.internationalCurrencySymbol;
        } 
        
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.627 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "B840AA7B80056C5776E9C4FD85654EA4")
    @Override
    public Object clone() {
        try 
        {
Object var46F3A0D86742C1D6E099C2B166941A33_105565556 =             super.clone();
            var46F3A0D86742C1D6E099C2B166941A33_105565556.addTaint(taint);
            return var46F3A0D86742C1D6E099C2B166941A33_105565556;
        } 
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_528888612 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_528888612.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_528888612;
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.628 -0400", hash_original_method = "B3296A7E858EAC27CB28889E1F7A56D1", hash_generated_method = "C57E823F7F5D489B37810441E4E2B41D")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
    if(this == object)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_958446152 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1962365716 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1962365716;
        } 
    if(!(object instanceof DecimalFormatSymbols))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1523936267 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1330280267 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1330280267;
        } 
        DecimalFormatSymbols obj = (DecimalFormatSymbols) object;
        boolean var107FAF9BE703CAF82A450A71575EDA6B_1630279103 = (currency.equals(obj.currency) &&
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
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_966370205 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_966370205;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.629 -0400", hash_original_method = "A8625956386363E3EFDBA37B24F1F247", hash_generated_method = "777CE350B18B30DA04B94FDE125305CF")
    @Override
    public String toString() {
String var22C3B0BA5F0FC12075CF2D57A25D0A22_2021409755 =         getClass().getName() +
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
        var22C3B0BA5F0FC12075CF2D57A25D0A22_2021409755.addTaint(taint);
        return var22C3B0BA5F0FC12075CF2D57A25D0A22_2021409755;
        
        
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.629 -0400", hash_original_method = "595F433D4A540AB9FD57454DFC2D00CA", hash_generated_method = "B110881861E2D1FAA34AE7E4EF8C58EA")
    public Currency getCurrency() {
Currency var05943DA259B0C6AE5B5DE9B3E5D0D71C_1282430901 =         currency;
        var05943DA259B0C6AE5B5DE9B3E5D0D71C_1282430901.addTaint(taint);
        return var05943DA259B0C6AE5B5DE9B3E5D0D71C_1282430901;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.629 -0400", hash_original_method = "9A7223B2A10801087A5753E160EB5AD9", hash_generated_method = "9DF3ECE2842C3BB0AEFB096EC9734FBE")
    public String getInternationalCurrencySymbol() {
String varDB22D121B4DC5D377D10BD415496517A_1070354903 =         intlCurrencySymbol;
        varDB22D121B4DC5D377D10BD415496517A_1070354903.addTaint(taint);
        return varDB22D121B4DC5D377D10BD415496517A_1070354903;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.630 -0400", hash_original_method = "44BA6DF186734A9129EE433C5393A649", hash_generated_method = "4BF79E3705ADA9E82D28E6EB7B29D0EF")
    public String getCurrencySymbol() {
String varE5FBAAE09BB3027B1B6A5DC2F7C8DF5F_2084147217 =         currencySymbol;
        varE5FBAAE09BB3027B1B6A5DC2F7C8DF5F_2084147217.addTaint(taint);
        return varE5FBAAE09BB3027B1B6A5DC2F7C8DF5F_2084147217;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.630 -0400", hash_original_method = "C908C2BC77C07C5C3074706ADD440EBB", hash_generated_method = "52B5FC026DC1D55AC633067600974488")
    public char getDecimalSeparator() {
        char var48A6CA504F67CF2BD9895069CD4472FA_918610408 = (decimalSeparator);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1734154192 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1734154192;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.630 -0400", hash_original_method = "4E80424FBB82914FDC63C744E843DFA5", hash_generated_method = "3883B67209510C721D1536978B2C18BA")
    public char getDigit() {
        char var29A1470067B045281DEAF936A75D8C06_434316060 = (digit);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1858607690 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1858607690;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.631 -0400", hash_original_method = "0D8DAB63E4E740341CDDC10B95F6771D", hash_generated_method = "A59E65413772C2FD717A3E7D32082894")
    public char getGroupingSeparator() {
        char var3A708173CA04CA37E5B22F97B4BC43CF_2027995838 = (groupingSeparator);
                char varA87DEB01C5F539E6BDA34829C8EF2368_709823684 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_709823684;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.631 -0400", hash_original_method = "195513F858098AF1B8C98F122DD853CE", hash_generated_method = "DBAFBB0510C85BC4F86061A57B46CD0D")
    public String getInfinity() {
String varD826F01678C0988122ADB8C93417E177_1327019280 =         infinity;
        varD826F01678C0988122ADB8C93417E177_1327019280.addTaint(taint);
        return varD826F01678C0988122ADB8C93417E177_1327019280;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.631 -0400", hash_original_method = "B02DD985FFD3C706D5501C97C0FC9E68", hash_generated_method = "AE92F2C7C62B06DC119C18D89D6AD96E")
    public char getMinusSign() {
        char var094850D5B1A3856672905D85A426AC77_960715386 = (minusSign);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1214563925 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1214563925;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.632 -0400", hash_original_method = "C02AEBD6916CB8991D4B6D1CCA4BA867", hash_generated_method = "BD733FD2809CEFD2A3580BC190BC048E")
    public char getMonetaryDecimalSeparator() {
        char var368D90094DFA80CD83BD48905254BFA2_1480926167 = (monetarySeparator);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1674888260 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1674888260;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.632 -0400", hash_original_method = "A7A5B5565C9E586C08E861055D3F830D", hash_generated_method = "000E7BB5B89B9AB4F262B62D6DA00B22")
    public String getNaN() {
String var7664F764E2574F36842BC374E1714106_744129640 =         NaN;
        var7664F764E2574F36842BC374E1714106_744129640.addTaint(taint);
        return var7664F764E2574F36842BC374E1714106_744129640;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.632 -0400", hash_original_method = "D38F7AE8E1369570AEDB785398752C04", hash_generated_method = "F658ADD98FC5E6B0524770D48684D283")
    public char getPatternSeparator() {
        char varCD221E3F127BA556BCF5DA2798A424B3_1285068670 = (patternSeparator);
                char varA87DEB01C5F539E6BDA34829C8EF2368_80580453 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_80580453;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.633 -0400", hash_original_method = "0F05A385A7483224A3B3B115F4941DEA", hash_generated_method = "C5E4029AD86453F8F836C4A3CAE8102D")
    public char getPercent() {
        char var354F047BA64552895B016BBDD60AB174_1674334390 = (percent);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1355639850 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1355639850;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.633 -0400", hash_original_method = "DDC83740D050E65F948D715CA46AA4E6", hash_generated_method = "9D7FF71EE7BB7267F7F4A12EEC7DA27B")
    public char getPerMill() {
        char varD6C9C9F61F0116B9930F4EDD0F9D8227_215849698 = (perMill);
                char varA87DEB01C5F539E6BDA34829C8EF2368_253065277 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_253065277;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.633 -0400", hash_original_method = "5E609E25361E12310E119A02851AA08C", hash_generated_method = "86D51986FA67E434AC732C48C8CBAD21")
    public char getZeroDigit() {
        char var8AD80D213027B16530912C1C1C7453EF_633926730 = (zeroDigit);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1813467327 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1813467327;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.634 -0400", hash_original_method = "819A49232B9C4BF84239DF8CB1CAA3C1", hash_generated_method = "21E760BA805BF903D749990C7EA0BC8B")
    public String getExponentSeparator() {
String varDC51D8165EE9EB6F1490FA1CA4EEB129_1812940421 =         exponentSeparator;
        varDC51D8165EE9EB6F1490FA1CA4EEB129_1812940421.addTaint(taint);
        return varDC51D8165EE9EB6F1490FA1CA4EEB129_1812940421;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.636 -0400", hash_original_method = "730AF15AAE06AD4A292A18D5EB73C960", hash_generated_method = "2C70BA5233C2C5E56483E035B3BFAFAF")
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
        int varB4A88417B3D0170D754C647C30B7216A_670125058 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_504885994 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_504885994;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.637 -0400", hash_original_method = "92D5537D8B3843A17694170BBEA5586B", hash_generated_method = "DAFC74E3607094B9B544446519BEDDDF")
    public void setCurrency(Currency currency) {
    if(currency == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1315488595 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1315488595.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1315488595;
        } 
    if(currency == this.currency)        
        {
            return;
        } 
        this.currency = currency;
        intlCurrencySymbol = currency.getCurrencyCode();
        currencySymbol = currency.getSymbol(locale);
        
        
            
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.639 -0400", hash_original_method = "207176AE532CCEDF88793D675BD5BB7E", hash_generated_method = "2E0FB49B2DA5CF4A23DCC90F8AB49642")
    public void setInternationalCurrencySymbol(String value) {
    if(value == null)        
        {
            currency = null;
            intlCurrencySymbol = null;
            return;
        } 
    if(value.equals(intlCurrencySymbol))        
        {
            return;
        } 
        try 
        {
            currency = Currency.getInstance(value);
            currencySymbol = currency.getSymbol(locale);
        } 
        catch (IllegalArgumentException e)
        {
            currency = null;
        } 
        intlCurrencySymbol = value;
        
        
            
            
            
        
        
            
        
        
            
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.640 -0400", hash_original_method = "29E8104D01D46C7E9FE837881A4B811D", hash_generated_method = "A1B254E664FC163A6D6D66EE9051B9E5")
    public void setCurrencySymbol(String value) {
        this.currencySymbol = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.640 -0400", hash_original_method = "9AC8CCC4F998C35713D40EA8501A574C", hash_generated_method = "4539C6F9693002CBFA4139FAA5A10266")
    public void setDecimalSeparator(char value) {
        this.decimalSeparator = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.641 -0400", hash_original_method = "D6FAF1D38DB7E623F52AE4E3C83BC924", hash_generated_method = "7711FAE92BC9F01A058CFEF49755A394")
    public void setDigit(char value) {
        this.digit = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.642 -0400", hash_original_method = "9D270588D20ED0589BF78FE9A748D06B", hash_generated_method = "C292B529EBE5F04DB57AE205EC3B991A")
    public void setGroupingSeparator(char value) {
        this.groupingSeparator = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.642 -0400", hash_original_method = "253C85BF9C056E30DB4FF21631672E45", hash_generated_method = "ABF5584BEC1CA4A91D70149ED70C9A27")
    public void setInfinity(String value) {
        this.infinity = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.643 -0400", hash_original_method = "D3F4D7B2767531D5CB8D7EDFAA19A0F0", hash_generated_method = "97F2E98A9053428A52AC61901D7A6FEA")
    public void setMinusSign(char value) {
        this.minusSign = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.643 -0400", hash_original_method = "5DC5988EDD7C3CC1FE974B80FD913370", hash_generated_method = "37C329CB534FCBA848ADC17C5247D834")
    public void setMonetaryDecimalSeparator(char value) {
        this.monetarySeparator = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.644 -0400", hash_original_method = "6A48D24176C36753AA1CCB849BDA297D", hash_generated_method = "AA33C8D18B728D340C95D0AD4D935FA8")
    public void setNaN(String value) {
        this.NaN = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.644 -0400", hash_original_method = "F9CB88FF85D83DD076D59F9C65C2F022", hash_generated_method = "3017D9D53BF3860D543CEE81C7ED5A22")
    public void setPatternSeparator(char value) {
        this.patternSeparator = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.645 -0400", hash_original_method = "82CC4266781153E2E37AE97635E76BF7", hash_generated_method = "4EDEC5C156FF56FDE2BCE58452EA9BAA")
    public void setPercent(char value) {
        this.percent = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.645 -0400", hash_original_method = "A113C8FE00852B00BE817507D877FFEC", hash_generated_method = "2304401BB8B19A673A86CB5806CCD958")
    public void setPerMill(char value) {
        this.perMill = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.645 -0400", hash_original_method = "1F31C9A94279CEAA9BC58336D0C15AE7", hash_generated_method = "0DC2F198C5C3860518C6B4FFDAA37AED")
    public void setZeroDigit(char value) {
        this.zeroDigit = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.646 -0400", hash_original_method = "9B9F6C7BB1C5EA5DED0636F1E4439683", hash_generated_method = "55C2BE232DB75D900039692C5993AF47")
    public void setExponentSeparator(String value) {
    if(value == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1198679923 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1198679923.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1198679923;
        } 
        this.exponentSeparator = value;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.647 -0400", hash_original_method = "AC413B5955CC7818D3CB585AD477DBD8", hash_generated_method = "4D2A2895964DF0D57B1D0BBB55C534F0")
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
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.648 -0400", hash_original_method = "6B45962B37C777732BB6D07E7138D37B", hash_generated_method = "C408F6234E0FF6225B7B81806FDC0D24")
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
        } 
        else
        {
            setMonetaryDecimalSeparator(fields.get("monetarySeparator", '.'));
        } 
    if(serialVersionOnStream == 0)        
        {
            exponentSeparator = "E";
        } 
        else
    if(serialVersionOnStream < 3)        
        {
            setExponentSeparator(String.valueOf(fields.get("exponential", 'E')));
        } 
        else
        {
            setExponentSeparator((String) fields.get("exponentialSeparator", "E"));
        } 
        try 
        {
            currency = Currency.getInstance(intlCurrencySymbol);
        } 
        catch (IllegalArgumentException e)
        {
            currency = null;
        } 
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.649 -0400", hash_original_field = "C1546AD2F0A1B24A763042F20510D2DC", hash_generated_field = "87839485C41D69D54758762801BECCB5")

    private static final long serialVersionUID = 5772796243397350300L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.649 -0400", hash_original_field = "A497A46D73270DC9F3E7811070586C67", hash_generated_field = "EBF01AA379088E4ACAF6533F65E738B5")

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

