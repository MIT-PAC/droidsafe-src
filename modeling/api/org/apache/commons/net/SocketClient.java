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


package org.apache.commons.net;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

/**
 * The SocketClient provides the basic operations that are required of
 * client objects accessing sockets.  It is meant to be
 * subclassed to avoid having to rewrite the same code over and over again
 * to open a socket, close a socket, set timeouts, etc.  Of special note
 * is the {@link #setSocketFactory  setSocketFactory }
 * method, which allows you to control the type of Socket the SocketClient
 * creates for initiating network connections.  This is especially useful
 * for adding SSL or proxy support as well as better support for applets.  For
 * example, you could create a
 * {@link org.apache.commons.net.SocketFactory} that
 * requests browser security capabilities before creating a socket.
 * All classes derived from SocketClient should use the
 * {@link #_socketFactory_  _socketFactory_ } member variable to
 * create Socket and ServerSocket instances rather than instanting
 * them by directly invoking a constructor.  By honoring this contract
 * you guarantee that a user will always be able to provide his own
 * Socket implementations by substituting his own SocketFactory.
 * @author Daniel F. Savarese
 * @see SocketFactory
 */
public abstract class SocketClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.100 -0500", hash_original_field = "8928DBFDB6D046A724438CDED6BA7443", hash_generated_field = "0EA256984B7598A1155391046E264E04")

    public static final String NETASCII_EOL = "\r\n";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.103 -0500", hash_original_field = "78C8497CC790429D4EFA05AD673CF227", hash_generated_field = "D3917F16B2042CEDAB44C6ED88E92FF9")

    private static final SocketFactory __DEFAULT_SOCKET_FACTORY =
        new DefaultSocketFactory();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.105 -0500", hash_original_field = "CB8A82913986A8891D8A21392F5B8097", hash_generated_field = "EF27B9409CBEA792130C2237C188D864")

    protected int _timeout_;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.109 -0500", hash_original_field = "6CBDDA65A5278DDA8511328B6D05A74C", hash_generated_field = "B1DEE7EACCFB6EA9AA6FA1DBBC4D6238")

    protected Socket _socket_;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.112 -0500", hash_original_field = "10D8109653F588AA3EDF74E5853AEDF0", hash_generated_field = "1693530CDBBC515B3F2158AD9F6EA7FC")

    protected boolean _isConnected_;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.115 -0500", hash_original_field = "A5494BFFB61229BF1252B5B591533BB2", hash_generated_field = "DB4A5F0B341B726D7EBA03D1799FB386")

    protected int _defaultPort_;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.118 -0500", hash_original_field = "57C7CFFB8F3C2D7BC3B469692F26CE02", hash_generated_field = "DC2FB70DEF26B8661EC5D0098DB59638")

    protected InputStream _input_;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.121 -0500", hash_original_field = "9CC305B86BD746536A50433B4BE7CC57", hash_generated_field = "2724581DB121C6F6C58DA32C24F4E225")

    protected OutputStream _output_;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.123 -0500", hash_original_field = "17F8CAF3B92D29C1D92E29FDD0719D9B", hash_generated_field = "2973F467C8BD1FC56232EA7214304B6D")

    protected SocketFactory _socketFactory_;


    /**
     * Default constructor for SocketClient.  Initializes
     * _socket_ to null, _timeout_ to 0, _defaultPort to 0,
     * _isConnected_ to false, and _socketFactory_ to a shared instance of
     * {@link org.apache.commons.net.DefaultSocketFactory}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.126 -0500", hash_original_method = "93FF3AD39A65F94071EDD8E8BD3E2EC6", hash_generated_method = "A8D9DAA4A8C3033FC100F445681247DB")
    @DSComment("Constructor")
    @DSSafe(DSCat.SAFE_OTHERS)  
public SocketClient()
    {
        _socket_ = null;
        _input_ = null;
        _output_ = null;
        _timeout_ = 0;
        _defaultPort_ = 0;
        _isConnected_ = false;
        _socketFactory_ = __DEFAULT_SOCKET_FACTORY;
    }


    /**
     * Because there are so many connect() methods, the _connectAction_()
     * method is provided as a means of performing some action immediately
     * after establishing a connection, rather than reimplementing all
     * of the connect() methods.  The last action performed by every
     * connect() method after opening a socket is to call this method.
     * <p>
     * This method sets the timeout on the just opened socket to the default
     * timeout set by {@link #setDefaultTimeout  setDefaultTimeout() },
     * sets _input_ and _output_ to the socket's InputStream and OutputStream
     * respectively, and sets _isConnected_ to true.
     * <p>
     * Subclasses overriding this method should start by calling
     * <code> super._connectAction_() </code> first to ensure the
     * initialization of the aforementioned protected variables.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.129 -0500", hash_original_method = "6901DE6A68C50AF510824F6003DFB9AA", hash_generated_method = "C4D04EC4C4B919DA34DF87779076DC74")
    @DSVerified("Calling getters")
    @DSSafe(DSCat.SAFE_OTHERS)
protected void _connectAction_() throws IOException
    {
        _socket_.setSoTimeout(_timeout_);
        _input_ = _socket_.getInputStream();
        _output_ = _socket_.getOutputStream();
        _isConnected_ = true;
    }


    /**
     * Opens a Socket connected to a remote host at the specified port and
     * originating from the current host at a system assigned port.
     * Before returning, {@link #_connectAction_  _connectAction_() }
     * is called to perform connection initialization actions.
     * <p>
     * @param host  The remote host.
     * @param port  The port to connect to on the remote host.
     * @exception SocketException If the socket timeout could not be set.
     * @exception IOException If the socket could not be opened.  In most
     *  cases you will only want to catch IOException since SocketException is
     *  derived from it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.132 -0500", hash_original_method = "7B958379BE3471901DE9AE1E0C97E973", hash_generated_method = "59DFFFFD87AC2E26A854BEDC8D27CD38")
    @DSVerified
    @DSSpec(DSCat.INTERNET)
public void connect(InetAddress host, int port)
    throws SocketException, IOException
    {
        _socket_ = _socketFactory_.createSocket(host, port);
        _connectAction_();
    }

    /**
     * Opens a Socket connected to a remote host at the specified port and
     * originating from the current host at a system assigned port.
     * Before returning, {@link #_connectAction_  _connectAction_() }
     * is called to perform connection initialization actions.
     * <p>
     * @param hostname  The name of the remote host.
     * @param port  The port to connect to on the remote host.
     * @exception SocketException If the socket timeout could not be set.
     * @exception IOException If the socket could not be opened.  In most
     *  cases you will only want to catch IOException since SocketException is
     *  derived from it.
     * @exception UnknownHostException If the hostname cannot be resolved.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.135 -0500", hash_original_method = "41EEE4FD6DB40E930F556CF3C8791806", hash_generated_method = "9C6A38F158C783651B9DB6E6338D9FFF")
    @DSVerified
    @DSSpec(DSCat.INTERNET)
public void connect(String hostname, int port)
    throws SocketException, IOException
    {
        _socket_ = _socketFactory_.createSocket(hostname, port);
        _connectAction_();
    }


    /**
     * Opens a Socket connected to a remote host at the specified port and
     * originating from the specified local address and port.
     * Before returning, {@link #_connectAction_  _connectAction_() }
     * is called to perform connection initialization actions.
     * <p>
     * @param host  The remote host.
     * @param port  The port to connect to on the remote host.
     * @param localAddr  The local address to use.
     * @param localPort  The local port to use.
     * @exception SocketException If the socket timeout could not be set.
     * @exception IOException If the socket could not be opened.  In most
     *  cases you will only want to catch IOException since SocketException is
     *  derived from it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.138 -0500", hash_original_method = "2CAF2963B0112EDF585D8A32A0235CCA", hash_generated_method = "396152F6872FABEFE736E336119A17A3")
    @DSVerified
    @DSSpec(DSCat.INTERNET)
public void connect(InetAddress host, int port,
                        InetAddress localAddr, int localPort)
    throws SocketException, IOException
    {
        _socket_ = _socketFactory_.createSocket(host, port, localAddr, localPort);
        _connectAction_();
    }


    /**
     * Opens a Socket connected to a remote host at the specified port and
     * originating from the specified local address and port.
     * Before returning, {@link #_connectAction_  _connectAction_() }
     * is called to perform connection initialization actions.
     * <p>
     * @param hostname  The name of the remote host.
     * @param port  The port to connect to on the remote host.
     * @param localAddr  The local address to use.
     * @param localPort  The local port to use.
     * @exception SocketException If the socket timeout could not be set.
     * @exception IOException If the socket could not be opened.  In most
     *  cases you will only want to catch IOException since SocketException is
     *  derived from it.
     * @exception UnknownHostException If the hostname cannot be resolved.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.141 -0500", hash_original_method = "A05AB8172AA7B61690B92586AB9E9173", hash_generated_method = "ABB49830F80F0FB2307D9A8B3059FC1A")
    @DSVerified
    @DSSpec(DSCat.INTERNET)
public void connect(String hostname, int port,
                        InetAddress localAddr, int localPort)
    throws SocketException, IOException
    {
        _socket_ =
            _socketFactory_.createSocket(hostname, port, localAddr, localPort);
        _connectAction_();
    }


    /**
     * Opens a Socket connected to a remote host at the current default port
     * and originating from the current host at a system assigned port.
     * Before returning, {@link #_connectAction_  _connectAction_() }
     * is called to perform connection initialization actions.
     * <p>
     * @param host  The remote host.
     * @exception SocketException If the socket timeout could not be set.
     * @exception IOException If the socket could not be opened.  In most
     *  cases you will only want to catch IOException since SocketException is
     *  derived from it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.143 -0500", hash_original_method = "41434615E178682B599165811173ABD1", hash_generated_method = "0424ADF3E270CB84012A1F132468CFBB")
    @DSVerified
    @DSSpec(DSCat.INTERNET)
public void connect(InetAddress host) throws SocketException, IOException
    {
        connect(host, _defaultPort_);
    }


    /**
     * Opens a Socket connected to a remote host at the current default
     * port and originating from the current host at a system assigned port.
     * Before returning, {@link #_connectAction_  _connectAction_() }
     * is called to perform connection initialization actions.
     * <p>
     * @param hostname  The name of the remote host.
     * @exception SocketException If the socket timeout could not be set.
     * @exception IOException If the socket could not be opened.  In most
     *  cases you will only want to catch IOException since SocketException is
     *  derived from it.
     * @exception UnknownHostException If the hostname cannot be resolved.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.146 -0500", hash_original_method = "D57FE7EA8899601F3786405387BCB305", hash_generated_method = "2A27D75E9027188AA3FC818ACD09C1EC")
    @DSVerified
    @DSSpec(DSCat.INTERNET)
public void connect(String hostname) throws SocketException, IOException
    {
        connect(hostname, _defaultPort_);
    }


    /**
     * Disconnects the socket connection.
     * You should call this method after you've finished using the class
     * instance and also before you call
     * {@link #connect connect() }
     * again.  _isConnected_ is set to false, _socket_ is set to null,
     * _input_ is set to null, and _output_ is set to null.
     * <p>
     * @exception IOException  If there is an error closing the socket.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.151 -0500", hash_original_method = "7C98583F77EDF407420D49C65683FC52", hash_generated_method = "3451BFE69D5642F05D8CFA219CB4C55F")
    @DSSafe(DSCat.SAFE_OTHERS)
public void disconnect() throws IOException
    {
        _socket_.close();
        _input_.close();
        _output_.close();
        _socket_ = null;
        _input_ = null;
        _output_ = null;
        _isConnected_ = false;
    }


    /**
     * Returns true if the client is currently connected to a server.
     * <p>
     * @return True if the client is currently connected to a server,
     *         false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.156 -0500", hash_original_method = "E94E451F563AEB345A5532C008598177", hash_generated_method = "80797AEB78C6B5AE0E145C627917395C")
    @DSSafe(DSCat.SAFE_OTHERS)
public boolean isConnected()
    {
        return _isConnected_;
    }


    /**
     * Sets the default port the SocketClient should connect to when a port
     * is not specified.  The {@link #_defaultPort_  _defaultPort_ }
     * variable stores this value.  If never set, the default port is equal
     * to zero.
     * <p>
     * @param port  The default port to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.161 -0500", hash_original_method = "FB52FA9DA5ADF056A39906C36DDF7C89", hash_generated_method = "86A877BCB08FAAF142E0A5A229343A28")
    @DSSafe(DSCat.SAFE_OTHERS) 
public void setDefaultPort(int port)
    {
        _defaultPort_ = port;
    }

    /**
     * Returns the current value of the default port (stored in
     * {@link #_defaultPort_  _defaultPort_ }).
     * <p>
     * @return The current value of the default port.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.166 -0500", hash_original_method = "DCF009AC615CEE14D3009D308D6D00AA", hash_generated_method = "980912D8044E6AEFD2342D1F6885DB99")
    @DSSafe(DSCat.SAFE_OTHERS)
public int getDefaultPort()
    {
        return _defaultPort_;
    }


    /**
     * Set the default timeout in milliseconds to use when opening a socket.
     * This value is only used previous to a call to
     * {@link #connect connect()}
     * and should not be confused with {@link #setSoTimeout setSoTimeout()}
     * which operates on an the currently opened socket.  _timeout_ contains
     * the new timeout value.
     * <p>
     * @param timeout  The timeout in milliseconds to use for the socket
     *                 connection.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.171 -0500", hash_original_method = "B1B69883F5517DC8F397475A3AFD5B54", hash_generated_method = "E3FC7F9EB20F1DBBCBC5E1F4A3158A29")
    @DSSafe(DSCat.SAFE_OTHERS)
public void setDefaultTimeout(int timeout)
    {
        _timeout_ = timeout;
    }


    /**
     * Returns the default timeout in milliseconds that is used when
     * opening a socket.
     * <p>
     * @return The default timeout in milliseconds that is used when
     *         opening a socket.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.175 -0500", hash_original_method = "0A2938C4AB3D789E8DE51C3D26C66274", hash_generated_method = "83F4743C6CFCE48F1B1A5C5F0F3F91E3")
    @DSSafe(DSCat.SAFE_OTHERS)
public int getDefaultTimeout()
    {
        return _timeout_;
    }


    /**
     * Set the timeout in milliseconds of a currently open connection.
     * Only call this method after a connection has been opened
     * by {@link #connect connect()}.
     * <p>
     * @param timeout  The timeout in milliseconds to use for the currently
     *                 open socket connection.
     * @exception SocketException If the operation fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.180 -0500", hash_original_method = "479DBF5E68FC96FE9C21ED750A0333B0", hash_generated_method = "8B00040ECF2DB1DEE6B13D01FA3F80D4")
    @DSSafe(DSCat.SAFE_OTHERS)
public void setSoTimeout(int timeout) throws SocketException
    {
        _socket_.setSoTimeout(timeout);
    }


    /**
     * Returns the timeout in milliseconds of the currently opened socket.
     * <p>
     * @return The timeout in milliseconds of the currently opened socket.
     * @exception SocketException If the operation fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.184 -0500", hash_original_method = "6FF781C0A1CD1666DE724FB5EDF49A3E", hash_generated_method = "AF602ED0F1F526CADF145552332EF6B3")
    @DSSafe(DSCat.SAFE_OTHERS) 
public int getSoTimeout() throws SocketException
    {
        return _socket_.getSoTimeout();
    }

    /**
     * Enables or disables the Nagle's algorithm (TCP_NODELAY) on the
     * currently opened socket.
     * <p>
     * @param on  True if Nagle's algorithm is to be enabled, false if not.
     * @exception SocketException If the operation fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.189 -0500", hash_original_method = "920C4715CC2AFFF8AD450EE6A942F5AB", hash_generated_method = "6ED48C277E9BF00E64D1875D25A3A120")
    @DSSafe(DSCat.SAFE_OTHERS) 
public void setTcpNoDelay(boolean on) throws SocketException
    {
        _socket_.setTcpNoDelay(on);
    }


    /**
     * Returns true if Nagle's algorithm is enabled on the currently opened
     * socket.
     * <p>
     * @return True if Nagle's algorithm is enabled on the currently opened
     *        socket, false otherwise.
     * @exception SocketException If the operation fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.194 -0500", hash_original_method = "18F63B14BC54F71A76CCFFE849F4289C", hash_generated_method = "474B39BC1E892D4CC86FAA6FF814156F")
    @DSSafe(DSCat.SAFE_OTHERS)
public boolean getTcpNoDelay() throws SocketException
    {
        return _socket_.getTcpNoDelay();
    }


    /**
     * Sets the SO_LINGER timeout on the currently opened socket.
     * <p>
     * @param on  True if linger is to be enabled, false if not.
     * @param val The linger timeout (in hundredths of a second?)
     * @exception SocketException If the operation fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.199 -0500", hash_original_method = "6AE183177EA54EA621FCFC3FC30A8D88", hash_generated_method = "8A3CE2DFC1C52D571A114FD309376ABB")
    @DSSafe(DSCat.SAFE_OTHERS)
public void setSoLinger(boolean on, int val) throws SocketException
    {
        _socket_.setSoLinger(on, val);
    }


    /**
     * Returns the current SO_LINGER timeout of the currently opened socket.
     * <p>
     * @return The current SO_LINGER timeout.  If SO_LINGER is disabled returns
     *         -1.
     * @exception SocketException If the operation fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.204 -0500", hash_original_method = "2CAB1FAED311E2CB18D6CDAD890CA69D", hash_generated_method = "B066C282DE90D9E7FF75974658DA94CA")
    @DSSafe(DSCat.SAFE_OTHERS)
public int getSoLinger() throws SocketException
    {
        return _socket_.getSoLinger();
    }


    /**
     * Returns the port number of the open socket on the local host used
     * for the connection.
     * <p>
     * @return The port number of the open socket on the local host used
     *         for the connection.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.209 -0500", hash_original_method = "97A9AB88FBE0CF0F4FA56668AE610FD9", hash_generated_method = "6E070E29463F86DCF93CB00D693E03A2")
    @DSSafe(DSCat.SAFE_OTHERS)
public int getLocalPort()
    {
        return _socket_.getLocalPort();
    }


    /**
     * Returns the local address to which the client's socket is bound.
     * <p>
     * @return The local address to which the client's socket is bound.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.213 -0500", hash_original_method = "695EE6197C6950818AB629303AB28701", hash_generated_method = "BCE1AD8DD07386D3740CFBA98FF2161D")
    @DSSafe(DSCat.SAFE_OTHERS)
public InetAddress getLocalAddress()
    {
        return _socket_.getLocalAddress();
    }

    /**
     * Returns the port number of the remote host to which the client is
     * connected.
     * <p>
     * @return The port number of the remote host to which the client is
     *         connected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.218 -0500", hash_original_method = "C1726499023788C9F9A3176021A48A7D", hash_generated_method = "FB9124FAE5A73B8CAC55B08A22625384")
    @DSSafe(DSCat.SAFE_OTHERS)
public int getRemotePort()
    {
        return _socket_.getPort();
    }


    /**
     * @return The remote address to which the client is connected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.223 -0500", hash_original_method = "0AC407323960F33B0316EE968EF838C2", hash_generated_method = "5E582BBE860DDD545830EB14E486575D")
    @DSSafe(DSCat.SAFE_OTHERS)
public InetAddress getRemoteAddress()
    {
        return _socket_.getInetAddress();
    }


    /**
     * Verifies that the remote end of the given socket is connected to the
     * the same host that the SocketClient is currently connected to.  This
     * is useful for doing a quick security check when a client needs to
     * accept a connection from a server, such as an FTP data connection or
     * a BSD R command standard error stream.
     * <p>
     * @return True if the remote hosts are the same, false if not.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.228 -0500", hash_original_method = "8E46176062A22F0EF265736A53696086", hash_generated_method = "727FC798DE8E6B8B3E3FD242D0744942")
    @DSSafe(DSCat.SAFE_OTHERS)
public boolean verifyRemote(Socket socket)
    {
        InetAddress host1, host2;

        host1 = socket.getInetAddress();
        host2 = getRemoteAddress();

        return host1.equals(host2);
    }


    /**
     * Sets the SocketFactory used by the SocketClient to open socket
     * connections.  If the factory value is null, then a default
     * factory is used (only do this to reset the factory after having
     * previously altered it).
     * <p>
     * @param factory  The new SocketFactory the SocketClient should use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.233 -0500", hash_original_method = "B0A4F7202C432D5F3A85378B9558CC43", hash_generated_method = "1C95F218AA3824296CD891982F3CB993")
    @DSSafe(DSCat.SAFE_OTHERS)
public void setSocketFactory(SocketFactory factory)
    {
        if (factory == null)
            _socketFactory_ = __DEFAULT_SOCKET_FACTORY;
        else
            _socketFactory_ = factory;
    }
}


