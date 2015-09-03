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


package javax.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;
import java.util.Iterator;

import javax.sip.address.Address;
import javax.sip.header.CallIdHeader;
import javax.sip.message.Request;
import javax.sip.message.Response;

public interface Dialog extends Serializable {
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Object getApplicationData();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setApplicationData(Object applicationData);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    CallIdHeader getCallId();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getDialogId();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Transaction getFirstTransaction();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Address getLocalParty();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    int getLocalSequenceNumber();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    long getLocalSeqNumber();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getLocalTag();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Address getRemoteParty();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    int getRemoteSequenceNumber();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    long getRemoteSeqNumber();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getRemoteTag();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Address getRemoteTarget();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Iterator getRouteSet();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    SipProvider getSipProvider();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    DialogState getState();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    boolean isSecure();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    boolean isServer();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void delete();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void incrementLocalSequenceNumber();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Request createRequest(String method) throws SipException;
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Request createAck(long cseq) throws InvalidArgumentException, SipException;
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Request createPrack(Response relResponse)
            throws DialogDoesNotExistException, SipException;
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Response createReliableProvisionalResponse(int statusCode)
            throws InvalidArgumentException, SipException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void sendRequest(ClientTransaction clientTransaction)
            throws TransactionDoesNotExistException, SipException;
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void sendAck(Request ackRequest) throws SipException;
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void sendReliableProvisionalResponse(Response relResponse)
            throws SipException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setBackToBackUserAgent();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void terminateOnBye(boolean terminateFlag) throws SipException;
}
