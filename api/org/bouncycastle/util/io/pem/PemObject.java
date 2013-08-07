package org.bouncycastle.util.io.pem;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;






public class PemObject implements PemObjectGenerator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.390 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private String type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.390 -0400", hash_original_field = "4340FD73E75DF7A9D9E45902A59BA3A4", hash_generated_field = "144EBE63A318E4E8C50ABA547D9431E1")

    private List headers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.390 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "2AFA79670796B1E0B73AB75D7B8465D5")

    private byte[] content;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.390 -0400", hash_original_method = "E8E4F9BE36AC2F3679718F77E354BD1D", hash_generated_method = "CFDBF7148C6995D0368428C328349840")
    public  PemObject(String type, byte[] content) {
        this(type, EMPTY_LIST, content);
        addTaint(content[0]);
        addTaint(type.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.392 -0400", hash_original_method = "A9F012093AAD72893A58BFC7BE174583", hash_generated_method = "56CA7597FDF3C3B709648C340A79F765")
    public  PemObject(String type, List headers, byte[] content) {
        this.type = type;
        this.headers = Collections.unmodifiableList(headers);
        this.content = content;
        // ---------- Original Method ----------
        //this.type = type;
        //this.headers = Collections.unmodifiableList(headers);
        //this.content = content;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.392 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "968C75D91DCF7C624102FF452C035513")
    public String getType() {
String varC5B9F25B4EEAD3E8E2C33F9429204397_2062847992 =         type;
        varC5B9F25B4EEAD3E8E2C33F9429204397_2062847992.addTaint(taint);
        return varC5B9F25B4EEAD3E8E2C33F9429204397_2062847992;
        // ---------- Original Method ----------
        //return type;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.392 -0400", hash_original_method = "7A0337E547AB2E290525371E494B1A30", hash_generated_method = "F6C7C4DE5DDD1AED456AB16D7EDF8C07")
    public List getHeaders() {
List var6937E37BAD8D53F9D49A0E32C69A3A2C_1672655285 =         headers;
        var6937E37BAD8D53F9D49A0E32C69A3A2C_1672655285.addTaint(taint);
        return var6937E37BAD8D53F9D49A0E32C69A3A2C_1672655285;
        // ---------- Original Method ----------
        //return headers;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.393 -0400", hash_original_method = "CA0902D8AF35560815DA28546D2C787A", hash_generated_method = "0394888A0FE62E6EFADF9B49EA9D834B")
    public byte[] getContent() {
        byte[] var9A0364B9E99BB480DD25E1F0284C8555_1763672806 = (content);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_69146576 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_69146576;
        // ---------- Original Method ----------
        //return content;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.393 -0400", hash_original_method = "E898D78DBFB1F3FB89A6D402FC0A6D27", hash_generated_method = "90EBBCD5C47392064EB4E79AD054F959")
    public PemObject generate() throws PemGenerationException {
PemObject var72A74007B2BE62B849F475C7BDA4658B_641700577 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_641700577.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_641700577;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.393 -0400", hash_original_field = "5D4B6FC0D382A15BAE3F1DA051A09980", hash_generated_field = "4F4BAD0CB2525EB0C5709334AA057CD9")

    private static final List EMPTY_LIST = Collections.unmodifiableList(new ArrayList());
}

