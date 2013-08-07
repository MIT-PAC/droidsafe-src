package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.math.BigInteger;

import org.apache.harmony.security.asn1.ASN1Integer;






public final class InhibitAnyPolicy extends ExtensionValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.417 -0400", hash_original_field = "0CD883677A360FE36D329FE6AA5778AB", hash_generated_field = "34CEC7EBF0D69FDD5ECCA6C7F25F7FAF")

    private int skipCerts;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.418 -0400", hash_original_method = "1933FA0EC9823F8DA6E27E5F5995EEC8", hash_generated_method = "467922954530EACCB586AEDF82EDDCC3")
    public  InhibitAnyPolicy(byte[] encoding) throws IOException {
        super(encoding);
        this.skipCerts = new BigInteger((byte[])
                ASN1Integer.getInstance().decode(encoding)).intValue();
        // ---------- Original Method ----------
        //this.skipCerts = new BigInteger((byte[])
                //ASN1Integer.getInstance().decode(encoding)).intValue();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.419 -0400", hash_original_method = "3EBD51C43A05A1E4C8002DD6E78AE310", hash_generated_method = "D1C6A736BB45F56C0887D22D935D71DE")
    @Override
    public byte[] getEncoded() {
        if(encoding == null)        
        {
            encoding = ASN1Integer.getInstance()
                .encode(ASN1Integer.fromIntValue(skipCerts));
        } //End block
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_455441725 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2113609259 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2113609259;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1Integer.getInstance()
                //.encode(ASN1Integer.fromIntValue(skipCerts));
        //}
        //return encoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.420 -0400", hash_original_method = "25B8E258E2717A4BB370159BACC96911", hash_generated_method = "90318AB1054F99DE94AA2CF5B6CBAB6C")
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(sb.getTaint());
        sb.append(prefix).append("Inhibit Any-Policy: ").append(skipCerts).append('\n');
        // ---------- Original Method ----------
        //sb.append(prefix).append("Inhibit Any-Policy: ").append(skipCerts).append('\n');
    }

    
}

