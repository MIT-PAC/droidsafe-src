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
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/***
 * The DatagramSocketClient provides the basic operations that are required
 * of client objects accessing datagram sockets.  It is meant to be
 * subclassed to avoid having to rewrite the same code over and over again
 * to open a socket, close a socket, set timeouts, etc.  Of special note
 * is the {@link #setDatagramSocketFactory  setDatagramSocketFactory }
 * method, which allows you to control the type of DatagramSocket the
 * DatagramSocketClient creates for network communications.  This is
 * especially useful for adding things like proxy support as well as better
 * support for applets.  For
 * example, you could create a
 * {@link org.apache.commons.net.DatagramSocketFactory}
 *  that
 * requests browser security capabilities before creating a socket.
 * All classes derived from DatagramSocketClient should use the
 * {@link #_socketFactory_  _socketFactory_ } member variable to
 * create DatagramSocket instances rather than instantiating
 * them by directly invoking a constructor.  By honoring this contract
 * you guarantee that a user will always be able to provide his own
 * Socket implementations by substituting his own SocketFactory.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see DatagramSocketFactory
 ***/

public abstract class DatagramSocketClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.691 -0500", hash_original_field = "A6CDEF368D9FC6C92DB2A84554905209", hash_generated_field = "1FFCF10211166CAF9D71D25088619BC3")

    private static final DatagramSocketFactory __DEFAULT_SOCKET_FACTORY =
        new DefaultDatagramSocketFactory();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.694 -0500", hash_original_field = "CB8A82913986A8891D8A21392F5B8097", hash_generated_field = "EF27B9409CBEA792130C2237C188D864")

    protected int _timeout_;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.696 -0500", hash_original_field = "EEA3AA722FD9E9E8227A0842ECB29D25", hash_generated_field = "0DEF96554A1296587E75B11C7D6AA932")

    protected DatagramSocket _socket_;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.699 -0500", hash_original_field = "DFD5D233D0E39FC430FC8B268150C34D", hash_generated_field = "1726F2D36166670CEEA216436F31E26B")

    protected boolean _isOpen_;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.702 -0500", hash_original_field = "CE893203AFFF501AC273ADAE576949C7", hash_generated_field = "748A2A92B8D8F648EB3A1CEE8425F1E7")

    protected DatagramSocketFactory _socketFactory_;

    /***
     * Default constructor for DatagramSocketClient.  Initializes
     * _socket_ to null, _timeout_ to 0, and _isOpen_ to false.
     ***/
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.706 -0500", hash_original_method = "78E49BB35B919B0760E543E32DBDB577", hash_generated_method = "B19DBE2859E4F8D0C99247FA78659753")
    
public DatagramSocketClient()
    {
        _socket_ = null;
        _timeout_ = 0;
        _isOpen_ = false;
        _socketFactory_ = __DEFAULT_SOCKET_FACTORY;
    }

    /***
     * Opens a DatagramSocket on the local host at the first available port.
     * Also sets the timeout on the socket to the default timeout set
     * by {@link #setDefaultTimeout  setDefaultTimeout() }.
     * <p>
     * _isOpen_ is set to true after calling this method and _socket_
     * is set to the newly opened socket.
     * <p>
     * @exception SocketException If the socket could not be opened or the
     *   timeout could not be set.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.709 -0500", hash_original_method = "661757EDE15E8B8BB107FC8C738925FC", hash_generated_method = "CD0D49A6C145F3D80316F9B879BF5C94")
    
public void open() throws SocketException
    {
        _socket_ = _socketFactory_.createDatagramSocket();
        _socket_.setSoTimeout(_timeout_);
        _isOpen_ = true;
    }

    /***
     * Opens a DatagramSocket on the local host at a specified port.
     * Also sets the timeout on the socket to the default timeout set
     * by {@link #setDefaultTimeout  setDefaultTimeout() }.
     * <p>
     * _isOpen_ is set to true after calling this method and _socket_
     * is set to the newly opened socket.
     * <p>
     * @param port The port to use for the socket.
     * @exception SocketException If the socket could not be opened or the
     *   timeout could not be set.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.711 -0500", hash_original_method = "B7A47EF052F2249FAE756CD065F44A21", hash_generated_method = "60BDE0D3F9831DCB4E343774010E603F")
    
public void open(int port) throws SocketException
    {
        _socket_ = _socketFactory_.createDatagramSocket(port);
        _socket_.setSoTimeout(_timeout_);
        _isOpen_ = true;
    }

    /***
     * Opens a DatagramSocket at the specified address on the local host
     * at a specified port.
     * Also sets the timeout on the socket to the default timeout set
     * by {@link #setDefaultTimeout  setDefaultTimeout() }.
     * <p>
     * _isOpen_ is set to true after calling this method and _socket_
     * is set to the newly opened socket.
     * <p>
     * @param port The port to use for the socket.
     * @param laddr  The local address to use.
     * @exception SocketException If the socket could not be opened or the
     *   timeout could not be set.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.715 -0500", hash_original_method = "0E247B548F3083C77296661041E0AEE1", hash_generated_method = "D5F97182C8FC338DAD3F49C48E269E09")
    
public void open(int port, InetAddress laddr) throws SocketException
    {
        _socket_ = _socketFactory_.createDatagramSocket(port, laddr);
        _socket_.setSoTimeout(_timeout_);
        _isOpen_ = true;
    }

    /***
     * Closes the DatagramSocket used for the connection.
     * You should call this method after you've finished using the class
     * instance and also before you call {@link #open open() }
     * again.   _isOpen_ is set to false and  _socket_ is set to null.
     * If you call this method when the client socket is not open,
     * a NullPointerException is thrown.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.718 -0500", hash_original_method = "7EDDDF2BB7563CC45994B519489CCD89", hash_generated_method = "7F969F7E51013625A10A4B84ACC81AEF")
    
public void close()
    {
        _socket_.close();
        _socket_ = null;
        _isOpen_ = false;
    }

    /***
     * Returns true if the client has a currently open socket.
     * <p>
     * @return True if the client has a curerntly open socket, false otherwise.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.721 -0500", hash_original_method = "8535257A8EC97C9D266AD8174A62E8F9", hash_generated_method = "5F61CA0B08E7DB545E43980463DAE0FD")
    
public boolean isOpen()
    {
        return _isOpen_;
    }

    /***
     * Set the default timeout in milliseconds to use when opening a socket.
     * After a call to open, the timeout for the socket is set using this value.
     * This method should be used prior to a call to {@link #open open()}
     * and should not be confused with {@link #setSoTimeout setSoTimeout()}
     * which operates on the currently open socket.  _timeout_ contains
     * the new timeout value.
     * <p>
     * @param timeout  The timeout in milliseconds to use for the datagram socket
     *                 connection.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.723 -0500", hash_original_method = "B1B69883F5517DC8F397475A3AFD5B54", hash_generated_method = "E3FC7F9EB20F1DBBCBC5E1F4A3158A29")
    
public void setDefaultTimeout(int timeout)
    {
        _timeout_ = timeout;
    }

    /***
     * Returns the default timeout in milliseconds that is used when
     * opening a socket.
     * <p>
     * @return The default timeout in milliseconds that is used when
     *         opening a socket.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.726 -0500", hash_original_method = "0A2938C4AB3D789E8DE51C3D26C66274", hash_generated_method = "83F4743C6CFCE48F1B1A5C5F0F3F91E3")
    
public int getDefaultTimeout()
    {
        return _timeout_;
    }

    /***
     * Set the timeout in milliseconds of a currently open connection.
     * Only call this method after a connection has been opened
     * by {@link #open open()}.
     * <p>
     * @param timeout  The timeout in milliseconds to use for the currently
     *                 open datagram socket connection.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.729 -0500", hash_original_method = "479DBF5E68FC96FE9C21ED750A0333B0", hash_generated_method = "8B00040ECF2DB1DEE6B13D01FA3F80D4")
    
public void setSoTimeout(int timeout) throws SocketException
    {
        _socket_.setSoTimeout(timeout);
    }

    /***
     * Returns the timeout in milliseconds of the currently opened socket.
     * If you call this method when the client socket is not open,
     * a NullPointerException is thrown.
     * <p>
     * @return The timeout in milliseconds of the currently opened socket.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.731 -0500", hash_original_method = "6FF781C0A1CD1666DE724FB5EDF49A3E", hash_generated_method = "AF602ED0F1F526CADF145552332EF6B3")
    
public int getSoTimeout() throws SocketException
    {
        return _socket_.getSoTimeout();
    }

    /***
     * Returns the port number of the open socket on the local host used
     * for the connection.  If you call this method when the client socket
     * is not open, a NullPointerException is thrown.
     * <p>
     * @return The port number of the open socket on the local host used
     *         for the connection.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.734 -0500", hash_original_method = "97A9AB88FBE0CF0F4FA56668AE610FD9", hash_generated_method = "6E070E29463F86DCF93CB00D693E03A2")
    
public int getLocalPort()
    {
        return _socket_.getLocalPort();
    }

    /***
     * Returns the local address to which the client's socket is bound.
     * If you call this method when the client socket is not open, a
     * NullPointerException is thrown.
     * <p>
     * @return The local address to which the client's socket is bound.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.737 -0500", hash_original_method = "695EE6197C6950818AB629303AB28701", hash_generated_method = "BCE1AD8DD07386D3740CFBA98FF2161D")
    
public InetAddress getLocalAddress()
    {
        return _socket_.getLocalAddress();
    }

    /***
     * Sets the DatagramSocketFactory used by the DatagramSocketClient
     * to open DatagramSockets.  If the factory value is null, then a default
     * factory is used (only do this to reset the factory after having
     * previously altered it).
     * <p>
     * @param factory  The new DatagramSocketFactory the DatagramSocketClient
     * should use.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.740 -0500", hash_original_method = "0FCD418868B1330D6606596C51F06F41", hash_generated_method = "8B9F03B5D57B3F6504095624B7E27674")
    
public void setDatagramSocketFactory(DatagramSocketFactory factory)
    {
        if (factory == null)
            _socketFactory_ = __DEFAULT_SOCKET_FACTORY;
        else
            _socketFactory_ = factory;
    }
}
