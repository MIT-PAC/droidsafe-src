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


package org.apache.commons.net.pop3;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.Reader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.StringTokenizer;
import org.apache.commons.net.io.DotTerminatedMessageReader;

/***
 * The POP3Client class implements the client side of the Internet POP3
 * Protocol defined in RFC 1939.  All commands are supported, including
 * the APOP command which requires MD5 encryption.  See RFC 1939 for
 * more details on the POP3 protocol.
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
 * @see POP3MessageInfo
 * @see org.apache.commons.net.io.DotTerminatedMessageReader
 * @see org.apache.commons.net.MalformedServerReplyException
 ***/

public class POP3Client extends POP3
{

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.015 -0500", hash_original_method = "B4E96DE4D8FCA8C0ABFB2881AC98F0E5", hash_generated_method = "7F155E1D9B26700412B13C577F255E60")
    
private static POP3MessageInfo __parseStatus(String line)
    {
        int num, size;
        StringTokenizer tokenizer;

        tokenizer = new StringTokenizer(line);

        if (!tokenizer.hasMoreElements())
            return null;

        num = size = 0;

        try
        {
            num = Integer.parseInt(tokenizer.nextToken());

            if (!tokenizer.hasMoreElements())
                return null;

            size = Integer.parseInt(tokenizer.nextToken());
        }
        catch (NumberFormatException e)
        {
            return null;
        }

        return new POP3MessageInfo(num, size);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.021 -0500", hash_original_method = "86804562AF5E8C4FA65D3178BCAF3470", hash_generated_method = "CA56721D55538BE54587CD1B66C58AFD")
    
private static POP3MessageInfo __parseUID(String line)
    {
        int num;
        StringTokenizer tokenizer;

        tokenizer = new StringTokenizer(line);

        if (!tokenizer.hasMoreElements())
            return null;

        num = 0;

        try
        {
            num = Integer.parseInt(tokenizer.nextToken());

            if (!tokenizer.hasMoreElements())
                return null;

            line = tokenizer.nextToken();
        }
        catch (NumberFormatException e)
        {
            return null;
        }

        return new POP3MessageInfo(num, line);
    }

    /***
     * Login to the POP3 server with the given username and password.  You
     * must first connect to the server with
     * {@link org.apache.commons.net.SocketClient#connect  connect }
     * before attempting to login.  A login attempt is only valid if
     * the client is in the
     * {@link org.apache.commons.net.pop3.POP3#AUTHORIZATION_STATE AUTHORIZATION_STATE }
     * .  After logging in, the client enters the
     * {@link org.apache.commons.net.pop3.POP3#TRANSACTION_STATE TRANSACTION_STATE }
     * .
     * <p>
     * @param username  The account name being logged in to.
     * @param password  The plain text password of the account.
     * @return True if the login attempt was successful, false if not.
     * @exception IOException If a network I/O error occurs in the process of
     *            logging in.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.025 -0500", hash_original_method = "6053372F9E1263F0A71E25A52E24B3CA", hash_generated_method = "5B7594DC029DD75414092974B4B20968")
    
public boolean login(String username, String password) throws IOException
    {
        if (getState() != AUTHORIZATION_STATE)
            return false;

        if (sendCommand(POP3Command.USER, username) != POP3Reply.OK)
            return false;

        if (sendCommand(POP3Command.PASS, password) != POP3Reply.OK)
            return false;

        setState(TRANSACTION_STATE);

        return true;
    }


    /***
     * Login to the POP3 server with the given username and authentication
     * information.  Use this method when connecting to a server requiring
     * authentication using the APOP command.  Because the timestamp
     * produced in the greeting banner varies from server to server, it is
     * not possible to consistently extract the information.  Therefore,
     * after connecting to the server, you must call
     * {@link org.apache.commons.net.pop3.POP3#getReplyString getReplyString }
     *  and parse out the timestamp information yourself.
     * <p>
     * You must first connect to the server with
     * {@link org.apache.commons.net.SocketClient#connect  connect }
     * before attempting to login.  A login attempt is only valid if
     * the client is in the
     * {@link org.apache.commons.net.pop3.POP3#AUTHORIZATION_STATE AUTHORIZATION_STATE }
     * .  After logging in, the client enters the
     * {@link org.apache.commons.net.pop3.POP3#TRANSACTION_STATE TRANSACTION_STATE }
     * .  After connecting, you must parse out the
     * server specific information to use as a timestamp, and pass that
     * information to this method.  The secret is a shared secret known
     * to you and the server.  See RFC 1939 for more details regarding
     * the APOP command.
     * <p>
     * @param username  The account name being logged in to.
     * @param timestamp  The timestamp string to combine with the secret.
     * @param secret  The shared secret which produces the MD5 digest when
     *        combined with the timestamp.
     * @return True if the login attempt was successful, false if not.
     * @exception IOException If a network I/O error occurs in the process of
     *            logging in.
     * @exception NoSuchAlgorithmException If the MD5 encryption algorithm
     *      cannot be instantiated by the Java runtime system.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.028 -0500", hash_original_method = "0991B3965C90B1EA01206F16BE711647", hash_generated_method = "C36AF73FA53B7D8B3C798417715E9901")
    
public boolean login(String username, String timestamp, String secret)
    throws IOException, NoSuchAlgorithmException
    {
        int i;
        byte[] digest;
        StringBuffer buffer, digestBuffer;
        MessageDigest md5;

        if (getState() != AUTHORIZATION_STATE)
            return false;

        md5 = MessageDigest.getInstance("MD5");
        timestamp += secret;
        digest = md5.digest(timestamp.getBytes());
        digestBuffer = new StringBuffer(128);

        for (i = 0; i < digest.length; i++)
            digestBuffer.append(Integer.toHexString(digest[i] & 0xff));

        buffer = new StringBuffer(256);
        buffer.append(username);
        buffer.append(' ');
        buffer.append(digestBuffer.toString());

        if (sendCommand(POP3Command.APOP, buffer.toString()) != POP3Reply.OK)
            return false;

        setState(TRANSACTION_STATE);

        return true;
    }


    /***
     * Logout of the POP3 server.  To fully disconnect from the server
     * you must call
     * {@link org.apache.commons.net.pop3.POP3#disconnect  disconnect }.
     * A logout attempt is valid in any state.  If
     * the client is in the
     * {@link org.apache.commons.net.pop3.POP3#TRANSACTION_STATE TRANSACTION_STATE }
     * , it enters the
     * {@link org.apache.commons.net.pop3.POP3#UPDATE_STATE UPDATE_STATE }
     *  on a successful logout.
     * <p>
     * @return True if the logout attempt was successful, false if not.
     * @exception IOException If a network I/O error occurs in the process
     *           of logging out.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.031 -0500", hash_original_method = "D8BA71D1B5FD5172963B47E21FA852B0", hash_generated_method = "68D134A886AB02FE1FC4B8C6A6E6D889")
    
public boolean logout() throws IOException
    {
        if (getState() == TRANSACTION_STATE)
            setState(UPDATE_STATE);
        sendCommand(POP3Command.QUIT);
        return (_replyCode == POP3Reply.OK);
    }


    /***
     * Send a NOOP command to the POP3 server.  This is useful for keeping
     * a connection alive since most POP3 servers will timeout after 10
     * minutes of inactivity.  A noop attempt will only succeed if
     * the client is in the
     * {@link org.apache.commons.net.pop3.POP3#TRANSACTION_STATE TRANSACTION_STATE }
     * .
     * <p>
     * @return True if the noop attempt was successful, false if not.
     * @exception IOException If a network I/O error occurs in the process of
     *        sending the NOOP command.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.034 -0500", hash_original_method = "E078C29BC6FC8CC7DD5D2917CD135CA4", hash_generated_method = "5AD71C5B67A518AFA2C6D0D739E044C7")
    
public boolean noop() throws IOException
    {
        if (getState() == TRANSACTION_STATE)
            return (sendCommand(POP3Command.NOOP) == POP3Reply.OK);
        return false;
    }


    /***
     * Delete a message from the POP3 server.  The message is only marked
     * for deletion by the server.  If you decide to unmark the message, you
     * must issuse a {@link #reset  reset } command.  Messages marked
     * for deletion are only deleted by the server on
     * {@link #logout  logout }.
     * A delete attempt can only succeed if the client is in the
     * {@link org.apache.commons.net.pop3.POP3#TRANSACTION_STATE TRANSACTION_STATE }
     * .
     * <p>
     * @param messageId  The message number to delete.
     * @return True if the deletion attempt was successful, false if not.
     * @exception IOException If a network I/O error occurs in the process of
     *           sending the delete command.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.038 -0500", hash_original_method = "3527E3B50E11424840A0E5B5506D8908", hash_generated_method = "CA97EFD14BF3CD44819BDEA8488BAAB5")
    
public boolean deleteMessage(int messageId) throws IOException
    {
        if (getState() == TRANSACTION_STATE)
            return (sendCommand(POP3Command.DELE, Integer.toString(messageId))
                    == POP3Reply.OK);
        return false;
    }


    /***
     * Reset the POP3 session.  This is useful for undoing any message
     * deletions that may have been performed.  A reset attempt can only
     * succeed if the client is in the
     * {@link org.apache.commons.net.pop3.POP3#TRANSACTION_STATE TRANSACTION_STATE }
     * .
     * <p>
     * @return True if the reset attempt was successful, false if not.
     * @exception IOException If a network I/O error occurs in the process of
     *      sending the reset command.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.042 -0500", hash_original_method = "E606EF8952BF61C17145885F43467D0F", hash_generated_method = "788E756BFE34214908EB06599BF4767C")
    
public boolean reset() throws IOException
    {
        if (getState() == TRANSACTION_STATE)
            return (sendCommand(POP3Command.RSET) == POP3Reply.OK);
        return false;
    }

    /***
     * Get the mailbox status.  A status attempt can only
     * succeed if the client is in the
     * {@link org.apache.commons.net.pop3.POP3#TRANSACTION_STATE TRANSACTION_STATE }
     * .  Returns a POP3MessageInfo instance
     * containing the number of messages in the mailbox and the total
     * size of the messages in bytes.  Returns null if the status the
     * attempt fails.
     * <p>
     * @return A POP3MessageInfo instance containing the number of
     *         messages in the mailbox and the total size of the messages
     *         in bytes.  Returns null if the status the attempt fails.
     * @exception IOException If a network I/O error occurs in the process of
     *       sending the status command.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.045 -0500", hash_original_method = "D355305109535AECCA5EFB2F5F5A698C", hash_generated_method = "7A55F43FC8BDE457FF57381E9B461E9D")
    
public POP3MessageInfo status() throws IOException
    {
        if (getState() != TRANSACTION_STATE)
            return null;
        if (sendCommand(POP3Command.STAT) != POP3Reply.OK)
            return null;
        return __parseStatus(_lastReplyLine.substring(3));
    }


    /***
     * List an individual message.  A list attempt can only
     * succeed if the client is in the
     * {@link org.apache.commons.net.pop3.POP3#TRANSACTION_STATE TRANSACTION_STATE }
     * .  Returns a POP3MessageInfo instance
     * containing the number of the listed message and the
     * size of the message in bytes.  Returns null if the list
     * attempt fails (e.g., if the specified message number does
     * not exist).
     * <p>
     * @param messageId  The number of the message list.
     * @return A POP3MessageInfo instance containing the number of the
     *         listed message and the size of the message in bytes.  Returns
     *         null if the list attempt fails.
     * @exception IOException If a network I/O error occurs in the process of
     *         sending the list command.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.048 -0500", hash_original_method = "FEE74BD843B1A4D0046BA4720B6BD38E", hash_generated_method = "0BB3D61C4F23F20B35E10D49AE121700")
    
public POP3MessageInfo listMessage(int messageId) throws IOException
    {
        if (getState() != TRANSACTION_STATE)
            return null;
        if (sendCommand(POP3Command.LIST, Integer.toString(messageId))
                != POP3Reply.OK)
            return null;
        return __parseStatus(_lastReplyLine.substring(3));
    }


    /***
     * List all messages.  A list attempt can only
     * succeed if the client is in the
     * {@link org.apache.commons.net.pop3.POP3#TRANSACTION_STATE TRANSACTION_STATE }
     * .  Returns an array of POP3MessageInfo instances,
     * each containing the number of a message and its size in bytes.
     * If there are no messages, this method returns a zero length array.
     * If the list attempt fails, it returns null.
     * <p>
     * @return An array of POP3MessageInfo instances representing all messages
     * in the order they appear in the mailbox,
     * each containing the number of a message and its size in bytes.
     * If there are no messages, this method returns a zero length array.
     * If the list attempt fails, it returns null.
     * @exception IOException If a network I/O error occurs in the process of
     *     sending the list command.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.051 -0500", hash_original_method = "DDFC1ED28B13936429EE165DDE5450D7", hash_generated_method = "2F2C0AB437F87DA3E34E5BE78773D370")
    
public POP3MessageInfo[] listMessages() throws IOException
    {
        POP3MessageInfo[] messages;
        Enumeration en;
        int line;

        if (getState() != TRANSACTION_STATE)
            return null;
        if (sendCommand(POP3Command.LIST) != POP3Reply.OK)
            return null;
        getAdditionalReply();

        // This could be a zero length array if no messages present
        messages = new POP3MessageInfo[_replyLines.size() - 2];
        en = _replyLines.elements();

        // Skip first line
        en.nextElement();

        // Fetch lines.
        for (line = 0; line < messages.length; line++)
            messages[line] = __parseStatus((String)en.nextElement());

        return messages;
    }

    /***
     * List the unique identifier for a message.  A list attempt can only
     * succeed if the client is in the
     * {@link org.apache.commons.net.pop3.POP3#TRANSACTION_STATE TRANSACTION_STATE }
     * .  Returns a POP3MessageInfo instance
     * containing the number of the listed message and the
     * unique identifier for that message.  Returns null if the list
     * attempt fails  (e.g., if the specified message number does
     * not exist).
     * <p>
     * @param messageId  The number of the message list.
     * @return A POP3MessageInfo instance containing the number of the
     *         listed message and the unique identifier for that message.
     *         Returns null if the list attempt fails.
     * @exception IOException If a network I/O error occurs in the process of
     *        sending the list unique identifier command.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.055 -0500", hash_original_method = "97FA63A39EF1F832B30B106ACDF49656", hash_generated_method = "D17EC4DCCCEB67D8CB8D21B26F3815CD")
    
public POP3MessageInfo listUniqueIdentifier(int messageId)
    throws IOException
    {
        if (getState() != TRANSACTION_STATE)
            return null;
        if (sendCommand(POP3Command.UIDL, Integer.toString(messageId))
                != POP3Reply.OK)
            return null;
        return __parseUID(_lastReplyLine.substring(3));
    }


    /***
     * List the unique identifiers for all messages.  A list attempt can only
     * succeed if the client is in the
     * {@link org.apache.commons.net.pop3.POP3#TRANSACTION_STATE TRANSACTION_STATE }
     * .  Returns an array of POP3MessageInfo instances,
     * each containing the number of a message and its unique identifier.
     * If there are no messages, this method returns a zero length array.
     * If the list attempt fails, it returns null.
     * <p>
     * @return An array of POP3MessageInfo instances representing all messages
     * in the order they appear in the mailbox,
     * each containing the number of a message and its unique identifier
     * If there are no messages, this method returns a zero length array.
     * If the list attempt fails, it returns null.
     * @exception IOException If a network I/O error occurs in the process of
     *     sending the list unique identifier command.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.058 -0500", hash_original_method = "35097E2BB8A98BB5788B3206C81EC891", hash_generated_method = "FE6BEE4220CD172A18BA7FB528610FE0")
    
public POP3MessageInfo[] listUniqueIdentifiers() throws IOException
    {
        POP3MessageInfo[] messages;
        Enumeration en;
        int line;

        if (getState() != TRANSACTION_STATE)
            return null;
        if (sendCommand(POP3Command.UIDL) != POP3Reply.OK)
            return null;
        getAdditionalReply();

        // This could be a zero length array if no messages present
        messages = new POP3MessageInfo[_replyLines.size() - 2];
        en = _replyLines.elements();

        // Skip first line
        en.nextElement();

        // Fetch lines.
        for (line = 0; line < messages.length; line++)
            messages[line] = __parseUID((String)en.nextElement());

        return messages;
    }


    /***
     * Retrieve a message from the POP3 server.  A retrieve message attempt
     * can only succeed if the client is in the
     * {@link org.apache.commons.net.pop3.POP3#TRANSACTION_STATE TRANSACTION_STATE }
     * .  Returns a DotTerminatedMessageReader instance
     * from which the entire message can be read.
     * Returns null if the retrieval attempt fails  (e.g., if the specified
     * message number does not exist).
     * <p>
     * You must not issue any commands to the POP3 server (i.e., call any
     * other methods) until you finish reading the message from the
     * returned Reader instance.
     * The POP3 protocol uses the same stream for issuing commands as it does
     * for returning results.  Therefore the returned Reader actually reads
     * directly from the POP3 connection.  After the end of message has been
     * reached, new commands can be executed and their replies read.  If
     * you do not follow these requirements, your program will not work
     * properly.
     * <p>
     * @param messageId  The number of the message to fetch.
     * @return A DotTerminatedMessageReader instance
     * from which the entire message can be read.
     * Returns null if the retrieval attempt fails  (e.g., if the specified
     * message number does not exist).
     * @exception IOException If a network I/O error occurs in the process of
     *        sending the retrieve message command.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.061 -0500", hash_original_method = "89CCF1D056738205766B48A30FF311CE", hash_generated_method = "E5DC43EC8BDE799E91EAAB2FDD2626F9")
    
public Reader retrieveMessage(int messageId) throws IOException
    {
        if (getState() != TRANSACTION_STATE)
            return null;
        if (sendCommand(POP3Command.RETR, Integer.toString(messageId))
                != POP3Reply.OK)
            return null;

        return new DotTerminatedMessageReader(_reader);
    }


    /***
     * Retrieve only the specified top number of lines of a message from the
     * POP3 server.  A retrieve top lines attempt
     * can only succeed if the client is in the
     * {@link org.apache.commons.net.pop3.POP3#TRANSACTION_STATE TRANSACTION_STATE }
     * .  Returns a DotTerminatedMessageReader instance
     * from which the specified top number of lines of the message can be
     * read.
     * Returns null if the retrieval attempt fails  (e.g., if the specified
     * message number does not exist).
     * <p>
     * You must not issue any commands to the POP3 server (i.e., call any
     * other methods) until you finish reading the message from the returned
     * Reader instance.
     * The POP3 protocol uses the same stream for issuing commands as it does
     * for returning results.  Therefore the returned Reader actually reads
     * directly from the POP3 connection.  After the end of message has been
     * reached, new commands can be executed and their replies read.  If
     * you do not follow these requirements, your program will not work
     * properly.
     * <p>
     * @param messageId  The number of the message to fetch.
     * @param numLines  The top number of lines to fetch. This must be >= 0.
     * @return  A DotTerminatedMessageReader instance
     * from which the specified top number of lines of the message can be
     * read.
     * Returns null if the retrieval attempt fails  (e.g., if the specified
     * message number does not exist).
     * @exception IOException If a network I/O error occurs in the process of
     *       sending the top command.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:13.064 -0500", hash_original_method = "DA0B77A536DB46B42F7ECFE3C80518ED", hash_generated_method = "A5C415659CFC4EBDC80B964E0284E116")
    
public Reader retrieveMessageTop(int messageId, int numLines)
    throws IOException
    {
        if (numLines < 0 || getState() != TRANSACTION_STATE)
            return null;
        if (sendCommand(POP3Command.TOP, Integer.toString(messageId) + " " +
                        Integer.toString(numLines)) != POP3Reply.OK)
            return null;

        return new DotTerminatedMessageReader(_reader);
    }


}

