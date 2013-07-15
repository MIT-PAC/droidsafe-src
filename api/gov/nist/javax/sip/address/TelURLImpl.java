package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.NameValueList;
import java.text.ParseException;
import java.util.Iterator;

public class TelURLImpl extends GenericURI implements javax.sip.address.TelURL {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.368 -0400", hash_original_field = "DE1DEE97B96CF71ACE169ADA317301A5", hash_generated_field = "A24B43E0CC935DC17A1CF71DA4A58F34")

    protected TelephoneNumber telephoneNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.368 -0400", hash_original_method = "C17135FC5CC76AEB5F88156629F51796", hash_generated_method = "377BA745CD46D0E73B14510DE7FBBCEB")
    public  TelURLImpl() {
        this.scheme = "tel";
        // ---------- Original Method ----------
        //this.scheme = "tel";
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.375 -0400", hash_original_method = "C9EB332176FD96276A0692D7B71B3B1C", hash_generated_method = "D0138740D84BA72C2DE0294C938C714D")
    public void setTelephoneNumber(TelephoneNumber telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        // ---------- Original Method ----------
        //this.telephoneNumber = telephoneNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.376 -0400", hash_original_method = "7749933BE9F1A8F770924BE8E0DD80B2", hash_generated_method = "18EEBD56D9EDB2F914A8BEF9E0BFA1DE")
    public String getIsdnSubAddress() {
String var172B27340AEC7A96C98F43E2188CFB2E_1249627745 =         telephoneNumber.getIsdnSubaddress();
        var172B27340AEC7A96C98F43E2188CFB2E_1249627745.addTaint(taint);
        return var172B27340AEC7A96C98F43E2188CFB2E_1249627745;
        // ---------- Original Method ----------
        //return telephoneNumber.getIsdnSubaddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.377 -0400", hash_original_method = "A07C64D3F1CC8848A39F332213EC7E5C", hash_generated_method = "342F8D9796D44F753618EAB704DA605B")
    public String getPostDial() {
String varA33BA7A023A959AD044A6D5D34B61AD7_1884051136 =         telephoneNumber.getPostDial();
        varA33BA7A023A959AD044A6D5D34B61AD7_1884051136.addTaint(taint);
        return varA33BA7A023A959AD044A6D5D34B61AD7_1884051136;
        // ---------- Original Method ----------
        //return telephoneNumber.getPostDial();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.378 -0400", hash_original_method = "76031D31C1CA528B8F038117D6808811", hash_generated_method = "41D483080B30618F99A336E8D267369B")
    public String getScheme() {
String varBF26C0D1E8CB9E7F67A307E664136E8F_1295594357 =         this.scheme;
        varBF26C0D1E8CB9E7F67A307E664136E8F_1295594357.addTaint(taint);
        return varBF26C0D1E8CB9E7F67A307E664136E8F_1295594357;
        // ---------- Original Method ----------
        //return this.scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.378 -0400", hash_original_method = "95ED443083D9E3C79BD9C6E46A138264", hash_generated_method = "230534A9ABA7CE72ECEA44EFEE624382")
    public boolean isGlobal() {
        boolean var26E631107706F594FC27E5156B8AE5CE_337246065 = (telephoneNumber.isGlobal());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_182997697 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_182997697;
        // ---------- Original Method ----------
        //return telephoneNumber.isGlobal();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.378 -0400", hash_original_method = "317E4D17172E12E605B8E6C02B3A9523", hash_generated_method = "B7AF76358997C76A6621BEC04C13002A")
    public boolean isSipURI() {
        boolean var68934A3E9455FA72420237EB05902327_1938135588 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1041067192 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1041067192;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.379 -0400", hash_original_method = "EE86C87982E4E6CE462C2F1CF12245F2", hash_generated_method = "951824DCB735E93CF68C84EFAE990424")
    public void setGlobal(boolean global) {
        addTaint(global);
        this.telephoneNumber.setGlobal(global);
        // ---------- Original Method ----------
        //this.telephoneNumber.setGlobal(global);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.379 -0400", hash_original_method = "122F825A7097C68E3CD71E8CD7DD2208", hash_generated_method = "CE312079A10A601EB683505464A4D9FB")
    public void setIsdnSubAddress(String isdnSubAddress) {
        addTaint(isdnSubAddress.getTaint());
        this.telephoneNumber.setIsdnSubaddress(isdnSubAddress);
        // ---------- Original Method ----------
        //this.telephoneNumber.setIsdnSubaddress(isdnSubAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.380 -0400", hash_original_method = "19BDC1422936CE8CD2446692653D846C", hash_generated_method = "DC35F0337B77BF3F6C113C97E7A2B7DD")
    public void setPostDial(String postDial) {
        addTaint(postDial.getTaint());
        this.telephoneNumber.setPostDial(postDial);
        // ---------- Original Method ----------
        //this.telephoneNumber.setPostDial(postDial);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.380 -0400", hash_original_method = "57F725D8D07902BEB47C996DF34801CB", hash_generated_method = "D4836FB7C96184B58591AE9C3CA5A28F")
    public void setPhoneNumber(String telephoneNumber) {
        addTaint(telephoneNumber.getTaint());
        this.telephoneNumber.setPhoneNumber(telephoneNumber);
        // ---------- Original Method ----------
        //this.telephoneNumber.setPhoneNumber(telephoneNumber);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.381 -0400", hash_original_method = "9932D29BF514A34CC6953B51ADDD0B1C", hash_generated_method = "20CA6F583643661233EFEEB11B68C6BF")
    public String getPhoneNumber() {
String var2F1CBDC39608F5232C1CECD43D85B6F6_1945971929 =         this.telephoneNumber.getPhoneNumber();
        var2F1CBDC39608F5232C1CECD43D85B6F6_1945971929.addTaint(taint);
        return var2F1CBDC39608F5232C1CECD43D85B6F6_1945971929;
        // ---------- Original Method ----------
        //return this.telephoneNumber.getPhoneNumber();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.381 -0400", hash_original_method = "5EC62A2B879CA2B5D87DB46D668C10E0", hash_generated_method = "FEFBA599E825DDD03E75340505FD021D")
    public String toString() {
String varB884CA5420A1A701D348CB6F48F104FA_748977184 =         this.scheme + ":" + telephoneNumber.encode();
        varB884CA5420A1A701D348CB6F48F104FA_748977184.addTaint(taint);
        return varB884CA5420A1A701D348CB6F48F104FA_748977184;
        // ---------- Original Method ----------
        //return this.scheme + ":" + telephoneNumber.encode();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.382 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "CB4411422631A6103B343E9202060BF3")
    public String encode() {
String var678B6FE61D54E5BD4E109D01C318C133_402811170 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_402811170.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_402811170;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.382 -0400", hash_original_method = "CF877865ECD493DE460A284390F03152", hash_generated_method = "17D6396958C261D51A5D870BB52E91BF")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
        buffer.append(this.scheme).append(':');
        telephoneNumber.encode(buffer);
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1737399231 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_1737399231.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1737399231;
        // ---------- Original Method ----------
        //buffer.append(this.scheme).append(':');
        //telephoneNumber.encode(buffer);
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.383 -0400", hash_original_method = "6B8A416F4757BDF00BB53E081B0C9027", hash_generated_method = "9E1D1B845F8613B9C70DD8A20D8D8CF4")
    public Object clone() {
        TelURLImpl retval = (TelURLImpl) super.clone();
    if(this.telephoneNumber != null)        
        retval.telephoneNumber = (TelephoneNumber) this.telephoneNumber.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_1965913435 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1965913435.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1965913435;
        // ---------- Original Method ----------
        //TelURLImpl retval = (TelURLImpl) super.clone();
        //if (this.telephoneNumber != null)
            //retval.telephoneNumber = (TelephoneNumber) this.telephoneNumber.clone();
        //return retval;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.384 -0400", hash_original_method = "7FADC9FB5FA5B5E8B9D3FF343952F7D6", hash_generated_method = "7B7A72BCE8C0BB97581E02C5E206F3F1")
    public String getParameter(String parameterName) {
        addTaint(parameterName.getTaint());
String var6C84BCA8A31709458B5DA32D29D1CB3C_433350339 =         telephoneNumber.getParameter(parameterName);
        var6C84BCA8A31709458B5DA32D29D1CB3C_433350339.addTaint(taint);
        return var6C84BCA8A31709458B5DA32D29D1CB3C_433350339;
        // ---------- Original Method ----------
        //return telephoneNumber.getParameter(parameterName);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.384 -0400", hash_original_method = "7B12A3BFEAC170D72CC4E531FEDC5259", hash_generated_method = "738D826ED6F7153D27C4D708873F79A9")
    public void setParameter(String name, String value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        telephoneNumber.setParameter(name, value);
        // ---------- Original Method ----------
        //telephoneNumber.setParameter(name, value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.384 -0400", hash_original_method = "9F3A3B5343A94A5C27FE8CB7C132960C", hash_generated_method = "047711542DE59AB3E2BD182E451F51CA")
    public Iterator<String> getParameterNames() {
Iterator<String> var79A879190FBE882B20EB52EE06847E33_814691876 =         telephoneNumber.getParameterNames();
        var79A879190FBE882B20EB52EE06847E33_814691876.addTaint(taint);
        return var79A879190FBE882B20EB52EE06847E33_814691876;
        // ---------- Original Method ----------
        //return telephoneNumber.getParameterNames();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.385 -0400", hash_original_method = "9F42A8DF83D29C58CCE55D9B05B30108", hash_generated_method = "40E99788784DDC1594689233E3463AB1")
    public NameValueList getParameters() {
NameValueList var056B7BA6BDE391B0E6EDACF40AED3FE6_278253709 =         telephoneNumber.getParameters();
        var056B7BA6BDE391B0E6EDACF40AED3FE6_278253709.addTaint(taint);
        return var056B7BA6BDE391B0E6EDACF40AED3FE6_278253709;
        // ---------- Original Method ----------
        //return telephoneNumber.getParameters();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.385 -0400", hash_original_method = "7A5BAA5627804B12C2CD072560767D2A", hash_generated_method = "93D21EE98864062BD00875D1163F027C")
    public void removeParameter(String name) {
        addTaint(name.getTaint());
        telephoneNumber.removeParameter(name);
        // ---------- Original Method ----------
        //telephoneNumber.removeParameter(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.385 -0400", hash_original_method = "601A60F168280AF8DB609489286F142F", hash_generated_method = "098359866EC490DDBD811279E3119059")
    public void setPhoneContext(String phoneContext) throws ParseException {
        addTaint(phoneContext.getTaint());
    if(phoneContext==null)        
        {
            this.removeParameter("phone-context");
        } //End block
        else
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.385 -0400", hash_original_method = "E99D05466523D70C189436EBEEC64347", hash_generated_method = "3690C575C2564E1BEFB1A612E82E2EAD")
    public String getPhoneContext() {
String var1435CB6D9B27CEE5416B92AAD2755A1A_1319676604 =         this.getParameter("phone-context");
        var1435CB6D9B27CEE5416B92AAD2755A1A_1319676604.addTaint(taint);
        return var1435CB6D9B27CEE5416B92AAD2755A1A_1319676604;
        // ---------- Original Method ----------
        //return this.getParameter("phone-context");
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.386 -0400", hash_original_field = "23FDE5D4AAD83E531CC43FF9B57B5602", hash_generated_field = "F6119FF81BCE9EC280E1CB921273774A")

    private static final long serialVersionUID = 5873527320305915954L;
}

