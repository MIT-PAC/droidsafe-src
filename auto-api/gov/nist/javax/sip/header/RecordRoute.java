package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.address.*;

public class RecordRoute extends AddressParametersHeader implements javax.sip.header.RecordRouteHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.360 -0400", hash_original_method = "1784D193E15A9C55742286FE08847141", hash_generated_method = "5CA1E44B9A2B6369A9863F92BA224A33")
    public  RecordRoute(AddressImpl address) {
        super(NAME);
        this.address = address;
        addTaint(address.getTaint());
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.360 -0400", hash_original_method = "F63822F670C4D20D985D1B2C470568FD", hash_generated_method = "6E15848E792F6F3E30F683E515F8A47E")
    public  RecordRoute() {
        super(RECORD_ROUTE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.360 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "DC735E97614A5D11A24E6F58F015F6A8")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_2008936418 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2008936418 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_2008936418.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2008936418;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.361 -0400", hash_original_method = "1F2E3BF90793586E89EB2C500039787C", hash_generated_method = "03F1586028281492EB063F47DD9BB2C5")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_962942038 = null; //Variable for return #1
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_147889883 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                buffer.append(LESS_THAN);
            } //End block
        } //End collapsed parenthetic
        address.encode(buffer);
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_899745212 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                buffer.append(GREATER_THAN);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_303683152 = (!parameters.isEmpty());
            {
                buffer.append(SEMICOLON);
                this.parameters.encode(buffer);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_962942038 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_962942038.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_962942038;
        // ---------- Original Method ----------
        //if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            //buffer.append(LESS_THAN);
        //}
        //address.encode(buffer);
        //if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            //buffer.append(GREATER_THAN);
        //}
        //if (!parameters.isEmpty()) {
            //buffer.append(SEMICOLON);
            //this.parameters.encode(buffer);
        //}
        //return buffer;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.361 -0400", hash_original_field = "E32A96EEC9EC8C8193321B9247FF1E9B", hash_generated_field = "063D5C6C9ED96ABD959AB37662ED4CA7")

    private static long serialVersionUID = 2388023364181727205L;
}

