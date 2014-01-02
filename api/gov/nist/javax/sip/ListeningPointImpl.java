package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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




    /**
     * Construct a key to refer to this structure from the SIP stack
     * @param host host string
     * @param port port
     * @param transport transport
     * @return a string that is used as a key
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.716 -0500", hash_original_method = "388DE5D31708B68044E586CE034D55F9", hash_generated_method = "85827F502261E6A1AE0E28DC01409AA6")
    
public static String makeKey(String host, int port, String transport) {
        return new StringBuffer(host)
            .append(":")
            .append(port)
            .append("/")
            .append(transport)
            .toString()
            .toLowerCase();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.705 -0500", hash_original_field = "852FD1938B4FCA59C0635E9D670A8D0B", hash_generated_field = "B1CF55BB145913C3C7A70130704FABEE")



    protected String transport;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.707 -0500", hash_original_field = "5A948EF636511EF149269A68FE278AED", hash_generated_field = "5A948EF636511EF149269A68FE278AED")


    int port;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.709 -0500", hash_original_field = "E4941A6D5D11F7097BE49F2BB415489B", hash_generated_field = "9E12CC740EB4D514DEBB557E6BE577E6")

    protected MessageProcessor messageProcessor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.712 -0500", hash_original_field = "ABE11E1B61EA62D737AB9769DADE074A", hash_generated_field = "7267A58204CB541E7C8F31E3DB1077A9")

    protected SipProviderImpl sipProvider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.714 -0500", hash_original_field = "03821C4D777C0A4AB8577E0C5F2371D6", hash_generated_field = "4DAF551644AC41AE30E26F4ABCF55488")

    protected SipStackImpl sipStack;

    /**
     * Constructor
     * @param sipStack Our sip stack
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.727 -0500", hash_original_method = "7DF0488B21396F065D358B863377FD48", hash_generated_method = "FEC36F4BE417850F712F923FE3C095DE")
    
protected ListeningPointImpl(
        SipStack sipStack,
        int port,
        String transport) {
        this.sipStack = (SipStackImpl) sipStack;

        this.port = port;
        this.transport = transport;

    }

    /**
     * Get the key for this strucut
     * @return  get the host
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.720 -0500", hash_original_method = "7B5051E336F9DA4D6C5FA2A2C5289297", hash_generated_method = "D09B47B9C7C7D97856A2D296D9052899")
    
protected String getKey() {
        return makeKey(this.getIPAddress(), port, transport);
    }

    /**
     * Set the sip provider for this structure.
     * @param sipProvider provider to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.722 -0500", hash_original_method = "B5BA0F86714AE38D5B0FD7A4FCC59EE7", hash_generated_method = "D5A7D0A245D1ACDACAFFBB8DAAB0C286")
    
protected void setSipProvider(SipProviderImpl sipProviderImpl) {
        this.sipProvider = sipProviderImpl;
    }

    /**
     * Remove the sip provider from this listening point.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.724 -0500", hash_original_method = "D12539CEE35D9C982852375BE20257EF", hash_generated_method = "0FAE4F94A348B3D10863180E32BA2C1A")
    
protected void removeSipProvider() {
        this.sipProvider = null;
    }

    /**
     * Clone this listening point. Note that a message Processor is not
     * started. The transport is set to null.
     * @return cloned listening point.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.730 -0500", hash_original_method = "641C5C66572DBEDEF9FDF97C1A945C27", hash_generated_method = "BB3641FDEB99F8F0DEA7460B697D9064")
    
public Object clone() {
        ListeningPointImpl lip =
            new ListeningPointImpl(this.sipStack, this.port, null);
        lip.sipStack = this.sipStack;
        return lip;
    }



    /**
     * Gets the port of the ListeningPoint. The default port of a ListeningPoint
     * is dependent on the scheme and transport.  For example:
     * <ul>
     * <li>The default port is 5060 if the transport UDP the scheme is <i>sip:</i>.
     * <li>The default port is 5060 if the transport is TCP the scheme is <i>sip:</i>.
     * <li>The default port is 5060 if the transport is SCTP the scheme is <i>sip:</i>.
     * <li>The default port is 5061 if the transport is TLS over TCP the scheme is <i>sip:</i>.
     * <li>The default port is 5061 if the transport is TCP the scheme is <i>sips:</i>.
     * </ul>
     *
     * @return port of ListeningPoint
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.732 -0500", hash_original_method = "9099990124C6005A8102A71CBA5F7A65", hash_generated_method = "4F204B5ED45BB548CF28AFE7C57565EB")
    
public int getPort() {
        return messageProcessor.getPort();
    }

    /**
     * Gets transport of the ListeningPoint.
     *
     * @return transport of ListeningPoint
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.735 -0500", hash_original_method = "2F70021F53E5650B4EE9A2F614549153", hash_generated_method = "A5A7D93E396D80685398EF17B6B67763")
    
public String getTransport() {
        return messageProcessor.getTransport();
    }

    /**
     * Get the provider.
     *
     * @return the provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.737 -0500", hash_original_method = "AAD8E25C27C8721BC0F29D01F90B95A6", hash_generated_method = "821A72F7EE986C8E1FD4966D903C9078")
    
public SipProviderImpl getProvider() {
        return this.sipProvider;
    }

    /* (non-Javadoc)
     * @see javax.sip.ListeningPoint#getIPAddress()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.739 -0500", hash_original_method = "C8FDA759281B0540F1A01A50A8584E49", hash_generated_method = "8B1F4D14E2CD6874D8D55B931387805D")
    
public String getIPAddress() {

        return this.messageProcessor.getIpAddress().getHostAddress();
    }



    /* (non-Javadoc)
     * @see javax.sip.ListeningPoint#setSentBy(java.lang.String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.741 -0500", hash_original_method = "C988C19E7315430B0087298232CBBC55", hash_generated_method = "3CCBE29524C9A3DA0F3FAC24EB19BCCC")
    
public void setSentBy(String sentBy) throws ParseException {
        this.messageProcessor.setSentBy(sentBy);

    }

    /* (non-Javadoc)
     * @see javax.sip.ListeningPoint#getSentBy()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.743 -0500", hash_original_method = "0F3CBDA4EFE78BE80FA7EB48D9C543C3", hash_generated_method = "A1EEE7F0166B76121B736334C10CFFC5")
    
public String getSentBy() {

        return this.messageProcessor.getSentBy();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.746 -0500", hash_original_method = "FB81111FA8EEF846B60E416B5C715284", hash_generated_method = "05760885D2889C8ACFFDA83C9FB6B152")
    
public boolean isSentBySet() {
        return this.messageProcessor.isSentBySet();
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.749 -0500", hash_original_method = "98E0FDFAA28F1C7110EA27D9E468A7B1", hash_generated_method = "9097EC0BA2C457452C5627F4DE507B5C")
    
public Via getViaHeader() {
        return this.messageProcessor.getViaHeader();
     }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.751 -0500", hash_original_method = "B369445AF3BB32430CE637694E76219B", hash_generated_method = "4B0F0A9B7F50969861BE18EA82A66E74")
    
public MessageProcessor getMessageProcessor() {
        return this.messageProcessor;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.754 -0500", hash_original_method = "5245FC9449D74C308C0D9DFB6981DAC3", hash_generated_method = "245A43FD499625FE64A5BB2A981016EF")
    
public ContactHeader createContactHeader() {
        try {
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
            
            return contact;
        } catch (Exception ex) {
            InternalErrorHandler.handleException("Unexpected exception",sipStack.getStackLogger());
            return null;
        }
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.756 -0500", hash_original_method = "5402C8EE79A7BEF74C3B072587BA8FD1", hash_generated_method = "3B731FBDEBF9C67A94F3246A288D24D6")
    
public void sendHeartbeat(String ipAddress, int port) throws IOException {

        HostPort targetHostPort  = new HostPort();
        targetHostPort.setHost(new Host( ipAddress));
        targetHostPort.setPort(port);
        MessageChannel messageChannel = this.messageProcessor.createMessageChannel(targetHostPort);
        SIPRequest siprequest = new SIPRequest();
        siprequest.setNullRequest();
        messageChannel.sendMessage(siprequest);

    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.759 -0500", hash_original_method = "463489B426580FC1D58885BA81FC3706", hash_generated_method = "C421309420FE90F81E0D183CBADD17D7")
    
public ViaHeader createViaHeader() {
           return this.getViaHeader();
    }

    
}

