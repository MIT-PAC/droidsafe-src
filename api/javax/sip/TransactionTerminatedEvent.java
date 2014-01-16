package javax.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.EventObject;

public class TransactionTerminatedEvent extends EventObject {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.190 -0500", hash_original_field = "7F0DEF4149A50E91D47D48AF026F263A", hash_generated_field = "3875027DABF1E19F66E817463ADDFE1C")

    private boolean mIsServerTransaction;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.192 -0500", hash_original_field = "A30FC1585A56436E1B61B6E9548A5F3A", hash_generated_field = "FF9951F95B61CCF65F36CC4EF2056786")

    private ServerTransaction mServerTransaction;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.195 -0500", hash_original_field = "1070B773CE6DA8864E09299E049FADCE", hash_generated_field = "A2FE03B3287159BF06762C26E990AE5E")

    private ClientTransaction mClientTransaction;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.198 -0500", hash_original_method = "632867B97B2B335D37FE735387619A6D", hash_generated_method = "CF14D7F702A0711A13A247D6EE70753B")
    
public TransactionTerminatedEvent(
            Object source, ServerTransaction serverTransaction) {
        super(source);
        mServerTransaction = serverTransaction;

        mIsServerTransaction = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.200 -0500", hash_original_method = "7DFFD669F06BABDE586831D790DBAADB", hash_generated_method = "618513DE188C017A04A40E6BA0F3779B")
    
public TransactionTerminatedEvent(
            Object source, ClientTransaction clientTransaction) {
        super(source);
        mClientTransaction = clientTransaction;

        mIsServerTransaction = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.203 -0500", hash_original_method = "13475C47047839CF10BE5B5662BF4F2D", hash_generated_method = "7A0E0168FF77213D2060E674DC35DDA8")
    
public boolean isServerTransaction() {
        return mIsServerTransaction;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.205 -0500", hash_original_method = "00896F7299BD9459656811B60B06B2C6", hash_generated_method = "81AF1418326903D133D5A72B4179C35F")
    
public ClientTransaction getClientTransaction() {
        return mClientTransaction;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.207 -0500", hash_original_method = "8D21BCE8DC60E722EE457FD9027E91F0", hash_generated_method = "68BE8F510D36285A2EDFFE7542489C74")
    
public ServerTransaction getServerTransaction() {
        return mServerTransaction;
    }
    
}

