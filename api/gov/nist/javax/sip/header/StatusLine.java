package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.SIPConstants;





public final class StatusLine extends SIPObject implements SipStatusLine {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.872 -0500", hash_original_field = "79365C69CBC5A241E22A20696C1E9E79", hash_generated_field = "8EFFA514AA9B40DA5920D5D322D825C6")

    private static final long serialVersionUID = -4738092215519950414L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.874 -0500", hash_original_field = "4B44DB64F7D6DC216D1F0EB2F476593E", hash_generated_field = "B8EAB804E3725A6DD3531CF15A699005")


    protected boolean matchStatusClass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.878 -0500", hash_original_field = "CE1553CBFC9C6BF901CA3EFBFD71C841", hash_generated_field = "0E22CDA9223E852519CAF5EA7723F865")

    protected String sipVersion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.881 -0500", hash_original_field = "7D58E974091311E54CFA3738B5F585EF", hash_generated_field = "AF3A2B27F74478A1F178EA853CB720C4")

    protected int statusCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.884 -0500", hash_original_field = "3FAD2DC6D188281A1174ECE25C647B14", hash_generated_field = "C24AAD4BC0C98CB74977788D19F4D718")

    protected String reasonPhrase;

    /** Default Constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.894 -0500", hash_original_method = "952A7A04B56CA19CB087E879E7A74676", hash_generated_method = "33EA3B99AA5D0F3D658D8AD4573ED50C")
    
public StatusLine() {
        reasonPhrase = null;
        sipVersion = SIPConstants.SIP_VERSION_STRING;
    }

    /** Match with a template.
     * Match only the response class if the last two digits of the
     * match templates are 0's
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.887 -0500", hash_original_method = "F8EDA6D677CBC73EB8A3A71E43559895", hash_generated_method = "8CDC305BF4AC73ACFA7382B000A0CBD5")
    
public boolean match(Object matchObj) {
        if (!(matchObj instanceof StatusLine))
            return false;
        StatusLine sl = (StatusLine) matchObj;
        // A pattern matcher has been registered.
        if (sl.matchExpression != null)
            return sl.matchExpression.match(this.encode());
        // no patter matcher has been registered..
        if (sl.sipVersion != null && !sl.sipVersion.equals(sipVersion))
            return false;
        if (sl.statusCode != 0) {
            if (matchStatusClass) {
                int hiscode = sl.statusCode;
                String codeString = Integer.toString(sl.statusCode);
                String mycode = Integer.toString(statusCode);
                if (codeString.charAt(0) != mycode.charAt(0))
                    return false;
            } else {
                if (statusCode != sl.statusCode)
                    return false;
            }
        }
        if (sl.reasonPhrase == null || reasonPhrase == sl.reasonPhrase)
            return true;
        return reasonPhrase.equals(sl.reasonPhrase);

    }

    /** set the flag on a match template.
     *If this set to true, then the whole status code is matched (default
     * behavior) else only the class of the response is matched.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.889 -0500", hash_original_method = "72B66E964D13ABBD6BD5B9A3B23AE94A", hash_generated_method = "A942BE3D1D9B1119AE8B959CD1FE58CB")
    
public void setMatchStatusClass(boolean flag) {
        matchStatusClass = flag;
    }

    /**
     * Encode into a canonical form.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.896 -0500", hash_original_method = "2D22A2D80C0943AA7141B4A0B4034D5B", hash_generated_method = "F9F2A0914D7FFA9C370363F5FF6BD17F")
    
public String encode() {
        String encoding = SIPConstants.SIP_VERSION_STRING + SP + statusCode;
        if (reasonPhrase != null)
            encoding += SP + reasonPhrase;
        encoding += NEWLINE;
        return encoding;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.SipStatusLine#getSipVersion()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.899 -0500", hash_original_method = "756FD7B4E35B001597A1BAB462C97AFC", hash_generated_method = "7635A3ADA2875913277DA776A6504B01")
    
public String getSipVersion() {
        return sipVersion;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.SipStatusLine#getStatusCode()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.902 -0500", hash_original_method = "08273B061292A48923EC30EEEA581059", hash_generated_method = "0AA4D52406821AA7CD81148A6B2FA4E2")
    
public int getStatusCode() {
        return statusCode;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.SipStatusLine#getReasonPhrase()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.905 -0500", hash_original_method = "CA4528A98316683C1F54E337727EA693", hash_generated_method = "7C91752073E4881A461B47118BAF05BE")
    
public String getReasonPhrase() {
        return reasonPhrase;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.SipStatusLine#setSipVersion(java.lang.String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.907 -0500", hash_original_method = "B810A06FC4BF04031B4FF5A14EE77A78", hash_generated_method = "E60A433331DF27DFE3F711D9C0483A67")
    
public void setSipVersion(String s) {
        sipVersion = s;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.SipStatusLine#setStatusCode(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.910 -0500", hash_original_method = "C85C39756030BBC4F8AB42FF73F21E45", hash_generated_method = "A52AD7A54F1BCF29F979B24A52338C8F")
    
public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.SipStatusLine#setReasonPhrase(java.lang.String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.913 -0500", hash_original_method = "6488565BF42DDD1E8B09A0AD1F358FD4", hash_generated_method = "7778C5A2A7D0B443D6302796B225ADED")
    
public void setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.SipStatusLine#getVersionMajor()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.916 -0500", hash_original_method = "4A94C9174C4923F8D67F5FDBFAEBA922", hash_generated_method = "CEFDE4BE8BC2C1A5D1E79833698FCCE6")
    
public String getVersionMajor() {
        if (sipVersion == null)
            return null;
        String major = null;
        boolean slash = false;
        for (int i = 0; i < sipVersion.length(); i++) {
            if (sipVersion.charAt(i) == '.')
                slash = false;
            if (slash) {
                if (major == null)
                    major = "" + sipVersion.charAt(i);
                else
                    major += sipVersion.charAt(i);
            }
            if (sipVersion.charAt(i) == '/')
                slash = true;
        }
        return major;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.SipStatusLine#getVersionMinor()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.919 -0500", hash_original_method = "4EF04355E0E174C22FDE9BF5C4BD4B3D", hash_generated_method = "6EA6974F2F8CEB1964A391173266EFF2")
    
public String getVersionMinor() {
        if (sipVersion == null)
            return null;
        String minor = null;
        boolean dot = false;
        for (int i = 0; i < sipVersion.length(); i++) {
            if (dot) {
                if (minor == null)
                    minor = "" + sipVersion.charAt(i);
                else
                    minor += sipVersion.charAt(i);
            }
            if (sipVersion.charAt(i) == '.')
                dot = true;
        }
        return minor;
    }
}

