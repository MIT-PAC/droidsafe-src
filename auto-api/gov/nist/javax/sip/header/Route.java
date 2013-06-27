package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.address.AddressImpl;
import javax.sip.header.RouteHeader;

public class Route extends AddressParametersHeader implements javax.sip.header.RouteHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.417 -0400", hash_original_method = "B9CE287F547A57CF29833C977E422F42", hash_generated_method = "78BD04979B7BBC9CE0E7EF4486861FDE")
    public  Route() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.417 -0400", hash_original_method = "D97B9DA75E98466FFB5CFE28F884D630", hash_generated_method = "39DA2D92B961A947E890F449A9EA9E62")
    public  Route(AddressImpl address) {
        super(NAME);
        this.address = address;
        addTaint(address.getTaint());
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.417 -0400", hash_original_method = "42825E09BC1306330D357AEB56059051", hash_generated_method = "0CCD9104E154586977C49570B1377532")
    public int hashCode() {
        int var9C79550AB94DC3847B947AFB716927DB_1140829988 = (this.address.getHostPort().encode().toLowerCase().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_183199968 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_183199968;
        // ---------- Original Method ----------
        //return this.address.getHostPort().encode().toLowerCase().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.418 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "5DDA47539B5EA6C4154966F711783033")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1058833835 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1058833835 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1058833835.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1058833835;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.430 -0400", hash_original_method = "2891D97F5EA93E20B16E0A9272FB4B2C", hash_generated_method = "A5C0DF02EAFC61350DD25A4A36F56CE4")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1716926266 = null; //Variable for return #1
        boolean addrFlag;
        addrFlag = address.getAddressType() == AddressImpl.NAME_ADDR;
        {
            buffer.append('<');
            address.encode(buffer);
            buffer.append('>');
        } //End block
        {
            address.encode(buffer);
        } //End block
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_211437162 = (!parameters.isEmpty());
            {
                buffer.append(SEMICOLON);
                parameters.encode(buffer);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1716926266 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1716926266.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1716926266;
        // ---------- Original Method ----------
        //boolean addrFlag = address.getAddressType() == AddressImpl.NAME_ADDR;
        //if (!addrFlag) {
            //buffer.append('<');
            //address.encode(buffer);
            //buffer.append('>');
        //} else {
            //address.encode(buffer);
        //}
        //if (!parameters.isEmpty()) {
            //buffer.append(SEMICOLON);
            //parameters.encode(buffer);
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.430 -0400", hash_original_method = "53DB62040F48266C1BBF2CE5E963ACD1", hash_generated_method = "D983E3E6707AE2E6E94D5322BA8A06A3")
    public boolean equals(Object other) {
        boolean var2F4AFEB523B482BB1EEA591882055F1B_196328382 = ((other instanceof RouteHeader) && super.equals(other));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_753847070 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_753847070;
        // ---------- Original Method ----------
        //return (other instanceof RouteHeader) && super.equals(other);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.430 -0400", hash_original_field = "24947308B97B96B5EB000D870A381219", hash_generated_field = "B8A716CEE790D909B6E23BB7AF46C084")

    private static long serialVersionUID = 5683577362998368846L;
}

