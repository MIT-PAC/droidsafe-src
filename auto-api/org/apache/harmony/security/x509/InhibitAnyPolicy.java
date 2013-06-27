package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.math.BigInteger;
import org.apache.harmony.security.asn1.ASN1Integer;

public final class InhibitAnyPolicy extends ExtensionValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.972 -0400", hash_original_field = "0CD883677A360FE36D329FE6AA5778AB", hash_generated_field = "34CEC7EBF0D69FDD5ECCA6C7F25F7FAF")

    private int skipCerts;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.973 -0400", hash_original_method = "1933FA0EC9823F8DA6E27E5F5995EEC8", hash_generated_method = "467922954530EACCB586AEDF82EDDCC3")
    public  InhibitAnyPolicy(byte[] encoding) throws IOException {
        super(encoding);
        this.skipCerts = new BigInteger((byte[])
                ASN1Integer.getInstance().decode(encoding)).intValue();
        // ---------- Original Method ----------
        //this.skipCerts = new BigInteger((byte[])
                //ASN1Integer.getInstance().decode(encoding)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.973 -0400", hash_original_method = "3EBD51C43A05A1E4C8002DD6E78AE310", hash_generated_method = "196F4364FBF2397455A01C596C8ED2E7")
    @Override
    public byte[] getEncoded() {
        {
            encoding = ASN1Integer.getInstance()
                .encode(ASN1Integer.fromIntValue(skipCerts));
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1885936173 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1885936173;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1Integer.getInstance()
                //.encode(ASN1Integer.fromIntValue(skipCerts));
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.978 -0400", hash_original_method = "25B8E258E2717A4BB370159BACC96911", hash_generated_method = "AF858BEAF003225EBF3AECEAC9C6DC5E")
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("Inhibit Any-Policy: ").append(skipCerts).append('\n');
        addTaint(sb.getTaint());
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
        //sb.append(prefix).append("Inhibit Any-Policy: ").append(skipCerts).append('\n');
    }

    
}

