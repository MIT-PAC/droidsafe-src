package libcore.net.url;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.273 -0400", hash_original_field = "62CE5FD8E6BD8C916853B8B84063B5BC", hash_generated_field = "29D7DAD04AED0A3F698C92F271D7CD33")

    private Socket controlSocket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.273 -0400", hash_original_field = "ABED72C2327EB6296CEDFEAF2006DEB3", hash_generated_field = "7B1D54FCA191D26513E267657B979CEB")

    private Socket dataSocket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.273 -0400", hash_original_field = "E8F8DAC6DABE3040DE150C6CE8506CD3", hash_generated_field = "7BE7DB96B1694A7C39FC6FE75B87910A")

    private ServerSocket acceptSocket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.273 -0400", hash_original_field = "45A2FD2F2740E6E3CE4775827D47DD44", hash_generated_field = "51832BA3E12265F350C7C5709B55A742")

    private InputStream ctrlInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.273 -0400", hash_original_field = "267171E6BFB2A04E5670F3CE06C59060", hash_generated_field = "92444C781A1F5D159CDAA9528EFB69D8")

    private InputStream inputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.273 -0400", hash_original_field = "55A6B3FAFD62DE046073381A8736EFFF", hash_generated_field = "12096641C7216452413CF3D401307879")

    private OutputStream ctrlOutput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.273 -0400", hash_original_field = "90E5A01CC93A2C344A089383AC078569", hash_generated_field = "C87C583997CC752459B2C205B1AD9852")

    private int dataPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.273 -0400", hash_original_field = "56E0FF4EB85672FDFA0C369E23026FCF", hash_generated_field = "38135D7350723E148C32F7DB8A1F88C7")

    private String username = "anonymous";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.273 -0400", hash_original_field = "E4ACDEB0FB5D57AEE860D82AE404EBCA", hash_generated_field = "A05E2C20CC130ACAA51D860E3D5DDA10")

    private String password = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.273 -0400", hash_original_field = "58F579EDF9F22B152776B24B7564DD9B", hash_generated_field = "FE3B08AEFFC7B5D68A43118A08CD21CC")

    private String replyCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.273 -0400", hash_original_field = "018531A6FE3834353217DBF6A6634DCF", hash_generated_field = "6E65B96A9C64AF2C3CF4B7358A16F214")

    private String hostName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.274 -0400", hash_original_field = "431387EB7262E1CFC79B125EB8A67C60", hash_generated_field = "EE0BB8F1739D62A5A5C8EDF7D478A66B")

    private Proxy proxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.274 -0400", hash_original_field = "D7764253E2BBE1A4CF807EA78A298AE2", hash_generated_field = "3CCF1C6267C7354D73650ACC80DF3F0D")

    private Proxy currentProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.274 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "DDFAECCF21F90F28142F5C866534A5C3")

    private URI uri;
    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.275 -0400", hash_original_method = "9C0763DE42B4885FC37474533A9FD11D", hash_generated_method = "5B7478F2D6D39BFC00FE35AA4A872A60")
    protected  FtpURLConnection(URL url) {
        super(url);
        hostName = url.getHost();
        String parse = url.getUserInfo();
        if(parse != null)        
        {
            int split = parse.indexOf(':');
            if(split >= 0)            
            {
                username = parse.substring(0, split);
                password = parse.substring(split + 1);
            } //End block
            else
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
        {
        } //End block
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.276 -0400", hash_original_method = "705675501234B79BED4D0186BAC535B7", hash_generated_method = "B14C2A1E53F4EB1A3F812FD3C5F1795E")
    protected  FtpURLConnection(URL url, Proxy proxy) {
        this(url);
        addTaint(url.getTaint());
        this.proxy = proxy;
        // ---------- Original Method ----------
        //this.proxy = proxy;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.277 -0400", hash_original_method = "2BDEB44F3F77270286A692320830ED18", hash_generated_method = "920CBCFA9E6DA251040AA910507A9F06")
    private void cd() throws IOException {
        int idx = url.getFile().lastIndexOf('/');
        if(idx > 0)        
        {
            String dir = url.getFile().substring(0, idx);
            write("CWD " + dir + "\r\n");
            int reply = getReply();
            if(reply != FTP_FILEOK && dir.length() > 0 && dir.charAt(0) == '/')            
            {
                write("CWD " + dir.substring(1) + "\r\n");
                reply = getReply();
            } //End block
            if(reply != FTP_FILEOK)            
            {
                IOException var2B16AC0ABAC6AC9EF53A24879E6ED4F3_647670511 = new IOException("Unable to change directories");
                var2B16AC0ABAC6AC9EF53A24879E6ED4F3_647670511.addTaint(taint);
                throw var2B16AC0ABAC6AC9EF53A24879E6ED4F3_647670511;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.279 -0400", hash_original_method = "1FC662ADE026A6EC6E72DFD849EB4C0C", hash_generated_method = "A60FCFE40C997DD07C3C0826DB8EBDB6")
    @Override
    public void connect() throws IOException {
        List<Proxy> proxyList = null;
        if(proxy != null)        
        {
            proxyList = new ArrayList<Proxy>(1);
            proxyList.add(proxy);
        } //End block
        else
        {
            ProxySelector selector = ProxySelector.getDefault();
            if(selector != null)            
            {
                proxyList = selector.select(uri);
            } //End block
        } //End block
        if(proxyList == null)        
        {
            currentProxy = null;
            connectInternal();
        } //End block
        else
        {
            ProxySelector selector = ProxySelector.getDefault();
            Iterator<Proxy> iter = proxyList.iterator();
            boolean connectOK = false;
            String failureReason = "";
            while
(iter.hasNext() && !connectOK)            
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
                    if(selector != null && Proxy.NO_PROXY != currentProxy)                    
                    {
                        selector.connectFailed(uri, currentProxy.address(), ioe);
                    } //End block
                } //End block
            } //End block
            if(!connectOK)            
            {
                IOException var6FF1E3D5F7F4A5C4E06A890F61313DD7_687782162 = new IOException("Unable to connect to server: " + failureReason);
                var6FF1E3D5F7F4A5C4E06A890F61313DD7_687782162.addTaint(taint);
                throw var6FF1E3D5F7F4A5C4E06A890F61313DD7_687782162;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.282 -0400", hash_original_method = "C4AF18B7DC35179EB8C42F6F6880E61F", hash_generated_method = "B4BBDACF88916695F5901EFAA0949B24")
    private void connectInternal() throws IOException {
        int port = url.getPort();
        int connectTimeout = getConnectTimeout();
        if(port <= 0)        
        {
            port = FTP_PORT;
        } //End block
        if(currentProxy == null || Proxy.Type.HTTP == currentProxy.type())        
        {
            controlSocket = new Socket();
        } //End block
        else
        {
            controlSocket = new Socket(currentProxy);
        } //End block
        InetSocketAddress addr = new InetSocketAddress(hostName, port);
        controlSocket.connect(addr, connectTimeout);
        connected = true;
        ctrlOutput = controlSocket.getOutputStream();
        ctrlInput = controlSocket.getInputStream();
        login();
        setType();
        if(!getDoInput())        
        {
            cd();
        } //End block
        try 
        {
            acceptSocket = new ServerSocket(0);
            dataPort = acceptSocket.getLocalPort();
            port();
            if(connectTimeout == 0)            
            {
                connectTimeout = 3000;
            } //End block
            acceptSocket.setSoTimeout(getConnectTimeout());
            if(getDoInput())            
            {
                getFile();
            } //End block
            else
            {
                sendFile();
            } //End block
            dataSocket = acceptSocket.accept();
            dataSocket.setSoTimeout(getReadTimeout());
            acceptSocket.close();
        } //End block
        catch (InterruptedIOException e)
        {
            IOException var3585C91A7767F5A85FF949A5E6C1352F_1380951265 = new IOException("Could not establish data connection");
            var3585C91A7767F5A85FF949A5E6C1352F_1380951265.addTaint(taint);
            throw var3585C91A7767F5A85FF949A5E6C1352F_1380951265;
        } //End block
        if(getDoInput())        
        {
            inputStream = new FtpURLInputStream(
                    new BufferedInputStream(dataSocket.getInputStream()), controlSocket);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.282 -0400", hash_original_method = "EC8528293B0BAB1F2E4332771D0B26FB", hash_generated_method = "4CC5E3AD8909616CEB974D12F329F78F")
    @Override
    public String getContentType() {
        String result = guessContentTypeFromName(url.getFile());
        if(result == null)        
        {
String var74BE35FB698BCBEC5E595F7D368A5F61_1369614335 =             "content/unknown";
            var74BE35FB698BCBEC5E595F7D368A5F61_1369614335.addTaint(taint);
            return var74BE35FB698BCBEC5E595F7D368A5F61_1369614335;
        } //End block
String varDC838461EE2FA0CA4C9BBB70A15456B0_1412896122 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1412896122.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1412896122;
        // ---------- Original Method ----------
        //String result = guessContentTypeFromName(url.getFile());
        //if (result == null) {
            //return "content/unknown";
        //}
        //return result;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.283 -0400", hash_original_method = "4A774F3C4B70A99D65FCF85E87C829A2", hash_generated_method = "83C29E51381D85DB471F089362E217F5")
    private void getFile() throws IOException {
        int reply;
        String file = url.getFile();
        write("RETR " + file + "\r\n");
        reply = getReply();
        if(reply == FTP_NOTFOUND && file.length() > 0 && file.charAt(0) == '/')        
        {
            write("RETR " + file.substring(1) + "\r\n");
            reply = getReply();
        } //End block
        if(!(reply == FTP_OPENDATA || reply == FTP_TRANSFEROK))        
        {
            FileNotFoundException var5BC1C4162C10F95FF88804124F8CEA46_568423578 = new FileNotFoundException("Unable to retrieve file: " + reply);
            var5BC1C4162C10F95FF88804124F8CEA46_568423578.addTaint(taint);
            throw var5BC1C4162C10F95FF88804124F8CEA46_568423578;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.284 -0400", hash_original_method = "71DB7CA360B0ED6E855C6F8E83FB7FD7", hash_generated_method = "527D7A5785F20062A66BB3695E2EAADB")
    @Override
    public InputStream getInputStream() throws IOException {
        if(!connected)        
        {
            connect();
        } //End block
InputStream var6D6AA0B6E97941129A02DB042FF8CF68_1442555171 =         inputStream;
        var6D6AA0B6E97941129A02DB042FF8CF68_1442555171.addTaint(taint);
        return var6D6AA0B6E97941129A02DB042FF8CF68_1442555171;
        // ---------- Original Method ----------
        //if (!connected) {
            //connect();
        //}
        //return inputStream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.284 -0400", hash_original_method = "97C79AEDFD54E69CFEDF030BFEEB0808", hash_generated_method = "A581CD17DE4AEED4C8EA88F571086345")
    @Override
    public Permission getPermission() throws IOException {
        int port = url.getPort();
        if(port <= 0)        
        {
            port = FTP_PORT;
        } //End block
Permission varFD00CEEA44FE42A489C211D128AF0313_279458787 =         new SocketPermission(hostName + ":" + port, "connect, resolve");
        varFD00CEEA44FE42A489C211D128AF0313_279458787.addTaint(taint);
        return varFD00CEEA44FE42A489C211D128AF0313_279458787;
        // ---------- Original Method ----------
        //int port = url.getPort();
        //if (port <= 0) {
            //port = FTP_PORT;
        //}
        //return new SocketPermission(hostName + ":" + port, "connect, resolve");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.284 -0400", hash_original_method = "C24DD353CC035BBFCE8CBDD0A367D441", hash_generated_method = "7BBDAB8221C78FE1C51E05BF6433606F")
    @Override
    public OutputStream getOutputStream() throws IOException {
        if(!connected)        
        {
            connect();
        } //End block
OutputStream var0A60C763AC2C950C297DA7D4666CB315_1438290743 =         dataSocket.getOutputStream();
        var0A60C763AC2C950C297DA7D4666CB315_1438290743.addTaint(taint);
        return var0A60C763AC2C950C297DA7D4666CB315_1438290743;
        // ---------- Original Method ----------
        //if (!connected) {
            //connect();
        //}
        //return dataSocket.getOutputStream();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.285 -0400", hash_original_method = "754446702A2F2C82AEEC6CF269039EFC", hash_generated_method = "16D6F93F61FBB81486F352032E2D6824")
    private int getReply() throws IOException {
        byte[] code = new byte[3];
for(int i = 0;i < code.length;i++)
        {
            final int tmp = ctrlInput.read();
            if(tmp == -1)            
            {
                EOFException var0239D63DB748BB20D119EB36D6D1C384_887376435 = new EOFException();
                var0239D63DB748BB20D119EB36D6D1C384_887376435.addTaint(taint);
                throw var0239D63DB748BB20D119EB36D6D1C384_887376435;
            } //End block
            code[i] = (byte) tmp;
        } //End block
        replyCode = new String(code, 0, code.length, Charsets.ISO_8859_1);
        boolean multiline = false;
        if(ctrlInput.read() == '-')        
        {
            multiline = true;
        } //End block
        readLine();
        if(multiline)        
        {
            while
(readMultiLine())            
            {
            } //End block
        } //End block
        try 
        {
            int varDCD90A1B3EB71A94D6F6EAFB426EFA3D_1480792695 = (Integer.parseInt(replyCode));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2097508420 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2097508420;
        } //End block
        catch (NumberFormatException e)
        {
            IOException varD1C4CFA7C2E4ECCD4958BF07FA7AE1A8_947386069 = (IOException)(new IOException("reply code is invalid").initCause(e));
            varD1C4CFA7C2E4ECCD4958BF07FA7AE1A8_947386069.addTaint(taint);
            throw varD1C4CFA7C2E4ECCD4958BF07FA7AE1A8_947386069;
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.286 -0400", hash_original_method = "0C049C745906095629F65911A54698F4", hash_generated_method = "4AE54DD803AA68FE92FD00BC2B399AF0")
    private void login() throws IOException {
        int reply;
        reply = getReply();
        if(reply == FTP_USERREADY)        
        {
        } //End block
        else
        {
            IOException var03DF6E7FC2C301784478F401927F6843_338023335 = new IOException("Unable to connect to server: " + url.getHost());
            var03DF6E7FC2C301784478F401927F6843_338023335.addTaint(taint);
            throw var03DF6E7FC2C301784478F401927F6843_338023335;
        } //End block
        write("USER " + username + "\r\n");
        reply = getReply();
        if(reply == FTP_PASWD || reply == FTP_LOGGEDIN)        
        {
        } //End block
        else
        {
            IOException var3A61407F2FEFCFD47C505A8BB15C4033_146545415 = new IOException("Unable to log in to server (USER): " + url.getHost());
            var3A61407F2FEFCFD47C505A8BB15C4033_146545415.addTaint(taint);
            throw var3A61407F2FEFCFD47C505A8BB15C4033_146545415;
        } //End block
        if(reply == FTP_PASWD)        
        {
            write("PASS " + password + "\r\n");
            reply = getReply();
            if(!(reply == FTP_OK || reply == FTP_USERREADY || reply == FTP_LOGGEDIN))            
            {
                IOException varFADFF05B927A409609217B1CB6F2B71A_968440161 = new IOException("Unable to log in to server (PASS): " + url.getHost());
                varFADFF05B927A409609217B1CB6F2B71A_968440161.addTaint(taint);
                throw varFADFF05B927A409609217B1CB6F2B71A_968440161;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.286 -0400", hash_original_method = "7AD2E3313E6C9CA8D7D83CEDA11B3440", hash_generated_method = "1012690898C2B28CB6D8FBDFADE6C132")
    private void port() throws IOException {
        write("PORT "
                + controlSocket.getLocalAddress().getHostAddress().replace('.',
                        ',') + ',' + (dataPort >> 8) + ','
                + (dataPort & 255)
                + "\r\n");
        if(getReply() != FTP_OK)        
        {
            IOException varB6807CA2CD675B71037F439C7D45962C_1566955203 = new IOException("Unable to configure data port");
            varB6807CA2CD675B71037F439C7D45962C_1566955203.addTaint(taint);
            throw varB6807CA2CD675B71037F439C7D45962C_1566955203;
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.287 -0400", hash_original_method = "2E63066111AD195377A7E087D5F90A5E", hash_generated_method = "B7CDE21C453A17F1C0DDC4B25D3D8899")
    private String readLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while
((c = ctrlInput.read()) != '\n')        
        {
            sb.append((char) c);
        } //End block
String var2460B846747F8B22185AD8BE722266A5_1873113358 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_1873113358.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_1873113358;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //int c;
        //while ((c = ctrlInput.read()) != '\n') {
            //sb.append((char) c);
        //}
        //return sb.toString();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.287 -0400", hash_original_method = "D4D3BFF8CA61872FC19064B66C8564AF", hash_generated_method = "0C9F02D970B3051B5FA80DAB9CD53953")
    private boolean readMultiLine() throws IOException {
        String line = readLine();
        if(line.length() < 4)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_123212126 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_74621257 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_74621257;
        } //End block
        if(line.substring(0, 3).equals(replyCode)
                && (line.charAt(3) == (char) 32))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1837314202 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_602226753 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_602226753;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_121489187 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_190815102 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_190815102;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.288 -0400", hash_original_method = "2BA78033DAE740186A6855D293FFDC43", hash_generated_method = "B02222632CEF7EED4ADA13B79B98CDD4")
    private void sendFile() throws IOException {
        int reply;
        write("STOR "
                + url.getFile().substring(url.getFile().lastIndexOf('/') + 1,
                        url.getFile().length()) + "\r\n");
        reply = getReply();
        if(!(reply == FTP_OPENDATA || reply == FTP_OK || reply == FTP_DATAOPEN))        
        {
            IOException var894DFDA9C92BEB23CD395D049428B72E_313685475 = new IOException("Unable to store file");
            var894DFDA9C92BEB23CD395D049428B72E_313685475.addTaint(taint);
            throw var894DFDA9C92BEB23CD395D049428B72E_313685475;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.301 -0400", hash_original_method = "D85289DF0962B48F2ED540BF99BE1F4B", hash_generated_method = "93A88E4A79F10052992DAFE85AD8B99C")
    @Override
    public void setDoInput(boolean newValue) {
        addTaint(newValue);
        if(connected)        
        {
            IllegalAccessError var5521B3494B44914EF7ACFE5EEBCF057A_1803038949 = new IllegalAccessError();
            var5521B3494B44914EF7ACFE5EEBCF057A_1803038949.addTaint(taint);
            throw var5521B3494B44914EF7ACFE5EEBCF057A_1803038949;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.301 -0400", hash_original_method = "E097E58C1D164A4A6A5279DFEE80DF6A", hash_generated_method = "260795408DCB1E58F8E0639E94DEE2AA")
    @Override
    public void setDoOutput(boolean newValue) {
        addTaint(newValue);
        if(connected)        
        {
            IllegalAccessError var5521B3494B44914EF7ACFE5EEBCF057A_650659639 = new IllegalAccessError();
            var5521B3494B44914EF7ACFE5EEBCF057A_650659639.addTaint(taint);
            throw var5521B3494B44914EF7ACFE5EEBCF057A_650659639;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.302 -0400", hash_original_method = "507EB2691A7ADEA1CDA7F73F8F57152E", hash_generated_method = "4FF260D3D96A4E0E05E636BD7451E0DA")
    private void setType() throws IOException {
        write("TYPE I\r\n");
        if(getReply() != FTP_OK)        
        {
            IOException varD7E718C01C1753C890AA0684E190142D_21684550 = new IOException("Unable to set transfer type");
            varD7E718C01C1753C890AA0684E190142D_21684550.addTaint(taint);
            throw varD7E718C01C1753C890AA0684E190142D_21684550;
        } //End block
        // ---------- Original Method ----------
        //write("TYPE I\r\n");
        //if (getReply() != FTP_OK) {
            //throw new IOException("Unable to set transfer type");
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.302 -0400", hash_original_method = "3CB2D955BA1082FED6AC9AF45688DFA7", hash_generated_method = "5C575998C03FBA9A83A47B68B19952F2")
    private void write(String command) throws IOException {
        addTaint(command.getTaint());
        ctrlOutput.write(command.getBytes(Charsets.ISO_8859_1));
        // ---------- Original Method ----------
        //ctrlOutput.write(command.getBytes(Charsets.ISO_8859_1));
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.302 -0400", hash_original_field = "40907AD68D2326CC5B43306FB100F610", hash_generated_field = "0494778C6EA146AC5E18C1B6D7683910")

    private static final int FTP_PORT = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.302 -0400", hash_original_field = "23B41E27160246E1E9727D4CA0C73B88", hash_generated_field = "169F27D94B8CAF7F7CBD2DEA74B85B37")

    private static final int FTP_DATAOPEN = 125;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.302 -0400", hash_original_field = "190869485A3022695759F8349A66BEAE", hash_generated_field = "8DF56D85BC8DE798D19E138A00A0C1D9")

    private static final int FTP_OPENDATA = 150;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.302 -0400", hash_original_field = "36C04BA3231BAA35A2B37E4587F340A1", hash_generated_field = "3F451E5D2E344DB8316B56DFF8925C34")

    private static final int FTP_OK = 200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.302 -0400", hash_original_field = "4894B10ABCD2BDE1F843362BE3972401", hash_generated_field = "B876C6347750E4EF8FA7D6EE3A1EF0E6")

    private static final int FTP_USERREADY = 220;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.302 -0400", hash_original_field = "80226B533A52439A8B67E8F2DFF297A6", hash_generated_field = "0D09504F1A64A88FD752115C30EB978B")

    private static final int FTP_TRANSFEROK = 226;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.302 -0400", hash_original_field = "777E76EBEBF483304080CCFBDF3B85ED", hash_generated_field = "20FB2A24F9622AEA2B37FD07EB62ED62")

    private static final int FTP_LOGGEDIN = 230;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.302 -0400", hash_original_field = "545A1E6BE4254F4B9F1C304543691B8D", hash_generated_field = "3DA30E757E31984F8C34CFF5C2EB7C06")

    private static final int FTP_FILEOK = 250;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.302 -0400", hash_original_field = "44D032478A43739ABF9EDD61592A1F43", hash_generated_field = "6C860939D42FEBE3FB567493FDF7E408")

    private static final int FTP_PASWD = 331;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.302 -0400", hash_original_field = "14A4ED5ECC64E1A63CE6CF76DAE98B2C", hash_generated_field = "D1960BFD9B2C52C3813E7EDA523AEEC4")

    private static final int FTP_NOTFOUND = 550;
}

