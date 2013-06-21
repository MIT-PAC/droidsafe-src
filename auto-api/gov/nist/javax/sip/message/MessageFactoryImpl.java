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
    private boolean testing = false;
    private boolean strict  = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.825 -0400", hash_original_method = "1A6840ADE4B5EE3A7D8D47E6638687F6", hash_generated_method = "F0B1C59F76B6CADA6430628AA379007A")
    @DSModeled(DSC.SAFE)
    public MessageFactoryImpl() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.825 -0400", hash_original_method = "EC510198678EBDAFC45D82B058FF4015", hash_generated_method = "0354B80892A0D8E2A9E042E574374324")
    @DSModeled(DSC.SAFE)
    public void setStrict(boolean strict) {
        dsTaint.addTaint(strict);
        // ---------- Original Method ----------
        //this.strict = strict;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.825 -0400", hash_original_method = "4DD923E2326A355154686E3A31C60072", hash_generated_method = "C7878E364EAA841D41CFB64DF261A029")
    @DSModeled(DSC.SAFE)
    public void setTest(boolean flag) {
        dsTaint.addTaint(flag);
        // ---------- Original Method ----------
        //this.testing = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.825 -0400", hash_original_method = "D170EED829DCE544127E74E1BD3E45CA", hash_generated_method = "51DE4D3DA28B57A6808F171F8DD337F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Request createRequest(javax.sip.address.URI requestURI,
            String method, CallIdHeader callId, CSeqHeader cSeq,
            FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards, ContentTypeHeader contentType,
            Object content) throws ParseException {
        dsTaint.addTaint(content.dsTaint);
        dsTaint.addTaint(to.dsTaint);
        dsTaint.addTaint(via.dsTaint);
        dsTaint.addTaint(cSeq.dsTaint);
        dsTaint.addTaint(requestURI.dsTaint);
        dsTaint.addTaint(method);
        dsTaint.addTaint(contentType.dsTaint);
        dsTaint.addTaint(from.dsTaint);
        dsTaint.addTaint(callId.dsTaint);
        dsTaint.addTaint(maxForwards.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null parameters");
        SIPRequest sipRequest;
        sipRequest = new SIPRequest();
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
        return (Request)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.826 -0400", hash_original_method = "41D839E013CFE4CFF0DE63311CBF1487", hash_generated_method = "1D0D9AC92F05B1C6F1AC9222DCE1124E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Request createRequest(URI requestURI, String method,
            CallIdHeader callId, CSeqHeader cSeq, FromHeader from, ToHeader to,
            List via, MaxForwardsHeader maxForwards, byte[] content,
            ContentTypeHeader contentType) throws ParseException {
        dsTaint.addTaint(content[0]);
        dsTaint.addTaint(to.dsTaint);
        dsTaint.addTaint(via.dsTaint);
        dsTaint.addTaint(cSeq.dsTaint);
        dsTaint.addTaint(requestURI.dsTaint);
        dsTaint.addTaint(method);
        dsTaint.addTaint(contentType.dsTaint);
        dsTaint.addTaint(from.dsTaint);
        dsTaint.addTaint(callId.dsTaint);
        dsTaint.addTaint(maxForwards.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new ParseException(
                    "JAIN-SIP Exception, some parameters are missing"
                            + ", unable to create the request", 0);
        SIPRequest sipRequest;
        sipRequest = new SIPRequest();
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
        return (Request)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.826 -0400", hash_original_method = "CE2184BFA0A9A5A1AA8BA0C0C675B13F", hash_generated_method = "8805770ED685D9DA3FF8F1A39F65B25D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Request createRequest(URI requestURI, String method,
            CallIdHeader callId, CSeqHeader cSeq, FromHeader from, ToHeader to,
            List via, MaxForwardsHeader maxForwards) throws ParseException {
        dsTaint.addTaint(to.dsTaint);
        dsTaint.addTaint(via.dsTaint);
        dsTaint.addTaint(cSeq.dsTaint);
        dsTaint.addTaint(requestURI.dsTaint);
        dsTaint.addTaint(method);
        dsTaint.addTaint(from.dsTaint);
        dsTaint.addTaint(callId.dsTaint);
        dsTaint.addTaint(maxForwards.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new ParseException(
                    "JAIN-SIP Exception, some parameters are missing"
                            + ", unable to create the request", 0);
        SIPRequest sipRequest;
        sipRequest = new SIPRequest();
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
        return (Request)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.827 -0400", hash_original_method = "ECF04A8977F592B6B34B54A1AB720125", hash_generated_method = "1D46185031FFF9DFEFCB6141C8F3566E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Response createResponse(int statusCode, CallIdHeader callId,
            CSeqHeader cSeq, FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards, Object content,
            ContentTypeHeader contentType) throws ParseException {
        dsTaint.addTaint(content.dsTaint);
        dsTaint.addTaint(to.dsTaint);
        dsTaint.addTaint(statusCode);
        dsTaint.addTaint(via.dsTaint);
        dsTaint.addTaint(cSeq.dsTaint);
        dsTaint.addTaint(contentType.dsTaint);
        dsTaint.addTaint(from.dsTaint);
        dsTaint.addTaint(callId.dsTaint);
        dsTaint.addTaint(maxForwards.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(" unable to create the response");
        SIPResponse sipResponse;
        sipResponse = new SIPResponse();
        StatusLine statusLine;
        statusLine = new StatusLine();
        statusLine.setStatusCode(statusCode);
        String reasonPhrase;
        reasonPhrase = SIPResponse.getReasonPhrase(statusCode);
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
        return (Response)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.827 -0400", hash_original_method = "A629704DD43A1871A6A3CE469581E96B", hash_generated_method = "B28F1D885EC3BFF703034795BF4EA2FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Response createResponse(int statusCode, CallIdHeader callId,
            CSeqHeader cSeq, FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards, byte[] content,
            ContentTypeHeader contentType) throws ParseException {
        dsTaint.addTaint(content[0]);
        dsTaint.addTaint(to.dsTaint);
        dsTaint.addTaint(statusCode);
        dsTaint.addTaint(via.dsTaint);
        dsTaint.addTaint(cSeq.dsTaint);
        dsTaint.addTaint(contentType.dsTaint);
        dsTaint.addTaint(from.dsTaint);
        dsTaint.addTaint(callId.dsTaint);
        dsTaint.addTaint(maxForwards.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null params ");
        SIPResponse sipResponse;
        sipResponse = new SIPResponse();
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
        return (Response)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.828 -0400", hash_original_method = "A7A78E739513CEBA7D925C6C5ED3F852", hash_generated_method = "0F31D0DA5A79309CF8D378A0D114A420")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Response createResponse(int statusCode, CallIdHeader callId,
            CSeqHeader cSeq, FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards) throws ParseException {
        dsTaint.addTaint(to.dsTaint);
        dsTaint.addTaint(statusCode);
        dsTaint.addTaint(via.dsTaint);
        dsTaint.addTaint(cSeq.dsTaint);
        dsTaint.addTaint(from.dsTaint);
        dsTaint.addTaint(callId.dsTaint);
        dsTaint.addTaint(maxForwards.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new ParseException(
                    "JAIN-SIP Exception, some parameters are missing"
                            + ", unable to create the response", 0);
        SIPResponse sipResponse;
        sipResponse = new SIPResponse();
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
        return (Response)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.828 -0400", hash_original_method = "DD467BD39ED470F41EBF28C514D0DE9D", hash_generated_method = "3BFFA536BA784643B6EBBEDEBDCDC21B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Response createResponse(int statusCode, Request request,
            ContentTypeHeader contentType, Object content) throws ParseException {
        dsTaint.addTaint(content.dsTaint);
        dsTaint.addTaint(statusCode);
        dsTaint.addTaint(request.dsTaint);
        dsTaint.addTaint(contentType.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null parameters");
        SIPRequest sipRequest;
        sipRequest = (SIPRequest) request;
        SIPResponse sipResponse;
        sipResponse = sipRequest.createResponse(statusCode);
        sipResponse.setContent(content, contentType);
        {
            sipResponse.setHeader(server);
        } //End block
        return (Response)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.828 -0400", hash_original_method = "8BDEFE6980DC0197E43DC25D26C94143", hash_generated_method = "8FC2CDC00C47AE3D09A1BF81E5386566")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Response createResponse(int statusCode, Request request,
            ContentTypeHeader contentType, byte[] content) throws ParseException {
        dsTaint.addTaint(content[0]);
        dsTaint.addTaint(statusCode);
        dsTaint.addTaint(request.dsTaint);
        dsTaint.addTaint(contentType.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null Parameters");
        SIPRequest sipRequest;
        sipRequest = (SIPRequest) request;
        SIPResponse sipResponse;
        sipResponse = sipRequest.createResponse(statusCode);
        sipResponse.setHeader((ContentType) contentType);
        sipResponse.setMessageContent(content);
        {
            sipResponse.setHeader(server);
        } //End block
        return (Response)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.829 -0400", hash_original_method = "C92B83B60B03C2CCAA2954674526918C", hash_generated_method = "EEC7ED64F6E5584D33A32A91D4869624")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Response createResponse(int statusCode, Request request) throws ParseException {
        dsTaint.addTaint(statusCode);
        dsTaint.addTaint(request.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null parameters");
        SIPRequest sipRequest;
        sipRequest = (SIPRequest) request;
        SIPResponse sipResponse;
        sipResponse = sipRequest.createResponse(statusCode);
        sipResponse.removeContent();
        sipResponse.removeHeader(ContentTypeHeader.NAME);
        {
            sipResponse.setHeader(server);
        } //End block
        return (Response)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.829 -0400", hash_original_method = "CA414FF436476B2FF81777F9CBBFC86F", hash_generated_method = "FAA5E35024340C22EA22B50DF0DFF145")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Request createRequest(javax.sip.address.URI requestURI,
            String method, CallIdHeader callId, CSeqHeader cSeq,
            FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards, ContentTypeHeader contentType,
            byte[] content) throws ParseException {
        dsTaint.addTaint(content[0]);
        dsTaint.addTaint(to.dsTaint);
        dsTaint.addTaint(via.dsTaint);
        dsTaint.addTaint(cSeq.dsTaint);
        dsTaint.addTaint(requestURI.dsTaint);
        dsTaint.addTaint(method);
        dsTaint.addTaint(contentType.dsTaint);
        dsTaint.addTaint(from.dsTaint);
        dsTaint.addTaint(callId.dsTaint);
        dsTaint.addTaint(maxForwards.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("missing parameters");
        SIPRequest sipRequest;
        sipRequest = new SIPRequest();
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
        return (Request)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.830 -0400", hash_original_method = "F442F4A57014D62724BCC0FFB03CA549", hash_generated_method = "F15C448020ECAA94F5EFA722444FC752")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Response createResponse(int statusCode, CallIdHeader callId,
            CSeqHeader cSeq, FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards, ContentTypeHeader contentType,
            Object content) throws ParseException {
        dsTaint.addTaint(content.dsTaint);
        dsTaint.addTaint(to.dsTaint);
        dsTaint.addTaint(statusCode);
        dsTaint.addTaint(via.dsTaint);
        dsTaint.addTaint(cSeq.dsTaint);
        dsTaint.addTaint(contentType.dsTaint);
        dsTaint.addTaint(from.dsTaint);
        dsTaint.addTaint(callId.dsTaint);
        dsTaint.addTaint(maxForwards.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("missing parameters");
        SIPResponse sipResponse;
        sipResponse = new SIPResponse();
        StatusLine statusLine;
        statusLine = new StatusLine();
        statusLine.setStatusCode(statusCode);
        String reason;
        reason = SIPResponse.getReasonPhrase(statusCode);
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
        return (Response)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.830 -0400", hash_original_method = "6F9C1831E48382AD1DFACEE268167E8E", hash_generated_method = "A322FD3D7E5941213D60E4F8E09DE48D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Response createResponse(int statusCode, CallIdHeader callId,
            CSeqHeader cSeq, FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards, ContentTypeHeader contentType,
            byte[] content) throws ParseException {
        dsTaint.addTaint(content[0]);
        dsTaint.addTaint(to.dsTaint);
        dsTaint.addTaint(statusCode);
        dsTaint.addTaint(via.dsTaint);
        dsTaint.addTaint(cSeq.dsTaint);
        dsTaint.addTaint(contentType.dsTaint);
        dsTaint.addTaint(from.dsTaint);
        dsTaint.addTaint(callId.dsTaint);
        dsTaint.addTaint(maxForwards.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("missing parameters");
        SIPResponse sipResponse;
        sipResponse = new SIPResponse();
        StatusLine statusLine;
        statusLine = new StatusLine();
        statusLine.setStatusCode(statusCode);
        String reason;
        reason = SIPResponse.getReasonPhrase(statusCode);
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
        return (Response)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.831 -0400", hash_original_method = "973FDAB995A16C4007672A92A7C4D585", hash_generated_method = "0F8AF31BE47E9FB87FAE1B4FF422C110")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public javax.sip.message.Request createRequest(String requestString) throws java.text.ParseException {
        dsTaint.addTaint(requestString);
        {
            boolean varDB1EE064EEBA27818A326B01B2A660EE_1160712691 = (requestString == null || requestString.equals(""));
            {
                SIPRequest retval;
                retval = new SIPRequest();
                retval.setNullRequest();
            } //End block
        } //End collapsed parenthetic
        StringMsgParser smp;
        smp = new StringMsgParser();
        smp.setStrict(this.strict);
        ParseExceptionListener parseExceptionListener;
        parseExceptionListener = new ParseExceptionListener() {
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
        SIPMessage sipMessage;
        sipMessage = smp.parseSIPMessage(requestString);
        if (DroidSafeAndroidRuntime.control) throw new ParseException(requestString, 0);
        return (javax.sip.message.Request)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.831 -0400", hash_original_method = "8329107E7147BB5F0DCDAFE41A50D91D", hash_generated_method = "5F05234E3E0D7A49AFDD907B65B67375")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Response createResponse(String responseString) throws java.text.ParseException {
        dsTaint.addTaint(responseString);
        Response var55A1443FE5E8A0404A1353E77D7132EE_1425422798 = (new SIPResponse());
        StringMsgParser smp;
        smp = new StringMsgParser();
        SIPMessage sipMessage;
        sipMessage = smp.parseSIPMessage(responseString);
        if (DroidSafeAndroidRuntime.control) throw new ParseException(responseString, 0);
        return (Response)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (responseString == null)
            //return new SIPResponse();
        //StringMsgParser smp = new StringMsgParser();
        //SIPMessage sipMessage = smp.parseSIPMessage(responseString);
        //if (!(sipMessage instanceof SIPResponse))
            //throw new ParseException(responseString, 0);
        //return (SIPResponse) sipMessage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.831 -0400", hash_original_method = "F6370A15361A54B6EDEFA955061D514D", hash_generated_method = "EE5C4D5388A64C3A52DB43BF77017942")
    @DSModeled(DSC.SAFE)
    public void setDefaultUserAgentHeader(UserAgentHeader userAgent) {
        dsTaint.addTaint(userAgent.dsTaint);
        MessageFactoryImpl.userAgent = userAgent;
        // ---------- Original Method ----------
        //MessageFactoryImpl.userAgent = userAgent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.831 -0400", hash_original_method = "86783F390E61522F639FC7DF78604B5D", hash_generated_method = "5464DBF18A60C1F2AC017D07829119D2")
    @DSModeled(DSC.SAFE)
    public void setDefaultServerHeader(ServerHeader server) {
        dsTaint.addTaint(server.dsTaint);
        MessageFactoryImpl.server = server;
        // ---------- Original Method ----------
        //MessageFactoryImpl.server = server;
    }

    
        public static UserAgentHeader getDefaultUserAgentHeader() {
        return userAgent;
    }

    
        public static ServerHeader getDefaultServerHeader() {
        return server;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.832 -0400", hash_original_method = "7A37B9B6512C6512FDCFFA4B5CE85073", hash_generated_method = "D0C625CE47161C513FA78D793D6770C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDefaultContentEncodingCharset(String charset) throws NullPointerException,
    IllegalArgumentException {
        dsTaint.addTaint(charset);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException ("Null argument!");
        MessageFactoryImpl.defaultContentEncodingCharset = charset;
        // ---------- Original Method ----------
        //if (charset == null ) throw new NullPointerException ("Null argument!");
        //MessageFactoryImpl.defaultContentEncodingCharset = charset;
    }

    
        public static String getDefaultContentEncodingCharset() {
        return MessageFactoryImpl.defaultContentEncodingCharset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.832 -0400", hash_original_method = "86E485BB3E030FD77D4D70ABB6598D25", hash_generated_method = "7F41448921197A35AC425D4B0F919F57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MultipartMimeContent createMultipartMimeContent(ContentTypeHeader multipartMimeCth,
            String[] contentType,
            String[] contentSubtype, 
            String[] contentBody) {
        dsTaint.addTaint(contentBody[0]);
        dsTaint.addTaint(multipartMimeCth.dsTaint);
        dsTaint.addTaint(contentType[0]);
        dsTaint.addTaint(contentSubtype[0]);
        String boundary;
        boundary = multipartMimeCth.getParameter("boundary");
        MultipartMimeContentImpl retval;
        retval = new MultipartMimeContentImpl(multipartMimeCth);
        {
            int i;
            i = 0;
            {
                ContentTypeHeader cth;
                cth = new ContentType(contentType[i],contentSubtype[i]);
                ContentImpl contentImpl;
                contentImpl = new ContentImpl(contentBody[i],boundary);
                contentImpl.setContentTypeHeader(cth);
                retval.add(contentImpl);
            } //End block
        } //End collapsed parenthetic
        return (MultipartMimeContent)dsTaint.getTaint();
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

    
    private static String defaultContentEncodingCharset = "UTF-8";
    private static UserAgentHeader userAgent;
    private static ServerHeader server;
}

