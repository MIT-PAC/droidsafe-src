/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.Map;

import android.net.http.ErrorStrings;
import android.net.http.EventHandler;
import android.net.http.RequestHandle;
import android.os.Build;
import android.webkit.CacheManager.CacheResult;

class FrameLoader {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.920 -0500", hash_original_method = "0F090DDEC88C4F6DDE49E0CF19F424EB", hash_generated_method = "FD66A4B52C3F94D32976AC193BD637CB")
    
private static boolean handleLocalFile(String url, LoadListener loadListener,
            WebSettings settings) {
        assert !JniUtil.useChromiumHttpStack();

        // Attempt to decode the percent-encoded url before passing to the
        // local loaders.
        try {
            url = new String(URLUtil.decode(url.getBytes()));
        } catch (IllegalArgumentException e) {
            loadListener.error(EventHandler.ERROR_BAD_URL,
                    loadListener.getContext().getString(
                            com.android.internal.R.string.httpErrorBadUrl));
            // Return true here so we do not trigger an unsupported scheme
            // error.
            return true;
        }
        if (URLUtil.isAssetUrl(url)) {
            if (loadListener.isSynchronous()) {
                new FileLoader(url, loadListener, FileLoader.TYPE_ASSET,
                        true).load();
            } else {
                // load asset in a separate thread as it involves IO
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
                // load resource in a separate thread as it involves IO
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
                // load file in a separate thread as it involves IO
                WebViewWorker.getHandler().obtainMessage(
                        WebViewWorker.MSG_ADD_STREAMLOADER,
                        new FileLoader(url, loadListener, FileLoader.TYPE_FILE,
                                settings.getAllowFileAccess())).sendToTarget();
            }
            return true;
        } else if (settings.getAllowContentAccess() &&
                   URLUtil.isContentUrl(url)) {
            // Send the raw url to the ContentLoader because it will do a
            // permission check and the url has to match.
            if (loadListener.isSynchronous()) {
                new ContentLoader(loadListener.url(), loadListener).load();
            } else {
                // load content in a separate thread as it involves IO
                WebViewWorker.getHandler().obtainMessage(
                        WebViewWorker.MSG_ADD_STREAMLOADER,
                        new ContentLoader(loadListener.url(), loadListener))
                        .sendToTarget();
            }
            return true;
        } else if (URLUtil.isDataUrl(url)) {
            // load data in the current thread to reduce the latency
            new DataLoader(url, loadListener).load();
            return true;
        } else if (URLUtil.isAboutUrl(url)) {
            loadListener.data(mAboutBlank.getBytes(), mAboutBlank.length());
            loadListener.endData();
            return true;
        }
        return false;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.887 -0500", hash_original_field = "4336C241816DDA6167F38455E1A2AB46", hash_generated_field = "EB2ACDA5CCC677A93D03B81217EE2CA1")

    private static final int URI_PROTOCOL = 0x100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.890 -0500", hash_original_field = "8CC4B91D16E4C3BAC489D34D5D74C806", hash_generated_field = "E9E9985B4D9BEACB3E20B77FBDAC6013")

    private static final String CONTENT_TYPE = "content-type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.893 -0500", hash_original_field = "FA0EBEF2A159D7573F9A9C0E88256609", hash_generated_field = "36FEC7407939A642CEE5B978BA5EE272")

    private static final String mAboutBlank =
            "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EB\">" +
            "<html><head><title>about:blank</title></head><body></body></html>";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.895 -0500", hash_original_field = "7DF962FCBF88FDCD826B3B2B6F608E65", hash_generated_field = "0A81A03C8AD82EEC7F102EB79209347D")

    static final String HEADER_STR = "text/xml, text/html, " +
            "application/xhtml+xml, image/png, text/plain, */*;q=0.8";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.897 -0500", hash_original_field = "CF5103981B618784F76950E4558FDBCC", hash_generated_field = "061362C112C980EB4954480FBAFBE378")

    private static final String LOGTAG = "webkit";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.863 -0500", hash_original_field = "6F634748B2632997CFA3BD470A985F63", hash_generated_field = "D7FBD6A4D07A65117411BC8C01652773")

    private  LoadListener mListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.866 -0500", hash_original_field = "FB63EE61CA76D9C9913EC87AD6B942C6", hash_generated_field = "46D356CEC2B798E53528C0BD5F09C873")

    private  String mMethod;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.868 -0500", hash_original_field = "A5E24FAE08D22101EAD3684EE47BCBA3", hash_generated_field = "D4F7B9B886C1ADC785C82D3DD8AF3DFF")

    private  WebSettings mSettings;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.871 -0500", hash_original_field = "A7D525FA609C0F6270055E985F097B79", hash_generated_field = "A366B1C8ECA0EA3E5C2DAE5F1AFFA05D")

    private Map<String, String> mHeaders;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.873 -0500", hash_original_field = "2D2347367D31A512EEC0E8D215ED2DBD", hash_generated_field = "C5200C1F2575A09491B18B8CE6E6A375")

    private byte[] mPostData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.875 -0500", hash_original_field = "C72A50F72B23F13DD3F117A7D73CF25A", hash_generated_field = "E0FAA2A6C497494B58133B8740B95CC3")

    private Network mNetwork;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.877 -0500", hash_original_field = "F01A8831B95EC0E82D0909C20A93CC55", hash_generated_field = "8C07F09E694B2A8054749812D7A11348")

    private int mCacheMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.879 -0500", hash_original_field = "3A88C05BE1665FA9AE31BE79D7D88287", hash_generated_field = "D80C103FF159A690060174B576F408C0")

    private String mReferrer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.880 -0500", hash_original_field = "608DAE159C1CB591E99EAE76FAB7334E", hash_generated_field = "1F620CC4F21CDF80833E6AB697F4F4F7")

    private String mContentType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.883 -0500", hash_original_field = "01D1C2FCC57D945AED696F76D49D181E", hash_generated_field = "DC5ABF50AC0DEDF84B387D0BCB7F8F31")

    private  String mUaprofHeader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.885 -0500", hash_original_field = "3F1DC37EB8CF345B321349ACB9BE13E3", hash_generated_field = "1E5C1AADABD2F96959CCC93C619B3FFF")

    private  WebResourceResponse mInterceptResponse;
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.901 -0500", hash_original_method = "E604BA5F97EB5A21051EE698F8A56155", hash_generated_method = "E604BA5F97EB5A21051EE698F8A56155")
    
FrameLoader(LoadListener listener, WebSettings settings,
            String method, WebResourceResponse interceptResponse) {
        assert !JniUtil.useChromiumHttpStack();

        mListener = listener;
        mHeaders = null;
        mMethod = method;
        mCacheMode = WebSettings.LOAD_NORMAL;
        mSettings = settings;
        mInterceptResponse = interceptResponse;
        mUaprofHeader = mListener.getContext().getResources().getString(
                com.android.internal.R.string.config_useragentprofile_url, Build.MODEL);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.903 -0500", hash_original_method = "DAE08684530294543D6392896259C957", hash_generated_method = "09D80A1F9DDC4E1F4D3B6A849078AEAD")
    
public void setReferrer(String ref) {
        // only set referrer for http or https
        if (URLUtil.isNetworkUrl(ref)) mReferrer = ref;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.905 -0500", hash_original_method = "D2C8C4DED03F288D6E8AB32DB5451075", hash_generated_method = "DF8AE15CA0D7E8B5BFBD1E77DCEA2A85")
    
public void setPostData(byte[] postData) {
        mPostData = postData;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.907 -0500", hash_original_method = "E910F46151D172102331975C2568BBCE", hash_generated_method = "54BAB93111DAA1A43649AD0B815DF76B")
    
public void setContentTypeForPost(String postContentType) {
        mContentType = postContentType;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.909 -0500", hash_original_method = "4FD1C5F2E68FCD3B6425DADD4042F496", hash_generated_method = "49CDBD057E7164DCE326D7A2DE87FF77")
    
public void setCacheMode(int cacheMode) {
        mCacheMode = cacheMode;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.912 -0500", hash_original_method = "E0E34456BA61E1D94659FB0013B44B13", hash_generated_method = "04A12AB70FFD8B8D87C839701B3561B5")
    
public void setHeaders(HashMap headers) {
        mHeaders = headers;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.914 -0500", hash_original_method = "C430EEAE75F5C9BA4DF5580B50F4FE67", hash_generated_method = "1BFFB41D68420761D8117A8EC09AF1BA")
    
public LoadListener getLoadListener() {
        return mListener;
    }

    /**
     * Issues the load request.
     *
     * Return value does not indicate if the load was successful or not. It
     * simply indicates that the load request is reasonable.
     *
     * @return true if the load is reasonable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.917 -0500", hash_original_method = "C44DBC63D87836D797664A5A599046E9", hash_generated_method = "7149B29A53D042BA7D3F427E1203C70A")
    
public boolean executeLoad() {
        String url = mListener.url();

        // Process intercepted requests first as they could be any url.
        if (mInterceptResponse != null) {
            if (mListener.isSynchronous()) {
                mInterceptResponse.loader(mListener).load();
            } else {
                WebViewWorker.getHandler().obtainMessage(
                        WebViewWorker.MSG_ADD_STREAMLOADER,
                        mInterceptResponse.loader(mListener)).sendToTarget();
            }
            return true;
        } else if (URLUtil.isNetworkUrl(url)){
            if (mSettings.getBlockNetworkLoads()) {
                mListener.error(EventHandler.ERROR_BAD_URL,
                        mListener.getContext().getString(
                                com.android.internal.R.string.httpErrorBadUrl));
                return false;
            }
            // Make sure the host part of the url is correctly
            // encoded before sending the request
            if (!URLUtil.verifyURLEncoding(mListener.host())) {
                mListener.error(EventHandler.ERROR_BAD_URL,
                        mListener.getContext().getString(
                        com.android.internal.R.string.httpErrorBadUrl));
                return false;
            }
            mNetwork = Network.getInstance(mListener.getContext());
            if (mListener.isSynchronous()) {
                return handleHTTPLoad();
            }
            WebViewWorker.getHandler().obtainMessage(
                    WebViewWorker.MSG_ADD_HTTPLOADER, this).sendToTarget();
            return true;
        } else if (handleLocalFile(url, mListener, mSettings)) {
            return true;
        }
        if (DebugFlags.FRAME_LOADER) {
            Log.v(LOGTAG, "FrameLoader.executeLoad: url protocol not supported:"
                    + mListener.url());
        }
        mListener.error(EventHandler.ERROR_UNSUPPORTED_SCHEME,
                mListener.getContext().getText(
                        com.android.internal.R.string.httpErrorUnsupportedScheme).toString());
        return false;

    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.923 -0500", hash_original_method = "24B8F725DD0D2F171F529FAFE2897245", hash_generated_method = "1C30F7F32746647A05A19AC4A9C30F54")
    
boolean handleHTTPLoad() {
        if (mHeaders == null) {
            mHeaders = new HashMap<String, String>();
        }
        populateStaticHeaders();
        populateHeaders();

        // response was handled by Cache, don't issue HTTP request
        if (handleCache()) {
            // push the request data down to the LoadListener
            // as response from the cache could be a redirect
            // and we may need to initiate a network request if the cache
            // can't satisfy redirect URL
            mListener.setRequestData(mMethod, mHeaders, mPostData);
            return true;
        }

        if (DebugFlags.FRAME_LOADER) {
            Log.v(LOGTAG, "FrameLoader: http " + mMethod + " load for: "
                    + mListener.url());
        }

        boolean ret = false;
        int error = EventHandler.ERROR_UNSUPPORTED_SCHEME;
        
        try {
            ret = mNetwork.requestURL(mMethod, mHeaders,
                    mPostData, mListener);
        } catch (android.net.ParseException ex) {
            error = EventHandler.ERROR_BAD_URL;
        } catch (java.lang.RuntimeException ex) {
            /* probably an empty header set by javascript.  We want
               the same result as bad URL  */
            error = EventHandler.ERROR_BAD_URL;
        }
        if (!ret) {
            mListener.error(error, ErrorStrings.getString(error, mListener.getContext()));
            return false;
        }
        return true;
    }

    /*
     * This function is used by handleCache to
     * setup a load from the byte stream in a CacheResult.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.925 -0500", hash_original_method = "D628211A63EBF198D6007A9671F95672", hash_generated_method = "1089CAC15093A387E6F2BA5D7BC48F43")
    
private void startCacheLoad(CacheResult result) {
        if (DebugFlags.FRAME_LOADER) {
            Log.v(LOGTAG, "FrameLoader: loading from cache: "
                  + mListener.url());
        }
        // Tell the Listener respond with the cache file
        CacheLoader cacheLoader =
                new CacheLoader(mListener, result);
        mListener.setCacheLoader(cacheLoader);
        if (mListener.isSynchronous()) {
            cacheLoader.load();
        } else {
            // Load the cached file in a separate thread
            WebViewWorker.getHandler().obtainMessage(
                    WebViewWorker.MSG_ADD_STREAMLOADER, cacheLoader).sendToTarget();
        }
    }

    /*
     * This function is used by the handleHTTPLoad to setup the cache headers
     * correctly.
     * Returns true if the response was handled from the cache
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.929 -0500", hash_original_method = "ED6284595A2927F289F312ED71C4BF2D", hash_generated_method = "6E7D654569B43B2A03FAE01DE6FAA9B3")
    
private boolean handleCache() {
        switch (mCacheMode) {
            // This mode is normally used for a reload, it instructs the http
            // loader to not use the cached content.
            case WebSettings.LOAD_NO_CACHE:
                break;
                
            // This mode is used when the content should only be loaded from
            // the cache. If it is not there, then fail the load. This is used
            // to load POST content in a history navigation.
            case WebSettings.LOAD_CACHE_ONLY: {
                CacheResult result = CacheManager.getCacheFile(mListener.url(),
                        mListener.postIdentifier(), null);
                if (result != null) {
                    startCacheLoad(result);
                } else {
                    // This happens if WebCore was first told that the POST
                    // response was in the cache, then when we try to use it
                    // it has gone.
                    // Generate a file not found error
                    int err = EventHandler.FILE_NOT_FOUND_ERROR;
                    mListener.error(err,
                            ErrorStrings.getString(err, mListener.getContext()));
                }
                return true;
            }

            // This mode is for when the user is doing a history navigation
            // in the browser and should returned cached content regardless
            // of it's state. If it is not in the cache, then go to the 
            // network.
            case WebSettings.LOAD_CACHE_ELSE_NETWORK: {
                if (DebugFlags.FRAME_LOADER) {
                    Log.v(LOGTAG, "FrameLoader: checking cache: "
                            + mListener.url());
                }
                // Get the cache file name for the current URL, passing null for
                // the validation headers causes no validation to occur
                CacheResult result = CacheManager.getCacheFile(mListener.url(),
                        mListener.postIdentifier(), null);
                if (result != null) {
                    startCacheLoad(result);
                    return true;
                }
                break;
            }

            // This is the default case, which is to check to see if the
            // content in the cache can be used. If it can be used, then
            // use it. If it needs revalidation then the relevant headers
            // are added to the request.
            default:
            case WebSettings.LOAD_NORMAL:
                return mListener.checkCache(mHeaders);
        }// end of switch

        return false;
    }
    
    /**
     * Add the static headers that don't change with each request.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.931 -0500", hash_original_method = "2D0BB20A4C7261DEBC8826658FC12230", hash_generated_method = "C58F7F6A51A3BB84E758653BC0F7704F")
    
private void populateStaticHeaders() {
        // Accept header should already be there as they are built by WebCore,
        // but in the case they are missing, add some.
        String accept = mHeaders.get("Accept");
        if (accept == null || accept.length() == 0) {
            mHeaders.put("Accept", HEADER_STR);
        }
        mHeaders.put("Accept-Charset", "utf-8, iso-8859-1, utf-16, *;q=0.7");

        String acceptLanguage = mSettings.getAcceptLanguage();
        if (acceptLanguage.length() > 0) {
            mHeaders.put("Accept-Language", acceptLanguage);
        }
        
        mHeaders.put("User-Agent", mSettings.getUserAgentString());

        // Set the x-wap-profile header
        if (mUaprofHeader != null && mUaprofHeader.length() > 0) {
            mHeaders.put("x-wap-profile", mUaprofHeader);
        }
    }

    /**
     * Add the content related headers. These headers contain user private data
     * and is not used when we are proxying an untrusted request.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.934 -0500", hash_original_method = "FC5DAD276D63BF9B93BD19919189EAE8", hash_generated_method = "39104EE62728A8993DD70EB39437F698")
    
private void populateHeaders() {
        
        if (mReferrer != null) mHeaders.put("Referer", mReferrer);
        if (mContentType != null) mHeaders.put(CONTENT_TYPE, mContentType);

        // if we have an active proxy and have proxy credentials, do pre-emptive
        // authentication to avoid an extra round-trip:
        if (mNetwork.isValidProxySet()) {
            String username;
            String password;
            /* The proxy credentials can be set in the Network thread */
            synchronized (mNetwork) {
                username = mNetwork.getProxyUsername();
                password = mNetwork.getProxyPassword();
            }
            if (username != null && password != null) {
                // we collect credentials ONLY if the proxy scheme is BASIC!!!
                String proxyHeader = RequestHandle.authorizationHeader(true);
                mHeaders.put(proxyHeader,
                        "Basic " + RequestHandle.computeBasicAuthResponse(
                                username, password));
            }
        }

        // Set cookie header
        String cookie = CookieManager.getInstance().getCookie(
                mListener.getWebAddress());
        if (cookie != null && cookie.length() > 0) {
            mHeaders.put("Cookie", cookie);
        }
    }
}

