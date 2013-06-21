package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class HttpRetryException extends IOException {
    private int responseCode;
    private String location = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.796 -0400", hash_original_method = "D66D6037990D1320EE8F2B514BE7C80E", hash_generated_method = "7C931933A0201FA2CA642518737EAD30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HttpRetryException(String detail, int code) {
        super(detail);
        dsTaint.addTaint(detail);
        dsTaint.addTaint(code);
        // ---------- Original Method ----------
        //responseCode = code;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.796 -0400", hash_original_method = "45DACDA3DE4782FE57BD28A2C8469CC6", hash_generated_method = "4F107ABB578D507D5129AC4A8DCB6F0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HttpRetryException(String detail, int code, String location) {
        super(detail);
        dsTaint.addTaint(detail);
        dsTaint.addTaint(location);
        dsTaint.addTaint(code);
        // ---------- Original Method ----------
        //responseCode = code;
        //this.location = location;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.796 -0400", hash_original_method = "958E0B7EB30F5353747022B831D2FD74", hash_generated_method = "A941BDFD2013D229D958641548CDE8D4")
    @DSModeled(DSC.SAFE)
    public String getLocation() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return location;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.796 -0400", hash_original_method = "8E1778B505008D9459C329AADF141931", hash_generated_method = "DE7C103F39E4DF7AB017E253AFA032DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getReason() {
        String var00B89656DBC4A557EC1B04ADBC5951F6_510198712 = (getMessage());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.796 -0400", hash_original_method = "DF7E8E86AB48E1A133C36E616BD5E9BF", hash_generated_method = "5A0DDF0D3474E5AC7476A68249C2B9B4")
    @DSModeled(DSC.SAFE)
    public int responseCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return responseCode;
    }

    
    private static final long serialVersionUID = -9186022286469111381L;
}

