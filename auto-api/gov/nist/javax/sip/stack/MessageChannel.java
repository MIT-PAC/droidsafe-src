package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.Host;
import gov.nist.core.HostPort;
import gov.nist.core.InternalErrorHandler;
import gov.nist.core.ServerLogger;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.ContentLength;
import gov.nist.javax.sip.header.ContentType;
import gov.nist.javax.sip.header.Via;
import gov.nist.javax.sip.message.MessageFactoryImpl;
import gov.nist.javax.sip.message.SIPMessage;
import gov.nist.javax.sip.message.SIPRequest;
import gov.nist.javax.sip.message.SIPResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.text.ParseException;
import javax.sip.address.Hop;
import javax.sip.header.CSeqHeader;
import javax.sip.header.CallIdHeader;
import javax.sip.header.ContactHeader;
import javax.sip.header.ContentLengthHeader;
import javax.sip.header.ContentTypeHeader;
import javax.sip.header.FromHeader;
import javax.sip.header.ServerHeader;
import javax.sip.header.ToHeader;
import javax.sip.header.ViaHeader;

public abstract class MessageChannel {
    protected int useCount;
    protected transient MessageProcessor messageProcessor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.887 -0400", hash_original_method = "1C3928EA9ED2F7F446DAACF302660FFE", hash_generated_method = "1C3928EA9ED2F7F446DAACF302660FFE")
        public MessageChannel ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.887 -0400", hash_original_method = "B5543AC884E160C74E00608F95C390A3", hash_generated_method = "547268D6CF76DECC0066A4DC26EFC855")
    @DSModeled(DSC.SAFE)
    protected void uncache() {
        // ---------- Original Method ----------
    }

    
    public abstract void close();

    
    public abstract SIPTransactionStack getSIPStack();

    
    public abstract String getTransport();

    
    public abstract boolean isReliable();

    
    public abstract boolean isSecure();

    
    public abstract void sendMessage(SIPMessage sipMessage) throws IOException;

    
    public abstract String getPeerAddress();

    
    protected abstract InetAddress getPeerInetAddress();

    
    protected abstract String getPeerProtocol();

    
    public abstract int getPeerPort();

    
    public abstract int getPeerPacketSourcePort();

    
    public abstract InetAddress getPeerPacketSourceAddress();

    
    public abstract String getKey();

    
    public abstract String getViaHost();

    
    public abstract int getViaPort();

    
    protected abstract void sendMessage(byte[] message, InetAddress receiverAddress,
            int receiverPort, boolean reconnectFlag) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.891 -0400", hash_original_method = "CA1BACEAFC0549F0AA4E82303BA5F480", hash_generated_method = "7B3A3550AB2A8A4499EC77C4C4A33015")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getHost() {
        String varCB0E262FA3C0E487FDA46A765FFCC822_1942564536 = (this.getMessageProcessor().getIpAddress().getHostAddress());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.getMessageProcessor().getIpAddress().getHostAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.891 -0400", hash_original_method = "D12E0B39D0A0A3DBD8096F94437302A2", hash_generated_method = "5EF620162A3D615B8D26C157C62E1267")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPort() {
        int varA100E41244C68A9F97324F08F822F83F_1156453311 = (messageProcessor.getPort());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (this.messageProcessor != null)
            //return messageProcessor.getPort();
        //else
            //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.910 -0400", hash_original_method = "6965EB337B784D47DD1B6D5165D2FBD3", hash_generated_method = "E0EB8ADBC38DE98F003049A5213A7BAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendMessage(SIPMessage sipMessage, Hop hop) throws IOException {
        dsTaint.addTaint(sipMessage.dsTaint);
        dsTaint.addTaint(hop.dsTaint);
        long time;
        time = System.currentTimeMillis();
        InetAddress hopAddr;
        hopAddr = InetAddress.getByName(hop.getHost());
        try 
        {
            {
                MessageProcessor messageProcessor = getSIPStack().getMessageProcessors()[0];
                {
                    {
                        boolean var7765B2DC295364D1C19B74A079B8042D_1377822308 = (messageProcessor.getIpAddress().equals(hopAddr)
                        && messageProcessor.getPort() == hop.getPort()
                        && messageProcessor.getTransport().equals(hop.getTransport()));
                        {
                            MessageChannel messageChannel;
                            messageChannel = messageProcessor.createMessageChannel(
                            hopAddr, hop.getPort());
                            {
                                ((RawMessageChannel) messageChannel).processMessage(sipMessage);
                                {
                                    boolean varB302AC6B07F52C4E2326C0A8080C6396_2092719224 = (getSIPStack().isLoggingEnabled());
                                    getSIPStack().getStackLogger().logDebug("Self routing message");
                                } //End collapsed parenthetic
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            byte[] msg;
            msg = sipMessage.encodeAsBytes(this.getTransport());
            this.sendMessage(msg, hopAddr, hop.getPort(), sipMessage instanceof SIPRequest);
        } //End block
        catch (IOException ioe)
        {
            if (DroidSafeAndroidRuntime.control) throw ioe;
        } //End block
        catch (Exception ex)
        {
            {
                boolean varF431BBF7DDBE8461EF02D058C832AD01_1700369331 = (this.getSIPStack().getStackLogger().isLoggingEnabled(ServerLogger.TRACE_ERROR));
                {
                    this.getSIPStack().getStackLogger().logError("Error self routing message cause by: ", ex);
                } //End block
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw new IOException("Error self routing message");
        } //End block
        finally 
        {
            {
                boolean var7A4E9416A69CB8A92770D24F8DF72D74_2085448378 = (this.getSIPStack().getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES));
                logMessage(sipMessage, hopAddr, hop.getPort(), time);
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.911 -0400", hash_original_method = "4AF33D1C82235ED60B6E3DD0D1967C25", hash_generated_method = "5269B7D286461759D0AE61C81696D626")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendMessage(SIPMessage sipMessage, InetAddress receiverAddress, int receiverPort) throws IOException {
        dsTaint.addTaint(sipMessage.dsTaint);
        dsTaint.addTaint(receiverPort);
        dsTaint.addTaint(receiverAddress.dsTaint);
        long time;
        time = System.currentTimeMillis();
        byte[] bytes;
        bytes = sipMessage.encodeAsBytes(this.getTransport());
        sendMessage(bytes, receiverAddress, receiverPort, sipMessage instanceof SIPRequest);
        logMessage(sipMessage, receiverAddress, receiverPort, time);
        // ---------- Original Method ----------
        //long time = System.currentTimeMillis();
        //byte[] bytes = sipMessage.encodeAsBytes(this.getTransport());
        //sendMessage(bytes, receiverAddress, receiverPort, sipMessage instanceof SIPRequest);
        //logMessage(sipMessage, receiverAddress, receiverPort, time);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.911 -0400", hash_original_method = "BC100C85F7EEF6C9116B6E540185BCE8", hash_generated_method = "CCF3DB31EA5B3A00F2AF16038F41EF2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getRawIpSourceAddress() {
        String sourceAddress;
        sourceAddress = getPeerAddress();
        String rawIpSourceAddress;
        rawIpSourceAddress = null;
        try 
        {
            InetAddress sourceInetAddress;
            sourceInetAddress = InetAddress.getByName(sourceAddress);
            rawIpSourceAddress = sourceInetAddress.getHostAddress();
        } //End block
        catch (Exception ex)
        {
            InternalErrorHandler.handleException(ex);
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String sourceAddress = getPeerAddress();
        //String rawIpSourceAddress = null;
        //try {
            //InetAddress sourceInetAddress = InetAddress.getByName(sourceAddress);
            //rawIpSourceAddress = sourceInetAddress.getHostAddress();
        //} catch (Exception ex) {
            //InternalErrorHandler.handleException(ex);
        //}
        //return rawIpSourceAddress;
    }

    
        public static String getKey(InetAddress inetAddr, int port, String transport) {
        return (transport + ":" + inetAddr.getHostAddress() + ":" + port).toLowerCase();
    }

    
        public static String getKey(HostPort hostPort, String transport) {
        return (transport + ":" + hostPort.getHost().getHostname() + ":" + hostPort.getPort())
                .toLowerCase();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.912 -0400", hash_original_method = "A44FE176AC0185A0737BBEE3031992DB", hash_generated_method = "EDC2F688E951002FB3D67D4A9790F70C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HostPort getHostPort() {
        HostPort retval;
        retval = new HostPort();
        retval.setHost(new Host(this.getHost()));
        retval.setPort(this.getPort());
        return (HostPort)dsTaint.getTaint();
        // ---------- Original Method ----------
        //HostPort retval = new HostPort();
        //retval.setHost(new Host(this.getHost()));
        //retval.setPort(this.getPort());
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.912 -0400", hash_original_method = "B86C07836DB50334479A6BD4BF7381CC", hash_generated_method = "C1526A998509648D6D87B8E7101EE923")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HostPort getPeerHostPort() {
        HostPort retval;
        retval = new HostPort();
        retval.setHost(new Host(this.getPeerAddress()));
        retval.setPort(this.getPeerPort());
        return (HostPort)dsTaint.getTaint();
        // ---------- Original Method ----------
        //HostPort retval = new HostPort();
        //retval.setHost(new Host(this.getPeerAddress()));
        //retval.setPort(this.getPeerPort());
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.912 -0400", hash_original_method = "31F63348466D8C31B05195508CA771AE", hash_generated_method = "15152CBF53C2AAA8CD6EA6607D1ACE9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Via getViaHeader() {
        Via channelViaHeader;
        channelViaHeader = new Via();
        try 
        {
            channelViaHeader.setTransport(getTransport());
        } //End block
        catch (ParseException ex)
        { }
        channelViaHeader.setSentBy(getHostPort());
        return (Via)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Via channelViaHeader;
        //channelViaHeader = new Via();
        //try {
            //channelViaHeader.setTransport(getTransport());
        //} catch (ParseException ex) {
        //}
        //channelViaHeader.setSentBy(getHostPort());
        //return channelViaHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.912 -0400", hash_original_method = "8AF1560686CCA72CFE111D9FA9C1ECDE", hash_generated_method = "7223D088E2FFB7F6F38D9F708F3E66C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HostPort getViaHostPort() {
        HostPort retval;
        retval = new HostPort();
        retval.setHost(new Host(this.getViaHost()));
        retval.setPort(this.getViaPort());
        return (HostPort)dsTaint.getTaint();
        // ---------- Original Method ----------
        //HostPort retval = new HostPort();
        //retval.setHost(new Host(this.getViaHost()));
        //retval.setPort(this.getViaPort());
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.913 -0400", hash_original_method = "C068429579A247F633492130419A4C88", hash_generated_method = "396F168A94C4690268DCDC65F56DB37C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void logMessage(SIPMessage sipMessage, InetAddress address, int port, long time) {
        dsTaint.addTaint(port);
        dsTaint.addTaint(time);
        dsTaint.addTaint(address.dsTaint);
        dsTaint.addTaint(sipMessage.dsTaint);
        {
            boolean var2516254AC94744EE5F2042143C2C2CA0_1245158029 = (!getSIPStack().getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES));
        } //End collapsed parenthetic
        port = 5060;
        getSIPStack().serverLogger.logMessage(sipMessage, this.getHost() + ":" + this.getPort(),
                address.getHostAddress().toString() + ":" + port, true, time);
        // ---------- Original Method ----------
        //if (!getSIPStack().getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES))
            //return;
        //if (port == -1)
            //port = 5060;
        //getSIPStack().serverLogger.logMessage(sipMessage, this.getHost() + ":" + this.getPort(),
                //address.getHostAddress().toString() + ":" + port, true, time);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.913 -0400", hash_original_method = "F3D4D9112F2E8581D299D1D033206DF5", hash_generated_method = "E06742FAA2F1D8E072BA8BD9BE44D9C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void logResponse(SIPResponse sipResponse, long receptionTime, String status) {
        dsTaint.addTaint(status);
        dsTaint.addTaint(receptionTime);
        dsTaint.addTaint(sipResponse.dsTaint);
        int peerport;
        peerport = getPeerPort();
        {
            boolean var321536B5BBF9E022C6F05C23921B41FC_1639582774 = (peerport == 0 && sipResponse.getContactHeaders() != null);
            {
                ContactHeader contact;
                contact = (ContactHeader) sipResponse.getContactHeaders().getFirst();
                peerport = ((AddressImpl) contact.getAddress()).getPort();
            } //End block
        } //End collapsed parenthetic
        String from;
        from = getPeerAddress().toString() + ":" + peerport;
        String to;
        to = this.getHost() + ":" + getPort();
        this.getSIPStack().serverLogger.logMessage(sipResponse, from, to, status, false,
                receptionTime);
        // ---------- Original Method ----------
        //int peerport = getPeerPort();
        //if (peerport == 0 && sipResponse.getContactHeaders() != null) {
            //ContactHeader contact = (ContactHeader) sipResponse.getContactHeaders().getFirst();
            //peerport = ((AddressImpl) contact.getAddress()).getPort();
        //}
        //String from = getPeerAddress().toString() + ":" + peerport;
        //String to = this.getHost() + ":" + getPort();
        //this.getSIPStack().serverLogger.logMessage(sipResponse, from, to, status, false,
                //receptionTime);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.914 -0400", hash_original_method = "FECBC10325F07301270E33C64C8E0AD0", hash_generated_method = "A5B6A1DA65652B59EA1049DB689B7C3D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final String createBadReqRes(String badReq, ParseException pe) {
        dsTaint.addTaint(pe.dsTaint);
        dsTaint.addTaint(badReq);
        StringBuffer buf;
        buf = new StringBuffer(512);
        buf.append("SIP/2.0 400 Bad Request (" + pe.getLocalizedMessage() + ')');
        {
            boolean varA74195C993F839258344C44C50F82D7F_981836770 = (!copyViaHeaders(badReq, buf));
        } //End collapsed parenthetic
        {
            boolean varD40A5204557B10CAAE28B7110057F82E_99726860 = (!copyHeader(CSeqHeader.NAME, badReq, buf));
        } //End collapsed parenthetic
        {
            boolean varD056133D7B990F0705C31740796D4B57_1865691276 = (!copyHeader(CallIdHeader.NAME, badReq, buf));
        } //End collapsed parenthetic
        {
            boolean var87D1B258DFFADD71B890074FBABDB43C_799745959 = (!copyHeader(FromHeader.NAME, badReq, buf));
        } //End collapsed parenthetic
        {
            boolean var1899C470E280CFBEB977387671427330_1225525578 = (!copyHeader(ToHeader.NAME, badReq, buf));
        } //End collapsed parenthetic
        int toStart;
        toStart = buf.indexOf(ToHeader.NAME);
        {
            boolean var7F4FDFDBDF87B9BF468383C929F3552C_103610242 = (toStart != -1 && buf.indexOf("tag", toStart) == -1);
            {
                buf.append(";tag=badreq");
            } //End block
        } //End collapsed parenthetic
        ServerHeader s;
        s = MessageFactoryImpl.getDefaultServerHeader();
        {
            buf.append("\r\n" + s.toString());
        } //End block
        int clength;
        clength = badReq.length();
        {
            boolean varA313D1F6D6586964A488AEC11B13E622_2021596280 = (! (this instanceof UDPMessageChannel) ||
                clength + buf.length() + ContentTypeHeader.NAME.length()
                + ": message/sipfrag\r\n".length() +
                ContentLengthHeader.NAME.length()  < 1300);
            {
                ContentTypeHeader cth;
                cth = new ContentType("message", "sipfrag");
                buf.append("\r\n" + cth.toString());
                ContentLength clengthHeader;
                clengthHeader = new ContentLength(clength);
                buf.append("\r\n" + clengthHeader.toString());
                buf.append("\r\n\r\n" + badReq);
            } //End block
            {
                ContentLength clengthHeader;
                clengthHeader = new ContentLength(0);
                buf.append("\r\n" + clengthHeader.toString());
            } //End block
        } //End collapsed parenthetic
        String var0C174602EFE4BFBCB80A7056CFA680FB_1229279166 = (buf.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static final boolean copyHeader(String name, String fromReq, StringBuffer buf) {
        int start = fromReq.indexOf(name);
        if (start != -1) {
            int end = fromReq.indexOf("\r\n", start);
            if (end != -1) {
                buf.append(fromReq.subSequence(start - 2, end)); 
                return true;
            }
        }
        return false;
    }

    
        private static final boolean copyViaHeaders(String fromReq, StringBuffer buf) {
        int start = fromReq.indexOf(ViaHeader.NAME);
        boolean found = false;
        while (start != -1) {
            int end = fromReq.indexOf("\r\n", start);
            if (end != -1) {
                buf.append(fromReq.subSequence(start - 2, end)); 
                found = true;
                start = fromReq.indexOf(ViaHeader.NAME, end);
            } else {
                return false;
            }
        }
        return found;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.914 -0400", hash_original_method = "B369445AF3BB32430CE637694E76219B", hash_generated_method = "843092AC9A693B29FDC308623349BCE9")
    @DSModeled(DSC.SAFE)
    public MessageProcessor getMessageProcessor() {
        return (MessageProcessor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.messageProcessor;
    }

    
}

