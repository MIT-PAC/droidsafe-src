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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.737 -0400", hash_original_field = "7CEF8A734855777C2A9D0CAF42666E69", hash_generated_field = "F8642D5396CC441E503E603D20259781")

    private volatile boolean open;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.737 -0400", hash_original_field = "E728D69D332AE7988C6FE7869D66573E", hash_generated_field = "9FD10C539AD3B0FAAA147E92379F8AC8")

    private Socket socket = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.737 -0400", hash_original_method = "8247D33E6B1FB68E086BB1CE85A17BB9", hash_generated_method = "155CA621912EC7DBC4E2832397471812")
    public  SocketHttpClientConnection() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.738 -0400", hash_original_method = "BD86A908767A86776B5DCBFC714C696F", hash_generated_method = "070974C83D3BFC31590AD3244AD87067")
    protected void assertNotOpen() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Connection is already open");
        } //End block
        // ---------- Original Method ----------
        //if (this.open) {
            //throw new IllegalStateException("Connection is already open");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.738 -0400", hash_original_method = "ACED44A56037ABE0B09ED18FFAC2A6E6", hash_generated_method = "3F1BDE3953311EAA59897DCCF7449F3F")
    protected void assertOpen() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Connection is not open");
        } //End block
        // ---------- Original Method ----------
        //if (!this.open) {
            //throw new IllegalStateException("Connection is not open");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.739 -0400", hash_original_method = "AA92EF53C1C7E5C18A171AB9C4BA46D7", hash_generated_method = "CD35DA5183CBA38FA6B7963383B14647")
    protected SessionInputBuffer createSessionInputBuffer(
            final Socket socket, 
            int buffersize,
            final HttpParams params) throws IOException {
        SessionInputBuffer varB4EAC82CA7396A68D541C85D26508E83_555364116 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_555364116 = new SocketInputBuffer(socket, buffersize, params);
        addTaint(socket.getTaint());
        addTaint(buffersize);
        addTaint(params.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_555364116.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_555364116;
        // ---------- Original Method ----------
        //return new SocketInputBuffer(socket, buffersize, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.739 -0400", hash_original_method = "188D8B42816E97B142A63887C343A4D5", hash_generated_method = "E849F7D6B59E065F0F7E2859B11A8376")
    protected SessionOutputBuffer createSessionOutputBuffer(
            final Socket socket, 
            int buffersize,
            final HttpParams params) throws IOException {
        SessionOutputBuffer varB4EAC82CA7396A68D541C85D26508E83_681488489 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_681488489 = new SocketOutputBuffer(socket, buffersize, params);
        addTaint(socket.getTaint());
        addTaint(buffersize);
        addTaint(params.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_681488489.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_681488489;
        // ---------- Original Method ----------
        //return new SocketOutputBuffer(socket, buffersize, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.740 -0400", hash_original_method = "05B6F703A6A9BCF9CC38B84399416D78", hash_generated_method = "2395678C66BA08B8AC17BE35478853A2")
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
        int buffersize = HttpConnectionParams.getSocketBufferSize(params);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.741 -0400", hash_original_method = "38867CD3C8042DC0E4B0EAE08D88273F", hash_generated_method = "1BDF3AD6A5DAAAA17F5D3F49176FBEEE")
    public boolean isOpen() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1517000668 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1517000668;
        // ---------- Original Method ----------
        //return this.open;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.742 -0400", hash_original_method = "B12AAA9EA995C0C9BE2466476E8BAC96", hash_generated_method = "63259D95CC39229DFA0489306BE28644")
    protected Socket getSocket() {
        Socket varB4EAC82CA7396A68D541C85D26508E83_129504617 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_129504617 = this.socket;
        varB4EAC82CA7396A68D541C85D26508E83_129504617.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_129504617;
        // ---------- Original Method ----------
        //return this.socket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.746 -0400", hash_original_method = "37A4CCD5FC4FE8478033812CF6081247", hash_generated_method = "82206D7081D4490D702FC6BABAA31867")
    public InetAddress getLocalAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1889898680 = null; //Variable for return #1
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1815710920 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1889898680 = this.socket.getLocalAddress();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1815710920 = null;
        } //End block
        InetAddress varA7E53CE21691AB073D9660D615818899_1174709370; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1174709370 = varB4EAC82CA7396A68D541C85D26508E83_1889898680;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1174709370 = varB4EAC82CA7396A68D541C85D26508E83_1815710920;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1174709370.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1174709370;
        // ---------- Original Method ----------
        //if (this.socket != null) {
            //return this.socket.getLocalAddress();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.747 -0400", hash_original_method = "CB3D09E80AD036DA49A9727AFFCF9E16", hash_generated_method = "8A924A8B0AC4F9095FB40502F9A370ED")
    public int getLocalPort() {
        {
            int varCCD0594420CD0D8D452225AADE7A07D2_1973984019 = (this.socket.getLocalPort());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_174931060 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_174931060;
        // ---------- Original Method ----------
        //if (this.socket != null) {
            //return this.socket.getLocalPort();
        //} else {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.749 -0400", hash_original_method = "738E936ADE4702B2396BC3DC05386FBD", hash_generated_method = "CD169838BBD7E89425C9C21174E170FF")
    public InetAddress getRemoteAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1349309735 = null; //Variable for return #1
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_2144512057 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1349309735 = this.socket.getInetAddress();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_2144512057 = null;
        } //End block
        InetAddress varA7E53CE21691AB073D9660D615818899_3518316; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_3518316 = varB4EAC82CA7396A68D541C85D26508E83_1349309735;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_3518316 = varB4EAC82CA7396A68D541C85D26508E83_2144512057;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_3518316.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_3518316;
        // ---------- Original Method ----------
        //if (this.socket != null) {
            //return this.socket.getInetAddress();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.749 -0400", hash_original_method = "D939EFD523917F0149002711980337D5", hash_generated_method = "95B8388E4CD5E98DE6E357AB932BECF6")
    public int getRemotePort() {
        {
            int var3EE29869B1F636B5DAA1F70FA7C6400E_1223450162 = (this.socket.getPort());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2002078699 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2002078699;
        // ---------- Original Method ----------
        //if (this.socket != null) {
            //return this.socket.getPort();
        //} else {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.750 -0400", hash_original_method = "1060FB10CE7965802AECEE442A1DB6DF", hash_generated_method = "676D254DEDC8A8C19857A94AF50E3C3B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.750 -0400", hash_original_method = "65027FF3AE16248E56640778A6A4578D", hash_generated_method = "46DCC50BEEE88A3653DA8690868B9798")
    public int getSocketTimeout() {
        {
            try 
            {
                int var1CFD970C58DCF71C94F6332F13F0CD73_1489352447 = (this.socket.getSoTimeout());
            } //End block
            catch (SocketException ignore)
            { }
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1522865599 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1522865599;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.751 -0400", hash_original_method = "CEF80ABEDD17E9F414E04B4979CC6A82", hash_generated_method = "7E2B6040690192B3CAFE5C000979438D")
    public void shutdown() throws IOException {
        this.open = false;
        Socket tmpsocket = this.socket;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.752 -0400", hash_original_method = "E2A0230BE95C4B74092464470E281A24", hash_generated_method = "C67C9038C6A0874A962E604367169DAC")
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

