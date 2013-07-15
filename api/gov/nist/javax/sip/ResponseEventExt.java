package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.ClientTransaction;
import javax.sip.Dialog;
import javax.sip.ResponseEvent;
import javax.sip.message.Response;

public class ResponseEventExt extends ResponseEvent {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.548 -0400", hash_original_field = "D41668E01A43244927876A27588FC413", hash_generated_field = "F64A30969C6A648637B3D7A003D6815C")

    private ClientTransactionExt m_originalTransaction;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.548 -0400", hash_original_method = "E0A4B826C1E89C68B173497FA6715B8E", hash_generated_method = "D9CFAF44542742CC92191234D3E6FA33")
    public  ResponseEventExt(Object source, ClientTransactionExt clientTransaction, 
            Dialog dialog,  Response response) {
        super(source,clientTransaction,dialog,response);
        addTaint(response.getTaint());
        addTaint(dialog.getTaint());
        addTaint(source.getTaint());
        m_originalTransaction = clientTransaction;
        // ---------- Original Method ----------
        //m_originalTransaction = clientTransaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.549 -0400", hash_original_method = "1D5FD647F40A8A30082BEBDADF028E9F", hash_generated_method = "DDAD136A4C109538A385C10E46D2728A")
    public boolean isForkedResponse() {
        boolean var0FCFC13D796A6319C2F5AEA23D967DF1_66371237 = (super.getClientTransaction() == null && m_originalTransaction != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1942506284 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1942506284;
        // ---------- Original Method ----------
        //return super.getClientTransaction() == null && m_originalTransaction != null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.549 -0400", hash_original_method = "86BB48DEB1DDB9180E72A821E2A3AF51", hash_generated_method = "86A3A3109A8873E13BC7122F5738A43E")
    public void setOriginalTransaction(ClientTransactionExt originalTransaction ) {
        m_originalTransaction = originalTransaction;
        // ---------- Original Method ----------
        //m_originalTransaction = originalTransaction;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.549 -0400", hash_original_method = "BC8FBC0426D6766D3BE2845167DC7794", hash_generated_method = "9191B5004976D497F4E24F2A14419604")
    public ClientTransactionExt getOriginalTransaction() {
ClientTransactionExt var16BA59E0B4BC8848A154C09BC442AF86_1250628985 =         this.m_originalTransaction;
        var16BA59E0B4BC8848A154C09BC442AF86_1250628985.addTaint(taint);
        return var16BA59E0B4BC8848A154C09BC442AF86_1250628985;
        // ---------- Original Method ----------
        //return this.m_originalTransaction;
    }

    
}

