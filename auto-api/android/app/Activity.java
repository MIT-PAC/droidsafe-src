package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.601 -0400", hash_original_field = "69994B385C8EE3CB1FC89C139F80EE2C", hash_generated_field = "D7ACA1EA4615702CAE0E6513097C1B9D")

    private SparseArray<ManagedDialog> mManagedDialogs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.601 -0400", hash_original_field = "E062CE48CD3AFCDDC19DD9FCF2E119D4", hash_generated_field = "B2267B39A1EB39D35FC793A28FB486AB")

    private Instrumentation mInstrumentation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.601 -0400", hash_original_field = "98E8D2ECD335C543A384E2B940159AF2", hash_generated_field = "48FA2AB88D7976975EE44F222013EB79")

    private IBinder mToken;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.601 -0400", hash_original_field = "9ECD332EA0315F97A6C2A47F0DFCF2CA", hash_generated_field = "1C52ADC6FAC22BA15FC5CB45EFB9C704")

    private int mIdent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.602 -0400", hash_original_field = "1F8EA74468A18EB8C9F4629DC88D43D9", hash_generated_field = "A96A287BB650BF201DDA299E34737419")

    String mEmbeddedID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.602 -0400", hash_original_field = "6B35E9B21496C1A77A324DB1577A6395", hash_generated_field = "53FA3553B85F7414D1C5F2C302FDEBF9")

    private Application mApplication;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.602 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "1811495D939DB843870F6315E04555CC")

    Intent mIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.602 -0400", hash_original_field = "C0386E973BB6E008B1720A8BB4936F69", hash_generated_field = "1B40E7C57A0B1682389BAE16521C0844")

    private ComponentName mComponent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.602 -0400", hash_original_field = "4BA355497E3293EF79CEB324C2759EC3", hash_generated_field = "C71CEE98D7B6D75F61EDC7C7807C69E4")

    ActivityInfo mActivityInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.603 -0400", hash_original_field = "46FDB2388003D2F8D58B7436C6E7B099", hash_generated_field = "DAA5CF027F30E341CB6E5B438E9919B8")

    ActivityThread mMainThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.603 -0400", hash_original_field = "08DEDF480C56042390504EEB5F2B5C59", hash_generated_field = "CD55C80FF47FF655766F475F33319B07")

    Activity mParent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.603 -0400", hash_original_field = "8F73DC27B0DCA8E7133AEF9B7DBDC6C6", hash_generated_field = "6971FF9C6126C288092CCC2A5964E550")

    boolean mCalled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.603 -0400", hash_original_field = "E2FDF9701AF8C008E54F63B95BC75C79", hash_generated_field = "93A369593E1CC22C7DE8D4D5C675B065")

    boolean mCheckedForLoaderManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.603 -0400", hash_original_field = "7B94EB60C9B740E67FF099B167511F7B", hash_generated_field = "D357ECA56BF47F1751443279339D50DF")

    boolean mLoadersStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.604 -0400", hash_original_field = "9933B84C738DC45A33F44AE2EFCBD30F", hash_generated_field = "23D2434AD22548E124B62AB7739838E9")

    boolean mResumed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.604 -0400", hash_original_field = "33AF93F952A554412842C66D48683981", hash_generated_field = "7A3A2F4FBB99BD4528DF7EC8A1065318")

    private boolean mStopped;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.604 -0400", hash_original_field = "BB077E6B2FCDFA3F0EF71EB099A18F49", hash_generated_field = "10598AB9B4F301B505526794EAE9EAF0")

    boolean mFinished;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.604 -0400", hash_original_field = "D6CAA0132EF985A9C48E94EF5C72A353", hash_generated_field = "4271970B01F3FE84D04BB6304D70A20E")

    boolean mStartedActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.604 -0400", hash_original_field = "DD793F13DDAF2B567A8C331E578AA5A1", hash_generated_field = "E2F9380D6A364C95010BE19858A38D28")

    boolean mTemporaryPause = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.605 -0400", hash_original_field = "9D9C29E34F0ED4F978EFE00DFB6384BA", hash_generated_field = "D9F8EBFD0B8B6BCDE3A24A3C3A2D769A")

    boolean mChangingConfigurations = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.605 -0400", hash_original_field = "C276475150FAB89E9C0772A14D5411EF", hash_generated_field = "8737FBBAA51F2079A35CA72C17030BD1")

    int mConfigChangeFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.605 -0400", hash_original_field = "49D0F54F6F251B7A443EE498C968E7F0", hash_generated_field = "C5BC4D87F668E7C84F089BDA831D492B")

    Configuration mCurrentConfig;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.605 -0400", hash_original_field = "32BBEFAC8E5B50979F727CF657FBCDC5", hash_generated_field = "EC37B561700692089320F9D5E535EAC6")

    private SearchManager mSearchManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.605 -0400", hash_original_field = "EC6D3DC1F9EEB509CBA3527543E491C5", hash_generated_field = "53E9FC1E44FE670BE318B42372895069")

    private MenuInflater mMenuInflater;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.606 -0400", hash_original_field = "A330FB67942A8EBA9AA052BF6E9BD824", hash_generated_field = "103BD895478A6A40124D791931151EE2")

    NonConfigurationInstances mLastNonConfigurationInstances;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.606 -0400", hash_original_field = "F4214BE1FFE044F8CA79EEDDDED72016", hash_generated_field = "C669AC20EF93035981B8D3BE2898892F")

    private Window mWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.606 -0400", hash_original_field = "306519E50E3A91B9733D09F5D8EB985C", hash_generated_field = "3C750A4AE06B71AF3A05B7797C7182A4")

    private WindowManager mWindowManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.606 -0400", hash_original_field = "51828538BFE4CBE4B66B359B3F441676", hash_generated_field = "E1BBD6179BBAC61DB86866A787E8F58C")

    View mDecor = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.606 -0400", hash_original_field = "D04D49A04B1C9F713DA6373581960A20", hash_generated_field = "55C28C3FE3EA0FDA8C94FC41EC701FCC")

    boolean mWindowAdded = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.607 -0400", hash_original_field = "F4264B08F586521DD9D9932CF43D3E98", hash_generated_field = "8DFFFB221D63F9E9F2CE49B7477D9272")

    boolean mVisibleFromServer = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.607 -0400", hash_original_field = "A0B583B0E04E9DAD985B75BE1B4455FB", hash_generated_field = "5F61707B4AC1003B88348BA722FB1276")

    boolean mVisibleFromClient = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.607 -0400", hash_original_field = "E174CF32536D070CADCB31C79B6A2A6D", hash_generated_field = "1CE82A6BEC35E312C3A47BC38BD7B9BC")

    ActionBarImpl mActionBar = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.607 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.607 -0400", hash_original_field = "31044357223C0CBA3321867ECA01F93C", hash_generated_field = "CF4E9C052F96C3E80581AE8AF634872B")

    private int mTitleColor = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.608 -0400", hash_original_field = "9E9F5C9A2D303AC76B37DDF504A5EF92", hash_generated_field = "694874072698409F6608B46B5D5A3DE1")

    final FragmentManagerImpl mFragments = new FragmentManagerImpl();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.608 -0400", hash_original_field = "C3FC98EBFA953A5BA9BDADB9981A948A", hash_generated_field = "207A321ED3571899F1F73399691FB216")

    SparseArray<LoaderManagerImpl> mAllLoaderManagers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.608 -0400", hash_original_field = "780418B081227A51BFCB9EC0223B15ED", hash_generated_field = "6EE478DF5473556475C8D09C185A01BC")

    LoaderManagerImpl mLoaderManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.608 -0400", hash_original_field = "4FADE50651FFFEF0B3EB84F52D784589", hash_generated_field = "055EFA91DED96C0A7FAE40D00A04351C")

    private final ArrayList<ManagedCursor> mManagedCursors = new ArrayList<ManagedCursor>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.608 -0400", hash_original_field = "E342FEFA537FF05142CD9015EE3A0E7D", hash_generated_field = "2FA7D874AF2386F63CF856FBF24A7710")

    int mResultCode = RESULT_CANCELED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.609 -0400", hash_original_field = "1096C650F15AC7BAC99BEA828E92A3B2", hash_generated_field = "33B7C8CE0002446D9B0EE0274776A0A9")

    Intent mResultData = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.609 -0400", hash_original_field = "4F715D0874F4F1364B7BFCBD6E8E0F0A", hash_generated_field = "AB8AC56D76B8BEA00FC5296846330527")

    private boolean mTitleReady = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.609 -0400", hash_original_field = "E63F81EBF009861E6158D6EBEF422559", hash_generated_field = "B2DD3A4B48EBE858054417FEDBBD4E9F")

    private int mDefaultKeyMode = DEFAULT_KEYS_DISABLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.609 -0400", hash_original_field = "56ABC0D9D60C4A18066C25A91AA319BA", hash_generated_field = "2B1292D0EBD0751B84B1BAFF83080A8F")

    private SpannableStringBuilder mDefaultKeySsb = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.610 -0400", hash_original_field = "EA2540686B911BB0954AF2AA78EF465E", hash_generated_field = "67CC4174E7EA3B2C8F47C97894D850FA")

    private final Object mInstanceTracker = StrictMode.trackActivity(this);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.610 -0400", hash_original_field = "C5D62B7C4F8BE6B828DA51239EC692E0", hash_generated_field = "A94051227A36AE91A6CE3B31BF1DD3E6")

    private Thread mUiThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.610 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "26DE2B72977ADBD047A9853341F26F79")

    final Handler mHandler = new Handler();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.610 -0400", hash_original_method = "AACC12F53D348DF0EC8A64E180708AE7", hash_generated_method = "AACC12F53D348DF0EC8A64E180708AE7")
    public Activity ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.611 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "40D882F3A1186DBAAD3CDA8FF3538DB4")
    public Intent getIntent() {
        Intent varB4EAC82CA7396A68D541C85D26508E83_772984976 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_772984976 = mIntent;
        varB4EAC82CA7396A68D541C85D26508E83_772984976.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_772984976;
        // ---------- Original Method ----------
        //return mIntent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.612 -0400", hash_original_method = "CC61C883982068788EAC9DED2F81C9E5", hash_generated_method = "B79BA4B24A70D57CC8AC980D0B341130")
    public void setIntent(Intent newIntent) {
        mIntent = newIntent;
        // ---------- Original Method ----------
        //mIntent = newIntent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.614 -0400", hash_original_method = "510D23D8CF054FDAE1D1426C6A1A1500", hash_generated_method = "28D2DFA684EF446AE05246820F9057BB")
    public final Application getApplication() {
        Application varB4EAC82CA7396A68D541C85D26508E83_652164263 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_652164263 = mApplication;
        varB4EAC82CA7396A68D541C85D26508E83_652164263.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_652164263;
        // ---------- Original Method ----------
        //return mApplication;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.615 -0400", hash_original_method = "68263BD6D248286EA0E84780534AEB0C", hash_generated_method = "F69B1DCA076F7677152C2E9C42FD5768")
    public final boolean isChild() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1626383455 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1626383455;
        // ---------- Original Method ----------
        //return mParent != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.616 -0400", hash_original_method = "9F036901744EF56469FFF11C0925658F", hash_generated_method = "5D9DCC9BD6D5AA941AFCFCE834D22CC8")
    public final Activity getParent() {
        Activity varB4EAC82CA7396A68D541C85D26508E83_1265125769 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1265125769 = mParent;
        varB4EAC82CA7396A68D541C85D26508E83_1265125769.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1265125769;
        // ---------- Original Method ----------
        //return mParent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.617 -0400", hash_original_method = "1DCFADD2C71F0E408EA049F81A8ACDED", hash_generated_method = "734D2A98F408233E136423BA63024E34")
    public WindowManager getWindowManager() {
        WindowManager varB4EAC82CA7396A68D541C85D26508E83_988565730 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_988565730 = mWindowManager;
        varB4EAC82CA7396A68D541C85D26508E83_988565730.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_988565730;
        // ---------- Original Method ----------
        //return mWindowManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.618 -0400", hash_original_method = "51ACB33F24592F8ED3FAFF9D96DEAF2A", hash_generated_method = "DC96C9C2C834AA730EBE613A81D9C0F5")
    public Window getWindow() {
        Window varB4EAC82CA7396A68D541C85D26508E83_60546631 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_60546631 = mWindow;
        varB4EAC82CA7396A68D541C85D26508E83_60546631.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_60546631;
        // ---------- Original Method ----------
        //return mWindow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.620 -0400", hash_original_method = "6FD2535D569839ECA0CF9FB0769EA7E8", hash_generated_method = "D53B9A4365E7759C6A8710B31FBCFD33")
    public LoaderManager getLoaderManager() {
        LoaderManager varB4EAC82CA7396A68D541C85D26508E83_572277713 = null; //Variable for return #1
        LoaderManager varB4EAC82CA7396A68D541C85D26508E83_530013655 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_572277713 = mLoaderManager;
        } //End block
        mCheckedForLoaderManager = true;
        mLoaderManager = getLoaderManager(-1, mLoadersStarted, true);
        varB4EAC82CA7396A68D541C85D26508E83_530013655 = mLoaderManager;
        LoaderManager varA7E53CE21691AB073D9660D615818899_1188985604; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1188985604 = varB4EAC82CA7396A68D541C85D26508E83_572277713;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1188985604 = varB4EAC82CA7396A68D541C85D26508E83_530013655;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1188985604.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1188985604;
        // ---------- Original Method ----------
        //if (mLoaderManager != null) {
            //return mLoaderManager;
        //}
        //mCheckedForLoaderManager = true;
        //mLoaderManager = getLoaderManager(-1, mLoadersStarted, true);
        //return mLoaderManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.621 -0400", hash_original_method = "08140101E6179DFA80CB04A3C57AF21B", hash_generated_method = "9EB9F6CE2BA5057F7A101F4AD351986D")
     LoaderManagerImpl getLoaderManager(int index, boolean started, boolean create) {
        LoaderManagerImpl varB4EAC82CA7396A68D541C85D26508E83_308619981 = null; //Variable for return #1
        {
            mAllLoaderManagers = new SparseArray<LoaderManagerImpl>();
        } //End block
        LoaderManagerImpl lm = mAllLoaderManagers.get(index);
        {
            {
                lm = new LoaderManagerImpl(this, started);
                mAllLoaderManagers.put(index, lm);
            } //End block
        } //End block
        {
            lm.updateActivity(this);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_308619981 = lm;
        addTaint(index);
        addTaint(started);
        addTaint(create);
        varB4EAC82CA7396A68D541C85D26508E83_308619981.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_308619981;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.623 -0400", hash_original_method = "44957F5326E5A87B91E438DCD3C71232", hash_generated_method = "2C157A6DE0ABBE78439CEC0F8FA05206")
    public View getCurrentFocus() {
        View varB4EAC82CA7396A68D541C85D26508E83_1704332066 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1704332066 = mWindow != null ? mWindow.getCurrentFocus() : null;
        varB4EAC82CA7396A68D541C85D26508E83_1704332066.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1704332066;
        // ---------- Original Method ----------
        //return mWindow != null ? mWindow.getCurrentFocus() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.625 -0400", hash_original_method = "B17127798FA6CFC370BF4A1AB8F1546E", hash_generated_method = "EE521F2E2D9724C1291B392AC2A2D09F")
    protected void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mAllLoaderManagers = mLastNonConfigurationInstances.loaders;
        } //End block
        {
            Parcelable p = savedInstanceState.getParcelable(FRAGMENTS_TAG);
            mFragments.restoreAllState(p, mLastNonConfigurationInstances != null
                    ? mLastNonConfigurationInstances.fragments : null);
        } //End block
        mFragments.dispatchCreate();
        getApplication().dispatchActivityCreated(this, savedInstanceState);
        mCalled = true;
        addTaint(savedInstanceState.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.627 -0400", hash_original_method = "F96DCFB160CAE669DE173597BCAB5D29", hash_generated_method = "04CD208A03098F358C20529956E3E77B")
    final void performRestoreInstanceState(Bundle savedInstanceState) {
        onRestoreInstanceState(savedInstanceState);
        restoreManagedDialogs(savedInstanceState);
        addTaint(savedInstanceState.getTaint());
        // ---------- Original Method ----------
        //onRestoreInstanceState(savedInstanceState);
        //restoreManagedDialogs(savedInstanceState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.628 -0400", hash_original_method = "310E3A3C8C3B3732DFA9529F42CA26F1", hash_generated_method = "6C81C3565E8C619D77A058D028157D29")
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            Bundle windowState = savedInstanceState.getBundle(WINDOW_HIERARCHY_TAG);
            {
                mWindow.restoreHierarchyState(windowState);
            } //End block
        } //End block
        addTaint(savedInstanceState.getTaint());
        // ---------- Original Method ----------
        //if (mWindow != null) {
            //Bundle windowState = savedInstanceState.getBundle(WINDOW_HIERARCHY_TAG);
            //if (windowState != null) {
                //mWindow.restoreHierarchyState(windowState);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.629 -0400", hash_original_method = "0F730FD08B46E6D42261031E4F07C651", hash_generated_method = "BE134322D956071AD0ED9DFAE87C3BC2")
    private void restoreManagedDialogs(Bundle savedInstanceState) {
        final Bundle b = savedInstanceState.getBundle(SAVED_DIALOGS_TAG);
        final int[] ids = b.getIntArray(SAVED_DIALOG_IDS_KEY);
        final int numDialogs = ids.length;
        mManagedDialogs = new SparseArray<ManagedDialog>(numDialogs);
        {
            int i = 0;
            {
                final Integer dialogId = ids[i];
                Bundle dialogState = b.getBundle(savedDialogKeyFor(dialogId));
                {
                    final ManagedDialog md = new ManagedDialog();
                    md.mArgs = b.getBundle(savedDialogArgsKeyFor(dialogId));
                    md.mDialog = createDialog(dialogId, dialogState, md.mArgs);
                    {
                        mManagedDialogs.put(dialogId, md);
                        onPrepareDialog(dialogId, md.mDialog, md.mArgs);
                        md.mDialog.onRestoreInstanceState(dialogState);
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(savedInstanceState.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.630 -0400", hash_original_method = "F21B3418C21CA75D12B54B07BD48021E", hash_generated_method = "28D012A3EFE97F3F6F42398E2A4D6DAB")
    private Dialog createDialog(Integer dialogId, Bundle state, Bundle args) {
        Dialog varB4EAC82CA7396A68D541C85D26508E83_1972091312 = null; //Variable for return #1
        Dialog varB4EAC82CA7396A68D541C85D26508E83_327906848 = null; //Variable for return #2
        final Dialog dialog = onCreateDialog(dialogId, args);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1972091312 = null;
        } //End block
        dialog.dispatchOnCreate(state);
        varB4EAC82CA7396A68D541C85D26508E83_327906848 = dialog;
        addTaint(dialogId.getTaint());
        addTaint(state.getTaint());
        addTaint(args.getTaint());
        Dialog varA7E53CE21691AB073D9660D615818899_913244036; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_913244036 = varB4EAC82CA7396A68D541C85D26508E83_1972091312;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_913244036 = varB4EAC82CA7396A68D541C85D26508E83_327906848;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_913244036.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_913244036;
        // ---------- Original Method ----------
        //final Dialog dialog = onCreateDialog(dialogId, args);
        //if (dialog == null) {
            //return null;
        //}
        //dialog.dispatchOnCreate(state);
        //return dialog;
    }

    
    private static String savedDialogKeyFor(int key) {
        return SAVED_DIALOG_KEY_PREFIX + key;
    }

    
    private static String savedDialogArgsKeyFor(int key) {
        return SAVED_DIALOG_ARGS_KEY_PREFIX + key;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.632 -0400", hash_original_method = "15D630F6A1CF1F711678BA91927530D5", hash_generated_method = "D493E785C7540F12064D0D1D649E6D56")
    protected void onPostCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var1E47DE65F9CFFB5FFE0047F063F1F3E2_256093937 = (!isChild());
            {
                mTitleReady = true;
                onTitleChanged(getTitle(), getTitleColor());
            } //End block
        } //End collapsed parenthetic
        mCalled = true;
        addTaint(savedInstanceState.getTaint());
        // ---------- Original Method ----------
        //if (!isChild()) {
            //mTitleReady = true;
            //onTitleChanged(getTitle(), getTitleColor());
        //}
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.634 -0400", hash_original_method = "79A696122767FFD8BC894F5F20A8F390", hash_generated_method = "2397E2132D66A9B67652FE4FE96B68CE")
    protected void onStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        {
            mLoadersStarted = true;
            {
                mLoaderManager.doStart();
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.636 -0400", hash_original_method = "9551F017AAC8568C86A29525E7DD6889", hash_generated_method = "BFAD3826B369FB60CEBE705C5D3DE3AF")
    protected void onRestart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.637 -0400", hash_original_method = "AC4046BA89469FB1DB71AF45F366E61A", hash_generated_method = "386EEADB41ACC4B4BD80CE17A193C26A")
    protected void onResume() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        getApplication().dispatchActivityResumed(this);
        mCalled = true;
        // ---------- Original Method ----------
        //getApplication().dispatchActivityResumed(this);
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.638 -0400", hash_original_method = "F3C7FB58C48A3E40E2BB0C45916F9A60", hash_generated_method = "1D0F1F0F0B8A7E9011B76E382A1D8D96")
    protected void onPostResume() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final Window win = getWindow();
        win.makeActive();
        mActionBar.setShowHideAnimationEnabled(true);
        mCalled = true;
        // ---------- Original Method ----------
        //final Window win = getWindow();
        //if (win != null) win.makeActive();
        //if (mActionBar != null) mActionBar.setShowHideAnimationEnabled(true);
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.638 -0400", hash_original_method = "ECA12E6FCFF6C8E6301C9A23FD34F5BD", hash_generated_method = "55BB01BD8178596262072C6AD03D450A")
    protected void onNewIntent(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.639 -0400", hash_original_method = "0B461FC0ABFD8E876BD0A4555078BB43", hash_generated_method = "F3FA9E9361FD8CB50CB6AE1B3A5F66A3")
    final void performSaveInstanceState(Bundle outState) {
        onSaveInstanceState(outState);
        saveManagedDialogs(outState);
        addTaint(outState.getTaint());
        // ---------- Original Method ----------
        //onSaveInstanceState(outState);
        //saveManagedDialogs(outState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.640 -0400", hash_original_method = "7ACED454726A10AD27032B8542185EA6", hash_generated_method = "A59390CA6EDBF70FEF03DD7CC8A4EBD2")
    protected void onSaveInstanceState(Bundle outState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        outState.putBundle(WINDOW_HIERARCHY_TAG, mWindow.saveHierarchyState());
        Parcelable p = mFragments.saveAllState();
        {
            outState.putParcelable(FRAGMENTS_TAG, p);
        } //End block
        getApplication().dispatchActivitySaveInstanceState(this, outState);
        addTaint(outState.getTaint());
        // ---------- Original Method ----------
        //outState.putBundle(WINDOW_HIERARCHY_TAG, mWindow.saveHierarchyState());
        //Parcelable p = mFragments.saveAllState();
        //if (p != null) {
            //outState.putParcelable(FRAGMENTS_TAG, p);
        //}
        //getApplication().dispatchActivitySaveInstanceState(this, outState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.641 -0400", hash_original_method = "8A0B1A781281636D9884F4D74FBF5AF9", hash_generated_method = "BF89EE6B85A32C7489F94603C661A565")
    private void saveManagedDialogs(Bundle outState) {
        final int numDialogs = mManagedDialogs.size();
        Bundle dialogState = new Bundle();
        int[] ids = new int[mManagedDialogs.size()];
        {
            int i = 0;
            {
                final int key = mManagedDialogs.keyAt(i);
                ids[i] = key;
                final ManagedDialog md = mManagedDialogs.valueAt(i);
                dialogState.putBundle(savedDialogKeyFor(key), md.mDialog.onSaveInstanceState());
                {
                    dialogState.putBundle(savedDialogArgsKeyFor(key), md.mArgs);
                } //End block
            } //End block
        } //End collapsed parenthetic
        dialogState.putIntArray(SAVED_DIALOG_IDS_KEY, ids);
        outState.putBundle(SAVED_DIALOGS_TAG, dialogState);
        addTaint(outState.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.641 -0400", hash_original_method = "B6F2BA46109080323AC17E644CBE52E4", hash_generated_method = "486584B3FE1F7AACB7AE3C8DA52C0E5B")
    protected void onPause() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        getApplication().dispatchActivityPaused(this);
        mCalled = true;
        // ---------- Original Method ----------
        //getApplication().dispatchActivityPaused(this);
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.642 -0400", hash_original_method = "F09D1B8D5CADCA3B5931B472B638BC48", hash_generated_method = "E9DC8D666FB72967F203DDC8123D3668")
    protected void onUserLeaveHint() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.642 -0400", hash_original_method = "88BB0202BF6BAEB771096BFB80D04435", hash_generated_method = "EFB33BA577C239CCA9926E0018AFE5A7")
    public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(outBitmap.getTaint());
        addTaint(canvas.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1761017420 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1761017420;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.644 -0400", hash_original_method = "ABF3FC9B35FB67DA4650457E79D2DAE8", hash_generated_method = "B1FAF3BEF87509889186D7CD9A91F683")
    public CharSequence onCreateDescription() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1984858603 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1984858603 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1984858603.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1984858603;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.645 -0400", hash_original_method = "24615BF0697D6E27C5190BAC65D711E7", hash_generated_method = "B96FF3EC182066563D7EFF3F55303022")
    protected void onStop() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mActionBar.setShowHideAnimationEnabled(false);
        getApplication().dispatchActivityStopped(this);
        mCalled = true;
        // ---------- Original Method ----------
        //if (mActionBar != null) mActionBar.setShowHideAnimationEnabled(false);
        //getApplication().dispatchActivityStopped(this);
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.647 -0400", hash_original_method = "4E5533F51E688B9D4BB620414B9C0889", hash_generated_method = "54885FD59F0C04348587A6952C51F396")
    protected void onDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        {
            final int numDialogs = mManagedDialogs.size();
            {
                int i = 0;
                {
                    final ManagedDialog md = mManagedDialogs.valueAt(i);
                    {
                        boolean var45C50B8B627C1BA4D235A3956BED22BE_1545950308 = (md.mDialog.isShowing());
                        {
                            md.mDialog.dismiss();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            mManagedDialogs = null;
        } //End block
        {
            int numCursors = mManagedCursors.size();
            {
                int i = 0;
                {
                    ManagedCursor c = mManagedCursors.get(i);
                    {
                        c.mCursor.close();
                    } //End block
                } //End block
            } //End collapsed parenthetic
            mManagedCursors.clear();
        } //End block
        {
            mSearchManager.stopSearch();
        } //End block
        getApplication().dispatchActivityDestroyed(this);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.648 -0400", hash_original_method = "30CE766C89D5A8D407C7E787A35027AF", hash_generated_method = "4D1FA5B9C502EA77AEB0068A6951F095")
    public void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        mFragments.dispatchConfigurationChanged(newConfig);
        {
            mWindow.onConfigurationChanged(newConfig);
        } //End block
        {
            mActionBar.onConfigurationChanged(newConfig);
        } //End block
        addTaint(newConfig.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.649 -0400", hash_original_method = "60C5D0D9DB2F726CCDEA80A841C2981A", hash_generated_method = "513CD76529F712D34B94D067D8195797")
    public int getChangingConfigurations() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_328452037 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_328452037;
        // ---------- Original Method ----------
        //return mConfigChangeFlags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.649 -0400", hash_original_method = "A4ED76D57E3C56C838C9F6AEF3843C6C", hash_generated_method = "EBCBEE219C98A0AA3850CB34D38E85B9")
    @Deprecated
    public Object getLastNonConfigurationInstance() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1607492735 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1607492735 = mLastNonConfigurationInstances != null
                ? mLastNonConfigurationInstances.activity : null;
        varB4EAC82CA7396A68D541C85D26508E83_1607492735.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1607492735;
        // ---------- Original Method ----------
        //return mLastNonConfigurationInstances != null
                //? mLastNonConfigurationInstances.activity : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.650 -0400", hash_original_method = "1AAF173FB42EFD7F047F27F49A93F1B0", hash_generated_method = "4937D66C19EF3B6B4E926D37DEF06C1D")
    public Object onRetainNonConfigurationInstance() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Object varB4EAC82CA7396A68D541C85D26508E83_169446526 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_169446526 = null;
        varB4EAC82CA7396A68D541C85D26508E83_169446526.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_169446526;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.652 -0400", hash_original_method = "891F87189588B9AE1E11F6F1107773C1", hash_generated_method = "DC7B8D2301BFFBD0C4B965E38A09517D")
     HashMap<String, Object> getLastNonConfigurationChildInstances() {
        HashMap<String, Object> varB4EAC82CA7396A68D541C85D26508E83_225640942 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_225640942 = mLastNonConfigurationInstances != null
                ? mLastNonConfigurationInstances.children : null;
        varB4EAC82CA7396A68D541C85D26508E83_225640942.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_225640942;
        // ---------- Original Method ----------
        //return mLastNonConfigurationInstances != null
                //? mLastNonConfigurationInstances.children : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.653 -0400", hash_original_method = "342B0C995620FF868A09DAF694D00C04", hash_generated_method = "387F4945759D3FFF4B8BC82777900AA7")
     HashMap<String,Object> onRetainNonConfigurationChildInstances() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        HashMap<String,Object> varB4EAC82CA7396A68D541C85D26508E83_278662133 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_278662133 = null;
        varB4EAC82CA7396A68D541C85D26508E83_278662133.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_278662133;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.656 -0400", hash_original_method = "927AC7E194A76481C5C9B757C08C225A", hash_generated_method = "D1AD9C059291D4E2C37DC7D8E1DFC9C3")
     NonConfigurationInstances retainNonConfigurationInstances() {
        NonConfigurationInstances varB4EAC82CA7396A68D541C85D26508E83_1686690819 = null; //Variable for return #1
        NonConfigurationInstances varB4EAC82CA7396A68D541C85D26508E83_1485497376 = null; //Variable for return #2
        Object activity = onRetainNonConfigurationInstance();
        HashMap<String, Object> children = onRetainNonConfigurationChildInstances();
        ArrayList<Fragment> fragments = mFragments.retainNonConfig();
        boolean retainLoaders = false;
        {
            {
                int i = mAllLoaderManagers.size()-1;
                {
                    LoaderManagerImpl lm = mAllLoaderManagers.valueAt(i);
                    {
                        retainLoaders = true;
                    } //End block
                    {
                        lm.doDestroy();
                        mAllLoaderManagers.removeAt(i);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1686690819 = null;
        } //End block
        NonConfigurationInstances nci = new NonConfigurationInstances();
        nci.activity = activity;
        nci.children = children;
        nci.fragments = fragments;
        nci.loaders = mAllLoaderManagers;
        varB4EAC82CA7396A68D541C85D26508E83_1485497376 = nci;
        NonConfigurationInstances varA7E53CE21691AB073D9660D615818899_1239660772; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1239660772 = varB4EAC82CA7396A68D541C85D26508E83_1686690819;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1239660772 = varB4EAC82CA7396A68D541C85D26508E83_1485497376;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1239660772.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1239660772;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.658 -0400", hash_original_method = "85EA10C9746E5BAE09F0BEB2EAF91433", hash_generated_method = "DF43C28571D148477AB74F4811D8645C")
    public void onLowMemory() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        mFragments.dispatchLowMemory();
        // ---------- Original Method ----------
        //mCalled = true;
        //mFragments.dispatchLowMemory();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.659 -0400", hash_original_method = "B7E71156F952E373C8BB026507E8D786", hash_generated_method = "D9508E7C57AFBD7E938E2947FFDAA6DC")
    public void onTrimMemory(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        mFragments.dispatchTrimMemory(level);
        addTaint(level);
        // ---------- Original Method ----------
        //mCalled = true;
        //mFragments.dispatchTrimMemory(level);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.660 -0400", hash_original_method = "C5EB33D6873EE026D87972F02E8EBD4B", hash_generated_method = "6B80D7DC013E9118FAECABE177B75EEE")
    public FragmentManager getFragmentManager() {
        FragmentManager varB4EAC82CA7396A68D541C85D26508E83_1592188508 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1592188508 = mFragments;
        varB4EAC82CA7396A68D541C85D26508E83_1592188508.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1592188508;
        // ---------- Original Method ----------
        //return mFragments;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.661 -0400", hash_original_method = "36D6A0BA7A439406C26069B6EB63A924", hash_generated_method = "818A6B2581499E0BB4D9320197DCF973")
     void invalidateFragmentIndex(int index) {
        {
            LoaderManagerImpl lm = mAllLoaderManagers.get(index);
            {
                lm.doDestroy();
                mAllLoaderManagers.remove(index);
            } //End block
        } //End block
        addTaint(index);
        // ---------- Original Method ----------
        //if (mAllLoaderManagers != null) {
            //LoaderManagerImpl lm = mAllLoaderManagers.get(index);
            //if (lm != null && !lm.mRetaining) {
                //lm.doDestroy();
                //mAllLoaderManagers.remove(index);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.662 -0400", hash_original_method = "28C2B4CF762BABC0F8C194FDD6A98E77", hash_generated_method = "7BA62512AFE4BD6BB2D807B17B09B3A6")
    public void onAttachFragment(Fragment fragment) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(fragment.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.663 -0400", hash_original_method = "BCF4BFC69850BAC01DAD91770055CA28", hash_generated_method = "B83BE3D8C22CEC32787AF5A9295D571F")
    @Deprecated
    public final Cursor managedQuery(Uri uri, String[] projection, String selection,
            String sortOrder) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_2019324458 = null; //Variable for return #1
        Cursor c = getContentResolver().query(uri, projection, selection, null, sortOrder);
        {
            startManagingCursor(c);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2019324458 = c;
        addTaint(uri.getTaint());
        addTaint(projection[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(sortOrder.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2019324458.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2019324458;
        // ---------- Original Method ----------
        //Cursor c = getContentResolver().query(uri, projection, selection, null, sortOrder);
        //if (c != null) {
            //startManagingCursor(c);
        //}
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.665 -0400", hash_original_method = "957642E226FD04681CA818B5E27D8161", hash_generated_method = "C88FD93A1C8E8230126FF98370BA7169")
    @Deprecated
    public final Cursor managedQuery(Uri uri, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_2139822749 = null; //Variable for return #1
        Cursor c = getContentResolver().query(uri, projection, selection, selectionArgs, sortOrder);
        {
            startManagingCursor(c);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2139822749 = c;
        addTaint(uri.getTaint());
        addTaint(projection[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(sortOrder.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2139822749.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2139822749;
        // ---------- Original Method ----------
        //Cursor c = getContentResolver().query(uri, projection, selection, selectionArgs, sortOrder);
        //if (c != null) {
            //startManagingCursor(c);
        //}
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.666 -0400", hash_original_method = "A63FE9916C33F333B3D894D85FA64949", hash_generated_method = "348D5F320412D05C8B87C7C9F09A04AD")
    @Deprecated
    public void startManagingCursor(Cursor c) {
        {
            mManagedCursors.add(new ManagedCursor(c));
        } //End block
        addTaint(c.getTaint());
        // ---------- Original Method ----------
        //synchronized (mManagedCursors) {
            //mManagedCursors.add(new ManagedCursor(c));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.668 -0400", hash_original_method = "6A91264601243F53EF1A64547761DF34", hash_generated_method = "8F824332B7A3D73D7543C6ACEEF3D6D1")
    @Deprecated
    public void stopManagingCursor(Cursor c) {
        {
            final int N = mManagedCursors.size();
            {
                int i = 0;
                {
                    ManagedCursor mc = mManagedCursors.get(i);
                    {
                        mManagedCursors.remove(i);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(c.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.668 -0400", hash_original_method = "14D9F664592BF6CD2790F336C855BE58", hash_generated_method = "C1728DB8A9348DEE6C39624FD13930AC")
    @Deprecated
    public void setPersistent(boolean isPersistent) {
        addTaint(isPersistent);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.669 -0400", hash_original_method = "6A267AF8CD8DFD046F9AA4A840E0F1F1", hash_generated_method = "1864FDB0AA189F4850C0160C30ED0559")
    public View findViewById(int id) {
        View varB4EAC82CA7396A68D541C85D26508E83_2114208266 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2114208266 = getWindow().findViewById(id);
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_2114208266.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2114208266;
        // ---------- Original Method ----------
        //return getWindow().findViewById(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.671 -0400", hash_original_method = "EC6DC7C8BFDE6FF47CE21F97E3274EE5", hash_generated_method = "46D45EF989C4BA271B52F2DF7F12CCB1")
    public ActionBar getActionBar() {
        ActionBar varB4EAC82CA7396A68D541C85D26508E83_361347295 = null; //Variable for return #1
        initActionBar();
        varB4EAC82CA7396A68D541C85D26508E83_361347295 = mActionBar;
        varB4EAC82CA7396A68D541C85D26508E83_361347295.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_361347295;
        // ---------- Original Method ----------
        //initActionBar();
        //return mActionBar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.672 -0400", hash_original_method = "1F37525CA4259BFCC1AC98918D267A3B", hash_generated_method = "0730F481354F60CD5396C7E4DF254632")
    private void initActionBar() {
        Window window = getWindow();
        window.getDecorView();
        {
            boolean varDD4E522E8814A0C229F7C100E74BEA95_368055558 = (isChild() || !window.hasFeature(Window.FEATURE_ACTION_BAR) || mActionBar != null);
        } //End collapsed parenthetic
        mActionBar = new ActionBarImpl(this);
        // ---------- Original Method ----------
        //Window window = getWindow();
        //window.getDecorView();
        //if (isChild() || !window.hasFeature(Window.FEATURE_ACTION_BAR) || mActionBar != null) {
            //return;
        //}
        //mActionBar = new ActionBarImpl(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.673 -0400", hash_original_method = "FC4CFA409E0DBC3CD2C86D908686341E", hash_generated_method = "99531264B62A1567E246A8B28A73A994")
    public void setContentView(int layoutResID) {
        getWindow().setContentView(layoutResID);
        initActionBar();
        addTaint(layoutResID);
        // ---------- Original Method ----------
        //getWindow().setContentView(layoutResID);
        //initActionBar();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.673 -0400", hash_original_method = "6143DA20A0E63D3DD26D6D6CC3A0350F", hash_generated_method = "61FF09B5B4538CBB3A1FC06BBD5BABCD")
    public void setContentView(View view) {
        getWindow().setContentView(view);
        initActionBar();
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //getWindow().setContentView(view);
        //initActionBar();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.674 -0400", hash_original_method = "FCB0E6F09A4D449F841F63B35D6A2C9A", hash_generated_method = "05A7DC4935A58527735DFAD3186107BA")
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        getWindow().setContentView(view, params);
        initActionBar();
        addTaint(view.getTaint());
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //getWindow().setContentView(view, params);
        //initActionBar();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.676 -0400", hash_original_method = "FC447FA34EAD1A15520CE5D8778BF36F", hash_generated_method = "10F6146D011E16DA07D2783A6955D172")
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        getWindow().addContentView(view, params);
        initActionBar();
        addTaint(view.getTaint());
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //getWindow().addContentView(view, params);
        //initActionBar();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.677 -0400", hash_original_method = "729048B37138D48F6A74BC6AFCECACEE", hash_generated_method = "0F9F517E80ECC2FDFAFC4F2FD7F8AC05")
    public void setFinishOnTouchOutside(boolean finish) {
        mWindow.setCloseOnTouchOutside(finish);
        addTaint(finish);
        // ---------- Original Method ----------
        //mWindow.setCloseOnTouchOutside(finish);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.678 -0400", hash_original_method = "84B2B4D9720193C8DC3107EE4335392B", hash_generated_method = "F8702E5326475477D335C1152AA7CA98")
    public final void setDefaultKeyMode(int mode) {
        mDefaultKeyMode = mode;
        //Begin case DEFAULT_KEYS_DISABLE DEFAULT_KEYS_SHORTCUT 
        mDefaultKeySsb = null;
        //End case DEFAULT_KEYS_DISABLE DEFAULT_KEYS_SHORTCUT 
        //Begin case DEFAULT_KEYS_DIALER DEFAULT_KEYS_SEARCH_LOCAL DEFAULT_KEYS_SEARCH_GLOBAL 
        mDefaultKeySsb = new SpannableStringBuilder();
        //End case DEFAULT_KEYS_DIALER DEFAULT_KEYS_SEARCH_LOCAL DEFAULT_KEYS_SEARCH_GLOBAL 
        //Begin case DEFAULT_KEYS_DIALER DEFAULT_KEYS_SEARCH_LOCAL DEFAULT_KEYS_SEARCH_GLOBAL 
        Selection.setSelection(mDefaultKeySsb,0);
        //End case DEFAULT_KEYS_DIALER DEFAULT_KEYS_SEARCH_LOCAL DEFAULT_KEYS_SEARCH_GLOBAL 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        //End case default 
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.680 -0400", hash_original_method = "447EA7C05CB03D3ADA1829E3AD87227A", hash_generated_method = "7EF275C10BA9F96B16ACBA74F11C62A0")
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            {
                boolean var6C8C397317C30451187B86B88E0B9C4B_1016678460 = (getApplicationInfo().targetSdkVersion
                    >= Build.VERSION_CODES.ECLAIR);
                {
                    event.startTracking();
                } //End block
                {
                    onBackPressed();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varBB73A2A4C4FF1B16BF9427D966A4A801_1092732769 = (getWindow().performPanelShortcut(Window.FEATURE_OPTIONS_PANEL, 
                    keyCode, event, Menu.FLAG_ALWAYS_PERFORM_CLOSE));
            } //End collapsed parenthetic
        } //End block
        {
            boolean clearSpannable = false;
            boolean handled;
            {
                boolean var083CEDCC9F1335B2AB0C1AAC01AAF679_1252046341 = ((event.getRepeatCount() != 0) || event.isSystem());
                {
                    clearSpannable = true;
                    handled = false;
                } //End block
                {
                    handled = TextKeyListener.getInstance().onKeyDown(
                        null, mDefaultKeySsb, keyCode, event);
                    {
                        boolean varEE1C0A7E7A940EF9FBEBBE171CEDD5A9_765994676 = (handled && mDefaultKeySsb.length() > 0);
                        {
                            final String str = mDefaultKeySsb.toString();
                            clearSpannable = true;
                            //Begin case DEFAULT_KEYS_DIALER 
                            Intent intent = new Intent(Intent.ACTION_DIAL,  Uri.parse("tel:" + str));
                            //End case DEFAULT_KEYS_DIALER 
                            //Begin case DEFAULT_KEYS_DIALER 
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            //End case DEFAULT_KEYS_DIALER 
                            //Begin case DEFAULT_KEYS_DIALER 
                            startActivity(intent);
                            //End case DEFAULT_KEYS_DIALER 
                            //Begin case DEFAULT_KEYS_SEARCH_LOCAL 
                            startSearch(str, false, null, false);
                            //End case DEFAULT_KEYS_SEARCH_LOCAL 
                            //Begin case DEFAULT_KEYS_SEARCH_GLOBAL 
                            startSearch(str, false, null, true);
                            //End case DEFAULT_KEYS_SEARCH_GLOBAL 
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                mDefaultKeySsb.clear();
                mDefaultKeySsb.clearSpans();
                Selection.setSelection(mDefaultKeySsb,0);
            } //End block
        } //End block
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1349549097 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1349549097;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.681 -0400", hash_original_method = "2A75FF2C44C4D96068DDAFC2643F0C8B", hash_generated_method = "58C6E056456A330A3C2B9AAAA27750D7")
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_490914951 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_490914951;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.682 -0400", hash_original_method = "25B851F5D41453D6013FB2C2AA511AE1", hash_generated_method = "7207EC46EE4AC4BD52E2B57BC9C9F794")
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varDD97E8990072EF9A9394C8CEA67054A7_419694612 = (getApplicationInfo().targetSdkVersion
                >= Build.VERSION_CODES.ECLAIR);
            {
                {
                    boolean var1C6DFE5F80166C4CE3FD88815AAAD598_1390315156 = (keyCode == KeyEvent.KEYCODE_BACK && event.isTracking()
                    && !event.isCanceled());
                    {
                        onBackPressed();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1898267491 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1898267491;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.682 -0400", hash_original_method = "E364C67ED15F0AA31C6DCFFA6137C8C0", hash_generated_method = "D0BF1D7F38071ED301D9BACE63141C7A")
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(keyCode);
        addTaint(repeatCount);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1325131640 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1325131640;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.683 -0400", hash_original_method = "6AE13C43A807A8F581EF7E482513BDAF", hash_generated_method = "DDF0D5E27BD62784CFFC4942FAEB9091")
    public void onBackPressed() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var5C240956F2A34791A06A0F4236D73061_899855631 = (!mFragments.popBackStackImmediate());
            {
                finish();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!mFragments.popBackStackImmediate()) {
            //finish();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.684 -0400", hash_original_method = "2ECF3E4914B4B3BE2238F799B7435A51", hash_generated_method = "0A9FA12DD5D45229BE322BAE6DB4F0C1")
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1238532170 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1238532170;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.685 -0400", hash_original_method = "587C23A975B49ED816BE95A55AB82601", hash_generated_method = "19CDDB80CDDE3F8ADBE57092F8248AF9")
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var5B881718D56E5E510CAAD751F448A0C9_616950346 = (mWindow.shouldCloseOnTouch(this, event));
            {
                finish();
            } //End block
        } //End collapsed parenthetic
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1079414723 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1079414723;
        // ---------- Original Method ----------
        //if (mWindow.shouldCloseOnTouch(this, event)) {
            //finish();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.686 -0400", hash_original_method = "4A983FDB3FF481E2165B7D8D641CDD48", hash_generated_method = "E6E784766C2C78561C3D9BC14947E78C")
    public boolean onTrackballEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_374821354 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_374821354;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.687 -0400", hash_original_method = "0E59A005881F30C798F764BCF32D89A3", hash_generated_method = "8EE29DC24EE268CD9D5608088D77EFD6")
    public boolean onGenericMotionEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_34914086 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_34914086;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.688 -0400", hash_original_method = "787C037504CBD45EADF1B222AFA073D0", hash_generated_method = "A806D85F6475EA9E3D8F95C8B0E85BF8")
    public void onUserInteraction() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.689 -0400", hash_original_method = "1D902756EB8B1D6D1B39ED873E4CD230", hash_generated_method = "3D4DF0EDD187E8826EB41E2E97C61F66")
    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            View decor = mDecor;
            {
                boolean var518FD95C1D322AE3CA22F3454EF80BC3_1678362093 = (decor != null && decor.getParent() != null);
                {
                    getWindowManager().updateViewLayout(decor, params);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //if (mParent == null) {
            //View decor = mDecor;
            //if (decor != null && decor.getParent() != null) {
                //getWindowManager().updateViewLayout(decor, params);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.690 -0400", hash_original_method = "32D7339793DCE0D5AEFE6621981EC978", hash_generated_method = "15CE33052F85E41C1BB65E1E6B2C108A")
    public void onContentChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.690 -0400", hash_original_method = "C7622FC561A602386C2112BC0445F7C6", hash_generated_method = "EEF2114A935228AD19BFEE6FAB48379F")
    public void onWindowFocusChanged(boolean hasFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(hasFocus);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.691 -0400", hash_original_method = "D6E949EE9F0768F47016EEA4FC0347A8", hash_generated_method = "0E08FFA9282E502085CC6973CB60CDA1")
    public void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.691 -0400", hash_original_method = "E592299EBB4DE1D6696EB8C4009A9EF4", hash_generated_method = "1328510831112E7A424EFCA8583CA87C")
    public void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.692 -0400", hash_original_method = "7F717562D5C1B102DE657A2EE434F557", hash_generated_method = "6BA0B3B9025D81171C52DE4B99CB2537")
    public boolean hasWindowFocus() {
        Window w = getWindow();
        {
            View d = w.getDecorView();
            {
                boolean varB73A262141F3E017F7CE2E1136F11BDF_1337430444 = (d.hasWindowFocus());
            } //End block
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1913189272 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1913189272;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.693 -0400", hash_original_method = "1A094AE61005DB4CDA2599E7F0A4A230", hash_generated_method = "DDBE43DC5CFF60572AA60EA6B0F8A9DA")
    public boolean dispatchKeyEvent(KeyEvent event) {
        onUserInteraction();
        Window win = getWindow();
        {
            boolean varB72D02E2D60D06CF890A5BAC6ED691A6_99045733 = (win.superDispatchKeyEvent(event));
        } //End collapsed parenthetic
        View decor = mDecor;
        decor = win.getDecorView();
        boolean var0F3BC286E711F8FE369DCCE6C96A1F39_841879858 = (event.dispatch(this, decor != null
                ? decor.getKeyDispatcherState() : null, this)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_139834693 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_139834693;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.694 -0400", hash_original_method = "1BC9E6494D7E888C2866773840EEFAF2", hash_generated_method = "C605175C479FA2A8835C7174409EEC0A")
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        onUserInteraction();
        {
            boolean var22B3DC591CCDF9027A8822387BB60CC1_1348021651 = (getWindow().superDispatchKeyShortcutEvent(event));
        } //End collapsed parenthetic
        boolean varB65319FC5255424F872A964CBDE1432E_307367938 = (onKeyShortcut(event.getKeyCode(), event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_203837322 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_203837322;
        // ---------- Original Method ----------
        //onUserInteraction();
        //if (getWindow().superDispatchKeyShortcutEvent(event)) {
            //return true;
        //}
        //return onKeyShortcut(event.getKeyCode(), event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.695 -0400", hash_original_method = "9C043C82D0E35283EE51DCEF499F92C6", hash_generated_method = "3D1A21226723E5AAF94267CA163CAD7A")
    public boolean dispatchTouchEvent(MotionEvent ev) {
        {
            boolean var89AADF399BE9B0E2DFA5C9BD5C451F2D_704122483 = (ev.getAction() == MotionEvent.ACTION_DOWN);
            {
                onUserInteraction();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var63BEDD669BE8863D86EB2C005414F90C_1358680043 = (getWindow().superDispatchTouchEvent(ev));
        } //End collapsed parenthetic
        boolean var985DA2294C2CD7796EE4EFA7F3FBE91B_498008501 = (onTouchEvent(ev));
        addTaint(ev.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_300151912 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_300151912;
        // ---------- Original Method ----------
        //if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            //onUserInteraction();
        //}
        //if (getWindow().superDispatchTouchEvent(ev)) {
            //return true;
        //}
        //return onTouchEvent(ev);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.696 -0400", hash_original_method = "B4E564288E5B587F0E42C599C68E6C62", hash_generated_method = "C2A4B28883C9623E4A3A82663D8ADDC4")
    public boolean dispatchTrackballEvent(MotionEvent ev) {
        onUserInteraction();
        {
            boolean var344CC3B3CF0390FD00C126501759FC6E_1437463742 = (getWindow().superDispatchTrackballEvent(ev));
        } //End collapsed parenthetic
        boolean varE24895B72E913D801FFC5B9D9055D482_360594433 = (onTrackballEvent(ev));
        addTaint(ev.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_440167956 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_440167956;
        // ---------- Original Method ----------
        //onUserInteraction();
        //if (getWindow().superDispatchTrackballEvent(ev)) {
            //return true;
        //}
        //return onTrackballEvent(ev);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.698 -0400", hash_original_method = "8A5C748F888ED0234B6228EEE9B28C6A", hash_generated_method = "C3F684391EE688A4522FC2A9E5724520")
    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        onUserInteraction();
        {
            boolean var0488FB753A1A4840338895882C17972B_368265611 = (getWindow().superDispatchGenericMotionEvent(ev));
        } //End collapsed parenthetic
        boolean var82ABE1E641E95D27D650D268E959F965_1939856896 = (onGenericMotionEvent(ev));
        addTaint(ev.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_12863476 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_12863476;
        // ---------- Original Method ----------
        //onUserInteraction();
        //if (getWindow().superDispatchGenericMotionEvent(ev)) {
            //return true;
        //}
        //return onGenericMotionEvent(ev);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.699 -0400", hash_original_method = "E0DA176D51FB90EA428361841719B862", hash_generated_method = "0CB1B38425EED8F27D9BF2DF7153BEAC")
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        event.setClassName(getClass().getName());
        event.setPackageName(getPackageName());
        LayoutParams params = getWindow().getAttributes();
        boolean isFullScreen = (params.width == LayoutParams.MATCH_PARENT) &&
            (params.height == LayoutParams.MATCH_PARENT);
        event.setFullScreen(isFullScreen);
        CharSequence title = getTitle();
        {
            boolean var4315037A3FEAFB24D399CA884BFC6923_364145293 = (!TextUtils.isEmpty(title));
            {
                event.getText().add(title);
            } //End block
        } //End collapsed parenthetic
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1639333762 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1639333762;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.700 -0400", hash_original_method = "8FB2859FE43E0606E21921E291A18BDA", hash_generated_method = "54D145B10C486CF2BD6821254ADFD193")
    public View onCreatePanelView(int featureId) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        View varB4EAC82CA7396A68D541C85D26508E83_1898670566 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1898670566 = null;
        addTaint(featureId);
        varB4EAC82CA7396A68D541C85D26508E83_1898670566.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1898670566;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.701 -0400", hash_original_method = "3CEBC68A0556AFB2BA0DA511B7D323DE", hash_generated_method = "6992F81A5EA4B7233DC7B66CD9488750")
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean show = onCreateOptionsMenu(menu);
            show |= mFragments.dispatchCreateOptionsMenu(menu, getMenuInflater());
        } //End block
        addTaint(featureId);
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1614512623 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1614512623;
        // ---------- Original Method ----------
        //if (featureId == Window.FEATURE_OPTIONS_PANEL) {
            //boolean show = onCreateOptionsMenu(menu);
            //show |= mFragments.dispatchCreateOptionsMenu(menu, getMenuInflater());
            //return show;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.702 -0400", hash_original_method = "A6A8332EF2663DFC6EB1A100F6AD5BEC", hash_generated_method = "277DFA537DD8615675312CFFB860DA25")
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean goforit = onPrepareOptionsMenu(menu);
            goforit |= mFragments.dispatchPrepareOptionsMenu(menu);
            boolean var7116118DD297E6C08BE1AD40992AA51A_630803043 = (goforit && menu.hasVisibleItems());
        } //End block
        addTaint(featureId);
        addTaint(view.getTaint());
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_600127049 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_600127049;
        // ---------- Original Method ----------
        //if (featureId == Window.FEATURE_OPTIONS_PANEL && menu != null) {
            //boolean goforit = onPrepareOptionsMenu(menu);
            //goforit |= mFragments.dispatchPrepareOptionsMenu(menu);
            //return goforit && menu.hasVisibleItems();
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.703 -0400", hash_original_method = "FE81CE57FF3B2984A6841999BDAFE276", hash_generated_method = "7FCB6BD8D1E4ABEBA0A4598321AAD6F1")
    public boolean onMenuOpened(int featureId, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            initActionBar();
            {
                mActionBar.dispatchMenuVisibilityChanged(true);
            } //End block
        } //End block
        addTaint(featureId);
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1315583745 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1315583745;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.704 -0400", hash_original_method = "06AE80A8039E39DC7E4DC1C38B6D66B0", hash_generated_method = "42ECBB4F116B01D38390CB335F2C26DD")
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        //Begin case Window.FEATURE_OPTIONS_PANEL 
        EventLog.writeEvent(50000, 0, item.getTitleCondensed());
        //End case Window.FEATURE_OPTIONS_PANEL 
        //Begin case Window.FEATURE_OPTIONS_PANEL 
        {
            boolean var3550B832F8A6DB96B87874C60FB2152D_1769744251 = (onOptionsItemSelected(item));
        } //End collapsed parenthetic
        //End case Window.FEATURE_OPTIONS_PANEL 
        //Begin case Window.FEATURE_OPTIONS_PANEL 
        boolean varE8A690D6428BE61C39A35A33EE497930_1129125512 = (mFragments.dispatchOptionsItemSelected(item));
        //End case Window.FEATURE_OPTIONS_PANEL 
        //Begin case Window.FEATURE_CONTEXT_MENU 
        EventLog.writeEvent(50000, 1, item.getTitleCondensed());
        //End case Window.FEATURE_CONTEXT_MENU 
        //Begin case Window.FEATURE_CONTEXT_MENU 
        {
            boolean varB8F885094F9CD83DEADF429F082FB201_60980876 = (onContextItemSelected(item));
        } //End collapsed parenthetic
        //End case Window.FEATURE_CONTEXT_MENU 
        //Begin case Window.FEATURE_CONTEXT_MENU 
        boolean var06F6B009CCB26CDE69B7F5C36D0D4DFE_959667751 = (mFragments.dispatchContextItemSelected(item));
        //End case Window.FEATURE_CONTEXT_MENU 
        addTaint(featureId);
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2059248572 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2059248572;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.705 -0400", hash_original_method = "89E795D5B25B105016E6897E97159EA1", hash_generated_method = "5CED3190A2B807A6AE080FFB5E3665E1")
    public void onPanelClosed(int featureId, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        //Begin case Window.FEATURE_OPTIONS_PANEL 
        mFragments.dispatchOptionsMenuClosed(menu);
        //End case Window.FEATURE_OPTIONS_PANEL 
        //Begin case Window.FEATURE_OPTIONS_PANEL 
        onOptionsMenuClosed(menu);
        //End case Window.FEATURE_OPTIONS_PANEL 
        //Begin case Window.FEATURE_CONTEXT_MENU 
        onContextMenuClosed(menu);
        //End case Window.FEATURE_CONTEXT_MENU 
        //Begin case Window.FEATURE_ACTION_BAR 
        initActionBar();
        //End case Window.FEATURE_ACTION_BAR 
        //Begin case Window.FEATURE_ACTION_BAR 
        mActionBar.dispatchMenuVisibilityChanged(false);
        //End case Window.FEATURE_ACTION_BAR 
        addTaint(featureId);
        addTaint(menu.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.705 -0400", hash_original_method = "319389EBA801B290FB41D02473EB2E9E", hash_generated_method = "E3CB03CA5E4EB5916215E567B4276E95")
    public void invalidateOptionsMenu() {
        mWindow.invalidatePanelMenu(Window.FEATURE_OPTIONS_PANEL);
        // ---------- Original Method ----------
        //mWindow.invalidatePanelMenu(Window.FEATURE_OPTIONS_PANEL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.707 -0400", hash_original_method = "D798A5E9CBD6E094B476E3BCFB506C48", hash_generated_method = "12DB5FADFF1CBD4208C23260BC55F256")
    public boolean onCreateOptionsMenu(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varF935B90ABE5131DCB630E9E27DC64FE3_1828245057 = (mParent.onCreateOptionsMenu(menu));
        } //End block
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1446850991 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1446850991;
        // ---------- Original Method ----------
        //if (mParent != null) {
            //return mParent.onCreateOptionsMenu(menu);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.708 -0400", hash_original_method = "E91DC6A73B73F0C36C3453FFD6D52B27", hash_generated_method = "8D70495828950AEBA1F1F4E5785B76A2")
    public boolean onPrepareOptionsMenu(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varAAB92CF1F1A4A0A344E7476B2B22B35C_1341354472 = (mParent.onPrepareOptionsMenu(menu));
        } //End block
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_867906929 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_867906929;
        // ---------- Original Method ----------
        //if (mParent != null) {
            //return mParent.onPrepareOptionsMenu(menu);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.710 -0400", hash_original_method = "3F90928280ED0097B9620B898E691C1D", hash_generated_method = "8AA32005B8E6772F12054FB0B0D8B472")
    public boolean onOptionsItemSelected(MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var47DFB44A8390EC1DC29AA40E602F6D38_157324058 = (mParent.onOptionsItemSelected(item));
        } //End block
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1598468695 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1598468695;
        // ---------- Original Method ----------
        //if (mParent != null) {
            //return mParent.onOptionsItemSelected(item);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.710 -0400", hash_original_method = "F56CDE64C3E3D8A72B60F2808B2AA992", hash_generated_method = "F5AFA2FA4E4D9523C3E90F7709D7E7A5")
    public void onOptionsMenuClosed(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mParent.onOptionsMenuClosed(menu);
        } //End block
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
        //if (mParent != null) {
            //mParent.onOptionsMenuClosed(menu);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.711 -0400", hash_original_method = "756759165F6AB2C8C6E469E63BE14186", hash_generated_method = "8F36C449192E9A4FC8F578B78BE7C244")
    public void openOptionsMenu() {
        mWindow.openPanel(Window.FEATURE_OPTIONS_PANEL, null);
        // ---------- Original Method ----------
        //mWindow.openPanel(Window.FEATURE_OPTIONS_PANEL, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.712 -0400", hash_original_method = "D12ED1735BBB9BCDCD831C99F03640D7", hash_generated_method = "249BD0BDCB652EF31D4B735086D0BDEC")
    public void closeOptionsMenu() {
        mWindow.closePanel(Window.FEATURE_OPTIONS_PANEL);
        // ---------- Original Method ----------
        //mWindow.closePanel(Window.FEATURE_OPTIONS_PANEL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.712 -0400", hash_original_method = "85F2A519B2781A30F4BC68DB47459C98", hash_generated_method = "170D9A5A5BFA1A654CA19943D4D0F496")
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        addTaint(v.getTaint());
        addTaint(menuInfo.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.713 -0400", hash_original_method = "1A123249F7C2C892EA53E2F44D60C1FB", hash_generated_method = "0FEECD9EF1102B65D35844FDFD151864")
    public void registerForContextMenu(View view) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        view.setOnCreateContextMenuListener(this);
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //view.setOnCreateContextMenuListener(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.713 -0400", hash_original_method = "6A7E2B106BB1CEE7C3B668A773DE5A5B", hash_generated_method = "344591114B98358744F7FCF1C426D7AD")
    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //view.setOnCreateContextMenuListener(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.714 -0400", hash_original_method = "D1451DBD5DFD14FAE397660897192E3C", hash_generated_method = "0E259D70C84DA1F0D8EA55F14095AA14")
    public void openContextMenu(View view) {
        view.showContextMenu();
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //view.showContextMenu();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.715 -0400", hash_original_method = "0F5BE8719D80390C88A4C0CDCF0E8C81", hash_generated_method = "A649B62C078D6DDA81669B8C50CB3152")
    public void closeContextMenu() {
        mWindow.closePanel(Window.FEATURE_CONTEXT_MENU);
        // ---------- Original Method ----------
        //mWindow.closePanel(Window.FEATURE_CONTEXT_MENU);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.716 -0400", hash_original_method = "BE982B537DFF57F9B4E6459A3621A4C0", hash_generated_method = "CD988075DCC267924F63498855FDD028")
    public boolean onContextItemSelected(MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var7ECF1B2F229D5634CCEBD2144EC86F5A_826766407 = (mParent.onContextItemSelected(item));
        } //End block
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1580500823 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1580500823;
        // ---------- Original Method ----------
        //if (mParent != null) {
            //return mParent.onContextItemSelected(item);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.717 -0400", hash_original_method = "3B89231032C2ACDB0A53B5E9B36C3177", hash_generated_method = "289A28B79761B391DA11B88EBEFC8A18")
    public void onContextMenuClosed(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mParent.onContextMenuClosed(menu);
        } //End block
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
        //if (mParent != null) {
            //mParent.onContextMenuClosed(menu);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.719 -0400", hash_original_method = "5C4ABBE5E4F27E10ACC00467798D80D8", hash_generated_method = "20335D8710FF0308CB9DA68CDAEA9927")
    @Deprecated
    protected Dialog onCreateDialog(int id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Dialog varB4EAC82CA7396A68D541C85D26508E83_90008569 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_90008569 = null;
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_90008569.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_90008569;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.720 -0400", hash_original_method = "34E3D2628A4C0BFC6C20A449A8141897", hash_generated_method = "A6E1C23EF3D6B7F29368CAE949ABCFFB")
    @Deprecated
    protected Dialog onCreateDialog(int id, Bundle args) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Dialog varB4EAC82CA7396A68D541C85D26508E83_2041173581 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2041173581 = onCreateDialog(id);
        addTaint(id);
        addTaint(args.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2041173581.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2041173581;
        // ---------- Original Method ----------
        //return onCreateDialog(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.721 -0400", hash_original_method = "7779942926F36CBECCFB305682D0E188", hash_generated_method = "5C8F94F2C9918C0B84A5BCEDC8DCAE6A")
    @Deprecated
    protected void onPrepareDialog(int id, Dialog dialog) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dialog.setOwnerActivity(this);
        addTaint(id);
        addTaint(dialog.getTaint());
        // ---------- Original Method ----------
        //dialog.setOwnerActivity(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.722 -0400", hash_original_method = "5C5331293ECB563ADEBB709047E6FA90", hash_generated_method = "9422F52F9A944A595ABA094DA7D27D51")
    @Deprecated
    protected void onPrepareDialog(int id, Dialog dialog, Bundle args) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        onPrepareDialog(id, dialog);
        addTaint(id);
        addTaint(dialog.getTaint());
        addTaint(args.getTaint());
        // ---------- Original Method ----------
        //onPrepareDialog(id, dialog);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.722 -0400", hash_original_method = "C69337B465910082B7749F46A60AEA22", hash_generated_method = "2EA32EF1E9332B890938D738539A8F4C")
    @Deprecated
    public final void showDialog(int id) {
        showDialog(id, null);
        addTaint(id);
        // ---------- Original Method ----------
        //showDialog(id, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.723 -0400", hash_original_method = "3DD1E3020EFCD44C0CA311C29E1CC42D", hash_generated_method = "EBC008639DFDDFE0BFFE29578E0DC880")
    @Deprecated
    public final boolean showDialog(int id, Bundle args) {
        {
            mManagedDialogs = new SparseArray<ManagedDialog>();
        } //End block
        ManagedDialog md = mManagedDialogs.get(id);
        {
            md = new ManagedDialog();
            md.mDialog = createDialog(id, null, args);
            mManagedDialogs.put(id, md);
        } //End block
        md.mArgs = args;
        onPrepareDialog(id, md.mDialog, args);
        md.mDialog.show();
        addTaint(id);
        addTaint(args.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_340291347 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_340291347;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.724 -0400", hash_original_method = "E601E473B0753C1FEDA76812E1FD9E58", hash_generated_method = "E6C76B6D441879165A1304B7AE7AD4D2")
    @Deprecated
    public final void dismissDialog(int id) {
        {
            if (DroidSafeAndroidRuntime.control) throw missingDialog(id);
        } //End block
        final ManagedDialog md = mManagedDialogs.get(id);
        {
            if (DroidSafeAndroidRuntime.control) throw missingDialog(id);
        } //End block
        md.mDialog.dismiss();
        addTaint(id);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.725 -0400", hash_original_method = "A39236F46CF5FE1491F0C82DFDF249BB", hash_generated_method = "58AF5618B6D3E71D4D812B58B5B521DD")
    private IllegalArgumentException missingDialog(int id) {
        IllegalArgumentException varB4EAC82CA7396A68D541C85D26508E83_102936506 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_102936506 = new IllegalArgumentException("no dialog with id " + id + " was ever "
                + "shown via Activity#showDialog");
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_102936506.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_102936506;
        // ---------- Original Method ----------
        //return new IllegalArgumentException("no dialog with id " + id + " was ever "
                //+ "shown via Activity#showDialog");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.726 -0400", hash_original_method = "3D1D9959965F7A331D31AA1B43803DC2", hash_generated_method = "01BEDA3C8B71BD57A862EF27934C2B47")
    @Deprecated
    public final void removeDialog(int id) {
        {
            final ManagedDialog md = mManagedDialogs.get(id);
            {
                md.mDialog.dismiss();
                mManagedDialogs.remove(id);
            } //End block
        } //End block
        addTaint(id);
        // ---------- Original Method ----------
        //if (mManagedDialogs != null) {
            //final ManagedDialog md = mManagedDialogs.get(id);
            //if (md != null) {
                //md.mDialog.dismiss();
                //mManagedDialogs.remove(id);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.727 -0400", hash_original_method = "0DF3BA4E928401133F2B75C6B5EB4631", hash_generated_method = "2A159725A638264B7D9F8D69B0DE4DB9")
    public boolean onSearchRequested() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        startSearch(null, false, null, false);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_118964253 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_118964253;
        // ---------- Original Method ----------
        //startSearch(null, false, null, false);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.728 -0400", hash_original_method = "E294F26A29AF2F9D8B2D38BC4A0138F5", hash_generated_method = "1C0121E8942AAFED9A6DD6719AAA0DBB")
    public void startSearch(String initialQuery, boolean selectInitialQuery, 
            Bundle appSearchData, boolean globalSearch) {
        ensureSearchManager();
        mSearchManager.startSearch(initialQuery, selectInitialQuery, getComponentName(),
                        appSearchData, globalSearch);
        addTaint(initialQuery.getTaint());
        addTaint(selectInitialQuery);
        addTaint(appSearchData.getTaint());
        addTaint(globalSearch);
        // ---------- Original Method ----------
        //ensureSearchManager();
        //mSearchManager.startSearch(initialQuery, selectInitialQuery, getComponentName(),
                        //appSearchData, globalSearch);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.730 -0400", hash_original_method = "A3EE90277ACB35FF640742FD629291A1", hash_generated_method = "1B35D2DF8EB410E5AED714A16AD3EF54")
    public void triggerSearch(String query, Bundle appSearchData) {
        ensureSearchManager();
        mSearchManager.triggerSearch(query, getComponentName(), appSearchData);
        addTaint(query.getTaint());
        addTaint(appSearchData.getTaint());
        // ---------- Original Method ----------
        //ensureSearchManager();
        //mSearchManager.triggerSearch(query, getComponentName(), appSearchData);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.731 -0400", hash_original_method = "0192041795732D663EE503A2AEC04112", hash_generated_method = "1C4EC0D223F9E3DCEC8DCF0D86A4D651")
    public void takeKeyEvents(boolean get) {
        getWindow().takeKeyEvents(get);
        addTaint(get);
        // ---------- Original Method ----------
        //getWindow().takeKeyEvents(get);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.732 -0400", hash_original_method = "3CDF417FCD4F33EAE6CFCF0FB6D583A8", hash_generated_method = "548E420A1CD1260E5B54B3B9B478E92F")
    public final boolean requestWindowFeature(int featureId) {
        boolean varB82514052F40771017139C27F50D7D45_791693992 = (getWindow().requestFeature(featureId));
        addTaint(featureId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1416741987 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1416741987;
        // ---------- Original Method ----------
        //return getWindow().requestFeature(featureId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.732 -0400", hash_original_method = "E7AFD534CB1DF8060614ED36111B2407", hash_generated_method = "1D84D45038FD5866F8926E34F140C5A2")
    public final void setFeatureDrawableResource(int featureId, int resId) {
        getWindow().setFeatureDrawableResource(featureId, resId);
        addTaint(featureId);
        addTaint(resId);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawableResource(featureId, resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.733 -0400", hash_original_method = "2E53659D6309BF8C5C8E8AD82BD6A577", hash_generated_method = "2B27B06D57220A2D7BDBB2E34E6E392C")
    public final void setFeatureDrawableUri(int featureId, Uri uri) {
        getWindow().setFeatureDrawableUri(featureId, uri);
        addTaint(featureId);
        addTaint(uri.getTaint());
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawableUri(featureId, uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.734 -0400", hash_original_method = "D3FA0A5870730A6F3C959B16FC004BCD", hash_generated_method = "F557D4B7A04B56974C87A9013515B72F")
    public final void setFeatureDrawable(int featureId, Drawable drawable) {
        getWindow().setFeatureDrawable(featureId, drawable);
        addTaint(featureId);
        addTaint(drawable.getTaint());
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawable(featureId, drawable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.734 -0400", hash_original_method = "4D2A81FF8C2C83F47460DEB3120C04CB", hash_generated_method = "04310BD6B9B4218E4C6AF4E9D6650F61")
    public final void setFeatureDrawableAlpha(int featureId, int alpha) {
        getWindow().setFeatureDrawableAlpha(featureId, alpha);
        addTaint(featureId);
        addTaint(alpha);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawableAlpha(featureId, alpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.735 -0400", hash_original_method = "2F200E491A9F2CDC38C392035D21ED48", hash_generated_method = "0B544E558976200421808503BD7FAAC5")
    public LayoutInflater getLayoutInflater() {
        LayoutInflater varB4EAC82CA7396A68D541C85D26508E83_1841796301 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1841796301 = getWindow().getLayoutInflater();
        varB4EAC82CA7396A68D541C85D26508E83_1841796301.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1841796301;
        // ---------- Original Method ----------
        //return getWindow().getLayoutInflater();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.737 -0400", hash_original_method = "E3707649B39EF110B7161F89DE89D715", hash_generated_method = "A9DAEDCC0DB61F909FA8DCBBC6329AAE")
    public MenuInflater getMenuInflater() {
        MenuInflater varB4EAC82CA7396A68D541C85D26508E83_1988462170 = null; //Variable for return #1
        {
            initActionBar();
            {
                mMenuInflater = new MenuInflater(mActionBar.getThemedContext());
            } //End block
            {
                mMenuInflater = new MenuInflater(this);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1988462170 = mMenuInflater;
        varB4EAC82CA7396A68D541C85D26508E83_1988462170.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1988462170;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.739 -0400", hash_original_method = "4857987668195170B5763D3AC5F48499", hash_generated_method = "6CDAB149CA785B821DB941A7AAB1BC80")
    @Override
    protected void onApplyThemeResource(Resources.Theme theme, int resid,
            boolean first) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            super.onApplyThemeResource(theme, resid, first);
        } //End block
        {
            try 
            {
                theme.setTo(mParent.getTheme());
            } //End block
            catch (Exception e)
            { }
            theme.applyStyle(resid, false);
        } //End block
        addTaint(theme.getTaint());
        addTaint(resid);
        addTaint(first);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.740 -0400", hash_original_method = "30D6BE1E6EC7F84FBEF609A16BE7CA4B", hash_generated_method = "B137FC071652C17D355793D1C802296C")
    public void startActivityForResult(Intent intent, int requestCode) {
        {
            Instrumentation.ActivityResult ar = mInstrumentation.execStartActivity(
                    this, mMainThread.getApplicationThread(), mToken, this,
                    intent, requestCode);
            {
                mMainThread.sendActivityResult(
                    mToken, mEmbeddedID, requestCode, ar.getResultCode(),
                    ar.getResultData());
            } //End block
            {
                mStartedActivity = true;
            } //End block
        } //End block
        {
            mParent.startActivityFromChild(this, intent, requestCode);
        } //End block
        addTaint(intent.getTaint());
        addTaint(requestCode);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.741 -0400", hash_original_method = "97600DFB6FE5B26D9938AA60DE8024CD", hash_generated_method = "FA10EF31903F88D2581DE195777EC527")
    public void startIntentSenderForResult(IntentSender intent, int requestCode,
            Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        {
            startIntentSenderForResultInner(intent, requestCode, fillInIntent,
                    flagsMask, flagsValues, this);
        } //End block
        {
            mParent.startIntentSenderFromChild(this, intent, requestCode,
                    fillInIntent, flagsMask, flagsValues, extraFlags);
        } //End block
        addTaint(intent.getTaint());
        addTaint(requestCode);
        addTaint(fillInIntent.getTaint());
        addTaint(flagsMask);
        addTaint(flagsValues);
        addTaint(extraFlags);
        // ---------- Original Method ----------
        //if (mParent == null) {
            //startIntentSenderForResultInner(intent, requestCode, fillInIntent,
                    //flagsMask, flagsValues, this);
        //} else {
            //mParent.startIntentSenderFromChild(this, intent, requestCode,
                    //fillInIntent, flagsMask, flagsValues, extraFlags);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.742 -0400", hash_original_method = "5FAE47F5C92447A2EE7F29A0B33663DC", hash_generated_method = "6076DC73DF003AE18ABB9D43185D5999")
    private void startIntentSenderForResultInner(IntentSender intent, int requestCode,
            Intent fillInIntent, int flagsMask, int flagsValues, Activity activity) throws IntentSender.SendIntentException {
        try 
        {
            String resolvedType = null;
            {
                fillInIntent.setAllowFds(false);
                resolvedType = fillInIntent.resolveTypeIfNeeded(getContentResolver());
            } //End block
            int result = ActivityManagerNative.getDefault()
                .startActivityIntentSender(mMainThread.getApplicationThread(), intent,
                        fillInIntent, resolvedType, mToken, activity.mEmbeddedID,
                        requestCode, flagsMask, flagsValues);
            {
                if (DroidSafeAndroidRuntime.control) throw new IntentSender.SendIntentException();
            } //End block
            Instrumentation.checkStartActivityResult(result, null);
        } //End block
        catch (RemoteException e)
        { }
        {
            mStartedActivity = true;
        } //End block
        addTaint(intent.getTaint());
        addTaint(requestCode);
        addTaint(fillInIntent.getTaint());
        addTaint(flagsMask);
        addTaint(flagsValues);
        addTaint(activity.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.743 -0400", hash_original_method = "496A47C2900A9596F27A50B4876A4F74", hash_generated_method = "7E32BC9F71CA50B44AEBBB0B32CF0606")
    @Override
    public void startActivity(Intent intent) {
        startActivityForResult(intent, -1);
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //startActivityForResult(intent, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.743 -0400", hash_original_method = "E2A55AFC4750254BD88786F18353EE8B", hash_generated_method = "7D07A5F51482F3088CADC2E5114E30E8")
    @Override
    public void startActivities(Intent[] intents) {
        mInstrumentation.execStartActivities(this, mMainThread.getApplicationThread(),
                mToken, this, intents);
        addTaint(intents[0].getTaint());
        // ---------- Original Method ----------
        //mInstrumentation.execStartActivities(this, mMainThread.getApplicationThread(),
                //mToken, this, intents);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.744 -0400", hash_original_method = "9F69F403C1C5722F41E10FF600B75C73", hash_generated_method = "53FC79B0A90985C80375B1F1564CCE14")
    public void startIntentSender(IntentSender intent,
            Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        startIntentSenderForResult(intent, -1, fillInIntent, flagsMask,
                flagsValues, extraFlags);
        addTaint(intent.getTaint());
        addTaint(fillInIntent.getTaint());
        addTaint(flagsMask);
        addTaint(flagsValues);
        addTaint(extraFlags);
        // ---------- Original Method ----------
        //startIntentSenderForResult(intent, -1, fillInIntent, flagsMask,
                //flagsValues, extraFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.745 -0400", hash_original_method = "190134DCA27346A23C03C3693BD2B9AA", hash_generated_method = "FEF7AB2718A479A765F7905B1944DF06")
    public boolean startActivityIfNeeded(Intent intent, int requestCode) {
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
            { }
            Instrumentation.checkStartActivityResult(result, intent);
            {
                mStartedActivity = true;
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
            "startActivityIfNeeded can only be called from a top-level activity");
        addTaint(intent.getTaint());
        addTaint(requestCode);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_483890731 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_483890731;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.746 -0400", hash_original_method = "BA57A0705EEE92F3B7079102E9F6CF18", hash_generated_method = "E86915256498B9979F0E7B227B9B4FB2")
    public boolean startNextMatchingActivity(Intent intent) {
        {
            try 
            {
                intent.setAllowFds(false);
                boolean var48E21F8A126EF0CF3E2826B5E3578F5C_1420547150 = (ActivityManagerNative.getDefault()
                    .startNextMatchingActivity(mToken, intent));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
            "startNextMatchingActivity can only be called from a top-level activity");
        addTaint(intent.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1274584732 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1274584732;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.746 -0400", hash_original_method = "DF04C3C173E07E956B29F2B3DAB7E481", hash_generated_method = "43291160E6EFA260EBAB369A49CF904D")
    public void startActivityFromChild(Activity child, Intent intent, 
            int requestCode) {
        Instrumentation.ActivityResult ar = mInstrumentation.execStartActivity(
                this, mMainThread.getApplicationThread(), mToken, child,
                intent, requestCode);
        {
            mMainThread.sendActivityResult(
                mToken, child.mEmbeddedID, requestCode,
                ar.getResultCode(), ar.getResultData());
        } //End block
        addTaint(child.getTaint());
        addTaint(intent.getTaint());
        addTaint(requestCode);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.747 -0400", hash_original_method = "5E733A6053D527FE1D06898E4868AC5B", hash_generated_method = "93A849EB613BABF66E8A458C106D7466")
    public void startActivityFromFragment(Fragment fragment, Intent intent, 
            int requestCode) {
        Instrumentation.ActivityResult ar = mInstrumentation.execStartActivity(
                this, mMainThread.getApplicationThread(), mToken, fragment,
                intent, requestCode);
        {
            mMainThread.sendActivityResult(
                mToken, fragment.mWho, requestCode,
                ar.getResultCode(), ar.getResultData());
        } //End block
        addTaint(fragment.getTaint());
        addTaint(intent.getTaint());
        addTaint(requestCode);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.749 -0400", hash_original_method = "39BD7073F28230B53A756B456127D77C", hash_generated_method = "03BC87FA40B57EECC467DABFFB2B357D")
    public void startIntentSenderFromChild(Activity child, IntentSender intent,
            int requestCode, Intent fillInIntent, int flagsMask, int flagsValues,
            int extraFlags) throws IntentSender.SendIntentException {
        startIntentSenderForResultInner(intent, requestCode, fillInIntent,
                flagsMask, flagsValues, child);
        addTaint(child.getTaint());
        addTaint(intent.getTaint());
        addTaint(requestCode);
        addTaint(fillInIntent.getTaint());
        addTaint(flagsMask);
        addTaint(flagsValues);
        addTaint(extraFlags);
        // ---------- Original Method ----------
        //startIntentSenderForResultInner(intent, requestCode, fillInIntent,
                //flagsMask, flagsValues, child);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.750 -0400", hash_original_method = "0CB07497B5E56C46E5A71AB5CB4CC143", hash_generated_method = "3C3AE556460FDD4910F9956EE91C22B0")
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        try 
        {
            ActivityManagerNative.getDefault().overridePendingTransition(
                    mToken, getPackageName(), enterAnim, exitAnim);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(enterAnim);
        addTaint(exitAnim);
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().overridePendingTransition(
                    //mToken, getPackageName(), enterAnim, exitAnim);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.751 -0400", hash_original_method = "A1F0E9D1C51A75D776561E1E894349B6", hash_generated_method = "CBA7E9A53147862BFCEA6CECBA6507F1")
    public final void setResult(int resultCode) {
        {
            mResultCode = resultCode;
            mResultData = null;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //mResultCode = resultCode;
            //mResultData = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.751 -0400", hash_original_method = "6BED503DFB65A20EFD511A0C71BBBEA5", hash_generated_method = "66418680AB3895336C309FFB7F7A89BA")
    public final void setResult(int resultCode, Intent data) {
        {
            mResultCode = resultCode;
            mResultData = data;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //mResultCode = resultCode;
            //mResultData = data;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.753 -0400", hash_original_method = "88476E01B039440C5805C3F210A00F20", hash_generated_method = "749ED1D7D07DC013E0F07455754F2D1F")
    public String getCallingPackage() {
        String varB4EAC82CA7396A68D541C85D26508E83_2098694164 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1920377365 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2098694164 = ActivityManagerNative.getDefault().getCallingPackage(mToken);
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1920377365 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_396971414; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_396971414 = varB4EAC82CA7396A68D541C85D26508E83_2098694164;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_396971414 = varB4EAC82CA7396A68D541C85D26508E83_1920377365;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_396971414.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_396971414;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getCallingPackage(mToken);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.754 -0400", hash_original_method = "BA5844B2C9F3C6D12393731B7AECDFB9", hash_generated_method = "35F7535C0E20DDDAC267B927FE8CB9D2")
    public ComponentName getCallingActivity() {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_443210606 = null; //Variable for return #1
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1289652499 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_443210606 = ActivityManagerNative.getDefault().getCallingActivity(mToken);
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1289652499 = null;
        } //End block
        ComponentName varA7E53CE21691AB073D9660D615818899_704696373; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_704696373 = varB4EAC82CA7396A68D541C85D26508E83_443210606;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_704696373 = varB4EAC82CA7396A68D541C85D26508E83_1289652499;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_704696373.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_704696373;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getCallingActivity(mToken);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.755 -0400", hash_original_method = "0E2F74853BCADD728740841EA37367F9", hash_generated_method = "98C465A75DCF544E2D7649C493FC173F")
    public void setVisible(boolean visible) {
        {
            mVisibleFromClient = visible;
            {
                makeVisible();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.755 -0400", hash_original_method = "FB761D67DEFD95C853371C7404DC7410", hash_generated_method = "EEA8F12FE6C3FEDFE900A4C399226D4D")
     void makeVisible() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.756 -0400", hash_original_method = "43D5EE376AB6A31BE07F9DEA063A3A15", hash_generated_method = "1C1CD86412F03F0408132364FBE77A25")
    public boolean isFinishing() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_7499186 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_7499186;
        // ---------- Original Method ----------
        //return mFinished;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.757 -0400", hash_original_method = "FE2E80A11740332998069879BC688861", hash_generated_method = "DD38BFFF03E373BAB04C671679FBDD82")
    public boolean isChangingConfigurations() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1770471603 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1770471603;
        // ---------- Original Method ----------
        //return mChangingConfigurations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.758 -0400", hash_original_method = "3298831B26ECD21F1FDB51A320DC7BE6", hash_generated_method = "4207D72D3EF6CF68C5245DD1D4AFC4A6")
    public void recreate() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Can only be called on top-level activity");
        } //End block
        {
            boolean var61A058F6D0650572B0637A5D7A729D5C_357035747 = (Looper.myLooper() != mMainThread.getLooper());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Must be called from main thread");
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.759 -0400", hash_original_method = "996A5282391C6D355ADB156CA1D0ED89", hash_generated_method = "7289BBE8DFA270DA6E102973EB3DA268")
    public void finish() {
        {
            int resultCode;
            Intent resultData;
            {
                resultCode = mResultCode;
                resultData = mResultData;
            } //End block
            try 
            {
                {
                    resultData.setAllowFds(false);
                } //End block
                {
                    boolean var98DEA089FC32BBD5488A00FF4FF0CC1E_618748334 = (ActivityManagerNative.getDefault()
                    .finishActivity(mToken, resultCode, resultData));
                    {
                        mFinished = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (RemoteException e)
            { }
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.760 -0400", hash_original_method = "75F7E4E1E03EB9263BD8694C580B708B", hash_generated_method = "95D8EA88836F03895ACAE5F76BE9CDDC")
    public void finishFromChild(Activity child) {
        finish();
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //finish();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.761 -0400", hash_original_method = "5ADA8FCD727B0FDDA383F561FB00E0D6", hash_generated_method = "7E7C91CA52C29DBAB74C5FA347EF2F40")
    public void finishActivity(int requestCode) {
        {
            try 
            {
                ActivityManagerNative.getDefault()
                    .finishSubActivity(mToken, mEmbeddedID, requestCode);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        {
            mParent.finishActivityFromChild(this, requestCode);
        } //End block
        addTaint(requestCode);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.762 -0400", hash_original_method = "78F43A087FD65470CED68BD5979667B7", hash_generated_method = "A17C18FD8318DD04E820B34B2C2A868B")
    public void finishActivityFromChild(Activity child, int requestCode) {
        try 
        {
            ActivityManagerNative.getDefault()
                .finishSubActivity(mToken, child.mEmbeddedID, requestCode);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(child.getTaint());
        addTaint(requestCode);
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault()
                //.finishSubActivity(mToken, child.mEmbeddedID, requestCode);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.762 -0400", hash_original_method = "6D8F676326F7C192A2903AC6F4C36AC9", hash_generated_method = "FA2BB58664560B8B761B02F0C8FA09C1")
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(requestCode);
        addTaint(resultCode);
        addTaint(data.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.764 -0400", hash_original_method = "724A566EB4440BBE32F479663ADACFA1", hash_generated_method = "E5D116A5A06D9E976CB315D1559302BE")
    public PendingIntent createPendingResult(int requestCode, Intent data,
            int flags) {
        PendingIntent varB4EAC82CA7396A68D541C85D26508E83_1195054240 = null; //Variable for return #1
        PendingIntent varB4EAC82CA7396A68D541C85D26508E83_150612028 = null; //Variable for return #2
        String packageName = getPackageName();
        try 
        {
            data.setAllowFds(false);
            IIntentSender target = ActivityManagerNative.getDefault().getIntentSender(
                        IActivityManager.INTENT_SENDER_ACTIVITY_RESULT, packageName,
                        mParent == null ? mToken : mParent.mToken,
                        mEmbeddedID, requestCode, new Intent[] { data }, null, flags);//DSFIXME:  CODE0008: Nested ternary operator in expression
            varB4EAC82CA7396A68D541C85D26508E83_1195054240 = target != null ? new PendingIntent(target) : null;
        } //End block
        catch (RemoteException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_150612028 = null;
        addTaint(requestCode);
        addTaint(data.getTaint());
        addTaint(flags);
        PendingIntent varA7E53CE21691AB073D9660D615818899_1470612397; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1470612397 = varB4EAC82CA7396A68D541C85D26508E83_1195054240;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1470612397 = varB4EAC82CA7396A68D541C85D26508E83_150612028;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1470612397.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1470612397;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.765 -0400", hash_original_method = "AB602316CD63B19CFF08DCE67D0ABE67", hash_generated_method = "5CDD1FBB0154268F02D99F0D81B8C6FA")
    public void setRequestedOrientation(int requestedOrientation) {
        {
            try 
            {
                ActivityManagerNative.getDefault().setRequestedOrientation(
                        mToken, requestedOrientation);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        {
            mParent.setRequestedOrientation(requestedOrientation);
        } //End block
        addTaint(requestedOrientation);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.765 -0400", hash_original_method = "DB34404EF91E1F4006BE0A78903A055D", hash_generated_method = "4D67E3699A5700206F50BD2FD61A4588")
    public int getRequestedOrientation() {
        {
            try 
            {
                int varF73A2C1D42F32A8E880FEE19D43552B0_1939933370 = (ActivityManagerNative.getDefault()
                        .getRequestedOrientation(mToken));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        {
            int var6BA699CCE9FE9ECEB5C2EB944481D0CA_1742263861 = (mParent.getRequestedOrientation());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_33781738 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_33781738;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.766 -0400", hash_original_method = "617D78E91C885EF783A85ACE788D978C", hash_generated_method = "4815FB095EF1F5CB9950352DDB858278")
    public int getTaskId() {
        try 
        {
            int varB14910B437D45BFD02C50351FBFB3D89_148013018 = (ActivityManagerNative.getDefault()
                .getTaskForActivity(mToken, false));
        } //End block
        catch (RemoteException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_573260577 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_573260577;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault()
                //.getTaskForActivity(mToken, false);
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.767 -0400", hash_original_method = "6E45F873D7236EF61D26B672F842F45F", hash_generated_method = "730494AB62803050622D2FFCA488CEB4")
    public boolean isTaskRoot() {
        try 
        {
            boolean var4B80DC96910152E8758D098D1964B8FB_851924451 = (ActivityManagerNative.getDefault()
                .getTaskForActivity(mToken, true) >= 0);
        } //End block
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_583377055 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_583377055;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault()
                //.getTaskForActivity(mToken, true) >= 0;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.768 -0400", hash_original_method = "9A59EFD62BA4B2B1BB27D9BF60C81F37", hash_generated_method = "9B76ACD3514869B3811625F683516B37")
    public boolean moveTaskToBack(boolean nonRoot) {
        try 
        {
            boolean var098F37A659AB56219B499ADFB5DCEEF7_1903868300 = (ActivityManagerNative.getDefault().moveActivityTaskToBack(
                    mToken, nonRoot));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(nonRoot);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1236880912 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1236880912;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().moveActivityTaskToBack(
                    //mToken, nonRoot);
        //} catch (RemoteException e) {
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.770 -0400", hash_original_method = "551AAFB8F3EA920969607A2C223A3A3A", hash_generated_method = "EB213F0824AD263E4F69961D92DBE01A")
    public String getLocalClassName() {
        String varB4EAC82CA7396A68D541C85D26508E83_780053267 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_276322027 = null; //Variable for return #2
        final String pkg = getPackageName();
        final String cls = mComponent.getClassName();
        int packageLen = pkg.length();
        {
            boolean var0EAAC10B288339C1570AA8AB20356E7A_196625270 = (!cls.startsWith(pkg) || cls.length() <= packageLen
                || cls.charAt(packageLen) != '.');
            {
                varB4EAC82CA7396A68D541C85D26508E83_780053267 = cls;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_276322027 = cls.substring(packageLen+1);
        String varA7E53CE21691AB073D9660D615818899_588482461; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_588482461 = varB4EAC82CA7396A68D541C85D26508E83_780053267;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_588482461 = varB4EAC82CA7396A68D541C85D26508E83_276322027;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_588482461.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_588482461;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.772 -0400", hash_original_method = "6C1D36E28C0C97736EA4779A7FB1715C", hash_generated_method = "08D60F3A3965E609E8438BBF769C11E7")
    public ComponentName getComponentName() {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1575296692 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1575296692 = mComponent;
        varB4EAC82CA7396A68D541C85D26508E83_1575296692.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1575296692;
        // ---------- Original Method ----------
        //return mComponent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.773 -0400", hash_original_method = "8FF11253989B916424A8F19A417B9894", hash_generated_method = "4D926057A314A861F25F8723514083CB")
    public SharedPreferences getPreferences(int mode) {
        SharedPreferences varB4EAC82CA7396A68D541C85D26508E83_1804309614 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1804309614 = getSharedPreferences(getLocalClassName(), mode);
        addTaint(mode);
        varB4EAC82CA7396A68D541C85D26508E83_1804309614.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1804309614;
        // ---------- Original Method ----------
        //return getSharedPreferences(getLocalClassName(), mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.774 -0400", hash_original_method = "4647E231E061B70291C2AAA883C4D14E", hash_generated_method = "74AAF8A2D90559508EC965512345BF71")
    private void ensureSearchManager() {
        mSearchManager = new SearchManager(this, null);
        // ---------- Original Method ----------
        //if (mSearchManager != null) {
            //return;
        //}
        //mSearchManager = new SearchManager(this, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.775 -0400", hash_original_method = "C911C3513CF522AB406EF738AFCD068D", hash_generated_method = "FE9AFE04CA18ACADDE260BC2739A5B27")
    @Override
    public Object getSystemService(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1513543406 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1700428691 = null; //Variable for return #2
        Object varB4EAC82CA7396A68D541C85D26508E83_1327713122 = null; //Variable for return #3
        {
            boolean var147AC2BBBF3AEE182DB26FB40142700F_981599629 = (getBaseContext() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "System services not available to Activities before onCreate()");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var1CCF0F4FD95ED5B34F2142B4928344D1_1207829078 = (WINDOW_SERVICE.equals(name));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1513543406 = mWindowManager;
            } //End block
            {
                boolean var2768C019CA3E7B10A866FFEC217F769C_569418470 = (SEARCH_SERVICE.equals(name));
                {
                    ensureSearchManager();
                    varB4EAC82CA7396A68D541C85D26508E83_1700428691 = mSearchManager;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1327713122 = super.getSystemService(name);
        addTaint(name.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_245231212; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_245231212 = varB4EAC82CA7396A68D541C85D26508E83_1513543406;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_245231212 = varB4EAC82CA7396A68D541C85D26508E83_1700428691;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_245231212 = varB4EAC82CA7396A68D541C85D26508E83_1327713122;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_245231212.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_245231212;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.776 -0400", hash_original_method = "917DB493889E2A2E4400765775D2C5BF", hash_generated_method = "803D7E132DC6DFFEC761022DE8638786")
    public void setTitle(CharSequence title) {
        mTitle = title;
        onTitleChanged(title, mTitleColor);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.777 -0400", hash_original_method = "A39F8277E51A7F6BD4A471D6255FEBC5", hash_generated_method = "74E2CECC78E84CDA22FC324C82785781")
    public void setTitle(int titleId) {
        setTitle(getText(titleId));
        addTaint(titleId);
        // ---------- Original Method ----------
        //setTitle(getText(titleId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.778 -0400", hash_original_method = "FA24EF1A624DFEEBC72DEB2A718D69DE", hash_generated_method = "BC4A216472427DDD027996C04C5326DB")
    public void setTitleColor(int textColor) {
        mTitleColor = textColor;
        onTitleChanged(mTitle, textColor);
        // ---------- Original Method ----------
        //mTitleColor = textColor;
        //onTitleChanged(mTitle, textColor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.779 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "F6AD5DB961B4209660E13BCDBECDCF16")
    public final CharSequence getTitle() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_762502797 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_762502797 = mTitle;
        varB4EAC82CA7396A68D541C85D26508E83_762502797.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_762502797;
        // ---------- Original Method ----------
        //return mTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.781 -0400", hash_original_method = "96312D04BD6FB534546AC8090A725A72", hash_generated_method = "451A9D2293C0EFC79E416B6131296159")
    public final int getTitleColor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1787558357 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1787558357;
        // ---------- Original Method ----------
        //return mTitleColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.782 -0400", hash_original_method = "907C0E9079D015DC414B2AE462CAF06D", hash_generated_method = "7F54CFFB2C87D97FD35D979B3ED9E8A8")
    protected void onTitleChanged(CharSequence title, int color) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            final Window win = getWindow();
            {
                win.setTitle(title);
                {
                    win.setTitleColor(color);
                } //End block
            } //End block
        } //End block
        addTaint(title.getTaint());
        addTaint(color);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.782 -0400", hash_original_method = "7A7CC5A839395F1C996BC46DE28C9533", hash_generated_method = "47D28BBF002CF6FFA1CB46B0EBB355C9")
    protected void onChildTitleChanged(Activity childActivity, CharSequence title) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(childActivity.getTaint());
        addTaint(title.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.783 -0400", hash_original_method = "32B6571BC6889F247F99CDBE3AE16965", hash_generated_method = "C5A973EF9F1894795713A701D8A54420")
    public final void setProgressBarVisibility(boolean visible) {
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS, visible ? Window.PROGRESS_VISIBILITY_ON :
            Window.PROGRESS_VISIBILITY_OFF);
        addTaint(visible);
        // ---------- Original Method ----------
        //getWindow().setFeatureInt(Window.FEATURE_PROGRESS, visible ? Window.PROGRESS_VISIBILITY_ON :
            //Window.PROGRESS_VISIBILITY_OFF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.784 -0400", hash_original_method = "1DF5015282F18776361652D68AED30B4", hash_generated_method = "3EA7373D37F405FB95C46CF566ECA25A")
    public final void setProgressBarIndeterminateVisibility(boolean visible) {
        getWindow().setFeatureInt(Window.FEATURE_INDETERMINATE_PROGRESS,
                visible ? Window.PROGRESS_VISIBILITY_ON : Window.PROGRESS_VISIBILITY_OFF);
        addTaint(visible);
        // ---------- Original Method ----------
        //getWindow().setFeatureInt(Window.FEATURE_INDETERMINATE_PROGRESS,
                //visible ? Window.PROGRESS_VISIBILITY_ON : Window.PROGRESS_VISIBILITY_OFF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.784 -0400", hash_original_method = "2F28E974BBABA05D28D9AF73C25D13FA", hash_generated_method = "5E7C9F5DD29C9C9A48FCCFA6469CB37F")
    public final void setProgressBarIndeterminate(boolean indeterminate) {
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS,
                indeterminate ? Window.PROGRESS_INDETERMINATE_ON : Window.PROGRESS_INDETERMINATE_OFF);
        addTaint(indeterminate);
        // ---------- Original Method ----------
        //getWindow().setFeatureInt(Window.FEATURE_PROGRESS,
                //indeterminate ? Window.PROGRESS_INDETERMINATE_ON : Window.PROGRESS_INDETERMINATE_OFF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.785 -0400", hash_original_method = "55067894B88907AA64DBBC76309FF362", hash_generated_method = "859E0EDEA9F9F5AE9DDB25BA660309E7")
    public final void setProgress(int progress) {
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS, progress + Window.PROGRESS_START);
        addTaint(progress);
        // ---------- Original Method ----------
        //getWindow().setFeatureInt(Window.FEATURE_PROGRESS, progress + Window.PROGRESS_START);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.786 -0400", hash_original_method = "FF0EFB07F2D369BD624208547BA4F187", hash_generated_method = "C4E25A3829BBFD1BF97CF8A6EE368191")
    public final void setSecondaryProgress(int secondaryProgress) {
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS,
                secondaryProgress + Window.PROGRESS_SECONDARY_START);
        addTaint(secondaryProgress);
        // ---------- Original Method ----------
        //getWindow().setFeatureInt(Window.FEATURE_PROGRESS,
                //secondaryProgress + Window.PROGRESS_SECONDARY_START);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.786 -0400", hash_original_method = "70729F29EB37CCBEC739A5986214C32F", hash_generated_method = "2764BD226534A1A95BF3BECEF1136ABC")
    public final void setVolumeControlStream(int streamType) {
        getWindow().setVolumeControlStream(streamType);
        addTaint(streamType);
        // ---------- Original Method ----------
        //getWindow().setVolumeControlStream(streamType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.787 -0400", hash_original_method = "03A841DC7655848901B3CE2C14084AAE", hash_generated_method = "D87B9EA1F427D43860B16BD4035C1BB7")
    public final int getVolumeControlStream() {
        int var10019DD6073F3F6675C482019A78518D_1452578897 = (getWindow().getVolumeControlStream());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1349246329 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1349246329;
        // ---------- Original Method ----------
        //return getWindow().getVolumeControlStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.787 -0400", hash_original_method = "691B4E9428578C2267EA5A6538081943", hash_generated_method = "01D2B25168733DF7A818358ED0B03AD6")
    public final void runOnUiThread(Runnable action) {
        {
            boolean varD46220B6DBDB2780BC14591AF2433BD7_1934702381 = (Thread.currentThread() != mUiThread);
            {
                mHandler.post(action);
            } //End block
            {
                action.run();
            } //End block
        } //End collapsed parenthetic
        addTaint(action.getTaint());
        // ---------- Original Method ----------
        //if (Thread.currentThread() != mUiThread) {
            //mHandler.post(action);
        //} else {
            //action.run();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.789 -0400", hash_original_method = "C11741BEACAA4DD4B803A04296254194", hash_generated_method = "5C9323AC93E7C00DB5C4479E0B1F8E78")
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        View varB4EAC82CA7396A68D541C85D26508E83_1761166543 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1761166543 = null;
        addTaint(name.getTaint());
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1761166543.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1761166543;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.793 -0400", hash_original_method = "6AED635285422A876000505F10FFFED0", hash_generated_method = "A7FBA2F002FE7851E09B8E2F87E18786")
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        View varB4EAC82CA7396A68D541C85D26508E83_876105033 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_1762275858 = null; //Variable for return #2
        {
            boolean var0F10F717A8824D895C9119EA392D7F2A_847445281 = (!"fragment".equals(name));
            {
                varB4EAC82CA7396A68D541C85D26508E83_876105033 = onCreateView(name, context, attrs);
            } //End block
        } //End collapsed parenthetic
        String fname = attrs.getAttributeValue(null, "class");
        TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.Fragment);
        {
            fname = a.getString(com.android.internal.R.styleable.Fragment_name);
        } //End block
        int id = a.getResourceId(com.android.internal.R.styleable.Fragment_id, View.NO_ID);
        String tag = a.getString(com.android.internal.R.styleable.Fragment_tag);
        a.recycle();
        int containerId;
        containerId = parent.getId();
        containerId = 0;
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(attrs.getPositionDescription()
                    + ": Must specify unique android:id, android:tag, or have a parent with an id for " + fname);
        } //End block
        Fragment fragment;
        fragment = mFragments.findFragmentById(id);
        fragment = null;
        {
            fragment = mFragments.findFragmentByTag(tag);
        } //End block
        {
            fragment = mFragments.findFragmentById(containerId);
        } //End block
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
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(attrs.getPositionDescription()
                    + ": Duplicate id 0x" + Integer.toHexString(id)
                    + ", tag " + tag + ", or parent id 0x" + Integer.toHexString(containerId)
                    + " with another fragment for " + fname);
        } //End block
        {
            fragment.mInLayout = true;
            {
                fragment.onInflate(this, attrs, fragment.mSavedFragmentState);
            } //End block
            mFragments.moveToState(fragment);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment " + fname
                    + " did not create a view.");
        } //End block
        {
            fragment.mView.setId(id);
        } //End block
        {
            boolean var28AAFB4908746F4035C573FBEA5D04E5_1585686545 = (fragment.mView.getTag() == null);
            {
                fragment.mView.setTag(tag);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1762275858 = fragment.mView;
        addTaint(parent.getTaint());
        addTaint(name.getTaint());
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        View varA7E53CE21691AB073D9660D615818899_278522518; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_278522518 = varB4EAC82CA7396A68D541C85D26508E83_876105033;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_278522518 = varB4EAC82CA7396A68D541C85D26508E83_1762275858;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_278522518.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_278522518;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.795 -0400", hash_original_method = "A3B02D247D35A4A6189512589B728713", hash_generated_method = "B89B5ECA91B1E45978A8880B3BCC0D85")
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
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
        {
            writer.print(prefix);
            writer.print("Loader Manager ");
            writer.print(Integer.toHexString(System.identityHashCode(mLoaderManager)));
            writer.println(":");
            mLoaderManager.dump(prefix + "  ", fd, writer, args);
        } //End block
        mFragments.dump(prefix, fd, writer, args);
        addTaint(prefix.getTaint());
        addTaint(fd.getTaint());
        addTaint(writer.getTaint());
        addTaint(args[0].getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.796 -0400", hash_original_method = "F5F1BD517EE731E56F922C1A6872A499", hash_generated_method = "00722B4AAD2A8DE73AF3F81E3A589C28")
    public boolean isImmersive() {
        try 
        {
            boolean var8E24EC029BEB1ED19FFEAC6EBBA9556E_1603502506 = (ActivityManagerNative.getDefault().isImmersive(mToken));
        } //End block
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_298170992 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_298170992;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().isImmersive(mToken);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.796 -0400", hash_original_method = "9D8EB8E29C9BCD315046F1934B1FF39B", hash_generated_method = "F967F018A9C613C44B7AACBB5F12019D")
    public void setImmersive(boolean i) {
        try 
        {
            ActivityManagerNative.getDefault().setImmersive(mToken, i);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(i);
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().setImmersive(mToken, i);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.797 -0400", hash_original_method = "2C973E12746FE944D244FE9652432CFA", hash_generated_method = "AB5E85FF055AA25CFB9FAB086F36BA73")
    public ActionMode startActionMode(ActionMode.Callback callback) {
        ActionMode varB4EAC82CA7396A68D541C85D26508E83_471359721 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_471359721 = mWindow.getDecorView().startActionMode(callback);
        addTaint(callback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_471359721.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_471359721;
        // ---------- Original Method ----------
        //return mWindow.getDecorView().startActionMode(callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.799 -0400", hash_original_method = "371F08E85934452E39039D6D8CFF84EA", hash_generated_method = "CDB317594D4E16B7B31E332E1C2421B7")
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        ActionMode varB4EAC82CA7396A68D541C85D26508E83_1413369546 = null; //Variable for return #1
        ActionMode varB4EAC82CA7396A68D541C85D26508E83_1785065381 = null; //Variable for return #2
        initActionBar();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1413369546 = mActionBar.startActionMode(callback);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1785065381 = null;
        addTaint(callback.getTaint());
        ActionMode varA7E53CE21691AB073D9660D615818899_231038131; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_231038131 = varB4EAC82CA7396A68D541C85D26508E83_1413369546;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_231038131 = varB4EAC82CA7396A68D541C85D26508E83_1785065381;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_231038131.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_231038131;
        // ---------- Original Method ----------
        //initActionBar();
        //if (mActionBar != null) {
            //return mActionBar.startActionMode(callback);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.800 -0400", hash_original_method = "255BA88D048ED7CA66014BFC1FF334C0", hash_generated_method = "5C31F22675E6C5EC34FEE649E89B1DA7")
    public void onActionModeStarted(ActionMode mode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(mode.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.801 -0400", hash_original_method = "731D5E497065CC7A99050B1E6205CD2C", hash_generated_method = "8341400BB35382A7F4737BEFC40A4A06")
    public void onActionModeFinished(ActionMode mode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(mode.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.803 -0400", hash_original_method = "CB0EFE3ADA1587CB31B88C9EC51AC6CD", hash_generated_method = "51CAD08D31A322104F1A9E253F06E70C")
    final void setParent(Activity parent) {
        mParent = parent;
        // ---------- Original Method ----------
        //mParent = parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.803 -0400", hash_original_method = "F5D036702945AFC6D1167650D88CF89C", hash_generated_method = "0C47A382579D247541533956F3D67822")
    final void attach(Context context, ActivityThread aThread, Instrumentation instr, IBinder token,
            Application application, Intent intent, ActivityInfo info, CharSequence title, 
            Activity parent, String id, NonConfigurationInstances lastNonConfigurationInstances,
            Configuration config) {
        attach(context, aThread, instr, token, 0, application, intent, info, title, parent, id,
            lastNonConfigurationInstances, config);
        addTaint(context.getTaint());
        addTaint(aThread.getTaint());
        addTaint(instr.getTaint());
        addTaint(token.getTaint());
        addTaint(application.getTaint());
        addTaint(intent.getTaint());
        addTaint(info.getTaint());
        addTaint(title.getTaint());
        addTaint(parent.getTaint());
        addTaint(id.getTaint());
        addTaint(lastNonConfigurationInstances.getTaint());
        addTaint(config.getTaint());
        // ---------- Original Method ----------
        //attach(context, aThread, instr, token, 0, application, intent, info, title, parent, id,
            //lastNonConfigurationInstances, config);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.805 -0400", hash_original_method = "1337919A8B79C562A3EF2FA6EE3B4075", hash_generated_method = "3C7499855B2FB72A6DC51EFDAAC4B253")
    final void attach(Context context, ActivityThread aThread,
            Instrumentation instr, IBinder token, int ident,
            Application application, Intent intent, ActivityInfo info,
            CharSequence title, Activity parent, String id,
            NonConfigurationInstances lastNonConfigurationInstances,
            Configuration config) {
        attachBaseContext(context);
        mFragments.attachActivity(this);
        mWindow = PolicyManager.makeNewWindow(this);
        mWindow.setCallback(this);
        mWindow.getLayoutInflater().setPrivateFactory(this);
        {
            mWindow.setSoftInputMode(info.softInputMode);
        } //End block
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
        {
            mWindow.setContainer(mParent.getWindow());
        } //End block
        mWindowManager = mWindow.getWindowManager();
        mCurrentConfig = config;
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.806 -0400", hash_original_method = "032FECF5166BB774C48681F5A73546B5", hash_generated_method = "D8E75BF70870D26A890C2E5AE3F30165")
    final IBinder getActivityToken() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_84578719 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_84578719 = mParent != null ? mParent.getActivityToken() : mToken;
        varB4EAC82CA7396A68D541C85D26508E83_84578719.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_84578719;
        // ---------- Original Method ----------
        //return mParent != null ? mParent.getActivityToken() : mToken;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.807 -0400", hash_original_method = "DAB379B095765C858B51976FA2FCF6E4", hash_generated_method = "B5B8BA41346A89857C284FC24F96A375")
    final void performCreate(Bundle icicle) {
        onCreate(icicle);
        mVisibleFromClient = !mWindow.getWindowStyle().getBoolean(
                com.android.internal.R.styleable.Window_windowNoDisplay, false);
        mFragments.dispatchActivityCreated();
        addTaint(icicle.getTaint());
        // ---------- Original Method ----------
        //onCreate(icicle);
        //mVisibleFromClient = !mWindow.getWindowStyle().getBoolean(
                //com.android.internal.R.styleable.Window_windowNoDisplay, false);
        //mFragments.dispatchActivityCreated();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.808 -0400", hash_original_method = "82BCF6383A02A95A38B6B2EB9C1C7555", hash_generated_method = "18B788DF8F72C5E4762601B8233C0761")
    final void performStart() {
        mFragments.noteStateNotSaved();
        mCalled = false;
        mFragments.execPendingActions();
        mInstrumentation.callActivityOnStart(this);
        {
            if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException(
                "Activity " + mComponent.toShortString() +
                " did not call through to super.onStart()");
        } //End block
        mFragments.dispatchStart();
        {
            {
                int i = mAllLoaderManagers.size()-1;
                {
                    LoaderManagerImpl lm = mAllLoaderManagers.valueAt(i);
                    lm.finishRetain();
                    lm.doReportStart();
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.810 -0400", hash_original_method = "3EBAEF204822031FA104B5D3C8D08DD5", hash_generated_method = "C036E3ECEF32E3BCB416D64E0130F67C")
    final void performRestart() {
        mFragments.noteStateNotSaved();
        {
            mStopped = false;
            {
                WindowManagerImpl.getDefault().setStoppedState(mToken, false);
            } //End block
            {
                final int N = mManagedCursors.size();
                {
                    int i = 0;
                    {
                        ManagedCursor mc = mManagedCursors.get(i);
                        {
                            {
                                boolean var04A5C84C1C3F081B6B9C5407629BB7FE_1872344091 = (!mc.mCursor.requery());
                                {
                                    {
                                        boolean varF1BBC5758062A55B0A9400E3F4AF6947_468782964 = (getApplicationInfo().targetSdkVersion
                                    >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH);
                                        {
                                            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                                        "trying to requery an already closed cursor  "
                                        + mc.mCursor);
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                            mc.mReleased = false;
                            mc.mUpdated = false;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            mCalled = false;
            mInstrumentation.callActivityOnRestart(this);
            {
                if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException(
                    "Activity " + mComponent.toShortString() +
                    " did not call through to super.onRestart()");
            } //End block
            performStart();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.811 -0400", hash_original_method = "F35F1467F0B7E6EEBE9DD69D8D6AD358", hash_generated_method = "524EF6E5195B2CDE387F3EC9A59B137C")
    final void performResume() {
        performRestart();
        mFragments.execPendingActions();
        mLastNonConfigurationInstances = null;
        mCalled = false;
        mInstrumentation.callActivityOnResume(this);
        {
            if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException(
                "Activity " + mComponent.toShortString() +
                " did not call through to super.onResume()");
        } //End block
        mCalled = false;
        mFragments.dispatchResume();
        mFragments.execPendingActions();
        onPostResume();
        {
            if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException(
                "Activity " + mComponent.toShortString() +
                " did not call through to super.onPostResume()");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.812 -0400", hash_original_method = "F81A8DB24B00685E2B896EC5528AF34D", hash_generated_method = "5D1273CBF75B0ED6475B89A5191C4B2A")
    final void performPause() {
        mFragments.dispatchPause();
        mCalled = false;
        onPause();
        mResumed = false;
        {
            boolean varAE0213A865A9842D2D0B2E8D0A5C03B4_80614419 = (!mCalled && getApplicationInfo().targetSdkVersion
                >= android.os.Build.VERSION_CODES.GINGERBREAD);
            {
                if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException(
                    "Activity " + mComponent.toShortString() +
                    " did not call through to super.onPause()");
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.813 -0400", hash_original_method = "ABDB3944564BF35742E6297221FCB3EA", hash_generated_method = "31170BEEC73668AEDE9E7F6B4C817A47")
    final void performUserLeaving() {
        onUserInteraction();
        onUserLeaveHint();
        // ---------- Original Method ----------
        //onUserInteraction();
        //onUserLeaveHint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.814 -0400", hash_original_method = "1444D8CCB63DB563C5707F75C9D1FF30", hash_generated_method = "CCF01BC5662A02D382E0B96749C1D0B0")
    final void performStop() {
        {
            mLoadersStarted = false;
            {
                {
                    mLoaderManager.doStop();
                } //End block
                {
                    mLoaderManager.doRetain();
                } //End block
            } //End block
        } //End block
        {
            {
                mWindow.closeAllPanels();
            } //End block
            {
                WindowManagerImpl.getDefault().setStoppedState(mToken, true);
            } //End block
            mFragments.dispatchStop();
            mCalled = false;
            mInstrumentation.callActivityOnStop(this);
            {
                if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException(
                    "Activity " + mComponent.toShortString() +
                    " did not call through to super.onStop()");
            } //End block
            {
                final int N = mManagedCursors.size();
                {
                    int i = 0;
                    {
                        ManagedCursor mc = mManagedCursors.get(i);
                        {
                            mc.mCursor.deactivate();
                            mc.mReleased = true;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            mStopped = true;
        } //End block
        mResumed = false;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.815 -0400", hash_original_method = "1C8656F81B9FFA0D582D8F6098E0BE30", hash_generated_method = "4E1B7C77883127F7CF94D3870067FF51")
    final void performDestroy() {
        mWindow.destroy();
        mFragments.dispatchDestroy();
        onDestroy();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.816 -0400", hash_original_method = "58811A32FF0FF231CA3DA7AD72F98B09", hash_generated_method = "91F56D146D7E7374762EA3A74E94703C")
    public final boolean isResumed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1247289296 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1247289296;
        // ---------- Original Method ----------
        //return mResumed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.816 -0400", hash_original_method = "9EF1B69B76655E6A901B5D291A25C28E", hash_generated_method = "93930EA3CE14432F6ED8F1A73D44877E")
     void dispatchActivityResult(String who, int requestCode, 
        int resultCode, Intent data) {
        mFragments.noteStateNotSaved();
        {
            onActivityResult(requestCode, resultCode, data);
        } //End block
        {
            Fragment frag = mFragments.findFragmentByWho(who);
            {
                frag.onActivityResult(requestCode, resultCode, data);
            } //End block
        } //End block
        addTaint(who.getTaint());
        addTaint(requestCode);
        addTaint(resultCode);
        addTaint(data.getTaint());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.817 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "0C87BCBAF0D95855709E5BEE2BDBA46D")

        Dialog mDialog;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.817 -0400", hash_original_field = "E8543AD9E6F42B0AF96855D6D0BAB0A3", hash_generated_field = "7B435E447280D5DC4E48D52C3AACF101")

        Bundle mArgs;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.817 -0400", hash_original_method = "9DCA77B5D1234925DAEE8DA8399779D6", hash_generated_method = "9DCA77B5D1234925DAEE8DA8399779D6")
        public ManagedDialog ()
        {
            //Synthesized constructor
        }


    }


    
    static final class NonConfigurationInstances {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.817 -0400", hash_original_field = "69A256025F66E4CE5D15C9DD7225D357", hash_generated_field = "AE7D68ABA75D09946A953E289939C500")

        Object activity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.818 -0400", hash_original_field = "268184C12DF027F536154D099D497B31", hash_generated_field = "39C55DEAC9D9B669F0F104569866C7D7")

        HashMap<String, Object> children;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.818 -0400", hash_original_field = "AD7BA86BB6B55B3BB2BB5F974A84CECF", hash_generated_field = "CB2FDAC93F3729E9B59C5F21C93A6FFF")

        ArrayList<Fragment> fragments;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.818 -0400", hash_original_field = "2AB8B63748D15E45B6CE4A33D435F369", hash_generated_field = "D5FA06C5EF7E6F3388FB9592AB447362")

        SparseArray<LoaderManagerImpl> loaders;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.818 -0400", hash_original_method = "6ECBAFFBF9F9B3F6A966772230E87049", hash_generated_method = "6ECBAFFBF9F9B3F6A966772230E87049")
        public NonConfigurationInstances ()
        {
            //Synthesized constructor
        }


    }


    
    private static final class ManagedCursor {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.818 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "6E649D5858461199DBD67FE0A0D43789")

        private Cursor mCursor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.818 -0400", hash_original_field = "59BD2047126E05F523EC535BB598B674", hash_generated_field = "6C470EAC7065369BBFA5B5575968482A")

        private boolean mReleased;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.819 -0400", hash_original_field = "63EBA8D5D32C815A530E6A72B411BAD1", hash_generated_field = "823188B97D251C7D61AAB004C3DA6C8F")

        private boolean mUpdated;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.819 -0400", hash_original_method = "1B2A6EC67EE1273DC41D2716939B2D2A", hash_generated_method = "42977AB1E1BFB8F07C0C61D524D131AA")
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

    // orphaned legacy method
    @DSModeled(DSC.BAN)
    public void droidsafeOnDestroy() {
    	onDestroy();
    }
    
    // orphaned legacy method
    @DSModeled(DSC.BAN)
    public void droidsafeOnResume() {
    	//This method is called by droidsafe itself, and should NEVER be called by an app
    	onResume();
    }
    
    // orphaned legacy method
    @DSModeled(DSC.BAN) //called by dsruntime to perform the onCreate
    public final void performCreate(Bundle icicle, Context context){
    	this.attachBaseContext(context);
    	onCreate(icicle);
    	mVisibleFromClient = !mWindow.getWindowStyle().getBoolean(
    	com.android.internal.R.styleable.Window_windowNoDisplay, false);
    	mFragments.dispatchActivityCreated();
    	// Original method
    	/*
    	{
    	onCreate(icicle);
    	mVisibleFromClient = !mWindow.getWindowStyle().getBoolean(
    	com.android.internal.R.styleable.Window_windowNoDisplay, false);
    	mFragments.dispatchActivityCreated();
    	}
    	*/
    	//Return nothing
    }
    
    // orphaned legacy method
    @DSModeled(DSC.BAN)
    public void droidsafeOnStop() {
    	//This method is called by droidsafe itself, and should NEVER be called by an app
    	onStop();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.819 -0400", hash_original_field = "9C29F19CBB2417EFCC04569A35A2C147", hash_generated_field = "8CACF19DA21B737E3F7EB34688FF057C")

    private static final String TAG = "Activity";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.820 -0400", hash_original_field = "F82AA367945C18050D2033244725EAF5", hash_generated_field = "2241ED7572C2B89FA014BFB20EB1AF72")

    public static final int RESULT_CANCELED    = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.820 -0400", hash_original_field = "962F509BC72F354FB94AC40E73A4B7A4", hash_generated_field = "F91B70B7F6D5082BE48EF2C98C1E7358")

    public static final int RESULT_OK           = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.820 -0400", hash_original_field = "E43060F557E7C9ED788A22939DB0D79E", hash_generated_field = "5077A6A22B66E72C7578FB99A7F608D6")

    public static final int RESULT_FIRST_USER   = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.820 -0400", hash_original_field = "B65D15DDA07492A4A8DE08D820B3BC23", hash_generated_field = "935F741DC4E3364E9A53BE28D1817499")

    private static final String WINDOW_HIERARCHY_TAG = "android:viewHierarchyState";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.820 -0400", hash_original_field = "FB4A22E192730B645166187558A8A796", hash_generated_field = "925270CCB66F84A6CC5AD8E1A127DDF5")

    private static final String FRAGMENTS_TAG = "android:fragments";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.821 -0400", hash_original_field = "E5B3C7DC3F4E78258F87EF385D628C7C", hash_generated_field = "B84490F85315FC6A0344124DA2A9A7C1")

    private static final String SAVED_DIALOG_IDS_KEY = "android:savedDialogIds";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.821 -0400", hash_original_field = "CEFECAA57483EE3BEADD7413245EF60B", hash_generated_field = "F085B80E40EB97561C0DC9EEAA7EAFE2")

    private static final String SAVED_DIALOGS_TAG = "android:savedDialogs";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.821 -0400", hash_original_field = "BDEC88B1A06E3B4B8EAD965EA57EAD9F", hash_generated_field = "7A1510EAA3BBABE8CABC5BDBCC2B1DF1")

    private static final String SAVED_DIALOG_KEY_PREFIX = "android:dialog_";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.821 -0400", hash_original_field = "B5CEBA5CE662022E22C9CE3982D9DCE2", hash_generated_field = "7ED6DE9D8F1923634B10FAD193F62B6F")

    private static final String SAVED_DIALOG_ARGS_KEY_PREFIX = "android:dialog_args_";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.822 -0400", hash_original_field = "4066C9D5A8E645EE130BB72CD59497D1", hash_generated_field = "98D5104638F2DEE99210C785FE0E500F")

    protected static final int[] FOCUSED_STATE_SET = {com.android.internal.R.attr.state_focused};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.822 -0400", hash_original_field = "8CB380EC154CB62ED9B10D3B61A2D67C", hash_generated_field = "45127B126EE2B3619E2DE44F606F53C3")

    static public final int DEFAULT_KEYS_DISABLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.822 -0400", hash_original_field = "BEC0DDDE6C52F8C9CB44C35DDF3A2D50", hash_generated_field = "F05278144A2B935FA742242E4E3A61A2")

    static public final int DEFAULT_KEYS_DIALER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.822 -0400", hash_original_field = "B9A091052EFFE8B52D43580CA139320C", hash_generated_field = "B4C1B32500D4540AA59C81E1B33DAC14")

    static public final int DEFAULT_KEYS_SHORTCUT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.822 -0400", hash_original_field = "265CCE449D6408B73F80115B406B0F94", hash_generated_field = "7B0F2176FF8E3A9C8466EB909FF8E3C8")

    static public final int DEFAULT_KEYS_SEARCH_LOCAL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.823 -0400", hash_original_field = "414426DEE5BB2437FCFB3279CDC238E7", hash_generated_field = "0C973E25C195EE36EA7FD3DD74B22EB1")

    static public final int DEFAULT_KEYS_SEARCH_GLOBAL = 4;
}

