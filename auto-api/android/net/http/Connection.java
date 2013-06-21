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
    Context mContext;
    protected AndroidHttpClientConnection mHttpClientConnection = null;
    protected SslCertificate mCertificate = null;
    HttpHost mHost;
    private boolean mCanPersist;
    private HttpContext mHttpContext;
    private int mActive = STATE_NORMAL;
    RequestFeeder mRequestFeeder;
    private byte[] mBuf;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.749 -0400", hash_original_method = "5BAB9F531750E6A689F8FF5D2A254CB9", hash_generated_method = "801A0987E484403A1E35DC2167EFBAFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Connection(Context context, HttpHost host,
                         RequestFeeder requestFeeder) {
        dsTaint.addTaint(host.dsTaint);
        dsTaint.addTaint(requestFeeder.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        mCanPersist = false;
        mHttpContext = new BasicHttpContext(null);
        // ---------- Original Method ----------
        //mContext = context;
        //mHost = host;
        //mRequestFeeder = requestFeeder;
        //mCanPersist = false;
        //mHttpContext = new BasicHttpContext(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.749 -0400", hash_original_method = "9B5E41A5FF20333698838F3F6DF6BCD6", hash_generated_method = "C5CBAFA1DC5068BA0CFA39744BA6E066")
    @DSModeled(DSC.SAFE)
     HttpHost getHost() {
        return (HttpHost)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.750 -0400", hash_original_method = "7F448377575EC929DDEDD2BF1EB435C4", hash_generated_method = "A82800696709CE09330F82EA7C79D92B")
    @DSModeled(DSC.SAFE)
     SslCertificate getCertificate() {
        return (SslCertificate)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCertificate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.750 -0400", hash_original_method = "E0AFA64670C1DBA320AD7B4F64C9D703", hash_generated_method = "BB343129EA06027067E7E95173C78636")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.752 -0400", hash_original_method = "F5EEA514D7040591FC6D3FB9B4E157ED", hash_generated_method = "448ECBCF91F03CC35568ABFEF44D4FB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void processRequests(Request firstRequest) {
        dsTaint.addTaint(firstRequest.dsTaint);
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
                    boolean varF6446B26928F500236FEA2DA96BA2177_2127809832 = (pipe.size() == maxPipe);
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
                    boolean var363D9D2F0E89C11F47781F945C0D91C8_68344384 = (mHttpClientConnection == null ||
                        !mHttpClientConnection.isOpen());
                    {
                        {
                            boolean var3B9848892C343394B2F8D5F96B18C3C5_295924766 = (!openHttpConnection(req));
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
                        boolean var3550BE76A96DD86D49D0E4DF58B240F3_846295928 = (httpFailure(req, error, exception) &&
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
                        boolean var3550BE76A96DD86D49D0E4DF58B240F3_462079699 = (httpFailure(req, error, exception) &&
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.753 -0400", hash_original_method = "3DB5627BDFAF8C06A0CDDAD2458FF1F0", hash_generated_method = "708DF9F546842708704BAF86F7A73918")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean clearPipe(LinkedList<Request> pipe) {
        dsTaint.addTaint(pipe.dsTaint);
        boolean empty;
        empty = true;
        HttpLog.v(
                "Connection.clearPipe(): clearing pipe " + pipe.size());
        {
            Request tReq;
            {
                boolean var973B31D5A803FED5D96DAF9AB4327C3D_384684422 = (!pipe.isEmpty());
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.754 -0400", hash_original_method = "65B4C91B53E686F7A0B5A125142FC3C0", hash_generated_method = "D6F2BCAD92937CEC70BA5DD6A0E6382F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean openHttpConnection(Request req) {
        dsTaint.addTaint(req.dsTaint);
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.754 -0400", hash_original_method = "6EC91A36E40ABAF43D521C6CD9682246", hash_generated_method = "1BB2D69067B8BCCC7DA720401C4E84EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean httpFailure(Request req, int errorId, Exception e) {
        dsTaint.addTaint(e.dsTaint);
        dsTaint.addTaint(req.dsTaint);
        dsTaint.addTaint(errorId);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.754 -0400", hash_original_method = "510B2315D285A4B8D2701F50BEED692F", hash_generated_method = "B3328385C668F44FB9A9DC6E0917F2CB")
    @DSModeled(DSC.SAFE)
     HttpContext getHttpContext() {
        return (HttpContext)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mHttpContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.755 -0400", hash_original_method = "CD663685F32FAE99B1C37BBE4FC5CEFB", hash_generated_method = "4A88B3408ABA08FB5CE6DE6EDCDA4F8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean keepAlive(HttpEntity entity,
            ProtocolVersion ver, int connType, final HttpContext context) {
        dsTaint.addTaint(connType);
        dsTaint.addTaint(entity.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(ver.dsTaint);
        org.apache.http.HttpConnection conn;
        conn = (org.apache.http.HttpConnection)
            context.getAttribute(ExecutionContext.HTTP_CONNECTION);
        {
            boolean var3F09B4DA4021A00B0E0E85A7A98C2EF2_683330708 = (conn != null && !conn.isOpen());
        } //End collapsed parenthetic
        {
            {
                boolean varD4D0AAD58097CCD39F1ACA1D9158C81F_1645151386 = (entity.getContentLength() < 0);
                {
                    {
                        boolean varC22E6EAF1973D4EF188692D613BFFF4F_169802233 = (!entity.isChunked() || ver.lessEquals(HttpVersion.HTTP_1_0));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        boolean varE7C0AF165CB1162AB0C6BED102DEE29E_1377289864 = (!ver.lessEquals(HttpVersion.HTTP_1_0));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.755 -0400", hash_original_method = "30E271C8B4BA77F90D768E6DAD0368A8", hash_generated_method = "FF5F8E458EFFE55ED5BF98BA021F0BEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setCanPersist(HttpEntity entity, ProtocolVersion ver, int connType) {
        dsTaint.addTaint(connType);
        dsTaint.addTaint(entity.dsTaint);
        dsTaint.addTaint(ver.dsTaint);
        mCanPersist = keepAlive(entity, ver, connType, mHttpContext);
        // ---------- Original Method ----------
        //mCanPersist = keepAlive(entity, ver, connType, mHttpContext);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.755 -0400", hash_original_method = "948404D3184D15107ABD2526F5DFBFE0", hash_generated_method = "D494D915AD77E7D89E7A4CC6D16BE413")
    @DSModeled(DSC.SAFE)
     void setCanPersist(boolean canPersist) {
        dsTaint.addTaint(canPersist);
        // ---------- Original Method ----------
        //mCanPersist = canPersist;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.756 -0400", hash_original_method = "5B21A605E2B59BE630988FE4FC055560", hash_generated_method = "08C7C981F7839E0C8EE84BB037FD236F")
    @DSModeled(DSC.SAFE)
     boolean getCanPersist() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCanPersist;
    }

    
    abstract String getScheme();

    
    abstract void closeConnection();

    
    abstract AndroidHttpClientConnection openConnection(Request req) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.756 -0400", hash_original_method = "AD69CA65EB98EE93EFEEFD66CD2BA041", hash_generated_method = "0338D28558442D97D2379A1285A8FE73")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized String toString() {
        String var677EB2750AC5BC3B7E0014D73CAB8D9E_1772797446 = (mHost.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mHost.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.756 -0400", hash_original_method = "ED2ED37A31E0A6859AF61C011936FDA1", hash_generated_method = "47FA944B06298B9E6CB0E21242720AB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     byte[] getBuf() {
        mBuf = new byte[8192];
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (mBuf == null) mBuf = new byte[8192];
        //return mBuf;
    }

    
    static final int SOCKET_TIMEOUT = 60000;
    private static final int SEND = 0;
    private static final int READ = 1;
    private static final int DRAIN = 2;
    private static final int DONE = 3;
    private static final String[] states = {"SEND",  "READ", "DRAIN", "DONE"};
    private static int STATE_NORMAL = 0;
    private static int STATE_CANCEL_REQUESTED = 1;
    private final static int RETRY_REQUEST_LIMIT = 2;
    private static final int MIN_PIPE = 2;
    private static final int MAX_PIPE = 3;
    private static final String HTTP_CONNECTION = "http.connection";
}

