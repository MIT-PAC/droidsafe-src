package gov.nist.javax.sip.stack;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.466 -0400", hash_original_field = "A771D64D63DE5E52A6605CCC6FAC3F7C", hash_generated_field = "8B62D61316200E61EA0A60A5551D82D6")

    protected int useCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.466 -0400", hash_original_field = "6B75413988C7E355B374E1A5B2309AE8", hash_generated_field = "F67739B8CB8B1CB4F97395041389F37A")

    protected transient MessageProcessor messageProcessor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.466 -0400", hash_original_method = "1B1EF2D32056DF45EB39273AF108BD8B", hash_generated_method = "1B1EF2D32056DF45EB39273AF108BD8B")
    public MessageChannel ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.467 -0400", hash_original_method = "B5543AC884E160C74E00608F95C390A3", hash_generated_method = "547268D6CF76DECC0066A4DC26EFC855")
    protected void uncache() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public abstract void close();

    
    @DSModeled(DSC.SAFE)
    public abstract SIPTransactionStack getSIPStack();

    
    @DSModeled(DSC.SAFE)
    public abstract String getTransport();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isReliable();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isSecure();

    
    @DSModeled(DSC.SAFE)
    public abstract void sendMessage(SIPMessage sipMessage) throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract String getPeerAddress();

    
    @DSModeled(DSC.SAFE)
    protected abstract InetAddress getPeerInetAddress();

    
    @DSModeled(DSC.SAFE)
    protected abstract String getPeerProtocol();

    
    @DSModeled(DSC.SAFE)
    public abstract int getPeerPort();

    
    @DSModeled(DSC.SAFE)
    public abstract int getPeerPacketSourcePort();

    
    @DSModeled(DSC.SAFE)
    public abstract InetAddress getPeerPacketSourceAddress();

    
    @DSModeled(DSC.SAFE)
    public abstract String getKey();

    
    @DSModeled(DSC.SAFE)
    public abstract String getViaHost();

    
    @DSModeled(DSC.SAFE)
    public abstract int getViaPort();

    
    @DSModeled(DSC.SAFE)
    protected abstract void sendMessage(byte[] message, InetAddress receiverAddress,
            int receiverPort, boolean reconnectFlag) throws IOException;

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.469 -0400", hash_original_method = "CA1BACEAFC0549F0AA4E82303BA5F480", hash_generated_method = "7D67B8A956E7AD512E622FAB0B4B912A")
    public String getHost() {
String var65F2C600F64239A3B364AF9F620B295F_1832348228 =         this.getMessageProcessor().getIpAddress().getHostAddress();
        var65F2C600F64239A3B364AF9F620B295F_1832348228.addTaint(taint);
        return var65F2C600F64239A3B364AF9F620B295F_1832348228;
        // ---------- Original Method ----------
        //return this.getMessageProcessor().getIpAddress().getHostAddress();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.469 -0400", hash_original_method = "D12E0B39D0A0A3DBD8096F94437302A2", hash_generated_method = "537AFEC332C72E0F57E342604D9A7018")
    public int getPort() {
        if(this.messageProcessor != null)        
        {
        int varA0F7AE011F3DB3D236378CBBE885612E_85694308 = (messageProcessor.getPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_583328536 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_583328536;
        }
        else
        {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_68331178 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_325728116 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_325728116;
        }
        // ---------- Original Method ----------
        //if (this.messageProcessor != null)
            //return messageProcessor.getPort();
        //else
            //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.470 -0400", hash_original_method = "6965EB337B784D47DD1B6D5165D2FBD3", hash_generated_method = "D58854B6F96FFB38CBD6C5DD855DC2C0")
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
                    } //End block
                } //End block
            } //End block
            byte[] msg = sipMessage.encodeAsBytes(this.getTransport());
            this.sendMessage(msg, hopAddr, hop.getPort(), sipMessage instanceof SIPRequest);
        } //End block
        catch (IOException ioe)
        {
            ioe.addTaint(taint);
            throw ioe;
        } //End block
        catch (Exception ex)
        {
            if(this.getSIPStack().getStackLogger().isLoggingEnabled(ServerLogger.TRACE_ERROR))            
            {
                this.getSIPStack().getStackLogger().logError("Error self routing message cause by: ", ex);
            } //End block
            IOException var21FE874BA1463E19D18105CD2D7A1D97_1334532105 = new IOException("Error self routing message");
            var21FE874BA1463E19D18105CD2D7A1D97_1334532105.addTaint(taint);
            throw var21FE874BA1463E19D18105CD2D7A1D97_1334532105;
        } //End block
        finally 
        {
            if(this.getSIPStack().getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES))            
            logMessage(sipMessage, hopAddr, hop.getPort(), time);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.471 -0400", hash_original_method = "4AF33D1C82235ED60B6E3DD0D1967C25", hash_generated_method = "C0824AFD3A472BAA5363FBD849866945")
    public void sendMessage(SIPMessage sipMessage, InetAddress receiverAddress, int receiverPort) throws IOException {
        addTaint(receiverPort);
        addTaint(receiverAddress.getTaint());
        addTaint(sipMessage.getTaint());
        long time = System.currentTimeMillis();
        byte[] bytes = sipMessage.encodeAsBytes(this.getTransport());
        sendMessage(bytes, receiverAddress, receiverPort, sipMessage instanceof SIPRequest);
        logMessage(sipMessage, receiverAddress, receiverPort, time);
        // ---------- Original Method ----------
        //long time = System.currentTimeMillis();
        //byte[] bytes = sipMessage.encodeAsBytes(this.getTransport());
        //sendMessage(bytes, receiverAddress, receiverPort, sipMessage instanceof SIPRequest);
        //logMessage(sipMessage, receiverAddress, receiverPort, time);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.471 -0400", hash_original_method = "BC100C85F7EEF6C9116B6E540185BCE8", hash_generated_method = "51A1B9FB8088ECF6F6A42A3CFBBC7D85")
    public String getRawIpSourceAddress() {
        String sourceAddress = getPeerAddress();
        String rawIpSourceAddress = null;
        try 
        {
            InetAddress sourceInetAddress = InetAddress.getByName(sourceAddress);
            rawIpSourceAddress = sourceInetAddress.getHostAddress();
        } //End block
        catch (Exception ex)
        {
            InternalErrorHandler.handleException(ex);
        } //End block
String var0C55497D4040E5B7A276211312B99E60_1910883551 =         rawIpSourceAddress;
        var0C55497D4040E5B7A276211312B99E60_1910883551.addTaint(taint);
        return var0C55497D4040E5B7A276211312B99E60_1910883551;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.471 -0400", hash_original_method = "A44FE176AC0185A0737BBEE3031992DB", hash_generated_method = "80F933D9D4CC0E2F983140DAF2ED804F")
    public HostPort getHostPort() {
        HostPort retval = new HostPort();
        retval.setHost(new Host(this.getHost()));
        retval.setPort(this.getPort());
HostPort varF9E19AD6135C970F387F77C6F3DE4477_2046180592 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_2046180592.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_2046180592;
        // ---------- Original Method ----------
        //HostPort retval = new HostPort();
        //retval.setHost(new Host(this.getHost()));
        //retval.setPort(this.getPort());
        //return retval;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.472 -0400", hash_original_method = "B86C07836DB50334479A6BD4BF7381CC", hash_generated_method = "10C582BEAC0801AF613B72EF86529E2F")
    public HostPort getPeerHostPort() {
        HostPort retval = new HostPort();
        retval.setHost(new Host(this.getPeerAddress()));
        retval.setPort(this.getPeerPort());
HostPort varF9E19AD6135C970F387F77C6F3DE4477_987889710 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_987889710.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_987889710;
        // ---------- Original Method ----------
        //HostPort retval = new HostPort();
        //retval.setHost(new Host(this.getPeerAddress()));
        //retval.setPort(this.getPeerPort());
        //return retval;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.472 -0400", hash_original_method = "31F63348466D8C31B05195508CA771AE", hash_generated_method = "B3F23829E8F9048492ABB2368503BC62")
    public Via getViaHeader() {
        Via channelViaHeader;
        channelViaHeader = new Via();
        try 
        {
            channelViaHeader.setTransport(getTransport());
        } //End block
        catch (ParseException ex)
        {
        } //End block
        channelViaHeader.setSentBy(getHostPort());
Via var35DB1238D58BA2159EC3B88E973131F6_1604982562 =         channelViaHeader;
        var35DB1238D58BA2159EC3B88E973131F6_1604982562.addTaint(taint);
        return var35DB1238D58BA2159EC3B88E973131F6_1604982562;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.472 -0400", hash_original_method = "8AF1560686CCA72CFE111D9FA9C1ECDE", hash_generated_method = "607506DA6D504721F6BCC4DDCBFE7EC7")
    public HostPort getViaHostPort() {
        HostPort retval = new HostPort();
        retval.setHost(new Host(this.getViaHost()));
        retval.setPort(this.getViaPort());
HostPort varF9E19AD6135C970F387F77C6F3DE4477_1052308826 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1052308826.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1052308826;
        // ---------- Original Method ----------
        //HostPort retval = new HostPort();
        //retval.setHost(new Host(this.getViaHost()));
        //retval.setPort(this.getViaPort());
        //return retval;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.472 -0400", hash_original_method = "C068429579A247F633492130419A4C88", hash_generated_method = "E20D0A2C899AA742E27CCDE796D8C69F")
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
        // ---------- Original Method ----------
        //if (!getSIPStack().getStackLogger().isLoggingEnabled(ServerLogger.TRACE_MESSAGES))
            //return;
        //if (port == -1)
            //port = 5060;
        //getSIPStack().serverLogger.logMessage(sipMessage, this.getHost() + ":" + this.getPort(),
                //address.getHostAddress().toString() + ":" + port, true, time);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.473 -0400", hash_original_method = "F3D4D9112F2E8581D299D1D033206DF5", hash_generated_method = "3BEECD77B61B4D9035D31F7704FA52B0")
    public void logResponse(SIPResponse sipResponse, long receptionTime, String status) {
        addTaint(status.getTaint());
        addTaint(receptionTime);
        addTaint(sipResponse.getTaint());
        int peerport = getPeerPort();
        if(peerport == 0 && sipResponse.getContactHeaders() != null)        
        {
            ContactHeader contact = (ContactHeader) sipResponse.getContactHeaders().getFirst();
            peerport = ((AddressImpl) contact.getAddress()).getPort();
        } //End block
        String from = getPeerAddress().toString() + ":" + peerport;
        String to = this.getHost() + ":" + getPort();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.473 -0400", hash_original_method = "FECBC10325F07301270E33C64C8E0AD0", hash_generated_method = "0E2C0ACDFB9AFB56A9B352658C803FCF")
    protected final String createBadReqRes(String badReq, ParseException pe) {
        addTaint(pe.getTaint());
        addTaint(badReq.getTaint());
        StringBuffer buf = new StringBuffer(512);
        buf.append("SIP/2.0 400 Bad Request (" + pe.getLocalizedMessage() + ')');
        if(!copyViaHeaders(badReq, buf))        
        {
String var540C13E9E156B687226421B24F2DF178_730182342 =         null;
        var540C13E9E156B687226421B24F2DF178_730182342.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_730182342;
        }
        if(!copyHeader(CSeqHeader.NAME, badReq, buf))        
        {
String var540C13E9E156B687226421B24F2DF178_802929280 =         null;
        var540C13E9E156B687226421B24F2DF178_802929280.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_802929280;
        }
        if(!copyHeader(CallIdHeader.NAME, badReq, buf))        
        {
String var540C13E9E156B687226421B24F2DF178_666125243 =         null;
        var540C13E9E156B687226421B24F2DF178_666125243.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_666125243;
        }
        if(!copyHeader(FromHeader.NAME, badReq, buf))        
        {
String var540C13E9E156B687226421B24F2DF178_1602204673 =         null;
        var540C13E9E156B687226421B24F2DF178_1602204673.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1602204673;
        }
        if(!copyHeader(ToHeader.NAME, badReq, buf))        
        {
String var540C13E9E156B687226421B24F2DF178_1535311716 =         null;
        var540C13E9E156B687226421B24F2DF178_1535311716.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1535311716;
        }
        int toStart = buf.indexOf(ToHeader.NAME);
        if(toStart != -1 && buf.indexOf("tag", toStart) == -1)        
        {
            buf.append(";tag=badreq");
        } //End block
        ServerHeader s = MessageFactoryImpl.getDefaultServerHeader();
        if(s != null)        
        {
            buf.append("\r\n" + s.toString());
        } //End block
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
        } //End block
        else
        {
            ContentLength clengthHeader = new ContentLength(0);
            buf.append("\r\n" + clengthHeader.toString());
        } //End block
String var4FC680801218E6372BC708D6FA44AE60_366987094 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_366987094.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_366987094;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.475 -0400", hash_original_method = "B369445AF3BB32430CE637694E76219B", hash_generated_method = "5A48C02877BEE0DB67CC37F399EE85DF")
    public MessageProcessor getMessageProcessor() {
MessageProcessor varEE93DAA9E4FDACE3D0129BF58212AA5C_1879622504 =         this.messageProcessor;
        varEE93DAA9E4FDACE3D0129BF58212AA5C_1879622504.addTaint(taint);
        return varEE93DAA9E4FDACE3D0129BF58212AA5C_1879622504;
        // ---------- Original Method ----------
        //return this.messageProcessor;
    }

    
}

