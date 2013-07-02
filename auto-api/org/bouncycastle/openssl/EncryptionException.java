package org.bouncycastle.openssl;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public class EncryptionException extends IOException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.950 -0400", hash_original_field = "560220FC3242A805F094EDCE47F35702", hash_generated_field = "8A44E2478DCB737F0795473263737867")

    private Throwable cause;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.951 -0400", hash_original_method = "0A5225B15FFCBBF051BE0F84A5007C61", hash_generated_method = "89AC63CD9CB583D280CD505887C5F8E6")
    public  EncryptionException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.952 -0400", hash_original_method = "FE6B7F9DB7E1AFAF6DF8BCFDDE4BB303", hash_generated_method = "8C6C6FBA20458EA64DE1908DC2D1E519")
    public  EncryptionException(String msg, Throwable ex) {
        super(msg);
        this.cause = ex;
        addTaint(msg.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.955 -0400", hash_original_method = "CDBDBC1C44563A9D34649A0018341F0E", hash_generated_method = "3DBDF6395186A862EFC4B8C309F9CD4A")
    public Throwable getCause() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_1128189813 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1128189813 = cause;
        varB4EAC82CA7396A68D541C85D26508E83_1128189813.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1128189813;
        
        
    }

    
}

