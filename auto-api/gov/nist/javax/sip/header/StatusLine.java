package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.SIPConstants;

public final class StatusLine extends SIPObject implements SipStatusLine {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.677 -0400", hash_original_field = "14881828949DC3B28E62BC34877C141D", hash_generated_field = "B8EAB804E3725A6DD3531CF15A699005")

    protected boolean matchStatusClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.677 -0400", hash_original_field = "66D2C8863084D21925D8C4AD8BD49102", hash_generated_field = "0E22CDA9223E852519CAF5EA7723F865")

    protected String sipVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.677 -0400", hash_original_field = "F9A31C6B3670C772D11230C8D4D1F33F", hash_generated_field = "AF3A2B27F74478A1F178EA853CB720C4")

    protected int statusCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.677 -0400", hash_original_field = "6A273AF93AEB8DA54D90CBF3B44D79AC", hash_generated_field = "C24AAD4BC0C98CB74977788D19F4D718")

    protected String reasonPhrase;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.678 -0400", hash_original_method = "952A7A04B56CA19CB087E879E7A74676", hash_generated_method = "264BF0CCCF59EFC8D77A76A8838AD81F")
    public  StatusLine() {
        reasonPhrase = null;
        sipVersion = SIPConstants.SIP_VERSION_STRING;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.678 -0400", hash_original_method = "F8EDA6D677CBC73EB8A3A71E43559895", hash_generated_method = "0F72A03285BEEB592687AE6A055C78C9")
    public boolean match(Object matchObj) {
        StatusLine sl = (StatusLine) matchObj;
        boolean varF11A090C3FA6483A7415F8E65776C7F8_419079136 = (sl.matchExpression.match(this.encode()));
        {
            boolean varABD0525F68421F849E9ED95F10F8FB24_173350348 = (sl.sipVersion != null && !sl.sipVersion.equals(sipVersion));
        } 
        {
            {
                int hiscode = sl.statusCode;
                String codeString = Integer.toString(sl.statusCode);
                String mycode = Integer.toString(statusCode);
                {
                    boolean var41CA100506627783ADDB3D130BD02D76_1040939981 = (codeString.charAt(0) != mycode.charAt(0));
                } 
            } 
        } 
        boolean var4B48BB3783DA57C9FECD296FB4154CCF_431562773 = (reasonPhrase.equals(sl.reasonPhrase));
        addTaint(matchObj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1262295973 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1262295973;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.679 -0400", hash_original_method = "72B66E964D13ABBD6BD5B9A3B23AE94A", hash_generated_method = "D651F6605A3DBCE632F06793020DB084")
    public void setMatchStatusClass(boolean flag) {
        matchStatusClass = flag;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.680 -0400", hash_original_method = "2D22A2D80C0943AA7141B4A0B4034D5B", hash_generated_method = "328DC3659145D790A503377035965296")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_211258245 = null; 
        String encoding = SIPConstants.SIP_VERSION_STRING + SP + statusCode;
        encoding += SP + reasonPhrase;
        encoding += NEWLINE;
        varB4EAC82CA7396A68D541C85D26508E83_211258245 = encoding;
        varB4EAC82CA7396A68D541C85D26508E83_211258245.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_211258245;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.682 -0400", hash_original_method = "756FD7B4E35B001597A1BAB462C97AFC", hash_generated_method = "C475CAA9A874014A5BF9BEF103F28B8B")
    public String getSipVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_356823940 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_356823940 = sipVersion;
        varB4EAC82CA7396A68D541C85D26508E83_356823940.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_356823940;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.683 -0400", hash_original_method = "08273B061292A48923EC30EEEA581059", hash_generated_method = "F74D155B2DEBCB03B4C5D6091A2B0DF0")
    public int getStatusCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_963140515 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_963140515;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.685 -0400", hash_original_method = "CA4528A98316683C1F54E337727EA693", hash_generated_method = "F21A5B49A5FFD760F313964C9B537091")
    public String getReasonPhrase() {
        String varB4EAC82CA7396A68D541C85D26508E83_1915604773 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1915604773 = reasonPhrase;
        varB4EAC82CA7396A68D541C85D26508E83_1915604773.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1915604773;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.685 -0400", hash_original_method = "B810A06FC4BF04031B4FF5A14EE77A78", hash_generated_method = "53F9AC2766DE93825A466772D60BE565")
    public void setSipVersion(String s) {
        sipVersion = s;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.686 -0400", hash_original_method = "C85C39756030BBC4F8AB42FF73F21E45", hash_generated_method = "6C0492B67AE3FB59C46B073C28241295")
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.686 -0400", hash_original_method = "6488565BF42DDD1E8B09A0AD1F358FD4", hash_generated_method = "743765ECFE339CAABC3918E02ABAA910")
    public void setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.687 -0400", hash_original_method = "4A94C9174C4923F8D67F5FDBFAEBA922", hash_generated_method = "32EA2B26262D9EA1676FA9DA693E9678")
    public String getVersionMajor() {
        String varB4EAC82CA7396A68D541C85D26508E83_2036155535 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_2113196089 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2036155535 = null;
        String major = null;
        boolean slash = false;
        {
            int i = 0;
            boolean var169D7E26B3087AB149CABEB542BD5E41_2003189614 = (i < sipVersion.length());
            {
                {
                    boolean varA8700FADE3EA4C6331A22B4D0D4435B3_2094835266 = (sipVersion.charAt(i) == '.');
                    slash = false;
                } 
                {
                    major = "" + sipVersion.charAt(i);
                    major += sipVersion.charAt(i);
                } 
                {
                    boolean var0DA5D2C2C152124EEAFDE0E0B2B4C8B3_1262204910 = (sipVersion.charAt(i) == '/');
                    slash = true;
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2113196089 = major;
        String varA7E53CE21691AB073D9660D615818899_687637973; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_687637973 = varB4EAC82CA7396A68D541C85D26508E83_2036155535;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_687637973 = varB4EAC82CA7396A68D541C85D26508E83_2113196089;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_687637973.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_687637973;
        
        
            
        
        
        
            
                
            
                
                    
                
                    
            
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.688 -0400", hash_original_method = "4EF04355E0E174C22FDE9BF5C4BD4B3D", hash_generated_method = "B1FE0B8428F9C48F0767508133C8F17F")
    public String getVersionMinor() {
        String varB4EAC82CA7396A68D541C85D26508E83_1815724863 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1106945216 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1815724863 = null;
        String minor = null;
        boolean dot = false;
        {
            int i = 0;
            boolean var169D7E26B3087AB149CABEB542BD5E41_1586611572 = (i < sipVersion.length());
            {
                {
                    minor = "" + sipVersion.charAt(i);
                    minor += sipVersion.charAt(i);
                } 
                {
                    boolean varA8700FADE3EA4C6331A22B4D0D4435B3_279120220 = (sipVersion.charAt(i) == '.');
                    dot = true;
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1106945216 = minor;
        String varA7E53CE21691AB073D9660D615818899_900692915; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_900692915 = varB4EAC82CA7396A68D541C85D26508E83_1815724863;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_900692915 = varB4EAC82CA7396A68D541C85D26508E83_1106945216;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_900692915.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_900692915;
        
        
            
        
        
        
            
                
                    
                
                    
            
            
                
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.688 -0400", hash_original_field = "4B6E80C7F602EB9377EDEB27867E9ED3", hash_generated_field = "8EFFA514AA9B40DA5920D5D322D825C6")

    private static final long serialVersionUID = -4738092215519950414L;
}

