package android.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.370 -0400", hash_original_field = "3487E63080D45B4AAFB4C377AC2DEA9F", hash_generated_field = "48DBEFEB1D57D7425F34775E3B0822FD")

    EventHandler mEventHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.370 -0400", hash_original_field = "8FB9CEDC14BF8DE9558825242E11E275", hash_generated_field = "619FD7E303013DFEE90F58DA7C3DCACD")

    private Connection mConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.371 -0400", hash_original_field = "7B4C7CFF79A356F9722DB9C608943043", hash_generated_field = "00DCF501A850F291B81138270DDF7D4D")

    BasicHttpRequest mHttpRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.371 -0400", hash_original_field = "FB4FCB3508FC66D4E3F113990AC335C6", hash_generated_field = "1D4D0FAE668EECF10ED75DDC284FFC16")

    String mPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.371 -0400", hash_original_field = "AE3E518F8FFDE1F8C00699B4C58E95B5", hash_generated_field = "BB62408D38B8CFFE64423F7A37FB51DF")

    HttpHost mHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.371 -0400", hash_original_field = "1E907E04A2E7F2CE11304EA1E7E477A6", hash_generated_field = "8D07AC44AA4C74B2AC6E6F002329824C")

    HttpHost mProxyHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.371 -0400", hash_original_field = "4966AE3B6048AEAF627C201F5D017994", hash_generated_field = "81F1F19F02DD71D9D08A9477DAAD695B")

    volatile boolean mCancelled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.371 -0400", hash_original_field = "3CDF2C9922C0EBD218A76414AB39040D", hash_generated_field = "5E66863F07F10B7287F0E997DBE9BDFD")

    int mFailCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.371 -0400", hash_original_field = "223160F850D9E5108687F104169D072B", hash_generated_field = "2DB8FB48C7810476C74FA592FABAE415")

    private int mReceivedBytes = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.371 -0400", hash_original_field = "183171F08ABB3787068B330DBA7E5900", hash_generated_field = "D18E2D3147EECBD8F566EDA75779DDA2")

    private InputStream mBodyProvider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.371 -0400", hash_original_field = "6CA3426B844BC585985128D50030D1F5", hash_generated_field = "DAA6C79DB8D209A54BE4FF4B04B63B6B")

    private int mBodyLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.371 -0400", hash_original_field = "790F1DE895020A396E4ABA2C1A1441CF", hash_generated_field = "58B1C220EAC61D22A66429CC428EF626")

    private final Object mClientResource = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.371 -0400", hash_original_field = "5366A0506AA87626770FD2FFC4E111E8", hash_generated_field = "E2A1F626EC5A40F2B6A741C8173B85D6")

    private boolean mLoadingPaused = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.373 -0400", hash_original_method = "E3AB2A1C4C118761EA0CC20D593A5A78", hash_generated_method = "59D67783F0B876F488AC9DCB4A2E3D9B")
      Request(String method, HttpHost host, HttpHost proxyHost, String path,
            InputStream bodyProvider, int bodyLength,
            EventHandler eventHandler,
            Map<String, String> headers) {
        addTaint(headers.getTaint());
        mEventHandler = eventHandler;
        mHost = host;
        mProxyHost = proxyHost;
        mPath = path;
        mBodyProvider = bodyProvider;
        mBodyLength = bodyLength;
        if(bodyProvider == null && !"POST".equalsIgnoreCase(method))        
        {
            mHttpRequest = new BasicHttpRequest(method, getUri());
        } //End block
        else
        {
            mHttpRequest = new BasicHttpEntityEnclosingRequest(
                    method, getUri());
            if(bodyProvider != null)            
            {
                setBodyProvider(bodyProvider, bodyLength);
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.375 -0400", hash_original_method = "E8032EBF304EE392C16172EA55A4B7FA", hash_generated_method = "55714596E4900A973666532455CD2BDB")
    synchronized void setLoadingPaused(boolean pause) {
        mLoadingPaused = pause;
        if(!mLoadingPaused)        
        {
            notify();
        } //End block
        // ---------- Original Method ----------
        //mLoadingPaused = pause;
        //if (!mLoadingPaused) {
            //notify();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.376 -0400", hash_original_method = "A8C7471D7BEF79EC71A4F8B9C611F231", hash_generated_method = "D70D1983B2F9D3329EE3C868A7734833")
     void setConnection(Connection connection) {
        mConnection = connection;
        // ---------- Original Method ----------
        //mConnection = connection;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.377 -0400", hash_original_method = "1AA9C40DC41DAB952A0E5EA6B233F2D0", hash_generated_method = "BCF259BEAFB70FE43F8EBADCAD717117")
     EventHandler getEventHandler() {
EventHandler varCF4010B9A116F4E34696F65AB43D0CCB_32956586 =         mEventHandler;
        varCF4010B9A116F4E34696F65AB43D0CCB_32956586.addTaint(taint);
        return varCF4010B9A116F4E34696F65AB43D0CCB_32956586;
        // ---------- Original Method ----------
        //return mEventHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.377 -0400", hash_original_method = "CAFFB5BC78A2E3A526CF37E51EA3E6DA", hash_generated_method = "3EA488368753801172A6E5B301C89CF8")
     void addHeader(String name, String value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        if(name == null)        
        {
            String damage = "Null http header name";
            HttpLog.e(damage);
            NullPointerException varFA92B4E29571334CC61079E44EFA4AD1_202257638 = new NullPointerException(damage);
            varFA92B4E29571334CC61079E44EFA4AD1_202257638.addTaint(taint);
            throw varFA92B4E29571334CC61079E44EFA4AD1_202257638;
        } //End block
        if(value == null || value.length() == 0)        
        {
            String damage = "Null or empty value for header \"" + name + "\"";
            HttpLog.e(damage);
            RuntimeException varE85E314CD46B77D37F60F484A78A8A5C_1676440151 = new RuntimeException(damage);
            varE85E314CD46B77D37F60F484A78A8A5C_1676440151.addTaint(taint);
            throw varE85E314CD46B77D37F60F484A78A8A5C_1676440151;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.378 -0400", hash_original_method = "CAEF84F00E8BD676D33383FFEC6D862C", hash_generated_method = "A71BB8D106AAC0F29C8384DCC675876E")
     void addHeaders(Map<String, String> headers) {
        addTaint(headers.getTaint());
        if(headers == null)        
        {
            return;
        } //End block
        Entry<String, String> entry;
        Iterator<Entry<String, String>> i = headers.entrySet().iterator();
        while
(i.hasNext())        
        {
            entry = i.next();
            addHeader(entry.getKey(), entry.getValue());
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.384 -0400", hash_original_method = "0703BC7E6FB4CF479DE68CDEB6E6E012", hash_generated_method = "FF5F1C49381C06BDF2FEBB72EA2F3A85")
    synchronized void cancel() {
        if(HttpLog.LOGV)        
        {
            HttpLog.v("Request.cancel(): " + getUri());
        } //End block
        mLoadingPaused = false;
        notify();
        mCancelled = true;
        if(mConnection != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.385 -0400", hash_original_method = "512B3E32AEE990D1477AF1DD14A214E5", hash_generated_method = "95BD70D55B67C97DBF85473434F90F87")
     String getHostPort() {
        String myScheme = mHost.getSchemeName();
        int myPort = mHost.getPort();
        if(myPort != 80 && myScheme.equals("http") ||
            myPort != 443 && myScheme.equals("https"))        
        {
String var719157C550566AE4F0CB171308C01238_650355179 =             mHost.toHostString();
            var719157C550566AE4F0CB171308C01238_650355179.addTaint(taint);
            return var719157C550566AE4F0CB171308C01238_650355179;
        } //End block
        else
        {
String var2B41A99CBD069523F9E41DEBCE3F1511_1970408428 =             mHost.getHostName();
            var2B41A99CBD069523F9E41DEBCE3F1511_1970408428.addTaint(taint);
            return var2B41A99CBD069523F9E41DEBCE3F1511_1970408428;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.387 -0400", hash_original_method = "260B42F8E7BEBB3ADC717EDEB2B728A2", hash_generated_method = "4E437B6DDE4955018F791B6DF388ABD0")
    public String toString() {
String var6AF672BCA4D9DB76D759DE4D6BEB1D5F_410354574 =         mPath;
        var6AF672BCA4D9DB76D759DE4D6BEB1D5F_410354574.addTaint(taint);
        return var6AF672BCA4D9DB76D759DE4D6BEB1D5F_410354574;
        // ---------- Original Method ----------
        //return mPath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.388 -0400", hash_original_method = "6782015769BAD3CE7033564D51D44773", hash_generated_method = "376A64D371E1CE38CD00658A6C73F3AB")
     void reset() {
        mHttpRequest.removeHeaders(CONTENT_LENGTH_HEADER);
        if(mBodyProvider != null)        
        {
            try 
            {
                mBodyProvider.reset();
            } //End block
            catch (IOException ex)
            {
                if(HttpLog.LOGV)                
                HttpLog.v(
                        "failed to reset body provider " +
                        getUri());
            } //End block
            setBodyProvider(mBodyProvider, mBodyLength);
        } //End block
        if(mReceivedBytes > 0)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.389 -0400", hash_original_method = "59F95FD933B02B7872449B124B2DE304", hash_generated_method = "3718EA6DCCDFCE0041ABBFEA406F5E25")
     void waitUntilComplete() {
        synchronized
(mClientResource)        {
            try 
            {
                if(HttpLog.LOGV)                
                HttpLog.v("Request.waitUntilComplete()");
                mClientResource.wait();
                if(HttpLog.LOGV)                
                HttpLog.v("Request.waitUntilComplete() done waiting");
            } //End block
            catch (InterruptedException e)
            {
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.389 -0400", hash_original_method = "7B097BCF5E489C3DB5111F527714D27C", hash_generated_method = "59D02A266F3A325593BA747E740E5602")
     void complete() {
        synchronized
(mClientResource)        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.390 -0400", hash_original_method = "270D8BA233306D6526BC7DEE9032A6D1", hash_generated_method = "14BFBBF87FC0402B830A269407F65B24")
    private void setBodyProvider(InputStream bodyProvider, int bodyLength) {
        addTaint(bodyLength);
        addTaint(bodyProvider.getTaint());
        if(!bodyProvider.markSupported())        
        {
            IllegalArgumentException varE30D6564CB78D5819B9068266E219739_926982508 = new IllegalArgumentException(
                    "bodyProvider must support mark()");
            varE30D6564CB78D5819B9068266E219739_926982508.addTaint(taint);
            throw varE30D6564CB78D5819B9068266E219739_926982508;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.392 -0400", hash_original_method = "9C3B106C5F2D1AB923C52530BB6B2461", hash_generated_method = "19AA2F8D5D2E20A2426B532F2AEA81CD")
    public void handleSslErrorResponse(boolean proceed) {
        addTaint(proceed);
        HttpsConnection connection = (HttpsConnection)(mConnection);
        if(connection != null)        
        {
            connection.restartConnection(proceed);
        } //End block
        // ---------- Original Method ----------
        //HttpsConnection connection = (HttpsConnection)(mConnection);
        //if (connection != null) {
            //connection.restartConnection(proceed);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.392 -0400", hash_original_method = "0F527F16FE7A8194B2376A18FA9A34FA", hash_generated_method = "DE078C071E333CA06A1FA9CE57981F12")
     void error(int errorId, int resourceId) {
        addTaint(resourceId);
        addTaint(errorId);
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.392 -0400", hash_original_field = "BFF19C9941B7F24015025FEC47946FEC", hash_generated_field = "7B9DE3A4130C6C995D9A037F9150C7FA")

    private final static String HOST_HEADER = "Host";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.393 -0400", hash_original_field = "C71F5E74A25541DB9EC52BFA384BBA5A", hash_generated_field = "E84D9A59CAEF3BCC11F8F89244D21D5D")

    private final static String ACCEPT_ENCODING_HEADER = "Accept-Encoding";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.393 -0400", hash_original_field = "71793AFFDF5DE2856726717360EFD4CE", hash_generated_field = "A5FEF046E57453815489487A5ADC09DE")

    private final static String CONTENT_LENGTH_HEADER = "content-length";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.393 -0400", hash_original_field = "D2868735E1BE5A9FB84EF3C8D326145F", hash_generated_field = "F007AA5F14F6E3C18CB781D2C4A675C4")

    private static RequestContent requestContentProcessor = new RequestContent();
}

