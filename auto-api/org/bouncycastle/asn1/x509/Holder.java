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
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class Holder extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.014 -0400", hash_original_field = "C3C2EC65CAD3747AA642E945B7F46D09", hash_generated_field = "BFE641AC9AE66327CCBC4859503216E4")

    IssuerSerial baseCertificateID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.014 -0400", hash_original_field = "8FF1C90F87089FA279CF82F873C8D47B", hash_generated_field = "47FC527E5C61B3740826FB06BA468BAC")

    GeneralNames entityName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.014 -0400", hash_original_field = "035CD4986BAFC5E11EA88A19D8C042C6", hash_generated_field = "0DFE757401959316759693C6B709966B")

    ObjectDigestInfo objectDigestInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.014 -0400", hash_original_field = "E42DADD15D4BC1646E84D1DED9A5D1F5", hash_generated_field = "D02C92BEFB56E93AECDC6D34F25DAE39")

    private int version = 1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.027 -0400", hash_original_method = "0F23F9566CA8F1263E212152AA97F735", hash_generated_method = "5CB642666035B412838295D3077AD643")
    public  Holder(ASN1TaggedObject tagObj) {
        {
            Object var5A1D86816B305CAB392BF2B3D11EBEDC_1344338796 = (tagObj.getTagNo());
            //Begin case 0 
            baseCertificateID = IssuerSerial.getInstance(tagObj, false);
            //End case 0 
            //Begin case 1 
            entityName = GeneralNames.getInstance(tagObj, false);
            //End case 1 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("unknown tag in Holder");
            //End case default 
        } //End collapsed parenthetic
        version = 0;
        // ---------- Original Method ----------
        //switch (tagObj.getTagNo())
        //{
        //case 0:
            //baseCertificateID = IssuerSerial.getInstance(tagObj, false);
            //break;
        //case 1:
            //entityName = GeneralNames.getInstance(tagObj, false);
            //break;
        //default:
            //throw new IllegalArgumentException("unknown tag in Holder");
        //}
        //version = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.028 -0400", hash_original_method = "D380E7678EAEF340CE1A336F4F6AC8E9", hash_generated_method = "1FBE68F15D3DFC0852635D9A5BA906CA")
    public  Holder(ASN1Sequence seq) {
        {
            boolean var889BC8C4BD2008ADA32540CA2FE285A5_2031735634 = (seq.size() > 3);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad sequence size: "
                + seq.size());
            } //End block
        } //End collapsed parenthetic
        {
            int i;
            i = 0;
            boolean varA93A8909C6B18B3F6367766A0DBBDCF3_788153204 = (i != seq.size());
            {
                ASN1TaggedObject tObj;
                tObj = ASN1TaggedObject.getInstance(seq
                .getObjectAt(i));
                {
                    Object var506C3BFE4DA0A54A555A4F5441806E9D_330925622 = (tObj.getTagNo());
                    //Begin case 0 
                    baseCertificateID = IssuerSerial.getInstance(tObj, false);
                    //End case 0 
                    //Begin case 1 
                    entityName = GeneralNames.getInstance(tObj, false);
                    //End case 1 
                    //Begin case 2 
                    objectDigestInfo = ObjectDigestInfo.getInstance(tObj, false);
                    //End case 2 
                    //Begin case default 
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("unknown tag in Holder");
                    //End case default 
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        version = 1;
        addTaint(seq.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.028 -0400", hash_original_method = "1AE14655F315618D60A29B1C084D2DBC", hash_generated_method = "077E89BAB23042BA20FF3CEB93E06142")
    public  Holder(IssuerSerial baseCertificateID) {
        this.baseCertificateID = baseCertificateID;
        // ---------- Original Method ----------
        //this.baseCertificateID = baseCertificateID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.029 -0400", hash_original_method = "DC30675D3133B7CA95C65C37FD001058", hash_generated_method = "8DAAFFADA025829FBF2AA37838285F49")
    public  Holder(IssuerSerial baseCertificateID, int version) {
        this.baseCertificateID = baseCertificateID;
        this.version = version;
        // ---------- Original Method ----------
        //this.baseCertificateID = baseCertificateID;
        //this.version = version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.029 -0400", hash_original_method = "4B8FAF3FE0CCE05E8194125D3D22989E", hash_generated_method = "275B12FB499CE8562859E5B2CB2594A6")
    public  Holder(GeneralNames entityName) {
        this.entityName = entityName;
        // ---------- Original Method ----------
        //this.entityName = entityName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.035 -0400", hash_original_method = "1B9818A91692B880BC908F5EBF39CBC8", hash_generated_method = "D296E5F293EFCF5762839FE906774F0D")
    public  Holder(GeneralNames entityName, int version) {
        this.entityName = entityName;
        this.version = version;
        // ---------- Original Method ----------
        //this.entityName = entityName;
        //this.version = version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.044 -0400", hash_original_method = "182191B1D77BB818CFC68B7BA957F59F", hash_generated_method = "83F615D970F0F8CB7C7C8709100B410C")
    public  Holder(ObjectDigestInfo objectDigestInfo) {
        this.objectDigestInfo = objectDigestInfo;
        // ---------- Original Method ----------
        //this.objectDigestInfo = objectDigestInfo;
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.045 -0400", hash_original_method = "00A0A81AB162D0816192A8848BD6F0D6", hash_generated_method = "7137609E3083059C8A58FED0EF8C151A")
    public int getVersion() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_609114268 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_609114268;
        // ---------- Original Method ----------
        //return version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.046 -0400", hash_original_method = "0056368CFDBAD05E126455DF61F0B2E7", hash_generated_method = "BF316256DB79A593269D8086A240C427")
    public IssuerSerial getBaseCertificateID() {
        IssuerSerial varB4EAC82CA7396A68D541C85D26508E83_1225493114 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1225493114 = baseCertificateID;
        varB4EAC82CA7396A68D541C85D26508E83_1225493114.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1225493114;
        // ---------- Original Method ----------
        //return baseCertificateID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.058 -0400", hash_original_method = "9B56B1F6A71C567F065DB4ADA2DE9246", hash_generated_method = "A5F7EB8F97FF62D3D5A9E2E0CC979083")
    public GeneralNames getEntityName() {
        GeneralNames varB4EAC82CA7396A68D541C85D26508E83_891189336 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_891189336 = entityName;
        varB4EAC82CA7396A68D541C85D26508E83_891189336.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_891189336;
        // ---------- Original Method ----------
        //return entityName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.058 -0400", hash_original_method = "BF432F04B889EC14E618C49342356E7A", hash_generated_method = "C9B211E99E28F808DA676730A6CFE32D")
    public ObjectDigestInfo getObjectDigestInfo() {
        ObjectDigestInfo varB4EAC82CA7396A68D541C85D26508E83_1313865205 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1313865205 = objectDigestInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1313865205.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1313865205;
        // ---------- Original Method ----------
        //return objectDigestInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.070 -0400", hash_original_method = "C4BE7581245F31D733ECA6F34E47D83B", hash_generated_method = "9DA0DFDFB530632192338E0A3A62B51C")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1535825524 = null; //Variable for return #1
        DERObject varB4EAC82CA7396A68D541C85D26508E83_907733173 = null; //Variable for return #2
        DERObject varB4EAC82CA7396A68D541C85D26508E83_450329992 = null; //Variable for return #3
        {
            ASN1EncodableVector v;
            v = new ASN1EncodableVector();
            {
                v.add(new DERTaggedObject(false, 0, baseCertificateID));
            } //End block
            {
                v.add(new DERTaggedObject(false, 1, entityName));
            } //End block
            {
                v.add(new DERTaggedObject(false, 2, objectDigestInfo));
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1535825524 = new DERSequence(v);
        } //End block
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_907733173 = new DERTaggedObject(false, 1, entityName);
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_450329992 = new DERTaggedObject(false, 0, baseCertificateID);
            } //End block
        } //End block
        DERObject varA7E53CE21691AB073D9660D615818899_24784554; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_24784554 = varB4EAC82CA7396A68D541C85D26508E83_1535825524;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_24784554 = varB4EAC82CA7396A68D541C85D26508E83_907733173;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_24784554 = varB4EAC82CA7396A68D541C85D26508E83_450329992;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_24784554.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_24784554;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

