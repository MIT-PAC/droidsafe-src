package org.apache.http.impl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.684 -0500", hash_original_field = "B4185B849AB8251A0F1052DF377DB9A2", hash_generated_field = "F8642D5396CC441E503E603D20259781")

    private volatile boolean open;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.686 -0500", hash_original_field = "E7F90F41B90C8A055F53F64B106EF2DC", hash_generated_field = "9FD10C539AD3B0FAAA147E92379F8AC8")

    private Socket socket = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.689 -0500", hash_original_method = "8247D33E6B1FB68E086BB1CE85A17BB9", hash_generated_method = "175251D7AC8F0A7AFFD4206B646A063D")
    
public SocketHttpClientConnection() {
        super();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.692 -0500", hash_original_method = "BD86A908767A86776B5DCBFC714C696F", hash_generated_method = "919400152E63DA2E6B748C48EF7E35F5")
    
protected void assertNotOpen() {
        if (this.open) {
            throw new IllegalStateException("Connection is already open");
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.694 -0500", hash_original_method = "ACED44A56037ABE0B09ED18FFAC2A6E6", hash_generated_method = "FFDD4DF53A09A80EDFF51162C703EFE5")
    
protected void assertOpen() {
        if (!this.open) {
            throw new IllegalStateException("Connection is not open");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.696 -0500", hash_original_method = "AA92EF53C1C7E5C18A171AB9C4BA46D7", hash_generated_method = "4AE9FBF42855DAB8A12329458F7D9666")
    
protected SessionInputBuffer createSessionInputBuffer(
            final Socket socket, 
            int buffersize,
            final HttpParams params) throws IOException {
        return new SocketInputBuffer(socket, buffersize, params);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.698 -0500", hash_original_method = "188D8B42816E97B142A63887C343A4D5", hash_generated_method = "7A877AEC0AC105AEEA2E41DD749CDB71")
    
protected SessionOutputBuffer createSessionOutputBuffer(
            final Socket socket, 
            int buffersize,
            final HttpParams params) throws IOException {
        return new SocketOutputBuffer(socket, buffersize, params);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.701 -0500", hash_original_method = "05B6F703A6A9BCF9CC38B84399416D78", hash_generated_method = "ED699B1B33A5DAFA902A0EA5D7EBE432")
    
protected void bind(
            final Socket socket, 
            final HttpParams params) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("Socket may not be null");
        }
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        this.socket = socket;

        int buffersize = HttpConnectionParams.getSocketBufferSize(params);

        init(
                createSessionInputBuffer(socket, buffersize, params), 
                createSessionOutputBuffer(socket, buffersize, params),
                params);
        
        this.open = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.703 -0500", hash_original_method = "38867CD3C8042DC0E4B0EAE08D88273F", hash_generated_method = "4B65C01A0DE7D3AF867EAB51C8BCEB29")
    
public boolean isOpen() {
        return this.open;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.705 -0500", hash_original_method = "B12AAA9EA995C0C9BE2466476E8BAC96", hash_generated_method = "39B5114475E69C5D8CA323CEC1163514")
    
protected Socket getSocket() {
        return this.socket;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.707 -0500", hash_original_method = "37A4CCD5FC4FE8478033812CF6081247", hash_generated_method = "EA530790EC409832EC35D8CAE50145BF")
    
public InetAddress getLocalAddress() {
        if (this.socket != null) {
            return this.socket.getLocalAddress();
        } else {
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.709 -0500", hash_original_method = "CB3D09E80AD036DA49A9727AFFCF9E16", hash_generated_method = "3A0C54C4A483F7C7ABC3323E7544AA7B")
    
public int getLocalPort() {
        if (this.socket != null) {
            return this.socket.getLocalPort();
        } else {
            return -1;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.711 -0500", hash_original_method = "738E936ADE4702B2396BC3DC05386FBD", hash_generated_method = "A53D10A004E6582D7D26BD15F7A46312")
    
public InetAddress getRemoteAddress() {
        if (this.socket != null) {
            return this.socket.getInetAddress();
        } else {
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.714 -0500", hash_original_method = "D939EFD523917F0149002711980337D5", hash_generated_method = "E09502CC817CBCDCE2D379B1FD8CEA55")
    
public int getRemotePort() {
        if (this.socket != null) {
            return this.socket.getPort();
        } else {
            return -1;
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.718 -0500", hash_original_method = "1060FB10CE7965802AECEE442A1DB6DF", hash_generated_method = "EE9131719BF4079CA96A25DB7FDB04A8")
    
public void setSocketTimeout(int timeout) {
        assertOpen();
        if (this.socket != null) {
            try {
                this.socket.setSoTimeout(timeout);
            } catch (SocketException ignore) {
                // It is not quite clear from the Sun's documentation if there are any 
                // other legitimate cases for a socket exception to be thrown when setting 
                // SO_TIMEOUT besides the socket being already closed
            }
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.720 -0500", hash_original_method = "65027FF3AE16248E56640778A6A4578D", hash_generated_method = "655443F0128AABC6EA28FA9B52CC5D57")
    
public int getSocketTimeout() {
        if (this.socket != null) {
            try {
                return this.socket.getSoTimeout();
            } catch (SocketException ignore) {
                return -1;
            }
        } else {
            return -1;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.722 -0500", hash_original_method = "CEF80ABEDD17E9F414E04B4979CC6A82", hash_generated_method = "C3605AB6514A2B9C5B898F69DC37D353")
    
public void shutdown() throws IOException {
        this.open = false;
        Socket tmpsocket = this.socket;
        if (tmpsocket != null) {
            tmpsocket.close();
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.725 -0500", hash_original_method = "E2A0230BE95C4B74092464470E281A24", hash_generated_method = "0212C870A827603A75CFFEDCEE597CF0")
    
public void close() throws IOException {
        if (!this.open) {
            return;
        }
        this.open = false;
        doFlush();
        try {
            try {
                this.socket.shutdownOutput();
            } catch (IOException ignore) {
            }
            try {
                this.socket.shutdownInput();
            } catch (IOException ignore) {
            }
        } catch (UnsupportedOperationException ignore) {
            // if one isn't supported, the other one isn't either
        }
        this.socket.close();
    }
    
}

