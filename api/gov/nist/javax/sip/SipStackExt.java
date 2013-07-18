package gov.nist.javax.sip;

// Droidsafe Imports
import gov.nist.core.net.AddressResolver;
import gov.nist.javax.sip.clientauthutils.AccountManager;
import gov.nist.javax.sip.clientauthutils.AuthenticationHelper;
import gov.nist.javax.sip.clientauthutils.SecureAccountManager;
import gov.nist.javax.sip.header.extensions.JoinHeader;
import gov.nist.javax.sip.header.extensions.ReplacesHeader;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.util.Collection;

import javax.sip.Dialog;
import javax.sip.SipStack;
import javax.sip.header.HeaderFactory;

public interface SipStackExt extends SipStack {

    
    public Collection<Dialog> getDialogs();

    
    public Dialog getReplacesDialog(ReplacesHeader replacesHeader);

    
    public AuthenticationHelper getAuthenticationHelper(AccountManager accountManager,
            HeaderFactory headerFactory);
    
    
    public AuthenticationHelper getSecureAuthenticationHelper(SecureAccountManager accountManager,
            HeaderFactory headerFactory);

    
    public void setAddressResolver(AddressResolver addressResolver);

    
    public Dialog getJoinDialog(JoinHeader joinHeader);

    
    public void setEnabledCipherSuites(String[] newCipherSuites);

    
    public SocketAddress obtainLocalAddress(InetAddress dst, int dstPort,
                    InetAddress localAddress, int localPort)
        throws IOException;

}
