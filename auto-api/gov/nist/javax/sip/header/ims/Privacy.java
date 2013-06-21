package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.ExtensionHeader;
import javax.sip.header.Parameters;
import gov.nist.core.NameValueList;
import gov.nist.javax.sip.header.SIPHeader;

public class Privacy extends SIPHeader implements PrivacyHeader, SIPHeaderNamesIms, ExtensionHeader {
    private String privacy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.637 -0400", hash_original_method = "A1E2C85381DFB17E59FB5DEA35C141AD", hash_generated_method = "F41CC28F77299CAB879B24173C4441D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Privacy() {
        super(PRIVACY);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.637 -0400", hash_original_method = "B120CF39D581439EB005580774DE8E96", hash_generated_method = "9408FD3AC357C1DFCAA73BB18E494891")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Privacy(String privacy) {
        this();
        dsTaint.addTaint(privacy);
        // ---------- Original Method ----------
        //this.privacy = privacy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.637 -0400", hash_original_method = "C66B8514DBF734E1693DCAFADDDE494C", hash_generated_method = "AADDF8F242322B5E01EA4933EAA40E4E")
    @DSModeled(DSC.SAFE)
    public String encodeBody() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.privacy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.637 -0400", hash_original_method = "1BCFC01DA9502F608C910A07D4A75A00", hash_generated_method = "10A3C4458E501F8D718CE8E03828C85D")
    @DSModeled(DSC.SAFE)
    public String getPrivacy() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return privacy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.637 -0400", hash_original_method = "B856482BE8E8039B726BD615DE62F5D9", hash_generated_method = "4CE46F25FBFB3070E88380659D6BB25F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPrivacy(String privacy) throws ParseException {
        dsTaint.addTaint(privacy);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + " Privacy, setPrivacy(), privacy value is null or empty");
        // ---------- Original Method ----------
        //if (privacy == null || privacy == "")
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ " Privacy, setPrivacy(), privacy value is null or empty");
        //this.privacy = privacy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.637 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "3173C219DBD7EAE475390DAFD6FD461B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setValue(String value) throws ParseException {
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.638 -0400", hash_original_method = "DB811FF594B6D6915B4D573130CCABF1", hash_generated_method = "BB5ECEDAE0A025F98D061343B51DF635")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            PrivacyHeader o;
            o = (PrivacyHeader) other;
            boolean var47FB8379C8E04B5D2A75854AD895B4C3_62820531 = ((this.getPrivacy().equals( o.getPrivacy() )));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (other instanceof PrivacyHeader)
        //{
            //PrivacyHeader o = (PrivacyHeader) other;
            //return (this.getPrivacy().equals( o.getPrivacy() ));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.638 -0400", hash_original_method = "6120A3F29636BB071828910A14D394C6", hash_generated_method = "1B708805E28BDBC49FD6AA9F46114725")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        Privacy retval;
        retval = (Privacy) super.clone();
        retval.privacy = this.privacy;
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Privacy retval = (Privacy) super.clone();
        //if (this.privacy != null)
            //retval.privacy = this.privacy;
        //return retval;
    }

    
}

