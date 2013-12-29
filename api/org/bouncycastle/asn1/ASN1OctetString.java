package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;






public abstract class ASN1OctetString extends ASN1Object implements ASN1OctetStringParser {

    /**
     * return an Octet String from a tagged object.
     *
     * @param obj the tagged object holding the object we want.
     * @param explicit true if the object is meant to be explicitly
     *              tagged false otherwise.
     * @exception IllegalArgumentException if the tagged object cannot
     *              be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.732 -0500", hash_original_method = "6B09C03535BADC8441AE18A4907392FD", hash_generated_method = "288C2ECA0A8FC98EE0BE5E7E385ED22D")
    public static ASN1OctetString getInstance(
        ASN1TaggedObject    obj,
        boolean             explicit)
    {
        DERObject o = obj.getObject();

        if (explicit || o instanceof ASN1OctetString)
        {
            return getInstance(o);
        }
        else
        {
            return BERConstructedOctetString.fromSequence(ASN1Sequence.getInstance(o)); 
        }
    }
    
    /**
     * return an Octet String from the given object.
     *
     * @param obj the object we want converted.
     * @exception IllegalArgumentException if the object cannot be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.733 -0500", hash_original_method = "36DE060E028EC1B3456CC07936016A00", hash_generated_method = "0B7AB7E6451886848EED90CE9644ED51")
    public static ASN1OctetString getInstance(
        Object  obj)
    {
        if (obj == null || obj instanceof ASN1OctetString)
        {
            return (ASN1OctetString)obj;
        }

        // TODO: this needs to be deleted in V2
        if (obj instanceof ASN1TaggedObject)
        {
            return getInstance(((ASN1TaggedObject)obj).getObject());
        }

        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.731 -0500", hash_original_field = "4DFAD1EC9079C516825D3C67F76850BC", hash_generated_field = "4DFAD1EC9079C516825D3C67F76850BC")

    byte[]  string;

    /**
     * @param string the octets making up the octet string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.734 -0500", hash_original_method = "210B116B260CE188F6D07BB4AB757CE1", hash_generated_method = "A3ACCCC6571B7A6B3A22BF7825C2A3E5")
    public ASN1OctetString(
        byte[]  string)
    {
        if (string == null)
        {
            throw new NullPointerException("string cannot be null");
        }
        this.string = string;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.735 -0500", hash_original_method = "654F394A2F1F18AA4253E49ED9387EFC", hash_generated_method = "EF119FE762A9888619113850015D1B82")
    public ASN1OctetString(
        DEREncodable obj)
    {
        try
        {
            this.string = obj.getDERObject().getEncoded(ASN1Encodable.DER);
        }
        catch (IOException e)
        {
            throw new IllegalArgumentException("Error processing object : " + e.toString());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.736 -0500", hash_original_method = "34640A97A031BA78080CEBB6F9EA17E5", hash_generated_method = "2A023B4E9B3850FDD7660FFEAF6A4B0B")
    public InputStream getOctetStream()
    {
        return new ByteArrayInputStream(string);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.737 -0500", hash_original_method = "9D3ECD11646B7B9703C16B797DA8DA2E", hash_generated_method = "78F653929744961BE91ACC82D5AAE280")
    public ASN1OctetStringParser parser()
    {
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.737 -0500", hash_original_method = "C5326C1D0359BDCEF8241B3A70DD591D", hash_generated_method = "94D2EF08EA4C68EF88007C34B3811270")
    public byte[] getOctets()
    {
        return string;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.738 -0500", hash_original_method = "306C0053EB93BF3AE4D12BCDAA093AD0", hash_generated_method = "CADC956D4F879516E430D0F140A862B4")
    public int hashCode()
    {
        return Arrays.hashCode(this.getOctets());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.739 -0500", hash_original_method = "5FE20DA2EBC8E33EF5740C0666CFE34F", hash_generated_method = "5FE20DA2EBC8E33EF5740C0666CFE34F")
    boolean asn1Equals(
        DERObject  o)
    {
        if (!(o instanceof ASN1OctetString))
        {
            return false;
        }

        ASN1OctetString  other = (ASN1OctetString)o;

        return Arrays.areEqual(string, other.string);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.739 -0500", hash_original_method = "D3363286272FDA8D05900543905FFBE8", hash_generated_method = "8623B307B61B507AA76548169F67C95B")
    public DERObject getLoadedObject()
    {
        return this.getDERObject();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.740 -0500", hash_original_method = "A1E289DFE0364C85836C0C8908499825", hash_generated_method = "877693E84D45EBE13EC3671BCE6F2F0C")
    abstract void encode(DEROutputStream out)
        throws IOException;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.741 -0500", hash_original_method = "A6F4AE428E861451DA18F2BDC0B16A3E", hash_generated_method = "3A62F662427472D9A778EE9E35AA01D0")
    public String toString()
    {
      return "#"+new String(Hex.encode(string));
    }

    
}

