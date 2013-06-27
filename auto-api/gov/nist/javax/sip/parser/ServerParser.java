package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

public class ServerParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.277 -0400", hash_original_method = "34ED7286D2A920D6CAAB19B69F1E2272", hash_generated_method = "888E93136AD8569BFDC8D4F05F7D97A3")
    public  ServerParser(String server) {
        super(server);
        addTaint(server.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.277 -0400", hash_original_method = "D6FF2C5B569C35FFD38E06BDFF6C27A4", hash_generated_method = "8A465FAAC11B416930BD68F6E655D9F3")
    protected  ServerParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.294 -0400", hash_original_method = "F7C094FE7E8356B9E6B34E820636D434", hash_generated_method = "6DCD3867D0C79E530127D60D1D5F44DC")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1534921619 = null; //Variable for return #1
        dbg_enter("ServerParser.parse");
        Server server;
        server = new Server();
        try 
        {
            headerName(TokenTypes.SERVER);
            {
                boolean varE8319E96ED7B82FE86A0F5A02AAB8C1A_503134198 = (this.lexer.lookAhead(0) == '\n');
                if (DroidSafeAndroidRuntime.control) throw createParseException("empty header");
            } //End collapsed parenthetic
            {
                boolean var8FB4C24DD238037CA48CACBA0110A3FD_1582720965 = (this.lexer.lookAhead(0) != '\n'
                && this.lexer.lookAhead(0) != '\0');
                {
                    {
                        boolean varBE42586E6C05C1C337617197702A94AB_754125083 = (this.lexer.lookAhead(0) == '(');
                        {
                            String comment;
                            comment = this.lexer.comment();
                            server.addProductToken('(' + comment + ')');
                        } //End block
                        {
                            String tok;
                            int marker;
                            marker = 0;
                            try 
                            {
                                marker = this.lexer.markInputPosition();
                                tok = this.lexer.getString('/');
                                {
                                    boolean var7758689215C22180F3AD46F78EC11CE9_2066891070 = (tok.charAt(tok.length() - 1) == '\n');
                                    tok = tok.trim();
                                } //End collapsed parenthetic
                                server.addProductToken(tok);
                            } //End block
                            catch (ParseException ex)
                            {
                                this.lexer.rewindInputPosition(marker);
                                tok = this.lexer.getRest().trim();
                                server.addProductToken(tok);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("ServerParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1534921619 = server;
        varB4EAC82CA7396A68D541C85D26508E83_1534921619.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1534921619;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

