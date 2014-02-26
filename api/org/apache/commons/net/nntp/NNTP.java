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
package org.apache.commons.net.nntp;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import org.apache.commons.net.MalformedServerReplyException;
import org.apache.commons.net.ProtocolCommandSupport;
import org.apache.commons.net.ProtocolCommandListener;
import org.apache.commons.net.SocketClient;

/***
 * The NNTP class is not meant to be used by itself and is provided
 * only so that you may easily implement your own NNTP client if
 * you so desire.  If you have no need to perform your own implementation,
 * you should use {@link org.apache.commons.net.nntp.NNTPClient}.
 * The NNTP class is made public to provide access to various NNTP constants
 * and to make it easier for adventurous programmers (or those with special
 * needs) to interact with the NNTP protocol and implement their own clients.
 * A set of methods with names corresponding to the NNTP command names are
 * provided to facilitate this interaction.
 * <p>
 * You should keep in mind that the NNTP server may choose to prematurely
 * close a connection if the client has been idle for longer than a
 * given time period or if the server is being shutdown by the operator or
 * some other reason.  The NNTP class will detect a
 * premature NNTP server connection closing when it receives a
 * {@link org.apache.commons.net.nntp.NNTPReply#SERVICE_DISCONTINUED NNTPReply.SERVICE_DISCONTINUED }
 *  response to a command.
 * When that occurs, the NNTP class method encountering that reply will throw
 * an {@link org.apache.commons.net.nntp.NNTPConnectionClosedException}
 * .
 * <code>NNTPConectionClosedException</code>
 * is a subclass of <code> IOException </code> and therefore need not be
 * caught separately, but if you are going to catch it separately, its
 * catch block must appear before the more general <code> IOException </code>
 * catch block.  When you encounter an
 * {@link org.apache.commons.net.nntp.NNTPConnectionClosedException}
 * , you must disconnect the connection with
 * {@link #disconnect  disconnect() } to properly clean up the
 * system resources used by NNTP.  Before disconnecting, you may check the
 * last reply code and text with
 * {@link #getReplyCode  getReplyCode } and
 * {@link #getReplyString  getReplyString }.
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
 * @author Rory Winston
 * @author Ted Wise
 * @see NNTPClient
 * @see NNTPConnectionClosedException
 * @see org.apache.commons.net.MalformedServerReplyException
 ***/

public class NNTP extends SocketClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.035 -0500", hash_original_field = "5BCCCD760825427370146629BCE30716", hash_generated_field = "8106B4E881C47C85278A41F4A9316D29")

    public static final int DEFAULT_PORT = 119;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.039 -0500", hash_original_field = "ED28C05F169DA0DE12EEA2F104BE3971", hash_generated_field = "42B1008CD8EE34AD3B14B05D542AC1CB")

    // but we use ISO-8859-1 just in case 8-bit characters cross
    // the wire.
    private static final String __DEFAULT_ENCODING = "ISO-8859-1";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.042 -0500", hash_original_field = "5851BF2FEF5A8535EAD5AA9837C9C499", hash_generated_field = "B44FD5DD0C96DE651EF02982D44EF837")


    private StringBuffer __commandBuffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.044 -0500", hash_original_field = "DB5F342E07F2229507AC31C58B3E5E99", hash_generated_field = "DB5F342E07F2229507AC31C58B3E5E99")


    boolean _isAllowedToPost;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.053 -0500", hash_original_field = "96C814136BEA461ACBAD7291EA9D0AEA", hash_generated_field = "96C814136BEA461ACBAD7291EA9D0AEA")

    int _replyCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.058 -0500", hash_original_field = "9D4E6ACED62C1C9F619D254C9BB4714F", hash_generated_field = "9D4E6ACED62C1C9F619D254C9BB4714F")

    String _replyString;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.063 -0500", hash_original_field = "AC1DB066DE9C78122B127FD6B19384FA", hash_generated_field = "CE60FF1574CD28F2A8DCD107DB45E73A")

    protected BufferedReader _reader_;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.069 -0500", hash_original_field = "8F5BE6FE55386A7A9EB7D67B32E8A383", hash_generated_field = "229A21EF2386319BCD5DF8A99C17375A")

    protected BufferedWriter _writer_;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.073 -0500", hash_original_field = "7DAF899D0A7A2C717C865E5E7E08CC52", hash_generated_field = "953ACDAC0C44CE1C293FA84B06DBBA20")

    protected ProtocolCommandSupport _commandSupport_;

    /***
     * The default NNTP constructor.  Sets the default port to
     * <code>DEFAULT_PORT</code> and initializes internal data structures
     * for saving NNTP reply information.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.076 -0500", hash_original_method = "E2C53E6840825B1D96699D1CA06CCBF1", hash_generated_method = "4C1308095C5465ED842A718296CD85B8")
    
public NNTP()
    {
        setDefaultPort(DEFAULT_PORT);
        __commandBuffer = new StringBuffer();
        _replyString = null;
        _reader_ = null;
        _writer_ = null;
        _isAllowedToPost = false;
        _commandSupport_ = new ProtocolCommandSupport(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.080 -0500", hash_original_method = "10E8C83F1466A6E5BFED7756B7D62D18", hash_generated_method = "3CD1CAC6A92911A1CF79C3CCDC24CE8C")
    
private void __getReply() throws IOException
    {
        _replyString = _reader_.readLine();

        if (_replyString == null)
            throw new NNTPConnectionClosedException(
                "Connection closed without indication.");

        // In case we run into an anomaly we don't want fatal index exceptions
        // to be thrown.
        if (_replyString.length() < 3)
            throw new MalformedServerReplyException(
                "Truncated server reply: " + _replyString);
        try
        {
            _replyCode = Integer.parseInt(_replyString.substring(0, 3));
        }
        catch (NumberFormatException e)
        {
            throw new MalformedServerReplyException(
                "Could not parse response code.\nServer Reply: " + _replyString);
        }

        if (_commandSupport_.getListenerCount() > 0)
            _commandSupport_.fireReplyReceived(_replyCode, _replyString +
                                               SocketClient.NETASCII_EOL);

        if (_replyCode == NNTPReply.SERVICE_DISCONTINUED)
            throw new NNTPConnectionClosedException(
                "NNTP response 400 received.  Server closed connection.");
    }

    /***
     * Initiates control connections and gets initial reply, determining
     * if the client is allowed to post to the server.  Initializes
     * {@link #_reader_} and {@link #_writer_} to wrap
     * {@link SocketClient#_input_} and {@link SocketClient#_output_}.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.084 -0500", hash_original_method = "FEA8121B14E9431F591A5C5AD7E13B49", hash_generated_method = "6286B71C0F9B133B3FD693882FE23823")
    
protected void _connectAction_() throws IOException
    {
        super._connectAction_();
        _reader_ =
            new BufferedReader(new InputStreamReader(_input_,
                                                     __DEFAULT_ENCODING));
        _writer_ =
            new BufferedWriter(new OutputStreamWriter(_output_,
                                                      __DEFAULT_ENCODING));
        __getReply();

        _isAllowedToPost = (_replyCode == NNTPReply.SERVER_READY_POSTING_ALLOWED);
    }

    /***
     * Adds a ProtocolCommandListener.  Delegates this task to
     * {@link #_commandSupport_  _commandSupport_ }.
     * <p>
     * @param listener  The ProtocolCommandListener to add.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.089 -0500", hash_original_method = "B2E7C8147EAF016E25D01B4A081623E2", hash_generated_method = "EBB19817C4DDE4A3C65E2B3B1F18E706")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.093 -0500", hash_original_method = "0DDC9924ED0A7D85ED50DAEB7FDEFC10", hash_generated_method = "84BEE9758E6B310B9D409F314E9D1F9A")
    
public void removeProtocolCommandListener(ProtocolCommandListener listener)
    {
        _commandSupport_.removeProtocolCommandListener(listener);
    }

    /***
     * Closes the connection to the NNTP server and sets to null
     * some internal data so that the memory may be reclaimed by the
     * garbage collector.  The reply text and code information from the
     * last command is voided so that the memory it used may be reclaimed.
     * <p>
     * @exception IOException If an error occurs while disconnecting.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.099 -0500", hash_original_method = "A088283C6D3AFB361E7B10D0999AC3A3", hash_generated_method = "7C560D97AD8C6B301BF770F86C880C01")
    
public void disconnect() throws IOException
    {
        super.disconnect();
        _reader_ = null;
        _writer_ = null;
        _replyString = null;
        _isAllowedToPost = false;
    }


    /***
     * Indicates whether or not the client is allowed to post articles to
     * the server it is currently connected to.
     * <p>
     * @return True if the client can post articles to the server, false
     *         otherwise.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.109 -0500", hash_original_method = "F1B4050DCF6D9F3D2D0F698BE22004BE", hash_generated_method = "C879F2867123FDC5490F8DC8EF0601C4")
    
public boolean isAllowedToPost()
    {
        return _isAllowedToPost;
    }


    /***
     * Sends an NNTP command to the server, waits for a reply and returns the
     * numerical response code.  After invocation, for more detailed
     * information, the actual reply text can be accessed by calling
     * {@link #getReplyString  getReplyString }.
     * <p>
     * @param command  The text representation of the  NNTP command to send.
     * @param args The arguments to the NNTP command.  If this parameter is
     *             set to null, then the command is sent with no argument.
     * @return The integer value of the NNTP reply code returned by the server
     *         in response to the command.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.113 -0500", hash_original_method = "7022D22854CA5FB79CE574BD00865118", hash_generated_method = "953B3A25B4E9159B7DA246272AFCC3E8")
    
public int sendCommand(String command, String args) throws IOException
    {
        String message;

        __commandBuffer.setLength(0);
        __commandBuffer.append(command);

        if (args != null)
        {
            __commandBuffer.append(' ');
            __commandBuffer.append(args);
        }
        __commandBuffer.append(SocketClient.NETASCII_EOL);

        _writer_.write(message = __commandBuffer.toString());
        _writer_.flush();

        if (_commandSupport_.getListenerCount() > 0)
            _commandSupport_.fireCommandSent(command, message);

        __getReply();
        return _replyCode;
    }


    /***
     * Sends an NNTP command to the server, waits for a reply and returns the
     * numerical response code.  After invocation, for more detailed
     * information, the actual reply text can be accessed by calling
     * {@link #getReplyString  getReplyString }.
     * <p>
     * @param command  The NNTPCommand constant corresponding to the NNTP command
     *                 to send.
     * @param args The arguments to the NNTP command.  If this parameter is
     *             set to null, then the command is sent with no argument.
     * @return The integer value of the NNTP reply code returned by the server
     *         in response to the command.
     *         in response to the command.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.116 -0500", hash_original_method = "2E6DE9B46EB9F77C314E2D636FE8BDFD", hash_generated_method = "F91838C63E9469ACDFA2034F6846019A")
    
public int sendCommand(int command, String args) throws IOException
    {
        return sendCommand(NNTPCommand._commands[command], args);
    }


    /***
     * Sends an NNTP command with no arguments to the server, waits for a
     * reply and returns the numerical response code.  After invocation, for
     * more detailed information, the actual reply text can be accessed by
     * calling {@link #getReplyString  getReplyString }.
     * <p>
     * @param command  The text representation of the  NNTP command to send.
     * @return The integer value of the NNTP reply code returned by the server
     *         in response to the command.
     *         in response to the command.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.119 -0500", hash_original_method = "249D1EA65C901278A4D9A21CA58581D8", hash_generated_method = "319B33627FD404284CF2FADC01D735DC")
    
public int sendCommand(String command) throws IOException
    {
        return sendCommand(command, null);
    }


    /***
     * Sends an NNTP command with no arguments to the server, waits for a
     * reply and returns the numerical response code.  After invocation, for
     * more detailed information, the actual reply text can be accessed by
     * calling {@link #getReplyString  getReplyString }.
     * <p>
     * @param command  The NNTPCommand constant corresponding to the NNTP command
     *                 to send.
     * @return The integer value of the NNTP reply code returned by the server
     *         in response to the command.
     *         in response to the command.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.123 -0500", hash_original_method = "1F8849508E07E274C5D8FC641A8F26DF", hash_generated_method = "9641A9247D5EAF7473C640D4A279E4DE")
    
public int sendCommand(int command) throws IOException
    {
        return sendCommand(command, null);
    }


    /***
     * Returns the integer value of the reply code of the last NNTP reply.
     * You will usually only use this method after you connect to the
     * NNTP server to check that the connection was successful since
     * <code> connect </code> is of type void.
     * <p>
     * @return The integer value of the reply code of the last NNTP reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.126 -0500", hash_original_method = "C50A2128BE09AED79AF9E811C678D377", hash_generated_method = "B9B64ED2E5BE5B2AD33B35CE05FA014A")
    
public int getReplyCode()
    {
        return _replyCode;
    }

    /***
     * Fetches a reply from the NNTP server and returns the integer reply
     * code.  After calling this method, the actual reply text can be accessed
     * from {@link #getReplyString  getReplyString }.  Only use this
     * method if you are implementing your own NNTP client or if you need to
     * fetch a secondary response from the NNTP server.
     * <p>
     * @return The integer value of the reply code of the fetched NNTP reply.
     *         in response to the command.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while
     *      receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.129 -0500", hash_original_method = "7A68383686F9416248FE3E530FCEE8A5", hash_generated_method = "575287EC1D25B9CB6A334BD3212BBDC7")
    
public int getReply() throws IOException
    {
        __getReply();
        return _replyCode;
    }


    /***
     * Returns the entire text of the last NNTP server response exactly
     * as it was received, not including the end of line marker.
     * <p>
     * @return The entire text from the last NNTP response as a String.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.132 -0500", hash_original_method = "20A487CFD8412198CF7270FBE03F83C5", hash_generated_method = "50D799EE2BAF049B2E01CFCE6989004D")
    
public String getReplyString()
    {
        return _replyString;
    }


    /***
     * A convenience method to send the NNTP ARTICLE command to the server,
     * receive the initial reply, and return the reply code.
     * <p>
     * @param messageId  The message identifier of the requested article,
     *                   including the encapsulating &lt and &gt characters.
     * @return The reply code received from the server.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.135 -0500", hash_original_method = "6E29908C529CE7846C11452C201BBB62", hash_generated_method = "F651796C95C96FF9EA55C810F6C889F8")
    
public int article(String messageId) throws IOException
    {
        return sendCommand(NNTPCommand.ARTICLE, messageId);
    }

    /***
     * A convenience method to send the NNTP ARTICLE command to the server,
     * receive the initial reply, and return the reply code.
     * <p>
     * @param articleNumber The number of the article to request from the
     *                      currently selected newsgroup.
     * @return The reply code received from the server.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.139 -0500", hash_original_method = "06E8E6E37E1424A31870FF0EF434E6CA", hash_generated_method = "A187188A20C0BEBD74FA62089DD62DE5")
    
public int article(int articleNumber) throws IOException
    {
        return sendCommand(NNTPCommand.ARTICLE, Integer.toString(articleNumber));
    }

    /***
     * A convenience method to send the NNTP ARTICLE command to the server,
     * receive the initial reply, and return the reply code.
     * <p>
     * @return The reply code received from the server.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.142 -0500", hash_original_method = "D9D80F00CDC581AABA98D597BEF7F07B", hash_generated_method = "D545C6CD7078B9627401CC616CC84A69")
    
public int article() throws IOException
    {
        return sendCommand(NNTPCommand.ARTICLE);
    }



    /***
     * A convenience method to send the NNTP BODY command to the server,
     * receive the initial reply, and return the reply code.
     * <p>
     * @param messageId  The message identifier of the requested article,
     *                   including the encapsulating &lt and &gt characters.
     * @return The reply code received from the server.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.153 -0500", hash_original_method = "52B4DCA52CE9008BF4F1F47D8B6558D0", hash_generated_method = "A1DE28B462D206CC85DA36A53CF4B23D")
    
public int body(String messageId) throws IOException
    {
        return sendCommand(NNTPCommand.BODY, messageId);
    }

    /***
     * A convenience method to send the NNTP BODY command to the server,
     * receive the initial reply, and return the reply code.
     * <p>
     * @param articleNumber The number of the article to request from the
     *                      currently selected newsgroup.
     * @return The reply code received from the server.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.156 -0500", hash_original_method = "16FAB9FE80C49A02BC9E8853407FE291", hash_generated_method = "CA2795845E2D065877529BFE6EAB4FB6")
    
public int body(int articleNumber) throws IOException
    {
        return sendCommand(NNTPCommand.BODY, Integer.toString(articleNumber));
    }

    /***
     * A convenience method to send the NNTP BODY command to the server,
     * receive the initial reply, and return the reply code.
     * <p>
     * @return The reply code received from the server.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.159 -0500", hash_original_method = "09284C64390035CEB1B433477B1727B8", hash_generated_method = "29439BBC7FF3EEC432E9D8F6CACF936F")
    
public int body() throws IOException
    {
        return sendCommand(NNTPCommand.BODY);
    }



    /***
     * A convenience method to send the NNTP HEAD command to the server,
     * receive the initial reply, and return the reply code.
     * <p>
     * @param messageId  The message identifier of the requested article,
     *                   including the encapsulating &lt and &gt characters.
     * @return The reply code received from the server.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.162 -0500", hash_original_method = "44504C706271339AD014839381D77404", hash_generated_method = "96E3A48A00ECE1E3524E121E7772B36A")
    
public int head(String messageId) throws IOException
    {
        return sendCommand(NNTPCommand.HEAD, messageId);
    }

    /***
     * A convenience method to send the NNTP HEAD command to the server,
     * receive the initial reply, and return the reply code.
     * <p>
     * @param articleNumber The number of the article to request from the
     *                      currently selected newsgroup.
     * @return The reply code received from the server.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.166 -0500", hash_original_method = "FDD1437D28F7C23540C204D06460844B", hash_generated_method = "ED7508CB6BB22ED3E257048449A4E56D")
    
public int head(int articleNumber) throws IOException
    {
        return sendCommand(NNTPCommand.HEAD, Integer.toString(articleNumber));
    }

    /***
     * A convenience method to send the NNTP HEAD command to the server,
     * receive the initial reply, and return the reply code.
     * <p>
     * @return The reply code received from the server.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.171 -0500", hash_original_method = "E5144E6A37A93F7F98A78F4E9AEFF229", hash_generated_method = "BDE1DC750BBB940FD57874A67E1B34A2")
    
public int head() throws IOException
    {
        return sendCommand(NNTPCommand.HEAD);
    }



    /***
     * A convenience method to send the NNTP STAT command to the server,
     * receive the initial reply, and return the reply code.
     * <p>
     * @param messageId  The message identifier of the requested article,
     *                   including the encapsulating &lt and &gt characters.
     * @return The reply code received from the server.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.176 -0500", hash_original_method = "F334246A42A35DCD33E898B66500F960", hash_generated_method = "8C3482C65DAFD6353C1FE0C003DBDD4F")
    
public int stat(String messageId) throws IOException
    {
        return sendCommand(NNTPCommand.STAT, messageId);
    }

    /***
     * A convenience method to send the NNTP STAT command to the server,
     * receive the initial reply, and return the reply code.
     * <p>
     * @param articleNumber The number of the article to request from the
     *                      currently selected newsgroup.
     * @return The reply code received from the server.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.182 -0500", hash_original_method = "CAD829645188BB4FEA744BF7331A1E52", hash_generated_method = "1222D259807353680677815467D7A3EB")
    
public int stat(int articleNumber) throws IOException
    {
        return sendCommand(NNTPCommand.STAT, Integer.toString(articleNumber));
    }

    /***
     * A convenience method to send the NNTP STAT command to the server,
     * receive the initial reply, and return the reply code.
     * <p>
     * @return The reply code received from the server.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.187 -0500", hash_original_method = "468AD85F0115764703DC30A2A08F954C", hash_generated_method = "8D78EAE151F9C4FB3184ACDDBA16806B")
    
public int stat() throws IOException
    {
        return sendCommand(NNTPCommand.STAT);
    }


    /***
     * A convenience method to send the NNTP GROUP command to the server,
     * receive the reply, and return the reply code.
     * <p>
     * @param newsgroup  The name of the newsgroup to select.
     * @return The reply code received from the server.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.193 -0500", hash_original_method = "CE987E2D0639A8371474E03A1BAB7064", hash_generated_method = "5AC65724670398C7D1047F737CC67B1A")
    
public int group(String newsgroup) throws IOException
    {
        return sendCommand(NNTPCommand.GROUP, newsgroup);
    }


    /***
     * A convenience method to send the NNTP HELP command to the server,
     * receive the reply, and return the reply code.
     * <p>
     * @return The reply code received from the server.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.198 -0500", hash_original_method = "0248E7E94C5A5A48B7EBA8F2086A381D", hash_generated_method = "EB7A281BBFE230BF86988ABBE326F73F")
    
public int help() throws IOException
    {
        return sendCommand(NNTPCommand.HELP);
    }


    /***
     * A convenience method to send the NNTP IHAVE command to the server,
     * receive the reply, and return the reply code.
     * <p>
     * @param messageId  The article identifier,
     *                   including the encapsulating &lt and &gt characters.
     * @return The reply code received from the server.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.208 -0500", hash_original_method = "F1D77F14200D8548E55B8DF05D044075", hash_generated_method = "A02B1FF6DA8EFFD2C9A0C13AD6D4AE31")
    
public int ihave(String messageId) throws IOException
    {
        return sendCommand(NNTPCommand.IHAVE, messageId);
    }


    /***
     * A convenience method to send the NNTP LAST command to the server,
     * receive the reply, and return the reply code.
     * <p>
     * @return The reply code received from the server.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.212 -0500", hash_original_method = "404BC9553FFFEEA26AF30C1D66ABC6E6", hash_generated_method = "B346B76AFB087F19C7116B39D101597A")
    
public int last() throws IOException
    {
        return sendCommand(NNTPCommand.LAST);
    }



    /***
     * A convenience method to send the NNTP LIST command to the server,
     * receive the reply, and return the reply code.
     * <p>
     * @return The reply code received from the server.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.218 -0500", hash_original_method = "2F2F1BA624E724086EA8751BBE476886", hash_generated_method = "6F28E74B1693B6D6F91A43F6A0ADB6DB")
    
public int list() throws IOException
    {
        return sendCommand(NNTPCommand.LIST);
    }



    /***
     * A convenience method to send the NNTP NEXT command to the server,
     * receive the reply, and return the reply code.
     * <p>
     * @return The reply code received from the server.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.223 -0500", hash_original_method = "C6B5BA4CC388DC52CEEC1238FEC9126F", hash_generated_method = "8D8204CB3AA50F3A530CD193887F06BD")
    
public int next() throws IOException
    {
        return sendCommand(NNTPCommand.NEXT);
    }


    /***
     * A convenience method to send the NNTP NEWGROUPS command to the server,
     * receive the reply, and return the reply code.
     * <p>
     * @param date The date after which to check for new groups.
     *             Date format is YYMMDD
     * @param time The time after which to check for new groups.
     *             Time format is HHMMSS using a 24-hour clock.
     * @param GMT  True if the time is in GMT, false if local server time.
     * @param distributions  Comma-separated distribution list to check for
     *            new groups. Set to null if no distributions.
     * @return The reply code received from the server.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.229 -0500", hash_original_method = "A4C771CAD3F4C9A57E73CCEAED0A04B5", hash_generated_method = "E5700C27A853EC6F51A5150DA453A47A")
    
public int newgroups(String date, String time, boolean GMT,
                         String distributions) throws IOException
    {
        StringBuffer buffer = new StringBuffer();

        buffer.append(date);
        buffer.append(' ');
        buffer.append(time);

        if (GMT)
        {
            buffer.append(' ');
            buffer.append("GMT");
        }

        if (distributions != null)
        {
            buffer.append(" <");
            buffer.append(distributions);
            buffer.append('>');
        }

        return sendCommand(NNTPCommand.NEWGROUPS, buffer.toString());
    }


    /***
     * A convenience method to send the NNTP NEWGROUPS command to the server,
     * receive the reply, and return the reply code.
     * <p>
     * @param newsgroups A comma-separated list of newsgroups to check for new
     *             news.
     * @param date The date after which to check for new news.
     *             Date format is YYMMDD
     * @param time The time after which to check for new news.
     *             Time format is HHMMSS using a 24-hour clock.
     * @param GMT  True if the time is in GMT, false if local server time.
     * @param distributions  Comma-separated distribution list to check for
     *            new news. Set to null if no distributions.
     * @return The reply code received from the server.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.236 -0500", hash_original_method = "BAF7872943A1F8791CEEBC9105F880C8", hash_generated_method = "42D520F55A1621DC903635DDE7B5BD96")
    
public int newnews(String newsgroups, String date, String time, boolean GMT,
                       String distributions) throws IOException
    {
        StringBuffer buffer = new StringBuffer();

        buffer.append(newsgroups);
        buffer.append(' ');
        buffer.append(date);
        buffer.append(' ');
        buffer.append(time);

        if (GMT)
        {
            buffer.append(' ');
            buffer.append("GMT");
        }

        if (distributions != null)
        {
            buffer.append(" <");
            buffer.append(distributions);
            buffer.append('>');
        }

        return sendCommand(NNTPCommand.NEWNEWS, buffer.toString());
    }



    /***
     * A convenience method to send the NNTP POST command to the server,
     * receive the reply, and return the reply code.
     * <p>
     * @return The reply code received from the server.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.242 -0500", hash_original_method = "FC9B2FFC2AD9C6287BD39CB5A78927E8", hash_generated_method = "D7F9551F49AEBA4E3ABDA359F2D05069")
    
public int post() throws IOException
    {
        return sendCommand(NNTPCommand.POST);
    }



    /***
     * A convenience method to send the NNTP QUIT command to the server,
     * receive the reply, and return the reply code.
     * <p>
     * @return The reply code received from the server.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.247 -0500", hash_original_method = "D4FB68F07E4D4A1CE75ADE48CA6C5624", hash_generated_method = "9A273D6D003A30C8B244DF86CFA794BD")
    
public int quit() throws IOException
    {
        return sendCommand(NNTPCommand.QUIT);
    }

    /***
     * A convenience method to send the AUTHINFO USER command to the server,
     *  receive the reply, and return the reply code. (See RFC 2980)
     * <p>
     * @param username A valid username.
     * @return The reply code received from the server. The server should
     *          return a 381 or 281 for this command.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.254 -0500", hash_original_method = "6EDDB7210B9771B4B6C2F63871114167", hash_generated_method = "EBF0668C91DEC83061D2B5D5D4A3B069")
    
public int authinfoUser(String username) throws IOException {
        String userParameter = "USER " + username;
        return sendCommand(NNTPCommand.AUTHINFO, userParameter);
    }

    /***
     * A convenience method to send the AUTHINFO PASS command to the server,
     * receive the reply, and return the reply code.  If this step is
     * required, it should immediately follow the AUTHINFO USER command
     * (See RFC 2980)
     * <p>
     * @param password a valid password.
     * @return The reply code received from the server. The server should
     *         return a 281 or 502 for this command.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.266 -0500", hash_original_method = "75AFFF60DFA2C9C15D3AF4D3BD061EC1", hash_generated_method = "D11DB6FF2F14EF5444C1CA7E0827F3A0")
    
public int authinfoPass(String password) throws IOException {
        String passParameter = "PASS " + password;
        return sendCommand(NNTPCommand.AUTHINFO, passParameter);
    }

    /***
     * A convenience method to send the NNTP XOVER command to the server,
     * receive the reply, and return the reply code.
     * <p>
     * @param selectedArticles a String representation of the range of
     * article headers required. This may be an article number, or a
     * range of article numbers in the form "XXXX-YYYY", where XXXX
     * and YYYY are valid article numbers in the current group.  It
     * also may be of the form "XXX-", meaning "return XXX and all
     * following articles" In this revision, the last format is not
     * possible (yet).
     * @return The reply code received from the server.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.269 -0500", hash_original_method = "B0F3668F9CFF50FB0E1B8840DEF22F88", hash_generated_method = "A37C9DEE94735CBF30339456FDC1F2B0")
    
public int xover(String selectedArticles) throws IOException {
        return sendCommand(NNTPCommand.XOVER, selectedArticles);
    }

    /***
     * A convenience method to send the NNTP XHDR command to the server,
     * receive the reply, and return the reply code.
     * <p>
     * @param header a String naming a header line (e.g., "subject").  See
     * RFC-1036 for a list of valid header lines.
     * @param selectedArticles a String representation of the range of
     * article headers required. This may be an article number, or a
     * range of article numbers in the form "XXXX-YYYY", where XXXX
     * and YYYY are valid article numbers in the current group.  It
     * also may be of the form "XXX-", meaning "return XXX and all
     * following articles" In this revision, the last format is not
     * possible (yet).
     * @return The reply code received from the server.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending the
     *      command or receiving the server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.274 -0500", hash_original_method = "8091A4366A2C1A9998C238D888E06938", hash_generated_method = "4BC82F2C31D9CDDD779B641B9867A61F")
    
public int xhdr(String header, String selectedArticles) throws IOException {
        StringBuffer command = new StringBuffer(header);
        command.append(" ");
        command.append(selectedArticles);
        return sendCommand(NNTPCommand.XHDR, command.toString());
    }

    /**
     * A convenience wrapper for the extended LIST command that takes
     * an argument, allowing us to selectively list multiple groups.
     * <p>
     * @param wildmat A wildmat (pseudo-regex) pattern. See RFC 2980 for
     *                details.
     * @return the reply code received from the server.
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:09.277 -0500", hash_original_method = "0E38673D7594A06D68DC2F60022760C9", hash_generated_method = "08A4B710C95B83BF1C567F0FE2B1A1BB")
    
public int listActive(String wildmat) throws IOException {
        StringBuffer command = new StringBuffer("ACTIVE ");
        command.append(wildmat);
        return sendCommand(NNTPCommand.LIST, command.toString());
    }
}

/* Emacs configuration
 * Local variables:        **
 * mode:             java  **
 * c-basic-offset:   4     **
 * indent-tabs-mode: nil   **
 * End:                    **
 */
