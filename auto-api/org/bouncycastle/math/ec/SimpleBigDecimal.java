package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigInteger;

class SimpleBigDecimal {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.724 -0400", hash_original_field = "33A2DB2A239C5BAAA46376495EE5F6ED", hash_generated_field = "4CD174344F65D3883705CA71073A947D")

    private BigInteger bigInt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.724 -0400", hash_original_field = "0CB47AEB6E5F9323F0969E628C4E59F5", hash_generated_field = "F9D5D1CA2ABDD82810FF1FE80E0268E6")

    private int scale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.725 -0400", hash_original_method = "B9E3F8F2D1F0CB50E3B2E06390DB4E90", hash_generated_method = "0B6FE15653CE30B8304023B193D64CD2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.727 -0400", hash_original_method = "BB0449F02A6AA340B8F9AEE6846C1B89", hash_generated_method = "3D0C818EB173578CDB4338C6D8735F35")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.729 -0400", hash_original_method = "C3E845BC0594ECAC644A3338EF26C373", hash_generated_method = "DE27A50F662C560F06B8BDE247D46668")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.731 -0400", hash_original_method = "6E51DD7AA8BCA4EBA8ECDE4AADAA865C", hash_generated_method = "364C9EAB46E95D60FCF9CE26469D98FD")
    public SimpleBigDecimal adjustScale(int newScale) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_1456705735 = null; //Variable for return #1
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_907963554 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("scale may not be negative");
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1456705735 = new SimpleBigDecimal(this);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_907963554 = new SimpleBigDecimal(bigInt.shiftLeft(newScale - scale),
                newScale);
        addTaint(newScale);
        SimpleBigDecimal varA7E53CE21691AB073D9660D615818899_95083730; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_95083730 = varB4EAC82CA7396A68D541C85D26508E83_1456705735;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_95083730 = varB4EAC82CA7396A68D541C85D26508E83_907963554;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_95083730.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_95083730;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.731 -0400", hash_original_method = "9B93EEC174A0454ADCF32BC9274B05B6", hash_generated_method = "6EE0482B3F6BA9CF21085CE6C3591576")
    public SimpleBigDecimal add(SimpleBigDecimal b) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_1841545925 = null; //Variable for return #1
        checkScale(b);
        varB4EAC82CA7396A68D541C85D26508E83_1841545925 = new SimpleBigDecimal(bigInt.add(b.bigInt), scale);
        addTaint(b.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1841545925.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1841545925;
        // ---------- Original Method ----------
        //checkScale(b);
        //return new SimpleBigDecimal(bigInt.add(b.bigInt), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.732 -0400", hash_original_method = "1997D6C5826C900035276C18BCFDD9D3", hash_generated_method = "4FE59915DB96813352802A9811F4DCA2")
    public SimpleBigDecimal add(BigInteger b) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_784663724 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_784663724 = new SimpleBigDecimal(bigInt.add(b.shiftLeft(scale)), scale);
        addTaint(b.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_784663724.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_784663724;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.add(b.shiftLeft(scale)), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.732 -0400", hash_original_method = "847D70590D3897E07ED49ABD60DD0D05", hash_generated_method = "4EC9AE9C4F1D212ECB6702D3CF16D206")
    public SimpleBigDecimal negate() {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_424907189 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_424907189 = new SimpleBigDecimal(bigInt.negate(), scale);
        varB4EAC82CA7396A68D541C85D26508E83_424907189.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_424907189;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.negate(), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.733 -0400", hash_original_method = "E3DDD4A4133D81CA99A1E7F6CCD5CF2B", hash_generated_method = "50ECDA496455D332809F6C09EF342151")
    public SimpleBigDecimal subtract(SimpleBigDecimal b) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_1583962743 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1583962743 = add(b.negate());
        addTaint(b.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1583962743.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1583962743;
        // ---------- Original Method ----------
        //return add(b.negate());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.733 -0400", hash_original_method = "5502C0B2E51F8EC346A3B0EA2AFD7881", hash_generated_method = "6A9C74E6C084C27EAD7CD6FC8E15FEC7")
    public SimpleBigDecimal subtract(BigInteger b) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_686745911 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_686745911 = new SimpleBigDecimal(bigInt.subtract(b.shiftLeft(scale)),
                scale);
        addTaint(b.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_686745911.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_686745911;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.subtract(b.shiftLeft(scale)),
                //scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.734 -0400", hash_original_method = "330628D6579367C0F7404BA6336A3E07", hash_generated_method = "07BFF8CDFB02692D4B7CFB09BB7BC4DB")
    public SimpleBigDecimal multiply(SimpleBigDecimal b) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_1063330563 = null; //Variable for return #1
        checkScale(b);
        varB4EAC82CA7396A68D541C85D26508E83_1063330563 = new SimpleBigDecimal(bigInt.multiply(b.bigInt), scale + scale);
        addTaint(b.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1063330563.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1063330563;
        // ---------- Original Method ----------
        //checkScale(b);
        //return new SimpleBigDecimal(bigInt.multiply(b.bigInt), scale + scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.734 -0400", hash_original_method = "F7512EC811E7F46BF7093DEE1B5F6571", hash_generated_method = "118D9A626256BE031195484785B2466F")
    public SimpleBigDecimal multiply(BigInteger b) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_480498877 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_480498877 = new SimpleBigDecimal(bigInt.multiply(b), scale);
        addTaint(b.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_480498877.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_480498877;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.multiply(b), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.735 -0400", hash_original_method = "7E74D1BB6D8D1863DA2FA49A62271B48", hash_generated_method = "0F7798F8A4B9CDE10AD4E8B35B8641B1")
    public SimpleBigDecimal divide(SimpleBigDecimal b) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_2137462492 = null; //Variable for return #1
        checkScale(b);
        BigInteger dividend = bigInt.shiftLeft(scale);
        varB4EAC82CA7396A68D541C85D26508E83_2137462492 = new SimpleBigDecimal(dividend.divide(b.bigInt), scale);
        addTaint(b.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2137462492.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2137462492;
        // ---------- Original Method ----------
        //checkScale(b);
        //BigInteger dividend = bigInt.shiftLeft(scale);
        //return new SimpleBigDecimal(dividend.divide(b.bigInt), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.735 -0400", hash_original_method = "F0938440F96DC20B0D4303728A0BA40C", hash_generated_method = "3DAC577B33E84AF8128FA21314BD689B")
    public SimpleBigDecimal divide(BigInteger b) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_402023447 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_402023447 = new SimpleBigDecimal(bigInt.divide(b), scale);
        addTaint(b.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_402023447.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_402023447;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.divide(b), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.736 -0400", hash_original_method = "886004AC1E5A48AB6425DAAA9E6A9AE1", hash_generated_method = "2541A7087FD2446683CF176FDDBD4F6B")
    public SimpleBigDecimal shiftLeft(int n) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_1249251863 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1249251863 = new SimpleBigDecimal(bigInt.shiftLeft(n), scale);
        addTaint(n);
        varB4EAC82CA7396A68D541C85D26508E83_1249251863.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1249251863;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.shiftLeft(n), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.736 -0400", hash_original_method = "F4FD2CFD498531A1DCCD160DB4A55A56", hash_generated_method = "CB45F63E776B391FC128BCA1F7408C4E")
    public int compareTo(SimpleBigDecimal val) {
        checkScale(val);
        int var9716E05F1AAB957E38CF488CDF7A87FE_843032520 = (bigInt.compareTo(val.bigInt));
        addTaint(val.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2107023971 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2107023971;
        // ---------- Original Method ----------
        //checkScale(val);
        //return bigInt.compareTo(val.bigInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.736 -0400", hash_original_method = "DA142CFE02A0CE378556DA61E5DFFA33", hash_generated_method = "13C90E9CAF22579211B3EE61605D20C9")
    public int compareTo(BigInteger val) {
        int var82CAFFB47EB528AAC6F01817DCE93EF3_288883677 = (bigInt.compareTo(val.shiftLeft(scale)));
        addTaint(val.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1990741871 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1990741871;
        // ---------- Original Method ----------
        //return bigInt.compareTo(val.shiftLeft(scale));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.737 -0400", hash_original_method = "5A4C971F5322638C8E9F4B26460E4E92", hash_generated_method = "B37F08C6A8C03411A23998EB3C37CA3A")
    public BigInteger floor() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_431720891 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_431720891 = bigInt.shiftRight(scale);
        varB4EAC82CA7396A68D541C85D26508E83_431720891.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_431720891;
        // ---------- Original Method ----------
        //return bigInt.shiftRight(scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.738 -0400", hash_original_method = "92FC76983B02D95A30B18D6CBD3123C0", hash_generated_method = "5CCB6D1EF16D09455D430F6E3A5F5D07")
    public BigInteger round() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1079411969 = null; //Variable for return #1
        SimpleBigDecimal oneHalf = new SimpleBigDecimal(ECConstants.ONE, 1);
        varB4EAC82CA7396A68D541C85D26508E83_1079411969 = add(oneHalf.adjustScale(scale)).floor();
        varB4EAC82CA7396A68D541C85D26508E83_1079411969.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1079411969;
        // ---------- Original Method ----------
        //SimpleBigDecimal oneHalf = new SimpleBigDecimal(ECConstants.ONE, 1);
        //return add(oneHalf.adjustScale(scale)).floor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.738 -0400", hash_original_method = "8F98A91102E8EBECCDC59FAE2090EE26", hash_generated_method = "8C8ABBC21885A026F28ADBE331856E57")
    public int intValue() {
        int var6670763D4ED36247FD6BBDE7591A2BEB_44274384 = (floor().intValue());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_159146329 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_159146329;
        // ---------- Original Method ----------
        //return floor().intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.739 -0400", hash_original_method = "AA9F4F5827911FF9AD2916733B5D4AF6", hash_generated_method = "FB4054AE40B7C1BCA30A8E5A40BF2097")
    public long longValue() {
        long var0F89E31FA1433C1CBAE17116C0BCC786_1869817368 = (floor().longValue());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1850284540 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1850284540;
        // ---------- Original Method ----------
        //return floor().longValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.739 -0400", hash_original_method = "555259738C76709D8C0A4CEB0BA4F05B", hash_generated_method = "A2B67806E201C15AD8FAA25B51E8DE98")
    public int getScale() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1002872957 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1002872957;
        // ---------- Original Method ----------
        //return scale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.741 -0400", hash_original_method = "687FE1E6404530E144AF0CBE5E24BCFF", hash_generated_method = "582F45475B5C9DB28A0097BF8F18F1E7")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_208959228 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1576406547 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_208959228 = bigInt.toString();
        } //End block
        BigInteger floorBigInt = floor();
        BigInteger fract = bigInt.subtract(floorBigInt.shiftLeft(scale));
        {
            boolean varED0BFE98954101C6F44F91A570BA4A80_1117298433 = (bigInt.signum() == -1);
            {
                fract = ECConstants.ONE.shiftLeft(scale).subtract(fract);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var5265F348731546FA9139EF5056083087_550901184 = ((floorBigInt.signum() == -1) && (!(fract.equals(ECConstants.ZERO))));
            {
                floorBigInt = floorBigInt.add(ECConstants.ONE);
            } //End block
        } //End collapsed parenthetic
        String leftOfPoint = floorBigInt.toString();
        char[] fractCharArr = new char[scale];
        String fractStr = fract.toString(2);
        int fractLen = fractStr.length();
        int zeroes = scale - fractLen;
        {
            int i = 0;
            {
                fractCharArr[i] = '0';
            } //End block
        } //End collapsed parenthetic
        {
            int j = 0;
            {
                fractCharArr[zeroes + j] = fractStr.charAt(j);
            } //End block
        } //End collapsed parenthetic
        String rightOfPoint = new String(fractCharArr);
        StringBuffer sb = new StringBuffer(leftOfPoint);
        sb.append(".");
        sb.append(rightOfPoint);
        varB4EAC82CA7396A68D541C85D26508E83_1576406547 = sb.toString();
        String varA7E53CE21691AB073D9660D615818899_1025453294; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1025453294 = varB4EAC82CA7396A68D541C85D26508E83_208959228;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1025453294 = varB4EAC82CA7396A68D541C85D26508E83_1576406547;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1025453294.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1025453294;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.741 -0400", hash_original_method = "31FE8AD014B4F1DD5E50498C47C1658F", hash_generated_method = "19FEF32207E0717CD70EB59DD726C27C")
    public boolean equals(Object o) {
        SimpleBigDecimal other = (SimpleBigDecimal)o;
        boolean varC745D84BBE17D811EC67E8C08332650F_1099376583 = (((bigInt.equals(other.bigInt)) && (scale == other.scale)));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1796761340 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1796761340;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.742 -0400", hash_original_method = "32368AD05F7F4213F28C81C339A46A5C", hash_generated_method = "B6917B0B5C217F6396F15D65DE289C0A")
    public int hashCode() {
        int varE816141714050E118753147A0CD07B69_2092021381 = (bigInt.hashCode() ^ scale);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1228586619 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1228586619;
        // ---------- Original Method ----------
        //return bigInt.hashCode() ^ scale;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.742 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

    private static final long serialVersionUID = 1L;
}

