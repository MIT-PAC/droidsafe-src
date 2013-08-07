package java.net;

// Droidsafe Imports
import droidsafe.annotations.*;



public class ProtocolException extends java.io.IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.297 -0400", hash_original_method = "F33E95B361A636BB80AA643BEE16494D", hash_generated_method = "E9DEBF640D79AE700FB76DD1B00C9C48")
    public  ProtocolException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.298 -0400", hash_original_method = "8A7B1748C796BD03C7089BCC55139778", hash_generated_method = "8CC4C616FF643B0D0AA5D9A66BC2BFAD")
    public  ProtocolException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.298 -0400", hash_original_method = "8A280093AAE5F90F3CD44950672A326E", hash_generated_method = "52115333BC07E85567077F59E3C3E6E4")
    public  ProtocolException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        addTaint(cause.getTaint());
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.298 -0400", hash_original_field = "EF597D0A71D077B57161E2A20B14AF7C", hash_generated_field = "B5FA4CEFFBB595720D8C22950D4B5E92")

    private static final long serialVersionUID = -6098449442062388080L;
}

