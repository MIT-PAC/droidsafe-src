package org.bouncycastle.asn1.x9;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.math.ec.ECCurve;

public class X9Curve extends ASN1Encodable implements X9ObjectIdentifiers {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.421 -0400", hash_original_field = "4EFA264F5EF3E1A5C95736E07544EBF0", hash_generated_field = "D4FD3D236F6822F3201F264EA949068E")

    private ECCurve curve;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.422 -0400", hash_original_field = "FE4C0F30AA359C41D9F9A5F69C8C4192", hash_generated_field = "84A0CB03E1AA0B2A11E3988D98BBE452")

    private byte[] seed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.422 -0400", hash_original_field = "C2288003BB5201930540DA624FE9B669", hash_generated_field = "E3338F0376BEF793D592DF0C27082DD0")

    private DERObjectIdentifier fieldIdentifier = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.422 -0400", hash_original_method = "D6C787E2A4803225F35FA6BCE1822130", hash_generated_method = "9C77687FAE312DDD695CEE5DA2B770F5")
    public  X9Curve(
        ECCurve     curve) {
        this.curve = curve;
        this.seed = null;
        setFieldIdentifier();
        // ---------- Original Method ----------
        //this.curve = curve;
        //this.seed = null;
        //setFieldIdentifier();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.422 -0400", hash_original_method = "3B7C14B5F62450195FF0D6E781874500", hash_generated_method = "520BE3AA222231447B5DC8D30ABB9A87")
    public  X9Curve(
        ECCurve     curve,
        byte[]      seed) {
        this.curve = curve;
        this.seed = seed;
        setFieldIdentifier();
        // ---------- Original Method ----------
        //this.curve = curve;
        //this.seed = seed;
        //setFieldIdentifier();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.436 -0400", hash_original_method = "7B136525ED7EAC50EDEE818CB871C643", hash_generated_method = "6DEC17DE26FE69A2CC73F018975A010A")
    public  X9Curve(
        X9FieldID     fieldID,
        ASN1Sequence  seq) {
        fieldIdentifier = fieldID.getIdentifier();
        {
            boolean var62E590AD15ACE0239EBD85B6ECDFA12A_1763681992 = (fieldIdentifier.equals(prime_field));
            {
                BigInteger p;
                p = ((DERInteger)fieldID.getParameters()).getValue();
                X9FieldElement x9A;
                x9A = new X9FieldElement(p, (ASN1OctetString)seq.getObjectAt(0));
                X9FieldElement x9B;
                x9B = new X9FieldElement(p, (ASN1OctetString)seq.getObjectAt(1));
                curve = new ECCurve.Fp(p, x9A.getValue().toBigInteger(), x9B.getValue().toBigInteger());
            } //End block
            {
                {
                    boolean var3BC873BB046F3404FE6D600BABFCF028_1875489201 = (fieldIdentifier.equals(characteristic_two_field));
                    {
                        DERSequence parameters;
                        parameters = (DERSequence)fieldID.getParameters();
                        int m;
                        m = ((DERInteger)parameters.getObjectAt(0)).getValue().
                    intValue();
                        DERObjectIdentifier representation;
                        representation = (DERObjectIdentifier)parameters.getObjectAt(1);
                        int k1;
                        k1 = 0;
                        int k2;
                        k2 = 0;
                        int k3;
                        k3 = 0;
                        {
                            boolean varCA1F0D3D295FF79FD540C5911D088D64_1295288749 = (representation.equals(tpBasis));
                            {
                                k1 = ((DERInteger)parameters.getObjectAt(2)).getValue().
                        intValue();
                            } //End block
                            {
                                DERSequence pentanomial;
                                pentanomial = (DERSequence)parameters.getObjectAt(2);
                                k1 = ((DERInteger)pentanomial.getObjectAt(0)).getValue().
                        intValue();
                                k2 = ((DERInteger)pentanomial.getObjectAt(1)).getValue().
                        intValue();
                                k3 = ((DERInteger)pentanomial.getObjectAt(2)).getValue().
                        intValue();
                            } //End block
                        } //End collapsed parenthetic
                        X9FieldElement x9A;
                        x9A = new X9FieldElement(m, k1, k2, k3, (ASN1OctetString)seq.getObjectAt(0));
                        X9FieldElement x9B;
                        x9B = new X9FieldElement(m, k1, k2, k3, (ASN1OctetString)seq.getObjectAt(1));
                        curve = new ECCurve.F2m(m, k1, k2, k3, x9A.getValue().toBigInteger(), x9B.getValue().toBigInteger());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB84C8522B025613859E5A51D2B72F1B8_2120166106 = (seq.size() == 3);
            {
                seed = ((DERBitString)seq.getObjectAt(2)).getBytes();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.437 -0400", hash_original_method = "D736F484B6800931FE72576618335766", hash_generated_method = "6EE048868B38FC35F72632EFD9ACE669")
    private void setFieldIdentifier() {
        {
            fieldIdentifier = prime_field;
        } //End block
        {
            fieldIdentifier = characteristic_two_field;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("This type of ECCurve is not "
                    + "implemented");
        } //End block
        // ---------- Original Method ----------
        //if (curve instanceof ECCurve.Fp)
        //{
            //fieldIdentifier = prime_field;
        //}
        //else if (curve instanceof ECCurve.F2m)
        //{
            //fieldIdentifier = characteristic_two_field;
        //}
        //else
        //{
            //throw new IllegalArgumentException("This type of ECCurve is not "
                    //+ "implemented");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.438 -0400", hash_original_method = "C3733AEA1B7056ED3896C5DBEA3E645D", hash_generated_method = "36EB886CB2DC2E0788FAB6B9E4EF6F9C")
    public ECCurve getCurve() {
        ECCurve varB4EAC82CA7396A68D541C85D26508E83_1788617623 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1788617623 = curve;
        varB4EAC82CA7396A68D541C85D26508E83_1788617623.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1788617623;
        // ---------- Original Method ----------
        //return curve;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.438 -0400", hash_original_method = "B051A8408593F9E1275AB818DE8E2A80", hash_generated_method = "DFEE9A3A36E72CE586CE2A1AE81F1DB9")
    public byte[] getSeed() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_738483506 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_738483506;
        // ---------- Original Method ----------
        //return seed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.439 -0400", hash_original_method = "FE4C71C21A5F26496E8390DAB2BE9299", hash_generated_method = "A99FA916855E7E35FFE340DC7086F7E8")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1302527172 = null; //Variable for return #1
        ASN1EncodableVector v;
        v = new ASN1EncodableVector();
        {
            boolean var62E590AD15ACE0239EBD85B6ECDFA12A_1947457904 = (fieldIdentifier.equals(prime_field));
            {
                v.add(new X9FieldElement(curve.getA()).getDERObject());
                v.add(new X9FieldElement(curve.getB()).getDERObject());
            } //End block
            {
                boolean varF49669515C9B242B5C36D1E3CE22C8C1_714593453 = (fieldIdentifier.equals(characteristic_two_field));
                {
                    v.add(new X9FieldElement(curve.getA()).getDERObject());
                    v.add(new X9FieldElement(curve.getB()).getDERObject());
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            v.add(new DERBitString(seed));
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1302527172 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_1302527172.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1302527172;
        // ---------- Original Method ----------
        //ASN1EncodableVector v = new ASN1EncodableVector();
        //if (fieldIdentifier.equals(prime_field)) 
        //{ 
            //v.add(new X9FieldElement(curve.getA()).getDERObject());
            //v.add(new X9FieldElement(curve.getB()).getDERObject());
        //} 
        //else if (fieldIdentifier.equals(characteristic_two_field)) 
        //{
            //v.add(new X9FieldElement(curve.getA()).getDERObject());
            //v.add(new X9FieldElement(curve.getB()).getDERObject());
        //}
        //if (seed != null)
        //{
            //v.add(new DERBitString(seed));
        //}
        //return new DERSequence(v);
    }

    
}

