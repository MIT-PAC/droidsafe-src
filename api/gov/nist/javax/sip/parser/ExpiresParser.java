package gov.nist.javax.sip.parser;

// Droidsafe Imports
import gov.nist.javax.sip.header.Expires;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ExpiresParser extends HeaderParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.495 -0400", hash_original_method = "A7328899640752C7683A3AAB5686C434", hash_generated_method = "91AD4A144E3219744EF95FFB87DA18A5")
    public  ExpiresParser(String text) {
        super(text);
        addTaint(text.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.496 -0400", hash_original_method = "8C0F40C2F214AF533DDC04CFAC4ADA24", hash_generated_method = "01CE2D3D2FDBF84082EF3A8A9C12D81D")
    protected  ExpiresParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.528 -0400", hash_original_method = "BF637AC6A5CBD4DC0512611361485C35", hash_generated_method = "215629D248540432BC5F170743E70E54")
    public SIPHeader parse() throws ParseException {
        Expires expires = new Expires();
        if(debug)        
        dbg_enter("parse");
        try 
        {
            lexer.match(TokenTypes.EXPIRES);
            lexer.SPorHT();
            lexer.match(':');
            lexer.SPorHT();
            String nextId = lexer.getNextId();
            lexer.match('\n');
            try 
            {
                int delta = Integer.parseInt(nextId);
                expires.setExpires(delta);
SIPHeader var1F40635C1A2E405B8C2A4BA335625EE0_2011955107 =                 expires;
                var1F40635C1A2E405B8C2A4BA335625EE0_2011955107.addTaint(taint);
                return var1F40635C1A2E405B8C2A4BA335625EE0_2011955107;
            } //End block
            catch (NumberFormatException ex)
            {
                java.text.ParseException var5FB99FE9B64E519E79EC6426B25925EC_1261300137 = createParseException("bad integer format");
                var5FB99FE9B64E519E79EC6426B25925EC_1261300137.addTaint(taint);
                throw var5FB99FE9B64E519E79EC6426B25925EC_1261300137;
            } //End block
            catch (InvalidArgumentException ex)
            {
                java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1387384184 = createParseException(ex.getMessage());
                varB8C80F72F95BF6A850D07F4EC5726C09_1387384184.addTaint(taint);
                throw varB8C80F72F95BF6A850D07F4EC5726C09_1387384184;
            } //End block
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("parse");
        } //End block
        // ---------- Original Method ----------
        //Expires expires = new Expires();
        //if (debug)
            //dbg_enter("parse");
        //try {
            //lexer.match(TokenTypes.EXPIRES);
            //lexer.SPorHT();
            //lexer.match(':');
            //lexer.SPorHT();
            //String nextId = lexer.getNextId();
            //lexer.match('\n');
            //try {
                //int delta = Integer.parseInt(nextId);
                //expires.setExpires(delta);
                //return expires;
            //} catch (NumberFormatException ex) {
                //throw createParseException("bad integer format");
            //} catch (InvalidArgumentException ex) {
                //throw createParseException(ex.getMessage());
            //}
        //} finally {
            //if (debug)
                //dbg_leave("parse");
        //}
    }

    
}

