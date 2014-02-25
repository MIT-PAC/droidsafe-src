/*
 * Copyright 2001-2005 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.net;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.InputStream;

/***
 * The WhoisClient class implements the client side of the Internet Whois
 * Protocol defined in RFC 954.   To query a host you create a
 * WhoisClient instance, connect to the host, query the host, and finally
 * disconnect from the host.  If the whois service you want to query is on
 * a non-standard port, connect to the host at that port.
 * Here's a sample use:
 * <pre>
 *    WhoisClient whois;
 *
 *    whois = new WhoisClient();
 *
 *    try {
 *      whois.connect(WhoisClient.DEFAULT_HOST);
 *      System.out.println(whois.query("foobar"));
 *      whois.disconnect();
 *    } catch(IOException e) {
 *      System.err.println("Error I/O exception: " + e.getMessage());
 *      return;
 *    }
 * </pre>
 *
 * <p>
 * <p>
 * @author Daniel F. Savarese
 ***/

public final class WhoisClient extends FingerClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.396 -0500", hash_original_field = "332C7CD3019F0D4DA58168EAEBEFFE38", hash_generated_field = "C487DF3EC9D8C35D8BC76FAEABB2DA0E")

    public static final String DEFAULT_HOST = "whois.internic.net";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.401 -0500", hash_original_field = "3413A033F323E732A56C0A47B4C40A3A", hash_generated_field = "A7AB2B8A8BEF83FF4BCF2136B1EC52D0")

    public static final int DEFAULT_PORT = 43;


    /***
     * The default whois constructor.    Initializes the
     * default port to <code> DEFAULT_PORT </code>.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.406 -0500", hash_original_method = "C196A1C4CA062B9CB50F14103D33FE2B", hash_generated_method = "9A5B1CADAB5F32ABE60C1E4FBCF6DD48")
    
public WhoisClient()
    {
        setDefaultPort(DEFAULT_PORT);
    }

    /***
     * Queries the connected whois server for information regarding
     * the given handle.  It is up to the programmer to be familiar with the
     * handle syntax of the whois server.  You must first connect to a whois
     * server before calling this method, and you should disconnect afterward.
     * <p>
     * @param handle  The handle to lookup.
     * @return The result of the whois query.
     * @exception IOException  If an I/O error occurs during the operation.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.411 -0500", hash_original_method = "A77E98452A80882EFF084EC07221C698", hash_generated_method = "E4F44393B75AC158C63D0C406E4215A4")
    
public String query(String handle) throws IOException
    {
        return query(false, handle);
    }


    /***
     * Queries the connected whois server for information regarding
     * the given handle and returns the InputStream of the network connection.
     * It is up to the programmer to be familiar with the handle syntax
     * of the whois server.  You must first connect to a finger server before
     * calling this method, and you should disconnect after finishing reading
     * the stream.
     * <p>
     * @param handle  The handle to lookup.
     * @return The InputStream of the network connection of the whois query.
     *         Can be read to obtain whois results.
     * @exception IOException  If an I/O error occurs during the operation.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.416 -0500", hash_original_method = "9AA9510082432260DAB1217300E8FD0D", hash_generated_method = "A7125A015B16625A790EA7D14A1F7A9A")
    
public InputStream getInputStream(String handle) throws IOException
    {
        return getInputStream(false, handle);
    }

}

