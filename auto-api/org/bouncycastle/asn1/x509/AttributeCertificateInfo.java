package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class AttributeCertificateInfo extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.974 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "22EBE359829AB95B300B64E2550F3EA1")

    private DERInteger version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.975 -0400", hash_original_field = "A403F79916FA151CDCC745626E69FED2", hash_generated_field = "563B820D71AB887AFBDC4FA155EF0F94")

    private Holder holder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.975 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "19091383B7F6282BDA73C5A5CBC6602A")

    private AttCertIssuer issuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.975 -0400", hash_original_field = "AC201FD270C3B96BEAB24F2829780AB2", hash_generated_field = "783386BC2A99F90E6BCFC976FA88180B")

    private AlgorithmIdentifier signature;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.975 -0400", hash_original_field = "071878F85C90E53E15AAC400B22E48B5", hash_generated_field = "5FEA8F3298727145BB03455817D3DE5F")

    private DERInteger serialNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.975 -0400", hash_original_field = "33EBF91CF28EA93C9565DBCC8F1E1788", hash_generated_field = "C8E13C4545DF7403FD584DFAE694F588")

    private AttCertValidityPeriod attrCertValidityPeriod;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.975 -0400", hash_original_field = "736B91750E516139ACC13C5EB6564F92", hash_generated_field = "DBB0952120A99FCFC1819E5AA89DC04F")

    private ASN1Sequence attributes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.976 -0400", hash_original_field = "0080B5239E0054A7EDCFA6529FB5BBF8", hash_generated_field = "F6ABE18285D56BD9C63FFD10DEBF5BD7")

    private DERBitString issuerUniqueID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.976 -0400", hash_original_field = "2AC737D240FC746CEF37129B7569F08E", hash_generated_field = "FD88AE5D9F8262A2B65FEAADA7C32BCC")

    private X509Extensions extensions;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.981 -0400", hash_original_method = "C35C344C6189D0B2CCFCB8B319FD5953", hash_generated_method = "F9A2AC3F769CEFA7AE39F0F53C0D2971")
    public  AttributeCertificateInfo(
        ASN1Sequence   seq) {
        {
            boolean var30A7C0A71F4FE7B4477356278956F305_2093250604 = (seq.size() < 7 || seq.size() > 9);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad sequence size: " + seq.size());
            } //End block
        } //End collapsed parenthetic
        this.version = DERInteger.getInstance(seq.getObjectAt(0));
        this.holder = Holder.getInstance(seq.getObjectAt(1));
        this.issuer = AttCertIssuer.getInstance(seq.getObjectAt(2));
        this.signature = AlgorithmIdentifier.getInstance(seq.getObjectAt(3));
        this.serialNumber = DERInteger.getInstance(seq.getObjectAt(4));
        this.attrCertValidityPeriod = AttCertValidityPeriod.getInstance(seq.getObjectAt(5));
        this.attributes = ASN1Sequence.getInstance(seq.getObjectAt(6));
        {
            int i;
            i = 7;
            boolean var9CD34824B777FD7076E411291F8236A4_1704642613 = (i < seq.size());
            {
                ASN1Encodable obj;
                obj = (ASN1Encodable)seq.getObjectAt(i);
                {
                    this.issuerUniqueID = DERBitString.getInstance(seq.getObjectAt(i));
                } //End block
                {
                    this.extensions = X509Extensions.getInstance(seq.getObjectAt(i));
                } //End block
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.982 -0400", hash_original_method = "C14C6949EA2D9724014BC15AB24B85D9", hash_generated_method = "2E5DD59B012B143938EAC3A6EAA12F80")
    public DERInteger getVersion() {
        DERInteger varB4EAC82CA7396A68D541C85D26508E83_2015807568 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2015807568 = version;
        varB4EAC82CA7396A68D541C85D26508E83_2015807568.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2015807568;
        // ---------- Original Method ----------
        //return version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.991 -0400", hash_original_method = "31AEFB5A2FC3B890A5A042FC24D98031", hash_generated_method = "1AA39BCA5FB0042452DDD7C552598881")
    public Holder getHolder() {
        Holder varB4EAC82CA7396A68D541C85D26508E83_1452170513 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1452170513 = holder;
        varB4EAC82CA7396A68D541C85D26508E83_1452170513.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1452170513;
        // ---------- Original Method ----------
        //return holder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.991 -0400", hash_original_method = "CDB27E7EA4A3B5B10C6A056E131798BE", hash_generated_method = "3372F8BB31328E0A8046FE090A183F06")
    public AttCertIssuer getIssuer() {
        AttCertIssuer varB4EAC82CA7396A68D541C85D26508E83_594428108 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_594428108 = issuer;
        varB4EAC82CA7396A68D541C85D26508E83_594428108.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_594428108;
        // ---------- Original Method ----------
        //return issuer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.991 -0400", hash_original_method = "DD6542667BFDE70B879F723105C92A71", hash_generated_method = "4E39A5F321153177A3B09DE3A29B94A0")
    public AlgorithmIdentifier getSignature() {
        AlgorithmIdentifier varB4EAC82CA7396A68D541C85D26508E83_592985759 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_592985759 = signature;
        varB4EAC82CA7396A68D541C85D26508E83_592985759.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_592985759;
        // ---------- Original Method ----------
        //return signature;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.992 -0400", hash_original_method = "FB637D35FB72ECF5302334390BEEB5AC", hash_generated_method = "E338F2F5BA7B9B3FF70B22558ECBD2E8")
    public DERInteger getSerialNumber() {
        DERInteger varB4EAC82CA7396A68D541C85D26508E83_564860386 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_564860386 = serialNumber;
        varB4EAC82CA7396A68D541C85D26508E83_564860386.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_564860386;
        // ---------- Original Method ----------
        //return serialNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.992 -0400", hash_original_method = "3C65423907176C9088B2D87B8798CFAE", hash_generated_method = "D1B09985CB18ED040EF30F2716806A20")
    public AttCertValidityPeriod getAttrCertValidityPeriod() {
        AttCertValidityPeriod varB4EAC82CA7396A68D541C85D26508E83_1798682364 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1798682364 = attrCertValidityPeriod;
        varB4EAC82CA7396A68D541C85D26508E83_1798682364.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1798682364;
        // ---------- Original Method ----------
        //return attrCertValidityPeriod;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.995 -0400", hash_original_method = "936A2581CBB919961CE40AAE721BB5BA", hash_generated_method = "F8B6B4A85D678FCAED59244B0035272C")
    public ASN1Sequence getAttributes() {
        ASN1Sequence varB4EAC82CA7396A68D541C85D26508E83_1574028097 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1574028097 = attributes;
        varB4EAC82CA7396A68D541C85D26508E83_1574028097.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1574028097;
        // ---------- Original Method ----------
        //return attributes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.005 -0400", hash_original_method = "2F58C5477BC934C0C5DF4943197A2496", hash_generated_method = "A02F099B1D266B018DC94A1BA89D3D31")
    public DERBitString getIssuerUniqueID() {
        DERBitString varB4EAC82CA7396A68D541C85D26508E83_856784008 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_856784008 = issuerUniqueID;
        varB4EAC82CA7396A68D541C85D26508E83_856784008.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_856784008;
        // ---------- Original Method ----------
        //return issuerUniqueID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.005 -0400", hash_original_method = "0A664DE086A2ED08A47FCC7544F0D12E", hash_generated_method = "67F1B3EB5D82B4A5B8388A0FF0BAFB97")
    public X509Extensions getExtensions() {
        X509Extensions varB4EAC82CA7396A68D541C85D26508E83_602080977 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_602080977 = extensions;
        varB4EAC82CA7396A68D541C85D26508E83_602080977.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_602080977;
        // ---------- Original Method ----------
        //return extensions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.006 -0400", hash_original_method = "AEBC8D50EAAC05A83CB6DB0736727739", hash_generated_method = "F624CFA600568923A2D58C654EEDA653")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1105428671 = null; //Variable for return #1
        ASN1EncodableVector v;
        v = new ASN1EncodableVector();
        v.add(version);
        v.add(holder);
        v.add(issuer);
        v.add(signature);
        v.add(serialNumber);
        v.add(attrCertValidityPeriod);
        v.add(attributes);
        {
            v.add(issuerUniqueID);
        } //End block
        {
            v.add(extensions);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1105428671 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_1105428671.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1105428671;
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

