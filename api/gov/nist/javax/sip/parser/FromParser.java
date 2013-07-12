package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.From;
import gov.nist.javax.sip.header.SIPHeader;
import java.text.ParseException;

public class FromParser extends AddressParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.510 -0400", hash_original_method = "959F9668B577E560A18D35872EBA8497", hash_generated_method = "885FA40AC3C138A7BD1A0F6967FB5387")
    public  FromParser(String from) {
        super(from);
        addTaint(from.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.510 -0400", hash_original_method = "CEE001D4136BA6038E80B22CA8F776D5", hash_generated_method = "BC246DE981154C301C0558972F241666")
    protected  FromParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.511 -0400", hash_original_method = "090BCBCCA2A0D46A805C56D0690187FF", hash_generated_method = "63692B7CFEFFF2645F37C539CD0DADBB")
    public SIPHeader parse() throws ParseException {
        From from = new From();
        this.lexer.match(TokenTypes.FROM);
        this.lexer.SPorHT();
        this.lexer.match(':');
        this.lexer.SPorHT();
        super.parse(from);
        this.lexer.match('\n');
SIPHeader var48A496C0AD319E4CFD66279C8D5D42FE_208373002 =         from;
        var48A496C0AD319E4CFD66279C8D5D42FE_208373002.addTaint(taint);
        return var48A496C0AD319E4CFD66279C8D5D42FE_208373002;
        
        
        
        
        
        
        
        
        
    }

    
}

