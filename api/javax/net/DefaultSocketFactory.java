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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.690 -0400", hash_original_method = "EE45CFA4F563D30E821D60984F7D023D", hash_generated_method = "027CB46FE2CBA12105D59EC97E29AE07")
      DefaultSocketFactory() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.691 -0400", hash_original_method = "A33770AB5F1406458667F0E1F9F70219", hash_generated_method = "B29BD32B918D6CA251B00AE469A4A0B1")
    @Override
    public Socket createSocket() throws IOException {
Socket var5C6AFEF94E279F279E58F2088BCAD974_330733874 =         new Socket();
        var5C6AFEF94E279F279E58F2088BCAD974_330733874.addTaint(taint);
        return var5C6AFEF94E279F279E58F2088BCAD974_330733874;
        // ---------- Original Method ----------
        //return new Socket();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.692 -0400", hash_original_method = "2C1906B27C1B85541A53DB0102673352", hash_generated_method = "899C4EF2018984B0377C7D178ACA9141")
    @Override
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        addTaint(port);
        addTaint(host.getTaint());
Socket var0D5D4203F6708052EDEEA1EAD4B4F929_748394160 =         new Socket(host, port);
        var0D5D4203F6708052EDEEA1EAD4B4F929_748394160.addTaint(taint);
        return var0D5D4203F6708052EDEEA1EAD4B4F929_748394160;
        // ---------- Original Method ----------
        //return new Socket(host, port);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.692 -0400", hash_original_method = "5CFD53FB508EE6C97BB6819A744C12B9", hash_generated_method = "E8AA5B085C6D36EE6B0F2B4337744D70")
    @Override
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException, UnknownHostException {
        addTaint(localPort);
        addTaint(localHost.getTaint());
        addTaint(port);
        addTaint(host.getTaint());
Socket var543CF54B0B3F8CD0CFC68B229AB68346_1440588455 =         new Socket(host, port, localHost, localPort);
        var543CF54B0B3F8CD0CFC68B229AB68346_1440588455.addTaint(taint);
        return var543CF54B0B3F8CD0CFC68B229AB68346_1440588455;
        // ---------- Original Method ----------
        //return new Socket(host, port, localHost, localPort);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.693 -0400", hash_original_method = "E8FBBD6B1D2EB76E2930CC22224BA560", hash_generated_method = "B4BF7B3408C5D35822426F7215F21E06")
    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        addTaint(port);
        addTaint(host.getTaint());
Socket var0D5D4203F6708052EDEEA1EAD4B4F929_911371486 =         new Socket(host, port);
        var0D5D4203F6708052EDEEA1EAD4B4F929_911371486.addTaint(taint);
        return var0D5D4203F6708052EDEEA1EAD4B4F929_911371486;
        // ---------- Original Method ----------
        //return new Socket(host, port);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.694 -0400", hash_original_method = "494C3A968988FACD5471E3F1752BD495", hash_generated_method = "02046933828395CD10FAC385F8DC6707")
    @Override
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress,
            int localPort) throws IOException {
        addTaint(localPort);
        addTaint(localAddress.getTaint());
        addTaint(port);
        addTaint(address.getTaint());
Socket varEC66FA71CA1372393D6D09FCD8B5B078_404655395 =         new Socket(address, port, localAddress, localPort);
        varEC66FA71CA1372393D6D09FCD8B5B078_404655395.addTaint(taint);
        return varEC66FA71CA1372393D6D09FCD8B5B078_404655395;
        // ---------- Original Method ----------
        //return new Socket(address, port, localAddress, localPort);
    }

    
}

