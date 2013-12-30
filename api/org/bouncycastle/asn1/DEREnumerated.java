package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.math.BigInteger;

import org.bouncycastle.util.Arrays;






public class DEREnumerated extends ASN1Object {

    /**
     * return an integer from the passed in object
     *
     * @exception IllegalArgumentException if the object cannot be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.437 -0500", hash_original_method = "5BC8F220C44E187EC01A5EA2B16F4349", hash_generated_method = "FBA16E6864C853B49E7FB002A8B9126E")
    
public static DEREnumerated getInstance(
        Object  obj)
    {
        if (obj == null || obj instanceof DEREnumerated)
        {
            return (DEREnumerated)obj;
        }

        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    /**
     * return an Enumerated from a tagged object.
     *
     * @param obj the tagged object holding the object we want
     * @param explicit true if the object is meant to be explicitly
     *              tagged false otherwise.
     * @exception IllegalArgumentException if the tagged object cannot
     *               be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.439 -0500", hash_original_method = "D49EC344EFD928ED887B967EA7DC5448", hash_generated_method = "2AE72E88238D48CAE54DEFF5FDF5F424")
    
public static DEREnumerated getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        DERObject o = obj.getObject();

        if (explicit || o instanceof DEREnumerated)
        {
            return getInstance(o);
        }
        else
        {
            return new DEREnumerated(((ASN1OctetString)o).getOctets());
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.434 -0500", hash_original_field = "AB97A4156FC1CC1DAF26375194010FF1", hash_generated_field = "AB97A4156FC1CC1DAF26375194010FF1")

    byte[]      bytes;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.442 -0500", hash_original_method = "B36B300F3CB5F32541367868C7626677", hash_generated_method = "74167A0C76D7B350B4903E8C3FD1F267")
    
public DEREnumerated(
        int         value)
    {
        bytes = BigInteger.valueOf(value).toByteArray();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.444 -0500", hash_original_method = "678F1FE65267358F51A86F36E09F17C8", hash_generated_method = "05DB6019C1C0B3EC49815463CE4DDF95")
    
public DEREnumerated(
        BigInteger   value)
    {
        bytes = value.toByteArray();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.447 -0500", hash_original_method = "AD7320D92755415772C23A44F11EC5AC", hash_generated_method = "2B3E448631E23D8CE491C82214FCE3D1")
    
public DEREnumerated(
        byte[]   bytes)
    {
        this.bytes = bytes;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.449 -0500", hash_original_method = "9CD9452AB0CD35F4B73E8FBD8DC6F0C8", hash_generated_method = "3C97FB31F711F8438DD2BD49E656445F")
    
public BigInteger getValue()
    {
        return new BigInteger(bytes);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.451 -0500", hash_original_method = "F1F5D8639E81BFE0F662E5D9DEEDCE8E", hash_generated_method = "F1F5D8639E81BFE0F662E5D9DEEDCE8E")
    
void encode(
        DEROutputStream out)
        throws IOException
    {
        out.writeEncoded(ENUMERATED, bytes);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.453 -0500", hash_original_method = "87F9EE40A630F0723068642FAAE69D4D", hash_generated_method = "87F9EE40A630F0723068642FAAE69D4D")
    
boolean asn1Equals(
        DERObject  o)
    {
        if (!(o instanceof DEREnumerated))
        {
            return false;
        }

        DEREnumerated other = (DEREnumerated)o;

        return Arrays.areEqual(this.bytes, other.bytes);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.455 -0500", hash_original_method = "ECC4B202736A567045152AD0D498E31B", hash_generated_method = "68A737718BE4129A2E38665F9FD0A635")
    
public int hashCode()
    {
        return Arrays.hashCode(bytes);
    }

    
}

