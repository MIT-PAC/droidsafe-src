package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;

import org.bouncycastle.util.Arrays;






class IntArray {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.332 -0500", hash_original_field = "2D5FF9010CC73184DFBD8E9952524D01", hash_generated_field = "E9EBF884B577D6B8AA0EBD0D214A9975")


    private int[] m_ints;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.333 -0500", hash_original_method = "CF92B6C8E56A2FEEE1A27D3C8C98CB3C", hash_generated_method = "40FD795C29B74611AA1748511A6669A8")
    public IntArray(int intLen)
    {
        m_ints = new int[intLen];
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.334 -0500", hash_original_method = "E4E96F90C2D91DCFC85CADE699127A3A", hash_generated_method = "F65CFC7A98B41805A3B6B88558C3AB75")
    public IntArray(int[] ints)
    {
        m_ints = ints;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.336 -0500", hash_original_method = "B0FB0977B01B053B445AE366ABB3C3A0", hash_generated_method = "89D8088415FED0A87F64B0C27059E5C7")
    public IntArray(BigInteger bigInt)
    {
        this(bigInt, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.337 -0500", hash_original_method = "F611B84A6E1A1EF85C1F3F4E5CEA7421", hash_generated_method = "DB2F694148E8746286D3C957CD847F11")
    public IntArray(BigInteger bigInt, int minIntLen)
    {
        if (bigInt.signum() == -1)
        {
            throw new IllegalArgumentException("Only positive Integers allowed");
        }
        if (bigInt.equals(ECConstants.ZERO))
        {
            m_ints = new int[] { 0 };
            return;
        }

        byte[] barr = bigInt.toByteArray();
        int barrLen = barr.length;
        int barrStart = 0;
        if (barr[0] == 0)
        {
            // First byte is 0 to enforce highest (=sign) bit is zero.
            // In this case ignore barr[0].
            barrLen--;
            barrStart = 1;
        }
        int intLen = (barrLen + 3) / 4;
        if (intLen < minIntLen)
        {
            m_ints = new int[minIntLen];
        }
        else
        {
            m_ints = new int[intLen];
        }

        int iarrJ = intLen - 1;
        int rem = barrLen % 4 + barrStart;
        int temp = 0;
        int barrI = barrStart;
        if (barrStart < rem)
        {
            for (; barrI < rem; barrI++)
            {
                temp <<= 8;
                int barrBarrI = barr[barrI];
                if (barrBarrI < 0)
                {
                    barrBarrI += 256;
                }
                temp |= barrBarrI;
            }
            m_ints[iarrJ--] = temp;
        }

        for (; iarrJ >= 0; iarrJ--)
        {
            temp = 0;
            for (int i = 0; i < 4; i++)
            {
                temp <<= 8;
                int barrBarrI = barr[barrI++];
                if (barrBarrI < 0)
                {
                    barrBarrI += 256;
                }
                temp |= barrBarrI;
            }
            m_ints[iarrJ] = temp;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.338 -0500", hash_original_method = "E4246E87B7407E5D0D895B01F5CA5262", hash_generated_method = "808A51291DE6B046B9EF855F10CB472A")
    public boolean isZero()
    {
        return m_ints.length == 0
            || (m_ints[0] == 0 && getUsedLength() == 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.339 -0500", hash_original_method = "B507EE9C677C6BEF8443BBEED19F5F42", hash_generated_method = "46B585ACD50E85CBCD9625CF0A705A91")
    public int getUsedLength()
    {
        int highestIntPos = m_ints.length;

        if (highestIntPos < 1)
        {
            return 0;
        }

        // Check if first element will act as sentinel
        if (m_ints[0] != 0)
        {
            while (m_ints[--highestIntPos] == 0)
            {
            }
            return highestIntPos + 1;
        }

        do
        {
            if (m_ints[--highestIntPos] != 0)
            {
                return highestIntPos + 1;
            }
        }
        while (highestIntPos > 0);

        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.340 -0500", hash_original_method = "8733B39F158A323B90B7B7708BEF842A", hash_generated_method = "1CD31C2706D28EA73013F3FBDA225707")
    public int bitLength()
    {
        // JDK 1.5: see Integer.numberOfLeadingZeros()
        int intLen = getUsedLength();
        if (intLen == 0)
        {
            return 0;
        }

        int last = intLen - 1;
        int highest = m_ints[last];
        int bits = (last << 5) + 1;

        // A couple of binary search steps
        if ((highest & 0xffff0000) != 0)
        {
            if ((highest & 0xff000000) != 0)
            {
                bits += 24;
                highest >>>= 24;
            }
            else
            {
                bits += 16;
                highest >>>= 16;
            }
        }
        else if (highest > 0x000000ff)
        {
            bits += 8;
            highest >>>= 8;
        }

        while (highest != 1)
        {
            ++bits;
            highest >>>= 1;
        }

        return bits;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.341 -0500", hash_original_method = "F4D18BEF0C27A90F867F9F4EB4C5771F", hash_generated_method = "32E1399AD834220FE977FC52F7179924")
    private int[] resizedInts(int newLen)
    {
        int[] newInts = new int[newLen];
        int oldLen = m_ints.length;
        int copyLen = oldLen < newLen ? oldLen : newLen;
        System.arraycopy(m_ints, 0, newInts, 0, copyLen);
        return newInts;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.342 -0500", hash_original_method = "09D09B2288FFFDA0E5E3DFE8BCA7084C", hash_generated_method = "3F9B39E96972EA0B0B99EDD806B67A86")
    public BigInteger toBigInteger()
    {
        int usedLen = getUsedLength();
        if (usedLen == 0)
        {
            return ECConstants.ZERO;
        }

        int highestInt = m_ints[usedLen - 1];
        byte[] temp = new byte[4];
        int barrI = 0;
        boolean trailingZeroBytesDone = false;
        for (int j = 3; j >= 0; j--)
        {
            byte thisByte = (byte) (highestInt >>> (8 * j));
            if (trailingZeroBytesDone || (thisByte != 0))
            {
                trailingZeroBytesDone = true;
                temp[barrI++] = thisByte;
            }
        }

        int barrLen = 4 * (usedLen - 1) + barrI;
        byte[] barr = new byte[barrLen];
        for (int j = 0; j < barrI; j++)
        {
            barr[j] = temp[j];
        }
        // Highest value int is done now

        for (int iarrJ = usedLen - 2; iarrJ >= 0; iarrJ--)
        {
            for (int j = 3; j >= 0; j--)
            {
                barr[barrI++] = (byte) (m_ints[iarrJ] >>> (8 * j));
            }
        }
        return new BigInteger(1, barr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.343 -0500", hash_original_method = "EBDDD2C6998D211B0908F9BCC5704DCD", hash_generated_method = "C650A76A3D82EEEE821A4E949260C214")
    public void shiftLeft()
    {
        int usedLen = getUsedLength();
        if (usedLen == 0)
        {
            return;
        }
        if (m_ints[usedLen - 1] < 0)
        {
            // highest bit of highest used byte is set, so shifting left will
            // make the IntArray one byte longer
            usedLen++;
            if (usedLen > m_ints.length)
            {
                // make the m_ints one byte longer, because we need one more
                // byte which is not available in m_ints
                m_ints = resizedInts(m_ints.length + 1);
            }
        }

        boolean carry = false;
        for (int i = 0; i < usedLen; i++)
        {
            // nextCarry is true if highest bit is set
            boolean nextCarry = m_ints[i] < 0;
            m_ints[i] <<= 1;
            if (carry)
            {
                // set lowest bit
                m_ints[i] |= 1;
            }
            carry = nextCarry;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.344 -0500", hash_original_method = "59BECB0203E4A32DCA173F83ED20FA13", hash_generated_method = "753E5FEB32C0E31D1CFA368BCC957252")
    public IntArray shiftLeft(int n)
    {
        int usedLen = getUsedLength();
        if (usedLen == 0)
        {
            return this;
        }

        if (n == 0)
        {
            return this;
        }

        if (n > 31)
        {
            throw new IllegalArgumentException("shiftLeft() for max 31 bits "
                + ", " + n + "bit shift is not possible");
        }

        int[] newInts = new int[usedLen + 1];

        int nm32 = 32 - n;
        newInts[0] = m_ints[0] << n;
        for (int i = 1; i < usedLen; i++)
        {
            newInts[i] = (m_ints[i] << n) | (m_ints[i - 1] >>> nm32);
        }
        newInts[usedLen] = m_ints[usedLen - 1] >>> nm32;

        return new IntArray(newInts);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.345 -0500", hash_original_method = "183D6916993CED67CC764EA8E5C66CEC", hash_generated_method = "2E8BD6A3A717336F8E8111B628AC6676")
    public void addShifted(IntArray other, int shift)
    {
        int usedLenOther = other.getUsedLength();
        int newMinUsedLen = usedLenOther + shift;
        if (newMinUsedLen > m_ints.length)
        {
            m_ints = resizedInts(newMinUsedLen);
            //System.out.println("Resize required");
        }

        for (int i = 0; i < usedLenOther; i++)
        {
            m_ints[i + shift] ^= other.m_ints[i];
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.345 -0500", hash_original_method = "690E47F400DCE7124DE7B026A4F32194", hash_generated_method = "5B1B4FF93713D1FBDA90FC5F9C9F15D9")
    public int getLength()
    {
        return m_ints.length;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.346 -0500", hash_original_method = "FE79684DF1E438A3896471D5404784E8", hash_generated_method = "E85C684376F38525A299804ABDF821C2")
    public boolean testBit(int n)
    {
        // theInt = n / 32
        int theInt = n >> 5;
        // theBit = n % 32
        int theBit = n & 0x1F;
        int tester = 1 << theBit;
        return ((m_ints[theInt] & tester) != 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.347 -0500", hash_original_method = "FC348D5A638DB94C0F8ADD1343AE7EDF", hash_generated_method = "9B7FD36156B58D149457C57271FD50F6")
    public void flipBit(int n)
    {
        // theInt = n / 32
        int theInt = n >> 5;
        // theBit = n % 32
        int theBit = n & 0x1F;
        int flipper = 1 << theBit;
        m_ints[theInt] ^= flipper;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.348 -0500", hash_original_method = "F9C9D5AAA5BDCC63A2223BBDEFA54345", hash_generated_method = "F3BC07256872DD5610E2D5D2DE8F5807")
    public void setBit(int n)
    {
        // theInt = n / 32
        int theInt = n >> 5;
        // theBit = n % 32
        int theBit = n & 0x1F;
        int setter = 1 << theBit;
        m_ints[theInt] |= setter;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.349 -0500", hash_original_method = "DDD6CCDE0A994A74C3AB776F1EAE0C54", hash_generated_method = "0A361E6BC64356670CD4B5D5FB41D290")
    public IntArray multiply(IntArray other, int m)
    {
        // Lenght of c is 2m bits rounded up to the next int (32 bit)
        int t = (m + 31) >> 5;
        if (m_ints.length < t)
        {
            m_ints = resizedInts(t);
        }

        IntArray b = new IntArray(other.resizedInts(other.getLength() + 1));
        IntArray c = new IntArray((m + m + 31) >> 5);
        // IntArray c = new IntArray(t + t);
        int testBit = 1;
        for (int k = 0; k < 32; k++)
        {
            for (int j = 0; j < t; j++)
            {
                if ((m_ints[j] & testBit) != 0)
                {
                    // The kth bit of m_ints[j] is set
                    c.addShifted(b, j);
                }
            }
            testBit <<= 1;
            b.shiftLeft();
        }
        return c;
    }

    // public IntArray multiplyLeftToRight(IntArray other, int m) {
    // // Lenght of c is 2m bits rounded up to the next int (32 bit)
    // int t = (m + 31) / 32;
    // if (m_ints.length < t) {
    // m_ints = resizedInts(t);
    // }
    //
    // IntArray b = new IntArray(other.resizedInts(other.getLength() + 1));
    // IntArray c = new IntArray((m + m + 31) / 32);
    // // IntArray c = new IntArray(t + t);
    // int testBit = 1 << 31;
    // for (int k = 31; k >= 0; k--) {
    // for (int j = 0; j < t; j++) {
    // if ((m_ints[j] & testBit) != 0) {
    // // The kth bit of m_ints[j] is set
    // c.addShifted(b, j);
    // }
    // }
    // testBit >>>= 1;
    // if (k > 0) {
    // c.shiftLeft();
    // }
    // }
    // return c;
    // }

    // TODO note, redPol.length must be 3 for TPB and 5 for PPB
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.350 -0500", hash_original_method = "801A97F7B079DF395A1C84876012A4A0", hash_generated_method = "69064716A86A4786867B4190B3847E9E")
    public void reduce(int m, int[] redPol)
    {
        for (int i = m + m - 2; i >= m; i--)
        {
            if (testBit(i))
            {
                int bit = i - m;
                flipBit(bit);
                flipBit(i);
                int l = redPol.length;
                while (--l >= 0)
                {
                    flipBit(redPol[l] + bit);
                }
            }
        }
        m_ints = resizedInts((m + 31) >> 5);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.351 -0500", hash_original_method = "D2D9CEFDA97A342DED6902D248733471", hash_generated_method = "581E6965F8ED27AE553812FEB2F8CB1C")
    public IntArray square(int m)
    {
        // TODO make the table static final
        final int[] table = { 0x0, 0x1, 0x4, 0x5, 0x10, 0x11, 0x14, 0x15, 0x40,
            0x41, 0x44, 0x45, 0x50, 0x51, 0x54, 0x55 };

        int t = (m + 31) >> 5;
        if (m_ints.length < t)
        {
            m_ints = resizedInts(t);
        }

        IntArray c = new IntArray(t + t);

        // TODO twice the same code, put in separate private method
        for (int i = 0; i < t; i++)
        {
            int v0 = 0;
            for (int j = 0; j < 4; j++)
            {
                v0 = v0 >>> 8;
                int u = (m_ints[i] >>> (j * 4)) & 0xF;
                int w = table[u] << 24;
                v0 |= w;
            }
            c.m_ints[i + i] = v0;

            v0 = 0;
            int upper = m_ints[i] >>> 16;
            for (int j = 0; j < 4; j++)
            {
                v0 = v0 >>> 8;
                int u = (upper >>> (j * 4)) & 0xF;
                int w = table[u] << 24;
                v0 |= w;
            }
            c.m_ints[i + i + 1] = v0;
        }
        return c;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.352 -0500", hash_original_method = "B863CB3B654462D1A297BFCA9B6601CD", hash_generated_method = "EFC9F01E650B729DD8A9AED0084DA8BC")
    public boolean equals(Object o)
    {
        if (!(o instanceof IntArray))
        {
            return false;
        }
        IntArray other = (IntArray) o;
        int usedLen = getUsedLength();
        if (other.getUsedLength() != usedLen)
        {
            return false;
        }
        for (int i = 0; i < usedLen; i++)
        {
            if (m_ints[i] != other.m_ints[i])
            {
                return false;
            }
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.353 -0500", hash_original_method = "651D45029664378C68EF3BB76B2C76E2", hash_generated_method = "9DC8867BA4AECD8A7155ABCBC595DC51")
    public int hashCode()
    {
        int usedLen = getUsedLength();
        int hash = 1;
        for (int i = 0; i < usedLen; i++)
        {
            hash = hash * 31 + m_ints[i];
        }
        return hash;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.353 -0500", hash_original_method = "550C6BAEBE6332C41740A28950586A2C", hash_generated_method = "AC48E4C420D14BC1119FE734B0432642")
    public Object clone()
    {
        return new IntArray(Arrays.clone(m_ints));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:59.354 -0500", hash_original_method = "14E8054A89CE6D677D0451C5FF658D29", hash_generated_method = "81839723FA073F18DD07DE5129A4F35C")
    public String toString()
    {
        int usedLen = getUsedLength();
        if (usedLen == 0)
        {
            return "0";
        }

        StringBuffer sb = new StringBuffer(Integer
            .toBinaryString(m_ints[usedLen - 1]));
        for (int iarrJ = usedLen - 2; iarrJ >= 0; iarrJ--)
        {
            String hexString = Integer.toBinaryString(m_ints[iarrJ]);

            // Add leading zeroes, except for highest significant int
            for (int i = hexString.length(); i < 8; i++)
            {
                hexString = "0" + hexString;
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    
}

