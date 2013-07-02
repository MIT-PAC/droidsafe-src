package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.ExtensionHeader;
import gov.nist.javax.sip.header.SIPHeader;

public class PPreferredService extends SIPHeader implements PPreferredServiceHeader, SIPHeaderNamesIms, ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.343 -0400", hash_original_field = "34C97D9F858DE85BE5E1A29DBACD860B", hash_generated_field = "8B30B176BF34BEC26AF3F3FDA86A1827")

    private String subServiceIds;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.343 -0400", hash_original_field = "1836D1911B2C516403BCBD2A0A20CDCC", hash_generated_field = "7976ED8892ABC041E4713F4D251EC3B6")

    private String subAppIds;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.344 -0400", hash_original_method = "2FB8EC7339BBF3197572778DF84B2394", hash_generated_method = "FCCB9A4D9BB589A3DB266620467C2216")
    protected  PPreferredService(String name) {
        super(NAME);
        addTaint(name.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.344 -0400", hash_original_method = "80DD74DB52B5BA3BF0297E04ECC509FE", hash_generated_method = "8906F3091D6728D0A2DF3027DBEFD55A")
    public  PPreferredService() {
        super(P_PREFERRED_SERVICE);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.345 -0400", hash_original_method = "13CD5B55BBBCA0548D99A959291FFE7D", hash_generated_method = "069A8C083E7619B07CF99901612140D3")
    @Override
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1851460830 = null; 
        StringBuffer retval = new StringBuffer();
        retval.append(ParameterNamesIms.SERVICE_ID);
        {
            retval.append(ParameterNamesIms.SERVICE_ID_LABEL).append(".");
            retval.append(this.getSubserviceIdentifiers());
        } 
        {
            retval.append(ParameterNamesIms.APPLICATION_ID_LABEL).append(".");
            retval.append(this.getApplicationIdentifiers());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1851460830 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1851460830.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1851460830;
        
        
        
        
            
                
            
            
            
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.346 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.346 -0400", hash_original_method = "C9711D50FDDAB1BC6FA9D8BEA3306598", hash_generated_method = "CCB345BE1EF30F9F5DF817AB0B88911C")
    public String getApplicationIdentifiers() {
        String varB4EAC82CA7396A68D541C85D26508E83_1945571605 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_48713011 = null; 
        {
            boolean varC8D3650830D08C4D23073ADEABCF9ED5_180274135 = (this.subAppIds.charAt(0)=='.');
            {
                varB4EAC82CA7396A68D541C85D26508E83_1945571605 = this.subAppIds.substring(1);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_48713011 = this.subAppIds;
        String varA7E53CE21691AB073D9660D615818899_648912421; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_648912421 = varB4EAC82CA7396A68D541C85D26508E83_1945571605;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_648912421 = varB4EAC82CA7396A68D541C85D26508E83_48713011;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_648912421.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_648912421;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.347 -0400", hash_original_method = "A7D1F6103283AF549702A3BD8A97DA85", hash_generated_method = "50CB3B2789A5DC40CBAD48D945194C53")
    public String getSubserviceIdentifiers() {
        String varB4EAC82CA7396A68D541C85D26508E83_1141523142 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_772118982 = null; 
        {
            boolean varAD698E105D8BEA98C5698AFC53CE6A02_637937541 = (this.subServiceIds.charAt(0)=='.');
            {
                varB4EAC82CA7396A68D541C85D26508E83_1141523142 = this.subServiceIds.substring(1);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_772118982 = this.subServiceIds;
        String varA7E53CE21691AB073D9660D615818899_264594089; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_264594089 = varB4EAC82CA7396A68D541C85D26508E83_1141523142;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_264594089 = varB4EAC82CA7396A68D541C85D26508E83_772118982;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_264594089.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_264594089;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.347 -0400", hash_original_method = "0A65ED1D7958A8DC93D54B9D5172FB86", hash_generated_method = "813392CF39A94B938B1B3C7E12E815AD")
    public void setApplicationIdentifiers(String appids) {
        this.subAppIds = appids;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.347 -0400", hash_original_method = "86174BD2B9F1F7BE8C26F06288A88EF6", hash_generated_method = "B3E4B360308281668CC193B4B051E180")
    public void setSubserviceIdentifiers(String subservices) {
        this.subServiceIds = ".".concat(subservices);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.348 -0400", hash_original_method = "C4B8C9C88189BDF3DAB8E362AE1162B5", hash_generated_method = "8E7FF5931A1A87B79692A47C6E41215E")
    public boolean equals(Object other) {
        boolean var9B85CAC857C9D64CB6CF9C0273C2B2D2_648529173 = ((other instanceof PPreferredServiceHeader) && super.equals(other));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_169922989 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_169922989;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.348 -0400", hash_original_method = "924DF1F04CF6C30DB3A78FE0D39487E9", hash_generated_method = "70ED8647EFF03DFE1A208DC71A83F654")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1768715417 = null; 
        PPreferredService retval = (PPreferredService) super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1768715417 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1768715417.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1768715417;
        
        
        
    }

    
}

