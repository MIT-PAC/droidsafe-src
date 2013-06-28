package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.Path;
import gov.nist.javax.sip.header.ims.PathList;
import gov.nist.javax.sip.parser.AddressParametersParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;
import java.text.ParseException;

public class PathParser extends AddressParametersParser implements TokenTypes {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.181 -0400", hash_original_method = "7A079BF63C48031C1D75ACF959BDA24D", hash_generated_method = "8C9FF8410B31649835F48ABA0CD38AC9")
    public  PathParser(String path) {
        super(path);
        addTaint(path.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.181 -0400", hash_original_method = "91CE1B5A663F1BD7DA26A8D59664C334", hash_generated_method = "F9264225D532990B0A316E96E402C1BB")
    protected  PathParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.182 -0400", hash_original_method = "F1314A453C93E830C24484946DC25942", hash_generated_method = "0F35743467510C12CF624D86A840B105")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1124771936 = null; //Variable for return #1
        PathList pathList = new PathList();
        dbg_enter("PathParser.parse");
        try 
        {
            this.lexer.match(TokenTypes.PATH);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            {
                Path path = new Path();
                super.parse(path);
                pathList.add(path);
                this.lexer.SPorHT();
                char la = lexer.lookAhead(0);
                {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                } //End block
                if (DroidSafeAndroidRuntime.control) throw createParseException("unexpected char");
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1124771936 = pathList;
        } //End block
        finally 
        {
            dbg_leave("PathParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1124771936.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1124771936;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

