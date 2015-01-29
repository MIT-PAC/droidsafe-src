package android.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;

public class LoggingEventHandler implements EventHandler {
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.285 -0400", hash_original_method = "2BC51DEB89C6AF0C6217972A72FE9112", hash_generated_method = "2BC51DEB89C6AF0C6217972A72FE9112")
    public LoggingEventHandler ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.636 -0500", hash_original_method = "9B877FF9BFB9C4944F8A279E52B62988", hash_generated_method = "C2368157723D43AE11E06F4A9E5EF67E")
    
public void requestSent() {
        HttpLog.v("LoggingEventHandler:requestSent()");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.639 -0500", hash_original_method = "9562CED72C3720167E8BBE6FC0F15333", hash_generated_method = "C7546D895DB238094E72032F92937856")
    
public void status(int major_version,
                       int minor_version,
                       int code, /* Status-Code value */
                       String reason_phrase) {
        if (HttpLog.LOGV) {
            HttpLog.v("LoggingEventHandler:status() major: " + major_version +
                  " minor: " + minor_version +
                  " code: " + code +
                  " reason: " + reason_phrase);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.641 -0500", hash_original_method = "8FE512AEA8F51EE9A35C32314D5687AD", hash_generated_method = "95B835D40052ABB897CB4F4C62AD414D")
    
public void headers(Headers headers) {
        if (HttpLog.LOGV) {
            HttpLog.v("LoggingEventHandler:headers()");
            HttpLog.v(headers.toString());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.643 -0500", hash_original_method = "A8D5EBFAB0280455A32A6C5CDBC44C4C", hash_generated_method = "CF633CF45BE056C07C069243B3958B03")
    
public void locationChanged(String newLocation, boolean permanent) {
        if (HttpLog.LOGV) {
            HttpLog.v("LoggingEventHandler: locationChanged() " + newLocation +
                      " permanent " + permanent);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.645 -0500", hash_original_method = "15D1AFABE65539E471DAB9FAA56FDCBD", hash_generated_method = "472B32E5182EDC3E70D38CD87168DA99")
    
public void data(byte[] data, int len) {
        if (HttpLog.LOGV) {
            HttpLog.v("LoggingEventHandler: data() " + len + " bytes");
        }
        // HttpLog.v(new String(data, 0, len));
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.648 -0500", hash_original_method = "1307000636F79B402F6C65745EBC0C33", hash_generated_method = "4855777B379BBEED0B38AA94EFD45B64")
    
public void endData() {
        if (HttpLog.LOGV) {
            HttpLog.v("LoggingEventHandler: endData() called");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.649 -0500", hash_original_method = "C33D898F8FAE31F96E6631A9B3801603", hash_generated_method = "33355BA04497C8007D074118A17E2FA4")
    
public void certificate(SslCertificate certificate) {
         if (HttpLog.LOGV) {
             HttpLog.v("LoggingEventHandler: certificate(): " + certificate);
         }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.652 -0500", hash_original_method = "EC9B7F9D07093F1D17DE76D8B4CD0C3B", hash_generated_method = "43D1960EF773A7E5C3C97C1703B8134E")
    
public void error(int id, String description) {
        if (HttpLog.LOGV) {
            HttpLog.v("LoggingEventHandler: error() called Id:" + id +
                      " description " + description);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.653 -0500", hash_original_method = "B335D5CE3F683FCF0CB8DE97E41DDFFF", hash_generated_method = "90BA52AF0ED51C3B13FFFDB1333F1177")
    
public boolean handleSslErrorRequest(SslError error) {
        if (HttpLog.LOGV) {
            HttpLog.v("LoggingEventHandler: handleSslErrorRequest():" + error);
        }
        // return false so that the caller thread won't wait forever
        return false;
    }
    
}

