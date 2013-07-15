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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.983 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "22EBE359829AB95B300B64E2550F3EA1")

    private DERInteger version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.983 -0400", hash_original_field = "A403F79916FA151CDCC745626E69FED2", hash_generated_field = "563B820D71AB887AFBDC4FA155EF0F94")

    private Holder holder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.983 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "19091383B7F6282BDA73C5A5CBC6602A")

    private AttCertIssuer issuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.983 -0400", hash_original_field = "AC201FD270C3B96BEAB24F2829780AB2", hash_generated_field = "783386BC2A99F90E6BCFC976FA88180B")

    private AlgorithmIdentifier signature;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.983 -0400", hash_original_field = "071878F85C90E53E15AAC400B22E48B5", hash_generated_field = "5FEA8F3298727145BB03455817D3DE5F")

    private DERInteger serialNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.983 -0400", hash_original_field = "33EBF91CF28EA93C9565DBCC8F1E1788", hash_generated_field = "C8E13C4545DF7403FD584DFAE694F588")

    private AttCertValidityPeriod attrCertValidityPeriod;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.983 -0400", hash_original_field = "736B91750E516139ACC13C5EB6564F92", hash_generated_field = "DBB0952120A99FCFC1819E5AA89DC04F")

    private ASN1Sequence attributes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.983 -0400", hash_original_field = "0080B5239E0054A7EDCFA6529FB5BBF8", hash_generated_field = "F6ABE18285D56BD9C63FFD10DEBF5BD7")

    private DERBitString issuerUniqueID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.983 -0400", hash_original_field = "2AC737D240FC746CEF37129B7569F08E", hash_generated_field = "FD88AE5D9F8262A2B65FEAADA7C32BCC")

    private X509Extensions extensions;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.986 -0400", hash_original_method = "C35C344C6189D0B2CCFCB8B319FD5953", hash_generated_method = "5368B297DB82CCB859742E530575AE07")
    public  AttributeCertificateInfo(
        ASN1Sequence   seq) {
    if(seq.size() < 7 || seq.size() > 9)        
        {
            IllegalArgumentException varA2072CF614C7B8C7696DD5A02DBCCE9C_1340008969 = new IllegalArgumentException("Bad sequence size: " + seq.size());
            varA2072CF614C7B8C7696DD5A02DBCCE9C_1340008969.addTaint(taint);
            throw varA2072CF614C7B8C7696DD5A02DBCCE9C_1340008969;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.989 -0400", hash_original_method = "C14C6949EA2D9724014BC15AB24B85D9", hash_generated_method = "04123366E5F65598B9D69A91C400A9BB")
    public DERInteger getVersion() {
DERInteger varE87BEFBC04DA371DFA5B07C77A4407CB_592705055 =         version;
        varE87BEFBC04DA371DFA5B07C77A4407CB_592705055.addTaint(taint);
        return varE87BEFBC04DA371DFA5B07C77A4407CB_592705055;
        // ---------- Original Method ----------
        //return version;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.989 -0400", hash_original_method = "31AEFB5A2FC3B890A5A042FC24D98031", hash_generated_method = "69B9751A5246B391070F58B40E2FDFD5")
    public Holder getHolder() {
Holder varFB58939ED56E085B5946FF7BF43F5A8C_273424686 =         holder;
        varFB58939ED56E085B5946FF7BF43F5A8C_273424686.addTaint(taint);
        return varFB58939ED56E085B5946FF7BF43F5A8C_273424686;
        // ---------- Original Method ----------
        //return holder;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.990 -0400", hash_original_method = "CDB27E7EA4A3B5B10C6A056E131798BE", hash_generated_method = "95B1484B7A19848A21C7B9D6259B134F")
    public AttCertIssuer getIssuer() {
AttCertIssuer var8EF52627413B91AB97DB59853805E979_593086153 =         issuer;
        var8EF52627413B91AB97DB59853805E979_593086153.addTaint(taint);
        return var8EF52627413B91AB97DB59853805E979_593086153;
        // ---------- Original Method ----------
        //return issuer;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.990 -0400", hash_original_method = "DD6542667BFDE70B879F723105C92A71", hash_generated_method = "6FA7B6F48FFCC596AEF0BBE3AB705490")
    public AlgorithmIdentifier getSignature() {
AlgorithmIdentifier varCDF7DED6F053AD37D069B3F1993A6032_498902918 =         signature;
        varCDF7DED6F053AD37D069B3F1993A6032_498902918.addTaint(taint);
        return varCDF7DED6F053AD37D069B3F1993A6032_498902918;
        // ---------- Original Method ----------
        //return signature;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.991 -0400", hash_original_method = "FB637D35FB72ECF5302334390BEEB5AC", hash_generated_method = "2AD1AD36F1CD1F75E62035744E363D9C")
    public DERInteger getSerialNumber() {
DERInteger varC5241B523DA06FB03F5998149659C655_1854587428 =         serialNumber;
        varC5241B523DA06FB03F5998149659C655_1854587428.addTaint(taint);
        return varC5241B523DA06FB03F5998149659C655_1854587428;
        // ---------- Original Method ----------
        //return serialNumber;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.991 -0400", hash_original_method = "3C65423907176C9088B2D87B8798CFAE", hash_generated_method = "049F8886362C23BAB1AB7097335CD6F3")
    public AttCertValidityPeriod getAttrCertValidityPeriod() {
AttCertValidityPeriod varA11F88F9C254C07EAFA8E62902024875_1260746383 =         attrCertValidityPeriod;
        varA11F88F9C254C07EAFA8E62902024875_1260746383.addTaint(taint);
        return varA11F88F9C254C07EAFA8E62902024875_1260746383;
        // ---------- Original Method ----------
        //return attrCertValidityPeriod;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.991 -0400", hash_original_method = "936A2581CBB919961CE40AAE721BB5BA", hash_generated_method = "64018BE543CA9F0973D098E4D6056298")
    public ASN1Sequence getAttributes() {
ASN1Sequence var4BBC8979DB64A9C3E2328AA1E06CDBB3_884643972 =         attributes;
        var4BBC8979DB64A9C3E2328AA1E06CDBB3_884643972.addTaint(taint);
        return var4BBC8979DB64A9C3E2328AA1E06CDBB3_884643972;
        // ---------- Original Method ----------
        //return attributes;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.992 -0400", hash_original_method = "2F58C5477BC934C0C5DF4943197A2496", hash_generated_method = "5C61F1C19BB33FFA93E58DCA080C5AEB")
    public DERBitString getIssuerUniqueID() {
DERBitString varC3F52AB7D2771DF0D802AC3A97EE5387_641511557 =         issuerUniqueID;
        varC3F52AB7D2771DF0D802AC3A97EE5387_641511557.addTaint(taint);
        return varC3F52AB7D2771DF0D802AC3A97EE5387_641511557;
        // ---------- Original Method ----------
        //return issuerUniqueID;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.992 -0400", hash_original_method = "0A664DE086A2ED08A47FCC7544F0D12E", hash_generated_method = "1D622C3CCC1CF2692012F8E6AFFEF18C")
    public X509Extensions getExtensions() {
X509Extensions varD5DA799FFC3665A23EF170042DC373AD_432745922 =         extensions;
        varD5DA799FFC3665A23EF170042DC373AD_432745922.addTaint(taint);
        return varD5DA799FFC3665A23EF170042DC373AD_432745922;
        // ---------- Original Method ----------
        //return extensions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.993 -0400", hash_original_method = "AEBC8D50EAAC05A83CB6DB0736727739", hash_generated_method = "F3577246955EE795C1298AE0DBFD2BAA")
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
DERObject var0B338F106E3279986C87B595B0F4A439_392824238 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_392824238.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_392824238;
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

