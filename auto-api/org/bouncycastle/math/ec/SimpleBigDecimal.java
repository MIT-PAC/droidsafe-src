package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigInteger;

class SimpleBigDecimal {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.396 -0400", hash_original_field = "33A2DB2A239C5BAAA46376495EE5F6ED", hash_generated_field = "4CD174344F65D3883705CA71073A947D")

    private BigInteger bigInt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.396 -0400", hash_original_field = "0CB47AEB6E5F9323F0969E628C4E59F5", hash_generated_field = "F9D5D1CA2ABDD82810FF1FE80E0268E6")

    private int scale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.401 -0400", hash_original_method = "B9E3F8F2D1F0CB50E3B2E06390DB4E90", hash_generated_method = "0B6FE15653CE30B8304023B193D64CD2")
    public  SimpleBigDecimal(BigInteger bigInt, int scale) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("scale may not be negative");
        } //End block
        this.bigInt = bigInt;
        this.scale = scale;
        // ---------- Original Method ----------
        //if (scale < 0)
        //{
            //throw new IllegalArgumentException("scale may not be negative");
        //}
        //this.bigInt = bigInt;
        //this.scale = scale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.401 -0400", hash_original_method = "BB0449F02A6AA340B8F9AEE6846C1B89", hash_generated_method = "3D0C818EB173578CDB4338C6D8735F35")
    private  SimpleBigDecimal(SimpleBigDecimal limBigDec) {
        bigInt = limBigDec.bigInt;
        scale = limBigDec.scale;
        // ---------- Original Method ----------
        //bigInt = limBigDec.bigInt;
        //scale = limBigDec.scale;
    }

    
        public static SimpleBigDecimal getInstance(BigInteger value, int scale) {
        return new SimpleBigDecimal(value.shiftLeft(scale), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.402 -0400", hash_original_method = "C3E845BC0594ECAC644A3338EF26C373", hash_generated_method = "DE27A50F662C560F06B8BDE247D46668")
    private void checkScale(SimpleBigDecimal b) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Only SimpleBigDecimal of " +
                "same scale allowed in arithmetic operations");
        } //End block
        addTaint(b.getTaint());
        // ---------- Original Method ----------
        //if (scale != b.scale)
        //{
            //throw new IllegalArgumentException("Only SimpleBigDecimal of " +
                //"same scale allowed in arithmetic operations");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.402 -0400", hash_original_method = "6E51DD7AA8BCA4EBA8ECDE4AADAA865C", hash_generated_method = "C52C17429BAB9B1ED6E62D6A130079E8")
    public SimpleBigDecimal adjustScale(int newScale) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_4836314 = null; //Variable for return #1
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_336479756 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("scale may not be negative");
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_4836314 = new SimpleBigDecimal(this);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_336479756 = new SimpleBigDecimal(bigInt.shiftLeft(newScale - scale),
                newScale);
        addTaint(newScale);
        SimpleBigDecimal varA7E53CE21691AB073D9660D615818899_1330206488; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1330206488 = varB4EAC82CA7396A68D541C85D26508E83_4836314;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1330206488 = varB4EAC82CA7396A68D541C85D26508E83_336479756;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1330206488.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1330206488;
        // ---------- Original Method ----------
        //if (newScale < 0)
        //{
            //throw new IllegalArgumentException("scale may not be negative");
        //}
        //if (newScale == scale)
        //{
            //return new SimpleBigDecimal(this);
        //}
        //return new SimpleBigDecimal(bigInt.shiftLeft(newScale - scale),
                //newScale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.403 -0400", hash_original_method = "9B93EEC174A0454ADCF32BC9274B05B6", hash_generated_method = "D3D5CAAB567EC1197A130A00A9DC2FB3")
    public SimpleBigDecimal add(SimpleBigDecimal b) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_505601637 = null; //Variable for return #1
        checkScale(b);
        varB4EAC82CA7396A68D541C85D26508E83_505601637 = new SimpleBigDecimal(bigInt.add(b.bigInt), scale);
        addTaint(b.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_505601637.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_505601637;
        // ---------- Original Method ----------
        //checkScale(b);
        //return new SimpleBigDecimal(bigInt.add(b.bigInt), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.423 -0400", hash_original_method = "1997D6C5826C900035276C18BCFDD9D3", hash_generated_method = "997585FFCE3E2AE0864FD78146B49E01")
    public SimpleBigDecimal add(BigInteger b) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_1051049421 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1051049421 = new SimpleBigDecimal(bigInt.add(b.shiftLeft(scale)), scale);
        addTaint(b.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1051049421.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1051049421;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.add(b.shiftLeft(scale)), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.423 -0400", hash_original_method = "847D70590D3897E07ED49ABD60DD0D05", hash_generated_method = "F24D49333876FD419B015701B7B82B54")
    public SimpleBigDecimal negate() {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_1046405156 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1046405156 = new SimpleBigDecimal(bigInt.negate(), scale);
        varB4EAC82CA7396A68D541C85D26508E83_1046405156.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1046405156;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.negate(), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.424 -0400", hash_original_method = "E3DDD4A4133D81CA99A1E7F6CCD5CF2B", hash_generated_method = "22E7F2FEEC28FAA8BD4260E4CE286EF4")
    public SimpleBigDecimal subtract(SimpleBigDecimal b) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_572849828 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_572849828 = add(b.negate());
        addTaint(b.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_572849828.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_572849828;
        // ---------- Original Method ----------
        //return add(b.negate());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.424 -0400", hash_original_method = "5502C0B2E51F8EC346A3B0EA2AFD7881", hash_generated_method = "7B212474D883EEEBE7F0916986660DE9")
    public SimpleBigDecimal subtract(BigInteger b) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_92710500 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_92710500 = new SimpleBigDecimal(bigInt.subtract(b.shiftLeft(scale)),
                scale);
        addTaint(b.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_92710500.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_92710500;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.subtract(b.shiftLeft(scale)),
                //scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.425 -0400", hash_original_method = "330628D6579367C0F7404BA6336A3E07", hash_generated_method = "87D943BDD584014BC89457BFE62FEA65")
    public SimpleBigDecimal multiply(SimpleBigDecimal b) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_650397778 = null; //Variable for return #1
        checkScale(b);
        varB4EAC82CA7396A68D541C85D26508E83_650397778 = new SimpleBigDecimal(bigInt.multiply(b.bigInt), scale + scale);
        addTaint(b.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_650397778.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_650397778;
        // ---------- Original Method ----------
        //checkScale(b);
        //return new SimpleBigDecimal(bigInt.multiply(b.bigInt), scale + scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.425 -0400", hash_original_method = "F7512EC811E7F46BF7093DEE1B5F6571", hash_generated_method = "4AEFF4FABF5EF3C82A08C8C6A2401F04")
    public SimpleBigDecimal multiply(BigInteger b) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_1502199037 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1502199037 = new SimpleBigDecimal(bigInt.multiply(b), scale);
        addTaint(b.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1502199037.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1502199037;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.multiply(b), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.426 -0400", hash_original_method = "7E74D1BB6D8D1863DA2FA49A62271B48", hash_generated_method = "4A296C863A9CB595DD7602F3625C80F7")
    public SimpleBigDecimal divide(SimpleBigDecimal b) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_1313093070 = null; //Variable for return #1
        checkScale(b);
        BigInteger dividend;
        dividend = bigInt.shiftLeft(scale);
        varB4EAC82CA7396A68D541C85D26508E83_1313093070 = new SimpleBigDecimal(dividend.divide(b.bigInt), scale);
        addTaint(b.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1313093070.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1313093070;
        // ---------- Original Method ----------
        //checkScale(b);
        //BigInteger dividend = bigInt.shiftLeft(scale);
        //return new SimpleBigDecimal(dividend.divide(b.bigInt), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.426 -0400", hash_original_method = "F0938440F96DC20B0D4303728A0BA40C", hash_generated_method = "B0E9CAB28FD912EB9B48D2C0931C7E67")
    public SimpleBigDecimal divide(BigInteger b) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_1770284528 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1770284528 = new SimpleBigDecimal(bigInt.divide(b), scale);
        addTaint(b.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1770284528.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1770284528;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.divide(b), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.427 -0400", hash_original_method = "886004AC1E5A48AB6425DAAA9E6A9AE1", hash_generated_method = "24B3068D4AC30980FA7F4E6E93A10486")
    public SimpleBigDecimal shiftLeft(int n) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_1424141031 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1424141031 = new SimpleBigDecimal(bigInt.shiftLeft(n), scale);
        addTaint(n);
        varB4EAC82CA7396A68D541C85D26508E83_1424141031.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1424141031;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.shiftLeft(n), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.447 -0400", hash_original_method = "F4FD2CFD498531A1DCCD160DB4A55A56", hash_generated_method = "31A224E3534E1DA700BAB2D6F325529D")
    public int compareTo(SimpleBigDecimal val) {
        checkScale(val);
        int var9716E05F1AAB957E38CF488CDF7A87FE_722088529 = (bigInt.compareTo(val.bigInt));
        addTaint(val.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1283531522 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1283531522;
        // ---------- Original Method ----------
        //checkScale(val);
        //return bigInt.compareTo(val.bigInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.448 -0400", hash_original_method = "DA142CFE02A0CE378556DA61E5DFFA33", hash_generated_method = "C45749ADC0908B990C53AB5E5C060B47")
    public int compareTo(BigInteger val) {
        int var82CAFFB47EB528AAC6F01817DCE93EF3_1228642179 = (bigInt.compareTo(val.shiftLeft(scale)));
        addTaint(val.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_637452775 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_637452775;
        // ---------- Original Method ----------
        //return bigInt.compareTo(val.shiftLeft(scale));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.449 -0400", hash_original_method = "5A4C971F5322638C8E9F4B26460E4E92", hash_generated_method = "A803922906E5095BD976B50F15B6B3A8")
    public BigInteger floor() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1331938189 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1331938189 = bigInt.shiftRight(scale);
        varB4EAC82CA7396A68D541C85D26508E83_1331938189.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1331938189;
        // ---------- Original Method ----------
        //return bigInt.shiftRight(scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.454 -0400", hash_original_method = "92FC76983B02D95A30B18D6CBD3123C0", hash_generated_method = "7B94F23BCBF0CDB643D02D2A6EE38534")
    public BigInteger round() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_400244872 = null; //Variable for return #1
        SimpleBigDecimal oneHalf;
        oneHalf = new SimpleBigDecimal(ECConstants.ONE, 1);
        varB4EAC82CA7396A68D541C85D26508E83_400244872 = add(oneHalf.adjustScale(scale)).floor();
        varB4EAC82CA7396A68D541C85D26508E83_400244872.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_400244872;
        // ---------- Original Method ----------
        //SimpleBigDecimal oneHalf = new SimpleBigDecimal(ECConstants.ONE, 1);
        //return add(oneHalf.adjustScale(scale)).floor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.456 -0400", hash_original_method = "8F98A91102E8EBECCDC59FAE2090EE26", hash_generated_method = "E3C2B268C15CDC26C45FC3C7D74240C8")
    public int intValue() {
        int var6670763D4ED36247FD6BBDE7591A2BEB_1005788521 = (floor().intValue());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_674941532 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_674941532;
        // ---------- Original Method ----------
        //return floor().intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.457 -0400", hash_original_method = "AA9F4F5827911FF9AD2916733B5D4AF6", hash_generated_method = "D6809D359F16225599025A253E93E856")
    public long longValue() {
        long var0F89E31FA1433C1CBAE17116C0BCC786_893900342 = (floor().longValue());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1940093749 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1940093749;
        // ---------- Original Method ----------
        //return floor().longValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.458 -0400", hash_original_method = "555259738C76709D8C0A4CEB0BA4F05B", hash_generated_method = "6ADE3399E1DD5F25FE2991FD9628DED7")
    public int getScale() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_514924089 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_514924089;
        // ---------- Original Method ----------
        //return scale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.468 -0400", hash_original_method = "687FE1E6404530E144AF0CBE5E24BCFF", hash_generated_method = "87D1A85C5F3DC5C5E303D7D60052BB7E")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1502388810 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_944734679 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1502388810 = bigInt.toString();
        } //End block
        BigInteger floorBigInt;
        floorBigInt = floor();
        BigInteger fract;
        fract = bigInt.subtract(floorBigInt.shiftLeft(scale));
        {
            boolean varED0BFE98954101C6F44F91A570BA4A80_1671036172 = (bigInt.signum() == -1);
            {
                fract = ECConstants.ONE.shiftLeft(scale).subtract(fract);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var5265F348731546FA9139EF5056083087_552950778 = ((floorBigInt.signum() == -1) && (!(fract.equals(ECConstants.ZERO))));
            {
                floorBigInt = floorBigInt.add(ECConstants.ONE);
            } //End block
        } //End collapsed parenthetic
        String leftOfPoint;
        leftOfPoint = floorBigInt.toString();
        char[] fractCharArr;
        fractCharArr = new char[scale];
        String fractStr;
        fractStr = fract.toString(2);
        int fractLen;
        fractLen = fractStr.length();
        int zeroes;
        zeroes = scale - fractLen;
        {
            int i;
            i = 0;
            {
                fractCharArr[i] = '0';
            } //End block
        } //End collapsed parenthetic
        {
            int j;
            j = 0;
            {
                fractCharArr[zeroes + j] = fractStr.charAt(j);
            } //End block
        } //End collapsed parenthetic
        String rightOfPoint;
        rightOfPoint = new String(fractCharArr);
        StringBuffer sb;
        sb = new StringBuffer(leftOfPoint);
        sb.append(".");
        sb.append(rightOfPoint);
        varB4EAC82CA7396A68D541C85D26508E83_944734679 = sb.toString();
        String varA7E53CE21691AB073D9660D615818899_215893623; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_215893623 = varB4EAC82CA7396A68D541C85D26508E83_1502388810;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_215893623 = varB4EAC82CA7396A68D541C85D26508E83_944734679;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_215893623.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_215893623;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.482 -0400", hash_original_method = "31FE8AD014B4F1DD5E50498C47C1658F", hash_generated_method = "2F2888856DC4934F648EE751E11FBFF9")
    public boolean equals(Object o) {
        SimpleBigDecimal other;
        other = (SimpleBigDecimal)o;
        boolean varC745D84BBE17D811EC67E8C08332650F_595526650 = (((bigInt.equals(other.bigInt)) && (scale == other.scale)));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1278384738 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1278384738;
        // ---------- Original Method ----------
        //if (this == o)
        //{
            //return true;
        //}
        //if (!(o instanceof SimpleBigDecimal))
        //{
            //return false;
        //}
        //SimpleBigDecimal other = (SimpleBigDecimal)o;
        //return ((bigInt.equals(other.bigInt)) && (scale == other.scale));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.483 -0400", hash_original_method = "32368AD05F7F4213F28C81C339A46A5C", hash_generated_method = "CD542C4A899E93E2D38BAB9327F44D01")
    public int hashCode() {
        int varE816141714050E118753147A0CD07B69_1815536280 = (bigInt.hashCode() ^ scale);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_276377510 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_276377510;
        // ---------- Original Method ----------
        //return bigInt.hashCode() ^ scale;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.483 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "027A87B98733155076ED3CAB6436C7AB")

    private static long serialVersionUID = 1L;
}

