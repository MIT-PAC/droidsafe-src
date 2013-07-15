package org.bouncycastle.asn1.x500;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;

public class RDN extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.692 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "239F5B210A7B8675111CDBD0D5490D28")

    private ASN1Set values;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.693 -0400", hash_original_method = "B2B65A892B577B3023594DECDAE0C7BC", hash_generated_method = "89280BB26732A955423A2E05E8E72AFE")
    private  RDN(ASN1Set values) {
        this.values = values;
        // ---------- Original Method ----------
        //this.values = values;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.693 -0400", hash_original_method = "34395E14B37CB09607BC1384911068DF", hash_generated_method = "4730855AD6D722A19B03FA23E3955A1C")
    public  RDN(ASN1ObjectIdentifier oid, ASN1Encodable value) {
        addTaint(value.getTaint());
        addTaint(oid.getTaint());
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(oid);
        v.add(value);
        this.values = new DERSet(new DERSequence(v));
        // ---------- Original Method ----------
        //ASN1EncodableVector v = new ASN1EncodableVector();
        //v.add(oid);
        //v.add(value);
        //this.values = new DERSet(new DERSequence(v));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.694 -0400", hash_original_method = "70441AB748507844E6B6BCC428FBB7E0", hash_generated_method = "7BBD5B09B6231808260E121EB4C29BD7")
    public  RDN(AttributeTypeAndValue attrTAndV) {
        this.values = new DERSet(attrTAndV);
        // ---------- Original Method ----------
        //this.values = new DERSet(attrTAndV);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.694 -0400", hash_original_method = "64FFFA196C50B73DE4BDB139C105E877", hash_generated_method = "FE3A4F5D64F6663C43C30F2372D32E20")
    public  RDN(AttributeTypeAndValue[] aAndVs) {
        this.values = new DERSet(aAndVs);
        // ---------- Original Method ----------
        //this.values = new DERSet(aAndVs);
    }

    
        public static RDN getInstance(Object obj) {
        if (obj instanceof RDN)
        {
            return (RDN)obj;
        }
        else if (obj != null)
        {
            return new RDN(ASN1Set.getInstance(obj));
        }
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.695 -0400", hash_original_method = "8A639F09C3F110E6BEBA76653F26863C", hash_generated_method = "A02665FB0B4F574EA7D9CDF55C36FA9D")
    public boolean isMultiValued() {
        boolean var4BD1DF8E036A3E994525BA373DB11683_1169605007 = (this.values.size() > 1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_149774725 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_149774725;
        // ---------- Original Method ----------
        //return this.values.size() > 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.695 -0400", hash_original_method = "C47887FAFD60151A3B1C3C44B7665548", hash_generated_method = "8CEBB6EFA657CD3850154C0E724541FA")
    public AttributeTypeAndValue getFirst() {
    if(this.values.size() == 0)        
        {
AttributeTypeAndValue var540C13E9E156B687226421B24F2DF178_1080633720 =             null;
            var540C13E9E156B687226421B24F2DF178_1080633720.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1080633720;
        } //End block
AttributeTypeAndValue var3E668B3FBD36C203E122F3AF63D5393B_11503090 =         AttributeTypeAndValue.getInstance(this.values.getObjectAt(0));
        var3E668B3FBD36C203E122F3AF63D5393B_11503090.addTaint(taint);
        return var3E668B3FBD36C203E122F3AF63D5393B_11503090;
        // ---------- Original Method ----------
        //if (this.values.size() == 0)
        //{
            //return null;
        //}
        //return AttributeTypeAndValue.getInstance(this.values.getObjectAt(0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.695 -0400", hash_original_method = "BEE890DAA6519CDB424A36294BC48156", hash_generated_method = "A8DB0356B5C0FCE49A14D82B511F6BAA")
    public AttributeTypeAndValue[] getTypesAndValues() {
        AttributeTypeAndValue[] tmp = new AttributeTypeAndValue[values.size()];
for(int i = 0;i != tmp.length;i++)
        {
            tmp[i] = AttributeTypeAndValue.getInstance(values.getObjectAt(i));
        } //End block
AttributeTypeAndValue[] var3F12A0424932F6B5155AA6C49B63FE6E_1121233081 =         tmp;
        var3F12A0424932F6B5155AA6C49B63FE6E_1121233081.addTaint(taint);
        return var3F12A0424932F6B5155AA6C49B63FE6E_1121233081;
        // ---------- Original Method ----------
        //AttributeTypeAndValue[] tmp = new AttributeTypeAndValue[values.size()];
        //for (int i = 0; i != tmp.length; i++)
        //{
            //tmp[i] = AttributeTypeAndValue.getInstance(values.getObjectAt(i));
        //}
        //return tmp;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.696 -0400", hash_original_method = "C51EA85277B01B717571B534CACD612E", hash_generated_method = "E627CC5FAC9C4F06D0E3B49CB65212EA")
    public DERObject toASN1Object() {
DERObject var674B10C763DBAAF9696AD9A3DDAE07B3_2144861341 =         values;
        var674B10C763DBAAF9696AD9A3DDAE07B3_2144861341.addTaint(taint);
        return var674B10C763DBAAF9696AD9A3DDAE07B3_2144861341;
        // ---------- Original Method ----------
        //return values;
    }

    
}

