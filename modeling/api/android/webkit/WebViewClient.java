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
 * Copyright (C) 2008 The Android Open Source Project
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
import droidsafe.annotations.*;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;

public class WebViewClient {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.241 -0500", hash_original_field = "58067C0F689D3D13A2C5D55E20398B61", hash_generated_field = "AFF2A8FAA6EFD814083D0A1774C9B3B4")

    /** Generic error */
    public static final int ERROR_UNKNOWN = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.243 -0500", hash_original_field = "DE15D2873B1837F1E3D6DFAAD78E1879", hash_generated_field = "72239920351FC89D2ED57BDF97EBFA27")

    public static final int ERROR_HOST_LOOKUP = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.245 -0500", hash_original_field = "79245F0C793A98776A14F328BBCD7D79", hash_generated_field = "2CFCC24523B105163373EB236FD30AFF")

    public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.248 -0500", hash_original_field = "6B403171A3248200E4C42EA45F219CDA", hash_generated_field = "22F331898A9FC0AAD055DD27C6091C1F")

    public static final int ERROR_AUTHENTICATION = -4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.250 -0500", hash_original_field = "9F6142F744093494639F31E5E0E4A802", hash_generated_field = "42008B6C2004A121650BFE6D956C7E51")

    public static final int ERROR_PROXY_AUTHENTICATION = -5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.253 -0500", hash_original_field = "CB54D1BC409E18F191C144CC8C1659A6", hash_generated_field = "4A1B38F17D7BF96C7FEDDB20F79EBE0E")

    public static final int ERROR_CONNECT = -6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.256 -0500", hash_original_field = "50240939AEB6FFD0C26E18A2C762F866", hash_generated_field = "65780D7E0E775F00FF76AD01C9AC4497")

    public static final int ERROR_IO = -7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.258 -0500", hash_original_field = "5303E1F08E6DFA2868F54631196A6DB7", hash_generated_field = "7B06DE861E1953168CA194164D2C3176")

    public static final int ERROR_TIMEOUT = -8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.260 -0500", hash_original_field = "88E12AB21C6319BF7CCA902347AA8F4E", hash_generated_field = "9DC0E6B5D6D9C05608115C117DB82C7B")

    public static final int ERROR_REDIRECT_LOOP = -9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.262 -0500", hash_original_field = "4A0B061312CAA8B9A9AD6C135D6F53BA", hash_generated_field = "674701B720681268494C1D44A8AD2ECE")

    public static final int ERROR_UNSUPPORTED_SCHEME = -10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.265 -0500", hash_original_field = "4B2D9F431780CF5A9F8F857156B07789", hash_generated_field = "AB0D31876B9EF21E506ABB893C746DF4")

    public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.267 -0500", hash_original_field = "4BB84FBE23B584443664FAE72163AFAF", hash_generated_field = "1E1D729D38F527DC3DEA2A962F063F30")

    public static final int ERROR_BAD_URL = -12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.269 -0500", hash_original_field = "F7132EE08F28E0ACFA7920F5E9B4E441", hash_generated_field = "CCBDCDB5E74CEE9466B80982792E4DDE")

    public static final int ERROR_FILE = -13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.271 -0500", hash_original_field = "606BDBFBA5ECFE709988FA11865CF95C", hash_generated_field = "38983ACBF2E5A0C5628CCCB24B08A301")

    public static final int ERROR_FILE_NOT_FOUND = -14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.274 -0500", hash_original_field = "37862605CF7163DE694157F43886B2D1", hash_generated_field = "B4EED3D9F39A49A72568F053E1CC61F2")

    public static final int ERROR_TOO_MANY_REQUESTS = -15;
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:55.612 -0400", hash_original_method = "B78AAF28C2768A73FBC0F670C8F6188A", hash_generated_method = "B78AAF28C2768A73FBC0F670C8F6188A")
    public WebViewClient ()
    {
        //Synthesized constructor
    }

    /**
     * Give the host application a chance to take over the control when a new
     * url is about to be loaded in the current WebView. If WebViewClient is not
     * provided, by default WebView will ask Activity Manager to choose the
     * proper handler for the url. If WebViewClient is provided, return true
     * means the host application handles the url, while return false means the
     * current WebView handles the url.
     *
     * @param view The WebView that is initiating the callback.
     * @param url The url to be loaded.
     * @return True if the host application wants to leave the current WebView
     *         and handle the url itself, otherwise return false.
     */
    @DSComment("no security concern")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.228 -0500", hash_original_method = "B25B5EE312C01437108EEEF8D289ECD3", hash_generated_method = "C63E892A6BA4EC792C3677F2364FB69A")
    @DSVerified
public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return false;
    }

    /**
     * Notify the host application that a page has started loading. This method
     * is called once for each main frame load so a page with iframes or
     * framesets will call onPageStarted one time for the main frame. This also
     * means that onPageStarted will not be called when the contents of an
     * embedded frame changes, i.e. clicking a link whose target is an iframe.
     *
     * @param view The WebView that is initiating the callback.
     * @param url The url to be loaded.
     * @param favicon The favicon for this page if it already exists in the
     *            database.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.230 -0500", hash_original_method = "5314B6B2031A7AB7127460792C15BEA8", hash_generated_method = "2AA0E4E4C205535EE1A0DA0AD75AB630")
    
public void onPageStarted(WebView view, String url, Bitmap favicon) {
    }

    /**
     * Notify the host application that a page has finished loading. This method
     * is called only for main frame. When onPageFinished() is called, the
     * rendering picture may not be updated yet. To get the notification for the
     * new Picture, use {@link WebView.PictureListener#onNewPicture}.
     *
     * @param view The WebView that is initiating the callback.
     * @param url The url of the page.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.232 -0500", hash_original_method = "3C74EFC6CC5DEEE74470BD61275572DD", hash_generated_method = "4F00DD59B5B3BE95C41F7A52C4687657")
    
public void onPageFinished(WebView view, String url) {
    }

    /**
     * Notify the host application that the WebView will load the resource
     * specified by the given url.
     *
     * @param view The WebView that is initiating the callback.
     * @param url The url of the resource the WebView will load.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSVerified
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.234 -0500", hash_original_method = "854E1155516A65D2A0AC69045B4275C1", hash_generated_method = "131BF72B6B1D1DE1F995D238334481A4")
    
public void onLoadResource(WebView view, String url) {
    }

    /**
     * Notify the host application of a resource request and allow the
     * application to return the data.  If the return value is null, the WebView
     * will continue to load the resource as usual.  Otherwise, the return
     * response and data will be used.  NOTE: This method is called by the
     * network thread so clients should exercise caution when accessing private
     * data.
     *
     * @param view The {@link android.webkit.WebView} that is requesting the
     *             resource.
     * @param url The raw url of the resource.
     * @return A {@link android.webkit.WebResourceResponse} containing the
     *         response information or null if the WebView should load the
     *         resource itself.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.236 -0500", hash_original_method = "B5801BDD799BA7062410BD396AAB4B71", hash_generated_method = "EEA7EB5F4B366192F4A7B398038D92DF")
    
public WebResourceResponse shouldInterceptRequest(WebView view,
            String url) {
        return null;
    }

    /**
     * Notify the host application that there have been an excessive number of
     * HTTP redirects. As the host application if it would like to continue
     * trying to load the resource. The default behavior is to send the cancel
     * message.
     *
     * @param view The WebView that is initiating the callback.
     * @param cancelMsg The message to send if the host wants to cancel
     * @param continueMsg The message to send if the host wants to continue
     * @deprecated This method is no longer called. When the WebView encounters
     *             a redirect loop, it will cancel the load.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.239 -0500", hash_original_method = "79CA4CDBF662362D6AFDE76E65301125", hash_generated_method = "0E064EBAC524F2DDC3D586E1517D4F20")
    
@Deprecated
    public void onTooManyRedirects(WebView view, Message cancelMsg,
            Message continueMsg) {
        cancelMsg.sendToTarget();
    }

    /**
     * Report an error to the host application. These errors are unrecoverable
     * (i.e. the main resource is unavailable). The errorCode parameter
     * corresponds to one of the ERROR_* constants.
     * @param view The WebView that is initiating the callback.
     * @param errorCode The error code corresponding to an ERROR_* value.
     * @param description A String describing the error.
     * @param failingUrl The url that failed to load.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.276 -0500", hash_original_method = "12ABA78EBE10E417F0C1B2A97120946D", hash_generated_method = "75FC56698A2AEE9B834045C27A0DF3DE")
    
public void onReceivedError(WebView view, int errorCode,
            String description, String failingUrl) {
    }

    /**
     * As the host application if the browser should resend data as the
     * requested page was a result of a POST. The default is to not resend the
     * data.
     *
     * @param view The WebView that is initiating the callback.
     * @param dontResend The message to send if the browser should not resend
     * @param resend The message to send if the browser should resend data
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.278 -0500", hash_original_method = "F404DEEFBF7AA691DD4FBAFA7C65E80C", hash_generated_method = "5C022222B5B6AA1F11824DDE7B1E59F6")
    
public void onFormResubmission(WebView view, Message dontResend,
            Message resend) {
        dontResend.sendToTarget();
    }

    /**
     * Notify the host application to update its visited links database.
     *
     * @param view The WebView that is initiating the callback.
     * @param url The url being visited.
     * @param isReload True if this url is being reloaded.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.280 -0500", hash_original_method = "17353DC9A8A29F2A1F6857B45DCA3F35", hash_generated_method = "A0B5CDDAE904CD93941B6BE702AD818C")
    
public void doUpdateVisitedHistory(WebView view, String url,
            boolean isReload) {
    }

    /**
     * Notify the host application that an SSL error occurred while loading a
     * resource. The host application must call either handler.cancel() or
     * handler.proceed(). Note that the decision may be retained for use in
     * response to future SSL errors. The default behavior is to cancel the
     * load.
     *
     * @param view The WebView that is initiating the callback.
     * @param handler An SslErrorHandler object that will handle the user's
     *            response.
     * @param error The SSL error object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.282 -0500", hash_original_method = "292FE6324BA8FDA19777928FD16DC874", hash_generated_method = "3F3BDBC2BEF8856EB2F4C11C1936C0CB")
    
public void onReceivedSslError(WebView view, SslErrorHandler handler,
            SslError error) {
        handler.cancel();
    }

    /**
     * Notify the host application that an SSL error occurred while loading a
     * resource, but the WebView but chose to proceed anyway based on a
     * decision retained from a previous response to onReceivedSslError().
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.284 -0500", hash_original_method = "B2EE2F5677BCC95DB5D614A683A4C62D", hash_generated_method = "9A1B96AA867156E1AB7A89966D62E473")
    
public void onProceededAfterSslError(WebView view, SslError error) {
    }

    /**
     * Notify the host application to handle a SSL client certificate
     * request (display the request to the user and ask whether to
     * proceed with a client certificate or not). The host application
     * has to call either handler.cancel() or handler.proceed() as the
     * connection is suspended and waiting for the response. The
     * default behavior is to cancel, returning no client certificate.
     *
     * @param view The WebView that is initiating the callback.
     * @param handler An ClientCertRequestHandler object that will
     *            handle the user's response.
     * @param host_and_port The host and port of the requesting server.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.287 -0500", hash_original_method = "C5A42222BD6D7B11B03E8E8DC75486E5", hash_generated_method = "5784B78D0998794D552EC7C822640647")
    
public void onReceivedClientCertRequest(WebView view,
            ClientCertRequestHandler handler, String host_and_port) {
        handler.cancel();
    }

    /**
     * Notify the host application to handle an authentication request. The
     * default behavior is to cancel the request.
     *
     * @param view The WebView that is initiating the callback.
     * @param handler The HttpAuthHandler that will handle the user's response.
     * @param host The host requiring authentication.
     * @param realm A description to help store user credentials for future
     *            visits.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.289 -0500", hash_original_method = "99DC3611344E7F5F6B557A987ADB25FE", hash_generated_method = "8561BB81A1CC84CFC1E6D202A95DD914")
    
public void onReceivedHttpAuthRequest(WebView view,
            HttpAuthHandler handler, String host, String realm) {
        handler.cancel();
    }

    /**
     * Give the host application a chance to handle the key event synchronously.
     * e.g. menu shortcut key events need to be filtered this way. If return
     * true, WebView will not handle the key event. If return false, WebView
     * will always handle the key event, so none of the super in the view chain
     * will see the key event. The default behavior returns false.
     *
     * @param view The WebView that is initiating the callback.
     * @param event The key event.
     * @return True if the host application wants to handle the key event
     *         itself, otherwise return false
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.291 -0500", hash_original_method = "1014277FB075F3AB2B83403F67794F88", hash_generated_method = "5D76AFF5D2F6192231E91D760493C620")
    
public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
        return false;
    }

    /**
     * Notify the host application that a key was not handled by the WebView.
     * Except system keys, WebView always consumes the keys in the normal flow
     * or if shouldOverrideKeyEvent returns true. This is called asynchronously
     * from where the key is dispatched. It gives the host application an chance
     * to handle the unhandled key events.
     *
     * @param view The WebView that is initiating the callback.
     * @param event The key event.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.293 -0500", hash_original_method = "0A322E8BE1639A0DBED358F3919BFB99", hash_generated_method = "4FA970995E386E899113863905242C0C")
    
public void onUnhandledKeyEvent(WebView view, KeyEvent event) {
    }

    /**
     * Notify the host application that the scale applied to the WebView has
     * changed.
     *
     * @param view he WebView that is initiating the callback.
     * @param oldScale The old scale factor
     * @param newScale The new scale factor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.296 -0500", hash_original_method = "E786223707BD58A877E8AD07E09750F2", hash_generated_method = "65A678B85D05DA1494C62416913CD072")
    
public void onScaleChanged(WebView view, float oldScale, float newScale) {
    }

    /**
     * Notify the host application that a request to automatically log in the
     * user has been processed.
     * @param view The WebView requesting the login.
     * @param realm The account realm used to look up accounts.
     * @param account An optional account. If not null, the account should be
     *                checked against accounts on the device. If it is a valid
     *                account, it should be used to log in the user.
     * @param args Authenticator specific arguments used to log in the user.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.298 -0500", hash_original_method = "61AD7355C99E5A8A7ACA8AE385985070", hash_generated_method = "459DDE1CE49277A1F7FB97704F993D16")
    
public void onReceivedLoginRequest(WebView view, String realm,
            String account, String args) {
    }
}

