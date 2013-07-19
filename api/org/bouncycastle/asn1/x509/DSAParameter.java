package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import java.math.BigInteger;
import java.util.Enumeration;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class DSAParameter extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.647 -0400", hash_original_field = "83878C91171338902E0FE0FB97A8C47A", hash_generated_field = "78E68994DDB38DACD0C64DDC4B780EA5")

    DERInteger p;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.647 -0400", hash_original_field = "7694F4A66316E53C8CDD9D9954BD611D", hash_generated_field = "6AC8943BCF79B204F433F003E517CC05")

    DERInteger q;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.647 -0400", hash_original_field = "B2F5FF47436671B6E533D8DC3614845D", hash_generated_field = "5A4DB2BF53400ABF311DC12A3223BB24")

    DERInteger g;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.648 -0400", hash_original_method = "81ED473C328949571168B755965D24F0", hash_generated_method = "D2DABC7A8780AAD8CD87320B56EAB45B")
    public  DSAParameter(
        BigInteger  p,
        BigInteger  q,
        BigInteger  g) {
        this.p = new DERInteger(p);
        this.q = new DERInteger(q);
        this.g = new DERInteger(g);
        // ---------- Original Method ----------
        //this.p = new DERInteger(p);
        //this.q = new DERInteger(q);
        //this.g = new DERInteger(g);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.649 -0400", hash_original_method = "B573F82854284864B5E2E05C2136F7B9", hash_generated_method = "AACD86D349849DEB7C6DD8188B6E38A5")
    public  DSAParameter(
        ASN1Sequence  seq) {
        addTaint(seq.getTaint());
        if(seq.size() != 3)        
        {
            IllegalArgumentException varA2072CF614C7B8C7696DD5A02DBCCE9C_84247090 = new IllegalArgumentException("Bad sequence size: " + seq.size());
            varA2072CF614C7B8C7696DD5A02DBCCE9C_84247090.addTaint(taint);
            throw varA2072CF614C7B8C7696DD5A02DBCCE9C_84247090;
        } //End block
        Enumeration e = seq.getObjects();
        p = DERInteger.getInstance(e.nextElement());
        q = DERInteger.getInstance(e.nextElement());
        g = DERInteger.getInstance(e.nextElement());
        // ---------- Original Method ----------
        //if (seq.size() != 3)
        //{
            //throw new IllegalArgumentException("Bad sequence size: " + seq.size());
        //}
        //Enumeration     e = seq.getObjects();
        //p = DERInteger.getInstance(e.nextElement());
        //q = DERInteger.getInstance(e.nextElement());
        //g = DERInteger.getInstance(e.nextElement());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.649 -0400", hash_original_method = "AD374264AA86AF8C15D476F74BF4E38F", hash_generated_method = "AEA53AE03FAB59F0CB0D5577433320E3")
    public BigInteger getP() {
BigInteger var3EF426B4E1F2501E96AD21D32A3B62C4_1073534039 =         p.getPositiveValue();
        var3EF426B4E1F2501E96AD21D32A3B62C4_1073534039.addTaint(taint);
        return var3EF426B4E1F2501E96AD21D32A3B62C4_1073534039;
        // ---------- Original Method ----------
        //return p.getPositiveValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.650 -0400", hash_original_method = "37C66EC3EBD32781416A0E32DB299F24", hash_generated_method = "82BE35F24C1F14F71A370C7BBB47F12F")
    public BigInteger getQ() {
BigInteger varCC858F5C6E76A5B6A466839CC6EE2CF8_1580255766 =         q.getPositiveValue();
        varCC858F5C6E76A5B6A466839CC6EE2CF8_1580255766.addTaint(taint);
        return varCC858F5C6E76A5B6A466839CC6EE2CF8_1580255766;
        // ---------- Original Method ----------
        //return q.getPositiveValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.650 -0400", hash_original_method = "76F261BBDCDDE10636E0B2FE4E543575", hash_generated_method = "DFDB1E7230A889F8F0AEC11C8BBC7E0B")
    public BigInteger getG() {
BigInteger varAF2148D9A6BFAF217D996B041348DFDA_2023221358 =         g.getPositiveValue();
        varAF2148D9A6BFAF217D996B041348DFDA_2023221358.addTaint(taint);
        return varAF2148D9A6BFAF217D996B041348DFDA_2023221358;
        // ---------- Original Method ----------
        //return g.getPositiveValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.650 -0400", hash_original_method = "07D924177C8A847E61F30C74ABF9090B", hash_generated_method = "9F2CBC31D6AB69CBB2561A387A6B1D7D")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(p);
        v.add(q);
        v.add(g);
DERObject var0B338F106E3279986C87B595B0F4A439_441118846 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_441118846.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_441118846;
        // ---------- Original Method ----------
        //ASN1EncodableVector  v = new ASN1EncodableVector();
        //v.add(p);
        //v.add(q);
        //v.add(g);
        //return new DERSequence(v);
    }

    
}

