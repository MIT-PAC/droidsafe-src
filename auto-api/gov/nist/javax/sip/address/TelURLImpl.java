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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.572 -0400", hash_original_field = "DE1DEE97B96CF71ACE169ADA317301A5", hash_generated_field = "A24B43E0CC935DC17A1CF71DA4A58F34")

    protected TelephoneNumber telephoneNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.573 -0400", hash_original_method = "C17135FC5CC76AEB5F88156629F51796", hash_generated_method = "377BA745CD46D0E73B14510DE7FBBCEB")
    public  TelURLImpl() {
        this.scheme = "tel";
        // ---------- Original Method ----------
        //this.scheme = "tel";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.573 -0400", hash_original_method = "C9EB332176FD96276A0692D7B71B3B1C", hash_generated_method = "D0138740D84BA72C2DE0294C938C714D")
    public void setTelephoneNumber(TelephoneNumber telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        // ---------- Original Method ----------
        //this.telephoneNumber = telephoneNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.574 -0400", hash_original_method = "7749933BE9F1A8F770924BE8E0DD80B2", hash_generated_method = "904B75A48B5519AA09858912A8F5B38A")
    public String getIsdnSubAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_1751078665 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1751078665 = telephoneNumber.getIsdnSubaddress();
        varB4EAC82CA7396A68D541C85D26508E83_1751078665.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1751078665;
        // ---------- Original Method ----------
        //return telephoneNumber.getIsdnSubaddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.574 -0400", hash_original_method = "A07C64D3F1CC8848A39F332213EC7E5C", hash_generated_method = "75E9A7A4A0BD4076BD2F1033FEA0B884")
    public String getPostDial() {
        String varB4EAC82CA7396A68D541C85D26508E83_1109173070 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1109173070 = telephoneNumber.getPostDial();
        varB4EAC82CA7396A68D541C85D26508E83_1109173070.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1109173070;
        // ---------- Original Method ----------
        //return telephoneNumber.getPostDial();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.575 -0400", hash_original_method = "76031D31C1CA528B8F038117D6808811", hash_generated_method = "B0EE4328FC7C77AA50707FB3CE891F22")
    public String getScheme() {
        String varB4EAC82CA7396A68D541C85D26508E83_515442649 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_515442649 = this.scheme;
        varB4EAC82CA7396A68D541C85D26508E83_515442649.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_515442649;
        // ---------- Original Method ----------
        //return this.scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.583 -0400", hash_original_method = "95ED443083D9E3C79BD9C6E46A138264", hash_generated_method = "0A5A4AABD14546679D808ABA3B323E89")
    public boolean isGlobal() {
        boolean var3B04E747E259CDF442AD9B897405BD8B_459325600 = (telephoneNumber.isGlobal());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_208375985 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_208375985;
        // ---------- Original Method ----------
        //return telephoneNumber.isGlobal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.583 -0400", hash_original_method = "317E4D17172E12E605B8E6C02B3A9523", hash_generated_method = "DA3C1E27FB4318D96C478FC4A0CAE29C")
    public boolean isSipURI() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_72370464 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_72370464;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.584 -0400", hash_original_method = "EE86C87982E4E6CE462C2F1CF12245F2", hash_generated_method = "D8ED26E806D56DCECCE683F289544917")
    public void setGlobal(boolean global) {
        this.telephoneNumber.setGlobal(global);
        addTaint(global);
        // ---------- Original Method ----------
        //this.telephoneNumber.setGlobal(global);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.584 -0400", hash_original_method = "122F825A7097C68E3CD71E8CD7DD2208", hash_generated_method = "2699D21D84CD388DE613B7EC433D031C")
    public void setIsdnSubAddress(String isdnSubAddress) {
        this.telephoneNumber.setIsdnSubaddress(isdnSubAddress);
        addTaint(isdnSubAddress.getTaint());
        // ---------- Original Method ----------
        //this.telephoneNumber.setIsdnSubaddress(isdnSubAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.594 -0400", hash_original_method = "19BDC1422936CE8CD2446692653D846C", hash_generated_method = "191CE53A571D426D49E09F2A1BD3A4D9")
    public void setPostDial(String postDial) {
        this.telephoneNumber.setPostDial(postDial);
        addTaint(postDial.getTaint());
        // ---------- Original Method ----------
        //this.telephoneNumber.setPostDial(postDial);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.594 -0400", hash_original_method = "57F725D8D07902BEB47C996DF34801CB", hash_generated_method = "4767C9875A9DBF98E9955291B34E5875")
    public void setPhoneNumber(String telephoneNumber) {
        this.telephoneNumber.setPhoneNumber(telephoneNumber);
        addTaint(telephoneNumber.getTaint());
        // ---------- Original Method ----------
        //this.telephoneNumber.setPhoneNumber(telephoneNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.595 -0400", hash_original_method = "9932D29BF514A34CC6953B51ADDD0B1C", hash_generated_method = "D2E56F4D8E091B529B40A7FC15185203")
    public String getPhoneNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_996455279 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_996455279 = this.telephoneNumber.getPhoneNumber();
        varB4EAC82CA7396A68D541C85D26508E83_996455279.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_996455279;
        // ---------- Original Method ----------
        //return this.telephoneNumber.getPhoneNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.595 -0400", hash_original_method = "5EC62A2B879CA2B5D87DB46D668C10E0", hash_generated_method = "93D6C9BE632788158E655FC2B2AFC989")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1685469037 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1685469037 = this.scheme + ":" + telephoneNumber.encode();
        varB4EAC82CA7396A68D541C85D26508E83_1685469037.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1685469037;
        // ---------- Original Method ----------
        //return this.scheme + ":" + telephoneNumber.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.595 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "21819F4CC5BC705EDF250A929C414049")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_929145922 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_929145922 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_929145922.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_929145922;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.596 -0400", hash_original_method = "CF877865ECD493DE460A284390F03152", hash_generated_method = "092DB3E6D136823BF5BD67EE50D44BFA")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1844643212 = null; //Variable for return #1
        buffer.append(this.scheme).append(':');
        telephoneNumber.encode(buffer);
        varB4EAC82CA7396A68D541C85D26508E83_1844643212 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1844643212.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1844643212;
        // ---------- Original Method ----------
        //buffer.append(this.scheme).append(':');
        //telephoneNumber.encode(buffer);
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.596 -0400", hash_original_method = "6B8A416F4757BDF00BB53E081B0C9027", hash_generated_method = "B4C85B5A266CA38A70570F7C71747C6B")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_482888384 = null; //Variable for return #1
        TelURLImpl retval;
        retval = (TelURLImpl) super.clone();
        retval.telephoneNumber = (TelephoneNumber) this.telephoneNumber.clone();
        varB4EAC82CA7396A68D541C85D26508E83_482888384 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_482888384.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_482888384;
        // ---------- Original Method ----------
        //TelURLImpl retval = (TelURLImpl) super.clone();
        //if (this.telephoneNumber != null)
            //retval.telephoneNumber = (TelephoneNumber) this.telephoneNumber.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.597 -0400", hash_original_method = "7FADC9FB5FA5B5E8B9D3FF343952F7D6", hash_generated_method = "B0048BA3860E91F1B7B1E85385206EF3")
    public String getParameter(String parameterName) {
        String varB4EAC82CA7396A68D541C85D26508E83_361272654 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_361272654 = telephoneNumber.getParameter(parameterName);
        addTaint(parameterName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_361272654.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_361272654;
        // ---------- Original Method ----------
        //return telephoneNumber.getParameter(parameterName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.597 -0400", hash_original_method = "7B12A3BFEAC170D72CC4E531FEDC5259", hash_generated_method = "F0C6EB1BE3E73CDBD792FB15934C49B6")
    public void setParameter(String name, String value) {
        telephoneNumber.setParameter(name, value);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //telephoneNumber.setParameter(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.603 -0400", hash_original_method = "9F3A3B5343A94A5C27FE8CB7C132960C", hash_generated_method = "9D776C567820B7E9F9E66439B164B621")
    public Iterator<String> getParameterNames() {
        Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_690604301 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_690604301 = telephoneNumber.getParameterNames();
        varB4EAC82CA7396A68D541C85D26508E83_690604301.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_690604301;
        // ---------- Original Method ----------
        //return telephoneNumber.getParameterNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.603 -0400", hash_original_method = "9F42A8DF83D29C58CCE55D9B05B30108", hash_generated_method = "87E8B6104A231CC9865DC5BE8306BDED")
    public NameValueList getParameters() {
        NameValueList varB4EAC82CA7396A68D541C85D26508E83_1724633740 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1724633740 = telephoneNumber.getParameters();
        varB4EAC82CA7396A68D541C85D26508E83_1724633740.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1724633740;
        // ---------- Original Method ----------
        //return telephoneNumber.getParameters();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.621 -0400", hash_original_method = "7A5BAA5627804B12C2CD072560767D2A", hash_generated_method = "953CB5DD22B589FA804851F1734298AD")
    public void removeParameter(String name) {
        telephoneNumber.removeParameter(name);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //telephoneNumber.removeParameter(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.621 -0400", hash_original_method = "601A60F168280AF8DB609489286F142F", hash_generated_method = "7E92A3BD9C5AE1C412E07D96495F60C4")
    public void setPhoneContext(String phoneContext) throws ParseException {
        {
            this.removeParameter("phone-context");
        } //End block
        {
            this.setParameter("phone-context",phoneContext);
        } //End block
        addTaint(phoneContext.getTaint());
        // ---------- Original Method ----------
        //if (phoneContext==null) {
            //this.removeParameter("phone-context");
        //} else {
            //this.setParameter("phone-context",phoneContext);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.622 -0400", hash_original_method = "E99D05466523D70C189436EBEEC64347", hash_generated_method = "0A6E0D3B9108689888292F775C4E2163")
    public String getPhoneContext() {
        String varB4EAC82CA7396A68D541C85D26508E83_1582756696 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1582756696 = this.getParameter("phone-context");
        varB4EAC82CA7396A68D541C85D26508E83_1582756696.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1582756696;
        // ---------- Original Method ----------
        //return this.getParameter("phone-context");
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.622 -0400", hash_original_field = "23FDE5D4AAD83E531CC43FF9B57B5602", hash_generated_field = "CA04C29225251CFD90D62477D6D68CFA")

    private static long serialVersionUID = 5873527320305915954L;
}

