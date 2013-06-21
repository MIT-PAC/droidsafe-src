package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import libcore.net.http.HttpEngine;

public abstract class HttpURLConnection extends URLConnection {
    protected String method = HttpEngine.GET;
    protected int responseCode = -1;
    protected String responseMessage;
    protected boolean instanceFollowRedirects = followRedirects;
    protected int chunkLength = -1;
    protected int fixedContentLength = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.803 -0400", hash_original_method = "58372EDCAE538607FC34A4F4F0582407", hash_generated_method = "FC6C49A5E6BCE1D899F351A954CE5E67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected HttpURLConnection(URL url) {
        super(url);
        dsTaint.addTaint(url.dsTaint);
        // ---------- Original Method ----------
    }

    
    public abstract void disconnect();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.803 -0400", hash_original_method = "6640096D2D877ED3E740627246DA5AF9", hash_generated_method = "76D11093B47CA5B7B7E6521A47976DBA")
    @DSModeled(DSC.SAFE)
    public InputStream getErrorStream() {
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
        public static boolean getFollowRedirects() {
        return followRedirects;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.804 -0400", hash_original_method = "ED24FB1ED5E1E919D525362B14A80DB6", hash_generated_method = "2A8CB8C7CC976777B6CC68AA394E5988")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public java.security.Permission getPermission() throws IOException {
        int port;
        port = url.getPort();
        {
            port = 80;
        } //End block
        java.security.Permission varECFEFD11874DC20940A3FD1FCCB16832_189761540 = (new SocketPermission(url.getHost() + ":" + port,
                "connect, resolve"));
        return (java.security.Permission)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int port = url.getPort();
        //if (port < 0) {
            //port = 80;
        //}
        //return new SocketPermission(url.getHost() + ":" + port,
                //"connect, resolve");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.804 -0400", hash_original_method = "0D9C6E3C645DAD49E763E30DD315D3EF", hash_generated_method = "BBC276E2EE46A13E39676ED80B22007A")
    @DSModeled(DSC.SAFE)
    public String getRequestMethod() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.804 -0400", hash_original_method = "7D3B203196D55AEFB0033919830A54D2", hash_generated_method = "D4A0ED16117F81A9F453AC639B23FEE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getResponseCode() throws IOException {
        getInputStream();
        String response;
        response = getHeaderField(0);
        response = response.trim();
        int mark;
        mark = response.indexOf(" ") + 1;
        int last;
        last = mark + 3;
        {
            boolean varDBC82FD2C27D040346DED1825365290A_740191285 = (last > response.length());
            {
                last = response.length();
            } //End block
        } //End collapsed parenthetic
        responseCode = Integer.parseInt(response.substring(mark, last));
        {
            boolean varEB8258B2AD4A2C7B13D11C42060FD010_1542755310 = (last + 1 <= response.length());
            {
                responseMessage = response.substring(last + 1);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //getInputStream();
        //String response = getHeaderField(0);
        //if (response == null) {
            //return -1;
        //}
        //response = response.trim();
        //int mark = response.indexOf(" ") + 1;
        //if (mark == 0) {
            //return -1;
        //}
        //int last = mark + 3;
        //if (last > response.length()) {
            //last = response.length();
        //}
        //responseCode = Integer.parseInt(response.substring(mark, last));
        //if (last + 1 <= response.length()) {
            //responseMessage = response.substring(last + 1);
        //}
        //return responseCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.804 -0400", hash_original_method = "2B517AE93F70715BB09FC42E79EE9551", hash_generated_method = "800BD38B579E74E86EF0B9B36611EC9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getResponseMessage() throws IOException {
        getResponseCode();
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (responseMessage != null) {
            //return responseMessage;
        //}
        //getResponseCode();
        //return responseMessage;
    }

    
        public static void setFollowRedirects(boolean auto) {
        followRedirects = auto;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.808 -0400", hash_original_method = "3B5EB6833E70FFDCB063E860A5177AF6", hash_generated_method = "B736921A1C4428D41E4CE205232EF201")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRequestMethod(String method) throws ProtocolException {
        dsTaint.addTaint(method);
        {
            if (DroidSafeAndroidRuntime.control) throw new ProtocolException("Connection already established");
        } //End block
        {
            String permittedUserMethod = PERMITTED_USER_METHODS[0];
            {
                {
                    boolean var754B48AB70D95830F89825504CF59187_1827840391 = (permittedUserMethod.equals(method));
                    {
                        this.method = permittedUserMethod;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new ProtocolException("Unknown method '" + method + "'; must be one of " +
                Arrays.toString(PERMITTED_USER_METHODS));
        // ---------- Original Method ----------
        //if (connected) {
            //throw new ProtocolException("Connection already established");
        //}
        //for (String permittedUserMethod : PERMITTED_USER_METHODS) {
            //if (permittedUserMethod.equals(method)) {
                //this.method = permittedUserMethod;
                //return;
            //}
        //}
        //throw new ProtocolException("Unknown method '" + method + "'; must be one of " +
                //Arrays.toString(PERMITTED_USER_METHODS));
    }

    
    public abstract boolean usingProxy();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.808 -0400", hash_original_method = "17A4A6C99056147BEFFA252CAD4737D6", hash_generated_method = "65D3A100EC7FB1CD36232757C95A79AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getContentEncoding() {
        String var200200937C07BE12B236D784A0B506FE_1743215741 = (super.getContentEncoding());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return super.getContentEncoding();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.808 -0400", hash_original_method = "881D26516B84F6D6EEADB518A168ADE5", hash_generated_method = "B867483DE05BAF87E64E1B6984CC55E4")
    @DSModeled(DSC.SAFE)
    public boolean getInstanceFollowRedirects() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return instanceFollowRedirects;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.808 -0400", hash_original_method = "BB71B8E9C2D3F0EF20C7720F9E44016D", hash_generated_method = "5F874142AB164AE24EA0C9A7BDA4F830")
    @DSModeled(DSC.SAFE)
    public void setInstanceFollowRedirects(boolean followRedirects) {
        dsTaint.addTaint(followRedirects);
        // ---------- Original Method ----------
        //instanceFollowRedirects = followRedirects;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.809 -0400", hash_original_method = "6E2F3B7733832056F416A461A3655623", hash_generated_method = "D91A5EE0AD4F6EA287E3C6F2AE13DF5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long getHeaderFieldDate(String field, long defaultValue) {
        dsTaint.addTaint(field);
        dsTaint.addTaint(defaultValue);
        long var67DEBF4EEA6A787049104D1914AA5EB6_644648934 = (super.getHeaderFieldDate(field, defaultValue));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return super.getHeaderFieldDate(field, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.809 -0400", hash_original_method = "746797ABBB47B5E996C092A3E4D56421", hash_generated_method = "7EEF6E85128A3FEEE5C169F576638CD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFixedLengthStreamingMode(int contentLength) {
        dsTaint.addTaint(contentLength);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Already connected");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Already in chunked mode");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("contentLength < 0");
        } //End block
        // ---------- Original Method ----------
        //if (super.connected) {
            //throw new IllegalStateException("Already connected");
        //}
        //if (chunkLength > 0) {
            //throw new IllegalStateException("Already in chunked mode");
        //}
        //if (contentLength < 0) {
            //throw new IllegalArgumentException("contentLength < 0");
        //}
        //this.fixedContentLength = contentLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.809 -0400", hash_original_method = "21470E1D7A697F6C3367E1B80C1F2447", hash_generated_method = "D6796B4817B5F80EE2F1BA06CD4F5355")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setChunkedStreamingMode(int chunkLength) {
        dsTaint.addTaint(chunkLength);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Already connected");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Already in fixed-length mode");
        } //End block
        {
            this.chunkLength = HttpEngine.DEFAULT_CHUNK_LENGTH;
        } //End block
        // ---------- Original Method ----------
        //if (super.connected) {
            //throw new IllegalStateException("Already connected");
        //}
        //if (fixedContentLength >= 0) {
            //throw new IllegalStateException("Already in fixed-length mode");
        //}
        //if (chunkLength <= 0) {
            //this.chunkLength = HttpEngine.DEFAULT_CHUNK_LENGTH;
        //} else {
            //this.chunkLength = chunkLength;
        //}
    }

    
    private static final String[] PERMITTED_USER_METHODS = {
            HttpEngine.OPTIONS,
            HttpEngine.GET,
            HttpEngine.HEAD,
            HttpEngine.POST,
            HttpEngine.PUT,
            HttpEngine.DELETE,
            HttpEngine.TRACE
            
    };
    private static boolean followRedirects = true;
    public static final int HTTP_ACCEPTED = 202;
    public static final int HTTP_BAD_GATEWAY = 502;
    public static final int HTTP_BAD_METHOD = 405;
    public static final int HTTP_BAD_REQUEST = 400;
    public static final int HTTP_CLIENT_TIMEOUT = 408;
    public static final int HTTP_CONFLICT = 409;
    public static final int HTTP_CREATED = 201;
    public static final int HTTP_ENTITY_TOO_LARGE = 413;
    public static final int HTTP_FORBIDDEN = 403;
    public static final int HTTP_GATEWAY_TIMEOUT = 504;
    public static final int HTTP_GONE = 410;
    public static final int HTTP_INTERNAL_ERROR = 500;
    public static final int HTTP_LENGTH_REQUIRED = 411;
    public static final int HTTP_MOVED_PERM = 301;
    public static final int HTTP_MOVED_TEMP = 302;
    public static final int HTTP_MULT_CHOICE = 300;
    public static final int HTTP_NO_CONTENT = 204;
    public static final int HTTP_NOT_ACCEPTABLE = 406;
    public static final int HTTP_NOT_AUTHORITATIVE = 203;
    public static final int HTTP_NOT_FOUND = 404;
    public static final int HTTP_NOT_IMPLEMENTED = 501;
    public static final int HTTP_NOT_MODIFIED = 304;
    public static final int HTTP_OK = 200;
    public static final int HTTP_PARTIAL = 206;
    public static final int HTTP_PAYMENT_REQUIRED = 402;
    public static final int HTTP_PRECON_FAILED = 412;
    public static final int HTTP_PROXY_AUTH = 407;
    public static final int HTTP_REQ_TOO_LONG = 414;
    public static final int HTTP_RESET = 205;
    public static final int HTTP_SEE_OTHER = 303;
    @Deprecated public static final int HTTP_SERVER_ERROR = 500;
    public static final int HTTP_USE_PROXY = 305;
    public static final int HTTP_UNAUTHORIZED = 401;
    public static final int HTTP_UNSUPPORTED_TYPE = 415;
    public static final int HTTP_UNAVAILABLE = 503;
    public static final int HTTP_VERSION = 505;
}

