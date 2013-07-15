package java.math;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import libcore.math.MathUtils;

public class BigDecimal extends Number implements Comparable<BigDecimal>, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.560 -0400", hash_original_field = "0A495C22CEE2486109FF49D52FAB7401", hash_generated_field = "326D03DFD6F64D4B3F1173FBD427B520")

    private transient String toStringImage = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.561 -0400", hash_original_field = "B81E47D2AA677809E4BE3C9232B2407F", hash_generated_field = "3D9A07F218385AD7A5B345B923EAF46E")

    private transient int hashCode = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.561 -0400", hash_original_field = "3A1F983ED27316FA36EAAFE36DA5649F", hash_generated_field = "E1C21CCC8969038A086EDD16030014B8")

    private BigInteger intVal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.561 -0400", hash_original_field = "B35AD5BAFCCD957A930C16D5DD131EE4", hash_generated_field = "1C841931B61AD9BC0EB5C76BA4219E64")

    private transient int bitLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.561 -0400", hash_original_field = "412477B04CAB5EE326327BE6C10454DF", hash_generated_field = "27339F171BD0CF229BCBE4E7356A5F0B")

    private transient long smallValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.561 -0400", hash_original_field = "0CB47AEB6E5F9323F0969E628C4E59F5", hash_generated_field = "F9D5D1CA2ABDD82810FF1FE80E0268E6")

    private int scale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.562 -0400", hash_original_field = "46C2159C904EABF687686166E93B72AA", hash_generated_field = "4E7D370BAE76B07332BBBB929C2DF340")

    private transient int precision = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.563 -0400", hash_original_method = "6BC27F867C09C0249873A4D338F8666D", hash_generated_method = "675ADE6C6F01FF4ED08427C7FC23A83B")
    private  BigDecimal(long smallValue, int scale) {
        this.smallValue = smallValue;
        this.scale = scale;
        this.bitLength = bitLength(smallValue);
        // ---------- Original Method ----------
        //this.smallValue = smallValue;
        //this.scale = scale;
        //this.bitLength = bitLength(smallValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.564 -0400", hash_original_method = "9F6CD654516DCD03F33530EDCF81D84D", hash_generated_method = "3DC98F1132A232115D5983B57B665BF0")
    private  BigDecimal(int smallValue, int scale) {
        this.smallValue = smallValue;
        this.scale = scale;
        this.bitLength = bitLength(smallValue);
        // ---------- Original Method ----------
        //this.smallValue = smallValue;
        //this.scale = scale;
        //this.bitLength = bitLength(smallValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.566 -0400", hash_original_method = "374C425CF4086C798A21EEA670343536", hash_generated_method = "A7AE5B589CBF39DA6B5A4657DA2B485C")
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
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_230934055 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_230934055.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_230934055;
        } //End block
    if((last >= in.length) || (offset < 0) || (len <= 0) || (last < 0))        
        {
            NumberFormatException varAAEF0009D42EC95914540CC09A7820A8_1125924011 = new NumberFormatException("Bad offset/length: offset=" + offset +
                    " len=" + len + " in.length=" + in.length);
            varAAEF0009D42EC95914540CC09A7820A8_1125924011.addTaint(taint);
            throw varAAEF0009D42EC95914540CC09A7820A8_1125924011;
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
                NumberFormatException var5CC2BE7BB2549E36BE8412551FCA65A3_1364214232 = new NumberFormatException("Scale out of range");
                var5CC2BE7BB2549E36BE8412551FCA65A3_1364214232.addTaint(taint);
                throw var5CC2BE7BB2549E36BE8412551FCA65A3_1364214232;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.568 -0400", hash_original_method = "021DB19003FFCB38960FC53E0DB20D11", hash_generated_method = "6EA90666D1CAF03400C0CFC3D6B3005E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.568 -0400", hash_original_method = "2CA49E7A005F756FE298C75D3E276FBD", hash_generated_method = "B4FD1176C71EA8991071A29C074F944A")
    public  BigDecimal(char[] in) {
        this(in, 0, in.length);
        addTaint(in[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.569 -0400", hash_original_method = "24A3A809E90D8D728111B1E9DFB6AE2B", hash_generated_method = "003A1CBC3DF4748A413346F98A116CAD")
    public  BigDecimal(char[] in, MathContext mc) {
        this(in, 0, in.length);
        addTaint(mc.getTaint());
        addTaint(in[0]);
        inplaceRound(mc);
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.569 -0400", hash_original_method = "97883F5F25D8C2D5B9EC2501AC7ECDA2", hash_generated_method = "F8C02FFBA49B73A7A22E83CA112803F6")
    public  BigDecimal(String val) {
        this(val.toCharArray(), 0, val.length());
        addTaint(val.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.569 -0400", hash_original_method = "65FA78E7CB5F82CDA77BAA4B434CD165", hash_generated_method = "C6CF09061D87965AB685D6E3C6C70502")
    public  BigDecimal(String val, MathContext mc) {
        this(val.toCharArray(), 0, val.length());
        addTaint(mc.getTaint());
        addTaint(val.getTaint());
        inplaceRound(mc);
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.572 -0400", hash_original_method = "A550123107439183BDAF78BFBC33380D", hash_generated_method = "B47384F62B2FD6F3986613710EC9745E")
    public  BigDecimal(double val) {
        addTaint(val);
    if(Double.isInfinite(val) || Double.isNaN(val))        
        {
            NumberFormatException var3E59A98DA4169D0690D22CFC24A27713_1201247146 = new NumberFormatException("Infinity or NaN: " + val);
            var3E59A98DA4169D0690D22CFC24A27713_1201247146.addTaint(taint);
            throw var3E59A98DA4169D0690D22CFC24A27713_1201247146;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.573 -0400", hash_original_method = "A301A521891A68A20E545213C1CF7F7F", hash_generated_method = "795441CAE659A8DAD7CFEBC298E96E6A")
    public  BigDecimal(double val, MathContext mc) {
        this(val);
        addTaint(mc.getTaint());
        addTaint(val);
        inplaceRound(mc);
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.573 -0400", hash_original_method = "35103202AC4D8227390F065BF679C471", hash_generated_method = "D504D0B814354DD64C3D66DE08011646")
    public  BigDecimal(BigInteger val) {
        this(val, 0);
        addTaint(val.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.573 -0400", hash_original_method = "4DD15F45D533F2889A2A72BE2BF675A6", hash_generated_method = "41EA77FB9F894AFE7ED5FEE5B9D530AB")
    public  BigDecimal(BigInteger val, MathContext mc) {
        this(val);
        addTaint(mc.getTaint());
        addTaint(val.getTaint());
        inplaceRound(mc);
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.574 -0400", hash_original_method = "E5BF86952E31D522F2FAABCF30464562", hash_generated_method = "9081881F98A86D531988A6F7ACEC9F2C")
    public  BigDecimal(BigInteger unscaledVal, int scale) {
        addTaint(unscaledVal.getTaint());
    if(unscaledVal == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_845926816 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_845926816.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_845926816;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.574 -0400", hash_original_method = "59F34EC0A04F061EC6FA9A9EFC322A4C", hash_generated_method = "7A740693F0C00529EF1F7D48CB20A65F")
    public  BigDecimal(BigInteger unscaledVal, int scale, MathContext mc) {
        this(unscaledVal, scale);
        addTaint(mc.getTaint());
        addTaint(scale);
        addTaint(unscaledVal.getTaint());
        inplaceRound(mc);
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.575 -0400", hash_original_method = "5359C9BE484C4A97ECD231D115B1BCDB", hash_generated_method = "D648D7F23799D878CE7DE9DEA41AED6E")
    public  BigDecimal(int val) {
        this(val,0);
        addTaint(val);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.575 -0400", hash_original_method = "919820155B3DF9AD0A8E776AC27BF824", hash_generated_method = "AFC7448519945F4B1F353BEBE5A3926C")
    public  BigDecimal(int val, MathContext mc) {
        this(val,0);
        addTaint(mc.getTaint());
        addTaint(val);
        inplaceRound(mc);
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.576 -0400", hash_original_method = "3B8082CDF108D6321820C9FA6A6A1D42", hash_generated_method = "5CD5A0914C8C99DBF87C1115B74C5DD3")
    public  BigDecimal(long val) {
        this(val,0);
        addTaint(val);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.576 -0400", hash_original_method = "E0851629E0BD0FDB6233816479A7E4A8", hash_generated_method = "E5D91C59CD5A78C99046DC7DF747470E")
    public  BigDecimal(long val, MathContext mc) {
        this(val);
        addTaint(mc.getTaint());
        addTaint(val);
        inplaceRound(mc);
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
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

    
        public static BigDecimal valueOf(long unscaledVal) {
        if ((unscaledVal >= 0) && (unscaledVal < BI_SCALED_BY_ZERO_LENGTH)) {
            return BI_SCALED_BY_ZERO[(int)unscaledVal];
        }
        return new BigDecimal(unscaledVal,0);
    }

    
        public static BigDecimal valueOf(double val) {
        if (Double.isInfinite(val) || Double.isNaN(val)) {
            throw new NumberFormatException("Infinity or NaN: " + val);
        }
        return new BigDecimal(Double.toString(val));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.577 -0400", hash_original_method = "1DCD141A7D54B6C70CB155CC6BA0AB13", hash_generated_method = "18C08C08F92E410C0C9E828979B206F8")
    public BigDecimal add(BigDecimal augend) {
        addTaint(augend.getTaint());
        int diffScale = this.scale - augend.scale;
    if(this.isZero())        
        {
    if(diffScale <= 0)            
            {
BigDecimal var408B19472C5B3FCFC50773687B4FC449_261876730 =                 augend;
                var408B19472C5B3FCFC50773687B4FC449_261876730.addTaint(taint);
                return var408B19472C5B3FCFC50773687B4FC449_261876730;
            } //End block
    if(augend.isZero())            
            {
BigDecimal var72A74007B2BE62B849F475C7BDA4658B_1417813233 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_1417813233.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_1417813233;
            } //End block
        } //End block
        else
    if(augend.isZero())        
        {
    if(diffScale >= 0)            
            {
BigDecimal var72A74007B2BE62B849F475C7BDA4658B_431475046 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_431475046.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_431475046;
            } //End block
        } //End block
    if(diffScale == 0)        
        {
    if(Math.max(this.bitLength, augend.bitLength) + 1 < 64)            
            {
BigDecimal varC29A5D28FDF467EA81BC878EFB41BE62_1746781560 =                 valueOf(this.smallValue + augend.smallValue, this.scale);
                varC29A5D28FDF467EA81BC878EFB41BE62_1746781560.addTaint(taint);
                return varC29A5D28FDF467EA81BC878EFB41BE62_1746781560;
            } //End block
BigDecimal var3B6F0CDD20C8378417204A394489CAC7_1954889466 =             new BigDecimal(this.getUnscaledValue().add(augend.getUnscaledValue()), this.scale);
            var3B6F0CDD20C8378417204A394489CAC7_1954889466.addTaint(taint);
            return var3B6F0CDD20C8378417204A394489CAC7_1954889466;
        } //End block
        else
    if(diffScale > 0)        
        {
BigDecimal varAA3782623FE5347A02582E3FC9AEFC56_2017164227 =             addAndMult10(this, augend, diffScale);
            varAA3782623FE5347A02582E3FC9AEFC56_2017164227.addTaint(taint);
            return varAA3782623FE5347A02582E3FC9AEFC56_2017164227;
        } //End block
        else
        {
BigDecimal varAA3EB47E36541685CC2623C1EC32ACA4_489726865 =             addAndMult10(augend, this, -diffScale);
            varAA3EB47E36541685CC2623C1EC32ACA4_489726865.addTaint(taint);
            return varAA3EB47E36541685CC2623C1EC32ACA4_489726865;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.580 -0400", hash_original_method = "37BDD6EE07613654EB8729406017A0AF", hash_generated_method = "4B68CEC0FF4316F62D6EB84FDD5B3474")
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
BigDecimal var20E40D3A180C61896F40B4FF11E1B4C7_1359479203 =             add(augend).round(mc);
            var20E40D3A180C61896F40B4FF11E1B4C7_1359479203.addTaint(taint);
            return var20E40D3A180C61896F40B4FF11E1B4C7_1359479203;
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
BigDecimal var20E40D3A180C61896F40B4FF11E1B4C7_1828555733 =             add(augend).round(mc);
            var20E40D3A180C61896F40B4FF11E1B4C7_1828555733.addTaint(taint);
            return var20E40D3A180C61896F40B4FF11E1B4C7_1828555733;
        } //End block
    if(mc.getPrecision() >= larger.approxPrecision())        
        {
BigDecimal var20E40D3A180C61896F40B4FF11E1B4C7_1526844804 =             add(augend).round(mc);
            var20E40D3A180C61896F40B4FF11E1B4C7_1526844804.addTaint(taint);
            return var20E40D3A180C61896F40B4FF11E1B4C7_1526844804;
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
BigDecimal var85AAE8429AFD0DC703FB3DD23498E04D_1234542802 =         larger.round(mc);
        var85AAE8429AFD0DC703FB3DD23498E04D_1234542802.addTaint(taint);
        return var85AAE8429AFD0DC703FB3DD23498E04D_1234542802;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.581 -0400", hash_original_method = "463B27AE9A4331C20782D4CCC2226F12", hash_generated_method = "6E1AC7F7A48782E323A3888841DC1CF2")
    public BigDecimal subtract(BigDecimal subtrahend) {
        addTaint(subtrahend.getTaint());
        int diffScale = this.scale - subtrahend.scale;
    if(this.isZero())        
        {
    if(diffScale <= 0)            
            {
BigDecimal var20CB7E4994F478F2FA990ABC4FC7E9E2_1076691533 =                 subtrahend.negate();
                var20CB7E4994F478F2FA990ABC4FC7E9E2_1076691533.addTaint(taint);
                return var20CB7E4994F478F2FA990ABC4FC7E9E2_1076691533;
            } //End block
    if(subtrahend.isZero())            
            {
BigDecimal var72A74007B2BE62B849F475C7BDA4658B_941411207 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_941411207.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_941411207;
            } //End block
        } //End block
        else
    if(subtrahend.isZero())        
        {
    if(diffScale >= 0)            
            {
BigDecimal var72A74007B2BE62B849F475C7BDA4658B_161039948 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_161039948.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_161039948;
            } //End block
        } //End block
    if(diffScale == 0)        
        {
    if(Math.max(this.bitLength, subtrahend.bitLength) + 1 < 64)            
            {
BigDecimal var4205EF116A00E778C0B3349717F48B49_697531877 =                 valueOf(this.smallValue - subtrahend.smallValue,this.scale);
                var4205EF116A00E778C0B3349717F48B49_697531877.addTaint(taint);
                return var4205EF116A00E778C0B3349717F48B49_697531877;
            } //End block
BigDecimal var790A17466751017D9F7E25BBDC99AFE3_420876021 =             new BigDecimal(this.getUnscaledValue().subtract(subtrahend.getUnscaledValue()), this.scale);
            var790A17466751017D9F7E25BBDC99AFE3_420876021.addTaint(taint);
            return var790A17466751017D9F7E25BBDC99AFE3_420876021;
        } //End block
        else
    if(diffScale > 0)        
        {
    if(diffScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                    Math.max(this.bitLength,subtrahend.bitLength+LONG_POWERS_OF_TEN_BIT_LENGTH[diffScale])+1<64)            
            {
BigDecimal var7C3E910EA26DCC86661FD9754DC625C0_1725420557 =                 valueOf(this.smallValue-subtrahend.smallValue*MathUtils.LONG_POWERS_OF_TEN[diffScale],this.scale);
                var7C3E910EA26DCC86661FD9754DC625C0_1725420557.addTaint(taint);
                return var7C3E910EA26DCC86661FD9754DC625C0_1725420557;
            } //End block
BigDecimal var15D9019C49E0B547E9298CE56667BC02_962030283 =             new BigDecimal(this.getUnscaledValue().subtract(
                    Multiplication.multiplyByTenPow(subtrahend.getUnscaledValue(),diffScale)), this.scale);
            var15D9019C49E0B547E9298CE56667BC02_962030283.addTaint(taint);
            return var15D9019C49E0B547E9298CE56667BC02_962030283;
        } //End block
        else
        {
            diffScale = -diffScale;
    if(diffScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                    Math.max(this.bitLength+LONG_POWERS_OF_TEN_BIT_LENGTH[diffScale],subtrahend.bitLength)+1<64)            
            {
BigDecimal varDC58FD3A05E933CD46CF8827177D6A0D_753789600 =                 valueOf(this.smallValue*MathUtils.LONG_POWERS_OF_TEN[diffScale]-subtrahend.smallValue,subtrahend.scale);
                varDC58FD3A05E933CD46CF8827177D6A0D_753789600.addTaint(taint);
                return varDC58FD3A05E933CD46CF8827177D6A0D_753789600;
            } //End block
BigDecimal var0357B328C12B82C4DC6697F3D0056D8B_721225026 =             new BigDecimal(Multiplication.multiplyByTenPow(this.getUnscaledValue(),diffScale)
            .subtract(subtrahend.getUnscaledValue()), subtrahend.scale);
            var0357B328C12B82C4DC6697F3D0056D8B_721225026.addTaint(taint);
            return var0357B328C12B82C4DC6697F3D0056D8B_721225026;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.583 -0400", hash_original_method = "427D658D2E18BC359A41906DA92107B2", hash_generated_method = "20D8216BBF2ED514C77E94827580CB4F")
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
BigDecimal var4481336689B89E473DC6E06151513A25_912506842 =             subtract(subtrahend).round(mc);
            var4481336689B89E473DC6E06151513A25_912506842.addTaint(taint);
            return var4481336689B89E473DC6E06151513A25_912506842;
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
BigDecimal var9E01B144E29749864BF254E9E9C2A256_328819746 =                 leftOperand.round(mc);
                var9E01B144E29749864BF254E9E9C2A256_328819746.addTaint(taint);
                return var9E01B144E29749864BF254E9E9C2A256_328819746;
            } //End block
        } //End block
BigDecimal var4481336689B89E473DC6E06151513A25_489351164 =         subtract(subtrahend).round(mc);
        var4481336689B89E473DC6E06151513A25_489351164.addTaint(taint);
        return var4481336689B89E473DC6E06151513A25_489351164;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.583 -0400", hash_original_method = "0CD1948BD2366020AE6A84C7902D73D6", hash_generated_method = "ED2AEB2E56A29152E543ECFB855446DD")
    public BigDecimal multiply(BigDecimal multiplicand) {
        addTaint(multiplicand.getTaint());
        long newScale = (long)this.scale + multiplicand.scale;
    if((this.isZero()) || (multiplicand.isZero()))        
        {
BigDecimal varE59C58B2F93F3B07BADE839AC0BAC55B_137402009 =             zeroScaledBy(newScale);
            varE59C58B2F93F3B07BADE839AC0BAC55B_137402009.addTaint(taint);
            return varE59C58B2F93F3B07BADE839AC0BAC55B_137402009;
        } //End block
    if(this.bitLength + multiplicand.bitLength < 64)        
        {
BigDecimal var737034098D95ED0FC63A7DF773CD73FD_73174878 =             valueOf(this.smallValue*multiplicand.smallValue, safeLongToInt(newScale));
            var737034098D95ED0FC63A7DF773CD73FD_73174878.addTaint(taint);
            return var737034098D95ED0FC63A7DF773CD73FD_73174878;
        } //End block
BigDecimal var3F964FE42BAEC76AB0D169D386269642_1124316862 =         new BigDecimal(this.getUnscaledValue().multiply(
                multiplicand.getUnscaledValue()), safeLongToInt(newScale));
        var3F964FE42BAEC76AB0D169D386269642_1124316862.addTaint(taint);
        return var3F964FE42BAEC76AB0D169D386269642_1124316862;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.584 -0400", hash_original_method = "C6525DC236CD6C9B7DA82BBF840C4183", hash_generated_method = "305AC5350E9BFDF181876AE7D980BE9E")
    public BigDecimal multiply(BigDecimal multiplicand, MathContext mc) {
        addTaint(mc.getTaint());
        addTaint(multiplicand.getTaint());
        BigDecimal result = multiply(multiplicand);
        result.inplaceRound(mc);
BigDecimal varDC838461EE2FA0CA4C9BBB70A15456B0_1770069779 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1770069779.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1770069779;
        // ---------- Original Method ----------
        //BigDecimal result = multiply(multiplicand);
        //result.inplaceRound(mc);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.584 -0400", hash_original_method = "462A8C7DE00EC7C78FAA3F28B925453C", hash_generated_method = "F71BA99B7E177687AB1A7A8E4DB7B7A5")
    public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode) {
        addTaint(roundingMode);
        addTaint(scale);
        addTaint(divisor.getTaint());
BigDecimal varBA9719B24DF54089903C79918220E383_1729980960 =         divide(divisor, scale, RoundingMode.valueOf(roundingMode));
        varBA9719B24DF54089903C79918220E383_1729980960.addTaint(taint);
        return varBA9719B24DF54089903C79918220E383_1729980960;
        // ---------- Original Method ----------
        //return divide(divisor, scale, RoundingMode.valueOf(roundingMode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.585 -0400", hash_original_method = "CAF40474AE4670E1A6482892323F28CB", hash_generated_method = "A7D414C9FD44A0DA38F078E21BF888C6")
    public BigDecimal divide(BigDecimal divisor, int scale, RoundingMode roundingMode) {
        addTaint(roundingMode.getTaint());
        addTaint(scale);
        addTaint(divisor.getTaint());
    if(roundingMode == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1072677447 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1072677447.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1072677447;
        } //End block
    if(divisor.isZero())        
        {
            ArithmeticException var8232FF584263005EDE3503FB2494EECC_304358608 = new ArithmeticException("Division by zero");
            var8232FF584263005EDE3503FB2494EECC_304358608.addTaint(taint);
            throw var8232FF584263005EDE3503FB2494EECC_304358608;
        } //End block
        long diffScale = ((long)this.scale - divisor.scale) - scale;
    if(this.bitLength < 64 && divisor.bitLength < 64)        
        {
    if(diffScale == 0)            
            {
BigDecimal varA1F4C614F572240C11899F668DB0D55E_1978446712 =                 dividePrimitiveLongs(this.smallValue,
                        divisor.smallValue,
                        scale,
                        roundingMode );
                varA1F4C614F572240C11899F668DB0D55E_1978446712.addTaint(taint);
                return varA1F4C614F572240C11899F668DB0D55E_1978446712;
            } //End block
            else
    if(diffScale > 0)            
            {
    if(diffScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                        divisor.bitLength + LONG_POWERS_OF_TEN_BIT_LENGTH[(int)diffScale] < 64)                
                {
BigDecimal varAC9EC2469B7198582C29A1B0D39CDA9C_843392573 =                     dividePrimitiveLongs(this.smallValue,
                            divisor.smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)diffScale],
                            scale,
                            roundingMode);
                    varAC9EC2469B7198582C29A1B0D39CDA9C_843392573.addTaint(taint);
                    return varAC9EC2469B7198582C29A1B0D39CDA9C_843392573;
                } //End block
            } //End block
            else
            {
    if(-diffScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                        this.bitLength + LONG_POWERS_OF_TEN_BIT_LENGTH[(int)-diffScale] < 64)                
                {
BigDecimal varCE8CA12CD95E2FB8CD14FD3D265A5A0A_468191479 =                     dividePrimitiveLongs(this.smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)-diffScale],
                            divisor.smallValue,
                            scale,
                            roundingMode);
                    varCE8CA12CD95E2FB8CD14FD3D265A5A0A_468191479.addTaint(taint);
                    return varCE8CA12CD95E2FB8CD14FD3D265A5A0A_468191479;
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
BigDecimal varF6C63A795D53A996135BB70BCA9E6E0B_1898237603 =         divideBigIntegers(scaledDividend, scaledDivisor, scale, roundingMode);
        varF6C63A795D53A996135BB70BCA9E6E0B_1898237603.addTaint(taint);
        return varF6C63A795D53A996135BB70BCA9E6E0B_1898237603;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.587 -0400", hash_original_method = "2C6660A6ECCA62927D6A6B71E8D4804F", hash_generated_method = "3555A34010E1B71636892A36CF6B3C3D")
    public BigDecimal divide(BigDecimal divisor, int roundingMode) {
        addTaint(roundingMode);
        addTaint(divisor.getTaint());
BigDecimal varBA9719B24DF54089903C79918220E383_779172636 =         divide(divisor, scale, RoundingMode.valueOf(roundingMode));
        varBA9719B24DF54089903C79918220E383_779172636.addTaint(taint);
        return varBA9719B24DF54089903C79918220E383_779172636;
        // ---------- Original Method ----------
        //return divide(divisor, scale, RoundingMode.valueOf(roundingMode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.588 -0400", hash_original_method = "5F1D784ACEFAF8C3A3D46632D71C7A92", hash_generated_method = "5EDFCDD7A5A26E31E5AD88505D6FEA1D")
    public BigDecimal divide(BigDecimal divisor, RoundingMode roundingMode) {
        addTaint(roundingMode.getTaint());
        addTaint(divisor.getTaint());
BigDecimal varD4989E9F927A2A4FAB7F073D2585164F_778606938 =         divide(divisor, scale, roundingMode);
        varD4989E9F927A2A4FAB7F073D2585164F_778606938.addTaint(taint);
        return varD4989E9F927A2A4FAB7F073D2585164F_778606938;
        // ---------- Original Method ----------
        //return divide(divisor, scale, roundingMode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.590 -0400", hash_original_method = "A7E2E0DD5FAFAFB93C0707787850F19F", hash_generated_method = "FB866F550F70803787DBB7DDF4EFF358")
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
            ArithmeticException var8232FF584263005EDE3503FB2494EECC_1464350179 = new ArithmeticException("Division by zero");
            var8232FF584263005EDE3503FB2494EECC_1464350179.addTaint(taint);
            throw var8232FF584263005EDE3503FB2494EECC_1464350179;
        } //End block
    if(p.signum() == 0)        
        {
BigDecimal var277AAF866E1EF31575126210EC839CAB_1016322854 =             zeroScaledBy(diffScale);
            var277AAF866E1EF31575126210EC839CAB_1016322854.addTaint(taint);
            return var277AAF866E1EF31575126210EC839CAB_1016322854;
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
            ArithmeticException var5490C747F55608EDD43F4C0EE6D94910_1367078849 = new ArithmeticException("Non-terminating decimal expansion; no exact representable decimal result");
            var5490C747F55608EDD43F4C0EE6D94910_1367078849.addTaint(taint);
            throw var5490C747F55608EDD43F4C0EE6D94910_1367078849;
        } //End block
    if(q.signum() < 0)        
        {
            p = p.negate();
        } //End block
        newScale = safeLongToInt(diffScale + Math.max(k, l));
        i = k - l;
        p = (i > 0) ? Multiplication.multiplyByFivePow(p, i)
        : p.shiftLeft(-i);
BigDecimal varD0644BCFD931415D27D5B4154667FE6D_1980514128 =         new BigDecimal(p, newScale);
        varD0644BCFD931415D27D5B4154667FE6D_1980514128.addTaint(taint);
        return varD0644BCFD931415D27D5B4154667FE6D_1980514128;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.593 -0400", hash_original_method = "E69AD17C16131904FF2F859BB6B8C3E0", hash_generated_method = "EB13F771923AA7024790BAECD60BE3FF")
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
BigDecimal varBA3F941531BC5E6E1960376988ED770D_1190559573 =             this.divide(divisor);
            varBA3F941531BC5E6E1960376988ED770D_1190559573.addTaint(taint);
            return varBA3F941531BC5E6E1960376988ED770D_1190559573;
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
BigDecimal var3AC7C1B712651F6BEB20B4A533A61659_2054078646 =         new BigDecimal(integerQuot, safeLongToInt(newScale), mc);
        var3AC7C1B712651F6BEB20B4A533A61659_2054078646.addTaint(taint);
        return var3AC7C1B712651F6BEB20B4A533A61659_2054078646;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.595 -0400", hash_original_method = "370FC7E5A1C86319865302EB832BE460", hash_generated_method = "7D1284B5061F4B9A904C0B427281E570")
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
            ArithmeticException var8232FF584263005EDE3503FB2494EECC_489515626 = new ArithmeticException("Division by zero");
            var8232FF584263005EDE3503FB2494EECC_489515626.addTaint(taint);
            throw var8232FF584263005EDE3503FB2494EECC_489515626;
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
BigDecimal var8CD0EAEFCB484EE00D372EAE56C5A002_44551790 =         ((integralValue.signum() == 0)
        ? zeroScaledBy(newScale)
                : new BigDecimal(integralValue, safeLongToInt(newScale)));
        var8CD0EAEFCB484EE00D372EAE56C5A002_44551790.addTaint(taint);
        return var8CD0EAEFCB484EE00D372EAE56C5A002_44551790;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.600 -0400", hash_original_method = "15ECC758BA9BF5EB2D64CC984DE4A4C9", hash_generated_method = "1F325E71C73F1CD3FB72788BABFE3AD6")
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
BigDecimal varF90F04B070151E626D75F40D8923223D_1869662433 =             this.divideToIntegralValue(divisor);
            varF90F04B070151E626D75F40D8923223D_1869662433.addTaint(taint);
            return varF90F04B070151E626D75F40D8923223D_1869662433;
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
                    ArithmeticException var53FA20AA5783266B1EC065CD5B879CF0_431558841 = new ArithmeticException("Division impossible");
                    var53FA20AA5783266B1EC065CD5B879CF0_431558841.addTaint(taint);
                    throw var53FA20AA5783266B1EC065CD5B879CF0_431558841;
                } //End block
            } //End block
        } //End block
    if(quotAndRem[0].signum() == 0)        
        {
BigDecimal var277AAF866E1EF31575126210EC839CAB_1160693565 =             zeroScaledBy(diffScale);
            var277AAF866E1EF31575126210EC839CAB_1160693565.addTaint(taint);
            return var277AAF866E1EF31575126210EC839CAB_1160693565;
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
            ArithmeticException var53FA20AA5783266B1EC065CD5B879CF0_698838553 = new ArithmeticException("Division impossible");
            var53FA20AA5783266B1EC065CD5B879CF0_698838553.addTaint(taint);
            throw var53FA20AA5783266B1EC065CD5B879CF0_698838553;
        } //End block
        integralValue.scale = safeLongToInt(newScale);
        integralValue.setUnscaledValue(strippedBI);
BigDecimal var6A7B4288ADCD69BF11ABA916220598AF_612873225 =         integralValue;
        var6A7B4288ADCD69BF11ABA916220598AF_612873225.addTaint(taint);
        return var6A7B4288ADCD69BF11ABA916220598AF_612873225;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.601 -0400", hash_original_method = "EBDBD1FB251B2EF1CF76CA97862E098F", hash_generated_method = "A86399D4007CD841A63FB644292447CE")
    public BigDecimal remainder(BigDecimal divisor) {
        addTaint(divisor.getTaint());
BigDecimal var8CBD704006853C12B2C3587D77D455B0_402838932 =         divideAndRemainder(divisor)[1];
        var8CBD704006853C12B2C3587D77D455B0_402838932.addTaint(taint);
        return var8CBD704006853C12B2C3587D77D455B0_402838932;
        // ---------- Original Method ----------
        //return divideAndRemainder(divisor)[1];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.601 -0400", hash_original_method = "B5D8082AFBB8A8B7919238963079BE8E", hash_generated_method = "BB68E9C3B9A4D01E00612AD12EDF39FA")
    public BigDecimal remainder(BigDecimal divisor, MathContext mc) {
        addTaint(mc.getTaint());
        addTaint(divisor.getTaint());
BigDecimal var255C2A159BF47AFDB531DC1FDA4FBDE3_1201619046 =         divideAndRemainder(divisor, mc)[1];
        var255C2A159BF47AFDB531DC1FDA4FBDE3_1201619046.addTaint(taint);
        return var255C2A159BF47AFDB531DC1FDA4FBDE3_1201619046;
        // ---------- Original Method ----------
        //return divideAndRemainder(divisor, mc)[1];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.602 -0400", hash_original_method = "078854E5024F03E2C96ABDC15A98EC28", hash_generated_method = "CB9DCFD4CD523A126D7B10002DE380A0")
    public BigDecimal[] divideAndRemainder(BigDecimal divisor) {
        addTaint(divisor.getTaint());
        BigDecimal quotAndRem[] = new BigDecimal[2];
        quotAndRem[0] = this.divideToIntegralValue(divisor);
        quotAndRem[1] = this.subtract( quotAndRem[0].multiply(divisor) );
BigDecimal[] var06CBC57291B9EBBB56A44DD63D3B6686_236117741 =         quotAndRem;
        var06CBC57291B9EBBB56A44DD63D3B6686_236117741.addTaint(taint);
        return var06CBC57291B9EBBB56A44DD63D3B6686_236117741;
        // ---------- Original Method ----------
        //BigDecimal quotAndRem[] = new BigDecimal[2];
        //quotAndRem[0] = this.divideToIntegralValue(divisor);
        //quotAndRem[1] = this.subtract( quotAndRem[0].multiply(divisor) );
        //return quotAndRem;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.602 -0400", hash_original_method = "36D2BD3305B7DD5EA1226F88EE4D6B60", hash_generated_method = "54E797CB22AB9089AE72BC9E88CAA7D1")
    public BigDecimal[] divideAndRemainder(BigDecimal divisor, MathContext mc) {
        addTaint(mc.getTaint());
        addTaint(divisor.getTaint());
        BigDecimal quotAndRem[] = new BigDecimal[2];
        quotAndRem[0] = this.divideToIntegralValue(divisor, mc);
        quotAndRem[1] = this.subtract( quotAndRem[0].multiply(divisor) );
BigDecimal[] var06CBC57291B9EBBB56A44DD63D3B6686_1857063800 =         quotAndRem;
        var06CBC57291B9EBBB56A44DD63D3B6686_1857063800.addTaint(taint);
        return var06CBC57291B9EBBB56A44DD63D3B6686_1857063800;
        // ---------- Original Method ----------
        //BigDecimal quotAndRem[] = new BigDecimal[2];
        //quotAndRem[0] = this.divideToIntegralValue(divisor, mc);
        //quotAndRem[1] = this.subtract( quotAndRem[0].multiply(divisor) );
        //return quotAndRem;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.603 -0400", hash_original_method = "0BA2A5CD46D450D69AC19365E08D7C5C", hash_generated_method = "5A114687E4B73846D328615C20692D7B")
    public BigDecimal pow(int n) {
        addTaint(n);
    if(n == 0)        
        {
BigDecimal varBAE09D6A693103980CCD98582008583B_1388957863 =             ONE;
            varBAE09D6A693103980CCD98582008583B_1388957863.addTaint(taint);
            return varBAE09D6A693103980CCD98582008583B_1388957863;
        } //End block
    if((n < 0) || (n > 999999999))        
        {
            ArithmeticException var0D4D59570E4E5191698B488830D15716_656169487 = new ArithmeticException("Invalid operation");
            var0D4D59570E4E5191698B488830D15716_656169487.addTaint(taint);
            throw var0D4D59570E4E5191698B488830D15716_656169487;
        } //End block
        long newScale = scale * (long)n;
BigDecimal var2CE28CE1CD1304A24D1EA5E44DCD3B2E_961895755 =         isZero() ? zeroScaledBy(newScale)
                : new BigDecimal(getUnscaledValue().pow(n), safeLongToInt(newScale));
        var2CE28CE1CD1304A24D1EA5E44DCD3B2E_961895755.addTaint(taint);
        return var2CE28CE1CD1304A24D1EA5E44DCD3B2E_961895755;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.604 -0400", hash_original_method = "C8938AEDE89231C5AAB8CE41C7A1DE59", hash_generated_method = "3557569CF9D039D0669F656789C518F5")
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
BigDecimal var8CBFE70F915191D2B08C03E09264D484_1391450892 =             pow(n);
            var8CBFE70F915191D2B08C03E09264D484_1391450892.addTaint(taint);
            return var8CBFE70F915191D2B08C03E09264D484_1391450892;
        } //End block
    if((m > 999999999) || ((mcPrecision == 0) && (n < 0))
                || ((mcPrecision > 0) && (elength > mcPrecision)))        
        {
            ArithmeticException var0D4D59570E4E5191698B488830D15716_279185447 = new ArithmeticException("Invalid operation");
            var0D4D59570E4E5191698B488830D15716_279185447.addTaint(taint);
            throw var0D4D59570E4E5191698B488830D15716_279185447;
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
BigDecimal var3E2E0393E92029AC9F8EC9F2D778D7A4_234011335 =         accum;
        var3E2E0393E92029AC9F8EC9F2D778D7A4_234011335.addTaint(taint);
        return var3E2E0393E92029AC9F8EC9F2D778D7A4_234011335;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.604 -0400", hash_original_method = "DF1CB3D65F2CAE136A2978BF9C5604B4", hash_generated_method = "651E251778B0190C9B19627AA689E72A")
    public BigDecimal abs() {
BigDecimal var3E2BA03AB8CD54396BA9F03BD8DE54CD_1592880982 =         ((signum() < 0) ? negate() : this);
        var3E2BA03AB8CD54396BA9F03BD8DE54CD_1592880982.addTaint(taint);
        return var3E2BA03AB8CD54396BA9F03BD8DE54CD_1592880982;
        // ---------- Original Method ----------
        //return ((signum() < 0) ? negate() : this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.604 -0400", hash_original_method = "BC934B9214C4819E6720F567E9C870B9", hash_generated_method = "C026F7DC571E7A5D7A65B931D8565A43")
    public BigDecimal abs(MathContext mc) {
        addTaint(mc.getTaint());
        BigDecimal result = abs();
        result.inplaceRound(mc);
BigDecimal varDC838461EE2FA0CA4C9BBB70A15456B0_1039880746 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1039880746.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1039880746;
        // ---------- Original Method ----------
        //BigDecimal result = abs();
        //result.inplaceRound(mc);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.604 -0400", hash_original_method = "434D4E2CBF9E3CBC75126AF4586B2CF0", hash_generated_method = "C93D27D7928BFB90C7717FBA303B2953")
    public BigDecimal negate() {
    if(bitLength < 63 || (bitLength == 63 && smallValue!=Long.MIN_VALUE))        
        {
BigDecimal var73E555E7A4D5749B540A5445821C9FE7_873970843 =             valueOf(-smallValue,scale);
            var73E555E7A4D5749B540A5445821C9FE7_873970843.addTaint(taint);
            return var73E555E7A4D5749B540A5445821C9FE7_873970843;
        } //End block
BigDecimal var187C2BDDBC5A501DDF5A20C3166229AA_909781512 =         new BigDecimal(getUnscaledValue().negate(), scale);
        var187C2BDDBC5A501DDF5A20C3166229AA_909781512.addTaint(taint);
        return var187C2BDDBC5A501DDF5A20C3166229AA_909781512;
        // ---------- Original Method ----------
        //if(bitLength < 63 || (bitLength == 63 && smallValue!=Long.MIN_VALUE)) {
            //return valueOf(-smallValue,scale);
        //}
        //return new BigDecimal(getUnscaledValue().negate(), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.605 -0400", hash_original_method = "1D24791EE4ADD6E04558F8C92319E898", hash_generated_method = "71E888910E869870E37CD0FA5C13EEB7")
    public BigDecimal negate(MathContext mc) {
        addTaint(mc.getTaint());
        BigDecimal result = negate();
        result.inplaceRound(mc);
BigDecimal varDC838461EE2FA0CA4C9BBB70A15456B0_2056697731 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_2056697731.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_2056697731;
        // ---------- Original Method ----------
        //BigDecimal result = negate();
        //result.inplaceRound(mc);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.605 -0400", hash_original_method = "E5A0BEEECFDAB0EB24F23ED92FDA1EE0", hash_generated_method = "D054CF740427237351894D09BF2AACF5")
    public BigDecimal plus() {
BigDecimal var72A74007B2BE62B849F475C7BDA4658B_566467994 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_566467994.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_566467994;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.605 -0400", hash_original_method = "06DE611812CE14E42B61206CBE361795", hash_generated_method = "B38D6C02427FFEDF49860DC2553BA438")
    public BigDecimal plus(MathContext mc) {
        addTaint(mc.getTaint());
BigDecimal var099658E03F9BF7D1563531EEEABC8E1F_1403421476 =         round(mc);
        var099658E03F9BF7D1563531EEEABC8E1F_1403421476.addTaint(taint);
        return var099658E03F9BF7D1563531EEEABC8E1F_1403421476;
        // ---------- Original Method ----------
        //return round(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.605 -0400", hash_original_method = "CA4E5917AFEF32459FAB7B79AFDA8BD4", hash_generated_method = "0F43CD36E69F1F9CFB63AD3AFC95B931")
    public int signum() {
    if(bitLength < 64)        
        {
            int varD9A9F07E76925BC510DC1A6A4A0DC45B_248370537 = (Long.signum( this.smallValue ));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1125758592 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1125758592;
        } //End block
        int var4B8344645A71978B6D1FD40497CCD683_393997490 = (getUnscaledValue().signum());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_954133548 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_954133548;
        // ---------- Original Method ----------
        //if( bitLength < 64) {
            //return Long.signum( this.smallValue );
        //}
        //return getUnscaledValue().signum();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.606 -0400", hash_original_method = "F3E74BAAEB162D78F28E445308393563", hash_generated_method = "7DE40A1BF1B2222C0C9FB7D66A84BE03")
    private boolean isZero() {
        boolean var82D0A726C120D5744FDF0390F9FF98A3_1406528649 = (bitLength == 0 && this.smallValue != -1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1669183692 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1669183692;
        // ---------- Original Method ----------
        //return bitLength == 0 && this.smallValue != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.606 -0400", hash_original_method = "5F6F67A9AE4AEECC5BD64D7ACC145B6A", hash_generated_method = "78CB80391EA8736C1EB6D0A6762F3DDA")
    public int scale() {
        int var0CB47AEB6E5F9323F0969E628C4E59F5_679016012 = (scale);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_733917555 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_733917555;
        // ---------- Original Method ----------
        //return scale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.606 -0400", hash_original_method = "6DFBDD0E771CAF738A0C801E888E1E3B", hash_generated_method = "15EAB8DBCBEC6C045990F9C0798756CB")
    public int precision() {
    if(precision > 0)        
        {
            int varE2794D8F12719281EFF5601251C8A680_733793312 = (precision);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2118929632 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2118929632;
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
        int varE2794D8F12719281EFF5601251C8A680_1730793865 = (precision);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1344951731 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1344951731;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.607 -0400", hash_original_method = "EAD040D94F5F819E555B537F69E87C66", hash_generated_method = "67F908A6AD4F957D37747CA2F32871DC")
    private int decimalDigitsInLong(long value) {
        addTaint(value);
    if(value == Long.MIN_VALUE)        
        {
            int var1F0E3DAD99908345F7439F8FFABDFFC4_720881160 = (19);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1630638052 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1630638052;
        } //End block
        else
        {
            int index = Arrays.binarySearch(MathUtils.LONG_POWERS_OF_TEN, Math.abs(value));
            int var389FD6ABBD36BA1BEEA459EFC729774A_1805902263 = ((index < 0) ? (-index - 1) : (index + 1));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_492317999 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_492317999;
        } //End block
        // ---------- Original Method ----------
        //if (value == Long.MIN_VALUE) {
            //return 19; 
        //} else {
            //int index = Arrays.binarySearch(MathUtils.LONG_POWERS_OF_TEN, Math.abs(value));
            //return (index < 0) ? (-index - 1) : (index + 1);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.607 -0400", hash_original_method = "067DA515CBCF3B72C5546CE6034B99CF", hash_generated_method = "5E559EB46972A0D8F6A81DC0179461AA")
    public BigInteger unscaledValue() {
BigInteger varC9F991BB5BE86225185B684B83A7B9ED_163105875 =         getUnscaledValue();
        varC9F991BB5BE86225185B684B83A7B9ED_163105875.addTaint(taint);
        return varC9F991BB5BE86225185B684B83A7B9ED_163105875;
        // ---------- Original Method ----------
        //return getUnscaledValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.608 -0400", hash_original_method = "2FC46B1D06394AF066FA7CDA852A22F8", hash_generated_method = "78B7F52AD7EB599321C4A433CDD88D43")
    public BigDecimal round(MathContext mc) {
        addTaint(mc.getTaint());
        BigDecimal thisBD = new BigDecimal(getUnscaledValue(), scale);
        thisBD.inplaceRound(mc);
BigDecimal varB72F00E59FE39C0D0346006335911BDC_1645485684 =         thisBD;
        varB72F00E59FE39C0D0346006335911BDC_1645485684.addTaint(taint);
        return varB72F00E59FE39C0D0346006335911BDC_1645485684;
        // ---------- Original Method ----------
        //BigDecimal thisBD = new BigDecimal(getUnscaledValue(), scale);
        //thisBD.inplaceRound(mc);
        //return thisBD;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.608 -0400", hash_original_method = "7B0F1A102C68137F597240860B4573E3", hash_generated_method = "4DACB8E621B2D66C4263FA7528B1B31B")
    public BigDecimal setScale(int newScale, RoundingMode roundingMode) {
        addTaint(roundingMode.getTaint());
        addTaint(newScale);
    if(roundingMode == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_48711323 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_48711323.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_48711323;
        } //End block
        long diffScale = newScale - (long)scale;
    if(diffScale == 0)        
        {
BigDecimal var72A74007B2BE62B849F475C7BDA4658B_484366785 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_484366785.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_484366785;
        } //End block
    if(diffScale > 0)        
        {
    if(diffScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                    (this.bitLength + LONG_POWERS_OF_TEN_BIT_LENGTH[(int)diffScale]) < 64)            
            {
BigDecimal var4C319D7509BAD3F87FD88EF0DDE3CF05_604073675 =                 valueOf(this.smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)diffScale],newScale);
                var4C319D7509BAD3F87FD88EF0DDE3CF05_604073675.addTaint(taint);
                return var4C319D7509BAD3F87FD88EF0DDE3CF05_604073675;
            } //End block
BigDecimal var879AE69C6F82455D75FF1571FFEBC63F_609595607 =             new BigDecimal(Multiplication.multiplyByTenPow(getUnscaledValue(),(int)diffScale), newScale);
            var879AE69C6F82455D75FF1571FFEBC63F_609595607.addTaint(taint);
            return var879AE69C6F82455D75FF1571FFEBC63F_609595607;
        } //End block
    if(this.bitLength < 64 && -diffScale < MathUtils.LONG_POWERS_OF_TEN.length)        
        {
BigDecimal var02425BF4EB44CC1AE5DA82EC99C07B32_75630413 =             dividePrimitiveLongs(this.smallValue, MathUtils.LONG_POWERS_OF_TEN[(int)-diffScale], newScale,roundingMode);
            var02425BF4EB44CC1AE5DA82EC99C07B32_75630413.addTaint(taint);
            return var02425BF4EB44CC1AE5DA82EC99C07B32_75630413;
        } //End block
BigDecimal varDD0B29B5503B4B9E4737410AAFF67D96_1116973603 =         divideBigIntegers(this.getUnscaledValue(),Multiplication.powerOf10(-diffScale),newScale,roundingMode);
        varDD0B29B5503B4B9E4737410AAFF67D96_1116973603.addTaint(taint);
        return varDD0B29B5503B4B9E4737410AAFF67D96_1116973603;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.609 -0400", hash_original_method = "82E5CBCA5195979E97780CEADBFBD3C4", hash_generated_method = "5AF9293C776DD5CFDB8CB1080CEB7A7D")
    public BigDecimal setScale(int newScale, int roundingMode) {
        addTaint(roundingMode);
        addTaint(newScale);
BigDecimal var3CB37F9DED08E643A7B23987C491C2AB_2045999616 =         setScale(newScale, RoundingMode.valueOf(roundingMode));
        var3CB37F9DED08E643A7B23987C491C2AB_2045999616.addTaint(taint);
        return var3CB37F9DED08E643A7B23987C491C2AB_2045999616;
        // ---------- Original Method ----------
        //return setScale(newScale, RoundingMode.valueOf(roundingMode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.609 -0400", hash_original_method = "ABCD452F1FC16ADBD3F58023EF098557", hash_generated_method = "4B8970FA227F05986CE01D34FB3C7947")
    public BigDecimal setScale(int newScale) {
        addTaint(newScale);
BigDecimal varA1157EE9F4212E9445297F359E13EBFE_1794820510 =         setScale(newScale, RoundingMode.UNNECESSARY);
        varA1157EE9F4212E9445297F359E13EBFE_1794820510.addTaint(taint);
        return varA1157EE9F4212E9445297F359E13EBFE_1794820510;
        // ---------- Original Method ----------
        //return setScale(newScale, RoundingMode.UNNECESSARY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.610 -0400", hash_original_method = "146C1C6822DF31E0F5C90B0C65347C9D", hash_generated_method = "CE6B52ED50FEB23F6DDB209BC96CCE68")
    public BigDecimal movePointLeft(int n) {
        addTaint(n);
BigDecimal var18B7F63A30DCEE38D3BB12F0A0E8352C_187684169 =         movePoint(scale + (long)n);
        var18B7F63A30DCEE38D3BB12F0A0E8352C_187684169.addTaint(taint);
        return var18B7F63A30DCEE38D3BB12F0A0E8352C_187684169;
        // ---------- Original Method ----------
        //return movePoint(scale + (long)n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.610 -0400", hash_original_method = "EF6481821B33DB93DBF91CDB78772ACF", hash_generated_method = "E9906A87A02471D54A9C6E65735754DE")
    private BigDecimal movePoint(long newScale) {
        addTaint(newScale);
    if(isZero())        
        {
BigDecimal var8648669F4F9B7990554AFB532873A30B_1617984225 =             zeroScaledBy(Math.max(newScale, 0));
            var8648669F4F9B7990554AFB532873A30B_1617984225.addTaint(taint);
            return var8648669F4F9B7990554AFB532873A30B_1617984225;
        } //End block
    if(newScale >= 0)        
        {
    if(bitLength < 64)            
            {
BigDecimal var1F006DE699D456616CFA5C0DCB882785_966557875 =                 valueOf(smallValue, safeLongToInt(newScale));
                var1F006DE699D456616CFA5C0DCB882785_966557875.addTaint(taint);
                return var1F006DE699D456616CFA5C0DCB882785_966557875;
            } //End block
BigDecimal var2950B3F33271CDDFB82B4FA1532054AD_1013140407 =             new BigDecimal(getUnscaledValue(), safeLongToInt(newScale));
            var2950B3F33271CDDFB82B4FA1532054AD_1013140407.addTaint(taint);
            return var2950B3F33271CDDFB82B4FA1532054AD_1013140407;
        } //End block
    if(-newScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                bitLength + LONG_POWERS_OF_TEN_BIT_LENGTH[(int)-newScale] < 64)        
        {
BigDecimal varBA2BCB1B91E2BF9BB2E46D52D5B505F9_1337403863 =             valueOf(smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)-newScale],0);
            varBA2BCB1B91E2BF9BB2E46D52D5B505F9_1337403863.addTaint(taint);
            return varBA2BCB1B91E2BF9BB2E46D52D5B505F9_1337403863;
        } //End block
BigDecimal varB459E47A55149A8AB88189942063A3AE_1482511950 =         new BigDecimal(Multiplication.multiplyByTenPow(
                getUnscaledValue(), safeLongToInt(-newScale)), 0);
        varB459E47A55149A8AB88189942063A3AE_1482511950.addTaint(taint);
        return varB459E47A55149A8AB88189942063A3AE_1482511950;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.611 -0400", hash_original_method = "07D5C3611C3ACCF090DC6103621F9345", hash_generated_method = "A3A71A182A9544AB1D6FBC3D523F5AE0")
    public BigDecimal movePointRight(int n) {
        addTaint(n);
BigDecimal varFAB4A084C014F2CC9A06FE2F649EC5B7_180912846 =         movePoint(scale - (long)n);
        varFAB4A084C014F2CC9A06FE2F649EC5B7_180912846.addTaint(taint);
        return varFAB4A084C014F2CC9A06FE2F649EC5B7_180912846;
        // ---------- Original Method ----------
        //return movePoint(scale - (long)n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.612 -0400", hash_original_method = "D86719E7E7F9F283B32E5780DA0BBE23", hash_generated_method = "099B56C1BB085B7368D99382D47B1CFF")
    public BigDecimal scaleByPowerOfTen(int n) {
        addTaint(n);
        long newScale = scale - (long)n;
    if(bitLength < 64)        
        {
    if(smallValue==0)            
            {
BigDecimal varE59C58B2F93F3B07BADE839AC0BAC55B_865663105 =                 zeroScaledBy( newScale );
                varE59C58B2F93F3B07BADE839AC0BAC55B_865663105.addTaint(taint);
                return varE59C58B2F93F3B07BADE839AC0BAC55B_865663105;
            } //End block
BigDecimal var1F006DE699D456616CFA5C0DCB882785_1866926805 =             valueOf(smallValue, safeLongToInt(newScale));
            var1F006DE699D456616CFA5C0DCB882785_1866926805.addTaint(taint);
            return var1F006DE699D456616CFA5C0DCB882785_1866926805;
        } //End block
BigDecimal var2950B3F33271CDDFB82B4FA1532054AD_1270239187 =         new BigDecimal(getUnscaledValue(), safeLongToInt(newScale));
        var2950B3F33271CDDFB82B4FA1532054AD_1270239187.addTaint(taint);
        return var2950B3F33271CDDFB82B4FA1532054AD_1270239187;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.613 -0400", hash_original_method = "6A410D70691999CADF96A81B91BD2E64", hash_generated_method = "3358AF7EAADA69C6659F7D20F7CD1902")
    public BigDecimal stripTrailingZeros() {
        int i = 1;
        int lastPow = TEN_POW.length - 1;
        long newScale = scale;
    if(isZero())        
        {
BigDecimal var72A74007B2BE62B849F475C7BDA4658B_1470427878 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1470427878.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1470427878;
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
BigDecimal var1A166BB701B1FAE1B7F0689622487F14_1843358510 =         new BigDecimal(strippedBI, safeLongToInt(newScale));
        var1A166BB701B1FAE1B7F0689622487F14_1843358510.addTaint(taint);
        return var1A166BB701B1FAE1B7F0689622487F14_1843358510;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.614 -0400", hash_original_method = "1C45ED34C4C1F5BEBD8BB8EF3CBE1A6B", hash_generated_method = "AA4211BD63DEEFC6EF4C8C811AC628AC")
    public int compareTo(BigDecimal val) {
        addTaint(val.getTaint());
        int thisSign = signum();
        int valueSign = val.signum();
    if(thisSign == valueSign)        
        {
    if(this.scale == val.scale && this.bitLength<64 && val.bitLength<64)            
            {
                int var4F05C911BF30C1F1E580BBD19824544C_1365628858 = ((smallValue < val.smallValue) ? -1 : (smallValue > val.smallValue) ? 1 : 0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_115984925 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_115984925;
            } //End block
            long diffScale = (long)this.scale - val.scale;
            int diffPrecision = this.approxPrecision() - val.approxPrecision();
    if(diffPrecision > diffScale + 1)            
            {
                int varAAEC9E072831704FD03A6CE72D4B1006_806325253 = (thisSign);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1547171120 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1547171120;
            } //End block
            else
    if(diffPrecision < diffScale - 1)            
            {
                int var9339BEECD49D6BC1F9531011F0B80496_596730583 = (-thisSign);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_778813777 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_778813777;
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
                int var17572EF0DCF687EFA578961DD76793C2_896773179 = (thisUnscaled.compareTo(valUnscaled));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_48987948 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_48987948;
            } //End block
        } //End block
        else
    if(thisSign < valueSign)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1810946782 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1835180578 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1835180578;
        } //End block
        else
        {
            int varC4CA4238A0B923820DCC509A6F75849B_292858310 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1285034244 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1285034244;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.615 -0400", hash_original_method = "310E755E039C5525B03EE3C0A35D27A8", hash_generated_method = "6EA5DFE3D2C689A58545FC3B3181EE71")
    @Override
    public boolean equals(Object x) {
        addTaint(x.getTaint());
    if(this == x)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_880981848 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1514363905 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1514363905;
        } //End block
    if(x instanceof BigDecimal)        
        {
            BigDecimal x1 = (BigDecimal) x;
            boolean varFFCB248826AD0D992940B7C3CE45FBD6_1911687753 = (x1.scale == scale
                   && (bitLength < 64 ? (x1.smallValue == smallValue)
                    : intVal.equals(x1.intVal)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_212990890 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_212990890;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1559386830 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1140638088 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1140638088;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.616 -0400", hash_original_method = "F19ED99F66E082325A61ACA186AF7454", hash_generated_method = "198B4042EC12FF10EA6FF4657A4170B3")
    public BigDecimal min(BigDecimal val) {
        addTaint(val.getTaint());
BigDecimal var26708BAD27AB6A40DFD9B529BADE2259_1616060785 =         ((compareTo(val) <= 0) ? this : val);
        var26708BAD27AB6A40DFD9B529BADE2259_1616060785.addTaint(taint);
        return var26708BAD27AB6A40DFD9B529BADE2259_1616060785;
        // ---------- Original Method ----------
        //return ((compareTo(val) <= 0) ? this : val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.616 -0400", hash_original_method = "4EA6A2C4CEA295044D603E0ACE9B5BC6", hash_generated_method = "60256130EFB9FB72251D5A01CA437037")
    public BigDecimal max(BigDecimal val) {
        addTaint(val.getTaint());
BigDecimal var34A91ECE6AEEAB60C08BD373AE7560BF_1410485212 =         ((compareTo(val) >= 0) ? this : val);
        var34A91ECE6AEEAB60C08BD373AE7560BF_1410485212.addTaint(taint);
        return var34A91ECE6AEEAB60C08BD373AE7560BF_1410485212;
        // ---------- Original Method ----------
        //return ((compareTo(val) >= 0) ? this : val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.617 -0400", hash_original_method = "F20F131BB03F0B25B12A1EF1F413017D", hash_generated_method = "1E24D20CEA1A2830B0FD720A800A2258")
    @Override
    public int hashCode() {
    if(hashCode != 0)        
        {
            int var550D1CC054A1B23A411DDDA46FD64811_704629736 = (hashCode);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_412468554 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_412468554;
        } //End block
    if(bitLength < 64)        
        {
            hashCode = (int)(smallValue & 0xffffffff);
            hashCode = 33 * hashCode +  (int)((smallValue >> 32) & 0xffffffff);
            hashCode = 17 * hashCode + scale;
            int var550D1CC054A1B23A411DDDA46FD64811_109737711 = (hashCode);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1326064983 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1326064983;
        } //End block
        hashCode = 17 * intVal.hashCode() + scale;
        int var550D1CC054A1B23A411DDDA46FD64811_519582426 = (hashCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_137220104 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_137220104;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.619 -0400", hash_original_method = "7C431BE8FF70735180E872A989DC1E52", hash_generated_method = "5580B6E8417C3DD881A88C9F376BEC11")
    @Override
    public String toString() {
    if(toStringImage != null)        
        {
String varC4BFBCFE8406AE670C10C7BFDA80A704_655684935 =             toStringImage;
            varC4BFBCFE8406AE670C10C7BFDA80A704_655684935.addTaint(taint);
            return varC4BFBCFE8406AE670C10C7BFDA80A704_655684935;
        } //End block
    if(bitLength < 32)        
        {
            toStringImage = Conversion.toDecimalScaledString(smallValue,scale);
String varC4BFBCFE8406AE670C10C7BFDA80A704_1709447434 =             toStringImage;
            varC4BFBCFE8406AE670C10C7BFDA80A704_1709447434.addTaint(taint);
            return varC4BFBCFE8406AE670C10C7BFDA80A704_1709447434;
        } //End block
        String intString = getUnscaledValue().toString();
    if(scale == 0)        
        {
String var44CDC699F6A0F54826763415A2B51DE5_1404869381 =             intString;
            var44CDC699F6A0F54826763415A2B51DE5_1404869381.addTaint(taint);
            return var44CDC699F6A0F54826763415A2B51DE5_1404869381;
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
String varC4BFBCFE8406AE670C10C7BFDA80A704_1089162111 =         toStringImage;
        varC4BFBCFE8406AE670C10C7BFDA80A704_1089162111.addTaint(taint);
        return varC4BFBCFE8406AE670C10C7BFDA80A704_1089162111;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.620 -0400", hash_original_method = "37C393D601D5FE9982CCA7EB2837999F", hash_generated_method = "8001946CC8FE0422084B7F24E4DD6AC1")
    public String toEngineeringString() {
        String intString = getUnscaledValue().toString();
    if(scale == 0)        
        {
String var44CDC699F6A0F54826763415A2B51DE5_1099585998 =             intString;
            var44CDC699F6A0F54826763415A2B51DE5_1099585998.addTaint(taint);
            return var44CDC699F6A0F54826763415A2B51DE5_1099585998;
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
String varE65B3A02759122992CB82C0E651AD408_1506754672 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_1506754672.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_1506754672;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.622 -0400", hash_original_method = "F2C3CA97C72252FC482FDCEF1D32932E", hash_generated_method = "0AB77B02CEA74DD941FBFFFB6E2AAE52")
    public String toPlainString() {
        String intStr = getUnscaledValue().toString();
    if((scale == 0) || ((isZero()) && (scale < 0)))        
        {
String var26ACA9E947EDB70461C1B834B3A4BCDD_1296538159 =             intStr;
            var26ACA9E947EDB70461C1B834B3A4BCDD_1296538159.addTaint(taint);
            return var26ACA9E947EDB70461C1B834B3A4BCDD_1296538159;
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
String varE65B3A02759122992CB82C0E651AD408_617251214 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_617251214.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_617251214;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.623 -0400", hash_original_method = "E90ADE3EE93FD433EFA047972DEC5382", hash_generated_method = "CEE7897C76AC30158CC7FFE43CB3A0D2")
    public BigInteger toBigInteger() {
    if((scale == 0) || (isZero()))        
        {
BigInteger varC9F991BB5BE86225185B684B83A7B9ED_1513311228 =             getUnscaledValue();
            varC9F991BB5BE86225185B684B83A7B9ED_1513311228.addTaint(taint);
            return varC9F991BB5BE86225185B684B83A7B9ED_1513311228;
        } //End block
        else
    if(scale < 0)        
        {
BigInteger var92E5714BDDF7DA600C27464C41C26CB9_1897837062 =             getUnscaledValue().multiply(Multiplication.powerOf10(-(long)scale));
            var92E5714BDDF7DA600C27464C41C26CB9_1897837062.addTaint(taint);
            return var92E5714BDDF7DA600C27464C41C26CB9_1897837062;
        } //End block
        else
        {
BigInteger var79C204E0A83BFC04B5F58E315F54C764_1128609401 =             getUnscaledValue().divide(Multiplication.powerOf10(scale));
            var79C204E0A83BFC04B5F58E315F54C764_1128609401.addTaint(taint);
            return var79C204E0A83BFC04B5F58E315F54C764_1128609401;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.624 -0400", hash_original_method = "0E78A189176A3E6769EBE407FB203DE6", hash_generated_method = "87343CF0917865C141B4D6936876CE72")
    public BigInteger toBigIntegerExact() {
    if((scale == 0) || (isZero()))        
        {
BigInteger varC9F991BB5BE86225185B684B83A7B9ED_958459272 =             getUnscaledValue();
            varC9F991BB5BE86225185B684B83A7B9ED_958459272.addTaint(taint);
            return varC9F991BB5BE86225185B684B83A7B9ED_958459272;
        } //End block
        else
    if(scale < 0)        
        {
BigInteger var92E5714BDDF7DA600C27464C41C26CB9_1570810395 =             getUnscaledValue().multiply(Multiplication.powerOf10(-(long)scale));
            var92E5714BDDF7DA600C27464C41C26CB9_1570810395.addTaint(taint);
            return var92E5714BDDF7DA600C27464C41C26CB9_1570810395;
        } //End block
        else
        {
            BigInteger[] integerAndFraction;
    if((scale > approxPrecision()) || (scale > getUnscaledValue().getLowestSetBit()))            
            {
                ArithmeticException varE5C6C0C3BF441F5A418B2C1CC9D6DB36_1101598561 = new ArithmeticException("Rounding necessary");
                varE5C6C0C3BF441F5A418B2C1CC9D6DB36_1101598561.addTaint(taint);
                throw varE5C6C0C3BF441F5A418B2C1CC9D6DB36_1101598561;
            } //End block
            integerAndFraction = getUnscaledValue().divideAndRemainder(Multiplication.powerOf10(scale));
    if(integerAndFraction[1].signum() != 0)            
            {
                ArithmeticException varE5C6C0C3BF441F5A418B2C1CC9D6DB36_747790010 = new ArithmeticException("Rounding necessary");
                varE5C6C0C3BF441F5A418B2C1CC9D6DB36_747790010.addTaint(taint);
                throw varE5C6C0C3BF441F5A418B2C1CC9D6DB36_747790010;
            } //End block
BigInteger var06BDC30212A265E66B8639F7A00D2AE4_843380089 =             integerAndFraction[0];
            var06BDC30212A265E66B8639F7A00D2AE4_843380089.addTaint(taint);
            return var06BDC30212A265E66B8639F7A00D2AE4_843380089;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.624 -0400", hash_original_method = "A54EDCAFB9A559A1B4EB83484BB75122", hash_generated_method = "0547EA0FD50616B680D7109357A6ED91")
    @Override
    public long longValue() {
        long var1D42F7550BDAE71142EC35FAC17842DD_820694248 = (((scale <= -64) || (scale > approxPrecision()) ? 0L
                : toBigInteger().longValue()));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_378589116 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_378589116;
        // ---------- Original Method ----------
        //return ((scale <= -64) || (scale > approxPrecision()) ? 0L
                //: toBigInteger().longValue());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.625 -0400", hash_original_method = "FC36A176D0180DB1420333E5E0A5371B", hash_generated_method = "6DE90486A73ABEA6794C446BC9F9F3BE")
    public long longValueExact() {
        long var69827C6D8993AB87D730C31E03F601BE_1628033271 = (valueExact(64));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1207622974 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1207622974;
        // ---------- Original Method ----------
        //return valueExact(64);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.625 -0400", hash_original_method = "C22AEC57669E1045E01A9977FB32CBED", hash_generated_method = "A69812EC446CC98C37D82783360083A1")
    @Override
    public int intValue() {
        int var2AEA45D79AA6593A7B7DB1A67D8D63EB_1987846748 = (((scale <= -32) || (scale > approxPrecision())
        ? 0
                : toBigInteger().intValue()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1798687009 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1798687009;
        // ---------- Original Method ----------
        //return ((scale <= -32) || (scale > approxPrecision())
        //? 0
                //: toBigInteger().intValue());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.625 -0400", hash_original_method = "3865E14853C36D94FA2C26348C89A3B8", hash_generated_method = "E4F6AD6ECB4456FE054F4F16953751A5")
    public int intValueExact() {
        int var8379FDDD5D0728EB8AD43CC75916BEB4_761958039 = ((int)valueExact(32));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_336281808 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_336281808;
        // ---------- Original Method ----------
        //return (int)valueExact(32);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.626 -0400", hash_original_method = "D0948D36E91C12739D01E1A7BD76887B", hash_generated_method = "82CE3E67872E5B741884A3A8F0967140")
    public short shortValueExact() {
        short var3FF1A8D4C979BFECFA072DA7AF4F3D20_1379793812 = ((short)valueExact(16));
                short var4F09DAA9D95BCB166A302407A0E0BABE_615749540 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_615749540;
        // ---------- Original Method ----------
        //return (short)valueExact(16);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.626 -0400", hash_original_method = "D6CE76A6DF6EC675E82ED0D5BFCEAF06", hash_generated_method = "28920336740440A2A17A09FAD2DBDFC3")
    public byte byteValueExact() {
        byte var90D2D9D6796F8238D749A34354DD1148_1049204485 = ((byte)valueExact(8));
                byte var40EA57D3EE3C07BF1C102B466E1C3091_1377498494 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1377498494;
        // ---------- Original Method ----------
        //return (byte)valueExact(8);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.627 -0400", hash_original_method = "4137052570907849FFBB7EF546BA389D", hash_generated_method = "DBFF297582F0E2AE47361EF6D5E51365")
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
        float var698E631BB1C9A92204E07401E49BEE17_1091608663 = (floatResult);
                float var546ADE640B6EDFBC8A086EF31347E768_145872057 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_145872057;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.632 -0400", hash_original_method = "73F99D783081712086B11A0804DADCB9", hash_generated_method = "29372168861A9E4235DD4269448D552F")
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
            double varD8283E0CBB3270C1C3CBAEDED6D59ED3_1936633831 = ((sign * 0.0d));
                        double varE8CD7DA078A86726031AD64F35F5A6C0_1273576454 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_1273576454;
        } //End block
        else
    if(powerOfTwo > 1025)        
        {
            double varDCD32871C19AE37E8637F370F1056C23_1076402863 = ((sign * Double.POSITIVE_INFINITY));
                        double varE8CD7DA078A86726031AD64F35F5A6C0_773081737 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_773081737;
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
            double varDCD32871C19AE37E8637F370F1056C23_1663854074 = ((sign * Double.POSITIVE_INFINITY));
                        double varE8CD7DA078A86726031AD64F35F5A6C0_548793728 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_548793728;
        } //End block
        else
    if(exponent <= 0)        
        {
    if(exponent < -53)            
            {
                double varD8283E0CBB3270C1C3CBAEDED6D59ED3_474481734 = ((sign * 0.0d));
                                double varE8CD7DA078A86726031AD64F35F5A6C0_862745849 = getTaintDouble();
                return varE8CD7DA078A86726031AD64F35F5A6C0_862745849;
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
        double var61EDA2E8233274E3C33F1B296528BD1E_1429276123 = (Double.longBitsToDouble(bits));
                double varE8CD7DA078A86726031AD64F35F5A6C0_1083279464 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1083279464;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.634 -0400", hash_original_method = "AE130D2701C769DD6982173139D47466", hash_generated_method = "460FDD4A61F72EB6AA2B2058D13019CF")
    public BigDecimal ulp() {
BigDecimal var7724CABD8C77ECA94722C10ABD307202_481328574 =         valueOf(1, scale);
        var7724CABD8C77ECA94722C10ABD307202_481328574.addTaint(taint);
        return var7724CABD8C77ECA94722C10ABD307202_481328574;
        // ---------- Original Method ----------
        //return valueOf(1, scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.637 -0400", hash_original_method = "55CD7E6ED2002FE9D7C30850FBD08759", hash_generated_method = "302C7A4476621A1CEB0DF9106E185BB0")
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

    
        private static int longCompareTo(long value1, long value2) {
        return value1 > value2 ? 1 : (value1 < value2 ? -1 : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.639 -0400", hash_original_method = "7FBE752FF3FF6B350050AE2B0F2B0308", hash_generated_method = "6F63D71CB645EEA08B0D4376FB6BE196")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.640 -0400", hash_original_method = "77E444DFD73510CC8BF3E35576C17A04", hash_generated_method = "F1A7D4BC1515866CBB4DCE0EB7DA7A51")
    private long valueExact(int bitLengthOfType) {
        addTaint(bitLengthOfType);
        BigInteger bigInteger = toBigIntegerExact();
    if(bigInteger.bitLength() < bitLengthOfType)        
        {
            long varE8B6CC613F9134F0818C7AFDC479A7FA_1477125365 = (bigInteger.longValue());
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1478007759 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1478007759;
        } //End block
        ArithmeticException varE5C6C0C3BF441F5A418B2C1CC9D6DB36_129550976 = new ArithmeticException("Rounding necessary");
        varE5C6C0C3BF441F5A418B2C1CC9D6DB36_129550976.addTaint(taint);
        throw varE5C6C0C3BF441F5A418B2C1CC9D6DB36_129550976;
        // ---------- Original Method ----------
        //BigInteger bigInteger = toBigIntegerExact();
        //if (bigInteger.bitLength() < bitLengthOfType) {
            //return bigInteger.longValue();
        //}
        //throw new ArithmeticException("Rounding necessary");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.641 -0400", hash_original_method = "610DE3E95388579A8DD4E22BDEDE3C6E", hash_generated_method = "46C8A690D09C52784F648273963863D4")
    private int approxPrecision() {
        int var7CDA58196C86390834B6F2307552DAD7_1195708814 = (precision > 0
                ? precision
                : (int) ((this.bitLength - 1) * LOG10_2) + 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_684359470 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_684359470;
        // ---------- Original Method ----------
        //return precision > 0
                //? precision
                //: (int) ((this.bitLength - 1) * LOG10_2) + 1;
    }

    
        private static int safeLongToInt(long longValue) {
        if (longValue < Integer.MIN_VALUE || longValue > Integer.MAX_VALUE) {
            throw new ArithmeticException("Out of int range: " + longValue);
        }
        return (int) longValue;
    }

    
        private static BigDecimal zeroScaledBy(long longScale) {
        if (longScale == (int) longScale) {
            return valueOf(0,(int)longScale);
            }
        if (longScale >= 0) {
            return new BigDecimal( 0, Integer.MAX_VALUE);
        }
        return new BigDecimal( 0, Integer.MIN_VALUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.643 -0400", hash_original_method = "886E4F08C2196C85465CF795B505FE44", hash_generated_method = "B223894362AA1D8F0C8B7257680A781C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.644 -0400", hash_original_method = "19FA8CC309F5EC9C814FD711C697099A", hash_generated_method = "A182EAFF59BE1C772C43C11E96D8B230")
    private void writeObject(ObjectOutputStream out) throws IOException {
        addTaint(out.getTaint());
        getUnscaledValue();
        out.defaultWriteObject();
        // ---------- Original Method ----------
        //getUnscaledValue();
        //out.defaultWriteObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.645 -0400", hash_original_method = "1C1109E2DBDCFAE7331AD37D197254D0", hash_generated_method = "0868814EAA80155EB37805C9C849537D")
    private BigInteger getUnscaledValue() {
    if(intVal == null)        
        {
            intVal = BigInteger.valueOf(smallValue);
        } //End block
BigInteger var8FF653FB840FA82FCA73D5A3807C8FDF_1310344521 =         intVal;
        var8FF653FB840FA82FCA73D5A3807C8FDF_1310344521.addTaint(taint);
        return var8FF653FB840FA82FCA73D5A3807C8FDF_1310344521;
        // ---------- Original Method ----------
        //if(intVal == null) {
            //intVal = BigInteger.valueOf(smallValue);
        //}
        //return intVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.646 -0400", hash_original_method = "3BE919C32007DA5FAF4FB8B842EE650C", hash_generated_method = "42271E755316AB344A200BAE571C12BC")
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

    
        private static int bitLength(long smallValue) {
        if(smallValue < 0) {
            smallValue = ~smallValue;
        }
        return 64 - Long.numberOfLeadingZeros(smallValue);
    }

    
        private static int bitLength(int smallValue) {
        if(smallValue < 0) {
            smallValue = ~smallValue;
        }
        return 32 - Integer.numberOfLeadingZeros(smallValue);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.647 -0400", hash_original_field = "877CBC7572A1F4C5C4A5EF0FCDBA91C3", hash_generated_field = "B6EECEB04C7C8E9BC518DBA316290DA7")

    public static final int ROUND_UP = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.647 -0400", hash_original_field = "D2CF03DE063925E19E13C52C8FBE1929", hash_generated_field = "454999CD924CB489896B8D343444FE92")

    public static final int ROUND_DOWN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.647 -0400", hash_original_field = "AAC8B6F1C4763B9728AB52AE15952AF6", hash_generated_field = "3C0D845F7C2F954D2ED7E86C0AE35835")

    public static final int ROUND_CEILING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.647 -0400", hash_original_field = "7503CC26EC44F42386A1D0025B5AEF97", hash_generated_field = "53D60190BBA8538A982DF868F4C6200E")

    public static final int ROUND_FLOOR = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.647 -0400", hash_original_field = "7E7DD45EF4EB3B06BFEF96EA4B0DD84D", hash_generated_field = "F10F1696D5C52C5E6B4B91643A72CEBE")

    public static final int ROUND_HALF_UP = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.647 -0400", hash_original_field = "20B7B28A1B56AD4CEA47F72CC0696346", hash_generated_field = "1619429E1C6C75DCE5756A9CF242CB9E")

    public static final int ROUND_HALF_DOWN = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.647 -0400", hash_original_field = "B3DCF23AE156DDE73D388CA751C9365F", hash_generated_field = "737A62C6AFA4A3B8167B738F856B0DEA")

    public static final int ROUND_HALF_EVEN = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.647 -0400", hash_original_field = "22697FABD637B187447A670B355A0081", hash_generated_field = "C5A01DD93D79DC15583A8D0F0236E74E")

    public static final int ROUND_UNNECESSARY = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.647 -0400", hash_original_field = "116BD32AD0E75158256F445ABDC8389D", hash_generated_field = "732C210E7618496C3947E6F404C23DC5")

    private static final long serialVersionUID = 6108874887143696463L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.648 -0400", hash_original_field = "7458DC5DA966512012D7187A9F089DAC", hash_generated_field = "E93F26BA415E2A63370EECFB39CABE9A")

    private static final double LOG10_2 = 0.3010299956639812;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.648 -0400", hash_original_field = "5515FC399FA5591FAB09427986B893AC", hash_generated_field = "BC1FA69034FA076F552F1F096B6FE848")

    private static BigInteger[] FIVE_POW;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.648 -0400", hash_original_field = "6890CCC61C514170BDE91D0B4ED71AF6", hash_generated_field = "487DAC2FC944E340E99AE2E5C8C63B33")

    private static BigInteger[] TEN_POW;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.648 -0400", hash_original_field = "B3E64594B71C88A1FCA0FDDB1DB0D932", hash_generated_field = "7278FA9BE84E3C616E4421DE5FF2F206")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.648 -0400", hash_original_field = "BE202B01F91923E667B3B16B069D07DC", hash_generated_field = "FD0F7EAC9A9246982008521CC29799A7")

    private static final int[] LONG_FIVE_POW_BIT_LENGTH = new int[LONG_FIVE_POW.length];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.648 -0400", hash_original_field = "157379F1EEDF7417D34D4EA991CF2184", hash_generated_field = "9DFBCE8298EAB00B86718FC0B2D88337")

    private static final int[] LONG_POWERS_OF_TEN_BIT_LENGTH = new int[MathUtils.LONG_POWERS_OF_TEN.length];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.648 -0400", hash_original_field = "921789C958D668713F05F9FFE836B8C7", hash_generated_field = "E22EB04741B2BFD88E960FE524D60B1A")

    private static final int BI_SCALED_BY_ZERO_LENGTH = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.648 -0400", hash_original_field = "717A7640C2D9003B18C4055EC0C50419", hash_generated_field = "5B020D40BF07C0EC94E4149184B70A65")

    private static final BigDecimal[] BI_SCALED_BY_ZERO = new BigDecimal[BI_SCALED_BY_ZERO_LENGTH];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.649 -0400", hash_original_field = "39586D78C45D7A19439688292151133A", hash_generated_field = "5C08AD19ABFF43369109F8D9272F2B04")

    private static final BigDecimal[] ZERO_SCALED_BY = new BigDecimal[11];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.649 -0400", hash_original_field = "94F236C8393993A7B9287704666BFBEE", hash_generated_field = "12A340B61FB03C00F6D04EBF43FAFF99")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.649 -0400", hash_original_field = "B1F433B3E708BA2079293308D7CA4999", hash_generated_field = "E2BD5BBDB2DF3AE4973FDC84A00AF40A")

    public static final BigDecimal ZERO = new BigDecimal(0, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.649 -0400", hash_original_field = "3A7ACF4CD264E65305ECE3D1A439ECF7", hash_generated_field = "9F34079F2BD32FDD32B17DD6B2BC0759")

    public static final BigDecimal ONE = new BigDecimal(1, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.649 -0400", hash_original_field = "831A4D5A2871A70F006594FB3523DE19", hash_generated_field = "7D43F273171CCD7BF176CC18D6BEE813")

    public static final BigDecimal TEN = new BigDecimal(10, 0);
}

