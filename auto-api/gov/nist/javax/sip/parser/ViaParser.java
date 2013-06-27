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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.411 -0400", hash_original_method = "0CA9F50F0D44148E6CD64450736B4031", hash_generated_method = "A595FA4AF354454E04B84C7828F56E64")
    public  ViaParser(String via) {
        super(via);
        addTaint(via.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.423 -0400", hash_original_method = "16747522FA7D80CA65EEE675350A9BF1", hash_generated_method = "AB2626686D9A6EC63ED495A950EFFDAC")
    public  ViaParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.427 -0400", hash_original_method = "2208496A4921623C92FF093043E5D238", hash_generated_method = "6A7B2958887FF9A9D07091BBFA0D6B7B")
    private void parseVia(Via v) throws ParseException {
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
            boolean var96A32AC0A30F05473A254B92D685A530_381154346 = (lexer.lookAhead(0) == ';');
            {
                this.lexer.consume(1);
                this.lexer.SPorHT();
                NameValue nameValue;
                nameValue = this.nameValue();
                String name;
                name = nameValue.getName();
                {
                    boolean var5AC1D29C9E01A98D010A256EE655A472_1085763668 = (name.equals(Via.BRANCH));
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
            boolean var95FD7756D0F4D66FE88CED204A89FE7A_1791236200 = (lexer.lookAhead(0) == '(');
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
        addTaint(v.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.429 -0400", hash_original_method = "5AA78E39B6EC64AD2F4CBC59769995CB", hash_generated_method = "EB72F3DF6D36C9317916ACBB2F8FA81A")
    protected NameValue nameValue() throws ParseException {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_1693594191 = null; //Variable for return #1
        NameValue varB4EAC82CA7396A68D541C85D26508E83_566546548 = null; //Variable for return #2
        NameValue varB4EAC82CA7396A68D541C85D26508E83_1868554569 = null; //Variable for return #3
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
                        boolean varC5C0FF43AD91B5B0075AF6BA19AF8C36_925484196 = (name.getTokenValue().compareToIgnoreCase(Via.RECEIVED) == 0);
                        {
                            str = lexer.byteStringNoSemicolon();
                        } //End block
                        {
                            {
                                boolean var57818337835E12BAD166BBE7198517E8_131475513 = (lexer.lookAhead(0) == '\"');
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
                    varB4EAC82CA7396A68D541C85D26508E83_1693594191 = nv;
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_566546548 = new NameValue(name.getTokenValue().toLowerCase(),
                            null);
                } //End block
            } //End block
            catch (ParseException ex)
            {
                varB4EAC82CA7396A68D541C85D26508E83_1868554569 = new NameValue(name.getTokenValue(), null);
            } //End block
        } //End block
        finally 
        {
            dbg_leave("nameValue");
        } //End block
        NameValue varA7E53CE21691AB073D9660D615818899_785976887; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_785976887 = varB4EAC82CA7396A68D541C85D26508E83_1693594191;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_785976887 = varB4EAC82CA7396A68D541C85D26508E83_566546548;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_785976887 = varB4EAC82CA7396A68D541C85D26508E83_1868554569;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_785976887.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_785976887;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.439 -0400", hash_original_method = "2B03679359A52BF0E5FCCEF061A24457", hash_generated_method = "3C26F0616AF9C6E817631BFF5B9B5B98")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1000316630 = null; //Variable for return #1
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
                    boolean varBB6C606F08DEB32F536FD814D9250A9A_2141912610 = (this.lexer.lookAhead(0) == ',');
                    {
                        this.lexer.consume(1);
                        this.lexer.SPorHT();
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var292F6FF60BF4A0F7195BDD598E5CCBD3_86413922 = (this.lexer.lookAhead(0) == '\n');
                } //End collapsed parenthetic
            } //End block
            this.lexer.match('\n');
            varB4EAC82CA7396A68D541C85D26508E83_1000316630 = viaList;
        } //End block
        finally 
        {
            dbg_leave("parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1000316630.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1000316630;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

