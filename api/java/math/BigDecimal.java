package java.math;

// Droidsafe Imports
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

import libcore.math.MathUtils;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class BigDecimal extends Number implements Comparable<BigDecimal>, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.576 -0400", hash_original_field = "0A495C22CEE2486109FF49D52FAB7401", hash_generated_field = "326D03DFD6F64D4B3F1173FBD427B520")

    private transient String toStringImage = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.576 -0400", hash_original_field = "B81E47D2AA677809E4BE3C9232B2407F", hash_generated_field = "3D9A07F218385AD7A5B345B923EAF46E")

    private transient int hashCode = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.576 -0400", hash_original_field = "3A1F983ED27316FA36EAAFE36DA5649F", hash_generated_field = "E1C21CCC8969038A086EDD16030014B8")

    private BigInteger intVal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.576 -0400", hash_original_field = "B35AD5BAFCCD957A930C16D5DD131EE4", hash_generated_field = "1C841931B61AD9BC0EB5C76BA4219E64")

    private transient int bitLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.576 -0400", hash_original_field = "412477B04CAB5EE326327BE6C10454DF", hash_generated_field = "27339F171BD0CF229BCBE4E7356A5F0B")

    private transient long smallValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.576 -0400", hash_original_field = "0CB47AEB6E5F9323F0969E628C4E59F5", hash_generated_field = "F9D5D1CA2ABDD82810FF1FE80E0268E6")

    private int scale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.576 -0400", hash_original_field = "46C2159C904EABF687686166E93B72AA", hash_generated_field = "4E7D370BAE76B07332BBBB929C2DF340")

    private transient int precision = 0;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.576 -0400", hash_original_method = "6BC27F867C09C0249873A4D338F8666D", hash_generated_method = "675ADE6C6F01FF4ED08427C7FC23A83B")
    private  BigDecimal(long smallValue, int scale) {
        this.smallValue = smallValue;
        this.scale = scale;
        this.bitLength = bitLength(smallValue);
        // ---------- Original Method ----------
        //this.smallValue = smallValue;
        //this.scale = scale;
        //this.bitLength = bitLength(smallValue);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.576 -0400", hash_original_method = "9F6CD654516DCD03F33530EDCF81D84D", hash_generated_method = "3DC98F1132A232115D5983B57B665BF0")
    private  BigDecimal(int smallValue, int scale) {
        this.smallValue = smallValue;
        this.scale = scale;
        this.bitLength = bitLength(smallValue);
        // ---------- Original Method ----------
        //this.smallValue = smallValue;
        //this.scale = scale;
        //this.bitLength = bitLength(smallValue);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.577 -0400", hash_original_method = "374C425CF4086C798A21EEA670343536", hash_generated_method = "0352E809877806BE1392A12BEE81362D")
    public  BigDecimal(char[] in, int offset, int len) {
        addTaint(len);
        addTaint(in[0]);
        int begin = offset;
        int last = offset + (len - 1);
        String scaleString;
        StringBuilder unscaledBuffer;
        long newScale;
        if(in == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_196100460 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_196100460.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_196100460;
        } //End block
        if((last >= in.length) || (offset < 0) || (len <= 0) || (last < 0))        
        {
            NumberFormatException varAAEF0009D42EC95914540CC09A7820A8_1086927406 = new NumberFormatException("Bad offset/length: offset=" + offset +
                    " len=" + len + " in.length=" + in.length);
            varAAEF0009D42EC95914540CC09A7820A8_1086927406.addTaint(taint);
            throw varAAEF0009D42EC95914540CC09A7820A8_1086927406;
        } //End block
        unscaledBuffer = new StringBuilder(len);
        int bufLength = 0;
        if((offset <= last) && (in[offset] == '+'))        
        {
            offset++;
            begin++;
        } //End block
        int counter = 0;
        boolean wasNonZero = false;
for(;(offset <= last) && (in[offset] != '.') && (in[offset] != 'e') && (in[offset] != 'E');offset++)
        {
            if(!wasNonZero)            
            {
                if(in[offset] == '0')                
                {
                    counter++;
                } //End block
                else
                {
                    wasNonZero = true;
                } //End block
            } //End block
        } //End block
        unscaledBuffer.append(in, begin, offset - begin);
        bufLength += offset - begin;
        if((offset <= last) && (in[offset] == '.'))        
        {
            offset++;
            begin = offset;
for(;(offset <= last) && (in[offset] != 'e')
            && (in[offset] != 'E');offset++)
            {
                if(!wasNonZero)                
                {
                    if(in[offset] == '0')                    
                    {
                        counter++;
                    } //End block
                    else
                    {
                        wasNonZero = true;
                    } //End block
                } //End block
            } //End block
            scale = offset - begin;
            bufLength +=scale;
            unscaledBuffer.append(in, begin, scale);
        } //End block
        else
        {
            scale = 0;
        } //End block
        if((offset <= last) && ((in[offset] == 'e') || (in[offset] == 'E')))        
        {
            offset++;
            begin = offset;
            if((offset <= last) && (in[offset] == '+'))            
            {
                offset++;
                if((offset <= last) && (in[offset] != '-'))                
                {
                    begin++;
                } //End block
            } //End block
            scaleString = String.valueOf(in, begin, last + 1 - begin);
            newScale = (long)scale - Integer.parseInt(scaleString);
            scale = (int)newScale;
            if(newScale != scale)            
            {
                NumberFormatException var5CC2BE7BB2549E36BE8412551FCA65A3_453940146 = new NumberFormatException("Scale out of range");
                var5CC2BE7BB2549E36BE8412551FCA65A3_453940146.addTaint(taint);
                throw var5CC2BE7BB2549E36BE8412551FCA65A3_453940146;
            } //End block
        } //End block
        if(bufLength < 19)        
        {
            smallValue = Long.parseLong(unscaledBuffer.toString());
            bitLength = bitLength(smallValue);
        } //End block
        else
        {
            setUnscaledValue(new BigInteger(unscaledBuffer.toString()));
        } //End block
        precision = unscaledBuffer.length() - counter;
        if(unscaledBuffer.charAt(0) == '-')        
        {
            precision --;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.578 -0400", hash_original_method = "021DB19003FFCB38960FC53E0DB20D11", hash_generated_method = "6EA90666D1CAF03400C0CFC3D6B3005E")
    public  BigDecimal(char[] in, int offset, int len, MathContext mc) {
        this(in, offset, len);
        addTaint(mc.getTaint());
        addTaint(len);
        addTaint(offset);
        addTaint(in[0]);
        inplaceRound(mc);
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.578 -0400", hash_original_method = "2CA49E7A005F756FE298C75D3E276FBD", hash_generated_method = "B4FD1176C71EA8991071A29C074F944A")
    public  BigDecimal(char[] in) {
        this(in, 0, in.length);
        addTaint(in[0]);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.579 -0400", hash_original_method = "24A3A809E90D8D728111B1E9DFB6AE2B", hash_generated_method = "003A1CBC3DF4748A413346F98A116CAD")
    public  BigDecimal(char[] in, MathContext mc) {
        this(in, 0, in.length);
        addTaint(mc.getTaint());
        addTaint(in[0]);
        inplaceRound(mc);
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.579 -0400", hash_original_method = "97883F5F25D8C2D5B9EC2501AC7ECDA2", hash_generated_method = "F8C02FFBA49B73A7A22E83CA112803F6")
    public  BigDecimal(String val) {
        this(val.toCharArray(), 0, val.length());
        addTaint(val.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.579 -0400", hash_original_method = "65FA78E7CB5F82CDA77BAA4B434CD165", hash_generated_method = "C6CF09061D87965AB685D6E3C6C70502")
    public  BigDecimal(String val, MathContext mc) {
        this(val.toCharArray(), 0, val.length());
        addTaint(mc.getTaint());
        addTaint(val.getTaint());
        inplaceRound(mc);
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.580 -0400", hash_original_method = "A550123107439183BDAF78BFBC33380D", hash_generated_method = "960B8C1763B02EEA6DA41F1F35DA3BD7")
    public  BigDecimal(double val) {
        addTaint(val);
        if(Double.isInfinite(val) || Double.isNaN(val))        
        {
            NumberFormatException var3E59A98DA4169D0690D22CFC24A27713_1099832441 = new NumberFormatException("Infinity or NaN: " + val);
            var3E59A98DA4169D0690D22CFC24A27713_1099832441.addTaint(taint);
            throw var3E59A98DA4169D0690D22CFC24A27713_1099832441;
        } //End block
        long bits = Double.doubleToLongBits(val);
        long mantissa;
        int trailingZeros;
        scale = 1075 - (int)((bits >> 52) & 0x7FFL);
        mantissa = (scale == 1075) ? (bits & 0xFFFFFFFFFFFFFL) << 1
                : (bits & 0xFFFFFFFFFFFFFL) | 0x10000000000000L;
        if(mantissa == 0)        
        {
            scale = 0;
            precision = 1;
        } //End block
        if(scale > 0)        
        {
            trailingZeros = Math.min(scale, Long.numberOfTrailingZeros(mantissa));
            mantissa >>>= trailingZeros;
            scale -= trailingZeros;
        } //End block
        if((bits >> 63) != 0)        
        {
            mantissa = -mantissa;
        } //End block
        int mantissaBits = bitLength(mantissa);
        if(scale < 0)        
        {
            bitLength = mantissaBits == 0 ? 0 : mantissaBits - scale;
            if(bitLength < 64)            
            {
                smallValue = mantissa << (-scale);
            } //End block
            else
            {
                BigInt bi = new BigInt();
                bi.putLongInt(mantissa);
                bi.shift(-scale);
                intVal = new BigInteger(bi);
            } //End block
            scale = 0;
        } //End block
        else
        if(scale > 0)        
        {
            if(scale < LONG_FIVE_POW.length
                    && mantissaBits+LONG_FIVE_POW_BIT_LENGTH[scale] < 64)            
            {
                smallValue = mantissa * LONG_FIVE_POW[scale];
                bitLength = bitLength(smallValue);
            } //End block
            else
            {
                setUnscaledValue(Multiplication.multiplyByFivePow(BigInteger.valueOf(mantissa), scale));
            } //End block
        } //End block
        else
        {
            smallValue = mantissa;
            bitLength = mantissaBits;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.580 -0400", hash_original_method = "A301A521891A68A20E545213C1CF7F7F", hash_generated_method = "795441CAE659A8DAD7CFEBC298E96E6A")
    public  BigDecimal(double val, MathContext mc) {
        this(val);
        addTaint(mc.getTaint());
        addTaint(val);
        inplaceRound(mc);
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.581 -0400", hash_original_method = "35103202AC4D8227390F065BF679C471", hash_generated_method = "D504D0B814354DD64C3D66DE08011646")
    public  BigDecimal(BigInteger val) {
        this(val, 0);
        addTaint(val.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.581 -0400", hash_original_method = "4DD15F45D533F2889A2A72BE2BF675A6", hash_generated_method = "41EA77FB9F894AFE7ED5FEE5B9D530AB")
    public  BigDecimal(BigInteger val, MathContext mc) {
        this(val);
        addTaint(mc.getTaint());
        addTaint(val.getTaint());
        inplaceRound(mc);
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.581 -0400", hash_original_method = "E5BF86952E31D522F2FAABCF30464562", hash_generated_method = "8822DF49605D188B3B5E209E43729793")
    public  BigDecimal(BigInteger unscaledVal, int scale) {
        addTaint(unscaledVal.getTaint());
        if(unscaledVal == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1217592158 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1217592158.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1217592158;
        } //End block
        this.scale = scale;
        setUnscaledValue(unscaledVal);
        // ---------- Original Method ----------
        //if (unscaledVal == null) {
            //throw new NullPointerException();
        //}
        //this.scale = scale;
        //setUnscaledValue(unscaledVal);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.581 -0400", hash_original_method = "59F34EC0A04F061EC6FA9A9EFC322A4C", hash_generated_method = "7A740693F0C00529EF1F7D48CB20A65F")
    public  BigDecimal(BigInteger unscaledVal, int scale, MathContext mc) {
        this(unscaledVal, scale);
        addTaint(mc.getTaint());
        addTaint(scale);
        addTaint(unscaledVal.getTaint());
        inplaceRound(mc);
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.581 -0400", hash_original_method = "5359C9BE484C4A97ECD231D115B1BCDB", hash_generated_method = "D648D7F23799D878CE7DE9DEA41AED6E")
    public  BigDecimal(int val) {
        this(val,0);
        addTaint(val);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.581 -0400", hash_original_method = "919820155B3DF9AD0A8E776AC27BF824", hash_generated_method = "AFC7448519945F4B1F353BEBE5A3926C")
    public  BigDecimal(int val, MathContext mc) {
        this(val,0);
        addTaint(mc.getTaint());
        addTaint(val);
        inplaceRound(mc);
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.581 -0400", hash_original_method = "3B8082CDF108D6321820C9FA6A6A1D42", hash_generated_method = "5CD5A0914C8C99DBF87C1115B74C5DD3")
    public  BigDecimal(long val) {
        this(val,0);
        addTaint(val);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.581 -0400", hash_original_method = "E0851629E0BD0FDB6233816479A7E4A8", hash_generated_method = "E5D91C59CD5A78C99046DC7DF747470E")
    public  BigDecimal(long val, MathContext mc) {
        this(val);
        addTaint(mc.getTaint());
        addTaint(val);
        inplaceRound(mc);
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSModeled(DSC.SAFE)
    public static BigDecimal valueOf(long unscaledVal, int scale) {
        if (scale == 0) {
            return valueOf(unscaledVal);
        }
        if ((unscaledVal == 0) && (scale >= 0)
                && (scale < ZERO_SCALED_BY.length)) {
            return ZERO_SCALED_BY[scale];
        }
        return new BigDecimal(unscaledVal, scale);
    }

    
    @DSModeled(DSC.SAFE)
    public static BigDecimal valueOf(long unscaledVal) {
        if ((unscaledVal >= 0) && (unscaledVal < BI_SCALED_BY_ZERO_LENGTH)) {
            return BI_SCALED_BY_ZERO[(int)unscaledVal];
        }
        return new BigDecimal(unscaledVal,0);
    }

    
    @DSModeled(DSC.SAFE)
    public static BigDecimal valueOf(double val) {
        if (Double.isInfinite(val) || Double.isNaN(val)) {
            throw new NumberFormatException("Infinity or NaN: " + val);
        }
        return new BigDecimal(Double.toString(val));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.582 -0400", hash_original_method = "1DCD141A7D54B6C70CB155CC6BA0AB13", hash_generated_method = "0F2435EDEACB1EA37B6AE09D6767DA53")
    public BigDecimal add(BigDecimal augend) {
        addTaint(augend.getTaint());
        int diffScale = this.scale - augend.scale;
        if(this.isZero())        
        {
            if(diffScale <= 0)            
            {
BigDecimal var408B19472C5B3FCFC50773687B4FC449_209028195 =                 augend;
                var408B19472C5B3FCFC50773687B4FC449_209028195.addTaint(taint);
                return var408B19472C5B3FCFC50773687B4FC449_209028195;
            } //End block
            if(augend.isZero())            
            {
BigDecimal var72A74007B2BE62B849F475C7BDA4658B_1405417936 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_1405417936.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_1405417936;
            } //End block
        } //End block
        else
        if(augend.isZero())        
        {
            if(diffScale >= 0)            
            {
BigDecimal var72A74007B2BE62B849F475C7BDA4658B_936294093 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_936294093.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_936294093;
            } //End block
        } //End block
        if(diffScale == 0)        
        {
            if(Math.max(this.bitLength, augend.bitLength) + 1 < 64)            
            {
BigDecimal varC29A5D28FDF467EA81BC878EFB41BE62_1575155694 =                 valueOf(this.smallValue + augend.smallValue, this.scale);
                varC29A5D28FDF467EA81BC878EFB41BE62_1575155694.addTaint(taint);
                return varC29A5D28FDF467EA81BC878EFB41BE62_1575155694;
            } //End block
BigDecimal var3B6F0CDD20C8378417204A394489CAC7_133528274 =             new BigDecimal(this.getUnscaledValue().add(augend.getUnscaledValue()), this.scale);
            var3B6F0CDD20C8378417204A394489CAC7_133528274.addTaint(taint);
            return var3B6F0CDD20C8378417204A394489CAC7_133528274;
        } //End block
        else
        if(diffScale > 0)        
        {
BigDecimal varAA3782623FE5347A02582E3FC9AEFC56_160039710 =             addAndMult10(this, augend, diffScale);
            varAA3782623FE5347A02582E3FC9AEFC56_160039710.addTaint(taint);
            return varAA3782623FE5347A02582E3FC9AEFC56_160039710;
        } //End block
        else
        {
BigDecimal varAA3EB47E36541685CC2623C1EC32ACA4_897208305 =             addAndMult10(augend, this, -diffScale);
            varAA3EB47E36541685CC2623C1EC32ACA4_897208305.addTaint(taint);
            return varAA3EB47E36541685CC2623C1EC32ACA4_897208305;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    private static BigDecimal addAndMult10(BigDecimal thisValue,BigDecimal augend, int diffScale) {
        if(diffScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                Math.max(thisValue.bitLength,augend.bitLength+LONG_POWERS_OF_TEN_BIT_LENGTH[diffScale])+1<64) {
            return valueOf(thisValue.smallValue+augend.smallValue*MathUtils.LONG_POWERS_OF_TEN[diffScale],thisValue.scale);
        } else {
            BigInt bi = Multiplication.multiplyByTenPow(augend.getUnscaledValue(),diffScale).getBigInt();
            bi.add(thisValue.getUnscaledValue().getBigInt());
            return new BigDecimal(new BigInteger(bi), thisValue.scale);
        }
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.583 -0400", hash_original_method = "37BDD6EE07613654EB8729406017A0AF", hash_generated_method = "1A2FF46A35EB006C07FA4743A5F96561")
    public BigDecimal add(BigDecimal augend, MathContext mc) {
        addTaint(mc.getTaint());
        addTaint(augend.getTaint());
        BigDecimal larger;
        BigDecimal smaller;
        BigInteger tempBI;
        long diffScale = (long)this.scale - augend.scale;
        int largerSignum;
        if((augend.isZero()) || (this.isZero())
                || (mc.getPrecision() == 0))        
        {
BigDecimal var20E40D3A180C61896F40B4FF11E1B4C7_238074363 =             add(augend).round(mc);
            var20E40D3A180C61896F40B4FF11E1B4C7_238074363.addTaint(taint);
            return var20E40D3A180C61896F40B4FF11E1B4C7_238074363;
        } //End block
        if(this.approxPrecision() < diffScale - 1)        
        {
            larger = augend;
            smaller = this;
        } //End block
        else
        if(augend.approxPrecision() < -diffScale - 1)        
        {
            larger = this;
            smaller = augend;
        } //End block
        else
        {
BigDecimal var20E40D3A180C61896F40B4FF11E1B4C7_1807710909 =             add(augend).round(mc);
            var20E40D3A180C61896F40B4FF11E1B4C7_1807710909.addTaint(taint);
            return var20E40D3A180C61896F40B4FF11E1B4C7_1807710909;
        } //End block
        if(mc.getPrecision() >= larger.approxPrecision())        
        {
BigDecimal var20E40D3A180C61896F40B4FF11E1B4C7_1792961135 =             add(augend).round(mc);
            var20E40D3A180C61896F40B4FF11E1B4C7_1792961135.addTaint(taint);
            return var20E40D3A180C61896F40B4FF11E1B4C7_1792961135;
        } //End block
        largerSignum = larger.signum();
        if(largerSignum == smaller.signum())        
        {
            tempBI = Multiplication.multiplyByPositiveInt(larger.getUnscaledValue(),10)
            .add(BigInteger.valueOf(largerSignum));
        } //End block
        else
        {
            tempBI = larger.getUnscaledValue().subtract(
                    BigInteger.valueOf(largerSignum));
            tempBI = Multiplication.multiplyByPositiveInt(tempBI,10)
            .add(BigInteger.valueOf(largerSignum * 9));
        } //End block
        larger = new BigDecimal(tempBI, larger.scale + 1);
BigDecimal var85AAE8429AFD0DC703FB3DD23498E04D_1440324971 =         larger.round(mc);
        var85AAE8429AFD0DC703FB3DD23498E04D_1440324971.addTaint(taint);
        return var85AAE8429AFD0DC703FB3DD23498E04D_1440324971;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.583 -0400", hash_original_method = "463B27AE9A4331C20782D4CCC2226F12", hash_generated_method = "2F354B6143BDE4779CF80649030A8D1B")
    public BigDecimal subtract(BigDecimal subtrahend) {
        addTaint(subtrahend.getTaint());
        int diffScale = this.scale - subtrahend.scale;
        if(this.isZero())        
        {
            if(diffScale <= 0)            
            {
BigDecimal var20CB7E4994F478F2FA990ABC4FC7E9E2_309195430 =                 subtrahend.negate();
                var20CB7E4994F478F2FA990ABC4FC7E9E2_309195430.addTaint(taint);
                return var20CB7E4994F478F2FA990ABC4FC7E9E2_309195430;
            } //End block
            if(subtrahend.isZero())            
            {
BigDecimal var72A74007B2BE62B849F475C7BDA4658B_242787114 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_242787114.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_242787114;
            } //End block
        } //End block
        else
        if(subtrahend.isZero())        
        {
            if(diffScale >= 0)            
            {
BigDecimal var72A74007B2BE62B849F475C7BDA4658B_1334714473 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_1334714473.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_1334714473;
            } //End block
        } //End block
        if(diffScale == 0)        
        {
            if(Math.max(this.bitLength, subtrahend.bitLength) + 1 < 64)            
            {
BigDecimal var4205EF116A00E778C0B3349717F48B49_984636499 =                 valueOf(this.smallValue - subtrahend.smallValue,this.scale);
                var4205EF116A00E778C0B3349717F48B49_984636499.addTaint(taint);
                return var4205EF116A00E778C0B3349717F48B49_984636499;
            } //End block
BigDecimal var790A17466751017D9F7E25BBDC99AFE3_1953692802 =             new BigDecimal(this.getUnscaledValue().subtract(subtrahend.getUnscaledValue()), this.scale);
            var790A17466751017D9F7E25BBDC99AFE3_1953692802.addTaint(taint);
            return var790A17466751017D9F7E25BBDC99AFE3_1953692802;
        } //End block
        else
        if(diffScale > 0)        
        {
            if(diffScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                    Math.max(this.bitLength,subtrahend.bitLength+LONG_POWERS_OF_TEN_BIT_LENGTH[diffScale])+1<64)            
            {
BigDecimal var7C3E910EA26DCC86661FD9754DC625C0_1401466445 =                 valueOf(this.smallValue-subtrahend.smallValue*MathUtils.LONG_POWERS_OF_TEN[diffScale],this.scale);
                var7C3E910EA26DCC86661FD9754DC625C0_1401466445.addTaint(taint);
                return var7C3E910EA26DCC86661FD9754DC625C0_1401466445;
            } //End block
BigDecimal var15D9019C49E0B547E9298CE56667BC02_1660293161 =             new BigDecimal(this.getUnscaledValue().subtract(
                    Multiplication.multiplyByTenPow(subtrahend.getUnscaledValue(),diffScale)), this.scale);
            var15D9019C49E0B547E9298CE56667BC02_1660293161.addTaint(taint);
            return var15D9019C49E0B547E9298CE56667BC02_1660293161;
        } //End block
        else
        {
            diffScale = -diffScale;
            if(diffScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                    Math.max(this.bitLength+LONG_POWERS_OF_TEN_BIT_LENGTH[diffScale],subtrahend.bitLength)+1<64)            
            {
BigDecimal varDC58FD3A05E933CD46CF8827177D6A0D_2042212753 =                 valueOf(this.smallValue*MathUtils.LONG_POWERS_OF_TEN[diffScale]-subtrahend.smallValue,subtrahend.scale);
                varDC58FD3A05E933CD46CF8827177D6A0D_2042212753.addTaint(taint);
                return varDC58FD3A05E933CD46CF8827177D6A0D_2042212753;
            } //End block
BigDecimal var0357B328C12B82C4DC6697F3D0056D8B_460495526 =             new BigDecimal(Multiplication.multiplyByTenPow(this.getUnscaledValue(),diffScale)
            .subtract(subtrahend.getUnscaledValue()), subtrahend.scale);
            var0357B328C12B82C4DC6697F3D0056D8B_460495526.addTaint(taint);
            return var0357B328C12B82C4DC6697F3D0056D8B_460495526;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.584 -0400", hash_original_method = "427D658D2E18BC359A41906DA92107B2", hash_generated_method = "675169CC8A87475A7B34AA93680ADFF5")
    public BigDecimal subtract(BigDecimal subtrahend, MathContext mc) {
        addTaint(mc.getTaint());
        addTaint(subtrahend.getTaint());
        long diffScale = subtrahend.scale - (long)this.scale;
        int thisSignum;
        BigDecimal leftOperand;
        BigInteger tempBI;
        if((subtrahend.isZero()) || (this.isZero())
                || (mc.getPrecision() == 0))        
        {
BigDecimal var4481336689B89E473DC6E06151513A25_702349898 =             subtract(subtrahend).round(mc);
            var4481336689B89E473DC6E06151513A25_702349898.addTaint(taint);
            return var4481336689B89E473DC6E06151513A25_702349898;
        } //End block
        if(subtrahend.approxPrecision() < diffScale - 1)        
        {
            if(mc.getPrecision() < this.approxPrecision())            
            {
                thisSignum = this.signum();
                if(thisSignum != subtrahend.signum())                
                {
                    tempBI = Multiplication.multiplyByPositiveInt(this.getUnscaledValue(), 10)
                    .add(BigInteger.valueOf(thisSignum));
                } //End block
                else
                {
                    tempBI = this.getUnscaledValue().subtract(BigInteger.valueOf(thisSignum));
                    tempBI = Multiplication.multiplyByPositiveInt(tempBI, 10)
                    .add(BigInteger.valueOf(thisSignum * 9));
                } //End block
                leftOperand = new BigDecimal(tempBI, this.scale + 1);
BigDecimal var9E01B144E29749864BF254E9E9C2A256_675154642 =                 leftOperand.round(mc);
                var9E01B144E29749864BF254E9E9C2A256_675154642.addTaint(taint);
                return var9E01B144E29749864BF254E9E9C2A256_675154642;
            } //End block
        } //End block
BigDecimal var4481336689B89E473DC6E06151513A25_54573347 =         subtract(subtrahend).round(mc);
        var4481336689B89E473DC6E06151513A25_54573347.addTaint(taint);
        return var4481336689B89E473DC6E06151513A25_54573347;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.584 -0400", hash_original_method = "0CD1948BD2366020AE6A84C7902D73D6", hash_generated_method = "1BF1F4A41BB8F80E06B8114DB5DD7C45")
    public BigDecimal multiply(BigDecimal multiplicand) {
        addTaint(multiplicand.getTaint());
        long newScale = (long)this.scale + multiplicand.scale;
        if((this.isZero()) || (multiplicand.isZero()))        
        {
BigDecimal varE59C58B2F93F3B07BADE839AC0BAC55B_399932696 =             zeroScaledBy(newScale);
            varE59C58B2F93F3B07BADE839AC0BAC55B_399932696.addTaint(taint);
            return varE59C58B2F93F3B07BADE839AC0BAC55B_399932696;
        } //End block
        if(this.bitLength + multiplicand.bitLength < 64)        
        {
BigDecimal var737034098D95ED0FC63A7DF773CD73FD_1410024134 =             valueOf(this.smallValue*multiplicand.smallValue, safeLongToInt(newScale));
            var737034098D95ED0FC63A7DF773CD73FD_1410024134.addTaint(taint);
            return var737034098D95ED0FC63A7DF773CD73FD_1410024134;
        } //End block
BigDecimal var3F964FE42BAEC76AB0D169D386269642_99433365 =         new BigDecimal(this.getUnscaledValue().multiply(
                multiplicand.getUnscaledValue()), safeLongToInt(newScale));
        var3F964FE42BAEC76AB0D169D386269642_99433365.addTaint(taint);
        return var3F964FE42BAEC76AB0D169D386269642_99433365;
        // ---------- Original Method ----------
        //long newScale = (long)this.scale + multiplicand.scale;
        //if ((this.isZero()) || (multiplicand.isZero())) {
            //return zeroScaledBy(newScale);
        //}
        //if(this.bitLength + multiplicand.bitLength < 64) {
            //return valueOf(this.smallValue*multiplicand.smallValue, safeLongToInt(newScale));
        //}
        //return new BigDecimal(this.getUnscaledValue().multiply(
                //multiplicand.getUnscaledValue()), safeLongToInt(newScale));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.584 -0400", hash_original_method = "C6525DC236CD6C9B7DA82BBF840C4183", hash_generated_method = "6EAF44FF188A833707E00FB7644B97A7")
    public BigDecimal multiply(BigDecimal multiplicand, MathContext mc) {
        addTaint(mc.getTaint());
        addTaint(multiplicand.getTaint());
        BigDecimal result = multiply(multiplicand);
        result.inplaceRound(mc);
BigDecimal varDC838461EE2FA0CA4C9BBB70A15456B0_1042594239 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1042594239.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1042594239;
        // ---------- Original Method ----------
        //BigDecimal result = multiply(multiplicand);
        //result.inplaceRound(mc);
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.584 -0400", hash_original_method = "462A8C7DE00EC7C78FAA3F28B925453C", hash_generated_method = "7FA8ABD217C958D26787FF668D8460FD")
    public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode) {
        addTaint(roundingMode);
        addTaint(scale);
        addTaint(divisor.getTaint());
BigDecimal varBA9719B24DF54089903C79918220E383_1125825875 =         divide(divisor, scale, RoundingMode.valueOf(roundingMode));
        varBA9719B24DF54089903C79918220E383_1125825875.addTaint(taint);
        return varBA9719B24DF54089903C79918220E383_1125825875;
        // ---------- Original Method ----------
        //return divide(divisor, scale, RoundingMode.valueOf(roundingMode));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.585 -0400", hash_original_method = "CAF40474AE4670E1A6482892323F28CB", hash_generated_method = "AF09C7AA18CF4E5405FFE9EBDB5817B6")
    public BigDecimal divide(BigDecimal divisor, int scale, RoundingMode roundingMode) {
        addTaint(roundingMode.getTaint());
        addTaint(scale);
        addTaint(divisor.getTaint());
        if(roundingMode == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_641386658 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_641386658.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_641386658;
        } //End block
        if(divisor.isZero())        
        {
            ArithmeticException var8232FF584263005EDE3503FB2494EECC_805196376 = new ArithmeticException("Division by zero");
            var8232FF584263005EDE3503FB2494EECC_805196376.addTaint(taint);
            throw var8232FF584263005EDE3503FB2494EECC_805196376;
        } //End block
        long diffScale = ((long)this.scale - divisor.scale) - scale;
        if(this.bitLength < 64 && divisor.bitLength < 64)        
        {
            if(diffScale == 0)            
            {
BigDecimal varA1F4C614F572240C11899F668DB0D55E_307311545 =                 dividePrimitiveLongs(this.smallValue,
                        divisor.smallValue,
                        scale,
                        roundingMode );
                varA1F4C614F572240C11899F668DB0D55E_307311545.addTaint(taint);
                return varA1F4C614F572240C11899F668DB0D55E_307311545;
            } //End block
            else
            if(diffScale > 0)            
            {
                if(diffScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                        divisor.bitLength + LONG_POWERS_OF_TEN_BIT_LENGTH[(int)diffScale] < 64)                
                {
BigDecimal varAC9EC2469B7198582C29A1B0D39CDA9C_1193707864 =                     dividePrimitiveLongs(this.smallValue,
                            divisor.smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)diffScale],
                            scale,
                            roundingMode);
                    varAC9EC2469B7198582C29A1B0D39CDA9C_1193707864.addTaint(taint);
                    return varAC9EC2469B7198582C29A1B0D39CDA9C_1193707864;
                } //End block
            } //End block
            else
            {
                if(-diffScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                        this.bitLength + LONG_POWERS_OF_TEN_BIT_LENGTH[(int)-diffScale] < 64)                
                {
BigDecimal varCE8CA12CD95E2FB8CD14FD3D265A5A0A_838909974 =                     dividePrimitiveLongs(this.smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)-diffScale],
                            divisor.smallValue,
                            scale,
                            roundingMode);
                    varCE8CA12CD95E2FB8CD14FD3D265A5A0A_838909974.addTaint(taint);
                    return varCE8CA12CD95E2FB8CD14FD3D265A5A0A_838909974;
                } //End block
            } //End block
        } //End block
        BigInteger scaledDividend = this.getUnscaledValue();
        BigInteger scaledDivisor = divisor.getUnscaledValue();
        if(diffScale > 0)        
        {
            scaledDivisor = Multiplication.multiplyByTenPow(scaledDivisor, (int)diffScale);
        } //End block
        else
        if(diffScale < 0)        
        {
            scaledDividend  = Multiplication.multiplyByTenPow(scaledDividend, (int)-diffScale);
        } //End block
BigDecimal varF6C63A795D53A996135BB70BCA9E6E0B_1513396922 =         divideBigIntegers(scaledDividend, scaledDivisor, scale, roundingMode);
        varF6C63A795D53A996135BB70BCA9E6E0B_1513396922.addTaint(taint);
        return varF6C63A795D53A996135BB70BCA9E6E0B_1513396922;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    private static BigDecimal divideBigIntegers(BigInteger scaledDividend, BigInteger scaledDivisor, int scale, RoundingMode roundingMode) {
        BigInteger[] quotAndRem = scaledDividend.divideAndRemainder(scaledDivisor);
        BigInteger quotient = quotAndRem[0];
        BigInteger remainder = quotAndRem[1];
        if (remainder.signum() == 0) {
            return new BigDecimal(quotient, scale);
        }
        int sign = scaledDividend.signum() * scaledDivisor.signum();
        int compRem;
        if(scaledDivisor.bitLength() < 63) { 
            long rem = remainder.longValue();
            long divisor = scaledDivisor.longValue();
            compRem = longCompareTo(Math.abs(rem) * 2,Math.abs(divisor));
            compRem = roundingBehavior(quotient.testBit(0) ? 1 : 0,
                    sign * (5 + compRem), roundingMode);
        } else {
            compRem = remainder.abs().shiftLeftOneBit().compareTo(scaledDivisor.abs());
            compRem = roundingBehavior(quotient.testBit(0) ? 1 : 0,
                    sign * (5 + compRem), roundingMode);
        }
        if (compRem != 0) {
            if(quotient.bitLength() < 63) {
                return valueOf(quotient.longValue() + compRem,scale);
            }
            quotient = quotient.add(BigInteger.valueOf(compRem));
            return new BigDecimal(quotient, scale);
        }
        return new BigDecimal(quotient, scale);
    }

    
    @DSModeled(DSC.SAFE)
    private static BigDecimal dividePrimitiveLongs(long scaledDividend, long scaledDivisor, int scale, RoundingMode roundingMode) {
        long quotient = scaledDividend / scaledDivisor;
        long remainder = scaledDividend % scaledDivisor;
        int sign = Long.signum( scaledDividend ) * Long.signum( scaledDivisor );
        if (remainder != 0) {
            int compRem;                                      
            compRem = longCompareTo(Math.abs(remainder) * 2,Math.abs(scaledDivisor));
            quotient += roundingBehavior(((int)quotient) & 1,
                    sign * (5 + compRem),
                    roundingMode);
        }
        return valueOf(quotient, scale);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.585 -0400", hash_original_method = "2C6660A6ECCA62927D6A6B71E8D4804F", hash_generated_method = "8CBC19CB2D6A7B4B4098B9EEBEBA63B8")
    public BigDecimal divide(BigDecimal divisor, int roundingMode) {
        addTaint(roundingMode);
        addTaint(divisor.getTaint());
BigDecimal varBA9719B24DF54089903C79918220E383_110996257 =         divide(divisor, scale, RoundingMode.valueOf(roundingMode));
        varBA9719B24DF54089903C79918220E383_110996257.addTaint(taint);
        return varBA9719B24DF54089903C79918220E383_110996257;
        // ---------- Original Method ----------
        //return divide(divisor, scale, RoundingMode.valueOf(roundingMode));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.586 -0400", hash_original_method = "5F1D784ACEFAF8C3A3D46632D71C7A92", hash_generated_method = "84F7C0CEE7DD18F62B6DFCFA599433A4")
    public BigDecimal divide(BigDecimal divisor, RoundingMode roundingMode) {
        addTaint(roundingMode.getTaint());
        addTaint(divisor.getTaint());
BigDecimal varD4989E9F927A2A4FAB7F073D2585164F_131054491 =         divide(divisor, scale, roundingMode);
        varD4989E9F927A2A4FAB7F073D2585164F_131054491.addTaint(taint);
        return varD4989E9F927A2A4FAB7F073D2585164F_131054491;
        // ---------- Original Method ----------
        //return divide(divisor, scale, roundingMode);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.586 -0400", hash_original_method = "A7E2E0DD5FAFAFB93C0707787850F19F", hash_generated_method = "A64BF58865AEE6BE9D4018DC620C485A")
    public BigDecimal divide(BigDecimal divisor) {
        addTaint(divisor.getTaint());
        BigInteger p = this.getUnscaledValue();
        BigInteger q = divisor.getUnscaledValue();
        BigInteger gcd;
        BigInteger quotAndRem[];
        long diffScale = (long)scale - divisor.scale;
        int newScale;
        int k;
        int l = 0;
        int i = 1;
        int lastPow = FIVE_POW.length - 1;
        if(divisor.isZero())        
        {
            ArithmeticException var8232FF584263005EDE3503FB2494EECC_613058744 = new ArithmeticException("Division by zero");
            var8232FF584263005EDE3503FB2494EECC_613058744.addTaint(taint);
            throw var8232FF584263005EDE3503FB2494EECC_613058744;
        } //End block
        if(p.signum() == 0)        
        {
BigDecimal var277AAF866E1EF31575126210EC839CAB_803158726 =             zeroScaledBy(diffScale);
            var277AAF866E1EF31575126210EC839CAB_803158726.addTaint(taint);
            return var277AAF866E1EF31575126210EC839CAB_803158726;
        } //End block
        gcd = p.gcd(q);
        p = p.divide(gcd);
        q = q.divide(gcd);
        k = q.getLowestSetBit();
        q = q.shiftRight(k);
        do {
            {
                quotAndRem = q.divideAndRemainder(FIVE_POW[i]);
                if(quotAndRem[1].signum() == 0)                
                {
                    l += i;
                    if(i < lastPow)                    
                    {
                        i++;
                    } //End block
                    q = quotAndRem[0];
                } //End block
                else
                {
                    if(i == 1)                    
                    {
                        break;
                    } //End block
                    i = 1;
                } //End block
            } //End block
} while (true);
        if(!q.abs().equals(BigInteger.ONE))        
        {
            ArithmeticException var5490C747F55608EDD43F4C0EE6D94910_2043961320 = new ArithmeticException("Non-terminating decimal expansion; no exact representable decimal result");
            var5490C747F55608EDD43F4C0EE6D94910_2043961320.addTaint(taint);
            throw var5490C747F55608EDD43F4C0EE6D94910_2043961320;
        } //End block
        if(q.signum() < 0)        
        {
            p = p.negate();
        } //End block
        newScale = safeLongToInt(diffScale + Math.max(k, l));
        i = k - l;
        p = (i > 0) ? Multiplication.multiplyByFivePow(p, i)
        : p.shiftLeft(-i);
BigDecimal varD0644BCFD931415D27D5B4154667FE6D_275374126 =         new BigDecimal(p, newScale);
        varD0644BCFD931415D27D5B4154667FE6D_275374126.addTaint(taint);
        return varD0644BCFD931415D27D5B4154667FE6D_275374126;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.587 -0400", hash_original_method = "E69AD17C16131904FF2F859BB6B8C3E0", hash_generated_method = "891752F6CE2B20DB2E4B616CF138CB0B")
    public BigDecimal divide(BigDecimal divisor, MathContext mc) {
        addTaint(mc.getTaint());
        addTaint(divisor.getTaint());
        long trailingZeros = mc.getPrecision() + 2L
                + divisor.approxPrecision() - approxPrecision();
        long diffScale = (long)scale - divisor.scale;
        long newScale = diffScale;
        int compRem;
        int i = 1;
        int lastPow = TEN_POW.length - 1;
        BigInteger integerQuot;
        BigInteger quotAndRem[] = {getUnscaledValue()};
        if((mc.getPrecision() == 0) || (this.isZero())
        || (divisor.isZero()))        
        {
BigDecimal varBA3F941531BC5E6E1960376988ED770D_346576032 =             this.divide(divisor);
            varBA3F941531BC5E6E1960376988ED770D_346576032.addTaint(taint);
            return varBA3F941531BC5E6E1960376988ED770D_346576032;
        } //End block
        if(trailingZeros > 0)        
        {
            quotAndRem[0] = getUnscaledValue().multiply( Multiplication.powerOf10(trailingZeros) );
            newScale += trailingZeros;
        } //End block
        quotAndRem = quotAndRem[0].divideAndRemainder( divisor.getUnscaledValue() );
        integerQuot = quotAndRem[0];
        if(quotAndRem[1].signum() != 0)        
        {
            compRem = quotAndRem[1].shiftLeftOneBit().compareTo( divisor.getUnscaledValue() );
            integerQuot = integerQuot.multiply(BigInteger.TEN)
            .add(BigInteger.valueOf(quotAndRem[0].signum() * (5 + compRem)));
            newScale++;
        } //End block
        else
        {
            while
(!integerQuot.testBit(0))            
            {
                quotAndRem = integerQuot.divideAndRemainder(TEN_POW[i]);
                if((quotAndRem[1].signum() == 0)
                        && (newScale - i >= diffScale))                
                {
                    newScale -= i;
                    if(i < lastPow)                    
                    {
                        i++;
                    } //End block
                    integerQuot = quotAndRem[0];
                } //End block
                else
                {
                    if(i == 1)                    
                    {
                        break;
                    } //End block
                    i = 1;
                } //End block
            } //End block
        } //End block
BigDecimal var3AC7C1B712651F6BEB20B4A533A61659_532984139 =         new BigDecimal(integerQuot, safeLongToInt(newScale), mc);
        var3AC7C1B712651F6BEB20B4A533A61659_532984139.addTaint(taint);
        return var3AC7C1B712651F6BEB20B4A533A61659_532984139;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.588 -0400", hash_original_method = "370FC7E5A1C86319865302EB832BE460", hash_generated_method = "5558EAB9F197E3823C777F0354A567A3")
    public BigDecimal divideToIntegralValue(BigDecimal divisor) {
        addTaint(divisor.getTaint());
        BigInteger integralValue;
        BigInteger powerOfTen;
        BigInteger quotAndRem[] = {getUnscaledValue()};
        long newScale = (long)this.scale - divisor.scale;
        long tempScale = 0;
        int i = 1;
        int lastPow = TEN_POW.length - 1;
        if(divisor.isZero())        
        {
            ArithmeticException var8232FF584263005EDE3503FB2494EECC_1799379501 = new ArithmeticException("Division by zero");
            var8232FF584263005EDE3503FB2494EECC_1799379501.addTaint(taint);
            throw var8232FF584263005EDE3503FB2494EECC_1799379501;
        } //End block
        if((divisor.approxPrecision() + newScale > this.approxPrecision() + 1L)
        || (this.isZero()))        
        {
            integralValue = BigInteger.ZERO;
        } //End block
        else
        if(newScale == 0)        
        {
            integralValue = getUnscaledValue().divide( divisor.getUnscaledValue() );
        } //End block
        else
        if(newScale > 0)        
        {
            powerOfTen = Multiplication.powerOf10(newScale);
            integralValue = getUnscaledValue().divide( divisor.getUnscaledValue().multiply(powerOfTen) );
            integralValue = integralValue.multiply(powerOfTen);
        } //End block
        else
        {
            powerOfTen = Multiplication.powerOf10(-newScale);
            integralValue = getUnscaledValue().multiply(powerOfTen).divide( divisor.getUnscaledValue() );
            while
(!integralValue.testBit(0))            
            {
                quotAndRem = integralValue.divideAndRemainder(TEN_POW[i]);
                if((quotAndRem[1].signum() == 0)
                        && (tempScale - i >= newScale))                
                {
                    tempScale -= i;
                    if(i < lastPow)                    
                    {
                        i++;
                    } //End block
                    integralValue = quotAndRem[0];
                } //End block
                else
                {
                    if(i == 1)                    
                    {
                        break;
                    } //End block
                    i = 1;
                } //End block
            } //End block
            newScale = tempScale;
        } //End block
BigDecimal var8CD0EAEFCB484EE00D372EAE56C5A002_2077479168 =         ((integralValue.signum() == 0)
        ? zeroScaledBy(newScale)
                : new BigDecimal(integralValue, safeLongToInt(newScale)));
        var8CD0EAEFCB484EE00D372EAE56C5A002_2077479168.addTaint(taint);
        return var8CD0EAEFCB484EE00D372EAE56C5A002_2077479168;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.593 -0400", hash_original_method = "15ECC758BA9BF5EB2D64CC984DE4A4C9", hash_generated_method = "40EFA69A42F0D952A66006A84C5A1BF1")
    public BigDecimal divideToIntegralValue(BigDecimal divisor, MathContext mc) {
        addTaint(mc.getTaint());
        addTaint(divisor.getTaint());
        int mcPrecision = mc.getPrecision();
        int diffPrecision = this.precision() - divisor.precision();
        int lastPow = TEN_POW.length - 1;
        long diffScale = (long)this.scale - divisor.scale;
        long newScale = diffScale;
        long quotPrecision = diffPrecision - diffScale + 1;
        BigInteger quotAndRem[] = new BigInteger[2];
        if((mcPrecision == 0) || (this.isZero()) || (divisor.isZero()))        
        {
BigDecimal varF90F04B070151E626D75F40D8923223D_1421825109 =             this.divideToIntegralValue(divisor);
            varF90F04B070151E626D75F40D8923223D_1421825109.addTaint(taint);
            return varF90F04B070151E626D75F40D8923223D_1421825109;
        } //End block
        if(quotPrecision <= 0)        
        {
            quotAndRem[0] = BigInteger.ZERO;
        } //End block
        else
        if(diffScale == 0)        
        {
            quotAndRem[0] = this.getUnscaledValue().divide( divisor.getUnscaledValue() );
        } //End block
        else
        if(diffScale > 0)        
        {
            quotAndRem[0] = this.getUnscaledValue().divide(
                    divisor.getUnscaledValue().multiply(Multiplication.powerOf10(diffScale)) );
            newScale = Math.min(diffScale, Math.max(mcPrecision - quotPrecision + 1, 0));
            quotAndRem[0] = quotAndRem[0].multiply(Multiplication.powerOf10(newScale));
        } //End block
        else
        {
            long exp = Math.min(-diffScale, Math.max((long)mcPrecision - diffPrecision, 0));
            long compRemDiv;
            quotAndRem = this.getUnscaledValue().multiply(Multiplication.powerOf10(exp)).
                    divideAndRemainder(divisor.getUnscaledValue());
            newScale += exp;
            exp = -newScale;
            if((quotAndRem[1].signum() != 0) && (exp > 0))            
            {
                compRemDiv = (new BigDecimal(quotAndRem[1])).precision()
                + exp - divisor.precision();
                if(compRemDiv == 0)                
                {
                    quotAndRem[1] = quotAndRem[1].multiply(Multiplication.powerOf10(exp)).
                            divide(divisor.getUnscaledValue());
                    compRemDiv = Math.abs(quotAndRem[1].signum());
                } //End block
                if(compRemDiv > 0)                
                {
                    ArithmeticException var53FA20AA5783266B1EC065CD5B879CF0_1645537130 = new ArithmeticException("Division impossible");
                    var53FA20AA5783266B1EC065CD5B879CF0_1645537130.addTaint(taint);
                    throw var53FA20AA5783266B1EC065CD5B879CF0_1645537130;
                } //End block
            } //End block
        } //End block
        if(quotAndRem[0].signum() == 0)        
        {
BigDecimal var277AAF866E1EF31575126210EC839CAB_1411830818 =             zeroScaledBy(diffScale);
            var277AAF866E1EF31575126210EC839CAB_1411830818.addTaint(taint);
            return var277AAF866E1EF31575126210EC839CAB_1411830818;
        } //End block
        BigInteger strippedBI = quotAndRem[0];
        BigDecimal integralValue = new BigDecimal(quotAndRem[0]);
        long resultPrecision = integralValue.precision();
        int i = 1;
        while
(!strippedBI.testBit(0))        
        {
            quotAndRem = strippedBI.divideAndRemainder(TEN_POW[i]);
            if((quotAndRem[1].signum() == 0) &&
                    ((resultPrecision - i >= mcPrecision)
                    || (newScale - i >= diffScale)))            
            {
                resultPrecision -= i;
                newScale -= i;
                if(i < lastPow)                
                {
                    i++;
                } //End block
                strippedBI = quotAndRem[0];
            } //End block
            else
            {
                if(i == 1)                
                {
                    break;
                } //End block
                i = 1;
            } //End block
        } //End block
        if(resultPrecision > mcPrecision)        
        {
            ArithmeticException var53FA20AA5783266B1EC065CD5B879CF0_467509183 = new ArithmeticException("Division impossible");
            var53FA20AA5783266B1EC065CD5B879CF0_467509183.addTaint(taint);
            throw var53FA20AA5783266B1EC065CD5B879CF0_467509183;
        } //End block
        integralValue.scale = safeLongToInt(newScale);
        integralValue.setUnscaledValue(strippedBI);
BigDecimal var6A7B4288ADCD69BF11ABA916220598AF_1799266045 =         integralValue;
        var6A7B4288ADCD69BF11ABA916220598AF_1799266045.addTaint(taint);
        return var6A7B4288ADCD69BF11ABA916220598AF_1799266045;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.594 -0400", hash_original_method = "EBDBD1FB251B2EF1CF76CA97862E098F", hash_generated_method = "682F0665F75078D0A02E5B761829D14D")
    public BigDecimal remainder(BigDecimal divisor) {
        addTaint(divisor.getTaint());
BigDecimal var8CBD704006853C12B2C3587D77D455B0_851615057 =         divideAndRemainder(divisor)[1];
        var8CBD704006853C12B2C3587D77D455B0_851615057.addTaint(taint);
        return var8CBD704006853C12B2C3587D77D455B0_851615057;
        // ---------- Original Method ----------
        //return divideAndRemainder(divisor)[1];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.594 -0400", hash_original_method = "B5D8082AFBB8A8B7919238963079BE8E", hash_generated_method = "5A819EE2A4C8EC7D5E9CC9D02FB31398")
    public BigDecimal remainder(BigDecimal divisor, MathContext mc) {
        addTaint(mc.getTaint());
        addTaint(divisor.getTaint());
BigDecimal var255C2A159BF47AFDB531DC1FDA4FBDE3_742365124 =         divideAndRemainder(divisor, mc)[1];
        var255C2A159BF47AFDB531DC1FDA4FBDE3_742365124.addTaint(taint);
        return var255C2A159BF47AFDB531DC1FDA4FBDE3_742365124;
        // ---------- Original Method ----------
        //return divideAndRemainder(divisor, mc)[1];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.595 -0400", hash_original_method = "078854E5024F03E2C96ABDC15A98EC28", hash_generated_method = "0BD2BC3939130DFA05EB06966855084F")
    public BigDecimal[] divideAndRemainder(BigDecimal divisor) {
        addTaint(divisor.getTaint());
        BigDecimal quotAndRem[] = new BigDecimal[2];
        quotAndRem[0] = this.divideToIntegralValue(divisor);
        quotAndRem[1] = this.subtract( quotAndRem[0].multiply(divisor) );
BigDecimal[] var06CBC57291B9EBBB56A44DD63D3B6686_1874032368 =         quotAndRem;
        var06CBC57291B9EBBB56A44DD63D3B6686_1874032368.addTaint(taint);
        return var06CBC57291B9EBBB56A44DD63D3B6686_1874032368;
        // ---------- Original Method ----------
        //BigDecimal quotAndRem[] = new BigDecimal[2];
        //quotAndRem[0] = this.divideToIntegralValue(divisor);
        //quotAndRem[1] = this.subtract( quotAndRem[0].multiply(divisor) );
        //return quotAndRem;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.595 -0400", hash_original_method = "36D2BD3305B7DD5EA1226F88EE4D6B60", hash_generated_method = "A4DEBD17301BDF7C8295E7B35601E174")
    public BigDecimal[] divideAndRemainder(BigDecimal divisor, MathContext mc) {
        addTaint(mc.getTaint());
        addTaint(divisor.getTaint());
        BigDecimal quotAndRem[] = new BigDecimal[2];
        quotAndRem[0] = this.divideToIntegralValue(divisor, mc);
        quotAndRem[1] = this.subtract( quotAndRem[0].multiply(divisor) );
BigDecimal[] var06CBC57291B9EBBB56A44DD63D3B6686_849403900 =         quotAndRem;
        var06CBC57291B9EBBB56A44DD63D3B6686_849403900.addTaint(taint);
        return var06CBC57291B9EBBB56A44DD63D3B6686_849403900;
        // ---------- Original Method ----------
        //BigDecimal quotAndRem[] = new BigDecimal[2];
        //quotAndRem[0] = this.divideToIntegralValue(divisor, mc);
        //quotAndRem[1] = this.subtract( quotAndRem[0].multiply(divisor) );
        //return quotAndRem;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.596 -0400", hash_original_method = "0BA2A5CD46D450D69AC19365E08D7C5C", hash_generated_method = "D62CE55F727CE60530DE8B84166C3360")
    public BigDecimal pow(int n) {
        addTaint(n);
        if(n == 0)        
        {
BigDecimal varBAE09D6A693103980CCD98582008583B_760616799 =             ONE;
            varBAE09D6A693103980CCD98582008583B_760616799.addTaint(taint);
            return varBAE09D6A693103980CCD98582008583B_760616799;
        } //End block
        if((n < 0) || (n > 999999999))        
        {
            ArithmeticException var0D4D59570E4E5191698B488830D15716_1059034629 = new ArithmeticException("Invalid operation");
            var0D4D59570E4E5191698B488830D15716_1059034629.addTaint(taint);
            throw var0D4D59570E4E5191698B488830D15716_1059034629;
        } //End block
        long newScale = scale * (long)n;
BigDecimal var2CE28CE1CD1304A24D1EA5E44DCD3B2E_578692245 =         isZero() ? zeroScaledBy(newScale)
                : new BigDecimal(getUnscaledValue().pow(n), safeLongToInt(newScale));
        var2CE28CE1CD1304A24D1EA5E44DCD3B2E_578692245.addTaint(taint);
        return var2CE28CE1CD1304A24D1EA5E44DCD3B2E_578692245;
        // ---------- Original Method ----------
        //if (n == 0) {
            //return ONE;
        //}
        //if ((n < 0) || (n > 999999999)) {
            //throw new ArithmeticException("Invalid operation");
        //}
        //long newScale = scale * (long)n;
        //return isZero() ? zeroScaledBy(newScale)
                //: new BigDecimal(getUnscaledValue().pow(n), safeLongToInt(newScale));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.596 -0400", hash_original_method = "C8938AEDE89231C5AAB8CE41C7A1DE59", hash_generated_method = "E4765319A791CA4E3450A533151E1A58")
    public BigDecimal pow(int n, MathContext mc) {
        addTaint(mc.getTaint());
        addTaint(n);
        int m = Math.abs(n);
        int mcPrecision = mc.getPrecision();
        int elength = (int)Math.log10(m) + 1;
        int oneBitMask;
        BigDecimal accum;
        MathContext newPrecision = mc;
        if((n == 0) || ((isZero()) && (n > 0)))        
        {
BigDecimal var8CBFE70F915191D2B08C03E09264D484_506301997 =             pow(n);
            var8CBFE70F915191D2B08C03E09264D484_506301997.addTaint(taint);
            return var8CBFE70F915191D2B08C03E09264D484_506301997;
        } //End block
        if((m > 999999999) || ((mcPrecision == 0) && (n < 0))
                || ((mcPrecision > 0) && (elength > mcPrecision)))        
        {
            ArithmeticException var0D4D59570E4E5191698B488830D15716_344441096 = new ArithmeticException("Invalid operation");
            var0D4D59570E4E5191698B488830D15716_344441096.addTaint(taint);
            throw var0D4D59570E4E5191698B488830D15716_344441096;
        } //End block
        if(mcPrecision > 0)        
        {
            newPrecision = new MathContext( mcPrecision + elength + 1,
                    mc.getRoundingMode());
        } //End block
        accum = round(newPrecision);
        oneBitMask = Integer.highestOneBit(m) >> 1;
        while
(oneBitMask > 0)        
        {
            accum = accum.multiply(accum, newPrecision);
            if((m & oneBitMask) == oneBitMask)            
            {
                accum = accum.multiply(this, newPrecision);
            } //End block
            oneBitMask >>= 1;
        } //End block
        if(n < 0)        
        {
            accum = ONE.divide(accum, newPrecision);
        } //End block
        accum.inplaceRound(mc);
BigDecimal var3E2E0393E92029AC9F8EC9F2D778D7A4_887673966 =         accum;
        var3E2E0393E92029AC9F8EC9F2D778D7A4_887673966.addTaint(taint);
        return var3E2E0393E92029AC9F8EC9F2D778D7A4_887673966;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.596 -0400", hash_original_method = "DF1CB3D65F2CAE136A2978BF9C5604B4", hash_generated_method = "1DBFE3F70AC3176E969E73F867912F59")
    public BigDecimal abs() {
BigDecimal var3E2BA03AB8CD54396BA9F03BD8DE54CD_799075618 =         ((signum() < 0) ? negate() : this);
        var3E2BA03AB8CD54396BA9F03BD8DE54CD_799075618.addTaint(taint);
        return var3E2BA03AB8CD54396BA9F03BD8DE54CD_799075618;
        // ---------- Original Method ----------
        //return ((signum() < 0) ? negate() : this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.597 -0400", hash_original_method = "BC934B9214C4819E6720F567E9C870B9", hash_generated_method = "5C474C857AC09F2F7A0CCE5CA257F329")
    public BigDecimal abs(MathContext mc) {
        addTaint(mc.getTaint());
        BigDecimal result = abs();
        result.inplaceRound(mc);
BigDecimal varDC838461EE2FA0CA4C9BBB70A15456B0_732676119 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_732676119.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_732676119;
        // ---------- Original Method ----------
        //BigDecimal result = abs();
        //result.inplaceRound(mc);
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.597 -0400", hash_original_method = "434D4E2CBF9E3CBC75126AF4586B2CF0", hash_generated_method = "AFD88AA3DAB16901453947B6E6A47828")
    public BigDecimal negate() {
        if(bitLength < 63 || (bitLength == 63 && smallValue!=Long.MIN_VALUE))        
        {
BigDecimal var73E555E7A4D5749B540A5445821C9FE7_333031941 =             valueOf(-smallValue,scale);
            var73E555E7A4D5749B540A5445821C9FE7_333031941.addTaint(taint);
            return var73E555E7A4D5749B540A5445821C9FE7_333031941;
        } //End block
BigDecimal var187C2BDDBC5A501DDF5A20C3166229AA_1578531527 =         new BigDecimal(getUnscaledValue().negate(), scale);
        var187C2BDDBC5A501DDF5A20C3166229AA_1578531527.addTaint(taint);
        return var187C2BDDBC5A501DDF5A20C3166229AA_1578531527;
        // ---------- Original Method ----------
        //if(bitLength < 63 || (bitLength == 63 && smallValue!=Long.MIN_VALUE)) {
            //return valueOf(-smallValue,scale);
        //}
        //return new BigDecimal(getUnscaledValue().negate(), scale);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.601 -0400", hash_original_method = "1D24791EE4ADD6E04558F8C92319E898", hash_generated_method = "AEE44AD892613EAA12D9C309128C5507")
    public BigDecimal negate(MathContext mc) {
        addTaint(mc.getTaint());
        BigDecimal result = negate();
        result.inplaceRound(mc);
BigDecimal varDC838461EE2FA0CA4C9BBB70A15456B0_1574971770 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1574971770.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1574971770;
        // ---------- Original Method ----------
        //BigDecimal result = negate();
        //result.inplaceRound(mc);
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.601 -0400", hash_original_method = "E5A0BEEECFDAB0EB24F23ED92FDA1EE0", hash_generated_method = "B3B9785D1D2C26E5841314993F496623")
    public BigDecimal plus() {
BigDecimal var72A74007B2BE62B849F475C7BDA4658B_1396870932 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1396870932.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1396870932;
        // ---------- Original Method ----------
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.601 -0400", hash_original_method = "06DE611812CE14E42B61206CBE361795", hash_generated_method = "BFA6CC78EF784A8D2B83DBD44DAD6FEB")
    public BigDecimal plus(MathContext mc) {
        addTaint(mc.getTaint());
BigDecimal var099658E03F9BF7D1563531EEEABC8E1F_710795689 =         round(mc);
        var099658E03F9BF7D1563531EEEABC8E1F_710795689.addTaint(taint);
        return var099658E03F9BF7D1563531EEEABC8E1F_710795689;
        // ---------- Original Method ----------
        //return round(mc);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.601 -0400", hash_original_method = "CA4E5917AFEF32459FAB7B79AFDA8BD4", hash_generated_method = "985B784EC37D05869F2A264BE30CE835")
    public int signum() {
        if(bitLength < 64)        
        {
            int varD9A9F07E76925BC510DC1A6A4A0DC45B_1685021074 = (Long.signum( this.smallValue ));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_680349225 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_680349225;
        } //End block
        int var4B8344645A71978B6D1FD40497CCD683_1083952380 = (getUnscaledValue().signum());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_455525749 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_455525749;
        // ---------- Original Method ----------
        //if( bitLength < 64) {
            //return Long.signum( this.smallValue );
        //}
        //return getUnscaledValue().signum();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.601 -0400", hash_original_method = "F3E74BAAEB162D78F28E445308393563", hash_generated_method = "C1C85CA1C6269639FBF6506B8728564C")
    private boolean isZero() {
        boolean var82D0A726C120D5744FDF0390F9FF98A3_1583080267 = (bitLength == 0 && this.smallValue != -1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_57405788 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_57405788;
        // ---------- Original Method ----------
        //return bitLength == 0 && this.smallValue != -1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.602 -0400", hash_original_method = "5F6F67A9AE4AEECC5BD64D7ACC145B6A", hash_generated_method = "86B132E8A9034D04D4D6B57D800D1A8B")
    public int scale() {
        int var0CB47AEB6E5F9323F0969E628C4E59F5_1880075253 = (scale);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1921712066 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1921712066;
        // ---------- Original Method ----------
        //return scale;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.602 -0400", hash_original_method = "6DFBDD0E771CAF738A0C801E888E1E3B", hash_generated_method = "99E63BC8B8945C072EF14E00E887F28B")
    public int precision() {
        if(precision > 0)        
        {
            int varE2794D8F12719281EFF5601251C8A680_248825736 = (precision);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1106483014 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1106483014;
        } //End block
        int bitLength = this.bitLength;
        if(bitLength == 0)        
        {
            precision = 1;
        } //End block
        else
        if(bitLength < 64)        
        {
            precision = decimalDigitsInLong(smallValue);
        } //End block
        else
        {
            int decimalDigits = 1 + (int) ((bitLength - 1) * LOG10_2);
            if(getUnscaledValue().divide(Multiplication.powerOf10(decimalDigits)).signum() != 0)            
            {
                decimalDigits++;
            } //End block
            precision = decimalDigits;
        } //End block
        int varE2794D8F12719281EFF5601251C8A680_1669458824 = (precision);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_791433501 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_791433501;
        // ---------- Original Method ----------
        //if (precision > 0) {
            //return precision;
        //}
        //int bitLength = this.bitLength;
        //if (bitLength == 0) {
            //precision = 1;
        //} else if (bitLength < 64) {
            //precision = decimalDigitsInLong(smallValue);
        //} else {
            //int decimalDigits = 1 + (int) ((bitLength - 1) * LOG10_2);
            //if (getUnscaledValue().divide(Multiplication.powerOf10(decimalDigits)).signum() != 0) {
                //decimalDigits++;
            //}
            //precision = decimalDigits;
        //}
        //return precision;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.602 -0400", hash_original_method = "EAD040D94F5F819E555B537F69E87C66", hash_generated_method = "95BE04735A06B475F8C969CBAA3BFE6C")
    private int decimalDigitsInLong(long value) {
        addTaint(value);
        if(value == Long.MIN_VALUE)        
        {
            int var1F0E3DAD99908345F7439F8FFABDFFC4_1896315010 = (19);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_208514115 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_208514115;
        } //End block
        else
        {
            int index = Arrays.binarySearch(MathUtils.LONG_POWERS_OF_TEN, Math.abs(value));
            int var389FD6ABBD36BA1BEEA459EFC729774A_1280560911 = ((index < 0) ? (-index - 1) : (index + 1));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1970037955 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1970037955;
        } //End block
        // ---------- Original Method ----------
        //if (value == Long.MIN_VALUE) {
            //return 19; 
        //} else {
            //int index = Arrays.binarySearch(MathUtils.LONG_POWERS_OF_TEN, Math.abs(value));
            //return (index < 0) ? (-index - 1) : (index + 1);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.603 -0400", hash_original_method = "067DA515CBCF3B72C5546CE6034B99CF", hash_generated_method = "FB3B6C09CFA84A917411A8BEF1FD9B45")
    public BigInteger unscaledValue() {
BigInteger varC9F991BB5BE86225185B684B83A7B9ED_312089222 =         getUnscaledValue();
        varC9F991BB5BE86225185B684B83A7B9ED_312089222.addTaint(taint);
        return varC9F991BB5BE86225185B684B83A7B9ED_312089222;
        // ---------- Original Method ----------
        //return getUnscaledValue();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.603 -0400", hash_original_method = "2FC46B1D06394AF066FA7CDA852A22F8", hash_generated_method = "54F3F693F0A5B11C7C76FCC39D5862A1")
    public BigDecimal round(MathContext mc) {
        addTaint(mc.getTaint());
        BigDecimal thisBD = new BigDecimal(getUnscaledValue(), scale);
        thisBD.inplaceRound(mc);
BigDecimal varB72F00E59FE39C0D0346006335911BDC_1849581520 =         thisBD;
        varB72F00E59FE39C0D0346006335911BDC_1849581520.addTaint(taint);
        return varB72F00E59FE39C0D0346006335911BDC_1849581520;
        // ---------- Original Method ----------
        //BigDecimal thisBD = new BigDecimal(getUnscaledValue(), scale);
        //thisBD.inplaceRound(mc);
        //return thisBD;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.603 -0400", hash_original_method = "7B0F1A102C68137F597240860B4573E3", hash_generated_method = "D2FE2685B60E31BCDB58B8B9841A0E8B")
    public BigDecimal setScale(int newScale, RoundingMode roundingMode) {
        addTaint(roundingMode.getTaint());
        addTaint(newScale);
        if(roundingMode == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_967860652 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_967860652.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_967860652;
        } //End block
        long diffScale = newScale - (long)scale;
        if(diffScale == 0)        
        {
BigDecimal var72A74007B2BE62B849F475C7BDA4658B_637160517 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_637160517.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_637160517;
        } //End block
        if(diffScale > 0)        
        {
            if(diffScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                    (this.bitLength + LONG_POWERS_OF_TEN_BIT_LENGTH[(int)diffScale]) < 64)            
            {
BigDecimal var4C319D7509BAD3F87FD88EF0DDE3CF05_8720115 =                 valueOf(this.smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)diffScale],newScale);
                var4C319D7509BAD3F87FD88EF0DDE3CF05_8720115.addTaint(taint);
                return var4C319D7509BAD3F87FD88EF0DDE3CF05_8720115;
            } //End block
BigDecimal var879AE69C6F82455D75FF1571FFEBC63F_1026568365 =             new BigDecimal(Multiplication.multiplyByTenPow(getUnscaledValue(),(int)diffScale), newScale);
            var879AE69C6F82455D75FF1571FFEBC63F_1026568365.addTaint(taint);
            return var879AE69C6F82455D75FF1571FFEBC63F_1026568365;
        } //End block
        if(this.bitLength < 64 && -diffScale < MathUtils.LONG_POWERS_OF_TEN.length)        
        {
BigDecimal var02425BF4EB44CC1AE5DA82EC99C07B32_2138280937 =             dividePrimitiveLongs(this.smallValue, MathUtils.LONG_POWERS_OF_TEN[(int)-diffScale], newScale,roundingMode);
            var02425BF4EB44CC1AE5DA82EC99C07B32_2138280937.addTaint(taint);
            return var02425BF4EB44CC1AE5DA82EC99C07B32_2138280937;
        } //End block
BigDecimal varDD0B29B5503B4B9E4737410AAFF67D96_321463953 =         divideBigIntegers(this.getUnscaledValue(),Multiplication.powerOf10(-diffScale),newScale,roundingMode);
        varDD0B29B5503B4B9E4737410AAFF67D96_321463953.addTaint(taint);
        return varDD0B29B5503B4B9E4737410AAFF67D96_321463953;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.604 -0400", hash_original_method = "82E5CBCA5195979E97780CEADBFBD3C4", hash_generated_method = "83084EDCA07DEB80A870D9F7CBE9B82B")
    public BigDecimal setScale(int newScale, int roundingMode) {
        addTaint(roundingMode);
        addTaint(newScale);
BigDecimal var3CB37F9DED08E643A7B23987C491C2AB_1140483178 =         setScale(newScale, RoundingMode.valueOf(roundingMode));
        var3CB37F9DED08E643A7B23987C491C2AB_1140483178.addTaint(taint);
        return var3CB37F9DED08E643A7B23987C491C2AB_1140483178;
        // ---------- Original Method ----------
        //return setScale(newScale, RoundingMode.valueOf(roundingMode));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.604 -0400", hash_original_method = "ABCD452F1FC16ADBD3F58023EF098557", hash_generated_method = "D417F2E6333C881DB7CC75B91B8B4CBB")
    public BigDecimal setScale(int newScale) {
        addTaint(newScale);
BigDecimal varA1157EE9F4212E9445297F359E13EBFE_1247304969 =         setScale(newScale, RoundingMode.UNNECESSARY);
        varA1157EE9F4212E9445297F359E13EBFE_1247304969.addTaint(taint);
        return varA1157EE9F4212E9445297F359E13EBFE_1247304969;
        // ---------- Original Method ----------
        //return setScale(newScale, RoundingMode.UNNECESSARY);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.608 -0400", hash_original_method = "146C1C6822DF31E0F5C90B0C65347C9D", hash_generated_method = "2325882701ADDFC9B93FD16925B3E30B")
    public BigDecimal movePointLeft(int n) {
        addTaint(n);
BigDecimal var18B7F63A30DCEE38D3BB12F0A0E8352C_235503069 =         movePoint(scale + (long)n);
        var18B7F63A30DCEE38D3BB12F0A0E8352C_235503069.addTaint(taint);
        return var18B7F63A30DCEE38D3BB12F0A0E8352C_235503069;
        // ---------- Original Method ----------
        //return movePoint(scale + (long)n);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.609 -0400", hash_original_method = "EF6481821B33DB93DBF91CDB78772ACF", hash_generated_method = "0FCF1180B479463D5800268A36B491B6")
    private BigDecimal movePoint(long newScale) {
        addTaint(newScale);
        if(isZero())        
        {
BigDecimal var8648669F4F9B7990554AFB532873A30B_797189204 =             zeroScaledBy(Math.max(newScale, 0));
            var8648669F4F9B7990554AFB532873A30B_797189204.addTaint(taint);
            return var8648669F4F9B7990554AFB532873A30B_797189204;
        } //End block
        if(newScale >= 0)        
        {
            if(bitLength < 64)            
            {
BigDecimal var1F006DE699D456616CFA5C0DCB882785_173944413 =                 valueOf(smallValue, safeLongToInt(newScale));
                var1F006DE699D456616CFA5C0DCB882785_173944413.addTaint(taint);
                return var1F006DE699D456616CFA5C0DCB882785_173944413;
            } //End block
BigDecimal var2950B3F33271CDDFB82B4FA1532054AD_2099504053 =             new BigDecimal(getUnscaledValue(), safeLongToInt(newScale));
            var2950B3F33271CDDFB82B4FA1532054AD_2099504053.addTaint(taint);
            return var2950B3F33271CDDFB82B4FA1532054AD_2099504053;
        } //End block
        if(-newScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                bitLength + LONG_POWERS_OF_TEN_BIT_LENGTH[(int)-newScale] < 64)        
        {
BigDecimal varBA2BCB1B91E2BF9BB2E46D52D5B505F9_99918731 =             valueOf(smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)-newScale],0);
            varBA2BCB1B91E2BF9BB2E46D52D5B505F9_99918731.addTaint(taint);
            return varBA2BCB1B91E2BF9BB2E46D52D5B505F9_99918731;
        } //End block
BigDecimal varB459E47A55149A8AB88189942063A3AE_1502713905 =         new BigDecimal(Multiplication.multiplyByTenPow(
                getUnscaledValue(), safeLongToInt(-newScale)), 0);
        varB459E47A55149A8AB88189942063A3AE_1502713905.addTaint(taint);
        return varB459E47A55149A8AB88189942063A3AE_1502713905;
        // ---------- Original Method ----------
        //if (isZero()) {
            //return zeroScaledBy(Math.max(newScale, 0));
        //}
        //if(newScale >= 0) {
            //if(bitLength < 64) {
                //return valueOf(smallValue, safeLongToInt(newScale));
            //}
            //return new BigDecimal(getUnscaledValue(), safeLongToInt(newScale));
        //}
        //if(-newScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                //bitLength + LONG_POWERS_OF_TEN_BIT_LENGTH[(int)-newScale] < 64 ) {
            //return valueOf(smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)-newScale],0);
        //}
        //return new BigDecimal(Multiplication.multiplyByTenPow(
                //getUnscaledValue(), safeLongToInt(-newScale)), 0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.609 -0400", hash_original_method = "07D5C3611C3ACCF090DC6103621F9345", hash_generated_method = "937B08075DED0B5D5A2551B8A907793B")
    public BigDecimal movePointRight(int n) {
        addTaint(n);
BigDecimal varFAB4A084C014F2CC9A06FE2F649EC5B7_1789834916 =         movePoint(scale - (long)n);
        varFAB4A084C014F2CC9A06FE2F649EC5B7_1789834916.addTaint(taint);
        return varFAB4A084C014F2CC9A06FE2F649EC5B7_1789834916;
        // ---------- Original Method ----------
        //return movePoint(scale - (long)n);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.610 -0400", hash_original_method = "D86719E7E7F9F283B32E5780DA0BBE23", hash_generated_method = "D44471AE6C73CA9AFBEB1856D118845D")
    public BigDecimal scaleByPowerOfTen(int n) {
        addTaint(n);
        long newScale = scale - (long)n;
        if(bitLength < 64)        
        {
            if(smallValue==0)            
            {
BigDecimal varE59C58B2F93F3B07BADE839AC0BAC55B_1240075622 =                 zeroScaledBy( newScale );
                varE59C58B2F93F3B07BADE839AC0BAC55B_1240075622.addTaint(taint);
                return varE59C58B2F93F3B07BADE839AC0BAC55B_1240075622;
            } //End block
BigDecimal var1F006DE699D456616CFA5C0DCB882785_1032408418 =             valueOf(smallValue, safeLongToInt(newScale));
            var1F006DE699D456616CFA5C0DCB882785_1032408418.addTaint(taint);
            return var1F006DE699D456616CFA5C0DCB882785_1032408418;
        } //End block
BigDecimal var2950B3F33271CDDFB82B4FA1532054AD_1449123415 =         new BigDecimal(getUnscaledValue(), safeLongToInt(newScale));
        var2950B3F33271CDDFB82B4FA1532054AD_1449123415.addTaint(taint);
        return var2950B3F33271CDDFB82B4FA1532054AD_1449123415;
        // ---------- Original Method ----------
        //long newScale = scale - (long)n;
        //if(bitLength < 64) {
            //if( smallValue==0  ){
                //return zeroScaledBy( newScale );
            //}
            //return valueOf(smallValue, safeLongToInt(newScale));
        //}
        //return new BigDecimal(getUnscaledValue(), safeLongToInt(newScale));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.610 -0400", hash_original_method = "6A410D70691999CADF96A81B91BD2E64", hash_generated_method = "3450819D3EBCFDE605E707D0DD68F925")
    public BigDecimal stripTrailingZeros() {
        int i = 1;
        int lastPow = TEN_POW.length - 1;
        long newScale = scale;
        if(isZero())        
        {
BigDecimal var72A74007B2BE62B849F475C7BDA4658B_995137567 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_995137567.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_995137567;
        } //End block
        BigInteger strippedBI = getUnscaledValue();
        BigInteger[] quotAndRem;
        while
(!strippedBI.testBit(0))        
        {
            quotAndRem = strippedBI.divideAndRemainder(TEN_POW[i]);
            if(quotAndRem[1].signum() == 0)            
            {
                newScale -= i;
                if(i < lastPow)                
                {
                    i++;
                } //End block
                strippedBI = quotAndRem[0];
            } //End block
            else
            {
                if(i == 1)                
                {
                    break;
                } //End block
                i = 1;
            } //End block
        } //End block
BigDecimal var1A166BB701B1FAE1B7F0689622487F14_776345864 =         new BigDecimal(strippedBI, safeLongToInt(newScale));
        var1A166BB701B1FAE1B7F0689622487F14_776345864.addTaint(taint);
        return var1A166BB701B1FAE1B7F0689622487F14_776345864;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.611 -0400", hash_original_method = "1C45ED34C4C1F5BEBD8BB8EF3CBE1A6B", hash_generated_method = "798E562E7A798D49D9162FDD44B020FF")
    public int compareTo(BigDecimal val) {
        addTaint(val.getTaint());
        int thisSign = signum();
        int valueSign = val.signum();
        if(thisSign == valueSign)        
        {
            if(this.scale == val.scale && this.bitLength<64 && val.bitLength<64)            
            {
                int var4F05C911BF30C1F1E580BBD19824544C_1832832366 = ((smallValue < val.smallValue) ? -1 : (smallValue > val.smallValue) ? 1 : 0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1080201716 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1080201716;
            } //End block
            long diffScale = (long)this.scale - val.scale;
            int diffPrecision = this.approxPrecision() - val.approxPrecision();
            if(diffPrecision > diffScale + 1)            
            {
                int varAAEC9E072831704FD03A6CE72D4B1006_1677753005 = (thisSign);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_502510991 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_502510991;
            } //End block
            else
            if(diffPrecision < diffScale - 1)            
            {
                int var9339BEECD49D6BC1F9531011F0B80496_1197006121 = (-thisSign);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1964780982 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1964780982;
            } //End block
            else
            {
                BigInteger thisUnscaled = this.getUnscaledValue();
                BigInteger valUnscaled = val.getUnscaledValue();
                if(diffScale < 0)                
                {
                    thisUnscaled = thisUnscaled.multiply(Multiplication.powerOf10(-diffScale));
                } //End block
                else
                if(diffScale > 0)                
                {
                    valUnscaled = valUnscaled.multiply(Multiplication.powerOf10(diffScale));
                } //End block
                int var17572EF0DCF687EFA578961DD76793C2_497723867 = (thisUnscaled.compareTo(valUnscaled));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1178400513 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1178400513;
            } //End block
        } //End block
        else
        if(thisSign < valueSign)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1612621430 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_267738868 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_267738868;
        } //End block
        else
        {
            int varC4CA4238A0B923820DCC509A6F75849B_1062312335 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_717418387 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_717418387;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.611 -0400", hash_original_method = "310E755E039C5525B03EE3C0A35D27A8", hash_generated_method = "D320148567319ACE203B57E619CBA6B1")
    @Override
    public boolean equals(Object x) {
        addTaint(x.getTaint());
        if(this == x)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_871460011 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_25986762 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_25986762;
        } //End block
        if(x instanceof BigDecimal)        
        {
            BigDecimal x1 = (BigDecimal) x;
            boolean varFFCB248826AD0D992940B7C3CE45FBD6_2052374629 = (x1.scale == scale
                   && (bitLength < 64 ? (x1.smallValue == smallValue)
                    : intVal.equals(x1.intVal)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1543695050 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1543695050;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1972662381 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_972912487 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_972912487;
        // ---------- Original Method ----------
        //if (this == x) {
            //return true;
        //}
        //if (x instanceof BigDecimal) {
            //BigDecimal x1 = (BigDecimal) x;
            //return x1.scale == scale
                   //&& (bitLength < 64 ? (x1.smallValue == smallValue)
                    //: intVal.equals(x1.intVal));
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.611 -0400", hash_original_method = "F19ED99F66E082325A61ACA186AF7454", hash_generated_method = "78E87683F2C8656457F9CD8087F28223")
    public BigDecimal min(BigDecimal val) {
        addTaint(val.getTaint());
BigDecimal var26708BAD27AB6A40DFD9B529BADE2259_494840350 =         ((compareTo(val) <= 0) ? this : val);
        var26708BAD27AB6A40DFD9B529BADE2259_494840350.addTaint(taint);
        return var26708BAD27AB6A40DFD9B529BADE2259_494840350;
        // ---------- Original Method ----------
        //return ((compareTo(val) <= 0) ? this : val);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.611 -0400", hash_original_method = "4EA6A2C4CEA295044D603E0ACE9B5BC6", hash_generated_method = "F0652A7116F4C9EF6E3CCE54C7175AC5")
    public BigDecimal max(BigDecimal val) {
        addTaint(val.getTaint());
BigDecimal var34A91ECE6AEEAB60C08BD373AE7560BF_766296049 =         ((compareTo(val) >= 0) ? this : val);
        var34A91ECE6AEEAB60C08BD373AE7560BF_766296049.addTaint(taint);
        return var34A91ECE6AEEAB60C08BD373AE7560BF_766296049;
        // ---------- Original Method ----------
        //return ((compareTo(val) >= 0) ? this : val);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.612 -0400", hash_original_method = "F20F131BB03F0B25B12A1EF1F413017D", hash_generated_method = "2A65098AEDF7E5389C2ED9064E1960B6")
    @Override
    public int hashCode() {
        if(hashCode != 0)        
        {
            int var550D1CC054A1B23A411DDDA46FD64811_1226974303 = (hashCode);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1566408933 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1566408933;
        } //End block
        if(bitLength < 64)        
        {
            hashCode = (int)(smallValue & 0xffffffff);
            hashCode = 33 * hashCode +  (int)((smallValue >> 32) & 0xffffffff);
            hashCode = 17 * hashCode + scale;
            int var550D1CC054A1B23A411DDDA46FD64811_2059029917 = (hashCode);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1186466924 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1186466924;
        } //End block
        hashCode = 17 * intVal.hashCode() + scale;
        int var550D1CC054A1B23A411DDDA46FD64811_168362159 = (hashCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1239372266 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1239372266;
        // ---------- Original Method ----------
        //if (hashCode != 0) {
            //return hashCode;
        //}
        //if (bitLength < 64) {
            //hashCode = (int)(smallValue & 0xffffffff);
            //hashCode = 33 * hashCode +  (int)((smallValue >> 32) & 0xffffffff);
            //hashCode = 17 * hashCode + scale;
            //return hashCode;
        //}
        //hashCode = 17 * intVal.hashCode() + scale;
        //return hashCode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.612 -0400", hash_original_method = "7C431BE8FF70735180E872A989DC1E52", hash_generated_method = "FF11B613B96877A5FE702CC156127706")
    @Override
    public String toString() {
        if(toStringImage != null)        
        {
String varC4BFBCFE8406AE670C10C7BFDA80A704_1603636057 =             toStringImage;
            varC4BFBCFE8406AE670C10C7BFDA80A704_1603636057.addTaint(taint);
            return varC4BFBCFE8406AE670C10C7BFDA80A704_1603636057;
        } //End block
        if(bitLength < 32)        
        {
            toStringImage = Conversion.toDecimalScaledString(smallValue,scale);
String varC4BFBCFE8406AE670C10C7BFDA80A704_595136038 =             toStringImage;
            varC4BFBCFE8406AE670C10C7BFDA80A704_595136038.addTaint(taint);
            return varC4BFBCFE8406AE670C10C7BFDA80A704_595136038;
        } //End block
        String intString = getUnscaledValue().toString();
        if(scale == 0)        
        {
String var44CDC699F6A0F54826763415A2B51DE5_1560795475 =             intString;
            var44CDC699F6A0F54826763415A2B51DE5_1560795475.addTaint(taint);
            return var44CDC699F6A0F54826763415A2B51DE5_1560795475;
        } //End block
        int begin = (getUnscaledValue().signum() < 0) ? 2 : 1;
        int end = intString.length();
        long exponent = -(long)scale + end - begin;
        StringBuilder result = new StringBuilder();
        result.append(intString);
        if((scale > 0) && (exponent >= -6))        
        {
            if(exponent >= 0)            
            {
                result.insert(end - scale, '.');
            } //End block
            else
            {
                result.insert(begin - 1, "0.");
                result.insert(begin + 1, CH_ZEROS, 0, -(int)exponent - 1);
            } //End block
        } //End block
        else
        {
            if(end - begin >= 1)            
            {
                result.insert(begin, '.');
                end++;
            } //End block
            result.insert(end, 'E');
            if(exponent > 0)            
            {
                result.insert(++end, '+');
            } //End block
            result.insert(++end, Long.toString(exponent));
        } //End block
        toStringImage = result.toString();
String varC4BFBCFE8406AE670C10C7BFDA80A704_186093592 =         toStringImage;
        varC4BFBCFE8406AE670C10C7BFDA80A704_186093592.addTaint(taint);
        return varC4BFBCFE8406AE670C10C7BFDA80A704_186093592;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.613 -0400", hash_original_method = "37C393D601D5FE9982CCA7EB2837999F", hash_generated_method = "9AA2552AF6AD13DDDC35DA58F93396AD")
    public String toEngineeringString() {
        String intString = getUnscaledValue().toString();
        if(scale == 0)        
        {
String var44CDC699F6A0F54826763415A2B51DE5_1760424110 =             intString;
            var44CDC699F6A0F54826763415A2B51DE5_1760424110.addTaint(taint);
            return var44CDC699F6A0F54826763415A2B51DE5_1760424110;
        } //End block
        int begin = (getUnscaledValue().signum() < 0) ? 2 : 1;
        int end = intString.length();
        long exponent = -(long)scale + end - begin;
        StringBuilder result = new StringBuilder(intString);
        if((scale > 0) && (exponent >= -6))        
        {
            if(exponent >= 0)            
            {
                result.insert(end - scale, '.');
            } //End block
            else
            {
                result.insert(begin - 1, "0.");
                result.insert(begin + 1, CH_ZEROS, 0, -(int)exponent - 1);
            } //End block
        } //End block
        else
        {
            int delta = end - begin;
            int rem = (int)(exponent % 3);
            if(rem != 0)            
            {
                if(getUnscaledValue().signum() == 0)                
                {
                    rem = (rem < 0) ? -rem : 3 - rem;
                    exponent += rem;
                } //End block
                else
                {
                    rem = (rem < 0) ? rem + 3 : rem;
                    exponent -= rem;
                    begin += rem;
                } //End block
                if(delta < 3)                
                {
for(int i = rem - delta;i > 0;i--)
                    {
                        result.insert(end++, '0');
                    } //End block
                } //End block
            } //End block
            if(end - begin >= 1)            
            {
                result.insert(begin, '.');
                end++;
            } //End block
            if(exponent != 0)            
            {
                result.insert(end, 'E');
                if(exponent > 0)                
                {
                    result.insert(++end, '+');
                } //End block
                result.insert(++end, Long.toString(exponent));
            } //End block
        } //End block
String varE65B3A02759122992CB82C0E651AD408_884600151 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_884600151.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_884600151;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.614 -0400", hash_original_method = "F2C3CA97C72252FC482FDCEF1D32932E", hash_generated_method = "5D5AE5E720EC8F63C67C53D1C69DECB1")
    public String toPlainString() {
        String intStr = getUnscaledValue().toString();
        if((scale == 0) || ((isZero()) && (scale < 0)))        
        {
String var26ACA9E947EDB70461C1B834B3A4BCDD_544022192 =             intStr;
            var26ACA9E947EDB70461C1B834B3A4BCDD_544022192.addTaint(taint);
            return var26ACA9E947EDB70461C1B834B3A4BCDD_544022192;
        } //End block
        int begin = (signum() < 0) ? 1 : 0;
        int delta = scale;
        StringBuilder result = new StringBuilder(intStr.length() + 1 + Math.abs(scale));
        if(begin == 1)        
        {
            result.append('-');
        } //End block
        if(scale > 0)        
        {
            delta -= (intStr.length() - begin);
            if(delta >= 0)            
            {
                result.append("0.");
for(;delta > CH_ZEROS.length;delta -= CH_ZEROS.length)
                {
                    result.append(CH_ZEROS);
                } //End block
                result.append(CH_ZEROS, 0, delta);
                result.append(intStr.substring(begin));
            } //End block
            else
            {
                delta = begin - delta;
                result.append(intStr.substring(begin, delta));
                result.append('.');
                result.append(intStr.substring(delta));
            } //End block
        } //End block
        else
        {
            result.append(intStr.substring(begin));
for(;delta < -CH_ZEROS.length;delta += CH_ZEROS.length)
            {
                result.append(CH_ZEROS);
            } //End block
            result.append(CH_ZEROS, 0, -delta);
        } //End block
String varE65B3A02759122992CB82C0E651AD408_1489989535 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_1489989535.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_1489989535;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.617 -0400", hash_original_method = "E90ADE3EE93FD433EFA047972DEC5382", hash_generated_method = "15FDE7CC2303EC5FF632771FDDDC2EFB")
    public BigInteger toBigInteger() {
        if((scale == 0) || (isZero()))        
        {
BigInteger varC9F991BB5BE86225185B684B83A7B9ED_1175584922 =             getUnscaledValue();
            varC9F991BB5BE86225185B684B83A7B9ED_1175584922.addTaint(taint);
            return varC9F991BB5BE86225185B684B83A7B9ED_1175584922;
        } //End block
        else
        if(scale < 0)        
        {
BigInteger var92E5714BDDF7DA600C27464C41C26CB9_483476344 =             getUnscaledValue().multiply(Multiplication.powerOf10(-(long)scale));
            var92E5714BDDF7DA600C27464C41C26CB9_483476344.addTaint(taint);
            return var92E5714BDDF7DA600C27464C41C26CB9_483476344;
        } //End block
        else
        {
BigInteger var79C204E0A83BFC04B5F58E315F54C764_1420341590 =             getUnscaledValue().divide(Multiplication.powerOf10(scale));
            var79C204E0A83BFC04B5F58E315F54C764_1420341590.addTaint(taint);
            return var79C204E0A83BFC04B5F58E315F54C764_1420341590;
        } //End block
        // ---------- Original Method ----------
        //if ((scale == 0) || (isZero())) {
            //return getUnscaledValue();
        //} else if (scale < 0) {
            //return getUnscaledValue().multiply(Multiplication.powerOf10(-(long)scale));
        //} else {
            //return getUnscaledValue().divide(Multiplication.powerOf10(scale));
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.618 -0400", hash_original_method = "0E78A189176A3E6769EBE407FB203DE6", hash_generated_method = "303A11400A79DD24161529F6A212CB9A")
    public BigInteger toBigIntegerExact() {
        if((scale == 0) || (isZero()))        
        {
BigInteger varC9F991BB5BE86225185B684B83A7B9ED_400117274 =             getUnscaledValue();
            varC9F991BB5BE86225185B684B83A7B9ED_400117274.addTaint(taint);
            return varC9F991BB5BE86225185B684B83A7B9ED_400117274;
        } //End block
        else
        if(scale < 0)        
        {
BigInteger var92E5714BDDF7DA600C27464C41C26CB9_1908818333 =             getUnscaledValue().multiply(Multiplication.powerOf10(-(long)scale));
            var92E5714BDDF7DA600C27464C41C26CB9_1908818333.addTaint(taint);
            return var92E5714BDDF7DA600C27464C41C26CB9_1908818333;
        } //End block
        else
        {
            BigInteger[] integerAndFraction;
            if((scale > approxPrecision()) || (scale > getUnscaledValue().getLowestSetBit()))            
            {
                ArithmeticException varE5C6C0C3BF441F5A418B2C1CC9D6DB36_44240142 = new ArithmeticException("Rounding necessary");
                varE5C6C0C3BF441F5A418B2C1CC9D6DB36_44240142.addTaint(taint);
                throw varE5C6C0C3BF441F5A418B2C1CC9D6DB36_44240142;
            } //End block
            integerAndFraction = getUnscaledValue().divideAndRemainder(Multiplication.powerOf10(scale));
            if(integerAndFraction[1].signum() != 0)            
            {
                ArithmeticException varE5C6C0C3BF441F5A418B2C1CC9D6DB36_192295540 = new ArithmeticException("Rounding necessary");
                varE5C6C0C3BF441F5A418B2C1CC9D6DB36_192295540.addTaint(taint);
                throw varE5C6C0C3BF441F5A418B2C1CC9D6DB36_192295540;
            } //End block
BigInteger var06BDC30212A265E66B8639F7A00D2AE4_2138024107 =             integerAndFraction[0];
            var06BDC30212A265E66B8639F7A00D2AE4_2138024107.addTaint(taint);
            return var06BDC30212A265E66B8639F7A00D2AE4_2138024107;
        } //End block
        // ---------- Original Method ----------
        //if ((scale == 0) || (isZero())) {
            //return getUnscaledValue();
        //} else if (scale < 0) {
            //return getUnscaledValue().multiply(Multiplication.powerOf10(-(long)scale));
        //} else {
            //BigInteger[] integerAndFraction;
            //if ((scale > approxPrecision()) || (scale > getUnscaledValue().getLowestSetBit())) {
                //throw new ArithmeticException("Rounding necessary");
            //}
            //integerAndFraction = getUnscaledValue().divideAndRemainder(Multiplication.powerOf10(scale));
            //if (integerAndFraction[1].signum() != 0) {
                //throw new ArithmeticException("Rounding necessary");
            //}
            //return integerAndFraction[0];
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.618 -0400", hash_original_method = "A54EDCAFB9A559A1B4EB83484BB75122", hash_generated_method = "4A8C13B0FF235C743E34E864B3FD2985")
    @Override
    public long longValue() {
        long var1D42F7550BDAE71142EC35FAC17842DD_863249334 = (((scale <= -64) || (scale > approxPrecision()) ? 0L
                : toBigInteger().longValue()));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1498192464 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1498192464;
        // ---------- Original Method ----------
        //return ((scale <= -64) || (scale > approxPrecision()) ? 0L
                //: toBigInteger().longValue());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.618 -0400", hash_original_method = "FC36A176D0180DB1420333E5E0A5371B", hash_generated_method = "3393F64AC368171FE0B27F358DDFA9B0")
    public long longValueExact() {
        long var69827C6D8993AB87D730C31E03F601BE_808863129 = (valueExact(64));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1320228808 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1320228808;
        // ---------- Original Method ----------
        //return valueExact(64);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.618 -0400", hash_original_method = "C22AEC57669E1045E01A9977FB32CBED", hash_generated_method = "1736F4522384E32C6C28249559032AFD")
    @Override
    public int intValue() {
        int var2AEA45D79AA6593A7B7DB1A67D8D63EB_320822617 = (((scale <= -32) || (scale > approxPrecision())
        ? 0
                : toBigInteger().intValue()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1235943539 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1235943539;
        // ---------- Original Method ----------
        //return ((scale <= -32) || (scale > approxPrecision())
        //? 0
                //: toBigInteger().intValue());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.618 -0400", hash_original_method = "3865E14853C36D94FA2C26348C89A3B8", hash_generated_method = "186B4DDC54285D5A8DB5FB17474C5109")
    public int intValueExact() {
        int var8379FDDD5D0728EB8AD43CC75916BEB4_1487781099 = ((int)valueExact(32));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1139177289 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1139177289;
        // ---------- Original Method ----------
        //return (int)valueExact(32);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.620 -0400", hash_original_method = "D0948D36E91C12739D01E1A7BD76887B", hash_generated_method = "15A84573A086B1654C400FB1F7723505")
    public short shortValueExact() {
        short var3FF1A8D4C979BFECFA072DA7AF4F3D20_48500358 = ((short)valueExact(16));
                short var4F09DAA9D95BCB166A302407A0E0BABE_1977488068 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1977488068;
        // ---------- Original Method ----------
        //return (short)valueExact(16);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.620 -0400", hash_original_method = "D6CE76A6DF6EC675E82ED0D5BFCEAF06", hash_generated_method = "77E71A072EE62C22691D10968831DA4B")
    public byte byteValueExact() {
        byte var90D2D9D6796F8238D749A34354DD1148_2144835486 = ((byte)valueExact(8));
                byte var40EA57D3EE3C07BF1C102B466E1C3091_1847106552 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1847106552;
        // ---------- Original Method ----------
        //return (byte)valueExact(8);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.620 -0400", hash_original_method = "4137052570907849FFBB7EF546BA389D", hash_generated_method = "A4082A87BAA200C354542577C3130CAF")
    @Override
    public float floatValue() {
        float floatResult = signum();
        long powerOfTwo = this.bitLength - (long)(scale / LOG10_2);
        if((powerOfTwo < -149) || (floatResult == 0.0f))        
        {
            floatResult *= 0.0f;
        } //End block
        else
        if(powerOfTwo > 129)        
        {
            floatResult *= Float.POSITIVE_INFINITY;
        } //End block
        else
        {
            floatResult = (float)doubleValue();
        } //End block
        float var698E631BB1C9A92204E07401E49BEE17_1842175536 = (floatResult);
                float var546ADE640B6EDFBC8A086EF31347E768_673058868 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_673058868;
        // ---------- Original Method ----------
        //float floatResult = signum();
        //long powerOfTwo = this.bitLength - (long)(scale / LOG10_2);
        //if ((powerOfTwo < -149) || (floatResult == 0.0f)) {
            //floatResult *= 0.0f;
        //} else if (powerOfTwo > 129) {
            //floatResult *= Float.POSITIVE_INFINITY;
        //} else {
            //floatResult = (float)doubleValue();
        //}
        //return floatResult;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.625 -0400", hash_original_method = "73F99D783081712086B11A0804DADCB9", hash_generated_method = "1C3BB0C429B0D613FDD766919B5FEF16")
    @Override
    public double doubleValue() {
        int sign = signum();
        int exponent = 1076;
        int lowestSetBit;
        int discardedSize;
        long powerOfTwo = this.bitLength - (long)(scale / LOG10_2);
        long bits;
        long tempBits;
        BigInteger mantissa;
        if((powerOfTwo < -1074) || (sign == 0))        
        {
            double varD8283E0CBB3270C1C3CBAEDED6D59ED3_580041407 = ((sign * 0.0d));
                        double varE8CD7DA078A86726031AD64F35F5A6C0_1335379088 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_1335379088;
        } //End block
        else
        if(powerOfTwo > 1025)        
        {
            double varDCD32871C19AE37E8637F370F1056C23_1573624928 = ((sign * Double.POSITIVE_INFINITY));
                        double varE8CD7DA078A86726031AD64F35F5A6C0_66355090 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_66355090;
        } //End block
        mantissa = getUnscaledValue().abs();
        if(scale <= 0)        
        {
            mantissa = mantissa.multiply(Multiplication.powerOf10(-scale));
        } //End block
        else
        {
            BigInteger quotAndRem[];
            BigInteger powerOfTen = Multiplication.powerOf10(scale);
            int k = 100 - (int)powerOfTwo;
            int compRem;
            if(k > 0)            
            {
                mantissa = mantissa.shiftLeft(k);
                exponent -= k;
            } //End block
            quotAndRem = mantissa.divideAndRemainder(powerOfTen);
            compRem = quotAndRem[1].shiftLeftOneBit().compareTo(powerOfTen);
            mantissa = quotAndRem[0].shiftLeft(2).add(
                    BigInteger.valueOf((compRem * (compRem + 3)) / 2 + 1));
            exponent -= 2;
        } //End block
        lowestSetBit = mantissa.getLowestSetBit();
        discardedSize = mantissa.bitLength() - 54;
        if(discardedSize > 0)        
        {
            bits = mantissa.shiftRight(discardedSize).longValue();
            tempBits = bits;
            if((((bits & 1) == 1) && (lowestSetBit < discardedSize))
                    || ((bits & 3) == 3))            
            {
                bits += 2;
            } //End block
        } //End block
        else
        {
            bits = mantissa.longValue() << -discardedSize;
            tempBits = bits;
            if((bits & 3) == 3)            
            {
                bits += 2;
            } //End block
        } //End block
        if((bits & 0x40000000000000L) == 0)        
        {
            bits >>= 1;
            exponent += discardedSize;
        } //End block
        else
        {
            bits >>= 2;
            exponent += discardedSize + 1;
        } //End block
        if(exponent > 2046)        
        {
            double varDCD32871C19AE37E8637F370F1056C23_290450378 = ((sign * Double.POSITIVE_INFINITY));
                        double varE8CD7DA078A86726031AD64F35F5A6C0_1692405116 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_1692405116;
        } //End block
        else
        if(exponent <= 0)        
        {
            if(exponent < -53)            
            {
                double varD8283E0CBB3270C1C3CBAEDED6D59ED3_662638779 = ((sign * 0.0d));
                                double varE8CD7DA078A86726031AD64F35F5A6C0_1940605513 = getTaintDouble();
                return varE8CD7DA078A86726031AD64F35F5A6C0_1940605513;
            } //End block
            bits = tempBits >> 1;
            tempBits = bits & (-1L >>> (63 + exponent));
            bits >>= (-exponent );
            if(((bits & 3) == 3) || (((bits & 1) == 1) && (tempBits != 0)
            && (lowestSetBit < discardedSize)))            
            {
                bits += 1;
            } //End block
            exponent = 0;
            bits >>= 1;
        } //End block
        bits = (sign & 0x8000000000000000L) | ((long)exponent << 52)
                | (bits & 0xFFFFFFFFFFFFFL);
        double var61EDA2E8233274E3C33F1B296528BD1E_86096314 = (Double.longBitsToDouble(bits));
                double varE8CD7DA078A86726031AD64F35F5A6C0_1731163897 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1731163897;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.628 -0400", hash_original_method = "AE130D2701C769DD6982173139D47466", hash_generated_method = "CDF10D59323F3E1A6FF138F9A3741836")
    public BigDecimal ulp() {
BigDecimal var7724CABD8C77ECA94722C10ABD307202_2045275545 =         valueOf(1, scale);
        var7724CABD8C77ECA94722C10ABD307202_2045275545.addTaint(taint);
        return var7724CABD8C77ECA94722C10ABD307202_2045275545;
        // ---------- Original Method ----------
        //return valueOf(1, scale);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.630 -0400", hash_original_method = "55CD7E6ED2002FE9D7C30850FBD08759", hash_generated_method = "302C7A4476621A1CEB0DF9106E185BB0")
    private void inplaceRound(MathContext mc) {
        addTaint(mc.getTaint());
        int mcPrecision = mc.getPrecision();
        if(approxPrecision() < mcPrecision || mcPrecision == 0)        
        {
            return;
        } //End block
        int discardedPrecision = precision() - mcPrecision;
        if((discardedPrecision <= 0))        
        {
            return;
        } //End block
        if(this.bitLength < 64)        
        {
            smallRound(mc, discardedPrecision);
            return;
        } //End block
        BigInteger sizeOfFraction = Multiplication.powerOf10(discardedPrecision);
        BigInteger[] integerAndFraction = getUnscaledValue().divideAndRemainder(sizeOfFraction);
        long newScale = (long)scale - discardedPrecision;
        int compRem;
        BigDecimal tempBD;
        if(integerAndFraction[1].signum() != 0)        
        {
            compRem = (integerAndFraction[1].abs().shiftLeftOneBit().compareTo(sizeOfFraction));
            compRem =  roundingBehavior( integerAndFraction[0].testBit(0) ? 1 : 0,
                    integerAndFraction[1].signum() * (5 + compRem),
                    mc.getRoundingMode());
            if(compRem != 0)            
            {
                integerAndFraction[0] = integerAndFraction[0].add(BigInteger.valueOf(compRem));
            } //End block
            tempBD = new BigDecimal(integerAndFraction[0]);
            if(tempBD.precision() > mcPrecision)            
            {
                integerAndFraction[0] = integerAndFraction[0].divide(BigInteger.TEN);
                newScale--;
            } //End block
        } //End block
        scale = safeLongToInt(newScale);
        precision = mcPrecision;
        setUnscaledValue(integerAndFraction[0]);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    private static int longCompareTo(long value1, long value2) {
        return value1 > value2 ? 1 : (value1 < value2 ? -1 : 0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.631 -0400", hash_original_method = "7FBE752FF3FF6B350050AE2B0F2B0308", hash_generated_method = "6F63D71CB645EEA08B0D4376FB6BE196")
    private void smallRound(MathContext mc, int discardedPrecision) {
        addTaint(discardedPrecision);
        long sizeOfFraction = MathUtils.LONG_POWERS_OF_TEN[discardedPrecision];
        long newScale = (long)scale - discardedPrecision;
        long unscaledVal = smallValue;
        long integer = unscaledVal / sizeOfFraction;
        long fraction = unscaledVal % sizeOfFraction;
        int compRem;
        if(fraction != 0)        
        {
            compRem = longCompareTo(Math.abs(fraction) * 2, sizeOfFraction);
            integer += roundingBehavior( ((int)integer) & 1,
                    Long.signum(fraction) * (5 + compRem),
                    mc.getRoundingMode());
            if(Math.log10(Math.abs(integer)) >= mc.getPrecision())            
            {
                integer /= 10;
                newScale--;
            } //End block
        } //End block
        scale = safeLongToInt(newScale);
        precision = mc.getPrecision();
        smallValue = integer;
        bitLength = bitLength(integer);
        intVal = null;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    private static int roundingBehavior(int parityBit, int fraction, RoundingMode roundingMode) {
        int increment = 0;
        switch (roundingMode) {
            case UNNECESSARY:
                if (fraction != 0) {
                    throw new ArithmeticException("Rounding necessary");
                }
                break;
            case UP:
                increment = Integer.signum(fraction);
                break;
            case DOWN:
                break;
            case CEILING:
                increment = Math.max(Integer.signum(fraction), 0);
                break;
            case FLOOR:
                increment = Math.min(Integer.signum(fraction), 0);
                break;
            case HALF_UP:
                if (Math.abs(fraction) >= 5) {
                    increment = Integer.signum(fraction);
                }
                break;
            case HALF_DOWN:
                if (Math.abs(fraction) > 5) {
                    increment = Integer.signum(fraction);
                }
                break;
            case HALF_EVEN:
                if (Math.abs(fraction) + parityBit > 5) {
                    increment = Integer.signum(fraction);
                }
                break;
        }
        return increment;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.632 -0400", hash_original_method = "77E444DFD73510CC8BF3E35576C17A04", hash_generated_method = "9848A981137340FF0198997AFCC9296A")
    private long valueExact(int bitLengthOfType) {
        addTaint(bitLengthOfType);
        BigInteger bigInteger = toBigIntegerExact();
        if(bigInteger.bitLength() < bitLengthOfType)        
        {
            long varE8B6CC613F9134F0818C7AFDC479A7FA_78751404 = (bigInteger.longValue());
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_2117789846 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_2117789846;
        } //End block
        ArithmeticException varE5C6C0C3BF441F5A418B2C1CC9D6DB36_1084526079 = new ArithmeticException("Rounding necessary");
        varE5C6C0C3BF441F5A418B2C1CC9D6DB36_1084526079.addTaint(taint);
        throw varE5C6C0C3BF441F5A418B2C1CC9D6DB36_1084526079;
        // ---------- Original Method ----------
        //BigInteger bigInteger = toBigIntegerExact();
        //if (bigInteger.bitLength() < bitLengthOfType) {
            //return bigInteger.longValue();
        //}
        //throw new ArithmeticException("Rounding necessary");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.633 -0400", hash_original_method = "610DE3E95388579A8DD4E22BDEDE3C6E", hash_generated_method = "6BFC52A2FD8797B24E0FEF95FAA72EE0")
    private int approxPrecision() {
        int var7CDA58196C86390834B6F2307552DAD7_1750699668 = (precision > 0
                ? precision
                : (int) ((this.bitLength - 1) * LOG10_2) + 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1794961039 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1794961039;
        // ---------- Original Method ----------
        //return precision > 0
                //? precision
                //: (int) ((this.bitLength - 1) * LOG10_2) + 1;
    }

    
    @DSModeled(DSC.SAFE)
    private static int safeLongToInt(long longValue) {
        if (longValue < Integer.MIN_VALUE || longValue > Integer.MAX_VALUE) {
            throw new ArithmeticException("Out of int range: " + longValue);
        }
        return (int) longValue;
    }

    
    @DSModeled(DSC.SAFE)
    private static BigDecimal zeroScaledBy(long longScale) {
        if (longScale == (int) longScale) {
            return valueOf(0,(int)longScale);
            }
        if (longScale >= 0) {
            return new BigDecimal( 0, Integer.MAX_VALUE);
        }
        return new BigDecimal( 0, Integer.MIN_VALUE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.633 -0400", hash_original_method = "886E4F08C2196C85465CF795B505FE44", hash_generated_method = "B223894362AA1D8F0C8B7257680A781C")
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        addTaint(in.getTaint());
        in.defaultReadObject();
        this.bitLength = intVal.bitLength();
        if(this.bitLength < 64)        
        {
            this.smallValue = intVal.longValue();
        } //End block
        // ---------- Original Method ----------
        //in.defaultReadObject();
        //this.bitLength = intVal.bitLength();
        //if (this.bitLength < 64) {
            //this.smallValue = intVal.longValue();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.633 -0400", hash_original_method = "19FA8CC309F5EC9C814FD711C697099A", hash_generated_method = "A182EAFF59BE1C772C43C11E96D8B230")
    private void writeObject(ObjectOutputStream out) throws IOException {
        addTaint(out.getTaint());
        getUnscaledValue();
        out.defaultWriteObject();
        // ---------- Original Method ----------
        //getUnscaledValue();
        //out.defaultWriteObject();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.636 -0400", hash_original_method = "1C1109E2DBDCFAE7331AD37D197254D0", hash_generated_method = "BFC5885E1AC10BE47B0F97C110FA0E1B")
    private BigInteger getUnscaledValue() {
        if(intVal == null)        
        {
            intVal = BigInteger.valueOf(smallValue);
        } //End block
BigInteger var8FF653FB840FA82FCA73D5A3807C8FDF_1970183124 =         intVal;
        var8FF653FB840FA82FCA73D5A3807C8FDF_1970183124.addTaint(taint);
        return var8FF653FB840FA82FCA73D5A3807C8FDF_1970183124;
        // ---------- Original Method ----------
        //if(intVal == null) {
            //intVal = BigInteger.valueOf(smallValue);
        //}
        //return intVal;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.636 -0400", hash_original_method = "3BE919C32007DA5FAF4FB8B842EE650C", hash_generated_method = "42271E755316AB344A200BAE571C12BC")
    private void setUnscaledValue(BigInteger unscaledValue) {
        this.intVal = unscaledValue;
        this.bitLength = unscaledValue.bitLength();
        if(this.bitLength < 64)        
        {
            this.smallValue = unscaledValue.longValue();
        } //End block
        // ---------- Original Method ----------
        //this.intVal = unscaledValue;
        //this.bitLength = unscaledValue.bitLength();
        //if(this.bitLength < 64) {
            //this.smallValue = unscaledValue.longValue();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    private static int bitLength(long smallValue) {
        if(smallValue < 0) {
            smallValue = ~smallValue;
        }
        return 64 - Long.numberOfLeadingZeros(smallValue);
    }

    
    @DSModeled(DSC.SAFE)
    private static int bitLength(int smallValue) {
        if(smallValue < 0) {
            smallValue = ~smallValue;
        }
        return 32 - Integer.numberOfLeadingZeros(smallValue);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.636 -0400", hash_original_field = "877CBC7572A1F4C5C4A5EF0FCDBA91C3", hash_generated_field = "B6EECEB04C7C8E9BC518DBA316290DA7")

    public static final int ROUND_UP = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.636 -0400", hash_original_field = "D2CF03DE063925E19E13C52C8FBE1929", hash_generated_field = "454999CD924CB489896B8D343444FE92")

    public static final int ROUND_DOWN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.636 -0400", hash_original_field = "AAC8B6F1C4763B9728AB52AE15952AF6", hash_generated_field = "3C0D845F7C2F954D2ED7E86C0AE35835")

    public static final int ROUND_CEILING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.637 -0400", hash_original_field = "7503CC26EC44F42386A1D0025B5AEF97", hash_generated_field = "53D60190BBA8538A982DF868F4C6200E")

    public static final int ROUND_FLOOR = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.637 -0400", hash_original_field = "7E7DD45EF4EB3B06BFEF96EA4B0DD84D", hash_generated_field = "F10F1696D5C52C5E6B4B91643A72CEBE")

    public static final int ROUND_HALF_UP = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.637 -0400", hash_original_field = "20B7B28A1B56AD4CEA47F72CC0696346", hash_generated_field = "1619429E1C6C75DCE5756A9CF242CB9E")

    public static final int ROUND_HALF_DOWN = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.637 -0400", hash_original_field = "B3DCF23AE156DDE73D388CA751C9365F", hash_generated_field = "737A62C6AFA4A3B8167B738F856B0DEA")

    public static final int ROUND_HALF_EVEN = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.637 -0400", hash_original_field = "22697FABD637B187447A670B355A0081", hash_generated_field = "C5A01DD93D79DC15583A8D0F0236E74E")

    public static final int ROUND_UNNECESSARY = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.637 -0400", hash_original_field = "116BD32AD0E75158256F445ABDC8389D", hash_generated_field = "732C210E7618496C3947E6F404C23DC5")

    private static final long serialVersionUID = 6108874887143696463L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.637 -0400", hash_original_field = "7458DC5DA966512012D7187A9F089DAC", hash_generated_field = "E93F26BA415E2A63370EECFB39CABE9A")

    private static final double LOG10_2 = 0.3010299956639812;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.637 -0400", hash_original_field = "5515FC399FA5591FAB09427986B893AC", hash_generated_field = "BC1FA69034FA076F552F1F096B6FE848")

    private static BigInteger[] FIVE_POW;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.637 -0400", hash_original_field = "6890CCC61C514170BDE91D0B4ED71AF6", hash_generated_field = "487DAC2FC944E340E99AE2E5C8C63B33")

    private static BigInteger[] TEN_POW;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.637 -0400", hash_original_field = "B3E64594B71C88A1FCA0FDDB1DB0D932", hash_generated_field = "7278FA9BE84E3C616E4421DE5FF2F206")

    private static final long[] LONG_FIVE_POW = new long[]
    {   1L,
        5L,
        25L,
        125L,
        625L,
        3125L,
        15625L,
        78125L,
        390625L,
        1953125L,
        9765625L,
        48828125L,
        244140625L,
        1220703125L,
        6103515625L,
        30517578125L,
        152587890625L,
        762939453125L,
        3814697265625L,
        19073486328125L,
        95367431640625L,
        476837158203125L,
        2384185791015625L,
        11920928955078125L,
        59604644775390625L,
        298023223876953125L,
        1490116119384765625L,
        7450580596923828125L, };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.637 -0400", hash_original_field = "BE202B01F91923E667B3B16B069D07DC", hash_generated_field = "FD0F7EAC9A9246982008521CC29799A7")

    private static final int[] LONG_FIVE_POW_BIT_LENGTH = new int[LONG_FIVE_POW.length];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.637 -0400", hash_original_field = "157379F1EEDF7417D34D4EA991CF2184", hash_generated_field = "9DFBCE8298EAB00B86718FC0B2D88337")

    private static final int[] LONG_POWERS_OF_TEN_BIT_LENGTH = new int[MathUtils.LONG_POWERS_OF_TEN.length];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.637 -0400", hash_original_field = "921789C958D668713F05F9FFE836B8C7", hash_generated_field = "E22EB04741B2BFD88E960FE524D60B1A")

    private static final int BI_SCALED_BY_ZERO_LENGTH = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.638 -0400", hash_original_field = "717A7640C2D9003B18C4055EC0C50419", hash_generated_field = "5B020D40BF07C0EC94E4149184B70A65")

    private static final BigDecimal[] BI_SCALED_BY_ZERO = new BigDecimal[BI_SCALED_BY_ZERO_LENGTH];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.638 -0400", hash_original_field = "39586D78C45D7A19439688292151133A", hash_generated_field = "5C08AD19ABFF43369109F8D9272F2B04")

    private static final BigDecimal[] ZERO_SCALED_BY = new BigDecimal[11];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.638 -0400", hash_original_field = "94F236C8393993A7B9287704666BFBEE", hash_generated_field = "12A340B61FB03C00F6D04EBF43FAFF99")

    private static final char[] CH_ZEROS = new char[100];
    static {
        Arrays.fill(CH_ZEROS, '0');
        for (int i = 0; i < ZERO_SCALED_BY.length; ++i) {
            BI_SCALED_BY_ZERO[i] = new BigDecimal(i, 0);
            ZERO_SCALED_BY[i] = new BigDecimal(0, i);
        }
        for (int i = 0; i < LONG_FIVE_POW_BIT_LENGTH.length; ++i) {
            LONG_FIVE_POW_BIT_LENGTH[i] = bitLength(LONG_FIVE_POW[i]);
        }
        for (int i = 0; i < LONG_POWERS_OF_TEN_BIT_LENGTH.length; ++i) {
            LONG_POWERS_OF_TEN_BIT_LENGTH[i] = bitLength(MathUtils.LONG_POWERS_OF_TEN[i]);
        }
        TEN_POW = Multiplication.bigTenPows;
        FIVE_POW = Multiplication.bigFivePows;
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.638 -0400", hash_original_field = "B1F433B3E708BA2079293308D7CA4999", hash_generated_field = "E2BD5BBDB2DF3AE4973FDC84A00AF40A")

    public static final BigDecimal ZERO = new BigDecimal(0, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.638 -0400", hash_original_field = "3A7ACF4CD264E65305ECE3D1A439ECF7", hash_generated_field = "9F34079F2BD32FDD32B17DD6B2BC0759")

    public static final BigDecimal ONE = new BigDecimal(1, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.638 -0400", hash_original_field = "831A4D5A2871A70F006594FB3523DE19", hash_generated_field = "7D43F273171CCD7BF176CC18D6BEE813")

    public static final BigDecimal TEN = new BigDecimal(10, 0);
}

