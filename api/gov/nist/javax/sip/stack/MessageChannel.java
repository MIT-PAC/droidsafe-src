package gov.nist.javax.sip.stack;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.630 -0400", hash_original_field = "A771D64D63DE5E52A6605CCC6FAC3F7C", hash_generated_field = "8B62D61316200E61EA0A60A5551D82D6")

    protected int useCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.630 -0400", hash_original_field = "6B75413988C7E355B374E1A5B2309AE8", hash_generated_field = "F67739B8CB8B1CB4F97395041389F37A")

    protected transient MessageProcessor messageProcessor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.631 -0400", hash_original_method = "1B1EF2D32056DF45EB39273AF108BD8B", hash_generated_method = "1B1EF2D32056DF45EB39273AF108BD8B")
    public MessageChannel ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.631 -0400", hash_original_method = "B5543AC884E160C74E00608F95C390A3", hash_generated_method = "547268D6CF76DECC0066A4DC26EFC855")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.634 -0400", hash_original_method = "CA1BACEAFC0549F0AA4E82303BA5F480", hash_generated_method = "66D9E1607D47C0C321AA11CA87B01C74")
    public String getHost() {
String var65F2C600F64239A3B364AF9F620B295F_1871729290 =         this.getMessageProcessor().getIpAddress().getHostAddress();
        var65F2C600F64239A3B364AF9F620B295F_1871729290.addTaint(taint);
        return var65F2C600F64239A3B364AF9F620B295F_1871729290;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.635 -0400", hash_original_method = "D12E0B39D0A0A3DBD8096F94437302A2", hash_generated_method = "8060648C455FBD2640ADB759C671475B")
    public int getPort() {
    if(this.messageProcessor != null)        
        {
        int varA0F7AE011F3DB3D236378CBBE885612E_916708433 = (messageProcessor.getPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_119692790 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_119692790;
        }
        else
        {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1571082860 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531813727 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531813727;
        }
        
        
            
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.636 -0400", hash_original_method = "6965EB337B784D47DD1B6D5165D2FBD3", hash_generated_method = "B095283B0DC3A008CB0DE36D7144A5CD")
    public void sendMessage(SIPMessage sipMessage, Hop hop) throws IOException {
        addTaint(hop.getTaint());
        addTaint(sipMessage.getTaint());
        long time = System.currentTimeMillis();
        InetAddress hopAddr = InetAddress.getByName(hop.getHost());
        try 
        {
for(MessageProcessor messageProcessor : getSIPStack().getMessageProcessors())
            {
    if(messageProcessor.getIpAddress().equals(hopAddr)
                        && messageProcessor.getPort() == hop.getPort()
                        && messageProcessor.getTransport().equals(hop.getTransport()))                
                {
                    MessageChannel messageChannel = messageProcessor.createMessageChannel(
                            hopAddr, hop.getPort());
    if(messageChannel instanceof RawMessageChannel)                    
                    {
                        ((RawMessageChannel) messageChannel).processMessage(sipMessage);
    if(getSIPStack().isLoggingEnabled())                        
                        getSIPStack().getStackLogger().logDebug("Self routing message");
                        return;
                    } 
                } 
            } 
            byte[] msg = sipMessage.encodeAsBytes(this.getTransport());
            this.sendMessage(msg, hopAddr, hop.getPort(), sipMessage instanceof SIPRequest);
        } 
        catch (IOException ioe)
        {
            ioe.addTaint(taint);
            throw ioe;
        } 
        catch (Exception ex)
        {
    if(this.getSIPStack().getStackLogger().isLoggingEnabled(ServerLogger.TRACE_ERROR))            
            {
                this.getSIPStack().getStackLogger().logError("Error self routing message cause by: ", ex);
            } 
            IOException var21FE874BA1463E19D18105CD2D7A1D97_855649303 = new IOException("Error self routing message");
            var21FE874BA1463E19D18105CD2D7A1D97_855649303.addTaint(taint);
            throw var21FE874BA1463E19D18105CD2D7A1D97_855649303;
        } 
        finally 
        {
    if(this.getSIPStack().getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES))            
            logMessage(sipMessage, hopAddr, hop.getPort(), time);
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.636 -0400", hash_original_method = "4AF33D1C82235ED60B6E3DD0D1967C25", hash_generated_method = "C0824AFD3A472BAA5363FBD849866945")
    public void sendMessage(SIPMessage sipMessage, InetAddress receiverAddress, int receiverPort) throws IOException {
        addTaint(receiverPort);
        addTaint(receiverAddress.getTaint());
        addTaint(sipMessage.getTaint());
        long time = System.currentTimeMillis();
        byte[] bytes = sipMessage.encodeAsBytes(this.getTransport());
        sendMessage(bytes, receiverAddress, receiverPort, sipMessage instanceof SIPRequest);
        logMessage(sipMessage, receiverAddress, receiverPort, time);
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.637 -0400", hash_original_method = "BC100C85F7EEF6C9116B6E540185BCE8", hash_generated_method = "41691E43879F0B20B433872733E25531")
    public String getRawIpSourceAddress() {
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
String var0C55497D4040E5B7A276211312B99E60_1686432340 =         rawIpSourceAddress;
        var0C55497D4040E5B7A276211312B99E60_1686432340.addTaint(taint);
        return var0C55497D4040E5B7A276211312B99E60_1686432340;
        
        
        
        
            
            
        
            
        
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.638 -0400", hash_original_method = "A44FE176AC0185A0737BBEE3031992DB", hash_generated_method = "78AF5536D76989A2E56F1082588D7C8E")
    public HostPort getHostPort() {
        HostPort retval = new HostPort();
        retval.setHost(new Host(this.getHost()));
        retval.setPort(this.getPort());
HostPort varF9E19AD6135C970F387F77C6F3DE4477_319477055 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_319477055.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_319477055;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.639 -0400", hash_original_method = "B86C07836DB50334479A6BD4BF7381CC", hash_generated_method = "682E641BEA3FBB7893B83DD2576BC333")
    public HostPort getPeerHostPort() {
        HostPort retval = new HostPort();
        retval.setHost(new Host(this.getPeerAddress()));
        retval.setPort(this.getPeerPort());
HostPort varF9E19AD6135C970F387F77C6F3DE4477_1231214454 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1231214454.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1231214454;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.640 -0400", hash_original_method = "31F63348466D8C31B05195508CA771AE", hash_generated_method = "5D77069C168102BE1868B7AF39A538C3")
    public Via getViaHeader() {
        Via channelViaHeader;
        channelViaHeader = new Via();
        try 
        {
            channelViaHeader.setTransport(getTransport());
        } 
        catch (ParseException ex)
        {
        } 
        channelViaHeader.setSentBy(getHostPort());
Via var35DB1238D58BA2159EC3B88E973131F6_1126258903 =         channelViaHeader;
        var35DB1238D58BA2159EC3B88E973131F6_1126258903.addTaint(taint);
        return var35DB1238D58BA2159EC3B88E973131F6_1126258903;
        
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.641 -0400", hash_original_method = "8AF1560686CCA72CFE111D9FA9C1ECDE", hash_generated_method = "2A7AA626054F690B744221AED5567E81")
    public HostPort getViaHostPort() {
        HostPort retval = new HostPort();
        retval.setHost(new Host(this.getViaHost()));
        retval.setPort(this.getViaPort());
HostPort varF9E19AD6135C970F387F77C6F3DE4477_451746499 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_451746499.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_451746499;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.641 -0400", hash_original_method = "C068429579A247F633492130419A4C88", hash_generated_method = "E20D0A2C899AA742E27CCDE796D8C69F")
    protected void logMessage(SIPMessage sipMessage, InetAddress address, int port, long time) {
        addTaint(time);
        addTaint(port);
        addTaint(address.getTaint());
        addTaint(sipMessage.getTaint());
    if(!getSIPStack().getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES))        
        return;
    if(port == -1)        
        port = 5060;
        getSIPStack().serverLogger.logMessage(sipMessage, this.getHost() + ":" + this.getPort(),
                address.getHostAddress().toString() + ":" + port, true, time);
        
        
            
        
            
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.643 -0400", hash_original_method = "F3D4D9112F2E8581D299D1D033206DF5", hash_generated_method = "3BEECD77B61B4D9035D31F7704FA52B0")
    public void logResponse(SIPResponse sipResponse, long receptionTime, String status) {
        addTaint(status.getTaint());
        addTaint(receptionTime);
        addTaint(sipResponse.getTaint());
        int peerport = getPeerPort();
    if(peerport == 0 && sipResponse.getContactHeaders() != null)        
        {
            ContactHeader contact = (ContactHeader) sipResponse.getContactHeaders().getFirst();
            peerport = ((AddressImpl) contact.getAddress()).getPort();
        } 
        String from = getPeerAddress().toString() + ":" + peerport;
        String to = this.getHost() + ":" + getPort();
        this.getSIPStack().serverLogger.logMessage(sipResponse, from, to, status, false,
                receptionTime);
        
        
        
            
            
        
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.644 -0400", hash_original_method = "FECBC10325F07301270E33C64C8E0AD0", hash_generated_method = "F0AA46CBD58FDCF76FDAA96A7B0E7D63")
    protected final String createBadReqRes(String badReq, ParseException pe) {
        addTaint(pe.getTaint());
        addTaint(badReq.getTaint());
        StringBuffer buf = new StringBuffer(512);
        buf.append("SIP/2.0 400 Bad Request (" + pe.getLocalizedMessage() + ')');
    if(!copyViaHeaders(badReq, buf))        
        {
String var540C13E9E156B687226421B24F2DF178_1418766931 =         null;
        var540C13E9E156B687226421B24F2DF178_1418766931.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1418766931;
        }
    if(!copyHeader(CSeqHeader.NAME, badReq, buf))        
        {
String var540C13E9E156B687226421B24F2DF178_744311644 =         null;
        var540C13E9E156B687226421B24F2DF178_744311644.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_744311644;
        }
    if(!copyHeader(CallIdHeader.NAME, badReq, buf))        
        {
String var540C13E9E156B687226421B24F2DF178_2076019759 =         null;
        var540C13E9E156B687226421B24F2DF178_2076019759.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2076019759;
        }
    if(!copyHeader(FromHeader.NAME, badReq, buf))        
        {
String var540C13E9E156B687226421B24F2DF178_1549773885 =         null;
        var540C13E9E156B687226421B24F2DF178_1549773885.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1549773885;
        }
    if(!copyHeader(ToHeader.NAME, badReq, buf))        
        {
String var540C13E9E156B687226421B24F2DF178_1744399192 =         null;
        var540C13E9E156B687226421B24F2DF178_1744399192.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1744399192;
        }
        int toStart = buf.indexOf(ToHeader.NAME);
    if(toStart != -1 && buf.indexOf("tag", toStart) == -1)        
        {
            buf.append(";tag=badreq");
        } 
        ServerHeader s = MessageFactoryImpl.getDefaultServerHeader();
    if(s != null)        
        {
            buf.append("\r\n" + s.toString());
        } 
        int clength = badReq.length();
    if(! (this instanceof UDPMessageChannel) ||
                clength + buf.length() + ContentTypeHeader.NAME.length()
                + ": message/sipfrag\r\n".length() +
                ContentLengthHeader.NAME.length()  < 1300)        
        {
            ContentTypeHeader cth = new ContentType("message", "sipfrag");
            buf.append("\r\n" + cth.toString());
            ContentLength clengthHeader = new ContentLength(clength);
            buf.append("\r\n" + clengthHeader.toString());
            buf.append("\r\n\r\n" + badReq);
        } 
        else
        {
            ContentLength clengthHeader = new ContentLength(0);
            buf.append("\r\n" + clengthHeader.toString());
        } 
String var4FC680801218E6372BC708D6FA44AE60_811310195 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_811310195.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_811310195;
        
        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.647 -0400", hash_original_method = "B369445AF3BB32430CE637694E76219B", hash_generated_method = "C116D3F5A203C2A91EBEDADCBF7AD84A")
    public MessageProcessor getMessageProcessor() {
MessageProcessor varEE93DAA9E4FDACE3D0129BF58212AA5C_1007815180 =         this.messageProcessor;
        varEE93DAA9E4FDACE3D0129BF58212AA5C_1007815180.addTaint(taint);
        return varEE93DAA9E4FDACE3D0129BF58212AA5C_1007815180;
        
        
    }

    
}

