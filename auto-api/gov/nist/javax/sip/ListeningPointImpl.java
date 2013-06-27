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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.061 -0400", hash_original_field = "7B334B7260361141659FA9862E803476", hash_generated_field = "B1CF55BB145913C3C7A70130704FABEE")

    protected String transport;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.062 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "5A948EF636511EF149269A68FE278AED")

    int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.062 -0400", hash_original_field = "6B75413988C7E355B374E1A5B2309AE8", hash_generated_field = "9E12CC740EB4D514DEBB557E6BE577E6")

    protected MessageProcessor messageProcessor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.062 -0400", hash_original_field = "2D3F8ACEA2D147F7A52D2FA493D756C8", hash_generated_field = "7267A58204CB541E7C8F31E3DB1077A9")

    protected SipProviderImpl sipProvider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.062 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "4DAF551644AC41AE30E26F4ABCF55488")

    protected SipStackImpl sipStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.062 -0400", hash_original_method = "7DF0488B21396F065D358B863377FD48", hash_generated_method = "4D9DF6DC89E29396EAAAC394873BE570")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.068 -0400", hash_original_method = "7B5051E336F9DA4D6C5FA2A2C5289297", hash_generated_method = "B12B7B1F2331D0B7983956418C05F661")
    protected String getKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_239834728 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_239834728 = makeKey(this.getIPAddress(), port, transport);
        varB4EAC82CA7396A68D541C85D26508E83_239834728.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_239834728;
        // ---------- Original Method ----------
        //return makeKey(this.getIPAddress(), port, transport);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.069 -0400", hash_original_method = "B5BA0F86714AE38D5B0FD7A4FCC59EE7", hash_generated_method = "67E4BC8870DD5E1F917EF85EF4D572B5")
    protected void setSipProvider(SipProviderImpl sipProviderImpl) {
        this.sipProvider = sipProviderImpl;
        // ---------- Original Method ----------
        //this.sipProvider = sipProviderImpl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.069 -0400", hash_original_method = "D12539CEE35D9C982852375BE20257EF", hash_generated_method = "74906DC351FFB2C8C9754469FB66B2C0")
    protected void removeSipProvider() {
        this.sipProvider = null;
        // ---------- Original Method ----------
        //this.sipProvider = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.070 -0400", hash_original_method = "641C5C66572DBEDEF9FDF97C1A945C27", hash_generated_method = "E1D0C1A3AD8DC2CED5427683E2DC2156")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_882732222 = null; //Variable for return #1
        ListeningPointImpl lip;
        lip = new ListeningPointImpl(this.sipStack, this.port, null);
        lip.sipStack = this.sipStack;
        varB4EAC82CA7396A68D541C85D26508E83_882732222 = lip;
        varB4EAC82CA7396A68D541C85D26508E83_882732222.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_882732222;
        // ---------- Original Method ----------
        //ListeningPointImpl lip =
            //new ListeningPointImpl(this.sipStack, this.port, null);
        //lip.sipStack = this.sipStack;
        //return lip;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.070 -0400", hash_original_method = "9099990124C6005A8102A71CBA5F7A65", hash_generated_method = "ECB0C996C3CD48EFA7166705CA162FDB")
    public int getPort() {
        int varA100E41244C68A9F97324F08F822F83F_1344021267 = (messageProcessor.getPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_347309795 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_347309795;
        // ---------- Original Method ----------
        //return messageProcessor.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.070 -0400", hash_original_method = "2F70021F53E5650B4EE9A2F614549153", hash_generated_method = "09DD023F499FEA97F4172445020C6854")
    public String getTransport() {
        String varB4EAC82CA7396A68D541C85D26508E83_622500787 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_622500787 = messageProcessor.getTransport();
        varB4EAC82CA7396A68D541C85D26508E83_622500787.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_622500787;
        // ---------- Original Method ----------
        //return messageProcessor.getTransport();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.072 -0400", hash_original_method = "AAD8E25C27C8721BC0F29D01F90B95A6", hash_generated_method = "03C5EBB6470F82454432E999E8F12B12")
    public SipProviderImpl getProvider() {
        SipProviderImpl varB4EAC82CA7396A68D541C85D26508E83_206480263 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_206480263 = this.sipProvider;
        varB4EAC82CA7396A68D541C85D26508E83_206480263.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_206480263;
        // ---------- Original Method ----------
        //return this.sipProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.072 -0400", hash_original_method = "C8FDA759281B0540F1A01A50A8584E49", hash_generated_method = "BFEB8E1D5701726562C5BBB2F5AFA784")
    public String getIPAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_1265236265 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1265236265 = this.messageProcessor.getIpAddress().getHostAddress();
        varB4EAC82CA7396A68D541C85D26508E83_1265236265.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1265236265;
        // ---------- Original Method ----------
        //return this.messageProcessor.getIpAddress().getHostAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.072 -0400", hash_original_method = "C988C19E7315430B0087298232CBBC55", hash_generated_method = "A4A6CBEE0F7E1F92AB1F62494174E9F1")
    public void setSentBy(String sentBy) throws ParseException {
        this.messageProcessor.setSentBy(sentBy);
        addTaint(sentBy.getTaint());
        // ---------- Original Method ----------
        //this.messageProcessor.setSentBy(sentBy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.073 -0400", hash_original_method = "0F3CBDA4EFE78BE80FA7EB48D9C543C3", hash_generated_method = "095AF9F25D3475AEC3D3BE8A8A81780A")
    public String getSentBy() {
        String varB4EAC82CA7396A68D541C85D26508E83_1827061036 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1827061036 = this.messageProcessor.getSentBy();
        varB4EAC82CA7396A68D541C85D26508E83_1827061036.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1827061036;
        // ---------- Original Method ----------
        //return this.messageProcessor.getSentBy();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.073 -0400", hash_original_method = "FB81111FA8EEF846B60E416B5C715284", hash_generated_method = "59EE3A04577E789BAE303E29D34BC681")
    public boolean isSentBySet() {
        boolean var8338F5CF94157491D671DC7B8EF341E4_1296370370 = (this.messageProcessor.isSentBySet());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1951003255 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1951003255;
        // ---------- Original Method ----------
        //return this.messageProcessor.isSentBySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.077 -0400", hash_original_method = "98E0FDFAA28F1C7110EA27D9E468A7B1", hash_generated_method = "E1268A12427198CC16C8F4AE5AF099D8")
    public Via getViaHeader() {
        Via varB4EAC82CA7396A68D541C85D26508E83_704036426 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_704036426 = this.messageProcessor.getViaHeader();
        varB4EAC82CA7396A68D541C85D26508E83_704036426.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_704036426;
        // ---------- Original Method ----------
        //return this.messageProcessor.getViaHeader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.077 -0400", hash_original_method = "B369445AF3BB32430CE637694E76219B", hash_generated_method = "4113A3F35FB8DFA327F5598245F87B88")
    public MessageProcessor getMessageProcessor() {
        MessageProcessor varB4EAC82CA7396A68D541C85D26508E83_1258527375 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1258527375 = this.messageProcessor;
        varB4EAC82CA7396A68D541C85D26508E83_1258527375.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1258527375;
        // ---------- Original Method ----------
        //return this.messageProcessor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.078 -0400", hash_original_method = "5245FC9449D74C308C0D9DFB6981DAC3", hash_generated_method = "5D5A48F709E97243718EEE2CFD556BA5")
    public ContactHeader createContactHeader() {
        ContactHeader varB4EAC82CA7396A68D541C85D26508E83_1869171718 = null; //Variable for return #1
        ContactHeader varB4EAC82CA7396A68D541C85D26508E83_966548482 = null; //Variable for return #2
        try 
        {
            String ipAddress;
            ipAddress = this.getIPAddress();
            int port;
            port = this.getPort();
            SipURI sipURI;
            sipURI = new SipUri();
            sipURI.setHost(ipAddress);
            sipURI.setPort(port);
            sipURI.setTransportParam(this.transport);
            Contact contact;
            contact = new Contact();
            AddressImpl address;
            address = new AddressImpl();
            address.setURI(sipURI);
            contact.setAddress(address);
            varB4EAC82CA7396A68D541C85D26508E83_1869171718 = contact;
        } //End block
        catch (Exception ex)
        {
            InternalErrorHandler.handleException("Unexpected exception",sipStack.getStackLogger());
            varB4EAC82CA7396A68D541C85D26508E83_966548482 = null;
        } //End block
        ContactHeader varA7E53CE21691AB073D9660D615818899_537349107; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_537349107 = varB4EAC82CA7396A68D541C85D26508E83_1869171718;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_537349107 = varB4EAC82CA7396A68D541C85D26508E83_966548482;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_537349107.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_537349107;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.079 -0400", hash_original_method = "5402C8EE79A7BEF74C3B072587BA8FD1", hash_generated_method = "7779CF82B1DB7C70438F07542374B8A3")
    public void sendHeartbeat(String ipAddress, int port) throws IOException {
        HostPort targetHostPort;
        targetHostPort = new HostPort();
        targetHostPort.setHost(new Host( ipAddress));
        targetHostPort.setPort(port);
        MessageChannel messageChannel;
        messageChannel = this.messageProcessor.createMessageChannel(targetHostPort);
        SIPRequest siprequest;
        siprequest = new SIPRequest();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.080 -0400", hash_original_method = "463489B426580FC1D58885BA81FC3706", hash_generated_method = "7ADF6857EB376D21846B5FD375C00D30")
    public ViaHeader createViaHeader() {
        ViaHeader varB4EAC82CA7396A68D541C85D26508E83_1340941200 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1340941200 = this.getViaHeader();
        varB4EAC82CA7396A68D541C85D26508E83_1340941200.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1340941200;
        // ---------- Original Method ----------
        //return this.getViaHeader();
    }

    
}

