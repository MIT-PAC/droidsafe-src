package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

public class ServerParser extends HeaderParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.733 -0400", hash_original_method = "34ED7286D2A920D6CAAB19B69F1E2272", hash_generated_method = "888E93136AD8569BFDC8D4F05F7D97A3")
    public  ServerParser(String server) {
        super(server);
        addTaint(server.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.734 -0400", hash_original_method = "D6FF2C5B569C35FFD38E06BDFF6C27A4", hash_generated_method = "8A465FAAC11B416930BD68F6E655D9F3")
    protected  ServerParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:38.776 -0400", hash_original_method = "F7C094FE7E8356B9E6B34E820636D434", hash_generated_method = "4B795A13F98154E3EFA73AEC546340C3")
    public SIPHeader parse() throws ParseException {
        if(debug)        
        dbg_enter("ServerParser.parse");
        Server server = new Server();
        try 
        {
            headerName(TokenTypes.SERVER);
            if(this.lexer.lookAhead(0) == '\n')            
            {
            java.text.ParseException var2A78B7EA9E0D9AA1D9EB461A1311D9F5_1537191459 = createParseException("empty header");
            var2A78B7EA9E0D9AA1D9EB461A1311D9F5_1537191459.addTaint(taint);
            throw var2A78B7EA9E0D9AA1D9EB461A1311D9F5_1537191459;
            }
            while
(this.lexer.lookAhead(0) != '\n'
                && this.lexer.lookAhead(0) != '\0')            
            {
                if(this.lexer.lookAhead(0) == '(')                
                {
                    String comment = this.lexer.comment();
                    server.addProductToken('(' + comment + ')');
                } //End block
                else
                {
                    String tok;
                    int marker = 0;
                    try 
                    {
                        marker = this.lexer.markInputPosition();
                        tok = this.lexer.getString('/');
                        if(tok.charAt(tok.length() - 1) == '\n')                        
                        tok = tok.trim();
                        server.addProductToken(tok);
                    } //End block
                    catch (ParseException ex)
                    {
                        this.lexer.rewindInputPosition(marker);
                        tok = this.lexer.getRest().trim();
                        server.addProductToken(tok);
                        break;
                    } //End block
                } //End block
            } //End block
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("ServerParser.parse");
        } //End block
SIPHeader varCF007A6E73A4D4959380322938EA0E3D_1317090543 =         server;
        varCF007A6E73A4D4959380322938EA0E3D_1317090543.addTaint(taint);
        return varCF007A6E73A4D4959380322938EA0E3D_1317090543;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

