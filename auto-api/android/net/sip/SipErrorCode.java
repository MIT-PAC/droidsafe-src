package android.net.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SipErrorCode {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.330 -0400", hash_original_method = "298DBB0089D5BDD0947985D624D66502", hash_generated_method = "A393C2CD781F4E1A7DF9F09461968B5C")
    @DSModeled(DSC.SAFE)
    private SipErrorCode() {
        // ---------- Original Method ----------
    }

    
        public static String toString(int errorCode) {
        switch (errorCode) {
            case NO_ERROR:
                return "NO_ERROR";
            case SOCKET_ERROR:
                return "SOCKET_ERROR";
            case SERVER_ERROR:
                return "SERVER_ERROR";
            case TRANSACTION_TERMINTED:
                return "TRANSACTION_TERMINTED";
            case CLIENT_ERROR:
                return "CLIENT_ERROR";
            case TIME_OUT:
                return "TIME_OUT";
            case INVALID_REMOTE_URI:
                return "INVALID_REMOTE_URI";
            case PEER_NOT_REACHABLE:
                return "PEER_NOT_REACHABLE";
            case INVALID_CREDENTIALS:
                return "INVALID_CREDENTIALS";
            case IN_PROGRESS:
                return "IN_PROGRESS";
            case DATA_CONNECTION_LOST:
                return "DATA_CONNECTION_LOST";
            case CROSS_DOMAIN_AUTHENTICATION:
                return "CROSS_DOMAIN_AUTHENTICATION";
            case SERVER_UNREACHABLE:
                return "SERVER_UNREACHABLE";
            default:
                return "UNKNOWN";
        }
    }

    
    public static final int NO_ERROR = 0;
    public static final int SOCKET_ERROR = -1;
    public static final int SERVER_ERROR = -2;
    public static final int TRANSACTION_TERMINTED = -3;
    public static final int CLIENT_ERROR = -4;
    public static final int TIME_OUT = -5;
    public static final int INVALID_REMOTE_URI = -6;
    public static final int PEER_NOT_REACHABLE = -7;
    public static final int INVALID_CREDENTIALS = -8;
    public static final int IN_PROGRESS = -9;
    public static final int DATA_CONNECTION_LOST = -10;
    public static final int CROSS_DOMAIN_AUTHENTICATION = -11;
    public static final int SERVER_UNREACHABLE = -12;
}

