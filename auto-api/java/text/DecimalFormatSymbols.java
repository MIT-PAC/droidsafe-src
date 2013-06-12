package java.text;

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
import java.util.Currency;
import java.util.Locale;
import libcore.icu.ICU;
import libcore.icu.LocaleData;

public class DecimalFormatSymbols implements Cloneable, Serializable {
    private static final long serialVersionUID = 5772796243397350300L;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.094 -0400", hash_original_method = "91524EB1B511A6593A9E4C16AA4F2798", hash_generated_method = "5AC3097117AC9E79EEC04D08FE2CBAA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DecimalFormatSymbols() {
        this(Locale.getDefault());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.094 -0400", hash_original_method = "0AEA27B26006219100D92BC0021E5648", hash_generated_method = "F2AC513E3CB2871641FBF2298BA0AABE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.094 -0400", hash_original_method = "A20804536D1BB58CF64F5D4344E1058E", hash_generated_method = "A0E365D64745B645D76306204BE1E035")
    public static DecimalFormatSymbols getInstance() {
        return getInstance(Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.094 -0400", hash_original_method = "AAE245E8122356AE5E986468622585C0", hash_generated_method = "B356C861F459952B5AA0BDB0997162C9")
    public static DecimalFormatSymbols getInstance(Locale locale) {
        if (locale == null) {
            throw new NullPointerException();
        }
        return new DecimalFormatSymbols(locale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.094 -0400", hash_original_method = "623079C002E398EE5B17BE6978E7428C", hash_generated_method = "01AF92D5F3A729A167059F795E08D11C")
    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableDecimalFormatSymbolsLocales();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.094 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "7FC57DD37327E28F6D8E5D0E16E2DC95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        try 
        {
            Object varDEB570B566DA7549E2F197D0AFA5A2B6_1791487219 = (super.clone());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.095 -0400", hash_original_method = "B3296A7E858EAC27CB28889E1F7A56D1", hash_generated_method = "C9C230204F82207CE3ED91B2D295BF1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        DecimalFormatSymbols obj;
        obj = (DecimalFormatSymbols) object;
        boolean varC158CC4243FB554C90CC017AB48211C2_158525452 = (currency.equals(obj.currency) &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.095 -0400", hash_original_method = "A8625956386363E3EFDBA37B24F1F247", hash_generated_method = "E0D145843894E0BCB73D4C5A73237353")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varA8FD58D00DF2FE04003DDA0387EED1A1_543832036 = (getClass().getName() +
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.095 -0400", hash_original_method = "595F433D4A540AB9FD57454DFC2D00CA", hash_generated_method = "A6F85F7ADE73B51271698E2BFC7D8FC5")
    @DSModeled(DSC.SAFE)
    public Currency getCurrency() {
        return (Currency)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return currency;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.095 -0400", hash_original_method = "9A7223B2A10801087A5753E160EB5AD9", hash_generated_method = "08820E05CAFD5BFF8759A0EC5E65C86D")
    @DSModeled(DSC.SAFE)
    public String getInternationalCurrencySymbol() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return intlCurrencySymbol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.095 -0400", hash_original_method = "44BA6DF186734A9129EE433C5393A649", hash_generated_method = "A8AD110DB2EF6D3993FFFC5BA4FC15DE")
    @DSModeled(DSC.SAFE)
    public String getCurrencySymbol() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return currencySymbol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.095 -0400", hash_original_method = "C908C2BC77C07C5C3074706ADD440EBB", hash_generated_method = "196B29A8FAED29C79AFBEA26D3180D54")
    @DSModeled(DSC.SAFE)
    public char getDecimalSeparator() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return decimalSeparator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.095 -0400", hash_original_method = "4E80424FBB82914FDC63C744E843DFA5", hash_generated_method = "5005DEE63D8D1CE9BAA85E2AF595A282")
    @DSModeled(DSC.SAFE)
    public char getDigit() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return digit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.095 -0400", hash_original_method = "0D8DAB63E4E740341CDDC10B95F6771D", hash_generated_method = "14B137D7DBE60D6538AEA8E2376696B9")
    @DSModeled(DSC.SAFE)
    public char getGroupingSeparator() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return groupingSeparator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.095 -0400", hash_original_method = "195513F858098AF1B8C98F122DD853CE", hash_generated_method = "BFEFE51A24B0C91709B147925E6189AF")
    @DSModeled(DSC.SAFE)
    public String getInfinity() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return infinity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.096 -0400", hash_original_method = "B02DD985FFD3C706D5501C97C0FC9E68", hash_generated_method = "45DA2F56E53E9D21C464A8C2BB486BCA")
    @DSModeled(DSC.SAFE)
    public char getMinusSign() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return minusSign;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.096 -0400", hash_original_method = "C02AEBD6916CB8991D4B6D1CCA4BA867", hash_generated_method = "D05CD5CA5467B87C72D6DC33333E251D")
    @DSModeled(DSC.SAFE)
    public char getMonetaryDecimalSeparator() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return monetarySeparator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.096 -0400", hash_original_method = "A7A5B5565C9E586C08E861055D3F830D", hash_generated_method = "6A665F5326A9EA6A8C5AFC7218E585BF")
    @DSModeled(DSC.SAFE)
    public String getNaN() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return NaN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.096 -0400", hash_original_method = "D38F7AE8E1369570AEDB785398752C04", hash_generated_method = "7C434A26E591B9C49F95B1A73D9626A6")
    @DSModeled(DSC.SAFE)
    public char getPatternSeparator() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return patternSeparator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.096 -0400", hash_original_method = "0F05A385A7483224A3B3B115F4941DEA", hash_generated_method = "10703B857491E5B1B448B9BE6575C850")
    @DSModeled(DSC.SAFE)
    public char getPercent() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return percent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.096 -0400", hash_original_method = "DDC83740D050E65F948D715CA46AA4E6", hash_generated_method = "5F0AB7936F8428459961859FD04EFAB0")
    @DSModeled(DSC.SAFE)
    public char getPerMill() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return perMill;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.096 -0400", hash_original_method = "5E609E25361E12310E119A02851AA08C", hash_generated_method = "3B255FF2E76D4A0A8CFEBBB1821BD966")
    @DSModeled(DSC.SAFE)
    public char getZeroDigit() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return zeroDigit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.096 -0400", hash_original_method = "819A49232B9C4BF84239DF8CB1CAA3C1", hash_generated_method = "75CFB6BD3A16063AA01B3782E4412FF8")
    @DSModeled(DSC.SAFE)
    public String getExponentSeparator() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return exponentSeparator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.096 -0400", hash_original_method = "730AF15AAE06AD4A292A18D5EB73C960", hash_generated_method = "BAB3F73CFF9234CB1E44DE44EAA46FAD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.096 -0400", hash_original_method = "92D5537D8B3843A17694170BBEA5586B", hash_generated_method = "D6D7B0942072A478A6212B2F13753D63")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.096 -0400", hash_original_method = "207176AE532CCEDF88793D675BD5BB7E", hash_generated_method = "24A66A03FED371D125CECB3512091CDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setInternationalCurrencySymbol(String value) {
        dsTaint.addTaint(value);
        {
            currency = null;
            intlCurrencySymbol = null;
        } //End block
        {
            boolean var8EB9949666341D3A42DA12AD2DEE9D4F_435211651 = (value.equals(intlCurrencySymbol));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.096 -0400", hash_original_method = "29E8104D01D46C7E9FE837881A4B811D", hash_generated_method = "AD1433EE186CA57B85123D728CF48A93")
    @DSModeled(DSC.SAFE)
    public void setCurrencySymbol(String value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.currencySymbol = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.097 -0400", hash_original_method = "9AC8CCC4F998C35713D40EA8501A574C", hash_generated_method = "A3940A7BC22E922A210E55FF5FE0BE3A")
    @DSModeled(DSC.SAFE)
    public void setDecimalSeparator(char value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.decimalSeparator = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.097 -0400", hash_original_method = "D6FAF1D38DB7E623F52AE4E3C83BC924", hash_generated_method = "974A2319E408CF31AA005F010D653545")
    @DSModeled(DSC.SAFE)
    public void setDigit(char value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.digit = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.097 -0400", hash_original_method = "9D270588D20ED0589BF78FE9A748D06B", hash_generated_method = "088D78A578D87EA63180CEE8840563F3")
    @DSModeled(DSC.SAFE)
    public void setGroupingSeparator(char value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.groupingSeparator = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.097 -0400", hash_original_method = "253C85BF9C056E30DB4FF21631672E45", hash_generated_method = "3A8244EFF6E07581A0C3EB16B9DBFCC5")
    @DSModeled(DSC.SAFE)
    public void setInfinity(String value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.infinity = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.097 -0400", hash_original_method = "D3F4D7B2767531D5CB8D7EDFAA19A0F0", hash_generated_method = "98D18113A6276A0B956D24803C0A528B")
    @DSModeled(DSC.SAFE)
    public void setMinusSign(char value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.minusSign = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.097 -0400", hash_original_method = "5DC5988EDD7C3CC1FE974B80FD913370", hash_generated_method = "05E4A733B5DD463631916689A11A9B89")
    @DSModeled(DSC.SAFE)
    public void setMonetaryDecimalSeparator(char value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.monetarySeparator = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.097 -0400", hash_original_method = "6A48D24176C36753AA1CCB849BDA297D", hash_generated_method = "3980700C2B97BB2085D37E13EFE68A64")
    @DSModeled(DSC.SAFE)
    public void setNaN(String value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.NaN = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.097 -0400", hash_original_method = "F9CB88FF85D83DD076D59F9C65C2F022", hash_generated_method = "EE98EB6033116941EB4BDC264F2A036A")
    @DSModeled(DSC.SAFE)
    public void setPatternSeparator(char value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.patternSeparator = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.097 -0400", hash_original_method = "82CC4266781153E2E37AE97635E76BF7", hash_generated_method = "3EE5B2E93871189C4CF753249B13822F")
    @DSModeled(DSC.SAFE)
    public void setPercent(char value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.percent = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.097 -0400", hash_original_method = "A113C8FE00852B00BE817507D877FFEC", hash_generated_method = "7ECDCAA7E50A2EEF9471FF0326EEA6EA")
    @DSModeled(DSC.SAFE)
    public void setPerMill(char value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.perMill = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.097 -0400", hash_original_method = "1F31C9A94279CEAA9BC58336D0C15AE7", hash_generated_method = "5A5E49AC736B9C0D4E012A74DC43BDFC")
    @DSModeled(DSC.SAFE)
    public void setZeroDigit(char value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.zeroDigit = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.097 -0400", hash_original_method = "9B9F6C7BB1C5EA5DED0636F1E4439683", hash_generated_method = "5008D6CED74804CC5C3916DEC309CC1A")
    @DSModeled(DSC.SAFE)
    public void setExponentSeparator(String value) {
        dsTaint.addTaint(value);
        {
            throw new NullPointerException();
        } //End block
        // ---------- Original Method ----------
        //if (value == null) {
            //throw new NullPointerException();
        //}
        //this.exponentSeparator = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.097 -0400", hash_original_method = "AC413B5955CC7818D3CB585AD477DBD8", hash_generated_method = "E48710F70BEFB26DAE249FC41F84031B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.098 -0400", hash_original_method = "6B45962B37C777732BB6D07E7138D37B", hash_generated_method = "233ABE207BB31B999CC19344F95038CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(stream.dsTaint);
        ObjectInputStream.GetField fields;
        fields = stream.readFields();
        final int serialVersionOnStream;
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

    
}


