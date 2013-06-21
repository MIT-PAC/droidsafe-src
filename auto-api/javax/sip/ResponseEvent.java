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
    private Dialog mDialog;
    private Response mResponse;
    private ClientTransaction mClientTransaction;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.239 -0400", hash_original_method = "F99FD2C7A85B9DCBE0AD9A9C8BE9081F", hash_generated_method = "22003019BA745D6D8C70FCFC1E80BB46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ResponseEvent(Object source, ClientTransaction clientTransaction,
            Dialog dialog, Response response) {
        super(source);
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(source.dsTaint);
        dsTaint.addTaint(clientTransaction.dsTaint);
        dsTaint.addTaint(dialog.dsTaint);
        // ---------- Original Method ----------
        //mDialog = dialog;
        //mResponse = response;
        //mClientTransaction = clientTransaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.239 -0400", hash_original_method = "BFDF5D83CE787BE21817622D7064532F", hash_generated_method = "4F073E538789CB30D5A56AE8F87B31D1")
    @DSModeled(DSC.SAFE)
    public Dialog getDialog() {
        return (Dialog)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mDialog;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.239 -0400", hash_original_method = "00292A90D159CA5BE7BB594CFFCF61C9", hash_generated_method = "D82119CB9D25E1B493B7A47D13B8D502")
    @DSModeled(DSC.SAFE)
    public Response getResponse() {
        return (Response)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mResponse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.240 -0400", hash_original_method = "00896F7299BD9459656811B60B06B2C6", hash_generated_method = "4E5A58027175171C65F7EE315343CA77")
    @DSModeled(DSC.SAFE)
    public ClientTransaction getClientTransaction() {
        return (ClientTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mClientTransaction;
    }

    
}

