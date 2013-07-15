package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import libcore.util.EmptyArray;

class DefaultSSLSocketFactory extends SSLSocketFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.745 -0400", hash_original_field = "A35A1CBBA413D923284FE4F467EA17EB", hash_generated_field = "9CF404529F089526CB6A4794BF7634AB")

    private String errMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.746 -0400", hash_original_method = "518A173F954BA705CC3BF505F9E13E1E", hash_generated_method = "5F8808C0137C671CECF9FCB4803684EB")
      DefaultSSLSocketFactory(String mes) {
        errMessage = mes;
        // ---------- Original Method ----------
        //errMessage = mes;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.746 -0400", hash_original_method = "12108FA96648EC8E1683C3067260A382", hash_generated_method = "3B7AC1FDB1431FD34D8B9AAAAAA2FA3B")
    @Override
    public String[] getDefaultCipherSuites() {
String[] var46F61E348BE3BFB8B0571B04F2FE2C80_206727589 =         EmptyArray.STRING;
        var46F61E348BE3BFB8B0571B04F2FE2C80_206727589.addTaint(taint);
        return var46F61E348BE3BFB8B0571B04F2FE2C80_206727589;
        // ---------- Original Method ----------
        //return EmptyArray.STRING;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.747 -0400", hash_original_method = "02FB44E3332A242283DAD5FC179FF843", hash_generated_method = "7EE64CA9E529161501145AFD204E4C8D")
    @Override
    public String[] getSupportedCipherSuites() {
String[] var46F61E348BE3BFB8B0571B04F2FE2C80_191743334 =         EmptyArray.STRING;
        var46F61E348BE3BFB8B0571B04F2FE2C80_191743334.addTaint(taint);
        return var46F61E348BE3BFB8B0571B04F2FE2C80_191743334;
        // ---------- Original Method ----------
        //return EmptyArray.STRING;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.747 -0400", hash_original_method = "80973C4D16E76F8CBD9DC9AFB2C6FFD0", hash_generated_method = "9F67BA55CB91CA28B20A29C92507BABC")
    @Override
    public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
        addTaint(autoClose);
        addTaint(port);
        addTaint(host.getTaint());
        addTaint(s.getTaint());
        SocketException varEB339767C6BAA0A2146810EA7017633C_1895770000 = new SocketException(errMessage);
        varEB339767C6BAA0A2146810EA7017633C_1895770000.addTaint(taint);
        throw varEB339767C6BAA0A2146810EA7017633C_1895770000;
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.748 -0400", hash_original_method = "DA3DD563FBA8107A1A984067F5EE0D59", hash_generated_method = "7E9E695301538257643D4BFF7FC010B5")
    @Override
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        addTaint(port);
        addTaint(host.getTaint());
        SocketException varEB339767C6BAA0A2146810EA7017633C_1947095080 = new SocketException(errMessage);
        varEB339767C6BAA0A2146810EA7017633C_1947095080.addTaint(taint);
        throw varEB339767C6BAA0A2146810EA7017633C_1947095080;
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.748 -0400", hash_original_method = "8FF7B0825A4C1BFCEAEA97A8A771852A", hash_generated_method = "5AA2D9EA55736E33756FC8285D71A162")
    @Override
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException, UnknownHostException {
        addTaint(localPort);
        addTaint(localHost.getTaint());
        addTaint(port);
        addTaint(host.getTaint());
        SocketException varEB339767C6BAA0A2146810EA7017633C_1195091978 = new SocketException(errMessage);
        varEB339767C6BAA0A2146810EA7017633C_1195091978.addTaint(taint);
        throw varEB339767C6BAA0A2146810EA7017633C_1195091978;
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.749 -0400", hash_original_method = "F1FA6E0F26B33554BE365A5605459FC6", hash_generated_method = "549AD008A3DB6B1FA0A31394603514C3")
    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        addTaint(port);
        addTaint(host.getTaint());
        SocketException varEB339767C6BAA0A2146810EA7017633C_1071286377 = new SocketException(errMessage);
        varEB339767C6BAA0A2146810EA7017633C_1071286377.addTaint(taint);
        throw varEB339767C6BAA0A2146810EA7017633C_1071286377;
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.749 -0400", hash_original_method = "5A01435F50BC90BAF50A86E164E9FD29", hash_generated_method = "5C7B69AC6AC9C5431BF9D517BC74AF0A")
    @Override
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress,
            int localPort) throws IOException {
        addTaint(localPort);
        addTaint(localAddress.getTaint());
        addTaint(port);
        addTaint(address.getTaint());
        SocketException varEB339767C6BAA0A2146810EA7017633C_555668264 = new SocketException(errMessage);
        varEB339767C6BAA0A2146810EA7017633C_555668264.addTaint(taint);
        throw varEB339767C6BAA0A2146810EA7017633C_555668264;
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
}

