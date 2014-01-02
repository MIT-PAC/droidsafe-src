package android.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.protocol.RequestContent;






class Request {

    /**
     * Decide whether a response comes with an entity.
     * The implementation in this class is based on RFC 2616.
     * Unknown methods and response codes are supposed to
     * indicate responses with an entity.
     * <br/>
     * Derived executors can override this method to handle
     * methods and response codes not specified in RFC 2616.
     *
     * @param request   the request, to obtain the executed method
     * @param response  the response, to obtain the status code
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.704 -0500", hash_original_method = "04461905D5906FA3DCAABB508245B209", hash_generated_method = "C59D3BA0BCD3A6EE5C635817F5FB067D")
    
private static boolean canResponseHaveBody(final HttpRequest request,
                                               final int status) {

        if ("HEAD".equalsIgnoreCase(request.getRequestLine().getMethod())) {
            return false;
        }
        return status >= HttpStatus.SC_OK
            && status != HttpStatus.SC_NO_CONTENT
            && status != HttpStatus.SC_NOT_MODIFIED;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.651 -0500", hash_original_field = "1E92A266EBDB8B46D3250CA0A5786BE9", hash_generated_field = "7B9DE3A4130C6C995D9A037F9150C7FA")


    private final static String HOST_HEADER = "Host";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.654 -0500", hash_original_field = "3EE60C7966B8BBAB851456B4A377E69C", hash_generated_field = "E84D9A59CAEF3BCC11F8F89244D21D5D")

    private final static String ACCEPT_ENCODING_HEADER = "Accept-Encoding";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.657 -0500", hash_original_field = "2A644AF32A7BD6AAC4259523FF330F77", hash_generated_field = "A5FEF046E57453815489487A5ADC09DE")

    private final static String CONTENT_LENGTH_HEADER = "content-length";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.664 -0500", hash_original_field = "FC05EDC2EC2D172FD33EBDA8371CD59C", hash_generated_field = "F007AA5F14F6E3C18CB781D2C4A675C4")

    private static RequestContent requestContentProcessor =
            new RequestContent();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.627 -0500", hash_original_field = "48DBEFEB1D57D7425F34775E3B0822FD", hash_generated_field = "48DBEFEB1D57D7425F34775E3B0822FD")

    EventHandler mEventHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.630 -0500", hash_original_field = "D468AD0EA1184CE89FA8A45254E2CDD6", hash_generated_field = "619FD7E303013DFEE90F58DA7C3DCACD")


    private Connection mConnection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.632 -0500", hash_original_field = "00DCF501A850F291B81138270DDF7D4D", hash_generated_field = "00DCF501A850F291B81138270DDF7D4D")

    BasicHttpRequest mHttpRequest;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.634 -0500", hash_original_field = "1D4D0FAE668EECF10ED75DDC284FFC16", hash_generated_field = "1D4D0FAE668EECF10ED75DDC284FFC16")

    String mPath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.636 -0500", hash_original_field = "BB62408D38B8CFFE64423F7A37FB51DF", hash_generated_field = "BB62408D38B8CFFE64423F7A37FB51DF")

    HttpHost mHost;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.638 -0500", hash_original_field = "8D07AC44AA4C74B2AC6E6F002329824C", hash_generated_field = "8D07AC44AA4C74B2AC6E6F002329824C")

    HttpHost mProxyHost;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.641 -0500", hash_original_field = "DE939164FC7BA4BBF78A04A60D6F1F48", hash_generated_field = "81F1F19F02DD71D9D08A9477DAAD695B")

    volatile boolean mCancelled = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.642 -0500", hash_original_field = "5E66863F07F10B7287F0E997DBE9BDFD", hash_generated_field = "5E66863F07F10B7287F0E997DBE9BDFD")


    int mFailCount = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.644 -0500", hash_original_field = "9F24C9AA82C33343B9BFCD7DF72B7F2C", hash_generated_field = "9AA1D199AB2A27232DA25E07F74C582A")

    // is http/1.1 feature.
    private int mReceivedBytes = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.647 -0500", hash_original_field = "00BD06F3A68F022203FBFD258BDC707D", hash_generated_field = "D18E2D3147EECBD8F566EDA75779DDA2")


    private InputStream mBodyProvider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.649 -0500", hash_original_field = "9F97B0948BBDDDA2CDEDF84C846F0425", hash_generated_field = "DAA6C79DB8D209A54BE4FF4B04B63B6B")

    private int mBodyLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.660 -0500", hash_original_field = "EE22D57F1DBDB5332BEC1A7C1228CAB3", hash_generated_field = "58B1C220EAC61D22A66429CC428EF626")

    private final Object mClientResource = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.662 -0500", hash_original_field = "0504A143E354556BF76FDA83FD8D3BB5", hash_generated_field = "E2A1F626EC5A40F2B6A741C8173B85D6")

    private boolean mLoadingPaused = false;

    /**
     * Instantiates a new Request.
     * @param method GET/POST/PUT
     * @param host The server that will handle this request
     * @param path path part of URI
     * @param bodyProvider InputStream providing HTTP body, null if none
     * @param bodyLength length of body, must be 0 if bodyProvider is null
     * @param eventHandler request will make progress callbacks on
     * this interface
     * @param headers reqeust headers
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.667 -0500", hash_original_method = "E3AB2A1C4C118761EA0CC20D593A5A78", hash_generated_method = "E3C161AA33E9F97B75915A04C7D01B65")
    
Request(String method, HttpHost host, HttpHost proxyHost, String path,
            InputStream bodyProvider, int bodyLength,
            EventHandler eventHandler,
            Map<String, String> headers) {
        mEventHandler = eventHandler;
        mHost = host;
        mProxyHost = proxyHost;
        mPath = path;
        mBodyProvider = bodyProvider;
        mBodyLength = bodyLength;

        if (bodyProvider == null && !"POST".equalsIgnoreCase(method)) {
            mHttpRequest = new BasicHttpRequest(method, getUri());
        } else {
            mHttpRequest = new BasicHttpEntityEnclosingRequest(
                    method, getUri());
            // it is ok to have null entity for BasicHttpEntityEnclosingRequest.
            // By using BasicHttpEntityEnclosingRequest, it will set up the
            // correct content-length, content-type and content-encoding.
            if (bodyProvider != null) {
                setBodyProvider(bodyProvider, bodyLength);
            }
        }
        addHeader(HOST_HEADER, getHostPort());

        /* FIXME: if webcore will make the root document a
           high-priority request, we can ask for gzip encoding only on
           high priority reqs (saving the trouble for images, etc) */
        addHeader(ACCEPT_ENCODING_HEADER, "gzip");
        addHeaders(headers);
    }

    /**
     * @param pause True if the load should be paused.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.669 -0500", hash_original_method = "E8032EBF304EE392C16172EA55A4B7FA", hash_generated_method = "6D078047263CC1711E539100E6DECBDE")
    
synchronized void setLoadingPaused(boolean pause) {
        mLoadingPaused = pause;

        // Wake up the paused thread if we're unpausing the load.
        if (!mLoadingPaused) {
            notify();
        }
    }

    /**
     * @param connection Request served by this connection
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.671 -0500", hash_original_method = "A8C7471D7BEF79EC71A4F8B9C611F231", hash_generated_method = "A8C7471D7BEF79EC71A4F8B9C611F231")
    
void setConnection(Connection connection) {
        mConnection = connection;
    }

    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.673 -0500", hash_original_method = "1AA9C40DC41DAB952A0E5EA6B233F2D0", hash_generated_method = "1AA9C40DC41DAB952A0E5EA6B233F2D0")
    
EventHandler getEventHandler() {
        return mEventHandler;
    }

    /**
     * Add header represented by given pair to request.  Header will
     * be formatted in request as "name: value\r\n".
     * @param name of header
     * @param value of header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.676 -0500", hash_original_method = "CAFFB5BC78A2E3A526CF37E51EA3E6DA", hash_generated_method = "CAFFB5BC78A2E3A526CF37E51EA3E6DA")
    
void addHeader(String name, String value) {
        if (name == null) {
            String damage = "Null http header name";
            HttpLog.e(damage);
            throw new NullPointerException(damage);
        }
        if (value == null || value.length() == 0) {
            String damage = "Null or empty value for header \"" + name + "\"";
            HttpLog.e(damage);
            throw new RuntimeException(damage);
        }
        mHttpRequest.addHeader(name, value);
    }

    /**
     * Add all headers in given map to this request.  This is a helper
     * method: it calls addHeader for each pair in the map.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.678 -0500", hash_original_method = "CAEF84F00E8BD676D33383FFEC6D862C", hash_generated_method = "CAEF84F00E8BD676D33383FFEC6D862C")
    
void addHeaders(Map<String, String> headers) {
        if (headers == null) {
            return;
        }

        Entry<String, String> entry;
        Iterator<Entry<String, String>> i = headers.entrySet().iterator();
        while (i.hasNext()) {
            entry = i.next();
            addHeader(entry.getKey(), entry.getValue());
        }
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.379 -0400", hash_original_method = "8B550870D8AB2316B065E1C79CBF1A12", hash_generated_method = "383E98875EEC585A968060D5275FCCF4")
     void sendRequest(AndroidHttpClientConnection httpClientConnection) throws HttpException, IOException {
        addTaint(httpClientConnection.getTaint());
        if(mCancelled)        
        return;
        if(HttpLog.LOGV)        
        {
            HttpLog.v("Request.sendRequest() " + mHost.getSchemeName() + "://" + getHostPort());
            if(false)            
            {
                Iterator i = mHttpRequest.headerIterator();
                while
(i.hasNext())                
                {
                    Header header = (Header)i.next();
                    HttpLog.v(header.getName() + ": " + header.getValue());
                } //End block
            } //End block
        } //End block
        requestContentProcessor.process(mHttpRequest,
                                        mConnection.getHttpContext());
        httpClientConnection.sendRequestHeader(mHttpRequest);
        if(mHttpRequest instanceof HttpEntityEnclosingRequest)        
        {
            httpClientConnection.sendRequestEntity(
                    (HttpEntityEnclosingRequest) mHttpRequest);
        } //End block
        if(HttpLog.LOGV)        
        {
            HttpLog.v("Request.requestSent() " + mHost.getSchemeName() + "://" + getHostPort() + mPath);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.382 -0400", hash_original_method = "77E4A14D27C62797F0A19B684369B7C4", hash_generated_method = "2E64E738A714DA8F9EDDFAFF77FC9478")
     void readResponse(AndroidHttpClientConnection httpClientConnection) throws IOException, ParseException {
        addTaint(httpClientConnection.getTaint());
        if(mCancelled)        
        return;
        StatusLine statusLine = null;
        boolean hasBody = false;
        httpClientConnection.flush();
        int statusCode = 0;
        Headers header = new Headers();
        do {
            {
                statusLine = httpClientConnection.parseResponseHeader(header);
                statusCode = statusLine.getStatusCode();
            } //End block
} while (statusCode < HttpStatus.SC_OK);
        if(HttpLog.LOGV)        
        HttpLog.v(
                "Request.readResponseStatus() " +
                statusLine.toString().length() + " " + statusLine);
        ProtocolVersion v = statusLine.getProtocolVersion();
        mEventHandler.status(v.getMajor(), v.getMinor(),
                statusCode, statusLine.getReasonPhrase());
        mEventHandler.headers(header);
        HttpEntity entity = null;
        hasBody = canResponseHaveBody(mHttpRequest, statusCode);
        if(hasBody)        
        entity = httpClientConnection.receiveResponseEntity(header);
        boolean supportPartialContent = "bytes".equalsIgnoreCase(header
                .getAcceptRanges());
        if(entity != null)        
        {
            InputStream is = entity.getContent();
            Header contentEncoding = entity.getContentEncoding();
            InputStream nis = null;
            byte[] buf = null;
            int count = 0;
            try 
            {
                if(contentEncoding != null &&
                    contentEncoding.getValue().equals("gzip"))                
                {
                    nis = new GZIPInputStream(is);
                } //End block
                else
                {
                    nis = is;
                } //End block
                buf = mConnection.getBuf();
                int len = 0;
                int lowWater = buf.length / 2;
                while
(len != -1)                
                {
                    synchronized
(this)                    {
                        while
(mLoadingPaused)                        
                        {
                            try 
                            {
                                wait();
                            } //End block
                            catch (InterruptedException e)
                            {
                                HttpLog.e("Interrupted exception whilst "
                                    + "network thread paused at WebCore's request."
                                    + " " + e.getMessage());
                            } //End block
                        } //End block
                    } //End block
                    len = nis.read(buf, count, buf.length - count);
                    if(len != -1)                    
                    {
                        count += len;
                        if(supportPartialContent)                        
                        mReceivedBytes += len;
                    } //End block
                    if(len == -1 || count >= lowWater)                    
                    {
                        if(HttpLog.LOGV)                        
                        HttpLog.v("Request.readResponse() " + count);
                        mEventHandler.data(buf, count);
                        count = 0;
                    } //End block
                } //End block
            } //End block
            catch (EOFException e)
            {
                if(count > 0)                
                {
                    mEventHandler.data(buf, count);
                } //End block
                if(HttpLog.LOGV)                
                HttpLog.v( "readResponse() handling " + e);
            } //End block
            catch (IOException e)
            {
                if(statusCode == HttpStatus.SC_OK
                        || statusCode == HttpStatus.SC_PARTIAL_CONTENT)                
                {
                    if(supportPartialContent && count > 0)                    
                    {
                        mEventHandler.data(buf, count);
                    } //End block
                    e.addTaint(taint);
                    throw e;
                } //End block
            } //End block
            finally 
            {
                if(nis != null)                
                {
                    nis.close();
                } //End block
            } //End block
        } //End block
        mConnection.setCanPersist(entity, statusLine.getProtocolVersion(),
                header.getConnectionType());
        mEventHandler.endData();
        complete();
        if(HttpLog.LOGV)        
        HttpLog.v("Request.readResponse(): done " +
                                    mHost.getSchemeName() + "://" + getHostPort() + mPath);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    /**
     * Data will not be sent to or received from server after cancel()
     * call.  Does not close connection--use close() below for that.
     *
     * Called by RequestHandle from non-network thread
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.687 -0500", hash_original_method = "0703BC7E6FB4CF479DE68CDEB6E6E012", hash_generated_method = "4B6EC5FDAD794F7DFF50406E013371F9")
    
synchronized void cancel() {
        if (HttpLog.LOGV) {
            HttpLog.v("Request.cancel(): " + getUri());
        }

        // Ensure that the network thread is not blocked by a hanging request from WebCore to
        // pause the load.
        mLoadingPaused = false;
        notify();

        mCancelled = true;
        if (mConnection != null) {
            mConnection.cancel();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.689 -0500", hash_original_method = "512B3E32AEE990D1477AF1DD14A214E5", hash_generated_method = "632932A86D9A8B15AC1DAA7F9BBDA079")
    
String getHostPort() {
        String myScheme = mHost.getSchemeName();
        int myPort = mHost.getPort();

        // Only send port when we must... many servers can't deal with it
        if (myPort != 80 && myScheme.equals("http") ||
            myPort != 443 && myScheme.equals("https")) {
            return mHost.toHostString();
        } else {
            return mHost.getHostName();
        }
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.386 -0400", hash_original_method = "2DF65EB3016FC9C1BCED4852586E67B2", hash_generated_method = "1CD07FD701792A8833A6C0A8D18BE133")
     String getUri() {
        if(mProxyHost == null ||
            mHost.getSchemeName().equals("https"))        
        {
String var6AF672BCA4D9DB76D759DE4D6BEB1D5F_558262208 =             mPath;
            var6AF672BCA4D9DB76D759DE4D6BEB1D5F_558262208.addTaint(taint);
            return var6AF672BCA4D9DB76D759DE4D6BEB1D5F_558262208;
        } //End block
String var2C2774A4504CCD41056B65A992871E34_1015357335 =         mHost.getSchemeName() + "://" + getHostPort() + mPath;
        var2C2774A4504CCD41056B65A992871E34_1015357335.addTaint(taint);
        return var2C2774A4504CCD41056B65A992871E34_1015357335;
        // ---------- Original Method ----------
        //if (mProxyHost == null ||
            //mHost.getSchemeName().equals("https")) {
            //return mPath;
        //}
        //return mHost.getSchemeName() + "://" + getHostPort() + mPath;
    }

    /**
     * for debugging
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.693 -0500", hash_original_method = "260B42F8E7BEBB3ADC717EDEB2B728A2", hash_generated_method = "A34314B6DE7E4E9B624F3C7CC5F6B943")
    
public String toString() {
        return mPath;
    }


    /**
     * If this request has been sent once and failed, it must be reset
     * before it can be sent again.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.696 -0500", hash_original_method = "6782015769BAD3CE7033564D51D44773", hash_generated_method = "5F9D0864E5714EA6E374497F09D12465")
    
void reset() {
        /* clear content-length header */
        mHttpRequest.removeHeaders(CONTENT_LENGTH_HEADER);

        if (mBodyProvider != null) {
            try {
                mBodyProvider.reset();
            } catch (IOException ex) {
                if (HttpLog.LOGV) HttpLog.v(
                        "failed to reset body provider " +
                        getUri());
            }
            setBodyProvider(mBodyProvider, mBodyLength);
        }

        if (mReceivedBytes > 0) {
            // reset the fail count as we continue the request
            mFailCount = 0;
            // set the "Range" header to indicate that the retry will continue
            // instead of restarting the request
            HttpLog.v("*** Request.reset() to range:" + mReceivedBytes);
            mHttpRequest.setHeader("Range", "bytes=" + mReceivedBytes + "-");
        }
    }

    /**
     * Pause thread request completes.  Used for synchronous requests,
     * and testing
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.698 -0500", hash_original_method = "59F95FD933B02B7872449B124B2DE304", hash_generated_method = "59F95FD933B02B7872449B124B2DE304")
    
void waitUntilComplete() {
        synchronized (mClientResource) {
            try {
                if (HttpLog.LOGV) HttpLog.v("Request.waitUntilComplete()");
                mClientResource.wait();
                if (HttpLog.LOGV) HttpLog.v("Request.waitUntilComplete() done waiting");
            } catch (InterruptedException e) {
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.701 -0500", hash_original_method = "7B097BCF5E489C3DB5111F527714D27C", hash_generated_method = "7B097BCF5E489C3DB5111F527714D27C")
    
void complete() {
        synchronized (mClientResource) {
            mClientResource.notifyAll();
        }
    }

    /**
     * Supply an InputStream that provides the body of a request.  It's
     * not great that the caller must also provide the length of the data
     * returned by that InputStream, but the client needs to know up
     * front, and I'm not sure how to get this out of the InputStream
     * itself without a costly readthrough.  I'm not sure skip() would
     * do what we want.  If you know a better way, please let me know.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.706 -0500", hash_original_method = "270D8BA233306D6526BC7DEE9032A6D1", hash_generated_method = "8DDA10B9AFD52875FB60E681BAE21A29")
    
private void setBodyProvider(InputStream bodyProvider, int bodyLength) {
        if (!bodyProvider.markSupported()) {
            throw new IllegalArgumentException(
                    "bodyProvider must support mark()");
        }
        // Mark beginning of stream
        bodyProvider.mark(Integer.MAX_VALUE);

        ((BasicHttpEntityEnclosingRequest)mHttpRequest).setEntity(
                new InputStreamEntity(bodyProvider, bodyLength));
    }


    /**
     * Handles SSL error(s) on the way down from the user (the user
     * has already provided their feedback).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.708 -0500", hash_original_method = "9C3B106C5F2D1AB923C52530BB6B2461", hash_generated_method = "01C2FD017899B9334C1015E99D77DF22")
    
public void handleSslErrorResponse(boolean proceed) {
        HttpsConnection connection = (HttpsConnection)(mConnection);
        if (connection != null) {
            connection.restartConnection(proceed);
        }
    }

    /**
     * Helper: calls error() on eventhandler with appropriate message
     * This should not be called before the mConnection is set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:10.710 -0500", hash_original_method = "0F527F16FE7A8194B2376A18FA9A34FA", hash_generated_method = "0F527F16FE7A8194B2376A18FA9A34FA")
    
void error(int errorId, int resourceId) {
        mEventHandler.error(
                errorId,
                mConnection.mContext.getText(
                        resourceId).toString());
    }
}

