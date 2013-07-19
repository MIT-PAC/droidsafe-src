package gov.nist.javax.sip.header;

// Droidsafe Imports
import gov.nist.javax.sip.address.AddressImpl;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class RecordRoute extends AddressParametersHeader implements javax.sip.header.RecordRouteHeader {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.839 -0400", hash_original_method = "1784D193E15A9C55742286FE08847141", hash_generated_method = "D1F947A90DC2AC7C0CD39710A57089DF")
    public  RecordRoute(AddressImpl address) {
        super(NAME);
        addTaint(address.getTaint());
        this.address = address;
        // ---------- Original Method ----------
        //this.address = address;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.839 -0400", hash_original_method = "F63822F670C4D20D985D1B2C470568FD", hash_generated_method = "6E15848E792F6F3E30F683E515F8A47E")
    public  RecordRoute() {
        super(RECORD_ROUTE);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.839 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "1DB9C63FFA97BB6C3BFAD6B52DAD9743")
    public String encodeBody() {
String varB9AAF3B320DC07C68A40DABE06BFAFD1_1454736819 =         encodeBody(new StringBuffer()).toString();
        varB9AAF3B320DC07C68A40DABE06BFAFD1_1454736819.addTaint(taint);
        return varB9AAF3B320DC07C68A40DABE06BFAFD1_1454736819;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.840 -0400", hash_original_method = "1F2E3BF90793586E89EB2C500039787C", hash_generated_method = "B9E5F396BC2BFC7E11178BCCAF700577")
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
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1988159785 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_1988159785.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1988159785;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.840 -0400", hash_original_field = "E32A96EEC9EC8C8193321B9247FF1E9B", hash_generated_field = "E1824FFE4050EC4E12856745910C83B9")

    private static final long serialVersionUID = 2388023364181727205L;
}

