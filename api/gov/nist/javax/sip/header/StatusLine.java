package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.SIPConstants;

public final class StatusLine extends SIPObject implements SipStatusLine {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.445 -0400", hash_original_field = "14881828949DC3B28E62BC34877C141D", hash_generated_field = "B8EAB804E3725A6DD3531CF15A699005")

    protected boolean matchStatusClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.445 -0400", hash_original_field = "66D2C8863084D21925D8C4AD8BD49102", hash_generated_field = "0E22CDA9223E852519CAF5EA7723F865")

    protected String sipVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.445 -0400", hash_original_field = "F9A31C6B3670C772D11230C8D4D1F33F", hash_generated_field = "AF3A2B27F74478A1F178EA853CB720C4")

    protected int statusCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.445 -0400", hash_original_field = "6A273AF93AEB8DA54D90CBF3B44D79AC", hash_generated_field = "C24AAD4BC0C98CB74977788D19F4D718")

    protected String reasonPhrase;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.446 -0400", hash_original_method = "952A7A04B56CA19CB087E879E7A74676", hash_generated_method = "264BF0CCCF59EFC8D77A76A8838AD81F")
    public  StatusLine() {
        reasonPhrase = null;
        sipVersion = SIPConstants.SIP_VERSION_STRING;
        // ---------- Original Method ----------
        //reasonPhrase = null;
        //sipVersion = SIPConstants.SIP_VERSION_STRING;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.446 -0400", hash_original_method = "F8EDA6D677CBC73EB8A3A71E43559895", hash_generated_method = "77451088059095A2464DFBDD124E3AE4")
    public boolean match(Object matchObj) {
        addTaint(matchObj.getTaint());
    if(!(matchObj instanceof StatusLine))        
        {
        boolean var68934A3E9455FA72420237EB05902327_2097886905 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1772167386 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1772167386;
        }
        StatusLine sl = (StatusLine) matchObj;
    if(sl.matchExpression != null)        
        {
        boolean var75B812DCF4D1F33FA2EECFA8F8868774_2022411861 = (sl.matchExpression.match(this.encode()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1203003685 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1203003685;
        }
    if(sl.sipVersion != null && !sl.sipVersion.equals(sipVersion))        
        {
        boolean var68934A3E9455FA72420237EB05902327_2012949126 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_554099586 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_554099586;
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
                boolean var68934A3E9455FA72420237EB05902327_23197640 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1739773429 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1739773429;
                }
            } //End block
            else
            {
    if(statusCode != sl.statusCode)                
                {
                boolean var68934A3E9455FA72420237EB05902327_574447410 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_566819937 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_566819937;
                }
            } //End block
        } //End block
    if(sl.reasonPhrase == null || reasonPhrase == sl.reasonPhrase)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_980292062 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_645957118 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_645957118;
        }
        boolean var543A6C3751FD2F24938A06D47715A160_2107086765 = (reasonPhrase.equals(sl.reasonPhrase));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1822826938 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1822826938;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.447 -0400", hash_original_method = "72B66E964D13ABBD6BD5B9A3B23AE94A", hash_generated_method = "D651F6605A3DBCE632F06793020DB084")
    public void setMatchStatusClass(boolean flag) {
        matchStatusClass = flag;
        // ---------- Original Method ----------
        //matchStatusClass = flag;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.448 -0400", hash_original_method = "2D22A2D80C0943AA7141B4A0B4034D5B", hash_generated_method = "036925E563AE4C65CFAC57F11C0A22BB")
    public String encode() {
        String encoding = SIPConstants.SIP_VERSION_STRING + SP + statusCode;
    if(reasonPhrase != null)        
        encoding += SP + reasonPhrase;
        encoding += NEWLINE;
String varE424DD5E6E58EB63E1272B71B5A81966_1581948054 =         encoding;
        varE424DD5E6E58EB63E1272B71B5A81966_1581948054.addTaint(taint);
        return varE424DD5E6E58EB63E1272B71B5A81966_1581948054;
        // ---------- Original Method ----------
        //String encoding = SIPConstants.SIP_VERSION_STRING + SP + statusCode;
        //if (reasonPhrase != null)
            //encoding += SP + reasonPhrase;
        //encoding += NEWLINE;
        //return encoding;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.448 -0400", hash_original_method = "756FD7B4E35B001597A1BAB462C97AFC", hash_generated_method = "584D467185D533CBA99D3022BBC15B17")
    public String getSipVersion() {
String var6122000D007F950F5F6ADABFD883424A_1506493500 =         sipVersion;
        var6122000D007F950F5F6ADABFD883424A_1506493500.addTaint(taint);
        return var6122000D007F950F5F6ADABFD883424A_1506493500;
        // ---------- Original Method ----------
        //return sipVersion;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.449 -0400", hash_original_method = "08273B061292A48923EC30EEEA581059", hash_generated_method = "E076E592AF5CAF93D8610F2C0864568A")
    public int getStatusCode() {
        int varF9A31C6B3670C772D11230C8D4D1F33F_1283275120 = (statusCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1636951625 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1636951625;
        // ---------- Original Method ----------
        //return statusCode;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.449 -0400", hash_original_method = "CA4528A98316683C1F54E337727EA693", hash_generated_method = "E56C3D32A0FF238235E5C4C9B0A305FB")
    public String getReasonPhrase() {
String var78E6D063B709D1EA115EB9F821792EF2_1442648639 =         reasonPhrase;
        var78E6D063B709D1EA115EB9F821792EF2_1442648639.addTaint(taint);
        return var78E6D063B709D1EA115EB9F821792EF2_1442648639;
        // ---------- Original Method ----------
        //return reasonPhrase;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.450 -0400", hash_original_method = "B810A06FC4BF04031B4FF5A14EE77A78", hash_generated_method = "53F9AC2766DE93825A466772D60BE565")
    public void setSipVersion(String s) {
        sipVersion = s;
        // ---------- Original Method ----------
        //sipVersion = s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.450 -0400", hash_original_method = "C85C39756030BBC4F8AB42FF73F21E45", hash_generated_method = "6C0492B67AE3FB59C46B073C28241295")
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        // ---------- Original Method ----------
        //this.statusCode = statusCode;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.451 -0400", hash_original_method = "6488565BF42DDD1E8B09A0AD1F358FD4", hash_generated_method = "743765ECFE339CAABC3918E02ABAA910")
    public void setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
        // ---------- Original Method ----------
        //this.reasonPhrase = reasonPhrase;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.460 -0400", hash_original_method = "4A94C9174C4923F8D67F5FDBFAEBA922", hash_generated_method = "956EB491B9F6DD94C9924A4B1283842C")
    public String getVersionMajor() {
    if(sipVersion == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1765629390 =         null;
        var540C13E9E156B687226421B24F2DF178_1765629390.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1765629390;
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
String var8E02483E9748102D17FB12AAE8E4AFEA_2074229963 =         major;
        var8E02483E9748102D17FB12AAE8E4AFEA_2074229963.addTaint(taint);
        return var8E02483E9748102D17FB12AAE8E4AFEA_2074229963;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.460 -0400", hash_original_method = "4EF04355E0E174C22FDE9BF5C4BD4B3D", hash_generated_method = "B8E8E7B57641767ABF6600668B716933")
    public String getVersionMinor() {
    if(sipVersion == null)        
        {
String var540C13E9E156B687226421B24F2DF178_2036495522 =         null;
        var540C13E9E156B687226421B24F2DF178_2036495522.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2036495522;
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
String varEAA4AE06AD0186EF287EEA4C8E0F2076_576100804 =         minor;
        varEAA4AE06AD0186EF287EEA4C8E0F2076_576100804.addTaint(taint);
        return varEAA4AE06AD0186EF287EEA4C8E0F2076_576100804;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.461 -0400", hash_original_field = "4B6E80C7F602EB9377EDEB27867E9ED3", hash_generated_field = "8EFFA514AA9B40DA5920D5D322D825C6")

    private static final long serialVersionUID = -4738092215519950414L;
}

