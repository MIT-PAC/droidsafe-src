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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.860 -0400", hash_original_method = "7CFB3ABB21EF244A9FD6E54AD9CC5173", hash_generated_method = "668C3C4C9F8E59AA7D7644F10E61864F")
    public  To() {
        super(TO,true);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.860 -0400", hash_original_method = "10EA715D50A25194DE35700E69984D3D", hash_generated_method = "32B4C3F11BD063C197F37E1841325AD2")
    public  To(From from) {
        super(TO);
        setAddress(from.address);
        setParameters(from.parameters);
        addTaint(from.getTaint());
        // ---------- Original Method ----------
        //setAddress(from.address);
        //setParameters(from.parameters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.875 -0400", hash_original_method = "DA29AB595B7A4A125EF99100FA337502", hash_generated_method = "BC98881D2C60D95BB8969D6114EDEAF7")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1865195680 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1865195680 = headerName + COLON + SP + encodeBody() + NEWLINE;
        varB4EAC82CA7396A68D541C85D26508E83_1865195680.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1865195680;
        // ---------- Original Method ----------
        //return headerName + COLON + SP + encodeBody() + NEWLINE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.876 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "81F74BE35106341DC4091318EEA84D35")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1728270330 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1728270330 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1728270330.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1728270330;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.876 -0400", hash_original_method = "6379DF107AEAFFCF06677344FE0DDDB5", hash_generated_method = "BE2EB94324FA24842F718347C074C006")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1603834797 = null; //Variable for return #1
        {
            {
                boolean var78D19BB43C375C85610BCE449243D46E_1294362572 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
                {
                    buffer.append(LESS_THAN);
                } //End block
            } //End collapsed parenthetic
            address.encode(buffer);
            {
                boolean var78D19BB43C375C85610BCE449243D46E_1786816656 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
                {
                    buffer.append(GREATER_THAN);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var68D5E9BF75957AD09F9F4AEE7444A527_1754912418 = (!parameters.isEmpty());
                {
                    buffer.append(SEMICOLON);
                    parameters.encode(buffer);
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1603834797 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1603834797.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1603834797;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.877 -0400", hash_original_method = "465066D205BCB0CD35C4F9A4E5087389", hash_generated_method = "EEB9A59E3D62B507E73EBA2EA6F9F92F")
    public HostPort getHostPort() {
        HostPort varB4EAC82CA7396A68D541C85D26508E83_303964472 = null; //Variable for return #1
        HostPort varB4EAC82CA7396A68D541C85D26508E83_813321273 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_303964472 = null;
        varB4EAC82CA7396A68D541C85D26508E83_813321273 = address.getHostPort();
        HostPort varA7E53CE21691AB073D9660D615818899_1576423657; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1576423657 = varB4EAC82CA7396A68D541C85D26508E83_303964472;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1576423657 = varB4EAC82CA7396A68D541C85D26508E83_813321273;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1576423657.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1576423657;
        // ---------- Original Method ----------
        //if (address == null)
            //return null;
        //return address.getHostPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.882 -0400", hash_original_method = "3C83E52D0C85786FBC54CBD0510A4886", hash_generated_method = "FF21931C539A46692F3C03093C6E2883")
    public String getDisplayName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1019591365 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1760949755 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1019591365 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1760949755 = address.getDisplayName();
        String varA7E53CE21691AB073D9660D615818899_1043839855; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1043839855 = varB4EAC82CA7396A68D541C85D26508E83_1019591365;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1043839855 = varB4EAC82CA7396A68D541C85D26508E83_1760949755;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1043839855.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1043839855;
        // ---------- Original Method ----------
        //if (address == null)
            //return null;
        //return address.getDisplayName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.898 -0400", hash_original_method = "2057D1C8F1E8BB8C55512212A4FDB01D", hash_generated_method = "89DBF7DC6A74EF2CE303199F4D22C991")
    public String getTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1193502410 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_836602641 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1193502410 = null;
        varB4EAC82CA7396A68D541C85D26508E83_836602641 = getParameter(ParameterNames.TAG);
        String varA7E53CE21691AB073D9660D615818899_86474830; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_86474830 = varB4EAC82CA7396A68D541C85D26508E83_1193502410;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_86474830 = varB4EAC82CA7396A68D541C85D26508E83_836602641;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_86474830.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_86474830;
        // ---------- Original Method ----------
        //if (parameters == null)
            //return null;
        //return getParameter(ParameterNames.TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.899 -0400", hash_original_method = "DE9D34178B7493C9CBB9357375B774A4", hash_generated_method = "611F5F219FACC9BF6BE6A56267EF9D90")
    public boolean hasTag() {
        boolean var6FA539423622336D479E26E4BC38CB5D_518588360 = (hasParameter(ParameterNames.TAG));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1915210257 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1915210257;
        // ---------- Original Method ----------
        //if (parameters == null)
            //return false;
        //return hasParameter(ParameterNames.TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.899 -0400", hash_original_method = "EECFB5B736A479D5AC464F374A1DB439", hash_generated_method = "06347E790DC02B6DE3E3A0AEF849CF0C")
    public void removeTag() {
        parameters.delete(ParameterNames.TAG);
        // ---------- Original Method ----------
        //if (parameters != null)
                //parameters.delete(ParameterNames.TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.903 -0400", hash_original_method = "8317B37B8D85C50DB928305D5320BE87", hash_generated_method = "5699316D34767019B630E0ED4ECDB2FC")
    public void setTag(String t) throws ParseException {
        Parser.checkToken(t);
        this.setParameter(ParameterNames.TAG, t);
        addTaint(t.getTaint());
        // ---------- Original Method ----------
        //Parser.checkToken(t);
        //this.setParameter(ParameterNames.TAG, t);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.903 -0400", hash_original_method = "ED5A65C9FFE9E87462C7980633990418", hash_generated_method = "FC9503FA9FD654E99422E98D7BAAFC9A")
    public String getUserAtHostPort() {
        String varB4EAC82CA7396A68D541C85D26508E83_758206078 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1701693901 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_758206078 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1701693901 = address.getUserAtHostPort();
        String varA7E53CE21691AB073D9660D615818899_1125645099; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1125645099 = varB4EAC82CA7396A68D541C85D26508E83_758206078;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1125645099 = varB4EAC82CA7396A68D541C85D26508E83_1701693901;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1125645099.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1125645099;
        // ---------- Original Method ----------
        //if (address == null)
            //return null;
        //return address.getUserAtHostPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.904 -0400", hash_original_method = "A8E3E290BA3A80BEE74A86D8FFE8EF4A", hash_generated_method = "FFE8FBACCED95D7B6B4FDB8AF777E400")
    public boolean equals(Object other) {
        boolean varE717845D794282E82D38DE500F6217E3_2141467071 = ((other instanceof ToHeader) && super.equals(other));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_546757762 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_546757762;
        // ---------- Original Method ----------
        //return (other instanceof ToHeader) && super.equals(other);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.904 -0400", hash_original_field = "BD489DAD9E109F634ADCC2F1AC7467AA", hash_generated_field = "09F24984F501B62EAB60CAB72A8E5D69")

    private static long serialVersionUID = -4057413800584586316L;
}

