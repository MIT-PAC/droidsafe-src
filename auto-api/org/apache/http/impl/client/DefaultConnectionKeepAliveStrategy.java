package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

public class DefaultConnectionKeepAliveStrategy implements ConnectionKeepAliveStrategy {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.248 -0400", hash_original_method = "9F91BCEACEC5544FA32C5606F5B738A8", hash_generated_method = "9F91BCEACEC5544FA32C5606F5B738A8")
    public DefaultConnectionKeepAliveStrategy ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.250 -0400", hash_original_method = "A7D37BD826557BEBF753D4A8DC681C72", hash_generated_method = "CFFBA620E05D12D83DB58E8FD32D9565")
    public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP response may not be null");
        } //End block
        HeaderElementIterator it;
        it = new BasicHeaderElementIterator(
                response.headerIterator(HTTP.CONN_KEEP_ALIVE));
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1425368896 = (it.hasNext());
            {
                HeaderElement he;
                he = it.nextElement();
                String param;
                param = he.getName();
                String value;
                value = he.getValue();
                {
                    boolean var1EF3E3E54A567F7414EE77F38BA1CCC1_1103450631 = (value != null && param.equalsIgnoreCase("timeout"));
                    {
                        try 
                        {
                            long var827513AE700971AB86A3F1108926C8C5_1546324582 = (Long.parseLong(value) * 1000);
                        } //End block
                        catch (NumberFormatException ignore)
                        { }
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(response.getTaint());
        addTaint(context.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1864666810 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1864666810;
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

