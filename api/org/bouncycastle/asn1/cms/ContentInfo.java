package org.bouncycastle.asn1.cms;

// Droidsafe Imports
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.BERTaggedObject;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ContentInfo extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.817 -0400", hash_original_field = "DF5FEAFAB86601EA0E1E6FE6E20DF6C5", hash_generated_field = "B8723365A049B92E62BB2E1CD2ECFAD9")

    private ASN1ObjectIdentifier contentType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.817 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "11432CB547B86FEE63A81F195D38FA38")

    private DEREncodable content;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.818 -0400", hash_original_method = "ACECF8DCEA349FB5AA8E3A5A4DDD5C04", hash_generated_method = "53A62DE957712956E8D0481C87B38CF5")
    public  ContentInfo(
        ASN1Sequence  seq) {
        if(seq.size() < 1 || seq.size() > 2)        
        {
            IllegalArgumentException varA2072CF614C7B8C7696DD5A02DBCCE9C_1133958389 = new IllegalArgumentException("Bad sequence size: " + seq.size());
            varA2072CF614C7B8C7696DD5A02DBCCE9C_1133958389.addTaint(taint);
            throw varA2072CF614C7B8C7696DD5A02DBCCE9C_1133958389;
        } //End block
        contentType = (ASN1ObjectIdentifier)seq.getObjectAt(0);
        if(seq.size() > 1)        
        {
            ASN1TaggedObject tagged = (ASN1TaggedObject)seq.getObjectAt(1);
            if(!tagged.isExplicit() || tagged.getTagNo() != 0)            
            {
                IllegalArgumentException varED48470EFFBBBD9B446D7E4E7B33CB71_1593264516 = new IllegalArgumentException("Bad tag for 'content'");
                varED48470EFFBBBD9B446D7E4E7B33CB71_1593264516.addTaint(taint);
                throw varED48470EFFBBBD9B446D7E4E7B33CB71_1593264516;
            } //End block
            content = tagged.getObject();
        } //End block
        // ---------- Original Method ----------
        //if (seq.size() < 1 || seq.size() > 2)
        //{
            //throw new IllegalArgumentException("Bad sequence size: " + seq.size());
        //}
        //contentType = (ASN1ObjectIdentifier)seq.getObjectAt(0);
        //if (seq.size() > 1)
        //{
            //ASN1TaggedObject tagged = (ASN1TaggedObject)seq.getObjectAt(1);
            //if (!tagged.isExplicit() || tagged.getTagNo() != 0)
            //{
                //throw new IllegalArgumentException("Bad tag for 'content'");
            //}
            //content = tagged.getObject();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.835 -0400", hash_original_method = "AB0717E658192592AF8930AA14355CFE", hash_generated_method = "A3BA825DF17E5D0A0A8AF41AB3ABF408")
    public  ContentInfo(
        ASN1ObjectIdentifier contentType,
        DEREncodable        content) {
        this.contentType = contentType;
        this.content = content;
        // ---------- Original Method ----------
        //this.contentType = contentType;
        //this.content = content;
    }

    
    public static ContentInfo getInstance(
        Object  obj) {
        if (obj == null || obj instanceof ContentInfo)
        {
            return (ContentInfo)obj;
        }
        else if (obj instanceof ASN1Sequence)
        {
            return new ContentInfo((ASN1Sequence)obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.835 -0400", hash_original_method = "53E059E7B37D744FA8DA51063C1D9E4B", hash_generated_method = "B7297002111C27E25F5CD8FC9FF50961")
    public ASN1ObjectIdentifier getContentType() {
ASN1ObjectIdentifier var1F9BE0A83D9F0F30EFF7E238CEE615C0_575397879 =         contentType;
        var1F9BE0A83D9F0F30EFF7E238CEE615C0_575397879.addTaint(taint);
        return var1F9BE0A83D9F0F30EFF7E238CEE615C0_575397879;
        // ---------- Original Method ----------
        //return contentType;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.835 -0400", hash_original_method = "188E73C2A8286EF39F391EFEF33436C4", hash_generated_method = "A71B25C6BDA2B5A34237DC304EB4329E")
    public DEREncodable getContent() {
DEREncodable varD442C91479410F76C84B872DA6AAE139_978413017 =         content;
        varD442C91479410F76C84B872DA6AAE139_978413017.addTaint(taint);
        return varD442C91479410F76C84B872DA6AAE139_978413017;
        // ---------- Original Method ----------
        //return content;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.835 -0400", hash_original_method = "2158A385B6C0B5A4AB87745CBE53ED1A", hash_generated_method = "7C7661ECA47612A78189C8B1AC3BF7F9")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(contentType);
        if(content != null)        
        {
            v.add(new BERTaggedObject(0, content));
        } //End block
DERObject varCDD25507F90A94964B9DD8362AA9119C_2056587114 =         new BERSequence(v);
        varCDD25507F90A94964B9DD8362AA9119C_2056587114.addTaint(taint);
        return varCDD25507F90A94964B9DD8362AA9119C_2056587114;
        // ---------- Original Method ----------
        //ASN1EncodableVector  v = new ASN1EncodableVector();
        //v.add(contentType);
        //if (content != null)
        //{
            //v.add(new BERTaggedObject(0, content));
        //}
        //return new BERSequence(v);
    }

    
}

