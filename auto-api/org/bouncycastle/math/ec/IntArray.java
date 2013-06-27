package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.bouncycastle.util.Arrays;
import java.math.BigInteger;

class IntArray {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.373 -0400", hash_original_field = "BA2706D542212E178665E29722CB6E32", hash_generated_field = "E9EBF884B577D6B8AA0EBD0D214A9975")

    private int[] m_ints;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.374 -0400", hash_original_method = "CF92B6C8E56A2FEEE1A27D3C8C98CB3C", hash_generated_method = "4AA2E90BC04CBD175089A5991408DCD6")
    public  IntArray(int intLen) {
        m_ints = new int[intLen];
        // ---------- Original Method ----------
        //m_ints = new int[intLen];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.375 -0400", hash_original_method = "E4E96F90C2D91DCFC85CADE699127A3A", hash_generated_method = "0788CFC36461FC202D3DA53F8D708A6F")
    public  IntArray(int[] ints) {
        m_ints = ints;
        // ---------- Original Method ----------
        //m_ints = ints;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.375 -0400", hash_original_method = "B0FB0977B01B053B445AE366ABB3C3A0", hash_generated_method = "1BABE91D15068D08839E8E69BB47572F")
    public  IntArray(BigInteger bigInt) {
        this(bigInt, 0);
        addTaint(bigInt.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.380 -0400", hash_original_method = "F611B84A6E1A1EF85C1F3F4E5CEA7421", hash_generated_method = "2E700D394939F39DA024293BE0C40BBE")
    public  IntArray(BigInteger bigInt, int minIntLen) {
        {
            boolean varED0BFE98954101C6F44F91A570BA4A80_459729397 = (bigInt.signum() == -1);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Only positive Integers allowed");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA22C6D2079995A2CFF67778702FE6A37_1374241498 = (bigInt.equals(ECConstants.ZERO));
            {
                m_ints = new int[] { 0 };
            } //End block
        } //End collapsed parenthetic
        byte[] barr;
        barr = bigInt.toByteArray();
        int barrLen;
        barrLen = barr.length;
        int barrStart;
        barrStart = 0;
        {
            barrStart = 1;
        } //End block
        int intLen;
        intLen = (barrLen + 3) / 4;
        {
            m_ints = new int[minIntLen];
        } //End block
        {
            m_ints = new int[intLen];
        } //End block
        int iarrJ;
        iarrJ = intLen - 1;
        int rem;
        rem = barrLen % 4 + barrStart;
        int temp;
        temp = 0;
        int barrI;
        barrI = barrStart;
        {
            {
                temp <<= 8;
                int barrBarrI;
                barrBarrI = barr[barrI];
                {
                    barrBarrI += 256;
                } //End block
                temp |= barrBarrI;
            } //End block
            m_ints[iarrJ--] = temp;
        } //End block
        {
            temp = 0;
            {
                int i;
                i = 0;
                {
                    temp <<= 8;
                    int barrBarrI;
                    barrBarrI = barr[barrI++];
                    {
                        barrBarrI += 256;
                    } //End block
                    temp |= barrBarrI;
                } //End block
            } //End collapsed parenthetic
            m_ints[iarrJ] = temp;
        } //End block
        addTaint(bigInt.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.381 -0400", hash_original_method = "E4246E87B7407E5D0D895B01F5CA5262", hash_generated_method = "0C07B269D8C51FB8F0CA28D242C55891")
    public boolean isZero() {
        boolean var544461B831785C2ED105E5595D738F47_317619185 = (m_ints.length == 0
            || (m_ints[0] == 0 && getUsedLength() == 0));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1900361914 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1900361914;
        // ---------- Original Method ----------
        //return m_ints.length == 0
            //|| (m_ints[0] == 0 && getUsedLength() == 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.382 -0400", hash_original_method = "B507EE9C677C6BEF8443BBEED19F5F42", hash_generated_method = "DE9B4E5A6C92E5AF04FD9B21B774C952")
    public int getUsedLength() {
        int highestIntPos;
        highestIntPos = m_ints.length;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_143198390 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_143198390;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.394 -0400", hash_original_method = "8733B39F158A323B90B7B7708BEF842A", hash_generated_method = "CF23420990042EA09AA15B849E766F7A")
    public int bitLength() {
        int intLen;
        intLen = getUsedLength();
        int last;
        last = intLen - 1;
        int highest;
        highest = m_ints[last];
        int bits;
        bits = (last << 5) + 1;
        {
            {
                bits += 24;
                highest >>>= 24;
            } //End block
            {
                bits += 16;
                highest >>>= 16;
            } //End block
        } //End block
        {
            bits += 8;
            highest >>>= 8;
        } //End block
        {
            highest >>>= 1;
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1530199803 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1530199803;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.395 -0400", hash_original_method = "F4D18BEF0C27A90F867F9F4EB4C5771F", hash_generated_method = "D9C5248D50913952895BE159A242DA9A")
    private int[] resizedInts(int newLen) {
        int[] newInts;
        newInts = new int[newLen];
        int oldLen;
        oldLen = m_ints.length;
        int copyLen;
        copyLen = oldLen;
        copyLen = newLen;
        System.arraycopy(m_ints, 0, newInts, 0, copyLen);
        addTaint(newLen);
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_59163519 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_59163519;
        // ---------- Original Method ----------
        //int[] newInts = new int[newLen];
        //int oldLen = m_ints.length;
        //int copyLen = oldLen < newLen ? oldLen : newLen;
        //System.arraycopy(m_ints, 0, newInts, 0, copyLen);
        //return newInts;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.402 -0400", hash_original_method = "09D09B2288FFFDA0E5E3DFE8BCA7084C", hash_generated_method = "BA86609D394C9A6A099CAD43A4B2E692")
    public BigInteger toBigInteger() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1990359399 = null; //Variable for return #1
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_344356696 = null; //Variable for return #2
        int usedLen;
        usedLen = getUsedLength();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1990359399 = ECConstants.ZERO;
        } //End block
        int highestInt;
        highestInt = m_ints[usedLen - 1];
        byte[] temp;
        temp = new byte[4];
        int barrI;
        barrI = 0;
        boolean trailingZeroBytesDone;
        trailingZeroBytesDone = false;
        {
            int j;
            j = 3;
            {
                byte thisByte;
                thisByte = (byte) (highestInt >>> (8 * j));
                {
                    trailingZeroBytesDone = true;
                    temp[barrI++] = thisByte;
                } //End block
            } //End block
        } //End collapsed parenthetic
        int barrLen;
        barrLen = 4 * (usedLen - 1) + barrI;
        byte[] barr;
        barr = new byte[barrLen];
        {
            int j;
            j = 0;
            {
                barr[j] = temp[j];
            } //End block
        } //End collapsed parenthetic
        {
            int iarrJ;
            iarrJ = usedLen - 2;
            {
                {
                    int j;
                    j = 3;
                    {
                        barr[barrI++] = (byte) (m_ints[iarrJ] >>> (8 * j));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_344356696 = new BigInteger(1, barr);
        BigInteger varA7E53CE21691AB073D9660D615818899_352203432; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_352203432 = varB4EAC82CA7396A68D541C85D26508E83_1990359399;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_352203432 = varB4EAC82CA7396A68D541C85D26508E83_344356696;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_352203432.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_352203432;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.411 -0400", hash_original_method = "EBDDD2C6998D211B0908F9BCC5704DCD", hash_generated_method = "E5563B813BC56A3EADA1625C79FE1FC8")
    public void shiftLeft() {
        int usedLen;
        usedLen = getUsedLength();
        {
            {
                m_ints = resizedInts(m_ints.length + 1);
            } //End block
        } //End block
        boolean carry;
        carry = false;
        {
            int i;
            i = 0;
            {
                boolean nextCarry;
                nextCarry = m_ints[i] < 0;
                m_ints[i] <<= 1;
                {
                    m_ints[i] |= 1;
                } //End block
                carry = nextCarry;
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.412 -0400", hash_original_method = "59BECB0203E4A32DCA173F83ED20FA13", hash_generated_method = "F33CBDA14C6375D2D21A910383EBD0A8")
    public IntArray shiftLeft(int n) {
        IntArray varB4EAC82CA7396A68D541C85D26508E83_99987501 = null; //Variable for return #1
        IntArray varB4EAC82CA7396A68D541C85D26508E83_555518260 = null; //Variable for return #2
        IntArray varB4EAC82CA7396A68D541C85D26508E83_39527097 = null; //Variable for return #3
        int usedLen;
        usedLen = getUsedLength();
        {
            varB4EAC82CA7396A68D541C85D26508E83_99987501 = this;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_555518260 = this;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("shiftLeft() for max 31 bits "
                + ", " + n + "bit shift is not possible");
        } //End block
        int[] newInts;
        newInts = new int[usedLen + 1];
        int nm32;
        nm32 = 32 - n;
        newInts[0] = m_ints[0] << n;
        {
            int i;
            i = 1;
            {
                newInts[i] = (m_ints[i] << n) | (m_ints[i - 1] >>> nm32);
            } //End block
        } //End collapsed parenthetic
        newInts[usedLen] = m_ints[usedLen - 1] >>> nm32;
        varB4EAC82CA7396A68D541C85D26508E83_39527097 = new IntArray(newInts);
        addTaint(n);
        IntArray varA7E53CE21691AB073D9660D615818899_1928110587; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1928110587 = varB4EAC82CA7396A68D541C85D26508E83_99987501;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1928110587 = varB4EAC82CA7396A68D541C85D26508E83_555518260;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1928110587 = varB4EAC82CA7396A68D541C85D26508E83_39527097;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1928110587.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1928110587;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.413 -0400", hash_original_method = "183D6916993CED67CC764EA8E5C66CEC", hash_generated_method = "4212E00A45EF806B83893ADBB0C77A1F")
    public void addShifted(IntArray other, int shift) {
        int usedLenOther;
        usedLenOther = other.getUsedLength();
        int newMinUsedLen;
        newMinUsedLen = usedLenOther + shift;
        {
            m_ints = resizedInts(newMinUsedLen);
        } //End block
        {
            int i;
            i = 0;
            {
                m_ints[i + shift] ^= other.m_ints[i];
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.413 -0400", hash_original_method = "690E47F400DCE7124DE7B026A4F32194", hash_generated_method = "0F425A5A4F4DD7B47E8A058BD48C8BC9")
    public int getLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_316322464 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_316322464;
        // ---------- Original Method ----------
        //return m_ints.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.413 -0400", hash_original_method = "FE79684DF1E438A3896471D5404784E8", hash_generated_method = "1748667271D2390E4ABE879A368147AB")
    public boolean testBit(int n) {
        int theInt;
        theInt = n >> 5;
        int theBit;
        theBit = n & 0x1F;
        int tester;
        tester = 1 << theBit;
        addTaint(n);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2025371970 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2025371970;
        // ---------- Original Method ----------
        //int theInt = n >> 5;
        //int theBit = n & 0x1F;
        //int tester = 1 << theBit;
        //return ((m_ints[theInt] & tester) != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.414 -0400", hash_original_method = "FC348D5A638DB94C0F8ADD1343AE7EDF", hash_generated_method = "0E4B267CF260653B0B2C983802C6D627")
    public void flipBit(int n) {
        int theInt;
        theInt = n >> 5;
        int theBit;
        theBit = n & 0x1F;
        int flipper;
        flipper = 1 << theBit;
        m_ints[theInt] ^= flipper;
        addTaint(n);
        // ---------- Original Method ----------
        //int theInt = n >> 5;
        //int theBit = n & 0x1F;
        //int flipper = 1 << theBit;
        //m_ints[theInt] ^= flipper;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.414 -0400", hash_original_method = "F9C9D5AAA5BDCC63A2223BBDEFA54345", hash_generated_method = "3CFB3703A540B6CEF43700359C03616D")
    public void setBit(int n) {
        int theInt;
        theInt = n >> 5;
        int theBit;
        theBit = n & 0x1F;
        int setter;
        setter = 1 << theBit;
        m_ints[theInt] |= setter;
        addTaint(n);
        // ---------- Original Method ----------
        //int theInt = n >> 5;
        //int theBit = n & 0x1F;
        //int setter = 1 << theBit;
        //m_ints[theInt] |= setter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.415 -0400", hash_original_method = "DDD6CCDE0A994A74C3AB776F1EAE0C54", hash_generated_method = "36EB2D79D921D5FD43ACA6DFC26CF88D")
    public IntArray multiply(IntArray other, int m) {
        IntArray varB4EAC82CA7396A68D541C85D26508E83_2131241247 = null; //Variable for return #1
        int t;
        t = (m + 31) >> 5;
        {
            m_ints = resizedInts(t);
        } //End block
        IntArray b;
        b = new IntArray(other.resizedInts(other.getLength() + 1));
        IntArray c;
        c = new IntArray((m + m + 31) >> 5);
        int testBit;
        testBit = 1;
        {
            int k;
            k = 0;
            {
                {
                    int j;
                    j = 0;
                    {
                        {
                            c.addShifted(b, j);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                testBit <<= 1;
                b.shiftLeft();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2131241247 = c;
        addTaint(other.getTaint());
        addTaint(m);
        varB4EAC82CA7396A68D541C85D26508E83_2131241247.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2131241247;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.415 -0400", hash_original_method = "801A97F7B079DF395A1C84876012A4A0", hash_generated_method = "E295D4968BF3BE5924FAD29E4B20D92D")
    public void reduce(int m, int[] redPol) {
        {
            int i;
            i = m + m - 2;
            {
                {
                    boolean varD91FF93A19C19720B665E683C4B2A2E3_86416304 = (testBit(i));
                    {
                        int bit;
                        bit = i - m;
                        flipBit(bit);
                        flipBit(i);
                        int l;
                        l = redPol.length;
                        {
                            flipBit(redPol[l] + bit);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        m_ints = resizedInts((m + 31) >> 5);
        addTaint(redPol[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.422 -0400", hash_original_method = "D2D9CEFDA97A342DED6902D248733471", hash_generated_method = "4ADB64DB7C73E2247CBEEA6B616E0A74")
    public IntArray square(int m) {
        IntArray varB4EAC82CA7396A68D541C85D26508E83_1893350361 = null; //Variable for return #1
        int[] table;
        int t;
        t = (m + 31) >> 5;
        {
            m_ints = resizedInts(t);
        } //End block
        IntArray c;
        c = new IntArray(t + t);
        {
            int i;
            i = 0;
            {
                int v0;
                v0 = 0;
                {
                    int j;
                    j = 0;
                    {
                        v0 = v0 >>> 8;
                        int u;
                        u = (m_ints[i] >>> (j * 4)) & 0xF;
                        int w;
                        w = table[u] << 24;
                        v0 |= w;
                    } //End block
                } //End collapsed parenthetic
                c.m_ints[i + i] = v0;
                v0 = 0;
                int upper;
                upper = m_ints[i] >>> 16;
                {
                    int j;
                    j = 0;
                    {
                        v0 = v0 >>> 8;
                        int u;
                        u = (upper >>> (j * 4)) & 0xF;
                        int w;
                        w = table[u] << 24;
                        v0 |= w;
                    } //End block
                } //End collapsed parenthetic
                c.m_ints[i + i + 1] = v0;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1893350361 = c;
        addTaint(m);
        varB4EAC82CA7396A68D541C85D26508E83_1893350361.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1893350361;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.423 -0400", hash_original_method = "B863CB3B654462D1A297BFCA9B6601CD", hash_generated_method = "A236D869F0A73094387A11728F5B9222")
    public boolean equals(Object o) {
        IntArray other;
        other = (IntArray) o;
        int usedLen;
        usedLen = getUsedLength();
        {
            boolean varC23C0893EF9761C1957F797C69E3A0A1_189619761 = (other.getUsedLength() != usedLen);
        } //End collapsed parenthetic
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2039837639 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2039837639;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.433 -0400", hash_original_method = "651D45029664378C68EF3BB76B2C76E2", hash_generated_method = "E9F332F8B2FA54289F69ABD4228388E5")
    public int hashCode() {
        int usedLen;
        usedLen = getUsedLength();
        int hash;
        hash = 1;
        {
            int i;
            i = 0;
            {
                hash = hash * 31 + m_ints[i];
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_266440283 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_266440283;
        // ---------- Original Method ----------
        //int usedLen = getUsedLength();
        //int hash = 1;
        //for (int i = 0; i < usedLen; i++)
        //{
            //hash = hash * 31 + m_ints[i];
        //}
        //return hash;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.434 -0400", hash_original_method = "550C6BAEBE6332C41740A28950586A2C", hash_generated_method = "C39D61513F32A9608617FD6657B0FFD4")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1159542113 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1159542113 = new IntArray(Arrays.clone(m_ints));
        varB4EAC82CA7396A68D541C85D26508E83_1159542113.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1159542113;
        // ---------- Original Method ----------
        //return new IntArray(Arrays.clone(m_ints));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.435 -0400", hash_original_method = "14E8054A89CE6D677D0451C5FF658D29", hash_generated_method = "95665EC9566B4A65BAD368E7C9718E2A")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_527632161 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_528751408 = null; //Variable for return #2
        int usedLen;
        usedLen = getUsedLength();
        {
            varB4EAC82CA7396A68D541C85D26508E83_527632161 = "0";
        } //End block
        StringBuffer sb;
        sb = new StringBuffer(Integer
            .toBinaryString(m_ints[usedLen - 1]));
        {
            int iarrJ;
            iarrJ = usedLen - 2;
            {
                String hexString;
                hexString = Integer.toBinaryString(m_ints[iarrJ]);
                {
                    int i;
                    i = hexString.length();
                    {
                        hexString = "0" + hexString;
                    } //End block
                } //End collapsed parenthetic
                sb.append(hexString);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_528751408 = sb.toString();
        String varA7E53CE21691AB073D9660D615818899_1258675010; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1258675010 = varB4EAC82CA7396A68D541C85D26508E83_527632161;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1258675010 = varB4EAC82CA7396A68D541C85D26508E83_528751408;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1258675010.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1258675010;
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

