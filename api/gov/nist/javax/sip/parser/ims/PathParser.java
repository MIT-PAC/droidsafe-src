package gov.nist.javax.sip.parser.ims;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.Path;
import gov.nist.javax.sip.header.ims.PathList;
import gov.nist.javax.sip.parser.AddressParametersParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;

import java.text.ParseException;



public class PathParser extends AddressParametersParser implements TokenTypes {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.045 -0400", hash_original_method = "7A079BF63C48031C1D75ACF959BDA24D", hash_generated_method = "8C9FF8410B31649835F48ABA0CD38AC9")
    public  PathParser(String path) {
        super(path);
        addTaint(path.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.046 -0400", hash_original_method = "91CE1B5A663F1BD7DA26A8D59664C334", hash_generated_method = "F9264225D532990B0A316E96E402C1BB")
    protected  PathParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.074 -0400", hash_original_method = "F1314A453C93E830C24484946DC25942", hash_generated_method = "5BFCDAA7F98690C138EBA5CDCC1165F4")
    public SIPHeader parse() throws ParseException {
        PathList pathList = new PathList();
        if(debug)        
        dbg_enter("PathParser.parse");
        try 
        {
            this.lexer.match(TokenTypes.PATH);
            this.lexer.SPorHT();
            this.lexer.match(':');
            this.lexer.SPorHT();
            while
(true)            
            {
                Path path = new Path();
                super.parse(path);
                pathList.add(path);
                this.lexer.SPorHT();
                char la = lexer.lookAhead(0);
                if(la == ',')                
                {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                } //End block
                else
                if(la == '\n')                
                break;
                else
                {
                java.text.ParseException var7805DD1445672D84C07E56FCC19D9765_949329519 = createParseException("unexpected char");
                var7805DD1445672D84C07E56FCC19D9765_949329519.addTaint(taint);
                throw var7805DD1445672D84C07E56FCC19D9765_949329519;
                }
            } //End block
SIPHeader var024CEB90B19D0AC297D288C50E00741D_524665310 =             pathList;
            var024CEB90B19D0AC297D288C50E00741D_524665310.addTaint(taint);
            return var024CEB90B19D0AC297D288C50E00741D_524665310;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("PathParser.parse");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

