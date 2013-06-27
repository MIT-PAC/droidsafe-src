package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Vector;

public class DEREncodableVector {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.920 -0400", hash_original_field = "7333F09B91C7F702C0D4E47815B90759", hash_generated_field = "A7A9A9F7A17391F6E585D35448FF7802")

    Vector v = new Vector();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.920 -0400", hash_original_method = "4B1458BF3C50FB4227938042BB3B78D8", hash_generated_method = "1DD20547FCD1109D010042A3252F39EC")
    public  DEREncodableVector() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.920 -0400", hash_original_method = "D2631DDAF2947787DEB94C0E4C39923E", hash_generated_method = "CE4D5174E359CB6A647B86553DDBC198")
    public void add(
        DEREncodable   obj) {
        v.addElement(obj);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //v.addElement(obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.921 -0400", hash_original_method = "B314138255529409821E04A292C38866", hash_generated_method = "76A878507065C3D47546DFA35CEBE2DA")
    public DEREncodable get(
        int i) {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_893970156 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_893970156 = (DEREncodable)v.elementAt(i);
        addTaint(i);
        varB4EAC82CA7396A68D541C85D26508E83_893970156.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_893970156;
        // ---------- Original Method ----------
        //return (DEREncodable)v.elementAt(i);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.921 -0400", hash_original_method = "F82248B1BB6EFF1F27955CBD5C3A97B0", hash_generated_method = "F4E8B6AF237E713B6B661E729A70C0D2")
    public int size() {
        int varE3024CD2899AAFA1DB065784012AAC08_1800242955 = (v.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1294164377 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1294164377;
        // ---------- Original Method ----------
        //return v.size();
    }

    
}

