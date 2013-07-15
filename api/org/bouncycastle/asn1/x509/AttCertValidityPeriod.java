package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class AttCertValidityPeriod extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.921 -0400", hash_original_field = "2919902F9A6E0F5FCF60B41418F11D15", hash_generated_field = "47DE96B4FD02A134DD50DFF525BEE2DC")

    DERGeneralizedTime notBeforeTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.921 -0400", hash_original_field = "F6D45B6FEDB08A0673FA9C388F80AC1F", hash_generated_field = "F8DBABB88A466E46C9DA55A579BE1BBD")

    DERGeneralizedTime notAfterTime;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.922 -0400", hash_original_method = "4935F5EA06A87E5EB822F7F5CCD2C830", hash_generated_method = "CDBCD3E9D4AC5BEBD70A8AFEB839CE9D")
    public  AttCertValidityPeriod(
        ASN1Sequence    seq) {
    if(seq.size() != 2)        
        {
            IllegalArgumentException varA2072CF614C7B8C7696DD5A02DBCCE9C_1490027275 = new IllegalArgumentException("Bad sequence size: "
                    + seq.size());
            varA2072CF614C7B8C7696DD5A02DBCCE9C_1490027275.addTaint(taint);
            throw varA2072CF614C7B8C7696DD5A02DBCCE9C_1490027275;
        } //End block
        notBeforeTime = DERGeneralizedTime.getInstance(seq.getObjectAt(0));
        notAfterTime = DERGeneralizedTime.getInstance(seq.getObjectAt(1));
        // ---------- Original Method ----------
        //if (seq.size() != 2)
        //{
            //throw new IllegalArgumentException("Bad sequence size: "
                    //+ seq.size());
        //}
        //notBeforeTime = DERGeneralizedTime.getInstance(seq.getObjectAt(0));
        //notAfterTime = DERGeneralizedTime.getInstance(seq.getObjectAt(1));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.922 -0400", hash_original_method = "EE3E4821B31B071C83A5954362B6FCF9", hash_generated_method = "78645F960C6BB66568007E45DEE436B1")
    public  AttCertValidityPeriod(
        DERGeneralizedTime notBeforeTime,
        DERGeneralizedTime notAfterTime) {
        this.notBeforeTime = notBeforeTime;
        this.notAfterTime = notAfterTime;
        // ---------- Original Method ----------
        //this.notBeforeTime = notBeforeTime;
        //this.notAfterTime = notAfterTime;
    }

    
        @DSModeled(DSC.SPEC)
    public static AttCertValidityPeriod getInstance(
            Object  obj) {
        if (obj instanceof AttCertValidityPeriod)
        {
            return (AttCertValidityPeriod)obj;
        }
        else if (obj instanceof ASN1Sequence)
        {
            return new AttCertValidityPeriod((ASN1Sequence)obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.923 -0400", hash_original_method = "61005B71BB5E250DAD749F45259F34BB", hash_generated_method = "A2AEBC7A259EF3C32EE902F932BA4BF1")
    public DERGeneralizedTime getNotBeforeTime() {
DERGeneralizedTime varD79BF4F5D1C2BF1B626C250DDDC1BBBB_1204964520 =         notBeforeTime;
        varD79BF4F5D1C2BF1B626C250DDDC1BBBB_1204964520.addTaint(taint);
        return varD79BF4F5D1C2BF1B626C250DDDC1BBBB_1204964520;
        // ---------- Original Method ----------
        //return notBeforeTime;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.923 -0400", hash_original_method = "3C0941D5D83A6A464C361337736D354A", hash_generated_method = "51896EDFECFCCECA583F289AED73B131")
    public DERGeneralizedTime getNotAfterTime() {
DERGeneralizedTime varA4D5BDCFF20FBB2AB9CF4A743D5EF45E_1920694573 =         notAfterTime;
        varA4D5BDCFF20FBB2AB9CF4A743D5EF45E_1920694573.addTaint(taint);
        return varA4D5BDCFF20FBB2AB9CF4A743D5EF45E_1920694573;
        // ---------- Original Method ----------
        //return notAfterTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.923 -0400", hash_original_method = "F304C055A3AB57005A726D651B674F2F", hash_generated_method = "B162DB4EA589B5387D091589294971FE")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(notBeforeTime);
        v.add(notAfterTime);
DERObject var0B338F106E3279986C87B595B0F4A439_220137605 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_220137605.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_220137605;
        // ---------- Original Method ----------
        //ASN1EncodableVector  v = new ASN1EncodableVector();
        //v.add(notBeforeTime);
        //v.add(notAfterTime);
        //return new DERSequence(v);
    }

    
}

