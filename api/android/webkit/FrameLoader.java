package android.webkit;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.Map;

import android.net.http.ErrorStrings;
import android.net.http.EventHandler;
import android.net.http.RequestHandle;
import android.os.Build;
import android.webkit.CacheManager.CacheResult;





class FrameLoader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.708 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "D7FBD6A4D07A65117411BC8C01652773")

    private LoadListener mListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.708 -0400", hash_original_field = "411D2DFDB93368C46AFADBEC76A54162", hash_generated_field = "46D356CEC2B798E53528C0BD5F09C873")

    private String mMethod;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.708 -0400", hash_original_field = "A5E11DE354AE2FBFC3E5565E23F4F865", hash_generated_field = "D4F7B9B886C1ADC785C82D3DD8AF3DFF")

    private WebSettings mSettings;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.708 -0400", hash_original_field = "9DA6583E4F64A78649E80D72BFE1DBCC", hash_generated_field = "A366B1C8ECA0EA3E5C2DAE5F1AFFA05D")

    private Map<String, String> mHeaders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.709 -0400", hash_original_field = "AF86FBE15EC2C25B16B35C7E4DD756CA", hash_generated_field = "C5200C1F2575A09491B18B8CE6E6A375")

    private byte[] mPostData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.709 -0400", hash_original_field = "92BCA70246F96A0F4366A7F1448D9E16", hash_generated_field = "E0FAA2A6C497494B58133B8740B95CC3")

    private Network mNetwork;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.709 -0400", hash_original_field = "F54BA5590C446F577AE73077661515C5", hash_generated_field = "8C07F09E694B2A8054749812D7A11348")

    private int mCacheMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.709 -0400", hash_original_field = "D0ACC05D6104FCC6E4DE0F3D0FCDE093", hash_generated_field = "D80C103FF159A690060174B576F408C0")

    private String mReferrer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.709 -0400", hash_original_field = "24B8797543549EFE4715ED8CFEFE95BC", hash_generated_field = "1F620CC4F21CDF80833E6AB697F4F4F7")

    private String mContentType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.709 -0400", hash_original_field = "0012BC49BA59EBAB5E247FD510C71F97", hash_generated_field = "DC5ABF50AC0DEDF84B387D0BCB7F8F31")

    private String mUaprofHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.709 -0400", hash_original_field = "2976D7B4B78ED29D3465A8FCEB8A8BEB", hash_generated_field = "1E5C1AADABD2F96959CCC93C619B3FFF")

    private WebResourceResponse mInterceptResponse;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.710 -0400", hash_original_method = "E604BA5F97EB5A21051EE698F8A56155", hash_generated_method = "A206A49D0F67A967CEB547485E0E8F49")
      FrameLoader(LoadListener listener, WebSettings settings,
            String method, WebResourceResponse interceptResponse) {
        mListener = listener;
        mHeaders = null;
        mMethod = method;
        mCacheMode = WebSettings.LOAD_NORMAL;
        mSettings = settings;
        mInterceptResponse = interceptResponse;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.731 -0400", hash_original_method = "DAE08684530294543D6392896259C957", hash_generated_method = "92386B791CB1171C17B7ECFBFCCD9818")
    public void setReferrer(String ref) {
        if(URLUtil.isNetworkUrl(ref))        
        mReferrer = ref;
        // ---------- Original Method ----------
        //if (URLUtil.isNetworkUrl(ref)) mReferrer = ref;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.731 -0400", hash_original_method = "D2C8C4DED03F288D6E8AB32DB5451075", hash_generated_method = "AFA899BAAE4627D629483619DC707622")
    public void setPostData(byte[] postData) {
        mPostData = postData;
        // ---------- Original Method ----------
        //mPostData = postData;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.731 -0400", hash_original_method = "E910F46151D172102331975C2568BBCE", hash_generated_method = "FA7AB8F86BB414F666064016C84E824E")
    public void setContentTypeForPost(String postContentType) {
        mContentType = postContentType;
        // ---------- Original Method ----------
        //mContentType = postContentType;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.731 -0400", hash_original_method = "4FD1C5F2E68FCD3B6425DADD4042F496", hash_generated_method = "07CDE86C3243F89B692735454AED33C1")
    public void setCacheMode(int cacheMode) {
        mCacheMode = cacheMode;
        // ---------- Original Method ----------
        //mCacheMode = cacheMode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.731 -0400", hash_original_method = "E0E34456BA61E1D94659FB0013B44B13", hash_generated_method = "E4CBCEFCEF3480884B759040661DF0A4")
    public void setHeaders(HashMap headers) {
        mHeaders = headers;
        // ---------- Original Method ----------
        //mHeaders = headers;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.731 -0400", hash_original_method = "C430EEAE75F5C9BA4DF5580B50F4FE67", hash_generated_method = "D014DE6A5C95DCC23F8D74F82033404B")
    public LoadListener getLoadListener() {
LoadListener varB7C366B3FCCD3E2168CA30DDDB430A4F_1244776930 =         mListener;
        varB7C366B3FCCD3E2168CA30DDDB430A4F_1244776930.addTaint(taint);
        return varB7C366B3FCCD3E2168CA30DDDB430A4F_1244776930;
        // ---------- Original Method ----------
        //return mListener;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.732 -0400", hash_original_method = "C44DBC63D87836D797664A5A599046E9", hash_generated_method = "F9F408113CE06FEC1A84C0281B5CC1B4")
    public boolean executeLoad() {
        String url = mListener.url();
        if(mInterceptResponse != null)        
        {
            if(mListener.isSynchronous())            
            {
                mInterceptResponse.loader(mListener).load();
            } //End block
            else
            {
                WebViewWorker.getHandler().obtainMessage(
                        WebViewWorker.MSG_ADD_STREAMLOADER,
                        mInterceptResponse.loader(mListener)).sendToTarget();
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_386824979 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_694329968 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_694329968;
        } //End block
        else
        if(URLUtil.isNetworkUrl(url))        
        {
            if(mSettings.getBlockNetworkLoads())            
            {
                mListener.error(EventHandler.ERROR_BAD_URL,
                        mListener.getContext().getString(
                                com.android.internal.R.string.httpErrorBadUrl));
                boolean var68934A3E9455FA72420237EB05902327_1275851176 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1792054940 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1792054940;
            } //End block
            if(!URLUtil.verifyURLEncoding(mListener.host()))            
            {
                mListener.error(EventHandler.ERROR_BAD_URL,
                        mListener.getContext().getString(
                        com.android.internal.R.string.httpErrorBadUrl));
                boolean var68934A3E9455FA72420237EB05902327_279198834 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_36991430 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_36991430;
            } //End block
            mNetwork = Network.getInstance(mListener.getContext());
            if(mListener.isSynchronous())            
            {
                boolean var03C36CD4DF7ED468A28523D62BCFED45_2022935723 = (handleHTTPLoad());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_559197977 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_559197977;
            } //End block
            WebViewWorker.getHandler().obtainMessage(
                    WebViewWorker.MSG_ADD_HTTPLOADER, this).sendToTarget();
            boolean varB326B5062B2F0E69046810717534CB09_437166118 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1207828444 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1207828444;
        } //End block
        else
        if(handleLocalFile(url, mListener, mSettings))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1142878065 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1819240758 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1819240758;
        } //End block
        if(DebugFlags.FRAME_LOADER)        
        {
        } //End block
        mListener.error(EventHandler.ERROR_UNSUPPORTED_SCHEME,
                mListener.getContext().getText(
                        com.android.internal.R.string.httpErrorUnsupportedScheme).toString());
        boolean var68934A3E9455FA72420237EB05902327_536315242 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_986172963 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_986172963;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.733 -0400", hash_original_method = "24B8F725DD0D2F171F529FAFE2897245", hash_generated_method = "B28637D304EB40844F78B9EBFE4C801D")
     boolean handleHTTPLoad() {
        if(mHeaders == null)        
        {
            mHeaders = new HashMap<String, String>();
        } //End block
        populateStaticHeaders();
        populateHeaders();
        if(handleCache())        
        {
            mListener.setRequestData(mMethod, mHeaders, mPostData);
            boolean varB326B5062B2F0E69046810717534CB09_1062780684 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2045303597 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2045303597;
        } //End block
        if(DebugFlags.FRAME_LOADER)        
        {
        } //End block
        boolean ret = false;
        int error = EventHandler.ERROR_UNSUPPORTED_SCHEME;
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
        if(!ret)        
        {
            mListener.error(error, ErrorStrings.getString(error, mListener.getContext()));
            boolean var68934A3E9455FA72420237EB05902327_1082296272 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1297051826 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1297051826;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_370884123 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_918223451 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_918223451;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.733 -0400", hash_original_method = "D628211A63EBF198D6007A9671F95672", hash_generated_method = "EAE83E1A2EF110E3F79827C2EF31B37F")
    private void startCacheLoad(CacheResult result) {
        addTaint(result.getTaint());
        if(DebugFlags.FRAME_LOADER)        
        {
        } //End block
        CacheLoader cacheLoader = new CacheLoader(mListener, result);
        mListener.setCacheLoader(cacheLoader);
        if(mListener.isSynchronous())        
        {
            cacheLoader.load();
        } //End block
        else
        {
            WebViewWorker.getHandler().obtainMessage(
                    WebViewWorker.MSG_ADD_STREAMLOADER, cacheLoader).sendToTarget();
        } //End block
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.733 -0400", hash_original_method = "ED6284595A2927F289F312ED71C4BF2D", hash_generated_method = "04CBE39D95ADC5EB67EE6CFC5AB62C19")
    private boolean handleCache() {
switch(mCacheMode){
        case WebSettings.LOAD_NO_CACHE:
        break;
        case WebSettings.LOAD_CACHE_ONLY:
        {
            CacheResult result = CacheManager.getCacheFile(mListener.url(),
                        mListener.postIdentifier(), null);
            if(result != null)            
            {
                startCacheLoad(result);
            } //End block
            else
            {
                int err = EventHandler.FILE_NOT_FOUND_ERROR;
                mListener.error(err,
                            ErrorStrings.getString(err, mListener.getContext()));
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1850289526 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_541187631 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_541187631;
        } //End block
        case WebSettings.LOAD_CACHE_ELSE_NETWORK:
        {
            if(DebugFlags.FRAME_LOADER)            
            {
            } //End block
            CacheResult result = CacheManager.getCacheFile(mListener.url(),
                        mListener.postIdentifier(), null);
            if(result != null)            
            {
                startCacheLoad(result);
                boolean varB326B5062B2F0E69046810717534CB09_881284421 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1220438794 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1220438794;
            } //End block
            break;
        } //End block
        default:
        case WebSettings.LOAD_NORMAL:
        boolean var54BEEA9328BF32A869AE4ED6EE467781_362152792 = (mListener.checkCache(mHeaders));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1725812079 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1725812079;
}        boolean var68934A3E9455FA72420237EB05902327_634586423 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_531557354 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_531557354;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.733 -0400", hash_original_method = "2D0BB20A4C7261DEBC8826658FC12230", hash_generated_method = "4712B931494AD22C3CCFAC85ADE49922")
    private void populateStaticHeaders() {
        String accept = mHeaders.get("Accept");
        if(accept == null || accept.length() == 0)        
        {
            mHeaders.put("Accept", HEADER_STR);
        } //End block
        mHeaders.put("Accept-Charset", "utf-8, iso-8859-1, utf-16, *;q=0.7");
        String acceptLanguage = mSettings.getAcceptLanguage();
        if(acceptLanguage.length() > 0)        
        {
            mHeaders.put("Accept-Language", acceptLanguage);
        } //End block
        mHeaders.put("User-Agent", mSettings.getUserAgentString());
        if(mUaprofHeader != null && mUaprofHeader.length() > 0)        
        {
            mHeaders.put("x-wap-profile", mUaprofHeader);
        } //End block
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.734 -0400", hash_original_method = "FC5DAD276D63BF9B93BD19919189EAE8", hash_generated_method = "EEEC9434E0A08CEA31852FC09037CFDA")
    private void populateHeaders() {
        if(mReferrer != null)        
        mHeaders.put("Referer", mReferrer);
        if(mContentType != null)        
        mHeaders.put(CONTENT_TYPE, mContentType);
        if(mNetwork.isValidProxySet())        
        {
            String username;
            String password;
            synchronized
(mNetwork)            {
                username = mNetwork.getProxyUsername();
                password = mNetwork.getProxyPassword();
            } //End block
            if(username != null && password != null)            
            {
                String proxyHeader = RequestHandle.authorizationHeader(true);
                mHeaders.put(proxyHeader,
                        "Basic " + RequestHandle.computeBasicAuthResponse(
                                username, password));
            } //End block
        } //End block
        String cookie = CookieManager.getInstance().getCookie(
                mListener.getWebAddress());
        if(cookie != null && cookie.length() > 0)        
        {
            mHeaders.put("Cookie", cookie);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.734 -0400", hash_original_field = "9C7D7F9ADBEF14BF8D36BF8372641839", hash_generated_field = "EB2ACDA5CCC677A93D03B81217EE2CA1")

    private static final int URI_PROTOCOL = 0x100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.734 -0400", hash_original_field = "3A558F5CAC0A7C913876ED4BEB31EAFC", hash_generated_field = "E9E9985B4D9BEACB3E20B77FBDAC6013")

    private static final String CONTENT_TYPE = "content-type";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.734 -0400", hash_original_field = "740BA245928812A52724E4131E81A743", hash_generated_field = "36FEC7407939A642CEE5B978BA5EE272")

    private static final String mAboutBlank = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EB\">" +
            "<html><head><title>about:blank</title></head><body></body></html>";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.734 -0400", hash_original_field = "50162879797A1E7821CDF8CDC1EE9986", hash_generated_field = "0A81A03C8AD82EEC7F102EB79209347D")

    static final String HEADER_STR = "text/xml, text/html, " +
            "application/xhtml+xml, image/png, text/plain, */*;q=0.8";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.734 -0400", hash_original_field = "9722F24E24D81405093C0E61AAF58518", hash_generated_field = "061362C112C980EB4954480FBAFBE378")

    private static final String LOGTAG = "webkit";
}

