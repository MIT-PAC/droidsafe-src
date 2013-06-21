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
    private Socket controlSocket;
    private Socket dataSocket;
    private ServerSocket acceptSocket;
    private InputStream ctrlInput;
    private InputStream inputStream;
    private OutputStream ctrlOutput;
    private int dataPort;
    private String username = "anonymous";
    private String password = "";
    private String replyCode;
    private String hostName;
    private Proxy proxy;
    private Proxy currentProxy;
    private URI uri;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.616 -0400", hash_original_method = "9C0763DE42B4885FC37474533A9FD11D", hash_generated_method = "B166B328505F4461EB6033DB2737E13F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected FtpURLConnection(URL url) {
        super(url);
        dsTaint.addTaint(url.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.617 -0400", hash_original_method = "705675501234B79BED4D0186BAC535B7", hash_generated_method = "B1375C3B25DEAF315DD5A090ECEEEFB0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected FtpURLConnection(URL url, Proxy proxy) {
        this(url);
        dsTaint.addTaint(proxy.dsTaint);
        dsTaint.addTaint(url.dsTaint);
        // ---------- Original Method ----------
        //this.proxy = proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.619 -0400", hash_original_method = "2BDEB44F3F77270286A692320830ED18", hash_generated_method = "8D49EEA01155D6DE2C928876958F2AD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                boolean varBE81789B15668C14F8FBF1F7C83F40EF_1206709649 = (reply != FTP_FILEOK && dir.length() > 0 && dir.charAt(0) == '/');
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.620 -0400", hash_original_method = "1FC662ADE026A6EC6E72DFD849EB4C0C", hash_generated_method = "8EB5991E40A4A452934994EDCBD70018")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                boolean varCFD72D53DBA52886AC473D9BA8446371_1141001807 = (iter.hasNext() && !connectOK);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.622 -0400", hash_original_method = "C4AF18B7DC35179EB8C42F6F6880E61F", hash_generated_method = "2BB7AF6A055ACBC8EE6CFF505700B9D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void connectInternal() throws IOException {
        int port;
        port = url.getPort();
        int connectTimeout;
        connectTimeout = getConnectTimeout();
        {
            port = FTP_PORT;
        } //End block
        {
            boolean varF4CD2CCF74132A11A5914708A82DC9EC_1330836434 = (currentProxy == null || Proxy.Type.HTTP == currentProxy.type());
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
            boolean var829DE01A17FC0244427FEC6DEC92507E_270407510 = (!getDoInput());
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
                boolean var68D57BFB543CF9672AB661363C16EEBA_124171035 = (getDoInput());
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
            boolean var94914FE1E1D82177FF47112D9CCAA253_2004393868 = (getDoInput());
            {
                inputStream = new FtpURLInputStream(
                    new BufferedInputStream(dataSocket.getInputStream()), controlSocket);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.623 -0400", hash_original_method = "EC8528293B0BAB1F2E4332771D0B26FB", hash_generated_method = "D360740FE2F21B7ECAD125574DA43D1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getContentType() {
        String result;
        result = guessContentTypeFromName(url.getFile());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String result = guessContentTypeFromName(url.getFile());
        //if (result == null) {
            //return "content/unknown";
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.623 -0400", hash_original_method = "4A774F3C4B70A99D65FCF85E87C829A2", hash_generated_method = "23F166C4AD9EE10B3BFE4D5EAA07BA39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void getFile() throws IOException {
        int reply;
        String file;
        file = url.getFile();
        write("RETR " + file + "\r\n");
        reply = getReply();
        {
            boolean var35CF175F816EA3EA6C255308B8C21654_898041180 = (reply == FTP_NOTFOUND && file.length() > 0 && file.charAt(0) == '/');
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.623 -0400", hash_original_method = "71DB7CA360B0ED6E855C6F8E83FB7FD7", hash_generated_method = "0ED8878BFEAA8B9B31B105AC0E4F8C14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public InputStream getInputStream() throws IOException {
        {
            connect();
        } //End block
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!connected) {
            //connect();
        //}
        //return inputStream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.623 -0400", hash_original_method = "97C79AEDFD54E69CFEDF030BFEEB0808", hash_generated_method = "17E57A3A647397CED21DC7B57F62D2CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Permission getPermission() throws IOException {
        int port;
        port = url.getPort();
        {
            port = FTP_PORT;
        } //End block
        Permission varA791DB3C35CC9BC93EB384342635EF0C_2098297211 = (new SocketPermission(hostName + ":" + port, "connect, resolve"));
        return (Permission)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int port = url.getPort();
        //if (port <= 0) {
            //port = FTP_PORT;
        //}
        //return new SocketPermission(hostName + ":" + port, "connect, resolve");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.623 -0400", hash_original_method = "C24DD353CC035BBFCE8CBDD0A367D441", hash_generated_method = "C20D415EE24220244A9392ACF339DC86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public OutputStream getOutputStream() throws IOException {
        {
            connect();
        } //End block
        OutputStream var43F77FDF10ADB06A50C42E82D92D7A57_1317180246 = (dataSocket.getOutputStream());
        return (OutputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!connected) {
            //connect();
        //}
        //return dataSocket.getOutputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.624 -0400", hash_original_method = "754446702A2F2C82AEEC6CF269039EFC", hash_generated_method = "9DE6A006C9EFB78FD422EA484B10DF6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
            boolean varBA5772E8936B0A50E1A123DBE745E06F_19103136 = (ctrlInput.read() == '-');
            {
                multiline = true;
            } //End block
        } //End collapsed parenthetic
        readLine();
        {
            {
                boolean var9C00639D5751585AF0FD1C756377B44F_1772461521 = (readMultiLine());
            } //End collapsed parenthetic
        } //End block
        try 
        {
            int varBB571124520D3C3346414E12694FE6DA_550781574 = (Integer.parseInt(replyCode));
        } //End block
        catch (NumberFormatException e)
        {
            if (DroidSafeAndroidRuntime.control) throw (IOException)(new IOException("reply code is invalid").initCause(e));
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.624 -0400", hash_original_method = "0C049C745906095629F65911A54698F4", hash_generated_method = "BA8006199C9CE5DEAC5A2DA8CDD9DD59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.625 -0400", hash_original_method = "7AD2E3313E6C9CA8D7D83CEDA11B3440", hash_generated_method = "CB33498A10AA140E1B783918E5D15A80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void port() throws IOException {
        write("PORT "
                + controlSocket.getLocalAddress().getHostAddress().replace('.',
                        ',') + ',' + (dataPort >> 8) + ','
                + (dataPort & 255)
                + "\r\n");
        {
            boolean var89ABBF2CBDBE2FAE4CD06E939EEADC92_1905875703 = (getReply() != FTP_OK);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.625 -0400", hash_original_method = "2E63066111AD195377A7E087D5F90A5E", hash_generated_method = "36C4DE5022C2AB0794329453DC3E2D2A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String readLine() throws IOException {
        StringBuilder sb;
        sb = new StringBuilder();
        int c;
        {
            boolean var0A1A84B711CE9EFCE167E7000C6A6CAC_627028269 = ((c = ctrlInput.read()) != '\n');
            {
                sb.append((char) c);
            } //End block
        } //End collapsed parenthetic
        String var806458D832AB974D230FEE4CBBDBD390_799303990 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //int c;
        //while ((c = ctrlInput.read()) != '\n') {
            //sb.append((char) c);
        //}
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.625 -0400", hash_original_method = "D4D3BFF8CA61872FC19064B66C8564AF", hash_generated_method = "A6EFE9D57A6867D5A200D4BC8F89D21C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean readMultiLine() throws IOException {
        String line;
        line = readLine();
        {
            boolean var3A066064DA765AB7D5D26E22DA8460AD_630620877 = (line.length() < 4);
        } //End collapsed parenthetic
        {
            boolean var0953186FCF36BD1F0150CCCE3D967FBF_1316407799 = (line.substring(0, 3).equals(replyCode)
                && (line.charAt(3) == (char) 32));
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.627 -0400", hash_original_method = "2BA78033DAE740186A6855D293FFDC43", hash_generated_method = "3C6D1095F4A84A640ACDD09D1F6B2860")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.627 -0400", hash_original_method = "D85289DF0962B48F2ED540BF99BE1F4B", hash_generated_method = "0E6F4E6D2EA8A74988CC66AAE5281A9A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setDoInput(boolean newValue) {
        dsTaint.addTaint(newValue);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalAccessError();
        } //End block
        this.doInput = newValue;
        this.doOutput = !newValue;
        // ---------- Original Method ----------
        //if (connected) {
            //throw new IllegalAccessError();
        //}
        //this.doInput = newValue;
        //this.doOutput = !newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.627 -0400", hash_original_method = "E097E58C1D164A4A6A5279DFEE80DF6A", hash_generated_method = "87DA9C073D1980F43F4165818F446922")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setDoOutput(boolean newValue) {
        dsTaint.addTaint(newValue);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalAccessError();
        } //End block
        this.doOutput = newValue;
        this.doInput = !newValue;
        // ---------- Original Method ----------
        //if (connected) {
            //throw new IllegalAccessError();
        //}
        //this.doOutput = newValue;
        //this.doInput = !newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.627 -0400", hash_original_method = "507EB2691A7ADEA1CDA7F73F8F57152E", hash_generated_method = "DCAC3740D316F482E9098F487FD99074")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setType() throws IOException {
        write("TYPE I\r\n");
        {
            boolean var89ABBF2CBDBE2FAE4CD06E939EEADC92_2127439598 = (getReply() != FTP_OK);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.627 -0400", hash_original_method = "3CB2D955BA1082FED6AC9AF45688DFA7", hash_generated_method = "B66C78D2D1555AFC6D789E80DD09FB79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void write(String command) throws IOException {
        dsTaint.addTaint(command);
        ctrlOutput.write(command.getBytes(Charsets.ISO_8859_1));
        // ---------- Original Method ----------
        //ctrlOutput.write(command.getBytes(Charsets.ISO_8859_1));
    }

    
    private static final int FTP_PORT = 21;
    private static final int FTP_DATAOPEN = 125;
    private static final int FTP_OPENDATA = 150;
    private static final int FTP_OK = 200;
    private static final int FTP_USERREADY = 220;
    private static final int FTP_TRANSFEROK = 226;
    private static final int FTP_LOGGEDIN = 230;
    private static final int FTP_FILEOK = 250;
    private static final int FTP_PASWD = 331;
    private static final int FTP_NOTFOUND = 550;
}

