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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.263 -0400", hash_original_method = "62A39FCB1E97FABE3CE56B88DF28D500", hash_generated_method = "6CF76ED268EA92EBF0466748DD23DF23")
    public  PProfileKey( ) {
        super(P_PROFILE_KEY);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.263 -0400", hash_original_method = "0A29E597AFEA61D9850CF327C87E8DD7", hash_generated_method = "C570B5BEC1FF37B1984D71F7A2DDF85E")
    public  PProfileKey(AddressImpl address) {
        super(NAME);
        addTaint(address.getTaint());
        this.address = address;
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.264 -0400", hash_original_method = "DD9AA0788424353442B0CFE218D97412", hash_generated_method = "D18820F616D6A193DEBF6B61969A4626")
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
String var1B324365A764C077A55854483509F4AB_597889478 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_597889478.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_597889478;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.265 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "C61648CCEBEC592B96579753DF9E137B")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_2086555117 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_2086555117.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_2086555117;
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.265 -0400", hash_original_method = "9C9266054F44A0CD7DB49784A3A7D69D", hash_generated_method = "95B2E950AEFA721261B8E91A852D85C0")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        boolean var25F1D0958FB5ED2500C373724BBA1A92_1128572666 = ((other instanceof PProfileKey) && super.equals(other));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_411558285 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_411558285;
        // ---------- Original Method ----------
        //return (other instanceof PProfileKey) && super.equals(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.266 -0400", hash_original_method = "38197786CF7CEF8229067A4B5205EC8C", hash_generated_method = "33275C3EEB341DAD849BCA596CBAEDE2")
    public Object clone() {
        PProfileKey retval = (PProfileKey) super.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_1456382681 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1456382681.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1456382681;
        // ---------- Original Method ----------
        //PProfileKey retval = (PProfileKey) super.clone();
        //return retval;
    }

    
}

