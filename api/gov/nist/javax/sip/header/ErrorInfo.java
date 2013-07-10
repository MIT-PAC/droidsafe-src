package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.address.*;
import javax.sip.header.*;
import javax.sip.address.*;
import java.text.ParseException;

public final class ErrorInfo extends ParametersHeader implements ErrorInfoHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.477 -0400", hash_original_field = "6B3E9CDFD9FD6B6F313D7DD4526C9CEB", hash_generated_field = "8F903FEA2C89EDECE455B9C7E7CF07FC")

    protected GenericURI errorInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.478 -0400", hash_original_method = "E4884C80CFD3760FF481610C05E97D11", hash_generated_method = "79B25B6B953F6F9A24DA8C23D01FB1BE")
    public  ErrorInfo() {
        super(NAME);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.478 -0400", hash_original_method = "5D4EAB69496BA6FC52162AB30D1BA363", hash_generated_method = "CE88C25A02D8DA66304F83D86F593A68")
    public  ErrorInfo(GenericURI errorInfo) {
        this();
        this.errorInfo = errorInfo;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.479 -0400", hash_original_method = "2C75F11DE6E05BFA889C5ACE2D8E3910", hash_generated_method = "4E87788128D5C8157EFB2DF35366ED90")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_767322424 = null; 
        StringBuffer retval = new StringBuffer(LESS_THAN).append(errorInfo.toString()).append(
                GREATER_THAN);
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_1866345039 = (!parameters.isEmpty());
            {
                retval.append(SEMICOLON).append(parameters.encode());
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_767322424 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_767322424.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_767322424;
        
        
            
                
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.479 -0400", hash_original_method = "BEF760DA2ED1BBF6FE66AFCF85F4B855", hash_generated_method = "ED9C70B309FE86559BBD1BE0632FAA86")
    public void setErrorInfo(javax.sip.address.URI errorInfo) {
        this.errorInfo = (GenericURI) errorInfo;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.480 -0400", hash_original_method = "4A04B5BB24A371C2D4F0F24F47A1F48A", hash_generated_method = "390E57993E065A0C134DC3A0339CD396")
    public URI getErrorInfo() {
        URI varB4EAC82CA7396A68D541C85D26508E83_490870097 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_490870097 = errorInfo;
        varB4EAC82CA7396A68D541C85D26508E83_490870097.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_490870097;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.481 -0400", hash_original_method = "E1313AE37E1C05DA9102D36DED16DFCA", hash_generated_method = "6F55BA99641FD4C7B6C77CA18917506C")
    public void setErrorMessage(String message) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception "
                    + ", ErrorInfoHeader, setErrorMessage(), the message parameter is null");
        setParameter("message", message);
        addTaint(message.getTaint());
        
        
            
                
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.482 -0400", hash_original_method = "9D1A3E324FFC9C131D1ACF2EBA93FC69", hash_generated_method = "1166B5BD54F911309DDE9EF928EFAF2F")
    public String getErrorMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_931920401 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_931920401 = getParameter("message");
        varB4EAC82CA7396A68D541C85D26508E83_931920401.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_931920401;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.483 -0400", hash_original_method = "251926555E92C7CD7D27CA2FB451752B", hash_generated_method = "D4F43D13D2530D95A2A997648355DDAF")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_636626183 = null; 
        ErrorInfo retval = (ErrorInfo) super.clone();
        retval.errorInfo = (GenericURI) this.errorInfo.clone();
        varB4EAC82CA7396A68D541C85D26508E83_636626183 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_636626183.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_636626183;
        
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.483 -0400", hash_original_field = "CA0A0263C05CE17B2E01A22B3FD416DD", hash_generated_field = "9BD0FFEC94B76824606332C7C1A80F81")

    private static final long serialVersionUID = -6347702901964436362L;
}

