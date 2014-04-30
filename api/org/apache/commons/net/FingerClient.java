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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;

/***
 * The FingerClient class implements the client side of the Internet Finger
 * Protocol defined in RFC 1288.  To finger a host you create a
 * FingerClient instance, connect to the host, query the host, and finally
 * disconnect from the host.  If the finger service you want to query is on
 * a non-standard port, connect to the host at that port.
 * Here's a sample use:
 * <pre>
 *    FingerClient finger;
 *
 *    finger = new FingerClient();
 *
 *    try {
 *      finger.connect("foo.bar.com");
 *      System.out.println(finger.query("foobar", false));
 *      finger.disconnect();
 *    } catch(IOException e) {
 *      System.err.println("Error I/O exception: " + e.getMessage());
 *      return;
 *    }
 * </pre>
 * <p>
 * <p>
 * @author Daniel F. Savarese
 ***/

public class FingerClient extends SocketClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.179 -0500", hash_original_field = "47FD3C9AB0272121961C1DE5DCA9164F", hash_generated_field = "DA676B5566F8C833A4B08D46B8B47348")

    public static final int DEFAULT_PORT = 79;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.183 -0500", hash_original_field = "53747FAF3B74697FB72CBF578F664CBF", hash_generated_field = "0A4A8E13FF83FD664B42FED328F494AF")

    private static final String __LONG_FLAG = "/W ";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.186 -0500", hash_original_field = "070520B24C657DD573A20ADDA34EBA8E", hash_generated_field = "309EB73D1E13AD4431220E040AC161AB")

    private transient StringBuffer __query = new StringBuffer(64);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.191 -0500", hash_original_field = "6D657336A96973153F06A98271A46026", hash_generated_field = "56B478E465C6965FCA2D464FAFB5ADD1")

    private transient char[] __buffer = new char[1024];

    /***
     * The default FingerClient constructor.  Initializes the
     * default port to <code> DEFAULT_PORT </code>.
     ***/
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.194 -0500", hash_original_method = "1D10C2AB7D4A035E3EDB22DE2A4CE492", hash_generated_method = "0435422691E8E273DCF5B48248AF7C2D")
    
public FingerClient()
    {
        setDefaultPort(DEFAULT_PORT);
    }

    /***
     * Fingers a user at the connected host and returns the output
     * as a String.  You must first connect to a finger server before
     * calling this method, and you should disconnect afterward.
     * <p>
     * @param longOutput Set to true if long output is requested, false if not.
     * @param username  The name of the user to finger.
     * @return The result of the finger query.
     * @exception IOException If an I/O error occurs while reading the socket.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.198 -0500", hash_original_method = "2A70F6675BC0E5B7285963B33CF05633", hash_generated_method = "CEA6E8CB86D8633F992546500EB30A04")
    
public String query(boolean longOutput, String username) throws IOException
    {
        int read;
        StringBuffer result = new StringBuffer(__buffer.length);
        BufferedReader input;

        input =
            new BufferedReader(new InputStreamReader(getInputStream(longOutput,
                               username)));

        while (true)
        {
            read = input.read(__buffer, 0, __buffer.length);
            if (read <= 0)
                break;
            result.append(__buffer, 0, read);
        }

        input.close();

        return result.toString();
    }

    /***
     * Fingers the connected host and returns the output
     * as a String.  You must first connect to a finger server before
     * calling this method, and you should disconnect afterward.
     * This is equivalent to calling <code> query(longOutput, "") </code>.
     * <p>
     * @param longOutput Set to true if long output is requested, false if not.
     * @return The result of the finger query.
     * @exception IOException If an I/O error occurs while reading the socket.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.201 -0500", hash_original_method = "D55C30402833F6F2BAA0496774A46F30", hash_generated_method = "F2E462204BE75A08A79F0954411A0C08")
    
public String query(boolean longOutput) throws IOException
    {
        return query(longOutput, "");
    }

    /***
     * Fingers a user and returns the input stream from the network connection
     * of the finger query.  You must first connect to a finger server before
     * calling this method, and you should disconnect after finishing reading
     * the stream.
     * <p>
     * @param longOutput Set to true if long output is requested, false if not.
     * @param username  The name of the user to finger.
     * @return The InputStream of the network connection of the finger query.
     *         Can be read to obtain finger results.
     * @exception IOException If an I/O error during the operation.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.204 -0500", hash_original_method = "034A74CF741FE2445E1EF5A642CC1511", hash_generated_method = "3A85DD688350F6792B6EB72C07C2A7BD")
    
public InputStream getInputStream(boolean longOutput, String username)
    throws IOException
    {
        DataOutputStream output;

        __query.setLength(0);
        if (longOutput)
            __query.append(__LONG_FLAG);
        __query.append(username);
        __query.append(SocketClient.NETASCII_EOL);

        output =
          new DataOutputStream(new BufferedOutputStream(_output_, 1024));
        output.writeBytes(__query.toString());
        output.flush();

        return _input_;
    }

    /***
     * Fingers the connected host and returns the input stream from
     * the network connection of the finger query.  This is equivalent to
     * calling getInputStream(longOutput, "").  You must first connect to a
     * finger server before calling this method, and you should disconnect
     * after finishing reading the stream.
     * <p>
     * @param longOutput Set to true if long output is requested, false if not.
     * @return The InputStream of the network connection of the finger query.
     *         Can be read to obtain finger results.
     * @exception IOException If an I/O error during the operation.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.208 -0500", hash_original_method = "D95DE5E5F36AAD93AC232DE6F1D2CA5C", hash_generated_method = "657DDD42228CCEDB3A91B02B987BCC68")
    
public InputStream getInputStream(boolean longOutput) throws IOException
    {
        return getInputStream(longOutput, "");
    }

}
