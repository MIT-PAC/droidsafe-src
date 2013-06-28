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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.632 -0400", hash_original_field = "F6A0B614A3E3F2033445BCEBD36D070B", hash_generated_field = "7E0AA0556EE34EDC1E14E7271C2271D7")

    protected boolean readBody;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.632 -0400", hash_original_field = "0E6EE533F6F7CB1037DB27980D2D40A6", hash_generated_field = "1B834CF99672F368DBE005CE727DA4BD")

    private ParseExceptionListener parseExceptionListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.632 -0400", hash_original_field = "9C8E56B49859E77E66AE351926812318", hash_generated_field = "71F8C7FC9A6DFE4A45B8B3445B6FC291")

    private String rawStringMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.632 -0400", hash_original_field = "2133FD717402A7966EE88D06F9E0B792", hash_generated_field = "02B827874E8744100DF748B4791EB7C5")

    private boolean strict;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.633 -0400", hash_original_method = "03434E90443FF3CC6928C5F00042D419", hash_generated_method = "2EF648646CCD07FCEF63A7835151765E")
    public  StringMsgParser() {
        super();
        readBody = true;
        // ---------- Original Method ----------
        //readBody = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.633 -0400", hash_original_method = "84F5B97F6353CE6241343807C31ED063", hash_generated_method = "C119674FD94FFD6C811D4B6C9741DB1D")
    public  StringMsgParser(ParseExceptionListener exhandler) {
        this();
        parseExceptionListener = exhandler;
        // ---------- Original Method ----------
        //parseExceptionListener = exhandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.633 -0400", hash_original_method = "E7BB96D94C72A71CC55D419208731E5E", hash_generated_method = "20F944E1A059060117121AD4A329ED73")
    public void setParseExceptionListener(ParseExceptionListener pexhandler) {
        parseExceptionListener = pexhandler;
        // ---------- Original Method ----------
        //parseExceptionListener = pexhandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.634 -0400", hash_original_method = "9C5089EA8774478643AAED9197A2D229", hash_generated_method = "F8EAEE2A39B2AF4C953830C3AB724F93")
    public SIPMessage parseSIPMessage(byte[] msgBuffer) throws ParseException {
        SIPMessage varB4EAC82CA7396A68D541C85D26508E83_2074367227 = null; //Variable for return #1
        SIPMessage varB4EAC82CA7396A68D541C85D26508E83_881707868 = null; //Variable for return #2
        SIPMessage varB4EAC82CA7396A68D541C85D26508E83_1073962389 = null; //Variable for return #3
        varB4EAC82CA7396A68D541C85D26508E83_2074367227 = null;
        int i = 0;
        String currentLine = null;
        String currentHeader = null;
        boolean isFirstLine = true;
        SIPMessage message = null;
        {
            int lineStart = i;
            int lineLength = i - lineStart;
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
                boolean var77FDA07008A6EE8388573EBC8194D560_1492361343 = (currentLine.length() == 0);
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
                        char firstChar = currentLine.charAt(0);
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
            boolean var1E1E76B25946A0B0BAEC1D3D3CF41AC5_804320047 = (currentLine.length() > 0);
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new ParseException("Bad message", 0);
        message.setSize(i);
        {
            boolean var80C1D7AF139CBA766D6496F3FF8E5A49_115922837 = (readBody && message.getContentLength() != null &&
                message.getContentLength().getContentLength() != 0);
            {
                int bodyLength = msgBuffer.length - i;
                byte[] body = new byte[bodyLength];
                System.arraycopy(msgBuffer, i, body, 0, bodyLength);
                message.setMessageContent(body,computeContentLengthFromMessage ,message.getContentLength().getContentLength() );
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_881707868 = message;
        addTaint(msgBuffer[0]);
        SIPMessage varA7E53CE21691AB073D9660D615818899_2062008585; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2062008585 = varB4EAC82CA7396A68D541C85D26508E83_2074367227;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2062008585 = varB4EAC82CA7396A68D541C85D26508E83_881707868;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2062008585 = varB4EAC82CA7396A68D541C85D26508E83_1073962389;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2062008585.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2062008585;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.637 -0400", hash_original_method = "2180FC72509B511C247A77608998B3E2", hash_generated_method = "858AB653CDA43964E74E8A94CA273CD1")
    public SIPMessage parseSIPMessage(String msgString) throws ParseException {
        SIPMessage varB4EAC82CA7396A68D541C85D26508E83_1990848055 = null; //Variable for return #1
        SIPMessage varB4EAC82CA7396A68D541C85D26508E83_1140154747 = null; //Variable for return #2
        SIPMessage varB4EAC82CA7396A68D541C85D26508E83_1238706029 = null; //Variable for return #3
        SIPMessage varB4EAC82CA7396A68D541C85D26508E83_879686917 = null; //Variable for return #4
        {
            boolean var7D89CFD8482AB6A8AD85DA0DFBABF979_1148620189 = (msgString == null || msgString.length() == 0);
            varB4EAC82CA7396A68D541C85D26508E83_1990848055 = null;
        } //End collapsed parenthetic
        rawStringMessage = msgString;
        int i = 0;
        try 
        {
            {
                boolean var859977E92DA9B12FACA1EC0F1FA4D264_483547047 = (msgString.charAt(i) < 0x20);
            } //End collapsed parenthetic
        } //End block
        catch (ArrayIndexOutOfBoundsException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1140154747 = null;
        } //End block
        catch (StringIndexOutOfBoundsException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1238706029 = null;
        } //End block
        String currentLine = null;
        String currentHeader = null;
        boolean isFirstLine = true;
        SIPMessage message = null;
        {
            int lineStart = i;
            try 
            {
                char c = msgString.charAt(i);
                c = msgString.charAt(++i);
            } //End block
            catch (ArrayIndexOutOfBoundsException e)
            { }
            catch (StringIndexOutOfBoundsException ex)
            { }
            currentLine = msgString.substring(lineStart, i);
            currentLine = trimEndOfLine(currentLine);
            {
                boolean var77FDA07008A6EE8388573EBC8194D560_979095804 = (currentLine.length() == 0);
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
                        char firstChar = currentLine.charAt(0);
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
                boolean var66897782C6CABBFB4C017CF430AC4CC7_1884984732 = (msgString.charAt(i) == '\r' && msgString.length() > i+1 && msgString.charAt(i+1) == '\n');
            } //End collapsed parenthetic
            isFirstLine = false;
        } //End block
        {
            boolean var1E1E76B25946A0B0BAEC1D3D3CF41AC5_1132352069 = (currentLine.length() > 0);
        } //End collapsed parenthetic
        message.setSize(i);
        {
            boolean var2C8FC7F5C20AA0F801C7E4D85C52C9B2_2125034026 = (readBody && message.getContentLength() != null);
            {
                {
                    boolean var19C30E534A644723268FE932A6BCE642_178940200 = (message.getContentLength().getContentLength() != 0);
                    {
                        String body = msgString.substring(i);
                        message.setMessageContent(body,this.strict,computeContentLengthFromMessage,message.getContentLength().getContentLength());
                    } //End block
                    {
                        boolean var25EF6C317ABB678F71EA951E09435C2F_1351802419 = (!computeContentLengthFromMessage && message.getContentLength().getContentLength() == 0 && !msgString.endsWith("\r\n\r\n"));
                        {
                            {
                                if (DroidSafeAndroidRuntime.control) throw new ParseException("Extraneous characters at the end of the message ",i);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_879686917 = message;
        SIPMessage varA7E53CE21691AB073D9660D615818899_1307678776; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1307678776 = varB4EAC82CA7396A68D541C85D26508E83_1990848055;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1307678776 = varB4EAC82CA7396A68D541C85D26508E83_1140154747;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1307678776 = varB4EAC82CA7396A68D541C85D26508E83_1238706029;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1307678776 = varB4EAC82CA7396A68D541C85D26508E83_879686917;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1307678776.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1307678776;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.639 -0400", hash_original_method = "790601CAF711B74124A1DBA9FDFB3A7B", hash_generated_method = "F201656534A1525FC67D383CF34E038F")
    private String trimEndOfLine(String line) {
        String varB4EAC82CA7396A68D541C85D26508E83_1696252154 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1944306777 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1363222784 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1941144187 = null; //Variable for return #4
        varB4EAC82CA7396A68D541C85D26508E83_1696252154 = line;
        int i = line.length() - 1;
        {
            boolean var0ABA4510E5F4FEBF04BA26FD153A806B_733198048 = (i >= 0 && line.charAt(i) <= 0x20);
        } //End collapsed parenthetic
        {
            boolean var8955262F2B285AD01BE6086E0999045B_1735751838 = (i == line.length() - 1);
            varB4EAC82CA7396A68D541C85D26508E83_1944306777 = line;
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1363222784 = "";
        varB4EAC82CA7396A68D541C85D26508E83_1941144187 = line.substring(0, i+1);
        addTaint(line.getTaint());
        String varA7E53CE21691AB073D9660D615818899_809400083; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_809400083 = varB4EAC82CA7396A68D541C85D26508E83_1696252154;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_809400083 = varB4EAC82CA7396A68D541C85D26508E83_1944306777;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_809400083 = varB4EAC82CA7396A68D541C85D26508E83_1363222784;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_809400083 = varB4EAC82CA7396A68D541C85D26508E83_1941144187;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_809400083.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_809400083;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.641 -0400", hash_original_method = "E1A152A7092436D65484E6472132234E", hash_generated_method = "F6CD35C5E9201E48B3A92272AA21F246")
    private SIPMessage processFirstLine(String firstLine) throws ParseException {
        SIPMessage varB4EAC82CA7396A68D541C85D26508E83_1334663293 = null; //Variable for return #1
        SIPMessage message;
        {
            boolean varE13C2B742A2A12CE615C7B3D8E636FC5_1959581126 = (!firstLine.startsWith(SIPConstants.SIP_VERSION_STRING));
            {
                message = new SIPRequest();
                try 
                {
                    RequestLine requestLine = new RequestLineParser(firstLine + "\n")
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
                    StatusLine sl = new StatusLineParser(firstLine + "\n").parse();
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
        varB4EAC82CA7396A68D541C85D26508E83_1334663293 = message;
        addTaint(firstLine.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1334663293.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1334663293;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.642 -0400", hash_original_method = "825D9502572A55E55AC5E33884E71C29", hash_generated_method = "08D9ED817BA27BCAC342FB0A553AFFC5")
    private void processHeader(String header, SIPMessage message) throws ParseException {
        {
            boolean varE0603EF74A60306DC3A2D1CD57563139_834248858 = (header == null || header.length() == 0);
        } //End collapsed parenthetic
        HeaderParser headerParser = null;
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
            SIPHeader sipHeader = headerParser.parse();
            message.attachHeader(sipHeader, false);
        } //End block
        catch (ParseException ex)
        {
            {
                String headerName = Lexer.getHeaderName(header);
                Class headerClass = NameMap.getClassFromName(headerName);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.643 -0400", hash_original_method = "049BA210A39AB5443B08132FD51D457E", hash_generated_method = "3D9363EEB0FE05F5B89165B18A7C0650")
    public AddressImpl parseAddress(String address) throws ParseException {
        AddressImpl varB4EAC82CA7396A68D541C85D26508E83_242733377 = null; //Variable for return #1
        AddressParser addressParser = new AddressParser(address);
        varB4EAC82CA7396A68D541C85D26508E83_242733377 = addressParser.address(true);
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_242733377.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_242733377;
        // ---------- Original Method ----------
        //AddressParser addressParser = new AddressParser(address);
        //return addressParser.address(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.645 -0400", hash_original_method = "6E5629CC68B4185F1ADA3485008A15B3", hash_generated_method = "E4C1BB73D27AF9C074BA48CADE1B96D9")
    public Host parseHost(String host) throws ParseException {
        Host varB4EAC82CA7396A68D541C85D26508E83_1567588608 = null; //Variable for return #1
        Lexer lexer = new Lexer("charLexer", host);
        varB4EAC82CA7396A68D541C85D26508E83_1567588608 = new HostNameParser(lexer).host();
        addTaint(host.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1567588608.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1567588608;
        // ---------- Original Method ----------
        //Lexer lexer = new Lexer("charLexer", host);
        //return new HostNameParser(lexer).host();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.648 -0400", hash_original_method = "FA67D7760B995854EEA852AD4B17EA85", hash_generated_method = "7EC3142372F9549CAECB5F1C5A77FFDB")
    public TelephoneNumber parseTelephoneNumber(String telephone_number) throws ParseException {
        TelephoneNumber varB4EAC82CA7396A68D541C85D26508E83_1649676295 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1649676295 = new URLParser(telephone_number).parseTelephoneNumber(true);
        addTaint(telephone_number.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1649676295.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1649676295;
        // ---------- Original Method ----------
        //return new URLParser(telephone_number).parseTelephoneNumber(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.650 -0400", hash_original_method = "F49AF4817F29179E4378A66D59AF945F", hash_generated_method = "810D58749A1A25316D572B3DB47B22DC")
    public SipUri parseSIPUrl(String url) throws ParseException {
        SipUri varB4EAC82CA7396A68D541C85D26508E83_429850303 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_429850303 = new URLParser(url).sipURL(true);
        } //End block
        catch (ClassCastException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(url + " Not a SIP URL ", 0);
        } //End block
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_429850303.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_429850303;
        // ---------- Original Method ----------
        //try {
            //return new URLParser(url).sipURL(true);
        //} catch (ClassCastException ex) {
            //throw new ParseException(url + " Not a SIP URL ", 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.652 -0400", hash_original_method = "40F3B3649F989E59FAF074C2858F6B9B", hash_generated_method = "36352A3ADDCCB47AADF079F83C50D846")
    public GenericURI parseUrl(String url) throws ParseException {
        GenericURI varB4EAC82CA7396A68D541C85D26508E83_511677330 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_511677330 = new URLParser(url).parse();
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_511677330.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_511677330;
        // ---------- Original Method ----------
        //return new URLParser(url).parse();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.653 -0400", hash_original_method = "6152413E77E62620D4330DAF5944A1B1", hash_generated_method = "979C2B37C6B0FDD870F352733174B706")
    public SIPHeader parseSIPHeader(String header) throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_571013789 = null; //Variable for return #1
        int start = 0;
        int end = header.length() - 1;
        try 
        {
            {
                boolean var8CAFC4B850226A8495EEFA3C5169032C_2012342929 = (header.charAt(start) <= 0x20);
            } //End collapsed parenthetic
            {
                boolean var5F1685AC9DD4CBAFA4A1EB91FD0B579B_925342296 = (header.charAt(end) <= 0x20);
            } //End collapsed parenthetic
        } //End block
        catch (ArrayIndexOutOfBoundsException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException("Empty header.", 0);
        } //End block
        StringBuffer buffer = new StringBuffer(end + 1);
        int i = start;
        int lineStart = start;
        boolean endOfLine = false;
        {
            char c = header.charAt(i);
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
        HeaderParser hp = ParserFactory.createParser(buffer.toString());
        if (DroidSafeAndroidRuntime.control) throw new ParseException("could not create parser", 0);
        varB4EAC82CA7396A68D541C85D26508E83_571013789 = hp.parse();
        addTaint(header.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_571013789.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_571013789;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.654 -0400", hash_original_method = "C661D43CA4BEB0154AFD6A7B8492896F", hash_generated_method = "0F88433C19B3445961E8A4DC6A7318AD")
    public RequestLine parseSIPRequestLine(String requestLine) throws ParseException {
        RequestLine varB4EAC82CA7396A68D541C85D26508E83_1418926661 = null; //Variable for return #1
        requestLine += "\n";
        varB4EAC82CA7396A68D541C85D26508E83_1418926661 = new RequestLineParser(requestLine).parse();
        addTaint(requestLine.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1418926661.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1418926661;
        // ---------- Original Method ----------
        //requestLine += "\n";
        //return new RequestLineParser(requestLine).parse();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.655 -0400", hash_original_method = "9FDE6314AF63D7F1DD1D0AE258CFAA9B", hash_generated_method = "654176B9813FB1870DCA177E63D837F8")
    public StatusLine parseSIPStatusLine(String statusLine) throws ParseException {
        StatusLine varB4EAC82CA7396A68D541C85D26508E83_135209492 = null; //Variable for return #1
        statusLine += "\n";
        varB4EAC82CA7396A68D541C85D26508E83_135209492 = new StatusLineParser(statusLine).parse();
        addTaint(statusLine.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_135209492.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_135209492;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.656 -0400", hash_original_method = "EC510198678EBDAFC45D82B058FF4015", hash_generated_method = "C6177A909B65F45400E04967CBC68CBF")
    public void setStrict(boolean strict) {
        this.strict = strict;
        // ---------- Original Method ----------
        //this.strict = strict;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.656 -0400", hash_original_field = "6A0B46763BD9870CC46C4EF4641C6BDC", hash_generated_field = "A4CB644B81B9880592D43A90E29E3123")

    private static boolean computeContentLengthFromMessage = false;
}

