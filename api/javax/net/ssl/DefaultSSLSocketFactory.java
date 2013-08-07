package javax.net.ssl;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import libcore.util.EmptyArray;





class DefaultSSLSocketFactory extends SSLSocketFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.578 -0400", hash_original_field = "A35A1CBBA413D923284FE4F467EA17EB", hash_generated_field = "9CF404529F089526CB6A4794BF7634AB")

    private String errMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.578 -0400", hash_original_method = "518A173F954BA705CC3BF505F9E13E1E", hash_generated_method = "5F8808C0137C671CECF9FCB4803684EB")
      DefaultSSLSocketFactory(String mes) {
        errMessage = mes;
        // ---------- Original Method ----------
        //errMessage = mes;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.578 -0400", hash_original_method = "12108FA96648EC8E1683C3067260A382", hash_generated_method = "B8281374B12BF60AF4D8C776018A22DE")
    @Override
    public String[] getDefaultCipherSuites() {
String[] var46F61E348BE3BFB8B0571B04F2FE2C80_376952694 =         EmptyArray.STRING;
        var46F61E348BE3BFB8B0571B04F2FE2C80_376952694.addTaint(taint);
        return var46F61E348BE3BFB8B0571B04F2FE2C80_376952694;
        // ---------- Original Method ----------
        //return EmptyArray.STRING;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.579 -0400", hash_original_method = "02FB44E3332A242283DAD5FC179FF843", hash_generated_method = "635D668AECC00C790BAEFFE5BD2F01B3")
    @Override
    public String[] getSupportedCipherSuites() {
String[] var46F61E348BE3BFB8B0571B04F2FE2C80_514587504 =         EmptyArray.STRING;
        var46F61E348BE3BFB8B0571B04F2FE2C80_514587504.addTaint(taint);
        return var46F61E348BE3BFB8B0571B04F2FE2C80_514587504;
        // ---------- Original Method ----------
        //return EmptyArray.STRING;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.579 -0400", hash_original_method = "80973C4D16E76F8CBD9DC9AFB2C6FFD0", hash_generated_method = "E126D2E350AE7DB43CEBC758ACAC47FE")
    @Override
    public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
        addTaint(autoClose);
        addTaint(port);
        addTaint(host.getTaint());
        addTaint(s.getTaint());
        SocketException varEB339767C6BAA0A2146810EA7017633C_259806629 = new SocketException(errMessage);
        varEB339767C6BAA0A2146810EA7017633C_259806629.addTaint(taint);
        throw varEB339767C6BAA0A2146810EA7017633C_259806629;
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.579 -0400", hash_original_method = "DA3DD563FBA8107A1A984067F5EE0D59", hash_generated_method = "F82F15ADDF2C4C3627FDE63F21C503F0")
    @Override
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        addTaint(port);
        addTaint(host.getTaint());
        SocketException varEB339767C6BAA0A2146810EA7017633C_1567609928 = new SocketException(errMessage);
        varEB339767C6BAA0A2146810EA7017633C_1567609928.addTaint(taint);
        throw varEB339767C6BAA0A2146810EA7017633C_1567609928;
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.580 -0400", hash_original_method = "8FF7B0825A4C1BFCEAEA97A8A771852A", hash_generated_method = "3C56BA84AEF4683E085CDD24523E897F")
    @Override
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException, UnknownHostException {
        addTaint(localPort);
        addTaint(localHost.getTaint());
        addTaint(port);
        addTaint(host.getTaint());
        SocketException varEB339767C6BAA0A2146810EA7017633C_378935512 = new SocketException(errMessage);
        varEB339767C6BAA0A2146810EA7017633C_378935512.addTaint(taint);
        throw varEB339767C6BAA0A2146810EA7017633C_378935512;
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.580 -0400", hash_original_method = "F1FA6E0F26B33554BE365A5605459FC6", hash_generated_method = "5AE6D2AF626384B645C6A9B194AE9272")
    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        addTaint(port);
        addTaint(host.getTaint());
        SocketException varEB339767C6BAA0A2146810EA7017633C_1140497369 = new SocketException(errMessage);
        varEB339767C6BAA0A2146810EA7017633C_1140497369.addTaint(taint);
        throw varEB339767C6BAA0A2146810EA7017633C_1140497369;
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.581 -0400", hash_original_method = "5A01435F50BC90BAF50A86E164E9FD29", hash_generated_method = "0E0A2C01EF15256958B34F6FCAE9B82E")
    @Override
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress,
            int localPort) throws IOException {
        addTaint(localPort);
        addTaint(localAddress.getTaint());
        addTaint(port);
        addTaint(address.getTaint());
        SocketException varEB339767C6BAA0A2146810EA7017633C_436973535 = new SocketException(errMessage);
        varEB339767C6BAA0A2146810EA7017633C_436973535.addTaint(taint);
        throw varEB339767C6BAA0A2146810EA7017633C_436973535;
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
}

