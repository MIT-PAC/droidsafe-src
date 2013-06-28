package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.628 -0400", hash_original_field = "7B334B7260361141659FA9862E803476", hash_generated_field = "B1CF55BB145913C3C7A70130704FABEE")

    protected String transport;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.628 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "5A948EF636511EF149269A68FE278AED")

    int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.629 -0400", hash_original_field = "6B75413988C7E355B374E1A5B2309AE8", hash_generated_field = "9E12CC740EB4D514DEBB557E6BE577E6")

    protected MessageProcessor messageProcessor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.629 -0400", hash_original_field = "2D3F8ACEA2D147F7A52D2FA493D756C8", hash_generated_field = "7267A58204CB541E7C8F31E3DB1077A9")

    protected SipProviderImpl sipProvider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.629 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "4DAF551644AC41AE30E26F4ABCF55488")

    protected SipStackImpl sipStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.629 -0400", hash_original_method = "7DF0488B21396F065D358B863377FD48", hash_generated_method = "4D9DF6DC89E29396EAAAC394873BE570")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.630 -0400", hash_original_method = "7B5051E336F9DA4D6C5FA2A2C5289297", hash_generated_method = "41B9C0ED980A0524B9D7308577D25F87")
    protected String getKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_915448767 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_915448767 = makeKey(this.getIPAddress(), port, transport);
        varB4EAC82CA7396A68D541C85D26508E83_915448767.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_915448767;
        // ---------- Original Method ----------
        //return makeKey(this.getIPAddress(), port, transport);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.630 -0400", hash_original_method = "B5BA0F86714AE38D5B0FD7A4FCC59EE7", hash_generated_method = "67E4BC8870DD5E1F917EF85EF4D572B5")
    protected void setSipProvider(SipProviderImpl sipProviderImpl) {
        this.sipProvider = sipProviderImpl;
        // ---------- Original Method ----------
        //this.sipProvider = sipProviderImpl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.630 -0400", hash_original_method = "D12539CEE35D9C982852375BE20257EF", hash_generated_method = "74906DC351FFB2C8C9754469FB66B2C0")
    protected void removeSipProvider() {
        this.sipProvider = null;
        // ---------- Original Method ----------
        //this.sipProvider = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.631 -0400", hash_original_method = "641C5C66572DBEDEF9FDF97C1A945C27", hash_generated_method = "008EF0DAFB187E981C75480700532B4B")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_2075171682 = null; //Variable for return #1
        ListeningPointImpl lip = new ListeningPointImpl(this.sipStack, this.port, null);
        lip.sipStack = this.sipStack;
        varB4EAC82CA7396A68D541C85D26508E83_2075171682 = lip;
        varB4EAC82CA7396A68D541C85D26508E83_2075171682.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2075171682;
        // ---------- Original Method ----------
        //ListeningPointImpl lip =
            //new ListeningPointImpl(this.sipStack, this.port, null);
        //lip.sipStack = this.sipStack;
        //return lip;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.631 -0400", hash_original_method = "9099990124C6005A8102A71CBA5F7A65", hash_generated_method = "73D6C59B6248B9D44DE3C5C47B8BC780")
    public int getPort() {
        int varA100E41244C68A9F97324F08F822F83F_1180279889 = (messageProcessor.getPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_608341399 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_608341399;
        // ---------- Original Method ----------
        //return messageProcessor.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.632 -0400", hash_original_method = "2F70021F53E5650B4EE9A2F614549153", hash_generated_method = "147CB9916F532DF138C8DBCF81ED88BE")
    public String getTransport() {
        String varB4EAC82CA7396A68D541C85D26508E83_1094307515 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1094307515 = messageProcessor.getTransport();
        varB4EAC82CA7396A68D541C85D26508E83_1094307515.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1094307515;
        // ---------- Original Method ----------
        //return messageProcessor.getTransport();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.633 -0400", hash_original_method = "AAD8E25C27C8721BC0F29D01F90B95A6", hash_generated_method = "4B0D91AD571CDC7F79847B0191A6E211")
    public SipProviderImpl getProvider() {
        SipProviderImpl varB4EAC82CA7396A68D541C85D26508E83_893696766 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_893696766 = this.sipProvider;
        varB4EAC82CA7396A68D541C85D26508E83_893696766.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_893696766;
        // ---------- Original Method ----------
        //return this.sipProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.634 -0400", hash_original_method = "C8FDA759281B0540F1A01A50A8584E49", hash_generated_method = "DB98A5D235BC9C84932E6A179BC13B4F")
    public String getIPAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_1471957288 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1471957288 = this.messageProcessor.getIpAddress().getHostAddress();
        varB4EAC82CA7396A68D541C85D26508E83_1471957288.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1471957288;
        // ---------- Original Method ----------
        //return this.messageProcessor.getIpAddress().getHostAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.634 -0400", hash_original_method = "C988C19E7315430B0087298232CBBC55", hash_generated_method = "A4A6CBEE0F7E1F92AB1F62494174E9F1")
    public void setSentBy(String sentBy) throws ParseException {
        this.messageProcessor.setSentBy(sentBy);
        addTaint(sentBy.getTaint());
        // ---------- Original Method ----------
        //this.messageProcessor.setSentBy(sentBy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.635 -0400", hash_original_method = "0F3CBDA4EFE78BE80FA7EB48D9C543C3", hash_generated_method = "28FDC837DB87C2B698172131A5EA0F78")
    public String getSentBy() {
        String varB4EAC82CA7396A68D541C85D26508E83_1004771201 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1004771201 = this.messageProcessor.getSentBy();
        varB4EAC82CA7396A68D541C85D26508E83_1004771201.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1004771201;
        // ---------- Original Method ----------
        //return this.messageProcessor.getSentBy();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.635 -0400", hash_original_method = "FB81111FA8EEF846B60E416B5C715284", hash_generated_method = "65F49FB700CA17EC9E0BD0C08CDBC8F2")
    public boolean isSentBySet() {
        boolean var8338F5CF94157491D671DC7B8EF341E4_83879199 = (this.messageProcessor.isSentBySet());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1382063557 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1382063557;
        // ---------- Original Method ----------
        //return this.messageProcessor.isSentBySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.636 -0400", hash_original_method = "98E0FDFAA28F1C7110EA27D9E468A7B1", hash_generated_method = "96C61F8A118C6970F0892C1EECE350A6")
    public Via getViaHeader() {
        Via varB4EAC82CA7396A68D541C85D26508E83_1470492837 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1470492837 = this.messageProcessor.getViaHeader();
        varB4EAC82CA7396A68D541C85D26508E83_1470492837.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1470492837;
        // ---------- Original Method ----------
        //return this.messageProcessor.getViaHeader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.636 -0400", hash_original_method = "B369445AF3BB32430CE637694E76219B", hash_generated_method = "AF22376EE7EFC3228FC25B2BAE2C3DCF")
    public MessageProcessor getMessageProcessor() {
        MessageProcessor varB4EAC82CA7396A68D541C85D26508E83_1501194128 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1501194128 = this.messageProcessor;
        varB4EAC82CA7396A68D541C85D26508E83_1501194128.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1501194128;
        // ---------- Original Method ----------
        //return this.messageProcessor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.637 -0400", hash_original_method = "5245FC9449D74C308C0D9DFB6981DAC3", hash_generated_method = "810AAC13F87A485F1AA33698EFC1F172")
    public ContactHeader createContactHeader() {
        ContactHeader varB4EAC82CA7396A68D541C85D26508E83_261181670 = null; //Variable for return #1
        ContactHeader varB4EAC82CA7396A68D541C85D26508E83_2144495956 = null; //Variable for return #2
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
            varB4EAC82CA7396A68D541C85D26508E83_261181670 = contact;
        } //End block
        catch (Exception ex)
        {
            InternalErrorHandler.handleException("Unexpected exception",sipStack.getStackLogger());
            varB4EAC82CA7396A68D541C85D26508E83_2144495956 = null;
        } //End block
        ContactHeader varA7E53CE21691AB073D9660D615818899_201014261; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_201014261 = varB4EAC82CA7396A68D541C85D26508E83_261181670;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_201014261 = varB4EAC82CA7396A68D541C85D26508E83_2144495956;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_201014261.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_201014261;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.637 -0400", hash_original_method = "5402C8EE79A7BEF74C3B072587BA8FD1", hash_generated_method = "E51F8A94885CC8F9A495DB4492C50523")
    public void sendHeartbeat(String ipAddress, int port) throws IOException {
        HostPort targetHostPort = new HostPort();
        targetHostPort.setHost(new Host( ipAddress));
        targetHostPort.setPort(port);
        MessageChannel messageChannel = this.messageProcessor.createMessageChannel(targetHostPort);
        SIPRequest siprequest = new SIPRequest();
        siprequest.setNullRequest();
        messageChannel.sendMessage(siprequest);
        addTaint(ipAddress.getTaint());
        addTaint(port);
        // ---------- Original Method ----------
        //HostPort targetHostPort  = new HostPort();
        //targetHostPort.setHost(new Host( ipAddress));
        //targetHostPort.setPort(port);
        //MessageChannel messageChannel = this.messageProcessor.createMessageChannel(targetHostPort);
        //SIPRequest siprequest = new SIPRequest();
        //siprequest.setNullRequest();
        //messageChannel.sendMessage(siprequest);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.638 -0400", hash_original_method = "463489B426580FC1D58885BA81FC3706", hash_generated_method = "D0651AB20EA67C3FB5A1F8E18E126A88")
    public ViaHeader createViaHeader() {
        ViaHeader varB4EAC82CA7396A68D541C85D26508E83_1433044763 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1433044763 = this.getViaHeader();
        varB4EAC82CA7396A68D541C85D26508E83_1433044763.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1433044763;
        // ---------- Original Method ----------
        //return this.getViaHeader();
    }

    
}

