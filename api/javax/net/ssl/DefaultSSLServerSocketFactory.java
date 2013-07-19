package javax.net.ssl;

// Droidsafe Imports
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketException;

import libcore.util.EmptyArray;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

class DefaultSSLServerSocketFactory extends SSLServerSocketFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.569 -0400", hash_original_field = "A35A1CBBA413D923284FE4F467EA17EB", hash_generated_field = "9CF404529F089526CB6A4794BF7634AB")

    private String errMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.569 -0400", hash_original_method = "75914460F849F70EB9C61E69E22A6D0F", hash_generated_method = "D44D9734EF6EA12716A4A51DD204BD62")
      DefaultSSLServerSocketFactory(String mes) {
        errMessage = mes;
        // ---------- Original Method ----------
        //errMessage = mes;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.570 -0400", hash_original_method = "12108FA96648EC8E1683C3067260A382", hash_generated_method = "F6F597C0BE02CC92F3815BF2B3CD76E7")
    @Override
    public String[] getDefaultCipherSuites() {
String[] var46F61E348BE3BFB8B0571B04F2FE2C80_1919591812 =         EmptyArray.STRING;
        var46F61E348BE3BFB8B0571B04F2FE2C80_1919591812.addTaint(taint);
        return var46F61E348BE3BFB8B0571B04F2FE2C80_1919591812;
        // ---------- Original Method ----------
        //return EmptyArray.STRING;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.570 -0400", hash_original_method = "02FB44E3332A242283DAD5FC179FF843", hash_generated_method = "0891B57C0D8B6C47A93996FECC497AD9")
    @Override
    public String[] getSupportedCipherSuites() {
String[] var46F61E348BE3BFB8B0571B04F2FE2C80_642271864 =         EmptyArray.STRING;
        var46F61E348BE3BFB8B0571B04F2FE2C80_642271864.addTaint(taint);
        return var46F61E348BE3BFB8B0571B04F2FE2C80_642271864;
        // ---------- Original Method ----------
        //return EmptyArray.STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.570 -0400", hash_original_method = "3CA5D0FA144D223B163E20364EF717CA", hash_generated_method = "133FC510E625DA106FE17BBC85906791")
    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        addTaint(port);
        SocketException varEB339767C6BAA0A2146810EA7017633C_449620729 = new SocketException(errMessage);
        varEB339767C6BAA0A2146810EA7017633C_449620729.addTaint(taint);
        throw varEB339767C6BAA0A2146810EA7017633C_449620729;
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.570 -0400", hash_original_method = "72A7F975E743E745F7B0696336C67E27", hash_generated_method = "FC23AD8D3FECF15650B620CC2879C618")
    @Override
    public ServerSocket createServerSocket(int port, int backlog) throws IOException {
        addTaint(backlog);
        addTaint(port);
        SocketException varEB339767C6BAA0A2146810EA7017633C_1782816825 = new SocketException(errMessage);
        varEB339767C6BAA0A2146810EA7017633C_1782816825.addTaint(taint);
        throw varEB339767C6BAA0A2146810EA7017633C_1782816825;
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.571 -0400", hash_original_method = "46FACB6F6AB575F914E1C4CC8DD6AA24", hash_generated_method = "171AA8F72664419240807E7CC8F4CB00")
    @Override
    public ServerSocket createServerSocket(int port, int backlog, InetAddress iAddress) throws IOException {
        addTaint(iAddress.getTaint());
        addTaint(backlog);
        addTaint(port);
        SocketException varEB339767C6BAA0A2146810EA7017633C_11879112 = new SocketException(errMessage);
        varEB339767C6BAA0A2146810EA7017633C_11879112.addTaint(taint);
        throw varEB339767C6BAA0A2146810EA7017633C_11879112;
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
}

