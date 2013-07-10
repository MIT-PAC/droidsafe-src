package org.bouncycastle.asn1.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.979 -0400", hash_original_field = "E068C2DE26D760F20CF10AFC4B87EF0F", hash_generated_field = "67B66723C4558F27E19029159A09253A")

    ASN1Sequence seq;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.979 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "E228CDE1667030A19BE9074EE632C2E6")

    DERInteger version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.979 -0400", hash_original_field = "AC201FD270C3B96BEAB24F2829780AB2", hash_generated_field = "A9C2427A585DE5C2846E517FA208C326")

    AlgorithmIdentifier signature;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.979 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "5D6D7F9E9DB3838227A35E0CE4DA4A40")

    X509Name issuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.979 -0400", hash_original_field = "5A57C2EC88FCBD38D012B98CFBA87F36", hash_generated_field = "F7307148EA192C2AC6829F3D6478616E")

    Time thisUpdate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.979 -0400", hash_original_field = "0795B4516D5D7B11F363991643178A98", hash_generated_field = "81E26EA846E6309FDA2B763EEE4322CF")

    Time nextUpdate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.979 -0400", hash_original_field = "0B6950E312B7638124011FB2B7D7DB5E", hash_generated_field = "AE9FB0F92F5352F3D989DA8B1E3BF6E8")

    ASN1Sequence revokedCertificates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.979 -0400", hash_original_field = "FCA1AF483E9CDF6520BB02D488ABDB91", hash_generated_field = "32AFE711317FCCD7D6FFF9CE186DE901")

    X509Extensions crlExtensions;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.980 -0400", hash_original_method = "979311BA6EB06D915E93C36961984E0B", hash_generated_method = "AC56A790B7E2AC8EAAECAA9A52CB6308")
    public  TBSCertList(
        ASN1Sequence  seq) {
        {
            boolean var21ED16CA67443A0A274B847563FDA10F_1817636577 = (seq.size() < 3 || seq.size() > 7);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad sequence size: " + seq.size());
            } 
        } 
        int seqPos = 0;
        this.seq = seq;
        {
            boolean var01755594B3C45A8CC2076460D5A8C2D0_1849112071 = (seq.getObjectAt(seqPos) instanceof DERInteger);
            {
                version = DERInteger.getInstance(seq.getObjectAt(seqPos++));
            } 
            {
                version = new DERInteger(0);
            } 
        } 
        signature = AlgorithmIdentifier.getInstance(seq.getObjectAt(seqPos++));
        issuer = X509Name.getInstance(seq.getObjectAt(seqPos++));
        thisUpdate = Time.getInstance(seq.getObjectAt(seqPos++));
        {
            boolean var37853308D9A84798E00BA68EE3B5576A_773407759 = (seqPos < seq.size()
            && (seq.getObjectAt(seqPos) instanceof DERUTCTime
               || seq.getObjectAt(seqPos) instanceof DERGeneralizedTime
               || seq.getObjectAt(seqPos) instanceof Time));
            {
                nextUpdate = Time.getInstance(seq.getObjectAt(seqPos++));
            } 
        } 
        {
            boolean var40A9D6CFDAB571D594A331C79D092F69_1194184455 = (seqPos < seq.size()
            && !(seq.getObjectAt(seqPos) instanceof DERTaggedObject));
            {
                revokedCertificates = ASN1Sequence.getInstance(seq.getObjectAt(seqPos++));
            } 
        } 
        {
            boolean var48E487CC4644F2A9B839624D6894AE63_722805911 = (seqPos < seq.size()
            && seq.getObjectAt(seqPos) instanceof DERTaggedObject);
            {
                crlExtensions = X509Extensions.getInstance(seq.getObjectAt(seqPos));
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static TBSCertList getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.981 -0400", hash_original_method = "FDACF2D9FDD982F7370FC1531628D869", hash_generated_method = "18D95435014253BA3454CD2EB3CAAF6A")
    public int getVersion() {
        int varB5DB73F7B840BF8BC35281016B62125C_176904072 = (version.getValue().intValue() + 1);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_473161140 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_473161140;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.981 -0400", hash_original_method = "AC16A6F43E56B222CBB33342980501D7", hash_generated_method = "0A40F4C2D1466686036215FF111C8894")
    public DERInteger getVersionNumber() {
        DERInteger varB4EAC82CA7396A68D541C85D26508E83_1975806451 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1975806451 = version;
        varB4EAC82CA7396A68D541C85D26508E83_1975806451.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1975806451;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.981 -0400", hash_original_method = "DD6542667BFDE70B879F723105C92A71", hash_generated_method = "AB4F1564E835C6DE18F56767B695D3D2")
    public AlgorithmIdentifier getSignature() {
        AlgorithmIdentifier varB4EAC82CA7396A68D541C85D26508E83_934570327 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_934570327 = signature;
        varB4EAC82CA7396A68D541C85D26508E83_934570327.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_934570327;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.982 -0400", hash_original_method = "45BDDD2025565616026FAE1CCD324C0F", hash_generated_method = "8211BD84F1492A7F00BA38E238BA7686")
    public X509Name getIssuer() {
        X509Name varB4EAC82CA7396A68D541C85D26508E83_1861579464 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1861579464 = issuer;
        varB4EAC82CA7396A68D541C85D26508E83_1861579464.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1861579464;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.982 -0400", hash_original_method = "13C3CAE3E054BA140B8F621AE3EA7547", hash_generated_method = "B1A93507D86DECFBDE564EDF3C7580C9")
    public Time getThisUpdate() {
        Time varB4EAC82CA7396A68D541C85D26508E83_2015502857 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2015502857 = thisUpdate;
        varB4EAC82CA7396A68D541C85D26508E83_2015502857.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2015502857;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.983 -0400", hash_original_method = "A77204D0766EFD8AD6F24F7F347199B2", hash_generated_method = "5D70E3A64C8C8B28C512BC49BE2979CF")
    public Time getNextUpdate() {
        Time varB4EAC82CA7396A68D541C85D26508E83_1524054913 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1524054913 = nextUpdate;
        varB4EAC82CA7396A68D541C85D26508E83_1524054913.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1524054913;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.984 -0400", hash_original_method = "CEAEC6FC0ECB759CC0350D156B5BC4BE", hash_generated_method = "911935001D0AA386765F31D616449C80")
    public CRLEntry[] getRevokedCertificates() {
        CRLEntry[] varB4EAC82CA7396A68D541C85D26508E83_597201018 = null; 
        CRLEntry[] varB4EAC82CA7396A68D541C85D26508E83_2100739056 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_597201018 = new CRLEntry[0];
        } 
        CRLEntry[] entries = new CRLEntry[revokedCertificates.size()];
        {
            int i = 0;
            {
                entries[i] = new CRLEntry(ASN1Sequence.getInstance(revokedCertificates.getObjectAt(i)));
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2100739056 = entries;
        CRLEntry[] varA7E53CE21691AB073D9660D615818899_1165013311; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1165013311 = varB4EAC82CA7396A68D541C85D26508E83_597201018;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1165013311 = varB4EAC82CA7396A68D541C85D26508E83_2100739056;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1165013311.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1165013311;
        
        
        
            
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.984 -0400", hash_original_method = "6375844A31081D053220C645D0F9B87E", hash_generated_method = "42C4FDD8F97679999EB87046D72F7754")
    public Enumeration getRevokedCertificateEnumeration() {
        Enumeration varB4EAC82CA7396A68D541C85D26508E83_1942260992 = null; 
        Enumeration varB4EAC82CA7396A68D541C85D26508E83_20753381 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1942260992 = new EmptyEnumeration();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_20753381 = new RevokedCertificatesEnumeration(revokedCertificates.getObjects());
        Enumeration varA7E53CE21691AB073D9660D615818899_480168992; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_480168992 = varB4EAC82CA7396A68D541C85D26508E83_1942260992;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_480168992 = varB4EAC82CA7396A68D541C85D26508E83_20753381;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_480168992.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_480168992;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.985 -0400", hash_original_method = "CDE1CFE7081DEA43241E45471E737135", hash_generated_method = "4FE7627154FF2A8B9BC71BAA50BC4D58")
    public X509Extensions getExtensions() {
        X509Extensions varB4EAC82CA7396A68D541C85D26508E83_2118878003 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2118878003 = crlExtensions;
        varB4EAC82CA7396A68D541C85D26508E83_2118878003.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2118878003;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.985 -0400", hash_original_method = "0BE753B103EB5E27F0AD9CE4B67E8D14", hash_generated_method = "84F136B9D9E1053F9BFDFCD7CF8C2664")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1594677040 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1594677040 = seq;
        varB4EAC82CA7396A68D541C85D26508E83_1594677040.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1594677040;
        
        
    }

    
    public static class CRLEntry extends ASN1Encodable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.985 -0400", hash_original_field = "E068C2DE26D760F20CF10AFC4B87EF0F", hash_generated_field = "67B66723C4558F27E19029159A09253A")

        ASN1Sequence seq;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.985 -0400", hash_original_field = "71A5BB307937C590A67CEB96CF72CF12", hash_generated_field = "2B07ABA517A3C72D4D1AE840B26D1CBC")

        DERInteger userCertificate;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.985 -0400", hash_original_field = "30D935E32E2556ADF9A447D78BEC8E47", hash_generated_field = "6E03E433A7A3E5DD51EB4D05094D4199")

        Time revocationDate;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.985 -0400", hash_original_field = "AD8C0148B3A586F917CF6245F9F618B8", hash_generated_field = "16E9DEFD70BF4A992A02A9F3935A2277")

        X509Extensions crlEntryExtensions;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.986 -0400", hash_original_method = "5E4E4AC1AFC14B33E134B0DE6A66EF69", hash_generated_method = "BD3DC95C6191A9B2899B72C131C63194")
        public  CRLEntry(
            ASN1Sequence  seq) {
            {
                boolean varA160258BC3B6C3888C3C365D75E7ADD2_2046611295 = (seq.size() < 2 || seq.size() > 3);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad sequence size: " + seq.size());
                } 
            } 
            this.seq = seq;
            userCertificate = DERInteger.getInstance(seq.getObjectAt(0));
            revocationDate = Time.getInstance(seq.getObjectAt(1));
            
            
            
                
            
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.986 -0400", hash_original_method = "4F65DC188C3501616DCFC998DA7DBFCB", hash_generated_method = "710D9D36F189C7D99D34638831EF6BAE")
        public DERInteger getUserCertificate() {
            DERInteger varB4EAC82CA7396A68D541C85D26508E83_1339354920 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1339354920 = userCertificate;
            varB4EAC82CA7396A68D541C85D26508E83_1339354920.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1339354920;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.986 -0400", hash_original_method = "4B493204B476D887C77BCF51D1F57DB2", hash_generated_method = "1DA3B57685D0D04848EF959D1ECEC953")
        public Time getRevocationDate() {
            Time varB4EAC82CA7396A68D541C85D26508E83_1812033588 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1812033588 = revocationDate;
            varB4EAC82CA7396A68D541C85D26508E83_1812033588.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1812033588;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.987 -0400", hash_original_method = "15344AC9965F1BCC242E7479E06915DE", hash_generated_method = "B7D8FB1A8683F057694C60ADE8154E1D")
        public X509Extensions getExtensions() {
            X509Extensions varB4EAC82CA7396A68D541C85D26508E83_893376072 = null; 
            {
                boolean varB18CB2CF52CBE8C75F89242B7DF09E84_1338060275 = (crlEntryExtensions == null && seq.size() == 3);
                {
                    crlEntryExtensions = X509Extensions.getInstance(seq.getObjectAt(2));
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_893376072 = crlEntryExtensions;
            varB4EAC82CA7396A68D541C85D26508E83_893376072.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_893376072;
            
            
            
                
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.988 -0400", hash_original_method = "0BE753B103EB5E27F0AD9CE4B67E8D14", hash_generated_method = "A93CCB80309A56B33AC3D56133E58B18")
        public DERObject toASN1Object() {
            DERObject varB4EAC82CA7396A68D541C85D26508E83_632132947 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_632132947 = seq;
            varB4EAC82CA7396A68D541C85D26508E83_632132947.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_632132947;
            
            
        }

        
    }


    
    private class RevokedCertificatesEnumeration implements Enumeration {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.988 -0400", hash_original_field = "9CFEFED8FB9497BAA5CD519D7D2BB5D7", hash_generated_field = "B0D8CED81BAB00EB7CFC8DD7778DE583")

        private Enumeration en;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.989 -0400", hash_original_method = "6A29318C110C11222950EB9111D0EBEA", hash_generated_method = "CA8192B4B33D4156BE2130DE3439FDDC")
          RevokedCertificatesEnumeration(Enumeration en) {
            this.en = en;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.990 -0400", hash_original_method = "FBC842E02AF9214599A6659CADABA547", hash_generated_method = "52120165FE4F50B79FA0B2286A830334")
        public boolean hasMoreElements() {
            boolean varB188EF125CE599069C2B3F78653D629C_590223783 = (en.hasMoreElements());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_397422107 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_397422107;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.991 -0400", hash_original_method = "09463CFA8BEF092B2195E66AA891F38D", hash_generated_method = "1DE7E25459B6153FCA02DB740424CD62")
        public Object nextElement() {
            Object varB4EAC82CA7396A68D541C85D26508E83_330782231 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_330782231 = new CRLEntry(ASN1Sequence.getInstance(en.nextElement()));
            varB4EAC82CA7396A68D541C85D26508E83_330782231.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_330782231;
            
            
        }

        
    }


    
    private class EmptyEnumeration implements Enumeration {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.991 -0400", hash_original_method = "7DE508FCF70F724013E54D107E91DAB2", hash_generated_method = "7DE508FCF70F724013E54D107E91DAB2")
        public EmptyEnumeration ()
        {
            
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.992 -0400", hash_original_method = "50CD0E92886EDA5BEE0164B092B351EC", hash_generated_method = "E1CF32CAD7EA4C27A6450EF73A69EE1F")
        public boolean hasMoreElements() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_6259513 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_6259513;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.994 -0400", hash_original_method = "6A32EEF26E654AE1CD00BB3EBA8A611E", hash_generated_method = "27C65079816AD72511B4B4EDDBB92407")
        public Object nextElement() {
            Object varB4EAC82CA7396A68D541C85D26508E83_545882378 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_545882378 = null;
            varB4EAC82CA7396A68D541C85D26508E83_545882378.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_545882378;
            
            
        }

        
    }


    
}

