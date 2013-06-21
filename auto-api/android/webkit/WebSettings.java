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
    private WebView mWebView;
    private BrowserFrame mBrowserFrame;
    private boolean mSyncPending = false;
    private EventHandler mEventHandler;
    private LayoutAlgorithm mLayoutAlgorithm = LayoutAlgorithm.NARROW_COLUMNS;
    private Context         mContext;
    private int             mTextSize = 100;
    private String          mStandardFontFamily = "sans-serif";
    private String          mFixedFontFamily = "monospace";
    private String          mSansSerifFontFamily = "sans-serif";
    private String          mSerifFontFamily = "serif";
    private String          mCursiveFontFamily = "cursive";
    private String          mFantasyFontFamily = "fantasy";
    private String          mDefaultTextEncoding;
    private String          mUserAgent;
    private boolean         mUseDefaultUserAgent;
    private String          mAcceptLanguage;
    private int             mMinimumFontSize = 8;
    private int             mMinimumLogicalFontSize = 8;
    private int             mDefaultFontSize = 16;
    private int             mDefaultFixedFontSize = 13;
    private int             mPageCacheCapacity = 0;
    private boolean         mLoadsImagesAutomatically = true;
    private boolean         mBlockNetworkImage = false;
    private boolean         mBlockNetworkLoads;
    private boolean         mJavaScriptEnabled = false;
    private boolean         mHardwareAccelSkia = false;
    private boolean         mShowVisualIndicator = false;
    private PluginState     mPluginState = PluginState.OFF;
    private boolean         mJavaScriptCanOpenWindowsAutomatically = false;
    private boolean         mUseDoubleTree = false;
    private boolean         mUseWideViewport = false;
    private boolean         mSupportMultipleWindows = false;
    private boolean         mShrinksStandaloneImagesToFit = false;
    private long            mMaximumDecodedImageSize = 0;
    private boolean         mPrivateBrowsingEnabled = false;
    private boolean         mSyntheticLinksEnabled = true;
    private boolean         mAppCacheEnabled = false;
    private boolean         mDatabaseEnabled = false;
    private boolean         mDomStorageEnabled = false;
    private boolean         mWorkersEnabled = false;
    private boolean         mGeolocationEnabled = true;
    private boolean         mXSSAuditorEnabled = false;
    private long            mAppCacheMaxSize = Long.MAX_VALUE;
    private String          mAppCachePath = "";
    private String          mDatabasePath = "";
    private boolean         mDatabasePathHasBeenSet = false;
    private String          mGeolocationDatabasePath = "";
    private ZoomDensity     mDefaultZoom = ZoomDensity.MEDIUM;
    private RenderPriority  mRenderPriority = RenderPriority.NORMAL;
    private int             mOverrideCacheMode = LOAD_DEFAULT;
    private int             mDoubleTapZoom = 100;
    private boolean         mSaveFormData = true;
    private boolean         mAutoFillEnabled = false;
    private boolean         mSavePassword = true;
    private boolean         mLightTouchEnabled = false;
    private boolean         mNeedInitialFocus = true;
    private boolean         mNavDump = false;
    private boolean         mSupportZoom = true;
    private boolean         mBuiltInZoomControls = false;
    private boolean         mDisplayZoomControls = true;
    private boolean         mAllowFileAccess = true;
    private boolean         mAllowContentAccess = true;
    private boolean         mLoadWithOverviewMode = false;
    private boolean         mEnableSmoothTransition = false;
    private boolean         mForceUserScalable = false;
    private AutoFillProfile mAutoFillProfile;
    private boolean         mUseWebViewBackgroundForOverscroll = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.048 -0400", hash_original_method = "C5F77054875E8CE16379FFA130433105", hash_generated_method = "B8461ED53E559239C37FCE7D42A27C02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     WebSettings(Context context, WebView webview) {
        dsTaint.addTaint(webview.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        mEventHandler = new EventHandler();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.049 -0400", hash_original_method = "4DE075F72507E4E460D500D800684FF5", hash_generated_method = "304402AF130775FE04EA2852604A4969")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getCurrentAcceptLanguage() {
        Locale locale;
        {
            locale = sLocale;
        } //End block
        StringBuilder buffer;
        buffer = new StringBuilder();
        addLocaleToHttpAcceptLanguage(buffer, locale);
        {
            boolean var431751D6A3587215342AEEB02B5F09EE_1044181347 = (!Locale.US.equals(locale));
            {
                {
                    boolean var9C02A302D5D3520DE4F4E0F080BCC1E1_1207669543 = (buffer.length() > 0);
                    {
                        buffer.append(", ");
                    } //End block
                } //End collapsed parenthetic
                buffer.append(ACCEPT_LANG_FOR_US_LOCALE);
            } //End block
        } //End collapsed parenthetic
        String varAD28D02EB1C6982A5710D014292E1955_1161993608 = (buffer.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.050 -0400", hash_original_method = "7A96EBBEB91D958845CC53A11C0AF344", hash_generated_method = "9C005083939FF2021EB119BC27A71CDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized String getCurrentUserAgent() {
        Locale locale;
        {
            locale = sLocale;
        } //End block
        StringBuffer buffer;
        buffer = new StringBuffer();
        String version;
        version = Build.VERSION.RELEASE;
        {
            boolean var4C6295605C370EDE83CC155E9E515FA4_407665699 = (version.length() > 0);
            {
                {
                    boolean varAA1BB3E0B4229E1816D8A6A205E26C86_855485690 = (Character.isDigit(version.charAt(0)));
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
            boolean var74E1736D68B691D0E86DFB92E7377FE0_1463975506 = ("REL".equals(Build.VERSION.CODENAME));
            {
                String model;
                model = Build.MODEL;
                {
                    boolean varA8E096DD510AFCFD2AF4DF6E257AC809_101676383 = (model.length() > 0);
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
            boolean var9B6DAC42F8BDFB2B50C52216DE688E8B_335754398 = (id.length() > 0);
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
        String varAEB0D1CA262E3F00C77EC94EC09EB59C_2045370305 = (String.format(base, buffer, mobile));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.050 -0400", hash_original_method = "0785CD668E13EDF5998305462A035DB6", hash_generated_method = "77C5522344F48396B9D4E7AB99313BCA")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void setNavDump(boolean enabled) {
        dsTaint.addTaint(enabled);
        // ---------- Original Method ----------
        //mNavDump = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.050 -0400", hash_original_method = "8B24B3626FE4D070605B6C1E8E9774B6", hash_generated_method = "5BDFFAE6248E9A098B0380D9B306DEA8")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public boolean getNavDump() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mNavDump;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.050 -0400", hash_original_method = "BB54171E3BDD4A64CB98C2709AC39B9C", hash_generated_method = "FEFA7D50638A0D8581DF60E78A6107E7")
    @DSModeled(DSC.SAFE)
     boolean supportTouchOnly() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mLightTouchEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.050 -0400", hash_original_method = "6B7C7B097AE4AF077C4ED1E2A5D10429", hash_generated_method = "1777EB1C23D82F5BCC05A355403AD653")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSupportZoom(boolean support) {
        dsTaint.addTaint(support);
        mWebView.updateMultiTouchSupport(mContext);
        // ---------- Original Method ----------
        //mSupportZoom = support;
        //mWebView.updateMultiTouchSupport(mContext);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.051 -0400", hash_original_method = "A16213EC170C52C83CDC8BBC64DBFF18", hash_generated_method = "37ABF36DC08A7F4803CC39A160F5D6D5")
    @DSModeled(DSC.SAFE)
    public boolean supportZoom() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSupportZoom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.051 -0400", hash_original_method = "16CDF55EE98C899167571FFC15609D2B", hash_generated_method = "346AF64A99AB0FDFAC845B7BEA02EDC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBuiltInZoomControls(boolean enabled) {
        dsTaint.addTaint(enabled);
        mWebView.updateMultiTouchSupport(mContext);
        // ---------- Original Method ----------
        //mBuiltInZoomControls = enabled;
        //mWebView.updateMultiTouchSupport(mContext);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.051 -0400", hash_original_method = "9006048913C3ABECFF150ED9A10494B5", hash_generated_method = "E58022F3047396B7C272529B94EC2F03")
    @DSModeled(DSC.SAFE)
    public boolean getBuiltInZoomControls() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mBuiltInZoomControls;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.051 -0400", hash_original_method = "8F17FB2A2C1E34D57B8A250CBF0EF944", hash_generated_method = "C14497D0B3F3A8EE15343F62920F49EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDisplayZoomControls(boolean enabled) {
        dsTaint.addTaint(enabled);
        mWebView.updateMultiTouchSupport(mContext);
        // ---------- Original Method ----------
        //mDisplayZoomControls = enabled;
        //mWebView.updateMultiTouchSupport(mContext);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.051 -0400", hash_original_method = "AE5780336410432FB6F983F3F828E46C", hash_generated_method = "EE789098D055D600CE8282AE527D25A4")
    @DSModeled(DSC.SAFE)
    public boolean getDisplayZoomControls() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDisplayZoomControls;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.052 -0400", hash_original_method = "C265511540E520E57BDB53C1B101C5AC", hash_generated_method = "D22EC2D3D7C7B3173172B7AA28C26D27")
    @DSModeled(DSC.SAFE)
    public void setAllowFileAccess(boolean allow) {
        dsTaint.addTaint(allow);
        // ---------- Original Method ----------
        //mAllowFileAccess = allow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.052 -0400", hash_original_method = "ED281F9FC327C1DCA93656D122E60B6E", hash_generated_method = "C02A14CDC46C5C8E303CE7561A455E37")
    @DSModeled(DSC.SAFE)
    public boolean getAllowFileAccess() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAllowFileAccess;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.052 -0400", hash_original_method = "1A30AACA222993CDBB39CAF3A548FAE3", hash_generated_method = "CF6D3C9041A80B030D2D19D6D3F50456")
    @DSModeled(DSC.SAFE)
    public void setAllowContentAccess(boolean allow) {
        dsTaint.addTaint(allow);
        // ---------- Original Method ----------
        //mAllowContentAccess = allow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.052 -0400", hash_original_method = "E20572D9D9FCBBCAC622C44A2D9C5369", hash_generated_method = "593B6FC123D3D1E4FA9A65B6D63CCCF3")
    @DSModeled(DSC.SAFE)
    public boolean getAllowContentAccess() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAllowContentAccess;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.052 -0400", hash_original_method = "E0C53B0ABBE8903B8C2E5235B7766B9A", hash_generated_method = "8370E68AFB78A18093B317C1427AE367")
    @DSModeled(DSC.SAFE)
    public void setLoadWithOverviewMode(boolean overview) {
        dsTaint.addTaint(overview);
        // ---------- Original Method ----------
        //mLoadWithOverviewMode = overview;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.052 -0400", hash_original_method = "0D409EAD2B46C91908C9804617827D1C", hash_generated_method = "4E90BCB6B4D27FE6F4BC1449AE10FECD")
    @DSModeled(DSC.SAFE)
    public boolean getLoadWithOverviewMode() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mLoadWithOverviewMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.053 -0400", hash_original_method = "B5CB73D3FC09526DD6AE502765086798", hash_generated_method = "0998F65195BCDE532BE42BAEED3D2D38")
    @DSModeled(DSC.SAFE)
    public void setEnableSmoothTransition(boolean enable) {
        dsTaint.addTaint(enable);
        // ---------- Original Method ----------
        //mEnableSmoothTransition = enable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.053 -0400", hash_original_method = "FB45006D48B3F1A32CF7E83242DDAE7D", hash_generated_method = "E0497F422C266DEA8BA3077BD5DF2DA9")
    @DSModeled(DSC.SAFE)
    public boolean enableSmoothTransition() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mEnableSmoothTransition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.053 -0400", hash_original_method = "6C4A8C912B988582A0E8E6FECC7FBF9C", hash_generated_method = "38C44C62AC736D0198F14A37550FB31A")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void setUseWebViewBackgroundForOverscrollBackground(boolean view) {
        dsTaint.addTaint(view);
        // ---------- Original Method ----------
        //mUseWebViewBackgroundForOverscroll = view;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.053 -0400", hash_original_method = "FE1757AAD5E1DD702744237E901A55C8", hash_generated_method = "83D98749FC642B38831E11F962DCF9AB")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public boolean getUseWebViewBackgroundForOverscrollBackground() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mUseWebViewBackgroundForOverscroll;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.053 -0400", hash_original_method = "BAE3B161CD7589698136E106A2876792", hash_generated_method = "BAD82FDEA9378C4D00A85F3325A7CE1D")
    @DSModeled(DSC.SAFE)
    public void setSaveFormData(boolean save) {
        dsTaint.addTaint(save);
        // ---------- Original Method ----------
        //mSaveFormData = save;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.053 -0400", hash_original_method = "4DFFD3713A8D682938D03E8713A587EF", hash_generated_method = "FA8502A3C1B981E6053D48DBFE20DA7C")
    @DSModeled(DSC.SAFE)
    public boolean getSaveFormData() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSaveFormData && !mPrivateBrowsingEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.054 -0400", hash_original_method = "B2DE3A754D34523602EAE606838B5563", hash_generated_method = "86E5713200B647CEE2CB886F49D9853F")
    @DSModeled(DSC.SAFE)
    public void setSavePassword(boolean save) {
        dsTaint.addTaint(save);
        // ---------- Original Method ----------
        //mSavePassword = save;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.054 -0400", hash_original_method = "7EDF9AC2E1EDCCF642364DB0CD31765F", hash_generated_method = "FDF5F97A5EC08F4EBAE3FC7E96CA011E")
    @DSModeled(DSC.SAFE)
    public boolean getSavePassword() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSavePassword;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.054 -0400", hash_original_method = "C5C41A533FE351F2D45D268D5D267050", hash_generated_method = "7383B2F277C7D7CB8457B7C13D42102D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setTextZoom(int textZoom) {
        dsTaint.addTaint(textZoom);
        {
            {
                EventLog.writeEvent(EventLogTags.BROWSER_TEXT_SIZE_CHANGE,
                        mTextSize, textZoom);
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.054 -0400", hash_original_method = "570564B346A8D968406F236CA99E37F6", hash_generated_method = "C4875AB00693A86EE7E2C2B167DCDCF8")
    @DSModeled(DSC.SAFE)
    public synchronized int getTextZoom() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTextSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.054 -0400", hash_original_method = "D3E0150ED5C00CC3B22240870480363B", hash_generated_method = "C2ED61D8544862E5AD7AA69AA2CDCC1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setTextSize(TextSize t) {
        dsTaint.addTaint(t.dsTaint);
        setTextZoom(t.value);
        // ---------- Original Method ----------
        //setTextZoom(t.value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.059 -0400", hash_original_method = "900BE61F6B80F2B5D843AC6DC18F9D15", hash_generated_method = "48B8BA27E2B2AF88F068B947B0AD699E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized TextSize getTextSize() {
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
                    smallestDelta = delta;
                    closestSize = size;
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (TextSize)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.059 -0400", hash_original_method = "E23B2F666BB6D09A8C611DD5B37D2698", hash_generated_method = "84026B947788FE617F032ADAE53EA7EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDoubleTapZoom(int doubleTapZoom) {
        dsTaint.addTaint(doubleTapZoom);
        {
            mWebView.updateDoubleTapZoom(doubleTapZoom);
        } //End block
        // ---------- Original Method ----------
        //if (mDoubleTapZoom != doubleTapZoom) {
            //mDoubleTapZoom = doubleTapZoom;
            //mWebView.updateDoubleTapZoom(doubleTapZoom);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.059 -0400", hash_original_method = "137930918FD91EA20A5F57296DD24AFB", hash_generated_method = "C7A20353EBB4D132468BF6160C7991F1")
    @DSModeled(DSC.SAFE)
    public int getDoubleTapZoom() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDoubleTapZoom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.060 -0400", hash_original_method = "E4C2219CCE12A9777A4354402A44D34B", hash_generated_method = "FE94DC9B640E0B4988124A5732AC2A8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDefaultZoom(ZoomDensity zoom) {
        dsTaint.addTaint(zoom.dsTaint);
        {
            mWebView.adjustDefaultZoomDensity(zoom.value);
        } //End block
        // ---------- Original Method ----------
        //if (mDefaultZoom != zoom) {
            //mDefaultZoom = zoom;
            //mWebView.adjustDefaultZoomDensity(zoom.value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.060 -0400", hash_original_method = "72EF0E181D832EBBD7F53BEF96096C0C", hash_generated_method = "0636D40ACA8DE091F18803A6F491D2E4")
    @DSModeled(DSC.SAFE)
    public ZoomDensity getDefaultZoom() {
        return (ZoomDensity)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mDefaultZoom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.060 -0400", hash_original_method = "DFD74C15B6ACEBABFCBAF5FDE1C7D76D", hash_generated_method = "96B3213A839FE6E91BA8B980B1D026DF")
    @DSModeled(DSC.SAFE)
    public void setLightTouchEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        // ---------- Original Method ----------
        //mLightTouchEnabled = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.060 -0400", hash_original_method = "02D840FF3CC8AE7A6DEC323EC455B33B", hash_generated_method = "62B72C68D3834827CDFBE369FCD826C5")
    @DSModeled(DSC.SAFE)
    public boolean getLightTouchEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mLightTouchEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.060 -0400", hash_original_method = "EF2600D8826AB6D5A4057F05D8E61936", hash_generated_method = "5975701F8FF94B8080448FC52066D364")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public synchronized void setUseDoubleTree(boolean use) {
        dsTaint.addTaint(use);
        // ---------- Original Method ----------
        //return;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.060 -0400", hash_original_method = "89BCC0409F823F147F01A4F485C1EC58", hash_generated_method = "4222FC24E3D0804EA01D8666C3983F4E")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public synchronized boolean getUseDoubleTree() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.061 -0400", hash_original_method = "85DE35A00A5168FE5C8491B5E07C3BBE", hash_generated_method = "1E37038FDA35B647AFB3D1D31397EA5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public synchronized void setUserAgent(int ua) {
        dsTaint.addTaint(ua);
        String uaString;
        uaString = null;
        {
            {
                boolean var4A844877AA20090242BD936E4114AAF0_261386484 = (DESKTOP_USERAGENT.equals(mUserAgent));
                {
                    uaString = DESKTOP_USERAGENT;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB0C37EBE4069C6C6D0B7D26FC6DDD7F8_1810924719 = (IPHONE_USERAGENT.equals(mUserAgent));
                {
                    uaString = IPHONE_USERAGENT;
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.061 -0400", hash_original_method = "622085E3817D576D67ED6E0D62241C79", hash_generated_method = "EF1D04AF0F91F84E750AAAF7F6B41F99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public synchronized int getUserAgent() {
        {
            boolean var0EFD68202BB0194EC352607AD3F67935_925341215 = (DESKTOP_USERAGENT.equals(mUserAgent));
            {
                boolean varB0C37EBE4069C6C6D0B7D26FC6DDD7F8_1090561215 = (IPHONE_USERAGENT.equals(mUserAgent));
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.061 -0400", hash_original_method = "6232B93EE163514DA7A8F2A20C0E8296", hash_generated_method = "35665FC81EAA7D5F4B36922ED8DE345A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setUseWideViewPort(boolean use) {
        dsTaint.addTaint(use);
        {
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mUseWideViewport != use) {
            //mUseWideViewport = use;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.061 -0400", hash_original_method = "B42FD143593B620F53C7027879473593", hash_generated_method = "58DD1A19D952D58E83533EDD73CCB135")
    @DSModeled(DSC.SAFE)
    public synchronized boolean getUseWideViewPort() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mUseWideViewport;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.061 -0400", hash_original_method = "961D9442BDC4ECD4A72AED0ECCABFF49", hash_generated_method = "03678B9F70D927873BD328A492B39A91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setSupportMultipleWindows(boolean support) {
        dsTaint.addTaint(support);
        {
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mSupportMultipleWindows != support) {
            //mSupportMultipleWindows = support;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.062 -0400", hash_original_method = "DC8997F98FC697774C788E0E9C368A15", hash_generated_method = "6FA14117985F6FCA55ADF8764A2697E1")
    @DSModeled(DSC.SAFE)
    public synchronized boolean supportMultipleWindows() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSupportMultipleWindows;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.062 -0400", hash_original_method = "CF796A65BC60375130249D0138E0D269", hash_generated_method = "4C543A3F487AF42D4DA69A8345D14E04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setLayoutAlgorithm(LayoutAlgorithm l) {
        dsTaint.addTaint(l.dsTaint);
        {
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mLayoutAlgorithm != l) {
            //mLayoutAlgorithm = l;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.062 -0400", hash_original_method = "D199B05491A7568F9921CD10D25BC54E", hash_generated_method = "4801C08D3A32F8675549FE0BDF933D77")
    @DSModeled(DSC.SAFE)
    public synchronized LayoutAlgorithm getLayoutAlgorithm() {
        return (LayoutAlgorithm)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mLayoutAlgorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.062 -0400", hash_original_method = "80141FBB7709CEF61745CB878BA8248B", hash_generated_method = "755F9113D82974C627ED91FB76BB160F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setStandardFontFamily(String font) {
        dsTaint.addTaint(font);
        {
            boolean varB128AAF7335996E86683BB90059325B1_1144202837 = (font != null && !font.equals(mStandardFontFamily));
            {
                postSync();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (font != null && !font.equals(mStandardFontFamily)) {
            //mStandardFontFamily = font;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.062 -0400", hash_original_method = "D17418EAB461A3931F0EFDEA802C4808", hash_generated_method = "246F696572D9002AF5A8DADE631363CF")
    @DSModeled(DSC.SAFE)
    public synchronized String getStandardFontFamily() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mStandardFontFamily;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.062 -0400", hash_original_method = "85832E987C30A09FD65E322D8A53532D", hash_generated_method = "43A3621741E960BE6CAFAD246D3E2B23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setFixedFontFamily(String font) {
        dsTaint.addTaint(font);
        {
            boolean var2192ACF0230C6A0784BBAB0F632C7F94_189316976 = (font != null && !font.equals(mFixedFontFamily));
            {
                postSync();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (font != null && !font.equals(mFixedFontFamily)) {
            //mFixedFontFamily = font;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.063 -0400", hash_original_method = "91A5D658AFF46E5675EE0251B0448A37", hash_generated_method = "A287ECE16F61B7580CF966B100385662")
    @DSModeled(DSC.SAFE)
    public synchronized String getFixedFontFamily() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mFixedFontFamily;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.063 -0400", hash_original_method = "5317C7E81FFF6267D702DE0B9A35C25F", hash_generated_method = "4E6D82AD4A1D1E97B5D850F264BD40BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setSansSerifFontFamily(String font) {
        dsTaint.addTaint(font);
        {
            boolean var514778F08C8455342768B3DE4B757E0E_235547069 = (font != null && !font.equals(mSansSerifFontFamily));
            {
                postSync();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (font != null && !font.equals(mSansSerifFontFamily)) {
            //mSansSerifFontFamily = font;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.063 -0400", hash_original_method = "E8B035ABC4C315E7FC00763BCE4B3101", hash_generated_method = "AE9E3EBE45A300227192BCF302D0A256")
    @DSModeled(DSC.SAFE)
    public synchronized String getSansSerifFontFamily() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSansSerifFontFamily;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.063 -0400", hash_original_method = "B0B03F3832ADF5F3F163E426E788DEB1", hash_generated_method = "2182D96632CC3112D2C5CF1D15DF4770")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setSerifFontFamily(String font) {
        dsTaint.addTaint(font);
        {
            boolean var0F2299905D79404CB9B0DCD6CDA01E81_337020685 = (font != null && !font.equals(mSerifFontFamily));
            {
                postSync();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (font != null && !font.equals(mSerifFontFamily)) {
            //mSerifFontFamily = font;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.063 -0400", hash_original_method = "AEE55B3207D2A837254BD0F18E5F431B", hash_generated_method = "EE129081021BC83ABB74AE4EB1C2C920")
    @DSModeled(DSC.SAFE)
    public synchronized String getSerifFontFamily() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSerifFontFamily;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.064 -0400", hash_original_method = "8334AD5BA97572A472DE2E88CF457E83", hash_generated_method = "CFDBA45D1EE5EAB69067511CE27F0ACC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setCursiveFontFamily(String font) {
        dsTaint.addTaint(font);
        {
            boolean var574F82A2068BB3BEAB991B434D7D7582_2051893278 = (font != null && !font.equals(mCursiveFontFamily));
            {
                postSync();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (font != null && !font.equals(mCursiveFontFamily)) {
            //mCursiveFontFamily = font;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.064 -0400", hash_original_method = "A9100EF4E222FCE0DCE66A7BF6E9785C", hash_generated_method = "2AD01693322FB65F46D6318FF1DFEBA6")
    @DSModeled(DSC.SAFE)
    public synchronized String getCursiveFontFamily() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mCursiveFontFamily;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.064 -0400", hash_original_method = "3BEE212C0CAB12BA1830E10645682B81", hash_generated_method = "740A35B5D5B998FD92541F3C1F484647")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setFantasyFontFamily(String font) {
        dsTaint.addTaint(font);
        {
            boolean varBE452F483B0D977FF74BFC8D461A34DE_1433309490 = (font != null && !font.equals(mFantasyFontFamily));
            {
                postSync();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (font != null && !font.equals(mFantasyFontFamily)) {
            //mFantasyFontFamily = font;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.064 -0400", hash_original_method = "3AB44712F248734E7DE5412E073462E0", hash_generated_method = "7216757A431F0D760CE0F13C37676D16")
    @DSModeled(DSC.SAFE)
    public synchronized String getFantasyFontFamily() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mFantasyFontFamily;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.064 -0400", hash_original_method = "5B2F36FEBD6497C3F70A8544117DF67F", hash_generated_method = "D95BDB91C7F0A77D4D5BFE3C9B989A7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setMinimumFontSize(int size) {
        dsTaint.addTaint(size);
        size = pin(size);
        {
            postSync();
        } //End block
        // ---------- Original Method ----------
        //size = pin(size);
        //if (mMinimumFontSize != size) {
            //mMinimumFontSize = size;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.065 -0400", hash_original_method = "9F0281C9F2E3CE3701E30B7BA1EEFCDC", hash_generated_method = "3768D60D69496AEC84E735B86D5A31E1")
    @DSModeled(DSC.SAFE)
    public synchronized int getMinimumFontSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMinimumFontSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.065 -0400", hash_original_method = "979D72ED8DED37C47A363976CA577A0C", hash_generated_method = "52238F1E0968985B32673C372E9360B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setMinimumLogicalFontSize(int size) {
        dsTaint.addTaint(size);
        size = pin(size);
        {
            postSync();
        } //End block
        // ---------- Original Method ----------
        //size = pin(size);
        //if (mMinimumLogicalFontSize != size) {
            //mMinimumLogicalFontSize = size;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.065 -0400", hash_original_method = "4108641CDFB7F27DEA848BE579464C88", hash_generated_method = "F6A7764F1FC0108386E47EE62088ACCA")
    @DSModeled(DSC.SAFE)
    public synchronized int getMinimumLogicalFontSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMinimumLogicalFontSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.065 -0400", hash_original_method = "F015D29DAD166EF30FCB62EA8F22BD34", hash_generated_method = "73B1282DAB95C8FA355DD9DAEFA90136")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setDefaultFontSize(int size) {
        dsTaint.addTaint(size);
        size = pin(size);
        {
            postSync();
        } //End block
        // ---------- Original Method ----------
        //size = pin(size);
        //if (mDefaultFontSize != size) {
            //mDefaultFontSize = size;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.065 -0400", hash_original_method = "DC87CC6F42B19166FD6192BC9DCDB609", hash_generated_method = "FE233D235F745B241EA376190BD47DE4")
    @DSModeled(DSC.SAFE)
    public synchronized int getDefaultFontSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDefaultFontSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.065 -0400", hash_original_method = "F38EE7285BA7C36F298A402033D20C39", hash_generated_method = "15B8027C1F7C595BC96B954F4FAFA42B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setDefaultFixedFontSize(int size) {
        dsTaint.addTaint(size);
        size = pin(size);
        {
            postSync();
        } //End block
        // ---------- Original Method ----------
        //size = pin(size);
        //if (mDefaultFixedFontSize != size) {
            //mDefaultFixedFontSize = size;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.066 -0400", hash_original_method = "32FF94F6134070C3A3BF7D6E4734C806", hash_generated_method = "5D3B238C28A1B042B48B79B8733DF05F")
    @DSModeled(DSC.SAFE)
    public synchronized int getDefaultFixedFontSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDefaultFixedFontSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.066 -0400", hash_original_method = "E6659EF50725F66F9827ED33E4CFAB21", hash_generated_method = "51C67C14FBEAFE0CD662BB53CDEE2275")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setPageCacheCapacity(int size) {
        dsTaint.addTaint(size);
        size = 0;
        size = 20;
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.066 -0400", hash_original_method = "4253364D9E80624081FA0E0F6FDC86F7", hash_generated_method = "3C91EFFABE5E7A9865A714A871B2BD17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setLoadsImagesAutomatically(boolean flag) {
        dsTaint.addTaint(flag);
        {
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mLoadsImagesAutomatically != flag) {
            //mLoadsImagesAutomatically = flag;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.066 -0400", hash_original_method = "55A6CB81C4460FAFC4A6B0D4FAE1ED88", hash_generated_method = "82A6FC338DC0248D613D3DA0D6A81F4E")
    @DSModeled(DSC.SAFE)
    public synchronized boolean getLoadsImagesAutomatically() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mLoadsImagesAutomatically;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.066 -0400", hash_original_method = "D93A9FC6AE1462BC3A72CE8E390FD0F6", hash_generated_method = "8292BCC15E8C6922D39FB8898C739746")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setBlockNetworkImage(boolean flag) {
        dsTaint.addTaint(flag);
        {
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mBlockNetworkImage != flag) {
            //mBlockNetworkImage = flag;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.067 -0400", hash_original_method = "20F3224FE4B0DC8AEBED4FF3568A3BDD", hash_generated_method = "B25D143390EACA98E9621FCD95015C40")
    @DSModeled(DSC.SAFE)
    public synchronized boolean getBlockNetworkImage() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mBlockNetworkImage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.067 -0400", hash_original_method = "244EC0C47571696247D156D16BFFBF27", hash_generated_method = "220A3CDEE10B06A038D857D5E057A08D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setBlockNetworkLoads(boolean flag) {
        dsTaint.addTaint(flag);
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.067 -0400", hash_original_method = "8F98673864D7321D7FB7DE6793DC0EC8", hash_generated_method = "4EA81D619C692F9AD79AB58A0F93D881")
    @DSModeled(DSC.SAFE)
    public synchronized boolean getBlockNetworkLoads() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mBlockNetworkLoads;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.067 -0400", hash_original_method = "4445E93EF699C8E4DE794753E49CA477", hash_generated_method = "3695856CA84065C44E4AB3DFCFE78523")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void verifyNetworkAccess() {
        {
            {
                boolean varF9F9CDB4CAE6045469577FF26B8A9439_802112062 = (mContext.checkPermission("android.permission.INTERNET",
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.067 -0400", hash_original_method = "0BBFCDC224ADE5D71512B3B9C5FED4DC", hash_generated_method = "3251604A5E7B4C100C12971BC70B1DD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setJavaScriptEnabled(boolean flag) {
        dsTaint.addTaint(flag);
        {
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mJavaScriptEnabled != flag) {
            //mJavaScriptEnabled = flag;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.068 -0400", hash_original_method = "8A9F66ACB83E46F66732CB0783F8BD97", hash_generated_method = "07DBC3D4BD079302B5A93EFAA64EA652")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setHardwareAccelSkiaEnabled(boolean flag) {
        dsTaint.addTaint(flag);
        {
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mHardwareAccelSkia != flag) {
            //mHardwareAccelSkia = flag;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.068 -0400", hash_original_method = "B41E73346B4841FDA1F28A35C0158347", hash_generated_method = "E1A26ED93E239D0F54A5E60CB93700C3")
    @DSModeled(DSC.SAFE)
    public synchronized boolean getHardwareAccelSkiaEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mHardwareAccelSkia;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.068 -0400", hash_original_method = "69FE03F7A269EF1D16FCCD39ECE7D049", hash_generated_method = "69F01EB7819737BD60E128021670EBA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setShowVisualIndicator(boolean flag) {
        dsTaint.addTaint(flag);
        {
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mShowVisualIndicator != flag) {
            //mShowVisualIndicator = flag;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.068 -0400", hash_original_method = "C63472D12B908062A1CEAE79E75779C9", hash_generated_method = "FFFF8EF8A7860AA6DCB56EBD23936283")
    @DSModeled(DSC.SAFE)
    public synchronized boolean getShowVisualIndicator() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mShowVisualIndicator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.068 -0400", hash_original_method = "05BB2A888D33554F620DCC4B01FA7575", hash_generated_method = "3908E07630035937ACF63C783A1EF9CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public synchronized void setPluginsEnabled(boolean flag) {
        dsTaint.addTaint(flag);
        setPluginState(flag ? PluginState.ON : PluginState.OFF);
        // ---------- Original Method ----------
        //setPluginState(flag ? PluginState.ON : PluginState.OFF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.068 -0400", hash_original_method = "DB94ACE3494108D6193A811AD96FC597", hash_generated_method = "7FBA4E26B51BC1B62B4C5C4FDDA2C730")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setPluginState(PluginState state) {
        dsTaint.addTaint(state.dsTaint);
        {
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mPluginState != state) {
            //mPluginState = state;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.069 -0400", hash_original_method = "773787F5C9956C3834DA2A6EB4286614", hash_generated_method = "82EB520FCBE55BC65B23BFE82BB27595")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public synchronized void setPluginsPath(String pluginsPath) {
        dsTaint.addTaint(pluginsPath);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.069 -0400", hash_original_method = "AF758F2CA723722CB4C8BF68969FC2D2", hash_generated_method = "5DD3ADD77D42D23DD30AC6F7DF0D571E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setDatabasePath(String databasePath) {
        dsTaint.addTaint(databasePath);
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.069 -0400", hash_original_method = "BC0F324C7AC101E200A0E358BDBC7AB1", hash_generated_method = "5C550141C87616B98871399DC3F6D44E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setGeolocationDatabasePath(String databasePath) {
        dsTaint.addTaint(databasePath);
        {
            boolean var104A4F548659CD09E1488BC6740CE5B2_541333378 = (databasePath != null
                && !databasePath.equals(mGeolocationDatabasePath));
            {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.069 -0400", hash_original_method = "F95CC1B9D2327BC5BCD822D16CE23DEA", hash_generated_method = "0E8242A7C199DDCB3F20D26015E453A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setAppCacheEnabled(boolean flag) {
        dsTaint.addTaint(flag);
        {
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mAppCacheEnabled != flag) {
            //mAppCacheEnabled = flag;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.069 -0400", hash_original_method = "C7AB159C419EE425C63EEE7B4C162DEF", hash_generated_method = "B84D8F09BAB5EDF233499F57484545CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setAppCachePath(String appCachePath) {
        dsTaint.addTaint(appCachePath);
        {
            boolean var42DDAC661D71068414BF42654B143F02_1812200485 = (appCachePath != null && !appCachePath.equals(mAppCachePath));
            {
                postSync();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (appCachePath != null && !appCachePath.equals(mAppCachePath)) {
            //mAppCachePath = appCachePath;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.070 -0400", hash_original_method = "55D93840C546554373F35F660C5755AC", hash_generated_method = "E58B771C85F58210EAEF36ACA05BEBB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setAppCacheMaxSize(long appCacheMaxSize) {
        dsTaint.addTaint(appCacheMaxSize);
        {
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (appCacheMaxSize != mAppCacheMaxSize) {
            //mAppCacheMaxSize = appCacheMaxSize;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.070 -0400", hash_original_method = "869B3AB9767C9688E84644FF6FE71246", hash_generated_method = "90AE424BCE35E18DEF167A4BD1253B59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setDatabaseEnabled(boolean flag) {
        dsTaint.addTaint(flag);
        {
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mDatabaseEnabled != flag) {
           //mDatabaseEnabled = flag;
           //postSync();
       //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.070 -0400", hash_original_method = "1833A47C66872FD150B68FE6759B0625", hash_generated_method = "C535FE6F18EA869ECD42150B734768AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setDomStorageEnabled(boolean flag) {
        dsTaint.addTaint(flag);
        {
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mDomStorageEnabled != flag) {
           //mDomStorageEnabled = flag;
           //postSync();
       //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.070 -0400", hash_original_method = "F0262AC32F151E97C7BD7687A4F30118", hash_generated_method = "A1341F2B0732BD5FCA56CFAC70060A73")
    @DSModeled(DSC.SAFE)
    public synchronized boolean getDomStorageEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDomStorageEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.070 -0400", hash_original_method = "B06914FF8620CDD00A7D2E76B4DC9F8E", hash_generated_method = "4B63EA3D01C400EDDF98B97E1F24237D")
    @DSModeled(DSC.SAFE)
    public synchronized String getDatabasePath() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mDatabasePath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.071 -0400", hash_original_method = "B3A6EABACA6DB5DAD1BC523D1F7D938A", hash_generated_method = "111E0C761DD1F9BB09C7F4F9F9234610")
    @DSModeled(DSC.SAFE)
    public synchronized boolean getDatabaseEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDatabaseEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.071 -0400", hash_original_method = "5C3A0FF2F7925F672A8F3BF470C8C1B9", hash_generated_method = "FF9029592B4616FCF83466ADC6C04737")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setWorkersEnabled(boolean flag) {
        dsTaint.addTaint(flag);
        {
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mWorkersEnabled != flag) {
            //mWorkersEnabled = flag;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.071 -0400", hash_original_method = "1B37EF49E1DD23D92EBFCAE289865E03", hash_generated_method = "42411E2067A2527BECD71D8E88D3C6E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setGeolocationEnabled(boolean flag) {
        dsTaint.addTaint(flag);
        {
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mGeolocationEnabled != flag) {
            //mGeolocationEnabled = flag;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.071 -0400", hash_original_method = "ED4873F24C9B96C88ADEA94C6CEBF439", hash_generated_method = "9951C710A5E12B68B4C3F767C38BDCDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setXSSAuditorEnabled(boolean flag) {
        dsTaint.addTaint(flag);
        {
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mXSSAuditorEnabled != flag) {
            //mXSSAuditorEnabled = flag;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.071 -0400", hash_original_method = "0DFFCBD94870E084A8277321728F548A", hash_generated_method = "5C984ED32C947C7B184A309051E945A2")
    @DSModeled(DSC.SAFE)
    public synchronized boolean getJavaScriptEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mJavaScriptEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.071 -0400", hash_original_method = "71CDB5FC63B182B87115D2DBE9F21219", hash_generated_method = "96DDB56A3010C0C4973EE6FEFBA534CE")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public synchronized boolean getPluginsEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mPluginState == PluginState.ON;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.072 -0400", hash_original_method = "F64B7B770EF5DD5F7B0D7EE789561CF2", hash_generated_method = "D74A0846939BD3521A7F0802C4138A36")
    @DSModeled(DSC.SAFE)
    public synchronized PluginState getPluginState() {
        return (PluginState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mPluginState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.072 -0400", hash_original_method = "9447E36E214BB4441498CEE16910C171", hash_generated_method = "174F37203F076575EC336AE6B5918C50")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public synchronized String getPluginsPath() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.072 -0400", hash_original_method = "4CDCF2B2AC7A9689B491AFCE4B80F0EB", hash_generated_method = "BD7A378AEA68FFF8576698808D0B1950")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setJavaScriptCanOpenWindowsAutomatically(
            boolean flag) {
        dsTaint.addTaint(flag);
        {
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mJavaScriptCanOpenWindowsAutomatically != flag) {
            //mJavaScriptCanOpenWindowsAutomatically = flag;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.073 -0400", hash_original_method = "79E98D32B2FE915E7B4CD55D0B1C896F", hash_generated_method = "0E70516C386ABC9508700F8137B29324")
    @DSModeled(DSC.SAFE)
    public synchronized boolean getJavaScriptCanOpenWindowsAutomatically() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mJavaScriptCanOpenWindowsAutomatically;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.074 -0400", hash_original_method = "A24B805E1ED21576385EF437050E004D", hash_generated_method = "DB144745FEADEEC52D7F22918DB2ACCC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setDefaultTextEncodingName(String encoding) {
        dsTaint.addTaint(encoding);
        {
            boolean var817A81EF6D982E87FA14412EF57E190A_1700400964 = (encoding != null && !encoding.equals(mDefaultTextEncoding));
            {
                postSync();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (encoding != null && !encoding.equals(mDefaultTextEncoding)) {
            //mDefaultTextEncoding = encoding;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.074 -0400", hash_original_method = "C5F48A0B5AD67EA38BD640610E4387AC", hash_generated_method = "503B835865E69FA38DE9F56686188EEB")
    @DSModeled(DSC.SAFE)
    public synchronized String getDefaultTextEncodingName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mDefaultTextEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.074 -0400", hash_original_method = "EF76B53D37FAD17B99E355E5158D3AE3", hash_generated_method = "FE6A509010C44F3B2F061A97748B789B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setUserAgentString(String ua) {
        dsTaint.addTaint(ua);
        {
            boolean varF3C0DB8E14A6F2373A8E52D464BF926D_853706775 = (ua == null || ua.length() == 0);
            {
                {
                    Locale currentLocale;
                    currentLocale = Locale.getDefault();
                    {
                        boolean var192A18582AA5B1AF80348915B981AF01_1921223348 = (!sLocale.equals(currentLocale));
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
            boolean varCC809D313AE67B9E066A335FB0E09C4F_2107632510 = (!ua.equals(mUserAgent));
            {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.074 -0400", hash_original_method = "2522780DB5B181D072BE72836FEE2179", hash_generated_method = "9D717AA80EA19E05E754E70C545467B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized String getUserAgentString() {
        {
            boolean var5E27F088CD27294C3C475917A7A3FE4F_1717517483 = (DESKTOP_USERAGENT.equals(mUserAgent) ||
                IPHONE_USERAGENT.equals(mUserAgent) ||
                !mUseDefaultUserAgent);
        } //End collapsed parenthetic
        boolean doPostSync;
        doPostSync = false;
        {
            Locale currentLocale;
            currentLocale = Locale.getDefault();
            {
                boolean var999D054DAE77F62E7C9FEEBDA5E27DE4_1181899324 = (!sLocale.equals(currentLocale));
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
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.075 -0400", hash_original_method = "D20FFE724413B630D767FC3330D85D9B", hash_generated_method = "2BDA391C208FB6C329BD19A9BF98D88D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized String getAcceptLanguage() {
        {
            Locale currentLocale;
            currentLocale = Locale.getDefault();
            {
                boolean var999D054DAE77F62E7C9FEEBDA5E27DE4_161736119 = (!sLocale.equals(currentLocale));
                {
                    sLocale = currentLocale;
                    mAcceptLanguage = getCurrentAcceptLanguage();
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.075 -0400", hash_original_method = "1949FADEB987BBB9FFD42544F3D5731B", hash_generated_method = "2B81ACA44A2172A07537B9E0CF1F5F5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isNarrowColumnLayout() {
        boolean var3FA54FC670124C41C60DD50803A1AE27_1192628197 = (getLayoutAlgorithm() == LayoutAlgorithm.NARROW_COLUMNS);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getLayoutAlgorithm() == LayoutAlgorithm.NARROW_COLUMNS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.075 -0400", hash_original_method = "0197ABD852A904C83B0994DA40EDDF11", hash_generated_method = "AB81041BBCCA47D65A3DABCC3ED0DDF0")
    @DSModeled(DSC.SAFE)
    public void setNeedInitialFocus(boolean flag) {
        dsTaint.addTaint(flag);
        // ---------- Original Method ----------
        //if (mNeedInitialFocus != flag) {
            //mNeedInitialFocus = flag;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.075 -0400", hash_original_method = "D1C04B216D0AC5093D2F075C6698B7EE", hash_generated_method = "B694BB65CA7D6F7114AB62F7BA48F6B1")
    @DSModeled(DSC.SAFE)
     boolean getNeedInitialFocus() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mNeedInitialFocus;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.075 -0400", hash_original_method = "ADE96AEA7507FA885C654AF6A7AF6825", hash_generated_method = "C4329A63CFA9862B68CB82CD517C4D39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setRenderPriority(RenderPriority priority) {
        dsTaint.addTaint(priority.dsTaint);
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.076 -0400", hash_original_method = "C16F91A0BF5BCFC94071B85F47E4B2E9", hash_generated_method = "3752E0620E8F4E83C1753245C7E97CDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCacheMode(int mode) {
        dsTaint.addTaint(mode);
        {
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mode != mOverrideCacheMode) {
            //mOverrideCacheMode = mode;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.076 -0400", hash_original_method = "4A960A8ACA504F48F41DB237F9209DA9", hash_generated_method = "DDB5139C1E7A7700C890E64F1560223C")
    @DSModeled(DSC.SAFE)
    public int getCacheMode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mOverrideCacheMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.076 -0400", hash_original_method = "9F8C026B57F7FDFD26FE193DA8C87BB6", hash_generated_method = "EB2AD18811D5CD9A53687F55ECDA091D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setShrinksStandaloneImagesToFit(boolean shrink) {
        dsTaint.addTaint(shrink);
        {
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mShrinksStandaloneImagesToFit != shrink) {
            //mShrinksStandaloneImagesToFit = shrink;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.076 -0400", hash_original_method = "041EEBDF0CC6DB4D857EE5FE00439A69", hash_generated_method = "E22CA5C244AEEB9AD126B6C11B730C26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMaximumDecodedImageSize(long size) {
        dsTaint.addTaint(size);
        {
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mMaximumDecodedImageSize != size) {
            //mMaximumDecodedImageSize = size;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.076 -0400", hash_original_method = "37CD2CB6E6E70B184FA7FDB5F22FF522", hash_generated_method = "77948DE7070F9DF3EA089A716F56EBBB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean getUseFixedViewport() {
        boolean var1C7F87D513600327D8EDE7818B64C140_772029396 = (getUseWideViewPort());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getUseWideViewPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.076 -0400", hash_original_method = "F442F079E2DD19439C88D9FB5E3A709B", hash_generated_method = "BBD7CE3AA341AB790E7EE8F546F76F13")
    @DSModeled(DSC.SAFE)
     boolean isPrivateBrowsingEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mPrivateBrowsingEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.077 -0400", hash_original_method = "34042B5DCA297E4EBEB0CC9227844924", hash_generated_method = "2E745BD528AB94DDA8006BF32524F157")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void setPrivateBrowsingEnabled(boolean flag) {
        dsTaint.addTaint(flag);
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.077 -0400", hash_original_method = "9C2B0A9C4AD9BDB94288AB167718CCA9", hash_generated_method = "E3E7836CC14E08FBFD841B2C2489BE10")
    @DSModeled(DSC.SAFE)
    public boolean forceUserScalable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mForceUserScalable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.077 -0400", hash_original_method = "1D6F9D93B2A4A93CBF13AD0469B99A04", hash_generated_method = "BB761310065F4C906008FBF07F587118")
    @DSModeled(DSC.SAFE)
    public synchronized void setForceUserScalable(boolean flag) {
        dsTaint.addTaint(flag);
        // ---------- Original Method ----------
        //mForceUserScalable = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.077 -0400", hash_original_method = "5D9DAFAFBF77CCE3ED840C406B6898AF", hash_generated_method = "3DD88E4C334E049ABF44F5E76C486D58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void setSyntheticLinksEnabled(boolean flag) {
        dsTaint.addTaint(flag);
        {
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mSyntheticLinksEnabled != flag) {
            //mSyntheticLinksEnabled = flag;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.077 -0400", hash_original_method = "1A8C919F0F6505492DC614E84115DF0C", hash_generated_method = "B4DA531901CD263831DDAF71CAB1D76F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setAutoFillEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        boolean autoFillEnabled;
        autoFillEnabled = enabled && !mPrivateBrowsingEnabled;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.077 -0400", hash_original_method = "8774A835D2148EBC629E39CB3DCAFA63", hash_generated_method = "469C5AC3E62F03FC33F745390A00C965")
    @DSModeled(DSC.SAFE)
    public synchronized boolean getAutoFillEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAutoFillEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.078 -0400", hash_original_method = "3148173678A0F0377520D6B2C8079A70", hash_generated_method = "96BB8F79769EB0D84F19FB406A2B11FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setAutoFillProfile(AutoFillProfile profile) {
        dsTaint.addTaint(profile.dsTaint);
        {
            postSync();
        } //End block
        // ---------- Original Method ----------
        //if (mAutoFillProfile != profile) {
            //mAutoFillProfile = profile;
            //postSync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.078 -0400", hash_original_method = "40495DA1FFE9EC3467407968672CDCF7", hash_generated_method = "AFC3CC9E429DDB87E32E373143DA4D6E")
    @DSModeled(DSC.SAFE)
    public synchronized AutoFillProfile getAutoFillProfile() {
        return (AutoFillProfile)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAutoFillProfile;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.078 -0400", hash_original_method = "C3E1D2408E91E83D6659CE445CE89780", hash_generated_method = "D3FECAA86A238298D08AD3EAA2074BB7")
    @DSModeled(DSC.SAFE)
     int getDoubleTapToastCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDoubleTapToastCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.078 -0400", hash_original_method = "3B766C36F75F383AEAB183DB6ECCA431", hash_generated_method = "4FAD4D2C533407CBEB5FF7F6B3ACC63D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setDoubleTapToastCount(int count) {
        dsTaint.addTaint(count);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.078 -0400", hash_original_method = "51A1E424E5F24F0C6AF042B09286C12C", hash_generated_method = "672C4E79E23F6952A04E5385735D600A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setProperty(String key, String value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        {
            boolean varB1AAD98259CD767817D0F1151B8AA0DE_360903355 = (mWebView.nativeSetProperty(key, value));
            {
                mWebView.contentInvalidateAll();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mWebView.nativeSetProperty(key, value)) {
            //mWebView.contentInvalidateAll();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.078 -0400", hash_original_method = "E79B730EE57AB5AA3332F72B80B24914", hash_generated_method = "4FC2E7F929A0F8F82ABC8A82ED34D184")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getProperty(String key) {
        dsTaint.addTaint(key);
        String var413B71B7F2FAA007143655BAC2367D1E_2005339626 = (mWebView.nativeGetProperty(key));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mWebView.nativeGetProperty(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.079 -0400", hash_original_method = "B2134E4964C5B0957E3BC21A40B5447F", hash_generated_method = "32CD9CB1AFB5DD2964E294AE41E633D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void syncSettingsAndCreateHandler(BrowserFrame frame) {
        dsTaint.addTaint(frame.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.079 -0400", hash_original_method = "97F607FA924E3FA8AA008A1519BCA623", hash_generated_method = "B8CB642682401D5017A0F8BB624FB20A")
    @DSModeled(DSC.SAFE)
    synchronized void onDestroyed() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.079 -0400", hash_original_method = "32C980BFA3F312B2745A36CC144BD5C9", hash_generated_method = "F2526F64BA4FA29147A496009DA940D6")
    @DSModeled(DSC.SAFE)
    private int pin(int size) {
        dsTaint.addTaint(size);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (size < 1) {
            //return 1;
        //} else if (size > 72) {
            //return 72;
        //}
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.079 -0400", hash_original_method = "028ACD01F22F62E6B019AFF3AD2AE2F1", hash_generated_method = "1FE65182E5086CFB9E39F761AEB0FBDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.080 -0400", hash_original_method = "B9A4DA2D5B0DA0061612E5CC599DFA25", hash_generated_method = "2AF61E91BD9DA0540B97E0C070C97241")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSync(int nativeFrame) {
        dsTaint.addTaint(nativeFrame);
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
        private int mUniqueId;
        private String mFullName;
        private String mEmailAddress;
        private String mCompanyName;
        private String mAddressLine1;
        private String mAddressLine2;
        private String mCity;
        private String mState;
        private String mZipCode;
        private String mCountry;
        private String mPhoneNumber;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.080 -0400", hash_original_method = "356718E28156E1213C1513B4F67A401A", hash_generated_method = "266F9F61897BE958085A5EB7FAE24913")
        @DSModeled(DSC.SAFE)
        public AutoFillProfile(int uniqueId, String fullName, String email,
                String companyName, String addressLine1, String addressLine2,
                String city, String state, String zipCode, String country,
                String phoneNumber) {
            dsTaint.addTaint(phoneNumber);
            dsTaint.addTaint(email);
            dsTaint.addTaint(zipCode);
            dsTaint.addTaint(state);
            dsTaint.addTaint(fullName);
            dsTaint.addTaint(companyName);
            dsTaint.addTaint(addressLine2);
            dsTaint.addTaint(addressLine1);
            dsTaint.addTaint(country);
            dsTaint.addTaint(city);
            dsTaint.addTaint(uniqueId);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.080 -0400", hash_original_method = "F64F21D16CFD05D4B80E501A354D44C1", hash_generated_method = "5195FCFDC3A7438D302496C40D70BD0F")
        @DSModeled(DSC.SAFE)
        public int getUniqueId() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mUniqueId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.080 -0400", hash_original_method = "1443687462A2902C11BD4613CE447F4A", hash_generated_method = "46553307EA5BBE7D9EB8C06D7876DCC1")
        @DSModeled(DSC.SAFE)
        public String getFullName() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mFullName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.080 -0400", hash_original_method = "F1CEF297E349972E689A87BC52C1313A", hash_generated_method = "0FE07257548772251D0434483DF9BF7D")
        @DSModeled(DSC.SAFE)
        public String getEmailAddress() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mEmailAddress;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.081 -0400", hash_original_method = "52206539E751E4CCE5415670F9F725D8", hash_generated_method = "4DF59C32979088586C2F12FDEF0F563E")
        @DSModeled(DSC.SAFE)
        public String getCompanyName() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mCompanyName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.081 -0400", hash_original_method = "C545FDC49346DC5A5D71F5AD1D1BEF53", hash_generated_method = "025A62E731B1B0463CC3C944FEC486BB")
        @DSModeled(DSC.SAFE)
        public String getAddressLine1() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mAddressLine1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.081 -0400", hash_original_method = "F55EC6B8A39F598BB4DCA9E4A078AA07", hash_generated_method = "9275983F6F6CB889FADFB1D557870667")
        @DSModeled(DSC.SAFE)
        public String getAddressLine2() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mAddressLine2;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.081 -0400", hash_original_method = "B85B96BC49C3B97C84AB4B17868CBD9D", hash_generated_method = "7BC9680F70399A0C21E4FBC92F475FFD")
        @DSModeled(DSC.SAFE)
        public String getCity() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mCity;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.081 -0400", hash_original_method = "E347213115686AEA23D455AF8267D98C", hash_generated_method = "2A857BBFD5FEF99AE21D3CAF5E4CBECC")
        @DSModeled(DSC.SAFE)
        public String getState() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mState;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.081 -0400", hash_original_method = "07A544AD716F805F393CD2D204A5CDEF", hash_generated_method = "3800AF1A308230F7DD97C3DBB87EE832")
        @DSModeled(DSC.SAFE)
        public String getZipCode() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mZipCode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.081 -0400", hash_original_method = "F3511327404A79B77D5BB05807C0214B", hash_generated_method = "314B99F40CEC70E8BD1381C51C2C2B22")
        @DSModeled(DSC.SAFE)
        public String getCountry() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mCountry;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.082 -0400", hash_original_method = "6EFA8840ED98073D74C9222B8B96940F", hash_generated_method = "E00A864AA26291278E10C8FE09028484")
        @DSModeled(DSC.SAFE)
        public String getPhoneNumber() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mPhoneNumber;
        }

        
    }


    
    private class EventHandler {
        private Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.082 -0400", hash_original_method = "A6B283281D2E30FEC9C27B06A0776A9C", hash_generated_method = "A6B283281D2E30FEC9C27B06A0776A9C")
                public EventHandler ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.083 -0400", hash_original_method = "5DB82DF3D22DC31DB9F8A52C18B58140", hash_generated_method = "2639214B30A414BB89CB90D251BA2072")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private synchronized void createHandler() {
            setRenderPriority();
            mHandler = new Handler() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.082 -0400", hash_original_method = "98DDA7B8BD7D5D00B914EDDF76F7BBE2", hash_generated_method = "3BE0A413775069005145503E4639127B")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public void handleMessage(Message msg) {
                    dsTaint.addTaint(msg.dsTaint);
                    //Begin case SYNC 
                    {
                        Object var99811B65C4AE735A679EC9FB9B6A43C5_901353565 = (WebSettings.this);
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
                    // ---------- Original Method ----------
                    // Original Method Too Long, Refer to Original Implementation
                }
};
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.083 -0400", hash_original_method = "C47047917EAD94E1F72D1853ABF9CDB1", hash_generated_method = "100D432E9EF07108717CF9BC612EAD69")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void setRenderPriority() {
            {
                Object var795E9C1B680F5750A86392043AD4E199_870052370 = (WebSettings.this);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.083 -0400", hash_original_method = "AA202573A133FD4C93192532FFFE560D", hash_generated_method = "0CB369641F02963DDC481DF5AA29B981")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private synchronized boolean sendMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            {
                mHandler.sendMessage(msg);
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (mHandler != null) {
                //mHandler.sendMessage(msg);
                //return true;
            //} else {
                //return false;
            //}
        }

        
        static final int SYNC = 0;
        static final int PRIORITY = 1;
        static final int SET_DOUBLE_TAP_TOAST_COUNT = 2;
    }


    
    public static final int LOAD_DEFAULT = -1;
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_NO_CACHE = 2;
    public static final int LOAD_CACHE_ONLY = 3;
    private static final String PREVIOUS_VERSION = "3.1";
    static private int      mDoubleTapToastCount = 3;
    private static final String PREF_FILE = "WebViewSettings";
    private static final String DOUBLE_TAP_TOAST_COUNT = "double_tap_toast_count";
    private static final String DESKTOP_USERAGENT = "Mozilla/5.0 (X11; " +
        "Linux x86_64) AppleWebKit/534.24 (KHTML, like Gecko) " +
        "Chrome/11.0.696.34 Safari/534.24";
    private static final String IPHONE_USERAGENT =
            "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_0 like Mac OS X; en-us)"
            + " AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0"
            + " Mobile/7A341 Safari/528.16";
    private static Locale sLocale;
    private static Object sLockForLocaleSettings;
    private static final String ACCEPT_LANG_FOR_US_LOCALE = "en-US";
}

