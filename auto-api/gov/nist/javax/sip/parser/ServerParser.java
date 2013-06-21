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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.533 -0400", hash_original_method = "34ED7286D2A920D6CAAB19B69F1E2272", hash_generated_method = "0C428741CFE4619E95CD31E847F108D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServerParser(String server) {
        super(server);
        dsTaint.addTaint(server);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.534 -0400", hash_original_method = "D6FF2C5B569C35FFD38E06BDFF6C27A4", hash_generated_method = "4F3DBD50B7F3E245D99CFA2256DE1D66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ServerParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.534 -0400", hash_original_method = "F7C094FE7E8356B9E6B34E820636D434", hash_generated_method = "59E00456364F58B07E2BEF96660E6BA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("ServerParser.parse");
        Server server;
        server = new Server();
        try 
        {
            headerName(TokenTypes.SERVER);
            {
                boolean varE8319E96ED7B82FE86A0F5A02AAB8C1A_1254937977 = (this.lexer.lookAhead(0) == '\n');
                if (DroidSafeAndroidRuntime.control) throw createParseException("empty header");
            } //End collapsed parenthetic
            {
                boolean var8FB4C24DD238037CA48CACBA0110A3FD_1257507965 = (this.lexer.lookAhead(0) != '\n'
                && this.lexer.lookAhead(0) != '\0');
                {
                    {
                        boolean varBE42586E6C05C1C337617197702A94AB_1626598842 = (this.lexer.lookAhead(0) == '(');
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
                                    boolean var7758689215C22180F3AD46F78EC11CE9_731244226 = (tok.charAt(tok.length() - 1) == '\n');
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
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

