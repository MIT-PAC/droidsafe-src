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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.420 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "D17BDF81091C1074F22AD5D363A1EFEF")

    protected GenericURI uri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.420 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "7A7B3881B98B4FAF9D2BB4D0900875E7")

    protected String method;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.421 -0400", hash_original_field = "66D2C8863084D21925D8C4AD8BD49102", hash_generated_field = "0E22CDA9223E852519CAF5EA7723F865")

    protected String sipVersion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.421 -0400", hash_original_method = "E4B7F4B41910EC919E5F140217342F7C", hash_generated_method = "EAF4B8E6F66C463F263AD3BE32A3D88C")
    public  RequestLine() {
        sipVersion = "SIP/2.0";
        // ---------- Original Method ----------
        //sipVersion = "SIP/2.0";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.422 -0400", hash_original_method = "FF0843F55ACEC2A8E2B69A1885A4A70E", hash_generated_method = "94E775391CAAE4815033C54C5EEE9CB9")
    public  RequestLine(GenericURI requestURI, String method) {
        this.uri = requestURI;
        this.method = method;
        this.sipVersion = "SIP/2.0";
        // ---------- Original Method ----------
        //this.uri = requestURI;
        //this.method = method;
        //this.sipVersion = "SIP/2.0";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.422 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "EBEF5015F5E1ECA05A79D660266D854E")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1856248735 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1856248735 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1856248735.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1856248735;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.423 -0400", hash_original_method = "4F6DB28D47CD31A53DCF9FC226D5B630", hash_generated_method = "E4E6265E1388B9306D4B1E9FBCE16981")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1485675101 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1485675101 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1485675101.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1485675101;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.423 -0400", hash_original_method = "F87CE2D8FFE3E61DA8A4BD8B0BDA0697", hash_generated_method = "D349D5CD338CF8A3E37B57AEE7CEF2F8")
    public GenericURI getUri() {
        GenericURI varB4EAC82CA7396A68D541C85D26508E83_288997334 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_288997334 = uri;
        varB4EAC82CA7396A68D541C85D26508E83_288997334.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_288997334;
        // ---------- Original Method ----------
        //return uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.424 -0400", hash_original_method = "A65B682B0B822D8527FBE88A2FCA60FC", hash_generated_method = "C62F16E9E2EF1043AB0145ABCB75AA37")
    public String getMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_1049399411 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1049399411 = method;
        varB4EAC82CA7396A68D541C85D26508E83_1049399411.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1049399411;
        // ---------- Original Method ----------
        //return method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.424 -0400", hash_original_method = "756FD7B4E35B001597A1BAB462C97AFC", hash_generated_method = "DFB72FBAB0D5D96924D3320AE8274A71")
    public String getSipVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_589605009 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_589605009 = sipVersion;
        varB4EAC82CA7396A68D541C85D26508E83_589605009.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_589605009;
        // ---------- Original Method ----------
        //return sipVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.438 -0400", hash_original_method = "E1410A4CC0BAAD1440D0D1F349F6B893", hash_generated_method = "9490E77B55167E8C08B818C0A6425D28")
    public void setUri(URI uri) {
        this.uri = (GenericURI)uri;
        // ---------- Original Method ----------
        //this.uri = (GenericURI)uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.438 -0400", hash_original_method = "190C52163DA3AE651D57D1F9409B666E", hash_generated_method = "0A32A302E12C16AB7BD122DBD89AC3B9")
    public void setMethod(String method) {
        this.method = method;
        // ---------- Original Method ----------
        //this.method = method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.438 -0400", hash_original_method = "1D61DBA7A6626C97B8FBAF50D3DDD562", hash_generated_method = "5D5262EE7BD591D6E71A6ED43A58938F")
    public void setSipVersion(String version) {
        this.sipVersion = version;
        // ---------- Original Method ----------
        //this.sipVersion = version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.453 -0400", hash_original_method = "4D5FB483F06B9DEED18B900A5129C79B", hash_generated_method = "1795AA0495736111B4F7A74414EB2202")
    public String getVersionMajor() {
        String varB4EAC82CA7396A68D541C85D26508E83_889010797 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_458217734 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_889010797 = null;
        String major;
        major = null;
        boolean slash;
        slash = false;
        {
            int i;
            i = 0;
            boolean var169D7E26B3087AB149CABEB542BD5E41_801525564 = (i < sipVersion.length());
            {
                {
                    boolean varA8700FADE3EA4C6331A22B4D0D4435B3_1196916400 = (sipVersion.charAt(i) == '.');
                } //End collapsed parenthetic
                {
                    major = "" + sipVersion.charAt(i);
                    major += sipVersion.charAt(i);
                } //End block
                {
                    boolean var0DA5D2C2C152124EEAFDE0E0B2B4C8B3_1457935264 = (sipVersion.charAt(i) == '/');
                    slash = true;
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_458217734 = major;
        String varA7E53CE21691AB073D9660D615818899_1026682979; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1026682979 = varB4EAC82CA7396A68D541C85D26508E83_889010797;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1026682979 = varB4EAC82CA7396A68D541C85D26508E83_458217734;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1026682979.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1026682979;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.454 -0400", hash_original_method = "4EF04355E0E174C22FDE9BF5C4BD4B3D", hash_generated_method = "4741D41629D5C1FF639AFD1D551082CF")
    public String getVersionMinor() {
        String varB4EAC82CA7396A68D541C85D26508E83_860514106 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1976174680 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_860514106 = null;
        String minor;
        minor = null;
        boolean dot;
        dot = false;
        {
            int i;
            i = 0;
            boolean var169D7E26B3087AB149CABEB542BD5E41_2015944798 = (i < sipVersion.length());
            {
                {
                    minor = "" + sipVersion.charAt(i);
                    minor += sipVersion.charAt(i);
                } //End block
                {
                    boolean varA8700FADE3EA4C6331A22B4D0D4435B3_579095076 = (sipVersion.charAt(i) == '.');
                    dot = true;
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1976174680 = minor;
        String varA7E53CE21691AB073D9660D615818899_702334294; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_702334294 = varB4EAC82CA7396A68D541C85D26508E83_860514106;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_702334294 = varB4EAC82CA7396A68D541C85D26508E83_1976174680;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_702334294.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_702334294;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.455 -0400", hash_original_method = "1239840CE17889EA14CF87055D293638", hash_generated_method = "9EE7D2859608CF9353C6B11C968E8126")
    public boolean equals(Object other) {
        boolean retval;
        {
            boolean varAC16F771BB29A32F2C455E410359AF13_1174534344 = (!other.getClass().equals(this.getClass()));
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
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_943613625 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_943613625;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.462 -0400", hash_original_method = "6B13CE61BDAF8DDF9CB0869D09E1BD0F", hash_generated_method = "3C7DC969CBEBC0C3135BECFD171BE560")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_236196588 = null; //Variable for return #1
        RequestLine retval;
        retval = (RequestLine) super.clone();
        retval.uri = (GenericURI) this.uri.clone();
        varB4EAC82CA7396A68D541C85D26508E83_236196588 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_236196588.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_236196588;
        // ---------- Original Method ----------
        //RequestLine retval = (RequestLine) super.clone();
        //if (this.uri != null)
            //retval.uri = (GenericURI) this.uri.clone();
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.463 -0400", hash_original_field = "BA6FC0007D7D0CFBD660D7DEE05A678D", hash_generated_field = "D231EC2F738E3EDCDB096E9D9F333CB4")

    private static long serialVersionUID = -3286426172326043129L;
}

