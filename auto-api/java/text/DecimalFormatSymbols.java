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
    private char zeroDigit;
    private char digit;
    private char decimalSeparator;
    private char groupingSeparator;
    private char patternSeparator;
    private char percent;
    private char perMill;
    private char monetarySeparator;
    private char minusSign;
    private String infinity, NaN, currencySymbol, intlCurrencySymbol;
    private transient Currency currency;
    private transient Locale locale;
    private transient String exponentSeparator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.266 -0400", hash_original_method = "91524EB1B511A6593A9E4C16AA4F2798", hash_generated_method = "56C5B7DBED39CFE7A5BF60DA4A9A951E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DecimalFormatSymbols() {
        this(Locale.getDefault());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.267 -0400", hash_original_method = "0AEA27B26006219100D92BC0021E5648", hash_generated_method = "79212F372479F7F6C448BBB8F9878AD9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DecimalFormatSymbols(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.268 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "861441C0AD2D6A1BEDFB7B7449665351")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        try 
        {
            Object varDEB570B566DA7549E2F197D0AFA5A2B6_1783118356 = (super.clone());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.268 -0400", hash_original_method = "B3296A7E858EAC27CB28889E1F7A56D1", hash_generated_method = "2CECC66B86B2156D2B3EBFFB0E1224D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        DecimalFormatSymbols obj;
        obj = (DecimalFormatSymbols) object;
        boolean varC158CC4243FB554C90CC017AB48211C2_414555818 = (currency.equals(obj.currency) &&
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.269 -0400", hash_original_method = "A8625956386363E3EFDBA37B24F1F247", hash_generated_method = "7B6664F8FC03B8AE8978CE01AE722207")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varA8FD58D00DF2FE04003DDA0387EED1A1_1963257238 = (getClass().getName() +
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
                "]");
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.269 -0400", hash_original_method = "595F433D4A540AB9FD57454DFC2D00CA", hash_generated_method = "6F1B17BE4A19389EC4E5D6F94E767849")
    @DSModeled(DSC.SAFE)
    public Currency getCurrency() {
        return (Currency)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return currency;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.269 -0400", hash_original_method = "9A7223B2A10801087A5753E160EB5AD9", hash_generated_method = "DF91092143FF19D656832CC0032C69FA")
    @DSModeled(DSC.SAFE)
    public String getInternationalCurrencySymbol() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return intlCurrencySymbol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.269 -0400", hash_original_method = "44BA6DF186734A9129EE433C5393A649", hash_generated_method = "DA14079F1428C017BB2DE9C518AFD202")
    @DSModeled(DSC.SAFE)
    public String getCurrencySymbol() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return currencySymbol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.270 -0400", hash_original_method = "C908C2BC77C07C5C3074706ADD440EBB", hash_generated_method = "E52C0825A1F427DAD573DC0D37CD3E86")
    @DSModeled(DSC.SAFE)
    public char getDecimalSeparator() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return decimalSeparator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.270 -0400", hash_original_method = "4E80424FBB82914FDC63C744E843DFA5", hash_generated_method = "E2EC32F121A53DF354FBE33A625B2334")
    @DSModeled(DSC.SAFE)
    public char getDigit() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return digit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.270 -0400", hash_original_method = "0D8DAB63E4E740341CDDC10B95F6771D", hash_generated_method = "54ACEC08F2B597A2BD8076095EF3B75D")
    @DSModeled(DSC.SAFE)
    public char getGroupingSeparator() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return groupingSeparator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.270 -0400", hash_original_method = "195513F858098AF1B8C98F122DD853CE", hash_generated_method = "97288FC2E2BB8B0208BC2321982A6577")
    @DSModeled(DSC.SAFE)
    public String getInfinity() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return infinity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.270 -0400", hash_original_method = "B02DD985FFD3C706D5501C97C0FC9E68", hash_generated_method = "013DFE12D8B706F0D602BE73044B6AAB")
    @DSModeled(DSC.SAFE)
    public char getMinusSign() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return minusSign;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.270 -0400", hash_original_method = "C02AEBD6916CB8991D4B6D1CCA4BA867", hash_generated_method = "0F7D128907288C0B51728F61BFA5A1A8")
    @DSModeled(DSC.SAFE)
    public char getMonetaryDecimalSeparator() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return monetarySeparator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.271 -0400", hash_original_method = "A7A5B5565C9E586C08E861055D3F830D", hash_generated_method = "3ECD63CE1CA002A5DD5B0FA7C4C284B0")
    @DSModeled(DSC.SAFE)
    public String getNaN() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return NaN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.271 -0400", hash_original_method = "D38F7AE8E1369570AEDB785398752C04", hash_generated_method = "7E447246634D2FF90B88653279E9DF51")
    @DSModeled(DSC.SAFE)
    public char getPatternSeparator() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return patternSeparator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.271 -0400", hash_original_method = "0F05A385A7483224A3B3B115F4941DEA", hash_generated_method = "3D59E1751F162F9F08002CE70B75BBCC")
    @DSModeled(DSC.SAFE)
    public char getPercent() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return percent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.271 -0400", hash_original_method = "DDC83740D050E65F948D715CA46AA4E6", hash_generated_method = "EC99D3A10D45B7D6EC1FCABA0B5EAF9D")
    @DSModeled(DSC.SAFE)
    public char getPerMill() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return perMill;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.271 -0400", hash_original_method = "5E609E25361E12310E119A02851AA08C", hash_generated_method = "ECB4DFD9B58825DA7D38B010DFA09190")
    @DSModeled(DSC.SAFE)
    public char getZeroDigit() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return zeroDigit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.271 -0400", hash_original_method = "819A49232B9C4BF84239DF8CB1CAA3C1", hash_generated_method = "6FC575DED97F8F2606CF903B48943081")
    @DSModeled(DSC.SAFE)
    public String getExponentSeparator() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return exponentSeparator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.272 -0400", hash_original_method = "730AF15AAE06AD4A292A18D5EB73C960", hash_generated_method = "A128B9173ED3C809C2A6BE743D3F2F62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.272 -0400", hash_original_method = "92D5537D8B3843A17694170BBEA5586B", hash_generated_method = "CCFFB5023FBE0069D270C957ABF19A94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCurrency(Currency currency) {
        dsTaint.addTaint(currency.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.273 -0400", hash_original_method = "207176AE532CCEDF88793D675BD5BB7E", hash_generated_method = "73C39B505F65A206AE826A257079677C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setInternationalCurrencySymbol(String value) {
        dsTaint.addTaint(value);
        {
            currency = null;
            intlCurrencySymbol = null;
        } //End block
        {
            boolean var8EB9949666341D3A42DA12AD2DEE9D4F_537519039 = (value.equals(intlCurrencySymbol));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.273 -0400", hash_original_method = "29E8104D01D46C7E9FE837881A4B811D", hash_generated_method = "E99A14AE8E7D3ED6893A7E7099DF2B80")
    @DSModeled(DSC.SAFE)
    public void setCurrencySymbol(String value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.currencySymbol = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.273 -0400", hash_original_method = "9AC8CCC4F998C35713D40EA8501A574C", hash_generated_method = "2889DDFA4E8957BD569EEF9E97ED25C8")
    @DSModeled(DSC.SAFE)
    public void setDecimalSeparator(char value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.decimalSeparator = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.273 -0400", hash_original_method = "D6FAF1D38DB7E623F52AE4E3C83BC924", hash_generated_method = "5C39A235F01227F9F85AA7258CD2FDC9")
    @DSModeled(DSC.SAFE)
    public void setDigit(char value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.digit = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.273 -0400", hash_original_method = "9D270588D20ED0589BF78FE9A748D06B", hash_generated_method = "94A4FECF99C6FDE5044C54D389B7D65E")
    @DSModeled(DSC.SAFE)
    public void setGroupingSeparator(char value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.groupingSeparator = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.274 -0400", hash_original_method = "253C85BF9C056E30DB4FF21631672E45", hash_generated_method = "7BEEB580F96A578DABA7A49A79666D57")
    @DSModeled(DSC.SAFE)
    public void setInfinity(String value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.infinity = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.274 -0400", hash_original_method = "D3F4D7B2767531D5CB8D7EDFAA19A0F0", hash_generated_method = "6A909044F19EB0A49BF7BECCA08265EA")
    @DSModeled(DSC.SAFE)
    public void setMinusSign(char value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.minusSign = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.274 -0400", hash_original_method = "5DC5988EDD7C3CC1FE974B80FD913370", hash_generated_method = "5508AD210E57E84DF70590BF84129997")
    @DSModeled(DSC.SAFE)
    public void setMonetaryDecimalSeparator(char value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.monetarySeparator = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.274 -0400", hash_original_method = "6A48D24176C36753AA1CCB849BDA297D", hash_generated_method = "BFF53660793BACEAFB6D32CC736E3A30")
    @DSModeled(DSC.SAFE)
    public void setNaN(String value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.NaN = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.274 -0400", hash_original_method = "F9CB88FF85D83DD076D59F9C65C2F022", hash_generated_method = "9F4687BFE7F260C6D19956897F360423")
    @DSModeled(DSC.SAFE)
    public void setPatternSeparator(char value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.patternSeparator = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.275 -0400", hash_original_method = "82CC4266781153E2E37AE97635E76BF7", hash_generated_method = "E4F9770738C2D34E08112925B3812984")
    @DSModeled(DSC.SAFE)
    public void setPercent(char value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.percent = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.275 -0400", hash_original_method = "A113C8FE00852B00BE817507D877FFEC", hash_generated_method = "95065D92C902560432CA1851DC3688DC")
    @DSModeled(DSC.SAFE)
    public void setPerMill(char value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.perMill = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.275 -0400", hash_original_method = "1F31C9A94279CEAA9BC58336D0C15AE7", hash_generated_method = "299125E3DD9C65E2193E0C77CF862491")
    @DSModeled(DSC.SAFE)
    public void setZeroDigit(char value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.zeroDigit = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.275 -0400", hash_original_method = "9B9F6C7BB1C5EA5DED0636F1E4439683", hash_generated_method = "CAF2798BB6F81C6F9AB02567D337308D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setExponentSeparator(String value) {
        dsTaint.addTaint(value);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        // ---------- Original Method ----------
        //if (value == null) {
            //throw new NullPointerException();
        //}
        //this.exponentSeparator = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.276 -0400", hash_original_method = "AC413B5955CC7818D3CB585AD477DBD8", hash_generated_method = "5DBF2FA3EFC5A80179D08EE97BC25336")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream stream) throws IOException {
        dsTaint.addTaint(stream.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.276 -0400", hash_original_method = "6B45962B37C777732BB6D07E7138D37B", hash_generated_method = "4138537880C9A72ED74369AFF62CD05E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(stream.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static final long serialVersionUID = 5772796243397350300L;
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

