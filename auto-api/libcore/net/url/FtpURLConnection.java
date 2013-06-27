package libcore.net.url;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketPermission;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.nio.charset.Charsets;
import java.security.Permission;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FtpURLConnection extends URLConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.266 -0400", hash_original_field = "62CE5FD8E6BD8C916853B8B84063B5BC", hash_generated_field = "29D7DAD04AED0A3F698C92F271D7CD33")

    private Socket controlSocket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.267 -0400", hash_original_field = "ABED72C2327EB6296CEDFEAF2006DEB3", hash_generated_field = "7B1D54FCA191D26513E267657B979CEB")

    private Socket dataSocket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.267 -0400", hash_original_field = "E8F8DAC6DABE3040DE150C6CE8506CD3", hash_generated_field = "7BE7DB96B1694A7C39FC6FE75B87910A")

    private ServerSocket acceptSocket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.270 -0400", hash_original_field = "45A2FD2F2740E6E3CE4775827D47DD44", hash_generated_field = "51832BA3E12265F350C7C5709B55A742")

    private InputStream ctrlInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.270 -0400", hash_original_field = "267171E6BFB2A04E5670F3CE06C59060", hash_generated_field = "92444C781A1F5D159CDAA9528EFB69D8")

    private InputStream inputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.270 -0400", hash_original_field = "55A6B3FAFD62DE046073381A8736EFFF", hash_generated_field = "12096641C7216452413CF3D401307879")

    private OutputStream ctrlOutput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.271 -0400", hash_original_field = "90E5A01CC93A2C344A089383AC078569", hash_generated_field = "C87C583997CC752459B2C205B1AD9852")

    private int dataPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.271 -0400", hash_original_field = "56E0FF4EB85672FDFA0C369E23026FCF", hash_generated_field = "38135D7350723E148C32F7DB8A1F88C7")

    private String username = "anonymous";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.271 -0400", hash_original_field = "E4ACDEB0FB5D57AEE860D82AE404EBCA", hash_generated_field = "A05E2C20CC130ACAA51D860E3D5DDA10")

    private String password = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.271 -0400", hash_original_field = "58F579EDF9F22B152776B24B7564DD9B", hash_generated_field = "FE3B08AEFFC7B5D68A43118A08CD21CC")

    private String replyCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.271 -0400", hash_original_field = "018531A6FE3834353217DBF6A6634DCF", hash_generated_field = "6E65B96A9C64AF2C3CF4B7358A16F214")

    private String hostName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.271 -0400", hash_original_field = "431387EB7262E1CFC79B125EB8A67C60", hash_generated_field = "EE0BB8F1739D62A5A5C8EDF7D478A66B")

    private Proxy proxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.271 -0400", hash_original_field = "D7764253E2BBE1A4CF807EA78A298AE2", hash_generated_field = "3CCF1C6267C7354D73650ACC80DF3F0D")

    private Proxy currentProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.271 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "DDFAECCF21F90F28142F5C866534A5C3")

    private URI uri;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.273 -0400", hash_original_method = "9C0763DE42B4885FC37474533A9FD11D", hash_generated_method = "7278D6C348A144179DDEAD26EC5673CB")
    protected  FtpURLConnection(URL url) {
        super(url);
        hostName = url.getHost();
        String parse;
        parse = url.getUserInfo();
        {
            int split;
            split = parse.indexOf(':');
            {
                username = parse.substring(0, split);
                password = parse.substring(split + 1);
            } //End block
            {
                username = parse;
            } //End block
        } //End block
        uri = null;
        try 
        {
            uri = url.toURI();
        } //End block
        catch (URISyntaxException e)
        { }
        // ---------- Original Method ----------
        //hostName = url.getHost();
        //String parse = url.getUserInfo();
        //if (parse != null) {
            //int split = parse.indexOf(':');
            //if (split >= 0) {
                //username = parse.substring(0, split);
                //password = parse.substring(split + 1);
            //} else {
                //username = parse;
            //}
        //}
        //uri = null;
        //try {
            //uri = url.toURI();
        //} catch (URISyntaxException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.274 -0400", hash_original_method = "705675501234B79BED4D0186BAC535B7", hash_generated_method = "7143207E04E6488C1D4291E74A15777F")
    protected  FtpURLConnection(URL url, Proxy proxy) {
        this(url);
        this.proxy = proxy;
        addTaint(url.getTaint());
        // ---------- Original Method ----------
        //this.proxy = proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.283 -0400", hash_original_method = "2BDEB44F3F77270286A692320830ED18", hash_generated_method = "428915D2606DEB5ABF969A1E85E8DAD8")
    private void cd() throws IOException {
        int idx;
        idx = url.getFile().lastIndexOf('/');
        {
            String dir;
            dir = url.getFile().substring(0, idx);
            write("CWD " + dir + "\r\n");
            int reply;
            reply = getReply();
            {
                boolean varBE81789B15668C14F8FBF1F7C83F40EF_29704397 = (reply != FTP_FILEOK && dir.length() > 0 && dir.charAt(0) == '/');
                {
                    write("CWD " + dir.substring(1) + "\r\n");
                    reply = getReply();
                } //End block
            } //End collapsed parenthetic
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Unable to change directories");
            } //End block
        } //End block
        // ---------- Original Method ----------
        //int idx = url.getFile().lastIndexOf('/');
        //if (idx > 0) {
            //String dir = url.getFile().substring(0, idx);
            //write("CWD " + dir + "\r\n");
            //int reply = getReply();
            //if (reply != FTP_FILEOK && dir.length() > 0 && dir.charAt(0) == '/') {
                //write("CWD " + dir.substring(1) + "\r\n");
                //reply = getReply();
            //}
            //if (reply != FTP_FILEOK) {
                //throw new IOException("Unable to change directories");
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.284 -0400", hash_original_method = "1FC662ADE026A6EC6E72DFD849EB4C0C", hash_generated_method = "B0AD703E77EE4524AFF22575D43527EB")
    @Override
    public void connect() throws IOException {
        List<Proxy> proxyList;
        proxyList = null;
        {
            proxyList = new ArrayList<Proxy>(1);
            proxyList.add(proxy);
        } //End block
        {
            ProxySelector selector;
            selector = ProxySelector.getDefault();
            {
                proxyList = selector.select(uri);
            } //End block
        } //End block
        {
            currentProxy = null;
            connectInternal();
        } //End block
        {
            ProxySelector selector;
            selector = ProxySelector.getDefault();
            Iterator<Proxy> iter;
            iter = proxyList.iterator();
            boolean connectOK;
            connectOK = false;
            String failureReason;
            failureReason = "";
            {
                boolean varCFD72D53DBA52886AC473D9BA8446371_2115063731 = (iter.hasNext() && !connectOK);
                {
                    currentProxy = iter.next();
                    try 
                    {
                        connectInternal();
                        connectOK = true;
                    } //End block
                    catch (IOException ioe)
                    {
                        failureReason = ioe.getLocalizedMessage();
                        {
                            selector.connectFailed(uri, currentProxy.address(), ioe);
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Unable to connect to server: " + failureReason);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.297 -0400", hash_original_method = "C4AF18B7DC35179EB8C42F6F6880E61F", hash_generated_method = "CC5540DE8AE36AA6478C36ABA1A06B2A")
    private void connectInternal() throws IOException {
        int port;
        port = url.getPort();
        int connectTimeout;
        connectTimeout = getConnectTimeout();
        {
            port = FTP_PORT;
        } //End block
        {
            boolean varF4CD2CCF74132A11A5914708A82DC9EC_167536215 = (currentProxy == null || Proxy.Type.HTTP == currentProxy.type());
            {
                controlSocket = new Socket();
            } //End block
            {
                controlSocket = new Socket(currentProxy);
            } //End block
        } //End collapsed parenthetic
        InetSocketAddress addr;
        addr = new InetSocketAddress(hostName, port);
        controlSocket.connect(addr, connectTimeout);
        connected = true;
        ctrlOutput = controlSocket.getOutputStream();
        ctrlInput = controlSocket.getInputStream();
        login();
        setType();
        {
            boolean var829DE01A17FC0244427FEC6DEC92507E_615726462 = (!getDoInput());
            {
                cd();
            } //End block
        } //End collapsed parenthetic
        try 
        {
            acceptSocket = new ServerSocket(0);
            dataPort = acceptSocket.getLocalPort();
            port();
            {
                connectTimeout = 3000;
            } //End block
            acceptSocket.setSoTimeout(getConnectTimeout());
            {
                boolean var68D57BFB543CF9672AB661363C16EEBA_83462567 = (getDoInput());
                {
                    getFile();
                } //End block
                {
                    sendFile();
                } //End block
            } //End collapsed parenthetic
            dataSocket = acceptSocket.accept();
            dataSocket.setSoTimeout(getReadTimeout());
            acceptSocket.close();
        } //End block
        catch (InterruptedIOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Could not establish data connection");
        } //End block
        {
            boolean var94914FE1E1D82177FF47112D9CCAA253_1777457201 = (getDoInput());
            {
                inputStream = new FtpURLInputStream(
                    new BufferedInputStream(dataSocket.getInputStream()), controlSocket);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.298 -0400", hash_original_method = "EC8528293B0BAB1F2E4332771D0B26FB", hash_generated_method = "AF4ACF53AC0089E062E80556C8992EFA")
    @Override
    public String getContentType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1792914804 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_610703028 = null; //Variable for return #2
        String result;
        result = guessContentTypeFromName(url.getFile());
        {
            varB4EAC82CA7396A68D541C85D26508E83_1792914804 = "content/unknown";
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_610703028 = result;
        String varA7E53CE21691AB073D9660D615818899_1600979749; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1600979749 = varB4EAC82CA7396A68D541C85D26508E83_1792914804;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1600979749 = varB4EAC82CA7396A68D541C85D26508E83_610703028;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1600979749.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1600979749;
        // ---------- Original Method ----------
        //String result = guessContentTypeFromName(url.getFile());
        //if (result == null) {
            //return "content/unknown";
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.308 -0400", hash_original_method = "4A774F3C4B70A99D65FCF85E87C829A2", hash_generated_method = "0A40218DE4D79643584401C98C7BDFA4")
    private void getFile() throws IOException {
        int reply;
        String file;
        file = url.getFile();
        write("RETR " + file + "\r\n");
        reply = getReply();
        {
            boolean var35CF175F816EA3EA6C255308B8C21654_1382703838 = (reply == FTP_NOTFOUND && file.length() > 0 && file.charAt(0) == '/');
            {
                write("RETR " + file.substring(1) + "\r\n");
                reply = getReply();
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Unable to retrieve file: " + reply);
        } //End block
        // ---------- Original Method ----------
        //int reply;
        //String file = url.getFile();
        //write("RETR " + file + "\r\n");
        //reply = getReply();
        //if (reply == FTP_NOTFOUND && file.length() > 0 && file.charAt(0) == '/') {
            //write("RETR " + file.substring(1) + "\r\n");
            //reply = getReply();
        //}
        //if (!(reply == FTP_OPENDATA || reply == FTP_TRANSFEROK)) {
            //throw new FileNotFoundException("Unable to retrieve file: " + reply);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.362 -0400", hash_original_method = "71DB7CA360B0ED6E855C6F8E83FB7FD7", hash_generated_method = "E52967AB3EBD4E45307DD241ABDF339C")
    @Override
    public InputStream getInputStream() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_737539922 = null; //Variable for return #1
        {
            connect();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_737539922 = inputStream;
        varB4EAC82CA7396A68D541C85D26508E83_737539922.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_737539922;
        // ---------- Original Method ----------
        //if (!connected) {
            //connect();
        //}
        //return inputStream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.363 -0400", hash_original_method = "97C79AEDFD54E69CFEDF030BFEEB0808", hash_generated_method = "C4B46E4F980E6B9CA0D56B77B92FE2DB")
    @Override
    public Permission getPermission() throws IOException {
        Permission varB4EAC82CA7396A68D541C85D26508E83_2117313729 = null; //Variable for return #1
        int port;
        port = url.getPort();
        {
            port = FTP_PORT;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2117313729 = new SocketPermission(hostName + ":" + port, "connect, resolve");
        varB4EAC82CA7396A68D541C85D26508E83_2117313729.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2117313729;
        // ---------- Original Method ----------
        //int port = url.getPort();
        //if (port <= 0) {
            //port = FTP_PORT;
        //}
        //return new SocketPermission(hostName + ":" + port, "connect, resolve");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.363 -0400", hash_original_method = "C24DD353CC035BBFCE8CBDD0A367D441", hash_generated_method = "23544BC534767CCCE143A591EEF57E37")
    @Override
    public OutputStream getOutputStream() throws IOException {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_1648595381 = null; //Variable for return #1
        {
            connect();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1648595381 = dataSocket.getOutputStream();
        varB4EAC82CA7396A68D541C85D26508E83_1648595381.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1648595381;
        // ---------- Original Method ----------
        //if (!connected) {
            //connect();
        //}
        //return dataSocket.getOutputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.368 -0400", hash_original_method = "754446702A2F2C82AEEC6CF269039EFC", hash_generated_method = "8E6CA3D14501563CF0CE6501FBF806DE")
    private int getReply() throws IOException {
        byte[] code;
        code = new byte[3];
        {
            int i;
            i = 0;
            {
                int tmp;
                tmp = ctrlInput.read();
                {
                    if (DroidSafeAndroidRuntime.control) throw new EOFException();
                } //End block
                code[i] = (byte) tmp;
            } //End block
        } //End collapsed parenthetic
        replyCode = new String(code, 0, code.length, Charsets.ISO_8859_1);
        boolean multiline;
        multiline = false;
        {
            boolean varBA5772E8936B0A50E1A123DBE745E06F_1729430722 = (ctrlInput.read() == '-');
            {
                multiline = true;
            } //End block
        } //End collapsed parenthetic
        readLine();
        {
            {
                boolean var9C00639D5751585AF0FD1C756377B44F_1896335684 = (readMultiLine());
            } //End collapsed parenthetic
        } //End block
        try 
        {
            int varBB571124520D3C3346414E12694FE6DA_1739596489 = (Integer.parseInt(replyCode));
        } //End block
        catch (NumberFormatException e)
        {
            if (DroidSafeAndroidRuntime.control) throw (IOException)(new IOException("reply code is invalid").initCause(e));
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_361538168 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_361538168;
        // ---------- Original Method ----------
        //byte[] code = new byte[3];
        //for (int i = 0; i < code.length; i++) {
            //final int tmp = ctrlInput.read();
            //if (tmp == -1) {
                //throw new EOFException();
            //}
            //code[i] = (byte) tmp;
        //}
        //replyCode = new String(code, 0, code.length, Charsets.ISO_8859_1);
        //boolean multiline = false;
        //if (ctrlInput.read() == '-') {
            //multiline = true;
        //}
        //readLine();
        //if (multiline) {
            //while (readMultiLine()) {
            //}
        //}
        //try {
            //return Integer.parseInt(replyCode);
        //} catch (NumberFormatException e) {
            //throw (IOException)(new IOException("reply code is invalid").initCause(e));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.369 -0400", hash_original_method = "0C049C745906095629F65911A54698F4", hash_generated_method = "BA8006199C9CE5DEAC5A2DA8CDD9DD59")
    private void login() throws IOException {
        int reply;
        reply = getReply();
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Unable to connect to server: " + url.getHost());
        } //End block
        write("USER " + username + "\r\n");
        reply = getReply();
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Unable to log in to server (USER): " + url.getHost());
        } //End block
        {
            write("PASS " + password + "\r\n");
            reply = getReply();
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Unable to log in to server (PASS): " + url.getHost());
            } //End block
        } //End block
        // ---------- Original Method ----------
        //int reply;
        //reply = getReply();
        //if (reply == FTP_USERREADY) {
        //} else {
            //throw new IOException("Unable to connect to server: " + url.getHost());
        //}
        //write("USER " + username + "\r\n");
        //reply = getReply();
        //if (reply == FTP_PASWD || reply == FTP_LOGGEDIN) {
        //} else {
            //throw new IOException("Unable to log in to server (USER): " + url.getHost());
        //}
        //if (reply == FTP_PASWD) {
            //write("PASS " + password + "\r\n");
            //reply = getReply();
            //if (!(reply == FTP_OK || reply == FTP_USERREADY || reply == FTP_LOGGEDIN)) {
                //throw new IOException("Unable to log in to server (PASS): " + url.getHost());
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.370 -0400", hash_original_method = "7AD2E3313E6C9CA8D7D83CEDA11B3440", hash_generated_method = "24E48425769C96A99F3FF19E158ABA9E")
    private void port() throws IOException {
        write("PORT "
                + controlSocket.getLocalAddress().getHostAddress().replace('.',
                        ',') + ',' + (dataPort >> 8) + ','
                + (dataPort & 255)
                + "\r\n");
        {
            boolean var89ABBF2CBDBE2FAE4CD06E939EEADC92_1466297715 = (getReply() != FTP_OK);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Unable to configure data port");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //write("PORT "
                //+ controlSocket.getLocalAddress().getHostAddress().replace('.',
                        //',') + ',' + (dataPort >> 8) + ','
                //+ (dataPort & 255)
                //+ "\r\n");
        //if (getReply() != FTP_OK) {
            //throw new IOException("Unable to configure data port");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.370 -0400", hash_original_method = "2E63066111AD195377A7E087D5F90A5E", hash_generated_method = "5C5F8DAADA75070CA32FDDDDAD1D33A8")
    private String readLine() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_1952448530 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder();
        int c;
        {
            boolean var0A1A84B711CE9EFCE167E7000C6A6CAC_1676874570 = ((c = ctrlInput.read()) != '\n');
            {
                sb.append((char) c);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1952448530 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1952448530.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1952448530;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //int c;
        //while ((c = ctrlInput.read()) != '\n') {
            //sb.append((char) c);
        //}
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.371 -0400", hash_original_method = "D4D3BFF8CA61872FC19064B66C8564AF", hash_generated_method = "64D6650221CB0F9BC4AD38A8319FB19C")
    private boolean readMultiLine() throws IOException {
        String line;
        line = readLine();
        {
            boolean var3A066064DA765AB7D5D26E22DA8460AD_1267314117 = (line.length() < 4);
        } //End collapsed parenthetic
        {
            boolean var0953186FCF36BD1F0150CCCE3D967FBF_930277855 = (line.substring(0, 3).equals(replyCode)
                && (line.charAt(3) == (char) 32));
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_504174499 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_504174499;
        // ---------- Original Method ----------
        //String line = readLine();
        //if (line.length() < 4) {
            //return true;
        //}
        //if (line.substring(0, 3).equals(replyCode)
                //&& (line.charAt(3) == (char) 32)) {
            //return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.374 -0400", hash_original_method = "2BA78033DAE740186A6855D293FFDC43", hash_generated_method = "3C6D1095F4A84A640ACDD09D1F6B2860")
    private void sendFile() throws IOException {
        int reply;
        write("STOR "
                + url.getFile().substring(url.getFile().lastIndexOf('/') + 1,
                        url.getFile().length()) + "\r\n");
        reply = getReply();
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Unable to store file");
        } //End block
        // ---------- Original Method ----------
        //int reply;
        //write("STOR "
                //+ url.getFile().substring(url.getFile().lastIndexOf('/') + 1,
                        //url.getFile().length()) + "\r\n");
        //reply = getReply();
        //if (!(reply == FTP_OPENDATA || reply == FTP_OK || reply == FTP_DATAOPEN)) {
            //throw new IOException("Unable to store file");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.374 -0400", hash_original_method = "D85289DF0962B48F2ED540BF99BE1F4B", hash_generated_method = "8627FE5E61E8C187C0DA384FCC1D26CE")
    @Override
    public void setDoInput(boolean newValue) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalAccessError();
        } //End block
        this.doInput = newValue;
        this.doOutput = !newValue;
        addTaint(newValue);
        // ---------- Original Method ----------
        //if (connected) {
            //throw new IllegalAccessError();
        //}
        //this.doInput = newValue;
        //this.doOutput = !newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.375 -0400", hash_original_method = "E097E58C1D164A4A6A5279DFEE80DF6A", hash_generated_method = "885E6F743885F1DFEDDAFE8B00D1E004")
    @Override
    public void setDoOutput(boolean newValue) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalAccessError();
        } //End block
        this.doOutput = newValue;
        this.doInput = !newValue;
        addTaint(newValue);
        // ---------- Original Method ----------
        //if (connected) {
            //throw new IllegalAccessError();
        //}
        //this.doOutput = newValue;
        //this.doInput = !newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.375 -0400", hash_original_method = "507EB2691A7ADEA1CDA7F73F8F57152E", hash_generated_method = "F91CCE94921CE564A5179799DA107B19")
    private void setType() throws IOException {
        write("TYPE I\r\n");
        {
            boolean var89ABBF2CBDBE2FAE4CD06E939EEADC92_965194736 = (getReply() != FTP_OK);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Unable to set transfer type");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //write("TYPE I\r\n");
        //if (getReply() != FTP_OK) {
            //throw new IOException("Unable to set transfer type");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.375 -0400", hash_original_method = "3CB2D955BA1082FED6AC9AF45688DFA7", hash_generated_method = "852C423B65CCA7735CA77354568247DF")
    private void write(String command) throws IOException {
        ctrlOutput.write(command.getBytes(Charsets.ISO_8859_1));
        addTaint(command.getTaint());
        // ---------- Original Method ----------
        //ctrlOutput.write(command.getBytes(Charsets.ISO_8859_1));
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.375 -0400", hash_original_field = "40907AD68D2326CC5B43306FB100F610", hash_generated_field = "02C45DC159C98DD9FA078997D6F66804")

    private static int FTP_PORT = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.375 -0400", hash_original_field = "23B41E27160246E1E9727D4CA0C73B88", hash_generated_field = "83003C6154691E98F2CC63EFD745DC5F")

    private static int FTP_DATAOPEN = 125;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.376 -0400", hash_original_field = "190869485A3022695759F8349A66BEAE", hash_generated_field = "B150C22E75B3FDA29A8ABBD027715C4B")

    private static int FTP_OPENDATA = 150;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.376 -0400", hash_original_field = "36C04BA3231BAA35A2B37E4587F340A1", hash_generated_field = "63241EED239D909933C82FA0FA776B6A")

    private static int FTP_OK = 200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.376 -0400", hash_original_field = "4894B10ABCD2BDE1F843362BE3972401", hash_generated_field = "4AE3754B9BFE4902F8AEFB7924712609")

    private static int FTP_USERREADY = 220;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.382 -0400", hash_original_field = "80226B533A52439A8B67E8F2DFF297A6", hash_generated_field = "5DEDC5676E9E67ED4371FD5B5C43507E")

    private static int FTP_TRANSFEROK = 226;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.382 -0400", hash_original_field = "777E76EBEBF483304080CCFBDF3B85ED", hash_generated_field = "354EB252DCECEE382D33CBB23CF9C4B3")

    private static int FTP_LOGGEDIN = 230;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.382 -0400", hash_original_field = "545A1E6BE4254F4B9F1C304543691B8D", hash_generated_field = "2B94200B12B3DD1BADA2C711B1714784")

    private static int FTP_FILEOK = 250;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.382 -0400", hash_original_field = "44D032478A43739ABF9EDD61592A1F43", hash_generated_field = "418DF2D73E74D4957E92DD7A94306195")

    private static int FTP_PASWD = 331;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.382 -0400", hash_original_field = "14A4ED5ECC64E1A63CE6CF76DAE98B2C", hash_generated_field = "32B7184D6A0122806F8AECA28D97501F")

    private static int FTP_NOTFOUND = 550;
}

