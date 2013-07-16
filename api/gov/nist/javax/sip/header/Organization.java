package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.header.*;

public class Organization extends SIPHeader implements OrganizationHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.628 -0400", hash_original_field = "B4C1948C087FAFC89A88450FCBB64C77", hash_generated_field = "7B6519A46F5BF8862075151D042F1E20")

    protected String organization;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.628 -0400", hash_original_method = "A22A45BA0A2B2678454705CA5BB968BD", hash_generated_method = "77544CC18B49DD4CBC9F054FA924E69C")
    public  Organization() {
        super(ORGANIZATION);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.628 -0400", hash_original_method = "64094CFB244C647C5657F3E488B1D7D6", hash_generated_method = "5BEC6C1469B40E1B8FB2A1A977BD26CF")
    public String encodeBody() {
String var86B932A706B81240694A9B2D316B40FE_955607160 =         organization;
        var86B932A706B81240694A9B2D316B40FE_955607160.addTaint(taint);
        return var86B932A706B81240694A9B2D316B40FE_955607160;
        // ---------- Original Method ----------
        //return organization;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.628 -0400", hash_original_method = "9435FCCFD7C054307D934681F7070D26", hash_generated_method = "A39E0A82721F030A14D0F45DC82DD351")
    public String getOrganization() {
String var86B932A706B81240694A9B2D316B40FE_216386101 =         organization;
        var86B932A706B81240694A9B2D316B40FE_216386101.addTaint(taint);
        return var86B932A706B81240694A9B2D316B40FE_216386101;
        // ---------- Original Method ----------
        //return organization;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.629 -0400", hash_original_method = "525AB078049049253D355424AD5A3E65", hash_generated_method = "3C7656E0E91BE7D8C5938B623B0DDA48")
    public void setOrganization(String o) throws ParseException {
    if(o == null)        
        {
        NullPointerException var1C649641E447788F72462AC460039BB1_1215520972 = new NullPointerException(
                "JAIN-SIP Exception,"
                    + " Organization, setOrganization(), the organization parameter is null");
        var1C649641E447788F72462AC460039BB1_1215520972.addTaint(taint);
        throw var1C649641E447788F72462AC460039BB1_1215520972;
        }
        organization = o;
        // ---------- Original Method ----------
        //if (o == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception,"
                    //+ " Organization, setOrganization(), the organization parameter is null");
        //organization = o;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.629 -0400", hash_original_field = "4141766911F0F3B58A3082026A876C2C", hash_generated_field = "BF1069295545422BFA1A0647DDAC00E1")

    private static final long serialVersionUID = -2775003113740192712L;
}

