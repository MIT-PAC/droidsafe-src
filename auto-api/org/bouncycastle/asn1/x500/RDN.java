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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.392 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "239F5B210A7B8675111CDBD0D5490D28")

    private ASN1Set values;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.393 -0400", hash_original_method = "B2B65A892B577B3023594DECDAE0C7BC", hash_generated_method = "89280BB26732A955423A2E05E8E72AFE")
    private  RDN(ASN1Set values) {
        this.values = values;
        // ---------- Original Method ----------
        //this.values = values;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.393 -0400", hash_original_method = "34395E14B37CB09607BC1384911068DF", hash_generated_method = "DCA6F5DB339AFFE069CDA77308642350")
    public  RDN(ASN1ObjectIdentifier oid, ASN1Encodable value) {
        ASN1EncodableVector v = new ASN1EncodableVector();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.394 -0400", hash_original_method = "70441AB748507844E6B6BCC428FBB7E0", hash_generated_method = "7BBD5B09B6231808260E121EB4C29BD7")
    public  RDN(AttributeTypeAndValue attrTAndV) {
        this.values = new DERSet(attrTAndV);
        // ---------- Original Method ----------
        //this.values = new DERSet(attrTAndV);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.394 -0400", hash_original_method = "64FFFA196C50B73DE4BDB139C105E877", hash_generated_method = "FE3A4F5D64F6663C43C30F2372D32E20")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.395 -0400", hash_original_method = "8A639F09C3F110E6BEBA76653F26863C", hash_generated_method = "9A7064E6F1A3A780787D77512D62949C")
    public boolean isMultiValued() {
        boolean var4F86FC141AA103956455F16320BF7065_803831811 = (this.values.size() > 1);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1868025395 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1868025395;
        // ---------- Original Method ----------
        //return this.values.size() > 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.396 -0400", hash_original_method = "C47887FAFD60151A3B1C3C44B7665548", hash_generated_method = "77B9E3132EA8DBA940CADB1E235E1369")
    public AttributeTypeAndValue getFirst() {
        AttributeTypeAndValue varB4EAC82CA7396A68D541C85D26508E83_236528866 = null; //Variable for return #1
        AttributeTypeAndValue varB4EAC82CA7396A68D541C85D26508E83_1281801367 = null; //Variable for return #2
        {
            boolean var54F40CD1C1801E3A72C98CD218C98919_1434204676 = (this.values.size() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_236528866 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1281801367 = AttributeTypeAndValue.getInstance(this.values.getObjectAt(0));
        AttributeTypeAndValue varA7E53CE21691AB073D9660D615818899_2070721996; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2070721996 = varB4EAC82CA7396A68D541C85D26508E83_236528866;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2070721996 = varB4EAC82CA7396A68D541C85D26508E83_1281801367;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2070721996.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2070721996;
        // ---------- Original Method ----------
        //if (this.values.size() == 0)
        //{
            //return null;
        //}
        //return AttributeTypeAndValue.getInstance(this.values.getObjectAt(0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.397 -0400", hash_original_method = "BEE890DAA6519CDB424A36294BC48156", hash_generated_method = "AAD26373C470F8D266407C4104BD912A")
    public AttributeTypeAndValue[] getTypesAndValues() {
        AttributeTypeAndValue[] varB4EAC82CA7396A68D541C85D26508E83_1929488572 = null; //Variable for return #1
        AttributeTypeAndValue[] tmp = new AttributeTypeAndValue[values.size()];
        {
            int i = 0;
            {
                tmp[i] = AttributeTypeAndValue.getInstance(values.getObjectAt(i));
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1929488572 = tmp;
        varB4EAC82CA7396A68D541C85D26508E83_1929488572.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1929488572;
        // ---------- Original Method ----------
        //AttributeTypeAndValue[] tmp = new AttributeTypeAndValue[values.size()];
        //for (int i = 0; i != tmp.length; i++)
        //{
            //tmp[i] = AttributeTypeAndValue.getInstance(values.getObjectAt(i));
        //}
        //return tmp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.398 -0400", hash_original_method = "C51EA85277B01B717571B534CACD612E", hash_generated_method = "4EE426731246FA431E7D10DF94F6976C")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1824158216 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1824158216 = values;
        varB4EAC82CA7396A68D541C85D26508E83_1824158216.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1824158216;
        // ---------- Original Method ----------
        //return values;
    }

    
}

