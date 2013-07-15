package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.core.HostPort;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.parser.Parser;
import javax.sip.header.ToHeader;
import java.text.ParseException;

public final class To extends AddressParametersHeader implements javax.sip.header.ToHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.772 -0400", hash_original_method = "7CFB3ABB21EF244A9FD6E54AD9CC5173", hash_generated_method = "668C3C4C9F8E59AA7D7644F10E61864F")
    public  To() {
        super(TO,true);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.773 -0400", hash_original_method = "10EA715D50A25194DE35700E69984D3D", hash_generated_method = "32B4C3F11BD063C197F37E1841325AD2")
    public  To(From from) {
        super(TO);
        setAddress(from.address);
        setParameters(from.parameters);
        addTaint(from.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.774 -0400", hash_original_method = "DA29AB595B7A4A125EF99100FA337502", hash_generated_method = "124027B36731930799FB0A18D6248053")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_819195652 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_819195652 = headerName + COLON + SP + encodeBody() + NEWLINE;
        varB4EAC82CA7396A68D541C85D26508E83_819195652.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_819195652;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.775 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "DC0951A344072E5DEF4382E44543ED16")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1614418175 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1614418175 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1614418175.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1614418175;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.776 -0400", hash_original_method = "6379DF107AEAFFCF06677344FE0DDDB5", hash_generated_method = "4CBF507A3EFF0AC5A327ED0004404150")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_280835829 = null; 
        {
            {
                boolean var78D19BB43C375C85610BCE449243D46E_1091867790 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
                {
                    buffer.append(LESS_THAN);
                } 
            } 
            address.encode(buffer);
            {
                boolean var78D19BB43C375C85610BCE449243D46E_1918184798 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
                {
                    buffer.append(GREATER_THAN);
                } 
            } 
            {
                boolean var68D5E9BF75957AD09F9F4AEE7444A527_1731259280 = (!parameters.isEmpty());
                {
                    buffer.append(SEMICOLON);
                    parameters.encode(buffer);
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_280835829 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_280835829.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_280835829;
        
        
            
                
            
            
            
                
            
            
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.777 -0400", hash_original_method = "465066D205BCB0CD35C4F9A4E5087389", hash_generated_method = "5B755C82C270045F92F842923596AFA1")
    public HostPort getHostPort() {
        HostPort varB4EAC82CA7396A68D541C85D26508E83_512551486 = null; 
        HostPort varB4EAC82CA7396A68D541C85D26508E83_1131289908 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_512551486 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1131289908 = address.getHostPort();
        HostPort varA7E53CE21691AB073D9660D615818899_1291953344; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1291953344 = varB4EAC82CA7396A68D541C85D26508E83_512551486;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1291953344 = varB4EAC82CA7396A68D541C85D26508E83_1131289908;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1291953344.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1291953344;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.778 -0400", hash_original_method = "3C83E52D0C85786FBC54CBD0510A4886", hash_generated_method = "657CA806EDF6226511B9B71B15BDC073")
    public String getDisplayName() {
        String varB4EAC82CA7396A68D541C85D26508E83_477979890 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1884856848 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_477979890 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1884856848 = address.getDisplayName();
        String varA7E53CE21691AB073D9660D615818899_2113390865; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2113390865 = varB4EAC82CA7396A68D541C85D26508E83_477979890;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2113390865 = varB4EAC82CA7396A68D541C85D26508E83_1884856848;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2113390865.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2113390865;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.778 -0400", hash_original_method = "2057D1C8F1E8BB8C55512212A4FDB01D", hash_generated_method = "F9A9C9F59048D1FE6F13792205FA974D")
    public String getTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1834581492 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1381369159 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1834581492 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1381369159 = getParameter(ParameterNames.TAG);
        String varA7E53CE21691AB073D9660D615818899_982068048; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_982068048 = varB4EAC82CA7396A68D541C85D26508E83_1834581492;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_982068048 = varB4EAC82CA7396A68D541C85D26508E83_1381369159;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_982068048.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_982068048;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.779 -0400", hash_original_method = "DE9D34178B7493C9CBB9357375B774A4", hash_generated_method = "43E789BF0DDAF1BD3FEF7C16219C260A")
    public boolean hasTag() {
        boolean var6FA539423622336D479E26E4BC38CB5D_1419362063 = (hasParameter(ParameterNames.TAG));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1193955328 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1193955328;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.779 -0400", hash_original_method = "EECFB5B736A479D5AC464F374A1DB439", hash_generated_method = "06347E790DC02B6DE3E3A0AEF849CF0C")
    public void removeTag() {
        parameters.delete(ParameterNames.TAG);
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.780 -0400", hash_original_method = "8317B37B8D85C50DB928305D5320BE87", hash_generated_method = "5699316D34767019B630E0ED4ECDB2FC")
    public void setTag(String t) throws ParseException {
        Parser.checkToken(t);
        this.setParameter(ParameterNames.TAG, t);
        addTaint(t.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.781 -0400", hash_original_method = "ED5A65C9FFE9E87462C7980633990418", hash_generated_method = "63C3278C6064BD3A5F7642EBE01EE203")
    public String getUserAtHostPort() {
        String varB4EAC82CA7396A68D541C85D26508E83_1381131669 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_508497551 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1381131669 = null;
        varB4EAC82CA7396A68D541C85D26508E83_508497551 = address.getUserAtHostPort();
        String varA7E53CE21691AB073D9660D615818899_1798835594; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1798835594 = varB4EAC82CA7396A68D541C85D26508E83_1381131669;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1798835594 = varB4EAC82CA7396A68D541C85D26508E83_508497551;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1798835594.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1798835594;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.781 -0400", hash_original_method = "A8E3E290BA3A80BEE74A86D8FFE8EF4A", hash_generated_method = "1405C0ACA91ED2323AF340857E244E48")
    public boolean equals(Object other) {
        boolean varE717845D794282E82D38DE500F6217E3_199782810 = ((other instanceof ToHeader) && super.equals(other));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_6639272 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_6639272;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.782 -0400", hash_original_field = "BD489DAD9E109F634ADCC2F1AC7467AA", hash_generated_field = "4A9712AFAA43552733CBA4D2014F2688")

    private static final long serialVersionUID = -4057413800584586316L;
}

