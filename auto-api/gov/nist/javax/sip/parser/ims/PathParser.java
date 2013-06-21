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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.777 -0400", hash_original_method = "7A079BF63C48031C1D75ACF959BDA24D", hash_generated_method = "93CBFFCA4045B7DD44150AA2480B9F27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PathParser(String path) {
        super(path);
        dsTaint.addTaint(path);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.777 -0400", hash_original_method = "91CE1B5A663F1BD7DA26A8D59664C334", hash_generated_method = "E3CB5189145A0F60435069AE0E069D16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected PathParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.777 -0400", hash_original_method = "F1314A453C93E830C24484946DC25942", hash_generated_method = "660CB20D9864B04485F4D0E779A749B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        PathList pathList;
        pathList = new PathList();
        dbg_enter("PathParser.parse");
        try 
        {
            this.lexer.match(TokenTypes.PATH);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            {
                Path path;
                path = new Path();
                super.parse(path);
                pathList.add(path);
                this.lexer.SPorHT();
                char la;
                la = lexer.lookAhead(0);
                {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                } //End block
                if (DroidSafeAndroidRuntime.control) throw createParseException("unexpected char");
            } //End block
        } //End block
        finally 
        {
            dbg_leave("PathParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

