package org.apache.http.client.utils;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpHost;

public class URIUtils {

     /**
         * Constructs a {@link URI} using all the parameters. This should be
         * used instead of
         * {@link URI#URI(String, String, String, int, String, String, String)}
         * or any of the other URI multi-argument URI constructors.
         * 
         * See <a
         * href="https://issues.apache.org/jira/browse/HTTPCLIENT-730">HTTPCLIENT-730</a>
         * for more information.
         * 
         * @param scheme
         *            Scheme name
         * @param host
         *            Host name
         * @param port
         *            Port number
         * @param path
         *            Path
         * @param query
         *            Query
         * @param fragment
         *            Fragment
         * 
         * @throws URISyntaxException
         *             If both a scheme and a path are given but the path is
         *             relative, if the URI string constructed from the given
         *             components violates RFC&nbsp;2396, or if the authority
         *             component of the string is present but cannot be parsed
         *             as a server-based authority
         */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.569 -0500", hash_original_method = "19A08876017B0E66F12ADB34AE24FA2E", hash_generated_method = "86440AB2C498932E991F146363D76901")
    
public static URI createURI(
            final String scheme,
            final String host,
            int port,
            final String path,
            final String query,
            final String fragment) throws URISyntaxException {
        
        StringBuilder buffer = new StringBuilder();
        if (host != null) {
            if (scheme != null) {
                buffer.append(scheme);
                buffer.append("://");
            }
            buffer.append(host);
            if (port > 0) {
                buffer.append(':');
                buffer.append(port);
            }
        }
        if (path == null || !path.startsWith("/")) {
            buffer.append('/');
        }
        if (path != null) {
            buffer.append(path);
        }
        if (query != null) {
            buffer.append('?');
            buffer.append(query);
        }
        if (fragment != null) {
            buffer.append('#');
            buffer.append(fragment);
        }
        return new URI(buffer.toString());
    }

    /**
     * A convenience method for creating a new {@link URI} whose scheme, host
     * and port are taken from the target host, but whose path, query and
     * fragment are taken from the existing URI. The fragment is only used if
     * dropFragment is false.
     * 
     * @param uri
     *            Contains the path, query and fragment to use.
     * @param target
     *            Contains the scheme, host and port to use.
     * @param dropFragment
     *            True if the fragment should not be copied.
     * 
     * @throws URISyntaxException
     *             If the resulting URI is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.572 -0500", hash_original_method = "5BCF6CC51BFC75D8413D633758FBA659", hash_generated_method = "28EE0D92FA51D1769C76980AF918D41F")
    
public static URI rewriteURI(
            final URI uri, 
            final HttpHost target,
            boolean dropFragment) throws URISyntaxException {
        if (uri == null) {
            throw new IllegalArgumentException("URI may nor be null");
        }
        if (target != null) {
            return URIUtils.createURI(
                    target.getSchemeName(), 
                    target.getHostName(), 
                    target.getPort(), 
                    uri.getRawPath(), 
                    uri.getRawQuery(), 
                    dropFragment ? null : uri.getRawFragment());
        } else {
            return URIUtils.createURI(
                    null, 
                    null, 
                    -1, 
                    uri.getRawPath(), 
                    uri.getRawQuery(), 
                    dropFragment ? null : uri.getRawFragment());
        }
    }
    
    /**
     * A convenience method for
     * {@link URIUtils#rewriteURI(URI, HttpHost, boolean)} that always keeps the
     * fragment.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.574 -0500", hash_original_method = "0CAE9240B5B3CDDA3A701D41E526238F", hash_generated_method = "57306AAC46193404E9D3354186493CF2")
    
public static URI rewriteURI(
            final URI uri, 
            final HttpHost target) throws URISyntaxException {
        return rewriteURI(uri, target, false);
    }
    
    /**
     * Resolves a URI reference against a base URI. Work-around for bug in
     * java.net.URI (<http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4708535>)
     *
     * @param baseURI the base URI
     * @param reference the URI reference
     * @return the resulting URI
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.576 -0500", hash_original_method = "EC59E00085E1F31ADDA0DBE4C60C3840", hash_generated_method = "CD39698D2E50D07981213FC662C1DBF5")
    
public static URI resolve(final URI baseURI, final String reference) {
        return URIUtils.resolve(baseURI, URI.create(reference));
    }

    /**
     * Resolves a URI reference against a base URI. Work-around for bug in
     * java.net.URI (<http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4708535>)
     *
     * @param baseURI the base URI
     * @param reference the URI reference
     * @return the resulting URI
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.579 -0500", hash_original_method = "B3B247A72B9A5E5D631B15DB9021C14E", hash_generated_method = "C5079CC507FC792378C3D1DC8D1E9C32")
    
public static URI resolve(final URI baseURI, URI reference){
        if (baseURI == null) {
            throw new IllegalArgumentException("Base URI may nor be null");
        }
        if (reference == null) {
            throw new IllegalArgumentException("Reference URI may nor be null");
        }
        boolean emptyReference = reference.toString().length() == 0;
        if (emptyReference) {
            reference = URI.create("#");
        }
        URI resolved = baseURI.resolve(reference);
        if (emptyReference) {
            String resolvedString = resolved.toString();
            resolved = URI.create(resolvedString.substring(0,
                resolvedString.indexOf('#')));
        }
        return resolved;
    }

    /**
     * This class should not be instantiated.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.581 -0500", hash_original_method = "76E8736EFBBC9BF69FA0C2D7E3BBC6EF", hash_generated_method = "763070220CDD6AAECE1612E041381A7A")
    
private URIUtils() {
    }
    
}

