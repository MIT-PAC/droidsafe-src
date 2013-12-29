package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:52.550 -0500", hash_original_method = "2F04F73A5FFC4C5959B0385363F30C08", hash_generated_method = "42F9037B7509CB2C4ABC796954D5FA89")
    public static DSAParameter getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:52.551 -0500", hash_original_method = "634544A11A105D5E7722C04AF5ED85F5", hash_generated_method = "AEFDE79F01263CECD39DCC581BA8771A")
    public static DSAParameter getInstance(
        Object obj)
    {
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.647 -0400", hash_original_field = "83878C91171338902E0FE0FB97A8C47A", hash_generated_field = "78E68994DDB38DACD0C64DDC4B780EA5")

    DERInteger p;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.647 -0400", hash_original_field = "7694F4A66316E53C8CDD9D9954BD611D", hash_generated_field = "6AC8943BCF79B204F433F003E517CC05")

    DERInteger q;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.647 -0400", hash_original_field = "B2F5FF47436671B6E533D8DC3614845D", hash_generated_field = "5A4DB2BF53400ABF311DC12A3223BB24")

    DERInteger g;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:52.552 -0500", hash_original_method = "81ED473C328949571168B755965D24F0", hash_generated_method = "CB0BB17DD5A08DC5C1EDA0C8BFA56FBF")
    public DSAParameter(
        BigInteger  p,
        BigInteger  q,
        BigInteger  g)
    {
        this.p = new DERInteger(p);
        this.q = new DERInteger(q);
        this.g = new DERInteger(g);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:52.553 -0500", hash_original_method = "B573F82854284864B5E2E05C2136F7B9", hash_generated_method = "DD26581B8A4A0E5A3B0403F099737559")
    public DSAParameter(
        ASN1Sequence  seq)
    {
        if (seq.size() != 3)
        {
            throw new IllegalArgumentException("Bad sequence size: " + seq.size());
        }
        
        Enumeration     e = seq.getObjects();

        p = DERInteger.getInstance(e.nextElement());
        q = DERInteger.getInstance(e.nextElement());
        g = DERInteger.getInstance(e.nextElement());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:52.554 -0500", hash_original_method = "AD374264AA86AF8C15D476F74BF4E38F", hash_generated_method = "8925DA88C5641891721F7DC8D031D60F")
    public BigInteger getP()
    {
        return p.getPositiveValue();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:52.555 -0500", hash_original_method = "37C66EC3EBD32781416A0E32DB299F24", hash_generated_method = "2857EFD9EA17BBDD472B5B6058178928")
    public BigInteger getQ()
    {
        return q.getPositiveValue();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:52.555 -0500", hash_original_method = "76F261BBDCDDE10636E0B2FE4E543575", hash_generated_method = "B7DF6C5ACBB61DD97C2FE7B167614F43")
    public BigInteger getG()
    {
        return g.getPositiveValue();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:52.556 -0500", hash_original_method = "07D924177C8A847E61F30C74ABF9090B", hash_generated_method = "4EDF26274983A92B680C3476DCD53D9D")
    public DERObject toASN1Object()
    {
        ASN1EncodableVector  v = new ASN1EncodableVector();

        v.add(p);
        v.add(q);
        v.add(g);

        return new DERSequence(v);
    }

    
}

