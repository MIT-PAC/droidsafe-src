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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.749 -0400", hash_original_field = "DE1DEE97B96CF71ACE169ADA317301A5", hash_generated_field = "A24B43E0CC935DC17A1CF71DA4A58F34")

    protected TelephoneNumber telephoneNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.759 -0400", hash_original_method = "C17135FC5CC76AEB5F88156629F51796", hash_generated_method = "377BA745CD46D0E73B14510DE7FBBCEB")
    public  TelURLImpl() {
        this.scheme = "tel";
        // ---------- Original Method ----------
        //this.scheme = "tel";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.759 -0400", hash_original_method = "C9EB332176FD96276A0692D7B71B3B1C", hash_generated_method = "D0138740D84BA72C2DE0294C938C714D")
    public void setTelephoneNumber(TelephoneNumber telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        // ---------- Original Method ----------
        //this.telephoneNumber = telephoneNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.760 -0400", hash_original_method = "7749933BE9F1A8F770924BE8E0DD80B2", hash_generated_method = "E3956F865D264CF39311FAB3979F5D10")
    public String getIsdnSubAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_523181360 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_523181360 = telephoneNumber.getIsdnSubaddress();
        varB4EAC82CA7396A68D541C85D26508E83_523181360.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_523181360;
        // ---------- Original Method ----------
        //return telephoneNumber.getIsdnSubaddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.760 -0400", hash_original_method = "A07C64D3F1CC8848A39F332213EC7E5C", hash_generated_method = "2010AE24E820256FC50B07D99624E899")
    public String getPostDial() {
        String varB4EAC82CA7396A68D541C85D26508E83_863182725 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_863182725 = telephoneNumber.getPostDial();
        varB4EAC82CA7396A68D541C85D26508E83_863182725.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_863182725;
        // ---------- Original Method ----------
        //return telephoneNumber.getPostDial();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.760 -0400", hash_original_method = "76031D31C1CA528B8F038117D6808811", hash_generated_method = "BB1A35CD68D507676504DC9D10CABE74")
    public String getScheme() {
        String varB4EAC82CA7396A68D541C85D26508E83_758781703 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_758781703 = this.scheme;
        varB4EAC82CA7396A68D541C85D26508E83_758781703.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_758781703;
        // ---------- Original Method ----------
        //return this.scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.760 -0400", hash_original_method = "95ED443083D9E3C79BD9C6E46A138264", hash_generated_method = "7BC46922F7579010F4B0E82357B219BD")
    public boolean isGlobal() {
        boolean var3B04E747E259CDF442AD9B897405BD8B_1649064636 = (telephoneNumber.isGlobal());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1572651744 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1572651744;
        // ---------- Original Method ----------
        //return telephoneNumber.isGlobal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.761 -0400", hash_original_method = "317E4D17172E12E605B8E6C02B3A9523", hash_generated_method = "BDF8D4F7FC8E0EF21EA59399DC34CAB9")
    public boolean isSipURI() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2081296465 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2081296465;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.761 -0400", hash_original_method = "EE86C87982E4E6CE462C2F1CF12245F2", hash_generated_method = "D8ED26E806D56DCECCE683F289544917")
    public void setGlobal(boolean global) {
        this.telephoneNumber.setGlobal(global);
        addTaint(global);
        // ---------- Original Method ----------
        //this.telephoneNumber.setGlobal(global);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.761 -0400", hash_original_method = "122F825A7097C68E3CD71E8CD7DD2208", hash_generated_method = "2699D21D84CD388DE613B7EC433D031C")
    public void setIsdnSubAddress(String isdnSubAddress) {
        this.telephoneNumber.setIsdnSubaddress(isdnSubAddress);
        addTaint(isdnSubAddress.getTaint());
        // ---------- Original Method ----------
        //this.telephoneNumber.setIsdnSubaddress(isdnSubAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.766 -0400", hash_original_method = "19BDC1422936CE8CD2446692653D846C", hash_generated_method = "191CE53A571D426D49E09F2A1BD3A4D9")
    public void setPostDial(String postDial) {
        this.telephoneNumber.setPostDial(postDial);
        addTaint(postDial.getTaint());
        // ---------- Original Method ----------
        //this.telephoneNumber.setPostDial(postDial);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.769 -0400", hash_original_method = "57F725D8D07902BEB47C996DF34801CB", hash_generated_method = "4767C9875A9DBF98E9955291B34E5875")
    public void setPhoneNumber(String telephoneNumber) {
        this.telephoneNumber.setPhoneNumber(telephoneNumber);
        addTaint(telephoneNumber.getTaint());
        // ---------- Original Method ----------
        //this.telephoneNumber.setPhoneNumber(telephoneNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.770 -0400", hash_original_method = "9932D29BF514A34CC6953B51ADDD0B1C", hash_generated_method = "93159E56B5E47B71E2697A8296F0D1A7")
    public String getPhoneNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_1730191171 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1730191171 = this.telephoneNumber.getPhoneNumber();
        varB4EAC82CA7396A68D541C85D26508E83_1730191171.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1730191171;
        // ---------- Original Method ----------
        //return this.telephoneNumber.getPhoneNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.771 -0400", hash_original_method = "5EC62A2B879CA2B5D87DB46D668C10E0", hash_generated_method = "24577023E5692A471A394886E896C7F7")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1842746552 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1842746552 = this.scheme + ":" + telephoneNumber.encode();
        varB4EAC82CA7396A68D541C85D26508E83_1842746552.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1842746552;
        // ---------- Original Method ----------
        //return this.scheme + ":" + telephoneNumber.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.771 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "1B3BD45EB3C9147901AB4B5A173E57C0")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1125242935 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1125242935 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1125242935.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1125242935;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.772 -0400", hash_original_method = "CF877865ECD493DE460A284390F03152", hash_generated_method = "66732A5D291A72CB64DE36BAC57DC1FA")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1623678919 = null; //Variable for return #1
        buffer.append(this.scheme).append(':');
        telephoneNumber.encode(buffer);
        varB4EAC82CA7396A68D541C85D26508E83_1623678919 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1623678919.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1623678919;
        // ---------- Original Method ----------
        //buffer.append(this.scheme).append(':');
        //telephoneNumber.encode(buffer);
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.773 -0400", hash_original_method = "6B8A416F4757BDF00BB53E081B0C9027", hash_generated_method = "55CE5690A10862718AB9C64C5B2E562B")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1213195034 = null; //Variable for return #1
        TelURLImpl retval;
        retval = (TelURLImpl) super.clone();
        retval.telephoneNumber = (TelephoneNumber) this.telephoneNumber.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1213195034 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1213195034.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1213195034;
        // ---------- Original Method ----------
        //TelURLImpl retval = (TelURLImpl) super.clone();
        //if (this.telephoneNumber != null)
            //retval.telephoneNumber = (TelephoneNumber) this.telephoneNumber.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.784 -0400", hash_original_method = "7FADC9FB5FA5B5E8B9D3FF343952F7D6", hash_generated_method = "A1480608571EE43E5BCB72F8C2598C94")
    public String getParameter(String parameterName) {
        String varB4EAC82CA7396A68D541C85D26508E83_402977009 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_402977009 = telephoneNumber.getParameter(parameterName);
        addTaint(parameterName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_402977009.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_402977009;
        // ---------- Original Method ----------
        //return telephoneNumber.getParameter(parameterName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.785 -0400", hash_original_method = "7B12A3BFEAC170D72CC4E531FEDC5259", hash_generated_method = "F0C6EB1BE3E73CDBD792FB15934C49B6")
    public void setParameter(String name, String value) {
        telephoneNumber.setParameter(name, value);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //telephoneNumber.setParameter(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.786 -0400", hash_original_method = "9F3A3B5343A94A5C27FE8CB7C132960C", hash_generated_method = "755329E88804B10C9521AFB1215DFDDB")
    public Iterator<String> getParameterNames() {
        Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_1611436327 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1611436327 = telephoneNumber.getParameterNames();
        varB4EAC82CA7396A68D541C85D26508E83_1611436327.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1611436327;
        // ---------- Original Method ----------
        //return telephoneNumber.getParameterNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.790 -0400", hash_original_method = "9F42A8DF83D29C58CCE55D9B05B30108", hash_generated_method = "F86FB421CA1DC63F6F184C5382E288DC")
    public NameValueList getParameters() {
        NameValueList varB4EAC82CA7396A68D541C85D26508E83_928999496 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_928999496 = telephoneNumber.getParameters();
        varB4EAC82CA7396A68D541C85D26508E83_928999496.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_928999496;
        // ---------- Original Method ----------
        //return telephoneNumber.getParameters();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.798 -0400", hash_original_method = "7A5BAA5627804B12C2CD072560767D2A", hash_generated_method = "953CB5DD22B589FA804851F1734298AD")
    public void removeParameter(String name) {
        telephoneNumber.removeParameter(name);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //telephoneNumber.removeParameter(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.799 -0400", hash_original_method = "601A60F168280AF8DB609489286F142F", hash_generated_method = "7E92A3BD9C5AE1C412E07D96495F60C4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.799 -0400", hash_original_method = "E99D05466523D70C189436EBEEC64347", hash_generated_method = "1BAED071F18F36EE0BD0ABFD73A48BE9")
    public String getPhoneContext() {
        String varB4EAC82CA7396A68D541C85D26508E83_493462626 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_493462626 = this.getParameter("phone-context");
        varB4EAC82CA7396A68D541C85D26508E83_493462626.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_493462626;
        // ---------- Original Method ----------
        //return this.getParameter("phone-context");
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.799 -0400", hash_original_field = "23FDE5D4AAD83E531CC43FF9B57B5602", hash_generated_field = "CA04C29225251CFD90D62477D6D68CFA")

    private static long serialVersionUID = 5873527320305915954L;
}

