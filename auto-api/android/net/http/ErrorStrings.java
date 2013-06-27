package android.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.util.Log;

public class ErrorStrings {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.059 -0400", hash_original_method = "15196F3BFA8B9637883B8AE296FFF8F2", hash_generated_method = "0498F89C8088675FDFC23A8A118F14B3")
    private  ErrorStrings() {
        // ---------- Original Method ----------
    }

    
        public static String getString(int errorCode, Context context) {
        return context.getText(getResource(errorCode)).toString();
    }

    
        public static int getResource(int errorCode) {
        switch(errorCode) {
            case EventHandler.OK:
                return com.android.internal.R.string.httpErrorOk;
            case EventHandler.ERROR:
                return com.android.internal.R.string.httpError;
            case EventHandler.ERROR_LOOKUP:
                return com.android.internal.R.string.httpErrorLookup;
            case EventHandler.ERROR_UNSUPPORTED_AUTH_SCHEME:
                return com.android.internal.R.string.httpErrorUnsupportedAuthScheme;
            case EventHandler.ERROR_AUTH:
                return com.android.internal.R.string.httpErrorAuth;
            case EventHandler.ERROR_PROXYAUTH:
                return com.android.internal.R.string.httpErrorProxyAuth;
            case EventHandler.ERROR_CONNECT:
                return com.android.internal.R.string.httpErrorConnect;
            case EventHandler.ERROR_IO:
                return com.android.internal.R.string.httpErrorIO;
            case EventHandler.ERROR_TIMEOUT:
                return com.android.internal.R.string.httpErrorTimeout;
            case EventHandler.ERROR_REDIRECT_LOOP:
                return com.android.internal.R.string.httpErrorRedirectLoop;
            case EventHandler.ERROR_UNSUPPORTED_SCHEME:
                return com.android.internal.R.string.httpErrorUnsupportedScheme;
            case EventHandler.ERROR_FAILED_SSL_HANDSHAKE:
                return com.android.internal.R.string.httpErrorFailedSslHandshake;
            case EventHandler.ERROR_BAD_URL:
                return com.android.internal.R.string.httpErrorBadUrl;
            case EventHandler.FILE_ERROR:
                return com.android.internal.R.string.httpErrorFile;
            case EventHandler.FILE_NOT_FOUND_ERROR:
                return com.android.internal.R.string.httpErrorFileNotFound;
            case EventHandler.TOO_MANY_REQUESTS_ERROR:
                return com.android.internal.R.string.httpErrorTooManyRequests;
            default:
                Log.w(LOGTAG, "Using generic message for unknown error code: " + errorCode);
                return com.android.internal.R.string.httpError;
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.060 -0400", hash_original_field = "612150595DFE4003266A71271894AF14", hash_generated_field = "D801BA9EDE316931B4F9A041D653A61D")

    private static String LOGTAG = "Http";
}

