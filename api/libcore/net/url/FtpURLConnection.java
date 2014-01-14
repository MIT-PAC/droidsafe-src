package libcore.net.url;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
import java.nio.charset.Charsets;
import java.security.Permission;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FtpURLConnection extends URLConnection {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.208 -0500", hash_original_field = "E6CB908C9AE2E19F58D042A4F589FE3B", hash_generated_field = "0494778C6EA146AC5E18C1B6D7683910")

    private static final int FTP_PORT = 21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.211 -0500", hash_original_field = "876C802F7DA6C96C6540E26E9E468975", hash_generated_field = "169F27D94B8CAF7F7CBD2DEA74B85B37")

    private static final int FTP_DATAOPEN = 125;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.213 -0500", hash_original_field = "1EF2BB32C5C1D4B58E209F9BA57F541E", hash_generated_field = "8DF56D85BC8DE798D19E138A00A0C1D9")

    private static final int FTP_OPENDATA = 150;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.216 -0500", hash_original_field = "622B8AF00DBB2CD6A825E2D48803C75E", hash_generated_field = "3F451E5D2E344DB8316B56DFF8925C34")

    private static final int FTP_OK = 200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.219 -0500", hash_original_field = "63FA9AF0D26804BACB59B73C2A5C164D", hash_generated_field = "B876C6347750E4EF8FA7D6EE3A1EF0E6")

    private static final int FTP_USERREADY = 220;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.221 -0500", hash_original_field = "C8C68C7A7BC3CDC03DD579151D569760", hash_generated_field = "0D09504F1A64A88FD752115C30EB978B")

    private static final int FTP_TRANSFEROK = 226;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.224 -0500", hash_original_field = "986E421D5256CC8368DF39CB690377FA", hash_generated_field = "20FB2A24F9622AEA2B37FD07EB62ED62")

    private static final int FTP_LOGGEDIN = 230;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.226 -0500", hash_original_field = "CB8210299FD9DA935BC8A69A1305C92B", hash_generated_field = "3DA30E757E31984F8C34CFF5C2EB7C06")

    private static final int FTP_FILEOK = 250;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.229 -0500", hash_original_field = "10E4A3283BF02093A0AD29345E552938", hash_generated_field = "6C860939D42FEBE3FB567493FDF7E408")

    private static final int FTP_PASWD = 331;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.231 -0500", hash_original_field = "339641143CC3F1E8806EE70A8D21FDC9", hash_generated_field = "76A799D42837F6804660F94674F0E518")

    // private static final int FTP_ERROR = 500;

    private static final int FTP_NOTFOUND = 550;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.233 -0500", hash_original_field = "6CF25C888D3E662FD8C4A2A5DD7D4D81", hash_generated_field = "29D7DAD04AED0A3F698C92F271D7CD33")

    private Socket controlSocket;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.236 -0500", hash_original_field = "3B6085D86B05593506AA65904178F58A", hash_generated_field = "7B1D54FCA191D26513E267657B979CEB")

    private Socket dataSocket;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.238 -0500", hash_original_field = "E2FC843CF9DC6A0CE6E263D1113B2E8E", hash_generated_field = "7BE7DB96B1694A7C39FC6FE75B87910A")

    private ServerSocket acceptSocket;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.241 -0500", hash_original_field = "62F8F1707AB4077CAD3E60C6177BB9B8", hash_generated_field = "51832BA3E12265F350C7C5709B55A742")

    private InputStream ctrlInput;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.243 -0500", hash_original_field = "219F81106B069BE15533E4B7BAC5527C", hash_generated_field = "92444C781A1F5D159CDAA9528EFB69D8")

    private InputStream inputStream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.246 -0500", hash_original_field = "CD1AC14DB6ED4378A587B05188DC9C94", hash_generated_field = "12096641C7216452413CF3D401307879")

    private OutputStream ctrlOutput;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.248 -0500", hash_original_field = "34C7F2C178F7A257385ACE86621D9581", hash_generated_field = "C87C583997CC752459B2C205B1AD9852")

    private int dataPort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.250 -0500", hash_original_field = "14AB4F288F25EB23F7A3B6464EFB236B", hash_generated_field = "38135D7350723E148C32F7DB8A1F88C7")

    private String username = "anonymous";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.252 -0500", hash_original_field = "8595ED564FD4157EA17206CCF65F9B77", hash_generated_field = "A05E2C20CC130ACAA51D860E3D5DDA10")

    private String password = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.255 -0500", hash_original_field = "1FAED5329ED39F63889601913F784871", hash_generated_field = "FE3B08AEFFC7B5D68A43118A08CD21CC")

    private String replyCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.257 -0500", hash_original_field = "1B7A53B08CE768344D84B69A12503624", hash_generated_field = "6E65B96A9C64AF2C3CF4B7358A16F214")

    private String hostName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.259 -0500", hash_original_field = "CA775536D3A7F4013C2E9C464BE24463", hash_generated_field = "EE0BB8F1739D62A5A5C8EDF7D478A66B")

    private Proxy proxy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.261 -0500", hash_original_field = "0768F67A4FC923C3253FBE09F2FAF27F", hash_generated_field = "3CCF1C6267C7354D73650ACC80DF3F0D")

    private Proxy currentProxy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.263 -0500", hash_original_field = "1154143EF3A042E6515BD6D5B42C64B6", hash_generated_field = "DDFAECCF21F90F28142F5C866534A5C3")

    private URI uri;

    /**
     * FtpURLConnection constructor comment.
     *
     * @param url
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.266 -0500", hash_original_method = "9C0763DE42B4885FC37474533A9FD11D", hash_generated_method = "DC38485E5DF9DA1AAC5C7DD2B6899CF1")
    
protected FtpURLConnection(URL url) {
        super(url);
        hostName = url.getHost();
        String parse = url.getUserInfo();
        if (parse != null) {
            int split = parse.indexOf(':');
            if (split >= 0) {
                username = parse.substring(0, split);
                password = parse.substring(split + 1);
            } else {
                username = parse;
            }
        }
        uri = null;
        try {
            uri = url.toURI();
        } catch (URISyntaxException e) {
            // do nothing.
        }
    }

    /**
     * FtpURLConnection constructor.
     *
     * @param url
     * @param proxy
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.269 -0500", hash_original_method = "705675501234B79BED4D0186BAC535B7", hash_generated_method = "BF861696A50AF704CD89B57CF0FEF500")
    
protected FtpURLConnection(URL url, Proxy proxy) {
        this(url);
        this.proxy = proxy;
    }

    /**
     * Change the server directory to that specified in the URL
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.273 -0500", hash_original_method = "2BDEB44F3F77270286A692320830ED18", hash_generated_method = "10A3023962BAC8347E6F9AA00501C9E6")
    
private void cd() throws IOException {
        int idx = url.getFile().lastIndexOf('/');

        if (idx > 0) {
            String dir = url.getFile().substring(0, idx);
            write("CWD " + dir + "\r\n");
            int reply = getReply();
            if (reply != FTP_FILEOK && dir.length() > 0 && dir.charAt(0) == '/') {
                write("CWD " + dir.substring(1) + "\r\n");
                reply = getReply();
            }
            if (reply != FTP_FILEOK) {
                throw new IOException("Unable to change directories");
            }
        }
    }

    /**
     * Establishes the connection to the resource specified by this
     * <code>URL</code>
     *
     * @see #connected
     * @see java.io.IOException
     * @see URLStreamHandler
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.276 -0500", hash_original_method = "1FC662ADE026A6EC6E72DFD849EB4C0C", hash_generated_method = "85E1BD66594FB807FDC8148CFC6E4EC3")
    
@Override
    public void connect() throws IOException {
        // Use system-wide ProxySelect to select proxy list,
        // then try to connect via elements in the proxy list.
        List<Proxy> proxyList = null;
        if (proxy != null) {
            proxyList = new ArrayList<Proxy>(1);
            proxyList.add(proxy);
        } else {
            ProxySelector selector = ProxySelector.getDefault();
            if (selector != null) {
                proxyList = selector.select(uri);
            }
        }
        if (proxyList == null) {
            currentProxy = null;
            connectInternal();
        } else {
            ProxySelector selector = ProxySelector.getDefault();
            Iterator<Proxy> iter = proxyList.iterator();
            boolean connectOK = false;
            String failureReason = "";
            while (iter.hasNext() && !connectOK) {
                currentProxy = iter.next();
                try {
                    connectInternal();
                    connectOK = true;
                } catch (IOException ioe) {
                    failureReason = ioe.getLocalizedMessage();
                    // If connect failed, callback "connectFailed"
                    // should be invoked.
                    if (selector != null && Proxy.NO_PROXY != currentProxy) {
                        selector.connectFailed(uri, currentProxy.address(), ioe);
                    }
                }
            }
            if (!connectOK) {
                throw new IOException("Unable to connect to server: " + failureReason);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.278 -0500", hash_original_method = "C4AF18B7DC35179EB8C42F6F6880E61F", hash_generated_method = "9FAE12B4A24D30720580EE48844C7FB0")
    
private void connectInternal() throws IOException {
        int port = url.getPort();
        int connectTimeout = getConnectTimeout();
        if (port <= 0) {
            port = FTP_PORT;
        }
        if (currentProxy == null || Proxy.Type.HTTP == currentProxy.type()) {
            controlSocket = new Socket();
        } else {
            controlSocket = new Socket(currentProxy);
        }
        InetSocketAddress addr = new InetSocketAddress(hostName, port);
        controlSocket.connect(addr, connectTimeout);
        connected = true;
        ctrlOutput = controlSocket.getOutputStream();
        ctrlInput = controlSocket.getInputStream();
        login();
        setType();
        if (!getDoInput()) {
            cd();
        }

        try {
            acceptSocket = new ServerSocket(0);
            dataPort = acceptSocket.getLocalPort();
            /* Cannot set REUSEADDR so we need to send a PORT command */
            port();
            if (connectTimeout == 0) {
                // set timeout rather than zero as before
                connectTimeout = 3000;
            }
            acceptSocket.setSoTimeout(getConnectTimeout());
            if (getDoInput()) {
                getFile();
            } else {
                sendFile();
            }
            dataSocket = acceptSocket.accept();
            dataSocket.setSoTimeout(getReadTimeout());
            acceptSocket.close();
        } catch (InterruptedIOException e) {
            throw new IOException("Could not establish data connection");
        }
        if (getDoInput()) {
            inputStream = new FtpURLInputStream(
                    new BufferedInputStream(dataSocket.getInputStream()), controlSocket);
        }
    }

    /**
     * Returns the content type of the resource. Just takes a guess based on the
     * name.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.281 -0500", hash_original_method = "EC8528293B0BAB1F2E4332771D0B26FB", hash_generated_method = "B8FC79F078AF180D749C0E69A131C9F9")
    
@Override
    public String getContentType() {
        String result = guessContentTypeFromName(url.getFile());
        if (result == null) {
            return "content/unknown";
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.283 -0500", hash_original_method = "4A774F3C4B70A99D65FCF85E87C829A2", hash_generated_method = "091E31ADA898D03FEEBD0D4182D9F130")
    
private void getFile() throws IOException {
        int reply;
        String file = url.getFile();
        write("RETR " + file + "\r\n");
        reply = getReply();
        if (reply == FTP_NOTFOUND && file.length() > 0 && file.charAt(0) == '/') {
            write("RETR " + file.substring(1) + "\r\n");
            reply = getReply();
        }
        if (!(reply == FTP_OPENDATA || reply == FTP_TRANSFEROK)) {
            throw new FileNotFoundException("Unable to retrieve file: " + reply);
        }
    }

    /**
     * Creates a input stream for writing to this URL Connection.
     *
     * @return The input stream to write to
     * @throws IOException
     *             Cannot read from URL or error creating InputStream
     *
     * @see #getContent()
     * @see #getOutputStream()
     * @see java.io.InputStream
     * @see java.io.IOException
     *
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.286 -0500", hash_original_method = "71DB7CA360B0ED6E855C6F8E83FB7FD7", hash_generated_method = "4C37CF1AFC0137215B4753FA4EA259CA")
    
@Override
    public InputStream getInputStream() throws IOException {
        if (!connected) {
            connect();
        }
        return inputStream;
    }

    /**
     * Returns the permission object (in this case, SocketPermission) with the
     * host and the port number as the target name and "resolve, connect" as the
     * action list.
     *
     * @return the permission object required for this connection
     * @throws IOException
     *             thrown when an IO exception occurs during the creation of the
     *             permission object.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.289 -0500", hash_original_method = "97C79AEDFD54E69CFEDF030BFEEB0808", hash_generated_method = "3F44E7668EFDC92B456158FD7ADD8986")
    
@Override
    public Permission getPermission() throws IOException {
        int port = url.getPort();
        if (port <= 0) {
            port = FTP_PORT;
        }
        return new SocketPermission(hostName + ":" + port, "connect, resolve");
    }

    /**
     * Creates a output stream for writing to this URL Connection.
     *
     * @return The output stream to write to
     * @throws IOException
     *             when the OutputStream could not be created
     *
     * @see #getContent()
     * @see #getInputStream()
     * @see java.io.IOException
     *
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.291 -0500", hash_original_method = "C24DD353CC035BBFCE8CBDD0A367D441", hash_generated_method = "D43C3593C7E376E4875AD4DA10BF5DD6")
    
@Override
    public OutputStream getOutputStream() throws IOException {
        if (!connected) {
            connect();
        }
        return dataSocket.getOutputStream();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.294 -0500", hash_original_method = "754446702A2F2C82AEEC6CF269039EFC", hash_generated_method = "81ED77FDD16F56DCC7E1B5D9E042275C")
    
private int getReply() throws IOException {
        byte[] code = new byte[3];
        for (int i = 0; i < code.length; i++) {
            final int tmp = ctrlInput.read();
            if (tmp == -1) {
                throw new EOFException();
            }
            code[i] = (byte) tmp;
        }
        replyCode = new String(code, 0, code.length, Charsets.ISO_8859_1);

        boolean multiline = false;
        if (ctrlInput.read() == '-') {
            multiline = true;
        }
        readLine(); /* Skip the rest of the first line */
        if (multiline) {
            while (readMultiLine()) {/* Read all of a multiline reply */
            }
        }

        try {
            return Integer.parseInt(replyCode);
        } catch (NumberFormatException e) {
            throw (IOException)(new IOException("reply code is invalid").initCause(e));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.297 -0500", hash_original_method = "0C049C745906095629F65911A54698F4", hash_generated_method = "6E01AC6228185AA9D0FAE2C9A6508A83")
    
private void login() throws IOException {
        int reply;
        reply = getReply();
        if (reply == FTP_USERREADY) {
        } else {
            throw new IOException("Unable to connect to server: " + url.getHost());
        }
        write("USER " + username + "\r\n");
        reply = getReply();
        if (reply == FTP_PASWD || reply == FTP_LOGGEDIN) {
        } else {
            throw new IOException("Unable to log in to server (USER): " + url.getHost());
        }
        if (reply == FTP_PASWD) {
            write("PASS " + password + "\r\n");
            reply = getReply();
            if (!(reply == FTP_OK || reply == FTP_USERREADY || reply == FTP_LOGGEDIN)) {
                throw new IOException("Unable to log in to server (PASS): " + url.getHost());
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.299 -0500", hash_original_method = "7AD2E3313E6C9CA8D7D83CEDA11B3440", hash_generated_method = "0C662C569F216B6C78D5E1EF1B15A833")
    
private void port() throws IOException {
        write("PORT "
                + controlSocket.getLocalAddress().getHostAddress().replace('.',
                        ',') + ',' + (dataPort >> 8) + ','
                + (dataPort & 255)
                + "\r\n");
        if (getReply() != FTP_OK) {
            throw new IOException("Unable to configure data port");
        }
    }

    /**
     * Read a line of text and return it for possible parsing
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.301 -0500", hash_original_method = "2E63066111AD195377A7E087D5F90A5E", hash_generated_method = "B1ECC6AC4E64132290709D619D40862C")
    
private String readLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = ctrlInput.read()) != '\n') {
            sb.append((char) c);
        }
        return sb.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.304 -0500", hash_original_method = "D4D3BFF8CA61872FC19064B66C8564AF", hash_generated_method = "D271C02393161A417D34C43BB6F198A0")
    
private boolean readMultiLine() throws IOException {
        String line = readLine();
        if (line.length() < 4) {
            return true;
        }
        if (line.substring(0, 3).equals(replyCode)
                && (line.charAt(3) == (char) 32)) {
            return false;
        }
        return true;
    }

    /**
     * Issue the STOR command to the server with the file as the parameter
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.306 -0500", hash_original_method = "2BA78033DAE740186A6855D293FFDC43", hash_generated_method = "6E79BC3AC105495601645C17C9BDCD4E")
    
private void sendFile() throws IOException {
        int reply;
        write("STOR "
                + url.getFile().substring(url.getFile().lastIndexOf('/') + 1,
                        url.getFile().length()) + "\r\n");
        reply = getReply();
        if (!(reply == FTP_OPENDATA || reply == FTP_OK || reply == FTP_DATAOPEN)) {
            throw new IOException("Unable to store file");
        }
    }

    /**
     * Set the flag if this <code>URLConnection</code> supports input (read).
     * It cannot be set after the connection is made. FtpURLConnections cannot
     * support both input and output
     *
     * @param newValue *
     * @throws IllegalAccessError
     *             when this method attempts to change the flag after connected
     *
     * @see #doInput
     * @see #getDoInput()
     * @see java.lang.IllegalAccessError
     * @see #setDoInput(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.309 -0500", hash_original_method = "D85289DF0962B48F2ED540BF99BE1F4B", hash_generated_method = "0B4114D88BDCD5CE948AB0D91FAB8BB7")
    
@Override
    public void setDoInput(boolean newValue) {
        if (connected) {
            throw new IllegalAccessError();
        }
        this.doInput = newValue;
        this.doOutput = !newValue;
    }

    /**
     * Set the flag if this <code>URLConnection</code> supports output(read).
     * It cannot be set after the connection is made.\ FtpURLConnections cannot
     * support both input and output.
     *
     * @param newValue
     *
     * @throws IllegalAccessError
     *             when this method attempts to change the flag after connected
     *
     * @see #doOutput
     * @see java.lang.IllegalAccessError
     * @see #setDoOutput(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.311 -0500", hash_original_method = "E097E58C1D164A4A6A5279DFEE80DF6A", hash_generated_method = "4F140F3E8DD5B6A4C88F23D79845D711")
    
@Override
    public void setDoOutput(boolean newValue) {
        if (connected) {
            throw new IllegalAccessError();
        }
        this.doOutput = newValue;
        this.doInput = !newValue;
    }

    /**
     * Set the type of the file transfer. Only Image is supported
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.313 -0500", hash_original_method = "507EB2691A7ADEA1CDA7F73F8F57152E", hash_generated_method = "F7E0FDF9595C5A5E4A6A97D2D8DF488D")
    
private void setType() throws IOException {
        write("TYPE I\r\n");
        if (getReply() != FTP_OK) {
            throw new IOException("Unable to set transfer type");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.317 -0500", hash_original_method = "3CB2D955BA1082FED6AC9AF45688DFA7", hash_generated_method = "E13BB63FBBD3E929E88C92BAA2A1E863")
    
private void write(String command) throws IOException {
        ctrlOutput.write(command.getBytes(Charsets.ISO_8859_1));
    }
}

