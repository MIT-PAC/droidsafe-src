/*
 * Copyright 2003-2004 The Apache Software Foundation
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
package org.apache.commons.net.telnet;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.net.io.FromNetASCIIInputStream;
import org.apache.commons.net.io.ToNetASCIIOutputStream;

/***
 * The TelnetClient class implements the simple network virtual
 * terminal (NVT) for the Telnet protocol according to RFC 854.  It
 * does not implement any of the extra Telnet options because it
 * is meant to be used within a Java program providing automated
 * access to Telnet accessible resources.
 * <p>
 * The class can be used by first connecting to a server using the
 * SocketClient
 * {@link org.apache.commons.net.SocketClient#connect connect}
 * method.  Then an InputStream and OutputStream for sending and
 * receiving data over the Telnet connection can be obtained by
 * using the {@link #getInputStream  getInputStream() } and
 * {@link #getOutputStream  getOutputStream() } methods.
 * When you finish using the streams, you must call
 * {@link #disconnect  disconnect } rather than simply
 * closing the streams.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @author Bruno D'Avanzo
 ***/

public class TelnetClient extends Telnet
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.367 -0500", hash_original_field = "2E718496483F14F5C147A38B299F759C", hash_generated_field = "4DEE2C9ADA3E219441C8E8E623985C33")

    private InputStream __input;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.371 -0500", hash_original_field = "E56D774E0B47A20FF2BEF8EE5C129A20", hash_generated_field = "DE457E78C2E7DB147AA705C9753FE269")

    private OutputStream __output;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.374 -0500", hash_original_field = "09AEA54237B288BE0414AE13DA655F88", hash_generated_field = "4CD1AE51F31E45558C81CF1A0B775E1C")

    protected boolean readerThread = true;

    /***
     * Default TelnetClient constructor.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.379 -0500", hash_original_method = "15A0010D4AABD66B282741758C2E805C", hash_generated_method = "556FA5FB890A2B790D6C1C65038D9781")
    
public TelnetClient()
    {
        /* TERMINAL-TYPE option (start)*/
        super ("VT100");
        /* TERMINAL-TYPE option (end)*/
        __input = null;
        __output = null;
    }

    /* TERMINAL-TYPE option (start)*/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.388 -0500", hash_original_method = "7737DC888CB16CB82D4128F0FBEB9378", hash_generated_method = "A18F013DF0B4D05D60D9902F5B4EA747")
    
public TelnetClient(String termtype)
    {
        super (termtype);
        __input = null;
        __output = null;
    }
    /* TERMINAL-TYPE option (end)*/

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.391 -0500", hash_original_method = "227BE09654FF1861A06E0E5856151E48", hash_generated_method = "227BE09654FF1861A06E0E5856151E48")
    
void _flushOutputStream() throws IOException
    {
        _output_.flush();
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.396 -0500", hash_original_method = "805B4AEF59D255E63C94698AE31DEC92", hash_generated_method = "805B4AEF59D255E63C94698AE31DEC92")
    
void _closeOutputStream() throws IOException
    {
        _output_.close();
    }

    /***
     * Handles special connection requirements.
     * <p>
     * @exception IOException  If an error occurs during connection setup.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.400 -0500", hash_original_method = "CBA9C9C2A65EACDAD03B36A06DFF64B0", hash_generated_method = "AF17EEB713B0DE34C67B2AAB24E2A77B")
    
protected void _connectAction_() throws IOException
    {
        super._connectAction_();
        InputStream input;
        TelnetInputStream tmp;

        if (FromNetASCIIInputStream.isConversionRequired())
            input = new FromNetASCIIInputStream(_input_);
        else
            input = _input_;


        tmp = new TelnetInputStream(input, this, readerThread);
        if(readerThread)
        {
            tmp._start();
        }
        // __input CANNOT refer to the TelnetInputStream.  We run into
        // blocking problems when some classes use TelnetInputStream, so
        // we wrap it with a BufferedInputStream which we know is safe.
        // This blocking behavior requires further investigation, but right
        // now it looks like classes like InputStreamReader are not implemented
        // in a safe manner.
        __input = new BufferedInputStream(tmp);
        __output = new ToNetASCIIOutputStream(new TelnetOutputStream(this));
    }

    /***
     * Disconnects the telnet session, closing the input and output streams
     * as well as the socket.  If you have references to the
     * input and output streams of the telnet connection, you should not
     * close them yourself, but rather call disconnect to properly close
     * the connection.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.404 -0500", hash_original_method = "A5A902720BBA2BC5C38FC5C51260A9D6", hash_generated_method = "BEF6C75B1C9182A7F94002676040FAA7")
    
public void disconnect() throws IOException
    {
        __input.close();
        __output.close();
        super.disconnect();
    }

    /***
     * Returns the telnet connection output stream.  You should not close the
     * stream when you finish with it.  Rather, you should call
     * {@link #disconnect  disconnect }.
     * <p>
     * @return The telnet connection output stream.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.407 -0500", hash_original_method = "C3A502648B54CD9C00200B22148CC8AC", hash_generated_method = "912CC0C1E6B6044D88BE3B1AEF1BBC21")
    
public OutputStream getOutputStream()
    {
        return __output;
    }

    /***
     * Returns the telnet connection input stream.  You should not close the
     * stream when you finish with it.  Rather, you should call
     * {@link #disconnect  disconnect }.
     * <p>
     * @return The telnet connection input stream.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.411 -0500", hash_original_method = "467E1D75EA54E36659724C5259CAA973", hash_generated_method = "A485BD7A6017E24C984E7976403024FE")
    
public InputStream getInputStream()
    {
        return __input;
    }

    /***
     * Returns the state of the option on the local side.
     * <p>
     * @param option - Option to be checked.
     * <p>
     * @return The state of the option on the local side.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.415 -0500", hash_original_method = "385571E5A278B9294CC1DCBC641661CD", hash_generated_method = "E9CC16710CC66012C85E42DF36F6EC8B")
    
public boolean getLocalOptionState(int option)
    {
        /* BUG (option active when not already acknowledged) (start)*/
        return (_stateIsWill(option) && _requestedWill(option));
        /* BUG (option active when not already acknowledged) (end)*/
    }

    /***
     * Returns the state of the option on the remote side.
     * <p>
     * @param option - Option to be checked.
     * <p>
     * @return The state of the option on the remote side.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.421 -0500", hash_original_method = "907D546183AA4C4B5E5EC72E0BA90597", hash_generated_method = "35AE4A5A3C594E527F89BC06CC8850B7")
    
public boolean getRemoteOptionState(int option)
    {
        /* BUG (option active when not already acknowledged) (start)*/
        return (_stateIsDo(option) && _requestedDo(option));
        /* BUG (option active when not already acknowledged) (end)*/
    }
    /* open TelnetOptionHandler functionality (end)*/

    /* Code Section added for supporting AYT (start)*/

    /***
     * Sends an Are You There sequence and waits for the result.
     * <p>
     * @throws InterruptedException
     * @throws IllegalArgumentException
     * @throws IOException
     * <p>
     * @param timeout - Time to wait for a response (millis.)
     * <p>
     * @return true if AYT received a response, false otherwise
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.424 -0500", hash_original_method = "F060452392542B1DFA01F7103620BB37", hash_generated_method = "DB1667D8182DA799F631A5B078EC58E6")
    
public boolean sendAYT(long timeout)
    throws IOException, IllegalArgumentException, InterruptedException
    {
        return (_sendAYT(timeout));
    }
    /* Code Section added for supporting AYT (start)*/

    /* open TelnetOptionHandler functionality (start)*/

    /***
     * Registers a new TelnetOptionHandler for this telnet client to use.
     * <p>
     * @throws InvalidTelnetOptionException
     * <p>
     * @param opthand - option handler to be registered.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.428 -0500", hash_original_method = "C7335716F5A5FE392DFA727356C682DF", hash_generated_method = "A329A8E4FAEC9FF6A4525B62EAF0DCD3")
    
public void addOptionHandler(TelnetOptionHandler opthand)
    throws InvalidTelnetOptionException
    {
        super.addOptionHandler(opthand);
    }
    /* open TelnetOptionHandler functionality (end)*/

    /***
     * Unregisters a  TelnetOptionHandler.
     * <p>
     * @throws InvalidTelnetOptionException
     * <p>
     * @param optcode - Code of the option to be unregistered.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.431 -0500", hash_original_method = "8B6A27DB4EF6FF923614BEDE2725C38D", hash_generated_method = "C175DA295867E4B2748B526110F37F97")
    
public void deleteOptionHandler(int optcode)
    throws InvalidTelnetOptionException
    {
        super.deleteOptionHandler(optcode);
    }

    /* Code Section added for supporting spystreams (start)*/
    /***
     * Registers an OutputStream for spying what's going on in
     * the TelnetClient session.
     * <p>
     * @param spystream - OutputStream on which session activity
     * will be echoed.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.434 -0500", hash_original_method = "A42C38B5EC409455B458B8894CBAC685", hash_generated_method = "736FFC5D8306996A19F0FFA3C8858096")
    
public void registerSpyStream(OutputStream  spystream)
    {
        super._registerSpyStream(spystream);
    }

    /***
     * Stops spying this TelnetClient.
     * <p>
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.446 -0500", hash_original_method = "F82C2754B23055580BC52097E43A638F", hash_generated_method = "DFC273A3EF7088CF42618329463CB6DB")
    
public void stopSpyStream()
    {
        super._stopSpyStream();
    }
    /* Code Section added for supporting spystreams (end)*/

    /***
     * Registers a notification handler to which will be sent
     * notifications of received telnet option negotiation commands.
     * <p>
     * @param notifhand - TelnetNotificationHandler to be registered
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.450 -0500", hash_original_method = "8CC326C1A1CE427AC85501B720437F4A", hash_generated_method = "695FE39C6F48DCAEAE8CBE221DA9AF6D")
    
public void registerNotifHandler(TelnetNotificationHandler  notifhand)
    {
        super.registerNotifHandler(notifhand);
    }

    /***
     * Unregisters the current notification handler.
     * <p>
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.454 -0500", hash_original_method = "1AACB26B1B60F01C9870DFA873D76FD4", hash_generated_method = "01EBA9E48F7F3BEF49501179D80AE37E")
    
public void unregisterNotifHandler()
    {
        super.unregisterNotifHandler();
    }

    /***
     * Sets the status of the reader thread.
     * The reader thread status will apply to all subsequent connections
     * <p>
     * @param flag - true switches the reader thread on, false switches it off
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.458 -0500", hash_original_method = "BCC971138014B89E5944C0561954C707", hash_generated_method = "7C34848E453B1C03AECFD98E934BF0F4")
    
public void setReaderThread(boolean flag)
    {
        readerThread = flag;
    }

    /***
     * Gets the status of the reader thread.
     * <p>
     * @return true if the reader thread is on, false otherwise
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.462 -0500", hash_original_method = "792B102539C45B0146E64BFCECE54598", hash_generated_method = "3CEFB6C09CCBEB5DC5271F3CD9EC8FC5")
    
public boolean getReaderThread()
    {
        return (readerThread);
    }
}
