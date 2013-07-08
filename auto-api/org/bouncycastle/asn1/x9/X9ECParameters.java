package org.bouncycastle.asn1.x9;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.420 -0400", hash_original_field = "D87F5109F111FEC49B0D2349C971D42D", hash_generated_field = "161E0CD2A331703CED55991AA7670409")

    private X9FieldID fieldID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.420 -0400", hash_original_field = "4EFA264F5EF3E1A5C95736E07544EBF0", hash_generated_field = "D4FD3D236F6822F3201F264EA949068E")

    private ECCurve curve;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.420 -0400", hash_original_field = "B2F5FF47436671B6E533D8DC3614845D", hash_generated_field = "1F461AF19CABD1B00959F9F3AD8297A2")

    private ECPoint g;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.420 -0400", hash_original_field = "7B8B965AD4BCA0E41AB51DE7B31363A1", hash_generated_field = "28997BC83DA18A620109895922F10617")

    private BigInteger n;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.420 -0400", hash_original_field = "2510C39011C5BE704182423E3A695E91", hash_generated_field = "2BC612FFF03C8C6BFD81D1617A7F7383")

    private BigInteger h;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.420 -0400", hash_original_field = "FE4C0F30AA359C41D9F9A5F69C8C4192", hash_generated_field = "84A0CB03E1AA0B2A11E3988D98BBE452")

    private byte[] seed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.433 -0400", hash_original_method = "38D6105F07283EB5F8B3605923A2D06B", hash_generated_method = "4D7EE8D99B0F8E590BE5A4BC660ECD34")
    public  X9ECParameters(
        ASN1Sequence  seq) {
        {
            boolean var96CD03E362CB7FBCC40B4D2C4C17A3C2_37132431 = (!(seq.getObjectAt(0) instanceof DERInteger)
           || !((DERInteger)seq.getObjectAt(0)).getValue().equals(ONE));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("bad version in X9ECParameters");
            } 
        } 
        X9Curve x9c = new X9Curve(
                        new X9FieldID((ASN1Sequence)seq.getObjectAt(1)),
                        (ASN1Sequence)seq.getObjectAt(2));
        this.curve = x9c.getCurve();
        this.g = new X9ECPoint(curve, (ASN1OctetString)seq.getObjectAt(3)).getPoint();
        this.n = ((DERInteger)seq.getObjectAt(4)).getValue();
        this.seed = x9c.getSeed();
        {
            boolean var137928E29A9DE0EA9CAE203D397A260C_1302497395 = (seq.size() == 6);
            {
                this.h = ((DERInteger)seq.getObjectAt(5)).getValue();
            } 
        } 
        
        
           
        
            
        
        
                        
                        
        
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.433 -0400", hash_original_method = "739112175432B7FC1F3897612DAEA859", hash_generated_method = "A8E0CA538FADA9FFA24D47C15AF9AB06")
    public  X9ECParameters(
        ECCurve     curve,
        ECPoint     g,
        BigInteger  n) {
        this(curve, g, n, ONE, null);
        addTaint(curve.getTaint());
        addTaint(g.getTaint());
        addTaint(n.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.434 -0400", hash_original_method = "7F13F9D9B68D09FF2E2DEF2F93290D05", hash_generated_method = "07D3CF5A8B654BAB698288AA5A0C5979")
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
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.434 -0400", hash_original_method = "1843E539ACF8FE39D46257BC325E0DC6", hash_generated_method = "97B8849D34F9E7B2023F0E1A44474F64")
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
        } 
        {
            {
                ECCurve.F2m curveF2m = (ECCurve.F2m)curve;
                this.fieldID = new X9FieldID(curveF2m.getM(), curveF2m.getK1(),
                    curveF2m.getK2(), curveF2m.getK3());
            } 
        } 
        
        
        
        
        
        
        
        
            
        
        
        
            
            
                
                
                    
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.435 -0400", hash_original_method = "C3733AEA1B7056ED3896C5DBEA3E645D", hash_generated_method = "37E1216193B105FD71664655DD8DCB65")
    public ECCurve getCurve() {
        ECCurve varB4EAC82CA7396A68D541C85D26508E83_1634885025 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1634885025 = curve;
        varB4EAC82CA7396A68D541C85D26508E83_1634885025.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1634885025;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.435 -0400", hash_original_method = "F49644298FFD38F2CFD5B0D378F29102", hash_generated_method = "50335F5D02028625DC0E2CD5953882F2")
    public ECPoint getG() {
        ECPoint varB4EAC82CA7396A68D541C85D26508E83_698382514 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_698382514 = g;
        varB4EAC82CA7396A68D541C85D26508E83_698382514.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_698382514;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.435 -0400", hash_original_method = "30674A850FAA3528D3976F32A0E4EE43", hash_generated_method = "07ED9D64183108635E070AA5AA9BB3AD")
    public BigInteger getN() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1664045136 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1664045136 = n;
        varB4EAC82CA7396A68D541C85D26508E83_1664045136.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1664045136;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.436 -0400", hash_original_method = "9DE3987FDD4335D5C0BE76F667E07DA1", hash_generated_method = "93FA0D40577CAFBBD6049C243F20592A")
    public BigInteger getH() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_329065643 = null; 
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1984779527 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_329065643 = ONE;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1984779527 = h;
        BigInteger varA7E53CE21691AB073D9660D615818899_1782200563; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1782200563 = varB4EAC82CA7396A68D541C85D26508E83_329065643;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1782200563 = varB4EAC82CA7396A68D541C85D26508E83_1984779527;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1782200563.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1782200563;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.436 -0400", hash_original_method = "B051A8408593F9E1275AB818DE8E2A80", hash_generated_method = "B8CF73F6B0226E3C034BBF19E9BDE10C")
    public byte[] getSeed() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1478852809 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1478852809;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.437 -0400", hash_original_method = "8FEF0683FB02574D7DCECBAD72741893", hash_generated_method = "122D2A57BD48752E6B9E7FE7612F135A")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_2064533938 = null; 
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(new DERInteger(1));
        v.add(fieldID);
        v.add(new X9Curve(curve, seed));
        v.add(new X9ECPoint(g));
        v.add(new DERInteger(n));
        {
            v.add(new DERInteger(h));
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2064533938 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_2064533938.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2064533938;
        
        
        
        
        
        
        
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.437 -0400", hash_original_field = "ADD10266D801BA1050DC92ABCE3C6C53", hash_generated_field = "A2EFE0CE5423F8076AF20D5B76F7D97A")

    private static final BigInteger ONE = BigInteger.valueOf(1);
}

