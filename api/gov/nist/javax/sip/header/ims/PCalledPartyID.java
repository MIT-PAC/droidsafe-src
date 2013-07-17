package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.header.ExtensionHeader;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.ims.PCalledPartyIDHeader;

public class PCalledPartyID extends gov.nist.javax.sip.header.AddressParametersHeader implements PCalledPartyIDHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.125 -0400", hash_original_method = "EDC402C5990746AE150AF00BD84032F6", hash_generated_method = "D9664EE33C8B96C805728CCB2FF4B2BE")
    public  PCalledPartyID(AddressImpl address) {
        super(NAME);
        addTaint(address.getTaint());
        this.address = address;
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.126 -0400", hash_original_method = "D34D544F1730F850E33368222A05354C", hash_generated_method = "49A3F9AF22422791AFB5269749C297FA")
    public  PCalledPartyID() {
        super(CALLED_PARTY_ID);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.126 -0400", hash_original_method = "DD9AA0788424353442B0CFE218D97412", hash_generated_method = "CC7844458163CBDED05DB5FCAEFB776C")
    public String encodeBody() {
        StringBuffer retval = new StringBuffer();
        if(address.getAddressType() == AddressImpl.ADDRESS_SPEC)        
        {
            retval.append(LESS_THAN);
        } //End block
        retval.append(address.encode());
        if(address.getAddressType() == AddressImpl.ADDRESS_SPEC)        
        {
            retval.append(GREATER_THAN);
        } //End block
        if(!parameters.isEmpty())        
        retval.append(SEMICOLON + this.parameters.encode());
String var1B324365A764C077A55854483509F4AB_868707911 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_868707911.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_868707911;
        // ---------- Original Method ----------
        //StringBuffer retval = new StringBuffer();
        //if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            //retval.append(LESS_THAN);
        //}
        //retval.append(address.encode());
        //if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            //retval.append(GREATER_THAN);
        //}
        //if (!parameters.isEmpty())
            //retval.append(SEMICOLON + this.parameters.encode());
        //return retval.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.127 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "11777646B03BD4A57DBCD76AF161C0E3")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_1351479295 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_1351479295.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_1351479295;
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
}

