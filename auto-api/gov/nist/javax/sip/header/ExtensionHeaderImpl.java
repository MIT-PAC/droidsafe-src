package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ExtensionHeaderImpl extends SIPHeader implements javax.sip.header.ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.975 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "67AFEE1CECFFBA6E89413397161A2E7D")

    protected String value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.975 -0400", hash_original_method = "0D428BF693BC145CE79E697041FDBB13", hash_generated_method = "E16B4249E7E1D0E0C17B6F77DF99E8B5")
    public  ExtensionHeaderImpl() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.975 -0400", hash_original_method = "A937839923AA8BCCDCCEAF20D9D52A8A", hash_generated_method = "CE11635C6A2DA477CA25FDD83D492784")
    public  ExtensionHeaderImpl(String headerName) {
        super(headerName);
        addTaint(headerName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.980 -0400", hash_original_method = "484F8876E72CD5E2F0338DF99C79D0F8", hash_generated_method = "CE5DDBB2CC882FDCDEEB362EE6539269")
    public void setName(String headerName) {
        this.headerName = headerName;
        addTaint(headerName.getTaint());
        // ---------- Original Method ----------
        //this.headerName = headerName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.986 -0400", hash_original_method = "54A096BDAB783365763903A518BE6C1A", hash_generated_method = "811C079A212601355D5034023F0D4C0B")
    public void setValue(String value) {
        this.value = value;
        // ---------- Original Method ----------
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.987 -0400", hash_original_method = "1D785F814110552974451EFCFA0C5F26", hash_generated_method = "B36EBA3BB7BAFF0E2E77BA8C7AF31088")
    public String getHeaderValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_920111513 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_66740904 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1659576544 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_920111513 = this.value;
        } //End block
        {
            String encodedHdr;
            encodedHdr = null;
            try 
            {
                encodedHdr = this.encode();
            } //End block
            catch (Exception ex)
            {
                varB4EAC82CA7396A68D541C85D26508E83_66740904 = null;
            } //End block
            StringBuffer buffer;
            buffer = new StringBuffer(encodedHdr);
            {
                boolean varEBE4927262008ED3958A3F76EC2D70F1_1975055599 = (buffer.length() > 0 && buffer.charAt(0) != ':');
                {
                    buffer.deleteCharAt(0);
                } //End block
            } //End collapsed parenthetic
            buffer.deleteCharAt(0);
            this.value = buffer.toString().trim();
            varB4EAC82CA7396A68D541C85D26508E83_1659576544 = this.value;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1953889927; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1953889927 = varB4EAC82CA7396A68D541C85D26508E83_920111513;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1953889927 = varB4EAC82CA7396A68D541C85D26508E83_66740904;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1953889927 = varB4EAC82CA7396A68D541C85D26508E83_1659576544;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1953889927.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1953889927;
        // ---------- Original Method ----------
        //if (this.value != null) {
            //return this.value;
        //} else {
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
            //buffer.deleteCharAt(0);
            //this.value = buffer.toString().trim();
            //return this.value;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.988 -0400", hash_original_method = "AC75BAF5D25E8A26F15256B1C5A7867F", hash_generated_method = "34E1E976E44CD7D7507465E7521567BF")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_264026475 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_264026475 = new StringBuffer(this.headerName)
            .append(COLON)
            .append(SP)
            .append(this.value)
            .append(NEWLINE)
            .toString();
        varB4EAC82CA7396A68D541C85D26508E83_264026475.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_264026475;
        // ---------- Original Method ----------
        //return new StringBuffer(this.headerName)
            //.append(COLON)
            //.append(SP)
            //.append(this.value)
            //.append(NEWLINE)
            //.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.988 -0400", hash_original_method = "0A0703D799D76E700F53E1DA99AB2D69", hash_generated_method = "5E2372E806B1AF595D8B9A6456FE1018")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1676412737 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1676412737 = this.getHeaderValue();
        varB4EAC82CA7396A68D541C85D26508E83_1676412737.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1676412737;
        // ---------- Original Method ----------
        //return this.getHeaderValue();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.988 -0400", hash_original_field = "17BBB107160A1B885287E0DF95FB240C", hash_generated_field = "A482249ACC20A47556A77F1C671E90F5")

    private static long serialVersionUID = -8693922839612081849L;
}

