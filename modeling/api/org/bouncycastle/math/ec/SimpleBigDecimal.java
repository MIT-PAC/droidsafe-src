/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;

class SimpleBigDecimal {

    /**
     * Returns a <code>SimpleBigDecimal</code> representing the same numerical
     * value as <code>value</code>.
     * @param value The value of the <code>SimpleBigDecimal</code> to be
     * created. 
     * @param scale The scale of the <code>SimpleBigDecimal</code> to be
     * created. 
     * @return The such created <code>SimpleBigDecimal</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.980 -0500", hash_original_method = "521858A84CA75A585AB087F1B453F3A3", hash_generated_method = "3AA6E828860AEFB6804615222D88554E")
    
public static SimpleBigDecimal getInstance(BigInteger value, int scale)
    {
        return new SimpleBigDecimal(value.shiftLeft(scale), scale);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.972 -0500", hash_original_field = "7D07EDF60BE7D52BF87500AC6D8FE154", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

    private static final long serialVersionUID = 1L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.974 -0500", hash_original_field = "7D34351BBD83B5DAEF7230C2695B3A56", hash_generated_field = "4CD174344F65D3883705CA71073A947D")

    private  BigInteger bigInt;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.977 -0500", hash_original_field = "BA0D3D812FE0526303F6820DD8690E4B", hash_generated_field = "F9D5D1CA2ABDD82810FF1FE80E0268E6")

    private  int scale;

    /**
     * Constructor for <code>SimpleBigDecimal</code>. The value of the
     * constructed <code>SimpleBigDecimal</code> equals <code>bigInt / 
     * 2<sup>scale</sup></code>.
     * @param bigInt The <code>bigInt</code> value parameter.
     * @param scale The scale of the constructed <code>SimpleBigDecimal</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.983 -0500", hash_original_method = "B9E3F8F2D1F0CB50E3B2E06390DB4E90", hash_generated_method = "8BDD79E23FF6BFFCA0B242BFF6CE8ABE")
    
public SimpleBigDecimal(BigInteger bigInt, int scale)
    {
        if (scale < 0)
        {
            throw new IllegalArgumentException("scale may not be negative");
        }

        this.bigInt = bigInt;
        this.scale = scale;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.986 -0500", hash_original_method = "BB0449F02A6AA340B8F9AEE6846C1B89", hash_generated_method = "6C17DF7C076A9066461547D15218BA60")
    
private SimpleBigDecimal(SimpleBigDecimal limBigDec)
    {
        bigInt = limBigDec.bigInt;
        scale = limBigDec.scale;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.988 -0500", hash_original_method = "C3E845BC0594ECAC644A3338EF26C373", hash_generated_method = "0ED9610980B5E3F91BA7C767C6247810")
    
private void checkScale(SimpleBigDecimal b)
    {
        if (scale != b.scale)
        {
            throw new IllegalArgumentException("Only SimpleBigDecimal of " +
                "same scale allowed in arithmetic operations");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.990 -0500", hash_original_method = "6E51DD7AA8BCA4EBA8ECDE4AADAA865C", hash_generated_method = "03708F3A9EB6E1E15A76DBFDD71BA538")
    
public SimpleBigDecimal adjustScale(int newScale)
    {
        if (newScale < 0)
        {
            throw new IllegalArgumentException("scale may not be negative");
        }

        if (newScale == scale)
        {
            return new SimpleBigDecimal(this);
        }

        return new SimpleBigDecimal(bigInt.shiftLeft(newScale - scale),
                newScale);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.993 -0500", hash_original_method = "9B93EEC174A0454ADCF32BC9274B05B6", hash_generated_method = "6482A9A790590E500E40BC112796E670")
    
public SimpleBigDecimal add(SimpleBigDecimal b)
    {
        checkScale(b);
        return new SimpleBigDecimal(bigInt.add(b.bigInt), scale);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.996 -0500", hash_original_method = "1997D6C5826C900035276C18BCFDD9D3", hash_generated_method = "9E2B932AB73B3E7740C4E6C0C28960FB")
    
public SimpleBigDecimal add(BigInteger b)
    {
        return new SimpleBigDecimal(bigInt.add(b.shiftLeft(scale)), scale);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.998 -0500", hash_original_method = "847D70590D3897E07ED49ABD60DD0D05", hash_generated_method = "F776AE6EB72B78E53EF3C7737BEEDBE3")
    
public SimpleBigDecimal negate()
    {
        return new SimpleBigDecimal(bigInt.negate(), scale);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.000 -0500", hash_original_method = "E3DDD4A4133D81CA99A1E7F6CCD5CF2B", hash_generated_method = "D04D2922E40CCB0CB73E9847364C6543")
    
public SimpleBigDecimal subtract(SimpleBigDecimal b)
    {
        return add(b.negate());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.003 -0500", hash_original_method = "5502C0B2E51F8EC346A3B0EA2AFD7881", hash_generated_method = "F86CB2777FF7DDA65DD9538A3BDA226E")
    
public SimpleBigDecimal subtract(BigInteger b)
    {
        return new SimpleBigDecimal(bigInt.subtract(b.shiftLeft(scale)),
                scale);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.005 -0500", hash_original_method = "330628D6579367C0F7404BA6336A3E07", hash_generated_method = "3E54489C0CF2D4DE89D94E08B3C1D057")
    
public SimpleBigDecimal multiply(SimpleBigDecimal b)
    {
        checkScale(b);
        return new SimpleBigDecimal(bigInt.multiply(b.bigInt), scale + scale);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.008 -0500", hash_original_method = "F7512EC811E7F46BF7093DEE1B5F6571", hash_generated_method = "7B6188B0EDA03F608D515FAC2E82CD84")
    
public SimpleBigDecimal multiply(BigInteger b)
    {
        return new SimpleBigDecimal(bigInt.multiply(b), scale);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.011 -0500", hash_original_method = "7E74D1BB6D8D1863DA2FA49A62271B48", hash_generated_method = "4F05A8FF2B662AFD3F8805AE415EA8F8")
    
public SimpleBigDecimal divide(SimpleBigDecimal b)
    {
        checkScale(b);
        BigInteger dividend = bigInt.shiftLeft(scale);
        return new SimpleBigDecimal(dividend.divide(b.bigInt), scale);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.013 -0500", hash_original_method = "F0938440F96DC20B0D4303728A0BA40C", hash_generated_method = "862BB189C2A7F2CBBD20234E7A390C99")
    
public SimpleBigDecimal divide(BigInteger b)
    {
        return new SimpleBigDecimal(bigInt.divide(b), scale);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.015 -0500", hash_original_method = "886004AC1E5A48AB6425DAAA9E6A9AE1", hash_generated_method = "E1B749169D65B7C60E65C5D69C905540")
    
public SimpleBigDecimal shiftLeft(int n)
    {
        return new SimpleBigDecimal(bigInt.shiftLeft(n), scale);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.017 -0500", hash_original_method = "F4FD2CFD498531A1DCCD160DB4A55A56", hash_generated_method = "0D7C53A6456E324ADEE71C98F926EAC6")
    
public int compareTo(SimpleBigDecimal val)
    {
        checkScale(val);
        return bigInt.compareTo(val.bigInt);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.020 -0500", hash_original_method = "DA142CFE02A0CE378556DA61E5DFFA33", hash_generated_method = "AD925AA2B2509F7950884EF6903F7B75")
    
public int compareTo(BigInteger val)
    {
        return bigInt.compareTo(val.shiftLeft(scale));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.022 -0500", hash_original_method = "5A4C971F5322638C8E9F4B26460E4E92", hash_generated_method = "A01FF9C6B6C344A2A385D00D9EE0B9BA")
    
public BigInteger floor()
    {
        return bigInt.shiftRight(scale);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.024 -0500", hash_original_method = "92FC76983B02D95A30B18D6CBD3123C0", hash_generated_method = "BA737C6606899CEC2570D11F771C4D66")
    
public BigInteger round()
    {
        SimpleBigDecimal oneHalf = new SimpleBigDecimal(ECConstants.ONE, 1);
        return add(oneHalf.adjustScale(scale)).floor();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.027 -0500", hash_original_method = "8F98A91102E8EBECCDC59FAE2090EE26", hash_generated_method = "548DD6ACC91FB5C1B47D0F6293D20E60")
    
public int intValue()
    {
        return floor().intValue();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.029 -0500", hash_original_method = "AA9F4F5827911FF9AD2916733B5D4AF6", hash_generated_method = "3720ACE3219E3E39E5924E0B5B40BA84")
    
public long longValue()
    {
        return floor().longValue();
    }
          /* NON-J2ME compliant.
    public double doubleValue()
    {
        return Double.valueOf(toString()).doubleValue();
    }

    public float floatValue()
    {
        return Float.valueOf(toString()).floatValue();
    }
       */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.031 -0500", hash_original_method = "555259738C76709D8C0A4CEB0BA4F05B", hash_generated_method = "EAA1ACF93CBB6AEDE6A2818EB316EBEA")
    
public int getScale()
    {
        return scale;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.035 -0500", hash_original_method = "687FE1E6404530E144AF0CBE5E24BCFF", hash_generated_method = "438634EC5C3409E5F783F2BE8F0699B1")
    
public String toString()
    {
        if (scale == 0)
        {
            return bigInt.toString();
        }

        BigInteger floorBigInt = floor();
        
        BigInteger fract = bigInt.subtract(floorBigInt.shiftLeft(scale));
        if (bigInt.signum() == -1)
        {
            fract = ECConstants.ONE.shiftLeft(scale).subtract(fract);
        }

        if ((floorBigInt.signum() == -1) && (!(fract.equals(ECConstants.ZERO))))
        {
            floorBigInt = floorBigInt.add(ECConstants.ONE);
        }
        String leftOfPoint = floorBigInt.toString();

        char[] fractCharArr = new char[scale];
        String fractStr = fract.toString(2);
        int fractLen = fractStr.length();
        int zeroes = scale - fractLen;
        for (int i = 0; i < zeroes; i++)
        {
            fractCharArr[i] = '0';
        }
        for (int j = 0; j < fractLen; j++)
        {
            fractCharArr[zeroes + j] = fractStr.charAt(j);
        }
        String rightOfPoint = new String(fractCharArr);

        StringBuffer sb = new StringBuffer(leftOfPoint);
        sb.append(".");
        sb.append(rightOfPoint);

        return sb.toString();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.037 -0500", hash_original_method = "31FE8AD014B4F1DD5E50498C47C1658F", hash_generated_method = "114AC49794CFA028086C8D1C325CFA83")
    
public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }

        if (!(o instanceof SimpleBigDecimal))
        {
            return false;
        }

        SimpleBigDecimal other = (SimpleBigDecimal)o;
        return ((bigInt.equals(other.bigInt)) && (scale == other.scale));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:37.039 -0500", hash_original_method = "32368AD05F7F4213F28C81C339A46A5C", hash_generated_method = "9AB25D5AA31E8C9BE223110C9C69105D")
    
public int hashCode()
    {
        return bigInt.hashCode() ^ scale;
    }
}

