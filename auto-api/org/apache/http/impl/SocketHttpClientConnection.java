package org.apache.http.impl;

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
import org.apache.http.HttpInetConnection;
import org.apache.http.impl.io.SocketInputBuffer;
import org.apache.http.impl.io.SocketOutputBuffer;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class SocketHttpClientConnection extends AbstractHttpClientConnection implements HttpInetConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.997 -0400", hash_original_field = "7CEF8A734855777C2A9D0CAF42666E69", hash_generated_field = "F8642D5396CC441E503E603D20259781")

    private volatile boolean open;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.997 -0400", hash_original_field = "E728D69D332AE7988C6FE7869D66573E", hash_generated_field = "9FD10C539AD3B0FAAA147E92379F8AC8")

    private Socket socket = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.998 -0400", hash_original_method = "8247D33E6B1FB68E086BB1CE85A17BB9", hash_generated_method = "155CA621912EC7DBC4E2832397471812")
    public  SocketHttpClientConnection() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.998 -0400", hash_original_method = "BD86A908767A86776B5DCBFC714C696F", hash_generated_method = "070974C83D3BFC31590AD3244AD87067")
    protected void assertNotOpen() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Connection is already open");
        } //End block
        // ---------- Original Method ----------
        //if (this.open) {
            //throw new IllegalStateException("Connection is already open");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.998 -0400", hash_original_method = "ACED44A56037ABE0B09ED18FFAC2A6E6", hash_generated_method = "3F1BDE3953311EAA59897DCCF7449F3F")
    protected void assertOpen() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Connection is not open");
        } //End block
        // ---------- Original Method ----------
        //if (!this.open) {
            //throw new IllegalStateException("Connection is not open");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.999 -0400", hash_original_method = "AA92EF53C1C7E5C18A171AB9C4BA46D7", hash_generated_method = "F97FC3A64B8C1781514F9468D22E0165")
    protected SessionInputBuffer createSessionInputBuffer(
            final Socket socket, 
            int buffersize,
            final HttpParams params) throws IOException {
        SessionInputBuffer varB4EAC82CA7396A68D541C85D26508E83_838996824 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_838996824 = new SocketInputBuffer(socket, buffersize, params);
        addTaint(socket.getTaint());
        addTaint(buffersize);
        addTaint(params.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_838996824.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_838996824;
        // ---------- Original Method ----------
        //return new SocketInputBuffer(socket, buffersize, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.004 -0400", hash_original_method = "188D8B42816E97B142A63887C343A4D5", hash_generated_method = "4330E63339027B5CF37348B3ED8FD643")
    protected SessionOutputBuffer createSessionOutputBuffer(
            final Socket socket, 
            int buffersize,
            final HttpParams params) throws IOException {
        SessionOutputBuffer varB4EAC82CA7396A68D541C85D26508E83_1880141056 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1880141056 = new SocketOutputBuffer(socket, buffersize, params);
        addTaint(socket.getTaint());
        addTaint(buffersize);
        addTaint(params.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1880141056.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1880141056;
        // ---------- Original Method ----------
        //return new SocketOutputBuffer(socket, buffersize, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.005 -0400", hash_original_method = "05B6F703A6A9BCF9CC38B84399416D78", hash_generated_method = "9953958CB9A36A6F4B855F812787FADC")
    protected void bind(
            final Socket socket, 
            final HttpParams params) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Socket may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP parameters may not be null");
        } //End block
        this.socket = socket;
        int buffersize;
        buffersize = HttpConnectionParams.getSocketBufferSize(params);
        init(
                createSessionInputBuffer(socket, buffersize, params), 
                createSessionOutputBuffer(socket, buffersize, params),
                params);
        this.open = true;
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //if (socket == null) {
            //throw new IllegalArgumentException("Socket may not be null");
        //}
        //if (params == null) {
            //throw new IllegalArgumentException("HTTP parameters may not be null");
        //}
        //this.socket = socket;
        //int buffersize = HttpConnectionParams.getSocketBufferSize(params);
        //init(
                //createSessionInputBuffer(socket, buffersize, params), 
                //createSessionOutputBuffer(socket, buffersize, params),
                //params);
        //this.open = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.010 -0400", hash_original_method = "38867CD3C8042DC0E4B0EAE08D88273F", hash_generated_method = "1C7D543C759B93B21D3AE33F2467A0AC")
    public boolean isOpen() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_197216064 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_197216064;
        // ---------- Original Method ----------
        //return this.open;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.013 -0400", hash_original_method = "B12AAA9EA995C0C9BE2466476E8BAC96", hash_generated_method = "3E97419D4F4A8D8B07C1D4312042075C")
    protected Socket getSocket() {
        Socket varB4EAC82CA7396A68D541C85D26508E83_2063118464 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2063118464 = this.socket;
        varB4EAC82CA7396A68D541C85D26508E83_2063118464.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2063118464;
        // ---------- Original Method ----------
        //return this.socket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.014 -0400", hash_original_method = "37A4CCD5FC4FE8478033812CF6081247", hash_generated_method = "47A80C6DCA402236A4F8D8FB6A5B6ED8")
    public InetAddress getLocalAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1540007210 = null; //Variable for return #1
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1347207685 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1540007210 = this.socket.getLocalAddress();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1347207685 = null;
        } //End block
        InetAddress varA7E53CE21691AB073D9660D615818899_445200896; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_445200896 = varB4EAC82CA7396A68D541C85D26508E83_1540007210;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_445200896 = varB4EAC82CA7396A68D541C85D26508E83_1347207685;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_445200896.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_445200896;
        // ---------- Original Method ----------
        //if (this.socket != null) {
            //return this.socket.getLocalAddress();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.014 -0400", hash_original_method = "CB3D09E80AD036DA49A9727AFFCF9E16", hash_generated_method = "64A5369DBB9AF22C9D1D79B4A3AB9EF5")
    public int getLocalPort() {
        {
            int varCCD0594420CD0D8D452225AADE7A07D2_56455688 = (this.socket.getLocalPort());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_82513161 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_82513161;
        // ---------- Original Method ----------
        //if (this.socket != null) {
            //return this.socket.getLocalPort();
        //} else {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.015 -0400", hash_original_method = "738E936ADE4702B2396BC3DC05386FBD", hash_generated_method = "1DF86372B85AA6DED983281D3F0EB09B")
    public InetAddress getRemoteAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1800467041 = null; //Variable for return #1
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_556293241 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1800467041 = this.socket.getInetAddress();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_556293241 = null;
        } //End block
        InetAddress varA7E53CE21691AB073D9660D615818899_1692680680; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1692680680 = varB4EAC82CA7396A68D541C85D26508E83_1800467041;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1692680680 = varB4EAC82CA7396A68D541C85D26508E83_556293241;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1692680680.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1692680680;
        // ---------- Original Method ----------
        //if (this.socket != null) {
            //return this.socket.getInetAddress();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.026 -0400", hash_original_method = "D939EFD523917F0149002711980337D5", hash_generated_method = "AF13067AF12979AAE01412E42835E7F5")
    public int getRemotePort() {
        {
            int var3EE29869B1F636B5DAA1F70FA7C6400E_1564790472 = (this.socket.getPort());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_636331350 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_636331350;
        // ---------- Original Method ----------
        //if (this.socket != null) {
            //return this.socket.getPort();
        //} else {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.027 -0400", hash_original_method = "1060FB10CE7965802AECEE442A1DB6DF", hash_generated_method = "676D254DEDC8A8C19857A94AF50E3C3B")
    public void setSocketTimeout(int timeout) {
        assertOpen();
        {
            try 
            {
                this.socket.setSoTimeout(timeout);
            } //End block
            catch (SocketException ignore)
            { }
        } //End block
        addTaint(timeout);
        // ---------- Original Method ----------
        //assertOpen();
        //if (this.socket != null) {
            //try {
                //this.socket.setSoTimeout(timeout);
            //} catch (SocketException ignore) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.027 -0400", hash_original_method = "65027FF3AE16248E56640778A6A4578D", hash_generated_method = "B9F312E659B04D7613D5C1E671F4C212")
    public int getSocketTimeout() {
        {
            try 
            {
                int var1CFD970C58DCF71C94F6332F13F0CD73_1187072670 = (this.socket.getSoTimeout());
            } //End block
            catch (SocketException ignore)
            { }
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_455776934 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_455776934;
        // ---------- Original Method ----------
        //if (this.socket != null) {
            //try {
                //return this.socket.getSoTimeout();
            //} catch (SocketException ignore) {
                //return -1;
            //}
        //} else {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.033 -0400", hash_original_method = "CEF80ABEDD17E9F414E04B4979CC6A82", hash_generated_method = "CF620A7315D3C1C1AD4D9BAC734BF982")
    public void shutdown() throws IOException {
        this.open = false;
        Socket tmpsocket;
        tmpsocket = this.socket;
        {
            tmpsocket.close();
        } //End block
        // ---------- Original Method ----------
        //this.open = false;
        //Socket tmpsocket = this.socket;
        //if (tmpsocket != null) {
            //tmpsocket.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.034 -0400", hash_original_method = "E2A0230BE95C4B74092464470E281A24", hash_generated_method = "C67C9038C6A0874A962E604367169DAC")
    public void close() throws IOException {
        this.open = false;
        doFlush();
        try 
        {
            try 
            {
                this.socket.shutdownOutput();
            } //End block
            catch (IOException ignore)
            { }
            try 
            {
                this.socket.shutdownInput();
            } //End block
            catch (IOException ignore)
            { }
        } //End block
        catch (UnsupportedOperationException ignore)
        { }
        this.socket.close();
        // ---------- Original Method ----------
        //if (!this.open) {
            //return;
        //}
        //this.open = false;
        //doFlush();
        //try {
            //try {
                //this.socket.shutdownOutput();
            //} catch (IOException ignore) {
            //}
            //try {
                //this.socket.shutdownInput();
            //} catch (IOException ignore) {
            //}
        //} catch (UnsupportedOperationException ignore) {
        //}
        //this.socket.close();
    }

    
}

