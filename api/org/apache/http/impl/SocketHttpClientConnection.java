package org.apache.http.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.062 -0400", hash_original_field = "7CEF8A734855777C2A9D0CAF42666E69", hash_generated_field = "F8642D5396CC441E503E603D20259781")

    private volatile boolean open;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.062 -0400", hash_original_field = "E728D69D332AE7988C6FE7869D66573E", hash_generated_field = "9FD10C539AD3B0FAAA147E92379F8AC8")

    private Socket socket = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.074 -0400", hash_original_method = "8247D33E6B1FB68E086BB1CE85A17BB9", hash_generated_method = "155CA621912EC7DBC4E2832397471812")
    public  SocketHttpClientConnection() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.074 -0400", hash_original_method = "BD86A908767A86776B5DCBFC714C696F", hash_generated_method = "96D27F673596E816D36FB9A567436145")
    protected void assertNotOpen() {
    if(this.open)        
        {
            IllegalStateException var84A3AD519B18408EB344ACE934F6C410_482700183 = new IllegalStateException("Connection is already open");
            var84A3AD519B18408EB344ACE934F6C410_482700183.addTaint(taint);
            throw var84A3AD519B18408EB344ACE934F6C410_482700183;
        } //End block
        // ---------- Original Method ----------
        //if (this.open) {
            //throw new IllegalStateException("Connection is already open");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.074 -0400", hash_original_method = "ACED44A56037ABE0B09ED18FFAC2A6E6", hash_generated_method = "1D4AB545A00F101FFE5F64CBAC1B61B1")
    protected void assertOpen() {
    if(!this.open)        
        {
            IllegalStateException var9ADD238E8FA39BC97A70F042343A30CA_762944162 = new IllegalStateException("Connection is not open");
            var9ADD238E8FA39BC97A70F042343A30CA_762944162.addTaint(taint);
            throw var9ADD238E8FA39BC97A70F042343A30CA_762944162;
        } //End block
        // ---------- Original Method ----------
        //if (!this.open) {
            //throw new IllegalStateException("Connection is not open");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.074 -0400", hash_original_method = "AA92EF53C1C7E5C18A171AB9C4BA46D7", hash_generated_method = "AC29CE2C544518658CD21E9D5449AF27")
    protected SessionInputBuffer createSessionInputBuffer(
            final Socket socket, 
            int buffersize,
            final HttpParams params) throws IOException {
        addTaint(params.getTaint());
        addTaint(buffersize);
        addTaint(socket.getTaint());
SessionInputBuffer var37442DDBB4EC5DBB61A49580F0DD0085_1994118993 =         new SocketInputBuffer(socket, buffersize, params);
        var37442DDBB4EC5DBB61A49580F0DD0085_1994118993.addTaint(taint);
        return var37442DDBB4EC5DBB61A49580F0DD0085_1994118993;
        // ---------- Original Method ----------
        //return new SocketInputBuffer(socket, buffersize, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.074 -0400", hash_original_method = "188D8B42816E97B142A63887C343A4D5", hash_generated_method = "7037F1191DB17A2DF6D57498CD3739EE")
    protected SessionOutputBuffer createSessionOutputBuffer(
            final Socket socket, 
            int buffersize,
            final HttpParams params) throws IOException {
        addTaint(params.getTaint());
        addTaint(buffersize);
        addTaint(socket.getTaint());
SessionOutputBuffer var95460FC2529DBA317C2C68B6FFB37D8D_2124452636 =         new SocketOutputBuffer(socket, buffersize, params);
        var95460FC2529DBA317C2C68B6FFB37D8D_2124452636.addTaint(taint);
        return var95460FC2529DBA317C2C68B6FFB37D8D_2124452636;
        // ---------- Original Method ----------
        //return new SocketOutputBuffer(socket, buffersize, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.075 -0400", hash_original_method = "05B6F703A6A9BCF9CC38B84399416D78", hash_generated_method = "16A4ECCB9E770047C6CFC7C78D6C567E")
    protected void bind(
            final Socket socket, 
            final HttpParams params) throws IOException {
        addTaint(params.getTaint());
    if(socket == null)        
        {
            IllegalArgumentException varCBABC6A96FAFFF53CCBEEA230A20A836_654938028 = new IllegalArgumentException("Socket may not be null");
            varCBABC6A96FAFFF53CCBEEA230A20A836_654938028.addTaint(taint);
            throw varCBABC6A96FAFFF53CCBEEA230A20A836_654938028;
        } //End block
    if(params == null)        
        {
            IllegalArgumentException var497CCC27A43EDD6EE25BEEC5507E2BE2_102785022 = new IllegalArgumentException("HTTP parameters may not be null");
            var497CCC27A43EDD6EE25BEEC5507E2BE2_102785022.addTaint(taint);
            throw var497CCC27A43EDD6EE25BEEC5507E2BE2_102785022;
        } //End block
        this.socket = socket;
        int buffersize = HttpConnectionParams.getSocketBufferSize(params);
        init(
                createSessionInputBuffer(socket, buffersize, params), 
                createSessionOutputBuffer(socket, buffersize, params),
                params);
        this.open = true;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.075 -0400", hash_original_method = "38867CD3C8042DC0E4B0EAE08D88273F", hash_generated_method = "3EE9F043284426CD1C86EA16E34751F4")
    public boolean isOpen() {
        boolean var00BFB1FB2706ED8CD7ED237AFFEB8C1A_1092136608 = (this.open);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_457208377 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_457208377;
        // ---------- Original Method ----------
        //return this.open;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.075 -0400", hash_original_method = "B12AAA9EA995C0C9BE2466476E8BAC96", hash_generated_method = "3480A8583B58D122C05BFED7A822E345")
    protected Socket getSocket() {
Socket var6B38E62DD669FDAB6F1C8B30960FAB66_408127110 =         this.socket;
        var6B38E62DD669FDAB6F1C8B30960FAB66_408127110.addTaint(taint);
        return var6B38E62DD669FDAB6F1C8B30960FAB66_408127110;
        // ---------- Original Method ----------
        //return this.socket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.075 -0400", hash_original_method = "37A4CCD5FC4FE8478033812CF6081247", hash_generated_method = "333142CC72739DB22C3BCF0EB9E92BE8")
    public InetAddress getLocalAddress() {
    if(this.socket != null)        
        {
InetAddress var55250CAC8E472010A9C3BCFFCA885EF9_252457568 =             this.socket.getLocalAddress();
            var55250CAC8E472010A9C3BCFFCA885EF9_252457568.addTaint(taint);
            return var55250CAC8E472010A9C3BCFFCA885EF9_252457568;
        } //End block
        else
        {
InetAddress var540C13E9E156B687226421B24F2DF178_443762998 =             null;
            var540C13E9E156B687226421B24F2DF178_443762998.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_443762998;
        } //End block
        // ---------- Original Method ----------
        //if (this.socket != null) {
            //return this.socket.getLocalAddress();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.075 -0400", hash_original_method = "CB3D09E80AD036DA49A9727AFFCF9E16", hash_generated_method = "7641339F75A22979A507423AAF712623")
    public int getLocalPort() {
    if(this.socket != null)        
        {
            int varA1A37855EF64705F2D43A30D558084D5_1792605700 = (this.socket.getLocalPort());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1975772699 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1975772699;
        } //End block
        else
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1669472667 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_931060929 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_931060929;
        } //End block
        // ---------- Original Method ----------
        //if (this.socket != null) {
            //return this.socket.getLocalPort();
        //} else {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.075 -0400", hash_original_method = "738E936ADE4702B2396BC3DC05386FBD", hash_generated_method = "089450318A08092917AB75FEA1B580EA")
    public InetAddress getRemoteAddress() {
    if(this.socket != null)        
        {
InetAddress var601DF1EB7A81FFA1EAA0DD611F88A9A1_1537721494 =             this.socket.getInetAddress();
            var601DF1EB7A81FFA1EAA0DD611F88A9A1_1537721494.addTaint(taint);
            return var601DF1EB7A81FFA1EAA0DD611F88A9A1_1537721494;
        } //End block
        else
        {
InetAddress var540C13E9E156B687226421B24F2DF178_1837361922 =             null;
            var540C13E9E156B687226421B24F2DF178_1837361922.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1837361922;
        } //End block
        // ---------- Original Method ----------
        //if (this.socket != null) {
            //return this.socket.getInetAddress();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.076 -0400", hash_original_method = "D939EFD523917F0149002711980337D5", hash_generated_method = "336B68BB7ABF27A2C13C8AFD5E15A8D5")
    public int getRemotePort() {
    if(this.socket != null)        
        {
            int var502403C994AC2D85DCA0890A45B626BE_1743703534 = (this.socket.getPort());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_437057444 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_437057444;
        } //End block
        else
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1996455913 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1008869584 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1008869584;
        } //End block
        // ---------- Original Method ----------
        //if (this.socket != null) {
            //return this.socket.getPort();
        //} else {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.076 -0400", hash_original_method = "1060FB10CE7965802AECEE442A1DB6DF", hash_generated_method = "BE67356934499B3F4828E090EF89D577")
    public void setSocketTimeout(int timeout) {
        addTaint(timeout);
        assertOpen();
    if(this.socket != null)        
        {
            try 
            {
                this.socket.setSoTimeout(timeout);
            } //End block
            catch (SocketException ignore)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //assertOpen();
        //if (this.socket != null) {
            //try {
                //this.socket.setSoTimeout(timeout);
            //} catch (SocketException ignore) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.076 -0400", hash_original_method = "65027FF3AE16248E56640778A6A4578D", hash_generated_method = "DB9380B55F0D51E5C59D69C29E13DD6E")
    public int getSocketTimeout() {
    if(this.socket != null)        
        {
            try 
            {
                int var1F56CB3CA7DD779FD088C15B14EF2D6D_698801974 = (this.socket.getSoTimeout());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1912681991 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1912681991;
            } //End block
            catch (SocketException ignore)
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_2130816136 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1311031846 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1311031846;
            } //End block
        } //End block
        else
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1976578906 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_856471767 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_856471767;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.076 -0400", hash_original_method = "CEF80ABEDD17E9F414E04B4979CC6A82", hash_generated_method = "A28E06A0CA260323C8F4F1C99DF0CED4")
    public void shutdown() throws IOException {
        this.open = false;
        Socket tmpsocket = this.socket;
    if(tmpsocket != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.077 -0400", hash_original_method = "E2A0230BE95C4B74092464470E281A24", hash_generated_method = "F1846722FD7DAA0EB6FBC61594D64B90")
    public void close() throws IOException {
    if(!this.open)        
        {
            return;
        } //End block
        this.open = false;
        doFlush();
        try 
        {
            try 
            {
                this.socket.shutdownOutput();
            } //End block
            catch (IOException ignore)
            {
            } //End block
            try 
            {
                this.socket.shutdownInput();
            } //End block
            catch (IOException ignore)
            {
            } //End block
        } //End block
        catch (UnsupportedOperationException ignore)
        {
        } //End block
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

