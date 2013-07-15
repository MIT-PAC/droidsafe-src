package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.address.*;

public class RecordRoute extends AddressParametersHeader implements javax.sip.header.RecordRouteHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.820 -0400", hash_original_method = "1784D193E15A9C55742286FE08847141", hash_generated_method = "D1F947A90DC2AC7C0CD39710A57089DF")
    public  RecordRoute(AddressImpl address) {
        super(NAME);
        addTaint(address.getTaint());
        this.address = address;
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.820 -0400", hash_original_method = "F63822F670C4D20D985D1B2C470568FD", hash_generated_method = "6E15848E792F6F3E30F683E515F8A47E")
    public  RecordRoute() {
        super(RECORD_ROUTE);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.821 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "CB26ED8E14EF8DF1D15A4669DCD761A7")
    public String encodeBody() {
String varB9AAF3B320DC07C68A40DABE06BFAFD1_922642630 =         encodeBody(new StringBuffer()).toString();
        varB9AAF3B320DC07C68A40DABE06BFAFD1_922642630.addTaint(taint);
        return varB9AAF3B320DC07C68A40DABE06BFAFD1_922642630;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.822 -0400", hash_original_method = "1F2E3BF90793586E89EB2C500039787C", hash_generated_method = "56D71691DA44AC7E9F4117CE9ACDF3C0")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        addTaint(buffer.getTaint());
    if(address.getAddressType() == AddressImpl.ADDRESS_SPEC)        
        {
            buffer.append(LESS_THAN);
        } //End block
        address.encode(buffer);
    if(address.getAddressType() == AddressImpl.ADDRESS_SPEC)        
        {
            buffer.append(GREATER_THAN);
        } //End block
    if(!parameters.isEmpty())        
        {
            buffer.append(SEMICOLON);
            this.parameters.encode(buffer);
        } //End block
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1291372500 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_1291372500.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1291372500;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.822 -0400", hash_original_field = "E32A96EEC9EC8C8193321B9247FF1E9B", hash_generated_field = "E1824FFE4050EC4E12856745910C83B9")

    private static final long serialVersionUID = 2388023364181727205L;
}

