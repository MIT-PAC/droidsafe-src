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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.874 -0400", hash_original_field = "3487E63080D45B4AAFB4C377AC2DEA9F", hash_generated_field = "48DBEFEB1D57D7425F34775E3B0822FD")

    EventHandler mEventHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.874 -0400", hash_original_field = "8FB9CEDC14BF8DE9558825242E11E275", hash_generated_field = "619FD7E303013DFEE90F58DA7C3DCACD")

    private Connection mConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.874 -0400", hash_original_field = "7B4C7CFF79A356F9722DB9C608943043", hash_generated_field = "00DCF501A850F291B81138270DDF7D4D")

    BasicHttpRequest mHttpRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.874 -0400", hash_original_field = "FB4FCB3508FC66D4E3F113990AC335C6", hash_generated_field = "1D4D0FAE668EECF10ED75DDC284FFC16")

    String mPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.874 -0400", hash_original_field = "AE3E518F8FFDE1F8C00699B4C58E95B5", hash_generated_field = "BB62408D38B8CFFE64423F7A37FB51DF")

    HttpHost mHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.874 -0400", hash_original_field = "1E907E04A2E7F2CE11304EA1E7E477A6", hash_generated_field = "8D07AC44AA4C74B2AC6E6F002329824C")

    HttpHost mProxyHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.874 -0400", hash_original_field = "4966AE3B6048AEAF627C201F5D017994", hash_generated_field = "81F1F19F02DD71D9D08A9477DAAD695B")

    volatile boolean mCancelled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.874 -0400", hash_original_field = "3CDF2C9922C0EBD218A76414AB39040D", hash_generated_field = "5E66863F07F10B7287F0E997DBE9BDFD")

    int mFailCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.874 -0400", hash_original_field = "223160F850D9E5108687F104169D072B", hash_generated_field = "2DB8FB48C7810476C74FA592FABAE415")

    private int mReceivedBytes = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.874 -0400", hash_original_field = "183171F08ABB3787068B330DBA7E5900", hash_generated_field = "D18E2D3147EECBD8F566EDA75779DDA2")

    private InputStream mBodyProvider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.875 -0400", hash_original_field = "6CA3426B844BC585985128D50030D1F5", hash_generated_field = "DAA6C79DB8D209A54BE4FF4B04B63B6B")

    private int mBodyLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.875 -0400", hash_original_field = "790F1DE895020A396E4ABA2C1A1441CF", hash_generated_field = "B401B4CED42C0B1A974E89B5E2058555")

    private Object mClientResource = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.875 -0400", hash_original_field = "5366A0506AA87626770FD2FFC4E111E8", hash_generated_field = "E2A1F626EC5A40F2B6A741C8173B85D6")

    private boolean mLoadingPaused = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.891 -0400", hash_original_method = "E3AB2A1C4C118761EA0CC20D593A5A78", hash_generated_method = "B88350A8DA57C8EA50E9CFD850450467")
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
        {
            boolean var8FEF9B847500F12DA238FAC239D37F37_2141791847 = (bodyProvider == null && !"POST".equalsIgnoreCase(method));
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
        addTaint(headers.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.892 -0400", hash_original_method = "E8032EBF304EE392C16172EA55A4B7FA", hash_generated_method = "28ECA01D6890B41AC46CFE47D170D534")
    synchronized void setLoadingPaused(boolean pause) {
        mLoadingPaused = pause;
        {
            notify();
        } //End block
        // ---------- Original Method ----------
        //mLoadingPaused = pause;
        //if (!mLoadingPaused) {
            //notify();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.909 -0400", hash_original_method = "A8C7471D7BEF79EC71A4F8B9C611F231", hash_generated_method = "D70D1983B2F9D3329EE3C868A7734833")
     void setConnection(Connection connection) {
        mConnection = connection;
        // ---------- Original Method ----------
        //mConnection = connection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.911 -0400", hash_original_method = "1AA9C40DC41DAB952A0E5EA6B233F2D0", hash_generated_method = "CDD74B741DB04A300BE02ECC0549372B")
     EventHandler getEventHandler() {
        EventHandler varB4EAC82CA7396A68D541C85D26508E83_480970721 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_480970721 = mEventHandler;
        varB4EAC82CA7396A68D541C85D26508E83_480970721.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_480970721;
        // ---------- Original Method ----------
        //return mEventHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.925 -0400", hash_original_method = "CAFFB5BC78A2E3A526CF37E51EA3E6DA", hash_generated_method = "9B4F40C8ED537909C4454AF38026948A")
     void addHeader(String name, String value) {
        {
            String damage;
            damage = "Null http header name";
            HttpLog.e(damage);
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException(damage);
        } //End block
        {
            boolean var1C990C48A6BCBB3DBB9FE63782A7F952_723824590 = (value == null || value.length() == 0);
            {
                String damage;
                damage = "Null or empty value for header \"" + name + "\"";
                HttpLog.e(damage);
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(damage);
            } //End block
        } //End collapsed parenthetic
        mHttpRequest.addHeader(name, value);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.927 -0400", hash_original_method = "CAEF84F00E8BD676D33383FFEC6D862C", hash_generated_method = "F6233289DABD0CFC60730C29CEC93F62")
     void addHeaders(Map<String, String> headers) {
        Entry<String, String> entry;
        Iterator<Entry<String, String>> i;
        i = headers.entrySet().iterator();
        {
            boolean var1611849CD1EE22EA22E4E7E3327E2E35_1990993112 = (i.hasNext());
            {
                entry = i.next();
                addHeader(entry.getKey(), entry.getValue());
            } //End block
        } //End collapsed parenthetic
        addTaint(headers.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.942 -0400", hash_original_method = "8B550870D8AB2316B065E1C79CBF1A12", hash_generated_method = "3E805AA5B486DC27E7217D73FBB0EB3C")
     void sendRequest(AndroidHttpClientConnection httpClientConnection) throws HttpException, IOException {
        {
            HttpLog.v("Request.sendRequest() " + mHost.getSchemeName() + "://" + getHostPort());
            {
                Iterator i;
                i = mHttpRequest.headerIterator();
                {
                    boolean var048C390D087BEDAABDA4F669A9DA628E_1691346361 = (i.hasNext());
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
        addTaint(httpClientConnection.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.984 -0400", hash_original_method = "77E4A14D27C62797F0A19B684369B7C4", hash_generated_method = "1BEC59857EF800C07C50132AD217A845")
     void readResponse(AndroidHttpClientConnection httpClientConnection) throws IOException, ParseException {
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
                    boolean var9F2E6DC3F5A6DFB92F317E36CE0E61D5_1328525447 = (contentEncoding != null &&
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
        addTaint(httpClientConnection.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.986 -0400", hash_original_method = "0703BC7E6FB4CF479DE68CDEB6E6E012", hash_generated_method = "FB6F6716432825E5A1B83371B2531B57")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.002 -0400", hash_original_method = "512B3E32AEE990D1477AF1DD14A214E5", hash_generated_method = "7346BBD647AA8B559DF4CEB0C5F957B7")
     String getHostPort() {
        String varB4EAC82CA7396A68D541C85D26508E83_1456695195 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_426938441 = null; //Variable for return #2
        String myScheme;
        myScheme = mHost.getSchemeName();
        int myPort;
        myPort = mHost.getPort();
        {
            boolean var8D6BF4CF9681D2015AABFC3D27024A3C_1699415271 = (myPort != 80 && myScheme.equals("http") ||
            myPort != 443 && myScheme.equals("https"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1456695195 = mHost.toHostString();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_426938441 = mHost.getHostName();
            } //End block
        } //End collapsed parenthetic
        String varA7E53CE21691AB073D9660D615818899_131298707; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_131298707 = varB4EAC82CA7396A68D541C85D26508E83_1456695195;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_131298707 = varB4EAC82CA7396A68D541C85D26508E83_426938441;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_131298707.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_131298707;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.024 -0400", hash_original_method = "2DF65EB3016FC9C1BCED4852586E67B2", hash_generated_method = "A936F22DF6807F065A93BDD342B27F7D")
     String getUri() {
        String varB4EAC82CA7396A68D541C85D26508E83_2139955643 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_286062254 = null; //Variable for return #2
        {
            boolean varC80F30B1906E6F9A7B5768A93265E704_1907889041 = (mProxyHost == null ||
            mHost.getSchemeName().equals("https"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_2139955643 = mPath;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_286062254 = mHost.getSchemeName() + "://" + getHostPort() + mPath;
        String varA7E53CE21691AB073D9660D615818899_2136453626; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2136453626 = varB4EAC82CA7396A68D541C85D26508E83_2139955643;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2136453626 = varB4EAC82CA7396A68D541C85D26508E83_286062254;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2136453626.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2136453626;
        // ---------- Original Method ----------
        //if (mProxyHost == null ||
            //mHost.getSchemeName().equals("https")) {
            //return mPath;
        //}
        //return mHost.getSchemeName() + "://" + getHostPort() + mPath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.024 -0400", hash_original_method = "260B42F8E7BEBB3ADC717EDEB2B728A2", hash_generated_method = "98C93C10C30D4C30B5C5D33FF92EE0A6")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2073997834 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2073997834 = mPath;
        varB4EAC82CA7396A68D541C85D26508E83_2073997834.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2073997834;
        // ---------- Original Method ----------
        //return mPath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.026 -0400", hash_original_method = "6782015769BAD3CE7033564D51D44773", hash_generated_method = "C9F2DA436C0B9B6A2A8251A84572C8DC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.057 -0400", hash_original_method = "59F95FD933B02B7872449B124B2DE304", hash_generated_method = "A697D85C9FD075294ED849C7A4FB2683")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.058 -0400", hash_original_method = "7B097BCF5E489C3DB5111F527714D27C", hash_generated_method = "5985E11E937D3B36C1FE673E3527F219")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.070 -0400", hash_original_method = "270D8BA233306D6526BC7DEE9032A6D1", hash_generated_method = "EA63279040D31B5B239A2FAC6F4E9FE4")
    private void setBodyProvider(InputStream bodyProvider, int bodyLength) {
        {
            boolean var23FBFF8990744E2A5380230AC0A31086_1587490629 = (!bodyProvider.markSupported());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "bodyProvider must support mark()");
            } //End block
        } //End collapsed parenthetic
        bodyProvider.mark(Integer.MAX_VALUE);
        ((BasicHttpEntityEnclosingRequest)mHttpRequest).setEntity(
                new InputStreamEntity(bodyProvider, bodyLength));
        addTaint(bodyProvider.getTaint());
        addTaint(bodyLength);
        // ---------- Original Method ----------
        //if (!bodyProvider.markSupported()) {
            //throw new IllegalArgumentException(
                    //"bodyProvider must support mark()");
        //}
        //bodyProvider.mark(Integer.MAX_VALUE);
        //((BasicHttpEntityEnclosingRequest)mHttpRequest).setEntity(
                //new InputStreamEntity(bodyProvider, bodyLength));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.080 -0400", hash_original_method = "9C3B106C5F2D1AB923C52530BB6B2461", hash_generated_method = "367A87428CA952BF5830097F01239AC1")
    public void handleSslErrorResponse(boolean proceed) {
        HttpsConnection connection;
        connection = (HttpsConnection)(mConnection);
        {
            connection.restartConnection(proceed);
        } //End block
        addTaint(proceed);
        // ---------- Original Method ----------
        //HttpsConnection connection = (HttpsConnection)(mConnection);
        //if (connection != null) {
            //connection.restartConnection(proceed);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.081 -0400", hash_original_method = "0F527F16FE7A8194B2376A18FA9A34FA", hash_generated_method = "DE75C0955107B3D6E5FD6DCCC0F32142")
     void error(int errorId, int resourceId) {
        mEventHandler.error(
                errorId,
                mConnection.mContext.getText(
                        resourceId).toString());
        addTaint(errorId);
        addTaint(resourceId);
        // ---------- Original Method ----------
        //mEventHandler.error(
                //errorId,
                //mConnection.mContext.getText(
                        //resourceId).toString());
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.082 -0400", hash_original_field = "BFF19C9941B7F24015025FEC47946FEC", hash_generated_field = "14E134A3BDEA3B170AF4FFC4D769BC8C")

    private static String HOST_HEADER = "Host";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.082 -0400", hash_original_field = "C71F5E74A25541DB9EC52BFA384BBA5A", hash_generated_field = "982EA3A4C6BFC4ECCCA440A878E57C4E")

    private static String ACCEPT_ENCODING_HEADER = "Accept-Encoding";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.082 -0400", hash_original_field = "71793AFFDF5DE2856726717360EFD4CE", hash_generated_field = "EBDD66FEBECEED7F0E3AE2D1E53C8040")

    private static String CONTENT_LENGTH_HEADER = "content-length";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.082 -0400", hash_original_field = "D2868735E1BE5A9FB84EF3C8D326145F", hash_generated_field = "F007AA5F14F6E3C18CB781D2C4A675C4")

    private static RequestContent requestContentProcessor = new RequestContent();
}

