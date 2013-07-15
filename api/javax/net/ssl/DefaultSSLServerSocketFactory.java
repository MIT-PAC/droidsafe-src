package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketException;
import libcore.util.EmptyArray;

class DefaultSSLServerSocketFactory extends SSLServerSocketFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.560 -0400", hash_original_field = "A35A1CBBA413D923284FE4F467EA17EB", hash_generated_field = "9CF404529F089526CB6A4794BF7634AB")

    private String errMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.561 -0400", hash_original_method = "75914460F849F70EB9C61E69E22A6D0F", hash_generated_method = "D44D9734EF6EA12716A4A51DD204BD62")
      DefaultSSLServerSocketFactory(String mes) {
        errMessage = mes;
        // ---------- Original Method ----------
        //errMessage = mes;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.561 -0400", hash_original_method = "12108FA96648EC8E1683C3067260A382", hash_generated_method = "8D704FD5C764FE8F3107699A9ED478D5")
    @Override
    public String[] getDefaultCipherSuites() {
String[] var46F61E348BE3BFB8B0571B04F2FE2C80_1819630051 =         EmptyArray.STRING;
        var46F61E348BE3BFB8B0571B04F2FE2C80_1819630051.addTaint(taint);
        return var46F61E348BE3BFB8B0571B04F2FE2C80_1819630051;
        // ---------- Original Method ----------
        //return EmptyArray.STRING;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.561 -0400", hash_original_method = "02FB44E3332A242283DAD5FC179FF843", hash_generated_method = "1B2843C141E639106CF7FDDDB33252C4")
    @Override
    public String[] getSupportedCipherSuites() {
String[] var46F61E348BE3BFB8B0571B04F2FE2C80_916179145 =         EmptyArray.STRING;
        var46F61E348BE3BFB8B0571B04F2FE2C80_916179145.addTaint(taint);
        return var46F61E348BE3BFB8B0571B04F2FE2C80_916179145;
        // ---------- Original Method ----------
        //return EmptyArray.STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.561 -0400", hash_original_method = "3CA5D0FA144D223B163E20364EF717CA", hash_generated_method = "F8642FB1DB55FA415D9F964DCA93A20C")
    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        addTaint(port);
        SocketException varEB339767C6BAA0A2146810EA7017633C_818158412 = new SocketException(errMessage);
        varEB339767C6BAA0A2146810EA7017633C_818158412.addTaint(taint);
        throw varEB339767C6BAA0A2146810EA7017633C_818158412;
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.562 -0400", hash_original_method = "72A7F975E743E745F7B0696336C67E27", hash_generated_method = "4C97AE3EC2528E9F9BFAB49062E2E429")
    @Override
    public ServerSocket createServerSocket(int port, int backlog) throws IOException {
        addTaint(backlog);
        addTaint(port);
        SocketException varEB339767C6BAA0A2146810EA7017633C_1559481641 = new SocketException(errMessage);
        varEB339767C6BAA0A2146810EA7017633C_1559481641.addTaint(taint);
        throw varEB339767C6BAA0A2146810EA7017633C_1559481641;
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.562 -0400", hash_original_method = "46FACB6F6AB575F914E1C4CC8DD6AA24", hash_generated_method = "F1CA00F645EBDCDFF16259706236CDFC")
    @Override
    public ServerSocket createServerSocket(int port, int backlog, InetAddress iAddress) throws IOException {
        addTaint(iAddress.getTaint());
        addTaint(backlog);
        addTaint(port);
        SocketException varEB339767C6BAA0A2146810EA7017633C_1619410139 = new SocketException(errMessage);
        varEB339767C6BAA0A2146810EA7017633C_1619410139.addTaint(taint);
        throw varEB339767C6BAA0A2146810EA7017633C_1619410139;
        // ---------- Original Method ----------
        //throw new SocketException(errMessage);
    }

    
}

