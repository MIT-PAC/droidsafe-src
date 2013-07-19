package org.bouncycastle.asn1;

// Droidsafe Imports
import java.util.Vector;

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class DEREncodableVector {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.168 -0400", hash_original_field = "7333F09B91C7F702C0D4E47815B90759", hash_generated_field = "A7A9A9F7A17391F6E585D35448FF7802")

    Vector v = new Vector();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.168 -0400", hash_original_method = "4B1458BF3C50FB4227938042BB3B78D8", hash_generated_method = "1DD20547FCD1109D010042A3252F39EC")
    public  DEREncodableVector() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.168 -0400", hash_original_method = "D2631DDAF2947787DEB94C0E4C39923E", hash_generated_method = "C07A46466B2C3107C1E9219F21752B31")
    public void add(
        DEREncodable   obj) {
        addTaint(obj.getTaint());
        v.addElement(obj);
        // ---------- Original Method ----------
        //v.addElement(obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.169 -0400", hash_original_method = "B314138255529409821E04A292C38866", hash_generated_method = "FB56AB608D137DD7266B6373036FD8C7")
    public DEREncodable get(
        int i) {
        addTaint(i);
DEREncodable var8191964E2FCEE7188EFAEBD767F0FDB4_372246353 =         (DEREncodable)v.elementAt(i);
        var8191964E2FCEE7188EFAEBD767F0FDB4_372246353.addTaint(taint);
        return var8191964E2FCEE7188EFAEBD767F0FDB4_372246353;
        // ---------- Original Method ----------
        //return (DEREncodable)v.elementAt(i);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.169 -0400", hash_original_method = "F82248B1BB6EFF1F27955CBD5C3A97B0", hash_generated_method = "08FBD9B0CE225AE4E1F09919178CE294")
    public int size() {
        int var51AE616C0259F34AABC75BA09943E804_549983705 = (v.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1553279208 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1553279208;
        // ---------- Original Method ----------
        //return v.size();
    }

    
}

