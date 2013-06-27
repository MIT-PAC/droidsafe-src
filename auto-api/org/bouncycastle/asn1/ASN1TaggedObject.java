package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public abstract class ASN1TaggedObject extends ASN1Object implements ASN1TaggedObjectParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.815 -0400", hash_original_field = "5725D710258369113D712F6D4ABF6730", hash_generated_field = "FA62A32896A7308D5C3ACC05B62DCB16")

    int tagNo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.815 -0400", hash_original_field = "B4A8E09BB57CCF7D96716F9A43485E3E", hash_generated_field = "A3C5A9AF358FD2BFCBE0C2693903BB82")

    boolean empty = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.815 -0400", hash_original_field = "3E40242F1A39AB0A286E83CF367BEE19", hash_generated_field = "83237803BCA36CFD769F62D64B3B892F")

    boolean explicit = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.815 -0400", hash_original_field = "47189E8EF2397EADF5CDF5F3A182EACB", hash_generated_field = "27B23743F26E5B0F431105D2841F3A3B")

    DEREncodable obj = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.822 -0400", hash_original_method = "00E51A508FDFE6A586E84CD8A518A30A", hash_generated_method = "DA23F9717F5F756F2361C3E8C1AED031")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.826 -0400", hash_original_method = "9F7BD38C3B2D03C6929A27397833F44D", hash_generated_method = "0277C1215F80879A1BB37205234F6938")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.827 -0400", hash_original_method = "68AE9CCB33F87A12C7FA4AA63E83BFDC", hash_generated_method = "0A9C6155F64F7EB9A586B5B5A8C943F6")
     boolean asn1Equals(
        DERObject o) {
        ASN1TaggedObject other;
        other = (ASN1TaggedObject)o;
        {
            {
                boolean var6D20EA9E948E0CA84F38D9E98EAB6AF5_1213295545 = (!(obj.getDERObject().equals(other.obj.getDERObject())));
            } //End collapsed parenthetic
        } //End block
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2069555751 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2069555751;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.839 -0400", hash_original_method = "996889D0C05CC309872B8EE7FF5C4369", hash_generated_method = "284209D0EBB3A8AE116C4B41652D634D")
    public int hashCode() {
        int code;
        code = tagNo;
        {
            code ^= obj.hashCode();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1611835545 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1611835545;
        // ---------- Original Method ----------
        //int code = tagNo;
        //if (obj != null)
        //{
            //code ^= obj.hashCode();
        //}
        //return code;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.839 -0400", hash_original_method = "CB42AFB8AF1DB9A93243A50229C66A0D", hash_generated_method = "C701952B7B56D2955B17BE24850E3435")
    public int getTagNo() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2110865175 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2110865175;
        // ---------- Original Method ----------
        //return tagNo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.839 -0400", hash_original_method = "AF6534B2BC536C6B2446F0C361A4EC15", hash_generated_method = "B1F4FB7E862D42257950FBFAC03D923E")
    public boolean isExplicit() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_648519583 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_648519583;
        // ---------- Original Method ----------
        //return explicit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.840 -0400", hash_original_method = "A3A283EA275283949A16122176F95537", hash_generated_method = "C6F4AE70616C4596EF03DED2281FD795")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1279078162 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1279078162;
        // ---------- Original Method ----------
        //return empty;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.840 -0400", hash_original_method = "71996C10B1D68BDB26DD531066806FCB", hash_generated_method = "B015C9C1037CD1153E59EE5F73EDE166")
    public DERObject getObject() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_214045492 = null; //Variable for return #1
        DERObject varB4EAC82CA7396A68D541C85D26508E83_2099287143 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_214045492 = obj.getDERObject();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2099287143 = null;
        DERObject varA7E53CE21691AB073D9660D615818899_481451908; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_481451908 = varB4EAC82CA7396A68D541C85D26508E83_214045492;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_481451908 = varB4EAC82CA7396A68D541C85D26508E83_2099287143;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_481451908.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_481451908;
        // ---------- Original Method ----------
        //if (obj != null)
        //{
            //return obj.getDERObject();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.841 -0400", hash_original_method = "45814A62D9590995EE34A14DC507BC36", hash_generated_method = "F82F0F1652C94DEE317A3AFD22D0A11E")
    public DEREncodable getObjectParser(
        int     tag,
        boolean isExplicit) {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1154611402 = null; //Variable for return #1
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_575339512 = null; //Variable for return #2
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_162053633 = null; //Variable for return #3
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_2135346558 = null; //Variable for return #4
        //Begin case DERTags.SET 
        varB4EAC82CA7396A68D541C85D26508E83_1154611402 = ASN1Set.getInstance(this, isExplicit).parser();
        //End case DERTags.SET 
        //Begin case DERTags.SEQUENCE 
        varB4EAC82CA7396A68D541C85D26508E83_575339512 = ASN1Sequence.getInstance(this, isExplicit).parser();
        //End case DERTags.SEQUENCE 
        //Begin case DERTags.OCTET_STRING 
        varB4EAC82CA7396A68D541C85D26508E83_162053633 = ASN1OctetString.getInstance(this, isExplicit).parser();
        //End case DERTags.OCTET_STRING 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2135346558 = getObject();
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("implicit tagging not implemented for tag: " + tag);
        addTaint(tag);
        addTaint(isExplicit);
        DEREncodable varA7E53CE21691AB073D9660D615818899_918148428; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_918148428 = varB4EAC82CA7396A68D541C85D26508E83_1154611402;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_918148428 = varB4EAC82CA7396A68D541C85D26508E83_575339512;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_918148428 = varB4EAC82CA7396A68D541C85D26508E83_162053633;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_918148428 = varB4EAC82CA7396A68D541C85D26508E83_2135346558;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_918148428.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_918148428;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.841 -0400", hash_original_method = "D3363286272FDA8D05900543905FFBE8", hash_generated_method = "E6B166148892AEA29D77F57783E5C02F")
    public DERObject getLoadedObject() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_420967365 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_420967365 = this.getDERObject();
        varB4EAC82CA7396A68D541C85D26508E83_420967365.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_420967365;
        // ---------- Original Method ----------
        //return this.getDERObject();
    }

    
    abstract void encode(DEROutputStream  out)
        throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.861 -0400", hash_original_method = "5750585E0FAF2C7F60E10F96F297B6DF", hash_generated_method = "EEE4EE5257AA2583DAE5728428DB0CE3")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_79839237 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_79839237 = "[" + tagNo + "]" + obj;
        varB4EAC82CA7396A68D541C85D26508E83_79839237.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_79839237;
        // ---------- Original Method ----------
        //return "[" + tagNo + "]" + obj;
    }

    
}

