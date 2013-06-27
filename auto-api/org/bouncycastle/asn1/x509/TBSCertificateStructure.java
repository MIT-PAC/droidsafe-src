package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;

public class TBSCertificateStructure extends ASN1Encodable implements X509ObjectIdentifiers, PKCSObjectIdentifiers {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.194 -0400", hash_original_field = "E068C2DE26D760F20CF10AFC4B87EF0F", hash_generated_field = "67B66723C4558F27E19029159A09253A")

    ASN1Sequence seq;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.195 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "E228CDE1667030A19BE9074EE632C2E6")

    DERInteger version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.195 -0400", hash_original_field = "071878F85C90E53E15AAC400B22E48B5", hash_generated_field = "61F6E9A806268A4DFEFDDB24EB7F542C")

    DERInteger serialNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.195 -0400", hash_original_field = "AC201FD270C3B96BEAB24F2829780AB2", hash_generated_field = "A9C2427A585DE5C2846E517FA208C326")

    AlgorithmIdentifier signature;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.195 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "5D6D7F9E9DB3838227A35E0CE4DA4A40")

    X509Name issuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.195 -0400", hash_original_field = "E4DFB3F5DD911DC868EB4F2C2A836D64", hash_generated_field = "DE01625B0FD536262A10F3B23586D456")

    Time startDate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.195 -0400", hash_original_field = "813E94378D42501D835B2ED6253DC463", hash_generated_field = "368D4323F52DEF40161D12727D58B4F3")

    Time endDate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.195 -0400", hash_original_field = "B5E3374E43F6544852F7751DFC529100", hash_generated_field = "4344A061EE66BE44C834258CE9FA8F22")

    X509Name subject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.195 -0400", hash_original_field = "EC8B3961E3C6839FC6F3EA0F5AA3F1BE", hash_generated_field = "B0B8278CF79DE1BD38516FAC424CAD16")

    SubjectPublicKeyInfo subjectPublicKeyInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.195 -0400", hash_original_field = "8BF7DA96D5D88AA731FA0548F72AFA8B", hash_generated_field = "88D9B3E531838E1A98E9372502638388")

    DERBitString issuerUniqueId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.195 -0400", hash_original_field = "F5A5FF35B5DBE192034F639F88E3740D", hash_generated_field = "2C76406ED67582A5FA081A7A2D9B2868")

    DERBitString subjectUniqueId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.195 -0400", hash_original_field = "2AC737D240FC746CEF37129B7569F08E", hash_generated_field = "2BA375987D179ECB55F007F92DADE11C")

    X509Extensions extensions;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.202 -0400", hash_original_method = "F026064B24F5E7FC18B81DFF22C18AC9", hash_generated_method = "5F3FCE743166786ABF7463011DB5B9DF")
    public  TBSCertificateStructure(
        ASN1Sequence  seq) {
        int seqStart;
        seqStart = 0;
        this.seq = seq;
        {
            boolean var3988B84B0073E20EECE1CAE51F086249_504090624 = (seq.getObjectAt(0) instanceof DERTaggedObject);
            {
                version = DERInteger.getInstance((ASN1TaggedObject)seq.getObjectAt(0), true);
            } //End block
            {
                seqStart = -1;
                version = new DERInteger(0);
            } //End block
        } //End collapsed parenthetic
        serialNumber = DERInteger.getInstance(seq.getObjectAt(seqStart + 1));
        signature = AlgorithmIdentifier.getInstance(seq.getObjectAt(seqStart + 2));
        issuer = X509Name.getInstance(seq.getObjectAt(seqStart + 3));
        ASN1Sequence dates;
        dates = (ASN1Sequence)seq.getObjectAt(seqStart + 4);
        startDate = Time.getInstance(dates.getObjectAt(0));
        endDate = Time.getInstance(dates.getObjectAt(1));
        subject = X509Name.getInstance(seq.getObjectAt(seqStart + 5));
        subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(seq.getObjectAt(seqStart + 6));
        {
            int extras;
            extras = seq.size() - (seqStart + 6) - 1;
            {
                DERTaggedObject extra;
                extra = (DERTaggedObject)seq.getObjectAt(seqStart + 6 + extras);
                {
                    Object var30FBA01FAEE674C40D117DCDD4D83491_2051518415 = (extra.getTagNo());
                    //Begin case 1 
                    issuerUniqueId = DERBitString.getInstance(extra, false);
                    //End case 1 
                    //Begin case 2 
                    subjectUniqueId = DERBitString.getInstance(extra, false);
                    //End case 2 
                    //Begin case 3 
                    extensions = X509Extensions.getInstance(extra);
                    //End case 3 
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static TBSCertificateStructure getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    
        public static TBSCertificateStructure getInstance(
        Object  obj) {
        if (obj instanceof TBSCertificateStructure)
        {
            return (TBSCertificateStructure)obj;
        }
        else if (obj != null)
        {
            return new TBSCertificateStructure(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.203 -0400", hash_original_method = "FDACF2D9FDD982F7370FC1531628D869", hash_generated_method = "C72ED96ABE5353B779EE25CCDBB83076")
    public int getVersion() {
        int varB5DB73F7B840BF8BC35281016B62125C_1910020442 = (version.getValue().intValue() + 1);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_104256238 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_104256238;
        // ---------- Original Method ----------
        //return version.getValue().intValue() + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.203 -0400", hash_original_method = "AC16A6F43E56B222CBB33342980501D7", hash_generated_method = "D4940BEA7510D580F23B2E1725422B15")
    public DERInteger getVersionNumber() {
        DERInteger varB4EAC82CA7396A68D541C85D26508E83_734759256 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_734759256 = version;
        varB4EAC82CA7396A68D541C85D26508E83_734759256.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_734759256;
        // ---------- Original Method ----------
        //return version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.214 -0400", hash_original_method = "FB637D35FB72ECF5302334390BEEB5AC", hash_generated_method = "E85EACC621F97B74A4DFCD609C1A9A48")
    public DERInteger getSerialNumber() {
        DERInteger varB4EAC82CA7396A68D541C85D26508E83_348706476 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_348706476 = serialNumber;
        varB4EAC82CA7396A68D541C85D26508E83_348706476.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_348706476;
        // ---------- Original Method ----------
        //return serialNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.215 -0400", hash_original_method = "DD6542667BFDE70B879F723105C92A71", hash_generated_method = "81C44228E563E5C21CD9179EC1118143")
    public AlgorithmIdentifier getSignature() {
        AlgorithmIdentifier varB4EAC82CA7396A68D541C85D26508E83_1164520986 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1164520986 = signature;
        varB4EAC82CA7396A68D541C85D26508E83_1164520986.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1164520986;
        // ---------- Original Method ----------
        //return signature;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.215 -0400", hash_original_method = "45BDDD2025565616026FAE1CCD324C0F", hash_generated_method = "A971F48458D006CAA7085A387DD677E2")
    public X509Name getIssuer() {
        X509Name varB4EAC82CA7396A68D541C85D26508E83_246098238 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_246098238 = issuer;
        varB4EAC82CA7396A68D541C85D26508E83_246098238.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_246098238;
        // ---------- Original Method ----------
        //return issuer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.216 -0400", hash_original_method = "909D374C3F5E114020E1939F16D3CF76", hash_generated_method = "31041FF3E92C5FB026D52B1265C38C52")
    public Time getStartDate() {
        Time varB4EAC82CA7396A68D541C85D26508E83_1559078058 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1559078058 = startDate;
        varB4EAC82CA7396A68D541C85D26508E83_1559078058.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1559078058;
        // ---------- Original Method ----------
        //return startDate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.216 -0400", hash_original_method = "B4A95AF8DCBBCB951EF2EC33D2077725", hash_generated_method = "03616BEAECDB7F19FCA917599B95E252")
    public Time getEndDate() {
        Time varB4EAC82CA7396A68D541C85D26508E83_901969616 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_901969616 = endDate;
        varB4EAC82CA7396A68D541C85D26508E83_901969616.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_901969616;
        // ---------- Original Method ----------
        //return endDate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.228 -0400", hash_original_method = "CA422C660E8CA6347A77201218B988AE", hash_generated_method = "6858264678E5F2F94A8382242492DCBB")
    public X509Name getSubject() {
        X509Name varB4EAC82CA7396A68D541C85D26508E83_1611926676 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1611926676 = subject;
        varB4EAC82CA7396A68D541C85D26508E83_1611926676.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1611926676;
        // ---------- Original Method ----------
        //return subject;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.232 -0400", hash_original_method = "EE5B5FDD20BC2C4F67CD8D0C39F17B3D", hash_generated_method = "7105B6688105A97C0160EF1857900DCE")
    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        SubjectPublicKeyInfo varB4EAC82CA7396A68D541C85D26508E83_1328393548 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1328393548 = subjectPublicKeyInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1328393548.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1328393548;
        // ---------- Original Method ----------
        //return subjectPublicKeyInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.232 -0400", hash_original_method = "6F6E1D43C4C5F3E57DDB874B276B463E", hash_generated_method = "7D41C065A737BEB01005960104A692CF")
    public DERBitString getIssuerUniqueId() {
        DERBitString varB4EAC82CA7396A68D541C85D26508E83_782208484 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_782208484 = issuerUniqueId;
        varB4EAC82CA7396A68D541C85D26508E83_782208484.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_782208484;
        // ---------- Original Method ----------
        //return issuerUniqueId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.232 -0400", hash_original_method = "9788F7D9ABBC525B6D86ECC001203156", hash_generated_method = "F3530067DD8435ECDEA262ED04B746D4")
    public DERBitString getSubjectUniqueId() {
        DERBitString varB4EAC82CA7396A68D541C85D26508E83_1730555603 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1730555603 = subjectUniqueId;
        varB4EAC82CA7396A68D541C85D26508E83_1730555603.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1730555603;
        // ---------- Original Method ----------
        //return subjectUniqueId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.233 -0400", hash_original_method = "0A664DE086A2ED08A47FCC7544F0D12E", hash_generated_method = "F7B3DD0EFD635B4CE620BC1044F5B43A")
    public X509Extensions getExtensions() {
        X509Extensions varB4EAC82CA7396A68D541C85D26508E83_984868495 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_984868495 = extensions;
        varB4EAC82CA7396A68D541C85D26508E83_984868495.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_984868495;
        // ---------- Original Method ----------
        //return extensions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.237 -0400", hash_original_method = "0BE753B103EB5E27F0AD9CE4B67E8D14", hash_generated_method = "1D6E19414ABB8A9999EAE56C6D45D6E9")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_224639715 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_224639715 = seq;
        varB4EAC82CA7396A68D541C85D26508E83_224639715.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_224639715;
        // ---------- Original Method ----------
        //return seq;
    }

    
}

