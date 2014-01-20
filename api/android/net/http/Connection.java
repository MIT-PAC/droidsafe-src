package android.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.LinkedList;

import javax.net.ssl.SSLHandshakeException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;

import android.content.Context;
import android.os.SystemClock;

abstract class Connection {

    /**
     * connection factory: returns an HTTP or HTTPS connection as
     * necessary
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.896 -0500", hash_original_method = "9385B9D6EC74D1C750DAFAFBFBD94573", hash_generated_method = "4C4D93138F5E3927E852882E8218A1A2")
    
static Connection getConnection(
            Context context, HttpHost host, HttpHost proxy,
            RequestFeeder requestFeeder) {

        if (host.getSchemeName().equals("http")) {
            return new HttpConnection(context, host, requestFeeder);
        }

        // Otherwise, default to https
        return new HttpsConnection(context, host, proxy, requestFeeder);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.844 -0500", hash_original_field = "6CBAD2F9095CC876BAC89255E13EF2D9", hash_generated_field = "FD49C956DFAA52CB9AA44D852EDE7E88")

    static final int SOCKET_TIMEOUT = 60000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.847 -0500", hash_original_field = "F03FB3615DA5BF50A18AAB161B1A8121", hash_generated_field = "1685A8AED473B8DB89C64DD70F6B2006")

    private static final int SEND = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.849 -0500", hash_original_field = "22DB8F0A7F00930967DA2F9685488B5E", hash_generated_field = "22E96ACD2E5356C19B3A4C8936496A0F")

    private static final int READ = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.851 -0500", hash_original_field = "B995507E822B815392BD02C49CEAC450", hash_generated_field = "5BAF0CAFDC584F3B1861B58546EDCB7E")

    private static final int DRAIN = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.854 -0500", hash_original_field = "9D18D84309B6C9A34E1A88C3CE33FFB8", hash_generated_field = "A0EA7B5A8C185F5C7D5C82DFB7B53A9C")

    private static final int DONE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.856 -0500", hash_original_field = "15126CB90A8EC5A8DAAEAFEC434CF5EC", hash_generated_field = "751D7AEFD8D9F803728738C72D6E6C21")

    private static final String[] states = {"SEND",  "READ", "DRAIN", "DONE"};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.871 -0500", hash_original_field = "F8B2A139882F75F08BC255CC657BA228", hash_generated_field = "C20BDB569BF441D514B312064089B80D")

    private static int STATE_NORMAL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.873 -0500", hash_original_field = "46CCB37E57783F112F82AE8D0B95A08E", hash_generated_field = "4B33F7E13CDE76A475EA8482B52829FC")

    private static int STATE_CANCEL_REQUESTED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.877 -0500", hash_original_field = "C12EB9768D62D946F39AD059915E7425", hash_generated_field = "BB46C45CF828AF753F842CF0245407C9")

    private final static int RETRY_REQUEST_LIMIT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.879 -0500", hash_original_field = "3F533F5B9DFB580B7A178A760163083C", hash_generated_field = "8470675918FC5BC85BDE71A8C20A9EED")

    private static final int MIN_PIPE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.882 -0500", hash_original_field = "A3EC94B7D7D734A1A12DE0CFE823E426", hash_generated_field = "5FBC745DF7014C47FBE8E03B5689C9AC")

    private static final int MAX_PIPE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.884 -0500", hash_original_field = "F234D520B252191B909E3DAD4EF40817", hash_generated_field = "A05D44F0812379A6B6F7EFAA2F4D23B1")

    private static final String HTTP_CONNECTION = "http.connection";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.858 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.860 -0500", hash_original_field = "5527CB508C917F64359E36ED9BE59363", hash_generated_field = "89DB88E2A4BA8B129AFC783A277DC972")

    protected AndroidHttpClientConnection mHttpClientConnection = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.862 -0500", hash_original_field = "2FAAC0888F29E6AA839289DB5507DCB5", hash_generated_field = "C93393B13E8B23850F2A2AA31CFA340F")

    protected SslCertificate mCertificate = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.864 -0500", hash_original_field = "BB62408D38B8CFFE64423F7A37FB51DF", hash_generated_field = "BB62408D38B8CFFE64423F7A37FB51DF")

    HttpHost mHost;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.866 -0500", hash_original_field = "DB401CBBF1D92E78D554BFBB33AB7CCA", hash_generated_field = "7CE1ADB90870C4000E5A95CCB811B5D9")

    private boolean mCanPersist;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.868 -0500", hash_original_field = "8E6B97D48E6D003B7F5F3021ABFFBA2A", hash_generated_field = "5A9EBA484956FCBE0111BA8174DA817C")

    private HttpContext mHttpContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.875 -0500", hash_original_field = "815EB59F96EDB9FBF1F338EC2425F1A9", hash_generated_field = "47B94217572DFA83D4A2A33DD250B38D")

    private int mActive = STATE_NORMAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.887 -0500", hash_original_field = "537B204D0FD240DD08711E1D73085387", hash_generated_field = "537B204D0FD240DD08711E1D73085387")

    RequestFeeder mRequestFeeder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.889 -0500", hash_original_field = "CCCDB98A97C1303EEF1EDB8DB6C44807", hash_generated_field = "29FB82D1D2E75901C37B9EDD1B81BDDE")

    private byte[] mBuf;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.892 -0500", hash_original_method = "5BAB9F531750E6A689F8FF5D2A254CB9", hash_generated_method = "9A3780FAA33B97F769ADCD07ED8411AC")
    
protected Connection(Context context, HttpHost host,
                         RequestFeeder requestFeeder) {
        mContext = context;
        mHost = host;
        mRequestFeeder = requestFeeder;

        mCanPersist = false;
        mHttpContext = new BasicHttpContext(null);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.893 -0500", hash_original_method = "9B5E41A5FF20333698838F3F6DF6BCD6", hash_generated_method = "9B5E41A5FF20333698838F3F6DF6BCD6")
    
HttpHost getHost() {
        return mHost;
    }

    /**
     * @return The server SSL certificate associated with this
     * connection (null if the connection is not secure)
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.898 -0500", hash_original_method = "7F448377575EC929DDEDD2BF1EB435C4", hash_generated_method = "7F448377575EC929DDEDD2BF1EB435C4")
    
SslCertificate getCertificate() {
        return mCertificate;
    }

    /**
     * Close current network connection
     * Note: this runs in non-network thread
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.900 -0500", hash_original_method = "E0AFA64670C1DBA320AD7B4F64C9D703", hash_generated_method = "E0AFA64670C1DBA320AD7B4F64C9D703")
    
void cancel() {
        mActive = STATE_CANCEL_REQUESTED;
        closeConnection();
        if (HttpLog.LOGV) HttpLog.v(
            "Connection.cancel(): connection closed " + mHost);
    }

    /**
     * Process requests in queue
     * pipelines requests
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.904 -0500", hash_original_method = "F5EEA514D7040591FC6D3FB9B4E157ED", hash_generated_method = "E46FBFB4883AE1552E95C85002A1AF0A")
    
void processRequests(Request firstRequest) {
        Request req = null;
        boolean empty;
        int error = EventHandler.OK;
        Exception exception = null;

        LinkedList<Request> pipe = new LinkedList<Request>();

        int minPipe = MIN_PIPE, maxPipe = MAX_PIPE;
        int state = SEND;

        while (state != DONE) {
            if (HttpLog.LOGV) HttpLog.v(
                    states[state] + " pipe " + pipe.size());

            /* If a request was cancelled, give other cancel requests
               some time to go through so we don't uselessly restart
               connections */
            if (mActive == STATE_CANCEL_REQUESTED) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException x) { /* ignore */ }
                mActive = STATE_NORMAL;
            }

            switch (state) {
                case SEND: {
                    if (pipe.size() == maxPipe) {
                        state = READ;
                        break;
                    }
                    /* get a request */
                    if (firstRequest == null) {
                        req = mRequestFeeder.getRequest(mHost);
                    } else {
                        req = firstRequest;
                        firstRequest = null;
                    }
                    if (req == null) {
                        state = DRAIN;
                        break;
                    }
                    req.setConnection(this);

                    /* Don't work on cancelled requests. */
                    if (req.mCancelled) {
                        if (HttpLog.LOGV) HttpLog.v(
                                "processRequests(): skipping cancelled request "
                                + req);
                        req.complete();
                        break;
                    }

                    if (mHttpClientConnection == null ||
                        !mHttpClientConnection.isOpen()) {
                        /* If this call fails, the address is bad or
                           the net is down.  Punt for now.

                           FIXME: blow out entire queue here on
                           connection failure if net up? */

                        if (!openHttpConnection(req)) {
                            state = DONE;
                            break;
                        }
                    }

                    /* we have a connection, let the event handler
                     * know of any associated certificate,
                     * potentially none.
                     */
                    req.mEventHandler.certificate(mCertificate);

                    try {
                        /* FIXME: don't increment failure count if old
                           connection?  There should not be a penalty for
                           attempting to reuse an old connection */
                        req.sendRequest(mHttpClientConnection);
                    } catch (HttpException e) {
                        exception = e;
                        error = EventHandler.ERROR;
                    } catch (IOException e) {
                        exception = e;
                        error = EventHandler.ERROR_IO;
                    } catch (IllegalStateException e) {
                        exception = e;
                        error = EventHandler.ERROR_IO;
                    }
                    if (exception != null) {
                        if (httpFailure(req, error, exception) &&
                            !req.mCancelled) {
                            /* retry request if not permanent failure
                               or cancelled */
                            pipe.addLast(req);
                        }
                        exception = null;
                        state = clearPipe(pipe) ? DONE : SEND;
                        minPipe = maxPipe = 1;
                        break;
                    }

                    pipe.addLast(req);
                    if (!mCanPersist) state = READ;
                    break;

                }
                case DRAIN:
                case READ: {
                    empty = !mRequestFeeder.haveRequest(mHost);
                    int pipeSize = pipe.size();
                    if (state != DRAIN && pipeSize < minPipe &&
                        !empty && mCanPersist) {
                        state = SEND;
                        break;
                    } else if (pipeSize == 0) {
                        /* Done if no other work to do */
                        state = empty ? DONE : SEND;
                        break;
                    }

                    req = (Request)pipe.removeFirst();
                    if (HttpLog.LOGV) HttpLog.v(
                            "processRequests() reading " + req);

                    try {
                        req.readResponse(mHttpClientConnection);
                    } catch (ParseException e) {
                        exception = e;
                        error = EventHandler.ERROR_IO;
                    } catch (IOException e) {
                        exception = e;
                        error = EventHandler.ERROR_IO;
                    } catch (IllegalStateException e) {
                        exception = e;
                        error = EventHandler.ERROR_IO;
                    }
                    if (exception != null) {
                        if (httpFailure(req, error, exception) &&
                            !req.mCancelled) {
                            /* retry request if not permanent failure
                               or cancelled */
                            req.reset();
                            pipe.addFirst(req);
                        }
                        exception = null;
                        mCanPersist = false;
                    }
                    if (!mCanPersist) {
                        if (HttpLog.LOGV) HttpLog.v(
                                "processRequests(): no persist, closing " +
                                mHost);

                        closeConnection();

                        mHttpContext.removeAttribute(HTTP_CONNECTION);
                        clearPipe(pipe);
                        minPipe = maxPipe = 1;
                        state = SEND;
                    }
                    break;
                }
            }
        }
    }

    /**
     * After a send/receive failure, any pipelined requests must be
     * cleared back to the mRequest queue
     * @return true if mRequests is empty after pipe cleared
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.907 -0500", hash_original_method = "3DB5627BDFAF8C06A0CDDAD2458FF1F0", hash_generated_method = "8355093E9B5A918D63AB9052B262AE0F")
    
private boolean clearPipe(LinkedList<Request> pipe) {
        boolean empty = true;
        if (HttpLog.LOGV) HttpLog.v(
                "Connection.clearPipe(): clearing pipe " + pipe.size());
        synchronized (mRequestFeeder) {
            Request tReq;
            while (!pipe.isEmpty()) {
                tReq = (Request)pipe.removeLast();
                if (HttpLog.LOGV) HttpLog.v(
                        "clearPipe() adding back " + mHost + " " + tReq);
                mRequestFeeder.requeueRequest(tReq);
                empty = false;
            }
            if (empty) empty = !mRequestFeeder.haveRequest(mHost);
        }
        return empty;
    }

    /**
     * @return true on success
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.910 -0500", hash_original_method = "65B4C91B53E686F7A0B5A125142FC3C0", hash_generated_method = "685BB5C8C60A4113FB6E30D0B096B062")
    
private boolean openHttpConnection(Request req) {

        long now = SystemClock.uptimeMillis();
        int error = EventHandler.OK;
        Exception exception = null;

        try {
            // reset the certificate to null before opening a connection
            mCertificate = null;
            mHttpClientConnection = openConnection(req);
            if (mHttpClientConnection != null) {
                mHttpClientConnection.setSocketTimeout(SOCKET_TIMEOUT);
                mHttpContext.setAttribute(HTTP_CONNECTION,
                                          mHttpClientConnection);
            } else {
                // we tried to do SSL tunneling, failed,
                // and need to drop the request;
                // we have already informed the handler
                req.mFailCount = RETRY_REQUEST_LIMIT;
                return false;
            }
        } catch (UnknownHostException e) {
            if (HttpLog.LOGV) HttpLog.v("Failed to open connection");
            error = EventHandler.ERROR_LOOKUP;
            exception = e;
        } catch (IllegalArgumentException e) {
            if (HttpLog.LOGV) HttpLog.v("Illegal argument exception");
            error = EventHandler.ERROR_CONNECT;
            req.mFailCount = RETRY_REQUEST_LIMIT;
            exception = e;
        } catch (SSLConnectionClosedByUserException e) {
            // hack: if we have an SSL connection failure,
            // we don't want to reconnect
            req.mFailCount = RETRY_REQUEST_LIMIT;
            // no error message
            return false;
        } catch (SSLHandshakeException e) {
            // hack: if we have an SSL connection failure,
            // we don't want to reconnect
            req.mFailCount = RETRY_REQUEST_LIMIT;
            if (HttpLog.LOGV) HttpLog.v(
                    "SSL exception performing handshake");
            error = EventHandler.ERROR_FAILED_SSL_HANDSHAKE;
            exception = e;
        } catch (IOException e) {
            error = EventHandler.ERROR_CONNECT;
            exception = e;
        }

        if (HttpLog.LOGV) {
            long now2 = SystemClock.uptimeMillis();
            HttpLog.v("Connection.openHttpConnection() " +
                      (now2 - now) + " " + mHost);
        }

        if (error == EventHandler.OK) {
            return true;
        } else {
            if (req.mFailCount < RETRY_REQUEST_LIMIT) {
                // requeue
                mRequestFeeder.requeueRequest(req);
                req.mFailCount++;
            } else {
                httpFailure(req, error, exception);
            }
            return error == EventHandler.OK;
        }
    }

    /**
     * Helper.  Calls the mEventHandler's error() method only if
     * request failed permanently.  Increments mFailcount on failure.
     *
     * Increments failcount only if the network is believed to be
     * connected
     *
     * @return true if request can be retried (less than
     * RETRY_REQUEST_LIMIT failures have occurred).
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.913 -0500", hash_original_method = "6EC91A36E40ABAF43D521C6CD9682246", hash_generated_method = "AEFBDA141683B77570677E43A16757B3")
    
private boolean httpFailure(Request req, int errorId, Exception e) {
        boolean ret = true;

        // e.printStackTrace();
        if (HttpLog.LOGV) HttpLog.v(
                "httpFailure() ******* " + e + " count " + req.mFailCount +
                " " + mHost + " " + req.getUri());

        if (++req.mFailCount >= RETRY_REQUEST_LIMIT) {
            ret = false;
            String error;
            if (errorId < 0) {
                error = ErrorStrings.getString(errorId, mContext);
            } else {
                Throwable cause = e.getCause();
                error = cause != null ? cause.toString() : e.getMessage();
            }
            req.mEventHandler.error(errorId, error);
            req.complete();
        }

        closeConnection();
        mHttpContext.removeAttribute(HTTP_CONNECTION);

        return ret;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.915 -0500", hash_original_method = "510B2315D285A4B8D2701F50BEED692F", hash_generated_method = "510B2315D285A4B8D2701F50BEED692F")
    
HttpContext getHttpContext() {
        return mHttpContext;
    }

    /**
     * Use same logic as ConnectionReuseStrategy
     * @see ConnectionReuseStrategy
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.918 -0500", hash_original_method = "CD663685F32FAE99B1C37BBE4FC5CEFB", hash_generated_method = "D298DF6EDE468BBCFD57E976D23290BF")
    
private boolean keepAlive(HttpEntity entity,
            ProtocolVersion ver, int connType, final HttpContext context) {
        org.apache.http.HttpConnection conn = (org.apache.http.HttpConnection)
            context.getAttribute(ExecutionContext.HTTP_CONNECTION);

        if (conn != null && !conn.isOpen())
            return false;
        // do NOT check for stale connection, that is an expensive operation

        if (entity != null) {
            if (entity.getContentLength() < 0) {
                if (!entity.isChunked() || ver.lessEquals(HttpVersion.HTTP_1_0)) {
                    // if the content length is not known and is not chunk
                    // encoded, the connection cannot be reused
                    return false;
                }
            }
        }
        // Check for 'Connection' directive
        if (connType == Headers.CONN_CLOSE) {
            return false;
        } else if (connType == Headers.CONN_KEEP_ALIVE) {
            return true;
        }
        // Resorting to protocol version default close connection policy
        return !ver.lessEquals(HttpVersion.HTTP_1_0);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.920 -0500", hash_original_method = "30E271C8B4BA77F90D768E6DAD0368A8", hash_generated_method = "30E271C8B4BA77F90D768E6DAD0368A8")
    
void setCanPersist(HttpEntity entity, ProtocolVersion ver, int connType) {
        mCanPersist = keepAlive(entity, ver, connType, mHttpContext);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.922 -0500", hash_original_method = "948404D3184D15107ABD2526F5DFBFE0", hash_generated_method = "948404D3184D15107ABD2526F5DFBFE0")
    
void setCanPersist(boolean canPersist) {
        mCanPersist = canPersist;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.923 -0500", hash_original_method = "5B21A605E2B59BE630988FE4FC055560", hash_generated_method = "5B21A605E2B59BE630988FE4FC055560")
    
boolean getCanPersist() {
        return mCanPersist;
    }

    /** typically http or https... set by subclass */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.925 -0500", hash_original_method = "49DE357EBCB935115FD25920AB27E09B", hash_generated_method = "39D6F3ED68DA5E1AAED39BA2792E024C")
    
abstract String getScheme();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.927 -0500", hash_original_method = "2743D0CE4FC6FDA658E35772D12E049E", hash_generated_method = "375F4613E9CAD8196D088F4D3C02D3D1")
    
abstract void closeConnection();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.929 -0500", hash_original_method = "0B181E605C4B422EB0E3DFC7D1CC67FB", hash_generated_method = "FC5E6927B007D47BC3C2D5378E8FE53E")
    
abstract AndroidHttpClientConnection openConnection(Request req) throws IOException;

    /**
     * Prints request queue to log, for debugging.
     * returns request count
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.932 -0500", hash_original_method = "AD69CA65EB98EE93EFEEFD66CD2BA041", hash_generated_method = "0F0B9B727B9C02D7CF2D8CB4C4E59E27")
    
public synchronized String toString() {
        return mHost.toString();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:14.934 -0500", hash_original_method = "ED2ED37A31E0A6859AF61C011936FDA1", hash_generated_method = "ED2ED37A31E0A6859AF61C011936FDA1")
    
byte[] getBuf() {
        if (mBuf == null) mBuf = new byte[8192];
        return mBuf;
    }
}

