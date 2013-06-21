package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

public class OrganizationParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.319 -0400", hash_original_method = "549F69CADB3AF439FF99C26DCF97EF61", hash_generated_method = "40640B540FB56A8F1AF55A28DD4CF8AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OrganizationParser(String organization) {
        super(organization);
        dsTaint.addTaint(organization);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.319 -0400", hash_original_method = "5407EA6CAC142FB29C8ECABB6BAE3B2C", hash_generated_method = "29C8838AC3B44BD164BDCA632AA847D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected OrganizationParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.319 -0400", hash_original_method = "FCDFEF7484AB928FBE1CF6D95D3DCFBA", hash_generated_method = "E737DE6FAC76F8CF243DA654F8F13886")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        dbg_enter("OrganizationParser.parse");
        Organization organization;
        organization = new Organization();
        try 
        {
            headerName(TokenTypes.ORGANIZATION);
            organization.setHeaderName(SIPHeaderNames.ORGANIZATION);
            this.lexer.SPorHT();
            String value;
            value = this.lexer.getRest();
            organization.setOrganization(value.trim());
        } //End block
        finally 
        {
            dbg_leave("OrganizationParser.parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
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

