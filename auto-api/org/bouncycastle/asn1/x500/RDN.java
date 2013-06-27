package org.bouncycastle.asn1.x500;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;

public class RDN extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.726 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "239F5B210A7B8675111CDBD0D5490D28")

    private ASN1Set values;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.738 -0400", hash_original_method = "B2B65A892B577B3023594DECDAE0C7BC", hash_generated_method = "89280BB26732A955423A2E05E8E72AFE")
    private  RDN(ASN1Set values) {
        this.values = values;
        // ---------- Original Method ----------
        //this.values = values;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.744 -0400", hash_original_method = "34395E14B37CB09607BC1384911068DF", hash_generated_method = "D08C5C12664399A47EFA0E4386C84523")
    public  RDN(ASN1ObjectIdentifier oid, ASN1Encodable value) {
        ASN1EncodableVector v;
        v = new ASN1EncodableVector();
        v.add(oid);
        v.add(value);
        this.values = new DERSet(new DERSequence(v));
        addTaint(oid.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //ASN1EncodableVector v = new ASN1EncodableVector();
        //v.add(oid);
        //v.add(value);
        //this.values = new DERSet(new DERSequence(v));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.744 -0400", hash_original_method = "70441AB748507844E6B6BCC428FBB7E0", hash_generated_method = "7BBD5B09B6231808260E121EB4C29BD7")
    public  RDN(AttributeTypeAndValue attrTAndV) {
        this.values = new DERSet(attrTAndV);
        // ---------- Original Method ----------
        //this.values = new DERSet(attrTAndV);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.747 -0400", hash_original_method = "64FFFA196C50B73DE4BDB139C105E877", hash_generated_method = "FE3A4F5D64F6663C43C30F2372D32E20")
    public  RDN(AttributeTypeAndValue[] aAndVs) {
        this.values = new DERSet(aAndVs);
        // ---------- Original Method ----------
        //this.values = new DERSet(aAndVs);
    }

    
        public static RDN getInstance(Object obj) {
        if (obj instanceof RDN)
        {
            return (RDN)obj;
        }
        else if (obj != null)
        {
            return new RDN(ASN1Set.getInstance(obj));
        }
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.753 -0400", hash_original_method = "8A639F09C3F110E6BEBA76653F26863C", hash_generated_method = "8B3C9487BB11AB588CEE4974C6780375")
    public boolean isMultiValued() {
        boolean var4F86FC141AA103956455F16320BF7065_1341376807 = (this.values.size() > 1);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1645188554 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1645188554;
        // ---------- Original Method ----------
        //return this.values.size() > 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.755 -0400", hash_original_method = "C47887FAFD60151A3B1C3C44B7665548", hash_generated_method = "9F2463AAD9069E3E11F6A595BD48007F")
    public AttributeTypeAndValue getFirst() {
        AttributeTypeAndValue varB4EAC82CA7396A68D541C85D26508E83_431540405 = null; //Variable for return #1
        AttributeTypeAndValue varB4EAC82CA7396A68D541C85D26508E83_1001893689 = null; //Variable for return #2
        {
            boolean var54F40CD1C1801E3A72C98CD218C98919_184426714 = (this.values.size() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_431540405 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1001893689 = AttributeTypeAndValue.getInstance(this.values.getObjectAt(0));
        AttributeTypeAndValue varA7E53CE21691AB073D9660D615818899_684520207; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_684520207 = varB4EAC82CA7396A68D541C85D26508E83_431540405;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_684520207 = varB4EAC82CA7396A68D541C85D26508E83_1001893689;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_684520207.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_684520207;
        // ---------- Original Method ----------
        //if (this.values.size() == 0)
        //{
            //return null;
        //}
        //return AttributeTypeAndValue.getInstance(this.values.getObjectAt(0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.755 -0400", hash_original_method = "BEE890DAA6519CDB424A36294BC48156", hash_generated_method = "E5FB066E5AD9D8D4B12AE060A38F7393")
    public AttributeTypeAndValue[] getTypesAndValues() {
        AttributeTypeAndValue[] varB4EAC82CA7396A68D541C85D26508E83_1658489976 = null; //Variable for return #1
        AttributeTypeAndValue[] tmp;
        tmp = new AttributeTypeAndValue[values.size()];
        {
            int i;
            i = 0;
            {
                tmp[i] = AttributeTypeAndValue.getInstance(values.getObjectAt(i));
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1658489976 = tmp;
        varB4EAC82CA7396A68D541C85D26508E83_1658489976.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1658489976;
        // ---------- Original Method ----------
        //AttributeTypeAndValue[] tmp = new AttributeTypeAndValue[values.size()];
        //for (int i = 0; i != tmp.length; i++)
        //{
            //tmp[i] = AttributeTypeAndValue.getInstance(values.getObjectAt(i));
        //}
        //return tmp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.756 -0400", hash_original_method = "C51EA85277B01B717571B534CACD612E", hash_generated_method = "9776074F41951A25C2A05F3A1903886B")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_441728232 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_441728232 = values;
        varB4EAC82CA7396A68D541C85D26508E83_441728232.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_441728232;
        // ---------- Original Method ----------
        //return values;
    }

    
}

