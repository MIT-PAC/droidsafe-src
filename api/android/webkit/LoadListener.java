package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

import com.android.internal.R;






class LoadListener extends Handler implements EventHandler {

    // =========================================================================
    // Public functions
    // =========================================================================

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.373 -0500", hash_original_method = "DE7E62620DF1D4DDCBECDEA48A032445", hash_generated_method = "1D2FE8097BFC0AADE5C7BC7327327DB7")
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.374 -0500", hash_original_method = "26BCC5D87204162241963F5EC1FB15BE", hash_generated_method = "63B4F200CD121BE71F143FF3B1C63B0D")
    public static int getNativeLoaderCount() {
        return sNativeLoaderCount;
    }
    
    /*
     * This function is called from native WebCore code to
     * find out if the given URL is in the cache, and if it can
     * be used. This is just for forward/back navigation to a POST
     * URL.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.409 -0500", hash_original_method = "595F3DC654AB4311FF581E0939656C44", hash_generated_method = "7D6FAB9E8F5DDBBF80A469620DC91B5A")
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.326 -0500", hash_original_field = "CF5103981B618784F76950E4558FDBCC", hash_generated_field = "061362C112C980EB4954480FBAFBE378")


    private static final String LOGTAG = "webkit";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:00.502 -0500", hash_original_field = "08B330D8984AEA5C2068F02AF7C93279", hash_generated_field = "9CD704C2905354C49BB21D67E3584C22")

    // Network thread and the WebCore thread.
    private static final int MSG_CONTENT_HEADERS = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.328 -0500", hash_original_field = "169DF2AAD3389412824801B0E0C2DE50", hash_generated_field = "DAA6BB961A1AB150C7D4C79F2F45075C")

    private static final int MSG_CONTENT_DATA = 110;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.329 -0500", hash_original_field = "3A30292C960E2C7AA40DE6FA77692890", hash_generated_field = "821C83A5F10056724A1264EDF4B243C7")

    private static final int MSG_CONTENT_FINISHED = 120;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.330 -0500", hash_original_field = "71BF18CBF983AFE22A325364299A9EAE", hash_generated_field = "B2A41EFD129FF10B9F368F8C3B6CABAB")

    private static final int MSG_CONTENT_ERROR = 130;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.330 -0500", hash_original_field = "3A1A66A981DBD7AA1CF404A7350BB1A4", hash_generated_field = "DEE25F2AAC38E6182B595E5F1A7B9DF8")

    private static final int MSG_LOCATION_CHANGED = 140;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.331 -0500", hash_original_field = "AE9BE97D8CA84E3EB9DB6BB9E4383BC8", hash_generated_field = "66AC92B296B18CD4FFA79CCBEBEFDEDC")

    private static final int MSG_LOCATION_CHANGED_REQUEST = 150;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.332 -0500", hash_original_field = "CDEF5339A81C497B39E882A24AAB07BE", hash_generated_field = "8CE8B590CBF427BDEBAF776EA07B635E")

    private static final int MSG_STATUS = 160;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.333 -0500", hash_original_field = "0081BE85B08CB21D4CD4BB457AD3AE6F", hash_generated_field = "77AEDD03EFF9D007A9FF71685ED9B603")

    private static final int MSG_SSL_CERTIFICATE = 170;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.334 -0500", hash_original_field = "66B052273324AA4A6466F7FBCFC9A3F7", hash_generated_field = "4A5C4BFACAE94926B45870B18FFAEC2B")

    private static final int MSG_SSL_ERROR = 180;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.335 -0500", hash_original_field = "4F08975A84D01CE999CC4E4860225587", hash_generated_field = "C8D2666C9BA638414EEC6A741AFCFBE7")

    private static final int HTTP_OK = 200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.336 -0500", hash_original_field = "DA2BBF9FCCBDE049DA6B4ECDBEC2E9B6", hash_generated_field = "D8436253A0E1590995389DEF643C7AC4")

    private static final int HTTP_PARTIAL_CONTENT = 206;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.337 -0500", hash_original_field = "5FF417C1FE8E5314DA63487A86BD1004", hash_generated_field = "A21DD64CACF18DF6C575E72962C46F9E")

    private static final int HTTP_MOVED_PERMANENTLY = 301;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.338 -0500", hash_original_field = "E51A648E8ED9A512F838B38FCF6E5EFB", hash_generated_field = "F16818D73EBE4718633BC72A35C64865")

    private static final int HTTP_FOUND = 302;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.339 -0500", hash_original_field = "F587D14A71911E85060DCB94495BE5D3", hash_generated_field = "949A18F982649D59B83F6E75D3E98A68")

    private static final int HTTP_SEE_OTHER = 303;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.339 -0500", hash_original_field = "D867F77B71B4007457FAD26BE01C5B60", hash_generated_field = "DBCD47929E85185D8F234889685C9320")

    private static final int HTTP_NOT_MODIFIED = 304;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.340 -0500", hash_original_field = "99EFA4455E722F4F8F5B4CCC35370B18", hash_generated_field = "A37E4C811DC81991FD4504CDD85F4F53")

    private static final int HTTP_TEMPORARY_REDIRECT = 307;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.341 -0500", hash_original_field = "389C14F89211D00D2AD6C88CA6912ABB", hash_generated_field = "19163CCE00330334DC887A0C1853E241")

    private static final int HTTP_AUTH = 401;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.342 -0500", hash_original_field = "5F76983B14F0A279991E635441241C96", hash_generated_field = "0E33C348AEF88770DA8DCD09874C3305")

    private static final int HTTP_NOT_FOUND = 404;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.343 -0500", hash_original_field = "B9011F9284B3F5802812F31765400BAF", hash_generated_field = "6F18BE030B574644F542FCCDBD4B8DCE")

    private static final int HTTP_PROXY_AUTH = 407;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.343 -0500", hash_original_field = "E95E87D426A369968FA91632300F68CC", hash_generated_field = "4FCBFD819BC0278295B9EC4188A35F2D")


    private static int sNativeLoaderCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:00.557 -0500", hash_original_field = "695F79085D231E71A09611258D7CB118", hash_generated_field = "96DF5A9DA7B80BE97B79159472842F9A")

    // content. Use this to check if another Activity wants to handle the
    // content before giving it to webkit.
    private static final String XML_MIME_TYPE =
            "^[\\w_\\-+~!$\\^{}|.%'`#&*]+/" +
            "[\\w_\\-+~!$\\^{}|.%'`#&*]+\\+xml$";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.426 -0500", hash_original_field = "C7E6551769EA1884399CBCCDB7E4ACB2", hash_generated_field = "9A0633094294E861E914F60D234070F3")

    private static final Pattern CONTENT_TYPE_PATTERN =
            Pattern.compile("^((?:[xX]-)?[a-zA-Z\\*]+/[\\w\\+\\*-]+[\\.[\\w\\+-]+]*)$");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.344 -0500", hash_original_field = "E6EE4FF0DEA62AEFAFF3DBB439BA6E92", hash_generated_field = "C2ADEC4B7675869DD34EF84CA5DC8ADA")


    private final ByteArrayBuilder mDataBuilder = new ByteArrayBuilder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.345 -0500", hash_original_field = "CA88DB4A75B79130313A74537195706C", hash_generated_field = "9C2E85EC79E8F8349BF2E81BA4AC7991")


    private String   mUrl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.345 -0500", hash_original_field = "DB3D2BD1CF0785D6513DCE03F6FD6846", hash_generated_field = "93793E19832E1B2CEA9B3AE18495201F")

    private WebAddress mUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.346 -0500", hash_original_field = "A845E1869945995F98D02B200494ABF7", hash_generated_field = "632697020547475B21783FF9A242BA30")

    private boolean  mPermanent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.347 -0500", hash_original_field = "9D579EBEEA247F7CBFFCE18F65EEE6DC", hash_generated_field = "568234C9B8DA241BFA5B09B8101F8B12")

    private String   mOriginalUrl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.348 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context  mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.348 -0500", hash_original_field = "3FC88C05AF84F1DA5801895C1A5E2AA9", hash_generated_field = "076F5BF2A47D119E2704BFAF413B4749")

    private BrowserFrame mBrowserFrame;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.349 -0500", hash_original_field = "3D3531CE82E6ADA74D0DBD5EAC347C35", hash_generated_field = "CFE8D432F2D30F6D44FDB0D4F89E9956")

    private int      mNativeLoader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.350 -0500", hash_original_field = "B161F982909610C03B68BAACDD54E076", hash_generated_field = "D6D2783B71AE4BF9CBF84D44336E2BF9")

    private String   mMimeType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.351 -0500", hash_original_field = "532663CB004FA57020360003BD60B6E5", hash_generated_field = "98F3D6B51351657C10385D44B0C0054D")

    private String   mEncoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.352 -0500", hash_original_field = "5CE6CF745CE48449CC47937C01C409DF", hash_generated_field = "5B5A898734AC0BC3BD56BC7A1B09A1AA")

    private String   mTransferEncoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.353 -0500", hash_original_field = "FDFA4F4264773014D5F97717B076C5CB", hash_generated_field = "A03B65E05BCBAEC5D04E36F3DA55AA89")

    private int      mStatusCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.354 -0500", hash_original_field = "7BCF9A33111B9B599CB88F8AE6D1C063", hash_generated_field = "8308E02599DA7B9492281855AF586F6A")

    private String   mStatusText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.354 -0500", hash_original_field = "43FA6B89410ACDDFB4B89F954A0B5BF7", hash_generated_field = "1ACBF6AD05D624BD330C1EA27911AFED")

    public long mContentLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.355 -0500", hash_original_field = "CCCB3FDCAF75EA369C4CD3D5C8686C3D", hash_generated_field = "582F041564D3B399F48E8AE230C16FEE")

    private boolean  mCancelled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.356 -0500", hash_original_field = "D67798EC3F5CF01B23F5326ABDE48583", hash_generated_field = "11E3D87CDBCDF8F27F5BCF75E88255E5")

    private boolean  mAuthFailed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.357 -0500", hash_original_field = "F8DB1E5AE7F7FE96A623685E2819F07E", hash_generated_field = "7D2D2225EC07E109A425BA1C9069B594")

    private CacheLoader mCacheLoader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.357 -0500", hash_original_field = "F804B1A7FA5DE964D222A17E805C1861", hash_generated_field = "7BD10F8B23449D67AF64947251567443")

    private boolean  mFromCache = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.358 -0500", hash_original_field = "5340D8EBF2FF30D604E8FF2953C1F70A", hash_generated_field = "F92F68007E24C2007F5E8613B464C2BA")

    private HttpAuthHeader mAuthHeader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.359 -0500", hash_original_field = "15C260B09BDA0360E20A20E431FED53F", hash_generated_field = "CFF6FAF13B4D5230E9FF26C0A80758BB")

    private int      mErrorID = OK;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.360 -0500", hash_original_field = "DCD032B7AA6F69B622B4437C7D3AD3FF", hash_generated_field = "9A2F4E95853CE87C657553938570C697")

    private String   mErrorDescription;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.360 -0500", hash_original_field = "43C8FE43BDB3A02F7F1B52FFB7F33377", hash_generated_field = "260FF327C4645479FF5E5DCF19E349AD")

    private SslError mSslError;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.361 -0500", hash_original_field = "60897D6FF6EC53AEFD2E3CA0FC46E4F5", hash_generated_field = "D2C086119AFB2A8257E7CAD619AFA47F")

    private RequestHandle mRequestHandle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.362 -0500", hash_original_field = "E33E2562317D9750627598A93C3D28D3", hash_generated_field = "1D3366ACEEB83C50B8FD0D2EE0AAAE40")

    private RequestHandle mSslErrorRequestHandle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.363 -0500", hash_original_field = "76F780345902BF5C7D2AE1B1DB07EDB1", hash_generated_field = "B0E361E4F3B0293B8C4D8932D9873B39")

    private long     mPostIdentifier;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.364 -0500", hash_original_field = "8581055CF35432109973ABCC2E8F9F9F", hash_generated_field = "E5EA8984DD22A9073BFFEAE2B245DF81")

    private boolean  mSetNativeResponse;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:00.539 -0500", hash_original_field = "FB63EE61CA76D9C9913EC87AD6B942C6", hash_generated_field = "65083C345C65A635FE4EBE2BF1D8A8B6")

    // cache. It is needed if the cache returns a redirect
    private String mMethod;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.365 -0500", hash_original_field = "D395DE2619F6F83352093A0D51018CFF", hash_generated_field = "223EBD1E69C1299B02B1F1776461294B")

    private Map<String, String> mRequestHeaders;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.366 -0500", hash_original_field = "2D2347367D31A512EEC0E8D215ED2DBD", hash_generated_field = "C5200C1F2575A09491B18B8CE6E6A375")

    private byte[] mPostData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.367 -0500", hash_original_field = "B47D38F4AE9172691A5D2E7145F22FD3", hash_generated_field = "FB6DD9E423DD8E3B65713D050C1DF4CF")

    private boolean mSynchronous;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.367 -0500", hash_original_field = "07E1912DAE5C99E72BC3A4BE8EE55452", hash_generated_field = "8086EB07D920976B70D832288B336380")

    private Vector<Message> mMessageQueue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.368 -0500", hash_original_field = "CE89EC25A7C3852DD74197786788727C", hash_generated_field = "E2600D589BA8423FB6859BA77F68989A")

    private boolean mIsMainPageLoader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.369 -0500", hash_original_field = "DB0A234A69FB1C5CEBC87A0D572919C9", hash_generated_field = "75023DD9A0A12C6512FD4F2D45866B50")

    private  boolean mIsMainResourceLoader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.370 -0500", hash_original_field = "DD2C833C7B1ED488C0C6F717E5A5C944", hash_generated_field = "D928F63690A6A62BFF2AD4D16739AD6F")

    private  boolean mUserGesture;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.371 -0500", hash_original_field = "9035AF409A03B14F6004C0202B58C473", hash_generated_field = "13C03042313948D47B6F87C772F0131E")


    private Headers mHeaders;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.371 -0500", hash_original_field = "F6C0B2A92BAD484AE3E9DE7409D6C7A8", hash_generated_field = "50564F75BBDED0F5A11BFE739FB8373A")


    private  String mUsername;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.372 -0500", hash_original_field = "6E680D0312272F1C50F2E99ACBEA882B", hash_generated_field = "44A1332F4D6AD461D600A43252892695")

    private  String mPassword;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:00.599 -0500", hash_original_field = "E22F5E57AE40227B829EF52079762AE8", hash_generated_field = "54744D88023FDBB07FA1DB3C2D3F77B0")

    // loading from the cache so that we can detect redirect loops that switch
    // between the network and the cache.
    private int mCacheRedirectCount;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.375 -0500", hash_original_method = "63FB01D41A0193C36F7BC9C3E9D1276B", hash_generated_method = "63FB01D41A0193C36F7BC9C3E9D1276B")
    LoadListener(Context context, BrowserFrame frame, String url,
            int nativeLoader, boolean synchronous, boolean isMainPageLoader,
            boolean isMainResource, boolean userGesture, long postIdentifier,
            String username, String password) {
        assert !JniUtil.useChromiumHttpStack();

        if (DebugFlags.LOAD_LISTENER) {
            Log.v(LOGTAG, "LoadListener constructor url=" + url);
        }
        mContext = context;
        mBrowserFrame = frame;
        setUrl(url);
        mNativeLoader = nativeLoader;
        mSynchronous = synchronous;
        if (synchronous) {
            mMessageQueue = new Vector<Message>();
        }
        mIsMainPageLoader = isMainPageLoader;
        mIsMainResourceLoader = isMainResource;
        mUserGesture = userGesture;
        mPostIdentifier = postIdentifier;
        mUsername = username;
        mPassword = password;
    }

    /**
     * We keep a count of refs to the nativeLoader so we do not create
     * so many LoadListeners that the GREFs blow up
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.376 -0500", hash_original_method = "E8BFBC0989CB1303890EF6ABB82F2DCB", hash_generated_method = "1D544F275B4EBCF75E4514D548A5000B")
    private void clearNativeLoader() {
        sNativeLoaderCount -= 1;
        mNativeLoader = 0;
        mSetNativeResponse = false;
    }

    /*
     * This message handler is to facilitate communication between the network
     * thread and the browser thread.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.377 -0500", hash_original_method = "77CD0D13F9C2AAAECAF2A5910AFEFD4A", hash_generated_method = "69FEF8C0BD4FCFEF0E7C42376084BC62")
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case MSG_CONTENT_HEADERS:
                /*
                 * This message is sent when the LoadListener has headers
                 * available. The headers are sent onto WebCore to see what we
                 * should do with them.
                 */
                handleHeaders((Headers) msg.obj);
                break;

            case MSG_CONTENT_DATA:
                /*
                 * This message is sent when the LoadListener has data available
                 * in it's data buffer. This data buffer could be filled from a
                 * file (this thread) or from http (Network thread).
                 */
                if (mNativeLoader != 0 && !ignoreCallbacks()) {
                    commitLoad();
                }
                break;

            case MSG_CONTENT_FINISHED:
                /*
                 * This message is sent when the LoadListener knows that the
                 * load is finished. This message is not sent in the case of an
                 * error.
                 *
                 */
                handleEndData();
                break;

            case MSG_CONTENT_ERROR:
                /*
                 * This message is sent when a load error has occured. The
                 * LoadListener will clean itself up.
                 */
                handleError(msg.arg1, (String) msg.obj);
                break;

            case MSG_LOCATION_CHANGED:
                /*
                 * This message is sent from LoadListener.endData to inform the
                 * browser activity that the location of the top level page
                 * changed.
                 */
                doRedirect();
                break;

            case MSG_LOCATION_CHANGED_REQUEST:
                /*
                 * This message is sent from endData on receipt of a 307
                 * Temporary Redirect in response to a POST -- the user must
                 * confirm whether to continue loading. If the user says Yes,
                 * we simply call MSG_LOCATION_CHANGED. If the user says No,
                 * we call MSG_CONTENT_FINISHED.
                 */
                Message contMsg = obtainMessage(MSG_LOCATION_CHANGED);
                Message stopMsg = obtainMessage(MSG_CONTENT_FINISHED);
                mBrowserFrame.getCallbackProxy().onFormResubmission(
                        stopMsg, contMsg);
                break;

            case MSG_STATUS:
                /*
                 * This message is sent from the network thread when the http
                 * stack has received the status response from the server.
                 */
                HashMap status = (HashMap) msg.obj;
                handleStatus(((Integer) status.get("major")).intValue(),
                        ((Integer) status.get("minor")).intValue(),
                        ((Integer) status.get("code")).intValue(),
                        (String) status.get("reason"));
                break;

            case MSG_SSL_CERTIFICATE:
                /*
                 * This message is sent when the network thread receives a ssl
                 * certificate.
                 */
                handleCertificate((SslCertificate) msg.obj);
                break;

            case MSG_SSL_ERROR:
                /*
                 * This message is sent when the network thread encounters a
                 * ssl error.
                 */
                handleSslError((SslError) msg.obj);
                break;
        }
    }

    /**
     * @return The loader's BrowserFrame.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.378 -0500", hash_original_method = "172B6AEABEB6A05CD87E0FF0F77BADEB", hash_generated_method = "172B6AEABEB6A05CD87E0FF0F77BADEB")
    BrowserFrame getFrame() {
        return mBrowserFrame;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.379 -0500", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "4F4EBC54D108D66F416C93B46580E117")
    Context getContext() {
        return mContext;
    }

    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.379 -0500", hash_original_method = "8DEF62308917FED7D5E9DE4FE979D5DE", hash_generated_method = "8DEF62308917FED7D5E9DE4FE979D5DE")
    boolean isSynchronous() {
        return mSynchronous;
    }

    /**
     * @return True iff the load has been cancelled
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.380 -0500", hash_original_method = "E8044B5DC56667FC9DCFE8CB33E5852B", hash_generated_method = "A3E96A98D38C5329B51D4A8618D32255")
    public boolean cancelled() {
        return mCancelled;
    }

    /**
     * Parse the headers sent from the server.
     * @param headers gives up the HeaderGroup
     * IMPORTANT: as this is called from network thread, can't call native
     * directly
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.381 -0500", hash_original_method = "454399D3A9345FFC357883E67C1190C2", hash_generated_method = "34FCB14B87FB5B3F78BB9BE9C7C550CA")
    public void headers(Headers headers) {
        if (DebugFlags.LOAD_LISTENER) Log.v(LOGTAG, "LoadListener.headers");
        // call db (setCookie) in the non-WebCore thread
        if (mCancelled) return;
        ArrayList<String> cookies = headers.getSetCookie();
        for (int i = 0; i < cookies.size(); ++i) {
            CookieManager.getInstance().setCookie(mUri, cookies.get(i));
        }
        sendMessageInternal(obtainMessage(MSG_CONTENT_HEADERS, headers));
    }

    // Does the header parsing work on the WebCore thread.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.384 -0500", hash_original_method = "311EC7904C0F96CC61CCD61A611678E4", hash_generated_method = "4978B88FAA58855B70B0EEC56D0FA3E6")
    private void handleHeaders(Headers headers) {
        if (mCancelled) return;

        // Note: the headers we care in LoadListeners, like
        // content-type/content-length, should not be updated for partial
        // content. Just skip here and go ahead with adding data.
        if (mStatusCode == HTTP_PARTIAL_CONTENT) {
            // we don't support cache for partial content yet
            WebViewWorker.getHandler().obtainMessage(
                    WebViewWorker.MSG_REMOVE_CACHE, this).sendToTarget();
            return;
        }

        mHeaders = headers;

        long contentLength = headers.getContentLength();
        if (contentLength != Headers.NO_CONTENT_LENGTH) {
            mContentLength = contentLength;
        } else {
            mContentLength = 0;
        }

        String contentType = headers.getContentType();
        if (contentType != null) {
            parseContentTypeHeader(contentType);
            mMimeType = MimeTypeMap.getSingleton().remapGenericMimeType(
                    mMimeType, mUrl, headers.getContentDisposition());
        } else {
            /* Often when servers respond with 304 Not Modified or a
               Redirect, then they don't specify a MIMEType. When this
               occurs, the function below is called.  In the case of
               304 Not Modified, the cached headers are used rather
               than the headers that are returned from the server. */
            guessMimeType();
        }
        // At this point, mMimeType has been set to non-null.
        if (mIsMainPageLoader && mIsMainResourceLoader && mUserGesture &&
                Pattern.matches(XML_MIME_TYPE, mMimeType) &&
                !mMimeType.equalsIgnoreCase("application/xhtml+xml")) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setDataAndType(Uri.parse(url()), mMimeType);
            ResolveInfo info = mContext.getPackageManager().resolveActivity(i,
                    PackageManager.MATCH_DEFAULT_ONLY);
            if (info != null && !mContext.getPackageName().equals(
                    info.activityInfo.packageName)) {
                // someone (other than the current app) knows how to
                // handle this mime type.
                try {
                    mContext.startActivity(i);
                    mBrowserFrame.stopLoading();
                    return;
                } catch (ActivityNotFoundException ex) {
                    // continue loading internally.
                }
            }
        }

        // is it an authentication request?
        boolean mustAuthenticate = (mStatusCode == HTTP_AUTH ||
                mStatusCode == HTTP_PROXY_AUTH);
        // is it a proxy authentication request?
        boolean isProxyAuthRequest = (mStatusCode == HTTP_PROXY_AUTH);
        // is this authentication request due to a failed attempt to
        // authenticate ealier?
        mAuthFailed = false;

        // if we tried to authenticate ourselves last time
        if (mAuthHeader != null) {
            // we failed, if we must authenticate again now and
            // we have a proxy-ness match
            mAuthFailed = (mustAuthenticate &&
                    isProxyAuthRequest == mAuthHeader.isProxy());

            // if we did NOT fail and last authentication request was a
            // proxy-authentication request
            if (!mAuthFailed && mAuthHeader.isProxy()) {
                Network network = Network.getInstance(mContext);
                // if we have a valid proxy set
                if (network.isValidProxySet()) {
                    /* The proxy credentials can be read in the WebCore thread
                    */
                    synchronized (network) {
                        // save authentication credentials for pre-emptive proxy
                        // authentication
                        network.setProxyUsername(mAuthHeader.getUsername());
                        network.setProxyPassword(mAuthHeader.getPassword());
                    }
                }
            }
        }

        // it is only here that we can reset the last mAuthHeader object
        // (if existed) and start a new one!!!
        mAuthHeader = null;
        if (mustAuthenticate) {
            if (mStatusCode == HTTP_AUTH) {
                mAuthHeader = parseAuthHeader(
                        headers.getWwwAuthenticate());
            } else {
                mAuthHeader = parseAuthHeader(
                        headers.getProxyAuthenticate());
                // if successfully parsed the header
                if (mAuthHeader != null) {
                    // mark the auth-header object as a proxy
                    mAuthHeader.setProxy();
                }
            }
        }

        // Only create a cache file if the server has responded positively.
        if ((mStatusCode == HTTP_OK ||
                mStatusCode == HTTP_FOUND ||
                mStatusCode == HTTP_MOVED_PERMANENTLY ||
                mStatusCode == HTTP_TEMPORARY_REDIRECT) && 
                mNativeLoader != 0) {
            // for POST request, only cache the result if there is an identifier
            // associated with it. postUrl() or form submission should set the
            // identifier while XHR POST doesn't.
            if (!mFromCache && mRequestHandle != null
                    && (!mRequestHandle.getMethod().equals("POST")
                            || mPostIdentifier != 0)) {
                WebViewWorker.CacheCreateData data = new WebViewWorker.CacheCreateData();
                data.mListener = this;
                data.mUrl = mUrl;
                data.mMimeType = mMimeType;
                data.mStatusCode = mStatusCode;
                data.mPostId = mPostIdentifier;
                data.mHeaders = headers;
                WebViewWorker.getHandler().obtainMessage(
                        WebViewWorker.MSG_CREATE_CACHE, data).sendToTarget();
            }
            WebViewWorker.CacheEncoding ce = new WebViewWorker.CacheEncoding();
            ce.mEncoding = mEncoding;
            ce.mListener = this;
            WebViewWorker.getHandler().obtainMessage(
                    WebViewWorker.MSG_UPDATE_CACHE_ENCODING, ce).sendToTarget();
        }
        commitHeadersCheckRedirect();
    }

    /**
     * @return True iff this loader is in the proxy-authenticate state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.385 -0500", hash_original_method = "700C126D7DD3A2A28FA66689BEC1C959", hash_generated_method = "700C126D7DD3A2A28FA66689BEC1C959")
    boolean proxyAuthenticate() {
        if (mAuthHeader != null) {
            return mAuthHeader.isProxy();
        }

        return false;
    }

    /**
     * Report the status of the response.
     * TODO: Comments about each parameter.
     * IMPORTANT: as this is called from network thread, can't call native
     * directly
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.385 -0500", hash_original_method = "DDF05333033BF6873CD233D3316FD8A3", hash_generated_method = "73AECAACAB3642727AC8C508F30B1597")
    public void status(int majorVersion, int minorVersion,
            int code, /* Status-Code value */ String reasonPhrase) {
        if (DebugFlags.LOAD_LISTENER) {
            Log.v(LOGTAG, "LoadListener: from: " + mUrl
                    + " major: " + majorVersion
                    + " minor: " + minorVersion
                    + " code: " + code
                    + " reason: " + reasonPhrase);
        }
        HashMap status = new HashMap();
        status.put("major", majorVersion);
        status.put("minor", minorVersion);
        status.put("code", code);
        status.put("reason", reasonPhrase);
        // New status means new data. Clear the old.
        mDataBuilder.clear();
        mMimeType = "";
        mEncoding = "";
        mTransferEncoding = "";
        sendMessageInternal(obtainMessage(MSG_STATUS, status));
    }

    // Handle the status callback on the WebCore thread.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.386 -0500", hash_original_method = "80BDEC9DD0BC19198E8FAA3CF681EF16", hash_generated_method = "E955BBF80A42B251F8968169994AE628")
    private void handleStatus(int major, int minor, int code, String reason) {
        if (mCancelled) return;

        mStatusCode = code;
        mStatusText = reason;
        mPermanent = false;
    }

    /**
     * Implementation of certificate handler for EventHandler. Called
     * before a resource is requested. In this context, can be called
     * multiple times if we have redirects
     *
     * IMPORTANT: as this is called from network thread, can't call
     * native directly
     *
     * @param certificate The SSL certifcate or null if the request
     * was not secure
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.387 -0500", hash_original_method = "E4096ABF23EF8731F97354B434FC290A", hash_generated_method = "C3BB9F7E230940EFAA1C5C9B299BE664")
    public void certificate(SslCertificate certificate) {
        if (DebugFlags.LOAD_LISTENER) {
            Log.v(LOGTAG, "LoadListener.certificate: " + certificate);
        }
        sendMessageInternal(obtainMessage(MSG_SSL_CERTIFICATE, certificate));
    }

    // Handle the certificate on the WebCore thread.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.388 -0500", hash_original_method = "0FA338360DC1BF86862C5325E0DDE15B", hash_generated_method = "43F42A4EA5CA8BE6560D4A806AB9DF11")
    private void handleCertificate(SslCertificate certificate) {
        // if this is main resource of the top frame
        if (mIsMainPageLoader && mIsMainResourceLoader) {
            // update the browser frame with certificate
            mBrowserFrame.certificate(certificate);
        }
    }

    /**
     * Implementation of error handler for EventHandler.
     * Subclasses should call this method to have error fields set.
     * @param id The error id described by EventHandler.
     * @param description A string description of the error.
     * IMPORTANT: as this is called from network thread, can't call native
     * directly
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.388 -0500", hash_original_method = "89A45FCA5400E7297D291CB9BD4FA531", hash_generated_method = "C888D2EBE22B33CBA481EECB8C6F0C39")
    public void error(int id, String description) {
        if (DebugFlags.LOAD_LISTENER) {
            Log.v(LOGTAG, "LoadListener.error url:" +
                    url() + " id:" + id + " description:" + description);
        }
        sendMessageInternal(obtainMessage(MSG_CONTENT_ERROR, id, 0, description));
    }

    // Handle the error on the WebCore thread.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.389 -0500", hash_original_method = "FF98E8647B63FEBC8B925077CB2E6971", hash_generated_method = "3F9DE0D206C090FF89324BD9EF42ADA8")
    private void handleError(int id, String description) {
        mErrorID = id;
        mErrorDescription = description;
        detachRequestHandle();
        notifyError();
        tearDown();
    }

    /**
     * Add data to the internal collection of data. This function is used by
     * the data: scheme, about: scheme and http/https schemes.
     * @param data A byte array containing the content.
     * @param length The length of data.
     * IMPORTANT: as this is called from network thread, can't call native
     * directly
     * XXX: Unlike the other network thread methods, this method can do the
     * work of decoding the data and appending it to the data builder.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.390 -0500", hash_original_method = "842D88ADC63F459E21BBD6FC9BF11FA0", hash_generated_method = "09DF8652C2396427E8C3181F052DEC23")
    public void data(byte[] data, int length) {
        if (DebugFlags.LOAD_LISTENER) {
            Log.v(LOGTAG, "LoadListener.data(): url: " + url());
        }

        // The reason isEmpty() and append() need to synchronized together is
        // because it is possible for getFirstChunk() to be called multiple
        // times between isEmpty() and append(). This could cause commitLoad()
        // to finish before processing the newly appended data and no message
        // will be sent.
        boolean sendMessage = false;
        synchronized (mDataBuilder) {
            sendMessage = mDataBuilder.isEmpty();
            mDataBuilder.append(data, 0, length);
        }
        if (sendMessage) {
            // Send a message whenever data comes in after a write to WebCore
            sendMessageInternal(obtainMessage(MSG_CONTENT_DATA));
        }
    }

    /**
     * Event handler's endData call. Send a message to the handler notifying
     * them that the data has finished.
     * IMPORTANT: as this is called from network thread, can't call native
     * directly
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.391 -0500", hash_original_method = "57E1AB7C57BAD02879F9C8B9B633558A", hash_generated_method = "DC2A41AA03DCB667D877296C574623AC")
    public void endData() {
        if (DebugFlags.LOAD_LISTENER) {
            Log.v(LOGTAG, "LoadListener.endData(): url: " + url());
        }
        sendMessageInternal(obtainMessage(MSG_CONTENT_FINISHED));
    }

    // Handle the end of data.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.392 -0500", hash_original_method = "CDF3DE93E351C5A11A75DE0E367F817E", hash_generated_method = "7EAD288A2C050CA2890BF26FFBF721D9")
    private void handleEndData() {
        if (mCancelled) return;

        switch (mStatusCode) {
            case HTTP_MOVED_PERMANENTLY:
                // 301 - permanent redirect
                mPermanent = true;
            case HTTP_FOUND:
            case HTTP_SEE_OTHER:
            case HTTP_TEMPORARY_REDIRECT:
                // 301, 302, 303, and 307 - redirect
                if (mStatusCode == HTTP_TEMPORARY_REDIRECT) {
                    if (mRequestHandle != null && 
                                mRequestHandle.getMethod().equals("POST")) {
                        sendMessageInternal(obtainMessage(
                                MSG_LOCATION_CHANGED_REQUEST));  
                    } else if (mMethod != null && mMethod.equals("POST")) {
                        sendMessageInternal(obtainMessage(
                                MSG_LOCATION_CHANGED_REQUEST));
                    } else {
                        sendMessageInternal(obtainMessage(MSG_LOCATION_CHANGED));
                    }
                } else {
                    sendMessageInternal(obtainMessage(MSG_LOCATION_CHANGED));
                }
                return;

            case HTTP_AUTH:
            case HTTP_PROXY_AUTH:
                // According to rfc2616, the response for HTTP_AUTH must include
                // WWW-Authenticate header field and the response for 
                // HTTP_PROXY_AUTH must include Proxy-Authenticate header field.
                if (mAuthHeader != null &&
                        (Network.getInstance(mContext).isValidProxySet() ||
                         !mAuthHeader.isProxy())) {
                    // If this is the first attempt to authenticate, try again with the username and
                    // password supplied in the URL, if present.
                    if (!mAuthFailed && mUsername != null && mPassword != null) {
                        String host = mAuthHeader.isProxy() ?
                                Network.getInstance(mContext).getProxyHostname() :
                                mUri.getHost();
                        HttpAuthHandlerImpl.onReceivedCredentials(this, host,
                                mAuthHeader.getRealm(), mUsername, mPassword);
                        makeAuthResponse(mUsername, mPassword);
                    } else {
                        Network.getInstance(mContext).handleAuthRequest(this);
                    }
                    return;
                }
                break;  // use default

            case HTTP_NOT_MODIFIED:
                // Server could send back NOT_MODIFIED even if we didn't
                // ask for it, so make sure we have a valid CacheLoader
                // before calling it.
                if (mCacheLoader != null) {
                    if (isSynchronous()) {
                        mCacheLoader.load();
                    } else {
                        // Load the cached file in a separate thread
                        WebViewWorker.getHandler().obtainMessage(
                                WebViewWorker.MSG_ADD_STREAMLOADER, mCacheLoader)
                                .sendToTarget();
                    }
                    mFromCache = true;
                    if (DebugFlags.LOAD_LISTENER) {
                        Log.v(LOGTAG, "LoadListener cache load url=" + url());
                    }
                    return;
                }
                break;  // use default

            case HTTP_NOT_FOUND:
                // Not an error, the server can send back content.
            default:
                break;
        }
        detachRequestHandle();
        tearDown();
    }

    /* This method is called from CacheLoader when the initial request is
     * serviced by the Cache. */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.393 -0500", hash_original_method = "986192BD953D202BDF33831C4485C789", hash_generated_method = "986192BD953D202BDF33831C4485C789")
    void setCacheLoader(CacheLoader c) {
        mCacheLoader = c;
        mFromCache = true;
    }

    /**
     * Check the cache for the current URL, and load it if it is valid.
     *
     * @param headers for the request
     * @return true if cached response is used.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.394 -0500", hash_original_method = "0AD650AC52F38566687E74B5EF113675", hash_generated_method = "F79A2E5FA156440E467C6A61D6D61217")
    boolean checkCache(Map<String, String> headers) {
        // Get the cache file name for the current URL
        CacheResult result = CacheManager.getCacheFile(url(), mPostIdentifier,
                headers);

        // Go ahead and set the cache loader to null in case the result is
        // null.
        mCacheLoader = null;
        // reset the flag
        mFromCache = false;

        if (result != null) {
            // The contents of the cache may need to be revalidated so just
            // remember the cache loader in the case that the server responds
            // positively to the cached content. This is also used to detect if
            // a redirect came from the cache.
            mCacheLoader = new CacheLoader(this, result);

            // If I got a cachedUrl and the revalidation header was not
            // added, then the cached content valid, we should use it.
            if (!headers.containsKey(
                    CacheManager.HEADER_KEY_IFNONEMATCH) &&
                    !headers.containsKey(
                            CacheManager.HEADER_KEY_IFMODIFIEDSINCE)) {
                if (DebugFlags.LOAD_LISTENER) {
                    Log.v(LOGTAG, "FrameLoader: HTTP URL in cache " +
                            "and usable: " + url());
                }
                if (isSynchronous()) {
                    mCacheLoader.load();
                } else {
                    // Load the cached file in a separate thread
                    WebViewWorker.getHandler().obtainMessage(
                            WebViewWorker.MSG_ADD_STREAMLOADER, mCacheLoader)
                            .sendToTarget();
                }
                mFromCache = true;
                return true;
            }
        }
        return false;
    }

    /**
     * SSL certificate error callback. Handles SSL error(s) on the way up
     * to the user.
     * IMPORTANT: as this is called from network thread, can't call native
     * directly
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.396 -0500", hash_original_method = "DAC212856E10133D124E798AA1F9AF10", hash_generated_method = "635313FC4207BD4AE0842E8F92D92CBE")
    public boolean handleSslErrorRequest(SslError error) {
        if (DebugFlags.LOAD_LISTENER) {
            Log.v(LOGTAG,
                    "LoadListener.handleSslErrorRequest(): url:" + url() +
                    " primary error: " + error.getPrimaryError() +
                    " certificate: " + error.getCertificate());
        }
        // Check the cached preference table before sending a message. This
        // will prevent waiting for an already available answer.
        if (Network.getInstance(mContext).checkSslPrefTable(this, error)) {
            return true;
        }
        // Do not post a message for a synchronous request. This will cause a
        // deadlock. Just bail on the request.
        if (isSynchronous()) {
            mRequestHandle.handleSslErrorResponse(false);
            return true;
        }
        sendMessageInternal(obtainMessage(MSG_SSL_ERROR, error));
        // if it has been canceled, return false so that the network thread
        // won't be blocked. If it is not canceled, save the mRequestHandle
        // so that if it is canceled when MSG_SSL_ERROR is handled, we can
        // still call handleSslErrorResponse which will call restartConnection
        // to unblock the network thread.
        if (!mCancelled) {
            mSslErrorRequestHandle = mRequestHandle;
        }
        return !mCancelled;
    }

    // Handle the ssl error on the WebCore thread.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.397 -0500", hash_original_method = "8A34681F6BA1F3EEE132C403DE00B59E", hash_generated_method = "1704C2821FE571DC0858607B8EBD0281")
    private void handleSslError(SslError error) {
        if (!mCancelled) {
            mSslError = error;
            Network.getInstance(mContext).handleSslErrorRequest(this);
        } else if (mSslErrorRequestHandle != null) {
            mSslErrorRequestHandle.handleSslErrorResponse(true);
        }
        mSslErrorRequestHandle = null;
    }

    /**
     * @return HTTP authentication realm or null if none.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.397 -0500", hash_original_method = "273C3FB8F6276DB18167E6647E9B9071", hash_generated_method = "273C3FB8F6276DB18167E6647E9B9071")
    String realm() {
        if (mAuthHeader == null) {
            return null;
        } else {
            return mAuthHeader.getRealm();
        }
    }

    /**
     * Returns true iff an HTTP authentication problem has
     * occured (credentials invalid).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.398 -0500", hash_original_method = "B53822BFF4A674DE454739734B590814", hash_generated_method = "EC617CC556BE1483D43B093E2F5B0359")
    boolean authCredentialsInvalid() {
        // if it is digest and the nonce is stale, we just
        // resubmit with a new nonce
        return (mAuthFailed &&
                !(mAuthHeader.isDigest() && mAuthHeader.getStale()));
    }

    /**
     * @return The last SSL error or null if there is none
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.399 -0500", hash_original_method = "D83DC2897E3C9B13E1B0E03447F2258A", hash_generated_method = "D83DC2897E3C9B13E1B0E03447F2258A")
    SslError sslError() {
        return mSslError;
    }

    /**
     * Handles SSL error(s) on the way down from the user
     * (the user has already provided their feedback).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.399 -0500", hash_original_method = "98A7269FE5209374A8ED24F438AC19C3", hash_generated_method = "98A7269FE5209374A8ED24F438AC19C3")
    void handleSslErrorResponse(boolean proceed) {
        if (mRequestHandle != null) {
            mRequestHandle.handleSslErrorResponse(proceed);
        }
        if (!proceed) {
            mBrowserFrame.stopLoading();
            tearDown();
        }
    }

    /**
     * Uses user-supplied credentials to restart a request. If the credentials
     * are null, cancel the request.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.400 -0500", hash_original_method = "7E02E9AA12C4A958E94F9A413E55434A", hash_generated_method = "0665231E11D1B705C546F5C3CB2CBE70")
    void handleAuthResponse(String username, String password) {
        if (DebugFlags.LOAD_LISTENER) {
            Log.v(LOGTAG, "LoadListener.handleAuthResponse: url: " + mUrl
                    + " username: " + username
                    + " password: " + password);
        }
        if (username != null && password != null) {
            makeAuthResponse(username, password);
        } else {
            // Commit whatever data we have and tear down the loader.
            commitLoad();
            tearDown();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.401 -0500", hash_original_method = "D4EC792204E12F6CD4476F22DB2D7416", hash_generated_method = "23C15967EC87129DA65B4C170E58149C")
    void makeAuthResponse(String username, String password) {
        if (mAuthHeader == null || mRequestHandle == null) {
            return;
        }

        mAuthHeader.setUsername(username);
        mAuthHeader.setPassword(password);

        int scheme = mAuthHeader.getScheme();
        if (scheme == HttpAuthHeader.BASIC) {
            // create a basic response
            boolean isProxy = mAuthHeader.isProxy();

            mRequestHandle.setupBasicAuthResponse(isProxy, username, password);
        } else if (scheme == HttpAuthHeader.DIGEST) {
            // create a digest response
            boolean isProxy = mAuthHeader.isProxy();

            String realm     = mAuthHeader.getRealm();
            String nonce     = mAuthHeader.getNonce();
            String qop       = mAuthHeader.getQop();
            String algorithm = mAuthHeader.getAlgorithm();
            String opaque    = mAuthHeader.getOpaque();

            mRequestHandle.setupDigestAuthResponse(isProxy, username, password,
                    realm, nonce, qop, algorithm, opaque);
        }
    }

    /**
     * This is called when a request can be satisfied by the cache, however,
     * the cache result could be a redirect. In this case we need to issue
     * the network request.
     * @param method
     * @param headers
     * @param postData
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.402 -0500", hash_original_method = "0354530277F06C2F68A7F9A147112FDC", hash_generated_method = "0354530277F06C2F68A7F9A147112FDC")
    void setRequestData(String method, Map<String, String> headers, 
            byte[] postData) {
        mMethod = method;
        mRequestHeaders = headers;
        mPostData = postData;
    }

    /**
     * @return The current URL associated with this load.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.403 -0500", hash_original_method = "50C2A5A94CFD2B09208EC5050A570E5D", hash_generated_method = "50C2A5A94CFD2B09208EC5050A570E5D")
    String url() {
        return mUrl;
    }

    /**
     * @return The current WebAddress associated with this load.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.403 -0500", hash_original_method = "C2839DA6285DEBF5C5C20951F1E9FC61", hash_generated_method = "C2839DA6285DEBF5C5C20951F1E9FC61")
    WebAddress getWebAddress() {
        return mUri;
    }

    /**
     * @return URL hostname (current URL).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.404 -0500", hash_original_method = "0451B8994B1846476A8FE8B0355ADDFF", hash_generated_method = "0451B8994B1846476A8FE8B0355ADDFF")
    String host() {
        if (mUri != null) {
            return mUri.getHost();
        }

        return null;
    }

    /**
     * @return The original URL associated with this load.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.405 -0500", hash_original_method = "BC027B9D5395B8E20CC57CD534FC36DC", hash_generated_method = "BC027B9D5395B8E20CC57CD534FC36DC")
    String originalUrl() {
        if (mOriginalUrl != null) {
            return mOriginalUrl;
        } else {
            return mUrl;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.406 -0500", hash_original_method = "1FD4A483F618FB6B6B2EA6F438798B25", hash_generated_method = "1FD4A483F618FB6B6B2EA6F438798B25")
    long postIdentifier() {
        return mPostIdentifier;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.406 -0500", hash_original_method = "555C5182696D3D1E5A8F07F29E226BC9", hash_generated_method = "555C5182696D3D1E5A8F07F29E226BC9")
    void attachRequestHandle(RequestHandle requestHandle) {
        if (DebugFlags.LOAD_LISTENER) {
            Log.v(LOGTAG, "LoadListener.attachRequestHandle(): " +
                    "requestHandle: " +  requestHandle);
        }
        mRequestHandle = requestHandle;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.407 -0500", hash_original_method = "A03FA80E3F939CA589BDCCBFD92DE3E2", hash_generated_method = "A03FA80E3F939CA589BDCCBFD92DE3E2")
    void detachRequestHandle() {
        if (DebugFlags.LOAD_LISTENER) {
            Log.v(LOGTAG, "LoadListener.detachRequestHandle(): " +
                    "requestHandle: " + mRequestHandle);
        }
        mRequestHandle = null;
    }

    /*
     * This function is called from native WebCore code to
     * notify this LoadListener that the content it is currently
     * downloading should be saved to a file and not sent to
     * WebCore.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.408 -0500", hash_original_method = "34F543213ABA35F3500E526ABE3EA0BF", hash_generated_method = "6650D383E607F28C1F77130139EBF1C3")
    void downloadFile() {
        // remove the cache
        WebViewWorker.getHandler().obtainMessage(
                WebViewWorker.MSG_REMOVE_CACHE, this).sendToTarget();

        // Inform the client that they should download a file
        mBrowserFrame.getCallbackProxy().onDownloadStart(url(), 
                mBrowserFrame.getUserAgentString(),
                mHeaders.getContentDisposition(), 
                mMimeType, mContentLength);

        // Cancel the download. We need to stop the http load.
        // The native loader object will get cleared by the call to
        // cancel() but will also be cleared on the WebCore side
        // when this function returns.
        cancel();
    }

    /*
     * Reset the cancel flag. This is used when we are resuming a stopped
     * download. To suspend a download, we cancel it. It can also be cancelled
     * when it has run out of disk space. In this situation, the download
     * can be resumed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.410 -0500", hash_original_method = "D1C1DC94D32429EE46F2E8034E6F3CAD", hash_generated_method = "D1C1DC94D32429EE46F2E8034E6F3CAD")
    void resetCancel() {
        mCancelled = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.410 -0500", hash_original_method = "AB4E07CAED8783333F5D8E2EFE2FEA5A", hash_generated_method = "AB4E07CAED8783333F5D8E2EFE2FEA5A")
    String mimeType() {
        return mMimeType;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.411 -0500", hash_original_method = "EDB0721EF3A307F050BF15E668A80271", hash_generated_method = "EDB0721EF3A307F050BF15E668A80271")
    String transferEncoding() {
        return mTransferEncoding;
    }

    /*
     * Return the size of the content being downloaded. This represents the
     * full content size, even under the situation where the download has been
     * resumed after interruption.
     *
     * @ return full content size
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.412 -0500", hash_original_method = "A0A208846C45918947FC3EEE159224A3", hash_generated_method = "A0A208846C45918947FC3EEE159224A3")
    long contentLength() {
        return mContentLength;
    }

    // Commit the headers if the status code is not a redirect.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.413 -0500", hash_original_method = "78D8A8AE22C18C73CE2907680A09633B", hash_generated_method = "8454BFF8CF771223F5CEFC6FBB76A80D")
    private void commitHeadersCheckRedirect() {
        if (mCancelled) return;

        // do not call webcore if it is redirect. According to the code in
        // InspectorController::willSendRequest(), the response is only updated
        // when it is not redirect. If we received a not-modified response from
        // the server and mCacheLoader is not null, do not send the response to
        // webkit. This is just a validation response for loading from the
        // cache.
        if ((mStatusCode >= 301 && mStatusCode <= 303) || mStatusCode == 307 ||
                (mStatusCode == 304 && mCacheLoader != null)) {
            return;
        }

        commitHeaders();
    }

    // This commits the headers without checking the response status code.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.413 -0500", hash_original_method = "8E8E66962C082FBF4981B6E1121BFDBD", hash_generated_method = "06B645531472C60F16D044A6250443F6")
    private void commitHeaders() {
        if (mIsMainPageLoader && CertTool.getCertType(mMimeType) != null) {
            // In the case of downloading certificate, we will save it to the
            // KeyStore in commitLoad. Do not call webcore.
            return;
        }

        // If the response is an authentication and we've resent the
        // request with some credentials then don't commit the headers
        // of this response; wait for the response to the request with the
        // credentials.
        if (mAuthHeader != null) {
            return;
        }

        setNativeResponse();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.414 -0500", hash_original_method = "E28F47114E6BDDF9FD429A699C881F5C", hash_generated_method = "B74395CDBED4557E00F3454E94232A1E")
    private void setNativeResponse() {
        int nativeResponse = createNativeResponse();
        // The native code deletes the native response object.
        nativeReceivedResponse(nativeResponse);
        mSetNativeResponse = true;
    }

    /**
     * Create a WebCore response object so that it can be used by
     * nativeReceivedResponse or nativeRedirectedToUrl
     * @return native response pointer
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.416 -0500", hash_original_method = "90DA669053E3EAB1E41208AD478B9563", hash_generated_method = "655B3796015A2475A063A7A7B1238571")
    private int createNativeResponse() {
        // If WebCore sends if-modified-since, mCacheLoader is null. If 
        // CacheManager sends it, mCacheLoader is not null. In this case, if the
        // server responds with a 304, then we treat it like it was a 200 code 
        // and proceed with loading the file from the cache.
        int statusCode = (mStatusCode == HTTP_NOT_MODIFIED &&
                mCacheLoader != null) ? HTTP_OK : mStatusCode;
        // pass content-type content-length and content-encoding
        final int nativeResponse = nativeCreateResponse(
                originalUrl(), statusCode, mStatusText,
                mMimeType, mContentLength, mEncoding);
        if (mHeaders != null) {
            mHeaders.getHeaders(new Headers.HeaderCallback() {
                    public void header(String name, String value) {
                        nativeSetResponseHeader(nativeResponse, name, value);
                    }
                });
        }
        return nativeResponse;
    }

    /**
     * Commit the load.  It should be ok to call repeatedly but only before
     * tearDown is called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.417 -0500", hash_original_method = "6C3510E057E7F86D9E5BFE641B751A6D", hash_generated_method = "A3672F6EFBB3BADD1BB15C644CDA938C")
    private void commitLoad() {
        if (mCancelled) return;
        if (!mSetNativeResponse) {
            setNativeResponse();
        }

        if (mIsMainPageLoader) {
            String type = CertTool.getCertType(mMimeType);
            if (type != null) {
                // This must be synchronized so that no more data can be added
                // after getByteSize returns.
                synchronized (mDataBuilder) {
                    // In the case of downloading certificate, we will save it
                    // to the KeyStore and stop the current loading so that it
                    // will not generate a new history page
                    byte[] cert = new byte[mDataBuilder.getByteSize()];
                    int offset = 0;
                    while (true) {
                        ByteArrayBuilder.Chunk c = mDataBuilder.getFirstChunk();
                        if (c == null) break;

                        if (c.mLength != 0) {
                            System.arraycopy(c.mArray, 0, cert, offset, c.mLength);
                            offset += c.mLength;
                        }
                        c.release();
                    }
                    CertTool.addCertificate(mContext, type, cert);
                    mBrowserFrame.stopLoading();
                    return;
                }
            }
        }

        // Give the data to WebKit now. We don't have to synchronize on
        // mDataBuilder here because pulling each chunk removes it from the
        // internal list so it cannot be modified.
        ByteArrayBuilder.Chunk c;
        while (true) {
            c = mDataBuilder.getFirstChunk();
            if (c == null) break;

            if (c.mLength != 0) {
                nativeAddData(c.mArray, c.mLength);
                WebViewWorker.CacheData data = new WebViewWorker.CacheData();
                data.mListener = this;
                data.mChunk = c;
                WebViewWorker.getHandler().obtainMessage(
                        WebViewWorker.MSG_APPEND_CACHE, data).sendToTarget();
            } else {
                c.release();
            }
        }
    }

    /**
     * Tear down the load. Subclasses should clean up any mess because of
     * cancellation or errors during the load.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.418 -0500", hash_original_method = "622A6BD0A40561F44F0949C5CF1F5483", hash_generated_method = "622A6BD0A40561F44F0949C5CF1F5483")
    void tearDown() {
        if (getErrorID() == OK) {
            WebViewWorker.CacheSaveData data = new WebViewWorker.CacheSaveData();
            data.mListener = this;
            data.mUrl = mUrl;
            data.mPostId = mPostIdentifier;
            WebViewWorker.getHandler().obtainMessage(
                    WebViewWorker.MSG_SAVE_CACHE, data).sendToTarget();
        } else {
            WebViewWorker.getHandler().obtainMessage(
                    WebViewWorker.MSG_REMOVE_CACHE, this).sendToTarget();
        }
        if (mNativeLoader != 0) {
            if (!mSetNativeResponse) {
                setNativeResponse();
            }

            nativeFinished();
            clearNativeLoader();
        }
    }

    /**
     * Helper for getting the error ID.
     * @return errorID.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.419 -0500", hash_original_method = "209FBE9F3E1C7384DEBC7D7B19E27A8A", hash_generated_method = "CBB271F392776065AD5357F7DD052812")
    private int getErrorID() {
        return mErrorID;
    }

    /**
     * Return the error description.
     * @return errorDescription.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.420 -0500", hash_original_method = "D67F514368DCF056FAAB1F778CFC87BD", hash_generated_method = "4420A8222648D93A15CB5E56C33A0349")
    private String getErrorDescription() {
        return mErrorDescription;
    }

    /**
     * Notify the loader we encountered an error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.421 -0500", hash_original_method = "E680E4717FCBA329FAA87BAD42E56CAC", hash_generated_method = "E680E4717FCBA329FAA87BAD42E56CAC")
    void notifyError() {
        if (mNativeLoader != 0) {
            String description = getErrorDescription();
            if (description == null) description = "";
            nativeError(getErrorID(), description, url());
            clearNativeLoader();
        }
    }

    /**
     * Pause the load. For example, if a plugin is unable to accept more data,
     * we pause reading from the request. Called directly from the WebCore thread.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.421 -0500", hash_original_method = "DFC23EFD31E5C4FF40E98CE1A64FD5ED", hash_generated_method = "DFC23EFD31E5C4FF40E98CE1A64FD5ED")
    void pauseLoad(boolean pause) {
        if (mRequestHandle != null) {
            mRequestHandle.pauseRequest(pause);
        }
    }

    /**
     * Cancel a request.
     * FIXME: This will only work if the request has yet to be handled. This
     * is in no way guarenteed if requests are served in a separate thread.
     * It also causes major problems if cancel is called during an
     * EventHandler's method call.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.422 -0500", hash_original_method = "1181D36634AC97975F684A5C861366C7", hash_generated_method = "F7FCA06355DDC312F1C17F6E20005DC3")
    public void cancel() {
        if (DebugFlags.LOAD_LISTENER) {
            if (mRequestHandle == null) {
                Log.v(LOGTAG, "LoadListener.cancel(): no requestHandle");
            } else {
                Log.v(LOGTAG, "LoadListener.cancel()");
            }
        }
        if (mRequestHandle != null) {
            mRequestHandle.cancel();
            mRequestHandle = null;
        }

        WebViewWorker.getHandler().obtainMessage(
                WebViewWorker.MSG_REMOVE_CACHE, this).sendToTarget();
        mCancelled = true;

        clearNativeLoader();
    }

    /*
     * Perform the actual redirection. This involves setting up the new URL,
     * informing WebCore and then telling the Network to start loading again.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.425 -0500", hash_original_method = "A28FBC4A594C62B1FB221C43DC1C2583", hash_generated_method = "96CCBC29EC9CB5B244DE46A72EA7EFD4")
    private void doRedirect() {
        // as cancel() can cancel the load before doRedirect() is
        // called through handleMessage, needs to check to see if we
        // are canceled before proceed
        if (mCancelled) {
            return;
        }

        // Do the same check for a redirect loop that
        // RequestHandle.setupRedirect does.
        if (mCacheRedirectCount >= RequestHandle.MAX_REDIRECT_COUNT) {
            handleError(EventHandler.ERROR_REDIRECT_LOOP, mContext.getString(
                    R.string.httpErrorRedirectLoop));
            return;
        }

        String redirectTo = mHeaders.getLocation();
        if (redirectTo != null) {
            int nativeResponse = createNativeResponse();
            redirectTo =
                    nativeRedirectedToUrl(mUrl, redirectTo, nativeResponse);
            // nativeRedirectedToUrl() may call cancel(), e.g. when redirect
            // from a https site to a http site, check mCancelled again
            if (mCancelled) {
                return;
            }
            if (redirectTo == null) {
                Log.d(LOGTAG, "Redirection failed for "
                        + mHeaders.getLocation());
                cancel();
                return;
            } else if (!URLUtil.isNetworkUrl(redirectTo)) {
                final String text = mContext
                        .getString(R.string.open_permission_deny)
                        + "\n" + redirectTo;
                if (!mSetNativeResponse) {
                    setNativeResponse();
                }
                nativeAddData(text.getBytes(), text.length());
                nativeFinished();
                clearNativeLoader();
                return;
            }


            // Cache the redirect response
            if (getErrorID() == OK) {
                WebViewWorker.CacheSaveData data = new WebViewWorker.CacheSaveData();
                data.mListener = this;
                data.mUrl = mUrl;
                data.mPostId = mPostIdentifier;
                WebViewWorker.getHandler().obtainMessage(
                        WebViewWorker.MSG_SAVE_CACHE, data).sendToTarget();
            } else {
                WebViewWorker.getHandler().obtainMessage(
                        WebViewWorker.MSG_REMOVE_CACHE, this).sendToTarget();
            }

            // Saving a copy of the unstripped url for the response
            mOriginalUrl = redirectTo;
            // This will strip the anchor
            setUrl(redirectTo);

            // Redirect may be in the cache
            if (mRequestHeaders == null) {
                mRequestHeaders = new HashMap<String, String>();
            }
            boolean fromCache = false;
            if (mCacheLoader != null) {
                // This is a redirect from the cache loader. Increment the
                // redirect count to avoid redirect loops.
                mCacheRedirectCount++;
                fromCache = true;
            }
            if (!checkCache(mRequestHeaders)) {
                // mRequestHandle can be null when the request was satisfied
                // by the cache, and the cache returned a redirect
                if (mRequestHandle != null) {
                    try {
                        mRequestHandle.setupRedirect(mUrl, mStatusCode,
                                mRequestHeaders);
                    } catch(RuntimeException e) {
                        Log.e(LOGTAG, e.getMessage());
                        // Signal a bad url error if we could not load the
                        // redirection.
                        handleError(EventHandler.ERROR_BAD_URL,
                                mContext.getString(R.string.httpErrorBadUrl));
                        return;
                    }
                } else {
                    // If the original request came from the cache, there is no
                    // RequestHandle, we have to create a new one through
                    // Network.requestURL.
                    Network network = Network.getInstance(getContext());
                    if (!network.requestURL(mMethod, mRequestHeaders,
                            mPostData, this)) {
                        // Signal a bad url error if we could not load the
                        // redirection.
                        handleError(EventHandler.ERROR_BAD_URL,
                                mContext.getString(R.string.httpErrorBadUrl));
                        return;
                    }
                }
                if (fromCache) {
                    // If we are coming from a cache load, we need to transfer
                    // the redirect count to the new (or old) RequestHandle to
                    // keep the redirect count in sync.
                    mRequestHandle.setRedirectCount(mCacheRedirectCount);
                }
            } else if (!fromCache) {
                // Switching from network to cache means we need to grab the
                // redirect count from the RequestHandle to keep the count in
                // sync. Add 1 to account for the current redirect.
                mCacheRedirectCount = mRequestHandle.getRedirectCount() + 1;
            }
        } else {
            commitHeaders();
            commitLoad();
            tearDown();
        }

        if (DebugFlags.LOAD_LISTENER) {
            Log.v(LOGTAG, "LoadListener.onRedirect(): redirect to: " +
                    redirectTo);
        }
    }

    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.427 -0500", hash_original_method = "F42460285C9091878E41158B4AED6A71", hash_generated_method = "756BFA1AE35C48D40769C48C08555D3E")
    void parseContentTypeHeader(String contentType) {
        if (DebugFlags.LOAD_LISTENER) {
            Log.v(LOGTAG, "LoadListener.parseContentTypeHeader: " +
                    "contentType: " + contentType);
        }

        if (contentType != null) {
            int i = contentType.indexOf(';');
            if (i >= 0) {
                mMimeType = contentType.substring(0, i);

                int j = contentType.indexOf('=', i);
                if (j > 0) {
                    i = contentType.indexOf(';', j);
                    if (i < j) {
                        i = contentType.length();
                    }
                    mEncoding = contentType.substring(j + 1, i);
                } else {
                    mEncoding = contentType.substring(i + 1);
                }
                // Trim excess whitespace.
                mEncoding = mEncoding.trim().toLowerCase();

                if (i < contentType.length() - 1) {
                    // for data: uri the mimeType and encoding have
                    // the form image/jpeg;base64 or text/plain;charset=utf-8
                    // or text/html;charset=utf-8;base64
                    mTransferEncoding =
                            contentType.substring(i + 1).trim().toLowerCase();
                }
            } else {
                mMimeType = contentType;
            }

            // Trim leading and trailing whitespace
            mMimeType = mMimeType.trim();

            try {
                Matcher m = CONTENT_TYPE_PATTERN.matcher(mMimeType);
                if (m.find()) {
                    mMimeType = m.group(1);
                } else {
                    guessMimeType();
                }
            } catch (IllegalStateException ex) {
                guessMimeType();
            }
        }
        // Ensure mMimeType is lower case.
        mMimeType = mMimeType.toLowerCase();
    }

    /**
     * @return The HTTP-authentication object or null if there
     * is no supported scheme in the header.
     * If there are several valid schemes present, we pick the
     * strongest one. If there are several schemes of the same
     * strength, we pick the one that comes first.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.428 -0500", hash_original_method = "AE0FC74CC8A0BC926B5DCE69D72EC94D", hash_generated_method = "37D6D0643FD2EA6EA0B729BE9E908B94")
    private HttpAuthHeader parseAuthHeader(String header) {
        if (header != null) {
            int posMax = 256;
            int posLen = 0;
            int[] pos = new int [posMax];

            int headerLen = header.length();
            if (headerLen > 0) {
                // first, we find all unquoted instances of 'Basic' and 'Digest'
                boolean quoted = false;
                for (int i = 0; i < headerLen && posLen < posMax; ++i) {
                    if (header.charAt(i) == '\"') {
                        quoted = !quoted;
                    } else {
                        if (!quoted) {
                            if (header.regionMatches(true, i,
                                    HttpAuthHeader.BASIC_TOKEN, 0,
                                    HttpAuthHeader.BASIC_TOKEN.length())) {
                                pos[posLen++] = i;
                                continue;
                            }

                            if (header.regionMatches(true, i,
                                    HttpAuthHeader.DIGEST_TOKEN, 0,
                                    HttpAuthHeader.DIGEST_TOKEN.length())) {
                                pos[posLen++] = i;
                                continue;
                            }
                        }
                    }
                }
            }

            if (posLen > 0) {
                // consider all digest schemes first (if any)
                for (int i = 0; i < posLen; i++) {
                    if (header.regionMatches(true, pos[i],
                                HttpAuthHeader.DIGEST_TOKEN, 0,
                                HttpAuthHeader.DIGEST_TOKEN.length())) {
                        String sub = header.substring(pos[i],
                                (i + 1 < posLen ? pos[i + 1] : headerLen));

                        HttpAuthHeader rval = new HttpAuthHeader(sub);
                        if (rval.isSupportedScheme()) {
                            // take the first match
                            return rval;
                        }
                    }
                }

                // ...then consider all basic schemes (if any)
                for (int i = 0; i < posLen; i++) {
                    if (header.regionMatches(true, pos[i],
                                HttpAuthHeader.BASIC_TOKEN, 0,
                                HttpAuthHeader.BASIC_TOKEN.length())) {
                        String sub = header.substring(pos[i],
                                (i + 1 < posLen ? pos[i + 1] : headerLen));

                        HttpAuthHeader rval = new HttpAuthHeader(sub);
                        if (rval.isSupportedScheme()) {
                            // take the first match
                            return rval;
                        }
                    }
                }
            }
        }

        return null;
    }

    /**
     * If the content is a redirect or not modified we should not send
     * any data into WebCore as that will cause it create a document with
     * the data, then when we try to provide the real content, it will assert.
     *
     * @return True iff the callback should be ignored.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.429 -0500", hash_original_method = "977413F84EEA9D9E0B7BBB5D674FC9E7", hash_generated_method = "C193B708AD165A660F76A53E245457E1")
    private boolean ignoreCallbacks() {
        return (mCancelled || mAuthHeader != null ||
                // Allow 305 (Use Proxy) to call through.
                (mStatusCode > 300 && mStatusCode < 400 && mStatusCode != 305));
    }

    /**
     * Sets the current URL associated with this load.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.430 -0500", hash_original_method = "B1CFB6FACF3C8464BDC576EEF15EE2EE", hash_generated_method = "B1CFB6FACF3C8464BDC576EEF15EE2EE")
    void setUrl(String url) {
        if (url != null) {
            mUri = null;
            if (URLUtil.isNetworkUrl(url)) {
                mUrl = URLUtil.stripAnchor(url);
                try {
                    mUri = new WebAddress(mUrl);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else {
                mUrl = url;
            }
        }
    }

    /**
     * Guesses MIME type if one was not specified. Defaults to 'text/html'. In
     * addition, tries to guess the MIME type based on the extension.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.431 -0500", hash_original_method = "EF260C0902D2E84B94B185FE48F20D51", hash_generated_method = "8021CD6B00DDAD56B52A7509EA9C07EF")
    private void guessMimeType() {
        // Data urls must have a valid mime type or a blank string for the mime
        // type (implying text/plain).
        if (URLUtil.isDataUrl(mUrl) && mMimeType.length() != 0) {
            cancel();
            final String text = mContext.getString(R.string.httpErrorBadUrl);
            handleError(EventHandler.ERROR_BAD_URL, text);
        } else {
            // Note: This is ok because this is used only for the main content
            // of frames. If no content-type was specified, it is fine to
            // default to text/html.
            mMimeType = "text/html";
            String newMimeType = guessMimeTypeFromExtension(mUrl);
            if (newMimeType != null) {
                mMimeType = newMimeType;
            }
        }
    }

    /**
     * guess MIME type based on the file extension.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.431 -0500", hash_original_method = "2EA3CE69FA8B837FDAA4CA6DE51D2499", hash_generated_method = "AAE65D57329207CA6E43888EEC2755F7")
    private String guessMimeTypeFromExtension(String url) {
        // PENDING: need to normalize url
        if (DebugFlags.LOAD_LISTENER) {
            Log.v(LOGTAG, "guessMimeTypeFromExtension: url = " + url);
        }

        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(
                MimeTypeMap.getFileExtensionFromUrl(url));
    }

    /**
     * Either send a message to ourselves or queue the message if this is a
     * synchronous load.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.432 -0500", hash_original_method = "4C14C55105A23524352CD131708D205A", hash_generated_method = "C2051A12288BDA05573D45CB4F842EE0")
    private void sendMessageInternal(Message msg) {
        if (mSynchronous) {
            mMessageQueue.add(msg);
        } else {
            sendMessage(msg);
        }
    }

    /**
     * Cycle through our messages for synchronous loads.
     */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.433 -0500", hash_original_method = "84B3C85DEED8CE51C1D689DF257AD721", hash_generated_method = "D92F4491524734E2C39072D095E8A5BB")
    void loadSynchronousMessages() {
        if (DebugFlags.LOAD_LISTENER && !mSynchronous) {
            throw new AssertionError();
        }
        // Note: this can be called twice if it is a synchronous network load,
        // and there is a cache, but it needs to go to network to validate. If 
        // validation succeed, the CacheLoader is used so this is first called 
        // from http thread. Then it is called again from WebViewCore thread 
        // after the load is completed. So make sure the queue is cleared but
        // don't set it to null.
        while (!mMessageQueue.isEmpty()) {
            handleMessage(mMessageQueue.remove(0));
        }
    }

    //=========================================================================
    // native functions
    //=========================================================================

    /**
     * Create a new native response object.
     * @param url The url of the resource.
     * @param statusCode The HTTP status code.
     * @param statusText The HTTP status text.
     * @param mimeType HTTP content-type.
     * @param expectedLength An estimate of the content length or the length
     *                       given by the server.
     * @param encoding HTTP encoding.
     * @return The native response pointer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:00.611 -0500", hash_original_method = "4DA58223C4F20A38192632BBFEEE57C8", hash_generated_method = "9F1AF78FB5A9C9BCEDE3F196974EEDE2")
    private native int nativeCreateResponse(String url, int statusCode,
            String statusText, String mimeType, long expectedLength,
            String encoding);

    /**
     * Add a response header to the native object.
     * @param nativeResponse The native pointer.
     * @param key String key.
     * @param val String value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:00.612 -0500", hash_original_method = "BA6D20A53269A42AE8656C6EBDDFC70F", hash_generated_method = "844C0A50B5716AF87BD34EEB77E0CB7D")
    private native void nativeSetResponseHeader(int nativeResponse, String key,
            String val);

    /**
     * Dispatch the response.
     * @param nativeResponse The native pointer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:00.614 -0500", hash_original_method = "41C6950B308582DB9C9A99E22648CC08", hash_generated_method = "CB1212C9E00CED60E958D8E65D773551")
    private native void nativeReceivedResponse(int nativeResponse);

    /**
     * Add data to the loader.
     * @param data Byte array of data.
     * @param length Number of objects in data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:00.615 -0500", hash_original_method = "CB7AF973B7AC5B91CFB8AF007E1C0D32", hash_generated_method = "035167774DD7F630D943C0A2DDCA9658")
    private native void nativeAddData(byte[] data, int length);

    /**
     * Tell the loader it has finished.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:00.616 -0500", hash_original_method = "49549DEACC297430F7E9805D3678A016", hash_generated_method = "AA06E82B2FBF8034810ACC4CD2880391")
    private native void nativeFinished();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.190 -0400", hash_original_method = "33F440D9D1697DCCED15CDDD044058A8", hash_generated_method = "29EA735C0797FDF2B21BDCB4EDCF36A9")
    private String nativeRedirectedToUrl(String baseUrl,
            String redirectTo, int nativeResponse) {
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }

    /**
     * Tell the loader there is error
     * @param id
     * @param desc
     * @param failingUrl The url that failed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:00.619 -0500", hash_original_method = "BCCFE0CFBD3782D8BEDE6CB5D0F9DEA3", hash_generated_method = "CD9E93ECC177D9B9E4A21A91E47BA028")
    private native void nativeError(int id, String desc, String failingUrl);
}

