package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.header.OrganizationHeader;






public class Organization extends SIPHeader implements OrganizationHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.613 -0400", hash_original_field = "B4C1948C087FAFC89A88450FCBB64C77", hash_generated_field = "7B6519A46F5BF8862075151D042F1E20")

    protected String organization;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.613 -0400", hash_original_method = "A22A45BA0A2B2678454705CA5BB968BD", hash_generated_method = "77544CC18B49DD4CBC9F054FA924E69C")
    public  Organization() {
        super(ORGANIZATION);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.613 -0400", hash_original_method = "64094CFB244C647C5657F3E488B1D7D6", hash_generated_method = "FD20A299C6FF7602A4E30034AFDD0662")
    public String encodeBody() {
String var86B932A706B81240694A9B2D316B40FE_2035440169 =         organization;
        var86B932A706B81240694A9B2D316B40FE_2035440169.addTaint(taint);
        return var86B932A706B81240694A9B2D316B40FE_2035440169;
        // ---------- Original Method ----------
        //return organization;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.614 -0400", hash_original_method = "9435FCCFD7C054307D934681F7070D26", hash_generated_method = "0FAE80E51ACFD867B774FE9CBD9DA43F")
    public String getOrganization() {
String var86B932A706B81240694A9B2D316B40FE_1947973207 =         organization;
        var86B932A706B81240694A9B2D316B40FE_1947973207.addTaint(taint);
        return var86B932A706B81240694A9B2D316B40FE_1947973207;
        // ---------- Original Method ----------
        //return organization;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.614 -0400", hash_original_method = "525AB078049049253D355424AD5A3E65", hash_generated_method = "57A0521248BC9414C73D1DC174CB43C1")
    public void setOrganization(String o) throws ParseException {
        if(o == null)        
        {
        NullPointerException var1C649641E447788F72462AC460039BB1_1236106549 = new NullPointerException(
                "JAIN-SIP Exception,"
                    + " Organization, setOrganization(), the organization parameter is null");
        var1C649641E447788F72462AC460039BB1_1236106549.addTaint(taint);
        throw var1C649641E447788F72462AC460039BB1_1236106549;
        }
        organization = o;
        // ---------- Original Method ----------
        //if (o == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception,"
                    //+ " Organization, setOrganization(), the organization parameter is null");
        //organization = o;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.614 -0400", hash_original_field = "4141766911F0F3B58A3082026A876C2C", hash_generated_field = "BF1069295545422BFA1A0647DDAC00E1")

    private static final long serialVersionUID = -2775003113740192712L;
}

