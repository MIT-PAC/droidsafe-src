package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.app.ActionBarImpl;
import com.android.internal.policy.PolicyManager;
import android.content.ComponentCallbacks2;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.CursorLoader;
import android.content.IIntentSender;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.Resources.Theme;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.StrictMode;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.TextKeyListener;
import android.util.AttributeSet;
import android.util.EventLog;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManagerImpl;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewManager;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AdapterView;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Activity extends ContextThemeWrapper implements LayoutInflater.Factory2, Window.Callback, KeyEvent.Callback, OnCreateContextMenuListener, ComponentCallbacks2 {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.111 -0400", hash_original_field = "69994B385C8EE3CB1FC89C139F80EE2C", hash_generated_field = "D7ACA1EA4615702CAE0E6513097C1B9D")

    private SparseArray<ManagedDialog> mManagedDialogs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.112 -0400", hash_original_field = "E062CE48CD3AFCDDC19DD9FCF2E119D4", hash_generated_field = "B2267B39A1EB39D35FC793A28FB486AB")

    private Instrumentation mInstrumentation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.113 -0400", hash_original_field = "98E8D2ECD335C543A384E2B940159AF2", hash_generated_field = "48FA2AB88D7976975EE44F222013EB79")

    private IBinder mToken;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.114 -0400", hash_original_field = "9ECD332EA0315F97A6C2A47F0DFCF2CA", hash_generated_field = "1C52ADC6FAC22BA15FC5CB45EFB9C704")

    private int mIdent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.114 -0400", hash_original_field = "1F8EA74468A18EB8C9F4629DC88D43D9", hash_generated_field = "A96A287BB650BF201DDA299E34737419")

    String mEmbeddedID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.115 -0400", hash_original_field = "6B35E9B21496C1A77A324DB1577A6395", hash_generated_field = "53FA3553B85F7414D1C5F2C302FDEBF9")

    private Application mApplication;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.115 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "1811495D939DB843870F6315E04555CC")

    Intent mIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.115 -0400", hash_original_field = "C0386E973BB6E008B1720A8BB4936F69", hash_generated_field = "1B40E7C57A0B1682389BAE16521C0844")

    private ComponentName mComponent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.116 -0400", hash_original_field = "4BA355497E3293EF79CEB324C2759EC3", hash_generated_field = "C71CEE98D7B6D75F61EDC7C7807C69E4")

    ActivityInfo mActivityInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.116 -0400", hash_original_field = "46FDB2388003D2F8D58B7436C6E7B099", hash_generated_field = "DAA5CF027F30E341CB6E5B438E9919B8")

    ActivityThread mMainThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.116 -0400", hash_original_field = "08DEDF480C56042390504EEB5F2B5C59", hash_generated_field = "CD55C80FF47FF655766F475F33319B07")

    Activity mParent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.117 -0400", hash_original_field = "8F73DC27B0DCA8E7133AEF9B7DBDC6C6", hash_generated_field = "6971FF9C6126C288092CCC2A5964E550")

    boolean mCalled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.117 -0400", hash_original_field = "E2FDF9701AF8C008E54F63B95BC75C79", hash_generated_field = "93A369593E1CC22C7DE8D4D5C675B065")

    boolean mCheckedForLoaderManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.117 -0400", hash_original_field = "7B94EB60C9B740E67FF099B167511F7B", hash_generated_field = "D357ECA56BF47F1751443279339D50DF")

    boolean mLoadersStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.118 -0400", hash_original_field = "9933B84C738DC45A33F44AE2EFCBD30F", hash_generated_field = "23D2434AD22548E124B62AB7739838E9")

    boolean mResumed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.118 -0400", hash_original_field = "33AF93F952A554412842C66D48683981", hash_generated_field = "7A3A2F4FBB99BD4528DF7EC8A1065318")

    private boolean mStopped;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.118 -0400", hash_original_field = "BB077E6B2FCDFA3F0EF71EB099A18F49", hash_generated_field = "10598AB9B4F301B505526794EAE9EAF0")

    boolean mFinished;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.119 -0400", hash_original_field = "D6CAA0132EF985A9C48E94EF5C72A353", hash_generated_field = "4271970B01F3FE84D04BB6304D70A20E")

    boolean mStartedActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.119 -0400", hash_original_field = "DD793F13DDAF2B567A8C331E578AA5A1", hash_generated_field = "E2F9380D6A364C95010BE19858A38D28")

    boolean mTemporaryPause = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.119 -0400", hash_original_field = "9D9C29E34F0ED4F978EFE00DFB6384BA", hash_generated_field = "D9F8EBFD0B8B6BCDE3A24A3C3A2D769A")

    boolean mChangingConfigurations = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.120 -0400", hash_original_field = "C276475150FAB89E9C0772A14D5411EF", hash_generated_field = "8737FBBAA51F2079A35CA72C17030BD1")

    int mConfigChangeFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.120 -0400", hash_original_field = "49D0F54F6F251B7A443EE498C968E7F0", hash_generated_field = "C5BC4D87F668E7C84F089BDA831D492B")

    Configuration mCurrentConfig;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.120 -0400", hash_original_field = "32BBEFAC8E5B50979F727CF657FBCDC5", hash_generated_field = "EC37B561700692089320F9D5E535EAC6")

    private SearchManager mSearchManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.121 -0400", hash_original_field = "EC6D3DC1F9EEB509CBA3527543E491C5", hash_generated_field = "53E9FC1E44FE670BE318B42372895069")

    private MenuInflater mMenuInflater;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.121 -0400", hash_original_field = "A330FB67942A8EBA9AA052BF6E9BD824", hash_generated_field = "103BD895478A6A40124D791931151EE2")

    NonConfigurationInstances mLastNonConfigurationInstances;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.122 -0400", hash_original_field = "F4214BE1FFE044F8CA79EEDDDED72016", hash_generated_field = "C669AC20EF93035981B8D3BE2898892F")

    private Window mWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.122 -0400", hash_original_field = "306519E50E3A91B9733D09F5D8EB985C", hash_generated_field = "3C750A4AE06B71AF3A05B7797C7182A4")

    private WindowManager mWindowManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.123 -0400", hash_original_field = "51828538BFE4CBE4B66B359B3F441676", hash_generated_field = "E1BBD6179BBAC61DB86866A787E8F58C")

    View mDecor = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.126 -0400", hash_original_field = "D04D49A04B1C9F713DA6373581960A20", hash_generated_field = "55C28C3FE3EA0FDA8C94FC41EC701FCC")

    boolean mWindowAdded = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.127 -0400", hash_original_field = "F4264B08F586521DD9D9932CF43D3E98", hash_generated_field = "8DFFFB221D63F9E9F2CE49B7477D9272")

    boolean mVisibleFromServer = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.127 -0400", hash_original_field = "A0B583B0E04E9DAD985B75BE1B4455FB", hash_generated_field = "5F61707B4AC1003B88348BA722FB1276")

    boolean mVisibleFromClient = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.132 -0400", hash_original_field = "E174CF32536D070CADCB31C79B6A2A6D", hash_generated_field = "1CE82A6BEC35E312C3A47BC38BD7B9BC")

    ActionBarImpl mActionBar = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.133 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.136 -0400", hash_original_field = "31044357223C0CBA3321867ECA01F93C", hash_generated_field = "CF4E9C052F96C3E80581AE8AF634872B")

    private int mTitleColor = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.137 -0400", hash_original_field = "9E9F5C9A2D303AC76B37DDF504A5EF92", hash_generated_field = "694874072698409F6608B46B5D5A3DE1")

    final FragmentManagerImpl mFragments = new FragmentManagerImpl();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.138 -0400", hash_original_field = "C3FC98EBFA953A5BA9BDADB9981A948A", hash_generated_field = "207A321ED3571899F1F73399691FB216")

    SparseArray<LoaderManagerImpl> mAllLoaderManagers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.138 -0400", hash_original_field = "780418B081227A51BFCB9EC0223B15ED", hash_generated_field = "6EE478DF5473556475C8D09C185A01BC")

    LoaderManagerImpl mLoaderManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.139 -0400", hash_original_field = "4FADE50651FFFEF0B3EB84F52D784589", hash_generated_field = "055EFA91DED96C0A7FAE40D00A04351C")

    private final ArrayList<ManagedCursor> mManagedCursors = new ArrayList<ManagedCursor>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.139 -0400", hash_original_field = "E342FEFA537FF05142CD9015EE3A0E7D", hash_generated_field = "2FA7D874AF2386F63CF856FBF24A7710")

    int mResultCode = RESULT_CANCELED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.140 -0400", hash_original_field = "1096C650F15AC7BAC99BEA828E92A3B2", hash_generated_field = "33B7C8CE0002446D9B0EE0274776A0A9")

    Intent mResultData = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.140 -0400", hash_original_field = "4F715D0874F4F1364B7BFCBD6E8E0F0A", hash_generated_field = "AB8AC56D76B8BEA00FC5296846330527")

    private boolean mTitleReady = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.140 -0400", hash_original_field = "E63F81EBF009861E6158D6EBEF422559", hash_generated_field = "B2DD3A4B48EBE858054417FEDBBD4E9F")

    private int mDefaultKeyMode = DEFAULT_KEYS_DISABLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.141 -0400", hash_original_field = "56ABC0D9D60C4A18066C25A91AA319BA", hash_generated_field = "2B1292D0EBD0751B84B1BAFF83080A8F")

    private SpannableStringBuilder mDefaultKeySsb = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.141 -0400", hash_original_field = "EA2540686B911BB0954AF2AA78EF465E", hash_generated_field = "67CC4174E7EA3B2C8F47C97894D850FA")

    private final Object mInstanceTracker = StrictMode.trackActivity(this);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.142 -0400", hash_original_field = "C5D62B7C4F8BE6B828DA51239EC692E0", hash_generated_field = "A94051227A36AE91A6CE3B31BF1DD3E6")

    private Thread mUiThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.142 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "26DE2B72977ADBD047A9853341F26F79")

    final Handler mHandler = new Handler();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.142 -0400", hash_original_method = "AACC12F53D348DF0EC8A64E180708AE7", hash_generated_method = "AACC12F53D348DF0EC8A64E180708AE7")
    public Activity ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.144 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "BAB47810CFA4CD1BFBDB1F815700A536")
    public Intent getIntent() {
Intent var4DCF8E3D75AE0B94CDA94656DCE16BCE_1788461147 =         mIntent;
        var4DCF8E3D75AE0B94CDA94656DCE16BCE_1788461147.addTaint(taint);
        return var4DCF8E3D75AE0B94CDA94656DCE16BCE_1788461147;
        // ---------- Original Method ----------
        //return mIntent;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.146 -0400", hash_original_method = "CC61C883982068788EAC9DED2F81C9E5", hash_generated_method = "B79BA4B24A70D57CC8AC980D0B341130")
    public void setIntent(Intent newIntent) {
        mIntent = newIntent;
        // ---------- Original Method ----------
        //mIntent = newIntent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.147 -0400", hash_original_method = "510D23D8CF054FDAE1D1426C6A1A1500", hash_generated_method = "024AB9870AADD6192E2A93D66DB36721")
    public final Application getApplication() {
Application varF254F0ADF054F0318B65674CA3670A5E_1998651508 =         mApplication;
        varF254F0ADF054F0318B65674CA3670A5E_1998651508.addTaint(taint);
        return varF254F0ADF054F0318B65674CA3670A5E_1998651508;
        // ---------- Original Method ----------
        //return mApplication;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.150 -0400", hash_original_method = "68263BD6D248286EA0E84780534AEB0C", hash_generated_method = "0968810C6F0ABCB176C8F2B243CABA90")
    public final boolean isChild() {
        boolean var59946ED0506E172464CCBA93FC667ED2_990153449 = (mParent != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_826313549 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_826313549;
        // ---------- Original Method ----------
        //return mParent != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.151 -0400", hash_original_method = "9F036901744EF56469FFF11C0925658F", hash_generated_method = "56AFB87647D3BB60B65D228A7B62DAD0")
    public final Activity getParent() {
Activity var0FD24AAB8334CCBF65F979972AC650BD_1847876295 =         mParent;
        var0FD24AAB8334CCBF65F979972AC650BD_1847876295.addTaint(taint);
        return var0FD24AAB8334CCBF65F979972AC650BD_1847876295;
        // ---------- Original Method ----------
        //return mParent;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.153 -0400", hash_original_method = "1DCFADD2C71F0E408EA049F81A8ACDED", hash_generated_method = "7B95111CD71FD38D51849C74B2BC64E8")
    public WindowManager getWindowManager() {
WindowManager varC209C60BFE9D7B593AFE54EB902C1459_184611233 =         mWindowManager;
        varC209C60BFE9D7B593AFE54EB902C1459_184611233.addTaint(taint);
        return varC209C60BFE9D7B593AFE54EB902C1459_184611233;
        // ---------- Original Method ----------
        //return mWindowManager;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.154 -0400", hash_original_method = "51ACB33F24592F8ED3FAFF9D96DEAF2A", hash_generated_method = "B64A95081A2BC54DB065255C45D88B34")
    public Window getWindow() {
Window var125511BCCBD4CDF7BDF315F5AA8A1CE3_1543286081 =         mWindow;
        var125511BCCBD4CDF7BDF315F5AA8A1CE3_1543286081.addTaint(taint);
        return var125511BCCBD4CDF7BDF315F5AA8A1CE3_1543286081;
        // ---------- Original Method ----------
        //return mWindow;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.155 -0400", hash_original_method = "6FD2535D569839ECA0CF9FB0769EA7E8", hash_generated_method = "7837BA46863B67E4E6458215A27D3660")
    public LoaderManager getLoaderManager() {
    if(mLoaderManager != null)        
        {
LoaderManager var805CC3710F0829AF609E93E575C2DA90_1831618471 =             mLoaderManager;
            var805CC3710F0829AF609E93E575C2DA90_1831618471.addTaint(taint);
            return var805CC3710F0829AF609E93E575C2DA90_1831618471;
        } //End block
        mCheckedForLoaderManager = true;
        mLoaderManager = getLoaderManager(-1, mLoadersStarted, true);
LoaderManager var805CC3710F0829AF609E93E575C2DA90_476822677 =         mLoaderManager;
        var805CC3710F0829AF609E93E575C2DA90_476822677.addTaint(taint);
        return var805CC3710F0829AF609E93E575C2DA90_476822677;
        // ---------- Original Method ----------
        //if (mLoaderManager != null) {
            //return mLoaderManager;
        //}
        //mCheckedForLoaderManager = true;
        //mLoaderManager = getLoaderManager(-1, mLoadersStarted, true);
        //return mLoaderManager;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.158 -0400", hash_original_method = "08140101E6179DFA80CB04A3C57AF21B", hash_generated_method = "1BE8300B87C302476F2C673F5BFCD4B3")
     LoaderManagerImpl getLoaderManager(int index, boolean started, boolean create) {
        addTaint(create);
        addTaint(started);
        addTaint(index);
    if(mAllLoaderManagers == null)        
        {
            mAllLoaderManagers = new SparseArray<LoaderManagerImpl>();
        } //End block
        LoaderManagerImpl lm = mAllLoaderManagers.get(index);
    if(lm == null)        
        {
    if(create)            
            {
                lm = new LoaderManagerImpl(this, started);
                mAllLoaderManagers.put(index, lm);
            } //End block
        } //End block
        else
        {
            lm.updateActivity(this);
        } //End block
LoaderManagerImpl varFAB97767FC97D5B051DD34588BADBEE3_1963917504 =         lm;
        varFAB97767FC97D5B051DD34588BADBEE3_1963917504.addTaint(taint);
        return varFAB97767FC97D5B051DD34588BADBEE3_1963917504;
        // ---------- Original Method ----------
        //if (mAllLoaderManagers == null) {
            //mAllLoaderManagers = new SparseArray<LoaderManagerImpl>();
        //}
        //LoaderManagerImpl lm = mAllLoaderManagers.get(index);
        //if (lm == null) {
            //if (create) {
                //lm = new LoaderManagerImpl(this, started);
                //mAllLoaderManagers.put(index, lm);
            //}
        //} else {
            //lm.updateActivity(this);
        //}
        //return lm;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.159 -0400", hash_original_method = "44957F5326E5A87B91E438DCD3C71232", hash_generated_method = "64C9C2E612F3557977DEECB496787AD3")
    public View getCurrentFocus() {
View varE3E79DFDA423BE71E1BD830287B2C373_886827634 =         mWindow != null ? mWindow.getCurrentFocus() : null;
        varE3E79DFDA423BE71E1BD830287B2C373_886827634.addTaint(taint);
        return varE3E79DFDA423BE71E1BD830287B2C373_886827634;
        // ---------- Original Method ----------
        //return mWindow != null ? mWindow.getCurrentFocus() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.160 -0400", hash_original_method = "B17127798FA6CFC370BF4A1AB8F1546E", hash_generated_method = "8320B7E5D558CDCF6F4B9639F455928B")
    protected void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
    if(mLastNonConfigurationInstances != null)        
        {
            mAllLoaderManagers = mLastNonConfigurationInstances.loaders;
        } //End block
    if(savedInstanceState != null)        
        {
            Parcelable p = savedInstanceState.getParcelable(FRAGMENTS_TAG);
            mFragments.restoreAllState(p, mLastNonConfigurationInstances != null
                    ? mLastNonConfigurationInstances.fragments : null);
        } //End block
        mFragments.dispatchCreate();
        getApplication().dispatchActivityCreated(this, savedInstanceState);
        mCalled = true;
        // ---------- Original Method ----------
        //if (mLastNonConfigurationInstances != null) {
            //mAllLoaderManagers = mLastNonConfigurationInstances.loaders;
        //}
        //if (savedInstanceState != null) {
            //Parcelable p = savedInstanceState.getParcelable(FRAGMENTS_TAG);
            //mFragments.restoreAllState(p, mLastNonConfigurationInstances != null
                    //? mLastNonConfigurationInstances.fragments : null);
        //}
        //mFragments.dispatchCreate();
        //getApplication().dispatchActivityCreated(this, savedInstanceState);
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.161 -0400", hash_original_method = "F96DCFB160CAE669DE173597BCAB5D29", hash_generated_method = "B408C94F71D998D8CB930448FA04C0C7")
    final void performRestoreInstanceState(Bundle savedInstanceState) {
        addTaint(savedInstanceState.getTaint());
        onRestoreInstanceState(savedInstanceState);
        restoreManagedDialogs(savedInstanceState);
        // ---------- Original Method ----------
        //onRestoreInstanceState(savedInstanceState);
        //restoreManagedDialogs(savedInstanceState);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.162 -0400", hash_original_method = "310E3A3C8C3B3732DFA9529F42CA26F1", hash_generated_method = "45E6C49B47198020495E8E98E448D6EE")
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
    if(mWindow != null)        
        {
            Bundle windowState = savedInstanceState.getBundle(WINDOW_HIERARCHY_TAG);
    if(windowState != null)            
            {
                mWindow.restoreHierarchyState(windowState);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mWindow != null) {
            //Bundle windowState = savedInstanceState.getBundle(WINDOW_HIERARCHY_TAG);
            //if (windowState != null) {
                //mWindow.restoreHierarchyState(windowState);
            //}
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.164 -0400", hash_original_method = "0F730FD08B46E6D42261031E4F07C651", hash_generated_method = "1B0F13492E6DB13B515B7D70B6A1B80D")
    private void restoreManagedDialogs(Bundle savedInstanceState) {
        addTaint(savedInstanceState.getTaint());
        final Bundle b = savedInstanceState.getBundle(SAVED_DIALOGS_TAG);
    if(b == null)        
        {
            return;
        } //End block
        final int[] ids = b.getIntArray(SAVED_DIALOG_IDS_KEY);
        final int numDialogs = ids.length;
        mManagedDialogs = new SparseArray<ManagedDialog>(numDialogs);
for(int i = 0;i < numDialogs;i++)
        {
            final Integer dialogId = ids[i];
            Bundle dialogState = b.getBundle(savedDialogKeyFor(dialogId));
    if(dialogState != null)            
            {
                final ManagedDialog md = new ManagedDialog();
                md.mArgs = b.getBundle(savedDialogArgsKeyFor(dialogId));
                md.mDialog = createDialog(dialogId, dialogState, md.mArgs);
    if(md.mDialog != null)                
                {
                    mManagedDialogs.put(dialogId, md);
                    onPrepareDialog(dialogId, md.mDialog, md.mArgs);
                    md.mDialog.onRestoreInstanceState(dialogState);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.166 -0400", hash_original_method = "F21B3418C21CA75D12B54B07BD48021E", hash_generated_method = "7B4200850ACF4B01A7B888EBCC93DB80")
    private Dialog createDialog(Integer dialogId, Bundle state, Bundle args) {
        addTaint(args.getTaint());
        addTaint(state.getTaint());
        addTaint(dialogId.getTaint());
        final Dialog dialog = onCreateDialog(dialogId, args);
    if(dialog == null)        
        {
Dialog var540C13E9E156B687226421B24F2DF178_570463377 =             null;
            var540C13E9E156B687226421B24F2DF178_570463377.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_570463377;
        } //End block
        dialog.dispatchOnCreate(state);
Dialog varE19892282EF70932DF3A147A213BE89D_129545283 =         dialog;
        varE19892282EF70932DF3A147A213BE89D_129545283.addTaint(taint);
        return varE19892282EF70932DF3A147A213BE89D_129545283;
        // ---------- Original Method ----------
        //final Dialog dialog = onCreateDialog(dialogId, args);
        //if (dialog == null) {
            //return null;
        //}
        //dialog.dispatchOnCreate(state);
        //return dialog;
    }

    
        @DSModeled(DSC.SPEC)
    private static String savedDialogKeyFor(int key) {
        return SAVED_DIALOG_KEY_PREFIX + key;
    }

    
        @DSModeled(DSC.SPEC)
    private static String savedDialogArgsKeyFor(int key) {
        return SAVED_DIALOG_ARGS_KEY_PREFIX + key;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.172 -0400", hash_original_method = "15D630F6A1CF1F711678BA91927530D5", hash_generated_method = "02D9DABD476524D00842793F970D437B")
    protected void onPostCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
    if(!isChild())        
        {
            mTitleReady = true;
            onTitleChanged(getTitle(), getTitleColor());
        } //End block
        mCalled = true;
        // ---------- Original Method ----------
        //if (!isChild()) {
            //mTitleReady = true;
            //onTitleChanged(getTitle(), getTitleColor());
        //}
        //mCalled = true;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.175 -0400", hash_original_method = "79A696122767FFD8BC894F5F20A8F390", hash_generated_method = "CA018C1C1D3C86440B6082BFD7792C8D")
    protected void onStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
    if(!mLoadersStarted)        
        {
            mLoadersStarted = true;
    if(mLoaderManager != null)            
            {
                mLoaderManager.doStart();
            } //End block
            else
    if(!mCheckedForLoaderManager)            
            {
                mLoaderManager = getLoaderManager(-1, mLoadersStarted, false);
            } //End block
            mCheckedForLoaderManager = true;
        } //End block
        getApplication().dispatchActivityStarted(this);
        // ---------- Original Method ----------
        //mCalled = true;
        //if (!mLoadersStarted) {
            //mLoadersStarted = true;
            //if (mLoaderManager != null) {
                //mLoaderManager.doStart();
            //} else if (!mCheckedForLoaderManager) {
                //mLoaderManager = getLoaderManager(-1, mLoadersStarted, false);
            //}
            //mCheckedForLoaderManager = true;
        //}
        //getApplication().dispatchActivityStarted(this);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.178 -0400", hash_original_method = "9551F017AAC8568C86A29525E7DD6889", hash_generated_method = "BFAD3826B369FB60CEBE705C5D3DE3AF")
    protected void onRestart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.184 -0400", hash_original_method = "AC4046BA89469FB1DB71AF45F366E61A", hash_generated_method = "386EEADB41ACC4B4BD80CE17A193C26A")
    protected void onResume() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        getApplication().dispatchActivityResumed(this);
        mCalled = true;
        // ---------- Original Method ----------
        //getApplication().dispatchActivityResumed(this);
        //mCalled = true;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.185 -0400", hash_original_method = "F3C7FB58C48A3E40E2BB0C45916F9A60", hash_generated_method = "83540263E35D36F58CBAD56C45C282D5")
    protected void onPostResume() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final Window win = getWindow();
    if(win != null)        
        win.makeActive();
    if(mActionBar != null)        
        mActionBar.setShowHideAnimationEnabled(true);
        mCalled = true;
        // ---------- Original Method ----------
        //final Window win = getWindow();
        //if (win != null) win.makeActive();
        //if (mActionBar != null) mActionBar.setShowHideAnimationEnabled(true);
        //mCalled = true;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.186 -0400", hash_original_method = "ECA12E6FCFF6C8E6301C9A23FD34F5BD", hash_generated_method = "55BB01BD8178596262072C6AD03D450A")
    protected void onNewIntent(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.187 -0400", hash_original_method = "0B461FC0ABFD8E876BD0A4555078BB43", hash_generated_method = "E02196070D10C87DF308A9BB1CE31E11")
    final void performSaveInstanceState(Bundle outState) {
        addTaint(outState.getTaint());
        onSaveInstanceState(outState);
        saveManagedDialogs(outState);
        // ---------- Original Method ----------
        //onSaveInstanceState(outState);
        //saveManagedDialogs(outState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.188 -0400", hash_original_method = "7ACED454726A10AD27032B8542185EA6", hash_generated_method = "AAB785645CC0369C4A16B10D45B22994")
    protected void onSaveInstanceState(Bundle outState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(outState.getTaint());
        outState.putBundle(WINDOW_HIERARCHY_TAG, mWindow.saveHierarchyState());
        Parcelable p = mFragments.saveAllState();
    if(p != null)        
        {
            outState.putParcelable(FRAGMENTS_TAG, p);
        } //End block
        getApplication().dispatchActivitySaveInstanceState(this, outState);
        // ---------- Original Method ----------
        //outState.putBundle(WINDOW_HIERARCHY_TAG, mWindow.saveHierarchyState());
        //Parcelable p = mFragments.saveAllState();
        //if (p != null) {
            //outState.putParcelable(FRAGMENTS_TAG, p);
        //}
        //getApplication().dispatchActivitySaveInstanceState(this, outState);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.190 -0400", hash_original_method = "8A0B1A781281636D9884F4D74FBF5AF9", hash_generated_method = "0077FA30563385D5525EAAC3CDC91837")
    private void saveManagedDialogs(Bundle outState) {
        addTaint(outState.getTaint());
    if(mManagedDialogs == null)        
        {
            return;
        } //End block
        final int numDialogs = mManagedDialogs.size();
    if(numDialogs == 0)        
        {
            return;
        } //End block
        Bundle dialogState = new Bundle();
        int[] ids = new int[mManagedDialogs.size()];
for(int i = 0;i < numDialogs;i++)
        {
            final int key = mManagedDialogs.keyAt(i);
            ids[i] = key;
            final ManagedDialog md = mManagedDialogs.valueAt(i);
            dialogState.putBundle(savedDialogKeyFor(key), md.mDialog.onSaveInstanceState());
    if(md.mArgs != null)            
            {
                dialogState.putBundle(savedDialogArgsKeyFor(key), md.mArgs);
            } //End block
        } //End block
        dialogState.putIntArray(SAVED_DIALOG_IDS_KEY, ids);
        outState.putBundle(SAVED_DIALOGS_TAG, dialogState);
        // ---------- Original Method ----------
        //if (mManagedDialogs == null) {
            //return;
        //}
        //final int numDialogs = mManagedDialogs.size();
        //if (numDialogs == 0) {
            //return;
        //}
        //Bundle dialogState = new Bundle();
        //int[] ids = new int[mManagedDialogs.size()];
        //for (int i = 0; i < numDialogs; i++) {
            //final int key = mManagedDialogs.keyAt(i);
            //ids[i] = key;
            //final ManagedDialog md = mManagedDialogs.valueAt(i);
            //dialogState.putBundle(savedDialogKeyFor(key), md.mDialog.onSaveInstanceState());
            //if (md.mArgs != null) {
                //dialogState.putBundle(savedDialogArgsKeyFor(key), md.mArgs);
            //}
        //}
        //dialogState.putIntArray(SAVED_DIALOG_IDS_KEY, ids);
        //outState.putBundle(SAVED_DIALOGS_TAG, dialogState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.191 -0400", hash_original_method = "B6F2BA46109080323AC17E644CBE52E4", hash_generated_method = "486584B3FE1F7AACB7AE3C8DA52C0E5B")
    protected void onPause() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        getApplication().dispatchActivityPaused(this);
        mCalled = true;
        // ---------- Original Method ----------
        //getApplication().dispatchActivityPaused(this);
        //mCalled = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.193 -0400", hash_original_method = "F09D1B8D5CADCA3B5931B472B638BC48", hash_generated_method = "E9DC8D666FB72967F203DDC8123D3668")
    protected void onUserLeaveHint() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.198 -0400", hash_original_method = "88BB0202BF6BAEB771096BFB80D04435", hash_generated_method = "25D3F8CC2A60DFF022479BFCD96C2714")
    public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(canvas.getTaint());
        addTaint(outBitmap.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1680902949 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2118010541 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2118010541;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.201 -0400", hash_original_method = "ABF3FC9B35FB67DA4650457E79D2DAE8", hash_generated_method = "5DDFA7AA7B03A59DE88CF05E1C22CD2A")
    public CharSequence onCreateDescription() {
        //DSFIXME:  CODE0009: Possible callback target function detected
CharSequence var540C13E9E156B687226421B24F2DF178_978867545 =         null;
        var540C13E9E156B687226421B24F2DF178_978867545.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_978867545;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.203 -0400", hash_original_method = "24615BF0697D6E27C5190BAC65D711E7", hash_generated_method = "E308DAFB2A00B063E84057BBF8FD3F8B")
    protected void onStop() {
        //DSFIXME:  CODE0009: Possible callback target function detected
    if(mActionBar != null)        
        mActionBar.setShowHideAnimationEnabled(false);
        getApplication().dispatchActivityStopped(this);
        mCalled = true;
        // ---------- Original Method ----------
        //if (mActionBar != null) mActionBar.setShowHideAnimationEnabled(false);
        //getApplication().dispatchActivityStopped(this);
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.204 -0400", hash_original_method = "4E5533F51E688B9D4BB620414B9C0889", hash_generated_method = "4BE7D990D317F9BD729169984D5D4B29")
    protected void onDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
    if(mManagedDialogs != null)        
        {
            final int numDialogs = mManagedDialogs.size();
for(int i = 0;i < numDialogs;i++)
            {
                final ManagedDialog md = mManagedDialogs.valueAt(i);
    if(md.mDialog.isShowing())                
                {
                    md.mDialog.dismiss();
                } //End block
            } //End block
            mManagedDialogs = null;
        } //End block
        synchronized
(mManagedCursors)        {
            int numCursors = mManagedCursors.size();
for(int i = 0;i < numCursors;i++)
            {
                ManagedCursor c = mManagedCursors.get(i);
    if(c != null)                
                {
                    c.mCursor.close();
                } //End block
            } //End block
            mManagedCursors.clear();
        } //End block
    if(mSearchManager != null)        
        {
            mSearchManager.stopSearch();
        } //End block
        getApplication().dispatchActivityDestroyed(this);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.206 -0400", hash_original_method = "30CE766C89D5A8D407C7E787A35027AF", hash_generated_method = "E559E9BB1DA57F2515EC2DCA03C42FA9")
    public void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newConfig.getTaint());
        mCalled = true;
        mFragments.dispatchConfigurationChanged(newConfig);
    if(mWindow != null)        
        {
            mWindow.onConfigurationChanged(newConfig);
        } //End block
    if(mActionBar != null)        
        {
            mActionBar.onConfigurationChanged(newConfig);
        } //End block
        // ---------- Original Method ----------
        //mCalled = true;
        //mFragments.dispatchConfigurationChanged(newConfig);
        //if (mWindow != null) {
            //mWindow.onConfigurationChanged(newConfig);
        //}
        //if (mActionBar != null) {
            //mActionBar.onConfigurationChanged(newConfig);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.208 -0400", hash_original_method = "60C5D0D9DB2F726CCDEA80A841C2981A", hash_generated_method = "BFA765BFA8EDD63A44CD14D243308597")
    public int getChangingConfigurations() {
        int varC276475150FAB89E9C0772A14D5411EF_1470298979 = (mConfigChangeFlags);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1794118973 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1794118973;
        // ---------- Original Method ----------
        //return mConfigChangeFlags;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.210 -0400", hash_original_method = "A4ED76D57E3C56C838C9F6AEF3843C6C", hash_generated_method = "53CD51E7CAFB92223EF9B6E00E3F6FBF")
    @Deprecated
    public Object getLastNonConfigurationInstance() {
Object varE43F41A071A3FAC2B59DBDC0221898AF_395114665 =         mLastNonConfigurationInstances != null
                ? mLastNonConfigurationInstances.activity : null;
        varE43F41A071A3FAC2B59DBDC0221898AF_395114665.addTaint(taint);
        return varE43F41A071A3FAC2B59DBDC0221898AF_395114665;
        // ---------- Original Method ----------
        //return mLastNonConfigurationInstances != null
                //? mLastNonConfigurationInstances.activity : null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.212 -0400", hash_original_method = "1AAF173FB42EFD7F047F27F49A93F1B0", hash_generated_method = "8541E4A4279C36BD8E817A9B562AF104")
    public Object onRetainNonConfigurationInstance() {
        //DSFIXME:  CODE0009: Possible callback target function detected
Object var540C13E9E156B687226421B24F2DF178_670442227 =         null;
        var540C13E9E156B687226421B24F2DF178_670442227.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_670442227;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.213 -0400", hash_original_method = "891F87189588B9AE1E11F6F1107773C1", hash_generated_method = "9E5A54DA7A59EF18733F9C973706CA94")
     HashMap<String, Object> getLastNonConfigurationChildInstances() {
HashMap<String, Object> var565AF85CD7FD549206791978C46AE460_258775599 =         mLastNonConfigurationInstances != null
                ? mLastNonConfigurationInstances.children : null;
        var565AF85CD7FD549206791978C46AE460_258775599.addTaint(taint);
        return var565AF85CD7FD549206791978C46AE460_258775599;
        // ---------- Original Method ----------
        //return mLastNonConfigurationInstances != null
                //? mLastNonConfigurationInstances.children : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.213 -0400", hash_original_method = "342B0C995620FF868A09DAF694D00C04", hash_generated_method = "624D2659AEA7DBB38CCA06C99A27EC8D")
     HashMap<String,Object> onRetainNonConfigurationChildInstances() {
        //DSFIXME:  CODE0009: Possible callback target function detected
HashMap<String,Object> var540C13E9E156B687226421B24F2DF178_227216230 =         null;
        var540C13E9E156B687226421B24F2DF178_227216230.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_227216230;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.215 -0400", hash_original_method = "927AC7E194A76481C5C9B757C08C225A", hash_generated_method = "8D720897E3CDC34015CF0FC646F6E4DD")
     NonConfigurationInstances retainNonConfigurationInstances() {
        Object activity = onRetainNonConfigurationInstance();
        HashMap<String, Object> children = onRetainNonConfigurationChildInstances();
        ArrayList<Fragment> fragments = mFragments.retainNonConfig();
        boolean retainLoaders = false;
    if(mAllLoaderManagers != null)        
        {
for(int i=mAllLoaderManagers.size()-1;i>=0;i--)
            {
                LoaderManagerImpl lm = mAllLoaderManagers.valueAt(i);
    if(lm.mRetaining)                
                {
                    retainLoaders = true;
                } //End block
                else
                {
                    lm.doDestroy();
                    mAllLoaderManagers.removeAt(i);
                } //End block
            } //End block
        } //End block
    if(activity == null && children == null && fragments == null && !retainLoaders)        
        {
NonConfigurationInstances var540C13E9E156B687226421B24F2DF178_1923078140 =             null;
            var540C13E9E156B687226421B24F2DF178_1923078140.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1923078140;
        } //End block
        NonConfigurationInstances nci = new NonConfigurationInstances();
        nci.activity = activity;
        nci.children = children;
        nci.fragments = fragments;
        nci.loaders = mAllLoaderManagers;
NonConfigurationInstances var7D805FCD5771122135162F5B7459B31C_2005313671 =         nci;
        var7D805FCD5771122135162F5B7459B31C_2005313671.addTaint(taint);
        return var7D805FCD5771122135162F5B7459B31C_2005313671;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.222 -0400", hash_original_method = "85EA10C9746E5BAE09F0BEB2EAF91433", hash_generated_method = "DF43C28571D148477AB74F4811D8645C")
    public void onLowMemory() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        mFragments.dispatchLowMemory();
        // ---------- Original Method ----------
        //mCalled = true;
        //mFragments.dispatchLowMemory();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.224 -0400", hash_original_method = "B7E71156F952E373C8BB026507E8D786", hash_generated_method = "F741E9AD7E2555C56E5F3AD3DAEDFA16")
    public void onTrimMemory(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(level);
        mCalled = true;
        mFragments.dispatchTrimMemory(level);
        // ---------- Original Method ----------
        //mCalled = true;
        //mFragments.dispatchTrimMemory(level);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.225 -0400", hash_original_method = "C5EB33D6873EE026D87972F02E8EBD4B", hash_generated_method = "D238AD07B905DB072805D4D55ECFA9FD")
    public FragmentManager getFragmentManager() {
FragmentManager varB68713B43E6D3DE30B9A48FEA4C5FD0D_1272713691 =         mFragments;
        varB68713B43E6D3DE30B9A48FEA4C5FD0D_1272713691.addTaint(taint);
        return varB68713B43E6D3DE30B9A48FEA4C5FD0D_1272713691;
        // ---------- Original Method ----------
        //return mFragments;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.225 -0400", hash_original_method = "36D6A0BA7A439406C26069B6EB63A924", hash_generated_method = "2AAE51536ED4088E236FD6F9B304AF59")
     void invalidateFragmentIndex(int index) {
        addTaint(index);
    if(mAllLoaderManagers != null)        
        {
            LoaderManagerImpl lm = mAllLoaderManagers.get(index);
    if(lm != null && !lm.mRetaining)            
            {
                lm.doDestroy();
                mAllLoaderManagers.remove(index);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mAllLoaderManagers != null) {
            //LoaderManagerImpl lm = mAllLoaderManagers.get(index);
            //if (lm != null && !lm.mRetaining) {
                //lm.doDestroy();
                //mAllLoaderManagers.remove(index);
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.226 -0400", hash_original_method = "28C2B4CF762BABC0F8C194FDD6A98E77", hash_generated_method = "7BA62512AFE4BD6BB2D807B17B09B3A6")
    public void onAttachFragment(Fragment fragment) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(fragment.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.228 -0400", hash_original_method = "BCF4BFC69850BAC01DAD91770055CA28", hash_generated_method = "13BD81DEB4B14D2AE73FD1FBE8376C83")
    @Deprecated
    public final Cursor managedQuery(Uri uri, String[] projection, String selection,
            String sortOrder) {
        addTaint(sortOrder.getTaint());
        addTaint(selection.getTaint());
        addTaint(projection[0].getTaint());
        addTaint(uri.getTaint());
        Cursor c = getContentResolver().query(uri, projection, selection, null, sortOrder);
    if(c != null)        
        {
            startManagingCursor(c);
        } //End block
Cursor var807FB10045EE51C06BDB74744A6714DF_1769143991 =         c;
        var807FB10045EE51C06BDB74744A6714DF_1769143991.addTaint(taint);
        return var807FB10045EE51C06BDB74744A6714DF_1769143991;
        // ---------- Original Method ----------
        //Cursor c = getContentResolver().query(uri, projection, selection, null, sortOrder);
        //if (c != null) {
            //startManagingCursor(c);
        //}
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.230 -0400", hash_original_method = "957642E226FD04681CA818B5E27D8161", hash_generated_method = "B6BFE99BC1E717A2DBAE2821CE7E7CBA")
    @Deprecated
    public final Cursor managedQuery(Uri uri, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) {
        addTaint(sortOrder.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(projection[0].getTaint());
        addTaint(uri.getTaint());
        Cursor c = getContentResolver().query(uri, projection, selection, selectionArgs, sortOrder);
    if(c != null)        
        {
            startManagingCursor(c);
        } //End block
Cursor var807FB10045EE51C06BDB74744A6714DF_1337736273 =         c;
        var807FB10045EE51C06BDB74744A6714DF_1337736273.addTaint(taint);
        return var807FB10045EE51C06BDB74744A6714DF_1337736273;
        // ---------- Original Method ----------
        //Cursor c = getContentResolver().query(uri, projection, selection, selectionArgs, sortOrder);
        //if (c != null) {
            //startManagingCursor(c);
        //}
        //return c;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.231 -0400", hash_original_method = "A63FE9916C33F333B3D894D85FA64949", hash_generated_method = "60F670D3E9FC091E69645FD542AA84BE")
    @Deprecated
    public void startManagingCursor(Cursor c) {
        addTaint(c.getTaint());
        synchronized
(mManagedCursors)        {
            mManagedCursors.add(new ManagedCursor(c));
        } //End block
        // ---------- Original Method ----------
        //synchronized (mManagedCursors) {
            //mManagedCursors.add(new ManagedCursor(c));
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.232 -0400", hash_original_method = "6A91264601243F53EF1A64547761DF34", hash_generated_method = "490F6EFB7D045D3827E299277F58D106")
    @Deprecated
    public void stopManagingCursor(Cursor c) {
        addTaint(c.getTaint());
        synchronized
(mManagedCursors)        {
            final int N = mManagedCursors.size();
for(int i=0;i<N;i++)
            {
                ManagedCursor mc = mManagedCursors.get(i);
    if(mc.mCursor == c)                
                {
                    mManagedCursors.remove(i);
                    break;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mManagedCursors) {
            //final int N = mManagedCursors.size();
            //for (int i=0; i<N; i++) {
                //ManagedCursor mc = mManagedCursors.get(i);
                //if (mc.mCursor == c) {
                    //mManagedCursors.remove(i);
                    //break;
                //}
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.233 -0400", hash_original_method = "14D9F664592BF6CD2790F336C855BE58", hash_generated_method = "C1728DB8A9348DEE6C39624FD13930AC")
    @Deprecated
    public void setPersistent(boolean isPersistent) {
        addTaint(isPersistent);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.234 -0400", hash_original_method = "6A267AF8CD8DFD046F9AA4A840E0F1F1", hash_generated_method = "6B775BD89B69B7F0C120C72D1630178B")
    public View findViewById(int id) {
        addTaint(id);
View var4D717054A3BFDE9A7AE97D046B1A160A_1375795082 =         getWindow().findViewById(id);
        var4D717054A3BFDE9A7AE97D046B1A160A_1375795082.addTaint(taint);
        return var4D717054A3BFDE9A7AE97D046B1A160A_1375795082;
        // ---------- Original Method ----------
        //return getWindow().findViewById(id);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.234 -0400", hash_original_method = "EC6DC7C8BFDE6FF47CE21F97E3274EE5", hash_generated_method = "C434C496C3AAFBDCA42C6BC79A7A4135")
    public ActionBar getActionBar() {
        initActionBar();
ActionBar var02D7B9E52DFDAF29F050C055F2B0A03C_422099317 =         mActionBar;
        var02D7B9E52DFDAF29F050C055F2B0A03C_422099317.addTaint(taint);
        return var02D7B9E52DFDAF29F050C055F2B0A03C_422099317;
        // ---------- Original Method ----------
        //initActionBar();
        //return mActionBar;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.235 -0400", hash_original_method = "1F37525CA4259BFCC1AC98918D267A3B", hash_generated_method = "031E26D98F5E1F29F8211D6F09BF4AD6")
    private void initActionBar() {
        Window window = getWindow();
        window.getDecorView();
    if(isChild() || !window.hasFeature(Window.FEATURE_ACTION_BAR) || mActionBar != null)        
        {
            return;
        } //End block
        mActionBar = new ActionBarImpl(this);
        // ---------- Original Method ----------
        //Window window = getWindow();
        //window.getDecorView();
        //if (isChild() || !window.hasFeature(Window.FEATURE_ACTION_BAR) || mActionBar != null) {
            //return;
        //}
        //mActionBar = new ActionBarImpl(this);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.236 -0400", hash_original_method = "FC4CFA409E0DBC3CD2C86D908686341E", hash_generated_method = "DD50AE9CA3E30A50521FF5832C4B998B")
    public void setContentView(int layoutResID) {
        addTaint(layoutResID);
        getWindow().setContentView(layoutResID);
        initActionBar();
        // ---------- Original Method ----------
        //getWindow().setContentView(layoutResID);
        //initActionBar();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.237 -0400", hash_original_method = "6143DA20A0E63D3DD26D6D6CC3A0350F", hash_generated_method = "8C30C12182A5ED856C195287BD5DD0D2")
    public void setContentView(View view) {
        addTaint(view.getTaint());
        getWindow().setContentView(view);
        initActionBar();
        // ---------- Original Method ----------
        //getWindow().setContentView(view);
        //initActionBar();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.238 -0400", hash_original_method = "FCB0E6F09A4D449F841F63B35D6A2C9A", hash_generated_method = "83B846FFDE9E83E7AD2DB7B9AD3C45DC")
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        addTaint(params.getTaint());
        addTaint(view.getTaint());
        getWindow().setContentView(view, params);
        initActionBar();
        // ---------- Original Method ----------
        //getWindow().setContentView(view, params);
        //initActionBar();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.239 -0400", hash_original_method = "FC447FA34EAD1A15520CE5D8778BF36F", hash_generated_method = "7D0A77A50094480903F1BC3646A6414E")
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        addTaint(params.getTaint());
        addTaint(view.getTaint());
        getWindow().addContentView(view, params);
        initActionBar();
        // ---------- Original Method ----------
        //getWindow().addContentView(view, params);
        //initActionBar();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.240 -0400", hash_original_method = "729048B37138D48F6A74BC6AFCECACEE", hash_generated_method = "4317FA9DB306D17FCAAA4D70EAA249DE")
    public void setFinishOnTouchOutside(boolean finish) {
        addTaint(finish);
        mWindow.setCloseOnTouchOutside(finish);
        // ---------- Original Method ----------
        //mWindow.setCloseOnTouchOutside(finish);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.242 -0400", hash_original_method = "84B2B4D9720193C8DC3107EE4335392B", hash_generated_method = "52E6E3435CF124B3A0984B287D8E3B58")
    public final void setDefaultKeyMode(int mode) {
        mDefaultKeyMode = mode;
switch(mode){
        case DEFAULT_KEYS_DISABLE:
        case DEFAULT_KEYS_SHORTCUT:
        mDefaultKeySsb = null;
        break;
        case DEFAULT_KEYS_DIALER:
        case DEFAULT_KEYS_SEARCH_LOCAL:
        case DEFAULT_KEYS_SEARCH_GLOBAL:
        mDefaultKeySsb = new SpannableStringBuilder();
        Selection.setSelection(mDefaultKeySsb,0);
        break;
        default:
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1913960253 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_1913960253.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_1913960253;
}
        // ---------- Original Method ----------
        //mDefaultKeyMode = mode;
        //switch (mode) {
        //case DEFAULT_KEYS_DISABLE:
        //case DEFAULT_KEYS_SHORTCUT:
            //mDefaultKeySsb = null;      
            //break;
        //case DEFAULT_KEYS_DIALER:
        //case DEFAULT_KEYS_SEARCH_LOCAL:
        //case DEFAULT_KEYS_SEARCH_GLOBAL:
            //mDefaultKeySsb = new SpannableStringBuilder();
            //Selection.setSelection(mDefaultKeySsb,0);
            //break;
        //default:
            //throw new IllegalArgumentException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.251 -0400", hash_original_method = "447EA7C05CB03D3ADA1829E3AD87227A", hash_generated_method = "49D1EA23E80C8CB5800A82BD4BB3B2E5")
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
    if(keyCode == KeyEvent.KEYCODE_BACK)        
        {
    if(getApplicationInfo().targetSdkVersion
                    >= Build.VERSION_CODES.ECLAIR)            
            {
                event.startTracking();
            } //End block
            else
            {
                onBackPressed();
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1319821222 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_608254591 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_608254591;
        } //End block
    if(mDefaultKeyMode == DEFAULT_KEYS_DISABLE)        
        {
            boolean var68934A3E9455FA72420237EB05902327_132329164 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1701027457 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1701027457;
        } //End block
        else
    if(mDefaultKeyMode == DEFAULT_KEYS_SHORTCUT)        
        {
    if(getWindow().performPanelShortcut(Window.FEATURE_OPTIONS_PANEL, 
                    keyCode, event, Menu.FLAG_ALWAYS_PERFORM_CLOSE))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1542098491 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_859656300 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_859656300;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1182361402 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1660394415 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1660394415;
        } //End block
        else
        {
            boolean clearSpannable = false;
            boolean handled;
    if((event.getRepeatCount() != 0) || event.isSystem())            
            {
                clearSpannable = true;
                handled = false;
            } //End block
            else
            {
                handled = TextKeyListener.getInstance().onKeyDown(
                        null, mDefaultKeySsb, keyCode, event);
    if(handled && mDefaultKeySsb.length() > 0)                
                {
                    final String str = mDefaultKeySsb.toString();
                    clearSpannable = true;
switch(mDefaultKeyMode){
                    case DEFAULT_KEYS_DIALER:
                    Intent intent = new Intent(Intent.ACTION_DIAL,  Uri.parse("tel:" + str));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    break;
                    case DEFAULT_KEYS_SEARCH_LOCAL:
                    startSearch(str, false, null, false);
                    break;
                    case DEFAULT_KEYS_SEARCH_GLOBAL:
                    startSearch(str, false, null, true);
                    break;
}
                } //End block
            } //End block
    if(clearSpannable)            
            {
                mDefaultKeySsb.clear();
                mDefaultKeySsb.clearSpans();
                Selection.setSelection(mDefaultKeySsb,0);
            } //End block
            boolean var98F0599AF776A1FE4101C199A40EEB8F_51910118 = (handled);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1740908678 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1740908678;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.255 -0400", hash_original_method = "2A75FF2C44C4D96068DDAFC2643F0C8B", hash_generated_method = "D0132134A46DE2566C9C68D15FA54C16")
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        boolean var68934A3E9455FA72420237EB05902327_1671074404 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2120940816 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2120940816;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.256 -0400", hash_original_method = "25B851F5D41453D6013FB2C2AA511AE1", hash_generated_method = "EB25610C36B70D483CEFDD078C85F7F3")
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
    if(getApplicationInfo().targetSdkVersion
                >= Build.VERSION_CODES.ECLAIR)        
        {
    if(keyCode == KeyEvent.KEYCODE_BACK && event.isTracking()
                    && !event.isCanceled())            
            {
                onBackPressed();
                boolean varB326B5062B2F0E69046810717534CB09_555800937 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1028332509 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1028332509;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_113699635 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2116486750 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2116486750;
        // ---------- Original Method ----------
        //if (getApplicationInfo().targetSdkVersion
                //>= Build.VERSION_CODES.ECLAIR) {
            //if (keyCode == KeyEvent.KEYCODE_BACK && event.isTracking()
                    //&& !event.isCanceled()) {
                //onBackPressed();
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.256 -0400", hash_original_method = "E364C67ED15F0AA31C6DCFFA6137C8C0", hash_generated_method = "D2151F2EC013148FBF6BF864648E2DB3")
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(repeatCount);
        addTaint(keyCode);
        boolean var68934A3E9455FA72420237EB05902327_33673970 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_95282891 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_95282891;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.257 -0400", hash_original_method = "6AE13C43A807A8F581EF7E482513BDAF", hash_generated_method = "2F6D57473D5D3CD0E2A1AE71D5A914F0")
    public void onBackPressed() {
        //DSFIXME:  CODE0009: Possible callback target function detected
    if(!mFragments.popBackStackImmediate())        
        {
            finish();
        } //End block
        // ---------- Original Method ----------
        //if (!mFragments.popBackStackImmediate()) {
            //finish();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.258 -0400", hash_original_method = "2ECF3E4914B4B3BE2238F799B7435A51", hash_generated_method = "B27A90E248A73D339F2070C3465E8263")
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        boolean var68934A3E9455FA72420237EB05902327_139885429 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1112572891 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1112572891;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.260 -0400", hash_original_method = "587C23A975B49ED816BE95A55AB82601", hash_generated_method = "67BBACF49CAF72DEDDCBE24D0047A8AF")
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
    if(mWindow.shouldCloseOnTouch(this, event))        
        {
            finish();
            boolean varB326B5062B2F0E69046810717534CB09_2125585497 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_731503916 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_731503916;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_953210581 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2098890158 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2098890158;
        // ---------- Original Method ----------
        //if (mWindow.shouldCloseOnTouch(this, event)) {
            //finish();
            //return true;
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.262 -0400", hash_original_method = "4A983FDB3FF481E2165B7D8D641CDD48", hash_generated_method = "F16821FEFEBA42760D63F16C6DD3D4A9")
    public boolean onTrackballEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_194376743 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1445474914 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1445474914;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.263 -0400", hash_original_method = "0E59A005881F30C798F764BCF32D89A3", hash_generated_method = "09BEB5828E83B8739D2EB0957B273C9F")
    public boolean onGenericMotionEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_790983164 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_807669982 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_807669982;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.264 -0400", hash_original_method = "787C037504CBD45EADF1B222AFA073D0", hash_generated_method = "A806D85F6475EA9E3D8F95C8B0E85BF8")
    public void onUserInteraction() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.265 -0400", hash_original_method = "1D902756EB8B1D6D1B39ED873E4CD230", hash_generated_method = "EDA06DA9D14070F4EAE2130A916836BD")
    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(params.getTaint());
    if(mParent == null)        
        {
            View decor = mDecor;
    if(decor != null && decor.getParent() != null)            
            {
                getWindowManager().updateViewLayout(decor, params);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mParent == null) {
            //View decor = mDecor;
            //if (decor != null && decor.getParent() != null) {
                //getWindowManager().updateViewLayout(decor, params);
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.266 -0400", hash_original_method = "32D7339793DCE0D5AEFE6621981EC978", hash_generated_method = "15CE33052F85E41C1BB65E1E6B2C108A")
    public void onContentChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.266 -0400", hash_original_method = "C7622FC561A602386C2112BC0445F7C6", hash_generated_method = "EEF2114A935228AD19BFEE6FAB48379F")
    public void onWindowFocusChanged(boolean hasFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(hasFocus);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.267 -0400", hash_original_method = "D6E949EE9F0768F47016EEA4FC0347A8", hash_generated_method = "0E08FFA9282E502085CC6973CB60CDA1")
    public void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.268 -0400", hash_original_method = "E592299EBB4DE1D6696EB8C4009A9EF4", hash_generated_method = "1328510831112E7A424EFCA8583CA87C")
    public void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.271 -0400", hash_original_method = "7F717562D5C1B102DE657A2EE434F557", hash_generated_method = "7A6ABAF7D88D0875D87A149A4610F145")
    public boolean hasWindowFocus() {
        Window w = getWindow();
    if(w != null)        
        {
            View d = w.getDecorView();
    if(d != null)            
            {
                boolean var84E5D20C0FA3F9ECF2E904046FD3A7EC_1982569232 = (d.hasWindowFocus());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_364796086 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_364796086;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2048952956 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1177805615 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1177805615;
        // ---------- Original Method ----------
        //Window w = getWindow();
        //if (w != null) {
            //View d = w.getDecorView();
            //if (d != null) {
                //return d.hasWindowFocus();
            //}
        //}
        //return false;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.275 -0400", hash_original_method = "1A094AE61005DB4CDA2599E7F0A4A230", hash_generated_method = "44464233B2185D03712D2D24EFC7C134")
    public boolean dispatchKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
        onUserInteraction();
        Window win = getWindow();
    if(win.superDispatchKeyEvent(event))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1057507335 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1098113461 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1098113461;
        } //End block
        View decor = mDecor;
    if(decor == null)        
        decor = win.getDecorView();
        boolean varBF82E21C802CE6A21A3A6850AAECC329_770046526 = (event.dispatch(this, decor != null
                ? decor.getKeyDispatcherState() : null, this));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_840383196 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_840383196;
        // ---------- Original Method ----------
        //onUserInteraction();
        //Window win = getWindow();
        //if (win.superDispatchKeyEvent(event)) {
            //return true;
        //}
        //View decor = mDecor;
        //if (decor == null) decor = win.getDecorView();
        //return event.dispatch(this, decor != null
                //? decor.getKeyDispatcherState() : null, this);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.276 -0400", hash_original_method = "1BC9E6494D7E888C2866773840EEFAF2", hash_generated_method = "E44DBA269512621DCECF539E73E67B22")
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        addTaint(event.getTaint());
        onUserInteraction();
    if(getWindow().superDispatchKeyShortcutEvent(event))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1601907832 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_83890866 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_83890866;
        } //End block
        boolean var156E4CB1D436F15C72AC6FC64572DBC8_1227368554 = (onKeyShortcut(event.getKeyCode(), event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2009408231 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2009408231;
        // ---------- Original Method ----------
        //onUserInteraction();
        //if (getWindow().superDispatchKeyShortcutEvent(event)) {
            //return true;
        //}
        //return onKeyShortcut(event.getKeyCode(), event);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.278 -0400", hash_original_method = "9C043C82D0E35283EE51DCEF499F92C6", hash_generated_method = "DEFBEBB1DC37682A5B1F4B3C30724823")
    public boolean dispatchTouchEvent(MotionEvent ev) {
        addTaint(ev.getTaint());
    if(ev.getAction() == MotionEvent.ACTION_DOWN)        
        {
            onUserInteraction();
        } //End block
    if(getWindow().superDispatchTouchEvent(ev))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_13385582 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_488484818 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_488484818;
        } //End block
        boolean var6A82C8DBC967C7DCA9B560132CC6DCB4_997259530 = (onTouchEvent(ev));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1979614535 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1979614535;
        // ---------- Original Method ----------
        //if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            //onUserInteraction();
        //}
        //if (getWindow().superDispatchTouchEvent(ev)) {
            //return true;
        //}
        //return onTouchEvent(ev);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.279 -0400", hash_original_method = "B4E564288E5B587F0E42C599C68E6C62", hash_generated_method = "69AFC24804AC3945842187406E530D20")
    public boolean dispatchTrackballEvent(MotionEvent ev) {
        addTaint(ev.getTaint());
        onUserInteraction();
    if(getWindow().superDispatchTrackballEvent(ev))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_37368897 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_567141105 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_567141105;
        } //End block
        boolean var29D71352E688331DEA01A8CD09B7572F_1886081400 = (onTrackballEvent(ev));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1240351519 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1240351519;
        // ---------- Original Method ----------
        //onUserInteraction();
        //if (getWindow().superDispatchTrackballEvent(ev)) {
            //return true;
        //}
        //return onTrackballEvent(ev);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.281 -0400", hash_original_method = "8A5C748F888ED0234B6228EEE9B28C6A", hash_generated_method = "B3BA89AEE31E9D88746DF3FB26AAAE83")
    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        addTaint(ev.getTaint());
        onUserInteraction();
    if(getWindow().superDispatchGenericMotionEvent(ev))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_2026862781 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2089731790 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2089731790;
        } //End block
        boolean varE3EC3986EBBB841CE7203BD438C75A8B_923820806 = (onGenericMotionEvent(ev));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1825437069 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1825437069;
        // ---------- Original Method ----------
        //onUserInteraction();
        //if (getWindow().superDispatchGenericMotionEvent(ev)) {
            //return true;
        //}
        //return onGenericMotionEvent(ev);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.282 -0400", hash_original_method = "E0DA176D51FB90EA428361841719B862", hash_generated_method = "6348A4D55F0FAFFA6B7C5433C8721116")
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        addTaint(event.getTaint());
        event.setClassName(getClass().getName());
        event.setPackageName(getPackageName());
        LayoutParams params = getWindow().getAttributes();
        boolean isFullScreen = (params.width == LayoutParams.MATCH_PARENT) &&
            (params.height == LayoutParams.MATCH_PARENT);
        event.setFullScreen(isFullScreen);
        CharSequence title = getTitle();
    if(!TextUtils.isEmpty(title))        
        {
            event.getText().add(title);
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_837577415 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2092068115 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2092068115;
        // ---------- Original Method ----------
        //event.setClassName(getClass().getName());
        //event.setPackageName(getPackageName());
        //LayoutParams params = getWindow().getAttributes();
        //boolean isFullScreen = (params.width == LayoutParams.MATCH_PARENT) &&
            //(params.height == LayoutParams.MATCH_PARENT);
        //event.setFullScreen(isFullScreen);
        //CharSequence title = getTitle();
        //if (!TextUtils.isEmpty(title)) {
           //event.getText().add(title);
        //}
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.283 -0400", hash_original_method = "8FB2859FE43E0606E21921E291A18BDA", hash_generated_method = "E1E33D436A6DF48F011B703081CA0CA7")
    public View onCreatePanelView(int featureId) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(featureId);
View var540C13E9E156B687226421B24F2DF178_1875277006 =         null;
        var540C13E9E156B687226421B24F2DF178_1875277006.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1875277006;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.284 -0400", hash_original_method = "3CEBC68A0556AFB2BA0DA511B7D323DE", hash_generated_method = "18711FAFFDC182B60ADB181E07A287BA")
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        addTaint(featureId);
    if(featureId == Window.FEATURE_OPTIONS_PANEL)        
        {
            boolean show = onCreateOptionsMenu(menu);
            show |= mFragments.dispatchCreateOptionsMenu(menu, getMenuInflater());
            boolean varA7DD12B1DAB17D25467B0B0A4C8D4A92_1770595524 = (show);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1640889850 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1640889850;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_119562637 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1981024442 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1981024442;
        // ---------- Original Method ----------
        //if (featureId == Window.FEATURE_OPTIONS_PANEL) {
            //boolean show = onCreateOptionsMenu(menu);
            //show |= mFragments.dispatchCreateOptionsMenu(menu, getMenuInflater());
            //return show;
        //}
        //return false;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.286 -0400", hash_original_method = "A6A8332EF2663DFC6EB1A100F6AD5BEC", hash_generated_method = "E003B9A8AC7BFB16B50FA7053412197C")
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        addTaint(view.getTaint());
        addTaint(featureId);
    if(featureId == Window.FEATURE_OPTIONS_PANEL && menu != null)        
        {
            boolean goforit = onPrepareOptionsMenu(menu);
            goforit |= mFragments.dispatchPrepareOptionsMenu(menu);
            boolean var6F30EC4F22FBB3CC309B851E4D801F61_1245972585 = (goforit && menu.hasVisibleItems());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1161366712 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1161366712;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1018274356 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_230866063 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_230866063;
        // ---------- Original Method ----------
        //if (featureId == Window.FEATURE_OPTIONS_PANEL && menu != null) {
            //boolean goforit = onPrepareOptionsMenu(menu);
            //goforit |= mFragments.dispatchPrepareOptionsMenu(menu);
            //return goforit && menu.hasVisibleItems();
        //}
        //return true;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.287 -0400", hash_original_method = "FE81CE57FF3B2984A6841999BDAFE276", hash_generated_method = "5D95BFE3C5848B8A0B32072678657119")
    public boolean onMenuOpened(int featureId, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        addTaint(featureId);
    if(featureId == Window.FEATURE_ACTION_BAR)        
        {
            initActionBar();
    if(mActionBar != null)            
            {
                mActionBar.dispatchMenuVisibilityChanged(true);
            } //End block
            else
            {
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1599146480 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_724575983 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_724575983;
        // ---------- Original Method ----------
        //if (featureId == Window.FEATURE_ACTION_BAR) {
            //initActionBar();
            //if (mActionBar != null) {
                //mActionBar.dispatchMenuVisibilityChanged(true);
            //} else {
                //Log.e(TAG, "Tried to open action bar menu with no action bar");
            //}
        //}
        //return true;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.289 -0400", hash_original_method = "06AE80A8039E39DC7E4DC1C38B6D66B0", hash_generated_method = "1B5167F4EC8CEC389611F3AACC458E04")
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(item.getTaint());
        addTaint(featureId);
switch(featureId){
        case Window.FEATURE_OPTIONS_PANEL:
        EventLog.writeEvent(50000, 0, item.getTitleCondensed());
    if(onOptionsItemSelected(item))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_28956644 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2031591624 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2031591624;
        } //End block
        boolean var35323F3748751EAB5CA55A38B5170D93_1967141923 = (mFragments.dispatchOptionsItemSelected(item));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2129128661 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2129128661;
        case Window.FEATURE_CONTEXT_MENU:
        EventLog.writeEvent(50000, 1, item.getTitleCondensed());
    if(onContextItemSelected(item))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1341905659 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1263583770 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1263583770;
        } //End block
        boolean varE8A1D72471F976E54718B2BDEBD8D841_179137791 = (mFragments.dispatchContextItemSelected(item));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1477114517 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1477114517;
        default:
        boolean var68934A3E9455FA72420237EB05902327_724426515 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1065125878 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1065125878;
}
        // ---------- Original Method ----------
        //switch (featureId) {
            //case Window.FEATURE_OPTIONS_PANEL:
                //EventLog.writeEvent(50000, 0, item.getTitleCondensed());
                //if (onOptionsItemSelected(item)) {
                    //return true;
                //}
                //return mFragments.dispatchOptionsItemSelected(item);
            //case Window.FEATURE_CONTEXT_MENU:
                //EventLog.writeEvent(50000, 1, item.getTitleCondensed());
                //if (onContextItemSelected(item)) {
                    //return true;
                //}
                //return mFragments.dispatchContextItemSelected(item);
            //default:
                //return false;
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.291 -0400", hash_original_method = "89E795D5B25B105016E6897E97159EA1", hash_generated_method = "3073ADBE88369183217FFC25CB501602")
    public void onPanelClosed(int featureId, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        addTaint(featureId);
switch(featureId){
        case Window.FEATURE_OPTIONS_PANEL:
        mFragments.dispatchOptionsMenuClosed(menu);
        onOptionsMenuClosed(menu);
        break;
        case Window.FEATURE_CONTEXT_MENU:
        onContextMenuClosed(menu);
        break;
        case Window.FEATURE_ACTION_BAR:
        initActionBar();
        mActionBar.dispatchMenuVisibilityChanged(false);
        break;
}
        // ---------- Original Method ----------
        //switch (featureId) {
            //case Window.FEATURE_OPTIONS_PANEL:
                //mFragments.dispatchOptionsMenuClosed(menu);
                //onOptionsMenuClosed(menu);
                //break;
            //case Window.FEATURE_CONTEXT_MENU:
                //onContextMenuClosed(menu);
                //break;
            //case Window.FEATURE_ACTION_BAR:
                //initActionBar();
                //mActionBar.dispatchMenuVisibilityChanged(false);
                //break;
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.292 -0400", hash_original_method = "319389EBA801B290FB41D02473EB2E9E", hash_generated_method = "E3CB03CA5E4EB5916215E567B4276E95")
    public void invalidateOptionsMenu() {
        mWindow.invalidatePanelMenu(Window.FEATURE_OPTIONS_PANEL);
        // ---------- Original Method ----------
        //mWindow.invalidatePanelMenu(Window.FEATURE_OPTIONS_PANEL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.294 -0400", hash_original_method = "D798A5E9CBD6E094B476E3BCFB506C48", hash_generated_method = "6573CCFDFB7E5A4FD2AC3A54209E2E78")
    public boolean onCreateOptionsMenu(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
    if(mParent != null)        
        {
            boolean varD96E941E82CE08DAA102D0C59A01D843_522684275 = (mParent.onCreateOptionsMenu(menu));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1279659792 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1279659792;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1874743987 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1417671460 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1417671460;
        // ---------- Original Method ----------
        //if (mParent != null) {
            //return mParent.onCreateOptionsMenu(menu);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.297 -0400", hash_original_method = "E91DC6A73B73F0C36C3453FFD6D52B27", hash_generated_method = "19A95D41E606A527D5CFD83B490D4A55")
    public boolean onPrepareOptionsMenu(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
    if(mParent != null)        
        {
            boolean var4401E280EC59859BB2BD091CD586ACC9_425953617 = (mParent.onPrepareOptionsMenu(menu));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1385854621 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1385854621;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1707756252 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_776131622 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_776131622;
        // ---------- Original Method ----------
        //if (mParent != null) {
            //return mParent.onPrepareOptionsMenu(menu);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.299 -0400", hash_original_method = "3F90928280ED0097B9620B898E691C1D", hash_generated_method = "6A48CB8EE9982105E1312D4A5B30B726")
    public boolean onOptionsItemSelected(MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(item.getTaint());
    if(mParent != null)        
        {
            boolean var856EDF6C43A8DDDE6F7D474592B1BF61_1278470860 = (mParent.onOptionsItemSelected(item));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_982817591 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_982817591;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_775378889 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_711711409 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_711711409;
        // ---------- Original Method ----------
        //if (mParent != null) {
            //return mParent.onOptionsItemSelected(item);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.300 -0400", hash_original_method = "F56CDE64C3E3D8A72B60F2808B2AA992", hash_generated_method = "F3C8AC8D4D546074AE2D7475FAA05D4F")
    public void onOptionsMenuClosed(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
    if(mParent != null)        
        {
            mParent.onOptionsMenuClosed(menu);
        } //End block
        // ---------- Original Method ----------
        //if (mParent != null) {
            //mParent.onOptionsMenuClosed(menu);
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.301 -0400", hash_original_method = "756759165F6AB2C8C6E469E63BE14186", hash_generated_method = "8F36C449192E9A4FC8F578B78BE7C244")
    public void openOptionsMenu() {
        mWindow.openPanel(Window.FEATURE_OPTIONS_PANEL, null);
        // ---------- Original Method ----------
        //mWindow.openPanel(Window.FEATURE_OPTIONS_PANEL, null);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.302 -0400", hash_original_method = "D12ED1735BBB9BCDCD831C99F03640D7", hash_generated_method = "249BD0BDCB652EF31D4B735086D0BDEC")
    public void closeOptionsMenu() {
        mWindow.closePanel(Window.FEATURE_OPTIONS_PANEL);
        // ---------- Original Method ----------
        //mWindow.closePanel(Window.FEATURE_OPTIONS_PANEL);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.304 -0400", hash_original_method = "85F2A519B2781A30F4BC68DB47459C98", hash_generated_method = "7E675DA5E9A426B1D0A463AC60958A2A")
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menuInfo.getTaint());
        addTaint(v.getTaint());
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.304 -0400", hash_original_method = "1A123249F7C2C892EA53E2F44D60C1FB", hash_generated_method = "A6804032F4A398F98AB72F29BB096EED")
    public void registerForContextMenu(View view) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(view.getTaint());
        view.setOnCreateContextMenuListener(this);
        // ---------- Original Method ----------
        //view.setOnCreateContextMenuListener(this);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.305 -0400", hash_original_method = "6A7E2B106BB1CEE7C3B668A773DE5A5B", hash_generated_method = "00514E90EA9081E765956475D78499EF")
    public void unregisterForContextMenu(View view) {
        addTaint(view.getTaint());
        view.setOnCreateContextMenuListener(null);
        // ---------- Original Method ----------
        //view.setOnCreateContextMenuListener(null);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.306 -0400", hash_original_method = "D1451DBD5DFD14FAE397660897192E3C", hash_generated_method = "C843096FC988D7D7DCCAAEBAE1988481")
    public void openContextMenu(View view) {
        addTaint(view.getTaint());
        view.showContextMenu();
        // ---------- Original Method ----------
        //view.showContextMenu();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.306 -0400", hash_original_method = "0F5BE8719D80390C88A4C0CDCF0E8C81", hash_generated_method = "A649B62C078D6DDA81669B8C50CB3152")
    public void closeContextMenu() {
        mWindow.closePanel(Window.FEATURE_CONTEXT_MENU);
        // ---------- Original Method ----------
        //mWindow.closePanel(Window.FEATURE_CONTEXT_MENU);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.307 -0400", hash_original_method = "BE982B537DFF57F9B4E6459A3621A4C0", hash_generated_method = "69EDCE3776D8724BD87796EA49AC933B")
    public boolean onContextItemSelected(MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(item.getTaint());
    if(mParent != null)        
        {
            boolean varB05C5A12805F3E7182E329CCC3AB220E_1994820492 = (mParent.onContextItemSelected(item));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1282885835 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1282885835;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_745094529 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_19012891 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_19012891;
        // ---------- Original Method ----------
        //if (mParent != null) {
            //return mParent.onContextItemSelected(item);
        //}
        //return false;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.309 -0400", hash_original_method = "3B89231032C2ACDB0A53B5E9B36C3177", hash_generated_method = "BE0C0A30F56B45929DE8A1643F8ED4F1")
    public void onContextMenuClosed(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
    if(mParent != null)        
        {
            mParent.onContextMenuClosed(menu);
        } //End block
        // ---------- Original Method ----------
        //if (mParent != null) {
            //mParent.onContextMenuClosed(menu);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.310 -0400", hash_original_method = "5C4ABBE5E4F27E10ACC00467798D80D8", hash_generated_method = "A988B897934DEBB2E6BB4FE57001DC6E")
    @Deprecated
    protected Dialog onCreateDialog(int id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(id);
Dialog var540C13E9E156B687226421B24F2DF178_2124559648 =         null;
        var540C13E9E156B687226421B24F2DF178_2124559648.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2124559648;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.311 -0400", hash_original_method = "34E3D2628A4C0BFC6C20A449A8141897", hash_generated_method = "14C0E75769DA36562ED17027AD9169C2")
    @Deprecated
    protected Dialog onCreateDialog(int id, Bundle args) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(args.getTaint());
        addTaint(id);
Dialog var81AE1E5544A9C501A1239924F7BA4153_770260445 =         onCreateDialog(id);
        var81AE1E5544A9C501A1239924F7BA4153_770260445.addTaint(taint);
        return var81AE1E5544A9C501A1239924F7BA4153_770260445;
        // ---------- Original Method ----------
        //return onCreateDialog(id);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.312 -0400", hash_original_method = "7779942926F36CBECCFB305682D0E188", hash_generated_method = "F386DE7A1CA657281C062B6C383C498A")
    @Deprecated
    protected void onPrepareDialog(int id, Dialog dialog) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(dialog.getTaint());
        addTaint(id);
        dialog.setOwnerActivity(this);
        // ---------- Original Method ----------
        //dialog.setOwnerActivity(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.313 -0400", hash_original_method = "5C5331293ECB563ADEBB709047E6FA90", hash_generated_method = "3FFA16741E821A8E14AB2EB0ABB452AE")
    @Deprecated
    protected void onPrepareDialog(int id, Dialog dialog, Bundle args) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(args.getTaint());
        addTaint(dialog.getTaint());
        addTaint(id);
        onPrepareDialog(id, dialog);
        // ---------- Original Method ----------
        //onPrepareDialog(id, dialog);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.314 -0400", hash_original_method = "C69337B465910082B7749F46A60AEA22", hash_generated_method = "66114C3E196080B18AB26ACCF8E1E5EA")
    @Deprecated
    public final void showDialog(int id) {
        addTaint(id);
        showDialog(id, null);
        // ---------- Original Method ----------
        //showDialog(id, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:35.316 -0400", hash_original_method = "3DD1E3020EFCD44C0CA311C29E1CC42D", hash_generated_method = "BF5F23A3F14C525C516281CBF942926B")
    @Deprecated
    public final boolean showDialog(int id, Bundle args) {
        addTaint(args.getTaint());
        addTaint(id);
    if(mManagedDialogs == null)        
        {
            mManagedDialogs = new SparseArray<ManagedDialog>();
        } //End block
        ManagedDialog md = mManagedDialogs.get(id);
    if(md == null)        
        {
            md = new ManagedDialog();
            md.mDialog = createDialog(id, null, args);
    if(md.mDialog == null)            
            {
                boolean var68934A3E9455FA72420237EB05902327_739242928 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1509776620 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1509776620;
            } //End block
            mManagedDialogs.put(id, md);
        } //End block
        md.mArgs = args;
        onPrepareDialog(id, md.mDialog, args);
        md.mDialog.show();
        boolean varB326B5062B2F0E69046810717534CB09_1550539332 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1212234192 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1212234192;
        // ---------- Original Method ----------
        //if (mManagedDialogs == null) {
            //mManagedDialogs = new SparseArray<ManagedDialog>();
        //}
        //ManagedDialog md = mManagedDialogs.get(id);
        //if (md == null) {
            //md = new ManagedDialog();
            //md.mDialog = createDialog(id, null, args);
            //if (md.mDialog == null) {
                //return false;
            //}
            //mManagedDialogs.put(id, md);
        //}
        //md.mArgs = args;
        //onPrepareDialog(id, md.mDialog, args);
        //md.mDialog.show();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.838 -0400", hash_original_method = "E601E473B0753C1FEDA76812E1FD9E58", hash_generated_method = "EEC6F585A1D0B98730B4858E2ADF1859")
    @Deprecated
    public final void dismissDialog(int id) {
        addTaint(id);
    if(mManagedDialogs == null)        
        {
            java.lang.IllegalArgumentException var1458FF18995E112CFB9082A00E23E847_1048966461 = missingDialog(id);
            var1458FF18995E112CFB9082A00E23E847_1048966461.addTaint(taint);
            throw var1458FF18995E112CFB9082A00E23E847_1048966461;
        } //End block
        final ManagedDialog md = mManagedDialogs.get(id);
    if(md == null)        
        {
            java.lang.IllegalArgumentException var1458FF18995E112CFB9082A00E23E847_1698788221 = missingDialog(id);
            var1458FF18995E112CFB9082A00E23E847_1698788221.addTaint(taint);
            throw var1458FF18995E112CFB9082A00E23E847_1698788221;
        } //End block
        md.mDialog.dismiss();
        // ---------- Original Method ----------
        //if (mManagedDialogs == null) {
            //throw missingDialog(id);
        //}
        //final ManagedDialog md = mManagedDialogs.get(id);
        //if (md == null) {
            //throw missingDialog(id);
        //}
        //md.mDialog.dismiss();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.840 -0400", hash_original_method = "A39236F46CF5FE1491F0C82DFDF249BB", hash_generated_method = "1C2B9ABAE6C583CCD9E79309C986EA1B")
    private IllegalArgumentException missingDialog(int id) {
        addTaint(id);
IllegalArgumentException varF923491F341D495D075C7404868A6E39_16961720 =         new IllegalArgumentException("no dialog with id " + id + " was ever "
                + "shown via Activity#showDialog");
        varF923491F341D495D075C7404868A6E39_16961720.addTaint(taint);
        return varF923491F341D495D075C7404868A6E39_16961720;
        // ---------- Original Method ----------
        //return new IllegalArgumentException("no dialog with id " + id + " was ever "
                //+ "shown via Activity#showDialog");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.841 -0400", hash_original_method = "3D1D9959965F7A331D31AA1B43803DC2", hash_generated_method = "20B4183221AADCCF8A08BE3292DEDF01")
    @Deprecated
    public final void removeDialog(int id) {
        addTaint(id);
    if(mManagedDialogs != null)        
        {
            final ManagedDialog md = mManagedDialogs.get(id);
    if(md != null)            
            {
                md.mDialog.dismiss();
                mManagedDialogs.remove(id);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mManagedDialogs != null) {
            //final ManagedDialog md = mManagedDialogs.get(id);
            //if (md != null) {
                //md.mDialog.dismiss();
                //mManagedDialogs.remove(id);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.843 -0400", hash_original_method = "0DF3BA4E928401133F2B75C6B5EB4631", hash_generated_method = "5627BFECC1D4FA68B9AFEE4AC5DECC5B")
    public boolean onSearchRequested() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        startSearch(null, false, null, false);
        boolean varB326B5062B2F0E69046810717534CB09_370822650 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_356365949 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_356365949;
        // ---------- Original Method ----------
        //startSearch(null, false, null, false);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.844 -0400", hash_original_method = "E294F26A29AF2F9D8B2D38BC4A0138F5", hash_generated_method = "59D4FA580851332125A71AA86B3E02C6")
    public void startSearch(String initialQuery, boolean selectInitialQuery, 
            Bundle appSearchData, boolean globalSearch) {
        addTaint(globalSearch);
        addTaint(appSearchData.getTaint());
        addTaint(selectInitialQuery);
        addTaint(initialQuery.getTaint());
        ensureSearchManager();
        mSearchManager.startSearch(initialQuery, selectInitialQuery, getComponentName(),
                        appSearchData, globalSearch);
        // ---------- Original Method ----------
        //ensureSearchManager();
        //mSearchManager.startSearch(initialQuery, selectInitialQuery, getComponentName(),
                        //appSearchData, globalSearch);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.845 -0400", hash_original_method = "A3EE90277ACB35FF640742FD629291A1", hash_generated_method = "39250BBC5265239A0291CB4FABE0F95B")
    public void triggerSearch(String query, Bundle appSearchData) {
        addTaint(appSearchData.getTaint());
        addTaint(query.getTaint());
        ensureSearchManager();
        mSearchManager.triggerSearch(query, getComponentName(), appSearchData);
        // ---------- Original Method ----------
        //ensureSearchManager();
        //mSearchManager.triggerSearch(query, getComponentName(), appSearchData);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.845 -0400", hash_original_method = "0192041795732D663EE503A2AEC04112", hash_generated_method = "2528EEA1BD09164579645D25F18D401F")
    public void takeKeyEvents(boolean get) {
        addTaint(get);
        getWindow().takeKeyEvents(get);
        // ---------- Original Method ----------
        //getWindow().takeKeyEvents(get);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.846 -0400", hash_original_method = "3CDF417FCD4F33EAE6CFCF0FB6D583A8", hash_generated_method = "CBC76E60B33F5431874C2F7F6358241E")
    public final boolean requestWindowFeature(int featureId) {
        addTaint(featureId);
        boolean varE4F9C4B29456CD18692A96646504123C_1960079934 = (getWindow().requestFeature(featureId));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1169083468 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1169083468;
        // ---------- Original Method ----------
        //return getWindow().requestFeature(featureId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.847 -0400", hash_original_method = "E7AFD534CB1DF8060614ED36111B2407", hash_generated_method = "2BFA4306CBED4C696B6B062B629554E3")
    public final void setFeatureDrawableResource(int featureId, int resId) {
        addTaint(resId);
        addTaint(featureId);
        getWindow().setFeatureDrawableResource(featureId, resId);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawableResource(featureId, resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.847 -0400", hash_original_method = "2E53659D6309BF8C5C8E8AD82BD6A577", hash_generated_method = "29B383C4D5EDB762E45EC352A7CB31AA")
    public final void setFeatureDrawableUri(int featureId, Uri uri) {
        addTaint(uri.getTaint());
        addTaint(featureId);
        getWindow().setFeatureDrawableUri(featureId, uri);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawableUri(featureId, uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.848 -0400", hash_original_method = "D3FA0A5870730A6F3C959B16FC004BCD", hash_generated_method = "C76B89C9812B57A2354090A517CBDED8")
    public final void setFeatureDrawable(int featureId, Drawable drawable) {
        addTaint(drawable.getTaint());
        addTaint(featureId);
        getWindow().setFeatureDrawable(featureId, drawable);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawable(featureId, drawable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.849 -0400", hash_original_method = "4D2A81FF8C2C83F47460DEB3120C04CB", hash_generated_method = "22F02FBFF89811CD2F189F47D063D4BD")
    public final void setFeatureDrawableAlpha(int featureId, int alpha) {
        addTaint(alpha);
        addTaint(featureId);
        getWindow().setFeatureDrawableAlpha(featureId, alpha);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawableAlpha(featureId, alpha);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.850 -0400", hash_original_method = "2F200E491A9F2CDC38C392035D21ED48", hash_generated_method = "1A13B7D22ED0D97D7C081D7B07FD5E63")
    public LayoutInflater getLayoutInflater() {
LayoutInflater var8D6DD3C28714B51EAA9625A43B68EFD5_936446745 =         getWindow().getLayoutInflater();
        var8D6DD3C28714B51EAA9625A43B68EFD5_936446745.addTaint(taint);
        return var8D6DD3C28714B51EAA9625A43B68EFD5_936446745;
        // ---------- Original Method ----------
        //return getWindow().getLayoutInflater();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.852 -0400", hash_original_method = "E3707649B39EF110B7161F89DE89D715", hash_generated_method = "D53497D9732AF7016124F17FE38B479B")
    public MenuInflater getMenuInflater() {
    if(mMenuInflater == null)        
        {
            initActionBar();
    if(mActionBar != null)            
            {
                mMenuInflater = new MenuInflater(mActionBar.getThemedContext());
            } //End block
            else
            {
                mMenuInflater = new MenuInflater(this);
            } //End block
        } //End block
MenuInflater var187373E2504A47A2DAB1AEF3DE2600F6_158407632 =         mMenuInflater;
        var187373E2504A47A2DAB1AEF3DE2600F6_158407632.addTaint(taint);
        return var187373E2504A47A2DAB1AEF3DE2600F6_158407632;
        // ---------- Original Method ----------
        //if (mMenuInflater == null) {
            //initActionBar();
            //if (mActionBar != null) {
                //mMenuInflater = new MenuInflater(mActionBar.getThemedContext());
            //} else {
                //mMenuInflater = new MenuInflater(this);
            //}
        //}
        //return mMenuInflater;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.854 -0400", hash_original_method = "4857987668195170B5763D3AC5F48499", hash_generated_method = "CEC9DE7A1B84DBBBFDA41574CE295631")
    @Override
    protected void onApplyThemeResource(Resources.Theme theme, int resid,
            boolean first) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(first);
        addTaint(resid);
        addTaint(theme.getTaint());
    if(mParent == null)        
        {
            super.onApplyThemeResource(theme, resid, first);
        } //End block
        else
        {
            try 
            {
                theme.setTo(mParent.getTheme());
            } //End block
            catch (Exception e)
            {
            } //End block
            theme.applyStyle(resid, false);
        } //End block
        // ---------- Original Method ----------
        //if (mParent == null) {
            //super.onApplyThemeResource(theme, resid, first);
        //} else {
            //try {
                //theme.setTo(mParent.getTheme());
            //} catch (Exception e) {
            //}
            //theme.applyStyle(resid, false);
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.857 -0400", hash_original_method = "30D6BE1E6EC7F84FBEF609A16BE7CA4B", hash_generated_method = "F4814DD31E058CB10EBB0F6C36DE033F")
    public void startActivityForResult(Intent intent, int requestCode) {
        addTaint(requestCode);
        addTaint(intent.getTaint());
    if(mParent == null)        
        {
            Instrumentation.ActivityResult ar = mInstrumentation.execStartActivity(
                    this, mMainThread.getApplicationThread(), mToken, this,
                    intent, requestCode);
    if(ar != null)            
            {
                mMainThread.sendActivityResult(
                    mToken, mEmbeddedID, requestCode, ar.getResultCode(),
                    ar.getResultData());
            } //End block
    if(requestCode >= 0)            
            {
                mStartedActivity = true;
            } //End block
        } //End block
        else
        {
            mParent.startActivityFromChild(this, intent, requestCode);
        } //End block
        // ---------- Original Method ----------
        //if (mParent == null) {
            //Instrumentation.ActivityResult ar =
                //mInstrumentation.execStartActivity(
                    //this, mMainThread.getApplicationThread(), mToken, this,
                    //intent, requestCode);
            //if (ar != null) {
                //mMainThread.sendActivityResult(
                    //mToken, mEmbeddedID, requestCode, ar.getResultCode(),
                    //ar.getResultData());
            //}
            //if (requestCode >= 0) {
                //mStartedActivity = true;
            //}
        //} else {
            //mParent.startActivityFromChild(this, intent, requestCode);
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.861 -0400", hash_original_method = "97600DFB6FE5B26D9938AA60DE8024CD", hash_generated_method = "1D223F8F806944C6EFE803AF8DD0B4E7")
    public void startIntentSenderForResult(IntentSender intent, int requestCode,
            Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        addTaint(extraFlags);
        addTaint(flagsValues);
        addTaint(flagsMask);
        addTaint(fillInIntent.getTaint());
        addTaint(requestCode);
        addTaint(intent.getTaint());
    if(mParent == null)        
        {
            startIntentSenderForResultInner(intent, requestCode, fillInIntent,
                    flagsMask, flagsValues, this);
        } //End block
        else
        {
            mParent.startIntentSenderFromChild(this, intent, requestCode,
                    fillInIntent, flagsMask, flagsValues, extraFlags);
        } //End block
        // ---------- Original Method ----------
        //if (mParent == null) {
            //startIntentSenderForResultInner(intent, requestCode, fillInIntent,
                    //flagsMask, flagsValues, this);
        //} else {
            //mParent.startIntentSenderFromChild(this, intent, requestCode,
                    //fillInIntent, flagsMask, flagsValues, extraFlags);
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.865 -0400", hash_original_method = "5FAE47F5C92447A2EE7F29A0B33663DC", hash_generated_method = "2D9574CC72D7AFC0EDE524B653BD3B2F")
    private void startIntentSenderForResultInner(IntentSender intent, int requestCode,
            Intent fillInIntent, int flagsMask, int flagsValues, Activity activity) throws IntentSender.SendIntentException {
        addTaint(activity.getTaint());
        addTaint(flagsValues);
        addTaint(flagsMask);
        addTaint(fillInIntent.getTaint());
        addTaint(requestCode);
        addTaint(intent.getTaint());
        try 
        {
            String resolvedType = null;
    if(fillInIntent != null)            
            {
                fillInIntent.setAllowFds(false);
                resolvedType = fillInIntent.resolveTypeIfNeeded(getContentResolver());
            } //End block
            int result = ActivityManagerNative.getDefault()
                .startActivityIntentSender(mMainThread.getApplicationThread(), intent,
                        fillInIntent, resolvedType, mToken, activity.mEmbeddedID,
                        requestCode, flagsMask, flagsValues);
    if(result == IActivityManager.START_CANCELED)            
            {
                IntentSender.SendIntentException var60287FF7293661812F3B04B1C75E0F5D_2079895417 = new IntentSender.SendIntentException();
                var60287FF7293661812F3B04B1C75E0F5D_2079895417.addTaint(taint);
                throw var60287FF7293661812F3B04B1C75E0F5D_2079895417;
            } //End block
            Instrumentation.checkStartActivityResult(result, null);
        } //End block
        catch (RemoteException e)
        {
        } //End block
    if(requestCode >= 0)        
        {
            mStartedActivity = true;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.867 -0400", hash_original_method = "496A47C2900A9596F27A50B4876A4F74", hash_generated_method = "F3FCEF4B3157F06DF4A6B8A7932F91A3")
    @Override
    public void startActivity(Intent intent) {
        addTaint(intent.getTaint());
        startActivityForResult(intent, -1);
        // ---------- Original Method ----------
        //startActivityForResult(intent, -1);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.868 -0400", hash_original_method = "E2A55AFC4750254BD88786F18353EE8B", hash_generated_method = "04B1CA52502B54CC7EE3436D59A3C4FA")
    @Override
    public void startActivities(Intent[] intents) {
        addTaint(intents[0].getTaint());
        mInstrumentation.execStartActivities(this, mMainThread.getApplicationThread(),
                mToken, this, intents);
        // ---------- Original Method ----------
        //mInstrumentation.execStartActivities(this, mMainThread.getApplicationThread(),
                //mToken, this, intents);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.869 -0400", hash_original_method = "9F69F403C1C5722F41E10FF600B75C73", hash_generated_method = "220E0F9A27AA79558D6406C9D284D968")
    public void startIntentSender(IntentSender intent,
            Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        addTaint(extraFlags);
        addTaint(flagsValues);
        addTaint(flagsMask);
        addTaint(fillInIntent.getTaint());
        addTaint(intent.getTaint());
        startIntentSenderForResult(intent, -1, fillInIntent, flagsMask,
                flagsValues, extraFlags);
        // ---------- Original Method ----------
        //startIntentSenderForResult(intent, -1, fillInIntent, flagsMask,
                //flagsValues, extraFlags);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.872 -0400", hash_original_method = "190134DCA27346A23C03C3693BD2B9AA", hash_generated_method = "3A52644D443B5828F2C1BED2D03CD6BA")
    public boolean startActivityIfNeeded(Intent intent, int requestCode) {
        addTaint(requestCode);
        addTaint(intent.getTaint());
    if(mParent == null)        
        {
            int result = IActivityManager.START_RETURN_INTENT_TO_CALLER;
            try 
            {
                intent.setAllowFds(false);
                result = ActivityManagerNative.getDefault()
                    .startActivity(mMainThread.getApplicationThread(),
                            intent, intent.resolveTypeIfNeeded(
                                    getContentResolver()),
                            null, 0,
                            mToken, mEmbeddedID, requestCode, true, false,
                            null, null, false);
            } //End block
            catch (RemoteException e)
            {
            } //End block
            Instrumentation.checkStartActivityResult(result, intent);
    if(requestCode >= 0)            
            {
                mStartedActivity = true;
            } //End block
            boolean var45DB7B8BD7790B71117CBA3A2E471DE6_1394594186 = (result != IActivityManager.START_RETURN_INTENT_TO_CALLER);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_497034829 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_497034829;
        } //End block
        UnsupportedOperationException var8BA33EF0B29B5FCA67A0ABADFC16B2EE_345202390 = new UnsupportedOperationException(
            "startActivityIfNeeded can only be called from a top-level activity");
        var8BA33EF0B29B5FCA67A0ABADFC16B2EE_345202390.addTaint(taint);
        throw var8BA33EF0B29B5FCA67A0ABADFC16B2EE_345202390;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.877 -0400", hash_original_method = "BA57A0705EEE92F3B7079102E9F6CF18", hash_generated_method = "B3E2D7BEDF9B516871C43DC05A6FF31E")
    public boolean startNextMatchingActivity(Intent intent) {
        addTaint(intent.getTaint());
    if(mParent == null)        
        {
            try 
            {
                intent.setAllowFds(false);
                boolean var55C32C92E6D6AC9A69A73EF4C9829F6A_1147475347 = (ActivityManagerNative.getDefault()
                    .startNextMatchingActivity(mToken, intent));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_567010728 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_567010728;
            } //End block
            catch (RemoteException e)
            {
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_702238040 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_224402326 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_224402326;
        } //End block
        UnsupportedOperationException var2977A5B5CB682630D4B1E606A7D7E634_2144729090 = new UnsupportedOperationException(
            "startNextMatchingActivity can only be called from a top-level activity");
        var2977A5B5CB682630D4B1E606A7D7E634_2144729090.addTaint(taint);
        throw var2977A5B5CB682630D4B1E606A7D7E634_2144729090;
        // ---------- Original Method ----------
        //if (mParent == null) {
            //try {
                //intent.setAllowFds(false);
                //return ActivityManagerNative.getDefault()
                    //.startNextMatchingActivity(mToken, intent);
            //} catch (RemoteException e) {
            //}
            //return false;
        //}
        //throw new UnsupportedOperationException(
            //"startNextMatchingActivity can only be called from a top-level activity");
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.880 -0400", hash_original_method = "DF04C3C173E07E956B29F2B3DAB7E481", hash_generated_method = "E32DCEDF8749D171C6F84266579AA3A3")
    public void startActivityFromChild(Activity child, Intent intent, 
            int requestCode) {
        addTaint(requestCode);
        addTaint(intent.getTaint());
        addTaint(child.getTaint());
        Instrumentation.ActivityResult ar = mInstrumentation.execStartActivity(
                this, mMainThread.getApplicationThread(), mToken, child,
                intent, requestCode);
    if(ar != null)        
        {
            mMainThread.sendActivityResult(
                mToken, child.mEmbeddedID, requestCode,
                ar.getResultCode(), ar.getResultData());
        } //End block
        // ---------- Original Method ----------
        //Instrumentation.ActivityResult ar =
            //mInstrumentation.execStartActivity(
                //this, mMainThread.getApplicationThread(), mToken, child,
                //intent, requestCode);
        //if (ar != null) {
            //mMainThread.sendActivityResult(
                //mToken, child.mEmbeddedID, requestCode,
                //ar.getResultCode(), ar.getResultData());
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.882 -0400", hash_original_method = "5E733A6053D527FE1D06898E4868AC5B", hash_generated_method = "1DAD73BE8902BEBDCA78EFFAE1338421")
    public void startActivityFromFragment(Fragment fragment, Intent intent, 
            int requestCode) {
        addTaint(requestCode);
        addTaint(intent.getTaint());
        addTaint(fragment.getTaint());
        Instrumentation.ActivityResult ar = mInstrumentation.execStartActivity(
                this, mMainThread.getApplicationThread(), mToken, fragment,
                intent, requestCode);
    if(ar != null)        
        {
            mMainThread.sendActivityResult(
                mToken, fragment.mWho, requestCode,
                ar.getResultCode(), ar.getResultData());
        } //End block
        // ---------- Original Method ----------
        //Instrumentation.ActivityResult ar =
            //mInstrumentation.execStartActivity(
                //this, mMainThread.getApplicationThread(), mToken, fragment,
                //intent, requestCode);
        //if (ar != null) {
            //mMainThread.sendActivityResult(
                //mToken, fragment.mWho, requestCode,
                //ar.getResultCode(), ar.getResultData());
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.884 -0400", hash_original_method = "39BD7073F28230B53A756B456127D77C", hash_generated_method = "3BDBF66DDCBF7B53B632E13DABD6AF11")
    public void startIntentSenderFromChild(Activity child, IntentSender intent,
            int requestCode, Intent fillInIntent, int flagsMask, int flagsValues,
            int extraFlags) throws IntentSender.SendIntentException {
        addTaint(extraFlags);
        addTaint(flagsValues);
        addTaint(flagsMask);
        addTaint(fillInIntent.getTaint());
        addTaint(requestCode);
        addTaint(intent.getTaint());
        addTaint(child.getTaint());
        startIntentSenderForResultInner(intent, requestCode, fillInIntent,
                flagsMask, flagsValues, child);
        // ---------- Original Method ----------
        //startIntentSenderForResultInner(intent, requestCode, fillInIntent,
                //flagsMask, flagsValues, child);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.887 -0400", hash_original_method = "0CB07497B5E56C46E5A71AB5CB4CC143", hash_generated_method = "19B37EEA3632138FAF34E4E8C305331D")
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        addTaint(exitAnim);
        addTaint(enterAnim);
        try 
        {
            ActivityManagerNative.getDefault().overridePendingTransition(
                    mToken, getPackageName(), enterAnim, exitAnim);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().overridePendingTransition(
                    //mToken, getPackageName(), enterAnim, exitAnim);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.888 -0400", hash_original_method = "A1F0E9D1C51A75D776561E1E894349B6", hash_generated_method = "AB1BFE0A2A1DA85099E2F7E869C01D49")
    public final void setResult(int resultCode) {
        synchronized
(this)        {
            mResultCode = resultCode;
            mResultData = null;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //mResultCode = resultCode;
            //mResultData = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.889 -0400", hash_original_method = "6BED503DFB65A20EFD511A0C71BBBEA5", hash_generated_method = "4025500A9753BD3FA3EFACDCB39D6F49")
    public final void setResult(int resultCode, Intent data) {
        synchronized
(this)        {
            mResultCode = resultCode;
            mResultData = data;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //mResultCode = resultCode;
            //mResultData = data;
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.890 -0400", hash_original_method = "88476E01B039440C5805C3F210A00F20", hash_generated_method = "84DF3F024FC2DE865875DA46ED558E70")
    public String getCallingPackage() {
        try 
        {
String var44E777B8C062FE777BFA764E6F527F23_756946258 =             ActivityManagerNative.getDefault().getCallingPackage(mToken);
            var44E777B8C062FE777BFA764E6F527F23_756946258.addTaint(taint);
            return var44E777B8C062FE777BFA764E6F527F23_756946258;
        } //End block
        catch (RemoteException e)
        {
String var540C13E9E156B687226421B24F2DF178_842813305 =             null;
            var540C13E9E156B687226421B24F2DF178_842813305.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_842813305;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getCallingPackage(mToken);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.892 -0400", hash_original_method = "BA5844B2C9F3C6D12393731B7AECDFB9", hash_generated_method = "D8F3D94C3229CE9DE765E162DC2CBC9C")
    public ComponentName getCallingActivity() {
        try 
        {
ComponentName var6CB99819E271803AF1CF0279667F1B25_657886295 =             ActivityManagerNative.getDefault().getCallingActivity(mToken);
            var6CB99819E271803AF1CF0279667F1B25_657886295.addTaint(taint);
            return var6CB99819E271803AF1CF0279667F1B25_657886295;
        } //End block
        catch (RemoteException e)
        {
ComponentName var540C13E9E156B687226421B24F2DF178_972069781 =             null;
            var540C13E9E156B687226421B24F2DF178_972069781.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_972069781;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getCallingActivity(mToken);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.893 -0400", hash_original_method = "0E2F74853BCADD728740841EA37367F9", hash_generated_method = "1777983C571C8A6920CF7BFA5CCB66B2")
    public void setVisible(boolean visible) {
    if(mVisibleFromClient != visible)        
        {
            mVisibleFromClient = visible;
    if(mVisibleFromServer)            
            {
    if(visible)                
                makeVisible();
                else
                mDecor.setVisibility(View.INVISIBLE);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mVisibleFromClient != visible) {
            //mVisibleFromClient = visible;
            //if (mVisibleFromServer) {
                //if (visible) makeVisible();
                //else mDecor.setVisibility(View.INVISIBLE);
            //}
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.895 -0400", hash_original_method = "FB761D67DEFD95C853371C7404DC7410", hash_generated_method = "0453EF5CF0E643EA9E48C1625AB43499")
     void makeVisible() {
    if(!mWindowAdded)        
        {
            ViewManager wm = getWindowManager();
            wm.addView(mDecor, getWindow().getAttributes());
            mWindowAdded = true;
        } //End block
        mDecor.setVisibility(View.VISIBLE);
        // ---------- Original Method ----------
        //if (!mWindowAdded) {
            //ViewManager wm = getWindowManager();
            //wm.addView(mDecor, getWindow().getAttributes());
            //mWindowAdded = true;
        //}
        //mDecor.setVisibility(View.VISIBLE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.897 -0400", hash_original_method = "43D5EE376AB6A31BE07F9DEA063A3A15", hash_generated_method = "A08BBCB449AB5DFCD641D2BBFC61CBC8")
    public boolean isFinishing() {
        boolean varBB077E6B2FCDFA3F0EF71EB099A18F49_1317605146 = (mFinished);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2056932364 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2056932364;
        // ---------- Original Method ----------
        //return mFinished;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.901 -0400", hash_original_method = "FE2E80A11740332998069879BC688861", hash_generated_method = "E0F29F9C79F5962759CC6A78D615AE1D")
    public boolean isChangingConfigurations() {
        boolean var276E0645C4E2084773D0EB8C5576428C_1787461040 = (mChangingConfigurations);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1268257134 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1268257134;
        // ---------- Original Method ----------
        //return mChangingConfigurations;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.903 -0400", hash_original_method = "3298831B26ECD21F1FDB51A320DC7BE6", hash_generated_method = "CE032E19F0C1EB9DFA271DD9FC94A33F")
    public void recreate() {
    if(mParent != null)        
        {
            IllegalStateException var0ED880132F5570D75F4C90A32358CCF4_410705981 = new IllegalStateException("Can only be called on top-level activity");
            var0ED880132F5570D75F4C90A32358CCF4_410705981.addTaint(taint);
            throw var0ED880132F5570D75F4C90A32358CCF4_410705981;
        } //End block
    if(Looper.myLooper() != mMainThread.getLooper())        
        {
            IllegalStateException var94D80F308A9160D52F9E1A5E01D86818_1591228456 = new IllegalStateException("Must be called from main thread");
            var94D80F308A9160D52F9E1A5E01D86818_1591228456.addTaint(taint);
            throw var94D80F308A9160D52F9E1A5E01D86818_1591228456;
        } //End block
        mMainThread.requestRelaunchActivity(mToken, null, null, 0, false, null, false);
        // ---------- Original Method ----------
        //if (mParent != null) {
            //throw new IllegalStateException("Can only be called on top-level activity");
        //}
        //if (Looper.myLooper() != mMainThread.getLooper()) {
            //throw new IllegalStateException("Must be called from main thread");
        //}
        //mMainThread.requestRelaunchActivity(mToken, null, null, 0, false, null, false);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.906 -0400", hash_original_method = "996A5282391C6D355ADB156CA1D0ED89", hash_generated_method = "A31B08937117ECC1CD6832CE18BFEEC2")
    public void finish() {
    if(mParent == null)        
        {
            int resultCode;
            Intent resultData;
            synchronized
(this)            {
                resultCode = mResultCode;
                resultData = mResultData;
            } //End block
    if(false){ }            try 
            {
    if(resultData != null)                
                {
                    resultData.setAllowFds(false);
                } //End block
    if(ActivityManagerNative.getDefault()
                    .finishActivity(mToken, resultCode, resultData))                
                {
                    mFinished = true;
                } //End block
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        else
        {
            mParent.finishFromChild(this);
        } //End block
        // ---------- Original Method ----------
        //if (mParent == null) {
            //int resultCode;
            //Intent resultData;
            //synchronized (this) {
                //resultCode = mResultCode;
                //resultData = mResultData;
            //}
            //if (false) Log.v(TAG, "Finishing self: token=" + mToken);
            //try {
                //if (resultData != null) {
                    //resultData.setAllowFds(false);
                //}
                //if (ActivityManagerNative.getDefault()
                    //.finishActivity(mToken, resultCode, resultData)) {
                    //mFinished = true;
                //}
            //} catch (RemoteException e) {
            //}
        //} else {
            //mParent.finishFromChild(this);
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.908 -0400", hash_original_method = "75F7E4E1E03EB9263BD8694C580B708B", hash_generated_method = "FDB250C425926E7D9C31622EFC165368")
    public void finishFromChild(Activity child) {
        addTaint(child.getTaint());
        finish();
        // ---------- Original Method ----------
        //finish();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.910 -0400", hash_original_method = "5ADA8FCD727B0FDDA383F561FB00E0D6", hash_generated_method = "95E21E23FA2FB2F3750F656D7E5EDDE2")
    public void finishActivity(int requestCode) {
        addTaint(requestCode);
    if(mParent == null)        
        {
            try 
            {
                ActivityManagerNative.getDefault()
                    .finishSubActivity(mToken, mEmbeddedID, requestCode);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        else
        {
            mParent.finishActivityFromChild(this, requestCode);
        } //End block
        // ---------- Original Method ----------
        //if (mParent == null) {
            //try {
                //ActivityManagerNative.getDefault()
                    //.finishSubActivity(mToken, mEmbeddedID, requestCode);
            //} catch (RemoteException e) {
            //}
        //} else {
            //mParent.finishActivityFromChild(this, requestCode);
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.911 -0400", hash_original_method = "78F43A087FD65470CED68BD5979667B7", hash_generated_method = "3C052A3C4712E340F1C764D0B5F6E8E4")
    public void finishActivityFromChild(Activity child, int requestCode) {
        addTaint(requestCode);
        addTaint(child.getTaint());
        try 
        {
            ActivityManagerNative.getDefault()
                .finishSubActivity(mToken, child.mEmbeddedID, requestCode);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault()
                //.finishSubActivity(mToken, child.mEmbeddedID, requestCode);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.912 -0400", hash_original_method = "6D8F676326F7C192A2903AC6F4C36AC9", hash_generated_method = "3DA28B5DC00E687708DEC88E536B036B")
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(data.getTaint());
        addTaint(resultCode);
        addTaint(requestCode);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.913 -0400", hash_original_method = "724A566EB4440BBE32F479663ADACFA1", hash_generated_method = "059DADCBF23DCE7457B5853CB384C157")
    public PendingIntent createPendingResult(int requestCode, Intent data,
            int flags) {
        addTaint(flags);
        addTaint(data.getTaint());
        addTaint(requestCode);
        String packageName = getPackageName();
        try 
        {
            data.setAllowFds(false);
            IIntentSender target = ActivityManagerNative.getDefault().getIntentSender(
                        IActivityManager.INTENT_SENDER_ACTIVITY_RESULT, packageName,
                        mParent == null ? mToken : mParent.mToken,
                        mEmbeddedID, requestCode, new Intent[] { data }, null, flags);
PendingIntent var28A462FA0C3D8BAAC1D3C7F9744D6F45_1536774747 =             target != null ? new PendingIntent(target) : null;
            var28A462FA0C3D8BAAC1D3C7F9744D6F45_1536774747.addTaint(taint);
            return var28A462FA0C3D8BAAC1D3C7F9744D6F45_1536774747;
        } //End block
        catch (RemoteException e)
        {
        } //End block
PendingIntent var540C13E9E156B687226421B24F2DF178_1061124996 =         null;
        var540C13E9E156B687226421B24F2DF178_1061124996.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1061124996;
        // ---------- Original Method ----------
        //String packageName = getPackageName();
        //try {
            //data.setAllowFds(false);
            //IIntentSender target =
                //ActivityManagerNative.getDefault().getIntentSender(
                        //IActivityManager.INTENT_SENDER_ACTIVITY_RESULT, packageName,
                        //mParent == null ? mToken : mParent.mToken,
                        //mEmbeddedID, requestCode, new Intent[] { data }, null, flags);
            //return target != null ? new PendingIntent(target) : null;
        //} catch (RemoteException e) {
        //}
        //return null;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.915 -0400", hash_original_method = "AB602316CD63B19CFF08DCE67D0ABE67", hash_generated_method = "856B5C618E839CC3F0D7FE4A659B2A1A")
    public void setRequestedOrientation(int requestedOrientation) {
        addTaint(requestedOrientation);
    if(mParent == null)        
        {
            try 
            {
                ActivityManagerNative.getDefault().setRequestedOrientation(
                        mToken, requestedOrientation);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        else
        {
            mParent.setRequestedOrientation(requestedOrientation);
        } //End block
        // ---------- Original Method ----------
        //if (mParent == null) {
            //try {
                //ActivityManagerNative.getDefault().setRequestedOrientation(
                        //mToken, requestedOrientation);
            //} catch (RemoteException e) {
            //}
        //} else {
            //mParent.setRequestedOrientation(requestedOrientation);
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.917 -0400", hash_original_method = "DB34404EF91E1F4006BE0A78903A055D", hash_generated_method = "5F1874ED62F0AC7DC02519038F7BBE44")
    public int getRequestedOrientation() {
    if(mParent == null)        
        {
            try 
            {
                int varAE24F4AB958B9F61BC15171CFB055EED_248208203 = (ActivityManagerNative.getDefault()
                        .getRequestedOrientation(mToken));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_354147485 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_354147485;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        else
        {
            int var45A4ECE0516406D0B1847F88E861D835_1747678815 = (mParent.getRequestedOrientation());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1881664633 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1881664633;
        } //End block
        int var5955876F887D4BBAAA40017524D7FCD6_372736423 = (ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_945895119 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_945895119;
        // ---------- Original Method ----------
        //if (mParent == null) {
            //try {
                //return ActivityManagerNative.getDefault()
                        //.getRequestedOrientation(mToken);
            //} catch (RemoteException e) {
            //}
        //} else {
            //return mParent.getRequestedOrientation();
        //}
        //return ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.918 -0400", hash_original_method = "617D78E91C885EF783A85ACE788D978C", hash_generated_method = "7500BF9FAA963A5903740CD274F69F56")
    public int getTaskId() {
        try 
        {
            int varDA3D9F2DEDDCB7A26559927CF49041FB_1624064217 = (ActivityManagerNative.getDefault()
                .getTaskForActivity(mToken, false));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_30251327 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_30251327;
        } //End block
        catch (RemoteException e)
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1829275834 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1537381309 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1537381309;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault()
                //.getTaskForActivity(mToken, false);
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.919 -0400", hash_original_method = "6E45F873D7236EF61D26B672F842F45F", hash_generated_method = "105008FA57ED09D60267F1A29858EA4D")
    public boolean isTaskRoot() {
        try 
        {
            boolean varA710479B2610A3D9023D1F5BB2BF4799_194170990 = (ActivityManagerNative.getDefault()
                .getTaskForActivity(mToken, true) >= 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1065250986 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1065250986;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_210995462 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1078380752 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1078380752;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault()
                //.getTaskForActivity(mToken, true) >= 0;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.922 -0400", hash_original_method = "9A59EFD62BA4B2B1BB27D9BF60C81F37", hash_generated_method = "CD1A28679CE5B0452EC3B27292719A82")
    public boolean moveTaskToBack(boolean nonRoot) {
        addTaint(nonRoot);
        try 
        {
            boolean var90B769A9E4DE8D15FE1F929926C7150A_451192927 = (ActivityManagerNative.getDefault().moveActivityTaskToBack(
                    mToken, nonRoot));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1832163789 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1832163789;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_85322594 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_950811700 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_950811700;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().moveActivityTaskToBack(
                    //mToken, nonRoot);
        //} catch (RemoteException e) {
        //}
        //return false;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.927 -0400", hash_original_method = "551AAFB8F3EA920969607A2C223A3A3A", hash_generated_method = "5E774C46B25E7CF0C838AF5863C362E0")
    public String getLocalClassName() {
        final String pkg = getPackageName();
        final String cls = mComponent.getClassName();
        int packageLen = pkg.length();
    if(!cls.startsWith(pkg) || cls.length() <= packageLen
                || cls.charAt(packageLen) != '.')        
        {
String var51801364268DFB5B1361AB761C7278F7_1526914830 =             cls;
            var51801364268DFB5B1361AB761C7278F7_1526914830.addTaint(taint);
            return var51801364268DFB5B1361AB761C7278F7_1526914830;
        } //End block
String var723F31F197533B0155DB0AC0EAD46253_1705564851 =         cls.substring(packageLen+1);
        var723F31F197533B0155DB0AC0EAD46253_1705564851.addTaint(taint);
        return var723F31F197533B0155DB0AC0EAD46253_1705564851;
        // ---------- Original Method ----------
        //final String pkg = getPackageName();
        //final String cls = mComponent.getClassName();
        //int packageLen = pkg.length();
        //if (!cls.startsWith(pkg) || cls.length() <= packageLen
                //|| cls.charAt(packageLen) != '.') {
            //return cls;
        //}
        //return cls.substring(packageLen+1);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.929 -0400", hash_original_method = "6C1D36E28C0C97736EA4779A7FB1715C", hash_generated_method = "4617C27B7CA3A5C2162C6754269D621A")
    public ComponentName getComponentName() {
ComponentName var05A4B5AD7D0B7D1F57C4FD8455C615E7_675697634 =         mComponent;
        var05A4B5AD7D0B7D1F57C4FD8455C615E7_675697634.addTaint(taint);
        return var05A4B5AD7D0B7D1F57C4FD8455C615E7_675697634;
        // ---------- Original Method ----------
        //return mComponent;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.931 -0400", hash_original_method = "8FF11253989B916424A8F19A417B9894", hash_generated_method = "1184D08365ABE966ACA9F05F1C8347BC")
    public SharedPreferences getPreferences(int mode) {
        addTaint(mode);
SharedPreferences varCF777F79975C13638913857981C0E5EB_1862297640 =         getSharedPreferences(getLocalClassName(), mode);
        varCF777F79975C13638913857981C0E5EB_1862297640.addTaint(taint);
        return varCF777F79975C13638913857981C0E5EB_1862297640;
        // ---------- Original Method ----------
        //return getSharedPreferences(getLocalClassName(), mode);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.932 -0400", hash_original_method = "4647E231E061B70291C2AAA883C4D14E", hash_generated_method = "1ECB33EB702FF37A32E9A3EAA40B5E1F")
    private void ensureSearchManager() {
    if(mSearchManager != null)        
        {
            return;
        } //End block
        mSearchManager = new SearchManager(this, null);
        // ---------- Original Method ----------
        //if (mSearchManager != null) {
            //return;
        //}
        //mSearchManager = new SearchManager(this, null);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.936 -0400", hash_original_method = "C911C3513CF522AB406EF738AFCD068D", hash_generated_method = "A94DBEB04110E9707FE7B83DA7EC4D8B")
    @Override
    public Object getSystemService(String name) {
        addTaint(name.getTaint());
    if(getBaseContext() == null)        
        {
            IllegalStateException var10DA1B74C7B25BEF2B5B2A88A435A5CB_2033574460 = new IllegalStateException(
                    "System services not available to Activities before onCreate()");
            var10DA1B74C7B25BEF2B5B2A88A435A5CB_2033574460.addTaint(taint);
            throw var10DA1B74C7B25BEF2B5B2A88A435A5CB_2033574460;
        } //End block
    if(WINDOW_SERVICE.equals(name))        
        {
Object varC209C60BFE9D7B593AFE54EB902C1459_471713686 =             mWindowManager;
            varC209C60BFE9D7B593AFE54EB902C1459_471713686.addTaint(taint);
            return varC209C60BFE9D7B593AFE54EB902C1459_471713686;
        } //End block
        else
    if(SEARCH_SERVICE.equals(name))        
        {
            ensureSearchManager();
Object var5439CF182A48FF81B205E1B740BFB822_812111469 =             mSearchManager;
            var5439CF182A48FF81B205E1B740BFB822_812111469.addTaint(taint);
            return var5439CF182A48FF81B205E1B740BFB822_812111469;
        } //End block
Object var6F0EFB07E70615565F7B773FAC854A26_1917299404 =         super.getSystemService(name);
        var6F0EFB07E70615565F7B773FAC854A26_1917299404.addTaint(taint);
        return var6F0EFB07E70615565F7B773FAC854A26_1917299404;
        // ---------- Original Method ----------
        //if (getBaseContext() == null) {
            //throw new IllegalStateException(
                    //"System services not available to Activities before onCreate()");
        //}
        //if (WINDOW_SERVICE.equals(name)) {
            //return mWindowManager;
        //} else if (SEARCH_SERVICE.equals(name)) {
            //ensureSearchManager();
            //return mSearchManager;
        //}
        //return super.getSystemService(name);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.938 -0400", hash_original_method = "917DB493889E2A2E4400765775D2C5BF", hash_generated_method = "5C0349CB95EC1A592A624F1E0F6F7A68")
    public void setTitle(CharSequence title) {
        mTitle = title;
        onTitleChanged(title, mTitleColor);
    if(mParent != null)        
        {
            mParent.onChildTitleChanged(this, title);
        } //End block
        // ---------- Original Method ----------
        //mTitle = title;
        //onTitleChanged(title, mTitleColor);
        //if (mParent != null) {
            //mParent.onChildTitleChanged(this, title);
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.939 -0400", hash_original_method = "A39F8277E51A7F6BD4A471D6255FEBC5", hash_generated_method = "F6253A3309AE21EFE023B7125BDF6F81")
    public void setTitle(int titleId) {
        addTaint(titleId);
        setTitle(getText(titleId));
        // ---------- Original Method ----------
        //setTitle(getText(titleId));
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.939 -0400", hash_original_method = "FA24EF1A624DFEEBC72DEB2A718D69DE", hash_generated_method = "BC4A216472427DDD027996C04C5326DB")
    public void setTitleColor(int textColor) {
        mTitleColor = textColor;
        onTitleChanged(mTitle, textColor);
        // ---------- Original Method ----------
        //mTitleColor = textColor;
        //onTitleChanged(mTitle, textColor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.940 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "D795748EBC6938CA9DB55DB21C03DF5A")
    public final CharSequence getTitle() {
CharSequence var4FE0D95ADE4B4BDFA36D55D8B62A6C49_282089369 =         mTitle;
        var4FE0D95ADE4B4BDFA36D55D8B62A6C49_282089369.addTaint(taint);
        return var4FE0D95ADE4B4BDFA36D55D8B62A6C49_282089369;
        // ---------- Original Method ----------
        //return mTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.941 -0400", hash_original_method = "96312D04BD6FB534546AC8090A725A72", hash_generated_method = "49CC61C0ED4595973CCAE710B3F5F872")
    public final int getTitleColor() {
        int var014792C54895DD72FBE25EDD52556324_1232659140 = (mTitleColor);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1346416906 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1346416906;
        // ---------- Original Method ----------
        //return mTitleColor;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.943 -0400", hash_original_method = "907C0E9079D015DC414B2AE462CAF06D", hash_generated_method = "CF2DDB18FBB48AE3DA0F154B947B85B3")
    protected void onTitleChanged(CharSequence title, int color) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(color);
        addTaint(title.getTaint());
    if(mTitleReady)        
        {
            final Window win = getWindow();
    if(win != null)            
            {
                win.setTitle(title);
    if(color != 0)                
                {
                    win.setTitleColor(color);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mTitleReady) {
            //final Window win = getWindow();
            //if (win != null) {
                //win.setTitle(title);
                //if (color != 0) {
                    //win.setTitleColor(color);
                //}
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.945 -0400", hash_original_method = "7A7CC5A839395F1C996BC46DE28C9533", hash_generated_method = "FD0669DE79BE9438D3D651E966E23DF8")
    protected void onChildTitleChanged(Activity childActivity, CharSequence title) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(title.getTaint());
        addTaint(childActivity.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.946 -0400", hash_original_method = "32B6571BC6889F247F99CDBE3AE16965", hash_generated_method = "9CD5E822C1DD6966E5E5F31FBD332B80")
    public final void setProgressBarVisibility(boolean visible) {
        addTaint(visible);
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS, visible ? Window.PROGRESS_VISIBILITY_ON :
            Window.PROGRESS_VISIBILITY_OFF);
        // ---------- Original Method ----------
        //getWindow().setFeatureInt(Window.FEATURE_PROGRESS, visible ? Window.PROGRESS_VISIBILITY_ON :
            //Window.PROGRESS_VISIBILITY_OFF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.947 -0400", hash_original_method = "1DF5015282F18776361652D68AED30B4", hash_generated_method = "FEB1C63193C22E31DD50C776BF09EAD0")
    public final void setProgressBarIndeterminateVisibility(boolean visible) {
        addTaint(visible);
        getWindow().setFeatureInt(Window.FEATURE_INDETERMINATE_PROGRESS,
                visible ? Window.PROGRESS_VISIBILITY_ON : Window.PROGRESS_VISIBILITY_OFF);
        // ---------- Original Method ----------
        //getWindow().setFeatureInt(Window.FEATURE_INDETERMINATE_PROGRESS,
                //visible ? Window.PROGRESS_VISIBILITY_ON : Window.PROGRESS_VISIBILITY_OFF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.950 -0400", hash_original_method = "2F28E974BBABA05D28D9AF73C25D13FA", hash_generated_method = "9F604E4F89BA6FF0072C52502E9D0D97")
    public final void setProgressBarIndeterminate(boolean indeterminate) {
        addTaint(indeterminate);
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS,
                indeterminate ? Window.PROGRESS_INDETERMINATE_ON : Window.PROGRESS_INDETERMINATE_OFF);
        // ---------- Original Method ----------
        //getWindow().setFeatureInt(Window.FEATURE_PROGRESS,
                //indeterminate ? Window.PROGRESS_INDETERMINATE_ON : Window.PROGRESS_INDETERMINATE_OFF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.953 -0400", hash_original_method = "55067894B88907AA64DBBC76309FF362", hash_generated_method = "549A0DECAFA6E88CB0259D2C46DD0B7E")
    public final void setProgress(int progress) {
        addTaint(progress);
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS, progress + Window.PROGRESS_START);
        // ---------- Original Method ----------
        //getWindow().setFeatureInt(Window.FEATURE_PROGRESS, progress + Window.PROGRESS_START);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.956 -0400", hash_original_method = "FF0EFB07F2D369BD624208547BA4F187", hash_generated_method = "D185902F087B7692957E649BEF47DC7E")
    public final void setSecondaryProgress(int secondaryProgress) {
        addTaint(secondaryProgress);
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS,
                secondaryProgress + Window.PROGRESS_SECONDARY_START);
        // ---------- Original Method ----------
        //getWindow().setFeatureInt(Window.FEATURE_PROGRESS,
                //secondaryProgress + Window.PROGRESS_SECONDARY_START);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.959 -0400", hash_original_method = "70729F29EB37CCBEC739A5986214C32F", hash_generated_method = "80B29B3BBD8F623411679BA79F1EADEC")
    public final void setVolumeControlStream(int streamType) {
        addTaint(streamType);
        getWindow().setVolumeControlStream(streamType);
        // ---------- Original Method ----------
        //getWindow().setVolumeControlStream(streamType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.961 -0400", hash_original_method = "03A841DC7655848901B3CE2C14084AAE", hash_generated_method = "063E06B34D45F9FB4B7578A236494C28")
    public final int getVolumeControlStream() {
        int var160AF96B101FDFAA7B104A380D7A015D_1056426081 = (getWindow().getVolumeControlStream());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1704201669 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1704201669;
        // ---------- Original Method ----------
        //return getWindow().getVolumeControlStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.962 -0400", hash_original_method = "691B4E9428578C2267EA5A6538081943", hash_generated_method = "CB076C9E438F2EF08697A1E368803AA5")
    public final void runOnUiThread(Runnable action) {
        addTaint(action.getTaint());
    if(Thread.currentThread() != mUiThread)        
        {
            mHandler.post(action);
        } //End block
        else
        {
            action.run();
        } //End block
        // ---------- Original Method ----------
        //if (Thread.currentThread() != mUiThread) {
            //mHandler.post(action);
        //} else {
            //action.run();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.963 -0400", hash_original_method = "C11741BEACAA4DD4B803A04296254194", hash_generated_method = "7351F79FEA5F046D54C6FC0CAC7628FC")
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        addTaint(name.getTaint());
View var540C13E9E156B687226421B24F2DF178_725061678 =         null;
        var540C13E9E156B687226421B24F2DF178_725061678.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_725061678;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.969 -0400", hash_original_method = "6AED635285422A876000505F10FFFED0", hash_generated_method = "D2BBFA9715225FAD495F52AE5A2F2C20")
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        addTaint(name.getTaint());
        addTaint(parent.getTaint());
    if(!"fragment".equals(name))        
        {
View var027B96B8532E2E982795E5E5EC54E4DE_776637271 =             onCreateView(name, context, attrs);
            var027B96B8532E2E982795E5E5EC54E4DE_776637271.addTaint(taint);
            return var027B96B8532E2E982795E5E5EC54E4DE_776637271;
        } //End block
        String fname = attrs.getAttributeValue(null, "class");
        TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.Fragment);
    if(fname == null)        
        {
            fname = a.getString(com.android.internal.R.styleable.Fragment_name);
        } //End block
        int id = a.getResourceId(com.android.internal.R.styleable.Fragment_id, View.NO_ID);
        String tag = a.getString(com.android.internal.R.styleable.Fragment_tag);
        a.recycle();
        int containerId = parent != null ? parent.getId() : 0;
    if(containerId == View.NO_ID && id == View.NO_ID && tag == null)        
        {
            IllegalArgumentException var3AF5CF07E2261E5D16C72162F16D6095_683720753 = new IllegalArgumentException(attrs.getPositionDescription()
                    + ": Must specify unique android:id, android:tag, or have a parent with an id for " + fname);
            var3AF5CF07E2261E5D16C72162F16D6095_683720753.addTaint(taint);
            throw var3AF5CF07E2261E5D16C72162F16D6095_683720753;
        } //End block
        Fragment fragment = id != View.NO_ID ? mFragments.findFragmentById(id) : null;
    if(fragment == null && tag != null)        
        {
            fragment = mFragments.findFragmentByTag(tag);
        } //End block
    if(fragment == null && containerId != View.NO_ID)        
        {
            fragment = mFragments.findFragmentById(containerId);
        } //End block
    if(FragmentManagerImpl.DEBUG){ }    if(fragment == null)        
        {
            fragment = Fragment.instantiate(this, fname);
            fragment.mFromLayout = true;
            fragment.mFragmentId = id != 0 ? id : containerId;
            fragment.mContainerId = containerId;
            fragment.mTag = tag;
            fragment.mInLayout = true;
            fragment.mFragmentManager = mFragments;
            fragment.onInflate(this, attrs, fragment.mSavedFragmentState);
            mFragments.addFragment(fragment, true);
        } //End block
        else
    if(fragment.mInLayout)        
        {
            IllegalArgumentException var390F44C73191E7A7A889F24BBA1C65CC_392563151 = new IllegalArgumentException(attrs.getPositionDescription()
                    + ": Duplicate id 0x" + Integer.toHexString(id)
                    + ", tag " + tag + ", or parent id 0x" + Integer.toHexString(containerId)
                    + " with another fragment for " + fname);
            var390F44C73191E7A7A889F24BBA1C65CC_392563151.addTaint(taint);
            throw var390F44C73191E7A7A889F24BBA1C65CC_392563151;
        } //End block
        else
        {
            fragment.mInLayout = true;
    if(!fragment.mRetaining)            
            {
                fragment.onInflate(this, attrs, fragment.mSavedFragmentState);
            } //End block
            mFragments.moveToState(fragment);
        } //End block
    if(fragment.mView == null)        
        {
            IllegalStateException varE32E018854A74B91F16273BC26BBEA6D_1123973099 = new IllegalStateException("Fragment " + fname
                    + " did not create a view.");
            varE32E018854A74B91F16273BC26BBEA6D_1123973099.addTaint(taint);
            throw varE32E018854A74B91F16273BC26BBEA6D_1123973099;
        } //End block
    if(id != 0)        
        {
            fragment.mView.setId(id);
        } //End block
    if(fragment.mView.getTag() == null)        
        {
            fragment.mView.setTag(tag);
        } //End block
View varCA045DD9191E9B0BACEF80A7EEFB5C7A_59609824 =         fragment.mView;
        varCA045DD9191E9B0BACEF80A7EEFB5C7A_59609824.addTaint(taint);
        return varCA045DD9191E9B0BACEF80A7EEFB5C7A_59609824;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.972 -0400", hash_original_method = "A3B02D247D35A4A6189512589B728713", hash_generated_method = "DA79636DEF60CE67D7038B5C64EB384C")
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        addTaint(args[0].getTaint());
        addTaint(writer.getTaint());
        addTaint(fd.getTaint());
        addTaint(prefix.getTaint());
        writer.print(prefix);
        writer.print("Local Activity ");
        writer.print(Integer.toHexString(System.identityHashCode(this)));
        writer.println(" State:");
        String innerPrefix = prefix + "  ";
        writer.print(innerPrefix);
        writer.print("mResumed=");
        writer.print(mResumed);
        writer.print(" mStopped=");
        writer.print(mStopped);
        writer.print(" mFinished=");
        writer.println(mFinished);
        writer.print(innerPrefix);
        writer.print("mLoadersStarted=");
        writer.println(mLoadersStarted);
        writer.print(innerPrefix);
        writer.print("mChangingConfigurations=");
        writer.println(mChangingConfigurations);
        writer.print(innerPrefix);
        writer.print("mCurrentConfig=");
        writer.println(mCurrentConfig);
    if(mLoaderManager != null)        
        {
            writer.print(prefix);
            writer.print("Loader Manager ");
            writer.print(Integer.toHexString(System.identityHashCode(mLoaderManager)));
            writer.println(":");
            mLoaderManager.dump(prefix + "  ", fd, writer, args);
        } //End block
        mFragments.dump(prefix, fd, writer, args);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.974 -0400", hash_original_method = "F5F1BD517EE731E56F922C1A6872A499", hash_generated_method = "4EF72AF1BF5908E77E83CC1CCE9DEB84")
    public boolean isImmersive() {
        try 
        {
            boolean var3E6A0257DA6325E22C4E8E09111DC356_828984531 = (ActivityManagerNative.getDefault().isImmersive(mToken));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_334536934 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_334536934;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1688802428 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1893445174 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1893445174;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().isImmersive(mToken);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.978 -0400", hash_original_method = "9D8EB8E29C9BCD315046F1934B1FF39B", hash_generated_method = "37382A897ABB979C0518F041213B1D29")
    public void setImmersive(boolean i) {
        addTaint(i);
        try 
        {
            ActivityManagerNative.getDefault().setImmersive(mToken, i);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().setImmersive(mToken, i);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.981 -0400", hash_original_method = "2C973E12746FE944D244FE9652432CFA", hash_generated_method = "2925C4F7918956D4790E5AB8B8A94715")
    public ActionMode startActionMode(ActionMode.Callback callback) {
        addTaint(callback.getTaint());
ActionMode var1785340D3471D4C131AAC624BA2DB3ED_463091602 =         mWindow.getDecorView().startActionMode(callback);
        var1785340D3471D4C131AAC624BA2DB3ED_463091602.addTaint(taint);
        return var1785340D3471D4C131AAC624BA2DB3ED_463091602;
        // ---------- Original Method ----------
        //return mWindow.getDecorView().startActionMode(callback);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.982 -0400", hash_original_method = "371F08E85934452E39039D6D8CFF84EA", hash_generated_method = "8A2FB308879146C0F3A382E45E00B3F1")
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(callback.getTaint());
        initActionBar();
    if(mActionBar != null)        
        {
ActionMode var8AEDBD2BEB8F07A00A535933A5F34D1D_1036826656 =             mActionBar.startActionMode(callback);
            var8AEDBD2BEB8F07A00A535933A5F34D1D_1036826656.addTaint(taint);
            return var8AEDBD2BEB8F07A00A535933A5F34D1D_1036826656;
        } //End block
ActionMode var540C13E9E156B687226421B24F2DF178_209008802 =         null;
        var540C13E9E156B687226421B24F2DF178_209008802.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_209008802;
        // ---------- Original Method ----------
        //initActionBar();
        //if (mActionBar != null) {
            //return mActionBar.startActionMode(callback);
        //}
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.984 -0400", hash_original_method = "255BA88D048ED7CA66014BFC1FF334C0", hash_generated_method = "5C31F22675E6C5EC34FEE649E89B1DA7")
    public void onActionModeStarted(ActionMode mode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(mode.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.985 -0400", hash_original_method = "731D5E497065CC7A99050B1E6205CD2C", hash_generated_method = "8341400BB35382A7F4737BEFC40A4A06")
    public void onActionModeFinished(ActionMode mode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(mode.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.987 -0400", hash_original_method = "CB0EFE3ADA1587CB31B88C9EC51AC6CD", hash_generated_method = "51CAD08D31A322104F1A9E253F06E70C")
    final void setParent(Activity parent) {
        mParent = parent;
        // ---------- Original Method ----------
        //mParent = parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.989 -0400", hash_original_method = "F5D036702945AFC6D1167650D88CF89C", hash_generated_method = "71D7A6B09B3EB6BCA3A5E47AA2C1B57A")
    final void attach(Context context, ActivityThread aThread, Instrumentation instr, IBinder token,
            Application application, Intent intent, ActivityInfo info, CharSequence title, 
            Activity parent, String id, NonConfigurationInstances lastNonConfigurationInstances,
            Configuration config) {
        addTaint(config.getTaint());
        addTaint(lastNonConfigurationInstances.getTaint());
        addTaint(id.getTaint());
        addTaint(parent.getTaint());
        addTaint(title.getTaint());
        addTaint(info.getTaint());
        addTaint(intent.getTaint());
        addTaint(application.getTaint());
        addTaint(token.getTaint());
        addTaint(instr.getTaint());
        addTaint(aThread.getTaint());
        addTaint(context.getTaint());
        attach(context, aThread, instr, token, 0, application, intent, info, title, parent, id,
            lastNonConfigurationInstances, config);
        // ---------- Original Method ----------
        //attach(context, aThread, instr, token, 0, application, intent, info, title, parent, id,
            //lastNonConfigurationInstances, config);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.994 -0400", hash_original_method = "1337919A8B79C562A3EF2FA6EE3B4075", hash_generated_method = "DA9EC1E881D5A949CB587E99278A73AC")
    final void attach(Context context, ActivityThread aThread,
            Instrumentation instr, IBinder token, int ident,
            Application application, Intent intent, ActivityInfo info,
            CharSequence title, Activity parent, String id,
            NonConfigurationInstances lastNonConfigurationInstances,
            Configuration config) {
        addTaint(context.getTaint());
        attachBaseContext(context);
        mFragments.attachActivity(this);
        mWindow = PolicyManager.makeNewWindow(this);
        mWindow.setCallback(this);
        mWindow.getLayoutInflater().setPrivateFactory(this);
    if(info.softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_UNSPECIFIED)        
        {
            mWindow.setSoftInputMode(info.softInputMode);
        } //End block
    if(info.uiOptions != 0)        
        {
            mWindow.setUiOptions(info.uiOptions);
        } //End block
        mUiThread = Thread.currentThread();
        mMainThread = aThread;
        mInstrumentation = instr;
        mToken = token;
        mIdent = ident;
        mApplication = application;
        mIntent = intent;
        mComponent = intent.getComponent();
        mActivityInfo = info;
        mTitle = title;
        mParent = parent;
        mEmbeddedID = id;
        mLastNonConfigurationInstances = lastNonConfigurationInstances;
        mWindow.setWindowManager(null, mToken, mComponent.flattenToString(),
                (info.flags & ActivityInfo.FLAG_HARDWARE_ACCELERATED) != 0);
    if(mParent != null)        
        {
            mWindow.setContainer(mParent.getWindow());
        } //End block
        mWindowManager = mWindow.getWindowManager();
        mCurrentConfig = config;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.996 -0400", hash_original_method = "032FECF5166BB774C48681F5A73546B5", hash_generated_method = "FBD12963FFDAC751FB1D372BBFA9C36E")
    final IBinder getActivityToken() {
IBinder var4B9A6691958C19C92091EE63D9D59BA2_956734409 =         mParent != null ? mParent.getActivityToken() : mToken;
        var4B9A6691958C19C92091EE63D9D59BA2_956734409.addTaint(taint);
        return var4B9A6691958C19C92091EE63D9D59BA2_956734409;
        // ---------- Original Method ----------
        //return mParent != null ? mParent.getActivityToken() : mToken;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:56.999 -0400", hash_original_method = "DAB379B095765C858B51976FA2FCF6E4", hash_generated_method = "B85FC9CA5FD75BC2569BC7FE820DA2C6")
    final void performCreate(Bundle icicle) {
        addTaint(icicle.getTaint());
        onCreate(icicle);
        mVisibleFromClient = !mWindow.getWindowStyle().getBoolean(
                com.android.internal.R.styleable.Window_windowNoDisplay, false);
        mFragments.dispatchActivityCreated();
        // ---------- Original Method ----------
        //onCreate(icicle);
        //mVisibleFromClient = !mWindow.getWindowStyle().getBoolean(
                //com.android.internal.R.styleable.Window_windowNoDisplay, false);
        //mFragments.dispatchActivityCreated();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.003 -0400", hash_original_method = "82BCF6383A02A95A38B6B2EB9C1C7555", hash_generated_method = "028081CB4A8EE2F66801A40EF562A0F2")
    final void performStart() {
        mFragments.noteStateNotSaved();
        mCalled = false;
        mFragments.execPendingActions();
        mInstrumentation.callActivityOnStart(this);
    if(!mCalled)        
        {
            SuperNotCalledException var71AF051CF8A0BDD1F6C63516F06F3DC2_374091151 = new SuperNotCalledException(
                "Activity " + mComponent.toShortString() +
                " did not call through to super.onStart()");
            var71AF051CF8A0BDD1F6C63516F06F3DC2_374091151.addTaint(taint);
            throw var71AF051CF8A0BDD1F6C63516F06F3DC2_374091151;
        } //End block
        mFragments.dispatchStart();
    if(mAllLoaderManagers != null)        
        {
for(int i=mAllLoaderManagers.size()-1;i>=0;i--)
            {
                LoaderManagerImpl lm = mAllLoaderManagers.valueAt(i);
                lm.finishRetain();
                lm.doReportStart();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //mFragments.noteStateNotSaved();
        //mCalled = false;
        //mFragments.execPendingActions();
        //mInstrumentation.callActivityOnStart(this);
        //if (!mCalled) {
            //throw new SuperNotCalledException(
                //"Activity " + mComponent.toShortString() +
                //" did not call through to super.onStart()");
        //}
        //mFragments.dispatchStart();
        //if (mAllLoaderManagers != null) {
            //for (int i=mAllLoaderManagers.size()-1; i>=0; i--) {
                //LoaderManagerImpl lm = mAllLoaderManagers.valueAt(i);
                //lm.finishRetain();
                //lm.doReportStart();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.009 -0400", hash_original_method = "3EBAEF204822031FA104B5D3C8D08DD5", hash_generated_method = "68778DE7DCB9FAF26F04118BFE2AB9DC")
    final void performRestart() {
        mFragments.noteStateNotSaved();
    if(mStopped)        
        {
            mStopped = false;
    if(mToken != null && mParent == null)            
            {
                WindowManagerImpl.getDefault().setStoppedState(mToken, false);
            } //End block
            synchronized
(mManagedCursors)            {
                final int N = mManagedCursors.size();
for(int i=0;i<N;i++)
                {
                    ManagedCursor mc = mManagedCursors.get(i);
    if(mc.mReleased || mc.mUpdated)                    
                    {
    if(!mc.mCursor.requery())                        
                        {
    if(getApplicationInfo().targetSdkVersion
                                    >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH)                            
                            {
                                IllegalStateException varBAB0C250C31091A07CCF4C6949498D27_1601182118 = new IllegalStateException(
                                        "trying to requery an already closed cursor  "
                                        + mc.mCursor);
                                varBAB0C250C31091A07CCF4C6949498D27_1601182118.addTaint(taint);
                                throw varBAB0C250C31091A07CCF4C6949498D27_1601182118;
                            } //End block
                        } //End block
                        mc.mReleased = false;
                        mc.mUpdated = false;
                    } //End block
                } //End block
            } //End block
            mCalled = false;
            mInstrumentation.callActivityOnRestart(this);
    if(!mCalled)            
            {
                SuperNotCalledException varE3A843FD8CFB969129D9306C218E58D8_1993530027 = new SuperNotCalledException(
                    "Activity " + mComponent.toShortString() +
                    " did not call through to super.onRestart()");
                varE3A843FD8CFB969129D9306C218E58D8_1993530027.addTaint(taint);
                throw varE3A843FD8CFB969129D9306C218E58D8_1993530027;
            } //End block
            performStart();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.012 -0400", hash_original_method = "F35F1467F0B7E6EEBE9DD69D8D6AD358", hash_generated_method = "CE4F627BD608D65EC34E528EEA6C788D")
    final void performResume() {
        performRestart();
        mFragments.execPendingActions();
        mLastNonConfigurationInstances = null;
        mCalled = false;
        mInstrumentation.callActivityOnResume(this);
    if(!mCalled)        
        {
            SuperNotCalledException varD9FF5F8ED2C0E2561BD23F0877C644E1_93132013 = new SuperNotCalledException(
                "Activity " + mComponent.toShortString() +
                " did not call through to super.onResume()");
            varD9FF5F8ED2C0E2561BD23F0877C644E1_93132013.addTaint(taint);
            throw varD9FF5F8ED2C0E2561BD23F0877C644E1_93132013;
        } //End block
        mCalled = false;
        mFragments.dispatchResume();
        mFragments.execPendingActions();
        onPostResume();
    if(!mCalled)        
        {
            SuperNotCalledException var72F5311211A02EC807D6696D8863984D_1113612719 = new SuperNotCalledException(
                "Activity " + mComponent.toShortString() +
                " did not call through to super.onPostResume()");
            var72F5311211A02EC807D6696D8863984D_1113612719.addTaint(taint);
            throw var72F5311211A02EC807D6696D8863984D_1113612719;
        } //End block
        // ---------- Original Method ----------
        //performRestart();
        //mFragments.execPendingActions();
        //mLastNonConfigurationInstances = null;
        //mCalled = false;
        //mInstrumentation.callActivityOnResume(this);
        //if (!mCalled) {
            //throw new SuperNotCalledException(
                //"Activity " + mComponent.toShortString() +
                //" did not call through to super.onResume()");
        //}
        //mCalled = false;
        //mFragments.dispatchResume();
        //mFragments.execPendingActions();
        //onPostResume();
        //if (!mCalled) {
            //throw new SuperNotCalledException(
                //"Activity " + mComponent.toShortString() +
                //" did not call through to super.onPostResume()");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.013 -0400", hash_original_method = "F81A8DB24B00685E2B896EC5528AF34D", hash_generated_method = "049987C649FDA94028E545EFCF0985BD")
    final void performPause() {
        mFragments.dispatchPause();
        mCalled = false;
        onPause();
        mResumed = false;
    if(!mCalled && getApplicationInfo().targetSdkVersion
                >= android.os.Build.VERSION_CODES.GINGERBREAD)        
        {
            SuperNotCalledException var2F15591A7E854C983E3272C5A80E048D_750496235 = new SuperNotCalledException(
                    "Activity " + mComponent.toShortString() +
                    " did not call through to super.onPause()");
            var2F15591A7E854C983E3272C5A80E048D_750496235.addTaint(taint);
            throw var2F15591A7E854C983E3272C5A80E048D_750496235;
        } //End block
        mResumed = false;
        // ---------- Original Method ----------
        //mFragments.dispatchPause();
        //mCalled = false;
        //onPause();
        //mResumed = false;
        //if (!mCalled && getApplicationInfo().targetSdkVersion
                //>= android.os.Build.VERSION_CODES.GINGERBREAD) {
            //throw new SuperNotCalledException(
                    //"Activity " + mComponent.toShortString() +
                    //" did not call through to super.onPause()");
        //}
        //mResumed = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.014 -0400", hash_original_method = "ABDB3944564BF35742E6297221FCB3EA", hash_generated_method = "31170BEEC73668AEDE9E7F6B4C817A47")
    final void performUserLeaving() {
        onUserInteraction();
        onUserLeaveHint();
        // ---------- Original Method ----------
        //onUserInteraction();
        //onUserLeaveHint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.016 -0400", hash_original_method = "1444D8CCB63DB563C5707F75C9D1FF30", hash_generated_method = "730D207907E48FCAAF7C75B83FC0D3BA")
    final void performStop() {
    if(mLoadersStarted)        
        {
            mLoadersStarted = false;
    if(mLoaderManager != null)            
            {
    if(!mChangingConfigurations)                
                {
                    mLoaderManager.doStop();
                } //End block
                else
                {
                    mLoaderManager.doRetain();
                } //End block
            } //End block
        } //End block
    if(!mStopped)        
        {
    if(mWindow != null)            
            {
                mWindow.closeAllPanels();
            } //End block
    if(mToken != null && mParent == null)            
            {
                WindowManagerImpl.getDefault().setStoppedState(mToken, true);
            } //End block
            mFragments.dispatchStop();
            mCalled = false;
            mInstrumentation.callActivityOnStop(this);
    if(!mCalled)            
            {
                SuperNotCalledException var3AB7478038AF877C715EB109ACBA7F9B_1739951023 = new SuperNotCalledException(
                    "Activity " + mComponent.toShortString() +
                    " did not call through to super.onStop()");
                var3AB7478038AF877C715EB109ACBA7F9B_1739951023.addTaint(taint);
                throw var3AB7478038AF877C715EB109ACBA7F9B_1739951023;
            } //End block
            synchronized
(mManagedCursors)            {
                final int N = mManagedCursors.size();
for(int i=0;i<N;i++)
                {
                    ManagedCursor mc = mManagedCursors.get(i);
    if(!mc.mReleased)                    
                    {
                        mc.mCursor.deactivate();
                        mc.mReleased = true;
                    } //End block
                } //End block
            } //End block
            mStopped = true;
        } //End block
        mResumed = false;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.018 -0400", hash_original_method = "1C8656F81B9FFA0D582D8F6098E0BE30", hash_generated_method = "FDB41AC3BCC859C52194451197C83F44")
    final void performDestroy() {
        mWindow.destroy();
        mFragments.dispatchDestroy();
        onDestroy();
    if(mLoaderManager != null)        
        {
            mLoaderManager.doDestroy();
        } //End block
        // ---------- Original Method ----------
        //mWindow.destroy();
        //mFragments.dispatchDestroy();
        //onDestroy();
        //if (mLoaderManager != null) {
            //mLoaderManager.doDestroy();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.019 -0400", hash_original_method = "58811A32FF0FF231CA3DA7AD72F98B09", hash_generated_method = "49EA33E1E9C7F21B27AC95F49C181930")
    public final boolean isResumed() {
        boolean var9933B84C738DC45A33F44AE2EFCBD30F_1099172818 = (mResumed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2009913814 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2009913814;
        // ---------- Original Method ----------
        //return mResumed;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.020 -0400", hash_original_method = "9EF1B69B76655E6A901B5D291A25C28E", hash_generated_method = "D19054DD8FB251AA2673AB601B53878F")
     void dispatchActivityResult(String who, int requestCode, 
        int resultCode, Intent data) {
        addTaint(data.getTaint());
        addTaint(resultCode);
        addTaint(requestCode);
        addTaint(who.getTaint());
    if(false){ }        mFragments.noteStateNotSaved();
    if(who == null)        
        {
            onActivityResult(requestCode, resultCode, data);
        } //End block
        else
        {
            Fragment frag = mFragments.findFragmentByWho(who);
    if(frag != null)            
            {
                frag.onActivityResult(requestCode, resultCode, data);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (false) Log.v(
            //TAG, "Dispatching result: who=" + who + ", reqCode=" + requestCode
            //+ ", resCode=" + resultCode + ", data=" + data);
        //mFragments.noteStateNotSaved();
        //if (who == null) {
            //onActivityResult(requestCode, resultCode, data);
        //} else {
            //Fragment frag = mFragments.findFragmentByWho(who);
            //if (frag != null) {
                //frag.onActivityResult(requestCode, resultCode, data);
            //}
        //}
    }

    
    private static class ManagedDialog {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.021 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "0C87BCBAF0D95855709E5BEE2BDBA46D")

        Dialog mDialog;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.021 -0400", hash_original_field = "E8543AD9E6F42B0AF96855D6D0BAB0A3", hash_generated_field = "7B435E447280D5DC4E48D52C3AACF101")

        Bundle mArgs;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.022 -0400", hash_original_method = "9DCA77B5D1234925DAEE8DA8399779D6", hash_generated_method = "9DCA77B5D1234925DAEE8DA8399779D6")
        public ManagedDialog ()
        {
            //Synthesized constructor
        }


    }


    
    static final class NonConfigurationInstances {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.022 -0400", hash_original_field = "69A256025F66E4CE5D15C9DD7225D357", hash_generated_field = "AE7D68ABA75D09946A953E289939C500")

        Object activity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.022 -0400", hash_original_field = "268184C12DF027F536154D099D497B31", hash_generated_field = "39C55DEAC9D9B669F0F104569866C7D7")

        HashMap<String, Object> children;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.023 -0400", hash_original_field = "AD7BA86BB6B55B3BB2BB5F974A84CECF", hash_generated_field = "CB2FDAC93F3729E9B59C5F21C93A6FFF")

        ArrayList<Fragment> fragments;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.023 -0400", hash_original_field = "2AB8B63748D15E45B6CE4A33D435F369", hash_generated_field = "D5FA06C5EF7E6F3388FB9592AB447362")

        SparseArray<LoaderManagerImpl> loaders;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.023 -0400", hash_original_method = "6ECBAFFBF9F9B3F6A966772230E87049", hash_generated_method = "6ECBAFFBF9F9B3F6A966772230E87049")
        public NonConfigurationInstances ()
        {
            //Synthesized constructor
        }


    }


    
    private static final class ManagedCursor {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.023 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "6E649D5858461199DBD67FE0A0D43789")

        private Cursor mCursor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.024 -0400", hash_original_field = "59BD2047126E05F523EC535BB598B674", hash_generated_field = "6C470EAC7065369BBFA5B5575968482A")

        private boolean mReleased;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.024 -0400", hash_original_field = "63EBA8D5D32C815A530E6A72B411BAD1", hash_generated_field = "823188B97D251C7D61AAB004C3DA6C8F")

        private boolean mUpdated;
        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.025 -0400", hash_original_method = "1B2A6EC67EE1273DC41D2716939B2D2A", hash_generated_method = "42977AB1E1BFB8F07C0C61D524D131AA")
          ManagedCursor(Cursor cursor) {
            mCursor = cursor;
            mReleased = false;
            mUpdated = false;
            // ---------- Original Method ----------
            //mCursor = cursor;
            //mReleased = false;
            //mUpdated = false;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.025 -0400", hash_original_field = "9C29F19CBB2417EFCC04569A35A2C147", hash_generated_field = "8CACF19DA21B737E3F7EB34688FF057C")

    private static final String TAG = "Activity";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.026 -0400", hash_original_field = "F82AA367945C18050D2033244725EAF5", hash_generated_field = "2241ED7572C2B89FA014BFB20EB1AF72")

    public static final int RESULT_CANCELED    = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.026 -0400", hash_original_field = "962F509BC72F354FB94AC40E73A4B7A4", hash_generated_field = "F91B70B7F6D5082BE48EF2C98C1E7358")

    public static final int RESULT_OK           = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.026 -0400", hash_original_field = "E43060F557E7C9ED788A22939DB0D79E", hash_generated_field = "5077A6A22B66E72C7578FB99A7F608D6")

    public static final int RESULT_FIRST_USER   = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.027 -0400", hash_original_field = "B65D15DDA07492A4A8DE08D820B3BC23", hash_generated_field = "935F741DC4E3364E9A53BE28D1817499")

    private static final String WINDOW_HIERARCHY_TAG = "android:viewHierarchyState";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.027 -0400", hash_original_field = "FB4A22E192730B645166187558A8A796", hash_generated_field = "925270CCB66F84A6CC5AD8E1A127DDF5")

    private static final String FRAGMENTS_TAG = "android:fragments";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.028 -0400", hash_original_field = "E5B3C7DC3F4E78258F87EF385D628C7C", hash_generated_field = "B84490F85315FC6A0344124DA2A9A7C1")

    private static final String SAVED_DIALOG_IDS_KEY = "android:savedDialogIds";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.028 -0400", hash_original_field = "CEFECAA57483EE3BEADD7413245EF60B", hash_generated_field = "F085B80E40EB97561C0DC9EEAA7EAFE2")

    private static final String SAVED_DIALOGS_TAG = "android:savedDialogs";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.029 -0400", hash_original_field = "BDEC88B1A06E3B4B8EAD965EA57EAD9F", hash_generated_field = "7A1510EAA3BBABE8CABC5BDBCC2B1DF1")

    private static final String SAVED_DIALOG_KEY_PREFIX = "android:dialog_";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.029 -0400", hash_original_field = "B5CEBA5CE662022E22C9CE3982D9DCE2", hash_generated_field = "7ED6DE9D8F1923634B10FAD193F62B6F")

    private static final String SAVED_DIALOG_ARGS_KEY_PREFIX = "android:dialog_args_";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.029 -0400", hash_original_field = "4066C9D5A8E645EE130BB72CD59497D1", hash_generated_field = "98D5104638F2DEE99210C785FE0E500F")

    protected static final int[] FOCUSED_STATE_SET = {com.android.internal.R.attr.state_focused};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.030 -0400", hash_original_field = "8CB380EC154CB62ED9B10D3B61A2D67C", hash_generated_field = "45127B126EE2B3619E2DE44F606F53C3")

    static public final int DEFAULT_KEYS_DISABLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.030 -0400", hash_original_field = "BEC0DDDE6C52F8C9CB44C35DDF3A2D50", hash_generated_field = "F05278144A2B935FA742242E4E3A61A2")

    static public final int DEFAULT_KEYS_DIALER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.030 -0400", hash_original_field = "B9A091052EFFE8B52D43580CA139320C", hash_generated_field = "B4C1B32500D4540AA59C81E1B33DAC14")

    static public final int DEFAULT_KEYS_SHORTCUT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.031 -0400", hash_original_field = "265CCE449D6408B73F80115B406B0F94", hash_generated_field = "7B0F2176FF8E3A9C8466EB909FF8E3C8")

    static public final int DEFAULT_KEYS_SEARCH_LOCAL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:57.031 -0400", hash_original_field = "414426DEE5BB2437FCFB3279CDC238E7", hash_generated_field = "0C973E25C195EE36EA7FD3DD74B22EB1")

    static public final int DEFAULT_KEYS_SEARCH_GLOBAL = 4;
    // orphaned legacy method
    @DSModeled(DSC.BAN) 
    public final void performCreate(Bundle icicle, Context context){
    	this.attachBaseContext(context);
    	onCreate(icicle);
    	mVisibleFromClient = !mWindow.getWindowStyle().getBoolean(
    	com.android.internal.R.styleable.Window_windowNoDisplay, false);
    	mFragments.dispatchActivityCreated();
    	
    	
    	
    }
    
    // orphaned legacy method
    @DSModeled(DSC.BAN)
    public void droidsafeOnStop() {
    	
    	onStop();
    }
    
    // orphaned legacy method
    @DSModeled(DSC.BAN)
    public void droidsafeOnDestroy() {
    	onDestroy();
    }
    
    // orphaned legacy method
    @DSModeled(DSC.BAN)
    public void droidsafeOnResume() {
    	
    	onResume();
    }
    
}

