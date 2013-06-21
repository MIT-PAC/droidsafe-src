package android.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.net.http.Headers;

public class LoggingEventHandler implements EventHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.897 -0400", hash_original_method = "FF25D2B6B14F656022C454AFC1713FD4", hash_generated_method = "FF25D2B6B14F656022C454AFC1713FD4")
        public LoggingEventHandler ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.898 -0400", hash_original_method = "9B877FF9BFB9C4944F8A279E52B62988", hash_generated_method = "10CA008D5591C89B89CC76B17D80A76F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestSent() {
        HttpLog.v("LoggingEventHandler:requestSent()");
        // ---------- Original Method ----------
        //HttpLog.v("LoggingEventHandler:requestSent()");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.899 -0400", hash_original_method = "9562CED72C3720167E8BBE6FC0F15333", hash_generated_method = "71B9AA45217F39EB09E6222118C13481")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void status(int major_version,
                       int minor_version,
                       int code, 
                       String reason_phrase) {
        dsTaint.addTaint(minor_version);
        dsTaint.addTaint(reason_phrase);
        dsTaint.addTaint(major_version);
        dsTaint.addTaint(code);
        {
            HttpLog.v("LoggingEventHandler:status() major: " + major_version +
                  " minor: " + minor_version +
                  " code: " + code +
                  " reason: " + reason_phrase);
        } //End block
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) {
            //HttpLog.v("LoggingEventHandler:status() major: " + major_version +
                  //" minor: " + minor_version +
                  //" code: " + code +
                  //" reason: " + reason_phrase);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.899 -0400", hash_original_method = "8FE512AEA8F51EE9A35C32314D5687AD", hash_generated_method = "C6BFC215756EE90C922D567AAE7BFEA1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void headers(Headers headers) {
        dsTaint.addTaint(headers.dsTaint);
        {
            HttpLog.v("LoggingEventHandler:headers()");
            HttpLog.v(headers.toString());
        } //End block
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) {
            //HttpLog.v("LoggingEventHandler:headers()");
            //HttpLog.v(headers.toString());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.900 -0400", hash_original_method = "A8D5EBFAB0280455A32A6C5CDBC44C4C", hash_generated_method = "2065955D3A2FAC1A8E67DCC4F414E820")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void locationChanged(String newLocation, boolean permanent) {
        dsTaint.addTaint(permanent);
        dsTaint.addTaint(newLocation);
        {
            HttpLog.v("LoggingEventHandler: locationChanged() " + newLocation +
                      " permanent " + permanent);
        } //End block
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) {
            //HttpLog.v("LoggingEventHandler: locationChanged() " + newLocation +
                      //" permanent " + permanent);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.900 -0400", hash_original_method = "15D1AFABE65539E471DAB9FAA56FDCBD", hash_generated_method = "13C2848F9045B3992348588262CA34D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void data(byte[] data, int len) {
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(len);
        {
            HttpLog.v("LoggingEventHandler: data() " + len + " bytes");
        } //End block
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) {
            //HttpLog.v("LoggingEventHandler: data() " + len + " bytes");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.900 -0400", hash_original_method = "1307000636F79B402F6C65745EBC0C33", hash_generated_method = "080FB57BA9672D0AB975E5DABB193E3B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void endData() {
        {
            HttpLog.v("LoggingEventHandler: endData() called");
        } //End block
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) {
            //HttpLog.v("LoggingEventHandler: endData() called");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.901 -0400", hash_original_method = "C33D898F8FAE31F96E6631A9B3801603", hash_generated_method = "BFD80ECE049EF0026A065CA0582EE3F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void certificate(SslCertificate certificate) {
        dsTaint.addTaint(certificate.dsTaint);
        {
            HttpLog.v("LoggingEventHandler: certificate(): " + certificate);
        } //End block
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) {
             //HttpLog.v("LoggingEventHandler: certificate(): " + certificate);
         //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.901 -0400", hash_original_method = "EC9B7F9D07093F1D17DE76D8B4CD0C3B", hash_generated_method = "A124DD42763021C8D4F3750A8245A674")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void error(int id, String description) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(description);
        {
            HttpLog.v("LoggingEventHandler: error() called Id:" + id +
                      " description " + description);
        } //End block
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) {
            //HttpLog.v("LoggingEventHandler: error() called Id:" + id +
                      //" description " + description);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.902 -0400", hash_original_method = "B335D5CE3F683FCF0CB8DE97E41DDFFF", hash_generated_method = "B5D6D7C44284B1E085F9F1266C27B6C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean handleSslErrorRequest(SslError error) {
        dsTaint.addTaint(error.dsTaint);
        {
            HttpLog.v("LoggingEventHandler: handleSslErrorRequest():" + error);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) {
            //HttpLog.v("LoggingEventHandler: handleSslErrorRequest():" + error);
        //}
        //return false;
    }

    
}

