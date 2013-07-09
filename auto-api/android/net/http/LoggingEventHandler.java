package android.net.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.net.http.Headers;

public class LoggingEventHandler implements EventHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.033 -0400", hash_original_method = "2BC51DEB89C6AF0C6217972A72FE9112", hash_generated_method = "2BC51DEB89C6AF0C6217972A72FE9112")
    public LoggingEventHandler ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.034 -0400", hash_original_method = "9B877FF9BFB9C4944F8A279E52B62988", hash_generated_method = "10CA008D5591C89B89CC76B17D80A76F")
    public void requestSent() {
        HttpLog.v("LoggingEventHandler:requestSent()");
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.034 -0400", hash_original_method = "9562CED72C3720167E8BBE6FC0F15333", hash_generated_method = "A2DB2D954D5DD2ECA5B120C4E32E33E7")
    public void status(int major_version,
                       int minor_version,
                       int code, 
                       String reason_phrase) {
        {
            HttpLog.v("LoggingEventHandler:status() major: " + major_version +
                  " minor: " + minor_version +
                  " code: " + code +
                  " reason: " + reason_phrase);
        } 
        addTaint(major_version);
        addTaint(minor_version);
        addTaint(code);
        addTaint(reason_phrase.getTaint());
        
        
            
                  
                  
                  
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.035 -0400", hash_original_method = "8FE512AEA8F51EE9A35C32314D5687AD", hash_generated_method = "F5880CDFB8291B120AE2B80E8E519673")
    public void headers(Headers headers) {
        {
            HttpLog.v("LoggingEventHandler:headers()");
            HttpLog.v(headers.toString());
        } 
        addTaint(headers.getTaint());
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.035 -0400", hash_original_method = "A8D5EBFAB0280455A32A6C5CDBC44C4C", hash_generated_method = "4D21DF6D736AE34E4AA4D394D48D25E2")
    public void locationChanged(String newLocation, boolean permanent) {
        {
            HttpLog.v("LoggingEventHandler: locationChanged() " + newLocation +
                      " permanent " + permanent);
        } 
        addTaint(newLocation.getTaint());
        addTaint(permanent);
        
        
            
                      
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.036 -0400", hash_original_method = "15D1AFABE65539E471DAB9FAA56FDCBD", hash_generated_method = "B0FED91238261EBB932A4FC1986AEEAE")
    public void data(byte[] data, int len) {
        {
            HttpLog.v("LoggingEventHandler: data() " + len + " bytes");
        } 
        addTaint(data[0]);
        addTaint(len);
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.036 -0400", hash_original_method = "1307000636F79B402F6C65745EBC0C33", hash_generated_method = "080FB57BA9672D0AB975E5DABB193E3B")
    public void endData() {
        {
            HttpLog.v("LoggingEventHandler: endData() called");
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.036 -0400", hash_original_method = "C33D898F8FAE31F96E6631A9B3801603", hash_generated_method = "48ABC6E383E8A6F9EA732F2C1E09F08B")
    public void certificate(SslCertificate certificate) {
        {
            HttpLog.v("LoggingEventHandler: certificate(): " + certificate);
        } 
        addTaint(certificate.getTaint());
        
        
             
         
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.037 -0400", hash_original_method = "EC9B7F9D07093F1D17DE76D8B4CD0C3B", hash_generated_method = "E94ABB82D4EDB059712A14483406B529")
    public void error(int id, String description) {
        {
            HttpLog.v("LoggingEventHandler: error() called Id:" + id +
                      " description " + description);
        } 
        addTaint(id);
        addTaint(description.getTaint());
        
        
            
                      
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.037 -0400", hash_original_method = "B335D5CE3F683FCF0CB8DE97E41DDFFF", hash_generated_method = "11C71E617A65699530A315A7BECA5711")
    public boolean handleSslErrorRequest(SslError error) {
        {
            HttpLog.v("LoggingEventHandler: handleSslErrorRequest():" + error);
        } 
        addTaint(error.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1792431135 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1792431135;
        
        
            
        
        
    }

    
}

