package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import libcore.util.EmptyArray;

class DefaultSSLSocketFactory extends SSLSocketFactory {
    private String errMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.046 -0400", hash_original_method = "518A173F954BA705CC3BF505F9E13E1E", hash_generated_method = "DB9646B52A95DE8A321640CE92B5371E")
    @DSModeled(DSC.SAFE)
     DefaultSSLSocketFactory(String mes) {
        dsTaint.addTaint(mes);
        // ---------- Original Method ----------
        //errMessage = mes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.046 -0400", hash_original_method = "12108FA96648EC8E1683C3067260A382", hash_generated_method = "92AFAEB08A0598071634AB26BA355610")
    @DSModeled(DSC.SAFE)
    @Override
    public String[] getDefaultCipherSuites() {
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return EmptyArray.STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.046 -0400", hash_original_method = "02FB44E3332A242283DAD5FC179FF843", hash_generated_method = "5A390AC14B34E796549B75DB1A9E1C8F")
    @DSModeled(DSC.SAFE)
    @Override
    public String[] getSupportedCipherSuites() {
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return EmptyArray.STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.046 -0400", hash_original_method = "80973C4D16E76F8CBD9DC9AFB2C6FFD0", hash_generated_method = "782CDAA0A392B9BF09B0FC11E00B8CD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        dsTaint.addTaint(s.dsTaint);
        dsTaint.addTaint(autoClose);
        if (DroidSafeAndroidRuntime.control) throw new SocketException(errMessage);
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.046 -0400", hash_original_method = "DA3DD563FBA8107A1A984067F5EE0D59", hash_generated_method = "28068A00CF1AE963159AA8C791EBBF38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        if (DroidSafeAndroidRuntime.control) throw new SocketException(errMessage);
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.046 -0400", hash_original_method = "8FF7B0825A4C1BFCEAEA97A8A771852A", hash_generated_method = "E91877E2189256971664CDC720281794")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException, UnknownHostException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        dsTaint.addTaint(localPort);
        dsTaint.addTaint(localHost.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new SocketException(errMessage);
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.047 -0400", hash_original_method = "F1FA6E0F26B33554BE365A5605459FC6", hash_generated_method = "24AD23A54F7BD1317A104BE1DF190C25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new SocketException(errMessage);
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.047 -0400", hash_original_method = "5A01435F50BC90BAF50A86E164E9FD29", hash_generated_method = "720A2006DC5F2C3589D4DA829C34C800")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress,
            int localPort) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(address.dsTaint);
        dsTaint.addTaint(localAddress.dsTaint);
        dsTaint.addTaint(localPort);
        if (DroidSafeAndroidRuntime.control) throw new SocketException(errMessage);
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
}

