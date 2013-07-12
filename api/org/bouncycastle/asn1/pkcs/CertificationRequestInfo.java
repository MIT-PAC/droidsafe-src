package org.bouncycastle.asn1.pkcs;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.296 -0400", hash_original_field = "FF82111B3F21980AB24776EFA599378C", hash_generated_field = "E5AD0B91EEAC333294A87988907D98F4")

    DERInteger version = new DERInteger(0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.296 -0400", hash_original_field = "B5E3374E43F6544852F7751DFC529100", hash_generated_field = "4344A061EE66BE44C834258CE9FA8F22")

    X509Name subject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.296 -0400", hash_original_field = "555762009EB39D4008C01F7B860FEAF6", hash_generated_field = "F7829ABD2DC66F67AB9A43F8086B0231")

    SubjectPublicKeyInfo subjectPKInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.296 -0400", hash_original_field = "736D2DBD967759F047753C15C7CADC6E", hash_generated_field = "E579ABB775930056E729CE38818A2767")

    ASN1Set attributes = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.297 -0400", hash_original_method = "3FEF08A37E0D9141B7E2C5E10AC22D85", hash_generated_method = "4516536591C0306AAA3325323C71D751")
    public  CertificationRequestInfo(
        X500Name subject,
        SubjectPublicKeyInfo    pkInfo,
        ASN1Set                 attributes) {
        this.subject = X509Name.getInstance(subject.getDERObject());
        this.subjectPKInfo = pkInfo;
        this.attributes = attributes;
    if((subject == null) || (version == null) || (subjectPKInfo == null))        
        {
            IllegalArgumentException var1B00796A6494DFB82A5A80FF25E8759A_2082413333 = new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
            var1B00796A6494DFB82A5A80FF25E8759A_2082413333.addTaint(taint);
            throw var1B00796A6494DFB82A5A80FF25E8759A_2082413333;
        } 
        
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.298 -0400", hash_original_method = "8A394FF3547B9E5B97402324215DFF8C", hash_generated_method = "DF7D696E1EA9B48845CFEB903A3C2EA4")
    public  CertificationRequestInfo(
        X509Name                subject,
        SubjectPublicKeyInfo    pkInfo,
        ASN1Set                 attributes) {
        this.subject = subject;
        this.subjectPKInfo = pkInfo;
        this.attributes = attributes;
    if((subject == null) || (version == null) || (subjectPKInfo == null))        
        {
            IllegalArgumentException var1B00796A6494DFB82A5A80FF25E8759A_2001489644 = new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
            var1B00796A6494DFB82A5A80FF25E8759A_2001489644.addTaint(taint);
            throw var1B00796A6494DFB82A5A80FF25E8759A_2001489644;
        } 
        
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.299 -0400", hash_original_method = "C4672867714D5EDD4217814EF96CA715", hash_generated_method = "1B77A839AE3363444CD072C99CD169D1")
    public  CertificationRequestInfo(
        ASN1Sequence  seq) {
        version = (DERInteger)seq.getObjectAt(0);
        subject = X509Name.getInstance(seq.getObjectAt(1));
        subjectPKInfo = SubjectPublicKeyInfo.getInstance(seq.getObjectAt(2));
    if(seq.size() > 3)        
        {
            DERTaggedObject tagobj = (DERTaggedObject)seq.getObjectAt(3);
            attributes = ASN1Set.getInstance(tagobj, false);
        } 
    if((subject == null) || (version == null) || (subjectPKInfo == null))        
        {
            IllegalArgumentException var1B00796A6494DFB82A5A80FF25E8759A_1338501783 = new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
            var1B00796A6494DFB82A5A80FF25E8759A_1338501783.addTaint(taint);
            throw var1B00796A6494DFB82A5A80FF25E8759A_1338501783;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.299 -0400", hash_original_method = "C14C6949EA2D9724014BC15AB24B85D9", hash_generated_method = "9FFFB551B1F141D866C8B3EAC930AD08")
    public DERInteger getVersion() {
DERInteger varE87BEFBC04DA371DFA5B07C77A4407CB_671747665 =         version;
        varE87BEFBC04DA371DFA5B07C77A4407CB_671747665.addTaint(taint);
        return varE87BEFBC04DA371DFA5B07C77A4407CB_671747665;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.299 -0400", hash_original_method = "CA422C660E8CA6347A77201218B988AE", hash_generated_method = "50D83B09D7B1CF4559569E1FEBF532CB")
    public X509Name getSubject() {
X509Name varC07EC1407326EABEF2FB6D781FE48674_1794055841 =         subject;
        varC07EC1407326EABEF2FB6D781FE48674_1794055841.addTaint(taint);
        return varC07EC1407326EABEF2FB6D781FE48674_1794055841;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.300 -0400", hash_original_method = "9158BC4B5A10C8DD7FADE51069C303FC", hash_generated_method = "50A2333281845FBF79816DC18FC2F5D9")
    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
SubjectPublicKeyInfo var0F23F992E0F266C5F329776868FA4590_1762954548 =         subjectPKInfo;
        var0F23F992E0F266C5F329776868FA4590_1762954548.addTaint(taint);
        return var0F23F992E0F266C5F329776868FA4590_1762954548;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.300 -0400", hash_original_method = "2B5879FE48F35BA3284D87B378AFE5E1", hash_generated_method = "5A113CBDF00E364C2CA974411CB4DB59")
    public ASN1Set getAttributes() {
ASN1Set var4BBC8979DB64A9C3E2328AA1E06CDBB3_20227820 =         attributes;
        var4BBC8979DB64A9C3E2328AA1E06CDBB3_20227820.addTaint(taint);
        return var4BBC8979DB64A9C3E2328AA1E06CDBB3_20227820;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.300 -0400", hash_original_method = "0D1C10082A06DC50A0BCC9BE2BA5F1A2", hash_generated_method = "38867DF77CE43DD8E6E18F330B0CD4C0")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(version);
        v.add(subject);
        v.add(subjectPKInfo);
    if(attributes != null)        
        {
            v.add(new DERTaggedObject(false, 0, attributes));
        } 
DERObject var0B338F106E3279986C87B595B0F4A439_2014177837 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_2014177837.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_2014177837;
        
        
        
        
        
        
        
            
        
        
    }

    
}

