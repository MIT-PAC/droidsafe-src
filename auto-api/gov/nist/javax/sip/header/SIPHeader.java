package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class SIPHeader extends SIPObject implements SIPHeaderNames, javax.sip.header.Header, HeaderExt {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.525 -0400", hash_original_field = "5B56D13EFD69E1602F78DED5D4B9CB80", hash_generated_field = "A59FED2AE4AD2264FB1F7BF89553485D")

    protected String headerName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.525 -0400", hash_original_method = "FE673D693BAC70694CA41EF39D92900D", hash_generated_method = "65F96AA6876FD65CD5AC5D1ED00B8886")
    protected  SIPHeader(String hname) {
        headerName = hname;
        // ---------- Original Method ----------
        //headerName = hname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.525 -0400", hash_original_method = "1EA533F6110BBCB8F937FFE2E4A5C224", hash_generated_method = "944F6867AF0E885EC31D94410F55FE87")
    public  SIPHeader() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.526 -0400", hash_original_method = "62BB7D98AC3AE2D1B44BF4A9C83BFCEA", hash_generated_method = "40F60240531BDB5A131AC2337339161A")
    public String getHeaderName() {
        String varB4EAC82CA7396A68D541C85D26508E83_610207155 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_610207155 = headerName;
        varB4EAC82CA7396A68D541C85D26508E83_610207155.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_610207155;
        // ---------- Original Method ----------
        //return headerName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.526 -0400", hash_original_method = "5A8D65821D08B5534EF9F59F256EB0ED", hash_generated_method = "68A381EA962E5052FFA631E6A5437E06")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1174940135 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1174940135 = this.headerName;
        varB4EAC82CA7396A68D541C85D26508E83_1174940135.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1174940135;
        // ---------- Original Method ----------
        //return this.headerName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.527 -0400", hash_original_method = "B4EB4BB0337C6A7359D4335CEE5552C5", hash_generated_method = "6CE49BAD21B0CDF875F602FC403D818D")
    public void setHeaderName(String hdrname) {
        headerName = hdrname;
        // ---------- Original Method ----------
        //headerName = hdrname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.527 -0400", hash_original_method = "4978FCECCFF9CE458180DF94EDCE0642", hash_generated_method = "A432B13CED454A6E896E9FFD1DB63557")
    public String getHeaderValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_637972074 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_390737112 = null; //Variable for return #2
        String encodedHdr;
        encodedHdr = null;
        try 
        {
            encodedHdr = this.encode();
        } //End block
        catch (Exception ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_637972074 = null;
        } //End block
        StringBuffer buffer;
        buffer = new StringBuffer(encodedHdr);
        {
            boolean var8ED0ECD51D0EE01B77341FFB604DA0BF_1105644835 = (buffer.length() > 0 && buffer.charAt(0) != ':');
            {
                buffer.deleteCharAt(0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA6481F2DD37075F8497C4FE156A6F563_1730272980 = (buffer.length() > 0);
            buffer.deleteCharAt(0);
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_390737112 = buffer.toString().trim();
        String varA7E53CE21691AB073D9660D615818899_655256698; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_655256698 = varB4EAC82CA7396A68D541C85D26508E83_637972074;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_655256698 = varB4EAC82CA7396A68D541C85D26508E83_390737112;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_655256698.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_655256698;
        // ---------- Original Method ----------
        //String encodedHdr = null;
        //try {
            //encodedHdr = this.encode();
        //} catch (Exception ex) {
            //return null;
        //}
        //StringBuffer buffer = new StringBuffer(encodedHdr);
        //while (buffer.length() > 0 && buffer.charAt(0) != ':') {
            //buffer.deleteCharAt(0);
        //}
        //if (buffer.length() > 0)
            //buffer.deleteCharAt(0);
        //return buffer.toString().trim();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.528 -0400", hash_original_method = "1CB55F4681FA88A1D00C1CC7A8265E42", hash_generated_method = "CBF2BFFC66BB07B9CC3C8FBCC4DE7A05")
    public boolean isHeaderList() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_976912649 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_976912649;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.528 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "FFE7F748CE7493B99302BFC6F5315CEA")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_333857588 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_333857588 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_333857588.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_333857588;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.535 -0400", hash_original_method = "D602371A78852934DC2C93C46C0FD81D", hash_generated_method = "3C4D74945ED046FD3A72FA303FF7B187")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1445857238 = null; //Variable for return #1
        buffer.append(this.headerName).append(COLON).append(SP);
        this.encodeBody(buffer);
        buffer.append(NEWLINE);
        varB4EAC82CA7396A68D541C85D26508E83_1445857238 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1445857238.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1445857238;
        // ---------- Original Method ----------
        //buffer.append(this.headerName).append(COLON).append(SP);
        //this.encodeBody(buffer);
        //buffer.append(NEWLINE);
        //return buffer;
    }

    
    protected abstract String encodeBody();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.538 -0400", hash_original_method = "112FD4376D79389C2460FE6A980E7021", hash_generated_method = "E412EC0EA60BC65BA10DCBB64E77E793")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_222288974 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_222288974 = buffer.append(encodeBody());
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_222288974.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_222288974;
        // ---------- Original Method ----------
        //return buffer.append(encodeBody());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.542 -0400", hash_original_method = "B7F53CD18FD7F00B77483EF4A0589C59", hash_generated_method = "713C587E6CDE40FD27EBAA14CA02E20C")
    public String getValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_1300246832 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1300246832 = this.getHeaderValue();
        varB4EAC82CA7396A68D541C85D26508E83_1300246832.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1300246832;
        // ---------- Original Method ----------
        //return this.getHeaderValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.543 -0400", hash_original_method = "78242797F449E5EBFB278CC5A6BC56D0", hash_generated_method = "C18763B86E0FFEF6236CD12E35FDE21B")
    public int hashCode() {
        int var4B8D37533CC12365BECFAB730FC9EDC2_1138747705 = (this.headerName.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1350609496 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1350609496;
        // ---------- Original Method ----------
        //return this.headerName.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.543 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "E3838D8EDAEAD7E3E549859E58FD7A57")
    public final String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_113288102 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_113288102 = this.encode();
        varB4EAC82CA7396A68D541C85D26508E83_113288102.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_113288102;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
}

