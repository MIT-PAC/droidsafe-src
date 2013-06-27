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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.922 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "D9FAD0C1386FC50E3C837906841C2A70")

    private Dialog mDialog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.922 -0400", hash_original_field = "6F4B92891660455681591E8ACE541D68", hash_generated_field = "79AB1A57A5EF61E95F4BC3CF5EFCC5FE")

    private Request mRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.922 -0400", hash_original_field = "9512BFD2351AA348680BC0368D1B6879", hash_generated_field = "FF9951F95B61CCF65F36CC4EF2056786")

    private ServerTransaction mServerTransaction;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.923 -0400", hash_original_method = "6E9D93EAAC84D5FA5B8ACB540F1D99F4", hash_generated_method = "46BB8E25529D01EF7271833BA4C601A0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.923 -0400", hash_original_method = "BFDF5D83CE787BE21817622D7064532F", hash_generated_method = "567AF0F49B3596C1CDD9D23CFE229E8F")
    public Dialog getDialog() {
        Dialog varB4EAC82CA7396A68D541C85D26508E83_1002809062 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1002809062 = mDialog;
        varB4EAC82CA7396A68D541C85D26508E83_1002809062.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1002809062;
        // ---------- Original Method ----------
        //return mDialog;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.925 -0400", hash_original_method = "4D383BC0FA934F7D1FD2321C898D3E04", hash_generated_method = "0E1AA2EEC39F44BBA516ACE16F88D80B")
    public Request getRequest() {
        Request varB4EAC82CA7396A68D541C85D26508E83_1144812369 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1144812369 = mRequest;
        varB4EAC82CA7396A68D541C85D26508E83_1144812369.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1144812369;
        // ---------- Original Method ----------
        //return mRequest;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.926 -0400", hash_original_method = "8D21BCE8DC60E722EE457FD9027E91F0", hash_generated_method = "42CCD107E83939054E9CAF7C87D4622B")
    public ServerTransaction getServerTransaction() {
        ServerTransaction varB4EAC82CA7396A68D541C85D26508E83_758900068 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_758900068 = mServerTransaction;
        varB4EAC82CA7396A68D541C85D26508E83_758900068.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_758900068;
        // ---------- Original Method ----------
        //return mServerTransaction;
    }

    
}

