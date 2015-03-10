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
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Set;

import android.net.ProxyProperties;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;

final class JWebCoreJavaBridge extends Handler {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.943 -0500", hash_original_method = "812C5D46D70F6EBD90414C46F818D47C", hash_generated_method = "AD2630B7C1B2B5474F846CC08C2CDBDC")
    
static synchronized void setActiveWebView(WebView webview) {
        if (sCurrentMainWebView.get() != null) {
            // it is possible if there is a sub-WebView. Do nothing.
            return;
        }
        sCurrentMainWebView = new WeakReference<WebView>(webview);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.946 -0500", hash_original_method = "BB0EBD6CFC072395955DF2C341991941", hash_generated_method = "41D5EC1C0579B34BAD1020ED0DE627DB")
    
static synchronized void removeActiveWebView(WebView webview) {
        if (sCurrentMainWebView.get() != webview) {
            // it is possible if there is a sub-WebView. Do nothing.
            return;
        }
        sCurrentMainWebView.clear();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.917 -0500", hash_original_field = "C0C0F784BFEA367DF89F7620636DC623", hash_generated_field = "9DF6119D97ECEA39D23976C04D9D93AA")

    private static final int TIMER_MESSAGE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.919 -0500", hash_original_field = "82A31CF640BE49FE06C8FAD782E31EEB", hash_generated_field = "D296A0461F81AE27D7536C23AFDC4097")

    private static final int FUNCPTR_MESSAGE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.921 -0500", hash_original_field = "A2D27548C61105D97E25F647A974D748", hash_generated_field = "C340BEA9652E0C495B0427C6F473E96D")

    private static final String LOGTAG = "webkit-timers";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.932 -0500", hash_original_field = "1747D798A254CB7F85861648CD9ADEF7", hash_generated_field = "E96C53461FA8FC86112444E60E77F2C1")

    // can get the proper Context.
    private static WeakReference<WebView> sCurrentMainWebView =
            new WeakReference<WebView>(null);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.934 -0500", hash_original_field = "9A01583D42F9203D75056768926EE18A", hash_generated_field = "F5D453B28C787626695D682CFDA8F348")

    static final int REFRESH_PLUGINS = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.923 -0500", hash_original_field = "DE2986C9DE1EA66FE06454D02B45E44B", hash_generated_field = "2974AA9EDEE26975BC6F1AFB9A7C8BD7")

    private int mNativeBridge;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.925 -0500", hash_original_field = "5195DBA3A56B2CF26681822CA3D5E4E9", hash_generated_field = "F9A22048A0372696618F712DC254B280")

    // immediately.
    private boolean mHasInstantTimer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.927 -0500", hash_original_field = "8CD5C91DD61A5EB3812EB68BF5811C3E", hash_generated_field = "4C6E6459810428DDB9069F262AE62676")

    private boolean mTimerPaused;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.929 -0500", hash_original_field = "F54618ED5FC2F0D5E760B5024EC79C3A", hash_generated_field = "64B51006061AD1592250F72E98B31DCF")

    private boolean mHasDeferredTimers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.936 -0500", hash_original_field = "EDDEFF2BA5F576754455CE012E3A9AFB", hash_generated_field = "54D1A4080AE3D1D4D0316390BB67ECCC")

    private HashMap<String, String> mContentUriToFilePathMap;

    /**
     * Construct a new JWebCoreJavaBridge to interface with
     * WebCore timers and cookies.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.939 -0500", hash_original_method = "24BC54E57520E50B51FEB9301490242D", hash_generated_method = "FAE9CEF2DB2F0021A995BEA229699877")
    
public JWebCoreJavaBridge() {
        nativeConstructor();

    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.941 -0500", hash_original_method = "5F428C944882A33820E180A8794913DA", hash_generated_method = "824E91469A1A44167DD4A4345F885232")
    
@Override
    protected void finalize() {
        nativeFinalize();
    }

    /**
     * Call native timer callbacks.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.948 -0500", hash_original_method = "02E069F093A33F917985EC0A146AF5DF", hash_generated_method = "0A0A0938FE87EB252E42E40EFC5D116F")
    
private void fireSharedTimer() { 
        // clear the flag so that sharedTimerFired() can set a new timer
        mHasInstantTimer = false;
        sharedTimerFired();
    }

    /**
     * handleMessage
     * @param msg The dispatched message.
     *
     * The only accepted message currently is TIMER_MESSAGE
     */
    @DSSafe(DSCat.IPC_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.951 -0500", hash_original_method = "192555E6E84DEFC9610ACF82B6235778", hash_generated_method = "A02BC465AF7FA4FA10FEE1CD67C31C11")
    
@Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case TIMER_MESSAGE: {
                if (mTimerPaused) {
                    mHasDeferredTimers = true;
                } else {
                    fireSharedTimer();
                }
                break;
            }
            case FUNCPTR_MESSAGE:
                nativeServiceFuncPtrQueue();
                break;
            case REFRESH_PLUGINS:
                nativeUpdatePluginDirectories(PluginManager.getInstance(null)
                        .getPluginDirectories(), ((Boolean) msg.obj)
                        .booleanValue());
                break;
        }
    }
    
    // called from JNI side
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.953 -0500", hash_original_method = "AB9D63477B4D64307AC8C3CAD493B037", hash_generated_method = "161BFB927796FC12A75F92D5D059932B")
    
private void signalServiceFuncPtrQueue() {
        Message msg = obtainMessage(FUNCPTR_MESSAGE);
        sendMessage(msg);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.957 -0500", hash_original_method = "7F0F2EACA52373092F02E1C8C47DF6D2", hash_generated_method = "BEE2E67E4A1D99AC382D153D5D939FCB")
    
    private void nativeServiceFuncPtrQueue(){
    	//Formerly a native method
    }

    /**
     * Pause all timers.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.959 -0500", hash_original_method = "DCDD00DDB3DA5C0826A1E2E2E5E3FA67", hash_generated_method = "308B89FD1FC1D75CE1456429332393A4")
    
public void pause() {
        if (!mTimerPaused) {
            mTimerPaused = true;
            mHasDeferredTimers = false;
        }
    }

    /**
     * Resume all timers.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.962 -0500", hash_original_method = "E4EBA320047EAFB61B42881338F91526", hash_generated_method = "703918BE9255F3B053FF566C577960E6")
    
public void resume() {
        if (mTimerPaused) {
           mTimerPaused = false;
           if (mHasDeferredTimers) {
               mHasDeferredTimers = false;
               fireSharedTimer();
           }
        }
    }

    /**
     * Set WebCore cache size.
     * @param bytes The cache size in bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.965 -0500", hash_original_method = "B06B3FDC2D2CDF223C79F9432CF6B221", hash_generated_method = "EC13B61AE91A640A596BB8C3880035C6")
    
    public void setCacheSize(int bytes){
    	//Formerly a native method
    	addTaint(bytes);
    }

    /**
     * Store a cookie string associated with a url.
     * @param url The url to be used as a key for the cookie.
     * @param value The cookie string to be stored.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.967 -0500", hash_original_method = "D5A9FC7DDB356B7F9D175C82B50A2AF1", hash_generated_method = "24C7574FF957618A543446AAAEE4BC4D")
    
private void setCookies(String url, String value) {
        if (value.contains("\r") || value.contains("\n")) {
            // for security reason, filter out '\r' and '\n' from the cookie
            int size = value.length();
            StringBuilder buffer = new StringBuilder(size);
            int i = 0;
            while (i != -1 && i < size) {
                int ir = value.indexOf('\r', i);
                int in = value.indexOf('\n', i);
                int newi = (ir == -1) ? in : (in == -1 ? ir : (ir < in ? ir
                        : in));
                if (newi > i) {
                    buffer.append(value.subSequence(i, newi));
                } else if (newi == -1) {
                    buffer.append(value.subSequence(i, size));
                    break;
                }
                i = newi + 1;
            }
            value = buffer.toString();
        }
        CookieManager.getInstance().setCookie(url, value);
    }

    /**
     * Retrieve the cookie string for the given url.
     * @param url The resource's url.
     * @return A String representing the cookies for the given resource url.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.970 -0500", hash_original_method = "E3D7D6931554145E868760CB2C4A26A3", hash_generated_method = "EE86FFF77F12F6E87C0C4F0204A00383")
    
private String cookies(String url) {
        return CookieManager.getInstance().getCookie(url);
    }

    /**
     * Returns whether cookies are enabled or not.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.972 -0500", hash_original_method = "E9376C130584FE2146C1CFB7A84FB471", hash_generated_method = "FA6BBF0A4D9665939C38DB115FB61EFF")
    
private boolean cookiesEnabled() {
        return CookieManager.getInstance().acceptCookie();
    }

    /**
     * Returns an array of plugin directoies
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.973 -0500", hash_original_method = "9CEFD28F2377E55BFA773DC40D227755", hash_generated_method = "73D87799411059F553F14ACEF6F84D19")
    
private String[] getPluginDirectories() {
        return PluginManager.getInstance(null).getPluginDirectories();
    }

    /**
     * Returns the path of the plugin data directory
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.976 -0500", hash_original_method = "EA355C7E0B9693F5192FD4CEC8057AD3", hash_generated_method = "9E6689181E864F22C591AF0EE83A1997")
    
private String getPluginSharedDataDirectory() {
        return PluginManager.getInstance(null).getPluginSharedDataDirectory();
    }

    /**
     * setSharedTimer
     * @param timemillis The relative time when the timer should fire
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.979 -0500", hash_original_method = "8308F15706BD844BBD432043C004CF45", hash_generated_method = "DFFBE103EB8340C01E1F4FA32BE49C4E")
    
private void setSharedTimer(long timemillis) {
        if (DebugFlags.J_WEB_CORE_JAVA_BRIDGE) Log.v(LOGTAG, "setSharedTimer " + timemillis);

        if (timemillis <= 0) {
            // we don't accumulate the sharedTimer unless it is a delayed
            // request. This way we won't flood the message queue with
            // WebKit messages. This should improve the browser's
            // responsiveness to key events.
            if (mHasInstantTimer) {
                return;
            } else {
                mHasInstantTimer = true;
                Message msg = obtainMessage(TIMER_MESSAGE);
                sendMessageDelayed(msg, timemillis);
            }
        } else {
            Message msg = obtainMessage(TIMER_MESSAGE);
            sendMessageDelayed(msg, timemillis);
        }
    }

    /**
     * Stop the shared timer.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.981 -0500", hash_original_method = "962436894D889C4038B1520A1ECBED33", hash_generated_method = "66F7DBB494564B9F17917A6AA602DF50")
    
private void stopSharedTimer() {
        if (DebugFlags.J_WEB_CORE_JAVA_BRIDGE) {
            Log.v(LOGTAG, "stopSharedTimer removing all timers");
        }
        removeMessages(TIMER_MESSAGE);
        mHasInstantTimer = false;
        mHasDeferredTimers = false;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.983 -0500", hash_original_method = "017AD119A16DE91023E8FE76067DD440", hash_generated_method = "53FF7207D2372C3B91C46E1EF3C573FA")
    
private String[] getKeyStrengthList() {
        return CertTool.getKeyStrengthList();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.986 -0500", hash_original_method = "A59843A23C4CF1F3FD140F676EC35D8E", hash_generated_method = "20C50B3A68FF077FC0E66FC1B4666469")
    
synchronized private String getSignedPublicKey(int index, String challenge,
            String url) {
        WebView current = sCurrentMainWebView.get();
        if (current != null) {
            // generateKeyPair expects organizations which we don't have. Ignore
            // url.
            return CertTool.getSignedPublicKey(
                    current.getContext(), index, challenge);
        } else {
            Log.e(LOGTAG, "There is no active WebView for getSignedPublicKey");
            return "";
        }
    }

    // Called on the WebCore thread through JNI.
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.988 -0500", hash_original_method = "7BAB6C5DC5E9A5F66D14195839893242", hash_generated_method = "6AC7082476212C63B892889CC1EEA5D0")
    
private String resolveFilePathForContentUri(String uri) {
        if (mContentUriToFilePathMap != null) {
            String fileName = mContentUriToFilePathMap.get(uri);
            if (fileName != null) {
                return fileName;
            }
        }

        // Failsafe fallback to just use the last path segment.
        // (See OpenableColumns documentation in the SDK)
        Uri jUri = Uri.parse(uri);
        return jUri.getLastPathSegment();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.991 -0500", hash_original_method = "3D9A94F616B3884F20C1C47ABAEE0053", hash_generated_method = "E38A4BFA23D0EE978D7C9BC5E427A642")
    
public void storeFilePathForContentUri(String path, String contentUri) {
        if (mContentUriToFilePathMap == null) {
            mContentUriToFilePathMap = new HashMap<String, String>();
        }
        mContentUriToFilePathMap.put(contentUri, path);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.993 -0500", hash_original_method = "48D122DFD280F464E6FED9A0593B265C", hash_generated_method = "1F55A7228744D88A6FB4CB83B68F129F")
    
public void updateProxy(ProxyProperties proxyProperties) {
        if (proxyProperties == null) {
            nativeUpdateProxy("", "");
            return;
        }

        String host = proxyProperties.getHost();
        int port = proxyProperties.getPort();
        if (port != 0)
            host += ":" + port;

        nativeUpdateProxy(host, proxyProperties.getExclusionList());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.996 -0500", hash_original_method = "CB9D9CAF93B6F7C6AC078700B30D5B3A", hash_generated_method = "6EEF3712392D06942F0E7086316BBAB4")
    
    private void nativeConstructor(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.000 -0500", hash_original_method = "46D026C452E34CB5D17D4D7413C83210", hash_generated_method = "78C5016E7109D19F8AD63CF42C68ACE4")
    
    private void nativeFinalize(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.004 -0500", hash_original_method = "509DDA1BD92D7B897CEF90224EAD9875", hash_generated_method = "4223596673A5B3FD038248B23650A4A5")
    
    private void sharedTimerFired(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.008 -0500", hash_original_method = "9316866F322C157E5A357156C0328836", hash_generated_method = "0AAD4E6525FDA7AD6805FD8FD3E4C4A7")
    
    private void nativeUpdatePluginDirectories(String[] directories,
                boolean reload){
    	//Formerly a native method
    	addTaint(directories[0].getTaint());
    	addTaint(reload);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.012 -0500", hash_original_method = "DB39049AAE02496ACE7C7C1E193B0ADF", hash_generated_method = "40C00F325A8EB9E169C604B505C6A30B")
    
    public void setNetworkOnLine(boolean online){
    	//Formerly a native method
    	addTaint(online);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.016 -0500", hash_original_method = "E4793A664EF98A715ED3BAC198AF4EBD", hash_generated_method = "B72ADD4A151BC578FAD8448CF7ED8D16")
    
    public void setNetworkType(String type, String subtype){
    	//Formerly a native method
    	addTaint(type.getTaint());
    	addTaint(subtype.getTaint());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.019 -0500", hash_original_method = "E5A69925BDA73DD9E81D8A1F8F42F257", hash_generated_method = "BC29193EBB18DD714A911DC3105CD009")
    
    public void addPackageNames(Set<String> packageNames){
    	//Formerly a native method
    	addTaint(packageNames.getTaint());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.023 -0500", hash_original_method = "B071A6644C9AA816555B15D21EE52FB4", hash_generated_method = "D65569BC7D40591501907DE0DFE452CE")
    
    public void addPackageName(String packageName){
    	//Formerly a native method
    	addTaint(packageName.getTaint());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.027 -0500", hash_original_method = "143D937A228206F27207E7C61286CEC1", hash_generated_method = "99B4559BE7E71E3CAB365A2313295F80")
    
    public void removePackageName(String packageName){
    	//Formerly a native method
    	addTaint(packageName.getTaint());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.030 -0500", hash_original_method = "562AC1C8CCB348A368D1FD0970777261", hash_generated_method = "677624E440233C527D1598ABFEC9FBEC")
    
    public void nativeUpdateProxy(String newProxy, String exclusionList){
    	//Formerly a native method
    	addTaint(newProxy.getTaint());
    	addTaint(exclusionList.getTaint());
    }

}

