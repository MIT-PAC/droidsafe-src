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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.114 -0400", hash_original_field = "A771D64D63DE5E52A6605CCC6FAC3F7C", hash_generated_field = "8B62D61316200E61EA0A60A5551D82D6")

    protected int useCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.114 -0400", hash_original_field = "6B75413988C7E355B374E1A5B2309AE8", hash_generated_field = "F67739B8CB8B1CB4F97395041389F37A")

    protected transient MessageProcessor messageProcessor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.114 -0400", hash_original_method = "1B1EF2D32056DF45EB39273AF108BD8B", hash_generated_method = "1B1EF2D32056DF45EB39273AF108BD8B")
    public MessageChannel ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.114 -0400", hash_original_method = "B5543AC884E160C74E00608F95C390A3", hash_generated_method = "547268D6CF76DECC0066A4DC26EFC855")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.132 -0400", hash_original_method = "CA1BACEAFC0549F0AA4E82303BA5F480", hash_generated_method = "4474708F342D395FB1CA5CC88DEB0F3C")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_72199733 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_72199733 = this.getMessageProcessor().getIpAddress().getHostAddress();
        varB4EAC82CA7396A68D541C85D26508E83_72199733.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_72199733;
        // ---------- Original Method ----------
        //return this.getMessageProcessor().getIpAddress().getHostAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.132 -0400", hash_original_method = "D12E0B39D0A0A3DBD8096F94437302A2", hash_generated_method = "385DA6B6A6127AD1462DB80AF8E05C34")
    public int getPort() {
        int varA100E41244C68A9F97324F08F822F83F_755565087 = (messageProcessor.getPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2018560794 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2018560794;
        // ---------- Original Method ----------
        //if (this.messageProcessor != null)
            //return messageProcessor.getPort();
        //else
            //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.332 -0400", hash_original_method = "6965EB337B784D47DD1B6D5165D2FBD3", hash_generated_method = "668E5859192300E126B6A5FFAB8BE3C2")
    public void sendMessage(SIPMessage sipMessage, Hop hop) throws IOException {
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
                        boolean var7765B2DC295364D1C19B74A079B8042D_1460061455 = (messageProcessor.getIpAddress().equals(hopAddr)
                        && messageProcessor.getPort() == hop.getPort()
                        && messageProcessor.getTransport().equals(hop.getTransport()));
                        {
                            MessageChannel messageChannel;
                            messageChannel = messageProcessor.createMessageChannel(
                            hopAddr, hop.getPort());
                            {
                                ((RawMessageChannel) messageChannel).processMessage(sipMessage);
                                {
                                    boolean varB302AC6B07F52C4E2326C0A8080C6396_136023605 = (getSIPStack().isLoggingEnabled());
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
                boolean varF431BBF7DDBE8461EF02D058C832AD01_282578100 = (this.getSIPStack().getStackLogger().isLoggingEnabled(ServerLogger.TRACE_ERROR));
                {
                    this.getSIPStack().getStackLogger().logError("Error self routing message cause by: ", ex);
                } //End block
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw new IOException("Error self routing message");
        } //End block
        finally 
        {
            {
                boolean var7A4E9416A69CB8A92770D24F8DF72D74_1614296117 = (this.getSIPStack().getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES));
                logMessage(sipMessage, hopAddr, hop.getPort(), time);
            } //End collapsed parenthetic
        } //End block
        addTaint(sipMessage.getTaint());
        addTaint(hop.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.343 -0400", hash_original_method = "4AF33D1C82235ED60B6E3DD0D1967C25", hash_generated_method = "3DF1494EA4DC7F746E96FF4AF4C5AC59")
    public void sendMessage(SIPMessage sipMessage, InetAddress receiverAddress, int receiverPort) throws IOException {
        long time;
        time = System.currentTimeMillis();
        byte[] bytes;
        bytes = sipMessage.encodeAsBytes(this.getTransport());
        sendMessage(bytes, receiverAddress, receiverPort, sipMessage instanceof SIPRequest);
        logMessage(sipMessage, receiverAddress, receiverPort, time);
        addTaint(sipMessage.getTaint());
        addTaint(receiverAddress.getTaint());
        addTaint(receiverPort);
        // ---------- Original Method ----------
        //long time = System.currentTimeMillis();
        //byte[] bytes = sipMessage.encodeAsBytes(this.getTransport());
        //sendMessage(bytes, receiverAddress, receiverPort, sipMessage instanceof SIPRequest);
        //logMessage(sipMessage, receiverAddress, receiverPort, time);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.345 -0400", hash_original_method = "BC100C85F7EEF6C9116B6E540185BCE8", hash_generated_method = "C577D2D167694F46CC8CDAFEC69B9745")
    public String getRawIpSourceAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_360435008 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_360435008 = rawIpSourceAddress;
        varB4EAC82CA7396A68D541C85D26508E83_360435008.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_360435008;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.364 -0400", hash_original_method = "A44FE176AC0185A0737BBEE3031992DB", hash_generated_method = "CC855EB2CDB26505B5D3B47C1C98EEE2")
    public HostPort getHostPort() {
        HostPort varB4EAC82CA7396A68D541C85D26508E83_1673357641 = null; //Variable for return #1
        HostPort retval;
        retval = new HostPort();
        retval.setHost(new Host(this.getHost()));
        retval.setPort(this.getPort());
        varB4EAC82CA7396A68D541C85D26508E83_1673357641 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1673357641.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1673357641;
        // ---------- Original Method ----------
        //HostPort retval = new HostPort();
        //retval.setHost(new Host(this.getHost()));
        //retval.setPort(this.getPort());
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.364 -0400", hash_original_method = "B86C07836DB50334479A6BD4BF7381CC", hash_generated_method = "C675DF347C7DFCD09A0E77FA0B33B513")
    public HostPort getPeerHostPort() {
        HostPort varB4EAC82CA7396A68D541C85D26508E83_807506691 = null; //Variable for return #1
        HostPort retval;
        retval = new HostPort();
        retval.setHost(new Host(this.getPeerAddress()));
        retval.setPort(this.getPeerPort());
        varB4EAC82CA7396A68D541C85D26508E83_807506691 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_807506691.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_807506691;
        // ---------- Original Method ----------
        //HostPort retval = new HostPort();
        //retval.setHost(new Host(this.getPeerAddress()));
        //retval.setPort(this.getPeerPort());
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.365 -0400", hash_original_method = "31F63348466D8C31B05195508CA771AE", hash_generated_method = "11396FE67426CD92585E487B5770431A")
    public Via getViaHeader() {
        Via varB4EAC82CA7396A68D541C85D26508E83_541615954 = null; //Variable for return #1
        Via channelViaHeader;
        channelViaHeader = new Via();
        try 
        {
            channelViaHeader.setTransport(getTransport());
        } //End block
        catch (ParseException ex)
        { }
        channelViaHeader.setSentBy(getHostPort());
        varB4EAC82CA7396A68D541C85D26508E83_541615954 = channelViaHeader;
        varB4EAC82CA7396A68D541C85D26508E83_541615954.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_541615954;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.366 -0400", hash_original_method = "8AF1560686CCA72CFE111D9FA9C1ECDE", hash_generated_method = "09F8F1EFBD33FC7249B43150FD923D5E")
    public HostPort getViaHostPort() {
        HostPort varB4EAC82CA7396A68D541C85D26508E83_616484763 = null; //Variable for return #1
        HostPort retval;
        retval = new HostPort();
        retval.setHost(new Host(this.getViaHost()));
        retval.setPort(this.getViaPort());
        varB4EAC82CA7396A68D541C85D26508E83_616484763 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_616484763.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_616484763;
        // ---------- Original Method ----------
        //HostPort retval = new HostPort();
        //retval.setHost(new Host(this.getViaHost()));
        //retval.setPort(this.getViaPort());
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.367 -0400", hash_original_method = "C068429579A247F633492130419A4C88", hash_generated_method = "CFFBC9C7C9499A05D59FBD013AD2BF45")
    protected void logMessage(SIPMessage sipMessage, InetAddress address, int port, long time) {
        {
            boolean var2516254AC94744EE5F2042143C2C2CA0_130761853 = (!getSIPStack().getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES));
        } //End collapsed parenthetic
        port = 5060;
        getSIPStack().serverLogger.logMessage(sipMessage, this.getHost() + ":" + this.getPort(),
                address.getHostAddress().toString() + ":" + port, true, time);
        addTaint(sipMessage.getTaint());
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(time);
        // ---------- Original Method ----------
        //if (!getSIPStack().getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES))
            //return;
        //if (port == -1)
            //port = 5060;
        //getSIPStack().serverLogger.logMessage(sipMessage, this.getHost() + ":" + this.getPort(),
                //address.getHostAddress().toString() + ":" + port, true, time);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.367 -0400", hash_original_method = "F3D4D9112F2E8581D299D1D033206DF5", hash_generated_method = "47D7CE0A0BCFCB0142951708FECF4BEF")
    public void logResponse(SIPResponse sipResponse, long receptionTime, String status) {
        int peerport;
        peerport = getPeerPort();
        {
            boolean var321536B5BBF9E022C6F05C23921B41FC_603144720 = (peerport == 0 && sipResponse.getContactHeaders() != null);
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
        addTaint(sipResponse.getTaint());
        addTaint(receptionTime);
        addTaint(status.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.391 -0400", hash_original_method = "FECBC10325F07301270E33C64C8E0AD0", hash_generated_method = "9DE274720A74C9BD53D2BCE6FA90A700")
    protected final String createBadReqRes(String badReq, ParseException pe) {
        String varB4EAC82CA7396A68D541C85D26508E83_393515097 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_792234778 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_816625909 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1821712759 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_1643673391 = null; //Variable for return #5
        String varB4EAC82CA7396A68D541C85D26508E83_1162514939 = null; //Variable for return #6
        StringBuffer buf;
        buf = new StringBuffer(512);
        buf.append("SIP/2.0 400 Bad Request (" + pe.getLocalizedMessage() + ')');
        {
            boolean varA74195C993F839258344C44C50F82D7F_1123331698 = (!copyViaHeaders(badReq, buf));
            varB4EAC82CA7396A68D541C85D26508E83_393515097 = null;
        } //End collapsed parenthetic
        {
            boolean varD40A5204557B10CAAE28B7110057F82E_1180171841 = (!copyHeader(CSeqHeader.NAME, badReq, buf));
            varB4EAC82CA7396A68D541C85D26508E83_792234778 = null;
        } //End collapsed parenthetic
        {
            boolean varD056133D7B990F0705C31740796D4B57_1965577693 = (!copyHeader(CallIdHeader.NAME, badReq, buf));
            varB4EAC82CA7396A68D541C85D26508E83_816625909 = null;
        } //End collapsed parenthetic
        {
            boolean var87D1B258DFFADD71B890074FBABDB43C_1264035881 = (!copyHeader(FromHeader.NAME, badReq, buf));
            varB4EAC82CA7396A68D541C85D26508E83_1821712759 = null;
        } //End collapsed parenthetic
        {
            boolean var1899C470E280CFBEB977387671427330_1528071962 = (!copyHeader(ToHeader.NAME, badReq, buf));
            varB4EAC82CA7396A68D541C85D26508E83_1643673391 = null;
        } //End collapsed parenthetic
        int toStart;
        toStart = buf.indexOf(ToHeader.NAME);
        {
            boolean var7F4FDFDBDF87B9BF468383C929F3552C_287117250 = (toStart != -1 && buf.indexOf("tag", toStart) == -1);
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
            boolean varA313D1F6D6586964A488AEC11B13E622_287877863 = (! (this instanceof UDPMessageChannel) ||
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
        varB4EAC82CA7396A68D541C85D26508E83_1162514939 = buf.toString();
        addTaint(badReq.getTaint());
        addTaint(pe.getTaint());
        String varA7E53CE21691AB073D9660D615818899_2130580063; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2130580063 = varB4EAC82CA7396A68D541C85D26508E83_393515097;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2130580063 = varB4EAC82CA7396A68D541C85D26508E83_792234778;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_2130580063 = varB4EAC82CA7396A68D541C85D26508E83_816625909;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_2130580063 = varB4EAC82CA7396A68D541C85D26508E83_1821712759;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_2130580063 = varB4EAC82CA7396A68D541C85D26508E83_1643673391;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2130580063 = varB4EAC82CA7396A68D541C85D26508E83_1162514939;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2130580063.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2130580063;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.393 -0400", hash_original_method = "B369445AF3BB32430CE637694E76219B", hash_generated_method = "F9F4F27C6E4D7C4B7FA8FC0A30E24927")
    public MessageProcessor getMessageProcessor() {
        MessageProcessor varB4EAC82CA7396A68D541C85D26508E83_1469366651 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1469366651 = this.messageProcessor;
        varB4EAC82CA7396A68D541C85D26508E83_1469366651.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1469366651;
        // ---------- Original Method ----------
        //return this.messageProcessor;
    }

    
}

