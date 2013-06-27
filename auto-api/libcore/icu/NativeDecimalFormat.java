package libcore.icu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Currency;
import java.util.NoSuchElementException;

public final class NativeDecimalFormat {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.128 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "849BAB492558B51E7BC4F1C331A435E4")

    private int address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.128 -0400", hash_original_field = "344BCC24F3464715940DD56604C8D74D", hash_generated_field = "5F7D5D3D7F66CE031779F4BACE74C549")

    private String lastPattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.128 -0400", hash_original_field = "FE0C344D27B5DDD52EE172F18436517A", hash_generated_field = "A56A7DCB118482C05DDF4AEBE99FDB15")

    private boolean negPrefNull;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.128 -0400", hash_original_field = "847370D067A7C3F3858025EC1AE68504", hash_generated_field = "2505E1D75E0C167EE76E4EF5DDA36BE9")

    private boolean negSuffNull;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.128 -0400", hash_original_field = "61EA484D190CD4F0A57205D48CFCE039", hash_generated_field = "CDAAA116F4BD28B5162A921B2B1BA25F")

    private boolean posPrefNull;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.128 -0400", hash_original_field = "C30F6031C7DF0B30F08B2845ADE90423", hash_generated_field = "E9F9066E16BD9AB176D3C016B62231F0")

    private boolean posSuffNull;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.128 -0400", hash_original_field = "287D1050A38F78BCF10BE8BDFB1C701E", hash_generated_field = "622CB2D56C22AE9A04568955FFFF4B33")

    private transient boolean parseBigDecimal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.129 -0400", hash_original_field = "EBBDEA416E09F573B73D6D6E43EF5083", hash_generated_field = "C24355A01F90DF3021CC166940F4BB14")

    private BigDecimal multiplierBigDecimal = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.129 -0400", hash_original_method = "D8AEBC26DB4CF2E0C933D0F5B84F659E", hash_generated_method = "A534F428BF436EFFCF7D5C20409BC3AD")
    public  NativeDecimalFormat(String pattern, DecimalFormatSymbols dfs) {
        try 
        {
            this.address = open(pattern, dfs.getCurrencySymbol(),
                    dfs.getDecimalSeparator(), dfs.getDigit(), dfs.getExponentSeparator(),
                    dfs.getGroupingSeparator(), dfs.getInfinity(),
                    dfs.getInternationalCurrencySymbol(), dfs.getMinusSign(),
                    dfs.getMonetaryDecimalSeparator(), dfs.getNaN(), dfs.getPatternSeparator(),
                    dfs.getPercent(), dfs.getPerMill(), dfs.getZeroDigit());
            this.lastPattern = pattern;
        } //End block
        catch (NullPointerException npe)
        {
            if (DroidSafeAndroidRuntime.control) throw npe;
        } //End block
        catch (RuntimeException re)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("syntax error: " + re.getMessage() + ": " + pattern);
        } //End block
        // ---------- Original Method ----------
        //try {
            //this.address = open(pattern, dfs.getCurrencySymbol(),
                    //dfs.getDecimalSeparator(), dfs.getDigit(), dfs.getExponentSeparator(),
                    //dfs.getGroupingSeparator(), dfs.getInfinity(),
                    //dfs.getInternationalCurrencySymbol(), dfs.getMinusSign(),
                    //dfs.getMonetaryDecimalSeparator(), dfs.getNaN(), dfs.getPatternSeparator(),
                    //dfs.getPercent(), dfs.getPerMill(), dfs.getZeroDigit());
            //this.lastPattern = pattern;
        //} catch (NullPointerException npe) {
            //throw npe;
        //} catch (RuntimeException re) {
            //throw new IllegalArgumentException("syntax error: " + re.getMessage() + ": " + pattern);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.139 -0400", hash_original_method = "03415942CECEA3C928FA024ACF038523", hash_generated_method = "D2E674819D4F909C96BFFA4F1D82A4EF")
    public  NativeDecimalFormat(String pattern, LocaleData data) {
        this.address = open(pattern, data.currencySymbol,
                data.decimalSeparator, '#', data.exponentSeparator, data.groupingSeparator,
                data.infinity, data.internationalCurrencySymbol, data.minusSign,
                data.monetarySeparator, data.NaN, data.patternSeparator,
                data.percent, data.perMill, data.zeroDigit);
        this.lastPattern = pattern;
        // ---------- Original Method ----------
        //this.address = open(pattern, data.currencySymbol,
                //data.decimalSeparator, '#', data.exponentSeparator, data.groupingSeparator,
                //data.infinity, data.internationalCurrencySymbol, data.minusSign,
                //data.monetarySeparator, data.NaN, data.patternSeparator,
                //data.percent, data.perMill, data.zeroDigit);
        //this.lastPattern = pattern;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.139 -0400", hash_original_method = "F2FB63D256AD622AD0AA1906E5944DB2", hash_generated_method = "5AAFFDF8705B718E89082099B750E33B")
    private  NativeDecimalFormat(NativeDecimalFormat other) {
        this.address = cloneImpl(other.address);
        this.lastPattern = other.lastPattern;
        this.negPrefNull = other.negPrefNull;
        this.negSuffNull = other.negSuffNull;
        this.posPrefNull = other.posPrefNull;
        this.posSuffNull = other.posSuffNull;
        // ---------- Original Method ----------
        //this.address = cloneImpl(other.address);
        //this.lastPattern = other.lastPattern;
        //this.negPrefNull = other.negPrefNull;
        //this.negSuffNull = other.negSuffNull;
        //this.posPrefNull = other.posPrefNull;
        //this.posSuffNull = other.posSuffNull;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.140 -0400", hash_original_method = "C197288C8DD3954567266901B60BE5B8", hash_generated_method = "6EC15A417C5455A602118D23BD3C9745")
    @Override
    public int hashCode() {
        int var8C9A345D8B4C41F5F6C3E9546CE693DB_721375589 = (this.getPositivePrefix().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1858698045 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1858698045;
        // ---------- Original Method ----------
        //return this.getPositivePrefix().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.140 -0400", hash_original_method = "5C171A463B7BB08FCE40648C7CE8F861", hash_generated_method = "36CAD6210CFA016FE9122A2E563AE993")
    public synchronized void close() {
        {
            close(address);
            address = 0;
        } //End block
        // ---------- Original Method ----------
        //if (address != 0) {
            //close(address);
            //address = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.141 -0400", hash_original_method = "D252F6FD4E111780C248C256B2516FF2", hash_generated_method = "D479660DDBA2DC5E41B0486C3FC288D7")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_725333207 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_725333207 = new NativeDecimalFormat(this);
        varB4EAC82CA7396A68D541C85D26508E83_725333207.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_725333207;
        // ---------- Original Method ----------
        //return new NativeDecimalFormat(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.150 -0400", hash_original_method = "220130DBC584D5B5D45771D972950D18", hash_generated_method = "94E3BF1E124F51393136690F414D8EAE")
    @Override
    public boolean equals(Object object) {
        {
            boolean var3F549205D4C262003697A031F89E5954_540011783 = (object == this);
        } //End collapsed parenthetic
        NativeDecimalFormat obj;
        obj = (NativeDecimalFormat) object;
        boolean var18FBB52F731808A4077D23FDD981869A_660249370 = (obj.toPattern().equals(this.toPattern()) &&
                obj.isDecimalSeparatorAlwaysShown() == this.isDecimalSeparatorAlwaysShown() &&
                obj.getGroupingSize() == this.getGroupingSize() &&
                obj.getMultiplier() == this.getMultiplier() &&
                obj.getNegativePrefix().equals(this.getNegativePrefix()) &&
                obj.getNegativeSuffix().equals(this.getNegativeSuffix()) &&
                obj.getPositivePrefix().equals(this.getPositivePrefix()) &&
                obj.getPositiveSuffix().equals(this.getPositiveSuffix()) &&
                obj.getMaximumIntegerDigits() == this.getMaximumIntegerDigits() &&
                obj.getMaximumFractionDigits() == this.getMaximumFractionDigits() &&
                obj.getMinimumIntegerDigits() == this.getMinimumIntegerDigits() &&
                obj.getMinimumFractionDigits() == this.getMinimumFractionDigits() &&
                obj.isGroupingUsed() == this.isGroupingUsed());
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_224437734 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_224437734;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.151 -0400", hash_original_method = "6B8DF144F51335DB9B33B1BD0598F087", hash_generated_method = "F50D865A25252BAB9C1E1E1C12F08C9E")
    public void setDecimalFormatSymbols(final DecimalFormatSymbols dfs) {
        setDecimalFormatSymbols(this.address, dfs.getCurrencySymbol(), dfs.getDecimalSeparator(),
                dfs.getDigit(), dfs.getExponentSeparator(), dfs.getGroupingSeparator(),
                dfs.getInfinity(), dfs.getInternationalCurrencySymbol(), dfs.getMinusSign(),
                dfs.getMonetaryDecimalSeparator(), dfs.getNaN(), dfs.getPatternSeparator(),
                dfs.getPercent(), dfs.getPerMill(), dfs.getZeroDigit());
        addTaint(dfs.getTaint());
        // ---------- Original Method ----------
        //setDecimalFormatSymbols(this.address, dfs.getCurrencySymbol(), dfs.getDecimalSeparator(),
                //dfs.getDigit(), dfs.getExponentSeparator(), dfs.getGroupingSeparator(),
                //dfs.getInfinity(), dfs.getInternationalCurrencySymbol(), dfs.getMinusSign(),
                //dfs.getMonetaryDecimalSeparator(), dfs.getNaN(), dfs.getPatternSeparator(),
                //dfs.getPercent(), dfs.getPerMill(), dfs.getZeroDigit());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.151 -0400", hash_original_method = "5FE0177EB5130C508ECEC468A64D96E3", hash_generated_method = "8EF61A24B2109F9772578EEB2CC2CBE1")
    public void setDecimalFormatSymbols(final LocaleData localeData) {
        setDecimalFormatSymbols(this.address, localeData.currencySymbol, localeData.decimalSeparator,
                '#', localeData.exponentSeparator, localeData.groupingSeparator,
                localeData.infinity, localeData.internationalCurrencySymbol, localeData.minusSign,
                localeData.monetarySeparator, localeData.NaN, localeData.patternSeparator,
                localeData.percent, localeData.perMill, localeData.zeroDigit);
        addTaint(localeData.getTaint());
        // ---------- Original Method ----------
        //setDecimalFormatSymbols(this.address, localeData.currencySymbol, localeData.decimalSeparator,
                //'#', localeData.exponentSeparator, localeData.groupingSeparator,
                //localeData.infinity, localeData.internationalCurrencySymbol, localeData.minusSign,
                //localeData.monetarySeparator, localeData.NaN, localeData.patternSeparator,
                //localeData.percent, localeData.perMill, localeData.zeroDigit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.152 -0400", hash_original_method = "E3DC36059DBEEA918EB4DAC2E3F69056", hash_generated_method = "09AC45A2EC3E62BED1DC8BD6DFBFBA41")
    public char[] formatBigDecimal(BigDecimal value, FieldPosition field) {
        FieldPositionIterator fpi;
        fpi = FieldPositionIterator.forFieldPosition(field);
        char[] result;
        result = formatDigitList(this.address, value.toString(), fpi);
        {
            FieldPositionIterator.setFieldPosition(fpi, field);
        } //End block
        addTaint(value.getTaint());
        addTaint(field.getTaint());
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1220677835 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1220677835;
        // ---------- Original Method ----------
        //FieldPositionIterator fpi = FieldPositionIterator.forFieldPosition(field);
        //char[] result = formatDigitList(this.address, value.toString(), fpi);
        //if (fpi != null) {
            //FieldPositionIterator.setFieldPosition(fpi, field);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.152 -0400", hash_original_method = "AB58B0DEED1650663505F868BCDB9A76", hash_generated_method = "F5C2A14BA162AB480E6218AE608916C5")
    public char[] formatBigInteger(BigInteger value, FieldPosition field) {
        FieldPositionIterator fpi;
        fpi = FieldPositionIterator.forFieldPosition(field);
        char[] result;
        result = formatDigitList(this.address, value.toString(10), fpi);
        {
            FieldPositionIterator.setFieldPosition(fpi, field);
        } //End block
        addTaint(value.getTaint());
        addTaint(field.getTaint());
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_501504787 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_501504787;
        // ---------- Original Method ----------
        //FieldPositionIterator fpi = FieldPositionIterator.forFieldPosition(field);
        //char[] result = formatDigitList(this.address, value.toString(10), fpi);
        //if (fpi != null) {
            //FieldPositionIterator.setFieldPosition(fpi, field);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.152 -0400", hash_original_method = "E280C21CEDC9C41E32AB3781E6354849", hash_generated_method = "81FCA76FE9E0F8B052E42E5E77522DEF")
    public char[] formatLong(long value, FieldPosition field) {
        FieldPositionIterator fpi;
        fpi = FieldPositionIterator.forFieldPosition(field);
        char[] result;
        result = formatLong(this.address, value, fpi);
        {
            FieldPositionIterator.setFieldPosition(fpi, field);
        } //End block
        addTaint(value);
        addTaint(field.getTaint());
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_2086212065 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_2086212065;
        // ---------- Original Method ----------
        //FieldPositionIterator fpi = FieldPositionIterator.forFieldPosition(field);
        //char[] result = formatLong(this.address, value, fpi);
        //if (fpi != null) {
            //FieldPositionIterator.setFieldPosition(fpi, field);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.153 -0400", hash_original_method = "2B822D9FBF334F04026E765F63D8EA7D", hash_generated_method = "5B9558C7AF2AF15A0D2A2BE1651E5B6A")
    public char[] formatDouble(double value, FieldPosition field) {
        FieldPositionIterator fpi;
        fpi = FieldPositionIterator.forFieldPosition(field);
        char[] result;
        result = formatDouble(this.address, value, fpi);
        {
            FieldPositionIterator.setFieldPosition(fpi, field);
        } //End block
        addTaint(value);
        addTaint(field.getTaint());
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_769058830 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_769058830;
        // ---------- Original Method ----------
        //FieldPositionIterator fpi = FieldPositionIterator.forFieldPosition(field);
        //char[] result = formatDouble(this.address, value, fpi);
        //if (fpi != null) {
            //FieldPositionIterator.setFieldPosition(fpi, field);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.154 -0400", hash_original_method = "521D68694A0F2FF9FD004D1F044248B6", hash_generated_method = "626CB7EAC0C2AC2D31677753DB78F3D3")
    public void applyLocalizedPattern(String pattern) {
        applyPattern(this.address, true, pattern);
        lastPattern = null;
        addTaint(pattern.getTaint());
        // ---------- Original Method ----------
        //applyPattern(this.address, true, pattern);
        //lastPattern = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.154 -0400", hash_original_method = "105E6A8350C3ECD2CBDC93E6E74AA17C", hash_generated_method = "C95D3613F38FB7944530534A1CFE0D08")
    public void applyPattern(String pattern) {
        {
            boolean var30056E56F7633573B6C2DD284E929162_1893171539 = (lastPattern != null && pattern.equals(lastPattern));
        } //End collapsed parenthetic
        applyPattern(this.address, false, pattern);
        lastPattern = pattern;
        // ---------- Original Method ----------
        //if (lastPattern != null && pattern.equals(lastPattern)) {
            //return;
        //}
        //applyPattern(this.address, false, pattern);
        //lastPattern = pattern;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.155 -0400", hash_original_method = "9FEF3AE5E61C347D525A9585FBE19ECF", hash_generated_method = "77FB0BCDE3F6FCB31EDFB775D66C5F6B")
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        AttributedCharacterIterator varB4EAC82CA7396A68D541C85D26508E83_705488981 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        Number number;
        number = (Number) object;
        FieldPositionIterator fpIter;
        fpIter = new FieldPositionIterator();
        String text;
        {
            text = new String(formatDigitList(this.address, number.toString(), fpIter));
        } //End block
        {
            double dv;
            dv = number.doubleValue();
            text = new String(formatDouble(this.address, dv, fpIter));
        } //End block
        {
            long lv;
            lv = number.longValue();
            text = new String(formatLong(this.address, lv, fpIter));
        } //End block
        AttributedString as;
        as = new AttributedString(text);
        {
            boolean varC94C796D691F3725A70F62B7F781E92F_1046275437 = (fpIter.next());
            {
                Format.Field field;
                field = fpIter.field();
                as.addAttribute(field, field, fpIter.start(), fpIter.limit());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_705488981 = as.getIterator();
        addTaint(object.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_705488981.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_705488981;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.156 -0400", hash_original_method = "E9B105AB178BFBFEB280AF82F381CE84", hash_generated_method = "7255795CBA987F67FB5ECA450112C031")
    private int makeScalePositive(int scale, StringBuilder val) {
        {
            scale = -scale;
            {
                int i;
                i = scale;
                {
                    val.append('0');
                } //End block
            } //End collapsed parenthetic
            scale = 0;
        } //End block
        addTaint(scale);
        addTaint(val.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1391338342 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1391338342;
        // ---------- Original Method ----------
        //if (scale < 0) {
            //scale = -scale;
            //for (int i = scale; i > 0; i--) {
                //val.append('0');
            //}
            //scale = 0;
        //}
        //return scale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.165 -0400", hash_original_method = "1F42A3AAFB142AE620B1A14F6DE6CCC5", hash_generated_method = "E1DBE943DA1ED46A1E988984B88E126F")
    public String toLocalizedPattern() {
        String varB4EAC82CA7396A68D541C85D26508E83_955686163 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_955686163 = toPatternImpl(this.address, true);
        varB4EAC82CA7396A68D541C85D26508E83_955686163.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_955686163;
        // ---------- Original Method ----------
        //return toPatternImpl(this.address, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.165 -0400", hash_original_method = "D90F2C106608034D601A7F076DF301BD", hash_generated_method = "3C6B8DDF591381BBA2EC7954DE09CD97")
    public String toPattern() {
        String varB4EAC82CA7396A68D541C85D26508E83_1693284830 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1693284830 = toPatternImpl(this.address, false);
        varB4EAC82CA7396A68D541C85D26508E83_1693284830.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1693284830;
        // ---------- Original Method ----------
        //return toPatternImpl(this.address, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.165 -0400", hash_original_method = "C24C75386265F50BCF75B046D9BE3ACC", hash_generated_method = "3C354444968CDBD7FA74F25188D5E5A8")
    public Number parse(String string, ParsePosition position) {
        Number varB4EAC82CA7396A68D541C85D26508E83_1563702204 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1563702204 = parse(address, string, position, parseBigDecimal);
        addTaint(string.getTaint());
        addTaint(position.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1563702204.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1563702204;
        // ---------- Original Method ----------
        //return parse(address, string, position, parseBigDecimal);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.166 -0400", hash_original_method = "00B4402833BBD0AA4B8B3DAC69045BF5", hash_generated_method = "3EE80F52889A37A1C20B535966925FAD")
    public int getMaximumFractionDigits() {
        int var2031882FA64042FA8714F056BC326B77_1029112651 = (getAttribute(this.address, UNUM_MAX_FRACTION_DIGITS));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1325658397 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1325658397;
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_MAX_FRACTION_DIGITS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.166 -0400", hash_original_method = "39458F699020062C4A2A7E5A13FEC803", hash_generated_method = "1C4D805CABBEF0A4F4520D63C544F732")
    public int getMaximumIntegerDigits() {
        int var552BC4AA7CD66CB5C86DC39DD6F5EB61_1682157807 = (getAttribute(this.address, UNUM_MAX_INTEGER_DIGITS));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1938907797 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1938907797;
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_MAX_INTEGER_DIGITS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.166 -0400", hash_original_method = "2493C2169723FB0932E2841ED5413767", hash_generated_method = "7C8B4206FDBAF6C26A623CC827C231C7")
    public int getMinimumFractionDigits() {
        int var651D9F7029A8FF147A685A36D32AA845_1986355218 = (getAttribute(this.address, UNUM_MIN_FRACTION_DIGITS));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1939517440 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1939517440;
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_MIN_FRACTION_DIGITS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.166 -0400", hash_original_method = "C287E89D9CA249987BAB41DA58A603BE", hash_generated_method = "5D5143A92A55C01ECE4EE34E1EBA5CE4")
    public int getMinimumIntegerDigits() {
        int varE7531A98F2A0AD2779754CD1B2865E0B_217735051 = (getAttribute(this.address, UNUM_MIN_INTEGER_DIGITS));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1943043760 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1943043760;
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_MIN_INTEGER_DIGITS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.167 -0400", hash_original_method = "C63E831A66DAEA25345E39BD0E8C902A", hash_generated_method = "0ED2AA64C4A3F933912A9586A1E5FC07")
    public int getGroupingSize() {
        int varEBCCDDFF415DDB22660365F0FC4A83FC_2067168730 = (getAttribute(this.address, UNUM_GROUPING_SIZE));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_17161102 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_17161102;
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_GROUPING_SIZE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.167 -0400", hash_original_method = "195B15A30ECFDD2DA316EFD7F1135C74", hash_generated_method = "58F017D76C4AC86D0357F0DF96DD5BDF")
    public int getMultiplier() {
        int var2028C5EE807D8F87AD09F7ADE0783DF7_616533348 = (getAttribute(this.address, UNUM_MULTIPLIER));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1036689218 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1036689218;
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_MULTIPLIER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.167 -0400", hash_original_method = "6BE8F2BF8B3A5604EA6D6E250F279823", hash_generated_method = "6B31E44CEE7A0A408889426770DC4BE0")
    public String getNegativePrefix() {
        String varB4EAC82CA7396A68D541C85D26508E83_402125721 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1312703980 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_402125721 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1312703980 = getTextAttribute(this.address, UNUM_NEGATIVE_PREFIX);
        String varA7E53CE21691AB073D9660D615818899_1069092888; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1069092888 = varB4EAC82CA7396A68D541C85D26508E83_402125721;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1069092888 = varB4EAC82CA7396A68D541C85D26508E83_1312703980;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1069092888.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1069092888;
        // ---------- Original Method ----------
        //if (negPrefNull) {
            //return null;
        //}
        //return getTextAttribute(this.address, UNUM_NEGATIVE_PREFIX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.178 -0400", hash_original_method = "3B3EF8E26C12E3D51B48D0C30732D5F5", hash_generated_method = "C0A5C3155EE9D71081043F435935DC28")
    public String getNegativeSuffix() {
        String varB4EAC82CA7396A68D541C85D26508E83_816121372 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_152073313 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_816121372 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_152073313 = getTextAttribute(this.address, UNUM_NEGATIVE_SUFFIX);
        String varA7E53CE21691AB073D9660D615818899_1436985113; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1436985113 = varB4EAC82CA7396A68D541C85D26508E83_816121372;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1436985113 = varB4EAC82CA7396A68D541C85D26508E83_152073313;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1436985113.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1436985113;
        // ---------- Original Method ----------
        //if (negSuffNull) {
            //return null;
        //}
        //return getTextAttribute(this.address, UNUM_NEGATIVE_SUFFIX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.179 -0400", hash_original_method = "8D4D6B90A746E09AE36173ABA0AB4B15", hash_generated_method = "AD70AB2965F0DB7393A5B1A84AEAB822")
    public String getPositivePrefix() {
        String varB4EAC82CA7396A68D541C85D26508E83_430131450 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_190122277 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_430131450 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_190122277 = getTextAttribute(this.address, UNUM_POSITIVE_PREFIX);
        String varA7E53CE21691AB073D9660D615818899_71297264; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_71297264 = varB4EAC82CA7396A68D541C85D26508E83_430131450;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_71297264 = varB4EAC82CA7396A68D541C85D26508E83_190122277;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_71297264.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_71297264;
        // ---------- Original Method ----------
        //if (posPrefNull) {
            //return null;
        //}
        //return getTextAttribute(this.address, UNUM_POSITIVE_PREFIX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.181 -0400", hash_original_method = "6CFE84E5B71B94B0DE7447BA68FEA246", hash_generated_method = "394CA0EE58EE1A75ABBA317BDFCEF82A")
    public String getPositiveSuffix() {
        String varB4EAC82CA7396A68D541C85D26508E83_247432190 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_102651099 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_247432190 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_102651099 = getTextAttribute(this.address, UNUM_POSITIVE_SUFFIX);
        String varA7E53CE21691AB073D9660D615818899_983261119; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_983261119 = varB4EAC82CA7396A68D541C85D26508E83_247432190;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_983261119 = varB4EAC82CA7396A68D541C85D26508E83_102651099;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_983261119.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_983261119;
        // ---------- Original Method ----------
        //if (posSuffNull) {
            //return null;
        //}
        //return getTextAttribute(this.address, UNUM_POSITIVE_SUFFIX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.181 -0400", hash_original_method = "F9B59ECC893A5B014F6155ABE9703BF1", hash_generated_method = "5EA5D1FBBB6152BD12C656D985F62858")
    public boolean isDecimalSeparatorAlwaysShown() {
        boolean var3E4313CD429F3F78E13F34D688881F5E_1408233240 = (getAttribute(this.address, UNUM_DECIMAL_ALWAYS_SHOWN) != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1014091915 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1014091915;
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_DECIMAL_ALWAYS_SHOWN) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.182 -0400", hash_original_method = "84561142CC409560F18895112EB228ED", hash_generated_method = "14A5C33BC39A2A120924D64211C316B2")
    public boolean isParseBigDecimal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1279111859 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1279111859;
        // ---------- Original Method ----------
        //return parseBigDecimal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.182 -0400", hash_original_method = "1D326E5349B9E5A9AED64258AB68CB41", hash_generated_method = "2DAFA276EB9AD06B5D08AD532A0822F7")
    public boolean isParseIntegerOnly() {
        boolean var58CA17599706E2BD9D06C2CCBA6B89AB_1703272742 = (getAttribute(this.address, UNUM_PARSE_INT_ONLY) != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1259380746 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1259380746;
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_PARSE_INT_ONLY) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.183 -0400", hash_original_method = "00E8502D2DA3C0C73215E5BC5979A07C", hash_generated_method = "28AB3A186A70A72121BDA86686EC0C33")
    public boolean isGroupingUsed() {
        boolean var875BD0DB8C0EE50D68D0C6793AE8DABD_1868398175 = (getAttribute(this.address, UNUM_GROUPING_USED) != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_762307804 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_762307804;
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_GROUPING_USED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.194 -0400", hash_original_method = "4515EB7BD614742B3D0DDD5748BC74D6", hash_generated_method = "B8B0456587560093071500C9C0FCAE5E")
    public void setDecimalSeparatorAlwaysShown(boolean value) {
        int i;
        i = -1;
        i = 0;
        setAttribute(this.address, UNUM_DECIMAL_ALWAYS_SHOWN, i);
        addTaint(value);
        // ---------- Original Method ----------
        //int i = value ? -1 : 0;
        //setAttribute(this.address, UNUM_DECIMAL_ALWAYS_SHOWN, i);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.194 -0400", hash_original_method = "27959CC6793546F59976E7DBD15119DA", hash_generated_method = "E9FFB17EAD4EA0D712632E876D6C36D5")
    public void setCurrency(Currency currency) {
        setSymbol(this.address, UNUM_CURRENCY_SYMBOL, currency.getSymbol());
        setSymbol(this.address, UNUM_INTL_CURRENCY_SYMBOL, currency.getCurrencyCode());
        addTaint(currency.getTaint());
        // ---------- Original Method ----------
        //setSymbol(this.address, UNUM_CURRENCY_SYMBOL, currency.getSymbol());
        //setSymbol(this.address, UNUM_INTL_CURRENCY_SYMBOL, currency.getCurrencyCode());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.194 -0400", hash_original_method = "49FEA0DFBB56F17CB90E68E0F78CE577", hash_generated_method = "EC4442CDE4C2F319FBDABF66B7010AFB")
    public void setGroupingSize(int value) {
        setAttribute(this.address, UNUM_GROUPING_SIZE, value);
        addTaint(value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_GROUPING_SIZE, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.194 -0400", hash_original_method = "E302CDF79A67421C2D7FEEF4C305D93F", hash_generated_method = "792F56F062246284C7ECE4AAAA26AE86")
    public void setGroupingUsed(boolean value) {
        int i;
        i = -1;
        i = 0;
        setAttribute(this.address, UNUM_GROUPING_USED, i);
        addTaint(value);
        // ---------- Original Method ----------
        //int i = value ? -1 : 0;
        //setAttribute(this.address, UNUM_GROUPING_USED, i);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.195 -0400", hash_original_method = "758C6DB93C92764527C1135AD7160507", hash_generated_method = "64C5C48B47DB480798C2AFF0D3819358")
    public void setMaximumFractionDigits(int value) {
        setAttribute(this.address, UNUM_MAX_FRACTION_DIGITS, value);
        addTaint(value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_MAX_FRACTION_DIGITS, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.195 -0400", hash_original_method = "89C5389B02F633081323A23C8FB84870", hash_generated_method = "9BE9DDE05F7F7A37CB2E326D3E2123B3")
    public void setMaximumIntegerDigits(int value) {
        setAttribute(this.address, UNUM_MAX_INTEGER_DIGITS, value);
        addTaint(value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_MAX_INTEGER_DIGITS, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.195 -0400", hash_original_method = "62DF7CF1343955ADCD931CBCC029C545", hash_generated_method = "0D04383E51DB8E8945118D5D47457FCC")
    public void setMinimumFractionDigits(int value) {
        setAttribute(this.address, UNUM_MIN_FRACTION_DIGITS, value);
        addTaint(value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_MIN_FRACTION_DIGITS, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.195 -0400", hash_original_method = "5D466EF26E9A120396C63069DE20CEB4", hash_generated_method = "D0CBC6A8D932BD845AF8513FB005E1E7")
    public void setMinimumIntegerDigits(int value) {
        setAttribute(this.address, UNUM_MIN_INTEGER_DIGITS, value);
        addTaint(value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_MIN_INTEGER_DIGITS, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.196 -0400", hash_original_method = "B169BA3B31B9F8AB850C7AD451D65C7F", hash_generated_method = "09EBC652ED959626329C8BC07614B33D")
    public void setMultiplier(int value) {
        setAttribute(this.address, UNUM_MULTIPLIER, value);
        multiplierBigDecimal = BigDecimal.valueOf(value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_MULTIPLIER, value);
        //multiplierBigDecimal = BigDecimal.valueOf(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.197 -0400", hash_original_method = "74BB5921C2CC61F7BCF8D1B8841FD51E", hash_generated_method = "C4DAAC223C73D5280FF1AECBB891C728")
    public void setNegativePrefix(String value) {
        negPrefNull = value == null;
        {
            setTextAttribute(this.address, UNUM_NEGATIVE_PREFIX, value);
        } //End block
        // ---------- Original Method ----------
        //negPrefNull = value == null;
        //if (!negPrefNull) {
            //setTextAttribute(this.address, UNUM_NEGATIVE_PREFIX, value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.197 -0400", hash_original_method = "0FF0A51DFB17D23D2B0F182081F1472B", hash_generated_method = "79F6037D750EDFA1DC0ED4FD3C7377C7")
    public void setNegativeSuffix(String value) {
        negSuffNull = value == null;
        {
            setTextAttribute(this.address, UNUM_NEGATIVE_SUFFIX, value);
        } //End block
        // ---------- Original Method ----------
        //negSuffNull = value == null;
        //if (!negSuffNull) {
            //setTextAttribute(this.address, UNUM_NEGATIVE_SUFFIX, value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.197 -0400", hash_original_method = "FC20737C410620F82F4CED74F1142CF3", hash_generated_method = "7C1C2C38F30484A1BDBFC4383517B9CA")
    public void setPositivePrefix(String value) {
        posPrefNull = value == null;
        {
            setTextAttribute(this.address, UNUM_POSITIVE_PREFIX, value);
        } //End block
        // ---------- Original Method ----------
        //posPrefNull = value == null;
        //if (!posPrefNull) {
            //setTextAttribute(this.address, UNUM_POSITIVE_PREFIX, value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.209 -0400", hash_original_method = "48A175BA83D370BA86128EC6BAC61CB5", hash_generated_method = "132EBBDC2763FE4573B3F9983677074F")
    public void setPositiveSuffix(String value) {
        posSuffNull = value == null;
        {
            setTextAttribute(this.address, UNUM_POSITIVE_SUFFIX, value);
        } //End block
        // ---------- Original Method ----------
        //posSuffNull = value == null;
        //if (!posSuffNull) {
            //setTextAttribute(this.address, UNUM_POSITIVE_SUFFIX, value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.209 -0400", hash_original_method = "16B3A7386DF3851CB73D32D9A838D98B", hash_generated_method = "A04CC31A40B62965DB9042EEB28F4644")
    public void setParseBigDecimal(boolean value) {
        parseBigDecimal = value;
        // ---------- Original Method ----------
        //parseBigDecimal = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.209 -0400", hash_original_method = "7FF47C5BC2EFAEE27B26A852A846EAFB", hash_generated_method = "CB50EF700F4EE81341E89A29CAB95719")
    public void setParseIntegerOnly(boolean value) {
        int i;
        i = -1;
        i = 0;
        setAttribute(this.address, UNUM_PARSE_INT_ONLY, i);
        addTaint(value);
        // ---------- Original Method ----------
        //int i = value ? -1 : 0;
        //setAttribute(this.address, UNUM_PARSE_INT_ONLY, i);
    }

    
        private static void applyPattern(int addr, boolean localized, String pattern) {
        try {
            applyPatternImpl(addr, localized, pattern);
        } catch (NullPointerException npe) {
            throw npe;
        } catch (RuntimeException re) {
            throw new IllegalArgumentException("syntax error: " + re.getMessage() + ": " + pattern);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.210 -0400", hash_original_method = "D542BB733096020C1E39876D678697A7", hash_generated_method = "5601AC6A55BB8B8AC389EDE8D8DE38ED")
    public void setRoundingMode(RoundingMode roundingMode, double roundingIncrement) {
        int nativeRoundingMode;
        //Begin case CEILING 
        nativeRoundingMode = 0;
        //End case CEILING 
        //Begin case FLOOR 
        nativeRoundingMode = 1;
        //End case FLOOR 
        //Begin case DOWN 
        nativeRoundingMode = 2;
        //End case DOWN 
        //Begin case UP 
        nativeRoundingMode = 3;
        //End case UP 
        //Begin case HALF_EVEN 
        nativeRoundingMode = 4;
        //End case HALF_EVEN 
        //Begin case HALF_DOWN 
        nativeRoundingMode = 5;
        //End case HALF_DOWN 
        //Begin case HALF_UP 
        nativeRoundingMode = 6;
        //End case HALF_UP 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        //End case default 
        setRoundingMode(address, nativeRoundingMode, roundingIncrement);
        addTaint(roundingMode.getTaint());
        addTaint(roundingIncrement);
        // ---------- Original Method ----------
        //final int nativeRoundingMode;
        //switch (roundingMode) {
        //case CEILING: nativeRoundingMode = 0; break;
        //case FLOOR: nativeRoundingMode = 1; break;
        //case DOWN: nativeRoundingMode = 2; break;
        //case UP: nativeRoundingMode = 3; break;
        //case HALF_EVEN: nativeRoundingMode = 4; break;
        //case HALF_DOWN: nativeRoundingMode = 5; break;
        //case HALF_UP: nativeRoundingMode = 6; break;
        //default: throw new AssertionError();
        //}
        //setRoundingMode(address, nativeRoundingMode, roundingIncrement);
    }

    
        private static void applyPatternImpl(int addr, boolean localized, String pattern) {
    }

    
        private static int cloneImpl(int addr) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void close(int addr) {
    }

    
        private static char[] formatLong(int addr, long value, FieldPositionIterator iter) {
        return {DSUtils.UNKNOWN_CHAR};
    }

    
        private static char[] formatDouble(int addr, double value, FieldPositionIterator iter) {
        return {DSUtils.UNKNOWN_CHAR};
    }

    
        private static char[] formatDigitList(int addr, String value, FieldPositionIterator iter) {
        return {DSUtils.UNKNOWN_CHAR};
    }

    
        private static int getAttribute(int addr, int symbol) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static String getTextAttribute(int addr, int symbol) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static int open(String pattern, String currencySymbol,
            char decimalSeparator, char digit, String exponentSeparator, char groupingSeparator,
            String infinity, String internationalCurrencySymbol, char minusSign,
            char monetaryDecimalSeparator, String nan, char patternSeparator, char percent,
            char perMill, char zeroDigit) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static Number parse(int addr, String string, ParsePosition position, boolean parseBigDecimal) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static void setDecimalFormatSymbols(int addr, String currencySymbol,
            char decimalSeparator, char digit, String exponentSeparator, char groupingSeparator,
            String infinity, String internationalCurrencySymbol, char minusSign,
            char monetaryDecimalSeparator, String nan, char patternSeparator, char percent,
            char perMill, char zeroDigit) {
    }

    
        private static void setSymbol(int addr, int symbol, String str) {
    }

    
        private static void setAttribute(int addr, int symbol, int i) {
    }

    
        private static void setRoundingMode(int addr, int roundingMode, double roundingIncrement) {
    }

    
        private static void setTextAttribute(int addr, int symbol, String str) {
    }

    
        private static String toPatternImpl(int addr, boolean localized) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    private static class FieldPositionIterator {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.224 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "2F322A4CCA87DBF62C5291F2FA6D1538")

        private int[] data;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.224 -0400", hash_original_field = "41A87CD99CAC79C14134D1D8193C9405", hash_generated_field = "C812BD0A950A53E451CF78B187BCF580")

        private int pos = -3;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.224 -0400", hash_original_method = "3872533C5F4C6DF8E9B47456E87ABB09", hash_generated_method = "61C6C4E209B2EB1D194185007E303529")
        private  FieldPositionIterator() {
            // ---------- Original Method ----------
        }

        
                public static FieldPositionIterator forFieldPosition(FieldPosition fp) {
            if (fp != null && fp.getField() != -1) {
                return new FieldPositionIterator();
            }
            return null;
        }

        
                private static int getNativeFieldPositionId(FieldPosition fp) {
            int id = fp.getField();
            if (id < -1 || id > 1) {
                id = -1;
            }
            if (id == -1) {
                Format.Field attr = fp.getFieldAttribute();
                if (attr != null) {
                    for (int i = 0; i < fields.length; ++i) {
                        if (fields[i].equals(attr)) {
                            id = i;
                            break;
                        }
                    }
                }
            }
            return id;
        }

        
                private static void setFieldPosition(FieldPositionIterator fpi, FieldPosition fp) {
            if (fpi != null && fp != null) {
                int field = getNativeFieldPositionId(fp);
                if (field != -1) {
                    while (fpi.next()) {
                        if (fpi.fieldId() == field) {
                            fp.setBeginIndex(fpi.start());
                            fp.setEndIndex(fpi.limit());
                            break;
                        }
                    }
                }
            }
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.236 -0400", hash_original_method = "F9CA7CA9C759396A69CAFCECCE3A38CE", hash_generated_method = "9F602C3A4CF4D9C9A50FD20E71A908B1")
        public boolean next() {
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            pos += 3;
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1887301004 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1887301004;
            // ---------- Original Method ----------
            //if (data == null || pos == data.length) {
                //throw new NoSuchElementException();
            //}
            //pos += 3;
            //return pos < data.length;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.237 -0400", hash_original_method = "28A52A04516ACAEA5CBE057E7005DC29", hash_generated_method = "5DF96E6E92B6CC3D8098CC728AFF2BD8")
        private void checkValid() {
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            // ---------- Original Method ----------
            //if (data == null || pos < 0 || pos == data.length) {
                //throw new NoSuchElementException();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.237 -0400", hash_original_method = "F481D50CCC1AB38B4CA6D00583ECCD74", hash_generated_method = "3AEDC5492DF607759E8B5B88F2B12A7C")
        public int fieldId() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_877240755 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_877240755;
            // ---------- Original Method ----------
            //return data[pos];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.238 -0400", hash_original_method = "B152D64258DA85AB1020B78F45482139", hash_generated_method = "F1B934C1F094E547EB1C792294A7C323")
        public Format.Field field() {
            Format.Field varB4EAC82CA7396A68D541C85D26508E83_836957064 = null; //Variable for return #1
            checkValid();
            varB4EAC82CA7396A68D541C85D26508E83_836957064 = fields[data[pos]];
            varB4EAC82CA7396A68D541C85D26508E83_836957064.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_836957064;
            // ---------- Original Method ----------
            //checkValid();
            //return fields[data[pos]];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.238 -0400", hash_original_method = "573D89586F74B4B2EDB6530AAE1DEC79", hash_generated_method = "0943F1F4067377D73FECB35CF223FE34")
        public int start() {
            checkValid();
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_140889949 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_140889949;
            // ---------- Original Method ----------
            //checkValid();
            //return data[pos + 1];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.238 -0400", hash_original_method = "431D149304BC1F14DB944F0790F3E8B8", hash_generated_method = "7563ED055CF2C5B61DF3EB0A6D6CD32B")
        public int limit() {
            checkValid();
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2106765972 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2106765972;
            // ---------- Original Method ----------
            //checkValid();
            //return data[pos + 2];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.239 -0400", hash_original_method = "E1A3B20A4A62E5F6661DF7F73A635F7C", hash_generated_method = "2FA05A6182FB4AA13AC353371D99B73A")
        private void setData(int[] data) {
            this.data = data;
            this.pos = -3;
            // ---------- Original Method ----------
            //this.data = data;
            //this.pos = -3;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.239 -0400", hash_original_field = "27D7A0AA47D8E9AD8DC4BF2D88186493", hash_generated_field = "C4A857D89644DD678C209850C71C6253")

        private static Format.Field fields[] = {
            
            
            
            
            NumberFormat.Field.INTEGER,
            NumberFormat.Field.FRACTION,
            NumberFormat.Field.DECIMAL_SEPARATOR,
            NumberFormat.Field.EXPONENT_SYMBOL,
            NumberFormat.Field.EXPONENT_SIGN,
            NumberFormat.Field.EXPONENT,
            NumberFormat.Field.GROUPING_SEPARATOR,
            NumberFormat.Field.CURRENCY,
            NumberFormat.Field.PERCENT,
            NumberFormat.Field.PERMILLE,
            NumberFormat.Field.SIGN,
        };
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.239 -0400", hash_original_field = "024283A17B4F858679487AA41D06F137", hash_generated_field = "F1A0B4063FC73A00E5925A4113D34F33")

    private static int UNUM_DECIMAL_SEPARATOR_SYMBOL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.239 -0400", hash_original_field = "569D4CB22C567CCFA8FA28AA98AA481B", hash_generated_field = "FFB1DBC11B61B861CB120E66FC348445")

    private static int UNUM_GROUPING_SEPARATOR_SYMBOL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.239 -0400", hash_original_field = "DC39C912818608D5EE416599EB02C2F1", hash_generated_field = "13D80B550D517DDBE93023DF7AB8E4AF")

    private static int UNUM_PATTERN_SEPARATOR_SYMBOL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.239 -0400", hash_original_field = "2E48B57484F2D80820EE30D01A85762B", hash_generated_field = "AB77581E6286196306602ED93BC57AF9")

    private static int UNUM_PERCENT_SYMBOL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.239 -0400", hash_original_field = "B80F5415D213C71760D64C3F8655E103", hash_generated_field = "846EEF4A4D3AFE29BAB0336BFD429FDF")

    private static int UNUM_ZERO_DIGIT_SYMBOL = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.239 -0400", hash_original_field = "849923D76D74AC9D2575F3FEB9D17105", hash_generated_field = "A95D26CEFB4738083B5CC4E5911EA137")

    private static int UNUM_DIGIT_SYMBOL = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.239 -0400", hash_original_field = "982740976D9454DA142BBB76FCB86E65", hash_generated_field = "AE99C546578E39F1A84EB6E19A6ECD0B")

    private static int UNUM_MINUS_SIGN_SYMBOL = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.239 -0400", hash_original_field = "D4A0AD0CDFD3BC5A192430B57716B330", hash_generated_field = "2FB4E731FA769678FC11C4CCE2D477A5")

    private static int UNUM_PLUS_SIGN_SYMBOL = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.239 -0400", hash_original_field = "6520A81D71399A74E18494DE8A2D2716", hash_generated_field = "E7AFBCE4F02EC99A1ADFD6407063802C")

    private static int UNUM_CURRENCY_SYMBOL = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.239 -0400", hash_original_field = "4EBC0BEF182CD31FB42F775EAD2D9A1C", hash_generated_field = "4EC18E3BC8FD687942CB53A60165AD20")

    private static int UNUM_INTL_CURRENCY_SYMBOL = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.239 -0400", hash_original_field = "82EF848B759F95741D1982E35EBEEA19", hash_generated_field = "B782DF48B22783F78CB3C9BF9867E963")

    private static int UNUM_MONETARY_SEPARATOR_SYMBOL = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.239 -0400", hash_original_field = "EBFE24817B35301033E4034E3B5AFB93", hash_generated_field = "F739F7AC70101A5061EA03973F0B44C6")

    private static int UNUM_EXPONENTIAL_SYMBOL = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.239 -0400", hash_original_field = "555A332569EBE4B181F44ADCCF0603D5", hash_generated_field = "AE0440C3265AAA458B6618C9997C63A4")

    private static int UNUM_PERMILL_SYMBOL = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.239 -0400", hash_original_field = "6F0C8024A801549CF944CDBEFDB9DDB4", hash_generated_field = "A207BD74612EA04C63F8EAFD5C4697FE")

    private static int UNUM_PAD_ESCAPE_SYMBOL = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.239 -0400", hash_original_field = "378FA79958A996A5E9BC4BFADD42352C", hash_generated_field = "C5FBBF4CEB67F2D4A40E12DB14C129B2")

    private static int UNUM_INFINITY_SYMBOL = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.239 -0400", hash_original_field = "8B4BB88522F81B591874E385E981297F", hash_generated_field = "A66A7F92A2A33759CAA68FCA9670E56F")

    private static int UNUM_NAN_SYMBOL = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.239 -0400", hash_original_field = "F86892C3522DEA90F517C4C5467386D5", hash_generated_field = "ED434CC9C3E68F2311304019BC8A38FA")

    private static int UNUM_SIGNIFICANT_DIGIT_SYMBOL = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.239 -0400", hash_original_field = "53E1C966A8C817CC8509732458E431F8", hash_generated_field = "DF1FB7EE940A8E1B8FF0355BD23DF064")

    private static int UNUM_MONETARY_GROUPING_SEPARATOR_SYMBOL = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_field = "6944D02F190693EAEBF8A29CD17CA79C", hash_generated_field = "774C94D52D74DACB1ECD0810D68C6C6E")

    private static int UNUM_FORMAT_SYMBOL_COUNT = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_field = "8971AE23D0ACB2019E7F237C1A5D9057", hash_generated_field = "E9D4E418BC891FA00F446DC769ABF166")

    private static int UNUM_PARSE_INT_ONLY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_field = "46581E7ADB623C966C46F86CBCA1ACA7", hash_generated_field = "BEE01287F5547E235A2E45295E96352A")

    private static int UNUM_GROUPING_USED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_field = "D0A1191C6B8058293B62F4EB5CB139F7", hash_generated_field = "5BCEEDAF00801CEEB2E2CC5446CA7B8D")

    private static int UNUM_DECIMAL_ALWAYS_SHOWN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_field = "6A692975BF789004FF9BCD7ED2595754", hash_generated_field = "0C50FDB8E63D18E74FD84372257CD42A")

    private static int UNUM_MAX_INTEGER_DIGITS = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_field = "BFCDA61A6544D8200FB16C8ECAB194D9", hash_generated_field = "19875760AE1AE10E91F16D956926D045")

    private static int UNUM_MIN_INTEGER_DIGITS = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_field = "DA0B7AFB468402B4FAB627D7A9AFFACE", hash_generated_field = "497556A4D54DC72F228E201D69F99D9B")

    private static int UNUM_INTEGER_DIGITS = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_field = "5750A34FC87461228B5037583C2CE979", hash_generated_field = "17492FB3B526FC58E5B8303AD0FCC398")

    private static int UNUM_MAX_FRACTION_DIGITS = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_field = "BE2E1373EE438BBC72E5EEA62F6EEFCE", hash_generated_field = "23238292FBA113DA32B40918FDBD6327")

    private static int UNUM_MIN_FRACTION_DIGITS = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_field = "C0D0E977100ACCBC9B8F77297A991F0A", hash_generated_field = "ABB619B1F91E8449737753382F4A7773")

    private static int UNUM_FRACTION_DIGITS = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_field = "4FFB3432E077BDF4076A364D312B6322", hash_generated_field = "E860B0F79430839306E7B4464FDF7C5A")

    private static int UNUM_MULTIPLIER = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_field = "68EDF621E4AEA7D984951F9A8C68B508", hash_generated_field = "33A0D7072383946FD3DE589292436664")

    private static int UNUM_GROUPING_SIZE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_field = "3180DB5CC7990CFC070810D65823E15E", hash_generated_field = "2F353D055C6CE86B2131D63744BDE07B")

    private static int UNUM_ROUNDING_MODE = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_field = "EB76EFADD49B90471770F624C07D79A9", hash_generated_field = "8DD05CECB4B2FA83C4755C2FFB8C39D0")

    private static int UNUM_ROUNDING_INCREMENT = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_field = "2E1629A5A9F1DEAF1A18A9539618D4D5", hash_generated_field = "4B5B325097AF2EEC2AF3DCED6079BC69")

    private static int UNUM_FORMAT_WIDTH = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_field = "B760C9A8428FD459E7B9827858CFD779", hash_generated_field = "B6124F7DDDF54572151B57017DB994E5")

    private static int UNUM_PADDING_POSITION = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_field = "D7D95CD560376F364890DB0FD74EB85B", hash_generated_field = "62DBB8D58F43FFC1602C56142717026D")

    private static int UNUM_SECONDARY_GROUPING_SIZE = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_field = "5CA0ED7747BDD5FD9CA45EC2E6F0E8B5", hash_generated_field = "0793A35896CC034823DD1EEDF472132E")

    private static int UNUM_SIGNIFICANT_DIGITS_USED = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_field = "CED3E3C034EC98CD8CA99E728B988C9E", hash_generated_field = "2949BA0424F474373992B7135D8FFD5C")

    private static int UNUM_MIN_SIGNIFICANT_DIGITS = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_field = "3E30604D3F70C6D8BE917DAB3E65F7C2", hash_generated_field = "3FE9D39FD73AD8FD8557F48BDBEEE0A1")

    private static int UNUM_MAX_SIGNIFICANT_DIGITS = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_field = "D64F4F2459B0190DFFBA9826AC72489F", hash_generated_field = "D3CA11B052F84F0E610A986ECB047426")

    private static int UNUM_LENIENT_PARSE = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_field = "E81D0E837BFCCE8B299F86B2B0379AA1", hash_generated_field = "5C27825FA6DDEBE5B3689CDE9ADD1B27")

    private static int UNUM_POSITIVE_PREFIX = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_field = "ACAF14DFBF527393BF01C453C005773D", hash_generated_field = "72BB3F9B4869F37B1712A4B3E02A7ACC")

    private static int UNUM_POSITIVE_SUFFIX = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_field = "3B4AAFD666329CD2E14C939EB5493111", hash_generated_field = "9D1E6D97489785DBE6BD452143657B27")

    private static int UNUM_NEGATIVE_PREFIX = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_field = "B914446D1D897950976F6F9F6EEBD0B7", hash_generated_field = "DBA534AA48DEA0242034D3457E1BF15D")

    private static int UNUM_NEGATIVE_SUFFIX = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_field = "4E39F122ADFEC6840ACE999C184C9EE2", hash_generated_field = "0B72590282B714A077410BB49CC6729A")

    private static int UNUM_PADDING_CHARACTER = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_field = "36CCE6C77A18DA6E36931EF0CD49A9BB", hash_generated_field = "352C277EBC3B7F19B41C32D96AD9956E")

    private static int UNUM_CURRENCY_CODE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_field = "FBB3BE349F8C0AB42CE7BA4DD07A0976", hash_generated_field = "CA6C1E3B5555C442D0ABE8ED635462AB")

    private static int UNUM_DEFAULT_RULESET = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_field = "A63C4BE0875A4094DC60472905775981", hash_generated_field = "8AB970464C89EE4EB6AF3B62724D9B9B")

    private static int UNUM_PUBLIC_RULESETS = 7;
}

