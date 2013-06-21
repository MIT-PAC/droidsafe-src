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
    private ClientTransactionExt  m_originalTransaction;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.156 -0400", hash_original_method = "E0A4B826C1E89C68B173497FA6715B8E", hash_generated_method = "163EA40AE5DABFD9CF25321DC96936C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ResponseEventExt(Object source, ClientTransactionExt clientTransaction, 
            Dialog dialog,  Response response) {
        super(source,clientTransaction,dialog,response);
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(source.dsTaint);
        dsTaint.addTaint(clientTransaction.dsTaint);
        dsTaint.addTaint(dialog.dsTaint);
        // ---------- Original Method ----------
        //m_originalTransaction = clientTransaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.156 -0400", hash_original_method = "1D5FD647F40A8A30082BEBDADF028E9F", hash_generated_method = "C539B0E357DA95BBA2A084F6699E1048")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isForkedResponse() {
        boolean varBC7ABAE0479D6E261A27B5CAE5B32C0E_1222237994 = (super.getClientTransaction() == null && m_originalTransaction != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return super.getClientTransaction() == null && m_originalTransaction != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.156 -0400", hash_original_method = "86BB48DEB1DDB9180E72A821E2A3AF51", hash_generated_method = "10E1BF38561530D1655D11A71994E31B")
    @DSModeled(DSC.SAFE)
    public void setOriginalTransaction(ClientTransactionExt originalTransaction ) {
        dsTaint.addTaint(originalTransaction.dsTaint);
        // ---------- Original Method ----------
        //m_originalTransaction = originalTransaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.157 -0400", hash_original_method = "BC8FBC0426D6766D3BE2845167DC7794", hash_generated_method = "E48117577ED2EC1B70C5632A5D9987AE")
    @DSModeled(DSC.SAFE)
    public ClientTransactionExt getOriginalTransaction() {
        return (ClientTransactionExt)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.m_originalTransaction;
    }

    
}

