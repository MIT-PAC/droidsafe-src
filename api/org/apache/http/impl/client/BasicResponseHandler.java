package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.*;

import droidsafe.runtime.*;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.EntityUtils;

public class BasicResponseHandler implements ResponseHandler<String> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.261 -0400", hash_original_method = "2E943129A9E8C0C10C42D984806E844A", hash_generated_method = "2E943129A9E8C0C10C42D984806E844A")
    public BasicResponseHandler ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.267 -0400", hash_original_method = "2A5E0F0DC068B1165A25576DA590B50A", hash_generated_method = "B110CBD2261469E411B04223FE9CD60F")
    public String handleResponse(final HttpResponse response) throws HttpResponseException, IOException {
        addTaint(response.getTaint());
        StatusLine statusLine = response.getStatusLine();
        if(statusLine.getStatusCode() >= 300)        
        {
            HttpResponseException var7624D5E0C7BF35DD37B1E2795B552D38_511869565 = new HttpResponseException(statusLine.getStatusCode(),
                    statusLine.getReasonPhrase());
            var7624D5E0C7BF35DD37B1E2795B552D38_511869565.addTaint(taint);
            throw var7624D5E0C7BF35DD37B1E2795B552D38_511869565;
        } //End block
        HttpEntity entity = response.getEntity();
String varA746E92923BA5CC7927BB79D1B3F0152_2086527699 =         entity == null ? null : EntityUtils.toString(entity);
        varA746E92923BA5CC7927BB79D1B3F0152_2086527699.addTaint(taint);
        return varA746E92923BA5CC7927BB79D1B3F0152_2086527699;
        // ---------- Original Method ----------
        //StatusLine statusLine = response.getStatusLine();
        //if (statusLine.getStatusCode() >= 300) {
            //throw new HttpResponseException(statusLine.getStatusCode(),
                    //statusLine.getReasonPhrase());
        //}
        //HttpEntity entity = response.getEntity();
        //return entity == null ? null : EntityUtils.toString(entity);
    }

    
}

