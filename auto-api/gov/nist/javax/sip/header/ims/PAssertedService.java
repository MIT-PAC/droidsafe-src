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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.181 -0400", hash_original_field = "34C97D9F858DE85BE5E1A29DBACD860B", hash_generated_field = "8B30B176BF34BEC26AF3F3FDA86A1827")

    private String subServiceIds;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.182 -0400", hash_original_field = "1836D1911B2C516403BCBD2A0A20CDCC", hash_generated_field = "7976ED8892ABC041E4713F4D251EC3B6")

    private String subAppIds;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.182 -0400", hash_original_method = "182ECFD494AF5D51867F4CB3F9E644EB", hash_generated_method = "6A6E160BAB145753731DA292EEC0188E")
    protected  PAssertedService(String name) {
        super(NAME);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.182 -0400", hash_original_method = "AA5E567A5261831D339C7F3E134619EA", hash_generated_method = "320063B2C7D78E77D8E4F4C11712E1EC")
    public  PAssertedService() {
        super(P_ASSERTED_SERVICE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.194 -0400", hash_original_method = "13CD5B55BBBCA0548D99A959291FFE7D", hash_generated_method = "71C1F54B4F0141BE9D325BA1184E37BE")
    @Override
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_970743108 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_970743108 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_970743108.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_970743108;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.195 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.201 -0400", hash_original_method = "C9711D50FDDAB1BC6FA9D8BEA3306598", hash_generated_method = "25B44E2B8D6CF8C8FFD63A926F78E6C1")
    public String getApplicationIdentifiers() {
        String varB4EAC82CA7396A68D541C85D26508E83_1894894146 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2067243931 = null; //Variable for return #2
        {
            boolean varC8D3650830D08C4D23073ADEABCF9ED5_1991871978 = (this.subAppIds.charAt(0)=='.');
            {
                varB4EAC82CA7396A68D541C85D26508E83_1894894146 = this.subAppIds.substring(1);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2067243931 = this.subAppIds;
        String varA7E53CE21691AB073D9660D615818899_1467875538; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1467875538 = varB4EAC82CA7396A68D541C85D26508E83_1894894146;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1467875538 = varB4EAC82CA7396A68D541C85D26508E83_2067243931;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1467875538.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1467875538;
        // ---------- Original Method ----------
        //if(this.subAppIds.charAt(0)=='.')
        //{
            //return this.subAppIds.substring(1);
        //}
        //return this.subAppIds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.201 -0400", hash_original_method = "A7D1F6103283AF549702A3BD8A97DA85", hash_generated_method = "AC1FE68603999CA1FE4934C9856235C5")
    public String getSubserviceIdentifiers() {
        String varB4EAC82CA7396A68D541C85D26508E83_215312370 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_974395685 = null; //Variable for return #2
        {
            boolean varAD698E105D8BEA98C5698AFC53CE6A02_503302578 = (this.subServiceIds.charAt(0)=='.');
            {
                varB4EAC82CA7396A68D541C85D26508E83_215312370 = this.subServiceIds.substring(1);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_974395685 = this.subServiceIds;
        String varA7E53CE21691AB073D9660D615818899_889293361; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_889293361 = varB4EAC82CA7396A68D541C85D26508E83_215312370;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_889293361 = varB4EAC82CA7396A68D541C85D26508E83_974395685;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_889293361.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_889293361;
        // ---------- Original Method ----------
        //if(this.subServiceIds.charAt(0)=='.')
        //{
            //return this.subServiceIds.substring(1);
        //}
        //return this.subServiceIds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.202 -0400", hash_original_method = "0A65ED1D7958A8DC93D54B9D5172FB86", hash_generated_method = "813392CF39A94B938B1B3C7E12E815AD")
    public void setApplicationIdentifiers(String appids) {
        this.subAppIds = appids;
        // ---------- Original Method ----------
        //this.subAppIds = appids;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.211 -0400", hash_original_method = "D85C3DD3D271FDFF4F350559A8282CAD", hash_generated_method = "408F5C6315DFA9E24D9CFBD7DDC9F713")
    public void setSubserviceIdentifiers(String subservices) {
        this.subServiceIds = subservices;
        // ---------- Original Method ----------
        //this.subServiceIds = subservices;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.211 -0400", hash_original_method = "698565353F33C32BACB06EBECCB2189D", hash_generated_method = "E1A0E12A6923E7DD59D847421E9DD9E3")
    public boolean equals(Object other) {
        boolean varACB9572725C3D0BB03C5FDEA37D02E09_437793378 = ((other instanceof PAssertedServiceHeader) && super.equals(other));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2045698894 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2045698894;
        // ---------- Original Method ----------
        //return (other instanceof PAssertedServiceHeader) && super.equals(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.212 -0400", hash_original_method = "3CDC6738E06A7AFD0A34818FC063034A", hash_generated_method = "FDAEEA77517C464F712EBE0F7695F030")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1199183680 = null; //Variable for return #1
        PAssertedService retval;
        retval = (PAssertedService) super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1199183680 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1199183680.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1199183680;
        // ---------- Original Method ----------
        //PAssertedService retval = (PAssertedService) super.clone();
        //return retval;
    }

    
}

