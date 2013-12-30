package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.CSeq;
import gov.nist.javax.sip.header.CallID;
import gov.nist.javax.sip.header.ContentType;
import gov.nist.javax.sip.header.From;
import gov.nist.javax.sip.header.MaxForwards;
import gov.nist.javax.sip.header.RequestLine;
import gov.nist.javax.sip.header.StatusLine;
import gov.nist.javax.sip.header.To;
import gov.nist.javax.sip.header.Via;
import gov.nist.javax.sip.parser.ParseExceptionListener;
import gov.nist.javax.sip.parser.StringMsgParser;

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
import javax.sip.message.MessageFactory;
import javax.sip.message.Request;
import javax.sip.message.Response;






public class MessageFactoryImpl implements MessageFactory, MessageFactoryExt {
    /**
     * Get the default common UserAgentHeader.
     *
     * @return the user agent header.
     *
     * @since 2.0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:35.692 -0500", hash_original_method = "C89ABE013600473558BF14E3725A2CD0", hash_generated_method = "B0C40DB3A8237F2BE59F07DCF31CFDCD")
    
public static UserAgentHeader getDefaultUserAgentHeader() {
        return userAgent;
    }


    /**
     * Get the default common server header.
     *
     * @return the server header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:35.694 -0500", hash_original_method = "8E30377DD5EA58EE24E9DBB58EDE843C", hash_generated_method = "76BB6719BE01E20BAA78776A5DEBF512")
    
public static ServerHeader getDefaultServerHeader() {
        return server;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:35.699 -0500", hash_original_method = "09F50F9145B26B5F9153A759802EF925", hash_generated_method = "7174EC97A2B0FEFE949F88B49B15845F")
    
public static String getDefaultContentEncodingCharset() {
        return MessageFactoryImpl.defaultContentEncodingCharset;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:35.625 -0500", hash_original_field = "7A0FDE982719C7AE0EADC20730BAA3A9", hash_generated_field = "790B4B09B170A9194D25942ACCB3ACEB")


    private static String defaultContentEncodingCharset = "UTF-8";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:35.628 -0500", hash_original_field = "D5E000297A9E09754C3FCD741F248C73", hash_generated_field = "52E17AB48D222AC2268208CD5EE77BA5")

    private static UserAgentHeader userAgent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:35.630 -0500", hash_original_field = "4FA79EC2DE15E51C42E5B8F1D6E6F0AE", hash_generated_field = "18CB845DD4EFE6EE2073E71A0755D764")

    private static ServerHeader server;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:35.620 -0500", hash_original_field = "42C8CC112359A643E3AEC6584A18C02E", hash_generated_field = "2C7FA1926E1866F2BD0E0444E5B75063")


    private boolean testing = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:35.623 -0500", hash_original_field = "3A05141681835043707EF1785E49D1A7", hash_generated_field = "99E1394EBF258394BF69F9B0CF058AC0")

    
    private boolean strict  = true;

    /**
     * Creates a new instance of MessageFactoryImpl
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:35.638 -0500", hash_original_method = "1A6840ADE4B5EE3A7D8D47E6638687F6", hash_generated_method = "60B67C93F701D6B0EF25391D410DC2A2")
    
public MessageFactoryImpl() {
    }
    
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:35.632 -0500", hash_original_method = "EC510198678EBDAFC45D82B058FF4015", hash_generated_method = "A576CD55F5552CD6C33C357CE066752B")
    
public void setStrict(boolean strict) {
        this.strict = strict;
    }



    /**
     * This is for testing -- allows you to generate invalid requests
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:35.635 -0500", hash_original_method = "4DD923E2326A355154686E3A31C60072", hash_generated_method = "40A81F28D3B4860286BEEBA56D2BD3A6")
    
public void setTest(boolean flag) {
        this.testing = flag;
    }

    /**
     * Creates a new Request message of type specified by the method paramater,
     * containing the URI of the Request, the mandatory headers of the message
     * with a body in the form of a Java object and the body content type.
     *
     * @param requestURI -
     *            the new URI object of the requestURI value of this Message.
     * @param method -
     *            the new string of the method value of this Message.
     * @param callId -
     *            the new CallIdHeader object of the callId value of this
     *            Message.
     * @param cSeq -
     *            the new CSeqHeader object of the cSeq value of this Message.
     * @param from -
     *            the new FromHeader object of the from value of this Message.
     * @param to -
     *            the new ToHeader object of the to value of this Message.
     * @param via -
     *            the new List object of the ViaHeaders of this Message.
     * @param content -
     *            the new Object of the body content value of this Message.
     * @param contentType -
     *            the new ContentTypeHeader object of the content type value of
     *            this Message.
     * @throws ParseException
     *             which signals that an error has been reached unexpectedly
     *             while parsing the method or the body.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:35.641 -0500", hash_original_method = "D170EED829DCE544127E74E1BD3E45CA", hash_generated_method = "30AEC1A9B9DFA1C178954384FBDA7648")
    
public Request createRequest(javax.sip.address.URI requestURI,
            String method, CallIdHeader callId, CSeqHeader cSeq,
            FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards, ContentTypeHeader contentType,
            Object content) throws ParseException {
        if (requestURI == null || method == null || callId == null
                || cSeq == null || from == null || to == null || via == null
                || maxForwards == null || content == null
                || contentType == null)
            throw new NullPointerException("Null parameters");

        SIPRequest sipRequest = new SIPRequest();
        sipRequest.setRequestURI(requestURI);
        sipRequest.setMethod(method);
        sipRequest.setCallId(callId);
        sipRequest.setCSeq(cSeq);
        sipRequest.setFrom(from);
        sipRequest.setTo(to);
        sipRequest.setVia(via);
        sipRequest.setMaxForwards(maxForwards);
        sipRequest.setContent(content, contentType);
        if ( userAgent != null ) {
            sipRequest.setHeader(userAgent);
        }

        return sipRequest;
    }

    /**
     * Creates a new Request message of type specified by the method paramater,
     * containing the URI of the Request, the mandatory headers of the message
     * with a body in the form of a byte array and body content type.
     *
     * @param requestURI -
     *            the new URI object of the requestURI value of this Message.
     * @param method -
     *            the new string of the method value of this Message.
     * @param callId -
     *            the new CallIdHeader object of the callId value of this
     *            Message.
     * @param cSeq -
     *            the new CSeqHeader object of the cSeq value of this Message.
     * @param from -
     *            the new FromHeader object of the from value of this Message.
     * @param to -
     *            the new ToHeader object of the to value of this Message.
     * @param via -
     *            the new List object of the ViaHeaders of this Message.
     * @param content -
     *            the new byte array of the body content value of this Message.
     * @param contentType -
     *            the new ContentTypeHeader object of the content type value of
     *            this Message.
     * @throws ParseException
     *             which signals that an error has been reached unexpectedly
     *             while parsing the method or the body.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:35.644 -0500", hash_original_method = "41D839E013CFE4CFF0DE63311CBF1487", hash_generated_method = "F308EC2A20BF7839426DC70AA3A867C3")
    
public Request createRequest(URI requestURI, String method,
            CallIdHeader callId, CSeqHeader cSeq, FromHeader from, ToHeader to,
            List via, MaxForwardsHeader maxForwards, byte[] content,
            ContentTypeHeader contentType) throws ParseException {
        if (requestURI == null || method == null || callId == null
                || cSeq == null || from == null || to == null || via == null
                || maxForwards == null || content == null
                || contentType == null)
            throw new ParseException(
                    "JAIN-SIP Exception, some parameters are missing"
                            + ", unable to create the request", 0);

        SIPRequest sipRequest = new SIPRequest();
        sipRequest.setRequestURI(requestURI);
        sipRequest.setMethod(method);
        sipRequest.setCallId(callId);
        sipRequest.setCSeq(cSeq);
        sipRequest.setFrom(from);
        sipRequest.setTo(to);
        sipRequest.setVia(via);
        sipRequest.setMaxForwards(maxForwards);
        sipRequest.setHeader((ContentType) contentType);
        sipRequest.setMessageContent(content);
        if ( userAgent != null ) {
            sipRequest.setHeader(userAgent);
        }
        return sipRequest;
    }

    /**
     * Creates a new Request message of type specified by the method paramater,
     * containing the URI of the Request, the mandatory headers of the message.
     * This new Request does not contain a body.
     *
     * @param requestURI -
     *            the new URI object of the requestURI value of this Message.
     * @param method -
     *            the new string of the method value of this Message.
     * @param callId -
     *            the new CallIdHeader object of the callId value of this
     *            Message.
     * @param cSeq -
     *            the new CSeqHeader object of the cSeq value of this Message.
     * @param from -
     *            the new FromHeader object of the from value of this Message.
     * @param to -
     *            the new ToHeader object of the to value of this Message.
     * @param via -
     *            the new List object of the ViaHeaders of this Message.
     * @throws ParseException
     *             which signals that an error has been reached unexpectedly
     *             while parsing the method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:35.647 -0500", hash_original_method = "CE2184BFA0A9A5A1AA8BA0C0C675B13F", hash_generated_method = "F6885C253F66C4BA576C0F815CAC3106")
    
public Request createRequest(URI requestURI, String method,
            CallIdHeader callId, CSeqHeader cSeq, FromHeader from, ToHeader to,
            List via, MaxForwardsHeader maxForwards) throws ParseException {
        if (requestURI == null || method == null || callId == null
                || cSeq == null || from == null || to == null || via == null
                || maxForwards == null)
            throw new ParseException(
                    "JAIN-SIP Exception, some parameters are missing"
                            + ", unable to create the request", 0);

        SIPRequest sipRequest = new SIPRequest();
        sipRequest.setRequestURI(requestURI);
        sipRequest.setMethod(method);
        sipRequest.setCallId(callId);
        sipRequest.setCSeq(cSeq);
        sipRequest.setFrom(from);
        sipRequest.setTo(to);
        sipRequest.setVia(via);
        sipRequest.setMaxForwards(maxForwards);
        if (userAgent != null) {
            sipRequest.setHeader(userAgent);
        }

        return sipRequest;
    }

    // Standard Response Creation methods

    /**
     * Creates a new Response message of type specified by the statusCode
     * paramater, containing the mandatory headers of the message with a body in
     * the form of a Java object and the body content type.
     *
     * @param statusCode -
     *            the new integer of the statusCode value of this Message.
     * @param callId -
     *            the new CallIdHeader object of the callId value of this
     *            Message.
     * @param cSeq -
     *            the new CSeqHeader object of the cSeq value of this Message.
     * @param from -
     *            the new FromHeader object of the from value of this Message.
     * @param to -
     *            the new ToHeader object of the to value of this Message.
     * @param via -
     *            the new List object of the ViaHeaders of this Message.
     * @param content -
     *            the new Object of the body content value of this Message.
     * @param contentType -
     *            the new ContentTypeHeader object of the content type value of
     *            this Message.
     * @throws ParseException
     *             which signals that an error has been reached unexpectedly
     *             while parsing the statusCode or the body.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:35.650 -0500", hash_original_method = "ECF04A8977F592B6B34B54A1AB720125", hash_generated_method = "52AF108A6E18123F1928924A90B876C3")
    
public Response createResponse(int statusCode, CallIdHeader callId,
            CSeqHeader cSeq, FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards, Object content,
            ContentTypeHeader contentType) throws ParseException {
        if (callId == null || cSeq == null || from == null || to == null
                || via == null || maxForwards == null || content == null
                || contentType == null)
            throw new NullPointerException(" unable to create the response");

        SIPResponse sipResponse = new SIPResponse();
        StatusLine statusLine = new StatusLine();
        statusLine.setStatusCode(statusCode);
        String reasonPhrase = SIPResponse.getReasonPhrase(statusCode);
        //if (reasonPhrase == null)
        //  throw new ParseException(statusCode + " Unkown  ", 0);
        statusLine.setReasonPhrase(reasonPhrase);
        sipResponse.setStatusLine(statusLine);
        sipResponse.setCallId(callId);
        sipResponse.setCSeq(cSeq);
        sipResponse.setFrom(from);
        sipResponse.setTo(to);
        sipResponse.setVia(via);
        sipResponse.setMaxForwards(maxForwards);
        sipResponse.setContent(content, contentType);
        if (userAgent != null) {
            sipResponse.setHeader(userAgent);
        }
        return sipResponse;
    }

    /**
     * Creates a new Response message of type specified by the statusCode
     * paramater, containing the mandatory headers of the message with a body in
     * the form of a byte array and the body content type.
     *
     * @param statusCode -
     *            the new integer of the statusCode value of this Message.
     * @param callId -
     *            the new CallIdHeader object of the callId value of this
     *            Message.
     * @param cSeq -
     *            the new CSeqHeader object of the cSeq value of this Message.
     * @param from -
     *            the new FromHeader object of the from value of this Message.
     * @param to -
     *            the new ToHeader object of the to value of this Message.
     * @param via -
     *            the new List object of the ViaHeaders of this Message.
     * @param content -
     *            the new byte array of the body content value of this Message.
     * @param contentType -
     *            the new ContentTypeHeader object of the content type value of
     *            this Message.
     * @throws ParseException
     *             which signals that an error has been reached unexpectedly
     *             while parsing the statusCode or the body.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:35.653 -0500", hash_original_method = "A629704DD43A1871A6A3CE469581E96B", hash_generated_method = "2B90D17DC577F0EEFB1B5F7D9D1D4021")
    
public Response createResponse(int statusCode, CallIdHeader callId,
            CSeqHeader cSeq, FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards, byte[] content,
            ContentTypeHeader contentType) throws ParseException {
        if (callId == null || cSeq == null || from == null || to == null
                || via == null || maxForwards == null || content == null
                || contentType == null)
            throw new NullPointerException("Null params ");

        SIPResponse sipResponse = new SIPResponse();
        sipResponse.setStatusCode(statusCode);
        sipResponse.setCallId(callId);
        sipResponse.setCSeq(cSeq);
        sipResponse.setFrom(from);
        sipResponse.setTo(to);
        sipResponse.setVia(via);
        sipResponse.setMaxForwards(maxForwards);
        sipResponse.setHeader((ContentType) contentType);
        sipResponse.setMessageContent(content);
        if (userAgent != null) {
            sipResponse.setHeader(userAgent);
        }
        return sipResponse;
    }

    /**
     * Creates a new Response message of type specified by the statusCode
     * paramater, containing the mandatory headers of the message. This new
     * Response does not contain a body.
     *
     * @param statusCode -
     *            the new integer of the statusCode value of this Message.
     * @param callId -
     *            the new CallIdHeader object of the callId value of this
     *            Message.
     * @param cSeq -
     *            the new CSeqHeader object of the cSeq value of this Message.
     * @param from -
     *            the new FromHeader object of the from value of this Message.
     * @param to -
     *            the new ToHeader object of the to value of this Message.
     * @param via -
     *            the new List object of the ViaHeaders of this Message.
     * @throws ParseException
     *             which signals that an error has been reached unexpectedly
     *             while parsing the statusCode.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:35.656 -0500", hash_original_method = "A7A78E739513CEBA7D925C6C5ED3F852", hash_generated_method = "592D2A350CB8CD8F3C1412A7AEBE5273")
    
public Response createResponse(int statusCode, CallIdHeader callId,
            CSeqHeader cSeq, FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards) throws ParseException {
        if (callId == null || cSeq == null || from == null || to == null
                || via == null || maxForwards == null)
            throw new ParseException(
                    "JAIN-SIP Exception, some parameters are missing"
                            + ", unable to create the response", 0);

        SIPResponse sipResponse = new SIPResponse();
        sipResponse.setStatusCode(statusCode);
        sipResponse.setCallId(callId);
        sipResponse.setCSeq(cSeq);
        sipResponse.setFrom(from);
        sipResponse.setTo(to);
        sipResponse.setVia(via);
        sipResponse.setMaxForwards(maxForwards);
        if (userAgent != null) {
            sipResponse.setHeader(userAgent);
        }
        return sipResponse;
    }

    // Response Creation methods based on a Request

    /**
     * Creates a new Response message of type specified by the statusCode
     * paramater, based on a specific Request with a new body in the form of a
     * Java object and the body content type.
     *
     * @param statusCode -
     *            the new integer of the statusCode value of this Message.
     * @param request -
     *            the received Reqest object upon which to base the Response.
     * @param content -
     *            the new Object of the body content value of this Message.
     * @param contentType -
     *            the new ContentTypeHeader object of the content type value of
     *            this Message.
     * @throws ParseException
     *             which signals that an error has been reached unexpectedly
     *             while parsing the statusCode or the body.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:35.659 -0500", hash_original_method = "DD467BD39ED470F41EBF28C514D0DE9D", hash_generated_method = "14EE41019E4C43E3407A25417435EE5C")
    
public Response createResponse(int statusCode, Request request,
            ContentTypeHeader contentType, Object content)
            throws ParseException {
        if (request == null || content == null || contentType == null)
            throw new NullPointerException("null parameters");

        SIPRequest sipRequest = (SIPRequest) request;
        SIPResponse sipResponse = sipRequest.createResponse(statusCode);
        sipResponse.setContent(content, contentType);
        if (server != null) {
            sipResponse.setHeader(server);
        }
        return sipResponse;
    }

    /**
     * Creates a new Response message of type specified by the statusCode
     * paramater, based on a specific Request with a new body in the form of a
     * byte array and the body content type.
     *
     * @param statusCode -
     *            the new integer of the statusCode value of this Message.
     * @param request -
     *            the received Reqest object upon which to base the Response.
     * @param content -
     *            the new byte array of the body content value of this Message.
     * @param contentType -
     *            the new ContentTypeHeader object of the content type value of
     *            this Message.
     * @throws ParseException
     *             which signals that an error has been reached unexpectedly
     *             while parsing the statusCode or the body.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:35.662 -0500", hash_original_method = "8BDEFE6980DC0197E43DC25D26C94143", hash_generated_method = "C5424F955C0A4BA4C1BE08A81A337C61")
    
public Response createResponse(int statusCode, Request request,
            ContentTypeHeader contentType, byte[] content)
            throws ParseException {
        if (request == null || content == null || contentType == null)
            throw new NullPointerException("null Parameters");

        SIPRequest sipRequest = (SIPRequest) request;
        SIPResponse sipResponse = sipRequest.createResponse(statusCode);
        sipResponse.setHeader((ContentType) contentType);
        sipResponse.setMessageContent(content);
        if (server != null) {
            sipResponse.setHeader(server);
        }
        return sipResponse;
    }

    /**
     * Creates a new Response message of type specified by the statusCode
     * paramater, based on a specific Request message. This new Response does
     * not contain a body.
     *
     * @param statusCode -
     *            the new integer of the statusCode value of this Message.
     * @param request -
     *            the received Reqest object upon which to base the Response.
     * @throws ParseException
     *             which signals that an error has been reached unexpectedly
     *             while parsing the statusCode.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:35.665 -0500", hash_original_method = "C92B83B60B03C2CCAA2954674526918C", hash_generated_method = "C10A7094A82089B77B56F1557666283F")
    
public Response createResponse(int statusCode, Request request)
            throws ParseException {
        if (request == null)
            throw new NullPointerException("null parameters");

        // if (LogWriter.needsLogging)
        // LogWriter.logMessage("createResponse " + request);

        SIPRequest sipRequest = (SIPRequest) request;
        SIPResponse sipResponse = sipRequest.createResponse(statusCode);
        // Remove the content from the message (Bug report from
        // Antonis Karydas.
        sipResponse.removeContent();
        sipResponse.removeHeader(ContentTypeHeader.NAME);
        if (server != null) {
            sipResponse.setHeader(server);
        }
        return sipResponse;
    }

    /**
     * Creates a new Request message of type specified by the method paramater,
     * containing the URI of the Request, the mandatory headers of the message
     * with a body in the form of a byte array and body content type.
     *
     * @param requestURI -
     *            the new URI object of the requestURI value of this Message.
     * @param method -
     *            the new string of the method value of this Message.
     * @param callId -
     *            the new CallIdHeader object of the callId value of this
     *            Message.
     * @param cSeq -
     *            the new CSeqHeader object of the cSeq value of this Message.
     * @param from -
     *            the new FromHeader object of the from value of this Message.
     * @param to -
     *            the new ToHeader object of the to value of this Message.
     * @param via -
     *            the new List object of the ViaHeaders of this Message.
     * @param contentType -
     *            the new ContentTypeHeader object of the content type value of
     *            this Message.
     * @param content -
     *            the new byte array of the body content value of this Message.
     * @throws ParseException
     *             which signals that an error has been reached unexpectedly
     *             while parsing the method or the body.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:35.668 -0500", hash_original_method = "CA414FF436476B2FF81777F9CBBFC86F", hash_generated_method = "F6306F7924D61C0659C380C9D4C4BD69")
    
public Request createRequest(javax.sip.address.URI requestURI,
            String method, CallIdHeader callId, CSeqHeader cSeq,
            FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards, ContentTypeHeader contentType,
            byte[] content) throws ParseException {
        if (requestURI == null || method == null || callId == null
                || cSeq == null || from == null || to == null || via == null
                || maxForwards == null || content == null
                || contentType == null)
            throw new NullPointerException("missing parameters");

        SIPRequest sipRequest = new SIPRequest();
        sipRequest.setRequestURI(requestURI);
        sipRequest.setMethod(method);
        sipRequest.setCallId(callId);
        sipRequest.setCSeq(cSeq);
        sipRequest.setFrom(from);
        sipRequest.setTo(to);
        sipRequest.setVia(via);
        sipRequest.setMaxForwards(maxForwards);
        sipRequest.setContent(content, contentType);
        if (userAgent != null) {
            sipRequest.setHeader(userAgent);
        }
        return sipRequest;
    }

    /**
     * Creates a new Response message of type specified by the statusCode
     * paramater, containing the mandatory headers of the message with a body in
     * the form of a Java object and the body content type.
     *
     * @param statusCode
     *            the new integer of the statusCode value of this Message.
     * @param callId
     *            the new CallIdHeader object of the callId value of this
     *            Message.
     * @param cSeq
     *            the new CSeqHeader object of the cSeq value of this Message.
     * @param from
     *            the new FromHeader object of the from value of this Message.
     * @param to
     *            the new ToHeader object of the to value of this Message.
     * @param via
     *            the new List object of the ViaHeaders of this Message.
     * @param contentType
     *            the new ContentTypeHeader object of the content type value of
     *            this Message.
     * @param content
     *            the new Object of the body content value of this Message.
     * @throws ParseException
     *             which signals that an error has been reached unexpectedly
     *             while parsing the statusCode or the body.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:35.671 -0500", hash_original_method = "F442F4A57014D62724BCC0FFB03CA549", hash_generated_method = "7CBF6AECDEAC88AF1032F8EF8101BFA7")
    
public Response createResponse(int statusCode, CallIdHeader callId,
            CSeqHeader cSeq, FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards, ContentTypeHeader contentType,
            Object content) throws ParseException {
        if (callId == null || cSeq == null || from == null || to == null
                || via == null || maxForwards == null || content == null
                || contentType == null)
            throw new NullPointerException("missing parameters");
        SIPResponse sipResponse = new SIPResponse();
        StatusLine statusLine = new StatusLine();
        statusLine.setStatusCode(statusCode);
        String reason = SIPResponse.getReasonPhrase(statusCode);
        if (reason == null)
            throw new ParseException(statusCode + " Unknown", 0);
        statusLine.setReasonPhrase(reason);
        sipResponse.setStatusLine(statusLine);
        sipResponse.setCallId(callId);
        sipResponse.setCSeq(cSeq);
        sipResponse.setFrom(from);
        sipResponse.setTo(to);
        sipResponse.setVia(via);
        sipResponse.setContent(content, contentType);
        if ( userAgent != null) {
            sipResponse.setHeader(userAgent);
        }
        return sipResponse;

    }

    /**
     * Creates a new Response message of type specified by the statusCode
     * paramater, containing the mandatory headers of the message with a body in
     * the form of a byte array and the body content type.
     *
     * @param statusCode
     *            the new integer of the statusCode value of this Message.
     * @param callId
     *            the new CallIdHeader object of the callId value of this
     *            Message.
     * @param cSeq
     *            the new CSeqHeader object of the cSeq value of this Message.
     * @param from
     *            the new FromHeader object of the from value of this Message.
     * @param to
     *            the new ToHeader object of the to value of this Message.
     * @param via
     *            the new List object of the ViaHeaders of this Message.
     * @param contentType
     *            the new ContentTypeHeader object of the content type value of
     *            this Message.
     * @param content
     *            the new byte array of the body content value of this Message.
     * @throws ParseException
     *             which signals that an error has been reached unexpectedly
     *             while parsing the statusCode or the body.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:35.674 -0500", hash_original_method = "6F9C1831E48382AD1DFACEE268167E8E", hash_generated_method = "D589AA3DC448C821179FDC12FF1C0570")
    
public Response createResponse(int statusCode, CallIdHeader callId,
            CSeqHeader cSeq, FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards, ContentTypeHeader contentType,
            byte[] content) throws ParseException {
        if (callId == null || cSeq == null || from == null || to == null
                || via == null || maxForwards == null || content == null
                || contentType == null)
            throw new NullPointerException("missing parameters");
        SIPResponse sipResponse = new SIPResponse();
        StatusLine statusLine = new StatusLine();
        statusLine.setStatusCode(statusCode);
        String reason = SIPResponse.getReasonPhrase(statusCode);
        if (reason == null)
            throw new ParseException(statusCode + " : Unknown", 0);
        statusLine.setReasonPhrase(reason);
        sipResponse.setStatusLine(statusLine);
        sipResponse.setCallId(callId);
        sipResponse.setCSeq(cSeq);
        sipResponse.setFrom(from);
        sipResponse.setTo(to);
        sipResponse.setVia(via);
        sipResponse.setContent(content, contentType);
        if ( userAgent != null) {
            sipResponse.setHeader(userAgent);
        }
        return sipResponse;
    }

    /**
     * Create a request from a string. Conveniance method for UACs that want to
     * create an outgoing request from a string. Only the headers of the request
     * should be included in the String that is supplied to this method.
     *
     * @param requestString --
     *            string from which to create the message null string returns an
     *            empty message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:35.681 -0500", hash_original_method = "973FDAB995A16C4007672A92A7C4D585", hash_generated_method = "755D25DCA1AE9A93D4537C572B1FE3F0")
    
public javax.sip.message.Request createRequest(String requestString)
            throws java.text.ParseException {
        if (requestString == null || requestString.equals("")) {
            SIPRequest retval = new SIPRequest();
            retval.setNullRequest();
            return retval;
        }

        StringMsgParser smp = new StringMsgParser();
        smp.setStrict(this.strict);

        /*
         * This allows you to catch parse exceptions and create invalid messages
         * if you want.
         */
        ParseExceptionListener parseExceptionListener = new ParseExceptionListener() {

            public void handleException(ParseException ex,
                    SIPMessage sipMessage, Class headerClass,
                    String headerText, String messageText)
                    throws ParseException {
                // Rethrow the error for the essential headers. Otherwise bad
                // headers are simply
                // recorded in the message.
                if (testing) {
                    if (headerClass == From.class || headerClass == To.class
                            || headerClass == CallID.class
                            || headerClass == MaxForwards.class
                            || headerClass == Via.class
                            || headerClass == RequestLine.class
                            || headerClass == StatusLine.class
                            || headerClass == CSeq.class)
                        throw ex;

                    sipMessage.addUnparsed(headerText);
                }

            }

        };

        if (this.testing)
            smp.setParseExceptionListener(parseExceptionListener);

        SIPMessage sipMessage = smp.parseSIPMessage(requestString);

        if (!(sipMessage instanceof SIPRequest))
            throw new ParseException(requestString, 0);

        return (SIPRequest) sipMessage;
    }

    /**
     * Create a response from a string
     *
     * @param responseString --
     *            string from which to create the message null string returns an
     *            empty message.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:35.684 -0500", hash_original_method = "8329107E7147BB5F0DCDAFE41A50D91D", hash_generated_method = "4E0D90FADC346D513AFBD89460FD3736")
    
public Response createResponse(String responseString)
            throws java.text.ParseException {
        if (responseString == null)
            return new SIPResponse();

        StringMsgParser smp = new StringMsgParser();

        SIPMessage sipMessage = smp.parseSIPMessage(responseString);

        if (!(sipMessage instanceof SIPResponse))
            throw new ParseException(responseString, 0);

        return (SIPResponse) sipMessage;
    }

    /**
     * Set the common UserAgent header for all requests created from this message factory.
     * This header is applied to all Messages created from this Factory object except those
     * that take String for an argument and create Message from the given String.
     *
     * @param userAgent -- the user agent header to set.
     *
     * @since 2.0
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:35.686 -0500", hash_original_method = "F6370A15361A54B6EDEFA955061D514D", hash_generated_method = "EE6F50D119E56F8B58DAC14A0A46D6CB")
    
public void setDefaultUserAgentHeader(UserAgentHeader userAgent) {
        MessageFactoryImpl.userAgent = userAgent;
    }

    /**
     * Set the common Server header for all responses created from this message factory.
     * This header is applied to all Messages created from this Factory object except those
     * that take String for an argument and create Message from the given String.
     *
     * @param userAgent -- the user agent header to set.
     *
     * @since 2.0
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:35.689 -0500", hash_original_method = "86783F390E61522F639FC7DF78604B5D", hash_generated_method = "EE4282027359EE5B9E724AB36B5B2FA8")
    
public void setDefaultServerHeader(ServerHeader server) {
        MessageFactoryImpl.server = server;
    }


    /**
     * Set default charset used for encoding String content.
     * @param charset
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:35.696 -0500", hash_original_method = "7A37B9B6512C6512FDCFFA4B5CE85073", hash_generated_method = "7823BC126FCEC5FEA79BE7FF64141AC1")
    
public  void setDefaultContentEncodingCharset(String charset) throws NullPointerException,
    IllegalArgumentException {
        if (charset == null ) throw new NullPointerException ("Null argument!");
        MessageFactoryImpl.defaultContentEncodingCharset = charset;

    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:35.701 -0500", hash_original_method = "86E485BB3E030FD77D4D70ABB6598D25", hash_generated_method = "BA29B266289A492235B2F750E3C5807F")
    
public MultipartMimeContent createMultipartMimeContent(ContentTypeHeader multipartMimeCth,
            String[] contentType,
            String[] contentSubtype, 
            String[] contentBody) {
        String boundary = multipartMimeCth.getParameter("boundary");
        MultipartMimeContentImpl retval = new MultipartMimeContentImpl(multipartMimeCth);
        for (int i = 0 ;  i < contentType.length; i++ ) {
            ContentTypeHeader cth = new ContentType(contentType[i],contentSubtype[i]);
            ContentImpl contentImpl  = new ContentImpl(contentBody[i],boundary);
            contentImpl.setContentTypeHeader(cth);
            retval.add(contentImpl);
        }
        return retval;
    }
    // orphaned legacy method
    public void handleException(ParseException ex,
                    SIPMessage sipMessage, Class headerClass,
                    String headerText, String messageText)
                    throws ParseException {
                if (testing) {
                    if (headerClass == From.class || headerClass == To.class
                            || headerClass == CallID.class
                            || headerClass == MaxForwards.class
                            || headerClass == Via.class
                            || headerClass == RequestLine.class
                            || headerClass == StatusLine.class
                            || headerClass == CSeq.class)
                        throw ex;
                    sipMessage.addUnparsed(headerText);
                }
            }
    
}

