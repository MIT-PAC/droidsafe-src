package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.javax.sip.address.*;
import java.text.ParseException;

public class AddressParametersParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.677 -0400", hash_original_method = "C3BA12083B7F74793C4F2E2FB3C1DB43", hash_generated_method = "0A98B82046309B91B28D34D99AE83B32")
    protected  AddressParametersParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.677 -0400", hash_original_method = "D3B3C15A6507A072481DABC46CDC9E97", hash_generated_method = "FE6FDA4F8652475F409E7BF0F7526903")
    protected  AddressParametersParser(String buffer) {
        super(buffer);
        addTaint(buffer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:42.677 -0400", hash_original_method = "CAB6813880E3A34B3347219ABB88ECB8", hash_generated_method = "C8675B416098757185430E0108DDD061")
    protected void parse(AddressParametersHeader addressParametersHeader) throws ParseException {
        dbg_enter("AddressParametersParser.parse");
        try 
        {
            AddressParser addressParser = new AddressParser(this.getLexer());
            AddressImpl addr = addressParser.address(false);
            addressParametersHeader.setAddress(addr);
            lexer.SPorHT();
            char la = this.lexer.lookAhead(0);
            {
                boolean var89A296B3201ECAD292C08595A9E0F0E3_137276520 = (this.lexer.hasMoreChars() &&
                 la != '\0' &&
                 la != '\n' &&
                 this.lexer.startsId());
                {
                    super.parseNameValueList(addressParametersHeader);
                } 
                super.parse(addressParametersHeader);
            } 
        } 
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw ex;
        } 
        finally 
        {
            dbg_leave("AddressParametersParser.parse");
        } 
        addTaint(addressParametersHeader.getTaint());
        
        
        
            
            
            
            
            
            
                 
                 
                 
                 
            
        
            
        
            
        
    }

    
}

