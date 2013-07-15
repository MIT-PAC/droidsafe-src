package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.EventLog;
import java.util.Locale;

public class WebSettings {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.588 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.588 -0400", hash_original_field = "210C1862D81E3FCC2FD87A83EA255D40", hash_generated_field = "076F5BF2A47D119E2704BFAF413B4749")

    private BrowserFrame mBrowserFrame;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.588 -0400", hash_original_field = "1C1B53671D8960CFDAF6678A518773D3", hash_generated_field = "C30651F336ACC984908CFD9A1D2C4FB4")

    private boolean mSyncPending = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.588 -0400", hash_original_field = "3487E63080D45B4AAFB4C377AC2DEA9F", hash_generated_field = "04D6DC37F0EF901EF71A528809491D49")

    private EventHandler mEventHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.589 -0400", hash_original_field = "0E67D362E0510FE684D203B7C7F6070B", hash_generated_field = "47AE0040F5B89E8E9BAF92BC707C0968")

    private LayoutAlgorithm mLayoutAlgorithm = LayoutAlgorithm.NARROW_COLUMNS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.589 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.589 -0400", hash_original_field = "C77050D5C2EE6A81F7591567A7C739D3", hash_generated_field = "093C29E093EBC4DF45917F084F44F5C6")

    private int mTextSize = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.589 -0400", hash_original_field = "FD6304CD2AD07308572BAF180A0533CF", hash_generated_field = "E4348E0A07514EBC6D1B08E5327B30EE")

    private String mStandardFontFamily = "sans-serif";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.589 -0400", hash_original_field = "B1FEC4472DB98E6AC7451DE82D2FC6FA", hash_generated_field = "3A7EFCED956E000EA686CA04D7AC83B8")

    private String mFixedFontFamily = "monospace";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.589 -0400", hash_original_field = "4D96B78DF60FEF0ABEB226DA207E661D", hash_generated_field = "399DACBDFE4EA1F4862F6FE2A91B1825")

    private String mSansSerifFontFamily = "sans-serif";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.589 -0400", hash_original_field = "F5A72D21736E3B729526542A27D57950", hash_generated_field = "C8511EC396A968342E91C81EE20A14FE")

    private String mSerifFontFamily = "serif";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.589 -0400", hash_original_field = "6F0F877F43636E621A23165415BE5E9C", hash_generated_field = "C79480C6B7D9DBB1193A0C73FB024BC6")

    private String mCursiveFontFamily = "cursive";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.589 -0400", hash_original_field = "ACAA0158781BC246A182425E83276CD3", hash_generated_field = "B7EC94AD4E54CB710D321F7D7DE2B94D")

    private String mFantasyFontFamily = "fantasy";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.589 -0400", hash_original_field = "CE5A4F5B72547D0E3BED4120AB54E949", hash_generated_field = "B14E6AD20DBCE8C395967EFC3730E312")

    private String mDefaultTextEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.589 -0400", hash_original_field = "BA6D6E1CFB30AD42884BC977FE2F8001", hash_generated_field = "DE0DD9FFAB9049B26488186A370E05A4")

    private String mUserAgent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.589 -0400", hash_original_field = "E636D0AC0659FBA6915C4CA8085F37FB", hash_generated_field = "98FAE63E9B12B7A881FB6D145E4549CE")

    private boolean mUseDefaultUserAgent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.589 -0400", hash_original_field = "B1F493B722D78CD886E29BDFFE0802B3", hash_generated_field = "439229978AE9CF49770BDEBF3E2CE78C")

    private String mAcceptLanguage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.589 -0400", hash_original_field = "0F2878AB7630408FA87100B28FC68C94", hash_generated_field = "D0EDBC802964D83D99F85BC314C8A69C")

    private int mMinimumFontSize = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.589 -0400", hash_original_field = "4B34DDC1E8E68B3BED9CC6080688FF22", hash_generated_field = "528ED989B04689091770CF5109FE433F")

    private int mMinimumLogicalFontSize = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.589 -0400", hash_original_field = "836C251AEBE2201CC391FB31DC7701C0", hash_generated_field = "57AE803195BA7056811C876F5BD9502B")

    private int mDefaultFontSize = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.590 -0400", hash_original_field = "3EF20D2976FA241D9E0FF7E4D44ED19A", hash_generated_field = "5AFDCF69E75A0190CADCEA2557825121")

    private int mDefaultFixedFontSize = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.590 -0400", hash_original_field = "C84A7DE980B0C26CE75BAC761048D403", hash_generated_field = "F690B69F0C52F955F3D88DD7983F79F2")

    private int mPageCacheCapacity = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.590 -0400", hash_original_field = "7B02990524344D9852C3E43FB13DD8E4", hash_generated_field = "DE3A280A6D9972DAFD651E9018D4768E")

    private boolean mLoadsImagesAutomatically = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.590 -0400", hash_original_field = "8F5CF5F2C56460BFDB5BFC7DC9CEF759", hash_generated_field = "503153EC725C55D5C1DC162A32A1D3DC")

    private boolean mBlockNetworkImage = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.590 -0400", hash_original_field = "FF7A02E2205AE67F625F39019D239753", hash_generated_field = "1ACDBB27D2A84BAEF0BB072C0594B56E")

    private boolean mBlockNetworkLoads;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.590 -0400", hash_original_field = "C3822A70B9259EA30623C122721ADA79", hash_generated_field = "36C1818B65CEBEA6CFEE516674358D43")

    private boolean mJavaScriptEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.590 -0400", hash_original_field = "4CA2A324C4541CD9D0F4EA48A9F96383", hash_generated_field = "0A90F6A7499839588E833D7BE890E1AE")

    private boolean mHardwareAccelSkia = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.590 -0400", hash_original_field = "6BBB46DBDE2209BDCF5F06D21CED3E66", hash_generated_field = "944C133C097C1E4190CF0C3582E0E938")

    private boolean mShowVisualIndicator = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.590 -0400", hash_original_field = "9C4C3DA8B3DFE7677F937A106A0FA190", hash_generated_field = "7D86B7624AEF61E6266D36CF41EB39D7")

    private PluginState mPluginState = PluginState.OFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.590 -0400", hash_original_field = "782F3CEA749C92F0B1AEF5C560F6F376", hash_generated_field = "459DE55C50CE26452B149CCD8782CC03")

    private boolean mJavaScriptCanOpenWindowsAutomatically = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.590 -0400", hash_original_field = "E42DF2AC48A80AC89D5EA6C725AA31FC", hash_generated_field = "20A7E2DF1A565B51829896E9F69CF90A")

    private boolean mUseDoubleTree = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.590 -0400", hash_original_field = "EFD7BD41CD6C84BE258717DD0246B0D9", hash_generated_field = "5EDADBA984DCE351C397430D71B8E193")

    private boolean mUseWideViewport = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.590 -0400", hash_original_field = "89ADAB8AAADB11C767CDDD4A47C31E4F", hash_generated_field = "63D7A412D6A66B99394E571B78F61F6C")

    private boolean mSupportMultipleWindows = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.591 -0400", hash_original_field = "776CDA302169DB8F9A950481F30563B1", hash_generated_field = "77A7B89BB1F561628F9C88F763E053D4")

    private boolean mShrinksStandaloneImagesToFit = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.591 -0400", hash_original_field = "1C23E4BD5710D9A07575C92514B3B2A7", hash_generated_field = "71BCB1B04985B5A05BFF9925B051AEA3")

    private long mMaximumDecodedImageSize = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.591 -0400", hash_original_field = "23A44297716498305D043D064C5F1A5D", hash_generated_field = "381C5CB2F1A0DF35777B63F9BF8EDACD")

    private boolean mPrivateBrowsingEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.591 -0400", hash_original_field = "40CEACE7770B1AA574AECB611E78A601", hash_generated_field = "F43E538FC31443F2EB0B8734DEF87A58")

    private boolean mSyntheticLinksEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.591 -0400", hash_original_field = "FF76A93821E4C14CA2D0F905605B5253", hash_generated_field = "A8618659B8DEE94F1CEAA079EECA9790")

    private boolean mAppCacheEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.591 -0400", hash_original_field = "CEE1403C760B29E8CFBD90E16820A9F9", hash_generated_field = "ABA108E81C8DBD674018DAA8E50B66B3")

    private boolean mDatabaseEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.591 -0400", hash_original_field = "9B4BB2DD19F19AEE3A60C91A700A53A8", hash_generated_field = "5F06543ABC51E15528B933AC0AB2C6F7")

    private boolean mDomStorageEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.591 -0400", hash_original_field = "D120EB54296E0E73D2502E565107FA14", hash_generated_field = "74A2A29BD57D607C6576055F7F403D0D")

    private boolean mWorkersEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.591 -0400", hash_original_field = "F4A5919DFCEA1FA69B258487DA02ED60", hash_generated_field = "3C3198EADED631FE881AB97F9EAFA5FA")

    private boolean mGeolocationEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.591 -0400", hash_original_field = "24DC0A10E4E5F0680B65B6480902CF89", hash_generated_field = "6F3EA93685FD5D8B0D8F67E8E5C21B28")

    private boolean mXSSAuditorEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.591 -0400", hash_original_field = "BAFC052B19321AD6D2EEE9FD24C189C7", hash_generated_field = "A6B2EA55227276EA13A495BB96D1DF12")

    private long mAppCacheMaxSize = Long.MAX_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.591 -0400", hash_original_field = "7B285FB0B6636DBE1C8FB24FC0A7082B", hash_generated_field = "D79F53468E055B10315200B95916C500")

    private String mAppCachePath = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.591 -0400", hash_original_field = "0F8B2DAEF39F0C191E39D188C577F5B0", hash_generated_field = "9EB5165541C5151194CB8556E03CD161")

    private String mDatabasePath = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.591 -0400", hash_original_field = "96B4B13C2502429263325D7990904AE8", hash_generated_field = "F2C27E27D9065859FE4225C1B56F842D")

    private boolean mDatabasePathHasBeenSet = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.592 -0400", hash_original_field = "207F5E7A506E1A9B35F9E6570D102D4C", hash_generated_field = "5ABA61E953719F99114204D8D30BD28F")

    private String mGeolocationDatabasePath = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.592 -0400", hash_original_field = "9AF10D96415892E26A1DFAA3A56A2347", hash_generated_field = "1F48A314038B92F0A250F855FF35D5AB")

    private ZoomDensity mDefaultZoom = ZoomDensity.MEDIUM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.592 -0400", hash_original_field = "A39FFAE4A825508391E0316FF905EEAF", hash_generated_field = "A1F79CA724067D106338BC229C16B5FC")

    private RenderPriority mRenderPriority = RenderPriority.NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.592 -0400", hash_original_field = "4E7CECE5CBD06928F1F2E5152BDCB1C0", hash_generated_field = "5C01ACB0A24F788620EF740B6F83D8FF")

    private int mOverrideCacheMode = LOAD_DEFAULT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.592 -0400", hash_original_field = "2F57086F7AA47DF4C289A1A22809C34B", hash_generated_field = "1E5E05632184B0562D99F65B2623C2C6")

    private int mDoubleTapZoom = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.592 -0400", hash_original_field = "7A20407DCDB4339E9CD5D75A376E286D", hash_generated_field = "82ACFD258B431C7D2B00D5130B9F8AC1")

    private boolean mSaveFormData = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.592 -0400", hash_original_field = "84334DBED733230649777024AC1171F3", hash_generated_field = "EE91F91973A59EB55189A26DDA38F9B3")

    private boolean mAutoFillEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.592 -0400", hash_original_field = "37293F79039D53AD34CCD74A160D684B", hash_generated_field = "0C944D5751C5A507BE22C1937F62D8F5")

    private boolean mSavePassword = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.592 -0400", hash_original_field = "14C3D2179570F06B504FCED5EF5C9DF1", hash_generated_field = "B0E370B7C84DDE746CBD3769FED2B05B")

    private boolean mLightTouchEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.592 -0400", hash_original_field = "FC17F5EAB69150AD7077A5F07A1029E6", hash_generated_field = "479CD0E5DFA0F4A8AD2336A3C8796C11")

    private boolean mNeedInitialFocus = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.592 -0400", hash_original_field = "CD2AB2548C6EBA9F969FE4F44D9EE358", hash_generated_field = "53BEF3F54FA7E72187F7DE406E409A1B")

    private boolean mNavDump = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.592 -0400", hash_original_field = "4FFFB08326947A7F34D6A94BCF9C323D", hash_generated_field = "9816BC835AB5A0ACD4FDE0137AF8616C")

    private boolean mSupportZoom = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.592 -0400", hash_original_field = "9CF7D3194AF8F27F30388FB99A38B9FB", hash_generated_field = "C64C3FAECED9CD368C40F69AB6974F26")

    private boolean mBuiltInZoomControls = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.592 -0400", hash_original_field = "9EE62A52A99CC1E8EEF461CF8EE79F29", hash_generated_field = "620B20DEA57B92E5F177E02A77C42AD0")

    private boolean mDisplayZoomControls = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.592 -0400", hash_original_field = "8C0C96268A4FE5A7FEA363603086B178", hash_generated_field = "296BB32E1651209ADFADBF23000A8C19")

    private boolean mAllowFileAccess = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.592 -0400", hash_original_field = "E8BD268B102F8A23DE857C06F29F7274", hash_generated_field = "CCF630C83B80C2F4393E963314F2D0FE")

    private boolean mAllowContentAccess = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.593 -0400", hash_original_field = "07AA53DFAC65DD5CA73EE06FC482AC8E", hash_generated_field = "30FAFE3A56A71716731F01CEE7EBDBC8")

    private boolean mLoadWithOverviewMode = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.593 -0400", hash_original_field = "DAFB88B50FE0B9BEB8636973E61088F4", hash_generated_field = "0383F8FCA39790900B8C6F17CB8C8ACE")

    private boolean mEnableSmoothTransition = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.593 -0400", hash_original_field = "78A6C8AB01BD6AD3C287AFA07ABEFE43", hash_generated_field = "C83DD3856F6A01CD394571B6570E38C9")

    private boolean mForceUserScalable = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.593 -0400", hash_original_field = "D0E8E1D004D578571CAB3FC73F9DD791", hash_generated_field = "91C6393A6B49848292FD9CB7AF58B0CD")

    private AutoFillProfile mAutoFillProfile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.593 -0400", hash_original_field = "4727D81B5001274DB3B60E1C06A5A4B0", hash_generated_field = "73BE0F1D89639A62A6549ED3C0472D72")

    private boolean mUseWebViewBackgroundForOverscroll = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.594 -0400", hash_original_method = "C5F77054875E8CE16379FFA130433105", hash_generated_method = "1CA31199F185959AAA4CAC977BC6EA45")
      WebSettings(Context context, WebView webview) {
        mEventHandler = new EventHandler();
        mContext = context;
        mWebView = webview;
        mDefaultTextEncoding = context.getString(com.android.internal.
                                                 R.string.default_text_encoding);
    if(sLockForLocaleSettings == null)        
        {
            sLockForLocaleSettings = new Object();
            sLocale = Locale.getDefault();
        } //End block
        mAcceptLanguage = getCurrentAcceptLanguage();
        mUserAgent = getCurrentUserAgent();
        mUseDefaultUserAgent = true;
        mBlockNetworkLoads = mContext.checkPermission(
                "android.permission.INTERNET", android.os.Process.myPid(),
                android.os.Process.myUid()) != PackageManager.PERMISSION_GRANTED;
        // ---------- Original Method ----------
        //mEventHandler = new EventHandler();
        //mContext = context;
        //mWebView = webview;
        //mDefaultTextEncoding = context.getString(com.android.internal.
                                                 //R.string.default_text_encoding);
        //if (sLockForLocaleSettings == null) {
            //sLockForLocaleSettings = new Object();
            //sLocale = Locale.getDefault();
        //}
        //mAcceptLanguage = getCurrentAcceptLanguage();
        //mUserAgent = getCurrentUserAgent();
        //mUseDefaultUserAgent = true;
        //mBlockNetworkLoads = mContext.checkPermission(
                //"android.permission.INTERNET", android.os.Process.myPid(),
                //android.os.Process.myUid()) != PackageManager.PERMISSION_GRANTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.595 -0400", hash_original_method = "4DE075F72507E4E460D500D800684FF5", hash_generated_method = "970C6A6CC090BA3D232BA9169355398C")
    private String getCurrentAcceptLanguage() {
        Locale locale;
        synchronized
(sLockForLocaleSettings)        {
            locale = sLocale;
        } //End block
        StringBuilder buffer = new StringBuilder();
        addLocaleToHttpAcceptLanguage(buffer, locale);
    if(!Locale.US.equals(locale))        
        {
    if(buffer.length() > 0)            
            {
                buffer.append(", ");
            } //End block
            buffer.append(ACCEPT_LANG_FOR_US_LOCALE);
        } //End block
String varD03843288D33B9E1D3062E25339ECF6D_50606612 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_50606612.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_50606612;
        // ---------- Original Method ----------
        //Locale locale;
        //synchronized(sLockForLocaleSettings) {
            //locale = sLocale;
        //}
        //StringBuilder buffer = new StringBuilder();
        //addLocaleToHttpAcceptLanguage(buffer, locale);
        //if (!Locale.US.equals(locale)) {
            //if (buffer.length() > 0) {
                //buffer.append(", ");
            //}
            //buffer.append(ACCEPT_LANG_FOR_US_LOCALE);
        //}
        //return buffer.toString();
    }

    
        private static String convertObsoleteLanguageCodeToNew(String langCode) {
        if (langCode == null) {
            return null;
        }
        if ("iw".equals(langCode)) {
            return "he";
        } else if ("in".equals(langCode)) {
            return "id";
        } else if ("ji".equals(langCode)) {
            return "yi";
        }
        return langCode;
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.596 -0400", hash_original_method = "7A96EBBEB91D958845CC53A11C0AF344", hash_generated_method = "0C17986D3B0048FE3436A0CD5C248C93")
    private synchronized String getCurrentUserAgent() {
        Locale locale;
        synchronized
(sLockForLocaleSettings)        {
            locale = sLocale;
        } //End block
        StringBuffer buffer = new StringBuffer();
        final String version = Build.VERSION.RELEASE;
    if(version.length() > 0)        
        {
    if(Character.isDigit(version.charAt(0)))            
            {
                buffer.append(version);
            } //End block
            else
            {
                buffer.append(PREVIOUS_VERSION);
            } //End block
        } //End block
        else
        {
            buffer.append("1.0");
        } //End block
        buffer.append("; ");
        final String language = locale.getLanguage();
    if(language != null)        
        {
            buffer.append(convertObsoleteLanguageCodeToNew(language));
            final String country = locale.getCountry();
    if(country != null)            
            {
                buffer.append("-");
                buffer.append(country.toLowerCase());
            } //End block
        } //End block
        else
        {
            buffer.append("en");
        } //End block
        buffer.append(";");
    if("REL".equals(Build.VERSION.CODENAME))        
        {
            final String model = Build.MODEL;
    if(model.length() > 0)            
            {
                buffer.append(" ");
                buffer.append(model);
            } //End block
        } //End block
        final String id = Build.ID;
    if(id.length() > 0)        
        {
            buffer.append(" Build/");
            buffer.append(id);
        } //End block
        String mobile = mContext.getResources().getText(
            com.android.internal.R.string.web_user_agent_target_content).toString();
        final String base = mContext.getResources().getText(
                com.android.internal.R.string.web_user_agent).toString();
String varE72B15D0FE2364B4652A376ACAFBA38E_1712999303 =         String.format(base, buffer, mobile);
        varE72B15D0FE2364B4652A376ACAFBA38E_1712999303.addTaint(taint);
        return varE72B15D0FE2364B4652A376ACAFBA38E_1712999303;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.597 -0400", hash_original_method = "0785CD668E13EDF5998305462A035DB6", hash_generated_method = "3D0009C82F720043A50C0F5906394E3C")
    @Deprecated
    public void setNavDump(boolean enabled) {
        mNavDump = enabled;
        // ---------- Original Method ----------
        //mNavDump = enabled;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.597 -0400", hash_original_method = "8B24B3626FE4D070605B6C1E8E9774B6", hash_generated_method = "0CE2866F9C9AAB4F54B996BE46DF13CA")
    @Deprecated
    public boolean getNavDump() {
        boolean var8DFF252163E31468DB1F35F5BDEB9D56_1989102400 = (mNavDump);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_112660136 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_112660136;
        // ---------- Original Method ----------
        //return mNavDump;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.598 -0400", hash_original_method = "BB54171E3BDD4A64CB98C2709AC39B9C", hash_generated_method = "674624705BAE54FDAF64DF89AF6F0A2F")
     boolean supportTouchOnly() {
        boolean varD46F66368C8A17CB1607B1673483E82B_438022305 = (mLightTouchEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_653321668 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_653321668;
        // ---------- Original Method ----------
        //return mLightTouchEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.598 -0400", hash_original_method = "6B7C7B097AE4AF077C4ED1E2A5D10429", hash_generated_method = "EE55224A930804935CDBC9F3AB3F3778")
    public void setSupportZoom(boolean support) {
        mSupportZoom = support;
        mWebView.updateMultiTouchSupport(mContext);
        // ---------- Original Method ----------
        //mSupportZoom = support;
        //mWebView.updateMultiTouchSupport(mContext);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.598 -0400", hash_original_method = "A16213EC170C52C83CDC8BBC64DBFF18", hash_generated_method = "89AAFD8B073BBF47F65000BE99191960")
    public boolean supportZoom() {
        boolean var8CE479DC01AA46B0A2C17DA4963C9C06_1971843015 = (mSupportZoom);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_442986129 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_442986129;
        // ---------- Original Method ----------
        //return mSupportZoom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.599 -0400", hash_original_method = "16CDF55EE98C899167571FFC15609D2B", hash_generated_method = "29D331EEE75AE04FE358F9041FDC9D4D")
    public void setBuiltInZoomControls(boolean enabled) {
        mBuiltInZoomControls = enabled;
        mWebView.updateMultiTouchSupport(mContext);
        // ---------- Original Method ----------
        //mBuiltInZoomControls = enabled;
        //mWebView.updateMultiTouchSupport(mContext);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.599 -0400", hash_original_method = "9006048913C3ABECFF150ED9A10494B5", hash_generated_method = "6806009E43E920CC65D7199893C58727")
    public boolean getBuiltInZoomControls() {
        boolean varE86A5142F372F659C5E7210280AFB569_1447674378 = (mBuiltInZoomControls);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1827027505 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1827027505;
        // ---------- Original Method ----------
        //return mBuiltInZoomControls;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.599 -0400", hash_original_method = "8F17FB2A2C1E34D57B8A250CBF0EF944", hash_generated_method = "150ABF0EFCA5E0EF820D4ABA562462C7")
    public void setDisplayZoomControls(boolean enabled) {
        mDisplayZoomControls = enabled;
        mWebView.updateMultiTouchSupport(mContext);
        // ---------- Original Method ----------
        //mDisplayZoomControls = enabled;
        //mWebView.updateMultiTouchSupport(mContext);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.600 -0400", hash_original_method = "AE5780336410432FB6F983F3F828E46C", hash_generated_method = "D089C2D7F4D334811A43A1DEB524A7EE")
    public boolean getDisplayZoomControls() {
        boolean var0AA37AE22047DA8D505F49DC32F4E62C_1614320913 = (mDisplayZoomControls);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1577264520 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1577264520;
        // ---------- Original Method ----------
        //return mDisplayZoomControls;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.600 -0400", hash_original_method = "C265511540E520E57BDB53C1B101C5AC", hash_generated_method = "3FA94A3866D3A3E694A204489118E1F3")
    public void setAllowFileAccess(boolean allow) {
        mAllowFileAccess = allow;
        // ---------- Original Method ----------
        //mAllowFileAccess = allow;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.601 -0400", hash_original_method = "ED281F9FC327C1DCA93656D122E60B6E", hash_generated_method = "B13562DFC7F730582A13D11960407E91")
    public boolean getAllowFileAccess() {
        boolean varB1028CE892468A1504CF91F79B7267EA_1217092576 = (mAllowFileAccess);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2072443088 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2072443088;
        // ---------- Original Method ----------
        //return mAllowFileAccess;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.601 -0400", hash_original_method = "1A30AACA222993CDBB39CAF3A548FAE3", hash_generated_method = "55017C3A0896C8083D53F9176707C196")
    public void setAllowContentAccess(boolean allow) {
        mAllowContentAccess = allow;
        // ---------- Original Method ----------
        //mAllowContentAccess = allow;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.602 -0400", hash_original_method = "E20572D9D9FCBBCAC622C44A2D9C5369", hash_generated_method = "5820C31C7AECFD13C4D1C80F424C2623")
    public boolean getAllowContentAccess() {
        boolean var2130116D297854C0D76F169B8FA8234A_340142674 = (mAllowContentAccess);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_150972041 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_150972041;
        // ---------- Original Method ----------
        //return mAllowContentAccess;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.602 -0400", hash_original_method = "E0C53B0ABBE8903B8C2E5235B7766B9A", hash_generated_method = "B6128BCF06C01508511BF873AD287A93")
    public void setLoadWithOverviewMode(boolean overview) {
        mLoadWithOverviewMode = overview;
        // ---------- Original Method ----------
        //mLoadWithOverviewMode = overview;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.603 -0400", hash_original_method = "0D409EAD2B46C91908C9804617827D1C", hash_generated_method = "5AAC88E037BFAEEB867EDC8792009F1F")
    public boolean getLoadWithOverviewMode() {
        boolean varDEC2FCD950650CAB3BA25EB7D1C5E32F_1935475158 = (mLoadWithOverviewMode);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1136371362 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1136371362;
        // ---------- Original Method ----------
        //return mLoadWithOverviewMode;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.603 -0400", hash_original_method = "B5CB73D3FC09526DD6AE502765086798", hash_generated_method = "64C152888041D085E972D81D1C95DC93")
    public void setEnableSmoothTransition(boolean enable) {
        mEnableSmoothTransition = enable;
        // ---------- Original Method ----------
        //mEnableSmoothTransition = enable;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.604 -0400", hash_original_method = "FB45006D48B3F1A32CF7E83242DDAE7D", hash_generated_method = "1A2BDE3EDA23A90D326BD64ED184F8DC")
    public boolean enableSmoothTransition() {
        boolean var579974033D1C44F79EC73FDBB9FAD536_1290803423 = (mEnableSmoothTransition);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_452127134 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_452127134;
        // ---------- Original Method ----------
        //return mEnableSmoothTransition;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.605 -0400", hash_original_method = "6C4A8C912B988582A0E8E6FECC7FBF9C", hash_generated_method = "85F98D1E9E9195557007E0781EDA3C95")
    @Deprecated
    public void setUseWebViewBackgroundForOverscrollBackground(boolean view) {
        mUseWebViewBackgroundForOverscroll = view;
        // ---------- Original Method ----------
        //mUseWebViewBackgroundForOverscroll = view;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.605 -0400", hash_original_method = "FE1757AAD5E1DD702744237E901A55C8", hash_generated_method = "CF533E43555C986282B5719B3A33EDF9")
    @Deprecated
    public boolean getUseWebViewBackgroundForOverscrollBackground() {
        boolean var1FCAB0B89E9FD4AD8C1700F04F27D8F1_412828059 = (mUseWebViewBackgroundForOverscroll);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1464902625 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1464902625;
        // ---------- Original Method ----------
        //return mUseWebViewBackgroundForOverscroll;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.607 -0400", hash_original_method = "BAE3B161CD7589698136E106A2876792", hash_generated_method = "1B000F89994FD51C8FCC87F59A7E5B8A")
    public void setSaveFormData(boolean save) {
        mSaveFormData = save;
        // ---------- Original Method ----------
        //mSaveFormData = save;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.607 -0400", hash_original_method = "4DFFD3713A8D682938D03E8713A587EF", hash_generated_method = "8DCA4740E052B64CB7280B0D6B51257B")
    public boolean getSaveFormData() {
        boolean var209B65E7AFDCF898AA38A64A2FC85397_266343193 = (mSaveFormData && !mPrivateBrowsingEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_401489326 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_401489326;
        // ---------- Original Method ----------
        //return mSaveFormData && !mPrivateBrowsingEnabled;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.607 -0400", hash_original_method = "B2DE3A754D34523602EAE606838B5563", hash_generated_method = "1A0C14453C50A93DCB55814578EA8BF3")
    public void setSavePassword(boolean save) {
        mSavePassword = save;
        // ---------- Original Method ----------
        //mSavePassword = save;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.608 -0400", hash_original_method = "7EDF9AC2E1EDCCF642364DB0CD31765F", hash_generated_method = "113770C7522DAFA5AA45AFDCCF024929")
    public boolean getSavePassword() {
        boolean var09F500AA40683E97951DF0A53E99F20F_1608250312 = (mSavePassword);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1715413579 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1715413579;
        // ---------- Original Method ----------
        //return mSavePassword;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.608 -0400", hash_original_method = "C5C41A533FE351F2D45D268D5D267050", hash_generated_method = "F1ADB5AC3FF31784521C0307BCC0965A")
    public synchronized void setTextZoom(int textZoom) {
    if(mTextSize != textZoom)        
        {
    if(WebView.mLogEvent)            
            {
                EventLog.writeEvent(EventLogTags.BROWSER_TEXT_SIZE_CHANGE,
                        mTextSize, textZoom);
            } //End block
            mTextSize = textZoom;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mTextSize != textZoom) {
            //if (WebView.mLogEvent) {
                //EventLog.writeEvent(EventLogTags.BROWSER_TEXT_SIZE_CHANGE,
                        //mTextSize, textZoom);
            //}
            //mTextSize = textZoom;
            //postSync();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.608 -0400", hash_original_method = "570564B346A8D968406F236CA99E37F6", hash_generated_method = "3E1E5E00052FF27269B54BD29A693E1E")
    public synchronized int getTextZoom() {
        int var327DC1284D23313571A41B232E2678D5_294062152 = (mTextSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1675411680 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1675411680;
        // ---------- Original Method ----------
        //return mTextSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.608 -0400", hash_original_method = "D3E0150ED5C00CC3B22240870480363B", hash_generated_method = "E65696AA4DF9F8E14B9F03A2E6BDDE5A")
    public synchronized void setTextSize(TextSize t) {
        addTaint(t.getTaint());
        setTextZoom(t.value);
        // ---------- Original Method ----------
        //setTextZoom(t.value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.608 -0400", hash_original_method = "900BE61F6B80F2B5D843AC6DC18F9D15", hash_generated_method = "1312443B67D971D5B154358FFDC95D12")
    public synchronized TextSize getTextSize() {
        TextSize closestSize = null;
        int smallestDelta = Integer.MAX_VALUE;
for(TextSize size : TextSize.values())
        {
            int delta = Math.abs(mTextSize - size.value);
    if(delta == 0)            
            {
TextSize var1C66204DCEA9331BE00F48731BABEBBE_209447997 =                 size;
                var1C66204DCEA9331BE00F48731BABEBBE_209447997.addTaint(taint);
                return var1C66204DCEA9331BE00F48731BABEBBE_209447997;
            } //End block
    if(delta < smallestDelta)            
            {
                smallestDelta = delta;
                closestSize = size;
            } //End block
        } //End block
TextSize varA667F0019A139609606DB37BCD641C93_1994502200 =         closestSize != null ? closestSize : TextSize.NORMAL;
        varA667F0019A139609606DB37BCD641C93_1994502200.addTaint(taint);
        return varA667F0019A139609606DB37BCD641C93_1994502200;
        // ---------- Original Method ----------
        //TextSize closestSize = null;
        //int smallestDelta = Integer.MAX_VALUE;
        //for (TextSize size : TextSize.values()) {
            //int delta = Math.abs(mTextSize - size.value);
            //if (delta == 0) {
                //return size;
            //}
            //if (delta < smallestDelta) {
                //smallestDelta = delta;
                //closestSize = size;
            //}
        //}
        //return closestSize != null ? closestSize : TextSize.NORMAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.608 -0400", hash_original_method = "E23B2F666BB6D09A8C611DD5B37D2698", hash_generated_method = "09C709307553D8058D837CA6F5A25D16")
    public void setDoubleTapZoom(int doubleTapZoom) {
    if(mDoubleTapZoom != doubleTapZoom)        
        {
            mDoubleTapZoom = doubleTapZoom;
            mWebView.updateDoubleTapZoom(doubleTapZoom);
        } //End block
        // ---------- Original Method ----------
        //if (mDoubleTapZoom != doubleTapZoom) {
            //mDoubleTapZoom = doubleTapZoom;
            //mWebView.updateDoubleTapZoom(doubleTapZoom);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.608 -0400", hash_original_method = "137930918FD91EA20A5F57296DD24AFB", hash_generated_method = "8C6597D267CED7E244427F9C0FF2A693")
    public int getDoubleTapZoom() {
        int varB24A87E78F1CA38FA17FF0BB7E4C8A3D_1122552564 = (mDoubleTapZoom);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_720548594 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_720548594;
        // ---------- Original Method ----------
        //return mDoubleTapZoom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.609 -0400", hash_original_method = "E4C2219CCE12A9777A4354402A44D34B", hash_generated_method = "3BE66571F0DC55B262AB1E0A66B4A9FB")
    public void setDefaultZoom(ZoomDensity zoom) {
    if(mDefaultZoom != zoom)        
        {
            mDefaultZoom = zoom;
            mWebView.adjustDefaultZoomDensity(zoom.value);
        } //End block
        // ---------- Original Method ----------
        //if (mDefaultZoom != zoom) {
            //mDefaultZoom = zoom;
            //mWebView.adjustDefaultZoomDensity(zoom.value);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.609 -0400", hash_original_method = "72EF0E181D832EBBD7F53BEF96096C0C", hash_generated_method = "1B4044FB09481CC844DA40778EB7CC2D")
    public ZoomDensity getDefaultZoom() {
ZoomDensity varADD2946A80182532484870CA33B16E4C_1495679679 =         mDefaultZoom;
        varADD2946A80182532484870CA33B16E4C_1495679679.addTaint(taint);
        return varADD2946A80182532484870CA33B16E4C_1495679679;
        // ---------- Original Method ----------
        //return mDefaultZoom;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.609 -0400", hash_original_method = "DFD74C15B6ACEBABFCBAF5FDE1C7D76D", hash_generated_method = "9AE3C2EAB296845CAC779F245F6C12E3")
    public void setLightTouchEnabled(boolean enabled) {
        mLightTouchEnabled = enabled;
        // ---------- Original Method ----------
        //mLightTouchEnabled = enabled;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.609 -0400", hash_original_method = "02D840FF3CC8AE7A6DEC323EC455B33B", hash_generated_method = "7A3D7E7A903DAF6438527755467B27F7")
    public boolean getLightTouchEnabled() {
        boolean varD46F66368C8A17CB1607B1673483E82B_1417535726 = (mLightTouchEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_240381216 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_240381216;
        // ---------- Original Method ----------
        //return mLightTouchEnabled;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.609 -0400", hash_original_method = "EF2600D8826AB6D5A4057F05D8E61936", hash_generated_method = "F24F619D5E27EFB871068CEAD3B02126")
    @Deprecated
    public synchronized void setUseDoubleTree(boolean use) {
        addTaint(use);
        return;
        // ---------- Original Method ----------
        //return;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.609 -0400", hash_original_method = "89BCC0409F823F147F01A4F485C1EC58", hash_generated_method = "A92084C211962EEF823E740C343A2FD3")
    @Deprecated
    public synchronized boolean getUseDoubleTree() {
        boolean var68934A3E9455FA72420237EB05902327_618248829 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1005124504 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1005124504;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.609 -0400", hash_original_method = "85DE35A00A5168FE5C8491B5E07C3BBE", hash_generated_method = "83A18675D250A2D60ACEA9271EE0AAC7")
    @Deprecated
    public synchronized void setUserAgent(int ua) {
        addTaint(ua);
        String uaString = null;
    if(ua == 1)        
        {
    if(DESKTOP_USERAGENT.equals(mUserAgent))            
            {
                return;
            } //End block
            else
            {
                uaString = DESKTOP_USERAGENT;
            } //End block
        } //End block
        else
    if(ua == 2)        
        {
    if(IPHONE_USERAGENT.equals(mUserAgent))            
            {
                return;
            } //End block
            else
            {
                uaString = IPHONE_USERAGENT;
            } //End block
        } //End block
        else
    if(ua != 0)        
        {
            return;
        } //End block
        setUserAgentString(uaString);
        // ---------- Original Method ----------
        //String uaString = null;
        //if (ua == 1) {
            //if (DESKTOP_USERAGENT.equals(mUserAgent)) {
                //return; 
            //} else {
                //uaString = DESKTOP_USERAGENT;
            //}
        //} else if (ua == 2) {
            //if (IPHONE_USERAGENT.equals(mUserAgent)) {
                //return; 
            //} else {
                //uaString = IPHONE_USERAGENT;
            //}
        //} else if (ua != 0) {
            //return; 
        //}
        //setUserAgentString(uaString);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.610 -0400", hash_original_method = "622085E3817D576D67ED6E0D62241C79", hash_generated_method = "99ACBB44E6C1862DD0F98FA26F927866")
    @Deprecated
    public synchronized int getUserAgent() {
    if(DESKTOP_USERAGENT.equals(mUserAgent))        
        {
            int varC4CA4238A0B923820DCC509A6F75849B_162552268 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1486988359 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1486988359;
        } //End block
        else
    if(IPHONE_USERAGENT.equals(mUserAgent))        
        {
            int varC81E728D9D4C2F636F067F89CC14862C_325566973 = (2);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1798138360 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1798138360;
        } //End block
        else
    if(mUseDefaultUserAgent)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1091031260 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1621200617 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1621200617;
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1913631268 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1689719458 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1689719458;
        // ---------- Original Method ----------
        //if (DESKTOP_USERAGENT.equals(mUserAgent)) {
            //return 1;
        //} else if (IPHONE_USERAGENT.equals(mUserAgent)) {
            //return 2;
        //} else if (mUseDefaultUserAgent) {
            //return 0;
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.610 -0400", hash_original_method = "6232B93EE163514DA7A8F2A20C0E8296", hash_generated_method = "8FB4C239CC17E89B66B686DAE2CD068E")
    public synchronized void setUseWideViewPort(boolean use) {
    if(mUseWideViewport != use)        
        {
            mUseWideViewport = use;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mUseWideViewport != use) {
            //mUseWideViewport = use;
            //postSync();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.616 -0400", hash_original_method = "B42FD143593B620F53C7027879473593", hash_generated_method = "B12CC370CDE107E49C468B290D0EFB1D")
    public synchronized boolean getUseWideViewPort() {
        boolean var4E022A6EBF72CC69C3CF35943A51F619_1342480315 = (mUseWideViewport);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1208747760 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1208747760;
        // ---------- Original Method ----------
        //return mUseWideViewport;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.616 -0400", hash_original_method = "961D9442BDC4ECD4A72AED0ECCABFF49", hash_generated_method = "A62E95927C47DFDAC7DBD2A61E99317F")
    public synchronized void setSupportMultipleWindows(boolean support) {
    if(mSupportMultipleWindows != support)        
        {
            mSupportMultipleWindows = support;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mSupportMultipleWindows != support) {
            //mSupportMultipleWindows = support;
            //postSync();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.617 -0400", hash_original_method = "DC8997F98FC697774C788E0E9C368A15", hash_generated_method = "0B76867D7CB3D5D337C29CEC6C5D01C8")
    public synchronized boolean supportMultipleWindows() {
        boolean var426334A3E8E8819F8B6152B2D96C1902_892405681 = (mSupportMultipleWindows);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_429341902 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_429341902;
        // ---------- Original Method ----------
        //return mSupportMultipleWindows;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.617 -0400", hash_original_method = "CF796A65BC60375130249D0138E0D269", hash_generated_method = "4D215C334C6E01F80F7C88BA91724002")
    public synchronized void setLayoutAlgorithm(LayoutAlgorithm l) {
    if(mLayoutAlgorithm != l)        
        {
            mLayoutAlgorithm = l;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mLayoutAlgorithm != l) {
            //mLayoutAlgorithm = l;
            //postSync();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.617 -0400", hash_original_method = "D199B05491A7568F9921CD10D25BC54E", hash_generated_method = "E627D3EEE3FE6F2A85E463D929CFC6CC")
    public synchronized LayoutAlgorithm getLayoutAlgorithm() {
LayoutAlgorithm var204CDD3DC144FE754C7AA775EBA06CC5_1410611416 =         mLayoutAlgorithm;
        var204CDD3DC144FE754C7AA775EBA06CC5_1410611416.addTaint(taint);
        return var204CDD3DC144FE754C7AA775EBA06CC5_1410611416;
        // ---------- Original Method ----------
        //return mLayoutAlgorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.618 -0400", hash_original_method = "80141FBB7709CEF61745CB878BA8248B", hash_generated_method = "724B663B9FD12E5AE5FA99728C1335D4")
    public synchronized void setStandardFontFamily(String font) {
    if(font != null && !font.equals(mStandardFontFamily))        
        {
            mStandardFontFamily = font;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (font != null && !font.equals(mStandardFontFamily)) {
            //mStandardFontFamily = font;
            //postSync();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.618 -0400", hash_original_method = "D17418EAB461A3931F0EFDEA802C4808", hash_generated_method = "21F620012E64A4875FFF40C1D17F84BC")
    public synchronized String getStandardFontFamily() {
String varC2323C1961CCC92FBE9666D2F620C295_977752293 =         mStandardFontFamily;
        varC2323C1961CCC92FBE9666D2F620C295_977752293.addTaint(taint);
        return varC2323C1961CCC92FBE9666D2F620C295_977752293;
        // ---------- Original Method ----------
        //return mStandardFontFamily;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.618 -0400", hash_original_method = "85832E987C30A09FD65E322D8A53532D", hash_generated_method = "CB184341EA1E9A3A9A7987844387EA0F")
    public synchronized void setFixedFontFamily(String font) {
    if(font != null && !font.equals(mFixedFontFamily))        
        {
            mFixedFontFamily = font;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (font != null && !font.equals(mFixedFontFamily)) {
            //mFixedFontFamily = font;
            //postSync();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.619 -0400", hash_original_method = "91A5D658AFF46E5675EE0251B0448A37", hash_generated_method = "96AF9E177D3A771AFC6ADC3A50AA3EDD")
    public synchronized String getFixedFontFamily() {
String var453A77CFB409A7BA198C0C8D0A55C188_775970298 =         mFixedFontFamily;
        var453A77CFB409A7BA198C0C8D0A55C188_775970298.addTaint(taint);
        return var453A77CFB409A7BA198C0C8D0A55C188_775970298;
        // ---------- Original Method ----------
        //return mFixedFontFamily;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.619 -0400", hash_original_method = "5317C7E81FFF6267D702DE0B9A35C25F", hash_generated_method = "BA635A1BB620256EB2FB53C4A401BF21")
    public synchronized void setSansSerifFontFamily(String font) {
    if(font != null && !font.equals(mSansSerifFontFamily))        
        {
            mSansSerifFontFamily = font;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (font != null && !font.equals(mSansSerifFontFamily)) {
            //mSansSerifFontFamily = font;
            //postSync();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.619 -0400", hash_original_method = "E8B035ABC4C315E7FC00763BCE4B3101", hash_generated_method = "6CC773952672E372150AB04ADCEDE016")
    public synchronized String getSansSerifFontFamily() {
String var0951E059DBC0E72E6FB78569D216234E_1590523305 =         mSansSerifFontFamily;
        var0951E059DBC0E72E6FB78569D216234E_1590523305.addTaint(taint);
        return var0951E059DBC0E72E6FB78569D216234E_1590523305;
        // ---------- Original Method ----------
        //return mSansSerifFontFamily;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.620 -0400", hash_original_method = "B0B03F3832ADF5F3F163E426E788DEB1", hash_generated_method = "88CF7D908E70EAAC6D322B47C50516B6")
    public synchronized void setSerifFontFamily(String font) {
    if(font != null && !font.equals(mSerifFontFamily))        
        {
            mSerifFontFamily = font;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (font != null && !font.equals(mSerifFontFamily)) {
            //mSerifFontFamily = font;
            //postSync();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.620 -0400", hash_original_method = "AEE55B3207D2A837254BD0F18E5F431B", hash_generated_method = "14E8AA5B29A395A89F54D3B9E8DBB95A")
    public synchronized String getSerifFontFamily() {
String var5BE2E40B500827616D5F1DACA1DE414C_383367538 =         mSerifFontFamily;
        var5BE2E40B500827616D5F1DACA1DE414C_383367538.addTaint(taint);
        return var5BE2E40B500827616D5F1DACA1DE414C_383367538;
        // ---------- Original Method ----------
        //return mSerifFontFamily;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.621 -0400", hash_original_method = "8334AD5BA97572A472DE2E88CF457E83", hash_generated_method = "C683BC8A9E3A52AEA5BE4427B5AB4D92")
    public synchronized void setCursiveFontFamily(String font) {
    if(font != null && !font.equals(mCursiveFontFamily))        
        {
            mCursiveFontFamily = font;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (font != null && !font.equals(mCursiveFontFamily)) {
            //mCursiveFontFamily = font;
            //postSync();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.621 -0400", hash_original_method = "A9100EF4E222FCE0DCE66A7BF6E9785C", hash_generated_method = "AB6B4DE0A0E7FC6E28C4D2BC2F8F882A")
    public synchronized String getCursiveFontFamily() {
String var4268F048F8F465953A322CC0EA3072E4_942678986 =         mCursiveFontFamily;
        var4268F048F8F465953A322CC0EA3072E4_942678986.addTaint(taint);
        return var4268F048F8F465953A322CC0EA3072E4_942678986;
        // ---------- Original Method ----------
        //return mCursiveFontFamily;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.621 -0400", hash_original_method = "3BEE212C0CAB12BA1830E10645682B81", hash_generated_method = "DA2766F02C11CAF107FA3DEA5FF1DAF7")
    public synchronized void setFantasyFontFamily(String font) {
    if(font != null && !font.equals(mFantasyFontFamily))        
        {
            mFantasyFontFamily = font;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (font != null && !font.equals(mFantasyFontFamily)) {
            //mFantasyFontFamily = font;
            //postSync();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.622 -0400", hash_original_method = "3AB44712F248734E7DE5412E073462E0", hash_generated_method = "E9552800206A1AD7F64F33C23ED7421D")
    public synchronized String getFantasyFontFamily() {
String varB11A6B5782C3062153801D3970A8B2B3_515924854 =         mFantasyFontFamily;
        varB11A6B5782C3062153801D3970A8B2B3_515924854.addTaint(taint);
        return varB11A6B5782C3062153801D3970A8B2B3_515924854;
        // ---------- Original Method ----------
        //return mFantasyFontFamily;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.622 -0400", hash_original_method = "5B2F36FEBD6497C3F70A8544117DF67F", hash_generated_method = "D0C03ED65D32A9D0B10CBA4AF9963EE2")
    public synchronized void setMinimumFontSize(int size) {
        size = pin(size);
    if(mMinimumFontSize != size)        
        {
            mMinimumFontSize = size;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //size = pin(size);
        //if (mMinimumFontSize != size) {
            //mMinimumFontSize = size;
            //postSync();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.623 -0400", hash_original_method = "9F0281C9F2E3CE3701E30B7BA1EEFCDC", hash_generated_method = "4E0C7D38D8D784C75ABAC3E7B6878B9F")
    public synchronized int getMinimumFontSize() {
        int var1CED7631993D433AB3E3EAD56A97E4B5_1934413206 = (mMinimumFontSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1246552118 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1246552118;
        // ---------- Original Method ----------
        //return mMinimumFontSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.623 -0400", hash_original_method = "979D72ED8DED37C47A363976CA577A0C", hash_generated_method = "CC8304D57BC9F2254F129246B799A31C")
    public synchronized void setMinimumLogicalFontSize(int size) {
        size = pin(size);
    if(mMinimumLogicalFontSize != size)        
        {
            mMinimumLogicalFontSize = size;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //size = pin(size);
        //if (mMinimumLogicalFontSize != size) {
            //mMinimumLogicalFontSize = size;
            //postSync();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.623 -0400", hash_original_method = "4108641CDFB7F27DEA848BE579464C88", hash_generated_method = "EFE22580052E27C61615DD367C1D9C82")
    public synchronized int getMinimumLogicalFontSize() {
        int var16397BCD87AEDB5C4CAA0DDA7F3F318E_422732076 = (mMinimumLogicalFontSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_294645287 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_294645287;
        // ---------- Original Method ----------
        //return mMinimumLogicalFontSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.624 -0400", hash_original_method = "F015D29DAD166EF30FCB62EA8F22BD34", hash_generated_method = "771AC0EFA70AE45800781712A93198E0")
    public synchronized void setDefaultFontSize(int size) {
        size = pin(size);
    if(mDefaultFontSize != size)        
        {
            mDefaultFontSize = size;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //size = pin(size);
        //if (mDefaultFontSize != size) {
            //mDefaultFontSize = size;
            //postSync();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.624 -0400", hash_original_method = "DC87CC6F42B19166FD6192BC9DCDB609", hash_generated_method = "EA0A687055EAD4C4DBC7F2D9AF0F2BE8")
    public synchronized int getDefaultFontSize() {
        int var6886352F96FB7FB3509C56BF652A3D6F_588670836 = (mDefaultFontSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_917736404 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_917736404;
        // ---------- Original Method ----------
        //return mDefaultFontSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.625 -0400", hash_original_method = "F38EE7285BA7C36F298A402033D20C39", hash_generated_method = "0FB29AC3C80E3B44A0146BA96FBFA62B")
    public synchronized void setDefaultFixedFontSize(int size) {
        size = pin(size);
    if(mDefaultFixedFontSize != size)        
        {
            mDefaultFixedFontSize = size;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //size = pin(size);
        //if (mDefaultFixedFontSize != size) {
            //mDefaultFixedFontSize = size;
            //postSync();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.625 -0400", hash_original_method = "32FF94F6134070C3A3BF7D6E4734C806", hash_generated_method = "F6D34192C6536CAE7454518DD5DF0EC5")
    public synchronized int getDefaultFixedFontSize() {
        int var277FA59166BE5F07A75727E6F1E6256A_1211537453 = (mDefaultFixedFontSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1958840268 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1958840268;
        // ---------- Original Method ----------
        //return mDefaultFixedFontSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.626 -0400", hash_original_method = "E6659EF50725F66F9827ED33E4CFAB21", hash_generated_method = "9527A145900C649C5117DA2FAA06C397")
    public synchronized void setPageCacheCapacity(int size) {
    if(size < 0)        
        size = 0;
    if(size > 20)        
        size = 20;
    if(mPageCacheCapacity != size)        
        {
            mPageCacheCapacity = size;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (size < 0) size = 0;
        //if (size > 20) size = 20;
        //if (mPageCacheCapacity != size) {
            //mPageCacheCapacity = size;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.627 -0400", hash_original_method = "4253364D9E80624081FA0E0F6FDC86F7", hash_generated_method = "006ECAE2613F23BD4DADA78790AF2980")
    public synchronized void setLoadsImagesAutomatically(boolean flag) {
    if(mLoadsImagesAutomatically != flag)        
        {
            mLoadsImagesAutomatically = flag;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mLoadsImagesAutomatically != flag) {
            //mLoadsImagesAutomatically = flag;
            //postSync();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.628 -0400", hash_original_method = "55A6CB81C4460FAFC4A6B0D4FAE1ED88", hash_generated_method = "5A15A6302F50CA56D9882E1C29FAC422")
    public synchronized boolean getLoadsImagesAutomatically() {
        boolean var4EFDF4DFE342F71CCDA924B633275708_366294466 = (mLoadsImagesAutomatically);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2061656590 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2061656590;
        // ---------- Original Method ----------
        //return mLoadsImagesAutomatically;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.629 -0400", hash_original_method = "D93A9FC6AE1462BC3A72CE8E390FD0F6", hash_generated_method = "A8BA1197A5F0C97B3BD5B7B777C0DBD5")
    public synchronized void setBlockNetworkImage(boolean flag) {
    if(mBlockNetworkImage != flag)        
        {
            mBlockNetworkImage = flag;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mBlockNetworkImage != flag) {
            //mBlockNetworkImage = flag;
            //postSync();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.629 -0400", hash_original_method = "20F3224FE4B0DC8AEBED4FF3568A3BDD", hash_generated_method = "C41678427611ABD633723AC5EADD699D")
    public synchronized boolean getBlockNetworkImage() {
        boolean var184A06B4892767F2B78106DDB589FBF7_868315174 = (mBlockNetworkImage);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1106266123 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1106266123;
        // ---------- Original Method ----------
        //return mBlockNetworkImage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.629 -0400", hash_original_method = "244EC0C47571696247D156D16BFFBF27", hash_generated_method = "1DB492CB4004AF02C30F39711C6F4E86")
    public synchronized void setBlockNetworkLoads(boolean flag) {
    if(mBlockNetworkLoads != flag)        
        {
            mBlockNetworkLoads = flag;
            verifyNetworkAccess();
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mBlockNetworkLoads != flag) {
            //mBlockNetworkLoads = flag;
            //verifyNetworkAccess();
            //postSync();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.630 -0400", hash_original_method = "8F98673864D7321D7FB7DE6793DC0EC8", hash_generated_method = "2575036CC2289067621C977343B5C01E")
    public synchronized boolean getBlockNetworkLoads() {
        boolean varFF7A02E2205AE67F625F39019D239753_1931029791 = (mBlockNetworkLoads);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1007223015 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1007223015;
        // ---------- Original Method ----------
        //return mBlockNetworkLoads;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.630 -0400", hash_original_method = "4445E93EF699C8E4DE794753E49CA477", hash_generated_method = "72727F1E1CCAFE230320D85EC7A6DD21")
    private void verifyNetworkAccess() {
    if(!mBlockNetworkLoads)        
        {
    if(mContext.checkPermission("android.permission.INTERNET",
                    android.os.Process.myPid(), android.os.Process.myUid()) !=
                        PackageManager.PERMISSION_GRANTED)            
            {
                SecurityException varE249CB53B453896FEADF35A72FFEB5A8_1757610346 = new SecurityException
                        ("Permission denied - " +
                                "application missing INTERNET permission");
                varE249CB53B453896FEADF35A72FFEB5A8_1757610346.addTaint(taint);
                throw varE249CB53B453896FEADF35A72FFEB5A8_1757610346;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (!mBlockNetworkLoads) {
            //if (mContext.checkPermission("android.permission.INTERNET",
                    //android.os.Process.myPid(), android.os.Process.myUid()) !=
                        //PackageManager.PERMISSION_GRANTED) {
                //throw new SecurityException
                        //("Permission denied - " +
                                //"application missing INTERNET permission");
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.631 -0400", hash_original_method = "0BBFCDC224ADE5D71512B3B9C5FED4DC", hash_generated_method = "B76E7C530464C07FD00CE283FE1B79CB")
    public synchronized void setJavaScriptEnabled(boolean flag) {
    if(mJavaScriptEnabled != flag)        
        {
            mJavaScriptEnabled = flag;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mJavaScriptEnabled != flag) {
            //mJavaScriptEnabled = flag;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.631 -0400", hash_original_method = "8A9F66ACB83E46F66732CB0783F8BD97", hash_generated_method = "AC9C31EF301FDA55234E882CD7F32D5E")
    public synchronized void setHardwareAccelSkiaEnabled(boolean flag) {
    if(mHardwareAccelSkia != flag)        
        {
            mHardwareAccelSkia = flag;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mHardwareAccelSkia != flag) {
            //mHardwareAccelSkia = flag;
            //postSync();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.631 -0400", hash_original_method = "B41E73346B4841FDA1F28A35C0158347", hash_generated_method = "A2B35355736724F5E1D66973703C8433")
    public synchronized boolean getHardwareAccelSkiaEnabled() {
        boolean varEB21311A166E0F2DBA02B218D19B4AC9_1419789569 = (mHardwareAccelSkia);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1560623377 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1560623377;
        // ---------- Original Method ----------
        //return mHardwareAccelSkia;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.632 -0400", hash_original_method = "69FE03F7A269EF1D16FCCD39ECE7D049", hash_generated_method = "70118629FB48BC31CDC0E5F0131B7539")
    public synchronized void setShowVisualIndicator(boolean flag) {
    if(mShowVisualIndicator != flag)        
        {
            mShowVisualIndicator = flag;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mShowVisualIndicator != flag) {
            //mShowVisualIndicator = flag;
            //postSync();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.632 -0400", hash_original_method = "C63472D12B908062A1CEAE79E75779C9", hash_generated_method = "A7D8D88018518639BC894BF06D71F221")
    public synchronized boolean getShowVisualIndicator() {
        boolean varB43EF6CB92DDDD967AA82418BC205214_421293942 = (mShowVisualIndicator);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1892559180 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1892559180;
        // ---------- Original Method ----------
        //return mShowVisualIndicator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.632 -0400", hash_original_method = "05BB2A888D33554F620DCC4B01FA7575", hash_generated_method = "111033F6059DDDD53D879E0C4C968AEA")
    @Deprecated
    public synchronized void setPluginsEnabled(boolean flag) {
        addTaint(flag);
        setPluginState(flag ? PluginState.ON : PluginState.OFF);
        // ---------- Original Method ----------
        //setPluginState(flag ? PluginState.ON : PluginState.OFF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.633 -0400", hash_original_method = "DB94ACE3494108D6193A811AD96FC597", hash_generated_method = "D3E8ECEF7C81240D8520E3D7DC7A5A88")
    public synchronized void setPluginState(PluginState state) {
    if(mPluginState != state)        
        {
            mPluginState = state;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mPluginState != state) {
            //mPluginState = state;
            //postSync();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.633 -0400", hash_original_method = "773787F5C9956C3834DA2A6EB4286614", hash_generated_method = "2374B3E0E5D807A3349883E976985366")
    @Deprecated
    public synchronized void setPluginsPath(String pluginsPath) {
        addTaint(pluginsPath.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.633 -0400", hash_original_method = "AF758F2CA723722CB4C8BF68969FC2D2", hash_generated_method = "FE951B42DADBE726FC6298063497D7B7")
    public synchronized void setDatabasePath(String databasePath) {
    if(databasePath != null && !mDatabasePathHasBeenSet)        
        {
            mDatabasePath = databasePath;
            mDatabasePathHasBeenSet = true;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (databasePath != null && !mDatabasePathHasBeenSet) {
            //mDatabasePath = databasePath;
            //mDatabasePathHasBeenSet = true;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.634 -0400", hash_original_method = "BC0F324C7AC101E200A0E358BDBC7AB1", hash_generated_method = "BF69870B320812A112DB079CC8951211")
    public synchronized void setGeolocationDatabasePath(String databasePath) {
    if(databasePath != null
                && !databasePath.equals(mGeolocationDatabasePath))        
        {
            mGeolocationDatabasePath = databasePath;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (databasePath != null
                //&& !databasePath.equals(mGeolocationDatabasePath)) {
            //mGeolocationDatabasePath = databasePath;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.634 -0400", hash_original_method = "F95CC1B9D2327BC5BCD822D16CE23DEA", hash_generated_method = "3ED25C02C90AD08A9D462807E54EEA03")
    public synchronized void setAppCacheEnabled(boolean flag) {
    if(mAppCacheEnabled != flag)        
        {
            mAppCacheEnabled = flag;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mAppCacheEnabled != flag) {
            //mAppCacheEnabled = flag;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.635 -0400", hash_original_method = "C7AB159C419EE425C63EEE7B4C162DEF", hash_generated_method = "B40AB22D7676452A82ACE26F8989F28F")
    public synchronized void setAppCachePath(String appCachePath) {
    if(appCachePath != null && !appCachePath.equals(mAppCachePath))        
        {
            mAppCachePath = appCachePath;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (appCachePath != null && !appCachePath.equals(mAppCachePath)) {
            //mAppCachePath = appCachePath;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.635 -0400", hash_original_method = "55D93840C546554373F35F660C5755AC", hash_generated_method = "DA4779B6CAFAEFA48DF6C010F725D898")
    public synchronized void setAppCacheMaxSize(long appCacheMaxSize) {
    if(appCacheMaxSize != mAppCacheMaxSize)        
        {
            mAppCacheMaxSize = appCacheMaxSize;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (appCacheMaxSize != mAppCacheMaxSize) {
            //mAppCacheMaxSize = appCacheMaxSize;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.635 -0400", hash_original_method = "869B3AB9767C9688E84644FF6FE71246", hash_generated_method = "8D8E3B449B60932E27E339F26C7BA1DE")
    public synchronized void setDatabaseEnabled(boolean flag) {
    if(mDatabaseEnabled != flag)        
        {
            mDatabaseEnabled = flag;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mDatabaseEnabled != flag) {
           //mDatabaseEnabled = flag;
           //postSync();
       //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.636 -0400", hash_original_method = "1833A47C66872FD150B68FE6759B0625", hash_generated_method = "82E041B98A1C87FED6913F44E0A0281B")
    public synchronized void setDomStorageEnabled(boolean flag) {
    if(mDomStorageEnabled != flag)        
        {
            mDomStorageEnabled = flag;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mDomStorageEnabled != flag) {
           //mDomStorageEnabled = flag;
           //postSync();
       //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.636 -0400", hash_original_method = "F0262AC32F151E97C7BD7687A4F30118", hash_generated_method = "FDFF98B3DB79DA13C9F2EEF300AB2B79")
    public synchronized boolean getDomStorageEnabled() {
        boolean varD0A927B9A1C760031CAA5DDA7BBFD388_2119533613 = (mDomStorageEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1186017041 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1186017041;
        // ---------- Original Method ----------
        //return mDomStorageEnabled;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.636 -0400", hash_original_method = "B06914FF8620CDD00A7D2E76B4DC9F8E", hash_generated_method = "944FD8520F4A516AC1BB3903E3819C63")
    public synchronized String getDatabasePath() {
String var09ADE5DECF0573905A2C722EF656BEFD_34330878 =         mDatabasePath;
        var09ADE5DECF0573905A2C722EF656BEFD_34330878.addTaint(taint);
        return var09ADE5DECF0573905A2C722EF656BEFD_34330878;
        // ---------- Original Method ----------
        //return mDatabasePath;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.636 -0400", hash_original_method = "B3A6EABACA6DB5DAD1BC523D1F7D938A", hash_generated_method = "F764C4A72185C0A301378B1F7E70180E")
    public synchronized boolean getDatabaseEnabled() {
        boolean varA1FF3A7CF6B05DEBD8460B2CB48B0856_1941798993 = (mDatabaseEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_547320967 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_547320967;
        // ---------- Original Method ----------
        //return mDatabaseEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.637 -0400", hash_original_method = "5C3A0FF2F7925F672A8F3BF470C8C1B9", hash_generated_method = "2145D7D320B33EA7A8DA240334B657D2")
    public synchronized void setWorkersEnabled(boolean flag) {
    if(mWorkersEnabled != flag)        
        {
            mWorkersEnabled = flag;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mWorkersEnabled != flag) {
            //mWorkersEnabled = flag;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.637 -0400", hash_original_method = "1B37EF49E1DD23D92EBFCAE289865E03", hash_generated_method = "241A2DB45C62A93F1FA32F366F8956FF")
    public synchronized void setGeolocationEnabled(boolean flag) {
    if(mGeolocationEnabled != flag)        
        {
            mGeolocationEnabled = flag;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mGeolocationEnabled != flag) {
            //mGeolocationEnabled = flag;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.638 -0400", hash_original_method = "ED4873F24C9B96C88ADEA94C6CEBF439", hash_generated_method = "B84327DEB02009204CF4A60D7F7A9697")
    public synchronized void setXSSAuditorEnabled(boolean flag) {
    if(mXSSAuditorEnabled != flag)        
        {
            mXSSAuditorEnabled = flag;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mXSSAuditorEnabled != flag) {
            //mXSSAuditorEnabled = flag;
            //postSync();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.820 -0400", hash_original_method = "0DFFCBD94870E084A8277321728F548A", hash_generated_method = "CDB2DA0A80802922E4B35F4FD1C8D0D9")
    public synchronized boolean getJavaScriptEnabled() {
        boolean var707CBF1A08CFDB7819946B136B8EB5C6_2104385819 = (mJavaScriptEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_738481531 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_738481531;
        // ---------- Original Method ----------
        //return mJavaScriptEnabled;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.820 -0400", hash_original_method = "71CDB5FC63B182B87115D2DBE9F21219", hash_generated_method = "677116288B9AC8A518531D7C73F37D22")
    @Deprecated
    public synchronized boolean getPluginsEnabled() {
        boolean var2D9750CF298E5139E5C20C7D6B70811E_56903001 = (mPluginState == PluginState.ON);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_452711396 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_452711396;
        // ---------- Original Method ----------
        //return mPluginState == PluginState.ON;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.820 -0400", hash_original_method = "F64B7B770EF5DD5F7B0D7EE789561CF2", hash_generated_method = "6E85ED2904CD33C4EFCDD6BCF5FB1681")
    public synchronized PluginState getPluginState() {
PluginState var64622CACFBD4FB77B6311C98F3645FA8_1469409909 =         mPluginState;
        var64622CACFBD4FB77B6311C98F3645FA8_1469409909.addTaint(taint);
        return var64622CACFBD4FB77B6311C98F3645FA8_1469409909;
        // ---------- Original Method ----------
        //return mPluginState;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.820 -0400", hash_original_method = "9447E36E214BB4441498CEE16910C171", hash_generated_method = "4921C8FC61CE18826FFDD9C6D0AE2A6A")
    @Deprecated
    public synchronized String getPluginsPath() {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_409013787 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_409013787.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_409013787;
        // ---------- Original Method ----------
        //return "";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.821 -0400", hash_original_method = "4CDCF2B2AC7A9689B491AFCE4B80F0EB", hash_generated_method = "931C629023BFB895281F385B1BF9B198")
    public synchronized void setJavaScriptCanOpenWindowsAutomatically(
            boolean flag) {
    if(mJavaScriptCanOpenWindowsAutomatically != flag)        
        {
            mJavaScriptCanOpenWindowsAutomatically = flag;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mJavaScriptCanOpenWindowsAutomatically != flag) {
            //mJavaScriptCanOpenWindowsAutomatically = flag;
            //postSync();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.821 -0400", hash_original_method = "79E98D32B2FE915E7B4CD55D0B1C896F", hash_generated_method = "CAAE502FF1CC121D4FB05F608D878C1A")
    public synchronized boolean getJavaScriptCanOpenWindowsAutomatically() {
        boolean varDF402D9036608C9172BF297E4CBAC36D_411489108 = (mJavaScriptCanOpenWindowsAutomatically);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1093935140 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1093935140;
        // ---------- Original Method ----------
        //return mJavaScriptCanOpenWindowsAutomatically;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.822 -0400", hash_original_method = "A24B805E1ED21576385EF437050E004D", hash_generated_method = "EB125807562DD6A96C8FC5B9FC6B1CF8")
    public synchronized void setDefaultTextEncodingName(String encoding) {
    if(encoding != null && !encoding.equals(mDefaultTextEncoding))        
        {
            mDefaultTextEncoding = encoding;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (encoding != null && !encoding.equals(mDefaultTextEncoding)) {
            //mDefaultTextEncoding = encoding;
            //postSync();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.822 -0400", hash_original_method = "C5F48A0B5AD67EA38BD640610E4387AC", hash_generated_method = "49353E1606494645C80FEAA6DAE03AB8")
    public synchronized String getDefaultTextEncodingName() {
String varFBF8D4E5D31D3452180EB440EBF187F9_396844247 =         mDefaultTextEncoding;
        varFBF8D4E5D31D3452180EB440EBF187F9_396844247.addTaint(taint);
        return varFBF8D4E5D31D3452180EB440EBF187F9_396844247;
        // ---------- Original Method ----------
        //return mDefaultTextEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.823 -0400", hash_original_method = "EF76B53D37FAD17B99E355E5158D3AE3", hash_generated_method = "4096CC9F38B94167C96CFC9D088EF85B")
    public synchronized void setUserAgentString(String ua) {
    if(ua == null || ua.length() == 0)        
        {
            synchronized
(sLockForLocaleSettings)            {
                Locale currentLocale = Locale.getDefault();
    if(!sLocale.equals(currentLocale))                
                {
                    sLocale = currentLocale;
                    mAcceptLanguage = getCurrentAcceptLanguage();
                } //End block
            } //End block
            ua = getCurrentUserAgent();
            mUseDefaultUserAgent = true;
        } //End block
        else
        {
            mUseDefaultUserAgent = false;
        } //End block
    if(!ua.equals(mUserAgent))        
        {
            mUserAgent = ua;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (ua == null || ua.length() == 0) {
            //synchronized(sLockForLocaleSettings) {
                //Locale currentLocale = Locale.getDefault();
                //if (!sLocale.equals(currentLocale)) {
                    //sLocale = currentLocale;
                    //mAcceptLanguage = getCurrentAcceptLanguage();
                //}
            //}
            //ua = getCurrentUserAgent();
            //mUseDefaultUserAgent = true;
        //} else  {
            //mUseDefaultUserAgent = false;
        //}
        //if (!ua.equals(mUserAgent)) {
            //mUserAgent = ua;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.824 -0400", hash_original_method = "2522780DB5B181D072BE72836FEE2179", hash_generated_method = "8874F9A4C528D3815D5DF2DDADFAF8D5")
    public synchronized String getUserAgentString() {
    if(DESKTOP_USERAGENT.equals(mUserAgent) ||
                IPHONE_USERAGENT.equals(mUserAgent) ||
                !mUseDefaultUserAgent)        
        {
String var335897D5BF56D3EA7F3758538DEBFEFF_1509897488 =             mUserAgent;
            var335897D5BF56D3EA7F3758538DEBFEFF_1509897488.addTaint(taint);
            return var335897D5BF56D3EA7F3758538DEBFEFF_1509897488;
        } //End block
        boolean doPostSync = false;
        synchronized
(sLockForLocaleSettings)        {
            Locale currentLocale = Locale.getDefault();
    if(!sLocale.equals(currentLocale))            
            {
                sLocale = currentLocale;
                mUserAgent = getCurrentUserAgent();
                mAcceptLanguage = getCurrentAcceptLanguage();
                doPostSync = true;
            } //End block
        } //End block
    if(doPostSync)        
        {
            postSync();
        } //End block
String var335897D5BF56D3EA7F3758538DEBFEFF_827319889 =         mUserAgent;
        var335897D5BF56D3EA7F3758538DEBFEFF_827319889.addTaint(taint);
        return var335897D5BF56D3EA7F3758538DEBFEFF_827319889;
        // ---------- Original Method ----------
        //if (DESKTOP_USERAGENT.equals(mUserAgent) ||
                //IPHONE_USERAGENT.equals(mUserAgent) ||
                //!mUseDefaultUserAgent) {
            //return mUserAgent;
        //}
        //boolean doPostSync = false;
        //synchronized(sLockForLocaleSettings) {
            //Locale currentLocale = Locale.getDefault();
            //if (!sLocale.equals(currentLocale)) {
                //sLocale = currentLocale;
                //mUserAgent = getCurrentUserAgent();
                //mAcceptLanguage = getCurrentAcceptLanguage();
                //doPostSync = true;
            //}
        //}
        //if (doPostSync) {
            //postSync();
        //}
        //return mUserAgent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.824 -0400", hash_original_method = "D20FFE724413B630D767FC3330D85D9B", hash_generated_method = "D9EE13D06F8F02119EAE47CAC0935330")
    synchronized String getAcceptLanguage() {
        synchronized
(sLockForLocaleSettings)        {
            Locale currentLocale = Locale.getDefault();
    if(!sLocale.equals(currentLocale))            
            {
                sLocale = currentLocale;
                mAcceptLanguage = getCurrentAcceptLanguage();
            } //End block
        } //End block
String var4F4D12599D633053CBC85A8AA103D90E_915694360 =         mAcceptLanguage;
        var4F4D12599D633053CBC85A8AA103D90E_915694360.addTaint(taint);
        return var4F4D12599D633053CBC85A8AA103D90E_915694360;
        // ---------- Original Method ----------
        //synchronized(sLockForLocaleSettings) {
            //Locale currentLocale = Locale.getDefault();
            //if (!sLocale.equals(currentLocale)) {
                //sLocale = currentLocale;
                //mAcceptLanguage = getCurrentAcceptLanguage();
            //}
        //}
        //return mAcceptLanguage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.825 -0400", hash_original_method = "1949FADEB987BBB9FFD42544F3D5731B", hash_generated_method = "23477CF656FFD1A663D03257237CC82F")
     boolean isNarrowColumnLayout() {
        boolean var99A4DD0BA17C4D3916FB39A801BD55DD_1373954432 = (getLayoutAlgorithm() == LayoutAlgorithm.NARROW_COLUMNS);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_70281003 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_70281003;
        // ---------- Original Method ----------
        //return getLayoutAlgorithm() == LayoutAlgorithm.NARROW_COLUMNS;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.825 -0400", hash_original_method = "0197ABD852A904C83B0994DA40EDDF11", hash_generated_method = "05A68B3D53B7DB8A16EC4EB4288E385A")
    public void setNeedInitialFocus(boolean flag) {
    if(mNeedInitialFocus != flag)        
        {
            mNeedInitialFocus = flag;
        } //End block
        // ---------- Original Method ----------
        //if (mNeedInitialFocus != flag) {
            //mNeedInitialFocus = flag;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.825 -0400", hash_original_method = "D1C04B216D0AC5093D2F075C6698B7EE", hash_generated_method = "D79F77E055812B5C5A2AD6DC8D38A185")
     boolean getNeedInitialFocus() {
        boolean var820CEB0204DC67DEC0541F055959708A_434469060 = (mNeedInitialFocus);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_819432853 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_819432853;
        // ---------- Original Method ----------
        //return mNeedInitialFocus;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.826 -0400", hash_original_method = "ADE96AEA7507FA885C654AF6A7AF6825", hash_generated_method = "797489A82414FABADB8B85D2C13B14AC")
    public synchronized void setRenderPriority(RenderPriority priority) {
    if(mRenderPriority != priority)        
        {
            mRenderPriority = priority;
            mEventHandler.sendMessage(Message.obtain(null,
                    EventHandler.PRIORITY));
        } //End block
        // ---------- Original Method ----------
        //if (mRenderPriority != priority) {
            //mRenderPriority = priority;
            //mEventHandler.sendMessage(Message.obtain(null,
                    //EventHandler.PRIORITY));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.826 -0400", hash_original_method = "C16F91A0BF5BCFC94071B85F47E4B2E9", hash_generated_method = "D970A1AF8762DC7784F4CF34C3544E3B")
    public void setCacheMode(int mode) {
    if(mode != mOverrideCacheMode)        
        {
            mOverrideCacheMode = mode;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mode != mOverrideCacheMode) {
            //mOverrideCacheMode = mode;
            //postSync();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.826 -0400", hash_original_method = "4A960A8ACA504F48F41DB237F9209DA9", hash_generated_method = "BF9AFFE98C4557DDB4DAFB1EC8135CB0")
    public int getCacheMode() {
        int var78B36B7BB0452881B8B7324BB5C0D0C6_1970327574 = (mOverrideCacheMode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1961501006 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1961501006;
        // ---------- Original Method ----------
        //return mOverrideCacheMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.827 -0400", hash_original_method = "9F8C026B57F7FDFD26FE193DA8C87BB6", hash_generated_method = "05DD6215B4364E5E03CBD9C423B1B7CA")
    public void setShrinksStandaloneImagesToFit(boolean shrink) {
    if(mShrinksStandaloneImagesToFit != shrink)        
        {
            mShrinksStandaloneImagesToFit = shrink;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mShrinksStandaloneImagesToFit != shrink) {
            //mShrinksStandaloneImagesToFit = shrink;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.827 -0400", hash_original_method = "041EEBDF0CC6DB4D857EE5FE00439A69", hash_generated_method = "2E832976280C843DBE994376E28B6AFA")
    public void setMaximumDecodedImageSize(long size) {
    if(mMaximumDecodedImageSize != size)        
        {
            mMaximumDecodedImageSize = size;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mMaximumDecodedImageSize != size) {
            //mMaximumDecodedImageSize = size;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.827 -0400", hash_original_method = "37CD2CB6E6E70B184FA7FDB5F22FF522", hash_generated_method = "BCB96E0CDCC2C0C88175B83DF603892A")
     boolean getUseFixedViewport() {
        boolean varA51C20A0FE1B2ECC6101FEF8C98C549F_1213024374 = (getUseWideViewPort());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1849256966 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1849256966;
        // ---------- Original Method ----------
        //return getUseWideViewPort();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.828 -0400", hash_original_method = "F442F079E2DD19439C88D9FB5E3A709B", hash_generated_method = "41B5996EC4E312FDDDBBEBEDEBAA5D8A")
     boolean isPrivateBrowsingEnabled() {
        boolean var7D859B4BFCBF6FEA0D71AF4F7D782122_278407358 = (mPrivateBrowsingEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1447114195 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1447114195;
        // ---------- Original Method ----------
        //return mPrivateBrowsingEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.828 -0400", hash_original_method = "34042B5DCA297E4EBEB0CC9227844924", hash_generated_method = "D55DA92CCE574D999F3216C3F666458F")
    synchronized void setPrivateBrowsingEnabled(boolean flag) {
    if(mPrivateBrowsingEnabled != flag)        
        {
            mPrivateBrowsingEnabled = flag;
            setAutoFillEnabled(mAutoFillEnabled);
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mPrivateBrowsingEnabled != flag) {
            //mPrivateBrowsingEnabled = flag;
            //setAutoFillEnabled(mAutoFillEnabled);
            //postSync();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.828 -0400", hash_original_method = "9C2B0A9C4AD9BDB94288AB167718CCA9", hash_generated_method = "5147CD9F6E5A2AEE4F36CCF4F83CF818")
    public boolean forceUserScalable() {
        boolean var848CE56F11C41CF540C3E3D9775A50CD_1614316761 = (mForceUserScalable);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_980543069 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_980543069;
        // ---------- Original Method ----------
        //return mForceUserScalable;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.829 -0400", hash_original_method = "1D6F9D93B2A4A93CBF13AD0469B99A04", hash_generated_method = "7138B412D9EF0A057D7618421D7F0639")
    public synchronized void setForceUserScalable(boolean flag) {
        mForceUserScalable = flag;
        // ---------- Original Method ----------
        //mForceUserScalable = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.829 -0400", hash_original_method = "5D9DAFAFBF77CCE3ED840C406B6898AF", hash_generated_method = "DAD7E3131EFE7AC3635DB02DE70DE0E1")
    synchronized void setSyntheticLinksEnabled(boolean flag) {
    if(mSyntheticLinksEnabled != flag)        
        {
            mSyntheticLinksEnabled = flag;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mSyntheticLinksEnabled != flag) {
            //mSyntheticLinksEnabled = flag;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.829 -0400", hash_original_method = "1A8C919F0F6505492DC614E84115DF0C", hash_generated_method = "F61C7134BE409D0B39FF0DC9DB0724EC")
    public synchronized void setAutoFillEnabled(boolean enabled) {
        addTaint(enabled);
        boolean autoFillEnabled = enabled && !mPrivateBrowsingEnabled;
    if(mAutoFillEnabled != autoFillEnabled)        
        {
            mAutoFillEnabled = autoFillEnabled;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //boolean autoFillEnabled = enabled && !mPrivateBrowsingEnabled;
        //if (mAutoFillEnabled != autoFillEnabled) {
            //mAutoFillEnabled = autoFillEnabled;
            //postSync();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.829 -0400", hash_original_method = "8774A835D2148EBC629E39CB3DCAFA63", hash_generated_method = "D8099F9151248D98D6F7C75DC98D9352")
    public synchronized boolean getAutoFillEnabled() {
        boolean var50EA70E6285C1FCC7F3B54A690D3A99B_975924473 = (mAutoFillEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1187747274 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1187747274;
        // ---------- Original Method ----------
        //return mAutoFillEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.830 -0400", hash_original_method = "3148173678A0F0377520D6B2C8079A70", hash_generated_method = "4AC5916B6C89A554548624C538C5A9FE")
    public synchronized void setAutoFillProfile(AutoFillProfile profile) {
    if(mAutoFillProfile != profile)        
        {
            mAutoFillProfile = profile;
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mAutoFillProfile != profile) {
            //mAutoFillProfile = profile;
            //postSync();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.830 -0400", hash_original_method = "40495DA1FFE9EC3467407968672CDCF7", hash_generated_method = "0F7E9EA12BC599F7D80E0ABE4684F439")
    public synchronized AutoFillProfile getAutoFillProfile() {
AutoFillProfile varDCF553BB5F5743139326AD6AFF33B6D4_1097100164 =         mAutoFillProfile;
        varDCF553BB5F5743139326AD6AFF33B6D4_1097100164.addTaint(taint);
        return varDCF553BB5F5743139326AD6AFF33B6D4_1097100164;
        // ---------- Original Method ----------
        //return mAutoFillProfile;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.830 -0400", hash_original_method = "C3E1D2408E91E83D6659CE445CE89780", hash_generated_method = "6FACDFF04082469DA9D6E0BDD6095E7F")
     int getDoubleTapToastCount() {
        int var17BCFD6E10D42DFDED1479FBB922DF4A_1483276588 = (mDoubleTapToastCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_302066918 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_302066918;
        // ---------- Original Method ----------
        //return mDoubleTapToastCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.831 -0400", hash_original_method = "3B766C36F75F383AEAB183DB6ECCA431", hash_generated_method = "748D32156F971838C8466AB83CD0C4D1")
     void setDoubleTapToastCount(int count) {
        addTaint(count);
    if(mDoubleTapToastCount != count)        
        {
            mDoubleTapToastCount = count;
            mEventHandler.sendMessage(Message.obtain(null,
                    EventHandler.SET_DOUBLE_TAP_TOAST_COUNT));
        } //End block
        // ---------- Original Method ----------
        //if (mDoubleTapToastCount != count) {
            //mDoubleTapToastCount = count;
            //mEventHandler.sendMessage(Message.obtain(null,
                    //EventHandler.SET_DOUBLE_TAP_TOAST_COUNT));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.831 -0400", hash_original_method = "51A1E424E5F24F0C6AF042B09286C12C", hash_generated_method = "2FBBC9B17F398A03B1F17079F3321661")
    public void setProperty(String key, String value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
    if(mWebView.nativeSetProperty(key, value))        
        {
            mWebView.contentInvalidateAll();
        } //End block
        // ---------- Original Method ----------
        //if (mWebView.nativeSetProperty(key, value)) {
            //mWebView.contentInvalidateAll();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.831 -0400", hash_original_method = "E79B730EE57AB5AA3332F72B80B24914", hash_generated_method = "D4BF0C42C0D0013CA93D3C8DC394DA3A")
    public String getProperty(String key) {
        addTaint(key.getTaint());
String var953EAE7B2F85C0E869D0F2008318D845_650669331 =         mWebView.nativeGetProperty(key);
        var953EAE7B2F85C0E869D0F2008318D845_650669331.addTaint(taint);
        return var953EAE7B2F85C0E869D0F2008318D845_650669331;
        // ---------- Original Method ----------
        //return mWebView.nativeGetProperty(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.832 -0400", hash_original_method = "B2134E4964C5B0957E3BC21A40B5447F", hash_generated_method = "B30157721046338430C3F847FFC8E60F")
    synchronized void syncSettingsAndCreateHandler(BrowserFrame frame) {
        mBrowserFrame = frame;
    if(DebugFlags.WEB_SETTINGS)        
        {
            junit.framework.Assert.assertTrue(frame.mNativeFrame != 0);
        } //End block
        SharedPreferences sp = mContext.getSharedPreferences(PREF_FILE,
                Context.MODE_PRIVATE);
    if(mDoubleTapToastCount > 0)        
        {
            mDoubleTapToastCount = sp.getInt(DOUBLE_TAP_TOAST_COUNT,
                    mDoubleTapToastCount);
        } //End block
        nativeSync(frame.mNativeFrame);
        mSyncPending = false;
        mEventHandler.createHandler();
        // ---------- Original Method ----------
        //mBrowserFrame = frame;
        //if (DebugFlags.WEB_SETTINGS) {
            //junit.framework.Assert.assertTrue(frame.mNativeFrame != 0);
        //}
        //SharedPreferences sp = mContext.getSharedPreferences(PREF_FILE,
                //Context.MODE_PRIVATE);
        //if (mDoubleTapToastCount > 0) {
            //mDoubleTapToastCount = sp.getInt(DOUBLE_TAP_TOAST_COUNT,
                    //mDoubleTapToastCount);
        //}
        //nativeSync(frame.mNativeFrame);
        //mSyncPending = false;
        //mEventHandler.createHandler();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.832 -0400", hash_original_method = "97F607FA924E3FA8AA008A1519BCA623", hash_generated_method = "B8CB642682401D5017A0F8BB624FB20A")
    synchronized void onDestroyed() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.833 -0400", hash_original_method = "32C980BFA3F312B2745A36CC144BD5C9", hash_generated_method = "B1A98061BCE1393BD98132A96879861A")
    private int pin(int size) {
        addTaint(size);
    if(size < 1)        
        {
            int varC4CA4238A0B923820DCC509A6F75849B_2025823572 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1971353018 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1971353018;
        } //End block
        else
    if(size > 72)        
        {
            int var32BB90E8976AAB5298D5DA10FE66F21D_216178252 = (72);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_343426830 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_343426830;
        } //End block
        int varF7BD60B75B29D79B660A2859395C1A24_1553871697 = (size);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1681808894 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1681808894;
        // ---------- Original Method ----------
        //if (size < 1) {
            //return 1;
        //} else if (size > 72) {
            //return 72;
        //}
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.833 -0400", hash_original_method = "028ACD01F22F62E6B019AFF3AD2AE2F1", hash_generated_method = "CF312E77451B47E2F44D5FE40AFD1B62")
    private synchronized void postSync() {
    if(!mSyncPending)        
        {
            mSyncPending = mEventHandler.sendMessage(
                    Message.obtain(null, EventHandler.SYNC));
        } //End block
        // ---------- Original Method ----------
        //if (!mSyncPending) {
            //mSyncPending = mEventHandler.sendMessage(
                    //Message.obtain(null, EventHandler.SYNC));
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.833 -0400", hash_original_method = "B9A4DA2D5B0DA0061612E5CC599DFA25", hash_generated_method = "04F53D1036DE1FABEDB87AC10815507F")
    private void nativeSync(int nativeFrame) {
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
        TextSize(int size) {
            value = size;
        }
        int value;
    }

    
    public enum ZoomDensity {
        FAR(150),      
        MEDIUM(100),    
        CLOSE(75);     
        ZoomDensity(int size) {
            value = size;
        }
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.833 -0400", hash_original_field = "6E665E2F7DF5FB1932FA473B8AE84F08", hash_generated_field = "702EBB63B52AE60657B34C8A34DF32C2")

        private int mUniqueId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.834 -0400", hash_original_field = "7C2ED77704BD0668218967DAF6DB51FD", hash_generated_field = "D1AA858CAC76B61ED536CD7E9E76BE21")

        private String mFullName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.834 -0400", hash_original_field = "1926262D46C3AB2D57B278A3A4B76597", hash_generated_field = "A0AF6DFDA7362BDA261A45220D527187")

        private String mEmailAddress;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.834 -0400", hash_original_field = "B99930177776BA623D88C05D8012668F", hash_generated_field = "64315C7772C2603B359A256D253AD04F")

        private String mCompanyName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.834 -0400", hash_original_field = "53E31CD418D6C401C2F047A324C04D01", hash_generated_field = "E8334A774D023DCDB51748F3A66127C5")

        private String mAddressLine1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.835 -0400", hash_original_field = "7D4BD855C83D1D87736C705A5C84268D", hash_generated_field = "4E58D56AF067C60E87EAB54C984D9419")

        private String mAddressLine2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.835 -0400", hash_original_field = "5F0F1085E7414563A2B4D2E8E37D568E", hash_generated_field = "1C2845D6D4FC6B2B1D1EAAA1F2A427AE")

        private String mCity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.835 -0400", hash_original_field = "48A902C1D749B47EBC75C77370D5A1F0", hash_generated_field = "B61FE231018E4E04E31044A1AA845D59")

        private String mState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.835 -0400", hash_original_field = "9C403CDE0E845E76471FE0DBB48F2102", hash_generated_field = "068EDE81B58924A221B365F3B7E4D5D4")

        private String mZipCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.835 -0400", hash_original_field = "41CE3E330DA2FB7F8008CDC4B3CC3773", hash_generated_field = "ED069FCB05E21E7854BDD84A7C5A61F9")

        private String mCountry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.835 -0400", hash_original_field = "6A2642B1AA7D9D60E8BC8ABEC1C8C01C", hash_generated_field = "D33476978CD54C942ED6226611614D21")

        private String mPhoneNumber;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.836 -0400", hash_original_method = "356718E28156E1213C1513B4F67A401A", hash_generated_method = "C70C537927799DC936356084302DBC48")
        public  AutoFillProfile(int uniqueId, String fullName, String email,
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
            // ---------- Original Method ----------
            //mUniqueId = uniqueId;
            //mFullName = fullName;
            //mEmailAddress = email;
            //mCompanyName = companyName;
            //mAddressLine1 = addressLine1;
            //mAddressLine2 = addressLine2;
            //mCity = city;
            //mState = state;
            //mZipCode = zipCode;
            //mCountry = country;
            //mPhoneNumber = phoneNumber;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.836 -0400", hash_original_method = "F64F21D16CFD05D4B80E501A354D44C1", hash_generated_method = "826E563F64E051CDDF5426C8E4F69DAC")
        public int getUniqueId() {
            int var6E665E2F7DF5FB1932FA473B8AE84F08_1925084874 = (mUniqueId);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_237135904 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_237135904;
            // ---------- Original Method ----------
            //return mUniqueId;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.837 -0400", hash_original_method = "1443687462A2902C11BD4613CE447F4A", hash_generated_method = "DDE8E9A86981077D12F87145057D49D8")
        public String getFullName() {
String var2CCB86D92A5B0C93E777B6E62E71CDC6_273238264 =             mFullName;
            var2CCB86D92A5B0C93E777B6E62E71CDC6_273238264.addTaint(taint);
            return var2CCB86D92A5B0C93E777B6E62E71CDC6_273238264;
            // ---------- Original Method ----------
            //return mFullName;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.837 -0400", hash_original_method = "F1CEF297E349972E689A87BC52C1313A", hash_generated_method = "1721787CCF9C0AFED5D0117A670BB2BA")
        public String getEmailAddress() {
String var63A2807D05CF632F5A6F3F5506F67A7E_1260973692 =             mEmailAddress;
            var63A2807D05CF632F5A6F3F5506F67A7E_1260973692.addTaint(taint);
            return var63A2807D05CF632F5A6F3F5506F67A7E_1260973692;
            // ---------- Original Method ----------
            //return mEmailAddress;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.837 -0400", hash_original_method = "52206539E751E4CCE5415670F9F725D8", hash_generated_method = "942362B2554B554F8E921A87379281C0")
        public String getCompanyName() {
String var2E2CFBAE98075B2F38165FF6B5315FDB_347800702 =             mCompanyName;
            var2E2CFBAE98075B2F38165FF6B5315FDB_347800702.addTaint(taint);
            return var2E2CFBAE98075B2F38165FF6B5315FDB_347800702;
            // ---------- Original Method ----------
            //return mCompanyName;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.837 -0400", hash_original_method = "C545FDC49346DC5A5D71F5AD1D1BEF53", hash_generated_method = "DD79EA9F49A0BB7BD5748906109F2BD6")
        public String getAddressLine1() {
String var97836B935EE797BC03B2C35FD389260E_2086140635 =             mAddressLine1;
            var97836B935EE797BC03B2C35FD389260E_2086140635.addTaint(taint);
            return var97836B935EE797BC03B2C35FD389260E_2086140635;
            // ---------- Original Method ----------
            //return mAddressLine1;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.837 -0400", hash_original_method = "F55EC6B8A39F598BB4DCA9E4A078AA07", hash_generated_method = "F147722954BCC46639483E5616AA83DE")
        public String getAddressLine2() {
String var5B6AEEB071C96720B296D9D9B2769F7D_1448611730 =             mAddressLine2;
            var5B6AEEB071C96720B296D9D9B2769F7D_1448611730.addTaint(taint);
            return var5B6AEEB071C96720B296D9D9B2769F7D_1448611730;
            // ---------- Original Method ----------
            //return mAddressLine2;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.837 -0400", hash_original_method = "B85B96BC49C3B97C84AB4B17868CBD9D", hash_generated_method = "7DE88BD64EFA24DB46D8B082B6EFE30F")
        public String getCity() {
String varBF53149F9650F8F50BF0BE976469DB2F_861365237 =             mCity;
            varBF53149F9650F8F50BF0BE976469DB2F_861365237.addTaint(taint);
            return varBF53149F9650F8F50BF0BE976469DB2F_861365237;
            // ---------- Original Method ----------
            //return mCity;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.837 -0400", hash_original_method = "E347213115686AEA23D455AF8267D98C", hash_generated_method = "0BEA03041113013F58AAD4D14ED6ACFC")
        public String getState() {
String var8B975C85F13BECB9FD4D21A5F3C8A56D_1117261804 =             mState;
            var8B975C85F13BECB9FD4D21A5F3C8A56D_1117261804.addTaint(taint);
            return var8B975C85F13BECB9FD4D21A5F3C8A56D_1117261804;
            // ---------- Original Method ----------
            //return mState;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.837 -0400", hash_original_method = "07A544AD716F805F393CD2D204A5CDEF", hash_generated_method = "EFD15630E17A6575E5C863CBCBDE2E74")
        public String getZipCode() {
String var74620C2EEA996952D2AB511FC6914DEB_2119946790 =             mZipCode;
            var74620C2EEA996952D2AB511FC6914DEB_2119946790.addTaint(taint);
            return var74620C2EEA996952D2AB511FC6914DEB_2119946790;
            // ---------- Original Method ----------
            //return mZipCode;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.837 -0400", hash_original_method = "F3511327404A79B77D5BB05807C0214B", hash_generated_method = "189E6F34D69B76F83F958889B5E73C06")
        public String getCountry() {
String var23DFF2AE842E650E5366ACC3BDCD9DC0_163137806 =             mCountry;
            var23DFF2AE842E650E5366ACC3BDCD9DC0_163137806.addTaint(taint);
            return var23DFF2AE842E650E5366ACC3BDCD9DC0_163137806;
            // ---------- Original Method ----------
            //return mCountry;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.837 -0400", hash_original_method = "6EFA8840ED98073D74C9222B8B96940F", hash_generated_method = "79FD3C1B4804D71438008D33361B1F92")
        public String getPhoneNumber() {
String var6A717345AF76EF28363FFAB5D9CDC4CC_1774565310 =             mPhoneNumber;
            var6A717345AF76EF28363FFAB5D9CDC4CC_1774565310.addTaint(taint);
            return var6A717345AF76EF28363FFAB5D9CDC4CC_1774565310;
            // ---------- Original Method ----------
            //return mPhoneNumber;
        }

        
    }


    
    private class EventHandler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.837 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.838 -0400", hash_original_method = "FFA7F4A8F990D2647EE1D5FBAEBEF779", hash_generated_method = "FFA7F4A8F990D2647EE1D5FBAEBEF779")
        public EventHandler ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.838 -0400", hash_original_method = "5DB82DF3D22DC31DB9F8A52C18B58140", hash_generated_method = "CBA89E8A13A1FAC34C041C354DB1D03C")
        private synchronized void createHandler() {
            setRenderPriority();
            mHandler = new Handler() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.838 -0400", hash_original_method = "98DDA7B8BD7D5D00B914EDDF76F7BBE2", hash_generated_method = "1E6C5E9BCB1C2D25E483D4F4DBBC8CA0")
            @Override
            public void handleMessage(Message msg) {
                addTaint(msg.getTaint());
switch(msg.what){
                case SYNC:
                synchronized
(WebSettings.this)                {
    if(mBrowserFrame.mNativeFrame != 0)                    
                    {
                        nativeSync(mBrowserFrame.mNativeFrame);
                    } //End block
                    mSyncPending = false;
                } //End block
                break;
                case PRIORITY:
                {
                    setRenderPriority();
                    break;
                } //End block
                case SET_DOUBLE_TAP_TOAST_COUNT:
                {
                    SharedPreferences.Editor editor = mContext
                                    .getSharedPreferences(PREF_FILE,
                                            Context.MODE_PRIVATE).edit();
                    editor.putInt(DOUBLE_TAP_TOAST_COUNT,
                                    mDoubleTapToastCount);
                    editor.commit();
                    break;
                } //End block
}
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }
};
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.838 -0400", hash_original_method = "C47047917EAD94E1F72D1853ABF9CDB1", hash_generated_method = "C3428E61FCEC12B1434968D54EBB49AC")
        private void setRenderPriority() {
            synchronized
(WebSettings.this)            {
    if(mRenderPriority == RenderPriority.NORMAL)                
                {
                    android.os.Process.setThreadPriority(
                            android.os.Process.THREAD_PRIORITY_DEFAULT);
                } //End block
                else
    if(mRenderPriority == RenderPriority.HIGH)                
                {
                    android.os.Process.setThreadPriority(
                            android.os.Process.THREAD_PRIORITY_FOREGROUND +
                            android.os.Process.THREAD_PRIORITY_LESS_FAVORABLE);
                } //End block
                else
    if(mRenderPriority == RenderPriority.LOW)                
                {
                    android.os.Process.setThreadPriority(
                            android.os.Process.THREAD_PRIORITY_BACKGROUND);
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized (WebSettings.this) {
                //if (mRenderPriority == RenderPriority.NORMAL) {
                    //android.os.Process.setThreadPriority(
                            //android.os.Process.THREAD_PRIORITY_DEFAULT);
                //} else if (mRenderPriority == RenderPriority.HIGH) {
                    //android.os.Process.setThreadPriority(
                            //android.os.Process.THREAD_PRIORITY_FOREGROUND +
                            //android.os.Process.THREAD_PRIORITY_LESS_FAVORABLE);
                //} else if (mRenderPriority == RenderPriority.LOW) {
                    //android.os.Process.setThreadPriority(
                            //android.os.Process.THREAD_PRIORITY_BACKGROUND);
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.839 -0400", hash_original_method = "AA202573A133FD4C93192532FFFE560D", hash_generated_method = "C158A0F8ED2C63773F6BF19CB60AEDEF")
        private synchronized boolean sendMessage(Message msg) {
            addTaint(msg.getTaint());
    if(mHandler != null)            
            {
                mHandler.sendMessage(msg);
                boolean varB326B5062B2F0E69046810717534CB09_1765192371 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1206336234 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1206336234;
            } //End block
            else
            {
                boolean var68934A3E9455FA72420237EB05902327_1313310460 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_220467470 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_220467470;
            } //End block
            // ---------- Original Method ----------
            //if (mHandler != null) {
                //mHandler.sendMessage(msg);
                //return true;
            //} else {
                //return false;
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.839 -0400", hash_original_field = "464BEEB0D5AFA6627F0AAF5994698663", hash_generated_field = "BEA2A099547FF2FCBA953052760FB020")

        static final int SYNC = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.839 -0400", hash_original_field = "5222DAB64B3BBF67B11C75915AA5B6CB", hash_generated_field = "43C72D88EADF09AFDEC0F00E9349B1C9")

        static final int PRIORITY = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.839 -0400", hash_original_field = "0FAA1035BD9960470AE9A6B07D078DDB", hash_generated_field = "6436B1795825C9FB51AD30AEEB2034F0")

        static final int SET_DOUBLE_TAP_TOAST_COUNT = 2;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.839 -0400", hash_original_field = "BA8C6A10D72C3FC67EC5924A092B65DA", hash_generated_field = "8B66A9C4881AE208D014D8CA4228F2EE")

    public static final int LOAD_DEFAULT = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.839 -0400", hash_original_field = "C5E0C3C3E96430709E7F40BA03317A64", hash_generated_field = "33703CA84A1357E3977DACD6A717E588")

    public static final int LOAD_NORMAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.839 -0400", hash_original_field = "583464AC38A651925287F1372DE1AF0E", hash_generated_field = "78B96C7AA29D9AE00D647E251F96CF2B")

    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.839 -0400", hash_original_field = "61A3672F813CA0161F13673CC6EA303F", hash_generated_field = "1E865A76FD0ADA1679603C1906D1F61A")

    public static final int LOAD_NO_CACHE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.839 -0400", hash_original_field = "A89D94A39191E20BB7D53A822E542888", hash_generated_field = "89C889C49078003040853BFEFF464593")

    public static final int LOAD_CACHE_ONLY = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.839 -0400", hash_original_field = "EAB952D25B9DD65A4E2CCAF315727D4A", hash_generated_field = "D0EF9E13114399EDE7E01406D4CC77CA")

    private static final String PREVIOUS_VERSION = "3.1";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.839 -0400", hash_original_field = "0AA76F66CE94E879138279BB4CF47B90", hash_generated_field = "FF3CCB91DD4246661BA37F60AF34DD57")

    static private int mDoubleTapToastCount = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.839 -0400", hash_original_field = "27489E71A1471DD0B589BD3A07F0599F", hash_generated_field = "6E3C440D8BF3EC1CA16D917A01E72EB8")

    private static final String PREF_FILE = "WebViewSettings";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.839 -0400", hash_original_field = "B127E3FE414CC3AD2770B1BFD080F03F", hash_generated_field = "5C124E37B3B634132C4C5D9B585D5CEC")

    private static final String DOUBLE_TAP_TOAST_COUNT = "double_tap_toast_count";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.839 -0400", hash_original_field = "E937B7440CD0AA715394A944140EC316", hash_generated_field = "1F903F388B91C74E2027345321C211C3")

    private static final String DESKTOP_USERAGENT = "Mozilla/5.0 (X11; " +
        "Linux x86_64) AppleWebKit/534.24 (KHTML, like Gecko) " +
        "Chrome/11.0.696.34 Safari/534.24";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.839 -0400", hash_original_field = "34908AE8379AD1FFA04E00746E4C697F", hash_generated_field = "1FE7BDD371AF963C7DBF5F80D7ED2ED5")

    private static final String IPHONE_USERAGENT = "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_0 like Mac OS X; en-us)"
            + " AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0"
            + " Mobile/7A341 Safari/528.16";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.839 -0400", hash_original_field = "2EDA948D4DA5C99A89B49D9CAD8012C5", hash_generated_field = "3DB7C9A03487D4317932026B0B75600E")

    private static Locale sLocale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.839 -0400", hash_original_field = "45C61DCA2BF928A2594FAD3471B85EFC", hash_generated_field = "7E7566C1F279CE9C6151F8EDB80EC486")

    private static Object sLockForLocaleSettings;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.839 -0400", hash_original_field = "5650F87828B4F5AD453B45B9EEF47A57", hash_generated_field = "5546D78A409F4DFBBA356772B2D57DF1")

    private static final String ACCEPT_LANG_FOR_US_LOCALE = "en-US";
}

