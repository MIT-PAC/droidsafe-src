package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.ClientTransaction;
import javax.sip.Dialog;
import javax.sip.ResponseEvent;
import javax.sip.message.Response;

public class ResponseEventExt extends ResponseEvent {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.740 -0400", hash_original_field = "D41668E01A43244927876A27588FC413", hash_generated_field = "F64A30969C6A648637B3D7A003D6815C")

    private ClientTransactionExt m_originalTransaction;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.741 -0400", hash_original_method = "E0A4B826C1E89C68B173497FA6715B8E", hash_generated_method = "6159CEE6A3BD46B50ABB4729B597F84C")
    public  ResponseEventExt(Object source, ClientTransactionExt clientTransaction, 
            Dialog dialog,  Response response) {
        super(source,clientTransaction,dialog,response);
        m_originalTransaction = clientTransaction;
        addTaint(source.getTaint());
        addTaint(dialog.getTaint());
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //m_originalTransaction = clientTransaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.741 -0400", hash_original_method = "1D5FD647F40A8A30082BEBDADF028E9F", hash_generated_method = "83EC9549021DAEC94A149FE0F37EC28C")
    public boolean isForkedResponse() {
        boolean varBC7ABAE0479D6E261A27B5CAE5B32C0E_1265057895 = (super.getClientTransaction() == null && m_originalTransaction != null);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_512275562 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_512275562;
        // ---------- Original Method ----------
        //return super.getClientTransaction() == null && m_originalTransaction != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.742 -0400", hash_original_method = "86BB48DEB1DDB9180E72A821E2A3AF51", hash_generated_method = "86A3A3109A8873E13BC7122F5738A43E")
    public void setOriginalTransaction(ClientTransactionExt originalTransaction ) {
        m_originalTransaction = originalTransaction;
        // ---------- Original Method ----------
        //m_originalTransaction = originalTransaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.742 -0400", hash_original_method = "BC8FBC0426D6766D3BE2845167DC7794", hash_generated_method = "61631373F6BE2191C4A2D5F504BDF413")
    public ClientTransactionExt getOriginalTransaction() {
        ClientTransactionExt varB4EAC82CA7396A68D541C85D26508E83_822077494 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_822077494 = this.m_originalTransaction;
        varB4EAC82CA7396A68D541C85D26508E83_822077494.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_822077494;
        // ---------- Original Method ----------
        //return this.m_originalTransaction;
    }

    
}

