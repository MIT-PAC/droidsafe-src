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
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
* Conditions Of Use 
* 
* This software was developed by employees of the National Institute of
* Standards and Technology (NIST), an agency of the Federal Government.
* Pursuant to title 15 Untied States Code Section 105, works of NIST
* employees are not subject to copyright protection in the United States
* and are considered to be in the public domain.  As a result, a formal
* license is not needed to use the software.
* 
* This software is provided by NIST as a service and is expressly
* provided "AS IS."  NIST MAKES NO WARRANTY OF ANY KIND, EXPRESS, IMPLIED
* OR STATUTORY, INCLUDING, WITHOUT LIMITATION, THE IMPLIED WARRANTY OF
* MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NON-INFRINGEMENT
* AND DATA ACCURACY.  NIST does not warrant or make any representations
* regarding the use of the software or the results thereof, including but
* not limited to the correctness, accuracy, reliability or usefulness of
* the software.
* 
* Permission to use this software is contingent upon your acceptance
* of the terms of this agreement
*  
* .
* 
*/
/*******************************************************************************
 * Product of NIST/ITL Advanced Networking Technologies Division (ANTD).        *
 *******************************************************************************/


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.message.SIPRequest;
import gov.nist.javax.sip.message.SIPResponse;
import gov.nist.javax.sip.stack.MessageChannel;
import gov.nist.javax.sip.stack.SIPTransaction;
import gov.nist.javax.sip.stack.SIPTransactionStack;
import gov.nist.javax.sip.stack.ServerRequestInterface;
import gov.nist.javax.sip.stack.ServerResponseInterface;
import gov.nist.javax.sip.stack.StackMessageFactory;

import javax.sip.TransactionState;

class NistSipMessageFactoryImpl implements StackMessageFactory {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.918 -0500", hash_original_field = "03821C4D777C0A4AB8577E0C5F2371D6", hash_generated_field = "B028268F85C87F49A0E45B93954BF938")

    private SipStackImpl sipStack;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.927 -0500", hash_original_method = "B4A348E139EC58BD28DD0F3A69B45AAD", hash_generated_method = "6F8E186CA749499C408261B2123CEEE7")
    
public NistSipMessageFactoryImpl(SipStackImpl sipStackImpl) {
        this.sipStack = sipStackImpl;

    }

    /**
     * Construct a new SIP Server Request.
     * 
     * @param sipRequest
     *            is the SIPRequest from which the SIPServerRequest is to be
     *            constructed.
     * @param messageChannel
     *            is the MessageChannel abstraction for this SIPServerRequest.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.921 -0500", hash_original_method = "05D11288A97D40A10A9E1FF4BB412446", hash_generated_method = "E7183459344DDC1F8F41F20C87AC3E8F")
    
public ServerRequestInterface newSIPServerRequest(SIPRequest sipRequest,
            MessageChannel messageChannel) {

        if (messageChannel == null || sipRequest == null) {
            throw new IllegalArgumentException("Null Arg!");
        }

        SipStackImpl theStack = (SipStackImpl) messageChannel.getSIPStack();
        DialogFilter retval = new DialogFilter(
                theStack);
        if (messageChannel instanceof SIPTransaction) {
            // If the transaction has already been created
            // then set the transaction channel.
            retval.transactionChannel = (SIPTransaction) messageChannel;
        }
        retval.listeningPoint = messageChannel.getMessageProcessor()
                .getListeningPoint();
        if (retval.listeningPoint == null)
            return null;
        if (sipStack.isLoggingEnabled())
            sipStack.getStackLogger().logDebug(
                    "Returning request interface for "
                            + sipRequest.getFirstLine() + " " + retval
                            + " messageChannel = " + messageChannel);
        return retval;
    }

    /**
     * Generate a new server response for the stack.
     * 
     * @param sipResponse
     *            is the SIPRequest from which the SIPServerRequest is to be
     *            constructed.
     * @param messageChannel
     *            is the MessageChannel abstraction for this SIPServerResponse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.924 -0500", hash_original_method = "683DE9908ACD912FB40AB2EA7112FC1F", hash_generated_method = "5F837B5EEEF568F0D8B6971471D8B2EC")
    
public ServerResponseInterface newSIPServerResponse(
            SIPResponse sipResponse, MessageChannel messageChannel) {
        SIPTransactionStack theStack = (SIPTransactionStack) messageChannel
                .getSIPStack();
        // Tr is null if a transaction is not mapped.
        SIPTransaction tr = (SIPTransaction) ((SIPTransactionStack) theStack)
                .findTransaction(sipResponse, false);
        if (sipStack.isLoggingEnabled())
            sipStack.getStackLogger().logDebug(
                    "Found Transaction " + tr + " for " + sipResponse);

        if (tr != null) {
            // Prune unhealthy responses early if handling statefully.
            // If the state has not yet been assigned then this is a
            // spurious response. This was moved up from the transaction
            // layer for efficiency.
            if (tr.getState() == null) {
                if (sipStack.isLoggingEnabled())
                    sipStack.getStackLogger().logDebug(
                            "Dropping response - null transaction state");
                return null;
                // Ignore 1xx
            } else if (TransactionState.COMPLETED == tr.getState()
                    && sipResponse.getStatusCode() / 100 == 1) {
                if (sipStack.isLoggingEnabled())
                    sipStack.getStackLogger().logDebug(
                            "Dropping response - late arriving "
                                    + sipResponse.getStatusCode());
                return null;
            }
        }

        DialogFilter retval = new DialogFilter(
                sipStack);

        retval.transactionChannel = tr;

        retval.listeningPoint = messageChannel.getMessageProcessor()
                .getListeningPoint();
        return retval;
    }
    
}

