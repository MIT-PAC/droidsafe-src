package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.*;
import java.util.LinkedList;
import java.util.List;
import gov.nist.javax.sip.header.*;
import javax.sip.message.*;
import javax.sip.address.*;
import gov.nist.javax.sip.parser.*;

public class MessageFactoryImpl implements MessageFactory, MessageFactoryExt {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.792 -0400", hash_original_field = "38E609FC75B0851ECF8F36A17766E912", hash_generated_field = "2C7FA1926E1866F2BD0E0444E5B75063")

    private boolean testing = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.792 -0400", hash_original_field = "3C8E87563DE29D665DA1974EB520FC45", hash_generated_field = "99E1394EBF258394BF69F9B0CF058AC0")

    private boolean strict = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.793 -0400", hash_original_method = "1A6840ADE4B5EE3A7D8D47E6638687F6", hash_generated_method = "F0B1C59F76B6CADA6430628AA379007A")
    public  MessageFactoryImpl() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.793 -0400", hash_original_method = "EC510198678EBDAFC45D82B058FF4015", hash_generated_method = "C6177A909B65F45400E04967CBC68CBF")
    public void setStrict(boolean strict) {
        this.strict = strict;
        // ---------- Original Method ----------
        //this.strict = strict;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.793 -0400", hash_original_method = "4DD923E2326A355154686E3A31C60072", hash_generated_method = "5E20E9296F487C26CA8E7594FEC2C6CF")
    public void setTest(boolean flag) {
        this.testing = flag;
        // ---------- Original Method ----------
        //this.testing = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.794 -0400", hash_original_method = "D170EED829DCE544127E74E1BD3E45CA", hash_generated_method = "C9F1F318FE6CE4388B3CEF442DD88533")
    public Request createRequest(javax.sip.address.URI requestURI,
            String method, CallIdHeader callId, CSeqHeader cSeq,
            FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards, ContentTypeHeader contentType,
            Object content) throws ParseException {
        Request varB4EAC82CA7396A68D541C85D26508E83_1535369964 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null parameters");
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
        {
            sipRequest.setHeader(userAgent);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1535369964 = sipRequest;
        addTaint(requestURI.getTaint());
        addTaint(method.getTaint());
        addTaint(callId.getTaint());
        addTaint(cSeq.getTaint());
        addTaint(from.getTaint());
        addTaint(to.getTaint());
        addTaint(via.getTaint());
        addTaint(maxForwards.getTaint());
        addTaint(contentType.getTaint());
        addTaint(content.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1535369964.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1535369964;
        // ---------- Original Method ----------
        //if (requestURI == null || method == null || callId == null
                //|| cSeq == null || from == null || to == null || via == null
                //|| maxForwards == null || content == null
                //|| contentType == null)
            //throw new NullPointerException("Null parameters");
        //SIPRequest sipRequest = new SIPRequest();
        //sipRequest.setRequestURI(requestURI);
        //sipRequest.setMethod(method);
        //sipRequest.setCallId(callId);
        //sipRequest.setCSeq(cSeq);
        //sipRequest.setFrom(from);
        //sipRequest.setTo(to);
        //sipRequest.setVia(via);
        //sipRequest.setMaxForwards(maxForwards);
        //sipRequest.setContent(content, contentType);
        //if ( userAgent != null ) {
            //sipRequest.setHeader(userAgent);
        //}
        //return sipRequest;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.795 -0400", hash_original_method = "41D839E013CFE4CFF0DE63311CBF1487", hash_generated_method = "871A8BE4E3797563A953CBA6CDF41C2B")
    public Request createRequest(URI requestURI, String method,
            CallIdHeader callId, CSeqHeader cSeq, FromHeader from, ToHeader to,
            List via, MaxForwardsHeader maxForwards, byte[] content,
            ContentTypeHeader contentType) throws ParseException {
        Request varB4EAC82CA7396A68D541C85D26508E83_824089896 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new ParseException(
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
        {
            sipRequest.setHeader(userAgent);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_824089896 = sipRequest;
        addTaint(requestURI.getTaint());
        addTaint(method.getTaint());
        addTaint(callId.getTaint());
        addTaint(cSeq.getTaint());
        addTaint(from.getTaint());
        addTaint(to.getTaint());
        addTaint(via.getTaint());
        addTaint(maxForwards.getTaint());
        addTaint(content[0]);
        addTaint(contentType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_824089896.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_824089896;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.797 -0400", hash_original_method = "CE2184BFA0A9A5A1AA8BA0C0C675B13F", hash_generated_method = "92BFD3F1B45FA967DF2149DDB93CD8C3")
    public Request createRequest(URI requestURI, String method,
            CallIdHeader callId, CSeqHeader cSeq, FromHeader from, ToHeader to,
            List via, MaxForwardsHeader maxForwards) throws ParseException {
        Request varB4EAC82CA7396A68D541C85D26508E83_715620726 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new ParseException(
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
        {
            sipRequest.setHeader(userAgent);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_715620726 = sipRequest;
        addTaint(requestURI.getTaint());
        addTaint(method.getTaint());
        addTaint(callId.getTaint());
        addTaint(cSeq.getTaint());
        addTaint(from.getTaint());
        addTaint(to.getTaint());
        addTaint(via.getTaint());
        addTaint(maxForwards.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_715620726.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_715620726;
        // ---------- Original Method ----------
        //if (requestURI == null || method == null || callId == null
                //|| cSeq == null || from == null || to == null || via == null
                //|| maxForwards == null)
            //throw new ParseException(
                    //"JAIN-SIP Exception, some parameters are missing"
                            //+ ", unable to create the request", 0);
        //SIPRequest sipRequest = new SIPRequest();
        //sipRequest.setRequestURI(requestURI);
        //sipRequest.setMethod(method);
        //sipRequest.setCallId(callId);
        //sipRequest.setCSeq(cSeq);
        //sipRequest.setFrom(from);
        //sipRequest.setTo(to);
        //sipRequest.setVia(via);
        //sipRequest.setMaxForwards(maxForwards);
        //if (userAgent != null) {
            //sipRequest.setHeader(userAgent);
        //}
        //return sipRequest;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.798 -0400", hash_original_method = "ECF04A8977F592B6B34B54A1AB720125", hash_generated_method = "C35C42299DD907CCB33C2FF7F77CBD5C")
    public Response createResponse(int statusCode, CallIdHeader callId,
            CSeqHeader cSeq, FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards, Object content,
            ContentTypeHeader contentType) throws ParseException {
        Response varB4EAC82CA7396A68D541C85D26508E83_1918361410 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(" unable to create the response");
        SIPResponse sipResponse = new SIPResponse();
        StatusLine statusLine = new StatusLine();
        statusLine.setStatusCode(statusCode);
        String reasonPhrase = SIPResponse.getReasonPhrase(statusCode);
        statusLine.setReasonPhrase(reasonPhrase);
        sipResponse.setStatusLine(statusLine);
        sipResponse.setCallId(callId);
        sipResponse.setCSeq(cSeq);
        sipResponse.setFrom(from);
        sipResponse.setTo(to);
        sipResponse.setVia(via);
        sipResponse.setMaxForwards(maxForwards);
        sipResponse.setContent(content, contentType);
        {
            sipResponse.setHeader(userAgent);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1918361410 = sipResponse;
        addTaint(statusCode);
        addTaint(callId.getTaint());
        addTaint(cSeq.getTaint());
        addTaint(from.getTaint());
        addTaint(to.getTaint());
        addTaint(via.getTaint());
        addTaint(maxForwards.getTaint());
        addTaint(content.getTaint());
        addTaint(contentType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1918361410.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1918361410;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.799 -0400", hash_original_method = "A629704DD43A1871A6A3CE469581E96B", hash_generated_method = "FDBF3BAA4E07982588857AB1AD801149")
    public Response createResponse(int statusCode, CallIdHeader callId,
            CSeqHeader cSeq, FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards, byte[] content,
            ContentTypeHeader contentType) throws ParseException {
        Response varB4EAC82CA7396A68D541C85D26508E83_1986927058 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null params ");
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
        {
            sipResponse.setHeader(userAgent);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1986927058 = sipResponse;
        addTaint(statusCode);
        addTaint(callId.getTaint());
        addTaint(cSeq.getTaint());
        addTaint(from.getTaint());
        addTaint(to.getTaint());
        addTaint(via.getTaint());
        addTaint(maxForwards.getTaint());
        addTaint(content[0]);
        addTaint(contentType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1986927058.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1986927058;
        // ---------- Original Method ----------
        //if (callId == null || cSeq == null || from == null || to == null
                //|| via == null || maxForwards == null || content == null
                //|| contentType == null)
            //throw new NullPointerException("Null params ");
        //SIPResponse sipResponse = new SIPResponse();
        //sipResponse.setStatusCode(statusCode);
        //sipResponse.setCallId(callId);
        //sipResponse.setCSeq(cSeq);
        //sipResponse.setFrom(from);
        //sipResponse.setTo(to);
        //sipResponse.setVia(via);
        //sipResponse.setMaxForwards(maxForwards);
        //sipResponse.setHeader((ContentType) contentType);
        //sipResponse.setMessageContent(content);
        //if (userAgent != null) {
            //sipResponse.setHeader(userAgent);
        //}
        //return sipResponse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.800 -0400", hash_original_method = "A7A78E739513CEBA7D925C6C5ED3F852", hash_generated_method = "D766849F4D2AE7C424A641ADBC7E63C1")
    public Response createResponse(int statusCode, CallIdHeader callId,
            CSeqHeader cSeq, FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards) throws ParseException {
        Response varB4EAC82CA7396A68D541C85D26508E83_1707267073 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new ParseException(
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
        {
            sipResponse.setHeader(userAgent);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1707267073 = sipResponse;
        addTaint(statusCode);
        addTaint(callId.getTaint());
        addTaint(cSeq.getTaint());
        addTaint(from.getTaint());
        addTaint(to.getTaint());
        addTaint(via.getTaint());
        addTaint(maxForwards.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1707267073.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1707267073;
        // ---------- Original Method ----------
        //if (callId == null || cSeq == null || from == null || to == null
                //|| via == null || maxForwards == null)
            //throw new ParseException(
                    //"JAIN-SIP Exception, some parameters are missing"
                            //+ ", unable to create the response", 0);
        //SIPResponse sipResponse = new SIPResponse();
        //sipResponse.setStatusCode(statusCode);
        //sipResponse.setCallId(callId);
        //sipResponse.setCSeq(cSeq);
        //sipResponse.setFrom(from);
        //sipResponse.setTo(to);
        //sipResponse.setVia(via);
        //sipResponse.setMaxForwards(maxForwards);
        //if (userAgent != null) {
            //sipResponse.setHeader(userAgent);
        //}
        //return sipResponse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.801 -0400", hash_original_method = "DD467BD39ED470F41EBF28C514D0DE9D", hash_generated_method = "346255538C6819671739B45E902456A5")
    public Response createResponse(int statusCode, Request request,
            ContentTypeHeader contentType, Object content) throws ParseException {
        Response varB4EAC82CA7396A68D541C85D26508E83_1613191162 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null parameters");
        SIPRequest sipRequest = (SIPRequest) request;
        SIPResponse sipResponse = sipRequest.createResponse(statusCode);
        sipResponse.setContent(content, contentType);
        {
            sipResponse.setHeader(server);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1613191162 = sipResponse;
        addTaint(statusCode);
        addTaint(request.getTaint());
        addTaint(contentType.getTaint());
        addTaint(content.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1613191162.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1613191162;
        // ---------- Original Method ----------
        //if (request == null || content == null || contentType == null)
            //throw new NullPointerException("null parameters");
        //SIPRequest sipRequest = (SIPRequest) request;
        //SIPResponse sipResponse = sipRequest.createResponse(statusCode);
        //sipResponse.setContent(content, contentType);
        //if (server != null) {
            //sipResponse.setHeader(server);
        //}
        //return sipResponse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.801 -0400", hash_original_method = "8BDEFE6980DC0197E43DC25D26C94143", hash_generated_method = "69559212267A712BC8DF37CF8A6BA9EF")
    public Response createResponse(int statusCode, Request request,
            ContentTypeHeader contentType, byte[] content) throws ParseException {
        Response varB4EAC82CA7396A68D541C85D26508E83_2132407167 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null Parameters");
        SIPRequest sipRequest = (SIPRequest) request;
        SIPResponse sipResponse = sipRequest.createResponse(statusCode);
        sipResponse.setHeader((ContentType) contentType);
        sipResponse.setMessageContent(content);
        {
            sipResponse.setHeader(server);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2132407167 = sipResponse;
        addTaint(statusCode);
        addTaint(request.getTaint());
        addTaint(contentType.getTaint());
        addTaint(content[0]);
        varB4EAC82CA7396A68D541C85D26508E83_2132407167.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2132407167;
        // ---------- Original Method ----------
        //if (request == null || content == null || contentType == null)
            //throw new NullPointerException("null Parameters");
        //SIPRequest sipRequest = (SIPRequest) request;
        //SIPResponse sipResponse = sipRequest.createResponse(statusCode);
        //sipResponse.setHeader((ContentType) contentType);
        //sipResponse.setMessageContent(content);
        //if (server != null) {
            //sipResponse.setHeader(server);
        //}
        //return sipResponse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.802 -0400", hash_original_method = "C92B83B60B03C2CCAA2954674526918C", hash_generated_method = "269F700065B848F239D2A31DC475B798")
    public Response createResponse(int statusCode, Request request) throws ParseException {
        Response varB4EAC82CA7396A68D541C85D26508E83_47239397 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null parameters");
        SIPRequest sipRequest = (SIPRequest) request;
        SIPResponse sipResponse = sipRequest.createResponse(statusCode);
        sipResponse.removeContent();
        sipResponse.removeHeader(ContentTypeHeader.NAME);
        {
            sipResponse.setHeader(server);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_47239397 = sipResponse;
        addTaint(statusCode);
        addTaint(request.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_47239397.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_47239397;
        // ---------- Original Method ----------
        //if (request == null)
            //throw new NullPointerException("null parameters");
        //SIPRequest sipRequest = (SIPRequest) request;
        //SIPResponse sipResponse = sipRequest.createResponse(statusCode);
        //sipResponse.removeContent();
        //sipResponse.removeHeader(ContentTypeHeader.NAME);
        //if (server != null) {
            //sipResponse.setHeader(server);
        //}
        //return sipResponse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.803 -0400", hash_original_method = "CA414FF436476B2FF81777F9CBBFC86F", hash_generated_method = "FB12164C169F9BFE24E599FCFD6FDF94")
    public Request createRequest(javax.sip.address.URI requestURI,
            String method, CallIdHeader callId, CSeqHeader cSeq,
            FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards, ContentTypeHeader contentType,
            byte[] content) throws ParseException {
        Request varB4EAC82CA7396A68D541C85D26508E83_1010775828 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("missing parameters");
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
        {
            sipRequest.setHeader(userAgent);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1010775828 = sipRequest;
        addTaint(requestURI.getTaint());
        addTaint(method.getTaint());
        addTaint(callId.getTaint());
        addTaint(cSeq.getTaint());
        addTaint(from.getTaint());
        addTaint(to.getTaint());
        addTaint(via.getTaint());
        addTaint(maxForwards.getTaint());
        addTaint(contentType.getTaint());
        addTaint(content[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1010775828.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1010775828;
        // ---------- Original Method ----------
        //if (requestURI == null || method == null || callId == null
                //|| cSeq == null || from == null || to == null || via == null
                //|| maxForwards == null || content == null
                //|| contentType == null)
            //throw new NullPointerException("missing parameters");
        //SIPRequest sipRequest = new SIPRequest();
        //sipRequest.setRequestURI(requestURI);
        //sipRequest.setMethod(method);
        //sipRequest.setCallId(callId);
        //sipRequest.setCSeq(cSeq);
        //sipRequest.setFrom(from);
        //sipRequest.setTo(to);
        //sipRequest.setVia(via);
        //sipRequest.setMaxForwards(maxForwards);
        //sipRequest.setContent(content, contentType);
        //if (userAgent != null) {
            //sipRequest.setHeader(userAgent);
        //}
        //return sipRequest;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.804 -0400", hash_original_method = "F442F4A57014D62724BCC0FFB03CA549", hash_generated_method = "B99078C3024ECFD7050DB131133E1B14")
    public Response createResponse(int statusCode, CallIdHeader callId,
            CSeqHeader cSeq, FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards, ContentTypeHeader contentType,
            Object content) throws ParseException {
        Response varB4EAC82CA7396A68D541C85D26508E83_620497255 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("missing parameters");
        SIPResponse sipResponse = new SIPResponse();
        StatusLine statusLine = new StatusLine();
        statusLine.setStatusCode(statusCode);
        String reason = SIPResponse.getReasonPhrase(statusCode);
        if (DroidSafeAndroidRuntime.control) throw new ParseException(statusCode + " Unknown", 0);
        statusLine.setReasonPhrase(reason);
        sipResponse.setStatusLine(statusLine);
        sipResponse.setCallId(callId);
        sipResponse.setCSeq(cSeq);
        sipResponse.setFrom(from);
        sipResponse.setTo(to);
        sipResponse.setVia(via);
        sipResponse.setContent(content, contentType);
        {
            sipResponse.setHeader(userAgent);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_620497255 = sipResponse;
        addTaint(statusCode);
        addTaint(callId.getTaint());
        addTaint(cSeq.getTaint());
        addTaint(from.getTaint());
        addTaint(to.getTaint());
        addTaint(via.getTaint());
        addTaint(maxForwards.getTaint());
        addTaint(contentType.getTaint());
        addTaint(content.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_620497255.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_620497255;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.806 -0400", hash_original_method = "6F9C1831E48382AD1DFACEE268167E8E", hash_generated_method = "DADF3519C3379AF56ED533C072DAC9A1")
    public Response createResponse(int statusCode, CallIdHeader callId,
            CSeqHeader cSeq, FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards, ContentTypeHeader contentType,
            byte[] content) throws ParseException {
        Response varB4EAC82CA7396A68D541C85D26508E83_662837927 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("missing parameters");
        SIPResponse sipResponse = new SIPResponse();
        StatusLine statusLine = new StatusLine();
        statusLine.setStatusCode(statusCode);
        String reason = SIPResponse.getReasonPhrase(statusCode);
        if (DroidSafeAndroidRuntime.control) throw new ParseException(statusCode + " : Unknown", 0);
        statusLine.setReasonPhrase(reason);
        sipResponse.setStatusLine(statusLine);
        sipResponse.setCallId(callId);
        sipResponse.setCSeq(cSeq);
        sipResponse.setFrom(from);
        sipResponse.setTo(to);
        sipResponse.setVia(via);
        sipResponse.setContent(content, contentType);
        {
            sipResponse.setHeader(userAgent);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_662837927 = sipResponse;
        addTaint(statusCode);
        addTaint(callId.getTaint());
        addTaint(cSeq.getTaint());
        addTaint(from.getTaint());
        addTaint(to.getTaint());
        addTaint(via.getTaint());
        addTaint(maxForwards.getTaint());
        addTaint(contentType.getTaint());
        addTaint(content[0]);
        varB4EAC82CA7396A68D541C85D26508E83_662837927.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_662837927;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.810 -0400", hash_original_method = "973FDAB995A16C4007672A92A7C4D585", hash_generated_method = "76EE8A21263C008D6DD98C9D792932A8")
    public javax.sip.message.Request createRequest(String requestString) throws java.text.ParseException {
        javax.sip.message.Request varB4EAC82CA7396A68D541C85D26508E83_1023673346 = null; //Variable for return #1
        javax.sip.message.Request varB4EAC82CA7396A68D541C85D26508E83_1743239063 = null; //Variable for return #2
        {
            boolean varDB1EE064EEBA27818A326B01B2A660EE_984277787 = (requestString == null || requestString.equals(""));
            {
                SIPRequest retval = new SIPRequest();
                retval.setNullRequest();
                varB4EAC82CA7396A68D541C85D26508E83_1023673346 = retval;
            } //End block
        } //End collapsed parenthetic
        StringMsgParser smp = new StringMsgParser();
        smp.setStrict(this.strict);
        ParseExceptionListener parseExceptionListener = new ParseExceptionListener() {
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
        };
        smp.setParseExceptionListener(parseExceptionListener);
        SIPMessage sipMessage = smp.parseSIPMessage(requestString);
        if (DroidSafeAndroidRuntime.control) throw new ParseException(requestString, 0);
        varB4EAC82CA7396A68D541C85D26508E83_1743239063 = (SIPRequest) sipMessage;
        addTaint(requestString.getTaint());
        javax.sip.message.Request varA7E53CE21691AB073D9660D615818899_1292076312; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1292076312 = varB4EAC82CA7396A68D541C85D26508E83_1023673346;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1292076312 = varB4EAC82CA7396A68D541C85D26508E83_1743239063;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1292076312.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1292076312;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.811 -0400", hash_original_method = "8329107E7147BB5F0DCDAFE41A50D91D", hash_generated_method = "0125ACBA0D13A0C1DFA70705D058409A")
    public Response createResponse(String responseString) throws java.text.ParseException {
        Response varB4EAC82CA7396A68D541C85D26508E83_1109981784 = null; //Variable for return #1
        Response varB4EAC82CA7396A68D541C85D26508E83_1264684243 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1109981784 = new SIPResponse();
        StringMsgParser smp = new StringMsgParser();
        SIPMessage sipMessage = smp.parseSIPMessage(responseString);
        if (DroidSafeAndroidRuntime.control) throw new ParseException(responseString, 0);
        varB4EAC82CA7396A68D541C85D26508E83_1264684243 = (SIPResponse) sipMessage;
        addTaint(responseString.getTaint());
        Response varA7E53CE21691AB073D9660D615818899_245096753; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_245096753 = varB4EAC82CA7396A68D541C85D26508E83_1109981784;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_245096753 = varB4EAC82CA7396A68D541C85D26508E83_1264684243;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_245096753.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_245096753;
        // ---------- Original Method ----------
        //if (responseString == null)
            //return new SIPResponse();
        //StringMsgParser smp = new StringMsgParser();
        //SIPMessage sipMessage = smp.parseSIPMessage(responseString);
        //if (!(sipMessage instanceof SIPResponse))
            //throw new ParseException(responseString, 0);
        //return (SIPResponse) sipMessage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.813 -0400", hash_original_method = "F6370A15361A54B6EDEFA955061D514D", hash_generated_method = "D99C4B413F6525F8354FC26B58F4490C")
    public void setDefaultUserAgentHeader(UserAgentHeader userAgent) {
        MessageFactoryImpl.userAgent = userAgent;
        addTaint(userAgent.getTaint());
        // ---------- Original Method ----------
        //MessageFactoryImpl.userAgent = userAgent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.815 -0400", hash_original_method = "86783F390E61522F639FC7DF78604B5D", hash_generated_method = "7101A99E0E3F47ED3CED2E9A54AB561C")
    public void setDefaultServerHeader(ServerHeader server) {
        MessageFactoryImpl.server = server;
        addTaint(server.getTaint());
        // ---------- Original Method ----------
        //MessageFactoryImpl.server = server;
    }

    
    public static UserAgentHeader getDefaultUserAgentHeader() {
        return userAgent;
    }

    
    public static ServerHeader getDefaultServerHeader() {
        return server;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.817 -0400", hash_original_method = "7A37B9B6512C6512FDCFFA4B5CE85073", hash_generated_method = "1AA4A1F2BFA76A53E8FBCD4030989704")
    public void setDefaultContentEncodingCharset(String charset) throws NullPointerException,
    IllegalArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException ("Null argument!");
        MessageFactoryImpl.defaultContentEncodingCharset = charset;
        addTaint(charset.getTaint());
        // ---------- Original Method ----------
        //if (charset == null ) throw new NullPointerException ("Null argument!");
        //MessageFactoryImpl.defaultContentEncodingCharset = charset;
    }

    
    public static String getDefaultContentEncodingCharset() {
        return MessageFactoryImpl.defaultContentEncodingCharset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.820 -0400", hash_original_method = "86E485BB3E030FD77D4D70ABB6598D25", hash_generated_method = "DF5C5E4B20BAE1307C95A7CE15012CF6")
    public MultipartMimeContent createMultipartMimeContent(ContentTypeHeader multipartMimeCth,
            String[] contentType,
            String[] contentSubtype, 
            String[] contentBody) {
        MultipartMimeContent varB4EAC82CA7396A68D541C85D26508E83_1720019690 = null; //Variable for return #1
        String boundary = multipartMimeCth.getParameter("boundary");
        MultipartMimeContentImpl retval = new MultipartMimeContentImpl(multipartMimeCth);
        {
            int i = 0;
            {
                ContentTypeHeader cth = new ContentType(contentType[i],contentSubtype[i]);
                ContentImpl contentImpl = new ContentImpl(contentBody[i],boundary);
                contentImpl.setContentTypeHeader(cth);
                retval.add(contentImpl);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1720019690 = retval;
        addTaint(multipartMimeCth.getTaint());
        addTaint(contentType[0].getTaint());
        addTaint(contentSubtype[0].getTaint());
        addTaint(contentBody[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1720019690.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1720019690;
        // ---------- Original Method ----------
        //String boundary = multipartMimeCth.getParameter("boundary");
        //MultipartMimeContentImpl retval = new MultipartMimeContentImpl(multipartMimeCth);
        //for (int i = 0 ;  i < contentType.length; i++ ) {
            //ContentTypeHeader cth = new ContentType(contentType[i],contentSubtype[i]);
            //ContentImpl contentImpl  = new ContentImpl(contentBody[i],boundary);
            //contentImpl.setContentTypeHeader(cth);
            //retval.add(contentImpl);
        //}
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.820 -0400", hash_original_field = "E35C353DE529B5A3041CFFE2B7AD3334", hash_generated_field = "790B4B09B170A9194D25942ACCB3ACEB")

    private static String defaultContentEncodingCharset = "UTF-8";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.820 -0400", hash_original_field = "FA71F997FA1A947459DC5495FDB40B0F", hash_generated_field = "52E17AB48D222AC2268208CD5EE77BA5")

    private static UserAgentHeader userAgent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.820 -0400", hash_original_field = "CF1E8C14E54505F60AA10CEB8D5D8AB3", hash_generated_field = "18CB845DD4EFE6EE2073E71A0755D764")

    private static ServerHeader server;
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

