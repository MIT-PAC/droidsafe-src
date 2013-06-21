package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.Host;
import gov.nist.core.HostNameParser;
import gov.nist.javax.sip.SIPConstants;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.address.GenericURI;
import gov.nist.javax.sip.address.SipUri;
import gov.nist.javax.sip.address.TelephoneNumber;
import gov.nist.javax.sip.header.*;
import gov.nist.javax.sip.message.SIPMessage;
import gov.nist.javax.sip.message.SIPRequest;
import gov.nist.javax.sip.message.SIPResponse;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;

public class StringMsgParser {
    protected boolean readBody;
    private ParseExceptionListener parseExceptionListener;
    private String rawStringMessage;
    private boolean strict;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.577 -0400", hash_original_method = "03434E90443FF3CC6928C5F00042D419", hash_generated_method = "2EF648646CCD07FCEF63A7835151765E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringMsgParser() {
        super();
        readBody = true;
        // ---------- Original Method ----------
        //readBody = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.577 -0400", hash_original_method = "84F5B97F6353CE6241343807C31ED063", hash_generated_method = "F7284FEAAD036067D193CEEF2FB87E03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringMsgParser(ParseExceptionListener exhandler) {
        this();
        dsTaint.addTaint(exhandler.dsTaint);
        // ---------- Original Method ----------
        //parseExceptionListener = exhandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.578 -0400", hash_original_method = "E7BB96D94C72A71CC55D419208731E5E", hash_generated_method = "64C856D21439F2FB25643CE711DA1A8A")
    @DSModeled(DSC.SAFE)
    public void setParseExceptionListener(ParseExceptionListener pexhandler) {
        dsTaint.addTaint(pexhandler.dsTaint);
        // ---------- Original Method ----------
        //parseExceptionListener = pexhandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.579 -0400", hash_original_method = "9C5089EA8774478643AAED9197A2D229", hash_generated_method = "8C2C807868AE14708C8159E6882A9D65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPMessage parseSIPMessage(byte[] msgBuffer) throws ParseException {
        dsTaint.addTaint(msgBuffer[0]);
        int i;
        i = 0;
        String currentLine;
        currentLine = null;
        String currentHeader;
        currentHeader = null;
        boolean isFirstLine;
        isFirstLine = true;
        SIPMessage message;
        message = null;
        {
            int lineStart;
            lineStart = i;
            int lineLength;
            lineLength = i - lineStart;
            try 
            {
                currentLine = new String(msgBuffer, lineStart, lineLength, "UTF-8");
            } //End block
            catch (UnsupportedEncodingException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException("Bad message encoding!", 0);
            } //End block
            currentLine = trimEndOfLine(currentLine);
            {
                boolean var77FDA07008A6EE8388573EBC8194D560_915832989 = (currentLine.length() == 0);
                {
                    {
                        processHeader(currentHeader, message);
                    } //End block
                } //End block
                {
                    {
                        message = processFirstLine(currentLine);
                    } //End block
                    {
                        char firstChar;
                        firstChar = currentLine.charAt(0);
                        {
                            if (DroidSafeAndroidRuntime.control) throw new ParseException("Bad header continuation.", 0);
                            currentHeader += currentLine.substring(1);
                        } //End block
                        {
                            {
                                processHeader(currentHeader, message);
                            } //End block
                            currentHeader = currentLine;
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
            isFirstLine = false;
        } //End block
        {
            boolean var1E1E76B25946A0B0BAEC1D3D3CF41AC5_1423838435 = (currentLine.length() > 0);
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new ParseException("Bad message", 0);
        message.setSize(i);
        {
            boolean var80C1D7AF139CBA766D6496F3FF8E5A49_1978091427 = (readBody && message.getContentLength() != null &&
                message.getContentLength().getContentLength() != 0);
            {
                int bodyLength;
                bodyLength = msgBuffer.length - i;
                byte[] body;
                body = new byte[bodyLength];
                System.arraycopy(msgBuffer, i, body, 0, bodyLength);
                message.setMessageContent(body,computeContentLengthFromMessage ,message.getContentLength().getContentLength() );
            } //End block
        } //End collapsed parenthetic
        return (SIPMessage)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.580 -0400", hash_original_method = "2180FC72509B511C247A77608998B3E2", hash_generated_method = "387094411B8BEF6F655CAA69280D139E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPMessage parseSIPMessage(String msgString) throws ParseException {
        dsTaint.addTaint(msgString);
        {
            boolean var7D89CFD8482AB6A8AD85DA0DFBABF979_773494758 = (msgString == null || msgString.length() == 0);
        } //End collapsed parenthetic
        int i;
        i = 0;
        try 
        {
            {
                boolean var859977E92DA9B12FACA1EC0F1FA4D264_1222624096 = (msgString.charAt(i) < 0x20);
            } //End collapsed parenthetic
        } //End block
        catch (ArrayIndexOutOfBoundsException e)
        { }
        catch (StringIndexOutOfBoundsException ex)
        { }
        String currentLine;
        currentLine = null;
        String currentHeader;
        currentHeader = null;
        boolean isFirstLine;
        isFirstLine = true;
        SIPMessage message;
        message = null;
        {
            int lineStart;
            lineStart = i;
            try 
            {
                char c;
                c = msgString.charAt(i);
                c = msgString.charAt(++i);
            } //End block
            catch (ArrayIndexOutOfBoundsException e)
            { }
            catch (StringIndexOutOfBoundsException ex)
            { }
            currentLine = msgString.substring(lineStart, i);
            currentLine = trimEndOfLine(currentLine);
            {
                boolean var77FDA07008A6EE8388573EBC8194D560_1192955890 = (currentLine.length() == 0);
                {
                    {
                        processHeader(currentHeader, message);
                    } //End block
                } //End block
                {
                    {
                        message = processFirstLine(currentLine);
                    } //End block
                    {
                        char firstChar;
                        firstChar = currentLine.charAt(0);
                        {
                            if (DroidSafeAndroidRuntime.control) throw new ParseException("Bad header continuation.", 0);
                            currentHeader += currentLine.substring(1);
                        } //End block
                        {
                            {
                                processHeader(currentHeader, message);
                            } //End block
                            currentHeader = currentLine;
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                boolean var66897782C6CABBFB4C017CF430AC4CC7_684632072 = (msgString.charAt(i) == '\r' && msgString.length() > i+1 && msgString.charAt(i+1) == '\n');
            } //End collapsed parenthetic
            isFirstLine = false;
        } //End block
        {
            boolean var1E1E76B25946A0B0BAEC1D3D3CF41AC5_917405771 = (currentLine.length() > 0);
        } //End collapsed parenthetic
        message.setSize(i);
        {
            boolean var2C8FC7F5C20AA0F801C7E4D85C52C9B2_1605228035 = (readBody && message.getContentLength() != null);
            {
                {
                    boolean var19C30E534A644723268FE932A6BCE642_1277895109 = (message.getContentLength().getContentLength() != 0);
                    {
                        String body;
                        body = msgString.substring(i);
                        message.setMessageContent(body,this.strict,computeContentLengthFromMessage,message.getContentLength().getContentLength());
                    } //End block
                    {
                        boolean var25EF6C317ABB678F71EA951E09435C2F_73308272 = (!computeContentLengthFromMessage && message.getContentLength().getContentLength() == 0 && !msgString.endsWith("\r\n\r\n"));
                        {
                            {
                                if (DroidSafeAndroidRuntime.control) throw new ParseException("Extraneous characters at the end of the message ",i);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (SIPMessage)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.580 -0400", hash_original_method = "790601CAF711B74124A1DBA9FDFB3A7B", hash_generated_method = "49164631E9D1F001FB4810B1C53B0DCF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String trimEndOfLine(String line) {
        dsTaint.addTaint(line);
        int i;
        i = line.length() - 1;
        {
            boolean var0ABA4510E5F4FEBF04BA26FD153A806B_1996754638 = (i >= 0 && line.charAt(i) <= 0x20);
        } //End collapsed parenthetic
        {
            boolean var8955262F2B285AD01BE6086E0999045B_1958831276 = (i == line.length() - 1);
        } //End collapsed parenthetic
        String var822036EDF7B27065716375EC61934DB1_1102963125 = (line.substring(0, i+1));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (line == null)
            //return line;
        //int i = line.length() - 1;
        //while (i >= 0 && line.charAt(i) <= 0x20)
            //i--;
        //if (i == line.length() - 1)
            //return line;
        //if (i == -1)
            //return "";
        //return line.substring(0, i+1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.580 -0400", hash_original_method = "E1A152A7092436D65484E6472132234E", hash_generated_method = "008B19D670A66431861CD1589AF2BDCA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SIPMessage processFirstLine(String firstLine) throws ParseException {
        dsTaint.addTaint(firstLine);
        SIPMessage message;
        {
            boolean varE13C2B742A2A12CE615C7B3D8E636FC5_1830153707 = (!firstLine.startsWith(SIPConstants.SIP_VERSION_STRING));
            {
                message = new SIPRequest();
                try 
                {
                    RequestLine requestLine;
                    requestLine = new RequestLineParser(firstLine + "\n")
                        .parse();
                    ((SIPRequest) message).setRequestLine(requestLine);
                } //End block
                catch (ParseException ex)
                {
                    this.parseExceptionListener.handleException(ex, message,
                            RequestLine.class, firstLine, rawStringMessage);
                    if (DroidSafeAndroidRuntime.control) throw ex;
                } //End block
            } //End block
            {
                message = new SIPResponse();
                try 
                {
                    StatusLine sl;
                    sl = new StatusLineParser(firstLine + "\n").parse();
                    ((SIPResponse) message).setStatusLine(sl);
                } //End block
                catch (ParseException ex)
                {
                    {
                        this.parseExceptionListener.handleException(ex, message,
                            StatusLine.class, firstLine, rawStringMessage);
                    } //End block
                    if (DroidSafeAndroidRuntime.control) throw ex;
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (SIPMessage)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.581 -0400", hash_original_method = "825D9502572A55E55AC5E33884E71C29", hash_generated_method = "01D87725156D776E194C266D938558AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void processHeader(String header, SIPMessage message) throws ParseException {
        dsTaint.addTaint(message.dsTaint);
        dsTaint.addTaint(header);
        {
            boolean varE0603EF74A60306DC3A2D1CD57563139_747894640 = (header == null || header.length() == 0);
        } //End collapsed parenthetic
        HeaderParser headerParser;
        headerParser = null;
        try 
        {
            headerParser = ParserFactory.createParser(header + "\n");
        } //End block
        catch (ParseException ex)
        {
            this.parseExceptionListener.handleException(ex, message, null,
                    header, rawStringMessage);
        } //End block
        try 
        {
            SIPHeader sipHeader;
            sipHeader = headerParser.parse();
            message.attachHeader(sipHeader, false);
        } //End block
        catch (ParseException ex)
        {
            {
                String headerName;
                headerName = Lexer.getHeaderName(header);
                Class headerClass;
                headerClass = NameMap.getClassFromName(headerName);
                {
                    headerClass = ExtensionHeaderImpl.class;
                } //End block
                this.parseExceptionListener.handleException(ex, message,
                        headerClass, header, rawStringMessage);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.581 -0400", hash_original_method = "049BA210A39AB5443B08132FD51D457E", hash_generated_method = "16B64BD5DFF384208FD86C74636302A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AddressImpl parseAddress(String address) throws ParseException {
        dsTaint.addTaint(address);
        AddressParser addressParser;
        addressParser = new AddressParser(address);
        AddressImpl var9AFE73F3C51B68774250899C5B63CB3E_1948879449 = (addressParser.address(true));
        return (AddressImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //AddressParser addressParser = new AddressParser(address);
        //return addressParser.address(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.581 -0400", hash_original_method = "6E5629CC68B4185F1ADA3485008A15B3", hash_generated_method = "CD194EAB532B42B91C0368260D91B32E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Host parseHost(String host) throws ParseException {
        dsTaint.addTaint(host);
        Lexer lexer;
        lexer = new Lexer("charLexer", host);
        Host var9D3C737B13AB9DACD3088632F569BA94_33218931 = (new HostNameParser(lexer).host());
        return (Host)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Lexer lexer = new Lexer("charLexer", host);
        //return new HostNameParser(lexer).host();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.582 -0400", hash_original_method = "FA67D7760B995854EEA852AD4B17EA85", hash_generated_method = "E6120E816491AC01C9D1079C9436B502")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TelephoneNumber parseTelephoneNumber(String telephone_number) throws ParseException {
        dsTaint.addTaint(telephone_number);
        TelephoneNumber varAEB008D1AB577866D41A2F4E5A6DB9ED_698994330 = (new URLParser(telephone_number).parseTelephoneNumber(true));
        return (TelephoneNumber)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new URLParser(telephone_number).parseTelephoneNumber(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.582 -0400", hash_original_method = "F49AF4817F29179E4378A66D59AF945F", hash_generated_method = "924A156556D5E52785649F9EA0B767C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SipUri parseSIPUrl(String url) throws ParseException {
        dsTaint.addTaint(url);
        try 
        {
            SipUri varB43284FBB31D050A18F417203CD08A13_490954898 = (new URLParser(url).sipURL(true));
        } //End block
        catch (ClassCastException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(url + " Not a SIP URL ", 0);
        } //End block
        return (SipUri)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return new URLParser(url).sipURL(true);
        //} catch (ClassCastException ex) {
            //throw new ParseException(url + " Not a SIP URL ", 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.582 -0400", hash_original_method = "40F3B3649F989E59FAF074C2858F6B9B", hash_generated_method = "B6B56DD107E213F281E9F2263E26B345")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GenericURI parseUrl(String url) throws ParseException {
        dsTaint.addTaint(url);
        GenericURI varC2644D78AF7ACDC0656E503A074D2F2E_1002197949 = (new URLParser(url).parse());
        return (GenericURI)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new URLParser(url).parse();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.582 -0400", hash_original_method = "6152413E77E62620D4330DAF5944A1B1", hash_generated_method = "B7F483DCA12B6D76DA455AD94FC07386")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parseSIPHeader(String header) throws ParseException {
        dsTaint.addTaint(header);
        int start;
        start = 0;
        int end;
        end = header.length() - 1;
        try 
        {
            {
                boolean var8CAFC4B850226A8495EEFA3C5169032C_1025629132 = (header.charAt(start) <= 0x20);
            } //End collapsed parenthetic
            {
                boolean var5F1685AC9DD4CBAFA4A1EB91FD0B579B_1451621106 = (header.charAt(end) <= 0x20);
            } //End collapsed parenthetic
        } //End block
        catch (ArrayIndexOutOfBoundsException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException("Empty header.", 0);
        } //End block
        StringBuffer buffer;
        buffer = new StringBuffer(end + 1);
        int i;
        i = start;
        int lineStart;
        lineStart = start;
        boolean endOfLine;
        endOfLine = false;
        {
            char c;
            c = header.charAt(i);
            {
                {
                    buffer.append(header.substring(lineStart, i));
                    endOfLine = true;
                } //End block
            } //End block
            {
                {
                    endOfLine = false;
                    {
                        buffer.append(' ');
                        lineStart = i + 1;
                    } //End block
                    {
                        lineStart = i;
                    } //End block
                } //End block
            } //End block
        } //End block
        buffer.append(header.substring(lineStart, i));
        buffer.append('\n');
        HeaderParser hp;
        hp = ParserFactory.createParser(buffer.toString());
        if (DroidSafeAndroidRuntime.control) throw new ParseException("could not create parser", 0);
        SIPHeader varE4B6514287EE4269F9D81EAE9A2CBC69_56041692 = (hp.parse());
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.583 -0400", hash_original_method = "C661D43CA4BEB0154AFD6A7B8492896F", hash_generated_method = "D2243E9BE58A49A9F22E3F6FA2FFC5FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RequestLine parseSIPRequestLine(String requestLine) throws ParseException {
        dsTaint.addTaint(requestLine);
        requestLine += "\n";
        RequestLine var0364EEC39008C8CEFB0A94E850C5DA7E_1681229952 = (new RequestLineParser(requestLine).parse());
        return (RequestLine)dsTaint.getTaint();
        // ---------- Original Method ----------
        //requestLine += "\n";
        //return new RequestLineParser(requestLine).parse();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.583 -0400", hash_original_method = "9FDE6314AF63D7F1DD1D0AE258CFAA9B", hash_generated_method = "91A7544E19A13B09E903F34A51E3A178")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StatusLine parseSIPStatusLine(String statusLine) throws ParseException {
        dsTaint.addTaint(statusLine);
        statusLine += "\n";
        StatusLine varCDB1D8BDA0C26A7F6F2E8302C699B108_1563520153 = (new StatusLineParser(statusLine).parse());
        return (StatusLine)dsTaint.getTaint();
        // ---------- Original Method ----------
        //statusLine += "\n";
        //return new StatusLineParser(statusLine).parse();
    }

    
        public static void setComputeContentLengthFromMessage(
            boolean computeContentLengthFromMessage) {
        StringMsgParser.computeContentLengthFromMessage = computeContentLengthFromMessage;
    }

    
        public static void main(String[] args) throws ParseException {
        String messages[] = {
                "SIP/2.0 200 OK\r\n"
                        + "To: \"The Little Blister\" <sip:LittleGuy@there.com>;tag=469bc066\r\n"
                        + "From: \"The Master Blaster\" <sip:BigGuy@here.com>;tag=11\r\n"
                        + "Via: SIP/2.0/UDP 139.10.134.246:5060;branch=z9hG4bK8b0a86f6_1030c7d18e0_17;received=139.10.134.246\r\n"
                        + "Call-ID: 1030c7d18ae_a97b0b_b@8b0a86f6\r\n"
                        + "CSeq: 1 SUBSCRIBE\r\n"
                        + "Contact: <sip:172.16.11.162:5070>\r\n"
                        + "Content-Length: 0\r\n\r\n",
                "SIP/2.0 180 Ringing\r\n"
                        + "Via: SIP/2.0/UDP 172.18.1.29:5060;branch=z9hG4bK43fc10fb4446d55fc5c8f969607991f4\r\n"
                        + "To: \"0440\" <sip:0440@212.209.220.131>;tag=2600\r\n"
                        + "From: \"Andreas\" <sip:andreas@e-horizon.se>;tag=8524\r\n"
                        + "Call-ID: f51a1851c5f570606140f14c8eb64fd3@172.18.1.29\r\n"
                        + "CSeq: 1 INVITE\r\n" + "Max-Forwards: 70\r\n"
                        + "Record-Route: <sip:212.209.220.131:5060>\r\n"
                        + "Content-Length: 0\r\n\r\n",
                "REGISTER sip:nist.gov SIP/2.0\r\n"
                        + "Via: SIP/2.0/UDP 129.6.55.182:14826\r\n"
                        + "Max-Forwards: 70\r\n"
                        + "From: <sip:mranga@nist.gov>;tag=6fcd5c7ace8b4a45acf0f0cd539b168b;epid=0d4c418ddf\r\n"
                        + "To: <sip:mranga@nist.gov>\r\n"
                        + "Call-ID: c5679907eb954a8da9f9dceb282d7230@129.6.55.182\r\n"
                        + "CSeq: 1 REGISTER\r\n"
                        + "Contact: <sip:129.6.55.182:14826>;methods=\"INVITE, MESSAGE, INFO, SUBSCRIBE, OPTIONS, BYE, CANCEL, NOTIFY, ACK, REFER\"\r\n"
                        + "User-Agent: RTC/(Microsoft RTC)\r\n"
                        + "Event:  registration\r\n"
                        + "Allow-Events: presence\r\n"
                        + "Content-Length: 0\r\n\r\n"
                        + "INVITE sip:littleguy@there.com:5060 SIP/2.0\r\n"
                        + "Via: SIP/2.0/UDP 65.243.118.100:5050\r\n"
                        + "From: M. Ranganathan  <sip:M.Ranganathan@sipbakeoff.com>;tag=1234\r\n"
                        + "To: \"littleguy@there.com\" <sip:littleguy@there.com:5060> \r\n"
                        + "Call-ID: Q2AboBsaGn9!?x6@sipbakeoff.com \r\n"
                        + "CSeq: 1 INVITE \r\n"
                        + "Content-Length: 247\r\n\r\n"
                        + "v=0\r\n"
                        + "o=4855 13760799956958020 13760799956958020 IN IP4  129.6.55.78\r\n"
                        + "s=mysession session\r\n" + "p=+46 8 52018010\r\n"
                        + "c=IN IP4  129.6.55.78\r\n" + "t=0 0\r\n"
                        + "m=audio 6022 RTP/AVP 0 4 18\r\n"
                        + "a=rtpmap:0 PCMU/8000\r\n"
                        + "a=rtpmap:4 G723/8000\r\n"
                        + "a=rtpmap:18 G729A/8000\r\n" + "a=ptime:20\r\n" };
        class ParserThread implements Runnable {
            String[] messages;
            public ParserThread(String[] messagesToParse) {
                this.messages = messagesToParse;
            }
            public void run() {
                for (int i = 0; i < messages.length; i++) {
                    StringMsgParser smp = new StringMsgParser();
                    try {
                        SIPMessage sipMessage = smp
                                .parseSIPMessage(messages[i]);
                        System.out.println(" i = " + i + " branchId = "
                                + sipMessage.getTopmostVia().getBranch());
                    } catch (ParseException ex) {
                    }
                }
            }
        }
        for (int i = 0; i < 20; i++) {
            new Thread(new ParserThread(messages)).start();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.586 -0400", hash_original_method = "EC510198678EBDAFC45D82B058FF4015", hash_generated_method = "0354B80892A0D8E2A9E042E574374324")
    @DSModeled(DSC.SAFE)
    public void setStrict(boolean strict) {
        dsTaint.addTaint(strict);
        // ---------- Original Method ----------
        //this.strict = strict;
    }

    
    private static boolean computeContentLengthFromMessage = false;
}

