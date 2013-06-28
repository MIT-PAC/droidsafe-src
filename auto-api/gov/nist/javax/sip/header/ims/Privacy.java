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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.463 -0400", hash_original_field = "21CEC257FEB15BCC84E0ACD5B0773883", hash_generated_field = "66940D25B8669AE19E240042C82974B1")

    private String privacy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.464 -0400", hash_original_method = "A1E2C85381DFB17E59FB5DEA35C141AD", hash_generated_method = "F41CC28F77299CAB879B24173C4441D3")
    public  Privacy() {
        super(PRIVACY);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.464 -0400", hash_original_method = "B120CF39D581439EB005580774DE8E96", hash_generated_method = "70A02CA92965B26C83EFFD5CBEE38258")
    public  Privacy(String privacy) {
        this();
        this.privacy = privacy;
        // ---------- Original Method ----------
        //this.privacy = privacy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.465 -0400", hash_original_method = "C66B8514DBF734E1693DCAFADDDE494C", hash_generated_method = "4EA1C004BE5279516F96420C7CAF3A76")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_613717358 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_613717358 = this.privacy;
        varB4EAC82CA7396A68D541C85D26508E83_613717358.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_613717358;
        // ---------- Original Method ----------
        //return this.privacy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.465 -0400", hash_original_method = "1BCFC01DA9502F608C910A07D4A75A00", hash_generated_method = "DA1ACB660FF6479A6D057FD136AC9A85")
    public String getPrivacy() {
        String varB4EAC82CA7396A68D541C85D26508E83_1280528763 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1280528763 = privacy;
        varB4EAC82CA7396A68D541C85D26508E83_1280528763.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1280528763;
        // ---------- Original Method ----------
        //return privacy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.466 -0400", hash_original_method = "B856482BE8E8039B726BD615DE62F5D9", hash_generated_method = "712562FB1BF0891CCA1942A7170EC860")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.466 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.466 -0400", hash_original_method = "DB811FF594B6D6915B4D573130CCABF1", hash_generated_method = "36B703BE07EC8A9580061EC2AC88BAAC")
    public boolean equals(Object other) {
        {
            PrivacyHeader o = (PrivacyHeader) other;
            boolean var47FB8379C8E04B5D2A75854AD895B4C3_744062272 = ((this.getPrivacy().equals( o.getPrivacy() )));
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_452433370 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_452433370;
        // ---------- Original Method ----------
        //if (other instanceof PrivacyHeader)
        //{
            //PrivacyHeader o = (PrivacyHeader) other;
            //return (this.getPrivacy().equals( o.getPrivacy() ));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.467 -0400", hash_original_method = "6120A3F29636BB071828910A14D394C6", hash_generated_method = "0D2E209AB09417F29E617CFFD35C4228")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_560795724 = null; //Variable for return #1
        Privacy retval = (Privacy) super.clone();
        retval.privacy = this.privacy;
        varB4EAC82CA7396A68D541C85D26508E83_560795724 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_560795724.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_560795724;
        // ---------- Original Method ----------
        //Privacy retval = (Privacy) super.clone();
        //if (this.privacy != null)
            //retval.privacy = this.privacy;
        //return retval;
    }

    
}

