package org.bouncycastle.jce.spec;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.bouncycastle.math.ec.ECPoint;






public class ECPublicKeySpec extends ECKeySpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.741 -0400", hash_original_field = "7694F4A66316E53C8CDD9D9954BD611D", hash_generated_field = "190FD5BD9908F6C1ABFEFC9764DEAE12")

    private ECPoint q;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.741 -0400", hash_original_method = "1E18973C74B180C46739C7EAE31BBB7B", hash_generated_method = "E690FA0806CF3BAADEFF6E883C4AF48A")
    public  ECPublicKeySpec(
        ECPoint         q,
        ECParameterSpec spec) {
        super(spec);
        addTaint(spec.getTaint());
        this.q = q;
        // ---------- Original Method ----------
        //this.q = q;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.741 -0400", hash_original_method = "A7464FB9BEF133E2EB393CD87C3AFDA4", hash_generated_method = "84261B964FFB9F4EB25C7B7F8A74864A")
    public ECPoint getQ() {
ECPoint varBEF1B7662E10AF6D5747729987514CB6_1402204828 =         q;
        varBEF1B7662E10AF6D5747729987514CB6_1402204828.addTaint(taint);
        return varBEF1B7662E10AF6D5747729987514CB6_1402204828;
        // ---------- Original Method ----------
        //return q;
    }

    
}

