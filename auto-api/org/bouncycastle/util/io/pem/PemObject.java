package org.bouncycastle.util.io.pem;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PemObject implements PemObjectGenerator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.931 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private String type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.931 -0400", hash_original_field = "4340FD73E75DF7A9D9E45902A59BA3A4", hash_generated_field = "144EBE63A318E4E8C50ABA547D9431E1")

    private List headers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.931 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "2AFA79670796B1E0B73AB75D7B8465D5")

    private byte[] content;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.931 -0400", hash_original_method = "E8E4F9BE36AC2F3679718F77E354BD1D", hash_generated_method = "B14EFFAD78A4A74F863F66794B97F24A")
    public  PemObject(String type, byte[] content) {
        this(type, EMPTY_LIST, content);
        addTaint(type.getTaint());
        addTaint(content[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.932 -0400", hash_original_method = "A9F012093AAD72893A58BFC7BE174583", hash_generated_method = "56CA7597FDF3C3B709648C340A79F765")
    public  PemObject(String type, List headers, byte[] content) {
        this.type = type;
        this.headers = Collections.unmodifiableList(headers);
        this.content = content;
        // ---------- Original Method ----------
        //this.type = type;
        //this.headers = Collections.unmodifiableList(headers);
        //this.content = content;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.932 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "B675B99126A5E1C3F5B9BFEB30501B62")
    public String getType() {
        String varB4EAC82CA7396A68D541C85D26508E83_677249996 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_677249996 = type;
        varB4EAC82CA7396A68D541C85D26508E83_677249996.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_677249996;
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.933 -0400", hash_original_method = "7A0337E547AB2E290525371E494B1A30", hash_generated_method = "64AC12C8E02DA06F342E5764641C77A0")
    public List getHeaders() {
        List varB4EAC82CA7396A68D541C85D26508E83_2083384534 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2083384534 = headers;
        varB4EAC82CA7396A68D541C85D26508E83_2083384534.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2083384534;
        // ---------- Original Method ----------
        //return headers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.933 -0400", hash_original_method = "CA0902D8AF35560815DA28546D2C787A", hash_generated_method = "E154E21CCFCBEC7A114BAA1BB557E2E4")
    public byte[] getContent() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_122162815 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_122162815;
        // ---------- Original Method ----------
        //return content;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.933 -0400", hash_original_method = "E898D78DBFB1F3FB89A6D402FC0A6D27", hash_generated_method = "7905C1AE9E862693D1B7D610298ABBC7")
    public PemObject generate() throws PemGenerationException {
        PemObject varB4EAC82CA7396A68D541C85D26508E83_1906612440 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1906612440 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1906612440.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1906612440;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:20.934 -0400", hash_original_field = "5D4B6FC0D382A15BAE3F1DA051A09980", hash_generated_field = "C7AC98161E15453735A8D89AAFEE507A")

    private static List EMPTY_LIST = Collections.unmodifiableList(new ArrayList());
}

