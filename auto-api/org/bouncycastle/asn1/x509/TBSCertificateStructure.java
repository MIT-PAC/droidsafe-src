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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.188 -0400", hash_original_field = "E068C2DE26D760F20CF10AFC4B87EF0F", hash_generated_field = "67B66723C4558F27E19029159A09253A")

    ASN1Sequence seq;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.188 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "E228CDE1667030A19BE9074EE632C2E6")

    DERInteger version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.188 -0400", hash_original_field = "071878F85C90E53E15AAC400B22E48B5", hash_generated_field = "61F6E9A806268A4DFEFDDB24EB7F542C")

    DERInteger serialNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.188 -0400", hash_original_field = "AC201FD270C3B96BEAB24F2829780AB2", hash_generated_field = "A9C2427A585DE5C2846E517FA208C326")

    AlgorithmIdentifier signature;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.188 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "5D6D7F9E9DB3838227A35E0CE4DA4A40")

    X509Name issuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.188 -0400", hash_original_field = "E4DFB3F5DD911DC868EB4F2C2A836D64", hash_generated_field = "DE01625B0FD536262A10F3B23586D456")

    Time startDate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.188 -0400", hash_original_field = "813E94378D42501D835B2ED6253DC463", hash_generated_field = "368D4323F52DEF40161D12727D58B4F3")

    Time endDate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.188 -0400", hash_original_field = "B5E3374E43F6544852F7751DFC529100", hash_generated_field = "4344A061EE66BE44C834258CE9FA8F22")

    X509Name subject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.189 -0400", hash_original_field = "EC8B3961E3C6839FC6F3EA0F5AA3F1BE", hash_generated_field = "B0B8278CF79DE1BD38516FAC424CAD16")

    SubjectPublicKeyInfo subjectPublicKeyInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.189 -0400", hash_original_field = "8BF7DA96D5D88AA731FA0548F72AFA8B", hash_generated_field = "88D9B3E531838E1A98E9372502638388")

    DERBitString issuerUniqueId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.189 -0400", hash_original_field = "F5A5FF35B5DBE192034F639F88E3740D", hash_generated_field = "2C76406ED67582A5FA081A7A2D9B2868")

    DERBitString subjectUniqueId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.189 -0400", hash_original_field = "2AC737D240FC746CEF37129B7569F08E", hash_generated_field = "2BA375987D179ECB55F007F92DADE11C")

    X509Extensions extensions;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.199 -0400", hash_original_method = "F026064B24F5E7FC18B81DFF22C18AC9", hash_generated_method = "432315403D9067039984C2A8572B475C")
    public  TBSCertificateStructure(
        ASN1Sequence  seq) {
        int seqStart;
        seqStart = 0;
        this.seq = seq;
        {
            boolean var3988B84B0073E20EECE1CAE51F086249_1040053307 = (seq.getObjectAt(0) instanceof DERTaggedObject);
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
                    Object var30FBA01FAEE674C40D117DCDD4D83491_207983719 = (extra.getTagNo());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.210 -0400", hash_original_method = "FDACF2D9FDD982F7370FC1531628D869", hash_generated_method = "C7EEC9298E7E7E07E7A0ECA20F4CE4E2")
    public int getVersion() {
        int varB5DB73F7B840BF8BC35281016B62125C_55731229 = (version.getValue().intValue() + 1);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2042963015 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2042963015;
        // ---------- Original Method ----------
        //return version.getValue().intValue() + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.211 -0400", hash_original_method = "AC16A6F43E56B222CBB33342980501D7", hash_generated_method = "0F8888C44308D9B4955A2AD8122B1850")
    public DERInteger getVersionNumber() {
        DERInteger varB4EAC82CA7396A68D541C85D26508E83_243403525 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_243403525 = version;
        varB4EAC82CA7396A68D541C85D26508E83_243403525.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_243403525;
        // ---------- Original Method ----------
        //return version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.211 -0400", hash_original_method = "FB637D35FB72ECF5302334390BEEB5AC", hash_generated_method = "DBDE8647FCC32B9A4772163B0440ED44")
    public DERInteger getSerialNumber() {
        DERInteger varB4EAC82CA7396A68D541C85D26508E83_1045887045 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1045887045 = serialNumber;
        varB4EAC82CA7396A68D541C85D26508E83_1045887045.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1045887045;
        // ---------- Original Method ----------
        //return serialNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.212 -0400", hash_original_method = "DD6542667BFDE70B879F723105C92A71", hash_generated_method = "C811111B3C81544C7D68ECA0D96FB4C3")
    public AlgorithmIdentifier getSignature() {
        AlgorithmIdentifier varB4EAC82CA7396A68D541C85D26508E83_1542868500 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1542868500 = signature;
        varB4EAC82CA7396A68D541C85D26508E83_1542868500.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1542868500;
        // ---------- Original Method ----------
        //return signature;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.212 -0400", hash_original_method = "45BDDD2025565616026FAE1CCD324C0F", hash_generated_method = "FBC63DBAB10A50736CA99A63EDD29C26")
    public X509Name getIssuer() {
        X509Name varB4EAC82CA7396A68D541C85D26508E83_1809254308 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1809254308 = issuer;
        varB4EAC82CA7396A68D541C85D26508E83_1809254308.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1809254308;
        // ---------- Original Method ----------
        //return issuer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.213 -0400", hash_original_method = "909D374C3F5E114020E1939F16D3CF76", hash_generated_method = "727EE2922069D5EDDA7A8566F4AB7849")
    public Time getStartDate() {
        Time varB4EAC82CA7396A68D541C85D26508E83_70719448 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_70719448 = startDate;
        varB4EAC82CA7396A68D541C85D26508E83_70719448.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_70719448;
        // ---------- Original Method ----------
        //return startDate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.213 -0400", hash_original_method = "B4A95AF8DCBBCB951EF2EC33D2077725", hash_generated_method = "37E0CFF9F5AD4DAB80C41CF6474BBF54")
    public Time getEndDate() {
        Time varB4EAC82CA7396A68D541C85D26508E83_732227258 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_732227258 = endDate;
        varB4EAC82CA7396A68D541C85D26508E83_732227258.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_732227258;
        // ---------- Original Method ----------
        //return endDate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.216 -0400", hash_original_method = "CA422C660E8CA6347A77201218B988AE", hash_generated_method = "51AAA2BEE376BB8850582EC3A4310387")
    public X509Name getSubject() {
        X509Name varB4EAC82CA7396A68D541C85D26508E83_510652510 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_510652510 = subject;
        varB4EAC82CA7396A68D541C85D26508E83_510652510.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_510652510;
        // ---------- Original Method ----------
        //return subject;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.217 -0400", hash_original_method = "EE5B5FDD20BC2C4F67CD8D0C39F17B3D", hash_generated_method = "B4A4932FD52F451FE83D124E16E1923A")
    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        SubjectPublicKeyInfo varB4EAC82CA7396A68D541C85D26508E83_149992032 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_149992032 = subjectPublicKeyInfo;
        varB4EAC82CA7396A68D541C85D26508E83_149992032.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_149992032;
        // ---------- Original Method ----------
        //return subjectPublicKeyInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.217 -0400", hash_original_method = "6F6E1D43C4C5F3E57DDB874B276B463E", hash_generated_method = "9118AA888D43B2041D9C02DAE03EC3CF")
    public DERBitString getIssuerUniqueId() {
        DERBitString varB4EAC82CA7396A68D541C85D26508E83_180119946 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_180119946 = issuerUniqueId;
        varB4EAC82CA7396A68D541C85D26508E83_180119946.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_180119946;
        // ---------- Original Method ----------
        //return issuerUniqueId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.224 -0400", hash_original_method = "9788F7D9ABBC525B6D86ECC001203156", hash_generated_method = "464F0D9E1C6C72CDFB4B58AD1D7ACDFF")
    public DERBitString getSubjectUniqueId() {
        DERBitString varB4EAC82CA7396A68D541C85D26508E83_1689497695 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1689497695 = subjectUniqueId;
        varB4EAC82CA7396A68D541C85D26508E83_1689497695.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1689497695;
        // ---------- Original Method ----------
        //return subjectUniqueId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.224 -0400", hash_original_method = "0A664DE086A2ED08A47FCC7544F0D12E", hash_generated_method = "1D92B2D883EA5D5587F0D966AD4A40A7")
    public X509Extensions getExtensions() {
        X509Extensions varB4EAC82CA7396A68D541C85D26508E83_431845830 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_431845830 = extensions;
        varB4EAC82CA7396A68D541C85D26508E83_431845830.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_431845830;
        // ---------- Original Method ----------
        //return extensions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.225 -0400", hash_original_method = "0BE753B103EB5E27F0AD9CE4B67E8D14", hash_generated_method = "4FDD9D1D29270E4720492F37D4E5FC18")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_285105562 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_285105562 = seq;
        varB4EAC82CA7396A68D541C85D26508E83_285105562.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_285105562;
        // ---------- Original Method ----------
        //return seq;
    }

    
}

