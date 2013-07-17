package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class ViaParser extends HeaderParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.545 -0400", hash_original_method = "0CA9F50F0D44148E6CD64450736B4031", hash_generated_method = "A595FA4AF354454E04B84C7828F56E64")
    public  ViaParser(String via) {
        super(via);
        addTaint(via.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.545 -0400", hash_original_method = "16747522FA7D80CA65EEE675350A9BF1", hash_generated_method = "AB2626686D9A6EC63ED495A950EFFDAC")
    public  ViaParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.547 -0400", hash_original_method = "2208496A4921623C92FF093043E5D238", hash_generated_method = "34DA52AC96BD13820126702A933D1FEC")
    private void parseVia(Via v) throws ParseException {
        addTaint(v.getTaint());
        lexer.match(TokenTypes.ID);
        Token protocolName = lexer.getNextToken();
        this.lexer.SPorHT();
        lexer.match('/');
        this.lexer.SPorHT();
        lexer.match(TokenTypes.ID);
        this.lexer.SPorHT();
        Token protocolVersion = lexer.getNextToken();
        this.lexer.SPorHT();
        lexer.match('/');
        this.lexer.SPorHT();
        lexer.match(TokenTypes.ID);
        this.lexer.SPorHT();
        Token transport = lexer.getNextToken();
        this.lexer.SPorHT();
        Protocol protocol = new Protocol();
        protocol.setProtocolName(protocolName.getTokenValue());
        protocol.setProtocolVersion(protocolVersion.getTokenValue());
        protocol.setTransport(transport.getTokenValue());
        v.setSentProtocol(protocol);
        HostNameParser hnp = new HostNameParser(this.getLexer());
        HostPort hostPort = hnp.hostPort( true );
        v.setSentBy(hostPort);
        this.lexer.SPorHT();
        while
(lexer.lookAhead(0) == ';')        
        {
            this.lexer.consume(1);
            this.lexer.SPorHT();
            NameValue nameValue = this.nameValue();
            String name = nameValue.getName();
            if(name.equals(Via.BRANCH))            
            {
                String branchId = (String) nameValue.getValueAsObject();
                if(branchId == null)                
                {
                ParseException varE52C48940FC22DA57128553A5474BF5E_1460866180 = new ParseException("null branch Id", lexer.getPtr());
                varE52C48940FC22DA57128553A5474BF5E_1460866180.addTaint(taint);
                throw varE52C48940FC22DA57128553A5474BF5E_1460866180;
                }
            } //End block
            v.setParameter(nameValue);
            this.lexer.SPorHT();
        } //End block
        if(lexer.lookAhead(0) == '(')        
        {
            this.lexer.selectLexer("charLexer");
            lexer.consume(1);
            StringBuffer comment = new StringBuffer();
            while
(true)            
            {
                char ch = lexer.lookAhead(0);
                if(ch == ')')                
                {
                    lexer.consume(1);
                    break;
                } //End block
                else
                if(ch == '\\')                
                {
                    Token tok = lexer.getNextToken();
                    comment.append(tok.getTokenValue());
                    lexer.consume(1);
                    tok = lexer.getNextToken();
                    comment.append(tok.getTokenValue());
                    lexer.consume(1);
                } //End block
                else
                if(ch == '\n')                
                {
                    break;
                } //End block
                else
                {
                    comment.append(ch);
                    lexer.consume(1);
                } //End block
            } //End block
            v.setComment(comment.toString());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.548 -0400", hash_original_method = "5AA78E39B6EC64AD2F4CBC59769995CB", hash_generated_method = "18C0572B76BE5E89CC52AA975EC72351")
    protected NameValue nameValue() throws ParseException {
        if(debug)        
        dbg_enter("nameValue");
        try 
        {
            lexer.match(LexerCore.ID);
            Token name = lexer.getNextToken();
            lexer.SPorHT();
            try 
            {
                boolean quoted = false;
                char la = lexer.lookAhead(0);
                if(la == '=')                
                {
                    lexer.consume(1);
                    lexer.SPorHT();
                    String str = null;
                    if(name.getTokenValue().compareToIgnoreCase(Via.RECEIVED) == 0)                    
                    {
                        str = lexer.byteStringNoSemicolon();
                    } //End block
                    else
                    {
                        if(lexer.lookAhead(0) == '\"')                        
                        {
                            str = lexer.quotedString();
                            quoted = true;
                        } //End block
                        else
                        {
                            lexer.match(LexerCore.ID);
                            Token value = lexer.getNextToken();
                            str = value.getTokenValue();
                        } //End block
                    } //End block
                    NameValue nv = new NameValue(name.getTokenValue()
                            .toLowerCase(), str);
                    if(quoted)                    
                    nv.setQuotedValue();
NameValue var8CDC8D1FFB0B29D7089B99B596CC9F85_1920797659 =                     nv;
                    var8CDC8D1FFB0B29D7089B99B596CC9F85_1920797659.addTaint(taint);
                    return var8CDC8D1FFB0B29D7089B99B596CC9F85_1920797659;
                } //End block
                else
                {
NameValue var1B621EC7BECB3B67D1650544C7F9B8BD_67757227 =                     new NameValue(name.getTokenValue().toLowerCase(),
                            null);
                    var1B621EC7BECB3B67D1650544C7F9B8BD_67757227.addTaint(taint);
                    return var1B621EC7BECB3B67D1650544C7F9B8BD_67757227;
                } //End block
            } //End block
            catch (ParseException ex)
            {
NameValue varAA6B0F6934A3DB1618778075C32053F2_1074837908 =                 new NameValue(name.getTokenValue(), null);
                varAA6B0F6934A3DB1618778075C32053F2_1074837908.addTaint(taint);
                return varAA6B0F6934A3DB1618778075C32053F2_1074837908;
            } //End block
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("nameValue");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.549 -0400", hash_original_method = "2B03679359A52BF0E5FCCEF061A24457", hash_generated_method = "C171ABABC73DC6DB9C3C761EEA01B0BF")
    public SIPHeader parse() throws ParseException {
        if(debug)        
        dbg_enter("parse");
        try 
        {
            ViaList viaList = new ViaList();
            this.lexer.match(TokenTypes.VIA);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            while
(true)            
            {
                Via v = new Via();
                parseVia(v);
                viaList.add(v);
                this.lexer.SPorHT();
                if(this.lexer.lookAhead(0) == ',')                
                {
                    this.lexer.consume(1);
                    this.lexer.SPorHT();
                } //End block
                if(this.lexer.lookAhead(0) == '\n')                
                break;
            } //End block
            this.lexer.match('\n');
SIPHeader varE2A372C5D26EBDD07722713ECCD40253_873361120 =             viaList;
            varE2A372C5D26EBDD07722713ECCD40253_873361120.addTaint(taint);
            return varE2A372C5D26EBDD07722713ECCD40253_873361120;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("parse");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

