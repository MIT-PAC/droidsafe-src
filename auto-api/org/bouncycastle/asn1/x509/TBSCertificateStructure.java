package org.bouncycastle.asn1.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.022 -0400", hash_original_field = "E068C2DE26D760F20CF10AFC4B87EF0F", hash_generated_field = "67B66723C4558F27E19029159A09253A")

    ASN1Sequence seq;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.022 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "E228CDE1667030A19BE9074EE632C2E6")

    DERInteger version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.022 -0400", hash_original_field = "071878F85C90E53E15AAC400B22E48B5", hash_generated_field = "61F6E9A806268A4DFEFDDB24EB7F542C")

    DERInteger serialNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.022 -0400", hash_original_field = "AC201FD270C3B96BEAB24F2829780AB2", hash_generated_field = "A9C2427A585DE5C2846E517FA208C326")

    AlgorithmIdentifier signature;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.022 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "5D6D7F9E9DB3838227A35E0CE4DA4A40")

    X509Name issuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.022 -0400", hash_original_field = "E4DFB3F5DD911DC868EB4F2C2A836D64", hash_generated_field = "DE01625B0FD536262A10F3B23586D456")

    Time startDate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.022 -0400", hash_original_field = "813E94378D42501D835B2ED6253DC463", hash_generated_field = "368D4323F52DEF40161D12727D58B4F3")

    Time endDate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.022 -0400", hash_original_field = "B5E3374E43F6544852F7751DFC529100", hash_generated_field = "4344A061EE66BE44C834258CE9FA8F22")

    X509Name subject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.022 -0400", hash_original_field = "EC8B3961E3C6839FC6F3EA0F5AA3F1BE", hash_generated_field = "B0B8278CF79DE1BD38516FAC424CAD16")

    SubjectPublicKeyInfo subjectPublicKeyInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.022 -0400", hash_original_field = "8BF7DA96D5D88AA731FA0548F72AFA8B", hash_generated_field = "88D9B3E531838E1A98E9372502638388")

    DERBitString issuerUniqueId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.022 -0400", hash_original_field = "F5A5FF35B5DBE192034F639F88E3740D", hash_generated_field = "2C76406ED67582A5FA081A7A2D9B2868")

    DERBitString subjectUniqueId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.022 -0400", hash_original_field = "2AC737D240FC746CEF37129B7569F08E", hash_generated_field = "2BA375987D179ECB55F007F92DADE11C")

    X509Extensions extensions;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.023 -0400", hash_original_method = "F026064B24F5E7FC18B81DFF22C18AC9", hash_generated_method = "0C6A203B5F2A40EAD6248F14942F8D93")
    public  TBSCertificateStructure(
        ASN1Sequence  seq) {
        int seqStart = 0;
        this.seq = seq;
        {
            boolean var3988B84B0073E20EECE1CAE51F086249_64493538 = (seq.getObjectAt(0) instanceof DERTaggedObject);
            {
                version = DERInteger.getInstance((ASN1TaggedObject)seq.getObjectAt(0), true);
            } 
            {
                seqStart = -1;
                version = new DERInteger(0);
            } 
        } 
        serialNumber = DERInteger.getInstance(seq.getObjectAt(seqStart + 1));
        signature = AlgorithmIdentifier.getInstance(seq.getObjectAt(seqStart + 2));
        issuer = X509Name.getInstance(seq.getObjectAt(seqStart + 3));
        ASN1Sequence dates = (ASN1Sequence)seq.getObjectAt(seqStart + 4);
        startDate = Time.getInstance(dates.getObjectAt(0));
        endDate = Time.getInstance(dates.getObjectAt(1));
        subject = X509Name.getInstance(seq.getObjectAt(seqStart + 5));
        subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(seq.getObjectAt(seqStart + 6));
        {
            int extras = seq.size() - (seqStart + 6) - 1;
            {
                DERTaggedObject extra = (DERTaggedObject)seq.getObjectAt(seqStart + 6 + extras);
                {
                    Object var30FBA01FAEE674C40D117DCDD4D83491_1941265705 = (extra.getTagNo());
                    
                    issuerUniqueId = DERBitString.getInstance(extra, false);
                    
                    
                    subjectUniqueId = DERBitString.getInstance(extra, false);
                    
                    
                    extensions = X509Extensions.getInstance(extra);
                    
                } 
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static TBSCertificateStructure getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.024 -0400", hash_original_method = "FDACF2D9FDD982F7370FC1531628D869", hash_generated_method = "52323FBDEED8C61CA329DC7D2A8DCD79")
    public int getVersion() {
        int varB5DB73F7B840BF8BC35281016B62125C_1153036717 = (version.getValue().intValue() + 1);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1790817445 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1790817445;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.024 -0400", hash_original_method = "AC16A6F43E56B222CBB33342980501D7", hash_generated_method = "9AD2BB0B83E7609B1011AADFC6D02150")
    public DERInteger getVersionNumber() {
        DERInteger varB4EAC82CA7396A68D541C85D26508E83_1051113941 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1051113941 = version;
        varB4EAC82CA7396A68D541C85D26508E83_1051113941.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1051113941;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.025 -0400", hash_original_method = "FB637D35FB72ECF5302334390BEEB5AC", hash_generated_method = "C2F203BDA2E73F14725A3582252E7DF7")
    public DERInteger getSerialNumber() {
        DERInteger varB4EAC82CA7396A68D541C85D26508E83_880505194 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_880505194 = serialNumber;
        varB4EAC82CA7396A68D541C85D26508E83_880505194.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_880505194;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.025 -0400", hash_original_method = "DD6542667BFDE70B879F723105C92A71", hash_generated_method = "A1AB30AD3FE9FEF7C7FFB546F519C69C")
    public AlgorithmIdentifier getSignature() {
        AlgorithmIdentifier varB4EAC82CA7396A68D541C85D26508E83_638686593 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_638686593 = signature;
        varB4EAC82CA7396A68D541C85D26508E83_638686593.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_638686593;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.026 -0400", hash_original_method = "45BDDD2025565616026FAE1CCD324C0F", hash_generated_method = "FCD7A5712966E4BD8B0CED771A840506")
    public X509Name getIssuer() {
        X509Name varB4EAC82CA7396A68D541C85D26508E83_998322243 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_998322243 = issuer;
        varB4EAC82CA7396A68D541C85D26508E83_998322243.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_998322243;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.027 -0400", hash_original_method = "909D374C3F5E114020E1939F16D3CF76", hash_generated_method = "F95B853645BCF1852712A3F355B9838D")
    public Time getStartDate() {
        Time varB4EAC82CA7396A68D541C85D26508E83_1751630416 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1751630416 = startDate;
        varB4EAC82CA7396A68D541C85D26508E83_1751630416.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1751630416;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.027 -0400", hash_original_method = "B4A95AF8DCBBCB951EF2EC33D2077725", hash_generated_method = "4741B1953CBBCC3EF3F3929FAC3AE941")
    public Time getEndDate() {
        Time varB4EAC82CA7396A68D541C85D26508E83_1601364984 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1601364984 = endDate;
        varB4EAC82CA7396A68D541C85D26508E83_1601364984.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1601364984;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.027 -0400", hash_original_method = "CA422C660E8CA6347A77201218B988AE", hash_generated_method = "609D9C301C834ED80AE28C3F287477F8")
    public X509Name getSubject() {
        X509Name varB4EAC82CA7396A68D541C85D26508E83_414602408 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_414602408 = subject;
        varB4EAC82CA7396A68D541C85D26508E83_414602408.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_414602408;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.028 -0400", hash_original_method = "EE5B5FDD20BC2C4F67CD8D0C39F17B3D", hash_generated_method = "B14B68D3343DC124AA3480BB17D21946")
    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        SubjectPublicKeyInfo varB4EAC82CA7396A68D541C85D26508E83_822460147 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_822460147 = subjectPublicKeyInfo;
        varB4EAC82CA7396A68D541C85D26508E83_822460147.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_822460147;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.028 -0400", hash_original_method = "6F6E1D43C4C5F3E57DDB874B276B463E", hash_generated_method = "A2C3160BBA8E2C34B0247FBB33D887D9")
    public DERBitString getIssuerUniqueId() {
        DERBitString varB4EAC82CA7396A68D541C85D26508E83_1527911431 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1527911431 = issuerUniqueId;
        varB4EAC82CA7396A68D541C85D26508E83_1527911431.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1527911431;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.028 -0400", hash_original_method = "9788F7D9ABBC525B6D86ECC001203156", hash_generated_method = "940A16CD5ABB9AB9C3F1D8E95899400F")
    public DERBitString getSubjectUniqueId() {
        DERBitString varB4EAC82CA7396A68D541C85D26508E83_1194451112 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1194451112 = subjectUniqueId;
        varB4EAC82CA7396A68D541C85D26508E83_1194451112.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1194451112;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.029 -0400", hash_original_method = "0A664DE086A2ED08A47FCC7544F0D12E", hash_generated_method = "70FB2069734D9749BC2CCBF2F2F56558")
    public X509Extensions getExtensions() {
        X509Extensions varB4EAC82CA7396A68D541C85D26508E83_1566792948 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1566792948 = extensions;
        varB4EAC82CA7396A68D541C85D26508E83_1566792948.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1566792948;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.029 -0400", hash_original_method = "0BE753B103EB5E27F0AD9CE4B67E8D14", hash_generated_method = "39164668397D7A0B3FE6A56F6987A32E")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1984190714 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1984190714 = seq;
        varB4EAC82CA7396A68D541C85D26508E83_1984190714.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1984190714;
        
        
    }

    
}

