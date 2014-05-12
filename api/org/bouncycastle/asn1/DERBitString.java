package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.bouncycastle.util.Arrays;

public class DERBitString extends ASN1Object implements DERString {

    /**
     * return the correct number of pad bits for a bit string defined in
     * a 32 bit constant
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.126 -0500", hash_original_method = "396013FF2057FF66C2060FF38FC87A87", hash_generated_method = "475D43472288FF111C2AA36D293A1304")
    
static protected int getPadBits(
        int bitString)
    {
        int val = 0;
        for (int i = 3; i >= 0; i--) 
        {
            //
            // this may look a little odd, but if it isn't done like this pre jdk1.2
            // JVM's break!
            //
            if (i != 0)
            {
                if ((bitString >> (i * 8)) != 0) 
                {
                    val = (bitString >> (i * 8)) & 0xFF;
                    break;
                }
            }
            else
            {
                if (bitString != 0)
                {
                    val = bitString & 0xFF;
                    break;
                }
            }
        }
 
        if (val == 0)
        {
            return 7;
        }

        int bits = 1;

        while (((val <<= 1) & 0xFF) != 0)
        {
            bits++;
        }

        return 8 - bits;
    }

    /**
     * return the correct number of bytes for a bit string defined in
     * a 32 bit constant
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.128 -0500", hash_original_method = "607C1312FA510FD34497089AECB9D86F", hash_generated_method = "1F5FCEB2DE0344E57BC8CDCFBD1E0233")
    
static protected byte[] getBytes(int bitString)
    {
        int bytes = 4;
        for (int i = 3; i >= 1; i--)
        {
            if ((bitString & (0xFF << (i * 8))) != 0)
            {
                break;
            }
            bytes--;
        }
        
        byte[] result = new byte[bytes];
        for (int i = 0; i < bytes; i++)
        {
            result[i] = (byte) ((bitString >> (i * 8)) & 0xFF);
        }

        return result;
    }

    /**
     * return a Bit String from the passed in object
     *
     * @exception IllegalArgumentException if the object cannot be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.131 -0500", hash_original_method = "DABD9FEFA9DBC7DEDC6966D1C5CEFDEA", hash_generated_method = "45C776EF3680DBFBA9FFAC9562DB86DD")
    
public static DERBitString getInstance(
        Object  obj)
    {
        if (obj == null || obj instanceof DERBitString)
        {
            return (DERBitString)obj;
        }

        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    /**
     * return a Bit String from a tagged object.
     *
     * @param obj the tagged object holding the object we want
     * @param explicit true if the object is meant to be explicitly
     *              tagged false otherwise.
     * @exception IllegalArgumentException if the tagged object cannot
     *               be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.133 -0500", hash_original_method = "6238F778612E11A86A3F263DAA4B1BC9", hash_generated_method = "7DE743676C02E8369BAF412190C8A80C")
    
public static DERBitString getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        DERObject o = obj.getObject();

        if (explicit || o instanceof DERBitString)
        {
            return getInstance(o);
        }
        else
        {
            return fromOctetString(((ASN1OctetString)o).getOctets());
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.166 -0500", hash_original_method = "135F4859410EF7167EE149EE7B9775D6", hash_generated_method = "9963BCBE953BEEDC2CD0561F98B395B2")
    
static DERBitString fromOctetString(byte[] bytes)
    {
        if (bytes.length < 1)
        {
            throw new IllegalArgumentException("truncated BIT STRING detected");
        }

        int padBits = bytes[0];
        byte[] data = new byte[bytes.length - 1];

        if (data.length != 0)
        {
            System.arraycopy(bytes, 1, data, 0, bytes.length - 1);
        }

        return new DERBitString(data, padBits);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.119 -0500", hash_original_field = "93CC79680ED66E97963A0FAE96507423", hash_generated_field = "4F8597255A63B9818A65C2C1EBCFBC6D")

    private static final char[]  table = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.121 -0500", hash_original_field = "B330DF564CD90A5498A9E4F0AB344BB9", hash_generated_field = "FE472066F06E7EB612EB3FC3B9912573")
    
    protected byte[]      data;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.123 -0500", hash_original_field = "DBDABC1E0B2C1B71214F1769BC7880B1", hash_generated_field = "133CFF098A8491F27C40D29FAE7800EB")

    protected int         padBits;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.136 -0500", hash_original_method = "26EE121790982A47721F4E882F2E6D1B", hash_generated_method = "4848F43D58109EB4745D55C1E95F52E9")
    
protected DERBitString(
        byte    data,
        int     padBits)
    {
        this.data = new byte[1];
        this.data[0] = data;
        this.padBits = padBits;
    }

    /**
     * @param data the octets making up the bit string.
     * @param padBits the number of extra bits at the end of the string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.139 -0500", hash_original_method = "FFBC3727DD76CEA695B58D8154C3FE06", hash_generated_method = "BEDD5BD84538CE98DDB9AF3FB0BADE3C")
    
public DERBitString(
        byte[]  data,
        int     padBits)
    {
        this.data = data;
        this.padBits = padBits;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.142 -0500", hash_original_method = "B944CF7FA9085EE991D9A8B7F428DA93", hash_generated_method = "D651EFEE6512523E26487F417EF453AA")
    
public DERBitString(
        byte[]  data)
    {
        this(data, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.144 -0500", hash_original_method = "CADA9C81F27161B70BDA506AB461E094", hash_generated_method = "D5885E6A7BEFF0A3AAE31D453F515B9C")
    
public DERBitString(
        DEREncodable  obj)
    {
        try
        {
            this.data = obj.getDERObject().getEncoded(ASN1Encodable.DER);
            this.padBits = 0;
        }
        catch (IOException e)
        {
            throw new IllegalArgumentException("Error processing object : " + e.toString());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.147 -0500", hash_original_method = "A347A6B90A5D4D940F0721005973D58D", hash_generated_method = "3C7438C8A4069E5C199E2D48F79B0806")
    
public byte[] getBytes()
    {
        return data;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.149 -0500", hash_original_method = "417B58F84A036F27149A8DCAE574FCD8", hash_generated_method = "18C43C40EE5C41D15340F6B757F76C28")
    
public int getPadBits()
    {
        return padBits;
    }

    /**
     * @return the value of the bit string as an int (truncating if necessary)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.152 -0500", hash_original_method = "4C040E65E95E154142FD7B39A853E86F", hash_generated_method = "26A3F150E85D328A465BDB627D3B08FE")
    
public int intValue()
    {
        int value = 0;
        
        for (int i = 0; i != data.length && i != 4; i++)
        {
            value |= (data[i] & 0xff) << (8 * i);
        }
        
        return value;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.154 -0500", hash_original_method = "CB83D166557B7D270FFD9D836925EA70", hash_generated_method = "CB83D166557B7D270FFD9D836925EA70")
    
void encode(
        DEROutputStream  out)
        throws IOException
    {
        byte[]  bytes = new byte[getBytes().length + 1];

        bytes[0] = (byte)getPadBits();
        System.arraycopy(getBytes(), 0, bytes, 1, bytes.length - 1);

        out.writeEncoded(BIT_STRING, bytes);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.156 -0500", hash_original_method = "0FA775A3BA483D59A323D752B0FD6DA8", hash_generated_method = "50DA926AE106364A3C95BC47DCB6ADCC")
    
public int hashCode()
    {
        return padBits ^ Arrays.hashCode(data);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.158 -0500", hash_original_method = "6A45C831F2BEA87730EF6E467856CBF1", hash_generated_method = "340DA8D604436855C8653FC5193FE3B4")
    
protected boolean asn1Equals(
        DERObject  o)
    {
        if (!(o instanceof DERBitString))
        {
            return false;
        }

        DERBitString other = (DERBitString)o;

        return this.padBits == other.padBits
            && Arrays.areEqual(this.data, other.data);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.161 -0500", hash_original_method = "C8AC92EF6B951363C15B3CD0868FB9EA", hash_generated_method = "625EEA01CAE8F289CBA884F5FAC598F2")
    
public String getString()
    {
        StringBuffer          buf = new StringBuffer("#");
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        ASN1OutputStream      aOut = new ASN1OutputStream(bOut);
        
        try
        {
            aOut.writeObject(this);
        }
        catch (IOException e)
        {
           throw new RuntimeException("internal error encoding BitString");
        }
        
        byte[]    string = bOut.toByteArray();
        
        for (int i = 0; i != string.length; i++)
        {
            buf.append(table[(string[i] >>> 4) & 0xf]);
            buf.append(table[string[i] & 0xf]);
        }
        
        return buf.toString();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.163 -0500", hash_original_method = "79F534E26CC8382FAA66B4080878D117", hash_generated_method = "797E25846E0761235375940A5544E1B9")
    
public String toString()
    {
        return getString();
    }
}

