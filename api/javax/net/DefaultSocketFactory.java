package javax.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

final class DefaultSocketFactory extends SocketFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.514 -0400", hash_original_method = "EE45CFA4F563D30E821D60984F7D023D", hash_generated_method = "027CB46FE2CBA12105D59EC97E29AE07")
      DefaultSocketFactory() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.514 -0400", hash_original_method = "A33770AB5F1406458667F0E1F9F70219", hash_generated_method = "FA5DC6631BEE9FEC49D8B00167E21535")
    @Override
    public Socket createSocket() throws IOException {
Socket var5C6AFEF94E279F279E58F2088BCAD974_1882777145 =         new Socket();
        var5C6AFEF94E279F279E58F2088BCAD974_1882777145.addTaint(taint);
        return var5C6AFEF94E279F279E58F2088BCAD974_1882777145;
        // ---------- Original Method ----------
        //return new Socket();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.515 -0400", hash_original_method = "2C1906B27C1B85541A53DB0102673352", hash_generated_method = "675D020311C2A51CAA2B3DE00ED7165D")
    @Override
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        addTaint(port);
        addTaint(host.getTaint());
Socket var0D5D4203F6708052EDEEA1EAD4B4F929_1342604824 =         new Socket(host, port);
        var0D5D4203F6708052EDEEA1EAD4B4F929_1342604824.addTaint(taint);
        return var0D5D4203F6708052EDEEA1EAD4B4F929_1342604824;
        // ---------- Original Method ----------
        //return new Socket(host, port);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.515 -0400", hash_original_method = "5CFD53FB508EE6C97BB6819A744C12B9", hash_generated_method = "F3682AB2181F5A064EF96572F2308B4B")
    @Override
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException, UnknownHostException {
        addTaint(localPort);
        addTaint(localHost.getTaint());
        addTaint(port);
        addTaint(host.getTaint());
Socket var543CF54B0B3F8CD0CFC68B229AB68346_664394762 =         new Socket(host, port, localHost, localPort);
        var543CF54B0B3F8CD0CFC68B229AB68346_664394762.addTaint(taint);
        return var543CF54B0B3F8CD0CFC68B229AB68346_664394762;
        // ---------- Original Method ----------
        //return new Socket(host, port, localHost, localPort);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.515 -0400", hash_original_method = "E8FBBD6B1D2EB76E2930CC22224BA560", hash_generated_method = "9959C6DA36BC4517E68256D9489524BD")
    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        addTaint(port);
        addTaint(host.getTaint());
Socket var0D5D4203F6708052EDEEA1EAD4B4F929_1392230405 =         new Socket(host, port);
        var0D5D4203F6708052EDEEA1EAD4B4F929_1392230405.addTaint(taint);
        return var0D5D4203F6708052EDEEA1EAD4B4F929_1392230405;
        // ---------- Original Method ----------
        //return new Socket(host, port);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.516 -0400", hash_original_method = "494C3A968988FACD5471E3F1752BD495", hash_generated_method = "8AE5A0D4F36B903710176AE134624684")
    @Override
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress,
            int localPort) throws IOException {
        addTaint(localPort);
        addTaint(localAddress.getTaint());
        addTaint(port);
        addTaint(address.getTaint());
Socket varEC66FA71CA1372393D6D09FCD8B5B078_1304957321 =         new Socket(address, port, localAddress, localPort);
        varEC66FA71CA1372393D6D09FCD8B5B078_1304957321.addTaint(taint);
        return varEC66FA71CA1372393D6D09FCD8B5B078_1304957321;
        // ---------- Original Method ----------
        //return new Socket(address, port, localAddress, localPort);
    }

    
}

