package javax.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.EventObject;
import javax.sip.message.Request;

public class RequestEvent extends EventObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.250 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "D9FAD0C1386FC50E3C837906841C2A70")

    private Dialog mDialog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.250 -0400", hash_original_field = "6F4B92891660455681591E8ACE541D68", hash_generated_field = "79AB1A57A5EF61E95F4BC3CF5EFCC5FE")

    private Request mRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.250 -0400", hash_original_field = "9512BFD2351AA348680BC0368D1B6879", hash_generated_field = "FF9951F95B61CCF65F36CC4EF2056786")

    private ServerTransaction mServerTransaction;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.251 -0400", hash_original_method = "6E9D93EAAC84D5FA5B8ACB540F1D99F4", hash_generated_method = "ABB8B6AF17E80F20D1DD7D1201E7193C")
    public  RequestEvent(Object source, ServerTransaction serverTransaction,
            Dialog dialog, Request request) {
        super(source);
        addTaint(source.getTaint());
        mDialog  = dialog;
        mRequest = request;
        mServerTransaction = serverTransaction;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.251 -0400", hash_original_method = "BFDF5D83CE787BE21817622D7064532F", hash_generated_method = "C75F49F3A56AEDB601E74A77E9F73E2D")
    public Dialog getDialog() {
Dialog var91E8306796CF70F787962B1CE02ED969_1458251745 =         mDialog;
        var91E8306796CF70F787962B1CE02ED969_1458251745.addTaint(taint);
        return var91E8306796CF70F787962B1CE02ED969_1458251745;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.252 -0400", hash_original_method = "4D383BC0FA934F7D1FD2321C898D3E04", hash_generated_method = "BFAE25CA7631F2DB3F836CDB4D796393")
    public Request getRequest() {
Request var8B4E8246FC9A4D03BA5261EDD7BB1532_7373598 =         mRequest;
        var8B4E8246FC9A4D03BA5261EDD7BB1532_7373598.addTaint(taint);
        return var8B4E8246FC9A4D03BA5261EDD7BB1532_7373598;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.252 -0400", hash_original_method = "8D21BCE8DC60E722EE457FD9027E91F0", hash_generated_method = "C12041A5D273FA163BB355F468E83E5C")
    public ServerTransaction getServerTransaction() {
ServerTransaction var546EC97A1EBD7D325ADA7242D87121A0_45244340 =         mServerTransaction;
        var546EC97A1EBD7D325ADA7242D87121A0_45244340.addTaint(taint);
        return var546EC97A1EBD7D325ADA7242D87121A0_45244340;
        
        
    }

    
}

