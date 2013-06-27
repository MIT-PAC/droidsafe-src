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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.318 -0400", hash_original_field = "34C97D9F858DE85BE5E1A29DBACD860B", hash_generated_field = "8B30B176BF34BEC26AF3F3FDA86A1827")

    private String subServiceIds;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.318 -0400", hash_original_field = "1836D1911B2C516403BCBD2A0A20CDCC", hash_generated_field = "7976ED8892ABC041E4713F4D251EC3B6")

    private String subAppIds;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.334 -0400", hash_original_method = "182ECFD494AF5D51867F4CB3F9E644EB", hash_generated_method = "6A6E160BAB145753731DA292EEC0188E")
    protected  PAssertedService(String name) {
        super(NAME);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.334 -0400", hash_original_method = "AA5E567A5261831D339C7F3E134619EA", hash_generated_method = "320063B2C7D78E77D8E4F4C11712E1EC")
    public  PAssertedService() {
        super(P_ASSERTED_SERVICE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.337 -0400", hash_original_method = "13CD5B55BBBCA0548D99A959291FFE7D", hash_generated_method = "8AEE23E1259581B74A32DF4B74F4D4DC")
    @Override
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1793132312 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1793132312 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1793132312.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1793132312;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.337 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.338 -0400", hash_original_method = "C9711D50FDDAB1BC6FA9D8BEA3306598", hash_generated_method = "80566A01EF14BC5B40F446AE749530DE")
    public String getApplicationIdentifiers() {
        String varB4EAC82CA7396A68D541C85D26508E83_974830192 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_569532836 = null; //Variable for return #2
        {
            boolean varC8D3650830D08C4D23073ADEABCF9ED5_1531136108 = (this.subAppIds.charAt(0)=='.');
            {
                varB4EAC82CA7396A68D541C85D26508E83_974830192 = this.subAppIds.substring(1);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_569532836 = this.subAppIds;
        String varA7E53CE21691AB073D9660D615818899_480057836; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_480057836 = varB4EAC82CA7396A68D541C85D26508E83_974830192;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_480057836 = varB4EAC82CA7396A68D541C85D26508E83_569532836;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_480057836.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_480057836;
        // ---------- Original Method ----------
        //if(this.subAppIds.charAt(0)=='.')
        //{
            //return this.subAppIds.substring(1);
        //}
        //return this.subAppIds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.353 -0400", hash_original_method = "A7D1F6103283AF549702A3BD8A97DA85", hash_generated_method = "7FDB694D891EBCBBB6DE22F666D55B18")
    public String getSubserviceIdentifiers() {
        String varB4EAC82CA7396A68D541C85D26508E83_1067431705 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_767016925 = null; //Variable for return #2
        {
            boolean varAD698E105D8BEA98C5698AFC53CE6A02_119929547 = (this.subServiceIds.charAt(0)=='.');
            {
                varB4EAC82CA7396A68D541C85D26508E83_1067431705 = this.subServiceIds.substring(1);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_767016925 = this.subServiceIds;
        String varA7E53CE21691AB073D9660D615818899_1576829299; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1576829299 = varB4EAC82CA7396A68D541C85D26508E83_1067431705;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1576829299 = varB4EAC82CA7396A68D541C85D26508E83_767016925;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1576829299.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1576829299;
        // ---------- Original Method ----------
        //if(this.subServiceIds.charAt(0)=='.')
        //{
            //return this.subServiceIds.substring(1);
        //}
        //return this.subServiceIds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.354 -0400", hash_original_method = "0A65ED1D7958A8DC93D54B9D5172FB86", hash_generated_method = "813392CF39A94B938B1B3C7E12E815AD")
    public void setApplicationIdentifiers(String appids) {
        this.subAppIds = appids;
        // ---------- Original Method ----------
        //this.subAppIds = appids;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.355 -0400", hash_original_method = "D85C3DD3D271FDFF4F350559A8282CAD", hash_generated_method = "408F5C6315DFA9E24D9CFBD7DDC9F713")
    public void setSubserviceIdentifiers(String subservices) {
        this.subServiceIds = subservices;
        // ---------- Original Method ----------
        //this.subServiceIds = subservices;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.355 -0400", hash_original_method = "698565353F33C32BACB06EBECCB2189D", hash_generated_method = "E25B1590884B5D1B26FF01B76C712B95")
    public boolean equals(Object other) {
        boolean varACB9572725C3D0BB03C5FDEA37D02E09_1324542298 = ((other instanceof PAssertedServiceHeader) && super.equals(other));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1400806899 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1400806899;
        // ---------- Original Method ----------
        //return (other instanceof PAssertedServiceHeader) && super.equals(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.356 -0400", hash_original_method = "3CDC6738E06A7AFD0A34818FC063034A", hash_generated_method = "C3A5E0E3E8F3F2EA10BCC6849CFDD11E")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1050802956 = null; //Variable for return #1
        PAssertedService retval;
        retval = (PAssertedService) super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1050802956 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1050802956.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1050802956;
        // ---------- Original Method ----------
        //PAssertedService retval = (PAssertedService) super.clone();
        //return retval;
    }

    
}

