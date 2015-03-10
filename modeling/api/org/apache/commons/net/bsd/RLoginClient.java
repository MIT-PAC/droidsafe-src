/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
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

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.commons.net.bsd;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;

/***
 * RLoginClient is very similar to
 * {@link org.apache.commons.net.bsd.RCommandClient},
 * from which it is derived, and uses the rcmd() facility implemented
 * in RCommandClient to implement the functionality of the rlogin command that
 * first appeared in 4.2BSD Unix.  rlogin is a command used to login to
 * a remote machine from a trusted host, sometimes without issuing a
 * password.  The trust relationship is the same as described in
 * the documentation for
 * {@link org.apache.commons.net.bsd.RCommandClient}.
 * <p>
 * As with virtually all of the client classes in org.apache.commons.net, this
 * class derives from SocketClient.  But it relies on the connection
 * methods defined  in RcommandClient which ensure that the local Socket
 * will originate from an acceptable rshell port.  The way to use
 * RLoginClient is to first connect
 * to the server, call the {@link #rlogin  rlogin() } method,
 * and then
 * fetch the connection's input and output streams.
 * Interaction with the remote command is controlled entirely through the
 * I/O streams.  Once you have finished processing the streams, you should
 * invoke {@link org.apache.commons.net.bsd.RExecClient#disconnect disconnect() }
 *  to clean up properly.
 * <p>
 * The standard output and standard error streams of the
 * remote process are transmitted over the same connection, readable
 * from the input stream returned by
 * {@link org.apache.commons.net.bsd.RExecClient#getInputStream getInputStream() }
 * .  Unlike RExecClient and RCommandClient, it is
 * not possible to tell the rlogind daemon to return the standard error
 * stream over a separate connection.
 * {@link org.apache.commons.net.bsd.RExecClient#getErrorStream getErrorStream() }
 *  will always return null.
 * The standard input of the remote process can be written to through
 * the output stream returned by
 * {@link org.apache.commons.net.bsd.RExecClient#getOutputStream getOutputSream() }
 * .
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see org.apache.commons.net.SocketClient
 * @see RExecClient
 * @see RCommandClient
 ***/

public class RLoginClient extends RCommandClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.369 -0500", hash_original_field = "30796E70F5AE974F502FCB4796F7A769", hash_generated_field = "DA4DDECAD640EDFA41C6413C27715052")

    public static final int DEFAULT_PORT = 513;

    /***
     * The default RLoginClient constructor.  Initializes the
     * default port to <code> DEFAULT_PORT </code>.
     ***/
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.372 -0500", hash_original_method = "137F9E248231F2FA54CF674E7086700C", hash_generated_method = "37B44EAC1C6E84FF6770EF17014684A2")
    
public RLoginClient()
    {
        setDefaultPort(DEFAULT_PORT);
    }

    /***
     * Logins into a remote machine through the rlogind daemon on the server
     * to which the RLoginClient is connected.  After calling this method,
     * you may interact with the remote login shell through its standard input
     * and output streams.  Standard error is sent over the same stream as
     * standard output.  You will typically be able to detect
     * the termination of the remote login shell after reaching end of file
     * on its standard output (accessible through
     * {@link #getInputStream  getInputStream() }.  Disconnecting
     * from the server or closing the process streams before reaching
     * end of file will terminate the remote login shell in most cases.
     * <p>
     * If user authentication fails, the rlogind daemon will request that
     * a password be entered interactively.  You will be able to read the
     * prompt from the output stream of the RLoginClient and write the
     * password to the input stream of the RLoginClient.
     * <p>
     * @param localUsername  The user account on the local machine that is
     *        trying to login to the remote host.
     * @param remoteUsername  The account name on the server that is
     *        being logged in to.
     * @param terminalType   The name of the user's terminal (e.g., "vt100",
     *        "network", etc.)
     * @param terminalSpeed  The speed of the user's terminal, expressed
     *        as a baud rate or bps (e.g., 9600 or 38400)
     * @exception IOException If the rlogin() attempt fails.  The exception
     *            will contain a message indicating the nature of the failure.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.375 -0500", hash_original_method = "BC4BDB5A916113950238F971AF29167F", hash_generated_method = "1481D5936C735104139512B5993C64BE")
    
public void rlogin(String localUsername, String remoteUsername,
                       String terminalType, int terminalSpeed)
    throws IOException
    {
        rexec(localUsername, remoteUsername, terminalType + "/" + terminalSpeed,
              false);
    }

    /***
     * Same as the other rlogin method, but no terminal speed is defined.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.378 -0500", hash_original_method = "73F3340DC9AFFDCAEE47EFC3606433FD", hash_generated_method = "EE604B285EECDD6018DC5ABFCB02AF33")
    
public void rlogin(String localUsername, String remoteUsername,
                       String terminalType)
    throws IOException
    {
        rexec(localUsername, remoteUsername, terminalType, false);
    }

}
