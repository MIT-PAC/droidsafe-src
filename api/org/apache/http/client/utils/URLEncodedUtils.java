package org.apache.http.client.utils;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import java.net.URLDecoder;
import java.util.List;
import java.net.URI;
import java.util.Collections;
import org.apache.http.Header;
import java.util.Scanner;
import java.io.IOException;
import org.apache.http.message.BasicNameValuePair;
import java.net.URLEncoder;
import org.apache.http.protocol.HTTP;
import org.apache.http.NameValuePair;
import java.io.UnsupportedEncodingException;
import org.apache.http.util.EntityUtils;
public class URLEncodedUtils {

    /**
     * Returns a list of {@link NameValuePair NameValuePairs} as built from the
     * URI's query portion. For example, a URI of
     * http://example.org/path/to/file?a=1&b=2&c=3 would return a list of three
     * NameValuePairs, one for a=1, one for b=2, and one for c=3.
     * <p>
     * This is typically useful while parsing an HTTP PUT.
     * 
     * @param uri
     *            uri to parse
     * @param encoding
     *            encoding to use while parsing the query
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.452 -0500", hash_original_method = "75763A91BDF0B02A517E106BC03551A8", hash_generated_method = "9C1AB2355DE68597D0C7FD33A48C9930")
    
public static List <NameValuePair> parse (final URI uri, final String encoding) {
        List <NameValuePair> result = Collections.emptyList();
        final String query = uri.getRawQuery();
        if (query != null && query.length() > 0) {
            result = new ArrayList <NameValuePair>();
            parse(result, new Scanner(query), encoding);
        }
        return result;
    }

    /**
     * Returns a list of {@link NameValuePair NameValuePairs} as parsed from an
     * {@link HttpEntity}. The encoding is taken from the entity's
     * Content-Encoding header.
     * <p>
     * This is typically used while parsing an HTTP POST.
     * 
     * @param entity
     *            The entity to parse
     * @throws IOException
     *             If there was an exception getting the entity's data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.455 -0500", hash_original_method = "3125ACC43E08755650BD72975049DA9D", hash_generated_method = "57408A403AC39C54BE0F6AE05B140555")
    
public static List <NameValuePair> parse (
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

    /**
     * Returns true if the entity's Content-Type header is
     * <code>application/x-www-form-urlencoded</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.457 -0500", hash_original_method = "0BF3228161F0ACF43C700CE7A2BBAA2E", hash_generated_method = "8503EA47287EAF38F5D4E4E943CADED1")
    
public static boolean isEncoded (final HttpEntity entity) {
        final Header contentType = entity.getContentType();
        return (contentType != null && contentType.getValue().equalsIgnoreCase(CONTENT_TYPE));
    }

    /**
     * Adds all parameters within the Scanner to the list of
     * <code>parameters</code>, as encoded by <code>encoding</code>. For
     * example, a scanner containing the string <code>a=1&b=2&c=3</code> would
     * add the {@link NameValuePair NameValuePairs} a=1, b=2, and c=3 to the
     * list of parameters.
     * 
     * @param parameters
     *            List to add parameters to.
     * @param scanner
     *            Input that contains the parameters to parse.
     * @param encoding
     *            Encoding to use when decoding the parameters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.460 -0500", hash_original_method = "B9E5E74932B9B651CCE1D167217476AF", hash_generated_method = "769E1F0F23499A6643A99990D4159254")
    
public static void parse (
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

    /**
     * Returns a String that is suitable for use as an <code>application/x-www-form-urlencoded</code>
     * list of parameters in an HTTP PUT or HTTP POST.
     * 
     * @param parameters  The parameters to include.
     * @param encoding The encoding to use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.463 -0500", hash_original_method = "FC50720DD3E5D2157039A2F08974D046", hash_generated_method = "DDE2DF273A0113D2EC3E0F3A3C8BCEAE")
    
public static String format (
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.465 -0500", hash_original_method = "2D8FF71055D97FB508B18FFC2F549496", hash_generated_method = "A47935A13B462B47CC4711B15FE69EA3")
    
private static String decode (final String content, final String encoding) {
        try {
            return URLDecoder.decode(content, 
                    encoding != null ? encoding : HTTP.DEFAULT_CONTENT_CHARSET);
        } catch (UnsupportedEncodingException problem) {
            throw new IllegalArgumentException(problem);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.468 -0500", hash_original_method = "7FB0AA8AD7FE2622360A7CF15E75172B", hash_generated_method = "51DC5F03E25D5BBF34576DFBFE9D90DB")
    
private static String encode (final String content, final String encoding) {
        try {
            return URLEncoder.encode(content, 
                    encoding != null ? encoding : HTTP.DEFAULT_CONTENT_CHARSET);
        } catch (UnsupportedEncodingException problem) {
            throw new IllegalArgumentException(problem);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.444 -0500", hash_original_field = "8CE1BE1F9E7F5E0ECDCE17C227A60463", hash_generated_field = "CA39D07C989D4F189D6186A6BE8AC2A2")

    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.447 -0500", hash_original_field = "BE30E2F1EF3EC80109603C450CC5D69C", hash_generated_field = "EADEDF186CBE5B5EA18ADAA5F38884BA")

    private static final String PARAMETER_SEPARATOR = "&";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.449 -0500", hash_original_field = "9B0CF78B002510056630BB2C521EBA47", hash_generated_field = "14E97C4E5722F77DC637C17244547DAD")

    private static final String NAME_VALUE_SEPARATOR = "=";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-18 10:03:54.756 -0400", hash_original_method = "81DBDF8E46C8CBBC080FA6A7719DA672", hash_generated_method = "81DBDF8E46C8CBBC080FA6A7719DA672")
    public URLEncodedUtils ()
    {
        //Synthesized constructor
    }
}

