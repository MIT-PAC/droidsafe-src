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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.442 -0400", hash_original_method = "7CFB3ABB21EF244A9FD6E54AD9CC5173", hash_generated_method = "668C3C4C9F8E59AA7D7644F10E61864F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public To() {
        super(TO,true);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.442 -0400", hash_original_method = "10EA715D50A25194DE35700E69984D3D", hash_generated_method = "E9B63885D674C8F1C2638411835D2639")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public To(From from) {
        super(TO);
        dsTaint.addTaint(from.dsTaint);
        setAddress(from.address);
        setParameters(from.parameters);
        // ---------- Original Method ----------
        //setAddress(from.address);
        //setParameters(from.parameters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.442 -0400", hash_original_method = "DA29AB595B7A4A125EF99100FA337502", hash_generated_method = "615A41360DA0D45322927C980AC1C152")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encode() {
        String var803E280AC6E161553ACD6EAB6E4869F5_344909620 = (headerName + COLON + SP + encodeBody() + NEWLINE);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return headerName + COLON + SP + encodeBody() + NEWLINE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.442 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "37D9C3591DC154137D2CBEFA060D31AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String encodeBody() {
        String var1FB3D4520BF100042DCF9757D0219988_1197653961 = (encodeBody(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.443 -0400", hash_original_method = "6379DF107AEAFFCF06677344FE0DDDB5", hash_generated_method = "230430F289110BF8CBA42E7CD8A48D88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected StringBuffer encodeBody(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        {
            {
                boolean var78D19BB43C375C85610BCE449243D46E_293904823 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
                {
                    buffer.append(LESS_THAN);
                } //End block
            } //End collapsed parenthetic
            address.encode(buffer);
            {
                boolean var78D19BB43C375C85610BCE449243D46E_792430067 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
                {
                    buffer.append(GREATER_THAN);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var68D5E9BF75957AD09F9F4AEE7444A527_1884781840 = (!parameters.isEmpty());
                {
                    buffer.append(SEMICOLON);
                    parameters.encode(buffer);
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (StringBuffer)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.443 -0400", hash_original_method = "465066D205BCB0CD35C4F9A4E5087389", hash_generated_method = "4799529F2ABAB6B51D6984FAC30B60BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HostPort getHostPort() {
        HostPort varEEF9871E33E64F4E24422F40F5C745CE_676848619 = (address.getHostPort());
        return (HostPort)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (address == null)
            //return null;
        //return address.getHostPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.443 -0400", hash_original_method = "3C83E52D0C85786FBC54CBD0510A4886", hash_generated_method = "8D99BBDEDBC8E33E3EA59805F0853B76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDisplayName() {
        String var31866FBF526B94C8B9049BB4E32C34D2_2097124872 = (address.getDisplayName());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (address == null)
            //return null;
        //return address.getDisplayName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.443 -0400", hash_original_method = "2057D1C8F1E8BB8C55512212A4FDB01D", hash_generated_method = "9FD990678B4A52719A7FC18B3CDFD743")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getTag() {
        String var2CBE987BEB64DE2AB52488AA15F8609C_690342693 = (getParameter(ParameterNames.TAG));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (parameters == null)
            //return null;
        //return getParameter(ParameterNames.TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.444 -0400", hash_original_method = "DE9D34178B7493C9CBB9357375B774A4", hash_generated_method = "C965A766CFFF1EA720F30B767C83D9B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasTag() {
        boolean var6FA539423622336D479E26E4BC38CB5D_1649142964 = (hasParameter(ParameterNames.TAG));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (parameters == null)
            //return false;
        //return hasParameter(ParameterNames.TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.444 -0400", hash_original_method = "EECFB5B736A479D5AC464F374A1DB439", hash_generated_method = "06347E790DC02B6DE3E3A0AEF849CF0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeTag() {
        parameters.delete(ParameterNames.TAG);
        // ---------- Original Method ----------
        //if (parameters != null)
                //parameters.delete(ParameterNames.TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.444 -0400", hash_original_method = "8317B37B8D85C50DB928305D5320BE87", hash_generated_method = "97D69F18C02152E862494A696E9EA9DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTag(String t) throws ParseException {
        dsTaint.addTaint(t);
        Parser.checkToken(t);
        this.setParameter(ParameterNames.TAG, t);
        // ---------- Original Method ----------
        //Parser.checkToken(t);
        //this.setParameter(ParameterNames.TAG, t);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.444 -0400", hash_original_method = "ED5A65C9FFE9E87462C7980633990418", hash_generated_method = "10EDAC2751FD846EE1D825116B3A8BB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getUserAtHostPort() {
        String varC05CA356E71E92F83BBFC5717562CC1F_1773116475 = (address.getUserAtHostPort());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (address == null)
            //return null;
        //return address.getUserAtHostPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.444 -0400", hash_original_method = "A8E3E290BA3A80BEE74A86D8FFE8EF4A", hash_generated_method = "FB0457440D0F6D1F7726FED102935D02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        boolean varE717845D794282E82D38DE500F6217E3_222361064 = ((other instanceof ToHeader) && super.equals(other));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (other instanceof ToHeader) && super.equals(other);
    }

    
    private static final long serialVersionUID = -4057413800584586316L;
}

