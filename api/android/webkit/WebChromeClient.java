package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;

public class WebChromeClient {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.356 -0400", hash_original_method = "99482C8BD0C5E621D29A3393913944E6", hash_generated_method = "99482C8BD0C5E621D29A3393913944E6")
    public WebChromeClient ()
    {
        //Synthesized constructor
    }

    /**
     * Tell the host application the current progress of loading a page.
     * @param view The WebView that initiated the callback.
     * @param newProgress Current page loading progress, represented by
     *                    an integer between 0 and 100.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.800 -0500", hash_original_method = "0356D3C5779031E83EBAA5536F22FD2C", hash_generated_method = "F09CF8F720B5C6D2391332AF1DC461DC")
    
public void onProgressChanged(WebView view, int newProgress) {}

    /**
     * Notify the host application of a change in the document title.
     * @param view The WebView that initiated the callback.
     * @param title A String containing the new title of the document.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.802 -0500", hash_original_method = "EF8501574F8D969A2FEBAA77F34054B1", hash_generated_method = "253CC99CAD3667E9CF9B4110EFFEBAEE")
    
public void onReceivedTitle(WebView view, String title) {}

    /**
     * Notify the host application of a new favicon for the current page.
     * @param view The WebView that initiated the callback.
     * @param icon A Bitmap containing the favicon for the current page.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.804 -0500", hash_original_method = "29596704FB7D5BB460F59F26BE233C70", hash_generated_method = "463A6E62876CE8CAAD42E04C8A17E972")
    
public void onReceivedIcon(WebView view, Bitmap icon) {}

    /**
     * Notify the host application of the url for an apple-touch-icon.
     * @param view The WebView that initiated the callback.
     * @param url The icon url.
     * @param precomposed True if the url is for a precomposed touch icon.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.806 -0500", hash_original_method = "A4C5B5257D00BF3A62B0EECD068EB4AE", hash_generated_method = "F9C9650D9FDBC0152D222BB81E92226D")
    
public void onReceivedTouchIconUrl(WebView view, String url,
            boolean precomposed) {}

    /**
     * Notify the host application that the current page would
     * like to show a custom View.
     * @param view is the View object to be shown.
     * @param callback is the callback to be invoked if and when the view
     * is dismissed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.810 -0500", hash_original_method = "77F78B4AA1FEBCA4548885095C178085", hash_generated_method = "61CE41DD4C726758B1889714A730D32B")
    
public void onShowCustomView(View view, CustomViewCallback callback) {}

    /**
     * Notify the host application that the current page would
     * like to show a custom View in a particular orientation.
     * @param view is the View object to be shown.
     * @param requestedOrientation An orientation constant as used in
     * {@link ActivityInfo#screenOrientation ActivityInfo.screenOrientation}.
     * @param callback is the callback to be invoked if and when the view
     * is dismissed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.813 -0500", hash_original_method = "42AC916863A44836B06C58A8705D2934", hash_generated_method = "D20DBD63E20D98CCB1530E007DCC6F50")
    
public void onShowCustomView(View view, int requestedOrientation,
            CustomViewCallback callback) {}
    
    /**
     * Notify the host application that the current page would
     * like to hide its custom view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.815 -0500", hash_original_method = "3C82DC078459A71064D67069FEC24583", hash_generated_method = "33ABEF40DB53BF4FE9CE9893C5C6D534")
    
public void onHideCustomView() {}

    /**
     * Request the host application to create a new window. If the host
     * application chooses to honor this request, it should return true from
     * this method, create a new WebView to host the window, insert it into the
     * View system and send the supplied resultMsg message to its target with
     * the new WebView as an argument. If the host application chooses not to
     * honor the request, it should return false from this method. The default
     * implementation of this method does nothing and hence returns false.
     * @param view The WebView from which the request for a new window
     *             originated.
     * @param isDialog True if the new window should be a dialog, rather than
     *                 a full-size window.
     * @param isUserGesture True if the request was initiated by a user gesture,
     *                      such as the user clicking a link.
     * @param resultMsg The message to send when once a new WebView has been
     *                  created. resultMsg.obj is a
     *                  {@link WebView.WebViewTransport} object. This should be
     *                  used to transport the new WebView, by calling
     *                  {@link WebView.WebViewTransport#setWebView(WebView)
     *                  WebView.WebViewTransport.setWebView(WebView)}.
     * @return This method should return true if the host application will
     *         create a new window, in which case resultMsg should be sent to
     *         its target. Otherwise, this method should return false. Returning
     *         false from this method but also sending resultMsg will result in
     *         undefined behavior.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.818 -0500", hash_original_method = "0F7608F947A0ECBD179808AAF0AFEB9B", hash_generated_method = "A81D6C615CBA76B288222AED880EAAE5")
    
public boolean onCreateWindow(WebView view, boolean isDialog,
            boolean isUserGesture, Message resultMsg) {
        return false;
    }

    /**
     * Request display and focus for this WebView. This may happen due to
     * another WebView opening a link in this WebView and requesting that this
     * WebView be displayed.
     * @param view The WebView that needs to be focused.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.820 -0500", hash_original_method = "9D3C2A06B7A580B802B062ACCF072DA0", hash_generated_method = "42667F2871C13EB578F688498F592237")
    
public void onRequestFocus(WebView view) {}

    /**
     * Notify the host application to close the given WebView and remove it
     * from the view system if necessary. At this point, WebCore has stopped
     * any loading in this window and has removed any cross-scripting ability
     * in javascript.
     * @param window The WebView that needs to be closed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.822 -0500", hash_original_method = "20C36406AC14D1B2BB4595DEF25401D6", hash_generated_method = "E57BEA599A95FAEE9649D62A68769698")
    
public void onCloseWindow(WebView window) {}

    /**
     * Tell the client to display a javascript alert dialog.  If the client
     * returns true, WebView will assume that the client will handle the
     * dialog.  If the client returns false, it will continue execution.
     * @param view The WebView that initiated the callback.
     * @param url The url of the page requesting the dialog.
     * @param message Message to be displayed in the window.
     * @param result A JsResult to confirm that the user hit enter.
     * @return boolean Whether the client will handle the alert dialog.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.824 -0500", hash_original_method = "B665260C93890B7DFFFEE826876C181C", hash_generated_method = "826D2BD1A94E35260E9B910D8DDA837B")
    
public boolean onJsAlert(WebView view, String url, String message,
            JsResult result) {
        return false;
    }

    /**
     * Tell the client to display a confirm dialog to the user. If the client
     * returns true, WebView will assume that the client will handle the
     * confirm dialog and call the appropriate JsResult method. If the
     * client returns false, a default value of false will be returned to
     * javascript. The default behavior is to return false.
     * @param view The WebView that initiated the callback.
     * @param url The url of the page requesting the dialog.
     * @param message Message to be displayed in the window.
     * @param result A JsResult used to send the user's response to
     *               javascript.
     * @return boolean Whether the client will handle the confirm dialog.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.826 -0500", hash_original_method = "96B1179CA869CC7F0C650459C80E91A1", hash_generated_method = "11D2278236205A06CB2240D52CBEA8FF")
    
public boolean onJsConfirm(WebView view, String url, String message,
            JsResult result) {
        return false;
    }

    /**
     * Tell the client to display a prompt dialog to the user. If the client
     * returns true, WebView will assume that the client will handle the
     * prompt dialog and call the appropriate JsPromptResult method. If the
     * client returns false, a default value of false will be returned to to
     * javascript. The default behavior is to return false.
     * @param view The WebView that initiated the callback.
     * @param url The url of the page requesting the dialog.
     * @param message Message to be displayed in the window.
     * @param defaultValue The default value displayed in the prompt dialog.
     * @param result A JsPromptResult used to send the user's reponse to
     *               javascript.
     * @return boolean Whether the client will handle the prompt dialog.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.828 -0500", hash_original_method = "B0F8165C36C1E06488928BD9B36CF34F", hash_generated_method = "95BF2AF331C13B0A9B81AEB063331D96")
    
public boolean onJsPrompt(WebView view, String url, String message,
            String defaultValue, JsPromptResult result) {
        return false;
    }

    /**
     * Tell the client to display a dialog to confirm navigation away from the
     * current page. This is the result of the onbeforeunload javascript event.
     * If the client returns true, WebView will assume that the client will
     * handle the confirm dialog and call the appropriate JsResult method. If
     * the client returns false, a default value of true will be returned to
     * javascript to accept navigation away from the current page. The default
     * behavior is to return false. Setting the JsResult to true will navigate
     * away from the current page, false will cancel the navigation.
     * @param view The WebView that initiated the callback.
     * @param url The url of the page requesting the dialog.
     * @param message Message to be displayed in the window.
     * @param result A JsResult used to send the user's response to
     *               javascript.
     * @return boolean Whether the client will handle the confirm dialog.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.831 -0500", hash_original_method = "9A70F346469CE5ADB362459FFD66F0CC", hash_generated_method = "EC9FE14DDF092F72789D5D4C1F5F2940")
    
public boolean onJsBeforeUnload(WebView view, String url, String message,
            JsResult result) {
        return false;
    }

   /**
    * Tell the client that the database quota for the origin has been exceeded.
    * @param url The URL that triggered the notification
    * @param databaseIdentifier The identifier of the database that caused the
    *     quota overflow.
    * @param currentQuota The current quota for the origin.
    * @param estimatedSize The estimated size of the database.
    * @param totalUsedQuota is the sum of all origins' quota.
    * @param quotaUpdater A callback to inform the WebCore thread that a new
    *     quota is available. This callback must always be executed at some
    *     point to ensure that the sleeping WebCore thread is woken up.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.833 -0500", hash_original_method = "E698A9F452C6783F3C6DB7E7A071CA1D", hash_generated_method = "58611049F5E2E7358DBECA32CF854676")
    
public void onExceededDatabaseQuota(String url, String databaseIdentifier,
        long currentQuota, long estimatedSize, long totalUsedQuota,
        WebStorage.QuotaUpdater quotaUpdater) {
        // This default implementation passes the current quota back to WebCore.
        // WebCore will interpret this that new quota was declined.
        quotaUpdater.updateQuota(currentQuota);
    }

   /**
    * Tell the client that the Application Cache has exceeded its max size.
    * @param spaceNeeded is the amount of disk space that would be needed
    * in order for the last appcache operation to succeed.
    * @param totalUsedQuota is the sum of all origins' quota.
    * @param quotaUpdater A callback to inform the WebCore thread that a new
    * app cache size is available. This callback must always be executed at
    * some point to ensure that the sleeping WebCore thread is woken up.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.835 -0500", hash_original_method = "EC4B1817B796D6243C1BADFF5A19DD19", hash_generated_method = "10A4AB035751E3FF3BCDD295F76115A5")
    
public void onReachedMaxAppCacheSize(long spaceNeeded, long totalUsedQuota,
            WebStorage.QuotaUpdater quotaUpdater) {
        quotaUpdater.updateQuota(0);
    }

    /**
     * Instructs the client to show a prompt to ask the user to set the
     * Geolocation permission state for the specified origin.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.837 -0500", hash_original_method = "98993092A89284EC0BBF79A8D8B73F2B", hash_generated_method = "CEA9FD44D03DA3ED879B3D0FD49F2933")
    
public void onGeolocationPermissionsShowPrompt(String origin,
            GeolocationPermissions.Callback callback) {}

    /**
     * Instructs the client to hide the Geolocation permissions prompt.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.839 -0500", hash_original_method = "C2C3AAB43EA40B6144BCEFE67B905422", hash_generated_method = "224992FD7C53F117A90A55C6DC481ED1")
    
public void onGeolocationPermissionsHidePrompt() {}

    /**
     * Tell the client that a JavaScript execution timeout has occured. And the
     * client may decide whether or not to interrupt the execution. If the
     * client returns true, the JavaScript will be interrupted. If the client
     * returns false, the execution will continue. Note that in the case of
     * continuing execution, the timeout counter will be reset, and the callback
     * will continue to occur if the script does not finish at the next check
     * point.
     * @return boolean Whether the JavaScript execution should be interrupted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.841 -0500", hash_original_method = "D3576F706DC2F920D86267B1909BCF87", hash_generated_method = "485FE48F316E8CB871E7B2629200D66A")
    
public boolean onJsTimeout() {
        return true;
    }

    /**
     * Report a JavaScript error message to the host application. The ChromeClient
     * should override this to process the log message as they see fit.
     * @param message The error message to report.
     * @param lineNumber The line number of the error.
     * @param sourceID The name of the source file that caused the error.
     * @deprecated Use {@link #onConsoleMessage(ConsoleMessage) onConsoleMessage(ConsoleMessage)}
     *      instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.844 -0500", hash_original_method = "79CD152A32E05A12E47F3ADA435EA3CF", hash_generated_method = "9DAB520727D50962DA40DC8ED2E74DC5")
    
@Deprecated
    public void onConsoleMessage(String message, int lineNumber, String sourceID) { }

    /**
     * Report a JavaScript console message to the host application. The ChromeClient
     * should override this to process the log message as they see fit.
     * @param consoleMessage Object containing details of the console message.
     * @return true if the message is handled by the client.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.846 -0500", hash_original_method = "CFDCDEC28BDAF7613A605474C11A52D7", hash_generated_method = "5DB993C5A074F511FB12DDDEDA4E9887")
    
public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        // Call the old version of this function for backwards compatability.
        onConsoleMessage(consoleMessage.message(), consoleMessage.lineNumber(),
                consoleMessage.sourceId());
        return false;
    }

    /**
     * When not playing, video elements are represented by a 'poster' image. The
     * image to use can be specified by the poster attribute of the video tag in
     * HTML. If the attribute is absent, then a default poster will be used. This
     * method allows the ChromeClient to provide that default image.
     *
     * @return Bitmap The image to use as a default poster, or null if no such image is
     * available.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.848 -0500", hash_original_method = "B12C654EAF6D1EF1BD2CB65AEE47A82B", hash_generated_method = "70527A5E20D719C3A209832D5B5500F1")
    
public Bitmap getDefaultVideoPoster() {
        return null;
    }

    /**
     * When the user starts to playback a video element, it may take time for enough
     * data to be buffered before the first frames can be rendered. While this buffering
     * is taking place, the ChromeClient can use this function to provide a View to be
     * displayed. For example, the ChromeClient could show a spinner animation.
     *
     * @return View The View to be displayed whilst the video is loading.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.850 -0500", hash_original_method = "72F535BEAD962B4F42D879A83B63BF5A", hash_generated_method = "BB4FDE2E472D0D28BB1092AD2DBC70AA")
    
public View getVideoLoadingProgressView() {
        return null;
    }

    /** Obtains a list of all visited history items, used for link coloring
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.852 -0500", hash_original_method = "15B2ED72F970B566935619473880B5EF", hash_generated_method = "F94A1DEF2C06E3AB0E076A88208C00E4")
    
public void getVisitedHistory(ValueCallback<String[]> callback) {
    }

    /**
     * Tell the client to open a file chooser.
     * @param uploadFile A ValueCallback to set the URI of the file to upload.
     *      onReceiveValue must be called to wake up the thread.a
     * @param acceptType The value of the 'accept' attribute of the input tag
     *         associated with this file picker.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.854 -0500", hash_original_method = "DA085B71ADFBAF37C9145F2BAEC7CA78", hash_generated_method = "4F320BAB6CADA1B82FF3F3CA0E6B9B42")
    
public void openFileChooser(ValueCallback<Uri> uploadFile, String acceptType) {
        uploadFile.onReceiveValue(null);
    }

    /**
     * Tell the client that the page being viewed is web app capable,
     * i.e. has specified the fullscreen-web-app-capable meta tag.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.856 -0500", hash_original_method = "BB19EC4B0210D5A42E9ED0382D14771D", hash_generated_method = "91C01A3277D8FEE6B17AB6375485A9CA")
    
public void setInstallableWebApp() { }

    /**
     * Tell the client that the page being viewed has an autofillable
     * form and the user would like to set a profile up.
     * @param msg A Message to send once the user has successfully
     *      set up a profile and to inform the WebTextView it should
     *      now autofill using that new profile.
     * @hide
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:57.858 -0500", hash_original_method = "681C2C146739845C582C6BB934543E3C", hash_generated_method = "8030A326DDD2D807CCC2A93B47490A89")
    
public void setupAutoFill(Message msg) { }
    
    public interface CustomViewCallback {
        
        public void onCustomViewHidden();
    }
    
}

