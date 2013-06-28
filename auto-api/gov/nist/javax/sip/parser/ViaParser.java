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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.954 -0400", hash_original_method = "0CA9F50F0D44148E6CD64450736B4031", hash_generated_method = "A595FA4AF354454E04B84C7828F56E64")
    public  ViaParser(String via) {
        super(via);
        addTaint(via.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.954 -0400", hash_original_method = "16747522FA7D80CA65EEE675350A9BF1", hash_generated_method = "AB2626686D9A6EC63ED495A950EFFDAC")
    public  ViaParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.955 -0400", hash_original_method = "2208496A4921623C92FF093043E5D238", hash_generated_method = "807B6533E010D10185B62378520A94FA")
    private void parseVia(Via v) throws ParseException {
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
        {
            boolean var96A32AC0A30F05473A254B92D685A530_1389014244 = (lexer.lookAhead(0) == ';');
            {
                this.lexer.consume(1);
                this.lexer.SPorHT();
                NameValue nameValue = this.nameValue();
                String name = nameValue.getName();
                {
                    boolean var5AC1D29C9E01A98D010A256EE655A472_450116839 = (name.equals(Via.BRANCH));
                    {
                        String branchId = (String) nameValue.getValueAsObject();
                        if (DroidSafeAndroidRuntime.control) throw new ParseException("null branch Id", lexer.getPtr());
                    } //End block
                } //End collapsed parenthetic
                v.setParameter(nameValue);
                this.lexer.SPorHT();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var95FD7756D0F4D66FE88CED204A89FE7A_767910683 = (lexer.lookAhead(0) == '(');
            {
                this.lexer.selectLexer("charLexer");
                lexer.consume(1);
                StringBuffer comment = new StringBuffer();
                {
                    char ch = lexer.lookAhead(0);
                    {
                        lexer.consume(1);
                    } //End block
                    {
                        Token tok = lexer.getNextToken();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.956 -0400", hash_original_method = "5AA78E39B6EC64AD2F4CBC59769995CB", hash_generated_method = "C710F01C288E088F73F5784FC011BFA3")
    protected NameValue nameValue() throws ParseException {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_265585582 = null; //Variable for return #1
        NameValue varB4EAC82CA7396A68D541C85D26508E83_768529911 = null; //Variable for return #2
        NameValue varB4EAC82CA7396A68D541C85D26508E83_2040882601 = null; //Variable for return #3
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
                {
                    lexer.consume(1);
                    lexer.SPorHT();
                    String str = null;
                    {
                        boolean varC5C0FF43AD91B5B0075AF6BA19AF8C36_71207305 = (name.getTokenValue().compareToIgnoreCase(Via.RECEIVED) == 0);
                        {
                            str = lexer.byteStringNoSemicolon();
                        } //End block
                        {
                            {
                                boolean var57818337835E12BAD166BBE7198517E8_1588753300 = (lexer.lookAhead(0) == '\"');
                                {
                                    str = lexer.quotedString();
                                    quoted = true;
                                } //End block
                                {
                                    lexer.match(LexerCore.ID);
                                    Token value = lexer.getNextToken();
                                    str = value.getTokenValue();
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    NameValue nv = new NameValue(name.getTokenValue()
                            .toLowerCase(), str);
                    nv.setQuotedValue();
                    varB4EAC82CA7396A68D541C85D26508E83_265585582 = nv;
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_768529911 = new NameValue(name.getTokenValue().toLowerCase(),
                            null);
                } //End block
            } //End block
            catch (ParseException ex)
            {
                varB4EAC82CA7396A68D541C85D26508E83_2040882601 = new NameValue(name.getTokenValue(), null);
            } //End block
        } //End block
        finally 
        {
            dbg_leave("nameValue");
        } //End block
        NameValue varA7E53CE21691AB073D9660D615818899_236993141; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_236993141 = varB4EAC82CA7396A68D541C85D26508E83_265585582;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_236993141 = varB4EAC82CA7396A68D541C85D26508E83_768529911;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_236993141 = varB4EAC82CA7396A68D541C85D26508E83_2040882601;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_236993141.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_236993141;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.957 -0400", hash_original_method = "2B03679359A52BF0E5FCCEF061A24457", hash_generated_method = "7BCC83EF80A374A7471FE6FF406870B3")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_455254297 = null; //Variable for return #1
        dbg_enter("parse");
        try 
        {
            ViaList viaList = new ViaList();
            this.lexer.match(TokenTypes.VIA);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            {
                Via v = new Via();
                parseVia(v);
                viaList.add(v);
                this.lexer.SPorHT();
                {
                    boolean varBB6C606F08DEB32F536FD814D9250A9A_276713226 = (this.lexer.lookAhead(0) == ',');
                    {
                        this.lexer.consume(1);
                        this.lexer.SPorHT();
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var292F6FF60BF4A0F7195BDD598E5CCBD3_761623641 = (this.lexer.lookAhead(0) == '\n');
                } //End collapsed parenthetic
            } //End block
            this.lexer.match('\n');
            varB4EAC82CA7396A68D541C85D26508E83_455254297 = viaList;
        } //End block
        finally 
        {
            dbg_leave("parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_455254297.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_455254297;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

