package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.core.Host;
import gov.nist.core.HostPort;
import gov.nist.core.InternalErrorHandler;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.address.SipUri;
import gov.nist.javax.sip.header.Contact;
import gov.nist.javax.sip.header.Via;
import gov.nist.javax.sip.message.SIPRequest;
import gov.nist.javax.sip.stack.MessageChannel;
import gov.nist.javax.sip.stack.MessageProcessor;

import java.io.IOException;
import java.text.ParseException;

import javax.sip.SipStack;
import javax.sip.address.SipURI;
import javax.sip.header.ContactHeader;
import javax.sip.header.ViaHeader;






public class ListeningPointImpl implements javax.sip.ListeningPoint, gov.nist.javax.sip.ListeningPointExt {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.446 -0400", hash_original_field = "7B334B7260361141659FA9862E803476", hash_generated_field = "B1CF55BB145913C3C7A70130704FABEE")

    protected String transport;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.446 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "5A948EF636511EF149269A68FE278AED")

    int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.447 -0400", hash_original_field = "6B75413988C7E355B374E1A5B2309AE8", hash_generated_field = "9E12CC740EB4D514DEBB557E6BE577E6")

    protected MessageProcessor messageProcessor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.447 -0400", hash_original_field = "2D3F8ACEA2D147F7A52D2FA493D756C8", hash_generated_field = "7267A58204CB541E7C8F31E3DB1077A9")

    protected SipProviderImpl sipProvider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.447 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "4DAF551644AC41AE30E26F4ABCF55488")

    protected SipStackImpl sipStack;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.448 -0400", hash_original_method = "7DF0488B21396F065D358B863377FD48", hash_generated_method = "4D9DF6DC89E29396EAAAC394873BE570")
    protected  ListeningPointImpl(
        SipStack sipStack,
        int port,
        String transport) {
        this.sipStack = (SipStackImpl) sipStack;
        this.port = port;
        this.transport = transport;
        // ---------- Original Method ----------
        //this.sipStack = (SipStackImpl) sipStack;
        //this.port = port;
        //this.transport = transport;
    }

    
    @DSModeled(DSC.SAFE)
    public static String makeKey(String host, int port, String transport) {
        return new StringBuffer(host)
            .append(":")
            .append(port)
            .append("/")
            .append(transport)
            .toString()
            .toLowerCase();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.449 -0400", hash_original_method = "7B5051E336F9DA4D6C5FA2A2C5289297", hash_generated_method = "F046F5BF42CF5AE5BE9110B4FBB3D46F")
    protected String getKey() {
String var60CEE2B145F0330389F8BAFBF53C9928_99919526 =         makeKey(this.getIPAddress(), port, transport);
        var60CEE2B145F0330389F8BAFBF53C9928_99919526.addTaint(taint);
        return var60CEE2B145F0330389F8BAFBF53C9928_99919526;
        // ---------- Original Method ----------
        //return makeKey(this.getIPAddress(), port, transport);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.449 -0400", hash_original_method = "B5BA0F86714AE38D5B0FD7A4FCC59EE7", hash_generated_method = "67E4BC8870DD5E1F917EF85EF4D572B5")
    protected void setSipProvider(SipProviderImpl sipProviderImpl) {
        this.sipProvider = sipProviderImpl;
        // ---------- Original Method ----------
        //this.sipProvider = sipProviderImpl;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.449 -0400", hash_original_method = "D12539CEE35D9C982852375BE20257EF", hash_generated_method = "74906DC351FFB2C8C9754469FB66B2C0")
    protected void removeSipProvider() {
        this.sipProvider = null;
        // ---------- Original Method ----------
        //this.sipProvider = null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.450 -0400", hash_original_method = "641C5C66572DBEDEF9FDF97C1A945C27", hash_generated_method = "C56AED480FF799E0385256739A5FBB55")
    public Object clone() {
        ListeningPointImpl lip = new ListeningPointImpl(this.sipStack, this.port, null);
        lip.sipStack = this.sipStack;
Object var258B3606D2892CBE12D92EDF68F0CCA7_1078657806 =         lip;
        var258B3606D2892CBE12D92EDF68F0CCA7_1078657806.addTaint(taint);
        return var258B3606D2892CBE12D92EDF68F0CCA7_1078657806;
        // ---------- Original Method ----------
        //ListeningPointImpl lip =
            //new ListeningPointImpl(this.sipStack, this.port, null);
        //lip.sipStack = this.sipStack;
        //return lip;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.450 -0400", hash_original_method = "9099990124C6005A8102A71CBA5F7A65", hash_generated_method = "2B00D5117598D7766A72FEFE467515DA")
    public int getPort() {
        int varA0F7AE011F3DB3D236378CBBE885612E_1514071496 = (messageProcessor.getPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1781403714 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1781403714;
        // ---------- Original Method ----------
        //return messageProcessor.getPort();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.450 -0400", hash_original_method = "2F70021F53E5650B4EE9A2F614549153", hash_generated_method = "3F63831E6BCE2CA7B98934284B3FA1C9")
    public String getTransport() {
String varBC4C3AAE5A28DB5958C39988EF1A9898_884359702 =         messageProcessor.getTransport();
        varBC4C3AAE5A28DB5958C39988EF1A9898_884359702.addTaint(taint);
        return varBC4C3AAE5A28DB5958C39988EF1A9898_884359702;
        // ---------- Original Method ----------
        //return messageProcessor.getTransport();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.451 -0400", hash_original_method = "AAD8E25C27C8721BC0F29D01F90B95A6", hash_generated_method = "96D952E2E597510CACFC63870DEF8587")
    public SipProviderImpl getProvider() {
SipProviderImpl varDA6985F98D2B970198C4C0F63DBC3E3D_629411218 =         this.sipProvider;
        varDA6985F98D2B970198C4C0F63DBC3E3D_629411218.addTaint(taint);
        return varDA6985F98D2B970198C4C0F63DBC3E3D_629411218;
        // ---------- Original Method ----------
        //return this.sipProvider;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.451 -0400", hash_original_method = "C8FDA759281B0540F1A01A50A8584E49", hash_generated_method = "D8253ABAAF89D74CE965B73F6D8B9C06")
    public String getIPAddress() {
String var1D236C2B85BDC9A40A91146AB55AA21E_1142119740 =         this.messageProcessor.getIpAddress().getHostAddress();
        var1D236C2B85BDC9A40A91146AB55AA21E_1142119740.addTaint(taint);
        return var1D236C2B85BDC9A40A91146AB55AA21E_1142119740;
        // ---------- Original Method ----------
        //return this.messageProcessor.getIpAddress().getHostAddress();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.451 -0400", hash_original_method = "C988C19E7315430B0087298232CBBC55", hash_generated_method = "C1A5E207036B122F5BF52F198EB53F42")
    public void setSentBy(String sentBy) throws ParseException {
        addTaint(sentBy.getTaint());
        this.messageProcessor.setSentBy(sentBy);
        // ---------- Original Method ----------
        //this.messageProcessor.setSentBy(sentBy);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.452 -0400", hash_original_method = "0F3CBDA4EFE78BE80FA7EB48D9C543C3", hash_generated_method = "FDDFB467B3DD92CA1D10F547161E66B2")
    public String getSentBy() {
String varC94510D23C21D2DACB64ADCA57DEE82D_1714366391 =         this.messageProcessor.getSentBy();
        varC94510D23C21D2DACB64ADCA57DEE82D_1714366391.addTaint(taint);
        return varC94510D23C21D2DACB64ADCA57DEE82D_1714366391;
        // ---------- Original Method ----------
        //return this.messageProcessor.getSentBy();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.452 -0400", hash_original_method = "FB81111FA8EEF846B60E416B5C715284", hash_generated_method = "FC91778EE54D6C8CCB26B50DC41CA234")
    public boolean isSentBySet() {
        boolean var8CDC11C5D3CD6C901BC0259044842CED_1270759180 = (this.messageProcessor.isSentBySet());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_787236591 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_787236591;
        // ---------- Original Method ----------
        //return this.messageProcessor.isSentBySet();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.453 -0400", hash_original_method = "98E0FDFAA28F1C7110EA27D9E468A7B1", hash_generated_method = "0FF844AC89719E71B052C7376E27C79E")
    public Via getViaHeader() {
Via var6D1FAA9A9C9AD7C385C321F6DCC97D70_153576274 =         this.messageProcessor.getViaHeader();
        var6D1FAA9A9C9AD7C385C321F6DCC97D70_153576274.addTaint(taint);
        return var6D1FAA9A9C9AD7C385C321F6DCC97D70_153576274;
        // ---------- Original Method ----------
        //return this.messageProcessor.getViaHeader();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.453 -0400", hash_original_method = "B369445AF3BB32430CE637694E76219B", hash_generated_method = "341493184B22829858990BE430A1B38B")
    public MessageProcessor getMessageProcessor() {
MessageProcessor varEE93DAA9E4FDACE3D0129BF58212AA5C_2110265754 =         this.messageProcessor;
        varEE93DAA9E4FDACE3D0129BF58212AA5C_2110265754.addTaint(taint);
        return varEE93DAA9E4FDACE3D0129BF58212AA5C_2110265754;
        // ---------- Original Method ----------
        //return this.messageProcessor;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.454 -0400", hash_original_method = "5245FC9449D74C308C0D9DFB6981DAC3", hash_generated_method = "D8BF61F3E5B7A2CC9097CE3D4E2EC42F")
    public ContactHeader createContactHeader() {
        try 
        {
            String ipAddress = this.getIPAddress();
            int port = this.getPort();
            SipURI sipURI = new SipUri();
            sipURI.setHost(ipAddress);
            sipURI.setPort(port);
            sipURI.setTransportParam(this.transport);
            Contact contact = new Contact();
            AddressImpl address = new AddressImpl();
            address.setURI(sipURI);
            contact.setAddress(address);
ContactHeader var695F7F01550A7C9445656119C31590B1_666869501 =             contact;
            var695F7F01550A7C9445656119C31590B1_666869501.addTaint(taint);
            return var695F7F01550A7C9445656119C31590B1_666869501;
        } //End block
        catch (Exception ex)
        {
            InternalErrorHandler.handleException("Unexpected exception",sipStack.getStackLogger());
ContactHeader var540C13E9E156B687226421B24F2DF178_539904280 =             null;
            var540C13E9E156B687226421B24F2DF178_539904280.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_539904280;
        } //End block
        // ---------- Original Method ----------
        //try {
            //String ipAddress = this.getIPAddress();
            //int port = this.getPort();
            //SipURI sipURI = new SipUri();
            //sipURI.setHost(ipAddress);
            //sipURI.setPort(port);
            //sipURI.setTransportParam(this.transport);
            //Contact contact = new Contact();
            //AddressImpl address = new AddressImpl();
            //address.setURI(sipURI);
            //contact.setAddress(address);
            //return contact;
        //} catch (Exception ex) {
            //InternalErrorHandler.handleException("Unexpected exception",sipStack.getStackLogger());
            //return null;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.454 -0400", hash_original_method = "5402C8EE79A7BEF74C3B072587BA8FD1", hash_generated_method = "4CB46C05EDB5E2F87683D92EA732F850")
    public void sendHeartbeat(String ipAddress, int port) throws IOException {
        addTaint(port);
        addTaint(ipAddress.getTaint());
        HostPort targetHostPort = new HostPort();
        targetHostPort.setHost(new Host( ipAddress));
        targetHostPort.setPort(port);
        MessageChannel messageChannel = this.messageProcessor.createMessageChannel(targetHostPort);
        SIPRequest siprequest = new SIPRequest();
        siprequest.setNullRequest();
        messageChannel.sendMessage(siprequest);
        // ---------- Original Method ----------
        //HostPort targetHostPort  = new HostPort();
        //targetHostPort.setHost(new Host( ipAddress));
        //targetHostPort.setPort(port);
        //MessageChannel messageChannel = this.messageProcessor.createMessageChannel(targetHostPort);
        //SIPRequest siprequest = new SIPRequest();
        //siprequest.setNullRequest();
        //messageChannel.sendMessage(siprequest);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.454 -0400", hash_original_method = "463489B426580FC1D58885BA81FC3706", hash_generated_method = "223619B98DD59B45F435D0E59A2CC40F")
    public ViaHeader createViaHeader() {
ViaHeader varE3EA92396C3E49AC27B9C4A2722AD142_1895053580 =         this.getViaHeader();
        varE3EA92396C3E49AC27B9C4A2722AD142_1895053580.addTaint(taint);
        return varE3EA92396C3E49AC27B9C4A2722AD142_1895053580;
        // ---------- Original Method ----------
        //return this.getViaHeader();
    }

    
}

