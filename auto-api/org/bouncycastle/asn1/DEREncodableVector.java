package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Vector;

public class DEREncodableVector {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.350 -0400", hash_original_field = "7333F09B91C7F702C0D4E47815B90759", hash_generated_field = "A7A9A9F7A17391F6E585D35448FF7802")

    Vector v = new Vector();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.350 -0400", hash_original_method = "4B1458BF3C50FB4227938042BB3B78D8", hash_generated_method = "1DD20547FCD1109D010042A3252F39EC")
    public  DEREncodableVector() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.351 -0400", hash_original_method = "D2631DDAF2947787DEB94C0E4C39923E", hash_generated_method = "CE4D5174E359CB6A647B86553DDBC198")
    public void add(
        DEREncodable   obj) {
        v.addElement(obj);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.352 -0400", hash_original_method = "B314138255529409821E04A292C38866", hash_generated_method = "8485EEB927749F041A231F5ED099AF4D")
    public DEREncodable get(
        int i) {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1967789673 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1967789673 = (DEREncodable)v.elementAt(i);
        addTaint(i);
        varB4EAC82CA7396A68D541C85D26508E83_1967789673.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1967789673;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.353 -0400", hash_original_method = "F82248B1BB6EFF1F27955CBD5C3A97B0", hash_generated_method = "848FC7F0D6D868B445CAF2011F5E6889")
    public int size() {
        int varE3024CD2899AAFA1DB065784012AAC08_1452492372 = (v.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1630515942 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1630515942;
        
        
    }

    
}

