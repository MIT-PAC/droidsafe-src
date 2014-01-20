package org.apache.http.impl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Locale;

import org.apache.http.HttpStatus;
import org.apache.http.ReasonPhraseCatalog;

public class EnglishReasonPhraseCatalog implements ReasonPhraseCatalog {

    /**
     * Stores the given reason phrase, by status code.
     * Helper method to initialize the static lookup table.
     *
     * @param status    the status code for which to define the phrase
     * @param reason    the reason phrase for this status code
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.181 -0500", hash_original_method = "B27E2E37F6B3FC851CE3E6D12D897D85", hash_generated_method = "A2AC6B10722D96F29BEA07C5A03A7B42")
    
private static void setReason(int status, String reason) {
        final int category = status / 100;
        final int subcode  = status - 100*category;
        REASON_PHRASES[category][subcode] = reason;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.171 -0500", hash_original_field = "3F04E5126E1D1968D1E674ED94439EAD", hash_generated_field = "28FD85E5B9D69DCFAD3C72A1C0490DAE")

    /**
     * The default instance of this catalog.
     * This catalog is thread safe, so there typically
     * is no need to create other instances.
     */
    public final static EnglishReasonPhraseCatalog INSTANCE =
        new EnglishReasonPhraseCatalog();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.178 -0500", hash_original_field = "F9E44CBC77D75AAB579C584FD87CD166", hash_generated_field = "422C0F7E284A61F03AE9A1E35BA8BAB2")

    private static final String[][] REASON_PHRASES = new String[][]{
        null,
        new String[3],  // 1xx
        new String[8],  // 2xx
        new String[8],  // 3xx
        new String[25], // 4xx
        new String[8]   // 5xx
    };

    /**
     * Restricted default constructor, for derived classes.
     * If you need an instance of this class, use {@link #INSTANCE INSTANCE}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.173 -0500", hash_original_method = "7E219D4204F52B71BC25A968ECCA9516", hash_generated_method = "72ADC483D87ABD7A7321DAAD98293FF1")
    
protected EnglishReasonPhraseCatalog() {
        // no body
    }

    /**
     * Obtains the reason phrase for a status code.
     *
     * @param status    the status code, in the range 100-599
     * @param loc       ignored
     *
     * @return  the reason phrase, or <code>null</code>
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.176 -0500", hash_original_method = "4DBCBC4442F2A5E0C839147542392D36", hash_generated_method = "D8BA9FE692BA584DC67C4A9211465EE3")
    
public String getReason(int status, Locale loc) {
        if ((status < 100) || (status >= 600)) {
            throw new IllegalArgumentException
                ("Unknown category for status code " + status + ".");
        }

        final int category = status / 100;
        final int subcode  = status - 100*category;

        String reason = null;
        if (REASON_PHRASES[category].length > subcode)
            reason = REASON_PHRASES[category][subcode];

        return reason;
    }
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

