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
package org.apache.commons.net.bsd;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.apache.commons.net.io.SocketInputStream;
import org.apache.commons.net.SocketClient;
import java.io.OutputStream;

/***
 * RExecClient implements the rexec() facility that first appeared in
 * 4.2BSD Unix.  This class will probably only be of use for connecting
 * to Unix systems and only when the rexecd daemon is configured to run,
 * which is a rarity these days because of the security risks involved.
 * However, rexec() can be very useful for performing administrative tasks
 * on a network behind a firewall.
 * <p>
 * As with virtually all of the client classes in org.apache.commons.net, this
 * class derives from SocketClient, inheriting its connection methods.
 * The way to use RExecClient is to first connect
 * to the server, call the {@link #rexec  rexec() } method, and then
 * fetch the connection's input, output, and optionally error streams.
 * Interaction with the remote command is controlled entirely through the
 * I/O streams.  Once you have finished processing the streams, you should
 * invoke {@link #disconnect  disconnect() } to clean up properly.
 * <p>
 * By default the standard output and standard error streams of the
 * remote process are transmitted over the same connection, readable
 * from the input stream returned by
 * {@link #getInputStream  getInputStream() }.  However, it is
 * possible to tell the rexecd daemon to return the standard error
 * stream over a separate connection, readable from the input stream
 * returned by {@link #getErrorStream  getErrorStream() }.  You
 * can specify that a separate connection should be created for standard
 * error by setting the boolean <code> separateErrorStream </code>
 * parameter of {@link #rexec  rexec() } to <code> true </code>.
 * The standard input of the remote process can be written to through
 * the output stream returned by
 * {@link #getOutputStream  getOutputSream() }.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see SocketClient
 * @see RCommandClient
 * @see RLoginClient
 ***/

public class RExecClient extends SocketClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.052 -0500", hash_original_field = "886D0778755C02DEAF444D032EC33BCA", hash_generated_field = "CC55772E320E33F8947EDCACF577DB59")

    public static final int DEFAULT_PORT = 512;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.055 -0500", hash_original_field = "0403A10F429DBA727A18F7B08AAE9617", hash_generated_field = "71EB29C591E35D926D58C0E99490EB00")

    private boolean __remoteVerificationEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.058 -0500", hash_original_field = "A85808C7CA7EABB042A3E88C09C6B8F4", hash_generated_field = "484F7A98B93DC22F370239738497CA80")

    protected InputStream _errorStream_;

    /***
     * The default RExecClient constructor.  Initializes the
     * default port to <code> DEFAULT_PORT </code>.
     ***/
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.064 -0500", hash_original_method = "FA53100D9673C8250DDDB2DABAFFF1EA", hash_generated_method = "EA67D5D4E3644B63BA9E1EAD6AE9DA2E")
    
public RExecClient()
    {
        _errorStream_ = null;
        setDefaultPort(DEFAULT_PORT);
    }

    // This can be overridden in local package to implement port range
    // limitations of rcmd and rlogin
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.061 -0500", hash_original_method = "5F23A288054E2AABF0B2E7862DD3F5FB", hash_generated_method = "5F23A288054E2AABF0B2E7862DD3F5FB")
    
InputStream _createErrorStream() throws IOException
    {
        ServerSocket server;
        Socket socket;

        server = _socketFactory_.createServerSocket(0, 1, getLocalAddress());

        _output_.write(Integer.toString(server.getLocalPort()).getBytes());
        _output_.write('\0');
        _output_.flush();

        socket = server.accept();
        server.close();

        if (__remoteVerificationEnabled && !verifyRemote(socket))
        {
            socket.close();
            throw new IOException(
                "Security violation: unexpected connection attempt by " +
                socket.getInetAddress().getHostAddress());
        }

        return (new SocketInputStream(socket, socket.getInputStream()));
    }

    /***
     * Returns the InputStream from which the standard outputof the remote
     * process can be read.  The input stream will only be set after a
     * successful rexec() invocation.
     * <p>
     * @return The InputStream from which the standard output of the remote
     * process can be read.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.067 -0500", hash_original_method = "5B35E9AA913BF4A15ABCD13F74CD4461", hash_generated_method = "A4E9FEBE11F0614695860FA53CA50740")
    
public InputStream getInputStream()
    {
        return _input_;
    }

    /***
     * Returns the OutputStream through which the standard input of the remote
     * process can be written.  The output stream will only be set after a
     * successful rexec() invocation.
     * <p>
     * @return The OutputStream through which the standard input of the remote
     * process can be written.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.070 -0500", hash_original_method = "9D2BB106ED3726830193706965BB93BE", hash_generated_method = "D94AD9215C67C9EFF14689561FD9C004")
    
public OutputStream getOutputStream()
    {
        return _output_;
    }

    /***
     * Returns the InputStream from which the standard error of the remote
     * process can be read if a separate error stream is requested from
     * the server.  Otherwise, null will be returned.  The error stream
     * will only be set after a successful rexec() invocation.
     * <p>
     * @return The InputStream from which the standard error of the remote
     * process can be read if a separate error stream is requested from
     * the server.  Otherwise, null will be returned.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.073 -0500", hash_original_method = "E310DF12A5042160F7CC16A8E08BC2E9", hash_generated_method = "6104472B483359EB69DD7077195D84FC")
    
public InputStream getErrorStream()
    {
        return _errorStream_;
    }

    /***
     * Remotely executes a command through the rexecd daemon on the server
     * to which the RExecClient is connected.  After calling this method,
     * you may interact with the remote process through its standard input,
     * output, and error streams.  You will typically be able to detect
     * the termination of the remote process after reaching end of file
     * on its standard output (accessible through
     * {@link #getInputStream  getInputStream() }.    Disconnecting
     * from the server or closing the process streams before reaching
     * end of file will not necessarily terminate the remote process.
     * <p>
     * If a separate error stream is requested, the remote server will
     * connect to a local socket opened by RExecClient, providing an
     * independent stream through which standard error will be transmitted.
     * RExecClient will do a simple security check when it accepts a
     * connection for this error stream.  If the connection does not originate
     * from the remote server, an IOException will be thrown.  This serves as
     * a simple protection against possible hijacking of the error stream by
     * an attacker monitoring the rexec() negotiation.  You may disable this
     * behavior with {@link #setRemoteVerificationEnabled setRemoteVerificationEnabled()}
     * .
     * <p>
     * @param username  The account name on the server through which to execute
     *                  the command.
     * @param password  The plain text password of the user account.
     * @param command   The command, including any arguments, to execute.
     * @param separateErrorStream True if you would like the standard error
     *        to be transmitted through a different stream than standard output.
     *        False if not.
     * @exception IOException If the rexec() attempt fails.  The exception
     *            will contain a message indicating the nature of the failure.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.077 -0500", hash_original_method = "AB23CB6D74AE00A0C1AC7BBE664846D4", hash_generated_method = "1B882F59BAB9B3A47B4285BFE5BF987E")
    
public void rexec(String username, String password,
                      String command, boolean separateErrorStream)
    throws IOException
    {
        int ch;

        if (separateErrorStream)
        {
            _errorStream_ = _createErrorStream();
        }
        else
        {
            _output_.write('\0');
        }

        _output_.write(username.getBytes());
        _output_.write('\0');
        _output_.write(password.getBytes());
        _output_.write('\0');
        _output_.write(command.getBytes());
        _output_.write('\0');
        _output_.flush();

        ch = _input_.read();
        if (ch > 0)
        {
            StringBuffer buffer = new StringBuffer();

            while ((ch = _input_.read()) != -1 && ch != '\n')
                buffer.append((char)ch);

            throw new IOException(buffer.toString());
        }
        else if (ch < 0)
        {
            throw new IOException("Server closed connection.");
        }
    }

    /***
     * Same as <code> rexec(username, password, command, false); </code>
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.080 -0500", hash_original_method = "7F8D11AAE20352F3BAFC0BB3AC43F85C", hash_generated_method = "317EE1C1B4352942DA2FC5B4F9A3F5B3")
    
public void rexec(String username, String password,
                      String command)
    throws IOException
    {
        rexec(username, password, command, false);
    }

    /***
     * Disconnects from the server, closing all associated open sockets and
     * streams.
     * <p>
     * @exception IOException If there an error occurs while disconnecting.
     ***/
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.083 -0500", hash_original_method = "EC3762ABD187734DF955C9D194C2C167", hash_generated_method = "ED6218BA92B2498B7E6ECACC0FCD68CE")
    
public void disconnect() throws IOException
    {
        if (_errorStream_ != null)
            _errorStream_.close();
        _errorStream_ = null;
        super.disconnect();
    }

    /***
     * Enable or disable verification that the remote host connecting to
     * create a separate error stream is the same as the host to which
     * the standard out stream is connected.  The default is for verification
     * to be enabled.  You may set this value at any time, whether the
     * client is currently connected or not.
     * <p>
     * @param enable True to enable verification, false to disable verification.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.086 -0500", hash_original_method = "B43F9511C52B1943E46D4FBD2B422626", hash_generated_method = "A1CA180102F7F562B9C5074A8E496E7F")
    
public final void setRemoteVerificationEnabled(boolean enable)
    {
        __remoteVerificationEnabled = enable;
    }

    /***
     * Return whether or not verification of the remote host providing a
     * separate error stream is enabled.  The default behavior is for
     * verification to be enabled.
     * <p>
     * @return True if verification is enabled, false if not.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.089 -0500", hash_original_method = "91605D0E838B38F66B10D351585DF796", hash_generated_method = "4B2EDA304ABE6B5B4E367975D6D6E455")
    
public final boolean isRemoteVerificationEnabled()
    {
        return __remoteVerificationEnabled;
    }

}

