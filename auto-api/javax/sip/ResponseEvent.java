package javax.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.EventObject;
import javax.sip.message.Response;

public class ResponseEvent extends EventObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.057 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "D9FAD0C1386FC50E3C837906841C2A70")

    private Dialog mDialog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.057 -0400", hash_original_field = "E72652B09AB331E8E60D8A37942A6989", hash_generated_field = "357A96A988CEB8869E67EAB0CC1CA73C")

    private Response mResponse;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.057 -0400", hash_original_field = "C0EE02CC55392CBD06E928953A0AD9C5", hash_generated_field = "A2FE03B3287159BF06762C26E990AE5E")

    private ClientTransaction mClientTransaction;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.058 -0400", hash_original_method = "F99FD2C7A85B9DCBE0AD9A9C8BE9081F", hash_generated_method = "58F3AA2155AB7C777F6FCBE67CA4A742")
    public  ResponseEvent(Object source, ClientTransaction clientTransaction,
            Dialog dialog, Response response) {
        super(source);
        mDialog = dialog;
        mResponse = response;
        mClientTransaction = clientTransaction;
        addTaint(source.getTaint());
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.058 -0400", hash_original_method = "BFDF5D83CE787BE21817622D7064532F", hash_generated_method = "6E5CB7294B58AD19F78AF8EA7E14D76B")
    public Dialog getDialog() {
        Dialog varB4EAC82CA7396A68D541C85D26508E83_970190510 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_970190510 = mDialog;
        varB4EAC82CA7396A68D541C85D26508E83_970190510.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_970190510;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.059 -0400", hash_original_method = "00292A90D159CA5BE7BB594CFFCF61C9", hash_generated_method = "25CDFD5ADB0A869D415E380A94E793AF")
    public Response getResponse() {
        Response varB4EAC82CA7396A68D541C85D26508E83_2107630378 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2107630378 = mResponse;
        varB4EAC82CA7396A68D541C85D26508E83_2107630378.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2107630378;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.060 -0400", hash_original_method = "00896F7299BD9459656811B60B06B2C6", hash_generated_method = "1DDC4F30C19888CA0FA6B530E1983CA4")
    public ClientTransaction getClientTransaction() {
        ClientTransaction varB4EAC82CA7396A68D541C85D26508E83_2012412133 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2012412133 = mClientTransaction;
        varB4EAC82CA7396A68D541C85D26508E83_2012412133.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2012412133;
        
        
    }

    
}

