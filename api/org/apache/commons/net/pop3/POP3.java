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
package org.apache.commons.net.pop3;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.StringBuffer;
import java.util.Enumeration;
import java.util.Vector;
import org.apache.commons.net.MalformedServerReplyException;
import org.apache.commons.net.ProtocolCommandListener;
import org.apache.commons.net.ProtocolCommandSupport;
import org.apache.commons.net.SocketClient;

/***
 * The POP3 class is not meant to be used by itself and is provided
 * only so that you may easily implement your own POP3 client if
 * you so desire.  If you have no need to perform your own implementation,
 * you should use {@link org.apache.commons.net.pop3.POP3Client}.
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
 * @see POP3Client
 * @see org.apache.commons.net.MalformedServerReplyException
 ***/

public class POP3 extends SocketClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.299 -0500", hash_original_field = "312D5F2AC0E641BACCBE359B23C6DB41", hash_generated_field = "7314D6A9CD369C36105C2EBF07CF6C02")

    public static final int DEFAULT_PORT = 110;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.307 -0500", hash_original_field = "C24BA7876929D02F7D091C9F62F55314", hash_generated_field = "56600FAAE1E8EFA289577151E1E6AFA5")

    public static final int DISCONNECTED_STATE = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.313 -0500", hash_original_field = "09E718BB45EA6996F1BA3FEF33082706", hash_generated_field = "523A0F3F3FC0B9C2C15CE3BD8074A1E6")

    public static final int AUTHORIZATION_STATE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.318 -0500", hash_original_field = "824B5FFBEF9F23FEFDC9E33F5B73E07B", hash_generated_field = "8400712B484A52A68A1754A8C8946A74")

    public static final int TRANSACTION_STATE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.325 -0500", hash_original_field = "0D780C5AA6A5ED8DF17E93CCEB892858", hash_generated_field = "8584BCECF9CBB484AC181202D051444A")

    public static final int UPDATE_STATE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.330 -0500", hash_original_field = "BDC43B603C01DB64CD6AD2EF3B64594A", hash_generated_field = "926FC06D70C35C9CB87E38B312D1DE43")


    static final String _OK = "+OK";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.336 -0500", hash_original_field = "8C7BFC19212229D47BCE8A67EFDE5065", hash_generated_field = "EEC2676B7ACFF8858936950004E41122")

    static final String _ERROR = "-ERR";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.341 -0500", hash_original_field = "ED28C05F169DA0DE12EEA2F104BE3971", hash_generated_field = "42B1008CD8EE34AD3B14B05D542AC1CB")

    // but we use ISO-8859-1 just in case 8-bit characters cross
    // the wire.
    private static final String __DEFAULT_ENCODING = "ISO-8859-1";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.347 -0500", hash_original_field = "F31B83C0C1D64B53F76F652AE8321C6D", hash_generated_field = "83E8DA05654F510CBF3B6C73540D31DF")


    private int __popState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.353 -0500", hash_original_field = "E52EBB0C4508DF2885AE07F230BD875D", hash_generated_field = "DDAD9EDD5F48B40E721C2DB7E079A4EF")

    private BufferedWriter __writer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.357 -0500", hash_original_field = "5851BF2FEF5A8535EAD5AA9837C9C499", hash_generated_field = "B44FD5DD0C96DE651EF02982D44EF837")

    private StringBuffer __commandBuffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.361 -0500", hash_original_field = "3B06A6A58FD8BA55C2BC8C2DF80650D4", hash_generated_field = "3B06A6A58FD8BA55C2BC8C2DF80650D4")


    BufferedReader _reader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.367 -0500", hash_original_field = "96C814136BEA461ACBAD7291EA9D0AEA", hash_generated_field = "96C814136BEA461ACBAD7291EA9D0AEA")

    int _replyCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.410 -0500", hash_original_field = "EF812FABCB72F01F38EA3E2A461341D3", hash_generated_field = "EF812FABCB72F01F38EA3E2A461341D3")

    String _lastReplyLine;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.415 -0500", hash_original_field = "23C4AF34777206128B89D0EB51F39B80", hash_generated_field = "23C4AF34777206128B89D0EB51F39B80")

    Vector _replyLines;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.420 -0500", hash_original_field = "7DAF899D0A7A2C717C865E5E7E08CC52", hash_generated_field = "953ACDAC0C44CE1C293FA84B06DBBA20")

    protected ProtocolCommandSupport _commandSupport_;

    /***
     * The default POP3Client constructor.  Initializes the state
     * to <code>DISCONNECTED_STATE</code>.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.427 -0500", hash_original_method = "0575B8C0B33C637AFCCDE968DE34C861", hash_generated_method = "1AFA5203D9326303873EF80924E6276B")
    
public POP3()
    {
        setDefaultPort(DEFAULT_PORT);
        __commandBuffer = new StringBuffer();
        __popState = DISCONNECTED_STATE;
        _reader = null;
        __writer = null;
        _replyLines = new Vector();
        _commandSupport_ = new ProtocolCommandSupport(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.433 -0500", hash_original_method = "D633F8583A1BD47A1B8AE6BB7D90C194", hash_generated_method = "83DA41988CA1558C0E237B16BB055447")
    
private void __getReply() throws IOException
    {
        String line;

        _replyLines.setSize(0);
        line = _reader.readLine();

        if (line == null)
            throw new EOFException("Connection closed without indication.");

        if (line.startsWith(_OK))
            _replyCode = POP3Reply.OK;
        else if (line.startsWith(_ERROR))
            _replyCode = POP3Reply.ERROR;
        else
            throw new
            MalformedServerReplyException(
                "Received invalid POP3 protocol response from server.");

        _replyLines.addElement(line);
        _lastReplyLine = line;

        if (_commandSupport_.getListenerCount() > 0)
            _commandSupport_.fireReplyReceived(_replyCode, getReplyString());
    }


    /***
     * Performs connection initialization and sets state to
     * <code> AUTHORIZATION_STATE </code>.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.438 -0500", hash_original_method = "B58A648696301FB54C97CC1043045CA2", hash_generated_method = "527ED651A3F1B697DF725283544E2845")
    
protected void _connectAction_() throws IOException
    {
        super._connectAction_();
        _reader =
          new BufferedReader(new InputStreamReader(_input_,
                                                   __DEFAULT_ENCODING));
        __writer =
          new BufferedWriter(new OutputStreamWriter(_output_,
                                                    __DEFAULT_ENCODING));
        __getReply();
        setState(AUTHORIZATION_STATE);
    }


    /***
     * Adds a ProtocolCommandListener.  Delegates this task to
     * {@link #_commandSupport_  _commandSupport_ }.
     * <p>
     * @param listener  The ProtocolCommandListener to add.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.443 -0500", hash_original_method = "B2E7C8147EAF016E25D01B4A081623E2", hash_generated_method = "EBB19817C4DDE4A3C65E2B3B1F18E706")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.450 -0500", hash_original_method = "17C790A63BE2E925F1B089C57BEDE92F", hash_generated_method = "61530F256429087D025AC2A72509A95D")
    
public void removeProtocolCommandistener(ProtocolCommandListener listener)
    {
        _commandSupport_.removeProtocolCommandListener(listener);
    }


    /***
     * Sets POP3 client state.  This must be one of the
     * <code>_STATE</code> constants.
     * <p>
     * @param state  The new state.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.459 -0500", hash_original_method = "B3304DE629E55567ACEF27F042671D00", hash_generated_method = "2E445A1559547A141FEB16C2CBECDFB1")
    
public void setState(int state)
    {
        __popState = state;
    }


    /***
     * Returns the current POP3 client state.
     * <p>
     * @return The current POP3 client state.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.462 -0500", hash_original_method = "0CB53782D2D13091B7CA4F657BAAAB03", hash_generated_method = "3C120C291BF576907094D4E6DE818660")
    
public int getState()
    {
        return __popState;
    }


    /***
     * Retrieves the additional lines of a multi-line server reply.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.465 -0500", hash_original_method = "E448D9A67BED3FAB4DCC9D1BF5871C73", hash_generated_method = "DF476E3036228D7B0442E232C0690BA4")
    
public void getAdditionalReply() throws IOException
    {
        String line;

        line = _reader.readLine();
        while (line != null)
        {
            _replyLines.addElement(line);
            if (line.equals("."))
                break;
            line = _reader.readLine();
        }
    }


    /***
     * Disconnects the client from the server, and sets the state to
     * <code> DISCONNECTED_STATE </code>.  The reply text information
     * from the last issued command is voided to allow garbage collection
     * of the memory used to store that information.
     * <p>
     * @exception IOException  If there is an error in disconnecting.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.472 -0500", hash_original_method = "1474552803FC2685678A4E676E6971C0", hash_generated_method = "004152CB5BF030549BAE435DF9336F43")
    
public void disconnect() throws IOException
    {
        super.disconnect();
        _reader = null;
        __writer = null;
        _lastReplyLine = null;
        _replyLines.setSize(0);
        setState(DISCONNECTED_STATE);
    }


    /***
     * Sends a command an arguments to the server and returns the reply code.
     * <p>
     * @param command  The POP3 command to send.
     * @param args     The command arguments.
     * @return  The server reply code (either POP3Reply.OK or POP3Reply.ERROR).
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.478 -0500", hash_original_method = "A7A36943EFC7086371CF45712D37E84A", hash_generated_method = "3DDD9AD55C14ABD700A1340C985CA31C")
    
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

        __writer.write(message = __commandBuffer.toString());
        __writer.flush();

        if (_commandSupport_.getListenerCount() > 0)
            _commandSupport_.fireCommandSent(command, message);

        __getReply();
        return _replyCode;
    }

    /***
     * Sends a command with no arguments to the server and returns the
     * reply code.
     * <p>
     * @param command  The POP3 command to send.
     * @return  The server reply code (either POP3Reply.OK or POP3Reply.ERROR).
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.481 -0500", hash_original_method = "249D1EA65C901278A4D9A21CA58581D8", hash_generated_method = "319B33627FD404284CF2FADC01D735DC")
    
public int sendCommand(String command) throws IOException
    {
        return sendCommand(command, null);
    }

    /***
     * Sends a command an arguments to the server and returns the reply code.
     * <p>
     * @param command  The POP3 command to send
     *                  (one of the POP3Command constants).
     * @param args     The command arguments.
     * @return  The server reply code (either POP3Reply.OK or POP3Reply.ERROR).
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.489 -0500", hash_original_method = "45C58224451B51A3264A16CA25344B04", hash_generated_method = "DC06289D43B6BBB5FBD073291773A3E0")
    
public int sendCommand(int command, String args) throws IOException
    {
        return sendCommand(POP3Command._commands[command], args);
    }

    /***
     * Sends a command with no arguments to the server and returns the
     * reply code.
     * <p>
     * @param command  The POP3 command to send
     *                  (one of the POP3Command constants).
     * @return  The server reply code (either POP3Reply.OK or POP3Reply.ERROR).
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.493 -0500", hash_original_method = "5A25BF0F0E375260F6C2B96FBB0D25FE", hash_generated_method = "44E0F7DF91D2F3BF7E701A42C087E724")
    
public int sendCommand(int command) throws IOException
    {
        return sendCommand(POP3Command._commands[command], null);
    }


    /***
     * Returns an array of lines received as a reply to the last command
     * sent to the server.  The lines have end of lines truncated.  If
     * the reply is a single line, but its format ndicates it should be
     * a multiline reply, then you must call
     * {@link #getAdditionalReply  getAdditionalReply() } to
     * fetch the rest of the reply, and then call <code>getReplyStrings</code>
     * again.  You only have to worry about this if you are implementing
     * your own client using the {@link #sendCommand  sendCommand } methods.
     * <p>
     * @return The last server response.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.498 -0500", hash_original_method = "3A94E407C2A98EED939BFA1A6A3156D5", hash_generated_method = "D7F54852D6CD4A77CA3C84C4B5B9FBFB")
    
public String[] getReplyStrings()
    {
        String[] lines;
        lines = new String[_replyLines.size()];
        _replyLines.copyInto(lines);
        return lines;
    }

    /***
     * Returns the reply to the last command sent to the server.
     * The value is a single string containing all the reply lines including
     * newlines.  If the reply is a single line, but its format ndicates it
     * should be a multiline reply, then you must call
     * {@link #getAdditionalReply  getAdditionalReply() } to
     * fetch the rest of the reply, and then call <code>getReplyString</code>
     * again.  You only have to worry about this if you are implementing
     * your own client using the {@link #sendCommand  sendCommand } methods.
     * <p>
     * @return The last server response.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.503 -0500", hash_original_method = "0629B90BFF8E413434D8D65C78F23A0E", hash_generated_method = "6927249A05A964753695A696646C5817")
    
public String getReplyString()
    {
        Enumeration en;
        StringBuffer buffer = new StringBuffer(256);

        en = _replyLines.elements();
        while (en.hasMoreElements())
        {
            buffer.append((String)en.nextElement());
            buffer.append(SocketClient.NETASCII_EOL);
        }

        return buffer.toString();
    }

}

