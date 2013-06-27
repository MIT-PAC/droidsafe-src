package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.X509Name;

public class CertificationRequestInfo extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.572 -0400", hash_original_field = "FF82111B3F21980AB24776EFA599378C", hash_generated_field = "E5AD0B91EEAC333294A87988907D98F4")

    DERInteger version = new DERInteger(0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.572 -0400", hash_original_field = "B5E3374E43F6544852F7751DFC529100", hash_generated_field = "4344A061EE66BE44C834258CE9FA8F22")

    X509Name subject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.572 -0400", hash_original_field = "555762009EB39D4008C01F7B860FEAF6", hash_generated_field = "F7829ABD2DC66F67AB9A43F8086B0231")

    SubjectPublicKeyInfo subjectPKInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.572 -0400", hash_original_field = "736D2DBD967759F047753C15C7CADC6E", hash_generated_field = "E579ABB775930056E729CE38818A2767")

    ASN1Set attributes = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.573 -0400", hash_original_method = "3FEF08A37E0D9141B7E2C5E10AC22D85", hash_generated_method = "1DEE1AC2366732BEDD497DCD31C28DA7")
    public  CertificationRequestInfo(
        X500Name subject,
        SubjectPublicKeyInfo    pkInfo,
        ASN1Set                 attributes) {
        this.subject = X509Name.getInstance(subject.getDERObject());
        this.subjectPKInfo = pkInfo;
        this.attributes = attributes;
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
        } //End block
        // ---------- Original Method ----------
        //this.subject = X509Name.getInstance(subject.getDERObject());
        //this.subjectPKInfo = pkInfo;
        //this.attributes = attributes;
        //if ((subject == null) || (version == null) || (subjectPKInfo == null))
        //{
            //throw new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.573 -0400", hash_original_method = "8A394FF3547B9E5B97402324215DFF8C", hash_generated_method = "4EC7A92CFC222B338A38104A32720819")
    public  CertificationRequestInfo(
        X509Name                subject,
        SubjectPublicKeyInfo    pkInfo,
        ASN1Set                 attributes) {
        this.subject = subject;
        this.subjectPKInfo = pkInfo;
        this.attributes = attributes;
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
        } //End block
        // ---------- Original Method ----------
        //this.subject = subject;
        //this.subjectPKInfo = pkInfo;
        //this.attributes = attributes;
        //if ((subject == null) || (version == null) || (subjectPKInfo == null))
        //{
            //throw new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.578 -0400", hash_original_method = "C4672867714D5EDD4217814EF96CA715", hash_generated_method = "06EA83B50C51B5D376906ED816797D0F")
    public  CertificationRequestInfo(
        ASN1Sequence  seq) {
        version = (DERInteger)seq.getObjectAt(0);
        subject = X509Name.getInstance(seq.getObjectAt(1));
        subjectPKInfo = SubjectPublicKeyInfo.getInstance(seq.getObjectAt(2));
        {
            boolean var889BC8C4BD2008ADA32540CA2FE285A5_1277221289 = (seq.size() > 3);
            {
                DERTaggedObject tagobj;
                tagobj = (DERTaggedObject)seq.getObjectAt(3);
                attributes = ASN1Set.getInstance(tagobj, false);
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
        } //End block
        // ---------- Original Method ----------
        //version = (DERInteger)seq.getObjectAt(0);
        //subject = X509Name.getInstance(seq.getObjectAt(1));
        //subjectPKInfo = SubjectPublicKeyInfo.getInstance(seq.getObjectAt(2));
        //if (seq.size() > 3)
        //{
            //DERTaggedObject tagobj = (DERTaggedObject)seq.getObjectAt(3);
            //attributes = ASN1Set.getInstance(tagobj, false);
        //}
        //if ((subject == null) || (version == null) || (subjectPKInfo == null))
        //{
            //throw new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
        //}
    }

    
        public static CertificationRequestInfo getInstance(
        Object  obj) {
        if (obj instanceof CertificationRequestInfo)
        {
            return (CertificationRequestInfo)obj;
        }
        else if (obj instanceof ASN1Sequence)
        {
            return new CertificationRequestInfo((ASN1Sequence)obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.579 -0400", hash_original_method = "C14C6949EA2D9724014BC15AB24B85D9", hash_generated_method = "D9C221E2C744E6560FF328DD0E8197D0")
    public DERInteger getVersion() {
        DERInteger varB4EAC82CA7396A68D541C85D26508E83_1884322286 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1884322286 = version;
        varB4EAC82CA7396A68D541C85D26508E83_1884322286.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1884322286;
        // ---------- Original Method ----------
        //return version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.580 -0400", hash_original_method = "CA422C660E8CA6347A77201218B988AE", hash_generated_method = "5C7CABA8C4FAB20AA6BEB661699B126D")
    public X509Name getSubject() {
        X509Name varB4EAC82CA7396A68D541C85D26508E83_919155917 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_919155917 = subject;
        varB4EAC82CA7396A68D541C85D26508E83_919155917.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_919155917;
        // ---------- Original Method ----------
        //return subject;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.591 -0400", hash_original_method = "9158BC4B5A10C8DD7FADE51069C303FC", hash_generated_method = "FF9878E1A590AEFDD8C420DCAE9DA75A")
    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        SubjectPublicKeyInfo varB4EAC82CA7396A68D541C85D26508E83_650665191 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_650665191 = subjectPKInfo;
        varB4EAC82CA7396A68D541C85D26508E83_650665191.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_650665191;
        // ---------- Original Method ----------
        //return subjectPKInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.596 -0400", hash_original_method = "2B5879FE48F35BA3284D87B378AFE5E1", hash_generated_method = "438A2B120B6DCE2C2219581D4B58976F")
    public ASN1Set getAttributes() {
        ASN1Set varB4EAC82CA7396A68D541C85D26508E83_1455110311 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1455110311 = attributes;
        varB4EAC82CA7396A68D541C85D26508E83_1455110311.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1455110311;
        // ---------- Original Method ----------
        //return attributes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.597 -0400", hash_original_method = "0D1C10082A06DC50A0BCC9BE2BA5F1A2", hash_generated_method = "BFF1879A1439090D9CEEF0678E494021")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1464979299 = null; //Variable for return #1
        ASN1EncodableVector v;
        v = new ASN1EncodableVector();
        v.add(version);
        v.add(subject);
        v.add(subjectPKInfo);
        {
            v.add(new DERTaggedObject(false, 0, attributes));
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1464979299 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_1464979299.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1464979299;
        // ---------- Original Method ----------
        //ASN1EncodableVector  v = new ASN1EncodableVector();
        //v.add(version);
        //v.add(subject);
        //v.add(subjectPKInfo);
        //if (attributes != null)
        //{
            //v.add(new DERTaggedObject(false, 0, attributes));
        //}
        //return new DERSequence(v);
    }

    
}

