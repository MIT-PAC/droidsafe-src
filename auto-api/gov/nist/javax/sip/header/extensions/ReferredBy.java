package gov.nist.javax.sip.header.extensions;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.ExtensionHeader;
import gov.nist.javax.sip.header.*;
import gov.nist.javax.sip.address.*;

public final class ReferredBy extends AddressParametersHeader implements ExtensionHeader, ReferredByHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.058 -0400", hash_original_method = "C3DEC8F418CE8BBD8D4ED1D7A2F51A12", hash_generated_method = "44B60B9435122CE6D895DDF9A9B319C3")
    public  ReferredBy() {
        super(NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.058 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.059 -0400", hash_original_method = "264DF371DD142B0CCD6F6ECE44A7BFB6", hash_generated_method = "3F856784577D68F063815F9F9DBD321B")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1303948878 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_296840262 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1303948878 = null;
        String retval = "";
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_117432978 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval += LESS_THAN;
            } 
        } 
        retval += address.encode();
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_710073104 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                retval += GREATER_THAN;
            } 
        } 
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_1358323999 = (!parameters.isEmpty());
            {
                retval += SEMICOLON + parameters.encode();
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_296840262 = retval;
        String varA7E53CE21691AB073D9660D615818899_726704741; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_726704741 = varB4EAC82CA7396A68D541C85D26508E83_1303948878;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_726704741 = varB4EAC82CA7396A68D541C85D26508E83_296840262;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_726704741.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_726704741;
        
        
            
        
        
            
        
        
        
            
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.059 -0400", hash_original_field = "2F10AFAED544B12D512EC416C57EE12B", hash_generated_field = "C1F49009315AF076AF05EE2867D3FDEF")

    private static final long serialVersionUID = 3134344915465784267L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.059 -0400", hash_original_field = "2B901D53AC9F4437C27DC11F24B6E7E9", hash_generated_field = "BAA3173ECCDDFD8B4EF4E90187540A3C")

    public static final String NAME = "Referred-By";
}

