package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.AddressParametersHeader;
import javax.sip.header.ExtensionHeader;

public class PProfileKey extends AddressParametersHeader implements PProfileKeyHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.364 -0400", hash_original_method = "62A39FCB1E97FABE3CE56B88DF28D500", hash_generated_method = "6CF76ED268EA92EBF0466748DD23DF23")
    public  PProfileKey( ) {
        super(P_PROFILE_KEY);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.364 -0400", hash_original_method = "0A29E597AFEA61D9850CF327C87E8DD7", hash_generated_method = "02F88E63386430911094E035542C5A35")
    public  PProfileKey(AddressImpl address) {
        super(NAME);
        this.address = address;
        addTaint(address.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.365 -0400", hash_original_method = "DD9AA0788424353442B0CFE218D97412", hash_generated_method = "C8278E6736D42675C90BC406A1F8E086")
    @Override
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1825202416 = null; 
        StringBuffer retval = new StringBuffer();
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_408683604 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(LESS_THAN);
            } 
        } 
        retval.append(address.encode());
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_1056307750 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval.append(GREATER_THAN);
            } 
        } 
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_408850279 = (!parameters.isEmpty());
            retval.append(SEMICOLON + this.parameters.encode());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1825202416 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1825202416.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1825202416;
        
        
        
            
        
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.366 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.366 -0400", hash_original_method = "9C9266054F44A0CD7DB49784A3A7D69D", hash_generated_method = "D508B689B22FF71C1E781462E86809C6")
    public boolean equals(Object other) {
        boolean varCA4B4D302580B6347E8C5820870B3AF3_1828827842 = ((other instanceof PProfileKey) && super.equals(other));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_303665295 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_303665295;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.366 -0400", hash_original_method = "38197786CF7CEF8229067A4B5205EC8C", hash_generated_method = "D65B12094CC83ED71F37C86C85BE697C")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_544175699 = null; 
        PProfileKey retval = (PProfileKey) super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_544175699 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_544175699.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_544175699;
        
        
        
    }

    
}

