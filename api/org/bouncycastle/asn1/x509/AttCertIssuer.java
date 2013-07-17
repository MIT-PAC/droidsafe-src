package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERTaggedObject;

public class AttCertIssuer extends ASN1Encodable implements ASN1Choice {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.539 -0400", hash_original_field = "BE8F80182E0C983916DA7338C2C1C040", hash_generated_field = "0613618850853D8432B3C1A1BFC732A1")

    ASN1Encodable obj;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.539 -0400", hash_original_field = "EFC75EED8DDBFE20EC53A6ED38038311", hash_generated_field = "7A86CED0F063083B43656D3132F9D6B0")

    DERObject choiceObj;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.540 -0400", hash_original_method = "0FB35C20300C210362F151B3AD34290C", hash_generated_method = "16EA2BEC16866BF71D318015D3781AEA")
    public  AttCertIssuer(
        GeneralNames  names) {
        obj = names;
        choiceObj = obj.getDERObject();
        // ---------- Original Method ----------
        //obj = names;
        //choiceObj = obj.getDERObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.541 -0400", hash_original_method = "00B10A8614D975711EAEB4C98ED18D40", hash_generated_method = "BBC4E0FAA2339E503A4A984047E4A1BD")
    public  AttCertIssuer(
        V2Form  v2Form) {
        obj = v2Form;
        choiceObj = new DERTaggedObject(false, 0, obj);
        // ---------- Original Method ----------
        //obj = v2Form;
        //choiceObj = new DERTaggedObject(false, 0, obj);
    }

    
    public static AttCertIssuer getInstance(
        Object  obj) {
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

    
    @DSModeled(DSC.SPEC)
    public static AttCertIssuer getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(obj.getObject());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.542 -0400", hash_original_method = "B549CE271C623D3D9A432BB134D69900", hash_generated_method = "EDFE3CF2A254A096FC2B4525C11624F3")
    public ASN1Encodable getIssuer() {
ASN1Encodable var2FDE1120F80AA4E8798ECDBDB1C0E85C_694791732 =         obj;
        var2FDE1120F80AA4E8798ECDBDB1C0E85C_694791732.addTaint(taint);
        return var2FDE1120F80AA4E8798ECDBDB1C0E85C_694791732;
        // ---------- Original Method ----------
        //return obj;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.542 -0400", hash_original_method = "6A55D157378C948D2010903EFE111848", hash_generated_method = "CDAECC2EB562E7FDEE23971A9D8A3FA5")
    public DERObject toASN1Object() {
DERObject var571917243FE92790CF9D7FC105A4CF06_344220108 =         choiceObj;
        var571917243FE92790CF9D7FC105A4CF06_344220108.addTaint(taint);
        return var571917243FE92790CF9D7FC105A4CF06_344220108;
        // ---------- Original Method ----------
        //return choiceObj;
    }

    
}

