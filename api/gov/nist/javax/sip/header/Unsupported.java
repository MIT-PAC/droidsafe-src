package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.text.ParseException;






public class Unsupported extends SIPHeader implements javax.sip.header.UnsupportedHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.634 -0400", hash_original_field = "7215DE10AF39CFD62967156F13524AEE", hash_generated_field = "EA9E843EF6C95A0999AD8B5523E0E7B3")

    protected String optionTag;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.634 -0400", hash_original_method = "7F4BD1C3AF5762ECCF124F3A56ADDC67", hash_generated_method = "20CE9BE220E1B76B99762452ADA57ECB")
    public  Unsupported() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.635 -0400", hash_original_method = "91BBA837F044D0A0A4874364E40F6125", hash_generated_method = "2C85D3B90F3F77053ABDF107887B68AA")
    public  Unsupported(String ot) {
        super(NAME);
        optionTag = ot;
        // ---------- Original Method ----------
        //optionTag = ot;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.635 -0400", hash_original_method = "9C711BE19A8C0E0A7CB116A3F753C6F0", hash_generated_method = "3D873FDF74DE1BF50DE89A20041E15E8")
    public String encodeBody() {
String var05FAD6E650FDF64778D62F7CDA67F749_2119904752 =         optionTag;
        var05FAD6E650FDF64778D62F7CDA67F749_2119904752.addTaint(taint);
        return var05FAD6E650FDF64778D62F7CDA67F749_2119904752;
        // ---------- Original Method ----------
        //return optionTag;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.635 -0400", hash_original_method = "CE304AE728C556B979775346D4C5B456", hash_generated_method = "F935ED8838DDD847A31DC523B0717C51")
    public String getOptionTag() {
String var05FAD6E650FDF64778D62F7CDA67F749_1864994719 =         optionTag;
        var05FAD6E650FDF64778D62F7CDA67F749_1864994719.addTaint(taint);
        return var05FAD6E650FDF64778D62F7CDA67F749_1864994719;
        // ---------- Original Method ----------
        //return optionTag;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.636 -0400", hash_original_method = "3B18B091D01592A1C9601DEA63572A7E", hash_generated_method = "7C4397414AC2E02B68491E3499B46F5D")
    public void setOptionTag(String o) throws ParseException {
        if(o == null)        
        {
        NullPointerException varE11526D4B61CEC11778CBDE441659081_1372403078 = new NullPointerException(
                "JAIN-SIP Exception, "
                    + " Unsupported, setOptionTag(), The option tag parameter is null");
        varE11526D4B61CEC11778CBDE441659081_1372403078.addTaint(taint);
        throw varE11526D4B61CEC11778CBDE441659081_1372403078;
        }
        optionTag = o;
        // ---------- Original Method ----------
        //if (o == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ " Unsupported, setOptionTag(), The option tag parameter is null");
        //optionTag = o;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.636 -0400", hash_original_field = "729B4B74845ACBCF4C5028ED87BE3471", hash_generated_field = "E6F62805C9FB301CFBA40BB42552946D")

    private static final long serialVersionUID = -2479414149440236199L;
}

