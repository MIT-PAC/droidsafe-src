package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import gov.nist.javax.sip.header.SIPHeader;
import javax.sip.header.ExtensionHeader;

public class PAssertedService extends SIPHeader implements PAssertedServiceHeader, SIPHeaderNamesIms, ExtensionHeader {
    private String subServiceIds;
    private String subAppIds;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.548 -0400", hash_original_method = "182ECFD494AF5D51867F4CB3F9E644EB", hash_generated_method = "F6340509EA68F9A6AA439051DA1EFC0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected PAssertedService(String name) {
        super(NAME);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.548 -0400", hash_original_method = "AA5E567A5261831D339C7F3E134619EA", hash_generated_method = "320063B2C7D78E77D8E4F4C11712E1EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PAssertedService() {
        super(P_ASSERTED_SERVICE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.548 -0400", hash_original_method = "13CD5B55BBBCA0548D99A959291FFE7D", hash_generated_method = "81B3D7DE731F627E34015D04238249CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected String encodeBody() {
        StringBuffer retval;
        retval = new StringBuffer();
        retval.append(ParameterNamesIms.SERVICE_ID);
        {
            retval.append(ParameterNamesIms.SERVICE_ID_LABEL).append(".");
            retval.append(this.getSubserviceIdentifiers());
        } //End block
        {
            retval.append(ParameterNamesIms.APPLICATION_ID_LABEL).append(".");
            retval.append(this.getApplicationIdentifiers());
        } //End block
        String var0F1F65BA89BF920BA1A29FC87F91B969_316070924 = (retval.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuffer retval = new StringBuffer();
        //retval.append(ParameterNamesIms.SERVICE_ID);
        //if(this.subServiceIds!=null)
            //{
                //retval.append(ParameterNamesIms.SERVICE_ID_LABEL).append(".");
            //retval.append(this.getSubserviceIdentifiers());
            //}
            //else if(this.subAppIds!=null)
            //{
                //retval.append(ParameterNamesIms.APPLICATION_ID_LABEL).append(".");
                //retval.append(this.getApplicationIdentifiers());
            //}
        //return retval.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.548 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "3173C219DBD7EAE475390DAFD6FD461B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setValue(String value) throws ParseException {
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.548 -0400", hash_original_method = "C9711D50FDDAB1BC6FA9D8BEA3306598", hash_generated_method = "9F61255A107D13F03FCE44D74B0D30AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getApplicationIdentifiers() {
        {
            boolean varC8D3650830D08C4D23073ADEABCF9ED5_1068731377 = (this.subAppIds.charAt(0)=='.');
            {
                String varAC9F7930D5F5D488E39E51862562FE6B_40984195 = (this.subAppIds.substring(1));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if(this.subAppIds.charAt(0)=='.')
        //{
            //return this.subAppIds.substring(1);
        //}
        //return this.subAppIds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.549 -0400", hash_original_method = "A7D1F6103283AF549702A3BD8A97DA85", hash_generated_method = "09701098F4E5EEE90C35D835828034A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSubserviceIdentifiers() {
        {
            boolean varAD698E105D8BEA98C5698AFC53CE6A02_1396513369 = (this.subServiceIds.charAt(0)=='.');
            {
                String var1997EA3D8ECA4E6B84D28F90DF1B1EFB_457477466 = (this.subServiceIds.substring(1));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if(this.subServiceIds.charAt(0)=='.')
        //{
            //return this.subServiceIds.substring(1);
        //}
        //return this.subServiceIds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.549 -0400", hash_original_method = "0A65ED1D7958A8DC93D54B9D5172FB86", hash_generated_method = "930FEAFB3416D7A1B7F11C65A6533AD0")
    @DSModeled(DSC.SAFE)
    public void setApplicationIdentifiers(String appids) {
        dsTaint.addTaint(appids);
        // ---------- Original Method ----------
        //this.subAppIds = appids;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.549 -0400", hash_original_method = "D85C3DD3D271FDFF4F350559A8282CAD", hash_generated_method = "98A91DF46F15573D887BF0F1661A4272")
    @DSModeled(DSC.SAFE)
    public void setSubserviceIdentifiers(String subservices) {
        dsTaint.addTaint(subservices);
        // ---------- Original Method ----------
        //this.subServiceIds = subservices;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.549 -0400", hash_original_method = "698565353F33C32BACB06EBECCB2189D", hash_generated_method = "949AAE46DD6177B7BEAFEDBCEFBBC128")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        boolean varACB9572725C3D0BB03C5FDEA37D02E09_71020701 = ((other instanceof PAssertedServiceHeader) && super.equals(other));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (other instanceof PAssertedServiceHeader) && super.equals(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.549 -0400", hash_original_method = "3CDC6738E06A7AFD0A34818FC063034A", hash_generated_method = "3270096429C859ECD9B9D56694591DD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        PAssertedService retval;
        retval = (PAssertedService) super.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PAssertedService retval = (PAssertedService) super.clone();
        //return retval;
    }

    
}

