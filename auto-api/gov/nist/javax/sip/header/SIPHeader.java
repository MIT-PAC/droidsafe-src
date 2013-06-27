package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class SIPHeader extends SIPObject implements SIPHeaderNames, javax.sip.header.Header, HeaderExt {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.469 -0400", hash_original_field = "5B56D13EFD69E1602F78DED5D4B9CB80", hash_generated_field = "A59FED2AE4AD2264FB1F7BF89553485D")

    protected String headerName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.475 -0400", hash_original_method = "FE673D693BAC70694CA41EF39D92900D", hash_generated_method = "65F96AA6876FD65CD5AC5D1ED00B8886")
    protected  SIPHeader(String hname) {
        headerName = hname;
        // ---------- Original Method ----------
        //headerName = hname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.477 -0400", hash_original_method = "1EA533F6110BBCB8F937FFE2E4A5C224", hash_generated_method = "944F6867AF0E885EC31D94410F55FE87")
    public  SIPHeader() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.478 -0400", hash_original_method = "62BB7D98AC3AE2D1B44BF4A9C83BFCEA", hash_generated_method = "9FBECBDDF71F5FC5363BEF28B73F9946")
    public String getHeaderName() {
        String varB4EAC82CA7396A68D541C85D26508E83_956588624 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_956588624 = headerName;
        varB4EAC82CA7396A68D541C85D26508E83_956588624.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_956588624;
        // ---------- Original Method ----------
        //return headerName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.481 -0400", hash_original_method = "5A8D65821D08B5534EF9F59F256EB0ED", hash_generated_method = "9811D8F14AD9BE26B2333C0432F8F53C")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1229222514 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1229222514 = this.headerName;
        varB4EAC82CA7396A68D541C85D26508E83_1229222514.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1229222514;
        // ---------- Original Method ----------
        //return this.headerName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.481 -0400", hash_original_method = "B4EB4BB0337C6A7359D4335CEE5552C5", hash_generated_method = "6CE49BAD21B0CDF875F602FC403D818D")
    public void setHeaderName(String hdrname) {
        headerName = hdrname;
        // ---------- Original Method ----------
        //headerName = hdrname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.482 -0400", hash_original_method = "4978FCECCFF9CE458180DF94EDCE0642", hash_generated_method = "D95BA3D39C34220B77A753C9E90D5535")
    public String getHeaderValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_1911086230 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_739621668 = null; //Variable for return #2
        String encodedHdr;
        encodedHdr = null;
        try 
        {
            encodedHdr = this.encode();
        } //End block
        catch (Exception ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1911086230 = null;
        } //End block
        StringBuffer buffer;
        buffer = new StringBuffer(encodedHdr);
        {
            boolean var8ED0ECD51D0EE01B77341FFB604DA0BF_1909789294 = (buffer.length() > 0 && buffer.charAt(0) != ':');
            {
                buffer.deleteCharAt(0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA6481F2DD37075F8497C4FE156A6F563_1128190076 = (buffer.length() > 0);
            buffer.deleteCharAt(0);
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_739621668 = buffer.toString().trim();
        String varA7E53CE21691AB073D9660D615818899_137346579; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_137346579 = varB4EAC82CA7396A68D541C85D26508E83_1911086230;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_137346579 = varB4EAC82CA7396A68D541C85D26508E83_739621668;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_137346579.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_137346579;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.484 -0400", hash_original_method = "1CB55F4681FA88A1D00C1CC7A8265E42", hash_generated_method = "F33C81ECEEBE9C8BA6171B2563A15FDB")
    public boolean isHeaderList() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1854576114 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1854576114;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.485 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "5F8D3AA0A055A263D2DB514284B04999")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_183986748 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_183986748 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_183986748.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_183986748;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.493 -0400", hash_original_method = "D602371A78852934DC2C93C46C0FD81D", hash_generated_method = "FAAF8C19E155524E515E15989EE126A9")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_905814347 = null; //Variable for return #1
        buffer.append(this.headerName).append(COLON).append(SP);
        this.encodeBody(buffer);
        buffer.append(NEWLINE);
        varB4EAC82CA7396A68D541C85D26508E83_905814347 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_905814347.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_905814347;
        // ---------- Original Method ----------
        //buffer.append(this.headerName).append(COLON).append(SP);
        //this.encodeBody(buffer);
        //buffer.append(NEWLINE);
        //return buffer;
    }

    
    protected abstract String encodeBody();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.500 -0400", hash_original_method = "112FD4376D79389C2460FE6A980E7021", hash_generated_method = "0C30CA404D54F916AD4F3EEB8D93E7E3")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_689506162 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_689506162 = buffer.append(encodeBody());
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_689506162.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_689506162;
        // ---------- Original Method ----------
        //return buffer.append(encodeBody());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.500 -0400", hash_original_method = "B7F53CD18FD7F00B77483EF4A0589C59", hash_generated_method = "CE3C37BB0D0E9E74A66C66F249CCF6C7")
    public String getValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_975508783 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_975508783 = this.getHeaderValue();
        varB4EAC82CA7396A68D541C85D26508E83_975508783.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_975508783;
        // ---------- Original Method ----------
        //return this.getHeaderValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.501 -0400", hash_original_method = "78242797F449E5EBFB278CC5A6BC56D0", hash_generated_method = "152707ACCDC77627306E7F942C3C9FA0")
    public int hashCode() {
        int var4B8D37533CC12365BECFAB730FC9EDC2_528894474 = (this.headerName.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_869986516 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_869986516;
        // ---------- Original Method ----------
        //return this.headerName.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.501 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "68D51B53366202541245D34DE2DEBAA0")
    public final String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_910517349 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_910517349 = this.encode();
        varB4EAC82CA7396A68D541C85D26508E83_910517349.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_910517349;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
}

