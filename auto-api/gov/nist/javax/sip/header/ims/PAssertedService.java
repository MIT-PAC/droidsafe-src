package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import gov.nist.javax.sip.header.SIPHeader;
import javax.sip.header.ExtensionHeader;

public class PAssertedService extends SIPHeader implements PAssertedServiceHeader, SIPHeaderNamesIms, ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.195 -0400", hash_original_field = "34C97D9F858DE85BE5E1A29DBACD860B", hash_generated_field = "8B30B176BF34BEC26AF3F3FDA86A1827")

    private String subServiceIds;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.195 -0400", hash_original_field = "1836D1911B2C516403BCBD2A0A20CDCC", hash_generated_field = "7976ED8892ABC041E4713F4D251EC3B6")

    private String subAppIds;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.195 -0400", hash_original_method = "182ECFD494AF5D51867F4CB3F9E644EB", hash_generated_method = "6A6E160BAB145753731DA292EEC0188E")
    protected  PAssertedService(String name) {
        super(NAME);
        addTaint(name.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.196 -0400", hash_original_method = "AA5E567A5261831D339C7F3E134619EA", hash_generated_method = "320063B2C7D78E77D8E4F4C11712E1EC")
    public  PAssertedService() {
        super(P_ASSERTED_SERVICE);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.196 -0400", hash_original_method = "13CD5B55BBBCA0548D99A959291FFE7D", hash_generated_method = "228C3E95C3BD69B27B966C90886CE9FA")
    @Override
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_170220196 = null; 
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
        varB4EAC82CA7396A68D541C85D26508E83_170220196 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_170220196.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_170220196;
        
        
        
        
            
                
            
            
            
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.197 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.197 -0400", hash_original_method = "C9711D50FDDAB1BC6FA9D8BEA3306598", hash_generated_method = "EE3D1115B69FB7C8E8147864C8883BA2")
    public String getApplicationIdentifiers() {
        String varB4EAC82CA7396A68D541C85D26508E83_358851240 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_737289646 = null; 
        {
            boolean varC8D3650830D08C4D23073ADEABCF9ED5_1692901137 = (this.subAppIds.charAt(0)=='.');
            {
                varB4EAC82CA7396A68D541C85D26508E83_358851240 = this.subAppIds.substring(1);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_737289646 = this.subAppIds;
        String varA7E53CE21691AB073D9660D615818899_1161746321; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1161746321 = varB4EAC82CA7396A68D541C85D26508E83_358851240;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1161746321 = varB4EAC82CA7396A68D541C85D26508E83_737289646;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1161746321.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1161746321;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.198 -0400", hash_original_method = "A7D1F6103283AF549702A3BD8A97DA85", hash_generated_method = "64316F8D48B6CC1319C9A2A6B7604A32")
    public String getSubserviceIdentifiers() {
        String varB4EAC82CA7396A68D541C85D26508E83_839849696 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1985595833 = null; 
        {
            boolean varAD698E105D8BEA98C5698AFC53CE6A02_2097874706 = (this.subServiceIds.charAt(0)=='.');
            {
                varB4EAC82CA7396A68D541C85D26508E83_839849696 = this.subServiceIds.substring(1);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1985595833 = this.subServiceIds;
        String varA7E53CE21691AB073D9660D615818899_1104552356; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1104552356 = varB4EAC82CA7396A68D541C85D26508E83_839849696;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1104552356 = varB4EAC82CA7396A68D541C85D26508E83_1985595833;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1104552356.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1104552356;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.198 -0400", hash_original_method = "0A65ED1D7958A8DC93D54B9D5172FB86", hash_generated_method = "813392CF39A94B938B1B3C7E12E815AD")
    public void setApplicationIdentifiers(String appids) {
        this.subAppIds = appids;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.198 -0400", hash_original_method = "D85C3DD3D271FDFF4F350559A8282CAD", hash_generated_method = "408F5C6315DFA9E24D9CFBD7DDC9F713")
    public void setSubserviceIdentifiers(String subservices) {
        this.subServiceIds = subservices;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.199 -0400", hash_original_method = "698565353F33C32BACB06EBECCB2189D", hash_generated_method = "10857A6E35C3F1ECF22BF97B441FB457")
    public boolean equals(Object other) {
        boolean varACB9572725C3D0BB03C5FDEA37D02E09_17490299 = ((other instanceof PAssertedServiceHeader) && super.equals(other));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1277687171 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1277687171;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.199 -0400", hash_original_method = "3CDC6738E06A7AFD0A34818FC063034A", hash_generated_method = "0ADFF4D82FEF0D131D97461B602EF0C6")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1609585835 = null; 
        PAssertedService retval = (PAssertedService) super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1609585835 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1609585835.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1609585835;
        
        
        
    }

    
}

