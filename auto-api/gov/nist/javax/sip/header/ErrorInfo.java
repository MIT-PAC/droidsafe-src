package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.address.*;
import javax.sip.header.*;
import javax.sip.address.*;
import java.text.ParseException;

public final class ErrorInfo extends ParametersHeader implements ErrorInfoHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.920 -0400", hash_original_field = "6B3E9CDFD9FD6B6F313D7DD4526C9CEB", hash_generated_field = "8F903FEA2C89EDECE455B9C7E7CF07FC")

    protected GenericURI errorInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.921 -0400", hash_original_method = "E4884C80CFD3760FF481610C05E97D11", hash_generated_method = "79B25B6B953F6F9A24DA8C23D01FB1BE")
    public  ErrorInfo() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.921 -0400", hash_original_method = "5D4EAB69496BA6FC52162AB30D1BA363", hash_generated_method = "CE88C25A02D8DA66304F83D86F593A68")
    public  ErrorInfo(GenericURI errorInfo) {
        this();
        this.errorInfo = errorInfo;
        // ---------- Original Method ----------
        //this.errorInfo = errorInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.922 -0400", hash_original_method = "2C75F11DE6E05BFA889C5ACE2D8E3910", hash_generated_method = "6DEE8CE898BBF2E6D726C8B688982B9B")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1245828211 = null; //Variable for return #1
        StringBuffer retval;
        retval = new StringBuffer(LESS_THAN).append(errorInfo.toString()).append(
                GREATER_THAN);
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_447445601 = (!parameters.isEmpty());
            {
                retval.append(SEMICOLON).append(parameters.encode());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1245828211 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1245828211.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1245828211;
        // ---------- Original Method ----------
        //StringBuffer retval =
            //new StringBuffer(LESS_THAN).append(errorInfo.toString()).append(
                //GREATER_THAN);
        //if (!parameters.isEmpty()) {
            //retval.append(SEMICOLON).append(parameters.encode());
        //}
        //return retval.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.923 -0400", hash_original_method = "BEF760DA2ED1BBF6FE66AFCF85F4B855", hash_generated_method = "ED9C70B309FE86559BBD1BE0632FAA86")
    public void setErrorInfo(javax.sip.address.URI errorInfo) {
        this.errorInfo = (GenericURI) errorInfo;
        // ---------- Original Method ----------
        //this.errorInfo = (GenericURI) errorInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.928 -0400", hash_original_method = "4A04B5BB24A371C2D4F0F24F47A1F48A", hash_generated_method = "43C346E4C26869E6F0A03D445363DF8F")
    public URI getErrorInfo() {
        URI varB4EAC82CA7396A68D541C85D26508E83_1352775809 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1352775809 = errorInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1352775809.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1352775809;
        // ---------- Original Method ----------
        //return errorInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.931 -0400", hash_original_method = "E1313AE37E1C05DA9102D36DED16DFCA", hash_generated_method = "6F55BA99641FD4C7B6C77CA18917506C")
    public void setErrorMessage(String message) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception "
                    + ", ErrorInfoHeader, setErrorMessage(), the message parameter is null");
        setParameter("message", message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //if (message == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception "
                    //+ ", ErrorInfoHeader, setErrorMessage(), the message parameter is null");
        //setParameter("message", message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.941 -0400", hash_original_method = "9D1A3E324FFC9C131D1ACF2EBA93FC69", hash_generated_method = "58165C6B15CF8DC1F53A274479911BA5")
    public String getErrorMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_583574248 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_583574248 = getParameter("message");
        varB4EAC82CA7396A68D541C85D26508E83_583574248.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_583574248;
        // ---------- Original Method ----------
        //return getParameter("message");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.942 -0400", hash_original_method = "251926555E92C7CD7D27CA2FB451752B", hash_generated_method = "A092CA7BF00F1D404074D37E320324DD")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_749403619 = null; //Variable for return #1
        ErrorInfo retval;
        retval = (ErrorInfo) super.clone();
        retval.errorInfo = (GenericURI) this.errorInfo.clone();
        varB4EAC82CA7396A68D541C85D26508E83_749403619 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_749403619.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_749403619;
        // ---------- Original Method ----------
        //ErrorInfo retval = (ErrorInfo) super.clone();
        //if (this.errorInfo != null)
            //retval.errorInfo = (GenericURI) this.errorInfo.clone();
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.942 -0400", hash_original_field = "CA0A0263C05CE17B2E01A22B3FD416DD", hash_generated_field = "A0B55A3D5DB4F967B6F23F3F6FA2D4EF")

    private static long serialVersionUID = -6347702901964436362L;
}

