package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Host;
import gov.nist.core.HostNameParser;
import gov.nist.javax.sip.SIPConstants;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.address.GenericURI;
import gov.nist.javax.sip.address.SipUri;
import gov.nist.javax.sip.address.TelephoneNumber;
import gov.nist.javax.sip.header.ExtensionHeaderImpl;
import gov.nist.javax.sip.header.NameMap;
import gov.nist.javax.sip.header.RequestLine;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.StatusLine;
import gov.nist.javax.sip.message.SIPMessage;
import gov.nist.javax.sip.message.SIPRequest;
import gov.nist.javax.sip.message.SIPResponse;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;

public class StringMsgParser {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.470 -0500", hash_original_method = "E55ED4E8D45A4ED321FE77BA414F4370", hash_generated_method = "078D6A91AF2AFA0E63B3A8F35C2A98A2")
    
public static void setComputeContentLengthFromMessage(
            boolean computeContentLengthFromMessage) {
        StringMsgParser.computeContentLengthFromMessage = computeContentLengthFromMessage;
    }

    /**
     * Test code.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.483 -0500", hash_original_method = "CDBF913024B5ED71496AB91FB35DA8A0", hash_generated_method = "4092FD4E8B5AF5D9204A3378F2BA7E37")
    
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

            @DSSafe(DSCat.SAFE_LIST)
            public void run() {
                for (int i = 0; i < messages.length; i++) {
                    StringMsgParser smp = new StringMsgParser();
                    try {
                        SIPMessage sipMessage = smp
                                .parseSIPMessage(messages[i]);
                        System.out.println(" i = " + i + " branchId = "
                                + sipMessage.getTopmostVia().getBranch());
                        // System.out.println("encoded " +
                        // sipMessage.toString());
                    } catch (ParseException ex) {

                    }

                    // System.out.println("dialog id = " +
                    // sipMessage.getDialogId(false));
                }
            }
        }

        for (int i = 0; i < 20; i++) {
            new Thread(new ParserThread(messages)).start();
        }

    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.422 -0500", hash_original_field = "F0B5F632149A7F653D7F41A22A1ADA42", hash_generated_field = "A4CB644B81B9880592D43A90E29E3123")

    private static boolean computeContentLengthFromMessage = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.412 -0500", hash_original_field = "634C12985CE6ECEC1246829FA58BCD72", hash_generated_field = "7E0AA0556EE34EDC1E14E7271C2271D7")

    protected boolean readBody;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.414 -0500", hash_original_field = "39B3B432102584B1DCF65A99D4A9A6D5", hash_generated_field = "1B834CF99672F368DBE005CE727DA4BD")

    private ParseExceptionListener parseExceptionListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.417 -0500", hash_original_field = "3818BE182D2E52DDE9CA4F5353E06BDA", hash_generated_field = "71F8C7FC9A6DFE4A45B8B3445B6FC291")

    private String rawStringMessage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.419 -0500", hash_original_field = "BDC54631C4936EA236C85607E0FD63F5", hash_generated_field = "02B827874E8744100DF748B4791EB7C5")

    private boolean strict;

    /**
     * @since v0.9
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.424 -0500", hash_original_method = "03434E90443FF3CC6928C5F00042D419", hash_generated_method = "35B29D519ACA0C846314797028EE4DBC")
    
public StringMsgParser() {
        super();
        readBody = true;
    }

    /**
     * Constructor (given a parse exception handler).
     *
     * @since 1.0
     * @param exhandler
     *            is the parse exception listener for the message parser.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.427 -0500", hash_original_method = "84F5B97F6353CE6241343807C31ED063", hash_generated_method = "13B9C917064301EEF4F07E7D56C012A4")
    
public StringMsgParser(ParseExceptionListener exhandler) {
        this();
        parseExceptionListener = exhandler;
    }

    /**
     * Add a handler for header parsing errors.
     *
     * @param pexhandler
     *            is a class that implements the ParseExceptionListener
     *            interface.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.430 -0500", hash_original_method = "E7BB96D94C72A71CC55D419208731E5E", hash_generated_method = "8980EFE71B5236DBD0827B78269A5B06")
    
public void setParseExceptionListener(ParseExceptionListener pexhandler) {
        parseExceptionListener = pexhandler;
    }

    /**
     * Parse a buffer containing a single SIP Message where the body is an array
     * of un-interpreted bytes. This is intended for parsing the message from a
     * memory buffer when the buffer. Incorporates a bug fix for a bug that was
     * noted by Will Sullin of Callcast
     *
     * @param msgBuffer
     *            a byte buffer containing the messages to be parsed. This can
     *            consist of multiple SIP Messages concatenated together.
     * @return a SIPMessage[] structure (request or response) containing the
     *         parsed SIP message.
     * @exception ParseException
     *                is thrown when an illegal message has been encountered
     *                (and the rest of the buffer is discarded).
     * @see ParseExceptionListener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.433 -0500", hash_original_method = "9C5089EA8774478643AAED9197A2D229", hash_generated_method = "1B419A4432CD72352E4A475FF0C7FEE9")
    
public SIPMessage parseSIPMessage(byte[] msgBuffer) throws ParseException {
        if (msgBuffer == null || msgBuffer.length == 0)
            return null;

        int i = 0;

        // Squeeze out any leading control character.
        try {
            while (msgBuffer[i] < 0x20)
                i++;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            // Array contains only control char, return null.
            return null;
        }

        // Iterate thru the request/status line and headers.
        String currentLine = null;
        String currentHeader = null;
        boolean isFirstLine = true;
        SIPMessage message = null;
        do
        {
            int lineStart = i;

            // Find the length of the line.
            try {
                while (msgBuffer[i] != '\r' && msgBuffer[i] != '\n')
                    i++;
            }
            catch (ArrayIndexOutOfBoundsException e) {
                // End of the message.
                break;
            }
            int lineLength = i - lineStart;

            // Make it a String.
            try {
                currentLine = new String(msgBuffer, lineStart, lineLength, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new ParseException("Bad message encoding!", 0);
            }

            currentLine = trimEndOfLine(currentLine);

            if (currentLine.length() == 0) {
                // Last header line, process the previous buffered header.
                if (currentHeader != null && message != null) {
                     processHeader(currentHeader, message);
                 }

            }
            else {
                if (isFirstLine) {
                    message = processFirstLine(currentLine);
                } else {
                    char firstChar = currentLine.charAt(0);
                    if (firstChar == '\t' || firstChar == ' ') {
                        if (currentHeader == null)
                            throw new ParseException("Bad header continuation.", 0);

                        // This is a continuation, append it to the previous line.
                        currentHeader += currentLine.substring(1);
                    }
                    else {
                        if (currentHeader != null && message != null) {
                             processHeader(currentHeader, message);
                         }
                        currentHeader = currentLine;
                    }
                }
            }

            if (msgBuffer[i] == '\r' && msgBuffer.length > i+1 && msgBuffer[i+1] == '\n')
                i++;

            i++;

            isFirstLine = false;
        } while (currentLine.length() > 0); // End do - while

        if (message == null) throw new ParseException("Bad message", 0);
        message.setSize(i);

        if (readBody && message.getContentLength() != null &&
                message.getContentLength().getContentLength() != 0) {

            int bodyLength = msgBuffer.length - i;

            byte[] body = new byte[bodyLength];
            System.arraycopy(msgBuffer, i, body, 0, bodyLength);
            message.setMessageContent(body,computeContentLengthFromMessage ,message.getContentLength().getContentLength() );
        }

        return message;
    }

    /**
     * Parse a buffer containing one or more SIP Messages and return an array of
     * SIPMessage parsed structures.
     *
     * @param msgString
     *            a String containing the messages to be parsed. This can
     *            consist of multiple SIP Messages concatenated together.
     * @return a SIPMessage structure (request or response) containing the
     *         parsed SIP message.
     * @exception ParseException
     *                is thrown when an illegal message has been encountered
     *                (and the rest of the buffer is discarded).
     * @see ParseExceptionListener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.438 -0500", hash_original_method = "2180FC72509B511C247A77608998B3E2", hash_generated_method = "193C2A5F2CCEEBF10DEAD42BE7FAD8A5")
    
public SIPMessage parseSIPMessage(String msgString) throws ParseException {
        if (msgString == null || msgString.length() == 0)
            return null;

        rawStringMessage = msgString;

        int i = 0;

        // Squeeze out any leading control character.
        try {
            while (msgString.charAt(i) < 0x20)
                i++;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            // Array contains only control char, return null.
            return null;
        } catch (StringIndexOutOfBoundsException ex) {
            return null;
        }

        // Iterate thru the request/status line and headers.
        String currentLine = null;
        String currentHeader = null;
        boolean isFirstLine = true;
        SIPMessage message = null;
        do
        {
            int lineStart = i;

            // Find the length of the line.
            try {
                char c = msgString.charAt(i);
                while (c != '\r' && c != '\n')
                    c = msgString.charAt(++i);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                // End of the message.
                break;
            } catch ( StringIndexOutOfBoundsException ex) {
                break;
            }

            // Make it a String.
            currentLine = msgString.substring(lineStart, i);
            currentLine = trimEndOfLine(currentLine);

            if (currentLine.length() == 0) {
                // Last header line, process the previous buffered header.
                if (currentHeader != null) {
                    processHeader(currentHeader, message);
                }
            }
            else {
                if (isFirstLine) {
                    message = processFirstLine(currentLine);
                } else {
                    char firstChar = currentLine.charAt(0);
                    if (firstChar == '\t' || firstChar == ' ') {
                        if (currentHeader == null)
                            throw new ParseException("Bad header continuation.", 0);

                        // This is a continuation, append it to the previous line.
                        currentHeader += currentLine.substring(1);
                    }
                    else {
                        if (currentHeader != null) {
                            processHeader(currentHeader, message);
                        }
                        currentHeader = currentLine;
                    }
                }
            }

            if (msgString.charAt(i) == '\r' && msgString.length() > i+1 && msgString.charAt(i+1) == '\n')
                i++;

            i++;

            isFirstLine = false;
        }
        while (currentLine.length() > 0);

        message.setSize(i);

        // Check for content legth header
        if (readBody && message.getContentLength() != null ) {
            if ( message.getContentLength().getContentLength() != 0) {
                String body = msgString.substring(i);
                message.setMessageContent(body,this.strict,computeContentLengthFromMessage,message.getContentLength().getContentLength());
             } else if (!computeContentLengthFromMessage && message.getContentLength().getContentLength() == 0 && !msgString.endsWith("\r\n\r\n") ){
                 if ( strict ) {
                     throw new ParseException("Extraneous characters at the end of the message ",i);
                 }
             }

        }

        return message;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.441 -0500", hash_original_method = "790601CAF711B74124A1DBA9FDFB3A7B", hash_generated_method = "6AB5AD0FEFC47BFD85BB51F416D0C5F0")
    
private String trimEndOfLine(String line) {
        if (line == null)
            return line;

        int i = line.length() - 1;
        while (i >= 0 && line.charAt(i) <= 0x20)
            i--;

        if (i == line.length() - 1)
            return line;

        if (i == -1)
            return "";

        return line.substring(0, i+1);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.444 -0500", hash_original_method = "E1A152A7092436D65484E6472132234E", hash_generated_method = "1EA560A8F950937693E119DE7973E4CA")
    
private SIPMessage processFirstLine(String firstLine) throws ParseException {
        SIPMessage message;
        if (!firstLine.startsWith(SIPConstants.SIP_VERSION_STRING)) {
            message = new SIPRequest();
            try {
                RequestLine requestLine = new RequestLineParser(firstLine + "\n")
                        .parse();
                ((SIPRequest) message).setRequestLine(requestLine);
            } catch (ParseException ex) {
                if (this.parseExceptionListener != null)
                    this.parseExceptionListener.handleException(ex, message,
                            RequestLine.class, firstLine, rawStringMessage);
                else
                    throw ex;

            }
        } else {
            message = new SIPResponse();
            try {
                StatusLine sl = new StatusLineParser(firstLine + "\n").parse();
                ((SIPResponse) message).setStatusLine(sl);
            } catch (ParseException ex) {
                if (this.parseExceptionListener != null) {
                    this.parseExceptionListener.handleException(ex, message,
                            StatusLine.class, firstLine, rawStringMessage);
                } else
                    throw ex;

            }
        }
        return message;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.447 -0500", hash_original_method = "825D9502572A55E55AC5E33884E71C29", hash_generated_method = "E884BF3BFFEBA037ADB951B9BCD4A7ED")
    
private void processHeader(String header, SIPMessage message) throws ParseException {
        if (header == null || header.length() == 0)
            return;

        HeaderParser headerParser = null;
        try {
            headerParser = ParserFactory.createParser(header + "\n");
        } catch (ParseException ex) {
            this.parseExceptionListener.handleException(ex, message, null,
                    header, rawStringMessage);
            return;
        }

        try {
            SIPHeader sipHeader = headerParser.parse();
            message.attachHeader(sipHeader, false);
        } catch (ParseException ex) {
            if (this.parseExceptionListener != null) {
                String headerName = Lexer.getHeaderName(header);
                Class headerClass = NameMap.getClassFromName(headerName);
                if (headerClass == null) {
                    headerClass = ExtensionHeaderImpl.class;

                }
                this.parseExceptionListener.handleException(ex, message,
                        headerClass, header, rawStringMessage);

            }
        }
    }

    /**
     * Parse an address (nameaddr or address spec) and return and address
     * structure.
     *
     * @param address
     *            is a String containing the address to be parsed.
     * @return a parsed address structure.
     * @since v1.0
     * @exception ParseException
     *                when the address is badly formatted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.449 -0500", hash_original_method = "049BA210A39AB5443B08132FD51D457E", hash_generated_method = "67E667399F88AE435AF274DA2626B05F")
    
public AddressImpl parseAddress(String address) throws ParseException {
        AddressParser addressParser = new AddressParser(address);
        return addressParser.address(true);
    }

    /**
     * Parse a host:port and return a parsed structure.
     *
     * @param hostport
     *            is a String containing the host:port to be parsed
     * @return a parsed address structure.
     * @since v1.0
     * @exception throws
     *                a ParseException when the address is badly formatted.
     *
    public HostPort parseHostPort(String hostport) throws ParseException {
        Lexer lexer = new Lexer("charLexer", hostport);
        return new HostNameParser(lexer).hostPort();

    }
    */

    /**
     * Parse a host name and return a parsed structure.
     *
     * @param host
     *            is a String containing the host name to be parsed
     * @return a parsed address structure.
     * @since v1.0
     * @exception ParseException
     *                a ParseException when the hostname is badly formatted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.451 -0500", hash_original_method = "6E5629CC68B4185F1ADA3485008A15B3", hash_generated_method = "3757B6D1F18269421988179AE69EAB05")
    
public Host parseHost(String host) throws ParseException {
        Lexer lexer = new Lexer("charLexer", host);
        return new HostNameParser(lexer).host();

    }

    /**
     * Parse a telephone number return a parsed structure.
     *
     * @param telephone_number
     *            is a String containing the telephone # to be parsed
     * @return a parsed address structure.
     * @since v1.0
     * @exception ParseException
     *                a ParseException when the address is badly formatted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.454 -0500", hash_original_method = "FA67D7760B995854EEA852AD4B17EA85", hash_generated_method = "EFBC73C8AAB088A9FB92BE8F4CD8B42C")
    
public TelephoneNumber parseTelephoneNumber(String telephone_number)
            throws ParseException {
        // Bug fix contributed by Will Scullin
        return new URLParser(telephone_number).parseTelephoneNumber(true);

    }

    /**
     * Parse a SIP url from a string and return a URI structure for it.
     *
     * @param url
     *            a String containing the URI structure to be parsed.
     * @return A parsed URI structure
     * @exception ParseException
     *                if there was an error parsing the message.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.456 -0500", hash_original_method = "F49AF4817F29179E4378A66D59AF945F", hash_generated_method = "0BDFB16238344617095C12C55C0809DF")
    
public SipUri parseSIPUrl(String url) throws ParseException {
        try {
            return new URLParser(url).sipURL(true);
        } catch (ClassCastException ex) {
            throw new ParseException(url + " Not a SIP URL ", 0);
        }
    }

    /**
     * Parse a uri from a string and return a URI structure for it.
     *
     * @param url
     *            a String containing the URI structure to be parsed.
     * @return A parsed URI structure
     * @exception ParseException
     *                if there was an error parsing the message.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.458 -0500", hash_original_method = "40F3B3649F989E59FAF074C2858F6B9B", hash_generated_method = "26A0276884CC044487B07E4402CDD314")
    
public GenericURI parseUrl(String url) throws ParseException {
        return new URLParser(url).parse();
    }

    /**
     * Parse an individual SIP message header from a string.
     *
     * @param header
     *            String containing the SIP header.
     * @return a SIPHeader structure.
     * @exception ParseException
     *                if there was an error parsing the message.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.462 -0500", hash_original_method = "6152413E77E62620D4330DAF5944A1B1", hash_generated_method = "08F4CAC237F3618F93B18A9A4E1E9CA1")
    
public SIPHeader parseSIPHeader(String header) throws ParseException {
        int start = 0;
        int end = header.length() - 1;
        try {
            // Squeeze out any leading control character.
            while (header.charAt(start) <= 0x20)
                start++;

            // Squeeze out any trailing control character.
            while (header.charAt(end) <= 0x20)
                end--;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            // Array contains only control char.
            throw new ParseException("Empty header.", 0);
        }

        StringBuffer buffer = new StringBuffer(end + 1);
        int i = start;
        int lineStart = start;
        boolean endOfLine = false;
        while (i <= end) {
            char c = header.charAt(i);
            if (c == '\r' || c == '\n') {
                if (!endOfLine) {
                    buffer.append(header.substring(lineStart, i));
                    endOfLine = true;
                }
            }
            else {
                if (endOfLine) {
                    endOfLine = false;
                    if (c == ' ' || c == '\t') {
                        buffer.append(' ');
                        lineStart = i + 1;
                    }
                    else {
                        lineStart = i;
                    }
                }
            }

            i++;
        }
        buffer.append(header.substring(lineStart, i));
        buffer.append('\n');

        HeaderParser hp = ParserFactory.createParser(buffer.toString());
        if (hp == null)
            throw new ParseException("could not create parser", 0);
        return hp.parse();
    }

    /**
     * Parse the SIP Request Line
     *
     * @param requestLine
     *            a String containing the request line to be parsed.
     * @return a RequestLine structure that has the parsed RequestLine
     * @exception ParseException
     *                if there was an error parsing the requestLine.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.464 -0500", hash_original_method = "C661D43CA4BEB0154AFD6A7B8492896F", hash_generated_method = "8964EBEF8322BD4922C3A52D42F0D038")
    
public RequestLine parseSIPRequestLine(String requestLine)
            throws ParseException {
        requestLine += "\n";
        return new RequestLineParser(requestLine).parse();
    }

    /**
     * Parse the SIP Response message status line
     *
     * @param statusLine
     *            a String containing the Status line to be parsed.
     * @return StatusLine class corresponding to message
     * @exception ParseException
     *                if there was an error parsing
     * @see StatusLine
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.468 -0500", hash_original_method = "9FDE6314AF63D7F1DD1D0AE258CFAA9B", hash_generated_method = "CEF177E2B1177F4D9C650F330300EDD2")
    
public StatusLine parseSIPStatusLine(String statusLine)
            throws ParseException {
        statusLine += "\n";
        return new StatusLineParser(statusLine).parse();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:43.485 -0500", hash_original_method = "EC510198678EBDAFC45D82B058FF4015", hash_generated_method = "A576CD55F5552CD6C33C357CE066752B")
    
public void setStrict(boolean strict) {
       this.strict = strict;
        
    }
}

