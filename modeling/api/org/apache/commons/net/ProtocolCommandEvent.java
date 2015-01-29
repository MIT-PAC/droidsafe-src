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
import java.util.EventObject;

/***
 * There exists a large class of IETF protocols that work by sending an
 * ASCII text command and arguments to a server, and then receiving an
 * ASCII text reply.  For debugging and other purposes, it is extremely
 * useful to log or keep track of the contents of the protocol messages.
 * The ProtocolCommandEvent class coupled with the
 * {@link org.apache.commons.net.ProtocolCommandListener}
 *  interface facilitate this process.
 * <p>
 * <p>
 * @see ProtocolCommandListener
 * @see ProtocolCommandSupport
 * @author Daniel F. Savarese
 ***/

public class ProtocolCommandEvent extends EventObject
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.854 -0500", hash_original_field = "EF338FA794A21631EC5E6D77B0405737", hash_generated_field = "BC456FF9D9AF9B514209E37CDE6F81F8")

    private int __replyCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.857 -0500", hash_original_field = "A0766E23B06E07C69F86301F88A30AB8", hash_generated_field = "7A5009FF5699DF666A4CA3799F06F2C7")

    private boolean __isCommand;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.860 -0500", hash_original_field = "FA112FAA90A71778B4DED3F646C1FA65", hash_generated_field = "C9C895CA3775E282397537501CDA649B")

    private String __message, __command;

    /***
     * Creates a ProtocolCommandEvent signalling a command was sent to
     * the server.  ProtocolCommandEvents created with this constructor
     * should only be sent after a command has been sent, but before the
     * reply has been received.
     * <p>
     * @param source  The source of the event.
     * @param command The string representation of the command type sent, not
     *      including the arguments (e.g., "STAT" or "GET").
     * @param message The entire command string verbatim as sent to the server,
     *        including all arguments.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.863 -0500", hash_original_method = "CB42E2F6132A6F2C3E05FCFA5B7F8B05", hash_generated_method = "66AF6F8EFB1A17606A227F583084FB0E")
    @DSComment("Constructor")
    @DSSafe(DSCat.SAFE_OTHERS)

public ProtocolCommandEvent(Object source, String command, String message)
    {
        super(source);
        __replyCode = 0;
        __message = message;
        __isCommand = true;
        __command = command;
    }

    /***
     * Creates a ProtocolCommandEvent signalling a reply to a command was
     * received.  ProtocolCommandEvents created with this constructor
     * should only be sent after a complete command reply has been received
     * fromt a server.
     * <p>
     * @param source  The source of the event.
     * @param replyCode The integer code indicating the natureof the reply.
     *   This will be the protocol integer value for protocols
     *   that use integer reply codes, or the reply class constant
     *   corresponding to the reply for protocols like POP3 that use
     *   strings like OK rather than integer codes (i.e., POP3Repy.OK).
     * @param message The entire reply as received from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.866 -0500", hash_original_method = "9EA7EC74A4BC8E0DF33625800BD9F55F", hash_generated_method = "0759AD5473A5524C20990496444FB6A9")
    @DSComment("Constructor")
    @DSSafe(DSCat.SAFE_OTHERS)

public ProtocolCommandEvent(Object source, int replyCode, String message)
    {
        super(source);
        __replyCode = replyCode;
        __message = message;
        __isCommand = false;
        __command = null;
    }

    /***
     * Returns the string representation of the command type sent (e.g., "STAT"
     * or "GET").  If the ProtocolCommandEvent is a reply event, then null
     * is returned.
     * <p>
     * @return The string representation of the command type sent, or null
     *         if this is a reply event.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.869 -0500", hash_original_method = "B07C43A2A9038460B2AFBD1567F9C907", hash_generated_method = "16C03E35245A5EAEB0E4ED5F673E4423")
    @DSComment("getter function")
    @DSSafe(DSCat.SAFE_OTHERS)
public String getCommand()
    {
        return __command;
    }

    /***
     * Returns the reply code of the received server reply.  Undefined if
     * this is not a reply event.
     * <p>
     * @return The reply code of the received server reply.  Undefined if
     *         not a reply event.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.872 -0500", hash_original_method = "49CC7F4F0E4CF44286687A7FDF656616", hash_generated_method = "9677A77743ABCE39DB4858B21E9CFAE4")
    @DSComment("getter function")
    @DSSafe(DSCat.SAFE_OTHERS)
    
public int getReplyCode()
    {
        return __replyCode;
    }

    /***
     * Returns true if the ProtocolCommandEvent was generated as a result
     * of sending a command.
     * <p>
     * @return true If the ProtocolCommandEvent was generated as a result
     * of sending a command.  False otherwise.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.875 -0500", hash_original_method = "BF967FD8D067C4ECB64FA2CD72EF91FA", hash_generated_method = "1DD936A1546C4CF673EEEF568E570245")
    @DSComment("getter function")
    @DSSafe(DSCat.SAFE_OTHERS)
    
public boolean isCommand()
    {
        return __isCommand;
    }

    /***
     * Returns true if the ProtocolCommandEvent was generated as a result
     * of receiving a reply.
     * <p>
     * @return true If the ProtocolCommandEvent was generated as a result
     * of receiving a reply.  False otherwise.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.879 -0500", hash_original_method = "5ADD93B4871E994650D7A4687B03F29C", hash_generated_method = "E9E9FE6807846298D52AD58540EE9F44")
    
    @DSComment("getter function")
    @DSSafe(DSCat.SAFE_OTHERS)
public boolean isReply()
    {
        return !isCommand();
    }

    /***
     * Returns the entire message sent to or received from the server.
     * <p>
     * @return The entire message sent to or received from the server.
     ***/
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.882 -0500", hash_original_method = "FA236082A8FEACD0E825C22F5D6921C2", hash_generated_method = "6038A56F1274B114EF2CB0ABD692B0C9")
    @DSComment("getter function")
    @DSSafe(DSCat.SAFE_OTHERS)
    
public String getMessage()
    {
        return __message;
    }
}
