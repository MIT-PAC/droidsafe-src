package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.address.*;

public class RecordRoute extends AddressParametersHeader implements javax.sip.header.RecordRouteHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.107 -0400", hash_original_method = "1784D193E15A9C55742286FE08847141", hash_generated_method = "09A5E8A793E2B7002600E5742CB6AA42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RecordRoute(AddressImpl address) {
        super(NAME);
        dsTaint.addTaint(address.dsTaint);
        this.address = address;
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.107 -0400", hash_original_method = "F63822F670C4D20D985D1B2C470568FD", hash_generated_method = "6E15848E792F6F3E30F683E515F8A47E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RecordRoute() {
        super(RECORD_ROUTE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.107 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "45EE09D139046270F391C22D5B41857F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        String var1FB3D4520BF100042DCF9757D0219988_427633035 = (encodeBody(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.107 -0400", hash_original_method = "1F2E3BF90793586E89EB2C500039787C", hash_generated_method = "3893C0207671B12D8E92B466EF0E75F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected StringBuffer encodeBody(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_295730387 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                buffer.append(LESS_THAN);
            } //End block
        } //End collapsed parenthetic
        address.encode(buffer);
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_17964295 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                buffer.append(GREATER_THAN);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_554498497 = (!parameters.isEmpty());
            {
                buffer.append(SEMICOLON);
                this.parameters.encode(buffer);
            } //End block
        } //End collapsed parenthetic
        return (StringBuffer)dsTaint.getTaint();
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

    
    private static final long serialVersionUID = 2388023364181727205L;
}

