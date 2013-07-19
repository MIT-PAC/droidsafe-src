package gov.nist.javax.sip.parser;

// Droidsafe Imports
import gov.nist.javax.sip.header.MaxForwards;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class MaxForwardsParser extends HeaderParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.776 -0400", hash_original_method = "005E89A999CEFE80041E010521110160", hash_generated_method = "48AAFDDDE42774E4C5643D05760B0D86")
    public  MaxForwardsParser(String contentLength) {
        super(contentLength);
        addTaint(contentLength.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.776 -0400", hash_original_method = "387C44575196A6CA2DFD9A3719D601C5", hash_generated_method = "5B26658256F06654B3E660E86989DD56")
    protected  MaxForwardsParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.807 -0400", hash_original_method = "1EF61729E616CF3DAFF49967F4EF386E", hash_generated_method = "141CA71C04F7968DA770F1351082BBDE")
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
SIPHeader var9ADA374ACA6AF88A2E93F2C3C80FE244_1631244466 =             contentLength;
            var9ADA374ACA6AF88A2E93F2C3C80FE244_1631244466.addTaint(taint);
            return var9ADA374ACA6AF88A2E93F2C3C80FE244_1631244466;
        } //End block
        catch (InvalidArgumentException ex)
        {
            java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1667451875 = createParseException(ex.getMessage());
            varB8C80F72F95BF6A850D07F4EC5726C09_1667451875.addTaint(taint);
            throw varB8C80F72F95BF6A850D07F4EC5726C09_1667451875;
        } //End block
        catch (NumberFormatException ex)
        {
            java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1321812566 = createParseException(ex.getMessage());
            varB8C80F72F95BF6A850D07F4EC5726C09_1321812566.addTaint(taint);
            throw varB8C80F72F95BF6A850D07F4EC5726C09_1321812566;
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

