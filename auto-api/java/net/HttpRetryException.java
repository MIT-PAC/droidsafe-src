package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class HttpRetryException extends IOException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.258 -0400", hash_original_field = "30F8CC0A3AD81545F79B55CD4A8D8C8E", hash_generated_field = "8810125BFC74B6FEF019EA3191F499C8")

    private int responseCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.258 -0400", hash_original_field = "BBA7B50E1C5359F7795B933313020379", hash_generated_field = "457C4B2054EF6A16BE437326A94A7775")

    private String location = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.258 -0400", hash_original_method = "D66D6037990D1320EE8F2B514BE7C80E", hash_generated_method = "B957715BA3C913DAEA34A492F914FD0E")
    public  HttpRetryException(String detail, int code) {
        super(detail);
        responseCode = code;
        addTaint(detail.getTaint());
        // ---------- Original Method ----------
        //responseCode = code;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.260 -0400", hash_original_method = "45DACDA3DE4782FE57BD28A2C8469CC6", hash_generated_method = "9593EB68E206ABA759438542C0AFCA29")
    public  HttpRetryException(String detail, int code, String location) {
        super(detail);
        responseCode = code;
        this.location = location;
        addTaint(detail.getTaint());
        // ---------- Original Method ----------
        //responseCode = code;
        //this.location = location;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.260 -0400", hash_original_method = "958E0B7EB30F5353747022B831D2FD74", hash_generated_method = "F85727A9FDB493B1DBB8FF6912A985DA")
    public String getLocation() {
        String varB4EAC82CA7396A68D541C85D26508E83_1554169873 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1554169873 = location;
        varB4EAC82CA7396A68D541C85D26508E83_1554169873.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1554169873;
        // ---------- Original Method ----------
        //return location;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.261 -0400", hash_original_method = "8E1778B505008D9459C329AADF141931", hash_generated_method = "B58A7CB6657162AB071E74D5B72B1CAC")
    public String getReason() {
        String varB4EAC82CA7396A68D541C85D26508E83_1519432241 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1519432241 = getMessage();
        varB4EAC82CA7396A68D541C85D26508E83_1519432241.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1519432241;
        // ---------- Original Method ----------
        //return getMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.261 -0400", hash_original_method = "DF7E8E86AB48E1A133C36E616BD5E9BF", hash_generated_method = "896A1AF0053DB91AA1E9AA3865974D5C")
    public int responseCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2016131284 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2016131284;
        // ---------- Original Method ----------
        //return responseCode;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.261 -0400", hash_original_field = "5FFF23F42413F5127D31CA2D6E70B5D3", hash_generated_field = "A1DA2BFC28BC866D3453EB4BC0D993AE")

    private static long serialVersionUID = -9186022286469111381L;
}

