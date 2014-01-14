package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public class HttpRetryException extends IOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.095 -0500", hash_original_field = "EF9264921A087F4B62A6C8BD38336DCB", hash_generated_field = "DEA0935142292E37128D2221A5C069EE")

    private static final long serialVersionUID = -9186022286469111381L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.097 -0500", hash_original_field = "D7B403E47F40E7B7D70137C0AFDC3473", hash_generated_field = "8810125BFC74B6FEF019EA3191F499C8")

    private int responseCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.100 -0500", hash_original_field = "E4800094DA5CC567DDD1BD548F3A2990", hash_generated_field = "457C4B2054EF6A16BE437326A94A7775")

    private String location = null;

    /**
     * Creates a new {@code HttpRetryException} instance with the specified
     * response code and the given detail message.
     *
     * @param detail
     *            the detail message for this exception.
     * @param code
     *            the HTTP response code from target host.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.102 -0500", hash_original_method = "D66D6037990D1320EE8F2B514BE7C80E", hash_generated_method = "0F761D883A54CD77D2D5E0DCD586B4DF")
    
public HttpRetryException(String detail, int code) {
        super(detail);
        responseCode = code;
    }

    /**
     * Creates a new {@code HttpRetryException} instance with the specified
     * response code, the given detail message and the value of the location
     * field from the response header.
     *
     * @param detail
     *            the detail message for this exception.
     * @param code
     *            the HTTP response code from target host.
     * @param location
     *            the destination URL of the redirection.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.105 -0500", hash_original_method = "45DACDA3DE4782FE57BD28A2C8469CC6", hash_generated_method = "B21C63635597F6D54887CD4DC24569AF")
    
public HttpRetryException(String detail, int code, String location) {
        super(detail);
        responseCode = code;
        this.location = location;
    }

    /**
     * Gets the location value.
     *
     * @return the stored location from the HTTP header.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.107 -0500", hash_original_method = "958E0B7EB30F5353747022B831D2FD74", hash_generated_method = "ADF84B7CD584A3086AA314B699B00CEF")
    
public String getLocation() {
        return location;
    }

    /**
     * Gets the detail message.
     *
     * @return the detail message.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.110 -0500", hash_original_method = "8E1778B505008D9459C329AADF141931", hash_generated_method = "01C0C67BB9AF9328133D03E5E8E174ED")
    
public String getReason() {
        return getMessage();
    }

    /**
     * Gets the response code.
     *
     * @return the HTTP response code.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.113 -0500", hash_original_method = "DF7E8E86AB48E1A133C36E616BD5E9BF", hash_generated_method = "69AC493B8337920777A23BE838A28F8E")
    
public int responseCode() {
        return responseCode;
    }
}

