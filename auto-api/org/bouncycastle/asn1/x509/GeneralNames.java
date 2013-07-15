package org.bouncycastle.asn1.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class GeneralNames extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.823 -0400", hash_original_field = "A8998C31A141924D06220074FCDC6925", hash_generated_field = "74CEDC81B0DB27B07D173878E0284C60")

    private GeneralName[] names;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.823 -0400", hash_original_method = "F51AA332BBC1C75C23F2395E3D593569", hash_generated_method = "8BC893C6BAC23CD880DBCF48578BF738")
    public  GeneralNames(
        GeneralName  name) {
        this.names = new GeneralName[] { name };
        addTaint(name.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.824 -0400", hash_original_method = "6F12A07D09CAFA480B0283A3B9FED616", hash_generated_method = "DAB419A7B41FBE9B505A534B468D2942")
    public  GeneralNames(
        ASN1Sequence  seq) {
        this.names = new GeneralName[seq.size()];
        {
            int i = 0;
            boolean varA93A8909C6B18B3F6367766A0DBBDCF3_78650704 = (i != seq.size());
            {
                names[i] = GeneralName.getInstance(seq.getObjectAt(i));
            } 
        } 
        
        
        
        
            
        
    }

    
    public static GeneralNames getInstance(
        Object  obj) {
        if (obj == null || obj instanceof GeneralNames)
        {
            return (GeneralNames)obj;
        }
        if (obj instanceof ASN1Sequence)
        {
            return new GeneralNames((ASN1Sequence)obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
    public static GeneralNames getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.825 -0400", hash_original_method = "9AED96B400BA543408C9F5E967093153", hash_generated_method = "B7A72A9FE13633B31DA0E9518DCB7542")
    public GeneralName[] getNames() {
        GeneralName[] varB4EAC82CA7396A68D541C85D26508E83_800146428 = null; 
        GeneralName[] tmp = new GeneralName[names.length];
        System.arraycopy(names, 0, tmp, 0, names.length);
        varB4EAC82CA7396A68D541C85D26508E83_800146428 = tmp;
        varB4EAC82CA7396A68D541C85D26508E83_800146428.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_800146428;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.825 -0400", hash_original_method = "04D00D35531AB013A64ACFCEB501C4EE", hash_generated_method = "AEDEB0863C43703724C408B5A78E3D7F")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_973329243 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_973329243 = new DERSequence(names);
        varB4EAC82CA7396A68D541C85D26508E83_973329243.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_973329243;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.826 -0400", hash_original_method = "7DDFA5C3E7762D6D39ED7DFFF0863845", hash_generated_method = "AD3B9CF96F8615B30BEF05E494729227")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1007483971 = null; 
        StringBuffer buf = new StringBuffer();
        String sep = System.getProperty("line.separator");
        buf.append("GeneralNames:");
        buf.append(sep);
        {
            int i = 0;
            {
                buf.append("    ");
                buf.append(names[i]);
                buf.append(sep);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1007483971 = buf.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1007483971.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1007483971;
        
        
        
        
        
        
        
            
            
            
        
        
    }

    
}

