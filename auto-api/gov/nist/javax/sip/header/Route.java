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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.144 -0400", hash_original_method = "B9CE287F547A57CF29833C977E422F42", hash_generated_method = "78BD04979B7BBC9CE0E7EF4486861FDE")
    public  Route() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.144 -0400", hash_original_method = "D97B9DA75E98466FFB5CFE28F884D630", hash_generated_method = "39DA2D92B961A947E890F449A9EA9E62")
    public  Route(AddressImpl address) {
        super(NAME);
        this.address = address;
        addTaint(address.getTaint());
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.145 -0400", hash_original_method = "42825E09BC1306330D357AEB56059051", hash_generated_method = "E1A3B8FBE54B1327F41ACCB818084164")
    public int hashCode() {
        int var9C79550AB94DC3847B947AFB716927DB_1136334620 = (this.address.getHostPort().encode().toLowerCase().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1920480409 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1920480409;
        // ---------- Original Method ----------
        //return this.address.getHostPort().encode().toLowerCase().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.145 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "9E04EE7918FD2CDF61F64505DBA1781D")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_434474926 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_434474926 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_434474926.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_434474926;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.146 -0400", hash_original_method = "2891D97F5EA93E20B16E0A9272FB4B2C", hash_generated_method = "0B1839FE707B28C7061B52235C167168")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_248549866 = null; //Variable for return #1
        boolean addrFlag = address.getAddressType() == AddressImpl.NAME_ADDR;
        {
            buffer.append('<');
            address.encode(buffer);
            buffer.append('>');
        } //End block
        {
            address.encode(buffer);
        } //End block
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_306229442 = (!parameters.isEmpty());
            {
                buffer.append(SEMICOLON);
                parameters.encode(buffer);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_248549866 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_248549866.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_248549866;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.146 -0400", hash_original_method = "53DB62040F48266C1BBF2CE5E963ACD1", hash_generated_method = "D6FAB9318C718156FAFB790AA2FF5415")
    public boolean equals(Object other) {
        boolean var2F4AFEB523B482BB1EEA591882055F1B_2067737166 = ((other instanceof RouteHeader) && super.equals(other));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1586026207 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1586026207;
        // ---------- Original Method ----------
        //return (other instanceof RouteHeader) && super.equals(other);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.146 -0400", hash_original_field = "24947308B97B96B5EB000D870A381219", hash_generated_field = "CDE0CEB85AD3435FE4139286512ECD09")

    private static final long serialVersionUID = 5683577362998368846L;
}

