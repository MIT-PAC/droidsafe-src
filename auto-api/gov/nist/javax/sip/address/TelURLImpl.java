package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.NameValueList;
import java.text.ParseException;
import java.util.Iterator;

public class TelURLImpl extends GenericURI implements javax.sip.address.TelURL {
    protected TelephoneNumber telephoneNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.495 -0400", hash_original_method = "C17135FC5CC76AEB5F88156629F51796", hash_generated_method = "377BA745CD46D0E73B14510DE7FBBCEB")
    @DSModeled(DSC.SAFE)
    public TelURLImpl() {
        this.scheme = "tel";
        // ---------- Original Method ----------
        //this.scheme = "tel";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.495 -0400", hash_original_method = "C9EB332176FD96276A0692D7B71B3B1C", hash_generated_method = "226821C27CD5A82B5264731571F5FEA8")
    @DSModeled(DSC.SAFE)
    public void setTelephoneNumber(TelephoneNumber telephoneNumber) {
        dsTaint.addTaint(telephoneNumber.dsTaint);
        // ---------- Original Method ----------
        //this.telephoneNumber = telephoneNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.495 -0400", hash_original_method = "7749933BE9F1A8F770924BE8E0DD80B2", hash_generated_method = "C5153BBCA2413B94FD32C5C207F6336F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getIsdnSubAddress() {
        String var3ED27DC7AD71D612D2219CB8E38ED5B3_981392797 = (telephoneNumber.getIsdnSubaddress());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return telephoneNumber.getIsdnSubaddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.495 -0400", hash_original_method = "A07C64D3F1CC8848A39F332213EC7E5C", hash_generated_method = "C24FA9342815376314FB2BE9212830CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPostDial() {
        String var4337340298185494DBCAC31A7CEC661D_1534789755 = (telephoneNumber.getPostDial());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return telephoneNumber.getPostDial();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.496 -0400", hash_original_method = "76031D31C1CA528B8F038117D6808811", hash_generated_method = "BC31174F828F19811FA9B66B1F89A31F")
    @DSModeled(DSC.SAFE)
    public String getScheme() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.496 -0400", hash_original_method = "95ED443083D9E3C79BD9C6E46A138264", hash_generated_method = "406369E40E8A8114D3C24BD65B7F1CCD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isGlobal() {
        boolean var3B04E747E259CDF442AD9B897405BD8B_1211443793 = (telephoneNumber.isGlobal());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return telephoneNumber.isGlobal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.496 -0400", hash_original_method = "317E4D17172E12E605B8E6C02B3A9523", hash_generated_method = "F348D443F4C679F355E8EE25DEC5587F")
    @DSModeled(DSC.SAFE)
    public boolean isSipURI() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.496 -0400", hash_original_method = "EE86C87982E4E6CE462C2F1CF12245F2", hash_generated_method = "3499CFC233BFB1A1A7585A9AE21EFC04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setGlobal(boolean global) {
        dsTaint.addTaint(global);
        this.telephoneNumber.setGlobal(global);
        // ---------- Original Method ----------
        //this.telephoneNumber.setGlobal(global);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.496 -0400", hash_original_method = "122F825A7097C68E3CD71E8CD7DD2208", hash_generated_method = "FF39F2C9EF7C267D06B792974D5213A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIsdnSubAddress(String isdnSubAddress) {
        dsTaint.addTaint(isdnSubAddress);
        this.telephoneNumber.setIsdnSubaddress(isdnSubAddress);
        // ---------- Original Method ----------
        //this.telephoneNumber.setIsdnSubaddress(isdnSubAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.496 -0400", hash_original_method = "19BDC1422936CE8CD2446692653D846C", hash_generated_method = "3838D3672853F9E6818B0F1FDECEB1A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPostDial(String postDial) {
        dsTaint.addTaint(postDial);
        this.telephoneNumber.setPostDial(postDial);
        // ---------- Original Method ----------
        //this.telephoneNumber.setPostDial(postDial);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.496 -0400", hash_original_method = "57F725D8D07902BEB47C996DF34801CB", hash_generated_method = "4D040107593478A70E8EFA2A021693F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPhoneNumber(String telephoneNumber) {
        dsTaint.addTaint(telephoneNumber);
        this.telephoneNumber.setPhoneNumber(telephoneNumber);
        // ---------- Original Method ----------
        //this.telephoneNumber.setPhoneNumber(telephoneNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.497 -0400", hash_original_method = "9932D29BF514A34CC6953B51ADDD0B1C", hash_generated_method = "58029864ECBB0841694DEC7A683BF91F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPhoneNumber() {
        String var438469B98C5C15F85C605213A56FA5B1_1503371340 = (this.telephoneNumber.getPhoneNumber());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.telephoneNumber.getPhoneNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.497 -0400", hash_original_method = "5EC62A2B879CA2B5D87DB46D668C10E0", hash_generated_method = "E30BA586665ED66DB8DD9192582902F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String varFE3AF7992E70903282496441DF1563E0_175411286 = (this.scheme + ":" + telephoneNumber.encode());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.scheme + ":" + telephoneNumber.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.497 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "A3E80BE974BC4F084B2D5A0B3F6DC2CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encode() {
        String varFFB45C40AF627644780ECFF5921CFE15_1690770045 = (encode(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.497 -0400", hash_original_method = "CF877865ECD493DE460A284390F03152", hash_generated_method = "7DC217F8E04DD82307D0FEE739FC76B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer encode(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        buffer.append(this.scheme).append(':');
        telephoneNumber.encode(buffer);
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //buffer.append(this.scheme).append(':');
        //telephoneNumber.encode(buffer);
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.497 -0400", hash_original_method = "6B8A416F4757BDF00BB53E081B0C9027", hash_generated_method = "16D7B6561851DFC04C6B1A8FDDAC5F01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        TelURLImpl retval;
        retval = (TelURLImpl) super.clone();
        retval.telephoneNumber = (TelephoneNumber) this.telephoneNumber.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //TelURLImpl retval = (TelURLImpl) super.clone();
        //if (this.telephoneNumber != null)
            //retval.telephoneNumber = (TelephoneNumber) this.telephoneNumber.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.497 -0400", hash_original_method = "7FADC9FB5FA5B5E8B9D3FF343952F7D6", hash_generated_method = "C59C405E6EFC1EB3AC0F46116CFD4057")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getParameter(String parameterName) {
        dsTaint.addTaint(parameterName);
        String varAB5C8C65A149857B927B01A3BD735A6C_266223169 = (telephoneNumber.getParameter(parameterName));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return telephoneNumber.getParameter(parameterName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.498 -0400", hash_original_method = "7B12A3BFEAC170D72CC4E531FEDC5259", hash_generated_method = "D3FE672C7D69F60E04A4072A1EE491C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setParameter(String name, String value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        telephoneNumber.setParameter(name, value);
        // ---------- Original Method ----------
        //telephoneNumber.setParameter(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.498 -0400", hash_original_method = "9F3A3B5343A94A5C27FE8CB7C132960C", hash_generated_method = "9731212AA9B63D8BFEFBB24F614A0427")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Iterator<String> getParameterNames() {
        Iterator<String> varA0971CFB915D8FA62B8FA991C1905768_386426201 = (telephoneNumber.getParameterNames());
        return (Iterator<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return telephoneNumber.getParameterNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.498 -0400", hash_original_method = "9F42A8DF83D29C58CCE55D9B05B30108", hash_generated_method = "61945966295AAF6E51CF9663A77B3110")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NameValueList getParameters() {
        NameValueList var1F6590D77C07364B4A7134E4758C03F8_769595695 = (telephoneNumber.getParameters());
        return (NameValueList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return telephoneNumber.getParameters();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.498 -0400", hash_original_method = "7A5BAA5627804B12C2CD072560767D2A", hash_generated_method = "9E550AC9BD312EFFFB66E02C26B0A366")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeParameter(String name) {
        dsTaint.addTaint(name);
        telephoneNumber.removeParameter(name);
        // ---------- Original Method ----------
        //telephoneNumber.removeParameter(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.498 -0400", hash_original_method = "601A60F168280AF8DB609489286F142F", hash_generated_method = "E8692FEE58C68C55EDCFCE3BED4BF1BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPhoneContext(String phoneContext) throws ParseException {
        dsTaint.addTaint(phoneContext);
        {
            this.removeParameter("phone-context");
        } //End block
        {
            this.setParameter("phone-context",phoneContext);
        } //End block
        // ---------- Original Method ----------
        //if (phoneContext==null) {
            //this.removeParameter("phone-context");
        //} else {
            //this.setParameter("phone-context",phoneContext);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.498 -0400", hash_original_method = "E99D05466523D70C189436EBEEC64347", hash_generated_method = "D8ABE1DD770EA523169164FC33B15E91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPhoneContext() {
        String var4F42B1A28930C8652CCCC883B81DC47A_231329285 = (this.getParameter("phone-context"));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.getParameter("phone-context");
    }

    
    private static final long serialVersionUID = 5873527320305915954L;
}

