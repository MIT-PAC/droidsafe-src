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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.534 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "D17BDF81091C1074F22AD5D363A1EFEF")

    protected GenericURI uri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.534 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "7A7B3881B98B4FAF9D2BB4D0900875E7")

    protected String method;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.534 -0400", hash_original_field = "66D2C8863084D21925D8C4AD8BD49102", hash_generated_field = "0E22CDA9223E852519CAF5EA7723F865")

    protected String sipVersion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.543 -0400", hash_original_method = "E4B7F4B41910EC919E5F140217342F7C", hash_generated_method = "EAF4B8E6F66C463F263AD3BE32A3D88C")
    public  RequestLine() {
        sipVersion = "SIP/2.0";
        // ---------- Original Method ----------
        //sipVersion = "SIP/2.0";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.544 -0400", hash_original_method = "FF0843F55ACEC2A8E2B69A1885A4A70E", hash_generated_method = "94E775391CAAE4815033C54C5EEE9CB9")
    public  RequestLine(GenericURI requestURI, String method) {
        this.uri = requestURI;
        this.method = method;
        this.sipVersion = "SIP/2.0";
        // ---------- Original Method ----------
        //this.uri = requestURI;
        //this.method = method;
        //this.sipVersion = "SIP/2.0";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.545 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "6DB4D416F7EF9C8BD210F150BE2FC03A")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_361953076 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_361953076 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_361953076.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_361953076;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.545 -0400", hash_original_method = "4F6DB28D47CD31A53DCF9FC226D5B630", hash_generated_method = "F4661F49F5B0F31BB88BEDCD073E9346")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1008221625 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1008221625 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1008221625.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1008221625;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.546 -0400", hash_original_method = "F87CE2D8FFE3E61DA8A4BD8B0BDA0697", hash_generated_method = "2434A3C7FF104D69CB85EF0D0B98943F")
    public GenericURI getUri() {
        GenericURI varB4EAC82CA7396A68D541C85D26508E83_1353310677 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1353310677 = uri;
        varB4EAC82CA7396A68D541C85D26508E83_1353310677.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1353310677;
        // ---------- Original Method ----------
        //return uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.546 -0400", hash_original_method = "A65B682B0B822D8527FBE88A2FCA60FC", hash_generated_method = "A363DAB3C967895BBA57DF56F184F1F0")
    public String getMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_1025622585 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1025622585 = method;
        varB4EAC82CA7396A68D541C85D26508E83_1025622585.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1025622585;
        // ---------- Original Method ----------
        //return method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.560 -0400", hash_original_method = "756FD7B4E35B001597A1BAB462C97AFC", hash_generated_method = "DF9FCE324D616BF3D2B33FF2747A29CD")
    public String getSipVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_14676848 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_14676848 = sipVersion;
        varB4EAC82CA7396A68D541C85D26508E83_14676848.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_14676848;
        // ---------- Original Method ----------
        //return sipVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.561 -0400", hash_original_method = "E1410A4CC0BAAD1440D0D1F349F6B893", hash_generated_method = "9490E77B55167E8C08B818C0A6425D28")
    public void setUri(URI uri) {
        this.uri = (GenericURI)uri;
        // ---------- Original Method ----------
        //this.uri = (GenericURI)uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.561 -0400", hash_original_method = "190C52163DA3AE651D57D1F9409B666E", hash_generated_method = "0A32A302E12C16AB7BD122DBD89AC3B9")
    public void setMethod(String method) {
        this.method = method;
        // ---------- Original Method ----------
        //this.method = method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.562 -0400", hash_original_method = "1D61DBA7A6626C97B8FBAF50D3DDD562", hash_generated_method = "5D5262EE7BD591D6E71A6ED43A58938F")
    public void setSipVersion(String version) {
        this.sipVersion = version;
        // ---------- Original Method ----------
        //this.sipVersion = version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.572 -0400", hash_original_method = "4D5FB483F06B9DEED18B900A5129C79B", hash_generated_method = "077381D0F4BF75F5EC90026C2D4C857E")
    public String getVersionMajor() {
        String varB4EAC82CA7396A68D541C85D26508E83_790512976 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_11785866 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_790512976 = null;
        String major;
        major = null;
        boolean slash;
        slash = false;
        {
            int i;
            i = 0;
            boolean var169D7E26B3087AB149CABEB542BD5E41_1789350399 = (i < sipVersion.length());
            {
                {
                    boolean varA8700FADE3EA4C6331A22B4D0D4435B3_1183039599 = (sipVersion.charAt(i) == '.');
                } //End collapsed parenthetic
                {
                    major = "" + sipVersion.charAt(i);
                    major += sipVersion.charAt(i);
                } //End block
                {
                    boolean var0DA5D2C2C152124EEAFDE0E0B2B4C8B3_1701924126 = (sipVersion.charAt(i) == '/');
                    slash = true;
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_11785866 = major;
        String varA7E53CE21691AB073D9660D615818899_442221109; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_442221109 = varB4EAC82CA7396A68D541C85D26508E83_790512976;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_442221109 = varB4EAC82CA7396A68D541C85D26508E83_11785866;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_442221109.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_442221109;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.586 -0400", hash_original_method = "4EF04355E0E174C22FDE9BF5C4BD4B3D", hash_generated_method = "741BE314D029A11199EF0717FA738BAC")
    public String getVersionMinor() {
        String varB4EAC82CA7396A68D541C85D26508E83_1667348843 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_586994564 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1667348843 = null;
        String minor;
        minor = null;
        boolean dot;
        dot = false;
        {
            int i;
            i = 0;
            boolean var169D7E26B3087AB149CABEB542BD5E41_1176303543 = (i < sipVersion.length());
            {
                {
                    minor = "" + sipVersion.charAt(i);
                    minor += sipVersion.charAt(i);
                } //End block
                {
                    boolean varA8700FADE3EA4C6331A22B4D0D4435B3_220629899 = (sipVersion.charAt(i) == '.');
                    dot = true;
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_586994564 = minor;
        String varA7E53CE21691AB073D9660D615818899_1590107608; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1590107608 = varB4EAC82CA7396A68D541C85D26508E83_1667348843;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1590107608 = varB4EAC82CA7396A68D541C85D26508E83_586994564;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1590107608.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1590107608;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.587 -0400", hash_original_method = "1239840CE17889EA14CF87055D293638", hash_generated_method = "E87C974A17B5D68DE9ECD408344FA757")
    public boolean equals(Object other) {
        boolean retval;
        {
            boolean varAC16F771BB29A32F2C455E410359AF13_1214143258 = (!other.getClass().equals(this.getClass()));
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_287674473 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_287674473;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.588 -0400", hash_original_method = "6B13CE61BDAF8DDF9CB0869D09E1BD0F", hash_generated_method = "AF6634FB565DC7F05AA720D1C874FED1")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1524776104 = null; //Variable for return #1
        RequestLine retval;
        retval = (RequestLine) super.clone();
        retval.uri = (GenericURI) this.uri.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1524776104 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1524776104.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1524776104;
        // ---------- Original Method ----------
        //RequestLine retval = (RequestLine) super.clone();
        //if (this.uri != null)
            //retval.uri = (GenericURI) this.uri.clone();
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.588 -0400", hash_original_field = "BA6FC0007D7D0CFBD660D7DEE05A678D", hash_generated_field = "D231EC2F738E3EDCDB096E9D9F333CB4")

    private static long serialVersionUID = -3286426172326043129L;
}

