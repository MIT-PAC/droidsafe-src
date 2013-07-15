package org.bouncycastle.asn1.cms;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.BERTaggedObject;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;

public class ContentInfo extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.242 -0400", hash_original_field = "DF5FEAFAB86601EA0E1E6FE6E20DF6C5", hash_generated_field = "B8723365A049B92E62BB2E1CD2ECFAD9")

    private ASN1ObjectIdentifier contentType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.243 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "11432CB547B86FEE63A81F195D38FA38")

    private DEREncodable content;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.243 -0400", hash_original_method = "ACECF8DCEA349FB5AA8E3A5A4DDD5C04", hash_generated_method = "4E5C86A170356B083FA0FFB6E546DA79")
    public  ContentInfo(
        ASN1Sequence  seq) {
    if(seq.size() < 1 || seq.size() > 2)        
        {
            IllegalArgumentException varA2072CF614C7B8C7696DD5A02DBCCE9C_1556761600 = new IllegalArgumentException("Bad sequence size: " + seq.size());
            varA2072CF614C7B8C7696DD5A02DBCCE9C_1556761600.addTaint(taint);
            throw varA2072CF614C7B8C7696DD5A02DBCCE9C_1556761600;
        } //End block
        contentType = (ASN1ObjectIdentifier)seq.getObjectAt(0);
    if(seq.size() > 1)        
        {
            ASN1TaggedObject tagged = (ASN1TaggedObject)seq.getObjectAt(1);
    if(!tagged.isExplicit() || tagged.getTagNo() != 0)            
            {
                IllegalArgumentException varED48470EFFBBBD9B446D7E4E7B33CB71_1198376708 = new IllegalArgumentException("Bad tag for 'content'");
                varED48470EFFBBBD9B446D7E4E7B33CB71_1198376708.addTaint(taint);
                throw varED48470EFFBBBD9B446D7E4E7B33CB71_1198376708;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.245 -0400", hash_original_method = "AB0717E658192592AF8930AA14355CFE", hash_generated_method = "A3BA825DF17E5D0A0A8AF41AB3ABF408")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.246 -0400", hash_original_method = "53E059E7B37D744FA8DA51063C1D9E4B", hash_generated_method = "F6BBC9B04C52A72D25EC1032469EEA8C")
    public ASN1ObjectIdentifier getContentType() {
ASN1ObjectIdentifier var1F9BE0A83D9F0F30EFF7E238CEE615C0_365760442 =         contentType;
        var1F9BE0A83D9F0F30EFF7E238CEE615C0_365760442.addTaint(taint);
        return var1F9BE0A83D9F0F30EFF7E238CEE615C0_365760442;
        // ---------- Original Method ----------
        //return contentType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.246 -0400", hash_original_method = "188E73C2A8286EF39F391EFEF33436C4", hash_generated_method = "61881F488E1B5BEDD8AAE046F086CA45")
    public DEREncodable getContent() {
DEREncodable varD442C91479410F76C84B872DA6AAE139_1988944455 =         content;
        varD442C91479410F76C84B872DA6AAE139_1988944455.addTaint(taint);
        return varD442C91479410F76C84B872DA6AAE139_1988944455;
        // ---------- Original Method ----------
        //return content;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.246 -0400", hash_original_method = "2158A385B6C0B5A4AB87745CBE53ED1A", hash_generated_method = "E397C19BA95520B9805055DAE6A584E6")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(contentType);
    if(content != null)        
        {
            v.add(new BERTaggedObject(0, content));
        } //End block
DERObject varCDD25507F90A94964B9DD8362AA9119C_177030295 =         new BERSequence(v);
        varCDD25507F90A94964B9DD8362AA9119C_177030295.addTaint(taint);
        return varCDD25507F90A94964B9DD8362AA9119C_177030295;
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

