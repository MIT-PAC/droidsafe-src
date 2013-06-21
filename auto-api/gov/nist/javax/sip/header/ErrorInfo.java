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
    protected GenericURI errorInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.921 -0400", hash_original_method = "E4884C80CFD3760FF481610C05E97D11", hash_generated_method = "79B25B6B953F6F9A24DA8C23D01FB1BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ErrorInfo() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.921 -0400", hash_original_method = "5D4EAB69496BA6FC52162AB30D1BA363", hash_generated_method = "AC9A0BF4FD0D778BC75006716D96B87F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ErrorInfo(GenericURI errorInfo) {
        this();
        dsTaint.addTaint(errorInfo.dsTaint);
        // ---------- Original Method ----------
        //this.errorInfo = errorInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.921 -0400", hash_original_method = "2C75F11DE6E05BFA889C5ACE2D8E3910", hash_generated_method = "F1544C659900F05204FA324066B22BA1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        StringBuffer retval;
        retval = new StringBuffer(LESS_THAN).append(errorInfo.toString()).append(
                GREATER_THAN);
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_1088317546 = (!parameters.isEmpty());
            {
                retval.append(SEMICOLON).append(parameters.encode());
            } //End block
        } //End collapsed parenthetic
        String var0F1F65BA89BF920BA1A29FC87F91B969_1001699752 = (retval.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuffer retval =
            //new StringBuffer(LESS_THAN).append(errorInfo.toString()).append(
                //GREATER_THAN);
        //if (!parameters.isEmpty()) {
            //retval.append(SEMICOLON).append(parameters.encode());
        //}
        //return retval.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.922 -0400", hash_original_method = "BEF760DA2ED1BBF6FE66AFCF85F4B855", hash_generated_method = "B81D49AE07216A31D511045FB3D5E46F")
    @DSModeled(DSC.SAFE)
    public void setErrorInfo(javax.sip.address.URI errorInfo) {
        dsTaint.addTaint(errorInfo.dsTaint);
        this.errorInfo = (GenericURI) errorInfo;
        // ---------- Original Method ----------
        //this.errorInfo = (GenericURI) errorInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.922 -0400", hash_original_method = "4A04B5BB24A371C2D4F0F24F47A1F48A", hash_generated_method = "51FFF107B913DCAFE90F5A8519D258E0")
    @DSModeled(DSC.SAFE)
    public URI getErrorInfo() {
        return (URI)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return errorInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.922 -0400", hash_original_method = "E1313AE37E1C05DA9102D36DED16DFCA", hash_generated_method = "3A3BD4CFB70CB1A96C514F55E4D2EA05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setErrorMessage(String message) throws ParseException {
        dsTaint.addTaint(message);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception "
                    + ", ErrorInfoHeader, setErrorMessage(), the message parameter is null");
        setParameter("message", message);
        // ---------- Original Method ----------
        //if (message == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception "
                    //+ ", ErrorInfoHeader, setErrorMessage(), the message parameter is null");
        //setParameter("message", message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.922 -0400", hash_original_method = "9D1A3E324FFC9C131D1ACF2EBA93FC69", hash_generated_method = "606EAF6E96AC5EB17D1644E621CBFBFF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getErrorMessage() {
        String varFE0553B6B04CA34E72B223F5E9BDA200_1107724386 = (getParameter("message"));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter("message");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.922 -0400", hash_original_method = "251926555E92C7CD7D27CA2FB451752B", hash_generated_method = "75751D5C33C98723CE0C93A26F2B5231")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        ErrorInfo retval;
        retval = (ErrorInfo) super.clone();
        retval.errorInfo = (GenericURI) this.errorInfo.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ErrorInfo retval = (ErrorInfo) super.clone();
        //if (this.errorInfo != null)
            //retval.errorInfo = (GenericURI) this.errorInfo.clone();
        //return retval;
    }

    
    private static final long serialVersionUID = -6347702901964436362L;
}

