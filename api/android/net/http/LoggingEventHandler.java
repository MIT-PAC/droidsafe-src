package android.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.net.http.Headers;

public class LoggingEventHandler implements EventHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.306 -0400", hash_original_method = "2BC51DEB89C6AF0C6217972A72FE9112", hash_generated_method = "2BC51DEB89C6AF0C6217972A72FE9112")
    public LoggingEventHandler ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.307 -0400", hash_original_method = "9B877FF9BFB9C4944F8A279E52B62988", hash_generated_method = "10CA008D5591C89B89CC76B17D80A76F")
    public void requestSent() {
        HttpLog.v("LoggingEventHandler:requestSent()");
        // ---------- Original Method ----------
        //HttpLog.v("LoggingEventHandler:requestSent()");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.308 -0400", hash_original_method = "9562CED72C3720167E8BBE6FC0F15333", hash_generated_method = "C3779ABC45335DE423896BD63F1FE945")
    public void status(int major_version,
                       int minor_version,
                       int code, 
                       String reason_phrase) {
        addTaint(reason_phrase.getTaint());
        addTaint(code);
        addTaint(minor_version);
        addTaint(major_version);
    if(HttpLog.LOGV)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.309 -0400", hash_original_method = "8FE512AEA8F51EE9A35C32314D5687AD", hash_generated_method = "5BFA388A3D4CAC446E6E00E10DF2AACE")
    public void headers(Headers headers) {
        addTaint(headers.getTaint());
    if(HttpLog.LOGV)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.309 -0400", hash_original_method = "A8D5EBFAB0280455A32A6C5CDBC44C4C", hash_generated_method = "B33DFDF379FE8FCD5229C3BEEF46B22F")
    public void locationChanged(String newLocation, boolean permanent) {
        addTaint(permanent);
        addTaint(newLocation.getTaint());
    if(HttpLog.LOGV)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.310 -0400", hash_original_method = "15D1AFABE65539E471DAB9FAA56FDCBD", hash_generated_method = "A3635CFB244374AE799188D5B81A1818")
    public void data(byte[] data, int len) {
        addTaint(len);
        addTaint(data[0]);
    if(HttpLog.LOGV)        
        {
            HttpLog.v("LoggingEventHandler: data() " + len + " bytes");
        } //End block
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) {
            //HttpLog.v("LoggingEventHandler: data() " + len + " bytes");
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.310 -0400", hash_original_method = "1307000636F79B402F6C65745EBC0C33", hash_generated_method = "81706297E037DF2B8DB97D2D9DA05629")
    public void endData() {
    if(HttpLog.LOGV)        
        {
            HttpLog.v("LoggingEventHandler: endData() called");
        } //End block
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) {
            //HttpLog.v("LoggingEventHandler: endData() called");
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.310 -0400", hash_original_method = "C33D898F8FAE31F96E6631A9B3801603", hash_generated_method = "30B1D0432C5107E2D0EED276CF964190")
    public void certificate(SslCertificate certificate) {
        addTaint(certificate.getTaint());
    if(HttpLog.LOGV)        
        {
            HttpLog.v("LoggingEventHandler: certificate(): " + certificate);
        } //End block
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) {
             //HttpLog.v("LoggingEventHandler: certificate(): " + certificate);
         //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.311 -0400", hash_original_method = "EC9B7F9D07093F1D17DE76D8B4CD0C3B", hash_generated_method = "F3843303AAFFFC49EE5087DB4B3535E3")
    public void error(int id, String description) {
        addTaint(description.getTaint());
        addTaint(id);
    if(HttpLog.LOGV)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.311 -0400", hash_original_method = "B335D5CE3F683FCF0CB8DE97E41DDFFF", hash_generated_method = "CC6E754838C3EBBCAD3EE090A56AD805")
    public boolean handleSslErrorRequest(SslError error) {
        addTaint(error.getTaint());
    if(HttpLog.LOGV)        
        {
            HttpLog.v("LoggingEventHandler: handleSslErrorRequest():" + error);
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1065817028 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_763066982 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_763066982;
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) {
            //HttpLog.v("LoggingEventHandler: handleSslErrorRequest():" + error);
        //}
        //return false;
    }

    
}

