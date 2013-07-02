package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import javax.sip.InvalidArgumentException;
import javax.sip.header.ExtensionHeader;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.AddressParametersHeader;

public class PServedUser extends AddressParametersHeader implements PServedUserHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.378 -0400", hash_original_method = "CE4E031625CF531C1B85FA453494B504", hash_generated_method = "D2CD9B450BEE17B2C8CB1F031EBB4B29")
    public  PServedUser(AddressImpl address) {
        super(P_SERVED_USER);
        this.address = address;
        addTaint(address.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.379 -0400", hash_original_method = "88679C40290AB234E035EF50535B4D0D", hash_generated_method = "9DF219AB55C86B79DEECEA502C213C52")
    public  PServedUser() {
        super(NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.379 -0400", hash_original_method = "060F42FFBCCB73E6969A6CFC80051047", hash_generated_method = "9FBD55DEA1C52B30EFCA721B0330FD49")
    public String getRegistrationState() {
        String varB4EAC82CA7396A68D541C85D26508E83_9813689 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_9813689 = getParameter(ParameterNamesIms.REGISTRATION_STATE);
        varB4EAC82CA7396A68D541C85D26508E83_9813689.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_9813689;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.380 -0400", hash_original_method = "86F2D3309EA08C107052AE36BBC425BC", hash_generated_method = "DCA71FB33F0034926CC9FE2B4DEE9C65")
    public String getSessionCase() {
        String varB4EAC82CA7396A68D541C85D26508E83_2136426955 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2136426955 = getParameter(ParameterNamesIms.SESSION_CASE);
        varB4EAC82CA7396A68D541C85D26508E83_2136426955.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2136426955;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.380 -0400", hash_original_method = "8A05E91630AB7D0557A40B65641F2C82", hash_generated_method = "251621AC48C49C79CC1CA0191A55DEEF")
    public void setRegistrationState(String registrationState) {
        {
            {
                boolean varBA8681E7A138FDBF12BDB0A2B4AEE0BD_1285158581 = (registrationState.equals("reg")||registrationState.equals("unreg"));
                {
                    try 
                    {
                        setParameter(ParameterNamesIms.REGISTRATION_STATE, registrationState);
                    } 
                    catch (ParseException e)
                    {
                        e.printStackTrace();
                    } 
                } 
                {
                    try 
                    {
                        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("Value can be either reg or unreg");
                    } 
                    catch (InvalidArgumentException e)
                    {
                        e.printStackTrace();
                    } 
                } 
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("regstate Parameter value is null");
        } 
        addTaint(registrationState.getTaint());
        
        
        
            
            
                
                    
                
                    
                
            
              
              
                  
                      
                  
                         
                    
              
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.381 -0400", hash_original_method = "B96D543F72B1B5850C059C4E8A513320", hash_generated_method = "263B6BAAD8F99E024821CB13CF90439B")
    public void setSessionCase(String sessionCase) {
        {
            {
                boolean var06E6B3A3543F32AF4A1823DD7B4D6730_682960406 = ((sessionCase.equals("orig"))||(sessionCase.equals("term")));
                {
                    try 
                    {
                        setParameter(ParameterNamesIms.SESSION_CASE, sessionCase);
                    } 
                    catch (ParseException e)
                    {
                        e.printStackTrace();
                    } 
                } 
                {
                    try 
                    {
                        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("Value can be either orig or term");
                    } 
                    catch (InvalidArgumentException e)
                    {
                        e.printStackTrace();
                    } 
                } 
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("sess-case Parameter value is null");
        } 
        addTaint(sessionCase.getTaint());
        
        
        
            
            
                
                    
                
                    
                
            
              
              
                  
                    
                
                    
                
              
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.383 -0400", hash_original_method = "5C1FD3ED8946938E44DEC9CB0584970B", hash_generated_method = "04A28D8EDBB3BB01A72F529834BC304E")
    @Override
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_793878631 = null; 
        StringBuffer retval = new StringBuffer();
        retval.append(address.encode());
        {
            boolean varD3C027666130F10CDC2A85B288EA20D6_504755769 = (parameters.containsKey(ParameterNamesIms.REGISTRATION_STATE));
            retval.append(SEMICOLON).append(ParameterNamesIms.REGISTRATION_STATE).append(EQUALS)
            .append(this.getRegistrationState());
        } 
        {
            boolean var441A52915CCC05FB5E68369C7AE68912_1610818283 = (parameters.containsKey(ParameterNamesIms.SESSION_CASE));
            retval.append(SEMICOLON).append(ParameterNamesIms.SESSION_CASE).append(EQUALS)
            .append(this.getSessionCase());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_793878631 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_793878631.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_793878631;
        
        
        
        
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.384 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.385 -0400", hash_original_method = "5DE7CF1B2BFD7CED31E376D58425CB92", hash_generated_method = "01C9CA8581F424BAD088E7D64B088400")
    public boolean equals(Object other) {
        {
            final PServedUserHeader psu = (PServedUserHeader)other;
            boolean varD89FCAB86EA829CE7D9EF46AFDFD7F15_1986976439 = (this.getAddress().equals(((PServedUser) other).getAddress()));
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1213463221 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1213463221;
        
        
         
            
            
         
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.388 -0400", hash_original_method = "E31F82669EB953245AD29DB03C98C513", hash_generated_method = "6998AD059ACE061F4EC0B3CF19167395")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_294809037 = null; 
        PServedUser retval = (PServedUser) super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_294809037 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_294809037.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_294809037;
        
        
        
    }

    
}

