package java.math;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import libcore.math.MathUtils;

public class BigDecimal extends Number implements Comparable<BigDecimal>, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.348 -0400", hash_original_field = "0A495C22CEE2486109FF49D52FAB7401", hash_generated_field = "326D03DFD6F64D4B3F1173FBD427B520")

    private transient String toStringImage = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.348 -0400", hash_original_field = "B81E47D2AA677809E4BE3C9232B2407F", hash_generated_field = "3D9A07F218385AD7A5B345B923EAF46E")

    private transient int hashCode = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.348 -0400", hash_original_field = "3A1F983ED27316FA36EAAFE36DA5649F", hash_generated_field = "E1C21CCC8969038A086EDD16030014B8")

    private BigInteger intVal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.348 -0400", hash_original_field = "B35AD5BAFCCD957A930C16D5DD131EE4", hash_generated_field = "1C841931B61AD9BC0EB5C76BA4219E64")

    private transient int bitLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.348 -0400", hash_original_field = "412477B04CAB5EE326327BE6C10454DF", hash_generated_field = "27339F171BD0CF229BCBE4E7356A5F0B")

    private transient long smallValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.348 -0400", hash_original_field = "0CB47AEB6E5F9323F0969E628C4E59F5", hash_generated_field = "F9D5D1CA2ABDD82810FF1FE80E0268E6")

    private int scale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.348 -0400", hash_original_field = "46C2159C904EABF687686166E93B72AA", hash_generated_field = "4E7D370BAE76B07332BBBB929C2DF340")

    private transient int precision = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.349 -0400", hash_original_method = "6BC27F867C09C0249873A4D338F8666D", hash_generated_method = "675ADE6C6F01FF4ED08427C7FC23A83B")
    private  BigDecimal(long smallValue, int scale) {
        this.smallValue = smallValue;
        this.scale = scale;
        this.bitLength = bitLength(smallValue);
        // ---------- Original Method ----------
        //this.smallValue = smallValue;
        //this.scale = scale;
        //this.bitLength = bitLength(smallValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.349 -0400", hash_original_method = "9F6CD654516DCD03F33530EDCF81D84D", hash_generated_method = "3DC98F1132A232115D5983B57B665BF0")
    private  BigDecimal(int smallValue, int scale) {
        this.smallValue = smallValue;
        this.scale = scale;
        this.bitLength = bitLength(smallValue);
        // ---------- Original Method ----------
        //this.smallValue = smallValue;
        //this.scale = scale;
        //this.bitLength = bitLength(smallValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.350 -0400", hash_original_method = "374C425CF4086C798A21EEA670343536", hash_generated_method = "997C83832A5AD4754A8EC39E883C08A8")
    public  BigDecimal(char[] in, int offset, int len) {
        int begin = offset;
        int last = offset + (len - 1);
        String scaleString;
        StringBuilder unscaledBuffer;
        long newScale;
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NumberFormatException("Bad offset/length: offset=" + offset +
                    " len=" + len + " in.length=" + in.length);
        } //End block
        unscaledBuffer = new StringBuilder(len);
        int bufLength = 0;
        int counter = 0;
        boolean wasNonZero = false;
        {
            {
                {
                    wasNonZero = true;
                } //End block
            } //End block
        } //End block
        unscaledBuffer.append(in, begin, offset - begin);
        bufLength += offset - begin;
        {
            begin = offset;
            {
                {
                    {
                        wasNonZero = true;
                    } //End block
                } //End block
            } //End block
            scale = offset - begin;
            bufLength +=scale;
            unscaledBuffer.append(in, begin, scale);
        } //End block
        {
            scale = 0;
        } //End block
        {
            begin = offset;
            scaleString = String.valueOf(in, begin, last + 1 - begin);
            newScale = (long)scale - Integer.parseInt(scaleString);
            scale = (int)newScale;
            {
                if (DroidSafeAndroidRuntime.control) throw new NumberFormatException("Scale out of range");
            } //End block
        } //End block
        {
            smallValue = Long.parseLong(unscaledBuffer.toString());
            bitLength = bitLength(smallValue);
        } //End block
        {
            setUnscaledValue(new BigInteger(unscaledBuffer.toString()));
        } //End block
        precision = unscaledBuffer.length() - counter;
        {
            boolean var61B48B5FEE897AE42C98AFC63C6454F8_1768908168 = (unscaledBuffer.charAt(0) == '-');
        } //End collapsed parenthetic
        addTaint(in[0]);
        addTaint(len);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.350 -0400", hash_original_method = "021DB19003FFCB38960FC53E0DB20D11", hash_generated_method = "275FB9D57B18A3B85184CAF9CE70BF00")
    public  BigDecimal(char[] in, int offset, int len, MathContext mc) {
        this(in, offset, len);
        inplaceRound(mc);
        addTaint(in[0]);
        addTaint(offset);
        addTaint(len);
        addTaint(mc.getTaint());
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.351 -0400", hash_original_method = "2CA49E7A005F756FE298C75D3E276FBD", hash_generated_method = "B4FD1176C71EA8991071A29C074F944A")
    public  BigDecimal(char[] in) {
        this(in, 0, in.length);
        addTaint(in[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.351 -0400", hash_original_method = "24A3A809E90D8D728111B1E9DFB6AE2B", hash_generated_method = "09C060845E8F5FF4F77D83B14AFC3E66")
    public  BigDecimal(char[] in, MathContext mc) {
        this(in, 0, in.length);
        inplaceRound(mc);
        addTaint(in[0]);
        addTaint(mc.getTaint());
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.352 -0400", hash_original_method = "97883F5F25D8C2D5B9EC2501AC7ECDA2", hash_generated_method = "F8C02FFBA49B73A7A22E83CA112803F6")
    public  BigDecimal(String val) {
        this(val.toCharArray(), 0, val.length());
        addTaint(val.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.353 -0400", hash_original_method = "65FA78E7CB5F82CDA77BAA4B434CD165", hash_generated_method = "76DAE502211644C5F6D20BA849076BCF")
    public  BigDecimal(String val, MathContext mc) {
        this(val.toCharArray(), 0, val.length());
        inplaceRound(mc);
        addTaint(val.getTaint());
        addTaint(mc.getTaint());
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.353 -0400", hash_original_method = "A550123107439183BDAF78BFBC33380D", hash_generated_method = "5E1493B76D13F603385B25C86038AB41")
    public  BigDecimal(double val) {
        {
            boolean var07ED44AABC248720567522E1772FEBCB_168000504 = (Double.isInfinite(val) || Double.isNaN(val));
            {
                if (DroidSafeAndroidRuntime.control) throw new NumberFormatException("Infinity or NaN: " + val);
            } //End block
        } //End collapsed parenthetic
        long bits = Double.doubleToLongBits(val);
        long mantissa;
        int trailingZeros;
        scale = 1075 - (int)((bits >> 52) & 0x7FFL);
        mantissa = (scale == 1075) ? (bits & 0xFFFFFFFFFFFFFL) << 1
                : (bits & 0xFFFFFFFFFFFFFL) | 0x10000000000000L;
        {
            scale = 0;
            precision = 1;
        } //End block
        {
            trailingZeros = Math.min(scale, Long.numberOfTrailingZeros(mantissa));
            mantissa >>>= trailingZeros;
            scale -= trailingZeros;
        } //End block
        {
            mantissa = -mantissa;
        } //End block
        int mantissaBits = bitLength(mantissa);
        {
            bitLength = mantissaBits == 0 ? 0 : mantissaBits - scale;
            {
                smallValue = mantissa << (-scale);
            } //End block
            {
                BigInt bi = new BigInt();
                bi.putLongInt(mantissa);
                bi.shift(-scale);
                intVal = new BigInteger(bi);
            } //End block
            scale = 0;
        } //End block
        {
            {
                smallValue = mantissa * LONG_FIVE_POW[scale];
                bitLength = bitLength(smallValue);
            } //End block
            {
                setUnscaledValue(Multiplication.multiplyByFivePow(BigInteger.valueOf(mantissa), scale));
            } //End block
        } //End block
        {
            smallValue = mantissa;
            bitLength = mantissaBits;
        } //End block
        addTaint(val);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.354 -0400", hash_original_method = "A301A521891A68A20E545213C1CF7F7F", hash_generated_method = "61E4530A94C3F954071D1E31BF762714")
    public  BigDecimal(double val, MathContext mc) {
        this(val);
        inplaceRound(mc);
        addTaint(val);
        addTaint(mc.getTaint());
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.354 -0400", hash_original_method = "35103202AC4D8227390F065BF679C471", hash_generated_method = "D504D0B814354DD64C3D66DE08011646")
    public  BigDecimal(BigInteger val) {
        this(val, 0);
        addTaint(val.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.354 -0400", hash_original_method = "4DD15F45D533F2889A2A72BE2BF675A6", hash_generated_method = "D67E2735ED92664B1FB6B7B749D87D08")
    public  BigDecimal(BigInteger val, MathContext mc) {
        this(val);
        inplaceRound(mc);
        addTaint(val.getTaint());
        addTaint(mc.getTaint());
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.354 -0400", hash_original_method = "E5BF86952E31D522F2FAABCF30464562", hash_generated_method = "72E89060793A1AA3A659E8DA2DA29B04")
    public  BigDecimal(BigInteger unscaledVal, int scale) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        this.scale = scale;
        setUnscaledValue(unscaledVal);
        addTaint(unscaledVal.getTaint());
        // ---------- Original Method ----------
        //if (unscaledVal == null) {
            //throw new NullPointerException();
        //}
        //this.scale = scale;
        //setUnscaledValue(unscaledVal);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.355 -0400", hash_original_method = "59F34EC0A04F061EC6FA9A9EFC322A4C", hash_generated_method = "32E65AEFC7C0BD2C974B7F3E9297CD5F")
    public  BigDecimal(BigInteger unscaledVal, int scale, MathContext mc) {
        this(unscaledVal, scale);
        inplaceRound(mc);
        addTaint(unscaledVal.getTaint());
        addTaint(scale);
        addTaint(mc.getTaint());
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.355 -0400", hash_original_method = "5359C9BE484C4A97ECD231D115B1BCDB", hash_generated_method = "D648D7F23799D878CE7DE9DEA41AED6E")
    public  BigDecimal(int val) {
        this(val,0);
        addTaint(val);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.355 -0400", hash_original_method = "919820155B3DF9AD0A8E776AC27BF824", hash_generated_method = "1FFD2ADDE931D52B57DBB399AEFC9F40")
    public  BigDecimal(int val, MathContext mc) {
        this(val,0);
        inplaceRound(mc);
        addTaint(val);
        addTaint(mc.getTaint());
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.355 -0400", hash_original_method = "3B8082CDF108D6321820C9FA6A6A1D42", hash_generated_method = "5CD5A0914C8C99DBF87C1115B74C5DD3")
    public  BigDecimal(long val) {
        this(val,0);
        addTaint(val);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.355 -0400", hash_original_method = "E0851629E0BD0FDB6233816479A7E4A8", hash_generated_method = "4C9B12BD7553D77E861C40B68F1A9173")
    public  BigDecimal(long val, MathContext mc) {
        this(val);
        inplaceRound(mc);
        addTaint(val);
        addTaint(mc.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.357 -0400", hash_original_method = "1DCD141A7D54B6C70CB155CC6BA0AB13", hash_generated_method = "B1E9477A58450F74DEDF56352D01604F")
    public BigDecimal add(BigDecimal augend) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1852702087 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1298115101 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1373246077 = null; //Variable for return #3
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_2000639689 = null; //Variable for return #4
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1967888171 = null; //Variable for return #5
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_481187541 = null; //Variable for return #6
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1167453273 = null; //Variable for return #7
        int diffScale = this.scale - augend.scale;
        {
            boolean var3ACAB80A5F99B906541DA9D0E446A470_1806614544 = (this.isZero());
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1852702087 = augend;
                } //End block
                {
                    boolean varB1908C261B547BD48CB51E1D5EF611A0_1291629723 = (augend.isZero());
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1298115101 = this;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean var133F1DCA67F284EB5AB919CE41BBA5B6_1214736014 = (augend.isZero());
                {
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1373246077 = this;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            {
                boolean varD111D3273CD5455867ABFC03E36CFA28_1165951283 = (Math.max(this.bitLength, augend.bitLength) + 1 < 64);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_2000639689 = valueOf(this.smallValue + augend.smallValue, this.scale);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1967888171 = new BigDecimal(this.getUnscaledValue().add(augend.getUnscaledValue()), this.scale);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_481187541 = addAndMult10(this, augend, diffScale);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1167453273 = addAndMult10(augend, this, -diffScale);
        } //End block
        addTaint(augend.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_1254350952; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1254350952 = varB4EAC82CA7396A68D541C85D26508E83_1852702087;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1254350952 = varB4EAC82CA7396A68D541C85D26508E83_1298115101;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1254350952 = varB4EAC82CA7396A68D541C85D26508E83_1373246077;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1254350952 = varB4EAC82CA7396A68D541C85D26508E83_2000639689;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1254350952 = varB4EAC82CA7396A68D541C85D26508E83_1967888171;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1254350952 = varB4EAC82CA7396A68D541C85D26508E83_481187541;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1254350952 = varB4EAC82CA7396A68D541C85D26508E83_1167453273;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1254350952.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1254350952;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.359 -0400", hash_original_method = "37BDD6EE07613654EB8729406017A0AF", hash_generated_method = "1DC927509A9BACFC5AC76E911B618C52")
    public BigDecimal add(BigDecimal augend, MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_252620751 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_283262296 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_484821975 = null; //Variable for return #3
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1540385750 = null; //Variable for return #4
        BigDecimal larger;
        BigDecimal smaller;
        BigInteger tempBI;
        long diffScale = (long)this.scale - augend.scale;
        int largerSignum;
        {
            boolean varF966BD50F4EF9C0D05117401635B161E_1262740704 = ((augend.isZero()) || (this.isZero())
                || (mc.getPrecision() == 0));
            {
                varB4EAC82CA7396A68D541C85D26508E83_252620751 = add(augend).round(mc);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var9070081FF1C89B57CAC464C53A5B31A2_1426429126 = (this.approxPrecision() < diffScale - 1);
            {
                larger = augend;
                smaller = this;
            } //End block
            {
                boolean varA5DA4849944CED3DDED10285985020BE_950727769 = (augend.approxPrecision() < -diffScale - 1);
                {
                    larger = this;
                    smaller = augend;
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_283262296 = add(augend).round(mc);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean var8AFB7E1F21C67DCCAA005AEF04A9DB11_1213619613 = (mc.getPrecision() >= larger.approxPrecision());
            {
                varB4EAC82CA7396A68D541C85D26508E83_484821975 = add(augend).round(mc);
            } //End block
        } //End collapsed parenthetic
        largerSignum = larger.signum();
        {
            boolean varFDAEFA28D5E9E9B77BEF39981CC0842F_2102615680 = (largerSignum == smaller.signum());
            {
                tempBI = Multiplication.multiplyByPositiveInt(larger.getUnscaledValue(),10)
            .add(BigInteger.valueOf(largerSignum));
            } //End block
            {
                tempBI = larger.getUnscaledValue().subtract(
                    BigInteger.valueOf(largerSignum));
                tempBI = Multiplication.multiplyByPositiveInt(tempBI,10)
            .add(BigInteger.valueOf(largerSignum * 9));
            } //End block
        } //End collapsed parenthetic
        larger = new BigDecimal(tempBI, larger.scale + 1);
        varB4EAC82CA7396A68D541C85D26508E83_1540385750 = larger.round(mc);
        addTaint(augend.getTaint());
        addTaint(mc.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_285437475; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_285437475 = varB4EAC82CA7396A68D541C85D26508E83_252620751;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_285437475 = varB4EAC82CA7396A68D541C85D26508E83_283262296;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_285437475 = varB4EAC82CA7396A68D541C85D26508E83_484821975;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_285437475 = varB4EAC82CA7396A68D541C85D26508E83_1540385750;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_285437475.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_285437475;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.361 -0400", hash_original_method = "463B27AE9A4331C20782D4CCC2226F12", hash_generated_method = "DA2A440C7D265524646BD74940FB60A2")
    public BigDecimal subtract(BigDecimal subtrahend) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_400653032 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_409776510 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_949443169 = null; //Variable for return #3
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1486281097 = null; //Variable for return #4
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_788872777 = null; //Variable for return #5
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_2047065149 = null; //Variable for return #6
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_572072046 = null; //Variable for return #7
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_619478430 = null; //Variable for return #8
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_863730232 = null; //Variable for return #9
        int diffScale = this.scale - subtrahend.scale;
        {
            boolean var3ACAB80A5F99B906541DA9D0E446A470_1163095985 = (this.isZero());
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_400653032 = subtrahend.negate();
                } //End block
                {
                    boolean varD03C6CECC51E3DE3442E3774C1567DCF_534738289 = (subtrahend.isZero());
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_409776510 = this;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean var9EB1DAC8BC084CCA52BBCF84A22F0C39_517560604 = (subtrahend.isZero());
                {
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_949443169 = this;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            {
                boolean var716C9DB8DD66F0858D9B5D3E8474C979_994762000 = (Math.max(this.bitLength, subtrahend.bitLength) + 1 < 64);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1486281097 = valueOf(this.smallValue - subtrahend.smallValue,this.scale);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_788872777 = new BigDecimal(this.getUnscaledValue().subtract(subtrahend.getUnscaledValue()), this.scale);
        } //End block
        {
            {
                boolean var920C6D472A61AE7DE113537D4CAEABA3_1376603836 = (diffScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                    Math.max(this.bitLength,subtrahend.bitLength+LONG_POWERS_OF_TEN_BIT_LENGTH[diffScale])+1<64);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_2047065149 = valueOf(this.smallValue-subtrahend.smallValue*MathUtils.LONG_POWERS_OF_TEN[diffScale],this.scale);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_572072046 = new BigDecimal(this.getUnscaledValue().subtract(
                    Multiplication.multiplyByTenPow(subtrahend.getUnscaledValue(),diffScale)), this.scale);
        } //End block
        {
            diffScale = -diffScale;
            {
                boolean var71AEEAE804686FEE863217A58EF3D39E_1841135183 = (diffScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                    Math.max(this.bitLength+LONG_POWERS_OF_TEN_BIT_LENGTH[diffScale],subtrahend.bitLength)+1<64);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_619478430 = valueOf(this.smallValue*MathUtils.LONG_POWERS_OF_TEN[diffScale]-subtrahend.smallValue,subtrahend.scale);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_863730232 = new BigDecimal(Multiplication.multiplyByTenPow(this.getUnscaledValue(),diffScale)
            .subtract(subtrahend.getUnscaledValue()), subtrahend.scale);
        } //End block
        addTaint(subtrahend.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_852085678; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_852085678 = varB4EAC82CA7396A68D541C85D26508E83_400653032;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_852085678 = varB4EAC82CA7396A68D541C85D26508E83_409776510;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_852085678 = varB4EAC82CA7396A68D541C85D26508E83_949443169;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_852085678 = varB4EAC82CA7396A68D541C85D26508E83_1486281097;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_852085678 = varB4EAC82CA7396A68D541C85D26508E83_788872777;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_852085678 = varB4EAC82CA7396A68D541C85D26508E83_2047065149;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_852085678 = varB4EAC82CA7396A68D541C85D26508E83_572072046;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_852085678 = varB4EAC82CA7396A68D541C85D26508E83_619478430;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_852085678 = varB4EAC82CA7396A68D541C85D26508E83_863730232;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_852085678.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_852085678;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.365 -0400", hash_original_method = "427D658D2E18BC359A41906DA92107B2", hash_generated_method = "B00C71144314901F60CFAF78F21DE2BF")
    public BigDecimal subtract(BigDecimal subtrahend, MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1971566410 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_11219444 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_818094913 = null; //Variable for return #3
        long diffScale = subtrahend.scale - (long)this.scale;
        int thisSignum;
        BigDecimal leftOperand;
        BigInteger tempBI;
        {
            boolean varFD92EBCDA78B63D052A84F60541F229A_1405206456 = ((subtrahend.isZero()) || (this.isZero())
                || (mc.getPrecision() == 0));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1971566410 = subtract(subtrahend).round(mc);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var89DC8760BF7238399EC83E1D522E73AD_264856670 = (subtrahend.approxPrecision() < diffScale - 1);
            {
                {
                    boolean varD9AB7589FCBDAD8F096FC84E02A2A50D_623505190 = (mc.getPrecision() < this.approxPrecision());
                    {
                        thisSignum = this.signum();
                        {
                            boolean var62FB1B54913969022251702D5200468F_1440609127 = (thisSignum != subtrahend.signum());
                            {
                                tempBI = Multiplication.multiplyByPositiveInt(this.getUnscaledValue(), 10)
                    .add(BigInteger.valueOf(thisSignum));
                            } //End block
                            {
                                tempBI = this.getUnscaledValue().subtract(BigInteger.valueOf(thisSignum));
                                tempBI = Multiplication.multiplyByPositiveInt(tempBI, 10)
                    .add(BigInteger.valueOf(thisSignum * 9));
                            } //End block
                        } //End collapsed parenthetic
                        leftOperand = new BigDecimal(tempBI, this.scale + 1);
                        varB4EAC82CA7396A68D541C85D26508E83_11219444 = leftOperand.round(mc);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_818094913 = subtract(subtrahend).round(mc);
        addTaint(subtrahend.getTaint());
        addTaint(mc.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_185758459; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_185758459 = varB4EAC82CA7396A68D541C85D26508E83_1971566410;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_185758459 = varB4EAC82CA7396A68D541C85D26508E83_11219444;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_185758459 = varB4EAC82CA7396A68D541C85D26508E83_818094913;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_185758459.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_185758459;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.367 -0400", hash_original_method = "0CD1948BD2366020AE6A84C7902D73D6", hash_generated_method = "07AA11336D1066A8FB6DD731B539BA3D")
    public BigDecimal multiply(BigDecimal multiplicand) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_184391660 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_234896719 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1898742439 = null; //Variable for return #3
        long newScale = (long)this.scale + multiplicand.scale;
        {
            boolean var94085E900CFE8C8A5270601770788621_938085343 = ((this.isZero()) || (multiplicand.isZero()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_184391660 = zeroScaledBy(newScale);
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_234896719 = valueOf(this.smallValue*multiplicand.smallValue, safeLongToInt(newScale));
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1898742439 = new BigDecimal(this.getUnscaledValue().multiply(
                multiplicand.getUnscaledValue()), safeLongToInt(newScale));
        addTaint(multiplicand.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_1424779176; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1424779176 = varB4EAC82CA7396A68D541C85D26508E83_184391660;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1424779176 = varB4EAC82CA7396A68D541C85D26508E83_234896719;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1424779176 = varB4EAC82CA7396A68D541C85D26508E83_1898742439;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1424779176.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1424779176;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.368 -0400", hash_original_method = "C6525DC236CD6C9B7DA82BBF840C4183", hash_generated_method = "07A05C69D10BDDEBFB8F61D58A82B3C3")
    public BigDecimal multiply(BigDecimal multiplicand, MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_274505146 = null; //Variable for return #1
        BigDecimal result = multiply(multiplicand);
        result.inplaceRound(mc);
        varB4EAC82CA7396A68D541C85D26508E83_274505146 = result;
        addTaint(multiplicand.getTaint());
        addTaint(mc.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_274505146.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_274505146;
        // ---------- Original Method ----------
        //BigDecimal result = multiply(multiplicand);
        //result.inplaceRound(mc);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.369 -0400", hash_original_method = "462A8C7DE00EC7C78FAA3F28B925453C", hash_generated_method = "A88BB3E964A1CA8FEB76C70CA6375200")
    public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1266871397 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1266871397 = divide(divisor, scale, RoundingMode.valueOf(roundingMode));
        addTaint(divisor.getTaint());
        addTaint(scale);
        addTaint(roundingMode);
        varB4EAC82CA7396A68D541C85D26508E83_1266871397.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1266871397;
        // ---------- Original Method ----------
        //return divide(divisor, scale, RoundingMode.valueOf(roundingMode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.371 -0400", hash_original_method = "CAF40474AE4670E1A6482892323F28CB", hash_generated_method = "C9AAF6897B730085E033FB78B9C57861")
    public BigDecimal divide(BigDecimal divisor, int scale, RoundingMode roundingMode) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_348153704 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1095659850 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_970144186 = null; //Variable for return #3
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_60023013 = null; //Variable for return #4
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean var16B71EEA539968D0D6443F65DF69A37A_661721056 = (divisor.isZero());
            {
                if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("Division by zero");
            } //End block
        } //End collapsed parenthetic
        long diffScale = ((long)this.scale - divisor.scale) - scale;
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_348153704 = dividePrimitiveLongs(this.smallValue,
                        divisor.smallValue,
                        scale,
                        roundingMode );
            } //End block
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1095659850 = dividePrimitiveLongs(this.smallValue,
                            divisor.smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)diffScale],
                            scale,
                            roundingMode);
                } //End block
            } //End block
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_970144186 = dividePrimitiveLongs(this.smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)-diffScale],
                            divisor.smallValue,
                            scale,
                            roundingMode);
                } //End block
            } //End block
        } //End block
        BigInteger scaledDividend = this.getUnscaledValue();
        BigInteger scaledDivisor = divisor.getUnscaledValue();
        {
            scaledDivisor = Multiplication.multiplyByTenPow(scaledDivisor, (int)diffScale);
        } //End block
        {
            scaledDividend  = Multiplication.multiplyByTenPow(scaledDividend, (int)-diffScale);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_60023013 = divideBigIntegers(scaledDividend, scaledDivisor, scale, roundingMode);
        addTaint(divisor.getTaint());
        addTaint(scale);
        addTaint(roundingMode.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_872735705; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_872735705 = varB4EAC82CA7396A68D541C85D26508E83_348153704;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_872735705 = varB4EAC82CA7396A68D541C85D26508E83_1095659850;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_872735705 = varB4EAC82CA7396A68D541C85D26508E83_970144186;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_872735705 = varB4EAC82CA7396A68D541C85D26508E83_60023013;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_872735705.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_872735705;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.372 -0400", hash_original_method = "2C6660A6ECCA62927D6A6B71E8D4804F", hash_generated_method = "17327562182E328E67FA10D102A83C93")
    public BigDecimal divide(BigDecimal divisor, int roundingMode) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_879832546 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_879832546 = divide(divisor, scale, RoundingMode.valueOf(roundingMode));
        addTaint(divisor.getTaint());
        addTaint(roundingMode);
        varB4EAC82CA7396A68D541C85D26508E83_879832546.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_879832546;
        // ---------- Original Method ----------
        //return divide(divisor, scale, RoundingMode.valueOf(roundingMode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.373 -0400", hash_original_method = "5F1D784ACEFAF8C3A3D46632D71C7A92", hash_generated_method = "1CE63D2760623602596FBC64840BA042")
    public BigDecimal divide(BigDecimal divisor, RoundingMode roundingMode) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1462354958 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1462354958 = divide(divisor, scale, roundingMode);
        addTaint(divisor.getTaint());
        addTaint(roundingMode.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1462354958.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1462354958;
        // ---------- Original Method ----------
        //return divide(divisor, scale, roundingMode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.375 -0400", hash_original_method = "A7E2E0DD5FAFAFB93C0707787850F19F", hash_generated_method = "2BF95B9867D38CD104F76EC3E3730BC1")
    public BigDecimal divide(BigDecimal divisor) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_925403196 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1119012589 = null; //Variable for return #2
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
        {
            boolean var16B71EEA539968D0D6443F65DF69A37A_2069649827 = (divisor.isZero());
            {
                if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("Division by zero");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB2E2B4410DE8AB2A2A71DAF68472D9F8_361858936 = (p.signum() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_925403196 = zeroScaledBy(diffScale);
            } //End block
        } //End collapsed parenthetic
        gcd = p.gcd(q);
        p = p.divide(gcd);
        q = q.divide(gcd);
        k = q.getLowestSetBit();
        q = q.shiftRight(k);
        {
            quotAndRem = q.divideAndRemainder(FIVE_POW[i]);
            {
                boolean var56D8F8621CBF2F8B7CF2D0AA5E63D82E_1416593326 = (quotAndRem[1].signum() == 0);
                {
                    l += i;
                    q = quotAndRem[0];
                } //End block
                {
                    i = 1;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var1CE2A649CF548A0B382B8CA8D0531C0B_1848967448 = (!q.abs().equals(BigInteger.ONE));
            {
                if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("Non-terminating decimal expansion; no exact representable decimal result");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var1BE70AB41E4F878C9E96CBD045BE82F6_138634170 = (q.signum() < 0);
            {
                p = p.negate();
            } //End block
        } //End collapsed parenthetic
        newScale = safeLongToInt(diffScale + Math.max(k, l));
        i = k - l;
        p = (i > 0) ? Multiplication.multiplyByFivePow(p, i)
        : p.shiftLeft(-i);
        varB4EAC82CA7396A68D541C85D26508E83_1119012589 = new BigDecimal(p, newScale);
        addTaint(divisor.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_914811102; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_914811102 = varB4EAC82CA7396A68D541C85D26508E83_925403196;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_914811102 = varB4EAC82CA7396A68D541C85D26508E83_1119012589;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_914811102.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_914811102;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.377 -0400", hash_original_method = "E69AD17C16131904FF2F859BB6B8C3E0", hash_generated_method = "000D78F2FDE29D3D7636B0CBB9ACA598")
    public BigDecimal divide(BigDecimal divisor, MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_244311035 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_2070805394 = null; //Variable for return #2
        long trailingZeros = mc.getPrecision() + 2L
                + divisor.approxPrecision() - approxPrecision();
        long diffScale = (long)scale - divisor.scale;
        long newScale = diffScale;
        int compRem;
        int i = 1;
        int lastPow = TEN_POW.length - 1;
        BigInteger integerQuot;
        BigInteger quotAndRem[] = {getUnscaledValue()};
        {
            boolean var1683CA06D9CD829DE790F5F76B24F12F_1497281642 = ((mc.getPrecision() == 0) || (this.isZero())
        || (divisor.isZero()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_244311035 = this.divide(divisor);
            } //End block
        } //End collapsed parenthetic
        {
            quotAndRem[0] = getUnscaledValue().multiply( Multiplication.powerOf10(trailingZeros) );
            newScale += trailingZeros;
        } //End block
        quotAndRem = quotAndRem[0].divideAndRemainder( divisor.getUnscaledValue() );
        integerQuot = quotAndRem[0];
        {
            boolean var519F85BAAFA83462D286D0E95FC021F7_110446011 = (quotAndRem[1].signum() != 0);
            {
                compRem = quotAndRem[1].shiftLeftOneBit().compareTo( divisor.getUnscaledValue() );
                integerQuot = integerQuot.multiply(BigInteger.TEN)
            .add(BigInteger.valueOf(quotAndRem[0].signum() * (5 + compRem)));
            } //End block
            {
                {
                    boolean varD5D87A190E12C2B6C000E3A9EE8BEC7C_1593925030 = (!integerQuot.testBit(0));
                    {
                        quotAndRem = integerQuot.divideAndRemainder(TEN_POW[i]);
                        {
                            boolean var3E10FD41A4FC7BC4D742233E45936456_522385156 = ((quotAndRem[1].signum() == 0)
                        && (newScale - i >= diffScale));
                            {
                                newScale -= i;
                                integerQuot = quotAndRem[0];
                            } //End block
                            {
                                i = 1;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2070805394 = new BigDecimal(integerQuot, safeLongToInt(newScale), mc);
        addTaint(divisor.getTaint());
        addTaint(mc.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_2130875964; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2130875964 = varB4EAC82CA7396A68D541C85D26508E83_244311035;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2130875964 = varB4EAC82CA7396A68D541C85D26508E83_2070805394;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2130875964.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2130875964;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.379 -0400", hash_original_method = "370FC7E5A1C86319865302EB832BE460", hash_generated_method = "7AC01EB7D1C0A02CBDB22A2D7CB9DBB1")
    public BigDecimal divideToIntegralValue(BigDecimal divisor) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_296998916 = null; //Variable for return #1
        BigInteger integralValue;
        BigInteger powerOfTen;
        BigInteger quotAndRem[] = {getUnscaledValue()};
        long newScale = (long)this.scale - divisor.scale;
        long tempScale = 0;
        int i = 1;
        int lastPow = TEN_POW.length - 1;
        {
            boolean var16B71EEA539968D0D6443F65DF69A37A_1757081297 = (divisor.isZero());
            {
                if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("Division by zero");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var43466425044C6001C715D4744A155718_179490078 = ((divisor.approxPrecision() + newScale > this.approxPrecision() + 1L)
        || (this.isZero()));
            {
                integralValue = BigInteger.ZERO;
            } //End block
            {
                integralValue = getUnscaledValue().divide( divisor.getUnscaledValue() );
            } //End block
            {
                powerOfTen = Multiplication.powerOf10(newScale);
                integralValue = getUnscaledValue().divide( divisor.getUnscaledValue().multiply(powerOfTen) );
                integralValue = integralValue.multiply(powerOfTen);
            } //End block
            {
                powerOfTen = Multiplication.powerOf10(-newScale);
                integralValue = getUnscaledValue().multiply(powerOfTen).divide( divisor.getUnscaledValue() );
                {
                    boolean varB25FF58A943269DCC68D0EBDAAE99805_564367132 = (!integralValue.testBit(0));
                    {
                        quotAndRem = integralValue.divideAndRemainder(TEN_POW[i]);
                        {
                            boolean varCAFFF7801493718308EEBDB0CF811D99_820999789 = ((quotAndRem[1].signum() == 0)
                        && (tempScale - i >= newScale));
                            {
                                tempScale -= i;
                                integralValue = quotAndRem[0];
                            } //End block
                            {
                                i = 1;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                newScale = tempScale;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_296998916 = ((integralValue.signum() == 0)
        ? zeroScaledBy(newScale)
                : new BigDecimal(integralValue, safeLongToInt(newScale)));
        addTaint(divisor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_296998916.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_296998916;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.381 -0400", hash_original_method = "15ECC758BA9BF5EB2D64CC984DE4A4C9", hash_generated_method = "73CB1A06EF520CF9C7CCFF7903CE861A")
    public BigDecimal divideToIntegralValue(BigDecimal divisor, MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1681764717 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_2046931625 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_761522366 = null; //Variable for return #3
        int mcPrecision = mc.getPrecision();
        int diffPrecision = this.precision() - divisor.precision();
        int lastPow = TEN_POW.length - 1;
        long diffScale = (long)this.scale - divisor.scale;
        long newScale = diffScale;
        long quotPrecision = diffPrecision - diffScale + 1;
        BigInteger quotAndRem[] = new BigInteger[2];
        {
            boolean var78FFC807FB0EE7608CAD1113F89EFF01_1587660584 = ((mcPrecision == 0) || (this.isZero()) || (divisor.isZero()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1681764717 = this.divideToIntegralValue(divisor);
            } //End block
        } //End collapsed parenthetic
        {
            quotAndRem[0] = BigInteger.ZERO;
        } //End block
        {
            quotAndRem[0] = this.getUnscaledValue().divide( divisor.getUnscaledValue() );
        } //End block
        {
            quotAndRem[0] = this.getUnscaledValue().divide(
                    divisor.getUnscaledValue().multiply(Multiplication.powerOf10(diffScale)) );
            newScale = Math.min(diffScale, Math.max(mcPrecision - quotPrecision + 1, 0));
            quotAndRem[0] = quotAndRem[0].multiply(Multiplication.powerOf10(newScale));
        } //End block
        {
            long exp = Math.min(-diffScale, Math.max((long)mcPrecision - diffPrecision, 0));
            long compRemDiv;
            quotAndRem = this.getUnscaledValue().multiply(Multiplication.powerOf10(exp)).
                    divideAndRemainder(divisor.getUnscaledValue());
            newScale += exp;
            exp = -newScale;
            {
                boolean var69073325A671CB393E6130C2ECC3A3F2_261499145 = ((quotAndRem[1].signum() != 0) && (exp > 0));
                {
                    compRemDiv = (new BigDecimal(quotAndRem[1])).precision()
                + exp - divisor.precision();
                    {
                        quotAndRem[1] = quotAndRem[1].multiply(Multiplication.powerOf10(exp)).
                            divide(divisor.getUnscaledValue());
                        compRemDiv = Math.abs(quotAndRem[1].signum());
                    } //End block
                    {
                        if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("Division impossible");
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean varF8DE899E76CEFE3C6AC3D8F3E0A27654_1506240981 = (quotAndRem[0].signum() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_2046931625 = zeroScaledBy(diffScale);
            } //End block
        } //End collapsed parenthetic
        BigInteger strippedBI = quotAndRem[0];
        BigDecimal integralValue = new BigDecimal(quotAndRem[0]);
        long resultPrecision = integralValue.precision();
        int i = 1;
        {
            boolean varFEBA48CABF974070FADE4D4043F8A64F_1810513959 = (!strippedBI.testBit(0));
            {
                quotAndRem = strippedBI.divideAndRemainder(TEN_POW[i]);
                {
                    boolean varA720D7C810B13E104AD0745BE1B37072_1811973489 = ((quotAndRem[1].signum() == 0) &&
                    ((resultPrecision - i >= mcPrecision)
                    || (newScale - i >= diffScale)));
                    {
                        resultPrecision -= i;
                        newScale -= i;
                        strippedBI = quotAndRem[0];
                    } //End block
                    {
                        i = 1;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("Division impossible");
        } //End block
        integralValue.scale = safeLongToInt(newScale);
        integralValue.setUnscaledValue(strippedBI);
        varB4EAC82CA7396A68D541C85D26508E83_761522366 = integralValue;
        addTaint(divisor.getTaint());
        addTaint(mc.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_1801815572; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1801815572 = varB4EAC82CA7396A68D541C85D26508E83_1681764717;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1801815572 = varB4EAC82CA7396A68D541C85D26508E83_2046931625;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1801815572 = varB4EAC82CA7396A68D541C85D26508E83_761522366;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1801815572.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1801815572;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.382 -0400", hash_original_method = "EBDBD1FB251B2EF1CF76CA97862E098F", hash_generated_method = "D08C75DFEF4D1525C91B2CFB8609C42F")
    public BigDecimal remainder(BigDecimal divisor) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_99964534 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_99964534 = divideAndRemainder(divisor)[1];
        addTaint(divisor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_99964534.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_99964534;
        // ---------- Original Method ----------
        //return divideAndRemainder(divisor)[1];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.384 -0400", hash_original_method = "B5D8082AFBB8A8B7919238963079BE8E", hash_generated_method = "27E37FA32CE3508738D0029EF369520D")
    public BigDecimal remainder(BigDecimal divisor, MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1222791179 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1222791179 = divideAndRemainder(divisor, mc)[1];
        addTaint(divisor.getTaint());
        addTaint(mc.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1222791179.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1222791179;
        // ---------- Original Method ----------
        //return divideAndRemainder(divisor, mc)[1];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.385 -0400", hash_original_method = "078854E5024F03E2C96ABDC15A98EC28", hash_generated_method = "65D368C0714B2DE6A584C6E2C5305B6D")
    public BigDecimal[] divideAndRemainder(BigDecimal divisor) {
        BigDecimal[] varB4EAC82CA7396A68D541C85D26508E83_341857162 = null; //Variable for return #1
        BigDecimal quotAndRem[] = new BigDecimal[2];
        quotAndRem[0] = this.divideToIntegralValue(divisor);
        quotAndRem[1] = this.subtract( quotAndRem[0].multiply(divisor) );
        varB4EAC82CA7396A68D541C85D26508E83_341857162 = quotAndRem;
        addTaint(divisor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_341857162.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_341857162;
        // ---------- Original Method ----------
        //BigDecimal quotAndRem[] = new BigDecimal[2];
        //quotAndRem[0] = this.divideToIntegralValue(divisor);
        //quotAndRem[1] = this.subtract( quotAndRem[0].multiply(divisor) );
        //return quotAndRem;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.387 -0400", hash_original_method = "36D2BD3305B7DD5EA1226F88EE4D6B60", hash_generated_method = "123CAFA8AD5A85171B2A380387C40438")
    public BigDecimal[] divideAndRemainder(BigDecimal divisor, MathContext mc) {
        BigDecimal[] varB4EAC82CA7396A68D541C85D26508E83_964370187 = null; //Variable for return #1
        BigDecimal quotAndRem[] = new BigDecimal[2];
        quotAndRem[0] = this.divideToIntegralValue(divisor, mc);
        quotAndRem[1] = this.subtract( quotAndRem[0].multiply(divisor) );
        varB4EAC82CA7396A68D541C85D26508E83_964370187 = quotAndRem;
        addTaint(divisor.getTaint());
        addTaint(mc.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_964370187.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_964370187;
        // ---------- Original Method ----------
        //BigDecimal quotAndRem[] = new BigDecimal[2];
        //quotAndRem[0] = this.divideToIntegralValue(divisor, mc);
        //quotAndRem[1] = this.subtract( quotAndRem[0].multiply(divisor) );
        //return quotAndRem;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.391 -0400", hash_original_method = "0BA2A5CD46D450D69AC19365E08D7C5C", hash_generated_method = "ACD9F254658A82D98B44D54101957CCD")
    public BigDecimal pow(int n) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1955975263 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1770215802 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1955975263 = ONE;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("Invalid operation");
        } //End block
        long newScale = scale * (long)n;
        varB4EAC82CA7396A68D541C85D26508E83_1770215802 = isZero() ? zeroScaledBy(newScale)
                : new BigDecimal(getUnscaledValue().pow(n), safeLongToInt(newScale));
        addTaint(n);
        BigDecimal varA7E53CE21691AB073D9660D615818899_214188087; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_214188087 = varB4EAC82CA7396A68D541C85D26508E83_1955975263;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_214188087 = varB4EAC82CA7396A68D541C85D26508E83_1770215802;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_214188087.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_214188087;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.394 -0400", hash_original_method = "C8938AEDE89231C5AAB8CE41C7A1DE59", hash_generated_method = "87605BF7DFE1A19D690FA5549BACE583")
    public BigDecimal pow(int n, MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_2058705811 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_536236739 = null; //Variable for return #2
        int m = Math.abs(n);
        int mcPrecision = mc.getPrecision();
        int elength = (int)Math.log10(m) + 1;
        int oneBitMask;
        BigDecimal accum;
        MathContext newPrecision = mc;
        {
            boolean varBF14C2086BC4C6404D3417B69099E0C2_1673828606 = ((n == 0) || ((isZero()) && (n > 0)));
            {
                varB4EAC82CA7396A68D541C85D26508E83_2058705811 = pow(n);
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("Invalid operation");
        } //End block
        {
            newPrecision = new MathContext( mcPrecision + elength + 1,
                    mc.getRoundingMode());
        } //End block
        accum = round(newPrecision);
        oneBitMask = Integer.highestOneBit(m) >> 1;
        {
            accum = accum.multiply(accum, newPrecision);
            {
                accum = accum.multiply(this, newPrecision);
            } //End block
            oneBitMask >>= 1;
        } //End block
        {
            accum = ONE.divide(accum, newPrecision);
        } //End block
        accum.inplaceRound(mc);
        varB4EAC82CA7396A68D541C85D26508E83_536236739 = accum;
        addTaint(n);
        addTaint(mc.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_1896468649; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1896468649 = varB4EAC82CA7396A68D541C85D26508E83_2058705811;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1896468649 = varB4EAC82CA7396A68D541C85D26508E83_536236739;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1896468649.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1896468649;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.395 -0400", hash_original_method = "DF1CB3D65F2CAE136A2978BF9C5604B4", hash_generated_method = "0FF9ED1A38A8F3A356EA5DAB8ABDAE70")
    public BigDecimal abs() {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_143603598 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_143603598 = ((signum() < 0) ? negate() : this);
        varB4EAC82CA7396A68D541C85D26508E83_143603598.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_143603598;
        // ---------- Original Method ----------
        //return ((signum() < 0) ? negate() : this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.396 -0400", hash_original_method = "BC934B9214C4819E6720F567E9C870B9", hash_generated_method = "F17CB5AD9FF8CA31A769C706062A2B6C")
    public BigDecimal abs(MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_875245878 = null; //Variable for return #1
        BigDecimal result = abs();
        result.inplaceRound(mc);
        varB4EAC82CA7396A68D541C85D26508E83_875245878 = result;
        addTaint(mc.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_875245878.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_875245878;
        // ---------- Original Method ----------
        //BigDecimal result = abs();
        //result.inplaceRound(mc);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.398 -0400", hash_original_method = "434D4E2CBF9E3CBC75126AF4586B2CF0", hash_generated_method = "9D0FA93995BCAF0F1536C5FDE88F416F")
    public BigDecimal negate() {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_508008732 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1718354357 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_508008732 = valueOf(-smallValue,scale);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1718354357 = new BigDecimal(getUnscaledValue().negate(), scale);
        BigDecimal varA7E53CE21691AB073D9660D615818899_670524757; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_670524757 = varB4EAC82CA7396A68D541C85D26508E83_508008732;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_670524757 = varB4EAC82CA7396A68D541C85D26508E83_1718354357;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_670524757.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_670524757;
        // ---------- Original Method ----------
        //if(bitLength < 63 || (bitLength == 63 && smallValue!=Long.MIN_VALUE)) {
            //return valueOf(-smallValue,scale);
        //}
        //return new BigDecimal(getUnscaledValue().negate(), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.399 -0400", hash_original_method = "1D24791EE4ADD6E04558F8C92319E898", hash_generated_method = "C17ACB4DF5BBEB06D246632D3FDB762A")
    public BigDecimal negate(MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_33572975 = null; //Variable for return #1
        BigDecimal result = negate();
        result.inplaceRound(mc);
        varB4EAC82CA7396A68D541C85D26508E83_33572975 = result;
        addTaint(mc.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_33572975.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_33572975;
        // ---------- Original Method ----------
        //BigDecimal result = negate();
        //result.inplaceRound(mc);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.399 -0400", hash_original_method = "E5A0BEEECFDAB0EB24F23ED92FDA1EE0", hash_generated_method = "B6983E356137F29A716B5E5FE8607627")
    public BigDecimal plus() {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_255472821 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_255472821 = this;
        varB4EAC82CA7396A68D541C85D26508E83_255472821.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_255472821;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.400 -0400", hash_original_method = "06DE611812CE14E42B61206CBE361795", hash_generated_method = "0E772745352C6FCE25B10A612CFB6741")
    public BigDecimal plus(MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_2079385758 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2079385758 = round(mc);
        addTaint(mc.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2079385758.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2079385758;
        // ---------- Original Method ----------
        //return round(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.400 -0400", hash_original_method = "CA4E5917AFEF32459FAB7B79AFDA8BD4", hash_generated_method = "3E4BE4C43D421DBBB5396CCEDEA90B62")
    public int signum() {
        {
            int varF032537E263740DA95D3B45D7C943C95_1605185987 = (Long.signum( this.smallValue ));
        } //End block
        int varF8C894AC9EB5FE4FA16D557236C882F9_1829745857 = (getUnscaledValue().signum());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_879958721 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_879958721;
        // ---------- Original Method ----------
        //if( bitLength < 64) {
            //return Long.signum( this.smallValue );
        //}
        //return getUnscaledValue().signum();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.401 -0400", hash_original_method = "F3E74BAAEB162D78F28E445308393563", hash_generated_method = "35B5AD9FF4AC51F4AF0E2B71F7FE6132")
    private boolean isZero() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1756055764 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1756055764;
        // ---------- Original Method ----------
        //return bitLength == 0 && this.smallValue != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.401 -0400", hash_original_method = "5F6F67A9AE4AEECC5BD64D7ACC145B6A", hash_generated_method = "6FB1914216B1AB965B96667CD3C5C996")
    public int scale() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_905334894 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_905334894;
        // ---------- Original Method ----------
        //return scale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.401 -0400", hash_original_method = "6DFBDD0E771CAF738A0C801E888E1E3B", hash_generated_method = "63591CD41EAB1000FCB84D1FBA7B85D4")
    public int precision() {
        int bitLength = this.bitLength;
        {
            precision = 1;
        } //End block
        {
            precision = decimalDigitsInLong(smallValue);
        } //End block
        {
            int decimalDigits = 1 + (int) ((bitLength - 1) * LOG10_2);
            {
                boolean var8743B4113D7AA0C9B3797D73894FAAF3_2116524192 = (getUnscaledValue().divide(Multiplication.powerOf10(decimalDigits)).signum() != 0);
            } //End collapsed parenthetic
            precision = decimalDigits;
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_231087488 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_231087488;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.402 -0400", hash_original_method = "EAD040D94F5F819E555B537F69E87C66", hash_generated_method = "CDFF6C6E3FE261755D8AD10F8AFC6C1F")
    private int decimalDigitsInLong(long value) {
        {
            int index = Arrays.binarySearch(MathUtils.LONG_POWERS_OF_TEN, Math.abs(value));
        } //End block
        addTaint(value);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1024851153 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1024851153;
        // ---------- Original Method ----------
        //if (value == Long.MIN_VALUE) {
            //return 19; 
        //} else {
            //int index = Arrays.binarySearch(MathUtils.LONG_POWERS_OF_TEN, Math.abs(value));
            //return (index < 0) ? (-index - 1) : (index + 1);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.402 -0400", hash_original_method = "067DA515CBCF3B72C5546CE6034B99CF", hash_generated_method = "BE7D1A521AFDE99E7C15EBC57D178F65")
    public BigInteger unscaledValue() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_628059288 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_628059288 = getUnscaledValue();
        varB4EAC82CA7396A68D541C85D26508E83_628059288.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_628059288;
        // ---------- Original Method ----------
        //return getUnscaledValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.403 -0400", hash_original_method = "2FC46B1D06394AF066FA7CDA852A22F8", hash_generated_method = "2217CC4184BB58D2D0CC27C19AEFBDC3")
    public BigDecimal round(MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1174928084 = null; //Variable for return #1
        BigDecimal thisBD = new BigDecimal(getUnscaledValue(), scale);
        thisBD.inplaceRound(mc);
        varB4EAC82CA7396A68D541C85D26508E83_1174928084 = thisBD;
        addTaint(mc.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1174928084.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1174928084;
        // ---------- Original Method ----------
        //BigDecimal thisBD = new BigDecimal(getUnscaledValue(), scale);
        //thisBD.inplaceRound(mc);
        //return thisBD;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.404 -0400", hash_original_method = "7B0F1A102C68137F597240860B4573E3", hash_generated_method = "5E0C59DF4F53B38C94FB4B1518BC4DD0")
    public BigDecimal setScale(int newScale, RoundingMode roundingMode) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1819218809 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_684323352 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1981423365 = null; //Variable for return #3
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_509162753 = null; //Variable for return #4
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1327579360 = null; //Variable for return #5
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        long diffScale = newScale - (long)scale;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1819218809 = this;
        } //End block
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_684323352 = valueOf(this.smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)diffScale],newScale);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1981423365 = new BigDecimal(Multiplication.multiplyByTenPow(getUnscaledValue(),(int)diffScale), newScale);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_509162753 = dividePrimitiveLongs(this.smallValue, MathUtils.LONG_POWERS_OF_TEN[(int)-diffScale], newScale,roundingMode);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1327579360 = divideBigIntegers(this.getUnscaledValue(),Multiplication.powerOf10(-diffScale),newScale,roundingMode);
        addTaint(newScale);
        addTaint(roundingMode.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_1619248895; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1619248895 = varB4EAC82CA7396A68D541C85D26508E83_1819218809;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1619248895 = varB4EAC82CA7396A68D541C85D26508E83_684323352;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1619248895 = varB4EAC82CA7396A68D541C85D26508E83_1981423365;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1619248895 = varB4EAC82CA7396A68D541C85D26508E83_509162753;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1619248895 = varB4EAC82CA7396A68D541C85D26508E83_1327579360;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1619248895.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1619248895;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.405 -0400", hash_original_method = "82E5CBCA5195979E97780CEADBFBD3C4", hash_generated_method = "E6CF10F188A7AC7851594DB2D877DD32")
    public BigDecimal setScale(int newScale, int roundingMode) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1040699277 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1040699277 = setScale(newScale, RoundingMode.valueOf(roundingMode));
        addTaint(newScale);
        addTaint(roundingMode);
        varB4EAC82CA7396A68D541C85D26508E83_1040699277.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1040699277;
        // ---------- Original Method ----------
        //return setScale(newScale, RoundingMode.valueOf(roundingMode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.406 -0400", hash_original_method = "ABCD452F1FC16ADBD3F58023EF098557", hash_generated_method = "5317AE4D1C9CE5039AE81201E431A797")
    public BigDecimal setScale(int newScale) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_534983270 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_534983270 = setScale(newScale, RoundingMode.UNNECESSARY);
        addTaint(newScale);
        varB4EAC82CA7396A68D541C85D26508E83_534983270.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_534983270;
        // ---------- Original Method ----------
        //return setScale(newScale, RoundingMode.UNNECESSARY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.407 -0400", hash_original_method = "146C1C6822DF31E0F5C90B0C65347C9D", hash_generated_method = "A7FDBECEEA55F5475328D3F409836953")
    public BigDecimal movePointLeft(int n) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1932603138 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1932603138 = movePoint(scale + (long)n);
        addTaint(n);
        varB4EAC82CA7396A68D541C85D26508E83_1932603138.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1932603138;
        // ---------- Original Method ----------
        //return movePoint(scale + (long)n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.409 -0400", hash_original_method = "EF6481821B33DB93DBF91CDB78772ACF", hash_generated_method = "E90A594CF20D84DD8DCB09109F6B7C34")
    private BigDecimal movePoint(long newScale) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_271686901 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1521693270 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_760289607 = null; //Variable for return #3
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_474611700 = null; //Variable for return #4
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_98199286 = null; //Variable for return #5
        {
            boolean var2CC22727CE5D95FFA6F7D70A538860F0_2115992972 = (isZero());
            {
                varB4EAC82CA7396A68D541C85D26508E83_271686901 = zeroScaledBy(Math.max(newScale, 0));
            } //End block
        } //End collapsed parenthetic
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1521693270 = valueOf(smallValue, safeLongToInt(newScale));
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_760289607 = new BigDecimal(getUnscaledValue(), safeLongToInt(newScale));
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_474611700 = valueOf(smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)-newScale],0);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_98199286 = new BigDecimal(Multiplication.multiplyByTenPow(
                getUnscaledValue(), safeLongToInt(-newScale)), 0);
        addTaint(newScale);
        BigDecimal varA7E53CE21691AB073D9660D615818899_562849005; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_562849005 = varB4EAC82CA7396A68D541C85D26508E83_271686901;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_562849005 = varB4EAC82CA7396A68D541C85D26508E83_1521693270;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_562849005 = varB4EAC82CA7396A68D541C85D26508E83_760289607;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_562849005 = varB4EAC82CA7396A68D541C85D26508E83_474611700;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_562849005 = varB4EAC82CA7396A68D541C85D26508E83_98199286;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_562849005.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_562849005;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.410 -0400", hash_original_method = "07D5C3611C3ACCF090DC6103621F9345", hash_generated_method = "BE3E06F045743B089876E075FA048822")
    public BigDecimal movePointRight(int n) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_290052688 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_290052688 = movePoint(scale - (long)n);
        addTaint(n);
        varB4EAC82CA7396A68D541C85D26508E83_290052688.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_290052688;
        // ---------- Original Method ----------
        //return movePoint(scale - (long)n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.411 -0400", hash_original_method = "D86719E7E7F9F283B32E5780DA0BBE23", hash_generated_method = "F9CCF3088ECF57ED0A582793E2E6EBD2")
    public BigDecimal scaleByPowerOfTen(int n) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_2013049960 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_597773091 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1996946817 = null; //Variable for return #3
        long newScale = scale - (long)n;
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_2013049960 = zeroScaledBy( newScale );
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_597773091 = valueOf(smallValue, safeLongToInt(newScale));
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1996946817 = new BigDecimal(getUnscaledValue(), safeLongToInt(newScale));
        addTaint(n);
        BigDecimal varA7E53CE21691AB073D9660D615818899_1412097135; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1412097135 = varB4EAC82CA7396A68D541C85D26508E83_2013049960;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1412097135 = varB4EAC82CA7396A68D541C85D26508E83_597773091;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1412097135 = varB4EAC82CA7396A68D541C85D26508E83_1996946817;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1412097135.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1412097135;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.412 -0400", hash_original_method = "6A410D70691999CADF96A81B91BD2E64", hash_generated_method = "25F352C8D7368CA63B537BFC0D4747FA")
    public BigDecimal stripTrailingZeros() {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1622051884 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1512250520 = null; //Variable for return #2
        int i = 1;
        int lastPow = TEN_POW.length - 1;
        long newScale = scale;
        {
            boolean var2CC22727CE5D95FFA6F7D70A538860F0_599132482 = (isZero());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1622051884 = this;
            } //End block
        } //End collapsed parenthetic
        BigInteger strippedBI = getUnscaledValue();
        BigInteger[] quotAndRem;
        {
            boolean varFEBA48CABF974070FADE4D4043F8A64F_149558010 = (!strippedBI.testBit(0));
            {
                quotAndRem = strippedBI.divideAndRemainder(TEN_POW[i]);
                {
                    boolean varC86A45592F149ACDEC5EDB396276478E_730649351 = (quotAndRem[1].signum() == 0);
                    {
                        newScale -= i;
                        strippedBI = quotAndRem[0];
                    } //End block
                    {
                        i = 1;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1512250520 = new BigDecimal(strippedBI, safeLongToInt(newScale));
        BigDecimal varA7E53CE21691AB073D9660D615818899_49964408; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_49964408 = varB4EAC82CA7396A68D541C85D26508E83_1622051884;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_49964408 = varB4EAC82CA7396A68D541C85D26508E83_1512250520;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_49964408.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_49964408;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.413 -0400", hash_original_method = "1C45ED34C4C1F5BEBD8BB8EF3CBE1A6B", hash_generated_method = "4F3940A24C35F01BBC414A003FBABB4B")
    public int compareTo(BigDecimal val) {
        int thisSign = signum();
        int valueSign = val.signum();
        {
            long diffScale = (long)this.scale - val.scale;
            int diffPrecision = this.approxPrecision() - val.approxPrecision();
            {
                BigInteger thisUnscaled = this.getUnscaledValue();
                BigInteger valUnscaled = val.getUnscaledValue();
                {
                    thisUnscaled = thisUnscaled.multiply(Multiplication.powerOf10(-diffScale));
                } //End block
                {
                    valUnscaled = valUnscaled.multiply(Multiplication.powerOf10(diffScale));
                } //End block
                int varCE3C94A5820498591ABCE6F39E1FAD3F_117360454 = (thisUnscaled.compareTo(valUnscaled));
            } //End block
        } //End block
        addTaint(val.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_271410905 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_271410905;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.414 -0400", hash_original_method = "310E755E039C5525B03EE3C0A35D27A8", hash_generated_method = "F1B325A7EFAAA38D74185AAFFF4FFA9D")
    @Override
    public boolean equals(Object x) {
        {
            BigDecimal x1 = (BigDecimal) x;
            boolean var001662A341C29FE1FFD924EE7151116A_422756505 = (x1.scale == scale
                   && (bitLength < 64 ? (x1.smallValue == smallValue)
                    : intVal.equals(x1.intVal))); //DSFIXME:  CODE0008: Nested ternary operator in expression
        } //End block
        addTaint(x.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1034723154 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1034723154;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.416 -0400", hash_original_method = "F19ED99F66E082325A61ACA186AF7454", hash_generated_method = "E7DB8F7AF02AD7F22C2B290D1352808B")
    public BigDecimal min(BigDecimal val) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_986778482 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_986778482 = ((compareTo(val) <= 0) ? this : val);
        addTaint(val.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_986778482.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_986778482;
        // ---------- Original Method ----------
        //return ((compareTo(val) <= 0) ? this : val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.419 -0400", hash_original_method = "4EA6A2C4CEA295044D603E0ACE9B5BC6", hash_generated_method = "EA71B40C9C33F126781461389767712B")
    public BigDecimal max(BigDecimal val) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_66174828 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_66174828 = ((compareTo(val) >= 0) ? this : val);
        addTaint(val.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_66174828.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_66174828;
        // ---------- Original Method ----------
        //return ((compareTo(val) >= 0) ? this : val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.420 -0400", hash_original_method = "F20F131BB03F0B25B12A1EF1F413017D", hash_generated_method = "589F3EBAA0D78BD1CE1675DD7B9DF4A2")
    @Override
    public int hashCode() {
        {
            hashCode = (int)(smallValue & 0xffffffff);
            hashCode = 33 * hashCode +  (int)((smallValue >> 32) & 0xffffffff);
            hashCode = 17 * hashCode + scale;
        } //End block
        hashCode = 17 * intVal.hashCode() + scale;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1383163256 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1383163256;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.422 -0400", hash_original_method = "7C431BE8FF70735180E872A989DC1E52", hash_generated_method = "528BDD802468B4717EC3FA33AAB9FFAB")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_840725378 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_659760248 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_157962888 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_382389404 = null; //Variable for return #4
        {
            varB4EAC82CA7396A68D541C85D26508E83_840725378 = toStringImage;
        } //End block
        {
            toStringImage = Conversion.toDecimalScaledString(smallValue,scale);
            varB4EAC82CA7396A68D541C85D26508E83_659760248 = toStringImage;
        } //End block
        String intString = getUnscaledValue().toString();
        {
            varB4EAC82CA7396A68D541C85D26508E83_157962888 = intString;
        } //End block
        int begin;
        boolean var5FFC8DC69DEA58D4CEC873F848ECF641_980222246 = ((getUnscaledValue().signum() < 0));
        begin = 2;
        begin = 1;
        int end = intString.length();
        long exponent = -(long)scale + end - begin;
        StringBuilder result = new StringBuilder();
        result.append(intString);
        {
            {
                result.insert(end - scale, '.');
            } //End block
            {
                result.insert(begin - 1, "0.");
                result.insert(begin + 1, CH_ZEROS, 0, -(int)exponent - 1);
            } //End block
        } //End block
        {
            {
                result.insert(begin, '.');
            } //End block
            result.insert(end, 'E');
            {
                result.insert(++end, '+');
            } //End block
            result.insert(++end, Long.toString(exponent));
        } //End block
        toStringImage = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_382389404 = toStringImage;
        String varA7E53CE21691AB073D9660D615818899_5379439; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_5379439 = varB4EAC82CA7396A68D541C85D26508E83_840725378;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_5379439 = varB4EAC82CA7396A68D541C85D26508E83_659760248;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_5379439 = varB4EAC82CA7396A68D541C85D26508E83_157962888;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_5379439 = varB4EAC82CA7396A68D541C85D26508E83_382389404;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_5379439.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_5379439;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.424 -0400", hash_original_method = "37C393D601D5FE9982CCA7EB2837999F", hash_generated_method = "AB35B1DAF07526ADBDF05C7B557EB814")
    public String toEngineeringString() {
        String varB4EAC82CA7396A68D541C85D26508E83_282607551 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_634452795 = null; //Variable for return #2
        String intString = getUnscaledValue().toString();
        {
            varB4EAC82CA7396A68D541C85D26508E83_282607551 = intString;
        } //End block
        int begin;
        boolean var5FFC8DC69DEA58D4CEC873F848ECF641_2004232948 = ((getUnscaledValue().signum() < 0));
        begin = 2;
        begin = 1;
        int end = intString.length();
        long exponent = -(long)scale + end - begin;
        StringBuilder result = new StringBuilder(intString);
        {
            {
                result.insert(end - scale, '.');
            } //End block
            {
                result.insert(begin - 1, "0.");
                result.insert(begin + 1, CH_ZEROS, 0, -(int)exponent - 1);
            } //End block
        } //End block
        {
            int delta = end - begin;
            int rem = (int)(exponent % 3);
            {
                {
                    boolean varF1275512AD4A7A2856364C7EFBECF78A_1296797634 = (getUnscaledValue().signum() == 0);
                    {
                        rem = (rem < 0) ? -rem : 3 - rem;
                        exponent += rem;
                    } //End block
                    {
                        rem = (rem < 0) ? rem + 3 : rem;
                        exponent -= rem;
                        begin += rem;
                    } //End block
                } //End collapsed parenthetic
                {
                    {
                        int i = rem - delta;
                        {
                            result.insert(end++, '0');
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            {
                result.insert(begin, '.');
            } //End block
            {
                result.insert(end, 'E');
                {
                    result.insert(++end, '+');
                } //End block
                result.insert(++end, Long.toString(exponent));
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_634452795 = result.toString();
        String varA7E53CE21691AB073D9660D615818899_1339670377; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1339670377 = varB4EAC82CA7396A68D541C85D26508E83_282607551;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1339670377 = varB4EAC82CA7396A68D541C85D26508E83_634452795;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1339670377.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1339670377;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.425 -0400", hash_original_method = "F2C3CA97C72252FC482FDCEF1D32932E", hash_generated_method = "C0B2C184D33B0880E2817548F92E9327")
    public String toPlainString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1333526010 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1428548628 = null; //Variable for return #2
        String intStr = getUnscaledValue().toString();
        {
            boolean var5EBF43068CE74A5170A1EF5C21021CBF_113287311 = ((scale == 0) || ((isZero()) && (scale < 0)));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1333526010 = intStr;
            } //End block
        } //End collapsed parenthetic
        int begin;
        boolean var515FA627C40C3884068623DD22E9034F_1281977392 = ((signum() < 0));
        begin = 1;
        begin = 0;
        int delta = scale;
        StringBuilder result = new StringBuilder(intStr.length() + 1 + Math.abs(scale));
        {
            result.append('-');
        } //End block
        {
            delta -= (intStr.length() - begin);
            {
                result.append("0.");
                {
                    delta -= CH_ZEROS.length;
                    {
                        result.append(CH_ZEROS);
                    } //End block
                } //End collapsed parenthetic
                result.append(CH_ZEROS, 0, delta);
                result.append(intStr.substring(begin));
            } //End block
            {
                delta = begin - delta;
                result.append(intStr.substring(begin, delta));
                result.append('.');
                result.append(intStr.substring(delta));
            } //End block
        } //End block
        {
            result.append(intStr.substring(begin));
            {
                delta += CH_ZEROS.length;
                {
                    result.append(CH_ZEROS);
                } //End block
            } //End collapsed parenthetic
            result.append(CH_ZEROS, 0, -delta);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1428548628 = result.toString();
        String varA7E53CE21691AB073D9660D615818899_1796346998; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1796346998 = varB4EAC82CA7396A68D541C85D26508E83_1333526010;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1796346998 = varB4EAC82CA7396A68D541C85D26508E83_1428548628;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1796346998.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1796346998;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.426 -0400", hash_original_method = "E90ADE3EE93FD433EFA047972DEC5382", hash_generated_method = "2C8ECCCBAA23884595C0F62A2162537D")
    public BigInteger toBigInteger() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1393355179 = null; //Variable for return #1
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_534734092 = null; //Variable for return #2
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1374278032 = null; //Variable for return #3
        {
            boolean var527650A3DE5B2457ABCDED439E32377E_1738734170 = ((scale == 0) || (isZero()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1393355179 = getUnscaledValue();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_534734092 = getUnscaledValue().multiply(Multiplication.powerOf10(-(long)scale));
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1374278032 = getUnscaledValue().divide(Multiplication.powerOf10(scale));
            } //End block
        } //End collapsed parenthetic
        BigInteger varA7E53CE21691AB073D9660D615818899_199317337; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_199317337 = varB4EAC82CA7396A68D541C85D26508E83_1393355179;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_199317337 = varB4EAC82CA7396A68D541C85D26508E83_534734092;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_199317337 = varB4EAC82CA7396A68D541C85D26508E83_1374278032;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_199317337.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_199317337;
        // ---------- Original Method ----------
        //if ((scale == 0) || (isZero())) {
            //return getUnscaledValue();
        //} else if (scale < 0) {
            //return getUnscaledValue().multiply(Multiplication.powerOf10(-(long)scale));
        //} else {
            //return getUnscaledValue().divide(Multiplication.powerOf10(scale));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.428 -0400", hash_original_method = "0E78A189176A3E6769EBE407FB203DE6", hash_generated_method = "FE36D7626E04C3A6CAA1B91767A2551B")
    public BigInteger toBigIntegerExact() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1092003810 = null; //Variable for return #1
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1331540254 = null; //Variable for return #2
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1283624830 = null; //Variable for return #3
        {
            boolean var527650A3DE5B2457ABCDED439E32377E_115203592 = ((scale == 0) || (isZero()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1092003810 = getUnscaledValue();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1331540254 = getUnscaledValue().multiply(Multiplication.powerOf10(-(long)scale));
            } //End block
            {
                BigInteger[] integerAndFraction;
                {
                    boolean varDA526623548FC456E3243F91470F7749_405018844 = ((scale > approxPrecision()) || (scale > getUnscaledValue().getLowestSetBit()));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("Rounding necessary");
                    } //End block
                } //End collapsed parenthetic
                integerAndFraction = getUnscaledValue().divideAndRemainder(Multiplication.powerOf10(scale));
                {
                    boolean var295E569F979C75DF93112C8D385DE9FD_1303002015 = (integerAndFraction[1].signum() != 0);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("Rounding necessary");
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_1283624830 = integerAndFraction[0];
            } //End block
        } //End collapsed parenthetic
        BigInteger varA7E53CE21691AB073D9660D615818899_98493683; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_98493683 = varB4EAC82CA7396A68D541C85D26508E83_1092003810;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_98493683 = varB4EAC82CA7396A68D541C85D26508E83_1331540254;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_98493683 = varB4EAC82CA7396A68D541C85D26508E83_1283624830;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_98493683.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_98493683;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.429 -0400", hash_original_method = "A54EDCAFB9A559A1B4EB83484BB75122", hash_generated_method = "74826A2F341EFA3CC482EE854BC1C3EF")
    @Override
    public long longValue() {
        long var02BCFECEB27CDDF7BA27A8716D0E8C08_1998793038 = (((scale <= -64) || (scale > approxPrecision()) ? 0L
                : toBigInteger().longValue())); //DSFIXME:  CODE0008: Nested ternary operator in expression
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1281614689 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1281614689;
        // ---------- Original Method ----------
        //return ((scale <= -64) || (scale > approxPrecision()) ? 0L
                //: toBigInteger().longValue());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.430 -0400", hash_original_method = "FC36A176D0180DB1420333E5E0A5371B", hash_generated_method = "98BFBD2ED040986147046486C833AA0D")
    public long longValueExact() {
        long var911FCAB8DFB4008CF2390984C1A72430_1239821360 = (valueExact(64));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2072719302 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2072719302;
        // ---------- Original Method ----------
        //return valueExact(64);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.430 -0400", hash_original_method = "C22AEC57669E1045E01A9977FB32CBED", hash_generated_method = "19194C97A09B6B2178E01BD1C38818F4")
    @Override
    public int intValue() {
        int var260F64E277497774BB8037E8D91956FC_851703675 = (((scale <= -32) || (scale > approxPrecision())
        ? 0
                : toBigInteger().intValue())); //DSFIXME:  CODE0008: Nested ternary operator in expression
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_719229477 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_719229477;
        // ---------- Original Method ----------
        //return ((scale <= -32) || (scale > approxPrecision())
        //? 0
                //: toBigInteger().intValue());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.431 -0400", hash_original_method = "3865E14853C36D94FA2C26348C89A3B8", hash_generated_method = "02D6E172212D30A7FF369D7A157B10C8")
    public int intValueExact() {
        int var86C4522ACDF35D342B59DBE535781A9E_1382675668 = ((int)valueExact(32));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_606369359 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_606369359;
        // ---------- Original Method ----------
        //return (int)valueExact(32);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.431 -0400", hash_original_method = "D0948D36E91C12739D01E1A7BD76887B", hash_generated_method = "3F5D8DC37121A7BA44669969D3408449")
    public short shortValueExact() {
        short varA81ACCE95AC11A2580319A9BFEB7E9B2_1045962922 = ((short)valueExact(16));
        short var4F09DAA9D95BCB166A302407A0E0BABE_1270877247 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1270877247;
        // ---------- Original Method ----------
        //return (short)valueExact(16);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.432 -0400", hash_original_method = "D6CE76A6DF6EC675E82ED0D5BFCEAF06", hash_generated_method = "832BA3EAA01EB9672E0D8A2BFF232B71")
    public byte byteValueExact() {
        byte varD83BA7BD5DF600388856A2C30163822F_58431845 = ((byte)valueExact(8));
        byte var40EA57D3EE3C07BF1C102B466E1C3091_931423104 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_931423104;
        // ---------- Original Method ----------
        //return (byte)valueExact(8);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.433 -0400", hash_original_method = "4137052570907849FFBB7EF546BA389D", hash_generated_method = "618ECA2A6E8740796B67A1836D8F9B80")
    @Override
    public float floatValue() {
        float floatResult = signum();
        long powerOfTwo = this.bitLength - (long)(scale / LOG10_2);
        {
            floatResult *= 0.0f;
        } //End block
        {
            floatResult *= Float.POSITIVE_INFINITY;
        } //End block
        {
            floatResult = (float)doubleValue();
        } //End block
        float var546ADE640B6EDFBC8A086EF31347E768_1410999087 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1410999087;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.434 -0400", hash_original_method = "73F99D783081712086B11A0804DADCB9", hash_generated_method = "D722A17E3A4831EF3EEA832245515F33")
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
        mantissa = getUnscaledValue().abs();
        {
            mantissa = mantissa.multiply(Multiplication.powerOf10(-scale));
        } //End block
        {
            BigInteger quotAndRem[];
            BigInteger powerOfTen = Multiplication.powerOf10(scale);
            int k = 100 - (int)powerOfTwo;
            int compRem;
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
        {
            bits = mantissa.shiftRight(discardedSize).longValue();
            tempBits = bits;
            {
                bits += 2;
            } //End block
        } //End block
        {
            bits = mantissa.longValue() << -discardedSize;
            tempBits = bits;
            {
                bits += 2;
            } //End block
        } //End block
        {
            bits >>= 1;
            exponent += discardedSize;
        } //End block
        {
            bits >>= 2;
            exponent += discardedSize + 1;
        } //End block
        {
            bits = tempBits >> 1;
            tempBits = bits & (-1L >>> (63 + exponent));
            bits >>= (-exponent );
            {
                bits += 1;
            } //End block
            exponent = 0;
            bits >>= 1;
        } //End block
        bits = (sign & 0x8000000000000000L) | ((long)exponent << 52)
                | (bits & 0xFFFFFFFFFFFFFL);
        double varCD654D4151F8E678076C18FA9FDC44FD_1086465190 = (Double.longBitsToDouble(bits));
        double varE8CD7DA078A86726031AD64F35F5A6C0_1897496009 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1897496009;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.435 -0400", hash_original_method = "AE130D2701C769DD6982173139D47466", hash_generated_method = "4AA4C88A02C0C718A5C5F9014938705F")
    public BigDecimal ulp() {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_382998385 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_382998385 = valueOf(1, scale);
        varB4EAC82CA7396A68D541C85D26508E83_382998385.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_382998385;
        // ---------- Original Method ----------
        //return valueOf(1, scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.436 -0400", hash_original_method = "55CD7E6ED2002FE9D7C30850FBD08759", hash_generated_method = "573A7880109F0733DFEB981C4D990D00")
    private void inplaceRound(MathContext mc) {
        int mcPrecision = mc.getPrecision();
        {
            boolean var6F010C2CB7AD09A8BC94F0B71513AC32_462327850 = (approxPrecision() < mcPrecision || mcPrecision == 0);
        } //End collapsed parenthetic
        int discardedPrecision = precision() - mcPrecision;
        {
            smallRound(mc, discardedPrecision);
        } //End block
        BigInteger sizeOfFraction = Multiplication.powerOf10(discardedPrecision);
        BigInteger[] integerAndFraction = getUnscaledValue().divideAndRemainder(sizeOfFraction);
        long newScale = (long)scale - discardedPrecision;
        int compRem;
        BigDecimal tempBD;
        {
            boolean var117BFEC09FEE1A0EBD26552B3C18D98D_572742280 = (integerAndFraction[1].signum() != 0);
            {
                compRem = (integerAndFraction[1].abs().shiftLeftOneBit().compareTo(sizeOfFraction));
                compRem =  roundingBehavior( integerAndFraction[0].testBit(0) ? 1 : 0,
                    integerAndFraction[1].signum() * (5 + compRem),
                    mc.getRoundingMode());
                {
                    integerAndFraction[0] = integerAndFraction[0].add(BigInteger.valueOf(compRem));
                } //End block
                tempBD = new BigDecimal(integerAndFraction[0]);
                {
                    boolean var10B8B9353B6BDAF0B62CA0F73EC5E632_1055190751 = (tempBD.precision() > mcPrecision);
                    {
                        integerAndFraction[0] = integerAndFraction[0].divide(BigInteger.TEN);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        scale = safeLongToInt(newScale);
        precision = mcPrecision;
        setUnscaledValue(integerAndFraction[0]);
        addTaint(mc.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static int longCompareTo(long value1, long value2) {
        return value1 > value2 ? 1 : (value1 < value2 ? -1 : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.438 -0400", hash_original_method = "7FBE752FF3FF6B350050AE2B0F2B0308", hash_generated_method = "980774848CA059BB8613D8DF6DABC2C3")
    private void smallRound(MathContext mc, int discardedPrecision) {
        long sizeOfFraction = MathUtils.LONG_POWERS_OF_TEN[discardedPrecision];
        long newScale = (long)scale - discardedPrecision;
        long unscaledVal = smallValue;
        long integer = unscaledVal / sizeOfFraction;
        long fraction = unscaledVal % sizeOfFraction;
        int compRem;
        {
            compRem = longCompareTo(Math.abs(fraction) * 2, sizeOfFraction);
            integer += roundingBehavior( ((int)integer) & 1,
                    Long.signum(fraction) * (5 + compRem),
                    mc.getRoundingMode());
            {
                boolean var23E618BB7F5984728547DADF43F7547E_992297769 = (Math.log10(Math.abs(integer)) >= mc.getPrecision());
                {
                    integer /= 10;
                } //End block
            } //End collapsed parenthetic
        } //End block
        scale = safeLongToInt(newScale);
        precision = mc.getPrecision();
        smallValue = integer;
        bitLength = bitLength(integer);
        intVal = null;
        addTaint(discardedPrecision);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.442 -0400", hash_original_method = "77E444DFD73510CC8BF3E35576C17A04", hash_generated_method = "9D660698D646E32126DFCE94D554AEA5")
    private long valueExact(int bitLengthOfType) {
        BigInteger bigInteger = toBigIntegerExact();
        {
            boolean var34AD3BA92A978E0890FA3B0628CDDC06_598261801 = (bigInteger.bitLength() < bitLengthOfType);
            {
                long var9D31F6DC18FE28EB42FCCA0D0D616FEB_898238058 = (bigInteger.longValue());
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("Rounding necessary");
        addTaint(bitLengthOfType);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_798841921 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_798841921;
        // ---------- Original Method ----------
        //BigInteger bigInteger = toBigIntegerExact();
        //if (bigInteger.bitLength() < bitLengthOfType) {
            //return bigInteger.longValue();
        //}
        //throw new ArithmeticException("Rounding necessary");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.443 -0400", hash_original_method = "610DE3E95388579A8DD4E22BDEDE3C6E", hash_generated_method = "5BDAB296920962FB0F06AF3B7AF21DA9")
    private int approxPrecision() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1470008315 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1470008315;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.445 -0400", hash_original_method = "886E4F08C2196C85465CF795B505FE44", hash_generated_method = "BDA0F1AC8B98ACD4B899312EFE36FE5A")
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        in.defaultReadObject();
        this.bitLength = intVal.bitLength();
        {
            this.smallValue = intVal.longValue();
        } //End block
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        //in.defaultReadObject();
        //this.bitLength = intVal.bitLength();
        //if (this.bitLength < 64) {
            //this.smallValue = intVal.longValue();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.445 -0400", hash_original_method = "19FA8CC309F5EC9C814FD711C697099A", hash_generated_method = "8A0F3297B8DAFE46D5786E4A20AAF3B5")
    private void writeObject(ObjectOutputStream out) throws IOException {
        getUnscaledValue();
        out.defaultWriteObject();
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //getUnscaledValue();
        //out.defaultWriteObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.446 -0400", hash_original_method = "1C1109E2DBDCFAE7331AD37D197254D0", hash_generated_method = "A041D6F7498429D1F7F6DC9C0BE035D2")
    private BigInteger getUnscaledValue() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_734294738 = null; //Variable for return #1
        {
            intVal = BigInteger.valueOf(smallValue);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_734294738 = intVal;
        varB4EAC82CA7396A68D541C85D26508E83_734294738.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_734294738;
        // ---------- Original Method ----------
        //if(intVal == null) {
            //intVal = BigInteger.valueOf(smallValue);
        //}
        //return intVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.446 -0400", hash_original_method = "3BE919C32007DA5FAF4FB8B842EE650C", hash_generated_method = "49E7AC88CEF6902CE7BE924ADF202E8D")
    private void setUnscaledValue(BigInteger unscaledValue) {
        this.intVal = unscaledValue;
        this.bitLength = unscaledValue.bitLength();
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.447 -0400", hash_original_field = "877CBC7572A1F4C5C4A5EF0FCDBA91C3", hash_generated_field = "B6EECEB04C7C8E9BC518DBA316290DA7")

    public static final int ROUND_UP = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.447 -0400", hash_original_field = "D2CF03DE063925E19E13C52C8FBE1929", hash_generated_field = "454999CD924CB489896B8D343444FE92")

    public static final int ROUND_DOWN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.447 -0400", hash_original_field = "AAC8B6F1C4763B9728AB52AE15952AF6", hash_generated_field = "3C0D845F7C2F954D2ED7E86C0AE35835")

    public static final int ROUND_CEILING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.447 -0400", hash_original_field = "7503CC26EC44F42386A1D0025B5AEF97", hash_generated_field = "53D60190BBA8538A982DF868F4C6200E")

    public static final int ROUND_FLOOR = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.447 -0400", hash_original_field = "7E7DD45EF4EB3B06BFEF96EA4B0DD84D", hash_generated_field = "F10F1696D5C52C5E6B4B91643A72CEBE")

    public static final int ROUND_HALF_UP = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.447 -0400", hash_original_field = "20B7B28A1B56AD4CEA47F72CC0696346", hash_generated_field = "1619429E1C6C75DCE5756A9CF242CB9E")

    public static final int ROUND_HALF_DOWN = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.447 -0400", hash_original_field = "B3DCF23AE156DDE73D388CA751C9365F", hash_generated_field = "737A62C6AFA4A3B8167B738F856B0DEA")

    public static final int ROUND_HALF_EVEN = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.447 -0400", hash_original_field = "22697FABD637B187447A670B355A0081", hash_generated_field = "C5A01DD93D79DC15583A8D0F0236E74E")

    public static final int ROUND_UNNECESSARY = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.447 -0400", hash_original_field = "116BD32AD0E75158256F445ABDC8389D", hash_generated_field = "732C210E7618496C3947E6F404C23DC5")

    private static final long serialVersionUID = 6108874887143696463L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.447 -0400", hash_original_field = "7458DC5DA966512012D7187A9F089DAC", hash_generated_field = "E93F26BA415E2A63370EECFB39CABE9A")

    private static final double LOG10_2 = 0.3010299956639812;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.447 -0400", hash_original_field = "5515FC399FA5591FAB09427986B893AC", hash_generated_field = "BC1FA69034FA076F552F1F096B6FE848")

    private static BigInteger[] FIVE_POW;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.447 -0400", hash_original_field = "6890CCC61C514170BDE91D0B4ED71AF6", hash_generated_field = "487DAC2FC944E340E99AE2E5C8C63B33")

    private static BigInteger[] TEN_POW;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.448 -0400", hash_original_field = "B3E64594B71C88A1FCA0FDDB1DB0D932", hash_generated_field = "7278FA9BE84E3C616E4421DE5FF2F206")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.448 -0400", hash_original_field = "BE202B01F91923E667B3B16B069D07DC", hash_generated_field = "FD0F7EAC9A9246982008521CC29799A7")

    private static final int[] LONG_FIVE_POW_BIT_LENGTH = new int[LONG_FIVE_POW.length];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.448 -0400", hash_original_field = "157379F1EEDF7417D34D4EA991CF2184", hash_generated_field = "9DFBCE8298EAB00B86718FC0B2D88337")

    private static final int[] LONG_POWERS_OF_TEN_BIT_LENGTH = new int[MathUtils.LONG_POWERS_OF_TEN.length];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.448 -0400", hash_original_field = "921789C958D668713F05F9FFE836B8C7", hash_generated_field = "E22EB04741B2BFD88E960FE524D60B1A")

    private static final int BI_SCALED_BY_ZERO_LENGTH = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.448 -0400", hash_original_field = "717A7640C2D9003B18C4055EC0C50419", hash_generated_field = "5B020D40BF07C0EC94E4149184B70A65")

    private static final BigDecimal[] BI_SCALED_BY_ZERO = new BigDecimal[BI_SCALED_BY_ZERO_LENGTH];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.448 -0400", hash_original_field = "39586D78C45D7A19439688292151133A", hash_generated_field = "5C08AD19ABFF43369109F8D9272F2B04")

    private static final BigDecimal[] ZERO_SCALED_BY = new BigDecimal[11];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.448 -0400", hash_original_field = "94F236C8393993A7B9287704666BFBEE", hash_generated_field = "12A340B61FB03C00F6D04EBF43FAFF99")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.448 -0400", hash_original_field = "B1F433B3E708BA2079293308D7CA4999", hash_generated_field = "E2BD5BBDB2DF3AE4973FDC84A00AF40A")

    public static final BigDecimal ZERO = new BigDecimal(0, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.448 -0400", hash_original_field = "3A7ACF4CD264E65305ECE3D1A439ECF7", hash_generated_field = "9F34079F2BD32FDD32B17DD6B2BC0759")

    public static final BigDecimal ONE = new BigDecimal(1, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:52.448 -0400", hash_original_field = "831A4D5A2871A70F006594FB3523DE19", hash_generated_field = "7D43F273171CCD7BF176CC18D6BEE813")

    public static final BigDecimal TEN = new BigDecimal(10, 0);
}

