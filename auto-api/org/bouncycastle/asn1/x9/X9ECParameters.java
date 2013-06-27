package org.bouncycastle.asn1.x9;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import java.math.BigInteger;

public class X9ECParameters extends ASN1Encodable implements X9ObjectIdentifiers {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.398 -0400", hash_original_field = "D87F5109F111FEC49B0D2349C971D42D", hash_generated_field = "161E0CD2A331703CED55991AA7670409")

    private X9FieldID fieldID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.398 -0400", hash_original_field = "4EFA264F5EF3E1A5C95736E07544EBF0", hash_generated_field = "D4FD3D236F6822F3201F264EA949068E")

    private ECCurve curve;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.398 -0400", hash_original_field = "B2F5FF47436671B6E533D8DC3614845D", hash_generated_field = "1F461AF19CABD1B00959F9F3AD8297A2")

    private ECPoint g;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.398 -0400", hash_original_field = "7B8B965AD4BCA0E41AB51DE7B31363A1", hash_generated_field = "28997BC83DA18A620109895922F10617")

    private BigInteger n;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.398 -0400", hash_original_field = "2510C39011C5BE704182423E3A695E91", hash_generated_field = "2BC612FFF03C8C6BFD81D1617A7F7383")

    private BigInteger h;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.398 -0400", hash_original_field = "FE4C0F30AA359C41D9F9A5F69C8C4192", hash_generated_field = "84A0CB03E1AA0B2A11E3988D98BBE452")

    private byte[] seed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.417 -0400", hash_original_method = "38D6105F07283EB5F8B3605923A2D06B", hash_generated_method = "CE1E073299A31D41B5A6E9BAC5439DB9")
    public  X9ECParameters(
        ASN1Sequence  seq) {
        {
            boolean var96CD03E362CB7FBCC40B4D2C4C17A3C2_760975430 = (!(seq.getObjectAt(0) instanceof DERInteger)
           || !((DERInteger)seq.getObjectAt(0)).getValue().equals(ONE));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("bad version in X9ECParameters");
            } //End block
        } //End collapsed parenthetic
        X9Curve x9c;
        x9c = new X9Curve(
                        new X9FieldID((ASN1Sequence)seq.getObjectAt(1)),
                        (ASN1Sequence)seq.getObjectAt(2));
        this.curve = x9c.getCurve();
        this.g = new X9ECPoint(curve, (ASN1OctetString)seq.getObjectAt(3)).getPoint();
        this.n = ((DERInteger)seq.getObjectAt(4)).getValue();
        this.seed = x9c.getSeed();
        {
            boolean var137928E29A9DE0EA9CAE203D397A260C_808708150 = (seq.size() == 6);
            {
                this.h = ((DERInteger)seq.getObjectAt(5)).getValue();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!(seq.getObjectAt(0) instanceof DERInteger)
           //|| !((DERInteger)seq.getObjectAt(0)).getValue().equals(ONE))
        //{
            //throw new IllegalArgumentException("bad version in X9ECParameters");
        //}
        //X9Curve     x9c = new X9Curve(
                        //new X9FieldID((ASN1Sequence)seq.getObjectAt(1)),
                        //(ASN1Sequence)seq.getObjectAt(2));
        //this.curve = x9c.getCurve();
        //this.g = new X9ECPoint(curve, (ASN1OctetString)seq.getObjectAt(3)).getPoint();
        //this.n = ((DERInteger)seq.getObjectAt(4)).getValue();
        //this.seed = x9c.getSeed();
        //if (seq.size() == 6)
        //{
            //this.h = ((DERInteger)seq.getObjectAt(5)).getValue();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.417 -0400", hash_original_method = "739112175432B7FC1F3897612DAEA859", hash_generated_method = "A8E0CA538FADA9FFA24D47C15AF9AB06")
    public  X9ECParameters(
        ECCurve     curve,
        ECPoint     g,
        BigInteger  n) {
        this(curve, g, n, ONE, null);
        addTaint(curve.getTaint());
        addTaint(g.getTaint());
        addTaint(n.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.417 -0400", hash_original_method = "7F13F9D9B68D09FF2E2DEF2F93290D05", hash_generated_method = "07D3CF5A8B654BAB698288AA5A0C5979")
    public  X9ECParameters(
        ECCurve     curve,
        ECPoint     g,
        BigInteger  n,
        BigInteger  h) {
        this(curve, g, n, h, null);
        addTaint(curve.getTaint());
        addTaint(g.getTaint());
        addTaint(n.getTaint());
        addTaint(h.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.419 -0400", hash_original_method = "1843E539ACF8FE39D46257BC325E0DC6", hash_generated_method = "AED1E600B3505C722C2BB6D1BFB4B7BA")
    public  X9ECParameters(
        ECCurve     curve,
        ECPoint     g,
        BigInteger  n,
        BigInteger  h,
        byte[]      seed) {
        this.curve = curve;
        this.g = g;
        this.n = n;
        this.h = h;
        this.seed = seed;
        {
            this.fieldID = new X9FieldID(((ECCurve.Fp)curve).getQ());
        } //End block
        {
            {
                ECCurve.F2m curveF2m;
                curveF2m = (ECCurve.F2m)curve;
                this.fieldID = new X9FieldID(curveF2m.getM(), curveF2m.getK1(),
                    curveF2m.getK2(), curveF2m.getK3());
            } //End block
        } //End block
        // ---------- Original Method ----------
        //this.curve = curve;
        //this.g = g;
        //this.n = n;
        //this.h = h;
        //this.seed = seed;
        //if (curve instanceof ECCurve.Fp)
        //{
            //this.fieldID = new X9FieldID(((ECCurve.Fp)curve).getQ());
        //}
        //else
        //{
            //if (curve instanceof ECCurve.F2m)
            //{
                //ECCurve.F2m curveF2m = (ECCurve.F2m)curve;
                //this.fieldID = new X9FieldID(curveF2m.getM(), curveF2m.getK1(),
                    //curveF2m.getK2(), curveF2m.getK3());
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.420 -0400", hash_original_method = "C3733AEA1B7056ED3896C5DBEA3E645D", hash_generated_method = "1D9EEA982D095DFD4D36596CB1BC2EEF")
    public ECCurve getCurve() {
        ECCurve varB4EAC82CA7396A68D541C85D26508E83_2086633636 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2086633636 = curve;
        varB4EAC82CA7396A68D541C85D26508E83_2086633636.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2086633636;
        // ---------- Original Method ----------
        //return curve;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.420 -0400", hash_original_method = "F49644298FFD38F2CFD5B0D378F29102", hash_generated_method = "6193B021D2ED8BEAF96261A609BDD6C3")
    public ECPoint getG() {
        ECPoint varB4EAC82CA7396A68D541C85D26508E83_1249186371 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1249186371 = g;
        varB4EAC82CA7396A68D541C85D26508E83_1249186371.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1249186371;
        // ---------- Original Method ----------
        //return g;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.424 -0400", hash_original_method = "30674A850FAA3528D3976F32A0E4EE43", hash_generated_method = "C69A819AA5A48D8084474A4C349419CC")
    public BigInteger getN() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_210468349 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_210468349 = n;
        varB4EAC82CA7396A68D541C85D26508E83_210468349.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_210468349;
        // ---------- Original Method ----------
        //return n;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.435 -0400", hash_original_method = "9DE3987FDD4335D5C0BE76F667E07DA1", hash_generated_method = "6B1A0376CA6D46412FEBB106AAA62DD5")
    public BigInteger getH() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1222799212 = null; //Variable for return #1
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1356908483 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1222799212 = ONE;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1356908483 = h;
        BigInteger varA7E53CE21691AB073D9660D615818899_212930282; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_212930282 = varB4EAC82CA7396A68D541C85D26508E83_1222799212;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_212930282 = varB4EAC82CA7396A68D541C85D26508E83_1356908483;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_212930282.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_212930282;
        // ---------- Original Method ----------
        //if (h == null)
        //{
            //return ONE;        
        //}
        //return h;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.435 -0400", hash_original_method = "B051A8408593F9E1275AB818DE8E2A80", hash_generated_method = "B0CE81A155B8CE3E320E6B2CFD769DB7")
    public byte[] getSeed() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1084209682 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1084209682;
        // ---------- Original Method ----------
        //return seed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.436 -0400", hash_original_method = "8FEF0683FB02574D7DCECBAD72741893", hash_generated_method = "56530165FDE06DAA1A560976B9B4DD6F")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_855860520 = null; //Variable for return #1
        ASN1EncodableVector v;
        v = new ASN1EncodableVector();
        v.add(new DERInteger(1));
        v.add(fieldID);
        v.add(new X9Curve(curve, seed));
        v.add(new X9ECPoint(g));
        v.add(new DERInteger(n));
        {
            v.add(new DERInteger(h));
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_855860520 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_855860520.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_855860520;
        // ---------- Original Method ----------
        //ASN1EncodableVector v = new ASN1EncodableVector();
        //v.add(new DERInteger(1));
        //v.add(fieldID);
        //v.add(new X9Curve(curve, seed));
        //v.add(new X9ECPoint(g));
        //v.add(new DERInteger(n));
        //if (h != null)
        //{
            //v.add(new DERInteger(h));
        //}
        //return new DERSequence(v);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.436 -0400", hash_original_field = "ADD10266D801BA1050DC92ABCE3C6C53", hash_generated_field = "8E908CD0C47237998BAFFEBCC326A53A")

    private static BigInteger ONE = BigInteger.valueOf(1);
}

