package android.net.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.os.SystemClock;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ListIterator;
import java.util.LinkedList;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.BasicHttpContext;

abstract class Connection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.737 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.737 -0400", hash_original_field = "225C165DF2343A8E0EA2245104D03B86", hash_generated_field = "89DB88E2A4BA8B129AFC783A277DC972")

    protected AndroidHttpClientConnection mHttpClientConnection = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.737 -0400", hash_original_field = "1C964C5062DB9515A402EF4BCB049EB0", hash_generated_field = "C93393B13E8B23850F2A2AA31CFA340F")

    protected SslCertificate mCertificate = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.737 -0400", hash_original_field = "AE3E518F8FFDE1F8C00699B4C58E95B5", hash_generated_field = "BB62408D38B8CFFE64423F7A37FB51DF")

    HttpHost mHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.737 -0400", hash_original_field = "97A1B0DF7A8AAEB03A6EC2B31E06308F", hash_generated_field = "7CE1ADB90870C4000E5A95CCB811B5D9")

    private boolean mCanPersist;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.737 -0400", hash_original_field = "FD03AC2C622114C9081EDA77D8B757D2", hash_generated_field = "5A9EBA484956FCBE0111BA8174DA817C")

    private HttpContext mHttpContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.737 -0400", hash_original_field = "41B678864A24EDAE5190D8888B82E287", hash_generated_field = "47B94217572DFA83D4A2A33DD250B38D")

    private int mActive = STATE_NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.737 -0400", hash_original_field = "2E54C55B0E19AE6A5D3D5CB288053E14", hash_generated_field = "537B204D0FD240DD08711E1D73085387")

    RequestFeeder mRequestFeeder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.737 -0400", hash_original_field = "D8259507CE3049C660B2FFFC8043DC4C", hash_generated_field = "29FB82D1D2E75901C37B9EDD1B81BDDE")

    private byte[] mBuf;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.738 -0400", hash_original_method = "5BAB9F531750E6A689F8FF5D2A254CB9", hash_generated_method = "8638DF5D935AC67BE8ACABC50432A630")
    protected  Connection(Context context, HttpHost host,
                         RequestFeeder requestFeeder) {
        mContext = context;
        mHost = host;
        mRequestFeeder = requestFeeder;
        mCanPersist = false;
        mHttpContext = new BasicHttpContext(null);
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.738 -0400", hash_original_method = "9B5E41A5FF20333698838F3F6DF6BCD6", hash_generated_method = "89D3868FA6362532F4470FABC20B30C2")
     HttpHost getHost() {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_641425320 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_641425320 = mHost;
        varB4EAC82CA7396A68D541C85D26508E83_641425320.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_641425320;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    static Connection getConnection(
            Context context, HttpHost host, HttpHost proxy,
            RequestFeeder requestFeeder) {
        if (host.getSchemeName().equals("http")) {
            return new HttpConnection(context, host, requestFeeder);
        }
        return new HttpsConnection(context, host, proxy, requestFeeder);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.739 -0400", hash_original_method = "7F448377575EC929DDEDD2BF1EB435C4", hash_generated_method = "FFD8F74B71756455FA9B9A1BCF38AADD")
     SslCertificate getCertificate() {
        SslCertificate varB4EAC82CA7396A68D541C85D26508E83_83625497 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_83625497 = mCertificate;
        varB4EAC82CA7396A68D541C85D26508E83_83625497.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_83625497;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.739 -0400", hash_original_method = "E0AFA64670C1DBA320AD7B4F64C9D703", hash_generated_method = "BB343129EA06027067E7E95173C78636")
     void cancel() {
        mActive = STATE_CANCEL_REQUESTED;
        closeConnection();
        HttpLog.v(
            "Connection.cancel(): connection closed " + mHost);
        
        
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.741 -0400", hash_original_method = "F5EEA514D7040591FC6D3FB9B4E157ED", hash_generated_method = "3EFAC097BA7179F9B509824C1229EE9E")
     void processRequests(Request firstRequest) {
        Request req = null;
        boolean empty;
        int error = EventHandler.OK;
        Exception exception = null;
        LinkedList<Request> pipe = new LinkedList<Request>();
        int minPipe = MIN_PIPE;
        int maxPipe = MAX_PIPE;
        int state = SEND;
        {
            HttpLog.v(
                    states[state] + " pipe " + pipe.size());
            {
                try 
                {
                    Thread.sleep(100);
                } 
                catch (InterruptedException x)
                { }
                mActive = STATE_NORMAL;
            } 
            
            {
                {
                    boolean varF6446B26928F500236FEA2DA96BA2177_300691850 = (pipe.size() == maxPipe);
                    {
                        state = READ;
                    } 
                } 
                {
                    req = mRequestFeeder.getRequest(mHost);
                } 
                {
                    req = firstRequest;
                    firstRequest = null;
                } 
                {
                    state = DRAIN;
                } 
                req.setConnection(this);
                {
                    HttpLog.v(
                                "processRequests(): skipping cancelled request "
                                + req);
                    req.complete();
                } 
                {
                    boolean var363D9D2F0E89C11F47781F945C0D91C8_713616688 = (mHttpClientConnection == null ||
                        !mHttpClientConnection.isOpen());
                    {
                        {
                            boolean var3B9848892C343394B2F8D5F96B18C3C5_1668950765 = (!openHttpConnection(req));
                            {
                                state = DONE;
                            } 
                        } 
                    } 
                } 
                req.mEventHandler.certificate(mCertificate);
                try 
                {
                    req.sendRequest(mHttpClientConnection);
                } 
                catch (HttpException e)
                {
                    exception = e;
                    error = EventHandler.ERROR;
                } 
                catch (IOException e)
                {
                    exception = e;
                    error = EventHandler.ERROR_IO;
                } 
                catch (IllegalStateException e)
                {
                    exception = e;
                    error = EventHandler.ERROR_IO;
                } 
                {
                    {
                        boolean var3550BE76A96DD86D49D0E4DF58B240F3_1033649060 = (httpFailure(req, error, exception) &&
                            !req.mCancelled);
                        {
                            pipe.addLast(req);
                        } 
                    } 
                    exception = null;
                    state = clearPipe(pipe) ? DONE : SEND;
                    minPipe = maxPipe = 1;
                } 
                pipe.addLast(req);
                state = READ;
            } 
            
            
            {
                empty = !mRequestFeeder.haveRequest(mHost);
                int pipeSize = pipe.size();
                {
                    state = SEND;
                } 
                {
                    state = empty ? DONE : SEND;
                } 
                req = (Request)pipe.removeFirst();
                HttpLog.v(
                            "processRequests() reading " + req);
                try 
                {
                    req.readResponse(mHttpClientConnection);
                } 
                catch (ParseException e)
                {
                    exception = e;
                    error = EventHandler.ERROR_IO;
                } 
                catch (IOException e)
                {
                    exception = e;
                    error = EventHandler.ERROR_IO;
                } 
                catch (IllegalStateException e)
                {
                    exception = e;
                    error = EventHandler.ERROR_IO;
                } 
                {
                    {
                        boolean var3550BE76A96DD86D49D0E4DF58B240F3_1663299740 = (httpFailure(req, error, exception) &&
                            !req.mCancelled);
                        {
                            req.reset();
                            pipe.addFirst(req);
                        } 
                    } 
                    exception = null;
                    mCanPersist = false;
                } 
                {
                    HttpLog.v(
                                "processRequests(): no persist, closing " +
                                mHost);
                    closeConnection();
                    mHttpContext.removeAttribute(HTTP_CONNECTION);
                    clearPipe(pipe);
                    minPipe = maxPipe = 1;
                    state = SEND;
                } 
            } 
            
        } 
        addTaint(firstRequest.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.742 -0400", hash_original_method = "3DB5627BDFAF8C06A0CDDAD2458FF1F0", hash_generated_method = "723D4325BE86673098C889DB598546CA")
    private boolean clearPipe(LinkedList<Request> pipe) {
        boolean empty = true;
        HttpLog.v(
                "Connection.clearPipe(): clearing pipe " + pipe.size());
        {
            Request tReq;
            {
                boolean var973B31D5A803FED5D96DAF9AB4327C3D_2014732843 = (!pipe.isEmpty());
                {
                    tReq = (Request)pipe.removeLast();
                    HttpLog.v(
                        "clearPipe() adding back " + mHost + " " + tReq);
                    mRequestFeeder.requeueRequest(tReq);
                    empty = false;
                } 
            } 
            empty = !mRequestFeeder.haveRequest(mHost);
        } 
        addTaint(pipe.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_574185422 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_574185422;
        
        
        
                
        
            
            
                
                
                        
                
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.743 -0400", hash_original_method = "65B4C91B53E686F7A0B5A125142FC3C0", hash_generated_method = "FFA1F6B83C4E1CF4EFED0F8E874797E9")
    private boolean openHttpConnection(Request req) {
        long now = SystemClock.uptimeMillis();
        int error = EventHandler.OK;
        Exception exception = null;
        try 
        {
            mCertificate = null;
            mHttpClientConnection = openConnection(req);
            {
                mHttpClientConnection.setSocketTimeout(SOCKET_TIMEOUT);
                mHttpContext.setAttribute(HTTP_CONNECTION,
                                          mHttpClientConnection);
            } 
            {
                req.mFailCount = RETRY_REQUEST_LIMIT;
            } 
        } 
        catch (UnknownHostException e)
        {
            HttpLog.v("Failed to open connection");
            error = EventHandler.ERROR_LOOKUP;
            exception = e;
        } 
        catch (IllegalArgumentException e)
        {
            HttpLog.v("Illegal argument exception");
            error = EventHandler.ERROR_CONNECT;
            req.mFailCount = RETRY_REQUEST_LIMIT;
            exception = e;
        } 
        catch (SSLConnectionClosedByUserException e)
        {
            req.mFailCount = RETRY_REQUEST_LIMIT;
        } 
        catch (SSLHandshakeException e)
        {
            req.mFailCount = RETRY_REQUEST_LIMIT;
            HttpLog.v(
                    "SSL exception performing handshake");
            error = EventHandler.ERROR_FAILED_SSL_HANDSHAKE;
            exception = e;
        } 
        catch (IOException e)
        {
            error = EventHandler.ERROR_CONNECT;
            exception = e;
        } 
        {
            long now2 = SystemClock.uptimeMillis();
            HttpLog.v("Connection.openHttpConnection() " +
                      (now2 - now) + " " + mHost);
        } 
        {
            {
                mRequestFeeder.requeueRequest(req);
            } 
            {
                httpFailure(req, error, exception);
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1482889439 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1482889439;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.743 -0400", hash_original_method = "6EC91A36E40ABAF43D521C6CD9682246", hash_generated_method = "59728BB8078BB6D886602CF732308467")
    private boolean httpFailure(Request req, int errorId, Exception e) {
        boolean ret = true;
        HttpLog.v(
                "httpFailure() ******* " + e + " count " + req.mFailCount +
                " " + mHost + " " + req.getUri());
        {
            ret = false;
            String error;
            {
                error = ErrorStrings.getString(errorId, mContext);
            } 
            {
                Throwable cause = e.getCause();
                error = cause != null ? cause.toString() : e.getMessage();
            } 
            req.mEventHandler.error(errorId, error);
            req.complete();
        } 
        closeConnection();
        mHttpContext.removeAttribute(HTTP_CONNECTION);
        addTaint(req.getTaint());
        addTaint(errorId);
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1418759221 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1418759221;
        
        
        
                
                
        
            
            
            
                
            
                
                
            
            
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.744 -0400", hash_original_method = "510B2315D285A4B8D2701F50BEED692F", hash_generated_method = "6D38A5BAF759D5C74E4EE325143BEC49")
     HttpContext getHttpContext() {
        HttpContext varB4EAC82CA7396A68D541C85D26508E83_2137880008 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2137880008 = mHttpContext;
        varB4EAC82CA7396A68D541C85D26508E83_2137880008.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2137880008;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.744 -0400", hash_original_method = "CD663685F32FAE99B1C37BBE4FC5CEFB", hash_generated_method = "B098EA10ABE7E7B080F662E8375BE8E5")
    private boolean keepAlive(HttpEntity entity,
            ProtocolVersion ver, int connType, final HttpContext context) {
        org.apache.http.HttpConnection conn = (org.apache.http.HttpConnection)
            context.getAttribute(ExecutionContext.HTTP_CONNECTION);
        {
            boolean var3F09B4DA4021A00B0E0E85A7A98C2EF2_1121983867 = (conn != null && !conn.isOpen());
        } 
        {
            {
                boolean varD4D0AAD58097CCD39F1ACA1D9158C81F_1819597689 = (entity.getContentLength() < 0);
                {
                    {
                        boolean varC22E6EAF1973D4EF188692D613BFFF4F_1518402378 = (!entity.isChunked() || ver.lessEquals(HttpVersion.HTTP_1_0));
                    } 
                } 
            } 
        } 
        boolean varE7C0AF165CB1162AB0C6BED102DEE29E_265577350 = (!ver.lessEquals(HttpVersion.HTTP_1_0));
        addTaint(entity.getTaint());
        addTaint(ver.getTaint());
        addTaint(connType);
        addTaint(context.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_977421057 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_977421057;
        
        
            
        
            
        
            
                
                    
                
            
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.745 -0400", hash_original_method = "30E271C8B4BA77F90D768E6DAD0368A8", hash_generated_method = "4D4E5718D6623C41E8E53EA293E55F7E")
     void setCanPersist(HttpEntity entity, ProtocolVersion ver, int connType) {
        mCanPersist = keepAlive(entity, ver, connType, mHttpContext);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.745 -0400", hash_original_method = "948404D3184D15107ABD2526F5DFBFE0", hash_generated_method = "C987B1689B3761BB7765A463FADF77BA")
     void setCanPersist(boolean canPersist) {
        mCanPersist = canPersist;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.746 -0400", hash_original_method = "5B21A605E2B59BE630988FE4FC055560", hash_generated_method = "A93E750E0583FEA252A61B89B916E61E")
     boolean getCanPersist() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2008601195 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2008601195;
        
        
    }

    
    abstract String getScheme();

    
    abstract void closeConnection();

    
    abstract AndroidHttpClientConnection openConnection(Request req) throws IOException;

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.747 -0400", hash_original_method = "AD69CA65EB98EE93EFEEFD66CD2BA041", hash_generated_method = "79E3055D5F583CAE1C62962CBAAB568F")
    public synchronized String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_362946216 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_362946216 = mHost.toString();
        varB4EAC82CA7396A68D541C85D26508E83_362946216.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_362946216;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.747 -0400", hash_original_method = "ED2ED37A31E0A6859AF61C011936FDA1", hash_generated_method = "A8ACDE5C7D8671C433CA31846CA9D4E3")
     byte[] getBuf() {
        mBuf = new byte[8192];
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1624127781 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1624127781;
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.747 -0400", hash_original_field = "DC786437DAF39BC0353D2B9BA7D3C9E6", hash_generated_field = "FD49C956DFAA52CB9AA44D852EDE7E88")

    static final int SOCKET_TIMEOUT = 60000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.747 -0400", hash_original_field = "6BF33435F120264EF42E338D17C72D0B", hash_generated_field = "1685A8AED473B8DB89C64DD70F6B2006")

    private static final int SEND = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.747 -0400", hash_original_field = "E175EC5A2FD87D2B13E08BAB1C961780", hash_generated_field = "22E96ACD2E5356C19B3A4C8936496A0F")

    private static final int READ = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.747 -0400", hash_original_field = "0CB9FCC085D3EC2FCAF62AD99BEB9AC2", hash_generated_field = "5BAF0CAFDC584F3B1861B58546EDCB7E")

    private static final int DRAIN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.747 -0400", hash_original_field = "709E3C1FBB813E9051103B038B68E183", hash_generated_field = "A0EA7B5A8C185F5C7D5C82DFB7B53A9C")

    private static final int DONE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.747 -0400", hash_original_field = "4890D714BFC35B9367C8CAB211D44263", hash_generated_field = "751D7AEFD8D9F803728738C72D6E6C21")

    private static final String[] states = {"SEND",  "READ", "DRAIN", "DONE"};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.747 -0400", hash_original_field = "56C17BEC69383339D712A34A376816DF", hash_generated_field = "C20BDB569BF441D514B312064089B80D")

    private static int STATE_NORMAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.747 -0400", hash_original_field = "6DD800274CF5304024380655EE085BEF", hash_generated_field = "4B33F7E13CDE76A475EA8482B52829FC")

    private static int STATE_CANCEL_REQUESTED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.747 -0400", hash_original_field = "9CF6E88AA50B22FBAA17EBC283AD1064", hash_generated_field = "BB46C45CF828AF753F842CF0245407C9")

    private final static int RETRY_REQUEST_LIMIT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.747 -0400", hash_original_field = "8AF7C98381A3955FFE32D244C79CD1BB", hash_generated_field = "8470675918FC5BC85BDE71A8C20A9EED")

    private static final int MIN_PIPE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.747 -0400", hash_original_field = "FBAD8F702AAE93F7E71144CEB6214FFD", hash_generated_field = "5FBC745DF7014C47FBE8E03B5689C9AC")

    private static final int MAX_PIPE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.747 -0400", hash_original_field = "315AC7FB13FDA9DD2AF31A202845A2F1", hash_generated_field = "A05D44F0812379A6B6F7EFAA2F4D23B1")

    private static final String HTTP_CONNECTION = "http.connection";
}

