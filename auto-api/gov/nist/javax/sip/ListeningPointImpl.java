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
    protected String transport;
    int port;
    protected MessageProcessor messageProcessor;
    protected SipProviderImpl sipProvider;
    protected SipStackImpl sipStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.137 -0400", hash_original_method = "7DF0488B21396F065D358B863377FD48", hash_generated_method = "A9043758ABD63FB0FEE455E394110A6E")
    @DSModeled(DSC.SAFE)
    protected ListeningPointImpl(
        SipStack sipStack,
        int port,
        String transport) {
        dsTaint.addTaint(port);
        dsTaint.addTaint(transport);
        dsTaint.addTaint(sipStack.dsTaint);
        this.sipStack = (SipStackImpl) sipStack;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.138 -0400", hash_original_method = "7B5051E336F9DA4D6C5FA2A2C5289297", hash_generated_method = "3A90576DC46CA80FD1457516C27628B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String getKey() {
        String var733D82CEA1162E4C96186852F40E2612_637309933 = (makeKey(this.getIPAddress(), port, transport));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return makeKey(this.getIPAddress(), port, transport);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.138 -0400", hash_original_method = "B5BA0F86714AE38D5B0FD7A4FCC59EE7", hash_generated_method = "8E3745AB391BD9531452AB55A25C2C2C")
    @DSModeled(DSC.SAFE)
    protected void setSipProvider(SipProviderImpl sipProviderImpl) {
        dsTaint.addTaint(sipProviderImpl.dsTaint);
        // ---------- Original Method ----------
        //this.sipProvider = sipProviderImpl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.138 -0400", hash_original_method = "D12539CEE35D9C982852375BE20257EF", hash_generated_method = "74906DC351FFB2C8C9754469FB66B2C0")
    @DSModeled(DSC.SAFE)
    protected void removeSipProvider() {
        this.sipProvider = null;
        // ---------- Original Method ----------
        //this.sipProvider = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.138 -0400", hash_original_method = "641C5C66572DBEDEF9FDF97C1A945C27", hash_generated_method = "14E744BA09E1B2A4951A284841709CCD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        ListeningPointImpl lip;
        lip = new ListeningPointImpl(this.sipStack, this.port, null);
        lip.sipStack = this.sipStack;
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ListeningPointImpl lip =
            //new ListeningPointImpl(this.sipStack, this.port, null);
        //lip.sipStack = this.sipStack;
        //return lip;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.138 -0400", hash_original_method = "9099990124C6005A8102A71CBA5F7A65", hash_generated_method = "AF4980E194143A1947CA9C1B45B048BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPort() {
        int varA100E41244C68A9F97324F08F822F83F_695929075 = (messageProcessor.getPort());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return messageProcessor.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.138 -0400", hash_original_method = "2F70021F53E5650B4EE9A2F614549153", hash_generated_method = "BDDE142B511274652506F6D751CDCC79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getTransport() {
        String varE3E53F510E4F03CED0968F12B52E1137_342273705 = (messageProcessor.getTransport());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return messageProcessor.getTransport();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.139 -0400", hash_original_method = "AAD8E25C27C8721BC0F29D01F90B95A6", hash_generated_method = "78E9D52D4E0904C64395DAE8595C7175")
    @DSModeled(DSC.SAFE)
    public SipProviderImpl getProvider() {
        return (SipProviderImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.sipProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.139 -0400", hash_original_method = "C8FDA759281B0540F1A01A50A8584E49", hash_generated_method = "9180F772D6AAEBFA2F2B5DBFB188143F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getIPAddress() {
        String var1511163DFEA08A8E58BA0D2CE2965F0B_989559813 = (this.messageProcessor.getIpAddress().getHostAddress());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.messageProcessor.getIpAddress().getHostAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.139 -0400", hash_original_method = "C988C19E7315430B0087298232CBBC55", hash_generated_method = "1285AE38133B6B56C1639ABC09A3FC3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSentBy(String sentBy) throws ParseException {
        dsTaint.addTaint(sentBy);
        this.messageProcessor.setSentBy(sentBy);
        // ---------- Original Method ----------
        //this.messageProcessor.setSentBy(sentBy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.139 -0400", hash_original_method = "0F3CBDA4EFE78BE80FA7EB48D9C543C3", hash_generated_method = "460243CAC02976E6084A0DED97F20672")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSentBy() {
        String var43175172B4D0F316467A8E86D5098421_1599070093 = (this.messageProcessor.getSentBy());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.messageProcessor.getSentBy();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.139 -0400", hash_original_method = "FB81111FA8EEF846B60E416B5C715284", hash_generated_method = "00E8BCF0B2F592B94AB723747CF6B8DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isSentBySet() {
        boolean var8338F5CF94157491D671DC7B8EF341E4_1015693202 = (this.messageProcessor.isSentBySet());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.messageProcessor.isSentBySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.139 -0400", hash_original_method = "98E0FDFAA28F1C7110EA27D9E468A7B1", hash_generated_method = "2D349C0F187A31A3E66102F996EEDA9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Via getViaHeader() {
        Via var91460FAA7702F9791A2FC16FE33BA93F_307857185 = (this.messageProcessor.getViaHeader());
        return (Via)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.messageProcessor.getViaHeader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.139 -0400", hash_original_method = "B369445AF3BB32430CE637694E76219B", hash_generated_method = "843092AC9A693B29FDC308623349BCE9")
    @DSModeled(DSC.SAFE)
    public MessageProcessor getMessageProcessor() {
        return (MessageProcessor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.messageProcessor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.140 -0400", hash_original_method = "5245FC9449D74C308C0D9DFB6981DAC3", hash_generated_method = "5BB88F6FE596EE0E753614FC4EAE5D96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContactHeader createContactHeader() {
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
        } //End block
        catch (Exception ex)
        {
            InternalErrorHandler.handleException("Unexpected exception",sipStack.getStackLogger());
        } //End block
        return (ContactHeader)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.140 -0400", hash_original_method = "5402C8EE79A7BEF74C3B072587BA8FD1", hash_generated_method = "652FC3D01E764E06A77AF5C191F98A2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendHeartbeat(String ipAddress, int port) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(ipAddress);
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
        // ---------- Original Method ----------
        //HostPort targetHostPort  = new HostPort();
        //targetHostPort.setHost(new Host( ipAddress));
        //targetHostPort.setPort(port);
        //MessageChannel messageChannel = this.messageProcessor.createMessageChannel(targetHostPort);
        //SIPRequest siprequest = new SIPRequest();
        //siprequest.setNullRequest();
        //messageChannel.sendMessage(siprequest);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.140 -0400", hash_original_method = "463489B426580FC1D58885BA81FC3706", hash_generated_method = "A1A7D8B910423746455218CE66E276C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViaHeader createViaHeader() {
        ViaHeader varFA6567B2E78C8A9E2856A41747F9A1AE_2100576292 = (this.getViaHeader());
        return (ViaHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.getViaHeader();
    }

    
}

