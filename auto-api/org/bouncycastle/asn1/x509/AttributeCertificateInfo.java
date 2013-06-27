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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.947 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "22EBE359829AB95B300B64E2550F3EA1")

    private DERInteger version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.947 -0400", hash_original_field = "A403F79916FA151CDCC745626E69FED2", hash_generated_field = "563B820D71AB887AFBDC4FA155EF0F94")

    private Holder holder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.947 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "19091383B7F6282BDA73C5A5CBC6602A")

    private AttCertIssuer issuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.947 -0400", hash_original_field = "AC201FD270C3B96BEAB24F2829780AB2", hash_generated_field = "783386BC2A99F90E6BCFC976FA88180B")

    private AlgorithmIdentifier signature;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.947 -0400", hash_original_field = "071878F85C90E53E15AAC400B22E48B5", hash_generated_field = "5FEA8F3298727145BB03455817D3DE5F")

    private DERInteger serialNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.947 -0400", hash_original_field = "33EBF91CF28EA93C9565DBCC8F1E1788", hash_generated_field = "C8E13C4545DF7403FD584DFAE694F588")

    private AttCertValidityPeriod attrCertValidityPeriod;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.947 -0400", hash_original_field = "736B91750E516139ACC13C5EB6564F92", hash_generated_field = "DBB0952120A99FCFC1819E5AA89DC04F")

    private ASN1Sequence attributes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.947 -0400", hash_original_field = "0080B5239E0054A7EDCFA6529FB5BBF8", hash_generated_field = "F6ABE18285D56BD9C63FFD10DEBF5BD7")

    private DERBitString issuerUniqueID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.947 -0400", hash_original_field = "2AC737D240FC746CEF37129B7569F08E", hash_generated_field = "FD88AE5D9F8262A2B65FEAADA7C32BCC")

    private X509Extensions extensions;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.949 -0400", hash_original_method = "C35C344C6189D0B2CCFCB8B319FD5953", hash_generated_method = "B76AAEA92E1079FBD029C6D792F9A4A6")
    public  AttributeCertificateInfo(
        ASN1Sequence   seq) {
        {
            boolean var30A7C0A71F4FE7B4477356278956F305_1980653844 = (seq.size() < 7 || seq.size() > 9);
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
            boolean var9CD34824B777FD7076E411291F8236A4_1471750299 = (i < seq.size());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.950 -0400", hash_original_method = "C14C6949EA2D9724014BC15AB24B85D9", hash_generated_method = "3137E9A67EB9CAC3B48460B91A2E15EF")
    public DERInteger getVersion() {
        DERInteger varB4EAC82CA7396A68D541C85D26508E83_1125599065 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1125599065 = version;
        varB4EAC82CA7396A68D541C85D26508E83_1125599065.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1125599065;
        // ---------- Original Method ----------
        //return version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.950 -0400", hash_original_method = "31AEFB5A2FC3B890A5A042FC24D98031", hash_generated_method = "656FD309401C8F96D8FFD2E21DE2D3AE")
    public Holder getHolder() {
        Holder varB4EAC82CA7396A68D541C85D26508E83_815528385 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_815528385 = holder;
        varB4EAC82CA7396A68D541C85D26508E83_815528385.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_815528385;
        // ---------- Original Method ----------
        //return holder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.951 -0400", hash_original_method = "CDB27E7EA4A3B5B10C6A056E131798BE", hash_generated_method = "D99A0DDA402798BD2365C6FFEBE7EDC2")
    public AttCertIssuer getIssuer() {
        AttCertIssuer varB4EAC82CA7396A68D541C85D26508E83_1301704605 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1301704605 = issuer;
        varB4EAC82CA7396A68D541C85D26508E83_1301704605.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1301704605;
        // ---------- Original Method ----------
        //return issuer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.952 -0400", hash_original_method = "DD6542667BFDE70B879F723105C92A71", hash_generated_method = "698B9E2DB577617BB9DD9F5177F67E56")
    public AlgorithmIdentifier getSignature() {
        AlgorithmIdentifier varB4EAC82CA7396A68D541C85D26508E83_1472034686 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1472034686 = signature;
        varB4EAC82CA7396A68D541C85D26508E83_1472034686.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1472034686;
        // ---------- Original Method ----------
        //return signature;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.953 -0400", hash_original_method = "FB637D35FB72ECF5302334390BEEB5AC", hash_generated_method = "72FCE7924CBA22984A25F992E38A00A5")
    public DERInteger getSerialNumber() {
        DERInteger varB4EAC82CA7396A68D541C85D26508E83_820094433 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_820094433 = serialNumber;
        varB4EAC82CA7396A68D541C85D26508E83_820094433.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_820094433;
        // ---------- Original Method ----------
        //return serialNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.953 -0400", hash_original_method = "3C65423907176C9088B2D87B8798CFAE", hash_generated_method = "E77C0CF084D4DF40DA2998A5EA512DC5")
    public AttCertValidityPeriod getAttrCertValidityPeriod() {
        AttCertValidityPeriod varB4EAC82CA7396A68D541C85D26508E83_1780017438 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1780017438 = attrCertValidityPeriod;
        varB4EAC82CA7396A68D541C85D26508E83_1780017438.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1780017438;
        // ---------- Original Method ----------
        //return attrCertValidityPeriod;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.953 -0400", hash_original_method = "936A2581CBB919961CE40AAE721BB5BA", hash_generated_method = "B13F6F05248AF608F14C1267637E2E13")
    public ASN1Sequence getAttributes() {
        ASN1Sequence varB4EAC82CA7396A68D541C85D26508E83_1303907729 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1303907729 = attributes;
        varB4EAC82CA7396A68D541C85D26508E83_1303907729.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1303907729;
        // ---------- Original Method ----------
        //return attributes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.954 -0400", hash_original_method = "2F58C5477BC934C0C5DF4943197A2496", hash_generated_method = "0E2A450AFA7ADAEF0F080C0FB051D5DB")
    public DERBitString getIssuerUniqueID() {
        DERBitString varB4EAC82CA7396A68D541C85D26508E83_1236680999 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1236680999 = issuerUniqueID;
        varB4EAC82CA7396A68D541C85D26508E83_1236680999.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1236680999;
        // ---------- Original Method ----------
        //return issuerUniqueID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.954 -0400", hash_original_method = "0A664DE086A2ED08A47FCC7544F0D12E", hash_generated_method = "E5CB0FF20CFEBA6BE5C1FE9E6D43BB1E")
    public X509Extensions getExtensions() {
        X509Extensions varB4EAC82CA7396A68D541C85D26508E83_1208658831 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1208658831 = extensions;
        varB4EAC82CA7396A68D541C85D26508E83_1208658831.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1208658831;
        // ---------- Original Method ----------
        //return extensions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.956 -0400", hash_original_method = "AEBC8D50EAAC05A83CB6DB0736727739", hash_generated_method = "9F81FB7432B3E5F45615A2678E8179D8")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_269181479 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_269181479 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_269181479.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_269181479;
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

