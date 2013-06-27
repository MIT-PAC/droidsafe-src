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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.010 -0400", hash_original_field = "7CEF8A734855777C2A9D0CAF42666E69", hash_generated_field = "F8642D5396CC441E503E603D20259781")

    private volatile boolean open;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.010 -0400", hash_original_field = "E728D69D332AE7988C6FE7869D66573E", hash_generated_field = "9FD10C539AD3B0FAAA147E92379F8AC8")

    private Socket socket = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.012 -0400", hash_original_method = "8247D33E6B1FB68E086BB1CE85A17BB9", hash_generated_method = "155CA621912EC7DBC4E2832397471812")
    public  SocketHttpClientConnection() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.012 -0400", hash_original_method = "BD86A908767A86776B5DCBFC714C696F", hash_generated_method = "070974C83D3BFC31590AD3244AD87067")
    protected void assertNotOpen() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Connection is already open");
        } //End block
        // ---------- Original Method ----------
        //if (this.open) {
            //throw new IllegalStateException("Connection is already open");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.012 -0400", hash_original_method = "ACED44A56037ABE0B09ED18FFAC2A6E6", hash_generated_method = "3F1BDE3953311EAA59897DCCF7449F3F")
    protected void assertOpen() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Connection is not open");
        } //End block
        // ---------- Original Method ----------
        //if (!this.open) {
            //throw new IllegalStateException("Connection is not open");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.015 -0400", hash_original_method = "AA92EF53C1C7E5C18A171AB9C4BA46D7", hash_generated_method = "045CBCA4205249FD8A4BDE6F395D5A75")
    protected SessionInputBuffer createSessionInputBuffer(
            final Socket socket, 
            int buffersize,
            final HttpParams params) throws IOException {
        SessionInputBuffer varB4EAC82CA7396A68D541C85D26508E83_1162096430 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1162096430 = new SocketInputBuffer(socket, buffersize, params);
        addTaint(socket.getTaint());
        addTaint(buffersize);
        addTaint(params.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1162096430.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1162096430;
        // ---------- Original Method ----------
        //return new SocketInputBuffer(socket, buffersize, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.016 -0400", hash_original_method = "188D8B42816E97B142A63887C343A4D5", hash_generated_method = "704515E37CB8D3968358451AC7E78E10")
    protected SessionOutputBuffer createSessionOutputBuffer(
            final Socket socket, 
            int buffersize,
            final HttpParams params) throws IOException {
        SessionOutputBuffer varB4EAC82CA7396A68D541C85D26508E83_292430911 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_292430911 = new SocketOutputBuffer(socket, buffersize, params);
        addTaint(socket.getTaint());
        addTaint(buffersize);
        addTaint(params.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_292430911.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_292430911;
        // ---------- Original Method ----------
        //return new SocketOutputBuffer(socket, buffersize, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.044 -0400", hash_original_method = "05B6F703A6A9BCF9CC38B84399416D78", hash_generated_method = "9953958CB9A36A6F4B855F812787FADC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.044 -0400", hash_original_method = "38867CD3C8042DC0E4B0EAE08D88273F", hash_generated_method = "E93FDE714EB151550FD56D484A85EEB8")
    public boolean isOpen() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1448359977 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1448359977;
        // ---------- Original Method ----------
        //return this.open;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.045 -0400", hash_original_method = "B12AAA9EA995C0C9BE2466476E8BAC96", hash_generated_method = "687507740290AAEB18D27D5377ECF965")
    protected Socket getSocket() {
        Socket varB4EAC82CA7396A68D541C85D26508E83_580902882 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_580902882 = this.socket;
        varB4EAC82CA7396A68D541C85D26508E83_580902882.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_580902882;
        // ---------- Original Method ----------
        //return this.socket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.046 -0400", hash_original_method = "37A4CCD5FC4FE8478033812CF6081247", hash_generated_method = "29B213F613E37B6B4545EC1F75D02437")
    public InetAddress getLocalAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_2117745294 = null; //Variable for return #1
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_965722572 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_2117745294 = this.socket.getLocalAddress();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_965722572 = null;
        } //End block
        InetAddress varA7E53CE21691AB073D9660D615818899_246226103; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_246226103 = varB4EAC82CA7396A68D541C85D26508E83_2117745294;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_246226103 = varB4EAC82CA7396A68D541C85D26508E83_965722572;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_246226103.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_246226103;
        // ---------- Original Method ----------
        //if (this.socket != null) {
            //return this.socket.getLocalAddress();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.046 -0400", hash_original_method = "CB3D09E80AD036DA49A9727AFFCF9E16", hash_generated_method = "6598F384B83F026CA4B8B65A54351C96")
    public int getLocalPort() {
        {
            int varCCD0594420CD0D8D452225AADE7A07D2_493855375 = (this.socket.getLocalPort());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1358735307 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1358735307;
        // ---------- Original Method ----------
        //if (this.socket != null) {
            //return this.socket.getLocalPort();
        //} else {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.046 -0400", hash_original_method = "738E936ADE4702B2396BC3DC05386FBD", hash_generated_method = "C7123278F48567884D45F72FDFEF43D1")
    public InetAddress getRemoteAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1481522970 = null; //Variable for return #1
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_399179342 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1481522970 = this.socket.getInetAddress();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_399179342 = null;
        } //End block
        InetAddress varA7E53CE21691AB073D9660D615818899_1267966535; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1267966535 = varB4EAC82CA7396A68D541C85D26508E83_1481522970;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1267966535 = varB4EAC82CA7396A68D541C85D26508E83_399179342;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1267966535.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1267966535;
        // ---------- Original Method ----------
        //if (this.socket != null) {
            //return this.socket.getInetAddress();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.047 -0400", hash_original_method = "D939EFD523917F0149002711980337D5", hash_generated_method = "4CF4E4B415782ABC5CF9FBFAE3A8E47A")
    public int getRemotePort() {
        {
            int var3EE29869B1F636B5DAA1F70FA7C6400E_309425312 = (this.socket.getPort());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_512529033 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_512529033;
        // ---------- Original Method ----------
        //if (this.socket != null) {
            //return this.socket.getPort();
        //} else {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.047 -0400", hash_original_method = "1060FB10CE7965802AECEE442A1DB6DF", hash_generated_method = "676D254DEDC8A8C19857A94AF50E3C3B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.047 -0400", hash_original_method = "65027FF3AE16248E56640778A6A4578D", hash_generated_method = "1160DC9DDB90CF83301AB2548769760D")
    public int getSocketTimeout() {
        {
            try 
            {
                int var1CFD970C58DCF71C94F6332F13F0CD73_1200171974 = (this.socket.getSoTimeout());
            } //End block
            catch (SocketException ignore)
            { }
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1960090803 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1960090803;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.060 -0400", hash_original_method = "CEF80ABEDD17E9F414E04B4979CC6A82", hash_generated_method = "CF620A7315D3C1C1AD4D9BAC734BF982")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.066 -0400", hash_original_method = "E2A0230BE95C4B74092464470E281A24", hash_generated_method = "C67C9038C6A0874A962E604367169DAC")
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

