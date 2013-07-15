package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;

public class PKCS12PBEParams extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.419 -0400", hash_original_field = "471DACEA75A62298F21BD08196E91EF6", hash_generated_field = "78F9CF53C7E0D6433DD6CC8969049302")

    DERInteger iterations;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.419 -0400", hash_original_field = "F0B53B2DA041FCA49EF0B9839060B345", hash_generated_field = "B25868518F07845AA04DDD7C4143C484")

    ASN1OctetString iv;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.420 -0400", hash_original_method = "386E04A4D9F1D93ADFE74A748112E74F", hash_generated_method = "236C997E4CCCD6DA28CBD027E375EF3D")
    public  PKCS12PBEParams(
        byte[]      salt,
        int         iterations) {
        this.iv = new DEROctetString(salt);
        this.iterations = new DERInteger(iterations);
        // ---------- Original Method ----------
        //this.iv = new DEROctetString(salt);
        //this.iterations = new DERInteger(iterations);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.420 -0400", hash_original_method = "9796F53576903CCA620F278DD161E921", hash_generated_method = "80A99104574C0F2DF3F2C510241123DF")
    public  PKCS12PBEParams(
        ASN1Sequence  seq) {
        iv = (ASN1OctetString)seq.getObjectAt(0);
        iterations = (DERInteger)seq.getObjectAt(1);
        // ---------- Original Method ----------
        //iv = (ASN1OctetString)seq.getObjectAt(0);
        //iterations = (DERInteger)seq.getObjectAt(1);
    }

    
        @DSModeled(DSC.SPEC)
    public static PKCS12PBEParams getInstance(
        Object  obj) {
        if (obj instanceof PKCS12PBEParams)
        {
            return (PKCS12PBEParams)obj;
        }
        else if (obj instanceof ASN1Sequence)
        {
            return new PKCS12PBEParams((ASN1Sequence)obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.420 -0400", hash_original_method = "DD1CD350639FBEA94B58D8C0FBFF69DE", hash_generated_method = "4634A87CFB66CB388AB55EBD69AB856D")
    public BigInteger getIterations() {
BigInteger var8563E23A7E89A15DC1621E7AA8EF0C9E_1949727658 =         iterations.getValue();
        var8563E23A7E89A15DC1621E7AA8EF0C9E_1949727658.addTaint(taint);
        return var8563E23A7E89A15DC1621E7AA8EF0C9E_1949727658;
        // ---------- Original Method ----------
        //return iterations.getValue();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.421 -0400", hash_original_method = "ABC6C1F7D45D0FDDF94BEAE70F71F0ED", hash_generated_method = "249BCFE79A3C1AC97C86295472ABF08D")
    public byte[] getIV() {
        byte[] var88FF68BFEDD92B2F4319637028DD4A35_89481037 = (iv.getOctets());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_95221355 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_95221355;
        // ---------- Original Method ----------
        //return iv.getOctets();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.421 -0400", hash_original_method = "08D9069F477C4E4688BE524F0F9F7EEF", hash_generated_method = "B39C69C530AF9A0695A73BB29BFAD552")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(iv);
        v.add(iterations);
DERObject var0B338F106E3279986C87B595B0F4A439_173114027 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_173114027.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_173114027;
        // ---------- Original Method ----------
        //ASN1EncodableVector  v = new ASN1EncodableVector();
        //v.add(iv);
        //v.add(iterations);
        //return new DERSequence(v);
    }

    
}

