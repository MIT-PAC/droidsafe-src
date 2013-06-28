package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class SIPHeader extends SIPObject implements SIPHeaderNames, javax.sip.header.Header, HeaderExt {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.335 -0400", hash_original_field = "5B56D13EFD69E1602F78DED5D4B9CB80", hash_generated_field = "A59FED2AE4AD2264FB1F7BF89553485D")

    protected String headerName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.335 -0400", hash_original_method = "FE673D693BAC70694CA41EF39D92900D", hash_generated_method = "65F96AA6876FD65CD5AC5D1ED00B8886")
    protected  SIPHeader(String hname) {
        headerName = hname;
        // ---------- Original Method ----------
        //headerName = hname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.335 -0400", hash_original_method = "1EA533F6110BBCB8F937FFE2E4A5C224", hash_generated_method = "944F6867AF0E885EC31D94410F55FE87")
    public  SIPHeader() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.336 -0400", hash_original_method = "62BB7D98AC3AE2D1B44BF4A9C83BFCEA", hash_generated_method = "1625E0E0E490C151EB22C2BBF3C38A5B")
    public String getHeaderName() {
        String varB4EAC82CA7396A68D541C85D26508E83_717913317 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_717913317 = headerName;
        varB4EAC82CA7396A68D541C85D26508E83_717913317.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_717913317;
        // ---------- Original Method ----------
        //return headerName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.336 -0400", hash_original_method = "5A8D65821D08B5534EF9F59F256EB0ED", hash_generated_method = "08721D10C5D0FE35F50124BE019790D2")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_745260868 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_745260868 = this.headerName;
        varB4EAC82CA7396A68D541C85D26508E83_745260868.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_745260868;
        // ---------- Original Method ----------
        //return this.headerName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.336 -0400", hash_original_method = "B4EB4BB0337C6A7359D4335CEE5552C5", hash_generated_method = "6CE49BAD21B0CDF875F602FC403D818D")
    public void setHeaderName(String hdrname) {
        headerName = hdrname;
        // ---------- Original Method ----------
        //headerName = hdrname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.337 -0400", hash_original_method = "4978FCECCFF9CE458180DF94EDCE0642", hash_generated_method = "EC1050EAD3EC2C15EB372DA3668BD9CD")
    public String getHeaderValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_953324120 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_713163929 = null; //Variable for return #2
        String encodedHdr = null;
        try 
        {
            encodedHdr = this.encode();
        } //End block
        catch (Exception ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_953324120 = null;
        } //End block
        StringBuffer buffer = new StringBuffer(encodedHdr);
        {
            boolean var8ED0ECD51D0EE01B77341FFB604DA0BF_1949430199 = (buffer.length() > 0 && buffer.charAt(0) != ':');
            {
                buffer.deleteCharAt(0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA6481F2DD37075F8497C4FE156A6F563_796144438 = (buffer.length() > 0);
            buffer.deleteCharAt(0);
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_713163929 = buffer.toString().trim();
        String varA7E53CE21691AB073D9660D615818899_1759102804; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1759102804 = varB4EAC82CA7396A68D541C85D26508E83_953324120;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1759102804 = varB4EAC82CA7396A68D541C85D26508E83_713163929;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1759102804.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1759102804;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.337 -0400", hash_original_method = "1CB55F4681FA88A1D00C1CC7A8265E42", hash_generated_method = "649D75E39EE5F9697C21E0BEEA4D32FB")
    public boolean isHeaderList() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_261456481 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_261456481;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.338 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "9046C3BABBF84AF991DC43955BDE4CA2")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1384830161 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1384830161 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1384830161.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1384830161;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.339 -0400", hash_original_method = "D602371A78852934DC2C93C46C0FD81D", hash_generated_method = "97D42B9712E5FBFE5F0123191D76AFFA")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_967423405 = null; //Variable for return #1
        buffer.append(this.headerName).append(COLON).append(SP);
        this.encodeBody(buffer);
        buffer.append(NEWLINE);
        varB4EAC82CA7396A68D541C85D26508E83_967423405 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_967423405.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_967423405;
        // ---------- Original Method ----------
        //buffer.append(this.headerName).append(COLON).append(SP);
        //this.encodeBody(buffer);
        //buffer.append(NEWLINE);
        //return buffer;
    }

    
    protected abstract String encodeBody();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.340 -0400", hash_original_method = "112FD4376D79389C2460FE6A980E7021", hash_generated_method = "E6D53A3D8320D508ABCD400C2CEB2294")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1158865704 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1158865704 = buffer.append(encodeBody());
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1158865704.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1158865704;
        // ---------- Original Method ----------
        //return buffer.append(encodeBody());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.341 -0400", hash_original_method = "B7F53CD18FD7F00B77483EF4A0589C59", hash_generated_method = "A0FD23FC6FC12F4F581DAD25766B8BC6")
    public String getValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_93523851 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_93523851 = this.getHeaderValue();
        varB4EAC82CA7396A68D541C85D26508E83_93523851.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_93523851;
        // ---------- Original Method ----------
        //return this.getHeaderValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.341 -0400", hash_original_method = "78242797F449E5EBFB278CC5A6BC56D0", hash_generated_method = "F0517E6F2D11B6B6C9E90FDE833DBA63")
    public int hashCode() {
        int var4B8D37533CC12365BECFAB730FC9EDC2_1433255232 = (this.headerName.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1348909236 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1348909236;
        // ---------- Original Method ----------
        //return this.headerName.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.342 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "107B0DEC3344C85F00376272607A0892")
    public final String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1934020416 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1934020416 = this.encode();
        varB4EAC82CA7396A68D541C85D26508E83_1934020416.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1934020416;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
}

