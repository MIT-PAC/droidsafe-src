package android.webkit;

// Droidsafe Imports
import java.util.Locale;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.EventLog;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class WebSettings {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.567 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.567 -0400", hash_original_field = "210C1862D81E3FCC2FD87A83EA255D40", hash_generated_field = "076F5BF2A47D119E2704BFAF413B4749")

    private BrowserFrame mBrowserFrame;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.567 -0400", hash_original_field = "1C1B53671D8960CFDAF6678A518773D3", hash_generated_field = "C30651F336ACC984908CFD9A1D2C4FB4")

    private boolean mSyncPending = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.567 -0400", hash_original_field = "3487E63080D45B4AAFB4C377AC2DEA9F", hash_generated_field = "04D6DC37F0EF901EF71A528809491D49")

    private EventHandler mEventHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.567 -0400", hash_original_field = "0E67D362E0510FE684D203B7C7F6070B", hash_generated_field = "47AE0040F5B89E8E9BAF92BC707C0968")

    private LayoutAlgorithm mLayoutAlgorithm = LayoutAlgorithm.NARROW_COLUMNS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.567 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.567 -0400", hash_original_field = "C77050D5C2EE6A81F7591567A7C739D3", hash_generated_field = "093C29E093EBC4DF45917F084F44F5C6")

    private int mTextSize = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.567 -0400", hash_original_field = "FD6304CD2AD07308572BAF180A0533CF", hash_generated_field = "E4348E0A07514EBC6D1B08E5327B30EE")

    private String mStandardFontFamily = "sans-serif";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.567 -0400", hash_original_field = "B1FEC4472DB98E6AC7451DE82D2FC6FA", hash_generated_field = "3A7EFCED956E000EA686CA04D7AC83B8")

    private String mFixedFontFamily = "monospace";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.567 -0400", hash_original_field = "4D96B78DF60FEF0ABEB226DA207E661D", hash_generated_field = "399DACBDFE4EA1F4862F6FE2A91B1825")

    private String mSansSerifFontFamily = "sans-serif";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.567 -0400", hash_original_field = "F5A72D21736E3B729526542A27D57950", hash_generated_field = "C8511EC396A968342E91C81EE20A14FE")

    private String mSerifFontFamily = "serif";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.567 -0400", hash_original_field = "6F0F877F43636E621A23165415BE5E9C", hash_generated_field = "C79480C6B7D9DBB1193A0C73FB024BC6")

    private String mCursiveFontFamily = "cursive";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.567 -0400", hash_original_field = "ACAA0158781BC246A182425E83276CD3", hash_generated_field = "B7EC94AD4E54CB710D321F7D7DE2B94D")

    private String mFantasyFontFamily = "fantasy";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.567 -0400", hash_original_field = "CE5A4F5B72547D0E3BED4120AB54E949", hash_generated_field = "B14E6AD20DBCE8C395967EFC3730E312")

    private String mDefaultTextEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.567 -0400", hash_original_field = "BA6D6E1CFB30AD42884BC977FE2F8001", hash_generated_field = "DE0DD9FFAB9049B26488186A370E05A4")

    private String mUserAgent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.567 -0400", hash_original_field = "E636D0AC0659FBA6915C4CA8085F37FB", hash_generated_field = "98FAE63E9B12B7A881FB6D145E4549CE")

    private boolean mUseDefaultUserAgent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.567 -0400", hash_original_field = "B1F493B722D78CD886E29BDFFE0802B3", hash_generated_field = "439229978AE9CF49770BDEBF3E2CE78C")

    private String mAcceptLanguage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.567 -0400", hash_original_field = "0F2878AB7630408FA87100B28FC68C94", hash_generated_field = "D0EDBC802964D83D99F85BC314C8A69C")

    private int mMinimumFontSize = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.567 -0400", hash_original_field = "4B34DDC1E8E68B3BED9CC6080688FF22", hash_generated_field = "528ED989B04689091770CF5109FE433F")

    private int mMinimumLogicalFontSize = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.567 -0400", hash_original_field = "836C251AEBE2201CC391FB31DC7701C0", hash_generated_field = "57AE803195BA7056811C876F5BD9502B")

    private int mDefaultFontSize = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.567 -0400", hash_original_field = "3EF20D2976FA241D9E0FF7E4D44ED19A", hash_generated_field = "5AFDCF69E75A0190CADCEA2557825121")

    private int mDefaultFixedFontSize = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.567 -0400", hash_original_field = "C84A7DE980B0C26CE75BAC761048D403", hash_generated_field = "F690B69F0C52F955F3D88DD7983F79F2")

    private int mPageCacheCapacity = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.567 -0400", hash_original_field = "7B02990524344D9852C3E43FB13DD8E4", hash_generated_field = "DE3A280A6D9972DAFD651E9018D4768E")

    private boolean mLoadsImagesAutomatically = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.567 -0400", hash_original_field = "8F5CF5F2C56460BFDB5BFC7DC9CEF759", hash_generated_field = "503153EC725C55D5C1DC162A32A1D3DC")

    private boolean mBlockNetworkImage = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.567 -0400", hash_original_field = "FF7A02E2205AE67F625F39019D239753", hash_generated_field = "1ACDBB27D2A84BAEF0BB072C0594B56E")

    private boolean mBlockNetworkLoads;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.567 -0400", hash_original_field = "C3822A70B9259EA30623C122721ADA79", hash_generated_field = "36C1818B65CEBEA6CFEE516674358D43")

    private boolean mJavaScriptEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "4CA2A324C4541CD9D0F4EA48A9F96383", hash_generated_field = "0A90F6A7499839588E833D7BE890E1AE")

    private boolean mHardwareAccelSkia = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "6BBB46DBDE2209BDCF5F06D21CED3E66", hash_generated_field = "944C133C097C1E4190CF0C3582E0E938")

    private boolean mShowVisualIndicator = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "9C4C3DA8B3DFE7677F937A106A0FA190", hash_generated_field = "7D86B7624AEF61E6266D36CF41EB39D7")

    private PluginState mPluginState = PluginState.OFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "782F3CEA749C92F0B1AEF5C560F6F376", hash_generated_field = "459DE55C50CE26452B149CCD8782CC03")

    private boolean mJavaScriptCanOpenWindowsAutomatically = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "E42DF2AC48A80AC89D5EA6C725AA31FC", hash_generated_field = "20A7E2DF1A565B51829896E9F69CF90A")

    private boolean mUseDoubleTree = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "EFD7BD41CD6C84BE258717DD0246B0D9", hash_generated_field = "5EDADBA984DCE351C397430D71B8E193")

    private boolean mUseWideViewport = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "89ADAB8AAADB11C767CDDD4A47C31E4F", hash_generated_field = "63D7A412D6A66B99394E571B78F61F6C")

    private boolean mSupportMultipleWindows = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "776CDA302169DB8F9A950481F30563B1", hash_generated_field = "77A7B89BB1F561628F9C88F763E053D4")

    private boolean mShrinksStandaloneImagesToFit = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "1C23E4BD5710D9A07575C92514B3B2A7", hash_generated_field = "71BCB1B04985B5A05BFF9925B051AEA3")

    private long mMaximumDecodedImageSize = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "23A44297716498305D043D064C5F1A5D", hash_generated_field = "381C5CB2F1A0DF35777B63F9BF8EDACD")

    private boolean mPrivateBrowsingEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "40CEACE7770B1AA574AECB611E78A601", hash_generated_field = "F43E538FC31443F2EB0B8734DEF87A58")

    private boolean mSyntheticLinksEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "FF76A93821E4C14CA2D0F905605B5253", hash_generated_field = "A8618659B8DEE94F1CEAA079EECA9790")

    private boolean mAppCacheEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "CEE1403C760B29E8CFBD90E16820A9F9", hash_generated_field = "ABA108E81C8DBD674018DAA8E50B66B3")

    private boolean mDatabaseEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "9B4BB2DD19F19AEE3A60C91A700A53A8", hash_generated_field = "5F06543ABC51E15528B933AC0AB2C6F7")

    private boolean mDomStorageEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "D120EB54296E0E73D2502E565107FA14", hash_generated_field = "74A2A29BD57D607C6576055F7F403D0D")

    private boolean mWorkersEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "F4A5919DFCEA1FA69B258487DA02ED60", hash_generated_field = "3C3198EADED631FE881AB97F9EAFA5FA")

    private boolean mGeolocationEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "24DC0A10E4E5F0680B65B6480902CF89", hash_generated_field = "6F3EA93685FD5D8B0D8F67E8E5C21B28")

    private boolean mXSSAuditorEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "BAFC052B19321AD6D2EEE9FD24C189C7", hash_generated_field = "A6B2EA55227276EA13A495BB96D1DF12")

    private long mAppCacheMaxSize = Long.MAX_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "7B285FB0B6636DBE1C8FB24FC0A7082B", hash_generated_field = "D79F53468E055B10315200B95916C500")

    private String mAppCachePath = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "0F8B2DAEF39F0C191E39D188C577F5B0", hash_generated_field = "9EB5165541C5151194CB8556E03CD161")

    private String mDatabasePath = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "96B4B13C2502429263325D7990904AE8", hash_generated_field = "F2C27E27D9065859FE4225C1B56F842D")

    private boolean mDatabasePathHasBeenSet = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "207F5E7A506E1A9B35F9E6570D102D4C", hash_generated_field = "5ABA61E953719F99114204D8D30BD28F")

    private String mGeolocationDatabasePath = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "9AF10D96415892E26A1DFAA3A56A2347", hash_generated_field = "1F48A314038B92F0A250F855FF35D5AB")

    private ZoomDensity mDefaultZoom = ZoomDensity.MEDIUM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "A39FFAE4A825508391E0316FF905EEAF", hash_generated_field = "A1F79CA724067D106338BC229C16B5FC")

    private RenderPriority mRenderPriority = RenderPriority.NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "4E7CECE5CBD06928F1F2E5152BDCB1C0", hash_generated_field = "5C01ACB0A24F788620EF740B6F83D8FF")

    private int mOverrideCacheMode = LOAD_DEFAULT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "2F57086F7AA47DF4C289A1A22809C34B", hash_generated_field = "1E5E05632184B0562D99F65B2623C2C6")

    private int mDoubleTapZoom = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "7A20407DCDB4339E9CD5D75A376E286D", hash_generated_field = "82ACFD258B431C7D2B00D5130B9F8AC1")

    private boolean mSaveFormData = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "84334DBED733230649777024AC1171F3", hash_generated_field = "EE91F91973A59EB55189A26DDA38F9B3")

    private boolean mAutoFillEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "37293F79039D53AD34CCD74A160D684B", hash_generated_field = "0C944D5751C5A507BE22C1937F62D8F5")

    private boolean mSavePassword = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "14C3D2179570F06B504FCED5EF5C9DF1", hash_generated_field = "B0E370B7C84DDE746CBD3769FED2B05B")

    private boolean mLightTouchEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "FC17F5EAB69150AD7077A5F07A1029E6", hash_generated_field = "479CD0E5DFA0F4A8AD2336A3C8796C11")

    private boolean mNeedInitialFocus = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "CD2AB2548C6EBA9F969FE4F44D9EE358", hash_generated_field = "53BEF3F54FA7E72187F7DE406E409A1B")

    private boolean mNavDump = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "4FFFB08326947A7F34D6A94BCF9C323D", hash_generated_field = "9816BC835AB5A0ACD4FDE0137AF8616C")

    private boolean mSupportZoom = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "9CF7D3194AF8F27F30388FB99A38B9FB", hash_generated_field = "C64C3FAECED9CD368C40F69AB6974F26")

    private boolean mBuiltInZoomControls = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.568 -0400", hash_original_field = "9EE62A52A99CC1E8EEF461CF8EE79F29", hash_generated_field = "620B20DEA57B92E5F177E02A77C42AD0")

    private boolean mDisplayZoomControls = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.569 -0400", hash_original_field = "8C0C96268A4FE5A7FEA363603086B178", hash_generated_field = "296BB32E1651209ADFADBF23000A8C19")

    private boolean mAllowFileAccess = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.569 -0400", hash_original_field = "E8BD268B102F8A23DE857C06F29F7274", hash_generated_field = "CCF630C83B80C2F4393E963314F2D0FE")

    private boolean mAllowContentAccess = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.569 -0400", hash_original_field = "07AA53DFAC65DD5CA73EE06FC482AC8E", hash_generated_field = "30FAFE3A56A71716731F01CEE7EBDBC8")

    private boolean mLoadWithOverviewMode = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.569 -0400", hash_original_field = "DAFB88B50FE0B9BEB8636973E61088F4", hash_generated_field = "0383F8FCA39790900B8C6F17CB8C8ACE")

    private boolean mEnableSmoothTransition = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.569 -0400", hash_original_field = "78A6C8AB01BD6AD3C287AFA07ABEFE43", hash_generated_field = "C83DD3856F6A01CD394571B6570E38C9")

    private boolean mForceUserScalable = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.569 -0400", hash_original_field = "D0E8E1D004D578571CAB3FC73F9DD791", hash_generated_field = "91C6393A6B49848292FD9CB7AF58B0CD")

    private AutoFillProfile mAutoFillProfile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.569 -0400", hash_original_field = "4727D81B5001274DB3B60E1C06A5A4B0", hash_generated_field = "73BE0F1D89639A62A6549ED3C0472D72")

    private boolean mUseWebViewBackgroundForOverscroll = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.569 -0400", hash_original_method = "C5F77054875E8CE16379FFA130433105", hash_generated_method = "1CA31199F185959AAA4CAC977BC6EA45")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.569 -0400", hash_original_method = "4DE075F72507E4E460D500D800684FF5", hash_generated_method = "BF87D083056DD36762DD8DFA35358E02")
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
String varD03843288D33B9E1D3062E25339ECF6D_226328214 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_226328214.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_226328214;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.570 -0400", hash_original_method = "7A96EBBEB91D958845CC53A11C0AF344", hash_generated_method = "9CDA40E66BC06B0DB4EA3FF5C9A66F17")
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
String varE72B15D0FE2364B4652A376ACAFBA38E_1810850022 =         String.format(base, buffer, mobile);
        varE72B15D0FE2364B4652A376ACAFBA38E_1810850022.addTaint(taint);
        return varE72B15D0FE2364B4652A376ACAFBA38E_1810850022;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.570 -0400", hash_original_method = "0785CD668E13EDF5998305462A035DB6", hash_generated_method = "3D0009C82F720043A50C0F5906394E3C")
    @Deprecated
    public void setNavDump(boolean enabled) {
        mNavDump = enabled;
        // ---------- Original Method ----------
        //mNavDump = enabled;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.570 -0400", hash_original_method = "8B24B3626FE4D070605B6C1E8E9774B6", hash_generated_method = "D31CDFDDFBE8F3E921E5AB39D696EAC9")
    @Deprecated
    public boolean getNavDump() {
        boolean var8DFF252163E31468DB1F35F5BDEB9D56_508796404 = (mNavDump);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1898190727 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1898190727;
        // ---------- Original Method ----------
        //return mNavDump;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.570 -0400", hash_original_method = "BB54171E3BDD4A64CB98C2709AC39B9C", hash_generated_method = "D34368A02E07C2A570922F9D937E7427")
     boolean supportTouchOnly() {
        boolean varD46F66368C8A17CB1607B1673483E82B_2096826158 = (mLightTouchEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_223775571 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_223775571;
        // ---------- Original Method ----------
        //return mLightTouchEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.570 -0400", hash_original_method = "6B7C7B097AE4AF077C4ED1E2A5D10429", hash_generated_method = "EE55224A930804935CDBC9F3AB3F3778")
    public void setSupportZoom(boolean support) {
        mSupportZoom = support;
        mWebView.updateMultiTouchSupport(mContext);
        // ---------- Original Method ----------
        //mSupportZoom = support;
        //mWebView.updateMultiTouchSupport(mContext);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.571 -0400", hash_original_method = "A16213EC170C52C83CDC8BBC64DBFF18", hash_generated_method = "7E2501E281EB89BA29B90FA5EE00C3C9")
    public boolean supportZoom() {
        boolean var8CE479DC01AA46B0A2C17DA4963C9C06_2094592995 = (mSupportZoom);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1348398553 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1348398553;
        // ---------- Original Method ----------
        //return mSupportZoom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.571 -0400", hash_original_method = "16CDF55EE98C899167571FFC15609D2B", hash_generated_method = "29D331EEE75AE04FE358F9041FDC9D4D")
    public void setBuiltInZoomControls(boolean enabled) {
        mBuiltInZoomControls = enabled;
        mWebView.updateMultiTouchSupport(mContext);
        // ---------- Original Method ----------
        //mBuiltInZoomControls = enabled;
        //mWebView.updateMultiTouchSupport(mContext);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.578 -0400", hash_original_method = "9006048913C3ABECFF150ED9A10494B5", hash_generated_method = "16CD45AF5C2104766F73A52D99DEEAC7")
    public boolean getBuiltInZoomControls() {
        boolean varE86A5142F372F659C5E7210280AFB569_1249212110 = (mBuiltInZoomControls);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1350353961 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1350353961;
        // ---------- Original Method ----------
        //return mBuiltInZoomControls;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.579 -0400", hash_original_method = "8F17FB2A2C1E34D57B8A250CBF0EF944", hash_generated_method = "150ABF0EFCA5E0EF820D4ABA562462C7")
    public void setDisplayZoomControls(boolean enabled) {
        mDisplayZoomControls = enabled;
        mWebView.updateMultiTouchSupport(mContext);
        // ---------- Original Method ----------
        //mDisplayZoomControls = enabled;
        //mWebView.updateMultiTouchSupport(mContext);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.579 -0400", hash_original_method = "AE5780336410432FB6F983F3F828E46C", hash_generated_method = "CA34C67F0BE92646E6C177B5009A1A75")
    public boolean getDisplayZoomControls() {
        boolean var0AA37AE22047DA8D505F49DC32F4E62C_1245109236 = (mDisplayZoomControls);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1431042270 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1431042270;
        // ---------- Original Method ----------
        //return mDisplayZoomControls;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.579 -0400", hash_original_method = "C265511540E520E57BDB53C1B101C5AC", hash_generated_method = "3FA94A3866D3A3E694A204489118E1F3")
    public void setAllowFileAccess(boolean allow) {
        mAllowFileAccess = allow;
        // ---------- Original Method ----------
        //mAllowFileAccess = allow;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.579 -0400", hash_original_method = "ED281F9FC327C1DCA93656D122E60B6E", hash_generated_method = "692DB543C934949F488DD75A90F4846A")
    public boolean getAllowFileAccess() {
        boolean varB1028CE892468A1504CF91F79B7267EA_1236774436 = (mAllowFileAccess);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1894781052 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1894781052;
        // ---------- Original Method ----------
        //return mAllowFileAccess;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.579 -0400", hash_original_method = "1A30AACA222993CDBB39CAF3A548FAE3", hash_generated_method = "55017C3A0896C8083D53F9176707C196")
    public void setAllowContentAccess(boolean allow) {
        mAllowContentAccess = allow;
        // ---------- Original Method ----------
        //mAllowContentAccess = allow;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.579 -0400", hash_original_method = "E20572D9D9FCBBCAC622C44A2D9C5369", hash_generated_method = "89B61A8BC40EE2F501969EA3E89136BC")
    public boolean getAllowContentAccess() {
        boolean var2130116D297854C0D76F169B8FA8234A_439643055 = (mAllowContentAccess);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1260490667 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1260490667;
        // ---------- Original Method ----------
        //return mAllowContentAccess;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.579 -0400", hash_original_method = "E0C53B0ABBE8903B8C2E5235B7766B9A", hash_generated_method = "B6128BCF06C01508511BF873AD287A93")
    public void setLoadWithOverviewMode(boolean overview) {
        mLoadWithOverviewMode = overview;
        // ---------- Original Method ----------
        //mLoadWithOverviewMode = overview;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.580 -0400", hash_original_method = "0D409EAD2B46C91908C9804617827D1C", hash_generated_method = "6B529B3F585FB3246283535026C30EC0")
    public boolean getLoadWithOverviewMode() {
        boolean varDEC2FCD950650CAB3BA25EB7D1C5E32F_489059150 = (mLoadWithOverviewMode);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1414404677 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1414404677;
        // ---------- Original Method ----------
        //return mLoadWithOverviewMode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.580 -0400", hash_original_method = "B5CB73D3FC09526DD6AE502765086798", hash_generated_method = "64C152888041D085E972D81D1C95DC93")
    public void setEnableSmoothTransition(boolean enable) {
        mEnableSmoothTransition = enable;
        // ---------- Original Method ----------
        //mEnableSmoothTransition = enable;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.580 -0400", hash_original_method = "FB45006D48B3F1A32CF7E83242DDAE7D", hash_generated_method = "A9F183D9EE7F3EAAB9AB03D281662FD1")
    public boolean enableSmoothTransition() {
        boolean var579974033D1C44F79EC73FDBB9FAD536_289843708 = (mEnableSmoothTransition);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_657799053 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_657799053;
        // ---------- Original Method ----------
        //return mEnableSmoothTransition;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.580 -0400", hash_original_method = "6C4A8C912B988582A0E8E6FECC7FBF9C", hash_generated_method = "85F98D1E9E9195557007E0781EDA3C95")
    @Deprecated
    public void setUseWebViewBackgroundForOverscrollBackground(boolean view) {
        mUseWebViewBackgroundForOverscroll = view;
        // ---------- Original Method ----------
        //mUseWebViewBackgroundForOverscroll = view;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.580 -0400", hash_original_method = "FE1757AAD5E1DD702744237E901A55C8", hash_generated_method = "88F59AEC65B85DA36BF9CC5F6010BAE6")
    @Deprecated
    public boolean getUseWebViewBackgroundForOverscrollBackground() {
        boolean var1FCAB0B89E9FD4AD8C1700F04F27D8F1_1896172058 = (mUseWebViewBackgroundForOverscroll);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_140008504 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_140008504;
        // ---------- Original Method ----------
        //return mUseWebViewBackgroundForOverscroll;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.580 -0400", hash_original_method = "BAE3B161CD7589698136E106A2876792", hash_generated_method = "1B000F89994FD51C8FCC87F59A7E5B8A")
    public void setSaveFormData(boolean save) {
        mSaveFormData = save;
        // ---------- Original Method ----------
        //mSaveFormData = save;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.580 -0400", hash_original_method = "4DFFD3713A8D682938D03E8713A587EF", hash_generated_method = "2C84100906D789DED6CFDE9706F47B2B")
    public boolean getSaveFormData() {
        boolean var209B65E7AFDCF898AA38A64A2FC85397_1218015247 = (mSaveFormData && !mPrivateBrowsingEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_31507040 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_31507040;
        // ---------- Original Method ----------
        //return mSaveFormData && !mPrivateBrowsingEnabled;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.580 -0400", hash_original_method = "B2DE3A754D34523602EAE606838B5563", hash_generated_method = "1A0C14453C50A93DCB55814578EA8BF3")
    public void setSavePassword(boolean save) {
        mSavePassword = save;
        // ---------- Original Method ----------
        //mSavePassword = save;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.580 -0400", hash_original_method = "7EDF9AC2E1EDCCF642364DB0CD31765F", hash_generated_method = "1FE0BBA7AD0B5468C0CE4DE6CDF141E7")
    public boolean getSavePassword() {
        boolean var09F500AA40683E97951DF0A53E99F20F_1150832383 = (mSavePassword);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1518320183 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1518320183;
        // ---------- Original Method ----------
        //return mSavePassword;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.580 -0400", hash_original_method = "C5C41A533FE351F2D45D268D5D267050", hash_generated_method = "F1ADB5AC3FF31784521C0307BCC0965A")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.581 -0400", hash_original_method = "570564B346A8D968406F236CA99E37F6", hash_generated_method = "D68960F1A444192507D338D60327D437")
    public synchronized int getTextZoom() {
        int var327DC1284D23313571A41B232E2678D5_1331093911 = (mTextSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1997654656 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1997654656;
        // ---------- Original Method ----------
        //return mTextSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.581 -0400", hash_original_method = "D3E0150ED5C00CC3B22240870480363B", hash_generated_method = "E65696AA4DF9F8E14B9F03A2E6BDDE5A")
    public synchronized void setTextSize(TextSize t) {
        addTaint(t.getTaint());
        setTextZoom(t.value);
        // ---------- Original Method ----------
        //setTextZoom(t.value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.581 -0400", hash_original_method = "900BE61F6B80F2B5D843AC6DC18F9D15", hash_generated_method = "D56B85F72A2FD41203EB39D647563692")
    public synchronized TextSize getTextSize() {
        TextSize closestSize = null;
        int smallestDelta = Integer.MAX_VALUE;
for(TextSize size : TextSize.values())
        {
            int delta = Math.abs(mTextSize - size.value);
            if(delta == 0)            
            {
TextSize var1C66204DCEA9331BE00F48731BABEBBE_559171144 =                 size;
                var1C66204DCEA9331BE00F48731BABEBBE_559171144.addTaint(taint);
                return var1C66204DCEA9331BE00F48731BABEBBE_559171144;
            } //End block
            if(delta < smallestDelta)            
            {
                smallestDelta = delta;
                closestSize = size;
            } //End block
        } //End block
TextSize varA667F0019A139609606DB37BCD641C93_1762892690 =         closestSize != null ? closestSize : TextSize.NORMAL;
        varA667F0019A139609606DB37BCD641C93_1762892690.addTaint(taint);
        return varA667F0019A139609606DB37BCD641C93_1762892690;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.581 -0400", hash_original_method = "E23B2F666BB6D09A8C611DD5B37D2698", hash_generated_method = "09C709307553D8058D837CA6F5A25D16")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.581 -0400", hash_original_method = "137930918FD91EA20A5F57296DD24AFB", hash_generated_method = "4890343CC4F14CE44B5E958D337968B7")
    public int getDoubleTapZoom() {
        int varB24A87E78F1CA38FA17FF0BB7E4C8A3D_840023459 = (mDoubleTapZoom);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_500253381 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_500253381;
        // ---------- Original Method ----------
        //return mDoubleTapZoom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.581 -0400", hash_original_method = "E4C2219CCE12A9777A4354402A44D34B", hash_generated_method = "3BE66571F0DC55B262AB1E0A66B4A9FB")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.581 -0400", hash_original_method = "72EF0E181D832EBBD7F53BEF96096C0C", hash_generated_method = "F7A34828089B633D71681F894BF45E2C")
    public ZoomDensity getDefaultZoom() {
ZoomDensity varADD2946A80182532484870CA33B16E4C_498049753 =         mDefaultZoom;
        varADD2946A80182532484870CA33B16E4C_498049753.addTaint(taint);
        return varADD2946A80182532484870CA33B16E4C_498049753;
        // ---------- Original Method ----------
        //return mDefaultZoom;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.582 -0400", hash_original_method = "DFD74C15B6ACEBABFCBAF5FDE1C7D76D", hash_generated_method = "9AE3C2EAB296845CAC779F245F6C12E3")
    public void setLightTouchEnabled(boolean enabled) {
        mLightTouchEnabled = enabled;
        // ---------- Original Method ----------
        //mLightTouchEnabled = enabled;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.582 -0400", hash_original_method = "02D840FF3CC8AE7A6DEC323EC455B33B", hash_generated_method = "BB8CF7D660A8F070ECAE8CDE5931EC64")
    public boolean getLightTouchEnabled() {
        boolean varD46F66368C8A17CB1607B1673483E82B_1862138126 = (mLightTouchEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1930928456 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1930928456;
        // ---------- Original Method ----------
        //return mLightTouchEnabled;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.582 -0400", hash_original_method = "EF2600D8826AB6D5A4057F05D8E61936", hash_generated_method = "F24F619D5E27EFB871068CEAD3B02126")
    @Deprecated
    public synchronized void setUseDoubleTree(boolean use) {
        addTaint(use);
        return;
        // ---------- Original Method ----------
        //return;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.582 -0400", hash_original_method = "89BCC0409F823F147F01A4F485C1EC58", hash_generated_method = "5368FBE0E0BA1E920C621E882AB00319")
    @Deprecated
    public synchronized boolean getUseDoubleTree() {
        boolean var68934A3E9455FA72420237EB05902327_435542216 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1612937505 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1612937505;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.582 -0400", hash_original_method = "85DE35A00A5168FE5C8491B5E07C3BBE", hash_generated_method = "83A18675D250A2D60ACEA9271EE0AAC7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.583 -0400", hash_original_method = "622085E3817D576D67ED6E0D62241C79", hash_generated_method = "CB21D01C15E63C20A133AD09E8ABACFF")
    @Deprecated
    public synchronized int getUserAgent() {
        if(DESKTOP_USERAGENT.equals(mUserAgent))        
        {
            int varC4CA4238A0B923820DCC509A6F75849B_1055915536 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1528313137 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1528313137;
        } //End block
        else
        if(IPHONE_USERAGENT.equals(mUserAgent))        
        {
            int varC81E728D9D4C2F636F067F89CC14862C_292306206 = (2);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1279478748 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1279478748;
        } //End block
        else
        if(mUseDefaultUserAgent)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1822849751 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_345187560 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_345187560;
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1178777018 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1184338474 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1184338474;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.583 -0400", hash_original_method = "6232B93EE163514DA7A8F2A20C0E8296", hash_generated_method = "8FB4C239CC17E89B66B686DAE2CD068E")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.583 -0400", hash_original_method = "B42FD143593B620F53C7027879473593", hash_generated_method = "A77D4EA183B898A199BE6BDFD6C3937A")
    public synchronized boolean getUseWideViewPort() {
        boolean var4E022A6EBF72CC69C3CF35943A51F619_1741376059 = (mUseWideViewport);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_39410831 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_39410831;
        // ---------- Original Method ----------
        //return mUseWideViewport;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.583 -0400", hash_original_method = "961D9442BDC4ECD4A72AED0ECCABFF49", hash_generated_method = "A62E95927C47DFDAC7DBD2A61E99317F")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.583 -0400", hash_original_method = "DC8997F98FC697774C788E0E9C368A15", hash_generated_method = "00857023DB43B3D01C4AED337E9FA68E")
    public synchronized boolean supportMultipleWindows() {
        boolean var426334A3E8E8819F8B6152B2D96C1902_997918767 = (mSupportMultipleWindows);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_169965578 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_169965578;
        // ---------- Original Method ----------
        //return mSupportMultipleWindows;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.583 -0400", hash_original_method = "CF796A65BC60375130249D0138E0D269", hash_generated_method = "4D215C334C6E01F80F7C88BA91724002")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.583 -0400", hash_original_method = "D199B05491A7568F9921CD10D25BC54E", hash_generated_method = "F9AEEB07FC07C5FFA844B12CB193CBF4")
    public synchronized LayoutAlgorithm getLayoutAlgorithm() {
LayoutAlgorithm var204CDD3DC144FE754C7AA775EBA06CC5_1845393278 =         mLayoutAlgorithm;
        var204CDD3DC144FE754C7AA775EBA06CC5_1845393278.addTaint(taint);
        return var204CDD3DC144FE754C7AA775EBA06CC5_1845393278;
        // ---------- Original Method ----------
        //return mLayoutAlgorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.583 -0400", hash_original_method = "80141FBB7709CEF61745CB878BA8248B", hash_generated_method = "724B663B9FD12E5AE5FA99728C1335D4")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.583 -0400", hash_original_method = "D17418EAB461A3931F0EFDEA802C4808", hash_generated_method = "7CEC34A8C13B89EB3F8DA5C9A6ABAD1F")
    public synchronized String getStandardFontFamily() {
String varC2323C1961CCC92FBE9666D2F620C295_1844860324 =         mStandardFontFamily;
        varC2323C1961CCC92FBE9666D2F620C295_1844860324.addTaint(taint);
        return varC2323C1961CCC92FBE9666D2F620C295_1844860324;
        // ---------- Original Method ----------
        //return mStandardFontFamily;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.584 -0400", hash_original_method = "85832E987C30A09FD65E322D8A53532D", hash_generated_method = "CB184341EA1E9A3A9A7987844387EA0F")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.584 -0400", hash_original_method = "91A5D658AFF46E5675EE0251B0448A37", hash_generated_method = "71EB4D5DF9F06E4A654A5A37CD111401")
    public synchronized String getFixedFontFamily() {
String var453A77CFB409A7BA198C0C8D0A55C188_1247312580 =         mFixedFontFamily;
        var453A77CFB409A7BA198C0C8D0A55C188_1247312580.addTaint(taint);
        return var453A77CFB409A7BA198C0C8D0A55C188_1247312580;
        // ---------- Original Method ----------
        //return mFixedFontFamily;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.597 -0400", hash_original_method = "5317C7E81FFF6267D702DE0B9A35C25F", hash_generated_method = "BA635A1BB620256EB2FB53C4A401BF21")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.597 -0400", hash_original_method = "E8B035ABC4C315E7FC00763BCE4B3101", hash_generated_method = "D62383A7BC6F71C54973F0F8B7620E58")
    public synchronized String getSansSerifFontFamily() {
String var0951E059DBC0E72E6FB78569D216234E_842020880 =         mSansSerifFontFamily;
        var0951E059DBC0E72E6FB78569D216234E_842020880.addTaint(taint);
        return var0951E059DBC0E72E6FB78569D216234E_842020880;
        // ---------- Original Method ----------
        //return mSansSerifFontFamily;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.597 -0400", hash_original_method = "B0B03F3832ADF5F3F163E426E788DEB1", hash_generated_method = "88CF7D908E70EAAC6D322B47C50516B6")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.597 -0400", hash_original_method = "AEE55B3207D2A837254BD0F18E5F431B", hash_generated_method = "D3A4E3290F04BCACDAEBBD4846C094A7")
    public synchronized String getSerifFontFamily() {
String var5BE2E40B500827616D5F1DACA1DE414C_620387861 =         mSerifFontFamily;
        var5BE2E40B500827616D5F1DACA1DE414C_620387861.addTaint(taint);
        return var5BE2E40B500827616D5F1DACA1DE414C_620387861;
        // ---------- Original Method ----------
        //return mSerifFontFamily;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.597 -0400", hash_original_method = "8334AD5BA97572A472DE2E88CF457E83", hash_generated_method = "C683BC8A9E3A52AEA5BE4427B5AB4D92")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.598 -0400", hash_original_method = "A9100EF4E222FCE0DCE66A7BF6E9785C", hash_generated_method = "9462BEAFCC178DD9984E9B5437A629D7")
    public synchronized String getCursiveFontFamily() {
String var4268F048F8F465953A322CC0EA3072E4_1427071900 =         mCursiveFontFamily;
        var4268F048F8F465953A322CC0EA3072E4_1427071900.addTaint(taint);
        return var4268F048F8F465953A322CC0EA3072E4_1427071900;
        // ---------- Original Method ----------
        //return mCursiveFontFamily;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.598 -0400", hash_original_method = "3BEE212C0CAB12BA1830E10645682B81", hash_generated_method = "DA2766F02C11CAF107FA3DEA5FF1DAF7")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.598 -0400", hash_original_method = "3AB44712F248734E7DE5412E073462E0", hash_generated_method = "5AA32457781B8635EB9A1149AAB0ED63")
    public synchronized String getFantasyFontFamily() {
String varB11A6B5782C3062153801D3970A8B2B3_1837319857 =         mFantasyFontFamily;
        varB11A6B5782C3062153801D3970A8B2B3_1837319857.addTaint(taint);
        return varB11A6B5782C3062153801D3970A8B2B3_1837319857;
        // ---------- Original Method ----------
        //return mFantasyFontFamily;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.598 -0400", hash_original_method = "5B2F36FEBD6497C3F70A8544117DF67F", hash_generated_method = "D0C03ED65D32A9D0B10CBA4AF9963EE2")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.598 -0400", hash_original_method = "9F0281C9F2E3CE3701E30B7BA1EEFCDC", hash_generated_method = "C5B1297C3D880154646027F1D751ADDE")
    public synchronized int getMinimumFontSize() {
        int var1CED7631993D433AB3E3EAD56A97E4B5_1873327853 = (mMinimumFontSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_156998851 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_156998851;
        // ---------- Original Method ----------
        //return mMinimumFontSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.599 -0400", hash_original_method = "979D72ED8DED37C47A363976CA577A0C", hash_generated_method = "CC8304D57BC9F2254F129246B799A31C")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.599 -0400", hash_original_method = "4108641CDFB7F27DEA848BE579464C88", hash_generated_method = "470AEA690DE2E78163316495DE8BA9C6")
    public synchronized int getMinimumLogicalFontSize() {
        int var16397BCD87AEDB5C4CAA0DDA7F3F318E_1635243514 = (mMinimumLogicalFontSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1315833637 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1315833637;
        // ---------- Original Method ----------
        //return mMinimumLogicalFontSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.600 -0400", hash_original_method = "F015D29DAD166EF30FCB62EA8F22BD34", hash_generated_method = "771AC0EFA70AE45800781712A93198E0")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.600 -0400", hash_original_method = "DC87CC6F42B19166FD6192BC9DCDB609", hash_generated_method = "A431A924C775802443EBDAA5E01802B4")
    public synchronized int getDefaultFontSize() {
        int var6886352F96FB7FB3509C56BF652A3D6F_1013950870 = (mDefaultFontSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_19193606 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_19193606;
        // ---------- Original Method ----------
        //return mDefaultFontSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.601 -0400", hash_original_method = "F38EE7285BA7C36F298A402033D20C39", hash_generated_method = "0FB29AC3C80E3B44A0146BA96FBFA62B")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.601 -0400", hash_original_method = "32FF94F6134070C3A3BF7D6E4734C806", hash_generated_method = "8430AADDBE0E42F72239CD9715B502E8")
    public synchronized int getDefaultFixedFontSize() {
        int var277FA59166BE5F07A75727E6F1E6256A_148310272 = (mDefaultFixedFontSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1184948438 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1184948438;
        // ---------- Original Method ----------
        //return mDefaultFixedFontSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.601 -0400", hash_original_method = "E6659EF50725F66F9827ED33E4CFAB21", hash_generated_method = "9527A145900C649C5117DA2FAA06C397")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.606 -0400", hash_original_method = "4253364D9E80624081FA0E0F6FDC86F7", hash_generated_method = "006ECAE2613F23BD4DADA78790AF2980")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.606 -0400", hash_original_method = "55A6CB81C4460FAFC4A6B0D4FAE1ED88", hash_generated_method = "AD6D968A7E19A38529B4048711B291E7")
    public synchronized boolean getLoadsImagesAutomatically() {
        boolean var4EFDF4DFE342F71CCDA924B633275708_1068849313 = (mLoadsImagesAutomatically);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_138054471 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_138054471;
        // ---------- Original Method ----------
        //return mLoadsImagesAutomatically;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.606 -0400", hash_original_method = "D93A9FC6AE1462BC3A72CE8E390FD0F6", hash_generated_method = "A8BA1197A5F0C97B3BD5B7B777C0DBD5")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.606 -0400", hash_original_method = "20F3224FE4B0DC8AEBED4FF3568A3BDD", hash_generated_method = "A01A72676BB4735A2A018E640F9C4474")
    public synchronized boolean getBlockNetworkImage() {
        boolean var184A06B4892767F2B78106DDB589FBF7_2146997214 = (mBlockNetworkImage);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_739335742 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_739335742;
        // ---------- Original Method ----------
        //return mBlockNetworkImage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.607 -0400", hash_original_method = "244EC0C47571696247D156D16BFFBF27", hash_generated_method = "1DB492CB4004AF02C30F39711C6F4E86")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.607 -0400", hash_original_method = "8F98673864D7321D7FB7DE6793DC0EC8", hash_generated_method = "BD906B7C4B8B394BE9C71DC316FEC4F7")
    public synchronized boolean getBlockNetworkLoads() {
        boolean varFF7A02E2205AE67F625F39019D239753_345636772 = (mBlockNetworkLoads);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_162270687 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_162270687;
        // ---------- Original Method ----------
        //return mBlockNetworkLoads;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.607 -0400", hash_original_method = "4445E93EF699C8E4DE794753E49CA477", hash_generated_method = "0B4E78E94E98AD8A79506E6D3ACE1E50")
    private void verifyNetworkAccess() {
        if(!mBlockNetworkLoads)        
        {
            if(mContext.checkPermission("android.permission.INTERNET",
                    android.os.Process.myPid(), android.os.Process.myUid()) !=
                        PackageManager.PERMISSION_GRANTED)            
            {
                SecurityException varE249CB53B453896FEADF35A72FFEB5A8_2057407338 = new SecurityException
                        ("Permission denied - " +
                                "application missing INTERNET permission");
                varE249CB53B453896FEADF35A72FFEB5A8_2057407338.addTaint(taint);
                throw varE249CB53B453896FEADF35A72FFEB5A8_2057407338;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.609 -0400", hash_original_method = "0BBFCDC224ADE5D71512B3B9C5FED4DC", hash_generated_method = "B76E7C530464C07FD00CE283FE1B79CB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.609 -0400", hash_original_method = "8A9F66ACB83E46F66732CB0783F8BD97", hash_generated_method = "AC9C31EF301FDA55234E882CD7F32D5E")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.609 -0400", hash_original_method = "B41E73346B4841FDA1F28A35C0158347", hash_generated_method = "60E64CE4CB609742A0E48A0013F97685")
    public synchronized boolean getHardwareAccelSkiaEnabled() {
        boolean varEB21311A166E0F2DBA02B218D19B4AC9_110146542 = (mHardwareAccelSkia);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1365913200 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1365913200;
        // ---------- Original Method ----------
        //return mHardwareAccelSkia;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.609 -0400", hash_original_method = "69FE03F7A269EF1D16FCCD39ECE7D049", hash_generated_method = "70118629FB48BC31CDC0E5F0131B7539")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.609 -0400", hash_original_method = "C63472D12B908062A1CEAE79E75779C9", hash_generated_method = "ECF6361108031955F37E6DC12DE78350")
    public synchronized boolean getShowVisualIndicator() {
        boolean varB43EF6CB92DDDD967AA82418BC205214_416474040 = (mShowVisualIndicator);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1064619112 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1064619112;
        // ---------- Original Method ----------
        //return mShowVisualIndicator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.609 -0400", hash_original_method = "05BB2A888D33554F620DCC4B01FA7575", hash_generated_method = "111033F6059DDDD53D879E0C4C968AEA")
    @Deprecated
    public synchronized void setPluginsEnabled(boolean flag) {
        addTaint(flag);
        setPluginState(flag ? PluginState.ON : PluginState.OFF);
        // ---------- Original Method ----------
        //setPluginState(flag ? PluginState.ON : PluginState.OFF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.609 -0400", hash_original_method = "DB94ACE3494108D6193A811AD96FC597", hash_generated_method = "D3E8ECEF7C81240D8520E3D7DC7A5A88")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.610 -0400", hash_original_method = "773787F5C9956C3834DA2A6EB4286614", hash_generated_method = "2374B3E0E5D807A3349883E976985366")
    @Deprecated
    public synchronized void setPluginsPath(String pluginsPath) {
        addTaint(pluginsPath.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.610 -0400", hash_original_method = "AF758F2CA723722CB4C8BF68969FC2D2", hash_generated_method = "FE951B42DADBE726FC6298063497D7B7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.610 -0400", hash_original_method = "BC0F324C7AC101E200A0E358BDBC7AB1", hash_generated_method = "BF69870B320812A112DB079CC8951211")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.610 -0400", hash_original_method = "F95CC1B9D2327BC5BCD822D16CE23DEA", hash_generated_method = "3ED25C02C90AD08A9D462807E54EEA03")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.610 -0400", hash_original_method = "C7AB159C419EE425C63EEE7B4C162DEF", hash_generated_method = "B40AB22D7676452A82ACE26F8989F28F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.611 -0400", hash_original_method = "55D93840C546554373F35F660C5755AC", hash_generated_method = "DA4779B6CAFAEFA48DF6C010F725D898")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.611 -0400", hash_original_method = "869B3AB9767C9688E84644FF6FE71246", hash_generated_method = "8D8E3B449B60932E27E339F26C7BA1DE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.611 -0400", hash_original_method = "1833A47C66872FD150B68FE6759B0625", hash_generated_method = "82E041B98A1C87FED6913F44E0A0281B")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.611 -0400", hash_original_method = "F0262AC32F151E97C7BD7687A4F30118", hash_generated_method = "693921210842A7024FDB2AF1C5013865")
    public synchronized boolean getDomStorageEnabled() {
        boolean varD0A927B9A1C760031CAA5DDA7BBFD388_1131725739 = (mDomStorageEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2025048547 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2025048547;
        // ---------- Original Method ----------
        //return mDomStorageEnabled;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.611 -0400", hash_original_method = "B06914FF8620CDD00A7D2E76B4DC9F8E", hash_generated_method = "6680A18759E7D925F5F71284B14021AB")
    public synchronized String getDatabasePath() {
String var09ADE5DECF0573905A2C722EF656BEFD_1789841075 =         mDatabasePath;
        var09ADE5DECF0573905A2C722EF656BEFD_1789841075.addTaint(taint);
        return var09ADE5DECF0573905A2C722EF656BEFD_1789841075;
        // ---------- Original Method ----------
        //return mDatabasePath;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.613 -0400", hash_original_method = "B3A6EABACA6DB5DAD1BC523D1F7D938A", hash_generated_method = "1748173A2C5B316E59938DA52707DD4E")
    public synchronized boolean getDatabaseEnabled() {
        boolean varA1FF3A7CF6B05DEBD8460B2CB48B0856_291186186 = (mDatabaseEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_142648338 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_142648338;
        // ---------- Original Method ----------
        //return mDatabaseEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.613 -0400", hash_original_method = "5C3A0FF2F7925F672A8F3BF470C8C1B9", hash_generated_method = "2145D7D320B33EA7A8DA240334B657D2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.613 -0400", hash_original_method = "1B37EF49E1DD23D92EBFCAE289865E03", hash_generated_method = "241A2DB45C62A93F1FA32F366F8956FF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.613 -0400", hash_original_method = "ED4873F24C9B96C88ADEA94C6CEBF439", hash_generated_method = "B84327DEB02009204CF4A60D7F7A9697")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.613 -0400", hash_original_method = "0DFFCBD94870E084A8277321728F548A", hash_generated_method = "F8CF3D7EC85C61082CD200857BE0D5A3")
    public synchronized boolean getJavaScriptEnabled() {
        boolean var707CBF1A08CFDB7819946B136B8EB5C6_1755998181 = (mJavaScriptEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_242567597 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_242567597;
        // ---------- Original Method ----------
        //return mJavaScriptEnabled;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.613 -0400", hash_original_method = "71CDB5FC63B182B87115D2DBE9F21219", hash_generated_method = "0655ECB6873F3B94CFFABF273B6DF3C4")
    @Deprecated
    public synchronized boolean getPluginsEnabled() {
        boolean var2D9750CF298E5139E5C20C7D6B70811E_2115688263 = (mPluginState == PluginState.ON);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1455756911 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1455756911;
        // ---------- Original Method ----------
        //return mPluginState == PluginState.ON;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.616 -0400", hash_original_method = "F64B7B770EF5DD5F7B0D7EE789561CF2", hash_generated_method = "199AAF2D1EC3E908429A34FB77133C28")
    public synchronized PluginState getPluginState() {
PluginState var64622CACFBD4FB77B6311C98F3645FA8_1965192142 =         mPluginState;
        var64622CACFBD4FB77B6311C98F3645FA8_1965192142.addTaint(taint);
        return var64622CACFBD4FB77B6311C98F3645FA8_1965192142;
        // ---------- Original Method ----------
        //return mPluginState;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.616 -0400", hash_original_method = "9447E36E214BB4441498CEE16910C171", hash_generated_method = "347C3735D042B9BB7F07FF008969CE20")
    @Deprecated
    public synchronized String getPluginsPath() {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1944020781 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1944020781.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1944020781;
        // ---------- Original Method ----------
        //return "";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.616 -0400", hash_original_method = "4CDCF2B2AC7A9689B491AFCE4B80F0EB", hash_generated_method = "931C629023BFB895281F385B1BF9B198")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.616 -0400", hash_original_method = "79E98D32B2FE915E7B4CD55D0B1C896F", hash_generated_method = "BCD8293E7498735F8B62D6B0378D51AC")
    public synchronized boolean getJavaScriptCanOpenWindowsAutomatically() {
        boolean varDF402D9036608C9172BF297E4CBAC36D_617308907 = (mJavaScriptCanOpenWindowsAutomatically);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1415048331 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1415048331;
        // ---------- Original Method ----------
        //return mJavaScriptCanOpenWindowsAutomatically;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.617 -0400", hash_original_method = "A24B805E1ED21576385EF437050E004D", hash_generated_method = "EB125807562DD6A96C8FC5B9FC6B1CF8")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.617 -0400", hash_original_method = "C5F48A0B5AD67EA38BD640610E4387AC", hash_generated_method = "C5CB9E41F4449A9E26C6731AF120F7D7")
    public synchronized String getDefaultTextEncodingName() {
String varFBF8D4E5D31D3452180EB440EBF187F9_1767966872 =         mDefaultTextEncoding;
        varFBF8D4E5D31D3452180EB440EBF187F9_1767966872.addTaint(taint);
        return varFBF8D4E5D31D3452180EB440EBF187F9_1767966872;
        // ---------- Original Method ----------
        //return mDefaultTextEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.623 -0400", hash_original_method = "EF76B53D37FAD17B99E355E5158D3AE3", hash_generated_method = "4096CC9F38B94167C96CFC9D088EF85B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.623 -0400", hash_original_method = "2522780DB5B181D072BE72836FEE2179", hash_generated_method = "A48D97326FD726ECADC740DCD2DDAE74")
    public synchronized String getUserAgentString() {
        if(DESKTOP_USERAGENT.equals(mUserAgent) ||
                IPHONE_USERAGENT.equals(mUserAgent) ||
                !mUseDefaultUserAgent)        
        {
String var335897D5BF56D3EA7F3758538DEBFEFF_1358650635 =             mUserAgent;
            var335897D5BF56D3EA7F3758538DEBFEFF_1358650635.addTaint(taint);
            return var335897D5BF56D3EA7F3758538DEBFEFF_1358650635;
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
String var335897D5BF56D3EA7F3758538DEBFEFF_475522875 =         mUserAgent;
        var335897D5BF56D3EA7F3758538DEBFEFF_475522875.addTaint(taint);
        return var335897D5BF56D3EA7F3758538DEBFEFF_475522875;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.623 -0400", hash_original_method = "D20FFE724413B630D767FC3330D85D9B", hash_generated_method = "25BC0CB051D3982A517777F6F1794800")
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
String var4F4D12599D633053CBC85A8AA103D90E_1309646304 =         mAcceptLanguage;
        var4F4D12599D633053CBC85A8AA103D90E_1309646304.addTaint(taint);
        return var4F4D12599D633053CBC85A8AA103D90E_1309646304;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.628 -0400", hash_original_method = "1949FADEB987BBB9FFD42544F3D5731B", hash_generated_method = "05829049C5EFC50B4F163B02BBA6B8B7")
     boolean isNarrowColumnLayout() {
        boolean var99A4DD0BA17C4D3916FB39A801BD55DD_463889166 = (getLayoutAlgorithm() == LayoutAlgorithm.NARROW_COLUMNS);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_129860579 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_129860579;
        // ---------- Original Method ----------
        //return getLayoutAlgorithm() == LayoutAlgorithm.NARROW_COLUMNS;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.628 -0400", hash_original_method = "0197ABD852A904C83B0994DA40EDDF11", hash_generated_method = "05A68B3D53B7DB8A16EC4EB4288E385A")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.628 -0400", hash_original_method = "D1C04B216D0AC5093D2F075C6698B7EE", hash_generated_method = "878D5361C83B943A482CBC4C10D511F1")
     boolean getNeedInitialFocus() {
        boolean var820CEB0204DC67DEC0541F055959708A_1356978757 = (mNeedInitialFocus);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2047509491 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2047509491;
        // ---------- Original Method ----------
        //return mNeedInitialFocus;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.628 -0400", hash_original_method = "ADE96AEA7507FA885C654AF6A7AF6825", hash_generated_method = "797489A82414FABADB8B85D2C13B14AC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.629 -0400", hash_original_method = "C16F91A0BF5BCFC94071B85F47E4B2E9", hash_generated_method = "D970A1AF8762DC7784F4CF34C3544E3B")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.629 -0400", hash_original_method = "4A960A8ACA504F48F41DB237F9209DA9", hash_generated_method = "ABAB023585D67E8D5E045E3AE1189A92")
    public int getCacheMode() {
        int var78B36B7BB0452881B8B7324BB5C0D0C6_1857316792 = (mOverrideCacheMode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1394842491 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1394842491;
        // ---------- Original Method ----------
        //return mOverrideCacheMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.633 -0400", hash_original_method = "9F8C026B57F7FDFD26FE193DA8C87BB6", hash_generated_method = "05DD6215B4364E5E03CBD9C423B1B7CA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.633 -0400", hash_original_method = "041EEBDF0CC6DB4D857EE5FE00439A69", hash_generated_method = "2E832976280C843DBE994376E28B6AFA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.633 -0400", hash_original_method = "37CD2CB6E6E70B184FA7FDB5F22FF522", hash_generated_method = "5EB3E7BB9B85E3C590994B3612286A63")
     boolean getUseFixedViewport() {
        boolean varA51C20A0FE1B2ECC6101FEF8C98C549F_1881980950 = (getUseWideViewPort());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_426069789 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_426069789;
        // ---------- Original Method ----------
        //return getUseWideViewPort();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.633 -0400", hash_original_method = "F442F079E2DD19439C88D9FB5E3A709B", hash_generated_method = "A83420663D4D9E9DFAA6C4E1EF1B2815")
     boolean isPrivateBrowsingEnabled() {
        boolean var7D859B4BFCBF6FEA0D71AF4F7D782122_696680896 = (mPrivateBrowsingEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_62150184 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_62150184;
        // ---------- Original Method ----------
        //return mPrivateBrowsingEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.633 -0400", hash_original_method = "34042B5DCA297E4EBEB0CC9227844924", hash_generated_method = "D55DA92CCE574D999F3216C3F666458F")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.633 -0400", hash_original_method = "9C2B0A9C4AD9BDB94288AB167718CCA9", hash_generated_method = "3D3E3F455DD16F494C6704524CA8C15D")
    public boolean forceUserScalable() {
        boolean var848CE56F11C41CF540C3E3D9775A50CD_2107664042 = (mForceUserScalable);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_817540320 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_817540320;
        // ---------- Original Method ----------
        //return mForceUserScalable;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.637 -0400", hash_original_method = "1D6F9D93B2A4A93CBF13AD0469B99A04", hash_generated_method = "7138B412D9EF0A057D7618421D7F0639")
    public synchronized void setForceUserScalable(boolean flag) {
        mForceUserScalable = flag;
        // ---------- Original Method ----------
        //mForceUserScalable = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.637 -0400", hash_original_method = "5D9DAFAFBF77CCE3ED840C406B6898AF", hash_generated_method = "DAD7E3131EFE7AC3635DB02DE70DE0E1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.637 -0400", hash_original_method = "1A8C919F0F6505492DC614E84115DF0C", hash_generated_method = "F61C7134BE409D0B39FF0DC9DB0724EC")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.637 -0400", hash_original_method = "8774A835D2148EBC629E39CB3DCAFA63", hash_generated_method = "1AB86210F6713225EF73AA3ACB00D552")
    public synchronized boolean getAutoFillEnabled() {
        boolean var50EA70E6285C1FCC7F3B54A690D3A99B_672837205 = (mAutoFillEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_882026603 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_882026603;
        // ---------- Original Method ----------
        //return mAutoFillEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.637 -0400", hash_original_method = "3148173678A0F0377520D6B2C8079A70", hash_generated_method = "4AC5916B6C89A554548624C538C5A9FE")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.637 -0400", hash_original_method = "40495DA1FFE9EC3467407968672CDCF7", hash_generated_method = "767663C77195EAEB5900B7EFF6ACA311")
    public synchronized AutoFillProfile getAutoFillProfile() {
AutoFillProfile varDCF553BB5F5743139326AD6AFF33B6D4_449259077 =         mAutoFillProfile;
        varDCF553BB5F5743139326AD6AFF33B6D4_449259077.addTaint(taint);
        return varDCF553BB5F5743139326AD6AFF33B6D4_449259077;
        // ---------- Original Method ----------
        //return mAutoFillProfile;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.640 -0400", hash_original_method = "C3E1D2408E91E83D6659CE445CE89780", hash_generated_method = "86A6FC175DB7F8602A1E3EE7304881F3")
     int getDoubleTapToastCount() {
        int var17BCFD6E10D42DFDED1479FBB922DF4A_34890906 = (mDoubleTapToastCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1046793590 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1046793590;
        // ---------- Original Method ----------
        //return mDoubleTapToastCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.640 -0400", hash_original_method = "3B766C36F75F383AEAB183DB6ECCA431", hash_generated_method = "748D32156F971838C8466AB83CD0C4D1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.640 -0400", hash_original_method = "51A1E424E5F24F0C6AF042B09286C12C", hash_generated_method = "2FBBC9B17F398A03B1F17079F3321661")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.640 -0400", hash_original_method = "E79B730EE57AB5AA3332F72B80B24914", hash_generated_method = "CC4BB9E90FD216B50030E3827806F9EA")
    public String getProperty(String key) {
        addTaint(key.getTaint());
String var953EAE7B2F85C0E869D0F2008318D845_728848379 =         mWebView.nativeGetProperty(key);
        var953EAE7B2F85C0E869D0F2008318D845_728848379.addTaint(taint);
        return var953EAE7B2F85C0E869D0F2008318D845_728848379;
        // ---------- Original Method ----------
        //return mWebView.nativeGetProperty(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.640 -0400", hash_original_method = "B2134E4964C5B0957E3BC21A40B5447F", hash_generated_method = "B30157721046338430C3F847FFC8E60F")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.640 -0400", hash_original_method = "97F607FA924E3FA8AA008A1519BCA623", hash_generated_method = "B8CB642682401D5017A0F8BB624FB20A")
    synchronized void onDestroyed() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.643 -0400", hash_original_method = "32C980BFA3F312B2745A36CC144BD5C9", hash_generated_method = "F9F52305F23143363AFC102C487FD00F")
    private int pin(int size) {
        addTaint(size);
        if(size < 1)        
        {
            int varC4CA4238A0B923820DCC509A6F75849B_286401674 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1260707970 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1260707970;
        } //End block
        else
        if(size > 72)        
        {
            int var32BB90E8976AAB5298D5DA10FE66F21D_453065096 = (72);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_358278992 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_358278992;
        } //End block
        int varF7BD60B75B29D79B660A2859395C1A24_742077091 = (size);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1835813915 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1835813915;
        // ---------- Original Method ----------
        //if (size < 1) {
            //return 1;
        //} else if (size > 72) {
            //return 72;
        //}
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.643 -0400", hash_original_method = "028ACD01F22F62E6B019AFF3AD2AE2F1", hash_generated_method = "CF312E77451B47E2F44D5FE40AFD1B62")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.643 -0400", hash_original_method = "B9A4DA2D5B0DA0061612E5CC599DFA25", hash_generated_method = "04F53D1036DE1FABEDB87AC10815507F")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.643 -0400", hash_original_field = "6E665E2F7DF5FB1932FA473B8AE84F08", hash_generated_field = "702EBB63B52AE60657B34C8A34DF32C2")

        private int mUniqueId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.643 -0400", hash_original_field = "7C2ED77704BD0668218967DAF6DB51FD", hash_generated_field = "D1AA858CAC76B61ED536CD7E9E76BE21")

        private String mFullName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.643 -0400", hash_original_field = "1926262D46C3AB2D57B278A3A4B76597", hash_generated_field = "A0AF6DFDA7362BDA261A45220D527187")

        private String mEmailAddress;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.643 -0400", hash_original_field = "B99930177776BA623D88C05D8012668F", hash_generated_field = "64315C7772C2603B359A256D253AD04F")

        private String mCompanyName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.643 -0400", hash_original_field = "53E31CD418D6C401C2F047A324C04D01", hash_generated_field = "E8334A774D023DCDB51748F3A66127C5")

        private String mAddressLine1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.643 -0400", hash_original_field = "7D4BD855C83D1D87736C705A5C84268D", hash_generated_field = "4E58D56AF067C60E87EAB54C984D9419")

        private String mAddressLine2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.643 -0400", hash_original_field = "5F0F1085E7414563A2B4D2E8E37D568E", hash_generated_field = "1C2845D6D4FC6B2B1D1EAAA1F2A427AE")

        private String mCity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.643 -0400", hash_original_field = "48A902C1D749B47EBC75C77370D5A1F0", hash_generated_field = "B61FE231018E4E04E31044A1AA845D59")

        private String mState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.643 -0400", hash_original_field = "9C403CDE0E845E76471FE0DBB48F2102", hash_generated_field = "068EDE81B58924A221B365F3B7E4D5D4")

        private String mZipCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.643 -0400", hash_original_field = "41CE3E330DA2FB7F8008CDC4B3CC3773", hash_generated_field = "ED069FCB05E21E7854BDD84A7C5A61F9")

        private String mCountry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.644 -0400", hash_original_field = "6A2642B1AA7D9D60E8BC8ABEC1C8C01C", hash_generated_field = "D33476978CD54C942ED6226611614D21")

        private String mPhoneNumber;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.646 -0400", hash_original_method = "356718E28156E1213C1513B4F67A401A", hash_generated_method = "C70C537927799DC936356084302DBC48")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.646 -0400", hash_original_method = "F64F21D16CFD05D4B80E501A354D44C1", hash_generated_method = "0B2BB0B1F698A43187DFC2B03EC624E2")
        public int getUniqueId() {
            int var6E665E2F7DF5FB1932FA473B8AE84F08_388861705 = (mUniqueId);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_638592859 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_638592859;
            // ---------- Original Method ----------
            //return mUniqueId;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.647 -0400", hash_original_method = "1443687462A2902C11BD4613CE447F4A", hash_generated_method = "740373E4D79EB3443B2A953BBF6B3F21")
        public String getFullName() {
String var2CCB86D92A5B0C93E777B6E62E71CDC6_1129259302 =             mFullName;
            var2CCB86D92A5B0C93E777B6E62E71CDC6_1129259302.addTaint(taint);
            return var2CCB86D92A5B0C93E777B6E62E71CDC6_1129259302;
            // ---------- Original Method ----------
            //return mFullName;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.647 -0400", hash_original_method = "F1CEF297E349972E689A87BC52C1313A", hash_generated_method = "9AAF7C0CC4465DF2D9D987C5B1FB272D")
        public String getEmailAddress() {
String var63A2807D05CF632F5A6F3F5506F67A7E_456930026 =             mEmailAddress;
            var63A2807D05CF632F5A6F3F5506F67A7E_456930026.addTaint(taint);
            return var63A2807D05CF632F5A6F3F5506F67A7E_456930026;
            // ---------- Original Method ----------
            //return mEmailAddress;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.655 -0400", hash_original_method = "52206539E751E4CCE5415670F9F725D8", hash_generated_method = "F46EBBBD74A331B31AA022EECE225F62")
        public String getCompanyName() {
String var2E2CFBAE98075B2F38165FF6B5315FDB_805353081 =             mCompanyName;
            var2E2CFBAE98075B2F38165FF6B5315FDB_805353081.addTaint(taint);
            return var2E2CFBAE98075B2F38165FF6B5315FDB_805353081;
            // ---------- Original Method ----------
            //return mCompanyName;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.655 -0400", hash_original_method = "C545FDC49346DC5A5D71F5AD1D1BEF53", hash_generated_method = "521FF2B34228B2FD2E6CCFF404F8B472")
        public String getAddressLine1() {
String var97836B935EE797BC03B2C35FD389260E_722620875 =             mAddressLine1;
            var97836B935EE797BC03B2C35FD389260E_722620875.addTaint(taint);
            return var97836B935EE797BC03B2C35FD389260E_722620875;
            // ---------- Original Method ----------
            //return mAddressLine1;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.655 -0400", hash_original_method = "F55EC6B8A39F598BB4DCA9E4A078AA07", hash_generated_method = "0578ECAC0493DF1BA2BF78A9F5853B53")
        public String getAddressLine2() {
String var5B6AEEB071C96720B296D9D9B2769F7D_1718174861 =             mAddressLine2;
            var5B6AEEB071C96720B296D9D9B2769F7D_1718174861.addTaint(taint);
            return var5B6AEEB071C96720B296D9D9B2769F7D_1718174861;
            // ---------- Original Method ----------
            //return mAddressLine2;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.655 -0400", hash_original_method = "B85B96BC49C3B97C84AB4B17868CBD9D", hash_generated_method = "E6DEE769F1410F2981E4159E991559EC")
        public String getCity() {
String varBF53149F9650F8F50BF0BE976469DB2F_629497625 =             mCity;
            varBF53149F9650F8F50BF0BE976469DB2F_629497625.addTaint(taint);
            return varBF53149F9650F8F50BF0BE976469DB2F_629497625;
            // ---------- Original Method ----------
            //return mCity;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.655 -0400", hash_original_method = "E347213115686AEA23D455AF8267D98C", hash_generated_method = "D75E23F2FFC451B8D55B39C54CEB878E")
        public String getState() {
String var8B975C85F13BECB9FD4D21A5F3C8A56D_102462502 =             mState;
            var8B975C85F13BECB9FD4D21A5F3C8A56D_102462502.addTaint(taint);
            return var8B975C85F13BECB9FD4D21A5F3C8A56D_102462502;
            // ---------- Original Method ----------
            //return mState;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.655 -0400", hash_original_method = "07A544AD716F805F393CD2D204A5CDEF", hash_generated_method = "8D9DDE4C35520E0603E5C51BDB3F308F")
        public String getZipCode() {
String var74620C2EEA996952D2AB511FC6914DEB_762330339 =             mZipCode;
            var74620C2EEA996952D2AB511FC6914DEB_762330339.addTaint(taint);
            return var74620C2EEA996952D2AB511FC6914DEB_762330339;
            // ---------- Original Method ----------
            //return mZipCode;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.655 -0400", hash_original_method = "F3511327404A79B77D5BB05807C0214B", hash_generated_method = "8E007B02A1BDDCDA68BA6BECB82EFF2B")
        public String getCountry() {
String var23DFF2AE842E650E5366ACC3BDCD9DC0_765750259 =             mCountry;
            var23DFF2AE842E650E5366ACC3BDCD9DC0_765750259.addTaint(taint);
            return var23DFF2AE842E650E5366ACC3BDCD9DC0_765750259;
            // ---------- Original Method ----------
            //return mCountry;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.655 -0400", hash_original_method = "6EFA8840ED98073D74C9222B8B96940F", hash_generated_method = "D481C32933A0127BB7C40AED85C8582C")
        public String getPhoneNumber() {
String var6A717345AF76EF28363FFAB5D9CDC4CC_2006849013 =             mPhoneNumber;
            var6A717345AF76EF28363FFAB5D9CDC4CC_2006849013.addTaint(taint);
            return var6A717345AF76EF28363FFAB5D9CDC4CC_2006849013;
            // ---------- Original Method ----------
            //return mPhoneNumber;
        }

        
    }


    
    private class EventHandler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.655 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.655 -0400", hash_original_method = "FFA7F4A8F990D2647EE1D5FBAEBEF779", hash_generated_method = "FFA7F4A8F990D2647EE1D5FBAEBEF779")
        public EventHandler ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.661 -0400", hash_original_method = "5DB82DF3D22DC31DB9F8A52C18B58140", hash_generated_method = "B5AB3291AD33F11E70232B2AEE7B8C52")
        private synchronized void createHandler() {
            setRenderPriority();
            mHandler = new Handler() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.661 -0400", hash_original_method = "98DDA7B8BD7D5D00B914EDDF76F7BBE2", hash_generated_method = "1E6C5E9BCB1C2D25E483D4F4DBBC8CA0")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.661 -0400", hash_original_method = "C47047917EAD94E1F72D1853ABF9CDB1", hash_generated_method = "C3428E61FCEC12B1434968D54EBB49AC")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.661 -0400", hash_original_method = "AA202573A133FD4C93192532FFFE560D", hash_generated_method = "4DBA84A4C1963987B57E213B639CE5DE")
        private synchronized boolean sendMessage(Message msg) {
            addTaint(msg.getTaint());
            if(mHandler != null)            
            {
                mHandler.sendMessage(msg);
                boolean varB326B5062B2F0E69046810717534CB09_1781231897 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_870748455 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_870748455;
            } //End block
            else
            {
                boolean var68934A3E9455FA72420237EB05902327_159019064 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_820261249 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_820261249;
            } //End block
            // ---------- Original Method ----------
            //if (mHandler != null) {
                //mHandler.sendMessage(msg);
                //return true;
            //} else {
                //return false;
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.661 -0400", hash_original_field = "464BEEB0D5AFA6627F0AAF5994698663", hash_generated_field = "BEA2A099547FF2FCBA953052760FB020")

        static final int SYNC = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.661 -0400", hash_original_field = "5222DAB64B3BBF67B11C75915AA5B6CB", hash_generated_field = "43C72D88EADF09AFDEC0F00E9349B1C9")

        static final int PRIORITY = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.661 -0400", hash_original_field = "0FAA1035BD9960470AE9A6B07D078DDB", hash_generated_field = "6436B1795825C9FB51AD30AEEB2034F0")

        static final int SET_DOUBLE_TAP_TOAST_COUNT = 2;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.661 -0400", hash_original_field = "BA8C6A10D72C3FC67EC5924A092B65DA", hash_generated_field = "8B66A9C4881AE208D014D8CA4228F2EE")

    public static final int LOAD_DEFAULT = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.661 -0400", hash_original_field = "C5E0C3C3E96430709E7F40BA03317A64", hash_generated_field = "33703CA84A1357E3977DACD6A717E588")

    public static final int LOAD_NORMAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.661 -0400", hash_original_field = "583464AC38A651925287F1372DE1AF0E", hash_generated_field = "78B96C7AA29D9AE00D647E251F96CF2B")

    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.661 -0400", hash_original_field = "61A3672F813CA0161F13673CC6EA303F", hash_generated_field = "1E865A76FD0ADA1679603C1906D1F61A")

    public static final int LOAD_NO_CACHE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.661 -0400", hash_original_field = "A89D94A39191E20BB7D53A822E542888", hash_generated_field = "89C889C49078003040853BFEFF464593")

    public static final int LOAD_CACHE_ONLY = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.661 -0400", hash_original_field = "EAB952D25B9DD65A4E2CCAF315727D4A", hash_generated_field = "D0EF9E13114399EDE7E01406D4CC77CA")

    private static final String PREVIOUS_VERSION = "3.1";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.661 -0400", hash_original_field = "0AA76F66CE94E879138279BB4CF47B90", hash_generated_field = "FF3CCB91DD4246661BA37F60AF34DD57")

    static private int mDoubleTapToastCount = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.662 -0400", hash_original_field = "27489E71A1471DD0B589BD3A07F0599F", hash_generated_field = "6E3C440D8BF3EC1CA16D917A01E72EB8")

    private static final String PREF_FILE = "WebViewSettings";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.662 -0400", hash_original_field = "B127E3FE414CC3AD2770B1BFD080F03F", hash_generated_field = "5C124E37B3B634132C4C5D9B585D5CEC")

    private static final String DOUBLE_TAP_TOAST_COUNT = "double_tap_toast_count";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.664 -0400", hash_original_field = "E937B7440CD0AA715394A944140EC316", hash_generated_field = "1F903F388B91C74E2027345321C211C3")

    private static final String DESKTOP_USERAGENT = "Mozilla/5.0 (X11; " +
        "Linux x86_64) AppleWebKit/534.24 (KHTML, like Gecko) " +
        "Chrome/11.0.696.34 Safari/534.24";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.664 -0400", hash_original_field = "34908AE8379AD1FFA04E00746E4C697F", hash_generated_field = "1FE7BDD371AF963C7DBF5F80D7ED2ED5")

    private static final String IPHONE_USERAGENT = "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_0 like Mac OS X; en-us)"
            + " AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0"
            + " Mobile/7A341 Safari/528.16";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.664 -0400", hash_original_field = "2EDA948D4DA5C99A89B49D9CAD8012C5", hash_generated_field = "3DB7C9A03487D4317932026B0B75600E")

    private static Locale sLocale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.664 -0400", hash_original_field = "45C61DCA2BF928A2594FAD3471B85EFC", hash_generated_field = "7E7566C1F279CE9C6151F8EDB80EC486")

    private static Object sLockForLocaleSettings;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.664 -0400", hash_original_field = "5650F87828B4F5AD453B45B9EEF47A57", hash_generated_field = "5546D78A409F4DFBBA356772B2D57DF1")

    private static final String ACCEPT_LANG_FOR_US_LOCALE = "en-US";
}

