package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ExtensionHeaderImpl extends SIPHeader implements javax.sip.header.ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.001 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "67AFEE1CECFFBA6E89413397161A2E7D")

    protected String value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.001 -0400", hash_original_method = "0D428BF693BC145CE79E697041FDBB13", hash_generated_method = "E16B4249E7E1D0E0C17B6F77DF99E8B5")
    public  ExtensionHeaderImpl() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.001 -0400", hash_original_method = "A937839923AA8BCCDCCEAF20D9D52A8A", hash_generated_method = "CE11635C6A2DA477CA25FDD83D492784")
    public  ExtensionHeaderImpl(String headerName) {
        super(headerName);
        addTaint(headerName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.017 -0400", hash_original_method = "484F8876E72CD5E2F0338DF99C79D0F8", hash_generated_method = "CE5DDBB2CC882FDCDEEB362EE6539269")
    public void setName(String headerName) {
        this.headerName = headerName;
        addTaint(headerName.getTaint());
        // ---------- Original Method ----------
        //this.headerName = headerName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.017 -0400", hash_original_method = "54A096BDAB783365763903A518BE6C1A", hash_generated_method = "811C079A212601355D5034023F0D4C0B")
    public void setValue(String value) {
        this.value = value;
        // ---------- Original Method ----------
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.018 -0400", hash_original_method = "1D785F814110552974451EFCFA0C5F26", hash_generated_method = "89A0A0050C8888EF56FBD14FF96DE4DB")
    public String getHeaderValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_1032409633 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1973112759 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_232961212 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_1032409633 = this.value;
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
                varB4EAC82CA7396A68D541C85D26508E83_1973112759 = null;
            } //End block
            StringBuffer buffer;
            buffer = new StringBuffer(encodedHdr);
            {
                boolean varEBE4927262008ED3958A3F76EC2D70F1_321828007 = (buffer.length() > 0 && buffer.charAt(0) != ':');
                {
                    buffer.deleteCharAt(0);
                } //End block
            } //End collapsed parenthetic
            buffer.deleteCharAt(0);
            this.value = buffer.toString().trim();
            varB4EAC82CA7396A68D541C85D26508E83_232961212 = this.value;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_657582548; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_657582548 = varB4EAC82CA7396A68D541C85D26508E83_1032409633;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_657582548 = varB4EAC82CA7396A68D541C85D26508E83_1973112759;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_657582548 = varB4EAC82CA7396A68D541C85D26508E83_232961212;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_657582548.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_657582548;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.019 -0400", hash_original_method = "AC75BAF5D25E8A26F15256B1C5A7867F", hash_generated_method = "5CBFE0282980E9625242D372E4939C7E")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_535437819 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_535437819 = new StringBuffer(this.headerName)
            .append(COLON)
            .append(SP)
            .append(this.value)
            .append(NEWLINE)
            .toString();
        varB4EAC82CA7396A68D541C85D26508E83_535437819.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_535437819;
        // ---------- Original Method ----------
        //return new StringBuffer(this.headerName)
            //.append(COLON)
            //.append(SP)
            //.append(this.value)
            //.append(NEWLINE)
            //.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.027 -0400", hash_original_method = "0A0703D799D76E700F53E1DA99AB2D69", hash_generated_method = "4D94A9DFF391D6F9497A69E79DB7D178")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_877001567 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_877001567 = this.getHeaderValue();
        varB4EAC82CA7396A68D541C85D26508E83_877001567.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_877001567;
        // ---------- Original Method ----------
        //return this.getHeaderValue();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.027 -0400", hash_original_field = "17BBB107160A1B885287E0DF95FB240C", hash_generated_field = "A482249ACC20A47556A77F1C671E90F5")

    private static long serialVersionUID = -8693922839612081849L;
}

