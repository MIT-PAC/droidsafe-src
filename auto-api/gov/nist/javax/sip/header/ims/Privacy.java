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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.436 -0400", hash_original_field = "21CEC257FEB15BCC84E0ACD5B0773883", hash_generated_field = "66940D25B8669AE19E240042C82974B1")

    private String privacy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.436 -0400", hash_original_method = "A1E2C85381DFB17E59FB5DEA35C141AD", hash_generated_method = "F41CC28F77299CAB879B24173C4441D3")
    public  Privacy() {
        super(PRIVACY);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.450 -0400", hash_original_method = "B120CF39D581439EB005580774DE8E96", hash_generated_method = "70A02CA92965B26C83EFFD5CBEE38258")
    public  Privacy(String privacy) {
        this();
        this.privacy = privacy;
        // ---------- Original Method ----------
        //this.privacy = privacy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.451 -0400", hash_original_method = "C66B8514DBF734E1693DCAFADDDE494C", hash_generated_method = "DA78C8C8B03C407D2693F4C1C475B541")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1179481782 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1179481782 = this.privacy;
        varB4EAC82CA7396A68D541C85D26508E83_1179481782.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1179481782;
        // ---------- Original Method ----------
        //return this.privacy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.451 -0400", hash_original_method = "1BCFC01DA9502F608C910A07D4A75A00", hash_generated_method = "EFEA98AA9C5A1D8C2E088426F623D67D")
    public String getPrivacy() {
        String varB4EAC82CA7396A68D541C85D26508E83_1136095079 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1136095079 = privacy;
        varB4EAC82CA7396A68D541C85D26508E83_1136095079.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1136095079;
        // ---------- Original Method ----------
        //return privacy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.451 -0400", hash_original_method = "B856482BE8E8039B726BD615DE62F5D9", hash_generated_method = "712562FB1BF0891CCA1942A7170EC860")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.452 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.454 -0400", hash_original_method = "DB811FF594B6D6915B4D573130CCABF1", hash_generated_method = "858B807D1D837A478A872E954BDFCBE6")
    public boolean equals(Object other) {
        {
            PrivacyHeader o;
            o = (PrivacyHeader) other;
            boolean var47FB8379C8E04B5D2A75854AD895B4C3_486398200 = ((this.getPrivacy().equals( o.getPrivacy() )));
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2145825266 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2145825266;
        // ---------- Original Method ----------
        //if (other instanceof PrivacyHeader)
        //{
            //PrivacyHeader o = (PrivacyHeader) other;
            //return (this.getPrivacy().equals( o.getPrivacy() ));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.461 -0400", hash_original_method = "6120A3F29636BB071828910A14D394C6", hash_generated_method = "565B4E86CD1E8967F8E1EBBE24082283")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1784865257 = null; //Variable for return #1
        Privacy retval;
        retval = (Privacy) super.clone();
        retval.privacy = this.privacy;
        varB4EAC82CA7396A68D541C85D26508E83_1784865257 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1784865257.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1784865257;
        // ---------- Original Method ----------
        //Privacy retval = (Privacy) super.clone();
        //if (this.privacy != null)
            //retval.privacy = this.privacy;
        //return retval;
    }

    
}

