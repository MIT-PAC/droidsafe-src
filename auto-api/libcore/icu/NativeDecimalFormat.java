package libcore.icu;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.665 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "849BAB492558B51E7BC4F1C331A435E4")

    private int address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.665 -0400", hash_original_field = "344BCC24F3464715940DD56604C8D74D", hash_generated_field = "5F7D5D3D7F66CE031779F4BACE74C549")

    private String lastPattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.665 -0400", hash_original_field = "FE0C344D27B5DDD52EE172F18436517A", hash_generated_field = "A56A7DCB118482C05DDF4AEBE99FDB15")

    private boolean negPrefNull;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.665 -0400", hash_original_field = "847370D067A7C3F3858025EC1AE68504", hash_generated_field = "2505E1D75E0C167EE76E4EF5DDA36BE9")

    private boolean negSuffNull;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.665 -0400", hash_original_field = "61EA484D190CD4F0A57205D48CFCE039", hash_generated_field = "CDAAA116F4BD28B5162A921B2B1BA25F")

    private boolean posPrefNull;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.665 -0400", hash_original_field = "C30F6031C7DF0B30F08B2845ADE90423", hash_generated_field = "E9F9066E16BD9AB176D3C016B62231F0")

    private boolean posSuffNull;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.665 -0400", hash_original_field = "287D1050A38F78BCF10BE8BDFB1C701E", hash_generated_field = "622CB2D56C22AE9A04568955FFFF4B33")

    private transient boolean parseBigDecimal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.665 -0400", hash_original_field = "EBBDEA416E09F573B73D6D6E43EF5083", hash_generated_field = "C24355A01F90DF3021CC166940F4BB14")

    private BigDecimal multiplierBigDecimal = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.666 -0400", hash_original_method = "D8AEBC26DB4CF2E0C933D0F5B84F659E", hash_generated_method = "A534F428BF436EFFCF7D5C20409BC3AD")
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
        } 
        catch (NullPointerException npe)
        {
            if (DroidSafeAndroidRuntime.control) throw npe;
        } 
        catch (RuntimeException re)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("syntax error: " + re.getMessage() + ": " + pattern);
        } 
        
        
            
                    
                    
                    
                    
                    
            
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.666 -0400", hash_original_method = "03415942CECEA3C928FA024ACF038523", hash_generated_method = "D2E674819D4F909C96BFFA4F1D82A4EF")
    public  NativeDecimalFormat(String pattern, LocaleData data) {
        this.address = open(pattern, data.currencySymbol,
                data.decimalSeparator, '#', data.exponentSeparator, data.groupingSeparator,
                data.infinity, data.internationalCurrencySymbol, data.minusSign,
                data.monetarySeparator, data.NaN, data.patternSeparator,
                data.percent, data.perMill, data.zeroDigit);
        this.lastPattern = pattern;
        
        
                
                
                
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.667 -0400", hash_original_method = "F2FB63D256AD622AD0AA1906E5944DB2", hash_generated_method = "5AAFFDF8705B718E89082099B750E33B")
    private  NativeDecimalFormat(NativeDecimalFormat other) {
        this.address = cloneImpl(other.address);
        this.lastPattern = other.lastPattern;
        this.negPrefNull = other.negPrefNull;
        this.negSuffNull = other.negSuffNull;
        this.posPrefNull = other.posPrefNull;
        this.posSuffNull = other.posSuffNull;
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.667 -0400", hash_original_method = "C197288C8DD3954567266901B60BE5B8", hash_generated_method = "B2926F2A13E0EE5AEFE1D187448163DB")
    @Override
    public int hashCode() {
        int var8C9A345D8B4C41F5F6C3E9546CE693DB_1932883180 = (this.getPositivePrefix().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1280003994 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1280003994;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.667 -0400", hash_original_method = "5C171A463B7BB08FCE40648C7CE8F861", hash_generated_method = "36CAD6210CFA016FE9122A2E563AE993")
    public synchronized void close() {
        {
            close(address);
            address = 0;
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.668 -0400", hash_original_method = "D252F6FD4E111780C248C256B2516FF2", hash_generated_method = "C361812F472423283FCA9024FB4F26EA")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1592016292 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1592016292 = new NativeDecimalFormat(this);
        varB4EAC82CA7396A68D541C85D26508E83_1592016292.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1592016292;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.669 -0400", hash_original_method = "220130DBC584D5B5D45771D972950D18", hash_generated_method = "94ADF234B6F36D9B4C0F539C7F2921FB")
    @Override
    public boolean equals(Object object) {
        {
            boolean var3F549205D4C262003697A031F89E5954_711877889 = (object == this);
        } 
        NativeDecimalFormat obj = (NativeDecimalFormat) object;
        boolean var18FBB52F731808A4077D23FDD981869A_672861029 = (obj.toPattern().equals(this.toPattern()) &&
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_952668373 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_952668373;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.670 -0400", hash_original_method = "6B8DF144F51335DB9B33B1BD0598F087", hash_generated_method = "F50D865A25252BAB9C1E1E1C12F08C9E")
    public void setDecimalFormatSymbols(final DecimalFormatSymbols dfs) {
        setDecimalFormatSymbols(this.address, dfs.getCurrencySymbol(), dfs.getDecimalSeparator(),
                dfs.getDigit(), dfs.getExponentSeparator(), dfs.getGroupingSeparator(),
                dfs.getInfinity(), dfs.getInternationalCurrencySymbol(), dfs.getMinusSign(),
                dfs.getMonetaryDecimalSeparator(), dfs.getNaN(), dfs.getPatternSeparator(),
                dfs.getPercent(), dfs.getPerMill(), dfs.getZeroDigit());
        addTaint(dfs.getTaint());
        
        
                
                
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.670 -0400", hash_original_method = "5FE0177EB5130C508ECEC468A64D96E3", hash_generated_method = "8EF61A24B2109F9772578EEB2CC2CBE1")
    public void setDecimalFormatSymbols(final LocaleData localeData) {
        setDecimalFormatSymbols(this.address, localeData.currencySymbol, localeData.decimalSeparator,
                '#', localeData.exponentSeparator, localeData.groupingSeparator,
                localeData.infinity, localeData.internationalCurrencySymbol, localeData.minusSign,
                localeData.monetarySeparator, localeData.NaN, localeData.patternSeparator,
                localeData.percent, localeData.perMill, localeData.zeroDigit);
        addTaint(localeData.getTaint());
        
        
                
                
                
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.671 -0400", hash_original_method = "E3DC36059DBEEA918EB4DAC2E3F69056", hash_generated_method = "39BF4338FB009C6CD6B3708FBAD0AADC")
    public char[] formatBigDecimal(BigDecimal value, FieldPosition field) {
        FieldPositionIterator fpi = FieldPositionIterator.forFieldPosition(field);
        char[] result = formatDigitList(this.address, value.toString(), fpi);
        {
            FieldPositionIterator.setFieldPosition(fpi, field);
        } 
        addTaint(value.getTaint());
        addTaint(field.getTaint());
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1161584332 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1161584332;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.671 -0400", hash_original_method = "AB58B0DEED1650663505F868BCDB9A76", hash_generated_method = "0277233A98920DBA8CC5AB72DABEE02B")
    public char[] formatBigInteger(BigInteger value, FieldPosition field) {
        FieldPositionIterator fpi = FieldPositionIterator.forFieldPosition(field);
        char[] result = formatDigitList(this.address, value.toString(10), fpi);
        {
            FieldPositionIterator.setFieldPosition(fpi, field);
        } 
        addTaint(value.getTaint());
        addTaint(field.getTaint());
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1664102226 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1664102226;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.671 -0400", hash_original_method = "E280C21CEDC9C41E32AB3781E6354849", hash_generated_method = "994B73A6CB8871832DB92A1E025C1C12")
    public char[] formatLong(long value, FieldPosition field) {
        FieldPositionIterator fpi = FieldPositionIterator.forFieldPosition(field);
        char[] result = formatLong(this.address, value, fpi);
        {
            FieldPositionIterator.setFieldPosition(fpi, field);
        } 
        addTaint(value);
        addTaint(field.getTaint());
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1665727766 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1665727766;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.672 -0400", hash_original_method = "2B822D9FBF334F04026E765F63D8EA7D", hash_generated_method = "95228327C180FEE2566EDDF1D22491AD")
    public char[] formatDouble(double value, FieldPosition field) {
        FieldPositionIterator fpi = FieldPositionIterator.forFieldPosition(field);
        char[] result = formatDouble(this.address, value, fpi);
        {
            FieldPositionIterator.setFieldPosition(fpi, field);
        } 
        addTaint(value);
        addTaint(field.getTaint());
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_22659319 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_22659319;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.672 -0400", hash_original_method = "521D68694A0F2FF9FD004D1F044248B6", hash_generated_method = "626CB7EAC0C2AC2D31677753DB78F3D3")
    public void applyLocalizedPattern(String pattern) {
        applyPattern(this.address, true, pattern);
        lastPattern = null;
        addTaint(pattern.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.672 -0400", hash_original_method = "105E6A8350C3ECD2CBDC93E6E74AA17C", hash_generated_method = "833BB0F24BB86ED21422DD8F2DDBDE6D")
    public void applyPattern(String pattern) {
        {
            boolean var30056E56F7633573B6C2DD284E929162_1881993685 = (lastPattern != null && pattern.equals(lastPattern));
        } 
        applyPattern(this.address, false, pattern);
        lastPattern = pattern;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.673 -0400", hash_original_method = "9FEF3AE5E61C347D525A9585FBE19ECF", hash_generated_method = "7016E3136F382EDB5DC04B8618FE86F8")
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        AttributedCharacterIterator varB4EAC82CA7396A68D541C85D26508E83_885099565 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        Number number = (Number) object;
        FieldPositionIterator fpIter = new FieldPositionIterator();
        String text;
        {
            text = new String(formatDigitList(this.address, number.toString(), fpIter));
        } 
        {
            double dv = number.doubleValue();
            text = new String(formatDouble(this.address, dv, fpIter));
        } 
        {
            long lv = number.longValue();
            text = new String(formatLong(this.address, lv, fpIter));
        } 
        AttributedString as = new AttributedString(text);
        {
            boolean varC94C796D691F3725A70F62B7F781E92F_1993369111 = (fpIter.next());
            {
                Format.Field field = fpIter.field();
                as.addAttribute(field, field, fpIter.start(), fpIter.limit());
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_885099565 = as.getIterator();
        addTaint(object.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_885099565.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_885099565;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.674 -0400", hash_original_method = "E9B105AB178BFBFEB280AF82F381CE84", hash_generated_method = "59F203B31B3097C78E7A1CB4F696DA43")
    private int makeScalePositive(int scale, StringBuilder val) {
        {
            scale = -scale;
            {
                int i = scale;
                {
                    val.append('0');
                } 
            } 
            scale = 0;
        } 
        addTaint(scale);
        addTaint(val.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_929547114 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_929547114;
        
        
            
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.674 -0400", hash_original_method = "1F42A3AAFB142AE620B1A14F6DE6CCC5", hash_generated_method = "DE0215914E26CE563B1F059079C9F9C8")
    public String toLocalizedPattern() {
        String varB4EAC82CA7396A68D541C85D26508E83_154443848 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_154443848 = toPatternImpl(this.address, true);
        varB4EAC82CA7396A68D541C85D26508E83_154443848.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_154443848;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.674 -0400", hash_original_method = "D90F2C106608034D601A7F076DF301BD", hash_generated_method = "559AB3949B7F05AEFF824A6FE759BA9D")
    public String toPattern() {
        String varB4EAC82CA7396A68D541C85D26508E83_1860088974 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1860088974 = toPatternImpl(this.address, false);
        varB4EAC82CA7396A68D541C85D26508E83_1860088974.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1860088974;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.675 -0400", hash_original_method = "C24C75386265F50BCF75B046D9BE3ACC", hash_generated_method = "265C3DEB827FAF54CD284DC03A98030B")
    public Number parse(String string, ParsePosition position) {
        Number varB4EAC82CA7396A68D541C85D26508E83_641098157 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_641098157 = parse(address, string, position, parseBigDecimal);
        addTaint(string.getTaint());
        addTaint(position.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_641098157.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_641098157;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.675 -0400", hash_original_method = "00B4402833BBD0AA4B8B3DAC69045BF5", hash_generated_method = "28292860FE5C80B882228C2909A957D2")
    public int getMaximumFractionDigits() {
        int var2031882FA64042FA8714F056BC326B77_2006222588 = (getAttribute(this.address, UNUM_MAX_FRACTION_DIGITS));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_956748369 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_956748369;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.675 -0400", hash_original_method = "39458F699020062C4A2A7E5A13FEC803", hash_generated_method = "C42B719784F10348C147CC06CA273AFE")
    public int getMaximumIntegerDigits() {
        int var552BC4AA7CD66CB5C86DC39DD6F5EB61_664565450 = (getAttribute(this.address, UNUM_MAX_INTEGER_DIGITS));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1469083822 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1469083822;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.676 -0400", hash_original_method = "2493C2169723FB0932E2841ED5413767", hash_generated_method = "5EBC8A6303AB7DBA50CAC41DE2D263ED")
    public int getMinimumFractionDigits() {
        int var651D9F7029A8FF147A685A36D32AA845_1203589061 = (getAttribute(this.address, UNUM_MIN_FRACTION_DIGITS));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_628452136 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_628452136;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.677 -0400", hash_original_method = "C287E89D9CA249987BAB41DA58A603BE", hash_generated_method = "AF3E812F1125C0A9C0E15F8988A24B92")
    public int getMinimumIntegerDigits() {
        int varE7531A98F2A0AD2779754CD1B2865E0B_1160085465 = (getAttribute(this.address, UNUM_MIN_INTEGER_DIGITS));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1755387443 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1755387443;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.677 -0400", hash_original_method = "C63E831A66DAEA25345E39BD0E8C902A", hash_generated_method = "F16DB2BF35ECDB8E9C2A519D534E2D8B")
    public int getGroupingSize() {
        int varEBCCDDFF415DDB22660365F0FC4A83FC_2122028024 = (getAttribute(this.address, UNUM_GROUPING_SIZE));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_566642255 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_566642255;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.677 -0400", hash_original_method = "195B15A30ECFDD2DA316EFD7F1135C74", hash_generated_method = "45D5FDDA7BD4BB14836E9804C022727F")
    public int getMultiplier() {
        int var2028C5EE807D8F87AD09F7ADE0783DF7_1926214797 = (getAttribute(this.address, UNUM_MULTIPLIER));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1718214232 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1718214232;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.678 -0400", hash_original_method = "6BE8F2BF8B3A5604EA6D6E250F279823", hash_generated_method = "E93E79F9D3B656EF666B2DD6E88F7698")
    public String getNegativePrefix() {
        String varB4EAC82CA7396A68D541C85D26508E83_1510265450 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1336436414 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1510265450 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1336436414 = getTextAttribute(this.address, UNUM_NEGATIVE_PREFIX);
        String varA7E53CE21691AB073D9660D615818899_1098378333; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1098378333 = varB4EAC82CA7396A68D541C85D26508E83_1510265450;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1098378333 = varB4EAC82CA7396A68D541C85D26508E83_1336436414;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1098378333.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1098378333;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.678 -0400", hash_original_method = "3B3EF8E26C12E3D51B48D0C30732D5F5", hash_generated_method = "A87C025DA1325FFA7B58A0B6DB40697E")
    public String getNegativeSuffix() {
        String varB4EAC82CA7396A68D541C85D26508E83_677894135 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_95071411 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_677894135 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_95071411 = getTextAttribute(this.address, UNUM_NEGATIVE_SUFFIX);
        String varA7E53CE21691AB073D9660D615818899_841228886; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_841228886 = varB4EAC82CA7396A68D541C85D26508E83_677894135;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_841228886 = varB4EAC82CA7396A68D541C85D26508E83_95071411;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_841228886.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_841228886;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.679 -0400", hash_original_method = "8D4D6B90A746E09AE36173ABA0AB4B15", hash_generated_method = "A81DCE1E0C0A6569D05ABDCEBE40B907")
    public String getPositivePrefix() {
        String varB4EAC82CA7396A68D541C85D26508E83_1410968848 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1949490375 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1410968848 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1949490375 = getTextAttribute(this.address, UNUM_POSITIVE_PREFIX);
        String varA7E53CE21691AB073D9660D615818899_741419764; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_741419764 = varB4EAC82CA7396A68D541C85D26508E83_1410968848;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_741419764 = varB4EAC82CA7396A68D541C85D26508E83_1949490375;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_741419764.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_741419764;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.679 -0400", hash_original_method = "6CFE84E5B71B94B0DE7447BA68FEA246", hash_generated_method = "B9A46F13379AEB9C11586DC0E0E5BFE8")
    public String getPositiveSuffix() {
        String varB4EAC82CA7396A68D541C85D26508E83_720156155 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1872649226 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_720156155 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1872649226 = getTextAttribute(this.address, UNUM_POSITIVE_SUFFIX);
        String varA7E53CE21691AB073D9660D615818899_1414591119; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1414591119 = varB4EAC82CA7396A68D541C85D26508E83_720156155;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1414591119 = varB4EAC82CA7396A68D541C85D26508E83_1872649226;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1414591119.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1414591119;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.680 -0400", hash_original_method = "F9B59ECC893A5B014F6155ABE9703BF1", hash_generated_method = "752513678210359658F53F9BA510339D")
    public boolean isDecimalSeparatorAlwaysShown() {
        boolean var3E4313CD429F3F78E13F34D688881F5E_1851044443 = (getAttribute(this.address, UNUM_DECIMAL_ALWAYS_SHOWN) != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_762060310 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_762060310;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.680 -0400", hash_original_method = "84561142CC409560F18895112EB228ED", hash_generated_method = "4ABF34803F0C3BB17B8FBA4B20C4B3AC")
    public boolean isParseBigDecimal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_101936727 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_101936727;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.680 -0400", hash_original_method = "1D326E5349B9E5A9AED64258AB68CB41", hash_generated_method = "DE6BA8437DA31DB99BC36BD11D8C5A08")
    public boolean isParseIntegerOnly() {
        boolean var58CA17599706E2BD9D06C2CCBA6B89AB_1206274534 = (getAttribute(this.address, UNUM_PARSE_INT_ONLY) != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1606145417 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1606145417;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.680 -0400", hash_original_method = "00E8502D2DA3C0C73215E5BC5979A07C", hash_generated_method = "7162B71E67E463E352E414AD40C86AD4")
    public boolean isGroupingUsed() {
        boolean var875BD0DB8C0EE50D68D0C6793AE8DABD_702726433 = (getAttribute(this.address, UNUM_GROUPING_USED) != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2026775995 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2026775995;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.681 -0400", hash_original_method = "4515EB7BD614742B3D0DDD5748BC74D6", hash_generated_method = "B8B0456587560093071500C9C0FCAE5E")
    public void setDecimalSeparatorAlwaysShown(boolean value) {
        int i;
        i = -1;
        i = 0;
        setAttribute(this.address, UNUM_DECIMAL_ALWAYS_SHOWN, i);
        addTaint(value);
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.681 -0400", hash_original_method = "27959CC6793546F59976E7DBD15119DA", hash_generated_method = "E9FFB17EAD4EA0D712632E876D6C36D5")
    public void setCurrency(Currency currency) {
        setSymbol(this.address, UNUM_CURRENCY_SYMBOL, currency.getSymbol());
        setSymbol(this.address, UNUM_INTL_CURRENCY_SYMBOL, currency.getCurrencyCode());
        addTaint(currency.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.681 -0400", hash_original_method = "49FEA0DFBB56F17CB90E68E0F78CE577", hash_generated_method = "EC4442CDE4C2F319FBDABF66B7010AFB")
    public void setGroupingSize(int value) {
        setAttribute(this.address, UNUM_GROUPING_SIZE, value);
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.682 -0400", hash_original_method = "E302CDF79A67421C2D7FEEF4C305D93F", hash_generated_method = "792F56F062246284C7ECE4AAAA26AE86")
    public void setGroupingUsed(boolean value) {
        int i;
        i = -1;
        i = 0;
        setAttribute(this.address, UNUM_GROUPING_USED, i);
        addTaint(value);
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.682 -0400", hash_original_method = "758C6DB93C92764527C1135AD7160507", hash_generated_method = "64C5C48B47DB480798C2AFF0D3819358")
    public void setMaximumFractionDigits(int value) {
        setAttribute(this.address, UNUM_MAX_FRACTION_DIGITS, value);
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.683 -0400", hash_original_method = "89C5389B02F633081323A23C8FB84870", hash_generated_method = "9BE9DDE05F7F7A37CB2E326D3E2123B3")
    public void setMaximumIntegerDigits(int value) {
        setAttribute(this.address, UNUM_MAX_INTEGER_DIGITS, value);
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.686 -0400", hash_original_method = "62DF7CF1343955ADCD931CBCC029C545", hash_generated_method = "0D04383E51DB8E8945118D5D47457FCC")
    public void setMinimumFractionDigits(int value) {
        setAttribute(this.address, UNUM_MIN_FRACTION_DIGITS, value);
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.687 -0400", hash_original_method = "5D466EF26E9A120396C63069DE20CEB4", hash_generated_method = "D0CBC6A8D932BD845AF8513FB005E1E7")
    public void setMinimumIntegerDigits(int value) {
        setAttribute(this.address, UNUM_MIN_INTEGER_DIGITS, value);
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.688 -0400", hash_original_method = "B169BA3B31B9F8AB850C7AD451D65C7F", hash_generated_method = "09EBC652ED959626329C8BC07614B33D")
    public void setMultiplier(int value) {
        setAttribute(this.address, UNUM_MULTIPLIER, value);
        multiplierBigDecimal = BigDecimal.valueOf(value);
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.688 -0400", hash_original_method = "74BB5921C2CC61F7BCF8D1B8841FD51E", hash_generated_method = "C4DAAC223C73D5280FF1AECBB891C728")
    public void setNegativePrefix(String value) {
        negPrefNull = value == null;
        {
            setTextAttribute(this.address, UNUM_NEGATIVE_PREFIX, value);
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.689 -0400", hash_original_method = "0FF0A51DFB17D23D2B0F182081F1472B", hash_generated_method = "79F6037D750EDFA1DC0ED4FD3C7377C7")
    public void setNegativeSuffix(String value) {
        negSuffNull = value == null;
        {
            setTextAttribute(this.address, UNUM_NEGATIVE_SUFFIX, value);
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.690 -0400", hash_original_method = "FC20737C410620F82F4CED74F1142CF3", hash_generated_method = "7C1C2C38F30484A1BDBFC4383517B9CA")
    public void setPositivePrefix(String value) {
        posPrefNull = value == null;
        {
            setTextAttribute(this.address, UNUM_POSITIVE_PREFIX, value);
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.690 -0400", hash_original_method = "48A175BA83D370BA86128EC6BAC61CB5", hash_generated_method = "132EBBDC2763FE4573B3F9983677074F")
    public void setPositiveSuffix(String value) {
        posSuffNull = value == null;
        {
            setTextAttribute(this.address, UNUM_POSITIVE_SUFFIX, value);
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.691 -0400", hash_original_method = "16B3A7386DF3851CB73D32D9A838D98B", hash_generated_method = "A04CC31A40B62965DB9042EEB28F4644")
    public void setParseBigDecimal(boolean value) {
        parseBigDecimal = value;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.691 -0400", hash_original_method = "7FF47C5BC2EFAEE27B26A852A846EAFB", hash_generated_method = "CB50EF700F4EE81341E89A29CAB95719")
    public void setParseIntegerOnly(boolean value) {
        int i;
        i = -1;
        i = 0;
        setAttribute(this.address, UNUM_PARSE_INT_ONLY, i);
        addTaint(value);
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    private static void applyPattern(int addr, boolean localized, String pattern) {
        try {
            applyPatternImpl(addr, localized, pattern);
        } catch (NullPointerException npe) {
            throw npe;
        } catch (RuntimeException re) {
            throw new IllegalArgumentException("syntax error: " + re.getMessage() + ": " + pattern);
        }
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.693 -0400", hash_original_method = "D542BB733096020C1E39876D678697A7", hash_generated_method = "5601AC6A55BB8B8AC389EDE8D8DE38ED")
    public void setRoundingMode(RoundingMode roundingMode, double roundingIncrement) {
        int nativeRoundingMode;
        
        nativeRoundingMode = 0;
        
        
        nativeRoundingMode = 1;
        
        
        nativeRoundingMode = 2;
        
        
        nativeRoundingMode = 3;
        
        
        nativeRoundingMode = 4;
        
        
        nativeRoundingMode = 5;
        
        
        nativeRoundingMode = 6;
        
        
        if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        
        setRoundingMode(address, nativeRoundingMode, roundingIncrement);
        addTaint(roundingMode.getTaint());
        addTaint(roundingIncrement);
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    private static void applyPatternImpl(int addr, boolean localized, String pattern) {
    }

    
    private static int cloneImpl(int addr) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2036702316 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2036702316;
    }

    
    private static void close(int addr) {
    }

    
    private static char[] formatLong(int addr, long value, FieldPositionIterator iter) {
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_478728693 = {DSUtils.UNKNOWN_CHAR};
        return var50607924ABD4C17119BAF3A1CE41C0EC_478728693;
    }

    
    private static char[] formatDouble(int addr, double value, FieldPositionIterator iter) {
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_1264013246 = {DSUtils.UNKNOWN_CHAR};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1264013246;
    }

    
    private static char[] formatDigitList(int addr, String value, FieldPositionIterator iter) {
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_1973734016 = {DSUtils.UNKNOWN_CHAR};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1973734016;
    }

    
    private static int getAttribute(int addr, int symbol) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1917559035 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1917559035;
    }

    
    private static String getTextAttribute(int addr, int symbol) {
    	String s = new String();
    	s.addTaint(symbol);
    	return s;
    }

    
    private static int open(String pattern, String currencySymbol,
            char decimalSeparator, char digit, String exponentSeparator, char groupingSeparator,
            String infinity, String internationalCurrencySymbol, char minusSign,
            char monetaryDecimalSeparator, String nan, char patternSeparator, char percent,
            char perMill, char zeroDigit) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1659367098 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1659367098;
    }

    
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
    	String s = new String();
    	s.addTaint(localized);
    	return s;
    }

    
    private static class FieldPositionIterator {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.697 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "2F322A4CCA87DBF62C5291F2FA6D1538")

        private int[] data;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.697 -0400", hash_original_field = "41A87CD99CAC79C14134D1D8193C9405", hash_generated_field = "C812BD0A950A53E451CF78B187BCF580")

        private int pos = -3;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.697 -0400", hash_original_method = "3872533C5F4C6DF8E9B47456E87ABB09", hash_generated_method = "61C6C4E209B2EB1D194185007E303529")
        private  FieldPositionIterator() {
            
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.698 -0400", hash_original_method = "F9CA7CA9C759396A69CAFCECCE3A38CE", hash_generated_method = "2BAC2CAAA1101A036DFEBBBFA8746372")
        public boolean next() {
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } 
            pos += 3;
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1365009316 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1365009316;
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.698 -0400", hash_original_method = "28A52A04516ACAEA5CBE057E7005DC29", hash_generated_method = "5DF96E6E92B6CC3D8098CC728AFF2BD8")
        private void checkValid() {
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } 
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.698 -0400", hash_original_method = "F481D50CCC1AB38B4CA6D00583ECCD74", hash_generated_method = "3037F836EDC519E83BBA2E7E588DF637")
        public int fieldId() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1458965784 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1458965784;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.699 -0400", hash_original_method = "B152D64258DA85AB1020B78F45482139", hash_generated_method = "8EC959FA641F99F389801555323CF268")
        public Format.Field field() {
            Format.Field varB4EAC82CA7396A68D541C85D26508E83_1893524538 = null; 
            checkValid();
            varB4EAC82CA7396A68D541C85D26508E83_1893524538 = fields[data[pos]];
            varB4EAC82CA7396A68D541C85D26508E83_1893524538.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1893524538;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.699 -0400", hash_original_method = "573D89586F74B4B2EDB6530AAE1DEC79", hash_generated_method = "4E71B2596731360D53946E3B8C26A4D9")
        public int start() {
            checkValid();
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2014822582 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2014822582;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.699 -0400", hash_original_method = "431D149304BC1F14DB944F0790F3E8B8", hash_generated_method = "88B5285EE6637D10841E8CA11C9CE325")
        public int limit() {
            checkValid();
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_152114980 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_152114980;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.700 -0400", hash_original_method = "E1A3B20A4A62E5F6661DF7F73A635F7C", hash_generated_method = "2FA05A6182FB4AA13AC353371D99B73A")
        private void setData(int[] data) {
            this.data = data;
            this.pos = -3;
            
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.700 -0400", hash_original_field = "27D7A0AA47D8E9AD8DC4BF2D88186493", hash_generated_field = "C4A857D89644DD678C209850C71C6253")

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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.700 -0400", hash_original_field = "024283A17B4F858679487AA41D06F137", hash_generated_field = "38F9165B0D1718351C70E64071CF49B4")

    private static final int UNUM_DECIMAL_SEPARATOR_SYMBOL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.700 -0400", hash_original_field = "569D4CB22C567CCFA8FA28AA98AA481B", hash_generated_field = "A28375963190DB6399778744725103E6")

    private static final int UNUM_GROUPING_SEPARATOR_SYMBOL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.700 -0400", hash_original_field = "DC39C912818608D5EE416599EB02C2F1", hash_generated_field = "0ECCE7421BEB7BB4F15F8631211E592E")

    private static final int UNUM_PATTERN_SEPARATOR_SYMBOL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.700 -0400", hash_original_field = "2E48B57484F2D80820EE30D01A85762B", hash_generated_field = "83D35D18C1BB99CFDB91DD1A86FC9678")

    private static final int UNUM_PERCENT_SYMBOL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.700 -0400", hash_original_field = "B80F5415D213C71760D64C3F8655E103", hash_generated_field = "A137593AB67428AD25B40E8D7662626C")

    private static final int UNUM_ZERO_DIGIT_SYMBOL = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.700 -0400", hash_original_field = "849923D76D74AC9D2575F3FEB9D17105", hash_generated_field = "0BF7C44A4D4E7A6FCFBDC966AC9A3476")

    private static final int UNUM_DIGIT_SYMBOL = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.700 -0400", hash_original_field = "982740976D9454DA142BBB76FCB86E65", hash_generated_field = "17518293119C4123ADB20C78B6AFF1D9")

    private static final int UNUM_MINUS_SIGN_SYMBOL = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.700 -0400", hash_original_field = "D4A0AD0CDFD3BC5A192430B57716B330", hash_generated_field = "1DCA6AC28B3EA63C4A4D4065F3445F3E")

    private static final int UNUM_PLUS_SIGN_SYMBOL = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.700 -0400", hash_original_field = "6520A81D71399A74E18494DE8A2D2716", hash_generated_field = "13D25F549CCD80A7958357D90F76BF36")

    private static final int UNUM_CURRENCY_SYMBOL = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.700 -0400", hash_original_field = "4EBC0BEF182CD31FB42F775EAD2D9A1C", hash_generated_field = "871E41AB05FA295AFDB080EA0ED3BFC5")

    private static final int UNUM_INTL_CURRENCY_SYMBOL = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.700 -0400", hash_original_field = "82EF848B759F95741D1982E35EBEEA19", hash_generated_field = "EEE69206D44FBEDEC2F848E246637D7D")

    private static final int UNUM_MONETARY_SEPARATOR_SYMBOL = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.700 -0400", hash_original_field = "EBFE24817B35301033E4034E3B5AFB93", hash_generated_field = "5DD2C0F9414476738084073736C6DD24")

    private static final int UNUM_EXPONENTIAL_SYMBOL = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.700 -0400", hash_original_field = "555A332569EBE4B181F44ADCCF0603D5", hash_generated_field = "E328F5A776A1D9EA915373443B4D1D36")

    private static final int UNUM_PERMILL_SYMBOL = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.700 -0400", hash_original_field = "6F0C8024A801549CF944CDBEFDB9DDB4", hash_generated_field = "FDD5FB07C1A11F2186831D8D8D4B07C5")

    private static final int UNUM_PAD_ESCAPE_SYMBOL = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.700 -0400", hash_original_field = "378FA79958A996A5E9BC4BFADD42352C", hash_generated_field = "00A8062220A299E144D758B6640F827D")

    private static final int UNUM_INFINITY_SYMBOL = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.700 -0400", hash_original_field = "8B4BB88522F81B591874E385E981297F", hash_generated_field = "FF98C79010DA951498FB4C5A5099EC0F")

    private static final int UNUM_NAN_SYMBOL = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.700 -0400", hash_original_field = "F86892C3522DEA90F517C4C5467386D5", hash_generated_field = "C24949E7E71025158E3BECC52FE6AEE8")

    private static final int UNUM_SIGNIFICANT_DIGIT_SYMBOL = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.700 -0400", hash_original_field = "53E1C966A8C817CC8509732458E431F8", hash_generated_field = "217B639C06D518F013EA3AFBC1159BEA")

    private static final int UNUM_MONETARY_GROUPING_SEPARATOR_SYMBOL = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.700 -0400", hash_original_field = "6944D02F190693EAEBF8A29CD17CA79C", hash_generated_field = "445837AD1924D5714BE388A67163A553")

    private static final int UNUM_FORMAT_SYMBOL_COUNT = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.700 -0400", hash_original_field = "8971AE23D0ACB2019E7F237C1A5D9057", hash_generated_field = "8BADA870B3144CAE14BC1B1303AFD2E0")

    private static final int UNUM_PARSE_INT_ONLY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.700 -0400", hash_original_field = "46581E7ADB623C966C46F86CBCA1ACA7", hash_generated_field = "7D1C329BEE2B035F9F233564C570028F")

    private static final int UNUM_GROUPING_USED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.700 -0400", hash_original_field = "D0A1191C6B8058293B62F4EB5CB139F7", hash_generated_field = "7A36CC1B192B3B1AADAF3A7C042D87DC")

    private static final int UNUM_DECIMAL_ALWAYS_SHOWN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.700 -0400", hash_original_field = "6A692975BF789004FF9BCD7ED2595754", hash_generated_field = "619A906F0DBD204A3D5EF39E61783952")

    private static final int UNUM_MAX_INTEGER_DIGITS = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.700 -0400", hash_original_field = "BFCDA61A6544D8200FB16C8ECAB194D9", hash_generated_field = "AD2EFDD3044D52B7569692F528421BFA")

    private static final int UNUM_MIN_INTEGER_DIGITS = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.700 -0400", hash_original_field = "DA0B7AFB468402B4FAB627D7A9AFFACE", hash_generated_field = "D3D4DF73C2432699E2CED910F4AC2552")

    private static final int UNUM_INTEGER_DIGITS = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.700 -0400", hash_original_field = "5750A34FC87461228B5037583C2CE979", hash_generated_field = "F0171186645CD6B003F45EE6BD32357E")

    private static final int UNUM_MAX_FRACTION_DIGITS = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.700 -0400", hash_original_field = "BE2E1373EE438BBC72E5EEA62F6EEFCE", hash_generated_field = "C0FAFB0D9C2B9DDEC85E66C9595CE14D")

    private static final int UNUM_MIN_FRACTION_DIGITS = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.701 -0400", hash_original_field = "C0D0E977100ACCBC9B8F77297A991F0A", hash_generated_field = "77B731D6D431A67B9FBD265D21C6B4E3")

    private static final int UNUM_FRACTION_DIGITS = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.701 -0400", hash_original_field = "4FFB3432E077BDF4076A364D312B6322", hash_generated_field = "D7D1DB6D490350ED0F56C66BA87D59DB")

    private static final int UNUM_MULTIPLIER = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.701 -0400", hash_original_field = "68EDF621E4AEA7D984951F9A8C68B508", hash_generated_field = "05CB2CE6529FD0E1150F6A0CE43ECDDA")

    private static final int UNUM_GROUPING_SIZE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.701 -0400", hash_original_field = "3180DB5CC7990CFC070810D65823E15E", hash_generated_field = "AE8E7BB146CFC987266EF6FCBEEA9CFA")

    private static final int UNUM_ROUNDING_MODE = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.701 -0400", hash_original_field = "EB76EFADD49B90471770F624C07D79A9", hash_generated_field = "D211C7D2DA9A6A02C05730209957713D")

    private static final int UNUM_ROUNDING_INCREMENT = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.701 -0400", hash_original_field = "2E1629A5A9F1DEAF1A18A9539618D4D5", hash_generated_field = "1BEE2F7A86DF9CC0CF422419F6C7E6AC")

    private static final int UNUM_FORMAT_WIDTH = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.701 -0400", hash_original_field = "B760C9A8428FD459E7B9827858CFD779", hash_generated_field = "1137CDEF8C77585315595AE0160B7096")

    private static final int UNUM_PADDING_POSITION = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.701 -0400", hash_original_field = "D7D95CD560376F364890DB0FD74EB85B", hash_generated_field = "06F7E6232D5F36D4B36C8F433D1A4815")

    private static final int UNUM_SECONDARY_GROUPING_SIZE = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.701 -0400", hash_original_field = "5CA0ED7747BDD5FD9CA45EC2E6F0E8B5", hash_generated_field = "B6C735B849850BC33558BDF5305AFBDF")

    private static final int UNUM_SIGNIFICANT_DIGITS_USED = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.701 -0400", hash_original_field = "CED3E3C034EC98CD8CA99E728B988C9E", hash_generated_field = "6A53E30035D626AEBE7319CC56976B5E")

    private static final int UNUM_MIN_SIGNIFICANT_DIGITS = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.701 -0400", hash_original_field = "3E30604D3F70C6D8BE917DAB3E65F7C2", hash_generated_field = "60312495E62249A683DE9D887813078C")

    private static final int UNUM_MAX_SIGNIFICANT_DIGITS = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.701 -0400", hash_original_field = "D64F4F2459B0190DFFBA9826AC72489F", hash_generated_field = "17FDB153D06831EFA445923876F0F9CD")

    private static final int UNUM_LENIENT_PARSE = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.701 -0400", hash_original_field = "E81D0E837BFCCE8B299F86B2B0379AA1", hash_generated_field = "CB0BDBA3DAAC06D26A2A81C71F65DE46")

    private static final int UNUM_POSITIVE_PREFIX = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.701 -0400", hash_original_field = "ACAF14DFBF527393BF01C453C005773D", hash_generated_field = "BA1D392F17BF7442D6C4A8ED2218F953")

    private static final int UNUM_POSITIVE_SUFFIX = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.701 -0400", hash_original_field = "3B4AAFD666329CD2E14C939EB5493111", hash_generated_field = "3B7B2C3FEE6B7373D124C61F621AAECB")

    private static final int UNUM_NEGATIVE_PREFIX = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.701 -0400", hash_original_field = "B914446D1D897950976F6F9F6EEBD0B7", hash_generated_field = "7ADB5843D6F5347E296883E0AD4E2AC6")

    private static final int UNUM_NEGATIVE_SUFFIX = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.701 -0400", hash_original_field = "4E39F122ADFEC6840ACE999C184C9EE2", hash_generated_field = "EA8C72D1176DA844AB8FAB8C5B840969")

    private static final int UNUM_PADDING_CHARACTER = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.701 -0400", hash_original_field = "36CCE6C77A18DA6E36931EF0CD49A9BB", hash_generated_field = "F54C128E1E1EA1DBED16FA7AC15596DC")

    private static final int UNUM_CURRENCY_CODE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.701 -0400", hash_original_field = "FBB3BE349F8C0AB42CE7BA4DD07A0976", hash_generated_field = "C71921E41D4DB8B96035181BECB3F4C9")

    private static final int UNUM_DEFAULT_RULESET = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.701 -0400", hash_original_field = "A63C4BE0875A4094DC60472905775981", hash_generated_field = "0401D7F0EFF53BBDD616982052AEAE8F")

    private static final int UNUM_PUBLIC_RULESETS = 7;
}

