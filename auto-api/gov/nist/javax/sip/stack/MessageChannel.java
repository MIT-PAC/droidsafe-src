package gov.nist.javax.sip.stack;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.441 -0400", hash_original_field = "A771D64D63DE5E52A6605CCC6FAC3F7C", hash_generated_field = "8B62D61316200E61EA0A60A5551D82D6")

    protected int useCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.441 -0400", hash_original_field = "6B75413988C7E355B374E1A5B2309AE8", hash_generated_field = "F67739B8CB8B1CB4F97395041389F37A")

    protected transient MessageProcessor messageProcessor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.441 -0400", hash_original_method = "1B1EF2D32056DF45EB39273AF108BD8B", hash_generated_method = "1B1EF2D32056DF45EB39273AF108BD8B")
    public MessageChannel ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.441 -0400", hash_original_method = "B5543AC884E160C74E00608F95C390A3", hash_generated_method = "547268D6CF76DECC0066A4DC26EFC855")
    protected void uncache() {
        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.444 -0400", hash_original_method = "CA1BACEAFC0549F0AA4E82303BA5F480", hash_generated_method = "CCB9BCE238C2058E8E09FCE65F07F69A")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_2126831715 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2126831715 = this.getMessageProcessor().getIpAddress().getHostAddress();
        varB4EAC82CA7396A68D541C85D26508E83_2126831715.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2126831715;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.445 -0400", hash_original_method = "D12E0B39D0A0A3DBD8096F94437302A2", hash_generated_method = "48AD9273DAD6699F8BC5639EBD4B7A8B")
    public int getPort() {
        int varA100E41244C68A9F97324F08F822F83F_1438280476 = (messageProcessor.getPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_360033754 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_360033754;
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.463 -0400", hash_original_method = "6965EB337B784D47DD1B6D5165D2FBD3", hash_generated_method = "E7C5A9EA059C854903CFE55008162062")
    public void sendMessage(SIPMessage sipMessage, Hop hop) throws IOException {
        long time = System.currentTimeMillis();
        InetAddress hopAddr = InetAddress.getByName(hop.getHost());
        try 
        {
            {
                MessageProcessor messageProcessor = getSIPStack().getMessageProcessors()[0];
                {
                    {
                        boolean var7765B2DC295364D1C19B74A079B8042D_1999798345 = (messageProcessor.getIpAddress().equals(hopAddr)
                        && messageProcessor.getPort() == hop.getPort()
                        && messageProcessor.getTransport().equals(hop.getTransport()));
                        {
                            MessageChannel messageChannel = messageProcessor.createMessageChannel(
                            hopAddr, hop.getPort());
                            {
                                ((RawMessageChannel) messageChannel).processMessage(sipMessage);
                                {
                                    boolean varB302AC6B07F52C4E2326C0A8080C6396_1013176462 = (getSIPStack().isLoggingEnabled());
                                    getSIPStack().getStackLogger().logDebug("Self routing message");
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            byte[] msg = sipMessage.encodeAsBytes(this.getTransport());
            this.sendMessage(msg, hopAddr, hop.getPort(), sipMessage instanceof SIPRequest);
        } 
        catch (IOException ioe)
        {
            if (DroidSafeAndroidRuntime.control) throw ioe;
        } 
        catch (Exception ex)
        {
            {
                boolean varF431BBF7DDBE8461EF02D058C832AD01_268449657 = (this.getSIPStack().getStackLogger().isLoggingEnabled(ServerLogger.TRACE_ERROR));
                {
                    this.getSIPStack().getStackLogger().logError("Error self routing message cause by: ", ex);
                } 
            } 
            if (DroidSafeAndroidRuntime.control) throw new IOException("Error self routing message");
        } 
        finally 
        {
            {
                boolean var7A4E9416A69CB8A92770D24F8DF72D74_464182984 = (this.getSIPStack().getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES));
                logMessage(sipMessage, hopAddr, hop.getPort(), time);
            } 
        } 
        addTaint(sipMessage.getTaint());
        addTaint(hop.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.463 -0400", hash_original_method = "4AF33D1C82235ED60B6E3DD0D1967C25", hash_generated_method = "647BCD8BFED29DD223A2ECC0DC8BF656")
    public void sendMessage(SIPMessage sipMessage, InetAddress receiverAddress, int receiverPort) throws IOException {
        long time = System.currentTimeMillis();
        byte[] bytes = sipMessage.encodeAsBytes(this.getTransport());
        sendMessage(bytes, receiverAddress, receiverPort, sipMessage instanceof SIPRequest);
        logMessage(sipMessage, receiverAddress, receiverPort, time);
        addTaint(sipMessage.getTaint());
        addTaint(receiverAddress.getTaint());
        addTaint(receiverPort);
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.464 -0400", hash_original_method = "BC100C85F7EEF6C9116B6E540185BCE8", hash_generated_method = "25422CAA8EA59007E5F58950F0C039BC")
    public String getRawIpSourceAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_1657173086 = null; 
        String sourceAddress = getPeerAddress();
        String rawIpSourceAddress = null;
        try 
        {
            InetAddress sourceInetAddress = InetAddress.getByName(sourceAddress);
            rawIpSourceAddress = sourceInetAddress.getHostAddress();
        } 
        catch (Exception ex)
        {
            InternalErrorHandler.handleException(ex);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1657173086 = rawIpSourceAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1657173086.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1657173086;
        
        
        
        
            
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static String getKey(InetAddress inetAddr, int port, String transport) {
        return (transport + ":" + inetAddr.getHostAddress() + ":" + port).toLowerCase();
    }

    
    @DSModeled(DSC.SAFE)
    public static String getKey(HostPort hostPort, String transport) {
        return (transport + ":" + hostPort.getHost().getHostname() + ":" + hostPort.getPort())
                .toLowerCase();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.464 -0400", hash_original_method = "A44FE176AC0185A0737BBEE3031992DB", hash_generated_method = "78D371DA979771BA94449BD9EEF6C8BA")
    public HostPort getHostPort() {
        HostPort varB4EAC82CA7396A68D541C85D26508E83_1545932042 = null; 
        HostPort retval = new HostPort();
        retval.setHost(new Host(this.getHost()));
        retval.setPort(this.getPort());
        varB4EAC82CA7396A68D541C85D26508E83_1545932042 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1545932042.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1545932042;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.465 -0400", hash_original_method = "B86C07836DB50334479A6BD4BF7381CC", hash_generated_method = "D126011298718F91A595E03FEE0D12D9")
    public HostPort getPeerHostPort() {
        HostPort varB4EAC82CA7396A68D541C85D26508E83_466879810 = null; 
        HostPort retval = new HostPort();
        retval.setHost(new Host(this.getPeerAddress()));
        retval.setPort(this.getPeerPort());
        varB4EAC82CA7396A68D541C85D26508E83_466879810 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_466879810.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_466879810;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.466 -0400", hash_original_method = "31F63348466D8C31B05195508CA771AE", hash_generated_method = "79A6D0B7AF0110F5284E4EE144F71F29")
    public Via getViaHeader() {
        Via varB4EAC82CA7396A68D541C85D26508E83_1537152720 = null; 
        Via channelViaHeader;
        channelViaHeader = new Via();
        try 
        {
            channelViaHeader.setTransport(getTransport());
        } 
        catch (ParseException ex)
        { }
        channelViaHeader.setSentBy(getHostPort());
        varB4EAC82CA7396A68D541C85D26508E83_1537152720 = channelViaHeader;
        varB4EAC82CA7396A68D541C85D26508E83_1537152720.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1537152720;
        
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.467 -0400", hash_original_method = "8AF1560686CCA72CFE111D9FA9C1ECDE", hash_generated_method = "3C4702277385F1C1A9F68FE914EF9E89")
    public HostPort getViaHostPort() {
        HostPort varB4EAC82CA7396A68D541C85D26508E83_1461333679 = null; 
        HostPort retval = new HostPort();
        retval.setHost(new Host(this.getViaHost()));
        retval.setPort(this.getViaPort());
        varB4EAC82CA7396A68D541C85D26508E83_1461333679 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1461333679.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1461333679;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.468 -0400", hash_original_method = "C068429579A247F633492130419A4C88", hash_generated_method = "E65B86C8D26DA9C4FD124693DC0CBB0B")
    protected void logMessage(SIPMessage sipMessage, InetAddress address, int port, long time) {
        {
            boolean var2516254AC94744EE5F2042143C2C2CA0_1469439905 = (!getSIPStack().getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES));
        } 
        port = 5060;
        getSIPStack().serverLogger.logMessage(sipMessage, this.getHost() + ":" + this.getPort(),
                address.getHostAddress().toString() + ":" + port, true, time);
        addTaint(sipMessage.getTaint());
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(time);
        
        
            
        
            
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.468 -0400", hash_original_method = "F3D4D9112F2E8581D299D1D033206DF5", hash_generated_method = "84227D04AE052A78BF67C42BFD059238")
    public void logResponse(SIPResponse sipResponse, long receptionTime, String status) {
        int peerport = getPeerPort();
        {
            boolean var321536B5BBF9E022C6F05C23921B41FC_444760241 = (peerport == 0 && sipResponse.getContactHeaders() != null);
            {
                ContactHeader contact = (ContactHeader) sipResponse.getContactHeaders().getFirst();
                peerport = ((AddressImpl) contact.getAddress()).getPort();
            } 
        } 
        String from = getPeerAddress().toString() + ":" + peerport;
        String to = this.getHost() + ":" + getPort();
        this.getSIPStack().serverLogger.logMessage(sipResponse, from, to, status, false,
                receptionTime);
        addTaint(sipResponse.getTaint());
        addTaint(receptionTime);
        addTaint(status.getTaint());
        
        
        
            
            
        
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.470 -0400", hash_original_method = "FECBC10325F07301270E33C64C8E0AD0", hash_generated_method = "4A0858A164F47AAA6BF1AAB6C1CA0D5D")
    protected final String createBadReqRes(String badReq, ParseException pe) {
        String varB4EAC82CA7396A68D541C85D26508E83_1042486229 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_2091701476 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1600276143 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1728319193 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_213901865 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1033970713 = null; 
        StringBuffer buf = new StringBuffer(512);
        buf.append("SIP/2.0 400 Bad Request (" + pe.getLocalizedMessage() + ')');
        {
            boolean varA74195C993F839258344C44C50F82D7F_1503402540 = (!copyViaHeaders(badReq, buf));
            varB4EAC82CA7396A68D541C85D26508E83_1042486229 = null;
        } 
        {
            boolean varD40A5204557B10CAAE28B7110057F82E_2126750959 = (!copyHeader(CSeqHeader.NAME, badReq, buf));
            varB4EAC82CA7396A68D541C85D26508E83_2091701476 = null;
        } 
        {
            boolean varD056133D7B990F0705C31740796D4B57_1084412347 = (!copyHeader(CallIdHeader.NAME, badReq, buf));
            varB4EAC82CA7396A68D541C85D26508E83_1600276143 = null;
        } 
        {
            boolean var87D1B258DFFADD71B890074FBABDB43C_1672089526 = (!copyHeader(FromHeader.NAME, badReq, buf));
            varB4EAC82CA7396A68D541C85D26508E83_1728319193 = null;
        } 
        {
            boolean var1899C470E280CFBEB977387671427330_1388031210 = (!copyHeader(ToHeader.NAME, badReq, buf));
            varB4EAC82CA7396A68D541C85D26508E83_213901865 = null;
        } 
        int toStart = buf.indexOf(ToHeader.NAME);
        {
            boolean var7F4FDFDBDF87B9BF468383C929F3552C_677494279 = (toStart != -1 && buf.indexOf("tag", toStart) == -1);
            {
                buf.append(";tag=badreq");
            } 
        } 
        ServerHeader s = MessageFactoryImpl.getDefaultServerHeader();
        {
            buf.append("\r\n" + s.toString());
        } 
        int clength = badReq.length();
        {
            boolean varA313D1F6D6586964A488AEC11B13E622_1567870042 = (! (this instanceof UDPMessageChannel) ||
                clength + buf.length() + ContentTypeHeader.NAME.length()
                + ": message/sipfrag\r\n".length() +
                ContentLengthHeader.NAME.length()  < 1300);
            {
                ContentTypeHeader cth = new ContentType("message", "sipfrag");
                buf.append("\r\n" + cth.toString());
                ContentLength clengthHeader = new ContentLength(clength);
                buf.append("\r\n" + clengthHeader.toString());
                buf.append("\r\n\r\n" + badReq);
            } 
            {
                ContentLength clengthHeader = new ContentLength(0);
                buf.append("\r\n" + clengthHeader.toString());
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1033970713 = buf.toString();
        addTaint(badReq.getTaint());
        addTaint(pe.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1750581864; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1750581864 = varB4EAC82CA7396A68D541C85D26508E83_1042486229;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1750581864 = varB4EAC82CA7396A68D541C85D26508E83_2091701476;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1750581864 = varB4EAC82CA7396A68D541C85D26508E83_1600276143;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1750581864 = varB4EAC82CA7396A68D541C85D26508E83_1728319193;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_1750581864 = varB4EAC82CA7396A68D541C85D26508E83_213901865;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1750581864 = varB4EAC82CA7396A68D541C85D26508E83_1033970713;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1750581864.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1750581864;
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.472 -0400", hash_original_method = "B369445AF3BB32430CE637694E76219B", hash_generated_method = "BE22E13C41EFF9501B703FF029E95DDF")
    public MessageProcessor getMessageProcessor() {
        MessageProcessor varB4EAC82CA7396A68D541C85D26508E83_725235226 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_725235226 = this.messageProcessor;
        varB4EAC82CA7396A68D541C85D26508E83_725235226.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_725235226;
        
        
    }

    
}

