package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.header.*;
import java.util.LinkedList;
import java.util.List;
import gov.nist.javax.sip.header.*;
import javax.sip.message.*;
import javax.sip.address.*;
import gov.nist.javax.sip.parser.*;

public class MessageFactoryImpl implements MessageFactory, MessageFactoryExt {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.675 -0400", hash_original_field = "38E609FC75B0851ECF8F36A17766E912", hash_generated_field = "2C7FA1926E1866F2BD0E0444E5B75063")

    private boolean testing = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.675 -0400", hash_original_field = "3C8E87563DE29D665DA1974EB520FC45", hash_generated_field = "99E1394EBF258394BF69F9B0CF058AC0")

    private boolean strict = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.675 -0400", hash_original_method = "1A6840ADE4B5EE3A7D8D47E6638687F6", hash_generated_method = "F0B1C59F76B6CADA6430628AA379007A")
    public  MessageFactoryImpl() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.675 -0400", hash_original_method = "EC510198678EBDAFC45D82B058FF4015", hash_generated_method = "C6177A909B65F45400E04967CBC68CBF")
    public void setStrict(boolean strict) {
        this.strict = strict;
        // ---------- Original Method ----------
        //this.strict = strict;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.676 -0400", hash_original_method = "4DD923E2326A355154686E3A31C60072", hash_generated_method = "5E20E9296F487C26CA8E7594FEC2C6CF")
    public void setTest(boolean flag) {
        this.testing = flag;
        // ---------- Original Method ----------
        //this.testing = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.676 -0400", hash_original_method = "D170EED829DCE544127E74E1BD3E45CA", hash_generated_method = "AE39F7A89DCC0210784C148DBF19CA03")
    public Request createRequest(javax.sip.address.URI requestURI,
            String method, CallIdHeader callId, CSeqHeader cSeq,
            FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards, ContentTypeHeader contentType,
            Object content) throws ParseException {
        addTaint(content.getTaint());
        addTaint(contentType.getTaint());
        addTaint(maxForwards.getTaint());
        addTaint(via.getTaint());
        addTaint(to.getTaint());
        addTaint(from.getTaint());
        addTaint(cSeq.getTaint());
        addTaint(callId.getTaint());
        addTaint(method.getTaint());
        addTaint(requestURI.getTaint());
    if(requestURI == null || method == null || callId == null
                || cSeq == null || from == null || to == null || via == null
                || maxForwards == null || content == null
                || contentType == null)        
        {
        NullPointerException varCBC39C1161DC00AF053EA56CBEC8F98E_1445776275 = new NullPointerException("Null parameters");
        varCBC39C1161DC00AF053EA56CBEC8F98E_1445776275.addTaint(taint);
        throw varCBC39C1161DC00AF053EA56CBEC8F98E_1445776275;
        }
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
    if(userAgent != null)        
        {
            sipRequest.setHeader(userAgent);
        } //End block
Request varC7C20CEFE913CADDEFC247E46F836F62_1006890524 =         sipRequest;
        varC7C20CEFE913CADDEFC247E46F836F62_1006890524.addTaint(taint);
        return varC7C20CEFE913CADDEFC247E46F836F62_1006890524;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.677 -0400", hash_original_method = "41D839E013CFE4CFF0DE63311CBF1487", hash_generated_method = "6E124594595A0027DA7765125615DE33")
    public Request createRequest(URI requestURI, String method,
            CallIdHeader callId, CSeqHeader cSeq, FromHeader from, ToHeader to,
            List via, MaxForwardsHeader maxForwards, byte[] content,
            ContentTypeHeader contentType) throws ParseException {
        addTaint(contentType.getTaint());
        addTaint(content[0]);
        addTaint(maxForwards.getTaint());
        addTaint(via.getTaint());
        addTaint(to.getTaint());
        addTaint(from.getTaint());
        addTaint(cSeq.getTaint());
        addTaint(callId.getTaint());
        addTaint(method.getTaint());
        addTaint(requestURI.getTaint());
    if(requestURI == null || method == null || callId == null
                || cSeq == null || from == null || to == null || via == null
                || maxForwards == null || content == null
                || contentType == null)        
        {
        ParseException varF876F690F2F89921888A0C4C1198EF42_112789372 = new ParseException(
                    "JAIN-SIP Exception, some parameters are missing"
                            + ", unable to create the request", 0);
        varF876F690F2F89921888A0C4C1198EF42_112789372.addTaint(taint);
        throw varF876F690F2F89921888A0C4C1198EF42_112789372;
        }
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
    if(userAgent != null)        
        {
            sipRequest.setHeader(userAgent);
        } //End block
Request varC7C20CEFE913CADDEFC247E46F836F62_1941665981 =         sipRequest;
        varC7C20CEFE913CADDEFC247E46F836F62_1941665981.addTaint(taint);
        return varC7C20CEFE913CADDEFC247E46F836F62_1941665981;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.678 -0400", hash_original_method = "CE2184BFA0A9A5A1AA8BA0C0C675B13F", hash_generated_method = "E49FC986BCFC19C9D66186BE6402E756")
    public Request createRequest(URI requestURI, String method,
            CallIdHeader callId, CSeqHeader cSeq, FromHeader from, ToHeader to,
            List via, MaxForwardsHeader maxForwards) throws ParseException {
        addTaint(maxForwards.getTaint());
        addTaint(via.getTaint());
        addTaint(to.getTaint());
        addTaint(from.getTaint());
        addTaint(cSeq.getTaint());
        addTaint(callId.getTaint());
        addTaint(method.getTaint());
        addTaint(requestURI.getTaint());
    if(requestURI == null || method == null || callId == null
                || cSeq == null || from == null || to == null || via == null
                || maxForwards == null)        
        {
        ParseException varF876F690F2F89921888A0C4C1198EF42_1161368921 = new ParseException(
                    "JAIN-SIP Exception, some parameters are missing"
                            + ", unable to create the request", 0);
        varF876F690F2F89921888A0C4C1198EF42_1161368921.addTaint(taint);
        throw varF876F690F2F89921888A0C4C1198EF42_1161368921;
        }
        SIPRequest sipRequest = new SIPRequest();
        sipRequest.setRequestURI(requestURI);
        sipRequest.setMethod(method);
        sipRequest.setCallId(callId);
        sipRequest.setCSeq(cSeq);
        sipRequest.setFrom(from);
        sipRequest.setTo(to);
        sipRequest.setVia(via);
        sipRequest.setMaxForwards(maxForwards);
    if(userAgent != null)        
        {
            sipRequest.setHeader(userAgent);
        } //End block
Request varC7C20CEFE913CADDEFC247E46F836F62_1687930921 =         sipRequest;
        varC7C20CEFE913CADDEFC247E46F836F62_1687930921.addTaint(taint);
        return varC7C20CEFE913CADDEFC247E46F836F62_1687930921;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.679 -0400", hash_original_method = "ECF04A8977F592B6B34B54A1AB720125", hash_generated_method = "E8355F161D9A4E77ABD4FD185A0AE517")
    public Response createResponse(int statusCode, CallIdHeader callId,
            CSeqHeader cSeq, FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards, Object content,
            ContentTypeHeader contentType) throws ParseException {
        addTaint(contentType.getTaint());
        addTaint(content.getTaint());
        addTaint(maxForwards.getTaint());
        addTaint(via.getTaint());
        addTaint(to.getTaint());
        addTaint(from.getTaint());
        addTaint(cSeq.getTaint());
        addTaint(callId.getTaint());
        addTaint(statusCode);
    if(callId == null || cSeq == null || from == null || to == null
                || via == null || maxForwards == null || content == null
                || contentType == null)        
        {
        NullPointerException var99225E31447E117606B4042FBEED03CD_2041278498 = new NullPointerException(" unable to create the response");
        var99225E31447E117606B4042FBEED03CD_2041278498.addTaint(taint);
        throw var99225E31447E117606B4042FBEED03CD_2041278498;
        }
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
    if(userAgent != null)        
        {
            sipResponse.setHeader(userAgent);
        } //End block
Response varF66B3BABBC9AAC75BB598AB35EF16644_1622002755 =         sipResponse;
        varF66B3BABBC9AAC75BB598AB35EF16644_1622002755.addTaint(taint);
        return varF66B3BABBC9AAC75BB598AB35EF16644_1622002755;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.680 -0400", hash_original_method = "A629704DD43A1871A6A3CE469581E96B", hash_generated_method = "CFF0A3FADB5635EDCDC78AC602E044B2")
    public Response createResponse(int statusCode, CallIdHeader callId,
            CSeqHeader cSeq, FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards, byte[] content,
            ContentTypeHeader contentType) throws ParseException {
        addTaint(contentType.getTaint());
        addTaint(content[0]);
        addTaint(maxForwards.getTaint());
        addTaint(via.getTaint());
        addTaint(to.getTaint());
        addTaint(from.getTaint());
        addTaint(cSeq.getTaint());
        addTaint(callId.getTaint());
        addTaint(statusCode);
    if(callId == null || cSeq == null || from == null || to == null
                || via == null || maxForwards == null || content == null
                || contentType == null)        
        {
        NullPointerException var4E8C596A00E42B0E795D4F79B497E5DF_1583611973 = new NullPointerException("Null params ");
        var4E8C596A00E42B0E795D4F79B497E5DF_1583611973.addTaint(taint);
        throw var4E8C596A00E42B0E795D4F79B497E5DF_1583611973;
        }
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
    if(userAgent != null)        
        {
            sipResponse.setHeader(userAgent);
        } //End block
Response varF66B3BABBC9AAC75BB598AB35EF16644_400448291 =         sipResponse;
        varF66B3BABBC9AAC75BB598AB35EF16644_400448291.addTaint(taint);
        return varF66B3BABBC9AAC75BB598AB35EF16644_400448291;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.681 -0400", hash_original_method = "A7A78E739513CEBA7D925C6C5ED3F852", hash_generated_method = "5A0ABE001B57409DBC47EA2C15867962")
    public Response createResponse(int statusCode, CallIdHeader callId,
            CSeqHeader cSeq, FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards) throws ParseException {
        addTaint(maxForwards.getTaint());
        addTaint(via.getTaint());
        addTaint(to.getTaint());
        addTaint(from.getTaint());
        addTaint(cSeq.getTaint());
        addTaint(callId.getTaint());
        addTaint(statusCode);
    if(callId == null || cSeq == null || from == null || to == null
                || via == null || maxForwards == null)        
        {
        ParseException var785B0115EF6C37DF44E96689AE1179EC_1880496415 = new ParseException(
                    "JAIN-SIP Exception, some parameters are missing"
                            + ", unable to create the response", 0);
        var785B0115EF6C37DF44E96689AE1179EC_1880496415.addTaint(taint);
        throw var785B0115EF6C37DF44E96689AE1179EC_1880496415;
        }
        SIPResponse sipResponse = new SIPResponse();
        sipResponse.setStatusCode(statusCode);
        sipResponse.setCallId(callId);
        sipResponse.setCSeq(cSeq);
        sipResponse.setFrom(from);
        sipResponse.setTo(to);
        sipResponse.setVia(via);
        sipResponse.setMaxForwards(maxForwards);
    if(userAgent != null)        
        {
            sipResponse.setHeader(userAgent);
        } //End block
Response varF66B3BABBC9AAC75BB598AB35EF16644_380504898 =         sipResponse;
        varF66B3BABBC9AAC75BB598AB35EF16644_380504898.addTaint(taint);
        return varF66B3BABBC9AAC75BB598AB35EF16644_380504898;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.681 -0400", hash_original_method = "DD467BD39ED470F41EBF28C514D0DE9D", hash_generated_method = "3D88C88401F84A007B7CBC9A7164CCB2")
    public Response createResponse(int statusCode, Request request,
            ContentTypeHeader contentType, Object content) throws ParseException {
        addTaint(content.getTaint());
        addTaint(contentType.getTaint());
        addTaint(request.getTaint());
        addTaint(statusCode);
    if(request == null || content == null || contentType == null)        
        {
        NullPointerException varBF4869D1D5EC3FA07F1B6FEBA19B24B8_293354681 = new NullPointerException("null parameters");
        varBF4869D1D5EC3FA07F1B6FEBA19B24B8_293354681.addTaint(taint);
        throw varBF4869D1D5EC3FA07F1B6FEBA19B24B8_293354681;
        }
        SIPRequest sipRequest = (SIPRequest) request;
        SIPResponse sipResponse = sipRequest.createResponse(statusCode);
        sipResponse.setContent(content, contentType);
    if(server != null)        
        {
            sipResponse.setHeader(server);
        } //End block
Response varF66B3BABBC9AAC75BB598AB35EF16644_1957044126 =         sipResponse;
        varF66B3BABBC9AAC75BB598AB35EF16644_1957044126.addTaint(taint);
        return varF66B3BABBC9AAC75BB598AB35EF16644_1957044126;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.682 -0400", hash_original_method = "8BDEFE6980DC0197E43DC25D26C94143", hash_generated_method = "8C5A0903747D67758827FFA420C6205C")
    public Response createResponse(int statusCode, Request request,
            ContentTypeHeader contentType, byte[] content) throws ParseException {
        addTaint(content[0]);
        addTaint(contentType.getTaint());
        addTaint(request.getTaint());
        addTaint(statusCode);
    if(request == null || content == null || contentType == null)        
        {
        NullPointerException var037A18BA73A80D63C93CE40AC660BBB9_1373076906 = new NullPointerException("null Parameters");
        var037A18BA73A80D63C93CE40AC660BBB9_1373076906.addTaint(taint);
        throw var037A18BA73A80D63C93CE40AC660BBB9_1373076906;
        }
        SIPRequest sipRequest = (SIPRequest) request;
        SIPResponse sipResponse = sipRequest.createResponse(statusCode);
        sipResponse.setHeader((ContentType) contentType);
        sipResponse.setMessageContent(content);
    if(server != null)        
        {
            sipResponse.setHeader(server);
        } //End block
Response varF66B3BABBC9AAC75BB598AB35EF16644_519263912 =         sipResponse;
        varF66B3BABBC9AAC75BB598AB35EF16644_519263912.addTaint(taint);
        return varF66B3BABBC9AAC75BB598AB35EF16644_519263912;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.682 -0400", hash_original_method = "C92B83B60B03C2CCAA2954674526918C", hash_generated_method = "3BEBC47FAF273B27765D11C04AACA451")
    public Response createResponse(int statusCode, Request request) throws ParseException {
        addTaint(request.getTaint());
        addTaint(statusCode);
    if(request == null)        
        {
        NullPointerException varBF4869D1D5EC3FA07F1B6FEBA19B24B8_1119577341 = new NullPointerException("null parameters");
        varBF4869D1D5EC3FA07F1B6FEBA19B24B8_1119577341.addTaint(taint);
        throw varBF4869D1D5EC3FA07F1B6FEBA19B24B8_1119577341;
        }
        SIPRequest sipRequest = (SIPRequest) request;
        SIPResponse sipResponse = sipRequest.createResponse(statusCode);
        sipResponse.removeContent();
        sipResponse.removeHeader(ContentTypeHeader.NAME);
    if(server != null)        
        {
            sipResponse.setHeader(server);
        } //End block
Response varF66B3BABBC9AAC75BB598AB35EF16644_274897241 =         sipResponse;
        varF66B3BABBC9AAC75BB598AB35EF16644_274897241.addTaint(taint);
        return varF66B3BABBC9AAC75BB598AB35EF16644_274897241;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.683 -0400", hash_original_method = "CA414FF436476B2FF81777F9CBBFC86F", hash_generated_method = "68EADF5557CF6C9C9457EBCAB37C7CA8")
    public Request createRequest(javax.sip.address.URI requestURI,
            String method, CallIdHeader callId, CSeqHeader cSeq,
            FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards, ContentTypeHeader contentType,
            byte[] content) throws ParseException {
        addTaint(content[0]);
        addTaint(contentType.getTaint());
        addTaint(maxForwards.getTaint());
        addTaint(via.getTaint());
        addTaint(to.getTaint());
        addTaint(from.getTaint());
        addTaint(cSeq.getTaint());
        addTaint(callId.getTaint());
        addTaint(method.getTaint());
        addTaint(requestURI.getTaint());
    if(requestURI == null || method == null || callId == null
                || cSeq == null || from == null || to == null || via == null
                || maxForwards == null || content == null
                || contentType == null)        
        {
        NullPointerException var0D92FD1E5CF96EC15D65801E11B9292D_409524137 = new NullPointerException("missing parameters");
        var0D92FD1E5CF96EC15D65801E11B9292D_409524137.addTaint(taint);
        throw var0D92FD1E5CF96EC15D65801E11B9292D_409524137;
        }
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
    if(userAgent != null)        
        {
            sipRequest.setHeader(userAgent);
        } //End block
Request varC7C20CEFE913CADDEFC247E46F836F62_495791102 =         sipRequest;
        varC7C20CEFE913CADDEFC247E46F836F62_495791102.addTaint(taint);
        return varC7C20CEFE913CADDEFC247E46F836F62_495791102;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.684 -0400", hash_original_method = "F442F4A57014D62724BCC0FFB03CA549", hash_generated_method = "E7DFF25D455A5967BE3F30577061A2D3")
    public Response createResponse(int statusCode, CallIdHeader callId,
            CSeqHeader cSeq, FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards, ContentTypeHeader contentType,
            Object content) throws ParseException {
        addTaint(content.getTaint());
        addTaint(contentType.getTaint());
        addTaint(maxForwards.getTaint());
        addTaint(via.getTaint());
        addTaint(to.getTaint());
        addTaint(from.getTaint());
        addTaint(cSeq.getTaint());
        addTaint(callId.getTaint());
        addTaint(statusCode);
    if(callId == null || cSeq == null || from == null || to == null
                || via == null || maxForwards == null || content == null
                || contentType == null)        
        {
        NullPointerException var0D92FD1E5CF96EC15D65801E11B9292D_304900166 = new NullPointerException("missing parameters");
        var0D92FD1E5CF96EC15D65801E11B9292D_304900166.addTaint(taint);
        throw var0D92FD1E5CF96EC15D65801E11B9292D_304900166;
        }
        SIPResponse sipResponse = new SIPResponse();
        StatusLine statusLine = new StatusLine();
        statusLine.setStatusCode(statusCode);
        String reason = SIPResponse.getReasonPhrase(statusCode);
    if(reason == null)        
        {
        ParseException var5F173B57E73D2CBE93A0C03542CF073F_121349331 = new ParseException(statusCode + " Unknown", 0);
        var5F173B57E73D2CBE93A0C03542CF073F_121349331.addTaint(taint);
        throw var5F173B57E73D2CBE93A0C03542CF073F_121349331;
        }
        statusLine.setReasonPhrase(reason);
        sipResponse.setStatusLine(statusLine);
        sipResponse.setCallId(callId);
        sipResponse.setCSeq(cSeq);
        sipResponse.setFrom(from);
        sipResponse.setTo(to);
        sipResponse.setVia(via);
        sipResponse.setContent(content, contentType);
    if(userAgent != null)        
        {
            sipResponse.setHeader(userAgent);
        } //End block
Response varF66B3BABBC9AAC75BB598AB35EF16644_503003682 =         sipResponse;
        varF66B3BABBC9AAC75BB598AB35EF16644_503003682.addTaint(taint);
        return varF66B3BABBC9AAC75BB598AB35EF16644_503003682;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.685 -0400", hash_original_method = "6F9C1831E48382AD1DFACEE268167E8E", hash_generated_method = "C4BE6B170BCE4226BF975A30936E200B")
    public Response createResponse(int statusCode, CallIdHeader callId,
            CSeqHeader cSeq, FromHeader from, ToHeader to, List via,
            MaxForwardsHeader maxForwards, ContentTypeHeader contentType,
            byte[] content) throws ParseException {
        addTaint(content[0]);
        addTaint(contentType.getTaint());
        addTaint(maxForwards.getTaint());
        addTaint(via.getTaint());
        addTaint(to.getTaint());
        addTaint(from.getTaint());
        addTaint(cSeq.getTaint());
        addTaint(callId.getTaint());
        addTaint(statusCode);
    if(callId == null || cSeq == null || from == null || to == null
                || via == null || maxForwards == null || content == null
                || contentType == null)        
        {
        NullPointerException var0D92FD1E5CF96EC15D65801E11B9292D_1001120523 = new NullPointerException("missing parameters");
        var0D92FD1E5CF96EC15D65801E11B9292D_1001120523.addTaint(taint);
        throw var0D92FD1E5CF96EC15D65801E11B9292D_1001120523;
        }
        SIPResponse sipResponse = new SIPResponse();
        StatusLine statusLine = new StatusLine();
        statusLine.setStatusCode(statusCode);
        String reason = SIPResponse.getReasonPhrase(statusCode);
    if(reason == null)        
        {
        ParseException varA59D4E9E396B8B1AD343A574A7B30B45_2100286406 = new ParseException(statusCode + " : Unknown", 0);
        varA59D4E9E396B8B1AD343A574A7B30B45_2100286406.addTaint(taint);
        throw varA59D4E9E396B8B1AD343A574A7B30B45_2100286406;
        }
        statusLine.setReasonPhrase(reason);
        sipResponse.setStatusLine(statusLine);
        sipResponse.setCallId(callId);
        sipResponse.setCSeq(cSeq);
        sipResponse.setFrom(from);
        sipResponse.setTo(to);
        sipResponse.setVia(via);
        sipResponse.setContent(content, contentType);
    if(userAgent != null)        
        {
            sipResponse.setHeader(userAgent);
        } //End block
Response varF66B3BABBC9AAC75BB598AB35EF16644_347302427 =         sipResponse;
        varF66B3BABBC9AAC75BB598AB35EF16644_347302427.addTaint(taint);
        return varF66B3BABBC9AAC75BB598AB35EF16644_347302427;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.686 -0400", hash_original_method = "973FDAB995A16C4007672A92A7C4D585", hash_generated_method = "F7010469171532C0F10B7B7FB6733537")
    public javax.sip.message.Request createRequest(String requestString) throws java.text.ParseException {
        addTaint(requestString.getTaint());
    if(requestString == null || requestString.equals(""))        
        {
            SIPRequest retval = new SIPRequest();
            retval.setNullRequest();
javax.sip.message.Request varF9E19AD6135C970F387F77C6F3DE4477_1125445606 =             retval;
            varF9E19AD6135C970F387F77C6F3DE4477_1125445606.addTaint(taint);
            return varF9E19AD6135C970F387F77C6F3DE4477_1125445606;
        } //End block
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
    if(this.testing)        
        smp.setParseExceptionListener(parseExceptionListener);
        SIPMessage sipMessage = smp.parseSIPMessage(requestString);
    if(!(sipMessage instanceof SIPRequest))        
        {
        ParseException varB861AEF1673444A6D220FAA8E5154773_993808665 = new ParseException(requestString, 0);
        varB861AEF1673444A6D220FAA8E5154773_993808665.addTaint(taint);
        throw varB861AEF1673444A6D220FAA8E5154773_993808665;
        }
javax.sip.message.Request var3A0DD2F3DF1CA3ABF8090503156E6432_1194358680 =         (SIPRequest) sipMessage;
        var3A0DD2F3DF1CA3ABF8090503156E6432_1194358680.addTaint(taint);
        return var3A0DD2F3DF1CA3ABF8090503156E6432_1194358680;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.687 -0400", hash_original_method = "8329107E7147BB5F0DCDAFE41A50D91D", hash_generated_method = "98B9DB264BB5FE53FC4015504C30F6A3")
    public Response createResponse(String responseString) throws java.text.ParseException {
        addTaint(responseString.getTaint());
    if(responseString == null)        
        {
Response varB48B9712E3F6A0CC5E200F148717B33F_566260882 =         new SIPResponse();
        varB48B9712E3F6A0CC5E200F148717B33F_566260882.addTaint(taint);
        return varB48B9712E3F6A0CC5E200F148717B33F_566260882;
        }
        StringMsgParser smp = new StringMsgParser();
        SIPMessage sipMessage = smp.parseSIPMessage(responseString);
    if(!(sipMessage instanceof SIPResponse))        
        {
        ParseException var46578DA3026D1C0D948103C86B94EEFD_33236698 = new ParseException(responseString, 0);
        var46578DA3026D1C0D948103C86B94EEFD_33236698.addTaint(taint);
        throw var46578DA3026D1C0D948103C86B94EEFD_33236698;
        }
Response varCB1C328DEADD598C5350BF81734F0282_1421796288 =         (SIPResponse) sipMessage;
        varCB1C328DEADD598C5350BF81734F0282_1421796288.addTaint(taint);
        return varCB1C328DEADD598C5350BF81734F0282_1421796288;
        // ---------- Original Method ----------
        //if (responseString == null)
            //return new SIPResponse();
        //StringMsgParser smp = new StringMsgParser();
        //SIPMessage sipMessage = smp.parseSIPMessage(responseString);
        //if (!(sipMessage instanceof SIPResponse))
            //throw new ParseException(responseString, 0);
        //return (SIPResponse) sipMessage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.687 -0400", hash_original_method = "F6370A15361A54B6EDEFA955061D514D", hash_generated_method = "3D40FEC77C6384E42F8318075B55B80B")
    public void setDefaultUserAgentHeader(UserAgentHeader userAgent) {
        addTaint(userAgent.getTaint());
        MessageFactoryImpl.userAgent = userAgent;
        // ---------- Original Method ----------
        //MessageFactoryImpl.userAgent = userAgent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.688 -0400", hash_original_method = "86783F390E61522F639FC7DF78604B5D", hash_generated_method = "37DD24912CBF3A3A4D14C400540C0069")
    public void setDefaultServerHeader(ServerHeader server) {
        addTaint(server.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.689 -0400", hash_original_method = "7A37B9B6512C6512FDCFFA4B5CE85073", hash_generated_method = "0F851291032840E58BACAC67A5530DA6")
    public void setDefaultContentEncodingCharset(String charset) throws NullPointerException,
    IllegalArgumentException {
        addTaint(charset.getTaint());
    if(charset == null)        
        {
        NullPointerException var2E325D1E8870351157D8C6AB415344DD_1050294084 = new NullPointerException ("Null argument!");
        var2E325D1E8870351157D8C6AB415344DD_1050294084.addTaint(taint);
        throw var2E325D1E8870351157D8C6AB415344DD_1050294084;
        }
        MessageFactoryImpl.defaultContentEncodingCharset = charset;
        // ---------- Original Method ----------
        //if (charset == null ) throw new NullPointerException ("Null argument!");
        //MessageFactoryImpl.defaultContentEncodingCharset = charset;
    }

    
        public static String getDefaultContentEncodingCharset() {
        return MessageFactoryImpl.defaultContentEncodingCharset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.690 -0400", hash_original_method = "86E485BB3E030FD77D4D70ABB6598D25", hash_generated_method = "861C278BBD00CF336F787F6958B5A4D3")
    public MultipartMimeContent createMultipartMimeContent(ContentTypeHeader multipartMimeCth,
            String[] contentType,
            String[] contentSubtype, 
            String[] contentBody) {
        addTaint(contentBody[0].getTaint());
        addTaint(contentSubtype[0].getTaint());
        addTaint(contentType[0].getTaint());
        addTaint(multipartMimeCth.getTaint());
        String boundary = multipartMimeCth.getParameter("boundary");
        MultipartMimeContentImpl retval = new MultipartMimeContentImpl(multipartMimeCth);
for(int i = 0;i < contentType.length;i++)
        {
            ContentTypeHeader cth = new ContentType(contentType[i],contentSubtype[i]);
            ContentImpl contentImpl = new ContentImpl(contentBody[i],boundary);
            contentImpl.setContentTypeHeader(cth);
            retval.add(contentImpl);
        } //End block
MultipartMimeContent varF9E19AD6135C970F387F77C6F3DE4477_325371722 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_325371722.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_325371722;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.691 -0400", hash_original_field = "E35C353DE529B5A3041CFFE2B7AD3334", hash_generated_field = "790B4B09B170A9194D25942ACCB3ACEB")

    private static String defaultContentEncodingCharset = "UTF-8";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.691 -0400", hash_original_field = "FA71F997FA1A947459DC5495FDB40B0F", hash_generated_field = "52E17AB48D222AC2268208CD5EE77BA5")

    private static UserAgentHeader userAgent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.691 -0400", hash_original_field = "CF1E8C14E54505F60AA10CEB8D5D8AB3", hash_generated_field = "18CB845DD4EFE6EE2073E71A0755D764")

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

