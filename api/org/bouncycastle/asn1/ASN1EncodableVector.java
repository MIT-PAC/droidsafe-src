package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Vector;

public class ASN1EncodableVector extends DEREncodableVector {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.531 -0400", hash_original_field = "7333F09B91C7F702C0D4E47815B90759", hash_generated_field = "A7A9A9F7A17391F6E585D35448FF7802")

    Vector v = new Vector();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.531 -0400", hash_original_method = "631383CBD9A750B80992BEF56F7E2945", hash_generated_method = "967E45ED59354704C65E0D33E00C0F4F")
    public  ASN1EncodableVector() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.532 -0400", hash_original_method = "D2631DDAF2947787DEB94C0E4C39923E", hash_generated_method = "C07A46466B2C3107C1E9219F21752B31")
    public void add(DEREncodable obj) {
        addTaint(obj.getTaint());
        v.addElement(obj);
        // ---------- Original Method ----------
        //v.addElement(obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.532 -0400", hash_original_method = "B314138255529409821E04A292C38866", hash_generated_method = "8DB1A259552A01C34901B3B32F81840B")
    public DEREncodable get(int i) {
        addTaint(i);
DEREncodable var8191964E2FCEE7188EFAEBD767F0FDB4_1453115967 =         (DEREncodable)v.elementAt(i);
        var8191964E2FCEE7188EFAEBD767F0FDB4_1453115967.addTaint(taint);
        return var8191964E2FCEE7188EFAEBD767F0FDB4_1453115967;
        // ---------- Original Method ----------
        //return (DEREncodable)v.elementAt(i);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.532 -0400", hash_original_method = "F82248B1BB6EFF1F27955CBD5C3A97B0", hash_generated_method = "2592458B177134CCDDAFBD6E54750549")
    public int size() {
        int var51AE616C0259F34AABC75BA09943E804_2041358170 = (v.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1420313607 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1420313607;
        // ---------- Original Method ----------
        //return v.size();
    }

    
}

