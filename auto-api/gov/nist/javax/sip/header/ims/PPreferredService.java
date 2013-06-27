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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.325 -0400", hash_original_field = "34C97D9F858DE85BE5E1A29DBACD860B", hash_generated_field = "8B30B176BF34BEC26AF3F3FDA86A1827")

    private String subServiceIds;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.328 -0400", hash_original_field = "1836D1911B2C516403BCBD2A0A20CDCC", hash_generated_field = "7976ED8892ABC041E4713F4D251EC3B6")

    private String subAppIds;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.328 -0400", hash_original_method = "2FB8EC7339BBF3197572778DF84B2394", hash_generated_method = "FCCB9A4D9BB589A3DB266620467C2216")
    protected  PPreferredService(String name) {
        super(NAME);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.328 -0400", hash_original_method = "80DD74DB52B5BA3BF0297E04ECC509FE", hash_generated_method = "8906F3091D6728D0A2DF3027DBEFD55A")
    public  PPreferredService() {
        super(P_PREFERRED_SERVICE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.336 -0400", hash_original_method = "13CD5B55BBBCA0548D99A959291FFE7D", hash_generated_method = "22AD973C5560D3CD453FD4658E6B71BD")
    @Override
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1581459523 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1581459523 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1581459523.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1581459523;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.345 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.347 -0400", hash_original_method = "C9711D50FDDAB1BC6FA9D8BEA3306598", hash_generated_method = "6C394343B1B7E1DA9DF22B581CF25CB5")
    public String getApplicationIdentifiers() {
        String varB4EAC82CA7396A68D541C85D26508E83_1749579324 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2017099597 = null; //Variable for return #2
        {
            boolean varC8D3650830D08C4D23073ADEABCF9ED5_800963726 = (this.subAppIds.charAt(0)=='.');
            {
                varB4EAC82CA7396A68D541C85D26508E83_1749579324 = this.subAppIds.substring(1);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2017099597 = this.subAppIds;
        String varA7E53CE21691AB073D9660D615818899_518074663; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_518074663 = varB4EAC82CA7396A68D541C85D26508E83_1749579324;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_518074663 = varB4EAC82CA7396A68D541C85D26508E83_2017099597;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_518074663.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_518074663;
        // ---------- Original Method ----------
        //if(this.subAppIds.charAt(0)=='.')
        //{
            //return this.subAppIds.substring(1);
        //}
        //return this.subAppIds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.350 -0400", hash_original_method = "A7D1F6103283AF549702A3BD8A97DA85", hash_generated_method = "4A0CE0B3D644972C8B6AB162E06E2196")
    public String getSubserviceIdentifiers() {
        String varB4EAC82CA7396A68D541C85D26508E83_922262504 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_895471837 = null; //Variable for return #2
        {
            boolean varAD698E105D8BEA98C5698AFC53CE6A02_2013174222 = (this.subServiceIds.charAt(0)=='.');
            {
                varB4EAC82CA7396A68D541C85D26508E83_922262504 = this.subServiceIds.substring(1);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_895471837 = this.subServiceIds;
        String varA7E53CE21691AB073D9660D615818899_519066171; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_519066171 = varB4EAC82CA7396A68D541C85D26508E83_922262504;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_519066171 = varB4EAC82CA7396A68D541C85D26508E83_895471837;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_519066171.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_519066171;
        // ---------- Original Method ----------
        //if(this.subServiceIds.charAt(0)=='.')
        //{
            //return this.subServiceIds.substring(1);
        //}
        //return this.subServiceIds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.350 -0400", hash_original_method = "0A65ED1D7958A8DC93D54B9D5172FB86", hash_generated_method = "813392CF39A94B938B1B3C7E12E815AD")
    public void setApplicationIdentifiers(String appids) {
        this.subAppIds = appids;
        // ---------- Original Method ----------
        //this.subAppIds = appids;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.360 -0400", hash_original_method = "86174BD2B9F1F7BE8C26F06288A88EF6", hash_generated_method = "B3E4B360308281668CC193B4B051E180")
    public void setSubserviceIdentifiers(String subservices) {
        this.subServiceIds = ".".concat(subservices);
        // ---------- Original Method ----------
        //this.subServiceIds = ".".concat(subservices);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.364 -0400", hash_original_method = "C4B8C9C88189BDF3DAB8E362AE1162B5", hash_generated_method = "C71FE939E242B53D8F078E357D755189")
    public boolean equals(Object other) {
        boolean var9B85CAC857C9D64CB6CF9C0273C2B2D2_384633245 = ((other instanceof PPreferredServiceHeader) && super.equals(other));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2040611332 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2040611332;
        // ---------- Original Method ----------
        //return (other instanceof PPreferredServiceHeader) && super.equals(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.373 -0400", hash_original_method = "924DF1F04CF6C30DB3A78FE0D39487E9", hash_generated_method = "3612A32673BB33E601B580743441B6A8")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1384913096 = null; //Variable for return #1
        PPreferredService retval;
        retval = (PPreferredService) super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1384913096 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1384913096.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1384913096;
        // ---------- Original Method ----------
        //PPreferredService retval = (PPreferredService) super.clone();
        //return retval;
    }

    
}

