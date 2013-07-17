package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

public class OrganizationParser extends HeaderParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.908 -0400", hash_original_method = "549F69CADB3AF439FF99C26DCF97EF61", hash_generated_method = "6170B9428B77266BA6E655AF7ACBDA03")
    public  OrganizationParser(String organization) {
        super(organization);
        addTaint(organization.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.908 -0400", hash_original_method = "5407EA6CAC142FB29C8ECABB6BAE3B2C", hash_generated_method = "30C64867BC39878E46F7846B11CA9D04")
    protected  OrganizationParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:37.909 -0400", hash_original_method = "FCDFEF7484AB928FBE1CF6D95D3DCFBA", hash_generated_method = "9B9C7D5E992E9471AAFCCFA7A394877C")
    public SIPHeader parse() throws ParseException {
        if(debug)        
        dbg_enter("OrganizationParser.parse");
        Organization organization = new Organization();
        try 
        {
            headerName(TokenTypes.ORGANIZATION);
            organization.setHeaderName(SIPHeaderNames.ORGANIZATION);
            this.lexer.SPorHT();
            String value = this.lexer.getRest();
            organization.setOrganization(value.trim());
SIPHeader var86B932A706B81240694A9B2D316B40FE_934013448 =             organization;
            var86B932A706B81240694A9B2D316B40FE_934013448.addTaint(taint);
            return var86B932A706B81240694A9B2D316B40FE_934013448;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("OrganizationParser.parse");
        } //End block
        // ---------- Original Method ----------
        //if (debug)
            //dbg_enter("OrganizationParser.parse");
        //Organization organization = new Organization();
        //try {
            //headerName(TokenTypes.ORGANIZATION);
            //organization.setHeaderName(SIPHeaderNames.ORGANIZATION);
            //this.lexer.SPorHT();
            //String value = this.lexer.getRest();
            //organization.setOrganization(value.trim());
            //return organization;
        //} finally {
            //if (debug)
                //dbg_leave("OrganizationParser.parse");
        //}
    }

    
}

