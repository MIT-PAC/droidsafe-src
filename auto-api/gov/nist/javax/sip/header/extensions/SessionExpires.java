package gov.nist.javax.sip.header.extensions;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.ParametersHeader;
import java.text.ParseException;
import javax.sip.InvalidArgumentException;
import javax.sip.header.ExtensionHeader;

public final class SessionExpires extends ParametersHeader implements ExtensionHeader, SessionExpiresHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.085 -0400", hash_original_field = "09BCB72D61C0D6D1EFF5336DA6881557", hash_generated_field = "C13B9F005337F50619E5092E1337E1D0")

    public int expires;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.086 -0400", hash_original_method = "A8246024A4BBDCEF318DB7F6B74C4E64", hash_generated_method = "0E464BB06220F15972D6EA6681E34A06")
    public  SessionExpires() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.099 -0400", hash_original_method = "47881175D7C463BCCB25030D767AD658", hash_generated_method = "49C8B59E00CE13260935F71E7B4C7B4A")
    public int getExpires() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1845658885 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1845658885;
        // ---------- Original Method ----------
        //return expires;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.116 -0400", hash_original_method = "A313D6724829247498596D0326F894CE", hash_generated_method = "1F94C2B6C4EFAB2003C10C5168D24F2A")
    public void setExpires(int expires) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad argument " + expires);
        this.expires = expires;
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad argument " + expires);
        //this.expires = expires;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.117 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.117 -0400", hash_original_method = "B1D6BF5FEA5681AEA45EA9D4CACD9FB8", hash_generated_method = "4C6F5C12F4283402D7C55BC53B7CB31F")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_652945625 = null; //Variable for return #1
        String retval;
        retval = Integer.toString(expires);
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_618362427 = (!parameters.isEmpty());
            {
                retval += SEMICOLON + parameters.encode();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_652945625 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_652945625.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_652945625;
        // ---------- Original Method ----------
        //String retval = Integer.toString(expires);
        //if (!parameters.isEmpty()) {
            //retval += SEMICOLON + parameters.encode();
        //}
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.118 -0400", hash_original_method = "5E6D9C5D9628C8E8194658511D516C38", hash_generated_method = "268D1BBB47D2D30EE618C2DC876AAD20")
    public String getRefresher() {
        String varB4EAC82CA7396A68D541C85D26508E83_680221475 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_680221475 = parameters.getParameter(REFRESHER);
        varB4EAC82CA7396A68D541C85D26508E83_680221475.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_680221475;
        // ---------- Original Method ----------
        //return parameters.getParameter(REFRESHER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.118 -0400", hash_original_method = "B765158B109DFF1FFF87124C5A68F884", hash_generated_method = "CFBA8027D56906088EF2EB555498C070")
    public void setRefresher(String refresher) {
        this.parameters.set(REFRESHER,refresher);
        addTaint(refresher.getTaint());
        // ---------- Original Method ----------
        //this.parameters.set(REFRESHER,refresher);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.118 -0400", hash_original_field = "1A90250BEA22A34094D11017692E5A52", hash_generated_field = "D44CFA417B8F36755294FBE5E8DD73BD")

    private static long serialVersionUID = 8765762413224043300L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.118 -0400", hash_original_field = "9BF636FEEC8D4B6523EE9B98ABA0A950", hash_generated_field = "440D53375B5C86D3B1C0A993DC1D1A5F")

    public static final String NAME = "Session-Expires";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.118 -0400", hash_original_field = "52C1E472405D97BD87845AB341E0D9DF", hash_generated_field = "D51D2CDCC34D9E34598982CCDA37DCD7")

    public static final String REFRESHER = "refresher";
}

