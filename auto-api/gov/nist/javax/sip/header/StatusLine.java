package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.SIPConstants;

public final class StatusLine extends SIPObject implements SipStatusLine {
    protected boolean matchStatusClass;
    protected String sipVersion;
    protected int statusCode;
    protected String reasonPhrase;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.415 -0400", hash_original_method = "952A7A04B56CA19CB087E879E7A74676", hash_generated_method = "264BF0CCCF59EFC8D77A76A8838AD81F")
    @DSModeled(DSC.SAFE)
    public StatusLine() {
        reasonPhrase = null;
        sipVersion = SIPConstants.SIP_VERSION_STRING;
        // ---------- Original Method ----------
        //reasonPhrase = null;
        //sipVersion = SIPConstants.SIP_VERSION_STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.415 -0400", hash_original_method = "F8EDA6D677CBC73EB8A3A71E43559895", hash_generated_method = "811C5EBBD4F4BA06C231D6913FB57F5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean match(Object matchObj) {
        dsTaint.addTaint(matchObj.dsTaint);
        StatusLine sl;
        sl = (StatusLine) matchObj;
        boolean varF11A090C3FA6483A7415F8E65776C7F8_1439064566 = (sl.matchExpression.match(this.encode()));
        {
            boolean varABD0525F68421F849E9ED95F10F8FB24_422035911 = (sl.sipVersion != null && !sl.sipVersion.equals(sipVersion));
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
                    boolean var41CA100506627783ADDB3D130BD02D76_870420894 = (codeString.charAt(0) != mycode.charAt(0));
                } //End collapsed parenthetic
            } //End block
        } //End block
        boolean var4B48BB3783DA57C9FECD296FB4154CCF_1421105834 = (reasonPhrase.equals(sl.reasonPhrase));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.415 -0400", hash_original_method = "72B66E964D13ABBD6BD5B9A3B23AE94A", hash_generated_method = "10498968F4755CAE740765E5DFE7C82D")
    @DSModeled(DSC.SAFE)
    public void setMatchStatusClass(boolean flag) {
        dsTaint.addTaint(flag);
        // ---------- Original Method ----------
        //matchStatusClass = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.416 -0400", hash_original_method = "2D22A2D80C0943AA7141B4A0B4034D5B", hash_generated_method = "C3040AEDF9248339875EB2793C2A84B6")
    @DSModeled(DSC.SAFE)
    public String encode() {
        String encoding;
        encoding = SIPConstants.SIP_VERSION_STRING + SP + statusCode;
        encoding += SP + reasonPhrase;
        encoding += NEWLINE;
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String encoding = SIPConstants.SIP_VERSION_STRING + SP + statusCode;
        //if (reasonPhrase != null)
            //encoding += SP + reasonPhrase;
        //encoding += NEWLINE;
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.416 -0400", hash_original_method = "756FD7B4E35B001597A1BAB462C97AFC", hash_generated_method = "F9B4B9E1B6E4EE30ABD23BA7D5753068")
    @DSModeled(DSC.SAFE)
    public String getSipVersion() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return sipVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.416 -0400", hash_original_method = "08273B061292A48923EC30EEEA581059", hash_generated_method = "5643050F4135AA249C3EAF67875A8A8D")
    @DSModeled(DSC.SAFE)
    public int getStatusCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return statusCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.416 -0400", hash_original_method = "CA4528A98316683C1F54E337727EA693", hash_generated_method = "29BCD54A47FD69455EE9FAEC58DF7282")
    @DSModeled(DSC.SAFE)
    public String getReasonPhrase() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return reasonPhrase;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.416 -0400", hash_original_method = "B810A06FC4BF04031B4FF5A14EE77A78", hash_generated_method = "40A6D9163CD4BD975804B945509DC77C")
    @DSModeled(DSC.SAFE)
    public void setSipVersion(String s) {
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
        //sipVersion = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.416 -0400", hash_original_method = "C85C39756030BBC4F8AB42FF73F21E45", hash_generated_method = "123F14395C621BBE16313DD12FD4AD06")
    @DSModeled(DSC.SAFE)
    public void setStatusCode(int statusCode) {
        dsTaint.addTaint(statusCode);
        // ---------- Original Method ----------
        //this.statusCode = statusCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.417 -0400", hash_original_method = "6488565BF42DDD1E8B09A0AD1F358FD4", hash_generated_method = "55DC2E06BDF14F23F8512E4B6AE0C16F")
    @DSModeled(DSC.SAFE)
    public void setReasonPhrase(String reasonPhrase) {
        dsTaint.addTaint(reasonPhrase);
        // ---------- Original Method ----------
        //this.reasonPhrase = reasonPhrase;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.417 -0400", hash_original_method = "4A94C9174C4923F8D67F5FDBFAEBA922", hash_generated_method = "4A5AEAC011070338763B16CDED3FF2D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getVersionMajor() {
        String major;
        major = null;
        boolean slash;
        slash = false;
        {
            int i;
            i = 0;
            boolean var169D7E26B3087AB149CABEB542BD5E41_51447471 = (i < sipVersion.length());
            {
                {
                    boolean varA8700FADE3EA4C6331A22B4D0D4435B3_758409067 = (sipVersion.charAt(i) == '.');
                    slash = false;
                } //End collapsed parenthetic
                {
                    major = "" + sipVersion.charAt(i);
                    major += sipVersion.charAt(i);
                } //End block
                {
                    boolean var0DA5D2C2C152124EEAFDE0E0B2B4C8B3_997602025 = (sipVersion.charAt(i) == '/');
                    slash = true;
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.418 -0400", hash_original_method = "4EF04355E0E174C22FDE9BF5C4BD4B3D", hash_generated_method = "07F62FB803F522CCE037192F3FEF040E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getVersionMinor() {
        String minor;
        minor = null;
        boolean dot;
        dot = false;
        {
            int i;
            i = 0;
            boolean var169D7E26B3087AB149CABEB542BD5E41_1711608887 = (i < sipVersion.length());
            {
                {
                    minor = "" + sipVersion.charAt(i);
                    minor += sipVersion.charAt(i);
                } //End block
                {
                    boolean varA8700FADE3EA4C6331A22B4D0D4435B3_1409255772 = (sipVersion.charAt(i) == '.');
                    dot = true;
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
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

    
    private static final long serialVersionUID = -4738092215519950414L;
}

