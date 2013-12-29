package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;






public class Holder extends ASN1Encodable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.214 -0500", hash_original_method = "C662F48FAFBD6958B1422C78C5CF117B", hash_generated_method = "0A0E349DFE87B91F461977E4BCCD75C8")
    public static Holder getInstance(Object obj)
    {
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.211 -0500", hash_original_field = "BFE641AC9AE66327CCBC4859503216E4", hash_generated_field = "BFE641AC9AE66327CCBC4859503216E4")

    IssuerSerial baseCertificateID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.212 -0500", hash_original_field = "47FC527E5C61B3740826FB06BA468BAC", hash_generated_field = "47FC527E5C61B3740826FB06BA468BAC")


    GeneralNames entityName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.213 -0500", hash_original_field = "0DFE757401959316759693C6B709966B", hash_generated_field = "0DFE757401959316759693C6B709966B")


    ObjectDigestInfo objectDigestInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.214 -0500", hash_original_field = "C9F615CDA103CA819E9CF48EDE296898", hash_generated_field = "D02C92BEFB56E93AECDC6D34F25DAE39")


    private int version = 1;

    /**
     * Constructor for a holder for an v1 attribute certificate.
     * 
     * @param tagObj The ASN.1 tagged holder object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.216 -0500", hash_original_method = "0F23F9566CA8F1263E212152AA97F735", hash_generated_method = "D58D778CCF127965AC19648303D22785")
    public Holder(ASN1TaggedObject tagObj)
    {
        switch (tagObj.getTagNo())
        {
        case 0:
            baseCertificateID = IssuerSerial.getInstance(tagObj, false);
            break;
        case 1:
            entityName = GeneralNames.getInstance(tagObj, false);
            break;
        default:
            throw new IllegalArgumentException("unknown tag in Holder");
        }
        version = 0;
    }

    /**
     * Constructor for a holder for an v2 attribute certificate. *
     * 
     * @param seq The ASN.1 sequence.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.217 -0500", hash_original_method = "D380E7678EAEF340CE1A336F4F6AC8E9", hash_generated_method = "DDF4CB9D7BAD7211899FE711C35FBA4C")
    public Holder(ASN1Sequence seq)
    {
        if (seq.size() > 3)
        {
            throw new IllegalArgumentException("Bad sequence size: "
                + seq.size());
        }

        for (int i = 0; i != seq.size(); i++)
        {
            ASN1TaggedObject tObj = ASN1TaggedObject.getInstance(seq
                .getObjectAt(i));

            switch (tObj.getTagNo())
            {
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
                throw new IllegalArgumentException("unknown tag in Holder");
            }
        }
        version = 1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.218 -0500", hash_original_method = "1AE14655F315618D60A29B1C084D2DBC", hash_generated_method = "C10A15C106ACB6CF46181F0318B0F849")
    public Holder(IssuerSerial baseCertificateID)
    {
        this.baseCertificateID = baseCertificateID;
    }

    /**
     * Constructs a holder from a IssuerSerial.
     * @param baseCertificateID The IssuerSerial.
     * @param version The version of the attribute certificate. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.219 -0500", hash_original_method = "DC30675D3133B7CA95C65C37FD001058", hash_generated_method = "F3FFE3C67E93F13E8881EE5343C6693D")
    public Holder(IssuerSerial baseCertificateID, int version)
    {
        this.baseCertificateID = baseCertificateID;
        this.version = version;
    }

    /**
     * Constructs a holder with an entityName for v2 attribute certificates or
     * with a subjectName for v1 attribute certificates.
     * 
     * @param entityName The entity or subject name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.220 -0500", hash_original_method = "4B8FAF3FE0CCE05E8194125D3D22989E", hash_generated_method = "51D7D070A8A270463349F6347712EF00")
    public Holder(GeneralNames entityName)
    {
        this.entityName = entityName;
    }

    /**
     * Constructs a holder with an entityName for v2 attribute certificates or
     * with a subjectName for v1 attribute certificates.
     * 
     * @param entityName The entity or subject name.
     * @param version The version of the attribute certificate. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.221 -0500", hash_original_method = "1B9818A91692B880BC908F5EBF39CBC8", hash_generated_method = "2C950F8E5011DD8B376454BD9C8CC1CB")
    public Holder(GeneralNames entityName, int version)
    {
        this.entityName = entityName;
        this.version = version;
    }
    
    /**
     * Constructs a holder from an object digest info.
     * 
     * @param objectDigestInfo The object digest info object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.222 -0500", hash_original_method = "182191B1D77BB818CFC68B7BA957F59F", hash_generated_method = "C865569B66E6B9D5F98A25B9338B8613")
    public Holder(ObjectDigestInfo objectDigestInfo)
    {
        this.objectDigestInfo = objectDigestInfo;
    }
    
    /**
     * Returns 1 for v2 attribute certificates or 0 for v1 attribute
     * certificates. 
     * @return The version of the attribute certificate.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.219 -0500", hash_original_method = "00A0A81AB162D0816192A8848BD6F0D6", hash_generated_method = "0A6C4E4591BB9051C220BECC5445085D")
    public int getVersion()
    {
        return version;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.223 -0500", hash_original_method = "0056368CFDBAD05E126455DF61F0B2E7", hash_generated_method = "462CAEFE3157CC593122F67181A49FAD")
    public IssuerSerial getBaseCertificateID()
    {
        return baseCertificateID;
    }

    /**
     * Returns the entityName for an v2 attribute certificate or the subjectName
     * for an v1 attribute certificate.
     * 
     * @return The entityname or subjectname.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.224 -0500", hash_original_method = "9B56B1F6A71C567F065DB4ADA2DE9246", hash_generated_method = "AA29B2809FD1C00217A0AF4662FAFAF3")
    public GeneralNames getEntityName()
    {
        return entityName;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.224 -0500", hash_original_method = "BF432F04B889EC14E618C49342356E7A", hash_generated_method = "03B6AC409A1C670BCF9E6988AD64A7E6")
    public ObjectDigestInfo getObjectDigestInfo()
    {
        return objectDigestInfo;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:53.225 -0500", hash_original_method = "C4BE7581245F31D733ECA6F34E47D83B", hash_generated_method = "71A476FC2F875065C9F2706D126453D1")
    public DERObject toASN1Object()
    {
        if (version == 1)
        {
            ASN1EncodableVector v = new ASN1EncodableVector();

            if (baseCertificateID != null)
            {
                v.add(new DERTaggedObject(false, 0, baseCertificateID));
            }

            if (entityName != null)
            {
                v.add(new DERTaggedObject(false, 1, entityName));
            }

            if (objectDigestInfo != null)
            {
                v.add(new DERTaggedObject(false, 2, objectDigestInfo));
            }

            return new DERSequence(v);
        }
        else
        {
            if (entityName != null)
            {
                return new DERTaggedObject(false, 1, entityName);
            }
            else
            {
                return new DERTaggedObject(false, 0, baseCertificateID);
            }
        }
    }

    
}

