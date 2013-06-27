package org.apache.http.client.utils;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class URLEncodedUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.210 -0400", hash_original_method = "81DBDF8E46C8CBBC080FA6A7719DA672", hash_generated_method = "81DBDF8E46C8CBBC080FA6A7719DA672")
    public URLEncodedUtils ()
    {
        //Synthesized constructor
    }


        public static List <NameValuePair> parse(final URI uri, final String encoding) {
        List <NameValuePair> result = Collections.emptyList();
        final String query = uri.getRawQuery();
        if (query != null && query.length() > 0) {
            result = new ArrayList <NameValuePair>();
            parse(result, new Scanner(query), encoding);
        }
        return result;
    }

    
        public static List <NameValuePair> parse(
            final HttpEntity entity) throws IOException {
        List <NameValuePair> result = Collections.emptyList();
        if (isEncoded(entity)) {
            final String content = EntityUtils.toString(entity);
            final Header encoding = entity.getContentEncoding();
            if (content != null && content.length() > 0) {
                result = new ArrayList <NameValuePair>();
                parse(result, new Scanner(content), 
                        encoding != null ? encoding.getValue() : null);
            }
        }
        return result;
    }

    
        public static boolean isEncoded(final HttpEntity entity) {
        final Header contentType = entity.getContentType();
        return (contentType != null && contentType.getValue().equalsIgnoreCase(CONTENT_TYPE));
    }

    
        public static void parse(
            final List <NameValuePair> parameters, 
            final Scanner scanner, 
            final String encoding) {
        scanner.useDelimiter(PARAMETER_SEPARATOR);
        while (scanner.hasNext()) {
            final String[] nameValue = scanner.next().split(NAME_VALUE_SEPARATOR);
            if (nameValue.length == 0 || nameValue.length > 2)
                throw new IllegalArgumentException("bad parameter");
            final String name = decode(nameValue[0], encoding);
            String value = null;
            if (nameValue.length == 2)
                value = decode(nameValue[1], encoding);
            parameters.add(new BasicNameValuePair(name, value));
        }
    }

    
        public static String format(
            final List <? extends NameValuePair> parameters, 
            final String encoding) {
        final StringBuilder result = new StringBuilder();
        for (final NameValuePair parameter : parameters) {
            final String encodedName = encode(parameter.getName(), encoding);
            final String value = parameter.getValue();
            final String encodedValue = value != null ? encode(value, encoding) : "";
            if (result.length() > 0)
                result.append(PARAMETER_SEPARATOR);
            result.append(encodedName);
            result.append(NAME_VALUE_SEPARATOR);
            result.append(encodedValue);
        }
        return result.toString();
    }

    
        private static String decode(final String content, final String encoding) {
        try {
            return URLDecoder.decode(content, 
                    encoding != null ? encoding : HTTP.DEFAULT_CONTENT_CHARSET);
        } catch (UnsupportedEncodingException problem) {
            throw new IllegalArgumentException(problem);
        }
    }

    
        private static String encode(final String content, final String encoding) {
        try {
            return URLEncoder.encode(content, 
                    encoding != null ? encoding : HTTP.DEFAULT_CONTENT_CHARSET);
        } catch (UnsupportedEncodingException problem) {
            throw new IllegalArgumentException(problem);
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.243 -0400", hash_original_field = "E5475157C74498E74A568469421CA731", hash_generated_field = "CA39D07C989D4F189D6186A6BE8AC2A2")

    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.247 -0400", hash_original_field = "F835064E8AD0EB0A2D73B235E96ADEAA", hash_generated_field = "3DD3590CE7A2AA7D6399B8BDE25A3AF9")

    private static String PARAMETER_SEPARATOR = "&";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.247 -0400", hash_original_field = "536C8846926768148DFB5EDE60D2D360", hash_generated_field = "F9CE5D83C4FD4DE7687D1A6031184B60")

    private static String NAME_VALUE_SEPARATOR = "=";
}

