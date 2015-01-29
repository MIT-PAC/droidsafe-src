package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERTaggedObject;






public class AttCertIssuer extends ASN1Encodable implements ASN1Choice {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.770 -0500", hash_original_method = "2F8858F5DE6ECFCC121A6ECE4BE55FAB", hash_generated_method = "F4E2BBFDEC11298572704914612467E7")
    
public static AttCertIssuer getInstance(
        Object  obj)
    {
        if (obj instanceof AttCertIssuer)
        {
            return (AttCertIssuer)obj;
        }
        else if (obj instanceof V2Form)
        {
            return new AttCertIssuer(V2Form.getInstance(obj));
        }
        else if (obj instanceof GeneralNames)
        {
            return new AttCertIssuer((GeneralNames)obj);
        }
        else if (obj instanceof ASN1TaggedObject)
        {
            return new AttCertIssuer(V2Form.getInstance((ASN1TaggedObject)obj, false));
        }
        else if (obj instanceof ASN1Sequence)
        {
            return new AttCertIssuer(GeneralNames.getInstance(obj));
        }

        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.773 -0500", hash_original_method = "50EB10983A327B84FF827D204CCF992A", hash_generated_method = "9B18C8574A9967C936A260CF5A65E298")
    
public static AttCertIssuer getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        return getInstance(obj.getObject()); // must be explicitly tagged
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.765 -0500", hash_original_field = "0613618850853D8432B3C1A1BFC732A1", hash_generated_field = "0613618850853D8432B3C1A1BFC732A1")

    ASN1Encodable   obj;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.767 -0500", hash_original_field = "7A86CED0F063083B43656D3132F9D6B0", hash_generated_field = "7A86CED0F063083B43656D3132F9D6B0")

    DERObject       choiceObj;

    /**
     * Don't use this one if you are trying to be RFC 3281 compliant.
     * Use it for v1 attribute certificates only.
     * 
     * @param names our GeneralNames structure
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.775 -0500", hash_original_method = "0FB35C20300C210362F151B3AD34290C", hash_generated_method = "86B0B71615F5ABBB5F40E3D0C93CFFD7")
    
public AttCertIssuer(
        GeneralNames  names)
    {
        obj = names;
        choiceObj = obj.getDERObject();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.778 -0500", hash_original_method = "00B10A8614D975711EAEB4C98ED18D40", hash_generated_method = "024B60BF653E505F445A2B8B58D1A101")
    
public AttCertIssuer(
        V2Form  v2Form)
    {
        obj = v2Form;
        choiceObj = new DERTaggedObject(false, 0, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.780 -0500", hash_original_method = "B549CE271C623D3D9A432BB134D69900", hash_generated_method = "2C1412B66084E65250F8E3ACEF655170")
    
public ASN1Encodable getIssuer()
    {
        return obj;
    }
    
    /**
     * Produce an object suitable for an ASN1OutputStream.
     * <pre>
     *  AttCertIssuer ::= CHOICE {
     *       v1Form   GeneralNames,  -- MUST NOT be used in this
     *                               -- profile
     *       v2Form   [0] V2Form     -- v2 only
     *  }
     * </pre>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.783 -0500", hash_original_method = "6A55D157378C948D2010903EFE111848", hash_generated_method = "CECF60C35AA80568DF6B9D6642D24A5B")
    
public DERObject toASN1Object()
    {
        return choiceObj;
    }

    
}

