package org.apache.http.client.entity;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;

public class UrlEncodedFormEntity extends StringEntity {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:02.151 -0400", hash_original_method = "2B79106283EA78C37FC06864AB4CC20F", hash_generated_method = "870E258256A0348FBCB54679377D3638")
    @DSModeled(DSC.SAFE)
    public  UrlEncodedFormEntity(
        final List <? extends NameValuePair> parameters, 
        final String encoding) throws UnsupportedEncodingException {
        super(URLEncodedUtils.format(parameters, encoding), 
            encoding);
        addTaint(encoding.getTaint());
        addTaint(parameters.getTaint());
        setContentType(URLEncodedUtils.CONTENT_TYPE);
        // ---------- Original Method ----------
        //setContentType(URLEncodedUtils.CONTENT_TYPE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:02.152 -0400", hash_original_method = "EFE31A1BCD3079C9AAB0E8E3BC2999DC", hash_generated_method = "0FBF6EAF74398CAC4AD274B8F07409B7")
    @DSModeled(DSC.SAFE)
    public  UrlEncodedFormEntity(
        final List <? extends NameValuePair> parameters) throws UnsupportedEncodingException {
        super(URLEncodedUtils.format(parameters, HTTP.DEFAULT_CONTENT_CHARSET), 
            HTTP.DEFAULT_CONTENT_CHARSET);
        addTaint(parameters.getTaint());
        setContentType(URLEncodedUtils.CONTENT_TYPE);
        // ---------- Original Method ----------
        //setContentType(URLEncodedUtils.CONTENT_TYPE);
    }

    
    
    
}

