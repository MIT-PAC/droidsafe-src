package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ParseException;
import android.net.Uri;
import android.net.WebAddress;
import android.net.http.EventHandler;
import android.net.http.Headers;
import android.net.http.HttpAuthHeader;
import android.net.http.RequestHandle;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.webkit.CacheManager.CacheResult;
import android.webkit.JniUtil;
import com.android.internal.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class LoadListener extends Handler implements EventHandler {
    private ByteArrayBuilder mDataBuilder = new ByteArrayBuilder();
    private String   mUrl;
    private WebAddress mUri;
    private boolean  mPermanent;
    private String   mOriginalUrl;
    private Context  mContext;
    private BrowserFrame mBrowserFrame;
    private int      mNativeLoader;
    private String   mMimeType;
    private String   mEncoding;
    private String   mTransferEncoding;
    private int      mStatusCode;
    private String   mStatusText;
    public long mContentLength;
    private boolean  mCancelled;
    private boolean  mAuthFailed;
    private CacheLoader mCacheLoader;
    private boolean  mFromCache = false;
    private HttpAuthHeader mAuthHeader;
    private int      mErrorID = OK;
    private String   mErrorDescription;
    private SslError mSslError;
    private RequestHandle mRequestHandle;
    private RequestHandle mSslErrorRequestHandle;
    private long     mPostIdentifier;
    private boolean  mSetNativeResponse;
    private String mMethod;
    private Map<String, String> mRequestHeaders;
    private byte[] mPostData;
    private boolean mSynchronous;
    private Vector<Message> mMessageQueue;
    private boolean mIsMainPageLoader;
    private boolean mIsMainResourceLoader;
    private boolean mUserGesture;
    private Headers mHeaders;
    private String mUsername;
    private String mPassword;
    private int mCacheRedirectCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.528 -0400", hash_original_method = "63FB01D41A0193C36F7BC9C3E9D1276B", hash_generated_method = "FD48B8B0A2C9B73288A89C9A100EC29B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     LoadListener(Context context, BrowserFrame frame, String url,
            int nativeLoader, boolean synchronous, boolean isMainPageLoader,
            boolean isMainResource, boolean userGesture, long postIdentifier,
            String username, String password) {
        dsTaint.addTaint(isMainPageLoader);
        dsTaint.addTaint(nativeLoader);
        dsTaint.addTaint(username);
        dsTaint.addTaint(frame.dsTaint);
        dsTaint.addTaint(postIdentifier);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(userGesture);
        dsTaint.addTaint(synchronous);
        dsTaint.addTaint(password);
        dsTaint.addTaint(isMainResource);
        dsTaint.addTaint(url);
        setUrl(url);
        {
            mMessageQueue = new Vector<Message>();
        } //End block
        // ---------- Original Method ----------
        //assert !JniUtil.useChromiumHttpStack();
        //if (DebugFlags.LOAD_LISTENER) {
            //Log.v(LOGTAG, "LoadListener constructor url=" + url);
        //}
        //mContext = context;
        //mBrowserFrame = frame;
        //setUrl(url);
        //mNativeLoader = nativeLoader;
        //mSynchronous = synchronous;
        //if (synchronous) {
            //mMessageQueue = new Vector<Message>();
        //}
        //mIsMainPageLoader = isMainPageLoader;
        //mIsMainResourceLoader = isMainResource;
        //mUserGesture = userGesture;
        //mPostIdentifier = postIdentifier;
        //mUsername = username;
        //mPassword = password;
    }

    
        public static LoadListener getLoadListener(Context context,
            BrowserFrame frame, String url, int nativeLoader,
            boolean synchronous, boolean isMainPageLoader,
            boolean isMainResource, boolean userGesture, long postIdentifier,
            String username, String password) {
        sNativeLoaderCount += 1;
        return new LoadListener(context, frame, url, nativeLoader, synchronous,
                isMainPageLoader, isMainResource, userGesture, postIdentifier,
                username, password);
    }

    
        public static int getNativeLoaderCount() {
        return sNativeLoaderCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.529 -0400", hash_original_method = "E8BFBC0989CB1303890EF6ABB82F2DCB", hash_generated_method = "1D30724615CFE0039A108856FCC50022")
    @DSModeled(DSC.SAFE)
    private void clearNativeLoader() {
        sNativeLoaderCount -= 1;
        mNativeLoader = 0;
        mSetNativeResponse = false;
        // ---------- Original Method ----------
        //sNativeLoaderCount -= 1;
        //mNativeLoader = 0;
        //mSetNativeResponse = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.530 -0400", hash_original_method = "77CD0D13F9C2AAAECAF2A5910AFEFD4A", hash_generated_method = "3CA3433B7C629489B01A857A96C748A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        //Begin case MSG_CONTENT_HEADERS 
        handleHeaders((Headers) msg.obj);
        //End case MSG_CONTENT_HEADERS 
        //Begin case MSG_CONTENT_DATA 
        {
            boolean varEBF14453EC3DF653682F6F49D18A0FCD_1017396825 = (mNativeLoader != 0 && !ignoreCallbacks());
            {
                commitLoad();
            } //End block
        } //End collapsed parenthetic
        //End case MSG_CONTENT_DATA 
        //Begin case MSG_CONTENT_FINISHED 
        handleEndData();
        //End case MSG_CONTENT_FINISHED 
        //Begin case MSG_CONTENT_ERROR 
        handleError(msg.arg1, (String) msg.obj);
        //End case MSG_CONTENT_ERROR 
        //Begin case MSG_LOCATION_CHANGED 
        doRedirect();
        //End case MSG_LOCATION_CHANGED 
        //Begin case MSG_LOCATION_CHANGED_REQUEST 
        Message contMsg;
        contMsg = obtainMessage(MSG_LOCATION_CHANGED);
        //End case MSG_LOCATION_CHANGED_REQUEST 
        //Begin case MSG_LOCATION_CHANGED_REQUEST 
        Message stopMsg;
        stopMsg = obtainMessage(MSG_CONTENT_FINISHED);
        //End case MSG_LOCATION_CHANGED_REQUEST 
        //Begin case MSG_LOCATION_CHANGED_REQUEST 
        mBrowserFrame.getCallbackProxy().onFormResubmission(
                        stopMsg, contMsg);
        //End case MSG_LOCATION_CHANGED_REQUEST 
        //Begin case MSG_STATUS 
        HashMap status;
        status = (HashMap) msg.obj;
        //End case MSG_STATUS 
        //Begin case MSG_STATUS 
        handleStatus(((Integer) status.get("major")).intValue(),
                        ((Integer) status.get("minor")).intValue(),
                        ((Integer) status.get("code")).intValue(),
                        (String) status.get("reason"));
        //End case MSG_STATUS 
        //Begin case MSG_SSL_CERTIFICATE 
        handleCertificate((SslCertificate) msg.obj);
        //End case MSG_SSL_CERTIFICATE 
        //Begin case MSG_SSL_ERROR 
        handleSslError((SslError) msg.obj);
        //End case MSG_SSL_ERROR 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.530 -0400", hash_original_method = "172B6AEABEB6A05CD87E0FF0F77BADEB", hash_generated_method = "9CE6D3AB391A376C04ED6A768CEA0EF5")
    @DSModeled(DSC.SAFE)
     BrowserFrame getFrame() {
        return (BrowserFrame)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBrowserFrame;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.530 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "B0B2DDBEB77BA94D0A4C33C64B71FA82")
    @DSModeled(DSC.SAFE)
     Context getContext() {
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.530 -0400", hash_original_method = "8DEF62308917FED7D5E9DE4FE979D5DE", hash_generated_method = "12FADEF1644BC5D9A65AC244ACC662A6")
    @DSModeled(DSC.SAFE)
     boolean isSynchronous() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSynchronous;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.530 -0400", hash_original_method = "E8044B5DC56667FC9DCFE8CB33E5852B", hash_generated_method = "0250F6ECEB9D6CEDC0BA1EB636743017")
    @DSModeled(DSC.SAFE)
    public boolean cancelled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCancelled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.531 -0400", hash_original_method = "454399D3A9345FFC357883E67C1190C2", hash_generated_method = "A153D9CF401E472A5A091C53ECC3CA21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void headers(Headers headers) {
        dsTaint.addTaint(headers.dsTaint);
        ArrayList<String> cookies;
        cookies = headers.getSetCookie();
        {
            int i;
            i = 0;
            boolean varE9AF3BEAEA8CF5406F5AC5D6F9EE8F57_203471313 = (i < cookies.size());
            {
                CookieManager.getInstance().setCookie(mUri, cookies.get(i));
            } //End block
        } //End collapsed parenthetic
        sendMessageInternal(obtainMessage(MSG_CONTENT_HEADERS, headers));
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) Log.v(LOGTAG, "LoadListener.headers");
        //if (mCancelled) return;
        //ArrayList<String> cookies = headers.getSetCookie();
        //for (int i = 0; i < cookies.size(); ++i) {
            //CookieManager.getInstance().setCookie(mUri, cookies.get(i));
        //}
        //sendMessageInternal(obtainMessage(MSG_CONTENT_HEADERS, headers));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.532 -0400", hash_original_method = "311EC7904C0F96CC61CCD61A611678E4", hash_generated_method = "73DA272E79E022397730F7C10BAF67E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleHeaders(Headers headers) {
        dsTaint.addTaint(headers.dsTaint);
        {
            WebViewWorker.getHandler().obtainMessage(
                    WebViewWorker.MSG_REMOVE_CACHE, this).sendToTarget();
        } //End block
        long contentLength;
        contentLength = headers.getContentLength();
        {
            mContentLength = contentLength;
        } //End block
        {
            mContentLength = 0;
        } //End block
        String contentType;
        contentType = headers.getContentType();
        {
            parseContentTypeHeader(contentType);
            mMimeType = MimeTypeMap.getSingleton().remapGenericMimeType(
                    mMimeType, mUrl, headers.getContentDisposition());
        } //End block
        {
            guessMimeType();
        } //End block
        {
            boolean var1FB790FEEC374B8E1CFBA64E5D64F4C6_1857333073 = (mIsMainPageLoader && mIsMainResourceLoader && mUserGesture &&
                Pattern.matches(XML_MIME_TYPE, mMimeType) &&
                !mMimeType.equalsIgnoreCase("application/xhtml+xml"));
            {
                Intent i;
                i = new Intent(Intent.ACTION_VIEW);
                i.setDataAndType(Uri.parse(url()), mMimeType);
                ResolveInfo info;
                info = mContext.getPackageManager().resolveActivity(i,
                    PackageManager.MATCH_DEFAULT_ONLY);
                {
                    boolean var0CAA1F9BE373A668A403365FF0CE483B_1796256519 = (info != null && !mContext.getPackageName().equals(
                    info.activityInfo.packageName));
                    {
                        try 
                        {
                            mContext.startActivity(i);
                            mBrowserFrame.stopLoading();
                        } //End block
                        catch (ActivityNotFoundException ex)
                        { }
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean mustAuthenticate;
        mustAuthenticate = (mStatusCode == HTTP_AUTH ||
                mStatusCode == HTTP_PROXY_AUTH);
        boolean isProxyAuthRequest;
        isProxyAuthRequest = (mStatusCode == HTTP_PROXY_AUTH);
        mAuthFailed = false;
        {
            mAuthFailed = (mustAuthenticate &&
                    isProxyAuthRequest == mAuthHeader.isProxy());
            {
                boolean varCC683FE62B0EF80F8FFB7C83613687C9_18048622 = (!mAuthFailed && mAuthHeader.isProxy());
                {
                    Network network;
                    network = Network.getInstance(mContext);
                    {
                        boolean varE7ECF7EC251273A020C9A5595F22451C_1234906942 = (network.isValidProxySet());
                        {
                            {
                                network.setProxyUsername(mAuthHeader.getUsername());
                                network.setProxyPassword(mAuthHeader.getPassword());
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        mAuthHeader = null;
        {
            {
                mAuthHeader = parseAuthHeader(
                        headers.getWwwAuthenticate());
            } //End block
            {
                mAuthHeader = parseAuthHeader(
                        headers.getProxyAuthenticate());
                {
                    mAuthHeader.setProxy();
                } //End block
            } //End block
        } //End block
        {
            {
                boolean var12B07FF95F64556F0F5629AF1ADEEDEA_553418980 = (!mFromCache && mRequestHandle != null
                    && (!mRequestHandle.getMethod().equals("POST")
                            || mPostIdentifier != 0));
                {
                    WebViewWorker.CacheCreateData data;
                    data = new WebViewWorker.CacheCreateData();
                    data.mListener = this;
                    data.mUrl = mUrl;
                    data.mMimeType = mMimeType;
                    data.mStatusCode = mStatusCode;
                    data.mPostId = mPostIdentifier;
                    data.mHeaders = headers;
                    WebViewWorker.getHandler().obtainMessage(
                        WebViewWorker.MSG_CREATE_CACHE, data).sendToTarget();
                } //End block
            } //End collapsed parenthetic
            WebViewWorker.CacheEncoding ce;
            ce = new WebViewWorker.CacheEncoding();
            ce.mEncoding = mEncoding;
            ce.mListener = this;
            WebViewWorker.getHandler().obtainMessage(
                    WebViewWorker.MSG_UPDATE_CACHE_ENCODING, ce).sendToTarget();
        } //End block
        commitHeadersCheckRedirect();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.532 -0400", hash_original_method = "700C126D7DD3A2A28FA66689BEC1C959", hash_generated_method = "AB4EA1ECF71ADDDB5015E5BD7C112AF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean proxyAuthenticate() {
        {
            boolean varE5CAE2FBD59400ACCD83E492081A86C1_1140792745 = (mAuthHeader.isProxy());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mAuthHeader != null) {
            //return mAuthHeader.isProxy();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.533 -0400", hash_original_method = "DDF05333033BF6873CD233D3316FD8A3", hash_generated_method = "CB983E532504D5FD378F328EFB119319")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void status(int majorVersion, int minorVersion,
            int code,  String reasonPhrase) {
        dsTaint.addTaint(majorVersion);
        dsTaint.addTaint(reasonPhrase);
        dsTaint.addTaint(minorVersion);
        dsTaint.addTaint(code);
        HashMap status;
        status = new HashMap();
        status.put("major", majorVersion);
        status.put("minor", minorVersion);
        status.put("code", code);
        status.put("reason", reasonPhrase);
        mDataBuilder.clear();
        mMimeType = "";
        mEncoding = "";
        mTransferEncoding = "";
        sendMessageInternal(obtainMessage(MSG_STATUS, status));
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) {
            //Log.v(LOGTAG, "LoadListener: from: " + mUrl
                    //+ " major: " + majorVersion
                    //+ " minor: " + minorVersion
                    //+ " code: " + code
                    //+ " reason: " + reasonPhrase);
        //}
        //HashMap status = new HashMap();
        //status.put("major", majorVersion);
        //status.put("minor", minorVersion);
        //status.put("code", code);
        //status.put("reason", reasonPhrase);
        //mDataBuilder.clear();
        //mMimeType = "";
        //mEncoding = "";
        //mTransferEncoding = "";
        //sendMessageInternal(obtainMessage(MSG_STATUS, status));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.533 -0400", hash_original_method = "80BDEC9DD0BC19198E8FAA3CF681EF16", hash_generated_method = "FAB5052B5D125582F1719A2D41DF96CB")
    @DSModeled(DSC.SAFE)
    private void handleStatus(int major, int minor, int code, String reason) {
        dsTaint.addTaint(reason);
        dsTaint.addTaint(minor);
        dsTaint.addTaint(code);
        dsTaint.addTaint(major);
        mPermanent = false;
        // ---------- Original Method ----------
        //if (mCancelled) return;
        //mStatusCode = code;
        //mStatusText = reason;
        //mPermanent = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.533 -0400", hash_original_method = "E4096ABF23EF8731F97354B434FC290A", hash_generated_method = "74CEE48C50EF7C445E713621BEC01572")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void certificate(SslCertificate certificate) {
        dsTaint.addTaint(certificate.dsTaint);
        sendMessageInternal(obtainMessage(MSG_SSL_CERTIFICATE, certificate));
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) {
            //Log.v(LOGTAG, "LoadListener.certificate: " + certificate);
        //}
        //sendMessageInternal(obtainMessage(MSG_SSL_CERTIFICATE, certificate));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.533 -0400", hash_original_method = "0FA338360DC1BF86862C5325E0DDE15B", hash_generated_method = "109B4740AC7CA714F3AAACD85A68C981")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleCertificate(SslCertificate certificate) {
        dsTaint.addTaint(certificate.dsTaint);
        {
            mBrowserFrame.certificate(certificate);
        } //End block
        // ---------- Original Method ----------
        //if (mIsMainPageLoader && mIsMainResourceLoader) {
            //mBrowserFrame.certificate(certificate);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.533 -0400", hash_original_method = "89A45FCA5400E7297D291CB9BD4FA531", hash_generated_method = "B32512A39BD1A52876ACEBB09D9F5939")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void error(int id, String description) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(description);
        sendMessageInternal(obtainMessage(MSG_CONTENT_ERROR, id, 0, description));
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) {
            //Log.v(LOGTAG, "LoadListener.error url:" +
                    //url() + " id:" + id + " description:" + description);
        //}
        //sendMessageInternal(obtainMessage(MSG_CONTENT_ERROR, id, 0, description));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.534 -0400", hash_original_method = "FF98E8647B63FEBC8B925077CB2E6971", hash_generated_method = "F8A0C7175E107CCFE09A942AAC63A853")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleError(int id, String description) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(description);
        detachRequestHandle();
        notifyError();
        tearDown();
        // ---------- Original Method ----------
        //mErrorID = id;
        //mErrorDescription = description;
        //detachRequestHandle();
        //notifyError();
        //tearDown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.534 -0400", hash_original_method = "842D88ADC63F459E21BBD6FC9BF11FA0", hash_generated_method = "32FBAF1A6CF1CE718137C339EE227327")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void data(byte[] data, int length) {
        dsTaint.addTaint(length);
        dsTaint.addTaint(data[0]);
        boolean sendMessage;
        sendMessage = false;
        {
            sendMessage = mDataBuilder.isEmpty();
            mDataBuilder.append(data, 0, length);
        } //End block
        {
            sendMessageInternal(obtainMessage(MSG_CONTENT_DATA));
        } //End block
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) {
            //Log.v(LOGTAG, "LoadListener.data(): url: " + url());
        //}
        //boolean sendMessage = false;
        //synchronized (mDataBuilder) {
            //sendMessage = mDataBuilder.isEmpty();
            //mDataBuilder.append(data, 0, length);
        //}
        //if (sendMessage) {
            //sendMessageInternal(obtainMessage(MSG_CONTENT_DATA));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.534 -0400", hash_original_method = "57E1AB7C57BAD02879F9C8B9B633558A", hash_generated_method = "169AA40A4DB785BD992709004B47C00D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void endData() {
        sendMessageInternal(obtainMessage(MSG_CONTENT_FINISHED));
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) {
            //Log.v(LOGTAG, "LoadListener.endData(): url: " + url());
        //}
        //sendMessageInternal(obtainMessage(MSG_CONTENT_FINISHED));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.535 -0400", hash_original_method = "CDF3DE93E351C5A11A75DE0E367F817E", hash_generated_method = "48B3B2FAC56BE626B574DD3794169EA2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleEndData() {
        //Begin case HTTP_MOVED_PERMANENTLY 
        mPermanent = true;
        //End case HTTP_MOVED_PERMANENTLY 
        //Begin case HTTP_FOUND HTTP_SEE_OTHER HTTP_TEMPORARY_REDIRECT 
        {
            {
                boolean varD068D29C86C3899A0A7365E7D8E5A606_112602888 = (mRequestHandle != null && 
                                mRequestHandle.getMethod().equals("POST"));
                {
                    sendMessageInternal(obtainMessage(
                                MSG_LOCATION_CHANGED_REQUEST));
                } //End block
                {
                    boolean varD28941268B369EB362F84F893C633B30_302382005 = (mMethod != null && mMethod.equals("POST"));
                    {
                        sendMessageInternal(obtainMessage(
                                MSG_LOCATION_CHANGED_REQUEST));
                    } //End block
                    {
                        sendMessageInternal(obtainMessage(MSG_LOCATION_CHANGED));
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        {
            sendMessageInternal(obtainMessage(MSG_LOCATION_CHANGED));
        } //End block
        //End case HTTP_FOUND HTTP_SEE_OTHER HTTP_TEMPORARY_REDIRECT 
        //Begin case HTTP_AUTH HTTP_PROXY_AUTH 
        {
            boolean var73D6F5715104F63F29F36A391760A31E_444364381 = (mAuthHeader != null &&
                        (Network.getInstance(mContext).isValidProxySet() ||
                         !mAuthHeader.isProxy()));
            {
                {
                    String host;
                    boolean varDFD43C8D97D180F461A514E8A6A76A39_190565515 = (mAuthHeader.isProxy());
                    host = Network.getInstance(mContext).getProxyHostname();
                    host = mUri.getHost();
                    HttpAuthHandlerImpl.onReceivedCredentials(this, host,
                                mAuthHeader.getRealm(), mUsername, mPassword);
                    makeAuthResponse(mUsername, mPassword);
                } //End block
                {
                    Network.getInstance(mContext).handleAuthRequest(this);
                } //End block
            } //End block
        } //End collapsed parenthetic
        //End case HTTP_AUTH HTTP_PROXY_AUTH 
        //Begin case HTTP_NOT_MODIFIED 
        {
            {
                boolean var42C78101C5CD9E8ED377DC60807FD554_478573460 = (isSynchronous());
                {
                    mCacheLoader.load();
                } //End block
                {
                    WebViewWorker.getHandler().obtainMessage(
                                WebViewWorker.MSG_ADD_STREAMLOADER, mCacheLoader)
                                .sendToTarget();
                } //End block
            } //End collapsed parenthetic
            mFromCache = true;
        } //End block
        //End case HTTP_NOT_MODIFIED 
        detachRequestHandle();
        tearDown();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.535 -0400", hash_original_method = "986192BD953D202BDF33831C4485C789", hash_generated_method = "36B6A18FF93A968082D30F2B20F95B3F")
    @DSModeled(DSC.SAFE)
     void setCacheLoader(CacheLoader c) {
        dsTaint.addTaint(c.dsTaint);
        mFromCache = true;
        // ---------- Original Method ----------
        //mCacheLoader = c;
        //mFromCache = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.536 -0400", hash_original_method = "0AD650AC52F38566687E74B5EF113675", hash_generated_method = "B20D34AC457CCB43CA3D3B82D331D90D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean checkCache(Map<String, String> headers) {
        dsTaint.addTaint(headers.dsTaint);
        CacheResult result;
        result = CacheManager.getCacheFile(url(), mPostIdentifier,
                headers);
        mCacheLoader = null;
        mFromCache = false;
        {
            mCacheLoader = new CacheLoader(this, result);
            {
                boolean varC6BCA4E5BDBD2D7A1E9322998F81BCBF_1909626485 = (!headers.containsKey(
                    CacheManager.HEADER_KEY_IFNONEMATCH) &&
                    !headers.containsKey(
                            CacheManager.HEADER_KEY_IFMODIFIEDSINCE));
                {
                    {
                        boolean varE43BEDB07085C405402D06A50570074B_1304047499 = (isSynchronous());
                        {
                            mCacheLoader.load();
                        } //End block
                        {
                            WebViewWorker.getHandler().obtainMessage(
                            WebViewWorker.MSG_ADD_STREAMLOADER, mCacheLoader)
                            .sendToTarget();
                        } //End block
                    } //End collapsed parenthetic
                    mFromCache = true;
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.536 -0400", hash_original_method = "DAC212856E10133D124E798AA1F9AF10", hash_generated_method = "2CE84032C7084F7DEA184D70B84B6844")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean handleSslErrorRequest(SslError error) {
        dsTaint.addTaint(error.dsTaint);
        {
            boolean var4D0341006E9A9633CEB75F8CF4C09DE3_2104632380 = (Network.getInstance(mContext).checkSslPrefTable(this, error));
        } //End collapsed parenthetic
        {
            boolean var837A5D3B4D6C6B7A7C66720A25FA94F8_104487967 = (isSynchronous());
            {
                mRequestHandle.handleSslErrorResponse(false);
            } //End block
        } //End collapsed parenthetic
        sendMessageInternal(obtainMessage(MSG_SSL_ERROR, error));
        {
            mSslErrorRequestHandle = mRequestHandle;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) {
            //Log.v(LOGTAG,
                    //"LoadListener.handleSslErrorRequest(): url:" + url() +
                    //" primary error: " + error.getPrimaryError() +
                    //" certificate: " + error.getCertificate());
        //}
        //if (Network.getInstance(mContext).checkSslPrefTable(this, error)) {
            //return true;
        //}
        //if (isSynchronous()) {
            //mRequestHandle.handleSslErrorResponse(false);
            //return true;
        //}
        //sendMessageInternal(obtainMessage(MSG_SSL_ERROR, error));
        //if (!mCancelled) {
            //mSslErrorRequestHandle = mRequestHandle;
        //}
        //return !mCancelled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.536 -0400", hash_original_method = "8A34681F6BA1F3EEE132C403DE00B59E", hash_generated_method = "8D6748461DEC917E94FAEF6E3F39EB40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleSslError(SslError error) {
        dsTaint.addTaint(error.dsTaint);
        {
            Network.getInstance(mContext).handleSslErrorRequest(this);
        } //End block
        {
            mSslErrorRequestHandle.handleSslErrorResponse(true);
        } //End block
        mSslErrorRequestHandle = null;
        // ---------- Original Method ----------
        //if (!mCancelled) {
            //mSslError = error;
            //Network.getInstance(mContext).handleSslErrorRequest(this);
        //} else if (mSslErrorRequestHandle != null) {
            //mSslErrorRequestHandle.handleSslErrorResponse(true);
        //}
        //mSslErrorRequestHandle = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.537 -0400", hash_original_method = "273C3FB8F6276DB18167E6647E9B9071", hash_generated_method = "65F021EE6C2ED1722FE3F5D72EB72DAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String realm() {
        {
            String var825AE9BFB0C67F9647E97A5763188481_1673119386 = (mAuthHeader.getRealm());
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (mAuthHeader == null) {
            //return null;
        //} else {
            //return mAuthHeader.getRealm();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.537 -0400", hash_original_method = "B53822BFF4A674DE454739734B590814", hash_generated_method = "9940DC9AAB63088ED937C3CCC5639BD9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean authCredentialsInvalid() {
        boolean var3969C3B58B09A1ECDB164E540B11F523_517467470 = ((mAuthFailed &&
                !(mAuthHeader.isDigest() && mAuthHeader.getStale())));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mAuthFailed &&
                //!(mAuthHeader.isDigest() && mAuthHeader.getStale()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.537 -0400", hash_original_method = "D83DC2897E3C9B13E1B0E03447F2258A", hash_generated_method = "D2E9A7798B19891D7588C14B06533BE9")
    @DSModeled(DSC.SAFE)
     SslError sslError() {
        return (SslError)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSslError;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.537 -0400", hash_original_method = "98A7269FE5209374A8ED24F438AC19C3", hash_generated_method = "36383142A525F23DB16F227064910C0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void handleSslErrorResponse(boolean proceed) {
        dsTaint.addTaint(proceed);
        {
            mRequestHandle.handleSslErrorResponse(proceed);
        } //End block
        {
            mBrowserFrame.stopLoading();
            tearDown();
        } //End block
        // ---------- Original Method ----------
        //if (mRequestHandle != null) {
            //mRequestHandle.handleSslErrorResponse(proceed);
        //}
        //if (!proceed) {
            //mBrowserFrame.stopLoading();
            //tearDown();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.537 -0400", hash_original_method = "7E02E9AA12C4A958E94F9A413E55434A", hash_generated_method = "6B3EC44B704C008E1E83529E0C7B22CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void handleAuthResponse(String username, String password) {
        dsTaint.addTaint(username);
        dsTaint.addTaint(password);
        {
            makeAuthResponse(username, password);
        } //End block
        {
            commitLoad();
            tearDown();
        } //End block
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) {
            //Log.v(LOGTAG, "LoadListener.handleAuthResponse: url: " + mUrl
                    //+ " username: " + username
                    //+ " password: " + password);
        //}
        //if (username != null && password != null) {
            //makeAuthResponse(username, password);
        //} else {
            //commitLoad();
            //tearDown();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.538 -0400", hash_original_method = "D4EC792204E12F6CD4476F22DB2D7416", hash_generated_method = "3A68CD3DB607A5C4DE4716F33F5BBBB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void makeAuthResponse(String username, String password) {
        dsTaint.addTaint(username);
        dsTaint.addTaint(password);
        mAuthHeader.setUsername(username);
        mAuthHeader.setPassword(password);
        int scheme;
        scheme = mAuthHeader.getScheme();
        {
            boolean isProxy;
            isProxy = mAuthHeader.isProxy();
            mRequestHandle.setupBasicAuthResponse(isProxy, username, password);
        } //End block
        {
            boolean isProxy;
            isProxy = mAuthHeader.isProxy();
            String realm;
            realm = mAuthHeader.getRealm();
            String nonce;
            nonce = mAuthHeader.getNonce();
            String qop;
            qop = mAuthHeader.getQop();
            String algorithm;
            algorithm = mAuthHeader.getAlgorithm();
            String opaque;
            opaque = mAuthHeader.getOpaque();
            mRequestHandle.setupDigestAuthResponse(isProxy, username, password,
                    realm, nonce, qop, algorithm, opaque);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.538 -0400", hash_original_method = "0354530277F06C2F68A7F9A147112FDC", hash_generated_method = "0AB2E8589D0C3C9F3F7623C45B631EC7")
    @DSModeled(DSC.SAFE)
     void setRequestData(String method, Map<String, String> headers, 
            byte[] postData) {
        dsTaint.addTaint(headers.dsTaint);
        dsTaint.addTaint(postData[0]);
        dsTaint.addTaint(method);
        // ---------- Original Method ----------
        //mMethod = method;
        //mRequestHeaders = headers;
        //mPostData = postData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.538 -0400", hash_original_method = "50C2A5A94CFD2B09208EC5050A570E5D", hash_generated_method = "B4CDB54FDA3EBBDFB43711E17DF57E2E")
    @DSModeled(DSC.SAFE)
     String url() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mUrl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.539 -0400", hash_original_method = "C2839DA6285DEBF5C5C20951F1E9FC61", hash_generated_method = "27CFB04084BBD9D48C4E4F1F891999DB")
    @DSModeled(DSC.SAFE)
     WebAddress getWebAddress() {
        return (WebAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mUri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.540 -0400", hash_original_method = "0451B8994B1846476A8FE8B0355ADDFF", hash_generated_method = "0DF6310B4418FA01860CF9AF1B47F407")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String host() {
        {
            String var401B6BC18814FB128FBEC15FAD4A25A4_804081221 = (mUri.getHost());
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (mUri != null) {
            //return mUri.getHost();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.540 -0400", hash_original_method = "BC027B9D5395B8E20CC57CD534FC36DC", hash_generated_method = "6885B5DF4FADFE6B6DEAF67BA3143980")
    @DSModeled(DSC.SAFE)
     String originalUrl() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (mOriginalUrl != null) {
            //return mOriginalUrl;
        //} else {
            //return mUrl;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.540 -0400", hash_original_method = "1FD4A483F618FB6B6B2EA6F438798B25", hash_generated_method = "1BA8E685BCE61ABA518E016E0FF40F1E")
    @DSModeled(DSC.SAFE)
     long postIdentifier() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mPostIdentifier;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.540 -0400", hash_original_method = "555C5182696D3D1E5A8F07F29E226BC9", hash_generated_method = "0ADA052A416C4C0C5783096B5C62BE71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void attachRequestHandle(RequestHandle requestHandle) {
        dsTaint.addTaint(requestHandle.dsTaint);
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) {
            //Log.v(LOGTAG, "LoadListener.attachRequestHandle(): " +
                    //"requestHandle: " +  requestHandle);
        //}
        //mRequestHandle = requestHandle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.541 -0400", hash_original_method = "A03FA80E3F939CA589BDCCBFD92DE3E2", hash_generated_method = "BDF1A7E1FC3C2077A98A5A519EEA781B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void detachRequestHandle() {
        mRequestHandle = null;
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) {
            //Log.v(LOGTAG, "LoadListener.detachRequestHandle(): " +
                    //"requestHandle: " + mRequestHandle);
        //}
        //mRequestHandle = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.541 -0400", hash_original_method = "34F543213ABA35F3500E526ABE3EA0BF", hash_generated_method = "C51EE3EB880DEE2C6E9A9DFF6BE15A5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void downloadFile() {
        WebViewWorker.getHandler().obtainMessage(
                WebViewWorker.MSG_REMOVE_CACHE, this).sendToTarget();
        mBrowserFrame.getCallbackProxy().onDownloadStart(url(), 
                mBrowserFrame.getUserAgentString(),
                mHeaders.getContentDisposition(), 
                mMimeType, mContentLength);
        cancel();
        // ---------- Original Method ----------
        //WebViewWorker.getHandler().obtainMessage(
                //WebViewWorker.MSG_REMOVE_CACHE, this).sendToTarget();
        //mBrowserFrame.getCallbackProxy().onDownloadStart(url(), 
                //mBrowserFrame.getUserAgentString(),
                //mHeaders.getContentDisposition(), 
                //mMimeType, mContentLength);
        //cancel();
    }

    
        static boolean willLoadFromCache(String url, long identifier) {
        assert !JniUtil.useChromiumHttpStack();
        boolean inCache =
                CacheManager.getCacheFile(url, identifier, null) != null;
        if (DebugFlags.LOAD_LISTENER) {
            Log.v(LOGTAG, "willLoadFromCache: " + url + " in cache: " + 
                    inCache);
        }
        return inCache;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.541 -0400", hash_original_method = "D1C1DC94D32429EE46F2E8034E6F3CAD", hash_generated_method = "E5BFBF4C61B75C3DF875FCDE0EEBC18D")
    @DSModeled(DSC.SAFE)
     void resetCancel() {
        mCancelled = false;
        // ---------- Original Method ----------
        //mCancelled = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.541 -0400", hash_original_method = "AB4E07CAED8783333F5D8E2EFE2FEA5A", hash_generated_method = "2A4818AC38D538F1C009EB4E44F9FB22")
    @DSModeled(DSC.SAFE)
     String mimeType() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mMimeType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.542 -0400", hash_original_method = "EDB0721EF3A307F050BF15E668A80271", hash_generated_method = "B34981799C87CA63ED35C608EEA30BA3")
    @DSModeled(DSC.SAFE)
     String transferEncoding() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mTransferEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.542 -0400", hash_original_method = "A0A208846C45918947FC3EEE159224A3", hash_generated_method = "4CBDBD8A34E0103EFE6927FCEF6DC659")
    @DSModeled(DSC.SAFE)
     long contentLength() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mContentLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.542 -0400", hash_original_method = "78D8A8AE22C18C73CE2907680A09633B", hash_generated_method = "D7B58E33D6B765DEEEE5CAFF2690F9E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void commitHeadersCheckRedirect() {
        commitHeaders();
        // ---------- Original Method ----------
        //if (mCancelled) return;
        //if ((mStatusCode >= 301 && mStatusCode <= 303) || mStatusCode == 307 ||
                //(mStatusCode == 304 && mCacheLoader != null)) {
            //return;
        //}
        //commitHeaders();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.542 -0400", hash_original_method = "8E8E66962C082FBF4981B6E1121BFDBD", hash_generated_method = "8B2D81578421C5A4203A8BB81741AB51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void commitHeaders() {
        {
            boolean var9788089095FD8B842742F0D3B2475B66_1479467773 = (mIsMainPageLoader && CertTool.getCertType(mMimeType) != null);
        } //End collapsed parenthetic
        setNativeResponse();
        // ---------- Original Method ----------
        //if (mIsMainPageLoader && CertTool.getCertType(mMimeType) != null) {
            //return;
        //}
        //if (mAuthHeader != null) {
            //return;
        //}
        //setNativeResponse();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.542 -0400", hash_original_method = "E28F47114E6BDDF9FD429A699C881F5C", hash_generated_method = "F40BDC9F30E4C4D1515A763F676892C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setNativeResponse() {
        int nativeResponse;
        nativeResponse = createNativeResponse();
        nativeReceivedResponse(nativeResponse);
        mSetNativeResponse = true;
        // ---------- Original Method ----------
        //int nativeResponse = createNativeResponse();
        //nativeReceivedResponse(nativeResponse);
        //mSetNativeResponse = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.543 -0400", hash_original_method = "90DA669053E3EAB1E41208AD478B9563", hash_generated_method = "CF4D2493BDDEE28D234C369DC0489272")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int createNativeResponse() {
        int statusCode;
        statusCode = HTTP_OK;
        statusCode = mStatusCode;
        int nativeResponse;
        nativeResponse = nativeCreateResponse(
                originalUrl(), statusCode, mStatusText,
                mMimeType, mContentLength, mEncoding);
        {
            mHeaders.getHeaders(new Headers.HeaderCallback() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.543 -0400", hash_original_method = "69E60F28B81345DBCE843A767C941042", hash_generated_method = "64547494959DDBF986AF7C3447759AFA")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public void header(String name, String value) {
                    dsTaint.addTaint(name);
                    dsTaint.addTaint(value);
                    nativeSetResponseHeader(nativeResponse, name, value);
                    // ---------- Original Method ----------
                    //nativeSetResponseHeader(nativeResponse, name, value);
                }
});
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int statusCode = (mStatusCode == HTTP_NOT_MODIFIED &&
                //mCacheLoader != null) ? HTTP_OK : mStatusCode;
        //final int nativeResponse = nativeCreateResponse(
                //originalUrl(), statusCode, mStatusText,
                //mMimeType, mContentLength, mEncoding);
        //if (mHeaders != null) {
            //mHeaders.getHeaders(new Headers.HeaderCallback() {
                    //public void header(String name, String value) {
                        //nativeSetResponseHeader(nativeResponse, name, value);
                    //}
                //});
        //}
        //return nativeResponse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.544 -0400", hash_original_method = "6C3510E057E7F86D9E5BFE641B751A6D", hash_generated_method = "224888B80B7C6536C97EB34D9071E956")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void commitLoad() {
        {
            setNativeResponse();
        } //End block
        {
            String type;
            type = CertTool.getCertType(mMimeType);
            {
                {
                    byte[] cert;
                    cert = new byte[mDataBuilder.getByteSize()];
                    int offset;
                    offset = 0;
                    {
                        ByteArrayBuilder.Chunk c;
                        c = mDataBuilder.getFirstChunk();
                        {
                            System.arraycopy(c.mArray, 0, cert, offset, c.mLength);
                            offset += c.mLength;
                        } //End block
                        c.release();
                    } //End block
                    CertTool.addCertificate(mContext, type, cert);
                    mBrowserFrame.stopLoading();
                } //End block
            } //End block
        } //End block
        ByteArrayBuilder.Chunk c;
        {
            c = mDataBuilder.getFirstChunk();
            {
                nativeAddData(c.mArray, c.mLength);
                WebViewWorker.CacheData data;
                data = new WebViewWorker.CacheData();
                data.mListener = this;
                data.mChunk = c;
                WebViewWorker.getHandler().obtainMessage(
                        WebViewWorker.MSG_APPEND_CACHE, data).sendToTarget();
            } //End block
            {
                c.release();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.544 -0400", hash_original_method = "622A6BD0A40561F44F0949C5CF1F5483", hash_generated_method = "D5CFC8FCE596C08EFC8FB05F73FCE58D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void tearDown() {
        {
            boolean varAB9E8CB6A473BE0B33C57182B7F91870_1143777937 = (getErrorID() == OK);
            {
                WebViewWorker.CacheSaveData data;
                data = new WebViewWorker.CacheSaveData();
                data.mListener = this;
                data.mUrl = mUrl;
                data.mPostId = mPostIdentifier;
                WebViewWorker.getHandler().obtainMessage(
                    WebViewWorker.MSG_SAVE_CACHE, data).sendToTarget();
            } //End block
            {
                WebViewWorker.getHandler().obtainMessage(
                    WebViewWorker.MSG_REMOVE_CACHE, this).sendToTarget();
            } //End block
        } //End collapsed parenthetic
        {
            {
                setNativeResponse();
            } //End block
            nativeFinished();
            clearNativeLoader();
        } //End block
        // ---------- Original Method ----------
        //if (getErrorID() == OK) {
            //WebViewWorker.CacheSaveData data = new WebViewWorker.CacheSaveData();
            //data.mListener = this;
            //data.mUrl = mUrl;
            //data.mPostId = mPostIdentifier;
            //WebViewWorker.getHandler().obtainMessage(
                    //WebViewWorker.MSG_SAVE_CACHE, data).sendToTarget();
        //} else {
            //WebViewWorker.getHandler().obtainMessage(
                    //WebViewWorker.MSG_REMOVE_CACHE, this).sendToTarget();
        //}
        //if (mNativeLoader != 0) {
            //if (!mSetNativeResponse) {
                //setNativeResponse();
            //}
            //nativeFinished();
            //clearNativeLoader();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.545 -0400", hash_original_method = "209FBE9F3E1C7384DEBC7D7B19E27A8A", hash_generated_method = "CD98762191921137533EED661E28667B")
    @DSModeled(DSC.SAFE)
    private int getErrorID() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mErrorID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.545 -0400", hash_original_method = "D67F514368DCF056FAAB1F778CFC87BD", hash_generated_method = "65F43BBB00759428DCB5D0C4D11A5F8C")
    @DSModeled(DSC.SAFE)
    private String getErrorDescription() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mErrorDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.546 -0400", hash_original_method = "E680E4717FCBA329FAA87BAD42E56CAC", hash_generated_method = "C7261BAE34AAAD545B599297E0284F8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void notifyError() {
        {
            String description;
            description = getErrorDescription();
            description = "";
            nativeError(getErrorID(), description, url());
            clearNativeLoader();
        } //End block
        // ---------- Original Method ----------
        //if (mNativeLoader != 0) {
            //String description = getErrorDescription();
            //if (description == null) description = "";
            //nativeError(getErrorID(), description, url());
            //clearNativeLoader();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.546 -0400", hash_original_method = "DFC23EFD31E5C4FF40E98CE1A64FD5ED", hash_generated_method = "D0F196AB49DC743F8DB7AEEFB59566B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void pauseLoad(boolean pause) {
        dsTaint.addTaint(pause);
        {
            mRequestHandle.pauseRequest(pause);
        } //End block
        // ---------- Original Method ----------
        //if (mRequestHandle != null) {
            //mRequestHandle.pauseRequest(pause);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.546 -0400", hash_original_method = "1181D36634AC97975F684A5C861366C7", hash_generated_method = "2D1A43E511ACBC3B72914B7AA57BF9A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void cancel() {
        {
            mRequestHandle.cancel();
            mRequestHandle = null;
        } //End block
        WebViewWorker.getHandler().obtainMessage(
                WebViewWorker.MSG_REMOVE_CACHE, this).sendToTarget();
        mCancelled = true;
        clearNativeLoader();
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) {
            //if (mRequestHandle == null) {
                //Log.v(LOGTAG, "LoadListener.cancel(): no requestHandle");
            //} else {
                //Log.v(LOGTAG, "LoadListener.cancel()");
            //}
        //}
        //if (mRequestHandle != null) {
            //mRequestHandle.cancel();
            //mRequestHandle = null;
        //}
        //WebViewWorker.getHandler().obtainMessage(
                //WebViewWorker.MSG_REMOVE_CACHE, this).sendToTarget();
        //mCancelled = true;
        //clearNativeLoader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.547 -0400", hash_original_method = "A28FBC4A594C62B1FB221C43DC1C2583", hash_generated_method = "EBB1A4195F785F080D6CEC6E5D727BA1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void doRedirect() {
        {
            handleError(EventHandler.ERROR_REDIRECT_LOOP, mContext.getString(
                    R.string.httpErrorRedirectLoop));
        } //End block
        String redirectTo;
        redirectTo = mHeaders.getLocation();
        {
            int nativeResponse;
            nativeResponse = createNativeResponse();
            redirectTo =
                    nativeRedirectedToUrl(mUrl, redirectTo, nativeResponse);
            {
                Log.d(LOGTAG, "Redirection failed for "
                        + mHeaders.getLocation());
                cancel();
            } //End block
            {
                boolean var4BC74C0339FF0D282D6889513716AF46_378919756 = (!URLUtil.isNetworkUrl(redirectTo));
                {
                    String text;
                    text = mContext
                        .getString(R.string.open_permission_deny)
                        + "\n" + redirectTo;
                    {
                        setNativeResponse();
                    } //End block
                    nativeAddData(text.getBytes(), text.length());
                    nativeFinished();
                    clearNativeLoader();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var9FABAD625F3CF927825C199D1CB19D00_27559627 = (getErrorID() == OK);
                {
                    WebViewWorker.CacheSaveData data;
                    data = new WebViewWorker.CacheSaveData();
                    data.mListener = this;
                    data.mUrl = mUrl;
                    data.mPostId = mPostIdentifier;
                    WebViewWorker.getHandler().obtainMessage(
                        WebViewWorker.MSG_SAVE_CACHE, data).sendToTarget();
                } //End block
                {
                    WebViewWorker.getHandler().obtainMessage(
                        WebViewWorker.MSG_REMOVE_CACHE, this).sendToTarget();
                } //End block
            } //End collapsed parenthetic
            mOriginalUrl = redirectTo;
            setUrl(redirectTo);
            {
                mRequestHeaders = new HashMap<String, String>();
            } //End block
            boolean fromCache;
            fromCache = false;
            {
                fromCache = true;
            } //End block
            {
                boolean var5B86DF6F22EC6A011A7E7F676EE6B6AB_880504551 = (!checkCache(mRequestHeaders));
                {
                    {
                        try 
                        {
                            mRequestHandle.setupRedirect(mUrl, mStatusCode,
                                mRequestHeaders);
                        } //End block
                        catch (RuntimeException e)
                        {
                            handleError(EventHandler.ERROR_BAD_URL,
                                mContext.getString(R.string.httpErrorBadUrl));
                        } //End block
                    } //End block
                    {
                        Network network;
                        network = Network.getInstance(getContext());
                        {
                            boolean var39F3D24FAA0DC03AD29BF73501987F25_1649654949 = (!network.requestURL(mMethod, mRequestHeaders,
                            mPostData, this));
                            {
                                handleError(EventHandler.ERROR_BAD_URL,
                                mContext.getString(R.string.httpErrorBadUrl));
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        mRequestHandle.setRedirectCount(mCacheRedirectCount);
                    } //End block
                } //End block
                {
                    mCacheRedirectCount = mRequestHandle.getRedirectCount() + 1;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            commitHeaders();
            commitLoad();
            tearDown();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.548 -0400", hash_original_method = "F42460285C9091878E41158B4AED6A71", hash_generated_method = "4BBBC148C84F672CAD2D4986BC0D5170")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void parseContentTypeHeader(String contentType) {
        dsTaint.addTaint(contentType);
        {
            int i;
            i = contentType.indexOf(';');
            {
                mMimeType = contentType.substring(0, i);
                int j;
                j = contentType.indexOf('=', i);
                {
                    i = contentType.indexOf(';', j);
                    {
                        i = contentType.length();
                    } //End block
                    mEncoding = contentType.substring(j + 1, i);
                } //End block
                {
                    mEncoding = contentType.substring(i + 1);
                } //End block
                mEncoding = mEncoding.trim().toLowerCase();
                {
                    boolean var13B27D95A9632914626DBEBE651A12EF_1841886704 = (i < contentType.length() - 1);
                    {
                        mTransferEncoding =
                            contentType.substring(i + 1).trim().toLowerCase();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            mMimeType = mMimeType.trim();
            try 
            {
                Matcher m;
                m = CONTENT_TYPE_PATTERN.matcher(mMimeType);
                {
                    boolean var39BD3106C7A2329BC5A3364836FB2CF9_54454580 = (m.find());
                    {
                        mMimeType = m.group(1);
                    } //End block
                    {
                        guessMimeType();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (IllegalStateException ex)
            {
                guessMimeType();
            } //End block
        } //End block
        mMimeType = mMimeType.toLowerCase();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.549 -0400", hash_original_method = "AE0FC74CC8A0BC926B5DCE69D72EC94D", hash_generated_method = "9D52576E1FC5F89C36FF2C4CD22509F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private HttpAuthHeader parseAuthHeader(String header) {
        dsTaint.addTaint(header);
        {
            int posMax;
            posMax = 256;
            int posLen;
            posLen = 0;
            int[] pos;
            pos = new int [posMax];
            int headerLen;
            headerLen = header.length();
            {
                boolean quoted;
                quoted = false;
                {
                    int i;
                    i = 0;
                    {
                        {
                            boolean varEED5FE80D284B29088CDC3B2020C18BA_1297655640 = (header.charAt(i) == '\"');
                            {
                                quoted = !quoted;
                            } //End block
                            {
                                {
                                    {
                                        boolean varA6D900745186AB55FA6DC70E044D90E7_1291529798 = (header.regionMatches(true, i,
                                    HttpAuthHeader.BASIC_TOKEN, 0,
                                    HttpAuthHeader.BASIC_TOKEN.length()));
                                        {
                                            pos[posLen++] = i;
                                        } //End block
                                    } //End collapsed parenthetic
                                    {
                                        boolean var9BB96610CCDD0A2CA167EA62D5B1E782_305244479 = (header.regionMatches(true, i,
                                    HttpAuthHeader.DIGEST_TOKEN, 0,
                                    HttpAuthHeader.DIGEST_TOKEN.length()));
                                        {
                                            pos[posLen++] = i;
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    int i;
                    i = 0;
                    {
                        {
                            boolean var0F7ADCB64C853D5C60254F8DA31AB71B_799417850 = (header.regionMatches(true, pos[i],
                                HttpAuthHeader.DIGEST_TOKEN, 0,
                                HttpAuthHeader.DIGEST_TOKEN.length()));
                            {
                                String sub;
                                sub = header.substring(pos[i],
                                (i + 1 < posLen ? pos[i + 1] : headerLen));//DSFIXME:  CODE0008: Nested ternary operator in expression
                                HttpAuthHeader rval;
                                rval = new HttpAuthHeader(sub);
                                {
                                    boolean var049D67944127B174A09BA345E9C65282_394271436 = (rval.isSupportedScheme());
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    int i;
                    i = 0;
                    {
                        {
                            boolean var3C860FF7CD9160C8A47433614CAD0330_1182153768 = (header.regionMatches(true, pos[i],
                                HttpAuthHeader.BASIC_TOKEN, 0,
                                HttpAuthHeader.BASIC_TOKEN.length()));
                            {
                                String sub;
                                sub = header.substring(pos[i],
                                (i + 1 < posLen ? pos[i + 1] : headerLen));//DSFIXME:  CODE0008: Nested ternary operator in expression
                                HttpAuthHeader rval;
                                rval = new HttpAuthHeader(sub);
                                {
                                    boolean var049D67944127B174A09BA345E9C65282_1026048414 = (rval.isSupportedScheme());
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        return (HttpAuthHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.549 -0400", hash_original_method = "977413F84EEA9D9E0B7BBB5D674FC9E7", hash_generated_method = "775ED54514896B1CA629C5B444E2898F")
    @DSModeled(DSC.SAFE)
    private boolean ignoreCallbacks() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mCancelled || mAuthHeader != null ||
                //(mStatusCode > 300 && mStatusCode < 400 && mStatusCode != 305));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.549 -0400", hash_original_method = "B1CFB6FACF3C8464BDC576EEF15EE2EE", hash_generated_method = "F08BB084965D4F2D3A66ED7551D7970D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setUrl(String url) {
        dsTaint.addTaint(url);
        {
            mUri = null;
            {
                boolean varB7E6CB04F9FE3A0CBF3E091A2172F917_416040365 = (URLUtil.isNetworkUrl(url));
                {
                    mUrl = URLUtil.stripAnchor(url);
                    try 
                    {
                        mUri = new WebAddress(mUrl);
                    } //End block
                    catch (ParseException e)
                    {
                        e.printStackTrace();
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (url != null) {
            //mUri = null;
            //if (URLUtil.isNetworkUrl(url)) {
                //mUrl = URLUtil.stripAnchor(url);
                //try {
                    //mUri = new WebAddress(mUrl);
                //} catch (ParseException e) {
                    //e.printStackTrace();
                //}
            //} else {
                //mUrl = url;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.550 -0400", hash_original_method = "EF260C0902D2E84B94B185FE48F20D51", hash_generated_method = "D1E753B4407F09D91B4CAFE437438DAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void guessMimeType() {
        {
            boolean varC2714C547A38705DE5583ECBFD766FDE_603771345 = (URLUtil.isDataUrl(mUrl) && mMimeType.length() != 0);
            {
                cancel();
                String text;
                text = mContext.getString(R.string.httpErrorBadUrl);
                handleError(EventHandler.ERROR_BAD_URL, text);
            } //End block
            {
                mMimeType = "text/html";
                String newMimeType;
                newMimeType = guessMimeTypeFromExtension(mUrl);
                {
                    mMimeType = newMimeType;
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (URLUtil.isDataUrl(mUrl) && mMimeType.length() != 0) {
            //cancel();
            //final String text = mContext.getString(R.string.httpErrorBadUrl);
            //handleError(EventHandler.ERROR_BAD_URL, text);
        //} else {
            //mMimeType = "text/html";
            //String newMimeType = guessMimeTypeFromExtension(mUrl);
            //if (newMimeType != null) {
                //mMimeType = newMimeType;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.550 -0400", hash_original_method = "2EA3CE69FA8B837FDAA4CA6DE51D2499", hash_generated_method = "597E97303C4ED9C092355ADB40D7DEDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String guessMimeTypeFromExtension(String url) {
        dsTaint.addTaint(url);
        String varED5BD54B837D222B18F7C793AE24DE18_228565581 = (MimeTypeMap.getSingleton().getMimeTypeFromExtension(
                MimeTypeMap.getFileExtensionFromUrl(url)));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) {
            //Log.v(LOGTAG, "guessMimeTypeFromExtension: url = " + url);
        //}
        //return MimeTypeMap.getSingleton().getMimeTypeFromExtension(
                //MimeTypeMap.getFileExtensionFromUrl(url));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.550 -0400", hash_original_method = "4C14C55105A23524352CD131708D205A", hash_generated_method = "766F6286368C8FE0FDD083AC2DA73442")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendMessageInternal(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        {
            mMessageQueue.add(msg);
        } //End block
        {
            sendMessage(msg);
        } //End block
        // ---------- Original Method ----------
        //if (mSynchronous) {
            //mMessageQueue.add(msg);
        //} else {
            //sendMessage(msg);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.550 -0400", hash_original_method = "84B3C85DEED8CE51C1D689DF257AD721", hash_generated_method = "BD6706BDC7514C5CBFE49F3FB39EBEBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void loadSynchronousMessages() {
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        } //End block
        {
            boolean var8F5875506F461E3D4FAABDB7CF8E2CD9_399843754 = (!mMessageQueue.isEmpty());
            {
                handleMessage(mMessageQueue.remove(0));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER && !mSynchronous) {
            //throw new AssertionError();
        //}
        //while (!mMessageQueue.isEmpty()) {
            //handleMessage(mMessageQueue.remove(0));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.551 -0400", hash_original_method = "4DA58223C4F20A38192632BBFEEE57C8", hash_generated_method = "F5D5D0F871F964D21113FAF7A7575756")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeCreateResponse(String url, int statusCode,
            String statusText, String mimeType, long expectedLength,
            String encoding) {
        dsTaint.addTaint(statusCode);
        dsTaint.addTaint(expectedLength);
        dsTaint.addTaint(encoding);
        dsTaint.addTaint(statusText);
        dsTaint.addTaint(mimeType);
        dsTaint.addTaint(url);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.551 -0400", hash_original_method = "BA6D20A53269A42AE8656C6EBDDFC70F", hash_generated_method = "C9E54489653FEC4AC18169AF8A8F518B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetResponseHeader(int nativeResponse, String key,
            String val) {
        dsTaint.addTaint(val);
        dsTaint.addTaint(nativeResponse);
        dsTaint.addTaint(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.551 -0400", hash_original_method = "41C6950B308582DB9C9A99E22648CC08", hash_generated_method = "C42C4279713E72C2032A2E8F51F8E564")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeReceivedResponse(int nativeResponse) {
        dsTaint.addTaint(nativeResponse);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.551 -0400", hash_original_method = "CB7AF973B7AC5B91CFB8AF007E1C0D32", hash_generated_method = "33F4353A5D2818E5BB807C21598518CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeAddData(byte[] data, int length) {
        dsTaint.addTaint(length);
        dsTaint.addTaint(data[0]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.551 -0400", hash_original_method = "49549DEACC297430F7E9805D3678A016", hash_generated_method = "F76CF5604F7D206ECF3936D4EC9118B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeFinished() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.552 -0400", hash_original_method = "33F440D9D1697DCCED15CDDD044058A8", hash_generated_method = "B0B44F8D138D1FB2CD649DCDEECEE048")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String nativeRedirectedToUrl(String baseUrl,
            String redirectTo, int nativeResponse) {
        dsTaint.addTaint(baseUrl);
        dsTaint.addTaint(nativeResponse);
        dsTaint.addTaint(redirectTo);
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.552 -0400", hash_original_method = "BCCFE0CFBD3782D8BEDE6CB5D0F9DEA3", hash_generated_method = "1E83582CF91AC0D0FDA333E6E0D43B78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeError(int id, String desc, String failingUrl) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(desc);
        dsTaint.addTaint(failingUrl);
    }

    
    private static final String LOGTAG = "webkit";
    private static final int MSG_CONTENT_HEADERS = 100;
    private static final int MSG_CONTENT_DATA = 110;
    private static final int MSG_CONTENT_FINISHED = 120;
    private static final int MSG_CONTENT_ERROR = 130;
    private static final int MSG_LOCATION_CHANGED = 140;
    private static final int MSG_LOCATION_CHANGED_REQUEST = 150;
    private static final int MSG_STATUS = 160;
    private static final int MSG_SSL_CERTIFICATE = 170;
    private static final int MSG_SSL_ERROR = 180;
    private static final int HTTP_OK = 200;
    private static final int HTTP_PARTIAL_CONTENT = 206;
    private static final int HTTP_MOVED_PERMANENTLY = 301;
    private static final int HTTP_FOUND = 302;
    private static final int HTTP_SEE_OTHER = 303;
    private static final int HTTP_NOT_MODIFIED = 304;
    private static final int HTTP_TEMPORARY_REDIRECT = 307;
    private static final int HTTP_AUTH = 401;
    private static final int HTTP_NOT_FOUND = 404;
    private static final int HTTP_PROXY_AUTH = 407;
    private static int sNativeLoaderCount;
    private static final String XML_MIME_TYPE =
            "^[\\w_\\-+~!$\\^{}|.%'`#&*]+/" +
            "[\\w_\\-+~!$\\^{}|.%'`#&*]+\\+xml$";
    private static final Pattern CONTENT_TYPE_PATTERN =
            Pattern.compile("^((?:[xX]-)?[a-zA-Z\\*]+/[\\w\\+\\*-]+[\\.[\\w\\+-]+]*)$");
}

