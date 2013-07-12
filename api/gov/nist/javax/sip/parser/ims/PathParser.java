package gov.nist.javax.sip.parser.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.ims.Path;
import gov.nist.javax.sip.header.ims.PathList;
import gov.nist.javax.sip.parser.AddressParametersParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.TokenTypes;
import java.text.ParseException;

public class PathParser extends AddressParametersParser implements TokenTypes {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.195 -0400", hash_original_method = "7A079BF63C48031C1D75ACF959BDA24D", hash_generated_method = "8C9FF8410B31649835F48ABA0CD38AC9")
    public  PathParser(String path) {
        super(path);
        addTaint(path.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.196 -0400", hash_original_method = "91CE1B5A663F1BD7DA26A8D59664C334", hash_generated_method = "F9264225D532990B0A316E96E402C1BB")
    protected  PathParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.224 -0400", hash_original_method = "F1314A453C93E830C24484946DC25942", hash_generated_method = "A77BB97CCF9FBF41D6AB5AC87D68D855")
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
                } 
                else
    if(la == '\n')                
                break;
                else
                {
                java.text.ParseException var7805DD1445672D84C07E56FCC19D9765_1809240963 = createParseException("unexpected char");
                var7805DD1445672D84C07E56FCC19D9765_1809240963.addTaint(taint);
                throw var7805DD1445672D84C07E56FCC19D9765_1809240963;
                }
            } 
SIPHeader var024CEB90B19D0AC297D288C50E00741D_325636660 =             pathList;
            var024CEB90B19D0AC297D288C50E00741D_325636660.addTaint(taint);
            return var024CEB90B19D0AC297D288C50E00741D_325636660;
        } 
        finally 
        {
    if(debug)            
            dbg_leave("PathParser.parse");
        } 
        
        
    }

    
}

