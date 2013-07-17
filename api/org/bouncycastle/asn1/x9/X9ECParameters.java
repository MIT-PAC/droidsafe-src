package org.bouncycastle.asn1.x9;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.342 -0400", hash_original_field = "D87F5109F111FEC49B0D2349C971D42D", hash_generated_field = "161E0CD2A331703CED55991AA7670409")

    private X9FieldID fieldID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.343 -0400", hash_original_field = "4EFA264F5EF3E1A5C95736E07544EBF0", hash_generated_field = "D4FD3D236F6822F3201F264EA949068E")

    private ECCurve curve;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.343 -0400", hash_original_field = "B2F5FF47436671B6E533D8DC3614845D", hash_generated_field = "1F461AF19CABD1B00959F9F3AD8297A2")

    private ECPoint g;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.343 -0400", hash_original_field = "7B8B965AD4BCA0E41AB51DE7B31363A1", hash_generated_field = "28997BC83DA18A620109895922F10617")

    private BigInteger n;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.343 -0400", hash_original_field = "2510C39011C5BE704182423E3A695E91", hash_generated_field = "2BC612FFF03C8C6BFD81D1617A7F7383")

    private BigInteger h;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.343 -0400", hash_original_field = "FE4C0F30AA359C41D9F9A5F69C8C4192", hash_generated_field = "84A0CB03E1AA0B2A11E3988D98BBE452")

    private byte[] seed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.345 -0400", hash_original_method = "38D6105F07283EB5F8B3605923A2D06B", hash_generated_method = "881DE6A87710177125792979883E8786")
    public  X9ECParameters(
        ASN1Sequence  seq) {
        if(!(seq.getObjectAt(0) instanceof DERInteger)
           || !((DERInteger)seq.getObjectAt(0)).getValue().equals(ONE))        
        {
            IllegalArgumentException var45F0FAE8DF83E31016D229CCBF4B1E0F_1194636228 = new IllegalArgumentException("bad version in X9ECParameters");
            var45F0FAE8DF83E31016D229CCBF4B1E0F_1194636228.addTaint(taint);
            throw var45F0FAE8DF83E31016D229CCBF4B1E0F_1194636228;
        } //End block
        X9Curve x9c = new X9Curve(
                        new X9FieldID((ASN1Sequence)seq.getObjectAt(1)),
                        (ASN1Sequence)seq.getObjectAt(2));
        this.curve = x9c.getCurve();
        this.g = new X9ECPoint(curve, (ASN1OctetString)seq.getObjectAt(3)).getPoint();
        this.n = ((DERInteger)seq.getObjectAt(4)).getValue();
        this.seed = x9c.getSeed();
        if(seq.size() == 6)        
        {
            this.h = ((DERInteger)seq.getObjectAt(5)).getValue();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.347 -0400", hash_original_method = "739112175432B7FC1F3897612DAEA859", hash_generated_method = "0F944A9E4DC39D01B3DB0F036F433885")
    public  X9ECParameters(
        ECCurve     curve,
        ECPoint     g,
        BigInteger  n) {
        this(curve, g, n, ONE, null);
        addTaint(n.getTaint());
        addTaint(g.getTaint());
        addTaint(curve.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.347 -0400", hash_original_method = "7F13F9D9B68D09FF2E2DEF2F93290D05", hash_generated_method = "6CEEC71B8EF9947BA1AC6A4755291D53")
    public  X9ECParameters(
        ECCurve     curve,
        ECPoint     g,
        BigInteger  n,
        BigInteger  h) {
        this(curve, g, n, h, null);
        addTaint(h.getTaint());
        addTaint(n.getTaint());
        addTaint(g.getTaint());
        addTaint(curve.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.349 -0400", hash_original_method = "1843E539ACF8FE39D46257BC325E0DC6", hash_generated_method = "A39EF16D26FE302B8F67ECD0C233F5FD")
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
        if(curve instanceof ECCurve.Fp)        
        {
            this.fieldID = new X9FieldID(((ECCurve.Fp)curve).getQ());
        } //End block
        else
        {
            if(curve instanceof ECCurve.F2m)            
            {
                ECCurve.F2m curveF2m = (ECCurve.F2m)curve;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.349 -0400", hash_original_method = "C3733AEA1B7056ED3896C5DBEA3E645D", hash_generated_method = "0973760B241267A416E48FB58AF88C47")
    public ECCurve getCurve() {
ECCurve varCB08C04A7A1DB77E60E6F93B4C766067_389755728 =         curve;
        varCB08C04A7A1DB77E60E6F93B4C766067_389755728.addTaint(taint);
        return varCB08C04A7A1DB77E60E6F93B4C766067_389755728;
        // ---------- Original Method ----------
        //return curve;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.349 -0400", hash_original_method = "F49644298FFD38F2CFD5B0D378F29102", hash_generated_method = "5C38DCEC8094205FDADAE0BA7B29E594")
    public ECPoint getG() {
ECPoint var96B5EDC7D356FCBAF3C926D8A70305DA_189680800 =         g;
        var96B5EDC7D356FCBAF3C926D8A70305DA_189680800.addTaint(taint);
        return var96B5EDC7D356FCBAF3C926D8A70305DA_189680800;
        // ---------- Original Method ----------
        //return g;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.350 -0400", hash_original_method = "30674A850FAA3528D3976F32A0E4EE43", hash_generated_method = "33EDE4674070006A651051977860548F")
    public BigInteger getN() {
BigInteger var041154653C812B0D1663EC287BE4C757_1073329663 =         n;
        var041154653C812B0D1663EC287BE4C757_1073329663.addTaint(taint);
        return var041154653C812B0D1663EC287BE4C757_1073329663;
        // ---------- Original Method ----------
        //return n;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.350 -0400", hash_original_method = "9DE3987FDD4335D5C0BE76F667E07DA1", hash_generated_method = "E2CD3AF67A21B205BA4A0D332E7FC438")
    public BigInteger getH() {
        if(h == null)        
        {
BigInteger varBAE09D6A693103980CCD98582008583B_536377587 =             ONE;
            varBAE09D6A693103980CCD98582008583B_536377587.addTaint(taint);
            return varBAE09D6A693103980CCD98582008583B_536377587;
        } //End block
BigInteger var81CECAAA363C2B26C476DE4A79F58961_1136126032 =         h;
        var81CECAAA363C2B26C476DE4A79F58961_1136126032.addTaint(taint);
        return var81CECAAA363C2B26C476DE4A79F58961_1136126032;
        // ---------- Original Method ----------
        //if (h == null)
        //{
            //return ONE;        
        //}
        //return h;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.350 -0400", hash_original_method = "B051A8408593F9E1275AB818DE8E2A80", hash_generated_method = "D557D03A857BF9959FFB79A6A77C9C5B")
    public byte[] getSeed() {
        byte[] varFE4C0F30AA359C41D9F9A5F69C8C4192_296891158 = (seed);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_519267437 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_519267437;
        // ---------- Original Method ----------
        //return seed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.351 -0400", hash_original_method = "8FEF0683FB02574D7DCECBAD72741893", hash_generated_method = "C98C89887BC528CA6CC936131500FC0A")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(new DERInteger(1));
        v.add(fieldID);
        v.add(new X9Curve(curve, seed));
        v.add(new X9ECPoint(g));
        v.add(new DERInteger(n));
        if(h != null)        
        {
            v.add(new DERInteger(h));
        } //End block
DERObject var0B338F106E3279986C87B595B0F4A439_1985138879 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_1985138879.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_1985138879;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.351 -0400", hash_original_field = "ADD10266D801BA1050DC92ABCE3C6C53", hash_generated_field = "A2EFE0CE5423F8076AF20D5B76F7D97A")

    private static final BigInteger ONE = BigInteger.valueOf(1);
}

