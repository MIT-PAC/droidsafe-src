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
* Conditions Of Use
*
* This software was developed by employees of the National Institute of
* Standards and Technology (NIST), an agency of the Federal Government.
* Pursuant to title 15 Untied States Code Section 105, works of NIST
* employees are not subject to copyright protection in the United States
* and are considered to be in the public domain.  As a result, a formal
* license is not needed to use the software.
*
* This software is provided by NIST as a service and is expressly
* provided "AS IS."  NIST MAKES NO WARRANTY OF ANY KIND, EXPRESS, IMPLIED
* OR STATUTORY, INCLUDING, WITHOUT LIMITATION, THE IMPLIED WARRANTY OF
* MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NON-INFRINGEMENT
* AND DATA ACCURACY.  NIST does not warrant or make any representations
* regarding the use of the software or the results thereof, including but
* not limited to the correctness, accuracy, reliability or usefulness of
* the software.
*
* Permission to use this software is contingent upon your acceptance
* of the terms of this agreement
*
* .
*
*/
/*******************************************************************************
 *   Product of NIST/ITL Advanced Networking Technologies Division (ANTD).     *
 *******************************************************************************/

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.HostPort;
import gov.nist.core.InternalErrorHandler;
import gov.nist.core.ThreadAuditor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.LinkedList;

public class UDPMessageProcessor extends MessageProcessor {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.805 -0500", hash_original_field = "31666E6E3E5C4C26BFC0A376D4995E68", hash_generated_field = "174D18645F1F98D2E6C01C2210EC5A14")
    
    private static final int HIGHWAT=5000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.807 -0500", hash_original_field = "E9A642E1E18EC1B098FBB67D335F80A1", hash_generated_field = "A95D179CF5D63D2E6F42DEFD017C99EB")
    
    private static final int LOWAT=2500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.788 -0500", hash_original_field = "5A948EF636511EF149269A68FE278AED", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.790 -0500", hash_original_field = "899066B5154C46A0CE38623F49497FA5", hash_generated_field = "C93CF307E97B9E62367601E63458BFCC")

    protected LinkedList messageQueue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.793 -0500", hash_original_field = "666F47260F88D884F01B285E3DC87045", hash_generated_field = "6AE79C808B860BF3147A11B4D0A7A4B0")

    protected LinkedList messageChannels;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.796 -0500", hash_original_field = "51874B13F0416651AA3D217A8A15B428", hash_generated_field = "C7EB24484DBA63450BB85C2FA7FA489F")

    protected int threadPoolSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.799 -0500", hash_original_field = "570524509F5F5D66C6CE0605580E6777", hash_generated_field = "43E95EAF82890431E324C86C2CA01A7C")

    protected DatagramSocket sock;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.802 -0500", hash_original_field = "5EBE085FDB38216257993802E75ABBBF", hash_generated_field = "911E18F9BE05473489F5F21C894DF579")

    protected boolean isRunning;

    /**
     * Constructor.
     *
     * @param sipStack
     *            pointer to the stack.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.811 -0500", hash_original_method = "B90AB6AB06537F29C47617DE501651D0", hash_generated_method = "9764C9C9E0408BF9C54778E5EB734420")
    
protected UDPMessageProcessor(InetAddress ipAddress,
            SIPTransactionStack sipStack, int port) throws IOException {
        super(ipAddress, port, "udp",sipStack);

        this.sipStack = sipStack;

        this.messageQueue = new LinkedList();

        this.port = port;
        try {
            this.sock = sipStack.getNetworkLayer().createDatagramSocket(port,
                    ipAddress);
            // Create a new datagram socket.
            sock.setReceiveBufferSize(sipStack.getReceiveUdpBufferSize());
            sock.setSendBufferSize(sipStack.getSendUdpBufferSize());

            /**
             * If the thread auditor is enabled, define a socket timeout value in order to
             * prevent sock.receive() from blocking forever
             */
            if (sipStack.getThreadAuditor().isEnabled()) {
                sock.setSoTimeout((int) sipStack.getThreadAuditor().getPingIntervalInMillisecs());
            }
            if ( ipAddress.getHostAddress().equals(IN_ADDR_ANY)  ||
                 ipAddress.getHostAddress().equals(IN6_ADDR_ANY)){
                // Store the address to which we are actually bound
                // Note that on WINDOWS this is actually broken. It will
                // return IN_ADDR_ANY again. On linux it will return the
                // address to which the socket was actually bound.
                super.setIpAddress( sock.getLocalAddress() );

            }
        } catch (SocketException ex) {
            throw new IOException(ex.getMessage());
        }
    }

    /**
     * Get port on which to listen for incoming stuff.
     *
     * @return port on which I am listening.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.813 -0500", hash_original_method = "1804D4B8ED6914D43C8BF926A65BA4F9", hash_generated_method = "2827709310D4A6354CC4E0B95B5C1D5F")
    
public int getPort() {
        return this.port;
    }

    /**
     * Start our processor thread.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.817 -0500", hash_original_method = "5E3073F0FEC53FA8E5673A840E14FE8B", hash_generated_method = "E9579E9C6D35736EB98E8A83BB7E0C9E")
    
public void start() throws IOException {

        this.isRunning = true;
        Thread thread = new Thread(this);
        thread.setDaemon(true);
        // Issue #32 on java.net
        thread.setName("UDPMessageProcessorThread");
        // Issue #184
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }

    /**
     * Thread main routine.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.823 -0500", hash_original_method = "5BA484CD985BE2E9792A2B4863AB23E2", hash_generated_method = "106D90FA668A6BA44AF7F4BC54AA527C")
    
public void run() {
        // Check for running flag.
        this.messageChannels = new LinkedList();
        // start all our messageChannels (unless the thread pool size is
        // infinity.
        if (sipStack.threadPoolSize != -1) {
            for (int i = 0; i < sipStack.threadPoolSize; i++) {
                UDPMessageChannel channel = new UDPMessageChannel(sipStack,
                        this);
                this.messageChannels.add(channel);

            }
        }

        // Ask the auditor to monitor this thread
        ThreadAuditor.ThreadHandle threadHandle = sipStack.getThreadAuditor().addCurrentThread();

        // Somebody asked us to exit. if isRunnning is set to false.
        while (this.isRunning) {

            try {
                // Let the thread auditor know we're up and running
                threadHandle.ping();

                int bufsize = sock.getReceiveBufferSize();
                byte message[] = new byte[bufsize];
                DatagramPacket packet = new DatagramPacket(message, bufsize);
                sock.receive(packet);
             
             // This is a simplistic congestion control algorithm.
             // It accepts packets if queuesize is < LOWAT. It drops
             // requests if the queue size exceeds a HIGHWAT and accepts
             // requests with probability p proportional to the difference
             // between current queue size and LOWAT in the range
             // of queue sizes between HIGHWAT and LOWAT.
             // TODO -- penalize spammers by looking at the source
             // port and IP address.
             if ( sipStack.stackDoesCongestionControl ) {  
             if ( this.messageQueue.size() >= HIGHWAT) {
                    if (sipStack.isLoggingEnabled()) {
                        sipStack.getStackLogger().logDebug("Dropping message -- queue length exceeded");

                    }
                    //System.out.println("HIGHWAT Drop!");
                    continue;
                } else if ( this.messageQueue.size() > LOWAT && this .messageQueue.size() < HIGHWAT ) {
                    // Drop the message with a probabilty that is linear in the range 0 to 1
                    float threshold = ((float)(messageQueue.size() - LOWAT))/ ((float)(HIGHWAT - LOWAT));
                    boolean decision = Math.random() > 1.0 - threshold;
                    if ( decision ) {
                        if (sipStack.isLoggingEnabled()) {
                            sipStack.getStackLogger().logDebug("Dropping message with probability  " + (1.0 - threshold));

                        }
                        //System.out.println("RED Drop!");
                        continue;
                    }

                }
             }
                
                // Count of # of packets in process.
                // this.useCount++;
                if (sipStack.threadPoolSize != -1) {
                    // Note: the only condition watched for by threads
                    // synchronizing on the messageQueue member is that it is
                    // not empty. As soon as you introduce some other
                    // condition you will have to call notifyAll instead of
                    // notify below.

                    synchronized (this.messageQueue) {
                        // was addLast
                        this.messageQueue.add(packet);
                        this.messageQueue.notify();
                    }
                } else {
                    new UDPMessageChannel(sipStack, this, packet);
                }
            } catch (SocketTimeoutException ex) {
              // This socket timeout alows us to ping the thread auditor periodically
            } catch (SocketException ex) {
                if (sipStack.isLoggingEnabled())
                    getSIPStack().getStackLogger()
                            .logDebug("UDPMessageProcessor: Stopping");
                isRunning = false;
                // The notifyAll should be in a synchronized block.
                // ( bug report by Niklas Uhrberg ).
                synchronized (this.messageQueue) {
                    this.messageQueue.notifyAll();
                }
            } catch (IOException ex) {
                isRunning = false;
                ex.printStackTrace();
                if (sipStack.isLoggingEnabled())
                    getSIPStack().getStackLogger()
                            .logDebug("UDPMessageProcessor: Got an IO Exception");
            } catch (Exception ex) {
                if (sipStack.isLoggingEnabled())
                    getSIPStack().getStackLogger()
                            .logDebug("UDPMessageProcessor: Unexpected Exception - quitting");
                InternalErrorHandler.handleException(ex);
                return;
            }
        }
    }

    /**
     * Shut down the message processor. Close the socket for recieving incoming
     * messages.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.826 -0500", hash_original_method = "98470A6BD6E1C018549BCC7706D1DEF2", hash_generated_method = "54487B663FB40F0AC0F04BC7B3F08FC1")
    
public void stop() {
        synchronized (this.messageQueue) {
            this.isRunning = false;
            this.messageQueue.notifyAll();
            sock.close();

        }
    }

    /**
     * Return the transport string.
     *
     * @return the transport string
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.828 -0500", hash_original_method = "026D790579A301E1D49F85E52A57E43F", hash_generated_method = "CD9CE3D74F8F4DF958703CD9EEEFCC32")
    
public String getTransport() {
        return "udp";
    }

    /**
     * Returns the stack.
     *
     * @return my sip stack.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.831 -0500", hash_original_method = "4789C177AC8ECE60B231BA8A866F9D66", hash_generated_method = "7DFF2B9EFB272B5F349D68AD73E9A18C")
    
public SIPTransactionStack getSIPStack() {
        return sipStack;
    }

    /**
     * Create and return new TCPMessageChannel for the given host/port.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.834 -0500", hash_original_method = "886709B501C0AFC116858EC5EEF3AF72", hash_generated_method = "FF7142E40F3C67BB9E9DD08AA3829490")
    
public MessageChannel createMessageChannel(HostPort targetHostPort)
            throws UnknownHostException {
        return new UDPMessageChannel(targetHostPort.getInetAddress(),
                targetHostPort.getPort(), sipStack, this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.837 -0500", hash_original_method = "3D05557B9B28DB0617B949ABC7CCF983", hash_generated_method = "3953ABF7DDBDFD643B2FB6E831F38326")
    
public MessageChannel createMessageChannel(InetAddress host, int port)
            throws IOException {
        return new UDPMessageChannel(host, port, sipStack, this);
    }

    /**
     * Default target port for UDP
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.839 -0500", hash_original_method = "549BD73BE1E8477C39668DF3AD0A0CF5", hash_generated_method = "A974BC08491FBE134376CBCCEE27369D")
    
public int getDefaultTargetPort() {
        return 5060;
    }

    /**
     * UDP is not a secure protocol.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.842 -0500", hash_original_method = "51201694E0EE76265BF39848EF10BE9C", hash_generated_method = "49E6B3D175AEB85C0CC035D6E473FA9A")
    
public boolean isSecure() {
        return false;
    }

    /**
     * UDP can handle a message as large as the MAX_DATAGRAM_SIZE.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.845 -0500", hash_original_method = "DB826EFA52B3A7F2C697730E780269B9", hash_generated_method = "BE8008A8AE67B0186FA945333D8EF3B1")
    
public int getMaximumMessageSize() {
        return 8*1024;
    }

    /**
     * Return true if there are any messages in use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.848 -0500", hash_original_method = "08919BACEEB275448156EA2ACF7B3D6A", hash_generated_method = "43830782CE56377739CB711511AC20E1")
    
public boolean inUse() {
        synchronized (messageQueue) {
            return messageQueue.size() != 0;
        }
    }
}

