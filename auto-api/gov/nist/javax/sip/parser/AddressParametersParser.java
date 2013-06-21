package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.javax.sip.address.*;
import java.text.ParseException;

public class AddressParametersParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.218 -0400", hash_original_method = "C3BA12083B7F74793C4F2E2FB3C1DB43", hash_generated_method = "CB6EB236CD792D7831180F49DF09B097")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected AddressParametersParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.218 -0400", hash_original_method = "D3B3C15A6507A072481DABC46CDC9E97", hash_generated_method = "E50B0E43618D16E5DDCBAF4ED92622BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected AddressParametersParser(String buffer) {
        super(buffer);
        dsTaint.addTaint(buffer);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.219 -0400", hash_original_method = "CAB6813880E3A34B3347219ABB88ECB8", hash_generated_method = "707383D7FD3F86E91DFD7EB8082E8621")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void parse(AddressParametersHeader addressParametersHeader) throws ParseException {
        dsTaint.addTaint(addressParametersHeader.dsTaint);
        dbg_enter("AddressParametersParser.parse");
        try 
        {
            AddressParser addressParser;
            addressParser = new AddressParser(this.getLexer());
            AddressImpl addr;
            addr = addressParser.address(false);
            addressParametersHeader.setAddress(addr);
            lexer.SPorHT();
            char la;
            la = this.lexer.lookAhead(0);
            {
                boolean var89A296B3201ECAD292C08595A9E0F0E3_624868692 = (this.lexer.hasMoreChars() &&
                 la != '\0' &&
                 la != '\n' &&
                 this.lexer.startsId());
                {
                    super.parseNameValueList(addressParametersHeader);
                } //End block
                super.parse(addressParametersHeader);
            } //End collapsed parenthetic
        } //End block
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw ex;
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

