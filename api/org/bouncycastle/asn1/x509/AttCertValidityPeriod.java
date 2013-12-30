package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;






public class AttCertValidityPeriod extends ASN1Encodable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.852 -0500", hash_original_method = "74F498B55FB68D93DAFE2C1357919BFF", hash_generated_method = "1153F5E8BD8298EFFE7837E954E85782")
    
public static AttCertValidityPeriod getInstance(
            Object  obj)
    {
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.847 -0500", hash_original_field = "47DE96B4FD02A134DD50DFF525BEE2DC", hash_generated_field = "47DE96B4FD02A134DD50DFF525BEE2DC")

    DERGeneralizedTime  notBeforeTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.849 -0500", hash_original_field = "F8DBABB88A466E46C9DA55A579BE1BBD", hash_generated_field = "F8DBABB88A466E46C9DA55A579BE1BBD")

    DERGeneralizedTime  notAfterTime;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.854 -0500", hash_original_method = "4935F5EA06A87E5EB822F7F5CCD2C830", hash_generated_method = "39A4AF2D9F6BD675365DC8CB03944E39")
    
public AttCertValidityPeriod(
        ASN1Sequence    seq)
    {
        if (seq.size() != 2)
        {
            throw new IllegalArgumentException("Bad sequence size: "
                    + seq.size());
        }

        notBeforeTime = DERGeneralizedTime.getInstance(seq.getObjectAt(0));
        notAfterTime = DERGeneralizedTime.getInstance(seq.getObjectAt(1));
    }

    /**
     * @param notBeforeTime
     * @param notAfterTime
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.858 -0500", hash_original_method = "EE3E4821B31B071C83A5954362B6FCF9", hash_generated_method = "8D7AD889F370A1E5C71857438584093E")
    
public AttCertValidityPeriod(
        DERGeneralizedTime notBeforeTime,
        DERGeneralizedTime notAfterTime)
    {
        this.notBeforeTime = notBeforeTime;
        this.notAfterTime = notAfterTime;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.860 -0500", hash_original_method = "61005B71BB5E250DAD749F45259F34BB", hash_generated_method = "EFC6F30FE31D5A57584A7000D0C741E5")
    
public DERGeneralizedTime getNotBeforeTime()
    {
        return notBeforeTime;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.862 -0500", hash_original_method = "3C0941D5D83A6A464C361337736D354A", hash_generated_method = "B15A0DB1053307709A16A02C67369B73")
    
public DERGeneralizedTime getNotAfterTime()
    {
        return notAfterTime;
    }

    /**
     * Produce an object suitable for an ASN1OutputStream.
     * <pre>
     *  AttCertValidityPeriod  ::= SEQUENCE {
     *       notBeforeTime  GeneralizedTime,
     *       notAfterTime   GeneralizedTime
     *  } 
     * </pre>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:20.864 -0500", hash_original_method = "F304C055A3AB57005A726D651B674F2F", hash_generated_method = "186E7F585650074D7AFA534FA667CCDA")
    
public DERObject toASN1Object()
    {
        ASN1EncodableVector  v = new ASN1EncodableVector();

        v.add(notBeforeTime);
        v.add(notAfterTime);

        return new DERSequence(v);
    }

    
}

