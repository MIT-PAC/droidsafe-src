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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.259 -0400", hash_original_field = "E068C2DE26D760F20CF10AFC4B87EF0F", hash_generated_field = "67B66723C4558F27E19029159A09253A")

    ASN1Sequence seq;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.259 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "E228CDE1667030A19BE9074EE632C2E6")

    DERInteger version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.259 -0400", hash_original_field = "AC201FD270C3B96BEAB24F2829780AB2", hash_generated_field = "A9C2427A585DE5C2846E517FA208C326")

    AlgorithmIdentifier signature;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.259 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "5D6D7F9E9DB3838227A35E0CE4DA4A40")

    X509Name issuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.259 -0400", hash_original_field = "5A57C2EC88FCBD38D012B98CFBA87F36", hash_generated_field = "F7307148EA192C2AC6829F3D6478616E")

    Time thisUpdate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.259 -0400", hash_original_field = "0795B4516D5D7B11F363991643178A98", hash_generated_field = "81E26EA846E6309FDA2B763EEE4322CF")

    Time nextUpdate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.259 -0400", hash_original_field = "0B6950E312B7638124011FB2B7D7DB5E", hash_generated_field = "AE9FB0F92F5352F3D989DA8B1E3BF6E8")

    ASN1Sequence revokedCertificates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.259 -0400", hash_original_field = "FCA1AF483E9CDF6520BB02D488ABDB91", hash_generated_field = "32AFE711317FCCD7D6FFF9CE186DE901")

    X509Extensions crlExtensions;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.261 -0400", hash_original_method = "979311BA6EB06D915E93C36961984E0B", hash_generated_method = "B27F7D730B9D9F71B2A85B0EE003CC77")
    public  TBSCertList(
        ASN1Sequence  seq) {
        {
            boolean var21ED16CA67443A0A274B847563FDA10F_582773812 = (seq.size() < 3 || seq.size() > 7);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad sequence size: " + seq.size());
            } //End block
        } //End collapsed parenthetic
        int seqPos;
        seqPos = 0;
        this.seq = seq;
        {
            boolean var01755594B3C45A8CC2076460D5A8C2D0_1173764499 = (seq.getObjectAt(seqPos) instanceof DERInteger);
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
            boolean var37853308D9A84798E00BA68EE3B5576A_587499704 = (seqPos < seq.size()
            && (seq.getObjectAt(seqPos) instanceof DERUTCTime
               || seq.getObjectAt(seqPos) instanceof DERGeneralizedTime
               || seq.getObjectAt(seqPos) instanceof Time));
            {
                nextUpdate = Time.getInstance(seq.getObjectAt(seqPos++));
            } //End block
        } //End collapsed parenthetic
        {
            boolean var40A9D6CFDAB571D594A331C79D092F69_665896392 = (seqPos < seq.size()
            && !(seq.getObjectAt(seqPos) instanceof DERTaggedObject));
            {
                revokedCertificates = ASN1Sequence.getInstance(seq.getObjectAt(seqPos++));
            } //End block
        } //End collapsed parenthetic
        {
            boolean var48E487CC4644F2A9B839624D6894AE63_999381425 = (seqPos < seq.size()
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.272 -0400", hash_original_method = "FDACF2D9FDD982F7370FC1531628D869", hash_generated_method = "F2B451E4B1CD5B15C3E20DF2360B09C1")
    public int getVersion() {
        int varB5DB73F7B840BF8BC35281016B62125C_2085474086 = (version.getValue().intValue() + 1);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_530610359 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_530610359;
        // ---------- Original Method ----------
        //return version.getValue().intValue() + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.277 -0400", hash_original_method = "AC16A6F43E56B222CBB33342980501D7", hash_generated_method = "077FCE6B337F7A3B0B9052367479A99B")
    public DERInteger getVersionNumber() {
        DERInteger varB4EAC82CA7396A68D541C85D26508E83_1663197626 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1663197626 = version;
        varB4EAC82CA7396A68D541C85D26508E83_1663197626.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1663197626;
        // ---------- Original Method ----------
        //return version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.278 -0400", hash_original_method = "DD6542667BFDE70B879F723105C92A71", hash_generated_method = "CB3DD96A41A1F52B6F7BB31929ED3EEA")
    public AlgorithmIdentifier getSignature() {
        AlgorithmIdentifier varB4EAC82CA7396A68D541C85D26508E83_1677080784 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1677080784 = signature;
        varB4EAC82CA7396A68D541C85D26508E83_1677080784.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1677080784;
        // ---------- Original Method ----------
        //return signature;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.279 -0400", hash_original_method = "45BDDD2025565616026FAE1CCD324C0F", hash_generated_method = "4D2D030ABDA89B8F978283AD67B85B0A")
    public X509Name getIssuer() {
        X509Name varB4EAC82CA7396A68D541C85D26508E83_150549159 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_150549159 = issuer;
        varB4EAC82CA7396A68D541C85D26508E83_150549159.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_150549159;
        // ---------- Original Method ----------
        //return issuer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.284 -0400", hash_original_method = "13C3CAE3E054BA140B8F621AE3EA7547", hash_generated_method = "C0344A7D3949FE05A4CAF826807A6688")
    public Time getThisUpdate() {
        Time varB4EAC82CA7396A68D541C85D26508E83_2024582194 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2024582194 = thisUpdate;
        varB4EAC82CA7396A68D541C85D26508E83_2024582194.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2024582194;
        // ---------- Original Method ----------
        //return thisUpdate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.299 -0400", hash_original_method = "A77204D0766EFD8AD6F24F7F347199B2", hash_generated_method = "95FF97B7B8C0A33061962CE551995B30")
    public Time getNextUpdate() {
        Time varB4EAC82CA7396A68D541C85D26508E83_1116310057 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1116310057 = nextUpdate;
        varB4EAC82CA7396A68D541C85D26508E83_1116310057.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1116310057;
        // ---------- Original Method ----------
        //return nextUpdate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.300 -0400", hash_original_method = "CEAEC6FC0ECB759CC0350D156B5BC4BE", hash_generated_method = "F8E8F2A5A9F9933CC6C6C757C29D651B")
    public CRLEntry[] getRevokedCertificates() {
        CRLEntry[] varB4EAC82CA7396A68D541C85D26508E83_764979316 = null; //Variable for return #1
        CRLEntry[] varB4EAC82CA7396A68D541C85D26508E83_783599822 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_764979316 = new CRLEntry[0];
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
        varB4EAC82CA7396A68D541C85D26508E83_783599822 = entries;
        CRLEntry[] varA7E53CE21691AB073D9660D615818899_1788343016; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1788343016 = varB4EAC82CA7396A68D541C85D26508E83_764979316;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1788343016 = varB4EAC82CA7396A68D541C85D26508E83_783599822;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1788343016.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1788343016;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.302 -0400", hash_original_method = "6375844A31081D053220C645D0F9B87E", hash_generated_method = "166EBE4FCA3C4D69A095A903A022F907")
    public Enumeration getRevokedCertificateEnumeration() {
        Enumeration varB4EAC82CA7396A68D541C85D26508E83_709022051 = null; //Variable for return #1
        Enumeration varB4EAC82CA7396A68D541C85D26508E83_1573410309 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_709022051 = new EmptyEnumeration();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1573410309 = new RevokedCertificatesEnumeration(revokedCertificates.getObjects());
        Enumeration varA7E53CE21691AB073D9660D615818899_254859565; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_254859565 = varB4EAC82CA7396A68D541C85D26508E83_709022051;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_254859565 = varB4EAC82CA7396A68D541C85D26508E83_1573410309;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_254859565.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_254859565;
        // ---------- Original Method ----------
        //if (revokedCertificates == null)
        //{
            //return new EmptyEnumeration();
        //}
        //return new RevokedCertificatesEnumeration(revokedCertificates.getObjects());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.302 -0400", hash_original_method = "CDE1CFE7081DEA43241E45471E737135", hash_generated_method = "4B45D4EF5017A39F624531C3CD976FF4")
    public X509Extensions getExtensions() {
        X509Extensions varB4EAC82CA7396A68D541C85D26508E83_730826840 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_730826840 = crlExtensions;
        varB4EAC82CA7396A68D541C85D26508E83_730826840.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_730826840;
        // ---------- Original Method ----------
        //return crlExtensions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.303 -0400", hash_original_method = "0BE753B103EB5E27F0AD9CE4B67E8D14", hash_generated_method = "AA858EDCED730EAF583A50F982924A55")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1118144952 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1118144952 = seq;
        varB4EAC82CA7396A68D541C85D26508E83_1118144952.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1118144952;
        // ---------- Original Method ----------
        //return seq;
    }

    
    public static class CRLEntry extends ASN1Encodable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.311 -0400", hash_original_field = "E068C2DE26D760F20CF10AFC4B87EF0F", hash_generated_field = "67B66723C4558F27E19029159A09253A")

        ASN1Sequence seq;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.311 -0400", hash_original_field = "71A5BB307937C590A67CEB96CF72CF12", hash_generated_field = "2B07ABA517A3C72D4D1AE840B26D1CBC")

        DERInteger userCertificate;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.311 -0400", hash_original_field = "30D935E32E2556ADF9A447D78BEC8E47", hash_generated_field = "6E03E433A7A3E5DD51EB4D05094D4199")

        Time revocationDate;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.312 -0400", hash_original_field = "AD8C0148B3A586F917CF6245F9F618B8", hash_generated_field = "16E9DEFD70BF4A992A02A9F3935A2277")

        X509Extensions crlEntryExtensions;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.312 -0400", hash_original_method = "5E4E4AC1AFC14B33E134B0DE6A66EF69", hash_generated_method = "A701088476D53409D04C7F6AEF60791A")
        public  CRLEntry(
            ASN1Sequence  seq) {
            {
                boolean varA160258BC3B6C3888C3C365D75E7ADD2_1176090452 = (seq.size() < 2 || seq.size() > 3);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.316 -0400", hash_original_method = "4F65DC188C3501616DCFC998DA7DBFCB", hash_generated_method = "7269244DA32152AA3238B1F39FE88FB5")
        public DERInteger getUserCertificate() {
            DERInteger varB4EAC82CA7396A68D541C85D26508E83_151333549 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_151333549 = userCertificate;
            varB4EAC82CA7396A68D541C85D26508E83_151333549.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_151333549;
            // ---------- Original Method ----------
            //return userCertificate;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.325 -0400", hash_original_method = "4B493204B476D887C77BCF51D1F57DB2", hash_generated_method = "495AF2110AB18FC6FD2AC8C485E3D702")
        public Time getRevocationDate() {
            Time varB4EAC82CA7396A68D541C85D26508E83_34544528 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_34544528 = revocationDate;
            varB4EAC82CA7396A68D541C85D26508E83_34544528.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_34544528;
            // ---------- Original Method ----------
            //return revocationDate;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.326 -0400", hash_original_method = "15344AC9965F1BCC242E7479E06915DE", hash_generated_method = "E0875F8F43867DDA1494C9FF16AEA812")
        public X509Extensions getExtensions() {
            X509Extensions varB4EAC82CA7396A68D541C85D26508E83_421807801 = null; //Variable for return #1
            {
                boolean varB18CB2CF52CBE8C75F89242B7DF09E84_1470422742 = (crlEntryExtensions == null && seq.size() == 3);
                {
                    crlEntryExtensions = X509Extensions.getInstance(seq.getObjectAt(2));
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_421807801 = crlEntryExtensions;
            varB4EAC82CA7396A68D541C85D26508E83_421807801.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_421807801;
            // ---------- Original Method ----------
            //if (crlEntryExtensions == null && seq.size() == 3)
            //{
                //crlEntryExtensions = X509Extensions.getInstance(seq.getObjectAt(2));
            //}
            //return crlEntryExtensions;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.326 -0400", hash_original_method = "0BE753B103EB5E27F0AD9CE4B67E8D14", hash_generated_method = "70AE7E3204E76F265DF2226B2F546F71")
        public DERObject toASN1Object() {
            DERObject varB4EAC82CA7396A68D541C85D26508E83_945233751 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_945233751 = seq;
            varB4EAC82CA7396A68D541C85D26508E83_945233751.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_945233751;
            // ---------- Original Method ----------
            //return seq;
        }

        
    }


    
    private class RevokedCertificatesEnumeration implements Enumeration {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.327 -0400", hash_original_field = "9CFEFED8FB9497BAA5CD519D7D2BB5D7", hash_generated_field = "B0D8CED81BAB00EB7CFC8DD7778DE583")

        private Enumeration en;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.327 -0400", hash_original_method = "6A29318C110C11222950EB9111D0EBEA", hash_generated_method = "CA8192B4B33D4156BE2130DE3439FDDC")
          RevokedCertificatesEnumeration(Enumeration en) {
            this.en = en;
            // ---------- Original Method ----------
            //this.en = en;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.327 -0400", hash_original_method = "FBC842E02AF9214599A6659CADABA547", hash_generated_method = "CBB104D956ECDA6D980237032FB393B4")
        public boolean hasMoreElements() {
            boolean varB188EF125CE599069C2B3F78653D629C_941613886 = (en.hasMoreElements());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1645014088 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1645014088;
            // ---------- Original Method ----------
            //return en.hasMoreElements();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.327 -0400", hash_original_method = "09463CFA8BEF092B2195E66AA891F38D", hash_generated_method = "88FFFAA95D62C7D1D80826B548C21E0E")
        public Object nextElement() {
            Object varB4EAC82CA7396A68D541C85D26508E83_360002698 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_360002698 = new CRLEntry(ASN1Sequence.getInstance(en.nextElement()));
            varB4EAC82CA7396A68D541C85D26508E83_360002698.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_360002698;
            // ---------- Original Method ----------
            //return new CRLEntry(ASN1Sequence.getInstance(en.nextElement()));
        }

        
    }


    
    private class EmptyEnumeration implements Enumeration {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.328 -0400", hash_original_method = "7DE508FCF70F724013E54D107E91DAB2", hash_generated_method = "7DE508FCF70F724013E54D107E91DAB2")
        public EmptyEnumeration ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.328 -0400", hash_original_method = "50CD0E92886EDA5BEE0164B092B351EC", hash_generated_method = "90F7D287A7F75453093EBFB40DCB7E76")
        public boolean hasMoreElements() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1918473545 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1918473545;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.328 -0400", hash_original_method = "6A32EEF26E654AE1CD00BB3EBA8A611E", hash_generated_method = "7B752283C3C79EF90BA6E3D6C324AB2E")
        public Object nextElement() {
            Object varB4EAC82CA7396A68D541C85D26508E83_1389107193 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1389107193 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1389107193.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1389107193;
            // ---------- Original Method ----------
            //return null;
        }

        
    }


    
}

