package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class V2Form extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.131 -0400", hash_original_field = "FBB85711FD06EA9038A0499C78C0F229", hash_generated_field = "27D5E6F2AF34AE0B03A90D9446FD0637")

    GeneralNames issuerName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.131 -0400", hash_original_field = "C3C2EC65CAD3747AA642E945B7F46D09", hash_generated_field = "BFE641AC9AE66327CCBC4859503216E4")

    IssuerSerial baseCertificateID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.131 -0400", hash_original_field = "035CD4986BAFC5E11EA88A19D8C042C6", hash_generated_field = "0DFE757401959316759693C6B709966B")

    ObjectDigestInfo objectDigestInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.132 -0400", hash_original_method = "58484080C9CD52E375DC7B3D30D61BD6", hash_generated_method = "F65B38D63267FE602DE1A3694A5C6E35")
    public  V2Form(
        GeneralNames    issuerName) {
        this.issuerName = issuerName;
        // ---------- Original Method ----------
        //this.issuerName = issuerName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.144 -0400", hash_original_method = "A1182A2D0637CA133E8A6FD666F8BDBF", hash_generated_method = "6BC505DAA16973C89CD49E61EE08ADE3")
    public  V2Form(
        ASN1Sequence seq) {
        {
            boolean var889BC8C4BD2008ADA32540CA2FE285A5_1790233940 = (seq.size() > 3);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad sequence size: " + seq.size());
            } //End block
        } //End collapsed parenthetic
        int index;
        index = 0;
        {
            boolean var32013F16F56DCA4DF1927FA703313B52_961898464 = (!(seq.getObjectAt(0) instanceof ASN1TaggedObject));
            {
                this.issuerName = GeneralNames.getInstance(seq.getObjectAt(0));
            } //End block
        } //End collapsed parenthetic
        {
            int i;
            i = index;
            boolean varA93A8909C6B18B3F6367766A0DBBDCF3_916470463 = (i != seq.size());
            {
                ASN1TaggedObject o;
                o = ASN1TaggedObject.getInstance(seq.getObjectAt(i));
                {
                    boolean varA2F9D8C6F2D82D772FD1DF33D746C524_578556036 = (o.getTagNo() == 0);
                    {
                        baseCertificateID = IssuerSerial.getInstance(o, false);
                    } //End block
                    {
                        boolean var016B5BB97924CB682C1367D5D572FA29_366528691 = (o.getTagNo() == 1);
                        {
                            objectDigestInfo = ObjectDigestInfo.getInstance(o, false);
                        } //End block
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad tag number: "
                        + o.getTagNo());
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static V2Form getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    
        public static V2Form getInstance(
        Object  obj) {
        if (obj == null || obj instanceof V2Form)
        {
            return (V2Form)obj;
        }
        else if (obj instanceof ASN1Sequence)
        {
            return new V2Form((ASN1Sequence)obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.145 -0400", hash_original_method = "55884F30CB8A32C82BBC3BF8E06EF566", hash_generated_method = "E433FB8BCC89A1877E7471D365135A9B")
    public GeneralNames getIssuerName() {
        GeneralNames varB4EAC82CA7396A68D541C85D26508E83_96668225 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_96668225 = issuerName;
        varB4EAC82CA7396A68D541C85D26508E83_96668225.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_96668225;
        // ---------- Original Method ----------
        //return issuerName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.146 -0400", hash_original_method = "0056368CFDBAD05E126455DF61F0B2E7", hash_generated_method = "DA80F6979633EC122E6FC337608C7A0A")
    public IssuerSerial getBaseCertificateID() {
        IssuerSerial varB4EAC82CA7396A68D541C85D26508E83_1004609855 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1004609855 = baseCertificateID;
        varB4EAC82CA7396A68D541C85D26508E83_1004609855.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1004609855;
        // ---------- Original Method ----------
        //return baseCertificateID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.146 -0400", hash_original_method = "BF432F04B889EC14E618C49342356E7A", hash_generated_method = "54CD928BB49E57CAA729E94EA389ACAE")
    public ObjectDigestInfo getObjectDigestInfo() {
        ObjectDigestInfo varB4EAC82CA7396A68D541C85D26508E83_1851033004 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1851033004 = objectDigestInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1851033004.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1851033004;
        // ---------- Original Method ----------
        //return objectDigestInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.147 -0400", hash_original_method = "136E61B408FA241B2CCB57655BDD036B", hash_generated_method = "98E8C344D0E940C32016BDB1F8834F0D")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_2029646049 = null; //Variable for return #1
        ASN1EncodableVector v;
        v = new ASN1EncodableVector();
        {
            v.add(issuerName);
        } //End block
        {
            v.add(new DERTaggedObject(false, 0, baseCertificateID));
        } //End block
        {
            v.add(new DERTaggedObject(false, 1, objectDigestInfo));
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2029646049 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_2029646049.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2029646049;
        // ---------- Original Method ----------
        //ASN1EncodableVector  v = new ASN1EncodableVector();
        //if (issuerName != null)
        //{
            //v.add(issuerName);
        //}
        //if (baseCertificateID != null)
        //{
            //v.add(new DERTaggedObject(false, 0, baseCertificateID));
        //}
        //if (objectDigestInfo != null)
        //{
            //v.add(new DERTaggedObject(false, 1, objectDigestInfo));
        //}
        //return new DERSequence(v);
    }

    
}

