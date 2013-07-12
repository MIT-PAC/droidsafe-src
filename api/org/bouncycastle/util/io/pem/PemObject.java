package org.bouncycastle.util.io.pem;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PemObject implements PemObjectGenerator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.597 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private String type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.597 -0400", hash_original_field = "4340FD73E75DF7A9D9E45902A59BA3A4", hash_generated_field = "144EBE63A318E4E8C50ABA547D9431E1")

    private List headers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.597 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "2AFA79670796B1E0B73AB75D7B8465D5")

    private byte[] content;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.598 -0400", hash_original_method = "E8E4F9BE36AC2F3679718F77E354BD1D", hash_generated_method = "CFDBF7148C6995D0368428C328349840")
    public  PemObject(String type, byte[] content) {
        this(type, EMPTY_LIST, content);
        addTaint(content[0]);
        addTaint(type.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.600 -0400", hash_original_method = "A9F012093AAD72893A58BFC7BE174583", hash_generated_method = "56CA7597FDF3C3B709648C340A79F765")
    public  PemObject(String type, List headers, byte[] content) {
        this.type = type;
        this.headers = Collections.unmodifiableList(headers);
        this.content = content;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.601 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "DE53AADD1C0871336C82286CE91AAE4A")
    public String getType() {
String varC5B9F25B4EEAD3E8E2C33F9429204397_1160772257 =         type;
        varC5B9F25B4EEAD3E8E2C33F9429204397_1160772257.addTaint(taint);
        return varC5B9F25B4EEAD3E8E2C33F9429204397_1160772257;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.601 -0400", hash_original_method = "7A0337E547AB2E290525371E494B1A30", hash_generated_method = "5C7A4C410CBEE3551B6C5EFD02E4F055")
    public List getHeaders() {
List var6937E37BAD8D53F9D49A0E32C69A3A2C_435252671 =         headers;
        var6937E37BAD8D53F9D49A0E32C69A3A2C_435252671.addTaint(taint);
        return var6937E37BAD8D53F9D49A0E32C69A3A2C_435252671;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.602 -0400", hash_original_method = "CA0902D8AF35560815DA28546D2C787A", hash_generated_method = "6179918FA9E11ABFC41585ABB5A06BF4")
    public byte[] getContent() {
        byte[] var9A0364B9E99BB480DD25E1F0284C8555_889661428 = (content);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1118856297 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1118856297;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.602 -0400", hash_original_method = "E898D78DBFB1F3FB89A6D402FC0A6D27", hash_generated_method = "82FF109258695413BCE82521B48D02E9")
    public PemObject generate() throws PemGenerationException {
PemObject var72A74007B2BE62B849F475C7BDA4658B_1332825588 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1332825588.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1332825588;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.603 -0400", hash_original_field = "5D4B6FC0D382A15BAE3F1DA051A09980", hash_generated_field = "4F4BAD0CB2525EB0C5709334AA057CD9")

    private static final List EMPTY_LIST = Collections.unmodifiableList(new ArrayList());
}

