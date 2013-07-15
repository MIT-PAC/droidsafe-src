package org.bouncycastle.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.x509.Attribute;

public class X509Attribute extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.738 -0400", hash_original_field = "815BE97DF65D6C4B510CD07189C5347A", hash_generated_field = "078373DB546E20C4F10604687E295777")

    Attribute attr;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.738 -0400", hash_original_method = "CE4AB458669C1421E9AF493051F17B5E", hash_generated_method = "F73CAD490F69AAFEDE5EE4A251B0330E")
      X509Attribute(
        ASN1Encodable   at) {
        this.attr = Attribute.getInstance(at);
        // ---------- Original Method ----------
        //this.attr = Attribute.getInstance(at);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.739 -0400", hash_original_method = "F2072CEA8EE053AA2B225A50B1411CAE", hash_generated_method = "CFBE33AD64AB7DD77DF0E28D00C8CD6A")
    public  X509Attribute(
        String          oid,
        ASN1Encodable   value) {
        this.attr = new Attribute(new DERObjectIdentifier(oid), new DERSet(value));
        // ---------- Original Method ----------
        //this.attr = new Attribute(new DERObjectIdentifier(oid), new DERSet(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.740 -0400", hash_original_method = "7A2D44AF2F579D4A5E25B4BDA18E068A", hash_generated_method = "29EC53AB3807C9520CBADE09246B0D7B")
    public  X509Attribute(
        String              oid,
        ASN1EncodableVector value) {
        this.attr = new Attribute(new DERObjectIdentifier(oid), new DERSet(value));
        // ---------- Original Method ----------
        //this.attr = new Attribute(new DERObjectIdentifier(oid), new DERSet(value));
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.740 -0400", hash_original_method = "EBAE76CB59DDB3FF6797DC91E3573A47", hash_generated_method = "45D4802FC747AF7CEF1BDE72CD553E23")
    public String getOID() {
String varA90EF0944754C973C365D321427B43FA_1696440179 =         attr.getAttrType().getId();
        varA90EF0944754C973C365D321427B43FA_1696440179.addTaint(taint);
        return varA90EF0944754C973C365D321427B43FA_1696440179;
        // ---------- Original Method ----------
        //return attr.getAttrType().getId();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.741 -0400", hash_original_method = "BC207D0C6A8D635D2F61723C6B9C7E5D", hash_generated_method = "027FE653BF85D7C959AE693A6EF1AF87")
    public ASN1Encodable[] getValues() {
        ASN1Set s = attr.getAttrValues();
        ASN1Encodable[] values = new ASN1Encodable[s.size()];
for(int i = 0;i != s.size();i++)
        {
            values[i] = (ASN1Encodable)s.getObjectAt(i);
        } //End block
ASN1Encodable[] var674B10C763DBAAF9696AD9A3DDAE07B3_1669501265 =         values;
        var674B10C763DBAAF9696AD9A3DDAE07B3_1669501265.addTaint(taint);
        return var674B10C763DBAAF9696AD9A3DDAE07B3_1669501265;
        // ---------- Original Method ----------
        //ASN1Set         s = attr.getAttrValues();
        //ASN1Encodable[] values = new ASN1Encodable[s.size()];
        //for (int i = 0; i != s.size(); i++)
        //{
            //values[i] = (ASN1Encodable)s.getObjectAt(i);
        //}
        //return values;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.741 -0400", hash_original_method = "B86A9DDF1DB3AD0B2C8F07C01CCF4C19", hash_generated_method = "6C3D94593854FB4A8FB7BE42FF8920D2")
    public DERObject toASN1Object() {
DERObject var2CFD40CD53E7C6DE08E954E654FF6C5B_1153744548 =         attr.toASN1Object();
        var2CFD40CD53E7C6DE08E954E654FF6C5B_1153744548.addTaint(taint);
        return var2CFD40CD53E7C6DE08E954E654FF6C5B_1153744548;
        // ---------- Original Method ----------
        //return attr.toASN1Object();
    }

    
}

