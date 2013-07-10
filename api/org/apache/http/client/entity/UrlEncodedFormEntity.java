package org.apache.http.client.entity;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;

public class UrlEncodedFormEntity extends StringEntity {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.740 -0400", hash_original_method = "2B79106283EA78C37FC06864AB4CC20F", hash_generated_method = "CA0C5C84655B6CF6F90C6701458D33FE")
    public  UrlEncodedFormEntity(
        final List <? extends NameValuePair> parameters, 
        final String encoding) throws UnsupportedEncodingException {
        super(URLEncodedUtils.format(parameters, encoding), 
            encoding);
        setContentType(URLEncodedUtils.CONTENT_TYPE);
        addTaint(parameters.getTaint());
        addTaint(encoding.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.741 -0400", hash_original_method = "EFE31A1BCD3079C9AAB0E8E3BC2999DC", hash_generated_method = "77088AAFB3CD71742DF6D759E79B9FCB")
    public  UrlEncodedFormEntity(
        final List <? extends NameValuePair> parameters) throws UnsupportedEncodingException {
        super(URLEncodedUtils.format(parameters, HTTP.DEFAULT_CONTENT_CHARSET), 
            HTTP.DEFAULT_CONTENT_CHARSET);
        setContentType(URLEncodedUtils.CONTENT_TYPE);
        addTaint(parameters.getTaint());
        
        
    }

    
}

