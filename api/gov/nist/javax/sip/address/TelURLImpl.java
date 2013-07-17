package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.NameValueList;
import java.text.ParseException;
import java.util.Iterator;

public class TelURLImpl extends GenericURI implements javax.sip.address.TelURL {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.283 -0400", hash_original_field = "DE1DEE97B96CF71ACE169ADA317301A5", hash_generated_field = "A24B43E0CC935DC17A1CF71DA4A58F34")

    protected TelephoneNumber telephoneNumber;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.283 -0400", hash_original_method = "C17135FC5CC76AEB5F88156629F51796", hash_generated_method = "377BA745CD46D0E73B14510DE7FBBCEB")
    public  TelURLImpl() {
        this.scheme = "tel";
        // ---------- Original Method ----------
        //this.scheme = "tel";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.283 -0400", hash_original_method = "C9EB332176FD96276A0692D7B71B3B1C", hash_generated_method = "D0138740D84BA72C2DE0294C938C714D")
    public void setTelephoneNumber(TelephoneNumber telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        // ---------- Original Method ----------
        //this.telephoneNumber = telephoneNumber;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.284 -0400", hash_original_method = "7749933BE9F1A8F770924BE8E0DD80B2", hash_generated_method = "052EC85A80A67738BDE70605E2C314A5")
    public String getIsdnSubAddress() {
String var172B27340AEC7A96C98F43E2188CFB2E_928163431 =         telephoneNumber.getIsdnSubaddress();
        var172B27340AEC7A96C98F43E2188CFB2E_928163431.addTaint(taint);
        return var172B27340AEC7A96C98F43E2188CFB2E_928163431;
        // ---------- Original Method ----------
        //return telephoneNumber.getIsdnSubaddress();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.284 -0400", hash_original_method = "A07C64D3F1CC8848A39F332213EC7E5C", hash_generated_method = "E46D147EB01B05AE7C2C025CD386FF91")
    public String getPostDial() {
String varA33BA7A023A959AD044A6D5D34B61AD7_1172197555 =         telephoneNumber.getPostDial();
        varA33BA7A023A959AD044A6D5D34B61AD7_1172197555.addTaint(taint);
        return varA33BA7A023A959AD044A6D5D34B61AD7_1172197555;
        // ---------- Original Method ----------
        //return telephoneNumber.getPostDial();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.284 -0400", hash_original_method = "76031D31C1CA528B8F038117D6808811", hash_generated_method = "7D61AE64AA4A677CE755621899679FDC")
    public String getScheme() {
String varBF26C0D1E8CB9E7F67A307E664136E8F_931797527 =         this.scheme;
        varBF26C0D1E8CB9E7F67A307E664136E8F_931797527.addTaint(taint);
        return varBF26C0D1E8CB9E7F67A307E664136E8F_931797527;
        // ---------- Original Method ----------
        //return this.scheme;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.284 -0400", hash_original_method = "95ED443083D9E3C79BD9C6E46A138264", hash_generated_method = "B76297969AF952477E29D289BC7C6E04")
    public boolean isGlobal() {
        boolean var26E631107706F594FC27E5156B8AE5CE_2065434201 = (telephoneNumber.isGlobal());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1250715097 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1250715097;
        // ---------- Original Method ----------
        //return telephoneNumber.isGlobal();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.284 -0400", hash_original_method = "317E4D17172E12E605B8E6C02B3A9523", hash_generated_method = "B89F31C89028B6361A1D4076B75A16C7")
    public boolean isSipURI() {
        boolean var68934A3E9455FA72420237EB05902327_1909743471 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2014456194 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2014456194;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.284 -0400", hash_original_method = "EE86C87982E4E6CE462C2F1CF12245F2", hash_generated_method = "951824DCB735E93CF68C84EFAE990424")
    public void setGlobal(boolean global) {
        addTaint(global);
        this.telephoneNumber.setGlobal(global);
        // ---------- Original Method ----------
        //this.telephoneNumber.setGlobal(global);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.284 -0400", hash_original_method = "122F825A7097C68E3CD71E8CD7DD2208", hash_generated_method = "CE312079A10A601EB683505464A4D9FB")
    public void setIsdnSubAddress(String isdnSubAddress) {
        addTaint(isdnSubAddress.getTaint());
        this.telephoneNumber.setIsdnSubaddress(isdnSubAddress);
        // ---------- Original Method ----------
        //this.telephoneNumber.setIsdnSubaddress(isdnSubAddress);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.284 -0400", hash_original_method = "19BDC1422936CE8CD2446692653D846C", hash_generated_method = "DC35F0337B77BF3F6C113C97E7A2B7DD")
    public void setPostDial(String postDial) {
        addTaint(postDial.getTaint());
        this.telephoneNumber.setPostDial(postDial);
        // ---------- Original Method ----------
        //this.telephoneNumber.setPostDial(postDial);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.285 -0400", hash_original_method = "57F725D8D07902BEB47C996DF34801CB", hash_generated_method = "D4836FB7C96184B58591AE9C3CA5A28F")
    public void setPhoneNumber(String telephoneNumber) {
        addTaint(telephoneNumber.getTaint());
        this.telephoneNumber.setPhoneNumber(telephoneNumber);
        // ---------- Original Method ----------
        //this.telephoneNumber.setPhoneNumber(telephoneNumber);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.285 -0400", hash_original_method = "9932D29BF514A34CC6953B51ADDD0B1C", hash_generated_method = "24AE890F1F5BE466B11818D01A9F7971")
    public String getPhoneNumber() {
String var2F1CBDC39608F5232C1CECD43D85B6F6_40323191 =         this.telephoneNumber.getPhoneNumber();
        var2F1CBDC39608F5232C1CECD43D85B6F6_40323191.addTaint(taint);
        return var2F1CBDC39608F5232C1CECD43D85B6F6_40323191;
        // ---------- Original Method ----------
        //return this.telephoneNumber.getPhoneNumber();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.285 -0400", hash_original_method = "5EC62A2B879CA2B5D87DB46D668C10E0", hash_generated_method = "5ACD44C29472BFD26637BC06E43E8E7A")
    public String toString() {
String varB884CA5420A1A701D348CB6F48F104FA_1157419829 =         this.scheme + ":" + telephoneNumber.encode();
        varB884CA5420A1A701D348CB6F48F104FA_1157419829.addTaint(taint);
        return varB884CA5420A1A701D348CB6F48F104FA_1157419829;
        // ---------- Original Method ----------
        //return this.scheme + ":" + telephoneNumber.encode();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.285 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "844DC0314C67417A71210DDEC0525207")
    public String encode() {
String var678B6FE61D54E5BD4E109D01C318C133_1284959198 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_1284959198.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_1284959198;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.285 -0400", hash_original_method = "CF877865ECD493DE460A284390F03152", hash_generated_method = "7A9CDD6B71C633821E8FB0252ACD9830")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
        buffer.append(this.scheme).append(':');
        telephoneNumber.encode(buffer);
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_905112138 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_905112138.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_905112138;
        // ---------- Original Method ----------
        //buffer.append(this.scheme).append(':');
        //telephoneNumber.encode(buffer);
        //return buffer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.285 -0400", hash_original_method = "6B8A416F4757BDF00BB53E081B0C9027", hash_generated_method = "DEEAF63C064B906B7B15D343EB0D71A3")
    public Object clone() {
        TelURLImpl retval = (TelURLImpl) super.clone();
        if(this.telephoneNumber != null)        
        retval.telephoneNumber = (TelephoneNumber) this.telephoneNumber.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_892699424 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_892699424.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_892699424;
        // ---------- Original Method ----------
        //TelURLImpl retval = (TelURLImpl) super.clone();
        //if (this.telephoneNumber != null)
            //retval.telephoneNumber = (TelephoneNumber) this.telephoneNumber.clone();
        //return retval;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.285 -0400", hash_original_method = "7FADC9FB5FA5B5E8B9D3FF343952F7D6", hash_generated_method = "6E1451185752A9F40B5317612DED728E")
    public String getParameter(String parameterName) {
        addTaint(parameterName.getTaint());
String var6C84BCA8A31709458B5DA32D29D1CB3C_1235728762 =         telephoneNumber.getParameter(parameterName);
        var6C84BCA8A31709458B5DA32D29D1CB3C_1235728762.addTaint(taint);
        return var6C84BCA8A31709458B5DA32D29D1CB3C_1235728762;
        // ---------- Original Method ----------
        //return telephoneNumber.getParameter(parameterName);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.285 -0400", hash_original_method = "7B12A3BFEAC170D72CC4E531FEDC5259", hash_generated_method = "738D826ED6F7153D27C4D708873F79A9")
    public void setParameter(String name, String value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        telephoneNumber.setParameter(name, value);
        // ---------- Original Method ----------
        //telephoneNumber.setParameter(name, value);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.285 -0400", hash_original_method = "9F3A3B5343A94A5C27FE8CB7C132960C", hash_generated_method = "D3730FE79AABEBB4BC51344C2CF29E14")
    public Iterator<String> getParameterNames() {
Iterator<String> var79A879190FBE882B20EB52EE06847E33_431722552 =         telephoneNumber.getParameterNames();
        var79A879190FBE882B20EB52EE06847E33_431722552.addTaint(taint);
        return var79A879190FBE882B20EB52EE06847E33_431722552;
        // ---------- Original Method ----------
        //return telephoneNumber.getParameterNames();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.286 -0400", hash_original_method = "9F42A8DF83D29C58CCE55D9B05B30108", hash_generated_method = "3415E47DE7C992E70E81E9554B44D7E4")
    public NameValueList getParameters() {
NameValueList var056B7BA6BDE391B0E6EDACF40AED3FE6_1135811267 =         telephoneNumber.getParameters();
        var056B7BA6BDE391B0E6EDACF40AED3FE6_1135811267.addTaint(taint);
        return var056B7BA6BDE391B0E6EDACF40AED3FE6_1135811267;
        // ---------- Original Method ----------
        //return telephoneNumber.getParameters();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.286 -0400", hash_original_method = "7A5BAA5627804B12C2CD072560767D2A", hash_generated_method = "93D21EE98864062BD00875D1163F027C")
    public void removeParameter(String name) {
        addTaint(name.getTaint());
        telephoneNumber.removeParameter(name);
        // ---------- Original Method ----------
        //telephoneNumber.removeParameter(name);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.286 -0400", hash_original_method = "601A60F168280AF8DB609489286F142F", hash_generated_method = "098359866EC490DDBD811279E3119059")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.286 -0400", hash_original_method = "E99D05466523D70C189436EBEEC64347", hash_generated_method = "1F545F045AF98A177D1300A86A97C9DA")
    public String getPhoneContext() {
String var1435CB6D9B27CEE5416B92AAD2755A1A_504754396 =         this.getParameter("phone-context");
        var1435CB6D9B27CEE5416B92AAD2755A1A_504754396.addTaint(taint);
        return var1435CB6D9B27CEE5416B92AAD2755A1A_504754396;
        // ---------- Original Method ----------
        //return this.getParameter("phone-context");
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.286 -0400", hash_original_field = "23FDE5D4AAD83E531CC43FF9B57B5602", hash_generated_field = "F6119FF81BCE9EC280E1CB921273774A")

    private static final long serialVersionUID = 5873527320305915954L;
}

