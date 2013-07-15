package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.*;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

public class MaxForwardsParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.779 -0400", hash_original_method = "005E89A999CEFE80041E010521110160", hash_generated_method = "48AAFDDDE42774E4C5643D05760B0D86")
    public  MaxForwardsParser(String contentLength) {
        super(contentLength);
        addTaint(contentLength.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.779 -0400", hash_original_method = "387C44575196A6CA2DFD9A3719D601C5", hash_generated_method = "5B26658256F06654B3E660E86989DD56")
    protected  MaxForwardsParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.808 -0400", hash_original_method = "1EF61729E616CF3DAFF49967F4EF386E", hash_generated_method = "D96B001F3172572FC1C44669601E62F5")
    public SIPHeader parse() throws ParseException {
    if(debug)        
        dbg_enter("MaxForwardsParser.enter");
        try 
        {
            MaxForwards contentLength = new MaxForwards();
            headerName(TokenTypes.MAX_FORWARDS);
            String number = this.lexer.number();
            contentLength.setMaxForwards(Integer.parseInt(number));
            this.lexer.SPorHT();
            this.lexer.match('\n');
SIPHeader var9ADA374ACA6AF88A2E93F2C3C80FE244_1999217019 =             contentLength;
            var9ADA374ACA6AF88A2E93F2C3C80FE244_1999217019.addTaint(taint);
            return var9ADA374ACA6AF88A2E93F2C3C80FE244_1999217019;
        } //End block
        catch (InvalidArgumentException ex)
        {
            java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_654566620 = createParseException(ex.getMessage());
            varB8C80F72F95BF6A850D07F4EC5726C09_654566620.addTaint(taint);
            throw varB8C80F72F95BF6A850D07F4EC5726C09_654566620;
        } //End block
        catch (NumberFormatException ex)
        {
            java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_293524291 = createParseException(ex.getMessage());
            varB8C80F72F95BF6A850D07F4EC5726C09_293524291.addTaint(taint);
            throw varB8C80F72F95BF6A850D07F4EC5726C09_293524291;
        } //End block
        finally 
        {
    if(debug)            
            dbg_leave("MaxForwardsParser.leave");
        } //End block
        // ---------- Original Method ----------
        //if (debug)
            //dbg_enter("MaxForwardsParser.enter");
        //try {
            //MaxForwards contentLength = new MaxForwards();
            //headerName(TokenTypes.MAX_FORWARDS);
            //String number = this.lexer.number();
            //contentLength.setMaxForwards(Integer.parseInt(number));
            //this.lexer.SPorHT();
            //this.lexer.match('\n');
            //return contentLength;
        //} catch (InvalidArgumentException ex) {
            //throw createParseException(ex.getMessage());
        //} catch (NumberFormatException ex) {
            //throw createParseException(ex.getMessage());
        //} finally {
            //if (debug)
                //dbg_leave("MaxForwardsParser.leave");
        //}
    }

    
}

