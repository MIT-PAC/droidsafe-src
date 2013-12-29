package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;

import javax.sip.header.ExtensionHeader;






public class Privacy extends SIPHeader implements PrivacyHeader, SIPHeaderNamesIms, ExtensionHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:51.623 -0500", hash_original_field = "51A99DF462F4D5940029DD161277ECD8", hash_generated_field = "66940D25B8669AE19E240042C82974B1")

    private String privacy;


    /**
     * Default constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:51.624 -0500", hash_original_method = "A1E2C85381DFB17E59FB5DEA35C141AD", hash_generated_method = "01ED2EC6F46120598F832753E092D125")
    public Privacy() {
        super(PRIVACY);
    }

    /**
     * Constructor given a privacy type
     *@param privacy
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:51.625 -0500", hash_original_method = "B120CF39D581439EB005580774DE8E96", hash_generated_method = "61A48D22FF0FBAAC8D306C015904822F")
    public Privacy(String privacy)
    {
        this();
        this.privacy = privacy;

    }


    /**
     * Encode into a canonical string.
     * @return String.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:51.626 -0500", hash_original_method = "C66B8514DBF734E1693DCAFADDDE494C", hash_generated_method = "A676E7B94E7A1D16D3D9DF2FED8715D4")
    public String encodeBody()
    {
        return this.privacy;
    }



    /**
     * Get privacy type
     * @return privacy type
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:51.627 -0500", hash_original_method = "1BCFC01DA9502F608C910A07D4A75A00", hash_generated_method = "6E0D8104C1D1B7065C7E83F581681107")
    public String getPrivacy()
    {
        return privacy;
    }



    /**
     * set the privacy type.
     * @param  privacy -- privacy type to set.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:51.629 -0500", hash_original_method = "B856482BE8E8039B726BD615DE62F5D9", hash_generated_method = "21AD8F075113A0B5F1CE0125ECCE2AC8")
    public void setPrivacy(String privacy) throws ParseException
    {

        if (privacy == null || privacy == "")
            throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + " Privacy, setPrivacy(), privacy value is null or empty");
        this.privacy = privacy;

    }

    /**
     * Suppress direct setting of values.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:51.630 -0500", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "014FE50D8A9A4F50DCF1C9E31F934432")
    public void setValue(String value) throws ParseException {
        throw new ParseException(value,0);

    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:51.632 -0500", hash_original_method = "DB811FF594B6D6915B4D573130CCABF1", hash_generated_method = "A3AF03FBE5AA62638055EB48FDED9C46")
    public boolean equals(Object other)
    {
        if (other instanceof PrivacyHeader)
        {
            PrivacyHeader o = (PrivacyHeader) other;
            return (this.getPrivacy().equals( o.getPrivacy() ));
        }
        return false;

    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:51.633 -0500", hash_original_method = "6120A3F29636BB071828910A14D394C6", hash_generated_method = "7D313FDD72B1477DC95BBDE8BB9B13E4")
    public Object clone() {
        Privacy retval = (Privacy) super.clone();
        if (this.privacy != null)
            retval.privacy = this.privacy;
        return retval;
    }

    
}

