package javax.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.EventObject;
import javax.sip.message.Request;

public class RequestEvent extends EventObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.049 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "D9FAD0C1386FC50E3C837906841C2A70")

    private Dialog mDialog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.049 -0400", hash_original_field = "6F4B92891660455681591E8ACE541D68", hash_generated_field = "79AB1A57A5EF61E95F4BC3CF5EFCC5FE")

    private Request mRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.049 -0400", hash_original_field = "9512BFD2351AA348680BC0368D1B6879", hash_generated_field = "FF9951F95B61CCF65F36CC4EF2056786")

    private ServerTransaction mServerTransaction;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.050 -0400", hash_original_method = "6E9D93EAAC84D5FA5B8ACB540F1D99F4", hash_generated_method = "46BB8E25529D01EF7271833BA4C601A0")
    public  RequestEvent(Object source, ServerTransaction serverTransaction,
            Dialog dialog, Request request) {
        super(source);
        mDialog  = dialog;
        mRequest = request;
        mServerTransaction = serverTransaction;
        addTaint(source.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.050 -0400", hash_original_method = "BFDF5D83CE787BE21817622D7064532F", hash_generated_method = "4E42276EADA33BB6AABF4DB64C97E0DA")
    public Dialog getDialog() {
        Dialog varB4EAC82CA7396A68D541C85D26508E83_411304872 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_411304872 = mDialog;
        varB4EAC82CA7396A68D541C85D26508E83_411304872.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_411304872;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.051 -0400", hash_original_method = "4D383BC0FA934F7D1FD2321C898D3E04", hash_generated_method = "3205B6F68C2CB1C139E337D32C43EAE1")
    public Request getRequest() {
        Request varB4EAC82CA7396A68D541C85D26508E83_1459813495 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1459813495 = mRequest;
        varB4EAC82CA7396A68D541C85D26508E83_1459813495.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1459813495;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.052 -0400", hash_original_method = "8D21BCE8DC60E722EE457FD9027E91F0", hash_generated_method = "05C98439D2BC3A34360AA8459DE0E637")
    public ServerTransaction getServerTransaction() {
        ServerTransaction varB4EAC82CA7396A68D541C85D26508E83_1727496910 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1727496910 = mServerTransaction;
        varB4EAC82CA7396A68D541C85D26508E83_1727496910.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1727496910;
        
        
    }

    
}

