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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.434 -0400", hash_original_field = "F6A0B614A3E3F2033445BCEBD36D070B", hash_generated_field = "7E0AA0556EE34EDC1E14E7271C2271D7")

    protected boolean readBody;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.434 -0400", hash_original_field = "0E6EE533F6F7CB1037DB27980D2D40A6", hash_generated_field = "1B834CF99672F368DBE005CE727DA4BD")

    private ParseExceptionListener parseExceptionListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.434 -0400", hash_original_field = "9C8E56B49859E77E66AE351926812318", hash_generated_field = "71F8C7FC9A6DFE4A45B8B3445B6FC291")

    private String rawStringMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.434 -0400", hash_original_field = "2133FD717402A7966EE88D06F9E0B792", hash_generated_field = "02B827874E8744100DF748B4791EB7C5")

    private boolean strict;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.435 -0400", hash_original_method = "03434E90443FF3CC6928C5F00042D419", hash_generated_method = "2EF648646CCD07FCEF63A7835151765E")
    public  StringMsgParser() {
        super();
        readBody = true;
        // ---------- Original Method ----------
        //readBody = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.446 -0400", hash_original_method = "84F5B97F6353CE6241343807C31ED063", hash_generated_method = "C119674FD94FFD6C811D4B6C9741DB1D")
    public  StringMsgParser(ParseExceptionListener exhandler) {
        this();
        parseExceptionListener = exhandler;
        // ---------- Original Method ----------
        //parseExceptionListener = exhandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.447 -0400", hash_original_method = "E7BB96D94C72A71CC55D419208731E5E", hash_generated_method = "20F944E1A059060117121AD4A329ED73")
    public void setParseExceptionListener(ParseExceptionListener pexhandler) {
        parseExceptionListener = pexhandler;
        // ---------- Original Method ----------
        //parseExceptionListener = pexhandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.450 -0400", hash_original_method = "9C5089EA8774478643AAED9197A2D229", hash_generated_method = "F0640484A1815496769A9FD95E59F3F4")
    public SIPMessage parseSIPMessage(byte[] msgBuffer) throws ParseException {
        SIPMessage varB4EAC82CA7396A68D541C85D26508E83_1043303536 = null; //Variable for return #1
        SIPMessage varB4EAC82CA7396A68D541C85D26508E83_1454039254 = null; //Variable for return #2
        SIPMessage varB4EAC82CA7396A68D541C85D26508E83_1286683408 = null; //Variable for return #3
        varB4EAC82CA7396A68D541C85D26508E83_1043303536 = null;
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
                boolean var77FDA07008A6EE8388573EBC8194D560_1963142268 = (currentLine.length() == 0);
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
            boolean var1E1E76B25946A0B0BAEC1D3D3CF41AC5_1700901709 = (currentLine.length() > 0);
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new ParseException("Bad message", 0);
        message.setSize(i);
        {
            boolean var80C1D7AF139CBA766D6496F3FF8E5A49_1504440011 = (readBody && message.getContentLength() != null &&
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
        varB4EAC82CA7396A68D541C85D26508E83_1454039254 = message;
        addTaint(msgBuffer[0]);
        SIPMessage varA7E53CE21691AB073D9660D615818899_402700216; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_402700216 = varB4EAC82CA7396A68D541C85D26508E83_1043303536;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_402700216 = varB4EAC82CA7396A68D541C85D26508E83_1454039254;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_402700216 = varB4EAC82CA7396A68D541C85D26508E83_1286683408;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_402700216.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_402700216;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.468 -0400", hash_original_method = "2180FC72509B511C247A77608998B3E2", hash_generated_method = "443FBAAFB974D5B25664B9FEC07D56FA")
    public SIPMessage parseSIPMessage(String msgString) throws ParseException {
        SIPMessage varB4EAC82CA7396A68D541C85D26508E83_1819676736 = null; //Variable for return #1
        SIPMessage varB4EAC82CA7396A68D541C85D26508E83_1454357720 = null; //Variable for return #2
        SIPMessage varB4EAC82CA7396A68D541C85D26508E83_1963516180 = null; //Variable for return #3
        SIPMessage varB4EAC82CA7396A68D541C85D26508E83_694852006 = null; //Variable for return #4
        {
            boolean var7D89CFD8482AB6A8AD85DA0DFBABF979_1321089742 = (msgString == null || msgString.length() == 0);
            varB4EAC82CA7396A68D541C85D26508E83_1819676736 = null;
        } //End collapsed parenthetic
        rawStringMessage = msgString;
        int i;
        i = 0;
        try 
        {
            {
                boolean var859977E92DA9B12FACA1EC0F1FA4D264_103148836 = (msgString.charAt(i) < 0x20);
            } //End collapsed parenthetic
        } //End block
        catch (ArrayIndexOutOfBoundsException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1454357720 = null;
        } //End block
        catch (StringIndexOutOfBoundsException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1963516180 = null;
        } //End block
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
                boolean var77FDA07008A6EE8388573EBC8194D560_279284967 = (currentLine.length() == 0);
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
                boolean var66897782C6CABBFB4C017CF430AC4CC7_1853208086 = (msgString.charAt(i) == '\r' && msgString.length() > i+1 && msgString.charAt(i+1) == '\n');
            } //End collapsed parenthetic
            isFirstLine = false;
        } //End block
        {
            boolean var1E1E76B25946A0B0BAEC1D3D3CF41AC5_481421385 = (currentLine.length() > 0);
        } //End collapsed parenthetic
        message.setSize(i);
        {
            boolean var2C8FC7F5C20AA0F801C7E4D85C52C9B2_1238320076 = (readBody && message.getContentLength() != null);
            {
                {
                    boolean var19C30E534A644723268FE932A6BCE642_1777878022 = (message.getContentLength().getContentLength() != 0);
                    {
                        String body;
                        body = msgString.substring(i);
                        message.setMessageContent(body,this.strict,computeContentLengthFromMessage,message.getContentLength().getContentLength());
                    } //End block
                    {
                        boolean var25EF6C317ABB678F71EA951E09435C2F_1898755387 = (!computeContentLengthFromMessage && message.getContentLength().getContentLength() == 0 && !msgString.endsWith("\r\n\r\n"));
                        {
                            {
                                if (DroidSafeAndroidRuntime.control) throw new ParseException("Extraneous characters at the end of the message ",i);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_694852006 = message;
        SIPMessage varA7E53CE21691AB073D9660D615818899_888993165; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_888993165 = varB4EAC82CA7396A68D541C85D26508E83_1819676736;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_888993165 = varB4EAC82CA7396A68D541C85D26508E83_1454357720;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_888993165 = varB4EAC82CA7396A68D541C85D26508E83_1963516180;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_888993165 = varB4EAC82CA7396A68D541C85D26508E83_694852006;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_888993165.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_888993165;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.469 -0400", hash_original_method = "790601CAF711B74124A1DBA9FDFB3A7B", hash_generated_method = "B9D81C0B9ADF84137FAB71ED66186028")
    private String trimEndOfLine(String line) {
        String varB4EAC82CA7396A68D541C85D26508E83_781344267 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1848057146 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1410404178 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_920128185 = null; //Variable for return #4
        varB4EAC82CA7396A68D541C85D26508E83_781344267 = line;
        int i;
        i = line.length() - 1;
        {
            boolean var0ABA4510E5F4FEBF04BA26FD153A806B_1634078910 = (i >= 0 && line.charAt(i) <= 0x20);
        } //End collapsed parenthetic
        {
            boolean var8955262F2B285AD01BE6086E0999045B_1268303192 = (i == line.length() - 1);
            varB4EAC82CA7396A68D541C85D26508E83_1848057146 = line;
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1410404178 = "";
        varB4EAC82CA7396A68D541C85D26508E83_920128185 = line.substring(0, i+1);
        addTaint(line.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1325104301; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1325104301 = varB4EAC82CA7396A68D541C85D26508E83_781344267;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1325104301 = varB4EAC82CA7396A68D541C85D26508E83_1848057146;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1325104301 = varB4EAC82CA7396A68D541C85D26508E83_1410404178;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1325104301 = varB4EAC82CA7396A68D541C85D26508E83_920128185;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1325104301.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1325104301;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.477 -0400", hash_original_method = "E1A152A7092436D65484E6472132234E", hash_generated_method = "0E46A7A0050C00140BD4032A023D2250")
    private SIPMessage processFirstLine(String firstLine) throws ParseException {
        SIPMessage varB4EAC82CA7396A68D541C85D26508E83_924417328 = null; //Variable for return #1
        SIPMessage message;
        {
            boolean varE13C2B742A2A12CE615C7B3D8E636FC5_1331136575 = (!firstLine.startsWith(SIPConstants.SIP_VERSION_STRING));
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
        varB4EAC82CA7396A68D541C85D26508E83_924417328 = message;
        addTaint(firstLine.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_924417328.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_924417328;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.478 -0400", hash_original_method = "825D9502572A55E55AC5E33884E71C29", hash_generated_method = "5A81D4E21472D4E12930AD866D8D0B10")
    private void processHeader(String header, SIPMessage message) throws ParseException {
        {
            boolean varE0603EF74A60306DC3A2D1CD57563139_744980143 = (header == null || header.length() == 0);
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
        addTaint(header.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.488 -0400", hash_original_method = "049BA210A39AB5443B08132FD51D457E", hash_generated_method = "5CFB4898C4F05E43822465C1654B1CDA")
    public AddressImpl parseAddress(String address) throws ParseException {
        AddressImpl varB4EAC82CA7396A68D541C85D26508E83_766942655 = null; //Variable for return #1
        AddressParser addressParser;
        addressParser = new AddressParser(address);
        varB4EAC82CA7396A68D541C85D26508E83_766942655 = addressParser.address(true);
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_766942655.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_766942655;
        // ---------- Original Method ----------
        //AddressParser addressParser = new AddressParser(address);
        //return addressParser.address(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.492 -0400", hash_original_method = "6E5629CC68B4185F1ADA3485008A15B3", hash_generated_method = "97278199A85101858078D0ADD517F325")
    public Host parseHost(String host) throws ParseException {
        Host varB4EAC82CA7396A68D541C85D26508E83_1938748763 = null; //Variable for return #1
        Lexer lexer;
        lexer = new Lexer("charLexer", host);
        varB4EAC82CA7396A68D541C85D26508E83_1938748763 = new HostNameParser(lexer).host();
        addTaint(host.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1938748763.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1938748763;
        // ---------- Original Method ----------
        //Lexer lexer = new Lexer("charLexer", host);
        //return new HostNameParser(lexer).host();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.497 -0400", hash_original_method = "FA67D7760B995854EEA852AD4B17EA85", hash_generated_method = "D1994446A2BBBAB63AA913ACD011039B")
    public TelephoneNumber parseTelephoneNumber(String telephone_number) throws ParseException {
        TelephoneNumber varB4EAC82CA7396A68D541C85D26508E83_1541802948 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1541802948 = new URLParser(telephone_number).parseTelephoneNumber(true);
        addTaint(telephone_number.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1541802948.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1541802948;
        // ---------- Original Method ----------
        //return new URLParser(telephone_number).parseTelephoneNumber(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.497 -0400", hash_original_method = "F49AF4817F29179E4378A66D59AF945F", hash_generated_method = "E080A50B87D86903D7B640EDD8C22936")
    public SipUri parseSIPUrl(String url) throws ParseException {
        SipUri varB4EAC82CA7396A68D541C85D26508E83_1066811002 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1066811002 = new URLParser(url).sipURL(true);
        } //End block
        catch (ClassCastException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(url + " Not a SIP URL ", 0);
        } //End block
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1066811002.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1066811002;
        // ---------- Original Method ----------
        //try {
            //return new URLParser(url).sipURL(true);
        //} catch (ClassCastException ex) {
            //throw new ParseException(url + " Not a SIP URL ", 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.498 -0400", hash_original_method = "40F3B3649F989E59FAF074C2858F6B9B", hash_generated_method = "3E9AE00AB9EB0C66CD233F53B78D6E94")
    public GenericURI parseUrl(String url) throws ParseException {
        GenericURI varB4EAC82CA7396A68D541C85D26508E83_1305958020 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1305958020 = new URLParser(url).parse();
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1305958020.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1305958020;
        // ---------- Original Method ----------
        //return new URLParser(url).parse();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.519 -0400", hash_original_method = "6152413E77E62620D4330DAF5944A1B1", hash_generated_method = "5C6C08CFAC62B0A54E64EDDF2BE5DFF8")
    public SIPHeader parseSIPHeader(String header) throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1906060732 = null; //Variable for return #1
        int start;
        start = 0;
        int end;
        end = header.length() - 1;
        try 
        {
            {
                boolean var8CAFC4B850226A8495EEFA3C5169032C_1813480608 = (header.charAt(start) <= 0x20);
            } //End collapsed parenthetic
            {
                boolean var5F1685AC9DD4CBAFA4A1EB91FD0B579B_1571869102 = (header.charAt(end) <= 0x20);
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
        varB4EAC82CA7396A68D541C85D26508E83_1906060732 = hp.parse();
        addTaint(header.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1906060732.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1906060732;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.521 -0400", hash_original_method = "C661D43CA4BEB0154AFD6A7B8492896F", hash_generated_method = "4B2E5D8D103767447EFA0EC9EE925D81")
    public RequestLine parseSIPRequestLine(String requestLine) throws ParseException {
        RequestLine varB4EAC82CA7396A68D541C85D26508E83_193181252 = null; //Variable for return #1
        requestLine += "\n";
        varB4EAC82CA7396A68D541C85D26508E83_193181252 = new RequestLineParser(requestLine).parse();
        addTaint(requestLine.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_193181252.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_193181252;
        // ---------- Original Method ----------
        //requestLine += "\n";
        //return new RequestLineParser(requestLine).parse();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.521 -0400", hash_original_method = "9FDE6314AF63D7F1DD1D0AE258CFAA9B", hash_generated_method = "5C9B94B37C64ED0F59031C1E2298FF8A")
    public StatusLine parseSIPStatusLine(String statusLine) throws ParseException {
        StatusLine varB4EAC82CA7396A68D541C85D26508E83_1465703008 = null; //Variable for return #1
        statusLine += "\n";
        varB4EAC82CA7396A68D541C85D26508E83_1465703008 = new StatusLineParser(statusLine).parse();
        addTaint(statusLine.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1465703008.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1465703008;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.522 -0400", hash_original_method = "EC510198678EBDAFC45D82B058FF4015", hash_generated_method = "C6177A909B65F45400E04967CBC68CBF")
    public void setStrict(boolean strict) {
        this.strict = strict;
        // ---------- Original Method ----------
        //this.strict = strict;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.522 -0400", hash_original_field = "6A0B46763BD9870CC46C4EF4641C6BDC", hash_generated_field = "A4CB644B81B9880592D43A90E29E3123")

    private static boolean computeContentLengthFromMessage = false;
}

