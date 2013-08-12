package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.math.BigInteger;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;




public class PBEParameter extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.960 -0400", hash_original_field = "471DACEA75A62298F21BD08196E91EF6", hash_generated_field = "78F9CF53C7E0D6433DD6CC8969049302")

    DERInteger iterations;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.960 -0400", hash_original_field = "CEB20772E0C9D240C75EB26B0E37ABEE", hash_generated_field = "83822DE1D48BD51F36389108E6B20D1C")

    ASN1OctetString salt;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.961 -0400", hash_original_method = "F7EDA5A89282A21C4F04920900A9B0E0", hash_generated_method = "17399259B6DE547A1349F81119817C26")
    public  PBEParameter(
        byte[]      salt,
        int         iterations) {
        if(salt.length != 8)        
        {
            IllegalArgumentException var506BB451BC97752FE0609B8A8667B7EC_1756283763 = new IllegalArgumentException("salt length must be 8");
            var506BB451BC97752FE0609B8A8667B7EC_1756283763.addTaint(taint);
            throw var506BB451BC97752FE0609B8A8667B7EC_1756283763;
        } //End block
        this.salt = new DEROctetString(salt);
        this.iterations = new DERInteger(iterations);
        // ---------- Original Method ----------
        //if (salt.length != 8)
        //{
            //throw new IllegalArgumentException("salt length must be 8");
        //}
        //this.salt = new DEROctetString(salt);
        //this.iterations = new DERInteger(iterations);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.962 -0400", hash_original_method = "8CC750B4C495B3704F501666A3EEDBD9", hash_generated_method = "26541D40AC632625B229A9B94A06658B")
    public  PBEParameter(
        ASN1Sequence  seq) {
        salt = (ASN1OctetString)seq.getObjectAt(0);
        iterations = (DERInteger)seq.getObjectAt(1);
        // ---------- Original Method ----------
        //salt = (ASN1OctetString)seq.getObjectAt(0);
        //iterations = (DERInteger)seq.getObjectAt(1);
    }

    
    @DSModeled(DSC.SAFE)
    public static PBEParameter getInstance(
        Object  obj) {
        if (obj instanceof PBEParameter)
        {
            return (PBEParameter)obj;
        }
        else if (obj instanceof ASN1Sequence)
        {
            return new PBEParameter((ASN1Sequence)obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.963 -0400", hash_original_method = "12A862718040CD6821608ED594311F7C", hash_generated_method = "81EDAE5B588F8A4C2DCC7ADA5EE1F5AE")
    public BigInteger getIterationCount() {
BigInteger var8563E23A7E89A15DC1621E7AA8EF0C9E_210620194 =         iterations.getValue();
        var8563E23A7E89A15DC1621E7AA8EF0C9E_210620194.addTaint(taint);
        return var8563E23A7E89A15DC1621E7AA8EF0C9E_210620194;
        // ---------- Original Method ----------
        //return iterations.getValue();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.964 -0400", hash_original_method = "54CCD4EF015960D2546AD9BCFDF4FA17", hash_generated_method = "2C1668F091268D758A934C4783AFA2EA")
    public byte[] getSalt() {
        byte[] var3B49B46E31C5F6502835BFC79B7BB43D_370262964 = (salt.getOctets());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_937694175 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_937694175;
        // ---------- Original Method ----------
        //return salt.getOctets();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.964 -0400", hash_original_method = "0DB5FC3A2AA27196084301AD64A15FCF", hash_generated_method = "30D5993EB78B746951D68CCBF1D34FAD")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(salt);
        v.add(iterations);
DERObject var0B338F106E3279986C87B595B0F4A439_2123550273 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_2123550273.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_2123550273;
        // ---------- Original Method ----------
        //ASN1EncodableVector  v = new ASN1EncodableVector();
        //v.add(salt);
        //v.add(iterations);
        //return new DERSequence(v);
    }

    
}

