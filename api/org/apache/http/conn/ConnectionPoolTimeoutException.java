package org.apache.http.conn;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class ConnectionPoolTimeoutException extends ConnectTimeoutException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.372 -0400", hash_original_method = "1DCDBD8202B02F10B12F065EF60143EE", hash_generated_method = "BE96AD196165FA8632030FC355956F28")
    public  ConnectionPoolTimeoutException() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.372 -0400", hash_original_method = "6FAEC3D93E1C94116A1DCC64CCDF43BD", hash_generated_method = "3EBF732B8E5E87EE56ADABE1CAC4B953")
    public  ConnectionPoolTimeoutException(String message) {
        super(message);
        addTaint(message.getTaint());
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.372 -0400", hash_original_field = "F25F957D17C34D2BB84F2DD01CFE8CFF", hash_generated_field = "E7B811CC0F7FBE05DC02261FB6EB070A")

    private static final long serialVersionUID = -7898874842020245128L;
}

