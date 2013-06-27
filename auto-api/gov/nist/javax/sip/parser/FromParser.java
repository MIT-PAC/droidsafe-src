package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.From;
import gov.nist.javax.sip.header.SIPHeader;
import java.text.ParseException;

public class FromParser extends AddressParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.763 -0400", hash_original_method = "959F9668B577E560A18D35872EBA8497", hash_generated_method = "885FA40AC3C138A7BD1A0F6967FB5387")
    public  FromParser(String from) {
        super(from);
        addTaint(from.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.766 -0400", hash_original_method = "CEE001D4136BA6038E80B22CA8F776D5", hash_generated_method = "BC246DE981154C301C0558972F241666")
    protected  FromParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.767 -0400", hash_original_method = "090BCBCCA2A0D46A805C56D0690187FF", hash_generated_method = "46F643FB21D18C0066D8FC9FB5FFB64A")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_491932217 = null; //Variable for return #1
        From from;
        from = new From();
        this.lexer.match(TokenTypes.FROM);
        this.lexer.SPorHT();
        this.lexer.match(':');
        this.lexer.SPorHT();
        super.parse(from);
        this.lexer.match('\n');
        varB4EAC82CA7396A68D541C85D26508E83_491932217 = from;
        varB4EAC82CA7396A68D541C85D26508E83_491932217.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_491932217;
        // ---------- Original Method ----------
        //From from = new From();
        //this.lexer.match(TokenTypes.FROM);
        //this.lexer.SPorHT();
        //this.lexer.match(':');
        //this.lexer.SPorHT();
        //super.parse(from);
        //this.lexer.match('\n');
        //return from;
    }

    
}

