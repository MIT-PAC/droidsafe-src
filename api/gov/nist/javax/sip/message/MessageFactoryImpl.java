package gov.nist.javax.sip.message;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.818 -0400", hash_original_field = "38E609FC75B0851ECF8F36A17766E912", hash_generated_field = "2C7FA1926E1866F2BD0E0444E5B75063")

    private boolean testing = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.818 -0400", hash_original_field = "3C8E87563DE29D665DA1974EB520FC45", hash_generated_field = "99E1394EBF258394BF69F9B0CF058AC0")

    private boolean strict = true;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.818 -0400", hash_original_method = "1A6840ADE4B5EE3A7D8D47E6638687F6", hash_generated_method = "F0B1C59F76B6CADA6430628AA379007A")
    public  MessageFactoryImpl() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.818 -0400", hash_original_method = "EC510198678EBDAFC45D82B058FF4015", hash_generated_method = "C6177A909B65F45400E04967CBC68CBF")
    public void setStrict(boolean strict) {
        this.strict = strict;
        // ---------- Original Method ----------
        //this.strict = strict;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.819 -0400", hash_original_method = "4DD923E2326A355154686E3A31C60072", hash_generated_method = "5E20E9296F487C26CA8E7594FEC2C6CF")
    public void setTest(boolean flag) {
        this.testing = flag;
        // ---------- Original Method ----------
        //this.testing = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.820 -0400", hash_original_method = "D170EED829DCE544127E74E1BD3E45CA", hash_generated_method = "7F9CC491868D3224FA126C9C82EEEC5F")
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
        NullPointerException varCBC39C1161DC00AF053EA56CBEC8F98E_1892359662 = new NullPointerException("Null parameters");
        varCBC39C1161DC00AF053EA56CBEC8F98E_1892359662.addTaint(taint);
        throw varCBC39C1161DC00AF053EA56CBEC8F98E_1892359662;
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
Request varC7C20CEFE913CADDEFC247E46F836F62_409504577 =         sipRequest;
        varC7C20CEFE913CADDEFC247E46F836F62_409504577.addTaint(taint);
        return varC7C20CEFE913CADDEFC247E46F836F62_409504577;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.821 -0400", hash_original_method = "41D839E013CFE4CFF0DE63311CBF1487", hash_generated_method = "211E82B0283D71800E03A83364E81DC1")
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
        ParseException varF876F690F2F89921888A0C4C1198EF42_300459051 = new ParseException(
                    "JAIN-SIP Exception, some parameters are missing"
                            + ", unable to create the request", 0);
        varF876F690F2F89921888A0C4C1198EF42_300459051.addTaint(taint);
        throw varF876F690F2F89921888A0C4C1198EF42_300459051;
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
Request varC7C20CEFE913CADDEFC247E46F836F62_1852941149 =         sipRequest;
        varC7C20CEFE913CADDEFC247E46F836F62_1852941149.addTaint(taint);
        return varC7C20CEFE913CADDEFC247E46F836F62_1852941149;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.822 -0400", hash_original_method = "CE2184BFA0A9A5A1AA8BA0C0C675B13F", hash_generated_method = "701F9D80FCD7891E6C7DD49CF325B7D1")
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
        ParseException varF876F690F2F89921888A0C4C1198EF42_734275963 = new ParseException(
                    "JAIN-SIP Exception, some parameters are missing"
                            + ", unable to create the request", 0);
        varF876F690F2F89921888A0C4C1198EF42_734275963.addTaint(taint);
        throw varF876F690F2F89921888A0C4C1198EF42_734275963;
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
Request varC7C20CEFE913CADDEFC247E46F836F62_1202564480 =         sipRequest;
        varC7C20CEFE913CADDEFC247E46F836F62_1202564480.addTaint(taint);
        return varC7C20CEFE913CADDEFC247E46F836F62_1202564480;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.823 -0400", hash_original_method = "ECF04A8977F592B6B34B54A1AB720125", hash_generated_method = "685B46265EC2333CE30C90A4F67EB860")
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
        NullPointerException var99225E31447E117606B4042FBEED03CD_2128150554 = new NullPointerException(" unable to create the response");
        var99225E31447E117606B4042FBEED03CD_2128150554.addTaint(taint);
        throw var99225E31447E117606B4042FBEED03CD_2128150554;
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
Response varF66B3BABBC9AAC75BB598AB35EF16644_1311183611 =         sipResponse;
        varF66B3BABBC9AAC75BB598AB35EF16644_1311183611.addTaint(taint);
        return varF66B3BABBC9AAC75BB598AB35EF16644_1311183611;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.825 -0400", hash_original_method = "A629704DD43A1871A6A3CE469581E96B", hash_generated_method = "51EDE0CA4CCDEE3B6D38EDE82767AA59")
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
        NullPointerException var4E8C596A00E42B0E795D4F79B497E5DF_40278923 = new NullPointerException("Null params ");
        var4E8C596A00E42B0E795D4F79B497E5DF_40278923.addTaint(taint);
        throw var4E8C596A00E42B0E795D4F79B497E5DF_40278923;
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
Response varF66B3BABBC9AAC75BB598AB35EF16644_1656969517 =         sipResponse;
        varF66B3BABBC9AAC75BB598AB35EF16644_1656969517.addTaint(taint);
        return varF66B3BABBC9AAC75BB598AB35EF16644_1656969517;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.825 -0400", hash_original_method = "A7A78E739513CEBA7D925C6C5ED3F852", hash_generated_method = "23D75483474C63F47F90642AB603F26F")
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
        ParseException var785B0115EF6C37DF44E96689AE1179EC_1436737418 = new ParseException(
                    "JAIN-SIP Exception, some parameters are missing"
                            + ", unable to create the response", 0);
        var785B0115EF6C37DF44E96689AE1179EC_1436737418.addTaint(taint);
        throw var785B0115EF6C37DF44E96689AE1179EC_1436737418;
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
Response varF66B3BABBC9AAC75BB598AB35EF16644_106925343 =         sipResponse;
        varF66B3BABBC9AAC75BB598AB35EF16644_106925343.addTaint(taint);
        return varF66B3BABBC9AAC75BB598AB35EF16644_106925343;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.826 -0400", hash_original_method = "DD467BD39ED470F41EBF28C514D0DE9D", hash_generated_method = "FFB2DAE01AD72CB933CDF22563BBC5FB")
    public Response createResponse(int statusCode, Request request,
            ContentTypeHeader contentType, Object content) throws ParseException {
        addTaint(content.getTaint());
        addTaint(contentType.getTaint());
        addTaint(request.getTaint());
        addTaint(statusCode);
        if(request == null || content == null || contentType == null)        
        {
        NullPointerException varBF4869D1D5EC3FA07F1B6FEBA19B24B8_324443295 = new NullPointerException("null parameters");
        varBF4869D1D5EC3FA07F1B6FEBA19B24B8_324443295.addTaint(taint);
        throw varBF4869D1D5EC3FA07F1B6FEBA19B24B8_324443295;
        }
        SIPRequest sipRequest = (SIPRequest) request;
        SIPResponse sipResponse = sipRequest.createResponse(statusCode);
        sipResponse.setContent(content, contentType);
        if(server != null)        
        {
            sipResponse.setHeader(server);
        } //End block
Response varF66B3BABBC9AAC75BB598AB35EF16644_971663635 =         sipResponse;
        varF66B3BABBC9AAC75BB598AB35EF16644_971663635.addTaint(taint);
        return varF66B3BABBC9AAC75BB598AB35EF16644_971663635;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.826 -0400", hash_original_method = "8BDEFE6980DC0197E43DC25D26C94143", hash_generated_method = "F7A0BB541F743AACD9A6A0D6BAA4C707")
    public Response createResponse(int statusCode, Request request,
            ContentTypeHeader contentType, byte[] content) throws ParseException {
        addTaint(content[0]);
        addTaint(contentType.getTaint());
        addTaint(request.getTaint());
        addTaint(statusCode);
        if(request == null || content == null || contentType == null)        
        {
        NullPointerException var037A18BA73A80D63C93CE40AC660BBB9_268445721 = new NullPointerException("null Parameters");
        var037A18BA73A80D63C93CE40AC660BBB9_268445721.addTaint(taint);
        throw var037A18BA73A80D63C93CE40AC660BBB9_268445721;
        }
        SIPRequest sipRequest = (SIPRequest) request;
        SIPResponse sipResponse = sipRequest.createResponse(statusCode);
        sipResponse.setHeader((ContentType) contentType);
        sipResponse.setMessageContent(content);
        if(server != null)        
        {
            sipResponse.setHeader(server);
        } //End block
Response varF66B3BABBC9AAC75BB598AB35EF16644_72945952 =         sipResponse;
        varF66B3BABBC9AAC75BB598AB35EF16644_72945952.addTaint(taint);
        return varF66B3BABBC9AAC75BB598AB35EF16644_72945952;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.827 -0400", hash_original_method = "C92B83B60B03C2CCAA2954674526918C", hash_generated_method = "76F5DB9D2A4E533DE00B34878A67FD9B")
    public Response createResponse(int statusCode, Request request) throws ParseException {
        addTaint(request.getTaint());
        addTaint(statusCode);
        if(request == null)        
        {
        NullPointerException varBF4869D1D5EC3FA07F1B6FEBA19B24B8_196257304 = new NullPointerException("null parameters");
        varBF4869D1D5EC3FA07F1B6FEBA19B24B8_196257304.addTaint(taint);
        throw varBF4869D1D5EC3FA07F1B6FEBA19B24B8_196257304;
        }
        SIPRequest sipRequest = (SIPRequest) request;
        SIPResponse sipResponse = sipRequest.createResponse(statusCode);
        sipResponse.removeContent();
        sipResponse.removeHeader(ContentTypeHeader.NAME);
        if(server != null)        
        {
            sipResponse.setHeader(server);
        } //End block
Response varF66B3BABBC9AAC75BB598AB35EF16644_1590913344 =         sipResponse;
        varF66B3BABBC9AAC75BB598AB35EF16644_1590913344.addTaint(taint);
        return varF66B3BABBC9AAC75BB598AB35EF16644_1590913344;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.828 -0400", hash_original_method = "CA414FF436476B2FF81777F9CBBFC86F", hash_generated_method = "852DC0CEBFF502559EC0CD55FABD7A76")
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
        NullPointerException var0D92FD1E5CF96EC15D65801E11B9292D_1955916644 = new NullPointerException("missing parameters");
        var0D92FD1E5CF96EC15D65801E11B9292D_1955916644.addTaint(taint);
        throw var0D92FD1E5CF96EC15D65801E11B9292D_1955916644;
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
Request varC7C20CEFE913CADDEFC247E46F836F62_1308484230 =         sipRequest;
        varC7C20CEFE913CADDEFC247E46F836F62_1308484230.addTaint(taint);
        return varC7C20CEFE913CADDEFC247E46F836F62_1308484230;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.829 -0400", hash_original_method = "F442F4A57014D62724BCC0FFB03CA549", hash_generated_method = "F15754CE0C955EF786BD547B95A78146")
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
        NullPointerException var0D92FD1E5CF96EC15D65801E11B9292D_667412370 = new NullPointerException("missing parameters");
        var0D92FD1E5CF96EC15D65801E11B9292D_667412370.addTaint(taint);
        throw var0D92FD1E5CF96EC15D65801E11B9292D_667412370;
        }
        SIPResponse sipResponse = new SIPResponse();
        StatusLine statusLine = new StatusLine();
        statusLine.setStatusCode(statusCode);
        String reason = SIPResponse.getReasonPhrase(statusCode);
        if(reason == null)        
        {
        ParseException var5F173B57E73D2CBE93A0C03542CF073F_1266518178 = new ParseException(statusCode + " Unknown", 0);
        var5F173B57E73D2CBE93A0C03542CF073F_1266518178.addTaint(taint);
        throw var5F173B57E73D2CBE93A0C03542CF073F_1266518178;
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
Response varF66B3BABBC9AAC75BB598AB35EF16644_819830240 =         sipResponse;
        varF66B3BABBC9AAC75BB598AB35EF16644_819830240.addTaint(taint);
        return varF66B3BABBC9AAC75BB598AB35EF16644_819830240;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.829 -0400", hash_original_method = "6F9C1831E48382AD1DFACEE268167E8E", hash_generated_method = "ABD8142215EACFAC02958EDCA0285E34")
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
        NullPointerException var0D92FD1E5CF96EC15D65801E11B9292D_2104813798 = new NullPointerException("missing parameters");
        var0D92FD1E5CF96EC15D65801E11B9292D_2104813798.addTaint(taint);
        throw var0D92FD1E5CF96EC15D65801E11B9292D_2104813798;
        }
        SIPResponse sipResponse = new SIPResponse();
        StatusLine statusLine = new StatusLine();
        statusLine.setStatusCode(statusCode);
        String reason = SIPResponse.getReasonPhrase(statusCode);
        if(reason == null)        
        {
        ParseException varA59D4E9E396B8B1AD343A574A7B30B45_212761556 = new ParseException(statusCode + " : Unknown", 0);
        varA59D4E9E396B8B1AD343A574A7B30B45_212761556.addTaint(taint);
        throw varA59D4E9E396B8B1AD343A574A7B30B45_212761556;
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
Response varF66B3BABBC9AAC75BB598AB35EF16644_453937901 =         sipResponse;
        varF66B3BABBC9AAC75BB598AB35EF16644_453937901.addTaint(taint);
        return varF66B3BABBC9AAC75BB598AB35EF16644_453937901;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.830 -0400", hash_original_method = "973FDAB995A16C4007672A92A7C4D585", hash_generated_method = "05E83F94D5B7FB7FC833119A034C05B1")
    public javax.sip.message.Request createRequest(String requestString) throws java.text.ParseException {
        addTaint(requestString.getTaint());
        if(requestString == null || requestString.equals(""))        
        {
            SIPRequest retval = new SIPRequest();
            retval.setNullRequest();
javax.sip.message.Request varF9E19AD6135C970F387F77C6F3DE4477_1892247274 =             retval;
            varF9E19AD6135C970F387F77C6F3DE4477_1892247274.addTaint(taint);
            return varF9E19AD6135C970F387F77C6F3DE4477_1892247274;
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
        ParseException varB861AEF1673444A6D220FAA8E5154773_1722252938 = new ParseException(requestString, 0);
        varB861AEF1673444A6D220FAA8E5154773_1722252938.addTaint(taint);
        throw varB861AEF1673444A6D220FAA8E5154773_1722252938;
        }
javax.sip.message.Request var3A0DD2F3DF1CA3ABF8090503156E6432_1855402312 =         (SIPRequest) sipMessage;
        var3A0DD2F3DF1CA3ABF8090503156E6432_1855402312.addTaint(taint);
        return var3A0DD2F3DF1CA3ABF8090503156E6432_1855402312;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.831 -0400", hash_original_method = "8329107E7147BB5F0DCDAFE41A50D91D", hash_generated_method = "71547E01B2241FC2C9788BA7CE327DE8")
    public Response createResponse(String responseString) throws java.text.ParseException {
        addTaint(responseString.getTaint());
        if(responseString == null)        
        {
Response varB48B9712E3F6A0CC5E200F148717B33F_1535147458 =         new SIPResponse();
        varB48B9712E3F6A0CC5E200F148717B33F_1535147458.addTaint(taint);
        return varB48B9712E3F6A0CC5E200F148717B33F_1535147458;
        }
        StringMsgParser smp = new StringMsgParser();
        SIPMessage sipMessage = smp.parseSIPMessage(responseString);
        if(!(sipMessage instanceof SIPResponse))        
        {
        ParseException var46578DA3026D1C0D948103C86B94EEFD_1126227484 = new ParseException(responseString, 0);
        var46578DA3026D1C0D948103C86B94EEFD_1126227484.addTaint(taint);
        throw var46578DA3026D1C0D948103C86B94EEFD_1126227484;
        }
Response varCB1C328DEADD598C5350BF81734F0282_1361102278 =         (SIPResponse) sipMessage;
        varCB1C328DEADD598C5350BF81734F0282_1361102278.addTaint(taint);
        return varCB1C328DEADD598C5350BF81734F0282_1361102278;
        // ---------- Original Method ----------
        //if (responseString == null)
            //return new SIPResponse();
        //StringMsgParser smp = new StringMsgParser();
        //SIPMessage sipMessage = smp.parseSIPMessage(responseString);
        //if (!(sipMessage instanceof SIPResponse))
            //throw new ParseException(responseString, 0);
        //return (SIPResponse) sipMessage;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.831 -0400", hash_original_method = "F6370A15361A54B6EDEFA955061D514D", hash_generated_method = "3D40FEC77C6384E42F8318075B55B80B")
    public void setDefaultUserAgentHeader(UserAgentHeader userAgent) {
        addTaint(userAgent.getTaint());
        MessageFactoryImpl.userAgent = userAgent;
        // ---------- Original Method ----------
        //MessageFactoryImpl.userAgent = userAgent;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.831 -0400", hash_original_method = "86783F390E61522F639FC7DF78604B5D", hash_generated_method = "37DD24912CBF3A3A4D14C400540C0069")
    public void setDefaultServerHeader(ServerHeader server) {
        addTaint(server.getTaint());
        MessageFactoryImpl.server = server;
        // ---------- Original Method ----------
        //MessageFactoryImpl.server = server;
    }

    
    @DSModeled(DSC.SAFE)
    public static UserAgentHeader getDefaultUserAgentHeader() {
        return userAgent;
    }

    
    @DSModeled(DSC.SAFE)
    public static ServerHeader getDefaultServerHeader() {
        return server;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.832 -0400", hash_original_method = "7A37B9B6512C6512FDCFFA4B5CE85073", hash_generated_method = "C56EF43FD986C796891D77B703D1446C")
    public void setDefaultContentEncodingCharset(String charset) throws NullPointerException,
    IllegalArgumentException {
        addTaint(charset.getTaint());
        if(charset == null)        
        {
        NullPointerException var2E325D1E8870351157D8C6AB415344DD_220910933 = new NullPointerException ("Null argument!");
        var2E325D1E8870351157D8C6AB415344DD_220910933.addTaint(taint);
        throw var2E325D1E8870351157D8C6AB415344DD_220910933;
        }
        MessageFactoryImpl.defaultContentEncodingCharset = charset;
        // ---------- Original Method ----------
        //if (charset == null ) throw new NullPointerException ("Null argument!");
        //MessageFactoryImpl.defaultContentEncodingCharset = charset;
    }

    
    @DSModeled(DSC.SAFE)
    public static String getDefaultContentEncodingCharset() {
        return MessageFactoryImpl.defaultContentEncodingCharset;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.833 -0400", hash_original_method = "86E485BB3E030FD77D4D70ABB6598D25", hash_generated_method = "8FB18627040661970BEC6512960BB131")
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
MultipartMimeContent varF9E19AD6135C970F387F77C6F3DE4477_792460915 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_792460915.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_792460915;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.833 -0400", hash_original_field = "E35C353DE529B5A3041CFFE2B7AD3334", hash_generated_field = "790B4B09B170A9194D25942ACCB3ACEB")

    private static String defaultContentEncodingCharset = "UTF-8";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.833 -0400", hash_original_field = "FA71F997FA1A947459DC5495FDB40B0F", hash_generated_field = "52E17AB48D222AC2268208CD5EE77BA5")

    private static UserAgentHeader userAgent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.833 -0400", hash_original_field = "CF1E8C14E54505F60AA10CEB8D5D8AB3", hash_generated_field = "18CB845DD4EFE6EE2073E71A0755D764")

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

