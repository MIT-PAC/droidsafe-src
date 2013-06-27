package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.887 -0400", hash_original_field = "83878C91171338902E0FE0FB97A8C47A", hash_generated_field = "78E68994DDB38DACD0C64DDC4B780EA5")

    DERInteger p;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.887 -0400", hash_original_field = "7694F4A66316E53C8CDD9D9954BD611D", hash_generated_field = "6AC8943BCF79B204F433F003E517CC05")

    DERInteger q;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.887 -0400", hash_original_field = "B2F5FF47436671B6E533D8DC3614845D", hash_generated_field = "5A4DB2BF53400ABF311DC12A3223BB24")

    DERInteger g;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.889 -0400", hash_original_method = "81ED473C328949571168B755965D24F0", hash_generated_method = "D2DABC7A8780AAD8CD87320B56EAB45B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.889 -0400", hash_original_method = "B573F82854284864B5E2E05C2136F7B9", hash_generated_method = "B6D69595FCBF57E61A6929A308B82947")
    public  DSAParameter(
        ASN1Sequence  seq) {
        {
            boolean var01335131BE2224430AFFE0AC95254DF2_1855539350 = (seq.size() != 3);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad sequence size: " + seq.size());
            } //End block
        } //End collapsed parenthetic
        Enumeration e;
        e = seq.getObjects();
        p = DERInteger.getInstance(e.nextElement());
        q = DERInteger.getInstance(e.nextElement());
        g = DERInteger.getInstance(e.nextElement());
        addTaint(seq.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.910 -0400", hash_original_method = "AD374264AA86AF8C15D476F74BF4E38F", hash_generated_method = "D7EB0C43FE9FB02A4DFA2B7BB03F4581")
    public BigInteger getP() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1342830245 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1342830245 = p.getPositiveValue();
        varB4EAC82CA7396A68D541C85D26508E83_1342830245.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1342830245;
        // ---------- Original Method ----------
        //return p.getPositiveValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.910 -0400", hash_original_method = "37C66EC3EBD32781416A0E32DB299F24", hash_generated_method = "BE586468D4834721161086B5543FFC81")
    public BigInteger getQ() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_810601597 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_810601597 = q.getPositiveValue();
        varB4EAC82CA7396A68D541C85D26508E83_810601597.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_810601597;
        // ---------- Original Method ----------
        //return q.getPositiveValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.911 -0400", hash_original_method = "76F261BBDCDDE10636E0B2FE4E543575", hash_generated_method = "F0D10D7AE3D39790C73CCE9DC842EEDD")
    public BigInteger getG() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_571416877 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_571416877 = g.getPositiveValue();
        varB4EAC82CA7396A68D541C85D26508E83_571416877.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_571416877;
        // ---------- Original Method ----------
        //return g.getPositiveValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.912 -0400", hash_original_method = "07D924177C8A847E61F30C74ABF9090B", hash_generated_method = "8D3EA78180E0568CEBB30E72E3B00256")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_498047209 = null; //Variable for return #1
        ASN1EncodableVector v;
        v = new ASN1EncodableVector();
        v.add(p);
        v.add(q);
        v.add(g);
        varB4EAC82CA7396A68D541C85D26508E83_498047209 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_498047209.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_498047209;
        // ---------- Original Method ----------
        //ASN1EncodableVector  v = new ASN1EncodableVector();
        //v.add(p);
        //v.add(q);
        //v.add(g);
        //return new DERSequence(v);
    }

    
}

