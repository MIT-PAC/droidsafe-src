package org.bouncycastle.math.ec;

// Droidsafe Imports
import java.math.BigInteger;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

class SimpleBigDecimal {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.754 -0400", hash_original_field = "33A2DB2A239C5BAAA46376495EE5F6ED", hash_generated_field = "4CD174344F65D3883705CA71073A947D")

    private BigInteger bigInt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.754 -0400", hash_original_field = "0CB47AEB6E5F9323F0969E628C4E59F5", hash_generated_field = "F9D5D1CA2ABDD82810FF1FE80E0268E6")

    private int scale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.756 -0400", hash_original_method = "B9E3F8F2D1F0CB50E3B2E06390DB4E90", hash_generated_method = "506E28452973EFD977E32014FB60F11D")
    public  SimpleBigDecimal(BigInteger bigInt, int scale) {
        if(scale < 0)        
        {
            IllegalArgumentException var58D735494520BA27765FD12526D578A6_1247420638 = new IllegalArgumentException("scale may not be negative");
            var58D735494520BA27765FD12526D578A6_1247420638.addTaint(taint);
            throw var58D735494520BA27765FD12526D578A6_1247420638;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.756 -0400", hash_original_method = "BB0449F02A6AA340B8F9AEE6846C1B89", hash_generated_method = "3D0C818EB173578CDB4338C6D8735F35")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.757 -0400", hash_original_method = "C3E845BC0594ECAC644A3338EF26C373", hash_generated_method = "180A2EF7772396F96E75B4E7F3701CCA")
    private void checkScale(SimpleBigDecimal b) {
        addTaint(b.getTaint());
        if(scale != b.scale)        
        {
            IllegalArgumentException varBF1E8E999FA33EDA489EBECEEE1B2B34_310278880 = new IllegalArgumentException("Only SimpleBigDecimal of " +
                "same scale allowed in arithmetic operations");
            varBF1E8E999FA33EDA489EBECEEE1B2B34_310278880.addTaint(taint);
            throw varBF1E8E999FA33EDA489EBECEEE1B2B34_310278880;
        } //End block
        // ---------- Original Method ----------
        //if (scale != b.scale)
        //{
            //throw new IllegalArgumentException("Only SimpleBigDecimal of " +
                //"same scale allowed in arithmetic operations");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.758 -0400", hash_original_method = "6E51DD7AA8BCA4EBA8ECDE4AADAA865C", hash_generated_method = "3668992B2BE3849D664182570C88FD74")
    public SimpleBigDecimal adjustScale(int newScale) {
        addTaint(newScale);
        if(newScale < 0)        
        {
            IllegalArgumentException var58D735494520BA27765FD12526D578A6_975906199 = new IllegalArgumentException("scale may not be negative");
            var58D735494520BA27765FD12526D578A6_975906199.addTaint(taint);
            throw var58D735494520BA27765FD12526D578A6_975906199;
        } //End block
        if(newScale == scale)        
        {
SimpleBigDecimal varC443E2FDD95F17BA27D97541FEDE810E_1463557765 =             new SimpleBigDecimal(this);
            varC443E2FDD95F17BA27D97541FEDE810E_1463557765.addTaint(taint);
            return varC443E2FDD95F17BA27D97541FEDE810E_1463557765;
        } //End block
SimpleBigDecimal var1D54614E725394C5DC4A6BDA871FE719_1029173676 =         new SimpleBigDecimal(bigInt.shiftLeft(newScale - scale),
                newScale);
        var1D54614E725394C5DC4A6BDA871FE719_1029173676.addTaint(taint);
        return var1D54614E725394C5DC4A6BDA871FE719_1029173676;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.758 -0400", hash_original_method = "9B93EEC174A0454ADCF32BC9274B05B6", hash_generated_method = "07A4EE215475AD00861A2FE71CBEAC2C")
    public SimpleBigDecimal add(SimpleBigDecimal b) {
        addTaint(b.getTaint());
        checkScale(b);
SimpleBigDecimal varBC873B48BA5F854280762166BC36B2E6_970714921 =         new SimpleBigDecimal(bigInt.add(b.bigInt), scale);
        varBC873B48BA5F854280762166BC36B2E6_970714921.addTaint(taint);
        return varBC873B48BA5F854280762166BC36B2E6_970714921;
        // ---------- Original Method ----------
        //checkScale(b);
        //return new SimpleBigDecimal(bigInt.add(b.bigInt), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.759 -0400", hash_original_method = "1997D6C5826C900035276C18BCFDD9D3", hash_generated_method = "89E061E6CC890BE5037A933D2E96F2B6")
    public SimpleBigDecimal add(BigInteger b) {
        addTaint(b.getTaint());
SimpleBigDecimal varA31368F8A8B819729583F82F3E09CF4F_1479318414 =         new SimpleBigDecimal(bigInt.add(b.shiftLeft(scale)), scale);
        varA31368F8A8B819729583F82F3E09CF4F_1479318414.addTaint(taint);
        return varA31368F8A8B819729583F82F3E09CF4F_1479318414;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.add(b.shiftLeft(scale)), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.759 -0400", hash_original_method = "847D70590D3897E07ED49ABD60DD0D05", hash_generated_method = "72482769805C6319346E3CF4C21AB5A4")
    public SimpleBigDecimal negate() {
SimpleBigDecimal varEED3C5BAE20C6BD213BDF57CA9FED0D9_1424130479 =         new SimpleBigDecimal(bigInt.negate(), scale);
        varEED3C5BAE20C6BD213BDF57CA9FED0D9_1424130479.addTaint(taint);
        return varEED3C5BAE20C6BD213BDF57CA9FED0D9_1424130479;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.negate(), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.759 -0400", hash_original_method = "E3DDD4A4133D81CA99A1E7F6CCD5CF2B", hash_generated_method = "89757FD575C4C173527DCCE725651EE9")
    public SimpleBigDecimal subtract(SimpleBigDecimal b) {
        addTaint(b.getTaint());
SimpleBigDecimal var32038E816FAB690831584DAC6FED51A3_706057303 =         add(b.negate());
        var32038E816FAB690831584DAC6FED51A3_706057303.addTaint(taint);
        return var32038E816FAB690831584DAC6FED51A3_706057303;
        // ---------- Original Method ----------
        //return add(b.negate());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.760 -0400", hash_original_method = "5502C0B2E51F8EC346A3B0EA2AFD7881", hash_generated_method = "BE6E8DE53780AD3883B6589F3B6274FC")
    public SimpleBigDecimal subtract(BigInteger b) {
        addTaint(b.getTaint());
SimpleBigDecimal var708256F44F870458C1B9173583B404CC_1710428883 =         new SimpleBigDecimal(bigInt.subtract(b.shiftLeft(scale)),
                scale);
        var708256F44F870458C1B9173583B404CC_1710428883.addTaint(taint);
        return var708256F44F870458C1B9173583B404CC_1710428883;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.subtract(b.shiftLeft(scale)),
                //scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.760 -0400", hash_original_method = "330628D6579367C0F7404BA6336A3E07", hash_generated_method = "95078F1B78F928D4F480C493DB9E7F14")
    public SimpleBigDecimal multiply(SimpleBigDecimal b) {
        addTaint(b.getTaint());
        checkScale(b);
SimpleBigDecimal varEB970EDBBB7718B30C3A81F4568A545F_2011793268 =         new SimpleBigDecimal(bigInt.multiply(b.bigInt), scale + scale);
        varEB970EDBBB7718B30C3A81F4568A545F_2011793268.addTaint(taint);
        return varEB970EDBBB7718B30C3A81F4568A545F_2011793268;
        // ---------- Original Method ----------
        //checkScale(b);
        //return new SimpleBigDecimal(bigInt.multiply(b.bigInt), scale + scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.761 -0400", hash_original_method = "F7512EC811E7F46BF7093DEE1B5F6571", hash_generated_method = "D810D08E1048778D3C4ECF904BBA8799")
    public SimpleBigDecimal multiply(BigInteger b) {
        addTaint(b.getTaint());
SimpleBigDecimal varC8F4D9931E1A3F11C6EA04ED3A60723C_1732418212 =         new SimpleBigDecimal(bigInt.multiply(b), scale);
        varC8F4D9931E1A3F11C6EA04ED3A60723C_1732418212.addTaint(taint);
        return varC8F4D9931E1A3F11C6EA04ED3A60723C_1732418212;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.multiply(b), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.761 -0400", hash_original_method = "7E74D1BB6D8D1863DA2FA49A62271B48", hash_generated_method = "1DB557BFBCE3D51D5D061E217FBDD871")
    public SimpleBigDecimal divide(SimpleBigDecimal b) {
        addTaint(b.getTaint());
        checkScale(b);
        BigInteger dividend = bigInt.shiftLeft(scale);
SimpleBigDecimal varF9FDF50A6BD8DB22F717F98EAA4C220D_1964228161 =         new SimpleBigDecimal(dividend.divide(b.bigInt), scale);
        varF9FDF50A6BD8DB22F717F98EAA4C220D_1964228161.addTaint(taint);
        return varF9FDF50A6BD8DB22F717F98EAA4C220D_1964228161;
        // ---------- Original Method ----------
        //checkScale(b);
        //BigInteger dividend = bigInt.shiftLeft(scale);
        //return new SimpleBigDecimal(dividend.divide(b.bigInt), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.761 -0400", hash_original_method = "F0938440F96DC20B0D4303728A0BA40C", hash_generated_method = "0533F82ACBD278A9EC6C07A8CB247328")
    public SimpleBigDecimal divide(BigInteger b) {
        addTaint(b.getTaint());
SimpleBigDecimal varE19CF6B9C2F6CFF15898E9D41C92A96A_1712827133 =         new SimpleBigDecimal(bigInt.divide(b), scale);
        varE19CF6B9C2F6CFF15898E9D41C92A96A_1712827133.addTaint(taint);
        return varE19CF6B9C2F6CFF15898E9D41C92A96A_1712827133;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.divide(b), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.762 -0400", hash_original_method = "886004AC1E5A48AB6425DAAA9E6A9AE1", hash_generated_method = "311FC820B6010856A8F6199CAC69DD69")
    public SimpleBigDecimal shiftLeft(int n) {
        addTaint(n);
SimpleBigDecimal varC8A0EFC90D5FF6476306E34DA9FDBC84_1523505866 =         new SimpleBigDecimal(bigInt.shiftLeft(n), scale);
        varC8A0EFC90D5FF6476306E34DA9FDBC84_1523505866.addTaint(taint);
        return varC8A0EFC90D5FF6476306E34DA9FDBC84_1523505866;
        // ---------- Original Method ----------
        //return new SimpleBigDecimal(bigInt.shiftLeft(n), scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.762 -0400", hash_original_method = "F4FD2CFD498531A1DCCD160DB4A55A56", hash_generated_method = "1725346FC5AC17772E95968B72FE6A93")
    public int compareTo(SimpleBigDecimal val) {
        addTaint(val.getTaint());
        checkScale(val);
        int var7DFBD8C88DA41B760E951F1CA94EA26B_673047863 = (bigInt.compareTo(val.bigInt));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_544016410 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_544016410;
        // ---------- Original Method ----------
        //checkScale(val);
        //return bigInt.compareTo(val.bigInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.762 -0400", hash_original_method = "DA142CFE02A0CE378556DA61E5DFFA33", hash_generated_method = "0C45D4C5A25500CC4F39BB12B1F6B32B")
    public int compareTo(BigInteger val) {
        addTaint(val.getTaint());
        int varEED84E9BC36E2AD84F3D633E6A97270C_1557673328 = (bigInt.compareTo(val.shiftLeft(scale)));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_896532802 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_896532802;
        // ---------- Original Method ----------
        //return bigInt.compareTo(val.shiftLeft(scale));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.763 -0400", hash_original_method = "5A4C971F5322638C8E9F4B26460E4E92", hash_generated_method = "AB0C849D30FA934DD5B872ECA91838C5")
    public BigInteger floor() {
BigInteger varC3DA19D8A5CFC927635B2DFC55335EE8_214244322 =         bigInt.shiftRight(scale);
        varC3DA19D8A5CFC927635B2DFC55335EE8_214244322.addTaint(taint);
        return varC3DA19D8A5CFC927635B2DFC55335EE8_214244322;
        // ---------- Original Method ----------
        //return bigInt.shiftRight(scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.763 -0400", hash_original_method = "92FC76983B02D95A30B18D6CBD3123C0", hash_generated_method = "C431CFD10BBC8815EB2330AD4AD1E2D2")
    public BigInteger round() {
        SimpleBigDecimal oneHalf = new SimpleBigDecimal(ECConstants.ONE, 1);
BigInteger var4174CC434CBDE7DB724D4E7CC73D7929_236119333 =         add(oneHalf.adjustScale(scale)).floor();
        var4174CC434CBDE7DB724D4E7CC73D7929_236119333.addTaint(taint);
        return var4174CC434CBDE7DB724D4E7CC73D7929_236119333;
        // ---------- Original Method ----------
        //SimpleBigDecimal oneHalf = new SimpleBigDecimal(ECConstants.ONE, 1);
        //return add(oneHalf.adjustScale(scale)).floor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.763 -0400", hash_original_method = "8F98A91102E8EBECCDC59FAE2090EE26", hash_generated_method = "58BD49262EC79A3FD3B4BE88D4E6E694")
    public int intValue() {
        int var6436157326F3A27A72136918BE8B74EF_1732165532 = (floor().intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2126799708 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2126799708;
        // ---------- Original Method ----------
        //return floor().intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.764 -0400", hash_original_method = "AA9F4F5827911FF9AD2916733B5D4AF6", hash_generated_method = "2E3D5149624EF1C0B8069AC16A7D103B")
    public long longValue() {
        long varCF8562293A42CEC110CF39E17AE4DEC3_1697840621 = (floor().longValue());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_211235722 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_211235722;
        // ---------- Original Method ----------
        //return floor().longValue();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.764 -0400", hash_original_method = "555259738C76709D8C0A4CEB0BA4F05B", hash_generated_method = "4BA9228AD0ABA84E8C809EC23C6838EB")
    public int getScale() {
        int var0CB47AEB6E5F9323F0969E628C4E59F5_1903541751 = (scale);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1988666791 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1988666791;
        // ---------- Original Method ----------
        //return scale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.765 -0400", hash_original_method = "687FE1E6404530E144AF0CBE5E24BCFF", hash_generated_method = "F196AB3A18FF3F8255501DC5E5D6B250")
    public String toString() {
        if(scale == 0)        
        {
String varD162A010942E77D36E1D2EBFEB251561_1888278867 =             bigInt.toString();
            varD162A010942E77D36E1D2EBFEB251561_1888278867.addTaint(taint);
            return varD162A010942E77D36E1D2EBFEB251561_1888278867;
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
String var2460B846747F8B22185AD8BE722266A5_1817592490 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_1817592490.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_1817592490;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.765 -0400", hash_original_method = "31FE8AD014B4F1DD5E50498C47C1658F", hash_generated_method = "C07E43B80120A9015FE0C5A1A46EA898")
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(this == o)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_493265216 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_814357712 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_814357712;
        } //End block
        if(!(o instanceof SimpleBigDecimal))        
        {
            boolean var68934A3E9455FA72420237EB05902327_714455179 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_354608511 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_354608511;
        } //End block
        SimpleBigDecimal other = (SimpleBigDecimal)o;
        boolean varAB5C50053DE1F138DD7CAC0F39FD4335_630198068 = (((bigInt.equals(other.bigInt)) && (scale == other.scale)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1234528882 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1234528882;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.766 -0400", hash_original_method = "32368AD05F7F4213F28C81C339A46A5C", hash_generated_method = "CDA1B01506CFBE971452C9F2AFF443E1")
    public int hashCode() {
        int var43CD7DFA1F2F6D87A7D7C4C3BE2185AE_1624471424 = (bigInt.hashCode() ^ scale);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1219580889 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1219580889;
        // ---------- Original Method ----------
        //return bigInt.hashCode() ^ scale;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.766 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

    private static final long serialVersionUID = 1L;
}

