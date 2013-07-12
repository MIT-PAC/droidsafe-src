package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.bouncycastle.util.Arrays;
import java.math.BigInteger;

class IntArray {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.092 -0400", hash_original_field = "BA2706D542212E178665E29722CB6E32", hash_generated_field = "E9EBF884B577D6B8AA0EBD0D214A9975")

    private int[] m_ints;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.093 -0400", hash_original_method = "CF92B6C8E56A2FEEE1A27D3C8C98CB3C", hash_generated_method = "4AA2E90BC04CBD175089A5991408DCD6")
    public  IntArray(int intLen) {
        m_ints = new int[intLen];
        // ---------- Original Method ----------
        //m_ints = new int[intLen];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.093 -0400", hash_original_method = "E4E96F90C2D91DCFC85CADE699127A3A", hash_generated_method = "0788CFC36461FC202D3DA53F8D708A6F")
    public  IntArray(int[] ints) {
        m_ints = ints;
        // ---------- Original Method ----------
        //m_ints = ints;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.093 -0400", hash_original_method = "B0FB0977B01B053B445AE366ABB3C3A0", hash_generated_method = "1BABE91D15068D08839E8E69BB47572F")
    public  IntArray(BigInteger bigInt) {
        this(bigInt, 0);
        addTaint(bigInt.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.179 -0400", hash_original_method = "F611B84A6E1A1EF85C1F3F4E5CEA7421", hash_generated_method = "A43C2CD3FF93D42E3E669D1ACBC59A74")
    public  IntArray(BigInteger bigInt, int minIntLen) {
        addTaint(bigInt.getTaint());
    if(bigInt.signum() == -1)        
        {
            IllegalArgumentException var4902BA8C565FD5B57A135BC17EAF2655_1049856380 = new IllegalArgumentException("Only positive Integers allowed");
            var4902BA8C565FD5B57A135BC17EAF2655_1049856380.addTaint(taint);
            throw var4902BA8C565FD5B57A135BC17EAF2655_1049856380;
        } //End block
    if(bigInt.equals(ECConstants.ZERO))        
        {
            m_ints = new int[] { 0 };
            return;
        } //End block
        byte[] barr = bigInt.toByteArray();
        int barrLen = barr.length;
        int barrStart = 0;
    if(barr[0] == 0)        
        {
            barrLen--;
            barrStart = 1;
        } //End block
        int intLen = (barrLen + 3) / 4;
    if(intLen < minIntLen)        
        {
            m_ints = new int[minIntLen];
        } //End block
        else
        {
            m_ints = new int[intLen];
        } //End block
        int iarrJ = intLen - 1;
        int rem = barrLen % 4 + barrStart;
        int temp = 0;
        int barrI = barrStart;
    if(barrStart < rem)        
        {
for(;barrI < rem;barrI++)
            {
                temp <<= 8;
                int barrBarrI = barr[barrI];
    if(barrBarrI < 0)                
                {
                    barrBarrI += 256;
                } //End block
                temp |= barrBarrI;
            } //End block
            m_ints[iarrJ--] = temp;
        } //End block
for(;iarrJ >= 0;iarrJ--)
        {
            temp = 0;
for(int i = 0;i < 4;i++)
            {
                temp <<= 8;
                int barrBarrI = barr[barrI++];
    if(barrBarrI < 0)                
                {
                    barrBarrI += 256;
                } //End block
                temp |= barrBarrI;
            } //End block
            m_ints[iarrJ] = temp;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.179 -0400", hash_original_method = "E4246E87B7407E5D0D895B01F5CA5262", hash_generated_method = "B38FFD754B7EDEFE92E8C1B6E3D7B73A")
    public boolean isZero() {
        boolean var253C72334C0EB694AA96247E57A28F2F_2105004065 = (m_ints.length == 0
            || (m_ints[0] == 0 && getUsedLength() == 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1384724782 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1384724782;
        // ---------- Original Method ----------
        //return m_ints.length == 0
            //|| (m_ints[0] == 0 && getUsedLength() == 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.179 -0400", hash_original_method = "B507EE9C677C6BEF8443BBEED19F5F42", hash_generated_method = "B10139042087416449F77039E04156FB")
    public int getUsedLength() {
        int highestIntPos = m_ints.length;
    if(highestIntPos < 1)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1906406449 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_528571238 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_528571238;
        } //End block
    if(m_ints[0] != 0)        
        {
            while
(m_ints[--highestIntPos] == 0)            
            {
            } //End block
            int varCB54868C7DDB67D87004BDED4ECF8BCB_200877544 = (highestIntPos + 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1450797423 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1450797423;
        } //End block
        do {
            {
    if(m_ints[--highestIntPos] != 0)                
                {
                    int varCB54868C7DDB67D87004BDED4ECF8BCB_645259918 = (highestIntPos + 1);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1218547315 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1218547315;
                } //End block
            } //End block
} while (highestIntPos > 0);
        int varCFCD208495D565EF66E7DFF9F98764DA_1400762327 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1491701152 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1491701152;
        // ---------- Original Method ----------
        //int highestIntPos = m_ints.length;
        //if (highestIntPos < 1)
        //{
            //return 0;
        //}
        //if (m_ints[0] != 0)
        //{
            //while (m_ints[--highestIntPos] == 0)
            //{
            //}
            //return highestIntPos + 1;
        //}
        //do
        //{
            //if (m_ints[--highestIntPos] != 0)
            //{
                //return highestIntPos + 1;
            //}
        //}
        //while (highestIntPos > 0);
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.180 -0400", hash_original_method = "8733B39F158A323B90B7B7708BEF842A", hash_generated_method = "19C891D585FC5A3F086D01EA392613F6")
    public int bitLength() {
        int intLen = getUsedLength();
    if(intLen == 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_2061879120 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_469255879 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_469255879;
        } //End block
        int last = intLen - 1;
        int highest = m_ints[last];
        int bits = (last << 5) + 1;
    if((highest & 0xffff0000) != 0)        
        {
    if((highest & 0xff000000) != 0)            
            {
                bits += 24;
                highest >>>= 24;
            } //End block
            else
            {
                bits += 16;
                highest >>>= 16;
            } //End block
        } //End block
        else
    if(highest > 0x000000ff)        
        {
            bits += 8;
            highest >>>= 8;
        } //End block
        while
(highest != 1)        
        {
            ++bits;
            highest >>>= 1;
        } //End block
        int varCC411E6C13670E52124629B8AC83F7D0_1299186117 = (bits);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1390371837 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1390371837;
        // ---------- Original Method ----------
        //int intLen = getUsedLength();
        //if (intLen == 0)
        //{
            //return 0;
        //}
        //int last = intLen - 1;
        //int highest = m_ints[last];
        //int bits = (last << 5) + 1;
        //if ((highest & 0xffff0000) != 0)
        //{
            //if ((highest & 0xff000000) != 0)
            //{
                //bits += 24;
                //highest >>>= 24;
            //}
            //else
            //{
                //bits += 16;
                //highest >>>= 16;
            //}
        //}
        //else if (highest > 0x000000ff)
        //{
            //bits += 8;
            //highest >>>= 8;
        //}
        //while (highest != 1)
        //{
            //++bits;
            //highest >>>= 1;
        //}
        //return bits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.180 -0400", hash_original_method = "F4D18BEF0C27A90F867F9F4EB4C5771F", hash_generated_method = "5144FF3BED0CD4A977ECF99E2188CD5A")
    private int[] resizedInts(int newLen) {
        addTaint(newLen);
        int[] newInts = new int[newLen];
        int oldLen = m_ints.length;
        int copyLen = oldLen < newLen ? oldLen : newLen;
        System.arraycopy(m_ints, 0, newInts, 0, copyLen);
        int[] var6DCC984BCD7412680413A2CDFED32285_2043357103 = (newInts);
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_315666009 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_315666009;
        // ---------- Original Method ----------
        //int[] newInts = new int[newLen];
        //int oldLen = m_ints.length;
        //int copyLen = oldLen < newLen ? oldLen : newLen;
        //System.arraycopy(m_ints, 0, newInts, 0, copyLen);
        //return newInts;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.180 -0400", hash_original_method = "09D09B2288FFFDA0E5E3DFE8BCA7084C", hash_generated_method = "8A35147DBF07CACAB2C7DEEA17E13460")
    public BigInteger toBigInteger() {
        int usedLen = getUsedLength();
    if(usedLen == 0)        
        {
BigInteger var70D83F43CEDD648CBCB32B0D8F832DD8_2092680562 =             ECConstants.ZERO;
            var70D83F43CEDD648CBCB32B0D8F832DD8_2092680562.addTaint(taint);
            return var70D83F43CEDD648CBCB32B0D8F832DD8_2092680562;
        } //End block
        int highestInt = m_ints[usedLen - 1];
        byte[] temp = new byte[4];
        int barrI = 0;
        boolean trailingZeroBytesDone = false;
for(int j = 3;j >= 0;j--)
        {
            byte thisByte = (byte) (highestInt >>> (8 * j));
    if(trailingZeroBytesDone || (thisByte != 0))            
            {
                trailingZeroBytesDone = true;
                temp[barrI++] = thisByte;
            } //End block
        } //End block
        int barrLen = 4 * (usedLen - 1) + barrI;
        byte[] barr = new byte[barrLen];
for(int j = 0;j < barrI;j++)
        {
            barr[j] = temp[j];
        } //End block
for(int iarrJ = usedLen - 2;iarrJ >= 0;iarrJ--)
        {
for(int j = 3;j >= 0;j--)
            {
                barr[barrI++] = (byte) (m_ints[iarrJ] >>> (8 * j));
            } //End block
        } //End block
BigInteger varCBBE36781BB4993B8A3D24E59AFD4F6E_975115777 =         new BigInteger(1, barr);
        varCBBE36781BB4993B8A3D24E59AFD4F6E_975115777.addTaint(taint);
        return varCBBE36781BB4993B8A3D24E59AFD4F6E_975115777;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.181 -0400", hash_original_method = "EBDDD2C6998D211B0908F9BCC5704DCD", hash_generated_method = "600127F06DC3EAF9F9AC6F5353F76021")
    public void shiftLeft() {
        int usedLen = getUsedLength();
    if(usedLen == 0)        
        {
            return;
        } //End block
    if(m_ints[usedLen - 1] < 0)        
        {
            usedLen++;
    if(usedLen > m_ints.length)            
            {
                m_ints = resizedInts(m_ints.length + 1);
            } //End block
        } //End block
        boolean carry = false;
for(int i = 0;i < usedLen;i++)
        {
            boolean nextCarry = m_ints[i] < 0;
            m_ints[i] <<= 1;
    if(carry)            
            {
                m_ints[i] |= 1;
            } //End block
            carry = nextCarry;
        } //End block
        // ---------- Original Method ----------
        //int usedLen = getUsedLength();
        //if (usedLen == 0)
        //{
            //return;
        //}
        //if (m_ints[usedLen - 1] < 0)
        //{
            //usedLen++;
            //if (usedLen > m_ints.length)
            //{
                //m_ints = resizedInts(m_ints.length + 1);
            //}
        //}
        //boolean carry = false;
        //for (int i = 0; i < usedLen; i++)
        //{
            //boolean nextCarry = m_ints[i] < 0;
            //m_ints[i] <<= 1;
            //if (carry)
            //{
                //m_ints[i] |= 1;
            //}
            //carry = nextCarry;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.181 -0400", hash_original_method = "59BECB0203E4A32DCA173F83ED20FA13", hash_generated_method = "7CD2033B8CCF923A70E30AE19BC71DF5")
    public IntArray shiftLeft(int n) {
        addTaint(n);
        int usedLen = getUsedLength();
    if(usedLen == 0)        
        {
IntArray var72A74007B2BE62B849F475C7BDA4658B_837982187 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_837982187.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_837982187;
        } //End block
    if(n == 0)        
        {
IntArray var72A74007B2BE62B849F475C7BDA4658B_233677860 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_233677860.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_233677860;
        } //End block
    if(n > 31)        
        {
            IllegalArgumentException var35B901062828562177A6827525EBDA49_1890954876 = new IllegalArgumentException("shiftLeft() for max 31 bits "
                + ", " + n + "bit shift is not possible");
            var35B901062828562177A6827525EBDA49_1890954876.addTaint(taint);
            throw var35B901062828562177A6827525EBDA49_1890954876;
        } //End block
        int[] newInts = new int[usedLen + 1];
        int nm32 = 32 - n;
        newInts[0] = m_ints[0] << n;
for(int i = 1;i < usedLen;i++)
        {
            newInts[i] = (m_ints[i] << n) | (m_ints[i - 1] >>> nm32);
        } //End block
        newInts[usedLen] = m_ints[usedLen - 1] >>> nm32;
IntArray varC42A0063A519C6F77098E2B47C3EB303_1820232652 =         new IntArray(newInts);
        varC42A0063A519C6F77098E2B47C3EB303_1820232652.addTaint(taint);
        return varC42A0063A519C6F77098E2B47C3EB303_1820232652;
        // ---------- Original Method ----------
        //int usedLen = getUsedLength();
        //if (usedLen == 0)
        //{
            //return this;
        //}
        //if (n == 0)
        //{
            //return this;
        //}
        //if (n > 31)
        //{
            //throw new IllegalArgumentException("shiftLeft() for max 31 bits "
                //+ ", " + n + "bit shift is not possible");
        //}
        //int[] newInts = new int[usedLen + 1];
        //int nm32 = 32 - n;
        //newInts[0] = m_ints[0] << n;
        //for (int i = 1; i < usedLen; i++)
        //{
            //newInts[i] = (m_ints[i] << n) | (m_ints[i - 1] >>> nm32);
        //}
        //newInts[usedLen] = m_ints[usedLen - 1] >>> nm32;
        //return new IntArray(newInts);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.181 -0400", hash_original_method = "183D6916993CED67CC764EA8E5C66CEC", hash_generated_method = "FD551B95FC73DE7D4DCC8C0219176718")
    public void addShifted(IntArray other, int shift) {
        int usedLenOther = other.getUsedLength();
        int newMinUsedLen = usedLenOther + shift;
    if(newMinUsedLen > m_ints.length)        
        {
            m_ints = resizedInts(newMinUsedLen);
        } //End block
for(int i = 0;i < usedLenOther;i++)
        {
            m_ints[i + shift] ^= other.m_ints[i];
        } //End block
        // ---------- Original Method ----------
        //int usedLenOther = other.getUsedLength();
        //int newMinUsedLen = usedLenOther + shift;
        //if (newMinUsedLen > m_ints.length)
        //{
            //m_ints = resizedInts(newMinUsedLen);
        //}
        //for (int i = 0; i < usedLenOther; i++)
        //{
            //m_ints[i + shift] ^= other.m_ints[i];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.182 -0400", hash_original_method = "690E47F400DCE7124DE7B026A4F32194", hash_generated_method = "D17095B085328871845F56011606C34A")
    public int getLength() {
        int var48385E2AA796608B29CB75E0EFDFAB5F_40365776 = (m_ints.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1265211639 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1265211639;
        // ---------- Original Method ----------
        //return m_ints.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.182 -0400", hash_original_method = "FE79684DF1E438A3896471D5404784E8", hash_generated_method = "356A3DC1C666354330EF92F7659DBF26")
    public boolean testBit(int n) {
        addTaint(n);
        int theInt = n >> 5;
        int theBit = n & 0x1F;
        int tester = 1 << theBit;
        boolean var7E09CD0C4F77CA89AB0F68C0A2541B6B_732295894 = (((m_ints[theInt] & tester) != 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1531229660 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1531229660;
        // ---------- Original Method ----------
        //int theInt = n >> 5;
        //int theBit = n & 0x1F;
        //int tester = 1 << theBit;
        //return ((m_ints[theInt] & tester) != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.182 -0400", hash_original_method = "FC348D5A638DB94C0F8ADD1343AE7EDF", hash_generated_method = "B8F2C85887D16BFCD65B085C7733CE67")
    public void flipBit(int n) {
        addTaint(n);
        int theInt = n >> 5;
        int theBit = n & 0x1F;
        int flipper = 1 << theBit;
        m_ints[theInt] ^= flipper;
        // ---------- Original Method ----------
        //int theInt = n >> 5;
        //int theBit = n & 0x1F;
        //int flipper = 1 << theBit;
        //m_ints[theInt] ^= flipper;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.182 -0400", hash_original_method = "F9C9D5AAA5BDCC63A2223BBDEFA54345", hash_generated_method = "15A83915FCF3C53CF78B58BFEDD01110")
    public void setBit(int n) {
        addTaint(n);
        int theInt = n >> 5;
        int theBit = n & 0x1F;
        int setter = 1 << theBit;
        m_ints[theInt] |= setter;
        // ---------- Original Method ----------
        //int theInt = n >> 5;
        //int theBit = n & 0x1F;
        //int setter = 1 << theBit;
        //m_ints[theInt] |= setter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.182 -0400", hash_original_method = "DDD6CCDE0A994A74C3AB776F1EAE0C54", hash_generated_method = "D8A8031059FF4708FC39949943869361")
    public IntArray multiply(IntArray other, int m) {
        addTaint(m);
        addTaint(other.getTaint());
        int t = (m + 31) >> 5;
    if(m_ints.length < t)        
        {
            m_ints = resizedInts(t);
        } //End block
        IntArray b = new IntArray(other.resizedInts(other.getLength() + 1));
        IntArray c = new IntArray((m + m + 31) >> 5);
        int testBit = 1;
for(int k = 0;k < 32;k++)
        {
for(int j = 0;j < t;j++)
            {
    if((m_ints[j] & testBit) != 0)                
                {
                    c.addShifted(b, j);
                } //End block
            } //End block
            testBit <<= 1;
            b.shiftLeft();
        } //End block
IntArray var807FB10045EE51C06BDB74744A6714DF_306128396 =         c;
        var807FB10045EE51C06BDB74744A6714DF_306128396.addTaint(taint);
        return var807FB10045EE51C06BDB74744A6714DF_306128396;
        // ---------- Original Method ----------
        //int t = (m + 31) >> 5;
        //if (m_ints.length < t)
        //{
            //m_ints = resizedInts(t);
        //}
        //IntArray b = new IntArray(other.resizedInts(other.getLength() + 1));
        //IntArray c = new IntArray((m + m + 31) >> 5);
        //int testBit = 1;
        //for (int k = 0; k < 32; k++)
        //{
            //for (int j = 0; j < t; j++)
            //{
                //if ((m_ints[j] & testBit) != 0)
                //{
                    //c.addShifted(b, j);
                //}
            //}
            //testBit <<= 1;
            //b.shiftLeft();
        //}
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.183 -0400", hash_original_method = "801A97F7B079DF395A1C84876012A4A0", hash_generated_method = "943962A55BF6DD8D87215532B3C2BB70")
    public void reduce(int m, int[] redPol) {
        addTaint(redPol[0]);
for(int i = m + m - 2;i >= m;i--)
        {
    if(testBit(i))            
            {
                int bit = i - m;
                flipBit(bit);
                flipBit(i);
                int l = redPol.length;
                while
(--l >= 0)                
                {
                    flipBit(redPol[l] + bit);
                } //End block
            } //End block
        } //End block
        m_ints = resizedInts((m + 31) >> 5);
        // ---------- Original Method ----------
        //for (int i = m + m - 2; i >= m; i--)
        //{
            //if (testBit(i))
            //{
                //int bit = i - m;
                //flipBit(bit);
                //flipBit(i);
                //int l = redPol.length;
                //while (--l >= 0)
                //{
                    //flipBit(redPol[l] + bit);
                //}
            //}
        //}
        //m_ints = resizedInts((m + 31) >> 5);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.183 -0400", hash_original_method = "D2D9CEFDA97A342DED6902D248733471", hash_generated_method = "436FC0DDD88DB1A87CD9D4B7B2DEB65E")
    public IntArray square(int m) {
        addTaint(m);
        final int[] table = { 0x0, 0x1, 0x4, 0x5, 0x10, 0x11, 0x14, 0x15, 0x40,
            0x41, 0x44, 0x45, 0x50, 0x51, 0x54, 0x55 };
        int t = (m + 31) >> 5;
    if(m_ints.length < t)        
        {
            m_ints = resizedInts(t);
        } //End block
        IntArray c = new IntArray(t + t);
for(int i = 0;i < t;i++)
        {
            int v0 = 0;
for(int j = 0;j < 4;j++)
            {
                v0 = v0 >>> 8;
                int u = (m_ints[i] >>> (j * 4)) & 0xF;
                int w = table[u] << 24;
                v0 |= w;
            } //End block
            c.m_ints[i + i] = v0;
            v0 = 0;
            int upper = m_ints[i] >>> 16;
for(int j = 0;j < 4;j++)
            {
                v0 = v0 >>> 8;
                int u = (upper >>> (j * 4)) & 0xF;
                int w = table[u] << 24;
                v0 |= w;
            } //End block
            c.m_ints[i + i + 1] = v0;
        } //End block
IntArray var807FB10045EE51C06BDB74744A6714DF_570430488 =         c;
        var807FB10045EE51C06BDB74744A6714DF_570430488.addTaint(taint);
        return var807FB10045EE51C06BDB74744A6714DF_570430488;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.183 -0400", hash_original_method = "B863CB3B654462D1A297BFCA9B6601CD", hash_generated_method = "66676FAD9CA712001B6D5AB038CAEE7A")
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(!(o instanceof IntArray))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1191856450 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1631474500 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1631474500;
        } //End block
        IntArray other = (IntArray) o;
        int usedLen = getUsedLength();
    if(other.getUsedLength() != usedLen)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1321766096 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_71350823 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_71350823;
        } //End block
for(int i = 0;i < usedLen;i++)
        {
    if(m_ints[i] != other.m_ints[i])            
            {
                boolean var68934A3E9455FA72420237EB05902327_347266925 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_246874297 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_246874297;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_720070024 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2090699373 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2090699373;
        // ---------- Original Method ----------
        //if (!(o instanceof IntArray))
        //{
            //return false;
        //}
        //IntArray other = (IntArray) o;
        //int usedLen = getUsedLength();
        //if (other.getUsedLength() != usedLen)
        //{
            //return false;
        //}
        //for (int i = 0; i < usedLen; i++)
        //{
            //if (m_ints[i] != other.m_ints[i])
            //{
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.184 -0400", hash_original_method = "651D45029664378C68EF3BB76B2C76E2", hash_generated_method = "CB3A653F082A8D553424776D0BCDBDB5")
    public int hashCode() {
        int usedLen = getUsedLength();
        int hash = 1;
for(int i = 0;i < usedLen;i++)
        {
            hash = hash * 31 + m_ints[i];
        } //End block
        int var0800FC577294C34E0B28AD2839435945_1248360008 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1288944783 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1288944783;
        // ---------- Original Method ----------
        //int usedLen = getUsedLength();
        //int hash = 1;
        //for (int i = 0; i < usedLen; i++)
        //{
            //hash = hash * 31 + m_ints[i];
        //}
        //return hash;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.184 -0400", hash_original_method = "550C6BAEBE6332C41740A28950586A2C", hash_generated_method = "F972D18462018D17D239BBAD9222B755")
    public Object clone() {
Object varBA17DD7025F99CDDFD91CAFCA1CF7C41_1692298085 =         new IntArray(Arrays.clone(m_ints));
        varBA17DD7025F99CDDFD91CAFCA1CF7C41_1692298085.addTaint(taint);
        return varBA17DD7025F99CDDFD91CAFCA1CF7C41_1692298085;
        // ---------- Original Method ----------
        //return new IntArray(Arrays.clone(m_ints));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:22.184 -0400", hash_original_method = "14E8054A89CE6D677D0451C5FF658D29", hash_generated_method = "F54BC07DAA5D18FA4EA1577EA6914B54")
    public String toString() {
        int usedLen = getUsedLength();
    if(usedLen == 0)        
        {
String var50F9DEEC38DD489662C457BCE7AD28CE_1361916769 =             "0";
            var50F9DEEC38DD489662C457BCE7AD28CE_1361916769.addTaint(taint);
            return var50F9DEEC38DD489662C457BCE7AD28CE_1361916769;
        } //End block
        StringBuffer sb = new StringBuffer(Integer
            .toBinaryString(m_ints[usedLen - 1]));
for(int iarrJ = usedLen - 2;iarrJ >= 0;iarrJ--)
        {
            String hexString = Integer.toBinaryString(m_ints[iarrJ]);
for(int i = hexString.length();i < 8;i++)
            {
                hexString = "0" + hexString;
            } //End block
            sb.append(hexString);
        } //End block
String var2460B846747F8B22185AD8BE722266A5_871908225 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_871908225.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_871908225;
        // ---------- Original Method ----------
        //int usedLen = getUsedLength();
        //if (usedLen == 0)
        //{
            //return "0";
        //}
        //StringBuffer sb = new StringBuffer(Integer
            //.toBinaryString(m_ints[usedLen - 1]));
        //for (int iarrJ = usedLen - 2; iarrJ >= 0; iarrJ--)
        //{
            //String hexString = Integer.toBinaryString(m_ints[iarrJ]);
            //for (int i = hexString.length(); i < 8; i++)
            //{
                //hexString = "0" + hexString;
            //}
            //sb.append(hexString);
        //}
        //return sb.toString();
    }

    
}

