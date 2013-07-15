package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;

class SimpleBigDecimal {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.348 -0400", hash_original_field = "33A2DB2A239C5BAAA46376495EE5F6ED", hash_generated_field = "4CD174344F65D3883705CA71073A947D")

    private BigInteger bigInt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.348 -0400", hash_original_field = "0CB47AEB6E5F9323F0969E628C4E59F5", hash_generated_field = "F9D5D1CA2ABDD82810FF1FE80E0268E6")

    private int scale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.348 -0400", hash_original_method = "B9E3F8F2D1F0CB50E3B2E06390DB4E90", hash_generated_method = "3D5035428277B6BB4E3007C13F833125")
    public  SimpleBigDecimal(BigInteger bigInt, int scale) {
    if(scale < 0)        
        {
            IllegalArgumentException var58D735494520BA27765FD12526D578A6_1157073269 = new IllegalArgumentException("scale may not be negative");
            var58D735494520BA27765FD12526D578A6_1157073269.addTaint(taint);
            throw var58D735494520BA27765FD12526D578A6_1157073269;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.349 -0400", hash_original_method = "BB0449F02A6AA340B8F9AEE6846C1B89", hash_generated_method = "3D0C818EB173578CDB4338C6D8735F35")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.350 -0400", hash_original_method = "C3E845BC0594ECAC644A3338EF26C373", hash_generated_method = "D26FF5CCC4C203172ABD6473EAA93A16")
    private void checkScale(SimpleBigDecimal b) {
        addTaint(b.getTaint());
    if(scale != b.scale)        
        {
            IllegalArgumentException varBF1E8E999FA33EDA489EBECEEE1B2B34_201206656 = new IllegalArgumentException("Only SimpleBigDecimal of " +
                "same scale allowed in arithmetic operations");
            varBF1E8E999FA33EDA489EBECEEE1B2B34_201206656.addTaint(taint);
            throw varBF1E8E999FA33EDA489EBECEEE1B2B34_201206656;
        } //End block
        // ---------- Original Method ----------
        //if (scale != b.scale)
        //{
            //throw new IllegalArgumentException("Only SimpleBigDecimal of " +
                //"same scale allowed in arithmetic operations");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.350 -0400", hash_original_method = "6E51DD7AA8BCA4EBA8ECDE4AADAA865C", hash_generated_method = "8137821E020557059C0B9D5328506FE6")
    public SimpleBigDecimal adjustScale(int newScale) {
        addTaint(newScale);
    if(newScale < 0)        
        {
            IllegalArgumentException var58D735494520BA27765FD12526D578A6_660423740 = new IllegalArgumentException("scale may not be negative");
            var58D735494520BA27765FD12526D578A6_660423740.addTaint(taint);
            throw var58D735494520BA27765FD12526D578A6_660423740;
        } //End block
    if(newScale == scale)        
        {
SimpleBigDecimal varC443E2FDD95F17BA27D97541FEDE810E_1079280353 =             new SimpleBigDecimal(this);
            varC443E2FDD95F17BA27D97541FEDE810E_1079280353.addTaint(taint);
            return varC443E2FDD95F17BA27D97541FEDE810E_1079280353;
        } //End block
SimpleBigDecimal var1D54614E725394C5DC4A6BDA871FE719_1567731247 =         new SimpleBigDecimal(bigInt.shiftLeft(newScale - scale),
                newScale);
        var1D54614E725394C5DC4A6BDA871FE719_1567731247.addTaint(taint);
        return var1D54614E725394C5DC4A6BDA871FE719_1567731247;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.350 -0400", hash_original_method = "9B93EEC174A0454ADCF32BC9274B05B6", hash_generated_method = "A108633DD861758656EA844D1913557B")
    public SimpleBigDecimal add(SimpleBigDecimal b) {
        addTaint(b.getTaint());
        checkScale(b);
SimpleBigDecimal varBC873B48BA5F854280762166BC36B2E6_521034983 =         new SimpleBigDecimal(bigInt.add(b.bigInt), scale);
        varBC873B48BA5F854280762166BC36B2E6_521034983.addTaint(taint);
        return varBC873B48BA5F854280762166BC36B2E6_521034983;
        // ---------- Original Method ----------
        //checkScale(b);
        //return new SimpleBigDecimal(bigInt.add(b.bigInt), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.351 -0400", hash_original_method = "1997D6C5826C900035276C18BCFDD9D3", hash_generated_method = "2371C34DA288F470C05CC6DD8F2F58D0")
    public SimpleBigDecimal add(BigInteger b) {
        addTaint(b.getTaint());
SimpleBigDecimal varA31368F8A8B819729583F82F3E09CF4F_1732324433 =         new SimpleBigDecimal(bigInt.add(b.shiftLeft(scale)), scale);
        varA31368F8A8B819729583F82F3E09CF4F_1732324433.addTaint(taint);
        return varA31368F8A8B819729583F82F3E09CF4F_1732324433;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.add(b.shiftLeft(scale)), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.351 -0400", hash_original_method = "847D70590D3897E07ED49ABD60DD0D05", hash_generated_method = "FBF5DF6536C09EA110569805FCE522D7")
    public SimpleBigDecimal negate() {
SimpleBigDecimal varEED3C5BAE20C6BD213BDF57CA9FED0D9_1870069025 =         new SimpleBigDecimal(bigInt.negate(), scale);
        varEED3C5BAE20C6BD213BDF57CA9FED0D9_1870069025.addTaint(taint);
        return varEED3C5BAE20C6BD213BDF57CA9FED0D9_1870069025;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.negate(), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.351 -0400", hash_original_method = "E3DDD4A4133D81CA99A1E7F6CCD5CF2B", hash_generated_method = "0EAD22302A65009A2EA48C82763AC585")
    public SimpleBigDecimal subtract(SimpleBigDecimal b) {
        addTaint(b.getTaint());
SimpleBigDecimal var32038E816FAB690831584DAC6FED51A3_563825041 =         add(b.negate());
        var32038E816FAB690831584DAC6FED51A3_563825041.addTaint(taint);
        return var32038E816FAB690831584DAC6FED51A3_563825041;
        // ---------- Original Method ----------
        //return add(b.negate());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.351 -0400", hash_original_method = "5502C0B2E51F8EC346A3B0EA2AFD7881", hash_generated_method = "2C5B8831C002AD3D80F43721EB8A92BB")
    public SimpleBigDecimal subtract(BigInteger b) {
        addTaint(b.getTaint());
SimpleBigDecimal var708256F44F870458C1B9173583B404CC_220957666 =         new SimpleBigDecimal(bigInt.subtract(b.shiftLeft(scale)),
                scale);
        var708256F44F870458C1B9173583B404CC_220957666.addTaint(taint);
        return var708256F44F870458C1B9173583B404CC_220957666;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.subtract(b.shiftLeft(scale)),
                //scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.351 -0400", hash_original_method = "330628D6579367C0F7404BA6336A3E07", hash_generated_method = "591250E335CE982AEEB5DB641D0F7D0D")
    public SimpleBigDecimal multiply(SimpleBigDecimal b) {
        addTaint(b.getTaint());
        checkScale(b);
SimpleBigDecimal varEB970EDBBB7718B30C3A81F4568A545F_1533617917 =         new SimpleBigDecimal(bigInt.multiply(b.bigInt), scale + scale);
        varEB970EDBBB7718B30C3A81F4568A545F_1533617917.addTaint(taint);
        return varEB970EDBBB7718B30C3A81F4568A545F_1533617917;
        // ---------- Original Method ----------
        //checkScale(b);
        //return new SimpleBigDecimal(bigInt.multiply(b.bigInt), scale + scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.352 -0400", hash_original_method = "F7512EC811E7F46BF7093DEE1B5F6571", hash_generated_method = "360D3AF9F4D8490A20E052960765A9AE")
    public SimpleBigDecimal multiply(BigInteger b) {
        addTaint(b.getTaint());
SimpleBigDecimal varC8F4D9931E1A3F11C6EA04ED3A60723C_1152117674 =         new SimpleBigDecimal(bigInt.multiply(b), scale);
        varC8F4D9931E1A3F11C6EA04ED3A60723C_1152117674.addTaint(taint);
        return varC8F4D9931E1A3F11C6EA04ED3A60723C_1152117674;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.multiply(b), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.352 -0400", hash_original_method = "7E74D1BB6D8D1863DA2FA49A62271B48", hash_generated_method = "DF81B01FE4C332CBFBAF8C555D85F7C6")
    public SimpleBigDecimal divide(SimpleBigDecimal b) {
        addTaint(b.getTaint());
        checkScale(b);
        BigInteger dividend = bigInt.shiftLeft(scale);
SimpleBigDecimal varF9FDF50A6BD8DB22F717F98EAA4C220D_2077342841 =         new SimpleBigDecimal(dividend.divide(b.bigInt), scale);
        varF9FDF50A6BD8DB22F717F98EAA4C220D_2077342841.addTaint(taint);
        return varF9FDF50A6BD8DB22F717F98EAA4C220D_2077342841;
        // ---------- Original Method ----------
        //checkScale(b);
        //BigInteger dividend = bigInt.shiftLeft(scale);
        //return new SimpleBigDecimal(dividend.divide(b.bigInt), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.352 -0400", hash_original_method = "F0938440F96DC20B0D4303728A0BA40C", hash_generated_method = "873FEE51AD297F8D260EE4D8582E4342")
    public SimpleBigDecimal divide(BigInteger b) {
        addTaint(b.getTaint());
SimpleBigDecimal varE19CF6B9C2F6CFF15898E9D41C92A96A_943409800 =         new SimpleBigDecimal(bigInt.divide(b), scale);
        varE19CF6B9C2F6CFF15898E9D41C92A96A_943409800.addTaint(taint);
        return varE19CF6B9C2F6CFF15898E9D41C92A96A_943409800;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.divide(b), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.352 -0400", hash_original_method = "886004AC1E5A48AB6425DAAA9E6A9AE1", hash_generated_method = "EF3B3A200E5EB101095BDD91162BF1E5")
    public SimpleBigDecimal shiftLeft(int n) {
        addTaint(n);
SimpleBigDecimal varC8A0EFC90D5FF6476306E34DA9FDBC84_642223230 =         new SimpleBigDecimal(bigInt.shiftLeft(n), scale);
        varC8A0EFC90D5FF6476306E34DA9FDBC84_642223230.addTaint(taint);
        return varC8A0EFC90D5FF6476306E34DA9FDBC84_642223230;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.shiftLeft(n), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.352 -0400", hash_original_method = "F4FD2CFD498531A1DCCD160DB4A55A56", hash_generated_method = "71365EF82E6E355B9748E77A3746286A")
    public int compareTo(SimpleBigDecimal val) {
        addTaint(val.getTaint());
        checkScale(val);
        int var7DFBD8C88DA41B760E951F1CA94EA26B_343424214 = (bigInt.compareTo(val.bigInt));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1081251764 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1081251764;
        // ---------- Original Method ----------
        //checkScale(val);
        //return bigInt.compareTo(val.bigInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.353 -0400", hash_original_method = "DA142CFE02A0CE378556DA61E5DFFA33", hash_generated_method = "9F233252B7D70B902F61A2855B1696DD")
    public int compareTo(BigInteger val) {
        addTaint(val.getTaint());
        int varEED84E9BC36E2AD84F3D633E6A97270C_1527159064 = (bigInt.compareTo(val.shiftLeft(scale)));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_541998059 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_541998059;
        // ---------- Original Method ----------
        //return bigInt.compareTo(val.shiftLeft(scale));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.353 -0400", hash_original_method = "5A4C971F5322638C8E9F4B26460E4E92", hash_generated_method = "279543CAE8B8024FDD0A5BE350E9F3C3")
    public BigInteger floor() {
BigInteger varC3DA19D8A5CFC927635B2DFC55335EE8_1799713632 =         bigInt.shiftRight(scale);
        varC3DA19D8A5CFC927635B2DFC55335EE8_1799713632.addTaint(taint);
        return varC3DA19D8A5CFC927635B2DFC55335EE8_1799713632;
        // ---------- Original Method ----------
        //return bigInt.shiftRight(scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.353 -0400", hash_original_method = "92FC76983B02D95A30B18D6CBD3123C0", hash_generated_method = "8545A633959AF6A93B92CC66AE75D05C")
    public BigInteger round() {
        SimpleBigDecimal oneHalf = new SimpleBigDecimal(ECConstants.ONE, 1);
BigInteger var4174CC434CBDE7DB724D4E7CC73D7929_308616573 =         add(oneHalf.adjustScale(scale)).floor();
        var4174CC434CBDE7DB724D4E7CC73D7929_308616573.addTaint(taint);
        return var4174CC434CBDE7DB724D4E7CC73D7929_308616573;
        // ---------- Original Method ----------
        //SimpleBigDecimal oneHalf = new SimpleBigDecimal(ECConstants.ONE, 1);
        //return add(oneHalf.adjustScale(scale)).floor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.353 -0400", hash_original_method = "8F98A91102E8EBECCDC59FAE2090EE26", hash_generated_method = "6F79428BE19ECB73F3B9E1BFBCC624AC")
    public int intValue() {
        int var6436157326F3A27A72136918BE8B74EF_2010795197 = (floor().intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_608551634 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_608551634;
        // ---------- Original Method ----------
        //return floor().intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.353 -0400", hash_original_method = "AA9F4F5827911FF9AD2916733B5D4AF6", hash_generated_method = "F751F1101754EA91955A8A4CE7C0A028")
    public long longValue() {
        long varCF8562293A42CEC110CF39E17AE4DEC3_1015308556 = (floor().longValue());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1194494820 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1194494820;
        // ---------- Original Method ----------
        //return floor().longValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.353 -0400", hash_original_method = "555259738C76709D8C0A4CEB0BA4F05B", hash_generated_method = "666DA5E438C798CDE7C654C63E9CD21E")
    public int getScale() {
        int var0CB47AEB6E5F9323F0969E628C4E59F5_1272456854 = (scale);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1264291047 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1264291047;
        // ---------- Original Method ----------
        //return scale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.354 -0400", hash_original_method = "687FE1E6404530E144AF0CBE5E24BCFF", hash_generated_method = "D2BA6776AFF95928CF05AFB733AD40F5")
    public String toString() {
    if(scale == 0)        
        {
String varD162A010942E77D36E1D2EBFEB251561_1544793613 =             bigInt.toString();
            varD162A010942E77D36E1D2EBFEB251561_1544793613.addTaint(taint);
            return varD162A010942E77D36E1D2EBFEB251561_1544793613;
        } //End block
        BigInteger floorBigInt = floor();
        BigInteger fract = bigInt.subtract(floorBigInt.shiftLeft(scale));
    if(bigInt.signum() == -1)        
        {
            fract = ECConstants.ONE.shiftLeft(scale).subtract(fract);
        } //End block
    if((floorBigInt.signum() == -1) && (!(fract.equals(ECConstants.ZERO))))        
        {
            floorBigInt = floorBigInt.add(ECConstants.ONE);
        } //End block
        String leftOfPoint = floorBigInt.toString();
        char[] fractCharArr = new char[scale];
        String fractStr = fract.toString(2);
        int fractLen = fractStr.length();
        int zeroes = scale - fractLen;
for(int i = 0;i < zeroes;i++)
        {
            fractCharArr[i] = '0';
        } //End block
for(int j = 0;j < fractLen;j++)
        {
            fractCharArr[zeroes + j] = fractStr.charAt(j);
        } //End block
        String rightOfPoint = new String(fractCharArr);
        StringBuffer sb = new StringBuffer(leftOfPoint);
        sb.append(".");
        sb.append(rightOfPoint);
String var2460B846747F8B22185AD8BE722266A5_1978180744 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_1978180744.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_1978180744;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.355 -0400", hash_original_method = "31FE8AD014B4F1DD5E50498C47C1658F", hash_generated_method = "C29570936D3867B162AAB86E73BEF846")
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(this == o)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1096111181 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_851215723 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_851215723;
        } //End block
    if(!(o instanceof SimpleBigDecimal))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1698982558 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1480631201 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1480631201;
        } //End block
        SimpleBigDecimal other = (SimpleBigDecimal)o;
        boolean varAB5C50053DE1F138DD7CAC0F39FD4335_59092031 = (((bigInt.equals(other.bigInt)) && (scale == other.scale)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1762109333 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1762109333;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.355 -0400", hash_original_method = "32368AD05F7F4213F28C81C339A46A5C", hash_generated_method = "512C270B57362D8C07262F034D648D6E")
    public int hashCode() {
        int var43CD7DFA1F2F6D87A7D7C4C3BE2185AE_1023100975 = (bigInt.hashCode() ^ scale);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_590130595 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_590130595;
        // ---------- Original Method ----------
        //return bigInt.hashCode() ^ scale;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.355 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

    private static final long serialVersionUID = 1L;
}

