package org.apache.http.client.entity;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.*;

import droidsafe.runtime.*;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;

public class UrlEncodedFormEntity extends StringEntity {
  
    /**
     * Constructs a new {@link UrlEncodedFormEntity} with the list
     * of parameters in the specified encoding.
     * 
     * @param parameters list of name/value pairs
     * @param encoding encoding the name/value pairs be encoded with
     * @throws UnsupportedEncodingException if the encoding isn't supported
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.628 -0500", hash_original_method = "2B79106283EA78C37FC06864AB4CC20F", hash_generated_method = "97236FA94CD4379FBBB97CBB8054EEFB")
    
public UrlEncodedFormEntity (
        final List <? extends NameValuePair> parameters, 
        final String encoding) throws UnsupportedEncodingException {
        super(URLEncodedUtils.format(parameters, encoding), 
            encoding);
        setContentType(URLEncodedUtils.CONTENT_TYPE);
    }

    /**
     * Constructs a new {@link UrlEncodedFormEntity} with the list
     * of parameters with the default encoding of {@link HTTP#DEFAULT_CONTENT_CHARSET}
     * 
     * @param parameters list of name/value pairs
     * @throws UnsupportedEncodingException if the default encoding isn't supported
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.631 -0500", hash_original_method = "EFE31A1BCD3079C9AAB0E8E3BC2999DC", hash_generated_method = "F2ADCBCD03D851844BFD7EFF8118FD22")
    
public UrlEncodedFormEntity (
        final List <? extends NameValuePair> parameters) throws UnsupportedEncodingException {
        super(URLEncodedUtils.format(parameters, HTTP.DEFAULT_CONTENT_CHARSET), 
            HTTP.DEFAULT_CONTENT_CHARSET);
        setContentType(URLEncodedUtils.CONTENT_TYPE);
    }

    
    
    
}

