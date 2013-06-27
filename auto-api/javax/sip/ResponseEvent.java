package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.EventObject;
import javax.sip.message.Response;

public class ResponseEvent extends EventObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.930 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "D9FAD0C1386FC50E3C837906841C2A70")

    private Dialog mDialog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.930 -0400", hash_original_field = "E72652B09AB331E8E60D8A37942A6989", hash_generated_field = "357A96A988CEB8869E67EAB0CC1CA73C")

    private Response mResponse;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.930 -0400", hash_original_field = "C0EE02CC55392CBD06E928953A0AD9C5", hash_generated_field = "A2FE03B3287159BF06762C26E990AE5E")

    private ClientTransaction mClientTransaction;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.931 -0400", hash_original_method = "F99FD2C7A85B9DCBE0AD9A9C8BE9081F", hash_generated_method = "58F3AA2155AB7C777F6FCBE67CA4A742")
    public  ResponseEvent(Object source, ClientTransaction clientTransaction,
            Dialog dialog, Response response) {
        super(source);
        mDialog = dialog;
        mResponse = response;
        mClientTransaction = clientTransaction;
        addTaint(source.getTaint());
        // ---------- Original Method ----------
        //mDialog = dialog;
        //mResponse = response;
        //mClientTransaction = clientTransaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.931 -0400", hash_original_method = "BFDF5D83CE787BE21817622D7064532F", hash_generated_method = "0F421E30360E960F5B3A8493D5B1A047")
    public Dialog getDialog() {
        Dialog varB4EAC82CA7396A68D541C85D26508E83_1584332303 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1584332303 = mDialog;
        varB4EAC82CA7396A68D541C85D26508E83_1584332303.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1584332303;
        // ---------- Original Method ----------
        //return mDialog;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.932 -0400", hash_original_method = "00292A90D159CA5BE7BB594CFFCF61C9", hash_generated_method = "1F00C5D9B1DDAB9B51F02C835CAE6418")
    public Response getResponse() {
        Response varB4EAC82CA7396A68D541C85D26508E83_1164718957 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1164718957 = mResponse;
        varB4EAC82CA7396A68D541C85D26508E83_1164718957.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1164718957;
        // ---------- Original Method ----------
        //return mResponse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.932 -0400", hash_original_method = "00896F7299BD9459656811B60B06B2C6", hash_generated_method = "4B24D4906518642D58AED219AB21BBE0")
    public ClientTransaction getClientTransaction() {
        ClientTransaction varB4EAC82CA7396A68D541C85D26508E83_463921441 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_463921441 = mClientTransaction;
        varB4EAC82CA7396A68D541C85D26508E83_463921441.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_463921441;
        // ---------- Original Method ----------
        //return mClientTransaction;
    }

    
}

