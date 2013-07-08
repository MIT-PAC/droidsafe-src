package org.bouncycastle.asn1.x9;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.391 -0400", hash_original_field = "4EFA264F5EF3E1A5C95736E07544EBF0", hash_generated_field = "D4FD3D236F6822F3201F264EA949068E")

    private ECCurve curve;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.391 -0400", hash_original_field = "FE4C0F30AA359C41D9F9A5F69C8C4192", hash_generated_field = "84A0CB03E1AA0B2A11E3988D98BBE452")

    private byte[] seed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.391 -0400", hash_original_field = "C2288003BB5201930540DA624FE9B669", hash_generated_field = "E3338F0376BEF793D592DF0C27082DD0")

    private DERObjectIdentifier fieldIdentifier = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.392 -0400", hash_original_method = "D6C787E2A4803225F35FA6BCE1822130", hash_generated_method = "9C77687FAE312DDD695CEE5DA2B770F5")
    public  X9Curve(
        ECCurve     curve) {
        this.curve = curve;
        this.seed = null;
        setFieldIdentifier();
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.392 -0400", hash_original_method = "3B7C14B5F62450195FF0D6E781874500", hash_generated_method = "520BE3AA222231447B5DC8D30ABB9A87")
    public  X9Curve(
        ECCurve     curve,
        byte[]      seed) {
        this.curve = curve;
        this.seed = seed;
        setFieldIdentifier();
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.395 -0400", hash_original_method = "7B136525ED7EAC50EDEE818CB871C643", hash_generated_method = "6328A271BC95AC352A932BCE5BAB1083")
    public  X9Curve(
        X9FieldID     fieldID,
        ASN1Sequence  seq) {
        fieldIdentifier = fieldID.getIdentifier();
        {
            boolean var62E590AD15ACE0239EBD85B6ECDFA12A_540580512 = (fieldIdentifier.equals(prime_field));
            {
                BigInteger p = ((DERInteger)fieldID.getParameters()).getValue();
                X9FieldElement x9A = new X9FieldElement(p, (ASN1OctetString)seq.getObjectAt(0));
                X9FieldElement x9B = new X9FieldElement(p, (ASN1OctetString)seq.getObjectAt(1));
                curve = new ECCurve.Fp(p, x9A.getValue().toBigInteger(), x9B.getValue().toBigInteger());
            } 
            {
                {
                    boolean var3BC873BB046F3404FE6D600BABFCF028_151066926 = (fieldIdentifier.equals(characteristic_two_field));
                    {
                        DERSequence parameters = (DERSequence)fieldID.getParameters();
                        int m = ((DERInteger)parameters.getObjectAt(0)).getValue().
                    intValue();
                        DERObjectIdentifier representation = (DERObjectIdentifier)parameters.getObjectAt(1);
                        int k1 = 0;
                        int k2 = 0;
                        int k3 = 0;
                        {
                            boolean varCA1F0D3D295FF79FD540C5911D088D64_489542592 = (representation.equals(tpBasis));
                            {
                                k1 = ((DERInteger)parameters.getObjectAt(2)).getValue().
                        intValue();
                            } 
                            {
                                DERSequence pentanomial = (DERSequence)parameters.getObjectAt(2);
                                k1 = ((DERInteger)pentanomial.getObjectAt(0)).getValue().
                        intValue();
                                k2 = ((DERInteger)pentanomial.getObjectAt(1)).getValue().
                        intValue();
                                k3 = ((DERInteger)pentanomial.getObjectAt(2)).getValue().
                        intValue();
                            } 
                        } 
                        X9FieldElement x9A = new X9FieldElement(m, k1, k2, k3, (ASN1OctetString)seq.getObjectAt(0));
                        X9FieldElement x9B = new X9FieldElement(m, k1, k2, k3, (ASN1OctetString)seq.getObjectAt(1));
                        curve = new ECCurve.F2m(m, k1, k2, k3, x9A.getValue().toBigInteger(), x9B.getValue().toBigInteger());
                    } 
                } 
            } 
        } 
        {
            boolean varB84C8522B025613859E5A51D2B72F1B8_1970476007 = (seq.size() == 3);
            {
                seed = ((DERBitString)seq.getObjectAt(2)).getBytes();
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.396 -0400", hash_original_method = "D736F484B6800931FE72576618335766", hash_generated_method = "6EE048868B38FC35F72632EFD9ACE669")
    private void setFieldIdentifier() {
        {
            fieldIdentifier = prime_field;
        } 
        {
            fieldIdentifier = characteristic_two_field;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("This type of ECCurve is not "
                    + "implemented");
        } 
        
        
        
            
        
        
        
            
        
        
        
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.398 -0400", hash_original_method = "C3733AEA1B7056ED3896C5DBEA3E645D", hash_generated_method = "1B6CB12C072BC7422FC5B1B35FDECBBD")
    public ECCurve getCurve() {
        ECCurve varB4EAC82CA7396A68D541C85D26508E83_1055447969 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1055447969 = curve;
        varB4EAC82CA7396A68D541C85D26508E83_1055447969.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1055447969;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.399 -0400", hash_original_method = "B051A8408593F9E1275AB818DE8E2A80", hash_generated_method = "CE79482750FD40A6D718A31615B247B9")
    public byte[] getSeed() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1315508704 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1315508704;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.399 -0400", hash_original_method = "FE4C71C21A5F26496E8390DAB2BE9299", hash_generated_method = "5CC22218843E0344C7ED2E9CF8D883F0")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1908963286 = null; 
        ASN1EncodableVector v = new ASN1EncodableVector();
        {
            boolean var62E590AD15ACE0239EBD85B6ECDFA12A_1893411784 = (fieldIdentifier.equals(prime_field));
            {
                v.add(new X9FieldElement(curve.getA()).getDERObject());
                v.add(new X9FieldElement(curve.getB()).getDERObject());
            } 
            {
                boolean varF49669515C9B242B5C36D1E3CE22C8C1_1424488522 = (fieldIdentifier.equals(characteristic_two_field));
                {
                    v.add(new X9FieldElement(curve.getA()).getDERObject());
                    v.add(new X9FieldElement(curve.getB()).getDERObject());
                } 
            } 
        } 
        {
            v.add(new DERBitString(seed));
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1908963286 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_1908963286.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1908963286;
        
        
        
        
            
            
        
        
        
            
            
        
        
        
            
        
        
    }

    
}

