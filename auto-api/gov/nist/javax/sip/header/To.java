package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.HostPort;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.parser.Parser;
import javax.sip.header.ToHeader;
import java.text.ParseException;

public final class To extends AddressParametersHeader implements javax.sip.header.ToHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.685 -0400", hash_original_method = "7CFB3ABB21EF244A9FD6E54AD9CC5173", hash_generated_method = "668C3C4C9F8E59AA7D7644F10E61864F")
    public  To() {
        super(TO,true);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.685 -0400", hash_original_method = "10EA715D50A25194DE35700E69984D3D", hash_generated_method = "32B4C3F11BD063C197F37E1841325AD2")
    public  To(From from) {
        super(TO);
        setAddress(from.address);
        setParameters(from.parameters);
        addTaint(from.getTaint());
        // ---------- Original Method ----------
        //setAddress(from.address);
        //setParameters(from.parameters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.685 -0400", hash_original_method = "DA29AB595B7A4A125EF99100FA337502", hash_generated_method = "4D727B58DD28F229B865547E9C19D226")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1307913383 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1307913383 = headerName + COLON + SP + encodeBody() + NEWLINE;
        varB4EAC82CA7396A68D541C85D26508E83_1307913383.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1307913383;
        // ---------- Original Method ----------
        //return headerName + COLON + SP + encodeBody() + NEWLINE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.686 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "0436EA4BCB4A1CE2B0A95E5EF15A3660")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_162412332 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_162412332 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_162412332.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_162412332;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.696 -0400", hash_original_method = "6379DF107AEAFFCF06677344FE0DDDB5", hash_generated_method = "E74B24059E68EDDA413D05CE6D6C31DC")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1916553058 = null; //Variable for return #1
        {
            {
                boolean var78D19BB43C375C85610BCE449243D46E_421619316 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
                {
                    buffer.append(LESS_THAN);
                } //End block
            } //End collapsed parenthetic
            address.encode(buffer);
            {
                boolean var78D19BB43C375C85610BCE449243D46E_1219670020 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
                {
                    buffer.append(GREATER_THAN);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var68D5E9BF75957AD09F9F4AEE7444A527_1404543924 = (!parameters.isEmpty());
                {
                    buffer.append(SEMICOLON);
                    parameters.encode(buffer);
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1916553058 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1916553058.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1916553058;
        // ---------- Original Method ----------
        //if (address != null) {
            //if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
                //buffer.append(LESS_THAN);
            //}
            //address.encode(buffer);
            //if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
                //buffer.append(GREATER_THAN);
            //}
            //if (!parameters.isEmpty()) {
                //buffer.append(SEMICOLON);
                //parameters.encode(buffer);
            //}
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.697 -0400", hash_original_method = "465066D205BCB0CD35C4F9A4E5087389", hash_generated_method = "239281A1192E7C606BD2BC227147CB66")
    public HostPort getHostPort() {
        HostPort varB4EAC82CA7396A68D541C85D26508E83_946148300 = null; //Variable for return #1
        HostPort varB4EAC82CA7396A68D541C85D26508E83_1875672812 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_946148300 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1875672812 = address.getHostPort();
        HostPort varA7E53CE21691AB073D9660D615818899_1170686338; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1170686338 = varB4EAC82CA7396A68D541C85D26508E83_946148300;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1170686338 = varB4EAC82CA7396A68D541C85D26508E83_1875672812;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1170686338.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1170686338;
        // ---------- Original Method ----------
        //if (address == null)
            //return null;
        //return address.getHostPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.697 -0400", hash_original_method = "3C83E52D0C85786FBC54CBD0510A4886", hash_generated_method = "043A07728AB360A4CC2E35892FB7E20C")
    public String getDisplayName() {
        String varB4EAC82CA7396A68D541C85D26508E83_940603285 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1139574314 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_940603285 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1139574314 = address.getDisplayName();
        String varA7E53CE21691AB073D9660D615818899_2027118169; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2027118169 = varB4EAC82CA7396A68D541C85D26508E83_940603285;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2027118169 = varB4EAC82CA7396A68D541C85D26508E83_1139574314;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2027118169.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2027118169;
        // ---------- Original Method ----------
        //if (address == null)
            //return null;
        //return address.getDisplayName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.698 -0400", hash_original_method = "2057D1C8F1E8BB8C55512212A4FDB01D", hash_generated_method = "5298A60AA22FB10B33330F284FE9E608")
    public String getTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1484852949 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1247822471 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1484852949 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1247822471 = getParameter(ParameterNames.TAG);
        String varA7E53CE21691AB073D9660D615818899_194065345; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_194065345 = varB4EAC82CA7396A68D541C85D26508E83_1484852949;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_194065345 = varB4EAC82CA7396A68D541C85D26508E83_1247822471;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_194065345.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_194065345;
        // ---------- Original Method ----------
        //if (parameters == null)
            //return null;
        //return getParameter(ParameterNames.TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.702 -0400", hash_original_method = "DE9D34178B7493C9CBB9357375B774A4", hash_generated_method = "0B6F6082042819B117AFA011DCFC47BF")
    public boolean hasTag() {
        boolean var6FA539423622336D479E26E4BC38CB5D_685027305 = (hasParameter(ParameterNames.TAG));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1130234315 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1130234315;
        // ---------- Original Method ----------
        //if (parameters == null)
            //return false;
        //return hasParameter(ParameterNames.TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.703 -0400", hash_original_method = "EECFB5B736A479D5AC464F374A1DB439", hash_generated_method = "06347E790DC02B6DE3E3A0AEF849CF0C")
    public void removeTag() {
        parameters.delete(ParameterNames.TAG);
        // ---------- Original Method ----------
        //if (parameters != null)
                //parameters.delete(ParameterNames.TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.703 -0400", hash_original_method = "8317B37B8D85C50DB928305D5320BE87", hash_generated_method = "5699316D34767019B630E0ED4ECDB2FC")
    public void setTag(String t) throws ParseException {
        Parser.checkToken(t);
        this.setParameter(ParameterNames.TAG, t);
        addTaint(t.getTaint());
        // ---------- Original Method ----------
        //Parser.checkToken(t);
        //this.setParameter(ParameterNames.TAG, t);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.703 -0400", hash_original_method = "ED5A65C9FFE9E87462C7980633990418", hash_generated_method = "0B76C01DF084DF2C7390B9F04A133305")
    public String getUserAtHostPort() {
        String varB4EAC82CA7396A68D541C85D26508E83_851080234 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_286785765 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_851080234 = null;
        varB4EAC82CA7396A68D541C85D26508E83_286785765 = address.getUserAtHostPort();
        String varA7E53CE21691AB073D9660D615818899_1488200577; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1488200577 = varB4EAC82CA7396A68D541C85D26508E83_851080234;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1488200577 = varB4EAC82CA7396A68D541C85D26508E83_286785765;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1488200577.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1488200577;
        // ---------- Original Method ----------
        //if (address == null)
            //return null;
        //return address.getUserAtHostPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.704 -0400", hash_original_method = "A8E3E290BA3A80BEE74A86D8FFE8EF4A", hash_generated_method = "7F480F926B8FB4E6D8C66CDF9627C6B8")
    public boolean equals(Object other) {
        boolean varE717845D794282E82D38DE500F6217E3_1277891262 = ((other instanceof ToHeader) && super.equals(other));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_834781250 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_834781250;
        // ---------- Original Method ----------
        //return (other instanceof ToHeader) && super.equals(other);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.704 -0400", hash_original_field = "BD489DAD9E109F634ADCC2F1AC7467AA", hash_generated_field = "09F24984F501B62EAB60CAB72A8E5D69")

    private static long serialVersionUID = -4057413800584586316L;
}

