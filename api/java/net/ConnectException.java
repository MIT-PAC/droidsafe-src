package java.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class ConnectException extends SocketException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.032 -0400", hash_original_method = "E8FAEAA07CFA8C05C275809EB6A40178", hash_generated_method = "7F69AFAC4E3662D5B99297EBEC8BAE4F")
    public  ConnectException() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.033 -0400", hash_original_method = "49125F9CA125EC7F4D4C7EADF3FA5E9C", hash_generated_method = "85152024E29DBCB665A3FF0BB4FA29D8")
    public  ConnectException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.033 -0400", hash_original_method = "4C12D3BC3A1875DEC95F9E2E6B90AD5C", hash_generated_method = "ED6C667A4A61B95BF8A1633A63B015E3")
    public  ConnectException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        addTaint(detailMessage.getTaint());
        addTaint(cause.getTaint());
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.033 -0400", hash_original_field = "D40375CA2B5D23EBFFECB923DFF3A0AE", hash_generated_field = "CAE820EF0FC06E92C927106699F8E8B2")

    private static final long serialVersionUID = 3831404271622369215L;
}

