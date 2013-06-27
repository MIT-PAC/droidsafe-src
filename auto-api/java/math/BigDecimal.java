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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.943 -0400", hash_original_field = "0A495C22CEE2486109FF49D52FAB7401", hash_generated_field = "326D03DFD6F64D4B3F1173FBD427B520")

    private transient String toStringImage = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.943 -0400", hash_original_field = "B81E47D2AA677809E4BE3C9232B2407F", hash_generated_field = "3D9A07F218385AD7A5B345B923EAF46E")

    private transient int hashCode = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.943 -0400", hash_original_field = "3A1F983ED27316FA36EAAFE36DA5649F", hash_generated_field = "E1C21CCC8969038A086EDD16030014B8")

    private BigInteger intVal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.943 -0400", hash_original_field = "B35AD5BAFCCD957A930C16D5DD131EE4", hash_generated_field = "1C841931B61AD9BC0EB5C76BA4219E64")

    private transient int bitLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.943 -0400", hash_original_field = "412477B04CAB5EE326327BE6C10454DF", hash_generated_field = "27339F171BD0CF229BCBE4E7356A5F0B")

    private transient long smallValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.943 -0400", hash_original_field = "0CB47AEB6E5F9323F0969E628C4E59F5", hash_generated_field = "F9D5D1CA2ABDD82810FF1FE80E0268E6")

    private int scale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.943 -0400", hash_original_field = "46C2159C904EABF687686166E93B72AA", hash_generated_field = "4E7D370BAE76B07332BBBB929C2DF340")

    private transient int precision = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.945 -0400", hash_original_method = "6BC27F867C09C0249873A4D338F8666D", hash_generated_method = "675ADE6C6F01FF4ED08427C7FC23A83B")
    private  BigDecimal(long smallValue, int scale) {
        this.smallValue = smallValue;
        this.scale = scale;
        this.bitLength = bitLength(smallValue);
        // ---------- Original Method ----------
        //this.smallValue = smallValue;
        //this.scale = scale;
        //this.bitLength = bitLength(smallValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.946 -0400", hash_original_method = "9F6CD654516DCD03F33530EDCF81D84D", hash_generated_method = "3DC98F1132A232115D5983B57B665BF0")
    private  BigDecimal(int smallValue, int scale) {
        this.smallValue = smallValue;
        this.scale = scale;
        this.bitLength = bitLength(smallValue);
        // ---------- Original Method ----------
        //this.smallValue = smallValue;
        //this.scale = scale;
        //this.bitLength = bitLength(smallValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.955 -0400", hash_original_method = "374C425CF4086C798A21EEA670343536", hash_generated_method = "48AD6D480865736E81D79F1726CC218F")
    public  BigDecimal(char[] in, int offset, int len) {
        int begin;
        begin = offset;
        int last;
        last = offset + (len - 1);
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
        int bufLength;
        bufLength = 0;
        int counter;
        counter = 0;
        boolean wasNonZero;
        wasNonZero = false;
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
            boolean var61B48B5FEE897AE42C98AFC63C6454F8_2058442837 = (unscaledBuffer.charAt(0) == '-');
        } //End collapsed parenthetic
        addTaint(in[0]);
        addTaint(len);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.956 -0400", hash_original_method = "021DB19003FFCB38960FC53E0DB20D11", hash_generated_method = "275FB9D57B18A3B85184CAF9CE70BF00")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.956 -0400", hash_original_method = "2CA49E7A005F756FE298C75D3E276FBD", hash_generated_method = "B4FD1176C71EA8991071A29C074F944A")
    public  BigDecimal(char[] in) {
        this(in, 0, in.length);
        addTaint(in[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.978 -0400", hash_original_method = "24A3A809E90D8D728111B1E9DFB6AE2B", hash_generated_method = "09C060845E8F5FF4F77D83B14AFC3E66")
    public  BigDecimal(char[] in, MathContext mc) {
        this(in, 0, in.length);
        inplaceRound(mc);
        addTaint(in[0]);
        addTaint(mc.getTaint());
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.979 -0400", hash_original_method = "97883F5F25D8C2D5B9EC2501AC7ECDA2", hash_generated_method = "F8C02FFBA49B73A7A22E83CA112803F6")
    public  BigDecimal(String val) {
        this(val.toCharArray(), 0, val.length());
        addTaint(val.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.980 -0400", hash_original_method = "65FA78E7CB5F82CDA77BAA4B434CD165", hash_generated_method = "76DAE502211644C5F6D20BA849076BCF")
    public  BigDecimal(String val, MathContext mc) {
        this(val.toCharArray(), 0, val.length());
        inplaceRound(mc);
        addTaint(val.getTaint());
        addTaint(mc.getTaint());
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.981 -0400", hash_original_method = "A550123107439183BDAF78BFBC33380D", hash_generated_method = "A89220B940373C38D7612CB8EBB04F14")
    public  BigDecimal(double val) {
        {
            boolean var07ED44AABC248720567522E1772FEBCB_2065396112 = (Double.isInfinite(val) || Double.isNaN(val));
            {
                if (DroidSafeAndroidRuntime.control) throw new NumberFormatException("Infinity or NaN: " + val);
            } //End block
        } //End collapsed parenthetic
        long bits;
        bits = Double.doubleToLongBits(val);
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
        int mantissaBits;
        mantissaBits = bitLength(mantissa);
        {
            bitLength = mantissaBits == 0 ? 0 : mantissaBits - scale;
            {
                smallValue = mantissa << (-scale);
            } //End block
            {
                BigInt bi;
                bi = new BigInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.982 -0400", hash_original_method = "A301A521891A68A20E545213C1CF7F7F", hash_generated_method = "61E4530A94C3F954071D1E31BF762714")
    public  BigDecimal(double val, MathContext mc) {
        this(val);
        inplaceRound(mc);
        addTaint(val);
        addTaint(mc.getTaint());
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.995 -0400", hash_original_method = "35103202AC4D8227390F065BF679C471", hash_generated_method = "D504D0B814354DD64C3D66DE08011646")
    public  BigDecimal(BigInteger val) {
        this(val, 0);
        addTaint(val.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.995 -0400", hash_original_method = "4DD15F45D533F2889A2A72BE2BF675A6", hash_generated_method = "D67E2735ED92664B1FB6B7B749D87D08")
    public  BigDecimal(BigInteger val, MathContext mc) {
        this(val);
        inplaceRound(mc);
        addTaint(val.getTaint());
        addTaint(mc.getTaint());
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.999 -0400", hash_original_method = "E5BF86952E31D522F2FAABCF30464562", hash_generated_method = "72E89060793A1AA3A659E8DA2DA29B04")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.000 -0400", hash_original_method = "59F34EC0A04F061EC6FA9A9EFC322A4C", hash_generated_method = "32E65AEFC7C0BD2C974B7F3E9297CD5F")
    public  BigDecimal(BigInteger unscaledVal, int scale, MathContext mc) {
        this(unscaledVal, scale);
        inplaceRound(mc);
        addTaint(unscaledVal.getTaint());
        addTaint(scale);
        addTaint(mc.getTaint());
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.000 -0400", hash_original_method = "5359C9BE484C4A97ECD231D115B1BCDB", hash_generated_method = "D648D7F23799D878CE7DE9DEA41AED6E")
    public  BigDecimal(int val) {
        this(val,0);
        addTaint(val);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.001 -0400", hash_original_method = "919820155B3DF9AD0A8E776AC27BF824", hash_generated_method = "1FFD2ADDE931D52B57DBB399AEFC9F40")
    public  BigDecimal(int val, MathContext mc) {
        this(val,0);
        inplaceRound(mc);
        addTaint(val);
        addTaint(mc.getTaint());
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.004 -0400", hash_original_method = "3B8082CDF108D6321820C9FA6A6A1D42", hash_generated_method = "5CD5A0914C8C99DBF87C1115B74C5DD3")
    public  BigDecimal(long val) {
        this(val,0);
        addTaint(val);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.004 -0400", hash_original_method = "E0851629E0BD0FDB6233816479A7E4A8", hash_generated_method = "4C9B12BD7553D77E861C40B68F1A9173")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.012 -0400", hash_original_method = "1DCD141A7D54B6C70CB155CC6BA0AB13", hash_generated_method = "E1CDA93B5172FE8E8549910CFA800086")
    public BigDecimal add(BigDecimal augend) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_412181157 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_145992134 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1463651681 = null; //Variable for return #3
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1817129847 = null; //Variable for return #4
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1946028520 = null; //Variable for return #5
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1177296062 = null; //Variable for return #6
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_789686859 = null; //Variable for return #7
        int diffScale;
        diffScale = this.scale - augend.scale;
        {
            boolean var3ACAB80A5F99B906541DA9D0E446A470_2069578966 = (this.isZero());
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_412181157 = augend;
                } //End block
                {
                    boolean varB1908C261B547BD48CB51E1D5EF611A0_1191514060 = (augend.isZero());
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_145992134 = this;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean var133F1DCA67F284EB5AB919CE41BBA5B6_685602228 = (augend.isZero());
                {
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1463651681 = this;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            {
                boolean varD111D3273CD5455867ABFC03E36CFA28_1508879323 = (Math.max(this.bitLength, augend.bitLength) + 1 < 64);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1817129847 = valueOf(this.smallValue + augend.smallValue, this.scale);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1946028520 = new BigDecimal(this.getUnscaledValue().add(augend.getUnscaledValue()), this.scale);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1177296062 = addAndMult10(this, augend, diffScale);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_789686859 = addAndMult10(augend, this, -diffScale);
        } //End block
        addTaint(augend.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_408481429; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_408481429 = varB4EAC82CA7396A68D541C85D26508E83_412181157;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_408481429 = varB4EAC82CA7396A68D541C85D26508E83_145992134;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_408481429 = varB4EAC82CA7396A68D541C85D26508E83_1463651681;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_408481429 = varB4EAC82CA7396A68D541C85D26508E83_1817129847;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_408481429 = varB4EAC82CA7396A68D541C85D26508E83_1946028520;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_408481429 = varB4EAC82CA7396A68D541C85D26508E83_1177296062;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_408481429 = varB4EAC82CA7396A68D541C85D26508E83_789686859;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_408481429.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_408481429;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.041 -0400", hash_original_method = "37BDD6EE07613654EB8729406017A0AF", hash_generated_method = "7D2739390BAFF3AB08DB020FD9AEB175")
    public BigDecimal add(BigDecimal augend, MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_2115765835 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_564089361 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1040165993 = null; //Variable for return #3
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_583858447 = null; //Variable for return #4
        BigDecimal larger;
        BigDecimal smaller;
        BigInteger tempBI;
        long diffScale;
        diffScale = (long)this.scale - augend.scale;
        int largerSignum;
        {
            boolean varF966BD50F4EF9C0D05117401635B161E_845244819 = ((augend.isZero()) || (this.isZero())
                || (mc.getPrecision() == 0));
            {
                varB4EAC82CA7396A68D541C85D26508E83_2115765835 = add(augend).round(mc);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var9070081FF1C89B57CAC464C53A5B31A2_1448863063 = (this.approxPrecision() < diffScale - 1);
            {
                larger = augend;
                smaller = this;
            } //End block
            {
                boolean varA5DA4849944CED3DDED10285985020BE_2110350835 = (augend.approxPrecision() < -diffScale - 1);
                {
                    larger = this;
                    smaller = augend;
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_564089361 = add(augend).round(mc);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean var8AFB7E1F21C67DCCAA005AEF04A9DB11_1737041412 = (mc.getPrecision() >= larger.approxPrecision());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1040165993 = add(augend).round(mc);
            } //End block
        } //End collapsed parenthetic
        largerSignum = larger.signum();
        {
            boolean varFDAEFA28D5E9E9B77BEF39981CC0842F_1728325820 = (largerSignum == smaller.signum());
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
        varB4EAC82CA7396A68D541C85D26508E83_583858447 = larger.round(mc);
        addTaint(augend.getTaint());
        addTaint(mc.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_539549150; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_539549150 = varB4EAC82CA7396A68D541C85D26508E83_2115765835;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_539549150 = varB4EAC82CA7396A68D541C85D26508E83_564089361;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_539549150 = varB4EAC82CA7396A68D541C85D26508E83_1040165993;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_539549150 = varB4EAC82CA7396A68D541C85D26508E83_583858447;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_539549150.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_539549150;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.043 -0400", hash_original_method = "463B27AE9A4331C20782D4CCC2226F12", hash_generated_method = "AFB37387676B6635AE959B9F21956622")
    public BigDecimal subtract(BigDecimal subtrahend) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1846087537 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_568579154 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1635730605 = null; //Variable for return #3
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1535468679 = null; //Variable for return #4
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1798780968 = null; //Variable for return #5
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_341169963 = null; //Variable for return #6
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1357081565 = null; //Variable for return #7
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_833070763 = null; //Variable for return #8
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1273827932 = null; //Variable for return #9
        int diffScale;
        diffScale = this.scale - subtrahend.scale;
        {
            boolean var3ACAB80A5F99B906541DA9D0E446A470_1031562098 = (this.isZero());
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1846087537 = subtrahend.negate();
                } //End block
                {
                    boolean varD03C6CECC51E3DE3442E3774C1567DCF_539178755 = (subtrahend.isZero());
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_568579154 = this;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean var9EB1DAC8BC084CCA52BBCF84A22F0C39_271579674 = (subtrahend.isZero());
                {
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1635730605 = this;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            {
                boolean var716C9DB8DD66F0858D9B5D3E8474C979_1766237591 = (Math.max(this.bitLength, subtrahend.bitLength) + 1 < 64);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1535468679 = valueOf(this.smallValue - subtrahend.smallValue,this.scale);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1798780968 = new BigDecimal(this.getUnscaledValue().subtract(subtrahend.getUnscaledValue()), this.scale);
        } //End block
        {
            {
                boolean var920C6D472A61AE7DE113537D4CAEABA3_1470455935 = (diffScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                    Math.max(this.bitLength,subtrahend.bitLength+LONG_POWERS_OF_TEN_BIT_LENGTH[diffScale])+1<64);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_341169963 = valueOf(this.smallValue-subtrahend.smallValue*MathUtils.LONG_POWERS_OF_TEN[diffScale],this.scale);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1357081565 = new BigDecimal(this.getUnscaledValue().subtract(
                    Multiplication.multiplyByTenPow(subtrahend.getUnscaledValue(),diffScale)), this.scale);
        } //End block
        {
            diffScale = -diffScale;
            {
                boolean var71AEEAE804686FEE863217A58EF3D39E_1082818582 = (diffScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                    Math.max(this.bitLength+LONG_POWERS_OF_TEN_BIT_LENGTH[diffScale],subtrahend.bitLength)+1<64);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_833070763 = valueOf(this.smallValue*MathUtils.LONG_POWERS_OF_TEN[diffScale]-subtrahend.smallValue,subtrahend.scale);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1273827932 = new BigDecimal(Multiplication.multiplyByTenPow(this.getUnscaledValue(),diffScale)
            .subtract(subtrahend.getUnscaledValue()), subtrahend.scale);
        } //End block
        addTaint(subtrahend.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_1983326206; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1983326206 = varB4EAC82CA7396A68D541C85D26508E83_1846087537;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1983326206 = varB4EAC82CA7396A68D541C85D26508E83_568579154;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1983326206 = varB4EAC82CA7396A68D541C85D26508E83_1635730605;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1983326206 = varB4EAC82CA7396A68D541C85D26508E83_1535468679;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1983326206 = varB4EAC82CA7396A68D541C85D26508E83_1798780968;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1983326206 = varB4EAC82CA7396A68D541C85D26508E83_341169963;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_1983326206 = varB4EAC82CA7396A68D541C85D26508E83_1357081565;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_1983326206 = varB4EAC82CA7396A68D541C85D26508E83_833070763;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1983326206 = varB4EAC82CA7396A68D541C85D26508E83_1273827932;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1983326206.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1983326206;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.066 -0400", hash_original_method = "427D658D2E18BC359A41906DA92107B2", hash_generated_method = "F2F5D5FC2AF4FA7C27DAB0D65840A216")
    public BigDecimal subtract(BigDecimal subtrahend, MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_166576960 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1206433082 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1866468392 = null; //Variable for return #3
        long diffScale;
        diffScale = subtrahend.scale - (long)this.scale;
        int thisSignum;
        BigDecimal leftOperand;
        BigInteger tempBI;
        {
            boolean varFD92EBCDA78B63D052A84F60541F229A_389224986 = ((subtrahend.isZero()) || (this.isZero())
                || (mc.getPrecision() == 0));
            {
                varB4EAC82CA7396A68D541C85D26508E83_166576960 = subtract(subtrahend).round(mc);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var89DC8760BF7238399EC83E1D522E73AD_546959113 = (subtrahend.approxPrecision() < diffScale - 1);
            {
                {
                    boolean varD9AB7589FCBDAD8F096FC84E02A2A50D_276460474 = (mc.getPrecision() < this.approxPrecision());
                    {
                        thisSignum = this.signum();
                        {
                            boolean var62FB1B54913969022251702D5200468F_1393534505 = (thisSignum != subtrahend.signum());
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
                        varB4EAC82CA7396A68D541C85D26508E83_1206433082 = leftOperand.round(mc);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1866468392 = subtract(subtrahend).round(mc);
        addTaint(subtrahend.getTaint());
        addTaint(mc.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_1844366172; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1844366172 = varB4EAC82CA7396A68D541C85D26508E83_166576960;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1844366172 = varB4EAC82CA7396A68D541C85D26508E83_1206433082;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1844366172 = varB4EAC82CA7396A68D541C85D26508E83_1866468392;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1844366172.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1844366172;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.090 -0400", hash_original_method = "0CD1948BD2366020AE6A84C7902D73D6", hash_generated_method = "EC4D6DD831F978E0F132E2664E1844A9")
    public BigDecimal multiply(BigDecimal multiplicand) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_636949721 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_23718093 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_922168682 = null; //Variable for return #3
        long newScale;
        newScale = (long)this.scale + multiplicand.scale;
        {
            boolean var94085E900CFE8C8A5270601770788621_2117908660 = ((this.isZero()) || (multiplicand.isZero()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_636949721 = zeroScaledBy(newScale);
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_23718093 = valueOf(this.smallValue*multiplicand.smallValue, safeLongToInt(newScale));
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_922168682 = new BigDecimal(this.getUnscaledValue().multiply(
                multiplicand.getUnscaledValue()), safeLongToInt(newScale));
        addTaint(multiplicand.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_1288929040; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1288929040 = varB4EAC82CA7396A68D541C85D26508E83_636949721;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1288929040 = varB4EAC82CA7396A68D541C85D26508E83_23718093;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1288929040 = varB4EAC82CA7396A68D541C85D26508E83_922168682;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1288929040.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1288929040;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.091 -0400", hash_original_method = "C6525DC236CD6C9B7DA82BBF840C4183", hash_generated_method = "7EAB5BCDD761B61E627F8AE5DC23C031")
    public BigDecimal multiply(BigDecimal multiplicand, MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_303339607 = null; //Variable for return #1
        BigDecimal result;
        result = multiply(multiplicand);
        result.inplaceRound(mc);
        varB4EAC82CA7396A68D541C85D26508E83_303339607 = result;
        addTaint(multiplicand.getTaint());
        addTaint(mc.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_303339607.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_303339607;
        // ---------- Original Method ----------
        //BigDecimal result = multiply(multiplicand);
        //result.inplaceRound(mc);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.091 -0400", hash_original_method = "462A8C7DE00EC7C78FAA3F28B925453C", hash_generated_method = "9999C5013E93FC0A3AFC6B446137745F")
    public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_349173402 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_349173402 = divide(divisor, scale, RoundingMode.valueOf(roundingMode));
        addTaint(divisor.getTaint());
        addTaint(scale);
        addTaint(roundingMode);
        varB4EAC82CA7396A68D541C85D26508E83_349173402.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_349173402;
        // ---------- Original Method ----------
        //return divide(divisor, scale, RoundingMode.valueOf(roundingMode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.097 -0400", hash_original_method = "CAF40474AE4670E1A6482892323F28CB", hash_generated_method = "4C18E656E402E99F1F54378CAD0D2EEB")
    public BigDecimal divide(BigDecimal divisor, int scale, RoundingMode roundingMode) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_346091073 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1142813205 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_529661584 = null; //Variable for return #3
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_15225633 = null; //Variable for return #4
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean var16B71EEA539968D0D6443F65DF69A37A_1741754849 = (divisor.isZero());
            {
                if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("Division by zero");
            } //End block
        } //End collapsed parenthetic
        long diffScale;
        diffScale = ((long)this.scale - divisor.scale) - scale;
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_346091073 = dividePrimitiveLongs(this.smallValue,
                        divisor.smallValue,
                        scale,
                        roundingMode );
            } //End block
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1142813205 = dividePrimitiveLongs(this.smallValue,
                            divisor.smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)diffScale],
                            scale,
                            roundingMode);
                } //End block
            } //End block
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_529661584 = dividePrimitiveLongs(this.smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)-diffScale],
                            divisor.smallValue,
                            scale,
                            roundingMode);
                } //End block
            } //End block
        } //End block
        BigInteger scaledDividend;
        scaledDividend = this.getUnscaledValue();
        BigInteger scaledDivisor;
        scaledDivisor = divisor.getUnscaledValue();
        {
            scaledDivisor = Multiplication.multiplyByTenPow(scaledDivisor, (int)diffScale);
        } //End block
        {
            scaledDividend  = Multiplication.multiplyByTenPow(scaledDividend, (int)-diffScale);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_15225633 = divideBigIntegers(scaledDividend, scaledDivisor, scale, roundingMode);
        addTaint(divisor.getTaint());
        addTaint(scale);
        addTaint(roundingMode.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_626490857; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_626490857 = varB4EAC82CA7396A68D541C85D26508E83_346091073;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_626490857 = varB4EAC82CA7396A68D541C85D26508E83_1142813205;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_626490857 = varB4EAC82CA7396A68D541C85D26508E83_529661584;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_626490857 = varB4EAC82CA7396A68D541C85D26508E83_15225633;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_626490857.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_626490857;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.114 -0400", hash_original_method = "2C6660A6ECCA62927D6A6B71E8D4804F", hash_generated_method = "31431068A3A2A99595728C5F840484BA")
    public BigDecimal divide(BigDecimal divisor, int roundingMode) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_2075167187 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2075167187 = divide(divisor, scale, RoundingMode.valueOf(roundingMode));
        addTaint(divisor.getTaint());
        addTaint(roundingMode);
        varB4EAC82CA7396A68D541C85D26508E83_2075167187.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2075167187;
        // ---------- Original Method ----------
        //return divide(divisor, scale, RoundingMode.valueOf(roundingMode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.115 -0400", hash_original_method = "5F1D784ACEFAF8C3A3D46632D71C7A92", hash_generated_method = "262B11549246B95CE8C2000235D04D13")
    public BigDecimal divide(BigDecimal divisor, RoundingMode roundingMode) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_140593158 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_140593158 = divide(divisor, scale, roundingMode);
        addTaint(divisor.getTaint());
        addTaint(roundingMode.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_140593158.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_140593158;
        // ---------- Original Method ----------
        //return divide(divisor, scale, roundingMode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.141 -0400", hash_original_method = "A7E2E0DD5FAFAFB93C0707787850F19F", hash_generated_method = "B8AA10876415C6953FF325B1964B6E37")
    public BigDecimal divide(BigDecimal divisor) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_600367028 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1571184830 = null; //Variable for return #2
        BigInteger p;
        p = this.getUnscaledValue();
        BigInteger q;
        q = divisor.getUnscaledValue();
        BigInteger gcd;
        BigInteger quotAndRem[];
        long diffScale;
        diffScale = (long)scale - divisor.scale;
        int newScale;
        int k;
        int l;
        l = 0;
        int i;
        i = 1;
        int lastPow;
        lastPow = FIVE_POW.length - 1;
        {
            boolean var16B71EEA539968D0D6443F65DF69A37A_612414766 = (divisor.isZero());
            {
                if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("Division by zero");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB2E2B4410DE8AB2A2A71DAF68472D9F8_207015442 = (p.signum() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_600367028 = zeroScaledBy(diffScale);
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
                boolean var56D8F8621CBF2F8B7CF2D0AA5E63D82E_1834249878 = (quotAndRem[1].signum() == 0);
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
            boolean var1CE2A649CF548A0B382B8CA8D0531C0B_1494355499 = (!q.abs().equals(BigInteger.ONE));
            {
                if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("Non-terminating decimal expansion; no exact representable decimal result");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var1BE70AB41E4F878C9E96CBD045BE82F6_1484150461 = (q.signum() < 0);
            {
                p = p.negate();
            } //End block
        } //End collapsed parenthetic
        newScale = safeLongToInt(diffScale + Math.max(k, l));
        i = k - l;
        p = (i > 0) ? Multiplication.multiplyByFivePow(p, i)
        : p.shiftLeft(-i);
        varB4EAC82CA7396A68D541C85D26508E83_1571184830 = new BigDecimal(p, newScale);
        addTaint(divisor.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_977682901; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_977682901 = varB4EAC82CA7396A68D541C85D26508E83_600367028;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_977682901 = varB4EAC82CA7396A68D541C85D26508E83_1571184830;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_977682901.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_977682901;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.160 -0400", hash_original_method = "E69AD17C16131904FF2F859BB6B8C3E0", hash_generated_method = "65B1418EA030025E197142F2B5C27714")
    public BigDecimal divide(BigDecimal divisor, MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_105155006 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1190503028 = null; //Variable for return #2
        long trailingZeros;
        trailingZeros = mc.getPrecision() + 2L
                + divisor.approxPrecision() - approxPrecision();
        long diffScale;
        diffScale = (long)scale - divisor.scale;
        long newScale;
        newScale = diffScale;
        int compRem;
        int i;
        i = 1;
        int lastPow;
        lastPow = TEN_POW.length - 1;
        BigInteger integerQuot;
        BigInteger quotAndRem[];
        {
            boolean var1683CA06D9CD829DE790F5F76B24F12F_1932275418 = ((mc.getPrecision() == 0) || (this.isZero())
        || (divisor.isZero()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_105155006 = this.divide(divisor);
            } //End block
        } //End collapsed parenthetic
        {
            quotAndRem[0] = getUnscaledValue().multiply( Multiplication.powerOf10(trailingZeros) );
            newScale += trailingZeros;
        } //End block
        quotAndRem = quotAndRem[0].divideAndRemainder( divisor.getUnscaledValue() );
        integerQuot = quotAndRem[0];
        {
            boolean var519F85BAAFA83462D286D0E95FC021F7_70717793 = (quotAndRem[1].signum() != 0);
            {
                compRem = quotAndRem[1].shiftLeftOneBit().compareTo( divisor.getUnscaledValue() );
                integerQuot = integerQuot.multiply(BigInteger.TEN)
            .add(BigInteger.valueOf(quotAndRem[0].signum() * (5 + compRem)));
            } //End block
            {
                {
                    boolean varD5D87A190E12C2B6C000E3A9EE8BEC7C_1012955912 = (!integerQuot.testBit(0));
                    {
                        quotAndRem = integerQuot.divideAndRemainder(TEN_POW[i]);
                        {
                            boolean var3E10FD41A4FC7BC4D742233E45936456_1266986470 = ((quotAndRem[1].signum() == 0)
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
        varB4EAC82CA7396A68D541C85D26508E83_1190503028 = new BigDecimal(integerQuot, safeLongToInt(newScale), mc);
        addTaint(divisor.getTaint());
        addTaint(mc.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_1577202452; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1577202452 = varB4EAC82CA7396A68D541C85D26508E83_105155006;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1577202452 = varB4EAC82CA7396A68D541C85D26508E83_1190503028;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1577202452.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1577202452;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.204 -0400", hash_original_method = "370FC7E5A1C86319865302EB832BE460", hash_generated_method = "B709A31D10CC609CD730A1C57480F58C")
    public BigDecimal divideToIntegralValue(BigDecimal divisor) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_772482199 = null; //Variable for return #1
        BigInteger integralValue;
        BigInteger powerOfTen;
        BigInteger quotAndRem[];
        long newScale;
        newScale = (long)this.scale - divisor.scale;
        long tempScale;
        tempScale = 0;
        int i;
        i = 1;
        int lastPow;
        lastPow = TEN_POW.length - 1;
        {
            boolean var16B71EEA539968D0D6443F65DF69A37A_812352777 = (divisor.isZero());
            {
                if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("Division by zero");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var43466425044C6001C715D4744A155718_1520839695 = ((divisor.approxPrecision() + newScale > this.approxPrecision() + 1L)
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
                    boolean varB25FF58A943269DCC68D0EBDAAE99805_8840499 = (!integralValue.testBit(0));
                    {
                        quotAndRem = integralValue.divideAndRemainder(TEN_POW[i]);
                        {
                            boolean varCAFFF7801493718308EEBDB0CF811D99_685392515 = ((quotAndRem[1].signum() == 0)
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
        varB4EAC82CA7396A68D541C85D26508E83_772482199 = ((integralValue.signum() == 0)
        ? zeroScaledBy(newScale)
                : new BigDecimal(integralValue, safeLongToInt(newScale)));
        addTaint(divisor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_772482199.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_772482199;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.260 -0400", hash_original_method = "15ECC758BA9BF5EB2D64CC984DE4A4C9", hash_generated_method = "76C61AB5DB0E5548E37AC7421F872527")
    public BigDecimal divideToIntegralValue(BigDecimal divisor, MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_921782837 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_859464604 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1004196026 = null; //Variable for return #3
        int mcPrecision;
        mcPrecision = mc.getPrecision();
        int diffPrecision;
        diffPrecision = this.precision() - divisor.precision();
        int lastPow;
        lastPow = TEN_POW.length - 1;
        long diffScale;
        diffScale = (long)this.scale - divisor.scale;
        long newScale;
        newScale = diffScale;
        long quotPrecision;
        quotPrecision = diffPrecision - diffScale + 1;
        BigInteger quotAndRem[];
        quotAndRem = new BigInteger[2];
        {
            boolean var78FFC807FB0EE7608CAD1113F89EFF01_1700661784 = ((mcPrecision == 0) || (this.isZero()) || (divisor.isZero()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_921782837 = this.divideToIntegralValue(divisor);
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
            long exp;
            exp = Math.min(-diffScale, Math.max((long)mcPrecision - diffPrecision, 0));
            long compRemDiv;
            quotAndRem = this.getUnscaledValue().multiply(Multiplication.powerOf10(exp)).
                    divideAndRemainder(divisor.getUnscaledValue());
            newScale += exp;
            exp = -newScale;
            {
                boolean var69073325A671CB393E6130C2ECC3A3F2_577156144 = ((quotAndRem[1].signum() != 0) && (exp > 0));
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
            boolean varF8DE899E76CEFE3C6AC3D8F3E0A27654_97461430 = (quotAndRem[0].signum() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_859464604 = zeroScaledBy(diffScale);
            } //End block
        } //End collapsed parenthetic
        BigInteger strippedBI;
        strippedBI = quotAndRem[0];
        BigDecimal integralValue;
        integralValue = new BigDecimal(quotAndRem[0]);
        long resultPrecision;
        resultPrecision = integralValue.precision();
        int i;
        i = 1;
        {
            boolean varFEBA48CABF974070FADE4D4043F8A64F_1786081747 = (!strippedBI.testBit(0));
            {
                quotAndRem = strippedBI.divideAndRemainder(TEN_POW[i]);
                {
                    boolean varA720D7C810B13E104AD0745BE1B37072_1339173362 = ((quotAndRem[1].signum() == 0) &&
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
        varB4EAC82CA7396A68D541C85D26508E83_1004196026 = integralValue;
        addTaint(divisor.getTaint());
        addTaint(mc.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_719487395; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_719487395 = varB4EAC82CA7396A68D541C85D26508E83_921782837;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_719487395 = varB4EAC82CA7396A68D541C85D26508E83_859464604;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_719487395 = varB4EAC82CA7396A68D541C85D26508E83_1004196026;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_719487395.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_719487395;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.261 -0400", hash_original_method = "EBDBD1FB251B2EF1CF76CA97862E098F", hash_generated_method = "0D6870606CA5EDFB11D1D0725D8472D0")
    public BigDecimal remainder(BigDecimal divisor) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1796034302 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1796034302 = divideAndRemainder(divisor)[1];
        addTaint(divisor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1796034302.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1796034302;
        // ---------- Original Method ----------
        //return divideAndRemainder(divisor)[1];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.262 -0400", hash_original_method = "B5D8082AFBB8A8B7919238963079BE8E", hash_generated_method = "21BAA69E336343B5DA2EB36AB990A472")
    public BigDecimal remainder(BigDecimal divisor, MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_729115889 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_729115889 = divideAndRemainder(divisor, mc)[1];
        addTaint(divisor.getTaint());
        addTaint(mc.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_729115889.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_729115889;
        // ---------- Original Method ----------
        //return divideAndRemainder(divisor, mc)[1];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.266 -0400", hash_original_method = "078854E5024F03E2C96ABDC15A98EC28", hash_generated_method = "94AA58A8870FBF27E30E1520808111B8")
    public BigDecimal[] divideAndRemainder(BigDecimal divisor) {
        BigDecimal[] varB4EAC82CA7396A68D541C85D26508E83_2046141269 = null; //Variable for return #1
        BigDecimal quotAndRem[];
        quotAndRem = new BigDecimal[2];
        quotAndRem[0] = this.divideToIntegralValue(divisor);
        quotAndRem[1] = this.subtract( quotAndRem[0].multiply(divisor) );
        varB4EAC82CA7396A68D541C85D26508E83_2046141269 = quotAndRem;
        addTaint(divisor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2046141269.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2046141269;
        // ---------- Original Method ----------
        //BigDecimal quotAndRem[] = new BigDecimal[2];
        //quotAndRem[0] = this.divideToIntegralValue(divisor);
        //quotAndRem[1] = this.subtract( quotAndRem[0].multiply(divisor) );
        //return quotAndRem;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.280 -0400", hash_original_method = "36D2BD3305B7DD5EA1226F88EE4D6B60", hash_generated_method = "0AF321542565B39121EE835BEA23CE18")
    public BigDecimal[] divideAndRemainder(BigDecimal divisor, MathContext mc) {
        BigDecimal[] varB4EAC82CA7396A68D541C85D26508E83_1488888159 = null; //Variable for return #1
        BigDecimal quotAndRem[];
        quotAndRem = new BigDecimal[2];
        quotAndRem[0] = this.divideToIntegralValue(divisor, mc);
        quotAndRem[1] = this.subtract( quotAndRem[0].multiply(divisor) );
        varB4EAC82CA7396A68D541C85D26508E83_1488888159 = quotAndRem;
        addTaint(divisor.getTaint());
        addTaint(mc.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1488888159.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1488888159;
        // ---------- Original Method ----------
        //BigDecimal quotAndRem[] = new BigDecimal[2];
        //quotAndRem[0] = this.divideToIntegralValue(divisor, mc);
        //quotAndRem[1] = this.subtract( quotAndRem[0].multiply(divisor) );
        //return quotAndRem;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.281 -0400", hash_original_method = "0BA2A5CD46D450D69AC19365E08D7C5C", hash_generated_method = "60D2A4FCA2E253D3576F9D8D856EC2D6")
    public BigDecimal pow(int n) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1876520940 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_46786000 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1876520940 = ONE;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("Invalid operation");
        } //End block
        long newScale;
        newScale = scale * (long)n;
        varB4EAC82CA7396A68D541C85D26508E83_46786000 = isZero() ? zeroScaledBy(newScale)
                : new BigDecimal(getUnscaledValue().pow(n), safeLongToInt(newScale));
        addTaint(n);
        BigDecimal varA7E53CE21691AB073D9660D615818899_206956396; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_206956396 = varB4EAC82CA7396A68D541C85D26508E83_1876520940;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_206956396 = varB4EAC82CA7396A68D541C85D26508E83_46786000;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_206956396.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_206956396;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.286 -0400", hash_original_method = "C8938AEDE89231C5AAB8CE41C7A1DE59", hash_generated_method = "DEE80C48BC4E2E584B962B8436132B53")
    public BigDecimal pow(int n, MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_158893536 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_345959439 = null; //Variable for return #2
        int m;
        m = Math.abs(n);
        int mcPrecision;
        mcPrecision = mc.getPrecision();
        int elength;
        elength = (int)Math.log10(m) + 1;
        int oneBitMask;
        BigDecimal accum;
        MathContext newPrecision;
        newPrecision = mc;
        {
            boolean varBF14C2086BC4C6404D3417B69099E0C2_1181129332 = ((n == 0) || ((isZero()) && (n > 0)));
            {
                varB4EAC82CA7396A68D541C85D26508E83_158893536 = pow(n);
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
        varB4EAC82CA7396A68D541C85D26508E83_345959439 = accum;
        addTaint(n);
        addTaint(mc.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_342175172; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_342175172 = varB4EAC82CA7396A68D541C85D26508E83_158893536;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_342175172 = varB4EAC82CA7396A68D541C85D26508E83_345959439;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_342175172.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_342175172;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.292 -0400", hash_original_method = "DF1CB3D65F2CAE136A2978BF9C5604B4", hash_generated_method = "E77125F58265CB80941A90FDE09D23A0")
    public BigDecimal abs() {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_293308326 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_293308326 = ((signum() < 0) ? negate() : this);
        varB4EAC82CA7396A68D541C85D26508E83_293308326.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_293308326;
        // ---------- Original Method ----------
        //return ((signum() < 0) ? negate() : this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.293 -0400", hash_original_method = "BC934B9214C4819E6720F567E9C870B9", hash_generated_method = "A289300FB1A126F7A6E42D4EFDA96C72")
    public BigDecimal abs(MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1211699067 = null; //Variable for return #1
        BigDecimal result;
        result = abs();
        result.inplaceRound(mc);
        varB4EAC82CA7396A68D541C85D26508E83_1211699067 = result;
        addTaint(mc.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1211699067.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1211699067;
        // ---------- Original Method ----------
        //BigDecimal result = abs();
        //result.inplaceRound(mc);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.302 -0400", hash_original_method = "434D4E2CBF9E3CBC75126AF4586B2CF0", hash_generated_method = "F318B75389D757E60A29AF4DCCE53756")
    public BigDecimal negate() {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_796028139 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1912314218 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_796028139 = valueOf(-smallValue,scale);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1912314218 = new BigDecimal(getUnscaledValue().negate(), scale);
        BigDecimal varA7E53CE21691AB073D9660D615818899_1918260013; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1918260013 = varB4EAC82CA7396A68D541C85D26508E83_796028139;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1918260013 = varB4EAC82CA7396A68D541C85D26508E83_1912314218;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1918260013.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1918260013;
        // ---------- Original Method ----------
        //if(bitLength < 63 || (bitLength == 63 && smallValue!=Long.MIN_VALUE)) {
            //return valueOf(-smallValue,scale);
        //}
        //return new BigDecimal(getUnscaledValue().negate(), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.318 -0400", hash_original_method = "1D24791EE4ADD6E04558F8C92319E898", hash_generated_method = "4DB6947CC9203B1805DC9B8009A92120")
    public BigDecimal negate(MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_474654213 = null; //Variable for return #1
        BigDecimal result;
        result = negate();
        result.inplaceRound(mc);
        varB4EAC82CA7396A68D541C85D26508E83_474654213 = result;
        addTaint(mc.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_474654213.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_474654213;
        // ---------- Original Method ----------
        //BigDecimal result = negate();
        //result.inplaceRound(mc);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.319 -0400", hash_original_method = "E5A0BEEECFDAB0EB24F23ED92FDA1EE0", hash_generated_method = "421CC241156798FCDE065F84423D3DCC")
    public BigDecimal plus() {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1854936503 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1854936503 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1854936503.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1854936503;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.319 -0400", hash_original_method = "06DE611812CE14E42B61206CBE361795", hash_generated_method = "8EAE40A714A509248A6C3A5E742E552E")
    public BigDecimal plus(MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1383013276 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1383013276 = round(mc);
        addTaint(mc.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1383013276.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1383013276;
        // ---------- Original Method ----------
        //return round(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.320 -0400", hash_original_method = "CA4E5917AFEF32459FAB7B79AFDA8BD4", hash_generated_method = "8B7D6B6FF7A5D53A48BF9C4CAFBA582E")
    public int signum() {
        {
            int varF032537E263740DA95D3B45D7C943C95_187259458 = (Long.signum( this.smallValue ));
        } //End block
        int varF8C894AC9EB5FE4FA16D557236C882F9_138907914 = (getUnscaledValue().signum());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2122062573 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2122062573;
        // ---------- Original Method ----------
        //if( bitLength < 64) {
            //return Long.signum( this.smallValue );
        //}
        //return getUnscaledValue().signum();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.321 -0400", hash_original_method = "F3E74BAAEB162D78F28E445308393563", hash_generated_method = "F18B8C4BA8A52648BFB4B86DC36562EF")
    private boolean isZero() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_873072693 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_873072693;
        // ---------- Original Method ----------
        //return bitLength == 0 && this.smallValue != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.328 -0400", hash_original_method = "5F6F67A9AE4AEECC5BD64D7ACC145B6A", hash_generated_method = "807F383A7B5C16DCD70743F3C6231F44")
    public int scale() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_244318464 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_244318464;
        // ---------- Original Method ----------
        //return scale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.329 -0400", hash_original_method = "6DFBDD0E771CAF738A0C801E888E1E3B", hash_generated_method = "FEAB3587B26069241B4B8A97031DD873")
    public int precision() {
        int bitLength;
        bitLength = this.bitLength;
        {
            precision = 1;
        } //End block
        {
            precision = decimalDigitsInLong(smallValue);
        } //End block
        {
            int decimalDigits;
            decimalDigits = 1 + (int) ((bitLength - 1) * LOG10_2);
            {
                boolean var8743B4113D7AA0C9B3797D73894FAAF3_402928028 = (getUnscaledValue().divide(Multiplication.powerOf10(decimalDigits)).signum() != 0);
            } //End collapsed parenthetic
            precision = decimalDigits;
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1703984443 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1703984443;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.330 -0400", hash_original_method = "EAD040D94F5F819E555B537F69E87C66", hash_generated_method = "3D975642776DD6E86B70194DD231FFCC")
    private int decimalDigitsInLong(long value) {
        {
            int index;
            index = Arrays.binarySearch(MathUtils.LONG_POWERS_OF_TEN, Math.abs(value));
        } //End block
        addTaint(value);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1895989413 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1895989413;
        // ---------- Original Method ----------
        //if (value == Long.MIN_VALUE) {
            //return 19; 
        //} else {
            //int index = Arrays.binarySearch(MathUtils.LONG_POWERS_OF_TEN, Math.abs(value));
            //return (index < 0) ? (-index - 1) : (index + 1);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.334 -0400", hash_original_method = "067DA515CBCF3B72C5546CE6034B99CF", hash_generated_method = "EF5EC4021F069220CBE334CB004EF45F")
    public BigInteger unscaledValue() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_852426735 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_852426735 = getUnscaledValue();
        varB4EAC82CA7396A68D541C85D26508E83_852426735.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_852426735;
        // ---------- Original Method ----------
        //return getUnscaledValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.348 -0400", hash_original_method = "2FC46B1D06394AF066FA7CDA852A22F8", hash_generated_method = "E00D74310DB865DF309497DB3EEEDC8B")
    public BigDecimal round(MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_130700458 = null; //Variable for return #1
        BigDecimal thisBD;
        thisBD = new BigDecimal(getUnscaledValue(), scale);
        thisBD.inplaceRound(mc);
        varB4EAC82CA7396A68D541C85D26508E83_130700458 = thisBD;
        addTaint(mc.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_130700458.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_130700458;
        // ---------- Original Method ----------
        //BigDecimal thisBD = new BigDecimal(getUnscaledValue(), scale);
        //thisBD.inplaceRound(mc);
        //return thisBD;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.349 -0400", hash_original_method = "7B0F1A102C68137F597240860B4573E3", hash_generated_method = "CE20F1BDEBFB19030633300911E4A9E1")
    public BigDecimal setScale(int newScale, RoundingMode roundingMode) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1854308209 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_126775704 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1754512798 = null; //Variable for return #3
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_2111970797 = null; //Variable for return #4
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1280558843 = null; //Variable for return #5
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        long diffScale;
        diffScale = newScale - (long)scale;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1854308209 = this;
        } //End block
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_126775704 = valueOf(this.smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)diffScale],newScale);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1754512798 = new BigDecimal(Multiplication.multiplyByTenPow(getUnscaledValue(),(int)diffScale), newScale);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_2111970797 = dividePrimitiveLongs(this.smallValue, MathUtils.LONG_POWERS_OF_TEN[(int)-diffScale], newScale,roundingMode);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1280558843 = divideBigIntegers(this.getUnscaledValue(),Multiplication.powerOf10(-diffScale),newScale,roundingMode);
        addTaint(newScale);
        addTaint(roundingMode.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_2055373030; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2055373030 = varB4EAC82CA7396A68D541C85D26508E83_1854308209;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2055373030 = varB4EAC82CA7396A68D541C85D26508E83_126775704;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_2055373030 = varB4EAC82CA7396A68D541C85D26508E83_1754512798;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_2055373030 = varB4EAC82CA7396A68D541C85D26508E83_2111970797;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2055373030 = varB4EAC82CA7396A68D541C85D26508E83_1280558843;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2055373030.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2055373030;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.350 -0400", hash_original_method = "82E5CBCA5195979E97780CEADBFBD3C4", hash_generated_method = "3CAB0D326D7925ACB9E18A331EB07146")
    public BigDecimal setScale(int newScale, int roundingMode) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1056900761 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1056900761 = setScale(newScale, RoundingMode.valueOf(roundingMode));
        addTaint(newScale);
        addTaint(roundingMode);
        varB4EAC82CA7396A68D541C85D26508E83_1056900761.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1056900761;
        // ---------- Original Method ----------
        //return setScale(newScale, RoundingMode.valueOf(roundingMode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.353 -0400", hash_original_method = "ABCD452F1FC16ADBD3F58023EF098557", hash_generated_method = "EFD10EA81C71A5AF45C7E71613C9452D")
    public BigDecimal setScale(int newScale) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1842262758 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1842262758 = setScale(newScale, RoundingMode.UNNECESSARY);
        addTaint(newScale);
        varB4EAC82CA7396A68D541C85D26508E83_1842262758.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1842262758;
        // ---------- Original Method ----------
        //return setScale(newScale, RoundingMode.UNNECESSARY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.357 -0400", hash_original_method = "146C1C6822DF31E0F5C90B0C65347C9D", hash_generated_method = "F200D181348C41D98856EA95F6D06B56")
    public BigDecimal movePointLeft(int n) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1346389705 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1346389705 = movePoint(scale + (long)n);
        addTaint(n);
        varB4EAC82CA7396A68D541C85D26508E83_1346389705.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1346389705;
        // ---------- Original Method ----------
        //return movePoint(scale + (long)n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.358 -0400", hash_original_method = "EF6481821B33DB93DBF91CDB78772ACF", hash_generated_method = "491A27E0A7F96F2428A5125E8E33FD8D")
    private BigDecimal movePoint(long newScale) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1750627725 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1635378460 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1918230878 = null; //Variable for return #3
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_2065746198 = null; //Variable for return #4
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1481702614 = null; //Variable for return #5
        {
            boolean var2CC22727CE5D95FFA6F7D70A538860F0_1899496895 = (isZero());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1750627725 = zeroScaledBy(Math.max(newScale, 0));
            } //End block
        } //End collapsed parenthetic
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1635378460 = valueOf(smallValue, safeLongToInt(newScale));
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1918230878 = new BigDecimal(getUnscaledValue(), safeLongToInt(newScale));
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_2065746198 = valueOf(smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)-newScale],0);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1481702614 = new BigDecimal(Multiplication.multiplyByTenPow(
                getUnscaledValue(), safeLongToInt(-newScale)), 0);
        addTaint(newScale);
        BigDecimal varA7E53CE21691AB073D9660D615818899_2016156963; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2016156963 = varB4EAC82CA7396A68D541C85D26508E83_1750627725;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2016156963 = varB4EAC82CA7396A68D541C85D26508E83_1635378460;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_2016156963 = varB4EAC82CA7396A68D541C85D26508E83_1918230878;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_2016156963 = varB4EAC82CA7396A68D541C85D26508E83_2065746198;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2016156963 = varB4EAC82CA7396A68D541C85D26508E83_1481702614;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2016156963.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2016156963;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.366 -0400", hash_original_method = "07D5C3611C3ACCF090DC6103621F9345", hash_generated_method = "2CF3786072F6CA3F77EE6363E3996436")
    public BigDecimal movePointRight(int n) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_329515385 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_329515385 = movePoint(scale - (long)n);
        addTaint(n);
        varB4EAC82CA7396A68D541C85D26508E83_329515385.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_329515385;
        // ---------- Original Method ----------
        //return movePoint(scale - (long)n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.376 -0400", hash_original_method = "D86719E7E7F9F283B32E5780DA0BBE23", hash_generated_method = "8664B9476B5C387714B2A05BF9397097")
    public BigDecimal scaleByPowerOfTen(int n) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1757155289 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_2022749204 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_2015808480 = null; //Variable for return #3
        long newScale;
        newScale = scale - (long)n;
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1757155289 = zeroScaledBy( newScale );
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_2022749204 = valueOf(smallValue, safeLongToInt(newScale));
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2015808480 = new BigDecimal(getUnscaledValue(), safeLongToInt(newScale));
        addTaint(n);
        BigDecimal varA7E53CE21691AB073D9660D615818899_1253569820; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1253569820 = varB4EAC82CA7396A68D541C85D26508E83_1757155289;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1253569820 = varB4EAC82CA7396A68D541C85D26508E83_2022749204;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1253569820 = varB4EAC82CA7396A68D541C85D26508E83_2015808480;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1253569820.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1253569820;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.390 -0400", hash_original_method = "6A410D70691999CADF96A81B91BD2E64", hash_generated_method = "AF49339B6FAC02945D59C5CE1135C798")
    public BigDecimal stripTrailingZeros() {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1765609369 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1590406573 = null; //Variable for return #2
        int i;
        i = 1;
        int lastPow;
        lastPow = TEN_POW.length - 1;
        long newScale;
        newScale = scale;
        {
            boolean var2CC22727CE5D95FFA6F7D70A538860F0_1546891926 = (isZero());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1765609369 = this;
            } //End block
        } //End collapsed parenthetic
        BigInteger strippedBI;
        strippedBI = getUnscaledValue();
        BigInteger[] quotAndRem;
        {
            boolean varFEBA48CABF974070FADE4D4043F8A64F_1769601415 = (!strippedBI.testBit(0));
            {
                quotAndRem = strippedBI.divideAndRemainder(TEN_POW[i]);
                {
                    boolean varC86A45592F149ACDEC5EDB396276478E_1057836713 = (quotAndRem[1].signum() == 0);
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
        varB4EAC82CA7396A68D541C85D26508E83_1590406573 = new BigDecimal(strippedBI, safeLongToInt(newScale));
        BigDecimal varA7E53CE21691AB073D9660D615818899_1541989706; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1541989706 = varB4EAC82CA7396A68D541C85D26508E83_1765609369;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1541989706 = varB4EAC82CA7396A68D541C85D26508E83_1590406573;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1541989706.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1541989706;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.391 -0400", hash_original_method = "1C45ED34C4C1F5BEBD8BB8EF3CBE1A6B", hash_generated_method = "674F0DD4B39803D30E06095C5C6BEAC6")
    public int compareTo(BigDecimal val) {
        int thisSign;
        thisSign = signum();
        int valueSign;
        valueSign = val.signum();
        {
            long diffScale;
            diffScale = (long)this.scale - val.scale;
            int diffPrecision;
            diffPrecision = this.approxPrecision() - val.approxPrecision();
            {
                BigInteger thisUnscaled;
                thisUnscaled = this.getUnscaledValue();
                BigInteger valUnscaled;
                valUnscaled = val.getUnscaledValue();
                {
                    thisUnscaled = thisUnscaled.multiply(Multiplication.powerOf10(-diffScale));
                } //End block
                {
                    valUnscaled = valUnscaled.multiply(Multiplication.powerOf10(diffScale));
                } //End block
                int varCE3C94A5820498591ABCE6F39E1FAD3F_2104807048 = (thisUnscaled.compareTo(valUnscaled));
            } //End block
        } //End block
        addTaint(val.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_375078711 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_375078711;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.391 -0400", hash_original_method = "310E755E039C5525B03EE3C0A35D27A8", hash_generated_method = "6241AAB681CD3516342974FA59D31EF1")
    @Override
    public boolean equals(Object x) {
        {
            BigDecimal x1;
            x1 = (BigDecimal) x;
            boolean var001662A341C29FE1FFD924EE7151116A_1662157241 = (x1.scale == scale
                   && (bitLength < 64 ? (x1.smallValue == smallValue)
                    : intVal.equals(x1.intVal))); //DSFIXME:  CODE0008: Nested ternary operator in expression
        } //End block
        addTaint(x.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_904853981 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_904853981;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.394 -0400", hash_original_method = "F19ED99F66E082325A61ACA186AF7454", hash_generated_method = "C87D6FBACFA3B92CF00F6A9CEC361F7E")
    public BigDecimal min(BigDecimal val) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_422705379 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_422705379 = ((compareTo(val) <= 0) ? this : val);
        addTaint(val.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_422705379.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_422705379;
        // ---------- Original Method ----------
        //return ((compareTo(val) <= 0) ? this : val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.394 -0400", hash_original_method = "4EA6A2C4CEA295044D603E0ACE9B5BC6", hash_generated_method = "24C7E3C2141DFDC14B73CE785793BFB1")
    public BigDecimal max(BigDecimal val) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_2033847682 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2033847682 = ((compareTo(val) >= 0) ? this : val);
        addTaint(val.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2033847682.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2033847682;
        // ---------- Original Method ----------
        //return ((compareTo(val) >= 0) ? this : val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.395 -0400", hash_original_method = "F20F131BB03F0B25B12A1EF1F413017D", hash_generated_method = "8C725B83F19FA794BB935A82FC9FD07D")
    @Override
    public int hashCode() {
        {
            hashCode = (int)(smallValue & 0xffffffff);
            hashCode = 33 * hashCode +  (int)((smallValue >> 32) & 0xffffffff);
            hashCode = 17 * hashCode + scale;
        } //End block
        hashCode = 17 * intVal.hashCode() + scale;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1587493122 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1587493122;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.404 -0400", hash_original_method = "7C431BE8FF70735180E872A989DC1E52", hash_generated_method = "638685DEA33D00931E33F46720EEACD5")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1181185231 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_668149283 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_486347679 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1298988423 = null; //Variable for return #4
        {
            varB4EAC82CA7396A68D541C85D26508E83_1181185231 = toStringImage;
        } //End block
        {
            toStringImage = Conversion.toDecimalScaledString(smallValue,scale);
            varB4EAC82CA7396A68D541C85D26508E83_668149283 = toStringImage;
        } //End block
        String intString;
        intString = getUnscaledValue().toString();
        {
            varB4EAC82CA7396A68D541C85D26508E83_486347679 = intString;
        } //End block
        int begin;
        boolean var5FFC8DC69DEA58D4CEC873F848ECF641_650848011 = ((getUnscaledValue().signum() < 0));
        begin = 2;
        begin = 1;
        int end;
        end = intString.length();
        long exponent;
        exponent = -(long)scale + end - begin;
        StringBuilder result;
        result = new StringBuilder();
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
        varB4EAC82CA7396A68D541C85D26508E83_1298988423 = toStringImage;
        String varA7E53CE21691AB073D9660D615818899_531781725; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_531781725 = varB4EAC82CA7396A68D541C85D26508E83_1181185231;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_531781725 = varB4EAC82CA7396A68D541C85D26508E83_668149283;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_531781725 = varB4EAC82CA7396A68D541C85D26508E83_486347679;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_531781725 = varB4EAC82CA7396A68D541C85D26508E83_1298988423;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_531781725.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_531781725;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.419 -0400", hash_original_method = "37C393D601D5FE9982CCA7EB2837999F", hash_generated_method = "342B066A7D6A265192B6E24EE646BEEA")
    public String toEngineeringString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1129772096 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_882992074 = null; //Variable for return #2
        String intString;
        intString = getUnscaledValue().toString();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1129772096 = intString;
        } //End block
        int begin;
        boolean var5FFC8DC69DEA58D4CEC873F848ECF641_464752762 = ((getUnscaledValue().signum() < 0));
        begin = 2;
        begin = 1;
        int end;
        end = intString.length();
        long exponent;
        exponent = -(long)scale + end - begin;
        StringBuilder result;
        result = new StringBuilder(intString);
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
            int delta;
            delta = end - begin;
            int rem;
            rem = (int)(exponent % 3);
            {
                {
                    boolean varF1275512AD4A7A2856364C7EFBECF78A_112032590 = (getUnscaledValue().signum() == 0);
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
                        int i;
                        i = rem - delta;
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
        varB4EAC82CA7396A68D541C85D26508E83_882992074 = result.toString();
        String varA7E53CE21691AB073D9660D615818899_1522350370; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1522350370 = varB4EAC82CA7396A68D541C85D26508E83_1129772096;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1522350370 = varB4EAC82CA7396A68D541C85D26508E83_882992074;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1522350370.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1522350370;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.429 -0400", hash_original_method = "F2C3CA97C72252FC482FDCEF1D32932E", hash_generated_method = "271495A34EAF84049B4E5F6B960A8496")
    public String toPlainString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1684984532 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_529379554 = null; //Variable for return #2
        String intStr;
        intStr = getUnscaledValue().toString();
        {
            boolean var5EBF43068CE74A5170A1EF5C21021CBF_1390800742 = ((scale == 0) || ((isZero()) && (scale < 0)));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1684984532 = intStr;
            } //End block
        } //End collapsed parenthetic
        int begin;
        boolean var515FA627C40C3884068623DD22E9034F_107368613 = ((signum() < 0));
        begin = 1;
        begin = 0;
        int delta;
        delta = scale;
        StringBuilder result;
        result = new StringBuilder(intStr.length() + 1 + Math.abs(scale));
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
        varB4EAC82CA7396A68D541C85D26508E83_529379554 = result.toString();
        String varA7E53CE21691AB073D9660D615818899_1923105111; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1923105111 = varB4EAC82CA7396A68D541C85D26508E83_1684984532;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1923105111 = varB4EAC82CA7396A68D541C85D26508E83_529379554;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1923105111.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1923105111;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.443 -0400", hash_original_method = "E90ADE3EE93FD433EFA047972DEC5382", hash_generated_method = "732CDD1F6895CD4BEDB65A50B1A39CB6")
    public BigInteger toBigInteger() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1240414959 = null; //Variable for return #1
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_118221104 = null; //Variable for return #2
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_36748219 = null; //Variable for return #3
        {
            boolean var527650A3DE5B2457ABCDED439E32377E_749416428 = ((scale == 0) || (isZero()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1240414959 = getUnscaledValue();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_118221104 = getUnscaledValue().multiply(Multiplication.powerOf10(-(long)scale));
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_36748219 = getUnscaledValue().divide(Multiplication.powerOf10(scale));
            } //End block
        } //End collapsed parenthetic
        BigInteger varA7E53CE21691AB073D9660D615818899_1122671474; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1122671474 = varB4EAC82CA7396A68D541C85D26508E83_1240414959;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1122671474 = varB4EAC82CA7396A68D541C85D26508E83_118221104;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1122671474 = varB4EAC82CA7396A68D541C85D26508E83_36748219;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1122671474.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1122671474;
        // ---------- Original Method ----------
        //if ((scale == 0) || (isZero())) {
            //return getUnscaledValue();
        //} else if (scale < 0) {
            //return getUnscaledValue().multiply(Multiplication.powerOf10(-(long)scale));
        //} else {
            //return getUnscaledValue().divide(Multiplication.powerOf10(scale));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.444 -0400", hash_original_method = "0E78A189176A3E6769EBE407FB203DE6", hash_generated_method = "9243987933124E1BE6587049AEFA21B0")
    public BigInteger toBigIntegerExact() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1480599756 = null; //Variable for return #1
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_25120734 = null; //Variable for return #2
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1969259467 = null; //Variable for return #3
        {
            boolean var527650A3DE5B2457ABCDED439E32377E_913186035 = ((scale == 0) || (isZero()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1480599756 = getUnscaledValue();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_25120734 = getUnscaledValue().multiply(Multiplication.powerOf10(-(long)scale));
            } //End block
            {
                BigInteger[] integerAndFraction;
                {
                    boolean varDA526623548FC456E3243F91470F7749_733474129 = ((scale > approxPrecision()) || (scale > getUnscaledValue().getLowestSetBit()));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("Rounding necessary");
                    } //End block
                } //End collapsed parenthetic
                integerAndFraction = getUnscaledValue().divideAndRemainder(Multiplication.powerOf10(scale));
                {
                    boolean var295E569F979C75DF93112C8D385DE9FD_1823047080 = (integerAndFraction[1].signum() != 0);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("Rounding necessary");
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_1969259467 = integerAndFraction[0];
            } //End block
        } //End collapsed parenthetic
        BigInteger varA7E53CE21691AB073D9660D615818899_1711055276; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1711055276 = varB4EAC82CA7396A68D541C85D26508E83_1480599756;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1711055276 = varB4EAC82CA7396A68D541C85D26508E83_25120734;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1711055276 = varB4EAC82CA7396A68D541C85D26508E83_1969259467;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1711055276.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1711055276;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.445 -0400", hash_original_method = "A54EDCAFB9A559A1B4EB83484BB75122", hash_generated_method = "CFE39C1A73F7F8D1EA011A2BA21ADD27")
    @Override
    public long longValue() {
        long var02BCFECEB27CDDF7BA27A8716D0E8C08_219599102 = (((scale <= -64) || (scale > approxPrecision()) ? 0L
                : toBigInteger().longValue())); //DSFIXME:  CODE0008: Nested ternary operator in expression
        long var0F5264038205EDFB1AC05FBB0E8C5E94_68502282 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_68502282;
        // ---------- Original Method ----------
        //return ((scale <= -64) || (scale > approxPrecision()) ? 0L
                //: toBigInteger().longValue());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.445 -0400", hash_original_method = "FC36A176D0180DB1420333E5E0A5371B", hash_generated_method = "532479E2490429D41638ADCC30950620")
    public long longValueExact() {
        long var911FCAB8DFB4008CF2390984C1A72430_2026801952 = (valueExact(64));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_896354720 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_896354720;
        // ---------- Original Method ----------
        //return valueExact(64);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.445 -0400", hash_original_method = "C22AEC57669E1045E01A9977FB32CBED", hash_generated_method = "BA7B09631DABA6B5BFAFBDA12650D117")
    @Override
    public int intValue() {
        int var260F64E277497774BB8037E8D91956FC_1498326512 = (((scale <= -32) || (scale > approxPrecision())
        ? 0
                : toBigInteger().intValue())); //DSFIXME:  CODE0008: Nested ternary operator in expression
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1816285478 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1816285478;
        // ---------- Original Method ----------
        //return ((scale <= -32) || (scale > approxPrecision())
        //? 0
                //: toBigInteger().intValue());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.448 -0400", hash_original_method = "3865E14853C36D94FA2C26348C89A3B8", hash_generated_method = "E4F3C9A350BB31D23D3F86D6558C46BD")
    public int intValueExact() {
        int var86C4522ACDF35D342B59DBE535781A9E_1090148573 = ((int)valueExact(32));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1693539178 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1693539178;
        // ---------- Original Method ----------
        //return (int)valueExact(32);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.463 -0400", hash_original_method = "D0948D36E91C12739D01E1A7BD76887B", hash_generated_method = "130E1E7C9C0EDC0DCE52CE7631CE4FF8")
    public short shortValueExact() {
        short varA81ACCE95AC11A2580319A9BFEB7E9B2_511420374 = ((short)valueExact(16));
        short var4F09DAA9D95BCB166A302407A0E0BABE_1628536213 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1628536213;
        // ---------- Original Method ----------
        //return (short)valueExact(16);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.464 -0400", hash_original_method = "D6CE76A6DF6EC675E82ED0D5BFCEAF06", hash_generated_method = "B97878C0E7FABA60086EDDE7B0E4DA50")
    public byte byteValueExact() {
        byte varD83BA7BD5DF600388856A2C30163822F_333007978 = ((byte)valueExact(8));
        byte var40EA57D3EE3C07BF1C102B466E1C3091_2040866120 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_2040866120;
        // ---------- Original Method ----------
        //return (byte)valueExact(8);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.464 -0400", hash_original_method = "4137052570907849FFBB7EF546BA389D", hash_generated_method = "3C66E3B4D7A326E414B06CD52EE48D76")
    @Override
    public float floatValue() {
        float floatResult;
        floatResult = signum();
        long powerOfTwo;
        powerOfTwo = this.bitLength - (long)(scale / LOG10_2);
        {
            floatResult *= 0.0f;
        } //End block
        {
            floatResult *= Float.POSITIVE_INFINITY;
        } //End block
        {
            floatResult = (float)doubleValue();
        } //End block
        float var546ADE640B6EDFBC8A086EF31347E768_793744129 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_793744129;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.467 -0400", hash_original_method = "73F99D783081712086B11A0804DADCB9", hash_generated_method = "45B0F373BDEF98C7CD43025415372389")
    @Override
    public double doubleValue() {
        int sign;
        sign = signum();
        int exponent;
        exponent = 1076;
        int lowestSetBit;
        int discardedSize;
        long powerOfTwo;
        powerOfTwo = this.bitLength - (long)(scale / LOG10_2);
        long bits;
        long tempBits;
        BigInteger mantissa;
        mantissa = getUnscaledValue().abs();
        {
            mantissa = mantissa.multiply(Multiplication.powerOf10(-scale));
        } //End block
        {
            BigInteger quotAndRem[];
            BigInteger powerOfTen;
            powerOfTen = Multiplication.powerOf10(scale);
            int k;
            k = 100 - (int)powerOfTwo;
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
        double varCD654D4151F8E678076C18FA9FDC44FD_1375195103 = (Double.longBitsToDouble(bits));
        double varE8CD7DA078A86726031AD64F35F5A6C0_1310474659 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1310474659;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.468 -0400", hash_original_method = "AE130D2701C769DD6982173139D47466", hash_generated_method = "B55518B8CA2F988B6D9AC06292171106")
    public BigDecimal ulp() {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1495544212 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1495544212 = valueOf(1, scale);
        varB4EAC82CA7396A68D541C85D26508E83_1495544212.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1495544212;
        // ---------- Original Method ----------
        //return valueOf(1, scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.486 -0400", hash_original_method = "55CD7E6ED2002FE9D7C30850FBD08759", hash_generated_method = "B39A0E61AD172843EA92A582F43E5F64")
    private void inplaceRound(MathContext mc) {
        int mcPrecision;
        mcPrecision = mc.getPrecision();
        {
            boolean var6F010C2CB7AD09A8BC94F0B71513AC32_1944768787 = (approxPrecision() < mcPrecision || mcPrecision == 0);
        } //End collapsed parenthetic
        int discardedPrecision;
        discardedPrecision = precision() - mcPrecision;
        {
            smallRound(mc, discardedPrecision);
        } //End block
        BigInteger sizeOfFraction;
        sizeOfFraction = Multiplication.powerOf10(discardedPrecision);
        BigInteger[] integerAndFraction;
        integerAndFraction = getUnscaledValue().divideAndRemainder(sizeOfFraction);
        long newScale;
        newScale = (long)scale - discardedPrecision;
        int compRem;
        BigDecimal tempBD;
        {
            boolean var117BFEC09FEE1A0EBD26552B3C18D98D_173352683 = (integerAndFraction[1].signum() != 0);
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
                    boolean var10B8B9353B6BDAF0B62CA0F73EC5E632_1516022024 = (tempBD.precision() > mcPrecision);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.503 -0400", hash_original_method = "7FBE752FF3FF6B350050AE2B0F2B0308", hash_generated_method = "6C766881803B8547001933C9D6EEAB19")
    private void smallRound(MathContext mc, int discardedPrecision) {
        long sizeOfFraction;
        sizeOfFraction = MathUtils.LONG_POWERS_OF_TEN[discardedPrecision];
        long newScale;
        newScale = (long)scale - discardedPrecision;
        long unscaledVal;
        unscaledVal = smallValue;
        long integer;
        integer = unscaledVal / sizeOfFraction;
        long fraction;
        fraction = unscaledVal % sizeOfFraction;
        int compRem;
        {
            compRem = longCompareTo(Math.abs(fraction) * 2, sizeOfFraction);
            integer += roundingBehavior( ((int)integer) & 1,
                    Long.signum(fraction) * (5 + compRem),
                    mc.getRoundingMode());
            {
                boolean var23E618BB7F5984728547DADF43F7547E_722099104 = (Math.log10(Math.abs(integer)) >= mc.getPrecision());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.519 -0400", hash_original_method = "77E444DFD73510CC8BF3E35576C17A04", hash_generated_method = "DF9844B8A873CC5378233D43F1F89537")
    private long valueExact(int bitLengthOfType) {
        BigInteger bigInteger;
        bigInteger = toBigIntegerExact();
        {
            boolean var34AD3BA92A978E0890FA3B0628CDDC06_1445175331 = (bigInteger.bitLength() < bitLengthOfType);
            {
                long var9D31F6DC18FE28EB42FCCA0D0D616FEB_507551777 = (bigInteger.longValue());
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("Rounding necessary");
        addTaint(bitLengthOfType);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_371757120 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_371757120;
        // ---------- Original Method ----------
        //BigInteger bigInteger = toBigIntegerExact();
        //if (bigInteger.bitLength() < bitLengthOfType) {
            //return bigInteger.longValue();
        //}
        //throw new ArithmeticException("Rounding necessary");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.519 -0400", hash_original_method = "610DE3E95388579A8DD4E22BDEDE3C6E", hash_generated_method = "033EB335FDC340F60DBF9C2D46033BD3")
    private int approxPrecision() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_618646712 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_618646712;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.521 -0400", hash_original_method = "886E4F08C2196C85465CF795B505FE44", hash_generated_method = "BDA0F1AC8B98ACD4B899312EFE36FE5A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.521 -0400", hash_original_method = "19FA8CC309F5EC9C814FD711C697099A", hash_generated_method = "8A0F3297B8DAFE46D5786E4A20AAF3B5")
    private void writeObject(ObjectOutputStream out) throws IOException {
        getUnscaledValue();
        out.defaultWriteObject();
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //getUnscaledValue();
        //out.defaultWriteObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.533 -0400", hash_original_method = "1C1109E2DBDCFAE7331AD37D197254D0", hash_generated_method = "2D1512D7C588AAFD4EA50009A35855DB")
    private BigInteger getUnscaledValue() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_345113188 = null; //Variable for return #1
        {
            intVal = BigInteger.valueOf(smallValue);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_345113188 = intVal;
        varB4EAC82CA7396A68D541C85D26508E83_345113188.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_345113188;
        // ---------- Original Method ----------
        //if(intVal == null) {
            //intVal = BigInteger.valueOf(smallValue);
        //}
        //return intVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.534 -0400", hash_original_method = "3BE919C32007DA5FAF4FB8B842EE650C", hash_generated_method = "49E7AC88CEF6902CE7BE924ADF202E8D")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.535 -0400", hash_original_field = "877CBC7572A1F4C5C4A5EF0FCDBA91C3", hash_generated_field = "B6EECEB04C7C8E9BC518DBA316290DA7")

    public static final int ROUND_UP = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.535 -0400", hash_original_field = "D2CF03DE063925E19E13C52C8FBE1929", hash_generated_field = "454999CD924CB489896B8D343444FE92")

    public static final int ROUND_DOWN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.535 -0400", hash_original_field = "AAC8B6F1C4763B9728AB52AE15952AF6", hash_generated_field = "3C0D845F7C2F954D2ED7E86C0AE35835")

    public static final int ROUND_CEILING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.535 -0400", hash_original_field = "7503CC26EC44F42386A1D0025B5AEF97", hash_generated_field = "53D60190BBA8538A982DF868F4C6200E")

    public static final int ROUND_FLOOR = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.535 -0400", hash_original_field = "7E7DD45EF4EB3B06BFEF96EA4B0DD84D", hash_generated_field = "F10F1696D5C52C5E6B4B91643A72CEBE")

    public static final int ROUND_HALF_UP = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.535 -0400", hash_original_field = "20B7B28A1B56AD4CEA47F72CC0696346", hash_generated_field = "1619429E1C6C75DCE5756A9CF242CB9E")

    public static final int ROUND_HALF_DOWN = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.535 -0400", hash_original_field = "B3DCF23AE156DDE73D388CA751C9365F", hash_generated_field = "737A62C6AFA4A3B8167B738F856B0DEA")

    public static final int ROUND_HALF_EVEN = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.535 -0400", hash_original_field = "22697FABD637B187447A670B355A0081", hash_generated_field = "C5A01DD93D79DC15583A8D0F0236E74E")

    public static final int ROUND_UNNECESSARY = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.535 -0400", hash_original_field = "116BD32AD0E75158256F445ABDC8389D", hash_generated_field = "6A48F8D7834878E630AA100A044B06C9")

    private static long serialVersionUID = 6108874887143696463L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.547 -0400", hash_original_field = "7458DC5DA966512012D7187A9F089DAC", hash_generated_field = "C8D6435C53FE2DEAE663FE15186F09F8")

    private static double LOG10_2 = 0.3010299956639812;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.547 -0400", hash_original_field = "5515FC399FA5591FAB09427986B893AC", hash_generated_field = "BC1FA69034FA076F552F1F096B6FE848")

    private static BigInteger[] FIVE_POW;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.547 -0400", hash_original_field = "6890CCC61C514170BDE91D0B4ED71AF6", hash_generated_field = "487DAC2FC944E340E99AE2E5C8C63B33")

    private static BigInteger[] TEN_POW;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.547 -0400", hash_original_field = "B3E64594B71C88A1FCA0FDDB1DB0D932", hash_generated_field = "BC622D252D29AC82357ECA77BDEE6391")

    private static long[] LONG_FIVE_POW = new long[]
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.547 -0400", hash_original_field = "BE202B01F91923E667B3B16B069D07DC", hash_generated_field = "9B70F6A9034B314601CCA32CF3A34AF7")

    private static int[] LONG_FIVE_POW_BIT_LENGTH = new int[LONG_FIVE_POW.length];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.547 -0400", hash_original_field = "157379F1EEDF7417D34D4EA991CF2184", hash_generated_field = "6C1BEE3FF35350B086316370A7F5F258")

    private static int[] LONG_POWERS_OF_TEN_BIT_LENGTH = new int[MathUtils.LONG_POWERS_OF_TEN.length];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.547 -0400", hash_original_field = "921789C958D668713F05F9FFE836B8C7", hash_generated_field = "9D29B5A0C77695F8BC92BA2512FC0999")

    private static int BI_SCALED_BY_ZERO_LENGTH = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.547 -0400", hash_original_field = "717A7640C2D9003B18C4055EC0C50419", hash_generated_field = "1EE791938B7988205992B62BC2B7F0AC")

    private static BigDecimal[] BI_SCALED_BY_ZERO = new BigDecimal[BI_SCALED_BY_ZERO_LENGTH];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.547 -0400", hash_original_field = "39586D78C45D7A19439688292151133A", hash_generated_field = "AF28D3C06FB6631E41CACFA5D1A2AFAA")

    private static BigDecimal[] ZERO_SCALED_BY = new BigDecimal[11];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.547 -0400", hash_original_field = "94F236C8393993A7B9287704666BFBEE", hash_generated_field = "DF59AECFEA0B4D6FD254138ED59B18B0")

    private static char[] CH_ZEROS = new char[100];
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.547 -0400", hash_original_field = "B1F433B3E708BA2079293308D7CA4999", hash_generated_field = "E2BD5BBDB2DF3AE4973FDC84A00AF40A")

    public static final BigDecimal ZERO = new BigDecimal(0, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.547 -0400", hash_original_field = "3A7ACF4CD264E65305ECE3D1A439ECF7", hash_generated_field = "9F34079F2BD32FDD32B17DD6B2BC0759")

    public static final BigDecimal ONE = new BigDecimal(1, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.547 -0400", hash_original_field = "831A4D5A2871A70F006594FB3523DE19", hash_generated_field = "7D43F273171CCD7BF176CC18D6BEE813")

    public static final BigDecimal TEN = new BigDecimal(10, 0);
}

