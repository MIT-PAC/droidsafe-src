package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.EventObject;

public class TransactionTerminatedEvent extends EventObject {
    private boolean mIsServerTransaction;
    private ServerTransaction mServerTransaction;
    private ClientTransaction mClientTransaction;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.262 -0400", hash_original_method = "632867B97B2B335D37FE735387619A6D", hash_generated_method = "7F3DE5E5A6C2D330AC1D1C9EA456BAAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TransactionTerminatedEvent(
            Object source, ServerTransaction serverTransaction) {
        super(source);
        dsTaint.addTaint(source.dsTaint);
        dsTaint.addTaint(serverTransaction.dsTaint);
        mIsServerTransaction = true;
        // ---------- Original Method ----------
        //mServerTransaction = serverTransaction;
        //mIsServerTransaction = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.262 -0400", hash_original_method = "7DFFD669F06BABDE586831D790DBAADB", hash_generated_method = "85F6F6A620330049AB6A9FA325AB0641")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TransactionTerminatedEvent(
            Object source, ClientTransaction clientTransaction) {
        super(source);
        dsTaint.addTaint(source.dsTaint);
        dsTaint.addTaint(clientTransaction.dsTaint);
        mIsServerTransaction = false;
        // ---------- Original Method ----------
        //mClientTransaction = clientTransaction;
        //mIsServerTransaction = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.262 -0400", hash_original_method = "13475C47047839CF10BE5B5662BF4F2D", hash_generated_method = "F98AD214D551C156B7BDF9870E0BE769")
    @DSModeled(DSC.SAFE)
    public boolean isServerTransaction() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsServerTransaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.262 -0400", hash_original_method = "00896F7299BD9459656811B60B06B2C6", hash_generated_method = "4E5A58027175171C65F7EE315343CA77")
    @DSModeled(DSC.SAFE)
    public ClientTransaction getClientTransaction() {
        return (ClientTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mClientTransaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.262 -0400", hash_original_method = "8D21BCE8DC60E722EE457FD9027E91F0", hash_generated_method = "76F9F318ACF29D0028403B6407753D5F")
    @DSModeled(DSC.SAFE)
    public ServerTransaction getServerTransaction() {
        return (ServerTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mServerTransaction;
    }

    
}

