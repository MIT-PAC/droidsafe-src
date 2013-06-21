package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.ExtensionHeader;
import gov.nist.javax.sip.header.SIPHeader;

public class PPreferredService extends SIPHeader implements PPreferredServiceHeader, SIPHeaderNamesIms, ExtensionHeader {
    private String subServiceIds;
    private String subAppIds;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.598 -0400", hash_original_method = "2FB8EC7339BBF3197572778DF84B2394", hash_generated_method = "EA48F4F198FEE1BF1DCE3F9C76738C64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected PPreferredService(String name) {
        super(NAME);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.598 -0400", hash_original_method = "80DD74DB52B5BA3BF0297E04ECC509FE", hash_generated_method = "8906F3091D6728D0A2DF3027DBEFD55A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PPreferredService() {
        super(P_PREFERRED_SERVICE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.598 -0400", hash_original_method = "13CD5B55BBBCA0548D99A959291FFE7D", hash_generated_method = "13A24A3F95F39052DBA8011D2F6C624D")
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
        String var0F1F65BA89BF920BA1A29FC87F91B969_2070656213 = (retval.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.598 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "3173C219DBD7EAE475390DAFD6FD461B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setValue(String value) throws ParseException {
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.598 -0400", hash_original_method = "C9711D50FDDAB1BC6FA9D8BEA3306598", hash_generated_method = "CEF61C29E7B9D75625647D1F36AA1ADB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getApplicationIdentifiers() {
        {
            boolean varC8D3650830D08C4D23073ADEABCF9ED5_1821478865 = (this.subAppIds.charAt(0)=='.');
            {
                String varAC9F7930D5F5D488E39E51862562FE6B_85236969 = (this.subAppIds.substring(1));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.599 -0400", hash_original_method = "A7D1F6103283AF549702A3BD8A97DA85", hash_generated_method = "777FC12A7009FC5CCB31070D400EE859")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSubserviceIdentifiers() {
        {
            boolean varAD698E105D8BEA98C5698AFC53CE6A02_761884173 = (this.subServiceIds.charAt(0)=='.');
            {
                String var1997EA3D8ECA4E6B84D28F90DF1B1EFB_406214077 = (this.subServiceIds.substring(1));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.599 -0400", hash_original_method = "0A65ED1D7958A8DC93D54B9D5172FB86", hash_generated_method = "930FEAFB3416D7A1B7F11C65A6533AD0")
    @DSModeled(DSC.SAFE)
    public void setApplicationIdentifiers(String appids) {
        dsTaint.addTaint(appids);
        // ---------- Original Method ----------
        //this.subAppIds = appids;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.599 -0400", hash_original_method = "86174BD2B9F1F7BE8C26F06288A88EF6", hash_generated_method = "88C9F5E79A6A21ACC02176B71A7579D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSubserviceIdentifiers(String subservices) {
        dsTaint.addTaint(subservices);
        this.subServiceIds = ".".concat(subservices);
        // ---------- Original Method ----------
        //this.subServiceIds = ".".concat(subservices);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.599 -0400", hash_original_method = "C4B8C9C88189BDF3DAB8E362AE1162B5", hash_generated_method = "5CD937761C169A50A2707654023C80FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        boolean var9B85CAC857C9D64CB6CF9C0273C2B2D2_1587595593 = ((other instanceof PPreferredServiceHeader) && super.equals(other));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (other instanceof PPreferredServiceHeader) && super.equals(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.599 -0400", hash_original_method = "924DF1F04CF6C30DB3A78FE0D39487E9", hash_generated_method = "9CA600D982697C2E42375A042C149972")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        PPreferredService retval;
        retval = (PPreferredService) super.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PPreferredService retval = (PPreferredService) super.clone();
        //return retval;
    }

    
}

