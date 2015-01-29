package javax.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.EventObject;

import javax.sip.message.Request;

public class RequestEvent extends EventObject {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.920 -0500", hash_original_field = "0C87BCBAF0D95855709E5BEE2BDBA46D", hash_generated_field = "D9FAD0C1386FC50E3C837906841C2A70")

    private Dialog mDialog;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.922 -0500", hash_original_field = "480419B6BBB9A26A6DD8401352CF0FEE", hash_generated_field = "79AB1A57A5EF61E95F4BC3CF5EFCC5FE")

    private Request mRequest;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.925 -0500", hash_original_field = "A30FC1585A56436E1B61B6E9548A5F3A", hash_generated_field = "FF9951F95B61CCF65F36CC4EF2056786")

    private ServerTransaction mServerTransaction;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.928 -0500", hash_original_method = "6E9D93EAAC84D5FA5B8ACB540F1D99F4", hash_generated_method = "38C4499FC9F86FB846306F28494857D2")
    
public RequestEvent(Object source, ServerTransaction serverTransaction,
            Dialog dialog, Request request) {
        super(source);
        mDialog  = dialog;
        mRequest = request;
        mServerTransaction = serverTransaction;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.930 -0500", hash_original_method = "BFDF5D83CE787BE21817622D7064532F", hash_generated_method = "C71E5AB7F1A8C6EFC64CAA7F76F42BA5")
    
public Dialog getDialog() {
        return mDialog;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.932 -0500", hash_original_method = "4D383BC0FA934F7D1FD2321C898D3E04", hash_generated_method = "FCAF1EB1B14AC1DA0D087DFAAA6821D6")
    
public Request getRequest() {
        return mRequest;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.934 -0500", hash_original_method = "8D21BCE8DC60E722EE457FD9027E91F0", hash_generated_method = "68BE8F510D36285A2EDFFE7542489C74")
    
public ServerTransaction getServerTransaction() {
        return mServerTransaction;
    }
    
}

