package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.SIPConstants;

public final class StatusLine extends SIPObject implements SipStatusLine {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.594 -0400", hash_original_field = "14881828949DC3B28E62BC34877C141D", hash_generated_field = "B8EAB804E3725A6DD3531CF15A699005")

    protected boolean matchStatusClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.604 -0400", hash_original_field = "66D2C8863084D21925D8C4AD8BD49102", hash_generated_field = "0E22CDA9223E852519CAF5EA7723F865")

    protected String sipVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.604 -0400", hash_original_field = "F9A31C6B3670C772D11230C8D4D1F33F", hash_generated_field = "AF3A2B27F74478A1F178EA853CB720C4")

    protected int statusCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.604 -0400", hash_original_field = "6A273AF93AEB8DA54D90CBF3B44D79AC", hash_generated_field = "C24AAD4BC0C98CB74977788D19F4D718")

    protected String reasonPhrase;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.604 -0400", hash_original_method = "952A7A04B56CA19CB087E879E7A74676", hash_generated_method = "264BF0CCCF59EFC8D77A76A8838AD81F")
    public  StatusLine() {
        reasonPhrase = null;
        sipVersion = SIPConstants.SIP_VERSION_STRING;
        // ---------- Original Method ----------
        //reasonPhrase = null;
        //sipVersion = SIPConstants.SIP_VERSION_STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.605 -0400", hash_original_method = "F8EDA6D677CBC73EB8A3A71E43559895", hash_generated_method = "51CC7E63B1AFA5E2DA2D481209F8D818")
    public boolean match(Object matchObj) {
        StatusLine sl;
        sl = (StatusLine) matchObj;
        boolean varF11A090C3FA6483A7415F8E65776C7F8_1190398010 = (sl.matchExpression.match(this.encode()));
        {
            boolean varABD0525F68421F849E9ED95F10F8FB24_251688956 = (sl.sipVersion != null && !sl.sipVersion.equals(sipVersion));
        } //End collapsed parenthetic
        {
            {
                int hiscode;
                hiscode = sl.statusCode;
                String codeString;
                codeString = Integer.toString(sl.statusCode);
                String mycode;
                mycode = Integer.toString(statusCode);
                {
                    boolean var41CA100506627783ADDB3D130BD02D76_272997756 = (codeString.charAt(0) != mycode.charAt(0));
                } //End collapsed parenthetic
            } //End block
        } //End block
        boolean var4B48BB3783DA57C9FECD296FB4154CCF_230191089 = (reasonPhrase.equals(sl.reasonPhrase));
        addTaint(matchObj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1141862583 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1141862583;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.605 -0400", hash_original_method = "72B66E964D13ABBD6BD5B9A3B23AE94A", hash_generated_method = "D651F6605A3DBCE632F06793020DB084")
    public void setMatchStatusClass(boolean flag) {
        matchStatusClass = flag;
        // ---------- Original Method ----------
        //matchStatusClass = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.606 -0400", hash_original_method = "2D22A2D80C0943AA7141B4A0B4034D5B", hash_generated_method = "00785D672C806B586059C96BB388739D")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_2022225642 = null; //Variable for return #1
        String encoding;
        encoding = SIPConstants.SIP_VERSION_STRING + SP + statusCode;
        encoding += SP + reasonPhrase;
        encoding += NEWLINE;
        varB4EAC82CA7396A68D541C85D26508E83_2022225642 = encoding;
        varB4EAC82CA7396A68D541C85D26508E83_2022225642.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2022225642;
        // ---------- Original Method ----------
        //String encoding = SIPConstants.SIP_VERSION_STRING + SP + statusCode;
        //if (reasonPhrase != null)
            //encoding += SP + reasonPhrase;
        //encoding += NEWLINE;
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.606 -0400", hash_original_method = "756FD7B4E35B001597A1BAB462C97AFC", hash_generated_method = "255C4DD70C1301EB40E28C2DEBB5B482")
    public String getSipVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_347183465 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_347183465 = sipVersion;
        varB4EAC82CA7396A68D541C85D26508E83_347183465.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_347183465;
        // ---------- Original Method ----------
        //return sipVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.607 -0400", hash_original_method = "08273B061292A48923EC30EEEA581059", hash_generated_method = "FF756FA8BE41A2EFD6E864320B7AF81B")
    public int getStatusCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_931715158 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_931715158;
        // ---------- Original Method ----------
        //return statusCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.614 -0400", hash_original_method = "CA4528A98316683C1F54E337727EA693", hash_generated_method = "8770A9F1151801846FA49CE8F7CC5310")
    public String getReasonPhrase() {
        String varB4EAC82CA7396A68D541C85D26508E83_658651210 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_658651210 = reasonPhrase;
        varB4EAC82CA7396A68D541C85D26508E83_658651210.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_658651210;
        // ---------- Original Method ----------
        //return reasonPhrase;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.615 -0400", hash_original_method = "B810A06FC4BF04031B4FF5A14EE77A78", hash_generated_method = "53F9AC2766DE93825A466772D60BE565")
    public void setSipVersion(String s) {
        sipVersion = s;
        // ---------- Original Method ----------
        //sipVersion = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.615 -0400", hash_original_method = "C85C39756030BBC4F8AB42FF73F21E45", hash_generated_method = "6C0492B67AE3FB59C46B073C28241295")
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        // ---------- Original Method ----------
        //this.statusCode = statusCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.615 -0400", hash_original_method = "6488565BF42DDD1E8B09A0AD1F358FD4", hash_generated_method = "743765ECFE339CAABC3918E02ABAA910")
    public void setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
        // ---------- Original Method ----------
        //this.reasonPhrase = reasonPhrase;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.616 -0400", hash_original_method = "4A94C9174C4923F8D67F5FDBFAEBA922", hash_generated_method = "56440AD59DBB9A991E2571B7854501D2")
    public String getVersionMajor() {
        String varB4EAC82CA7396A68D541C85D26508E83_190013828 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_993468038 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_190013828 = null;
        String major;
        major = null;
        boolean slash;
        slash = false;
        {
            int i;
            i = 0;
            boolean var169D7E26B3087AB149CABEB542BD5E41_1918007272 = (i < sipVersion.length());
            {
                {
                    boolean varA8700FADE3EA4C6331A22B4D0D4435B3_2015608191 = (sipVersion.charAt(i) == '.');
                    slash = false;
                } //End collapsed parenthetic
                {
                    major = "" + sipVersion.charAt(i);
                    major += sipVersion.charAt(i);
                } //End block
                {
                    boolean var0DA5D2C2C152124EEAFDE0E0B2B4C8B3_1914223313 = (sipVersion.charAt(i) == '/');
                    slash = true;
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_993468038 = major;
        String varA7E53CE21691AB073D9660D615818899_1407202086; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1407202086 = varB4EAC82CA7396A68D541C85D26508E83_190013828;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1407202086 = varB4EAC82CA7396A68D541C85D26508E83_993468038;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1407202086.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1407202086;
        // ---------- Original Method ----------
        //if (sipVersion == null)
            //return null;
        //String major = null;
        //boolean slash = false;
        //for (int i = 0; i < sipVersion.length(); i++) {
            //if (sipVersion.charAt(i) == '.')
                //slash = false;
            //if (slash) {
                //if (major == null)
                    //major = "" + sipVersion.charAt(i);
                //else
                    //major += sipVersion.charAt(i);
            //}
            //if (sipVersion.charAt(i) == '/')
                //slash = true;
        //}
        //return major;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.621 -0400", hash_original_method = "4EF04355E0E174C22FDE9BF5C4BD4B3D", hash_generated_method = "164FDE4F8E046DFE404B2F4F3F9E9612")
    public String getVersionMinor() {
        String varB4EAC82CA7396A68D541C85D26508E83_2059007162 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1906914539 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_2059007162 = null;
        String minor;
        minor = null;
        boolean dot;
        dot = false;
        {
            int i;
            i = 0;
            boolean var169D7E26B3087AB149CABEB542BD5E41_1979142047 = (i < sipVersion.length());
            {
                {
                    minor = "" + sipVersion.charAt(i);
                    minor += sipVersion.charAt(i);
                } //End block
                {
                    boolean varA8700FADE3EA4C6331A22B4D0D4435B3_729109060 = (sipVersion.charAt(i) == '.');
                    dot = true;
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1906914539 = minor;
        String varA7E53CE21691AB073D9660D615818899_1543207319; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1543207319 = varB4EAC82CA7396A68D541C85D26508E83_2059007162;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1543207319 = varB4EAC82CA7396A68D541C85D26508E83_1906914539;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1543207319.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1543207319;
        // ---------- Original Method ----------
        //if (sipVersion == null)
            //return null;
        //String minor = null;
        //boolean dot = false;
        //for (int i = 0; i < sipVersion.length(); i++) {
            //if (dot) {
                //if (minor == null)
                    //minor = "" + sipVersion.charAt(i);
                //else
                    //minor += sipVersion.charAt(i);
            //}
            //if (sipVersion.charAt(i) == '.')
                //dot = true;
        //}
        //return minor;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.621 -0400", hash_original_field = "4B6E80C7F602EB9377EDEB27867E9ED3", hash_generated_field = "87B217D9B4D2BD1EF72D4149732F6B90")

    private static long serialVersionUID = -4738092215519950414L;
}

