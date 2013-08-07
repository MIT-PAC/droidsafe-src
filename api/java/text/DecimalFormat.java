package java.text;

// Droidsafe Imports
import droidsafe.annotations.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.090 -0400", hash_original_field = "5503577415FC1D8D6B3818212A1745BC", hash_generated_field = "52EBB9EA358F4A29D5EE09E100128428")

    private transient DecimalFormatSymbols symbols;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.090 -0400", hash_original_field = "43FB3BF64083BD4CAC80E1ED8CD075E4", hash_generated_field = "311D958CADB5DD8F5620B5C0287903DF")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.090 -0400", hash_original_field = "825BD9DBFA8BD0A02A9B3F51F9F3F717", hash_generated_field = "F8D485A47161940F89EC9F4328B1DE40")

    private transient RoundingMode roundingMode = RoundingMode.HALF_EVEN;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.090 -0400", hash_original_method = "DE88C1883A924350E112FA17163006E9", hash_generated_method = "8F3D56F06F018038500D450373B97D16")
    public  DecimalFormat() {
        Locale locale = Locale.getDefault();
        this.symbols = new DecimalFormatSymbols(locale);
        initNative(LocaleData.get(locale).numberPattern);
        // ---------- Original Method ----------
        //Locale locale = Locale.getDefault();
        //this.symbols = new DecimalFormatSymbols(locale);
        //initNative(LocaleData.get(locale).numberPattern);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.091 -0400", hash_original_method = "35AB5293961F9B593ADD183E8B6B3242", hash_generated_method = "32BBE801F866CA8E0CC29DE98F1BC803")
    public  DecimalFormat(String pattern) {
        this(pattern, Locale.getDefault());
        addTaint(pattern.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.091 -0400", hash_original_method = "17CE9F29195C1874CE3535C0883BB7B4", hash_generated_method = "AFF6933CB6C09563DAB789392870D572")
    public  DecimalFormat(String pattern, DecimalFormatSymbols value) {
        addTaint(pattern.getTaint());
        this.symbols = (DecimalFormatSymbols) value.clone();
        initNative(pattern);
        // ---------- Original Method ----------
        //this.symbols = (DecimalFormatSymbols) value.clone();
        //initNative(pattern);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.092 -0400", hash_original_method = "1EB8095DC5F926848B20CBA55F6BDD83", hash_generated_method = "AF780A5AAAFB38AE6A93DEC938F1E518")
      DecimalFormat(String pattern, Locale locale) {
        addTaint(pattern.getTaint());
        this.symbols = new DecimalFormatSymbols(locale);
        initNative(pattern);
        // ---------- Original Method ----------
        //this.symbols = new DecimalFormatSymbols(locale);
        //initNative(pattern);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.092 -0400", hash_original_method = "701B7114CA5711EBC62D39124CAE5412", hash_generated_method = "CCEC8A6B8BFE4C5B294879A66E21B6D3")
    private void initNative(String pattern) {
        try 
        {
            this.dform = new NativeDecimalFormat(pattern, symbols);
        } //End block
        catch (IllegalArgumentException ex)
        {
            IllegalArgumentException varC758B2AA23ECD39A4D321C3E93080200_1579863067 = new IllegalArgumentException(pattern);
            varC758B2AA23ECD39A4D321C3E93080200_1579863067.addTaint(taint);
            throw varC758B2AA23ECD39A4D321C3E93080200_1579863067;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.093 -0400", hash_original_method = "65449F4F2C00BF62B7AB916EB2126B60", hash_generated_method = "018CCBD96C4910FEE3846B780FDB4ABF")
    public void applyLocalizedPattern(String pattern) {
        addTaint(pattern.getTaint());
        dform.applyLocalizedPattern(pattern);
        // ---------- Original Method ----------
        //dform.applyLocalizedPattern(pattern);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.093 -0400", hash_original_method = "09E7693F39B1CA310938A9A4756C1A20", hash_generated_method = "6FF533525EADCC765E35497A4D2E0E4A")
    public void applyPattern(String pattern) {
        addTaint(pattern.getTaint());
        dform.applyPattern(pattern);
        // ---------- Original Method ----------
        //dform.applyPattern(pattern);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.093 -0400", hash_original_method = "9257BEF78EF77BD305740BB055166BA8", hash_generated_method = "085CBBC8006AA575E0C267F6C19E278A")
    @Override
    public Object clone() {
        DecimalFormat clone = (DecimalFormat) super.clone();
        clone.dform = (NativeDecimalFormat) dform.clone();
        clone.symbols = (DecimalFormatSymbols) symbols.clone();
Object var3DE52045BFD3C1BF3742F994ED6139AD_332173938 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_332173938.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_332173938;
        // ---------- Original Method ----------
        //DecimalFormat clone = (DecimalFormat) super.clone();
        //clone.dform = (NativeDecimalFormat) dform.clone();
        //clone.symbols = (DecimalFormatSymbols) symbols.clone();
        //return clone;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.094 -0400", hash_original_method = "6765E822C563E620DE26A0B6A028E00A", hash_generated_method = "30DC877800341202580BCB17ED0132B8")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        if(this == object)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1579702635 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2070664372 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2070664372;
        } //End block
        if(!(object instanceof DecimalFormat))        
        {
            boolean var68934A3E9455FA72420237EB05902327_577581929 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_614482364 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_614482364;
        } //End block
        DecimalFormat other = (DecimalFormat) object;
        boolean varAED7EB42C51492C5257D36B2E3963DD5_1696051365 = ((this.dform == null ? other.dform == null : this.dform.equals(other.dform)) &&
                getDecimalFormatSymbols().equals(other.getDecimalFormatSymbols()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1022531643 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1022531643;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.094 -0400", hash_original_method = "3B59068DE45E1D685899870F874FDB91", hash_generated_method = "266AF6723514A8272257A8B11F1494C8")
    @Override
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        addTaint(object.getTaint());
        if(object == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_158611311 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_158611311.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_158611311;
        } //End block
AttributedCharacterIterator var1C8F08569E748D494B38E4E81FDA61BE_2001920330 =         dform.formatToCharacterIterator(object);
        var1C8F08569E748D494B38E4E81FDA61BE_2001920330.addTaint(taint);
        return var1C8F08569E748D494B38E4E81FDA61BE_2001920330;
        // ---------- Original Method ----------
        //if (object == null) {
            //throw new NullPointerException();
        //}
        //return dform.formatToCharacterIterator(object);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.095 -0400", hash_original_method = "FBA2DE4CAF4AAEBE0D141C6C51AFFE4A", hash_generated_method = "0F2E7D6B461187D00FB0B92CB73CB7E5")
    private void checkBufferAndFieldPosition(StringBuffer buffer, FieldPosition position) {
        addTaint(position.getTaint());
        addTaint(buffer.getTaint());
        if(buffer == null)        
        {
            NullPointerException varD1F0B530B211C354FD4DD40207900970_184637675 = new NullPointerException("buffer == null");
            varD1F0B530B211C354FD4DD40207900970_184637675.addTaint(taint);
            throw varD1F0B530B211C354FD4DD40207900970_184637675;
        } //End block
        if(position == null)        
        {
            NullPointerException var2030840110FE9F3EE225575977A8CDFC_609923945 = new NullPointerException("position == null");
            var2030840110FE9F3EE225575977A8CDFC_609923945.addTaint(taint);
            throw var2030840110FE9F3EE225575977A8CDFC_609923945;
        } //End block
        // ---------- Original Method ----------
        //if (buffer == null) {
            //throw new NullPointerException("buffer == null");
        //}
        //if (position == null) {
            //throw new NullPointerException("position == null");
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.095 -0400", hash_original_method = "1E84E5D2AEBA1220C1C2BABB55EE58F4", hash_generated_method = "30056D0DF3E7E0C56062C98C6158BA79")
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
                    ArithmeticException varFBD8854082FA884D2BD6BDDF6692699E_633570080 = new ArithmeticException("rounding mode UNNECESSARY but rounding required");
                    varFBD8854082FA884D2BD6BDDF6692699E_633570080.addTaint(taint);
                    throw varFBD8854082FA884D2BD6BDDF6692699E_633570080;
                } //End block
            } //End block
            finally 
            {
                setRoundingMode(RoundingMode.UNNECESSARY);
            } //End block
        } //End block
        buffer.append(dform.formatDouble(value, position));
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_91000338 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_91000338.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_91000338;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.096 -0400", hash_original_method = "B4F0904648F2A25561C63568681C231B", hash_generated_method = "9F3605FC82CEB4CBB3633024B799F35F")
    @Override
    public StringBuffer format(long value, StringBuffer buffer, FieldPosition position) {
        addTaint(position.getTaint());
        addTaint(buffer.getTaint());
        addTaint(value);
        checkBufferAndFieldPosition(buffer, position);
        buffer.append(dform.formatLong(value, position));
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_434701930 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_434701930.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_434701930;
        // ---------- Original Method ----------
        //checkBufferAndFieldPosition(buffer, position);
        //buffer.append(dform.formatLong(value, position));
        //return buffer;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.096 -0400", hash_original_method = "9F0187C663B029586FEAEE5997EF0E8A", hash_generated_method = "18E9B231B9B9C59193DDAD1DCE4D8663")
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
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_421298292 =             buffer;
            varE75BCB56CC6A0BCEED51BE38E1BB3F38_421298292.addTaint(taint);
            return varE75BCB56CC6A0BCEED51BE38E1BB3F38_421298292;
        } //End block
        else
        if(number instanceof BigDecimal)        
        {
            buffer.append(dform.formatBigDecimal((BigDecimal) number, position));
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_604170906 =             buffer;
            varE75BCB56CC6A0BCEED51BE38E1BB3F38_604170906.addTaint(taint);
            return varE75BCB56CC6A0BCEED51BE38E1BB3F38_604170906;
        } //End block
StringBuffer var6D1633B0DD6EC7C7C81187A942E347FE_1806947776 =         super.format(number, buffer, position);
        var6D1633B0DD6EC7C7C81187A942E347FE_1806947776.addTaint(taint);
        return var6D1633B0DD6EC7C7C81187A942E347FE_1806947776;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.096 -0400", hash_original_method = "8DCCB340D185077EABFD1E6BFE3DB36F", hash_generated_method = "405CAD3683361825464B9B83956F3E85")
    public DecimalFormatSymbols getDecimalFormatSymbols() {
DecimalFormatSymbols varF535F5587580EE309478194F19360926_629166181 =         (DecimalFormatSymbols) symbols.clone();
        varF535F5587580EE309478194F19360926_629166181.addTaint(taint);
        return varF535F5587580EE309478194F19360926_629166181;
        // ---------- Original Method ----------
        //return (DecimalFormatSymbols) symbols.clone();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.097 -0400", hash_original_method = "58EEC1F79BF01CD73E1939B30FC9554A", hash_generated_method = "A1E067D22EBD38E15EF09E94FB9FEDCF")
    @Override
    public Currency getCurrency() {
Currency varB2824F64BB61A457586B038943B89835_2128011845 =         symbols.getCurrency();
        varB2824F64BB61A457586B038943B89835_2128011845.addTaint(taint);
        return varB2824F64BB61A457586B038943B89835_2128011845;
        // ---------- Original Method ----------
        //return symbols.getCurrency();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.097 -0400", hash_original_method = "3224B3D9278B5F6729F4AC0FDDE7BC48", hash_generated_method = "3D2835E78A71096144778A476D8C827E")
    public int getGroupingSize() {
        int varF7B553198ED33A5B17BAA1C380583753_1762257474 = (dform.getGroupingSize());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1569316122 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1569316122;
        // ---------- Original Method ----------
        //return dform.getGroupingSize();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.097 -0400", hash_original_method = "20055FC91A272014560FDC07D160C285", hash_generated_method = "0DF6EE0F54B746A206DD3982FF593CD7")
    public int getMultiplier() {
        int varF08F8DDF73B14B0EC487BA5B5A1E2282_21007716 = (dform.getMultiplier());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1153401468 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1153401468;
        // ---------- Original Method ----------
        //return dform.getMultiplier();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.097 -0400", hash_original_method = "1F7C0591D1187101B5F5E6FCEBFE4BA7", hash_generated_method = "6E77EF75BA647085F34E5464271E64FE")
    public String getNegativePrefix() {
String varB9B0BB60870582BE65589AAFD64C6355_50894940 =         dform.getNegativePrefix();
        varB9B0BB60870582BE65589AAFD64C6355_50894940.addTaint(taint);
        return varB9B0BB60870582BE65589AAFD64C6355_50894940;
        // ---------- Original Method ----------
        //return dform.getNegativePrefix();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.097 -0400", hash_original_method = "61D6D48706CC87AEEF19B015AC798361", hash_generated_method = "F77F8A617BA41533DB83FAC7CFB7BDCD")
    public String getNegativeSuffix() {
String varA0A88B77049148E2CD33826DE5F34632_1304757013 =         dform.getNegativeSuffix();
        varA0A88B77049148E2CD33826DE5F34632_1304757013.addTaint(taint);
        return varA0A88B77049148E2CD33826DE5F34632_1304757013;
        // ---------- Original Method ----------
        //return dform.getNegativeSuffix();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.098 -0400", hash_original_method = "55B5FDB79399831D6973F7F1358A3E99", hash_generated_method = "7C999D1B0F579C86E2783531B43E22CF")
    public String getPositivePrefix() {
String var84F89D4883A16B655A7BD1E8BA813C3D_828127481 =         dform.getPositivePrefix();
        var84F89D4883A16B655A7BD1E8BA813C3D_828127481.addTaint(taint);
        return var84F89D4883A16B655A7BD1E8BA813C3D_828127481;
        // ---------- Original Method ----------
        //return dform.getPositivePrefix();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.098 -0400", hash_original_method = "2B5CAE95AEB5D456BD3378DDAC8D9097", hash_generated_method = "11A24E3413A51776BA8F8E5B6D61DFFC")
    public String getPositiveSuffix() {
String var1DCF002772F6FAEA22E5DA91E05E494B_168850125 =         dform.getPositiveSuffix();
        var1DCF002772F6FAEA22E5DA91E05E494B_168850125.addTaint(taint);
        return var1DCF002772F6FAEA22E5DA91E05E494B_168850125;
        // ---------- Original Method ----------
        //return dform.getPositiveSuffix();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.098 -0400", hash_original_method = "AC91BBA5B39870FB8DAE3ED8BCCB1730", hash_generated_method = "85336A8166D63C0BAAA98CC3960830B7")
    @Override
    public int hashCode() {
        int varF7C589B784B5B5534A8F584BA985F036_1737390491 = (dform.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1094553257 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1094553257;
        // ---------- Original Method ----------
        //return dform.hashCode();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.098 -0400", hash_original_method = "43884003345D483D0CB1C79601B3CBE6", hash_generated_method = "282D3956C8FFC2A18D4D21BE3413ADDB")
    public boolean isDecimalSeparatorAlwaysShown() {
        boolean varEC4B0B0BD107CFB48E52240C3B5DB389_864706931 = (dform.isDecimalSeparatorAlwaysShown());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1691824789 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1691824789;
        // ---------- Original Method ----------
        //return dform.isDecimalSeparatorAlwaysShown();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.098 -0400", hash_original_method = "0A7D24FF4B0BD9084E07584B0A08B543", hash_generated_method = "EFDF5D81F6D277E58C17ABD9A75CD45B")
    public boolean isParseBigDecimal() {
        boolean var5374EEAF0A51C3984BD7405F15CEF87F_981823351 = (dform.isParseBigDecimal());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1361661070 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1361661070;
        // ---------- Original Method ----------
        //return dform.isParseBigDecimal();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.099 -0400", hash_original_method = "7481DA5537EE3F9956B6D5D3C7A225D0", hash_generated_method = "2C66A3F373015048EA265877678C648B")
    @Override
    public void setParseIntegerOnly(boolean value) {
        addTaint(value);
        dform.setParseIntegerOnly(value);
        // ---------- Original Method ----------
        //dform.setParseIntegerOnly(value);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.099 -0400", hash_original_method = "4A357353F9630D5720A9D39DD6F8D4E6", hash_generated_method = "2DD7039B0D638AE573CBA3CB399A7424")
    @Override
    public boolean isParseIntegerOnly() {
        boolean var8FEB3383B92A74E3DE9D306189C6F948_2081582627 = (dform.isParseIntegerOnly());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2103587196 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2103587196;
        // ---------- Original Method ----------
        //return dform.isParseIntegerOnly();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.100 -0400", hash_original_method = "5624B977416508FD6FAAB26F049D0D1B", hash_generated_method = "A0308C14DC16493C370E5A803F87F484")
    @Override
    public Number parse(String string, ParsePosition position) {
        addTaint(position.getTaint());
        addTaint(string.getTaint());
        Number number = dform.parse(string, position);
        if(number == null)        
        {
Number var540C13E9E156B687226421B24F2DF178_1534739147 =             null;
            var540C13E9E156B687226421B24F2DF178_1534739147.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1534739147;
        } //End block
        if(this.isParseBigDecimal())        
        {
            if(number instanceof Long)            
            {
Number varEEF39D5DE6579656B8D8E0103818D0D4_2144137528 =                 new BigDecimal(number.longValue());
                varEEF39D5DE6579656B8D8E0103818D0D4_2144137528.addTaint(taint);
                return varEEF39D5DE6579656B8D8E0103818D0D4_2144137528;
            } //End block
            if((number instanceof Double) && !((Double) number).isInfinite()
                    && !((Double) number).isNaN())            
            {
Number var7AD72F6E9E1EBAD9311F85125E40A22F_1794919698 =                 new BigDecimal(number.toString());
                var7AD72F6E9E1EBAD9311F85125E40A22F_1794919698.addTaint(taint);
                return var7AD72F6E9E1EBAD9311F85125E40A22F_1794919698;
            } //End block
            if(number instanceof BigInteger)            
            {
Number var7AD72F6E9E1EBAD9311F85125E40A22F_653793188 =                 new BigDecimal(number.toString());
                var7AD72F6E9E1EBAD9311F85125E40A22F_653793188.addTaint(taint);
                return var7AD72F6E9E1EBAD9311F85125E40A22F_653793188;
            } //End block
Number var63E80DF571E08DAA47BEFBF0BD0EEBAD_1445942033 =             number;
            var63E80DF571E08DAA47BEFBF0BD0EEBAD_1445942033.addTaint(taint);
            return var63E80DF571E08DAA47BEFBF0BD0EEBAD_1445942033;
        } //End block
        if((number instanceof BigDecimal) || (number instanceof BigInteger))        
        {
Number varF90EEF3ECC5C9E491C97B32BD51573FD_447148300 =             new Double(number.doubleValue());
            varF90EEF3ECC5C9E491C97B32BD51573FD_447148300.addTaint(taint);
            return varF90EEF3ECC5C9E491C97B32BD51573FD_447148300;
        } //End block
        if(this.isParseIntegerOnly() && number.equals(NEGATIVE_ZERO_DOUBLE))        
        {
Number var665B8F765AF400834C316ECBA9EEB8AD_198020055 =             Long.valueOf(0);
            var665B8F765AF400834C316ECBA9EEB8AD_198020055.addTaint(taint);
            return var665B8F765AF400834C316ECBA9EEB8AD_198020055;
        } //End block
Number var63E80DF571E08DAA47BEFBF0BD0EEBAD_1834029150 =         number;
        var63E80DF571E08DAA47BEFBF0BD0EEBAD_1834029150.addTaint(taint);
        return var63E80DF571E08DAA47BEFBF0BD0EEBAD_1834029150;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.101 -0400", hash_original_method = "86D86A0FD4BCEEB43D34AB98DA52821C", hash_generated_method = "636EB1C6563D8F1E8C3404B82DD1F357")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.101 -0400", hash_original_method = "4395CDF7142532C86BE10F65050BB217", hash_generated_method = "C0C98FC60A57DBA61F84D745782C0F13")
    @Override
    public void setCurrency(Currency currency) {
        addTaint(currency.getTaint());
        dform.setCurrency(Currency.getInstance(currency.getCurrencyCode()));
        symbols.setCurrency(currency);
        // ---------- Original Method ----------
        //dform.setCurrency(Currency.getInstance(currency.getCurrencyCode()));
        //symbols.setCurrency(currency);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.101 -0400", hash_original_method = "3B253ED7615AA8E014EF753B3801D05C", hash_generated_method = "F935A8B0ED807DC43C1A6B48583A13B2")
    public void setDecimalSeparatorAlwaysShown(boolean value) {
        addTaint(value);
        dform.setDecimalSeparatorAlwaysShown(value);
        // ---------- Original Method ----------
        //dform.setDecimalSeparatorAlwaysShown(value);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.101 -0400", hash_original_method = "C7D074F8D378A670A8F54B2C99810E6C", hash_generated_method = "3912CCCE677652AB466BB85CE4B83A01")
    public void setGroupingSize(int value) {
        addTaint(value);
        dform.setGroupingSize(value);
        // ---------- Original Method ----------
        //dform.setGroupingSize(value);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.102 -0400", hash_original_method = "ABE655961F79B3C1FE3443634AA21C37", hash_generated_method = "88975A73906325260020C2212DEE3F5E")
    @Override
    public void setGroupingUsed(boolean value) {
        addTaint(value);
        dform.setGroupingUsed(value);
        // ---------- Original Method ----------
        //dform.setGroupingUsed(value);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.102 -0400", hash_original_method = "47F90CF51661FE278576148D8412D8DA", hash_generated_method = "65BC6E4544E25A3BC944AEE5F3443270")
    @Override
    public boolean isGroupingUsed() {
        boolean varDC4BD32FD7FC627ADA7B082C542ABAFF_923164166 = (dform.isGroupingUsed());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2013605308 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2013605308;
        // ---------- Original Method ----------
        //return dform.isGroupingUsed();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.102 -0400", hash_original_method = "D0C418C01DBD33DD29A18941B68BCBF7", hash_generated_method = "80A66D0912EA07FD8A2B65D1DBB57E38")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.102 -0400", hash_original_method = "D5AFAB41905B13F7AD20D2FADDE73669", hash_generated_method = "2A2CD1CB37FF8511518C0BC891B42ADA")
    @Override
    public void setMaximumIntegerDigits(int value) {
        addTaint(value);
        super.setMaximumIntegerDigits(value);
        dform.setMaximumIntegerDigits(getMaximumIntegerDigits());
        // ---------- Original Method ----------
        //super.setMaximumIntegerDigits(value);
        //dform.setMaximumIntegerDigits(getMaximumIntegerDigits());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.102 -0400", hash_original_method = "9EB52B7EEE1D2B50BAA9500CCA3AFB4E", hash_generated_method = "DD16CB5D6B7CE5F032B96E71D8B98A23")
    @Override
    public void setMinimumFractionDigits(int value) {
        addTaint(value);
        super.setMinimumFractionDigits(value);
        dform.setMinimumFractionDigits(getMinimumFractionDigits());
        // ---------- Original Method ----------
        //super.setMinimumFractionDigits(value);
        //dform.setMinimumFractionDigits(getMinimumFractionDigits());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.102 -0400", hash_original_method = "6EFC03984672E7D89A36C9F22F2AAB3B", hash_generated_method = "3862AA35C539D3C9403450716198B1AF")
    @Override
    public void setMinimumIntegerDigits(int value) {
        addTaint(value);
        super.setMinimumIntegerDigits(value);
        dform.setMinimumIntegerDigits(getMinimumIntegerDigits());
        // ---------- Original Method ----------
        //super.setMinimumIntegerDigits(value);
        //dform.setMinimumIntegerDigits(getMinimumIntegerDigits());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.102 -0400", hash_original_method = "2E4C739E2F1CFFD7C6A061AD5BB9ADF4", hash_generated_method = "AA5F220208D41A1EDF1CE76FB8AF9790")
    public void setMultiplier(int value) {
        addTaint(value);
        dform.setMultiplier(value);
        // ---------- Original Method ----------
        //dform.setMultiplier(value);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.102 -0400", hash_original_method = "2C739DF56DF29E81D815FC52FA901BFF", hash_generated_method = "B6AB3136F84DCEF2A3DE4948A9F67C49")
    public void setNegativePrefix(String value) {
        addTaint(value.getTaint());
        dform.setNegativePrefix(value);
        // ---------- Original Method ----------
        //dform.setNegativePrefix(value);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.102 -0400", hash_original_method = "A51B4E91EE1B92D26334E28FF3A003CC", hash_generated_method = "972D063F229B6135B664A71C0027FB00")
    public void setNegativeSuffix(String value) {
        addTaint(value.getTaint());
        dform.setNegativeSuffix(value);
        // ---------- Original Method ----------
        //dform.setNegativeSuffix(value);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.103 -0400", hash_original_method = "7DA87D841FEB1EB829AC578209C7D87B", hash_generated_method = "C0C97A53763B70369524D7E590BF5EA0")
    public void setPositivePrefix(String value) {
        addTaint(value.getTaint());
        dform.setPositivePrefix(value);
        // ---------- Original Method ----------
        //dform.setPositivePrefix(value);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.103 -0400", hash_original_method = "740675349A091E1D283FD9B9350AE3AA", hash_generated_method = "44FE4C92B45FB79DCC34DD31ABF0CEDA")
    public void setPositiveSuffix(String value) {
        addTaint(value.getTaint());
        dform.setPositiveSuffix(value);
        // ---------- Original Method ----------
        //dform.setPositiveSuffix(value);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.103 -0400", hash_original_method = "DD680A2A91BAA011B854EB3CE1AE2AEF", hash_generated_method = "3FB9270F11CB54C7EA06895BD43AE55D")
    public void setParseBigDecimal(boolean newValue) {
        addTaint(newValue);
        dform.setParseBigDecimal(newValue);
        // ---------- Original Method ----------
        //dform.setParseBigDecimal(newValue);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.103 -0400", hash_original_method = "487E11DF64E483CD2A017195603FADD0", hash_generated_method = "2760AE247E7D43D6F556D5B852CB0971")
    public String toLocalizedPattern() {
String varDD8B40A14CA06C461BF22839E014F041_1722931481 =         dform.toLocalizedPattern();
        varDD8B40A14CA06C461BF22839E014F041_1722931481.addTaint(taint);
        return varDD8B40A14CA06C461BF22839E014F041_1722931481;
        // ---------- Original Method ----------
        //return dform.toLocalizedPattern();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.103 -0400", hash_original_method = "588A1CECAAE48251BC4F5156DD9C9A13", hash_generated_method = "3BDBA9EE932DD31DAB9155AE5CF1BD27")
    public String toPattern() {
String varDFC74F53FA2B8E3B85B1E9D7EEF183F2_1453619505 =         dform.toPattern();
        varDFC74F53FA2B8E3B85B1E9D7EEF183F2_1453619505.addTaint(taint);
        return varDFC74F53FA2B8E3B85B1E9D7EEF183F2_1453619505;
        // ---------- Original Method ----------
        //return dform.toPattern();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.104 -0400", hash_original_method = "5BC6394F5F5C73D6097502885E125B6B", hash_generated_method = "F8FDEE228FEEE7060EAECC3138F40B55")
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.104 -0400", hash_original_method = "779EB6B3B1C2B5888DC5BF2D6BFB0D9C", hash_generated_method = "3D1EE7B944A1E1ED08D42D153B8324FB")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.104 -0400", hash_original_method = "665DD451D3753ACD20842BCA4E3EB32E", hash_generated_method = "EF7921686CCD3B2D178A2E0D43176667")
    public RoundingMode getRoundingMode() {
RoundingMode var212E4C0114CE7EB809681C4A5E5BA4B1_1628466029 =         roundingMode;
        var212E4C0114CE7EB809681C4A5E5BA4B1_1628466029.addTaint(taint);
        return var212E4C0114CE7EB809681C4A5E5BA4B1_1628466029;
        // ---------- Original Method ----------
        //return roundingMode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.105 -0400", hash_original_method = "91D8E7B9A007769AA087DAF2CAD1ADF8", hash_generated_method = "0CE961D861E43D4CCDB6B02C7A584A3E")
    public void setRoundingMode(RoundingMode roundingMode) {
        if(roundingMode == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_271817069 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_271817069.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_271817069;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.105 -0400", hash_original_field = "942CD9CF81E9C337E6C31D8025DDE1DD", hash_generated_field = "942EFADCEB0CE1279370395E6155A826")

    private static final long serialVersionUID = 864413376551465018L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.105 -0400", hash_original_field = "BBF28B41C805F82524E46B532E3F0E54", hash_generated_field = "932CCB84649F025E2FD30B1EDEB9D654")

    private static final Double NEGATIVE_ZERO_DOUBLE = new Double(-0.0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.105 -0400", hash_original_field = "027B5B0757B1FB87302B2884E911C820", hash_generated_field = "27E2EF88F203E0B05638B8EC99836A70")

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

