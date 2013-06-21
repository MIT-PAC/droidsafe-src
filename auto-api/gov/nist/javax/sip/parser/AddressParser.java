package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.address.*;
import java.text.ParseException;

public class AddressParser extends Parser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.224 -0400", hash_original_method = "DDF0B6D19753B0F457279892E29569BE", hash_generated_method = "C722CA8B82C8C252F37BC23438EDC8C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AddressParser(Lexer lexer) {
        dsTaint.addTaint(lexer.dsTaint);
        this.lexer = lexer;
        this.lexer.selectLexer("charLexer");
        // ---------- Original Method ----------
        //this.lexer = lexer;
        //this.lexer.selectLexer("charLexer");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.224 -0400", hash_original_method = "8E6C25B6D8313F3B657F98EEF90351BF", hash_generated_method = "8AC8ED3A945A72B21C763097F3ED0EFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AddressParser(String address) {
        dsTaint.addTaint(address);
        this.lexer = new Lexer("charLexer", address);
        // ---------- Original Method ----------
        //this.lexer = new Lexer("charLexer", address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.225 -0400", hash_original_method = "FFACB1FB21E7531199E63E4BDFD4B5B1", hash_generated_method = "3B380ABA033F2B33B95A4639A53C84FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected AddressImpl nameAddr() throws ParseException {
        dbg_enter("nameAddr");
        try 
        {
            {
                boolean var7B63CA3A57F9C3BCE27B67F3869E0AB1_1051200624 = (this.lexer.lookAhead(0) == '<');
                {
                    this.lexer.consume(1);
                    this.lexer.selectLexer("sip_urlLexer");
                    this.lexer.SPorHT();
                    URLParser uriParser;
                    uriParser = new URLParser((Lexer) lexer);
                    GenericURI uri;
                    uri = uriParser.uriReference( true );
                    AddressImpl retval;
                    retval = new AddressImpl();
                    retval.setAddressType(AddressImpl.NAME_ADDR);
                    retval.setURI(uri);
                    this.lexer.SPorHT();
                    this.lexer.match('>');
                } //End block
                {
                    AddressImpl addr;
                    addr = new AddressImpl();
                    addr.setAddressType(AddressImpl.NAME_ADDR);
                    String name;
                    name = null;
                    {
                        boolean var776EDCC72A84E14AC286E49571044B74_1449131678 = (this.lexer.lookAhead(0) == '\"');
                        {
                            name = this.lexer.quotedString();
                            this.lexer.SPorHT();
                        } //End block
                        name = this.lexer.getNextToken('<');
                    } //End collapsed parenthetic
                    addr.setDisplayName(name.trim());
                    this.lexer.match('<');
                    this.lexer.SPorHT();
                    URLParser uriParser;
                    uriParser = new URLParser((Lexer) lexer);
                    GenericURI uri;
                    uri = uriParser.uriReference( true );
                    AddressImpl retval;
                    retval = new AddressImpl();
                    addr.setAddressType(AddressImpl.NAME_ADDR);
                    addr.setURI(uri);
                    this.lexer.SPorHT();
                    this.lexer.match('>');
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("nameAddr");
        } //End block
        return (AddressImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.225 -0400", hash_original_method = "54D730AA0CABE4752468E1C28394616F", hash_generated_method = "8E5ED471EC661374C2B24C8AA442F7CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AddressImpl address( boolean inclParams ) throws ParseException {
        dsTaint.addTaint(inclParams);
        dbg_enter("address");
        AddressImpl retval;
        retval = null;
        try 
        {
            int k;
            k = 0;
            {
                boolean var9783FB04504A12AC5E4CB1806E828D43_1601953237 = (lexer.hasMoreChars());
                {
                    char la;
                    la = lexer.lookAhead(k);
                    if (DroidSafeAndroidRuntime.control) throw createParseException("unexpected EOL");
                } //End block
            } //End collapsed parenthetic
            char la;
            la = lexer.lookAhead(k);
            {
                retval = nameAddr();
            } //End block
            {
                retval = new AddressImpl();
                URLParser uriParser;
                uriParser = new URLParser((Lexer) lexer);
                GenericURI uri;
                uri = uriParser.uriReference( inclParams );
                retval.setAddressType(AddressImpl.ADDRESS_SPEC);
                retval.setURI(uri);
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw createParseException("Bad address spec");
            } //End block
        } //End block
        finally 
        {
            dbg_leave("address");
        } //End block
        return (AddressImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

