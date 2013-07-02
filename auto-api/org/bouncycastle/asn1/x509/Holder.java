package org.bouncycastle.asn1.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class Holder extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.850 -0400", hash_original_field = "C3C2EC65CAD3747AA642E945B7F46D09", hash_generated_field = "BFE641AC9AE66327CCBC4859503216E4")

    IssuerSerial baseCertificateID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.850 -0400", hash_original_field = "8FF1C90F87089FA279CF82F873C8D47B", hash_generated_field = "47FC527E5C61B3740826FB06BA468BAC")

    GeneralNames entityName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.850 -0400", hash_original_field = "035CD4986BAFC5E11EA88A19D8C042C6", hash_generated_field = "0DFE757401959316759693C6B709966B")

    ObjectDigestInfo objectDigestInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.850 -0400", hash_original_field = "E42DADD15D4BC1646E84D1DED9A5D1F5", hash_generated_field = "D02C92BEFB56E93AECDC6D34F25DAE39")

    private int version = 1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.850 -0400", hash_original_method = "0F23F9566CA8F1263E212152AA97F735", hash_generated_method = "8AE6AF3890B3BD13EFE0FDDA5557DEDD")
    public  Holder(ASN1TaggedObject tagObj) {
        {
            Object var5A1D86816B305CAB392BF2B3D11EBEDC_2145987339 = (tagObj.getTagNo());
            
            baseCertificateID = IssuerSerial.getInstance(tagObj, false);
            
            
            entityName = GeneralNames.getInstance(tagObj, false);
            
            
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("unknown tag in Holder");
            
        } 
        version = 0;
        
        
        
        
            
            
        
            
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.851 -0400", hash_original_method = "D380E7678EAEF340CE1A336F4F6AC8E9", hash_generated_method = "3BF98ABC21B6A45A4F2484E7D1DC0CD8")
    public  Holder(ASN1Sequence seq) {
        {
            boolean var889BC8C4BD2008ADA32540CA2FE285A5_729436117 = (seq.size() > 3);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad sequence size: "
                + seq.size());
            } 
        } 
        {
            int i = 0;
            boolean varA93A8909C6B18B3F6367766A0DBBDCF3_1093249987 = (i != seq.size());
            {
                ASN1TaggedObject tObj = ASN1TaggedObject.getInstance(seq
                .getObjectAt(i));
                {
                    Object var506C3BFE4DA0A54A555A4F5441806E9D_196905594 = (tObj.getTagNo());
                    
                    baseCertificateID = IssuerSerial.getInstance(tObj, false);
                    
                    
                    entityName = GeneralNames.getInstance(tObj, false);
                    
                    
                    objectDigestInfo = ObjectDigestInfo.getInstance(tObj, false);
                    
                    
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("unknown tag in Holder");
                    
                } 
            } 
        } 
        version = 1;
        addTaint(seq.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.851 -0400", hash_original_method = "1AE14655F315618D60A29B1C084D2DBC", hash_generated_method = "077E89BAB23042BA20FF3CEB93E06142")
    public  Holder(IssuerSerial baseCertificateID) {
        this.baseCertificateID = baseCertificateID;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.851 -0400", hash_original_method = "DC30675D3133B7CA95C65C37FD001058", hash_generated_method = "8DAAFFADA025829FBF2AA37838285F49")
    public  Holder(IssuerSerial baseCertificateID, int version) {
        this.baseCertificateID = baseCertificateID;
        this.version = version;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.851 -0400", hash_original_method = "4B8FAF3FE0CCE05E8194125D3D22989E", hash_generated_method = "275B12FB499CE8562859E5B2CB2594A6")
    public  Holder(GeneralNames entityName) {
        this.entityName = entityName;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.852 -0400", hash_original_method = "1B9818A91692B880BC908F5EBF39CBC8", hash_generated_method = "D296E5F293EFCF5762839FE906774F0D")
    public  Holder(GeneralNames entityName, int version) {
        this.entityName = entityName;
        this.version = version;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.852 -0400", hash_original_method = "182191B1D77BB818CFC68B7BA957F59F", hash_generated_method = "83F615D970F0F8CB7C7C8709100B410C")
    public  Holder(ObjectDigestInfo objectDigestInfo) {
        this.objectDigestInfo = objectDigestInfo;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static Holder getInstance(Object obj) {
        if (obj instanceof Holder)
        {
            return (Holder)obj;
        }
        else if (obj instanceof ASN1Sequence)
        {
            return new Holder((ASN1Sequence)obj);
        }
        else if (obj instanceof ASN1TaggedObject)
        {
            return new Holder((ASN1TaggedObject)obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.853 -0400", hash_original_method = "00A0A81AB162D0816192A8848BD6F0D6", hash_generated_method = "D19B5DB0CBD75F0980D41D7727A895A2")
    public int getVersion() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1005920754 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1005920754;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.853 -0400", hash_original_method = "0056368CFDBAD05E126455DF61F0B2E7", hash_generated_method = "36BD6B0BFB4C3649CF6F24AF427448E1")
    public IssuerSerial getBaseCertificateID() {
        IssuerSerial varB4EAC82CA7396A68D541C85D26508E83_121060454 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_121060454 = baseCertificateID;
        varB4EAC82CA7396A68D541C85D26508E83_121060454.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_121060454;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.854 -0400", hash_original_method = "9B56B1F6A71C567F065DB4ADA2DE9246", hash_generated_method = "7E4F66A8841BE42E4E91B5CEA9CB845D")
    public GeneralNames getEntityName() {
        GeneralNames varB4EAC82CA7396A68D541C85D26508E83_829796973 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_829796973 = entityName;
        varB4EAC82CA7396A68D541C85D26508E83_829796973.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_829796973;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.855 -0400", hash_original_method = "BF432F04B889EC14E618C49342356E7A", hash_generated_method = "F08C5C84CBBDC850C8520237C3271807")
    public ObjectDigestInfo getObjectDigestInfo() {
        ObjectDigestInfo varB4EAC82CA7396A68D541C85D26508E83_101783206 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_101783206 = objectDigestInfo;
        varB4EAC82CA7396A68D541C85D26508E83_101783206.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_101783206;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.855 -0400", hash_original_method = "C4BE7581245F31D733ECA6F34E47D83B", hash_generated_method = "9B975B53E233452F92881D1B44780961")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1141456907 = null; 
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1417226169 = null; 
        DERObject varB4EAC82CA7396A68D541C85D26508E83_119531551 = null; 
        {
            ASN1EncodableVector v = new ASN1EncodableVector();
            {
                v.add(new DERTaggedObject(false, 0, baseCertificateID));
            } 
            {
                v.add(new DERTaggedObject(false, 1, entityName));
            } 
            {
                v.add(new DERTaggedObject(false, 2, objectDigestInfo));
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1141456907 = new DERSequence(v);
        } 
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1417226169 = new DERTaggedObject(false, 1, entityName);
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_119531551 = new DERTaggedObject(false, 0, baseCertificateID);
            } 
        } 
        DERObject varA7E53CE21691AB073D9660D615818899_1027618961; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1027618961 = varB4EAC82CA7396A68D541C85D26508E83_1141456907;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1027618961 = varB4EAC82CA7396A68D541C85D26508E83_1417226169;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1027618961 = varB4EAC82CA7396A68D541C85D26508E83_119531551;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1027618961.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1027618961;
        
        
    }

    
}

