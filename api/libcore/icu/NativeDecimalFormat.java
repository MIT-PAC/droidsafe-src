package libcore.icu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.248 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "849BAB492558B51E7BC4F1C331A435E4")

    private int address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.248 -0400", hash_original_field = "344BCC24F3464715940DD56604C8D74D", hash_generated_field = "5F7D5D3D7F66CE031779F4BACE74C549")

    private String lastPattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.248 -0400", hash_original_field = "FE0C344D27B5DDD52EE172F18436517A", hash_generated_field = "A56A7DCB118482C05DDF4AEBE99FDB15")

    private boolean negPrefNull;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.248 -0400", hash_original_field = "847370D067A7C3F3858025EC1AE68504", hash_generated_field = "2505E1D75E0C167EE76E4EF5DDA36BE9")

    private boolean negSuffNull;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.248 -0400", hash_original_field = "61EA484D190CD4F0A57205D48CFCE039", hash_generated_field = "CDAAA116F4BD28B5162A921B2B1BA25F")

    private boolean posPrefNull;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.248 -0400", hash_original_field = "C30F6031C7DF0B30F08B2845ADE90423", hash_generated_field = "E9F9066E16BD9AB176D3C016B62231F0")

    private boolean posSuffNull;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.248 -0400", hash_original_field = "287D1050A38F78BCF10BE8BDFB1C701E", hash_generated_field = "622CB2D56C22AE9A04568955FFFF4B33")

    private transient boolean parseBigDecimal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.248 -0400", hash_original_field = "EBBDEA416E09F573B73D6D6E43EF5083", hash_generated_field = "C24355A01F90DF3021CC166940F4BB14")

    private BigDecimal multiplierBigDecimal = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.249 -0400", hash_original_method = "D8AEBC26DB4CF2E0C933D0F5B84F659E", hash_generated_method = "1ABD56759F568ED9066623AC8A1CE944")
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
            npe.addTaint(taint);
            throw npe;
        } //End block
        catch (RuntimeException re)
        {
            IllegalArgumentException var21F2095C31335E74113D24C8B49C0775_1125047440 = new IllegalArgumentException("syntax error: " + re.getMessage() + ": " + pattern);
            var21F2095C31335E74113D24C8B49C0775_1125047440.addTaint(taint);
            throw var21F2095C31335E74113D24C8B49C0775_1125047440;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.250 -0400", hash_original_method = "03415942CECEA3C928FA024ACF038523", hash_generated_method = "D2E674819D4F909C96BFFA4F1D82A4EF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.251 -0400", hash_original_method = "F2FB63D256AD622AD0AA1906E5944DB2", hash_generated_method = "5AAFFDF8705B718E89082099B750E33B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.252 -0400", hash_original_method = "C197288C8DD3954567266901B60BE5B8", hash_generated_method = "1BB12DD57608A19845F26CB955F20A24")
    @Override
    public int hashCode() {
        int varB71D361349A4DB8C2530578F22434148_1067602203 = (this.getPositivePrefix().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1045509160 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1045509160;
        // ---------- Original Method ----------
        //return this.getPositivePrefix().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.252 -0400", hash_original_method = "5C171A463B7BB08FCE40648C7CE8F861", hash_generated_method = "132E58C5D32B4E20C521CA909B3F9435")
    public synchronized void close() {
    if(address != 0)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.253 -0400", hash_original_method = "D252F6FD4E111780C248C256B2516FF2", hash_generated_method = "38E99CF0DE99BAEBCC6765B4B93831DF")
    @Override
    public Object clone() {
Object var4B7571CD2CD6DD663DE146F4A4111E5C_709712279 =         new NativeDecimalFormat(this);
        var4B7571CD2CD6DD663DE146F4A4111E5C_709712279.addTaint(taint);
        return var4B7571CD2CD6DD663DE146F4A4111E5C_709712279;
        // ---------- Original Method ----------
        //return new NativeDecimalFormat(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.253 -0400", hash_original_method = "220130DBC584D5B5D45771D972950D18", hash_generated_method = "CA8E6F5FEF0E63B4B96F65B45C9B6E86")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
    if(object == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_353350696 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_995757390 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_995757390;
        } //End block
    if(!(object instanceof NativeDecimalFormat))        
        {
            boolean var68934A3E9455FA72420237EB05902327_536083179 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2086551708 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2086551708;
        } //End block
        NativeDecimalFormat obj = (NativeDecimalFormat) object;
    if(obj.address == this.address)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1804214268 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1171826536 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1171826536;
        } //End block
        boolean var7C85BE0AEAB4F8638A5D78DB7241017E_635915352 = (obj.toPattern().equals(this.toPattern()) &&
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
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1059310148 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1059310148;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.254 -0400", hash_original_method = "6B8DF144F51335DB9B33B1BD0598F087", hash_generated_method = "007D87556B6E4DE4F9C39CCD4346F7A6")
    public void setDecimalFormatSymbols(final DecimalFormatSymbols dfs) {
        addTaint(dfs.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.254 -0400", hash_original_method = "5FE0177EB5130C508ECEC468A64D96E3", hash_generated_method = "C11BBAB7F1AB273966033292A454BD94")
    public void setDecimalFormatSymbols(final LocaleData localeData) {
        addTaint(localeData.getTaint());
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.255 -0400", hash_original_method = "E3DC36059DBEEA918EB4DAC2E3F69056", hash_generated_method = "411C76457333CD11616B92BEE666FF8A")
    public char[] formatBigDecimal(BigDecimal value, FieldPosition field) {
        addTaint(field.getTaint());
        addTaint(value.getTaint());
        FieldPositionIterator fpi = FieldPositionIterator.forFieldPosition(field);
        char[] result = formatDigitList(this.address, value.toString(), fpi);
    if(fpi != null)        
        {
            FieldPositionIterator.setFieldPosition(fpi, field);
        } //End block
        char[] varB4A88417B3D0170D754C647C30B7216A_1978327872 = (result);
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_1517117726 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1517117726;
        // ---------- Original Method ----------
        //FieldPositionIterator fpi = FieldPositionIterator.forFieldPosition(field);
        //char[] result = formatDigitList(this.address, value.toString(), fpi);
        //if (fpi != null) {
            //FieldPositionIterator.setFieldPosition(fpi, field);
        //}
        //return result;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.255 -0400", hash_original_method = "AB58B0DEED1650663505F868BCDB9A76", hash_generated_method = "3FFE42B268BAB43898E05D7E9B4BEF42")
    public char[] formatBigInteger(BigInteger value, FieldPosition field) {
        addTaint(field.getTaint());
        addTaint(value.getTaint());
        FieldPositionIterator fpi = FieldPositionIterator.forFieldPosition(field);
        char[] result = formatDigitList(this.address, value.toString(10), fpi);
    if(fpi != null)        
        {
            FieldPositionIterator.setFieldPosition(fpi, field);
        } //End block
        char[] varB4A88417B3D0170D754C647C30B7216A_2116834319 = (result);
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_2141490216 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_2141490216;
        // ---------- Original Method ----------
        //FieldPositionIterator fpi = FieldPositionIterator.forFieldPosition(field);
        //char[] result = formatDigitList(this.address, value.toString(10), fpi);
        //if (fpi != null) {
            //FieldPositionIterator.setFieldPosition(fpi, field);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.256 -0400", hash_original_method = "E280C21CEDC9C41E32AB3781E6354849", hash_generated_method = "2AB34D5B8980124634A52B29A5F39BFA")
    public char[] formatLong(long value, FieldPosition field) {
        addTaint(field.getTaint());
        addTaint(value);
        FieldPositionIterator fpi = FieldPositionIterator.forFieldPosition(field);
        char[] result = formatLong(this.address, value, fpi);
    if(fpi != null)        
        {
            FieldPositionIterator.setFieldPosition(fpi, field);
        } //End block
        char[] varB4A88417B3D0170D754C647C30B7216A_428116045 = (result);
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_79404867 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_79404867;
        // ---------- Original Method ----------
        //FieldPositionIterator fpi = FieldPositionIterator.forFieldPosition(field);
        //char[] result = formatLong(this.address, value, fpi);
        //if (fpi != null) {
            //FieldPositionIterator.setFieldPosition(fpi, field);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.256 -0400", hash_original_method = "2B822D9FBF334F04026E765F63D8EA7D", hash_generated_method = "DE3ECA4174C9266213D05F348395387E")
    public char[] formatDouble(double value, FieldPosition field) {
        addTaint(field.getTaint());
        addTaint(value);
        FieldPositionIterator fpi = FieldPositionIterator.forFieldPosition(field);
        char[] result = formatDouble(this.address, value, fpi);
    if(fpi != null)        
        {
            FieldPositionIterator.setFieldPosition(fpi, field);
        } //End block
        char[] varB4A88417B3D0170D754C647C30B7216A_1197787335 = (result);
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_1864671591 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1864671591;
        // ---------- Original Method ----------
        //FieldPositionIterator fpi = FieldPositionIterator.forFieldPosition(field);
        //char[] result = formatDouble(this.address, value, fpi);
        //if (fpi != null) {
            //FieldPositionIterator.setFieldPosition(fpi, field);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.257 -0400", hash_original_method = "521D68694A0F2FF9FD004D1F044248B6", hash_generated_method = "937FFD9D69FACC6C6A4609FBC243E4C3")
    public void applyLocalizedPattern(String pattern) {
        addTaint(pattern.getTaint());
        applyPattern(this.address, true, pattern);
        lastPattern = null;
        // ---------- Original Method ----------
        //applyPattern(this.address, true, pattern);
        //lastPattern = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.265 -0400", hash_original_method = "105E6A8350C3ECD2CBDC93E6E74AA17C", hash_generated_method = "89052EC45AB58A618F69C009AFD440A4")
    public void applyPattern(String pattern) {
    if(lastPattern != null && pattern.equals(lastPattern))        
        {
            return;
        } //End block
        applyPattern(this.address, false, pattern);
        lastPattern = pattern;
        // ---------- Original Method ----------
        //if (lastPattern != null && pattern.equals(lastPattern)) {
            //return;
        //}
        //applyPattern(this.address, false, pattern);
        //lastPattern = pattern;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.266 -0400", hash_original_method = "9FEF3AE5E61C347D525A9585FBE19ECF", hash_generated_method = "110C2BE520A988093A89B594CCDA2BD5")
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        addTaint(object.getTaint());
    if(!(object instanceof Number))        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_537287243 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_537287243.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_537287243;
        } //End block
        Number number = (Number) object;
        FieldPositionIterator fpIter = new FieldPositionIterator();
        String text;
    if(number instanceof BigInteger || number instanceof BigDecimal)        
        {
            text = new String(formatDigitList(this.address, number.toString(), fpIter));
        } //End block
        else
    if(number instanceof Double || number instanceof Float)        
        {
            double dv = number.doubleValue();
            text = new String(formatDouble(this.address, dv, fpIter));
        } //End block
        else
        {
            long lv = number.longValue();
            text = new String(formatLong(this.address, lv, fpIter));
        } //End block
        AttributedString as = new AttributedString(text);
        while
(fpIter.next())        
        {
            Format.Field field = fpIter.field();
            as.addAttribute(field, field, fpIter.start(), fpIter.limit());
        } //End block
AttributedCharacterIterator varE3ABF6B4C0DDC070CF0843A4557F5D73_1243516818 =         as.getIterator();
        varE3ABF6B4C0DDC070CF0843A4557F5D73_1243516818.addTaint(taint);
        return varE3ABF6B4C0DDC070CF0843A4557F5D73_1243516818;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.267 -0400", hash_original_method = "E9B105AB178BFBFEB280AF82F381CE84", hash_generated_method = "6EBD8C84CCD696EEA740F4F1D1F25CC0")
    private int makeScalePositive(int scale, StringBuilder val) {
        addTaint(val.getTaint());
        addTaint(scale);
    if(scale < 0)        
        {
            scale = -scale;
for(int i = scale;i > 0;i--)
            {
                val.append('0');
            } //End block
            scale = 0;
        } //End block
        int var0CB47AEB6E5F9323F0969E628C4E59F5_67526349 = (scale);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1935220376 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1935220376;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.267 -0400", hash_original_method = "1F42A3AAFB142AE620B1A14F6DE6CCC5", hash_generated_method = "96A77B43D116A58DEE20CEAC27805A3D")
    public String toLocalizedPattern() {
String var31D3589BFB680400985446ED3CCF48B8_1734205592 =         toPatternImpl(this.address, true);
        var31D3589BFB680400985446ED3CCF48B8_1734205592.addTaint(taint);
        return var31D3589BFB680400985446ED3CCF48B8_1734205592;
        // ---------- Original Method ----------
        //return toPatternImpl(this.address, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.267 -0400", hash_original_method = "D90F2C106608034D601A7F076DF301BD", hash_generated_method = "EC063F5A4DE6E3ED289A8162E1278B33")
    public String toPattern() {
String varB8419C6D8586ED8C576670402F06E75E_2034928639 =         toPatternImpl(this.address, false);
        varB8419C6D8586ED8C576670402F06E75E_2034928639.addTaint(taint);
        return varB8419C6D8586ED8C576670402F06E75E_2034928639;
        // ---------- Original Method ----------
        //return toPatternImpl(this.address, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.268 -0400", hash_original_method = "C24C75386265F50BCF75B046D9BE3ACC", hash_generated_method = "6488EECE1513387AD0A27E6CF378B82C")
    public Number parse(String string, ParsePosition position) {
        addTaint(position.getTaint());
        addTaint(string.getTaint());
Number var74971C09A2489F39862E7D44F1B176BF_1455665037 =         parse(address, string, position, parseBigDecimal);
        var74971C09A2489F39862E7D44F1B176BF_1455665037.addTaint(taint);
        return var74971C09A2489F39862E7D44F1B176BF_1455665037;
        // ---------- Original Method ----------
        //return parse(address, string, position, parseBigDecimal);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.268 -0400", hash_original_method = "00B4402833BBD0AA4B8B3DAC69045BF5", hash_generated_method = "1B4294B58CFDB2B603271E3ED70F21E7")
    public int getMaximumFractionDigits() {
        int varC4B915ED84FEC37A84C309EBD45C97C9_825293005 = (getAttribute(this.address, UNUM_MAX_FRACTION_DIGITS));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2035007435 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2035007435;
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_MAX_FRACTION_DIGITS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.268 -0400", hash_original_method = "39458F699020062C4A2A7E5A13FEC803", hash_generated_method = "319D9F696E9A62AE2FAFF6D202D71E3A")
    public int getMaximumIntegerDigits() {
        int varD85F50FB1D976D1507573B0865EBAB0F_1181677291 = (getAttribute(this.address, UNUM_MAX_INTEGER_DIGITS));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1039848909 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1039848909;
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_MAX_INTEGER_DIGITS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.268 -0400", hash_original_method = "2493C2169723FB0932E2841ED5413767", hash_generated_method = "2A18AE306F75B258D88A0F7072BFD43A")
    public int getMinimumFractionDigits() {
        int varF0190BF78C12A5EEC07D28BDE1309F4B_1375619794 = (getAttribute(this.address, UNUM_MIN_FRACTION_DIGITS));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_993614141 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_993614141;
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_MIN_FRACTION_DIGITS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.269 -0400", hash_original_method = "C287E89D9CA249987BAB41DA58A603BE", hash_generated_method = "200D48352048F3231727A97790FF9851")
    public int getMinimumIntegerDigits() {
        int varBF48D118C2E544EDF2D946888F37B196_364320401 = (getAttribute(this.address, UNUM_MIN_INTEGER_DIGITS));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_320377756 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_320377756;
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_MIN_INTEGER_DIGITS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.269 -0400", hash_original_method = "C63E831A66DAEA25345E39BD0E8C902A", hash_generated_method = "406E713CBD36B2661000314B5A5F5E12")
    public int getGroupingSize() {
        int varEA9D8E43BC35A3F63C6144D1DFFB4436_1652397803 = (getAttribute(this.address, UNUM_GROUPING_SIZE));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2101640319 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2101640319;
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_GROUPING_SIZE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.269 -0400", hash_original_method = "195B15A30ECFDD2DA316EFD7F1135C74", hash_generated_method = "4B4376587DDBA927D1E77DD0540B2F34")
    public int getMultiplier() {
        int var149C241827BE805F401C17DAA5592F5D_2136755399 = (getAttribute(this.address, UNUM_MULTIPLIER));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_325656968 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_325656968;
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_MULTIPLIER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.270 -0400", hash_original_method = "6BE8F2BF8B3A5604EA6D6E250F279823", hash_generated_method = "A9850445B246423C6A31A335EB8FEC07")
    public String getNegativePrefix() {
    if(negPrefNull)        
        {
String var540C13E9E156B687226421B24F2DF178_740923568 =             null;
            var540C13E9E156B687226421B24F2DF178_740923568.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_740923568;
        } //End block
String var15D5A3F21B682D1643CAF1FE163DE294_1150030347 =         getTextAttribute(this.address, UNUM_NEGATIVE_PREFIX);
        var15D5A3F21B682D1643CAF1FE163DE294_1150030347.addTaint(taint);
        return var15D5A3F21B682D1643CAF1FE163DE294_1150030347;
        // ---------- Original Method ----------
        //if (negPrefNull) {
            //return null;
        //}
        //return getTextAttribute(this.address, UNUM_NEGATIVE_PREFIX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.270 -0400", hash_original_method = "3B3EF8E26C12E3D51B48D0C30732D5F5", hash_generated_method = "92C9E3D6A7F3F325F3D0AA356CF5808F")
    public String getNegativeSuffix() {
    if(negSuffNull)        
        {
String var540C13E9E156B687226421B24F2DF178_922689902 =             null;
            var540C13E9E156B687226421B24F2DF178_922689902.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_922689902;
        } //End block
String varE15774883214C9F9D3916BD2A634D57B_500593162 =         getTextAttribute(this.address, UNUM_NEGATIVE_SUFFIX);
        varE15774883214C9F9D3916BD2A634D57B_500593162.addTaint(taint);
        return varE15774883214C9F9D3916BD2A634D57B_500593162;
        // ---------- Original Method ----------
        //if (negSuffNull) {
            //return null;
        //}
        //return getTextAttribute(this.address, UNUM_NEGATIVE_SUFFIX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.271 -0400", hash_original_method = "8D4D6B90A746E09AE36173ABA0AB4B15", hash_generated_method = "E2822A955C4D493544F87755C74CF298")
    public String getPositivePrefix() {
    if(posPrefNull)        
        {
String var540C13E9E156B687226421B24F2DF178_1056553929 =             null;
            var540C13E9E156B687226421B24F2DF178_1056553929.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1056553929;
        } //End block
String var14DD234D3385DA0437A6497BB8D3D78B_1355725551 =         getTextAttribute(this.address, UNUM_POSITIVE_PREFIX);
        var14DD234D3385DA0437A6497BB8D3D78B_1355725551.addTaint(taint);
        return var14DD234D3385DA0437A6497BB8D3D78B_1355725551;
        // ---------- Original Method ----------
        //if (posPrefNull) {
            //return null;
        //}
        //return getTextAttribute(this.address, UNUM_POSITIVE_PREFIX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.271 -0400", hash_original_method = "6CFE84E5B71B94B0DE7447BA68FEA246", hash_generated_method = "C18066117CABF71FFE019AAE6694C802")
    public String getPositiveSuffix() {
    if(posSuffNull)        
        {
String var540C13E9E156B687226421B24F2DF178_796586805 =             null;
            var540C13E9E156B687226421B24F2DF178_796586805.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_796586805;
        } //End block
String varAB13615B7DE428590B461B7CCD1A3EA5_1807236414 =         getTextAttribute(this.address, UNUM_POSITIVE_SUFFIX);
        varAB13615B7DE428590B461B7CCD1A3EA5_1807236414.addTaint(taint);
        return varAB13615B7DE428590B461B7CCD1A3EA5_1807236414;
        // ---------- Original Method ----------
        //if (posSuffNull) {
            //return null;
        //}
        //return getTextAttribute(this.address, UNUM_POSITIVE_SUFFIX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.271 -0400", hash_original_method = "F9B59ECC893A5B014F6155ABE9703BF1", hash_generated_method = "90BAC9592DD42104745258D5206C9231")
    public boolean isDecimalSeparatorAlwaysShown() {
        boolean var78881D5B52313AA849132FDB4C0EFC02_1237498103 = (getAttribute(this.address, UNUM_DECIMAL_ALWAYS_SHOWN) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_865179264 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_865179264;
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_DECIMAL_ALWAYS_SHOWN) != 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.272 -0400", hash_original_method = "84561142CC409560F18895112EB228ED", hash_generated_method = "00202FA257DDF44669A05CB37B97D0F1")
    public boolean isParseBigDecimal() {
        boolean var287D1050A38F78BCF10BE8BDFB1C701E_1651545963 = (parseBigDecimal);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2003763499 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2003763499;
        // ---------- Original Method ----------
        //return parseBigDecimal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.272 -0400", hash_original_method = "1D326E5349B9E5A9AED64258AB68CB41", hash_generated_method = "05F5B209704F51423644614860B37F43")
    public boolean isParseIntegerOnly() {
        boolean varB705EEF6456FCB9F9E3B57F78DE9FF1E_511736923 = (getAttribute(this.address, UNUM_PARSE_INT_ONLY) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_417273111 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_417273111;
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_PARSE_INT_ONLY) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.272 -0400", hash_original_method = "00E8502D2DA3C0C73215E5BC5979A07C", hash_generated_method = "297B001DC57830333D8B2137359E7331")
    public boolean isGroupingUsed() {
        boolean var20EAF1D4776EE252160537A050389998_895864592 = (getAttribute(this.address, UNUM_GROUPING_USED) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1513379570 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1513379570;
        // ---------- Original Method ----------
        //return getAttribute(this.address, UNUM_GROUPING_USED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.273 -0400", hash_original_method = "4515EB7BD614742B3D0DDD5748BC74D6", hash_generated_method = "39B9A6ACBE91266D5412A723150DFC47")
    public void setDecimalSeparatorAlwaysShown(boolean value) {
        addTaint(value);
        int i = value ? -1 : 0;
        setAttribute(this.address, UNUM_DECIMAL_ALWAYS_SHOWN, i);
        // ---------- Original Method ----------
        //int i = value ? -1 : 0;
        //setAttribute(this.address, UNUM_DECIMAL_ALWAYS_SHOWN, i);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.273 -0400", hash_original_method = "27959CC6793546F59976E7DBD15119DA", hash_generated_method = "5964C5D2C344EE36FFEB3D141F9DF86D")
    public void setCurrency(Currency currency) {
        addTaint(currency.getTaint());
        setSymbol(this.address, UNUM_CURRENCY_SYMBOL, currency.getSymbol());
        setSymbol(this.address, UNUM_INTL_CURRENCY_SYMBOL, currency.getCurrencyCode());
        // ---------- Original Method ----------
        //setSymbol(this.address, UNUM_CURRENCY_SYMBOL, currency.getSymbol());
        //setSymbol(this.address, UNUM_INTL_CURRENCY_SYMBOL, currency.getCurrencyCode());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.273 -0400", hash_original_method = "49FEA0DFBB56F17CB90E68E0F78CE577", hash_generated_method = "64496DA78FB66D27983BB2C813DEA747")
    public void setGroupingSize(int value) {
        addTaint(value);
        setAttribute(this.address, UNUM_GROUPING_SIZE, value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_GROUPING_SIZE, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.274 -0400", hash_original_method = "E302CDF79A67421C2D7FEEF4C305D93F", hash_generated_method = "AB2B286686CA5DD04F42EBCF1BE83425")
    public void setGroupingUsed(boolean value) {
        addTaint(value);
        int i = value ? -1 : 0;
        setAttribute(this.address, UNUM_GROUPING_USED, i);
        // ---------- Original Method ----------
        //int i = value ? -1 : 0;
        //setAttribute(this.address, UNUM_GROUPING_USED, i);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.274 -0400", hash_original_method = "758C6DB93C92764527C1135AD7160507", hash_generated_method = "C000D6AD7A44C687EB4BE4E340B0A920")
    public void setMaximumFractionDigits(int value) {
        addTaint(value);
        setAttribute(this.address, UNUM_MAX_FRACTION_DIGITS, value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_MAX_FRACTION_DIGITS, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.274 -0400", hash_original_method = "89C5389B02F633081323A23C8FB84870", hash_generated_method = "A21226E7951EFD8F1C6BB8A462525E5C")
    public void setMaximumIntegerDigits(int value) {
        addTaint(value);
        setAttribute(this.address, UNUM_MAX_INTEGER_DIGITS, value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_MAX_INTEGER_DIGITS, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.275 -0400", hash_original_method = "62DF7CF1343955ADCD931CBCC029C545", hash_generated_method = "29AE0E297533EEC7B279DE8372E2C159")
    public void setMinimumFractionDigits(int value) {
        addTaint(value);
        setAttribute(this.address, UNUM_MIN_FRACTION_DIGITS, value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_MIN_FRACTION_DIGITS, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.275 -0400", hash_original_method = "5D466EF26E9A120396C63069DE20CEB4", hash_generated_method = "838A52662540C12D55B8D5C735CBD1D5")
    public void setMinimumIntegerDigits(int value) {
        addTaint(value);
        setAttribute(this.address, UNUM_MIN_INTEGER_DIGITS, value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_MIN_INTEGER_DIGITS, value);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.275 -0400", hash_original_method = "B169BA3B31B9F8AB850C7AD451D65C7F", hash_generated_method = "09EBC652ED959626329C8BC07614B33D")
    public void setMultiplier(int value) {
        setAttribute(this.address, UNUM_MULTIPLIER, value);
        multiplierBigDecimal = BigDecimal.valueOf(value);
        // ---------- Original Method ----------
        //setAttribute(this.address, UNUM_MULTIPLIER, value);
        //multiplierBigDecimal = BigDecimal.valueOf(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.276 -0400", hash_original_method = "74BB5921C2CC61F7BCF8D1B8841FD51E", hash_generated_method = "ABD0A28DB84E5508630BA707856CF66A")
    public void setNegativePrefix(String value) {
        negPrefNull = value == null;
    if(!negPrefNull)        
        {
            setTextAttribute(this.address, UNUM_NEGATIVE_PREFIX, value);
        } //End block
        // ---------- Original Method ----------
        //negPrefNull = value == null;
        //if (!negPrefNull) {
            //setTextAttribute(this.address, UNUM_NEGATIVE_PREFIX, value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.276 -0400", hash_original_method = "0FF0A51DFB17D23D2B0F182081F1472B", hash_generated_method = "A2B7538039B9F28C20E52D1803BFEAAF")
    public void setNegativeSuffix(String value) {
        negSuffNull = value == null;
    if(!negSuffNull)        
        {
            setTextAttribute(this.address, UNUM_NEGATIVE_SUFFIX, value);
        } //End block
        // ---------- Original Method ----------
        //negSuffNull = value == null;
        //if (!negSuffNull) {
            //setTextAttribute(this.address, UNUM_NEGATIVE_SUFFIX, value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.277 -0400", hash_original_method = "FC20737C410620F82F4CED74F1142CF3", hash_generated_method = "84B839FC189572F3FFCBDC3987A3F8D0")
    public void setPositivePrefix(String value) {
        posPrefNull = value == null;
    if(!posPrefNull)        
        {
            setTextAttribute(this.address, UNUM_POSITIVE_PREFIX, value);
        } //End block
        // ---------- Original Method ----------
        //posPrefNull = value == null;
        //if (!posPrefNull) {
            //setTextAttribute(this.address, UNUM_POSITIVE_PREFIX, value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.277 -0400", hash_original_method = "48A175BA83D370BA86128EC6BAC61CB5", hash_generated_method = "185ADF780388B8651306507D83EB6E3D")
    public void setPositiveSuffix(String value) {
        posSuffNull = value == null;
    if(!posSuffNull)        
        {
            setTextAttribute(this.address, UNUM_POSITIVE_SUFFIX, value);
        } //End block
        // ---------- Original Method ----------
        //posSuffNull = value == null;
        //if (!posSuffNull) {
            //setTextAttribute(this.address, UNUM_POSITIVE_SUFFIX, value);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.278 -0400", hash_original_method = "16B3A7386DF3851CB73D32D9A838D98B", hash_generated_method = "A04CC31A40B62965DB9042EEB28F4644")
    public void setParseBigDecimal(boolean value) {
        parseBigDecimal = value;
        // ---------- Original Method ----------
        //parseBigDecimal = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.278 -0400", hash_original_method = "7FF47C5BC2EFAEE27B26A852A846EAFB", hash_generated_method = "4EE2163DB9BAF677C34C42F44485C385")
    public void setParseIntegerOnly(boolean value) {
        addTaint(value);
        int i = value ? -1 : 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.279 -0400", hash_original_method = "D542BB733096020C1E39876D678697A7", hash_generated_method = "B74D8EBBD2390B5DC6DF148DE340D9B7")
    public void setRoundingMode(RoundingMode roundingMode, double roundingIncrement) {
        addTaint(roundingIncrement);
        addTaint(roundingMode.getTaint());
        int nativeRoundingMode;
switch(roundingMode){
        case CEILING:
        nativeRoundingMode = 0;
        break;
        case FLOOR:
        nativeRoundingMode = 1;
        break;
        case DOWN:
        nativeRoundingMode = 2;
        break;
        case UP:
        nativeRoundingMode = 3;
        break;
        case HALF_EVEN:
        nativeRoundingMode = 4;
        break;
        case HALF_DOWN:
        nativeRoundingMode = 5;
        break;
        case HALF_UP:
        nativeRoundingMode = 6;
        break;
        default:
        AssertionError varA81442E36297E737EB908877E58260E8_1645637243 = new AssertionError();
        varA81442E36297E737EB908877E58260E8_1645637243.addTaint(taint);
        throw varA81442E36297E737EB908877E58260E8_1645637243;
}        setRoundingMode(address, nativeRoundingMode, roundingIncrement);
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

    
    @DSModeled(DSC.SAFE)
    private static void applyPatternImpl(int addr, boolean localized, String pattern) {
    }

    
    @DSModeled(DSC.SAFE)
    private static int cloneImpl(int addr) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2036702316 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2036702316;
    }

    
    @DSModeled(DSC.SAFE)
    private static void close(int addr) {
    }

    
    @DSModeled(DSC.SAFE)
    private static char[] formatLong(int addr, long value, FieldPositionIterator iter) {
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_478728693 = {DSUtils.UNKNOWN_CHAR};
        return var50607924ABD4C17119BAF3A1CE41C0EC_478728693;
    }

    
    @DSModeled(DSC.SAFE)
    private static char[] formatDouble(int addr, double value, FieldPositionIterator iter) {
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_1264013246 = {DSUtils.UNKNOWN_CHAR};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1264013246;
    }

    
    @DSModeled(DSC.SAFE)
    private static char[] formatDigitList(int addr, String value, FieldPositionIterator iter) {
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_1973734016 = {DSUtils.UNKNOWN_CHAR};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1973734016;
    }

    
    @DSModeled(DSC.SAFE)
    private static int getAttribute(int addr, int symbol) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1917559035 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1917559035;
    }

    
    @DSModeled(DSC.SAFE)
    private static String getTextAttribute(int addr, int symbol) {
    	String s = new String();
    	s.addTaint(symbol);
    	return s;
    }

    
    @DSModeled(DSC.SAFE)
    private static int open(String pattern, String currencySymbol,
            char decimalSeparator, char digit, String exponentSeparator, char groupingSeparator,
            String infinity, String internationalCurrencySymbol, char minusSign,
            char monetaryDecimalSeparator, String nan, char patternSeparator, char percent,
            char perMill, char zeroDigit) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1659367098 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1659367098;
    }

    
    @DSModeled(DSC.SAFE)
    private static Number parse(int addr, String string, ParsePosition position, boolean parseBigDecimal) {
    	Number ret;
    	if (parseBigDecimal) {
    		ret = new BigDecimal(1.0);
    		ret.addTaint(parseBigDecimal);
    		ret.addTaint(addr);
    		ret.addTaint(position.getTaint());
    		ret.addTaint(string.getTaint());
    	} else {
    		ret = new BigInteger("");
    		ret.addTaint(parseBigDecimal);
    		ret.addTaint(addr);
    		ret.addTaint(position.getTaint());
    		ret.addTaint(string.getTaint());
    	}
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    private static void setDecimalFormatSymbols(int addr, String currencySymbol,
            char decimalSeparator, char digit, String exponentSeparator, char groupingSeparator,
            String infinity, String internationalCurrencySymbol, char minusSign,
            char monetaryDecimalSeparator, String nan, char patternSeparator, char percent,
            char perMill, char zeroDigit) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void setSymbol(int addr, int symbol, String str) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void setAttribute(int addr, int symbol, int i) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void setRoundingMode(int addr, int roundingMode, double roundingIncrement) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void setTextAttribute(int addr, int symbol, String str) {
    }

    
    @DSModeled(DSC.SAFE)
    private static String toPatternImpl(int addr, boolean localized) {
    	String s = new String();
    	s.addTaint(localized);
    	return s;
    }

    
    private static class FieldPositionIterator {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.286 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "2F322A4CCA87DBF62C5291F2FA6D1538")

        private int[] data;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.286 -0400", hash_original_field = "41A87CD99CAC79C14134D1D8193C9405", hash_generated_field = "C812BD0A950A53E451CF78B187BCF580")

        private int pos = -3;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.286 -0400", hash_original_method = "3872533C5F4C6DF8E9B47456E87ABB09", hash_generated_method = "61C6C4E209B2EB1D194185007E303529")
        private  FieldPositionIterator() {
            // ---------- Original Method ----------
        }

        
                public static FieldPositionIterator forFieldPosition(FieldPosition fp) {
            if (fp != null && fp.getField() != -1) {
                return new FieldPositionIterator();
            }
            return null;
        }

        
                @DSModeled(DSC.SPEC)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.287 -0400", hash_original_method = "F9CA7CA9C759396A69CAFCECCE3A38CE", hash_generated_method = "CA58439BC6CD0ADE1FC0B56DFE85FAA1")
        public boolean next() {
    if(data == null || pos == data.length)            
            {
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_1713694644 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_1713694644.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_1713694644;
            } //End block
            pos += 3;
            boolean var7AC2A5D8985226C6CCB466A8CAEC56F5_1165987943 = (pos < data.length);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_615022416 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_615022416;
            // ---------- Original Method ----------
            //if (data == null || pos == data.length) {
                //throw new NoSuchElementException();
            //}
            //pos += 3;
            //return pos < data.length;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.288 -0400", hash_original_method = "28A52A04516ACAEA5CBE057E7005DC29", hash_generated_method = "6A4651E79B2AD901856B4CF83EAE007F")
        private void checkValid() {
    if(data == null || pos < 0 || pos == data.length)            
            {
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_394297710 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_394297710.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_394297710;
            } //End block
            // ---------- Original Method ----------
            //if (data == null || pos < 0 || pos == data.length) {
                //throw new NoSuchElementException();
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.288 -0400", hash_original_method = "F481D50CCC1AB38B4CA6D00583ECCD74", hash_generated_method = "1567EFBAB7FAC5F6CE2B17601B435E65")
        public int fieldId() {
            int var0F3108A7CB478B40D82FDA409BCEEA89_175097226 = (data[pos]);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_224857465 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_224857465;
            // ---------- Original Method ----------
            //return data[pos];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.289 -0400", hash_original_method = "B152D64258DA85AB1020B78F45482139", hash_generated_method = "885D7EBE13279F0AF9703E82B93C0601")
        public Format.Field field() {
            checkValid();
Format.Field var6997504BD7AD57E0F76526D97121C1E9_792431242 =             fields[data[pos]];
            var6997504BD7AD57E0F76526D97121C1E9_792431242.addTaint(taint);
            return var6997504BD7AD57E0F76526D97121C1E9_792431242;
            // ---------- Original Method ----------
            //checkValid();
            //return fields[data[pos]];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.289 -0400", hash_original_method = "573D89586F74B4B2EDB6530AAE1DEC79", hash_generated_method = "2165271E8FB8B7B1B73AF172B5D7045A")
        public int start() {
            checkValid();
            int var2A6E0793A07ED08AE6639010848C0C0E_448758724 = (data[pos + 1]);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1007941676 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1007941676;
            // ---------- Original Method ----------
            //checkValid();
            //return data[pos + 1];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.290 -0400", hash_original_method = "431D149304BC1F14DB944F0790F3E8B8", hash_generated_method = "5F78D9C1422AA7447E9D99334BD83F3D")
        public int limit() {
            checkValid();
            int var551E9255372266A293EFCDC7FEBE1724_753223224 = (data[pos + 2]);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1969126033 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1969126033;
            // ---------- Original Method ----------
            //checkValid();
            //return data[pos + 2];
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.290 -0400", hash_original_method = "E1A3B20A4A62E5F6661DF7F73A635F7C", hash_generated_method = "2FA05A6182FB4AA13AC353371D99B73A")
        private void setData(int[] data) {
            this.data = data;
            this.pos = -3;
            // ---------- Original Method ----------
            //this.data = data;
            //this.pos = -3;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.291 -0400", hash_original_field = "27D7A0AA47D8E9AD8DC4BF2D88186493", hash_generated_field = "C4A857D89644DD678C209850C71C6253")

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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.291 -0400", hash_original_field = "024283A17B4F858679487AA41D06F137", hash_generated_field = "38F9165B0D1718351C70E64071CF49B4")

    private static final int UNUM_DECIMAL_SEPARATOR_SYMBOL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.291 -0400", hash_original_field = "569D4CB22C567CCFA8FA28AA98AA481B", hash_generated_field = "A28375963190DB6399778744725103E6")

    private static final int UNUM_GROUPING_SEPARATOR_SYMBOL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.291 -0400", hash_original_field = "DC39C912818608D5EE416599EB02C2F1", hash_generated_field = "0ECCE7421BEB7BB4F15F8631211E592E")

    private static final int UNUM_PATTERN_SEPARATOR_SYMBOL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.291 -0400", hash_original_field = "2E48B57484F2D80820EE30D01A85762B", hash_generated_field = "83D35D18C1BB99CFDB91DD1A86FC9678")

    private static final int UNUM_PERCENT_SYMBOL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.292 -0400", hash_original_field = "B80F5415D213C71760D64C3F8655E103", hash_generated_field = "A137593AB67428AD25B40E8D7662626C")

    private static final int UNUM_ZERO_DIGIT_SYMBOL = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.292 -0400", hash_original_field = "849923D76D74AC9D2575F3FEB9D17105", hash_generated_field = "0BF7C44A4D4E7A6FCFBDC966AC9A3476")

    private static final int UNUM_DIGIT_SYMBOL = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.292 -0400", hash_original_field = "982740976D9454DA142BBB76FCB86E65", hash_generated_field = "17518293119C4123ADB20C78B6AFF1D9")

    private static final int UNUM_MINUS_SIGN_SYMBOL = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.292 -0400", hash_original_field = "D4A0AD0CDFD3BC5A192430B57716B330", hash_generated_field = "1DCA6AC28B3EA63C4A4D4065F3445F3E")

    private static final int UNUM_PLUS_SIGN_SYMBOL = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.292 -0400", hash_original_field = "6520A81D71399A74E18494DE8A2D2716", hash_generated_field = "13D25F549CCD80A7958357D90F76BF36")

    private static final int UNUM_CURRENCY_SYMBOL = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.292 -0400", hash_original_field = "4EBC0BEF182CD31FB42F775EAD2D9A1C", hash_generated_field = "871E41AB05FA295AFDB080EA0ED3BFC5")

    private static final int UNUM_INTL_CURRENCY_SYMBOL = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.292 -0400", hash_original_field = "82EF848B759F95741D1982E35EBEEA19", hash_generated_field = "EEE69206D44FBEDEC2F848E246637D7D")

    private static final int UNUM_MONETARY_SEPARATOR_SYMBOL = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.292 -0400", hash_original_field = "EBFE24817B35301033E4034E3B5AFB93", hash_generated_field = "5DD2C0F9414476738084073736C6DD24")

    private static final int UNUM_EXPONENTIAL_SYMBOL = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.292 -0400", hash_original_field = "555A332569EBE4B181F44ADCCF0603D5", hash_generated_field = "E328F5A776A1D9EA915373443B4D1D36")

    private static final int UNUM_PERMILL_SYMBOL = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.292 -0400", hash_original_field = "6F0C8024A801549CF944CDBEFDB9DDB4", hash_generated_field = "FDD5FB07C1A11F2186831D8D8D4B07C5")

    private static final int UNUM_PAD_ESCAPE_SYMBOL = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.293 -0400", hash_original_field = "378FA79958A996A5E9BC4BFADD42352C", hash_generated_field = "00A8062220A299E144D758B6640F827D")

    private static final int UNUM_INFINITY_SYMBOL = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.293 -0400", hash_original_field = "8B4BB88522F81B591874E385E981297F", hash_generated_field = "FF98C79010DA951498FB4C5A5099EC0F")

    private static final int UNUM_NAN_SYMBOL = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.293 -0400", hash_original_field = "F86892C3522DEA90F517C4C5467386D5", hash_generated_field = "C24949E7E71025158E3BECC52FE6AEE8")

    private static final int UNUM_SIGNIFICANT_DIGIT_SYMBOL = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.293 -0400", hash_original_field = "53E1C966A8C817CC8509732458E431F8", hash_generated_field = "217B639C06D518F013EA3AFBC1159BEA")

    private static final int UNUM_MONETARY_GROUPING_SEPARATOR_SYMBOL = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.293 -0400", hash_original_field = "6944D02F190693EAEBF8A29CD17CA79C", hash_generated_field = "445837AD1924D5714BE388A67163A553")

    private static final int UNUM_FORMAT_SYMBOL_COUNT = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.293 -0400", hash_original_field = "8971AE23D0ACB2019E7F237C1A5D9057", hash_generated_field = "8BADA870B3144CAE14BC1B1303AFD2E0")

    private static final int UNUM_PARSE_INT_ONLY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.293 -0400", hash_original_field = "46581E7ADB623C966C46F86CBCA1ACA7", hash_generated_field = "7D1C329BEE2B035F9F233564C570028F")

    private static final int UNUM_GROUPING_USED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.293 -0400", hash_original_field = "D0A1191C6B8058293B62F4EB5CB139F7", hash_generated_field = "7A36CC1B192B3B1AADAF3A7C042D87DC")

    private static final int UNUM_DECIMAL_ALWAYS_SHOWN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.293 -0400", hash_original_field = "6A692975BF789004FF9BCD7ED2595754", hash_generated_field = "619A906F0DBD204A3D5EF39E61783952")

    private static final int UNUM_MAX_INTEGER_DIGITS = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.293 -0400", hash_original_field = "BFCDA61A6544D8200FB16C8ECAB194D9", hash_generated_field = "AD2EFDD3044D52B7569692F528421BFA")

    private static final int UNUM_MIN_INTEGER_DIGITS = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.294 -0400", hash_original_field = "DA0B7AFB468402B4FAB627D7A9AFFACE", hash_generated_field = "D3D4DF73C2432699E2CED910F4AC2552")

    private static final int UNUM_INTEGER_DIGITS = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.294 -0400", hash_original_field = "5750A34FC87461228B5037583C2CE979", hash_generated_field = "F0171186645CD6B003F45EE6BD32357E")

    private static final int UNUM_MAX_FRACTION_DIGITS = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.294 -0400", hash_original_field = "BE2E1373EE438BBC72E5EEA62F6EEFCE", hash_generated_field = "C0FAFB0D9C2B9DDEC85E66C9595CE14D")

    private static final int UNUM_MIN_FRACTION_DIGITS = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.294 -0400", hash_original_field = "C0D0E977100ACCBC9B8F77297A991F0A", hash_generated_field = "77B731D6D431A67B9FBD265D21C6B4E3")

    private static final int UNUM_FRACTION_DIGITS = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.294 -0400", hash_original_field = "4FFB3432E077BDF4076A364D312B6322", hash_generated_field = "D7D1DB6D490350ED0F56C66BA87D59DB")

    private static final int UNUM_MULTIPLIER = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.294 -0400", hash_original_field = "68EDF621E4AEA7D984951F9A8C68B508", hash_generated_field = "05CB2CE6529FD0E1150F6A0CE43ECDDA")

    private static final int UNUM_GROUPING_SIZE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.294 -0400", hash_original_field = "3180DB5CC7990CFC070810D65823E15E", hash_generated_field = "AE8E7BB146CFC987266EF6FCBEEA9CFA")

    private static final int UNUM_ROUNDING_MODE = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.294 -0400", hash_original_field = "EB76EFADD49B90471770F624C07D79A9", hash_generated_field = "D211C7D2DA9A6A02C05730209957713D")

    private static final int UNUM_ROUNDING_INCREMENT = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.294 -0400", hash_original_field = "2E1629A5A9F1DEAF1A18A9539618D4D5", hash_generated_field = "1BEE2F7A86DF9CC0CF422419F6C7E6AC")

    private static final int UNUM_FORMAT_WIDTH = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.295 -0400", hash_original_field = "B760C9A8428FD459E7B9827858CFD779", hash_generated_field = "1137CDEF8C77585315595AE0160B7096")

    private static final int UNUM_PADDING_POSITION = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.295 -0400", hash_original_field = "D7D95CD560376F364890DB0FD74EB85B", hash_generated_field = "06F7E6232D5F36D4B36C8F433D1A4815")

    private static final int UNUM_SECONDARY_GROUPING_SIZE = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.295 -0400", hash_original_field = "5CA0ED7747BDD5FD9CA45EC2E6F0E8B5", hash_generated_field = "B6C735B849850BC33558BDF5305AFBDF")

    private static final int UNUM_SIGNIFICANT_DIGITS_USED = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.295 -0400", hash_original_field = "CED3E3C034EC98CD8CA99E728B988C9E", hash_generated_field = "6A53E30035D626AEBE7319CC56976B5E")

    private static final int UNUM_MIN_SIGNIFICANT_DIGITS = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.295 -0400", hash_original_field = "3E30604D3F70C6D8BE917DAB3E65F7C2", hash_generated_field = "60312495E62249A683DE9D887813078C")

    private static final int UNUM_MAX_SIGNIFICANT_DIGITS = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.295 -0400", hash_original_field = "D64F4F2459B0190DFFBA9826AC72489F", hash_generated_field = "17FDB153D06831EFA445923876F0F9CD")

    private static final int UNUM_LENIENT_PARSE = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.295 -0400", hash_original_field = "E81D0E837BFCCE8B299F86B2B0379AA1", hash_generated_field = "CB0BDBA3DAAC06D26A2A81C71F65DE46")

    private static final int UNUM_POSITIVE_PREFIX = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.295 -0400", hash_original_field = "ACAF14DFBF527393BF01C453C005773D", hash_generated_field = "BA1D392F17BF7442D6C4A8ED2218F953")

    private static final int UNUM_POSITIVE_SUFFIX = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.295 -0400", hash_original_field = "3B4AAFD666329CD2E14C939EB5493111", hash_generated_field = "3B7B2C3FEE6B7373D124C61F621AAECB")

    private static final int UNUM_NEGATIVE_PREFIX = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.296 -0400", hash_original_field = "B914446D1D897950976F6F9F6EEBD0B7", hash_generated_field = "7ADB5843D6F5347E296883E0AD4E2AC6")

    private static final int UNUM_NEGATIVE_SUFFIX = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.296 -0400", hash_original_field = "4E39F122ADFEC6840ACE999C184C9EE2", hash_generated_field = "EA8C72D1176DA844AB8FAB8C5B840969")

    private static final int UNUM_PADDING_CHARACTER = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.296 -0400", hash_original_field = "36CCE6C77A18DA6E36931EF0CD49A9BB", hash_generated_field = "F54C128E1E1EA1DBED16FA7AC15596DC")

    private static final int UNUM_CURRENCY_CODE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.296 -0400", hash_original_field = "FBB3BE349F8C0AB42CE7BA4DD07A0976", hash_generated_field = "C71921E41D4DB8B96035181BECB3F4C9")

    private static final int UNUM_DEFAULT_RULESET = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.296 -0400", hash_original_field = "A63C4BE0875A4094DC60472905775981", hash_generated_field = "0401D7F0EFF53BBDD616982052AEAE8F")

    private static final int UNUM_PUBLIC_RULESETS = 7;
}

