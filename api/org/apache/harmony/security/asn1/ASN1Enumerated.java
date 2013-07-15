package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.util.Arrays;

public final class ASN1Enumerated extends ASN1Primitive {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.563 -0400", hash_original_method = "AA03F41F75612EB5366E32BDDDAEA1AC", hash_generated_method = "11C6DEF098A19B58952BF9C0E3E54B4B")
    public  ASN1Enumerated() {
        super(TAG_ENUM);
        // ---------- Original Method ----------
    }

    
        public static ASN1Enumerated getInstance() {
        return ASN1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.563 -0400", hash_original_method = "810B1EC4B5D81C8B87770AF406E0EFF5", hash_generated_method = "0A3371AC82EE35498F8C3A0B9B5DA1A5")
    public Object decode(BerInputStream in) throws IOException {
        addTaint(in.getTaint());
        in.readEnumerated();
    if(in.isVerify)        
        {
Object var540C13E9E156B687226421B24F2DF178_1770551726 =             null;
            var540C13E9E156B687226421B24F2DF178_1770551726.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1770551726;
        } //End block
Object var6AD043AF0280111F31D0D60A6CD70863_1178104153 =         getDecodedObject(in);
        var6AD043AF0280111F31D0D60A6CD70863_1178104153.addTaint(taint);
        return var6AD043AF0280111F31D0D60A6CD70863_1178104153;
        // ---------- Original Method ----------
        //in.readEnumerated();
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.564 -0400", hash_original_method = "82D4C6A7EA2B5E6BF0228FD44BF29A31", hash_generated_method = "A52B7602DEE4C67E5A8CEB0EB571427F")
    public Object getDecodedObject(BerInputStream in) throws IOException {
        addTaint(in.getTaint());
Object var799D9F18AD20BC40A384FA5E7CC005DE_2076221912 =         Arrays.copyOfRange(in.buffer, in.contentOffset, in.contentOffset + in.length);
        var799D9F18AD20BC40A384FA5E7CC005DE_2076221912.addTaint(taint);
        return var799D9F18AD20BC40A384FA5E7CC005DE_2076221912;
        // ---------- Original Method ----------
        //return Arrays.copyOfRange(in.buffer, in.contentOffset, in.contentOffset + in.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.569 -0400", hash_original_method = "8972E72D5FACAB6282BB97DA2EB5021B", hash_generated_method = "F49D576287ACA2BF4FA8640DE6F6151F")
    public void encodeContent(BerOutputStream out) {
        addTaint(out.getTaint());
        out.encodeInteger();
        // ---------- Original Method ----------
        //out.encodeInteger();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.569 -0400", hash_original_method = "9FE1E04620BBFE07A0C8F71EADD10582", hash_generated_method = "CF6C0D89125D265A070FAEF45137B38D")
    public void setEncodingContent(BerOutputStream out) {
        addTaint(out.getTaint());
        out.length = ((byte[]) out.content).length;
        // ---------- Original Method ----------
        //out.length = ((byte[]) out.content).length;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.569 -0400", hash_original_field = "19E9747C25CFD9985C0EA6DB9F3FBE5D", hash_generated_field = "E1CAA2576C780B35F20FCEF265B3C62C")

    private static final ASN1Enumerated ASN1 = new ASN1Enumerated();
}

