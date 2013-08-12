package gov.nist.javax.sip.parser;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.869 -0400", hash_original_field = "F6A0B614A3E3F2033445BCEBD36D070B", hash_generated_field = "7E0AA0556EE34EDC1E14E7271C2271D7")

    protected boolean readBody;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.869 -0400", hash_original_field = "0E6EE533F6F7CB1037DB27980D2D40A6", hash_generated_field = "1B834CF99672F368DBE005CE727DA4BD")

    private ParseExceptionListener parseExceptionListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.869 -0400", hash_original_field = "9C8E56B49859E77E66AE351926812318", hash_generated_field = "71F8C7FC9A6DFE4A45B8B3445B6FC291")

    private String rawStringMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.869 -0400", hash_original_field = "2133FD717402A7966EE88D06F9E0B792", hash_generated_field = "02B827874E8744100DF748B4791EB7C5")

    private boolean strict;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.869 -0400", hash_original_method = "03434E90443FF3CC6928C5F00042D419", hash_generated_method = "2EF648646CCD07FCEF63A7835151765E")
    public  StringMsgParser() {
        super();
        readBody = true;
        // ---------- Original Method ----------
        //readBody = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.870 -0400", hash_original_method = "84F5B97F6353CE6241343807C31ED063", hash_generated_method = "C119674FD94FFD6C811D4B6C9741DB1D")
    public  StringMsgParser(ParseExceptionListener exhandler) {
        this();
        parseExceptionListener = exhandler;
        // ---------- Original Method ----------
        //parseExceptionListener = exhandler;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.870 -0400", hash_original_method = "E7BB96D94C72A71CC55D419208731E5E", hash_generated_method = "20F944E1A059060117121AD4A329ED73")
    public void setParseExceptionListener(ParseExceptionListener pexhandler) {
        parseExceptionListener = pexhandler;
        // ---------- Original Method ----------
        //parseExceptionListener = pexhandler;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.872 -0400", hash_original_method = "9C5089EA8774478643AAED9197A2D229", hash_generated_method = "A7358246937510B9B5E6E1E0D6E123EC")
    public SIPMessage parseSIPMessage(byte[] msgBuffer) throws ParseException {
        addTaint(msgBuffer[0]);
        if(msgBuffer == null || msgBuffer.length == 0)        
        {
SIPMessage var540C13E9E156B687226421B24F2DF178_268222928 =         null;
        var540C13E9E156B687226421B24F2DF178_268222928.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_268222928;
        }
        int i = 0;
        try 
        {
            while
(msgBuffer[i] < 0x20)            
            i++;
        } //End block
        catch (ArrayIndexOutOfBoundsException e)
        {
SIPMessage var540C13E9E156B687226421B24F2DF178_1288996888 =             null;
            var540C13E9E156B687226421B24F2DF178_1288996888.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1288996888;
        } //End block
        String currentLine = null;
        String currentHeader = null;
        boolean isFirstLine = true;
        SIPMessage message = null;
        do {
            {
                int lineStart = i;
                try 
                {
                    while
(msgBuffer[i] != '\r' && msgBuffer[i] != '\n')                    
                    i++;
                } //End block
                catch (ArrayIndexOutOfBoundsException e)
                {
                    break;
                } //End block
                int lineLength = i - lineStart;
                try 
                {
                    currentLine = new String(msgBuffer, lineStart, lineLength, "UTF-8");
                } //End block
                catch (UnsupportedEncodingException e)
                {
                    ParseException varD69FD0E270D6364D4BBE2AAD578C2CB9_2089144652 = new ParseException("Bad message encoding!", 0);
                    varD69FD0E270D6364D4BBE2AAD578C2CB9_2089144652.addTaint(taint);
                    throw varD69FD0E270D6364D4BBE2AAD578C2CB9_2089144652;
                } //End block
                currentLine = trimEndOfLine(currentLine);
                if(currentLine.length() == 0)                
                {
                    if(currentHeader != null && message != null)                    
                    {
                        processHeader(currentHeader, message);
                    } //End block
                } //End block
                else
                {
                    if(isFirstLine)                    
                    {
                        message = processFirstLine(currentLine);
                    } //End block
                    else
                    {
                        char firstChar = currentLine.charAt(0);
                        if(firstChar == '\t' || firstChar == ' ')                        
                        {
                            if(currentHeader == null)                            
                            {
                            ParseException var6FD753E49E329EE8F88129DAE2071C93_1663197888 = new ParseException("Bad header continuation.", 0);
                            var6FD753E49E329EE8F88129DAE2071C93_1663197888.addTaint(taint);
                            throw var6FD753E49E329EE8F88129DAE2071C93_1663197888;
                            }
                            currentHeader += currentLine.substring(1);
                        } //End block
                        else
                        {
                            if(currentHeader != null && message != null)                            
                            {
                                processHeader(currentHeader, message);
                            } //End block
                            currentHeader = currentLine;
                        } //End block
                    } //End block
                } //End block
                if(msgBuffer[i] == '\r' && msgBuffer.length > i+1 && msgBuffer[i+1] == '\n')                
                i++;
                i++;
                isFirstLine = false;
            } //End block
} while (currentLine.length() > 0);
        if(message == null)        
        {
        ParseException varD3C372BBFBB4E42FA6B4D23D9E2243DE_1923898396 = new ParseException("Bad message", 0);
        varD3C372BBFBB4E42FA6B4D23D9E2243DE_1923898396.addTaint(taint);
        throw varD3C372BBFBB4E42FA6B4D23D9E2243DE_1923898396;
        }
        message.setSize(i);
        if(readBody && message.getContentLength() != null &&
                message.getContentLength().getContentLength() != 0)        
        {
            int bodyLength = msgBuffer.length - i;
            byte[] body = new byte[bodyLength];
            System.arraycopy(msgBuffer, i, body, 0, bodyLength);
            message.setMessageContent(body,computeContentLengthFromMessage ,message.getContentLength().getContentLength() );
        } //End block
SIPMessage varFD182D7074F3848E773A38B067BBB880_1720381556 =         message;
        varFD182D7074F3848E773A38B067BBB880_1720381556.addTaint(taint);
        return varFD182D7074F3848E773A38B067BBB880_1720381556;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.875 -0400", hash_original_method = "2180FC72509B511C247A77608998B3E2", hash_generated_method = "624841CDFBA564B5E7671D4B1EC2DAD0")
    public SIPMessage parseSIPMessage(String msgString) throws ParseException {
        if(msgString == null || msgString.length() == 0)        
        {
SIPMessage var540C13E9E156B687226421B24F2DF178_1769457096 =         null;
        var540C13E9E156B687226421B24F2DF178_1769457096.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1769457096;
        }
        rawStringMessage = msgString;
        int i = 0;
        try 
        {
            while
(msgString.charAt(i) < 0x20)            
            i++;
        } //End block
        catch (ArrayIndexOutOfBoundsException e)
        {
SIPMessage var540C13E9E156B687226421B24F2DF178_1217098219 =             null;
            var540C13E9E156B687226421B24F2DF178_1217098219.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1217098219;
        } //End block
        catch (StringIndexOutOfBoundsException ex)
        {
SIPMessage var540C13E9E156B687226421B24F2DF178_312006018 =             null;
            var540C13E9E156B687226421B24F2DF178_312006018.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_312006018;
        } //End block
        String currentLine = null;
        String currentHeader = null;
        boolean isFirstLine = true;
        SIPMessage message = null;
        do {
            {
                int lineStart = i;
                try 
                {
                    char c = msgString.charAt(i);
                    while
(c != '\r' && c != '\n')                    
                    c = msgString.charAt(++i);
                } //End block
                catch (ArrayIndexOutOfBoundsException e)
                {
                    break;
                } //End block
                catch (StringIndexOutOfBoundsException ex)
                {
                    break;
                } //End block
                currentLine = msgString.substring(lineStart, i);
                currentLine = trimEndOfLine(currentLine);
                if(currentLine.length() == 0)                
                {
                    if(currentHeader != null)                    
                    {
                        processHeader(currentHeader, message);
                    } //End block
                } //End block
                else
                {
                    if(isFirstLine)                    
                    {
                        message = processFirstLine(currentLine);
                    } //End block
                    else
                    {
                        char firstChar = currentLine.charAt(0);
                        if(firstChar == '\t' || firstChar == ' ')                        
                        {
                            if(currentHeader == null)                            
                            {
                            ParseException var6FD753E49E329EE8F88129DAE2071C93_1089858715 = new ParseException("Bad header continuation.", 0);
                            var6FD753E49E329EE8F88129DAE2071C93_1089858715.addTaint(taint);
                            throw var6FD753E49E329EE8F88129DAE2071C93_1089858715;
                            }
                            currentHeader += currentLine.substring(1);
                        } //End block
                        else
                        {
                            if(currentHeader != null)                            
                            {
                                processHeader(currentHeader, message);
                            } //End block
                            currentHeader = currentLine;
                        } //End block
                    } //End block
                } //End block
                if(msgString.charAt(i) == '\r' && msgString.length() > i+1 && msgString.charAt(i+1) == '\n')                
                i++;
                i++;
                isFirstLine = false;
            } //End block
} while (currentLine.length() > 0);
        message.setSize(i);
        if(readBody && message.getContentLength() != null)        
        {
            if(message.getContentLength().getContentLength() != 0)            
            {
                String body = msgString.substring(i);
                message.setMessageContent(body,this.strict,computeContentLengthFromMessage,message.getContentLength().getContentLength());
            } //End block
            else
            if(!computeContentLengthFromMessage && message.getContentLength().getContentLength() == 0 && !msgString.endsWith("\r\n\r\n"))            
            {
                if(strict)                
                {
                    ParseException var263A08C68221F949D372365C8560497D_1778181168 = new ParseException("Extraneous characters at the end of the message ",i);
                    var263A08C68221F949D372365C8560497D_1778181168.addTaint(taint);
                    throw var263A08C68221F949D372365C8560497D_1778181168;
                } //End block
            } //End block
        } //End block
SIPMessage varFD182D7074F3848E773A38B067BBB880_257790948 =         message;
        varFD182D7074F3848E773A38B067BBB880_257790948.addTaint(taint);
        return varFD182D7074F3848E773A38B067BBB880_257790948;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.875 -0400", hash_original_method = "790601CAF711B74124A1DBA9FDFB3A7B", hash_generated_method = "C1E416BD22558099882D35E77AFC6CDC")
    private String trimEndOfLine(String line) {
        addTaint(line.getTaint());
        if(line == null)        
        {
String var8B953730BA6E72E2869C9D0C2CC87CC8_529785209 =         line;
        var8B953730BA6E72E2869C9D0C2CC87CC8_529785209.addTaint(taint);
        return var8B953730BA6E72E2869C9D0C2CC87CC8_529785209;
        }
        int i = line.length() - 1;
        while
(i >= 0 && line.charAt(i) <= 0x20)        
        i--;
        if(i == line.length() - 1)        
        {
String var8B953730BA6E72E2869C9D0C2CC87CC8_1384724490 =         line;
        var8B953730BA6E72E2869C9D0C2CC87CC8_1384724490.addTaint(taint);
        return var8B953730BA6E72E2869C9D0C2CC87CC8_1384724490;
        }
        if(i == -1)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1875279724 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1875279724.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1875279724;
        }
String varE97A29D7786D12C0606A8113DDE9DC15_1888224737 =         line.substring(0, i+1);
        varE97A29D7786D12C0606A8113DDE9DC15_1888224737.addTaint(taint);
        return varE97A29D7786D12C0606A8113DDE9DC15_1888224737;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.876 -0400", hash_original_method = "E1A152A7092436D65484E6472132234E", hash_generated_method = "9037E95ECA36DCCB0C80CBA36BB3C2DE")
    private SIPMessage processFirstLine(String firstLine) throws ParseException {
        addTaint(firstLine.getTaint());
        SIPMessage message;
        if(!firstLine.startsWith(SIPConstants.SIP_VERSION_STRING))        
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
                if(this.parseExceptionListener != null)                
                this.parseExceptionListener.handleException(ex, message,
                            RequestLine.class, firstLine, rawStringMessage);
                else
                {
                ex.addTaint(taint);
                throw ex;
                }
            } //End block
        } //End block
        else
        {
            message = new SIPResponse();
            try 
            {
                StatusLine sl = new StatusLineParser(firstLine + "\n").parse();
                ((SIPResponse) message).setStatusLine(sl);
            } //End block
            catch (ParseException ex)
            {
                if(this.parseExceptionListener != null)                
                {
                    this.parseExceptionListener.handleException(ex, message,
                            StatusLine.class, firstLine, rawStringMessage);
                } //End block
                else
                {
                ex.addTaint(taint);
                throw ex;
                }
            } //End block
        } //End block
SIPMessage varFD182D7074F3848E773A38B067BBB880_649030540 =         message;
        varFD182D7074F3848E773A38B067BBB880_649030540.addTaint(taint);
        return varFD182D7074F3848E773A38B067BBB880_649030540;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.877 -0400", hash_original_method = "825D9502572A55E55AC5E33884E71C29", hash_generated_method = "5AC354A9CF877E28FAC2D711E8B9250D")
    private void processHeader(String header, SIPMessage message) throws ParseException {
        addTaint(message.getTaint());
        addTaint(header.getTaint());
        if(header == null || header.length() == 0)        
        return;
        HeaderParser headerParser = null;
        try 
        {
            headerParser = ParserFactory.createParser(header + "\n");
        } //End block
        catch (ParseException ex)
        {
            this.parseExceptionListener.handleException(ex, message, null,
                    header, rawStringMessage);
            return;
        } //End block
        try 
        {
            SIPHeader sipHeader = headerParser.parse();
            message.attachHeader(sipHeader, false);
        } //End block
        catch (ParseException ex)
        {
            if(this.parseExceptionListener != null)            
            {
                String headerName = Lexer.getHeaderName(header);
                Class headerClass = NameMap.getClassFromName(headerName);
                if(headerClass == null)                
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.878 -0400", hash_original_method = "049BA210A39AB5443B08132FD51D457E", hash_generated_method = "1560F0F5BFD15ABBC949EE63A5AE29C1")
    public AddressImpl parseAddress(String address) throws ParseException {
        addTaint(address.getTaint());
        AddressParser addressParser = new AddressParser(address);
AddressImpl var38834A65BE845C655031CC23ACA4C772_1337875766 =         addressParser.address(true);
        var38834A65BE845C655031CC23ACA4C772_1337875766.addTaint(taint);
        return var38834A65BE845C655031CC23ACA4C772_1337875766;
        // ---------- Original Method ----------
        //AddressParser addressParser = new AddressParser(address);
        //return addressParser.address(true);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.878 -0400", hash_original_method = "6E5629CC68B4185F1ADA3485008A15B3", hash_generated_method = "C046608B4E8C57D750CF62A5F0FF0ABA")
    public Host parseHost(String host) throws ParseException {
        addTaint(host.getTaint());
        Lexer lexer = new Lexer("charLexer", host);
Host varBFDC80813AB4D3C174FE89D0FE5657A6_34832042 =         new HostNameParser(lexer).host();
        varBFDC80813AB4D3C174FE89D0FE5657A6_34832042.addTaint(taint);
        return varBFDC80813AB4D3C174FE89D0FE5657A6_34832042;
        // ---------- Original Method ----------
        //Lexer lexer = new Lexer("charLexer", host);
        //return new HostNameParser(lexer).host();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.879 -0400", hash_original_method = "FA67D7760B995854EEA852AD4B17EA85", hash_generated_method = "8546A7AF0428F814CA31236D48F45D97")
    public TelephoneNumber parseTelephoneNumber(String telephone_number) throws ParseException {
        addTaint(telephone_number.getTaint());
TelephoneNumber var19E7CF3AFA993CEA6FC8BE2686AF0D09_556840835 =         new URLParser(telephone_number).parseTelephoneNumber(true);
        var19E7CF3AFA993CEA6FC8BE2686AF0D09_556840835.addTaint(taint);
        return var19E7CF3AFA993CEA6FC8BE2686AF0D09_556840835;
        // ---------- Original Method ----------
        //return new URLParser(telephone_number).parseTelephoneNumber(true);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.879 -0400", hash_original_method = "F49AF4817F29179E4378A66D59AF945F", hash_generated_method = "62CF577284D35ECF893FA41D3E28BCCE")
    public SipUri parseSIPUrl(String url) throws ParseException {
        addTaint(url.getTaint());
        try 
        {
SipUri var945CAFD84159019C48E6373757A24F78_787874223 =             new URLParser(url).sipURL(true);
            var945CAFD84159019C48E6373757A24F78_787874223.addTaint(taint);
            return var945CAFD84159019C48E6373757A24F78_787874223;
        } //End block
        catch (ClassCastException ex)
        {
            ParseException var007E1D465BD35F2F74C467410EE7F33F_1167325663 = new ParseException(url + " Not a SIP URL ", 0);
            var007E1D465BD35F2F74C467410EE7F33F_1167325663.addTaint(taint);
            throw var007E1D465BD35F2F74C467410EE7F33F_1167325663;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return new URLParser(url).sipURL(true);
        //} catch (ClassCastException ex) {
            //throw new ParseException(url + " Not a SIP URL ", 0);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.880 -0400", hash_original_method = "40F3B3649F989E59FAF074C2858F6B9B", hash_generated_method = "5068BFCFFAF0E4FD1DFA1B2F2365E1F6")
    public GenericURI parseUrl(String url) throws ParseException {
        addTaint(url.getTaint());
GenericURI varE1262A481934EE776A587D0EE7911D31_1922450796 =         new URLParser(url).parse();
        varE1262A481934EE776A587D0EE7911D31_1922450796.addTaint(taint);
        return varE1262A481934EE776A587D0EE7911D31_1922450796;
        // ---------- Original Method ----------
        //return new URLParser(url).parse();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.881 -0400", hash_original_method = "6152413E77E62620D4330DAF5944A1B1", hash_generated_method = "24B2C53490E426334CC5D8E49A18CC04")
    public SIPHeader parseSIPHeader(String header) throws ParseException {
        addTaint(header.getTaint());
        int start = 0;
        int end = header.length() - 1;
        try 
        {
            while
(header.charAt(start) <= 0x20)            
            start++;
            while
(header.charAt(end) <= 0x20)            
            end--;
        } //End block
        catch (ArrayIndexOutOfBoundsException e)
        {
            ParseException varD0054FCA0E60A07FCFE304524FBEBEF4_1213361582 = new ParseException("Empty header.", 0);
            varD0054FCA0E60A07FCFE304524FBEBEF4_1213361582.addTaint(taint);
            throw varD0054FCA0E60A07FCFE304524FBEBEF4_1213361582;
        } //End block
        StringBuffer buffer = new StringBuffer(end + 1);
        int i = start;
        int lineStart = start;
        boolean endOfLine = false;
        while
(i <= end)        
        {
            char c = header.charAt(i);
            if(c == '\r' || c == '\n')            
            {
                if(!endOfLine)                
                {
                    buffer.append(header.substring(lineStart, i));
                    endOfLine = true;
                } //End block
            } //End block
            else
            {
                if(endOfLine)                
                {
                    endOfLine = false;
                    if(c == ' ' || c == '\t')                    
                    {
                        buffer.append(' ');
                        lineStart = i + 1;
                    } //End block
                    else
                    {
                        lineStart = i;
                    } //End block
                } //End block
            } //End block
            i++;
        } //End block
        buffer.append(header.substring(lineStart, i));
        buffer.append('\n');
        HeaderParser hp = ParserFactory.createParser(buffer.toString());
        if(hp == null)        
        {
        ParseException varE674F04EF8FE8ADF1D945F01FAD013AB_2040748043 = new ParseException("could not create parser", 0);
        varE674F04EF8FE8ADF1D945F01FAD013AB_2040748043.addTaint(taint);
        throw varE674F04EF8FE8ADF1D945F01FAD013AB_2040748043;
        }
SIPHeader varB31A57F2E73DE9124E0166DAEE7B8802_1720083336 =         hp.parse();
        varB31A57F2E73DE9124E0166DAEE7B8802_1720083336.addTaint(taint);
        return varB31A57F2E73DE9124E0166DAEE7B8802_1720083336;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.881 -0400", hash_original_method = "C661D43CA4BEB0154AFD6A7B8492896F", hash_generated_method = "41108F12F31666C4292B188033DFD103")
    public RequestLine parseSIPRequestLine(String requestLine) throws ParseException {
        addTaint(requestLine.getTaint());
        requestLine += "\n";
RequestLine var21E03B2AA1692429C9EF98FFF07ABBA2_721703916 =         new RequestLineParser(requestLine).parse();
        var21E03B2AA1692429C9EF98FFF07ABBA2_721703916.addTaint(taint);
        return var21E03B2AA1692429C9EF98FFF07ABBA2_721703916;
        // ---------- Original Method ----------
        //requestLine += "\n";
        //return new RequestLineParser(requestLine).parse();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.881 -0400", hash_original_method = "9FDE6314AF63D7F1DD1D0AE258CFAA9B", hash_generated_method = "7DB47BD4F622E37B8CE9ED04E2A00495")
    public StatusLine parseSIPStatusLine(String statusLine) throws ParseException {
        addTaint(statusLine.getTaint());
        statusLine += "\n";
StatusLine varC168C3AEA25683D36962B85515B113E0_668512523 =         new StatusLineParser(statusLine).parse();
        varC168C3AEA25683D36962B85515B113E0_668512523.addTaint(taint);
        return varC168C3AEA25683D36962B85515B113E0_668512523;
        // ---------- Original Method ----------
        //statusLine += "\n";
        //return new StatusLineParser(statusLine).parse();
    }

    
    @DSModeled(DSC.SAFE)
    public static void setComputeContentLengthFromMessage(
            boolean computeContentLengthFromMessage) {
        StringMsgParser.computeContentLengthFromMessage = computeContentLengthFromMessage;
    }

    
    @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.882 -0400", hash_original_method = "EC510198678EBDAFC45D82B058FF4015", hash_generated_method = "C6177A909B65F45400E04967CBC68CBF")
    public void setStrict(boolean strict) {
        this.strict = strict;
        // ---------- Original Method ----------
        //this.strict = strict;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.882 -0400", hash_original_field = "6A0B46763BD9870CC46C4EF4641C6BDC", hash_generated_field = "A4CB644B81B9880592D43A90E29E3123")

    private static boolean computeContentLengthFromMessage = false;
}

