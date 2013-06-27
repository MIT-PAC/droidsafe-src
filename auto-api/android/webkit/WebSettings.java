package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.273 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.273 -0400", hash_original_field = "210C1862D81E3FCC2FD87A83EA255D40", hash_generated_field = "076F5BF2A47D119E2704BFAF413B4749")

    private BrowserFrame mBrowserFrame;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.273 -0400", hash_original_field = "1C1B53671D8960CFDAF6678A518773D3", hash_generated_field = "C30651F336ACC984908CFD9A1D2C4FB4")

    private boolean mSyncPending = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.273 -0400", hash_original_field = "3487E63080D45B4AAFB4C377AC2DEA9F", hash_generated_field = "04D6DC37F0EF901EF71A528809491D49")

    private EventHandler mEventHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.273 -0400", hash_original_field = "0E67D362E0510FE684D203B7C7F6070B", hash_generated_field = "47AE0040F5B89E8E9BAF92BC707C0968")

    private LayoutAlgorithm mLayoutAlgorithm = LayoutAlgorithm.NARROW_COLUMNS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.273 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.273 -0400", hash_original_field = "C77050D5C2EE6A81F7591567A7C739D3", hash_generated_field = "093C29E093EBC4DF45917F084F44F5C6")

    private int mTextSize = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.273 -0400", hash_original_field = "FD6304CD2AD07308572BAF180A0533CF", hash_generated_field = "E4348E0A07514EBC6D1B08E5327B30EE")

    private String mStandardFontFamily = "sans-serif";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.273 -0400", hash_original_field = "B1FEC4472DB98E6AC7451DE82D2FC6FA", hash_generated_field = "3A7EFCED956E000EA686CA04D7AC83B8")

    private String mFixedFontFamily = "monospace";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.273 -0400", hash_original_field = "4D96B78DF60FEF0ABEB226DA207E661D", hash_generated_field = "399DACBDFE4EA1F4862F6FE2A91B1825")

    private String mSansSerifFontFamily = "sans-serif";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.273 -0400", hash_original_field = "F5A72D21736E3B729526542A27D57950", hash_generated_field = "C8511EC396A968342E91C81EE20A14FE")

    private String mSerifFontFamily = "serif";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.273 -0400", hash_original_field = "6F0F877F43636E621A23165415BE5E9C", hash_generated_field = "C79480C6B7D9DBB1193A0C73FB024BC6")

    private String mCursiveFontFamily = "cursive";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.273 -0400", hash_original_field = "ACAA0158781BC246A182425E83276CD3", hash_generated_field = "B7EC94AD4E54CB710D321F7D7DE2B94D")

    private String mFantasyFontFamily = "fantasy";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.273 -0400", hash_original_field = "CE5A4F5B72547D0E3BED4120AB54E949", hash_generated_field = "B14E6AD20DBCE8C395967EFC3730E312")

    private String mDefaultTextEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.273 -0400", hash_original_field = "BA6D6E1CFB30AD42884BC977FE2F8001", hash_generated_field = "DE0DD9FFAB9049B26488186A370E05A4")

    private String mUserAgent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.273 -0400", hash_original_field = "E636D0AC0659FBA6915C4CA8085F37FB", hash_generated_field = "98FAE63E9B12B7A881FB6D145E4549CE")

    private boolean mUseDefaultUserAgent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.273 -0400", hash_original_field = "B1F493B722D78CD886E29BDFFE0802B3", hash_generated_field = "439229978AE9CF49770BDEBF3E2CE78C")

    private String mAcceptLanguage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.273 -0400", hash_original_field = "0F2878AB7630408FA87100B28FC68C94", hash_generated_field = "D0EDBC802964D83D99F85BC314C8A69C")

    private int mMinimumFontSize = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.273 -0400", hash_original_field = "4B34DDC1E8E68B3BED9CC6080688FF22", hash_generated_field = "528ED989B04689091770CF5109FE433F")

    private int mMinimumLogicalFontSize = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.273 -0400", hash_original_field = "836C251AEBE2201CC391FB31DC7701C0", hash_generated_field = "57AE803195BA7056811C876F5BD9502B")

    private int mDefaultFontSize = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "3EF20D2976FA241D9E0FF7E4D44ED19A", hash_generated_field = "5AFDCF69E75A0190CADCEA2557825121")

    private int mDefaultFixedFontSize = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "C84A7DE980B0C26CE75BAC761048D403", hash_generated_field = "F690B69F0C52F955F3D88DD7983F79F2")

    private int mPageCacheCapacity = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "7B02990524344D9852C3E43FB13DD8E4", hash_generated_field = "DE3A280A6D9972DAFD651E9018D4768E")

    private boolean mLoadsImagesAutomatically = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "8F5CF5F2C56460BFDB5BFC7DC9CEF759", hash_generated_field = "503153EC725C55D5C1DC162A32A1D3DC")

    private boolean mBlockNetworkImage = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "FF7A02E2205AE67F625F39019D239753", hash_generated_field = "1ACDBB27D2A84BAEF0BB072C0594B56E")

    private boolean mBlockNetworkLoads;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "C3822A70B9259EA30623C122721ADA79", hash_generated_field = "36C1818B65CEBEA6CFEE516674358D43")

    private boolean mJavaScriptEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "4CA2A324C4541CD9D0F4EA48A9F96383", hash_generated_field = "0A90F6A7499839588E833D7BE890E1AE")

    private boolean mHardwareAccelSkia = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "6BBB46DBDE2209BDCF5F06D21CED3E66", hash_generated_field = "944C133C097C1E4190CF0C3582E0E938")

    private boolean mShowVisualIndicator = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "9C4C3DA8B3DFE7677F937A106A0FA190", hash_generated_field = "7D86B7624AEF61E6266D36CF41EB39D7")

    private PluginState mPluginState = PluginState.OFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "782F3CEA749C92F0B1AEF5C560F6F376", hash_generated_field = "459DE55C50CE26452B149CCD8782CC03")

    private boolean mJavaScriptCanOpenWindowsAutomatically = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "E42DF2AC48A80AC89D5EA6C725AA31FC", hash_generated_field = "20A7E2DF1A565B51829896E9F69CF90A")

    private boolean mUseDoubleTree = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "EFD7BD41CD6C84BE258717DD0246B0D9", hash_generated_field = "5EDADBA984DCE351C397430D71B8E193")

    private boolean mUseWideViewport = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "89ADAB8AAADB11C767CDDD4A47C31E4F", hash_generated_field = "63D7A412D6A66B99394E571B78F61F6C")

    private boolean mSupportMultipleWindows = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "776CDA302169DB8F9A950481F30563B1", hash_generated_field = "77A7B89BB1F561628F9C88F763E053D4")

    private boolean mShrinksStandaloneImagesToFit = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "1C23E4BD5710D9A07575C92514B3B2A7", hash_generated_field = "71BCB1B04985B5A05BFF9925B051AEA3")

    private long mMaximumDecodedImageSize = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "23A44297716498305D043D064C5F1A5D", hash_generated_field = "381C5CB2F1A0DF35777B63F9BF8EDACD")

    private boolean mPrivateBrowsingEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "40CEACE7770B1AA574AECB611E78A601", hash_generated_field = "F43E538FC31443F2EB0B8734DEF87A58")

    private boolean mSyntheticLinksEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "FF76A93821E4C14CA2D0F905605B5253", hash_generated_field = "A8618659B8DEE94F1CEAA079EECA9790")

    private boolean mAppCacheEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "CEE1403C760B29E8CFBD90E16820A9F9", hash_generated_field = "ABA108E81C8DBD674018DAA8E50B66B3")

    private boolean mDatabaseEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "9B4BB2DD19F19AEE3A60C91A700A53A8", hash_generated_field = "5F06543ABC51E15528B933AC0AB2C6F7")

    private boolean mDomStorageEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "D120EB54296E0E73D2502E565107FA14", hash_generated_field = "74A2A29BD57D607C6576055F7F403D0D")

    private boolean mWorkersEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "F4A5919DFCEA1FA69B258487DA02ED60", hash_generated_field = "3C3198EADED631FE881AB97F9EAFA5FA")

    private boolean mGeolocationEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "24DC0A10E4E5F0680B65B6480902CF89", hash_generated_field = "6F3EA93685FD5D8B0D8F67E8E5C21B28")

    private boolean mXSSAuditorEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "BAFC052B19321AD6D2EEE9FD24C189C7", hash_generated_field = "A6B2EA55227276EA13A495BB96D1DF12")

    private long mAppCacheMaxSize = Long.MAX_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "7B285FB0B6636DBE1C8FB24FC0A7082B", hash_generated_field = "D79F53468E055B10315200B95916C500")

    private String mAppCachePath = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "0F8B2DAEF39F0C191E39D188C577F5B0", hash_generated_field = "9EB5165541C5151194CB8556E03CD161")

    private String mDatabasePath = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "96B4B13C2502429263325D7990904AE8", hash_generated_field = "F2C27E27D9065859FE4225C1B56F842D")

    private boolean mDatabasePathHasBeenSet = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "207F5E7A506E1A9B35F9E6570D102D4C", hash_generated_field = "5ABA61E953719F99114204D8D30BD28F")

    private String mGeolocationDatabasePath = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "9AF10D96415892E26A1DFAA3A56A2347", hash_generated_field = "1F48A314038B92F0A250F855FF35D5AB")

    private ZoomDensity mDefaultZoom = ZoomDensity.MEDIUM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "A39FFAE4A825508391E0316FF905EEAF", hash_generated_field = "A1F79CA724067D106338BC229C16B5FC")

    private RenderPriority mRenderPriority = RenderPriority.NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "4E7CECE5CBD06928F1F2E5152BDCB1C0", hash_generated_field = "5C01ACB0A24F788620EF740B6F83D8FF")

    private int mOverrideCacheMode = LOAD_DEFAULT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "2F57086F7AA47DF4C289A1A22809C34B", hash_generated_field = "1E5E05632184B0562D99F65B2623C2C6")

    private int mDoubleTapZoom = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "7A20407DCDB4339E9CD5D75A376E286D", hash_generated_field = "82ACFD258B431C7D2B00D5130B9F8AC1")

    private boolean mSaveFormData = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.274 -0400", hash_original_field = "84334DBED733230649777024AC1171F3", hash_generated_field = "EE91F91973A59EB55189A26DDA38F9B3")

    private boolean mAutoFillEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.275 -0400", hash_original_field = "37293F79039D53AD34CCD74A160D684B", hash_generated_field = "0C944D5751C5A507BE22C1937F62D8F5")

    private boolean mSavePassword = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.275 -0400", hash_original_field = "14C3D2179570F06B504FCED5EF5C9DF1", hash_generated_field = "B0E370B7C84DDE746CBD3769FED2B05B")

    private boolean mLightTouchEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.275 -0400", hash_original_field = "FC17F5EAB69150AD7077A5F07A1029E6", hash_generated_field = "479CD0E5DFA0F4A8AD2336A3C8796C11")

    private boolean mNeedInitialFocus = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.282 -0400", hash_original_field = "CD2AB2548C6EBA9F969FE4F44D9EE358", hash_generated_field = "53BEF3F54FA7E72187F7DE406E409A1B")

    private boolean mNavDump = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.282 -0400", hash_original_field = "4FFFB08326947A7F34D6A94BCF9C323D", hash_generated_field = "9816BC835AB5A0ACD4FDE0137AF8616C")

    private boolean mSupportZoom = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.282 -0400", hash_original_field = "9CF7D3194AF8F27F30388FB99A38B9FB", hash_generated_field = "C64C3FAECED9CD368C40F69AB6974F26")

    private boolean mBuiltInZoomControls = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.282 -0400", hash_original_field = "9EE62A52A99CC1E8EEF461CF8EE79F29", hash_generated_field = "620B20DEA57B92E5F177E02A77C42AD0")

    private boolean mDisplayZoomControls = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.282 -0400", hash_original_field = "8C0C96268A4FE5A7FEA363603086B178", hash_generated_field = "296BB32E1651209ADFADBF23000A8C19")

    private boolean mAllowFileAccess = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.282 -0400", hash_original_field = "E8BD268B102F8A23DE857C06F29F7274", hash_generated_field = "CCF630C83B80C2F4393E963314F2D0FE")

    private boolean mAllowContentAccess = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.282 -0400", hash_original_field = "07AA53DFAC65DD5CA73EE06FC482AC8E", hash_generated_field = "30FAFE3A56A71716731F01CEE7EBDBC8")

    private boolean mLoadWithOverviewMode = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.282 -0400", hash_original_field = "DAFB88B50FE0B9BEB8636973E61088F4", hash_generated_field = "0383F8FCA39790900B8C6F17CB8C8ACE")

    private boolean mEnableSmoothTransition = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.283 -0400", hash_original_field = "78A6C8AB01BD6AD3C287AFA07ABEFE43", hash_generated_field = "C83DD3856F6A01CD394571B6570E38C9")

    private boolean mForceUserScalable = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.283 -0400", hash_original_field = "D0E8E1D004D578571CAB3FC73F9DD791", hash_generated_field = "91C6393A6B49848292FD9CB7AF58B0CD")

    private AutoFillProfile mAutoFillProfile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.283 -0400", hash_original_field = "4727D81B5001274DB3B60E1C06A5A4B0", hash_generated_field = "73BE0F1D89639A62A6549ED3C0472D72")

    private boolean mUseWebViewBackgroundForOverscroll = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.287 -0400", hash_original_method = "C5F77054875E8CE16379FFA130433105", hash_generated_method = "B88159AFC81B398C468C0CE415046862")
      WebSettings(Context context, WebView webview) {
        mEventHandler = new EventHandler();
        mContext = context;
        mWebView = webview;
        mDefaultTextEncoding = context.getString(com.android.internal.
                                                 R.string.default_text_encoding);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.289 -0400", hash_original_method = "4DE075F72507E4E460D500D800684FF5", hash_generated_method = "64045D59A15D909427EC4AFC15527615")
    private String getCurrentAcceptLanguage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1693618657 = null; //Variable for return #1
        Locale locale;
        {
            locale = sLocale;
        } //End block
        StringBuilder buffer;
        buffer = new StringBuilder();
        addLocaleToHttpAcceptLanguage(buffer, locale);
        {
            boolean var431751D6A3587215342AEEB02B5F09EE_1891084598 = (!Locale.US.equals(locale));
            {
                {
                    boolean var9C02A302D5D3520DE4F4E0F080BCC1E1_1895014440 = (buffer.length() > 0);
                    {
                        buffer.append(", ");
                    } //End block
                } //End collapsed parenthetic
                buffer.append(ACCEPT_LANG_FOR_US_LOCALE);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1693618657 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1693618657.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1693618657;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.295 -0400", hash_original_method = "7A96EBBEB91D958845CC53A11C0AF344", hash_generated_method = "21F2DDA1A7571189A34005579644076B")
    private synchronized String getCurrentUserAgent() {
        String varB4EAC82CA7396A68D541C85D26508E83_1055437991 = null; //Variable for return #1
        Locale locale;
        {
            locale = sLocale;
        } //End block
        StringBuffer buffer;
        buffer = new StringBuffer();
        String version;
        version = Build.VERSION.RELEASE;
        {
            boolean var4C6295605C370EDE83CC155E9E515FA4_1622440023 = (version.length() > 0);
            {
                {
                    boolean varAA1BB3E0B4229E1816D8A6A205E26C86_2072527011 = (Character.isDigit(version.charAt(0)));
                    {
                        buffer.append(version);
                    } //End block
                    {
                        buffer.append(PREVIOUS_VERSION);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                buffer.append("1.0");
            } //End block
        } //End collapsed parenthetic
        buffer.append("; ");
        String language;
        language = locale.getLanguage();
        {
            buffer.append(convertObsoleteLanguageCodeToNew(language));
            String country;
            country = locale.getCountry();
            {
                buffer.append("-");
                buffer.append(country.toLowerCase());
            } //End block
        } //End block
        {
            buffer.append("en");
        } //End block
        buffer.append(";");
        {
            boolean var74E1736D68B691D0E86DFB92E7377FE0_617271739 = ("REL".equals(Build.VERSION.CODENAME));
            {
                String model;
                model = Build.MODEL;
                {
                    boolean varA8E096DD510AFCFD2AF4DF6E257AC809_692299301 = (model.length() > 0);
                    {
                        buffer.append(" ");
                        buffer.append(model);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String id;
        id = Build.ID;
        {
            boolean var9B6DAC42F8BDFB2B50C52216DE688E8B_572407513 = (id.length() > 0);
            {
                buffer.append(" Build/");
                buffer.append(id);
            } //End block
        } //End collapsed parenthetic
        String mobile;
        mobile = mContext.getResources().getText(
            com.android.internal.R.string.web_user_agent_target_content).toString();
        String base;
        base = mContext.getResources().getText(
                com.android.internal.R.string.web_user_agent).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1055437991 = String.format(base, buffer, mobile);
        varB4EAC82CA7396A68D541C85D26508E83_1055437991.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1055437991;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.295 -0400", hash_original_method = "0785CD668E13EDF5998305462A035DB6", hash_generated_method = "3D0009C82F720043A50C0F5906394E3C")
    @Deprecated
    public void setNavDump(boolean enabled) {
        mNavDump = enabled;
        // ---------- Original Method ----------
        //mNavDump = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.296 -0400", hash_original_method = "8B24B3626FE4D070605B6C1E8E9774B6", hash_generated_method = "2CE9D80860A79B1738DC78C240451A94")
    @Deprecated
    public boolean getNavDump() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_492771169 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_492771169;
        // ---------- Original Method ----------
        //return mNavDump;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.297 -0400", hash_original_method = "BB54171E3BDD4A64CB98C2709AC39B9C", hash_generated_method = "D0FAB605AF251F9F195C8E1AD361054B")
     boolean supportTouchOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1101130839 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1101130839;
        // ---------- Original Method ----------
        //return mLightTouchEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.305 -0400", hash_original_method = "6B7C7B097AE4AF077C4ED1E2A5D10429", hash_generated_method = "EE55224A930804935CDBC9F3AB3F3778")
    public void setSupportZoom(boolean support) {
        mSupportZoom = support;
        mWebView.updateMultiTouchSupport(mContext);
        // ---------- Original Method ----------
        //mSupportZoom = support;
        //mWebView.updateMultiTouchSupport(mContext);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.306 -0400", hash_original_method = "A16213EC170C52C83CDC8BBC64DBFF18", hash_generated_method = "E488CA0AE19309CE8CC1672EA035C387")
    public boolean supportZoom() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_241886178 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_241886178;
        // ---------- Original Method ----------
        //return mSupportZoom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.306 -0400", hash_original_method = "16CDF55EE98C899167571FFC15609D2B", hash_generated_method = "29D331EEE75AE04FE358F9041FDC9D4D")
    public void setBuiltInZoomControls(boolean enabled) {
        mBuiltInZoomControls = enabled;
        mWebView.updateMultiTouchSupport(mContext);
        // ---------- Original Method ----------
        //mBuiltInZoomControls = enabled;
        //mWebView.updateMultiTouchSupport(mContext);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.307 -0400", hash_original_method = "9006048913C3ABECFF150ED9A10494B5", hash_generated_method = "AD3ADD0933879D6F65BB7A2108F4B4E5")
    public boolean getBuiltInZoomControls() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1406673441 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1406673441;
        // ---------- Original Method ----------
        //return mBuiltInZoomControls;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.307 -0400", hash_original_method = "8F17FB2A2C1E34D57B8A250CBF0EF944", hash_generated_method = "150ABF0EFCA5E0EF820D4ABA562462C7")
    public void setDisplayZoomControls(boolean enabled) {
        mDisplayZoomControls = enabled;
        mWebView.updateMultiTouchSupport(mContext);
        // ---------- Original Method ----------
        //mDisplayZoomControls = enabled;
        //mWebView.updateMultiTouchSupport(mContext);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.307 -0400", hash_original_method = "AE5780336410432FB6F983F3F828E46C", hash_generated_method = "1406715DBE98C04F7448B52BD0BC2F45")
    public boolean getDisplayZoomControls() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_743525408 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_743525408;
        // ---------- Original Method ----------
        //return mDisplayZoomControls;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.317 -0400", hash_original_method = "C265511540E520E57BDB53C1B101C5AC", hash_generated_method = "3FA94A3866D3A3E694A204489118E1F3")
    public void setAllowFileAccess(boolean allow) {
        mAllowFileAccess = allow;
        // ---------- Original Method ----------
        //mAllowFileAccess = allow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.317 -0400", hash_original_method = "ED281F9FC327C1DCA93656D122E60B6E", hash_generated_method = "2BDA1D2C87B2155A09504736E28CA1B6")
    public boolean getAllowFileAccess() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1769100797 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1769100797;
        // ---------- Original Method ----------
        //return mAllowFileAccess;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.318 -0400", hash_original_method = "1A30AACA222993CDBB39CAF3A548FAE3", hash_generated_method = "55017C3A0896C8083D53F9176707C196")
    public void setAllowContentAccess(boolean allow) {
        mAllowContentAccess = allow;
        // ---------- Original Method ----------
        //mAllowContentAccess = allow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.318 -0400", hash_original_method = "E20572D9D9FCBBCAC622C44A2D9C5369", hash_generated_method = "5D5968ADC43EB85C839F487DD72D2C0F")
    public boolean getAllowContentAccess() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1018883293 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1018883293;
        // ---------- Original Method ----------
        //return mAllowContentAccess;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.323 -0400", hash_original_method = "E0C53B0ABBE8903B8C2E5235B7766B9A", hash_generated_method = "B6128BCF06C01508511BF873AD287A93")
    public void setLoadWithOverviewMode(boolean overview) {
        mLoadWithOverviewMode = overview;
        // ---------- Original Method ----------
        //mLoadWithOverviewMode = overview;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.324 -0400", hash_original_method = "0D409EAD2B46C91908C9804617827D1C", hash_generated_method = "31EB4D28CA0A261F3536B284AB612AFD")
    public boolean getLoadWithOverviewMode() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_489627956 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_489627956;
        // ---------- Original Method ----------
        //return mLoadWithOverviewMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.324 -0400", hash_original_method = "B5CB73D3FC09526DD6AE502765086798", hash_generated_method = "64C152888041D085E972D81D1C95DC93")
    public void setEnableSmoothTransition(boolean enable) {
        mEnableSmoothTransition = enable;
        // ---------- Original Method ----------
        //mEnableSmoothTransition = enable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.329 -0400", hash_original_method = "FB45006D48B3F1A32CF7E83242DDAE7D", hash_generated_method = "9FB89289778668101EC193B31D3C29D5")
    public boolean enableSmoothTransition() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1035475145 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1035475145;
        // ---------- Original Method ----------
        //return mEnableSmoothTransition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.330 -0400", hash_original_method = "6C4A8C912B988582A0E8E6FECC7FBF9C", hash_generated_method = "85F98D1E9E9195557007E0781EDA3C95")
    @Deprecated
    public void setUseWebViewBackgroundForOverscrollBackground(boolean view) {
        mUseWebViewBackgroundForOverscroll = view;
        // ---------- Original Method ----------
        //mUseWebViewBackgroundForOverscroll = view;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.331 -0400", hash_original_method = "FE1757AAD5E1DD702744237E901A55C8", hash_generated_method = "AA6650A68647CDAED9298A07DB1C0562")
    @Deprecated
    public boolean getUseWebViewBackgroundForOverscrollBackground() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1812523904 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1812523904;
        // ---------- Original Method ----------
        //return mUseWebViewBackgroundForOverscroll;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.332 -0400", hash_original_method = "BAE3B161CD7589698136E106A2876792", hash_generated_method = "1B000F89994FD51C8FCC87F59A7E5B8A")
    public void setSaveFormData(boolean save) {
        mSaveFormData = save;
        // ---------- Original Method ----------
        //mSaveFormData = save;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.342 -0400", hash_original_method = "4DFFD3713A8D682938D03E8713A587EF", hash_generated_method = "3CBFA7FFA337F327FFD326B50E8E1703")
    public boolean getSaveFormData() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1848252360 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1848252360;
        // ---------- Original Method ----------
        //return mSaveFormData && !mPrivateBrowsingEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.343 -0400", hash_original_method = "B2DE3A754D34523602EAE606838B5563", hash_generated_method = "1A0C14453C50A93DCB55814578EA8BF3")
    public void setSavePassword(boolean save) {
        mSavePassword = save;
        // ---------- Original Method ----------
        //mSavePassword = save;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.343 -0400", hash_original_method = "7EDF9AC2E1EDCCF642364DB0CD31765F", hash_generated_method = "5B42BE514704442CC7243845381E3961")
    public boolean getSavePassword() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1913185455 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1913185455;
        // ---------- Original Method ----------
        //return mSavePassword;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.347 -0400", hash_original_method = "C5C41A533FE351F2D45D268D5D267050", hash_generated_method = "3427F30EBB03765631409C702287AE43")
    public synchronized void setTextZoom(int textZoom) {
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.347 -0400", hash_original_method = "570564B346A8D968406F236CA99E37F6", hash_generated_method = "37CF063CA02447BE11AE7D04E288F71A")
    public synchronized int getTextZoom() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_872926434 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_872926434;
        // ---------- Original Method ----------
        //return mTextSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.348 -0400", hash_original_method = "D3E0150ED5C00CC3B22240870480363B", hash_generated_method = "85D669DFBA6ABEBF6807745D40DAE30E")
    public synchronized void setTextSize(TextSize t) {
        setTextZoom(t.value);
        addTaint(t.getTaint());
        // ---------- Original Method ----------
        //setTextZoom(t.value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.379 -0400", hash_original_method = "900BE61F6B80F2B5D843AC6DC18F9D15", hash_generated_method = "CA4A93A543D4A68B3A31C4C148613A77")
    public synchronized TextSize getTextSize() {
        TextSize varB4EAC82CA7396A68D541C85D26508E83_783337057 = null; //Variable for return #1
        TextSize varB4EAC82CA7396A68D541C85D26508E83_650235558 = null; //Variable for return #2
        TextSize closestSize;
        closestSize = null;
        int smallestDelta;
        smallestDelta = Integer.MAX_VALUE;
        {
            TextSize size = TextSize.values()[0];
            {
                int delta;
                delta = Math.abs(mTextSize - size.value);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_783337057 = size;
                } //End block
                {
                    smallestDelta = delta;
                    closestSize = size;
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_650235558 = closestSize != null ? closestSize : TextSize.NORMAL;
        TextSize varA7E53CE21691AB073D9660D615818899_2102967628; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2102967628 = varB4EAC82CA7396A68D541C85D26508E83_783337057;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2102967628 = varB4EAC82CA7396A68D541C85D26508E83_650235558;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2102967628.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2102967628;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.390 -0400", hash_original_method = "E23B2F666BB6D09A8C611DD5B37D2698", hash_generated_method = "1D3D9385C72FB315C741E80B8D0772C5")
    public void setDoubleTapZoom(int doubleTapZoom) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.390 -0400", hash_original_method = "137930918FD91EA20A5F57296DD24AFB", hash_generated_method = "003ECB927A87ED4873F2D40C6374C998")
    public int getDoubleTapZoom() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1652319630 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1652319630;
        // ---------- Original Method ----------
        //return mDoubleTapZoom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.395 -0400", hash_original_method = "E4C2219CCE12A9777A4354402A44D34B", hash_generated_method = "F30568F0DCD3824632F004E712D1C78A")
    public void setDefaultZoom(ZoomDensity zoom) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.395 -0400", hash_original_method = "72EF0E181D832EBBD7F53BEF96096C0C", hash_generated_method = "82E5E5735F49B583738715CD04213559")
    public ZoomDensity getDefaultZoom() {
        ZoomDensity varB4EAC82CA7396A68D541C85D26508E83_1369072290 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1369072290 = mDefaultZoom;
        varB4EAC82CA7396A68D541C85D26508E83_1369072290.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1369072290;
        // ---------- Original Method ----------
        //return mDefaultZoom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.400 -0400", hash_original_method = "DFD74C15B6ACEBABFCBAF5FDE1C7D76D", hash_generated_method = "9AE3C2EAB296845CAC779F245F6C12E3")
    public void setLightTouchEnabled(boolean enabled) {
        mLightTouchEnabled = enabled;
        // ---------- Original Method ----------
        //mLightTouchEnabled = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.400 -0400", hash_original_method = "02D840FF3CC8AE7A6DEC323EC455B33B", hash_generated_method = "8E13EE4B728FCE10D073113223BDAD25")
    public boolean getLightTouchEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1177515939 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1177515939;
        // ---------- Original Method ----------
        //return mLightTouchEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.400 -0400", hash_original_method = "EF2600D8826AB6D5A4057F05D8E61936", hash_generated_method = "59E7F0F0712851047D9E12AC672F90AA")
    @Deprecated
    public synchronized void setUseDoubleTree(boolean use) {
        addTaint(use);
        // ---------- Original Method ----------
        //return;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.401 -0400", hash_original_method = "89BCC0409F823F147F01A4F485C1EC58", hash_generated_method = "B024F01BFCAA9260BD073E83FAA901C5")
    @Deprecated
    public synchronized boolean getUseDoubleTree() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_222034458 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_222034458;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.401 -0400", hash_original_method = "85DE35A00A5168FE5C8491B5E07C3BBE", hash_generated_method = "910C2406748C11B8AB1456F237A7C809")
    @Deprecated
    public synchronized void setUserAgent(int ua) {
        String uaString;
        uaString = null;
        {
            {
                boolean var4A844877AA20090242BD936E4114AAF0_127993131 = (DESKTOP_USERAGENT.equals(mUserAgent));
                {
                    uaString = DESKTOP_USERAGENT;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB0C37EBE4069C6C6D0B7D26FC6DDD7F8_1609171061 = (IPHONE_USERAGENT.equals(mUserAgent));
                {
                    uaString = IPHONE_USERAGENT;
                } //End block
            } //End collapsed parenthetic
        } //End block
        setUserAgentString(uaString);
        addTaint(ua);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.401 -0400", hash_original_method = "622085E3817D576D67ED6E0D62241C79", hash_generated_method = "15C89CCDE284722084396D492EF4F160")
    @Deprecated
    public synchronized int getUserAgent() {
        {
            boolean var0EFD68202BB0194EC352607AD3F67935_581498658 = (DESKTOP_USERAGENT.equals(mUserAgent));
            {
                boolean varB0C37EBE4069C6C6D0B7D26FC6DDD7F8_1877198557 = (IPHONE_USERAGENT.equals(mUserAgent));
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_728028679 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_728028679;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.414 -0400", hash_original_method = "6232B93EE163514DA7A8F2A20C0E8296", hash_generated_method = "FACD5FA7441C2B20F2C41EEDC132CAB1")
    public synchronized void setUseWideViewPort(boolean use) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.414 -0400", hash_original_method = "B42FD143593B620F53C7027879473593", hash_generated_method = "1ECAB2EDB67EF0A0DEB3E3E2C3C85D82")
    public synchronized boolean getUseWideViewPort() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_101781193 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_101781193;
        // ---------- Original Method ----------
        //return mUseWideViewport;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.414 -0400", hash_original_method = "961D9442BDC4ECD4A72AED0ECCABFF49", hash_generated_method = "318515AEB4B5DA86403848BD037ECBE9")
    public synchronized void setSupportMultipleWindows(boolean support) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.415 -0400", hash_original_method = "DC8997F98FC697774C788E0E9C368A15", hash_generated_method = "0D41FE18435E9C46D2F75D3148704617")
    public synchronized boolean supportMultipleWindows() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1052311672 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1052311672;
        // ---------- Original Method ----------
        //return mSupportMultipleWindows;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.415 -0400", hash_original_method = "CF796A65BC60375130249D0138E0D269", hash_generated_method = "647EB6AE6BBA1DADCEF85B567D1F4554")
    public synchronized void setLayoutAlgorithm(LayoutAlgorithm l) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.416 -0400", hash_original_method = "D199B05491A7568F9921CD10D25BC54E", hash_generated_method = "13E26F0F52A9FACC153D38D1486DBE9C")
    public synchronized LayoutAlgorithm getLayoutAlgorithm() {
        LayoutAlgorithm varB4EAC82CA7396A68D541C85D26508E83_998303352 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_998303352 = mLayoutAlgorithm;
        varB4EAC82CA7396A68D541C85D26508E83_998303352.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_998303352;
        // ---------- Original Method ----------
        //return mLayoutAlgorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.416 -0400", hash_original_method = "80141FBB7709CEF61745CB878BA8248B", hash_generated_method = "26F91708401DD803A36A83C502AA6661")
    public synchronized void setStandardFontFamily(String font) {
        {
            boolean varB128AAF7335996E86683BB90059325B1_1822301996 = (font != null && !font.equals(mStandardFontFamily));
            {
                mStandardFontFamily = font;
                postSync();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (font != null && !font.equals(mStandardFontFamily)) {
            //mStandardFontFamily = font;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.426 -0400", hash_original_method = "D17418EAB461A3931F0EFDEA802C4808", hash_generated_method = "C1FA0A09E3FBD6B004B5B98B12E55625")
    public synchronized String getStandardFontFamily() {
        String varB4EAC82CA7396A68D541C85D26508E83_1386504546 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1386504546 = mStandardFontFamily;
        varB4EAC82CA7396A68D541C85D26508E83_1386504546.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1386504546;
        // ---------- Original Method ----------
        //return mStandardFontFamily;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.427 -0400", hash_original_method = "85832E987C30A09FD65E322D8A53532D", hash_generated_method = "D13B6A8A9ED36834AC39ECBF336D6794")
    public synchronized void setFixedFontFamily(String font) {
        {
            boolean var2192ACF0230C6A0784BBAB0F632C7F94_1935497266 = (font != null && !font.equals(mFixedFontFamily));
            {
                mFixedFontFamily = font;
                postSync();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (font != null && !font.equals(mFixedFontFamily)) {
            //mFixedFontFamily = font;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.427 -0400", hash_original_method = "91A5D658AFF46E5675EE0251B0448A37", hash_generated_method = "4F3999C0FCD05FCE8FF7623B46C95168")
    public synchronized String getFixedFontFamily() {
        String varB4EAC82CA7396A68D541C85D26508E83_524854944 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_524854944 = mFixedFontFamily;
        varB4EAC82CA7396A68D541C85D26508E83_524854944.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_524854944;
        // ---------- Original Method ----------
        //return mFixedFontFamily;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.428 -0400", hash_original_method = "5317C7E81FFF6267D702DE0B9A35C25F", hash_generated_method = "BE917070E3FCE3181BDB620DF5382217")
    public synchronized void setSansSerifFontFamily(String font) {
        {
            boolean var514778F08C8455342768B3DE4B757E0E_2076891063 = (font != null && !font.equals(mSansSerifFontFamily));
            {
                mSansSerifFontFamily = font;
                postSync();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (font != null && !font.equals(mSansSerifFontFamily)) {
            //mSansSerifFontFamily = font;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.428 -0400", hash_original_method = "E8B035ABC4C315E7FC00763BCE4B3101", hash_generated_method = "23580005CFFD0607AE72E3691246C160")
    public synchronized String getSansSerifFontFamily() {
        String varB4EAC82CA7396A68D541C85D26508E83_1932410635 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1932410635 = mSansSerifFontFamily;
        varB4EAC82CA7396A68D541C85D26508E83_1932410635.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1932410635;
        // ---------- Original Method ----------
        //return mSansSerifFontFamily;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.440 -0400", hash_original_method = "B0B03F3832ADF5F3F163E426E788DEB1", hash_generated_method = "16A7EA0D5921B83FA8FDE597B9ED9804")
    public synchronized void setSerifFontFamily(String font) {
        {
            boolean var0F2299905D79404CB9B0DCD6CDA01E81_1097027606 = (font != null && !font.equals(mSerifFontFamily));
            {
                mSerifFontFamily = font;
                postSync();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (font != null && !font.equals(mSerifFontFamily)) {
            //mSerifFontFamily = font;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.441 -0400", hash_original_method = "AEE55B3207D2A837254BD0F18E5F431B", hash_generated_method = "D4370141968D65ADC0CE47D16DD22A01")
    public synchronized String getSerifFontFamily() {
        String varB4EAC82CA7396A68D541C85D26508E83_494312785 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_494312785 = mSerifFontFamily;
        varB4EAC82CA7396A68D541C85D26508E83_494312785.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_494312785;
        // ---------- Original Method ----------
        //return mSerifFontFamily;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.447 -0400", hash_original_method = "8334AD5BA97572A472DE2E88CF457E83", hash_generated_method = "16832DD9755DB299108B52B9C7158E46")
    public synchronized void setCursiveFontFamily(String font) {
        {
            boolean var574F82A2068BB3BEAB991B434D7D7582_239032094 = (font != null && !font.equals(mCursiveFontFamily));
            {
                mCursiveFontFamily = font;
                postSync();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (font != null && !font.equals(mCursiveFontFamily)) {
            //mCursiveFontFamily = font;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.447 -0400", hash_original_method = "A9100EF4E222FCE0DCE66A7BF6E9785C", hash_generated_method = "6EC68BE538AA08EA69BC67151691BCFF")
    public synchronized String getCursiveFontFamily() {
        String varB4EAC82CA7396A68D541C85D26508E83_287699444 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_287699444 = mCursiveFontFamily;
        varB4EAC82CA7396A68D541C85D26508E83_287699444.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_287699444;
        // ---------- Original Method ----------
        //return mCursiveFontFamily;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.448 -0400", hash_original_method = "3BEE212C0CAB12BA1830E10645682B81", hash_generated_method = "2AF44B74E45840DF45280E9F62D1C37D")
    public synchronized void setFantasyFontFamily(String font) {
        {
            boolean varBE452F483B0D977FF74BFC8D461A34DE_1777931548 = (font != null && !font.equals(mFantasyFontFamily));
            {
                mFantasyFontFamily = font;
                postSync();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (font != null && !font.equals(mFantasyFontFamily)) {
            //mFantasyFontFamily = font;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.448 -0400", hash_original_method = "3AB44712F248734E7DE5412E073462E0", hash_generated_method = "98A5B1E7316A0EA120069EC3C1CF6489")
    public synchronized String getFantasyFontFamily() {
        String varB4EAC82CA7396A68D541C85D26508E83_2146793575 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2146793575 = mFantasyFontFamily;
        varB4EAC82CA7396A68D541C85D26508E83_2146793575.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2146793575;
        // ---------- Original Method ----------
        //return mFantasyFontFamily;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.448 -0400", hash_original_method = "5B2F36FEBD6497C3F70A8544117DF67F", hash_generated_method = "46D94841A4885311ADC4FFDBE3FE27FB")
    public synchronized void setMinimumFontSize(int size) {
        size = pin(size);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.458 -0400", hash_original_method = "9F0281C9F2E3CE3701E30B7BA1EEFCDC", hash_generated_method = "B0F74D606F9F9D9E6A98BF80581B4847")
    public synchronized int getMinimumFontSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1820306880 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1820306880;
        // ---------- Original Method ----------
        //return mMinimumFontSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.459 -0400", hash_original_method = "979D72ED8DED37C47A363976CA577A0C", hash_generated_method = "D4A7916504E94F604B0FE00C7A6CC22B")
    public synchronized void setMinimumLogicalFontSize(int size) {
        size = pin(size);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.459 -0400", hash_original_method = "4108641CDFB7F27DEA848BE579464C88", hash_generated_method = "4295E448082EC3AE9DB01CF1781DE953")
    public synchronized int getMinimumLogicalFontSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1107457523 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1107457523;
        // ---------- Original Method ----------
        //return mMinimumLogicalFontSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.460 -0400", hash_original_method = "F015D29DAD166EF30FCB62EA8F22BD34", hash_generated_method = "8418B8B61E1159AE0B1ECABC460A8908")
    public synchronized void setDefaultFontSize(int size) {
        size = pin(size);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.460 -0400", hash_original_method = "DC87CC6F42B19166FD6192BC9DCDB609", hash_generated_method = "3C4022367E9D4C4009337621C243E088")
    public synchronized int getDefaultFontSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627189705 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627189705;
        // ---------- Original Method ----------
        //return mDefaultFontSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.460 -0400", hash_original_method = "F38EE7285BA7C36F298A402033D20C39", hash_generated_method = "DAFE7473BB6F59D9CEDBBCE8F7E3DC67")
    public synchronized void setDefaultFixedFontSize(int size) {
        size = pin(size);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.461 -0400", hash_original_method = "32FF94F6134070C3A3BF7D6E4734C806", hash_generated_method = "BC97E7E746F33CE152C28FAB5F6C8C64")
    public synchronized int getDefaultFixedFontSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_445231159 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_445231159;
        // ---------- Original Method ----------
        //return mDefaultFixedFontSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.461 -0400", hash_original_method = "E6659EF50725F66F9827ED33E4CFAB21", hash_generated_method = "A7F1475C05B735D82AD11A533E363C94")
    public synchronized void setPageCacheCapacity(int size) {
        size = 0;
        size = 20;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.478 -0400", hash_original_method = "4253364D9E80624081FA0E0F6FDC86F7", hash_generated_method = "9A3C140656B65583E8F56FBCB98B70BC")
    public synchronized void setLoadsImagesAutomatically(boolean flag) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.478 -0400", hash_original_method = "55A6CB81C4460FAFC4A6B0D4FAE1ED88", hash_generated_method = "3FB9B82B8D54838CE69CA307BFEC8961")
    public synchronized boolean getLoadsImagesAutomatically() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_499757949 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_499757949;
        // ---------- Original Method ----------
        //return mLoadsImagesAutomatically;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.479 -0400", hash_original_method = "D93A9FC6AE1462BC3A72CE8E390FD0F6", hash_generated_method = "CA2DE6953189B36743385EF426C3E5EE")
    public synchronized void setBlockNetworkImage(boolean flag) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.479 -0400", hash_original_method = "20F3224FE4B0DC8AEBED4FF3568A3BDD", hash_generated_method = "FA2A567917974D29FDA4F2E59465BCD8")
    public synchronized boolean getBlockNetworkImage() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_929769473 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_929769473;
        // ---------- Original Method ----------
        //return mBlockNetworkImage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.479 -0400", hash_original_method = "244EC0C47571696247D156D16BFFBF27", hash_generated_method = "51B4A3CA2412AB25217BB26DD10FE406")
    public synchronized void setBlockNetworkLoads(boolean flag) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.480 -0400", hash_original_method = "8F98673864D7321D7FB7DE6793DC0EC8", hash_generated_method = "695212EBA04186D2056465B8DE36B467")
    public synchronized boolean getBlockNetworkLoads() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_105606888 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_105606888;
        // ---------- Original Method ----------
        //return mBlockNetworkLoads;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.480 -0400", hash_original_method = "4445E93EF699C8E4DE794753E49CA477", hash_generated_method = "2EF73C5860D4948CA0CCC09C21E50777")
    private void verifyNetworkAccess() {
        {
            {
                boolean varF9F9CDB4CAE6045469577FF26B8A9439_133072610 = (mContext.checkPermission("android.permission.INTERNET",
                    android.os.Process.myPid(), android.os.Process.myUid()) !=
                        PackageManager.PERMISSION_GRANTED);
                {
                    if (DroidSafeAndroidRuntime.control) throw new SecurityException
                        ("Permission denied - " +
                                "application missing INTERNET permission");
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.480 -0400", hash_original_method = "0BBFCDC224ADE5D71512B3B9C5FED4DC", hash_generated_method = "64D70D4193B1F2E55DD1C9E99012CCE3")
    public synchronized void setJavaScriptEnabled(boolean flag) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.481 -0400", hash_original_method = "8A9F66ACB83E46F66732CB0783F8BD97", hash_generated_method = "933605B48E9FFA694D81613CD45B66D0")
    public synchronized void setHardwareAccelSkiaEnabled(boolean flag) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.492 -0400", hash_original_method = "B41E73346B4841FDA1F28A35C0158347", hash_generated_method = "78DBC2DC391C14309940B60FC194991B")
    public synchronized boolean getHardwareAccelSkiaEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_695687269 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_695687269;
        // ---------- Original Method ----------
        //return mHardwareAccelSkia;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.493 -0400", hash_original_method = "69FE03F7A269EF1D16FCCD39ECE7D049", hash_generated_method = "9F791D2D352658C66E95DCF0DC9370F6")
    public synchronized void setShowVisualIndicator(boolean flag) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.493 -0400", hash_original_method = "C63472D12B908062A1CEAE79E75779C9", hash_generated_method = "B37A6C2D0205A5ADDE6A4F43695F2A3A")
    public synchronized boolean getShowVisualIndicator() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1015857668 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1015857668;
        // ---------- Original Method ----------
        //return mShowVisualIndicator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.497 -0400", hash_original_method = "05BB2A888D33554F620DCC4B01FA7575", hash_generated_method = "BBEDBA7013B276D8274879A7570AAB89")
    @Deprecated
    public synchronized void setPluginsEnabled(boolean flag) {
        setPluginState(flag ? PluginState.ON : PluginState.OFF);
        addTaint(flag);
        // ---------- Original Method ----------
        //setPluginState(flag ? PluginState.ON : PluginState.OFF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.506 -0400", hash_original_method = "DB94ACE3494108D6193A811AD96FC597", hash_generated_method = "B914CF364D0402E31147DA23CDC53AFF")
    public synchronized void setPluginState(PluginState state) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.507 -0400", hash_original_method = "773787F5C9956C3834DA2A6EB4286614", hash_generated_method = "2374B3E0E5D807A3349883E976985366")
    @Deprecated
    public synchronized void setPluginsPath(String pluginsPath) {
        addTaint(pluginsPath.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.508 -0400", hash_original_method = "AF758F2CA723722CB4C8BF68969FC2D2", hash_generated_method = "43A5AF9A7C4BA2766617791A99AC6901")
    public synchronized void setDatabasePath(String databasePath) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.508 -0400", hash_original_method = "BC0F324C7AC101E200A0E358BDBC7AB1", hash_generated_method = "3E09709941C77D54D3E49876AC504F6A")
    public synchronized void setGeolocationDatabasePath(String databasePath) {
        {
            boolean var104A4F548659CD09E1488BC6740CE5B2_1883775694 = (databasePath != null
                && !databasePath.equals(mGeolocationDatabasePath));
            {
                mGeolocationDatabasePath = databasePath;
                postSync();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (databasePath != null
                //&& !databasePath.equals(mGeolocationDatabasePath)) {
            //mGeolocationDatabasePath = databasePath;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.512 -0400", hash_original_method = "F95CC1B9D2327BC5BCD822D16CE23DEA", hash_generated_method = "4EB206C57382F21EC27F5C6807355ECF")
    public synchronized void setAppCacheEnabled(boolean flag) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.513 -0400", hash_original_method = "C7AB159C419EE425C63EEE7B4C162DEF", hash_generated_method = "C69A107231FA1A59ED6927B6C2596FE4")
    public synchronized void setAppCachePath(String appCachePath) {
        {
            boolean var42DDAC661D71068414BF42654B143F02_728057562 = (appCachePath != null && !appCachePath.equals(mAppCachePath));
            {
                mAppCachePath = appCachePath;
                postSync();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (appCachePath != null && !appCachePath.equals(mAppCachePath)) {
            //mAppCachePath = appCachePath;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.513 -0400", hash_original_method = "55D93840C546554373F35F660C5755AC", hash_generated_method = "B2958AD3AF4BAC6E248AD7C483F93C0F")
    public synchronized void setAppCacheMaxSize(long appCacheMaxSize) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.514 -0400", hash_original_method = "869B3AB9767C9688E84644FF6FE71246", hash_generated_method = "74E1CC52AC529471B70CCB6F64E1CF86")
    public synchronized void setDatabaseEnabled(boolean flag) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.514 -0400", hash_original_method = "1833A47C66872FD150B68FE6759B0625", hash_generated_method = "EFC6777A4AC44C2DBBF1785FEE8475A7")
    public synchronized void setDomStorageEnabled(boolean flag) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.515 -0400", hash_original_method = "F0262AC32F151E97C7BD7687A4F30118", hash_generated_method = "66C45E4A51FE904007D8F25C31807059")
    public synchronized boolean getDomStorageEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_34684682 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_34684682;
        // ---------- Original Method ----------
        //return mDomStorageEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.531 -0400", hash_original_method = "B06914FF8620CDD00A7D2E76B4DC9F8E", hash_generated_method = "0F54CDD4117DE467EB2C11A979B5E066")
    public synchronized String getDatabasePath() {
        String varB4EAC82CA7396A68D541C85D26508E83_937029958 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_937029958 = mDatabasePath;
        varB4EAC82CA7396A68D541C85D26508E83_937029958.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_937029958;
        // ---------- Original Method ----------
        //return mDatabasePath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.532 -0400", hash_original_method = "B3A6EABACA6DB5DAD1BC523D1F7D938A", hash_generated_method = "14D05831251C6B0DF0AEF67F9D73F743")
    public synchronized boolean getDatabaseEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_986006177 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_986006177;
        // ---------- Original Method ----------
        //return mDatabaseEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.533 -0400", hash_original_method = "5C3A0FF2F7925F672A8F3BF470C8C1B9", hash_generated_method = "BAD67E8302B9C907A64B914224C41F52")
    public synchronized void setWorkersEnabled(boolean flag) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.543 -0400", hash_original_method = "1B37EF49E1DD23D92EBFCAE289865E03", hash_generated_method = "516EAA3B9CEAA148BDA51DB59FD66B2F")
    public synchronized void setGeolocationEnabled(boolean flag) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.543 -0400", hash_original_method = "ED4873F24C9B96C88ADEA94C6CEBF439", hash_generated_method = "F24A8057079B0D00F40E6F25997D3393")
    public synchronized void setXSSAuditorEnabled(boolean flag) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.543 -0400", hash_original_method = "0DFFCBD94870E084A8277321728F548A", hash_generated_method = "2A2EA445AB6935D040017FE920308E98")
    public synchronized boolean getJavaScriptEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1347691703 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1347691703;
        // ---------- Original Method ----------
        //return mJavaScriptEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.544 -0400", hash_original_method = "71CDB5FC63B182B87115D2DBE9F21219", hash_generated_method = "47AACEE281322330CCD1A6C67882F301")
    @Deprecated
    public synchronized boolean getPluginsEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_776123648 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_776123648;
        // ---------- Original Method ----------
        //return mPluginState == PluginState.ON;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.544 -0400", hash_original_method = "F64B7B770EF5DD5F7B0D7EE789561CF2", hash_generated_method = "97F481324EA3CDE47A4BF9A633DD244D")
    public synchronized PluginState getPluginState() {
        PluginState varB4EAC82CA7396A68D541C85D26508E83_563824109 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_563824109 = mPluginState;
        varB4EAC82CA7396A68D541C85D26508E83_563824109.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_563824109;
        // ---------- Original Method ----------
        //return mPluginState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.545 -0400", hash_original_method = "9447E36E214BB4441498CEE16910C171", hash_generated_method = "92957B18094B98660496478946D5AB8C")
    @Deprecated
    public synchronized String getPluginsPath() {
        String varB4EAC82CA7396A68D541C85D26508E83_1501823449 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1501823449 = "";
        varB4EAC82CA7396A68D541C85D26508E83_1501823449.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1501823449;
        // ---------- Original Method ----------
        //return "";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.545 -0400", hash_original_method = "4CDCF2B2AC7A9689B491AFCE4B80F0EB", hash_generated_method = "62A9917CE3FE4C8B6254B9864461BAAF")
    public synchronized void setJavaScriptCanOpenWindowsAutomatically(
            boolean flag) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.561 -0400", hash_original_method = "79E98D32B2FE915E7B4CD55D0B1C896F", hash_generated_method = "5E2104ACA806F4A224639F033C3CA19D")
    public synchronized boolean getJavaScriptCanOpenWindowsAutomatically() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1943416643 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1943416643;
        // ---------- Original Method ----------
        //return mJavaScriptCanOpenWindowsAutomatically;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.562 -0400", hash_original_method = "A24B805E1ED21576385EF437050E004D", hash_generated_method = "BB7B158F03A905757D1612DAFA4E14CD")
    public synchronized void setDefaultTextEncodingName(String encoding) {
        {
            boolean var817A81EF6D982E87FA14412EF57E190A_125123983 = (encoding != null && !encoding.equals(mDefaultTextEncoding));
            {
                mDefaultTextEncoding = encoding;
                postSync();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (encoding != null && !encoding.equals(mDefaultTextEncoding)) {
            //mDefaultTextEncoding = encoding;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.562 -0400", hash_original_method = "C5F48A0B5AD67EA38BD640610E4387AC", hash_generated_method = "F1124E0176D36AA48EB8210894FEFADB")
    public synchronized String getDefaultTextEncodingName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1319825127 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1319825127 = mDefaultTextEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1319825127.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1319825127;
        // ---------- Original Method ----------
        //return mDefaultTextEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.573 -0400", hash_original_method = "EF76B53D37FAD17B99E355E5158D3AE3", hash_generated_method = "7FF41F0110FBF6848F0CDBBECF0402E8")
    public synchronized void setUserAgentString(String ua) {
        {
            boolean varF3C0DB8E14A6F2373A8E52D464BF926D_504757473 = (ua == null || ua.length() == 0);
            {
                {
                    Locale currentLocale;
                    currentLocale = Locale.getDefault();
                    {
                        boolean var192A18582AA5B1AF80348915B981AF01_258952993 = (!sLocale.equals(currentLocale));
                        {
                            sLocale = currentLocale;
                            mAcceptLanguage = getCurrentAcceptLanguage();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                ua = getCurrentUserAgent();
                mUseDefaultUserAgent = true;
            } //End block
            {
                mUseDefaultUserAgent = false;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCC809D313AE67B9E066A335FB0E09C4F_643787815 = (!ua.equals(mUserAgent));
            {
                mUserAgent = ua;
                postSync();
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.575 -0400", hash_original_method = "2522780DB5B181D072BE72836FEE2179", hash_generated_method = "118C1B7EB058A985E8EE6BEDE1EA7618")
    public synchronized String getUserAgentString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1095860359 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_687209460 = null; //Variable for return #2
        {
            boolean var5E27F088CD27294C3C475917A7A3FE4F_1828012700 = (DESKTOP_USERAGENT.equals(mUserAgent) ||
                IPHONE_USERAGENT.equals(mUserAgent) ||
                !mUseDefaultUserAgent);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1095860359 = mUserAgent;
            } //End block
        } //End collapsed parenthetic
        boolean doPostSync;
        doPostSync = false;
        {
            Locale currentLocale;
            currentLocale = Locale.getDefault();
            {
                boolean var999D054DAE77F62E7C9FEEBDA5E27DE4_270233572 = (!sLocale.equals(currentLocale));
                {
                    sLocale = currentLocale;
                    mUserAgent = getCurrentUserAgent();
                    mAcceptLanguage = getCurrentAcceptLanguage();
                    doPostSync = true;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            postSync();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_687209460 = mUserAgent;
        String varA7E53CE21691AB073D9660D615818899_675824484; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_675824484 = varB4EAC82CA7396A68D541C85D26508E83_1095860359;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_675824484 = varB4EAC82CA7396A68D541C85D26508E83_687209460;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_675824484.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_675824484;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.580 -0400", hash_original_method = "D20FFE724413B630D767FC3330D85D9B", hash_generated_method = "0DF100F74F3C97DB25E0C38392DB96CF")
    synchronized String getAcceptLanguage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1772190594 = null; //Variable for return #1
        {
            Locale currentLocale;
            currentLocale = Locale.getDefault();
            {
                boolean var999D054DAE77F62E7C9FEEBDA5E27DE4_690221219 = (!sLocale.equals(currentLocale));
                {
                    sLocale = currentLocale;
                    mAcceptLanguage = getCurrentAcceptLanguage();
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1772190594 = mAcceptLanguage;
        varB4EAC82CA7396A68D541C85D26508E83_1772190594.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1772190594;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.607 -0400", hash_original_method = "1949FADEB987BBB9FFD42544F3D5731B", hash_generated_method = "13B353B2587C91C20547D0BF78C39F8E")
     boolean isNarrowColumnLayout() {
        boolean var3FA54FC670124C41C60DD50803A1AE27_2050399838 = (getLayoutAlgorithm() == LayoutAlgorithm.NARROW_COLUMNS);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_214361154 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_214361154;
        // ---------- Original Method ----------
        //return getLayoutAlgorithm() == LayoutAlgorithm.NARROW_COLUMNS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.607 -0400", hash_original_method = "0197ABD852A904C83B0994DA40EDDF11", hash_generated_method = "EDEC36C0677D16A3DB7F7CF555068A92")
    public void setNeedInitialFocus(boolean flag) {
        {
            mNeedInitialFocus = flag;
        } //End block
        // ---------- Original Method ----------
        //if (mNeedInitialFocus != flag) {
            //mNeedInitialFocus = flag;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.607 -0400", hash_original_method = "D1C04B216D0AC5093D2F075C6698B7EE", hash_generated_method = "E0E07059E06B2D6FAB1D1D2211920269")
     boolean getNeedInitialFocus() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2015149503 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2015149503;
        // ---------- Original Method ----------
        //return mNeedInitialFocus;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.760 -0400", hash_original_method = "ADE96AEA7507FA885C654AF6A7AF6825", hash_generated_method = "B4A879F1EAC4BBBAFDDE3D7A5E9FAE50")
    public synchronized void setRenderPriority(RenderPriority priority) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.764 -0400", hash_original_method = "C16F91A0BF5BCFC94071B85F47E4B2E9", hash_generated_method = "1EAD49BE838699B8A4892907D2666345")
    public void setCacheMode(int mode) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.765 -0400", hash_original_method = "4A960A8ACA504F48F41DB237F9209DA9", hash_generated_method = "7C70F4A77E1E983C108BE4C9B253E70E")
    public int getCacheMode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1728276535 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1728276535;
        // ---------- Original Method ----------
        //return mOverrideCacheMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.766 -0400", hash_original_method = "9F8C026B57F7FDFD26FE193DA8C87BB6", hash_generated_method = "14A9D80C0D75D7DC6F84A3EFCD9C56BE")
    public void setShrinksStandaloneImagesToFit(boolean shrink) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.766 -0400", hash_original_method = "041EEBDF0CC6DB4D857EE5FE00439A69", hash_generated_method = "4CD2E49BFFA12DC12E362E99EB4885AD")
    public void setMaximumDecodedImageSize(long size) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.766 -0400", hash_original_method = "37CD2CB6E6E70B184FA7FDB5F22FF522", hash_generated_method = "D6D521269BDA5B5FAF028B573DB8A516")
     boolean getUseFixedViewport() {
        boolean var1C7F87D513600327D8EDE7818B64C140_187422557 = (getUseWideViewPort());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1986671160 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1986671160;
        // ---------- Original Method ----------
        //return getUseWideViewPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.767 -0400", hash_original_method = "F442F079E2DD19439C88D9FB5E3A709B", hash_generated_method = "52AFFAF9BA347192C957873BE0E2099D")
     boolean isPrivateBrowsingEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_382361420 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_382361420;
        // ---------- Original Method ----------
        //return mPrivateBrowsingEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.767 -0400", hash_original_method = "34042B5DCA297E4EBEB0CC9227844924", hash_generated_method = "4384A1DE98F33F910751432BE5D2BEBC")
    synchronized void setPrivateBrowsingEnabled(boolean flag) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.767 -0400", hash_original_method = "9C2B0A9C4AD9BDB94288AB167718CCA9", hash_generated_method = "2C12E6A52D426B7F22E79EB4E32C3CBA")
    public boolean forceUserScalable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1784889508 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1784889508;
        // ---------- Original Method ----------
        //return mForceUserScalable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.773 -0400", hash_original_method = "1D6F9D93B2A4A93CBF13AD0469B99A04", hash_generated_method = "7138B412D9EF0A057D7618421D7F0639")
    public synchronized void setForceUserScalable(boolean flag) {
        mForceUserScalable = flag;
        // ---------- Original Method ----------
        //mForceUserScalable = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.773 -0400", hash_original_method = "5D9DAFAFBF77CCE3ED840C406B6898AF", hash_generated_method = "54564581CB0D0A0422D2829B1608C849")
    synchronized void setSyntheticLinksEnabled(boolean flag) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.773 -0400", hash_original_method = "1A8C919F0F6505492DC614E84115DF0C", hash_generated_method = "9F87EBBBB1A9816A17DA7B52D2214262")
    public synchronized void setAutoFillEnabled(boolean enabled) {
        boolean autoFillEnabled;
        autoFillEnabled = enabled && !mPrivateBrowsingEnabled;
        {
            mAutoFillEnabled = autoFillEnabled;
            postSync();
        } //End block
        addTaint(enabled);
        // ---------- Original Method ----------
        //boolean autoFillEnabled = enabled && !mPrivateBrowsingEnabled;
        //if (mAutoFillEnabled != autoFillEnabled) {
            //mAutoFillEnabled = autoFillEnabled;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.774 -0400", hash_original_method = "8774A835D2148EBC629E39CB3DCAFA63", hash_generated_method = "9181A92E1514BD75DB67A4D0BC247BB3")
    public synchronized boolean getAutoFillEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_598730371 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_598730371;
        // ---------- Original Method ----------
        //return mAutoFillEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.775 -0400", hash_original_method = "3148173678A0F0377520D6B2C8079A70", hash_generated_method = "BDD8FDF80F0F7C11091896B03B42BA7C")
    public synchronized void setAutoFillProfile(AutoFillProfile profile) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.775 -0400", hash_original_method = "40495DA1FFE9EC3467407968672CDCF7", hash_generated_method = "99AAA1F7C951BA5DBE17D0393A38A588")
    public synchronized AutoFillProfile getAutoFillProfile() {
        AutoFillProfile varB4EAC82CA7396A68D541C85D26508E83_14415533 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_14415533 = mAutoFillProfile;
        varB4EAC82CA7396A68D541C85D26508E83_14415533.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_14415533;
        // ---------- Original Method ----------
        //return mAutoFillProfile;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.777 -0400", hash_original_method = "C3E1D2408E91E83D6659CE445CE89780", hash_generated_method = "2FDAA890C30A7CAFF8DC98EFA0193DB8")
     int getDoubleTapToastCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_65695600 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_65695600;
        // ---------- Original Method ----------
        //return mDoubleTapToastCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.777 -0400", hash_original_method = "3B766C36F75F383AEAB183DB6ECCA431", hash_generated_method = "4EF68D7498F91447015E5ACE0EF92980")
     void setDoubleTapToastCount(int count) {
        {
            mDoubleTapToastCount = count;
            mEventHandler.sendMessage(Message.obtain(null,
                    EventHandler.SET_DOUBLE_TAP_TOAST_COUNT));
        } //End block
        addTaint(count);
        // ---------- Original Method ----------
        //if (mDoubleTapToastCount != count) {
            //mDoubleTapToastCount = count;
            //mEventHandler.sendMessage(Message.obtain(null,
                    //EventHandler.SET_DOUBLE_TAP_TOAST_COUNT));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.778 -0400", hash_original_method = "51A1E424E5F24F0C6AF042B09286C12C", hash_generated_method = "D7B1E8B2585342402FC5F6C4F7B186F7")
    public void setProperty(String key, String value) {
        {
            boolean varB1AAD98259CD767817D0F1151B8AA0DE_856373250 = (mWebView.nativeSetProperty(key, value));
            {
                mWebView.contentInvalidateAll();
            } //End block
        } //End collapsed parenthetic
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //if (mWebView.nativeSetProperty(key, value)) {
            //mWebView.contentInvalidateAll();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.779 -0400", hash_original_method = "E79B730EE57AB5AA3332F72B80B24914", hash_generated_method = "32C16240E15EB9F65F34151DCFA03481")
    public String getProperty(String key) {
        String varB4EAC82CA7396A68D541C85D26508E83_455864580 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_455864580 = mWebView.nativeGetProperty(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_455864580.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_455864580;
        // ---------- Original Method ----------
        //return mWebView.nativeGetProperty(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.781 -0400", hash_original_method = "B2134E4964C5B0957E3BC21A40B5447F", hash_generated_method = "DBD70F5A845A70876B28D10024265540")
    synchronized void syncSettingsAndCreateHandler(BrowserFrame frame) {
        mBrowserFrame = frame;
        {
            junit.framework.Assert.assertTrue(frame.mNativeFrame != 0);
        } //End block
        SharedPreferences sp;
        sp = mContext.getSharedPreferences(PREF_FILE,
                Context.MODE_PRIVATE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.781 -0400", hash_original_method = "97F607FA924E3FA8AA008A1519BCA623", hash_generated_method = "B8CB642682401D5017A0F8BB624FB20A")
    synchronized void onDestroyed() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.782 -0400", hash_original_method = "32C980BFA3F312B2745A36CC144BD5C9", hash_generated_method = "8AA1FC19F254BBBB3151BE8922F94625")
    private int pin(int size) {
        addTaint(size);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_196547786 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_196547786;
        // ---------- Original Method ----------
        //if (size < 1) {
            //return 1;
        //} else if (size > 72) {
            //return 72;
        //}
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.783 -0400", hash_original_method = "028ACD01F22F62E6B019AFF3AD2AE2F1", hash_generated_method = "1FE65182E5086CFB9E39F761AEB0FBDF")
    private synchronized void postSync() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.799 -0400", hash_original_method = "B9A4DA2D5B0DA0061612E5CC599DFA25", hash_generated_method = "04F53D1036DE1FABEDB87AC10815507F")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.802 -0400", hash_original_field = "6E665E2F7DF5FB1932FA473B8AE84F08", hash_generated_field = "702EBB63B52AE60657B34C8A34DF32C2")

        private int mUniqueId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.802 -0400", hash_original_field = "7C2ED77704BD0668218967DAF6DB51FD", hash_generated_field = "D1AA858CAC76B61ED536CD7E9E76BE21")

        private String mFullName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.802 -0400", hash_original_field = "1926262D46C3AB2D57B278A3A4B76597", hash_generated_field = "A0AF6DFDA7362BDA261A45220D527187")

        private String mEmailAddress;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.802 -0400", hash_original_field = "B99930177776BA623D88C05D8012668F", hash_generated_field = "64315C7772C2603B359A256D253AD04F")

        private String mCompanyName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.802 -0400", hash_original_field = "53E31CD418D6C401C2F047A324C04D01", hash_generated_field = "E8334A774D023DCDB51748F3A66127C5")

        private String mAddressLine1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.802 -0400", hash_original_field = "7D4BD855C83D1D87736C705A5C84268D", hash_generated_field = "4E58D56AF067C60E87EAB54C984D9419")

        private String mAddressLine2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.802 -0400", hash_original_field = "5F0F1085E7414563A2B4D2E8E37D568E", hash_generated_field = "1C2845D6D4FC6B2B1D1EAAA1F2A427AE")

        private String mCity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.803 -0400", hash_original_field = "48A902C1D749B47EBC75C77370D5A1F0", hash_generated_field = "B61FE231018E4E04E31044A1AA845D59")

        private String mState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.803 -0400", hash_original_field = "9C403CDE0E845E76471FE0DBB48F2102", hash_generated_field = "068EDE81B58924A221B365F3B7E4D5D4")

        private String mZipCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.803 -0400", hash_original_field = "41CE3E330DA2FB7F8008CDC4B3CC3773", hash_generated_field = "ED069FCB05E21E7854BDD84A7C5A61F9")

        private String mCountry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.803 -0400", hash_original_field = "6A2642B1AA7D9D60E8BC8ABEC1C8C01C", hash_generated_field = "D33476978CD54C942ED6226611614D21")

        private String mPhoneNumber;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.804 -0400", hash_original_method = "356718E28156E1213C1513B4F67A401A", hash_generated_method = "C70C537927799DC936356084302DBC48")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.805 -0400", hash_original_method = "F64F21D16CFD05D4B80E501A354D44C1", hash_generated_method = "7EE6F0A3842CFCBCE24AD017EA9255CA")
        public int getUniqueId() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1527720771 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1527720771;
            // ---------- Original Method ----------
            //return mUniqueId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.811 -0400", hash_original_method = "1443687462A2902C11BD4613CE447F4A", hash_generated_method = "341DA6A90257A8727914327604DD19CC")
        public String getFullName() {
            String varB4EAC82CA7396A68D541C85D26508E83_268759807 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_268759807 = mFullName;
            varB4EAC82CA7396A68D541C85D26508E83_268759807.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_268759807;
            // ---------- Original Method ----------
            //return mFullName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.812 -0400", hash_original_method = "F1CEF297E349972E689A87BC52C1313A", hash_generated_method = "29A70DF28B25E3FA4AC6C13C76689987")
        public String getEmailAddress() {
            String varB4EAC82CA7396A68D541C85D26508E83_148263420 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_148263420 = mEmailAddress;
            varB4EAC82CA7396A68D541C85D26508E83_148263420.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_148263420;
            // ---------- Original Method ----------
            //return mEmailAddress;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.813 -0400", hash_original_method = "52206539E751E4CCE5415670F9F725D8", hash_generated_method = "C942B4C12E5AE8E9045607EC3890AB44")
        public String getCompanyName() {
            String varB4EAC82CA7396A68D541C85D26508E83_1736873543 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1736873543 = mCompanyName;
            varB4EAC82CA7396A68D541C85D26508E83_1736873543.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1736873543;
            // ---------- Original Method ----------
            //return mCompanyName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.813 -0400", hash_original_method = "C545FDC49346DC5A5D71F5AD1D1BEF53", hash_generated_method = "C8745AD19A1F0A736AE71D9BF638CBA6")
        public String getAddressLine1() {
            String varB4EAC82CA7396A68D541C85D26508E83_1407598588 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1407598588 = mAddressLine1;
            varB4EAC82CA7396A68D541C85D26508E83_1407598588.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1407598588;
            // ---------- Original Method ----------
            //return mAddressLine1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.814 -0400", hash_original_method = "F55EC6B8A39F598BB4DCA9E4A078AA07", hash_generated_method = "EF2F89ED9543E79CA214D9CF604DC396")
        public String getAddressLine2() {
            String varB4EAC82CA7396A68D541C85D26508E83_1044985183 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1044985183 = mAddressLine2;
            varB4EAC82CA7396A68D541C85D26508E83_1044985183.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1044985183;
            // ---------- Original Method ----------
            //return mAddressLine2;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.814 -0400", hash_original_method = "B85B96BC49C3B97C84AB4B17868CBD9D", hash_generated_method = "62134BD42E2B15D0C0EF093E97372B7C")
        public String getCity() {
            String varB4EAC82CA7396A68D541C85D26508E83_192806458 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_192806458 = mCity;
            varB4EAC82CA7396A68D541C85D26508E83_192806458.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_192806458;
            // ---------- Original Method ----------
            //return mCity;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.815 -0400", hash_original_method = "E347213115686AEA23D455AF8267D98C", hash_generated_method = "41653B8135D23206AB30F2AAEE65B10A")
        public String getState() {
            String varB4EAC82CA7396A68D541C85D26508E83_878703152 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_878703152 = mState;
            varB4EAC82CA7396A68D541C85D26508E83_878703152.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_878703152;
            // ---------- Original Method ----------
            //return mState;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.830 -0400", hash_original_method = "07A544AD716F805F393CD2D204A5CDEF", hash_generated_method = "EBBFF829D171FB3A2A30B8D23BB88407")
        public String getZipCode() {
            String varB4EAC82CA7396A68D541C85D26508E83_78660361 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_78660361 = mZipCode;
            varB4EAC82CA7396A68D541C85D26508E83_78660361.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_78660361;
            // ---------- Original Method ----------
            //return mZipCode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.831 -0400", hash_original_method = "F3511327404A79B77D5BB05807C0214B", hash_generated_method = "A43BDD47DFFB4DBCC0538E5E37DA9662")
        public String getCountry() {
            String varB4EAC82CA7396A68D541C85D26508E83_125179520 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_125179520 = mCountry;
            varB4EAC82CA7396A68D541C85D26508E83_125179520.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_125179520;
            // ---------- Original Method ----------
            //return mCountry;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.831 -0400", hash_original_method = "6EFA8840ED98073D74C9222B8B96940F", hash_generated_method = "CBB65115262BC4F1EACBB07369E5D163")
        public String getPhoneNumber() {
            String varB4EAC82CA7396A68D541C85D26508E83_1567260355 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1567260355 = mPhoneNumber;
            varB4EAC82CA7396A68D541C85D26508E83_1567260355.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1567260355;
            // ---------- Original Method ----------
            //return mPhoneNumber;
        }

        
    }


    
    private class EventHandler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.832 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.834 -0400", hash_original_method = "FFA7F4A8F990D2647EE1D5FBAEBEF779", hash_generated_method = "FFA7F4A8F990D2647EE1D5FBAEBEF779")
        public EventHandler ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.836 -0400", hash_original_method = "5DB82DF3D22DC31DB9F8A52C18B58140", hash_generated_method = "05A50F0E0FED7F595ECD61DE747AA431")
        private synchronized void createHandler() {
            setRenderPriority();
            mHandler = new Handler() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.836 -0400", hash_original_method = "98DDA7B8BD7D5D00B914EDDF76F7BBE2", hash_generated_method = "12807B7EF6EC9F84AF49FBC84BEDBA48")
                @Override
                public void handleMessage(Message msg) {
                    //Begin case SYNC 
                    {
                        Object var99811B65C4AE735A679EC9FB9B6A43C5_574050993 = (WebSettings.this);
                        {
                            {
                                nativeSync(mBrowserFrame.mNativeFrame);
                            } //End block
                            mSyncPending = false;
                        } //End block
                    } //End collapsed parenthetic
                    //End case SYNC 
                    //Begin case PRIORITY 
                    {
                        setRenderPriority();
                    } //End block
                    //End case PRIORITY 
                    //Begin case SET_DOUBLE_TAP_TOAST_COUNT 
                    {
                        SharedPreferences.Editor editor;
                        editor = mContext
                                    .getSharedPreferences(PREF_FILE,
                                            Context.MODE_PRIVATE).edit();
                        editor.putInt(DOUBLE_TAP_TOAST_COUNT,
                                    mDoubleTapToastCount);
                        editor.commit();
                    } //End block
                    //End case SET_DOUBLE_TAP_TOAST_COUNT 
                    addTaint(msg.getTaint());
                    // ---------- Original Method ----------
                    // Original Method Too Long, Refer to Original Implementation
                }
};
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.838 -0400", hash_original_method = "C47047917EAD94E1F72D1853ABF9CDB1", hash_generated_method = "20DBBE467E52365CFBA3895D8042D79D")
        private void setRenderPriority() {
            {
                Object var795E9C1B680F5750A86392043AD4E199_63034929 = (WebSettings.this);
                {
                    {
                        android.os.Process.setThreadPriority(
                            android.os.Process.THREAD_PRIORITY_DEFAULT);
                    } //End block
                    {
                        android.os.Process.setThreadPriority(
                            android.os.Process.THREAD_PRIORITY_FOREGROUND +
                            android.os.Process.THREAD_PRIORITY_LESS_FAVORABLE);
                    } //End block
                    {
                        android.os.Process.setThreadPriority(
                            android.os.Process.THREAD_PRIORITY_BACKGROUND);
                    } //End block
                } //End block
            } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.838 -0400", hash_original_method = "AA202573A133FD4C93192532FFFE560D", hash_generated_method = "B1433FAD0393D491D39C9D5111AC92B9")
        private synchronized boolean sendMessage(Message msg) {
            {
                mHandler.sendMessage(msg);
            } //End block
            addTaint(msg.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1755107565 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1755107565;
            // ---------- Original Method ----------
            //if (mHandler != null) {
                //mHandler.sendMessage(msg);
                //return true;
            //} else {
                //return false;
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.838 -0400", hash_original_field = "464BEEB0D5AFA6627F0AAF5994698663", hash_generated_field = "7C510E89AA2B94DC4BF68343E68DE5B7")

        static int SYNC = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.838 -0400", hash_original_field = "5222DAB64B3BBF67B11C75915AA5B6CB", hash_generated_field = "950259D3E9BF19F19D1979D138AC20ED")

        static int PRIORITY = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.838 -0400", hash_original_field = "0FAA1035BD9960470AE9A6B07D078DDB", hash_generated_field = "8AC45F1B7A769046558226E00AE0F061")

        static int SET_DOUBLE_TAP_TOAST_COUNT = 2;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.839 -0400", hash_original_field = "BA8C6A10D72C3FC67EC5924A092B65DA", hash_generated_field = "8B66A9C4881AE208D014D8CA4228F2EE")

    public static final int LOAD_DEFAULT = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.839 -0400", hash_original_field = "C5E0C3C3E96430709E7F40BA03317A64", hash_generated_field = "33703CA84A1357E3977DACD6A717E588")

    public static final int LOAD_NORMAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.839 -0400", hash_original_field = "583464AC38A651925287F1372DE1AF0E", hash_generated_field = "78B96C7AA29D9AE00D647E251F96CF2B")

    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.839 -0400", hash_original_field = "61A3672F813CA0161F13673CC6EA303F", hash_generated_field = "1E865A76FD0ADA1679603C1906D1F61A")

    public static final int LOAD_NO_CACHE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.839 -0400", hash_original_field = "A89D94A39191E20BB7D53A822E542888", hash_generated_field = "89C889C49078003040853BFEFF464593")

    public static final int LOAD_CACHE_ONLY = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.839 -0400", hash_original_field = "EAB952D25B9DD65A4E2CCAF315727D4A", hash_generated_field = "D4612FC4CB18B05034047214BB6C3653")

    private static String PREVIOUS_VERSION = "3.1";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.839 -0400", hash_original_field = "0AA76F66CE94E879138279BB4CF47B90", hash_generated_field = "FF3CCB91DD4246661BA37F60AF34DD57")

    static private int mDoubleTapToastCount = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.839 -0400", hash_original_field = "27489E71A1471DD0B589BD3A07F0599F", hash_generated_field = "E55432E900BEE4AF4A0775289A266E8B")

    private static String PREF_FILE = "WebViewSettings";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.839 -0400", hash_original_field = "B127E3FE414CC3AD2770B1BFD080F03F", hash_generated_field = "9F4CAB109F783F9FFC8F59730330A8D8")

    private static String DOUBLE_TAP_TOAST_COUNT = "double_tap_toast_count";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.839 -0400", hash_original_field = "E937B7440CD0AA715394A944140EC316", hash_generated_field = "BE4039D5023AB1FB57EE904FA7D2826F")

    private static String DESKTOP_USERAGENT = "Mozilla/5.0 (X11; " +
        "Linux x86_64) AppleWebKit/534.24 (KHTML, like Gecko) " +
        "Chrome/11.0.696.34 Safari/534.24";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.839 -0400", hash_original_field = "34908AE8379AD1FFA04E00746E4C697F", hash_generated_field = "A1C5AEF464C0D227ED9DF7E46CB4208B")

    private static String IPHONE_USERAGENT = "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_0 like Mac OS X; en-us)"
            + " AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0"
            + " Mobile/7A341 Safari/528.16";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.839 -0400", hash_original_field = "2EDA948D4DA5C99A89B49D9CAD8012C5", hash_generated_field = "3DB7C9A03487D4317932026B0B75600E")

    private static Locale sLocale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.839 -0400", hash_original_field = "45C61DCA2BF928A2594FAD3471B85EFC", hash_generated_field = "7E7566C1F279CE9C6151F8EDB80EC486")

    private static Object sLockForLocaleSettings;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:00.840 -0400", hash_original_field = "5650F87828B4F5AD453B45B9EEF47A57", hash_generated_field = "3700A5E615795F8FBEC83485D21616CE")

    private static String ACCEPT_LANG_FOR_US_LOCALE = "en-US";
}

