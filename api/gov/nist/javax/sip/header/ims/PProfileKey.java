package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.AddressParametersHeader;
import javax.sip.header.ExtensionHeader;

public class PProfileKey extends AddressParametersHeader implements PProfileKeyHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.038 -0400", hash_original_method = "62A39FCB1E97FABE3CE56B88DF28D500", hash_generated_method = "6CF76ED268EA92EBF0466748DD23DF23")
    public  PProfileKey( ) {
        super(P_PROFILE_KEY);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.040 -0400", hash_original_method = "0A29E597AFEA61D9850CF327C87E8DD7", hash_generated_method = "C570B5BEC1FF37B1984D71F7A2DDF85E")
    public  PProfileKey(AddressImpl address) {
        super(NAME);
        addTaint(address.getTaint());
        this.address = address;
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.041 -0400", hash_original_method = "DD9AA0788424353442B0CFE218D97412", hash_generated_method = "CB6E31BE88EED5138842331B71DF0C18")
    @Override
    protected String encodeBody() {
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
String var1B324365A764C077A55854483509F4AB_1441635906 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_1441635906.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_1441635906;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.041 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "185A817A67F46A223ADEF56701CA816E")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_1011016062 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_1011016062.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_1011016062;
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.042 -0400", hash_original_method = "9C9266054F44A0CD7DB49784A3A7D69D", hash_generated_method = "AC8B689871BEDF1A90D4A812A78C9ABF")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        boolean var25F1D0958FB5ED2500C373724BBA1A92_931193135 = ((other instanceof PProfileKey) && super.equals(other));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_864519018 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_864519018;
        // ---------- Original Method ----------
        //return (other instanceof PProfileKey) && super.equals(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.043 -0400", hash_original_method = "38197786CF7CEF8229067A4B5205EC8C", hash_generated_method = "FC6FAFD99E235F3B2032709436086014")
    public Object clone() {
        PProfileKey retval = (PProfileKey) super.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_966995393 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_966995393.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_966995393;
        // ---------- Original Method ----------
        //PProfileKey retval = (PProfileKey) super.clone();
        //return retval;
    }

    
}

