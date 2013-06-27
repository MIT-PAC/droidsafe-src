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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.927 -0400", hash_original_field = "0A495C22CEE2486109FF49D52FAB7401", hash_generated_field = "326D03DFD6F64D4B3F1173FBD427B520")

    private transient String toStringImage = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.927 -0400", hash_original_field = "B81E47D2AA677809E4BE3C9232B2407F", hash_generated_field = "3D9A07F218385AD7A5B345B923EAF46E")

    private transient int hashCode = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.927 -0400", hash_original_field = "3A1F983ED27316FA36EAAFE36DA5649F", hash_generated_field = "E1C21CCC8969038A086EDD16030014B8")

    private BigInteger intVal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.927 -0400", hash_original_field = "B35AD5BAFCCD957A930C16D5DD131EE4", hash_generated_field = "1C841931B61AD9BC0EB5C76BA4219E64")

    private transient int bitLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.927 -0400", hash_original_field = "412477B04CAB5EE326327BE6C10454DF", hash_generated_field = "27339F171BD0CF229BCBE4E7356A5F0B")

    private transient long smallValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.927 -0400", hash_original_field = "0CB47AEB6E5F9323F0969E628C4E59F5", hash_generated_field = "F9D5D1CA2ABDD82810FF1FE80E0268E6")

    private int scale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.927 -0400", hash_original_field = "46C2159C904EABF687686166E93B72AA", hash_generated_field = "4E7D370BAE76B07332BBBB929C2DF340")

    private transient int precision = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.928 -0400", hash_original_method = "6BC27F867C09C0249873A4D338F8666D", hash_generated_method = "675ADE6C6F01FF4ED08427C7FC23A83B")
    private  BigDecimal(long smallValue, int scale) {
        this.smallValue = smallValue;
        this.scale = scale;
        this.bitLength = bitLength(smallValue);
        // ---------- Original Method ----------
        //this.smallValue = smallValue;
        //this.scale = scale;
        //this.bitLength = bitLength(smallValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.928 -0400", hash_original_method = "9F6CD654516DCD03F33530EDCF81D84D", hash_generated_method = "3DC98F1132A232115D5983B57B665BF0")
    private  BigDecimal(int smallValue, int scale) {
        this.smallValue = smallValue;
        this.scale = scale;
        this.bitLength = bitLength(smallValue);
        // ---------- Original Method ----------
        //this.smallValue = smallValue;
        //this.scale = scale;
        //this.bitLength = bitLength(smallValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.932 -0400", hash_original_method = "374C425CF4086C798A21EEA670343536", hash_generated_method = "3F223E4C8A9BC7FA6E6265B71415B924")
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
            boolean var61B48B5FEE897AE42C98AFC63C6454F8_1100853438 = (unscaledBuffer.charAt(0) == '-');
        } //End collapsed parenthetic
        addTaint(in[0]);
        addTaint(len);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.932 -0400", hash_original_method = "021DB19003FFCB38960FC53E0DB20D11", hash_generated_method = "275FB9D57B18A3B85184CAF9CE70BF00")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.933 -0400", hash_original_method = "2CA49E7A005F756FE298C75D3E276FBD", hash_generated_method = "B4FD1176C71EA8991071A29C074F944A")
    public  BigDecimal(char[] in) {
        this(in, 0, in.length);
        addTaint(in[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.933 -0400", hash_original_method = "24A3A809E90D8D728111B1E9DFB6AE2B", hash_generated_method = "09C060845E8F5FF4F77D83B14AFC3E66")
    public  BigDecimal(char[] in, MathContext mc) {
        this(in, 0, in.length);
        inplaceRound(mc);
        addTaint(in[0]);
        addTaint(mc.getTaint());
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.933 -0400", hash_original_method = "97883F5F25D8C2D5B9EC2501AC7ECDA2", hash_generated_method = "F8C02FFBA49B73A7A22E83CA112803F6")
    public  BigDecimal(String val) {
        this(val.toCharArray(), 0, val.length());
        addTaint(val.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.934 -0400", hash_original_method = "65FA78E7CB5F82CDA77BAA4B434CD165", hash_generated_method = "76DAE502211644C5F6D20BA849076BCF")
    public  BigDecimal(String val, MathContext mc) {
        this(val.toCharArray(), 0, val.length());
        inplaceRound(mc);
        addTaint(val.getTaint());
        addTaint(mc.getTaint());
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.949 -0400", hash_original_method = "A550123107439183BDAF78BFBC33380D", hash_generated_method = "BB33B4EB7942AD5FE516BB87E0582E07")
    public  BigDecimal(double val) {
        {
            boolean var07ED44AABC248720567522E1772FEBCB_275957595 = (Double.isInfinite(val) || Double.isNaN(val));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.955 -0400", hash_original_method = "A301A521891A68A20E545213C1CF7F7F", hash_generated_method = "61E4530A94C3F954071D1E31BF762714")
    public  BigDecimal(double val, MathContext mc) {
        this(val);
        inplaceRound(mc);
        addTaint(val);
        addTaint(mc.getTaint());
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.956 -0400", hash_original_method = "35103202AC4D8227390F065BF679C471", hash_generated_method = "D504D0B814354DD64C3D66DE08011646")
    public  BigDecimal(BigInteger val) {
        this(val, 0);
        addTaint(val.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.956 -0400", hash_original_method = "4DD15F45D533F2889A2A72BE2BF675A6", hash_generated_method = "D67E2735ED92664B1FB6B7B749D87D08")
    public  BigDecimal(BigInteger val, MathContext mc) {
        this(val);
        inplaceRound(mc);
        addTaint(val.getTaint());
        addTaint(mc.getTaint());
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.957 -0400", hash_original_method = "E5BF86952E31D522F2FAABCF30464562", hash_generated_method = "72E89060793A1AA3A659E8DA2DA29B04")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.957 -0400", hash_original_method = "59F34EC0A04F061EC6FA9A9EFC322A4C", hash_generated_method = "32E65AEFC7C0BD2C974B7F3E9297CD5F")
    public  BigDecimal(BigInteger unscaledVal, int scale, MathContext mc) {
        this(unscaledVal, scale);
        inplaceRound(mc);
        addTaint(unscaledVal.getTaint());
        addTaint(scale);
        addTaint(mc.getTaint());
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.957 -0400", hash_original_method = "5359C9BE484C4A97ECD231D115B1BCDB", hash_generated_method = "D648D7F23799D878CE7DE9DEA41AED6E")
    public  BigDecimal(int val) {
        this(val,0);
        addTaint(val);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.957 -0400", hash_original_method = "919820155B3DF9AD0A8E776AC27BF824", hash_generated_method = "1FFD2ADDE931D52B57DBB399AEFC9F40")
    public  BigDecimal(int val, MathContext mc) {
        this(val,0);
        inplaceRound(mc);
        addTaint(val);
        addTaint(mc.getTaint());
        // ---------- Original Method ----------
        //inplaceRound(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.958 -0400", hash_original_method = "3B8082CDF108D6321820C9FA6A6A1D42", hash_generated_method = "5CD5A0914C8C99DBF87C1115B74C5DD3")
    public  BigDecimal(long val) {
        this(val,0);
        addTaint(val);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.965 -0400", hash_original_method = "E0851629E0BD0FDB6233816479A7E4A8", hash_generated_method = "4C9B12BD7553D77E861C40B68F1A9173")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.968 -0400", hash_original_method = "1DCD141A7D54B6C70CB155CC6BA0AB13", hash_generated_method = "C1DA588E64E7390EEA94C49C7840BDFD")
    public BigDecimal add(BigDecimal augend) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_768684907 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1853098928 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1446797958 = null; //Variable for return #3
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1895158411 = null; //Variable for return #4
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_666230969 = null; //Variable for return #5
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_917992987 = null; //Variable for return #6
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_771900688 = null; //Variable for return #7
        int diffScale;
        diffScale = this.scale - augend.scale;
        {
            boolean var3ACAB80A5F99B906541DA9D0E446A470_865126883 = (this.isZero());
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_768684907 = augend;
                } //End block
                {
                    boolean varB1908C261B547BD48CB51E1D5EF611A0_1986695001 = (augend.isZero());
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1853098928 = this;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean var133F1DCA67F284EB5AB919CE41BBA5B6_1772044271 = (augend.isZero());
                {
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1446797958 = this;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            {
                boolean varD111D3273CD5455867ABFC03E36CFA28_565373412 = (Math.max(this.bitLength, augend.bitLength) + 1 < 64);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1895158411 = valueOf(this.smallValue + augend.smallValue, this.scale);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_666230969 = new BigDecimal(this.getUnscaledValue().add(augend.getUnscaledValue()), this.scale);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_917992987 = addAndMult10(this, augend, diffScale);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_771900688 = addAndMult10(augend, this, -diffScale);
        } //End block
        addTaint(augend.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_1048798160; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1048798160 = varB4EAC82CA7396A68D541C85D26508E83_768684907;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1048798160 = varB4EAC82CA7396A68D541C85D26508E83_1853098928;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1048798160 = varB4EAC82CA7396A68D541C85D26508E83_1446797958;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1048798160 = varB4EAC82CA7396A68D541C85D26508E83_1895158411;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1048798160 = varB4EAC82CA7396A68D541C85D26508E83_666230969;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1048798160 = varB4EAC82CA7396A68D541C85D26508E83_917992987;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1048798160 = varB4EAC82CA7396A68D541C85D26508E83_771900688;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1048798160.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1048798160;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.994 -0400", hash_original_method = "37BDD6EE07613654EB8729406017A0AF", hash_generated_method = "25AB64A5B6C2241EA58EECF81A556260")
    public BigDecimal add(BigDecimal augend, MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1284883867 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1921368278 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1525519357 = null; //Variable for return #3
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1571561988 = null; //Variable for return #4
        BigDecimal larger;
        BigDecimal smaller;
        BigInteger tempBI;
        long diffScale;
        diffScale = (long)this.scale - augend.scale;
        int largerSignum;
        {
            boolean varF966BD50F4EF9C0D05117401635B161E_1956185129 = ((augend.isZero()) || (this.isZero())
                || (mc.getPrecision() == 0));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1284883867 = add(augend).round(mc);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var9070081FF1C89B57CAC464C53A5B31A2_386009803 = (this.approxPrecision() < diffScale - 1);
            {
                larger = augend;
                smaller = this;
            } //End block
            {
                boolean varA5DA4849944CED3DDED10285985020BE_1482235769 = (augend.approxPrecision() < -diffScale - 1);
                {
                    larger = this;
                    smaller = augend;
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1921368278 = add(augend).round(mc);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean var8AFB7E1F21C67DCCAA005AEF04A9DB11_2076874842 = (mc.getPrecision() >= larger.approxPrecision());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1525519357 = add(augend).round(mc);
            } //End block
        } //End collapsed parenthetic
        largerSignum = larger.signum();
        {
            boolean varFDAEFA28D5E9E9B77BEF39981CC0842F_1274209961 = (largerSignum == smaller.signum());
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
        varB4EAC82CA7396A68D541C85D26508E83_1571561988 = larger.round(mc);
        addTaint(augend.getTaint());
        addTaint(mc.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_772938671; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_772938671 = varB4EAC82CA7396A68D541C85D26508E83_1284883867;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_772938671 = varB4EAC82CA7396A68D541C85D26508E83_1921368278;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_772938671 = varB4EAC82CA7396A68D541C85D26508E83_1525519357;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_772938671 = varB4EAC82CA7396A68D541C85D26508E83_1571561988;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_772938671.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_772938671;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.996 -0400", hash_original_method = "463B27AE9A4331C20782D4CCC2226F12", hash_generated_method = "6CF96154A878FA2A2FF17FAE74FFAA28")
    public BigDecimal subtract(BigDecimal subtrahend) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_631095921 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_290938895 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_958138945 = null; //Variable for return #3
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_6890600 = null; //Variable for return #4
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1411229222 = null; //Variable for return #5
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1195806990 = null; //Variable for return #6
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1157855264 = null; //Variable for return #7
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_2083936061 = null; //Variable for return #8
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1433164613 = null; //Variable for return #9
        int diffScale;
        diffScale = this.scale - subtrahend.scale;
        {
            boolean var3ACAB80A5F99B906541DA9D0E446A470_1988440284 = (this.isZero());
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_631095921 = subtrahend.negate();
                } //End block
                {
                    boolean varD03C6CECC51E3DE3442E3774C1567DCF_1441934361 = (subtrahend.isZero());
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_290938895 = this;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean var9EB1DAC8BC084CCA52BBCF84A22F0C39_1576953377 = (subtrahend.isZero());
                {
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_958138945 = this;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            {
                boolean var716C9DB8DD66F0858D9B5D3E8474C979_85923976 = (Math.max(this.bitLength, subtrahend.bitLength) + 1 < 64);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_6890600 = valueOf(this.smallValue - subtrahend.smallValue,this.scale);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1411229222 = new BigDecimal(this.getUnscaledValue().subtract(subtrahend.getUnscaledValue()), this.scale);
        } //End block
        {
            {
                boolean var920C6D472A61AE7DE113537D4CAEABA3_1559401022 = (diffScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                    Math.max(this.bitLength,subtrahend.bitLength+LONG_POWERS_OF_TEN_BIT_LENGTH[diffScale])+1<64);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1195806990 = valueOf(this.smallValue-subtrahend.smallValue*MathUtils.LONG_POWERS_OF_TEN[diffScale],this.scale);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1157855264 = new BigDecimal(this.getUnscaledValue().subtract(
                    Multiplication.multiplyByTenPow(subtrahend.getUnscaledValue(),diffScale)), this.scale);
        } //End block
        {
            diffScale = -diffScale;
            {
                boolean var71AEEAE804686FEE863217A58EF3D39E_196574262 = (diffScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                    Math.max(this.bitLength+LONG_POWERS_OF_TEN_BIT_LENGTH[diffScale],subtrahend.bitLength)+1<64);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_2083936061 = valueOf(this.smallValue*MathUtils.LONG_POWERS_OF_TEN[diffScale]-subtrahend.smallValue,subtrahend.scale);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1433164613 = new BigDecimal(Multiplication.multiplyByTenPow(this.getUnscaledValue(),diffScale)
            .subtract(subtrahend.getUnscaledValue()), subtrahend.scale);
        } //End block
        addTaint(subtrahend.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_1988951352; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1988951352 = varB4EAC82CA7396A68D541C85D26508E83_631095921;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1988951352 = varB4EAC82CA7396A68D541C85D26508E83_290938895;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1988951352 = varB4EAC82CA7396A68D541C85D26508E83_958138945;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1988951352 = varB4EAC82CA7396A68D541C85D26508E83_6890600;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1988951352 = varB4EAC82CA7396A68D541C85D26508E83_1411229222;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1988951352 = varB4EAC82CA7396A68D541C85D26508E83_1195806990;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_1988951352 = varB4EAC82CA7396A68D541C85D26508E83_1157855264;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_1988951352 = varB4EAC82CA7396A68D541C85D26508E83_2083936061;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1988951352 = varB4EAC82CA7396A68D541C85D26508E83_1433164613;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1988951352.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1988951352;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.016 -0400", hash_original_method = "427D658D2E18BC359A41906DA92107B2", hash_generated_method = "E084724F2E1938B94D8B6B9553C77E78")
    public BigDecimal subtract(BigDecimal subtrahend, MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1673979491 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1901867998 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_609977307 = null; //Variable for return #3
        long diffScale;
        diffScale = subtrahend.scale - (long)this.scale;
        int thisSignum;
        BigDecimal leftOperand;
        BigInteger tempBI;
        {
            boolean varFD92EBCDA78B63D052A84F60541F229A_88843322 = ((subtrahend.isZero()) || (this.isZero())
                || (mc.getPrecision() == 0));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1673979491 = subtract(subtrahend).round(mc);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var89DC8760BF7238399EC83E1D522E73AD_1888309047 = (subtrahend.approxPrecision() < diffScale - 1);
            {
                {
                    boolean varD9AB7589FCBDAD8F096FC84E02A2A50D_2128843898 = (mc.getPrecision() < this.approxPrecision());
                    {
                        thisSignum = this.signum();
                        {
                            boolean var62FB1B54913969022251702D5200468F_33039206 = (thisSignum != subtrahend.signum());
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
                        varB4EAC82CA7396A68D541C85D26508E83_1901867998 = leftOperand.round(mc);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_609977307 = subtract(subtrahend).round(mc);
        addTaint(subtrahend.getTaint());
        addTaint(mc.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_1781264040; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1781264040 = varB4EAC82CA7396A68D541C85D26508E83_1673979491;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1781264040 = varB4EAC82CA7396A68D541C85D26508E83_1901867998;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1781264040 = varB4EAC82CA7396A68D541C85D26508E83_609977307;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1781264040.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1781264040;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.017 -0400", hash_original_method = "0CD1948BD2366020AE6A84C7902D73D6", hash_generated_method = "C4F01A3CEEA8A0B3E2DA29096F190E75")
    public BigDecimal multiply(BigDecimal multiplicand) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1496263936 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1367166290 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_366810575 = null; //Variable for return #3
        long newScale;
        newScale = (long)this.scale + multiplicand.scale;
        {
            boolean var94085E900CFE8C8A5270601770788621_551200969 = ((this.isZero()) || (multiplicand.isZero()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1496263936 = zeroScaledBy(newScale);
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_1367166290 = valueOf(this.smallValue*multiplicand.smallValue, safeLongToInt(newScale));
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_366810575 = new BigDecimal(this.getUnscaledValue().multiply(
                multiplicand.getUnscaledValue()), safeLongToInt(newScale));
        addTaint(multiplicand.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_1973702279; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1973702279 = varB4EAC82CA7396A68D541C85D26508E83_1496263936;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1973702279 = varB4EAC82CA7396A68D541C85D26508E83_1367166290;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1973702279 = varB4EAC82CA7396A68D541C85D26508E83_366810575;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1973702279.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1973702279;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.018 -0400", hash_original_method = "C6525DC236CD6C9B7DA82BBF840C4183", hash_generated_method = "D6E87B62936ECCA2808AD4B273F90324")
    public BigDecimal multiply(BigDecimal multiplicand, MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_6576043 = null; //Variable for return #1
        BigDecimal result;
        result = multiply(multiplicand);
        result.inplaceRound(mc);
        varB4EAC82CA7396A68D541C85D26508E83_6576043 = result;
        addTaint(multiplicand.getTaint());
        addTaint(mc.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_6576043.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_6576043;
        // ---------- Original Method ----------
        //BigDecimal result = multiply(multiplicand);
        //result.inplaceRound(mc);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.034 -0400", hash_original_method = "462A8C7DE00EC7C78FAA3F28B925453C", hash_generated_method = "2541DE17BF04E6953F832C9E59F21286")
    public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_2052537962 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2052537962 = divide(divisor, scale, RoundingMode.valueOf(roundingMode));
        addTaint(divisor.getTaint());
        addTaint(scale);
        addTaint(roundingMode);
        varB4EAC82CA7396A68D541C85D26508E83_2052537962.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2052537962;
        // ---------- Original Method ----------
        //return divide(divisor, scale, RoundingMode.valueOf(roundingMode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.035 -0400", hash_original_method = "CAF40474AE4670E1A6482892323F28CB", hash_generated_method = "3F46539230E5F2550E2377A2C22A7EFA")
    public BigDecimal divide(BigDecimal divisor, int scale, RoundingMode roundingMode) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1302485807 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_95046033 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_654256434 = null; //Variable for return #3
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1105800036 = null; //Variable for return #4
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean var16B71EEA539968D0D6443F65DF69A37A_277207550 = (divisor.isZero());
            {
                if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("Division by zero");
            } //End block
        } //End collapsed parenthetic
        long diffScale;
        diffScale = ((long)this.scale - divisor.scale) - scale;
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1302485807 = dividePrimitiveLongs(this.smallValue,
                        divisor.smallValue,
                        scale,
                        roundingMode );
            } //End block
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_95046033 = dividePrimitiveLongs(this.smallValue,
                            divisor.smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)diffScale],
                            scale,
                            roundingMode);
                } //End block
            } //End block
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_654256434 = dividePrimitiveLongs(this.smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)-diffScale],
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
        varB4EAC82CA7396A68D541C85D26508E83_1105800036 = divideBigIntegers(scaledDividend, scaledDivisor, scale, roundingMode);
        addTaint(divisor.getTaint());
        addTaint(scale);
        addTaint(roundingMode.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_1116738158; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1116738158 = varB4EAC82CA7396A68D541C85D26508E83_1302485807;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1116738158 = varB4EAC82CA7396A68D541C85D26508E83_95046033;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1116738158 = varB4EAC82CA7396A68D541C85D26508E83_654256434;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1116738158 = varB4EAC82CA7396A68D541C85D26508E83_1105800036;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1116738158.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1116738158;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.050 -0400", hash_original_method = "2C6660A6ECCA62927D6A6B71E8D4804F", hash_generated_method = "1E7F96A2E371D42E3DA17D665669A4BB")
    public BigDecimal divide(BigDecimal divisor, int roundingMode) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1566626216 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1566626216 = divide(divisor, scale, RoundingMode.valueOf(roundingMode));
        addTaint(divisor.getTaint());
        addTaint(roundingMode);
        varB4EAC82CA7396A68D541C85D26508E83_1566626216.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1566626216;
        // ---------- Original Method ----------
        //return divide(divisor, scale, RoundingMode.valueOf(roundingMode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.050 -0400", hash_original_method = "5F1D784ACEFAF8C3A3D46632D71C7A92", hash_generated_method = "E407EB2463E505CFCC60B4ECAC573797")
    public BigDecimal divide(BigDecimal divisor, RoundingMode roundingMode) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1397728148 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1397728148 = divide(divisor, scale, roundingMode);
        addTaint(divisor.getTaint());
        addTaint(roundingMode.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1397728148.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1397728148;
        // ---------- Original Method ----------
        //return divide(divisor, scale, roundingMode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.067 -0400", hash_original_method = "A7E2E0DD5FAFAFB93C0707787850F19F", hash_generated_method = "24808CD64F1A64247410664EFD753E8C")
    public BigDecimal divide(BigDecimal divisor) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1297374143 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_970027602 = null; //Variable for return #2
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
            boolean var16B71EEA539968D0D6443F65DF69A37A_17246947 = (divisor.isZero());
            {
                if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("Division by zero");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB2E2B4410DE8AB2A2A71DAF68472D9F8_565032402 = (p.signum() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1297374143 = zeroScaledBy(diffScale);
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
                boolean var56D8F8621CBF2F8B7CF2D0AA5E63D82E_1076038129 = (quotAndRem[1].signum() == 0);
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
            boolean var1CE2A649CF548A0B382B8CA8D0531C0B_253788548 = (!q.abs().equals(BigInteger.ONE));
            {
                if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("Non-terminating decimal expansion; no exact representable decimal result");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var1BE70AB41E4F878C9E96CBD045BE82F6_313786893 = (q.signum() < 0);
            {
                p = p.negate();
            } //End block
        } //End collapsed parenthetic
        newScale = safeLongToInt(diffScale + Math.max(k, l));
        i = k - l;
        p = (i > 0) ? Multiplication.multiplyByFivePow(p, i)
        : p.shiftLeft(-i);
        varB4EAC82CA7396A68D541C85D26508E83_970027602 = new BigDecimal(p, newScale);
        addTaint(divisor.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_714309578; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_714309578 = varB4EAC82CA7396A68D541C85D26508E83_1297374143;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_714309578 = varB4EAC82CA7396A68D541C85D26508E83_970027602;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_714309578.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_714309578;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.070 -0400", hash_original_method = "E69AD17C16131904FF2F859BB6B8C3E0", hash_generated_method = "75940E5A05D08BB91A3F406BBA5BB915")
    public BigDecimal divide(BigDecimal divisor, MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_718332133 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1839414671 = null; //Variable for return #2
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
            boolean var1683CA06D9CD829DE790F5F76B24F12F_2063786300 = ((mc.getPrecision() == 0) || (this.isZero())
        || (divisor.isZero()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_718332133 = this.divide(divisor);
            } //End block
        } //End collapsed parenthetic
        {
            quotAndRem[0] = getUnscaledValue().multiply( Multiplication.powerOf10(trailingZeros) );
            newScale += trailingZeros;
        } //End block
        quotAndRem = quotAndRem[0].divideAndRemainder( divisor.getUnscaledValue() );
        integerQuot = quotAndRem[0];
        {
            boolean var519F85BAAFA83462D286D0E95FC021F7_1975874215 = (quotAndRem[1].signum() != 0);
            {
                compRem = quotAndRem[1].shiftLeftOneBit().compareTo( divisor.getUnscaledValue() );
                integerQuot = integerQuot.multiply(BigInteger.TEN)
            .add(BigInteger.valueOf(quotAndRem[0].signum() * (5 + compRem)));
            } //End block
            {
                {
                    boolean varD5D87A190E12C2B6C000E3A9EE8BEC7C_39127955 = (!integerQuot.testBit(0));
                    {
                        quotAndRem = integerQuot.divideAndRemainder(TEN_POW[i]);
                        {
                            boolean var3E10FD41A4FC7BC4D742233E45936456_92000521 = ((quotAndRem[1].signum() == 0)
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
        varB4EAC82CA7396A68D541C85D26508E83_1839414671 = new BigDecimal(integerQuot, safeLongToInt(newScale), mc);
        addTaint(divisor.getTaint());
        addTaint(mc.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_654740837; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_654740837 = varB4EAC82CA7396A68D541C85D26508E83_718332133;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_654740837 = varB4EAC82CA7396A68D541C85D26508E83_1839414671;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_654740837.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_654740837;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.084 -0400", hash_original_method = "370FC7E5A1C86319865302EB832BE460", hash_generated_method = "F054F9CED1BB7B277DB0773C55927FAF")
    public BigDecimal divideToIntegralValue(BigDecimal divisor) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1312715510 = null; //Variable for return #1
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
            boolean var16B71EEA539968D0D6443F65DF69A37A_1793292689 = (divisor.isZero());
            {
                if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("Division by zero");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var43466425044C6001C715D4744A155718_819940489 = ((divisor.approxPrecision() + newScale > this.approxPrecision() + 1L)
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
                    boolean varB25FF58A943269DCC68D0EBDAAE99805_1635438373 = (!integralValue.testBit(0));
                    {
                        quotAndRem = integralValue.divideAndRemainder(TEN_POW[i]);
                        {
                            boolean varCAFFF7801493718308EEBDB0CF811D99_1591153979 = ((quotAndRem[1].signum() == 0)
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
        varB4EAC82CA7396A68D541C85D26508E83_1312715510 = ((integralValue.signum() == 0)
        ? zeroScaledBy(newScale)
                : new BigDecimal(integralValue, safeLongToInt(newScale)));
        addTaint(divisor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1312715510.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1312715510;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.148 -0400", hash_original_method = "15ECC758BA9BF5EB2D64CC984DE4A4C9", hash_generated_method = "C22720219563C06A1251E5904CF25701")
    public BigDecimal divideToIntegralValue(BigDecimal divisor, MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_133197262 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1066186763 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1617140949 = null; //Variable for return #3
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
            boolean var78FFC807FB0EE7608CAD1113F89EFF01_1171899098 = ((mcPrecision == 0) || (this.isZero()) || (divisor.isZero()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_133197262 = this.divideToIntegralValue(divisor);
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
                boolean var69073325A671CB393E6130C2ECC3A3F2_784856145 = ((quotAndRem[1].signum() != 0) && (exp > 0));
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
            boolean varF8DE899E76CEFE3C6AC3D8F3E0A27654_1379460179 = (quotAndRem[0].signum() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1066186763 = zeroScaledBy(diffScale);
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
            boolean varFEBA48CABF974070FADE4D4043F8A64F_1981932804 = (!strippedBI.testBit(0));
            {
                quotAndRem = strippedBI.divideAndRemainder(TEN_POW[i]);
                {
                    boolean varA720D7C810B13E104AD0745BE1B37072_1507960654 = ((quotAndRem[1].signum() == 0) &&
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
        varB4EAC82CA7396A68D541C85D26508E83_1617140949 = integralValue;
        addTaint(divisor.getTaint());
        addTaint(mc.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_1260184972; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1260184972 = varB4EAC82CA7396A68D541C85D26508E83_133197262;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1260184972 = varB4EAC82CA7396A68D541C85D26508E83_1066186763;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1260184972 = varB4EAC82CA7396A68D541C85D26508E83_1617140949;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1260184972.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1260184972;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.150 -0400", hash_original_method = "EBDBD1FB251B2EF1CF76CA97862E098F", hash_generated_method = "D030FA7DC321F5C18461581A82245F7B")
    public BigDecimal remainder(BigDecimal divisor) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1858270694 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1858270694 = divideAndRemainder(divisor)[1];
        addTaint(divisor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1858270694.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1858270694;
        // ---------- Original Method ----------
        //return divideAndRemainder(divisor)[1];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.150 -0400", hash_original_method = "B5D8082AFBB8A8B7919238963079BE8E", hash_generated_method = "DAAF324F9995E1548AB18B19A395AB73")
    public BigDecimal remainder(BigDecimal divisor, MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_46919617 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_46919617 = divideAndRemainder(divisor, mc)[1];
        addTaint(divisor.getTaint());
        addTaint(mc.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_46919617.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_46919617;
        // ---------- Original Method ----------
        //return divideAndRemainder(divisor, mc)[1];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.156 -0400", hash_original_method = "078854E5024F03E2C96ABDC15A98EC28", hash_generated_method = "4F78FBC65E738447F4F5733BF9025576")
    public BigDecimal[] divideAndRemainder(BigDecimal divisor) {
        BigDecimal[] varB4EAC82CA7396A68D541C85D26508E83_644264099 = null; //Variable for return #1
        BigDecimal quotAndRem[];
        quotAndRem = new BigDecimal[2];
        quotAndRem[0] = this.divideToIntegralValue(divisor);
        quotAndRem[1] = this.subtract( quotAndRem[0].multiply(divisor) );
        varB4EAC82CA7396A68D541C85D26508E83_644264099 = quotAndRem;
        addTaint(divisor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_644264099.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_644264099;
        // ---------- Original Method ----------
        //BigDecimal quotAndRem[] = new BigDecimal[2];
        //quotAndRem[0] = this.divideToIntegralValue(divisor);
        //quotAndRem[1] = this.subtract( quotAndRem[0].multiply(divisor) );
        //return quotAndRem;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.157 -0400", hash_original_method = "36D2BD3305B7DD5EA1226F88EE4D6B60", hash_generated_method = "DC64AD3CD0F7C9179F743099A8686A97")
    public BigDecimal[] divideAndRemainder(BigDecimal divisor, MathContext mc) {
        BigDecimal[] varB4EAC82CA7396A68D541C85D26508E83_609283267 = null; //Variable for return #1
        BigDecimal quotAndRem[];
        quotAndRem = new BigDecimal[2];
        quotAndRem[0] = this.divideToIntegralValue(divisor, mc);
        quotAndRem[1] = this.subtract( quotAndRem[0].multiply(divisor) );
        varB4EAC82CA7396A68D541C85D26508E83_609283267 = quotAndRem;
        addTaint(divisor.getTaint());
        addTaint(mc.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_609283267.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_609283267;
        // ---------- Original Method ----------
        //BigDecimal quotAndRem[] = new BigDecimal[2];
        //quotAndRem[0] = this.divideToIntegralValue(divisor, mc);
        //quotAndRem[1] = this.subtract( quotAndRem[0].multiply(divisor) );
        //return quotAndRem;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.166 -0400", hash_original_method = "0BA2A5CD46D450D69AC19365E08D7C5C", hash_generated_method = "5AC407D7D0A5B70FEBC3C9E2209F4314")
    public BigDecimal pow(int n) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1990400657 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1554128275 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1990400657 = ONE;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("Invalid operation");
        } //End block
        long newScale;
        newScale = scale * (long)n;
        varB4EAC82CA7396A68D541C85D26508E83_1554128275 = isZero() ? zeroScaledBy(newScale)
                : new BigDecimal(getUnscaledValue().pow(n), safeLongToInt(newScale));
        addTaint(n);
        BigDecimal varA7E53CE21691AB073D9660D615818899_441783808; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_441783808 = varB4EAC82CA7396A68D541C85D26508E83_1990400657;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_441783808 = varB4EAC82CA7396A68D541C85D26508E83_1554128275;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_441783808.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_441783808;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.175 -0400", hash_original_method = "C8938AEDE89231C5AAB8CE41C7A1DE59", hash_generated_method = "3F4724D3D3B09DE3CF8E36CB88307AF0")
    public BigDecimal pow(int n, MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_527817250 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1377469765 = null; //Variable for return #2
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
            boolean varBF14C2086BC4C6404D3417B69099E0C2_1182485078 = ((n == 0) || ((isZero()) && (n > 0)));
            {
                varB4EAC82CA7396A68D541C85D26508E83_527817250 = pow(n);
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
        varB4EAC82CA7396A68D541C85D26508E83_1377469765 = accum;
        addTaint(n);
        addTaint(mc.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_478833492; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_478833492 = varB4EAC82CA7396A68D541C85D26508E83_527817250;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_478833492 = varB4EAC82CA7396A68D541C85D26508E83_1377469765;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_478833492.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_478833492;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.182 -0400", hash_original_method = "DF1CB3D65F2CAE136A2978BF9C5604B4", hash_generated_method = "E95B6CBF7C172447C94DEE46B7569087")
    public BigDecimal abs() {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_2070313005 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2070313005 = ((signum() < 0) ? negate() : this);
        varB4EAC82CA7396A68D541C85D26508E83_2070313005.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2070313005;
        // ---------- Original Method ----------
        //return ((signum() < 0) ? negate() : this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.182 -0400", hash_original_method = "BC934B9214C4819E6720F567E9C870B9", hash_generated_method = "16A537F332CABD3049BFFF44F8112440")
    public BigDecimal abs(MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_2092758616 = null; //Variable for return #1
        BigDecimal result;
        result = abs();
        result.inplaceRound(mc);
        varB4EAC82CA7396A68D541C85D26508E83_2092758616 = result;
        addTaint(mc.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2092758616.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2092758616;
        // ---------- Original Method ----------
        //BigDecimal result = abs();
        //result.inplaceRound(mc);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.183 -0400", hash_original_method = "434D4E2CBF9E3CBC75126AF4586B2CF0", hash_generated_method = "D9115F7CF979BF6F2D9E60D896B7E59F")
    public BigDecimal negate() {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1315654721 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1599316483 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1315654721 = valueOf(-smallValue,scale);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1599316483 = new BigDecimal(getUnscaledValue().negate(), scale);
        BigDecimal varA7E53CE21691AB073D9660D615818899_2096555631; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2096555631 = varB4EAC82CA7396A68D541C85D26508E83_1315654721;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2096555631 = varB4EAC82CA7396A68D541C85D26508E83_1599316483;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2096555631.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2096555631;
        // ---------- Original Method ----------
        //if(bitLength < 63 || (bitLength == 63 && smallValue!=Long.MIN_VALUE)) {
            //return valueOf(-smallValue,scale);
        //}
        //return new BigDecimal(getUnscaledValue().negate(), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.184 -0400", hash_original_method = "1D24791EE4ADD6E04558F8C92319E898", hash_generated_method = "277207D6489469246F07A507EBE8D6A3")
    public BigDecimal negate(MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_299214819 = null; //Variable for return #1
        BigDecimal result;
        result = negate();
        result.inplaceRound(mc);
        varB4EAC82CA7396A68D541C85D26508E83_299214819 = result;
        addTaint(mc.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_299214819.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_299214819;
        // ---------- Original Method ----------
        //BigDecimal result = negate();
        //result.inplaceRound(mc);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.185 -0400", hash_original_method = "E5A0BEEECFDAB0EB24F23ED92FDA1EE0", hash_generated_method = "0DC67FEF1D7AD5461DACA92C4B9907F0")
    public BigDecimal plus() {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1038001018 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1038001018 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1038001018.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1038001018;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.185 -0400", hash_original_method = "06DE611812CE14E42B61206CBE361795", hash_generated_method = "914E4747D42E5D3F1F8B7B94EBAE3C2D")
    public BigDecimal plus(MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_553633471 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_553633471 = round(mc);
        addTaint(mc.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_553633471.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_553633471;
        // ---------- Original Method ----------
        //return round(mc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.198 -0400", hash_original_method = "CA4E5917AFEF32459FAB7B79AFDA8BD4", hash_generated_method = "D6D473BDA0783EAB656FBE3D1AD75FDB")
    public int signum() {
        {
            int varF032537E263740DA95D3B45D7C943C95_95049034 = (Long.signum( this.smallValue ));
        } //End block
        int varF8C894AC9EB5FE4FA16D557236C882F9_1105131044 = (getUnscaledValue().signum());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_921155978 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_921155978;
        // ---------- Original Method ----------
        //if( bitLength < 64) {
            //return Long.signum( this.smallValue );
        //}
        //return getUnscaledValue().signum();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.198 -0400", hash_original_method = "F3E74BAAEB162D78F28E445308393563", hash_generated_method = "971FFB790564FB6EE78060E19EDDD2A6")
    private boolean isZero() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_467588361 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_467588361;
        // ---------- Original Method ----------
        //return bitLength == 0 && this.smallValue != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.198 -0400", hash_original_method = "5F6F67A9AE4AEECC5BD64D7ACC145B6A", hash_generated_method = "53FB32DDB7A1B65984B3B0C8D9718BCC")
    public int scale() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_334954937 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_334954937;
        // ---------- Original Method ----------
        //return scale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.209 -0400", hash_original_method = "6DFBDD0E771CAF738A0C801E888E1E3B", hash_generated_method = "181B4896CC92A3C18D5EF81594F1107B")
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
                boolean var8743B4113D7AA0C9B3797D73894FAAF3_593466449 = (getUnscaledValue().divide(Multiplication.powerOf10(decimalDigits)).signum() != 0);
            } //End collapsed parenthetic
            precision = decimalDigits;
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_901524412 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_901524412;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.210 -0400", hash_original_method = "EAD040D94F5F819E555B537F69E87C66", hash_generated_method = "641C741F6A537FFB5DDAC8899084CEB0")
    private int decimalDigitsInLong(long value) {
        {
            int index;
            index = Arrays.binarySearch(MathUtils.LONG_POWERS_OF_TEN, Math.abs(value));
        } //End block
        addTaint(value);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1018404098 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1018404098;
        // ---------- Original Method ----------
        //if (value == Long.MIN_VALUE) {
            //return 19; 
        //} else {
            //int index = Arrays.binarySearch(MathUtils.LONG_POWERS_OF_TEN, Math.abs(value));
            //return (index < 0) ? (-index - 1) : (index + 1);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.210 -0400", hash_original_method = "067DA515CBCF3B72C5546CE6034B99CF", hash_generated_method = "FC3970D5E73D3565DC4DF055212CD20A")
    public BigInteger unscaledValue() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1749448486 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1749448486 = getUnscaledValue();
        varB4EAC82CA7396A68D541C85D26508E83_1749448486.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1749448486;
        // ---------- Original Method ----------
        //return getUnscaledValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.211 -0400", hash_original_method = "2FC46B1D06394AF066FA7CDA852A22F8", hash_generated_method = "DA95528FF0BA9BCD9972F2A51A9A0FB9")
    public BigDecimal round(MathContext mc) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1298052597 = null; //Variable for return #1
        BigDecimal thisBD;
        thisBD = new BigDecimal(getUnscaledValue(), scale);
        thisBD.inplaceRound(mc);
        varB4EAC82CA7396A68D541C85D26508E83_1298052597 = thisBD;
        addTaint(mc.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1298052597.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1298052597;
        // ---------- Original Method ----------
        //BigDecimal thisBD = new BigDecimal(getUnscaledValue(), scale);
        //thisBD.inplaceRound(mc);
        //return thisBD;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.227 -0400", hash_original_method = "7B0F1A102C68137F597240860B4573E3", hash_generated_method = "D1F8BD80DBB71DD7DBE7179E2CB689ED")
    public BigDecimal setScale(int newScale, RoundingMode roundingMode) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_27261381 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_911068296 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_2055305575 = null; //Variable for return #3
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_673927412 = null; //Variable for return #4
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1952383325 = null; //Variable for return #5
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        long diffScale;
        diffScale = newScale - (long)scale;
        {
            varB4EAC82CA7396A68D541C85D26508E83_27261381 = this;
        } //End block
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_911068296 = valueOf(this.smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)diffScale],newScale);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_2055305575 = new BigDecimal(Multiplication.multiplyByTenPow(getUnscaledValue(),(int)diffScale), newScale);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_673927412 = dividePrimitiveLongs(this.smallValue, MathUtils.LONG_POWERS_OF_TEN[(int)-diffScale], newScale,roundingMode);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1952383325 = divideBigIntegers(this.getUnscaledValue(),Multiplication.powerOf10(-diffScale),newScale,roundingMode);
        addTaint(newScale);
        addTaint(roundingMode.getTaint());
        BigDecimal varA7E53CE21691AB073D9660D615818899_582300657; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_582300657 = varB4EAC82CA7396A68D541C85D26508E83_27261381;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_582300657 = varB4EAC82CA7396A68D541C85D26508E83_911068296;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_582300657 = varB4EAC82CA7396A68D541C85D26508E83_2055305575;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_582300657 = varB4EAC82CA7396A68D541C85D26508E83_673927412;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_582300657 = varB4EAC82CA7396A68D541C85D26508E83_1952383325;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_582300657.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_582300657;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.233 -0400", hash_original_method = "82E5CBCA5195979E97780CEADBFBD3C4", hash_generated_method = "E7DD00EA81B67B0058DD864C4E0AE6A7")
    public BigDecimal setScale(int newScale, int roundingMode) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1238148526 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1238148526 = setScale(newScale, RoundingMode.valueOf(roundingMode));
        addTaint(newScale);
        addTaint(roundingMode);
        varB4EAC82CA7396A68D541C85D26508E83_1238148526.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1238148526;
        // ---------- Original Method ----------
        //return setScale(newScale, RoundingMode.valueOf(roundingMode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.234 -0400", hash_original_method = "ABCD452F1FC16ADBD3F58023EF098557", hash_generated_method = "388A71112708FB476558D44971F06B3F")
    public BigDecimal setScale(int newScale) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1797373082 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1797373082 = setScale(newScale, RoundingMode.UNNECESSARY);
        addTaint(newScale);
        varB4EAC82CA7396A68D541C85D26508E83_1797373082.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1797373082;
        // ---------- Original Method ----------
        //return setScale(newScale, RoundingMode.UNNECESSARY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.234 -0400", hash_original_method = "146C1C6822DF31E0F5C90B0C65347C9D", hash_generated_method = "4C05AC1B0EE21D5F3A38841AAC95B1DD")
    public BigDecimal movePointLeft(int n) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1812223453 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1812223453 = movePoint(scale + (long)n);
        addTaint(n);
        varB4EAC82CA7396A68D541C85D26508E83_1812223453.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1812223453;
        // ---------- Original Method ----------
        //return movePoint(scale + (long)n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.235 -0400", hash_original_method = "EF6481821B33DB93DBF91CDB78772ACF", hash_generated_method = "B5677167EFF1BED346297052C2E7458C")
    private BigDecimal movePoint(long newScale) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_799815714 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_192927042 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1732205371 = null; //Variable for return #3
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_178318400 = null; //Variable for return #4
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_2112290860 = null; //Variable for return #5
        {
            boolean var2CC22727CE5D95FFA6F7D70A538860F0_1703824793 = (isZero());
            {
                varB4EAC82CA7396A68D541C85D26508E83_799815714 = zeroScaledBy(Math.max(newScale, 0));
            } //End block
        } //End collapsed parenthetic
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_192927042 = valueOf(smallValue, safeLongToInt(newScale));
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1732205371 = new BigDecimal(getUnscaledValue(), safeLongToInt(newScale));
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_178318400 = valueOf(smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)-newScale],0);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2112290860 = new BigDecimal(Multiplication.multiplyByTenPow(
                getUnscaledValue(), safeLongToInt(-newScale)), 0);
        addTaint(newScale);
        BigDecimal varA7E53CE21691AB073D9660D615818899_81864390; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_81864390 = varB4EAC82CA7396A68D541C85D26508E83_799815714;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_81864390 = varB4EAC82CA7396A68D541C85D26508E83_192927042;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_81864390 = varB4EAC82CA7396A68D541C85D26508E83_1732205371;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_81864390 = varB4EAC82CA7396A68D541C85D26508E83_178318400;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_81864390 = varB4EAC82CA7396A68D541C85D26508E83_2112290860;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_81864390.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_81864390;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.255 -0400", hash_original_method = "07D5C3611C3ACCF090DC6103621F9345", hash_generated_method = "E60E4D6B68D356F7C840C7CFE074355C")
    public BigDecimal movePointRight(int n) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_2095558623 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2095558623 = movePoint(scale - (long)n);
        addTaint(n);
        varB4EAC82CA7396A68D541C85D26508E83_2095558623.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2095558623;
        // ---------- Original Method ----------
        //return movePoint(scale - (long)n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.255 -0400", hash_original_method = "D86719E7E7F9F283B32E5780DA0BBE23", hash_generated_method = "25A2FDCC9F6A11CCEF01520D4DCDA5DF")
    public BigDecimal scaleByPowerOfTen(int n) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1704075151 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1846400646 = null; //Variable for return #2
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_468735776 = null; //Variable for return #3
        long newScale;
        newScale = scale - (long)n;
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1704075151 = zeroScaledBy( newScale );
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1846400646 = valueOf(smallValue, safeLongToInt(newScale));
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_468735776 = new BigDecimal(getUnscaledValue(), safeLongToInt(newScale));
        addTaint(n);
        BigDecimal varA7E53CE21691AB073D9660D615818899_652383578; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_652383578 = varB4EAC82CA7396A68D541C85D26508E83_1704075151;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_652383578 = varB4EAC82CA7396A68D541C85D26508E83_1846400646;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_652383578 = varB4EAC82CA7396A68D541C85D26508E83_468735776;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_652383578.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_652383578;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.257 -0400", hash_original_method = "6A410D70691999CADF96A81B91BD2E64", hash_generated_method = "34D490DD7DED3DFB9A0E48348F2BFD9A")
    public BigDecimal stripTrailingZeros() {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1192630339 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1815056466 = null; //Variable for return #2
        int i;
        i = 1;
        int lastPow;
        lastPow = TEN_POW.length - 1;
        long newScale;
        newScale = scale;
        {
            boolean var2CC22727CE5D95FFA6F7D70A538860F0_1333412427 = (isZero());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1192630339 = this;
            } //End block
        } //End collapsed parenthetic
        BigInteger strippedBI;
        strippedBI = getUnscaledValue();
        BigInteger[] quotAndRem;
        {
            boolean varFEBA48CABF974070FADE4D4043F8A64F_241262008 = (!strippedBI.testBit(0));
            {
                quotAndRem = strippedBI.divideAndRemainder(TEN_POW[i]);
                {
                    boolean varC86A45592F149ACDEC5EDB396276478E_408209090 = (quotAndRem[1].signum() == 0);
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
        varB4EAC82CA7396A68D541C85D26508E83_1815056466 = new BigDecimal(strippedBI, safeLongToInt(newScale));
        BigDecimal varA7E53CE21691AB073D9660D615818899_843983504; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_843983504 = varB4EAC82CA7396A68D541C85D26508E83_1192630339;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_843983504 = varB4EAC82CA7396A68D541C85D26508E83_1815056466;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_843983504.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_843983504;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.258 -0400", hash_original_method = "1C45ED34C4C1F5BEBD8BB8EF3CBE1A6B", hash_generated_method = "E2748C1EA506CFB4F2AAB7F63967A120")
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
                int varCE3C94A5820498591ABCE6F39E1FAD3F_1067496618 = (thisUnscaled.compareTo(valUnscaled));
            } //End block
        } //End block
        addTaint(val.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1691632611 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1691632611;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.269 -0400", hash_original_method = "310E755E039C5525B03EE3C0A35D27A8", hash_generated_method = "6C8D0F0C8CF2937A7ABC25A3EEAF2B8E")
    @Override
    public boolean equals(Object x) {
        {
            BigDecimal x1;
            x1 = (BigDecimal) x;
            boolean var001662A341C29FE1FFD924EE7151116A_284729394 = (x1.scale == scale
                   && (bitLength < 64 ? (x1.smallValue == smallValue)
                    : intVal.equals(x1.intVal))); //DSFIXME:  CODE0008: Nested ternary operator in expression
        } //End block
        addTaint(x.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_706084895 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_706084895;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.270 -0400", hash_original_method = "F19ED99F66E082325A61ACA186AF7454", hash_generated_method = "602E6A8DCFE28ED597488E4B3AACAC92")
    public BigDecimal min(BigDecimal val) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1508964395 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1508964395 = ((compareTo(val) <= 0) ? this : val);
        addTaint(val.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1508964395.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1508964395;
        // ---------- Original Method ----------
        //return ((compareTo(val) <= 0) ? this : val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.270 -0400", hash_original_method = "4EA6A2C4CEA295044D603E0ACE9B5BC6", hash_generated_method = "910E603AD164DEB5D58342D564CCE9AD")
    public BigDecimal max(BigDecimal val) {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_833648905 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_833648905 = ((compareTo(val) >= 0) ? this : val);
        addTaint(val.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_833648905.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_833648905;
        // ---------- Original Method ----------
        //return ((compareTo(val) >= 0) ? this : val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.271 -0400", hash_original_method = "F20F131BB03F0B25B12A1EF1F413017D", hash_generated_method = "DB5EF25D03437F0FFB397FB7C7AF2E40")
    @Override
    public int hashCode() {
        {
            hashCode = (int)(smallValue & 0xffffffff);
            hashCode = 33 * hashCode +  (int)((smallValue >> 32) & 0xffffffff);
            hashCode = 17 * hashCode + scale;
        } //End block
        hashCode = 17 * intVal.hashCode() + scale;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1972799621 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1972799621;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.275 -0400", hash_original_method = "7C431BE8FF70735180E872A989DC1E52", hash_generated_method = "735570F8D2A88D232F9D3321BF95AC6B")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1192657827 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_863407688 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_106200663 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_2058176046 = null; //Variable for return #4
        {
            varB4EAC82CA7396A68D541C85D26508E83_1192657827 = toStringImage;
        } //End block
        {
            toStringImage = Conversion.toDecimalScaledString(smallValue,scale);
            varB4EAC82CA7396A68D541C85D26508E83_863407688 = toStringImage;
        } //End block
        String intString;
        intString = getUnscaledValue().toString();
        {
            varB4EAC82CA7396A68D541C85D26508E83_106200663 = intString;
        } //End block
        int begin;
        boolean var5FFC8DC69DEA58D4CEC873F848ECF641_1587500495 = ((getUnscaledValue().signum() < 0));
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
        varB4EAC82CA7396A68D541C85D26508E83_2058176046 = toStringImage;
        String varA7E53CE21691AB073D9660D615818899_537396006; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_537396006 = varB4EAC82CA7396A68D541C85D26508E83_1192657827;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_537396006 = varB4EAC82CA7396A68D541C85D26508E83_863407688;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_537396006 = varB4EAC82CA7396A68D541C85D26508E83_106200663;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_537396006 = varB4EAC82CA7396A68D541C85D26508E83_2058176046;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_537396006.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_537396006;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.288 -0400", hash_original_method = "37C393D601D5FE9982CCA7EB2837999F", hash_generated_method = "E49BD39BAF9EE4B77D17112EAE899DF3")
    public String toEngineeringString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1841427133 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_623469330 = null; //Variable for return #2
        String intString;
        intString = getUnscaledValue().toString();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1841427133 = intString;
        } //End block
        int begin;
        boolean var5FFC8DC69DEA58D4CEC873F848ECF641_986460974 = ((getUnscaledValue().signum() < 0));
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
                    boolean varF1275512AD4A7A2856364C7EFBECF78A_1097824867 = (getUnscaledValue().signum() == 0);
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
        varB4EAC82CA7396A68D541C85D26508E83_623469330 = result.toString();
        String varA7E53CE21691AB073D9660D615818899_613421757; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_613421757 = varB4EAC82CA7396A68D541C85D26508E83_1841427133;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_613421757 = varB4EAC82CA7396A68D541C85D26508E83_623469330;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_613421757.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_613421757;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.290 -0400", hash_original_method = "F2C3CA97C72252FC482FDCEF1D32932E", hash_generated_method = "8FA210033FC0B8CD7BA347451B786361")
    public String toPlainString() {
        String varB4EAC82CA7396A68D541C85D26508E83_634064924 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1360890006 = null; //Variable for return #2
        String intStr;
        intStr = getUnscaledValue().toString();
        {
            boolean var5EBF43068CE74A5170A1EF5C21021CBF_15215060 = ((scale == 0) || ((isZero()) && (scale < 0)));
            {
                varB4EAC82CA7396A68D541C85D26508E83_634064924 = intStr;
            } //End block
        } //End collapsed parenthetic
        int begin;
        boolean var515FA627C40C3884068623DD22E9034F_600764131 = ((signum() < 0));
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
        varB4EAC82CA7396A68D541C85D26508E83_1360890006 = result.toString();
        String varA7E53CE21691AB073D9660D615818899_869811707; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_869811707 = varB4EAC82CA7396A68D541C85D26508E83_634064924;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_869811707 = varB4EAC82CA7396A68D541C85D26508E83_1360890006;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_869811707.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_869811707;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.301 -0400", hash_original_method = "E90ADE3EE93FD433EFA047972DEC5382", hash_generated_method = "E828268184B6FF3DD720407A3B7FA55C")
    public BigInteger toBigInteger() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_2063706928 = null; //Variable for return #1
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_577145534 = null; //Variable for return #2
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_368590597 = null; //Variable for return #3
        {
            boolean var527650A3DE5B2457ABCDED439E32377E_2006126713 = ((scale == 0) || (isZero()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_2063706928 = getUnscaledValue();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_577145534 = getUnscaledValue().multiply(Multiplication.powerOf10(-(long)scale));
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_368590597 = getUnscaledValue().divide(Multiplication.powerOf10(scale));
            } //End block
        } //End collapsed parenthetic
        BigInteger varA7E53CE21691AB073D9660D615818899_1322706780; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1322706780 = varB4EAC82CA7396A68D541C85D26508E83_2063706928;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1322706780 = varB4EAC82CA7396A68D541C85D26508E83_577145534;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1322706780 = varB4EAC82CA7396A68D541C85D26508E83_368590597;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1322706780.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1322706780;
        // ---------- Original Method ----------
        //if ((scale == 0) || (isZero())) {
            //return getUnscaledValue();
        //} else if (scale < 0) {
            //return getUnscaledValue().multiply(Multiplication.powerOf10(-(long)scale));
        //} else {
            //return getUnscaledValue().divide(Multiplication.powerOf10(scale));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.317 -0400", hash_original_method = "0E78A189176A3E6769EBE407FB203DE6", hash_generated_method = "ACB5660C039194217F1693311EF81415")
    public BigInteger toBigIntegerExact() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_287406043 = null; //Variable for return #1
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_791918402 = null; //Variable for return #2
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1483567389 = null; //Variable for return #3
        {
            boolean var527650A3DE5B2457ABCDED439E32377E_367613931 = ((scale == 0) || (isZero()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_287406043 = getUnscaledValue();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_791918402 = getUnscaledValue().multiply(Multiplication.powerOf10(-(long)scale));
            } //End block
            {
                BigInteger[] integerAndFraction;
                {
                    boolean varDA526623548FC456E3243F91470F7749_858888126 = ((scale > approxPrecision()) || (scale > getUnscaledValue().getLowestSetBit()));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("Rounding necessary");
                    } //End block
                } //End collapsed parenthetic
                integerAndFraction = getUnscaledValue().divideAndRemainder(Multiplication.powerOf10(scale));
                {
                    boolean var295E569F979C75DF93112C8D385DE9FD_1279678606 = (integerAndFraction[1].signum() != 0);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("Rounding necessary");
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_1483567389 = integerAndFraction[0];
            } //End block
        } //End collapsed parenthetic
        BigInteger varA7E53CE21691AB073D9660D615818899_351154835; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_351154835 = varB4EAC82CA7396A68D541C85D26508E83_287406043;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_351154835 = varB4EAC82CA7396A68D541C85D26508E83_791918402;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_351154835 = varB4EAC82CA7396A68D541C85D26508E83_1483567389;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_351154835.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_351154835;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.318 -0400", hash_original_method = "A54EDCAFB9A559A1B4EB83484BB75122", hash_generated_method = "2886ED8011346DCF2D275673EEA80364")
    @Override
    public long longValue() {
        long var02BCFECEB27CDDF7BA27A8716D0E8C08_687079504 = (((scale <= -64) || (scale > approxPrecision()) ? 0L
                : toBigInteger().longValue())); //DSFIXME:  CODE0008: Nested ternary operator in expression
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2061694285 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2061694285;
        // ---------- Original Method ----------
        //return ((scale <= -64) || (scale > approxPrecision()) ? 0L
                //: toBigInteger().longValue());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.319 -0400", hash_original_method = "FC36A176D0180DB1420333E5E0A5371B", hash_generated_method = "163ADAE9B406ECBF160872DEB3A1245E")
    public long longValueExact() {
        long var911FCAB8DFB4008CF2390984C1A72430_1952662170 = (valueExact(64));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_528858824 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_528858824;
        // ---------- Original Method ----------
        //return valueExact(64);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.319 -0400", hash_original_method = "C22AEC57669E1045E01A9977FB32CBED", hash_generated_method = "A0D4CB9FB0F24C1C7FEB5F52A0C959C5")
    @Override
    public int intValue() {
        int var260F64E277497774BB8037E8D91956FC_5154152 = (((scale <= -32) || (scale > approxPrecision())
        ? 0
                : toBigInteger().intValue())); //DSFIXME:  CODE0008: Nested ternary operator in expression
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_320050466 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_320050466;
        // ---------- Original Method ----------
        //return ((scale <= -32) || (scale > approxPrecision())
        //? 0
                //: toBigInteger().intValue());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.319 -0400", hash_original_method = "3865E14853C36D94FA2C26348C89A3B8", hash_generated_method = "DA7BAC167EA8B5BBE42F8712B75C7ADA")
    public int intValueExact() {
        int var86C4522ACDF35D342B59DBE535781A9E_2144469436 = ((int)valueExact(32));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_330482107 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_330482107;
        // ---------- Original Method ----------
        //return (int)valueExact(32);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.320 -0400", hash_original_method = "D0948D36E91C12739D01E1A7BD76887B", hash_generated_method = "284B757F4D3C257ED8A246791C14B6FC")
    public short shortValueExact() {
        short varA81ACCE95AC11A2580319A9BFEB7E9B2_1634792622 = ((short)valueExact(16));
        short var4F09DAA9D95BCB166A302407A0E0BABE_2107821063 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_2107821063;
        // ---------- Original Method ----------
        //return (short)valueExact(16);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.320 -0400", hash_original_method = "D6CE76A6DF6EC675E82ED0D5BFCEAF06", hash_generated_method = "2B3FD94D128B1F23E757AEE1F8314BA2")
    public byte byteValueExact() {
        byte varD83BA7BD5DF600388856A2C30163822F_829818952 = ((byte)valueExact(8));
        byte var40EA57D3EE3C07BF1C102B466E1C3091_4895613 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_4895613;
        // ---------- Original Method ----------
        //return (byte)valueExact(8);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.324 -0400", hash_original_method = "4137052570907849FFBB7EF546BA389D", hash_generated_method = "8E17A12A65DB7BC353B540B9218776D6")
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
        float var546ADE640B6EDFBC8A086EF31347E768_1551747953 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1551747953;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.350 -0400", hash_original_method = "73F99D783081712086B11A0804DADCB9", hash_generated_method = "024598B97A53C7659817B8AACEA57281")
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
        double varCD654D4151F8E678076C18FA9FDC44FD_1627543229 = (Double.longBitsToDouble(bits));
        double varE8CD7DA078A86726031AD64F35F5A6C0_1127391572 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1127391572;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.366 -0400", hash_original_method = "AE130D2701C769DD6982173139D47466", hash_generated_method = "E9B7E65D3D7C65155B202738F36F4509")
    public BigDecimal ulp() {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1272052714 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1272052714 = valueOf(1, scale);
        varB4EAC82CA7396A68D541C85D26508E83_1272052714.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1272052714;
        // ---------- Original Method ----------
        //return valueOf(1, scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.368 -0400", hash_original_method = "55CD7E6ED2002FE9D7C30850FBD08759", hash_generated_method = "B02F264BD7CDD5C1EE402067138D52C3")
    private void inplaceRound(MathContext mc) {
        int mcPrecision;
        mcPrecision = mc.getPrecision();
        {
            boolean var6F010C2CB7AD09A8BC94F0B71513AC32_309114142 = (approxPrecision() < mcPrecision || mcPrecision == 0);
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
            boolean var117BFEC09FEE1A0EBD26552B3C18D98D_1120156732 = (integerAndFraction[1].signum() != 0);
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
                    boolean var10B8B9353B6BDAF0B62CA0F73EC5E632_632059269 = (tempBD.precision() > mcPrecision);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.377 -0400", hash_original_method = "7FBE752FF3FF6B350050AE2B0F2B0308", hash_generated_method = "4832A2D68CE001F8010066580B402684")
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
                boolean var23E618BB7F5984728547DADF43F7547E_686821979 = (Math.log10(Math.abs(integer)) >= mc.getPrecision());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.378 -0400", hash_original_method = "77E444DFD73510CC8BF3E35576C17A04", hash_generated_method = "83B2A8613AF26C75E4980023A5F84512")
    private long valueExact(int bitLengthOfType) {
        BigInteger bigInteger;
        bigInteger = toBigIntegerExact();
        {
            boolean var34AD3BA92A978E0890FA3B0628CDDC06_318119454 = (bigInteger.bitLength() < bitLengthOfType);
            {
                long var9D31F6DC18FE28EB42FCCA0D0D616FEB_218085758 = (bigInteger.longValue());
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("Rounding necessary");
        addTaint(bitLengthOfType);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_447719100 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_447719100;
        // ---------- Original Method ----------
        //BigInteger bigInteger = toBigIntegerExact();
        //if (bigInteger.bitLength() < bitLengthOfType) {
            //return bigInteger.longValue();
        //}
        //throw new ArithmeticException("Rounding necessary");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.378 -0400", hash_original_method = "610DE3E95388579A8DD4E22BDEDE3C6E", hash_generated_method = "F3B782816052A46C4442961DFB8FE11D")
    private int approxPrecision() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2017823188 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2017823188;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.379 -0400", hash_original_method = "886E4F08C2196C85465CF795B505FE44", hash_generated_method = "BDA0F1AC8B98ACD4B899312EFE36FE5A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.379 -0400", hash_original_method = "19FA8CC309F5EC9C814FD711C697099A", hash_generated_method = "8A0F3297B8DAFE46D5786E4A20AAF3B5")
    private void writeObject(ObjectOutputStream out) throws IOException {
        getUnscaledValue();
        out.defaultWriteObject();
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //getUnscaledValue();
        //out.defaultWriteObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.380 -0400", hash_original_method = "1C1109E2DBDCFAE7331AD37D197254D0", hash_generated_method = "439E2A9368C193C45009C1EE3D95B456")
    private BigInteger getUnscaledValue() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1464656619 = null; //Variable for return #1
        {
            intVal = BigInteger.valueOf(smallValue);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1464656619 = intVal;
        varB4EAC82CA7396A68D541C85D26508E83_1464656619.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1464656619;
        // ---------- Original Method ----------
        //if(intVal == null) {
            //intVal = BigInteger.valueOf(smallValue);
        //}
        //return intVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.380 -0400", hash_original_method = "3BE919C32007DA5FAF4FB8B842EE650C", hash_generated_method = "49E7AC88CEF6902CE7BE924ADF202E8D")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.397 -0400", hash_original_field = "877CBC7572A1F4C5C4A5EF0FCDBA91C3", hash_generated_field = "B6EECEB04C7C8E9BC518DBA316290DA7")

    public static final int ROUND_UP = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.397 -0400", hash_original_field = "D2CF03DE063925E19E13C52C8FBE1929", hash_generated_field = "454999CD924CB489896B8D343444FE92")

    public static final int ROUND_DOWN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.398 -0400", hash_original_field = "AAC8B6F1C4763B9728AB52AE15952AF6", hash_generated_field = "3C0D845F7C2F954D2ED7E86C0AE35835")

    public static final int ROUND_CEILING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.398 -0400", hash_original_field = "7503CC26EC44F42386A1D0025B5AEF97", hash_generated_field = "53D60190BBA8538A982DF868F4C6200E")

    public static final int ROUND_FLOOR = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.398 -0400", hash_original_field = "7E7DD45EF4EB3B06BFEF96EA4B0DD84D", hash_generated_field = "F10F1696D5C52C5E6B4B91643A72CEBE")

    public static final int ROUND_HALF_UP = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.401 -0400", hash_original_field = "20B7B28A1B56AD4CEA47F72CC0696346", hash_generated_field = "1619429E1C6C75DCE5756A9CF242CB9E")

    public static final int ROUND_HALF_DOWN = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.401 -0400", hash_original_field = "B3DCF23AE156DDE73D388CA751C9365F", hash_generated_field = "737A62C6AFA4A3B8167B738F856B0DEA")

    public static final int ROUND_HALF_EVEN = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.401 -0400", hash_original_field = "22697FABD637B187447A670B355A0081", hash_generated_field = "C5A01DD93D79DC15583A8D0F0236E74E")

    public static final int ROUND_UNNECESSARY = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.401 -0400", hash_original_field = "116BD32AD0E75158256F445ABDC8389D", hash_generated_field = "6A48F8D7834878E630AA100A044B06C9")

    private static long serialVersionUID = 6108874887143696463L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.401 -0400", hash_original_field = "7458DC5DA966512012D7187A9F089DAC", hash_generated_field = "C8D6435C53FE2DEAE663FE15186F09F8")

    private static double LOG10_2 = 0.3010299956639812;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.401 -0400", hash_original_field = "5515FC399FA5591FAB09427986B893AC", hash_generated_field = "BC1FA69034FA076F552F1F096B6FE848")

    private static BigInteger[] FIVE_POW;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.401 -0400", hash_original_field = "6890CCC61C514170BDE91D0B4ED71AF6", hash_generated_field = "487DAC2FC944E340E99AE2E5C8C63B33")

    private static BigInteger[] TEN_POW;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.401 -0400", hash_original_field = "B3E64594B71C88A1FCA0FDDB1DB0D932", hash_generated_field = "BC622D252D29AC82357ECA77BDEE6391")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.401 -0400", hash_original_field = "BE202B01F91923E667B3B16B069D07DC", hash_generated_field = "9B70F6A9034B314601CCA32CF3A34AF7")

    private static int[] LONG_FIVE_POW_BIT_LENGTH = new int[LONG_FIVE_POW.length];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.401 -0400", hash_original_field = "157379F1EEDF7417D34D4EA991CF2184", hash_generated_field = "6C1BEE3FF35350B086316370A7F5F258")

    private static int[] LONG_POWERS_OF_TEN_BIT_LENGTH = new int[MathUtils.LONG_POWERS_OF_TEN.length];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.401 -0400", hash_original_field = "921789C958D668713F05F9FFE836B8C7", hash_generated_field = "9D29B5A0C77695F8BC92BA2512FC0999")

    private static int BI_SCALED_BY_ZERO_LENGTH = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.401 -0400", hash_original_field = "717A7640C2D9003B18C4055EC0C50419", hash_generated_field = "1EE791938B7988205992B62BC2B7F0AC")

    private static BigDecimal[] BI_SCALED_BY_ZERO = new BigDecimal[BI_SCALED_BY_ZERO_LENGTH];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.401 -0400", hash_original_field = "39586D78C45D7A19439688292151133A", hash_generated_field = "AF28D3C06FB6631E41CACFA5D1A2AFAA")

    private static BigDecimal[] ZERO_SCALED_BY = new BigDecimal[11];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.401 -0400", hash_original_field = "94F236C8393993A7B9287704666BFBEE", hash_generated_field = "DF59AECFEA0B4D6FD254138ED59B18B0")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.401 -0400", hash_original_field = "B1F433B3E708BA2079293308D7CA4999", hash_generated_field = "E2BD5BBDB2DF3AE4973FDC84A00AF40A")

    public static final BigDecimal ZERO = new BigDecimal(0, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.401 -0400", hash_original_field = "3A7ACF4CD264E65305ECE3D1A439ECF7", hash_generated_field = "9F34079F2BD32FDD32B17DD6B2BC0759")

    public static final BigDecimal ONE = new BigDecimal(1, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.401 -0400", hash_original_field = "831A4D5A2871A70F006594FB3523DE19", hash_generated_field = "7D43F273171CCD7BF176CC18D6BEE813")

    public static final BigDecimal TEN = new BigDecimal(10, 0);
}

