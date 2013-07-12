package java.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public class HttpRetryException extends IOException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.611 -0400", hash_original_field = "30F8CC0A3AD81545F79B55CD4A8D8C8E", hash_generated_field = "8810125BFC74B6FEF019EA3191F499C8")

    private int responseCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.611 -0400", hash_original_field = "BBA7B50E1C5359F7795B933313020379", hash_generated_field = "457C4B2054EF6A16BE437326A94A7775")

    private String location = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.611 -0400", hash_original_method = "D66D6037990D1320EE8F2B514BE7C80E", hash_generated_method = "B68D8B5D0CA30FB7D2135CDDCF208B7E")
    public  HttpRetryException(String detail, int code) {
        super(detail);
        addTaint(detail.getTaint());
        responseCode = code;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.612 -0400", hash_original_method = "45DACDA3DE4782FE57BD28A2C8469CC6", hash_generated_method = "0BD758FA08FF697C707881F548033493")
    public  HttpRetryException(String detail, int code, String location) {
        super(detail);
        addTaint(detail.getTaint());
        responseCode = code;
        this.location = location;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.612 -0400", hash_original_method = "958E0B7EB30F5353747022B831D2FD74", hash_generated_method = "D0E544F56B961F6EACDDBABC38500400")
    public String getLocation() {
String var96C70FF298E5697493B0D776E54760A4_1789035068 =         location;
        var96C70FF298E5697493B0D776E54760A4_1789035068.addTaint(taint);
        return var96C70FF298E5697493B0D776E54760A4_1789035068;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.613 -0400", hash_original_method = "8E1778B505008D9459C329AADF141931", hash_generated_method = "9BD863C26F0CB246C24BABFF0C76D907")
    public String getReason() {
String var161DE919C6E3D4B838448EC95B86CE9B_68996577 =         getMessage();
        var161DE919C6E3D4B838448EC95B86CE9B_68996577.addTaint(taint);
        return var161DE919C6E3D4B838448EC95B86CE9B_68996577;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.613 -0400", hash_original_method = "DF7E8E86AB48E1A133C36E616BD5E9BF", hash_generated_method = "12D389D17B3FCC4EF1FA55497DF87EE8")
    public int responseCode() {
        int var30F8CC0A3AD81545F79B55CD4A8D8C8E_93032498 = (responseCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_429054006 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_429054006;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.613 -0400", hash_original_field = "5FFF23F42413F5127D31CA2D6E70B5D3", hash_generated_field = "DEA0935142292E37128D2221A5C069EE")

    private static final long serialVersionUID = -9186022286469111381L;
}

