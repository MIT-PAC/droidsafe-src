package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;

import org.apache.harmony.security.provider.cert.X509CertImpl;

import android.app.ActivityManager;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.net.ParseException;
import android.net.Uri;
import android.net.WebAddress;
import android.net.http.ErrorStrings;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.view.Surface;
import android.view.ViewRootImpl;
import android.view.WindowManager;

class BrowserFrame extends Handler {
    /* package */ @DSSource({DSSourceKind.BROWSER_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.218 -0500", hash_original_method = "50372AB6BB6BBC5DF6CA1B50375B707C", hash_generated_method = "5692FCEFB6C8D382EA8E9E6F92A30F1B")
    
static String getRawResFilename(int id, Context context) {
        int resid;
        switch (id) {
            case NODOMAIN:
                resid = com.android.internal.R.raw.nodomain;
                break;

            case LOADERROR:
                resid = com.android.internal.R.raw.loaderror;
                break;

            case DRAWABLEDIR:
                // use one known resource to find the drawable directory
                resid = com.android.internal.R.drawable.btn_check_off;
                break;

            case FILE_UPLOAD_LABEL:
                return context.getResources().getString(
                        com.android.internal.R.string.upload_file);

            case RESET_LABEL:
                return context.getResources().getString(
                        com.android.internal.R.string.reset);

            case SUBMIT_LABEL:
                return context.getResources().getString(
                        com.android.internal.R.string.submit);

            case FILE_UPLOAD_NO_FILE_CHOSEN:
                return context.getResources().getString(
                        com.android.internal.R.string.no_file_chosen);

            default:
                Log.e(LOGTAG, "getRawResFilename got incompatible resource ID");
                return "";
        }
        TypedValue value = new TypedValue();
        context.getResources().getValue(resid, value, true);
        if (id == DRAWABLEDIR) {
            String path = value.string.toString();
            int index = path.lastIndexOf('/');
            if (index < 0) {
                Log.e(LOGTAG, "Can't find drawable directory.");
                return "";
            }
            return path.substring(0, index + 1);
        }
        return value.string.toString();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.984 -0500", hash_original_field = "CF5103981B618784F76950E4558FDBCC", hash_generated_field = "061362C112C980EB4954480FBAFBE378")

    private static final String LOGTAG = "webkit";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.986 -0500", hash_original_field = "9C4E0AF5855BCD67106C8565B25B662F", hash_generated_field = "07C45052F371F817A6E9C7129020689B")

    private final static int MAX_OUTSTANDING_REQUESTS = 300;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.024 -0500", hash_original_field = "1834DF972BBF32A50AD8A39FDCD48AB0", hash_generated_field = "02D6F5DD6038D682A7547420780B79FF")

    // a message posted when a frame loading is completed
    static final int FRAME_COMPLETED = 1001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.026 -0500", hash_original_field = "CEE43A26D3EB221F97758DB17DCF36D3", hash_generated_field = "AF9351C3CDB755F3B9F929001804B228")

    static final int ORIENTATION_CHANGED = 1002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.028 -0500", hash_original_field = "3063E218BC107052A72DF1E8BBEA7F39", hash_generated_field = "C36A7AE2DF93855D8C17DDD00680C01F")

    static final int POLICY_FUNCTION = 1003;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.030 -0500", hash_original_field = "221D954C4D10466A3543A9F54194000A", hash_generated_field = "DFF5E87C0D76673051368D90F72B1604")

    static final int FRAME_LOADTYPE_STANDARD = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.032 -0500", hash_original_field = "93E27A91950B4FFFAD26756DA7DA0C70", hash_generated_field = "C98CAC212FCE0950CF5C591CBA26F6CC")

    static final int FRAME_LOADTYPE_BACK = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.035 -0500", hash_original_field = "03A22A0CD5C1CE0523D53E21A3C694CC", hash_generated_field = "D7F18C05A3ED8C1A9A5E43B62A743FF7")

    static final int FRAME_LOADTYPE_FORWARD = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.038 -0500", hash_original_field = "5C024D056A365FC6822BBA0F3015B1AB", hash_generated_field = "A6DC1C43F9AA0B9E9057D9DF6E190A28")

    static final int FRAME_LOADTYPE_INDEXEDBACKFORWARD = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.040 -0500", hash_original_field = "129232BEDA3D986331F3187B0F61AB60", hash_generated_field = "648167BCE91CB300141EF0AFB6CD386E")

    static final int FRAME_LOADTYPE_RELOAD = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.042 -0500", hash_original_field = "C0F508E65AC10BAAE26A4F2C3950437B", hash_generated_field = "562F9B01E203DDE63B327BFF2B1CD946")

    static final int FRAME_LOADTYPE_RELOADALLOWINGSTALEDATA = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.044 -0500", hash_original_field = "427A7F420DB6650B4943B26FC23E01BC", hash_generated_field = "85E2877EDE72029BC342156260E07F32")

    static final int FRAME_LOADTYPE_SAME = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.047 -0500", hash_original_field = "6A847E4F1C7EDD559341CB4DEF3F9487", hash_generated_field = "7323181853C306D4388E0BF9D6453477")

    static final int FRAME_LOADTYPE_REDIRECT = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.049 -0500", hash_original_field = "843C4E082D3ABD666983A05EBE0FDDD1", hash_generated_field = "F07767150327DF86E3F5EFA1195635EC")

    static final int FRAME_LOADTYPE_REPLACE = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.051 -0500", hash_original_field = "B1496B807C42BC346B93E728B33C5E17", hash_generated_field = "4F198CADE81901781EF8AE5AB17DB41B")

    private static final int TRANSITION_SWITCH_THRESHOLD = 75;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.055 -0500", hash_original_field = "0609E6600AE3C6733FEC58952E4B3A26", hash_generated_field = "B586117A7538A7315A78374C827C5C42")

    // requests from WebCore.
    static JWebCoreJavaBridge sJavaBridge;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.076 -0500", hash_original_field = "7CBAA8755FE9366ECDE341B65D537ACD", hash_generated_field = "83DD52CDBA28345681C620B41796288C")

    static ConfigCallback sConfigCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.185 -0500", hash_original_field = "B423A79E5A48890CA1A0B9B43115C23E", hash_generated_field = "13740A75EDBFEE6C8A5C3D763C02E3C3")

    static final int POLICY_USE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.187 -0500", hash_original_field = "AF4E1EE948CD505DC5B7C5B9E60DE5D5", hash_generated_field = "2FABA77BC47A5226C38B743147FB61D6")

    static final int POLICY_IGNORE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.199 -0500", hash_original_field = "CFA7E91CDE231B72C0A804998A45671D", hash_generated_field = "3B0BA434BBAF6F143B1004BB592C5D7E")

    private static final int NODOMAIN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.202 -0500", hash_original_field = "F75380B5607FE2CE5A70D39D735C69AE", hash_generated_field = "AD9F10F130C2DBFC8F084342E0C12F0A")

    private static final int LOADERROR = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.204 -0500", hash_original_field = "8B91649D15B6A5C19F37F336B3FDD94E", hash_generated_field = "F4AD924B573A3AD2500D585C18423161")
 static final int DRAWABLEDIR = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.206 -0500", hash_original_field = "1C548642801DCA1B41274762DFE1B9A1", hash_generated_field = "309D0176BF26B7AC77784E88B4D15E58")

    private static final int FILE_UPLOAD_LABEL = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.208 -0500", hash_original_field = "CEB98E5E2429257D0EA2091E2B4FD7DD", hash_generated_field = "FD5A9527260C0D4BB974D71092CE0CA5")

    private static final int RESET_LABEL = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.210 -0500", hash_original_field = "F7013FE8C06BD4F5002DE718129D184A", hash_generated_field = "C4DC7FB1DE12FCB7898E3269E9F8A2BA")

    private static final int SUBMIT_LABEL = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.212 -0500", hash_original_field = "289FB4B164287C5CBD7CFCD6A7F821C1", hash_generated_field = "AD5F5EC77DEB8EB516DC019450BAA732")

    private static final int FILE_UPLOAD_NO_FILE_CHOSEN = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.988 -0500", hash_original_field = "C50B804397335F4C59F495D6A5AAA565", hash_generated_field = "62789CA10670C708EA4D387AB18C5F89")

    private  CallbackProxy mCallbackProxy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.991 -0500", hash_original_field = "A5E24FAE08D22101EAD3684EE47BCBA3", hash_generated_field = "D4F7B9B886C1ADC785C82D3DD8AF3DFF")

    private  WebSettings mSettings;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.993 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.995 -0500", hash_original_field = "2DFBDBD4347FE4E3543384465B3B797C", hash_generated_field = "7BDDBEC30F299EE26388591EE1BF8D76")

    private  WebViewDatabase mDatabase;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.998 -0500", hash_original_field = "799AB033E7CD1CC92AF93A69917908BF", hash_generated_field = "73DACDCC92B5BF8822959B0368CF2255")

    private  WebViewCore mWebViewCore;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.000 -0500", hash_original_field = "B4EA0C57C793BB0B49B6968B7FE9D971", hash_generated_field = "B4EA0C57C793BB0B49B6968B7FE9D971")
 boolean mLoadInitFromJava;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.002 -0500", hash_original_field = "87CC24F4EC735FE6AB645E6E64EC2B5D", hash_generated_field = "C86D106D01922BD5804E6AAE242DA6C3")

    private int mLoadType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.004 -0500", hash_original_field = "20D9DE622D0CBA38536F6A5BF781168E", hash_generated_field = "776616C56C2E01B1F2BB9B8C0B82CB21")

    private boolean mFirstLayoutDone = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.007 -0500", hash_original_field = "11A80AF07398D2E652D8BFC05E496F38", hash_generated_field = "EC7856A93088DA99A6DF3A617D2EA4C1")

    private boolean mCommitted = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.009 -0500", hash_original_field = "0CF02FF7FC18CE0B5556C558E59AA4B6", hash_generated_field = "7724221E14FD0BA1352EDE70E79E14F2")

    // that if the UI thread posts any messages after the message
    // queue has been cleared,they are ignored.
    private boolean mBlockMessages = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.011 -0500", hash_original_field = "2A4E2073F345342BDEB4C8B99467716E", hash_generated_field = "9A84F3DDA9738602717ED248C7C54BA0")

    private int mOrientation = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.013 -0500", hash_original_field = "2F4CA4AC5F3D84FD5633862B86611565", hash_generated_field = "288919EE03CF52ADC4ECF3BE90DB3FD0")

    private boolean mIsMainFrame;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.015 -0500", hash_original_field = "5ECB756EC35F41A951FB1B7D95B29065", hash_generated_field = "6BE2AF2AB55A96D7E8AF44D0319FADE3")

    private Map<String, Object> mJavaScriptObjects;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.017 -0500", hash_original_field = "D655A62E046B3D460223AD2C4958E766", hash_generated_field = "0CD8E441AD75D857B58751166EA1B830")

    private Set<Object> mRemovedJavaScriptObjects;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.020 -0500", hash_original_field = "5BD58AE141EE3C8F21839D7093DE0884", hash_generated_field = "6F2547FBE326896235C67C4D21E1AAB0")

    private KeyStoreHandler mKeyStoreHandler = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.022 -0500", hash_original_field = "1A89328CF50ECC70712CC92CFB803E23", hash_generated_field = "4A5DF3233C257C28C1B6F01FDD889A88")

    private  SearchBoxImpl mSearchBox;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.053 -0500", hash_original_field = "74015A65A56B852D13D3A8DC44ECA23B", hash_generated_field = "E90F451144927A2BC2A5E2B03C4E0655")

    /*package*/ int mNativeFrame;

    /**
     * Create a new BrowserFrame to be used in an application.
     * @param context An application context to use when retrieving assets.
     * @param w A WebViewCore used as the view for this frame.
     * @param proxy A CallbackProxy for posting messages to the UI thread and
     *              querying a client for information.
     * @param settings A WebSettings object that holds all settings.
     * XXX: Called by WebCore thread.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.079 -0500", hash_original_method = "0C0B9FED7DBC124A25298101B6DEE56A", hash_generated_method = "C1C8DA392CEC67EC532791FA766D3B44")
    
public BrowserFrame(Context context, WebViewCore w, CallbackProxy proxy,
            WebSettings settings, Map<String, Object> javascriptInterfaces) {

        Context appContext = context.getApplicationContext();

        // Create a global JWebCoreJavaBridge to handle timers and
        // cookies in the WebCore thread.
        if (sJavaBridge == null) {
            sJavaBridge = new JWebCoreJavaBridge();
            // set WebCore native cache size
            ActivityManager am = (ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            if (am.getMemoryClass() > 16) {
                sJavaBridge.setCacheSize(8 * 1024 * 1024);
            } else {
                sJavaBridge.setCacheSize(4 * 1024 * 1024);
            }
            // initialize CacheManager
            CacheManager.init(appContext);
            // create CookieSyncManager with current Context
            CookieSyncManager.createInstance(appContext);
            // create PluginManager with current Context
            PluginManager.getInstance(appContext);
        }

        if (sConfigCallback == null) {
            sConfigCallback = new ConfigCallback(
                    (WindowManager) appContext.getSystemService(
                            Context.WINDOW_SERVICE));
            ViewRootImpl.addConfigCallback(sConfigCallback);
        }
        sConfigCallback.addHandler(this);

        mJavaScriptObjects = javascriptInterfaces;
        if (mJavaScriptObjects == null) {
            mJavaScriptObjects = new HashMap<String, Object>();
        }
        mRemovedJavaScriptObjects = new HashSet<Object>();

        mSettings = settings;
        mContext = context;
        mCallbackProxy = proxy;
        mDatabase = WebViewDatabase.getInstance(appContext);
        mWebViewCore = w;

        mSearchBox = new SearchBoxImpl(mWebViewCore, mCallbackProxy);
        mJavaScriptObjects.put(SearchBoxImpl.JS_INTERFACE_NAME, mSearchBox);

        AssetManager am = context.getAssets();
        nativeCreateFrame(w, am, proxy.getBackForwardList());

        if (DebugFlags.BROWSER_FRAME) {
            Log.v(LOGTAG, "BrowserFrame constructor: this=" + this);
        }
    }

    /**
     * Load a url from the network or the filesystem into the main frame.
     * Following the same behaviour as Safari, javascript: URLs are not passed
     * to the main frame, instead they are evaluated immediately.
     * @param url The url to load.
     * @param extraHeaders The extra headers sent with this url. This should not
     *            include the common headers like "user-agent". If it does, it
     *            will be replaced by the intrinsic value of the WebView.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.082 -0500", hash_original_method = "056144D27ACF2932EFB0C1980B0D6F98", hash_generated_method = "74273AD6A7D138355EF1ACE14D1C1CB7")
    
public void loadUrl(String url, Map<String, String> extraHeaders) {
        mLoadInitFromJava = true;
        if (URLUtil.isJavaScriptUrl(url)) {
            // strip off the scheme and evaluate the string
            stringByEvaluatingJavaScriptFromString(
                    url.substring("javascript:".length()));
        } else {
            nativeLoadUrl(url, extraHeaders);
        }
        mLoadInitFromJava = false;
    }

    /**
     * Load a url with "POST" method from the network into the main frame.
     * @param url The url to load.
     * @param data The data for POST request.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.084 -0500", hash_original_method = "55F163F814F53ECA11AC218202D49EB2", hash_generated_method = "B6DAA9FC39B574ED3B96CB9CCFCDE9BA")
    
public void postUrl(String url, byte[] data) {
        mLoadInitFromJava = true;
        nativePostUrl(url, data);
        mLoadInitFromJava = false;
    }

    /**
     * Load the content as if it was loaded by the provided base URL. The
     * historyUrl is used as the history entry for the load data.
     * 
     * @param baseUrl Base URL used to resolve relative paths in the content
     * @param data Content to render in the browser
     * @param mimeType Mimetype of the data being passed in
     * @param encoding Character set encoding of the provided data.
     * @param historyUrl URL to use as the history entry.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.087 -0500", hash_original_method = "210E874B3CC8A8754EDB8A64197F3EDD", hash_generated_method = "87CA7DD5A7AE4AA411592B813E76CF34")
    
public void loadData(String baseUrl, String data, String mimeType,
            String encoding, String historyUrl) {
        mLoadInitFromJava = true;
        if (historyUrl == null || historyUrl.length() == 0) {
            historyUrl = "about:blank";
        }
        if (data == null) {
            data = "";
        }
        
        // Setup defaults for missing values. These defaults where taken from
        // WebKit's WebFrame.mm
        if (baseUrl == null || baseUrl.length() == 0) {
            baseUrl = "about:blank";
        }
        if (mimeType == null || mimeType.length() == 0) {
            mimeType = "text/html";
        }
        nativeLoadData(baseUrl, data, mimeType, encoding, historyUrl);
        mLoadInitFromJava = false;
    }

    /**
     * Saves the contents of the frame as a web archive.
     *
     * @param basename The filename where the archive should be placed.
     * @param autoname If false, takes filename to be a file. If true, filename
     *                 is assumed to be a directory in which a filename will be
     *                 chosen according to the url of the current page.
     */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.089 -0500", hash_original_method = "FE36B1316A593126EBA1AA2EF5942205", hash_generated_method = "FE36B1316A593126EBA1AA2EF5942205")
    
String saveWebArchive(String basename, boolean autoname) {
        return nativeSaveWebArchive(basename, autoname);
    }

    /**
     * Go back or forward the number of steps given.
     * @param steps A negative or positive number indicating the direction
     *              and number of steps to move.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.091 -0500", hash_original_method = "4DB46F10EA63A90C886405E235BD3A38", hash_generated_method = "2B3A74E2B01B4E6563CA5D1C66179B8D")
    
public void goBackOrForward(int steps) {
        mLoadInitFromJava = true;
        nativeGoBackOrForward(steps);
        mLoadInitFromJava = false;
    }

    /**
     * native callback
     * Report an error to an activity.
     * @param errorCode The HTTP error code.
     * @param description Optional human-readable description. If no description
     *     is given, we'll use a standard localized error message.
     * @param failingUrl The URL that was being loaded when the error occurred.
     * TODO: Report all errors including resource errors but include some kind
     * of domain identifier. Change errorCode to an enum for a cleaner
     * interface.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.093 -0500", hash_original_method = "50E452D86A3E55153B3E0F1DD816D615", hash_generated_method = "BB2A008545B8C231B09A8BC474F79D7F")
    
private void reportError(int errorCode, String description, String failingUrl) {
        // As this is called for the main resource and loading will be stopped
        // after, reset the state variables.
        resetLoadingStates();
        if (description == null || description.isEmpty()) {
            description = ErrorStrings.getString(errorCode, mContext);
        }
        mCallbackProxy.onReceivedError(errorCode, description, failingUrl);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.095 -0500", hash_original_method = "7B4A87199DD3BC0CC52E5F0CAA9F0064", hash_generated_method = "55DED5FCA323019CEF4F10E6E2FDF089")
    
private void resetLoadingStates() {
        mCommitted = true;
        mFirstLayoutDone = true;
    }

    /* package */@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.097 -0500", hash_original_method = "82C14ED51175F3BAD05958BE30AA9B50", hash_generated_method = "82C14ED51175F3BAD05958BE30AA9B50")
    
boolean committed() {
        return mCommitted;
    }

    /* package */@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.099 -0500", hash_original_method = "6055F5425C1866007AB953B33770A39A", hash_generated_method = "6055F5425C1866007AB953B33770A39A")
    
boolean firstLayoutDone() {
        return mFirstLayoutDone;
    }

    /* package */@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.101 -0500", hash_original_method = "9068063B02257F9D08EFF05D6BD051A9", hash_generated_method = "9068063B02257F9D08EFF05D6BD051A9")
    
int loadType() {
        return mLoadType;
    }

    /* package */@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.104 -0500", hash_original_method = "027FDD69E025CF7A20175D3E84246197", hash_generated_method = "D232C6F4EFCBFDA96EAFEFDD8C61BE56")
    
void didFirstLayout() {
        if (!mFirstLayoutDone) {
            mFirstLayoutDone = true;
            // ensure {@link WebViewCore#webkitDraw} is called as we were
            // blocking the update in {@link #loadStarted}
            mWebViewCore.contentDraw();
        }
    }

    /**
     * native callback
     * Indicates the beginning of a new load.
     * This method will be called once for the main frame.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.107 -0500", hash_original_method = "588CB65AC18071EB5B02ABC642CC0A1A", hash_generated_method = "C7BFA5CBEA1F09A3E6248BC6D75CCF70")
    
private void loadStarted(String url, Bitmap favicon, int loadType,
            boolean isMainFrame) {
        mIsMainFrame = isMainFrame;

        if (isMainFrame || loadType == FRAME_LOADTYPE_STANDARD) {
            mLoadType = loadType;

            if (isMainFrame) {
                // Call onPageStarted for main frames.
                mCallbackProxy.onPageStarted(url, favicon);
                // as didFirstLayout() is only called for the main frame, reset 
                // mFirstLayoutDone only for the main frames
                mFirstLayoutDone = false;
                mCommitted = false;
                // remove pending draw to block update until mFirstLayoutDone is
                // set to true in didFirstLayout()
                mWebViewCore.removeMessages(WebViewCore.EventHub.WEBKIT_DRAW);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.109 -0500", hash_original_method = "C9CC31AE97DBC19619CDCFC15EC7B03E", hash_generated_method = "87797B2F5B98E0DB51CD960603C59877")
    
@SuppressWarnings("unused")
    private void saveFormData(HashMap<String, String> data) {
        if (mSettings.getSaveFormData()) {
            final WebHistoryItem h = mCallbackProxy.getBackForwardList()
                    .getCurrentItem();
            if (h != null) {
                String url = WebTextView.urlForAutoCompleteData(h.getUrl());
                if (url != null) {
                    mDatabase.setFormData(url, data);
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.112 -0500", hash_original_method = "F4B9AF2B8B6C0B9D0EBAE01BEE4BF775", hash_generated_method = "EE42455E932A3BE74600001C166B3F03")
    
@SuppressWarnings("unused")
    private boolean shouldSaveFormData() {
        if (mSettings.getSaveFormData()) {
            final WebHistoryItem h = mCallbackProxy.getBackForwardList()
                    .getCurrentItem();
            return h != null && h.getUrl() != null;
        }
        return false;
    }

    /**
     * native callback
     * Indicates the WebKit has committed to the new load
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.114 -0500", hash_original_method = "7094DD5A86271DA7E952B216F4C46CCD", hash_generated_method = "39D9BB8A59FFD02C0A407B280CB1B697")
    
private void transitionToCommitted(int loadType, boolean isMainFrame) {
        // loadType is not used yet
        if (isMainFrame) {
            mCommitted = true;
            mWebViewCore.getWebView().mViewManager.postResetStateAll();
        }
    }

    /**
     * native callback
     * <p>
     * Indicates the end of a new load.
     * This method will be called once for the main frame.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.116 -0500", hash_original_method = "5C2FD3A5795EB59386117F9A61E0ADCE", hash_generated_method = "B01B6B091CA06151A1DE19D0694FE513")
    
private void loadFinished(String url, int loadType, boolean isMainFrame) {
        // mIsMainFrame and isMainFrame are better be equal!!!

        if (isMainFrame || loadType == FRAME_LOADTYPE_STANDARD) {
            if (isMainFrame) {
                resetLoadingStates();
                mCallbackProxy.switchOutDrawHistory();
                mCallbackProxy.onPageFinished(url);
            }
        }
    }

    /**
     * We have received an SSL certificate for the main top-level page.
     * Used by the Android HTTP stack only.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.118 -0500", hash_original_method = "D2CB1A360A21716BE59AD0C99E7F7543", hash_generated_method = "660ED0C5C1BBCBE5B2E23EA2648192A0")
    
void certificate(SslCertificate certificate) {
        if (mIsMainFrame) {
            // we want to make this call even if the certificate is null
            // (ie, the site is not secure)
            mCallbackProxy.onReceivedCertificate(certificate);
        }
    }

    /**
     * Destroy all native components of the BrowserFrame.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.120 -0500", hash_original_method = "FF0F600C92E1745B1B3B7823F85C9072", hash_generated_method = "C252620A39C6C1ABAC6E409569BE3C7D")
    
public void destroy() {
        nativeDestroyFrame();
        mBlockMessages = true;
        removeCallbacksAndMessages(null);
    }

    /**
     * Handle messages posted to us.
     * @param msg The message to handle.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.123 -0500", hash_original_method = "08B10BC0FD4D849356EF434C4A57C456", hash_generated_method = "6BD96B9529562207CAD6CD6B1C457CE8")
    
@Override
    public void handleMessage(Message msg) {
        if (mBlockMessages) {
            return;
        }
        switch (msg.what) {
            case FRAME_COMPLETED: {
                if (mSettings.getSavePassword() && hasPasswordField()) {
                    WebHistoryItem item = mCallbackProxy.getBackForwardList()
                            .getCurrentItem();
                    if (item != null) {
                        WebAddress uri = new WebAddress(item.getUrl());
                        String schemePlusHost = uri.getScheme() + uri.getHost();
                        String[] up =
                                mDatabase.getUsernamePassword(schemePlusHost);
                        if (up != null && up[0] != null) {
                            setUsernamePassword(up[0], up[1]);
                        }
                    }
                }
                if (!JniUtil.useChromiumHttpStack()) {
                    WebViewWorker.getHandler().sendEmptyMessage(
                            WebViewWorker.MSG_TRIM_CACHE);
                }
                break;
            }

            case POLICY_FUNCTION: {
                nativeCallPolicyFunction(msg.arg1, msg.arg2);
                break;
            }

            case ORIENTATION_CHANGED: {
                if (mOrientation != msg.arg1) {
                    mOrientation = msg.arg1;
                    nativeOrientationChanged(msg.arg1);
                }
                break;
            }

            default:
                break;
        }
    }

    /**
     * Punch-through for WebCore to set the document
     * title. Inform the Activity of the new title.
     * @param title The new title of the document.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.126 -0500", hash_original_method = "71CD366348BF98805D3BCFC6E13F61B1", hash_generated_method = "FA6ED58B03E74DAF236DFA142A7079E4")
    
private void setTitle(String title) {
        // FIXME: The activity must call getTitle (a native method) to get the
        // title. We should try and cache the title if we can also keep it in
        // sync with the document.
        mCallbackProxy.onReceivedTitle(title);
    }

    /**
     * Retrieves the render tree of this frame and puts it as the object for
     * the message and sends the message.
     * @param callback the message to use to send the render tree
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.128 -0500", hash_original_method = "DC38D0601A6CA8B3CA54AD6CF11C8ED7", hash_generated_method = "BEC13A2D99D338AEA54338061AF770B0")
    
public void externalRepresentation(Message callback) {
        callback.obj = externalRepresentation();;
        callback.sendToTarget();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.717 -0400", hash_original_method = "818D4287AF55B155FD9BEC63FC9BB14D", hash_generated_method = "2CE36722D89C9AAE233D32794227C266")
    private String externalRepresentation() {
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }

    /**
     * Retrieves the visual text of the frames, puts it as the object for
     * the message and sends the message.
     * @param callback the message to use to send the visual text
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.134 -0500", hash_original_method = "769B7E21D870172A915EE6F0EB6B2D2C", hash_generated_method = "E132C299AAE3D6417B8A2956E9FD212B")
    
public void documentAsText(Message callback) {
        StringBuilder text = new StringBuilder();
        if (callback.arg1 != 0) {
            // Dump top frame as text.
            text.append(documentAsText());
        }
        if (callback.arg2 != 0) {
            // Dump child frames as text.
            text.append(childFramesAsText());
        }
        callback.obj = text.toString();
        callback.sendToTarget();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.718 -0400", hash_original_method = "79942AAFA346C254C5198053B4C683D6", hash_generated_method = "07D5EDE5120089FA81790CBAAE4B851E")
    private String documentAsText() {
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.718 -0400", hash_original_method = "BAA59F57B83FBAF7CC9F5BD462BDF4D7", hash_generated_method = "81DE64B9D9AB653AFA9FD34037C2102D")
    private String childFramesAsText() {
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }

    /*
     * This method is called by WebCore to inform the frame that
     * the Javascript window object has been cleared.
     * We should re-attach any attached js interfaces.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.144 -0500", hash_original_method = "7D1B04AB7A647E05019AB7BC865C3803", hash_generated_method = "566A734F03AD8E5AB593B413B639A044")
    
private void windowObjectCleared(int nativeFramePointer) {
        Iterator<String> iter = mJavaScriptObjects.keySet().iterator();
        while (iter.hasNext())  {
            String interfaceName = iter.next();
            Object object = mJavaScriptObjects.get(interfaceName);
            if (object != null) {
                nativeAddJavascriptInterface(nativeFramePointer,
                        mJavaScriptObjects.get(interfaceName), interfaceName);
            }
        }
        mRemovedJavaScriptObjects.clear();

        stringByEvaluatingJavaScriptFromString(SearchBoxImpl.JS_BRIDGE);
    }

    /**
     * This method is called by WebCore to check whether application
     * wants to hijack url loading
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.146 -0500", hash_original_method = "2FB67C52CD526BE2C970DC0DB75D361F", hash_generated_method = "663C48D7C117632B590F4F7A4FB9B8E4")
    
public boolean handleUrl(String url) {
        if (mLoadInitFromJava == true) {
            return false;
        }
        if (mCallbackProxy.shouldOverrideUrlLoading(url)) {
            // if the url is hijacked, reset the state of the BrowserFrame
            didFirstLayout();
            return true;
        } else {
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.148 -0500", hash_original_method = "8112D6E9F2629FDD519CF9C502DF963B", hash_generated_method = "EA9635805A6401407279D9374C28989A")
    
public void addJavascriptInterface(Object obj, String interfaceName) {
        assert obj != null;
        removeJavascriptInterface(interfaceName);

        mJavaScriptObjects.put(interfaceName, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.150 -0500", hash_original_method = "D4D979316C36EF31BC47A23AC0C9BE50", hash_generated_method = "DAD691112337D40BE310667C5D2BC7F1")
    
public void removeJavascriptInterface(String interfaceName) {
        // We keep a reference to the removed object because the native side holds only a weak
        // reference and we need to allow the object to continue to be used until the page has been
        // navigated.
        if (mJavaScriptObjects.containsKey(interfaceName)) {
            mRemovedJavaScriptObjects.add(mJavaScriptObjects.remove(interfaceName));
        }
    }

    /**
     * Called by JNI.  Given a URI, find the associated file and return its size
     * @param uri A String representing the URI of the desired file.
     * @return int The size of the given file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.153 -0500", hash_original_method = "DF8E19ADC1C4D892E5E9E24D72F873C3", hash_generated_method = "38491F4E04C88F3067B64ECA6F23EA31")
    
private int getFileSize(String uri) {
        int size = 0;
        try {
            InputStream stream = mContext.getContentResolver()
                            .openInputStream(Uri.parse(uri));
            size = stream.available();
            stream.close();
        } catch (Exception e) {}
        return size;
    }

    /**
     * Called by JNI.  Given a URI, a buffer, and an offset into the buffer,
     * copy the resource into buffer.
     * @param uri A String representing the URI of the desired file.
     * @param buffer The byte array to copy the data into.
     * @param offset The offet into buffer to place the data.
     * @param expectedSize The size that the buffer has allocated for this file.
     * @return int The size of the given file, or zero if it fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.156 -0500", hash_original_method = "D65A9387A3FB37FCB544A79FFB5606B6", hash_generated_method = "99C51532C2A85ADA1E1CEE7620748EF3")
    
private int getFile(String uri, byte[] buffer, int offset,
            int expectedSize) {
        int size = 0;
        try {
            InputStream stream = mContext.getContentResolver()
                            .openInputStream(Uri.parse(uri));
            size = stream.available();
            if (size <= expectedSize && buffer != null
                    && buffer.length - offset >= size) {
                stream.read(buffer, offset, size);
            } else {
                size = 0;
            }
            stream.close();
        } catch (java.io.FileNotFoundException e) {
            Log.e(LOGTAG, "FileNotFoundException:" + e);
            size = 0;
        } catch (java.io.IOException e2) {
            Log.e(LOGTAG, "IOException: " + e2);
            size = 0;
        }
        return size;
    }
        
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.297 -0400", hash_original_method = "60CA323AEDF7C276FF8B65BEFBD4FA69", hash_generated_method = "7D89BCA3D4AB00A29B991E0D9B7AA4A5")
    private InputStream inputStreamForAndroidResource(String url) {
        addTaint(url.getTaint());
        final String ANDROID_ASSET = "file:///android_asset/";
        final String ANDROID_RESOURCE = "file:///android_res/";
        final String ANDROID_CONTENT = "content:";
        if(url.startsWith(ANDROID_RESOURCE))        
        {
            url = url.replaceFirst(ANDROID_RESOURCE, "");
            if(url == null || url.length() == 0)            
            {
InputStream var540C13E9E156B687226421B24F2DF178_1805354417 =                 null;
                var540C13E9E156B687226421B24F2DF178_1805354417.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1805354417;
            } //End block
            int slash = url.indexOf('/');
            int dot = url.indexOf('.', slash);
            if(slash == -1 || dot == -1)            
            {
InputStream var540C13E9E156B687226421B24F2DF178_516075261 =                 null;
                var540C13E9E156B687226421B24F2DF178_516075261.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_516075261;
            } //End block
            String subClassName = url.substring(0, slash);
            String fieldName = url.substring(slash + 1, dot);
            String errorMsg = null;
            try 
            {
                final Class<?> d = mContext.getApplicationContext()
                        .getClassLoader().loadClass(
                                mContext.getPackageName() + ".R$"
                                        + subClassName);
                final java.lang.reflect.Field field = d.getField(fieldName);
                final int id = field.getInt(null);
                TypedValue value = new TypedValue();
                mContext.getResources().getValue(id, value, true);
                if(value.type == TypedValue.TYPE_STRING)                
                {
InputStream varC78BFCF12FBFA3227A0197E64EC01945_850987104 =                     mContext.getAssets().openNonAsset(
                            value.assetCookie, value.string.toString(),
                            AssetManager.ACCESS_STREAMING);
                    varC78BFCF12FBFA3227A0197E64EC01945_850987104.addTaint(taint);
                    return varC78BFCF12FBFA3227A0197E64EC01945_850987104;
                } //End block
                else
                {
InputStream var540C13E9E156B687226421B24F2DF178_345571007 =                     null;
                    var540C13E9E156B687226421B24F2DF178_345571007.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_345571007;
                } //End block
            } //End block
            catch (Exception e)
            {
InputStream var540C13E9E156B687226421B24F2DF178_1844221166 =                 null;
                var540C13E9E156B687226421B24F2DF178_1844221166.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1844221166;
            } //End block
        } //End block
        else
        if(url.startsWith(ANDROID_ASSET))        
        {
            url = url.replaceFirst(ANDROID_ASSET, "");
            try 
            {
                AssetManager assets = mContext.getAssets();
InputStream var6EC0EF420A631EB21F555D908B217CE1_2052547921 =                 assets.open(url, AssetManager.ACCESS_STREAMING);
                var6EC0EF420A631EB21F555D908B217CE1_2052547921.addTaint(taint);
                return var6EC0EF420A631EB21F555D908B217CE1_2052547921;
            } //End block
            catch (IOException e)
            {
InputStream var540C13E9E156B687226421B24F2DF178_1943533256 =                 null;
                var540C13E9E156B687226421B24F2DF178_1943533256.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1943533256;
            } //End block
        } //End block
        else
        if(mSettings.getAllowContentAccess() &&
                   url.startsWith(ANDROID_CONTENT))        
        {
            try 
            {
                int mimeIndex = url.lastIndexOf('?');
                if(mimeIndex != -1)                
                {
                    url = url.substring(0, mimeIndex);
                } //End block
                Uri uri = Uri.parse(url);
InputStream varD596734B53E0C27C52F1BA3951A39E00_86716833 =                 mContext.getContentResolver().openInputStream(uri);
                varD596734B53E0C27C52F1BA3951A39E00_86716833.addTaint(taint);
                return varD596734B53E0C27C52F1BA3951A39E00_86716833;
            } //End block
            catch (Exception e)
            {
InputStream var540C13E9E156B687226421B24F2DF178_1487990529 =                 null;
                var540C13E9E156B687226421B24F2DF178_1487990529.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1487990529;
            } //End block
        } //End block
        else
        {
InputStream var540C13E9E156B687226421B24F2DF178_1855706854 =             null;
            var540C13E9E156B687226421B24F2DF178_1855706854.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1855706854;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    /**
     * Start loading a resource.
     * @param loaderHandle The native ResourceLoader that is the target of the
     *                     data.
     * @param url The url to load.
     * @param method The http method.
     * @param headers The http headers.
     * @param postData If the method is "POST" postData is sent as the request
     *                 body. Is null when empty.
     * @param postDataIdentifier If the post data contained form this is the form identifier, otherwise it is 0.
     * @param cacheMode The cache mode to use when loading this resource. See WebSettings.setCacheMode
     * @param mainResource True if the this resource is the main request, not a supporting resource
     * @param userGesture
     * @param synchronous True if the load is synchronous.
     * @return A newly created LoadListener object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.163 -0500", hash_original_method = "DEA49E30923C6B4E17F9FB446E1784D4", hash_generated_method = "ADCBF7F54D14F547D47B3A564F6E4BF7")
    
private LoadListener startLoadingResource(int loaderHandle,
                                              String url,
                                              String method,
                                              HashMap headers,
                                              byte[] postData,
                                              long postDataIdentifier,
                                              int cacheMode,
                                              boolean mainResource,
                                              boolean userGesture,
                                              boolean synchronous,
                                              String username,
                                              String password) {
        if (mSettings.getCacheMode() != WebSettings.LOAD_DEFAULT) {
            cacheMode = mSettings.getCacheMode();
        }

        if (method.equals("POST")) {
            // Don't use the cache on POSTs when issuing a normal POST
            // request.
            if (cacheMode == WebSettings.LOAD_NORMAL) {
                cacheMode = WebSettings.LOAD_NO_CACHE;
            }
            String[] ret = getUsernamePassword();
            if (ret != null) {
                String domUsername = ret[0];
                String domPassword = ret[1];
                maybeSavePassword(postData, domUsername, domPassword);
            }
        }

        // is this resource the main-frame top-level page?
        boolean isMainFramePage = mIsMainFrame;

        if (DebugFlags.BROWSER_FRAME) {
            Log.v(LOGTAG, "startLoadingResource: url=" + url + ", method="
                    + method + ", postData=" + postData + ", isMainFramePage="
                    + isMainFramePage + ", mainResource=" + mainResource
                    + ", userGesture=" + userGesture);
        }

        // Create a LoadListener
        LoadListener loadListener = LoadListener.getLoadListener(mContext,
                this, url, loaderHandle, synchronous, isMainFramePage,
                mainResource, userGesture, postDataIdentifier, username, password);

        if (LoadListener.getNativeLoaderCount() > MAX_OUTSTANDING_REQUESTS) {
            // send an error message, so that loadListener can be deleted
            // after this is returned. This is important as LoadListener's 
            // nativeError will remove the request from its DocLoader's request
            // list. But the set up is not done until this method is returned.
            loadListener.error(
                    android.net.http.EventHandler.ERROR, mContext.getString(
                            com.android.internal.R.string.httpErrorTooManyRequests));
            return loadListener;
        }

        // Note that we are intentionally skipping
        // inputStreamForAndroidResource.  This is so that FrameLoader will use
        // the various StreamLoader classes to handle assets.
        FrameLoader loader = new FrameLoader(loadListener, mSettings, method,
                mCallbackProxy.shouldInterceptRequest(url));
        loader.setHeaders(headers);
        loader.setPostData(postData);
        // Set the load mode to the mode used for the current page.
        // If WebKit wants validation, go to network directly.
        loader.setCacheMode(headers.containsKey("If-Modified-Since")
                || headers.containsKey("If-None-Match") ? 
                        WebSettings.LOAD_NO_CACHE : cacheMode);
        // Set referrer to current URL?
        return !synchronous ? loadListener : null;
    }

    /**
     * If this looks like a POST request (form submission) containing a username
     * and password, give the user the option of saving them. Will either do
     * nothing, or block until the UI interaction is complete.
     *
     * Called by startLoadingResource when using the Apache HTTP stack.
     * Called directly by WebKit when using the Chrome HTTP stack.
     *
     * @param postData The data about to be sent as the body of a POST request.
     * @param username The username entered by the user (sniffed from the DOM).
     * @param password The password entered by the user (sniffed from the DOM).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.166 -0500", hash_original_method = "69B43B2B2D64063203E22417AF1B4FBE", hash_generated_method = "9B363FF05DB78C31F3C70490363968C8")
    
private void maybeSavePassword(
            byte[] postData, String username, String password) {
        if (postData == null
                || username == null || username.isEmpty()
                || password == null || password.isEmpty()) {
            return; // No password to save.
        }

        if (!mSettings.getSavePassword()) {
            return; // User doesn't want to save passwords.
        }

        try {
            if (DebugFlags.BROWSER_FRAME) {
                Assert.assertNotNull(mCallbackProxy.getBackForwardList()
                        .getCurrentItem());
            }
            WebAddress uri = new WebAddress(mCallbackProxy
                    .getBackForwardList().getCurrentItem().getUrl());
            String schemePlusHost = uri.getScheme() + uri.getHost();
            // Check to see if the username & password appear in
            // the post data (there could be another form on the
            // page and that was posted instead.
            String postString = new String(postData);
            if (postString.contains(URLEncoder.encode(username)) &&
                    postString.contains(URLEncoder.encode(password))) {
                String[] saved = mDatabase.getUsernamePassword(
                        schemePlusHost);
                if (saved != null) {
                    // null username implies that user has chosen not to
                    // save password
                    if (saved[0] != null) {
                        // non-null username implies that user has
                        // chosen to save password, so update the
                        // recorded password
                        mDatabase.setUsernamePassword(
                                schemePlusHost, username, password);
                    }
                } else {
                    // CallbackProxy will handle creating the resume
                    // message
                    mCallbackProxy.onSavePassword(schemePlusHost, username,
                            password, null);
                }
            }
        } catch (ParseException ex) {
            // if it is bad uri, don't save its password
        }
    }

    // Called by jni from the chrome network stack.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.168 -0500", hash_original_method = "DD9E58924AE2FD70E5FF51B9D61BCBED", hash_generated_method = "2CECB201E6CC90EA2272DFB57640BE13")
    
private WebResourceResponse shouldInterceptRequest(String url) {
        InputStream androidResource = inputStreamForAndroidResource(url);
        if (androidResource != null) {
            return new WebResourceResponse(null, null, androidResource);
        }
        WebResourceResponse response = mCallbackProxy.shouldInterceptRequest(url);
        if (response == null && "browser:incognito".equals(url)) {
            try {
                Resources res = mContext.getResources();
                InputStream ins = res.openRawResource(
                        com.android.internal.R.raw.incognito_mode_start_page);
                response = new WebResourceResponse("text/html", "utf8", ins);
            } catch (NotFoundException ex) {
                // This shouldn't happen, but try and gracefully handle it jic
                Log.w(LOGTAG, "Failed opening raw.incognito_mode_start_page", ex);
            }
        }
        return response;
    }

    /**
     * Set the progress for the browser activity.  Called by native code.
     * Uses a delay so it does not happen too often.
     * @param newProgress An int between zero and one hundred representing
     *                    the current progress percentage of loading the page.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.171 -0500", hash_original_method = "07700DAB8245AC940D55DCEF1A17B102", hash_generated_method = "1346203C23A4361CE1942CB7556347BA")
    
private void setProgress(int newProgress) {
        mCallbackProxy.onProgressChanged(newProgress);
        if (newProgress == 100) {
            sendMessageDelayed(obtainMessage(FRAME_COMPLETED), 100);
        }
        // FIXME: Need to figure out a better way to switch out of the history
        // drawing mode. Maybe we can somehow compare the history picture with 
        // the current picture, and switch when it contains more content.
        if (mFirstLayoutDone && newProgress > TRANSITION_SWITCH_THRESHOLD) {
            mCallbackProxy.switchOutDrawHistory();
        }
    }

    /**
     * Send the icon to the activity for display.
     * @param icon A Bitmap representing a page's favicon.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.174 -0500", hash_original_method = "910C3A78FCE0B1E574FD9CA74D1EE7A9", hash_generated_method = "D28FE7594F08537D0E73353BED18B374")
    
private void didReceiveIcon(Bitmap icon) {
        mCallbackProxy.onReceivedIcon(icon);
    }

    // Called by JNI when an apple-touch-icon attribute was found.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.176 -0500", hash_original_method = "F9E26289979EC36BEDC07872BFD387F0", hash_generated_method = "EFA0D8E6A38AEFF94B40E9A4E2A04FE2")
    
private void didReceiveTouchIconUrl(String url, boolean precomposed) {
        mCallbackProxy.onReceivedTouchIconUrl(url, precomposed);
    }

    /**
     * Request a new window from the client.
     * @return The BrowserFrame object stored in the new WebView.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.178 -0500", hash_original_method = "49DBB49355B8BD4E95F5FBA6E171926E", hash_generated_method = "59EFD5B8330CF6583E735570D5217D7A")
    
private BrowserFrame createWindow(boolean dialog, boolean userGesture) {
        return mCallbackProxy.createWindow(dialog, userGesture);
    }

    /**
     * Try to focus this WebView.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.180 -0500", hash_original_method = "05E62B842D0E318583ACCB4619923A88", hash_generated_method = "C819474EE6118508400B6D2AD475968F")
    
private void requestFocus() {
        mCallbackProxy.onRequestFocus();
    }

    /**
     * Close this frame and window.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.183 -0500", hash_original_method = "A6BF5F00A4A45564AACA34EE9DAEC5CF", hash_generated_method = "46907B0190919553DD53D2F1687686EC")
    
private void closeWindow(WebViewCore w) {
        mCallbackProxy.onCloseWindow(w.getWebView());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.190 -0500", hash_original_method = "53828DFE68036F8E35ADAC562AA427C9", hash_generated_method = "5C3A520C0B5183C1E16F1E23B177695F")
    
private void decidePolicyForFormResubmission(int policyFunction) {
        Message dontResend = obtainMessage(POLICY_FUNCTION, policyFunction,
                POLICY_IGNORE);
        Message resend = obtainMessage(POLICY_FUNCTION, policyFunction,
                POLICY_USE);
        mCallbackProxy.onFormResubmission(dontResend, resend);
    }

    /**
     * Tell the activity to update its global history.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.192 -0500", hash_original_method = "B19BAB1EEF674556A3A9CC47CD14FB0B", hash_generated_method = "A4A93DB84096F87B82DB777B3CD75A12")
    
private void updateVisitedHistory(String url, boolean isReload) {
        mCallbackProxy.doUpdateVisitedHistory(url, isReload);
    }

    /**
     * Get the CallbackProxy for sending messages to the UI thread.
     */
    /* package */ @DSSource({DSSourceKind.BROWSER_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.194 -0500", hash_original_method = "D3ED977A3BCAC48329E24D7D69689852", hash_generated_method = "D3ED977A3BCAC48329E24D7D69689852")
    
CallbackProxy getCallbackProxy() {
        return mCallbackProxy;
    }

    /**
     * Returns the User Agent used by this frame
     */
    @DSSource({DSSourceKind.BROWSER_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.197 -0500", hash_original_method = "F09A8DE53C03EAD5D6B2D7442C92246E", hash_generated_method = "F09A8DE53C03EAD5D6B2D7442C92246E")
    
String getUserAgentString() {
        return mSettings.getUserAgentString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.215 -0500", hash_original_method = "D14466E1FBBBA5A0DDC9A63472126D93", hash_generated_method = "FC1CEB20F0A2030E12B2893C5F1B5453")
    
private String getRawResFilename(int id) {
        return getRawResFilename(id, mContext);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.220 -0500", hash_original_method = "E4DD03CAE364FD517B782C57726FD370", hash_generated_method = "2C757E9A29C2FD3560D0A5B6424D6332")
    
private float density() {
        return mContext.getResources().getDisplayMetrics().density;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.300 -0400", hash_original_method = "468A4DE23411D07F152B7955301757EE", hash_generated_method = "EF6FBD3E66E53A2039127B1AC512D427")
    private void didReceiveAuthenticationChallenge(
            final int handle, String host, String realm, final boolean useCachedCredentials,
            final boolean suppressDialog) {
        addTaint(suppressDialog);
        addTaint(useCachedCredentials);
        addTaint(realm.getTaint());
        addTaint(host.getTaint());
        addTaint(handle);
        HttpAuthHandler handler = new HttpAuthHandler() {

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.224 -0500", hash_original_method = "2E5F35CA74F94F853B8AE97058D81CC0", hash_generated_method = "4FF7A6C3A4C37B30AB177A80DB1B3136")
            
@Override
            public boolean useHttpAuthUsernamePassword() {
                return useCachedCredentials;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.226 -0500", hash_original_method = "1875FC664610ADF8E505FF933116EC72", hash_generated_method = "B724E7CC5E7E3B156FCABE692FA0B001")
            
@Override
            public void proceed(String username, String password) {
                nativeAuthenticationProceed(handle, username, password);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.229 -0500", hash_original_method = "D09539EE18C5A19F474F76D04B56AE03", hash_generated_method = "9D6470C767AA9889C65EBBCEB552F218")
            
@Override
            public void cancel() {
                nativeAuthenticationCancel(handle);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.233 -0500", hash_original_method = "912BB5A6474D3E35EA60CB5710504F7C", hash_generated_method = "B2390A18BD25CF5504F3F87EE6CB0A4E")
            
@Override
            public boolean suppressDialog() {
                return suppressDialog;
            }
        };
        mCallbackProxy.onReceivedHttpAuthRequest(handler, host, realm);
        // ---------- Original Method ----------
        //HttpAuthHandler handler = new HttpAuthHandler() {
            //@Override
            //public boolean useHttpAuthUsernamePassword() {
                //return useCachedCredentials;
            //}
            //@Override
            //public void proceed(String username, String password) {
                //nativeAuthenticationProceed(handle, username, password);
            //}
            //@Override
            //public void cancel() {
                //nativeAuthenticationCancel(handle);
            //}
            //@Override
            //public boolean suppressDialog() {
                //return suppressDialog;
            //}
        //};
        //mCallbackProxy.onReceivedHttpAuthRequest(handler, host, realm);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.044 -0400", hash_original_method = "BF59E951CBFF79EB5A7A07D0C7840C24", hash_generated_method = "56CA8B86B76D265AAC63B7DA59AFC465")
    private void reportSslCertError(final int handle, final int certError, byte certDER[],
            String url) {
        addTaint(url.getTaint());
        addTaint(certDER[0]);
        addTaint(certError);
        addTaint(handle);
        final SslError sslError;
        try 
        {
            X509Certificate cert = new X509CertImpl(certDER);
            SslCertificate sslCert = new SslCertificate(cert);
            sslError = SslError.SslErrorFromChromiumErrorCode(certError, sslCert, url);
        } //End block
        catch (IOException e)
        {
            nativeSslCertErrorCancel(handle, certError);
            return;
        } //End block
    if(SslCertLookupTable.getInstance().isAllowed(sslError))        
        {
            nativeSslCertErrorProceed(handle);
            mCallbackProxy.onProceededAfterSslError(sslError);
            return;
        } //End block
        SslErrorHandler handler = new SslErrorHandler() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.238 -0500", hash_original_method = "050F481CF539CEE7DA0C143E2D5030DF", hash_generated_method = "CC892E008C79F1AC9F5D24CE995C1098")
            
@Override
            public void proceed() {
                SslCertLookupTable.getInstance().setIsAllowed(sslError);
                nativeSslCertErrorProceed(handle);
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.241 -0500", hash_original_method = "615CCD38C29C1E3736BA69BF3E564640", hash_generated_method = "38357AA0DE485703A41796EB0C91ED9B")
            
@Override
            public void cancel() {
                nativeSslCertErrorCancel(handle, certError);
            }
        };
        mCallbackProxy.onReceivedSslError(handler, sslError);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    /**
     * Called by JNI when the native HTTPS stack gets a client
     * certificate request.
     *
     * We delegate the request to CallbackProxy, and route its response to
     * {@link #nativeSslClientCert(int, X509Certificate)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.246 -0500", hash_original_method = "DFA7C324E28D10E855E86AE4BB5B7562", hash_generated_method = "F326817D796D1230CE099623BEB6B8C3")
    
private void requestClientCert(int handle, String hostAndPort) {
        SslClientCertLookupTable table = SslClientCertLookupTable.getInstance();
        if (table.IsAllowed(hostAndPort)) {
            // previously allowed
            nativeSslClientCert(handle,
                                table.PrivateKey(hostAndPort),
                                table.CertificateChain(hostAndPort));
        } else if (table.IsDenied(hostAndPort)) {
            // previously denied
            nativeSslClientCert(handle, null, null);
        } else {
            // previously ignored or new
            mCallbackProxy.onReceivedClientCertRequest(
                    new ClientCertRequestHandler(this, handle, hostAndPort, table), hostAndPort);
        }
    }

    /**
     * Called by JNI when the native HTTP stack needs to download a file.
     *
     * We delegate the request to CallbackProxy, which owns the current app's
     * DownloadListener.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.249 -0500", hash_original_method = "322B645C7F09570DF98848B1C3D767D8", hash_generated_method = "7C1CDEC77E67281F51947C6E8EFC17AE")
    
private void downloadStart(String url, String userAgent,
            String contentDisposition, String mimeType, long contentLength) {
        // This will only work if the url ends with the filename
        if (mimeType.isEmpty()) {
            try {
                String extension = url.substring(url.lastIndexOf('.') + 1);
                mimeType = libcore.net.MimeUtils.guessMimeTypeFromExtension(extension);
                // MimeUtils might return null, not sure if downloadmanager is happy with that
                if (mimeType == null)
                    mimeType = "";
            } catch(IndexOutOfBoundsException exception) {
                // mimeType string end with a '.', not much to do
            }
        }
        mimeType = MimeTypeMap.getSingleton().remapGenericMimeType(
                mimeType, url, contentDisposition);

        if (CertTool.getCertType(mimeType) != null) {
            mKeyStoreHandler = new KeyStoreHandler(mimeType);
        } else {
            mCallbackProxy.onDownloadStart(url, userAgent,
                contentDisposition, mimeType, contentLength);
        }
    }

    /**
     * Called by JNI for Chrome HTTP stack when the Java side needs to access the data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.251 -0500", hash_original_method = "BAE8CD84EA4D59BD4BB7CAF15EB1C07F", hash_generated_method = "7445C14409FF7674B142C1E17AAC50F3")
    
private void didReceiveData(byte data[], int size) {
        if (mKeyStoreHandler != null) mKeyStoreHandler.didReceiveData(data, size);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.253 -0500", hash_original_method = "5EC89579D3745ABD19569589FBBBCA81", hash_generated_method = "BF9091BC227ECCCDDA7F7BA30A006F61")
    
private void didFinishLoading() {
      if (mKeyStoreHandler != null) {
          mKeyStoreHandler.installCert(mContext);
          mKeyStoreHandler = null;
      }
    }

    /**
     * Called by JNI when we recieve a certificate for the page's main resource.
     * Used by the Chromium HTTP stack only.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.255 -0500", hash_original_method = "A2E04BD398BDF0F096F042D99402CC27", hash_generated_method = "0CF75FAE561507595D7ECE10D393A40C")
    
private void setCertificate(byte cert_der[]) {
        try {
            X509Certificate cert = new X509CertImpl(cert_der);
            mCallbackProxy.onReceivedCertificate(new SslCertificate(cert));
        } catch (IOException e) {
            // Can't get the certificate, not much to do.
            Log.e(LOGTAG, "Can't get the certificate from WebKit, canceling");
            return;
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.257 -0500", hash_original_method = "780A48AF1DFDDD134926E1881FBB7981", hash_generated_method = "780A48AF1DFDDD134926E1881FBB7981")
    
SearchBox getSearchBox() {
        return mSearchBox;
    }

    /**
     * Called by JNI when processing the X-Auto-Login header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.260 -0500", hash_original_method = "957E1FEE267AF2EB4B4A609321166001", hash_generated_method = "6CE7CA93B49D4E548EC58C3E38AED7C2")
    
private void autoLogin(String realm, String account, String args) {
        mCallbackProxy.onReceivedLoginRequest(realm, account, args);
    }

    //==========================================================================
    // native functions
    //==========================================================================

    /**
     * Create a new native frame for a given WebView
     * @param w     A WebView that the frame draws into.
     * @param am    AssetManager to use to get assets.
     * @param list  The native side will add and remove items from this list as
     *              the native list changes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.264 -0500", hash_original_method = "CAC5AC041AD65DE746A86B06B460473E", hash_generated_method = "73AE5058C776F471080D184F0ABD763B")
    
    private void nativeCreateFrame(WebViewCore w, AssetManager am,
                WebBackForwardList list){
    	//Formerly a native method
    	addTaint(w.getTaint());
    	addTaint(am.getTaint());
    	addTaint(list.getTaint());
    }

    /**
     * Destroy the native frame.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.267 -0500", hash_original_method = "74AC0793AA670585A51BA4B2FC045561", hash_generated_method = "7B430B8E4D15CE48346DD2C7229FF5A3")
    
    public void nativeDestroyFrame(){
    	//Formerly a native method
    }
    
    private static class ConfigCallback implements ComponentCallbacks {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.059 -0500", hash_original_field = "9BDCFD1DEC1E58C555C4893FB1A5089E", hash_generated_field = "939312DE689389EC63468038A0B3966B")

        private final ArrayList<WeakReference<Handler>> mHandlers =
                new ArrayList<WeakReference<Handler>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.061 -0500", hash_original_field = "83A062836C11DD52DC32F4325712F233", hash_generated_field = "3C750A4AE06B71AF3A05B7797C7182A4")

        private  WindowManager mWindowManager;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.064 -0500", hash_original_method = "049F58B9ED595813037671BB1DAC0333", hash_generated_method = "049F58B9ED595813037671BB1DAC0333")
        
ConfigCallback(WindowManager wm) {
            mWindowManager = wm;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.067 -0500", hash_original_method = "3638F495C0637CBBD96B9D8F0DA8CFC2", hash_generated_method = "C41CC08B6ACB89F105258F0416D81A6A")
        
public synchronized void addHandler(Handler h) {
            // No need to ever remove a Handler. If the BrowserFrame is
            // destroyed, it will be collected and the WeakReference set to
            // null. If it happens to still be around during a configuration
            // change, the message will be ignored.
            mHandlers.add(new WeakReference<Handler>(h));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.070 -0500", hash_original_method = "2BDCB7974021DF1350762A5BB88607D6", hash_generated_method = "F7D6845B69102DDA83A3F9CC85E742F9")
        
public void onConfigurationChanged(Configuration newConfig) {
            if (mHandlers.size() == 0) {
                return;
            }
            int orientation =
                    mWindowManager.getDefaultDisplay().getOrientation();
            switch (orientation) {
                case Surface.ROTATION_90:
                    orientation = 90;
                    break;
                case Surface.ROTATION_180:
                    orientation = 180;
                    break;
                case Surface.ROTATION_270:
                    orientation = -90;
                    break;
                case Surface.ROTATION_0:
                    orientation = 0;
                    break;
                default:
                    break;
            }
            synchronized (this) {
                // Create a list of handlers to remove. Go ahead and make it
                // the same size to avoid resizing.
                ArrayList<WeakReference> handlersToRemove =
                        new ArrayList<WeakReference>(mHandlers.size());
                for (WeakReference<Handler> wh : mHandlers) {
                    Handler h = wh.get();
                    if (h != null) {
                        h.sendMessage(h.obtainMessage(ORIENTATION_CHANGED,
                                    orientation, 0));
                    } else {
                        handlersToRemove.add(wh);
                    }
                }
                // Now remove all the null references.
                for (WeakReference weak : handlersToRemove) {
                    mHandlers.remove(weak);
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.072 -0500", hash_original_method = "4F0E380BE715BF5B2ECCDB1794C8905E", hash_generated_method = "79F592DC22C7A97AE301DB7CC367A921")
        
public void onLowMemory() {}
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.271 -0500", hash_original_method = "7D705910310ED484283730AFB821A717", hash_generated_method = "406301031B3AABF223F5324690FD3ED4")
    
    private void nativeCallPolicyFunction(int policyFunction,
                int decision){
    	//Formerly a native method
    	addTaint(policyFunction);
    	addTaint(decision);
    }

    /**
     * Reload the current main frame.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.274 -0500", hash_original_method = "AE07D7138DB6945AA08789E90E80B92B", hash_generated_method = "1B289DA79CEA990160878E347151CD53")
    
    public void reload(boolean allowStale){
    	//Formerly a native method
    	addTaint(allowStale);
    }

    /**
     * Go back or forward the number of steps given.
     * @param steps A negative or positive number indicating the direction
     *              and number of steps to move.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.279 -0500", hash_original_method = "53A1F9C2A72688D9CD2F75BB7D3D5005", hash_generated_method = "0F9B35A447BBA3AFD0BD90BA2849A5D4")
    
    private void nativeGoBackOrForward(int steps){
    	//Formerly a native method
    	addTaint(steps);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.739 -0400", hash_original_method = "F143225F39CB01C1D802EC565271C419", hash_generated_method = "29BBC25C86CDC16E4793C63D3F6022F4")
    
    public String stringByEvaluatingJavaScriptFromString(String script) {
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }

    /**
     * Add a javascript interface to the main frame.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.286 -0500", hash_original_method = "1BC95C43CEE0FFE1F6217DA26B59C5B9", hash_generated_method = "26CC9F7BD5DA7915884E25F00AB2853B")
    
    private void nativeAddJavascriptInterface(int nativeFramePointer,
                Object obj, String interfaceName){
    	//Formerly a native method
    	addTaint(nativeFramePointer);
    	addTaint(obj.getTaint());
    	addTaint(interfaceName.getTaint());
    }

    /**
     * Enable or disable the native cache.
     */
    /* FIXME: The native cache is always on for now until we have a better
     * solution for our 2 caches. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.289 -0500", hash_original_method = "B177754AEEE092C53184C415EE8118E6", hash_generated_method = "722DDFC3A5FE357762C782EF27156D3B")
    
    private void setCacheDisabled(boolean disabled){
    	//Formerly a native method
    	addTaint(disabled);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.293 -0500", hash_original_method = "8B7AAFA05BB3F3ED8C594AA78F708D08", hash_generated_method = "4C9B88273F8B44A312577AE9D65BDD2E")
    
    public boolean cacheDisabled(){
    	//Formerly a native method
    	return getTaintBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.296 -0500", hash_original_method = "055468486DD4D3FA9B64A316B50FA6FA", hash_generated_method = "B3EA28451694567278DBB7B8C5898FA0")
    
    public void clearCache(){
    	//Formerly a native method
    }

    /**
     * Returns false if the url is bad.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.301 -0500", hash_original_method = "6C44E95231996B5164D16D96A5AF9CAD", hash_generated_method = "40B9E65FBFB1331A55BF5EE628C65CE7")
    
    private void nativeLoadUrl(String url, Map<String, String> headers){
    	//Formerly a native method
    	addTaint(url.getTaint());
    	addTaint(headers.getTaint());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.305 -0500", hash_original_method = "4DAAE38A658B1BBD069DC4A366A0C462", hash_generated_method = "9B6613BA10C56B29898E9C3B20F75C07")
    
    private void nativePostUrl(String url, byte[] postData){
    	//Formerly a native method
    	addTaint(url.getTaint());
    	addTaint(postData[0]);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.308 -0500", hash_original_method = "8945167C96AD091C5C39DEC108C4839D", hash_generated_method = "70E1BAD91CD52B6C68F6253B2A952D74")
    
    private void nativeLoadData(String baseUrl, String data,
                String mimeType, String encoding, String historyUrl){
    	//Formerly a native method
    	addTaint(baseUrl.getTaint());
    	addTaint(data.getTaint());
    	addTaint(mimeType.getTaint());
    	addTaint(encoding.getTaint());
    	addTaint(historyUrl.getTaint());
    }

    /**
     * Stop loading the current page.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.310 -0500", hash_original_method = "A939F96E349A2DAAC3BA975E2507007D", hash_generated_method = "0D3AFC876C6EE253E6960329A24DBDC9")
    
public void stopLoading() {
        if (mIsMainFrame) {
            resetLoadingStates();
        }
        nativeStopLoading();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.314 -0500", hash_original_method = "64AB65E4A9095F9BBCDCF9CF6CF9A5F6", hash_generated_method = "B52A492092BFFE8F4C3A94EF3C1BBCCF")
    
    private void nativeStopLoading(){
    	//Formerly a native method
    }

    /**
     * Return true if the document has images.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.318 -0500", hash_original_method = "9D75E2E2AB8D83EF2AA67EF8FE72195D", hash_generated_method = "66F94E328ECD4F0B65EDA58A2030DF2D")
    
    public boolean documentHasImages(){
    	//Formerly a native method
    	return getTaintBoolean();
    }

    /**
     * @return TRUE if there is a password field in the current frame
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.321 -0500", hash_original_method = "10318A015094FE1A39B49B3070F280C0", hash_generated_method = "F4A3AF6118273DC4FD2670F4C29DD8CB")
    
    private boolean hasPasswordField(){
    	//Formerly a native method
    	return getTaintBoolean();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.743 -0400", hash_original_method = "865B533AFC1748A162575C4402C4E1D7", hash_generated_method = "649B5EB499FF582D6D8E126787969B7F")
    private String[] getUsernamePassword() {
    	String[] s = new String[1];
    	s.addTaint(taint);
    	return s;
    }

    /**
     * Set username and password to the proper fields in the current frame
     * @param username
     * @param password
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.328 -0500", hash_original_method = "2745608D69207B6EE74824552EF70660", hash_generated_method = "6E88AFFB477D5693F1F3FC876B4BCA60")
    
    private void setUsernamePassword(String username, String password){
    	//Formerly a native method
    	addTaint(username.getTaint());
    	addTaint(password.getTaint());
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.743 -0400", hash_original_method = "74581984BB5BC192860C6547F8D5036F", hash_generated_method = "1313694DA1B47EE7DE9BC757D7889251")
    private String nativeSaveWebArchive(String basename, boolean autoname) {
    	addTaint(autoname);
    	addTaint(basename.taint);
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.336 -0500", hash_original_method = "08E54613B59D770C860286634891B8BB", hash_generated_method = "21220B1EDA678AA52C6F474D39FEDE96")
    
    private void nativeOrientationChanged(int orientation){
    	//Formerly a native method
    	addTaint(orientation);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.340 -0500", hash_original_method = "68B2D8AE5CF2C1C845D97B94EDB581CC", hash_generated_method = "C0C0561BBCCD82FBB7D90A7C0971E34C")
    
    private void nativeAuthenticationProceed(int handle, String username, String password){
    	//Formerly a native method
    	addTaint(handle);
    	addTaint(username.getTaint());
    	addTaint(password.getTaint());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.343 -0500", hash_original_method = "9DEA51422898C7E38A3DECD149992B9B", hash_generated_method = "B1A5E441167C0DF26C4F33E6275E9502")
    
    private void nativeAuthenticationCancel(int handle){
    	//Formerly a native method
    	addTaint(handle);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.347 -0500", hash_original_method = "DFE86F393FFB1B33336576462A995D77", hash_generated_method = "78CBB94BAAC06C870BCF54AF7BFB0C64")
    
    private void nativeSslCertErrorProceed(int handle){
    	//Formerly a native method
    	addTaint(handle);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.351 -0500", hash_original_method = "8A69525C805CE3B5326B3888FD841CA0", hash_generated_method = "7093D1398B4C1821787DE09D35C68DED")
    
    private void nativeSslCertErrorCancel(int handle, int certError){
    	//Formerly a native method
    	addTaint(handle);
    	addTaint(certError);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.355 -0500", hash_original_method = "81F222D4FD7D3F4B597DBD7F9BD0D106", hash_generated_method = "52BA7D1750B8229E20200613F672C566")
    
    void nativeSslClientCert(int handle,
                                        byte[] pkcs8EncodedPrivateKey,
                                        byte[][] asn1DerEncodedCertificateChain){
    	//Formerly a native method
    	addTaint(handle);
    	addTaint(pkcs8EncodedPrivateKey[0]);
    	addTaint(asn1DerEncodedCertificateChain[0][0]);
    }

    /**
     * Returns true when the contents of the frame is an RTL or vertical-rl
     * page. This is used for determining whether a frame should be initially
     * scrolled right-most as opposed to left-most.
     * @return true when the frame should be initially scrolled right-most
     * based on the text direction and writing mode.
     */
    /* package */ @DSSource({DSSourceKind.BROWSER_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.357 -0500", hash_original_method = "154F1DF98163CFE18EB2585F133E4CD5", hash_generated_method = "154F1DF98163CFE18EB2585F133E4CD5")
    
boolean getShouldStartScrolledRight() {
        return nativeGetShouldStartScrolledRight(mNativeFrame);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:12.360 -0500", hash_original_method = "F95D370518D151DA0A0757957627AE19", hash_generated_method = "20F1EA7DEE781B06C38A55CF9402CA5D")
    
    private boolean nativeGetShouldStartScrolledRight(int nativeBrowserFrame){
    	//Formerly a native method
    	addTaint(nativeBrowserFrame);
    	return getTaintBoolean();
    }

}

