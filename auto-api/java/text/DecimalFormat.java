package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Locale;
import libcore.icu.LocaleData;
import libcore.icu.NativeDecimalFormat;

public class DecimalFormat extends NumberFormat {
    private static final long serialVersionUID = 864413376551465018L;
    private transient DecimalFormatSymbols symbols;
    private transient NativeDecimalFormat dform;
    private final Object finalizerGuardian = new Object() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.655 -0400", hash_original_method = "1A366D9719473F2399B539B354BB787B", hash_generated_method = "92D79D6BB6E65B2840F2D778A700BE89")
        @DSModeled(DSC.SAFE)
        @Override
        protected void finalize() throws Throwable {
            try 
            {
                dform.close();
            } //End block
            finally 
            {
                super.finalize();
            } //End block
            // ---------- Original Method ----------
            //try {
                //dform.close();
            //} finally {
                //super.finalize();
            //}
        }

        
}; //Transformed anonymous class
    private transient RoundingMode roundingMode = RoundingMode.HALF_EVEN;
    private static final Double NEGATIVE_ZERO_DOUBLE = new Double(-0.0);
    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("positivePrefix", String.class),
        new ObjectStreamField("positiveSuffix", String.class),
        new ObjectStreamField("negativePrefix", String.class),
        new ObjectStreamField("negativeSuffix", String.class),
        new ObjectStreamField("posPrefixPattern", String.class),
        new ObjectStreamField("posSuffixPattern", String.class),
        new ObjectStreamField("negPrefixPattern", String.class),
        new ObjectStreamField("negSuffixPattern", String.class),
        new ObjectStreamField("multiplier", int.class),
        new ObjectStreamField("groupingSize", byte.class),
        new ObjectStreamField("groupingUsed", boolean.class),
        new ObjectStreamField("decimalSeparatorAlwaysShown", boolean.class),
        new ObjectStreamField("parseBigDecimal", boolean.class),
        new ObjectStreamField("roundingMode", RoundingMode.class),
        new ObjectStreamField("symbols", DecimalFormatSymbols.class),
        new ObjectStreamField("useExponentialNotation", boolean.class),
        new ObjectStreamField("minExponentDigits", byte.class),
        new ObjectStreamField("maximumIntegerDigits", int.class),
        new ObjectStreamField("minimumIntegerDigits", int.class),
        new ObjectStreamField("maximumFractionDigits", int.class),
        new ObjectStreamField("minimumFractionDigits", int.class),
        new ObjectStreamField("serialVersionOnStream", int.class),
    };
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.656 -0400", hash_original_method = "DE88C1883A924350E112FA17163006E9", hash_generated_method = "7BECE1B1EBDD3C0C8290B709C07500F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DecimalFormat() {
        Locale locale;
        locale = Locale.getDefault();
        this.symbols = new DecimalFormatSymbols(locale);
        initNative(LocaleData.get(locale).numberPattern);
        // ---------- Original Method ----------
        //Locale locale = Locale.getDefault();
        //this.symbols = new DecimalFormatSymbols(locale);
        //initNative(LocaleData.get(locale).numberPattern);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.657 -0400", hash_original_method = "35AB5293961F9B593ADD183E8B6B3242", hash_generated_method = "A32AB087E015187E2A760BB334BA31FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DecimalFormat(String pattern) {
        this(pattern, Locale.getDefault());
        dsTaint.addTaint(pattern);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.658 -0400", hash_original_method = "17CE9F29195C1874CE3535C0883BB7B4", hash_generated_method = "0987673BDFB4B5EC049F0BBFE32B9A99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DecimalFormat(String pattern, DecimalFormatSymbols value) {
        dsTaint.addTaint(pattern);
        dsTaint.addTaint(value.dsTaint);
        this.symbols = (DecimalFormatSymbols) value.clone();
        initNative(pattern);
        // ---------- Original Method ----------
        //this.symbols = (DecimalFormatSymbols) value.clone();
        //initNative(pattern);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.658 -0400", hash_original_method = "1EB8095DC5F926848B20CBA55F6BDD83", hash_generated_method = "8DF42F2F2B59D56E9E47BDA40181345C")
    @DSModeled(DSC.SAFE)
     DecimalFormat(String pattern, Locale locale) {
        dsTaint.addTaint(pattern);
        dsTaint.addTaint(locale.dsTaint);
        this.symbols = new DecimalFormatSymbols(locale);
        initNative(pattern);
        // ---------- Original Method ----------
        //this.symbols = new DecimalFormatSymbols(locale);
        //initNative(pattern);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.659 -0400", hash_original_method = "701B7114CA5711EBC62D39124CAE5412", hash_generated_method = "D9A21075FEAE4074FEE0E4FDC81FA410")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initNative(String pattern) {
        dsTaint.addTaint(pattern);
        try 
        {
            this.dform = new NativeDecimalFormat(pattern, symbols);
        } //End block
        catch (IllegalArgumentException ex)
        {
            throw new IllegalArgumentException(pattern);
        } //End block
        super.setMaximumFractionDigits(dform.getMaximumFractionDigits());
        super.setMaximumIntegerDigits(dform.getMaximumIntegerDigits());
        super.setMinimumFractionDigits(dform.getMinimumFractionDigits());
        super.setMinimumIntegerDigits(dform.getMinimumIntegerDigits());
        // ---------- Original Method ----------
        //try {
            //this.dform = new NativeDecimalFormat(pattern, symbols);
        //} catch (IllegalArgumentException ex) {
            //throw new IllegalArgumentException(pattern);
        //}
        //super.setMaximumFractionDigits(dform.getMaximumFractionDigits());
        //super.setMaximumIntegerDigits(dform.getMaximumIntegerDigits());
        //super.setMinimumFractionDigits(dform.getMinimumFractionDigits());
        //super.setMinimumIntegerDigits(dform.getMinimumIntegerDigits());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.660 -0400", hash_original_method = "65449F4F2C00BF62B7AB916EB2126B60", hash_generated_method = "1AB4256B8A48F925759E1E00E80EB5A0")
    @DSModeled(DSC.SAFE)
    public void applyLocalizedPattern(String pattern) {
        dsTaint.addTaint(pattern);
        dform.applyLocalizedPattern(pattern);
        // ---------- Original Method ----------
        //dform.applyLocalizedPattern(pattern);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.661 -0400", hash_original_method = "09E7693F39B1CA310938A9A4756C1A20", hash_generated_method = "A30F1B039358C3F5238AC1DD03BBD988")
    @DSModeled(DSC.SAFE)
    public void applyPattern(String pattern) {
        dsTaint.addTaint(pattern);
        dform.applyPattern(pattern);
        // ---------- Original Method ----------
        //dform.applyPattern(pattern);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.662 -0400", hash_original_method = "9257BEF78EF77BD305740BB055166BA8", hash_generated_method = "F69750E6B88994C09EFC130E28540584")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        DecimalFormat clone;
        clone = (DecimalFormat) super.clone();
        clone.dform = (NativeDecimalFormat) dform.clone();
        clone.symbols = (DecimalFormatSymbols) symbols.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //DecimalFormat clone = (DecimalFormat) super.clone();
        //clone.dform = (NativeDecimalFormat) dform.clone();
        //clone.symbols = (DecimalFormatSymbols) symbols.clone();
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.663 -0400", hash_original_method = "6765E822C563E620DE26A0B6A028E00A", hash_generated_method = "0ECFD2032806E80D30BBA4E67568419F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        DecimalFormat other;
        other = (DecimalFormat) object;
        boolean var978C9F6193C72EF6E0807F28D1781CB8_231991687 = ((this.dform == null ? other.dform == null : this.dform.equals(other.dform)) &&
                getDecimalFormatSymbols().equals(other.getDecimalFormatSymbols())); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (this == object) {
            //return true;
        //}
        //if (!(object instanceof DecimalFormat)) {
            //return false;
        //}
        //DecimalFormat other = (DecimalFormat) object;
        //return (this.dform == null ? other.dform == null : this.dform.equals(other.dform)) &&
                //getDecimalFormatSymbols().equals(other.getDecimalFormatSymbols());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.664 -0400", hash_original_method = "3B59068DE45E1D685899870F874FDB91", hash_generated_method = "F27FCB79BE50096F7451614EDB69940B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        dsTaint.addTaint(object.dsTaint);
        {
            throw new NullPointerException();
        } //End block
        AttributedCharacterIterator var409EFD5E94FC498742FA43A0FE748860_801939405 = (dform.formatToCharacterIterator(object));
        return (AttributedCharacterIterator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (object == null) {
            //throw new NullPointerException();
        //}
        //return dform.formatToCharacterIterator(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.665 -0400", hash_original_method = "FBA2DE4CAF4AAEBE0D141C6C51AFFE4A", hash_generated_method = "FFFEBF948C80A933015BC43D989A77C6")
    @DSModeled(DSC.SAFE)
    private void checkBufferAndFieldPosition(StringBuffer buffer, FieldPosition position) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(position.dsTaint);
        {
            throw new NullPointerException("buffer == null");
        } //End block
        {
            throw new NullPointerException("position == null");
        } //End block
        // ---------- Original Method ----------
        //if (buffer == null) {
            //throw new NullPointerException("buffer == null");
        //}
        //if (position == null) {
            //throw new NullPointerException("position == null");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.667 -0400", hash_original_method = "1E84E5D2AEBA1220C1C2BABB55EE58F4", hash_generated_method = "93C57501211C9CF5BF8F3B0568A671B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public StringBuffer format(double value, StringBuffer buffer, FieldPosition position) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(position.dsTaint);
        dsTaint.addTaint(value);
        checkBufferAndFieldPosition(buffer, position);
        {
            try 
            {
                setRoundingMode(RoundingMode.UP);
                String upResult;
                upResult = format(value, new StringBuffer(), new FieldPosition(0)).toString();
                setRoundingMode(RoundingMode.DOWN);
                String downResult;
                downResult = format(value, new StringBuffer(), new FieldPosition(0)).toString();
                {
                    boolean var2F746E5BABC839274FF6C5CAE9A27612_1688508989 = (!upResult.equals(downResult));
                    {
                        throw new ArithmeticException("rounding mode UNNECESSARY but rounding required");
                    } //End block
                } //End collapsed parenthetic
            } //End block
            finally 
            {
                setRoundingMode(RoundingMode.UNNECESSARY);
            } //End block
        } //End block
        buffer.append(dform.formatDouble(value, position));
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkBufferAndFieldPosition(buffer, position);
        //if (roundingMode == RoundingMode.UNNECESSARY) {
            //try {
                //setRoundingMode(RoundingMode.UP);
                //String upResult = format(value, new StringBuffer(), new FieldPosition(0)).toString();
                //setRoundingMode(RoundingMode.DOWN);
                //String downResult = format(value, new StringBuffer(), new FieldPosition(0)).toString();
                //if (!upResult.equals(downResult)) {
                    //throw new ArithmeticException("rounding mode UNNECESSARY but rounding required");
                //}
            //} finally {
                //setRoundingMode(RoundingMode.UNNECESSARY);
            //}
        //}
        //buffer.append(dform.formatDouble(value, position));
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.668 -0400", hash_original_method = "B4F0904648F2A25561C63568681C231B", hash_generated_method = "38EEE88695281F720605CF6493F7F9D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public StringBuffer format(long value, StringBuffer buffer, FieldPosition position) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(position.dsTaint);
        dsTaint.addTaint(value);
        checkBufferAndFieldPosition(buffer, position);
        buffer.append(dform.formatLong(value, position));
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkBufferAndFieldPosition(buffer, position);
        //buffer.append(dform.formatLong(value, position));
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.670 -0400", hash_original_method = "9F0187C663B029586FEAEE5997EF0E8A", hash_generated_method = "B69E1321539510BF429669AAF88213C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final StringBuffer format(Object number, StringBuffer buffer, FieldPosition position) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(position.dsTaint);
        dsTaint.addTaint(number.dsTaint);
        checkBufferAndFieldPosition(buffer, position);
        {
            BigInteger bigInteger;
            bigInteger = (BigInteger) number;
            char[] chars;
            boolean var13ED5CFC28017CACC4A5C2EC4BA37F58_1594776126 = ((bigInteger.bitLength() < 64));
            chars = dform.formatLong(bigInteger.longValue(), position);
            chars = dform.formatBigInteger(bigInteger, position);
            buffer.append(chars);
        } //End block
        {
            buffer.append(dform.formatBigDecimal((BigDecimal) number, position));
        } //End block
        StringBuffer var3F8C11D6A35340E5097C47B368F467BF_1280352777 = (super.format(number, buffer, position));
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkBufferAndFieldPosition(buffer, position);
        //if (number instanceof BigInteger) {
            //BigInteger bigInteger = (BigInteger) number;
            //char[] chars = (bigInteger.bitLength() < 64)
                    //? dform.formatLong(bigInteger.longValue(), position)
                    //: dform.formatBigInteger(bigInteger, position);
            //buffer.append(chars);
            //return buffer;
        //} else if (number instanceof BigDecimal) {
            //buffer.append(dform.formatBigDecimal((BigDecimal) number, position));
            //return buffer;
        //}
        //return super.format(number, buffer, position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.671 -0400", hash_original_method = "8DCCB340D185077EABFD1E6BFE3DB36F", hash_generated_method = "8708D24E105E43ABC4FECDC2D2D6F0DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DecimalFormatSymbols getDecimalFormatSymbols() {
        DecimalFormatSymbols var4B136C33B65A40F217BF5F73D744E93E_946208858 = ((DecimalFormatSymbols) symbols.clone());
        return (DecimalFormatSymbols)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (DecimalFormatSymbols) symbols.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.672 -0400", hash_original_method = "58EEC1F79BF01CD73E1939B30FC9554A", hash_generated_method = "916300CF3CDFC7B8ABC0D58AB55FA13B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Currency getCurrency() {
        Currency varA56D07719A83CD2A470DDEBA162AD8B2_1204277210 = (symbols.getCurrency());
        return (Currency)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return symbols.getCurrency();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.673 -0400", hash_original_method = "3224B3D9278B5F6729F4AC0FDDE7BC48", hash_generated_method = "DA1CAAEEBBA8FD45B06FB520EEE04519")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getGroupingSize() {
        int var84E7F84E9DB89AD1D760100A3219CD70_1084744954 = (dform.getGroupingSize());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return dform.getGroupingSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.674 -0400", hash_original_method = "20055FC91A272014560FDC07D160C285", hash_generated_method = "E45457CE4A54B63D87A4712ED26EB93D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMultiplier() {
        int varD5942B62FC4C9BC329C63BE9D496D09D_1007291930 = (dform.getMultiplier());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return dform.getMultiplier();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.674 -0400", hash_original_method = "1F7C0591D1187101B5F5E6FCEBFE4BA7", hash_generated_method = "AEE5AFA1199E74E0442240C4088DB30C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getNegativePrefix() {
        String varA2F3F67134C9440EBE8C0BF447A241D5_262009195 = (dform.getNegativePrefix());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return dform.getNegativePrefix();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.675 -0400", hash_original_method = "61D6D48706CC87AEEF19B015AC798361", hash_generated_method = "47856B0F6117E915A2735E71E59DB684")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getNegativeSuffix() {
        String var6199222092B029E86CAD221DD06054E0_1892550322 = (dform.getNegativeSuffix());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return dform.getNegativeSuffix();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.676 -0400", hash_original_method = "55B5FDB79399831D6973F7F1358A3E99", hash_generated_method = "761D765A4965C7BF0B83DCB1AB8FC9A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPositivePrefix() {
        String var2804E935B409A2320BC58105D8F7A0FF_648935175 = (dform.getPositivePrefix());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return dform.getPositivePrefix();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.677 -0400", hash_original_method = "2B5CAE95AEB5D456BD3378DDAC8D9097", hash_generated_method = "0A16A9ACF44DF67D980C190C63D316C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPositiveSuffix() {
        String varBBAC96CB33E8B5878C136C9BFDF208D4_925486175 = (dform.getPositiveSuffix());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return dform.getPositiveSuffix();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.678 -0400", hash_original_method = "AC91BBA5B39870FB8DAE3ED8BCCB1730", hash_generated_method = "F3AC8A56A79D664F1D94182E6DCA84AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varAB176B7235F3D88BF17FD6DC4AB80E7B_147783405 = (dform.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return dform.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.679 -0400", hash_original_method = "43884003345D483D0CB1C79601B3CBE6", hash_generated_method = "220A32899353BBA28D2F89E6D27FC36D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDecimalSeparatorAlwaysShown() {
        boolean var8C31534627EF9A9C01F3C98A04522156_624421194 = (dform.isDecimalSeparatorAlwaysShown());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return dform.isDecimalSeparatorAlwaysShown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.680 -0400", hash_original_method = "0A7D24FF4B0BD9084E07584B0A08B543", hash_generated_method = "581A3DA208A0294FBFF7F0F1E4CB716C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isParseBigDecimal() {
        boolean var0EB097AD7D30E488D1246B51922A3652_1107807249 = (dform.isParseBigDecimal());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return dform.isParseBigDecimal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.680 -0400", hash_original_method = "7481DA5537EE3F9956B6D5D3C7A225D0", hash_generated_method = "725D1AE4D2904E37523AC34FDC3A3F3B")
    @DSModeled(DSC.SAFE)
    @Override
    public void setParseIntegerOnly(boolean value) {
        dsTaint.addTaint(value);
        dform.setParseIntegerOnly(value);
        // ---------- Original Method ----------
        //dform.setParseIntegerOnly(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.681 -0400", hash_original_method = "4A357353F9630D5720A9D39DD6F8D4E6", hash_generated_method = "0142F90E8BA49C043075907D2F895F68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isParseIntegerOnly() {
        boolean var1E9CEECAA246756F13D9D10CB6BC9E3B_1964141707 = (dform.isParseIntegerOnly());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return dform.isParseIntegerOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.684 -0400", hash_original_method = "5624B977416508FD6FAAB26F049D0D1B", hash_generated_method = "4EAFC598727032A84DD3AC3ADB94042B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Number parse(String string, ParsePosition position) {
        dsTaint.addTaint(position.dsTaint);
        dsTaint.addTaint(string);
        Number number;
        number = dform.parse(string, position);
        {
            boolean varFCE5D5AECE0E50270D8E061A3C10C2CD_784175671 = (this.isParseBigDecimal());
            {
                {
                    Number varD822AEA122E9530D61A9B4D9202A8B26_1580043376 = (new BigDecimal(number.longValue()));
                } //End block
                {
                    boolean var6E0B5C3FBC13410F972BDAC62E60405B_1690990728 = ((number instanceof Double) && !((Double) number).isInfinite()
                    && !((Double) number).isNaN());
                    {
                        Number var1419EC050D769FE6289494ACB054CA43_740320398 = (new BigDecimal(number.toString()));
                    } //End block
                } //End collapsed parenthetic
                {
                    Number var1E54EB477127078CF9FB8D107F6BF792_199999690 = (new BigDecimal(number.toString()));
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            Number var2EC366FC14D73F0187B6DBD5B033476D_579874920 = (new Double(number.doubleValue()));
        } //End block
        {
            boolean var07027D739703D2CF0BA233E0500891D7_796109032 = (this.isParseIntegerOnly() && number.equals(NEGATIVE_ZERO_DOUBLE));
            {
                Number var3C20CB4D83DC44C836778334148825D3_700604274 = (Long.valueOf(0));
            } //End block
        } //End collapsed parenthetic
        return (Number)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.685 -0400", hash_original_method = "86D86A0FD4BCEEB43D34AB98DA52821C", hash_generated_method = "4E1262089B8B000F142AAAC77D62B280")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDecimalFormatSymbols(DecimalFormatSymbols value) {
        dsTaint.addTaint(value.dsTaint);
        {
            this.symbols = (DecimalFormatSymbols) value.clone();
            dform.setDecimalFormatSymbols(this.symbols);
        } //End block
        // ---------- Original Method ----------
        //if (value != null) {
            //this.symbols = (DecimalFormatSymbols) value.clone();
            //dform.setDecimalFormatSymbols(this.symbols);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.686 -0400", hash_original_method = "4395CDF7142532C86BE10F65050BB217", hash_generated_method = "8F86FC8502D2AC37A75057287EE3DE61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setCurrency(Currency currency) {
        dsTaint.addTaint(currency.dsTaint);
        dform.setCurrency(Currency.getInstance(currency.getCurrencyCode()));
        symbols.setCurrency(currency);
        // ---------- Original Method ----------
        //dform.setCurrency(Currency.getInstance(currency.getCurrencyCode()));
        //symbols.setCurrency(currency);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.687 -0400", hash_original_method = "3B253ED7615AA8E014EF753B3801D05C", hash_generated_method = "1AA379D810D67D663B56D6FFC1B53412")
    @DSModeled(DSC.SAFE)
    public void setDecimalSeparatorAlwaysShown(boolean value) {
        dsTaint.addTaint(value);
        dform.setDecimalSeparatorAlwaysShown(value);
        // ---------- Original Method ----------
        //dform.setDecimalSeparatorAlwaysShown(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.687 -0400", hash_original_method = "C7D074F8D378A670A8F54B2C99810E6C", hash_generated_method = "6686ECFF06417137F8649D4A63B0B197")
    @DSModeled(DSC.SAFE)
    public void setGroupingSize(int value) {
        dsTaint.addTaint(value);
        dform.setGroupingSize(value);
        // ---------- Original Method ----------
        //dform.setGroupingSize(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.688 -0400", hash_original_method = "ABE655961F79B3C1FE3443634AA21C37", hash_generated_method = "B238994A9D650C37C190CDDD061C1EA4")
    @DSModeled(DSC.SAFE)
    @Override
    public void setGroupingUsed(boolean value) {
        dsTaint.addTaint(value);
        dform.setGroupingUsed(value);
        // ---------- Original Method ----------
        //dform.setGroupingUsed(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.690 -0400", hash_original_method = "47F90CF51661FE278576148D8412D8DA", hash_generated_method = "00ADE85F4FB65C71036D9A891D82039D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isGroupingUsed() {
        boolean varAA5A5B89A3DACBDF58942A2C9533A8B6_636491540 = (dform.isGroupingUsed());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return dform.isGroupingUsed();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.691 -0400", hash_original_method = "D0C418C01DBD33DD29A18941B68BCBF7", hash_generated_method = "989B2DBBA3D2B2D2E7CEE2313790F974")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setMaximumFractionDigits(int value) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(value);
        super.setMaximumFractionDigits(value);
        dform.setMaximumFractionDigits(getMaximumFractionDigits());
        setRoundingMode(roundingMode);
        // ---------- Original Method ----------
        //super.setMaximumFractionDigits(value);
        //dform.setMaximumFractionDigits(getMaximumFractionDigits());
        //setRoundingMode(roundingMode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.692 -0400", hash_original_method = "D5AFAB41905B13F7AD20D2FADDE73669", hash_generated_method = "924BE8767DFE2AB378EA5BB0D73D9E23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setMaximumIntegerDigits(int value) {
        dsTaint.addTaint(value);
        super.setMaximumIntegerDigits(value);
        dform.setMaximumIntegerDigits(getMaximumIntegerDigits());
        // ---------- Original Method ----------
        //super.setMaximumIntegerDigits(value);
        //dform.setMaximumIntegerDigits(getMaximumIntegerDigits());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.694 -0400", hash_original_method = "9EB52B7EEE1D2B50BAA9500CCA3AFB4E", hash_generated_method = "5B04B34185FA2C179F0F1FED5EBAF32D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setMinimumFractionDigits(int value) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(value);
        super.setMinimumFractionDigits(value);
        dform.setMinimumFractionDigits(getMinimumFractionDigits());
        // ---------- Original Method ----------
        //super.setMinimumFractionDigits(value);
        //dform.setMinimumFractionDigits(getMinimumFractionDigits());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.695 -0400", hash_original_method = "6EFC03984672E7D89A36C9F22F2AAB3B", hash_generated_method = "BA6E1B75180DB83A97EED835157C5780")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setMinimumIntegerDigits(int value) {
        dsTaint.addTaint(value);
        super.setMinimumIntegerDigits(value);
        dform.setMinimumIntegerDigits(getMinimumIntegerDigits());
        // ---------- Original Method ----------
        //super.setMinimumIntegerDigits(value);
        //dform.setMinimumIntegerDigits(getMinimumIntegerDigits());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.696 -0400", hash_original_method = "2E4C739E2F1CFFD7C6A061AD5BB9ADF4", hash_generated_method = "5C8395EA5757D4639EB9F701E6FBD069")
    @DSModeled(DSC.SAFE)
    public void setMultiplier(int value) {
        dsTaint.addTaint(value);
        dform.setMultiplier(value);
        // ---------- Original Method ----------
        //dform.setMultiplier(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.697 -0400", hash_original_method = "2C739DF56DF29E81D815FC52FA901BFF", hash_generated_method = "F3EC0ACE42BD3C29AA889DF7FD4E00AB")
    @DSModeled(DSC.SAFE)
    public void setNegativePrefix(String value) {
        dsTaint.addTaint(value);
        dform.setNegativePrefix(value);
        // ---------- Original Method ----------
        //dform.setNegativePrefix(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.701 -0400", hash_original_method = "A51B4E91EE1B92D26334E28FF3A003CC", hash_generated_method = "2AF887CB5CFB71C85BE88EA50CFC5F45")
    @DSModeled(DSC.SAFE)
    public void setNegativeSuffix(String value) {
        dsTaint.addTaint(value);
        dform.setNegativeSuffix(value);
        // ---------- Original Method ----------
        //dform.setNegativeSuffix(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.702 -0400", hash_original_method = "7DA87D841FEB1EB829AC578209C7D87B", hash_generated_method = "4A44369C5E6DB0FC62A4509D74AD2CC4")
    @DSModeled(DSC.SAFE)
    public void setPositivePrefix(String value) {
        dsTaint.addTaint(value);
        dform.setPositivePrefix(value);
        // ---------- Original Method ----------
        //dform.setPositivePrefix(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.704 -0400", hash_original_method = "740675349A091E1D283FD9B9350AE3AA", hash_generated_method = "E0BAA8DA37DB233D79B2AB3A085946BC")
    @DSModeled(DSC.SAFE)
    public void setPositiveSuffix(String value) {
        dsTaint.addTaint(value);
        dform.setPositiveSuffix(value);
        // ---------- Original Method ----------
        //dform.setPositiveSuffix(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.705 -0400", hash_original_method = "DD680A2A91BAA011B854EB3CE1AE2AEF", hash_generated_method = "2C29AC459CA377F1B88F170ABBDED2B4")
    @DSModeled(DSC.SAFE)
    public void setParseBigDecimal(boolean newValue) {
        dsTaint.addTaint(newValue);
        dform.setParseBigDecimal(newValue);
        // ---------- Original Method ----------
        //dform.setParseBigDecimal(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.706 -0400", hash_original_method = "487E11DF64E483CD2A017195603FADD0", hash_generated_method = "B20BBA9B40538B193EB815B1282A92AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toLocalizedPattern() {
        String varAF95341A9D275F8E9D0A1AD6CDC1C691_1946804024 = (dform.toLocalizedPattern());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return dform.toLocalizedPattern();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.707 -0400", hash_original_method = "588A1CECAAE48251BC4F5156DD9C9A13", hash_generated_method = "CFCD1CBE7285D1E4CA3F3D729055F155")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toPattern() {
        String varBC0828661CABBB5228448B057BDEA5F3_179793294 = (dform.toPattern());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return dform.toPattern();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.717 -0400", hash_original_method = "5BC6394F5F5C73D6097502885E125B6B", hash_generated_method = "D05718547FACC443354AF014158AD18D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream stream) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(stream.dsTaint);
        ObjectOutputStream.PutField fields;
        fields = stream.putFields();
        fields.put("positivePrefix", dform.getPositivePrefix());
        fields.put("positiveSuffix", dform.getPositiveSuffix());
        fields.put("negativePrefix", dform.getNegativePrefix());
        fields.put("negativeSuffix", dform.getNegativeSuffix());
        fields.put("posPrefixPattern", (String) null);
        fields.put("posSuffixPattern", (String) null);
        fields.put("negPrefixPattern", (String) null);
        fields.put("negSuffixPattern", (String) null);
        fields.put("multiplier", dform.getMultiplier());
        fields.put("groupingSize", (byte) dform.getGroupingSize());
        fields.put("groupingUsed", dform.isGroupingUsed());
        fields.put("decimalSeparatorAlwaysShown", dform.isDecimalSeparatorAlwaysShown());
        fields.put("parseBigDecimal", dform.isParseBigDecimal());
        fields.put("roundingMode", roundingMode);
        fields.put("symbols", symbols);
        fields.put("useExponentialNotation", false);
        fields.put("minExponentDigits", (byte) 0);
        fields.put("maximumIntegerDigits", dform.getMaximumIntegerDigits());
        fields.put("minimumIntegerDigits", dform.getMinimumIntegerDigits());
        fields.put("maximumFractionDigits", dform.getMaximumFractionDigits());
        fields.put("minimumFractionDigits", dform.getMinimumFractionDigits());
        fields.put("serialVersionOnStream", 4);
        stream.writeFields();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.720 -0400", hash_original_method = "779EB6B3B1C2B5888DC5BF2D6BFB0D9C", hash_generated_method = "55EABB085821C4C795EDD3F12F8BFE94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(stream.dsTaint);
        ObjectInputStream.GetField fields;
        fields = stream.readFields();
        this.symbols = (DecimalFormatSymbols) fields.get("symbols", null);
        initNative("");
        dform.setPositivePrefix((String) fields.get("positivePrefix", ""));
        dform.setPositiveSuffix((String) fields.get("positiveSuffix", ""));
        dform.setNegativePrefix((String) fields.get("negativePrefix", "-"));
        dform.setNegativeSuffix((String) fields.get("negativeSuffix", ""));
        dform.setMultiplier(fields.get("multiplier", 1));
        dform.setGroupingSize(fields.get("groupingSize", (byte) 3));
        dform.setGroupingUsed(fields.get("groupingUsed", true));
        dform.setDecimalSeparatorAlwaysShown(fields.get("decimalSeparatorAlwaysShown", false));
        setRoundingMode((RoundingMode) fields.get("roundingMode", RoundingMode.HALF_EVEN));
        final int maximumIntegerDigits;
        maximumIntegerDigits = fields.get("maximumIntegerDigits", 309);
        final int minimumIntegerDigits;
        minimumIntegerDigits = fields.get("minimumIntegerDigits", 309);
        final int maximumFractionDigits;
        maximumFractionDigits = fields.get("maximumFractionDigits", 340);
        final int minimumFractionDigits;
        minimumFractionDigits = fields.get("minimumFractionDigits", 340);
        dform.setMaximumIntegerDigits(maximumIntegerDigits);
        super.setMaximumIntegerDigits(dform.getMaximumIntegerDigits());
        setMinimumIntegerDigits(minimumIntegerDigits);
        setMinimumFractionDigits(minimumFractionDigits);
        setMaximumFractionDigits(maximumFractionDigits);
        setParseBigDecimal(fields.get("parseBigDecimal", false));
        {
            boolean varC60DB38B4D51EB0E77F03A018CAB5ADE_1684838055 = (fields.get("serialVersionOnStream", 0) < 3);
            {
                setMaximumIntegerDigits(super.getMaximumIntegerDigits());
                setMinimumIntegerDigits(super.getMinimumIntegerDigits());
                setMaximumFractionDigits(super.getMaximumFractionDigits());
                setMinimumFractionDigits(super.getMinimumFractionDigits());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.722 -0400", hash_original_method = "665DD451D3753ACD20842BCA4E3EB32E", hash_generated_method = "B9BF4914BA9B54A70AB3ECD7C16403EA")
    @DSModeled(DSC.SAFE)
    public RoundingMode getRoundingMode() {
        return (RoundingMode)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return roundingMode;
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 15:32:19.658 -0400",hash_original_method="91D8E7B9A007769AA087DAF2CAD1ADF8",hash_generated_method="C0A8E9B63901EB85A0B4CB65B4C21530")
public void setRoundingMode(RoundingMode roundingMode) {
        dsTaint.addTaint(roundingMode.dsTaint);
        {
            throw new NullPointerException();
        } //End block
        {
            double roundingIncrement;
            roundingIncrement = 1.0 / Math.pow(10, Math.max(0, getMaximumFractionDigits()));
            dform.setRoundingMode(roundingMode, roundingIncrement);
        } //End block
        // ---------- Original Method ----------
        //if (roundingMode == null) {
            //throw new NullPointerException();
        //}
        //this.roundingMode = roundingMode;
        //if (roundingMode != RoundingMode.UNNECESSARY) { 
            //double roundingIncrement = 1.0 / Math.pow(10, Math.max(0, getMaximumFractionDigits()));
            //dform.setRoundingMode(roundingMode, roundingIncrement);
        //}
    }

    
}


