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
import java.io.InterruptedIOException;

/***
 *
 * <p>
 *
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @author Bruno D'Avanzo
 ***/

final class TelnetInputStream extends BufferedInputStream implements Runnable
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.854 -0500", hash_original_field = "E0445244D7A67E3BEE12186A58D97CD2", hash_generated_field = "8E4EC2729C3B0BA8DE02EAED79B1289D")

    static final int _STATE_DATA = 0, _STATE_IAC = 1, _STATE_WILL = 2,
                     _STATE_WONT = 3, _STATE_DO = 4, _STATE_DONT = 5,
                     _STATE_SB = 6, _STATE_SE = 7, _STATE_CR = 8, _STATE_IAC_SB = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.862 -0500", hash_original_field = "1173F66F362C8445F5EAF867F92799DA", hash_generated_field = "57778FC73ACFB7A98988535C015F8C8B")

    private boolean __hasReachedEOF, __isClosed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.872 -0500", hash_original_field = "409D3B831DEA719A6A0AFC650F419141", hash_generated_field = "6D3C2A909A50D27EAE0C7565ACD11067")

    private boolean __readIsWaiting;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.877 -0500", hash_original_field = "89F2C138103C38BFF640ABE05161AF8A", hash_generated_field = "EAAA20F63B2172B27E4C1CBE6AF0548A")

    private int __receiveState, __queueHead, __queueTail, __bytesAvailable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.881 -0500", hash_original_field = "935A619E106B6AEA231EBF6BFA12CDAF", hash_generated_field = "B6C0A4AC9DC162FB707B3DA407A2600A")

    private int[] __queue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.885 -0500", hash_original_field = "C86EE9323E0FFDBCF8BA85F6EF05A76C", hash_generated_field = "3FE186602BDE6904EF3E01EF9B657DE2")

    private TelnetClient __client;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.889 -0500", hash_original_field = "EC6FF4942B83F61264E904AC0DD12F5D", hash_generated_field = "FCD865B0168BC7B9ED05E9A9368C6689")

    private Thread __thread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.893 -0500", hash_original_field = "B105E6669A1B9B6EE9463F4E75D27E83", hash_generated_field = "436BA15DA75C37584AC4A08F0A7F6B79")

    private IOException __ioException;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.898 -0500", hash_original_field = "77C172C9CAF15AEB3D28F4D52EC48CBE", hash_generated_field = "3134F98EAE47642D71F03BE6A8DBCFC1")

    private int __suboption[] = new int[256];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.905 -0500", hash_original_field = "6B2C9A3E74FAD2861825FD7DC6C96406", hash_generated_field = "A13BEDE18B41BDB1D19926418F1C4F16")

    private int __suboption_count = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.911 -0500", hash_original_field = "30DEA0810623E7BC48AF78EE7C9343B3", hash_generated_field = "90C4EB634461342FD50EE22A84670F25")

    private boolean __threaded;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.917 -0500", hash_original_method = "027A0D76455B7BDED1EB1A7EDE069965", hash_generated_method = "2D34BD73F4FDFEA16D617AAC8D2F26B7")
    
TelnetInputStream(InputStream input, TelnetClient client,
                      boolean readerThread)
    {
        super(input);
        __client = client;
        __receiveState = _STATE_DATA;
        __isClosed = true;
        __hasReachedEOF = false;
        // Make it 2049, because when full, one slot will go unused, and we
        // want a 2048 byte buffer just to have a round number (base 2 that is)
        __queue = new int[2049];
        __queueHead = 0;
        __queueTail = 0;
        __bytesAvailable = 0;
        __ioException = null;
        __readIsWaiting = false;
        __threaded = false;
        if(readerThread)
            __thread = new Thread(this);
        else
            __thread = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.921 -0500", hash_original_method = "72785DD95C6410ECF7F630F4A8860A6F", hash_generated_method = "72785DD95C6410ECF7F630F4A8860A6F")
    
TelnetInputStream(InputStream input, TelnetClient client) {
        this(input, client, true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.925 -0500", hash_original_method = "E7412F2BCDFEA7CBCAE3CCCEA5686DEA", hash_generated_method = "563E7A5AD16227DE45E1F8E61BE2C7B4")
    
void _start()
    {
        if(__thread == null)
            return;

        int priority;
        __isClosed = false;
        // Need to set a higher priority in case JVM does not use pre-emptive
        // threads.  This should prevent scheduler induced deadlock (rather than
        // deadlock caused by a bug in this code).
        priority = Thread.currentThread().getPriority() + 1;
        if (priority > Thread.MAX_PRIORITY)
            priority = Thread.MAX_PRIORITY;
        __thread.setPriority(priority);
        __thread.setDaemon(true);
        __thread.start();
        __threaded = true;
    }

    // synchronized(__client) critical sections are to protect against
    // TelnetOutputStream writing through the telnet client at same time
    // as a processDo/Will/etc. command invoked from TelnetInputStream
    // tries to write.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.934 -0500", hash_original_method = "D6AA3D2B6B3E71137BE1756BC084EAE1", hash_generated_method = "749ED4521F0B1EEB9B2DD8A1AE873FBD")
    
private int __read() throws IOException
    {
        int ch;

_loop:
        while (true)
        {
            // Exit only when we reach end of stream.
            if ((ch = super.read()) < 0)
                return -1;

            ch = (ch & 0xff);

            /* Code Section added for supporting AYT (start)*/
            synchronized (__client)
            {
                __client._processAYTResponse();
            }
            /* Code Section added for supporting AYT (end)*/

            /* Code Section added for supporting spystreams (start)*/
            __client._spyRead(ch);
            /* Code Section added for supporting spystreams (end)*/

_mainSwitch:
            switch (__receiveState)
            {

            case _STATE_CR:
                if (ch == '\0')
                {
                    // Strip null
                    continue;
                }
                // How do we handle newline after cr?
                //  else if (ch == '\n' && _requestedDont(TelnetOption.ECHO) &&

                // Handle as normal data by falling through to _STATE_DATA case

            case _STATE_DATA:
                if (ch == TelnetCommand.IAC)
                {
                    __receiveState = _STATE_IAC;
                    continue;
                }

                if (ch == '\r')
                {
                    synchronized (__client)
                    {
                        if (__client._requestedDont(TelnetOption.BINARY))
                            __receiveState = _STATE_CR;
                        else
                            __receiveState = _STATE_DATA;
                    }
                }
                else
                    __receiveState = _STATE_DATA;
                break;

            case _STATE_IAC:
                switch (ch)
                {
                case TelnetCommand.WILL:
                    __receiveState = _STATE_WILL;
                    continue;
                case TelnetCommand.WONT:
                    __receiveState = _STATE_WONT;
                    continue;
                case TelnetCommand.DO:
                    __receiveState = _STATE_DO;
                    continue;
                case TelnetCommand.DONT:
                    __receiveState = _STATE_DONT;
                    continue;
                /* TERMINAL-TYPE option (start)*/
                case TelnetCommand.SB:
                    __suboption_count = 0;
                    __receiveState = _STATE_SB;
                    continue;
                /* TERMINAL-TYPE option (end)*/
                case TelnetCommand.IAC:
                    __receiveState = _STATE_DATA;
                    break;
                default:
                    break;
                }
                __receiveState = _STATE_DATA;
                continue;
            case _STATE_WILL:
                synchronized (__client)
                {
                    __client._processWill(ch);
                    __client._flushOutputStream();
                }
                __receiveState = _STATE_DATA;
                continue;
            case _STATE_WONT:
                synchronized (__client)
                {
                    __client._processWont(ch);
                    __client._flushOutputStream();
                }
                __receiveState = _STATE_DATA;
                continue;
            case _STATE_DO:
                synchronized (__client)
                {
                    __client._processDo(ch);
                    __client._flushOutputStream();
                }
                __receiveState = _STATE_DATA;
                continue;
            case _STATE_DONT:
                synchronized (__client)
                {
                    __client._processDont(ch);
                    __client._flushOutputStream();
                }
                __receiveState = _STATE_DATA;
                continue;
            /* TERMINAL-TYPE option (start)*/
            case _STATE_SB:
                switch (ch)
                {
                case TelnetCommand.IAC:
                    __receiveState = _STATE_IAC_SB;
                    continue;
                default:
                    // store suboption char
                    __suboption[__suboption_count++] = ch;
                    break;
                }
                __receiveState = _STATE_SB;
                continue;
            case _STATE_IAC_SB:
                switch (ch)
                {
                case TelnetCommand.SE:
                    synchronized (__client)
                    {
                        __client._processSuboption(__suboption, __suboption_count);
                        __client._flushOutputStream();
                    }
                    __receiveState = _STATE_DATA;
                    continue;
                default:
                    __receiveState = _STATE_SB;
                    break;
                }
                __receiveState = _STATE_DATA;
                continue;
            /* TERMINAL-TYPE option (end)*/
            }

            break;
        }

        return ch;
    }

    // synchronized(__client) critical sections are to protect against
    // TelnetOutputStream writing through the telnet client at same time
    // as a processDo/Will/etc. command invoked from TelnetInputStream
    // tries to write.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.944 -0500", hash_original_method = "BA8DD1C23354C503CB1A37724FA9B323", hash_generated_method = "BCF150C7E29D626423437B02540EC0B4")
    
private void __processChar(int ch) throws InterruptedException
    {
        // Critical section because we're altering __bytesAvailable,
        // __queueTail, and the contents of _queue.
        synchronized (__queue)
        {
            while (__bytesAvailable >= __queue.length - 1)
            {
                if(__threaded)
                {
                    __queue.notify();
                    try
                    {
                        __queue.wait();
                    }
                    catch (InterruptedException e)
                    {
                        throw e;
                    }
                }
            }

            // Need to do this in case we're not full, but block on a read
            if (__readIsWaiting && __threaded)
            {
                __queue.notify();
            }

            __queue[__queueTail] = ch;
            ++__bytesAvailable;

            if (++__queueTail >= __queue.length)
                __queueTail = 0;
        }
    }

    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.953 -0500", hash_original_method = "66329309126CC18AC52080ACFD2A7E15", hash_generated_method = "3CA5BFC1C90FB822B8610B3B9A261C02")
    
public int read() throws IOException
    {
        // Critical section because we're altering __bytesAvailable,
        // __queueHead, and the contents of _queue in addition to
        // testing value of __hasReachedEOF.
        synchronized (__queue)
        {

            while (true)
            {
                if (__ioException != null)
                {
                    IOException e;
                    e = __ioException;
                    __ioException = null;
                    throw e;
                }

                if (__bytesAvailable == 0)
                {
                    // Return -1 if at end of file
                    if (__hasReachedEOF)
                        return -1;

                    // Otherwise, we have to wait for queue to get something
                    if(__threaded)
                    {
                        __queue.notify();
                        try
                        {
                            __readIsWaiting = true;
                            __queue.wait();
                            __readIsWaiting = false;
                        }
                        catch (InterruptedException e)
                        {
                            throw new IOException("Fatal thread interruption during read.");
                        }
                    }
                    else
                    {
                        //__alreadyread = false;
                        __readIsWaiting = true;
                        int ch;

                        do
                        {
                            try
                            {
                                if ((ch = __read()) < 0)
                                    if(ch != -2)
                                        return (ch);
                            }
                            catch (InterruptedIOException e)
                            {
                                synchronized (__queue)
                                {
                                    __ioException = e;
                                    __queue.notifyAll();
                                    try
                                    {
                                        __queue.wait(100);
                                    }
                                    catch (InterruptedException interrupted)
                                    {
                                    }
                                }
                                return (-1);
                            }

                            try
                            {
                                if(ch != -2)
                                {
                                    __processChar(ch);
                                }
                            }
                            catch (InterruptedException e)
                            {
                                if (__isClosed)
                                    return (-1);
                            }
                        }
                        while (super.available() > 0);

                        __readIsWaiting = false;
                    }
                    continue;
                }
                else
                {
                    int ch;

                    ch = __queue[__queueHead];

                    if (++__queueHead >= __queue.length)
                        __queueHead = 0;

                    --__bytesAvailable;

		    // Need to explicitly notify() so available() works properly
		    if(__bytesAvailable == 0 && __threaded) {
			    __queue.notify();
		    }
		    
                    return ch;
                }
            }
        }
    }

    /***
     * Reads the next number of bytes from the stream into an array and
     * returns the number of bytes read.  Returns -1 if the end of the
     * stream has been reached.
     * <p>
     * @param buffer  The byte array in which to store the data.
     * @return The number of bytes read. Returns -1 if the
     *          end of the message has been reached.
     * @exception IOException If an error occurs in reading the underlying
     *            stream.
     ***/
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.957 -0500", hash_original_method = "1AF05D3B3AC1A0BE6FEC3ED8E4AD92D7", hash_generated_method = "602CBE64B37DDC68026D3CD1EA56EC7D")
    
public int read(byte buffer[]) throws IOException
    {
        return read(buffer, 0, buffer.length);
    }

    /***
     * Reads the next number of bytes from the stream into an array and returns
     * the number of bytes read.  Returns -1 if the end of the
     * message has been reached.  The characters are stored in the array
     * starting from the given offset and up to the length specified.
     * <p>
     * @param buffer The byte array in which to store the data.
     * @param offset  The offset into the array at which to start storing data.
     * @param length   The number of bytes to read.
     * @return The number of bytes read. Returns -1 if the
     *          end of the stream has been reached.
     * @exception IOException If an error occurs while reading the underlying
     *            stream.
     ***/
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.963 -0500", hash_original_method = "F31322C7E374D5C2D1894571A8E044A8", hash_generated_method = "F46F4C7939B3E8BCCBAAAF6C2BF2C47B")
    
public int read(byte buffer[], int offset, int length) throws IOException
    {
        int ch, off;

        if (length < 1)
            return 0;

        // Critical section because run() may change __bytesAvailable
        synchronized (__queue)
        {
            if (length > __bytesAvailable)
                length = __bytesAvailable;
        }

        if ((ch = read()) == -1)
            return -1;

        off = offset;

        do
        {
            buffer[offset++] = (byte)ch;
        }
        while (--length > 0 && (ch = read()) != -1);

        //__client._spyRead(buffer, off, offset - off);
        return (offset - off);
    }

    /*** Returns false.  Mark is not supported. ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.969 -0500", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "68CB0655189E46325916378CAE21EACC")
    
public boolean markSupported()
    {
        return false;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.975 -0500", hash_original_method = "8F0DC78A5AC3269E4DE32507160D3F4F", hash_generated_method = "23059450FF34B3A7D119C6767C621969")
    
public int available() throws IOException
    {
        // Critical section because run() may change __bytesAvailable
        synchronized (__queue)
        {
            return __bytesAvailable;
        }
    }

    // Cannot be synchronized.  Will cause deadlock if run() is blocked
    // in read because BufferedInputStream read() is synchronized.
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.982 -0500", hash_original_method = "F2413E328044212C07B796D6327CE9C1", hash_generated_method = "0209321B632A0EE62F937DD0C28C5FCB")
    
public void close() throws IOException
    {
        // Completely disregard the fact thread may still be running.
        // We can't afford to block on this close by waiting for
        // thread to terminate because few if any JVM's will actually
        // interrupt a system read() from the interrupt() method.
        super.close();

        synchronized (__queue)
        {
            __hasReachedEOF = true;
            __isClosed      = true;

            if (__thread != null && __thread.isAlive())
            {
                __thread.interrupt();
            }

            __queue.notifyAll();
        }

        __threaded = false;
    }

    @DSSpec(DSCat.THREADING)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:57.987 -0500", hash_original_method = "BC125B830373AC39F1C2546FCC293E9D", hash_generated_method = "8E7403B94ECFEDD51B5E7A8D415E9A56")
    
public void run()
    {
        int ch;

        try
        {
_outerLoop:
            while (!__isClosed)
            {
                try
                {
                    if ((ch = __read()) < 0)
                        break;
                }
                catch (InterruptedIOException e)
                {
                    synchronized (__queue)
                    {
                        __ioException = e;
                        __queue.notifyAll();
                        try
                        {
                            __queue.wait(100);
                        }
                        catch (InterruptedException interrupted)
                        {
                            if (__isClosed)
                                break _outerLoop;
                        }
                        continue;
                    }
                } catch(RuntimeException re) {
                    // We treat any runtime exceptions as though the
                    // stream has been closed.  We close the
                    // underlying stream just to be sure.
                    super.close();
                    // Breaking the loop has the effect of setting
                    // the state to closed at the end of the method.
                    break _outerLoop;
                }

                try
                {
                    __processChar(ch);
                }
                catch (InterruptedException e)
                {
                    if (__isClosed)
                        break _outerLoop;
                }
            }
        }
        catch (IOException ioe)
        {
            synchronized (__queue)
            {
                __ioException = ioe;
            }
        }

        synchronized (__queue)
        {
            __isClosed      = true; // Possibly redundant
            __hasReachedEOF = true;
            __queue.notify();
        }

        __threaded = false;
    }
}

/* Emacs configuration
 * Local variables:        **
 * mode:             java  **
 * c-basic-offset:   4     **
 * indent-tabs-mode: nil   **
 * End:                    **
 */
