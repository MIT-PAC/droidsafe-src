package javax.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

final class DefaultSocketFactory extends SocketFactory {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.712 -0500", hash_original_method = "EE45CFA4F563D30E821D60984F7D023D", hash_generated_method = "EE45CFA4F563D30E821D60984F7D023D")
    
DefaultSocketFactory() {
    }

    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.714 -0500", hash_original_method = "A33770AB5F1406458667F0E1F9F70219", hash_generated_method = "AE20279B7DF9D5E7769620F3DB88608D")
    
@Override
    public Socket createSocket() throws IOException {
        return new Socket();
    }

    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.716 -0500", hash_original_method = "2C1906B27C1B85541A53DB0102673352", hash_generated_method = "B359A7DFA5744399F267725635413FF3")
    
@Override
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        return new Socket(host, port);
    }

    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.718 -0500", hash_original_method = "5CFD53FB508EE6C97BB6819A744C12B9", hash_generated_method = "115DAC2082ED9888CB26CDE85427B61E")
    
@Override
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort)
            throws IOException, UnknownHostException {
        return new Socket(host, port, localHost, localPort);
    }

    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.721 -0500", hash_original_method = "E8FBBD6B1D2EB76E2930CC22224BA560", hash_generated_method = "390324990FC36D52FE50D49D936C42BD")
    
@Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        return new Socket(host, port);
    }

    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.724 -0500", hash_original_method = "494C3A968988FACD5471E3F1752BD495", hash_generated_method = "62C093013E3A0C3EC62804ABB08D0B9F")
    
@Override
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress,
            int localPort) throws IOException {
        return new Socket(address, port, localAddress, localPort);
    }
    
}

