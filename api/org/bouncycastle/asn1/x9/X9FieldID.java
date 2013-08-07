package org.bouncycastle.asn1.x9;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.math.BigInteger;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;






public class X9FieldID extends ASN1Encodable implements X9ObjectIdentifiers {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.391 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "C9026F3AA6576B332E83AF850E791F56")

    private DERObjectIdentifier id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.391 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "1557C13CB9AB38DEB6A065C70AD2F74E")

    private DERObject parameters;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.392 -0400", hash_original_method = "947D632CD3BB9C70FFB74606AF4AA65C", hash_generated_method = "336E537F452F8D6FB7E3AC232B57761F")
    public  X9FieldID(BigInteger primeP) {
        this.id = prime_field;
        this.parameters = new DERInteger(primeP);
        // ---------- Original Method ----------
        //this.id = prime_field;
        //this.parameters = new DERInteger(primeP);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.393 -0400", hash_original_method = "E68F2B5FEB9AA2D283212DC970B04168", hash_generated_method = "E74A148C6CB0FA6E4FC5EDC4BB523A7D")
    public  X9FieldID(int m, int k1, int k2, int k3) {
        addTaint(k3);
        addTaint(k2);
        addTaint(k1);
        addTaint(m);
        this.id = characteristic_two_field;
        ASN1EncodableVector fieldIdParams = new ASN1EncodableVector();
        fieldIdParams.add(new DERInteger(m));
        if(k2 == 0)        
        {
            fieldIdParams.add(tpBasis);
            fieldIdParams.add(new DERInteger(k1));
        } //End block
        else
        {
            fieldIdParams.add(ppBasis);
            ASN1EncodableVector pentanomialParams = new ASN1EncodableVector();
            pentanomialParams.add(new DERInteger(k1));
            pentanomialParams.add(new DERInteger(k2));
            pentanomialParams.add(new DERInteger(k3));
            fieldIdParams.add(new DERSequence(pentanomialParams));
        } //End block
        this.parameters = new DERSequence(fieldIdParams);
        // ---------- Original Method ----------
        //this.id = characteristic_two_field;
        //ASN1EncodableVector fieldIdParams = new ASN1EncodableVector();
        //fieldIdParams.add(new DERInteger(m));
        //if (k2 == 0) 
        //{
            //fieldIdParams.add(tpBasis);
            //fieldIdParams.add(new DERInteger(k1));
        //} 
        //else 
        //{
            //fieldIdParams.add(ppBasis);
            //ASN1EncodableVector pentanomialParams = new ASN1EncodableVector();
            //pentanomialParams.add(new DERInteger(k1));
            //pentanomialParams.add(new DERInteger(k2));
            //pentanomialParams.add(new DERInteger(k3));
            //fieldIdParams.add(new DERSequence(pentanomialParams));
        //}
        //this.parameters = new DERSequence(fieldIdParams);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.395 -0400", hash_original_method = "DE0F1786B89D9192DA26A23CD26B072E", hash_generated_method = "EC736FBE556FC79705AF65DDF77AD0A8")
    public  X9FieldID(
        ASN1Sequence  seq) {
        this.id = (DERObjectIdentifier)seq.getObjectAt(0);
        this.parameters = (DERObject)seq.getObjectAt(1);
        // ---------- Original Method ----------
        //this.id = (DERObjectIdentifier)seq.getObjectAt(0);
        //this.parameters = (DERObject)seq.getObjectAt(1);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.396 -0400", hash_original_method = "A03C04E1D63CA4FFA1D88D7678177C2A", hash_generated_method = "386CCBD56172426CFCD61CAD29C037AB")
    public DERObjectIdentifier getIdentifier() {
DERObjectIdentifier var6481E79D4B9F990E7C69C0523E4A3DFE_1494128526 =         id;
        var6481E79D4B9F990E7C69C0523E4A3DFE_1494128526.addTaint(taint);
        return var6481E79D4B9F990E7C69C0523E4A3DFE_1494128526;
        // ---------- Original Method ----------
        //return id;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.396 -0400", hash_original_method = "1898F00B5F10CC32C939404F88AE77E4", hash_generated_method = "0C5CA807296C0E372081D99F0B7B6EFA")
    public DERObject getParameters() {
DERObject var3CB0A38B794BDEDADB1F50256E0AE35B_1343068721 =         parameters;
        var3CB0A38B794BDEDADB1F50256E0AE35B_1343068721.addTaint(taint);
        return var3CB0A38B794BDEDADB1F50256E0AE35B_1343068721;
        // ---------- Original Method ----------
        //return parameters;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.397 -0400", hash_original_method = "F64CE532B89E0DF8480CF348DC73F510", hash_generated_method = "86824CFF5AEC64C4441AEBFE87EDC51A")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(this.id);
        v.add(this.parameters);
DERObject var0B338F106E3279986C87B595B0F4A439_349141530 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_349141530.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_349141530;
        // ---------- Original Method ----------
        //ASN1EncodableVector v = new ASN1EncodableVector();
        //v.add(this.id);
        //v.add(this.parameters);
        //return new DERSequence(v);
    }

    
}

