package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

public class DefaultConnectionKeepAliveStrategy implements ConnectionKeepAliveStrategy {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.378 -0400", hash_original_method = "9F91BCEACEC5544FA32C5606F5B738A8", hash_generated_method = "9F91BCEACEC5544FA32C5606F5B738A8")
    public DefaultConnectionKeepAliveStrategy ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.379 -0400", hash_original_method = "A7D37BD826557BEBF753D4A8DC681C72", hash_generated_method = "BF876BE82BFA53651122369DEB395F0C")
    public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
        addTaint(context.getTaint());
        addTaint(response.getTaint());
    if(response == null)        
        {
            IllegalArgumentException var81F7C558D1B895656E1A076743F59C7C_1752923292 = new IllegalArgumentException("HTTP response may not be null");
            var81F7C558D1B895656E1A076743F59C7C_1752923292.addTaint(taint);
            throw var81F7C558D1B895656E1A076743F59C7C_1752923292;
        } //End block
        HeaderElementIterator it = new BasicHeaderElementIterator(
                response.headerIterator(HTTP.CONN_KEEP_ALIVE));
        while
(it.hasNext())        
        {
            HeaderElement he = it.nextElement();
            String param = he.getName();
            String value = he.getValue();
    if(value != null && param.equalsIgnoreCase("timeout"))            
            {
                try 
                {
                    long varE1A866C15CA17E3F5CB174C34F12CB0C_296282985 = (Long.parseLong(value) * 1000);
                                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1088936538 = getTaintLong();
                    return var0F5264038205EDFB1AC05FBB0E8C5E94_1088936538;
                } //End block
                catch (NumberFormatException ignore)
                {
                } //End block
            } //End block
        } //End block
        long var6BB61E3B7BCE0931DA574D19D1D82C88_2065876529 = (-1);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1086772592 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1086772592;
        // ---------- Original Method ----------
        //if (response == null) {
            //throw new IllegalArgumentException("HTTP response may not be null");
        //}
        //HeaderElementIterator it = new BasicHeaderElementIterator(
                //response.headerIterator(HTTP.CONN_KEEP_ALIVE));
        //while (it.hasNext()) {
            //HeaderElement he = it.nextElement();
            //String param = he.getName(); 
            //String value = he.getValue();
            //if (value != null && param.equalsIgnoreCase("timeout")) {
                //try {
                    //return Long.parseLong(value) * 1000;
                //} catch(NumberFormatException ignore) {
                //}
            //}
        //}
        //return -1;
    }

    
}

