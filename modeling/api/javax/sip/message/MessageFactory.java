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


package javax.sip.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;
import java.util.List;

import javax.sip.address.URI;
import javax.sip.header.CSeqHeader;
import javax.sip.header.CallIdHeader;
import javax.sip.header.ContentTypeHeader;
import javax.sip.header.FromHeader;
import javax.sip.header.MaxForwardsHeader;
import javax.sip.header.ServerHeader;
import javax.sip.header.ToHeader;
import javax.sip.header.UserAgentHeader;

public interface MessageFactory {
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Request createRequest(URI requestURI, String method, CallIdHeader callId,
            CSeqHeader cSeq, FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards, ContentTypeHeader contentType,
            Object content) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Request createRequest(URI requestURI, String method, CallIdHeader callId,
            CSeqHeader cSeq, FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards, ContentTypeHeader contentType,
            byte[] content) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Request createRequest(URI requestURI, String method, CallIdHeader callId,
            CSeqHeader cSeq, FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Request createRequest(String request) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Response createResponse(int statusCode, CallIdHeader callId,
            CSeqHeader cSeq, FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards, ContentTypeHeader contentType,
            Object content) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Response createResponse(int statusCode, CallIdHeader callId,
            CSeqHeader cSeq, FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards, ContentTypeHeader contentType,
            byte[] content) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Response createResponse(int statusCode, CallIdHeader callId,
            CSeqHeader cSeq, FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Response createResponse(int statusCode, Request request,
            ContentTypeHeader contentType, Object content)
            throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Response createResponse(int statusCode, Request request,
            ContentTypeHeader contentType, byte[] content)
            throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Response createResponse(int statusCode, Request request)
            throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Response createResponse(String response) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setDefaultContentEncodingCharset(String defaultContentEncodingCharset)
            throws NullPointerException, IllegalArgumentException;
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setDefaultServerHeader(ServerHeader defaultServerHeader);
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setDefaultUserAgentHeader(UserAgentHeader defaultUserAgentHeader);
}
