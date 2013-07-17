package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.901 -0400", hash_original_field = "FF82111B3F21980AB24776EFA599378C", hash_generated_field = "E5AD0B91EEAC333294A87988907D98F4")

    DERInteger version = new DERInteger(0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.902 -0400", hash_original_field = "B5E3374E43F6544852F7751DFC529100", hash_generated_field = "4344A061EE66BE44C834258CE9FA8F22")

    X509Name subject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.902 -0400", hash_original_field = "555762009EB39D4008C01F7B860FEAF6", hash_generated_field = "F7829ABD2DC66F67AB9A43F8086B0231")

    SubjectPublicKeyInfo subjectPKInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.902 -0400", hash_original_field = "736D2DBD967759F047753C15C7CADC6E", hash_generated_field = "E579ABB775930056E729CE38818A2767")

    ASN1Set attributes = null;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.903 -0400", hash_original_method = "3FEF08A37E0D9141B7E2C5E10AC22D85", hash_generated_method = "FA534A3D5A98F5385944F2273E5E4795")
    public  CertificationRequestInfo(
        X500Name subject,
        SubjectPublicKeyInfo    pkInfo,
        ASN1Set                 attributes) {
        this.subject = X509Name.getInstance(subject.getDERObject());
        this.subjectPKInfo = pkInfo;
        this.attributes = attributes;
        if((subject == null) || (version == null) || (subjectPKInfo == null))        
        {
            IllegalArgumentException var1B00796A6494DFB82A5A80FF25E8759A_463101271 = new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
            var1B00796A6494DFB82A5A80FF25E8759A_463101271.addTaint(taint);
            throw var1B00796A6494DFB82A5A80FF25E8759A_463101271;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.904 -0400", hash_original_method = "8A394FF3547B9E5B97402324215DFF8C", hash_generated_method = "6C395CC57DA14308445FAEE25A52B252")
    public  CertificationRequestInfo(
        X509Name                subject,
        SubjectPublicKeyInfo    pkInfo,
        ASN1Set                 attributes) {
        this.subject = subject;
        this.subjectPKInfo = pkInfo;
        this.attributes = attributes;
        if((subject == null) || (version == null) || (subjectPKInfo == null))        
        {
            IllegalArgumentException var1B00796A6494DFB82A5A80FF25E8759A_1179905424 = new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
            var1B00796A6494DFB82A5A80FF25E8759A_1179905424.addTaint(taint);
            throw var1B00796A6494DFB82A5A80FF25E8759A_1179905424;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.905 -0400", hash_original_method = "C4672867714D5EDD4217814EF96CA715", hash_generated_method = "F5C55B5E32012AC9A4B462ABA9EDEE98")
    public  CertificationRequestInfo(
        ASN1Sequence  seq) {
        version = (DERInteger)seq.getObjectAt(0);
        subject = X509Name.getInstance(seq.getObjectAt(1));
        subjectPKInfo = SubjectPublicKeyInfo.getInstance(seq.getObjectAt(2));
        if(seq.size() > 3)        
        {
            DERTaggedObject tagobj = (DERTaggedObject)seq.getObjectAt(3);
            attributes = ASN1Set.getInstance(tagobj, false);
        } //End block
        if((subject == null) || (version == null) || (subjectPKInfo == null))        
        {
            IllegalArgumentException var1B00796A6494DFB82A5A80FF25E8759A_1451766017 = new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
            var1B00796A6494DFB82A5A80FF25E8759A_1451766017.addTaint(taint);
            throw var1B00796A6494DFB82A5A80FF25E8759A_1451766017;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.905 -0400", hash_original_method = "C14C6949EA2D9724014BC15AB24B85D9", hash_generated_method = "2127B8DEDF597957320835DFE8636E0A")
    public DERInteger getVersion() {
DERInteger varE87BEFBC04DA371DFA5B07C77A4407CB_2121624329 =         version;
        varE87BEFBC04DA371DFA5B07C77A4407CB_2121624329.addTaint(taint);
        return varE87BEFBC04DA371DFA5B07C77A4407CB_2121624329;
        // ---------- Original Method ----------
        //return version;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.906 -0400", hash_original_method = "CA422C660E8CA6347A77201218B988AE", hash_generated_method = "774932D49C08F1005799530542E9D7BB")
    public X509Name getSubject() {
X509Name varC07EC1407326EABEF2FB6D781FE48674_1115233939 =         subject;
        varC07EC1407326EABEF2FB6D781FE48674_1115233939.addTaint(taint);
        return varC07EC1407326EABEF2FB6D781FE48674_1115233939;
        // ---------- Original Method ----------
        //return subject;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.906 -0400", hash_original_method = "9158BC4B5A10C8DD7FADE51069C303FC", hash_generated_method = "B8D5EB685E30BBB18EB777CDDF780F1F")
    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
SubjectPublicKeyInfo var0F23F992E0F266C5F329776868FA4590_1118160294 =         subjectPKInfo;
        var0F23F992E0F266C5F329776868FA4590_1118160294.addTaint(taint);
        return var0F23F992E0F266C5F329776868FA4590_1118160294;
        // ---------- Original Method ----------
        //return subjectPKInfo;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.906 -0400", hash_original_method = "2B5879FE48F35BA3284D87B378AFE5E1", hash_generated_method = "08E157B6A41B94156239891CCAB15D54")
    public ASN1Set getAttributes() {
ASN1Set var4BBC8979DB64A9C3E2328AA1E06CDBB3_345622941 =         attributes;
        var4BBC8979DB64A9C3E2328AA1E06CDBB3_345622941.addTaint(taint);
        return var4BBC8979DB64A9C3E2328AA1E06CDBB3_345622941;
        // ---------- Original Method ----------
        //return attributes;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.907 -0400", hash_original_method = "0D1C10082A06DC50A0BCC9BE2BA5F1A2", hash_generated_method = "A6D98D2B8817CA6CC79BFBFEC0948747")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(version);
        v.add(subject);
        v.add(subjectPKInfo);
        if(attributes != null)        
        {
            v.add(new DERTaggedObject(false, 0, attributes));
        } //End block
DERObject var0B338F106E3279986C87B595B0F4A439_1755086001 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_1755086001.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_1755086001;
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

