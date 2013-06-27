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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.464 -0400", hash_original_field = "F6A0B614A3E3F2033445BCEBD36D070B", hash_generated_field = "7E0AA0556EE34EDC1E14E7271C2271D7")

    protected boolean readBody;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.464 -0400", hash_original_field = "0E6EE533F6F7CB1037DB27980D2D40A6", hash_generated_field = "1B834CF99672F368DBE005CE727DA4BD")

    private ParseExceptionListener parseExceptionListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.464 -0400", hash_original_field = "9C8E56B49859E77E66AE351926812318", hash_generated_field = "71F8C7FC9A6DFE4A45B8B3445B6FC291")

    private String rawStringMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.464 -0400", hash_original_field = "2133FD717402A7966EE88D06F9E0B792", hash_generated_field = "02B827874E8744100DF748B4791EB7C5")

    private boolean strict;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.465 -0400", hash_original_method = "03434E90443FF3CC6928C5F00042D419", hash_generated_method = "2EF648646CCD07FCEF63A7835151765E")
    public  StringMsgParser() {
        super();
        readBody = true;
        // ---------- Original Method ----------
        //readBody = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.465 -0400", hash_original_method = "84F5B97F6353CE6241343807C31ED063", hash_generated_method = "C119674FD94FFD6C811D4B6C9741DB1D")
    public  StringMsgParser(ParseExceptionListener exhandler) {
        this();
        parseExceptionListener = exhandler;
        // ---------- Original Method ----------
        //parseExceptionListener = exhandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.480 -0400", hash_original_method = "E7BB96D94C72A71CC55D419208731E5E", hash_generated_method = "20F944E1A059060117121AD4A329ED73")
    public void setParseExceptionListener(ParseExceptionListener pexhandler) {
        parseExceptionListener = pexhandler;
        // ---------- Original Method ----------
        //parseExceptionListener = pexhandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.485 -0400", hash_original_method = "9C5089EA8774478643AAED9197A2D229", hash_generated_method = "B3D7ECB43757517638064888FEB9F71F")
    public SIPMessage parseSIPMessage(byte[] msgBuffer) throws ParseException {
        SIPMessage varB4EAC82CA7396A68D541C85D26508E83_2100225869 = null; //Variable for return #1
        SIPMessage varB4EAC82CA7396A68D541C85D26508E83_449523589 = null; //Variable for return #2
        SIPMessage varB4EAC82CA7396A68D541C85D26508E83_1437863195 = null; //Variable for return #3
        varB4EAC82CA7396A68D541C85D26508E83_2100225869 = null;
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
                boolean var77FDA07008A6EE8388573EBC8194D560_2127038738 = (currentLine.length() == 0);
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
            boolean var1E1E76B25946A0B0BAEC1D3D3CF41AC5_1680428898 = (currentLine.length() > 0);
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new ParseException("Bad message", 0);
        message.setSize(i);
        {
            boolean var80C1D7AF139CBA766D6496F3FF8E5A49_830524377 = (readBody && message.getContentLength() != null &&
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
        varB4EAC82CA7396A68D541C85D26508E83_449523589 = message;
        addTaint(msgBuffer[0]);
        SIPMessage varA7E53CE21691AB073D9660D615818899_739083853; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_739083853 = varB4EAC82CA7396A68D541C85D26508E83_2100225869;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_739083853 = varB4EAC82CA7396A68D541C85D26508E83_449523589;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_739083853 = varB4EAC82CA7396A68D541C85D26508E83_1437863195;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_739083853.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_739083853;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.494 -0400", hash_original_method = "2180FC72509B511C247A77608998B3E2", hash_generated_method = "86C9C739DFC106C14358138ED60E0825")
    public SIPMessage parseSIPMessage(String msgString) throws ParseException {
        SIPMessage varB4EAC82CA7396A68D541C85D26508E83_847898249 = null; //Variable for return #1
        SIPMessage varB4EAC82CA7396A68D541C85D26508E83_1275019946 = null; //Variable for return #2
        SIPMessage varB4EAC82CA7396A68D541C85D26508E83_572680999 = null; //Variable for return #3
        SIPMessage varB4EAC82CA7396A68D541C85D26508E83_1044336693 = null; //Variable for return #4
        {
            boolean var7D89CFD8482AB6A8AD85DA0DFBABF979_1611223826 = (msgString == null || msgString.length() == 0);
            varB4EAC82CA7396A68D541C85D26508E83_847898249 = null;
        } //End collapsed parenthetic
        rawStringMessage = msgString;
        int i;
        i = 0;
        try 
        {
            {
                boolean var859977E92DA9B12FACA1EC0F1FA4D264_1755518207 = (msgString.charAt(i) < 0x20);
            } //End collapsed parenthetic
        } //End block
        catch (ArrayIndexOutOfBoundsException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1275019946 = null;
        } //End block
        catch (StringIndexOutOfBoundsException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_572680999 = null;
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
                boolean var77FDA07008A6EE8388573EBC8194D560_1656479183 = (currentLine.length() == 0);
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
                boolean var66897782C6CABBFB4C017CF430AC4CC7_923266800 = (msgString.charAt(i) == '\r' && msgString.length() > i+1 && msgString.charAt(i+1) == '\n');
            } //End collapsed parenthetic
            isFirstLine = false;
        } //End block
        {
            boolean var1E1E76B25946A0B0BAEC1D3D3CF41AC5_1974932157 = (currentLine.length() > 0);
        } //End collapsed parenthetic
        message.setSize(i);
        {
            boolean var2C8FC7F5C20AA0F801C7E4D85C52C9B2_1540773055 = (readBody && message.getContentLength() != null);
            {
                {
                    boolean var19C30E534A644723268FE932A6BCE642_286247385 = (message.getContentLength().getContentLength() != 0);
                    {
                        String body;
                        body = msgString.substring(i);
                        message.setMessageContent(body,this.strict,computeContentLengthFromMessage,message.getContentLength().getContentLength());
                    } //End block
                    {
                        boolean var25EF6C317ABB678F71EA951E09435C2F_773056152 = (!computeContentLengthFromMessage && message.getContentLength().getContentLength() == 0 && !msgString.endsWith("\r\n\r\n"));
                        {
                            {
                                if (DroidSafeAndroidRuntime.control) throw new ParseException("Extraneous characters at the end of the message ",i);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1044336693 = message;
        SIPMessage varA7E53CE21691AB073D9660D615818899_1690171195; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1690171195 = varB4EAC82CA7396A68D541C85D26508E83_847898249;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1690171195 = varB4EAC82CA7396A68D541C85D26508E83_1275019946;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1690171195 = varB4EAC82CA7396A68D541C85D26508E83_572680999;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1690171195 = varB4EAC82CA7396A68D541C85D26508E83_1044336693;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1690171195.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1690171195;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.500 -0400", hash_original_method = "790601CAF711B74124A1DBA9FDFB3A7B", hash_generated_method = "A52C0E18574D3AF592318FFA14FB8533")
    private String trimEndOfLine(String line) {
        String varB4EAC82CA7396A68D541C85D26508E83_2140243499 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1897723052 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1517604259 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1002503830 = null; //Variable for return #4
        varB4EAC82CA7396A68D541C85D26508E83_2140243499 = line;
        int i;
        i = line.length() - 1;
        {
            boolean var0ABA4510E5F4FEBF04BA26FD153A806B_416864330 = (i >= 0 && line.charAt(i) <= 0x20);
        } //End collapsed parenthetic
        {
            boolean var8955262F2B285AD01BE6086E0999045B_2028928240 = (i == line.length() - 1);
            varB4EAC82CA7396A68D541C85D26508E83_1897723052 = line;
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1517604259 = "";
        varB4EAC82CA7396A68D541C85D26508E83_1002503830 = line.substring(0, i+1);
        addTaint(line.getTaint());
        String varA7E53CE21691AB073D9660D615818899_405888261; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_405888261 = varB4EAC82CA7396A68D541C85D26508E83_2140243499;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_405888261 = varB4EAC82CA7396A68D541C85D26508E83_1897723052;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_405888261 = varB4EAC82CA7396A68D541C85D26508E83_1517604259;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_405888261 = varB4EAC82CA7396A68D541C85D26508E83_1002503830;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_405888261.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_405888261;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.510 -0400", hash_original_method = "E1A152A7092436D65484E6472132234E", hash_generated_method = "AC6FDA4EA18A4D5C197E1CE2AF3EED5F")
    private SIPMessage processFirstLine(String firstLine) throws ParseException {
        SIPMessage varB4EAC82CA7396A68D541C85D26508E83_2135005165 = null; //Variable for return #1
        SIPMessage message;
        {
            boolean varE13C2B742A2A12CE615C7B3D8E636FC5_2116387768 = (!firstLine.startsWith(SIPConstants.SIP_VERSION_STRING));
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
        varB4EAC82CA7396A68D541C85D26508E83_2135005165 = message;
        addTaint(firstLine.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2135005165.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2135005165;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.514 -0400", hash_original_method = "825D9502572A55E55AC5E33884E71C29", hash_generated_method = "46FFD59B2F699D78164E9FA734AF1BFF")
    private void processHeader(String header, SIPMessage message) throws ParseException {
        {
            boolean varE0603EF74A60306DC3A2D1CD57563139_185799848 = (header == null || header.length() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.515 -0400", hash_original_method = "049BA210A39AB5443B08132FD51D457E", hash_generated_method = "795741E1678241B8DC01C683C2B0896C")
    public AddressImpl parseAddress(String address) throws ParseException {
        AddressImpl varB4EAC82CA7396A68D541C85D26508E83_1987814095 = null; //Variable for return #1
        AddressParser addressParser;
        addressParser = new AddressParser(address);
        varB4EAC82CA7396A68D541C85D26508E83_1987814095 = addressParser.address(true);
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1987814095.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1987814095;
        // ---------- Original Method ----------
        //AddressParser addressParser = new AddressParser(address);
        //return addressParser.address(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.515 -0400", hash_original_method = "6E5629CC68B4185F1ADA3485008A15B3", hash_generated_method = "7DD465A0F359424E93E840709EA9E165")
    public Host parseHost(String host) throws ParseException {
        Host varB4EAC82CA7396A68D541C85D26508E83_1811778498 = null; //Variable for return #1
        Lexer lexer;
        lexer = new Lexer("charLexer", host);
        varB4EAC82CA7396A68D541C85D26508E83_1811778498 = new HostNameParser(lexer).host();
        addTaint(host.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1811778498.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1811778498;
        // ---------- Original Method ----------
        //Lexer lexer = new Lexer("charLexer", host);
        //return new HostNameParser(lexer).host();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.516 -0400", hash_original_method = "FA67D7760B995854EEA852AD4B17EA85", hash_generated_method = "EB66487439E088F5D20C4CE362C051C8")
    public TelephoneNumber parseTelephoneNumber(String telephone_number) throws ParseException {
        TelephoneNumber varB4EAC82CA7396A68D541C85D26508E83_1983376377 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1983376377 = new URLParser(telephone_number).parseTelephoneNumber(true);
        addTaint(telephone_number.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1983376377.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1983376377;
        // ---------- Original Method ----------
        //return new URLParser(telephone_number).parseTelephoneNumber(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.535 -0400", hash_original_method = "F49AF4817F29179E4378A66D59AF945F", hash_generated_method = "BF934D0143FC1BF3F417572E1E4A8AC9")
    public SipUri parseSIPUrl(String url) throws ParseException {
        SipUri varB4EAC82CA7396A68D541C85D26508E83_1270899495 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1270899495 = new URLParser(url).sipURL(true);
        } //End block
        catch (ClassCastException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(url + " Not a SIP URL ", 0);
        } //End block
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1270899495.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1270899495;
        // ---------- Original Method ----------
        //try {
            //return new URLParser(url).sipURL(true);
        //} catch (ClassCastException ex) {
            //throw new ParseException(url + " Not a SIP URL ", 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.536 -0400", hash_original_method = "40F3B3649F989E59FAF074C2858F6B9B", hash_generated_method = "249FD12F40E91D1952ABC7525BF9470E")
    public GenericURI parseUrl(String url) throws ParseException {
        GenericURI varB4EAC82CA7396A68D541C85D26508E83_40976759 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_40976759 = new URLParser(url).parse();
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_40976759.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_40976759;
        // ---------- Original Method ----------
        //return new URLParser(url).parse();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.542 -0400", hash_original_method = "6152413E77E62620D4330DAF5944A1B1", hash_generated_method = "47DA206A3591E2D47C220E63F842E77A")
    public SIPHeader parseSIPHeader(String header) throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1277124442 = null; //Variable for return #1
        int start;
        start = 0;
        int end;
        end = header.length() - 1;
        try 
        {
            {
                boolean var8CAFC4B850226A8495EEFA3C5169032C_14037552 = (header.charAt(start) <= 0x20);
            } //End collapsed parenthetic
            {
                boolean var5F1685AC9DD4CBAFA4A1EB91FD0B579B_998369401 = (header.charAt(end) <= 0x20);
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
        varB4EAC82CA7396A68D541C85D26508E83_1277124442 = hp.parse();
        addTaint(header.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1277124442.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1277124442;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.543 -0400", hash_original_method = "C661D43CA4BEB0154AFD6A7B8492896F", hash_generated_method = "174821127E9A03CDF07EE6F656BE3671")
    public RequestLine parseSIPRequestLine(String requestLine) throws ParseException {
        RequestLine varB4EAC82CA7396A68D541C85D26508E83_959842369 = null; //Variable for return #1
        requestLine += "\n";
        varB4EAC82CA7396A68D541C85D26508E83_959842369 = new RequestLineParser(requestLine).parse();
        addTaint(requestLine.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_959842369.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_959842369;
        // ---------- Original Method ----------
        //requestLine += "\n";
        //return new RequestLineParser(requestLine).parse();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.543 -0400", hash_original_method = "9FDE6314AF63D7F1DD1D0AE258CFAA9B", hash_generated_method = "1D23BD069D2F2662C0504D9566379BF1")
    public StatusLine parseSIPStatusLine(String statusLine) throws ParseException {
        StatusLine varB4EAC82CA7396A68D541C85D26508E83_2055666986 = null; //Variable for return #1
        statusLine += "\n";
        varB4EAC82CA7396A68D541C85D26508E83_2055666986 = new StatusLineParser(statusLine).parse();
        addTaint(statusLine.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2055666986.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2055666986;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.553 -0400", hash_original_method = "EC510198678EBDAFC45D82B058FF4015", hash_generated_method = "C6177A909B65F45400E04967CBC68CBF")
    public void setStrict(boolean strict) {
        this.strict = strict;
        // ---------- Original Method ----------
        //this.strict = strict;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.553 -0400", hash_original_field = "6A0B46763BD9870CC46C4EF4641C6BDC", hash_generated_field = "A4CB644B81B9880592D43A90E29E3123")

    private static boolean computeContentLengthFromMessage = false;
}

