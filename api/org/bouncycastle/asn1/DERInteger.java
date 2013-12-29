package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.math.BigInteger;

import org.bouncycastle.util.Arrays;






public class DERInteger extends ASN1Object {

    /**
     * return an integer from the passed in object
     *
     * @exception IllegalArgumentException if the object cannot be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.841 -0500", hash_original_method = "F9CDE53FA3BF888D04BAC088CBA314F4", hash_generated_method = "95833BE1209B58F0A08F8EF27F61B009")
    public static DERInteger getInstance(
        Object  obj)
    {
        if (obj == null || obj instanceof DERInteger)
        {
            return (DERInteger)obj;
        }

        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    /**
     * return an Integer from a tagged object.
     *
     * @param obj the tagged object holding the object we want
     * @param explicit true if the object is meant to be explicitly
     *              tagged false otherwise.
     * @exception IllegalArgumentException if the tagged object cannot
     *               be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.842 -0500", hash_original_method = "65E73A77782C9D6D1DC4F812E4C83134", hash_generated_method = "D745C0228ACA321CBD2795FFA6C2BD51")
    public static DERInteger getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        DERObject o = obj.getObject();

        if (explicit || o instanceof DERInteger)
        {
            return getInstance(o);
        }
        else
        {
            return new ASN1Integer(ASN1OctetString.getInstance(obj.getObject()).getOctets());
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.840 -0500", hash_original_field = "AB97A4156FC1CC1DAF26375194010FF1", hash_generated_field = "AB97A4156FC1CC1DAF26375194010FF1")

    byte[]      bytes;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.842 -0500", hash_original_method = "5201B112432D21625783310AA9CEC395", hash_generated_method = "0E2A83292C0D71A78D3919BBF358F509")
    public DERInteger(
        int         value)
    {
        bytes = BigInteger.valueOf(value).toByteArray();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.843 -0500", hash_original_method = "52A85FB71F259AF94A4C569903FA35A3", hash_generated_method = "0B80CBE0C02167DAB69FB5B4A20240AC")
    public DERInteger(
        BigInteger   value)
    {
        bytes = value.toByteArray();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.844 -0500", hash_original_method = "742445D1CBEB8EC33F0452B05DE17699", hash_generated_method = "7CE4D3D92C4CD75A445CA797C3DF183B")
    public DERInteger(
        byte[]   bytes)
    {
        this.bytes = bytes;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.845 -0500", hash_original_method = "9CD9452AB0CD35F4B73E8FBD8DC6F0C8", hash_generated_method = "3C97FB31F711F8438DD2BD49E656445F")
    public BigInteger getValue()
    {
        return new BigInteger(bytes);
    }

    /**
     * in some cases positive values get crammed into a space,
     * that's not quite big enough...
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.846 -0500", hash_original_method = "71BDB36FFF593CAF4C9E79EFECF43EBD", hash_generated_method = "E56CA4EC540EC87713C71D93662E37D2")
    public BigInteger getPositiveValue()
    {
        return new BigInteger(1, bytes);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.847 -0500", hash_original_method = "01662A631E5ACE6C7726FCC0828E9E63", hash_generated_method = "01662A631E5ACE6C7726FCC0828E9E63")
    void encode(
        DEROutputStream out)
        throws IOException
    {
        out.writeEncoded(INTEGER, bytes);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.847 -0500", hash_original_method = "473F358B008FFCD851D487BD1750243E", hash_generated_method = "E5139E02A1A214A723B907B74A6197FD")
    public int hashCode()
    {
         int     value = 0;
 
         for (int i = 0; i != bytes.length; i++)
         {
             value ^= (bytes[i] & 0xff) << (i % 4);
         }
 
         return value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.848 -0500", hash_original_method = "A031FF36E08BD1C92CE6416060813BEC", hash_generated_method = "A031FF36E08BD1C92CE6416060813BEC")
    boolean asn1Equals(
        DERObject  o)
    {
        if (!(o instanceof DERInteger))
        {
            return false;
        }

        DERInteger other = (DERInteger)o;

        return Arrays.areEqual(bytes, other.bytes);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.849 -0500", hash_original_method = "EFB82D2D11830675F5DB319D1D1561C4", hash_generated_method = "2EB7D252DFFB915E0989809C943E864A")
    public String toString()
    {
      return getValue().toString();
    }

    
}

