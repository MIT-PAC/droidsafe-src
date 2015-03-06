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

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Host;
import gov.nist.core.HostPort;
import gov.nist.core.ServerLogger;
import gov.nist.core.StackLogger;
import gov.nist.core.ThreadAuditor;
import gov.nist.core.net.AddressResolver;
import gov.nist.core.net.DefaultNetworkLayer;
import gov.nist.core.net.NetworkLayer;
import gov.nist.javax.sip.DefaultAddressResolver;
import gov.nist.javax.sip.ListeningPointImpl;
import gov.nist.javax.sip.LogRecordFactory;
import gov.nist.javax.sip.SIPConstants;
import gov.nist.javax.sip.SipListenerExt;
import gov.nist.javax.sip.SipProviderImpl;
import gov.nist.javax.sip.SipStackImpl;
import gov.nist.javax.sip.header.Event;
import gov.nist.javax.sip.header.Via;
import gov.nist.javax.sip.header.extensions.JoinHeader;
import gov.nist.javax.sip.header.extensions.ReplacesHeader;
import gov.nist.javax.sip.message.SIPMessage;
import gov.nist.javax.sip.message.SIPRequest;
import gov.nist.javax.sip.message.SIPResponse;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.sip.ClientTransaction;
import javax.sip.Dialog;
import javax.sip.DialogState;
import javax.sip.DialogTerminatedEvent;
import javax.sip.ServerTransaction;
import javax.sip.SipException;
import javax.sip.SipListener;
import javax.sip.TransactionState;
import javax.sip.TransactionTerminatedEvent;
import javax.sip.address.Hop;
import javax.sip.address.Router;
import javax.sip.header.CallIdHeader;
import javax.sip.header.EventHeader;
import javax.sip.message.Request;
import javax.sip.message.Response;

public abstract class SIPTransactionStack implements SIPTransactionEventListener, SIPDialogEventListener {

    /**
     * Return true if extension is supported.
     *
     * @return true if extension is supported and false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.384 -0500", hash_original_method = "03B5B874C8C8B5BEFC94C8A05F3C90E1", hash_generated_method = "EAD6582951721693C41EB54DED044A7B")
    
public static boolean isDialogCreated(String method) {
    	return dialogCreatingMethods.contains(method);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.151 -0500", hash_original_field = "35AD0CE7B34CE648D0542F818833070B", hash_generated_field = "840B97A8669F66449D46242BA5765A0F")

    public static final int BASE_TIMER_INTERVAL = 500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.154 -0500", hash_original_field = "55CB1D89122B5003C672DBA34ABB7EE2", hash_generated_field = "F814FEC2CA6FC54407356E1DCD115382")

    public static final int CONNECTION_LINGER_TIME = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.167 -0500", hash_original_field = "79C80743808938CB5A4CE70EF311F43A", hash_generated_field = "2D1D1AE6B824DAFBEC80F6EDE67E49B0")

    protected static final Set<String> dialogCreatingMethods = new HashSet<String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.158 -0500", hash_original_field = "5BA114DA4C405DBB2E0BC2787119C3B2", hash_generated_field = "4492ED7A506BF07B68742FB955C2E21E")

    protected ConcurrentHashMap<String, SIPServerTransaction> retransmissionAlertTransactions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.161 -0500", hash_original_field = "B7D917E6C7E8D5A336494FD15231FEB2", hash_generated_field = "6B3C62483E89DF024C432E8562DE8605")

    protected ConcurrentHashMap<String, SIPDialog> earlyDialogTable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.164 -0500", hash_original_field = "F2491D7A8FCADDC9E7D73C20E68DCF14", hash_generated_field = "612ED1FD1C10487B0104807B8A4F66C6")

    protected ConcurrentHashMap<String, SIPDialog> dialogTable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.170 -0500", hash_original_field = "738C3D18449F14F8BF2AE2302B0A1011", hash_generated_field = "02D2240A23798B540E9F3183DC11EA33")

    private Timer timer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.172 -0500", hash_original_field = "EDB6FB65E564164218125DE3EF635033", hash_generated_field = "32E72097D41FA2F9AA2F04A4F6D94614")

    private ConcurrentHashMap<String, SIPServerTransaction> pendingTransactions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.175 -0500", hash_original_field = "54DEA70590075C49D41E4FEF76F55CE4", hash_generated_field = "1A605FBA2863EF25462941960BB549FD")

    private ConcurrentHashMap<String, SIPClientTransaction> clientTransactionTable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.178 -0500", hash_original_field = "BC33D7139721C956BF6FAA61DBBB2367", hash_generated_field = "1F786F43A2E25D3141E2216B91F6EAFE")

    protected boolean unlimitedServerTransactionTableSize = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.181 -0500", hash_original_field = "43A81C3DFE3B12E01E1A478535C1BF4D", hash_generated_field = "DD907A7A90AC49DD39A1CAABAC88BD51")

    protected boolean unlimitedClientTransactionTableSize = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.184 -0500", hash_original_field = "10B75398F6750B7917979A1270FAA0F8", hash_generated_field = "62BC1A584FE3D1886A98D8C5ABC21C6C")

    // after which requests are dropped.
    protected int serverTransactionTableHighwaterMark = 5000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.187 -0500", hash_original_field = "2448A8EE38485A7481F7461F5A51B28E", hash_generated_field = "40AA5FE89ECC724489075A7B280EAD54")

    // requests are selectively dropped
    protected int serverTransactionTableLowaterMark = 4000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.190 -0500", hash_original_field = "4EB1BCBA28A21CF1DEC9FD366BC996F1", hash_generated_field = "FAEAF8DD40DC852CBF7CB0D4FA64FBF9")

    // overriden by stack
    // configuration.
    protected int clientTransactionTableHiwaterMark = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.193 -0500", hash_original_field = "DD7C73235F06F59C03525D3BE7F6CFCC", hash_generated_field = "5D70C98F837CF3F9C68DD58DFD91E463")

    protected int clientTransactionTableLowaterMark = 800;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.195 -0500", hash_original_field = "6E1CCA4652B2ED673A0EC365B7862F60", hash_generated_field = "EF538D5EF9F88F93E351A9F5CBDE10BE")

    private AtomicInteger activeClientTransactionCount = new AtomicInteger(0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.199 -0500", hash_original_field = "532D49C905A8101F8E2F554E2195A1B3", hash_generated_field = "17FBAB4D0971040901BD780F89591315")

    private ConcurrentHashMap<String, SIPServerTransaction> serverTransactionTable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.202 -0500", hash_original_field = "4AF946F60094F37A3CD71BF0CE434211", hash_generated_field = "3135F89ACDA5E960076EB543AFD5A064")

    // requests.
    private ConcurrentHashMap<String, SIPServerTransaction> mergeTable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.205 -0500", hash_original_field = "82C9185A7E16A6A59F92B43200DC06C3", hash_generated_field = "811B28F45DE9105A274B1DBADE0F6CC9")
    
    private ConcurrentHashMap<String,SIPServerTransaction> terminatedServerTransactionsPendingAck;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.207 -0500", hash_original_field = "CDCBF1CE8F6BA688490996181003FE73", hash_generated_field = "71F6115AE3CDEA5C8D231C9BD5ACFE37")
    
    private ConcurrentHashMap<String,SIPClientTransaction> forkedClientTransactionTable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.210 -0500", hash_original_field = "2D0C8423C59960E3E35FFD59E5DE02BE", hash_generated_field = "1D505020FB0AD1A554D62BDC6FA8297B")

    private StackLogger stackLogger;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.213 -0500", hash_original_field = "51D95D964E01EF1C1070512AC564A290", hash_generated_field = "5C234A980E10BCEA9B12BAB676094BC2")

    protected ServerLogger serverLogger;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.215 -0500", hash_original_field = "1E6D363EB172CF0996091AF3F1ED1415", hash_generated_field = "1E6D363EB172CF0996091AF3F1ED1415")

    boolean udpFlag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.218 -0500", hash_original_field = "2952C1893FAB07461DBC9282C6A6CE70", hash_generated_field = "EF7A4245F4BE46C3FAE858ABF7DB8188")

    protected DefaultRouter defaultRouter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.220 -0500", hash_original_field = "4214D09500DCECBDE1BEF90BC5A3E740", hash_generated_field = "C4FB0B708AF2FF7CDFB610A006B5BB00")

    protected boolean needsLogging;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.223 -0500", hash_original_field = "A9F4783305737E925A9CE5623D052181", hash_generated_field = "39AC5AA3A559BB385B76BB7FCEA06FC5")

    private boolean non2XXAckPassedToListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.227 -0500", hash_original_field = "AD8E0B69B6678844F33FDF3541F7ED93", hash_generated_field = "33EBA2CEF834B663ED5264FE81682D84")

    protected IOHandler ioHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.229 -0500", hash_original_field = "F094DE5FE09D8C58EFE77FCDF1DE8980", hash_generated_field = "F86372B43141F18E4A8130BDC70E29CE")

    protected boolean toExit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.232 -0500", hash_original_field = "7BCB5F09DB7A9B6831940702C870FA28", hash_generated_field = "D4D760F2DD059CF6C01F0C862657BA20")

    protected String stackName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.236 -0500", hash_original_field = "2D7E687CF01873B04F36576D3179ADD7", hash_generated_field = "A47D9D5247AAB165B1980C5D8E37AD58")

    protected String stackAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.240 -0500", hash_original_field = "19DF648B25D0A1B4E8D0A4F644AB9C5D", hash_generated_field = "413081F93DE42EB68D8F08C864982E20")

    protected InetAddress stackInetAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.242 -0500", hash_original_field = "79097A7DEDA92435341406A3202B5F7A", hash_generated_field = "272D1016DEB62E744C52940A3B0E5489")

    protected StackMessageFactory sipMessageFactory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.245 -0500", hash_original_field = "220E46DAA56DCECC8AC92A26DB0C9B23", hash_generated_field = "66410D3E71DA473D001977FF3AD7B23B")

    protected javax.sip.address.Router router;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.248 -0500", hash_original_field = "51874B13F0416651AA3D217A8A15B428", hash_generated_field = "C7EB24484DBA63450BB85C2FA7FA489F")

    protected int threadPoolSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.251 -0500", hash_original_field = "CF1F23AB5460D986D85752F07123AEA1", hash_generated_field = "F74AE6C7EF47828D3A211878D3F5E9F3")

    protected int maxConnections;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.254 -0500", hash_original_field = "C205E81825BA9BDCEEF506D81DF27227", hash_generated_field = "3130D9CC177F737BBD6633DB37EE5BF1")

    protected boolean cacheServerConnections;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.257 -0500", hash_original_field = "C91E6E330CC21FF1E6430DB25E48943F", hash_generated_field = "768D8EDFC9A10AC079EBDEBB9B0BEA2F")

    protected boolean cacheClientConnections;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.260 -0500", hash_original_field = "A7D84B3112B2CD8F4D7F7CE1B897E46C", hash_generated_field = "F13115153A6685630697524CF8732D13")

    protected boolean useRouterForAll;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.262 -0500", hash_original_field = "7A14E3AB5D6C912E4A295202CF6F0D57", hash_generated_field = "DDA86EBC27B96B0FE9D286E6B5C99D02")

    protected int maxContentLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.265 -0500", hash_original_field = "22F0990BFBB825F63302151EEE1DEF9C", hash_generated_field = "224FB7FE4F1198F8C1E840FE28932770")

    protected int maxMessageSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.268 -0500", hash_original_field = "18B0CDE00602950A0F031A98807B985B", hash_generated_field = "185A572D15C5BAB5F976AA3554E06D13")

    private Collection<MessageProcessor> messageProcessors;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.271 -0500", hash_original_field = "665A6CAA499F4AF9E1413810B84B3FBE", hash_generated_field = "29792280DB9C85168DEBC57540E5C62A")

    protected int readTimeout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.274 -0500", hash_original_field = "A03208BE3485B5E0C912721B0049FEB7", hash_generated_field = "F280B3067DE1A528C7BB767557FE00A0")

    protected NetworkLayer networkLayer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.277 -0500", hash_original_field = "C22F3254E5704F00A018DEF249EF9C5F", hash_generated_field = "2DDBEDAE711DD575D314D6FB0824162C")

    protected String outboundProxy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.280 -0500", hash_original_field = "AB341CB2ADF3D6AFFFDFFB9107DE3154", hash_generated_field = "E23BB81A391AC77E4B947A6531D7CFF7")

    protected String routerPath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.283 -0500", hash_original_field = "CFBB34BE1495D6DF2007561A07AD27E7", hash_generated_field = "D8B07380FC751DD31F22EE149C2225BE")

    // support.
    protected boolean isAutomaticDialogSupportEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.286 -0500", hash_original_field = "D506A51E1569A2AE901D4625E2BF6790", hash_generated_field = "758951DC734FED546F5FA46D0CD9E244")

    protected HashSet<String> forkedEvents;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.289 -0500", hash_original_field = "C7BE2149C988DC0B68F8980D9CEF3162", hash_generated_field = "E3C6781710F35866C48FB724B6E9B0A5")

    protected boolean generateTimeStampHeader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.292 -0500", hash_original_field = "74F6A9BDF4B72193921A899D3F189485", hash_generated_field = "921A218F1E68F36119322B4C0375D302")

    protected AddressResolver addressResolver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.295 -0500", hash_original_field = "E3ED477FF2A77D9DB463FB2B537CF5AC", hash_generated_field = "3888550D44F5E861BA85B642CF2C6F45")

    // request. Default is "infinity". This property allows
    // containers to defend against buggy clients (that do not
    // want to respond to requests).
    protected int maxListenerResponseTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.298 -0500", hash_original_field = "55547B581E42F1F8D81194BAD26D971B", hash_generated_field = "8A488BDAE306C066724EE323AB62E747")

    // If this is set to true, then To tag checking on the Dialog layer is
    // disabled in a few places - resulting in possible breakage of forked dialogs.
    protected boolean rfc2543Supported = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.301 -0500", hash_original_field = "C98E501EDEE4A37AF9B4545B334001EC", hash_generated_field = "0058B8BA743D38840E6D75DA68324774")

    // the stack
    protected ThreadAuditor threadAuditor = new ThreadAuditor();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.304 -0500", hash_original_field = "3307441A1054D448E7A6134AD145150D", hash_generated_field = "F94964197FE0E44E12A6BA7E03E51754")

    protected LogRecordFactory logRecordFactory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.306 -0500", hash_original_field = "0E8FDE2FBAE1EFEE734BBDEFC5A8A6EA", hash_generated_field = "542419080B2B3EDAD3ED15F97E9B7DA1")

    // it out.
    protected boolean cancelClientTransactionChecked = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.309 -0500", hash_original_field = "32484FC0E72A3E346E6F09FBF57C3787", hash_generated_field = "BCB26F591F1846D975D03FEA861FFBFA")

    protected boolean remoteTagReassignmentAllowed = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.312 -0500", hash_original_field = "58111BB2FDEB7463664F942D1AE9824C", hash_generated_field = "046122FB4660CF86569D7745FB6062FC")

    protected boolean logStackTraceOnMessageSend = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.316 -0500", hash_original_field = "01E62941BAB768C310619671F2300CB3", hash_generated_field = "533CF057F33E79CEE3F6C6762D967990")

    protected int receiveUdpBufferSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.319 -0500", hash_original_field = "D8775BEB5DE93DF0880321033462A0A3", hash_generated_field = "9F0A96DC46E2BE3FA6703B7ECEFC7E7B")

    protected int sendUdpBufferSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.321 -0500", hash_original_field = "3341013F18ACE2BB8AA5357DA23E5F25", hash_generated_field = "D2F44B156E2C7DA4668C7D5F665DAB5F")

    protected boolean stackDoesCongestionControl = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.324 -0500", hash_original_field = "EBB3F9DF34B491C04F616208E7ACD0F6", hash_generated_field = "C468B3795A40E24BFA5E22186F8BD92C")

    protected boolean isBackToBackUserAgent = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.327 -0500", hash_original_field = "429A3001BEDE9B2B2DCC6DC2087EF8BA", hash_generated_field = "30B91514890DCCCE1053BFD830B93F8D")

    protected boolean checkBranchId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.330 -0500", hash_original_field = "897DFDEC0B0C97CCDC9046BD387C803D", hash_generated_field = "2CEA2AC21B7A7C73026A335F4F3A56EB")

	protected boolean isAutomaticDialogErrorHandlingEnabled = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.332 -0500", hash_original_field = "110A0B37735EF4E95CA694CEFE644BD2", hash_generated_field = "8D5939440DC97D0AD4D778E8F452B5A4")
	
	protected boolean isDialogTerminatedEventDeliveredForNullDialog = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.335 -0500", hash_original_field = "F81AF70FBD391317C0CE03E247905C36", hash_generated_field = "2F246E676C0E44CC01DDEB1AFF1CE632")

	// is not tracked. If you want to track the original transaction you need to specify
	// the max fork time with a stack init property.
	protected int maxForkTime = 0;
    
    /**
     * Default constructor.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.364 -0500", hash_original_method = "58A99E16B05D3536C850145BF176F1CB", hash_generated_method = "831260624412E7D13ACE7897F697D54E")
    
protected SIPTransactionStack() {
        this.toExit = false;
        this.forkedEvents = new HashSet<String>();
        // set of events for which subscriptions can be forked.
        // Set an infinite thread pool size.
        this.threadPoolSize = -1;
        // Close response socket after infinte time.
        // for max performance
        this.cacheServerConnections = true;
        // Close the request socket after infinite time.
        // for max performance
        this.cacheClientConnections = true;
        // Max number of simultaneous connections.
        this.maxConnections = -1;
        // Array of message processors.
        messageProcessors = new ArrayList<MessageProcessor>();
        // Handle IO for this process.
        this.ioHandler = new IOHandler(this);

        // The read time out is infinite.
        this.readTimeout = -1;

        this.maxListenerResponseTime = -1;

        // The default (identity) address lookup scheme

        this.addressResolver = new DefaultAddressResolver();

        // Notify may or may not create a dialog. This is handled in
        // the code.
        // Create the transaction collections

        // Dialog dable.
        this.dialogTable = new ConcurrentHashMap<String, SIPDialog>();
        this.earlyDialogTable = new ConcurrentHashMap<String, SIPDialog>();

        clientTransactionTable = new ConcurrentHashMap<String, SIPClientTransaction>();
        serverTransactionTable = new ConcurrentHashMap<String, SIPServerTransaction>();
        this.terminatedServerTransactionsPendingAck = new ConcurrentHashMap<String, SIPServerTransaction>();
        mergeTable = new ConcurrentHashMap<String, SIPServerTransaction>();
        retransmissionAlertTransactions = new ConcurrentHashMap<String, SIPServerTransaction>();

        // Start the timer event thread.

        this.timer = new Timer();
        this.pendingTransactions = new ConcurrentHashMap<String, SIPServerTransaction>();
        
        this.forkedClientTransactionTable = new ConcurrentHashMap<String,SIPClientTransaction>();

        if (getThreadAuditor().isEnabled()) {
            // Start monitoring the timer thread
            timer.schedule(new PingTimer(null), 0);
        }
    }

    /**
     * Construcor for the stack. Registers the request and response factories for the stack.
     *
     * @param messageFactory User-implemented factory for processing messages.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.434 -0500", hash_original_method = "A949ED7F371D2CEC2724714D98F74A81", hash_generated_method = "A35FEC8DECEC7FCDFB70A09E65B2BE34")
    
protected SIPTransactionStack(StackMessageFactory messageFactory) {
        this();
        this.sipMessageFactory = messageFactory;
    }

    /**
     * Re Initialize the stack instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.367 -0500", hash_original_method = "4C95AA981C09EEAD5B31E73DC1384B23", hash_generated_method = "0CBD12A7C2D2B9FCF5B8F24492EE6FAE")
    
protected void reInit() {
        if (stackLogger.isLoggingEnabled())
            stackLogger.logDebug("Re-initializing !");

        // Array of message processors.
        messageProcessors = new ArrayList<MessageProcessor>();
        // Handle IO for this process.
        this.ioHandler = new IOHandler(this);
        // clientTransactions = new ConcurrentLinkedQueue();
        // serverTransactions = new ConcurrentLinkedQueue();
        pendingTransactions = new ConcurrentHashMap<String, SIPServerTransaction>();
        clientTransactionTable = new ConcurrentHashMap<String, SIPClientTransaction>();
        serverTransactionTable = new ConcurrentHashMap<String, SIPServerTransaction>();
        retransmissionAlertTransactions = new ConcurrentHashMap<String, SIPServerTransaction>();
        mergeTable = new ConcurrentHashMap<String, SIPServerTransaction>();
        // Dialog dable.
        this.dialogTable = new ConcurrentHashMap<String, SIPDialog>();
        this.earlyDialogTable = new ConcurrentHashMap<String, SIPDialog>();
        this.terminatedServerTransactionsPendingAck = new ConcurrentHashMap<String,SIPServerTransaction>();
        this.forkedClientTransactionTable = new ConcurrentHashMap<String,SIPClientTransaction>();

        this.timer = new Timer();

        this.activeClientTransactionCount = new AtomicInteger(0);

    }

    /**
     * Creates and binds, if necessary, a socket connected to the specified
     * destination address and port and then returns its local address.
     *
     * @param dst the destination address that the socket would need to connect
     *            to.
     * @param dstPort the port number that the connection would be established
     * with.
     * @param localAddress the address that we would like to bind on
     * (null for the "any" address).
     * @param localPort the port that we'd like our socket to bind to (0 for a
     * random port).
     *
     * @return the SocketAddress that this handler would use when connecting to
     * the specified destination address and port.
     *
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.370 -0500", hash_original_method = "5E8E9B567A338F9125BE752CD1B53E0E", hash_generated_method = "99EE4391AD7AA4B5779342BBE9FF6635")
    
public SocketAddress obtainLocalAddress(InetAddress dst, int dstPort,
                    InetAddress localAddress, int localPort)
        throws IOException
    {
        return this.ioHandler.obtainLocalAddress(
                        dst, dstPort, localAddress, localPort);

    }

    /**
     * For debugging -- allows you to disable logging or enable logging selectively.
     *
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.373 -0500", hash_original_method = "6F4F1101C93AB1BC6C07B08D53A20694", hash_generated_method = "709122F3FC3CBE9DAF24DE329B626AA2")
    
public void disableLogging() {
        this.getStackLogger().disableLogging();
    }

    /**
     * Globally enable message logging ( for debugging)
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.375 -0500", hash_original_method = "28B9C3C3AF577CC75DD224D050447CF4", hash_generated_method = "2519B50D30B20B11517B949E5B02DAC4")
    
public void enableLogging() {
        this.getStackLogger().enableLogging();
    }

    /**
     * Print the dialog table.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.378 -0500", hash_original_method = "F0A4CF0EC627D6BB4B7444677CFA585E", hash_generated_method = "DA599FFF1484C1231175AA0F18A7B1EF")
    
public void printDialogTable() {
        if (isLoggingEnabled()) {
            this.getStackLogger().logDebug("dialog table  = " + this.dialogTable);
            System.out.println("dialog table = " + this.dialogTable);
        }
    }

    /**
     * Retrieve a transaction from our table of transactions with pending retransmission alerts.
     *
     * @param dialogId
     * @return -- the RetransmissionAlert enabled transaction corresponding to the given dialog
     *         ID.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.381 -0500", hash_original_method = "A39FC22DA230CCE4243CA37C766915B4", hash_generated_method = "8F2FE9C3DCDDCEA771E04E31E06D6E1F")
    
public SIPServerTransaction getRetransmissionAlertTransaction(String dialogId) {
        return (SIPServerTransaction) this.retransmissionAlertTransactions.get(dialogId);
    }

    /**
     * Add an extension method.
     *
     * @param extensionMethod -- extension method to support for dialog creation
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.388 -0500", hash_original_method = "BEE1BC405D1C6F3176E5E5958D511DC6", hash_generated_method = "6DDD3E77E754B24ABCE6477E9CAFF9CD")
    
public void addExtensionMethod(String extensionMethod) {
        if (extensionMethod.equals(Request.NOTIFY)) {
            if (stackLogger.isLoggingEnabled())
                stackLogger.logDebug("NOTIFY Supported Natively");
        } else {
            dialogCreatingMethods.add(extensionMethod.trim().toUpperCase());
        }
    }

    /**
     * Put a dialog into the dialog table.
     *
     * @param dialog -- dialog to put into the dialog table.
     *
     */
    @DSSink({DSSinkKind.VOIP})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.391 -0500", hash_original_method = "3AD47119D9E3B66FC61FF1D5407F3E89", hash_generated_method = "D86A3365F924BC5296466B4C2E2757C9")
    
public void putDialog(SIPDialog dialog) {
        String dialogId = dialog.getDialogId();
        if (dialogTable.containsKey(dialogId)) {
            if (stackLogger.isLoggingEnabled()) {
                stackLogger.logDebug("putDialog: dialog already exists" + dialogId + " in table = "
                        + dialogTable.get(dialogId));
            }
            return;
        }
        if (stackLogger.isLoggingEnabled()) {
            stackLogger.logDebug("putDialog dialogId=" + dialogId + " dialog = " + dialog);
        }
        dialog.setStack(this);
        if (stackLogger.isLoggingEnabled())
            stackLogger.logStackTrace();
        dialogTable.put(dialogId, dialog);

    }

    /**
     * Create a dialog and add this transaction to it.
     *
     * @param transaction -- tx to add to the dialog.
     * @return the newly created Dialog.
     */
    @DSSink({DSSinkKind.VOIP})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.394 -0500", hash_original_method = "E7A6CF8B50F165B49D6E8637D9CBF9BD", hash_generated_method = "47F6C28109893F14B315FAA6E19D4D88")
    
public SIPDialog createDialog(SIPTransaction transaction) {

        SIPDialog retval = null;

        if (transaction instanceof SIPClientTransaction) {
            String dialogId = ((SIPRequest) transaction.getRequest()).getDialogId(false);
            if (this.earlyDialogTable.get(dialogId) != null) {
                SIPDialog dialog = this.earlyDialogTable.get(dialogId);
                if (dialog.getState() == null || dialog.getState() == DialogState.EARLY) {
                    retval = dialog;
                } else {
                    retval = new SIPDialog(transaction);
                    this.earlyDialogTable.put(dialogId, retval);
                }
            } else {
                retval = new SIPDialog(transaction);
                this.earlyDialogTable.put(dialogId, retval);
            }
        } else {
            retval = new SIPDialog(transaction);
        }

        return retval;

    }

    /**
     * Create a Dialog given a client tx and response.
     *
     * @param transaction
     * @param sipResponse
     * @return
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.396 -0500", hash_original_method = "077BDE7287D2ACDD7F2A84D6156CB0F7", hash_generated_method = "9A1703FB99D1A51BB295FB9E5853B2EB")
    
public SIPDialog createDialog(SIPClientTransaction transaction, SIPResponse sipResponse) {
        String dialogId = ((SIPRequest) transaction.getRequest()).getDialogId(false);
        SIPDialog retval = null;
        if (this.earlyDialogTable.get(dialogId) != null) {
            retval = this.earlyDialogTable.get(dialogId);
            if (sipResponse.isFinalResponse()) {
                this.earlyDialogTable.remove(dialogId);
            }

        } else {
            retval = new SIPDialog(transaction, sipResponse);
        }
        return retval;

    }
    /**
     * Create a Dialog given a sip provider and response.
     *
     * @param sipProvider
     * @param sipResponse
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.399 -0500", hash_original_method = "C8019EE35E2246E727D64B4FEC692BA7", hash_generated_method = "D2EF616819CAF1755FC4DC004FD55148")
    
public SIPDialog createDialog(SipProviderImpl sipProvider,
			SIPResponse sipResponse) {
		return new SIPDialog(sipProvider, sipResponse);
	}

    /**
     * Remove the dialog from the dialog table.
     *
     * @param dialog -- dialog to remove.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.402 -0500", hash_original_method = "C20BEEC896962D7D1856EB72C0C34791", hash_generated_method = "8AD4A75893F7402330C34806204FCB46")
    
public void removeDialog(SIPDialog dialog) {

        String id = dialog.getDialogId();

        String earlyId = dialog.getEarlyDialogId();

        if (earlyId != null) {
            this.earlyDialogTable.remove(earlyId);
            this.dialogTable.remove(earlyId);
        }

        if (id != null) {

            // FHT: Remove dialog from table only if its associated dialog is the same as the one
            // specified

            Object old = this.dialogTable.get(id);

            if (old == dialog) {
                this.dialogTable.remove(id);
            }
       
            // We now deliver DTE even when the dialog is not originally present in the Dialog
            // Table
            // This happens before the dialog state is assigned.

            if (!dialog.testAndSetIsDialogTerminatedEventDelivered()) {
                DialogTerminatedEvent event = new DialogTerminatedEvent(dialog.getSipProvider(),
                        dialog);

                // Provide notification to the listener that the dialog has
                // ended.
                dialog.getSipProvider().handleEvent(event, null);

            }

        } else if ( this.isDialogTerminatedEventDeliveredForNullDialog ) {
            if (!dialog.testAndSetIsDialogTerminatedEventDelivered()) {
                DialogTerminatedEvent event = new DialogTerminatedEvent(dialog.getSipProvider(),
                        dialog);

                // Provide notification to the listener that the dialog has
                // ended.
                dialog.getSipProvider().handleEvent(event, null);

            }
        }

    }

    /**
     * Return the dialog for a given dialog ID. If compatibility is enabled then we do not assume
     * the presence of tags and hence need to add a flag to indicate whether this is a server or
     * client transaction.
     *
     * @param dialogId is the dialog id to check.
     */

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.405 -0500", hash_original_method = "7CD5A4CB12647D3BBBFDC040A2B5E183", hash_generated_method = "66F94FA42435B38824839E25748C876B")
    
public SIPDialog getDialog(String dialogId) {

        SIPDialog sipDialog = (SIPDialog) dialogTable.get(dialogId);
        if (stackLogger.isLoggingEnabled()) {
            stackLogger.logDebug("getDialog(" + dialogId + ") : returning " + sipDialog);
        }
        return sipDialog;

    }

    /**
     * Remove the dialog given its dialog id. This is used for dialog id re-assignment only.
     *
     * @param dialogId is the dialog Id to remove.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.408 -0500", hash_original_method = "B0D51307A4FC266FC1D02389AEE54D05", hash_generated_method = "FF2775FBBDA31ED87F85F48A8F4805AD")
    
public void removeDialog(String dialogId) {
        if (stackLogger.isLoggingEnabled()) {
            stackLogger.logWarning("Silently removing dialog from table");
        }
        dialogTable.remove(dialogId);
    }

    /**
     * Find a matching client SUBSCRIBE to the incoming notify. NOTIFY requests are matched to
     * such SUBSCRIBE requests if they contain the same "Call-ID", a "To" header "tag" parameter
     * which matches the "From" header "tag" parameter of the SUBSCRIBE, and the same "Event"
     * header field. Rules for comparisons of the "Event" headers are described in section 7.2.1.
     * If a matching NOTIFY request contains a "Subscription-State" of "active" or "pending", it
     * creates a new subscription and a new dialog (unless they have already been created by a
     * matching response, as described above).
     *
     * @param notifyMessage
     * @return -- the matching ClientTransaction with semaphore aquired or null if no such client
     *         transaction can be found.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.412 -0500", hash_original_method = "5BA8167D6AC26A2C080E0DF071E238DD", hash_generated_method = "EB47C2931063D7D379FC7CFA8DCB3485")
    
public SIPClientTransaction findSubscribeTransaction(SIPRequest notifyMessage,
            ListeningPointImpl listeningPoint) {
        SIPClientTransaction retval = null;
        try {
            Iterator it = clientTransactionTable.values().iterator();
            if (stackLogger.isLoggingEnabled())
            	stackLogger.logDebug("ct table size = " + clientTransactionTable.size());
            String thisToTag = notifyMessage.getTo().getTag();
            if (thisToTag == null) {
                return retval;
            }
            Event eventHdr = (Event) notifyMessage.getHeader(EventHeader.NAME);
            if (eventHdr == null) {
                if (stackLogger.isLoggingEnabled()) {
                    stackLogger.logDebug("event Header is null -- returning null");
                }

                return retval;
            }
            while (it.hasNext()) {
                SIPClientTransaction ct = (SIPClientTransaction) it.next();
                if (!ct.getMethod().equals(Request.SUBSCRIBE))
                    continue;

                // if ( sipProvider.getListeningPoint(transport) == null)
                String fromTag = ct.from.getTag();
                Event hisEvent = ct.event;
                // Event header is mandatory but some slopply clients
                // dont include it.
                if (hisEvent == null)
                    continue;
                if (stackLogger.isLoggingEnabled()) {
                    stackLogger.logDebug("ct.fromTag = " + fromTag);
                    stackLogger.logDebug("thisToTag = " + thisToTag);
                    stackLogger.logDebug("hisEvent = " + hisEvent);
                    stackLogger.logDebug("eventHdr " + eventHdr);
                }

                if (  fromTag.equalsIgnoreCase(thisToTag)
                      && hisEvent != null
                      && eventHdr.match(hisEvent)
                      && notifyMessage.getCallId().getCallId().equalsIgnoreCase(
                                ct.callId.getCallId())) {
                    if (ct.acquireSem())
                        retval = ct;
                    return retval;
                }
            }

            return retval;
        } finally {
        	if (stackLogger.isLoggingEnabled())
                stackLogger.logDebug("findSubscribeTransaction : returning " + retval);

        }

    }
    
    /**
     * Add entry to "Transaction Pending ACK" table.
     * 
     * @param serverTransaction
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.415 -0500", hash_original_method = "D49C9B94E89B7FEA3320280273306438", hash_generated_method = "F4B1FA9EAC4475E2ABA1C7D1DF88A643")
    
public void addTransactionPendingAck(SIPServerTransaction serverTransaction) {
        String branchId = ((SIPRequest)serverTransaction.getRequest()).getTopmostVia().getBranch();
        if ( branchId != null ) {
            this.terminatedServerTransactionsPendingAck.put(branchId, serverTransaction);
        }
        
    }
    
    /**
     * Get entry in the server transaction pending ACK table corresponding to an ACK.
     * 
     * @param ackMessage
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.417 -0500", hash_original_method = "37709198085D538D169FF1DE9D9ADB9C", hash_generated_method = "8504BD49AD39B86C85FA02F7AFAD04FF")
    
public SIPServerTransaction findTransactionPendingAck(SIPRequest ackMessage) {
        return this.terminatedServerTransactionsPendingAck.get(ackMessage.getTopmostVia().getBranch());
    }
    
    /**
     * Remove entry from "Transaction Pending ACK" table.
     * 
     * @param serverTransaction
     * @return
     */
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.421 -0500", hash_original_method = "B481CD0C272F0294325516CB58C4D625", hash_generated_method = "E62AEA9FA7B244F3FD7573DFDE704FA8")
    
public boolean removeTransactionPendingAck(SIPServerTransaction serverTransaction) {
        String branchId = ((SIPRequest)serverTransaction.getRequest()).getTopmostVia().getBranch();
        if ( branchId != null && this.terminatedServerTransactionsPendingAck.containsKey(branchId) ) {
            this.terminatedServerTransactionsPendingAck.remove(branchId);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Check if this entry exists in the "Transaction Pending ACK" table.
     * 
     * @param serverTransaction
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.424 -0500", hash_original_method = "E118D63661EEDB81E619AEC2D5F479DE", hash_generated_method = "AE9D1B942B27BD13C63E02FC14050738")
    
public boolean isTransactionPendingAck(SIPServerTransaction serverTransaction) {
        String branchId = ((SIPRequest)serverTransaction.getRequest()).getTopmostVia().getBranch();
        return this.terminatedServerTransactionsPendingAck.contains(branchId); 
    }
    
    /**
     * Find the transaction corresponding to a given request.
     *
     * @param sipMessage request for which to retrieve the transaction.
     *
     * @param isServer search the server transaction table if true.
     *
     * @return the transaction object corresponding to the request or null if no such mapping
     *         exists.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.427 -0500", hash_original_method = "CFF098965464555AD1B1F596C34C16A1", hash_generated_method = "2538C69C4CF5B9AC37A2752308A2AD4B")
    
public SIPTransaction findTransaction(SIPMessage sipMessage, boolean isServer) {
        SIPTransaction retval = null;
        try {
            if (isServer) {
                Via via = sipMessage.getTopmostVia();
                if (via.getBranch() != null) {
                    String key = sipMessage.getTransactionId();

                    retval = (SIPTransaction) serverTransactionTable.get(key);
                    if (stackLogger.isLoggingEnabled())
                        getStackLogger().logDebug(
                                "serverTx: looking for key " + key + " existing="
                                + serverTransactionTable);
                    if (key.startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE)) {
                        return retval;
                    }

                }
                // Need to scan the table for old style transactions (RFC 2543
                // style)
                Iterator<SIPServerTransaction> it = serverTransactionTable.values().iterator();
                while (it.hasNext()) {
                    SIPServerTransaction sipServerTransaction = (SIPServerTransaction) it.next();
                    if (sipServerTransaction.isMessagePartOfTransaction(sipMessage)) {
                        retval = sipServerTransaction;
                        return retval;
                    }
                }

            } else {
                Via via = sipMessage.getTopmostVia();
                if (via.getBranch() != null) {
                    String key = sipMessage.getTransactionId();
                    if (stackLogger.isLoggingEnabled())
                        getStackLogger().logDebug("clientTx: looking for key " + key);
                    retval = (SIPTransaction) clientTransactionTable.get(key);
                    if (key.startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE)) {
                        return retval;
                    }

                }
                // Need to scan the table for old style transactions (RFC 2543
                // style). This is terribly slow but we need to do this
                // for backasswords compatibility.
                Iterator<SIPClientTransaction> it = clientTransactionTable.values().iterator();
                while (it.hasNext()) {
                    SIPClientTransaction clientTransaction = (SIPClientTransaction) it.next();
                    if (clientTransaction.isMessagePartOfTransaction(sipMessage)) {
                        retval = clientTransaction;
                        return retval;
                    }
                }

            }
        } finally {
        	if ( this.getStackLogger().isLoggingEnabled()) {
        	  this.getStackLogger().logDebug("findTransaction: returning  : " + retval);
        	}
        }
        return retval;

    }

    /**
     * Get the transaction to cancel. Search the server transaction table for a transaction that
     * matches the given transaction.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.431 -0500", hash_original_method = "EBA76BEAE03DA80AC45DCE1E9705412D", hash_generated_method = "A3AD8FF6792AD963A43CF5A198CECCD1")
    
public SIPTransaction findCancelTransaction(SIPRequest cancelRequest, boolean isServer) {

        if (stackLogger.isLoggingEnabled()) {
            stackLogger.logDebug("findCancelTransaction request= \n" + cancelRequest
                    + "\nfindCancelRequest isServer=" + isServer);
        }

        if (isServer) {
            Iterator<SIPServerTransaction> li = this.serverTransactionTable.values().iterator();
            while (li.hasNext()) {
                SIPTransaction transaction = (SIPTransaction) li.next();

                SIPServerTransaction sipServerTransaction = (SIPServerTransaction) transaction;
                if (sipServerTransaction.doesCancelMatchTransaction(cancelRequest))
                    return sipServerTransaction;
            }

        } else {
            Iterator<SIPClientTransaction> li = this.clientTransactionTable.values().iterator();
            while (li.hasNext()) {
                SIPTransaction transaction = (SIPTransaction) li.next();

                SIPClientTransaction sipClientTransaction = (SIPClientTransaction) transaction;
                if (sipClientTransaction.doesCancelMatchTransaction(cancelRequest))
                    return sipClientTransaction;

            }

        }
        if (stackLogger.isLoggingEnabled())
            stackLogger.logDebug("Could not find transaction for cancel request");
        return null;
    }

    /**
     * Finds a pending server transaction. Since each request may be handled either statefully or
     * statelessly, we keep a map of pending transactions so that a duplicate transaction is not
     * created if a second request is recieved while the first one is being processed.
     *
     * @param requestReceived
     * @return -- the pending transaction or null if no such transaction exists.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.437 -0500", hash_original_method = "C32886C5E5EF95CE74E82DCEA7E677B6", hash_generated_method = "D3B6DAB676DE9F36C58223BD4E21C20A")
    
public SIPServerTransaction findPendingTransaction(SIPRequest requestReceived) {
        if (this.stackLogger.isLoggingEnabled()) {
            this.stackLogger.logDebug("looking for pending tx for :"
                    + requestReceived.getTransactionId());
        }
        return (SIPServerTransaction) pendingTransactions.get(requestReceived.getTransactionId());

    }

    /**
     * See if there is a pending transaction with the same Merge ID as the Merge ID obtained from
     * the SIP Request. The Merge table is for handling the following condition: If the request
     * has no tag in the To header field, the UAS core MUST check the request against ongoing
     * transactions. If the From tag, Call-ID, and CSeq exactly match those associated with an
     * ongoing transaction, but the request does not match that transaction (based on the matching
     * rules in Section 17.2.3), the UAS core SHOULD generate a 482 (Loop Detected) response and
     * pass it to the server transaction.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.440 -0500", hash_original_method = "DE7BCEF3CEAF7F5E4F7BCE647A148129", hash_generated_method = "E18E3422BCACD9B86FFFF540EC036F81")
    
public SIPServerTransaction findMergedTransaction(SIPRequest sipRequest) {
        if (! sipRequest.getMethod().equals(Request.INVITE)) {
            /*
             * Dont need to worry about request merging for Non-INVITE transactions.
             */
            return null;
        }
        String mergeId = sipRequest.getMergeId();
        SIPServerTransaction mergedTransaction = (SIPServerTransaction) this.mergeTable.get(mergeId);
        if (mergeId == null ) {
            return null;
        } else if (mergedTransaction != null && !mergedTransaction.isMessagePartOfTransaction(sipRequest) ) {
            return mergedTransaction;
        } else {
            /*
             * Check the server transactions that have resulted in dialogs.
             */
           for (Dialog dialog: this.dialogTable.values() ) {
               SIPDialog sipDialog = (SIPDialog) dialog ;
               if (sipDialog.getFirstTransaction()  != null && 
                   sipDialog.getFirstTransaction() instanceof ServerTransaction) {
                   SIPServerTransaction serverTransaction = ((SIPServerTransaction) sipDialog.getFirstTransaction());
                   SIPRequest transactionRequest = ((SIPServerTransaction) sipDialog.getFirstTransaction()).getOriginalRequest();
                   if ( (! serverTransaction.isMessagePartOfTransaction(sipRequest))
                           && sipRequest.getMergeId().equals(transactionRequest.getMergeId())) {
                           return (SIPServerTransaction) sipDialog.getFirstTransaction();  
                   }
               }
           } 
           return null;
        }
    }

    /**
     * Remove a pending Server transaction from the stack. This is called after the user code has
     * completed execution in the listener.
     *
     * @param tr -- pending transaction to remove.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.443 -0500", hash_original_method = "365415518ECAE79EAD0CD2C9D4462A78", hash_generated_method = "9046C8C3606C809CC0BBD6C2974A7439")
    
public void removePendingTransaction(SIPServerTransaction tr) {
        if (this.stackLogger.isLoggingEnabled()) {
            this.stackLogger.logDebug("removePendingTx: " + tr.getTransactionId());
        }
        this.pendingTransactions.remove(tr.getTransactionId());

    }

    /**
     * Remove a transaction from the merge table.
     *
     * @param tr -- the server transaction to remove from the merge table.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.445 -0500", hash_original_method = "DB6ED2CEA840316B4782573C88C3E1FC", hash_generated_method = "5101BD978D3C72A3B6E8CC8BC1265D27")
    
public void removeFromMergeTable(SIPServerTransaction tr) {
        if (stackLogger.isLoggingEnabled()) {
            this.stackLogger.logDebug("Removing tx from merge table ");
        }
        String key = ((SIPRequest) tr.getRequest()).getMergeId();
        if (key != null) {
            this.mergeTable.remove(key);
        }
    }

    /**
     * Put this into the merge request table.
     *
     * @param sipTransaction -- transaction to put into the merge table.
     *
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.448 -0500", hash_original_method = "4DF3A9A601EFF55EEB4CCC4D0E1A4382", hash_generated_method = "13E408CCF65C1FF11D071DDA160B148B")
    
public void putInMergeTable(SIPServerTransaction sipTransaction, SIPRequest sipRequest) {
        String mergeKey = sipRequest.getMergeId();
        if (mergeKey != null) {
            this.mergeTable.put(mergeKey, sipTransaction);
        }
    }

    /**
     * Map a Server transaction (possibly sending out a 100 if the server tx is an INVITE). This
     * actually places it in the hash table and makes it known to the stack.
     *
     * @param transaction -- the server transaction to map.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.452 -0500", hash_original_method = "8109166214A5696534573E329912E2B5", hash_generated_method = "60D93C61249991A57EB5E60C813D3525")
    
public void mapTransaction(SIPServerTransaction transaction) {
        if (transaction.isMapped)
            return;
        addTransactionHash(transaction);
        // transaction.startTransactionTimer();
        transaction.isMapped = true;
    }

    /**
     * Handles a new SIP request. It finds a server transaction to handle this message. If none
     * exists, it creates a new transaction.
     *
     * @param requestReceived Request to handle.
     * @param requestMessageChannel Channel that received message.
     *
     * @return A server transaction.
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.456 -0500", hash_original_method = "C3F915B9919F99B9388976510DFE400E", hash_generated_method = "2E81C69D1D763F3DD7F082DF5A790E3F")
    
public ServerRequestInterface newSIPServerRequest(SIPRequest requestReceived,
            MessageChannel requestMessageChannel) {
        // Iterator through all server transactions
        Iterator<SIPServerTransaction> transactionIterator;
        // Next transaction in the set
        SIPServerTransaction nextTransaction;
        // Transaction to handle this request
        SIPServerTransaction currentTransaction;

        String key = requestReceived.getTransactionId();

        requestReceived.setMessageChannel(requestMessageChannel);

        currentTransaction = (SIPServerTransaction) serverTransactionTable.get(key);

        // Got to do this for bacasswards compatibility.
        if (currentTransaction == null
                || !currentTransaction.isMessagePartOfTransaction(requestReceived)) {

            // Loop through all server transactions
            transactionIterator = serverTransactionTable.values().iterator();
            currentTransaction = null;
            if (!key.toLowerCase().startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE)) {
                while (transactionIterator.hasNext() && currentTransaction == null) {

                    nextTransaction = (SIPServerTransaction) transactionIterator.next();

                    // If this transaction should handle this request,
                    if (nextTransaction.isMessagePartOfTransaction(requestReceived)) {
                        // Mark this transaction as the one
                        // to handle this message
                        currentTransaction = nextTransaction;
                    }
                }
            }

            // If no transaction exists to handle this message
            if (currentTransaction == null) {
                currentTransaction = findPendingTransaction(requestReceived);
                if (currentTransaction != null) {
                    // Associate the tx with the received request.
                    requestReceived.setTransaction(currentTransaction);
                    if (currentTransaction != null && currentTransaction.acquireSem())
                        return currentTransaction;
                    else
                        return null;

                }
                // Creating a new server tx. May fail under heavy load.
                currentTransaction = createServerTransaction(requestMessageChannel);
                if (currentTransaction != null) {
                    // currentTransaction.setPassToListener();
                    currentTransaction.setOriginalRequest(requestReceived);
                    // Associate the tx with the received request.
                    requestReceived.setTransaction(currentTransaction);
                }

            }

        }

        // Set ths transaction's encapsulated request
        // interface from the superclass
        if (stackLogger.isLoggingEnabled()) {
            stackLogger.logDebug("newSIPServerRequest( " + requestReceived.getMethod() + ":"
                    + requestReceived.getTopmostVia().getBranch() + "):" + currentTransaction);
        }

        if (currentTransaction != null)
            currentTransaction.setRequestInterface(sipMessageFactory.newSIPServerRequest(
                    requestReceived, currentTransaction));

        if (currentTransaction != null && currentTransaction.acquireSem()) {
            return currentTransaction;
        } else if (currentTransaction != null) {
            try {
                /*
                 * Already processing a message for this transaction.
                 * SEND a trying ( message already being processed ).
                 */
                if (currentTransaction.isMessagePartOfTransaction(requestReceived) &&
                    currentTransaction.getMethod().equals(requestReceived.getMethod())) {
                    SIPResponse trying = requestReceived.createResponse(Response.TRYING);
                    trying.removeContent();
                    currentTransaction.getMessageChannel().sendMessage(trying);
                }
            } catch (Exception ex) {
            	if (isLoggingEnabled())
            		stackLogger.logError("Exception occured sending TRYING");
            }
            return null;
        } else {
            return null;
        }
    }

    /**
     * Handles a new SIP response. It finds a client transaction to handle this message. If none
     * exists, it sends the message directly to the superclass.
     *
     * @param responseReceived Response to handle.
     * @param responseMessageChannel Channel that received message.
     *
     * @return A client transaction.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.460 -0500", hash_original_method = "62ADB5DE3DAA611F01F5B25EB82A32E9", hash_generated_method = "BAB46B9CC4BEDB8071B56701A0B54C17")
    
public ServerResponseInterface newSIPServerResponse(SIPResponse responseReceived,
            MessageChannel responseMessageChannel) {

        // Iterator through all client transactions
        Iterator<SIPClientTransaction> transactionIterator;
        // Next transaction in the set
        SIPClientTransaction nextTransaction;
        // Transaction to handle this request
        SIPClientTransaction currentTransaction;

        String key = responseReceived.getTransactionId();

        // Note that for RFC 3261 compliant operation, this lookup will
        // return a tx if one exists and hence no need to search through
        // the table.
        currentTransaction = (SIPClientTransaction) clientTransactionTable.get(key);

        if (currentTransaction == null
                || (!currentTransaction.isMessagePartOfTransaction(responseReceived) && !key
                        .startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE))) {
            // Loop through all client transactions

            transactionIterator = clientTransactionTable.values().iterator();
            currentTransaction = null;
            while (transactionIterator.hasNext() && currentTransaction == null) {

                nextTransaction = (SIPClientTransaction) transactionIterator.next();

                // If this transaction should handle this request,
                if (nextTransaction.isMessagePartOfTransaction(responseReceived)) {

                    // Mark this transaction as the one to
                    // handle this message
                    currentTransaction = nextTransaction;

                }

            }

            // If no transaction exists to handle this message,
            if (currentTransaction == null) {
                // JvB: Need to log before passing the response to the client
                // app, it
                // gets modified!
                if (this.stackLogger.isLoggingEnabled(StackLogger.TRACE_INFO)) {
                    responseMessageChannel.logResponse(responseReceived, System
                            .currentTimeMillis(), "before processing");
                }

                // Pass the message directly to the TU
                return sipMessageFactory.newSIPServerResponse(responseReceived,
                        responseMessageChannel);

            }
        }

        // Aquire the sem -- previous request may still be processing.
        boolean acquired = currentTransaction.acquireSem();
        // Set ths transaction's encapsulated response interface
        // from the superclass
        if (this.stackLogger.isLoggingEnabled(StackLogger.TRACE_INFO)) {
            currentTransaction.logResponse(responseReceived, System.currentTimeMillis(),
                    "before processing");
        }

        if (acquired) {
            ServerResponseInterface sri = sipMessageFactory.newSIPServerResponse(
                    responseReceived, currentTransaction);
            if (sri != null) {
                currentTransaction.setResponseInterface(sri);
            } else {
                if (this.stackLogger.isLoggingEnabled()) {
                    this.stackLogger.logDebug("returning null - serverResponseInterface is null!");
                }
                currentTransaction.releaseSem();
                return null;
            }
        } else {
        	if (stackLogger.isLoggingEnabled())
        		this.stackLogger.logDebug("Could not aquire semaphore !!");
        }

        if (acquired)
            return currentTransaction;
        else
            return null;

    }

    /**
     * Creates a client transaction to handle a new request. Gets the real message channel from
     * the superclass, and then creates a new client transaction wrapped around this channel.
     *
     * @param nextHop Hop to create a channel to contact.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.463 -0500", hash_original_method = "32F3E8827D13E0BAFD4E9DD3BE9CB370", hash_generated_method = "109A8D4F1D3CC0C71FA0CA07F80A1FAC")
    
public MessageChannel createMessageChannel(SIPRequest request, MessageProcessor mp,
            Hop nextHop) throws IOException {
        // New client transaction to return
        SIPTransaction returnChannel;

        // Create a new client transaction around the
        // superclass' message channel
        // Create the host/port of the target hop
        Host targetHost = new Host();
        targetHost.setHostname(nextHop.getHost());
        HostPort targetHostPort = new HostPort();
        targetHostPort.setHost(targetHost);
        targetHostPort.setPort(nextHop.getPort());
        MessageChannel mc = mp.createMessageChannel(targetHostPort);

        // Superclass will return null if no message processor
        // available for the transport.
        if (mc == null)
            return null;

        returnChannel = createClientTransaction(request, mc);

        ((SIPClientTransaction) returnChannel).setViaPort(nextHop.getPort());
        ((SIPClientTransaction) returnChannel).setViaHost(nextHop.getHost());
        addTransactionHash(returnChannel);
        // clientTransactionTable.put(returnChannel.getTransactionId(),
        // returnChannel);
        // Add the transaction timer for the state machine.
        // returnChannel.startTransactionTimer();
        return returnChannel;

    }

    /**
     * Creates a client transaction that encapsulates a MessageChannel. Useful for implementations
     * that want to subclass the standard
     *
     * @param encapsulatedMessageChannel Message channel of the transport layer.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.466 -0500", hash_original_method = "912DB48513D0A0D8594B2E782158C138", hash_generated_method = "4FAB49D11EF46D7525D217150469DD4C")
    
public SIPClientTransaction createClientTransaction(SIPRequest sipRequest,
            MessageChannel encapsulatedMessageChannel) {
        SIPClientTransaction ct = new SIPClientTransaction(this, encapsulatedMessageChannel);
        ct.setOriginalRequest(sipRequest);
        return ct;
    }

    /**
     * Creates a server transaction that encapsulates a MessageChannel. Useful for implementations
     * that want to subclass the standard
     *
     * @param encapsulatedMessageChannel Message channel of the transport layer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.469 -0500", hash_original_method = "81B760547C7425A938D45D7063876C66", hash_generated_method = "C859D3C5D2A0DB54DDA65A6979CC60D1")
    
public SIPServerTransaction createServerTransaction(MessageChannel encapsulatedMessageChannel) {
    	// Issue 256 : be consistent with createClientTransaction, if unlimitedServerTransactionTableSize is true,
    	// a new Server Transaction is created no matter what
        if (unlimitedServerTransactionTableSize) {                
            return new SIPServerTransaction(this, encapsulatedMessageChannel);
        } else {
            float threshold = ((float) (serverTransactionTable.size() - serverTransactionTableLowaterMark))
                    / ((float) (serverTransactionTableHighwaterMark - serverTransactionTableLowaterMark));
            boolean decision = Math.random() > 1.0 - threshold;
            if (decision) {
                return null;
            } else {
                return new SIPServerTransaction(this, encapsulatedMessageChannel);
            }

        }

    }

    /**
     * Get the size of the client transaction table.
     *
     * @return -- size of the ct table.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.473 -0500", hash_original_method = "2775112CA96E4BBD847FD3F2A14A81DE", hash_generated_method = "9C11E610166722C5AB926C686FCD424A")
    
public int getClientTransactionTableSize() {
        return this.clientTransactionTable.size();
    }
    
    /**
     * Get the size of the server transaction table.
     *
     * @return -- size of the server table.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.475 -0500", hash_original_method = "4372809DD9897424686B6F4A147D93FA", hash_generated_method = "5A473FA44173345A5DF0F1C2CC4D40C8")
    
public int getServerTransactionTableSize() {
        return this.serverTransactionTable.size();
    }

    /**
     * Add a new client transaction to the set of existing transactions. Add it to the top of the
     * list so an incoming response has less work to do in order to find the transaction.
     *
     * @param clientTransaction -- client transaction to add to the set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.478 -0500", hash_original_method = "2F0441D135E4CBEEA76B3CCA00FAD23B", hash_generated_method = "39BF0CEE4D7555B1BA6A2E532E0DAC1B")
    
public void addTransaction(SIPClientTransaction clientTransaction) {
        if (stackLogger.isLoggingEnabled())
            stackLogger.logDebug("added transaction " + clientTransaction);
        addTransactionHash(clientTransaction);
       
    }

    /**
     * Remove transaction. This actually gets the tx out of the search structures which the stack
     * keeps around. When the tx
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.482 -0500", hash_original_method = "FC7C0EB4C2CF25B4E39BD000BE1A0318", hash_generated_method = "6220C80D2C1C2701913488B36F33A72A")
    
public void removeTransaction(SIPTransaction sipTransaction) {
        if (stackLogger.isLoggingEnabled()) {
            stackLogger.logDebug("Removing Transaction = " + sipTransaction.getTransactionId()
                    + " transaction = " + sipTransaction);
        }
        if (sipTransaction instanceof SIPServerTransaction) {
            if (stackLogger.isLoggingEnabled())
                stackLogger.logStackTrace();
            String key = sipTransaction.getTransactionId();
            Object removed = serverTransactionTable.remove(key);
            String method = sipTransaction.getMethod();
            this.removePendingTransaction((SIPServerTransaction) sipTransaction);
            this.removeTransactionPendingAck((SIPServerTransaction) sipTransaction);
            if (method.equalsIgnoreCase(Request.INVITE)) {
                this.removeFromMergeTable((SIPServerTransaction) sipTransaction);
            }
            // Send a notification to the listener.
            SipProviderImpl sipProvider = (SipProviderImpl) sipTransaction.getSipProvider();
            if (removed != null && sipTransaction.testAndSetTransactionTerminatedEvent()) {
                TransactionTerminatedEvent event = new TransactionTerminatedEvent(sipProvider,
                        (ServerTransaction) sipTransaction);

                sipProvider.handleEvent(event, sipTransaction);

            }
        } else {

            String key = sipTransaction.getTransactionId();
            Object removed = clientTransactionTable.remove(key);

            if (stackLogger.isLoggingEnabled()) {
                stackLogger.logDebug("REMOVED client tx " + removed + " KEY = " + key);
                if ( removed != null ) {
                   SIPClientTransaction clientTx = (SIPClientTransaction)removed;
                   if ( clientTx.getMethod().equals(Request.INVITE) && this.maxForkTime != 0 ) {
                       RemoveForkedTransactionTimerTask ttask = new RemoveForkedTransactionTimerTask(clientTx);
                       this.timer.schedule(ttask, this.maxForkTime * 1000);
                   }
                }
            }

            // Send a notification to the listener.
            if (removed != null && sipTransaction.testAndSetTransactionTerminatedEvent()) {
                SipProviderImpl sipProvider = (SipProviderImpl) sipTransaction.getSipProvider();
                TransactionTerminatedEvent event = new TransactionTerminatedEvent(sipProvider,
                        (ClientTransaction) sipTransaction);

                sipProvider.handleEvent(event, sipTransaction);
            }

        }
    }

    /**
     * Add a new server transaction to the set of existing transactions. Add it to the top of the
     * list so an incoming ack has less work to do in order to find the transaction.
     *
     * @param serverTransaction -- server transaction to add to the set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.484 -0500", hash_original_method = "114E6F44E2106B74A7437814EDE26008", hash_generated_method = "3D40D948F7FB759130C5C83ED63862EF")
    
public void addTransaction(SIPServerTransaction serverTransaction) throws IOException {
        if (stackLogger.isLoggingEnabled())
            stackLogger.logDebug("added transaction " + serverTransaction);
        serverTransaction.map();

        addTransactionHash(serverTransaction);
      
    }

    /**
     * Hash table for quick lookup of transactions. Here we wait for room if needed.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.488 -0500", hash_original_method = "A02B6100DC58EB921085C7ED44EE1D0C", hash_generated_method = "48084A26E40A2F235318545FF3404AE3")
    
private void addTransactionHash(SIPTransaction sipTransaction) {
        SIPRequest sipRequest = sipTransaction.getOriginalRequest();
        if (sipTransaction instanceof SIPClientTransaction) {
            if (!this.unlimitedClientTransactionTableSize) {
                if (this.activeClientTransactionCount.get() > clientTransactionTableHiwaterMark) {
                    try {
                        synchronized (this.clientTransactionTable) {
                            this.clientTransactionTable.wait();
                            this.activeClientTransactionCount.incrementAndGet();
                        }

                    } catch (Exception ex) {
                        if (stackLogger.isLoggingEnabled()) {
                            stackLogger.logError("Exception occured while waiting for room", ex);
                        }

                    }
                }
            } else {
                this.activeClientTransactionCount.incrementAndGet();
            }
            String key = sipRequest.getTransactionId();
            clientTransactionTable.put(key, (SIPClientTransaction) sipTransaction);
            
            if (stackLogger.isLoggingEnabled()) {
                stackLogger.logDebug(" putTransactionHash : " + " key = " + key);
            }
        } else {
            String key = sipRequest.getTransactionId();

            if (stackLogger.isLoggingEnabled()) {
                stackLogger.logDebug(" putTransactionHash : " + " key = " + key);
            }
            serverTransactionTable.put(key, (SIPServerTransaction) sipTransaction);

        }

    }

    /**
     * This method is called when a client tx transitions to the Completed or Terminated state.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.490 -0500", hash_original_method = "380804F8BD40257E05E5F5A307273856", hash_generated_method = "0EAB716246A6A39605285866B3663EF1")
    
protected void decrementActiveClientTransactionCount() {

        if (this.activeClientTransactionCount.decrementAndGet() <= this.clientTransactionTableLowaterMark
                && !this.unlimitedClientTransactionTableSize) {
            synchronized (this.clientTransactionTable) {

                clientTransactionTable.notify();

            }
        }
    }

    /**
     * Remove the transaction from transaction hash.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.493 -0500", hash_original_method = "BBF1530237A94448CCB60A02BEEFAB6C", hash_generated_method = "1209DCE3DE05B77A0B5FDB69F25297DE")
    
protected void removeTransactionHash(SIPTransaction sipTransaction) {
        SIPRequest sipRequest = sipTransaction.getOriginalRequest();
        if (sipRequest == null)
            return;
        if (sipTransaction instanceof SIPClientTransaction) {
            String key = sipTransaction.getTransactionId();
            if (stackLogger.isLoggingEnabled()) {
                stackLogger.logStackTrace();
                stackLogger.logDebug("removing client Tx : " + key);
            }
            clientTransactionTable.remove(key);

        } else if (sipTransaction instanceof SIPServerTransaction) {
            String key = sipTransaction.getTransactionId();
            serverTransactionTable.remove(key);
            if (stackLogger.isLoggingEnabled()) {
                stackLogger.logDebug("removing server Tx : " + key);
            }
        }
    }

    /**
     * Invoked when an error has ocurred with a transaction.
     *
     * @param transactionErrorEvent Error event.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.497 -0500", hash_original_method = "DE85950924139BCA289E1B65627F95C2", hash_generated_method = "B9A6D6A78DD82FAE8A96D093725B1214")
    
public synchronized void transactionErrorEvent(SIPTransactionErrorEvent transactionErrorEvent) {
        SIPTransaction transaction = (SIPTransaction) transactionErrorEvent.getSource();

        if (transactionErrorEvent.getErrorID() == SIPTransactionErrorEvent.TRANSPORT_ERROR) {
            // Kill scanning of this transaction.
            transaction.setState(SIPTransaction.TERMINATED_STATE);
            if (transaction instanceof SIPServerTransaction) {
                // let the reaper get him
                ((SIPServerTransaction) transaction).collectionTime = 0;
            }
            transaction.disableTimeoutTimer();
            transaction.disableRetransmissionTimer();
            // Send a IO Exception to the Listener.
        }
    }
    
    /*
     * (non-Javadoc)
     * @see gov.nist.javax.sip.stack.SIPDialogEventListener#dialogErrorEvent(gov.nist.javax.sip.stack.SIPDialogErrorEvent)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.500 -0500", hash_original_method = "2DBBC23B1910A8BC0C385035C3D36387", hash_generated_method = "54DB15DE28370B47F2AA9214F2A9CA01")
    
public synchronized void dialogErrorEvent(SIPDialogErrorEvent dialogErrorEvent) {
        SIPDialog sipDialog = (SIPDialog) dialogErrorEvent.getSource();
        SipListener sipListener = ((SipStackImpl)this).getSipListener();
        // if the app is not implementing the SipListenerExt interface we delete the dialog to avoid leaks
        if(sipDialog != null && !(sipListener instanceof SipListenerExt)) {
        	sipDialog.delete();
        }
    }

    /**
     * Stop stack. Clear all the timer stuff. Make the stack close all accept connections and
     * return. This is useful if you want to start/stop the stack several times from your
     * application. Caution : use of this function could cause peculiar bugs as messages are
     * prcessed asynchronously by the stack.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.503 -0500", hash_original_method = "EC17AB4FB84DCA37B1579E7D41B287E3", hash_generated_method = "4A2F130B701175FEA8A0343BA238F9B3")
    
public void stopStack() {
        // Prevent NPE on two concurrent stops
        if (this.timer != null)
            this.timer.cancel();

        // JvB: set it to null, SIPDialog tries to schedule things after stop
        timer = null;
        this.pendingTransactions.clear();
        this.toExit = true;
        synchronized (this) {
            this.notifyAll();
        }
        synchronized (this.clientTransactionTable) {
            clientTransactionTable.notifyAll();
        }

        synchronized (this.messageProcessors) {
            // Threads must periodically check this flag.
            MessageProcessor[] processorList;
            processorList = getMessageProcessors();
            for (int processorIndex = 0; processorIndex < processorList.length; processorIndex++) {
                removeMessageProcessor(processorList[processorIndex]);
            }
            this.ioHandler.closeAll();
            // Let the processing complete.

        }
        try {

            Thread.sleep(1000);

        } catch (InterruptedException ex) {
        }
        this.clientTransactionTable.clear();
        this.serverTransactionTable.clear();

        this.dialogTable.clear();
        this.serverLogger.closeLogFile();

    }

    /**
     * Put a transaction in the pending transaction list. This is to avoid a race condition when a
     * duplicate may arrive when the application is deciding whether to create a transaction or
     * not.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.506 -0500", hash_original_method = "CEE88C8969112A140A79BE7502F1A5FB", hash_generated_method = "B2F1E1C5DB311B07C47A34E4E860BCF2")
    
public void putPendingTransaction(SIPServerTransaction tr) {
        if (stackLogger.isLoggingEnabled())
            stackLogger.logDebug("putPendingTransaction: " + tr);

        this.pendingTransactions.put(tr.getTransactionId(), tr);

    }

    /**
     * Return the network layer (i.e. the interface for socket creation or the socket factory for
     * the stack).
     *
     * @return -- the registered Network Layer.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.509 -0500", hash_original_method = "A3344B5915DA0C5B05591E12A62D4610", hash_generated_method = "7DE4FC2E67027057C236674D6681D0A6")
    
public NetworkLayer getNetworkLayer() {
        if (networkLayer == null) {
            return DefaultNetworkLayer.SINGLETON;
        } else {
            return networkLayer;
        }
    }

    /**
     * Return true if logging is enabled for this stack.
     *
     * @return true if logging is enabled for this stack instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.512 -0500", hash_original_method = "47BDB9F0F1E73BBB0BEBE9D5C68FE123", hash_generated_method = "23A013C70EEBC3C31C79031F2A1CE622")
    
public boolean isLoggingEnabled() {
        return this.stackLogger == null ? false : this.stackLogger.isLoggingEnabled();
    }

    /**
     * Get the logger.
     *
     * @return --the logger for the sip stack. Each stack has its own logger instance.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.515 -0500", hash_original_method = "ACBC713DDCF210EE591047F9A9A515DC", hash_generated_method = "7D2347558735E2792F69AADCCBFE7A99")
    
public StackLogger getStackLogger() {
        return this.stackLogger;
    }

    /**
     * Server log is the place where we log messages for the signaling trace viewer.
     *
     * @return -- the log file where messages are logged for viewing by the trace viewer.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.517 -0500", hash_original_method = "01705032DE3FE074C7E055A3A8A4FEE3", hash_generated_method = "93A142C9849AD615852B1BDD6ECC9B12")
    
public ServerLogger getServerLogger() {
        return this.serverLogger;
    }

    /**
     * Maximum size of a single TCP message. Limiting the size of a single TCP message prevents
     * flooding attacks.
     *
     * @return the size of a single TCP message.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.520 -0500", hash_original_method = "9DA0FD5646924F30F0B4568C00D20E6E", hash_generated_method = "5D7197F6682327197549E1D5F5DB530F")
    
public int getMaxMessageSize() {
        return this.maxMessageSize;
    }

    /**
     * Set the flag that instructs the stack to only start a single thread for sequentially
     * processing incoming udp messages (thus serializing the processing). Same as setting thread
     * pool size to 1.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.523 -0500", hash_original_method = "F7820D79676ABCB839F961B1893B47B1", hash_generated_method = "ABFD2669A3D1521F2903892DD7B1E687")
    
public void setSingleThreaded() {
        this.threadPoolSize = 1;
    }

    /**
     * Set the thread pool size for processing incoming UDP messages. Limit the total number of
     * threads for processing udp messages.
     *
     * @param size -- the thread pool size.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.526 -0500", hash_original_method = "E9690233252AAFA4C640E8F4D35D05EB", hash_generated_method = "D587492E0EBAD7D4B7F8ACB9C7DA703A")
    
public void setThreadPoolSize(int size) {
        this.threadPoolSize = size;
    }

    /**
     * Set the max # of simultaneously handled TCP connections.
     *
     * @param nconnections -- the number of connections to handle.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.529 -0500", hash_original_method = "71AE725926CCD09A123AE8B2DA17A3F2", hash_generated_method = "18511D8F74EB60C45179158C8FC77D23")
    
public void setMaxConnections(int nconnections) {
        this.maxConnections = nconnections;
    }

    /**
     * Get the default route string.
     *
     * @param sipRequest is the request for which we want to compute the next hop.
     * @throws SipException
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.532 -0500", hash_original_method = "48A74B192606F2E929FFF01B3041CF91", hash_generated_method = "EA47F636A127BE244F7AA2DD38FC4AD7")
    
public Hop getNextHop(SIPRequest sipRequest) throws SipException {
        if (this.useRouterForAll) {
            // Use custom router to route all messages.
            if (router != null)
                return router.getNextHop(sipRequest);
            else
                return null;
        } else {
            // Also non-SIP request containing Route headers goes to the default
            // router
            if (sipRequest.getRequestURI().isSipURI() || sipRequest.getRouteHeaders() != null) {
                return defaultRouter.getNextHop(sipRequest);
            } else if (router != null) {
                return router.getNextHop(sipRequest);
            } else
                return null;
        }
    }

    /**
     * Set the descriptive name of the stack.
     *
     * @param stackName -- descriptive name of the stack.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.535 -0500", hash_original_method = "F49E7F0B68A71227FAAC90E58DC1BBF8", hash_generated_method = "980CEAD392759F451899F030D2C3222C")
    
public void setStackName(String stackName) {
        this.stackName = stackName;
    }

    /**
     * Set my address.
     *
     * @param stackAddress -- A string containing the stack address.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.537 -0500", hash_original_method = "A8237A45131D19EE871BFED3E7A5AA19", hash_generated_method = "FAE0A9BE518DEB5DDE06A8982129E328")
    
protected void setHostAddress(String stackAddress) throws UnknownHostException {
        if (stackAddress.indexOf(':') != stackAddress.lastIndexOf(':')
                && stackAddress.trim().charAt(0) != '[')
            this.stackAddress = '[' + stackAddress + ']';
        else
            this.stackAddress = stackAddress;
        this.stackInetAddress = InetAddress.getByName(stackAddress);
    }

    /**
     * Get my address.
     *
     * @return hostAddress - my host address or null if no host address is defined.
     * @deprecated
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.540 -0500", hash_original_method = "54480DAD55477A9080CEE058FAAB32DE", hash_generated_method = "BFB801AA51BAAE0E0DED7F6ADED8E5D0")
    
public String getHostAddress() {

        // JvB: for 1.2 this may return null...
        return this.stackAddress;
    }

    /**
     * Set the router algorithm. This is meant for routing messages out of dialog or for non-sip
     * uri's.
     *
     * @param router A class that implements the Router interface.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.543 -0500", hash_original_method = "76950F41C787A5DB271675B8BBBB662A", hash_generated_method = "6BFB3AFCF6B204BC3D6FA3BEB6B27550")
    
protected void setRouter(Router router) {
        this.router = router;
    }

    /**
     * Get the router algorithm.
     *
     * @return Router router
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.546 -0500", hash_original_method = "AF384EADB40CF611F4292AFC400A4743", hash_generated_method = "295CC57C5DE9D9C6E5166AE30664D2F6")
    
public Router getRouter(SIPRequest request) {
        if (request.getRequestLine() == null) {
            return this.defaultRouter;
        } else if (this.useRouterForAll) {
            return this.router;
        } else {
            if (request.getRequestURI().getScheme().equals("sip")
                    || request.getRequestURI().getScheme().equals("sips")) {
                return this.defaultRouter;
            } else {
                if (this.router != null)
                    return this.router;
                else
                    return defaultRouter;
            }
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.sip.SipStack#getRouter()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.548 -0500", hash_original_method = "A48D8CFCA0D4EF991F0CE4AA0090BC89", hash_generated_method = "C658478AD9FB4222C943FA73CC923D1F")
    
public Router getRouter() {
        return this.router;
    }

    /**
     * return the status of the toExit flag.
     *
     * @return true if the stack object is alive and false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.551 -0500", hash_original_method = "DA20B42A9F145510C718334C692F5A76", hash_generated_method = "E54D1418147C98C1F7126621FA4FD25B")
    
public boolean isAlive() {
        return !toExit;
    }

    /**
     * Adds a new MessageProcessor to the list of running processors for this SIPStack and starts
     * it. You can use this method for dynamic stack configuration.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.554 -0500", hash_original_method = "A1F941D6CE0FD78BF39EC8F9AC314942", hash_generated_method = "C972BE9BCA555461E0B0F1907BED8AEB")
    
protected void addMessageProcessor(MessageProcessor newMessageProcessor) throws IOException {
        synchronized (messageProcessors) {
            // Suggested changes by Jeyashankher, jai@lucent.com
            // newMessageProcessor.start() can fail
            // because a local port is not available
            // This throws an IOException.
            // We should not add the message processor to the
            // local list of processors unless the start()
            // call is successful.
            // newMessageProcessor.start();
            messageProcessors.add(newMessageProcessor);

        }
    }

    /**
     * Removes a MessageProcessor from this SIPStack.
     *
     * @param oldMessageProcessor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.557 -0500", hash_original_method = "CFCCE7E1C39F0D41098F0FE9085A25D2", hash_generated_method = "7EB0212B4AD686539ED06577A5369771")
    
protected void removeMessageProcessor(MessageProcessor oldMessageProcessor) {
        synchronized (messageProcessors) {
            if (messageProcessors.remove(oldMessageProcessor)) {
                oldMessageProcessor.stop();
            }
        }
    }

    /**
     * Gets an array of running MessageProcessors on this SIPStack. Acknowledgement: Jeff Keyser
     * suggested that applications should have access to the running message processors and
     * contributed this code.
     *
     * @return an array of running message processors.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.559 -0500", hash_original_method = "B73144BB70E5C3E03C6EB8CA5C201D44", hash_generated_method = "3FC10C50CCA451161D63ABC80DE915DD")
    
protected MessageProcessor[] getMessageProcessors() {
        synchronized (messageProcessors) {
            return (MessageProcessor[]) messageProcessors.toArray(new MessageProcessor[0]);
        }
    }

    /**
     * Creates the equivalent of a JAIN listening point and attaches to the stack.
     *
     * @param ipAddress -- ip address for the listening point.
     * @param port -- port for the listening point.
     * @param transport -- transport for the listening point.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.563 -0500", hash_original_method = "923CC6809D53E2778E41D61552555A7F", hash_generated_method = "E511BCC1AF273F27C4175DD9CE608F04")
    
protected MessageProcessor createMessageProcessor(InetAddress ipAddress, int port,
            String transport) throws java.io.IOException {
        if (transport.equalsIgnoreCase("udp")) {
            UDPMessageProcessor udpMessageProcessor = new UDPMessageProcessor(ipAddress, this,
                    port);
            this.addMessageProcessor(udpMessageProcessor);
            this.udpFlag = true;
            return udpMessageProcessor;
        } else if (transport.equalsIgnoreCase("tcp")) {
            TCPMessageProcessor tcpMessageProcessor = new TCPMessageProcessor(ipAddress, this,
                    port);
            this.addMessageProcessor(tcpMessageProcessor);
            // this.tcpFlag = true;
            return tcpMessageProcessor;
        } else if (transport.equalsIgnoreCase("tls")) {
            TLSMessageProcessor tlsMessageProcessor = new TLSMessageProcessor(ipAddress, this,
                    port);
            this.addMessageProcessor(tlsMessageProcessor);
            // this.tlsFlag = true;
            return tlsMessageProcessor;
        } else if (transport.equalsIgnoreCase("sctp")) {
        	
        	// Need Java 7 for this, so these classes are packaged in a separate jar
        	// Try to load it indirectly, if fails report an error
        	try {
				Class<?> mpc = ClassLoader.getSystemClassLoader().loadClass( "gov.nist.javax.sip.stack.sctp.SCTPMessageProcessor" );
				MessageProcessor mp = (MessageProcessor) mpc.newInstance();
				mp.initialize( ipAddress, port, this );
				this.addMessageProcessor(mp);
				return mp;
			} catch (ClassNotFoundException e) {
				throw new IllegalArgumentException("SCTP not supported (needs Java 7 and SCTP jar in classpath)");
			} catch ( InstantiationException ie ) {
				throw new IllegalArgumentException("Error initializing SCTP", ie);				
			} catch ( IllegalAccessException ie ) {
				throw new IllegalArgumentException("Error initializing SCTP", ie);				
			}
        } else {
            throw new IllegalArgumentException("bad transport");
        }

    }

    /**
     * Set the message factory.
     *
     * @param messageFactory -- messageFactory to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.565 -0500", hash_original_method = "B67F8BF0F619BF3DA8779F834D136A31", hash_generated_method = "C88A7D96A24080C1D4BB138C8A0F60F8")
    
protected void setMessageFactory(StackMessageFactory messageFactory) {
        this.sipMessageFactory = messageFactory;
    }

    /**
     * Creates a new MessageChannel for a given Hop.
     *
     * @param sourceIpAddress - Ip address of the source of this message.
     *
     * @param sourcePort - source port of the message channel to be created.
     *
     * @param nextHop Hop to create a MessageChannel to.
     *
     * @return A MessageChannel to the specified Hop, or null if no MessageProcessors support
     *         contacting that Hop.
     *
     * @throws UnknownHostException If the host in the Hop doesn't exist.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.569 -0500", hash_original_method = "79BA5457C24B1F2BABB705E59D2E5DE3", hash_generated_method = "58F2E9D2C05DB337905336250F7AC6FA")
    
public MessageChannel createRawMessageChannel(String sourceIpAddress, int sourcePort,
            Hop nextHop) throws UnknownHostException {
        Host targetHost;
        HostPort targetHostPort;
        Iterator processorIterator;
        MessageProcessor nextProcessor;
        MessageChannel newChannel;

        // Create the host/port of the target hop
        targetHost = new Host();
        targetHost.setHostname(nextHop.getHost());
        targetHostPort = new HostPort();
        targetHostPort.setHost(targetHost);
        targetHostPort.setPort(nextHop.getPort());

        // Search each processor for the correct transport
        newChannel = null;
        processorIterator = messageProcessors.iterator();
        while (processorIterator.hasNext() && newChannel == null) {
            nextProcessor = (MessageProcessor) processorIterator.next();
            // If a processor that supports the correct
            // transport is found,
            if (nextHop.getTransport().equalsIgnoreCase(nextProcessor.getTransport())
                    && sourceIpAddress.equals(nextProcessor.getIpAddress().getHostAddress())
                    && sourcePort == nextProcessor.getPort()) {
                try {
                    // Create a channel to the target
                    // host/port
                    newChannel = nextProcessor.createMessageChannel(targetHostPort);
                } catch (UnknownHostException ex) {
                    if (stackLogger.isLoggingEnabled())
                        stackLogger.logException(ex);
                    throw ex;
                } catch (IOException e) {
                    if (stackLogger.isLoggingEnabled())
                        stackLogger.logException(e);
                    // Ignore channel creation error -
                    // try next processor
                }
            }
        }
        // Return the newly-created channel
        return newChannel;
    }

    /**
     * Return true if a given event can result in a forked subscription. The stack is configured
     * with a set of event names that can result in forked subscriptions.
     *
     * @param ename -- event name to check.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.572 -0500", hash_original_method = "35D04CBE96754834C212489B2C606D95", hash_generated_method = "F5F6A56CFB66A092A4E32CC53D0B5CC7")
    
public boolean isEventForked(String ename) {
        if (stackLogger.isLoggingEnabled()) {
            stackLogger.logDebug("isEventForked: " + ename + " returning "
                    + this.forkedEvents.contains(ename));
        }
        return this.forkedEvents.contains(ename);
    }

    /**
     * get the address resolver interface.
     *
     * @return -- the registered address resolver.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.575 -0500", hash_original_method = "8980F34FD4722FAAB08CBB90B3E36CA2", hash_generated_method = "34FC921C955EE5B517F7727B9AFCFD12")
    
public AddressResolver getAddressResolver() {
        return this.addressResolver;
    }

    /**
     * Set the address resolution interface
     *
     * @param addressResolver -- the address resolver to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.578 -0500", hash_original_method = "3C1DAA52D018FB69E50FF9E6B399590F", hash_generated_method = "14D8024A826FAB81AA757403A030ADAF")
    
public void setAddressResolver(AddressResolver addressResolver) {
        this.addressResolver = addressResolver;
    }

    /**
     * Set the logger factory.
     *
     * @param logRecordFactory -- the log record factory to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.580 -0500", hash_original_method = "906B74670BE04C4A719BBC503CD663E5", hash_generated_method = "2E81453480021FEBD6257C11BA3B2D4E")
    
public void setLogRecordFactory(LogRecordFactory logRecordFactory) {
        this.logRecordFactory = logRecordFactory;
    }

    /**
     * get the thread auditor object
     *
     * @return -- the thread auditor of the stack
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.584 -0500", hash_original_method = "2953BF87EC3C3B721F79C36C05ACD684", hash_generated_method = "D23AB41F7F5C5D682F80B8FD0D68412A")
    
public ThreadAuditor getThreadAuditor() {
        return this.threadAuditor;
    }

    // /
    // / Stack Audit methods
    // /

    /**
     * Audits the SIP Stack for leaks
     *
     * @return Audit report, null if no leaks were found
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.587 -0500", hash_original_method = "DA93EFB6297A5552E15BC0248101E996", hash_generated_method = "84449B13270383501CCC60F1CE80C5AC")
    
public String auditStack(Set activeCallIDs, long leakedDialogTimer,
            long leakedTransactionTimer) {
        String auditReport = null;
        String leakedDialogs = auditDialogs(activeCallIDs, leakedDialogTimer);
        String leakedServerTransactions = auditTransactions(serverTransactionTable,
                leakedTransactionTimer);
        String leakedClientTransactions = auditTransactions(clientTransactionTable,
                leakedTransactionTimer);
        if (leakedDialogs != null || leakedServerTransactions != null
                || leakedClientTransactions != null) {
            auditReport = "SIP Stack Audit:\n" + (leakedDialogs != null ? leakedDialogs : "")
                    + (leakedServerTransactions != null ? leakedServerTransactions : "")
                    + (leakedClientTransactions != null ? leakedClientTransactions : "");
        }
        return auditReport;
    }

    /**
     * Audits SIP dialogs for leaks - Compares the dialogs in the dialogTable with a list of Call
     * IDs passed by the application. - Dialogs that are not known by the application are leak
     * suspects. - Kill the dialogs that are still around after the timer specified.
     *
     * @return Audit report, null if no dialog leaks were found
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.591 -0500", hash_original_method = "5A76CC0B1A3067E5B9DACF3EB61E431C", hash_generated_method = "8C4AABB785909C003FDE6A663BCA9D8F")
    
private String auditDialogs(Set activeCallIDs, long leakedDialogTimer) {
        String auditReport = "  Leaked dialogs:\n";
        int leakedDialogs = 0;
        long currentTime = System.currentTimeMillis();

        // Make a shallow copy of the dialog list.
        // This copy will remain intact as leaked dialogs are removed by the
        // stack.
        LinkedList dialogs;
        synchronized (dialogTable) {
            dialogs = new LinkedList(dialogTable.values());
        }

        // Iterate through the dialogDialog, get the callID of each dialog and
        // check if it's in the
        // list of active calls passed by the application. If it isn't, start
        // the timer on it.
        // If the timer has expired, kill the dialog.
        Iterator it = dialogs.iterator();
        while (it.hasNext()) {
            // Get the next dialog
            SIPDialog itDialog = (SIPDialog) it.next();

            // Get the call id associated with this dialog
            CallIdHeader callIdHeader = (itDialog != null ? itDialog.getCallId() : null);
            String callID = (callIdHeader != null ? callIdHeader.getCallId() : null);

            // Check if the application knows about this call id
            if (itDialog != null && callID != null && !activeCallIDs.contains(callID)) {
                // Application doesn't know anything about this dialog...
                if (itDialog.auditTag == 0) {
                    // Mark this dialog as suspect
                    itDialog.auditTag = currentTime;
                } else {
                    // We already audited this dialog before. Check if his
                    // time's up.
                    if (currentTime - itDialog.auditTag >= leakedDialogTimer) {
                        // Leaked dialog found
                        leakedDialogs++;

                        // Generate report
                        DialogState dialogState = itDialog.getState();
                        String dialogReport = "dialog id: " + itDialog.getDialogId()
                                + ", dialog state: "
                                + (dialogState != null ? dialogState.toString() : "null");
                        auditReport += "    " + dialogReport + "\n";

                        // Kill it
                        itDialog.setState(SIPDialog.TERMINATED_STATE);
                        if (stackLogger.isLoggingEnabled())
                        	stackLogger.logDebug("auditDialogs: leaked " + dialogReport);
                    }
                }
            }
        }

        // Return final report
        if (leakedDialogs > 0) {
            auditReport += "    Total: " + Integer.toString(leakedDialogs)
                    + " leaked dialogs detected and removed.\n";
        } else {
            auditReport = null;
        }
        return auditReport;
    }

    /**
     * Audits SIP transactions for leaks
     *
     * @return Audit report, null if no transaction leaks were found
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.594 -0500", hash_original_method = "B29AC2188DE994EDE68B3EFDD85B41F1", hash_generated_method = "C9E4B079ADF87AC96205F417C0149E3E")
    
private String auditTransactions(ConcurrentHashMap transactionsMap,
            long a_nLeakedTransactionTimer) {
        String auditReport = "  Leaked transactions:\n";
        int leakedTransactions = 0;
        long currentTime = System.currentTimeMillis();

        // Make a shallow copy of the transaction list.
        // This copy will remain intact as leaked transactions are removed by
        // the stack.
        LinkedList transactionsList = new LinkedList(transactionsMap.values());

        // Iterate through our copy
        Iterator it = transactionsList.iterator();
        while (it.hasNext()) {
            SIPTransaction sipTransaction = (SIPTransaction) it.next();
            if (sipTransaction != null) {
                if (sipTransaction.auditTag == 0) {
                    // First time we see this transaction. Mark it as audited.
                    sipTransaction.auditTag = currentTime;
                } else {
                    // We've seen this transaction before. Check if his time's
                    // up.
                    if (currentTime - sipTransaction.auditTag >= a_nLeakedTransactionTimer) {
                        // Leaked transaction found
                        leakedTransactions++;

                        // Generate some report
                        TransactionState transactionState = sipTransaction.getState();
                        SIPRequest origRequest = sipTransaction.getOriginalRequest();
                        String origRequestMethod = (origRequest != null ? origRequest.getMethod()
                                : null);
                        String transactionReport = sipTransaction.getClass().getName()
                                + ", state: "
                                + (transactionState != null ? transactionState.toString()
                                        : "null") + ", OR: "
                                + (origRequestMethod != null ? origRequestMethod : "null");
                        auditReport += "    " + transactionReport + "\n";

                        // Kill it
                        removeTransaction(sipTransaction);
                        if (isLoggingEnabled())
                        	stackLogger.logDebug("auditTransactions: leaked " + transactionReport);
                    }
                }
            }
        }

        // Return final report
        if (leakedTransactions > 0) {
            auditReport += "    Total: " + Integer.toString(leakedTransactions)
                    + " leaked transactions detected and removed.\n";
        } else {
            auditReport = null;
        }
        return auditReport;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.597 -0500", hash_original_method = "216776ED7A95FC4D69FC6626B7475336", hash_generated_method = "B7744DB49D6FFEDDC5242C312F03752B")
    
public void setNon2XXAckPassedToListener(boolean passToListener) {
        this.non2XXAckPassedToListener = passToListener;
    }

    /**
     * @return the non2XXAckPassedToListener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.600 -0500", hash_original_method = "6286CBBFF5CE6322EC732C5543B43EDA", hash_generated_method = "C9128403A6B2E3EEE1D320469DDBFB8D")
    
public boolean isNon2XXAckPassedToListener() {
        return non2XXAckPassedToListener;
    }

    /**
     * Get the count of client transactions that is not in the completed or terminated state.
     *
     * @return the activeClientTransactionCount
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.603 -0500", hash_original_method = "39908A44D12AF4672A8DE059DC86C6F0", hash_generated_method = "3D17621092870ED2714151924E301F9A")
    
public int getActiveClientTransactionCount() {
        return activeClientTransactionCount.get();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.605 -0500", hash_original_method = "2D01936677D6715578D012ACFAF4D8A9", hash_generated_method = "B942D187599941815E0ED601EF0973DB")
    
public boolean isRfc2543Supported() {

        return this.rfc2543Supported;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.608 -0500", hash_original_method = "71493EE5805AD2AB9A60D51292B7773D", hash_generated_method = "D6306FB6132342311B52450E52E08AB8")
    
public boolean isCancelClientTransactionChecked() {
        return this.cancelClientTransactionChecked;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.611 -0500", hash_original_method = "45004C11584D234E2C0351030C5C7691", hash_generated_method = "2824E10C3D8F203293771E3F9302D60F")
    
public boolean isRemoteTagReassignmentAllowed() {
        return this.remoteTagReassignmentAllowed;
    }

    /**
     * This method is slated for addition to the next spec revision.
     *
     *
     * @return -- the collection of dialogs that is being managed by the stack.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.613 -0500", hash_original_method = "20ADA27D372C754940A803F19F3E7AD9", hash_generated_method = "B993E15C8FD752DCA41B35439FC2EF4D")
    
public Collection<Dialog> getDialogs() {
        HashSet<Dialog> dialogs = new HashSet<Dialog>();
        dialogs.addAll(this.dialogTable.values());
        dialogs.addAll(this.earlyDialogTable.values());
        return dialogs;
    }

    /**
     *
     * @return -- the collection of dialogs matching the state that is being managed by the stack.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.617 -0500", hash_original_method = "9851D171868856682CD66D2C2C77C100", hash_generated_method = "05A622841C2E13563FC2FEB9F17348D7")
    
public Collection<Dialog> getDialogs(DialogState state) {
        HashSet<Dialog> matchingDialogs = new HashSet<Dialog>();
        if (DialogState.EARLY.equals(state)) {
            matchingDialogs.addAll(this.earlyDialogTable.values());
        } else {
            Collection<SIPDialog> dialogs = dialogTable.values();
            for (SIPDialog dialog : dialogs) {
                if (dialog.getState() != null && dialog.getState().equals(state)) {
                    matchingDialogs.add(dialog);
                }
            }
        }
        return matchingDialogs;
    }

    /**
     * Get the Replaced Dialog from the stack.
     *
     * @param replacesHeader -- the header that references the dialog being replaced.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.620 -0500", hash_original_method = "B020A334EC30ACCE61108F29E8239DE0", hash_generated_method = "38CE4AE3611E20DB382531CB7CAB8662")
    
public Dialog getReplacesDialog(ReplacesHeader replacesHeader) {
        String cid = replacesHeader.getCallId();
        String fromTag = replacesHeader.getFromTag();
        String toTag = replacesHeader.getToTag();

        StringBuffer dialogId = new StringBuffer(cid);

        // retval.append(COLON).append(to.getUserAtHostPort());
        if (toTag != null) {
            dialogId.append(":");
            dialogId.append(toTag);
        }
        // retval.append(COLON).append(from.getUserAtHostPort());
        if (fromTag != null) {
            dialogId.append(":");
            dialogId.append(fromTag);
        }
        String did = dialogId.toString().toLowerCase();
        if (stackLogger.isLoggingEnabled())
        	stackLogger.logDebug("Looking for dialog " + did);
        /*
         * Check if we can find this dialog in our dialog table.
         */
        Dialog replacesDialog =  this.dialogTable.get(did);
        /*
         * This could be a forked dialog. Search for it.
         */
        if ( replacesDialog == null ) {
           for ( SIPClientTransaction ctx : this.clientTransactionTable.values()) {
               if ( ctx.getDialog(did) != null ) {
                   replacesDialog = ctx.getDialog(did);
                   break;
               }
           }
        }

        return replacesDialog;
    }

    /**
     * Get the Join Dialog from the stack.
     *
     * @param joinHeader -- the header that references the dialog being joined.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.623 -0500", hash_original_method = "01BB795BEB07C4ED2A3CDD99078DB107", hash_generated_method = "57830CCCDF3B9E719CB411DAA5686F28")
    
public Dialog getJoinDialog(JoinHeader joinHeader) {
        String cid = joinHeader.getCallId();
        String fromTag = joinHeader.getFromTag();
        String toTag = joinHeader.getToTag();

        StringBuffer retval = new StringBuffer(cid);

        // retval.append(COLON).append(to.getUserAtHostPort());
        if (toTag != null) {
            retval.append(":");
            retval.append(toTag);
        }
        // retval.append(COLON).append(from.getUserAtHostPort());
        if (fromTag != null) {
            retval.append(":");
            retval.append(fromTag);
        }
        return this.dialogTable.get(retval.toString().toLowerCase());
    }

    /**
     * @param timer the timer to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.626 -0500", hash_original_method = "69B105104758CF3A0416D8C1D4F4DE0D", hash_generated_method = "3397DA74626755AEAD45E22E813560AE")
    
public void setTimer(Timer timer) {
        this.timer = timer;
    }

    /**
     * @return the timer
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.628 -0500", hash_original_method = "8E3D165A90C48C9C43C8115575D5D434", hash_generated_method = "A31D54C10590EFD84D8B925BD8120262")
    
public Timer getTimer() {
        return timer;
    }
    
    /**
     * Size of the receive UDP buffer. This property affects performance under load. Bigger buffer
     * is better under load.
     * 
     * @return
     */
	@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.632 -0500", hash_original_method = "535D845393F6631B713A5EAFAC15730B", hash_generated_method = "F343591B531FD73E6B1538A593F4380C")
    
public int getReceiveUdpBufferSize() {
		return receiveUdpBufferSize;
	}

    /**
     * Size of the receive UDP buffer. This property affects performance under load. Bigger buffer
     * is better under load.
     * 
     * @return
     */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.634 -0500", hash_original_method = "AD9781079D581597B87998F87481A2EF", hash_generated_method = "7912ED9D69EE3F7E6C8C3AC1981CA27B")
    
public void setReceiveUdpBufferSize(int receiveUdpBufferSize) {
		this.receiveUdpBufferSize = receiveUdpBufferSize;
	}

    /**
     * Size of the send UDP buffer. This property affects performance under load. Bigger buffer
     * is better under load.
     * 
     * @return
     */
	@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.637 -0500", hash_original_method = "7F1E49D75F179129A028D4152C30D3F6", hash_generated_method = "5266B458B7B0F2EA5057A8A11C540B86")
    
public int getSendUdpBufferSize() {
		return sendUdpBufferSize;
	}

    /**
     * Size of the send UDP buffer. This property affects performance under load. Bigger buffer
     * is better under load.
     * 
     * @return
     */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.640 -0500", hash_original_method = "085E2E0AF6AC7C34DFF993E649718D81", hash_generated_method = "FD49494A339FAA54D83F8EAC809E5258")
    
public void setSendUdpBufferSize(int sendUdpBufferSize) {
		this.sendUdpBufferSize = sendUdpBufferSize;
	}

	/**
	 * @param stackLogger the stackLogger to set
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.643 -0500", hash_original_method = "3649FCA00F1F012AB31400D887FE5668", hash_generated_method = "858A3CACC34C3D8A9FB31A6A37934DB1")
    
public void setStackLogger(StackLogger stackLogger) {		
		this.stackLogger = stackLogger;
	}
	
	 /**
	  * Flag that reqests checking of branch IDs on responses.
	  * 
	  * @return
	  */
	 @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.645 -0500", hash_original_method = "3A00FD245E091565EAC4D2A0BF135C63", hash_generated_method = "8901A73A778C103F6D40C70DADE93696")
    
public boolean checkBranchId() {
	       return this.checkBranchId;
	 }

    /**
     * @param logStackTraceOnMessageSend the logStackTraceOnMessageSend to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.648 -0500", hash_original_method = "4B576FDEB92FCE56B4004D51F27F133D", hash_generated_method = "50F9019CCE6E04B51AA97DE60C430FCD")
    
public void setLogStackTraceOnMessageSend(boolean logStackTraceOnMessageSend) {
        this.logStackTraceOnMessageSend = logStackTraceOnMessageSend;
    }

    /**
     * @return the logStackTraceOnMessageSend
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.651 -0500", hash_original_method = "6EA33CFFB30E0EA85B4B3B5316E0B073", hash_generated_method = "F829A9689B9FA0D5A46BCECBE3C8908C")
    
public boolean isLogStackTraceOnMessageSend() {
        return logStackTraceOnMessageSend;
    }
    
    class PingTimer extends SIPStackTimerTask {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.338 -0500", hash_original_field = "3AE84B2399BFC1B1844D24A06D20C249", hash_generated_field = "3AE84B2399BFC1B1844D24A06D20C249")

        ThreadAuditor.ThreadHandle threadHandle;

        // / Constructor
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.342 -0500", hash_original_method = "BD8473F7A826DDA501F390A58BAECB33", hash_generated_method = "4DD3E5DA73D3B971F7380289712255F4")
        
public PingTimer(ThreadAuditor.ThreadHandle a_oThreadHandle) {
            threadHandle = a_oThreadHandle;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.345 -0500", hash_original_method = "D20FBACDA77D9F2BECED97C9063F3E91", hash_generated_method = "9210420433FD6BE235B5519E25F693CC")
        
protected void runTask() {
            // Check if we still have a timer (it may be null after shutdown)
            if (getTimer() != null) {
                // Register the timer task if we haven't done so
                if (threadHandle == null) {
                    // This happens only once since the thread handle is passed
                    // to the next scheduled ping timer
                    threadHandle = getThreadAuditor().addCurrentThread();
                }

                // Let the thread auditor know that the timer task is alive
                threadHandle.ping();

                // Schedule the next ping
                getTimer().schedule(new PingTimer(threadHandle),
                        threadHandle.getPingIntervalInMillisecs());
            }
        }
        
    }
    
    class RemoveForkedTransactionTimerTask extends SIPStackTimerTask {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.351 -0500", hash_original_field = "9CD5311870B0235CB989809E66CE6801", hash_generated_field = "346E85BD6DDF8042B729A2408B44CDD3")
        
        private SIPClientTransaction clientTransaction;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.354 -0500", hash_original_method = "D0A941D96C1666EFE3BE3721976F6AA6", hash_generated_method = "6E5E8F716EE7E7476ACC7081EFF9385F")
        
public RemoveForkedTransactionTimerTask(SIPClientTransaction sipClientTransaction ) {
            this.clientTransaction = sipClientTransaction;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.357 -0500", hash_original_method = "0A8A5E2C1505E2C2E84219D84E5444CF", hash_generated_method = "DBED303F369DD220A7A89B65C69E0ED9")
        
@Override
        protected void runTask() {
           forkedClientTransactionTable.remove(clientTransaction.getTransactionId()); 
        }
        
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.653 -0500", hash_original_method = "BBC3144A1CF9CB1C9F37A775F293720F", hash_generated_method = "7D1173FECF4AA8DB711F59E1F4908F35")
    
public void setDeliverDialogTerminatedEventForNullDialog() {
        this.isDialogTerminatedEventDeliveredForNullDialog = true;
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.656 -0500", hash_original_method = "C791CC7BC6998146618C651EB49E3406", hash_generated_method = "6A0E3D4431CEC3AD32F3CF9CD12C01BC")
    
public void addForkedClientTransaction(SIPClientTransaction clientTransaction) {
        this.forkedClientTransactionTable.put(clientTransaction.getTransactionId(), clientTransaction );
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:20.659 -0500", hash_original_method = "A07C61DB9453AEA0A84C4416E8A5508E", hash_generated_method = "5161D4027E430496DB41169AA9F4CB33")
    
public SIPClientTransaction getForkedTransaction(String transactionId) {
        return this.forkedClientTransactionTable.get(transactionId);
    }
    static {
    	dialogCreatingMethods.add(Request.REFER);
        dialogCreatingMethods.add(Request.INVITE);
        dialogCreatingMethods.add(Request.SUBSCRIBE);
    }
    
}

