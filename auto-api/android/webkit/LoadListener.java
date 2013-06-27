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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.784 -0400", hash_original_field = "1F82295670D8C49C778553291F467693", hash_generated_field = "2801F24E84D6A18BEF883D3AE94526E9")

    private ByteArrayBuilder mDataBuilder = new ByteArrayBuilder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.784 -0400", hash_original_field = "8299C83E9CFFA2EF5909444648349221", hash_generated_field = "9C2E85EC79E8F8349BF2E81BA4AC7991")

    private String mUrl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.784 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "93793E19832E1B2CEA9B3AE18495201F")

    private WebAddress mUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.784 -0400", hash_original_field = "5CE6426C79F06E218F426F0E1851F643", hash_generated_field = "632697020547475B21783FF9A242BA30")

    private boolean mPermanent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.784 -0400", hash_original_field = "C71E6F27982C162E3D48504B7CE95EEE", hash_generated_field = "568234C9B8DA241BFA5B09B8101F8B12")

    private String mOriginalUrl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.784 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.784 -0400", hash_original_field = "210C1862D81E3FCC2FD87A83EA255D40", hash_generated_field = "076F5BF2A47D119E2704BFAF413B4749")

    private BrowserFrame mBrowserFrame;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.784 -0400", hash_original_field = "8B6CED6C3251DC4BFDDBC4CCDF1CAA54", hash_generated_field = "CFE8D432F2D30F6D44FDB0D4F89E9956")

    private int mNativeLoader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.784 -0400", hash_original_field = "FA38F1960A45A7EC16349AAF783A80BC", hash_generated_field = "D6D2783B71AE4BF9CBF84D44336E2BF9")

    private String mMimeType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.784 -0400", hash_original_field = "FF7D0B646B2C057679C99D4079D890AA", hash_generated_field = "98F3D6B51351657C10385D44B0C0054D")

    private String mEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.784 -0400", hash_original_field = "2DF3ED20DD5FCAD4BBC54FFEAFD60E5D", hash_generated_field = "5B5A898734AC0BC3BD56BC7A1B09A1AA")

    private String mTransferEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.785 -0400", hash_original_field = "7948B1EFB4AE211035F97F99CDB6078C", hash_generated_field = "A03B65E05BCBAEC5D04E36F3DA55AA89")

    private int mStatusCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.785 -0400", hash_original_field = "E376B2491257EB4CB20B17AAF2E5520C", hash_generated_field = "8308E02599DA7B9492281855AF586F6A")

    private String mStatusText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.785 -0400", hash_original_field = "D4BC2D0F0185C97879D7062C4CEFD633", hash_generated_field = "1ACBF6AD05D624BD330C1EA27911AFED")

    public long mContentLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.785 -0400", hash_original_field = "1813307BAF5C3869F23F1AC0318DE4BE", hash_generated_field = "582F041564D3B399F48E8AE230C16FEE")

    private boolean mCancelled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.785 -0400", hash_original_field = "0191A284F8F26AE941D84E8E2ADF5731", hash_generated_field = "11E3D87CDBCDF8F27F5BCF75E88255E5")

    private boolean mAuthFailed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.785 -0400", hash_original_field = "6C485DBF404EED3828D28EAB5B75583E", hash_generated_field = "7D2D2225EC07E109A425BA1C9069B594")

    private CacheLoader mCacheLoader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.785 -0400", hash_original_field = "F48561BA425AAC50D6E8B7A4F82555FB", hash_generated_field = "7BD10F8B23449D67AF64947251567443")

    private boolean mFromCache = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.785 -0400", hash_original_field = "D88F8961E896B36F45BC65C0E5C94B4F", hash_generated_field = "F92F68007E24C2007F5E8613B464C2BA")

    private HttpAuthHeader mAuthHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.785 -0400", hash_original_field = "16DE1F4FBED47663F1B008C927D7B64E", hash_generated_field = "CFF6FAF13B4D5230E9FF26C0A80758BB")

    private int mErrorID = OK;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.785 -0400", hash_original_field = "4B18E53CCE831597CAE997F39A2FB253", hash_generated_field = "9A2F4E95853CE87C657553938570C697")

    private String mErrorDescription;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.785 -0400", hash_original_field = "99A9A437E48C76D1556026A0A85B5820", hash_generated_field = "260FF327C4645479FF5E5DCF19E349AD")

    private SslError mSslError;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.785 -0400", hash_original_field = "8F2BBF6B97D2E4DAE439A5022B5DBE41", hash_generated_field = "D2C086119AFB2A8257E7CAD619AFA47F")

    private RequestHandle mRequestHandle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.785 -0400", hash_original_field = "049D0917259EC924AF2E8D101BAF0656", hash_generated_field = "1D3366ACEEB83C50B8FD0D2EE0AAAE40")

    private RequestHandle mSslErrorRequestHandle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.785 -0400", hash_original_field = "326FAE0022967BEB3C583F6C15C54AA4", hash_generated_field = "B0E361E4F3B0293B8C4D8932D9873B39")

    private long mPostIdentifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.785 -0400", hash_original_field = "428D706CEC47D9F07779621FC1626C5A", hash_generated_field = "E5EA8984DD22A9073BFFEAE2B245DF81")

    private boolean mSetNativeResponse;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.785 -0400", hash_original_field = "411D2DFDB93368C46AFADBEC76A54162", hash_generated_field = "46D356CEC2B798E53528C0BD5F09C873")

    private String mMethod;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.785 -0400", hash_original_field = "0A064CD66C89784C0961CEF3F748A30D", hash_generated_field = "223EBD1E69C1299B02B1F1776461294B")

    private Map<String, String> mRequestHeaders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.785 -0400", hash_original_field = "AF86FBE15EC2C25B16B35C7E4DD756CA", hash_generated_field = "C5200C1F2575A09491B18B8CE6E6A375")

    private byte[] mPostData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.785 -0400", hash_original_field = "E3B093022B51696D8A9249A5CBB1B7C1", hash_generated_field = "FB6DD9E423DD8E3B65713D050C1DF4CF")

    private boolean mSynchronous;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.785 -0400", hash_original_field = "9B951BA0E0DD99654367267037A17F00", hash_generated_field = "8086EB07D920976B70D832288B336380")

    private Vector<Message> mMessageQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.785 -0400", hash_original_field = "F0D779550E246389EBE13C14C5F7FDB9", hash_generated_field = "E2600D589BA8423FB6859BA77F68989A")

    private boolean mIsMainPageLoader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.785 -0400", hash_original_field = "AF36715AAF25E2195BB18F3B33004164", hash_generated_field = "75023DD9A0A12C6512FD4F2D45866B50")

    private boolean mIsMainResourceLoader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.785 -0400", hash_original_field = "5E8195D2B1BFC9907987B84962F03AEB", hash_generated_field = "D928F63690A6A62BFF2AD4D16739AD6F")

    private boolean mUserGesture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.785 -0400", hash_original_field = "9DA6583E4F64A78649E80D72BFE1DBCC", hash_generated_field = "13C03042313948D47B6F87C772F0131E")

    private Headers mHeaders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.785 -0400", hash_original_field = "2FB3EB7CD104D0E14FE0487884A12591", hash_generated_field = "50564F75BBDED0F5A11BFE739FB8373A")

    private String mUsername;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.785 -0400", hash_original_field = "5C6B7EE711155A7472DA571800057A96", hash_generated_field = "44A1332F4D6AD461D600A43252892695")

    private String mPassword;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.785 -0400", hash_original_field = "4B9E95174875242C9A98A092137F2AE1", hash_generated_field = "DC46C8F8C9ECAF31EBEBF94599D29CFE")

    private int mCacheRedirectCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.787 -0400", hash_original_method = "63FB01D41A0193C36F7BC9C3E9D1276B", hash_generated_method = "B434F09CD029CFFFA3BD7ECD2C37104F")
      LoadListener(Context context, BrowserFrame frame, String url,
            int nativeLoader, boolean synchronous, boolean isMainPageLoader,
            boolean isMainResource, boolean userGesture, long postIdentifier,
            String username, String password) {
        mContext = context;
        mBrowserFrame = frame;
        setUrl(url);
        mNativeLoader = nativeLoader;
        mSynchronous = synchronous;
        {
            mMessageQueue = new Vector<Message>();
        } //End block
        mIsMainPageLoader = isMainPageLoader;
        mIsMainResourceLoader = isMainResource;
        mUserGesture = userGesture;
        mPostIdentifier = postIdentifier;
        mUsername = username;
        mPassword = password;
        addTaint(url.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.793 -0400", hash_original_method = "E8BFBC0989CB1303890EF6ABB82F2DCB", hash_generated_method = "1D30724615CFE0039A108856FCC50022")
    private void clearNativeLoader() {
        sNativeLoaderCount -= 1;
        mNativeLoader = 0;
        mSetNativeResponse = false;
        // ---------- Original Method ----------
        //sNativeLoaderCount -= 1;
        //mNativeLoader = 0;
        //mSetNativeResponse = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.806 -0400", hash_original_method = "77CD0D13F9C2AAAECAF2A5910AFEFD4A", hash_generated_method = "D311E87E7E386BC43E6FD5BD3FE463A9")
    public void handleMessage(Message msg) {
        //Begin case MSG_CONTENT_HEADERS 
        handleHeaders((Headers) msg.obj);
        //End case MSG_CONTENT_HEADERS 
        //Begin case MSG_CONTENT_DATA 
        {
            boolean varEBF14453EC3DF653682F6F49D18A0FCD_804521117 = (mNativeLoader != 0 && !ignoreCallbacks());
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
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.807 -0400", hash_original_method = "172B6AEABEB6A05CD87E0FF0F77BADEB", hash_generated_method = "2D3580F95B132108AF58AFB9F13558A4")
     BrowserFrame getFrame() {
        BrowserFrame varB4EAC82CA7396A68D541C85D26508E83_1242102799 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1242102799 = mBrowserFrame;
        varB4EAC82CA7396A68D541C85D26508E83_1242102799.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1242102799;
        // ---------- Original Method ----------
        //return mBrowserFrame;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.808 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "C99F6F1BD7A5F18137FC443B214B146D")
     Context getContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_746143287 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_746143287 = mContext;
        varB4EAC82CA7396A68D541C85D26508E83_746143287.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_746143287;
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.808 -0400", hash_original_method = "8DEF62308917FED7D5E9DE4FE979D5DE", hash_generated_method = "5DAD075CA7C180AE7B437E215B13585F")
     boolean isSynchronous() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_755504877 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_755504877;
        // ---------- Original Method ----------
        //return mSynchronous;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.820 -0400", hash_original_method = "E8044B5DC56667FC9DCFE8CB33E5852B", hash_generated_method = "FFE920ECD85A616A3442410323F36FAF")
    public boolean cancelled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_777778520 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_777778520;
        // ---------- Original Method ----------
        //return mCancelled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.821 -0400", hash_original_method = "454399D3A9345FFC357883E67C1190C2", hash_generated_method = "C4CD0D0340A3A25A70AA20705C19BBA8")
    public void headers(Headers headers) {
        ArrayList<String> cookies;
        cookies = headers.getSetCookie();
        {
            int i;
            i = 0;
            boolean varE9AF3BEAEA8CF5406F5AC5D6F9EE8F57_634882680 = (i < cookies.size());
            {
                CookieManager.getInstance().setCookie(mUri, cookies.get(i));
            } //End block
        } //End collapsed parenthetic
        sendMessageInternal(obtainMessage(MSG_CONTENT_HEADERS, headers));
        addTaint(headers.getTaint());
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) Log.v(LOGTAG, "LoadListener.headers");
        //if (mCancelled) return;
        //ArrayList<String> cookies = headers.getSetCookie();
        //for (int i = 0; i < cookies.size(); ++i) {
            //CookieManager.getInstance().setCookie(mUri, cookies.get(i));
        //}
        //sendMessageInternal(obtainMessage(MSG_CONTENT_HEADERS, headers));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.841 -0400", hash_original_method = "311EC7904C0F96CC61CCD61A611678E4", hash_generated_method = "3298A13DEF130B66E552DE829E618A34")
    private void handleHeaders(Headers headers) {
        {
            WebViewWorker.getHandler().obtainMessage(
                    WebViewWorker.MSG_REMOVE_CACHE, this).sendToTarget();
        } //End block
        mHeaders = headers;
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
            boolean var1FB790FEEC374B8E1CFBA64E5D64F4C6_1115375469 = (mIsMainPageLoader && mIsMainResourceLoader && mUserGesture &&
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
                    boolean var0CAA1F9BE373A668A403365FF0CE483B_618420567 = (info != null && !mContext.getPackageName().equals(
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
                boolean varCC683FE62B0EF80F8FFB7C83613687C9_1094966389 = (!mAuthFailed && mAuthHeader.isProxy());
                {
                    Network network;
                    network = Network.getInstance(mContext);
                    {
                        boolean varE7ECF7EC251273A020C9A5595F22451C_424552745 = (network.isValidProxySet());
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
                boolean var12B07FF95F64556F0F5629AF1ADEEDEA_1857752361 = (!mFromCache && mRequestHandle != null
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.847 -0400", hash_original_method = "700C126D7DD3A2A28FA66689BEC1C959", hash_generated_method = "3110D0DC203B589BCEF1A7D35101A450")
     boolean proxyAuthenticate() {
        {
            boolean varE5CAE2FBD59400ACCD83E492081A86C1_511273708 = (mAuthHeader.isProxy());
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_390015098 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_390015098;
        // ---------- Original Method ----------
        //if (mAuthHeader != null) {
            //return mAuthHeader.isProxy();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.848 -0400", hash_original_method = "DDF05333033BF6873CD233D3316FD8A3", hash_generated_method = "A6770B42EB824227B8C6EFAA5359C3D7")
    public void status(int majorVersion, int minorVersion,
            int code,  String reasonPhrase) {
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
        addTaint(majorVersion);
        addTaint(minorVersion);
        addTaint(code);
        addTaint(reasonPhrase.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.849 -0400", hash_original_method = "80BDEC9DD0BC19198E8FAA3CF681EF16", hash_generated_method = "92132462CD10CE442A0AE57AEC11FA6C")
    private void handleStatus(int major, int minor, int code, String reason) {
        mStatusCode = code;
        mStatusText = reason;
        mPermanent = false;
        addTaint(major);
        addTaint(minor);
        // ---------- Original Method ----------
        //if (mCancelled) return;
        //mStatusCode = code;
        //mStatusText = reason;
        //mPermanent = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.849 -0400", hash_original_method = "E4096ABF23EF8731F97354B434FC290A", hash_generated_method = "1FE0A9DB37368C3366448DF8108D0E1A")
    public void certificate(SslCertificate certificate) {
        sendMessageInternal(obtainMessage(MSG_SSL_CERTIFICATE, certificate));
        addTaint(certificate.getTaint());
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) {
            //Log.v(LOGTAG, "LoadListener.certificate: " + certificate);
        //}
        //sendMessageInternal(obtainMessage(MSG_SSL_CERTIFICATE, certificate));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.866 -0400", hash_original_method = "0FA338360DC1BF86862C5325E0DDE15B", hash_generated_method = "5A72371D15998E3081A501C76B63986F")
    private void handleCertificate(SslCertificate certificate) {
        {
            mBrowserFrame.certificate(certificate);
        } //End block
        addTaint(certificate.getTaint());
        // ---------- Original Method ----------
        //if (mIsMainPageLoader && mIsMainResourceLoader) {
            //mBrowserFrame.certificate(certificate);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.867 -0400", hash_original_method = "89A45FCA5400E7297D291CB9BD4FA531", hash_generated_method = "D3786D2B0F2EC8342100554EBF07FA2E")
    public void error(int id, String description) {
        sendMessageInternal(obtainMessage(MSG_CONTENT_ERROR, id, 0, description));
        addTaint(id);
        addTaint(description.getTaint());
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) {
            //Log.v(LOGTAG, "LoadListener.error url:" +
                    //url() + " id:" + id + " description:" + description);
        //}
        //sendMessageInternal(obtainMessage(MSG_CONTENT_ERROR, id, 0, description));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.867 -0400", hash_original_method = "FF98E8647B63FEBC8B925077CB2E6971", hash_generated_method = "BFAA29B7AE658444FE661E602E4F9A12")
    private void handleError(int id, String description) {
        mErrorID = id;
        mErrorDescription = description;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.868 -0400", hash_original_method = "842D88ADC63F459E21BBD6FC9BF11FA0", hash_generated_method = "1F7DE488839888DC3F5E4FA638A020D0")
    public void data(byte[] data, int length) {
        boolean sendMessage;
        sendMessage = false;
        {
            sendMessage = mDataBuilder.isEmpty();
            mDataBuilder.append(data, 0, length);
        } //End block
        {
            sendMessageInternal(obtainMessage(MSG_CONTENT_DATA));
        } //End block
        addTaint(data[0]);
        addTaint(length);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.868 -0400", hash_original_method = "57E1AB7C57BAD02879F9C8B9B633558A", hash_generated_method = "169AA40A4DB785BD992709004B47C00D")
    public void endData() {
        sendMessageInternal(obtainMessage(MSG_CONTENT_FINISHED));
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) {
            //Log.v(LOGTAG, "LoadListener.endData(): url: " + url());
        //}
        //sendMessageInternal(obtainMessage(MSG_CONTENT_FINISHED));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.869 -0400", hash_original_method = "CDF3DE93E351C5A11A75DE0E367F817E", hash_generated_method = "AC9F2E5FF56C47ED5AB7ABA6E24AE1C6")
    private void handleEndData() {
        //Begin case HTTP_MOVED_PERMANENTLY 
        mPermanent = true;
        //End case HTTP_MOVED_PERMANENTLY 
        //Begin case HTTP_FOUND HTTP_SEE_OTHER HTTP_TEMPORARY_REDIRECT 
        {
            {
                boolean varD068D29C86C3899A0A7365E7D8E5A606_1341572929 = (mRequestHandle != null && 
                                mRequestHandle.getMethod().equals("POST"));
                {
                    sendMessageInternal(obtainMessage(
                                MSG_LOCATION_CHANGED_REQUEST));
                } //End block
                {
                    boolean varD28941268B369EB362F84F893C633B30_535983030 = (mMethod != null && mMethod.equals("POST"));
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
            boolean var73D6F5715104F63F29F36A391760A31E_1932235383 = (mAuthHeader != null &&
                        (Network.getInstance(mContext).isValidProxySet() ||
                         !mAuthHeader.isProxy()));
            {
                {
                    String host;
                    boolean varDFD43C8D97D180F461A514E8A6A76A39_1836288231 = (mAuthHeader.isProxy());
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
                boolean var42C78101C5CD9E8ED377DC60807FD554_2005885153 = (isSynchronous());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.870 -0400", hash_original_method = "986192BD953D202BDF33831C4485C789", hash_generated_method = "47CBFFEFBA2BEBDF39A8136B3A86A818")
     void setCacheLoader(CacheLoader c) {
        mCacheLoader = c;
        mFromCache = true;
        // ---------- Original Method ----------
        //mCacheLoader = c;
        //mFromCache = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.885 -0400", hash_original_method = "0AD650AC52F38566687E74B5EF113675", hash_generated_method = "9673A2DF5671F9EA0F9FE568B60723CC")
     boolean checkCache(Map<String, String> headers) {
        CacheResult result;
        result = CacheManager.getCacheFile(url(), mPostIdentifier,
                headers);
        mCacheLoader = null;
        mFromCache = false;
        {
            mCacheLoader = new CacheLoader(this, result);
            {
                boolean varC6BCA4E5BDBD2D7A1E9322998F81BCBF_1102219053 = (!headers.containsKey(
                    CacheManager.HEADER_KEY_IFNONEMATCH) &&
                    !headers.containsKey(
                            CacheManager.HEADER_KEY_IFMODIFIEDSINCE));
                {
                    {
                        boolean varE43BEDB07085C405402D06A50570074B_1489680029 = (isSynchronous());
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
        addTaint(headers.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_842337828 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_842337828;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.893 -0400", hash_original_method = "DAC212856E10133D124E798AA1F9AF10", hash_generated_method = "8BC42C6D849CF697961D5B58021F8843")
    public boolean handleSslErrorRequest(SslError error) {
        {
            boolean var4D0341006E9A9633CEB75F8CF4C09DE3_106575116 = (Network.getInstance(mContext).checkSslPrefTable(this, error));
        } //End collapsed parenthetic
        {
            boolean var837A5D3B4D6C6B7A7C66720A25FA94F8_776395324 = (isSynchronous());
            {
                mRequestHandle.handleSslErrorResponse(false);
            } //End block
        } //End collapsed parenthetic
        sendMessageInternal(obtainMessage(MSG_SSL_ERROR, error));
        {
            mSslErrorRequestHandle = mRequestHandle;
        } //End block
        addTaint(error.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_261547106 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_261547106;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.894 -0400", hash_original_method = "8A34681F6BA1F3EEE132C403DE00B59E", hash_generated_method = "B29005D565C8401F61A0BA306735B0E3")
    private void handleSslError(SslError error) {
        {
            mSslError = error;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.899 -0400", hash_original_method = "273C3FB8F6276DB18167E6647E9B9071", hash_generated_method = "01B4C482DDE64B04AF13158DB64F5E45")
     String realm() {
        String varB4EAC82CA7396A68D541C85D26508E83_1621811391 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1180980753 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1621811391 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1180980753 = mAuthHeader.getRealm();
        } //End block
        String varA7E53CE21691AB073D9660D615818899_889026180; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_889026180 = varB4EAC82CA7396A68D541C85D26508E83_1621811391;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_889026180 = varB4EAC82CA7396A68D541C85D26508E83_1180980753;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_889026180.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_889026180;
        // ---------- Original Method ----------
        //if (mAuthHeader == null) {
            //return null;
        //} else {
            //return mAuthHeader.getRealm();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.918 -0400", hash_original_method = "B53822BFF4A674DE454739734B590814", hash_generated_method = "DC324FD0979CFEF9415B3DBA01D619C7")
     boolean authCredentialsInvalid() {
        boolean var3969C3B58B09A1ECDB164E540B11F523_348990837 = ((mAuthFailed &&
                !(mAuthHeader.isDigest() && mAuthHeader.getStale())));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_960346799 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_960346799;
        // ---------- Original Method ----------
        //return (mAuthFailed &&
                //!(mAuthHeader.isDigest() && mAuthHeader.getStale()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.921 -0400", hash_original_method = "D83DC2897E3C9B13E1B0E03447F2258A", hash_generated_method = "5B9B0B312100131E32702F2B82EE54DA")
     SslError sslError() {
        SslError varB4EAC82CA7396A68D541C85D26508E83_181974521 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_181974521 = mSslError;
        varB4EAC82CA7396A68D541C85D26508E83_181974521.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_181974521;
        // ---------- Original Method ----------
        //return mSslError;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.922 -0400", hash_original_method = "98A7269FE5209374A8ED24F438AC19C3", hash_generated_method = "2DA925C04A94A7E66D325CFB1CBE363E")
     void handleSslErrorResponse(boolean proceed) {
        {
            mRequestHandle.handleSslErrorResponse(proceed);
        } //End block
        {
            mBrowserFrame.stopLoading();
            tearDown();
        } //End block
        addTaint(proceed);
        // ---------- Original Method ----------
        //if (mRequestHandle != null) {
            //mRequestHandle.handleSslErrorResponse(proceed);
        //}
        //if (!proceed) {
            //mBrowserFrame.stopLoading();
            //tearDown();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.922 -0400", hash_original_method = "7E02E9AA12C4A958E94F9A413E55434A", hash_generated_method = "CB117F7EB32BBE6EF3D6A4D41FE257FE")
     void handleAuthResponse(String username, String password) {
        {
            makeAuthResponse(username, password);
        } //End block
        {
            commitLoad();
            tearDown();
        } //End block
        addTaint(username.getTaint());
        addTaint(password.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.926 -0400", hash_original_method = "D4EC792204E12F6CD4476F22DB2D7416", hash_generated_method = "F952027313CA32506A774AFA57FCEC74")
     void makeAuthResponse(String username, String password) {
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
        addTaint(username.getTaint());
        addTaint(password.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.938 -0400", hash_original_method = "0354530277F06C2F68A7F9A147112FDC", hash_generated_method = "B9828203D5B8AB72FF779428888DC616")
     void setRequestData(String method, Map<String, String> headers, 
            byte[] postData) {
        mMethod = method;
        mRequestHeaders = headers;
        mPostData = postData;
        // ---------- Original Method ----------
        //mMethod = method;
        //mRequestHeaders = headers;
        //mPostData = postData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.939 -0400", hash_original_method = "50C2A5A94CFD2B09208EC5050A570E5D", hash_generated_method = "D8CB0238CB55D32597D8C92394012F0F")
     String url() {
        String varB4EAC82CA7396A68D541C85D26508E83_1757204749 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1757204749 = mUrl;
        varB4EAC82CA7396A68D541C85D26508E83_1757204749.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1757204749;
        // ---------- Original Method ----------
        //return mUrl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.939 -0400", hash_original_method = "C2839DA6285DEBF5C5C20951F1E9FC61", hash_generated_method = "1D315E26610915112DB8F1E21A15692A")
     WebAddress getWebAddress() {
        WebAddress varB4EAC82CA7396A68D541C85D26508E83_1622517002 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1622517002 = mUri;
        varB4EAC82CA7396A68D541C85D26508E83_1622517002.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1622517002;
        // ---------- Original Method ----------
        //return mUri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.940 -0400", hash_original_method = "0451B8994B1846476A8FE8B0355ADDFF", hash_generated_method = "F5C4EB6B1BF576DDB86785D7F3F3FFCB")
     String host() {
        String varB4EAC82CA7396A68D541C85D26508E83_31378013 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_456534145 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_31378013 = mUri.getHost();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_456534145 = null;
        String varA7E53CE21691AB073D9660D615818899_1331611149; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1331611149 = varB4EAC82CA7396A68D541C85D26508E83_31378013;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1331611149 = varB4EAC82CA7396A68D541C85D26508E83_456534145;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1331611149.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1331611149;
        // ---------- Original Method ----------
        //if (mUri != null) {
            //return mUri.getHost();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.941 -0400", hash_original_method = "BC027B9D5395B8E20CC57CD534FC36DC", hash_generated_method = "0C93C8FBDD105EB55F1590EF3D2AF39C")
     String originalUrl() {
        String varB4EAC82CA7396A68D541C85D26508E83_1650044597 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1071440012 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1650044597 = mOriginalUrl;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1071440012 = mUrl;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_107509910; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_107509910 = varB4EAC82CA7396A68D541C85D26508E83_1650044597;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_107509910 = varB4EAC82CA7396A68D541C85D26508E83_1071440012;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_107509910.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_107509910;
        // ---------- Original Method ----------
        //if (mOriginalUrl != null) {
            //return mOriginalUrl;
        //} else {
            //return mUrl;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.961 -0400", hash_original_method = "1FD4A483F618FB6B6B2EA6F438798B25", hash_generated_method = "2FFEEC90FC19CE58AA985353378AE1F6")
     long postIdentifier() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_371659914 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_371659914;
        // ---------- Original Method ----------
        //return mPostIdentifier;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.961 -0400", hash_original_method = "555C5182696D3D1E5A8F07F29E226BC9", hash_generated_method = "B0A005E1C16B27D55998264EB3ED9582")
     void attachRequestHandle(RequestHandle requestHandle) {
        mRequestHandle = requestHandle;
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) {
            //Log.v(LOGTAG, "LoadListener.attachRequestHandle(): " +
                    //"requestHandle: " +  requestHandle);
        //}
        //mRequestHandle = requestHandle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.962 -0400", hash_original_method = "A03FA80E3F939CA589BDCCBFD92DE3E2", hash_generated_method = "BDF1A7E1FC3C2077A98A5A519EEA781B")
     void detachRequestHandle() {
        mRequestHandle = null;
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) {
            //Log.v(LOGTAG, "LoadListener.detachRequestHandle(): " +
                    //"requestHandle: " + mRequestHandle);
        //}
        //mRequestHandle = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.962 -0400", hash_original_method = "34F543213ABA35F3500E526ABE3EA0BF", hash_generated_method = "C51EE3EB880DEE2C6E9A9DFF6BE15A5F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.967 -0400", hash_original_method = "D1C1DC94D32429EE46F2E8034E6F3CAD", hash_generated_method = "E5BFBF4C61B75C3DF875FCDE0EEBC18D")
     void resetCancel() {
        mCancelled = false;
        // ---------- Original Method ----------
        //mCancelled = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.967 -0400", hash_original_method = "AB4E07CAED8783333F5D8E2EFE2FEA5A", hash_generated_method = "DF76EC32C541CF163C85A8557A6B3177")
     String mimeType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1167142065 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1167142065 = mMimeType;
        varB4EAC82CA7396A68D541C85D26508E83_1167142065.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1167142065;
        // ---------- Original Method ----------
        //return mMimeType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.968 -0400", hash_original_method = "EDB0721EF3A307F050BF15E668A80271", hash_generated_method = "1C15BF8F43FB9B25C11F8DE495240123")
     String transferEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1802948904 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1802948904 = mTransferEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1802948904.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1802948904;
        // ---------- Original Method ----------
        //return mTransferEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.968 -0400", hash_original_method = "A0A208846C45918947FC3EEE159224A3", hash_generated_method = "75EAC0256AC584A3CB61A6D6F1ACC45D")
     long contentLength() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1011223075 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1011223075;
        // ---------- Original Method ----------
        //return mContentLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.968 -0400", hash_original_method = "78D8A8AE22C18C73CE2907680A09633B", hash_generated_method = "D7B58E33D6B765DEEEE5CAFF2690F9E2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.969 -0400", hash_original_method = "8E8E66962C082FBF4981B6E1121BFDBD", hash_generated_method = "2BD0BEDDCF41AD2EBE5D37969B37791F")
    private void commitHeaders() {
        {
            boolean var9788089095FD8B842742F0D3B2475B66_1168233548 = (mIsMainPageLoader && CertTool.getCertType(mMimeType) != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.969 -0400", hash_original_method = "E28F47114E6BDDF9FD429A699C881F5C", hash_generated_method = "F40BDC9F30E4C4D1515A763F676892C4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.989 -0400", hash_original_method = "90DA669053E3EAB1E41208AD478B9563", hash_generated_method = "75C1CC5DE84601214A3B1081F033D962")
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
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.989 -0400", hash_original_method = "69E60F28B81345DBCE843A767C941042", hash_generated_method = "AF8D6CADD1F28EDEBD637D5D8F89D05F")
                public void header(String name, String value) {
                    nativeSetResponseHeader(nativeResponse, name, value);
                    addTaint(name.getTaint());
                    addTaint(value.getTaint());
                    // ---------- Original Method ----------
                    //nativeSetResponseHeader(nativeResponse, name, value);
                }
});
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_721847928 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_721847928;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.990 -0400", hash_original_method = "6C3510E057E7F86D9E5BFE641B751A6D", hash_generated_method = "224888B80B7C6536C97EB34D9071E956")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.991 -0400", hash_original_method = "622A6BD0A40561F44F0949C5CF1F5483", hash_generated_method = "8408CD880506B8E77BC48EBF2829EE15")
     void tearDown() {
        {
            boolean varAB9E8CB6A473BE0B33C57182B7F91870_1718828257 = (getErrorID() == OK);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.992 -0400", hash_original_method = "209FBE9F3E1C7384DEBC7D7B19E27A8A", hash_generated_method = "D442023802D610C12956891542EE7102")
    private int getErrorID() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2093844283 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2093844283;
        // ---------- Original Method ----------
        //return mErrorID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.007 -0400", hash_original_method = "D67F514368DCF056FAAB1F778CFC87BD", hash_generated_method = "02BB4DA472C3371687AA113E0540ED23")
    private String getErrorDescription() {
        String varB4EAC82CA7396A68D541C85D26508E83_1367852501 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1367852501 = mErrorDescription;
        varB4EAC82CA7396A68D541C85D26508E83_1367852501.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1367852501;
        // ---------- Original Method ----------
        //return mErrorDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.007 -0400", hash_original_method = "E680E4717FCBA329FAA87BAD42E56CAC", hash_generated_method = "C7261BAE34AAAD545B599297E0284F8E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.007 -0400", hash_original_method = "DFC23EFD31E5C4FF40E98CE1A64FD5ED", hash_generated_method = "F49939ADFF2C677E812D4F412736ABE3")
     void pauseLoad(boolean pause) {
        {
            mRequestHandle.pauseRequest(pause);
        } //End block
        addTaint(pause);
        // ---------- Original Method ----------
        //if (mRequestHandle != null) {
            //mRequestHandle.pauseRequest(pause);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.008 -0400", hash_original_method = "1181D36634AC97975F684A5C861366C7", hash_generated_method = "2D1A43E511ACBC3B72914B7AA57BF9A7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.018 -0400", hash_original_method = "A28FBC4A594C62B1FB221C43DC1C2583", hash_generated_method = "48D64F9F816BE16F2DC499C7AD3F412B")
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
                boolean var4BC74C0339FF0D282D6889513716AF46_158721576 = (!URLUtil.isNetworkUrl(redirectTo));
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
                boolean var9FABAD625F3CF927825C199D1CB19D00_2087686970 = (getErrorID() == OK);
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
                boolean var5B86DF6F22EC6A011A7E7F676EE6B6AB_1723683127 = (!checkCache(mRequestHeaders));
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
                            boolean var39F3D24FAA0DC03AD29BF73501987F25_495028477 = (!network.requestURL(mMethod, mRequestHeaders,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.039 -0400", hash_original_method = "F42460285C9091878E41158B4AED6A71", hash_generated_method = "825A9CDA779397C0F6B32D7609BEB424")
     void parseContentTypeHeader(String contentType) {
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
                    boolean var13B27D95A9632914626DBEBE651A12EF_1608818410 = (i < contentType.length() - 1);
                    {
                        mTransferEncoding =
                            contentType.substring(i + 1).trim().toLowerCase();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                mMimeType = contentType;
            } //End block
            mMimeType = mMimeType.trim();
            try 
            {
                Matcher m;
                m = CONTENT_TYPE_PATTERN.matcher(mMimeType);
                {
                    boolean var39BD3106C7A2329BC5A3364836FB2CF9_261632139 = (m.find());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.158 -0400", hash_original_method = "AE0FC74CC8A0BC926B5DCE69D72EC94D", hash_generated_method = "1E0F57068DA4AD1C946FF2E34F3E18E6")
    private HttpAuthHeader parseAuthHeader(String header) {
        HttpAuthHeader varB4EAC82CA7396A68D541C85D26508E83_606494790 = null; //Variable for return #1
        HttpAuthHeader varB4EAC82CA7396A68D541C85D26508E83_2017337813 = null; //Variable for return #2
        HttpAuthHeader varB4EAC82CA7396A68D541C85D26508E83_191744037 = null; //Variable for return #3
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
                            boolean varEED5FE80D284B29088CDC3B2020C18BA_878745233 = (header.charAt(i) == '\"');
                            {
                                quoted = !quoted;
                            } //End block
                            {
                                {
                                    {
                                        boolean varA6D900745186AB55FA6DC70E044D90E7_1098161889 = (header.regionMatches(true, i,
                                    HttpAuthHeader.BASIC_TOKEN, 0,
                                    HttpAuthHeader.BASIC_TOKEN.length()));
                                        {
                                            pos[posLen++] = i;
                                        } //End block
                                    } //End collapsed parenthetic
                                    {
                                        boolean var9BB96610CCDD0A2CA167EA62D5B1E782_1157301274 = (header.regionMatches(true, i,
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
                            boolean var0F7ADCB64C853D5C60254F8DA31AB71B_2001471013 = (header.regionMatches(true, pos[i],
                                HttpAuthHeader.DIGEST_TOKEN, 0,
                                HttpAuthHeader.DIGEST_TOKEN.length()));
                            {
                                String sub;
                                sub = header.substring(pos[i],
                                (i + 1 < posLen ? pos[i + 1] : headerLen));//DSFIXME:  CODE0008: Nested ternary operator in expression
                                HttpAuthHeader rval;
                                rval = new HttpAuthHeader(sub);
                                {
                                    boolean var049D67944127B174A09BA345E9C65282_704212339 = (rval.isSupportedScheme());
                                    {
                                        varB4EAC82CA7396A68D541C85D26508E83_606494790 = rval;
                                    } //End block
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
                            boolean var3C860FF7CD9160C8A47433614CAD0330_264096752 = (header.regionMatches(true, pos[i],
                                HttpAuthHeader.BASIC_TOKEN, 0,
                                HttpAuthHeader.BASIC_TOKEN.length()));
                            {
                                String sub;
                                sub = header.substring(pos[i],
                                (i + 1 < posLen ? pos[i + 1] : headerLen));//DSFIXME:  CODE0008: Nested ternary operator in expression
                                HttpAuthHeader rval;
                                rval = new HttpAuthHeader(sub);
                                {
                                    boolean var049D67944127B174A09BA345E9C65282_578701170 = (rval.isSupportedScheme());
                                    {
                                        varB4EAC82CA7396A68D541C85D26508E83_2017337813 = rval;
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_191744037 = null;
        addTaint(header.getTaint());
        HttpAuthHeader varA7E53CE21691AB073D9660D615818899_1212347410; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1212347410 = varB4EAC82CA7396A68D541C85D26508E83_606494790;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1212347410 = varB4EAC82CA7396A68D541C85D26508E83_2017337813;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1212347410 = varB4EAC82CA7396A68D541C85D26508E83_191744037;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1212347410.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1212347410;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.160 -0400", hash_original_method = "977413F84EEA9D9E0B7BBB5D674FC9E7", hash_generated_method = "C90617DD0EBF4E47E42459BB40B76A5B")
    private boolean ignoreCallbacks() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1103442126 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1103442126;
        // ---------- Original Method ----------
        //return (mCancelled || mAuthHeader != null ||
                //(mStatusCode > 300 && mStatusCode < 400 && mStatusCode != 305));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.160 -0400", hash_original_method = "B1CFB6FACF3C8464BDC576EEF15EE2EE", hash_generated_method = "873A9FCC20604B48C9D5FA7E8959BEB6")
     void setUrl(String url) {
        {
            mUri = null;
            {
                boolean varB7E6CB04F9FE3A0CBF3E091A2172F917_720501796 = (URLUtil.isNetworkUrl(url));
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
                {
                    mUrl = url;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.161 -0400", hash_original_method = "EF260C0902D2E84B94B185FE48F20D51", hash_generated_method = "B016B67622340CBCEB9E93C515D34AB2")
    private void guessMimeType() {
        {
            boolean varC2714C547A38705DE5583ECBFD766FDE_1597558322 = (URLUtil.isDataUrl(mUrl) && mMimeType.length() != 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.161 -0400", hash_original_method = "2EA3CE69FA8B837FDAA4CA6DE51D2499", hash_generated_method = "8F5908456156FCE52445B99497845D09")
    private String guessMimeTypeFromExtension(String url) {
        String varB4EAC82CA7396A68D541C85D26508E83_636496949 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_636496949 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(
                MimeTypeMap.getFileExtensionFromUrl(url));
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_636496949.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_636496949;
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) {
            //Log.v(LOGTAG, "guessMimeTypeFromExtension: url = " + url);
        //}
        //return MimeTypeMap.getSingleton().getMimeTypeFromExtension(
                //MimeTypeMap.getFileExtensionFromUrl(url));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.161 -0400", hash_original_method = "4C14C55105A23524352CD131708D205A", hash_generated_method = "D7092780BEA3316216BF3242167DD9D0")
    private void sendMessageInternal(Message msg) {
        {
            mMessageQueue.add(msg);
        } //End block
        {
            sendMessage(msg);
        } //End block
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //if (mSynchronous) {
            //mMessageQueue.add(msg);
        //} else {
            //sendMessage(msg);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.162 -0400", hash_original_method = "84B3C85DEED8CE51C1D689DF257AD721", hash_generated_method = "59730968657E585CD9A1F5F87DC416E6")
     void loadSynchronousMessages() {
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        } //End block
        {
            boolean var8F5875506F461E3D4FAABDB7CF8E2CD9_725415588 = (!mMessageQueue.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.162 -0400", hash_original_method = "4DA58223C4F20A38192632BBFEEE57C8", hash_generated_method = "7C3A181175F0ED9F1B6EE1ECCF5CE34A")
    private int nativeCreateResponse(String url, int statusCode,
            String statusText, String mimeType, long expectedLength,
            String encoding) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_735565707 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_735565707;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.162 -0400", hash_original_method = "BA6D20A53269A42AE8656C6EBDDFC70F", hash_generated_method = "2EE95CDE989B39A0D0DDF8BD2F00F5D0")
    private void nativeSetResponseHeader(int nativeResponse, String key,
            String val) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.162 -0400", hash_original_method = "41C6950B308582DB9C9A99E22648CC08", hash_generated_method = "4463E5BF89AC3DAA3138235FBCA35550")
    private void nativeReceivedResponse(int nativeResponse) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.163 -0400", hash_original_method = "CB7AF973B7AC5B91CFB8AF007E1C0D32", hash_generated_method = "2DC911843AB3EF8DD3A2BB1A5E9C90C7")
    private void nativeAddData(byte[] data, int length) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.163 -0400", hash_original_method = "49549DEACC297430F7E9805D3678A016", hash_generated_method = "F76CF5604F7D206ECF3936D4EC9118B8")
    private void nativeFinished() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.163 -0400", hash_original_method = "33F440D9D1697DCCED15CDDD044058A8", hash_generated_method = "29EA735C0797FDF2B21BDCB4EDCF36A9")
    private String nativeRedirectedToUrl(String baseUrl,
            String redirectTo, int nativeResponse) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.164 -0400", hash_original_method = "BCCFE0CFBD3782D8BEDE6CB5D0F9DEA3", hash_generated_method = "5B90DA7D769D000F23CD21F1BE24C0C0")
    private void nativeError(int id, String desc, String failingUrl) {
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.164 -0400", hash_original_field = "9722F24E24D81405093C0E61AAF58518", hash_generated_field = "E56CE2F3E60B73E43C117C0293F7827E")

    private static String LOGTAG = "webkit";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.164 -0400", hash_original_field = "509AF2834ADA401F28B3A49D3B705FD7", hash_generated_field = "5EBED6F7DA24EEDF876BBBD2FFF30567")

    private static int MSG_CONTENT_HEADERS = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.164 -0400", hash_original_field = "7355BAE53F9D568830324A8969C07267", hash_generated_field = "A2B5278CB9C376E771E1D231E9B9E50B")

    private static int MSG_CONTENT_DATA = 110;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.164 -0400", hash_original_field = "A2D250A3518B45A65154B96127A6F664", hash_generated_field = "31C927065895B61612595180937F720B")

    private static int MSG_CONTENT_FINISHED = 120;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.164 -0400", hash_original_field = "675853C8435F9866A52B73DF381042EF", hash_generated_field = "B224AF644BC4A39C2E4C8942B7D7BB87")

    private static int MSG_CONTENT_ERROR = 130;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.196 -0400", hash_original_field = "4CF18A1C721AB1F4A835A45350590E10", hash_generated_field = "B31BCFEE0CA9797EDA83B845AC054238")

    private static int MSG_LOCATION_CHANGED = 140;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.196 -0400", hash_original_field = "2481F0AA6F79937644E1A5A293AFBAC3", hash_generated_field = "E180F2532A91A856BCEEE658825D78B7")

    private static int MSG_LOCATION_CHANGED_REQUEST = 150;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.196 -0400", hash_original_field = "B7A45E8514F101F74E05513138B304C8", hash_generated_field = "763BB948D2F12931BD1648E691F52C0E")

    private static int MSG_STATUS = 160;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.196 -0400", hash_original_field = "15F7BB0E8BD2B4E568C46B6504FE8D7A", hash_generated_field = "3FE210DDA65F521C0653532872103E97")

    private static int MSG_SSL_CERTIFICATE = 170;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.196 -0400", hash_original_field = "608CB7C17A9F5C4E9F987C213FF631BA", hash_generated_field = "50E3605EBCCCB5D37DFF7095874E7678")

    private static int MSG_SSL_ERROR = 180;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.196 -0400", hash_original_field = "4800DC2FC1B39792E563783C8F6B5A15", hash_generated_field = "16FBC301B467E92AF52049BA419C55F8")

    private static int HTTP_OK = 200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.196 -0400", hash_original_field = "0760F8C3033E9095987F4D9935F2063D", hash_generated_field = "BF28498D2E1D4AB744DF38B3773AD898")

    private static int HTTP_PARTIAL_CONTENT = 206;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.196 -0400", hash_original_field = "0DF4FEB60449DF34F1AD9AA9936765DE", hash_generated_field = "9B947E4F6E3416302314223ECA54B8F1")

    private static int HTTP_MOVED_PERMANENTLY = 301;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.196 -0400", hash_original_field = "97B42AAB3CD04F3E73E4AE80BA351129", hash_generated_field = "1262489FE051FEFEEEB6B6A3842EFDD1")

    private static int HTTP_FOUND = 302;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.196 -0400", hash_original_field = "181D1EAE3C8C62D9A4E824819B863C2E", hash_generated_field = "0640D189FC95C7E8E2C02DF53E241E88")

    private static int HTTP_SEE_OTHER = 303;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.196 -0400", hash_original_field = "0FF390CB90ACDFA99B5AA910382219DE", hash_generated_field = "477996E9488F82A424D467F5D60E885C")

    private static int HTTP_NOT_MODIFIED = 304;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.196 -0400", hash_original_field = "9BEEF7C99885EE31AD26A587958D111A", hash_generated_field = "B38DC5DC32EC7E83AF0D4D33F14A0ECE")

    private static int HTTP_TEMPORARY_REDIRECT = 307;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.196 -0400", hash_original_field = "8E590EA7EB338033302726F6757CBE86", hash_generated_field = "B793C7086114FE8FC6B6C82C46075185")

    private static int HTTP_AUTH = 401;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.196 -0400", hash_original_field = "B970EF697AC248BDAD36A5826B50E965", hash_generated_field = "3902EFD6682EE97146BAFDB6CCCC536C")

    private static int HTTP_NOT_FOUND = 404;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.196 -0400", hash_original_field = "63AD218BFAC63DB6FD5C0ED2F32ADDA7", hash_generated_field = "B08AE5E2CDF7FDAEA668C4AB742830C9")

    private static int HTTP_PROXY_AUTH = 407;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.196 -0400", hash_original_field = "52191F22AFD6839461470104D6DB2030", hash_generated_field = "4FCBFD819BC0278295B9EC4188A35F2D")

    private static int sNativeLoaderCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.196 -0400", hash_original_field = "C18621DE80ED88424E67439E8D952773", hash_generated_field = "53FACACC4E1F114879CB27EE09A3EFBB")

    private static String XML_MIME_TYPE = "^[\\w_\\-+~!$\\^{}|.%'`#&*]+/" +
            "[\\w_\\-+~!$\\^{}|.%'`#&*]+\\+xml$";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.196 -0400", hash_original_field = "459CF722BCB9467407E6E09F9891AF1C", hash_generated_field = "34729962A912C86FF457D2F378B3AC20")

    private static Pattern CONTENT_TYPE_PATTERN = Pattern.compile("^((?:[xX]-)?[a-zA-Z\\*]+/[\\w\\+\\*-]+[\\.[\\w\\+-]+]*)$");
}

