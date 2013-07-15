package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.299 -0400", hash_original_field = "5503577415FC1D8D6B3818212A1745BC", hash_generated_field = "52EBB9EA358F4A29D5EE09E100128428")

    private transient DecimalFormatSymbols symbols;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.299 -0400", hash_original_field = "43FB3BF64083BD4CAC80E1ED8CD075E4", hash_generated_field = "311D958CADB5DD8F5620B5C0287903DF")

    private transient NativeDecimalFormat dform;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.076 -0400", hash_original_field = "56B4B01527B4EB5F82F59EBDEC4AAB14", hash_generated_field = "13F8C455B70342D0BE0D104687A9B188")

    private final Object finalizerGuardian = new Object() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.076 -0400", hash_original_method = "1A366D9719473F2399B539B354BB787B", hash_generated_method = "ABC3A607675036C5172AEFC1575529C6")
        @Override
        protected void finalize() throws Throwable {
            try 
            {
                dform.close();
            } 
            finally 
            {
                super.finalize();
            } 
            
            
                
            
                
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.299 -0400", hash_original_field = "825BD9DBFA8BD0A02A9B3F51F9F3F717", hash_generated_field = "F8D485A47161940F89EC9F4328B1DE40")

    private transient RoundingMode roundingMode = RoundingMode.HALF_EVEN;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.300 -0400", hash_original_method = "DE88C1883A924350E112FA17163006E9", hash_generated_method = "8F3D56F06F018038500D450373B97D16")
    public  DecimalFormat() {
        Locale locale = Locale.getDefault();
        this.symbols = new DecimalFormatSymbols(locale);
        initNative(LocaleData.get(locale).numberPattern);
        // ---------- Original Method ----------
        //Locale locale = Locale.getDefault();
        //this.symbols = new DecimalFormatSymbols(locale);
        //initNative(LocaleData.get(locale).numberPattern);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.300 -0400", hash_original_method = "35AB5293961F9B593ADD183E8B6B3242", hash_generated_method = "32BBE801F866CA8E0CC29DE98F1BC803")
    public  DecimalFormat(String pattern) {
        this(pattern, Locale.getDefault());
        addTaint(pattern.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.301 -0400", hash_original_method = "17CE9F29195C1874CE3535C0883BB7B4", hash_generated_method = "AFF6933CB6C09563DAB789392870D572")
    public  DecimalFormat(String pattern, DecimalFormatSymbols value) {
        addTaint(pattern.getTaint());
        this.symbols = (DecimalFormatSymbols) value.clone();
        initNative(pattern);
        // ---------- Original Method ----------
        //this.symbols = (DecimalFormatSymbols) value.clone();
        //initNative(pattern);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.301 -0400", hash_original_method = "1EB8095DC5F926848B20CBA55F6BDD83", hash_generated_method = "AF780A5AAAFB38AE6A93DEC938F1E518")
      DecimalFormat(String pattern, Locale locale) {
        addTaint(pattern.getTaint());
        this.symbols = new DecimalFormatSymbols(locale);
        initNative(pattern);
        // ---------- Original Method ----------
        //this.symbols = new DecimalFormatSymbols(locale);
        //initNative(pattern);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.302 -0400", hash_original_method = "701B7114CA5711EBC62D39124CAE5412", hash_generated_method = "7C13C8CE54B2D2372BDD7E07EA7A3D78")
    private void initNative(String pattern) {
        try 
        {
            this.dform = new NativeDecimalFormat(pattern, symbols);
        } //End block
        catch (IllegalArgumentException ex)
        {
            IllegalArgumentException varC758B2AA23ECD39A4D321C3E93080200_1956064070 = new IllegalArgumentException(pattern);
            varC758B2AA23ECD39A4D321C3E93080200_1956064070.addTaint(taint);
            throw varC758B2AA23ECD39A4D321C3E93080200_1956064070;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.302 -0400", hash_original_method = "65449F4F2C00BF62B7AB916EB2126B60", hash_generated_method = "018CCBD96C4910FEE3846B780FDB4ABF")
    public void applyLocalizedPattern(String pattern) {
        addTaint(pattern.getTaint());
        dform.applyLocalizedPattern(pattern);
        // ---------- Original Method ----------
        //dform.applyLocalizedPattern(pattern);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.303 -0400", hash_original_method = "09E7693F39B1CA310938A9A4756C1A20", hash_generated_method = "6FF533525EADCC765E35497A4D2E0E4A")
    public void applyPattern(String pattern) {
        addTaint(pattern.getTaint());
        dform.applyPattern(pattern);
        // ---------- Original Method ----------
        //dform.applyPattern(pattern);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.303 -0400", hash_original_method = "9257BEF78EF77BD305740BB055166BA8", hash_generated_method = "E9095685B34C525262368092B4049BAC")
    @Override
    public Object clone() {
        DecimalFormat clone = (DecimalFormat) super.clone();
        clone.dform = (NativeDecimalFormat) dform.clone();
        clone.symbols = (DecimalFormatSymbols) symbols.clone();
Object var3DE52045BFD3C1BF3742F994ED6139AD_996571821 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_996571821.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_996571821;
        // ---------- Original Method ----------
        //DecimalFormat clone = (DecimalFormat) super.clone();
        //clone.dform = (NativeDecimalFormat) dform.clone();
        //clone.symbols = (DecimalFormatSymbols) symbols.clone();
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.304 -0400", hash_original_method = "6765E822C563E620DE26A0B6A028E00A", hash_generated_method = "F8BDF4A6065D40D3C47655C302104801")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
    if(this == object)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_2057514703 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_55404728 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_55404728;
        } //End block
    if(!(object instanceof DecimalFormat))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1753709687 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2020903456 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2020903456;
        } //End block
        DecimalFormat other = (DecimalFormat) object;
        boolean varAED7EB42C51492C5257D36B2E3963DD5_30852435 = ((this.dform == null ? other.dform == null : this.dform.equals(other.dform)) &&
                getDecimalFormatSymbols().equals(other.getDecimalFormatSymbols()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1720781440 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1720781440;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.305 -0400", hash_original_method = "3B59068DE45E1D685899870F874FDB91", hash_generated_method = "DE1C341A66983B837AA93D4ACC0A4239")
    @Override
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        addTaint(object.getTaint());
    if(object == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1723487602 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1723487602.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1723487602;
        } //End block
AttributedCharacterIterator var1C8F08569E748D494B38E4E81FDA61BE_139422179 =         dform.formatToCharacterIterator(object);
        var1C8F08569E748D494B38E4E81FDA61BE_139422179.addTaint(taint);
        return var1C8F08569E748D494B38E4E81FDA61BE_139422179;
        // ---------- Original Method ----------
        //if (object == null) {
            //throw new NullPointerException();
        //}
        //return dform.formatToCharacterIterator(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.305 -0400", hash_original_method = "FBA2DE4CAF4AAEBE0D141C6C51AFFE4A", hash_generated_method = "C06E94C0F5C41505E4E658537411A9FC")
    private void checkBufferAndFieldPosition(StringBuffer buffer, FieldPosition position) {
        addTaint(position.getTaint());
        addTaint(buffer.getTaint());
    if(buffer == null)        
        {
            NullPointerException varD1F0B530B211C354FD4DD40207900970_291189060 = new NullPointerException("buffer == null");
            varD1F0B530B211C354FD4DD40207900970_291189060.addTaint(taint);
            throw varD1F0B530B211C354FD4DD40207900970_291189060;
        } //End block
    if(position == null)        
        {
            NullPointerException var2030840110FE9F3EE225575977A8CDFC_694826075 = new NullPointerException("position == null");
            var2030840110FE9F3EE225575977A8CDFC_694826075.addTaint(taint);
            throw var2030840110FE9F3EE225575977A8CDFC_694826075;
        } //End block
        // ---------- Original Method ----------
        //if (buffer == null) {
            //throw new NullPointerException("buffer == null");
        //}
        //if (position == null) {
            //throw new NullPointerException("position == null");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.306 -0400", hash_original_method = "1E84E5D2AEBA1220C1C2BABB55EE58F4", hash_generated_method = "914427248A1CE0703DF8F2AFD305821B")
    @Override
    public StringBuffer format(double value, StringBuffer buffer, FieldPosition position) {
        addTaint(position.getTaint());
        addTaint(buffer.getTaint());
        addTaint(value);
        checkBufferAndFieldPosition(buffer, position);
    if(roundingMode == RoundingMode.UNNECESSARY)        
        {
            try 
            {
                setRoundingMode(RoundingMode.UP);
                String upResult = format(value, new StringBuffer(), new FieldPosition(0)).toString();
                setRoundingMode(RoundingMode.DOWN);
                String downResult = format(value, new StringBuffer(), new FieldPosition(0)).toString();
    if(!upResult.equals(downResult))                
                {
                    ArithmeticException varFBD8854082FA884D2BD6BDDF6692699E_533103393 = new ArithmeticException("rounding mode UNNECESSARY but rounding required");
                    varFBD8854082FA884D2BD6BDDF6692699E_533103393.addTaint(taint);
                    throw varFBD8854082FA884D2BD6BDDF6692699E_533103393;
                } //End block
            } //End block
            finally 
            {
                setRoundingMode(RoundingMode.UNNECESSARY);
            } //End block
        } //End block
        buffer.append(dform.formatDouble(value, position));
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_2138179623 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_2138179623.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_2138179623;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.306 -0400", hash_original_method = "B4F0904648F2A25561C63568681C231B", hash_generated_method = "3D9B881E42DFEFB208B3028E55CB995D")
    @Override
    public StringBuffer format(long value, StringBuffer buffer, FieldPosition position) {
        addTaint(position.getTaint());
        addTaint(buffer.getTaint());
        addTaint(value);
        checkBufferAndFieldPosition(buffer, position);
        buffer.append(dform.formatLong(value, position));
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_625087859 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_625087859.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_625087859;
        // ---------- Original Method ----------
        //checkBufferAndFieldPosition(buffer, position);
        //buffer.append(dform.formatLong(value, position));
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.307 -0400", hash_original_method = "9F0187C663B029586FEAEE5997EF0E8A", hash_generated_method = "23D7941A3F07E37A8FE235F855C99E48")
    @Override
    public final StringBuffer format(Object number, StringBuffer buffer, FieldPosition position) {
        addTaint(position.getTaint());
        addTaint(buffer.getTaint());
        addTaint(number.getTaint());
        checkBufferAndFieldPosition(buffer, position);
    if(number instanceof BigInteger)        
        {
            BigInteger bigInteger = (BigInteger) number;
            char[] chars = (bigInteger.bitLength() < 64)
                    ? dform.formatLong(bigInteger.longValue(), position)
                    : dform.formatBigInteger(bigInteger, position);
            buffer.append(chars);
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1207568929 =             buffer;
            varE75BCB56CC6A0BCEED51BE38E1BB3F38_1207568929.addTaint(taint);
            return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1207568929;
        } //End block
        else
    if(number instanceof BigDecimal)        
        {
            buffer.append(dform.formatBigDecimal((BigDecimal) number, position));
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_167601732 =             buffer;
            varE75BCB56CC6A0BCEED51BE38E1BB3F38_167601732.addTaint(taint);
            return varE75BCB56CC6A0BCEED51BE38E1BB3F38_167601732;
        } //End block
StringBuffer var6D1633B0DD6EC7C7C81187A942E347FE_263932991 =         super.format(number, buffer, position);
        var6D1633B0DD6EC7C7C81187A942E347FE_263932991.addTaint(taint);
        return var6D1633B0DD6EC7C7C81187A942E347FE_263932991;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.307 -0400", hash_original_method = "8DCCB340D185077EABFD1E6BFE3DB36F", hash_generated_method = "5DC5A23C1167B6A4655773ACD484381F")
    public DecimalFormatSymbols getDecimalFormatSymbols() {
DecimalFormatSymbols varF535F5587580EE309478194F19360926_1584762601 =         (DecimalFormatSymbols) symbols.clone();
        varF535F5587580EE309478194F19360926_1584762601.addTaint(taint);
        return varF535F5587580EE309478194F19360926_1584762601;
        // ---------- Original Method ----------
        //return (DecimalFormatSymbols) symbols.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.308 -0400", hash_original_method = "58EEC1F79BF01CD73E1939B30FC9554A", hash_generated_method = "FCEDE135A436D98DEF5EF917529D456B")
    @Override
    public Currency getCurrency() {
Currency varB2824F64BB61A457586B038943B89835_1414968038 =         symbols.getCurrency();
        varB2824F64BB61A457586B038943B89835_1414968038.addTaint(taint);
        return varB2824F64BB61A457586B038943B89835_1414968038;
        // ---------- Original Method ----------
        //return symbols.getCurrency();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.308 -0400", hash_original_method = "3224B3D9278B5F6729F4AC0FDDE7BC48", hash_generated_method = "8EC98E1DE69DCA1A62A49759FDB5E81A")
    public int getGroupingSize() {
        int varF7B553198ED33A5B17BAA1C380583753_1685941959 = (dform.getGroupingSize());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_155693414 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_155693414;
        // ---------- Original Method ----------
        //return dform.getGroupingSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.308 -0400", hash_original_method = "20055FC91A272014560FDC07D160C285", hash_generated_method = "AA639625585EDA5DD280C3F0B1DBECE3")
    public int getMultiplier() {
        int varF08F8DDF73B14B0EC487BA5B5A1E2282_1261012860 = (dform.getMultiplier());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1530771649 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1530771649;
        // ---------- Original Method ----------
        //return dform.getMultiplier();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.309 -0400", hash_original_method = "1F7C0591D1187101B5F5E6FCEBFE4BA7", hash_generated_method = "352A50BF58808DF95C145C70F78B70DA")
    public String getNegativePrefix() {
String varB9B0BB60870582BE65589AAFD64C6355_1981572416 =         dform.getNegativePrefix();
        varB9B0BB60870582BE65589AAFD64C6355_1981572416.addTaint(taint);
        return varB9B0BB60870582BE65589AAFD64C6355_1981572416;
        // ---------- Original Method ----------
        //return dform.getNegativePrefix();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.309 -0400", hash_original_method = "61D6D48706CC87AEEF19B015AC798361", hash_generated_method = "6722763DBC990DF677262C57C30D1375")
    public String getNegativeSuffix() {
String varA0A88B77049148E2CD33826DE5F34632_1458286359 =         dform.getNegativeSuffix();
        varA0A88B77049148E2CD33826DE5F34632_1458286359.addTaint(taint);
        return varA0A88B77049148E2CD33826DE5F34632_1458286359;
        // ---------- Original Method ----------
        //return dform.getNegativeSuffix();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.309 -0400", hash_original_method = "55B5FDB79399831D6973F7F1358A3E99", hash_generated_method = "20265CFD43FBD632EFD7106C4773FEF4")
    public String getPositivePrefix() {
String var84F89D4883A16B655A7BD1E8BA813C3D_1697322602 =         dform.getPositivePrefix();
        var84F89D4883A16B655A7BD1E8BA813C3D_1697322602.addTaint(taint);
        return var84F89D4883A16B655A7BD1E8BA813C3D_1697322602;
        // ---------- Original Method ----------
        //return dform.getPositivePrefix();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.310 -0400", hash_original_method = "2B5CAE95AEB5D456BD3378DDAC8D9097", hash_generated_method = "A17F1D67E61267C447BC69EFD9FF40B0")
    public String getPositiveSuffix() {
String var1DCF002772F6FAEA22E5DA91E05E494B_1567269572 =         dform.getPositiveSuffix();
        var1DCF002772F6FAEA22E5DA91E05E494B_1567269572.addTaint(taint);
        return var1DCF002772F6FAEA22E5DA91E05E494B_1567269572;
        // ---------- Original Method ----------
        //return dform.getPositiveSuffix();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.310 -0400", hash_original_method = "AC91BBA5B39870FB8DAE3ED8BCCB1730", hash_generated_method = "955BDC7F368A601053488A68BCBC57B1")
    @Override
    public int hashCode() {
        int varF7C589B784B5B5534A8F584BA985F036_1159520250 = (dform.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1680022676 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1680022676;
        // ---------- Original Method ----------
        //return dform.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.310 -0400", hash_original_method = "43884003345D483D0CB1C79601B3CBE6", hash_generated_method = "42E7D02161EA6A57E6AA3500C118B6E0")
    public boolean isDecimalSeparatorAlwaysShown() {
        boolean varEC4B0B0BD107CFB48E52240C3B5DB389_580323158 = (dform.isDecimalSeparatorAlwaysShown());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_776276394 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_776276394;
        // ---------- Original Method ----------
        //return dform.isDecimalSeparatorAlwaysShown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.310 -0400", hash_original_method = "0A7D24FF4B0BD9084E07584B0A08B543", hash_generated_method = "A445C6C93C11799F72838E009FF071B7")
    public boolean isParseBigDecimal() {
        boolean var5374EEAF0A51C3984BD7405F15CEF87F_279328522 = (dform.isParseBigDecimal());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_25819336 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_25819336;
        // ---------- Original Method ----------
        //return dform.isParseBigDecimal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.311 -0400", hash_original_method = "7481DA5537EE3F9956B6D5D3C7A225D0", hash_generated_method = "2C66A3F373015048EA265877678C648B")
    @Override
    public void setParseIntegerOnly(boolean value) {
        addTaint(value);
        dform.setParseIntegerOnly(value);
        // ---------- Original Method ----------
        //dform.setParseIntegerOnly(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.311 -0400", hash_original_method = "4A357353F9630D5720A9D39DD6F8D4E6", hash_generated_method = "9F76E538CE9ADE459609846C29C02AB5")
    @Override
    public boolean isParseIntegerOnly() {
        boolean var8FEB3383B92A74E3DE9D306189C6F948_1526826826 = (dform.isParseIntegerOnly());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1844908477 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1844908477;
        // ---------- Original Method ----------
        //return dform.isParseIntegerOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.312 -0400", hash_original_method = "5624B977416508FD6FAAB26F049D0D1B", hash_generated_method = "7A4463839A92C712B32A556214EF67E0")
    @Override
    public Number parse(String string, ParsePosition position) {
        addTaint(position.getTaint());
        addTaint(string.getTaint());
        Number number = dform.parse(string, position);
    if(number == null)        
        {
Number var540C13E9E156B687226421B24F2DF178_1859714116 =             null;
            var540C13E9E156B687226421B24F2DF178_1859714116.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1859714116;
        } //End block
    if(this.isParseBigDecimal())        
        {
    if(number instanceof Long)            
            {
Number varEEF39D5DE6579656B8D8E0103818D0D4_1335920611 =                 new BigDecimal(number.longValue());
                varEEF39D5DE6579656B8D8E0103818D0D4_1335920611.addTaint(taint);
                return varEEF39D5DE6579656B8D8E0103818D0D4_1335920611;
            } //End block
    if((number instanceof Double) && !((Double) number).isInfinite()
                    && !((Double) number).isNaN())            
            {
Number var7AD72F6E9E1EBAD9311F85125E40A22F_779275882 =                 new BigDecimal(number.toString());
                var7AD72F6E9E1EBAD9311F85125E40A22F_779275882.addTaint(taint);
                return var7AD72F6E9E1EBAD9311F85125E40A22F_779275882;
            } //End block
    if(number instanceof BigInteger)            
            {
Number var7AD72F6E9E1EBAD9311F85125E40A22F_2024790005 =                 new BigDecimal(number.toString());
                var7AD72F6E9E1EBAD9311F85125E40A22F_2024790005.addTaint(taint);
                return var7AD72F6E9E1EBAD9311F85125E40A22F_2024790005;
            } //End block
Number var63E80DF571E08DAA47BEFBF0BD0EEBAD_155978367 =             number;
            var63E80DF571E08DAA47BEFBF0BD0EEBAD_155978367.addTaint(taint);
            return var63E80DF571E08DAA47BEFBF0BD0EEBAD_155978367;
        } //End block
    if((number instanceof BigDecimal) || (number instanceof BigInteger))        
        {
Number varF90EEF3ECC5C9E491C97B32BD51573FD_1899994360 =             new Double(number.doubleValue());
            varF90EEF3ECC5C9E491C97B32BD51573FD_1899994360.addTaint(taint);
            return varF90EEF3ECC5C9E491C97B32BD51573FD_1899994360;
        } //End block
    if(this.isParseIntegerOnly() && number.equals(NEGATIVE_ZERO_DOUBLE))        
        {
Number var665B8F765AF400834C316ECBA9EEB8AD_58046772 =             Long.valueOf(0);
            var665B8F765AF400834C316ECBA9EEB8AD_58046772.addTaint(taint);
            return var665B8F765AF400834C316ECBA9EEB8AD_58046772;
        } //End block
Number var63E80DF571E08DAA47BEFBF0BD0EEBAD_358336450 =         number;
        var63E80DF571E08DAA47BEFBF0BD0EEBAD_358336450.addTaint(taint);
        return var63E80DF571E08DAA47BEFBF0BD0EEBAD_358336450;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.313 -0400", hash_original_method = "86D86A0FD4BCEEB43D34AB98DA52821C", hash_generated_method = "636EB1C6563D8F1E8C3404B82DD1F357")
    public void setDecimalFormatSymbols(DecimalFormatSymbols value) {
    if(value != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.313 -0400", hash_original_method = "4395CDF7142532C86BE10F65050BB217", hash_generated_method = "C0C98FC60A57DBA61F84D745782C0F13")
    @Override
    public void setCurrency(Currency currency) {
        addTaint(currency.getTaint());
        dform.setCurrency(Currency.getInstance(currency.getCurrencyCode()));
        symbols.setCurrency(currency);
        // ---------- Original Method ----------
        //dform.setCurrency(Currency.getInstance(currency.getCurrencyCode()));
        //symbols.setCurrency(currency);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.314 -0400", hash_original_method = "3B253ED7615AA8E014EF753B3801D05C", hash_generated_method = "F935A8B0ED807DC43C1A6B48583A13B2")
    public void setDecimalSeparatorAlwaysShown(boolean value) {
        addTaint(value);
        dform.setDecimalSeparatorAlwaysShown(value);
        // ---------- Original Method ----------
        //dform.setDecimalSeparatorAlwaysShown(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.314 -0400", hash_original_method = "C7D074F8D378A670A8F54B2C99810E6C", hash_generated_method = "3912CCCE677652AB466BB85CE4B83A01")
    public void setGroupingSize(int value) {
        addTaint(value);
        dform.setGroupingSize(value);
        // ---------- Original Method ----------
        //dform.setGroupingSize(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.314 -0400", hash_original_method = "ABE655961F79B3C1FE3443634AA21C37", hash_generated_method = "88975A73906325260020C2212DEE3F5E")
    @Override
    public void setGroupingUsed(boolean value) {
        addTaint(value);
        dform.setGroupingUsed(value);
        // ---------- Original Method ----------
        //dform.setGroupingUsed(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.314 -0400", hash_original_method = "47F90CF51661FE278576148D8412D8DA", hash_generated_method = "D1E8B86ADCD81D20FF971AF2BBF769A7")
    @Override
    public boolean isGroupingUsed() {
        boolean varDC4BD32FD7FC627ADA7B082C542ABAFF_1409120880 = (dform.isGroupingUsed());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1974247375 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1974247375;
        // ---------- Original Method ----------
        //return dform.isGroupingUsed();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.315 -0400", hash_original_method = "D0C418C01DBD33DD29A18941B68BCBF7", hash_generated_method = "80A66D0912EA07FD8A2B65D1DBB57E38")
    @Override
    public void setMaximumFractionDigits(int value) {
        addTaint(value);
        super.setMaximumFractionDigits(value);
        dform.setMaximumFractionDigits(getMaximumFractionDigits());
        setRoundingMode(roundingMode);
        // ---------- Original Method ----------
        //super.setMaximumFractionDigits(value);
        //dform.setMaximumFractionDigits(getMaximumFractionDigits());
        //setRoundingMode(roundingMode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.315 -0400", hash_original_method = "D5AFAB41905B13F7AD20D2FADDE73669", hash_generated_method = "2A2CD1CB37FF8511518C0BC891B42ADA")
    @Override
    public void setMaximumIntegerDigits(int value) {
        addTaint(value);
        super.setMaximumIntegerDigits(value);
        dform.setMaximumIntegerDigits(getMaximumIntegerDigits());
        // ---------- Original Method ----------
        //super.setMaximumIntegerDigits(value);
        //dform.setMaximumIntegerDigits(getMaximumIntegerDigits());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.316 -0400", hash_original_method = "9EB52B7EEE1D2B50BAA9500CCA3AFB4E", hash_generated_method = "DD16CB5D6B7CE5F032B96E71D8B98A23")
    @Override
    public void setMinimumFractionDigits(int value) {
        addTaint(value);
        super.setMinimumFractionDigits(value);
        dform.setMinimumFractionDigits(getMinimumFractionDigits());
        // ---------- Original Method ----------
        //super.setMinimumFractionDigits(value);
        //dform.setMinimumFractionDigits(getMinimumFractionDigits());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.316 -0400", hash_original_method = "6EFC03984672E7D89A36C9F22F2AAB3B", hash_generated_method = "3862AA35C539D3C9403450716198B1AF")
    @Override
    public void setMinimumIntegerDigits(int value) {
        addTaint(value);
        super.setMinimumIntegerDigits(value);
        dform.setMinimumIntegerDigits(getMinimumIntegerDigits());
        // ---------- Original Method ----------
        //super.setMinimumIntegerDigits(value);
        //dform.setMinimumIntegerDigits(getMinimumIntegerDigits());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.316 -0400", hash_original_method = "2E4C739E2F1CFFD7C6A061AD5BB9ADF4", hash_generated_method = "AA5F220208D41A1EDF1CE76FB8AF9790")
    public void setMultiplier(int value) {
        addTaint(value);
        dform.setMultiplier(value);
        // ---------- Original Method ----------
        //dform.setMultiplier(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.316 -0400", hash_original_method = "2C739DF56DF29E81D815FC52FA901BFF", hash_generated_method = "B6AB3136F84DCEF2A3DE4948A9F67C49")
    public void setNegativePrefix(String value) {
        addTaint(value.getTaint());
        dform.setNegativePrefix(value);
        // ---------- Original Method ----------
        //dform.setNegativePrefix(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.317 -0400", hash_original_method = "A51B4E91EE1B92D26334E28FF3A003CC", hash_generated_method = "972D063F229B6135B664A71C0027FB00")
    public void setNegativeSuffix(String value) {
        addTaint(value.getTaint());
        dform.setNegativeSuffix(value);
        // ---------- Original Method ----------
        //dform.setNegativeSuffix(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.317 -0400", hash_original_method = "7DA87D841FEB1EB829AC578209C7D87B", hash_generated_method = "C0C97A53763B70369524D7E590BF5EA0")
    public void setPositivePrefix(String value) {
        addTaint(value.getTaint());
        dform.setPositivePrefix(value);
        // ---------- Original Method ----------
        //dform.setPositivePrefix(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.317 -0400", hash_original_method = "740675349A091E1D283FD9B9350AE3AA", hash_generated_method = "44FE4C92B45FB79DCC34DD31ABF0CEDA")
    public void setPositiveSuffix(String value) {
        addTaint(value.getTaint());
        dform.setPositiveSuffix(value);
        // ---------- Original Method ----------
        //dform.setPositiveSuffix(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.318 -0400", hash_original_method = "DD680A2A91BAA011B854EB3CE1AE2AEF", hash_generated_method = "3FB9270F11CB54C7EA06895BD43AE55D")
    public void setParseBigDecimal(boolean newValue) {
        addTaint(newValue);
        dform.setParseBigDecimal(newValue);
        // ---------- Original Method ----------
        //dform.setParseBigDecimal(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.318 -0400", hash_original_method = "487E11DF64E483CD2A017195603FADD0", hash_generated_method = "37B6F49745594231C890A9B67754A286")
    public String toLocalizedPattern() {
String varDD8B40A14CA06C461BF22839E014F041_1498137348 =         dform.toLocalizedPattern();
        varDD8B40A14CA06C461BF22839E014F041_1498137348.addTaint(taint);
        return varDD8B40A14CA06C461BF22839E014F041_1498137348;
        // ---------- Original Method ----------
        //return dform.toLocalizedPattern();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.318 -0400", hash_original_method = "588A1CECAAE48251BC4F5156DD9C9A13", hash_generated_method = "21FAF1E3B10810CEF114A79DF9672605")
    public String toPattern() {
String varDFC74F53FA2B8E3B85B1E9D7EEF183F2_1197863945 =         dform.toPattern();
        varDFC74F53FA2B8E3B85B1E9D7EEF183F2_1197863945.addTaint(taint);
        return varDFC74F53FA2B8E3B85B1E9D7EEF183F2_1197863945;
        // ---------- Original Method ----------
        //return dform.toPattern();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.319 -0400", hash_original_method = "5BC6394F5F5C73D6097502885E125B6B", hash_generated_method = "F8FDEE228FEEE7060EAECC3138F40B55")
    private void writeObject(ObjectOutputStream stream) throws IOException, ClassNotFoundException {
        addTaint(stream.getTaint());
        ObjectOutputStream.PutField fields = stream.putFields();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.320 -0400", hash_original_method = "779EB6B3B1C2B5888DC5BF2D6BFB0D9C", hash_generated_method = "3D1EE7B944A1E1ED08D42D153B8324FB")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        addTaint(stream.getTaint());
        ObjectInputStream.GetField fields = stream.readFields();
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
        final int maximumIntegerDigits = fields.get("maximumIntegerDigits", 309);
        final int minimumIntegerDigits = fields.get("minimumIntegerDigits", 309);
        final int maximumFractionDigits = fields.get("maximumFractionDigits", 340);
        final int minimumFractionDigits = fields.get("minimumFractionDigits", 340);
        dform.setMaximumIntegerDigits(maximumIntegerDigits);
        super.setMaximumIntegerDigits(dform.getMaximumIntegerDigits());
        setMinimumIntegerDigits(minimumIntegerDigits);
        setMinimumFractionDigits(minimumFractionDigits);
        setMaximumFractionDigits(maximumFractionDigits);
        setParseBigDecimal(fields.get("parseBigDecimal", false));
    if(fields.get("serialVersionOnStream", 0) < 3)        
        {
            setMaximumIntegerDigits(super.getMaximumIntegerDigits());
            setMinimumIntegerDigits(super.getMinimumIntegerDigits());
            setMaximumFractionDigits(super.getMaximumFractionDigits());
            setMinimumFractionDigits(super.getMinimumFractionDigits());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.320 -0400", hash_original_method = "665DD451D3753ACD20842BCA4E3EB32E", hash_generated_method = "D522B63823C2C452B89153EEC11CA2B9")
    public RoundingMode getRoundingMode() {
RoundingMode var212E4C0114CE7EB809681C4A5E5BA4B1_1085806856 =         roundingMode;
        var212E4C0114CE7EB809681C4A5E5BA4B1_1085806856.addTaint(taint);
        return var212E4C0114CE7EB809681C4A5E5BA4B1_1085806856;
        // ---------- Original Method ----------
        //return roundingMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.321 -0400", hash_original_method = "91D8E7B9A007769AA087DAF2CAD1ADF8", hash_generated_method = "3C4805E7DC5B362E9AD92AE1939A9F85")
    public void setRoundingMode(RoundingMode roundingMode) {
    if(roundingMode == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1727495669 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1727495669.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1727495669;
        } //End block
        this.roundingMode = roundingMode;
    if(roundingMode != RoundingMode.UNNECESSARY)        
        {
            double roundingIncrement = 1.0 / Math.pow(10, Math.max(0, getMaximumFractionDigits()));
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.321 -0400", hash_original_field = "942CD9CF81E9C337E6C31D8025DDE1DD", hash_generated_field = "942EFADCEB0CE1279370395E6155A826")

    private static final long serialVersionUID = 864413376551465018L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.321 -0400", hash_original_field = "BBF28B41C805F82524E46B532E3F0E54", hash_generated_field = "932CCB84649F025E2FD30B1EDEB9D654")

    private static final Double NEGATIVE_ZERO_DOUBLE = new Double(-0.0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.322 -0400", hash_original_field = "027B5B0757B1FB87302B2884E911C820", hash_generated_field = "27E2EF88F203E0B05638B8EC99836A70")

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
}

