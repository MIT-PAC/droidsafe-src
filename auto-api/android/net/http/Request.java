package android.net.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.112 -0400", hash_original_field = "3487E63080D45B4AAFB4C377AC2DEA9F", hash_generated_field = "48DBEFEB1D57D7425F34775E3B0822FD")

    EventHandler mEventHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.112 -0400", hash_original_field = "8FB9CEDC14BF8DE9558825242E11E275", hash_generated_field = "619FD7E303013DFEE90F58DA7C3DCACD")

    private Connection mConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.112 -0400", hash_original_field = "7B4C7CFF79A356F9722DB9C608943043", hash_generated_field = "00DCF501A850F291B81138270DDF7D4D")

    BasicHttpRequest mHttpRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.112 -0400", hash_original_field = "FB4FCB3508FC66D4E3F113990AC335C6", hash_generated_field = "1D4D0FAE668EECF10ED75DDC284FFC16")

    String mPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.112 -0400", hash_original_field = "AE3E518F8FFDE1F8C00699B4C58E95B5", hash_generated_field = "BB62408D38B8CFFE64423F7A37FB51DF")

    HttpHost mHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.112 -0400", hash_original_field = "1E907E04A2E7F2CE11304EA1E7E477A6", hash_generated_field = "8D07AC44AA4C74B2AC6E6F002329824C")

    HttpHost mProxyHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.112 -0400", hash_original_field = "4966AE3B6048AEAF627C201F5D017994", hash_generated_field = "81F1F19F02DD71D9D08A9477DAAD695B")

    volatile boolean mCancelled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.112 -0400", hash_original_field = "3CDF2C9922C0EBD218A76414AB39040D", hash_generated_field = "5E66863F07F10B7287F0E997DBE9BDFD")

    int mFailCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.112 -0400", hash_original_field = "223160F850D9E5108687F104169D072B", hash_generated_field = "2DB8FB48C7810476C74FA592FABAE415")

    private int mReceivedBytes = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.112 -0400", hash_original_field = "183171F08ABB3787068B330DBA7E5900", hash_generated_field = "D18E2D3147EECBD8F566EDA75779DDA2")

    private InputStream mBodyProvider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.112 -0400", hash_original_field = "6CA3426B844BC585985128D50030D1F5", hash_generated_field = "DAA6C79DB8D209A54BE4FF4B04B63B6B")

    private int mBodyLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.112 -0400", hash_original_field = "790F1DE895020A396E4ABA2C1A1441CF", hash_generated_field = "58B1C220EAC61D22A66429CC428EF626")

    private final Object mClientResource = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.112 -0400", hash_original_field = "5366A0506AA87626770FD2FFC4E111E8", hash_generated_field = "E2A1F626EC5A40F2B6A741C8173B85D6")

    private boolean mLoadingPaused = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.113 -0400", hash_original_method = "E3AB2A1C4C118761EA0CC20D593A5A78", hash_generated_method = "2B61A9A4B72C031B4FC0D9A4CBBF3196")
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
            boolean var8FEF9B847500F12DA238FAC239D37F37_1209531258 = (bodyProvider == null && !"POST".equalsIgnoreCase(method));
            {
                mHttpRequest = new BasicHttpRequest(method, getUri());
            } 
            {
                mHttpRequest = new BasicHttpEntityEnclosingRequest(
                    method, getUri());
                {
                    setBodyProvider(bodyProvider, bodyLength);
                } 
            } 
        } 
        addHeader(HOST_HEADER, getHostPort());
        addHeader(ACCEPT_ENCODING_HEADER, "gzip");
        addHeaders(headers);
        addTaint(headers.getTaint());
        
        
        
        
        
        
        
        
            
        
            
                    
            
                
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.114 -0400", hash_original_method = "E8032EBF304EE392C16172EA55A4B7FA", hash_generated_method = "28ECA01D6890B41AC46CFE47D170D534")
    synchronized void setLoadingPaused(boolean pause) {
        mLoadingPaused = pause;
        {
            notify();
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.114 -0400", hash_original_method = "A8C7471D7BEF79EC71A4F8B9C611F231", hash_generated_method = "D70D1983B2F9D3329EE3C868A7734833")
     void setConnection(Connection connection) {
        mConnection = connection;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.115 -0400", hash_original_method = "1AA9C40DC41DAB952A0E5EA6B233F2D0", hash_generated_method = "C3655118FE20F715AC5D7D3B41B2255E")
     EventHandler getEventHandler() {
        EventHandler varB4EAC82CA7396A68D541C85D26508E83_1456895119 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1456895119 = mEventHandler;
        varB4EAC82CA7396A68D541C85D26508E83_1456895119.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1456895119;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.116 -0400", hash_original_method = "CAFFB5BC78A2E3A526CF37E51EA3E6DA", hash_generated_method = "C21C6A340CC257D56D8230288652EE18")
     void addHeader(String name, String value) {
        {
            String damage = "Null http header name";
            HttpLog.e(damage);
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException(damage);
        } 
        {
            boolean var1C990C48A6BCBB3DBB9FE63782A7F952_1393682092 = (value == null || value.length() == 0);
            {
                String damage = "Null or empty value for header \"" + name + "\"";
                HttpLog.e(damage);
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(damage);
            } 
        } 
        mHttpRequest.addHeader(name, value);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        
        
            
            
            
        
        
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.117 -0400", hash_original_method = "CAEF84F00E8BD676D33383FFEC6D862C", hash_generated_method = "42AF8C19F50CF6CE90B39256CF5A7934")
     void addHeaders(Map<String, String> headers) {
        Entry<String, String> entry;
        Iterator<Entry<String, String>> i = headers.entrySet().iterator();
        {
            boolean var1611849CD1EE22EA22E4E7E3327E2E35_1143390777 = (i.hasNext());
            {
                entry = i.next();
                addHeader(entry.getKey(), entry.getValue());
            } 
        } 
        addTaint(headers.getTaint());
        
        
            
        
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.117 -0400", hash_original_method = "8B550870D8AB2316B065E1C79CBF1A12", hash_generated_method = "33E0CBCE56CC78FD02B123C3B00AE6D4")
     void sendRequest(AndroidHttpClientConnection httpClientConnection) throws HttpException, IOException {
        {
            HttpLog.v("Request.sendRequest() " + mHost.getSchemeName() + "://" + getHostPort());
            {
                Iterator i = mHttpRequest.headerIterator();
                {
                    boolean var048C390D087BEDAABDA4F669A9DA628E_1495101232 = (i.hasNext());
                    {
                        Header header = (Header)i.next();
                        HttpLog.v(header.getName() + ": " + header.getValue());
                    } 
                } 
            } 
        } 
        requestContentProcessor.process(mHttpRequest,
                                        mConnection.getHttpContext());
        httpClientConnection.sendRequestHeader(mHttpRequest);
        {
            httpClientConnection.sendRequestEntity(
                    (HttpEntityEnclosingRequest) mHttpRequest);
        } 
        {
            HttpLog.v("Request.requestSent() " + mHost.getSchemeName() + "://" + getHostPort() + mPath);
        } 
        addTaint(httpClientConnection.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.119 -0400", hash_original_method = "77E4A14D27C62797F0A19B684369B7C4", hash_generated_method = "7F5068D2C7A994C784ABCB5C348EF9B7")
     void readResponse(AndroidHttpClientConnection httpClientConnection) throws IOException, ParseException {
        StatusLine statusLine = null;
        boolean hasBody = false;
        httpClientConnection.flush();
        int statusCode = 0;
        Headers header = new Headers();
        {
            statusLine = httpClientConnection.parseResponseHeader(header);
            statusCode = statusLine.getStatusCode();
        } 
        HttpLog.v(
                "Request.readResponseStatus() " +
                statusLine.toString().length() + " " + statusLine);
        ProtocolVersion v = statusLine.getProtocolVersion();
        mEventHandler.status(v.getMajor(), v.getMinor(),
                statusCode, statusLine.getReasonPhrase());
        mEventHandler.headers(header);
        HttpEntity entity = null;
        hasBody = canResponseHaveBody(mHttpRequest, statusCode);
        entity = httpClientConnection.receiveResponseEntity(header);
        boolean supportPartialContent = "bytes".equalsIgnoreCase(header
                .getAcceptRanges());
        {
            InputStream is = entity.getContent();
            Header contentEncoding = entity.getContentEncoding();
            InputStream nis = null;
            byte[] buf = null;
            int count = 0;
            try 
            {
                {
                    boolean var9F2E6DC3F5A6DFB92F317E36CE0E61D5_1939798073 = (contentEncoding != null &&
                    contentEncoding.getValue().equals("gzip"));
                    {
                        nis = new GZIPInputStream(is);
                    } 
                    {
                        nis = is;
                    } 
                } 
                buf = mConnection.getBuf();
                int len = 0;
                int lowWater = buf.length / 2;
                {
                    {
                        {
                            try 
                            {
                                wait();
                            } 
                            catch (InterruptedException e)
                            {
                                HttpLog.e("Interrupted exception whilst "
                                    + "network thread paused at WebCore's request."
                                    + " " + e.getMessage());
                            } 
                        } 
                    } 
                    len = nis.read(buf, count, buf.length - count);
                    {
                        count += len;
                        mReceivedBytes += len;
                    } 
                    {
                        HttpLog.v("Request.readResponse() " + count);
                        mEventHandler.data(buf, count);
                        count = 0;
                    } 
                } 
            } 
            catch (EOFException e)
            {
                {
                    mEventHandler.data(buf, count);
                } 
                HttpLog.v( "readResponse() handling " + e);
            } 
            catch (IOException e)
            {
                {
                    {
                        mEventHandler.data(buf, count);
                    } 
                    if (DroidSafeAndroidRuntime.control) throw e;
                } 
            } 
            finally 
            {
                {
                    nis.close();
                } 
            } 
        } 
        mConnection.setCanPersist(entity, statusLine.getProtocolVersion(),
                header.getConnectionType());
        mEventHandler.endData();
        complete();
        HttpLog.v("Request.readResponse(): done " +
                                    mHost.getSchemeName() + "://" + getHostPort() + mPath);
        addTaint(httpClientConnection.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.119 -0400", hash_original_method = "0703BC7E6FB4CF479DE68CDEB6E6E012", hash_generated_method = "FB6F6716432825E5A1B83371B2531B57")
    synchronized void cancel() {
        {
            HttpLog.v("Request.cancel(): " + getUri());
        } 
        mLoadingPaused = false;
        notify();
        mCancelled = true;
        {
            mConnection.cancel();
        } 
        
        
            
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.120 -0400", hash_original_method = "512B3E32AEE990D1477AF1DD14A214E5", hash_generated_method = "C0B5BE73DC76B27674CAB1474A2E4E66")
     String getHostPort() {
        String varB4EAC82CA7396A68D541C85D26508E83_1532807207 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1933518326 = null; 
        String myScheme = mHost.getSchemeName();
        int myPort = mHost.getPort();
        {
            boolean var8D6BF4CF9681D2015AABFC3D27024A3C_1154729994 = (myPort != 80 && myScheme.equals("http") ||
            myPort != 443 && myScheme.equals("https"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1532807207 = mHost.toHostString();
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1933518326 = mHost.getHostName();
            } 
        } 
        String varA7E53CE21691AB073D9660D615818899_1544998969; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1544998969 = varB4EAC82CA7396A68D541C85D26508E83_1532807207;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1544998969 = varB4EAC82CA7396A68D541C85D26508E83_1933518326;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1544998969.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1544998969;
        
        
        
        
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.121 -0400", hash_original_method = "2DF65EB3016FC9C1BCED4852586E67B2", hash_generated_method = "7FDB36E480ABCDA13495FE1203452DFD")
     String getUri() {
        String varB4EAC82CA7396A68D541C85D26508E83_1021371154 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1384010889 = null; 
        {
            boolean varC80F30B1906E6F9A7B5768A93265E704_1203762419 = (mProxyHost == null ||
            mHost.getSchemeName().equals("https"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1021371154 = mPath;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1384010889 = mHost.getSchemeName() + "://" + getHostPort() + mPath;
        String varA7E53CE21691AB073D9660D615818899_1857809083; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1857809083 = varB4EAC82CA7396A68D541C85D26508E83_1021371154;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1857809083 = varB4EAC82CA7396A68D541C85D26508E83_1384010889;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1857809083.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1857809083;
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.121 -0400", hash_original_method = "260B42F8E7BEBB3ADC717EDEB2B728A2", hash_generated_method = "DFF3C8ACE1EDBF3CDD5BD9337A623CF6")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_162065004 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_162065004 = mPath;
        varB4EAC82CA7396A68D541C85D26508E83_162065004.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_162065004;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.122 -0400", hash_original_method = "6782015769BAD3CE7033564D51D44773", hash_generated_method = "C9F2DA436C0B9B6A2A8251A84572C8DC")
     void reset() {
        mHttpRequest.removeHeaders(CONTENT_LENGTH_HEADER);
        {
            try 
            {
                mBodyProvider.reset();
            } 
            catch (IOException ex)
            {
                HttpLog.v(
                        "failed to reset body provider " +
                        getUri());
            } 
            setBodyProvider(mBodyProvider, mBodyLength);
        } 
        {
            mFailCount = 0;
            HttpLog.v("*** Request.reset() to range:" + mReceivedBytes);
            mHttpRequest.setHeader("Range", "bytes=" + mReceivedBytes + "-");
        } 
        
        
        
            
                
            
                
                        
                        
            
            
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.122 -0400", hash_original_method = "59F95FD933B02B7872449B124B2DE304", hash_generated_method = "A697D85C9FD075294ED849C7A4FB2683")
     void waitUntilComplete() {
        {
            try 
            {
                HttpLog.v("Request.waitUntilComplete()");
                mClientResource.wait();
                HttpLog.v("Request.waitUntilComplete() done waiting");
            } 
            catch (InterruptedException e)
            { }
        } 
        
        
            
                
                
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.122 -0400", hash_original_method = "7B097BCF5E489C3DB5111F527714D27C", hash_generated_method = "5985E11E937D3B36C1FE673E3527F219")
     void complete() {
        {
            mClientResource.notifyAll();
        } 
        
        
            
        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.123 -0400", hash_original_method = "270D8BA233306D6526BC7DEE9032A6D1", hash_generated_method = "00192E1B927AA38ADE38D51ED73DC0CF")
    private void setBodyProvider(InputStream bodyProvider, int bodyLength) {
        {
            boolean var23FBFF8990744E2A5380230AC0A31086_1851892891 = (!bodyProvider.markSupported());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "bodyProvider must support mark()");
            } 
        } 
        bodyProvider.mark(Integer.MAX_VALUE);
        ((BasicHttpEntityEnclosingRequest)mHttpRequest).setEntity(
                new InputStreamEntity(bodyProvider, bodyLength));
        addTaint(bodyProvider.getTaint());
        addTaint(bodyLength);
        
        
            
                    
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.123 -0400", hash_original_method = "9C3B106C5F2D1AB923C52530BB6B2461", hash_generated_method = "9AA67C5B91347731ECC39C0441812624")
    public void handleSslErrorResponse(boolean proceed) {
        HttpsConnection connection = (HttpsConnection)(mConnection);
        {
            connection.restartConnection(proceed);
        } 
        addTaint(proceed);
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.124 -0400", hash_original_method = "0F527F16FE7A8194B2376A18FA9A34FA", hash_generated_method = "DE75C0955107B3D6E5FD6DCCC0F32142")
     void error(int errorId, int resourceId) {
        mEventHandler.error(
                errorId,
                mConnection.mContext.getText(
                        resourceId).toString());
        addTaint(errorId);
        addTaint(resourceId);
        
        
                
                
                        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.124 -0400", hash_original_field = "BFF19C9941B7F24015025FEC47946FEC", hash_generated_field = "7B9DE3A4130C6C995D9A037F9150C7FA")

    private final static String HOST_HEADER = "Host";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.124 -0400", hash_original_field = "C71F5E74A25541DB9EC52BFA384BBA5A", hash_generated_field = "E84D9A59CAEF3BCC11F8F89244D21D5D")

    private final static String ACCEPT_ENCODING_HEADER = "Accept-Encoding";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.124 -0400", hash_original_field = "71793AFFDF5DE2856726717360EFD4CE", hash_generated_field = "A5FEF046E57453815489487A5ADC09DE")

    private final static String CONTENT_LENGTH_HEADER = "content-length";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:39.124 -0400", hash_original_field = "D2868735E1BE5A9FB84EF3C8D326145F", hash_generated_field = "F007AA5F14F6E3C18CB781D2C4A675C4")

    private static RequestContent requestContentProcessor = new RequestContent();
}

