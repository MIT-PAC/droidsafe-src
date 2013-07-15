package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class Holder extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.100 -0400", hash_original_field = "C3C2EC65CAD3747AA642E945B7F46D09", hash_generated_field = "BFE641AC9AE66327CCBC4859503216E4")

    IssuerSerial baseCertificateID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.100 -0400", hash_original_field = "8FF1C90F87089FA279CF82F873C8D47B", hash_generated_field = "47FC527E5C61B3740826FB06BA468BAC")

    GeneralNames entityName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.100 -0400", hash_original_field = "035CD4986BAFC5E11EA88A19D8C042C6", hash_generated_field = "0DFE757401959316759693C6B709966B")

    ObjectDigestInfo objectDigestInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.100 -0400", hash_original_field = "E42DADD15D4BC1646E84D1DED9A5D1F5", hash_generated_field = "D02C92BEFB56E93AECDC6D34F25DAE39")

    private int version = 1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.101 -0400", hash_original_method = "0F23F9566CA8F1263E212152AA97F735", hash_generated_method = "FD0F7EAB28C6BF2227A5BC1FF9BEADC2")
    public  Holder(ASN1TaggedObject tagObj) {
switch(tagObj.getTagNo()){
        case 0:
        baseCertificateID = IssuerSerial.getInstance(tagObj, false);
        break;
        case 1:
        entityName = GeneralNames.getInstance(tagObj, false);
        break;
        default:
        IllegalArgumentException var3329B9EED33A4B7C54D7870A537856BA_1831852649 = new IllegalArgumentException("unknown tag in Holder");
        var3329B9EED33A4B7C54D7870A537856BA_1831852649.addTaint(taint);
        throw var3329B9EED33A4B7C54D7870A537856BA_1831852649;
}        version = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.102 -0400", hash_original_method = "D380E7678EAEF340CE1A336F4F6AC8E9", hash_generated_method = "C83C1A7CFF1206DA9039BD8CC9B03FB3")
    public  Holder(ASN1Sequence seq) {
        addTaint(seq.getTaint());
    if(seq.size() > 3)        
        {
            IllegalArgumentException varA2072CF614C7B8C7696DD5A02DBCCE9C_645507947 = new IllegalArgumentException("Bad sequence size: "
                + seq.size());
            varA2072CF614C7B8C7696DD5A02DBCCE9C_645507947.addTaint(taint);
            throw varA2072CF614C7B8C7696DD5A02DBCCE9C_645507947;
        } //End block
for(int i = 0;i != seq.size();i++)
        {
            ASN1TaggedObject tObj = ASN1TaggedObject.getInstance(seq
                .getObjectAt(i));
switch(tObj.getTagNo()){
            case 0:
            baseCertificateID = IssuerSerial.getInstance(tObj, false);
            break;
            case 1:
            entityName = GeneralNames.getInstance(tObj, false);
            break;
            case 2:
            objectDigestInfo = ObjectDigestInfo.getInstance(tObj, false);
            break;
            default:
            IllegalArgumentException var3329B9EED33A4B7C54D7870A537856BA_2144824756 = new IllegalArgumentException("unknown tag in Holder");
            var3329B9EED33A4B7C54D7870A537856BA_2144824756.addTaint(taint);
            throw var3329B9EED33A4B7C54D7870A537856BA_2144824756;
}
        } //End block
        version = 1;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.102 -0400", hash_original_method = "1AE14655F315618D60A29B1C084D2DBC", hash_generated_method = "077E89BAB23042BA20FF3CEB93E06142")
    public  Holder(IssuerSerial baseCertificateID) {
        this.baseCertificateID = baseCertificateID;
        // ---------- Original Method ----------
        //this.baseCertificateID = baseCertificateID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.103 -0400", hash_original_method = "DC30675D3133B7CA95C65C37FD001058", hash_generated_method = "8DAAFFADA025829FBF2AA37838285F49")
    public  Holder(IssuerSerial baseCertificateID, int version) {
        this.baseCertificateID = baseCertificateID;
        this.version = version;
        // ---------- Original Method ----------
        //this.baseCertificateID = baseCertificateID;
        //this.version = version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.104 -0400", hash_original_method = "4B8FAF3FE0CCE05E8194125D3D22989E", hash_generated_method = "275B12FB499CE8562859E5B2CB2594A6")
    public  Holder(GeneralNames entityName) {
        this.entityName = entityName;
        // ---------- Original Method ----------
        //this.entityName = entityName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.104 -0400", hash_original_method = "1B9818A91692B880BC908F5EBF39CBC8", hash_generated_method = "D296E5F293EFCF5762839FE906774F0D")
    public  Holder(GeneralNames entityName, int version) {
        this.entityName = entityName;
        this.version = version;
        // ---------- Original Method ----------
        //this.entityName = entityName;
        //this.version = version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.105 -0400", hash_original_method = "182191B1D77BB818CFC68B7BA957F59F", hash_generated_method = "83F615D970F0F8CB7C7C8709100B410C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.106 -0400", hash_original_method = "00A0A81AB162D0816192A8848BD6F0D6", hash_generated_method = "129C52C55085BD99FF04ABE0EB89455A")
    public int getVersion() {
        int var2AF72F100C356273D46284F6FD1DFC08_1973007528 = (version);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_874044449 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_874044449;
        // ---------- Original Method ----------
        //return version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.106 -0400", hash_original_method = "0056368CFDBAD05E126455DF61F0B2E7", hash_generated_method = "9DFFCA6FBB35FDF64A572FE4E7503FB6")
    public IssuerSerial getBaseCertificateID() {
IssuerSerial var3F2CF66981EEEACD456AAF29D2BB1816_193055435 =         baseCertificateID;
        var3F2CF66981EEEACD456AAF29D2BB1816_193055435.addTaint(taint);
        return var3F2CF66981EEEACD456AAF29D2BB1816_193055435;
        // ---------- Original Method ----------
        //return baseCertificateID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.106 -0400", hash_original_method = "9B56B1F6A71C567F065DB4ADA2DE9246", hash_generated_method = "76BE4CBFAC946CDC66EFD1CF437E9C56")
    public GeneralNames getEntityName() {
GeneralNames var505C8BE670B770FF827E6FFE2E69AF5E_1774392992 =         entityName;
        var505C8BE670B770FF827E6FFE2E69AF5E_1774392992.addTaint(taint);
        return var505C8BE670B770FF827E6FFE2E69AF5E_1774392992;
        // ---------- Original Method ----------
        //return entityName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.107 -0400", hash_original_method = "BF432F04B889EC14E618C49342356E7A", hash_generated_method = "AE09E2253C8B2D7F7D9A49D8F0110233")
    public ObjectDigestInfo getObjectDigestInfo() {
ObjectDigestInfo var8645E6823C16465BE8DE456BAC146566_1479348820 =         objectDigestInfo;
        var8645E6823C16465BE8DE456BAC146566_1479348820.addTaint(taint);
        return var8645E6823C16465BE8DE456BAC146566_1479348820;
        // ---------- Original Method ----------
        //return objectDigestInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.107 -0400", hash_original_method = "C4BE7581245F31D733ECA6F34E47D83B", hash_generated_method = "4A8A3C2E3D34D11BD4271DC1D5AFDCCC")
    public DERObject toASN1Object() {
    if(version == 1)        
        {
            ASN1EncodableVector v = new ASN1EncodableVector();
    if(baseCertificateID != null)            
            {
                v.add(new DERTaggedObject(false, 0, baseCertificateID));
            } //End block
    if(entityName != null)            
            {
                v.add(new DERTaggedObject(false, 1, entityName));
            } //End block
    if(objectDigestInfo != null)            
            {
                v.add(new DERTaggedObject(false, 2, objectDigestInfo));
            } //End block
DERObject var0B338F106E3279986C87B595B0F4A439_897809393 =             new DERSequence(v);
            var0B338F106E3279986C87B595B0F4A439_897809393.addTaint(taint);
            return var0B338F106E3279986C87B595B0F4A439_897809393;
        } //End block
        else
        {
    if(entityName != null)            
            {
DERObject var1577A18C8E4A1C17CA3FEB4D16D6103F_631176521 =                 new DERTaggedObject(false, 1, entityName);
                var1577A18C8E4A1C17CA3FEB4D16D6103F_631176521.addTaint(taint);
                return var1577A18C8E4A1C17CA3FEB4D16D6103F_631176521;
            } //End block
            else
            {
DERObject var6555801B2D388A11A9089DF3A3EA18A7_1700005098 =                 new DERTaggedObject(false, 0, baseCertificateID);
                var6555801B2D388A11A9089DF3A3EA18A7_1700005098.addTaint(taint);
                return var6555801B2D388A11A9089DF3A3EA18A7_1700005098;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

