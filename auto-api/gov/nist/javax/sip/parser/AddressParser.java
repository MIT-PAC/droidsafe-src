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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.272 -0400", hash_original_method = "DDF0B6D19753B0F457279892E29569BE", hash_generated_method = "4053417C05834F49A5E8D8DEAC6BE889")
    public  AddressParser(Lexer lexer) {
        this.lexer = lexer;
        this.lexer.selectLexer("charLexer");
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
        //this.lexer = lexer;
        //this.lexer.selectLexer("charLexer");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.273 -0400", hash_original_method = "8E6C25B6D8313F3B657F98EEF90351BF", hash_generated_method = "2A54BA3AAC294E52D4481FCDF4A273D8")
    public  AddressParser(String address) {
        this.lexer = new Lexer("charLexer", address);
        addTaint(address.getTaint());
        // ---------- Original Method ----------
        //this.lexer = new Lexer("charLexer", address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.275 -0400", hash_original_method = "FFACB1FB21E7531199E63E4BDFD4B5B1", hash_generated_method = "690124AFDB5BA811BE51B1CF0731E77C")
    protected AddressImpl nameAddr() throws ParseException {
        AddressImpl varB4EAC82CA7396A68D541C85D26508E83_1294885100 = null; //Variable for return #1
        AddressImpl varB4EAC82CA7396A68D541C85D26508E83_1780631685 = null; //Variable for return #2
        dbg_enter("nameAddr");
        try 
        {
            {
                boolean var7B63CA3A57F9C3BCE27B67F3869E0AB1_71411971 = (this.lexer.lookAhead(0) == '<');
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
                    varB4EAC82CA7396A68D541C85D26508E83_1294885100 = retval;
                } //End block
                {
                    AddressImpl addr;
                    addr = new AddressImpl();
                    addr.setAddressType(AddressImpl.NAME_ADDR);
                    String name;
                    name = null;
                    {
                        boolean var776EDCC72A84E14AC286E49571044B74_1301361726 = (this.lexer.lookAhead(0) == '\"');
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
                    varB4EAC82CA7396A68D541C85D26508E83_1780631685 = addr;
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("nameAddr");
        } //End block
        AddressImpl varA7E53CE21691AB073D9660D615818899_1795163471; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1795163471 = varB4EAC82CA7396A68D541C85D26508E83_1294885100;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1795163471 = varB4EAC82CA7396A68D541C85D26508E83_1780631685;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1795163471.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1795163471;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.287 -0400", hash_original_method = "54D730AA0CABE4752468E1C28394616F", hash_generated_method = "9022132A830DD668FCE0672D6FF7448D")
    public AddressImpl address( boolean inclParams ) throws ParseException {
        AddressImpl varB4EAC82CA7396A68D541C85D26508E83_674775869 = null; //Variable for return #1
        dbg_enter("address");
        AddressImpl retval;
        retval = null;
        try 
        {
            int k;
            k = 0;
            {
                boolean var9783FB04504A12AC5E4CB1806E828D43_1378960837 = (lexer.hasMoreChars());
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
            varB4EAC82CA7396A68D541C85D26508E83_674775869 = retval;
        } //End block
        finally 
        {
            dbg_leave("address");
        } //End block
        addTaint(inclParams);
        varB4EAC82CA7396A68D541C85D26508E83_674775869.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_674775869;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

