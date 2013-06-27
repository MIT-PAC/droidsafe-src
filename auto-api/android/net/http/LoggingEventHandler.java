package android.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.net.http.Headers;

public class LoggingEventHandler implements EventHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.472 -0400", hash_original_method = "2BC51DEB89C6AF0C6217972A72FE9112", hash_generated_method = "2BC51DEB89C6AF0C6217972A72FE9112")
    public LoggingEventHandler ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.483 -0400", hash_original_method = "9B877FF9BFB9C4944F8A279E52B62988", hash_generated_method = "10CA008D5591C89B89CC76B17D80A76F")
    public void requestSent() {
        HttpLog.v("LoggingEventHandler:requestSent()");
        // ---------- Original Method ----------
        //HttpLog.v("LoggingEventHandler:requestSent()");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.484 -0400", hash_original_method = "9562CED72C3720167E8BBE6FC0F15333", hash_generated_method = "A2DB2D954D5DD2ECA5B120C4E32E33E7")
    public void status(int major_version,
                       int minor_version,
                       int code, 
                       String reason_phrase) {
        {
            HttpLog.v("LoggingEventHandler:status() major: " + major_version +
                  " minor: " + minor_version +
                  " code: " + code +
                  " reason: " + reason_phrase);
        } //End block
        addTaint(major_version);
        addTaint(minor_version);
        addTaint(code);
        addTaint(reason_phrase.getTaint());
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) {
            //HttpLog.v("LoggingEventHandler:status() major: " + major_version +
                  //" minor: " + minor_version +
                  //" code: " + code +
                  //" reason: " + reason_phrase);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.485 -0400", hash_original_method = "8FE512AEA8F51EE9A35C32314D5687AD", hash_generated_method = "F5880CDFB8291B120AE2B80E8E519673")
    public void headers(Headers headers) {
        {
            HttpLog.v("LoggingEventHandler:headers()");
            HttpLog.v(headers.toString());
        } //End block
        addTaint(headers.getTaint());
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) {
            //HttpLog.v("LoggingEventHandler:headers()");
            //HttpLog.v(headers.toString());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.486 -0400", hash_original_method = "A8D5EBFAB0280455A32A6C5CDBC44C4C", hash_generated_method = "4D21DF6D736AE34E4AA4D394D48D25E2")
    public void locationChanged(String newLocation, boolean permanent) {
        {
            HttpLog.v("LoggingEventHandler: locationChanged() " + newLocation +
                      " permanent " + permanent);
        } //End block
        addTaint(newLocation.getTaint());
        addTaint(permanent);
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) {
            //HttpLog.v("LoggingEventHandler: locationChanged() " + newLocation +
                      //" permanent " + permanent);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.490 -0400", hash_original_method = "15D1AFABE65539E471DAB9FAA56FDCBD", hash_generated_method = "B0FED91238261EBB932A4FC1986AEEAE")
    public void data(byte[] data, int len) {
        {
            HttpLog.v("LoggingEventHandler: data() " + len + " bytes");
        } //End block
        addTaint(data[0]);
        addTaint(len);
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) {
            //HttpLog.v("LoggingEventHandler: data() " + len + " bytes");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.491 -0400", hash_original_method = "1307000636F79B402F6C65745EBC0C33", hash_generated_method = "080FB57BA9672D0AB975E5DABB193E3B")
    public void endData() {
        {
            HttpLog.v("LoggingEventHandler: endData() called");
        } //End block
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) {
            //HttpLog.v("LoggingEventHandler: endData() called");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.506 -0400", hash_original_method = "C33D898F8FAE31F96E6631A9B3801603", hash_generated_method = "48ABC6E383E8A6F9EA732F2C1E09F08B")
    public void certificate(SslCertificate certificate) {
        {
            HttpLog.v("LoggingEventHandler: certificate(): " + certificate);
        } //End block
        addTaint(certificate.getTaint());
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) {
             //HttpLog.v("LoggingEventHandler: certificate(): " + certificate);
         //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.508 -0400", hash_original_method = "EC9B7F9D07093F1D17DE76D8B4CD0C3B", hash_generated_method = "E94ABB82D4EDB059712A14483406B529")
    public void error(int id, String description) {
        {
            HttpLog.v("LoggingEventHandler: error() called Id:" + id +
                      " description " + description);
        } //End block
        addTaint(id);
        addTaint(description.getTaint());
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) {
            //HttpLog.v("LoggingEventHandler: error() called Id:" + id +
                      //" description " + description);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.508 -0400", hash_original_method = "B335D5CE3F683FCF0CB8DE97E41DDFFF", hash_generated_method = "5326538CF00E51B0BA99DD800C8DB576")
    public boolean handleSslErrorRequest(SslError error) {
        {
            HttpLog.v("LoggingEventHandler: handleSslErrorRequest():" + error);
        } //End block
        addTaint(error.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1825332748 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1825332748;
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) {
            //HttpLog.v("LoggingEventHandler: handleSslErrorRequest():" + error);
        //}
        //return false;
    }

    
}

