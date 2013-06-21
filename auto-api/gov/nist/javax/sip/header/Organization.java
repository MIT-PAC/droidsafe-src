package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.*;

public class Organization extends SIPHeader implements OrganizationHeader {
    protected String organization;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.038 -0400", hash_original_method = "A22A45BA0A2B2678454705CA5BB968BD", hash_generated_method = "77544CC18B49DD4CBC9F054FA924E69C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Organization() {
        super(ORGANIZATION);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.038 -0400", hash_original_method = "64094CFB244C647C5657F3E488B1D7D6", hash_generated_method = "DC149B0DEF82067E42C69EB803415055")
    @DSModeled(DSC.SAFE)
    public String encodeBody() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return organization;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.038 -0400", hash_original_method = "9435FCCFD7C054307D934681F7070D26", hash_generated_method = "0A8FE41E12D099B8712506FF90F6D291")
    @DSModeled(DSC.SAFE)
    public String getOrganization() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return organization;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.038 -0400", hash_original_method = "525AB078049049253D355424AD5A3E65", hash_generated_method = "C1DD25AEBB4E2BE4803F6C0113715B06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOrganization(String o) throws ParseException {
        dsTaint.addTaint(o);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception,"
                    + " Organization, setOrganization(), the organization parameter is null");
        // ---------- Original Method ----------
        //if (o == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception,"
                    //+ " Organization, setOrganization(), the organization parameter is null");
        //organization = o;
    }

    
    private static final long serialVersionUID = -2775003113740192712L;
}

