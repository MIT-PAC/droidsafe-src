package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.net.http.ErrorStrings;
import android.net.http.EventHandler;
import android.net.http.RequestHandle;
import android.os.Build;
import android.util.Log;
import android.webkit.CacheManager.CacheResult;
import android.webkit.JniUtil;
import java.util.HashMap;
import java.util.Map;

class FrameLoader {
    private LoadListener mListener;
    private String mMethod;
    private WebSettings mSettings;
    private Map<String, String> mHeaders;
    private byte[] mPostData;
    private Network mNetwork;
    private int mCacheMode;
    private String mReferrer;
    private String mContentType;
    private String mUaprofHeader;
    private WebResourceResponse mInterceptResponse;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.238 -0400", hash_original_method = "E604BA5F97EB5A21051EE698F8A56155", hash_generated_method = "09E6C03CD8934FD9A15F1E445202331D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     FrameLoader(LoadListener listener, WebSettings settings,
            String method, WebResourceResponse interceptResponse) {
        dsTaint.addTaint(interceptResponse.dsTaint);
        dsTaint.addTaint(settings.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(method);
        mHeaders = null;
        mCacheMode = WebSettings.LOAD_NORMAL;
        mUaprofHeader = mListener.getContext().getResources().getString(
                com.android.internal.R.string.config_useragentprofile_url, Build.MODEL);
        // ---------- Original Method ----------
        //assert !JniUtil.useChromiumHttpStack();
        //mListener = listener;
        //mHeaders = null;
        //mMethod = method;
        //mCacheMode = WebSettings.LOAD_NORMAL;
        //mSettings = settings;
        //mInterceptResponse = interceptResponse;
        //mUaprofHeader = mListener.getContext().getResources().getString(
                //com.android.internal.R.string.config_useragentprofile_url, Build.MODEL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.239 -0400", hash_original_method = "DAE08684530294543D6392896259C957", hash_generated_method = "FD45662ADFC054133E4B843569459CC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setReferrer(String ref) {
        dsTaint.addTaint(ref);
        {
            boolean var922AE2E711C836132B2F09AEA7CED413_2019333505 = (URLUtil.isNetworkUrl(ref));
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (URLUtil.isNetworkUrl(ref)) mReferrer = ref;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.239 -0400", hash_original_method = "D2C8C4DED03F288D6E8AB32DB5451075", hash_generated_method = "6A461DAC7AEEB84442860AB344D1CA34")
    @DSModeled(DSC.SAFE)
    public void setPostData(byte[] postData) {
        dsTaint.addTaint(postData[0]);
        // ---------- Original Method ----------
        //mPostData = postData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.239 -0400", hash_original_method = "E910F46151D172102331975C2568BBCE", hash_generated_method = "506CBD6FCF2194C7D3DE584BF1D2E391")
    @DSModeled(DSC.SAFE)
    public void setContentTypeForPost(String postContentType) {
        dsTaint.addTaint(postContentType);
        // ---------- Original Method ----------
        //mContentType = postContentType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.239 -0400", hash_original_method = "4FD1C5F2E68FCD3B6425DADD4042F496", hash_generated_method = "C525F22B1515B9C4B987E6E4AA021D8F")
    @DSModeled(DSC.SAFE)
    public void setCacheMode(int cacheMode) {
        dsTaint.addTaint(cacheMode);
        // ---------- Original Method ----------
        //mCacheMode = cacheMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.240 -0400", hash_original_method = "E0E34456BA61E1D94659FB0013B44B13", hash_generated_method = "C1827827C932EF92A06890CFDDF4FDAD")
    @DSModeled(DSC.SAFE)
    public void setHeaders(HashMap headers) {
        dsTaint.addTaint(headers.dsTaint);
        // ---------- Original Method ----------
        //mHeaders = headers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.240 -0400", hash_original_method = "C430EEAE75F5C9BA4DF5580B50F4FE67", hash_generated_method = "AE5AC07D3D4DF609762B7A7AEFB84208")
    @DSModeled(DSC.SAFE)
    public LoadListener getLoadListener() {
        return (LoadListener)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.241 -0400", hash_original_method = "C44DBC63D87836D797664A5A599046E9", hash_generated_method = "FAC6B4025B3E108300DE58C245342159")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean executeLoad() {
        String url;
        url = mListener.url();
        {
            {
                boolean varDC12B1CE651184F7487BC2CD3AF93BC4_434301093 = (mListener.isSynchronous());
                {
                    mInterceptResponse.loader(mListener).load();
                } //End block
                {
                    WebViewWorker.getHandler().obtainMessage(
                        WebViewWorker.MSG_ADD_STREAMLOADER,
                        mInterceptResponse.loader(mListener)).sendToTarget();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var4F95E4BDE23CE2774CDB1234D95999CA_42001152 = (URLUtil.isNetworkUrl(url));
            {
                {
                    boolean var293388128A8B804CF07E61838E699C6F_1659629586 = (mSettings.getBlockNetworkLoads());
                    {
                        mListener.error(EventHandler.ERROR_BAD_URL,
                        mListener.getContext().getString(
                                com.android.internal.R.string.httpErrorBadUrl));
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var4D7320D083FD883A3E69D199AAE6E271_821301237 = (!URLUtil.verifyURLEncoding(mListener.host()));
                    {
                        mListener.error(EventHandler.ERROR_BAD_URL,
                        mListener.getContext().getString(
                        com.android.internal.R.string.httpErrorBadUrl));
                    } //End block
                } //End collapsed parenthetic
                mNetwork = Network.getInstance(mListener.getContext());
                {
                    boolean var8E4B83D5369E9679F86F05C0F7F7EDBD_1836152124 = (mListener.isSynchronous());
                    {
                        boolean var519A1E3519349B18390578A9A8AAE9C6_930752847 = (handleHTTPLoad());
                    } //End block
                } //End collapsed parenthetic
                WebViewWorker.getHandler().obtainMessage(
                    WebViewWorker.MSG_ADD_HTTPLOADER, this).sendToTarget();
            } //End block
            {
                boolean var972F9ADE02003E2BF81443517B71BC8F_855558920 = (handleLocalFile(url, mListener, mSettings));
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        mListener.error(EventHandler.ERROR_UNSUPPORTED_SCHEME,
                mListener.getContext().getText(
                        com.android.internal.R.string.httpErrorUnsupportedScheme).toString());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static boolean handleLocalFile(String url, LoadListener loadListener,
            WebSettings settings) {
        assert !JniUtil.useChromiumHttpStack();
        try {
            url = new String(URLUtil.decode(url.getBytes()));
        } catch (IllegalArgumentException e) {
            loadListener.error(EventHandler.ERROR_BAD_URL,
                    loadListener.getContext().getString(
                            com.android.internal.R.string.httpErrorBadUrl));
            return true;
        }
        if (URLUtil.isAssetUrl(url)) {
            if (loadListener.isSynchronous()) {
                new FileLoader(url, loadListener, FileLoader.TYPE_ASSET,
                        true).load();
            } else {
                WebViewWorker.getHandler().obtainMessage(
                        WebViewWorker.MSG_ADD_STREAMLOADER,
                        new FileLoader(url, loadListener, FileLoader.TYPE_ASSET,
                                true)).sendToTarget();
            }
            return true;
        } else if (URLUtil.isResourceUrl(url)) {
            if (loadListener.isSynchronous()) {
                new FileLoader(url, loadListener, FileLoader.TYPE_RES,
                        true).load();
            } else {
                WebViewWorker.getHandler().obtainMessage(
                        WebViewWorker.MSG_ADD_STREAMLOADER,
                        new FileLoader(url, loadListener, FileLoader.TYPE_RES,
                                true)).sendToTarget();
            }
            return true;
        } else if (URLUtil.isFileUrl(url)) {
            if (loadListener.isSynchronous()) {
                new FileLoader(url, loadListener, FileLoader.TYPE_FILE,
                        settings.getAllowFileAccess()).load();
            } else {
                WebViewWorker.getHandler().obtainMessage(
                        WebViewWorker.MSG_ADD_STREAMLOADER,
                        new FileLoader(url, loadListener, FileLoader.TYPE_FILE,
                                settings.getAllowFileAccess())).sendToTarget();
            }
            return true;
        } else if (settings.getAllowContentAccess() &&
                   URLUtil.isContentUrl(url)) {
            if (loadListener.isSynchronous()) {
                new ContentLoader(loadListener.url(), loadListener).load();
            } else {
                WebViewWorker.getHandler().obtainMessage(
                        WebViewWorker.MSG_ADD_STREAMLOADER,
                        new ContentLoader(loadListener.url(), loadListener))
                        .sendToTarget();
            }
            return true;
        } else if (URLUtil.isDataUrl(url)) {
            new DataLoader(url, loadListener).load();
            return true;
        } else if (URLUtil.isAboutUrl(url)) {
            loadListener.data(mAboutBlank.getBytes(), mAboutBlank.length());
            loadListener.endData();
            return true;
        }
        return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.243 -0400", hash_original_method = "24B8F725DD0D2F171F529FAFE2897245", hash_generated_method = "674AE1160C2DE6A4AA6E00191821752C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean handleHTTPLoad() {
        {
            mHeaders = new HashMap<String, String>();
        } //End block
        populateStaticHeaders();
        populateHeaders();
        {
            boolean var9199F4C173F71DEA77808833A6EB5244_1504091752 = (handleCache());
            {
                mListener.setRequestData(mMethod, mHeaders, mPostData);
            } //End block
        } //End collapsed parenthetic
        boolean ret;
        ret = false;
        int error;
        error = EventHandler.ERROR_UNSUPPORTED_SCHEME;
        try 
        {
            ret = mNetwork.requestURL(mMethod, mHeaders,
                    mPostData, mListener);
        } //End block
        catch (android.net.ParseException ex)
        {
            error = EventHandler.ERROR_BAD_URL;
        } //End block
        catch (java.lang.RuntimeException ex)
        {
            error = EventHandler.ERROR_BAD_URL;
        } //End block
        {
            mListener.error(error, ErrorStrings.getString(error, mListener.getContext()));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.243 -0400", hash_original_method = "D628211A63EBF198D6007A9671F95672", hash_generated_method = "C52E9AB11D3AA212067AEF5B57C3E450")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void startCacheLoad(CacheResult result) {
        dsTaint.addTaint(result.dsTaint);
        CacheLoader cacheLoader;
        cacheLoader = new CacheLoader(mListener, result);
        mListener.setCacheLoader(cacheLoader);
        {
            boolean var421DBB609B44F2D84DDA3573FCA0EFE3_133436302 = (mListener.isSynchronous());
            {
                cacheLoader.load();
            } //End block
            {
                WebViewWorker.getHandler().obtainMessage(
                    WebViewWorker.MSG_ADD_STREAMLOADER, cacheLoader).sendToTarget();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (DebugFlags.FRAME_LOADER) {
            //Log.v(LOGTAG, "FrameLoader: loading from cache: "
                  //+ mListener.url());
        //}
        //CacheLoader cacheLoader =
                //new CacheLoader(mListener, result);
        //mListener.setCacheLoader(cacheLoader);
        //if (mListener.isSynchronous()) {
            //cacheLoader.load();
        //} else {
            //WebViewWorker.getHandler().obtainMessage(
                    //WebViewWorker.MSG_ADD_STREAMLOADER, cacheLoader).sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.243 -0400", hash_original_method = "ED6284595A2927F289F312ED71C4BF2D", hash_generated_method = "BA652B72C7C8A66808A6AFA725C46757")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean handleCache() {
        //Begin case WebSettings.LOAD_CACHE_ONLY 
        {
            CacheResult result;
            result = CacheManager.getCacheFile(mListener.url(),
                        mListener.postIdentifier(), null);
            {
                startCacheLoad(result);
            } //End block
            {
                int err;
                err = EventHandler.FILE_NOT_FOUND_ERROR;
                mListener.error(err,
                            ErrorStrings.getString(err, mListener.getContext()));
            } //End block
        } //End block
        //End case WebSettings.LOAD_CACHE_ONLY 
        //Begin case WebSettings.LOAD_CACHE_ELSE_NETWORK 
        {
            CacheResult result;
            result = CacheManager.getCacheFile(mListener.url(),
                        mListener.postIdentifier(), null);
            {
                startCacheLoad(result);
            } //End block
        } //End block
        //End case WebSettings.LOAD_CACHE_ELSE_NETWORK 
        //Begin case default WebSettings.LOAD_NORMAL 
        boolean var362521B747867FCBBD590C55C27ADA13_1566433388 = (mListener.checkCache(mHeaders));
        //End case default WebSettings.LOAD_NORMAL 
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.244 -0400", hash_original_method = "2D0BB20A4C7261DEBC8826658FC12230", hash_generated_method = "A95C413AC0A253B90FBDE6704E82881F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void populateStaticHeaders() {
        String accept;
        accept = mHeaders.get("Accept");
        {
            boolean var353782AD537F075DB95ABEC34D405E80_679192005 = (accept == null || accept.length() == 0);
            {
                mHeaders.put("Accept", HEADER_STR);
            } //End block
        } //End collapsed parenthetic
        mHeaders.put("Accept-Charset", "utf-8, iso-8859-1, utf-16, *;q=0.7");
        String acceptLanguage;
        acceptLanguage = mSettings.getAcceptLanguage();
        {
            boolean var7E59D9D12F1F68F2FDA010D34D39C4BF_1415185648 = (acceptLanguage.length() > 0);
            {
                mHeaders.put("Accept-Language", acceptLanguage);
            } //End block
        } //End collapsed parenthetic
        mHeaders.put("User-Agent", mSettings.getUserAgentString());
        {
            boolean varDE1D6E5B2446D52EDEE8BF319F19138D_383906178 = (mUaprofHeader != null && mUaprofHeader.length() > 0);
            {
                mHeaders.put("x-wap-profile", mUaprofHeader);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //String accept = mHeaders.get("Accept");
        //if (accept == null || accept.length() == 0) {
            //mHeaders.put("Accept", HEADER_STR);
        //}
        //mHeaders.put("Accept-Charset", "utf-8, iso-8859-1, utf-16, *;q=0.7");
        //String acceptLanguage = mSettings.getAcceptLanguage();
        //if (acceptLanguage.length() > 0) {
            //mHeaders.put("Accept-Language", acceptLanguage);
        //}
        //mHeaders.put("User-Agent", mSettings.getUserAgentString());
        //if (mUaprofHeader != null && mUaprofHeader.length() > 0) {
            //mHeaders.put("x-wap-profile", mUaprofHeader);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.244 -0400", hash_original_method = "FC5DAD276D63BF9B93BD19919189EAE8", hash_generated_method = "6A4BE97E42BEDB5FD5E41EE103276400")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void populateHeaders() {
        mHeaders.put("Referer", mReferrer);
        mHeaders.put(CONTENT_TYPE, mContentType);
        {
            boolean varFB7727304C578C78AD2EA70B6435E572_1872999602 = (mNetwork.isValidProxySet());
            {
                String username;
                String password;
                {
                    username = mNetwork.getProxyUsername();
                    password = mNetwork.getProxyPassword();
                } //End block
                {
                    String proxyHeader;
                    proxyHeader = RequestHandle.authorizationHeader(true);
                    mHeaders.put(proxyHeader,
                        "Basic " + RequestHandle.computeBasicAuthResponse(
                                username, password));
                } //End block
            } //End block
        } //End collapsed parenthetic
        String cookie;
        cookie = CookieManager.getInstance().getCookie(
                mListener.getWebAddress());
        {
            boolean var6E2855FE1453DF0044F1B1E343DD13F2_1970921837 = (cookie != null && cookie.length() > 0);
            {
                mHeaders.put("Cookie", cookie);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static final int URI_PROTOCOL = 0x100;
    private static final String CONTENT_TYPE = "content-type";
    private static final String mAboutBlank =
            "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EB\">" +
            "<html><head><title>about:blank</title></head><body></body></html>";
    static final String HEADER_STR = "text/xml, text/html, " +
            "application/xhtml+xml, image/png, text/plain, */*;q=0.8";
    private static final String LOGTAG = "webkit";
}

