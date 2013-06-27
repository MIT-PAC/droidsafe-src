package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERTaggedObject;

public class AttCertIssuer extends ASN1Encodable implements ASN1Choice {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.789 -0400", hash_original_field = "BE8F80182E0C983916DA7338C2C1C040", hash_generated_field = "0613618850853D8432B3C1A1BFC732A1")

    ASN1Encodable obj;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.790 -0400", hash_original_field = "EFC75EED8DDBFE20EC53A6ED38038311", hash_generated_field = "7A86CED0F063083B43656D3132F9D6B0")

    DERObject choiceObj;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.790 -0400", hash_original_method = "0FB35C20300C210362F151B3AD34290C", hash_generated_method = "16EA2BEC16866BF71D318015D3781AEA")
    public  AttCertIssuer(
        GeneralNames  names) {
        obj = names;
        choiceObj = obj.getDERObject();
        // ---------- Original Method ----------
        //obj = names;
        //choiceObj = obj.getDERObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.790 -0400", hash_original_method = "00B10A8614D975711EAEB4C98ED18D40", hash_generated_method = "BBC4E0FAA2339E503A4A984047E4A1BD")
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

    
        public static AttCertIssuer getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(obj.getObject());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.791 -0400", hash_original_method = "B549CE271C623D3D9A432BB134D69900", hash_generated_method = "A80496179CE801A3A2143F0ED2F800D0")
    public ASN1Encodable getIssuer() {
        ASN1Encodable varB4EAC82CA7396A68D541C85D26508E83_1880221369 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1880221369 = obj;
        varB4EAC82CA7396A68D541C85D26508E83_1880221369.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1880221369;
        // ---------- Original Method ----------
        //return obj;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.791 -0400", hash_original_method = "6A55D157378C948D2010903EFE111848", hash_generated_method = "674C709330B700682919A9DF48D9BEA1")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_964803315 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_964803315 = choiceObj;
        varB4EAC82CA7396A68D541C85D26508E83_964803315.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_964803315;
        // ---------- Original Method ----------
        //return choiceObj;
    }

    
}

