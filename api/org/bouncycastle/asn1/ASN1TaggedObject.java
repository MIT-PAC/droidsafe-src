package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;






public abstract class ASN1TaggedObject extends ASN1Object implements ASN1TaggedObjectParser {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.126 -0500", hash_original_method = "B10D1DEB1333C8895ED68C0DE4D64E52", hash_generated_method = "CF1AC47EE66EE08B989C6DF373014CD3")
    
static public ASN1TaggedObject getInstance(
        ASN1TaggedObject    obj,
        boolean             explicit)
    {
        if (explicit)
        {
            return (ASN1TaggedObject)obj.getObject();
        }

        throw new IllegalArgumentException("implicitly tagged tagged object");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.128 -0500", hash_original_method = "82C02E87071271D1F62BCD4C0AA46A8B", hash_generated_method = "6CC3B653BD37022DD6F229D6D930D9A5")
    
static public ASN1TaggedObject getInstance(
        Object obj) 
    {
        if (obj == null || obj instanceof ASN1TaggedObject) 
        {
                return (ASN1TaggedObject)obj;
        }

        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.117 -0500", hash_original_field = "FA62A32896A7308D5C3ACC05B62DCB16", hash_generated_field = "FA62A32896A7308D5C3ACC05B62DCB16")

    int             tagNo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.120 -0500", hash_original_field = "A3C5A9AF358FD2BFCBE0C2693903BB82", hash_generated_field = "A3C5A9AF358FD2BFCBE0C2693903BB82")

    boolean         empty = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.121 -0500", hash_original_field = "83237803BCA36CFD769F62D64B3B892F", hash_generated_field = "83237803BCA36CFD769F62D64B3B892F")

    boolean         explicit = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.124 -0500", hash_original_field = "27B23743F26E5B0F431105D2841F3A3B", hash_generated_field = "27B23743F26E5B0F431105D2841F3A3B")

    DEREncodable    obj = null;

    /**
     * Create a tagged object in the explicit style.
     * 
     * @param tagNo the tag number for this object.
     * @param obj the tagged object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.131 -0500", hash_original_method = "00E51A508FDFE6A586E84CD8A518A30A", hash_generated_method = "A915928119868388C6DA10DB89253826")
    
public ASN1TaggedObject(
        int             tagNo,
        DEREncodable    obj)
    {
        this.explicit = true;
        this.tagNo = tagNo;
        this.obj = obj;
    }

    /**
     * Create a tagged object with the style given by the value of explicit.
     * <p>
     * If the object implements ASN1Choice the tag style will always be changed
     * to explicit in accordance with the ASN.1 encoding rules.
     * </p>
     * @param explicit true if the object is explicitly tagged.
     * @param tagNo the tag number for this object.
     * @param obj the tagged object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.134 -0500", hash_original_method = "9F7BD38C3B2D03C6929A27397833F44D", hash_generated_method = "F945546D0C43A9E9268B7B1207F23901")
    
public ASN1TaggedObject(
        boolean         explicit,
        int             tagNo,
        DEREncodable    obj)
    {
        if (obj instanceof ASN1Choice)
        {
            this.explicit = true;
        }
        else
        {
            this.explicit = explicit;
        }
        
        this.tagNo = tagNo;
        this.obj = obj;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.137 -0500", hash_original_method = "68AE9CCB33F87A12C7FA4AA63E83BFDC", hash_generated_method = "68AE9CCB33F87A12C7FA4AA63E83BFDC")
    
boolean asn1Equals(
        DERObject o)
    {
        if (!(o instanceof ASN1TaggedObject))
        {
            return false;
        }
        
        ASN1TaggedObject other = (ASN1TaggedObject)o;
        
        if (tagNo != other.tagNo || empty != other.empty || explicit != other.explicit)
        {
            return false;
        }
        
        if(obj == null)
        {
            if (other.obj != null)
            {
                return false;
            }
        }
        else
        {
            if (!(obj.getDERObject().equals(other.obj.getDERObject())))
            {
                return false;
            }
        }
        
        return true;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.139 -0500", hash_original_method = "996889D0C05CC309872B8EE7FF5C4369", hash_generated_method = "07979806C0C20ADDDA772A11324248EC")
    
public int hashCode()
    {
        int code = tagNo;

        // TODO: actually this is wrong - the problem is that a re-encoded
        // object may end up with a different hashCode due to implicit
        // tagging. As implicit tagging is ambiguous if a sequence is involved
        // it seems the only correct method for both equals and hashCode is to
        // compare the encodings...
        if (obj != null)
        {
            code ^= obj.hashCode();
        }

        return code;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.142 -0500", hash_original_method = "CB42AFB8AF1DB9A93243A50229C66A0D", hash_generated_method = "DABB94A5116DC7589A63C7B0A88E4699")
    
public int getTagNo()
    {
        return tagNo;
    }

    /**
     * return whether or not the object may be explicitly tagged. 
     * <p>
     * Note: if the object has been read from an input stream, the only
     * time you can be sure if isExplicit is returning the true state of
     * affairs is if it returns false. An implicitly tagged object may appear
     * to be explicitly tagged, so you need to understand the context under
     * which the reading was done as well, see getObject below.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.144 -0500", hash_original_method = "AF6534B2BC536C6B2446F0C361A4EC15", hash_generated_method = "C5352AA7DF0C00ED1852C045A2A07019")
    
public boolean isExplicit()
    {
        return explicit;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.146 -0500", hash_original_method = "A3A283EA275283949A16122176F95537", hash_generated_method = "8EC7CB9A70495B8A7A532D0FAAB166D0")
    
public boolean isEmpty()
    {
        return empty;
    }

    /**
     * return whatever was following the tag.
     * <p>
     * Note: tagged objects are generally context dependent if you're
     * trying to extract a tagged object you should be going via the
     * appropriate getInstance method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.148 -0500", hash_original_method = "71996C10B1D68BDB26DD531066806FCB", hash_generated_method = "2D25E3A4D9CA0CCEEE0E62B9CFDEC97D")
    
public DERObject getObject()
    {
        if (obj != null)
        {
            return obj.getDERObject();
        }

        return null;
    }

    /**
     * Return the object held in this tagged object as a parser assuming it has
     * the type of the passed in tag. If the object doesn't have a parser
     * associated with it, the base object is returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.151 -0500", hash_original_method = "45814A62D9590995EE34A14DC507BC36", hash_generated_method = "1222D41CD8670E178BC4D4A7883F57A7")
    
public DEREncodable getObjectParser(
        int     tag,
        boolean isExplicit)
    {
        switch (tag)
        {
        case DERTags.SET:
            return ASN1Set.getInstance(this, isExplicit).parser();
        case DERTags.SEQUENCE:
            return ASN1Sequence.getInstance(this, isExplicit).parser();
        case DERTags.OCTET_STRING:
            return ASN1OctetString.getInstance(this, isExplicit).parser();
        }

        if (isExplicit)
        {
            return getObject();
        }

        throw new RuntimeException("implicit tagging not implemented for tag: " + tag);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.153 -0500", hash_original_method = "D3363286272FDA8D05900543905FFBE8", hash_generated_method = "8623B307B61B507AA76548169F67C95B")
    
public DERObject getLoadedObject()
    {
        return this.getDERObject();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.156 -0500", hash_original_method = "A1E289DFE0364C85836C0C8908499825", hash_generated_method = "877693E84D45EBE13EC3671BCE6F2F0C")
    
abstract void encode(DEROutputStream  out)
        throws IOException;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.158 -0500", hash_original_method = "5750585E0FAF2C7F60E10F96F297B6DF", hash_generated_method = "103ACC5A0DA98A573B1996BD5781ECB8")
    
public String toString()
    {
        return "[" + tagNo + "]" + obj;
    }

    
}

