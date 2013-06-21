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
    private Dialog mDialog;
    private Request mRequest;
    private ServerTransaction mServerTransaction;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.238 -0400", hash_original_method = "6E9D93EAAC84D5FA5B8ACB540F1D99F4", hash_generated_method = "12ECA7BF18B3B5AC12B5E5E52A9643ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RequestEvent(Object source, ServerTransaction serverTransaction,
            Dialog dialog, Request request) {
        super(source);
        dsTaint.addTaint(source.dsTaint);
        dsTaint.addTaint(request.dsTaint);
        dsTaint.addTaint(serverTransaction.dsTaint);
        dsTaint.addTaint(dialog.dsTaint);
        // ---------- Original Method ----------
        //mDialog  = dialog;
        //mRequest = request;
        //mServerTransaction = serverTransaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.238 -0400", hash_original_method = "BFDF5D83CE787BE21817622D7064532F", hash_generated_method = "4F073E538789CB30D5A56AE8F87B31D1")
    @DSModeled(DSC.SAFE)
    public Dialog getDialog() {
        return (Dialog)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mDialog;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.238 -0400", hash_original_method = "4D383BC0FA934F7D1FD2321C898D3E04", hash_generated_method = "83D0021A506D14EF617AD74B02AAB337")
    @DSModeled(DSC.SAFE)
    public Request getRequest() {
        return (Request)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mRequest;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.238 -0400", hash_original_method = "8D21BCE8DC60E722EE457FD9027E91F0", hash_generated_method = "76F9F318ACF29D0028403B6407753D5F")
    @DSModeled(DSC.SAFE)
    public ServerTransaction getServerTransaction() {
        return (ServerTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mServerTransaction;
    }

    
}

