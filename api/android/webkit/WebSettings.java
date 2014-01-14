package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.Locale;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.EventLog;

public class WebSettings {

    /**
     * Convert obsolete language codes, including Hebrew/Indonesian/Yiddish,
     * to new standard.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.297 -0500", hash_original_method = "62A4EBD8F4E62508750FECA9D13AF599", hash_generated_method = "BD27898EED9580F366AC4D9476AB1AFF")
    
private static String convertObsoleteLanguageCodeToNew(String langCode) {
        if (langCode == null) {
            return null;
        }
        if ("iw".equals(langCode)) {
            // Hebrew
            return "he";
        } else if ("in".equals(langCode)) {
            // Indonesian
            return "id";
        } else if ("ji".equals(langCode)) {
            // Yiddish
            return "yi";
        }
        return langCode;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.300 -0500", hash_original_method = "2FD191509AAFF5A35E4AE6ACAB376D84", hash_generated_method = "ACB9318157E592EAC714BBB85AA8F2AA")
    
private static void addLocaleToHttpAcceptLanguage(StringBuilder builder,
                                                      Locale locale) {
        String language = convertObsoleteLanguageCodeToNew(locale.getLanguage());
        if (language != null) {
            builder.append(language);
            String country = locale.getCountry();
            if (country != null) {
                builder.append("-");
                builder.append(country);
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.026 -0500", hash_original_field = "14505BD58DC77F83564857D2F517D8F1", hash_generated_field = "8B66A9C4881AE208D014D8CA4228F2EE")

    public static final int LOAD_DEFAULT = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.028 -0500", hash_original_field = "131C1DAF4637B051DF2D8480F3FC158C", hash_generated_field = "33703CA84A1357E3977DACD6A717E588")

    public static final int LOAD_NORMAL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.030 -0500", hash_original_field = "D2FC2D6FA95B08FF534DE31F5ED61D0F", hash_generated_field = "78B96C7AA29D9AE00D647E251F96CF2B")

    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.033 -0500", hash_original_field = "3CD705411AD9F065824293743428CB4B", hash_generated_field = "1E865A76FD0ADA1679603C1906D1F61A")

    public static final int LOAD_NO_CACHE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.035 -0500", hash_original_field = "11F0BA0490DA287DFA9B68EED06F6527", hash_generated_field = "89C889C49078003040853BFEFF464593")

    public static final int LOAD_CACHE_ONLY = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.041 -0500", hash_original_field = "88111D294616C6F7851944FAE0F4A1CB", hash_generated_field = "D0EF9E13114399EDE7E01406D4CC77CA")

    private static final String PREVIOUS_VERSION = "3.1";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.248 -0500", hash_original_field = "A6BBE3CBCCCC2C584C9ECC40B62907D7", hash_generated_field = "FF3CCB91DD4246661BA37F60AF34DD57")

    static private int      mDoubleTapToastCount = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.250 -0500", hash_original_field = "BBFEC4EF0844F61C249AC25B1631404E", hash_generated_field = "6E3C440D8BF3EC1CA16D917A01E72EB8")

    private static final String PREF_FILE = "WebViewSettings";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.253 -0500", hash_original_field = "9ED954696543D4FCADEFD8380248F675", hash_generated_field = "5C124E37B3B634132C4C5D9B585D5CEC")

    private static final String DOUBLE_TAP_TOAST_COUNT = "double_tap_toast_count";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.280 -0500", hash_original_field = "A58B1462917671E972DA34249923F6C2", hash_generated_field = "1F903F388B91C74E2027345321C211C3")

    private static final String DESKTOP_USERAGENT = "Mozilla/5.0 (X11; " +
        "Linux x86_64) AppleWebKit/534.24 (KHTML, like Gecko) " +
        "Chrome/11.0.696.34 Safari/534.24";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.283 -0500", hash_original_field = "D8CC5E9DE10F19622ADAFD7D29863694", hash_generated_field = "1FE7BDD371AF963C7DBF5F80D7ED2ED5")

    private static final String IPHONE_USERAGENT =
            "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_0 like Mac OS X; en-us)"
            + " AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0"
            + " Mobile/7A341 Safari/528.16";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.285 -0500", hash_original_field = "B5750F26C28E1875446D9F884C03889C", hash_generated_field = "3DB7C9A03487D4317932026B0B75600E")

    private static Locale sLocale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.288 -0500", hash_original_field = "37BC12B2F2A372CA39850EA57A2F653C", hash_generated_field = "7E7566C1F279CE9C6151F8EDB80EC486")

    private static Object sLockForLocaleSettings;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.293 -0500", hash_original_field = "CEDFBFDC998D00187E60438069CE4172", hash_generated_field = "5546D78A409F4DFBBA356772B2D57DF1")

    private static final String ACCEPT_LANG_FOR_US_LOCALE = "en-US";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.043 -0500", hash_original_field = "E044D69EE05B24F4B93E3A3B208F5343", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.045 -0500", hash_original_field = "3FC88C05AF84F1DA5801895C1A5E2AA9", hash_generated_field = "076F5BF2A47D119E2704BFAF413B4749")

    private BrowserFrame mBrowserFrame;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.047 -0500", hash_original_field = "BFA7C2FE90DDE8A718609C5299DB374F", hash_generated_field = "C30651F336ACC984908CFD9A1D2C4FB4")

    private boolean mSyncPending = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.049 -0500", hash_original_field = "48DBEFEB1D57D7425F34775E3B0822FD", hash_generated_field = "04D6DC37F0EF901EF71A528809491D49")

    private  EventHandler mEventHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.051 -0500", hash_original_field = "5E0F28DE5746646C5A976C02D3038540", hash_generated_field = "B2974D7C83FBB7F21FCAA6C0A4821814")

    // retrieve the values. After setXXX, postSync() needs to be called.
    //
    // The default values need to match those in WebSettings.cpp
    // If the defaults change, please also update the JavaDocs so developers
    // know what they are.
    private LayoutAlgorithm mLayoutAlgorithm = LayoutAlgorithm.NARROW_COLUMNS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.053 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context         mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.056 -0500", hash_original_field = "435CE0AEEC0F99962B94439E4C1E52FE", hash_generated_field = "093C29E093EBC4DF45917F084F44F5C6")

    private int             mTextSize = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.058 -0500", hash_original_field = "E48EE4C7E3F1FCF65ABD8C0691173DAA", hash_generated_field = "E4348E0A07514EBC6D1B08E5327B30EE")

    private String          mStandardFontFamily = "sans-serif";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.060 -0500", hash_original_field = "8B78626510F23619600FB109550D4E1D", hash_generated_field = "3A7EFCED956E000EA686CA04D7AC83B8")

    private String          mFixedFontFamily = "monospace";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.063 -0500", hash_original_field = "23E67B91A56526BC742F0F516E3325C6", hash_generated_field = "399DACBDFE4EA1F4862F6FE2A91B1825")

    private String          mSansSerifFontFamily = "sans-serif";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.065 -0500", hash_original_field = "79BD949BC0DBB2C77366A1BC8DDB5F5E", hash_generated_field = "C8511EC396A968342E91C81EE20A14FE")

    private String          mSerifFontFamily = "serif";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.067 -0500", hash_original_field = "D2364DFAE6B88A92943608EAEDA0ED2B", hash_generated_field = "C79480C6B7D9DBB1193A0C73FB024BC6")

    private String          mCursiveFontFamily = "cursive";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.069 -0500", hash_original_field = "4FAF6606FEB2E43C4D5432445279650E", hash_generated_field = "B7EC94AD4E54CB710D321F7D7DE2B94D")

    private String          mFantasyFontFamily = "fantasy";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.071 -0500", hash_original_field = "1CCA1F4A344C360C960CBFB7F36D87DF", hash_generated_field = "B14E6AD20DBCE8C395967EFC3730E312")

    private String          mDefaultTextEncoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.073 -0500", hash_original_field = "AB9CC8B91DA4CABE1E4BC1B4F2E071E2", hash_generated_field = "DE0DD9FFAB9049B26488186A370E05A4")

    private String          mUserAgent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.075 -0500", hash_original_field = "F6B8D2DDF8489C524AAC60C71C118270", hash_generated_field = "98FAE63E9B12B7A881FB6D145E4549CE")

    private boolean         mUseDefaultUserAgent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.077 -0500", hash_original_field = "0EB2313042FF8A0A480BD35D1E4777D6", hash_generated_field = "439229978AE9CF49770BDEBF3E2CE78C")

    private String          mAcceptLanguage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.080 -0500", hash_original_field = "AE1E8617558267B8C488C4573955CE9F", hash_generated_field = "D0EDBC802964D83D99F85BC314C8A69C")

    private int             mMinimumFontSize = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.082 -0500", hash_original_field = "DAFA5FC2F3947B2A1374EDA21FBF7369", hash_generated_field = "528ED989B04689091770CF5109FE433F")

    private int             mMinimumLogicalFontSize = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.084 -0500", hash_original_field = "E7CAB6932F272AF55B60CDB00307315B", hash_generated_field = "57AE803195BA7056811C876F5BD9502B")

    private int             mDefaultFontSize = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.087 -0500", hash_original_field = "895653D7657AA1148FBAB3C354755E20", hash_generated_field = "5AFDCF69E75A0190CADCEA2557825121")

    private int             mDefaultFixedFontSize = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.089 -0500", hash_original_field = "C83B4836F19CB3B7787D2C1730EA8A79", hash_generated_field = "F690B69F0C52F955F3D88DD7983F79F2")

    private int             mPageCacheCapacity = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.091 -0500", hash_original_field = "9EF3C813B9FCD4D89ED954A3B99548E8", hash_generated_field = "DE3A280A6D9972DAFD651E9018D4768E")

    private boolean         mLoadsImagesAutomatically = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.093 -0500", hash_original_field = "B1B0AC2C1B82500C71F81C9E747E3C77", hash_generated_field = "503153EC725C55D5C1DC162A32A1D3DC")

    private boolean         mBlockNetworkImage = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.095 -0500", hash_original_field = "59B049F7A59EF274115A1ED0969BD04D", hash_generated_field = "1ACDBB27D2A84BAEF0BB072C0594B56E")

    private boolean         mBlockNetworkLoads;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.096 -0500", hash_original_field = "B128E29900780B6512AD2B181B0E92CB", hash_generated_field = "36C1818B65CEBEA6CFEE516674358D43")

    private boolean         mJavaScriptEnabled = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.099 -0500", hash_original_field = "EDE589EA426C8D634992AFFE6D511EEC", hash_generated_field = "0A90F6A7499839588E833D7BE890E1AE")

    private boolean         mHardwareAccelSkia = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.101 -0500", hash_original_field = "B39360D080C7F1C10E6BBD6A53BF42CE", hash_generated_field = "944C133C097C1E4190CF0C3582E0E938")

    private boolean         mShowVisualIndicator = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.104 -0500", hash_original_field = "B9AC87FD40FA84F7F8C67E412A4548C0", hash_generated_field = "7D86B7624AEF61E6266D36CF41EB39D7")

    private PluginState     mPluginState = PluginState.OFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.106 -0500", hash_original_field = "E1181E2E273F4BF51DA160692F8A73C7", hash_generated_field = "459DE55C50CE26452B149CCD8782CC03")

    private boolean         mJavaScriptCanOpenWindowsAutomatically = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.108 -0500", hash_original_field = "FE0E9185E5DE03EC5FAFD63485769754", hash_generated_field = "20A7E2DF1A565B51829896E9F69CF90A")

    private boolean         mUseDoubleTree = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.111 -0500", hash_original_field = "34E05AC44917A8FE2B55420245B157C2", hash_generated_field = "5EDADBA984DCE351C397430D71B8E193")

    private boolean         mUseWideViewport = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.113 -0500", hash_original_field = "F1495EB96456741889AE532952E84ED4", hash_generated_field = "63D7A412D6A66B99394E571B78F61F6C")

    private boolean         mSupportMultipleWindows = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.115 -0500", hash_original_field = "70B92D8B4A6B906A91B716712CAB8D0A", hash_generated_field = "77A7B89BB1F561628F9C88F763E053D4")

    private boolean         mShrinksStandaloneImagesToFit = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.117 -0500", hash_original_field = "408ABD26C21EC17AA04B70ADE4D51DC4", hash_generated_field = "71BCB1B04985B5A05BFF9925B051AEA3")

    private long            mMaximumDecodedImageSize = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.119 -0500", hash_original_field = "008FCD46A815CAF6815473C87BDEA10B", hash_generated_field = "381C5CB2F1A0DF35777B63F9BF8EDACD")

    private boolean         mPrivateBrowsingEnabled = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.121 -0500", hash_original_field = "9BD1B3448CFC94952B5B87DA7D406BC3", hash_generated_field = "F43E538FC31443F2EB0B8734DEF87A58")

    private boolean         mSyntheticLinksEnabled = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.123 -0500", hash_original_field = "C689A4E10C667C9E67529E6556228437", hash_generated_field = "A8618659B8DEE94F1CEAA079EECA9790")

    private boolean         mAppCacheEnabled = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.126 -0500", hash_original_field = "BA7DDB690C97DC977BEAE188604933AA", hash_generated_field = "ABA108E81C8DBD674018DAA8E50B66B3")

    private boolean         mDatabaseEnabled = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.128 -0500", hash_original_field = "F1D57E3FC1FDEDE25BC817A52F5DAB35", hash_generated_field = "5F06543ABC51E15528B933AC0AB2C6F7")

    private boolean         mDomStorageEnabled = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.130 -0500", hash_original_field = "6A5F765B3AFB7ACF7B44BDB0B6C2CAC6", hash_generated_field = "74A2A29BD57D607C6576055F7F403D0D")

    private boolean         mWorkersEnabled = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.133 -0500", hash_original_field = "C2AAC6CF058462D91800015625CEE986", hash_generated_field = "3C3198EADED631FE881AB97F9EAFA5FA")

    private boolean         mGeolocationEnabled = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.135 -0500", hash_original_field = "034F67EB9381E71BE552351BBF39F542", hash_generated_field = "6F3EA93685FD5D8B0D8F67E8E5C21B28")

    private boolean         mXSSAuditorEnabled = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.137 -0500", hash_original_field = "B6F6B74C3AB0F8702B7AA7B36943FC24", hash_generated_field = "A6B2EA55227276EA13A495BB96D1DF12")

    private long            mAppCacheMaxSize = Long.MAX_VALUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.139 -0500", hash_original_field = "767A3141BB1945A588C3F4F78C31CB66", hash_generated_field = "D79F53468E055B10315200B95916C500")

    private String          mAppCachePath = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.141 -0500", hash_original_field = "19EE1C95187536037F27E95FCB7FE5AB", hash_generated_field = "9EB5165541C5151194CB8556E03CD161")

    private String          mDatabasePath = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.143 -0500", hash_original_field = "02623673F265D16FA3FAABAD4C08E471", hash_generated_field = "1D4B5B06C07522387A5CDD88AAA91651")

    // once. Keep track of when the path has been set.
    private boolean         mDatabasePathHasBeenSet = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.146 -0500", hash_original_field = "4C29A2A90C2449CE8A7F02553949237C", hash_generated_field = "5ABA61E953719F99114204D8D30BD28F")

    private String          mGeolocationDatabasePath = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.148 -0500", hash_original_field = "8C42577F26FC9AFFE52D941443D8B782", hash_generated_field = "240715B5D3BC0745CBEC5F598BDA2812")

    // are basic types, also none of these values are used in
    // native WebCore code.
    private ZoomDensity     mDefaultZoom = ZoomDensity.MEDIUM;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.150 -0500", hash_original_field = "E194FEA5D98AED8EEFB1B12863EE2365", hash_generated_field = "A1F79CA724067D106338BC229C16B5FC")

    private RenderPriority  mRenderPriority = RenderPriority.NORMAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.152 -0500", hash_original_field = "0F7294930861F44D568DB5F1272DC7E7", hash_generated_field = "5C01ACB0A24F788620EF740B6F83D8FF")

    private int             mOverrideCacheMode = LOAD_DEFAULT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.154 -0500", hash_original_field = "0665A7EA40A506EE39982B8D5D559245", hash_generated_field = "1E5E05632184B0562D99F65B2623C2C6")

    private int             mDoubleTapZoom = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.156 -0500", hash_original_field = "66D600A5B4E3D1FB6B54FFE7B8478F3B", hash_generated_field = "82ACFD258B431C7D2B00D5130B9F8AC1")

    private boolean         mSaveFormData = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.158 -0500", hash_original_field = "10B7464F0DB5CBA81B52297271ED0A10", hash_generated_field = "EE91F91973A59EB55189A26DDA38F9B3")

    private boolean         mAutoFillEnabled = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.160 -0500", hash_original_field = "7959F3EE158480A4E4F9626ED86CBF1F", hash_generated_field = "0C944D5751C5A507BE22C1937F62D8F5")

    private boolean         mSavePassword = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.163 -0500", hash_original_field = "598C4932E00C538ED342635A6B120C4A", hash_generated_field = "B0E370B7C84DDE746CBD3769FED2B05B")

    private boolean         mLightTouchEnabled = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.165 -0500", hash_original_field = "53ADFCDC80B4BBA06D079F0FD64D2AD8", hash_generated_field = "479CD0E5DFA0F4A8AD2336A3C8796C11")

    private boolean         mNeedInitialFocus = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.168 -0500", hash_original_field = "EDED71F16B35B776A04DC42FF6EE467C", hash_generated_field = "53BEF3F54FA7E72187F7DE406E409A1B")

    private boolean         mNavDump = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.170 -0500", hash_original_field = "F02E9461ACB40DE72A3C5B6D1E59885A", hash_generated_field = "9816BC835AB5A0ACD4FDE0137AF8616C")

    private boolean         mSupportZoom = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.172 -0500", hash_original_field = "C1D31ADC70F601EC2834A1D388F59F3F", hash_generated_field = "C64C3FAECED9CD368C40F69AB6974F26")

    private boolean         mBuiltInZoomControls = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.174 -0500", hash_original_field = "7AE6C386B6A15211ADC4FADC1DACAA17", hash_generated_field = "620B20DEA57B92E5F177E02A77C42AD0")

    private boolean         mDisplayZoomControls = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.176 -0500", hash_original_field = "20131F2CB1A2F516E12873E3AB0A3A37", hash_generated_field = "296BB32E1651209ADFADBF23000A8C19")

    private boolean         mAllowFileAccess = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.178 -0500", hash_original_field = "8EB270C9F563D321A859C4EC562316B4", hash_generated_field = "CCF630C83B80C2F4393E963314F2D0FE")

    private boolean         mAllowContentAccess = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.180 -0500", hash_original_field = "EC1C316612F13EE5105CDD5C805576F6", hash_generated_field = "30FAFE3A56A71716731F01CEE7EBDBC8")

    private boolean         mLoadWithOverviewMode = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.183 -0500", hash_original_field = "5663AC0B3C47A97C3A1002EE952788C0", hash_generated_field = "0383F8FCA39790900B8C6F17CB8C8ACE")

    private boolean         mEnableSmoothTransition = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.185 -0500", hash_original_field = "7615093DA13E9581298D259EF5582767", hash_generated_field = "C83DD3856F6A01CD394571B6570E38C9")

    private boolean         mForceUserScalable = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.244 -0500", hash_original_field = "F9BF0F44B81A6D68005C70982169E059", hash_generated_field = "91C6393A6B49848292FD9CB7AF58B0CD")

    private AutoFillProfile mAutoFillProfile;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.246 -0500", hash_original_field = "15A8F9FFC154A083A5DC202AABEB31E7", hash_generated_field = "73BE0F1D89639A62A6549ED3C0472D72")

    private boolean         mUseWebViewBackgroundForOverscroll = true;

    /**
     * Package constructor to prevent clients from creating a new settings
     * instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.290 -0500", hash_original_method = "C5F77054875E8CE16379FFA130433105", hash_generated_method = "C5F77054875E8CE16379FFA130433105")
    
WebSettings(Context context, WebView webview) {
        mEventHandler = new EventHandler();
        mContext = context;
        mWebView = webview;
        mDefaultTextEncoding = context.getString(com.android.internal.
                                                 R.string.default_text_encoding);

        if (sLockForLocaleSettings == null) {
            sLockForLocaleSettings = new Object();
            sLocale = Locale.getDefault();
        }
        mAcceptLanguage = getCurrentAcceptLanguage();
        mUserAgent = getCurrentUserAgent();
        mUseDefaultUserAgent = true;

        mBlockNetworkLoads = mContext.checkPermission(
                "android.permission.INTERNET", android.os.Process.myPid(),
                android.os.Process.myUid()) != PackageManager.PERMISSION_GRANTED;
    }

    /**
     * Looks at sLocale and returns current AcceptLanguage String.
     * @return Current AcceptLanguage String.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.295 -0500", hash_original_method = "4DE075F72507E4E460D500D800684FF5", hash_generated_method = "D5D1EBAD36E1F29CFFD3A846A6923F1C")
    
private String getCurrentAcceptLanguage() {
        Locale locale;
        synchronized(sLockForLocaleSettings) {
            locale = sLocale;
        }
        StringBuilder buffer = new StringBuilder();
        addLocaleToHttpAcceptLanguage(buffer, locale);

        if (!Locale.US.equals(locale)) {
            if (buffer.length() > 0) {
                buffer.append(", ");
            }
            buffer.append(ACCEPT_LANG_FOR_US_LOCALE);
        }

        return buffer.toString();
    }

    /**
     * Looks at sLocale and mContext and returns current UserAgent String.
     * @return Current UserAgent String.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.303 -0500", hash_original_method = "7A96EBBEB91D958845CC53A11C0AF344", hash_generated_method = "AD198F5268FD9D3CBF291F692E34E855")
    
private synchronized String getCurrentUserAgent() {
        Locale locale;
        synchronized(sLockForLocaleSettings) {
            locale = sLocale;
        }
        StringBuffer buffer = new StringBuffer();
        // Add version
        final String version = Build.VERSION.RELEASE;
        if (version.length() > 0) {
            if (Character.isDigit(version.charAt(0))) {
                // Release is a version, eg "3.1"
                buffer.append(version);
            } else {
                // Release is a codename, eg "Honeycomb"
                // In this case, use the previous release's version
                buffer.append(PREVIOUS_VERSION);
            }
        } else {
            // default to "1.0"
            buffer.append("1.0");
        }
        buffer.append("; ");
        final String language = locale.getLanguage();
        if (language != null) {
            buffer.append(convertObsoleteLanguageCodeToNew(language));
            final String country = locale.getCountry();
            if (country != null) {
                buffer.append("-");
                buffer.append(country.toLowerCase());
            }
        } else {
            // default to "en"
            buffer.append("en");
        }
        buffer.append(";");
        // add the model for the release build
        if ("REL".equals(Build.VERSION.CODENAME)) {
            final String model = Build.MODEL;
            if (model.length() > 0) {
                buffer.append(" ");
                buffer.append(model);
            }
        }
        final String id = Build.ID;
        if (id.length() > 0) {
            buffer.append(" Build/");
            buffer.append(id);
        }
        String mobile = mContext.getResources().getText(
            com.android.internal.R.string.web_user_agent_target_content).toString();
        final String base = mContext.getResources().getText(
                com.android.internal.R.string.web_user_agent).toString();
        return String.format(base, buffer, mobile);
    }

    /**
     * Enables dumping the pages navigation cache to a text file.
     * @deprecated This method is now obsolete.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.306 -0500", hash_original_method = "0785CD668E13EDF5998305462A035DB6", hash_generated_method = "1ED1C4E56A5F20E5C4ECA2F9C0273EB8")
    
@Deprecated
    public void setNavDump(boolean enabled) {
        mNavDump = enabled;
    }

    /**
     * Returns true if dumping the navigation cache is enabled.
     * @deprecated This method is now obsolete.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.308 -0500", hash_original_method = "8B24B3626FE4D070605B6C1E8E9774B6", hash_generated_method = "19E2DFBF582E3B8305E80F5E04625E02")
    
@Deprecated
    public boolean getNavDump() {
        return mNavDump;
    }

    /**
     * If WebView only supports touch, a different navigation model will be
     * applied. Otherwise, the navigation to support both touch and keyboard
     * will be used.
     * @hide
    public void setSupportTouchOnly(boolean touchOnly) {
        mSupportTounchOnly = touchOnly;
    }
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.311 -0500", hash_original_method = "BB54171E3BDD4A64CB98C2709AC39B9C", hash_generated_method = "30FA8E53333FFE1729FB8BEBBBD32F1A")
    
boolean supportTouchOnly() {
        // for debug only, use mLightTouchEnabled for mSupportTounchOnly
        return mLightTouchEnabled;
    }

    /**
     * Set whether the WebView supports zoom
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.313 -0500", hash_original_method = "6B7C7B097AE4AF077C4ED1E2A5D10429", hash_generated_method = "9AD8CD43D414B15C5C81F48132666191")
    
public void setSupportZoom(boolean support) {
        mSupportZoom = support;
        mWebView.updateMultiTouchSupport(mContext);
    }

    /**
     * Returns whether the WebView supports zoom
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.315 -0500", hash_original_method = "A16213EC170C52C83CDC8BBC64DBFF18", hash_generated_method = "48EB9648F632D6ED0A760000CCAB3686")
    
public boolean supportZoom() {
        return mSupportZoom;
    }

    /**
     * Sets whether the zoom mechanism built into WebView is used.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.317 -0500", hash_original_method = "16CDF55EE98C899167571FFC15609D2B", hash_generated_method = "453D17A868C2DCA7A2E28D62ACBA5A60")
    
public void setBuiltInZoomControls(boolean enabled) {
        mBuiltInZoomControls = enabled;
        mWebView.updateMultiTouchSupport(mContext);
    }

    /**
     * Returns true if the zoom mechanism built into WebView is being used.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.319 -0500", hash_original_method = "9006048913C3ABECFF150ED9A10494B5", hash_generated_method = "7052AEF1DF079510771865F9C7B36911")
    
public boolean getBuiltInZoomControls() {
        return mBuiltInZoomControls;
    }

    /**
     * Sets whether the on screen zoom buttons are used.
     * A combination of built in zoom controls enabled
     * and on screen zoom controls disabled allows for pinch to zoom
     * to work without the on screen controls
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.321 -0500", hash_original_method = "8F17FB2A2C1E34D57B8A250CBF0EF944", hash_generated_method = "6BBB098D7BD846C0635D7A1D8FEE8E20")
    
public void setDisplayZoomControls(boolean enabled) {
        mDisplayZoomControls = enabled;
        mWebView.updateMultiTouchSupport(mContext);
    }

    /**
     * Returns true if the on screen zoom buttons are being used.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.323 -0500", hash_original_method = "AE5780336410432FB6F983F3F828E46C", hash_generated_method = "A41E69B3DF2C09E91610E41004AA82BD")
    
public boolean getDisplayZoomControls() {
        return mDisplayZoomControls;
    }

    /**
     * Enable or disable file access within WebView. File access is enabled by
     * default.  Note that this enables or disables file system access only.
     * Assets and resources are still accessible using file:///android_asset and
     * file:///android_res.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.326 -0500", hash_original_method = "C265511540E520E57BDB53C1B101C5AC", hash_generated_method = "6EAB57A02C253FA6BB99EB43F6D5FBF7")
    
public void setAllowFileAccess(boolean allow) {
        mAllowFileAccess = allow;
    }

    /**
     * Returns true if this WebView supports file access.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.328 -0500", hash_original_method = "ED281F9FC327C1DCA93656D122E60B6E", hash_generated_method = "30259FAD0B20AD9CA27FA6EF18E78CE4")
    
public boolean getAllowFileAccess() {
        return mAllowFileAccess;
    }

    /**
     * Enable or disable content url access within WebView.  Content url access
     * allows WebView to load content from a content provider installed in the
     * system.  The default is enabled.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.330 -0500", hash_original_method = "1A30AACA222993CDBB39CAF3A548FAE3", hash_generated_method = "BAD88B9C84F1036B2088F307434C3325")
    
public void setAllowContentAccess(boolean allow) {
        mAllowContentAccess = allow;
    }

    /**
     * Returns true if this WebView supports content url access.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.332 -0500", hash_original_method = "E20572D9D9FCBBCAC622C44A2D9C5369", hash_generated_method = "EF6D0A86AAB5DE9EAA850EFBB0225966")
    
public boolean getAllowContentAccess() {
        return mAllowContentAccess;
    }

    /**
     * Set whether the WebView loads a page with overview mode.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.334 -0500", hash_original_method = "E0C53B0ABBE8903B8C2E5235B7766B9A", hash_generated_method = "7B1D9F67211909D027A50F5CB000A22C")
    
public void setLoadWithOverviewMode(boolean overview) {
        mLoadWithOverviewMode = overview;
    }

    /**
     * Returns true if this WebView loads page with overview mode
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.337 -0500", hash_original_method = "0D409EAD2B46C91908C9804617827D1C", hash_generated_method = "F5C533330A8FCAA3E2FF0B9A80758961")
    
public boolean getLoadWithOverviewMode() {
        return mLoadWithOverviewMode;
    }

    /**
     * Set whether the WebView will enable smooth transition while panning or
     * zooming or while the window hosting the WebView does not have focus.
     * If it is true, WebView will choose a solution to maximize the performance.
     * e.g. the WebView's content may not be updated during the transition.
     * If it is false, WebView will keep its fidelity. The default value is false.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.339 -0500", hash_original_method = "B5CB73D3FC09526DD6AE502765086798", hash_generated_method = "7B89024F10DF53E1DF74BDD8C0486431")
    
public void setEnableSmoothTransition(boolean enable) {
        mEnableSmoothTransition = enable;
    }

    /**
     * Returns true if the WebView enables smooth transition while panning or
     * zooming.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.341 -0500", hash_original_method = "FB45006D48B3F1A32CF7E83242DDAE7D", hash_generated_method = "4180CD48B508CABA71939068D3A8490E")
    
public boolean enableSmoothTransition() {
        return mEnableSmoothTransition;
    }

    /**
     * Set whether the WebView uses its background for over scroll background.
     * If true, it will use the WebView's background. If false, it will use an
     * internal pattern. Default is true.
     * @deprecated This method is now obsolete.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.343 -0500", hash_original_method = "6C4A8C912B988582A0E8E6FECC7FBF9C", hash_generated_method = "6BEB804CCDC6C20C8662456A20EE0337")
    
@Deprecated
    public void setUseWebViewBackgroundForOverscrollBackground(boolean view) {
        mUseWebViewBackgroundForOverscroll = view;
    }

    /**
     * Returns true if this WebView uses WebView's background instead of
     * internal pattern for over scroll background.
     * @deprecated This method is now obsolete.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.345 -0500", hash_original_method = "FE1757AAD5E1DD702744237E901A55C8", hash_generated_method = "8289F9644AED63A7452D5290A5F174F9")
    
@Deprecated
    public boolean getUseWebViewBackgroundForOverscrollBackground() {
        return mUseWebViewBackgroundForOverscroll;
    }

    /**
     * Store whether the WebView is saving form data.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.348 -0500", hash_original_method = "BAE3B161CD7589698136E106A2876792", hash_generated_method = "374F121303AD8BD6516B2DBD6D8CB63E")
    
public void setSaveFormData(boolean save) {
        mSaveFormData = save;
    }

    /**
     *  Return whether the WebView is saving form data and displaying prior
     *  entries/autofill++.  Always false in private browsing mode.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.350 -0500", hash_original_method = "4DFFD3713A8D682938D03E8713A587EF", hash_generated_method = "55BCA0F4D999A0DECEFC6DA3C4039B63")
    
public boolean getSaveFormData() {
        return mSaveFormData && !mPrivateBrowsingEnabled;
    }

    /**
     *  Store whether the WebView is saving password.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.352 -0500", hash_original_method = "B2DE3A754D34523602EAE606838B5563", hash_generated_method = "C270DE2E6B44D4B1AA54E72FEE5E1D4B")
    
public void setSavePassword(boolean save) {
        mSavePassword = save;
    }

    /**
     *  Return whether the WebView is saving password.
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.354 -0500", hash_original_method = "7EDF9AC2E1EDCCF642364DB0CD31765F", hash_generated_method = "DFDBCAE925F4C9D0FA74D873C0BB68DA")
    
public boolean getSavePassword() {
        return mSavePassword;
    }

    /**
     * Set the text zoom of the page in percent. Default is 100.
     * @param textZoom A percent value for increasing or decreasing the text.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.357 -0500", hash_original_method = "C5C41A533FE351F2D45D268D5D267050", hash_generated_method = "34CDDF998E1395E85F175D7A7F078FF3")
    
public synchronized void setTextZoom(int textZoom) {
        if (mTextSize != textZoom) {
            if (WebView.mLogEvent) {
                EventLog.writeEvent(EventLogTags.BROWSER_TEXT_SIZE_CHANGE,
                        mTextSize, textZoom);
            }
            mTextSize = textZoom;
            postSync();
        }
    }

    /**
     * Get the text zoom of the page in percent.
     * @return A percent value describing the text zoom.
     * @see setTextSizeZoom
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.360 -0500", hash_original_method = "570564B346A8D968406F236CA99E37F6", hash_generated_method = "3851039882C8F893E2B37DA735B5917D")
    
public synchronized int getTextZoom() {
        return mTextSize;
    }

    /**
     * Set the text size of the page.
     * @param t A TextSize value for increasing or decreasing the text.
     * @see WebSettings.TextSize
     * @deprecated Use {@link #setTextZoom(int)} instead
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.362 -0500", hash_original_method = "D3E0150ED5C00CC3B22240870480363B", hash_generated_method = "26674E2565B39A5506971B76D0B074D1")
    
public synchronized void setTextSize(TextSize t) {
        setTextZoom(t.value);
    }

    /**
     * Get the text size of the page. If the text size was previously specified
     * in percent using {@link #setTextZoom(int)}, this will return
     * the closest matching {@link TextSize}.
     * @return A TextSize enum value describing the text size.
     * @see WebSettings.TextSize
     * @deprecated Use {@link #getTextZoom()} instead
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.364 -0500", hash_original_method = "900BE61F6B80F2B5D843AC6DC18F9D15", hash_generated_method = "7330C44380363093344F21F2948A3635")
    
public synchronized TextSize getTextSize() {
        TextSize closestSize = null;
        int smallestDelta = Integer.MAX_VALUE;
        for (TextSize size : TextSize.values()) {
            int delta = Math.abs(mTextSize - size.value);
            if (delta == 0) {
                return size;
            }
            if (delta < smallestDelta) {
                smallestDelta = delta;
                closestSize = size;
            }
        }
        return closestSize != null ? closestSize : TextSize.NORMAL;
    }

    /**
     * Set the double-tap zoom of the page in percent. Default is 100.
     * @param doubleTapZoom A percent value for increasing or decreasing the double-tap zoom.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.366 -0500", hash_original_method = "E23B2F666BB6D09A8C611DD5B37D2698", hash_generated_method = "E3C2C633BD5C0EF0E7DDD3143A4C7C27")
    
public void setDoubleTapZoom(int doubleTapZoom) {
        if (mDoubleTapZoom != doubleTapZoom) {
            mDoubleTapZoom = doubleTapZoom;
            mWebView.updateDoubleTapZoom(doubleTapZoom);
        }
    }

    /**
     * Get the double-tap zoom of the page in percent.
     * @return A percent value describing the double-tap zoom.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.368 -0500", hash_original_method = "137930918FD91EA20A5F57296DD24AFB", hash_generated_method = "29E8BC3EC5F37E6B1D32F30AAB0AA78C")
    
public int getDoubleTapZoom() {
        return mDoubleTapZoom;
    }

    /**
     * Set the default zoom density of the page. This should be called from UI
     * thread.
     * @param zoom A ZoomDensity value
     * @see WebSettings.ZoomDensity
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.371 -0500", hash_original_method = "E4C2219CCE12A9777A4354402A44D34B", hash_generated_method = "7DD95B47792C351F1270E1C2CF4E09F1")
    
public void setDefaultZoom(ZoomDensity zoom) {
        if (mDefaultZoom != zoom) {
            mDefaultZoom = zoom;
            mWebView.adjustDefaultZoomDensity(zoom.value);
        }
    }

    /**
     * Get the default zoom density of the page. This should be called from UI
     * thread.
     * @return A ZoomDensity value
     * @see WebSettings.ZoomDensity
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.373 -0500", hash_original_method = "72EF0E181D832EBBD7F53BEF96096C0C", hash_generated_method = "2F7D6E13DB962E2EDD14215004AF0075")
    
public ZoomDensity getDefaultZoom() {
        return mDefaultZoom;
    }

    /**
     * Enables using light touches to make a selection and activate mouseovers.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.375 -0500", hash_original_method = "DFD74C15B6ACEBABFCBAF5FDE1C7D76D", hash_generated_method = "0C9681C853FDF3FA64864BA9E5522304")
    
public void setLightTouchEnabled(boolean enabled) {
        mLightTouchEnabled = enabled;
    }

    /**
     * Returns true if light touches are enabled.
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.377 -0500", hash_original_method = "02D840FF3CC8AE7A6DEC323EC455B33B", hash_generated_method = "97DEB8544A719CE299C898A07019007B")
    
public boolean getLightTouchEnabled() {
        return mLightTouchEnabled;
    }

    /**
     * @deprecated This setting controlled a rendering optimization
     * that is no longer present. Setting it now has no effect.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.380 -0500", hash_original_method = "EF2600D8826AB6D5A4057F05D8E61936", hash_generated_method = "A8402E45618CCE73034E12791CE0CCEB")
    
@Deprecated
    public synchronized void setUseDoubleTree(boolean use) {
        return;
    }

    /**
     * @deprecated This setting controlled a rendering optimization
     * that is no longer present. Setting it now has no effect.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.382 -0500", hash_original_method = "89BCC0409F823F147F01A4F485C1EC58", hash_generated_method = "042EB0942AD4C517C1F85FD13F3D4FD6")
    
@Deprecated
    public synchronized boolean getUseDoubleTree() {
        return false;
    }

    /**
     * Tell the WebView about user-agent string.
     * @param ua 0 if the WebView should use an Android user-agent string,
     *           1 if the WebView should use a desktop user-agent string.
     *
     * @deprecated Please use setUserAgentString instead.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.385 -0500", hash_original_method = "85DE35A00A5168FE5C8491B5E07C3BBE", hash_generated_method = "5A20129D5041615DB99A7F2AABFB035A")
    
@Deprecated
    public synchronized void setUserAgent(int ua) {
        String uaString = null;
        if (ua == 1) {
            if (DESKTOP_USERAGENT.equals(mUserAgent)) {
                return; // do nothing
            } else {
                uaString = DESKTOP_USERAGENT;
            }
        } else if (ua == 2) {
            if (IPHONE_USERAGENT.equals(mUserAgent)) {
                return; // do nothing
            } else {
                uaString = IPHONE_USERAGENT;
            }
        } else if (ua != 0) {
            return; // do nothing
        }
        setUserAgentString(uaString);
    }

    /**
     * Return user-agent as int
     * @return int  0 if the WebView is using an Android user-agent string.
     *              1 if the WebView is using a desktop user-agent string.
     *             -1 if the WebView is using user defined user-agent string.
     *
     * @deprecated Please use getUserAgentString instead.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.388 -0500", hash_original_method = "622085E3817D576D67ED6E0D62241C79", hash_generated_method = "77F5F641BACFAC349810A793F99745D6")
    
@Deprecated
    public synchronized int getUserAgent() {
        if (DESKTOP_USERAGENT.equals(mUserAgent)) {
            return 1;
        } else if (IPHONE_USERAGENT.equals(mUserAgent)) {
            return 2;
        } else if (mUseDefaultUserAgent) {
            return 0;
        }
        return -1;
    }

    /**
     * Tell the WebView to use the wide viewport
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.390 -0500", hash_original_method = "6232B93EE163514DA7A8F2A20C0E8296", hash_generated_method = "BD81717A1BA5C3C98CA5A5EEAC0936CC")
    
public synchronized void setUseWideViewPort(boolean use) {
        if (mUseWideViewport != use) {
            mUseWideViewport = use;
            postSync();
        }
    }

    /**
     * @return True if the WebView is using a wide viewport
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.392 -0500", hash_original_method = "B42FD143593B620F53C7027879473593", hash_generated_method = "A58A871EB2E941B1C191C2918F873456")
    
public synchronized boolean getUseWideViewPort() {
        return mUseWideViewport;
    }

    /**
     * Tell the WebView whether it supports multiple windows. TRUE means
     *         that {@link WebChromeClient#onCreateWindow(WebView, boolean,
     *         boolean, Message)} is implemented by the host application.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.395 -0500", hash_original_method = "961D9442BDC4ECD4A72AED0ECCABFF49", hash_generated_method = "B8D1D240AF936A1BB26B061120F203D3")
    
public synchronized void setSupportMultipleWindows(boolean support) {
        if (mSupportMultipleWindows != support) {
            mSupportMultipleWindows = support;
            postSync();
        }
    }

    /**
     * @return True if the WebView is supporting multiple windows. This means
     *         that {@link WebChromeClient#onCreateWindow(WebView, boolean,
     *         boolean, Message)} is implemented by the host application.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.397 -0500", hash_original_method = "DC8997F98FC697774C788E0E9C368A15", hash_generated_method = "3FDA22F78C845110AFC07AF4DFB50C60")
    
public synchronized boolean supportMultipleWindows() {
        return mSupportMultipleWindows;
    }

    /**
     * Set the underlying layout algorithm. This will cause a relayout of the
     * WebView.
     * @param l A LayoutAlgorithm enum specifying the algorithm to use.
     * @see WebSettings.LayoutAlgorithm
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.400 -0500", hash_original_method = "CF796A65BC60375130249D0138E0D269", hash_generated_method = "21FA9987DF9E97ABC147232480071C35")
    
public synchronized void setLayoutAlgorithm(LayoutAlgorithm l) {
        // XXX: This will only be affective if libwebcore was built with
        // ANDROID_LAYOUT defined.
        if (mLayoutAlgorithm != l) {
            mLayoutAlgorithm = l;
            postSync();
        }
    }

    /**
     * Return the current layout algorithm. The default is NARROW_COLUMNS.
     * @return LayoutAlgorithm enum value describing the layout algorithm
     *         being used.
     * @see WebSettings.LayoutAlgorithm
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.402 -0500", hash_original_method = "D199B05491A7568F9921CD10D25BC54E", hash_generated_method = "4D9FC41B9BD4A7CD6B0298B3809ED317")
    
public synchronized LayoutAlgorithm getLayoutAlgorithm() {
        return mLayoutAlgorithm;
    }

    /**
     * Set the standard font family name.
     * @param font A font family name.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.405 -0500", hash_original_method = "80141FBB7709CEF61745CB878BA8248B", hash_generated_method = "BBE35AE0A4C3F616859A098B850F814A")
    
public synchronized void setStandardFontFamily(String font) {
        if (font != null && !font.equals(mStandardFontFamily)) {
            mStandardFontFamily = font;
            postSync();
        }
    }

    /**
     * Get the standard font family name. The default is "sans-serif".
     * @return The standard font family name as a string.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.407 -0500", hash_original_method = "D17418EAB461A3931F0EFDEA802C4808", hash_generated_method = "8AB0D7D50ECAE13000C532ACD7A083C0")
    
public synchronized String getStandardFontFamily() {
        return mStandardFontFamily;
    }

    /**
     * Set the fixed font family name.
     * @param font A font family name.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.409 -0500", hash_original_method = "85832E987C30A09FD65E322D8A53532D", hash_generated_method = "C6DA933573E28719AB4383F977F4A653")
    
public synchronized void setFixedFontFamily(String font) {
        if (font != null && !font.equals(mFixedFontFamily)) {
            mFixedFontFamily = font;
            postSync();
        }
    }

    /**
     * Get the fixed font family name. The default is "monospace".
     * @return The fixed font family name as a string.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.411 -0500", hash_original_method = "91A5D658AFF46E5675EE0251B0448A37", hash_generated_method = "EAC405FC7AE9DE5891C6EF323CCD9DB9")
    
public synchronized String getFixedFontFamily() {
        return mFixedFontFamily;
    }

    /**
     * Set the sans-serif font family name.
     * @param font A font family name.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.413 -0500", hash_original_method = "5317C7E81FFF6267D702DE0B9A35C25F", hash_generated_method = "25D6FAA1759C86F4AE7ED9323BE65A61")
    
public synchronized void setSansSerifFontFamily(String font) {
        if (font != null && !font.equals(mSansSerifFontFamily)) {
            mSansSerifFontFamily = font;
            postSync();
        }
    }

    /**
     * Get the sans-serif font family name.
     * @return The sans-serif font family name as a string.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.416 -0500", hash_original_method = "E8B035ABC4C315E7FC00763BCE4B3101", hash_generated_method = "420A0256498ED8F222DA11E7A1F54653")
    
public synchronized String getSansSerifFontFamily() {
        return mSansSerifFontFamily;
    }

    /**
     * Set the serif font family name. The default is "sans-serif".
     * @param font A font family name.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.418 -0500", hash_original_method = "B0B03F3832ADF5F3F163E426E788DEB1", hash_generated_method = "F4F841A100E3C1A3AB3A0479AE0976FD")
    
public synchronized void setSerifFontFamily(String font) {
        if (font != null && !font.equals(mSerifFontFamily)) {
            mSerifFontFamily = font;
            postSync();
        }
    }

    /**
     * Get the serif font family name. The default is "serif".
     * @return The serif font family name as a string.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.421 -0500", hash_original_method = "AEE55B3207D2A837254BD0F18E5F431B", hash_generated_method = "EB212C4FC1BC412E275779077C20B9D0")
    
public synchronized String getSerifFontFamily() {
        return mSerifFontFamily;
    }

    /**
     * Set the cursive font family name.
     * @param font A font family name.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.423 -0500", hash_original_method = "8334AD5BA97572A472DE2E88CF457E83", hash_generated_method = "DDFDC684E07E3A3050564B9AF1FF37FC")
    
public synchronized void setCursiveFontFamily(String font) {
        if (font != null && !font.equals(mCursiveFontFamily)) {
            mCursiveFontFamily = font;
            postSync();
        }
    }

    /**
     * Get the cursive font family name. The default is "cursive".
     * @return The cursive font family name as a string.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.425 -0500", hash_original_method = "A9100EF4E222FCE0DCE66A7BF6E9785C", hash_generated_method = "8EC87EE29FD2BA8526A5079960F56B49")
    
public synchronized String getCursiveFontFamily() {
        return mCursiveFontFamily;
    }

    /**
     * Set the fantasy font family name.
     * @param font A font family name.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.427 -0500", hash_original_method = "3BEE212C0CAB12BA1830E10645682B81", hash_generated_method = "2CCBA696207916A9702E5917EF89FD64")
    
public synchronized void setFantasyFontFamily(String font) {
        if (font != null && !font.equals(mFantasyFontFamily)) {
            mFantasyFontFamily = font;
            postSync();
        }
    }

    /**
     * Get the fantasy font family name. The default is "fantasy".
     * @return The fantasy font family name as a string.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.430 -0500", hash_original_method = "3AB44712F248734E7DE5412E073462E0", hash_generated_method = "907EDD7E694853E4C8A8C8BADC6B3B62")
    
public synchronized String getFantasyFontFamily() {
        return mFantasyFontFamily;
    }

    /**
     * Set the minimum font size.
     * @param size A non-negative integer between 1 and 72.
     * Any number outside the specified range will be pinned.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.433 -0500", hash_original_method = "5B2F36FEBD6497C3F70A8544117DF67F", hash_generated_method = "6038C465367AEE91392A238F0263C7CE")
    
public synchronized void setMinimumFontSize(int size) {
        size = pin(size);
        if (mMinimumFontSize != size) {
            mMinimumFontSize = size;
            postSync();
        }
    }

    /**
     * Get the minimum font size. The default is 8.
     * @return A non-negative integer between 1 and 72.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.435 -0500", hash_original_method = "9F0281C9F2E3CE3701E30B7BA1EEFCDC", hash_generated_method = "F02F2F9D91896664EF85B09121C14133")
    
public synchronized int getMinimumFontSize() {
        return mMinimumFontSize;
    }

    /**
     * Set the minimum logical font size.
     * @param size A non-negative integer between 1 and 72.
     * Any number outside the specified range will be pinned.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.437 -0500", hash_original_method = "979D72ED8DED37C47A363976CA577A0C", hash_generated_method = "47CD283DBC4519C15D2D1E9407252411")
    
public synchronized void setMinimumLogicalFontSize(int size) {
        size = pin(size);
        if (mMinimumLogicalFontSize != size) {
            mMinimumLogicalFontSize = size;
            postSync();
        }
    }

    /**
     * Get the minimum logical font size. The default is 8.
     * @return A non-negative integer between 1 and 72.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.439 -0500", hash_original_method = "4108641CDFB7F27DEA848BE579464C88", hash_generated_method = "240038214F0E411E6E2BC4567245104E")
    
public synchronized int getMinimumLogicalFontSize() {
        return mMinimumLogicalFontSize;
    }

    /**
     * Set the default font size.
     * @param size A non-negative integer between 1 and 72.
     * Any number outside the specified range will be pinned.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.442 -0500", hash_original_method = "F015D29DAD166EF30FCB62EA8F22BD34", hash_generated_method = "D70ABF734D51BE470D682320EB40CA12")
    
public synchronized void setDefaultFontSize(int size) {
        size = pin(size);
        if (mDefaultFontSize != size) {
            mDefaultFontSize = size;
            postSync();
        }
    }

    /**
     * Get the default font size. The default is 16.
     * @return A non-negative integer between 1 and 72.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.444 -0500", hash_original_method = "DC87CC6F42B19166FD6192BC9DCDB609", hash_generated_method = "DC76C3D3B64133542193793604A7FC78")
    
public synchronized int getDefaultFontSize() {
        return mDefaultFontSize;
    }

    /**
     * Set the default fixed font size.
     * @param size A non-negative integer between 1 and 72.
     * Any number outside the specified range will be pinned.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.447 -0500", hash_original_method = "F38EE7285BA7C36F298A402033D20C39", hash_generated_method = "034D5A1D1EF8184F99E5FD8BFFCC70EE")
    
public synchronized void setDefaultFixedFontSize(int size) {
        size = pin(size);
        if (mDefaultFixedFontSize != size) {
            mDefaultFixedFontSize = size;
            postSync();
        }
    }

    /**
     * Get the default fixed font size. The default is 16.
     * @return A non-negative integer between 1 and 72.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.449 -0500", hash_original_method = "32FF94F6134070C3A3BF7D6E4734C806", hash_generated_method = "292874B061AC5D054B89E83D989276F6")
    
public synchronized int getDefaultFixedFontSize() {
        return mDefaultFixedFontSize;
    }

    /**
     * Set the number of pages cached by the WebKit for the history navigation.
     * @param size A non-negative integer between 0 (no cache) and 20 (max).
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.451 -0500", hash_original_method = "E6659EF50725F66F9827ED33E4CFAB21", hash_generated_method = "82A17BCAF37980A7B7BE85F2543DE0A4")
    
public synchronized void setPageCacheCapacity(int size) {
        if (size < 0) size = 0;
        if (size > 20) size = 20;
        if (mPageCacheCapacity != size) {
            mPageCacheCapacity = size;
            postSync();
        }
    }

    /**
     * Tell the WebView to load image resources automatically.
     * @param flag True if the WebView should load images automatically.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.453 -0500", hash_original_method = "4253364D9E80624081FA0E0F6FDC86F7", hash_generated_method = "AC9FFE49204370E93407FB748B46A39C")
    
public synchronized void setLoadsImagesAutomatically(boolean flag) {
        if (mLoadsImagesAutomatically != flag) {
            mLoadsImagesAutomatically = flag;
            postSync();
        }
    }

    /**
     * Return true if the WebView will load image resources automatically.
     * The default is true.
     * @return True if the WebView loads images automatically.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.456 -0500", hash_original_method = "55A6CB81C4460FAFC4A6B0D4FAE1ED88", hash_generated_method = "22F860787F5E83D0008D0F2B13952CED")
    
public synchronized boolean getLoadsImagesAutomatically() {
        return mLoadsImagesAutomatically;
    }

    /**
     * Tell the WebView to block network images. This is only checked when
     * {@link #getLoadsImagesAutomatically} is true. If you set the value to
     * false, images will automatically be loaded. Use this api to reduce
     * bandwidth only. Use {@link #setBlockNetworkLoads} if possible.
     * @param flag True if the WebView should block network images.
     * @see #setBlockNetworkLoads
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.458 -0500", hash_original_method = "D93A9FC6AE1462BC3A72CE8E390FD0F6", hash_generated_method = "9B1A73EE85AC1CE2093B761161428E40")
    
public synchronized void setBlockNetworkImage(boolean flag) {
        if (mBlockNetworkImage != flag) {
            mBlockNetworkImage = flag;
            postSync();
        }
    }

    /**
     * Return true if the WebView will block network images. The default is
     * false.
     * @return True if the WebView blocks network images.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.460 -0500", hash_original_method = "20F3224FE4B0DC8AEBED4FF3568A3BDD", hash_generated_method = "D33FDA00479132B2DD7020BEED6A24D5")
    
public synchronized boolean getBlockNetworkImage() {
        return mBlockNetworkImage;
    }

    /**
     * Tell the WebView to block all network load requests. If you set the
     * value to false, you must call {@link android.webkit.WebView#reload} to
     * fetch remote resources. This flag supercedes the value passed to
     * {@link #setBlockNetworkImage}.
     * @param flag True if the WebView should block all network loads.
     * @see android.webkit.WebView#reload
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.463 -0500", hash_original_method = "244EC0C47571696247D156D16BFFBF27", hash_generated_method = "CA8BC5A93FED9DE83E10165922E6520A")
    
public synchronized void setBlockNetworkLoads(boolean flag) {
        if (mBlockNetworkLoads != flag) {
            mBlockNetworkLoads = flag;
            verifyNetworkAccess();
            postSync();
        }
    }

    /**
     * Return true if the WebView will block all network loads. The default is
     * false.
     * @return True if the WebView blocks all network loads.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.466 -0500", hash_original_method = "8F98673864D7321D7FB7DE6793DC0EC8", hash_generated_method = "4DFA294954CD12EA459D621110C3B79F")
    
public synchronized boolean getBlockNetworkLoads() {
        return mBlockNetworkLoads;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.468 -0500", hash_original_method = "4445E93EF699C8E4DE794753E49CA477", hash_generated_method = "F3CB4EF725F885ADC8E7FC9F51F629AC")
    
private void verifyNetworkAccess() {
        if (!mBlockNetworkLoads) {
            if (mContext.checkPermission("android.permission.INTERNET",
                    android.os.Process.myPid(), android.os.Process.myUid()) !=
                        PackageManager.PERMISSION_GRANTED) {
                throw new SecurityException
                        ("Permission denied - " +
                                "application missing INTERNET permission");
            }
        }
    }

    /**
     * Tell the WebView to enable javascript execution.
     * @param flag True if the WebView should execute javascript.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.470 -0500", hash_original_method = "0BBFCDC224ADE5D71512B3B9C5FED4DC", hash_generated_method = "524201A68D16D11518F913CE7AD4EBEF")
    
public synchronized void setJavaScriptEnabled(boolean flag) {
        if (mJavaScriptEnabled != flag) {
            mJavaScriptEnabled = flag;
            postSync();
        }
    }

    /**
     * Tell the WebView to use Skia's hardware accelerated rendering path
     * @param flag True if the WebView should use Skia's hw-accel path
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.473 -0500", hash_original_method = "8A9F66ACB83E46F66732CB0783F8BD97", hash_generated_method = "C3EDDB666193A8F6F3ED6373D80F742F")
    
public synchronized void setHardwareAccelSkiaEnabled(boolean flag) {
        if (mHardwareAccelSkia != flag) {
            mHardwareAccelSkia = flag;
            postSync();
        }
    }

    /**
     * @return True if the WebView is using hardware accelerated skia
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.475 -0500", hash_original_method = "B41E73346B4841FDA1F28A35C0158347", hash_generated_method = "106CDB92CC6CF8804C00E81EB334E5A5")
    
public synchronized boolean getHardwareAccelSkiaEnabled() {
        return mHardwareAccelSkia;
    }

    /**
     * Tell the WebView to show the visual indicator
     * @param flag True if the WebView should show the visual indicator
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.478 -0500", hash_original_method = "69FE03F7A269EF1D16FCCD39ECE7D049", hash_generated_method = "C7D178F31BF02A3045E1DCFF2A10E136")
    
public synchronized void setShowVisualIndicator(boolean flag) {
        if (mShowVisualIndicator != flag) {
            mShowVisualIndicator = flag;
            postSync();
        }
    }

    /**
     * @return True if the WebView is showing the visual indicator
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.480 -0500", hash_original_method = "C63472D12B908062A1CEAE79E75779C9", hash_generated_method = "067E1661DB89FFFD879A7FD73C252419")
    
public synchronized boolean getShowVisualIndicator() {
        return mShowVisualIndicator;
    }

    /**
     * Tell the WebView to enable plugins.
     * @param flag True if the WebView should load plugins.
     * @deprecated This method has been deprecated in favor of
     *             {@link #setPluginState}
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.482 -0500", hash_original_method = "05BB2A888D33554F620DCC4B01FA7575", hash_generated_method = "7461C8ED1C8F8E6B27DC9B3787E39193")
    
@Deprecated
    public synchronized void setPluginsEnabled(boolean flag) {
        setPluginState(flag ? PluginState.ON : PluginState.OFF);
    }

    /**
     * Tell the WebView to enable, disable, or have plugins on demand. On
     * demand mode means that if a plugin exists that can handle the embedded
     * content, a placeholder icon will be shown instead of the plugin. When
     * the placeholder is clicked, the plugin will be enabled.
     * @param state One of the PluginState values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.484 -0500", hash_original_method = "DB94ACE3494108D6193A811AD96FC597", hash_generated_method = "90D058A60485E3C28A6F95B5035C5E04")
    
public synchronized void setPluginState(PluginState state) {
        if (mPluginState != state) {
            mPluginState = state;
            postSync();
        }
    }

    /**
     * Set a custom path to plugins used by the WebView. This method is
     * obsolete since each plugin is now loaded from its own package.
     * @param pluginsPath String path to the directory containing plugins.
     * @deprecated This method is no longer used as plugins are loaded from
     * their own APK via the system's package manager.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.486 -0500", hash_original_method = "773787F5C9956C3834DA2A6EB4286614", hash_generated_method = "8580260891D2C5421E7A8531AEDC7437")
    
@Deprecated
    public synchronized void setPluginsPath(String pluginsPath) {
    }

    /**
     * Set the path to where database storage API databases should be saved.
     * Nota that the WebCore Database Tracker only allows the path to be set once.
     * This will update WebCore when the Sync runs in the C++ side.
     * @param databasePath String path to the directory where databases should
     *     be saved. May be the empty string but should never be null.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.488 -0500", hash_original_method = "AF758F2CA723722CB4C8BF68969FC2D2", hash_generated_method = "4A229586DD77F9D92E45A0C979D708C7")
    
public synchronized void setDatabasePath(String databasePath) {
        if (databasePath != null && !mDatabasePathHasBeenSet) {
            mDatabasePath = databasePath;
            mDatabasePathHasBeenSet = true;
            postSync();
        }
    }

    /**
     * Set the path where the Geolocation permissions database should be saved.
     * This will update WebCore when the Sync runs in the C++ side.
     * @param databasePath String path to the directory where the Geolocation
     *     permissions database should be saved. May be the empty string but
     *     should never be null.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.491 -0500", hash_original_method = "BC0F324C7AC101E200A0E358BDBC7AB1", hash_generated_method = "CF7F0406E6F8B2FBCE9A3886A3178382")
    
public synchronized void setGeolocationDatabasePath(String databasePath) {
        if (databasePath != null
                && !databasePath.equals(mGeolocationDatabasePath)) {
            mGeolocationDatabasePath = databasePath;
            postSync();
        }
    }

    /**
     * Tell the WebView to enable Application Caches API.
     * @param flag True if the WebView should enable Application Caches.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.493 -0500", hash_original_method = "F95CC1B9D2327BC5BCD822D16CE23DEA", hash_generated_method = "A237B22D53BB9DB29FA996286FD1DB72")
    
public synchronized void setAppCacheEnabled(boolean flag) {
        if (mAppCacheEnabled != flag) {
            mAppCacheEnabled = flag;
            postSync();
        }
    }

    /**
     * Set a custom path to the Application Caches files. The client
     * must ensure it exists before this call.
     * @param appCachePath String path to the directory containing Application
     * Caches files. The appCache path can be the empty string but should not
     * be null. Passing null for this parameter will result in a no-op.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.496 -0500", hash_original_method = "C7AB159C419EE425C63EEE7B4C162DEF", hash_generated_method = "8BC1287DCB498F5346C8D58E83E00AE9")
    
public synchronized void setAppCachePath(String appCachePath) {
        if (appCachePath != null && !appCachePath.equals(mAppCachePath)) {
            mAppCachePath = appCachePath;
            postSync();
        }
    }

    /**
     * Set the maximum size for the Application Caches content.
     * @param appCacheMaxSize the maximum size in bytes.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.498 -0500", hash_original_method = "55D93840C546554373F35F660C5755AC", hash_generated_method = "C7CE6446AD16091DCB65C9EDAFD655D8")
    
public synchronized void setAppCacheMaxSize(long appCacheMaxSize) {
        if (appCacheMaxSize != mAppCacheMaxSize) {
            mAppCacheMaxSize = appCacheMaxSize;
            postSync();
        }
    }

    /**
     * Set whether the database storage API is enabled.
     * @param flag boolean True if the WebView should use the database storage
     *     API.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.500 -0500", hash_original_method = "869B3AB9767C9688E84644FF6FE71246", hash_generated_method = "F1C90478C048ABB3C958D258165139E8")
    
public synchronized void setDatabaseEnabled(boolean flag) {
       if (mDatabaseEnabled != flag) {
           mDatabaseEnabled = flag;
           postSync();
       }
    }

    /**
     * Set whether the DOM storage API is enabled.
     * @param flag boolean True if the WebView should use the DOM storage
     *     API.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.504 -0500", hash_original_method = "1833A47C66872FD150B68FE6759B0625", hash_generated_method = "1B397F232832BAB51F84E88E830EBD22")
    
public synchronized void setDomStorageEnabled(boolean flag) {
       if (mDomStorageEnabled != flag) {
           mDomStorageEnabled = flag;
           postSync();
       }
    }

    /**
     * Returns true if the DOM Storage API's are enabled.
     * @return True if the DOM Storage API's are enabled.
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.506 -0500", hash_original_method = "F0262AC32F151E97C7BD7687A4F30118", hash_generated_method = "F0B7FEC19CB269EF1165CD91E1037221")
    
public synchronized boolean getDomStorageEnabled() {
       return mDomStorageEnabled;
    }

    /**
     * Return the path to where database storage API databases are saved for
     * the current WebView.
     * @return the String path to the database storage API databases.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.508 -0500", hash_original_method = "B06914FF8620CDD00A7D2E76B4DC9F8E", hash_generated_method = "87EAC204CC6B68884686301E790E61BE")
    
public synchronized String getDatabasePath() {
        return mDatabasePath;
    }

    /**
     * Returns true if database storage API is enabled.
     * @return True if the database storage API is enabled.
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.511 -0500", hash_original_method = "B3A6EABACA6DB5DAD1BC523D1F7D938A", hash_generated_method = "D8850798C61D194F4B4610C39B780BFE")
    
public synchronized boolean getDatabaseEnabled() {
        return mDatabaseEnabled;
    }

    /**
     * Tell the WebView to enable WebWorkers API.
     * @param flag True if the WebView should enable WebWorkers.
     * Note that this flag only affects V8. JSC does not have
     * an equivalent setting.
     * @hide pending api council approval
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.514 -0500", hash_original_method = "5C3A0FF2F7925F672A8F3BF470C8C1B9", hash_generated_method = "32BDC507BF2A8F06AC03ABDC3D3001D7")
    
public synchronized void setWorkersEnabled(boolean flag) {
        if (mWorkersEnabled != flag) {
            mWorkersEnabled = flag;
            postSync();
        }
    }

    /**
     * Sets whether Geolocation is enabled.
     * @param flag Whether Geolocation should be enabled.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.516 -0500", hash_original_method = "1B37EF49E1DD23D92EBFCAE289865E03", hash_generated_method = "E062D06DCF1B9315BFAB0238C41EB959")
    
public synchronized void setGeolocationEnabled(boolean flag) {
        if (mGeolocationEnabled != flag) {
            mGeolocationEnabled = flag;
            postSync();
        }
    }

    /**
     * Sets whether XSS Auditor is enabled.
     * @param flag Whether XSS Auditor should be enabled.
     * @hide Only used by LayoutTestController.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.518 -0500", hash_original_method = "ED4873F24C9B96C88ADEA94C6CEBF439", hash_generated_method = "EDFCD16C210F992598B6A6BF46B9E228")
    
public synchronized void setXSSAuditorEnabled(boolean flag) {
        if (mXSSAuditorEnabled != flag) {
            mXSSAuditorEnabled = flag;
            postSync();
        }
    }

    /**
     * Return true if javascript is enabled. <b>Note: The default is false.</b>
     * @return True if javascript is enabled.
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.521 -0500", hash_original_method = "0DFFCBD94870E084A8277321728F548A", hash_generated_method = "386B425E3B90586C8DF5805338BD8990")
    
public synchronized boolean getJavaScriptEnabled() {
        return mJavaScriptEnabled;
    }

    /**
     * Return true if plugins are enabled.
     * @return True if plugins are enabled.
     * @deprecated This method has been replaced by {@link #getPluginState}
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.523 -0500", hash_original_method = "71CDB5FC63B182B87115D2DBE9F21219", hash_generated_method = "F718732ADC4B59F490F77276C39DE9D3")
    
@Deprecated
    public synchronized boolean getPluginsEnabled() {
        return mPluginState == PluginState.ON;
    }

    /**
     * Return the current plugin state.
     * @return A value corresponding to the enum PluginState.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.525 -0500", hash_original_method = "F64B7B770EF5DD5F7B0D7EE789561CF2", hash_generated_method = "3CDDD47F65943A7750788C2AD0C07BAD")
    
public synchronized PluginState getPluginState() {
        return mPluginState;
    }

    /**
     * Returns the directory that contains the plugin libraries. This method is
     * obsolete since each plugin is now loaded from its own package.
     * @return An empty string.
     * @deprecated This method is no longer used as plugins are loaded from
     * their own APK via the system's package manager.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.527 -0500", hash_original_method = "9447E36E214BB4441498CEE16910C171", hash_generated_method = "4F7D3498F2B65D34F73E7508D7F64997")
    
@Deprecated
    public synchronized String getPluginsPath() {
        return "";
    }

    /**
     * Tell javascript to open windows automatically. This applies to the
     * javascript function window.open().
     * @param flag True if javascript can open windows automatically.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.529 -0500", hash_original_method = "4CDCF2B2AC7A9689B491AFCE4B80F0EB", hash_generated_method = "20103A70372DA9DB41D7236CE1950338")
    
public synchronized void setJavaScriptCanOpenWindowsAutomatically(
            boolean flag) {
        if (mJavaScriptCanOpenWindowsAutomatically != flag) {
            mJavaScriptCanOpenWindowsAutomatically = flag;
            postSync();
        }
    }

    /**
     * Return true if javascript can open windows automatically. The default
     * is false.
     * @return True if javascript can open windows automatically during
     *         window.open().
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.532 -0500", hash_original_method = "79E98D32B2FE915E7B4CD55D0B1C896F", hash_generated_method = "F2BAB3EA3C17525E4E5FE18A98C4F5BA")
    
public synchronized boolean getJavaScriptCanOpenWindowsAutomatically() {
        return mJavaScriptCanOpenWindowsAutomatically;
    }

    /**
     * Set the default text encoding name to use when decoding html pages.
     * @param encoding The text encoding name.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.534 -0500", hash_original_method = "A24B805E1ED21576385EF437050E004D", hash_generated_method = "634FC530BFFF1EB93642FBEE229C9DBA")
    
public synchronized void setDefaultTextEncodingName(String encoding) {
        if (encoding != null && !encoding.equals(mDefaultTextEncoding)) {
            mDefaultTextEncoding = encoding;
            postSync();
        }
    }

    /**
     * Get the default text encoding name. The default is "Latin-1".
     * @return The default text encoding name as a string.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.537 -0500", hash_original_method = "C5F48A0B5AD67EA38BD640610E4387AC", hash_generated_method = "55178E81379757A32B62E01F5D3B5F12")
    
public synchronized String getDefaultTextEncodingName() {
        return mDefaultTextEncoding;
    }

    /**
     * Set the WebView's user-agent string. If the string "ua" is null or empty,
     * it will use the system default user-agent string.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.539 -0500", hash_original_method = "EF76B53D37FAD17B99E355E5158D3AE3", hash_generated_method = "38208C7490CB56FF7A84B2C77C991B39")
    
public synchronized void setUserAgentString(String ua) {
        if (ua == null || ua.length() == 0) {
            synchronized(sLockForLocaleSettings) {
                Locale currentLocale = Locale.getDefault();
                if (!sLocale.equals(currentLocale)) {
                    sLocale = currentLocale;
                    mAcceptLanguage = getCurrentAcceptLanguage();
                }
            }
            ua = getCurrentUserAgent();
            mUseDefaultUserAgent = true;
        } else  {
            mUseDefaultUserAgent = false;
        }

        if (!ua.equals(mUserAgent)) {
            mUserAgent = ua;
            postSync();
        }
    }

    /**
     * Return the WebView's user-agent string.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.542 -0500", hash_original_method = "2522780DB5B181D072BE72836FEE2179", hash_generated_method = "027D4F5D53C7319A45641E54E2216A79")
    
public synchronized String getUserAgentString() {
        if (DESKTOP_USERAGENT.equals(mUserAgent) ||
                IPHONE_USERAGENT.equals(mUserAgent) ||
                !mUseDefaultUserAgent) {
            return mUserAgent;
        }

        boolean doPostSync = false;
        synchronized(sLockForLocaleSettings) {
            Locale currentLocale = Locale.getDefault();
            if (!sLocale.equals(currentLocale)) {
                sLocale = currentLocale;
                mUserAgent = getCurrentUserAgent();
                mAcceptLanguage = getCurrentAcceptLanguage();
                doPostSync = true;
            }
        }
        if (doPostSync) {
            postSync();
        }
        return mUserAgent;
    }

    /* package api to grab the Accept Language string. */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.544 -0500", hash_original_method = "D20FFE724413B630D767FC3330D85D9B", hash_generated_method = "4DA0FAACCA3DDF0498F542EEF44D6DB2")
    
synchronized String getAcceptLanguage() {
        synchronized(sLockForLocaleSettings) {
            Locale currentLocale = Locale.getDefault();
            if (!sLocale.equals(currentLocale)) {
                sLocale = currentLocale;
                mAcceptLanguage = getCurrentAcceptLanguage();
            }
        }
        return mAcceptLanguage;
    }

    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.547 -0500", hash_original_method = "1949FADEB987BBB9FFD42544F3D5731B", hash_generated_method = "1949FADEB987BBB9FFD42544F3D5731B")
    
boolean isNarrowColumnLayout() {
        return getLayoutAlgorithm() == LayoutAlgorithm.NARROW_COLUMNS;
    }

    /**
     * Tell the WebView whether it needs to set a node to have focus when
     * {@link WebView#requestFocus(int, android.graphics.Rect)} is called.
     *
     * @param flag
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.549 -0500", hash_original_method = "0197ABD852A904C83B0994DA40EDDF11", hash_generated_method = "FE8FFF19B91C09B1B2776F81D1D9319B")
    
public void setNeedInitialFocus(boolean flag) {
        if (mNeedInitialFocus != flag) {
            mNeedInitialFocus = flag;
        }
    }

    /* Package api to get the choice whether it needs to set initial focus. */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.551 -0500", hash_original_method = "D1C04B216D0AC5093D2F075C6698B7EE", hash_generated_method = "D1C04B216D0AC5093D2F075C6698B7EE")
    
boolean getNeedInitialFocus() {
        return mNeedInitialFocus;
    }

    /**
     * Set the priority of the Render thread. Unlike the other settings, this
     * one only needs to be called once per process. The default is NORMAL.
     *
     * @param priority RenderPriority, can be normal, high or low.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.553 -0500", hash_original_method = "ADE96AEA7507FA885C654AF6A7AF6825", hash_generated_method = "E77546EC88F25AD78ADF4F71F6EEF5A4")
    
public synchronized void setRenderPriority(RenderPriority priority) {
        if (mRenderPriority != priority) {
            mRenderPriority = priority;
            mEventHandler.sendMessage(Message.obtain(null,
                    EventHandler.PRIORITY));
        }
    }

    /**
     * Override the way the cache is used. The way the cache is used is based
     * on the navigation option. For a normal page load, the cache is checked
     * and content is re-validated as needed. When navigating back, content is
     * not revalidated, instead the content is just pulled from the cache.
     * This function allows the client to override this behavior.
     * @param mode One of the LOAD_ values.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.556 -0500", hash_original_method = "C16F91A0BF5BCFC94071B85F47E4B2E9", hash_generated_method = "1B4CE6ECBB354B1224D7BA7B78B92FF7")
    
public void setCacheMode(int mode) {
        if (mode != mOverrideCacheMode) {
            mOverrideCacheMode = mode;
            postSync();
        }
    }

    /**
     * Return the current setting for overriding the cache mode. For a full
     * description, see the {@link #setCacheMode(int)} function.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.558 -0500", hash_original_method = "4A960A8ACA504F48F41DB237F9209DA9", hash_generated_method = "DC7D58DCD8AAF8B48A50D7CB64F57FB2")
    
public int getCacheMode() {
        return mOverrideCacheMode;
    }

    /**
     * If set, webkit alternately shrinks and expands images viewed outside
     * of an HTML page to fit the screen. This conflicts with attempts by
     * the UI to zoom in and out of an image, so it is set false by default.
     * @param shrink Set true to let webkit shrink the standalone image to fit.
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.560 -0500", hash_original_method = "9F8C026B57F7FDFD26FE193DA8C87BB6", hash_generated_method = "AAE0AF7C8D5DA7F97A946F7DE7AC6043")
    
public void setShrinksStandaloneImagesToFit(boolean shrink) {
        if (mShrinksStandaloneImagesToFit != shrink) {
            mShrinksStandaloneImagesToFit = shrink;
            postSync();
        }
     }

    /**
     * Specify the maximum decoded image size. The default is
     * 2 megs for small memory devices and 8 megs for large memory devices.
     * @param size The maximum decoded size, or zero to set to the default.
     * @hide pending api council approval
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.562 -0500", hash_original_method = "041EEBDF0CC6DB4D857EE5FE00439A69", hash_generated_method = "770FC8D0467A229EDA27F9BAEA200D99")
    
public void setMaximumDecodedImageSize(long size) {
        if (mMaximumDecodedImageSize != size) {
            mMaximumDecodedImageSize = size;
            postSync();
        }
    }

    /**
     * Returns whether to use fixed viewport.  Use fixed viewport
     * whenever wide viewport is on.
     */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.564 -0500", hash_original_method = "37CD2CB6E6E70B184FA7FDB5F22FF522", hash_generated_method = "37CD2CB6E6E70B184FA7FDB5F22FF522")
    
boolean getUseFixedViewport() {
        return getUseWideViewPort();
    }

    /**
     * Returns whether private browsing is enabled.
     */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.566 -0500", hash_original_method = "F442F079E2DD19439C88D9FB5E3A709B", hash_generated_method = "F442F079E2DD19439C88D9FB5E3A709B")
    
boolean isPrivateBrowsingEnabled() {
        return mPrivateBrowsingEnabled;
    }

    /**
     * Sets whether private browsing is enabled.
     * @param flag Whether private browsing should be enabled.
     */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.568 -0500", hash_original_method = "34042B5DCA297E4EBEB0CC9227844924", hash_generated_method = "636C96028B8ECA776D5E1C35BD43A5FF")
    
synchronized void setPrivateBrowsingEnabled(boolean flag) {
        if (mPrivateBrowsingEnabled != flag) {
            mPrivateBrowsingEnabled = flag;

            // AutoFill is dependant on private browsing being enabled so
            // reset it to take account of the new value of mPrivateBrowsingEnabled.
            setAutoFillEnabled(mAutoFillEnabled);

            postSync();
        }
    }

    /**
     * Returns whether the viewport metatag can disable zooming
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.570 -0500", hash_original_method = "9C2B0A9C4AD9BDB94288AB167718CCA9", hash_generated_method = "687A5BB14315A707BFCD8AF3214F564F")
    
public boolean forceUserScalable() {
        return mForceUserScalable;
    }

    /**
     * Sets whether viewport metatag can disable zooming.
     * @param flag Whether or not to forceably enable user scalable.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.572 -0500", hash_original_method = "1D6F9D93B2A4A93CBF13AD0469B99A04", hash_generated_method = "464EF533B8D42C2A3CBE56ADD702B946")
    
public synchronized void setForceUserScalable(boolean flag) {
        mForceUserScalable = flag;
    }
    
    public enum LayoutAlgorithm {
        NORMAL,
        @Deprecated
        SINGLE_COLUMN,
        NARROW_COLUMNS
    }
    
    public enum TextSize {
        SMALLEST(50),
        SMALLER(75),
        NORMAL(100),
        LARGER(150),
        LARGEST(200);
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.013 -0500", hash_original_method = "683F2F3FCA1FFAFAAFA68096F53D100B", hash_generated_method = "683F2F3FCA1FFAFAAFA68096F53D100B")
            
TextSize(int size) {
            value = size;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.016 -0500", hash_original_field = "2A5EA2B60261C751D318C2CB32BF7CEC", hash_generated_field = "2A5EA2B60261C751D318C2CB32BF7CEC")

        int value;
    }
    
    public enum ZoomDensity {
        FAR(150),      
        MEDIUM(100),    
        CLOSE(75);     // 120dpi
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.020 -0500", hash_original_method = "3F8A1B883F865662A176265EDDC383F7", hash_generated_method = "3F8A1B883F865662A176265EDDC383F7")
            
ZoomDensity(int size) {
            value = size;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.022 -0500", hash_original_field = "2A5EA2B60261C751D318C2CB32BF7CEC", hash_generated_field = "2A5EA2B60261C751D318C2CB32BF7CEC")

        int value;
    }
    
    public enum RenderPriority {
        NORMAL,
        HIGH,
        LOW
    }
    
    public enum PluginState {
        ON,
        ON_DEMAND,
        OFF
    }
    
    public static class AutoFillProfile {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.188 -0500", hash_original_field = "9F92F4106274D2629F33867183512BB7", hash_generated_field = "702EBB63B52AE60657B34C8A34DF32C2")

        private int mUniqueId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.190 -0500", hash_original_field = "3569B23C23CACA3E50908EB9787C5689", hash_generated_field = "D1AA858CAC76B61ED536CD7E9E76BE21")

        private String mFullName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.192 -0500", hash_original_field = "E96C81B5FB30276C04C08289481E78D0", hash_generated_field = "A0AF6DFDA7362BDA261A45220D527187")

        private String mEmailAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.195 -0500", hash_original_field = "B1829BAE62342F52BC3F136516918B1B", hash_generated_field = "64315C7772C2603B359A256D253AD04F")

        private String mCompanyName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.197 -0500", hash_original_field = "C0D2E4CF9D8BDD2047E72255543C5B99", hash_generated_field = "E8334A774D023DCDB51748F3A66127C5")

        private String mAddressLine1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.199 -0500", hash_original_field = "60BD985B9BD1C5D306E5854775FDF226", hash_generated_field = "4E58D56AF067C60E87EAB54C984D9419")

        private String mAddressLine2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.201 -0500", hash_original_field = "17F9BE4334908BAD25FB5A5B672CEF2E", hash_generated_field = "1C2845D6D4FC6B2B1D1EAAA1F2A427AE")

        private String mCity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.204 -0500", hash_original_field = "0453CAF6E1BD08223492E4C38E56F411", hash_generated_field = "B61FE231018E4E04E31044A1AA845D59")

        private String mState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.206 -0500", hash_original_field = "C132F85E85323D3A48D023BC2199F13F", hash_generated_field = "068EDE81B58924A221B365F3B7E4D5D4")

        private String mZipCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.208 -0500", hash_original_field = "7D03D3BA6847C6FE01DB005057151761", hash_generated_field = "ED069FCB05E21E7854BDD84A7C5A61F9")

        private String mCountry;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.211 -0500", hash_original_field = "D96FD5DE72675B8B0AB4CF852236B946", hash_generated_field = "D33476978CD54C942ED6226611614D21")

        private String mPhoneNumber;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.214 -0500", hash_original_method = "356718E28156E1213C1513B4F67A401A", hash_generated_method = "FCBB10B2F9DBFB81A392603885383F0D")
        
public AutoFillProfile(int uniqueId, String fullName, String email,
                String companyName, String addressLine1, String addressLine2,
                String city, String state, String zipCode, String country,
                String phoneNumber) {
            mUniqueId = uniqueId;
            mFullName = fullName;
            mEmailAddress = email;
            mCompanyName = companyName;
            mAddressLine1 = addressLine1;
            mAddressLine2 = addressLine2;
            mCity = city;
            mState = state;
            mZipCode = zipCode;
            mCountry = country;
            mPhoneNumber = phoneNumber;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.216 -0500", hash_original_method = "F64F21D16CFD05D4B80E501A354D44C1", hash_generated_method = "452A32334F84E7C77E7566A2CF2A80D9")
        
public int getUniqueId() { return mUniqueId; }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.219 -0500", hash_original_method = "1443687462A2902C11BD4613CE447F4A", hash_generated_method = "C45B0542436E7825610596051AD893E2")
        
public String getFullName() { return mFullName; }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.222 -0500", hash_original_method = "F1CEF297E349972E689A87BC52C1313A", hash_generated_method = "DD1ADA16E1C1A058464B614C2DC7C7FE")
        
public String getEmailAddress() { return mEmailAddress; }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.224 -0500", hash_original_method = "52206539E751E4CCE5415670F9F725D8", hash_generated_method = "73BF2B4D343881063CFE102BAA4A90C9")
        
public String getCompanyName() { return mCompanyName; }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.226 -0500", hash_original_method = "C545FDC49346DC5A5D71F5AD1D1BEF53", hash_generated_method = "80C42D8BE16EED98A6064C4369D936A9")
        
public String getAddressLine1() { return mAddressLine1; }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.228 -0500", hash_original_method = "F55EC6B8A39F598BB4DCA9E4A078AA07", hash_generated_method = "702ED20EDA004C0E96A631A56126A1C6")
        
public String getAddressLine2() { return mAddressLine2; }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.230 -0500", hash_original_method = "B85B96BC49C3B97C84AB4B17868CBD9D", hash_generated_method = "85A06E93709C11A2A4C75FD310B6EDB5")
        
public String getCity() { return mCity; }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.232 -0500", hash_original_method = "E347213115686AEA23D455AF8267D98C", hash_generated_method = "07003D50C91A7CF7BAB04DB992D9F796")
        
public String getState() { return mState; }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.234 -0500", hash_original_method = "07A544AD716F805F393CD2D204A5CDEF", hash_generated_method = "582727EB468E7641805FDA80D2E883BA")
        
public String getZipCode() { return mZipCode; }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.237 -0500", hash_original_method = "F3511327404A79B77D5BB05807C0214B", hash_generated_method = "01D9B3D0B36A94E649A862204FBD01E0")
        
public String getCountry() { return mCountry; }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.239 -0500", hash_original_method = "6EFA8840ED98073D74C9222B8B96940F", hash_generated_method = "BFE1EED7134F244061612B81E7139693")
        
public String getPhoneNumber() { return mPhoneNumber; }
        
    }
    
    private class EventHandler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.256 -0500", hash_original_field = "313030AF86D60E9D8AA403DED34C2A7A", hash_generated_field = "BEA2A099547FF2FCBA953052760FB020")

        static final int SYNC = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.259 -0500", hash_original_field = "2EE8FD53A8693E7EA042B2963682BFD1", hash_generated_field = "43C72D88EADF09AFDEC0F00E9349B1C9")

        static final int PRIORITY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.261 -0500", hash_original_field = "65CA40ADC4CF65EFA997141C45155E2A", hash_generated_field = "6436B1795825C9FB51AD30AEEB2034F0")

        static final int SET_DOUBLE_TAP_TOAST_COUNT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.263 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.655 -0400", hash_original_method = "FFA7F4A8F990D2647EE1D5FBAEBEF779", hash_generated_method = "FFA7F4A8F990D2647EE1D5FBAEBEF779")
        public EventHandler ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.269 -0500", hash_original_method = "5DB82DF3D22DC31DB9F8A52C18B58140", hash_generated_method = "89C69A3059449651D3B6C371038C5B0C")
        
private synchronized void createHandler() {
            // as mRenderPriority can be set before thread is running, sync up
            setRenderPriority();

            // create a new handler
            mHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    switch (msg.what) {
                        case SYNC:
                            synchronized (WebSettings.this) {
                                if (mBrowserFrame.mNativeFrame != 0) {
                                    nativeSync(mBrowserFrame.mNativeFrame);
                                }
                                mSyncPending = false;
                            }
                            break;

                        case PRIORITY: {
                            setRenderPriority();
                            break;
                        }

                        case SET_DOUBLE_TAP_TOAST_COUNT: {
                            SharedPreferences.Editor editor = mContext
                                    .getSharedPreferences(PREF_FILE,
                                            Context.MODE_PRIVATE).edit();
                            editor.putInt(DOUBLE_TAP_TOAST_COUNT,
                                    mDoubleTapToastCount);
                            editor.commit();
                            break;
                        }
                    }
                }
            };
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.272 -0500", hash_original_method = "C47047917EAD94E1F72D1853ABF9CDB1", hash_generated_method = "CA2A218B589EB50EE94C9E33903DF48B")
        
private void setRenderPriority() {
            synchronized (WebSettings.this) {
                if (mRenderPriority == RenderPriority.NORMAL) {
                    android.os.Process.setThreadPriority(
                            android.os.Process.THREAD_PRIORITY_DEFAULT);
                } else if (mRenderPriority == RenderPriority.HIGH) {
                    android.os.Process.setThreadPriority(
                            android.os.Process.THREAD_PRIORITY_FOREGROUND +
                            android.os.Process.THREAD_PRIORITY_LESS_FAVORABLE);
                } else if (mRenderPriority == RenderPriority.LOW) {
                    android.os.Process.setThreadPriority(
                            android.os.Process.THREAD_PRIORITY_BACKGROUND);
                }
            }
        }

        /**
         * Send a message to the private queue or handler.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.274 -0500", hash_original_method = "AA202573A133FD4C93192532FFFE560D", hash_generated_method = "474639955C5D8CF949FD2CA6772DB7D6")
        
private synchronized boolean sendMessage(Message msg) {
            if (mHandler != null) {
                mHandler.sendMessage(msg);
                return true;
            } else {
                return false;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.575 -0500", hash_original_method = "5D9DAFAFBF77CCE3ED840C406B6898AF", hash_generated_method = "BC6A3645DFCD86DE7CFF0FD5BD42A427")
    
synchronized void setSyntheticLinksEnabled(boolean flag) {
        if (mSyntheticLinksEnabled != flag) {
            mSyntheticLinksEnabled = flag;
            postSync();
        }
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.577 -0500", hash_original_method = "1A8C919F0F6505492DC614E84115DF0C", hash_generated_method = "4E6E935C8228691080569D312BAC0E98")
    
public synchronized void setAutoFillEnabled(boolean enabled) {
        // AutoFill is always disabled in private browsing mode.
        boolean autoFillEnabled = enabled && !mPrivateBrowsingEnabled;
        if (mAutoFillEnabled != autoFillEnabled) {
            mAutoFillEnabled = autoFillEnabled;
            postSync();
        }
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.579 -0500", hash_original_method = "8774A835D2148EBC629E39CB3DCAFA63", hash_generated_method = "6D9AC13FA840FD79907298ECDC3AA1D8")
    
public synchronized boolean getAutoFillEnabled() {
        return mAutoFillEnabled;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.582 -0500", hash_original_method = "3148173678A0F0377520D6B2C8079A70", hash_generated_method = "B67E4006E076E968403F9813A4F71330")
    
public synchronized void setAutoFillProfile(AutoFillProfile profile) {
        if (mAutoFillProfile != profile) {
            mAutoFillProfile = profile;
            postSync();
        }
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.584 -0500", hash_original_method = "40495DA1FFE9EC3467407968672CDCF7", hash_generated_method = "75DB25A5F54DA40E7150AF57C45137A8")
    
public synchronized AutoFillProfile getAutoFillProfile() {
        return mAutoFillProfile;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.586 -0500", hash_original_method = "C3E1D2408E91E83D6659CE445CE89780", hash_generated_method = "C3E1D2408E91E83D6659CE445CE89780")
    
int getDoubleTapToastCount() {
        return mDoubleTapToastCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.588 -0500", hash_original_method = "3B766C36F75F383AEAB183DB6ECCA431", hash_generated_method = "BA817ADAC0662A17386837E1C90220FA")
    
void setDoubleTapToastCount(int count) {
        if (mDoubleTapToastCount != count) {
            mDoubleTapToastCount = count;
            // write the settings in the non-UI thread
            mEventHandler.sendMessage(Message.obtain(null,
                    EventHandler.SET_DOUBLE_TAP_TOAST_COUNT));
        }
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.590 -0500", hash_original_method = "51A1E424E5F24F0C6AF042B09286C12C", hash_generated_method = "BEB52E7213D79531CFB8947DA21CB62C")
    
public void setProperty(String key, String value) {
        if (mWebView.nativeSetProperty(key, value)) {
            mWebView.contentInvalidateAll();
        }
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.593 -0500", hash_original_method = "E79B730EE57AB5AA3332F72B80B24914", hash_generated_method = "25B3F747EF0C98EB77D0F6E13D9E8224")
    
public String getProperty(String key) {
        return mWebView.nativeGetProperty(key);
    }

    /**
     * Transfer messages from the queue to the new WebCoreThread. Called from
     * WebCore thread.
     */
    /*package*/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.596 -0500", hash_original_method = "B2134E4964C5B0957E3BC21A40B5447F", hash_generated_method = "8A2FEDC9D2FB04DC6D60E0090934AFF3")
    
synchronized void syncSettingsAndCreateHandler(BrowserFrame frame) {
        mBrowserFrame = frame;
        if (DebugFlags.WEB_SETTINGS) {
            junit.framework.Assert.assertTrue(frame.mNativeFrame != 0);
        }

        SharedPreferences sp = mContext.getSharedPreferences(PREF_FILE,
                Context.MODE_PRIVATE);
        if (mDoubleTapToastCount > 0) {
            mDoubleTapToastCount = sp.getInt(DOUBLE_TAP_TOAST_COUNT,
                    mDoubleTapToastCount);
        }
        nativeSync(frame.mNativeFrame);
        mSyncPending = false;
        mEventHandler.createHandler();
    }

    /**
     * Let the Settings object know that our owner is being destroyed.
     */
    /*package*/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.598 -0500", hash_original_method = "97F607FA924E3FA8AA008A1519BCA623", hash_generated_method = "A03DF9FDC8B7FEC8EA64149AD0E09E24")
    
synchronized void onDestroyed() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.600 -0500", hash_original_method = "32C980BFA3F312B2745A36CC144BD5C9", hash_generated_method = "5ECAEFD2FF0554F867BAA0EEAB5A6C3F")
    
private int pin(int size) {
        // FIXME: 72 is just an arbitrary max text size value.
        if (size < 1) {
            return 1;
        } else if (size > 72) {
            return 72;
        }
        return size;
    }

    /* Post a SYNC message to handle syncing the native settings. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.602 -0500", hash_original_method = "028ACD01F22F62E6B019AFF3AD2AE2F1", hash_generated_method = "49DB4847087FE79E45295B997678671E")
    
private synchronized void postSync() {
        // Only post if a sync is not pending
        if (!mSyncPending) {
            mSyncPending = mEventHandler.sendMessage(
                    Message.obtain(null, EventHandler.SYNC));
        }
    }

    // Synchronize the native and java settings.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:04.606 -0500", hash_original_method = "B9A4DA2D5B0DA0061612E5CC599DFA25", hash_generated_method = "0D5B015FA56855943EC0D00519209BDE")
    
    private void nativeSync(int nativeFrame){
    	//Formerly a native method
    	addTaint(nativeFrame);
    }

}

