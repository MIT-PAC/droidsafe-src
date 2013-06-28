package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public abstract class ASN1TaggedObject extends ASN1Object implements ASN1TaggedObjectParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.076 -0400", hash_original_field = "5725D710258369113D712F6D4ABF6730", hash_generated_field = "FA62A32896A7308D5C3ACC05B62DCB16")

    int tagNo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.076 -0400", hash_original_field = "B4A8E09BB57CCF7D96716F9A43485E3E", hash_generated_field = "A3C5A9AF358FD2BFCBE0C2693903BB82")

    boolean empty = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.076 -0400", hash_original_field = "3E40242F1A39AB0A286E83CF367BEE19", hash_generated_field = "83237803BCA36CFD769F62D64B3B892F")

    boolean explicit = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.076 -0400", hash_original_field = "47189E8EF2397EADF5CDF5F3A182EACB", hash_generated_field = "27B23743F26E5B0F431105D2841F3A3B")

    DEREncodable obj = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.076 -0400", hash_original_method = "00E51A508FDFE6A586E84CD8A518A30A", hash_generated_method = "DA23F9717F5F756F2361C3E8C1AED031")
    public  ASN1TaggedObject(
        int             tagNo,
        DEREncodable    obj) {
        this.explicit = true;
        this.tagNo = tagNo;
        this.obj = obj;
        // ---------- Original Method ----------
        //this.explicit = true;
        //this.tagNo = tagNo;
        //this.obj = obj;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.076 -0400", hash_original_method = "9F7BD38C3B2D03C6929A27397833F44D", hash_generated_method = "0277C1215F80879A1BB37205234F6938")
    public  ASN1TaggedObject(
        boolean         explicit,
        int             tagNo,
        DEREncodable    obj) {
        {
            this.explicit = true;
        } //End block
        {
            this.explicit = explicit;
        } //End block
        this.tagNo = tagNo;
        this.obj = obj;
        // ---------- Original Method ----------
        //if (obj instanceof ASN1Choice)
        //{
            //this.explicit = true;
        //}
        //else
        //{
            //this.explicit = explicit;
        //}
        //this.tagNo = tagNo;
        //this.obj = obj;
    }

    
    static public ASN1TaggedObject getInstance(
        ASN1TaggedObject    obj,
        boolean             explicit) {
        if (explicit)
        {
            return (ASN1TaggedObject)obj.getObject();
        }
        throw new IllegalArgumentException("implicitly tagged tagged object");
    }

    
    static public ASN1TaggedObject getInstance(
        Object obj) {
        if (obj == null || obj instanceof ASN1TaggedObject) 
        {
                return (ASN1TaggedObject)obj;
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.077 -0400", hash_original_method = "68AE9CCB33F87A12C7FA4AA63E83BFDC", hash_generated_method = "120B273DE088C02A58E0B691E15A2FFF")
     boolean asn1Equals(
        DERObject o) {
        ASN1TaggedObject other = (ASN1TaggedObject)o;
        {
            {
                boolean var6D20EA9E948E0CA84F38D9E98EAB6AF5_2133072620 = (!(obj.getDERObject().equals(other.obj.getDERObject())));
            } //End collapsed parenthetic
        } //End block
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_188416030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_188416030;
        // ---------- Original Method ----------
        //if (!(o instanceof ASN1TaggedObject))
        //{
            //return false;
        //}
        //ASN1TaggedObject other = (ASN1TaggedObject)o;
        //if (tagNo != other.tagNo || empty != other.empty || explicit != other.explicit)
        //{
            //return false;
        //}
        //if(obj == null)
        //{
            //if (other.obj != null)
            //{
                //return false;
            //}
        //}
        //else
        //{
            //if (!(obj.getDERObject().equals(other.obj.getDERObject())))
            //{
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.078 -0400", hash_original_method = "996889D0C05CC309872B8EE7FF5C4369", hash_generated_method = "EB6DADC0F30B012AEEDC4241C4A36D23")
    public int hashCode() {
        int code = tagNo;
        {
            code ^= obj.hashCode();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2129495089 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2129495089;
        // ---------- Original Method ----------
        //int code = tagNo;
        //if (obj != null)
        //{
            //code ^= obj.hashCode();
        //}
        //return code;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.078 -0400", hash_original_method = "CB42AFB8AF1DB9A93243A50229C66A0D", hash_generated_method = "263FCFE21662FC6D53A708FBAF70DD74")
    public int getTagNo() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1544024373 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1544024373;
        // ---------- Original Method ----------
        //return tagNo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.078 -0400", hash_original_method = "AF6534B2BC536C6B2446F0C361A4EC15", hash_generated_method = "F67C9ACA528E350F7199036AB933BFC3")
    public boolean isExplicit() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2041612922 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2041612922;
        // ---------- Original Method ----------
        //return explicit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.078 -0400", hash_original_method = "A3A283EA275283949A16122176F95537", hash_generated_method = "48EDE9EF98AC1BA64062FD5DF5B62966")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_900468864 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_900468864;
        // ---------- Original Method ----------
        //return empty;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.079 -0400", hash_original_method = "71996C10B1D68BDB26DD531066806FCB", hash_generated_method = "BBB8252F1FA832B6C8A5CFE7F8867419")
    public DERObject getObject() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_23096243 = null; //Variable for return #1
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1521707876 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_23096243 = obj.getDERObject();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1521707876 = null;
        DERObject varA7E53CE21691AB073D9660D615818899_2109067757; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2109067757 = varB4EAC82CA7396A68D541C85D26508E83_23096243;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2109067757 = varB4EAC82CA7396A68D541C85D26508E83_1521707876;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2109067757.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2109067757;
        // ---------- Original Method ----------
        //if (obj != null)
        //{
            //return obj.getDERObject();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.080 -0400", hash_original_method = "45814A62D9590995EE34A14DC507BC36", hash_generated_method = "FE3ADED5772386FF99D9A7247DB845B1")
    public DEREncodable getObjectParser(
        int     tag,
        boolean isExplicit) {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1486408239 = null; //Variable for return #1
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1660938274 = null; //Variable for return #2
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1755452957 = null; //Variable for return #3
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_172121627 = null; //Variable for return #4
        //Begin case DERTags.SET 
        varB4EAC82CA7396A68D541C85D26508E83_1486408239 = ASN1Set.getInstance(this, isExplicit).parser();
        //End case DERTags.SET 
        //Begin case DERTags.SEQUENCE 
        varB4EAC82CA7396A68D541C85D26508E83_1660938274 = ASN1Sequence.getInstance(this, isExplicit).parser();
        //End case DERTags.SEQUENCE 
        //Begin case DERTags.OCTET_STRING 
        varB4EAC82CA7396A68D541C85D26508E83_1755452957 = ASN1OctetString.getInstance(this, isExplicit).parser();
        //End case DERTags.OCTET_STRING 
        {
            varB4EAC82CA7396A68D541C85D26508E83_172121627 = getObject();
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("implicit tagging not implemented for tag: " + tag);
        addTaint(tag);
        addTaint(isExplicit);
        DEREncodable varA7E53CE21691AB073D9660D615818899_1172650834; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1172650834 = varB4EAC82CA7396A68D541C85D26508E83_1486408239;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1172650834 = varB4EAC82CA7396A68D541C85D26508E83_1660938274;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1172650834 = varB4EAC82CA7396A68D541C85D26508E83_1755452957;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1172650834 = varB4EAC82CA7396A68D541C85D26508E83_172121627;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1172650834.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1172650834;
        // ---------- Original Method ----------
        //switch (tag)
        //{
        //case DERTags.SET:
            //return ASN1Set.getInstance(this, isExplicit).parser();
        //case DERTags.SEQUENCE:
            //return ASN1Sequence.getInstance(this, isExplicit).parser();
        //case DERTags.OCTET_STRING:
            //return ASN1OctetString.getInstance(this, isExplicit).parser();
        //}
        //if (isExplicit)
        //{
            //return getObject();
        //}
        //throw new RuntimeException("implicit tagging not implemented for tag: " + tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.081 -0400", hash_original_method = "D3363286272FDA8D05900543905FFBE8", hash_generated_method = "80C1B5B6CBEA5D8C71A17C45E54FB748")
    public DERObject getLoadedObject() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_88405600 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_88405600 = this.getDERObject();
        varB4EAC82CA7396A68D541C85D26508E83_88405600.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_88405600;
        // ---------- Original Method ----------
        //return this.getDERObject();
    }

    
    abstract void encode(DEROutputStream  out)
        throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.081 -0400", hash_original_method = "5750585E0FAF2C7F60E10F96F297B6DF", hash_generated_method = "2B1B2A4AF087A8C09595C102C54EBA97")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_414287685 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_414287685 = "[" + tagNo + "]" + obj;
        varB4EAC82CA7396A68D541C85D26508E83_414287685.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_414287685;
        // ---------- Original Method ----------
        //return "[" + tagNo + "]" + obj;
    }

    
}

