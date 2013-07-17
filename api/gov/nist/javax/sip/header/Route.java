package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.address.AddressImpl;
import javax.sip.header.RouteHeader;

public class Route extends AddressParametersHeader implements javax.sip.header.RouteHeader {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.965 -0400", hash_original_method = "B9CE287F547A57CF29833C977E422F42", hash_generated_method = "78BD04979B7BBC9CE0E7EF4486861FDE")
    public  Route() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.966 -0400", hash_original_method = "D97B9DA75E98466FFB5CFE28F884D630", hash_generated_method = "D5CA80DDFE0F9A7510EA0A6177493FB2")
    public  Route(AddressImpl address) {
        super(NAME);
        addTaint(address.getTaint());
        this.address = address;
        // ---------- Original Method ----------
        //this.address = address;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.966 -0400", hash_original_method = "42825E09BC1306330D357AEB56059051", hash_generated_method = "B6CF80FC48F773E75CDBA46AA563DFB5")
    public int hashCode() {
        int varA208F299EF1BEAF3A80941A2ED81F585_1788474111 = (this.address.getHostPort().encode().toLowerCase().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1368906510 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1368906510;
        // ---------- Original Method ----------
        //return this.address.getHostPort().encode().toLowerCase().hashCode();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.966 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "E1CD9821809761588E600943655E48FA")
    public String encodeBody() {
String varB9AAF3B320DC07C68A40DABE06BFAFD1_945942918 =         encodeBody(new StringBuffer()).toString();
        varB9AAF3B320DC07C68A40DABE06BFAFD1_945942918.addTaint(taint);
        return varB9AAF3B320DC07C68A40DABE06BFAFD1_945942918;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.967 -0400", hash_original_method = "2891D97F5EA93E20B16E0A9272FB4B2C", hash_generated_method = "615967868BB8C135E1D5CD1B87543313")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        addTaint(buffer.getTaint());
        boolean addrFlag = address.getAddressType() == AddressImpl.NAME_ADDR;
        if(!addrFlag)        
        {
            buffer.append('<');
            address.encode(buffer);
            buffer.append('>');
        } //End block
        else
        {
            address.encode(buffer);
        } //End block
        if(!parameters.isEmpty())        
        {
            buffer.append(SEMICOLON);
            parameters.encode(buffer);
        } //End block
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_258430181 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_258430181.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_258430181;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.967 -0400", hash_original_method = "53DB62040F48266C1BBF2CE5E963ACD1", hash_generated_method = "54EA2075341FCD8E75ECCB3B2140A8C3")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        boolean var20B181503EEA8D0904F4FC7CE22E73F0_544363153 = ((other instanceof RouteHeader) && super.equals(other));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1117426179 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1117426179;
        // ---------- Original Method ----------
        //return (other instanceof RouteHeader) && super.equals(other);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.967 -0400", hash_original_field = "24947308B97B96B5EB000D870A381219", hash_generated_field = "CDE0CEB85AD3435FE4139286512ECD09")

    private static final long serialVersionUID = 5683577362998368846L;
}

