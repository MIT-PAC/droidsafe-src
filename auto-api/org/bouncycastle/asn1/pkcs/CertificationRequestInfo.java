package org.bouncycastle.asn1.pkcs;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.000 -0400", hash_original_field = "FF82111B3F21980AB24776EFA599378C", hash_generated_field = "E5AD0B91EEAC333294A87988907D98F4")

    DERInteger version = new DERInteger(0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.000 -0400", hash_original_field = "B5E3374E43F6544852F7751DFC529100", hash_generated_field = "4344A061EE66BE44C834258CE9FA8F22")

    X509Name subject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.000 -0400", hash_original_field = "555762009EB39D4008C01F7B860FEAF6", hash_generated_field = "F7829ABD2DC66F67AB9A43F8086B0231")

    SubjectPublicKeyInfo subjectPKInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.000 -0400", hash_original_field = "736D2DBD967759F047753C15C7CADC6E", hash_generated_field = "E579ABB775930056E729CE38818A2767")

    ASN1Set attributes = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.000 -0400", hash_original_method = "3FEF08A37E0D9141B7E2C5E10AC22D85", hash_generated_method = "1DEE1AC2366732BEDD497DCD31C28DA7")
    public  CertificationRequestInfo(
        X500Name subject,
        SubjectPublicKeyInfo    pkInfo,
        ASN1Set                 attributes) {
        this.subject = X509Name.getInstance(subject.getDERObject());
        this.subjectPKInfo = pkInfo;
        this.attributes = attributes;
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
        } 
        
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.001 -0400", hash_original_method = "8A394FF3547B9E5B97402324215DFF8C", hash_generated_method = "4EC7A92CFC222B338A38104A32720819")
    public  CertificationRequestInfo(
        X509Name                subject,
        SubjectPublicKeyInfo    pkInfo,
        ASN1Set                 attributes) {
        this.subject = subject;
        this.subjectPKInfo = pkInfo;
        this.attributes = attributes;
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
        } 
        
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.001 -0400", hash_original_method = "C4672867714D5EDD4217814EF96CA715", hash_generated_method = "6D203FC1F8709B6F14924F61753164C9")
    public  CertificationRequestInfo(
        ASN1Sequence  seq) {
        version = (DERInteger)seq.getObjectAt(0);
        subject = X509Name.getInstance(seq.getObjectAt(1));
        subjectPKInfo = SubjectPublicKeyInfo.getInstance(seq.getObjectAt(2));
        {
            boolean var889BC8C4BD2008ADA32540CA2FE285A5_366026409 = (seq.size() > 3);
            {
                DERTaggedObject tagobj = (DERTaggedObject)seq.getObjectAt(3);
                attributes = ASN1Set.getInstance(tagobj, false);
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
        } 
        
        
        
        
        
        
            
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.003 -0400", hash_original_method = "C14C6949EA2D9724014BC15AB24B85D9", hash_generated_method = "8AAEDD8E4EEF226EB5BE9FC8EDF75698")
    public DERInteger getVersion() {
        DERInteger varB4EAC82CA7396A68D541C85D26508E83_1784349177 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1784349177 = version;
        varB4EAC82CA7396A68D541C85D26508E83_1784349177.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1784349177;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.003 -0400", hash_original_method = "CA422C660E8CA6347A77201218B988AE", hash_generated_method = "F971F7C72E3395799AEAAD34EB1000B3")
    public X509Name getSubject() {
        X509Name varB4EAC82CA7396A68D541C85D26508E83_756176855 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_756176855 = subject;
        varB4EAC82CA7396A68D541C85D26508E83_756176855.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_756176855;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.003 -0400", hash_original_method = "9158BC4B5A10C8DD7FADE51069C303FC", hash_generated_method = "7D154E00E30D32712F0221D2DDE6AA79")
    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        SubjectPublicKeyInfo varB4EAC82CA7396A68D541C85D26508E83_1589153772 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1589153772 = subjectPKInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1589153772.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1589153772;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.004 -0400", hash_original_method = "2B5879FE48F35BA3284D87B378AFE5E1", hash_generated_method = "7898FA6FEFC8B240A2B5E9B70711D050")
    public ASN1Set getAttributes() {
        ASN1Set varB4EAC82CA7396A68D541C85D26508E83_944583944 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_944583944 = attributes;
        varB4EAC82CA7396A68D541C85D26508E83_944583944.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_944583944;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.004 -0400", hash_original_method = "0D1C10082A06DC50A0BCC9BE2BA5F1A2", hash_generated_method = "5ECD85412E8E84F2AAADDD69D01DE15E")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1673595144 = null; 
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(version);
        v.add(subject);
        v.add(subjectPKInfo);
        {
            v.add(new DERTaggedObject(false, 0, attributes));
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1673595144 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_1673595144.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1673595144;
        
        
        
        
        
        
        
            
        
        
    }

    
}

