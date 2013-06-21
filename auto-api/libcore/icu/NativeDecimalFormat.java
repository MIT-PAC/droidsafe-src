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
    private int address;
    private String lastPattern;
    private boolean negPrefNull;
    private boolean negSuffNull;
    private boolean posPrefNull;
    private boolean posSuffNull;
    private transient boolean parseBigDecimal;
    private BigDecimal multiplierBigDecimal = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.687 -0400", hash_original_method = "D8AEBC26DB4CF2E0C933D0F5B84F659E", hash_generated_method = "C4A520DDE28740CB697AB4655955974D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.688 -0400", hash_original_method = "03415942CECEA3C928FA024ACF038523", hash_generated_method = "0112E6ADE0333DBB82F367AF88449802")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.688 -0400", hash_original_method = "F2FB63D256AD622AD0AA1906E5944DB2", hash_generated_method = "6CDBF5EC457E4EF8154853822E2AF7BF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.688 -0400", hash_original_method = "C197288C8DD3954567266901B60BE5B8", hash_generated_method = "0D604498FD8B1A3A6B8DFFEFD74AFA97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var8C9A345D8B4C41F5F6C3E9546CE693DB_1397041253 = (this.getPositivePrefix().hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.getPositivePrefix().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.688 -0400", hash_original_method = "5C171A463B7BB08FCE40648C7CE8F861", hash_generated_method = "36CAD6210CFA016FE9122A2E563AE993")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.689 -0400", hash_original_method = "D252F6FD4E111780C248C256B2516FF2", hash_generated_method = "F1E52126C2A63819215E1C41A44174C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        Object varE5ECDB3C3A81C14F1DB2815D857D5EB4_653818178 = (new NativeDecimalFormat(this));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new NativeDecimalFormat(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.689 -0400", hash_original_method = "220130DBC584D5B5D45771D972950D18", hash_generated_method = "9449D1E60C79045D654C2CB42CB33683")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        {
            boolean var3F549205D4C262003697A031F89E5954_1820104083 = (object == this);
        } //End collapsed parenthetic
        NativeDecimalFormat obj;
        obj = (NativeDecimalFormat) object;
        boolean var18FBB52F731808A4077D23FDD981869A_2024503498 = (obj.toPattern().equals(this.toPattern()) &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.689 -0400", hash_original_method = "6B8DF144F51335DB9B33B1BD0598F087", hash_generated_method = "7F4792758893E340779973483A57EB86")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.690 -0400", hash_original_method = "5FE0177EB5130C508ECEC468A64D96E3", hash_generated_method = "A3CD1E5F28A716952AFC9622E323E9F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.690 -0400", hash_original_method = "E3DC36059DBEEA918EB4DAC2E3F69056", hash_generated_method = "2769264E0D0EDB231A76FE60A5CB084E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.690 -0400", hash_original_method = "AB58B0DEED1650663505F868BCDB9A76", hash_generated_method = "60B13A506EB7E5E5DB2AA86C2ABDAC72")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.690 -0400", hash_original_method = "E280C21CEDC9C41E32AB3781E6354849", hash_generated_method = "762A5AB213B96F6C93D71D503ED969AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.691 -0400", hash_original_method = "2B822D9FBF334F04026E765F63D8EA7D", hash_generated_method = "C11D43A876E1AE18B39E8B1409FAF638")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.691 -0400", hash_original_method = "521D68694A0F2FF9FD004D1F044248B6", hash_generated_method = "15EA8FEB5633EAF3BD0737FC0541B606")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void applyLocalizedPattern(String pattern) {
        dsTaint.addTaint(pattern);
        applyPattern(this.address, true, pattern);
        lastPattern = null;
        // ---------- Original Method ----------
        //applyPattern(this.address, true, pattern);
        //lastPattern = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.691 -0400", hash_original_method = "105E6A8350C3ECD2CBDC93E6E74AA17C", hash_generated_method = "DC76DF653FAA7B8214F0AD0900D5E191")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void applyPattern(String pattern) {
        dsTaint.addTaint(pattern);
        {
            boolean var30056E56F7633573B6C2DD284E929162_1383915805 = (lastPattern != null && pattern.equals(lastPattern));
        } //End collapsed parenthetic
        applyPattern(this.address, false, pattern);
        // ---------- Original Method ----------
        //if (lastPattern != null && pattern.equals(lastPattern)) {
            //return;
        //}
        //applyPattern(this.address, false, pattern);
        //lastPattern = pattern;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.691 -0400", hash_original_method = "9FEF3AE5E61C347D525A9585FBE19ECF", hash_generated_method = "70D3287D0F424EABC275EB2A82316594")
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
            boolean varC94C796D691F3725A70F62B7F781E92F_755436807 = (fpIter.next());
            {
                Format.Field field;
                field = fpIter.field();
                as.addAttribute(field, field, fpIter.start(), fpIter.limit());
            } //End block
        } //End collapsed parenthetic
        AttributedCharacterIterator varC17B74234B5E841D682B5933E83FF653_424762228 = (as.getIterator());
        return (AttributedCharacterIterator)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.692 -0400", hash_original_method = "E9B105AB178BFBFEB280AF82F381CE84", hash_generated_method = "800771F8D203EDA3086218E886B8F3DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.692 -0400", hash_original_method = "1F42A3AAFB142AE620B1A14F6DE6CCC5", hash_generated_method = "4A0B79814194ECA0AEAE053DE9EC55C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toLocalizedPattern() {
        String varD9D03409EABA9668051F440E80015FF6_835422167 = (toPatternImpl(this.address, true));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return toPatternImpl(this.address, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.692 -0400", hash_original_method = "D90F2C106608034D601A7F076DF301BD", hash_generated_method = "A9E14302E422116E71194F394B75640E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toPattern() {
        String var8084429E32D1F969F87AFC56450ED8FA_44642855 = (toPatternImpl(this.address, false));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return toPatternImpl(this.address, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.692 -0400", hash_original_method = "C24C75386265F50BCF75B046D9BE3ACC", hash_generated_method = "52B7509E75E339A587D62E8BE1DB3919")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Number parse(String string, ParsePosition position) {
        dsTaint.addTaint(position.dsTaint);
        dsTaint.addTaint(string);
        Number var5749C7280422D3FE838D39A428497A88_755674098 = (parse(address, string, position, parseBigDecimal));
        return (Number)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return parse(address, string, position, parseBigDecimal);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.692 -0400", hash_original_method = "00B4402833BBD0AA4B8B3DAC69045BF5", hash_generated_method = "E3E32E65CB102B9FF3B4A9FECD1B14B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMaximumFractionDigits() {
        int var2031882FA64042FA8714F056BC326B77_276070490 = (getAttribute(this.address, UNUM_MAX_FRACTION_DIGITS));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_MAX_FRACTION_DIGITS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.693 -0400", hash_original_method = "39458F699020062C4A2A7E5A13FEC803", hash_generated_method = "4C7617FCE374C73BBDC367C623F72874")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMaximumIntegerDigits() {
        int var552BC4AA7CD66CB5C86DC39DD6F5EB61_592303362 = (getAttribute(this.address, UNUM_MAX_INTEGER_DIGITS));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_MAX_INTEGER_DIGITS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.693 -0400", hash_original_method = "2493C2169723FB0932E2841ED5413767", hash_generated_method = "696C84FF07679E7383CB08013B211337")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMinimumFractionDigits() {
        int var651D9F7029A8FF147A685A36D32AA845_1017225184 = (getAttribute(this.address, UNUM_MIN_FRACTION_DIGITS));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_MIN_FRACTION_DIGITS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.693 -0400", hash_original_method = "C287E89D9CA249987BAB41DA58A603BE", hash_generated_method = "41760382730AA3B077012947DF86BCF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMinimumIntegerDigits() {
        int varE7531A98F2A0AD2779754CD1B2865E0B_999423305 = (getAttribute(this.address, UNUM_MIN_INTEGER_DIGITS));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_MIN_INTEGER_DIGITS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.693 -0400", hash_original_method = "C63E831A66DAEA25345E39BD0E8C902A", hash_generated_method = "AF3C2F7B1752BE259B9AA7FBE9D1D63D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getGroupingSize() {
        int varEBCCDDFF415DDB22660365F0FC4A83FC_1088280489 = (getAttribute(this.address, UNUM_GROUPING_SIZE));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_GROUPING_SIZE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.693 -0400", hash_original_method = "195B15A30ECFDD2DA316EFD7F1135C74", hash_generated_method = "FE6667CCAAAFDFB809BFAFA99C3E809E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMultiplier() {
        int var2028C5EE807D8F87AD09F7ADE0783DF7_1393775704 = (getAttribute(this.address, UNUM_MULTIPLIER));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_MULTIPLIER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.693 -0400", hash_original_method = "6BE8F2BF8B3A5604EA6D6E250F279823", hash_generated_method = "FA6D2A742422FA796EA0E1EEE5A98460")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getNegativePrefix() {
        String var34254ADEEA9812EA9A118EEE5F0FFA5D_183253994 = (getTextAttribute(this.address, UNUM_NEGATIVE_PREFIX));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (negPrefNull) {
            //return null;
        //}
        //return getTextAttribute(this.address, UNUM_NEGATIVE_PREFIX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.694 -0400", hash_original_method = "3B3EF8E26C12E3D51B48D0C30732D5F5", hash_generated_method = "DF1A9B18D7246B1EEC5EDD39346D993C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getNegativeSuffix() {
        String varFF6E831F375FB4D540B92A08CB4F4FCF_1939463822 = (getTextAttribute(this.address, UNUM_NEGATIVE_SUFFIX));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (negSuffNull) {
            //return null;
        //}
        //return getTextAttribute(this.address, UNUM_NEGATIVE_SUFFIX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.694 -0400", hash_original_method = "8D4D6B90A746E09AE36173ABA0AB4B15", hash_generated_method = "7C2D07E1F7FA98DCDD7E7CA9B84420A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPositivePrefix() {
        String var1A9101840B75568C120D24519801CE9B_34391927 = (getTextAttribute(this.address, UNUM_POSITIVE_PREFIX));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (posPrefNull) {
            //return null;
        //}
        //return getTextAttribute(this.address, UNUM_POSITIVE_PREFIX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.694 -0400", hash_original_method = "6CFE84E5B71B94B0DE7447BA68FEA246", hash_generated_method = "EF6E58A009D8B2B26C0E5BC554F35852")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPositiveSuffix() {
        String varAB469852ABFF57F90F2AEBFC25BFF4F8_1067632841 = (getTextAttribute(this.address, UNUM_POSITIVE_SUFFIX));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (posSuffNull) {
            //return null;
        //}
        //return getTextAttribute(this.address, UNUM_POSITIVE_SUFFIX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.694 -0400", hash_original_method = "F9B59ECC893A5B014F6155ABE9703BF1", hash_generated_method = "31DA1723C0CCDEC6EC3A029B19BAB863")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDecimalSeparatorAlwaysShown() {
        boolean var3E4313CD429F3F78E13F34D688881F5E_1614339664 = (getAttribute(this.address, UNUM_DECIMAL_ALWAYS_SHOWN) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_DECIMAL_ALWAYS_SHOWN) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.695 -0400", hash_original_method = "84561142CC409560F18895112EB228ED", hash_generated_method = "2B84A228DFE9DAE266FAC43B11C26289")
    @DSModeled(DSC.SAFE)
    public boolean isParseBigDecimal() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return parseBigDecimal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.695 -0400", hash_original_method = "1D326E5349B9E5A9AED64258AB68CB41", hash_generated_method = "69918FF4926E22603ACAF364EA3F0D15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isParseIntegerOnly() {
        boolean var58CA17599706E2BD9D06C2CCBA6B89AB_1460566703 = (getAttribute(this.address, UNUM_PARSE_INT_ONLY) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_PARSE_INT_ONLY) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.695 -0400", hash_original_method = "00E8502D2DA3C0C73215E5BC5979A07C", hash_generated_method = "38C3B33859196E86EFC18DF918349B06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isGroupingUsed() {
        boolean var875BD0DB8C0EE50D68D0C6793AE8DABD_578473104 = (getAttribute(this.address, UNUM_GROUPING_USED) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_GROUPING_USED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.695 -0400", hash_original_method = "4515EB7BD614742B3D0DDD5748BC74D6", hash_generated_method = "5B9C98892640F37D5A85B9440A770F83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.695 -0400", hash_original_method = "27959CC6793546F59976E7DBD15119DA", hash_generated_method = "C629B4544F9B9C539C68B2895C17D141")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCurrency(Currency currency) {
        dsTaint.addTaint(currency.dsTaint);
        setSymbol(this.address, UNUM_CURRENCY_SYMBOL, currency.getSymbol());
        setSymbol(this.address, UNUM_INTL_CURRENCY_SYMBOL, currency.getCurrencyCode());
        // ---------- Original Method ----------
        //setSymbol(this.address, UNUM_CURRENCY_SYMBOL, currency.getSymbol());
        //setSymbol(this.address, UNUM_INTL_CURRENCY_SYMBOL, currency.getCurrencyCode());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.695 -0400", hash_original_method = "49FEA0DFBB56F17CB90E68E0F78CE577", hash_generated_method = "D8E26CB98D42F6C3297E34F49BD26B4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setGroupingSize(int value) {
        dsTaint.addTaint(value);
        setAttribute(this.address, UNUM_GROUPING_SIZE, value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_GROUPING_SIZE, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.696 -0400", hash_original_method = "E302CDF79A67421C2D7FEEF4C305D93F", hash_generated_method = "5A0EC0F4FBDC15F2FA2D9F0780671C37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.696 -0400", hash_original_method = "758C6DB93C92764527C1135AD7160507", hash_generated_method = "2FFAB728C829B306D60782489516813B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMaximumFractionDigits(int value) {
        dsTaint.addTaint(value);
        setAttribute(this.address, UNUM_MAX_FRACTION_DIGITS, value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_MAX_FRACTION_DIGITS, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.696 -0400", hash_original_method = "89C5389B02F633081323A23C8FB84870", hash_generated_method = "7293D99E4D6A1ECED3C3E2F1B8BBFFCE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMaximumIntegerDigits(int value) {
        dsTaint.addTaint(value);
        setAttribute(this.address, UNUM_MAX_INTEGER_DIGITS, value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_MAX_INTEGER_DIGITS, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.696 -0400", hash_original_method = "62DF7CF1343955ADCD931CBCC029C545", hash_generated_method = "3636185E24AAB866B2B75773EF44751E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMinimumFractionDigits(int value) {
        dsTaint.addTaint(value);
        setAttribute(this.address, UNUM_MIN_FRACTION_DIGITS, value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_MIN_FRACTION_DIGITS, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.696 -0400", hash_original_method = "5D466EF26E9A120396C63069DE20CEB4", hash_generated_method = "46A3424B5D501647FDA694640C69B79E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMinimumIntegerDigits(int value) {
        dsTaint.addTaint(value);
        setAttribute(this.address, UNUM_MIN_INTEGER_DIGITS, value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_MIN_INTEGER_DIGITS, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.696 -0400", hash_original_method = "B169BA3B31B9F8AB850C7AD451D65C7F", hash_generated_method = "5E6DE65F536DBF4D9E7852F40475118B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMultiplier(int value) {
        dsTaint.addTaint(value);
        setAttribute(this.address, UNUM_MULTIPLIER, value);
        multiplierBigDecimal = BigDecimal.valueOf(value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_MULTIPLIER, value);
        //multiplierBigDecimal = BigDecimal.valueOf(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.697 -0400", hash_original_method = "74BB5921C2CC61F7BCF8D1B8841FD51E", hash_generated_method = "6E4F1803144D56F2467BDB9DA54C8BBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.697 -0400", hash_original_method = "0FF0A51DFB17D23D2B0F182081F1472B", hash_generated_method = "7432B5973388C4469A7B2E696E18E81A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.697 -0400", hash_original_method = "FC20737C410620F82F4CED74F1142CF3", hash_generated_method = "2383CE19D8105C61859F600A40CEFA43")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.697 -0400", hash_original_method = "48A175BA83D370BA86128EC6BAC61CB5", hash_generated_method = "DF77D20E084E5EB90FC4632C353189B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.697 -0400", hash_original_method = "16B3A7386DF3851CB73D32D9A838D98B", hash_generated_method = "372C7601585120F128895C78EBCC97D4")
    @DSModeled(DSC.SAFE)
    public void setParseBigDecimal(boolean value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //parseBigDecimal = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.698 -0400", hash_original_method = "7FF47C5BC2EFAEE27B26A852A846EAFB", hash_generated_method = "F199346329450935BA3D8FFCE6CC06E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
        private static void applyPattern(int addr, boolean localized, String pattern) {
        try {
            applyPatternImpl(addr, localized, pattern);
        } catch (NullPointerException npe) {
            throw npe;
        } catch (RuntimeException re) {
            throw new IllegalArgumentException("syntax error: " + re.getMessage() + ": " + pattern);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.698 -0400", hash_original_method = "D542BB733096020C1E39876D678697A7", hash_generated_method = "873B239BA6FC2A8BF854220C5FF3C054")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
        private static void applyPatternImpl(int addr, boolean localized, String pattern) {
    }

    
        private static int cloneImpl(int addr) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void close(int addr) {
    }

    
        private static char[] formatLong(int addr, long value, FieldPositionIterator iter) {
        char[] retVal = {DSUtils.UNKNOWN_CHAR};
        return retVal;
    }

    
        private static char[] formatDouble(int addr, double value, FieldPositionIterator iter) {
        char[] retVal = {DSUtils.UNKNOWN_CHAR};
        return retVal;
    }

    
        private static char[] formatDigitList(int addr, String value, FieldPositionIterator iter) {
        char[] retVal = {DSUtils.UNKNOWN_CHAR};
        return retVal;
    }

    
        private static int getAttribute(int addr, int symbol) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static String getTextAttribute(int addr, int symbol) {
        return DSUtils.UNKNOWN_STRING;
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
        return DSUtils.UNKNOWN_STRING;
    }

    
    private static class FieldPositionIterator {
        private int[] data;
        private int pos = -3;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.702 -0400", hash_original_method = "3872533C5F4C6DF8E9B47456E87ABB09", hash_generated_method = "61C6C4E209B2EB1D194185007E303529")
        @DSModeled(DSC.SAFE)
        private FieldPositionIterator() {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.703 -0400", hash_original_method = "F9CA7CA9C759396A69CAFCECCE3A38CE", hash_generated_method = "CAE1682AA0FED0F7177B28EAAA9EDB44")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.703 -0400", hash_original_method = "28A52A04516ACAEA5CBE057E7005DC29", hash_generated_method = "5DF96E6E92B6CC3D8098CC728AFF2BD8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void checkValid() {
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            // ---------- Original Method ----------
            //if (data == null || pos < 0 || pos == data.length) {
                //throw new NoSuchElementException();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.703 -0400", hash_original_method = "F481D50CCC1AB38B4CA6D00583ECCD74", hash_generated_method = "5EDEE0302FA978199FBD740E5CFDC1A1")
        @DSModeled(DSC.SAFE)
        public int fieldId() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return data[pos];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.703 -0400", hash_original_method = "B152D64258DA85AB1020B78F45482139", hash_generated_method = "03C6D80174E2BBF1ADA4154D95AC040C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Format.Field field() {
            checkValid();
            return (Format.Field)dsTaint.getTaint();
            // ---------- Original Method ----------
            //checkValid();
            //return fields[data[pos]];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.704 -0400", hash_original_method = "573D89586F74B4B2EDB6530AAE1DEC79", hash_generated_method = "17470B603A79E9032EE8929E916816B7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int start() {
            checkValid();
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //checkValid();
            //return data[pos + 1];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.704 -0400", hash_original_method = "431D149304BC1F14DB944F0790F3E8B8", hash_generated_method = "4DA1132BC8193E07ED38316FD992EF51")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int limit() {
            checkValid();
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //checkValid();
            //return data[pos + 2];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.704 -0400", hash_original_method = "E1A3B20A4A62E5F6661DF7F73A635F7C", hash_generated_method = "AD4E4FCED2570085FBDDEA9F48C3AF4C")
        @DSModeled(DSC.SAFE)
        private void setData(int[] data) {
            dsTaint.addTaint(data[0]);
            this.pos = -3;
            // ---------- Original Method ----------
            //this.data = data;
            //this.pos = -3;
        }

        
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
}

