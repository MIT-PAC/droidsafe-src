package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.bouncycastle.util.Arrays;
import java.math.BigInteger;

class IntArray {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.704 -0400", hash_original_field = "BA2706D542212E178665E29722CB6E32", hash_generated_field = "E9EBF884B577D6B8AA0EBD0D214A9975")

    private int[] m_ints;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.704 -0400", hash_original_method = "CF92B6C8E56A2FEEE1A27D3C8C98CB3C", hash_generated_method = "4AA2E90BC04CBD175089A5991408DCD6")
    public  IntArray(int intLen) {
        m_ints = new int[intLen];
        // ---------- Original Method ----------
        //m_ints = new int[intLen];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.705 -0400", hash_original_method = "E4E96F90C2D91DCFC85CADE699127A3A", hash_generated_method = "0788CFC36461FC202D3DA53F8D708A6F")
    public  IntArray(int[] ints) {
        m_ints = ints;
        // ---------- Original Method ----------
        //m_ints = ints;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.705 -0400", hash_original_method = "B0FB0977B01B053B445AE366ABB3C3A0", hash_generated_method = "1BABE91D15068D08839E8E69BB47572F")
    public  IntArray(BigInteger bigInt) {
        this(bigInt, 0);
        addTaint(bigInt.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.707 -0400", hash_original_method = "F611B84A6E1A1EF85C1F3F4E5CEA7421", hash_generated_method = "7D0BFC01C41D46B5A7A2AE7ABB568010")
    public  IntArray(BigInteger bigInt, int minIntLen) {
        addTaint(bigInt.getTaint());
        if(bigInt.signum() == -1)        
        {
            IllegalArgumentException var4902BA8C565FD5B57A135BC17EAF2655_1494440601 = new IllegalArgumentException("Only positive Integers allowed");
            var4902BA8C565FD5B57A135BC17EAF2655_1494440601.addTaint(taint);
            throw var4902BA8C565FD5B57A135BC17EAF2655_1494440601;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.708 -0400", hash_original_method = "E4246E87B7407E5D0D895B01F5CA5262", hash_generated_method = "5A1C7FCF2C17B24AA191D69741001982")
    public boolean isZero() {
        boolean var253C72334C0EB694AA96247E57A28F2F_182337286 = (m_ints.length == 0
            || (m_ints[0] == 0 && getUsedLength() == 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_575472132 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_575472132;
        // ---------- Original Method ----------
        //return m_ints.length == 0
            //|| (m_ints[0] == 0 && getUsedLength() == 0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.709 -0400", hash_original_method = "B507EE9C677C6BEF8443BBEED19F5F42", hash_generated_method = "115455AE292E3B1A2F88A25D82B999AF")
    public int getUsedLength() {
        int highestIntPos = m_ints.length;
        if(highestIntPos < 1)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1073741760 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1803389146 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1803389146;
        } //End block
        if(m_ints[0] != 0)        
        {
            while
(m_ints[--highestIntPos] == 0)            
            {
            } //End block
            int varCB54868C7DDB67D87004BDED4ECF8BCB_940843837 = (highestIntPos + 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2093005921 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2093005921;
        } //End block
        do {
            {
                if(m_ints[--highestIntPos] != 0)                
                {
                    int varCB54868C7DDB67D87004BDED4ECF8BCB_1779937950 = (highestIntPos + 1);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_463071184 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_463071184;
                } //End block
            } //End block
} while (highestIntPos > 0);
        int varCFCD208495D565EF66E7DFF9F98764DA_774057290 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1784547090 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1784547090;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.710 -0400", hash_original_method = "8733B39F158A323B90B7B7708BEF842A", hash_generated_method = "8C2B2B7AA386998F0D45A67D34396A53")
    public int bitLength() {
        int intLen = getUsedLength();
        if(intLen == 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1587715728 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1544601669 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1544601669;
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
        int varCC411E6C13670E52124629B8AC83F7D0_1066329852 = (bits);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_795657313 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_795657313;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.711 -0400", hash_original_method = "F4D18BEF0C27A90F867F9F4EB4C5771F", hash_generated_method = "52EE0EAA5648AB75E62998B3F04716CF")
    private int[] resizedInts(int newLen) {
        addTaint(newLen);
        int[] newInts = new int[newLen];
        int oldLen = m_ints.length;
        int copyLen = oldLen < newLen ? oldLen : newLen;
        System.arraycopy(m_ints, 0, newInts, 0, copyLen);
        int[] var6DCC984BCD7412680413A2CDFED32285_1065070079 = (newInts);
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1013252433 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1013252433;
        // ---------- Original Method ----------
        //int[] newInts = new int[newLen];
        //int oldLen = m_ints.length;
        //int copyLen = oldLen < newLen ? oldLen : newLen;
        //System.arraycopy(m_ints, 0, newInts, 0, copyLen);
        //return newInts;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.712 -0400", hash_original_method = "09D09B2288FFFDA0E5E3DFE8BCA7084C", hash_generated_method = "9C2C94F64E03B258FFC0DF9C751BC5C3")
    public BigInteger toBigInteger() {
        int usedLen = getUsedLength();
        if(usedLen == 0)        
        {
BigInteger var70D83F43CEDD648CBCB32B0D8F832DD8_1960662153 =             ECConstants.ZERO;
            var70D83F43CEDD648CBCB32B0D8F832DD8_1960662153.addTaint(taint);
            return var70D83F43CEDD648CBCB32B0D8F832DD8_1960662153;
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
BigInteger varCBBE36781BB4993B8A3D24E59AFD4F6E_1195618836 =         new BigInteger(1, barr);
        varCBBE36781BB4993B8A3D24E59AFD4F6E_1195618836.addTaint(taint);
        return varCBBE36781BB4993B8A3D24E59AFD4F6E_1195618836;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.713 -0400", hash_original_method = "EBDDD2C6998D211B0908F9BCC5704DCD", hash_generated_method = "600127F06DC3EAF9F9AC6F5353F76021")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.714 -0400", hash_original_method = "59BECB0203E4A32DCA173F83ED20FA13", hash_generated_method = "C96F1EEB3CB82EBC2431A18C52D7B349")
    public IntArray shiftLeft(int n) {
        addTaint(n);
        int usedLen = getUsedLength();
        if(usedLen == 0)        
        {
IntArray var72A74007B2BE62B849F475C7BDA4658B_466686782 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_466686782.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_466686782;
        } //End block
        if(n == 0)        
        {
IntArray var72A74007B2BE62B849F475C7BDA4658B_679742715 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_679742715.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_679742715;
        } //End block
        if(n > 31)        
        {
            IllegalArgumentException var35B901062828562177A6827525EBDA49_107834596 = new IllegalArgumentException("shiftLeft() for max 31 bits "
                + ", " + n + "bit shift is not possible");
            var35B901062828562177A6827525EBDA49_107834596.addTaint(taint);
            throw var35B901062828562177A6827525EBDA49_107834596;
        } //End block
        int[] newInts = new int[usedLen + 1];
        int nm32 = 32 - n;
        newInts[0] = m_ints[0] << n;
for(int i = 1;i < usedLen;i++)
        {
            newInts[i] = (m_ints[i] << n) | (m_ints[i - 1] >>> nm32);
        } //End block
        newInts[usedLen] = m_ints[usedLen - 1] >>> nm32;
IntArray varC42A0063A519C6F77098E2B47C3EB303_2081652610 =         new IntArray(newInts);
        varC42A0063A519C6F77098E2B47C3EB303_2081652610.addTaint(taint);
        return varC42A0063A519C6F77098E2B47C3EB303_2081652610;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.715 -0400", hash_original_method = "183D6916993CED67CC764EA8E5C66CEC", hash_generated_method = "FD551B95FC73DE7D4DCC8C0219176718")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.715 -0400", hash_original_method = "690E47F400DCE7124DE7B026A4F32194", hash_generated_method = "5645DC8E8F7551A29539314031CEDD32")
    public int getLength() {
        int var48385E2AA796608B29CB75E0EFDFAB5F_1572216887 = (m_ints.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_302095786 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_302095786;
        // ---------- Original Method ----------
        //return m_ints.length;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.716 -0400", hash_original_method = "FE79684DF1E438A3896471D5404784E8", hash_generated_method = "DA7A23C715ED1B686163BDB610709DC7")
    public boolean testBit(int n) {
        addTaint(n);
        int theInt = n >> 5;
        int theBit = n & 0x1F;
        int tester = 1 << theBit;
        boolean var7E09CD0C4F77CA89AB0F68C0A2541B6B_1102217003 = (((m_ints[theInt] & tester) != 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_963808595 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_963808595;
        // ---------- Original Method ----------
        //int theInt = n >> 5;
        //int theBit = n & 0x1F;
        //int tester = 1 << theBit;
        //return ((m_ints[theInt] & tester) != 0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.716 -0400", hash_original_method = "FC348D5A638DB94C0F8ADD1343AE7EDF", hash_generated_method = "B8F2C85887D16BFCD65B085C7733CE67")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.716 -0400", hash_original_method = "F9C9D5AAA5BDCC63A2223BBDEFA54345", hash_generated_method = "15A83915FCF3C53CF78B58BFEDD01110")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.717 -0400", hash_original_method = "DDD6CCDE0A994A74C3AB776F1EAE0C54", hash_generated_method = "A6E941A9F238EA2CB65634CBC5E80E97")
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
IntArray var807FB10045EE51C06BDB74744A6714DF_660677402 =         c;
        var807FB10045EE51C06BDB74744A6714DF_660677402.addTaint(taint);
        return var807FB10045EE51C06BDB74744A6714DF_660677402;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.718 -0400", hash_original_method = "801A97F7B079DF395A1C84876012A4A0", hash_generated_method = "943962A55BF6DD8D87215532B3C2BB70")
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.719 -0400", hash_original_method = "D2D9CEFDA97A342DED6902D248733471", hash_generated_method = "67D6227F56ACEDB26312DA410427B218")
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
IntArray var807FB10045EE51C06BDB74744A6714DF_504348278 =         c;
        var807FB10045EE51C06BDB74744A6714DF_504348278.addTaint(taint);
        return var807FB10045EE51C06BDB74744A6714DF_504348278;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.720 -0400", hash_original_method = "B863CB3B654462D1A297BFCA9B6601CD", hash_generated_method = "CFB37B772C3181A4E6923B985824AB51")
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(!(o instanceof IntArray))        
        {
            boolean var68934A3E9455FA72420237EB05902327_877364487 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_985872954 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_985872954;
        } //End block
        IntArray other = (IntArray) o;
        int usedLen = getUsedLength();
        if(other.getUsedLength() != usedLen)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1683624203 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_106024818 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_106024818;
        } //End block
for(int i = 0;i < usedLen;i++)
        {
            if(m_ints[i] != other.m_ints[i])            
            {
                boolean var68934A3E9455FA72420237EB05902327_1172029301 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1057364683 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1057364683;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1211479323 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_587391448 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_587391448;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.721 -0400", hash_original_method = "651D45029664378C68EF3BB76B2C76E2", hash_generated_method = "D18B9FC0A8CA7BE7C896B0466DA20642")
    public int hashCode() {
        int usedLen = getUsedLength();
        int hash = 1;
for(int i = 0;i < usedLen;i++)
        {
            hash = hash * 31 + m_ints[i];
        } //End block
        int var0800FC577294C34E0B28AD2839435945_209923123 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1720674667 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1720674667;
        // ---------- Original Method ----------
        //int usedLen = getUsedLength();
        //int hash = 1;
        //for (int i = 0; i < usedLen; i++)
        //{
            //hash = hash * 31 + m_ints[i];
        //}
        //return hash;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.721 -0400", hash_original_method = "550C6BAEBE6332C41740A28950586A2C", hash_generated_method = "546CAE5A65859015B9DF89F78AA83BF7")
    public Object clone() {
Object varBA17DD7025F99CDDFD91CAFCA1CF7C41_1270546825 =         new IntArray(Arrays.clone(m_ints));
        varBA17DD7025F99CDDFD91CAFCA1CF7C41_1270546825.addTaint(taint);
        return varBA17DD7025F99CDDFD91CAFCA1CF7C41_1270546825;
        // ---------- Original Method ----------
        //return new IntArray(Arrays.clone(m_ints));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.722 -0400", hash_original_method = "14E8054A89CE6D677D0451C5FF658D29", hash_generated_method = "744633E844537C752BF48C7DBDA87028")
    public String toString() {
        int usedLen = getUsedLength();
        if(usedLen == 0)        
        {
String var50F9DEEC38DD489662C457BCE7AD28CE_894170765 =             "0";
            var50F9DEEC38DD489662C457BCE7AD28CE_894170765.addTaint(taint);
            return var50F9DEEC38DD489662C457BCE7AD28CE_894170765;
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
String var2460B846747F8B22185AD8BE722266A5_860330589 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_860330589.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_860330589;
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

