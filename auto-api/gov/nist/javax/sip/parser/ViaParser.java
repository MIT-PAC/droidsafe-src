package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class ViaParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.708 -0400", hash_original_method = "0CA9F50F0D44148E6CD64450736B4031", hash_generated_method = "41406145213E983C23D0645BEFDE1C81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViaParser(String via) {
        super(via);
        dsTaint.addTaint(via);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.708 -0400", hash_original_method = "16747522FA7D80CA65EEE675350A9BF1", hash_generated_method = "5B67B1C552CCDD82B87E9E204738C429")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViaParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.709 -0400", hash_original_method = "2208496A4921623C92FF093043E5D238", hash_generated_method = "66FB447F211EBF3B8B259491D4C84157")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseVia(Via v) throws ParseException {
        dsTaint.addTaint(v.dsTaint);
        lexer.match(TokenTypes.ID);
        Token protocolName;
        protocolName = lexer.getNextToken();
        this.lexer.SPorHT();
        lexer.match('/');
        this.lexer.SPorHT();
        lexer.match(TokenTypes.ID);
        this.lexer.SPorHT();
        Token protocolVersion;
        protocolVersion = lexer.getNextToken();
        this.lexer.SPorHT();
        lexer.match('/');
        this.lexer.SPorHT();
        lexer.match(TokenTypes.ID);
        this.lexer.SPorHT();
        Token transport;
        transport = lexer.getNextToken();
        this.lexer.SPorHT();
        Protocol protocol;
        protocol = new Protocol();
        protocol.setProtocolName(protocolName.getTokenValue());
        protocol.setProtocolVersion(protocolVersion.getTokenValue());
        protocol.setTransport(transport.getTokenValue());
        v.setSentProtocol(protocol);
        HostNameParser hnp;
        hnp = new HostNameParser(this.getLexer());
        HostPort hostPort;
        hostPort = hnp.hostPort( true );
        v.setSentBy(hostPort);
        this.lexer.SPorHT();
        {
            boolean var96A32AC0A30F05473A254B92D685A530_1337843133 = (lexer.lookAhead(0) == ';');
            {
                this.lexer.consume(1);
                this.lexer.SPorHT();
                NameValue nameValue;
                nameValue = this.nameValue();
                String name;
                name = nameValue.getName();
                {
                    boolean var5AC1D29C9E01A98D010A256EE655A472_1777127022 = (name.equals(Via.BRANCH));
                    {
                        String branchId;
                        branchId = (String) nameValue.getValueAsObject();
                        if (DroidSafeAndroidRuntime.control) throw new ParseException("null branch Id", lexer.getPtr());
                    } //End block
                } //End collapsed parenthetic
                v.setParameter(nameValue);
                this.lexer.SPorHT();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var95FD7756D0F4D66FE88CED204A89FE7A_344246477 = (lexer.lookAhead(0) == '(');
            {
                this.lexer.selectLexer("charLexer");
                lexer.consume(1);
                StringBuffer comment;
                comment = new StringBuffer();
                {
                    char ch;
                    ch = lexer.lookAhead(0);
                    {
                        lexer.consume(1);
                    } //End block
                    {
                        Token tok;
                        tok = lexer.getNextToken();
                        comment.append(tok.getTokenValue());
                        lexer.consume(1);
                        tok = lexer.getNextToken();
                        comment.append(tok.getTokenValue());
                        lexer.consume(1);
                    } //End block
                    {
                        comment.append(ch);
                        lexer.consume(1);
                    } //End block
                } //End block
                v.setComment(comment.toString());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.709 -0400", hash_original_method = "5AA78E39B6EC64AD2F4CBC59769995CB", hash_generated_method = "4A2374481F1E64AC7651C0F1EECCE773")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected NameValue nameValue() throws ParseException {
        dbg_enter("nameValue");
        try 
        {
            lexer.match(LexerCore.ID);
            Token name;
            name = lexer.getNextToken();
            lexer.SPorHT();
            try 
            {
                boolean quoted;
                quoted = false;
                char la;
                la = lexer.lookAhead(0);
                {
                    lexer.consume(1);
                    lexer.SPorHT();
                    String str;
                    str = null;
                    {
                        boolean varC5C0FF43AD91B5B0075AF6BA19AF8C36_201472595 = (name.getTokenValue().compareToIgnoreCase(Via.RECEIVED) == 0);
                        {
                            str = lexer.byteStringNoSemicolon();
                        } //End block
                        {
                            {
                                boolean var57818337835E12BAD166BBE7198517E8_208974541 = (lexer.lookAhead(0) == '\"');
                                {
                                    str = lexer.quotedString();
                                    quoted = true;
                                } //End block
                                {
                                    lexer.match(LexerCore.ID);
                                    Token value;
                                    value = lexer.getNextToken();
                                    str = value.getTokenValue();
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    NameValue nv;
                    nv = new NameValue(name.getTokenValue()
                            .toLowerCase(), str);
                    nv.setQuotedValue();
                } //End block
                {
                    NameValue varF18719752F9EE36B49C15480A73C8145_1454122182 = (new NameValue(name.getTokenValue().toLowerCase(),
                            null));
                } //End block
            } //End block
            catch (ParseException ex)
            {
                NameValue var9D08D7A2ECA489BF8B459E352262A0A7_139653981 = (new NameValue(name.getTokenValue(), null));
            } //End block
        } //End block
        finally 
        {
            dbg_leave("nameValue");
        } //End block
        return (NameValue)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.710 -0400", hash_original_method = "2B03679359A52BF0E5FCCEF061A24457", hash_generated_method = "8DF1D20A9BB7413C07A4043511585ACD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("parse");
        try 
        {
            ViaList viaList;
            viaList = new ViaList();
            this.lexer.match(TokenTypes.VIA);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            {
                Via v;
                v = new Via();
                parseVia(v);
                viaList.add(v);
                this.lexer.SPorHT();
                {
                    boolean varBB6C606F08DEB32F536FD814D9250A9A_1772421092 = (this.lexer.lookAhead(0) == ',');
                    {
                        this.lexer.consume(1);
                        this.lexer.SPorHT();
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var292F6FF60BF4A0F7195BDD598E5CCBD3_220059200 = (this.lexer.lookAhead(0) == '\n');
                } //End collapsed parenthetic
            } //End block
            this.lexer.match('\n');
        } //End block
        finally 
        {
            dbg_leave("parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

