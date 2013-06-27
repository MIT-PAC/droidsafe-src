package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.DERUTCTime;

public class TBSCertList extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.254 -0400", hash_original_field = "E068C2DE26D760F20CF10AFC4B87EF0F", hash_generated_field = "67B66723C4558F27E19029159A09253A")

    ASN1Sequence seq;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.254 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "E228CDE1667030A19BE9074EE632C2E6")

    DERInteger version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.254 -0400", hash_original_field = "AC201FD270C3B96BEAB24F2829780AB2", hash_generated_field = "A9C2427A585DE5C2846E517FA208C326")

    AlgorithmIdentifier signature;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.254 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "5D6D7F9E9DB3838227A35E0CE4DA4A40")

    X509Name issuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.255 -0400", hash_original_field = "5A57C2EC88FCBD38D012B98CFBA87F36", hash_generated_field = "F7307148EA192C2AC6829F3D6478616E")

    Time thisUpdate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.255 -0400", hash_original_field = "0795B4516D5D7B11F363991643178A98", hash_generated_field = "81E26EA846E6309FDA2B763EEE4322CF")

    Time nextUpdate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.255 -0400", hash_original_field = "0B6950E312B7638124011FB2B7D7DB5E", hash_generated_field = "AE9FB0F92F5352F3D989DA8B1E3BF6E8")

    ASN1Sequence revokedCertificates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.256 -0400", hash_original_field = "FCA1AF483E9CDF6520BB02D488ABDB91", hash_generated_field = "32AFE711317FCCD7D6FFF9CE186DE901")

    X509Extensions crlExtensions;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.264 -0400", hash_original_method = "979311BA6EB06D915E93C36961984E0B", hash_generated_method = "73BA127F115BBFDDE3E5BF757349635F")
    public  TBSCertList(
        ASN1Sequence  seq) {
        {
            boolean var21ED16CA67443A0A274B847563FDA10F_1292787777 = (seq.size() < 3 || seq.size() > 7);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad sequence size: " + seq.size());
            } //End block
        } //End collapsed parenthetic
        int seqPos;
        seqPos = 0;
        this.seq = seq;
        {
            boolean var01755594B3C45A8CC2076460D5A8C2D0_758873621 = (seq.getObjectAt(seqPos) instanceof DERInteger);
            {
                version = DERInteger.getInstance(seq.getObjectAt(seqPos++));
            } //End block
            {
                version = new DERInteger(0);
            } //End block
        } //End collapsed parenthetic
        signature = AlgorithmIdentifier.getInstance(seq.getObjectAt(seqPos++));
        issuer = X509Name.getInstance(seq.getObjectAt(seqPos++));
        thisUpdate = Time.getInstance(seq.getObjectAt(seqPos++));
        {
            boolean var37853308D9A84798E00BA68EE3B5576A_423601217 = (seqPos < seq.size()
            && (seq.getObjectAt(seqPos) instanceof DERUTCTime
               || seq.getObjectAt(seqPos) instanceof DERGeneralizedTime
               || seq.getObjectAt(seqPos) instanceof Time));
            {
                nextUpdate = Time.getInstance(seq.getObjectAt(seqPos++));
            } //End block
        } //End collapsed parenthetic
        {
            boolean var40A9D6CFDAB571D594A331C79D092F69_980583440 = (seqPos < seq.size()
            && !(seq.getObjectAt(seqPos) instanceof DERTaggedObject));
            {
                revokedCertificates = ASN1Sequence.getInstance(seq.getObjectAt(seqPos++));
            } //End block
        } //End collapsed parenthetic
        {
            boolean var48E487CC4644F2A9B839624D6894AE63_1148275917 = (seqPos < seq.size()
            && seq.getObjectAt(seqPos) instanceof DERTaggedObject);
            {
                crlExtensions = X509Extensions.getInstance(seq.getObjectAt(seqPos));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static TBSCertList getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    
        public static TBSCertList getInstance(
        Object  obj) {
        if (obj instanceof TBSCertList)
        {
            return (TBSCertList)obj;
        }
        else if (obj instanceof ASN1Sequence)
        {
            return new TBSCertList((ASN1Sequence)obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.265 -0400", hash_original_method = "FDACF2D9FDD982F7370FC1531628D869", hash_generated_method = "6673B1122C370AB447D8D7B658F4DE81")
    public int getVersion() {
        int varB5DB73F7B840BF8BC35281016B62125C_1502263378 = (version.getValue().intValue() + 1);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_190511409 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_190511409;
        // ---------- Original Method ----------
        //return version.getValue().intValue() + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.266 -0400", hash_original_method = "AC16A6F43E56B222CBB33342980501D7", hash_generated_method = "465B546FD5533DC98539FD6EFBDAF11B")
    public DERInteger getVersionNumber() {
        DERInteger varB4EAC82CA7396A68D541C85D26508E83_1706548436 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1706548436 = version;
        varB4EAC82CA7396A68D541C85D26508E83_1706548436.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1706548436;
        // ---------- Original Method ----------
        //return version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.266 -0400", hash_original_method = "DD6542667BFDE70B879F723105C92A71", hash_generated_method = "A4288B9C94500E0DADD83C9FADE6D18D")
    public AlgorithmIdentifier getSignature() {
        AlgorithmIdentifier varB4EAC82CA7396A68D541C85D26508E83_1256807911 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1256807911 = signature;
        varB4EAC82CA7396A68D541C85D26508E83_1256807911.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1256807911;
        // ---------- Original Method ----------
        //return signature;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.278 -0400", hash_original_method = "45BDDD2025565616026FAE1CCD324C0F", hash_generated_method = "5D28F0F4BD17D4575239960202E66E74")
    public X509Name getIssuer() {
        X509Name varB4EAC82CA7396A68D541C85D26508E83_1089436798 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1089436798 = issuer;
        varB4EAC82CA7396A68D541C85D26508E83_1089436798.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1089436798;
        // ---------- Original Method ----------
        //return issuer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.278 -0400", hash_original_method = "13C3CAE3E054BA140B8F621AE3EA7547", hash_generated_method = "E65DD89E83FCF5AD4980B95C57F5608D")
    public Time getThisUpdate() {
        Time varB4EAC82CA7396A68D541C85D26508E83_1648825661 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1648825661 = thisUpdate;
        varB4EAC82CA7396A68D541C85D26508E83_1648825661.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1648825661;
        // ---------- Original Method ----------
        //return thisUpdate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.279 -0400", hash_original_method = "A77204D0766EFD8AD6F24F7F347199B2", hash_generated_method = "BD2F181FF1B4C880ACCEED2F1389F2F4")
    public Time getNextUpdate() {
        Time varB4EAC82CA7396A68D541C85D26508E83_394898936 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_394898936 = nextUpdate;
        varB4EAC82CA7396A68D541C85D26508E83_394898936.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_394898936;
        // ---------- Original Method ----------
        //return nextUpdate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.286 -0400", hash_original_method = "CEAEC6FC0ECB759CC0350D156B5BC4BE", hash_generated_method = "0FCAC2F6CE508036F16DCFD59A22618D")
    public CRLEntry[] getRevokedCertificates() {
        CRLEntry[] varB4EAC82CA7396A68D541C85D26508E83_762475602 = null; //Variable for return #1
        CRLEntry[] varB4EAC82CA7396A68D541C85D26508E83_1938651084 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_762475602 = new CRLEntry[0];
        } //End block
        CRLEntry[] entries;
        entries = new CRLEntry[revokedCertificates.size()];
        {
            int i;
            i = 0;
            {
                entries[i] = new CRLEntry(ASN1Sequence.getInstance(revokedCertificates.getObjectAt(i)));
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1938651084 = entries;
        CRLEntry[] varA7E53CE21691AB073D9660D615818899_804779649; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_804779649 = varB4EAC82CA7396A68D541C85D26508E83_762475602;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_804779649 = varB4EAC82CA7396A68D541C85D26508E83_1938651084;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_804779649.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_804779649;
        // ---------- Original Method ----------
        //if (revokedCertificates == null)
        //{
            //return new CRLEntry[0];
        //}
        //CRLEntry[] entries = new CRLEntry[revokedCertificates.size()];
        //for (int i = 0; i < entries.length; i++)
        //{
            //entries[i] = new CRLEntry(ASN1Sequence.getInstance(revokedCertificates.getObjectAt(i)));
        //}
        //return entries;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.287 -0400", hash_original_method = "6375844A31081D053220C645D0F9B87E", hash_generated_method = "B626512721F039D8974F5074E7AF9371")
    public Enumeration getRevokedCertificateEnumeration() {
        Enumeration varB4EAC82CA7396A68D541C85D26508E83_604282224 = null; //Variable for return #1
        Enumeration varB4EAC82CA7396A68D541C85D26508E83_1690528147 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_604282224 = new EmptyEnumeration();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1690528147 = new RevokedCertificatesEnumeration(revokedCertificates.getObjects());
        Enumeration varA7E53CE21691AB073D9660D615818899_1160933328; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1160933328 = varB4EAC82CA7396A68D541C85D26508E83_604282224;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1160933328 = varB4EAC82CA7396A68D541C85D26508E83_1690528147;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1160933328.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1160933328;
        // ---------- Original Method ----------
        //if (revokedCertificates == null)
        //{
            //return new EmptyEnumeration();
        //}
        //return new RevokedCertificatesEnumeration(revokedCertificates.getObjects());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.287 -0400", hash_original_method = "CDE1CFE7081DEA43241E45471E737135", hash_generated_method = "0358B4CDF17C3F3CBB6093BA61319E2E")
    public X509Extensions getExtensions() {
        X509Extensions varB4EAC82CA7396A68D541C85D26508E83_1632076472 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1632076472 = crlExtensions;
        varB4EAC82CA7396A68D541C85D26508E83_1632076472.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1632076472;
        // ---------- Original Method ----------
        //return crlExtensions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.288 -0400", hash_original_method = "0BE753B103EB5E27F0AD9CE4B67E8D14", hash_generated_method = "DCC322F893940A64204CE1D341D11C35")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_698125243 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_698125243 = seq;
        varB4EAC82CA7396A68D541C85D26508E83_698125243.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_698125243;
        // ---------- Original Method ----------
        //return seq;
    }

    
    public static class CRLEntry extends ASN1Encodable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.288 -0400", hash_original_field = "E068C2DE26D760F20CF10AFC4B87EF0F", hash_generated_field = "67B66723C4558F27E19029159A09253A")

        ASN1Sequence seq;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.288 -0400", hash_original_field = "71A5BB307937C590A67CEB96CF72CF12", hash_generated_field = "2B07ABA517A3C72D4D1AE840B26D1CBC")

        DERInteger userCertificate;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.288 -0400", hash_original_field = "30D935E32E2556ADF9A447D78BEC8E47", hash_generated_field = "6E03E433A7A3E5DD51EB4D05094D4199")

        Time revocationDate;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.288 -0400", hash_original_field = "AD8C0148B3A586F917CF6245F9F618B8", hash_generated_field = "16E9DEFD70BF4A992A02A9F3935A2277")

        X509Extensions crlEntryExtensions;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.296 -0400", hash_original_method = "5E4E4AC1AFC14B33E134B0DE6A66EF69", hash_generated_method = "2B210A2C4F9C4B54A027835C38A34FD4")
        public  CRLEntry(
            ASN1Sequence  seq) {
            {
                boolean varA160258BC3B6C3888C3C365D75E7ADD2_1432895086 = (seq.size() < 2 || seq.size() > 3);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad sequence size: " + seq.size());
                } //End block
            } //End collapsed parenthetic
            this.seq = seq;
            userCertificate = DERInteger.getInstance(seq.getObjectAt(0));
            revocationDate = Time.getInstance(seq.getObjectAt(1));
            // ---------- Original Method ----------
            //if (seq.size() < 2 || seq.size() > 3)
            //{
                //throw new IllegalArgumentException("Bad sequence size: " + seq.size());
            //}
            //this.seq = seq;
            //userCertificate = DERInteger.getInstance(seq.getObjectAt(0));
            //revocationDate = Time.getInstance(seq.getObjectAt(1));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.300 -0400", hash_original_method = "4F65DC188C3501616DCFC998DA7DBFCB", hash_generated_method = "B1EA0B0C9D181CF856278D2A19FB1788")
        public DERInteger getUserCertificate() {
            DERInteger varB4EAC82CA7396A68D541C85D26508E83_1776690383 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1776690383 = userCertificate;
            varB4EAC82CA7396A68D541C85D26508E83_1776690383.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1776690383;
            // ---------- Original Method ----------
            //return userCertificate;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.305 -0400", hash_original_method = "4B493204B476D887C77BCF51D1F57DB2", hash_generated_method = "29B747EADA624C7162E851CC07870692")
        public Time getRevocationDate() {
            Time varB4EAC82CA7396A68D541C85D26508E83_1135657337 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1135657337 = revocationDate;
            varB4EAC82CA7396A68D541C85D26508E83_1135657337.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1135657337;
            // ---------- Original Method ----------
            //return revocationDate;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.306 -0400", hash_original_method = "15344AC9965F1BCC242E7479E06915DE", hash_generated_method = "A9DA26EF60AC9B46F2F46D3DE21257A8")
        public X509Extensions getExtensions() {
            X509Extensions varB4EAC82CA7396A68D541C85D26508E83_164053078 = null; //Variable for return #1
            {
                boolean varB18CB2CF52CBE8C75F89242B7DF09E84_2132182649 = (crlEntryExtensions == null && seq.size() == 3);
                {
                    crlEntryExtensions = X509Extensions.getInstance(seq.getObjectAt(2));
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_164053078 = crlEntryExtensions;
            varB4EAC82CA7396A68D541C85D26508E83_164053078.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_164053078;
            // ---------- Original Method ----------
            //if (crlEntryExtensions == null && seq.size() == 3)
            //{
                //crlEntryExtensions = X509Extensions.getInstance(seq.getObjectAt(2));
            //}
            //return crlEntryExtensions;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.306 -0400", hash_original_method = "0BE753B103EB5E27F0AD9CE4B67E8D14", hash_generated_method = "2CEA2A7E7E3AA9E052F32CBF1F080CEA")
        public DERObject toASN1Object() {
            DERObject varB4EAC82CA7396A68D541C85D26508E83_1951867517 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1951867517 = seq;
            varB4EAC82CA7396A68D541C85D26508E83_1951867517.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1951867517;
            // ---------- Original Method ----------
            //return seq;
        }

        
    }


    
    private class RevokedCertificatesEnumeration implements Enumeration {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.306 -0400", hash_original_field = "9CFEFED8FB9497BAA5CD519D7D2BB5D7", hash_generated_field = "B0D8CED81BAB00EB7CFC8DD7778DE583")

        private Enumeration en;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.307 -0400", hash_original_method = "6A29318C110C11222950EB9111D0EBEA", hash_generated_method = "CA8192B4B33D4156BE2130DE3439FDDC")
          RevokedCertificatesEnumeration(Enumeration en) {
            this.en = en;
            // ---------- Original Method ----------
            //this.en = en;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.307 -0400", hash_original_method = "FBC842E02AF9214599A6659CADABA547", hash_generated_method = "AF23169252A6542441EAE2EFE4C19C28")
        public boolean hasMoreElements() {
            boolean varB188EF125CE599069C2B3F78653D629C_975654834 = (en.hasMoreElements());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_451885005 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_451885005;
            // ---------- Original Method ----------
            //return en.hasMoreElements();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.307 -0400", hash_original_method = "09463CFA8BEF092B2195E66AA891F38D", hash_generated_method = "C987A6872636C14D4F4881EC7FC58309")
        public Object nextElement() {
            Object varB4EAC82CA7396A68D541C85D26508E83_846258921 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_846258921 = new CRLEntry(ASN1Sequence.getInstance(en.nextElement()));
            varB4EAC82CA7396A68D541C85D26508E83_846258921.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_846258921;
            // ---------- Original Method ----------
            //return new CRLEntry(ASN1Sequence.getInstance(en.nextElement()));
        }

        
    }


    
    private class EmptyEnumeration implements Enumeration {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.307 -0400", hash_original_method = "7DE508FCF70F724013E54D107E91DAB2", hash_generated_method = "7DE508FCF70F724013E54D107E91DAB2")
        public EmptyEnumeration ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.308 -0400", hash_original_method = "50CD0E92886EDA5BEE0164B092B351EC", hash_generated_method = "63FA73BC84C830CE89C8129B97BE9066")
        public boolean hasMoreElements() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_511290655 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_511290655;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.308 -0400", hash_original_method = "6A32EEF26E654AE1CD00BB3EBA8A611E", hash_generated_method = "7486C69497B656C8EB8BDEE64BBC6712")
        public Object nextElement() {
            Object varB4EAC82CA7396A68D541C85D26508E83_217905347 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_217905347 = null;
            varB4EAC82CA7396A68D541C85D26508E83_217905347.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_217905347;
            // ---------- Original Method ----------
            //return null;
        }

        
    }


    
}

