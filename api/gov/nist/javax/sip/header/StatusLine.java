package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.SIPConstants;





public final class StatusLine extends SIPObject implements SipStatusLine {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.514 -0400", hash_original_field = "14881828949DC3B28E62BC34877C141D", hash_generated_field = "B8EAB804E3725A6DD3531CF15A699005")

    protected boolean matchStatusClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.514 -0400", hash_original_field = "66D2C8863084D21925D8C4AD8BD49102", hash_generated_field = "0E22CDA9223E852519CAF5EA7723F865")

    protected String sipVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.514 -0400", hash_original_field = "F9A31C6B3670C772D11230C8D4D1F33F", hash_generated_field = "AF3A2B27F74478A1F178EA853CB720C4")

    protected int statusCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.514 -0400", hash_original_field = "6A273AF93AEB8DA54D90CBF3B44D79AC", hash_generated_field = "C24AAD4BC0C98CB74977788D19F4D718")

    protected String reasonPhrase;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.514 -0400", hash_original_method = "952A7A04B56CA19CB087E879E7A74676", hash_generated_method = "264BF0CCCF59EFC8D77A76A8838AD81F")
    public  StatusLine() {
        reasonPhrase = null;
        sipVersion = SIPConstants.SIP_VERSION_STRING;
        // ---------- Original Method ----------
        //reasonPhrase = null;
        //sipVersion = SIPConstants.SIP_VERSION_STRING;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.515 -0400", hash_original_method = "F8EDA6D677CBC73EB8A3A71E43559895", hash_generated_method = "D861137BD2FCFD1082C789BE8F42BB45")
    public boolean match(Object matchObj) {
        addTaint(matchObj.getTaint());
        if(!(matchObj instanceof StatusLine))        
        {
        boolean var68934A3E9455FA72420237EB05902327_1289730555 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_170116136 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_170116136;
        }
        StatusLine sl = (StatusLine) matchObj;
        if(sl.matchExpression != null)        
        {
        boolean var75B812DCF4D1F33FA2EECFA8F8868774_2099312160 = (sl.matchExpression.match(this.encode()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_817587843 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_817587843;
        }
        if(sl.sipVersion != null && !sl.sipVersion.equals(sipVersion))        
        {
        boolean var68934A3E9455FA72420237EB05902327_316844528 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1962346543 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1962346543;
        }
        if(sl.statusCode != 0)        
        {
            if(matchStatusClass)            
            {
                int hiscode = sl.statusCode;
                String codeString = Integer.toString(sl.statusCode);
                String mycode = Integer.toString(statusCode);
                if(codeString.charAt(0) != mycode.charAt(0))                
                {
                boolean var68934A3E9455FA72420237EB05902327_1349489724 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1568644949 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1568644949;
                }
            } //End block
            else
            {
                if(statusCode != sl.statusCode)                
                {
                boolean var68934A3E9455FA72420237EB05902327_35516955 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1451910510 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1451910510;
                }
            } //End block
        } //End block
        if(sl.reasonPhrase == null || reasonPhrase == sl.reasonPhrase)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_143149822 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_883708022 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_883708022;
        }
        boolean var543A6C3751FD2F24938A06D47715A160_368186939 = (reasonPhrase.equals(sl.reasonPhrase));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_783179860 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_783179860;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.515 -0400", hash_original_method = "72B66E964D13ABBD6BD5B9A3B23AE94A", hash_generated_method = "D651F6605A3DBCE632F06793020DB084")
    public void setMatchStatusClass(boolean flag) {
        matchStatusClass = flag;
        // ---------- Original Method ----------
        //matchStatusClass = flag;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.516 -0400", hash_original_method = "2D22A2D80C0943AA7141B4A0B4034D5B", hash_generated_method = "E6553E52BE185ED523ABD97B798BE94A")
    public String encode() {
        String encoding = SIPConstants.SIP_VERSION_STRING + SP + statusCode;
        if(reasonPhrase != null)        
        encoding += SP + reasonPhrase;
        encoding += NEWLINE;
String varE424DD5E6E58EB63E1272B71B5A81966_1587400462 =         encoding;
        varE424DD5E6E58EB63E1272B71B5A81966_1587400462.addTaint(taint);
        return varE424DD5E6E58EB63E1272B71B5A81966_1587400462;
        // ---------- Original Method ----------
        //String encoding = SIPConstants.SIP_VERSION_STRING + SP + statusCode;
        //if (reasonPhrase != null)
            //encoding += SP + reasonPhrase;
        //encoding += NEWLINE;
        //return encoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.516 -0400", hash_original_method = "756FD7B4E35B001597A1BAB462C97AFC", hash_generated_method = "5FF5DC28D51BD9A885C2D1282399E87B")
    public String getSipVersion() {
String var6122000D007F950F5F6ADABFD883424A_983698990 =         sipVersion;
        var6122000D007F950F5F6ADABFD883424A_983698990.addTaint(taint);
        return var6122000D007F950F5F6ADABFD883424A_983698990;
        // ---------- Original Method ----------
        //return sipVersion;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.516 -0400", hash_original_method = "08273B061292A48923EC30EEEA581059", hash_generated_method = "B8279431F94FBDAF376C310E3A913646")
    public int getStatusCode() {
        int varF9A31C6B3670C772D11230C8D4D1F33F_699580972 = (statusCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1160121387 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1160121387;
        // ---------- Original Method ----------
        //return statusCode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.517 -0400", hash_original_method = "CA4528A98316683C1F54E337727EA693", hash_generated_method = "2ACF486FD8572BCB207A2858D7743549")
    public String getReasonPhrase() {
String var78E6D063B709D1EA115EB9F821792EF2_968982111 =         reasonPhrase;
        var78E6D063B709D1EA115EB9F821792EF2_968982111.addTaint(taint);
        return var78E6D063B709D1EA115EB9F821792EF2_968982111;
        // ---------- Original Method ----------
        //return reasonPhrase;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.517 -0400", hash_original_method = "B810A06FC4BF04031B4FF5A14EE77A78", hash_generated_method = "53F9AC2766DE93825A466772D60BE565")
    public void setSipVersion(String s) {
        sipVersion = s;
        // ---------- Original Method ----------
        //sipVersion = s;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.517 -0400", hash_original_method = "C85C39756030BBC4F8AB42FF73F21E45", hash_generated_method = "6C0492B67AE3FB59C46B073C28241295")
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        // ---------- Original Method ----------
        //this.statusCode = statusCode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.518 -0400", hash_original_method = "6488565BF42DDD1E8B09A0AD1F358FD4", hash_generated_method = "743765ECFE339CAABC3918E02ABAA910")
    public void setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
        // ---------- Original Method ----------
        //this.reasonPhrase = reasonPhrase;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.519 -0400", hash_original_method = "4A94C9174C4923F8D67F5FDBFAEBA922", hash_generated_method = "FBB307586C255DC98DE27807479376D4")
    public String getVersionMajor() {
        if(sipVersion == null)        
        {
String var540C13E9E156B687226421B24F2DF178_2030134746 =         null;
        var540C13E9E156B687226421B24F2DF178_2030134746.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2030134746;
        }
        String major = null;
        boolean slash = false;
for(int i = 0;i < sipVersion.length();i++)
        {
            if(sipVersion.charAt(i) == '.')            
            slash = false;
            if(slash)            
            {
                if(major == null)                
                major = "" + sipVersion.charAt(i);
                else
                major += sipVersion.charAt(i);
            } //End block
            if(sipVersion.charAt(i) == '/')            
            slash = true;
        } //End block
String var8E02483E9748102D17FB12AAE8E4AFEA_1884277266 =         major;
        var8E02483E9748102D17FB12AAE8E4AFEA_1884277266.addTaint(taint);
        return var8E02483E9748102D17FB12AAE8E4AFEA_1884277266;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.520 -0400", hash_original_method = "4EF04355E0E174C22FDE9BF5C4BD4B3D", hash_generated_method = "CF84A0522C6DC07DF8F1CA00096313E9")
    public String getVersionMinor() {
        if(sipVersion == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1457601993 =         null;
        var540C13E9E156B687226421B24F2DF178_1457601993.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1457601993;
        }
        String minor = null;
        boolean dot = false;
for(int i = 0;i < sipVersion.length();i++)
        {
            if(dot)            
            {
                if(minor == null)                
                minor = "" + sipVersion.charAt(i);
                else
                minor += sipVersion.charAt(i);
            } //End block
            if(sipVersion.charAt(i) == '.')            
            dot = true;
        } //End block
String varEAA4AE06AD0186EF287EEA4C8E0F2076_1387308706 =         minor;
        varEAA4AE06AD0186EF287EEA4C8E0F2076_1387308706.addTaint(taint);
        return varEAA4AE06AD0186EF287EEA4C8E0F2076_1387308706;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.521 -0400", hash_original_field = "4B6E80C7F602EB9377EDEB27867E9ED3", hash_generated_field = "8EFFA514AA9B40DA5920D5D322D825C6")

    private static final long serialVersionUID = -4738092215519950414L;
}

