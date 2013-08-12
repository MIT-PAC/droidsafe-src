package org.apache.http.impl;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Locale;

import org.apache.http.HttpStatus;
import org.apache.http.ReasonPhraseCatalog;






public class EnglishReasonPhraseCatalog implements ReasonPhraseCatalog {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.339 -0400", hash_original_method = "7E219D4204F52B71BC25A968ECCA9516", hash_generated_method = "B7F389F477620D30D508A0713D2A466A")
    protected  EnglishReasonPhraseCatalog() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.340 -0400", hash_original_method = "4DBCBC4442F2A5E0C839147542392D36", hash_generated_method = "A3BB6041BC303F400FC276B80D3BAFF3")
    public String getReason(int status, Locale loc) {
        addTaint(loc.getTaint());
        addTaint(status);
        if((status < 100) || (status >= 600))        
        {
            IllegalArgumentException var29C44D8F7746F3313015E7D6995B3353_1133272239 = new IllegalArgumentException
                ("Unknown category for status code " + status + ".");
            var29C44D8F7746F3313015E7D6995B3353_1133272239.addTaint(taint);
            throw var29C44D8F7746F3313015E7D6995B3353_1133272239;
        } //End block
        final int category = status / 100;
        final int subcode = status - 100*category;
        String reason = null;
        if(REASON_PHRASES[category].length > subcode)        
        reason = REASON_PHRASES[category][subcode];
String varD602C4C1684F7464133CA1A6851CC44A_797259413 =         reason;
        varD602C4C1684F7464133CA1A6851CC44A_797259413.addTaint(taint);
        return varD602C4C1684F7464133CA1A6851CC44A_797259413;
        // ---------- Original Method ----------
        //if ((status < 100) || (status >= 600)) {
            //throw new IllegalArgumentException
                //("Unknown category for status code " + status + ".");
        //}
        //final int category = status / 100;
        //final int subcode  = status - 100*category;
        //String reason = null;
        //if (REASON_PHRASES[category].length > subcode)
            //reason = REASON_PHRASES[category][subcode];
        //return reason;
    }

    
    @DSModeled(DSC.BAN)
    private static void setReason(int status, String reason) {
        final int category = status / 100;
        final int subcode  = status - 100*category;
        REASON_PHRASES[category][subcode] = reason;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.340 -0400", hash_original_field = "E2DE488DB38893EE28317061D8B6A367", hash_generated_field = "0300F07CA0C9570BD3547AEAE24AE263")

    public final static EnglishReasonPhraseCatalog INSTANCE =
        new EnglishReasonPhraseCatalog();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.340 -0400", hash_original_field = "57A5A1B8340254B4D85331038E93BEFD", hash_generated_field = "0AF8F9600212ED6C05BE344BC451D7F8")

    private static final String[][] REASON_PHRASES = new String[][]{
        null,
        new String[3],  
        new String[8],  
        new String[8],  
        new String[25], 
        new String[8]   
    };
    static {
        setReason(HttpStatus.SC_OK,
                  "OK");
        setReason(HttpStatus.SC_CREATED,
                  "Created");
        setReason(HttpStatus.SC_ACCEPTED,
                  "Accepted");
        setReason(HttpStatus.SC_NO_CONTENT,
                  "No Content");
        setReason(HttpStatus.SC_MOVED_PERMANENTLY,
                  "Moved Permanently");
        setReason(HttpStatus.SC_MOVED_TEMPORARILY,
                  "Moved Temporarily");
        setReason(HttpStatus.SC_NOT_MODIFIED,
                  "Not Modified");
        setReason(HttpStatus.SC_BAD_REQUEST,
                  "Bad Request");
        setReason(HttpStatus.SC_UNAUTHORIZED,
                  "Unauthorized");
        setReason(HttpStatus.SC_FORBIDDEN,
                  "Forbidden");
        setReason(HttpStatus.SC_NOT_FOUND,
                  "Not Found");
        setReason(HttpStatus.SC_INTERNAL_SERVER_ERROR,
                  "Internal Server Error");
        setReason(HttpStatus.SC_NOT_IMPLEMENTED,
                  "Not Implemented");
        setReason(HttpStatus.SC_BAD_GATEWAY,
                  "Bad Gateway");
        setReason(HttpStatus.SC_SERVICE_UNAVAILABLE,
                  "Service Unavailable");
        setReason(HttpStatus.SC_CONTINUE,
                  "Continue");
        setReason(HttpStatus.SC_TEMPORARY_REDIRECT,
                  "Temporary Redirect");
        setReason(HttpStatus.SC_METHOD_NOT_ALLOWED,
                  "Method Not Allowed");
        setReason(HttpStatus.SC_CONFLICT,
                  "Conflict");
        setReason(HttpStatus.SC_PRECONDITION_FAILED,
                  "Precondition Failed");
        setReason(HttpStatus.SC_REQUEST_TOO_LONG,
                  "Request Too Long");
        setReason(HttpStatus.SC_REQUEST_URI_TOO_LONG,
                  "Request-URI Too Long");
        setReason(HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE,
                  "Unsupported Media Type");
        setReason(HttpStatus.SC_MULTIPLE_CHOICES,
                  "Multiple Choices");
        setReason(HttpStatus.SC_SEE_OTHER,
                  "See Other");
        setReason(HttpStatus.SC_USE_PROXY,
                  "Use Proxy");
        setReason(HttpStatus.SC_PAYMENT_REQUIRED,
                  "Payment Required");
        setReason(HttpStatus.SC_NOT_ACCEPTABLE,
                  "Not Acceptable");
        setReason(HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED, 
                  "Proxy Authentication Required");
        setReason(HttpStatus.SC_REQUEST_TIMEOUT, 
                  "Request Timeout");
        setReason(HttpStatus.SC_SWITCHING_PROTOCOLS,
                  "Switching Protocols");
        setReason(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION,
                  "Non Authoritative Information");
        setReason(HttpStatus.SC_RESET_CONTENT,
                  "Reset Content");
        setReason(HttpStatus.SC_PARTIAL_CONTENT,
                  "Partial Content");
        setReason(HttpStatus.SC_GATEWAY_TIMEOUT,
                  "Gateway Timeout");
        setReason(HttpStatus.SC_HTTP_VERSION_NOT_SUPPORTED,
                  "Http Version Not Supported");
        setReason(HttpStatus.SC_GONE,
                  "Gone");
        setReason(HttpStatus.SC_LENGTH_REQUIRED,
                  "Length Required");
        setReason(HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE,
                  "Requested Range Not Satisfiable");
        setReason(HttpStatus.SC_EXPECTATION_FAILED,
                  "Expectation Failed");
        setReason(HttpStatus.SC_PROCESSING,
                  "Processing");
        setReason(HttpStatus.SC_MULTI_STATUS,
                  "Multi-Status");
        setReason(HttpStatus.SC_UNPROCESSABLE_ENTITY,
                  "Unprocessable Entity");
        setReason(HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE,
                  "Insufficient Space On Resource");
        setReason(HttpStatus.SC_METHOD_FAILURE,
                  "Method Failure");
        setReason(HttpStatus.SC_LOCKED,
                  "Locked");
        setReason(HttpStatus.SC_INSUFFICIENT_STORAGE,
                  "Insufficient Storage");
        setReason(HttpStatus.SC_FAILED_DEPENDENCY,
                  "Failed Dependency");
    }
    
}

