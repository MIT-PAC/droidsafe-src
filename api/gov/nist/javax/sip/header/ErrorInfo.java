package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.GenericURI;

import java.text.ParseException;

import javax.sip.address.URI;
import javax.sip.header.ErrorInfoHeader;






public final class ErrorInfo extends ParametersHeader implements ErrorInfoHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.325 -0400", hash_original_field = "6B3E9CDFD9FD6B6F313D7DD4526C9CEB", hash_generated_field = "8F903FEA2C89EDECE455B9C7E7CF07FC")

    protected GenericURI errorInfo;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.325 -0400", hash_original_method = "E4884C80CFD3760FF481610C05E97D11", hash_generated_method = "79B25B6B953F6F9A24DA8C23D01FB1BE")
    public  ErrorInfo() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.326 -0400", hash_original_method = "5D4EAB69496BA6FC52162AB30D1BA363", hash_generated_method = "CE88C25A02D8DA66304F83D86F593A68")
    public  ErrorInfo(GenericURI errorInfo) {
        this();
        this.errorInfo = errorInfo;
        // ---------- Original Method ----------
        //this.errorInfo = errorInfo;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.326 -0400", hash_original_method = "2C75F11DE6E05BFA889C5ACE2D8E3910", hash_generated_method = "EA3D99D3B82C67EC5D41CF7ED84E3F7E")
    public String encodeBody() {
        StringBuffer retval = new StringBuffer(LESS_THAN).append(errorInfo.toString()).append(
                GREATER_THAN);
        if(!parameters.isEmpty())        
        {
            retval.append(SEMICOLON).append(parameters.encode());
        } //End block
String var1B324365A764C077A55854483509F4AB_610056486 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_610056486.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_610056486;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.327 -0400", hash_original_method = "BEF760DA2ED1BBF6FE66AFCF85F4B855", hash_generated_method = "ED9C70B309FE86559BBD1BE0632FAA86")
    public void setErrorInfo(javax.sip.address.URI errorInfo) {
        this.errorInfo = (GenericURI) errorInfo;
        // ---------- Original Method ----------
        //this.errorInfo = (GenericURI) errorInfo;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.328 -0400", hash_original_method = "4A04B5BB24A371C2D4F0F24F47A1F48A", hash_generated_method = "17852BC8309A691D6D7514F4311FD9FE")
    public URI getErrorInfo() {
URI var021E4EB39B1E88B2491D457272448852_2052455641 =         errorInfo;
        var021E4EB39B1E88B2491D457272448852_2052455641.addTaint(taint);
        return var021E4EB39B1E88B2491D457272448852_2052455641;
        // ---------- Original Method ----------
        //return errorInfo;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.328 -0400", hash_original_method = "E1313AE37E1C05DA9102D36DED16DFCA", hash_generated_method = "4EDE9F73ED5E34CDB840B4CFC1570B53")
    public void setErrorMessage(String message) throws ParseException {
        addTaint(message.getTaint());
        if(message == null)        
        {
        NullPointerException varCBE7726BDB9B215187BFAC7B19EFD28D_1887627731 = new NullPointerException(
                "JAIN-SIP Exception "
                    + ", ErrorInfoHeader, setErrorMessage(), the message parameter is null");
        varCBE7726BDB9B215187BFAC7B19EFD28D_1887627731.addTaint(taint);
        throw varCBE7726BDB9B215187BFAC7B19EFD28D_1887627731;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.329 -0400", hash_original_method = "9D1A3E324FFC9C131D1ACF2EBA93FC69", hash_generated_method = "AC7721380A98C08CB6CD60971FBB0E45")
    public String getErrorMessage() {
String varFB16D2563678484D86210B93F6825F69_1982573181 =         getParameter("message");
        varFB16D2563678484D86210B93F6825F69_1982573181.addTaint(taint);
        return varFB16D2563678484D86210B93F6825F69_1982573181;
        // ---------- Original Method ----------
        //return getParameter("message");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.329 -0400", hash_original_method = "251926555E92C7CD7D27CA2FB451752B", hash_generated_method = "BCA23D80D71FF8DF2802A82856584278")
    public Object clone() {
        ErrorInfo retval = (ErrorInfo) super.clone();
        if(this.errorInfo != null)        
        retval.errorInfo = (GenericURI) this.errorInfo.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_1681943041 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1681943041.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1681943041;
        // ---------- Original Method ----------
        //ErrorInfo retval = (ErrorInfo) super.clone();
        //if (this.errorInfo != null)
            //retval.errorInfo = (GenericURI) this.errorInfo.clone();
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.329 -0400", hash_original_field = "CA0A0263C05CE17B2E01A22B3FD416DD", hash_generated_field = "9BD0FFEC94B76824606332C7C1A80F81")

    private static final long serialVersionUID = -6347702901964436362L;
}

