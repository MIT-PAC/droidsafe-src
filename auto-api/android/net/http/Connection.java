package android.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.004 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.004 -0400", hash_original_field = "225C165DF2343A8E0EA2245104D03B86", hash_generated_field = "89DB88E2A4BA8B129AFC783A277DC972")

    protected AndroidHttpClientConnection mHttpClientConnection = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.004 -0400", hash_original_field = "1C964C5062DB9515A402EF4BCB049EB0", hash_generated_field = "C93393B13E8B23850F2A2AA31CFA340F")

    protected SslCertificate mCertificate = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.004 -0400", hash_original_field = "AE3E518F8FFDE1F8C00699B4C58E95B5", hash_generated_field = "BB62408D38B8CFFE64423F7A37FB51DF")

    HttpHost mHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.004 -0400", hash_original_field = "97A1B0DF7A8AAEB03A6EC2B31E06308F", hash_generated_field = "7CE1ADB90870C4000E5A95CCB811B5D9")

    private boolean mCanPersist;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.005 -0400", hash_original_field = "FD03AC2C622114C9081EDA77D8B757D2", hash_generated_field = "5A9EBA484956FCBE0111BA8174DA817C")

    private HttpContext mHttpContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.005 -0400", hash_original_field = "41B678864A24EDAE5190D8888B82E287", hash_generated_field = "47B94217572DFA83D4A2A33DD250B38D")

    private int mActive = STATE_NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.005 -0400", hash_original_field = "2E54C55B0E19AE6A5D3D5CB288053E14", hash_generated_field = "537B204D0FD240DD08711E1D73085387")

    RequestFeeder mRequestFeeder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.005 -0400", hash_original_field = "D8259507CE3049C660B2FFFC8043DC4C", hash_generated_field = "29FB82D1D2E75901C37B9EDD1B81BDDE")

    private byte[] mBuf;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.017 -0400", hash_original_method = "5BAB9F531750E6A689F8FF5D2A254CB9", hash_generated_method = "8638DF5D935AC67BE8ACABC50432A630")
    protected  Connection(Context context, HttpHost host,
                         RequestFeeder requestFeeder) {
        mContext = context;
        mHost = host;
        mRequestFeeder = requestFeeder;
        mCanPersist = false;
        mHttpContext = new BasicHttpContext(null);
        // ---------- Original Method ----------
        //mContext = context;
        //mHost = host;
        //mRequestFeeder = requestFeeder;
        //mCanPersist = false;
        //mHttpContext = new BasicHttpContext(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.020 -0400", hash_original_method = "9B5E41A5FF20333698838F3F6DF6BCD6", hash_generated_method = "163991A793FBB6F032CC1B4A88EBD3E5")
     HttpHost getHost() {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_2029443132 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2029443132 = mHost;
        varB4EAC82CA7396A68D541C85D26508E83_2029443132.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2029443132;
        // ---------- Original Method ----------
        //return mHost;
    }

    
        static Connection getConnection(
            Context context, HttpHost host, HttpHost proxy,
            RequestFeeder requestFeeder) {
        if (host.getSchemeName().equals("http")) {
            return new HttpConnection(context, host, requestFeeder);
        }
        return new HttpsConnection(context, host, proxy, requestFeeder);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.031 -0400", hash_original_method = "7F448377575EC929DDEDD2BF1EB435C4", hash_generated_method = "4D653911C6B9B67D825D57A2F498F344")
     SslCertificate getCertificate() {
        SslCertificate varB4EAC82CA7396A68D541C85D26508E83_968827838 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_968827838 = mCertificate;
        varB4EAC82CA7396A68D541C85D26508E83_968827838.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_968827838;
        // ---------- Original Method ----------
        //return mCertificate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.032 -0400", hash_original_method = "E0AFA64670C1DBA320AD7B4F64C9D703", hash_generated_method = "BB343129EA06027067E7E95173C78636")
     void cancel() {
        mActive = STATE_CANCEL_REQUESTED;
        closeConnection();
        HttpLog.v(
            "Connection.cancel(): connection closed " + mHost);
        // ---------- Original Method ----------
        //mActive = STATE_CANCEL_REQUESTED;
        //closeConnection();
        //if (HttpLog.LOGV) HttpLog.v(
            //"Connection.cancel(): connection closed " + mHost);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.078 -0400", hash_original_method = "F5EEA514D7040591FC6D3FB9B4E157ED", hash_generated_method = "406C021B5E891E321B866D8901586A19")
     void processRequests(Request firstRequest) {
        Request req;
        req = null;
        boolean empty;
        int error;
        error = EventHandler.OK;
        Exception exception;
        exception = null;
        LinkedList<Request> pipe;
        pipe = new LinkedList<Request>();
        int minPipe, maxPipe;
        minPipe = MIN_PIPE;
        maxPipe = MAX_PIPE;
        int state;
        state = SEND;
        {
            HttpLog.v(
                    states[state] + " pipe " + pipe.size());
            {
                try 
                {
                    Thread.sleep(100);
                } //End block
                catch (InterruptedException x)
                { }
                mActive = STATE_NORMAL;
            } //End block
            //Begin case SEND 
            {
                {
                    boolean varF6446B26928F500236FEA2DA96BA2177_887411644 = (pipe.size() == maxPipe);
                    {
                        state = READ;
                    } //End block
                } //End collapsed parenthetic
                {
                    req = mRequestFeeder.getRequest(mHost);
                } //End block
                {
                    req = firstRequest;
                    firstRequest = null;
                } //End block
                {
                    state = DRAIN;
                } //End block
                req.setConnection(this);
                {
                    HttpLog.v(
                                "processRequests(): skipping cancelled request "
                                + req);
                    req.complete();
                } //End block
                {
                    boolean var363D9D2F0E89C11F47781F945C0D91C8_1391719908 = (mHttpClientConnection == null ||
                        !mHttpClientConnection.isOpen());
                    {
                        {
                            boolean var3B9848892C343394B2F8D5F96B18C3C5_2077586194 = (!openHttpConnection(req));
                            {
                                state = DONE;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                req.mEventHandler.certificate(mCertificate);
                try 
                {
                    req.sendRequest(mHttpClientConnection);
                } //End block
                catch (HttpException e)
                {
                    exception = e;
                    error = EventHandler.ERROR;
                } //End block
                catch (IOException e)
                {
                    exception = e;
                    error = EventHandler.ERROR_IO;
                } //End block
                catch (IllegalStateException e)
                {
                    exception = e;
                    error = EventHandler.ERROR_IO;
                } //End block
                {
                    {
                        boolean var3550BE76A96DD86D49D0E4DF58B240F3_1608222117 = (httpFailure(req, error, exception) &&
                            !req.mCancelled);
                        {
                            pipe.addLast(req);
                        } //End block
                    } //End collapsed parenthetic
                    exception = null;
                    state = clearPipe(pipe) ? DONE : SEND;
                    minPipe = maxPipe = 1;
                } //End block
                pipe.addLast(req);
                state = READ;
            } //End block
            //End case SEND 
            //Begin case DRAIN READ 
            {
                empty = !mRequestFeeder.haveRequest(mHost);
                int pipeSize;
                pipeSize = pipe.size();
                {
                    state = SEND;
                } //End block
                {
                    state = empty ? DONE : SEND;
                } //End block
                req = (Request)pipe.removeFirst();
                HttpLog.v(
                            "processRequests() reading " + req);
                try 
                {
                    req.readResponse(mHttpClientConnection);
                } //End block
                catch (ParseException e)
                {
                    exception = e;
                    error = EventHandler.ERROR_IO;
                } //End block
                catch (IOException e)
                {
                    exception = e;
                    error = EventHandler.ERROR_IO;
                } //End block
                catch (IllegalStateException e)
                {
                    exception = e;
                    error = EventHandler.ERROR_IO;
                } //End block
                {
                    {
                        boolean var3550BE76A96DD86D49D0E4DF58B240F3_1372041414 = (httpFailure(req, error, exception) &&
                            !req.mCancelled);
                        {
                            req.reset();
                            pipe.addFirst(req);
                        } //End block
                    } //End collapsed parenthetic
                    exception = null;
                    mCanPersist = false;
                } //End block
                {
                    HttpLog.v(
                                "processRequests(): no persist, closing " +
                                mHost);
                    closeConnection();
                    mHttpContext.removeAttribute(HTTP_CONNECTION);
                    clearPipe(pipe);
                    minPipe = maxPipe = 1;
                    state = SEND;
                } //End block
            } //End block
            //End case DRAIN READ 
        } //End block
        addTaint(firstRequest.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.084 -0400", hash_original_method = "3DB5627BDFAF8C06A0CDDAD2458FF1F0", hash_generated_method = "C2A64BEE6691586A42209334CA09EDB9")
    private boolean clearPipe(LinkedList<Request> pipe) {
        boolean empty;
        empty = true;
        HttpLog.v(
                "Connection.clearPipe(): clearing pipe " + pipe.size());
        {
            Request tReq;
            {
                boolean var973B31D5A803FED5D96DAF9AB4327C3D_1309992275 = (!pipe.isEmpty());
                {
                    tReq = (Request)pipe.removeLast();
                    HttpLog.v(
                        "clearPipe() adding back " + mHost + " " + tReq);
                    mRequestFeeder.requeueRequest(tReq);
                    empty = false;
                } //End block
            } //End collapsed parenthetic
            empty = !mRequestFeeder.haveRequest(mHost);
        } //End block
        addTaint(pipe.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_820718105 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_820718105;
        // ---------- Original Method ----------
        //boolean empty = true;
        //if (HttpLog.LOGV) HttpLog.v(
                //"Connection.clearPipe(): clearing pipe " + pipe.size());
        //synchronized (mRequestFeeder) {
            //Request tReq;
            //while (!pipe.isEmpty()) {
                //tReq = (Request)pipe.removeLast();
                //if (HttpLog.LOGV) HttpLog.v(
                        //"clearPipe() adding back " + mHost + " " + tReq);
                //mRequestFeeder.requeueRequest(tReq);
                //empty = false;
            //}
            //if (empty) empty = !mRequestFeeder.haveRequest(mHost);
        //}
        //return empty;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.119 -0400", hash_original_method = "65B4C91B53E686F7A0B5A125142FC3C0", hash_generated_method = "1C13E590529317D994042889D68EC81A")
    private boolean openHttpConnection(Request req) {
        long now;
        now = SystemClock.uptimeMillis();
        int error;
        error = EventHandler.OK;
        Exception exception;
        exception = null;
        try 
        {
            mCertificate = null;
            mHttpClientConnection = openConnection(req);
            {
                mHttpClientConnection.setSocketTimeout(SOCKET_TIMEOUT);
                mHttpContext.setAttribute(HTTP_CONNECTION,
                                          mHttpClientConnection);
            } //End block
            {
                req.mFailCount = RETRY_REQUEST_LIMIT;
            } //End block
        } //End block
        catch (UnknownHostException e)
        {
            HttpLog.v("Failed to open connection");
            error = EventHandler.ERROR_LOOKUP;
            exception = e;
        } //End block
        catch (IllegalArgumentException e)
        {
            HttpLog.v("Illegal argument exception");
            error = EventHandler.ERROR_CONNECT;
            req.mFailCount = RETRY_REQUEST_LIMIT;
            exception = e;
        } //End block
        catch (SSLConnectionClosedByUserException e)
        {
            req.mFailCount = RETRY_REQUEST_LIMIT;
        } //End block
        catch (SSLHandshakeException e)
        {
            req.mFailCount = RETRY_REQUEST_LIMIT;
            HttpLog.v(
                    "SSL exception performing handshake");
            error = EventHandler.ERROR_FAILED_SSL_HANDSHAKE;
            exception = e;
        } //End block
        catch (IOException e)
        {
            error = EventHandler.ERROR_CONNECT;
            exception = e;
        } //End block
        {
            long now2;
            now2 = SystemClock.uptimeMillis();
            HttpLog.v("Connection.openHttpConnection() " +
                      (now2 - now) + " " + mHost);
        } //End block
        {
            {
                mRequestFeeder.requeueRequest(req);
            } //End block
            {
                httpFailure(req, error, exception);
            } //End block
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_4264743 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_4264743;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.127 -0400", hash_original_method = "6EC91A36E40ABAF43D521C6CD9682246", hash_generated_method = "107B99D66D2922F2A56D81A7B1F00E8C")
    private boolean httpFailure(Request req, int errorId, Exception e) {
        boolean ret;
        ret = true;
        HttpLog.v(
                "httpFailure() ******* " + e + " count " + req.mFailCount +
                " " + mHost + " " + req.getUri());
        {
            ret = false;
            String error;
            {
                error = ErrorStrings.getString(errorId, mContext);
            } //End block
            {
                Throwable cause;
                cause = e.getCause();
                error = cause != null ? cause.toString() : e.getMessage();
            } //End block
            req.mEventHandler.error(errorId, error);
            req.complete();
        } //End block
        closeConnection();
        mHttpContext.removeAttribute(HTTP_CONNECTION);
        addTaint(req.getTaint());
        addTaint(errorId);
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1747467525 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1747467525;
        // ---------- Original Method ----------
        //boolean ret = true;
        //if (HttpLog.LOGV) HttpLog.v(
                //"httpFailure() ******* " + e + " count " + req.mFailCount +
                //" " + mHost + " " + req.getUri());
        //if (++req.mFailCount >= RETRY_REQUEST_LIMIT) {
            //ret = false;
            //String error;
            //if (errorId < 0) {
                //error = ErrorStrings.getString(errorId, mContext);
            //} else {
                //Throwable cause = e.getCause();
                //error = cause != null ? cause.toString() : e.getMessage();
            //}
            //req.mEventHandler.error(errorId, error);
            //req.complete();
        //}
        //closeConnection();
        //mHttpContext.removeAttribute(HTTP_CONNECTION);
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.128 -0400", hash_original_method = "510B2315D285A4B8D2701F50BEED692F", hash_generated_method = "DCE424FACDA5238FA2EA10A725F4ACCD")
     HttpContext getHttpContext() {
        HttpContext varB4EAC82CA7396A68D541C85D26508E83_1927196593 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1927196593 = mHttpContext;
        varB4EAC82CA7396A68D541C85D26508E83_1927196593.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1927196593;
        // ---------- Original Method ----------
        //return mHttpContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.129 -0400", hash_original_method = "CD663685F32FAE99B1C37BBE4FC5CEFB", hash_generated_method = "C057897F8B18F2E8C481384A64285E24")
    private boolean keepAlive(HttpEntity entity,
            ProtocolVersion ver, int connType, final HttpContext context) {
        org.apache.http.HttpConnection conn;
        conn = (org.apache.http.HttpConnection)
            context.getAttribute(ExecutionContext.HTTP_CONNECTION);
        {
            boolean var3F09B4DA4021A00B0E0E85A7A98C2EF2_178079485 = (conn != null && !conn.isOpen());
        } //End collapsed parenthetic
        {
            {
                boolean varD4D0AAD58097CCD39F1ACA1D9158C81F_1326604806 = (entity.getContentLength() < 0);
                {
                    {
                        boolean varC22E6EAF1973D4EF188692D613BFFF4F_1300000418 = (!entity.isChunked() || ver.lessEquals(HttpVersion.HTTP_1_0));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        boolean varE7C0AF165CB1162AB0C6BED102DEE29E_1336734782 = (!ver.lessEquals(HttpVersion.HTTP_1_0));
        addTaint(entity.getTaint());
        addTaint(ver.getTaint());
        addTaint(connType);
        addTaint(context.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1775659080 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1775659080;
        // ---------- Original Method ----------
        //org.apache.http.HttpConnection conn = (org.apache.http.HttpConnection)
            //context.getAttribute(ExecutionContext.HTTP_CONNECTION);
        //if (conn != null && !conn.isOpen())
            //return false;
        //if (entity != null) {
            //if (entity.getContentLength() < 0) {
                //if (!entity.isChunked() || ver.lessEquals(HttpVersion.HTTP_1_0)) {
                    //return false;
                //}
            //}
        //}
        //if (connType == Headers.CONN_CLOSE) {
            //return false;
        //} else if (connType == Headers.CONN_KEEP_ALIVE) {
            //return true;
        //}
        //return !ver.lessEquals(HttpVersion.HTTP_1_0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.142 -0400", hash_original_method = "30E271C8B4BA77F90D768E6DAD0368A8", hash_generated_method = "4D4E5718D6623C41E8E53EA293E55F7E")
     void setCanPersist(HttpEntity entity, ProtocolVersion ver, int connType) {
        mCanPersist = keepAlive(entity, ver, connType, mHttpContext);
        // ---------- Original Method ----------
        //mCanPersist = keepAlive(entity, ver, connType, mHttpContext);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.142 -0400", hash_original_method = "948404D3184D15107ABD2526F5DFBFE0", hash_generated_method = "C987B1689B3761BB7765A463FADF77BA")
     void setCanPersist(boolean canPersist) {
        mCanPersist = canPersist;
        // ---------- Original Method ----------
        //mCanPersist = canPersist;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.143 -0400", hash_original_method = "5B21A605E2B59BE630988FE4FC055560", hash_generated_method = "099EB1D17679F2974019346F9E7E3420")
     boolean getCanPersist() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1473299188 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1473299188;
        // ---------- Original Method ----------
        //return mCanPersist;
    }

    
    abstract String getScheme();

    
    abstract void closeConnection();

    
    abstract AndroidHttpClientConnection openConnection(Request req) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.156 -0400", hash_original_method = "AD69CA65EB98EE93EFEEFD66CD2BA041", hash_generated_method = "E77859C6A9A6B2A28043B87C2B05339A")
    public synchronized String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1375477249 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1375477249 = mHost.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1375477249.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1375477249;
        // ---------- Original Method ----------
        //return mHost.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.157 -0400", hash_original_method = "ED2ED37A31E0A6859AF61C011936FDA1", hash_generated_method = "CEA6B8235A16AC60642E935DC75FF758")
     byte[] getBuf() {
        mBuf = new byte[8192];
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_752079206 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_752079206;
        // ---------- Original Method ----------
        //if (mBuf == null) mBuf = new byte[8192];
        //return mBuf;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.157 -0400", hash_original_field = "DC786437DAF39BC0353D2B9BA7D3C9E6", hash_generated_field = "8A7B7BD5BBEAEAEEB32291EE2763B6C8")

    static int SOCKET_TIMEOUT = 60000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.157 -0400", hash_original_field = "6BF33435F120264EF42E338D17C72D0B", hash_generated_field = "399F0015603163644E1C32D5B3C8E959")

    private static int SEND = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.157 -0400", hash_original_field = "E175EC5A2FD87D2B13E08BAB1C961780", hash_generated_field = "879F3E543B0FBF2F0C068961E71EE385")

    private static int READ = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.157 -0400", hash_original_field = "0CB9FCC085D3EC2FCAF62AD99BEB9AC2", hash_generated_field = "6204822F75964F83A0869E6A0BB80D41")

    private static int DRAIN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.158 -0400", hash_original_field = "709E3C1FBB813E9051103B038B68E183", hash_generated_field = "F8EC17F36E1C370BB2E07C6B986645A6")

    private static int DONE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.158 -0400", hash_original_field = "4890D714BFC35B9367C8CAB211D44263", hash_generated_field = "5DAF036DA9745F94D7128CB2ED16112F")

    private static String[] states = {"SEND",  "READ", "DRAIN", "DONE"};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.158 -0400", hash_original_field = "56C17BEC69383339D712A34A376816DF", hash_generated_field = "C20BDB569BF441D514B312064089B80D")

    private static int STATE_NORMAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.158 -0400", hash_original_field = "6DD800274CF5304024380655EE085BEF", hash_generated_field = "4B33F7E13CDE76A475EA8482B52829FC")

    private static int STATE_CANCEL_REQUESTED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.158 -0400", hash_original_field = "9CF6E88AA50B22FBAA17EBC283AD1064", hash_generated_field = "7A79C875716D1D2C886429E44E611409")

    private static int RETRY_REQUEST_LIMIT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.158 -0400", hash_original_field = "8AF7C98381A3955FFE32D244C79CD1BB", hash_generated_field = "A2819EC4D05C0D17B3151FE18C76F5DA")

    private static int MIN_PIPE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.158 -0400", hash_original_field = "FBAD8F702AAE93F7E71144CEB6214FFD", hash_generated_field = "49C60852E54A4DAD5B0666890A37269D")

    private static int MAX_PIPE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.158 -0400", hash_original_field = "315AC7FB13FDA9DD2AF31A202845A2F1", hash_generated_field = "77212DF15F187D163F2B369295E74A89")

    private static String HTTP_CONNECTION = "http.connection";
}

