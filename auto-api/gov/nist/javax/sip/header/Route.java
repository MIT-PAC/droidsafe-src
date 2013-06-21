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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.163 -0400", hash_original_method = "B9CE287F547A57CF29833C977E422F42", hash_generated_method = "78BD04979B7BBC9CE0E7EF4486861FDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Route() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.164 -0400", hash_original_method = "D97B9DA75E98466FFB5CFE28F884D630", hash_generated_method = "2CD7D07C7852D6F4FF260E03618CFDCC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Route(AddressImpl address) {
        super(NAME);
        dsTaint.addTaint(address.dsTaint);
        this.address = address;
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.164 -0400", hash_original_method = "42825E09BC1306330D357AEB56059051", hash_generated_method = "22399FAD0079E019DD67F8B2D7B9181B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int hashCode() {
        int var9C79550AB94DC3847B947AFB716927DB_1996391700 = (this.address.getHostPort().encode().toLowerCase().hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.address.getHostPort().encode().toLowerCase().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.164 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "F458D01B42D7F5F8EF3E09DE77B81701")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        String var1FB3D4520BF100042DCF9757D0219988_1326151168 = (encodeBody(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.164 -0400", hash_original_method = "2891D97F5EA93E20B16E0A9272FB4B2C", hash_generated_method = "209C99ECB24C0DBC3E435DB93FD76BE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected StringBuffer encodeBody(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
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
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_784864432 = (!parameters.isEmpty());
            {
                buffer.append(SEMICOLON);
                parameters.encode(buffer);
            } //End block
        } //End collapsed parenthetic
        return (StringBuffer)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.165 -0400", hash_original_method = "53DB62040F48266C1BBF2CE5E963ACD1", hash_generated_method = "D2518AB4009CCF8F72FE82314B14FB85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        boolean var2F4AFEB523B482BB1EEA591882055F1B_488769903 = ((other instanceof RouteHeader) && super.equals(other));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (other instanceof RouteHeader) && super.equals(other);
    }

    
    private static final long serialVersionUID = 5683577362998368846L;
}

