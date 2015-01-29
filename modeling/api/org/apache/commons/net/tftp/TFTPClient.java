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
package org.apache.commons.net.tftp;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import org.apache.commons.net.io.FromNetASCIIOutputStream;
import org.apache.commons.net.io.ToNetASCIIInputStream;

/***
 * The TFTPClient class encapsulates all the aspects of the TFTP protocol
 * necessary to receive and send files through TFTP.  It is derived from
 * the {@link org.apache.commons.net.tftp.TFTP} because
 * it is more convenient than using aggregation, and as a result exposes
 * the same set of methods to allow you to deal with the TFTP protocol
 * directly.  However, almost every user should only be concerend with the
 * the {@link org.apache.commons.net.DatagramSocketClient#open  open() },
 * {@link org.apache.commons.net.DatagramSocketClient#close  close() },
 * {@link #sendFile  sendFile() }, and
 * {@link #receiveFile  receiveFile() } methods.  Additionally, the
 * {@link #setMaxTimeouts  setMaxTimeouts() } and
 * {@link org.apache.commons.net.DatagramSocketClient#setDefaultTimeout setDefaultTimeout() }
 *  methods may be of importance for performance
 * tuning.
 * <p>
 * Details regarding the TFTP protocol and the format of TFTP packets can
 * be found in RFC 783.  But the point of these classes is to keep you
 * from having to worry about the internals.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see TFTP
 * @see TFTPPacket
 * @see TFTPPacketException
 ***/

public class TFTPClient extends TFTP
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.263 -0500", hash_original_field = "335A8821165BB1CDA4BA20599D861530", hash_generated_field = "A69D19312E72E1A2694A014FCFCC55C2")

    public static final int DEFAULT_MAX_TIMEOUTS = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.266 -0500", hash_original_field = "5214B88C9BD903B33F6E3F79EFCB75FD", hash_generated_field = "0DF598BBB54C546BDF2682A8A8764CC6")

    private int __maxTimeouts;

    /***
     * Creates a TFTPClient instance with a default timeout of DEFAULT_TIMEOUT,
     * maximum timeouts value of DEFAULT_MAX_TIMEOUTS, a null socket,
     * and buffered operations disabled.
     ***/
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.269 -0500", hash_original_method = "03A3B0C88D7350527C9A84271D66FB59", hash_generated_method = "2A0D691EF18D2CA6B1BC62CDF9C5FDF8")
    
public TFTPClient()
    {
        __maxTimeouts = DEFAULT_MAX_TIMEOUTS;
    }

    /***
     * Sets the maximum number of times a receive attempt is allowed to
     * timeout during a receiveFile() or sendFile() operation before ending
     * attempts to retry the receive and failing.
     * The default is DEFAULT_MAX_TIMEOUTS.
     * <p>
     * @param numTimeouts  The maximum number of timeouts to allow.  Values
     *        less than 1 should not be used, but if they are, they are
     *        treated as 1.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.272 -0500", hash_original_method = "29D7C0BA0D81E8D905E4C430DB53FA58", hash_generated_method = "C46E8E558FF87B024C71118A04CFE7E0")
    
public void setMaxTimeouts(int numTimeouts)
    {
        if (numTimeouts < 1)
            __maxTimeouts = 1;
        else
            __maxTimeouts = numTimeouts;
    }

    /***
     * Returns the maximum number of times a receive attempt is allowed to
     * timeout before ending attempts to retry the receive and failing.
     * <p>
     * @return The maximum number of timeouts allowed.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.275 -0500", hash_original_method = "830ED068D29B012C0B05FF50452F2342", hash_generated_method = "F8F4C09043E43EA9CD3DFBA6008E8BCB")
    
public int getMaxTimeouts()
    {
        return __maxTimeouts;
    }

    /***
     * Requests a named file from a remote host, writes the
     * file to an OutputStream, closes the connection, and returns the number
     * of bytes read.  A local UDP socket must first be created by
     * {@link org.apache.commons.net.DatagramSocketClient#open open()} before
     * invoking this method.  This method will not close the OutputStream
     * containing the file; you must close it after the method invocation.
     * <p>
     * @param filename  The name of the file to receive.
     * @param mode   The TFTP mode of the transfer (one of the MODE constants).
     * @param output The OutputStream to which the file should be written.
     * @param host   The remote host serving the file.
     * @param port   The port number of the remote TFTP server.
     * @exception IOException If an I/O error occurs.  The nature of the
     *            error will be reported in the message.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.281 -0500", hash_original_method = "3790D68CF6F2917BE3EE7CBD084B3D56", hash_generated_method = "625731CA4D0F474A9FA515AA966126B2")
    
public int receiveFile(String filename, int mode, OutputStream output,
                           InetAddress host, int port) throws IOException
    {
        int bytesRead, timeouts, lastBlock, block, hostPort, dataLength;
        TFTPPacket sent, received = null;
        TFTPErrorPacket error;
        TFTPDataPacket data;
        TFTPAckPacket ack = new TFTPAckPacket(host, port, 0);

        beginBufferedOps();

        dataLength = lastBlock = hostPort = bytesRead = 0;
        block = 1;

        if (mode == TFTP.ASCII_MODE)
            output = new FromNetASCIIOutputStream(output);

        sent =
            new TFTPReadRequestPacket(host, port, filename, mode);

_sendPacket:
        do
        {
            bufferedSend(sent);

_receivePacket:
            while (true)
            {
                timeouts = 0;
                while (timeouts < __maxTimeouts)
                {
                    try
                    {
                        received = bufferedReceive();
                        break;
                    }
                    catch (SocketException e)
                    {
                        if (++timeouts >= __maxTimeouts)
                        {
                            endBufferedOps();
                            throw new IOException("Connection timed out.");
                        }
                        continue;
                    }
                    catch (InterruptedIOException e)
                    {
                        if (++timeouts >= __maxTimeouts)
                        {
                            endBufferedOps();
                            throw new IOException("Connection timed out.");
                        }
                        continue;
                    }
                    catch (TFTPPacketException e)
                    {
                        endBufferedOps();
                        throw new IOException("Bad packet: " + e.getMessage());
                    }
                }

                // The first time we receive we get the port number and
        // answering host address (for hosts with multiple IPs)
                if (lastBlock == 0)
                {
                    hostPort = received.getPort();
                    ack.setPort(hostPort);
                    if(!host.equals(received.getAddress()))
                    {
                        host = received.getAddress();
                        ack.setAddress(host);
                        sent.setAddress(host);
                    }
                }

                // Comply with RFC 783 indication that an error acknowledgement
                // should be sent to originator if unexpected TID or host.
                if (host.equals(received.getAddress()) &&
                        received.getPort() == hostPort)
                {

                    switch (received.getType())
                    {
                    case TFTPPacket.ERROR:
                        error = (TFTPErrorPacket)received;
                        endBufferedOps();
                        throw new IOException("Error code " + error.getError() +
                                              " received: " + error.getMessage());
                    case TFTPPacket.DATA:
                        data = (TFTPDataPacket)received;
                        dataLength = data.getDataLength();

                        lastBlock = data.getBlockNumber();

                        if (lastBlock == block)
                        {
                            try
                            {
                                output.write(data.getData(), data.getDataOffset(),
                                             dataLength);
                            }
                            catch (IOException e)
                            {
                                error = new TFTPErrorPacket(host, hostPort,
                                                            TFTPErrorPacket.OUT_OF_SPACE,
                                                            "File write failed.");
                                bufferedSend(error);
                                endBufferedOps();
                                throw e;
                            }
                            ++block;
                            break _receivePacket;
                        }
                        else
                        {
                            discardPackets();

                            if (lastBlock == (block - 1))
                                continue _sendPacket;  // Resend last acknowledgement.

                            continue _receivePacket; // Start fetching packets again.
                        }
                        //break;

                    default:
                        endBufferedOps();
                        throw new IOException("Received unexpected packet type.");
                    }
                }
                else
                {
                    error = new TFTPErrorPacket(received.getAddress(),
                                                received.getPort(),
                                                TFTPErrorPacket.UNKNOWN_TID,
                                                "Unexpected host or port.");
                    bufferedSend(error);
                    continue _sendPacket;
                }

                // We should never get here, but this is a safety to avoid
                // infinite loop.  If only Java had the goto statement.
                //break;
            }

            ack.setBlockNumber(lastBlock);
            sent = ack;
            bytesRead += dataLength;
        } // First data packet less than 512 bytes signals end of stream.

        while (dataLength == TFTPPacket.SEGMENT_SIZE);

        bufferedSend(sent);
        endBufferedOps();

        return bytesRead;
    }

    /***
     * Requests a named file from a remote host, writes the
     * file to an OutputStream, closes the connection, and returns the number
     * of bytes read.  A local UDP socket must first be created by
     * {@link org.apache.commons.net.DatagramSocketClient#open open()} before
     * invoking this method.  This method will not close the OutputStream
     * containing the file; you must close it after the method invocation.
     * <p>
     * @param filename The name of the file to receive.
     * @param mode     The TFTP mode of the transfer (one of the MODE constants).
     * @param output   The OutputStream to which the file should be written.
     * @param hostname The name of the remote host serving the file.
     * @param port     The port number of the remote TFTP server.
     * @exception IOException If an I/O error occurs.  The nature of the
     *            error will be reported in the message.
     * @exception UnknownHostException  If the hostname cannot be resolved.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.284 -0500", hash_original_method = "581F17EFC12C987CF4BE8B097041D445", hash_generated_method = "3D44E7F4E2ACA70EFF005D3860F8BD12")
    
public int receiveFile(String filename, int mode, OutputStream output,
                           String hostname, int port)
    throws UnknownHostException, IOException
    {
        return receiveFile(filename, mode, output, InetAddress.getByName(hostname),
                           port);
    }

    /***
     * Same as calling receiveFile(filename, mode, output, host, TFTP.DEFAULT_PORT).
     *
     * @param filename The name of the file to receive.
     * @param mode     The TFTP mode of the transfer (one of the MODE constants).
     * @param output   The OutputStream to which the file should be written.
     * @param host     The remote host serving the file.
     * @exception IOException If an I/O error occurs.  The nature of the
     *            error will be reported in the message.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.289 -0500", hash_original_method = "CFCAD341235F37A4BB7DBC5A0D66ECE2", hash_generated_method = "F3F38ABC98AD185F1F455D50033A29E3")
    
public int receiveFile(String filename, int mode, OutputStream output,
                           InetAddress host)
    throws IOException
    {
        return receiveFile(filename, mode, output, host, DEFAULT_PORT);
    }

    /***
     * Same as calling receiveFile(filename, mode, output, hostname, TFTP.DEFAULT_PORT).
     *
     * @param filename The name of the file to receive.
     * @param mode     The TFTP mode of the transfer (one of the MODE constants).
     * @param output   The OutputStream to which the file should be written.
     * @param hostname The name of the remote host serving the file.
     * @exception IOException If an I/O error occurs.  The nature of the
     *            error will be reported in the message.
     * @exception UnknownHostException  If the hostname cannot be resolved.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.292 -0500", hash_original_method = "7B5DE20FF19445D9F18EB294E5B92363", hash_generated_method = "F466728A08A91AA61DCD7E14427C8EF3")
    
public int receiveFile(String filename, int mode, OutputStream output,
                           String hostname)
    throws UnknownHostException, IOException
    {
        return receiveFile(filename, mode, output, InetAddress.getByName(hostname),
                           DEFAULT_PORT);
    }

    /***
     * Requests to send a file to a remote host, reads the file from an
     * InputStream, sends the file to the remote host, and closes the
     * connection.  A local UDP socket must first be created by
     * {@link org.apache.commons.net.DatagramSocketClient#open open()} before
     * invoking this method.  This method will not close the InputStream
     * containing the file; you must close it after the method invocation.
     * <p>
     * @param filename The name the remote server should use when creating
     *        the file on its file system.
     * @param mode     The TFTP mode of the transfer (one of the MODE constants).
     * @param host     The remote host receiving the file.
     * @param port     The port number of the remote TFTP server.
     * @exception IOException If an I/O error occurs.  The nature of the
     *            error will be reported in the message.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.297 -0500", hash_original_method = "238433F04ECBD5A164FEE2CEB5118400", hash_generated_method = "9D53C958C37D1E8198AF378E22117C39")
    
public void sendFile(String filename, int mode, InputStream input,
                         InetAddress host, int port) throws IOException
    {
        int bytesRead, timeouts, lastBlock, block, hostPort, dataLength, offset;
        TFTPPacket sent, received = null;
        TFTPErrorPacket error;
        TFTPDataPacket data =
            new TFTPDataPacket(host, port, 0, _sendBuffer, 4, 0);
        ;
        TFTPAckPacket ack;

        beginBufferedOps();

        dataLength = lastBlock = hostPort = bytesRead = 0;
        block = 0;
        boolean lastAckWait = false;

        if (mode == TFTP.ASCII_MODE)
            input = new ToNetASCIIInputStream(input);

        sent =
            new TFTPWriteRequestPacket(host, port, filename, mode);

_sendPacket:
        do
        {
            bufferedSend(sent);

_receivePacket:
            while (true)
            {
                timeouts = 0;
                while (timeouts < __maxTimeouts)
                {
                    try
                    {
                        received = bufferedReceive();
                        break;
                    }
                    catch (SocketException e)
                    {
                        if (++timeouts >= __maxTimeouts)
                        {
                            endBufferedOps();
                            throw new IOException("Connection timed out.");
                        }
                        continue;
                    }
                    catch (InterruptedIOException e)
                    {
                        if (++timeouts >= __maxTimeouts)
                        {
                            endBufferedOps();
                            throw new IOException("Connection timed out.");
                        }
                        continue;
                    }
                    catch (TFTPPacketException e)
                    {
                        endBufferedOps();
                        throw new IOException("Bad packet: " + e.getMessage());
                    }
                }

                // The first time we receive we get the port number and
        // answering host address (for hosts with multiple IPs)
                if (lastBlock == 0)
                {
                    hostPort = received.getPort();
                    data.setPort(hostPort);
                    if(!host.equals(received.getAddress()))
                    {
                        host = received.getAddress();
                        data.setAddress(host);
                        sent.setAddress(host);
                    }
                }

                // Comply with RFC 783 indication that an error acknowledgement
                // should be sent to originator if unexpected TID or host.
                if (host.equals(received.getAddress()) &&
                        received.getPort() == hostPort)
                {

                    switch (received.getType())
                    {
                    case TFTPPacket.ERROR:
                        error = (TFTPErrorPacket)received;
                        endBufferedOps();
                        throw new IOException("Error code " + error.getError() +
                                              " received: " + error.getMessage());
                    case TFTPPacket.ACKNOWLEDGEMENT:
                        ack = (TFTPAckPacket)received;

                        lastBlock = ack.getBlockNumber();

                        if (lastBlock == block)
                        {
                            ++block;
                            if (lastAckWait)
                              break _sendPacket;
                            else
                              break _receivePacket;
                        }
                        else
                        {
                            discardPackets();

                            if (lastBlock == (block - 1))
                                continue _sendPacket;  // Resend last acknowledgement.

                            continue _receivePacket; // Start fetching packets again.
                        }
                        //break;

                    default:
                        endBufferedOps();
                        throw new IOException("Received unexpected packet type.");
                    }
                }
                else
                {
                    error = new TFTPErrorPacket(received.getAddress(),
                                                received.getPort(),
                                                TFTPErrorPacket.UNKNOWN_TID,
                                                "Unexpected host or port.");
                    bufferedSend(error);
                    continue _sendPacket;
                }

                // We should never get here, but this is a safety to avoid
                // infinite loop.  If only Java had the goto statement.
                //break;
            }

            dataLength = TFTPPacket.SEGMENT_SIZE;
            offset = 4;
            while (dataLength > 0 &&
                    (bytesRead = input.read(_sendBuffer, offset, dataLength)) > 0)
            {
                offset += bytesRead;
                dataLength -= bytesRead;
            }

            data.setBlockNumber(block);
            data.setData(_sendBuffer, 4, offset - 4);
            sent = data;
        }
        while (dataLength == 0 || lastAckWait);

        endBufferedOps();
    }

    /***
     * Requests to send a file to a remote host, reads the file from an
     * InputStream, sends the file to the remote host, and closes the
     * connection.  A local UDP socket must first be created by
     * {@link org.apache.commons.net.DatagramSocketClient#open open()} before
     * invoking this method.  This method will not close the InputStream
     * containing the file; you must close it after the method invocation.
     * <p>
     * @param filename The name the remote server should use when creating
     *        the file on its file system.
     * @param mode     The TFTP mode of the transfer (one of the MODE constants).
     * @param hostname The name of the remote host receiving the file.
     * @param port     The port number of the remote TFTP server.
     * @exception IOException If an I/O error occurs.  The nature of the
     *            error will be reported in the message.
     * @exception UnknownHostException  If the hostname cannot be resolved.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.301 -0500", hash_original_method = "3E0D1327EB8186CCC1950922EC8443F2", hash_generated_method = "A9DE5335EACFB37D86ABF5940B03E2E1")
    
public void sendFile(String filename, int mode, InputStream input,
                         String hostname, int port)
    throws UnknownHostException, IOException
    {
        sendFile(filename, mode, input, InetAddress.getByName(hostname), port);
    }

    /***
     * Same as calling sendFile(filename, mode, input, host, TFTP.DEFAULT_PORT).
     *
     * @param filename The name the remote server should use when creating
     *        the file on its file system.
     * @param mode     The TFTP mode of the transfer (one of the MODE constants).
     * @param host     The name of the remote host receiving the file.
     * @exception IOException If an I/O error occurs.  The nature of the
     *            error will be reported in the message.
     * @exception UnknownHostException  If the hostname cannot be resolved.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.305 -0500", hash_original_method = "606F0DCA7612149020DC0A3888C38263", hash_generated_method = "7824CF6264FC8702E43E9566F871EFE8")
    
public void sendFile(String filename, int mode, InputStream input,
                         InetAddress host)
    throws IOException
    {
        sendFile(filename, mode, input, host, DEFAULT_PORT);
    }

    /***
     * Same as calling sendFile(filename, mode, input, hostname, TFTP.DEFAULT_PORT).
     *
     * @param filename The name the remote server should use when creating
     *        the file on its file system.
     * @param mode     The TFTP mode of the transfer (one of the MODE constants).
     * @param hostname The name of the remote host receiving the file.
     * @exception IOException If an I/O error occurs.  The nature of the
     *            error will be reported in the message.
     * @exception UnknownHostException  If the hostname cannot be resolved.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.308 -0500", hash_original_method = "5BEDF6211D5BCB4D36F053D483B3651C", hash_generated_method = "D7B0492C586B0D3F3B98C6AA5C3E336D")
    
public void sendFile(String filename, int mode, InputStream input,
                         String hostname)
    throws UnknownHostException, IOException
    {
        sendFile(filename, mode, input, InetAddress.getByName(hostname),
                 DEFAULT_PORT);
    }
}
