/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.Dialog;
import javax.sip.ResponseEvent;
import javax.sip.message.Response;

public class ResponseEventExt extends ResponseEvent {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.015 -0500", hash_original_field = "86C5799144120E8B100BB36A047E8D99", hash_generated_field = "F64A30969C6A648637B3D7A003D6815C")

    private ClientTransactionExt  m_originalTransaction;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.018 -0500", hash_original_method = "E0A4B826C1E89C68B173497FA6715B8E", hash_generated_method = "5DE17CEB59A16B2B3CA3BB3F523DAD60")
    
public ResponseEventExt(Object source, ClientTransactionExt clientTransaction, 
            Dialog dialog,  Response response) {
        super(source,clientTransaction,dialog,response);
        m_originalTransaction = clientTransaction;
    }
    
    /**
     * Return true if this is a forked response.
     * 
     * @return true if the response event is for a forked response.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.021 -0500", hash_original_method = "1D5FD647F40A8A30082BEBDADF028E9F", hash_generated_method = "C11B90FE13D5D91010819DF98F43D8F7")
    
public boolean isForkedResponse() {
        return super.getClientTransaction() == null && m_originalTransaction != null;
    }
    
    /**
     * Set the original transaction for a forked response.
     * 
     * @param originalTransaction - the original transaction for which this response event is a fork.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.024 -0500", hash_original_method = "86BB48DEB1DDB9180E72A821E2A3AF51", hash_generated_method = "BB8A1B3A134ABE85821BF549B13868A2")
    
public void setOriginalTransaction(ClientTransactionExt originalTransaction ) {
        m_originalTransaction = originalTransaction;
    }
    
    /**
     * Get the original transaction for which this is a forked response.
     * Note that this transaction can be in a TERMINATED state.
     * 
     * @return the original clientTx for which this is a forked response.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.026 -0500", hash_original_method = "BC8FBC0426D6766D3BE2845167DC7794", hash_generated_method = "A38DCC48FDF9A2BF99FFB6B1509FA8F5")
    
public ClientTransactionExt getOriginalTransaction() {
        return this.m_originalTransaction;
    }
    
}

