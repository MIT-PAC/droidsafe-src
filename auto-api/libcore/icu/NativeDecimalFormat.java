package libcore.icu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final int UNUM_DECIMAL_SEPARATOR_SYMBOL = 0;
    private static final int UNUM_GROUPING_SEPARATOR_SYMBOL = 1;
    private static final int UNUM_PATTERN_SEPARATOR_SYMBOL = 2;
    private static final int UNUM_PERCENT_SYMBOL = 3;
    private static final int UNUM_ZERO_DIGIT_SYMBOL = 4;
    private static final int UNUM_DIGIT_SYMBOL = 5;
    private static final int UNUM_MINUS_SIGN_SYMBOL = 6;
    private static final int UNUM_PLUS_SIGN_SYMBOL = 7;
    private static final int UNUM_CURRENCY_SYMBOL = 8;
    private static final int UNUM_INTL_CURRENCY_SYMBOL = 9;
    private static final int UNUM_MONETARY_SEPARATOR_SYMBOL = 10;
    private static final int UNUM_EXPONENTIAL_SYMBOL = 11;
    private static final int UNUM_PERMILL_SYMBOL = 12;
    private static final int UNUM_PAD_ESCAPE_SYMBOL = 13;
    private static final int UNUM_INFINITY_SYMBOL = 14;
    private static final int UNUM_NAN_SYMBOL = 15;
    private static final int UNUM_SIGNIFICANT_DIGIT_SYMBOL = 16;
    private static final int UNUM_MONETARY_GROUPING_SEPARATOR_SYMBOL = 17;
    private static final int UNUM_FORMAT_SYMBOL_COUNT = 18;
    private static final int UNUM_PARSE_INT_ONLY = 0;
    private static final int UNUM_GROUPING_USED = 1;
    private static final int UNUM_DECIMAL_ALWAYS_SHOWN = 2;
    private static final int UNUM_MAX_INTEGER_DIGITS = 3;
    private static final int UNUM_MIN_INTEGER_DIGITS = 4;
    private static final int UNUM_INTEGER_DIGITS = 5;
    private static final int UNUM_MAX_FRACTION_DIGITS = 6;
    private static final int UNUM_MIN_FRACTION_DIGITS = 7;
    private static final int UNUM_FRACTION_DIGITS = 8;
    private static final int UNUM_MULTIPLIER = 9;
    private static final int UNUM_GROUPING_SIZE = 10;
    private static final int UNUM_ROUNDING_MODE = 11;
    private static final int UNUM_ROUNDING_INCREMENT = 12;
    private static final int UNUM_FORMAT_WIDTH = 13;
    private static final int UNUM_PADDING_POSITION = 14;
    private static final int UNUM_SECONDARY_GROUPING_SIZE = 15;
    private static final int UNUM_SIGNIFICANT_DIGITS_USED = 16;
    private static final int UNUM_MIN_SIGNIFICANT_DIGITS = 17;
    private static final int UNUM_MAX_SIGNIFICANT_DIGITS = 18;
    private static final int UNUM_LENIENT_PARSE = 19;
    private static final int UNUM_POSITIVE_PREFIX = 0;
    private static final int UNUM_POSITIVE_SUFFIX = 1;
    private static final int UNUM_NEGATIVE_PREFIX = 2;
    private static final int UNUM_NEGATIVE_SUFFIX = 3;
    private static final int UNUM_PADDING_CHARACTER = 4;
    private static final int UNUM_CURRENCY_CODE = 5;
    private static final int UNUM_DEFAULT_RULESET = 6;
    private static final int UNUM_PUBLIC_RULESETS = 7;
    private int address;
    private String lastPattern;
    private boolean negPrefNull;
    private boolean negSuffNull;
    private boolean posPrefNull;
    private boolean posSuffNull;
    private transient boolean parseBigDecimal;
    private BigDecimal multiplierBigDecimal = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.408 -0400", hash_original_method = "D8AEBC26DB4CF2E0C933D0F5B84F659E", hash_generated_method = "7B5A0DA842D76B218D32BB57FF95FEFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NativeDecimalFormat(String pattern, DecimalFormatSymbols dfs) {
        dsTaint.addTaint(dfs.dsTaint);
        dsTaint.addTaint(pattern);
        try 
        {
            this.address = open(pattern, dfs.getCurrencySymbol(),
                    dfs.getDecimalSeparator(), dfs.getDigit(), dfs.getExponentSeparator(),
                    dfs.getGroupingSeparator(), dfs.getInfinity(),
                    dfs.getInternationalCurrencySymbol(), dfs.getMinusSign(),
                    dfs.getMonetaryDecimalSeparator(), dfs.getNaN(), dfs.getPatternSeparator(),
                    dfs.getPercent(), dfs.getPerMill(), dfs.getZeroDigit());
        } //End block
        catch (NullPointerException npe)
        {
            throw npe;
        } //End block
        catch (RuntimeException re)
        {
            throw new IllegalArgumentException("syntax error: " + re.getMessage() + ": " + pattern);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.408 -0400", hash_original_method = "03415942CECEA3C928FA024ACF038523", hash_generated_method = "3E44AA8FAF15E8936523FE39D4035AF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NativeDecimalFormat(String pattern, LocaleData data) {
        dsTaint.addTaint(pattern);
        dsTaint.addTaint(data.dsTaint);
        this.address = open(pattern, data.currencySymbol,
                data.decimalSeparator, '#', data.exponentSeparator, data.groupingSeparator,
                data.infinity, data.internationalCurrencySymbol, data.minusSign,
                data.monetarySeparator, data.NaN, data.patternSeparator,
                data.percent, data.perMill, data.zeroDigit);
        // ---------- Original Method ----------
        //this.address = open(pattern, data.currencySymbol,
                //data.decimalSeparator, '#', data.exponentSeparator, data.groupingSeparator,
                //data.infinity, data.internationalCurrencySymbol, data.minusSign,
                //data.monetarySeparator, data.NaN, data.patternSeparator,
                //data.percent, data.perMill, data.zeroDigit);
        //this.lastPattern = pattern;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.408 -0400", hash_original_method = "F2FB63D256AD622AD0AA1906E5944DB2", hash_generated_method = "F8F772FF69E190BE5F4F0C27E67E2F64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private NativeDecimalFormat(NativeDecimalFormat other) {
        dsTaint.addTaint(other.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.409 -0400", hash_original_method = "C197288C8DD3954567266901B60BE5B8", hash_generated_method = "59F939CA31DAF1504FEB80A8F2A6DA25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var8C9A345D8B4C41F5F6C3E9546CE693DB_907487136 = (this.getPositivePrefix().hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.getPositivePrefix().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.409 -0400", hash_original_method = "5C171A463B7BB08FCE40648C7CE8F861", hash_generated_method = "5129AB30087D33B4B466EF7F5B2850DD")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.409 -0400", hash_original_method = "D252F6FD4E111780C248C256B2516FF2", hash_generated_method = "61C0DFC5068419BCCF2E39D778004E41")
    @DSModeled(DSC.SAFE)
    @Override
    public Object clone() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new NativeDecimalFormat(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.409 -0400", hash_original_method = "220130DBC584D5B5D45771D972950D18", hash_generated_method = "04D59599A896B495F81C21B87C13D66A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        NativeDecimalFormat obj;
        obj = (NativeDecimalFormat) object;
        boolean var18FBB52F731808A4077D23FDD981869A_80552574 = (obj.toPattern().equals(this.toPattern()) &&
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.409 -0400", hash_original_method = "6B8DF144F51335DB9B33B1BD0598F087", hash_generated_method = "7111AC663B99A7B0C269AA0646EC1A16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDecimalFormatSymbols(final DecimalFormatSymbols dfs) {
        dsTaint.addTaint(dfs.dsTaint);
        setDecimalFormatSymbols(this.address, dfs.getCurrencySymbol(), dfs.getDecimalSeparator(),
                dfs.getDigit(), dfs.getExponentSeparator(), dfs.getGroupingSeparator(),
                dfs.getInfinity(), dfs.getInternationalCurrencySymbol(), dfs.getMinusSign(),
                dfs.getMonetaryDecimalSeparator(), dfs.getNaN(), dfs.getPatternSeparator(),
                dfs.getPercent(), dfs.getPerMill(), dfs.getZeroDigit());
        // ---------- Original Method ----------
        //setDecimalFormatSymbols(this.address, dfs.getCurrencySymbol(), dfs.getDecimalSeparator(),
                //dfs.getDigit(), dfs.getExponentSeparator(), dfs.getGroupingSeparator(),
                //dfs.getInfinity(), dfs.getInternationalCurrencySymbol(), dfs.getMinusSign(),
                //dfs.getMonetaryDecimalSeparator(), dfs.getNaN(), dfs.getPatternSeparator(),
                //dfs.getPercent(), dfs.getPerMill(), dfs.getZeroDigit());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.409 -0400", hash_original_method = "5FE0177EB5130C508ECEC468A64D96E3", hash_generated_method = "79BBC230DD88A043D5D3C05547CB1211")
    @DSModeled(DSC.SAFE)
    public void setDecimalFormatSymbols(final LocaleData localeData) {
        dsTaint.addTaint(localeData.dsTaint);
        setDecimalFormatSymbols(this.address, localeData.currencySymbol, localeData.decimalSeparator,
                '#', localeData.exponentSeparator, localeData.groupingSeparator,
                localeData.infinity, localeData.internationalCurrencySymbol, localeData.minusSign,
                localeData.monetarySeparator, localeData.NaN, localeData.patternSeparator,
                localeData.percent, localeData.perMill, localeData.zeroDigit);
        // ---------- Original Method ----------
        //setDecimalFormatSymbols(this.address, localeData.currencySymbol, localeData.decimalSeparator,
                //'#', localeData.exponentSeparator, localeData.groupingSeparator,
                //localeData.infinity, localeData.internationalCurrencySymbol, localeData.minusSign,
                //localeData.monetarySeparator, localeData.NaN, localeData.patternSeparator,
                //localeData.percent, localeData.perMill, localeData.zeroDigit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.409 -0400", hash_original_method = "E3DC36059DBEEA918EB4DAC2E3F69056", hash_generated_method = "8947656444FE02C010E4A477177472F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char[] formatBigDecimal(BigDecimal value, FieldPosition field) {
        dsTaint.addTaint(field.dsTaint);
        dsTaint.addTaint(value.dsTaint);
        FieldPositionIterator fpi;
        fpi = FieldPositionIterator.forFieldPosition(field);
        char[] result;
        result = formatDigitList(this.address, value.toString(), fpi);
        {
            FieldPositionIterator.setFieldPosition(fpi, field);
        } //End block
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //FieldPositionIterator fpi = FieldPositionIterator.forFieldPosition(field);
        //char[] result = formatDigitList(this.address, value.toString(), fpi);
        //if (fpi != null) {
            //FieldPositionIterator.setFieldPosition(fpi, field);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.409 -0400", hash_original_method = "AB58B0DEED1650663505F868BCDB9A76", hash_generated_method = "B16C6D74D987B2159D2C8482F23A0CEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char[] formatBigInteger(BigInteger value, FieldPosition field) {
        dsTaint.addTaint(field.dsTaint);
        dsTaint.addTaint(value.dsTaint);
        FieldPositionIterator fpi;
        fpi = FieldPositionIterator.forFieldPosition(field);
        char[] result;
        result = formatDigitList(this.address, value.toString(10), fpi);
        {
            FieldPositionIterator.setFieldPosition(fpi, field);
        } //End block
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //FieldPositionIterator fpi = FieldPositionIterator.forFieldPosition(field);
        //char[] result = formatDigitList(this.address, value.toString(10), fpi);
        //if (fpi != null) {
            //FieldPositionIterator.setFieldPosition(fpi, field);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.410 -0400", hash_original_method = "E280C21CEDC9C41E32AB3781E6354849", hash_generated_method = "5E9B742BB7B5112D5D70B9DED39B7B71")
    @DSModeled(DSC.SAFE)
    public char[] formatLong(long value, FieldPosition field) {
        dsTaint.addTaint(field.dsTaint);
        dsTaint.addTaint(value);
        FieldPositionIterator fpi;
        fpi = FieldPositionIterator.forFieldPosition(field);
        char[] result;
        result = formatLong(this.address, value, fpi);
        {
            FieldPositionIterator.setFieldPosition(fpi, field);
        } //End block
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //FieldPositionIterator fpi = FieldPositionIterator.forFieldPosition(field);
        //char[] result = formatLong(this.address, value, fpi);
        //if (fpi != null) {
            //FieldPositionIterator.setFieldPosition(fpi, field);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.410 -0400", hash_original_method = "2B822D9FBF334F04026E765F63D8EA7D", hash_generated_method = "2A609601761ECC263645726220D531F2")
    @DSModeled(DSC.SAFE)
    public char[] formatDouble(double value, FieldPosition field) {
        dsTaint.addTaint(field.dsTaint);
        dsTaint.addTaint(value);
        FieldPositionIterator fpi;
        fpi = FieldPositionIterator.forFieldPosition(field);
        char[] result;
        result = formatDouble(this.address, value, fpi);
        {
            FieldPositionIterator.setFieldPosition(fpi, field);
        } //End block
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //FieldPositionIterator fpi = FieldPositionIterator.forFieldPosition(field);
        //char[] result = formatDouble(this.address, value, fpi);
        //if (fpi != null) {
            //FieldPositionIterator.setFieldPosition(fpi, field);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.410 -0400", hash_original_method = "521D68694A0F2FF9FD004D1F044248B6", hash_generated_method = "2E70D5977C9F3B9129C6AF8B2D48DF71")
    @DSModeled(DSC.SAFE)
    public void applyLocalizedPattern(String pattern) {
        dsTaint.addTaint(pattern);
        applyPattern(this.address, true, pattern);
        lastPattern = null;
        // ---------- Original Method ----------
        //applyPattern(this.address, true, pattern);
        //lastPattern = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.410 -0400", hash_original_method = "105E6A8350C3ECD2CBDC93E6E74AA17C", hash_generated_method = "EAA1538417C8102277B2C2D4E485A74C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void applyPattern(String pattern) {
        dsTaint.addTaint(pattern);
        {
            boolean var30056E56F7633573B6C2DD284E929162_1549513687 = (lastPattern != null && pattern.equals(lastPattern));
        } //End collapsed parenthetic
        applyPattern(this.address, false, pattern);
        // ---------- Original Method ----------
        //if (lastPattern != null && pattern.equals(lastPattern)) {
            //return;
        //}
        //applyPattern(this.address, false, pattern);
        //lastPattern = pattern;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.410 -0400", hash_original_method = "9FEF3AE5E61C347D525A9585FBE19ECF", hash_generated_method = "93367984C3988A96168E15EC95A9DC55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        dsTaint.addTaint(object.dsTaint);
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
            boolean varC94C796D691F3725A70F62B7F781E92F_1035211583 = (fpIter.next());
            {
                Format.Field field;
                field = fpIter.field();
                as.addAttribute(field, field, fpIter.start(), fpIter.limit());
            } //End block
        } //End collapsed parenthetic
        AttributedCharacterIterator varC17B74234B5E841D682B5933E83FF653_1214227863 = (as.getIterator());
        return (AttributedCharacterIterator)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.410 -0400", hash_original_method = "E9B105AB178BFBFEB280AF82F381CE84", hash_generated_method = "748B88870727BA1BF0E23978EE811E91")
    @DSModeled(DSC.SAFE)
    private int makeScalePositive(int scale, StringBuilder val) {
        dsTaint.addTaint(val.dsTaint);
        dsTaint.addTaint(scale);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.410 -0400", hash_original_method = "1F42A3AAFB142AE620B1A14F6DE6CCC5", hash_generated_method = "01038D86CE930C0294A1E30EF7201589")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toLocalizedPattern() {
        String varD9D03409EABA9668051F440E80015FF6_937484738 = (toPatternImpl(this.address, true));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return toPatternImpl(this.address, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.410 -0400", hash_original_method = "D90F2C106608034D601A7F076DF301BD", hash_generated_method = "4E62BF723D168F029CB6671ACF2388E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toPattern() {
        String var8084429E32D1F969F87AFC56450ED8FA_1539188800 = (toPatternImpl(this.address, false));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return toPatternImpl(this.address, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.410 -0400", hash_original_method = "C24C75386265F50BCF75B046D9BE3ACC", hash_generated_method = "247035365DC7E98136E311E417A46D1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Number parse(String string, ParsePosition position) {
        dsTaint.addTaint(position.dsTaint);
        dsTaint.addTaint(string);
        Number var5749C7280422D3FE838D39A428497A88_480926803 = (parse(address, string, position, parseBigDecimal));
        return (Number)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return parse(address, string, position, parseBigDecimal);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.410 -0400", hash_original_method = "00B4402833BBD0AA4B8B3DAC69045BF5", hash_generated_method = "4E013FEEDED609FEDE37866D8FD78505")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMaximumFractionDigits() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int var2031882FA64042FA8714F056BC326B77_1722703343 = (getAttribute(this.address, UNUM_MAX_FRACTION_DIGITS));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_MAX_FRACTION_DIGITS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.410 -0400", hash_original_method = "39458F699020062C4A2A7E5A13FEC803", hash_generated_method = "9F3BF749C49D9CCDE2BBD51F0AB2ED56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMaximumIntegerDigits() {
        int var552BC4AA7CD66CB5C86DC39DD6F5EB61_31537122 = (getAttribute(this.address, UNUM_MAX_INTEGER_DIGITS));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_MAX_INTEGER_DIGITS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.411 -0400", hash_original_method = "2493C2169723FB0932E2841ED5413767", hash_generated_method = "26C11484CBDD473A53E5DAD3AFFD8BEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMinimumFractionDigits() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int var651D9F7029A8FF147A685A36D32AA845_1383018906 = (getAttribute(this.address, UNUM_MIN_FRACTION_DIGITS));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_MIN_FRACTION_DIGITS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.411 -0400", hash_original_method = "C287E89D9CA249987BAB41DA58A603BE", hash_generated_method = "63E571D694A5418A269CD9F8D6A1CFF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMinimumIntegerDigits() {
        int varE7531A98F2A0AD2779754CD1B2865E0B_805597023 = (getAttribute(this.address, UNUM_MIN_INTEGER_DIGITS));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_MIN_INTEGER_DIGITS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.411 -0400", hash_original_method = "C63E831A66DAEA25345E39BD0E8C902A", hash_generated_method = "C27CB2DC45B7E8877F64CBA2D4EF3567")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getGroupingSize() {
        int varEBCCDDFF415DDB22660365F0FC4A83FC_1682648654 = (getAttribute(this.address, UNUM_GROUPING_SIZE));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_GROUPING_SIZE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.411 -0400", hash_original_method = "195B15A30ECFDD2DA316EFD7F1135C74", hash_generated_method = "D3A3CD6FB9C23CD6832FAE9FD656A1F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMultiplier() {
        int var2028C5EE807D8F87AD09F7ADE0783DF7_1948981273 = (getAttribute(this.address, UNUM_MULTIPLIER));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_MULTIPLIER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.411 -0400", hash_original_method = "6BE8F2BF8B3A5604EA6D6E250F279823", hash_generated_method = "8E0F44CF2436432B479BE54681A74E23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getNegativePrefix() {
        String var34254ADEEA9812EA9A118EEE5F0FFA5D_1608010747 = (getTextAttribute(this.address, UNUM_NEGATIVE_PREFIX));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (negPrefNull) {
            //return null;
        //}
        //return getTextAttribute(this.address, UNUM_NEGATIVE_PREFIX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.411 -0400", hash_original_method = "3B3EF8E26C12E3D51B48D0C30732D5F5", hash_generated_method = "860664CE53EEF5676DFD8CC21D608B17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getNegativeSuffix() {
        String varFF6E831F375FB4D540B92A08CB4F4FCF_1785151702 = (getTextAttribute(this.address, UNUM_NEGATIVE_SUFFIX));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (negSuffNull) {
            //return null;
        //}
        //return getTextAttribute(this.address, UNUM_NEGATIVE_SUFFIX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.411 -0400", hash_original_method = "8D4D6B90A746E09AE36173ABA0AB4B15", hash_generated_method = "744944760FA6B7821530FAD4D29AC030")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPositivePrefix() {
        String var1A9101840B75568C120D24519801CE9B_966299917 = (getTextAttribute(this.address, UNUM_POSITIVE_PREFIX));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (posPrefNull) {
            //return null;
        //}
        //return getTextAttribute(this.address, UNUM_POSITIVE_PREFIX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.411 -0400", hash_original_method = "6CFE84E5B71B94B0DE7447BA68FEA246", hash_generated_method = "3898E94EDAE1690AFCCBCB4109A60CFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPositiveSuffix() {
        String varAB469852ABFF57F90F2AEBFC25BFF4F8_1577167096 = (getTextAttribute(this.address, UNUM_POSITIVE_SUFFIX));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (posSuffNull) {
            //return null;
        //}
        //return getTextAttribute(this.address, UNUM_POSITIVE_SUFFIX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.411 -0400", hash_original_method = "F9B59ECC893A5B014F6155ABE9703BF1", hash_generated_method = "B37C884FB4780FC3E264DB5269199EEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDecimalSeparatorAlwaysShown() {
        boolean var3E4313CD429F3F78E13F34D688881F5E_1867137008 = (getAttribute(this.address, UNUM_DECIMAL_ALWAYS_SHOWN) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_DECIMAL_ALWAYS_SHOWN) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.411 -0400", hash_original_method = "84561142CC409560F18895112EB228ED", hash_generated_method = "00BD6223A4DD4E0A0802E9FEBE31725E")
    @DSModeled(DSC.SAFE)
    public boolean isParseBigDecimal() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return parseBigDecimal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.411 -0400", hash_original_method = "1D326E5349B9E5A9AED64258AB68CB41", hash_generated_method = "567084413F163FCEDA6B9DF90EF60795")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isParseIntegerOnly() {
        boolean var58CA17599706E2BD9D06C2CCBA6B89AB_616743937 = (getAttribute(this.address, UNUM_PARSE_INT_ONLY) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_PARSE_INT_ONLY) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.411 -0400", hash_original_method = "00E8502D2DA3C0C73215E5BC5979A07C", hash_generated_method = "0E35FA03BAD74D100206C30E64EA2297")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isGroupingUsed() {
        boolean var875BD0DB8C0EE50D68D0C6793AE8DABD_772943881 = (getAttribute(this.address, UNUM_GROUPING_USED) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_GROUPING_USED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.411 -0400", hash_original_method = "4515EB7BD614742B3D0DDD5748BC74D6", hash_generated_method = "B4FBD1FFFEA808F381E34846D1D0A484")
    @DSModeled(DSC.SAFE)
    public void setDecimalSeparatorAlwaysShown(boolean value) {
        dsTaint.addTaint(value);
        int i;
        i = -1;
        i = 0;
        setAttribute(this.address, UNUM_DECIMAL_ALWAYS_SHOWN, i);
        // ---------- Original Method ----------
        //int i = value ? -1 : 0;
        //setAttribute(this.address, UNUM_DECIMAL_ALWAYS_SHOWN, i);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.411 -0400", hash_original_method = "27959CC6793546F59976E7DBD15119DA", hash_generated_method = "5CC16CCB027CB78B3B04BC90DAA6DF0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCurrency(Currency currency) {
        dsTaint.addTaint(currency.dsTaint);
        setSymbol(this.address, UNUM_CURRENCY_SYMBOL, currency.getSymbol());
        setSymbol(this.address, UNUM_INTL_CURRENCY_SYMBOL, currency.getCurrencyCode());
        // ---------- Original Method ----------
        //setSymbol(this.address, UNUM_CURRENCY_SYMBOL, currency.getSymbol());
        //setSymbol(this.address, UNUM_INTL_CURRENCY_SYMBOL, currency.getCurrencyCode());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.411 -0400", hash_original_method = "49FEA0DFBB56F17CB90E68E0F78CE577", hash_generated_method = "374CD3231275FE1A4665B8571EF74084")
    @DSModeled(DSC.SAFE)
    public void setGroupingSize(int value) {
        dsTaint.addTaint(value);
        setAttribute(this.address, UNUM_GROUPING_SIZE, value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_GROUPING_SIZE, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.411 -0400", hash_original_method = "E302CDF79A67421C2D7FEEF4C305D93F", hash_generated_method = "94C9B23682AE2D896883BD05D8F862BF")
    @DSModeled(DSC.SAFE)
    public void setGroupingUsed(boolean value) {
        dsTaint.addTaint(value);
        int i;
        i = -1;
        i = 0;
        setAttribute(this.address, UNUM_GROUPING_USED, i);
        // ---------- Original Method ----------
        //int i = value ? -1 : 0;
        //setAttribute(this.address, UNUM_GROUPING_USED, i);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.411 -0400", hash_original_method = "758C6DB93C92764527C1135AD7160507", hash_generated_method = "7B32D609889FD076CEFFD07465FD7579")
    @DSModeled(DSC.SAFE)
    public void setMaximumFractionDigits(int value) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(value);
        setAttribute(this.address, UNUM_MAX_FRACTION_DIGITS, value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_MAX_FRACTION_DIGITS, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.411 -0400", hash_original_method = "89C5389B02F633081323A23C8FB84870", hash_generated_method = "B755B561C835310CE5877F9EFBC011F7")
    @DSModeled(DSC.SAFE)
    public void setMaximumIntegerDigits(int value) {
        dsTaint.addTaint(value);
        setAttribute(this.address, UNUM_MAX_INTEGER_DIGITS, value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_MAX_INTEGER_DIGITS, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.411 -0400", hash_original_method = "62DF7CF1343955ADCD931CBCC029C545", hash_generated_method = "C7EF630EE12A6EF2733F666819B98BAE")
    @DSModeled(DSC.SAFE)
    public void setMinimumFractionDigits(int value) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(value);
        setAttribute(this.address, UNUM_MIN_FRACTION_DIGITS, value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_MIN_FRACTION_DIGITS, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.412 -0400", hash_original_method = "5D466EF26E9A120396C63069DE20CEB4", hash_generated_method = "95235209CA15AF5B1B77BCA008538CF9")
    @DSModeled(DSC.SAFE)
    public void setMinimumIntegerDigits(int value) {
        dsTaint.addTaint(value);
        setAttribute(this.address, UNUM_MIN_INTEGER_DIGITS, value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_MIN_INTEGER_DIGITS, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.412 -0400", hash_original_method = "B169BA3B31B9F8AB850C7AD451D65C7F", hash_generated_method = "41CA6ADB58427DF04D55EB4EE5671248")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMultiplier(int value) {
        dsTaint.addTaint(value);
        setAttribute(this.address, UNUM_MULTIPLIER, value);
        multiplierBigDecimal = BigDecimal.valueOf(value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_MULTIPLIER, value);
        //multiplierBigDecimal = BigDecimal.valueOf(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.412 -0400", hash_original_method = "74BB5921C2CC61F7BCF8D1B8841FD51E", hash_generated_method = "3BEC9578904BC4E1BA1F61F80AF212C6")
    @DSModeled(DSC.SAFE)
    public void setNegativePrefix(String value) {
        dsTaint.addTaint(value);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.412 -0400", hash_original_method = "0FF0A51DFB17D23D2B0F182081F1472B", hash_generated_method = "038C7301A3F6CE0B72BAEA4C348A7F65")
    @DSModeled(DSC.SAFE)
    public void setNegativeSuffix(String value) {
        dsTaint.addTaint(value);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.412 -0400", hash_original_method = "FC20737C410620F82F4CED74F1142CF3", hash_generated_method = "6BB3A7A943E956BC73CA3CB8EC97D145")
    @DSModeled(DSC.SAFE)
    public void setPositivePrefix(String value) {
        dsTaint.addTaint(value);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.412 -0400", hash_original_method = "48A175BA83D370BA86128EC6BAC61CB5", hash_generated_method = "ED43D299F274DDB2E679C7DD90F0252A")
    @DSModeled(DSC.SAFE)
    public void setPositiveSuffix(String value) {
        dsTaint.addTaint(value);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.412 -0400", hash_original_method = "16B3A7386DF3851CB73D32D9A838D98B", hash_generated_method = "123F6FD1B6B4B3B931538D38FFF1C689")
    @DSModeled(DSC.SAFE)
    public void setParseBigDecimal(boolean value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //parseBigDecimal = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.412 -0400", hash_original_method = "7FF47C5BC2EFAEE27B26A852A846EAFB", hash_generated_method = "11E84768C86DA5AC10450B00F397D023")
    @DSModeled(DSC.SAFE)
    public void setParseIntegerOnly(boolean value) {
        dsTaint.addTaint(value);
        int i;
        i = -1;
        i = 0;
        setAttribute(this.address, UNUM_PARSE_INT_ONLY, i);
        // ---------- Original Method ----------
        //int i = value ? -1 : 0;
        //setAttribute(this.address, UNUM_PARSE_INT_ONLY, i);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.412 -0400", hash_original_method = "B8DBC7D049D3B4F244E4AF6EDA028CBA", hash_generated_method = "BFE675F82DDB4D186B8A5179A21EF157")
    private static void applyPattern(int addr, boolean localized, String pattern) {
        try {
            applyPatternImpl(addr, localized, pattern);
        } catch (NullPointerException npe) {
            throw npe;
        } catch (RuntimeException re) {
            throw new IllegalArgumentException("syntax error: " + re.getMessage() + ": " + pattern);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.412 -0400", hash_original_method = "D542BB733096020C1E39876D678697A7", hash_generated_method = "0CB5B02D324A8443CFAFED3FC3B6C1BC")
    @DSModeled(DSC.SAFE)
    public void setRoundingMode(RoundingMode roundingMode, double roundingIncrement) {
        dsTaint.addTaint(roundingMode.dsTaint);
        dsTaint.addTaint(roundingIncrement);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.412 -0400", hash_original_method = "89F62B688ECDE3121536CA739962871B", hash_generated_method = "31F632A764DB59CC1E5A7C7799308E84")
    private static void applyPatternImpl(int addr, boolean localized, String pattern) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.412 -0400", hash_original_method = "676D307481E0FF73AF2EAFE44D354043", hash_generated_method = "AAF78712BBEF14695FD7EBFAB9329EE2")
    private static int cloneImpl(int addr) {
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.412 -0400", hash_original_method = "A0AC48CCD57EF1310C2A722A4B9F953A", hash_generated_method = "EFDACCC4EBF587284D49C2C0FBF7D6E0")
    private static void close(int addr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.412 -0400", hash_original_method = "78AA77AC4B49C61676697E6151D87C9E", hash_generated_method = "FA8C10B6C343DE44B40D1B62F9D30A11")
    private static char[] formatLong(int addr, long value, FieldPositionIterator iter) {
    	char[] retVal = {DSUtils.UNKNOWN_CHAR};
    	return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.412 -0400", hash_original_method = "80E8389781C960208B10710AC7F75DDD", hash_generated_method = "A26E54F40BAE732CA53D1A30BAB32FED")
    private static char[] formatDouble(int addr, double value, FieldPositionIterator iter) {
    	char[] retVal = {DSUtils.UNKNOWN_CHAR};
    	return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.412 -0400", hash_original_method = "39E98461A60276718905EDF97F976364", hash_generated_method = "3579274BD51A646B869128C10DB38B31")
    private static char[] formatDigitList(int addr, String value, FieldPositionIterator iter) {
    	char[] retVal = {DSUtils.UNKNOWN_CHAR};
    	return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.412 -0400", hash_original_method = "C45D1178C4E1B6B9AF7F4F7CA7A46697", hash_generated_method = "A6F7A245FB574EE4183FCECC7180713B")
    private static int getAttribute(int addr, int symbol) {
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.412 -0400", hash_original_method = "E4FB143F9FEC9AD4FDFF264E83C99080", hash_generated_method = "7DA01D5C4946D00C913521AB06709E40")
    private static String getTextAttribute(int addr, int symbol) {
    	return DSUtils.UNKNOWN_STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.412 -0400", hash_original_method = "C82BB64EBC92B5A431C1CB17296EE6FE", hash_generated_method = "AE32BEB1E7AF5AB4BC94FAD88CA181BB")
    private static int open(String pattern, String currencySymbol,
            char decimalSeparator, char digit, String exponentSeparator, char groupingSeparator,
            String infinity, String internationalCurrencySymbol, char minusSign,
            char monetaryDecimalSeparator, String nan, char patternSeparator, char percent,
            char perMill, char zeroDigit) {
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.412 -0400", hash_original_method = "37D1A239E34B82C53C1FC2AD13C180A4", hash_generated_method = "851D6DD9FA0ADF1E6C23ACC18C6A471F")
    private static Number parse(int addr, String string, ParsePosition position, boolean parseBigDecimal) {
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.412 -0400", hash_original_method = "38562CBD2066CE9BED66E439CD153C28", hash_generated_method = "7F59CB812B1882FE9180CDF81CDEC653")
    private static void setDecimalFormatSymbols(int addr, String currencySymbol,
            char decimalSeparator, char digit, String exponentSeparator, char groupingSeparator,
            String infinity, String internationalCurrencySymbol, char minusSign,
            char monetaryDecimalSeparator, String nan, char patternSeparator, char percent,
            char perMill, char zeroDigit) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.413 -0400", hash_original_method = "C6525103B23425151F0DF63C2E7B2CB9", hash_generated_method = "829963D45CF0545D10BFD69E6847A287")
    private static void setSymbol(int addr, int symbol, String str) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.413 -0400", hash_original_method = "9CF64A50E62500CEB8D69C0D8703D8DF", hash_generated_method = "51F89FC90F6B3CB5596DA3FF65B5CF8D")
    private static void setAttribute(int addr, int symbol, int i) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.413 -0400", hash_original_method = "B25ED26F96CD53325B9498187078B093", hash_generated_method = "92A29CB3332EABA6C521D17F65CEDE40")
    private static void setRoundingMode(int addr, int roundingMode, double roundingIncrement) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.413 -0400", hash_original_method = "C053560EFBE0BC86C317DA675BA27ABC", hash_generated_method = "228D7DA8EA92840DA12A250344E54A04")
    private static void setTextAttribute(int addr, int symbol, String str) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.413 -0400", hash_original_method = "9F1956A5D5A29CC5DA084485ACF2BCBE", hash_generated_method = "4DC63F6103A0854B923462952765C11A")
    private static String toPatternImpl(int addr, boolean localized) {
    	return DSUtils.UNKNOWN_STRING;
    }

    
    private static class FieldPositionIterator {
        private int[] data;
        private int pos = -3;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.413 -0400", hash_original_method = "3872533C5F4C6DF8E9B47456E87ABB09", hash_generated_method = "5CE17BADFB8C1C142C099118F197187E")
        @DSModeled(DSC.SAFE)
        private FieldPositionIterator() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.413 -0400", hash_original_method = "384C091DF106F888683239832F6FD964", hash_generated_method = "6E57EE53987910BAFF7C36723A8DA958")
        public static FieldPositionIterator forFieldPosition(FieldPosition fp) {
            if (fp != null && fp.getField() != -1) {
                return new FieldPositionIterator();
            }
            return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.413 -0400", hash_original_method = "FD8765DDE780B1145300BBF4C2302309", hash_generated_method = "15EF6E251A385B7D2C88565CC94E5972")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.413 -0400", hash_original_method = "13170E88DCF158569D1B5B022C52EFDB", hash_generated_method = "F504E1C940AD6AE890288E0944365B7A")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.413 -0400", hash_original_method = "F9CA7CA9C759396A69CAFCECCE3A38CE", hash_generated_method = "8378E8FC85C9803B21D89A3A449E229E")
        @DSModeled(DSC.SAFE)
        public boolean next() {
            {
            	if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            pos += 3;
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (data == null || pos == data.length) {
                //throw new NoSuchElementException();
            //}
            //pos += 3;
            //return pos < data.length;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.413 -0400", hash_original_method = "28A52A04516ACAEA5CBE057E7005DC29", hash_generated_method = "3F3F2DDD3A606680C2F537B4002B1FF2")
        @DSModeled(DSC.SAFE)
        private void checkValid() {
            {
                throw new NoSuchElementException();
            } //End block
            // ---------- Original Method ----------
            //if (data == null || pos < 0 || pos == data.length) {
                //throw new NoSuchElementException();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.413 -0400", hash_original_method = "F481D50CCC1AB38B4CA6D00583ECCD74", hash_generated_method = "526249E65D04D289C631D841D7CC3845")
        @DSModeled(DSC.SAFE)
        public int fieldId() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return data[pos];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.413 -0400", hash_original_method = "B152D64258DA85AB1020B78F45482139", hash_generated_method = "0CE2FA0D5CF4A972DE047DE97BA39E4E")
        @DSModeled(DSC.SAFE)
        public Format.Field field() {
            checkValid();
            return (Format.Field)dsTaint.getTaint();
            // ---------- Original Method ----------
            //checkValid();
            //return fields[data[pos]];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.413 -0400", hash_original_method = "573D89586F74B4B2EDB6530AAE1DEC79", hash_generated_method = "2B817D24CCBB6A81DC129A7669EE19C4")
        @DSModeled(DSC.SAFE)
        public int start() {
            checkValid();
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //checkValid();
            //return data[pos + 1];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.413 -0400", hash_original_method = "431D149304BC1F14DB944F0790F3E8B8", hash_generated_method = "EFCC13C884AF2F81F0026D4AC8B0436B")
        @DSModeled(DSC.SAFE)
        public int limit() {
            checkValid();
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //checkValid();
            //return data[pos + 2];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.413 -0400", hash_original_method = "E1A3B20A4A62E5F6661DF7F73A635F7C", hash_generated_method = "2C6C75B8227D48EDBC4588072D724B2D")
        @DSModeled(DSC.SAFE)
        private void setData(int[] data) {
            dsTaint.addTaint(data);
            this.pos = -3;
            // ---------- Original Method ----------
            //this.data = data;
            //this.pos = -3;
        }

        
    }


    
}


