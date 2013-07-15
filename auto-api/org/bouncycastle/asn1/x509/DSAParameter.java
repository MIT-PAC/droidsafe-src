package org.bouncycastle.asn1.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class DSAParameter extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.724 -0400", hash_original_field = "83878C91171338902E0FE0FB97A8C47A", hash_generated_field = "78E68994DDB38DACD0C64DDC4B780EA5")

    DERInteger p;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.724 -0400", hash_original_field = "7694F4A66316E53C8CDD9D9954BD611D", hash_generated_field = "6AC8943BCF79B204F433F003E517CC05")

    DERInteger q;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.724 -0400", hash_original_field = "B2F5FF47436671B6E533D8DC3614845D", hash_generated_field = "5A4DB2BF53400ABF311DC12A3223BB24")

    DERInteger g;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.725 -0400", hash_original_method = "81ED473C328949571168B755965D24F0", hash_generated_method = "D2DABC7A8780AAD8CD87320B56EAB45B")
    public  DSAParameter(
        BigInteger  p,
        BigInteger  q,
        BigInteger  g) {
        this.p = new DERInteger(p);
        this.q = new DERInteger(q);
        this.g = new DERInteger(g);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.725 -0400", hash_original_method = "B573F82854284864B5E2E05C2136F7B9", hash_generated_method = "2608E0305A7CF99ADC40A6C9D050FF62")
    public  DSAParameter(
        ASN1Sequence  seq) {
        {
            boolean var01335131BE2224430AFFE0AC95254DF2_1835831108 = (seq.size() != 3);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad sequence size: " + seq.size());
            } 
        } 
        Enumeration e = seq.getObjects();
        p = DERInteger.getInstance(e.nextElement());
        q = DERInteger.getInstance(e.nextElement());
        g = DERInteger.getInstance(e.nextElement());
        addTaint(seq.getTaint());
        
        
        
            
        
        
        
        
        
    }

    
    public static DSAParameter getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    
    public static DSAParameter getInstance(
        Object obj) {
        if(obj == null || obj instanceof DSAParameter) 
        {
            return (DSAParameter)obj;
        }
        if(obj instanceof ASN1Sequence) 
        {
            return new DSAParameter((ASN1Sequence)obj);
        }
        throw new IllegalArgumentException("Invalid DSAParameter: " + obj.getClass().getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.726 -0400", hash_original_method = "AD374264AA86AF8C15D476F74BF4E38F", hash_generated_method = "A0C5038EBCFA814D0FBC748956E899F9")
    public BigInteger getP() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_191845811 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_191845811 = p.getPositiveValue();
        varB4EAC82CA7396A68D541C85D26508E83_191845811.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_191845811;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.727 -0400", hash_original_method = "37C66EC3EBD32781416A0E32DB299F24", hash_generated_method = "81510D2E94F1A97F442B455994B9A3BD")
    public BigInteger getQ() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_559181990 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_559181990 = q.getPositiveValue();
        varB4EAC82CA7396A68D541C85D26508E83_559181990.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_559181990;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.727 -0400", hash_original_method = "76F261BBDCDDE10636E0B2FE4E543575", hash_generated_method = "5111A68C4FABCF7540FFB70CCF2FE662")
    public BigInteger getG() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1479807156 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1479807156 = g.getPositiveValue();
        varB4EAC82CA7396A68D541C85D26508E83_1479807156.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1479807156;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.727 -0400", hash_original_method = "07D924177C8A847E61F30C74ABF9090B", hash_generated_method = "A9454ACB2602592F5CCD76CC6783E4DF")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_915033914 = null; 
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(p);
        v.add(q);
        v.add(g);
        varB4EAC82CA7396A68D541C85D26508E83_915033914 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_915033914.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_915033914;
        
        
        
        
        
        
    }

    
}

