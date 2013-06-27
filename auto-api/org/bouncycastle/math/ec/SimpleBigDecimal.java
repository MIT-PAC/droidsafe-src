package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigInteger;

class SimpleBigDecimal {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.341 -0400", hash_original_field = "33A2DB2A239C5BAAA46376495EE5F6ED", hash_generated_field = "4CD174344F65D3883705CA71073A947D")

    private BigInteger bigInt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.341 -0400", hash_original_field = "0CB47AEB6E5F9323F0969E628C4E59F5", hash_generated_field = "F9D5D1CA2ABDD82810FF1FE80E0268E6")

    private int scale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.354 -0400", hash_original_method = "B9E3F8F2D1F0CB50E3B2E06390DB4E90", hash_generated_method = "0B6FE15653CE30B8304023B193D64CD2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.355 -0400", hash_original_method = "BB0449F02A6AA340B8F9AEE6846C1B89", hash_generated_method = "3D0C818EB173578CDB4338C6D8735F35")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.355 -0400", hash_original_method = "C3E845BC0594ECAC644A3338EF26C373", hash_generated_method = "DE27A50F662C560F06B8BDE247D46668")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.357 -0400", hash_original_method = "6E51DD7AA8BCA4EBA8ECDE4AADAA865C", hash_generated_method = "DE69AC0820021FB7E6DEE487A2BAC3D6")
    public SimpleBigDecimal adjustScale(int newScale) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_1023904678 = null; //Variable for return #1
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_1266295216 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("scale may not be negative");
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1023904678 = new SimpleBigDecimal(this);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1266295216 = new SimpleBigDecimal(bigInt.shiftLeft(newScale - scale),
                newScale);
        addTaint(newScale);
        SimpleBigDecimal varA7E53CE21691AB073D9660D615818899_1455422586; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1455422586 = varB4EAC82CA7396A68D541C85D26508E83_1023904678;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1455422586 = varB4EAC82CA7396A68D541C85D26508E83_1266295216;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1455422586.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1455422586;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.357 -0400", hash_original_method = "9B93EEC174A0454ADCF32BC9274B05B6", hash_generated_method = "74AEA1681A07A0A4AA7F229754DDAAC2")
    public SimpleBigDecimal add(SimpleBigDecimal b) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_1545175519 = null; //Variable for return #1
        checkScale(b);
        varB4EAC82CA7396A68D541C85D26508E83_1545175519 = new SimpleBigDecimal(bigInt.add(b.bigInt), scale);
        addTaint(b.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1545175519.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1545175519;
        // ---------- Original Method ----------
        //checkScale(b);
        //return new SimpleBigDecimal(bigInt.add(b.bigInt), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.358 -0400", hash_original_method = "1997D6C5826C900035276C18BCFDD9D3", hash_generated_method = "7E44D978BF17C93498C6AD21E6BE0069")
    public SimpleBigDecimal add(BigInteger b) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_733622583 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_733622583 = new SimpleBigDecimal(bigInt.add(b.shiftLeft(scale)), scale);
        addTaint(b.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_733622583.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_733622583;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.add(b.shiftLeft(scale)), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.358 -0400", hash_original_method = "847D70590D3897E07ED49ABD60DD0D05", hash_generated_method = "C527D3E9B056C609014CC94BAEE7B7E0")
    public SimpleBigDecimal negate() {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_1298115772 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1298115772 = new SimpleBigDecimal(bigInt.negate(), scale);
        varB4EAC82CA7396A68D541C85D26508E83_1298115772.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1298115772;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.negate(), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.366 -0400", hash_original_method = "E3DDD4A4133D81CA99A1E7F6CCD5CF2B", hash_generated_method = "FEE4A4217850E62364EF5986D7334062")
    public SimpleBigDecimal subtract(SimpleBigDecimal b) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_1203862291 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1203862291 = add(b.negate());
        addTaint(b.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1203862291.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1203862291;
        // ---------- Original Method ----------
        //return add(b.negate());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.371 -0400", hash_original_method = "5502C0B2E51F8EC346A3B0EA2AFD7881", hash_generated_method = "5B7CBAE7B02AE927D3288EF641161102")
    public SimpleBigDecimal subtract(BigInteger b) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_2014468923 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2014468923 = new SimpleBigDecimal(bigInt.subtract(b.shiftLeft(scale)),
                scale);
        addTaint(b.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2014468923.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2014468923;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.subtract(b.shiftLeft(scale)),
                //scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.372 -0400", hash_original_method = "330628D6579367C0F7404BA6336A3E07", hash_generated_method = "4393E3D7BC626AD104BDE2825864C5A7")
    public SimpleBigDecimal multiply(SimpleBigDecimal b) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_959356031 = null; //Variable for return #1
        checkScale(b);
        varB4EAC82CA7396A68D541C85D26508E83_959356031 = new SimpleBigDecimal(bigInt.multiply(b.bigInt), scale + scale);
        addTaint(b.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_959356031.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_959356031;
        // ---------- Original Method ----------
        //checkScale(b);
        //return new SimpleBigDecimal(bigInt.multiply(b.bigInt), scale + scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.373 -0400", hash_original_method = "F7512EC811E7F46BF7093DEE1B5F6571", hash_generated_method = "AE2241B901EC815F39B23AF20AFAF16F")
    public SimpleBigDecimal multiply(BigInteger b) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_951911224 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_951911224 = new SimpleBigDecimal(bigInt.multiply(b), scale);
        addTaint(b.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_951911224.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_951911224;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.multiply(b), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.373 -0400", hash_original_method = "7E74D1BB6D8D1863DA2FA49A62271B48", hash_generated_method = "EDED3557B54E6CCCD46E38129EF6500F")
    public SimpleBigDecimal divide(SimpleBigDecimal b) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_1177415618 = null; //Variable for return #1
        checkScale(b);
        BigInteger dividend;
        dividend = bigInt.shiftLeft(scale);
        varB4EAC82CA7396A68D541C85D26508E83_1177415618 = new SimpleBigDecimal(dividend.divide(b.bigInt), scale);
        addTaint(b.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1177415618.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1177415618;
        // ---------- Original Method ----------
        //checkScale(b);
        //BigInteger dividend = bigInt.shiftLeft(scale);
        //return new SimpleBigDecimal(dividend.divide(b.bigInt), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.386 -0400", hash_original_method = "F0938440F96DC20B0D4303728A0BA40C", hash_generated_method = "8822FFF96720A72BBEDF17EBA453859E")
    public SimpleBigDecimal divide(BigInteger b) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_1248826120 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1248826120 = new SimpleBigDecimal(bigInt.divide(b), scale);
        addTaint(b.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1248826120.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1248826120;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.divide(b), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.386 -0400", hash_original_method = "886004AC1E5A48AB6425DAAA9E6A9AE1", hash_generated_method = "F22F81CCD76587107A7A715B9FBA72B1")
    public SimpleBigDecimal shiftLeft(int n) {
        SimpleBigDecimal varB4EAC82CA7396A68D541C85D26508E83_562778112 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_562778112 = new SimpleBigDecimal(bigInt.shiftLeft(n), scale);
        addTaint(n);
        varB4EAC82CA7396A68D541C85D26508E83_562778112.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_562778112;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.shiftLeft(n), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.386 -0400", hash_original_method = "F4FD2CFD498531A1DCCD160DB4A55A56", hash_generated_method = "B6EFF2B1186235DDFC4C54D32F937DAD")
    public int compareTo(SimpleBigDecimal val) {
        checkScale(val);
        int var9716E05F1AAB957E38CF488CDF7A87FE_254857393 = (bigInt.compareTo(val.bigInt));
        addTaint(val.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2128003309 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2128003309;
        // ---------- Original Method ----------
        //checkScale(val);
        //return bigInt.compareTo(val.bigInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.387 -0400", hash_original_method = "DA142CFE02A0CE378556DA61E5DFFA33", hash_generated_method = "A9E3F8F6D024723B8C415EC45EA1E81E")
    public int compareTo(BigInteger val) {
        int var82CAFFB47EB528AAC6F01817DCE93EF3_2041273990 = (bigInt.compareTo(val.shiftLeft(scale)));
        addTaint(val.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1676539834 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1676539834;
        // ---------- Original Method ----------
        //return bigInt.compareTo(val.shiftLeft(scale));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.388 -0400", hash_original_method = "5A4C971F5322638C8E9F4B26460E4E92", hash_generated_method = "A31524F9BC9A9D83B981A9FA9A33B412")
    public BigInteger floor() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1943052042 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1943052042 = bigInt.shiftRight(scale);
        varB4EAC82CA7396A68D541C85D26508E83_1943052042.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1943052042;
        // ---------- Original Method ----------
        //return bigInt.shiftRight(scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.405 -0400", hash_original_method = "92FC76983B02D95A30B18D6CBD3123C0", hash_generated_method = "55F465F0F8704322D21830186605EA5B")
    public BigInteger round() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_210756262 = null; //Variable for return #1
        SimpleBigDecimal oneHalf;
        oneHalf = new SimpleBigDecimal(ECConstants.ONE, 1);
        varB4EAC82CA7396A68D541C85D26508E83_210756262 = add(oneHalf.adjustScale(scale)).floor();
        varB4EAC82CA7396A68D541C85D26508E83_210756262.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_210756262;
        // ---------- Original Method ----------
        //SimpleBigDecimal oneHalf = new SimpleBigDecimal(ECConstants.ONE, 1);
        //return add(oneHalf.adjustScale(scale)).floor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.405 -0400", hash_original_method = "8F98A91102E8EBECCDC59FAE2090EE26", hash_generated_method = "25CB3868D149DEFD9BC58C1D5E002861")
    public int intValue() {
        int var6670763D4ED36247FD6BBDE7591A2BEB_1032833169 = (floor().intValue());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_440855336 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_440855336;
        // ---------- Original Method ----------
        //return floor().intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.405 -0400", hash_original_method = "AA9F4F5827911FF9AD2916733B5D4AF6", hash_generated_method = "67B18136963F18117381BD2E88D4F0A3")
    public long longValue() {
        long var0F89E31FA1433C1CBAE17116C0BCC786_1324420890 = (floor().longValue());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_525777180 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_525777180;
        // ---------- Original Method ----------
        //return floor().longValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.405 -0400", hash_original_method = "555259738C76709D8C0A4CEB0BA4F05B", hash_generated_method = "18B8993949A91C882E6DD5621718AD54")
    public int getScale() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1152319025 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1152319025;
        // ---------- Original Method ----------
        //return scale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.407 -0400", hash_original_method = "687FE1E6404530E144AF0CBE5E24BCFF", hash_generated_method = "D20964086473CD25C85CCBDF1225E71E")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1730952704 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_158665892 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1730952704 = bigInt.toString();
        } //End block
        BigInteger floorBigInt;
        floorBigInt = floor();
        BigInteger fract;
        fract = bigInt.subtract(floorBigInt.shiftLeft(scale));
        {
            boolean varED0BFE98954101C6F44F91A570BA4A80_1846275615 = (bigInt.signum() == -1);
            {
                fract = ECConstants.ONE.shiftLeft(scale).subtract(fract);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var5265F348731546FA9139EF5056083087_2033162267 = ((floorBigInt.signum() == -1) && (!(fract.equals(ECConstants.ZERO))));
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
        varB4EAC82CA7396A68D541C85D26508E83_158665892 = sb.toString();
        String varA7E53CE21691AB073D9660D615818899_908154107; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_908154107 = varB4EAC82CA7396A68D541C85D26508E83_1730952704;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_908154107 = varB4EAC82CA7396A68D541C85D26508E83_158665892;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_908154107.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_908154107;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.407 -0400", hash_original_method = "31FE8AD014B4F1DD5E50498C47C1658F", hash_generated_method = "6A2B06D675E8FD60EAE8BBE02FB70FFE")
    public boolean equals(Object o) {
        SimpleBigDecimal other;
        other = (SimpleBigDecimal)o;
        boolean varC745D84BBE17D811EC67E8C08332650F_2112621008 = (((bigInt.equals(other.bigInt)) && (scale == other.scale)));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2102857216 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2102857216;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.407 -0400", hash_original_method = "32368AD05F7F4213F28C81C339A46A5C", hash_generated_method = "70E740551B0E8414201A8189845BA855")
    public int hashCode() {
        int varE816141714050E118753147A0CD07B69_1983320513 = (bigInt.hashCode() ^ scale);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_407565019 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_407565019;
        // ---------- Original Method ----------
        //return bigInt.hashCode() ^ scale;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.408 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "027A87B98733155076ED3CAB6436C7AB")

    private static long serialVersionUID = 1L;
}

