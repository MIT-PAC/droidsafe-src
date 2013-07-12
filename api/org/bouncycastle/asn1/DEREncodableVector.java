package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Vector;

public class DEREncodableVector {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.948 -0400", hash_original_field = "7333F09B91C7F702C0D4E47815B90759", hash_generated_field = "A7A9A9F7A17391F6E585D35448FF7802")

    Vector v = new Vector();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.948 -0400", hash_original_method = "4B1458BF3C50FB4227938042BB3B78D8", hash_generated_method = "1DD20547FCD1109D010042A3252F39EC")
    public  DEREncodableVector() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.949 -0400", hash_original_method = "D2631DDAF2947787DEB94C0E4C39923E", hash_generated_method = "C07A46466B2C3107C1E9219F21752B31")
    public void add(
        DEREncodable   obj) {
        addTaint(obj.getTaint());
        v.addElement(obj);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.949 -0400", hash_original_method = "B314138255529409821E04A292C38866", hash_generated_method = "E0E9C522CC7EFFB97B1A4F6186FB9265")
    public DEREncodable get(
        int i) {
        addTaint(i);
DEREncodable var8191964E2FCEE7188EFAEBD767F0FDB4_743275781 =         (DEREncodable)v.elementAt(i);
        var8191964E2FCEE7188EFAEBD767F0FDB4_743275781.addTaint(taint);
        return var8191964E2FCEE7188EFAEBD767F0FDB4_743275781;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.949 -0400", hash_original_method = "F82248B1BB6EFF1F27955CBD5C3A97B0", hash_generated_method = "90178CE0CA15653A8C76627196E38103")
    public int size() {
        int var51AE616C0259F34AABC75BA09943E804_1660783274 = (v.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_664303414 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_664303414;
        
        
    }

    
}

