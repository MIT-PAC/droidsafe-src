package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.net.InetAddress;
import java.text.ParseException;
import javax.sip.*;
import javax.sip.address.SipURI;
import javax.sip.header.ContactHeader;
import javax.sip.header.ViaHeader;
import gov.nist.core.Host;
import gov.nist.core.HostPort;
import gov.nist.core.InternalErrorHandler;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.address.SipUri;
import gov.nist.javax.sip.header.Contact;
import gov.nist.javax.sip.header.Via;
import gov.nist.javax.sip.message.SIPRequest;
import gov.nist.javax.sip.stack.*;

public class ListeningPointImpl implements javax.sip.ListeningPoint, gov.nist.javax.sip.ListeningPointExt {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.506 -0400", hash_original_field = "7B334B7260361141659FA9862E803476", hash_generated_field = "B1CF55BB145913C3C7A70130704FABEE")

    protected String transport;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.506 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "5A948EF636511EF149269A68FE278AED")

    int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.506 -0400", hash_original_field = "6B75413988C7E355B374E1A5B2309AE8", hash_generated_field = "9E12CC740EB4D514DEBB557E6BE577E6")

    protected MessageProcessor messageProcessor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.506 -0400", hash_original_field = "2D3F8ACEA2D147F7A52D2FA493D756C8", hash_generated_field = "7267A58204CB541E7C8F31E3DB1077A9")

    protected SipProviderImpl sipProvider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.506 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "4DAF551644AC41AE30E26F4ABCF55488")

    protected SipStackImpl sipStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.506 -0400", hash_original_method = "7DF0488B21396F065D358B863377FD48", hash_generated_method = "4D9DF6DC89E29396EAAAC394873BE570")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.506 -0400", hash_original_method = "7B5051E336F9DA4D6C5FA2A2C5289297", hash_generated_method = "96C2E0264AFC0AB8F48CC965CBB04B50")
    protected String getKey() {
String var60CEE2B145F0330389F8BAFBF53C9928_744637497 =         makeKey(this.getIPAddress(), port, transport);
        var60CEE2B145F0330389F8BAFBF53C9928_744637497.addTaint(taint);
        return var60CEE2B145F0330389F8BAFBF53C9928_744637497;
        // ---------- Original Method ----------
        //return makeKey(this.getIPAddress(), port, transport);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.507 -0400", hash_original_method = "B5BA0F86714AE38D5B0FD7A4FCC59EE7", hash_generated_method = "67E4BC8870DD5E1F917EF85EF4D572B5")
    protected void setSipProvider(SipProviderImpl sipProviderImpl) {
        this.sipProvider = sipProviderImpl;
        // ---------- Original Method ----------
        //this.sipProvider = sipProviderImpl;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.507 -0400", hash_original_method = "D12539CEE35D9C982852375BE20257EF", hash_generated_method = "74906DC351FFB2C8C9754469FB66B2C0")
    protected void removeSipProvider() {
        this.sipProvider = null;
        // ---------- Original Method ----------
        //this.sipProvider = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.507 -0400", hash_original_method = "641C5C66572DBEDEF9FDF97C1A945C27", hash_generated_method = "D86FE4558281E444351075B5C36BC0F2")
    public Object clone() {
        ListeningPointImpl lip = new ListeningPointImpl(this.sipStack, this.port, null);
        lip.sipStack = this.sipStack;
Object var258B3606D2892CBE12D92EDF68F0CCA7_1491745422 =         lip;
        var258B3606D2892CBE12D92EDF68F0CCA7_1491745422.addTaint(taint);
        return var258B3606D2892CBE12D92EDF68F0CCA7_1491745422;
        // ---------- Original Method ----------
        //ListeningPointImpl lip =
            //new ListeningPointImpl(this.sipStack, this.port, null);
        //lip.sipStack = this.sipStack;
        //return lip;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.507 -0400", hash_original_method = "9099990124C6005A8102A71CBA5F7A65", hash_generated_method = "36A3242CE1655919EF469AA6AA8D8F3E")
    public int getPort() {
        int varA0F7AE011F3DB3D236378CBBE885612E_509311280 = (messageProcessor.getPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1797828363 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1797828363;
        // ---------- Original Method ----------
        //return messageProcessor.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.507 -0400", hash_original_method = "2F70021F53E5650B4EE9A2F614549153", hash_generated_method = "B5068C20DE4B9B2B8A52D916B1F13125")
    public String getTransport() {
String varBC4C3AAE5A28DB5958C39988EF1A9898_2114052833 =         messageProcessor.getTransport();
        varBC4C3AAE5A28DB5958C39988EF1A9898_2114052833.addTaint(taint);
        return varBC4C3AAE5A28DB5958C39988EF1A9898_2114052833;
        // ---------- Original Method ----------
        //return messageProcessor.getTransport();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.507 -0400", hash_original_method = "AAD8E25C27C8721BC0F29D01F90B95A6", hash_generated_method = "D4C41EB22AC376DAC5E384100E0A6BDA")
    public SipProviderImpl getProvider() {
SipProviderImpl varDA6985F98D2B970198C4C0F63DBC3E3D_1944325015 =         this.sipProvider;
        varDA6985F98D2B970198C4C0F63DBC3E3D_1944325015.addTaint(taint);
        return varDA6985F98D2B970198C4C0F63DBC3E3D_1944325015;
        // ---------- Original Method ----------
        //return this.sipProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.507 -0400", hash_original_method = "C8FDA759281B0540F1A01A50A8584E49", hash_generated_method = "A7DDA88851B9A023AB91FB0BF2458254")
    public String getIPAddress() {
String var1D236C2B85BDC9A40A91146AB55AA21E_1753644671 =         this.messageProcessor.getIpAddress().getHostAddress();
        var1D236C2B85BDC9A40A91146AB55AA21E_1753644671.addTaint(taint);
        return var1D236C2B85BDC9A40A91146AB55AA21E_1753644671;
        // ---------- Original Method ----------
        //return this.messageProcessor.getIpAddress().getHostAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.507 -0400", hash_original_method = "C988C19E7315430B0087298232CBBC55", hash_generated_method = "C1A5E207036B122F5BF52F198EB53F42")
    public void setSentBy(String sentBy) throws ParseException {
        addTaint(sentBy.getTaint());
        this.messageProcessor.setSentBy(sentBy);
        // ---------- Original Method ----------
        //this.messageProcessor.setSentBy(sentBy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.507 -0400", hash_original_method = "0F3CBDA4EFE78BE80FA7EB48D9C543C3", hash_generated_method = "71AE5CEB975DA9443E1868433C3B8E21")
    public String getSentBy() {
String varC94510D23C21D2DACB64ADCA57DEE82D_574851774 =         this.messageProcessor.getSentBy();
        varC94510D23C21D2DACB64ADCA57DEE82D_574851774.addTaint(taint);
        return varC94510D23C21D2DACB64ADCA57DEE82D_574851774;
        // ---------- Original Method ----------
        //return this.messageProcessor.getSentBy();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.508 -0400", hash_original_method = "FB81111FA8EEF846B60E416B5C715284", hash_generated_method = "650EC0AC063B41ADD4B3C40AD57DF92A")
    public boolean isSentBySet() {
        boolean var8CDC11C5D3CD6C901BC0259044842CED_1954074386 = (this.messageProcessor.isSentBySet());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1279288496 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1279288496;
        // ---------- Original Method ----------
        //return this.messageProcessor.isSentBySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.508 -0400", hash_original_method = "98E0FDFAA28F1C7110EA27D9E468A7B1", hash_generated_method = "5D4B50FEFF574F762C6013959F84728A")
    public Via getViaHeader() {
Via var6D1FAA9A9C9AD7C385C321F6DCC97D70_1194308123 =         this.messageProcessor.getViaHeader();
        var6D1FAA9A9C9AD7C385C321F6DCC97D70_1194308123.addTaint(taint);
        return var6D1FAA9A9C9AD7C385C321F6DCC97D70_1194308123;
        // ---------- Original Method ----------
        //return this.messageProcessor.getViaHeader();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.508 -0400", hash_original_method = "B369445AF3BB32430CE637694E76219B", hash_generated_method = "DB9C11963C1C24786EA43BE3FEF689F1")
    public MessageProcessor getMessageProcessor() {
MessageProcessor varEE93DAA9E4FDACE3D0129BF58212AA5C_199697410 =         this.messageProcessor;
        varEE93DAA9E4FDACE3D0129BF58212AA5C_199697410.addTaint(taint);
        return varEE93DAA9E4FDACE3D0129BF58212AA5C_199697410;
        // ---------- Original Method ----------
        //return this.messageProcessor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.508 -0400", hash_original_method = "5245FC9449D74C308C0D9DFB6981DAC3", hash_generated_method = "F572B7316A0BBF13B8EE8F2FDB37BB68")
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
ContactHeader var695F7F01550A7C9445656119C31590B1_1361605023 =             contact;
            var695F7F01550A7C9445656119C31590B1_1361605023.addTaint(taint);
            return var695F7F01550A7C9445656119C31590B1_1361605023;
        } //End block
        catch (Exception ex)
        {
            InternalErrorHandler.handleException("Unexpected exception",sipStack.getStackLogger());
ContactHeader var540C13E9E156B687226421B24F2DF178_2046273960 =             null;
            var540C13E9E156B687226421B24F2DF178_2046273960.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2046273960;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.508 -0400", hash_original_method = "5402C8EE79A7BEF74C3B072587BA8FD1", hash_generated_method = "4CB46C05EDB5E2F87683D92EA732F850")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.508 -0400", hash_original_method = "463489B426580FC1D58885BA81FC3706", hash_generated_method = "FE27625A04846F0F6A404082BB9E8A5F")
    public ViaHeader createViaHeader() {
ViaHeader varE3EA92396C3E49AC27B9C4A2722AD142_674331102 =         this.getViaHeader();
        varE3EA92396C3E49AC27B9C4A2722AD142_674331102.addTaint(taint);
        return varE3EA92396C3E49AC27B9C4A2722AD142_674331102;
        // ---------- Original Method ----------
        //return this.getViaHeader();
    }

    
}

