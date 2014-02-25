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
package org.apache.commons.net.smtp;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Enumeration;
import java.util.Vector;
import org.apache.commons.net.MalformedServerReplyException;
import org.apache.commons.net.ProtocolCommandListener;
import org.apache.commons.net.ProtocolCommandSupport;
import org.apache.commons.net.SocketClient;

/***
 * SMTP provides the basic the functionality necessary to implement your
 * own SMTP client.  To derive the full benefits of the SMTP class requires
 * some knowledge of the FTP protocol defined in RFC 821.  However, there
 * is no reason why you should have to use the SMTP class.  The
 * {@link org.apache.commons.net.smtp.SMTPClient} class,
 * derived from SMTP,
 * implements all the functionality required of an SMTP client.  The
 * SMTP class is made public to provide access to various SMTP constants
 * and to make it easier for adventurous programmers (or those with
 * special needs) to interact with the SMTP protocol and implement their
 * own clients.  A set of methods with names corresponding to the SMTP
 * command names are provided to facilitate this interaction.
 * <p>
 * You should keep in mind that the SMTP server may choose to prematurely
 * close a connection for various reasons.  The SMTP class will detect a
 * premature SMTP server connection closing when it receives a
 * {@link org.apache.commons.net.smtp.SMTPReply#SERVICE_NOT_AVAILABLE SMTPReply.SERVICE_NOT_AVAILABLE }
 *  response to a command.
 * When that occurs, the SMTP class method encountering that reply will throw
 * an {@link org.apache.commons.net.smtp.SMTPConnectionClosedException}
 * .
 * <code>SMTPConectionClosedException</code>
 * is a subclass of <code> IOException </code> and therefore need not be
 * caught separately, but if you are going to catch it separately, its
 * catch block must appear before the more general <code> IOException </code>
 * catch block.  When you encounter an
 * {@link org.apache.commons.net.smtp.SMTPConnectionClosedException}
 * , you must disconnect the connection with
 * {@link org.apache.commons.net.SocketClient#disconnect  disconnect() }
 * to properly clean up the system resources used by SMTP.  Before
 * disconnecting, you may check the
 * last reply code and text with
 * {@link #getReplyCode  getReplyCode },
 * {@link #getReplyString  getReplyString },
 * and {@link #getReplyStrings  getReplyStrings}.
 * <p>
 * Rather than list it separately for each method, we mention here that
 * every method communicating with the server and throwing an IOException
 * can also throw a
 * {@link org.apache.commons.net.MalformedServerReplyException}
 * , which is a subclass
 * of IOException.  A MalformedServerReplyException will be thrown when
 * the reply received from the server deviates enough from the protocol
 * specification that it cannot be interpreted in a useful manner despite
 * attempts to be as lenient as possible.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see SMTPClient
 * @see SMTPConnectionClosedException
 * @see org.apache.commons.net.MalformedServerReplyException
 ***/

public class SMTP extends SocketClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.349 -0500", hash_original_field = "BC7D46F6039E4A8B1D92B1488760D57E", hash_generated_field = "7EEA69CA3FDDCA7E8976B8D4B6BB0BF4")

    public static final int DEFAULT_PORT = 25;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.353 -0500", hash_original_field = "ED28C05F169DA0DE12EEA2F104BE3971", hash_generated_field = "42B1008CD8EE34AD3B14B05D542AC1CB")

    // but we use ISO-8859-1 just in case 8-bit characters cross
    // the wire.
    private static final String __DEFAULT_ENCODING = "ISO-8859-1";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.356 -0500", hash_original_field = "5851BF2FEF5A8535EAD5AA9837C9C499", hash_generated_field = "B44FD5DD0C96DE651EF02982D44EF837")


    private StringBuffer __commandBuffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.360 -0500", hash_original_field = "3B06A6A58FD8BA55C2BC8C2DF80650D4", hash_generated_field = "3B06A6A58FD8BA55C2BC8C2DF80650D4")


    BufferedReader _reader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.363 -0500", hash_original_field = "6D9F052A13DE4C4E60F654F796978D79", hash_generated_field = "6D9F052A13DE4C4E60F654F796978D79")

    BufferedWriter _writer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.366 -0500", hash_original_field = "96C814136BEA461ACBAD7291EA9D0AEA", hash_generated_field = "96C814136BEA461ACBAD7291EA9D0AEA")

    int _replyCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.370 -0500", hash_original_field = "23C4AF34777206128B89D0EB51F39B80", hash_generated_field = "23C4AF34777206128B89D0EB51F39B80")

    Vector _replyLines;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.373 -0500", hash_original_field = "2C9A08621054C4CB83B29BBCA0D2DEA0", hash_generated_field = "2C9A08621054C4CB83B29BBCA0D2DEA0")

    boolean _newReplyString;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.376 -0500", hash_original_field = "9D4E6ACED62C1C9F619D254C9BB4714F", hash_generated_field = "9D4E6ACED62C1C9F619D254C9BB4714F")

    String _replyString;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.379 -0500", hash_original_field = "7DAF899D0A7A2C717C865E5E7E08CC52", hash_generated_field = "953ACDAC0C44CE1C293FA84B06DBBA20")

    protected ProtocolCommandSupport _commandSupport_;

    /***
     * The default SMTP constructor.  Sets the default port to
     * <code>DEFAULT_PORT</code> and initializes internal data structures
     * for saving SMTP reply information.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.389 -0500", hash_original_method = "9F40EF610D87F26524AC6D109A5BE297", hash_generated_method = "50F3D9B24A302707056EF234BCACCD48")
    
public SMTP()
    {
        setDefaultPort(DEFAULT_PORT);
        __commandBuffer = new StringBuffer();
        _replyLines = new Vector();
        _newReplyString = false;
        _replyString = null;
        _commandSupport_ = new ProtocolCommandSupport(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.393 -0500", hash_original_method = "1D3E8BFCD7325AB348F43D5C5B1437A0", hash_generated_method = "E6956E6D765D88ED0AA3A7175C92BC2E")
    
private int __sendCommand(String command, String args, boolean includeSpace)
    throws IOException
    {
        String message;

        __commandBuffer.setLength(0);
        __commandBuffer.append(command);

        if (args != null)
        {
            if (includeSpace)
                __commandBuffer.append(' ');
            __commandBuffer.append(args);
        }

        __commandBuffer.append(SocketClient.NETASCII_EOL);

        _writer.write(message = __commandBuffer.toString());
        _writer.flush();

        if (_commandSupport_.getListenerCount() > 0)
            _commandSupport_.fireCommandSent(command, message);

        __getReply();
        return _replyCode;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.396 -0500", hash_original_method = "39E467315B0550F4BCD2DCF905E6BAC3", hash_generated_method = "B79E0F8C114406AB0F3D873846D4CF7A")
    
private int __sendCommand(int command, String args, boolean includeSpace)
    throws IOException
    {
        return __sendCommand(SMTPCommand._commands[command], args, includeSpace);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.401 -0500", hash_original_method = "2E97ADF91021E508EA557CC7491DEEE5", hash_generated_method = "D21CD44644C6BA04EF9673339E05EFD9")
    
private void __getReply() throws IOException
    {
        int length;

        _newReplyString = true;
        _replyLines.setSize(0);

        String line = _reader.readLine();

        if (line == null)
            throw new SMTPConnectionClosedException(
                "Connection closed without indication.");

        // In case we run into an anomaly we don't want fatal index exceptions
        // to be thrown.
        length = line.length();
        if (length < 3)
            throw new MalformedServerReplyException(
                "Truncated server reply: " + line);

        try
        {
            String code = line.substring(0, 3);
            _replyCode = Integer.parseInt(code);
        }
        catch (NumberFormatException e)
        {
            throw new MalformedServerReplyException(
                "Could not parse response code.\nServer Reply: " + line);
        }

        _replyLines.addElement(line);

        // Get extra lines if message continues.
        if (length > 3 && line.charAt(3) == '-')
        {
            do
            {
                line = _reader.readLine();

                if (line == null)
                    throw new SMTPConnectionClosedException(
                        "Connection closed without indication.");

                _replyLines.addElement(line);

                // The length() check handles problems that could arise from readLine()
                // returning too soon after encountering a naked CR or some other
                // anomaly.
            }
            while (!(line.length() >= 4 && line.charAt(3) != '-' &&
                     Character.isDigit(line.charAt(0))));
            // This is too strong a condition because a non-conforming server
            // could screw things up like ftp.funet.fi does for FTP
            // line.startsWith(code)));
        }

        if (_commandSupport_.getListenerCount() > 0)
            _commandSupport_.fireReplyReceived(_replyCode, getReplyString());

        if (_replyCode == SMTPReply.SERVICE_NOT_AVAILABLE)
            throw new SMTPConnectionClosedException(
                "SMTP response 421 received.  Server closed connection.");
    }

    /*** Initiates control connections and gets initial reply. ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.404 -0500", hash_original_method = "4BE5AFBC6E7AF7109FE6D4429F8CEB8D", hash_generated_method = "D1A4E670EEBDCB98A0A2CF76FD22C954")
    
protected void _connectAction_() throws IOException
    {
        super._connectAction_();
        _reader =
            new BufferedReader(new InputStreamReader(_input_,
                                                     __DEFAULT_ENCODING));
        _writer =
            new BufferedWriter(new OutputStreamWriter(_output_,
                                                      __DEFAULT_ENCODING));
        __getReply();
    }


    /***
     * Adds a ProtocolCommandListener.  Delegates this task to
     * {@link #_commandSupport_  _commandSupport_ }.
     * <p>
     * @param listener  The ProtocolCommandListener to add.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.407 -0500", hash_original_method = "B2E7C8147EAF016E25D01B4A081623E2", hash_generated_method = "EBB19817C4DDE4A3C65E2B3B1F18E706")
    
public void addProtocolCommandListener(ProtocolCommandListener listener)
    {
        _commandSupport_.addProtocolCommandListener(listener);
    }

    /***
     * Removes a ProtocolCommandListener.  Delegates this task to
     * {@link #_commandSupport_  _commandSupport_ }.
     * <p>
     * @param listener  The ProtocolCommandListener to remove.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.410 -0500", hash_original_method = "17C790A63BE2E925F1B089C57BEDE92F", hash_generated_method = "61530F256429087D025AC2A72509A95D")
    
public void removeProtocolCommandistener(ProtocolCommandListener listener)
    {
        _commandSupport_.removeProtocolCommandListener(listener);
    }


    /***
     * Closes the connection to the SMTP server and sets to null
     * some internal data so that the memory may be reclaimed by the
     * garbage collector.  The reply text and code information from the
     * last command is voided so that the memory it used may be reclaimed.
     * <p>
     * @exception IOException If an error occurs while disconnecting.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.413 -0500", hash_original_method = "270AE27F27A3F7621C8092BA94DE298D", hash_generated_method = "18BBEE17F7D24A9079B33AEDF2E4EF50")
    
public void disconnect() throws IOException
    {
        super.disconnect();
        _reader = null;
        _writer = null;
        _replyString = null;
        _replyLines.setSize(0);
        _newReplyString = false;
    }


    /***
     * Sends an SMTP command to the server, waits for a reply and returns the
     * numerical response code.  After invocation, for more detailed
     * information, the actual reply text can be accessed by calling
     * {@link #getReplyString  getReplyString } or
     * {@link #getReplyStrings  getReplyStrings }.
     * <p>
     * @param command  The text representation of the  SMTP command to send.
     * @param args The arguments to the SMTP command.  If this parameter is
     *             set to null, then the command is sent with no argument.
     * @return The integer value of the SMTP reply code returned by the server
     *         in response to the command.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.417 -0500", hash_original_method = "0218F4D28BBAC52F4E4CDA38DE21ED29", hash_generated_method = "A6523FFC35A73A72F6578AEEF3CC2A9D")
    
public int sendCommand(String command, String args) throws IOException
    {
        return __sendCommand(command, args, true);
    }


    /***
     * Sends an SMTP command to the server, waits for a reply and returns the
     * numerical response code.  After invocation, for more detailed
     * information, the actual reply text can be accessed by calling
     * {@link #getReplyString  getReplyString } or
     * {@link #getReplyStrings  getReplyStrings }.
     * <p>
     * @param command  The SMTPCommand constant corresponding to the SMTP command
     *                 to send.
     * @param args The arguments to the SMTP command.  If this parameter is
     *             set to null, then the command is sent with no argument.
     * @return The integer value of the SMTP reply code returned by the server
     *         in response to the command.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.419 -0500", hash_original_method = "8DE93EB71DBB87CAEC8D19D2B5E0D583", hash_generated_method = "153ED036F6D2AC6DDC165C7DD1F9EF63")
    
public int sendCommand(int command, String args) throws IOException
    {
        return sendCommand(SMTPCommand._commands[command], args);
    }


    /***
     * Sends an SMTP command with no arguments to the server, waits for a
     * reply and returns the numerical response code.  After invocation, for
     * more detailed information, the actual reply text can be accessed by
     * calling {@link #getReplyString  getReplyString } or
     * {@link #getReplyStrings  getReplyStrings }.
     * <p>
     * @param command  The text representation of the  SMTP command to send.
     * @return The integer value of the SMTP reply code returned by the server
     *         in response to the command.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.423 -0500", hash_original_method = "249D1EA65C901278A4D9A21CA58581D8", hash_generated_method = "319B33627FD404284CF2FADC01D735DC")
    
public int sendCommand(String command) throws IOException
    {
        return sendCommand(command, null);
    }


    /***
     * Sends an SMTP command with no arguments to the server, waits for a
     * reply and returns the numerical response code.  After invocation, for
     * more detailed information, the actual reply text can be accessed by
     * calling {@link #getReplyString  getReplyString } or
     * {@link #getReplyStrings  getReplyStrings }.
     * <p>
     * @param command  The SMTPCommand constant corresponding to the SMTP command
     *                 to send.
     * @return The integer value of the SMTP reply code returned by the server
     *         in response to the command.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.426 -0500", hash_original_method = "1F8849508E07E274C5D8FC641A8F26DF", hash_generated_method = "9641A9247D5EAF7473C640D4A279E4DE")
    
public int sendCommand(int command) throws IOException
    {
        return sendCommand(command, null);
    }


    /***
     * Returns the integer value of the reply code of the last SMTP reply.
     * You will usually only use this method after you connect to the
     * SMTP server to check that the connection was successful since
     * <code> connect </code> is of type void.
     * <p>
     * @return The integer value of the reply code of the last SMTP reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.429 -0500", hash_original_method = "C50A2128BE09AED79AF9E811C678D377", hash_generated_method = "B9B64ED2E5BE5B2AD33B35CE05FA014A")
    
public int getReplyCode()
    {
        return _replyCode;
    }

    /***
     * Fetches a reply from the SMTP server and returns the integer reply
     * code.  After calling this method, the actual reply text can be accessed
     * from either  calling {@link #getReplyString  getReplyString } or
     * {@link #getReplyStrings  getReplyStrings }.  Only use this
     * method if you are implementing your own SMTP client or if you need to
     * fetch a secondary response from the SMTP server.
     * <p>
     * @return The integer value of the reply code of the fetched SMTP reply.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while receiving the
     *                         server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.433 -0500", hash_original_method = "7A68383686F9416248FE3E530FCEE8A5", hash_generated_method = "575287EC1D25B9CB6A334BD3212BBDC7")
    
public int getReply() throws IOException
    {
        __getReply();
        return _replyCode;
    }


    /***
     * Returns the lines of text from the last SMTP server response as an array
     * of strings, one entry per line.  The end of line markers of each are
     * stripped from each line.
     * <p>
     * @return The lines of text from the last SMTP response as an array.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.436 -0500", hash_original_method = "3A94E407C2A98EED939BFA1A6A3156D5", hash_generated_method = "D7F54852D6CD4A77CA3C84C4B5B9FBFB")
    
public String[] getReplyStrings()
    {
        String[] lines;
        lines = new String[_replyLines.size()];
        _replyLines.copyInto(lines);
        return lines;
    }

    /***
     * Returns the entire text of the last SMTP server response exactly
     * as it was received, including all end of line markers in NETASCII
     * format.
     * <p>
     * @return The entire text from the last SMTP response as a String.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.439 -0500", hash_original_method = "84E293B796CFF792E36C37EFD2119006", hash_generated_method = "7A2D3AD43224B53EF4FBD29D4B1D280A")
    
public String getReplyString()
    {
        Enumeration en;
        StringBuffer buffer;

        if (!_newReplyString)
            return _replyString;

        buffer = new StringBuffer(256);
        en = _replyLines.elements();
        while (en.hasMoreElements())
        {
            buffer.append((String)en.nextElement());
            buffer.append(SocketClient.NETASCII_EOL);
        }

        _newReplyString = false;

        return (_replyString = buffer.toString());
    }


    /***
     * A convenience method to send the SMTP HELO command to the server,
     * receive the reply, and return the reply code.
     * <p>
     * @param hostname The hostname of the sender.
     * @return The reply code received from the server.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.442 -0500", hash_original_method = "B5C1A087675A1945EC6C55F404B859EF", hash_generated_method = "C071A397866D02A93D1A81C8028C5A31")
    
public int helo(String hostname) throws IOException
    {
        return sendCommand(SMTPCommand.HELO, hostname);
    }


    /***
     * A convenience method to send the SMTP MAIL command to the server,
     * receive the reply, and return the reply code.
     * <p>
     * @param reversePath The reverese path.
     * @return The reply code received from the server.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.445 -0500", hash_original_method = "781B73A423F5607115D65A9F70C8C3FD", hash_generated_method = "D543F294199168290E6AF66EFEC94A0E")
    
public int mail(String reversePath) throws IOException
    {
        return __sendCommand(SMTPCommand.MAIL, reversePath, false);
    }


    /***
     * A convenience method to send the SMTP RCPT command to the server,
     * receive the reply, and return the reply code.
     * <p>
     * @param forwardPath The forward path.
     * @return The reply code received from the server.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.449 -0500", hash_original_method = "E09AC91BFF0716A1363050785841D6F7", hash_generated_method = "27D251DA038DA05A7DD877977877B001")
    
public int rcpt(String forwardPath) throws IOException
    {
        return __sendCommand(SMTPCommand.RCPT, forwardPath, false);
    }


    /***
     * A convenience method to send the SMTP DATA command to the server,
     * receive the reply, and return the reply code.
     * <p>
     * @return The reply code received from the server.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.452 -0500", hash_original_method = "748B8AADFB217AB8F29DF7ED1C81D966", hash_generated_method = "0B4E66181B796C9630F40375F7787CCF")
    
public int data() throws IOException
    {
        return sendCommand(SMTPCommand.DATA);
    }


    /***
     * A convenience method to send the SMTP SEND command to the server,
     * receive the reply, and return the reply code.
     * <p>
     * @param reversePath The reverese path.
     * @return The reply code received from the server.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.455 -0500", hash_original_method = "CE7958995206C16BABC830EC1527AD6A", hash_generated_method = "B0C6476C1A7AA9D02FCCF8389C3472A7")
    
public int send(String reversePath) throws IOException
    {
        return sendCommand(SMTPCommand.SEND, reversePath);
    }


    /***
     * A convenience method to send the SMTP SOML command to the server,
     * receive the reply, and return the reply code.
     * <p>
     * @param reversePath The reverese path.
     * @return The reply code received from the server.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.458 -0500", hash_original_method = "B0CD1CF37C47B6EE8CA9750CE89F4BC8", hash_generated_method = "3F9500F6CC498B34F0757D541AC9F0D3")
    
public int soml(String reversePath) throws IOException
    {
        return sendCommand(SMTPCommand.SOML, reversePath);
    }


    /***
     * A convenience method to send the SMTP SAML command to the server,
     * receive the reply, and return the reply code.
     * <p>
     * @param reversePath The reverese path.
     * @return The reply code received from the server.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.461 -0500", hash_original_method = "A5632C4BCBF4A04998C8AED30BFA7D34", hash_generated_method = "451AC0235001E13CBE31F28EA5F72ECF")
    
public int saml(String reversePath) throws IOException
    {
        return sendCommand(SMTPCommand.SAML, reversePath);
    }


    /***
     * A convenience method to send the SMTP RSET command to the server,
     * receive the reply, and return the reply code.
     * <p>
     * @return The reply code received from the server.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.464 -0500", hash_original_method = "96B070670DE0E95F8D3FF147ADCAC1FA", hash_generated_method = "962E9816683B153B9D737496AF7F2319")
    
public int rset() throws IOException
    {
        return sendCommand(SMTPCommand.RSET);
    }


    /***
     * A convenience method to send the SMTP VRFY command to the server,
     * receive the reply, and return the reply code.
     * <p>
     * @param user The user address to verify.
     * @return The reply code received from the server.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.467 -0500", hash_original_method = "48854BC79E0F6D799B73E2D315528F1E", hash_generated_method = "9F05A7A5E55780B46804AA35B3B91120")
    
public int vrfy(String user) throws IOException
    {
        return sendCommand(SMTPCommand.VRFY, user);
    }


    /***
     * A convenience method to send the SMTP VRFY command to the server,
     * receive the reply, and return the reply code.
     * <p>
     * @param name The name to expand.
     * @return The reply code received from the server.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.470 -0500", hash_original_method = "84333F22D2F662ECF0F56FB718F0C6D4", hash_generated_method = "FE929F51FF07516C02FFA30619A24C07")
    
public int expn(String name) throws IOException
    {
        return sendCommand(SMTPCommand.EXPN, name);
    }

    /***
     * A convenience method to send the SMTP HELP command to the server,
     * receive the reply, and return the reply code.
     * <p>
     * @return The reply code received from the server.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.473 -0500", hash_original_method = "5F8F6FBE2B483385DE74A4590AA58F82", hash_generated_method = "07562B0E23EB401F9C7EE26FB1759915")
    
public int help() throws IOException
    {
        return sendCommand(SMTPCommand.HELP);
    }

    /***
     * A convenience method to send the SMTP HELP command to the server,
     * receive the reply, and return the reply code.
     * <p>
     * @param command  The command name on which to request help.
     * @return The reply code received from the server.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.482 -0500", hash_original_method = "21F6FFA80D5638BBF9678A771ADCBC20", hash_generated_method = "2BA5CDC9C3181209875E5B305DDDE7F7")
    
public int help(String command) throws IOException
    {
        return sendCommand(SMTPCommand.HELP, command);
    }

    /***
     * A convenience method to send the SMTP NOOP command to the server,
     * receive the reply, and return the reply code.
     * <p>
     * @return The reply code received from the server.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.485 -0500", hash_original_method = "5F50FEB40340882AAF112F9FFE8E6AE2", hash_generated_method = "5E52CCE70CA2104CFA5F2279997090C2")
    
public int noop() throws IOException
    {
        return sendCommand(SMTPCommand.NOOP);
    }


    /***
     * A convenience method to send the SMTP TURN command to the server,
     * receive the reply, and return the reply code.
     * <p>
     * @return The reply code received from the server.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.488 -0500", hash_original_method = "8916849FEAA1058F51E2B631594FEB81", hash_generated_method = "CBEF0068B01DA9E71E94F4AC651103D9")
    
public int turn() throws IOException
    {
        return sendCommand(SMTPCommand.TURN);
    }


    /***
     * A convenience method to send the SMTP QUIT command to the server,
     * receive the reply, and return the reply code.
     * <p>
     * @return The reply code received from the server.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.491 -0500", hash_original_method = "802ED383C458692C5D5C796DB1F0E3E6", hash_generated_method = "4C99D9EF19B1B897A26ADFFD29AB2AD4")
    
public int quit() throws IOException
    {
        return sendCommand(SMTPCommand.QUIT);
    }

}

/* Emacs configuration
 * Local variables:        **
 * mode:             java  **
 * c-basic-offset:   4     **
 * indent-tabs-mode: nil   **
 * End:                    **
 */
