package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.address.URI;
import gov.nist.javax.sip.address.*;

public class RequestLine extends SIPObject implements SipRequestLine {
    protected GenericURI uri;
    protected String method;
    protected String sipVersion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.142 -0400", hash_original_method = "E4B7F4B41910EC919E5F140217342F7C", hash_generated_method = "EAF4B8E6F66C463F263AD3BE32A3D88C")
    @DSModeled(DSC.SAFE)
    public RequestLine() {
        sipVersion = "SIP/2.0";
        // ---------- Original Method ----------
        //sipVersion = "SIP/2.0";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.142 -0400", hash_original_method = "FF0843F55ACEC2A8E2B69A1885A4A70E", hash_generated_method = "530839F3427D7694C1207EF7FC6281A2")
    @DSModeled(DSC.SAFE)
    public RequestLine(GenericURI requestURI, String method) {
        dsTaint.addTaint(requestURI.dsTaint);
        dsTaint.addTaint(method);
        this.sipVersion = "SIP/2.0";
        // ---------- Original Method ----------
        //this.uri = requestURI;
        //this.method = method;
        //this.sipVersion = "SIP/2.0";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.143 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "1020ABA87883EC83755AD13A66FD4466")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encode() {
        String varFFB45C40AF627644780ECFF5921CFE15_350224509 = (encode(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.143 -0400", hash_original_method = "4F6DB28D47CD31A53DCF9FC226D5B630", hash_generated_method = "F499D7C5008F9890EE9899AE9CD87BF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer encode(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        {
            buffer.append(method);
            buffer.append(SP);
        } //End block
        {
            uri.encode(buffer);
            buffer.append(SP);
        } //End block
        buffer.append(sipVersion);
        buffer.append(NEWLINE);
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (method != null) {
            //buffer.append(method);
            //buffer.append(SP);
        //}
        //if (uri != null) {
            //uri.encode(buffer);
            //buffer.append(SP);
        //}
        //buffer.append(sipVersion);
        //buffer.append(NEWLINE);
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.143 -0400", hash_original_method = "F87CE2D8FFE3E61DA8A4BD8B0BDA0697", hash_generated_method = "8BE94771182C5D29A8A70B2D114F143F")
    @DSModeled(DSC.SAFE)
    public GenericURI getUri() {
        return (GenericURI)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.143 -0400", hash_original_method = "A65B682B0B822D8527FBE88A2FCA60FC", hash_generated_method = "66F4EA2E5AA841011071F21690E6549B")
    @DSModeled(DSC.SAFE)
    public String getMethod() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.143 -0400", hash_original_method = "756FD7B4E35B001597A1BAB462C97AFC", hash_generated_method = "F9B4B9E1B6E4EE30ABD23BA7D5753068")
    @DSModeled(DSC.SAFE)
    public String getSipVersion() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return sipVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.144 -0400", hash_original_method = "E1410A4CC0BAAD1440D0D1F349F6B893", hash_generated_method = "9A5F390FFABB0F890B30ED921109FEBE")
    @DSModeled(DSC.SAFE)
    public void setUri(URI uri) {
        dsTaint.addTaint(uri.dsTaint);
        this.uri = (GenericURI)uri;
        // ---------- Original Method ----------
        //this.uri = (GenericURI)uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.144 -0400", hash_original_method = "190C52163DA3AE651D57D1F9409B666E", hash_generated_method = "2FB2DFE361C2097BA364F59DC35F98C0")
    @DSModeled(DSC.SAFE)
    public void setMethod(String method) {
        dsTaint.addTaint(method);
        // ---------- Original Method ----------
        //this.method = method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.144 -0400", hash_original_method = "1D61DBA7A6626C97B8FBAF50D3DDD562", hash_generated_method = "A147778726AA42FC6EC21C431652C93E")
    @DSModeled(DSC.SAFE)
    public void setSipVersion(String version) {
        dsTaint.addTaint(version);
        // ---------- Original Method ----------
        //this.sipVersion = version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.145 -0400", hash_original_method = "4D5FB483F06B9DEED18B900A5129C79B", hash_generated_method = "E93DE884D54C0FA462B990BCC3C4C177")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getVersionMajor() {
        String major;
        major = null;
        boolean slash;
        slash = false;
        {
            int i;
            i = 0;
            boolean var169D7E26B3087AB149CABEB542BD5E41_1867034778 = (i < sipVersion.length());
            {
                {
                    boolean varA8700FADE3EA4C6331A22B4D0D4435B3_1261349620 = (sipVersion.charAt(i) == '.');
                } //End collapsed parenthetic
                {
                    major = "" + sipVersion.charAt(i);
                    major += sipVersion.charAt(i);
                } //End block
                {
                    boolean var0DA5D2C2C152124EEAFDE0E0B2B4C8B3_1291664322 = (sipVersion.charAt(i) == '/');
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
                //break;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.145 -0400", hash_original_method = "4EF04355E0E174C22FDE9BF5C4BD4B3D", hash_generated_method = "A199AEB9788CB85CAF226F15E95DF56F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getVersionMinor() {
        String minor;
        minor = null;
        boolean dot;
        dot = false;
        {
            int i;
            i = 0;
            boolean var169D7E26B3087AB149CABEB542BD5E41_571711764 = (i < sipVersion.length());
            {
                {
                    minor = "" + sipVersion.charAt(i);
                    minor += sipVersion.charAt(i);
                } //End block
                {
                    boolean varA8700FADE3EA4C6331A22B4D0D4435B3_1382949526 = (sipVersion.charAt(i) == '.');
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.146 -0400", hash_original_method = "1239840CE17889EA14CF87055D293638", hash_generated_method = "9BFB3CE0A18AE5FE66A868D2077075C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        boolean retval;
        {
            boolean varAC16F771BB29A32F2C455E410359AF13_1361205665 = (!other.getClass().equals(this.getClass()));
        } //End collapsed parenthetic
        RequestLine that;
        that = (RequestLine) other;
        try 
        {
            retval =
                this.method.equals(that.method)
                    && this.uri.equals(that.uri)
                    && this.sipVersion.equals(that.sipVersion);
        } //End block
        catch (NullPointerException ex)
        {
            retval = false;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean retval;
        //if (!other.getClass().equals(this.getClass())) {
            //return false;
        //}
        //RequestLine that = (RequestLine) other;
        //try {
            //retval =
                //this.method.equals(that.method)
                    //&& this.uri.equals(that.uri)
                    //&& this.sipVersion.equals(that.sipVersion);
        //} catch (NullPointerException ex) {
            //retval = false;
        //}
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.146 -0400", hash_original_method = "6B13CE61BDAF8DDF9CB0869D09E1BD0F", hash_generated_method = "D5F4DBE60AE314CF2E47A65A6B2CFC39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        RequestLine retval;
        retval = (RequestLine) super.clone();
        retval.uri = (GenericURI) this.uri.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //RequestLine retval = (RequestLine) super.clone();
        //if (this.uri != null)
            //retval.uri = (GenericURI) this.uri.clone();
        //return retval;
    }

    
    private static final long serialVersionUID = -3286426172326043129L;
}

