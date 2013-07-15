package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.address.*;
import javax.sip.header.*;
import javax.sip.address.*;
import java.text.ParseException;

public final class ErrorInfo extends ParametersHeader implements ErrorInfoHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.334 -0400", hash_original_field = "6B3E9CDFD9FD6B6F313D7DD4526C9CEB", hash_generated_field = "8F903FEA2C89EDECE455B9C7E7CF07FC")

    protected GenericURI errorInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.334 -0400", hash_original_method = "E4884C80CFD3760FF481610C05E97D11", hash_generated_method = "79B25B6B953F6F9A24DA8C23D01FB1BE")
    public  ErrorInfo() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.334 -0400", hash_original_method = "5D4EAB69496BA6FC52162AB30D1BA363", hash_generated_method = "CE88C25A02D8DA66304F83D86F593A68")
    public  ErrorInfo(GenericURI errorInfo) {
        this();
        this.errorInfo = errorInfo;
        // ---------- Original Method ----------
        //this.errorInfo = errorInfo;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.335 -0400", hash_original_method = "2C75F11DE6E05BFA889C5ACE2D8E3910", hash_generated_method = "CECBDD8EA9899E12931BB1E8F9D12180")
    public String encodeBody() {
        StringBuffer retval = new StringBuffer(LESS_THAN).append(errorInfo.toString()).append(
                GREATER_THAN);
    if(!parameters.isEmpty())        
        {
            retval.append(SEMICOLON).append(parameters.encode());
        } //End block
String var1B324365A764C077A55854483509F4AB_434604880 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_434604880.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_434604880;
        // ---------- Original Method ----------
        //StringBuffer retval =
            //new StringBuffer(LESS_THAN).append(errorInfo.toString()).append(
                //GREATER_THAN);
        //if (!parameters.isEmpty()) {
            //retval.append(SEMICOLON).append(parameters.encode());
        //}
        //return retval.toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.335 -0400", hash_original_method = "BEF760DA2ED1BBF6FE66AFCF85F4B855", hash_generated_method = "ED9C70B309FE86559BBD1BE0632FAA86")
    public void setErrorInfo(javax.sip.address.URI errorInfo) {
        this.errorInfo = (GenericURI) errorInfo;
        // ---------- Original Method ----------
        //this.errorInfo = (GenericURI) errorInfo;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.335 -0400", hash_original_method = "4A04B5BB24A371C2D4F0F24F47A1F48A", hash_generated_method = "D6A51E524352A4B5957CB99D1C532914")
    public URI getErrorInfo() {
URI var021E4EB39B1E88B2491D457272448852_934111667 =         errorInfo;
        var021E4EB39B1E88B2491D457272448852_934111667.addTaint(taint);
        return var021E4EB39B1E88B2491D457272448852_934111667;
        // ---------- Original Method ----------
        //return errorInfo;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.336 -0400", hash_original_method = "E1313AE37E1C05DA9102D36DED16DFCA", hash_generated_method = "52E59CF13D9F56170D0D31E9F8E17E6A")
    public void setErrorMessage(String message) throws ParseException {
        addTaint(message.getTaint());
    if(message == null)        
        {
        NullPointerException varCBE7726BDB9B215187BFAC7B19EFD28D_2022662707 = new NullPointerException(
                "JAIN-SIP Exception "
                    + ", ErrorInfoHeader, setErrorMessage(), the message parameter is null");
        varCBE7726BDB9B215187BFAC7B19EFD28D_2022662707.addTaint(taint);
        throw varCBE7726BDB9B215187BFAC7B19EFD28D_2022662707;
        }
        setParameter("message", message);
        // ---------- Original Method ----------
        //if (message == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception "
                    //+ ", ErrorInfoHeader, setErrorMessage(), the message parameter is null");
        //setParameter("message", message);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.336 -0400", hash_original_method = "9D1A3E324FFC9C131D1ACF2EBA93FC69", hash_generated_method = "FB322CB2A4F042B93FAC57293896374B")
    public String getErrorMessage() {
String varFB16D2563678484D86210B93F6825F69_538626191 =         getParameter("message");
        varFB16D2563678484D86210B93F6825F69_538626191.addTaint(taint);
        return varFB16D2563678484D86210B93F6825F69_538626191;
        // ---------- Original Method ----------
        //return getParameter("message");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.337 -0400", hash_original_method = "251926555E92C7CD7D27CA2FB451752B", hash_generated_method = "629281C4F302CEF93F2B6F43BE4B5CCE")
    public Object clone() {
        ErrorInfo retval = (ErrorInfo) super.clone();
    if(this.errorInfo != null)        
        retval.errorInfo = (GenericURI) this.errorInfo.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_1802502277 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1802502277.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1802502277;
        // ---------- Original Method ----------
        //ErrorInfo retval = (ErrorInfo) super.clone();
        //if (this.errorInfo != null)
            //retval.errorInfo = (GenericURI) this.errorInfo.clone();
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.337 -0400", hash_original_field = "CA0A0263C05CE17B2E01A22B3FD416DD", hash_generated_field = "9BD0FFEC94B76824606332C7C1A80F81")

    private static final long serialVersionUID = -6347702901964436362L;
}

