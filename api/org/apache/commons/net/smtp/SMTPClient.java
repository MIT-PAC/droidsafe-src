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
import java.io.IOException;
import java.io.Writer;
import java.net.InetAddress;
import org.apache.commons.net.io.DotTerminatedMessageWriter;

/***
 * SMTPClient encapsulates all the functionality necessary to send files
 * through an SMTP server.  This class takes care of all
 * low level details of interacting with an SMTP server and provides
 * a convenient higher level interface.  As with all classes derived
 * from {@link org.apache.commons.net.SocketClient},
 * you must first connect to the server with
 * {@link org.apache.commons.net.SocketClient#connect  connect }
 * before doing anything, and finally
 * {@link org.apache.commons.net.SocketClient#disconnect  disconnect }
 * after you're completely finished interacting with the server.
 * Then you need to check the SMTP reply code to see if the connection
 * was successful.  For example:
 * <pre>
 *    try {
 *      int reply;
 *      client.connect("mail.foobar.com");
 *      System.out.print(client.getReplyString());
 *
 *      // After connection attempt, you should check the reply code to verify
 *      // success.
 *      reply = client.getReplyCode();
 *
 *      if(!SMTPReply.isPositiveCompletion(reply)) {
 *        client.disconnect();
 *        System.err.println("SMTP server refused connection.");
 *        System.exit(1);
 *      }
 *
 *      // Do useful stuff here.
 *      ...
 *    } catch(IOException e) {
 *      if(client.isConnected()) {
 *        try {
 *          client.disconnect();
 *        } catch(IOException f) {
 *          // do nothing
 *        }
 *      }
 *      System.err.println("Could not connect to server.");
 *      e.printStackTrace();
 *      System.exit(1);
 *    }
 * </pre>
 * <p>
 * Immediately after connecting is the only real time you need to check the
 * reply code (because connect is of type void).  The convention for all the
 * SMTP command methods in SMTPClient is such that they either return a
 * boolean value or some other value.
 * The boolean methods return true on a successful completion reply from
 * the SMTP server and false on a reply resulting in an error condition or
 * failure.  The methods returning a value other than boolean return a value
 * containing the higher level data produced by the SMTP command, or null if a
 * reply resulted in an error condition or failure.  If you want to access
 * the exact SMTP reply code causing a success or failure, you must call
 * {@link org.apache.commons.net.smtp.SMTP#getReplyCode  getReplyCode } after
 * a success or failure.
 * <p>
 * You should keep in mind that the SMTP server may choose to prematurely
 * close a connection for various reasons.  The SMTPClient class will detect a
 * premature SMTP server connection closing when it receives a
 * {@link org.apache.commons.net.smtp.SMTPReply#SERVICE_NOT_AVAILABLE SMTPReply.SERVICE_NOT_AVAILABLE }
 *  response to a command.
 * When that occurs, the method encountering that reply will throw
 * an {@link org.apache.commons.net.smtp.SMTPConnectionClosedException}
 * .
 * <code>SMTPConectionClosedException</code>
 * is a subclass of <code> IOException </code> and therefore need not be
 * caught separately, but if you are going to catch it separately, its
 * catch block must appear before the more general <code> IOException </code>
 * catch block.  When you encounter an
 * {@link org.apache.commons.net.smtp.SMTPConnectionClosedException}
 * , you must disconnect the connection with
 * {@link #disconnect  disconnect() } to properly clean up the
 * system resources used by SMTPClient.  Before disconnecting, you may check
 * the last reply code and text with
 * {@link org.apache.commons.net.smtp.SMTP#getReplyCode  getReplyCode },
 * {@link org.apache.commons.net.smtp.SMTP#getReplyString  getReplyString },
 * and
 * {@link org.apache.commons.net.smtp.SMTP#getReplyStrings getReplyStrings}.
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
 * @see SMTP
 * @see SimpleSMTPHeader
 * @see RelayPath
 * @see SMTPConnectionClosedException
 * @see org.apache.commons.net.MalformedServerReplyException
 ***/

public class SMTPClient extends SMTP
{

    /*
     * Default SMTPClient constructor.  Creates a new SMTPClient instance.
     */
    //public SMTPClient() {  }


    /***
     * At least one SMTPClient method ({@link #sendMessageData  sendMessageData })
     * does not complete the entire sequence of SMTP commands to complete a
     * transaction.  These types of commands require some action by the
     * programmer after the reception of a positive intermediate command.
     * After the programmer's code completes its actions, it must call this
     * method to receive the completion reply from the server and verify the
     * success of the entire transaction.
     * <p>
     * For example,
     * <pre>
     * writer = client.sendMessage();
     * if(writer == null) // failure
     *   return false;
     * header =
     *  new SimpleSMTPHeader("foobar@foo.com", "foo@foobar.com", "Re: Foo");
     * writer.write(header.toString());
     * writer.write("This is just a test");
     * writer.close();
     * if(!client.completePendingCommand()) // failure
     *   return false;
     * </pre>
     * <p>
     * @return True if successfully completed, false if not.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.893 -0500", hash_original_method = "BFA0A8FEA8E06D6A267D67FA4CCF091B", hash_generated_method = "256489EB04C9F3CD609596048359BA7D")
    
public boolean completePendingCommand() throws IOException
    {
        return SMTPReply.isPositiveCompletion(getReply());
    }


    /***
     * Login to the SMTP server by sending the HELO command with the
     * given hostname as an argument.  Before performing any mail commands,
     * you must first login.
     * <p>
     * @param hostname  The hostname with which to greet the SMTP server.
     * @return True if successfully completed, false if not.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.897 -0500", hash_original_method = "ADC5687DD367DA748E87D370EBAA626A", hash_generated_method = "9EE693998BA7A36A3A10E2F3EB609F02")
    
public boolean login(String hostname) throws IOException
    {
        return SMTPReply.isPositiveCompletion(helo(hostname));
    }


    /***
     * Login to the SMTP server by sending the HELO command with the
     * client hostname as an argument.  Before performing any mail commands,
     * you must first login.
     * <p>
     * @return True if successfully completed, false if not.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.901 -0500", hash_original_method = "9284A49878E24579805D9B3A83B65918", hash_generated_method = "5026640DDE838AB1D7C568964116B628")
    
public boolean login() throws IOException
    {
        String name;
        InetAddress host;

        host = getLocalAddress();
        name = host.getHostName();

        if (name == null)
            return false;

        return SMTPReply.isPositiveCompletion(helo(name));
    }


    /***
     * Set the sender of a message using the SMTP MAIL command, specifying
     * a reverse relay path.  The sender must be set first before any
     * recipients may be specified, otherwise the mail server will reject
     * your commands.
     * <p>
     * @param path  The reverse relay path pointing back to the sender.
     * @return True if successfully completed, false if not.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.905 -0500", hash_original_method = "A1B2D3D68C3A7DEE0788CB81C0FF13CB", hash_generated_method = "1DC0A2D0572E79AF86DDF8883FF2BA8D")
    
public boolean setSender(RelayPath path) throws IOException
    {
        return SMTPReply.isPositiveCompletion(mail(path.toString()));
    }


    /***
     * Set the sender of a message using the SMTP MAIL command, specifying
     * the sender's email address. The sender must be set first before any
     * recipients may be specified, otherwise the mail server will reject
     * your commands.
     * <p>
     * @param address  The sender's email address.
     * @return True if successfully completed, false if not.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.909 -0500", hash_original_method = "B1F5B3A988F172353F08FDEFCB4418C8", hash_generated_method = "7CE41911B29D32F7EB7077BFBD8F53E5")
    
public boolean setSender(String address) throws IOException
    {
        return SMTPReply.isPositiveCompletion(mail("<" + address + ">"));
    }


    /***
     * Add a recipient for a message using the SMTP RCPT command, specifying
     * a forward relay path.  The sender must be set first before any
     * recipients may be specified, otherwise the mail server will reject
     * your commands.
     * <p>
     * @param path  The forward relay path pointing to the recipient.
     * @return True if successfully completed, false if not.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.912 -0500", hash_original_method = "60C6DD13258E5D92FEA078E8C5222031", hash_generated_method = "271B53BA67E51E525EF7141EC3F65BC7")
    
public boolean addRecipient(RelayPath path) throws IOException
    {
        return SMTPReply.isPositiveCompletion(rcpt(path.toString()));
    }


    /***
     * Add a recipient for a message using the SMTP RCPT command, the
     * recipient's email address.  The sender must be set first before any
     * recipients may be specified, otherwise the mail server will reject
     * your commands.
     * <p>
     * @param address  The recipient's email address.
     * @return True if successfully completed, false if not.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.916 -0500", hash_original_method = "535370C087A055BCC54FD714FA277330", hash_generated_method = "F61C3E3B4781D082849D9D094BC24EF1")
    
public boolean addRecipient(String address) throws IOException
    {
        return SMTPReply.isPositiveCompletion(rcpt("<" + address + ">"));
    }



    /***
     * Send the SMTP DATA command in preparation to send an email message.
     * This method returns a DotTerminatedMessageWriter instance to which
     * the message can be written.  Null is returned if the DATA command
     * fails.
     * <p>
     * You must not issue any commands to the SMTP server (i.e., call any
     * (other methods) until you finish writing to the returned Writer
     * instance and close it.  The SMTP protocol uses the same stream for
     * issuing commands as it does for returning results.  Therefore the
     * returned Writer actually writes directly to the SMTP connection.
     * After you close the writer, you can execute new commands.  If you
     * do not follow these requirements your program will not work properly.
     * <p>
     * You can use the provided
     * {@link org.apache.commons.net.smtp.SimpleSMTPHeader}
     * class to construct a bare minimum header.
     * To construct more complicated headers you should
     * refer to RFC 822.  When the Java Mail API is finalized, you will be
     * able to use it to compose fully compliant Internet text messages.
     * The DotTerminatedMessageWriter takes care of doubling line-leading
     * dots and ending the message with a single dot upon closing, so all
     * you have to worry about is writing the header and the message.
     * <p>
     * Upon closing the returned Writer, you need to call
     * {@link #completePendingCommand  completePendingCommand() }
     * to finalize the transaction and verify its success or failure from
     * the server reply.
     * <p>
     * @return A DotTerminatedMessageWriter to which the message (including
     *      header) can be written.  Returns null if the command fails.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.921 -0500", hash_original_method = "3CE926AFC3A0744468CAB1714BF35B0D", hash_generated_method = "656009A6922DA839F09EB24B03E1B99D")
    
public Writer sendMessageData() throws IOException
    {
        if (!SMTPReply.isPositiveIntermediate(data()))
            return null;

        return new DotTerminatedMessageWriter(_writer);
    }


    /***
     * A convenience method for sending short messages.  This method fetches
     * the Writer returned by {@link #sendMessageData  sendMessageData() }
     * and writes the specified String to it.  After writing the message,
     * this method calls {@link #completePendingCommand completePendingCommand() }
     *  to finalize the transaction and returns
     * its success or failure.
     * <p>
     * @param message  The short email message to send.
     * @return True if successfully completed, false if not.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.929 -0500", hash_original_method = "7B89051DA90849929443A02F47B1E028", hash_generated_method = "A3D159AC352612B215386DC8E6BBF4F9")
    
public boolean sendShortMessageData(String message) throws IOException
    {
        Writer writer;

        writer = sendMessageData();

        if (writer == null)
            return false;

        writer.write(message);
        writer.close();

        return completePendingCommand();
    }


    /***
     * A convenience method for a sending short email without having to
     * explicitly set the sender and recipient(s).  This method
     * sets the sender and recipient using
     * {@link #setSender  setSender } and
     * {@link #addRecipient  addRecipient }, and then sends the
     * message using {@link #sendShortMessageData  sendShortMessageData }.
     * <p>
     * @param sender  The email address of the sender.
     * @param recipient  The email address of the recipient.
     * @param message  The short email message to send.
     * @return True if successfully completed, false if not.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.933 -0500", hash_original_method = "92647114F0B86067E7D43CC90DB0EBBE", hash_generated_method = "4558FF435C34BA54D2D4F3B6B39E0B7B")
    
public boolean sendSimpleMessage(String sender, String recipient,
                                     String message)
    throws IOException
    {
        if (!setSender(sender))
            return false;

        if (!addRecipient(recipient))
            return false;

        return sendShortMessageData(message);
    }



    /***
     * A convenience method for a sending short email without having to
     * explicitly set the sender and recipient(s).  This method
     * sets the sender and recipients using
     * {@link #setSender  setSender } and
     * {@link #addRecipient  addRecipient }, and then sends the
     * message using {@link #sendShortMessageData  sendShortMessageData }.
     * <p>
     * @param sender  The email address of the sender.
     * @param recipients  An array of recipient email addresses.
     * @param message  The short email message to send.
     * @return True if successfully completed, false if not.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.937 -0500", hash_original_method = "5AD2FE5C3CFE682A970F0638BE91A64C", hash_generated_method = "879DAC5FC115025C63FF204819E0C22B")
    
public boolean sendSimpleMessage(String sender, String[] recipients,
                                     String message)
    throws IOException
    {
        boolean oneSuccess = false;
        int count;

        if (!setSender(sender))
            return false;

        for (count = 0; count < recipients.length; count++)
        {
            if (addRecipient(recipients[count]))
                oneSuccess = true;
        }

        if (!oneSuccess)
            return false;

        return sendShortMessageData(message);
    }


    /***
     * Logout of the SMTP server by sending the QUIT command.
     * <p>
     * @return True if successfully completed, false if not.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.941 -0500", hash_original_method = "86625BE6BC74680BCE9F9FD0AA53BF54", hash_generated_method = "8AE8656DED621D60E849739B60BF3CA8")
    
public boolean logout() throws IOException
    {
        return SMTPReply.isPositiveCompletion(quit());
    }



    /***
     * Aborts the current mail transaction, resetting all server stored
     * sender, recipient, and mail data, cleaing all buffers and tables.
     * <p>
     * @return True if successfully completed, false if not.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.944 -0500", hash_original_method = "D3B7CEC20A124B5B8658676D7721D307", hash_generated_method = "2B4C16F7BEE7A65CECC0B61F85D894BA")
    
public boolean reset() throws IOException
    {
        return SMTPReply.isPositiveCompletion(rset());
    }


    /***
     * Verify that a username or email address is valid, i.e., that mail
     * can be delivered to that mailbox on the server.
     * <p>
     * @param username  The username or email address to validate.
     * @return True if the username is valid, false if not.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.948 -0500", hash_original_method = "4BA0FED02486EFBF4EE8334994DBE6CC", hash_generated_method = "CCB0D26414F71ECFF28E424750726E31")
    
public boolean verify(String username) throws IOException
    {
        int result;

        result = vrfy(username);

        return (result == SMTPReply.ACTION_OK ||
                result == SMTPReply.USER_NOT_LOCAL_WILL_FORWARD);
    }


    /***
     * Fetches the system help information from the server and returns the
     * full string.
     * <p>
     * @return The system help string obtained from the server.  null if the
     *       information could not be obtained.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *  command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.951 -0500", hash_original_method = "F9C41201775A1AACD21054779541BDEA", hash_generated_method = "3CA11E865E7B60B42B88D30C85038589")
    
public String listHelp() throws IOException
    {
        if (SMTPReply.isPositiveCompletion(help()))
            return getReplyString();
        return null;
    }


    /***
     * Fetches the help information for a given command from the server and
     * returns the full string.
     * <p>
     * @param command The command on which to ask for help.
     * @return The command help string obtained from the server.  null if the
     *       information could not be obtained.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *  command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.955 -0500", hash_original_method = "ACA58AE10EC88B0125C9A13993452736", hash_generated_method = "83BBE64308388E1E7664DAD362BEAF09")
    
public String listHelp(String command) throws IOException
    {
        if (SMTPReply.isPositiveCompletion(help(command)))
            return getReplyString();
        return null;
    }


    /***
     * Sends a NOOP command to the SMTP server.  This is useful for preventing
     * server timeouts.
     * <p>
     * @return True if successfully completed, false if not.
     * @exception SMTPConnectionClosedException
     *      If the SMTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send SMTP reply code 421.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.959 -0500", hash_original_method = "D41F1FA722E38C99947581A87108BCAE", hash_generated_method = "F0091385F9E85AF39D1057ADB6E82EB4")
    
public boolean sendNoOp() throws IOException
    {
        return SMTPReply.isPositiveCompletion(noop());
    }

}
