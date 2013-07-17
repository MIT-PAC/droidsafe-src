package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class AttributeCertificateInfo extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.628 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "22EBE359829AB95B300B64E2550F3EA1")

    private DERInteger version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.628 -0400", hash_original_field = "A403F79916FA151CDCC745626E69FED2", hash_generated_field = "563B820D71AB887AFBDC4FA155EF0F94")

    private Holder holder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.628 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "19091383B7F6282BDA73C5A5CBC6602A")

    private AttCertIssuer issuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.628 -0400", hash_original_field = "AC201FD270C3B96BEAB24F2829780AB2", hash_generated_field = "783386BC2A99F90E6BCFC976FA88180B")

    private AlgorithmIdentifier signature;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.628 -0400", hash_original_field = "071878F85C90E53E15AAC400B22E48B5", hash_generated_field = "5FEA8F3298727145BB03455817D3DE5F")

    private DERInteger serialNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.629 -0400", hash_original_field = "33EBF91CF28EA93C9565DBCC8F1E1788", hash_generated_field = "C8E13C4545DF7403FD584DFAE694F588")

    private AttCertValidityPeriod attrCertValidityPeriod;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.629 -0400", hash_original_field = "736B91750E516139ACC13C5EB6564F92", hash_generated_field = "DBB0952120A99FCFC1819E5AA89DC04F")

    private ASN1Sequence attributes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.629 -0400", hash_original_field = "0080B5239E0054A7EDCFA6529FB5BBF8", hash_generated_field = "F6ABE18285D56BD9C63FFD10DEBF5BD7")

    private DERBitString issuerUniqueID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.629 -0400", hash_original_field = "2AC737D240FC746CEF37129B7569F08E", hash_generated_field = "FD88AE5D9F8262A2B65FEAADA7C32BCC")

    private X509Extensions extensions;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.631 -0400", hash_original_method = "C35C344C6189D0B2CCFCB8B319FD5953", hash_generated_method = "B42C2C68F00FC403955D82451F78DCD4")
    public  AttributeCertificateInfo(
        ASN1Sequence   seq) {
        if(seq.size() < 7 || seq.size() > 9)        
        {
            IllegalArgumentException varA2072CF614C7B8C7696DD5A02DBCCE9C_1863260380 = new IllegalArgumentException("Bad sequence size: " + seq.size());
            varA2072CF614C7B8C7696DD5A02DBCCE9C_1863260380.addTaint(taint);
            throw varA2072CF614C7B8C7696DD5A02DBCCE9C_1863260380;
        } //End block
        this.version = DERInteger.getInstance(seq.getObjectAt(0));
        this.holder = Holder.getInstance(seq.getObjectAt(1));
        this.issuer = AttCertIssuer.getInstance(seq.getObjectAt(2));
        this.signature = AlgorithmIdentifier.getInstance(seq.getObjectAt(3));
        this.serialNumber = DERInteger.getInstance(seq.getObjectAt(4));
        this.attrCertValidityPeriod = AttCertValidityPeriod.getInstance(seq.getObjectAt(5));
        this.attributes = ASN1Sequence.getInstance(seq.getObjectAt(6));
for(int i = 7;i < seq.size();i++)
        {
            ASN1Encodable obj = (ASN1Encodable)seq.getObjectAt(i);
            if(obj instanceof DERBitString)            
            {
                this.issuerUniqueID = DERBitString.getInstance(seq.getObjectAt(i));
            } //End block
            else
            if(obj instanceof ASN1Sequence || obj instanceof X509Extensions)            
            {
                this.extensions = X509Extensions.getInstance(seq.getObjectAt(i));
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static AttributeCertificateInfo getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    
    public static AttributeCertificateInfo getInstance(
        Object  obj) {
        if (obj instanceof AttributeCertificateInfo)
        {
            return (AttributeCertificateInfo)obj;
        }
        else if (obj instanceof ASN1Sequence)
        {
            return new AttributeCertificateInfo((ASN1Sequence)obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.632 -0400", hash_original_method = "C14C6949EA2D9724014BC15AB24B85D9", hash_generated_method = "45F3A2174D2A8084467388D3304D4EE5")
    public DERInteger getVersion() {
DERInteger varE87BEFBC04DA371DFA5B07C77A4407CB_136621472 =         version;
        varE87BEFBC04DA371DFA5B07C77A4407CB_136621472.addTaint(taint);
        return varE87BEFBC04DA371DFA5B07C77A4407CB_136621472;
        // ---------- Original Method ----------
        //return version;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.632 -0400", hash_original_method = "31AEFB5A2FC3B890A5A042FC24D98031", hash_generated_method = "FBCC184357698AA7BF54183D84846018")
    public Holder getHolder() {
Holder varFB58939ED56E085B5946FF7BF43F5A8C_131504449 =         holder;
        varFB58939ED56E085B5946FF7BF43F5A8C_131504449.addTaint(taint);
        return varFB58939ED56E085B5946FF7BF43F5A8C_131504449;
        // ---------- Original Method ----------
        //return holder;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.633 -0400", hash_original_method = "CDB27E7EA4A3B5B10C6A056E131798BE", hash_generated_method = "C77278A76A00B46C6D0F83AD9D01DB05")
    public AttCertIssuer getIssuer() {
AttCertIssuer var8EF52627413B91AB97DB59853805E979_1925408538 =         issuer;
        var8EF52627413B91AB97DB59853805E979_1925408538.addTaint(taint);
        return var8EF52627413B91AB97DB59853805E979_1925408538;
        // ---------- Original Method ----------
        //return issuer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.633 -0400", hash_original_method = "DD6542667BFDE70B879F723105C92A71", hash_generated_method = "AA9516E3CE11B9C925C2BF399824DA04")
    public AlgorithmIdentifier getSignature() {
AlgorithmIdentifier varCDF7DED6F053AD37D069B3F1993A6032_241849342 =         signature;
        varCDF7DED6F053AD37D069B3F1993A6032_241849342.addTaint(taint);
        return varCDF7DED6F053AD37D069B3F1993A6032_241849342;
        // ---------- Original Method ----------
        //return signature;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.633 -0400", hash_original_method = "FB637D35FB72ECF5302334390BEEB5AC", hash_generated_method = "C12EA6549A016982D0978A10E9C069FC")
    public DERInteger getSerialNumber() {
DERInteger varC5241B523DA06FB03F5998149659C655_977020789 =         serialNumber;
        varC5241B523DA06FB03F5998149659C655_977020789.addTaint(taint);
        return varC5241B523DA06FB03F5998149659C655_977020789;
        // ---------- Original Method ----------
        //return serialNumber;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.633 -0400", hash_original_method = "3C65423907176C9088B2D87B8798CFAE", hash_generated_method = "FFE7D7C80BF3A65DF036CE7A306295BF")
    public AttCertValidityPeriod getAttrCertValidityPeriod() {
AttCertValidityPeriod varA11F88F9C254C07EAFA8E62902024875_2110642921 =         attrCertValidityPeriod;
        varA11F88F9C254C07EAFA8E62902024875_2110642921.addTaint(taint);
        return varA11F88F9C254C07EAFA8E62902024875_2110642921;
        // ---------- Original Method ----------
        //return attrCertValidityPeriod;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.634 -0400", hash_original_method = "936A2581CBB919961CE40AAE721BB5BA", hash_generated_method = "CC886763A341968854B19142EDAF6A6B")
    public ASN1Sequence getAttributes() {
ASN1Sequence var4BBC8979DB64A9C3E2328AA1E06CDBB3_394878475 =         attributes;
        var4BBC8979DB64A9C3E2328AA1E06CDBB3_394878475.addTaint(taint);
        return var4BBC8979DB64A9C3E2328AA1E06CDBB3_394878475;
        // ---------- Original Method ----------
        //return attributes;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.634 -0400", hash_original_method = "2F58C5477BC934C0C5DF4943197A2496", hash_generated_method = "04AD659C59F57182D4CF4D1E80152A76")
    public DERBitString getIssuerUniqueID() {
DERBitString varC3F52AB7D2771DF0D802AC3A97EE5387_840524344 =         issuerUniqueID;
        varC3F52AB7D2771DF0D802AC3A97EE5387_840524344.addTaint(taint);
        return varC3F52AB7D2771DF0D802AC3A97EE5387_840524344;
        // ---------- Original Method ----------
        //return issuerUniqueID;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.634 -0400", hash_original_method = "0A664DE086A2ED08A47FCC7544F0D12E", hash_generated_method = "9BF9BA205B7886F0A1984075DC1CFFBD")
    public X509Extensions getExtensions() {
X509Extensions varD5DA799FFC3665A23EF170042DC373AD_1131253428 =         extensions;
        varD5DA799FFC3665A23EF170042DC373AD_1131253428.addTaint(taint);
        return varD5DA799FFC3665A23EF170042DC373AD_1131253428;
        // ---------- Original Method ----------
        //return extensions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.634 -0400", hash_original_method = "AEBC8D50EAAC05A83CB6DB0736727739", hash_generated_method = "CE69D09B573B8F47511553F1D92264E4")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(version);
        v.add(holder);
        v.add(issuer);
        v.add(signature);
        v.add(serialNumber);
        v.add(attrCertValidityPeriod);
        v.add(attributes);
        if(issuerUniqueID != null)        
        {
            v.add(issuerUniqueID);
        } //End block
        if(extensions != null)        
        {
            v.add(extensions);
        } //End block
DERObject var0B338F106E3279986C87B595B0F4A439_384960245 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_384960245.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_384960245;
        // ---------- Original Method ----------
        //ASN1EncodableVector  v = new ASN1EncodableVector();
        //v.add(version);
        //v.add(holder);
        //v.add(issuer);
        //v.add(signature);
        //v.add(serialNumber);
        //v.add(attrCertValidityPeriod);
        //v.add(attributes);
        //if (issuerUniqueID != null)
        //{
            //v.add(issuerUniqueID);
        //}
        //if (extensions != null)
        //{
            //v.add(extensions);
        //}
        //return new DERSequence(v);
    }

    
}

