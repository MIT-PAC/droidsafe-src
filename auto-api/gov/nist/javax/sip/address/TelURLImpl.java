package gov.nist.javax.sip.address;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.core.NameValueList;
import java.text.ParseException;
import java.util.Iterator;

public class TelURLImpl extends GenericURI implements javax.sip.address.TelURL {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.500 -0400", hash_original_field = "DE1DEE97B96CF71ACE169ADA317301A5", hash_generated_field = "A24B43E0CC935DC17A1CF71DA4A58F34")

    protected TelephoneNumber telephoneNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.501 -0400", hash_original_method = "C17135FC5CC76AEB5F88156629F51796", hash_generated_method = "377BA745CD46D0E73B14510DE7FBBCEB")
    public  TelURLImpl() {
        this.scheme = "tel";
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.501 -0400", hash_original_method = "C9EB332176FD96276A0692D7B71B3B1C", hash_generated_method = "D0138740D84BA72C2DE0294C938C714D")
    public void setTelephoneNumber(TelephoneNumber telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.502 -0400", hash_original_method = "7749933BE9F1A8F770924BE8E0DD80B2", hash_generated_method = "AE715D423224532B09DE95147F17C496")
    public String getIsdnSubAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_1776180328 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1776180328 = telephoneNumber.getIsdnSubaddress();
        varB4EAC82CA7396A68D541C85D26508E83_1776180328.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1776180328;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.502 -0400", hash_original_method = "A07C64D3F1CC8848A39F332213EC7E5C", hash_generated_method = "B84CB2DB4E4D4C34DC87CB72EE03C284")
    public String getPostDial() {
        String varB4EAC82CA7396A68D541C85D26508E83_325870386 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_325870386 = telephoneNumber.getPostDial();
        varB4EAC82CA7396A68D541C85D26508E83_325870386.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_325870386;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.503 -0400", hash_original_method = "76031D31C1CA528B8F038117D6808811", hash_generated_method = "DC1DDAB6DFA66BEBBB125FD011BB5BEC")
    public String getScheme() {
        String varB4EAC82CA7396A68D541C85D26508E83_1281568264 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1281568264 = this.scheme;
        varB4EAC82CA7396A68D541C85D26508E83_1281568264.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1281568264;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.503 -0400", hash_original_method = "95ED443083D9E3C79BD9C6E46A138264", hash_generated_method = "151E8F68A641833C40657E8AFBC8ECA3")
    public boolean isGlobal() {
        boolean var3B04E747E259CDF442AD9B897405BD8B_1915213126 = (telephoneNumber.isGlobal());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_244713180 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_244713180;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.504 -0400", hash_original_method = "317E4D17172E12E605B8E6C02B3A9523", hash_generated_method = "45FA7D0743EFB57F5CEDCAD87E2D206D")
    public boolean isSipURI() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_831405094 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_831405094;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.504 -0400", hash_original_method = "EE86C87982E4E6CE462C2F1CF12245F2", hash_generated_method = "D8ED26E806D56DCECCE683F289544917")
    public void setGlobal(boolean global) {
        this.telephoneNumber.setGlobal(global);
        addTaint(global);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.504 -0400", hash_original_method = "122F825A7097C68E3CD71E8CD7DD2208", hash_generated_method = "2699D21D84CD388DE613B7EC433D031C")
    public void setIsdnSubAddress(String isdnSubAddress) {
        this.telephoneNumber.setIsdnSubaddress(isdnSubAddress);
        addTaint(isdnSubAddress.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.505 -0400", hash_original_method = "19BDC1422936CE8CD2446692653D846C", hash_generated_method = "191CE53A571D426D49E09F2A1BD3A4D9")
    public void setPostDial(String postDial) {
        this.telephoneNumber.setPostDial(postDial);
        addTaint(postDial.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.505 -0400", hash_original_method = "57F725D8D07902BEB47C996DF34801CB", hash_generated_method = "4767C9875A9DBF98E9955291B34E5875")
    public void setPhoneNumber(String telephoneNumber) {
        this.telephoneNumber.setPhoneNumber(telephoneNumber);
        addTaint(telephoneNumber.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.506 -0400", hash_original_method = "9932D29BF514A34CC6953B51ADDD0B1C", hash_generated_method = "2CD6741FEFFF4BE27E0433482EFE923A")
    public String getPhoneNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_588585557 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_588585557 = this.telephoneNumber.getPhoneNumber();
        varB4EAC82CA7396A68D541C85D26508E83_588585557.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_588585557;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.506 -0400", hash_original_method = "5EC62A2B879CA2B5D87DB46D668C10E0", hash_generated_method = "A63027853DAC88A923AB81A0D75FFB68")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1634424985 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1634424985 = this.scheme + ":" + telephoneNumber.encode();
        varB4EAC82CA7396A68D541C85D26508E83_1634424985.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1634424985;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.507 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "85D1ADAEDC85B3732140A1C9EE2F4C34")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_60666834 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_60666834 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_60666834.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_60666834;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.507 -0400", hash_original_method = "CF877865ECD493DE460A284390F03152", hash_generated_method = "D33BCCD2DACF71D58CBE20AF24BD3F3B")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_915926639 = null; 
        buffer.append(this.scheme).append(':');
        telephoneNumber.encode(buffer);
        varB4EAC82CA7396A68D541C85D26508E83_915926639 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_915926639.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_915926639;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.508 -0400", hash_original_method = "6B8A416F4757BDF00BB53E081B0C9027", hash_generated_method = "58B212B3C6A3F230FBD90612199BCC44")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_607282824 = null; 
        TelURLImpl retval = (TelURLImpl) super.clone();
        retval.telephoneNumber = (TelephoneNumber) this.telephoneNumber.clone();
        varB4EAC82CA7396A68D541C85D26508E83_607282824 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_607282824.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_607282824;
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.508 -0400", hash_original_method = "7FADC9FB5FA5B5E8B9D3FF343952F7D6", hash_generated_method = "8F703CC04029B0599B477C77412270FA")
    public String getParameter(String parameterName) {
        String varB4EAC82CA7396A68D541C85D26508E83_44896471 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_44896471 = telephoneNumber.getParameter(parameterName);
        addTaint(parameterName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_44896471.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_44896471;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.508 -0400", hash_original_method = "7B12A3BFEAC170D72CC4E531FEDC5259", hash_generated_method = "F0C6EB1BE3E73CDBD792FB15934C49B6")
    public void setParameter(String name, String value) {
        telephoneNumber.setParameter(name, value);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.509 -0400", hash_original_method = "9F3A3B5343A94A5C27FE8CB7C132960C", hash_generated_method = "15FB94BF6350D6A139F51D482D53FD1B")
    public Iterator<String> getParameterNames() {
        Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_240702353 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_240702353 = telephoneNumber.getParameterNames();
        varB4EAC82CA7396A68D541C85D26508E83_240702353.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_240702353;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.509 -0400", hash_original_method = "9F42A8DF83D29C58CCE55D9B05B30108", hash_generated_method = "ADCEF785298A1C8B82A0113DF165EC18")
    public NameValueList getParameters() {
        NameValueList varB4EAC82CA7396A68D541C85D26508E83_1667611014 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1667611014 = telephoneNumber.getParameters();
        varB4EAC82CA7396A68D541C85D26508E83_1667611014.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1667611014;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.509 -0400", hash_original_method = "7A5BAA5627804B12C2CD072560767D2A", hash_generated_method = "953CB5DD22B589FA804851F1734298AD")
    public void removeParameter(String name) {
        telephoneNumber.removeParameter(name);
        addTaint(name.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.510 -0400", hash_original_method = "601A60F168280AF8DB609489286F142F", hash_generated_method = "7E92A3BD9C5AE1C412E07D96495F60C4")
    public void setPhoneContext(String phoneContext) throws ParseException {
        {
            this.removeParameter("phone-context");
        } 
        {
            this.setParameter("phone-context",phoneContext);
        } 
        addTaint(phoneContext.getTaint());
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.510 -0400", hash_original_method = "E99D05466523D70C189436EBEEC64347", hash_generated_method = "9A1F8E2C6137F388FF38F03659F0933C")
    public String getPhoneContext() {
        String varB4EAC82CA7396A68D541C85D26508E83_1712682551 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1712682551 = this.getParameter("phone-context");
        varB4EAC82CA7396A68D541C85D26508E83_1712682551.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1712682551;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.510 -0400", hash_original_field = "23FDE5D4AAD83E531CC43FF9B57B5602", hash_generated_field = "F6119FF81BCE9EC280E1CB921273774A")

    private static final long serialVersionUID = 5873527320305915954L;
}

