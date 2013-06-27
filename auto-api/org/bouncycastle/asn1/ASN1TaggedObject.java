package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public abstract class ASN1TaggedObject extends ASN1Object implements ASN1TaggedObjectParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.734 -0400", hash_original_field = "5725D710258369113D712F6D4ABF6730", hash_generated_field = "FA62A32896A7308D5C3ACC05B62DCB16")

    int tagNo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.734 -0400", hash_original_field = "B4A8E09BB57CCF7D96716F9A43485E3E", hash_generated_field = "A3C5A9AF358FD2BFCBE0C2693903BB82")

    boolean empty = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.734 -0400", hash_original_field = "3E40242F1A39AB0A286E83CF367BEE19", hash_generated_field = "83237803BCA36CFD769F62D64B3B892F")

    boolean explicit = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.734 -0400", hash_original_field = "47189E8EF2397EADF5CDF5F3A182EACB", hash_generated_field = "27B23743F26E5B0F431105D2841F3A3B")

    DEREncodable obj = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.737 -0400", hash_original_method = "00E51A508FDFE6A586E84CD8A518A30A", hash_generated_method = "DA23F9717F5F756F2361C3E8C1AED031")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.738 -0400", hash_original_method = "9F7BD38C3B2D03C6929A27397833F44D", hash_generated_method = "0277C1215F80879A1BB37205234F6938")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.740 -0400", hash_original_method = "68AE9CCB33F87A12C7FA4AA63E83BFDC", hash_generated_method = "74A425951C50565BB736327450568FFE")
     boolean asn1Equals(
        DERObject o) {
        ASN1TaggedObject other;
        other = (ASN1TaggedObject)o;
        {
            {
                boolean var6D20EA9E948E0CA84F38D9E98EAB6AF5_1826480271 = (!(obj.getDERObject().equals(other.obj.getDERObject())));
            } //End collapsed parenthetic
        } //End block
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_853536763 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_853536763;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.749 -0400", hash_original_method = "996889D0C05CC309872B8EE7FF5C4369", hash_generated_method = "2A41736276EBEC4D3E806868BA895D2D")
    public int hashCode() {
        int code;
        code = tagNo;
        {
            code ^= obj.hashCode();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_459523500 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_459523500;
        // ---------- Original Method ----------
        //int code = tagNo;
        //if (obj != null)
        //{
            //code ^= obj.hashCode();
        //}
        //return code;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.750 -0400", hash_original_method = "CB42AFB8AF1DB9A93243A50229C66A0D", hash_generated_method = "7ED38D94367F2D25674074F69C53F971")
    public int getTagNo() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_147261826 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_147261826;
        // ---------- Original Method ----------
        //return tagNo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.751 -0400", hash_original_method = "AF6534B2BC536C6B2446F0C361A4EC15", hash_generated_method = "B832067626C7A8FC8DCEFF694B478C92")
    public boolean isExplicit() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_237686211 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_237686211;
        // ---------- Original Method ----------
        //return explicit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.758 -0400", hash_original_method = "A3A283EA275283949A16122176F95537", hash_generated_method = "0F8F443A62FE992EC5FD4EC52EE1C200")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_262530334 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_262530334;
        // ---------- Original Method ----------
        //return empty;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.758 -0400", hash_original_method = "71996C10B1D68BDB26DD531066806FCB", hash_generated_method = "3044ED705D65CFCDCB137C363AD1FCD4")
    public DERObject getObject() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_548637960 = null; //Variable for return #1
        DERObject varB4EAC82CA7396A68D541C85D26508E83_260830320 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_548637960 = obj.getDERObject();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_260830320 = null;
        DERObject varA7E53CE21691AB073D9660D615818899_1795828799; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1795828799 = varB4EAC82CA7396A68D541C85D26508E83_548637960;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1795828799 = varB4EAC82CA7396A68D541C85D26508E83_260830320;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1795828799.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1795828799;
        // ---------- Original Method ----------
        //if (obj != null)
        //{
            //return obj.getDERObject();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.772 -0400", hash_original_method = "45814A62D9590995EE34A14DC507BC36", hash_generated_method = "C335C4A047F3E4AC09969258CB02AD5D")
    public DEREncodable getObjectParser(
        int     tag,
        boolean isExplicit) {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1067346830 = null; //Variable for return #1
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1494186653 = null; //Variable for return #2
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1453280426 = null; //Variable for return #3
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1721596769 = null; //Variable for return #4
        //Begin case DERTags.SET 
        varB4EAC82CA7396A68D541C85D26508E83_1067346830 = ASN1Set.getInstance(this, isExplicit).parser();
        //End case DERTags.SET 
        //Begin case DERTags.SEQUENCE 
        varB4EAC82CA7396A68D541C85D26508E83_1494186653 = ASN1Sequence.getInstance(this, isExplicit).parser();
        //End case DERTags.SEQUENCE 
        //Begin case DERTags.OCTET_STRING 
        varB4EAC82CA7396A68D541C85D26508E83_1453280426 = ASN1OctetString.getInstance(this, isExplicit).parser();
        //End case DERTags.OCTET_STRING 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1721596769 = getObject();
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("implicit tagging not implemented for tag: " + tag);
        addTaint(tag);
        addTaint(isExplicit);
        DEREncodable varA7E53CE21691AB073D9660D615818899_26650338; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_26650338 = varB4EAC82CA7396A68D541C85D26508E83_1067346830;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_26650338 = varB4EAC82CA7396A68D541C85D26508E83_1494186653;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_26650338 = varB4EAC82CA7396A68D541C85D26508E83_1453280426;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_26650338 = varB4EAC82CA7396A68D541C85D26508E83_1721596769;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_26650338.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_26650338;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.772 -0400", hash_original_method = "D3363286272FDA8D05900543905FFBE8", hash_generated_method = "2910AC4C2EF62C94FD70D2140C7722D9")
    public DERObject getLoadedObject() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_851790197 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_851790197 = this.getDERObject();
        varB4EAC82CA7396A68D541C85D26508E83_851790197.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_851790197;
        // ---------- Original Method ----------
        //return this.getDERObject();
    }

    
    abstract void encode(DEROutputStream  out)
        throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.773 -0400", hash_original_method = "5750585E0FAF2C7F60E10F96F297B6DF", hash_generated_method = "68C7B3E025A482E80E0151585B52A2E9")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1455969396 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1455969396 = "[" + tagNo + "]" + obj;
        varB4EAC82CA7396A68D541C85D26508E83_1455969396.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1455969396;
        // ---------- Original Method ----------
        //return "[" + tagNo + "]" + obj;
    }

    
}

