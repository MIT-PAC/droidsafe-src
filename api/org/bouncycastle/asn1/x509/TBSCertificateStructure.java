package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;

public class TBSCertificateStructure extends ASN1Encodable implements X509ObjectIdentifiers, PKCSObjectIdentifiers {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.944 -0400", hash_original_field = "E068C2DE26D760F20CF10AFC4B87EF0F", hash_generated_field = "67B66723C4558F27E19029159A09253A")

    ASN1Sequence seq;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.944 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "E228CDE1667030A19BE9074EE632C2E6")

    DERInteger version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.944 -0400", hash_original_field = "071878F85C90E53E15AAC400B22E48B5", hash_generated_field = "61F6E9A806268A4DFEFDDB24EB7F542C")

    DERInteger serialNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.944 -0400", hash_original_field = "AC201FD270C3B96BEAB24F2829780AB2", hash_generated_field = "A9C2427A585DE5C2846E517FA208C326")

    AlgorithmIdentifier signature;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.944 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "5D6D7F9E9DB3838227A35E0CE4DA4A40")

    X509Name issuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.944 -0400", hash_original_field = "E4DFB3F5DD911DC868EB4F2C2A836D64", hash_generated_field = "DE01625B0FD536262A10F3B23586D456")

    Time startDate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.944 -0400", hash_original_field = "813E94378D42501D835B2ED6253DC463", hash_generated_field = "368D4323F52DEF40161D12727D58B4F3")

    Time endDate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.944 -0400", hash_original_field = "B5E3374E43F6544852F7751DFC529100", hash_generated_field = "4344A061EE66BE44C834258CE9FA8F22")

    X509Name subject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.944 -0400", hash_original_field = "EC8B3961E3C6839FC6F3EA0F5AA3F1BE", hash_generated_field = "B0B8278CF79DE1BD38516FAC424CAD16")

    SubjectPublicKeyInfo subjectPublicKeyInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.944 -0400", hash_original_field = "8BF7DA96D5D88AA731FA0548F72AFA8B", hash_generated_field = "88D9B3E531838E1A98E9372502638388")

    DERBitString issuerUniqueId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.944 -0400", hash_original_field = "F5A5FF35B5DBE192034F639F88E3740D", hash_generated_field = "2C76406ED67582A5FA081A7A2D9B2868")

    DERBitString subjectUniqueId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.944 -0400", hash_original_field = "2AC737D240FC746CEF37129B7569F08E", hash_generated_field = "2BA375987D179ECB55F007F92DADE11C")

    X509Extensions extensions;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.947 -0400", hash_original_method = "F026064B24F5E7FC18B81DFF22C18AC9", hash_generated_method = "5CC6E0237D1656960D6E32370721E993")
    public  TBSCertificateStructure(
        ASN1Sequence  seq) {
        int seqStart = 0;
        this.seq = seq;
        if(seq.getObjectAt(0) instanceof DERTaggedObject)        
        {
            version = DERInteger.getInstance((ASN1TaggedObject)seq.getObjectAt(0), true);
        } //End block
        else
        {
            seqStart = -1;
            version = new DERInteger(0);
        } //End block
        serialNumber = DERInteger.getInstance(seq.getObjectAt(seqStart + 1));
        signature = AlgorithmIdentifier.getInstance(seq.getObjectAt(seqStart + 2));
        issuer = X509Name.getInstance(seq.getObjectAt(seqStart + 3));
        ASN1Sequence dates = (ASN1Sequence)seq.getObjectAt(seqStart + 4);
        startDate = Time.getInstance(dates.getObjectAt(0));
        endDate = Time.getInstance(dates.getObjectAt(1));
        subject = X509Name.getInstance(seq.getObjectAt(seqStart + 5));
        subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(seq.getObjectAt(seqStart + 6));
for(int extras = seq.size() - (seqStart + 6) - 1;extras > 0;extras--)
        {
            DERTaggedObject extra = (DERTaggedObject)seq.getObjectAt(seqStart + 6 + extras);
switch(extra.getTagNo()){
            case 1:
            issuerUniqueId = DERBitString.getInstance(extra, false);
            break;
            case 2:
            subjectUniqueId = DERBitString.getInstance(extra, false);
            break;
            case 3:
            extensions = X509Extensions.getInstance(extra);
}
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.948 -0400", hash_original_method = "FDACF2D9FDD982F7370FC1531628D869", hash_generated_method = "960AA80A247D963D23754E0AC6414202")
    public int getVersion() {
        int var4E01D99371F8A746A4C58A8E9E72F05E_2087970624 = (version.getValue().intValue() + 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_889497508 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_889497508;
        // ---------- Original Method ----------
        //return version.getValue().intValue() + 1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.948 -0400", hash_original_method = "AC16A6F43E56B222CBB33342980501D7", hash_generated_method = "798EF37ED45070F1E101F2028C4EA860")
    public DERInteger getVersionNumber() {
DERInteger varE87BEFBC04DA371DFA5B07C77A4407CB_1643328773 =         version;
        varE87BEFBC04DA371DFA5B07C77A4407CB_1643328773.addTaint(taint);
        return varE87BEFBC04DA371DFA5B07C77A4407CB_1643328773;
        // ---------- Original Method ----------
        //return version;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.948 -0400", hash_original_method = "FB637D35FB72ECF5302334390BEEB5AC", hash_generated_method = "4729D5444718A0923193B162AA635745")
    public DERInteger getSerialNumber() {
DERInteger varC5241B523DA06FB03F5998149659C655_124979117 =         serialNumber;
        varC5241B523DA06FB03F5998149659C655_124979117.addTaint(taint);
        return varC5241B523DA06FB03F5998149659C655_124979117;
        // ---------- Original Method ----------
        //return serialNumber;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.948 -0400", hash_original_method = "DD6542667BFDE70B879F723105C92A71", hash_generated_method = "793F44DDFF6609C97449D32F510B9876")
    public AlgorithmIdentifier getSignature() {
AlgorithmIdentifier varCDF7DED6F053AD37D069B3F1993A6032_874591439 =         signature;
        varCDF7DED6F053AD37D069B3F1993A6032_874591439.addTaint(taint);
        return varCDF7DED6F053AD37D069B3F1993A6032_874591439;
        // ---------- Original Method ----------
        //return signature;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.949 -0400", hash_original_method = "45BDDD2025565616026FAE1CCD324C0F", hash_generated_method = "454060B28F384ED28C1F90A418039344")
    public X509Name getIssuer() {
X509Name var8EF52627413B91AB97DB59853805E979_1715548670 =         issuer;
        var8EF52627413B91AB97DB59853805E979_1715548670.addTaint(taint);
        return var8EF52627413B91AB97DB59853805E979_1715548670;
        // ---------- Original Method ----------
        //return issuer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.949 -0400", hash_original_method = "909D374C3F5E114020E1939F16D3CF76", hash_generated_method = "9104B48B858F647DCB256E5C0372C04A")
    public Time getStartDate() {
Time var6261FAF9C8E7C29EA81EE84682F84B85_1005571334 =         startDate;
        var6261FAF9C8E7C29EA81EE84682F84B85_1005571334.addTaint(taint);
        return var6261FAF9C8E7C29EA81EE84682F84B85_1005571334;
        // ---------- Original Method ----------
        //return startDate;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.949 -0400", hash_original_method = "B4A95AF8DCBBCB951EF2EC33D2077725", hash_generated_method = "45740216D037474AE6371531D759A225")
    public Time getEndDate() {
Time var85AADBA0ADC505F040C6B2CE25429C05_1246973375 =         endDate;
        var85AADBA0ADC505F040C6B2CE25429C05_1246973375.addTaint(taint);
        return var85AADBA0ADC505F040C6B2CE25429C05_1246973375;
        // ---------- Original Method ----------
        //return endDate;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.949 -0400", hash_original_method = "CA422C660E8CA6347A77201218B988AE", hash_generated_method = "31FF455A27DA114E95B2120D042E1405")
    public X509Name getSubject() {
X509Name varC07EC1407326EABEF2FB6D781FE48674_549365250 =         subject;
        varC07EC1407326EABEF2FB6D781FE48674_549365250.addTaint(taint);
        return varC07EC1407326EABEF2FB6D781FE48674_549365250;
        // ---------- Original Method ----------
        //return subject;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.950 -0400", hash_original_method = "EE5B5FDD20BC2C4F67CD8D0C39F17B3D", hash_generated_method = "A7494F9BDFB06FFD990552AB23851CD2")
    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
SubjectPublicKeyInfo var56C0C95C3EE73FCF29C802F24ADDBB81_873870797 =         subjectPublicKeyInfo;
        var56C0C95C3EE73FCF29C802F24ADDBB81_873870797.addTaint(taint);
        return var56C0C95C3EE73FCF29C802F24ADDBB81_873870797;
        // ---------- Original Method ----------
        //return subjectPublicKeyInfo;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.950 -0400", hash_original_method = "6F6E1D43C4C5F3E57DDB874B276B463E", hash_generated_method = "04CE8088FCD3D5119FBEEB8919E1D1C7")
    public DERBitString getIssuerUniqueId() {
DERBitString varC10373B37D512D7FA9423530FDD7A45F_1487966181 =         issuerUniqueId;
        varC10373B37D512D7FA9423530FDD7A45F_1487966181.addTaint(taint);
        return varC10373B37D512D7FA9423530FDD7A45F_1487966181;
        // ---------- Original Method ----------
        //return issuerUniqueId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.950 -0400", hash_original_method = "9788F7D9ABBC525B6D86ECC001203156", hash_generated_method = "606A3E383085811575437A3DEFD54F39")
    public DERBitString getSubjectUniqueId() {
DERBitString varF05C31D6B4BD7647C8AABBD578AC656D_807590456 =         subjectUniqueId;
        varF05C31D6B4BD7647C8AABBD578AC656D_807590456.addTaint(taint);
        return varF05C31D6B4BD7647C8AABBD578AC656D_807590456;
        // ---------- Original Method ----------
        //return subjectUniqueId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.950 -0400", hash_original_method = "0A664DE086A2ED08A47FCC7544F0D12E", hash_generated_method = "BE16D22AE1DC260BF60C5019DF4EF6A5")
    public X509Extensions getExtensions() {
X509Extensions varD5DA799FFC3665A23EF170042DC373AD_640918769 =         extensions;
        varD5DA799FFC3665A23EF170042DC373AD_640918769.addTaint(taint);
        return varD5DA799FFC3665A23EF170042DC373AD_640918769;
        // ---------- Original Method ----------
        //return extensions;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.951 -0400", hash_original_method = "0BE753B103EB5E27F0AD9CE4B67E8D14", hash_generated_method = "D59ABFA3E3154DB8470DA7B4DDA9FFF2")
    public DERObject toASN1Object() {
DERObject var42A78C062640017A329FA085150BC1B8_265249272 =         seq;
        var42A78C062640017A329FA085150BC1B8_265249272.addTaint(taint);
        return var42A78C062640017A329FA085150BC1B8_265249272;
        // ---------- Original Method ----------
        //return seq;
    }

    
}

