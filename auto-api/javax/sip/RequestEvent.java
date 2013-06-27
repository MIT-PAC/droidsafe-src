package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.EventObject;
import javax.sip.message.Request;

public class RequestEvent extends EventObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.513 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "D9FAD0C1386FC50E3C837906841C2A70")

    private Dialog mDialog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.513 -0400", hash_original_field = "6F4B92891660455681591E8ACE541D68", hash_generated_field = "79AB1A57A5EF61E95F4BC3CF5EFCC5FE")

    private Request mRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.514 -0400", hash_original_field = "9512BFD2351AA348680BC0368D1B6879", hash_generated_field = "FF9951F95B61CCF65F36CC4EF2056786")

    private ServerTransaction mServerTransaction;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.514 -0400", hash_original_method = "6E9D93EAAC84D5FA5B8ACB540F1D99F4", hash_generated_method = "46BB8E25529D01EF7271833BA4C601A0")
    public  RequestEvent(Object source, ServerTransaction serverTransaction,
            Dialog dialog, Request request) {
        super(source);
        mDialog  = dialog;
        mRequest = request;
        mServerTransaction = serverTransaction;
        addTaint(source.getTaint());
        // ---------- Original Method ----------
        //mDialog  = dialog;
        //mRequest = request;
        //mServerTransaction = serverTransaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.516 -0400", hash_original_method = "BFDF5D83CE787BE21817622D7064532F", hash_generated_method = "257D109AC017DA5DA9457FBC1EFF60D4")
    public Dialog getDialog() {
        Dialog varB4EAC82CA7396A68D541C85D26508E83_1736052203 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1736052203 = mDialog;
        varB4EAC82CA7396A68D541C85D26508E83_1736052203.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1736052203;
        // ---------- Original Method ----------
        //return mDialog;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.522 -0400", hash_original_method = "4D383BC0FA934F7D1FD2321C898D3E04", hash_generated_method = "26DE754DBB39BC46D21B882DAB660E3C")
    public Request getRequest() {
        Request varB4EAC82CA7396A68D541C85D26508E83_183158459 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_183158459 = mRequest;
        varB4EAC82CA7396A68D541C85D26508E83_183158459.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_183158459;
        // ---------- Original Method ----------
        //return mRequest;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.529 -0400", hash_original_method = "8D21BCE8DC60E722EE457FD9027E91F0", hash_generated_method = "77A70E29157B2D64FDABB07BDF32242B")
    public ServerTransaction getServerTransaction() {
        ServerTransaction varB4EAC82CA7396A68D541C85D26508E83_2065333458 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2065333458 = mServerTransaction;
        varB4EAC82CA7396A68D541C85D26508E83_2065333458.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2065333458;
        // ---------- Original Method ----------
        //return mServerTransaction;
    }

    
}

