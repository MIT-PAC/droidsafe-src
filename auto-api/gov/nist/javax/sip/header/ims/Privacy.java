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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.587 -0400", hash_original_field = "21CEC257FEB15BCC84E0ACD5B0773883", hash_generated_field = "66940D25B8669AE19E240042C82974B1")

    private String privacy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.588 -0400", hash_original_method = "A1E2C85381DFB17E59FB5DEA35C141AD", hash_generated_method = "F41CC28F77299CAB879B24173C4441D3")
    public  Privacy() {
        super(PRIVACY);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.588 -0400", hash_original_method = "B120CF39D581439EB005580774DE8E96", hash_generated_method = "70A02CA92965B26C83EFFD5CBEE38258")
    public  Privacy(String privacy) {
        this();
        this.privacy = privacy;
        // ---------- Original Method ----------
        //this.privacy = privacy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.592 -0400", hash_original_method = "C66B8514DBF734E1693DCAFADDDE494C", hash_generated_method = "7BCB2DEF289764610D749C4A5486521F")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1875771064 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1875771064 = this.privacy;
        varB4EAC82CA7396A68D541C85D26508E83_1875771064.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1875771064;
        // ---------- Original Method ----------
        //return this.privacy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.593 -0400", hash_original_method = "1BCFC01DA9502F608C910A07D4A75A00", hash_generated_method = "DFB68C867DDD11C097FB18D7F2CFCA97")
    public String getPrivacy() {
        String varB4EAC82CA7396A68D541C85D26508E83_474083202 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_474083202 = privacy;
        varB4EAC82CA7396A68D541C85D26508E83_474083202.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_474083202;
        // ---------- Original Method ----------
        //return privacy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.597 -0400", hash_original_method = "B856482BE8E8039B726BD615DE62F5D9", hash_generated_method = "712562FB1BF0891CCA1942A7170EC860")
    public void setPrivacy(String privacy) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + " Privacy, setPrivacy(), privacy value is null or empty");
        this.privacy = privacy;
        // ---------- Original Method ----------
        //if (privacy == null || privacy == "")
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ " Privacy, setPrivacy(), privacy value is null or empty");
        //this.privacy = privacy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.599 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.611 -0400", hash_original_method = "DB811FF594B6D6915B4D573130CCABF1", hash_generated_method = "E0281AD1AA8E4E9B03F2D8F988A781A7")
    public boolean equals(Object other) {
        {
            PrivacyHeader o;
            o = (PrivacyHeader) other;
            boolean var47FB8379C8E04B5D2A75854AD895B4C3_458411644 = ((this.getPrivacy().equals( o.getPrivacy() )));
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_662103007 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_662103007;
        // ---------- Original Method ----------
        //if (other instanceof PrivacyHeader)
        //{
            //PrivacyHeader o = (PrivacyHeader) other;
            //return (this.getPrivacy().equals( o.getPrivacy() ));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.612 -0400", hash_original_method = "6120A3F29636BB071828910A14D394C6", hash_generated_method = "C1DFC688DC72BF2C94796351BA602CE7")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1831315716 = null; //Variable for return #1
        Privacy retval;
        retval = (Privacy) super.clone();
        retval.privacy = this.privacy;
        varB4EAC82CA7396A68D541C85D26508E83_1831315716 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1831315716.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1831315716;
        // ---------- Original Method ----------
        //Privacy retval = (Privacy) super.clone();
        //if (this.privacy != null)
            //retval.privacy = this.privacy;
        //return retval;
    }

    
}

