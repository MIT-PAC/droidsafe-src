package java.net;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;






public class HttpRetryException extends IOException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.443 -0400", hash_original_field = "30F8CC0A3AD81545F79B55CD4A8D8C8E", hash_generated_field = "8810125BFC74B6FEF019EA3191F499C8")

    private int responseCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.443 -0400", hash_original_field = "BBA7B50E1C5359F7795B933313020379", hash_generated_field = "457C4B2054EF6A16BE437326A94A7775")

    private String location = null;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.443 -0400", hash_original_method = "D66D6037990D1320EE8F2B514BE7C80E", hash_generated_method = "B68D8B5D0CA30FB7D2135CDDCF208B7E")
    public  HttpRetryException(String detail, int code) {
        super(detail);
        addTaint(detail.getTaint());
        responseCode = code;
        // ---------- Original Method ----------
        //responseCode = code;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.444 -0400", hash_original_method = "45DACDA3DE4782FE57BD28A2C8469CC6", hash_generated_method = "0BD758FA08FF697C707881F548033493")
    public  HttpRetryException(String detail, int code, String location) {
        super(detail);
        addTaint(detail.getTaint());
        responseCode = code;
        this.location = location;
        // ---------- Original Method ----------
        //responseCode = code;
        //this.location = location;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.444 -0400", hash_original_method = "958E0B7EB30F5353747022B831D2FD74", hash_generated_method = "2C308CB295E410B2E1F5B2E169F3D807")
    public String getLocation() {
String var96C70FF298E5697493B0D776E54760A4_1647804286 =         location;
        var96C70FF298E5697493B0D776E54760A4_1647804286.addTaint(taint);
        return var96C70FF298E5697493B0D776E54760A4_1647804286;
        // ---------- Original Method ----------
        //return location;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.445 -0400", hash_original_method = "8E1778B505008D9459C329AADF141931", hash_generated_method = "DA0740696703D4CCEECBBCF1CEA53E81")
    public String getReason() {
String var161DE919C6E3D4B838448EC95B86CE9B_1321505818 =         getMessage();
        var161DE919C6E3D4B838448EC95B86CE9B_1321505818.addTaint(taint);
        return var161DE919C6E3D4B838448EC95B86CE9B_1321505818;
        // ---------- Original Method ----------
        //return getMessage();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.445 -0400", hash_original_method = "DF7E8E86AB48E1A133C36E616BD5E9BF", hash_generated_method = "55FB696B459A103DFA15BBEE72750177")
    public int responseCode() {
        int var30F8CC0A3AD81545F79B55CD4A8D8C8E_8710980 = (responseCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1590044180 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1590044180;
        // ---------- Original Method ----------
        //return responseCode;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.445 -0400", hash_original_field = "5FFF23F42413F5127D31CA2D6E70B5D3", hash_generated_field = "DEA0935142292E37128D2221A5C069EE")

    private static final long serialVersionUID = -9186022286469111381L;
}

