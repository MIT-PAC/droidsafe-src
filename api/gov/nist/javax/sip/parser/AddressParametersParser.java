package gov.nist.javax.sip.parser;

// Droidsafe Imports
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.AddressParametersHeader;

import java.text.ParseException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class AddressParametersParser extends ParametersParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.763 -0400", hash_original_method = "C3BA12083B7F74793C4F2E2FB3C1DB43", hash_generated_method = "0A98B82046309B91B28D34D99AE83B32")
    protected  AddressParametersParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.764 -0400", hash_original_method = "D3B3C15A6507A072481DABC46CDC9E97", hash_generated_method = "FE6FDA4F8652475F409E7BF0F7526903")
    protected  AddressParametersParser(String buffer) {
        super(buffer);
        addTaint(buffer.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.765 -0400", hash_original_method = "CAB6813880E3A34B3347219ABB88ECB8", hash_generated_method = "7397D47E35DCEACFF126F85021A286CD")
    protected void parse(AddressParametersHeader addressParametersHeader) throws ParseException {
        addTaint(addressParametersHeader.getTaint());
        dbg_enter("AddressParametersParser.parse");
        try 
        {
            AddressParser addressParser = new AddressParser(this.getLexer());
            AddressImpl addr = addressParser.address(false);
            addressParametersHeader.setAddress(addr);
            lexer.SPorHT();
            char la = this.lexer.lookAhead(0);
            if(this.lexer.hasMoreChars() &&
                 la != '\0' &&
                 la != '\n' &&
                 this.lexer.startsId())            
            {
                super.parseNameValueList(addressParametersHeader);
            } //End block
            else
            super.parse(addressParametersHeader);
        } //End block
        catch (ParseException ex)
        {
            ex.addTaint(taint);
            throw ex;
        } //End block
        finally 
        {
            dbg_leave("AddressParametersParser.parse");
        } //End block
        // ---------- Original Method ----------
        //dbg_enter("AddressParametersParser.parse");
        //try {
            //AddressParser addressParser = new AddressParser(this.getLexer());
            //AddressImpl addr = addressParser.address(false);
            //addressParametersHeader.setAddress(addr);
            //lexer.SPorHT();
            //char la = this.lexer.lookAhead(0);
            //if ( this.lexer.hasMoreChars() &&
                 //la != '\0' &&
                 //la != '\n' &&
                 //this.lexer.startsId()) {
                 //super.parseNameValueList(addressParametersHeader);
            //}  else super.parse(addressParametersHeader);
        //} catch (ParseException ex) {
            //throw ex;
        //} finally {
            //dbg_leave("AddressParametersParser.parse");
        //}
    }

    
}

