package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.AddressParametersHeader;

import java.text.ParseException;





public class AddressParametersParser extends ParametersParser {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.927 -0500", hash_original_method = "C3BA12083B7F74793C4F2E2FB3C1DB43", hash_generated_method = "32C575E0B6268B101B0077F16A99F56C")
    protected AddressParametersParser(Lexer lexer) {
        super(lexer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.928 -0500", hash_original_method = "D3B3C15A6507A072481DABC46CDC9E97", hash_generated_method = "529CAB5982D0D39B47DFD01EDBEDDBF6")
    protected AddressParametersParser(String buffer) {
        super(buffer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:10.929 -0500", hash_original_method = "CAB6813880E3A34B3347219ABB88ECB8", hash_generated_method = "A2A5470D439F3076CF9501A7A3EF357C")
    protected void parse(AddressParametersHeader addressParametersHeader)
        throws ParseException {
        dbg_enter("AddressParametersParser.parse");
        try {
            AddressParser addressParser = new AddressParser(this.getLexer());
            AddressImpl addr = addressParser.address(false);
            addressParametersHeader.setAddress(addr);
            lexer.SPorHT();
            char la = this.lexer.lookAhead(0);
            if ( this.lexer.hasMoreChars() &&
                 la != '\0' &&
                 la != '\n' &&
                 this.lexer.startsId()) {

                 super.parseNameValueList(addressParametersHeader);


            }  else super.parse(addressParametersHeader);

        } catch (ParseException ex) {
            throw ex;
        } finally {
            dbg_leave("AddressParametersParser.parse");
        }
    }

    
}

