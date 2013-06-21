package android.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.EOFException;
import java.io.InputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.Header;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.protocol.RequestContent;

class Request {
    EventHandler mEventHandler;
    private Connection mConnection;
    BasicHttpRequest mHttpRequest;
    String mPath;
    HttpHost mHost;
    HttpHost mProxyHost;
    volatile boolean mCancelled = false;
    int mFailCount = 0;
    private int mReceivedBytes = 0;
    private InputStream mBodyProvider;
    private int mBodyLength;
    private Object mClientResource = new Object();
    private boolean mLoadingPaused = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.946 -0400", hash_original_method = "E3AB2A1C4C118761EA0CC20D593A5A78", hash_generated_method = "2EDAF8EDFA938CE8670FCF41A7F5F552")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Request(String method, HttpHost host, HttpHost proxyHost, String path,
            InputStream bodyProvider, int bodyLength,
            EventHandler eventHandler,
            Map<String, String> headers) {
        dsTaint.addTaint(headers.dsTaint);
        dsTaint.addTaint(eventHandler.dsTaint);
        dsTaint.addTaint(bodyProvider.dsTaint);
        dsTaint.addTaint(host.dsTaint);
        dsTaint.addTaint(proxyHost.dsTaint);
        dsTaint.addTaint(bodyLength);
        dsTaint.addTaint(path);
        dsTaint.addTaint(method);
        {
            boolean var8FEF9B847500F12DA238FAC239D37F37_2046567659 = (bodyProvider == null && !"POST".equalsIgnoreCase(method));
            {
                mHttpRequest = new BasicHttpRequest(method, getUri());
            } //End block
            {
                mHttpRequest = new BasicHttpEntityEnclosingRequest(
                    method, getUri());
                {
                    setBodyProvider(bodyProvider, bodyLength);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addHeader(HOST_HEADER, getHostPort());
        addHeader(ACCEPT_ENCODING_HEADER, "gzip");
        addHeaders(headers);
        // ---------- Original Method ----------
        //mEventHandler = eventHandler;
        //mHost = host;
        //mProxyHost = proxyHost;
        //mPath = path;
        //mBodyProvider = bodyProvider;
        //mBodyLength = bodyLength;
        //if (bodyProvider == null && !"POST".equalsIgnoreCase(method)) {
            //mHttpRequest = new BasicHttpRequest(method, getUri());
        //} else {
            //mHttpRequest = new BasicHttpEntityEnclosingRequest(
                    //method, getUri());
            //if (bodyProvider != null) {
                //setBodyProvider(bodyProvider, bodyLength);
            //}
        //}
        //addHeader(HOST_HEADER, getHostPort());
        //addHeader(ACCEPT_ENCODING_HEADER, "gzip");
        //addHeaders(headers);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.947 -0400", hash_original_method = "E8032EBF304EE392C16172EA55A4B7FA", hash_generated_method = "AED0D881A814A673DAC9193929193A44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void setLoadingPaused(boolean pause) {
        dsTaint.addTaint(pause);
        {
            notify();
        } //End block
        // ---------- Original Method ----------
        //mLoadingPaused = pause;
        //if (!mLoadingPaused) {
            //notify();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.947 -0400", hash_original_method = "A8C7471D7BEF79EC71A4F8B9C611F231", hash_generated_method = "A7139E53E3FCB8AC5BABCCD188E76293")
    @DSModeled(DSC.SAFE)
     void setConnection(Connection connection) {
        dsTaint.addTaint(connection.dsTaint);
        // ---------- Original Method ----------
        //mConnection = connection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.947 -0400", hash_original_method = "1AA9C40DC41DAB952A0E5EA6B233F2D0", hash_generated_method = "0CB743BA6E02B05AFB01888A684439B1")
    @DSModeled(DSC.SAFE)
     EventHandler getEventHandler() {
        return (EventHandler)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mEventHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.947 -0400", hash_original_method = "CAFFB5BC78A2E3A526CF37E51EA3E6DA", hash_generated_method = "AEF4232521AC9EE358C39B1B0B88E17E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void addHeader(String name, String value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            String damage;
            damage = "Null http header name";
            HttpLog.e(damage);
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException(damage);
        } //End block
        {
            boolean var1C990C48A6BCBB3DBB9FE63782A7F952_1802335475 = (value == null || value.length() == 0);
            {
                String damage;
                damage = "Null or empty value for header \"" + name + "\"";
                HttpLog.e(damage);
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(damage);
            } //End block
        } //End collapsed parenthetic
        mHttpRequest.addHeader(name, value);
        // ---------- Original Method ----------
        //if (name == null) {
            //String damage = "Null http header name";
            //HttpLog.e(damage);
            //throw new NullPointerException(damage);
        //}
        //if (value == null || value.length() == 0) {
            //String damage = "Null or empty value for header \"" + name + "\"";
            //HttpLog.e(damage);
            //throw new RuntimeException(damage);
        //}
        //mHttpRequest.addHeader(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.948 -0400", hash_original_method = "CAEF84F00E8BD676D33383FFEC6D862C", hash_generated_method = "B84FD46A6F1AEA0E9472875E61ACF3EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void addHeaders(Map<String, String> headers) {
        dsTaint.addTaint(headers.dsTaint);
        Entry<String, String> entry;
        Iterator<Entry<String, String>> i;
        i = headers.entrySet().iterator();
        {
            boolean var1611849CD1EE22EA22E4E7E3327E2E35_477097509 = (i.hasNext());
            {
                entry = i.next();
                addHeader(entry.getKey(), entry.getValue());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (headers == null) {
            //return;
        //}
        //Entry<String, String> entry;
        //Iterator<Entry<String, String>> i = headers.entrySet().iterator();
        //while (i.hasNext()) {
            //entry = i.next();
            //addHeader(entry.getKey(), entry.getValue());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.948 -0400", hash_original_method = "8B550870D8AB2316B065E1C79CBF1A12", hash_generated_method = "CBB96692455FD013B4BA9D47A4358744")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void sendRequest(AndroidHttpClientConnection httpClientConnection) throws HttpException, IOException {
        dsTaint.addTaint(httpClientConnection.dsTaint);
        {
            HttpLog.v("Request.sendRequest() " + mHost.getSchemeName() + "://" + getHostPort());
            {
                Iterator i;
                i = mHttpRequest.headerIterator();
                {
                    boolean var048C390D087BEDAABDA4F669A9DA628E_107715456 = (i.hasNext());
                    {
                        Header header;
                        header = (Header)i.next();
                        HttpLog.v(header.getName() + ": " + header.getValue());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        requestContentProcessor.process(mHttpRequest,
                                        mConnection.getHttpContext());
        httpClientConnection.sendRequestHeader(mHttpRequest);
        {
            httpClientConnection.sendRequestEntity(
                    (HttpEntityEnclosingRequest) mHttpRequest);
        } //End block
        {
            HttpLog.v("Request.requestSent() " + mHost.getSchemeName() + "://" + getHostPort() + mPath);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.949 -0400", hash_original_method = "77E4A14D27C62797F0A19B684369B7C4", hash_generated_method = "11234EF4036B15F8E5D1E431D100A456")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void readResponse(AndroidHttpClientConnection httpClientConnection) throws IOException, ParseException {
        dsTaint.addTaint(httpClientConnection.dsTaint);
        StatusLine statusLine;
        statusLine = null;
        boolean hasBody;
        hasBody = false;
        httpClientConnection.flush();
        int statusCode;
        statusCode = 0;
        Headers header;
        header = new Headers();
        {
            statusLine = httpClientConnection.parseResponseHeader(header);
            statusCode = statusLine.getStatusCode();
        } //End block
        HttpLog.v(
                "Request.readResponseStatus() " +
                statusLine.toString().length() + " " + statusLine);
        ProtocolVersion v;
        v = statusLine.getProtocolVersion();
        mEventHandler.status(v.getMajor(), v.getMinor(),
                statusCode, statusLine.getReasonPhrase());
        mEventHandler.headers(header);
        HttpEntity entity;
        entity = null;
        hasBody = canResponseHaveBody(mHttpRequest, statusCode);
        entity = httpClientConnection.receiveResponseEntity(header);
        boolean supportPartialContent;
        supportPartialContent = "bytes".equalsIgnoreCase(header
                .getAcceptRanges());
        {
            InputStream is;
            is = entity.getContent();
            Header contentEncoding;
            contentEncoding = entity.getContentEncoding();
            InputStream nis;
            nis = null;
            byte[] buf;
            buf = null;
            int count;
            count = 0;
            try 
            {
                {
                    boolean var9F2E6DC3F5A6DFB92F317E36CE0E61D5_176677525 = (contentEncoding != null &&
                    contentEncoding.getValue().equals("gzip"));
                    {
                        nis = new GZIPInputStream(is);
                    } //End block
                    {
                        nis = is;
                    } //End block
                } //End collapsed parenthetic
                buf = mConnection.getBuf();
                int len;
                len = 0;
                int lowWater;
                lowWater = buf.length / 2;
                {
                    {
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
                    {
                        count += len;
                        mReceivedBytes += len;
                    } //End block
                    {
                        HttpLog.v("Request.readResponse() " + count);
                        mEventHandler.data(buf, count);
                        count = 0;
                    } //End block
                } //End block
            } //End block
            catch (EOFException e)
            {
                {
                    mEventHandler.data(buf, count);
                } //End block
                HttpLog.v( "readResponse() handling " + e);
            } //End block
            catch (IOException e)
            {
                {
                    {
                        mEventHandler.data(buf, count);
                    } //End block
                    if (DroidSafeAndroidRuntime.control) throw e;
                } //End block
            } //End block
            finally 
            {
                {
                    nis.close();
                } //End block
            } //End block
        } //End block
        mConnection.setCanPersist(entity, statusLine.getProtocolVersion(),
                header.getConnectionType());
        mEventHandler.endData();
        complete();
        HttpLog.v("Request.readResponse(): done " +
                                    mHost.getSchemeName() + "://" + getHostPort() + mPath);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.950 -0400", hash_original_method = "0703BC7E6FB4CF479DE68CDEB6E6E012", hash_generated_method = "FB6F6716432825E5A1B83371B2531B57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void cancel() {
        {
            HttpLog.v("Request.cancel(): " + getUri());
        } //End block
        mLoadingPaused = false;
        notify();
        mCancelled = true;
        {
            mConnection.cancel();
        } //End block
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) {
            //HttpLog.v("Request.cancel(): " + getUri());
        //}
        //mLoadingPaused = false;
        //notify();
        //mCancelled = true;
        //if (mConnection != null) {
            //mConnection.cancel();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.950 -0400", hash_original_method = "512B3E32AEE990D1477AF1DD14A214E5", hash_generated_method = "E3D00213F3C6E6DB912DE9894C3F9D08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String getHostPort() {
        String myScheme;
        myScheme = mHost.getSchemeName();
        int myPort;
        myPort = mHost.getPort();
        {
            boolean var8D6BF4CF9681D2015AABFC3D27024A3C_1811874696 = (myPort != 80 && myScheme.equals("http") ||
            myPort != 443 && myScheme.equals("https"));
            {
                String varCCCFB72755D8E68A1197A6E04EE91F35_1727359258 = (mHost.toHostString());
            } //End block
            {
                String varE53275AC4D48884C30677D10FE31A8A9_522125893 = (mHost.getHostName());
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String myScheme = mHost.getSchemeName();
        //int myPort = mHost.getPort();
        //if (myPort != 80 && myScheme.equals("http") ||
            //myPort != 443 && myScheme.equals("https")) {
            //return mHost.toHostString();
        //} else {
            //return mHost.getHostName();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.951 -0400", hash_original_method = "2DF65EB3016FC9C1BCED4852586E67B2", hash_generated_method = "9BC210E0EBDA4464AD2BB3C5AF30954F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String getUri() {
        {
            boolean varC80F30B1906E6F9A7B5768A93265E704_214450311 = (mProxyHost == null ||
            mHost.getSchemeName().equals("https"));
        } //End collapsed parenthetic
        String varEB19532411BE264909A2EF74C03FC8C6_540533763 = (mHost.getSchemeName() + "://" + getHostPort() + mPath);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (mProxyHost == null ||
            //mHost.getSchemeName().equals("https")) {
            //return mPath;
        //}
        //return mHost.getSchemeName() + "://" + getHostPort() + mPath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.951 -0400", hash_original_method = "260B42F8E7BEBB3ADC717EDEB2B728A2", hash_generated_method = "B2B21D2AFC772A812376138B07721793")
    @DSModeled(DSC.SAFE)
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.951 -0400", hash_original_method = "6782015769BAD3CE7033564D51D44773", hash_generated_method = "C9F2DA436C0B9B6A2A8251A84572C8DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void reset() {
        mHttpRequest.removeHeaders(CONTENT_LENGTH_HEADER);
        {
            try 
            {
                mBodyProvider.reset();
            } //End block
            catch (IOException ex)
            {
                HttpLog.v(
                        "failed to reset body provider " +
                        getUri());
            } //End block
            setBodyProvider(mBodyProvider, mBodyLength);
        } //End block
        {
            mFailCount = 0;
            HttpLog.v("*** Request.reset() to range:" + mReceivedBytes);
            mHttpRequest.setHeader("Range", "bytes=" + mReceivedBytes + "-");
        } //End block
        // ---------- Original Method ----------
        //mHttpRequest.removeHeaders(CONTENT_LENGTH_HEADER);
        //if (mBodyProvider != null) {
            //try {
                //mBodyProvider.reset();
            //} catch (IOException ex) {
                //if (HttpLog.LOGV) HttpLog.v(
                        //"failed to reset body provider " +
                        //getUri());
            //}
            //setBodyProvider(mBodyProvider, mBodyLength);
        //}
        //if (mReceivedBytes > 0) {
            //mFailCount = 0;
            //HttpLog.v("*** Request.reset() to range:" + mReceivedBytes);
            //mHttpRequest.setHeader("Range", "bytes=" + mReceivedBytes + "-");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.952 -0400", hash_original_method = "59F95FD933B02B7872449B124B2DE304", hash_generated_method = "A697D85C9FD075294ED849C7A4FB2683")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void waitUntilComplete() {
        {
            try 
            {
                HttpLog.v("Request.waitUntilComplete()");
                mClientResource.wait();
                HttpLog.v("Request.waitUntilComplete() done waiting");
            } //End block
            catch (InterruptedException e)
            { }
        } //End block
        // ---------- Original Method ----------
        //synchronized (mClientResource) {
            //try {
                //if (HttpLog.LOGV) HttpLog.v("Request.waitUntilComplete()");
                //mClientResource.wait();
                //if (HttpLog.LOGV) HttpLog.v("Request.waitUntilComplete() done waiting");
            //} catch (InterruptedException e) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.952 -0400", hash_original_method = "7B097BCF5E489C3DB5111F527714D27C", hash_generated_method = "5985E11E937D3B36C1FE673E3527F219")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void complete() {
        {
            mClientResource.notifyAll();
        } //End block
        // ---------- Original Method ----------
        //synchronized (mClientResource) {
            //mClientResource.notifyAll();
        //}
    }

    
        private static boolean canResponseHaveBody(final HttpRequest request,
                                               final int status) {
        if ("HEAD".equalsIgnoreCase(request.getRequestLine().getMethod())) {
            return false;
        }
        return status >= HttpStatus.SC_OK
            && status != HttpStatus.SC_NO_CONTENT
            && status != HttpStatus.SC_NOT_MODIFIED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.953 -0400", hash_original_method = "270D8BA233306D6526BC7DEE9032A6D1", hash_generated_method = "F006F15AB79A9D66F175A16EC631AC64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setBodyProvider(InputStream bodyProvider, int bodyLength) {
        dsTaint.addTaint(bodyProvider.dsTaint);
        dsTaint.addTaint(bodyLength);
        {
            boolean var23FBFF8990744E2A5380230AC0A31086_24469689 = (!bodyProvider.markSupported());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "bodyProvider must support mark()");
            } //End block
        } //End collapsed parenthetic
        bodyProvider.mark(Integer.MAX_VALUE);
        ((BasicHttpEntityEnclosingRequest)mHttpRequest).setEntity(
                new InputStreamEntity(bodyProvider, bodyLength));
        // ---------- Original Method ----------
        //if (!bodyProvider.markSupported()) {
            //throw new IllegalArgumentException(
                    //"bodyProvider must support mark()");
        //}
        //bodyProvider.mark(Integer.MAX_VALUE);
        //((BasicHttpEntityEnclosingRequest)mHttpRequest).setEntity(
                //new InputStreamEntity(bodyProvider, bodyLength));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.953 -0400", hash_original_method = "9C3B106C5F2D1AB923C52530BB6B2461", hash_generated_method = "EFB6FE4310225A56D0AF9118F849CF12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void handleSslErrorResponse(boolean proceed) {
        dsTaint.addTaint(proceed);
        HttpsConnection connection;
        connection = (HttpsConnection)(mConnection);
        {
            connection.restartConnection(proceed);
        } //End block
        // ---------- Original Method ----------
        //HttpsConnection connection = (HttpsConnection)(mConnection);
        //if (connection != null) {
            //connection.restartConnection(proceed);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.954 -0400", hash_original_method = "0F527F16FE7A8194B2376A18FA9A34FA", hash_generated_method = "788DA4B61F51A33A0F8B6A9E0A8CCFB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void error(int errorId, int resourceId) {
        dsTaint.addTaint(resourceId);
        dsTaint.addTaint(errorId);
        mEventHandler.error(
                errorId,
                mConnection.mContext.getText(
                        resourceId).toString());
        // ---------- Original Method ----------
        //mEventHandler.error(
                //errorId,
                //mConnection.mContext.getText(
                        //resourceId).toString());
    }

    
    private final static String HOST_HEADER = "Host";
    private final static String ACCEPT_ENCODING_HEADER = "Accept-Encoding";
    private final static String CONTENT_LENGTH_HEADER = "content-length";
    private static RequestContent requestContentProcessor =
            new RequestContent();
}

