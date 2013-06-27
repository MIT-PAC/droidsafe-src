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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.232 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "849BAB492558B51E7BC4F1C331A435E4")

    private int address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.232 -0400", hash_original_field = "344BCC24F3464715940DD56604C8D74D", hash_generated_field = "5F7D5D3D7F66CE031779F4BACE74C549")

    private String lastPattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.232 -0400", hash_original_field = "FE0C344D27B5DDD52EE172F18436517A", hash_generated_field = "A56A7DCB118482C05DDF4AEBE99FDB15")

    private boolean negPrefNull;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.232 -0400", hash_original_field = "847370D067A7C3F3858025EC1AE68504", hash_generated_field = "2505E1D75E0C167EE76E4EF5DDA36BE9")

    private boolean negSuffNull;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.232 -0400", hash_original_field = "61EA484D190CD4F0A57205D48CFCE039", hash_generated_field = "CDAAA116F4BD28B5162A921B2B1BA25F")

    private boolean posPrefNull;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.232 -0400", hash_original_field = "C30F6031C7DF0B30F08B2845ADE90423", hash_generated_field = "E9F9066E16BD9AB176D3C016B62231F0")

    private boolean posSuffNull;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.232 -0400", hash_original_field = "287D1050A38F78BCF10BE8BDFB1C701E", hash_generated_field = "622CB2D56C22AE9A04568955FFFF4B33")

    private transient boolean parseBigDecimal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.232 -0400", hash_original_field = "EBBDEA416E09F573B73D6D6E43EF5083", hash_generated_field = "C24355A01F90DF3021CC166940F4BB14")

    private BigDecimal multiplierBigDecimal = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.233 -0400", hash_original_method = "D8AEBC26DB4CF2E0C933D0F5B84F659E", hash_generated_method = "A534F428BF436EFFCF7D5C20409BC3AD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.233 -0400", hash_original_method = "03415942CECEA3C928FA024ACF038523", hash_generated_method = "D2E674819D4F909C96BFFA4F1D82A4EF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.234 -0400", hash_original_method = "F2FB63D256AD622AD0AA1906E5944DB2", hash_generated_method = "5AAFFDF8705B718E89082099B750E33B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.234 -0400", hash_original_method = "C197288C8DD3954567266901B60BE5B8", hash_generated_method = "C2848881BBFC43EF56BC17CEB02BA3A8")
    @Override
    public int hashCode() {
        int var8C9A345D8B4C41F5F6C3E9546CE693DB_1118996833 = (this.getPositivePrefix().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_679021655 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_679021655;
        // ---------- Original Method ----------
        //return this.getPositivePrefix().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.234 -0400", hash_original_method = "5C171A463B7BB08FCE40648C7CE8F861", hash_generated_method = "36CAD6210CFA016FE9122A2E563AE993")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.235 -0400", hash_original_method = "D252F6FD4E111780C248C256B2516FF2", hash_generated_method = "F7597C89B2C966B5EE79238F1D293DF4")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_285045487 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_285045487 = new NativeDecimalFormat(this);
        varB4EAC82CA7396A68D541C85D26508E83_285045487.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_285045487;
        // ---------- Original Method ----------
        //return new NativeDecimalFormat(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.243 -0400", hash_original_method = "220130DBC584D5B5D45771D972950D18", hash_generated_method = "463C650E6CBA2644A8CBDBB4C77A9E22")
    @Override
    public boolean equals(Object object) {
        {
            boolean var3F549205D4C262003697A031F89E5954_1012129768 = (object == this);
        } //End collapsed parenthetic
        NativeDecimalFormat obj;
        obj = (NativeDecimalFormat) object;
        boolean var18FBB52F731808A4077D23FDD981869A_1234983099 = (obj.toPattern().equals(this.toPattern()) &&
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1846136468 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1846136468;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.244 -0400", hash_original_method = "6B8DF144F51335DB9B33B1BD0598F087", hash_generated_method = "F50D865A25252BAB9C1E1E1C12F08C9E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.244 -0400", hash_original_method = "5FE0177EB5130C508ECEC468A64D96E3", hash_generated_method = "8EF61A24B2109F9772578EEB2CC2CBE1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.244 -0400", hash_original_method = "E3DC36059DBEEA918EB4DAC2E3F69056", hash_generated_method = "2CB5CC71A3E8E560ACD2820E6C0AC323")
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
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_431436676 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_431436676;
        // ---------- Original Method ----------
        //FieldPositionIterator fpi = FieldPositionIterator.forFieldPosition(field);
        //char[] result = formatDigitList(this.address, value.toString(), fpi);
        //if (fpi != null) {
            //FieldPositionIterator.setFieldPosition(fpi, field);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.245 -0400", hash_original_method = "AB58B0DEED1650663505F868BCDB9A76", hash_generated_method = "C422458D0A0F7AED9E9A970C37E45755")
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
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_603200744 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_603200744;
        // ---------- Original Method ----------
        //FieldPositionIterator fpi = FieldPositionIterator.forFieldPosition(field);
        //char[] result = formatDigitList(this.address, value.toString(10), fpi);
        //if (fpi != null) {
            //FieldPositionIterator.setFieldPosition(fpi, field);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.254 -0400", hash_original_method = "E280C21CEDC9C41E32AB3781E6354849", hash_generated_method = "78126616AD507C0D3DB346BACD967EC1")
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
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1446539595 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1446539595;
        // ---------- Original Method ----------
        //FieldPositionIterator fpi = FieldPositionIterator.forFieldPosition(field);
        //char[] result = formatLong(this.address, value, fpi);
        //if (fpi != null) {
            //FieldPositionIterator.setFieldPosition(fpi, field);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.258 -0400", hash_original_method = "2B822D9FBF334F04026E765F63D8EA7D", hash_generated_method = "75D47E678B043C9CFB2F5BE7D032C03E")
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
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_477938667 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_477938667;
        // ---------- Original Method ----------
        //FieldPositionIterator fpi = FieldPositionIterator.forFieldPosition(field);
        //char[] result = formatDouble(this.address, value, fpi);
        //if (fpi != null) {
            //FieldPositionIterator.setFieldPosition(fpi, field);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.259 -0400", hash_original_method = "521D68694A0F2FF9FD004D1F044248B6", hash_generated_method = "626CB7EAC0C2AC2D31677753DB78F3D3")
    public void applyLocalizedPattern(String pattern) {
        applyPattern(this.address, true, pattern);
        lastPattern = null;
        addTaint(pattern.getTaint());
        // ---------- Original Method ----------
        //applyPattern(this.address, true, pattern);
        //lastPattern = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.259 -0400", hash_original_method = "105E6A8350C3ECD2CBDC93E6E74AA17C", hash_generated_method = "C684EE805211C36A800CC2CE1E80C2EF")
    public void applyPattern(String pattern) {
        {
            boolean var30056E56F7633573B6C2DD284E929162_1384209844 = (lastPattern != null && pattern.equals(lastPattern));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.269 -0400", hash_original_method = "9FEF3AE5E61C347D525A9585FBE19ECF", hash_generated_method = "9D187E0AA1A8F312FE82AB3FF74CE8FF")
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        AttributedCharacterIterator varB4EAC82CA7396A68D541C85D26508E83_1737286093 = null; //Variable for return #1
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
            boolean varC94C796D691F3725A70F62B7F781E92F_868948298 = (fpIter.next());
            {
                Format.Field field;
                field = fpIter.field();
                as.addAttribute(field, field, fpIter.start(), fpIter.limit());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1737286093 = as.getIterator();
        addTaint(object.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1737286093.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1737286093;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.272 -0400", hash_original_method = "E9B105AB178BFBFEB280AF82F381CE84", hash_generated_method = "D0935F5E7262204D18D760E6926C6A45")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_768563360 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_768563360;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.272 -0400", hash_original_method = "1F42A3AAFB142AE620B1A14F6DE6CCC5", hash_generated_method = "67C9C819E8B331387E9F7BC0A58F1A9C")
    public String toLocalizedPattern() {
        String varB4EAC82CA7396A68D541C85D26508E83_1691577110 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1691577110 = toPatternImpl(this.address, true);
        varB4EAC82CA7396A68D541C85D26508E83_1691577110.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1691577110;
        // ---------- Original Method ----------
        //return toPatternImpl(this.address, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.272 -0400", hash_original_method = "D90F2C106608034D601A7F076DF301BD", hash_generated_method = "DC76F742D742AFCB29F2B4140DB8A4A6")
    public String toPattern() {
        String varB4EAC82CA7396A68D541C85D26508E83_28774213 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_28774213 = toPatternImpl(this.address, false);
        varB4EAC82CA7396A68D541C85D26508E83_28774213.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_28774213;
        // ---------- Original Method ----------
        //return toPatternImpl(this.address, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.277 -0400", hash_original_method = "C24C75386265F50BCF75B046D9BE3ACC", hash_generated_method = "4ACA0C6F624C1967A179F6D50F42E678")
    public Number parse(String string, ParsePosition position) {
        Number varB4EAC82CA7396A68D541C85D26508E83_1247781637 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1247781637 = parse(address, string, position, parseBigDecimal);
        addTaint(string.getTaint());
        addTaint(position.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1247781637.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1247781637;
        // ---------- Original Method ----------
        //return parse(address, string, position, parseBigDecimal);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.278 -0400", hash_original_method = "00B4402833BBD0AA4B8B3DAC69045BF5", hash_generated_method = "76DAB4C99B05E2A826097614850CFDF5")
    public int getMaximumFractionDigits() {
        int var2031882FA64042FA8714F056BC326B77_1325698354 = (getAttribute(this.address, UNUM_MAX_FRACTION_DIGITS));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1084684339 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1084684339;
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_MAX_FRACTION_DIGITS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.278 -0400", hash_original_method = "39458F699020062C4A2A7E5A13FEC803", hash_generated_method = "2E8ECAD7851A617BEEB349BA89F8AE8D")
    public int getMaximumIntegerDigits() {
        int var552BC4AA7CD66CB5C86DC39DD6F5EB61_925894228 = (getAttribute(this.address, UNUM_MAX_INTEGER_DIGITS));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_541511831 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_541511831;
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_MAX_INTEGER_DIGITS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.278 -0400", hash_original_method = "2493C2169723FB0932E2841ED5413767", hash_generated_method = "8704443ED008550292A5675DA472E196")
    public int getMinimumFractionDigits() {
        int var651D9F7029A8FF147A685A36D32AA845_1114158459 = (getAttribute(this.address, UNUM_MIN_FRACTION_DIGITS));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_377115246 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_377115246;
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_MIN_FRACTION_DIGITS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.279 -0400", hash_original_method = "C287E89D9CA249987BAB41DA58A603BE", hash_generated_method = "FEC65BDDDEB48EB5F0A6FAA6860C62A9")
    public int getMinimumIntegerDigits() {
        int varE7531A98F2A0AD2779754CD1B2865E0B_1400229836 = (getAttribute(this.address, UNUM_MIN_INTEGER_DIGITS));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1304880745 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1304880745;
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_MIN_INTEGER_DIGITS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.279 -0400", hash_original_method = "C63E831A66DAEA25345E39BD0E8C902A", hash_generated_method = "DC369E59934FF9F914FD5BBF2327445E")
    public int getGroupingSize() {
        int varEBCCDDFF415DDB22660365F0FC4A83FC_2109738650 = (getAttribute(this.address, UNUM_GROUPING_SIZE));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1060878704 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1060878704;
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_GROUPING_SIZE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.279 -0400", hash_original_method = "195B15A30ECFDD2DA316EFD7F1135C74", hash_generated_method = "0E5976F9BDA6220705B696C79B8FD6FB")
    public int getMultiplier() {
        int var2028C5EE807D8F87AD09F7ADE0783DF7_769615937 = (getAttribute(this.address, UNUM_MULTIPLIER));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1358100308 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1358100308;
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_MULTIPLIER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.280 -0400", hash_original_method = "6BE8F2BF8B3A5604EA6D6E250F279823", hash_generated_method = "7F83449122D1EEE58CA54F106CD913E8")
    public String getNegativePrefix() {
        String varB4EAC82CA7396A68D541C85D26508E83_2028822155 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1964011082 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_2028822155 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1964011082 = getTextAttribute(this.address, UNUM_NEGATIVE_PREFIX);
        String varA7E53CE21691AB073D9660D615818899_2099637047; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2099637047 = varB4EAC82CA7396A68D541C85D26508E83_2028822155;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2099637047 = varB4EAC82CA7396A68D541C85D26508E83_1964011082;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2099637047.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2099637047;
        // ---------- Original Method ----------
        //if (negPrefNull) {
            //return null;
        //}
        //return getTextAttribute(this.address, UNUM_NEGATIVE_PREFIX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.281 -0400", hash_original_method = "3B3EF8E26C12E3D51B48D0C30732D5F5", hash_generated_method = "A77F9A33FCA0F5241D1DCF5B482C06BE")
    public String getNegativeSuffix() {
        String varB4EAC82CA7396A68D541C85D26508E83_653268318 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_342641670 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_653268318 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_342641670 = getTextAttribute(this.address, UNUM_NEGATIVE_SUFFIX);
        String varA7E53CE21691AB073D9660D615818899_2037622572; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2037622572 = varB4EAC82CA7396A68D541C85D26508E83_653268318;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2037622572 = varB4EAC82CA7396A68D541C85D26508E83_342641670;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2037622572.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2037622572;
        // ---------- Original Method ----------
        //if (negSuffNull) {
            //return null;
        //}
        //return getTextAttribute(this.address, UNUM_NEGATIVE_SUFFIX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.283 -0400", hash_original_method = "8D4D6B90A746E09AE36173ABA0AB4B15", hash_generated_method = "23C177ECC3F661D35FA3922C3DE80FC9")
    public String getPositivePrefix() {
        String varB4EAC82CA7396A68D541C85D26508E83_1983114265 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1594535638 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1983114265 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1594535638 = getTextAttribute(this.address, UNUM_POSITIVE_PREFIX);
        String varA7E53CE21691AB073D9660D615818899_345647989; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_345647989 = varB4EAC82CA7396A68D541C85D26508E83_1983114265;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_345647989 = varB4EAC82CA7396A68D541C85D26508E83_1594535638;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_345647989.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_345647989;
        // ---------- Original Method ----------
        //if (posPrefNull) {
            //return null;
        //}
        //return getTextAttribute(this.address, UNUM_POSITIVE_PREFIX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.283 -0400", hash_original_method = "6CFE84E5B71B94B0DE7447BA68FEA246", hash_generated_method = "821F949A424509A79F83760D2D32EA6A")
    public String getPositiveSuffix() {
        String varB4EAC82CA7396A68D541C85D26508E83_506968337 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1039675525 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_506968337 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1039675525 = getTextAttribute(this.address, UNUM_POSITIVE_SUFFIX);
        String varA7E53CE21691AB073D9660D615818899_586695503; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_586695503 = varB4EAC82CA7396A68D541C85D26508E83_506968337;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_586695503 = varB4EAC82CA7396A68D541C85D26508E83_1039675525;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_586695503.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_586695503;
        // ---------- Original Method ----------
        //if (posSuffNull) {
            //return null;
        //}
        //return getTextAttribute(this.address, UNUM_POSITIVE_SUFFIX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.291 -0400", hash_original_method = "F9B59ECC893A5B014F6155ABE9703BF1", hash_generated_method = "7E1FC5813F006BDDF9965BF566D3724F")
    public boolean isDecimalSeparatorAlwaysShown() {
        boolean var3E4313CD429F3F78E13F34D688881F5E_1153326387 = (getAttribute(this.address, UNUM_DECIMAL_ALWAYS_SHOWN) != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1373045601 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1373045601;
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_DECIMAL_ALWAYS_SHOWN) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.292 -0400", hash_original_method = "84561142CC409560F18895112EB228ED", hash_generated_method = "7636F6E4B3A54FAE2F55A18802253B52")
    public boolean isParseBigDecimal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_276170929 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_276170929;
        // ---------- Original Method ----------
        //return parseBigDecimal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.292 -0400", hash_original_method = "1D326E5349B9E5A9AED64258AB68CB41", hash_generated_method = "EA2EDD3B5259CC3EF922C660B3A49E6A")
    public boolean isParseIntegerOnly() {
        boolean var58CA17599706E2BD9D06C2CCBA6B89AB_845636914 = (getAttribute(this.address, UNUM_PARSE_INT_ONLY) != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1682114820 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1682114820;
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_PARSE_INT_ONLY) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.298 -0400", hash_original_method = "00E8502D2DA3C0C73215E5BC5979A07C", hash_generated_method = "F554C236DCEC9736CF6794117E3D6CE0")
    public boolean isGroupingUsed() {
        boolean var875BD0DB8C0EE50D68D0C6793AE8DABD_477418345 = (getAttribute(this.address, UNUM_GROUPING_USED) != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1748927511 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1748927511;
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_GROUPING_USED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.298 -0400", hash_original_method = "4515EB7BD614742B3D0DDD5748BC74D6", hash_generated_method = "B8B0456587560093071500C9C0FCAE5E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.298 -0400", hash_original_method = "27959CC6793546F59976E7DBD15119DA", hash_generated_method = "E9FFB17EAD4EA0D712632E876D6C36D5")
    public void setCurrency(Currency currency) {
        setSymbol(this.address, UNUM_CURRENCY_SYMBOL, currency.getSymbol());
        setSymbol(this.address, UNUM_INTL_CURRENCY_SYMBOL, currency.getCurrencyCode());
        addTaint(currency.getTaint());
        // ---------- Original Method ----------
        //setSymbol(this.address, UNUM_CURRENCY_SYMBOL, currency.getSymbol());
        //setSymbol(this.address, UNUM_INTL_CURRENCY_SYMBOL, currency.getCurrencyCode());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.302 -0400", hash_original_method = "49FEA0DFBB56F17CB90E68E0F78CE577", hash_generated_method = "EC4442CDE4C2F319FBDABF66B7010AFB")
    public void setGroupingSize(int value) {
        setAttribute(this.address, UNUM_GROUPING_SIZE, value);
        addTaint(value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_GROUPING_SIZE, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.305 -0400", hash_original_method = "E302CDF79A67421C2D7FEEF4C305D93F", hash_generated_method = "792F56F062246284C7ECE4AAAA26AE86")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.305 -0400", hash_original_method = "758C6DB93C92764527C1135AD7160507", hash_generated_method = "64C5C48B47DB480798C2AFF0D3819358")
    public void setMaximumFractionDigits(int value) {
        setAttribute(this.address, UNUM_MAX_FRACTION_DIGITS, value);
        addTaint(value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_MAX_FRACTION_DIGITS, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.310 -0400", hash_original_method = "89C5389B02F633081323A23C8FB84870", hash_generated_method = "9BE9DDE05F7F7A37CB2E326D3E2123B3")
    public void setMaximumIntegerDigits(int value) {
        setAttribute(this.address, UNUM_MAX_INTEGER_DIGITS, value);
        addTaint(value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_MAX_INTEGER_DIGITS, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.311 -0400", hash_original_method = "62DF7CF1343955ADCD931CBCC029C545", hash_generated_method = "0D04383E51DB8E8945118D5D47457FCC")
    public void setMinimumFractionDigits(int value) {
        setAttribute(this.address, UNUM_MIN_FRACTION_DIGITS, value);
        addTaint(value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_MIN_FRACTION_DIGITS, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.311 -0400", hash_original_method = "5D466EF26E9A120396C63069DE20CEB4", hash_generated_method = "D0CBC6A8D932BD845AF8513FB005E1E7")
    public void setMinimumIntegerDigits(int value) {
        setAttribute(this.address, UNUM_MIN_INTEGER_DIGITS, value);
        addTaint(value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_MIN_INTEGER_DIGITS, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.311 -0400", hash_original_method = "B169BA3B31B9F8AB850C7AD451D65C7F", hash_generated_method = "09EBC652ED959626329C8BC07614B33D")
    public void setMultiplier(int value) {
        setAttribute(this.address, UNUM_MULTIPLIER, value);
        multiplierBigDecimal = BigDecimal.valueOf(value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_MULTIPLIER, value);
        //multiplierBigDecimal = BigDecimal.valueOf(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.312 -0400", hash_original_method = "74BB5921C2CC61F7BCF8D1B8841FD51E", hash_generated_method = "C4DAAC223C73D5280FF1AECBB891C728")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.319 -0400", hash_original_method = "0FF0A51DFB17D23D2B0F182081F1472B", hash_generated_method = "79F6037D750EDFA1DC0ED4FD3C7377C7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.319 -0400", hash_original_method = "FC20737C410620F82F4CED74F1142CF3", hash_generated_method = "7C1C2C38F30484A1BDBFC4383517B9CA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.320 -0400", hash_original_method = "48A175BA83D370BA86128EC6BAC61CB5", hash_generated_method = "132EBBDC2763FE4573B3F9983677074F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.320 -0400", hash_original_method = "16B3A7386DF3851CB73D32D9A838D98B", hash_generated_method = "A04CC31A40B62965DB9042EEB28F4644")
    public void setParseBigDecimal(boolean value) {
        parseBigDecimal = value;
        // ---------- Original Method ----------
        //parseBigDecimal = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.320 -0400", hash_original_method = "7FF47C5BC2EFAEE27B26A852A846EAFB", hash_generated_method = "CB50EF700F4EE81341E89A29CAB95719")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.326 -0400", hash_original_method = "D542BB733096020C1E39876D678697A7", hash_generated_method = "5601AC6A55BB8B8AC389EDE8D8DE38ED")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.344 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "2F322A4CCA87DBF62C5291F2FA6D1538")

        private int[] data;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.344 -0400", hash_original_field = "41A87CD99CAC79C14134D1D8193C9405", hash_generated_field = "C812BD0A950A53E451CF78B187BCF580")

        private int pos = -3;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.344 -0400", hash_original_method = "3872533C5F4C6DF8E9B47456E87ABB09", hash_generated_method = "61C6C4E209B2EB1D194185007E303529")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.355 -0400", hash_original_method = "F9CA7CA9C759396A69CAFCECCE3A38CE", hash_generated_method = "FAF5B98F6D6D45B84C4ACA3408247E82")
        public boolean next() {
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            pos += 3;
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1216513945 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1216513945;
            // ---------- Original Method ----------
            //if (data == null || pos == data.length) {
                //throw new NoSuchElementException();
            //}
            //pos += 3;
            //return pos < data.length;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.356 -0400", hash_original_method = "28A52A04516ACAEA5CBE057E7005DC29", hash_generated_method = "5DF96E6E92B6CC3D8098CC728AFF2BD8")
        private void checkValid() {
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            // ---------- Original Method ----------
            //if (data == null || pos < 0 || pos == data.length) {
                //throw new NoSuchElementException();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.356 -0400", hash_original_method = "F481D50CCC1AB38B4CA6D00583ECCD74", hash_generated_method = "AE6CD99C6AF6B8E2CD47165B57602CF6")
        public int fieldId() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_124679427 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_124679427;
            // ---------- Original Method ----------
            //return data[pos];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.358 -0400", hash_original_method = "B152D64258DA85AB1020B78F45482139", hash_generated_method = "A231B4729F1E7F6BDBA2E6C21D161288")
        public Format.Field field() {
            Format.Field varB4EAC82CA7396A68D541C85D26508E83_1631542846 = null; //Variable for return #1
            checkValid();
            varB4EAC82CA7396A68D541C85D26508E83_1631542846 = fields[data[pos]];
            varB4EAC82CA7396A68D541C85D26508E83_1631542846.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1631542846;
            // ---------- Original Method ----------
            //checkValid();
            //return fields[data[pos]];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.361 -0400", hash_original_method = "573D89586F74B4B2EDB6530AAE1DEC79", hash_generated_method = "7BD235ABAAA90BD135CC6BEC67918B32")
        public int start() {
            checkValid();
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1001933246 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1001933246;
            // ---------- Original Method ----------
            //checkValid();
            //return data[pos + 1];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.362 -0400", hash_original_method = "431D149304BC1F14DB944F0790F3E8B8", hash_generated_method = "D51C0737C074C54CE0C5A2748B613DD7")
        public int limit() {
            checkValid();
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_392890617 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_392890617;
            // ---------- Original Method ----------
            //checkValid();
            //return data[pos + 2];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.368 -0400", hash_original_method = "E1A3B20A4A62E5F6661DF7F73A635F7C", hash_generated_method = "2FA05A6182FB4AA13AC353371D99B73A")
        private void setData(int[] data) {
            this.data = data;
            this.pos = -3;
            // ---------- Original Method ----------
            //this.data = data;
            //this.pos = -3;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.368 -0400", hash_original_field = "27D7A0AA47D8E9AD8DC4BF2D88186493", hash_generated_field = "77669A7AF4E71AED42749606AFF53301")

        private static Format.Field fields[] = ;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.368 -0400", hash_original_field = "024283A17B4F858679487AA41D06F137", hash_generated_field = "F1A0B4063FC73A00E5925A4113D34F33")

    private static int UNUM_DECIMAL_SEPARATOR_SYMBOL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.368 -0400", hash_original_field = "569D4CB22C567CCFA8FA28AA98AA481B", hash_generated_field = "FFB1DBC11B61B861CB120E66FC348445")

    private static int UNUM_GROUPING_SEPARATOR_SYMBOL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.369 -0400", hash_original_field = "DC39C912818608D5EE416599EB02C2F1", hash_generated_field = "13D80B550D517DDBE93023DF7AB8E4AF")

    private static int UNUM_PATTERN_SEPARATOR_SYMBOL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.369 -0400", hash_original_field = "2E48B57484F2D80820EE30D01A85762B", hash_generated_field = "AB77581E6286196306602ED93BC57AF9")

    private static int UNUM_PERCENT_SYMBOL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.370 -0400", hash_original_field = "B80F5415D213C71760D64C3F8655E103", hash_generated_field = "846EEF4A4D3AFE29BAB0336BFD429FDF")

    private static int UNUM_ZERO_DIGIT_SYMBOL = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.370 -0400", hash_original_field = "849923D76D74AC9D2575F3FEB9D17105", hash_generated_field = "A95D26CEFB4738083B5CC4E5911EA137")

    private static int UNUM_DIGIT_SYMBOL = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.370 -0400", hash_original_field = "982740976D9454DA142BBB76FCB86E65", hash_generated_field = "AE99C546578E39F1A84EB6E19A6ECD0B")

    private static int UNUM_MINUS_SIGN_SYMBOL = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.370 -0400", hash_original_field = "D4A0AD0CDFD3BC5A192430B57716B330", hash_generated_field = "2FB4E731FA769678FC11C4CCE2D477A5")

    private static int UNUM_PLUS_SIGN_SYMBOL = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.370 -0400", hash_original_field = "6520A81D71399A74E18494DE8A2D2716", hash_generated_field = "E7AFBCE4F02EC99A1ADFD6407063802C")

    private static int UNUM_CURRENCY_SYMBOL = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.370 -0400", hash_original_field = "4EBC0BEF182CD31FB42F775EAD2D9A1C", hash_generated_field = "4EC18E3BC8FD687942CB53A60165AD20")

    private static int UNUM_INTL_CURRENCY_SYMBOL = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.370 -0400", hash_original_field = "82EF848B759F95741D1982E35EBEEA19", hash_generated_field = "B782DF48B22783F78CB3C9BF9867E963")

    private static int UNUM_MONETARY_SEPARATOR_SYMBOL = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.371 -0400", hash_original_field = "EBFE24817B35301033E4034E3B5AFB93", hash_generated_field = "F739F7AC70101A5061EA03973F0B44C6")

    private static int UNUM_EXPONENTIAL_SYMBOL = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.372 -0400", hash_original_field = "555A332569EBE4B181F44ADCCF0603D5", hash_generated_field = "AE0440C3265AAA458B6618C9997C63A4")

    private static int UNUM_PERMILL_SYMBOL = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.372 -0400", hash_original_field = "6F0C8024A801549CF944CDBEFDB9DDB4", hash_generated_field = "A207BD74612EA04C63F8EAFD5C4697FE")

    private static int UNUM_PAD_ESCAPE_SYMBOL = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.372 -0400", hash_original_field = "378FA79958A996A5E9BC4BFADD42352C", hash_generated_field = "C5FBBF4CEB67F2D4A40E12DB14C129B2")

    private static int UNUM_INFINITY_SYMBOL = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.372 -0400", hash_original_field = "8B4BB88522F81B591874E385E981297F", hash_generated_field = "A66A7F92A2A33759CAA68FCA9670E56F")

    private static int UNUM_NAN_SYMBOL = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.372 -0400", hash_original_field = "F86892C3522DEA90F517C4C5467386D5", hash_generated_field = "ED434CC9C3E68F2311304019BC8A38FA")

    private static int UNUM_SIGNIFICANT_DIGIT_SYMBOL = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.372 -0400", hash_original_field = "53E1C966A8C817CC8509732458E431F8", hash_generated_field = "DF1FB7EE940A8E1B8FF0355BD23DF064")

    private static int UNUM_MONETARY_GROUPING_SEPARATOR_SYMBOL = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.372 -0400", hash_original_field = "6944D02F190693EAEBF8A29CD17CA79C", hash_generated_field = "774C94D52D74DACB1ECD0810D68C6C6E")

    private static int UNUM_FORMAT_SYMBOL_COUNT = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.372 -0400", hash_original_field = "8971AE23D0ACB2019E7F237C1A5D9057", hash_generated_field = "E9D4E418BC891FA00F446DC769ABF166")

    private static int UNUM_PARSE_INT_ONLY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.372 -0400", hash_original_field = "46581E7ADB623C966C46F86CBCA1ACA7", hash_generated_field = "BEE01287F5547E235A2E45295E96352A")

    private static int UNUM_GROUPING_USED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.372 -0400", hash_original_field = "D0A1191C6B8058293B62F4EB5CB139F7", hash_generated_field = "5BCEEDAF00801CEEB2E2CC5446CA7B8D")

    private static int UNUM_DECIMAL_ALWAYS_SHOWN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.372 -0400", hash_original_field = "6A692975BF789004FF9BCD7ED2595754", hash_generated_field = "0C50FDB8E63D18E74FD84372257CD42A")

    private static int UNUM_MAX_INTEGER_DIGITS = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.372 -0400", hash_original_field = "BFCDA61A6544D8200FB16C8ECAB194D9", hash_generated_field = "19875760AE1AE10E91F16D956926D045")

    private static int UNUM_MIN_INTEGER_DIGITS = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.372 -0400", hash_original_field = "DA0B7AFB468402B4FAB627D7A9AFFACE", hash_generated_field = "497556A4D54DC72F228E201D69F99D9B")

    private static int UNUM_INTEGER_DIGITS = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.372 -0400", hash_original_field = "5750A34FC87461228B5037583C2CE979", hash_generated_field = "17492FB3B526FC58E5B8303AD0FCC398")

    private static int UNUM_MAX_FRACTION_DIGITS = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.372 -0400", hash_original_field = "BE2E1373EE438BBC72E5EEA62F6EEFCE", hash_generated_field = "23238292FBA113DA32B40918FDBD6327")

    private static int UNUM_MIN_FRACTION_DIGITS = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.372 -0400", hash_original_field = "C0D0E977100ACCBC9B8F77297A991F0A", hash_generated_field = "ABB619B1F91E8449737753382F4A7773")

    private static int UNUM_FRACTION_DIGITS = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.372 -0400", hash_original_field = "4FFB3432E077BDF4076A364D312B6322", hash_generated_field = "E860B0F79430839306E7B4464FDF7C5A")

    private static int UNUM_MULTIPLIER = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.372 -0400", hash_original_field = "68EDF621E4AEA7D984951F9A8C68B508", hash_generated_field = "33A0D7072383946FD3DE589292436664")

    private static int UNUM_GROUPING_SIZE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.372 -0400", hash_original_field = "3180DB5CC7990CFC070810D65823E15E", hash_generated_field = "2F353D055C6CE86B2131D63744BDE07B")

    private static int UNUM_ROUNDING_MODE = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.372 -0400", hash_original_field = "EB76EFADD49B90471770F624C07D79A9", hash_generated_field = "8DD05CECB4B2FA83C4755C2FFB8C39D0")

    private static int UNUM_ROUNDING_INCREMENT = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.372 -0400", hash_original_field = "2E1629A5A9F1DEAF1A18A9539618D4D5", hash_generated_field = "4B5B325097AF2EEC2AF3DCED6079BC69")

    private static int UNUM_FORMAT_WIDTH = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.373 -0400", hash_original_field = "B760C9A8428FD459E7B9827858CFD779", hash_generated_field = "B6124F7DDDF54572151B57017DB994E5")

    private static int UNUM_PADDING_POSITION = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.373 -0400", hash_original_field = "D7D95CD560376F364890DB0FD74EB85B", hash_generated_field = "62DBB8D58F43FFC1602C56142717026D")

    private static int UNUM_SECONDARY_GROUPING_SIZE = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.373 -0400", hash_original_field = "5CA0ED7747BDD5FD9CA45EC2E6F0E8B5", hash_generated_field = "0793A35896CC034823DD1EEDF472132E")

    private static int UNUM_SIGNIFICANT_DIGITS_USED = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.373 -0400", hash_original_field = "CED3E3C034EC98CD8CA99E728B988C9E", hash_generated_field = "2949BA0424F474373992B7135D8FFD5C")

    private static int UNUM_MIN_SIGNIFICANT_DIGITS = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.373 -0400", hash_original_field = "3E30604D3F70C6D8BE917DAB3E65F7C2", hash_generated_field = "3FE9D39FD73AD8FD8557F48BDBEEE0A1")

    private static int UNUM_MAX_SIGNIFICANT_DIGITS = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.373 -0400", hash_original_field = "D64F4F2459B0190DFFBA9826AC72489F", hash_generated_field = "D3CA11B052F84F0E610A986ECB047426")

    private static int UNUM_LENIENT_PARSE = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.373 -0400", hash_original_field = "E81D0E837BFCCE8B299F86B2B0379AA1", hash_generated_field = "5C27825FA6DDEBE5B3689CDE9ADD1B27")

    private static int UNUM_POSITIVE_PREFIX = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.373 -0400", hash_original_field = "ACAF14DFBF527393BF01C453C005773D", hash_generated_field = "72BB3F9B4869F37B1712A4B3E02A7ACC")

    private static int UNUM_POSITIVE_SUFFIX = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.373 -0400", hash_original_field = "3B4AAFD666329CD2E14C939EB5493111", hash_generated_field = "9D1E6D97489785DBE6BD452143657B27")

    private static int UNUM_NEGATIVE_PREFIX = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.373 -0400", hash_original_field = "B914446D1D897950976F6F9F6EEBD0B7", hash_generated_field = "DBA534AA48DEA0242034D3457E1BF15D")

    private static int UNUM_NEGATIVE_SUFFIX = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.373 -0400", hash_original_field = "4E39F122ADFEC6840ACE999C184C9EE2", hash_generated_field = "0B72590282B714A077410BB49CC6729A")

    private static int UNUM_PADDING_CHARACTER = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.373 -0400", hash_original_field = "36CCE6C77A18DA6E36931EF0CD49A9BB", hash_generated_field = "352C277EBC3B7F19B41C32D96AD9956E")

    private static int UNUM_CURRENCY_CODE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.373 -0400", hash_original_field = "FBB3BE349F8C0AB42CE7BA4DD07A0976", hash_generated_field = "CA6C1E3B5555C442D0ABE8ED635462AB")

    private static int UNUM_DEFAULT_RULESET = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.373 -0400", hash_original_field = "A63C4BE0875A4094DC60472905775981", hash_generated_field = "8AB970464C89EE4EB6AF3B62724D9B9B")

    private static int UNUM_PUBLIC_RULESETS = 7;
}

