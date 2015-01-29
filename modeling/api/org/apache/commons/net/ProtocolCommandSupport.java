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
import java.io.Serializable;
import java.util.Enumeration;
import org.apache.commons.net.util.ListenerList;

/***
 * ProtocolCommandSupport is a convenience class for managing a list of
 * ProtocolCommandListeners and firing ProtocolCommandEvents.  You can
 * simply delegate ProtocolCommandEvent firing and listener
 * registering/unregistering tasks to this class.
 * <p>
 * <p>
 * @see ProtocolCommandEvent
 * @see ProtocolCommandListener
 * @author Daniel F. Savarese
 ***/

public class ProtocolCommandSupport implements Serializable
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.550 -0500", hash_original_field = "286C5B88E2562D0F121F1670BA26B988", hash_generated_field = "F15F616084584F41C6D1EA3606D3FE44")

    private Object __source;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.556 -0500", hash_original_field = "BC83317544B5B37996111CAB5AD47961", hash_generated_field = "44225783259A0B7457B787EC64722DDF")

    private ListenerList __listeners;

    /***
     * Creates a ProtocolCommandSupport instant using the indicated source
     * as the source of fired ProtocolCommandEvents.
     * <p>
     * @param source  The source to use for all generated ProtocolCommandEvents.
     ***/
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.560 -0500", hash_original_method = "502912F9C717431C8F131DAFAEA6CFFC", hash_generated_method = "50D637142878A0E2645D56388C70D614")
    
public ProtocolCommandSupport(Object source)
    {
        __listeners = new ListenerList();
        __source = source;
    }

    /***
     * Fires a ProtocolCommandEvent signalling the sending of a command to all
     * registered listeners, invoking their
     * {@link org.apache.commons.net.ProtocolCommandListener#protocolCommandSent protocolCommandSent() }
     *  methods.
     * <p>
     * @param command The string representation of the command type sent, not
     *      including the arguments (e.g., "STAT" or "GET").
     * @param message The entire command string verbatim as sent to the server,
     *        including all arguments.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.565 -0500", hash_original_method = "924DE571208EDB6F106CC9F7AEFEDFBC", hash_generated_method = "917AFAEC8846A21C4DBFDDE51A31009B")
    @DSVerified
    @DSSafe(DSCat.CALLBACK_INVOKE)
    
public void fireCommandSent(String command, String message)
    {
        Enumeration en;
        ProtocolCommandEvent event;
        ProtocolCommandListener listener;

        en = __listeners.getListeners();

        event = new ProtocolCommandEvent(__source, command, message);

        while (en.hasMoreElements())
        {
            listener = (ProtocolCommandListener)en.nextElement();
            listener.protocolCommandSent(event);
        }
    }

    /***
     * Fires a ProtocolCommandEvent signalling the reception of a command reply
     * to all registered listeners, invoking their
     * {@link org.apache.commons.net.ProtocolCommandListener#protocolReplyReceived protocolReplyReceived() }
     *  methods.
     * <p>
     * @param replyCode The integer code indicating the natureof the reply.
     *   This will be the protocol integer value for protocols
     *   that use integer reply codes, or the reply class constant
     *   corresponding to the reply for protocols like POP3 that use
     *   strings like OK rather than integer codes (i.e., POP3Repy.OK).
     * @param message The entire reply as received from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.569 -0500", hash_original_method = "B9F577E0FBCAEFE328E86EB9BD6751FB", hash_generated_method = "6B1AA54471EAD34211C83ED4F2700F7B")
    
    @DSVerified
    @DSSafe(DSCat.CALLBACK_INVOKE)
public void fireReplyReceived(int replyCode, String message)
    {
        Enumeration en;
        ProtocolCommandEvent event;
        ProtocolCommandListener listener;

        en = __listeners.getListeners();

        event = new ProtocolCommandEvent(__source, replyCode, message);

        while (en.hasMoreElements())
        {
            listener = (ProtocolCommandListener)en.nextElement();
            listener.protocolReplyReceived(event);
        }
    }

    /***
     * Adds a ProtocolCommandListener.
     * <p>
     * @param listener  The ProtocolCommandListener to add.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.573 -0500", hash_original_method = "DECBD44E3008758FDC051E0FB454F22B", hash_generated_method = "9D096511C0BF9614F763EFCCD40CBA9A")
   
    @DSVerified
    @DSSafe(DSCat.CALLBACK_INVOKE)
public void addProtocolCommandListener(ProtocolCommandListener listener)
    {
        __listeners.addListener(listener);
        if (listener != null) {
            fireCommandSent("<proto-command>", "<proto-message>");
            fireReplyReceived(DSUtils.FAKE_INT, "<reply-received-msg>");
        }
    }

    /***
     * Removes a ProtocolCommandListener.
     * <p>
     * @param listener  The ProtocolCommandListener to remove.
     ***/
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.577 -0500", hash_original_method = "8BAE9456243623A59719FE55D09576AF", hash_generated_method = "98A8D0F0B5B9C9B0B8D3A0903AFD90DB")
    
public void removeProtocolCommandListener(ProtocolCommandListener listener)
    {
        __listeners.removeListener(listener);
    }

    /***
     * Returns the number of ProtocolCommandListeners currently registered.
     * <p>
     * @return The number of ProtocolCommandListeners currently registered.
     ***/
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.580 -0500", hash_original_method = "0341EF00CE2D6A0D116D4599A710DD9D", hash_generated_method = "863A9ADABBC8E3D79823EA3D9745525B")
    
public int getListenerCount()
    {
        return __listeners.getListenerCount();
    }

}

