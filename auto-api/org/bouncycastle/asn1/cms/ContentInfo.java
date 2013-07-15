package org.bouncycastle.asn1.cms;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.915 -0400", hash_original_field = "DF5FEAFAB86601EA0E1E6FE6E20DF6C5", hash_generated_field = "B8723365A049B92E62BB2E1CD2ECFAD9")

    private ASN1ObjectIdentifier contentType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.915 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "11432CB547B86FEE63A81F195D38FA38")

    private DEREncodable content;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.916 -0400", hash_original_method = "ACECF8DCEA349FB5AA8E3A5A4DDD5C04", hash_generated_method = "8B19947F96C042B55097E572BE44D37D")
    public  ContentInfo(
        ASN1Sequence  seq) {
        {
            boolean var20EF5DADDEFE74257652D6C1EB58B13A_1098141546 = (seq.size() < 1 || seq.size() > 2);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad sequence size: " + seq.size());
            } 
        } 
        contentType = (ASN1ObjectIdentifier)seq.getObjectAt(0);
        {
            boolean var64350C32E290C0E21F2C2729462EE694_2114686712 = (seq.size() > 1);
            {
                ASN1TaggedObject tagged = (ASN1TaggedObject)seq.getObjectAt(1);
                {
                    boolean var9E7F2387763A4CE52A266B5991C1EF86_1674924737 = (!tagged.isExplicit() || tagged.getTagNo() != 0);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad tag for 'content'");
                    } 
                } 
                content = tagged.getObject();
            } 
        } 
        
        
        
            
        
        
        
        
            
            
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.916 -0400", hash_original_method = "AB0717E658192592AF8930AA14355CFE", hash_generated_method = "A3BA825DF17E5D0A0A8AF41AB3ABF408")
    public  ContentInfo(
        ASN1ObjectIdentifier contentType,
        DEREncodable        content) {
        this.contentType = contentType;
        this.content = content;
        
        
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.917 -0400", hash_original_method = "53E059E7B37D744FA8DA51063C1D9E4B", hash_generated_method = "36F390D31E7D937F1F830898A1D2745F")
    public ASN1ObjectIdentifier getContentType() {
        ASN1ObjectIdentifier varB4EAC82CA7396A68D541C85D26508E83_239549259 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_239549259 = contentType;
        varB4EAC82CA7396A68D541C85D26508E83_239549259.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_239549259;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.917 -0400", hash_original_method = "188E73C2A8286EF39F391EFEF33436C4", hash_generated_method = "B1124B25B311CACCB88856CC7AD38453")
    public DEREncodable getContent() {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1725085792 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1725085792 = content;
        varB4EAC82CA7396A68D541C85D26508E83_1725085792.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1725085792;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.918 -0400", hash_original_method = "2158A385B6C0B5A4AB87745CBE53ED1A", hash_generated_method = "CF42CB06466F5BC65CF737097073BC15")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_2770573 = null; 
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(contentType);
        {
            v.add(new BERTaggedObject(0, content));
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2770573 = new BERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_2770573.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2770573;
        
        
        
        
        
            
        
        
    }

    
}

