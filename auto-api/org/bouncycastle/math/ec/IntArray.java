package org.bouncycastle.math.ec;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.bouncycastle.util.Arrays;
import java.math.BigInteger;

class IntArray {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.680 -0400", hash_original_field = "BA2706D542212E178665E29722CB6E32", hash_generated_field = "E9EBF884B577D6B8AA0EBD0D214A9975")

    private int[] m_ints;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.680 -0400", hash_original_method = "CF92B6C8E56A2FEEE1A27D3C8C98CB3C", hash_generated_method = "4AA2E90BC04CBD175089A5991408DCD6")
    public  IntArray(int intLen) {
        m_ints = new int[intLen];
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.681 -0400", hash_original_method = "E4E96F90C2D91DCFC85CADE699127A3A", hash_generated_method = "0788CFC36461FC202D3DA53F8D708A6F")
    public  IntArray(int[] ints) {
        m_ints = ints;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.681 -0400", hash_original_method = "B0FB0977B01B053B445AE366ABB3C3A0", hash_generated_method = "1BABE91D15068D08839E8E69BB47572F")
    public  IntArray(BigInteger bigInt) {
        this(bigInt, 0);
        addTaint(bigInt.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.681 -0400", hash_original_method = "F611B84A6E1A1EF85C1F3F4E5CEA7421", hash_generated_method = "F91CC5E2F9C4C7A09BE36EE09BBA05B1")
    public  IntArray(BigInteger bigInt, int minIntLen) {
        {
            boolean varED0BFE98954101C6F44F91A570BA4A80_905368837 = (bigInt.signum() == -1);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Only positive Integers allowed");
            } 
        } 
        {
            boolean varA22C6D2079995A2CFF67778702FE6A37_1852195122 = (bigInt.equals(ECConstants.ZERO));
            {
                m_ints = new int[] { 0 };
            } 
        } 
        byte[] barr = bigInt.toByteArray();
        int barrLen = barr.length;
        int barrStart = 0;
        {
            barrStart = 1;
        } 
        int intLen = (barrLen + 3) / 4;
        {
            m_ints = new int[minIntLen];
        } 
        {
            m_ints = new int[intLen];
        } 
        int iarrJ = intLen - 1;
        int rem = barrLen % 4 + barrStart;
        int temp = 0;
        int barrI = barrStart;
        {
            {
                temp <<= 8;
                int barrBarrI = barr[barrI];
                {
                    barrBarrI += 256;
                } 
                temp |= barrBarrI;
            } 
            m_ints[iarrJ--] = temp;
        } 
        {
            temp = 0;
            {
                int i = 0;
                {
                    temp <<= 8;
                    int barrBarrI = barr[barrI++];
                    {
                        barrBarrI += 256;
                    } 
                    temp |= barrBarrI;
                } 
            } 
            m_ints[iarrJ] = temp;
        } 
        addTaint(bigInt.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.682 -0400", hash_original_method = "E4246E87B7407E5D0D895B01F5CA5262", hash_generated_method = "A3EE7FA7DFC22854352A60B067078D7E")
    public boolean isZero() {
        boolean var544461B831785C2ED105E5595D738F47_442913908 = (m_ints.length == 0
            || (m_ints[0] == 0 && getUsedLength() == 0));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_578978617 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_578978617;
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.682 -0400", hash_original_method = "B507EE9C677C6BEF8443BBEED19F5F42", hash_generated_method = "70EDD67A77302502467C5FBC59B25DA7")
    public int getUsedLength() {
        int highestIntPos = m_ints.length;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_825597782 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_825597782;
        
        
        
        
            
        
        
        
            
            
            
            
        
        
        
            
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.683 -0400", hash_original_method = "8733B39F158A323B90B7B7708BEF842A", hash_generated_method = "00C3B1E730F7CA50F9244B1FDB85FF8C")
    public int bitLength() {
        int intLen = getUsedLength();
        int last = intLen - 1;
        int highest = m_ints[last];
        int bits = (last << 5) + 1;
        {
            {
                bits += 24;
                highest >>>= 24;
            } 
            {
                bits += 16;
                highest >>>= 16;
            } 
        } 
        {
            bits += 8;
            highest >>>= 8;
        } 
        {
            highest >>>= 1;
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1462991099 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1462991099;
        
        
        
        
            
        
        
        
        
        
        
            
            
                
                
            
            
            
                
                
            
        
        
        
            
            
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.684 -0400", hash_original_method = "F4D18BEF0C27A90F867F9F4EB4C5771F", hash_generated_method = "6236E8B951961DFC4C1AFDB030551EE5")
    private int[] resizedInts(int newLen) {
        int[] newInts = new int[newLen];
        int oldLen = m_ints.length;
        int copyLen;
        copyLen = oldLen;
        copyLen = newLen;
        System.arraycopy(m_ints, 0, newInts, 0, copyLen);
        addTaint(newLen);
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1245178466 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1245178466;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.685 -0400", hash_original_method = "09D09B2288FFFDA0E5E3DFE8BCA7084C", hash_generated_method = "627643070ADB2C60BF5CABE49E89A92A")
    public BigInteger toBigInteger() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_2070753939 = null; 
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1361923820 = null; 
        int usedLen = getUsedLength();
        {
            varB4EAC82CA7396A68D541C85D26508E83_2070753939 = ECConstants.ZERO;
        } 
        int highestInt = m_ints[usedLen - 1];
        byte[] temp = new byte[4];
        int barrI = 0;
        boolean trailingZeroBytesDone = false;
        {
            int j = 3;
            {
                byte thisByte = (byte) (highestInt >>> (8 * j));
                {
                    trailingZeroBytesDone = true;
                    temp[barrI++] = thisByte;
                } 
            } 
        } 
        int barrLen = 4 * (usedLen - 1) + barrI;
        byte[] barr = new byte[barrLen];
        {
            int j = 0;
            {
                barr[j] = temp[j];
            } 
        } 
        {
            int iarrJ = usedLen - 2;
            {
                {
                    int j = 3;
                    {
                        barr[barrI++] = (byte) (m_ints[iarrJ] >>> (8 * j));
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1361923820 = new BigInteger(1, barr);
        BigInteger varA7E53CE21691AB073D9660D615818899_1178327309; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1178327309 = varB4EAC82CA7396A68D541C85D26508E83_2070753939;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1178327309 = varB4EAC82CA7396A68D541C85D26508E83_1361923820;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1178327309.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1178327309;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.686 -0400", hash_original_method = "EBDDD2C6998D211B0908F9BCC5704DCD", hash_generated_method = "56E08F25B23DC46BE2DF9EEF16F481EF")
    public void shiftLeft() {
        int usedLen = getUsedLength();
        {
            {
                m_ints = resizedInts(m_ints.length + 1);
            } 
        } 
        boolean carry = false;
        {
            int i = 0;
            {
                boolean nextCarry = m_ints[i] < 0;
                m_ints[i] <<= 1;
                {
                    m_ints[i] |= 1;
                } 
                carry = nextCarry;
            } 
        } 
        
        
        
        
            
        
        
        
            
            
            
                
            
        
        
        
        
            
            
            
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.687 -0400", hash_original_method = "59BECB0203E4A32DCA173F83ED20FA13", hash_generated_method = "F2B29DA43EFA4B0228996BB66D52440A")
    public IntArray shiftLeft(int n) {
        IntArray varB4EAC82CA7396A68D541C85D26508E83_217059033 = null; 
        IntArray varB4EAC82CA7396A68D541C85D26508E83_802238854 = null; 
        IntArray varB4EAC82CA7396A68D541C85D26508E83_490803123 = null; 
        int usedLen = getUsedLength();
        {
            varB4EAC82CA7396A68D541C85D26508E83_217059033 = this;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_802238854 = this;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("shiftLeft() for max 31 bits "
                + ", " + n + "bit shift is not possible");
        } 
        int[] newInts = new int[usedLen + 1];
        int nm32 = 32 - n;
        newInts[0] = m_ints[0] << n;
        {
            int i = 1;
            {
                newInts[i] = (m_ints[i] << n) | (m_ints[i - 1] >>> nm32);
            } 
        } 
        newInts[usedLen] = m_ints[usedLen - 1] >>> nm32;
        varB4EAC82CA7396A68D541C85D26508E83_490803123 = new IntArray(newInts);
        addTaint(n);
        IntArray varA7E53CE21691AB073D9660D615818899_1880624588; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1880624588 = varB4EAC82CA7396A68D541C85D26508E83_217059033;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1880624588 = varB4EAC82CA7396A68D541C85D26508E83_802238854;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1880624588 = varB4EAC82CA7396A68D541C85D26508E83_490803123;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1880624588.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1880624588;
        
        
        
        
            
        
        
        
            
        
        
        
            
                
        
        
        
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.688 -0400", hash_original_method = "183D6916993CED67CC764EA8E5C66CEC", hash_generated_method = "172656ED7DC6104238FF2CDCC663E033")
    public void addShifted(IntArray other, int shift) {
        int usedLenOther = other.getUsedLength();
        int newMinUsedLen = usedLenOther + shift;
        {
            m_ints = resizedInts(newMinUsedLen);
        } 
        {
            int i = 0;
            {
                m_ints[i + shift] ^= other.m_ints[i];
            } 
        } 
        
        
        
        
        
            
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.688 -0400", hash_original_method = "690E47F400DCE7124DE7B026A4F32194", hash_generated_method = "B981EE27D11C085DE298A2CC8400EF34")
    public int getLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1561164626 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1561164626;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.688 -0400", hash_original_method = "FE79684DF1E438A3896471D5404784E8", hash_generated_method = "D90D18B7528CD53C9E0DD61B60EFED11")
    public boolean testBit(int n) {
        int theInt = n >> 5;
        int theBit = n & 0x1F;
        int tester = 1 << theBit;
        addTaint(n);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1452653764 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1452653764;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.689 -0400", hash_original_method = "FC348D5A638DB94C0F8ADD1343AE7EDF", hash_generated_method = "9FD7E562FCBE28AB03A3D2E3D9E52559")
    public void flipBit(int n) {
        int theInt = n >> 5;
        int theBit = n & 0x1F;
        int flipper = 1 << theBit;
        m_ints[theInt] ^= flipper;
        addTaint(n);
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.689 -0400", hash_original_method = "F9C9D5AAA5BDCC63A2223BBDEFA54345", hash_generated_method = "D78066049BD287B642C3DF828B7E0780")
    public void setBit(int n) {
        int theInt = n >> 5;
        int theBit = n & 0x1F;
        int setter = 1 << theBit;
        m_ints[theInt] |= setter;
        addTaint(n);
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.690 -0400", hash_original_method = "DDD6CCDE0A994A74C3AB776F1EAE0C54", hash_generated_method = "D9AF14A64C484B1796829ACB37697090")
    public IntArray multiply(IntArray other, int m) {
        IntArray varB4EAC82CA7396A68D541C85D26508E83_1732494997 = null; 
        int t = (m + 31) >> 5;
        {
            m_ints = resizedInts(t);
        } 
        IntArray b = new IntArray(other.resizedInts(other.getLength() + 1));
        IntArray c = new IntArray((m + m + 31) >> 5);
        int testBit = 1;
        {
            int k = 0;
            {
                {
                    int j = 0;
                    {
                        {
                            c.addShifted(b, j);
                        } 
                    } 
                } 
                testBit <<= 1;
                b.shiftLeft();
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1732494997 = c;
        addTaint(other.getTaint());
        addTaint(m);
        varB4EAC82CA7396A68D541C85D26508E83_1732494997.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1732494997;
        
        
        
        
            
        
        
        
        
        
        
            
            
                
                
                    
                
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.690 -0400", hash_original_method = "801A97F7B079DF395A1C84876012A4A0", hash_generated_method = "D92A13AA853074C0F882F38181EB74E4")
    public void reduce(int m, int[] redPol) {
        {
            int i = m + m - 2;
            {
                {
                    boolean varD91FF93A19C19720B665E683C4B2A2E3_1791272449 = (testBit(i));
                    {
                        int bit = i - m;
                        flipBit(bit);
                        flipBit(i);
                        int l = redPol.length;
                        {
                            flipBit(redPol[l] + bit);
                        } 
                    } 
                } 
            } 
        } 
        m_ints = resizedInts((m + 31) >> 5);
        addTaint(redPol[0]);
        
        
        
            
            
                
                
                
                
                
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.691 -0400", hash_original_method = "D2D9CEFDA97A342DED6902D248733471", hash_generated_method = "E6BBB9DD634BDA6F19CF7AA4CE09258F")
    public IntArray square(int m) {
        IntArray varB4EAC82CA7396A68D541C85D26508E83_1292337911 = null; 
        final int[] table = { 0x0, 0x1, 0x4, 0x5, 0x10, 0x11, 0x14, 0x15, 0x40,
            0x41, 0x44, 0x45, 0x50, 0x51, 0x54, 0x55 };
        int t = (m + 31) >> 5;
        {
            m_ints = resizedInts(t);
        } 
        IntArray c = new IntArray(t + t);
        {
            int i = 0;
            {
                int v0 = 0;
                {
                    int j = 0;
                    {
                        v0 = v0 >>> 8;
                        int u = (m_ints[i] >>> (j * 4)) & 0xF;
                        int w = table[u] << 24;
                        v0 |= w;
                    } 
                } 
                c.m_ints[i + i] = v0;
                v0 = 0;
                int upper = m_ints[i] >>> 16;
                {
                    int j = 0;
                    {
                        v0 = v0 >>> 8;
                        int u = (upper >>> (j * 4)) & 0xF;
                        int w = table[u] << 24;
                        v0 |= w;
                    } 
                } 
                c.m_ints[i + i + 1] = v0;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1292337911 = c;
        addTaint(m);
        varB4EAC82CA7396A68D541C85D26508E83_1292337911.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1292337911;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.692 -0400", hash_original_method = "B863CB3B654462D1A297BFCA9B6601CD", hash_generated_method = "9F42F9D6A829AB5F95DDA56B25EA3030")
    public boolean equals(Object o) {
        IntArray other = (IntArray) o;
        int usedLen = getUsedLength();
        {
            boolean varC23C0893EF9761C1957F797C69E3A0A1_952993758 = (other.getUsedLength() != usedLen);
        } 
        {
            int i = 0;
        } 
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1791755695 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1791755695;
        
        
        
            
        
        
        
        
        
            
        
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.692 -0400", hash_original_method = "651D45029664378C68EF3BB76B2C76E2", hash_generated_method = "E1947A4A72ECA123F17803825B781B2D")
    public int hashCode() {
        int usedLen = getUsedLength();
        int hash = 1;
        {
            int i = 0;
            {
                hash = hash * 31 + m_ints[i];
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1873609099 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1873609099;
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.693 -0400", hash_original_method = "550C6BAEBE6332C41740A28950586A2C", hash_generated_method = "46BFBDE784C126CB726AD792972F5A05")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1473922602 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1473922602 = new IntArray(Arrays.clone(m_ints));
        varB4EAC82CA7396A68D541C85D26508E83_1473922602.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1473922602;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.696 -0400", hash_original_method = "14E8054A89CE6D677D0451C5FF658D29", hash_generated_method = "7FD93F5B4FCAEFA6B31B1F353307AFA5")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1425719522 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1229902510 = null; 
        int usedLen = getUsedLength();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1425719522 = "0";
        } 
        StringBuffer sb = new StringBuffer(Integer
            .toBinaryString(m_ints[usedLen - 1]));
        {
            int iarrJ = usedLen - 2;
            {
                String hexString = Integer.toBinaryString(m_ints[iarrJ]);
                {
                    int i = hexString.length();
                    {
                        hexString = "0" + hexString;
                    } 
                } 
                sb.append(hexString);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1229902510 = sb.toString();
        String varA7E53CE21691AB073D9660D615818899_1308273446; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1308273446 = varB4EAC82CA7396A68D541C85D26508E83_1425719522;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1308273446 = varB4EAC82CA7396A68D541C85D26508E83_1229902510;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1308273446.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1308273446;
        
        
        
        
            
        
        
            
        
        
            
            
            
                
            
            
        
        
    }

    
}

